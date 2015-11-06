(function (ng) {
    var mod = ng.module('mainApp');
    mod.controller('orderQueryCtrl', ['CrudCreator', '$scope', 'saleService', 'orderQueryModel', '$location', 'authService', '$log',
        function (CrudCreator, $scope, svc, model, $location, authSvc, $log) {
            CrudCreator.extendController(this, svc, $scope, model, 'orderQuery', 'Order List');
            var user = authSvc.getCurrentUser();
            svc.getRoleOQ().then(function (data) {
                $scope.userRole = data.role;
            });
            var isDetail = $location.path();
            if (isDetail.indexOf('viewDetail') > -1) {
                var id = $location.search().id;
                svc.getProductsBySale(user.id, id).then(function (data) {
                    $scope.detailOrderList = data;
                });
            }
            if (user) {
                $log.log(user.id);
                svc.getSaleByClient(user.id).then(function (data) {
                    $scope.orderList = [];
                    for (var i = 0; i < data.length - 1; i++) {
                        var flag = false;
                        for (var j = 0; j < $scope.orderList.length; j++) {
                            if (data[i].orderId.id === $scope.orderList[j].orderId.id) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            $scope.orderList.push(data[i]);
                        }
                    }
                });
                svc.getSaleByProvider(user.id).then(function (data) {
                    $scope.orderList = [];
                    for (var i = 0; i < data.length - 1; i++) {
                        var flag = false;
                        for (var j = 0; j < $scope.orderList.length; j++) {
                            if (data[i].orderId.id === $scope.orderList[j].orderId.id) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            $scope.orderList.push(data[i]);
                        }
                    }
                });
                $scope.globalActions = {
                    viewDetail: {
                        displayName: 'Return',
                        icon: 'circle-arrow-left',
                        class: 'primary',
                        fn: function () {
                            $location.path('/orderLists');
                        },
                        show: function () {
                            return true;
                        }
                    }};
                $scope.recordActions = {
                    viewDetail: {
                        displayName: 'View Detail',
                        icon: 'list-alt',
                        class: 'primary',
                        fn: function (record) {
                            var id = String(record.orderId.id);
                            $location.path('/viewDetail').search('id', id);
                        },
                        show: function () {
                            return true;
                        }
                    }};
            }
            else {
                $location.path('/login');
            }
        }]).directive('starRating', starRating);
    
    function starRating() {
    return {
      restrict: 'EA',
      template:
        '<ul class="star-rating" ng-class="{readonly: readonly}">' +
        '  <li ng-repeat="star in stars" class="star" ng-class="{filled: star.filled}" ng-click="toggle($index)">' +
        '    <i class="fa fa-star"></i>' + // or &#9733
        '  </li>' +
        '</ul>',
      scope: {
        ratingValue: '=ngModel',
        max: '=?', // optional (default is 5)
        onRatingSelect: '&?',
        readonly: '=?'
      },
      link: function(scope, element, attributes) {
        if (scope.max == undefined) {
          scope.max = 5;
        }
        function updateStars() {
          scope.stars = [];
          for (var i = 0; i < scope.max; i++) {
            scope.stars.push({
              filled: i < scope.ratingValue
            });
          }
        };
        scope.toggle = function(index) {
          if (scope.readonly == undefined || scope.readonly === false){
            scope.ratingValue = index + 1;
            scope.onRatingSelect({
              rating: index + 1
            });
          }
        };
        scope.$watch('ratingValue', function(oldValue, newValue) {
          if (newValue) {
            updateStars();
          }
        });
      }
    };
  }
})(window.angular);