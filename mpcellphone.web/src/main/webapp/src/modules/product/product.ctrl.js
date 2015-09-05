//var tmp = 0;
(function (ng) {
    var mod = ng.module('productModule');
    var maximoCaracteres = 255;
    var ProducSelComment = 0; //Para guardar el item que se está haciendo el comentario..
    var f = new Date(); //Fecha actual
    var questionDate = f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear();

    mod.controller('productCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', 'cartItemService', '$location', 'authService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'product', 'Products');

            this.searchByName = function (cellPhoneName) {
                var search;
                if (cellPhoneName) {
                    search = '?q=' + cellPhoneName;
                }
                $location.url('/catalog' + search);
            };

            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (record) {
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
                        if (authSvc.getCurrentUser())
                        {
                            ProducSelComment = record;
                            $('#modalQuestion').modal('show');
                            $('#nameUserQuestion').html("<center><b>" + authSvc.getCurrentUser().name + " Dice:</b></center><br>");
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
                            var objEnvia = {
                                comment     : $("#comment").val(), 
                                idProduct   : ProducSelComment.id, 
                                idUser      : authSvc.getCurrentUser().id
                            };
                            svc.saveComment({id : 9, ship: $("#comment").val(), state: "correcto vista"}).then(function(data){
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
                    //tmp = authSvc;
                    if (authSvc.getCurrentUser())
                    {
                        if($("#question").val().length !== 0)
                        {
                            var objEnvia = {
                                question     : $("#question").val(), 
                                product      : ProducSelComment.id
                            };
                            svc.saveQuestion(objEnvia).then(function(data){
                                $('#myModal').modal('hide');
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
         
//            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
