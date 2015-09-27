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
                            ocultaCampos("th");
                            self.fetchRecords().then(function(){
                                $scope.$watch(function(){
                                    ocultaCampos("td");
                                    //console.log("Ingresa");
                                });
                            });
                            break;
                        case "provider":
                            self.fetchRecords().then(function(data)
                            {
                               var idActual = authSvc.getCurrentUser().id;
                               for(var i = 0; i < data.length; i++)
                               {
                                   if(Number(data[i].id) === Number(idActual))
                                   {
                                       self.editRecord(data[i]);
                                       break;
                                   }
                               }
                            });
                            break;
                        default:
                            $location.path('/#/catalogo');
                            break;
                    } 
                });
            }
            else
            {
                $location.path('/login');
            }
        var ocultaCampos = function(tipo)
        {
            for(var i = 1; i <= model.fields.length; i++)
            {
                if(!model.fields[i - 1].visible)
                {
                    $(tipo + ":nth-child("+i+")").css({"display" : "none"});
                }
            }
        };
        }]);

    mod.controller('productsCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'provider', 'Provider');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
