(function (ng) {
    var mod = ng.module('paymentModule');
    mod.service('checkoutService', ['CrudCreator', 'checkoutContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('shippingService', ['CrudCreator', 'shippingContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('creditCardService', ['CrudCreator', 'creditCardContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('shippingTypeService', ['CrudCreator', 'shippingTypeContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('saleService', ['CrudCreator', 'saleContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('shippingProductService', ['CrudCreator', 'shippingProductContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.updateProduct = function (record) {
                this.fetchRecords().then(function (data) {
                    for (var i = 0; i < data.length; i++) {
                        if (record.product.id === data[i].id) {
                            record = data[i];
                            record.productState = 'Vendido';
                            break;
                        }
                    }
                    record.put();
                });
            };
        }]);
    mod.service('shippingUserService', ['CrudCreator', 'userContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('stateService',['CrudCreator', 'stateContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
    mod.service('cityService',['CrudCreator', 'cityContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.getCityByState = function (stateId){
                return this.api.one('state/'+stateId).get();
            };
        }]);
})(window.angular);
