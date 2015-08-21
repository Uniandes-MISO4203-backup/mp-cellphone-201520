(function (ng) {
    var mod = ng.module('productModule');

    mod.controller('productCtrl', ['CrudCreator', '$scope', 'productService', 'productModel', 'cartItemService', '$location', 'authService', function (CrudCreator, $scope, svc, model, cartItemSvc, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'product', 'Products');

            this.searchByName = function (cellPhoneName) {
                var search;
                if (cellPhoneName) {
                    search = '?q=' + cellPhoneName;
                }
                $location.url('/catalog' + search);
            };

            this.recordActions = [{
                    name: 'addToCart',
                    displayName: 'Add to Cart',
                    icon: 'shopping-cart',
                    class: 'primary',
                    fn: function (record) {
                        if (authSvc.getCurrentUser()) {
                            return cartItemSvc.addItem({
                                product: record,
                                name: record.book.name,
                                quantity: 1});
                        } else {
                            $location.path('/login');// o colocar servicio de LocalStorage
                        }
                    },
                    show: function () {
                        return true;
                    }
                }];

//            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
