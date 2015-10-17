(function (ng) {
    var mod = ng.module('productModule');
    var maximoCaracteres = 255;
    var ProducSelComment = 0;
    mod.controller('productCtrl',
        ['CrudCreator', '$scope', 'productService', 'productModel', 'cartItemService', '$location', 'authService', 'adminService','$filter',
        function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc, adminService,$filter) {
            CrudCreator.extendController(this, svc, $scope, model, 'product', 'Products');
            this.searchByName = function (cellPhoneName) {
                var search;
                if (cellPhoneName) {
                    search = '?q=' + cellPhoneName;
                }
                $location.url('/catalog' + search);
            };
            var serviceSearch = [{
                service: "getModels",
                select: "model",
                campo: "name",
                search: "servicioBusca"
            },{
                service: "getCities",
                select: "cities",
                campo: "name",
                search: "servicioBusca"
            },{
                service: "getProviders",
                select: "providers",
                campo: "name",
                search: "servicioBusca"
            },{
                service: "getCategories",
                select: "categories",
                campo: "category",
                search: "servicioBusca"
            }];
            var findBy = function(servicio, criterio){
               svc.getBy(servicio, criterio).then(function(data){
                   $scope.records = data;
                });
            };
            $("#advancedForm").click(function(event) {
                var ingresa = false;
                var nomServicio = "";
                var criterio = "";
                if (($("#price1").val().length !== 0) || ($("#price2").val().length !== 0)){ //jb.del10
                    nomServicio = "getByPriceRange";
                    criterio = [$("#price1").val(),$("#price2").val()];
                    ingresa = true;
                }else{
                    for(var i = 0; i < serviceSearch.length; i++){
                        if($("#" + serviceSearch[i].select).val() !== "0"){
                            criterio = ($("#" + serviceSearch[i].select).val());
                            nomServicio = serviceSearch[i].service + "/";
                            ingresa = true;
                            break;
                        }
                    }
                }
                if(ingresa){
                    findBy(nomServicio, criterio);
                    $('#myModalHorizontal').modal('hide');
                }
            });
            var advancedSearchFields = function (indice){
                svc.cargaCombos(serviceSearch[indice].service).then(function (data){
                    var $select = $('#' + serviceSearch[indice].select);
                    $select.find('option').remove();
                    $select.append("<option value = '0'>Select</option>");
                    $.each(data, function (i){
                        $select.append("<option value='" + data[i][serviceSearch[indice].campo] + "'>" + data[i][serviceSearch[indice].campo] + "</option>");
                    });
                });
            };
            this.advancedSearch = function (){
                $('#myModalHorizontal').modal('show');
                for (var i = 0; i < serviceSearch.length; i++){
                    advancedSearchFields(i);
                    $("#" + serviceSearch[i].select).change(function (){
                        for (var i = 0; i < serviceSearch.length; i++){
                            if (serviceSearch[i].select !== this.id){
                                $("#" + serviceSearch[i].select).val("0");
                            }
                        }
                    });
                }
            };
            $("#admin").hide();
            $("#carrito").hide();
            $("#products").hide();
            if (!$('#profile').length){
                var orderListItem = $('<li>');
                var orderListLink = $('<a href="#/orderLists">');
                //To-Do verificar el icono
                var orderListIcon = $('<span>').addClass('glyphicon glyphicon-user');
                orderListItem.append(orderListLink);
                orderListLink.text(' Order List');
                orderListLink.prepend(orderListIcon);
                $(".dropdown-menu").prepend(orderListItem);
                $(".dropdown-menu").prepend("<li><a href = '#' id = 'profile'><span class = 'glyphicon glyphicon-user'></span> My Profile</a></li>");
            }
            var currentUser = authSvc.getCurrentUser();
            if (currentUser){
                adminService.darRole().then(function (data){
                    if (data.role === "admin"){
                        $("#admin").show();
                        $("#profile").attr("href", "#/client");
                    }else{
                        if (data.role === "provider"){
                            $("#products").show();
                            $("#profile").attr("href", "#/provider");
                        }else{
                            $("#carrito").show();
                            $("#profile").attr("href", "#/client");
                        }
                    }
                });
            }
            $(".dropdown-menu > li > a").click(function () {
                $("#admin").hide();
                $("#carrito").hide();
                $("products").hide();
            });
            $scope.priceItem = "";
            $scope.cheap = function (prov, price, record){
                price = price || 0;
                if (Number(record.provider.id) === Number(prov.Id) || prov.Id === 0){
                    return prov.Id === 0 ? true : Number(record.price) <= Number(price) || Number(price) === 0 ? true : false;
                }else{
                    return false;
                }
            };
            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (record) {
                        $("#notiShopping").html("Se ha agregado " + record.name + ", a tu carrito de compras.").fadeIn("fast").delay(2000).fadeOut(300);
                        if (authSvc.getCurrentUser()) {
                            return cartItemSvc.addItem({
                                product: record,
                                name: record.name,
                                quantity: 1});
                        }else{
                            $location.path('/login');
                        }
                    },
                    show: function () {
                        return true;
                    }
                }];
            //Para la información adicional del producto
            this.prodductInfoActions = [{
                    name: 'productInfo',
                    class: 'warning',
                    fn: function (record){
                        var price = $filter('currency')(record.price);
                        var discount = $filter('number')(record.discount,1);
                        $('#productInfo').modal('show');
                        $("#image").html("<img src='"+record.image+"' width='100%'>");
                        $("#image").html("<img src='"+record.image+"' width='100%'>");
                        $("#info").html("<p><strong>Cellphone:</strong>"+record.cellPhone.name+"</p>"+
                                "<p><strong>Price:</strong>"+price+"</p>"+
                                "<p><strong>Discount:</strong>"+discount+" %</p>"+
                                "<p><strong>Provider:</strong>"+record.provider.name+"</p>"+
                                "<p><strong>Available in:</strong>"+record.city.name+"</p>");
                        var text = "";
                        if(record.photos.length > 0){
                            for (var i = 0; i < record.photos.length; i++){
                                text += "<li><div class='slidercontainer'>"
                                        +"<div id='element-slider' class='element-slider'>"
                                        +"<a href='"+record.photos[i].image+"' target='_blank' "
                                        +" >"
                                        +"<img src='"+record.photos[i].image
                                        +"' alt='Click to watch more' "
                                        +"' style='max-width: 100%; vertical-align: middle;'/>"
                                        +"</a></div></div></li>";
                            }
                        }else{
                            text += "<li style='width: 100%;'><div class='slidercontainer' style='width: 100%;'>"
                                        +"<div id='element-slider' style='width: 100%;' class='element-slider'>"
                                        +"No pictures</div></div></li>";
                        }
                        $("#slider-ul").html(text);
                    },
                    show: function () {
                        return true;
                    }
                }];
            var getComments = function (id){
                svc.comments(id).then(function (data){
                    var txt = "";
                    var cont = 0;
                    for (var i = 0; i < data.length; i++){
                        if (Number(data[i].product_id) === Number(id)){
                            if (txt !== ""){
                                txt += "<hr>";
                            }
                            cont++;
                            txt += cont + ". " + data[i].comment;
                        }
                    }
                    $("#listComments").html(cont !== 0 ? txt : "<center><b>No comments here, be the first to comment</b></center>");
                });
            };
            //Para los comentarios por producto...
            this.commentActions = [{
                    name: 'comment',
                    displayName: 'Comment',
                    icon: 'comment',
                    class: 'warning',
                    fn: function (record){
                        tmp = authSvc;
                        if (authSvc.getCurrentUser()){
                            ProducSelComment = record;
                            $('#titleProduct').html("Comments: Cellphone - " + record.name);
                            $("#comment").val("").attr("placeholder", authSvc.getCurrentUser().name + " Says: ");
                            $("#cantidad").html("<center>" + maximoCaracteres + "</center>");
                            $('#myModal').modal('show').on('shown.bs.modal', function (){
                                $('#comment').focus();
                            });
                            getComments(record.id);
                        }else{
                            $location.path('/login');
                        }
                    },
                    show: function () {
                        return true;
                    }
                }];
            //Para las preguntas por producto...
            this.questionActions = [{
                    name: 'question',
                    displayName: 'Question',
                    icon: 'question-sign',
                    class: 'info',
                    fn: function (record){
                        tmp = authSvc;
                        if (authSvc.getCurrentUser()){
                            ProducSelComment = record;
                            $('#modalQuestion').modal('show');
                            $('#nameUserQuestion').html("<center><b>" + authSvc.getCurrentUser().name + " Says:</b></center><br>");
                            $('#titleProductQuestion').html("Cellphone: " + record.name);
                            $("#question").val("");
                        }else{
                            $location.path('/login');
                        }
                    },
                    show: function () {
                        return true;
                    }
                }];
            //Para limitar el numero de caracteres...
            this.keyActions = [{
                    fn: function (){
                        var queda = maximoCaracteres - $("#comment").val().length;
                        if (queda < 0){
                            $("#comment").val($("#comment").val().substr(0, maximoCaracteres));
                            queda = 0;
                        }
                        $("#cantidad").html("<center>" + queda + "</center>");
                    }
                }];
            //Para salvar el comentario...
            this.saveComment = [{
                    fn: function (){
                        if (authSvc.getCurrentUser()){
                            if ($("#comment").val().length !== 0){
                                svc.saveComment({
                                    comment: $("#comment").val(),
                                    product_id: ProducSelComment.id,
                                    client_id: authSvc.getCurrentUser().id,
                                    date: new Date().toISOString().substring(0, 10)
                                }).then(function () {
                                    getComments(ProducSelComment.id);
                                    $("#comment").val("").attr("placeholder", authSvc.getCurrentUser().name + " Says: ");
                                    $("#cantidad").html("<center>" + maximoCaracteres + "</center>");
                                    $('#comment').focus();
                                });
                            }else{
                                alert("Por favor escribe tu comentario");
                            }
                        }else{
                            $location.path('/login');
                        }
                    }
                }];
            this.saveQuestion = [{
                    fn: function (){
                        if (authSvc.getCurrentUser()){
                            if ($("#question").val().length !== 0){
                                var objEnvia = {
                                    question: $("#question").val(),
                                    product: ProducSelComment.cellPhone,
                                    client: authSvc.getCurrentUser(),
                                    provider: ProducSelComment.provider
                                };
                                svc.saveQuestion(objEnvia).then(function (){
                                    alert("La pregunta ha sido enviada satisfactoriamente");
                                    $('#modalQuestion').modal('hide');
                                });
                            }else{
                                alert("Por favor escribe tu pregunta");
                            }
                        }else{
                            $location.path('/login');
                        }
                    }
                }];
            var findItem = function (record){
                svc.findItem(record.id).then(function (cellPhone) {
                    $scope.records = [];
                    $scope.records.push(cellPhone);
                });
            };
            //Para encontrar el Proveedor con el menor precio para un producto
            this.cheapestActions = [{
                    name: 'BestProvider',
                    displayName: 'Best Provider',
                    icon: 'thumbs-up',
                    class: 'warning',
                    fn: function (record) {
                        return findItem(record);
                    },
                    show: function () {
                        return true;
                    }
                }
            ]
            var findItemProv = function (record){
                svc.findItemProv(record.provider.id).then(function (provider) {
                    $scope.records = [];
                    $scope.records.push(provider);
                });
            };
            //Para encontrar el menor precio de un Proveedor
            this.cheapestProvActions = [{
                    name: 'BestPrice',
                    displayName: 'Best Price',
                    icon: 'usd',
                    class: 'warning',
                    fn: function (record) {
                        findItemProv(record);
                    },
                    show: function () {
                        return true;
                    }
                }
            ]
            this.fetchRecords().then(function (data){
                tmp = data;
                var groups = [{
                        "Id": 0,
                        "Name": "Seleccionar Proveedor",
                        "Items": [{
                                "Id": 0,
                                "Name": "Seleccione Producto"
                            }]}];
                var existe = false;
                for (var i = 0; i < data.length; i++){
                    //Saber que el proveedor no est� ya relacionado...
                    existe = false;
                    for (var c = 0; c < groups.length; c++){
                        if (Number(groups[c].Id) === Number(data[i].provider.id)){
                            groups[c].Items.push({
                                "Id": data[i].id,
                                "Name": data[i].name
                            });
                            existe = true;
                            break;
                        }
                    }
                    if (!existe){
                        groups.push({
                            "Id": data[i].provider.id,
                            "Name": data[i].provider.name,
                            "Items": []
                        });
                    }
                }
                $scope.groups = groups;
                $scope.currentGroup = groups[0];
            });
            var findByDiscount = function(){
               svc.getByDiscount().then(function(data){
                   $scope.records = data;
            });
            //Para listar por descuento Desarrollado por Miguel Olivares
            this.discountActions = [{
                    name: 'BestDiscounts',
                    displayName: 'Best Discounts',
                    icon: 'usd',
                    class: 'warning',
                    fn: function (record) {
                        return findByDiscount();
                    },
                    show: function () {
                        return true;
                    }
                }
            ]
        };
    }]);
})(window.angular);