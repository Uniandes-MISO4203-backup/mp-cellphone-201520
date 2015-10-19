(function (ng) {
    var mod = ng.module('orderQueryModule');
    mod.controller('orderQueryCtrl', ['CrudCreator', '$scope', 'saleService', 'orderQueryModel', '$location', 'authService', '$log',
        function (CrudCreator, $scope, svc, model, $location, authSvc, $log) {
            CrudCreator.extendController(this, svc, $scope, model, 'orderQuery', 'Order List');
            var user = authSvc.getCurrentUser();
            svc.getRoleOQ().then(function (data) {
                $scope.userRole = data.role;
            });
            if (user) {
                $log.log(user.id);
                svc.getSaleByClient(user.id).then(function (data) {
                    $scope.orderList = data;
                });
                svc.getSaleByProvider(user.id).then(function (data) {
                    $scope.orderListProvider = data;
                });
                $scope.globalActions = {
                    viewDetail: {
                        displayName: 'Return',
                        icon: 'circle-arrow-left',
                        class: 'primary',
                        fn: function () {
                            $location.path('/orderList');
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
                            $location.path('/viewDetail');
                            svc.getProductsBySale(user.id, record.orderId.id).then(function (data) {
                                $scope.products = data;
                                $log.log($scope.products);
                            });
                        },
                        show: function () {
                            return true;
                        }
                    }};
            }
            else {
                $location.path('/login');
            }
        }]);
})(window.angular);
