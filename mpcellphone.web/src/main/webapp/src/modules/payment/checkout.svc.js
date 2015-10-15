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
    mod.service('productService', ['CrudCreator', 'productContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            this.updateProduct = function (record) {
                this.fetchRecords().then(function (data) {
                    for (var i = 0; i < data.length; i++) {
                        if (record.product.id === data[i].id) {
                            console.log('-------');
                            record = data[i];
                            record.productState = 'Vendido';
                            console.log(record);
                            console.log('********');
                            break;
                        }
                    }
                    //var update = self.saveRecord(record);
                    record.put();
                    //sconsole.log(update);
                });
            };
            /*this.updateProduct = function(record){
                console.log(record);
                var product = this.api.one('', record.product.id).get();
                product.productState = 'Vendido';
                console.log(product);
                //var productI = product.customPUT());
                //var productI = this.api.one('').customPUT(product);
                return product.put();
                //this.fetchRecord(idProduct);
                //console.log(this.fetchRecord(product));
                //return this.api.one('product', idProduct).put();
            };*/
        }]);
    mod.service('userService', ['CrudCreator', 'userContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
        }]);
})(window.angular);
