(function(ng){
    var mod = ng.module('productModule');
    
    mod.service('productService', ['CrudCreator','productContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            //Para los comemtarios...
            this.saveComment = function(data)
            {
                return this.api.one("comments/").customPOST(data).then(function() 
                {
                    console.log("Success");
                });
            };
            this.saveQuestion = function(data)
            {
                return this.api.one("questions/").customPOST(data).then(function() 
                {
                    console.log("Success");
                });
            };
            //Para listar el proveedor con el producto mas economico...
            this.findItem = function(idProvider){
                return this.api.one('cheapest', idProvider).get();
            };
            //Para listar el proveedor con el producto mas economico...
            this.findItemProv = function(idcellPhone){
                return this.api.one('cheapestProv', idcellPhone).get();
            };

    }]);
})(window.angular);
