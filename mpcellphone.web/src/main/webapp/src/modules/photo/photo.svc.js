(function(ng){
    var mod = ng.module('photoModule');
    mod.service('photoService', ['CrudCreator','photoContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
              //Para listar el proveedor con el producto mas economico...
            this.getByProductId = function(id){
                return this.api.one('getByProductId', id).get();
            };
    }]);
})(window.angular);