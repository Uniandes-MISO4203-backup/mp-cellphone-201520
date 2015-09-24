(function(ng){
    var mod = ng.module('clientModule');
    
    mod.service('clientService', ['CrudCreator','clientContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.getRoleSvc = function() {
                return this.api.one('../currentUser').get();   
            }
    }]);
})(window.angular);
