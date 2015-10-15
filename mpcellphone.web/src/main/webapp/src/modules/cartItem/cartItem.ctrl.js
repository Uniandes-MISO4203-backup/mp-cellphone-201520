(function (ng) {
    var mod = ng.module('cartItemModule');
    mod.controller('cartItemCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel', '$location', 'authService', function (CrudCreator, $scope, svc, model, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'cartItem', 'My Shopping Cart');
            var self = this;
            var oldFetch = this.fetchRecords;
            this.fetchRecords = function(){
                return oldFetch.call(this).then(function(data){
                    self.calcTotal();
                    return data;
                });
            };
            this.fetchRecords();
            this.readOnly = true;
            $scope.lastQuantity = 0;
            $scope.total = 0;
            this.recordActions = {
                delete: {
                    displayName: ' ',
                    icon: 'trash',
                    class: 'primary',
                    fn: function (record) {
                        svc.deleteRecord(record).then(function(){
                            self.fetchRecords();
                        });
                    },
                    show: function () {
                        return true;
                    }
                }};
            this.calcTotal = function () {
                $scope.total = 0;
                for (var i = 0; i < $scope.records.length; i++) {
                    $scope.total += $scope.records[i].product.price * $scope.records[i].quantity;
                }
            };
            //guarda la cantidad anterior
            $scope.verify = function (quantity) {
                $scope.lastQuantity = quantity;
            };
            //Realiza la validacion de la nueva cantidad asignada.
            $scope.postVerify = function (record) {
                var patron = /^\d*$/; //^[0-9]{3}$
                if (patron.test(record.quantity) && record.quantity > 0) {
                    self.calcTotal();
                } else {
                    self.showError("You must enter a valid quantity");
                    record.quantity = $scope.lastQuantity;
                    $scope.currentRecord = record;
                }
            };
            $scope.checkout = function () {
                $location.path('/checkout');
            };
            $scope.subtotal = function(record){
                return record.product.price * record.quantity;
            };
        }]);

})(window.angular);