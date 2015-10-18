(function (ng) {
    var mod = ng.module('orderQueryModule');
    mod.controller('orderQueryCtrl', ['CrudCreator', '$scope', 'saleService', 'orderQueryModel', '$location', 'authService', '$log',
        function (CrudCreator, $scope, svc, model, $location, authSvc, $log) {
            CrudCreator.extendController(this, svc, $scope, model, 'orderQuery', 'Order List');
            var user = authSvc.getCurrentUser();
            svc.getRoleOQ().then(function(data){
                $scope.userRole=data.role;
            });
            if (user) {
                $log.log(user.id);
                svc.getSaleByClient(user.id).then(function(data){
                    $scope.orderList = data;
                    $log.log($scope.orderList);
                });                               
                $scope.recordActions = {
                    viewDetail: {
                        displayName: 'View Detail',
                        icon: 'list-alt',
                        class: 'primary',
                        fn: function (record) {
                            
                        },
                        show: function () {
                            return true;
                        }
                    }};

                svc.getRoleOQ().then(function (data) {
                    switch (data.role) {
                        case "client":
                            
                            break;
                        case "provider":
                            
                            break;
                        default:
                            $location.path('/#/catalog');
                            break;
                    }
                });
            }
            else {
                $location.path('/login');
            }
        }]);
    mod.controller('shoppingCartCtrl', ['CrudCreator', '$scope', 'cartItemModel', function (CrudCreator, $scope, model) {
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'shoppingCart', 'client');
            this.loadRefOptions();
        }]);
})(window.angular);
