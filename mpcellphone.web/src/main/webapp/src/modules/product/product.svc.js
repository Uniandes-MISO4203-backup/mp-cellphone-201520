(function(ng){
    var mod = ng.module('productModule');
    
    mod.service('productService', ['CrudCreator','productContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.saveQuestion = function(data)
            {
                //return this.api.one('cheapest', idBook).get();
                console.log("llega", data);
            };
    }]);
})(window.angular);
