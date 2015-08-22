(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.service('cartItemService', ['CrudCreator', 'cartItemContext', function (CrudCreator, context) {
            CrudCreator.extendService(this, context);
            var self = this;
            this.addItem = function (record) {
                this.fetchRecords().then(function (data) {
                    for (var i = 0; i < data.length; i++) {
                        if (record.product.name === data[i].product.name && record.product.id === data[i].product.id) {
                            record = data[i];
                            record.quantity = data[i].quantity + 1;
                            break;
                        }
                    }
                    self.saveRecord(record);
                });
            };
        }]);
})(window.angular);
