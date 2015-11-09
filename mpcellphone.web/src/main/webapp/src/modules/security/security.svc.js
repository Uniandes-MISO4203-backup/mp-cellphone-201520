(function(ng){
    var mod = ng.module('clientModule');
    mod.service('clientService', ['CrudCreator','clientContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.getRoleCl = function() {return this.api.one('../users/currentUser').get();};
            this.savePasswordC = function(data){
                return this.api.one("/client/chgpwdC").customPOST(data).then(function(){});
            };
            this.savePasswordP = function(data){
                return this.api.one("/provider/chgpwdP").customPOST(data).then(function(){});
            };
    }]);
})(window.angular);