(function(ng){
    var mod = ng.module('providerModule');
    
    mod.service('providerService', ['CrudCreator','providerContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.getRoleSvc = function() {
                return this.api.one('../currentUser').get();   
            }
    }]);
})(window.angular);
