(function (ng){
    var mod = ng.module('orderQueryModule');
    mod.controller('orderQueryCtrl', ['CrudCreator', '$scope', 'saleService', 'orderQueryModel', '$location', 'authService', function (CrudCreator, $scope, svc, model, $location, authSvc){
            CrudCreator.extendController(this, svc, $scope, model, 'orderQuery', 'OrderQuery');
            if (authSvc.getCurrentUser()){
                var self = this;
                var ocultaCampos = function (tipo)
                {
                    for (var i = 1; i <= model.fields.length; i++)
                    {
                        if (!model.fields[i - 1].visible)
                        {
                            $(tipo + ":nth-child(" + i + ")").css({"display": "none"});
                        }
                    }
                };
                svc.getRoleOQ().then(function (data){
                    switch (data.role){
                        //Para mostrar la vista de administrador...
                        case "admin":
                            model.fields("clientName").visible=true;
                            model.fields("providerName").visible=true;
                            ocultaCampos("th");
                            self.fetchRecords().then(function () {
                                $scope.$watch(function () {
                                    ocultaCampos("td");
                                });
                            });
                            break;
                        case "client":
                            model.fields("clientName").visible=false;
                            model.fields("providerName").visible=true;
                            ocultaCampos("th");
                            var listSaleByClient = function (record){
                                svc.getSaleByClient(record.clientId).then(function (client) {
                                    $scope.records = [];
                                    $scope.records.push(client);
                                });
                            };
                            this.saleByClientActions = [{
                                    name: 'saleByClient',
                                    displayName: 'Sale By Client',
                                    icon: 'list-alt',
                                    class: 'info',
                                    fn: function (record) {
                                        listSaleByClient(record);
                                    },
                                    show: function () {
                                        return true;
                                    }
                                }
                            ]
                            self.fetchRecords().then(function () {
                                $scope.$watch(function () {
                                    ocultaCampos("td");
                                });
                            });
                            break;
                        case "provider":
                            model.fields("clientName").visible=true;
                            model.fields("providerName").visible=false;
                            ocultaCampos("th");
                            var listSaleByProvider = function (record){
                                svc.getSaleByProvider(record.providerId).then(function (provider) {
                                    $scope.records = [];
                                    $scope.records.push(provider);
                                });
                            };
                            this.saleBProviderActions = [{
                                    name: 'saleByProvider',
                                    displayName: 'Sale By Provider',
                                    icon: 'list-alt',
                                    class: 'info',
                                    fn: function (record) {
                                        listSaleByProvider(record);
                                    },
                                    show: function () {
                                        return true;
                                    }
                                }
                            ]
                            self.fetchRecords().then(function () {
                                $scope.$watch(function () {
                                    ocultaCampos("td");
                                });
                            });
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
