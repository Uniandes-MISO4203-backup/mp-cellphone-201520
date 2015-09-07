(function (ng) {
    var mod = ng.module('paymentModule');

    mod.controller('checkoutCtrl', ['CrudCreator', '$scope', 'authService', 'cartItemService'
        , 'checkoutService', 'paymentService', 'shippingService', 'creditCardService',
        function (CrudCreator, $scope, authSvc, ciSvc, chSvc, paySvc, shpSvc, ccSvc) {
            var that = this;
            $scope.cartItems = [];
            $scope.payment = {};
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
                            $scope.shippingData = data;
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
                var date = new Date().toISOString().substring(0, 10);
                var order = {};
                order.ship = $scope.shippingData;
                order.dateOrder = date;
                order.state = "En proceso";
                order.client = authSvc.getCurrentUser();
                
                chSvc.saveRecord(order).then(function (data){
                   $scope.order = data;
                   var paymentData = {};
                   paymentData.payDate = date;
                   paymentData.totalDiscount = 0;
                   paymentData.order = $scope.order;
                   paymentData.totalSale = $scope.totalCompra;
                   
                   var creditCard = {};
                    var data = $scope.payment.creditCardHolder;
                    for(var i = 0; i < $scope.creditCardHolders.length; i++){
                        creditCard = $scope.creditCardHolders[i];
                        if($scope.creditCardHolders[i].id == data){
                            break;
                        }
                    }
                   paymentData.paymentMethod = creditCard;
                   paymentData.numberCard = $scope.payment.cardNumber;
                   paymentData.totalTax = 0;
                   paymentData.bank = $scope.payment.clientBankName;
                   paymentData.expirationDate = $scope.payment.cardExpiration;
                   paymentData.svc = $scope.payment.cardCode;
                   paySvc.saveRecord(paymentData).then(function(data){
                       $scope.paymentData = data;
                       console.log(data);
                       document.querySelector('#paymentData').style.display = "none";
                       document.querySelector('#confirmationTmpl').style.display = "block";
                   });
                });    
            }
        }]);

})(window.angular);
