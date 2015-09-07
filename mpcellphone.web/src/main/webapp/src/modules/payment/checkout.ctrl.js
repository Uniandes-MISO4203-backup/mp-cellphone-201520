(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.controller('checkoutCtrl', ['CrudCreator', '$scope', 'authService', 'cartItemService'
        , 'checkoutService', 'paymentService', 'shippingService', 'creditCardService',
        function (CrudCreator, $scope, authSvc, ciSvc, chSvc, paySvc, shpSvc, ccSvc) {
            var that = this;
            $scope.cartItems = [];
            $scope.totalCompra = 0;
            
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
            
            /*-------------- Shipping ------------*/
            $scope.shipping = {};
            $scope.shipping.time = Math.ceil(Math.random() * 5);
            
            $scope.submitShippingData = function(){
                var shippingData = {};
                shippingData.state = $scope.shipping.state;
                shippingData.country = $scope.shipping.country;
                shippingData.city = $scope.shipping.city;
                shippingData.address = $scope.shipping.address;
                shippingData.stimatedTime = $scope.shipping.time;
                
                if(shippingData.state && shippingData.country && shippingData.city
                        && shippingData.address){
                        shpSvc.saveRecord(shippingData).then(function(data){
                            $scope.shipping = data[0];
                            document.getElementById('shippingData').style.display = "none";
                            document.getElementById('paymentData').style.display = "block";
                        });
                }
            }
            
            
            /*------------ Credit card ----------*/
            
            $scope.creditCardHolders = [];
            
            ccSvc.fetchRecords().then(function(data){
                for(var i = 0, l = data.length; i < l; i++){
                    if(data[i].methodName){
                        $scope.creditCardHolders.push(data[i]);
                    }
                }
            });
            
            $scope.changePayment = function(evt){
                switch(evt.currentTarget.id){
                    case 'creditCard': document.querySelector('#pseForm').style.display = "none";
                                        document.querySelector('#creditCardForm').style.display = "block";
                                        break;
                    case 'pse': document.querySelector('#creditCardForm').style.display = "none";
                                        document.querySelector('#pseForm').style.display = "block";
                                        break;
                }
            }
            
            $scope.submitPayment = function(){
                var paymentData = {};
                var date = new Date();
                date = date.getFullYear() + '/' + (date.getMonth()+1) + '/' date.getDay();
                paymentData.payDate = date;
                paymentData.totalDiscount = 0;
                
                paySvc.saveRecord(paymentData).then(function(data){
                    
                });
            }
            
        }]);

})(window.angular);
