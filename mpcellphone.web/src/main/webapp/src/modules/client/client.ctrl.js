/* global $location, authSvc */

(function (ng) {
    var mod = ng.module('clientModule');

    mod.controller('clientCtrl', ['CrudCreator', '$scope', 'clientService', 'clientModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'client', 'Client');
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
                        case "user":
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
            }
        }]);

    mod.controller('shoppingCartCtrl', ['CrudCreator', '$scope', 'cartItemModel', function (CrudCreator, $scope, model) {
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'shoppingCart', 'client');
            this.loadRefOptions();
        }]);
})(window.angular);
