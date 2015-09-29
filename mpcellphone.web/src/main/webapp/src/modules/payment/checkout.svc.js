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
    mod.service('clientService', ['CrudCreator', 'clientContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.getRoleCl = function () {
                return this.api.one('../users/currentUser').get();
            }
        }]);
})(window.angular);
