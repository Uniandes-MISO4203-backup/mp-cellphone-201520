(function(ng){
    var mod = ng.module('orderQueryModule');
    mod.service('saleService', ['CrudCreator','saleContext', function(CrudCreator, context){
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
            this.getProductsBySale = function (clientId,orderId){
                return this.api.one('viewDetail/'+clientId+'/'+orderId).get();
            };
    }]);
    mod.service('checkoutService', ['CrudCreator', 'checkoutContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.getOrderById = function (orderId){
                return this.api.one(orderId).get();
            };
        }]);
    mod.service('shippingService', ['CrudCreator', 'shippingContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('cityService',['CrudCreator', 'cityContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.getCityByState = function (stateId){
                return this.api.one('state/'+stateId).get();
            };
            this.getCityById = function (cityId){
                return this.api.one(cityId).get();
            };
        }]);

})(window.angular);