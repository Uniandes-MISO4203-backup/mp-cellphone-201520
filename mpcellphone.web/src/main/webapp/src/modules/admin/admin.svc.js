(function(ng){
    var mod = ng.module('adminModule');
    mod.service('adminService', ['CrudCreator','adminContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.darRole = function(){
                return this.api.one('../currentUser').get();
            };
    }]);
})(window.angular);
