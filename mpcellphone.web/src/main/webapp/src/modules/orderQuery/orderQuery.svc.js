(function(ng){
    var mod = ng.module('orderQueryModule');
    mod.service('saleService', ['CrudCreator','clientContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.getRoleOQ = function() {
                return this.api.one('../users/currentUser').get();
            };
            this.getSaleByClient = function(clientId) {
                return this.api.one('client',clientId).get();
            };
            this.getSaleByProvider = function(providerId) {
                return this.api.one('provider',providerId).get();
            };
    }]);
})(window.angular);