(function (ng) {
    var mod = ng.module('paymentModule');

    mod.service('checkoutService', ['CrudCreator', 'checkoutContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            
        }]);
    
    mod.service('paymentService', ['CrudCreator', 'paymentContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            
        }]);
})(window.angular);
