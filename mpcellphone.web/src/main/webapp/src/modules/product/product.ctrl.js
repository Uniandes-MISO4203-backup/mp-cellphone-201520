//var tmp = 0;
(function (ng) {
    var mod = ng.module('productModule');
    var maximoCaracteres = 255;
    var ProducSelComment = 0; //Para guardar el item que se está haciendo el comentario..
    //Para guardar el dato al servicio de producto más barato...
    /*
    var cheapProduct = {
                            provider  : 0, 
                            product   : 0,
                            lowprice  : 0, 
                            highprice : 0
                        };
    */
 
    mod.controller('productCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', 'cartItemService', '$location', 'authService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'product', 'Products');
               /*
            $('#sl2').slider().on('slide', function(){
                buscarCheap();
            });
            */
           /*
            $('#sl2').slider().val("200000,2000000").on('slide', function(event){
                //buscarCheap();
                //$('#sl2').val('0').trigger('change');
                //$scope.priceItem = event;
               //$("#priceItem").val(event.value.join(",")); 
               console.log(event.value.join(","));
            });
            */
           //$('#sl2').val();
            
            this.searchByName = function (cellPhoneName) {
                var search;
                if (cellPhoneName) {
                    search = '?q=' + cellPhoneName;
                }
                $location.url('/catalog' + search);
            };
            
            $scope.priceItem = "";
            $scope.cheap = function(prov, price, record) 
            {
                price = price || 0;
                if(Number(record.provider.id) === Number(prov.Id) || prov.Id === 0)
                {
                    return prov.Id === 0 ? true : Number(record.price) <= Number(price) || Number(price) === 0 ? true : false;
                }
                else
                {
                    return false;
                }
            };
            
            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (record) {
                        $("#notiShopping").html("Se ha agregado " + record.cellPhone.name + ", a tu carrito de compras.").fadeIn("fast").delay(2000).fadeOut(300);
                        if (authSvc.getCurrentUser()) {
                            return cartItemSvc.addItem({
                                product: record,
                                name: record.cellPhone.name,
                                quantity: 1});
                        } else {
                            $location.path('/login');
                        }
                    },
                    show: function () {
                        return true;
                    }
                }];
            
            //Para los comentarios por producto...
            this.commentActions = [
            {
                    name: 'commet',
                    displayName: 'Comment',
                    icon: 'comment',
                    class: 'warning',
                    fn: function (record)
                    {
                        if (authSvc.getCurrentUser())
                        {
                            ProducSelComment = record;
                            $('#nameUser').html("<center><b>" + authSvc.getCurrentUser().name + " Dice:</b></center><br>");
                            $('#titleProduct').html("Cellphone: " + record.cellPhone.name);
                            $("#comment").val("");
                            $('#myModal').modal('show');
                            $("#cantidad").html("<center>" + maximoCaracteres + "</center>");
                        }
                        else
                        {
                            $location.path('/login');
                        }
                    },
                    show: function () {
                        return true;
                    }
             }];
            
            //Para las preguntas por producto...
            this.questionActions = [
            {
                    name: 'question',
                    displayName: 'Question',
                    icon: 'question-sign',
                    class: 'info',
                    fn: function (record)
                    {
                        tmp = authSvc;
                        if (authSvc.getCurrentUser())
                        {
                            ProducSelComment = record;
                            $('#modalQuestion').modal('show');
                            $('#nameUserQuestion').html("<center><b>" + authSvc.getCurrentUser().name + " Says:</b></center><br>");
                            $('#titleProductQuestion').html("Cellphone: " + record.cellPhone.name);
                            $("#question").val(""); 
                        }
                        else
                        {
                            $location.path('/login');
                        }
                    },
                    show: function () {
                        return true;
                    }
             }];
         
             //Para limitar el número de carácteres...
            this.keyActions  = [
            {   
                fn: function ()
                {
                   //event, $event.keyCode
                    var queda = maximoCaracteres - $("#comment").val().length;
                    if(queda < 0)
                    {
                        $("#comment").val($("#comment").val().substr(0, maximoCaracteres));
                        queda = 0;
                    }
                    $("#cantidad").html("<center>" + queda + "</center>");
                }
             }];
         
            //Para salvar el comentario...
            this.saveComment = [
            {   
                fn: function ()
                {
                    if (authSvc.getCurrentUser())
                    {
                        if($("#comment").val().length !== 0)
                        {
                            svc.saveComment({
                                                comment     : $("#comment").val(), 
                                                product_id  : ProducSelComment.id, 
                                                client_id   : authSvc.getCurrentUser().id, 
                                                date        : new Date().toISOString().substring(0, 10)
                                            }).then(function(){
                                                alert("Su comentario ha sido enviado satisfactoriamente");  
                                                $('#myModal').modal('hide');
                                            });
                        }
                        else
                        {
                            alert("Por favor escribe tu comentario");
                        }
                    }
                    else
                    {
                        $location.path('/login');
                    }
                }
             }];
         
            this.saveQuestion = [
            {   
                fn: function ()
                {
                    if (authSvc.getCurrentUser())
                    {
                        if($("#question").val().length !== 0)
                        {
                            var objEnvia = {
                                question : $("#question").val(), 
                                product  : ProducSelComment.cellPhone,
                                client   : authSvc.getCurrentUser(),
                                provider : ProducSelComment.provider

                            };
                            console.log(objEnvia);
                            svc.saveQuestion(objEnvia).then(function()
                            {
                                alert("La pregunta ha sido enviada satisfactoriamente");
                                $('#modalQuestion').modal('hide');
                            });
                        }
                        else
                        {
                            alert("Por favor escribe tu pregunta");
                        }
                    }
                    else
                    {
                        $location.path('/login');
                    }
                }
             }];
         
         //Para encontrar el Proveedor con el menor precio para un producto
        this.cheapestActions = [ 
               {
                    name: 'BestProvider',
                    displayName: 'Best Provider',
                    icon: 'search',
                    class: 'warning',
                    fn: function (record) {
                            return findItem(record);
                            console.log(record);
                    },
                    show: function () {
                        return true;
                    }
              }
            ]
        
        var findItem = function(record)
            {
               svc.findItem(record.cellPhone.id).then(function(cellPhone){
                   $scope.records = [];
                   $scope.records.push(cellPhone);
                   console.log(cellPhone);
               });
            };
        //Para encontrar el menor precio de un Proveedor
        this.cheapestProvActions = [ 
               {
                    name: 'BestPrice',
                    displayName: 'Best Price',
                    icon: 'search',
                    class: 'warning',
                    fn: function (record) {
                            findItemProv(record);
                            console.log(record);
                    },
                    show: function () {
                        return true;
                    }
              }
            ]
        
        var findItemProv = function(record)
            {
                /*svc.findItem(record.cellPhone.id).then(function(cellPhone){
                   $scope.records = [];
                   $scope.records.push(cellPhone);
                   console.log(cellPhone);
               });*/
                svc.findItemProv(record.provider.id).then(function(provider){
                   $scope.records = [];
                   $scope.records.push(provider);
                   console.log(provider);
               });
            };

         
//      this.loadRefOptions();
        this.fetchRecords().then(function(data)
        {
            tmp = data;
            var groups = [{
                            "Id"    : 0, 
                            "Name"  : "Seleccionar Proveedor",  
                            "Items" : [{
                                        "Id": 0,
                                        "Name": "Seleccione Producto"
                                      }]}];
            var existe = false;
            for(var i = 0; i < data.length; i++)
            {
                //Saber que el proveedor no esté ya relacionado...
                existe = false;
                for(var c = 0; c < groups.length; c++)
                {
                    if(Number(groups[c].Id) === Number(data[i].provider.id))
                    {
                        groups[c].Items.push({
                                                   "Id"     : data[i].id,
                                                   "Name"   : data[i].name
                                              });
                        existe = true;
                        break;
                    }
                }
                if(!existe)
                {
                    groups.push({
                                    "Id"    : data[i].provider.id, 
                                    "Name"  : data[i].provider.name, 
                                    "Items" : []
                                });
                }
            }
            $scope.groups = groups;
            $scope.currentGroup = groups[0];
            /*
            $scope.$watch('currentGroup', function(value)
            {
                $scope.currentItem = value.Items[0] || 0;
            });
            
            $scope.$watch('currentItem', function(value)
            {
                if(value.Id !== 0)
                {
                    cheapProduct.provider = $scope.currentGroup.Id;
                    cheapProduct.product = value.Id;
                    //buscarCheap();
                }
            });
            */
        });
        /*
        var buscarCheap = function()
        {
            var price = $('#sl2').val().split(",");
            cheapProduct.lowprice = price[0] || 0 ;
            cheapProduct.highprice = price[1] || 0;
            console.log(cheapProduct);
            //$location.url('/catalog?q=htc');
        };
        */
    }]);
})(window.angular);