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
                $scope.recordActions = {
                    viewDetail: {
                        displayName: 'View Detail',
                        icon: 'list-alt',
                        class: 'primary',
                        fn: function (record) {
                            $log.log(record);
                            $location.path('/viewDetail/'+user.id+'/'+record.orderId.id);
                            svc.getProductsBySale(user.id, record.orderId.id).then(function (data) {
                                $log.log(data);
                            });
                            $log.log(record);
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
