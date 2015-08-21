(function(ng){
    var mod = ng.module('cartItemModule');
    
    mod.service('cartItemService', ['CrudCreator','cartItemContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
