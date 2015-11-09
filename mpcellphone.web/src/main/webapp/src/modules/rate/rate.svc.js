(function(ng){
    var mod = ng.module('rateModule');
    mod.service('rateService', ['CrudCreator','rateContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
            this.setRateProduct = function(product,value) {
                 var data = {rate: value,
                            product: product}
                return this.api.one('product').customPOST(data).then(function(){});
            };
            this.setRateProvider = function(provider,value) {
                var data = {rate: value,
                            provider: provider}
                return this.api.one('provider').customPOST(data).then(function(){});
            };
    }]);
})(window.angular);
