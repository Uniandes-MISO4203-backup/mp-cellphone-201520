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
    mod.service('userService', ['CrudCreator', 'userContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
})(window.angular);
