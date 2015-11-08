(function(ng){
    var mod = ng.module('rate');
    mod.service('rateService', ['CrudCreator','rateContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.setRateProduct = function(productId,value) {
                 var data = {rate: value,
                            product_id: productId}
                return this.api.one('product').customPOST(data).then(function(){});
            };
            this.setRateProvider = function(providerId,value) {
                var data = {rate: value,
                            provider_id: providerId}
                return this.api.one('provider').customPOST(data).then(function(){});
            };
    }]);
})(window.angular);
