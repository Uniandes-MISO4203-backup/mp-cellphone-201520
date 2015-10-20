/* global authSvc, $location */

(function (ng) {
    var mod = ng.module('providerModule');

    mod.controller('providerCtrl', ['CrudCreator', '$scope', 'providerService', 'providerModel', '$location', 'authService', '$log', function (CrudCreator, $scope, svc, model, $location, authSvc, $log) {
            CrudCreator.extendController(this, svc, $scope, model, 'provider', 'Provider');
            if (authSvc.getCurrentUser()){
                var self = this;
                $log.log('Ingrese rol');
                svc.getRolePr().then(function(data){
                    $log.log(data.role);
                    switch (data.role){
                        case "admin":
                            ocultaCampos("th");
                            self.fetchRecords().then(function(){
                                $scope.$watch(function(){
                                    ocultaCampos("td");
                                });
                            });
                            break;
                        case "provider":
                            self.itemsPerPage = 100;
                            self.fetchRecords().then(function(data){
                               var idActual = authSvc.getCurrentUser().id;
                               for(var i = 0; i < data.length; i++){
                                   if(Number(data[i].id) === Number(idActual)){
                                       self.editRecord(data[i]);
                                       break;
                                   }
                               }
                            });
                            $("#save-provider").click(function(){
                                $("#notiShopping").html("Se han actulizado los datos satisfactoriamente").fadeIn("fast").delay(2000).fadeOut(300);
                                $location.path('/#/catalog');
                            });

                            $("#cancel-provider").click(function(){
                                $location.path('/#/catalog');
                            });
                            break;
                        default:
                            $location.path('/#/catalog');
                            break;
                    }
                });
            }
            else{
                $location.path('/#/catalog');
            }
        var ocultaCampos = function(tipo){
            for(var i = 1; i <= model.fields.length; i++){
                if(!model.fields[i - 1].visible){
                    $(tipo + ":nth-child("+i+")").css({"display" : "none"});
                }
            }
        };
        }]);

/*
    mod.controller('productsCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'provider', 'Provider');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
        */
})(window.angular);
