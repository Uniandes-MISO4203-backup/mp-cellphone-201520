
(function (ng) {
    var mod = ng.module('clientModule');

    mod.controller('clientCtrl', ['CrudCreator', '$scope', 'clientService', 'clientModel', '$location', 'authService', function (CrudCreator, $scope, svc, model, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'client', 'Client');
            //this.fetchRecords();
            
            if (authSvc.getCurrentUser())
            {
                var self = this;
                idxx = authSvc;
                
                console.log(idxx)
                svc.getRoleSvc().then(function(data)
                {
                    switch (data.role) 
                    {
                        case "admin":
                            self.fetchRecords();
                            break;
                        case "client":
                            ss = self.fetchRecords();
                            self.fetchRecords();
                            break;
                        default:
                            $location.path('/#/catalog');
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
