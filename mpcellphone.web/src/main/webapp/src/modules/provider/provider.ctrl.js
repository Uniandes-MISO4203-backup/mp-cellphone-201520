/* global authSvc, $location */

(function (ng) {
    var mod = ng.module('providerModule');

    mod.controller('providerCtrl', ['CrudCreator', '$scope', 'providerService', 'providerModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'provider', 'Provider');
            this.fetchRecords();
            if (authSvc.getCurrentUser())
            {
                var self = this;
                svc.getRoleSvc().then(function(data)
                {
                    switch (data.role) 
                    {
                        case "admin":
                            self.fetchRecords();
                            break;
                        case "provider":
                            //usar data.id
                            self.fetchRecords();
                            break;
                        default:
                            $location.path('/login');
                            break;
                    } 
                });
            }
            else
            {
                $location.path('/login');
            }        }]);

    mod.controller('productsCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'provider', 'Provider');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
