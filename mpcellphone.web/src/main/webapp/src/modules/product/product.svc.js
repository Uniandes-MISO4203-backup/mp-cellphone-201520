(function(ng){
    var mod = ng.module('productModule');
    mod.service('productService', ['CrudCreator','productContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            //Para los comemtarios...
            this.saveComment = function(data){
                return this.api.one("comments/").customPOST(data).then(function(){});
            };
            this.saveQuestion = function(data){
                return this.api.one("questions/").customPOST(data).then(function(){});
            };
            //Para listar el proveedor con el producto mas economico...
            this.findItem = function(idProvider){
                return this.api.one('cheapest', idProvider).get();
            };
            //Para listar el proveedor con el producto mas economico...
            this.findItemProv = function(idcellPhone){
                return this.api.one('cheapestProv', idcellPhone).get();
            };            
            this.comments = function(){
                return this.api.one('allcomments').get();
            };            
            this.cargaCombos = function(service){
                return this.api.one(service).get();
            };            
            this.getBy = function(service, name){
                //Se edita la función getBy, porque es una busqueda alterna
                if (service !== "getByPriceRange"){
                    return this.api.one(service, name).get();
                }else{
                    return this.api.one(service+"/"+name[0]+"/"+name[1]).get();
                }                
            };            
            this.getByDiscount = function(){
                return this.api.one("getDiscount").get();
            };
    }]);
})(window.angular);