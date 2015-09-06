(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.controller('checkoutCtrl', ['CrudCreator', '$scope', 'authService', 'cartItemService'
        , 'checkoutService', 'paymentService', function (CrudCreator, $scope, authSvc, ciSvc, chSvc, paySvc) {
            var that = this;
            $scope.cartItems = [];
            $scope.totalCompra = 0;
            var fecha = new Date();
            fecha = fecha.getFullYear() + '/' + (fecha.getMonth()+1) + '/' + fecha.getDate();
            var ordenDummy = {client: authSvc.getCurrentUser(),
                                ship: "Hola mundo ship",
                                state: "En proceso",
                                dateOrder: fecha};
            var save = chSvc.saveRecord(ordenDummy);
            console.log(save);
            ciSvc.fetchRecords().then(function(data){
                for(var i=0, l = data.length; i < l; i++){
                    if(data[i].name){
                        $scope.cartItems.push(data[i]);
                        $scope.totalCompra += data[i].product.price;
                    }else{
                        break;
                    }
                }
            });
            
        }]);

})(window.angular);
