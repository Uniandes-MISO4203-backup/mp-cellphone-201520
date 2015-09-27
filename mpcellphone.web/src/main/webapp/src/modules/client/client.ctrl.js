(function (ng)
{
    var mod = ng.module('clientModule');
    mod.controller('clientCtrl', ['CrudCreator', '$scope', 'clientService', 'clientModel', '$location', 'authService', function (CrudCreator, $scope, svc, model, $location, authSvc)
    {
        CrudCreator.extendController(this, svc, $scope, model, 'client', 'Client');
        if (authSvc.getCurrentUser())
        {
            actual = authSvc;
            var self = this;
            svc.getRoleSvc().then(function(data)
            {
                switch (data.role) 
                {
                    case "admin":  //Para mostrar la vista de administrador...
                                   ocultaCampos("th");
                                   self.fetchRecords().then(function(){
                                       $scope.$watch(function(){
                                           ocultaCampos("td");
                                           //console.log("Ingresa");
                                       });
                                   });
                                   break;
                    case "client": 
                                    //debugger;
                                    self.fetchRecords().then(function(data)
                                    {
                                      //debugger;
                                       //tmp2 = data;
                                       //console.log(data);
                                       var idActual = authSvc.getCurrentUser().id;
                                       for(var i = 0; i < data.length; i++)
                                       {
                                           if(Number(data[i].id) === Number(idActual))
                                           {
                                               tmp2 = data[i];
                                               console.log(data[i].name, data[i].id);
                                           }
                                       }
                                       //debugger;
                                    });
                                    //debugger;
                                    break;
                    default: $location.path('/#/catalog'); 
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
    
    mod.controller('shoppingCartCtrl', ['CrudCreator', '$scope', 'cartItemModel', function (CrudCreator, $scope, model) {
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'shoppingCart', 'client');
            this.loadRefOptions();
        }]);
})(window.angular);
