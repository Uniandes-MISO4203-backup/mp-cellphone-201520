(function (ng) {
    var mod = ng.module('paymentModule');

    mod.controller('checkoutCtrl', ['CrudCreator', '$scope', 'authService', 'cartItemService', '$location'
                , 'checkoutService', 'shippingService', 'creditCardService', 'shippingTypeService',
        function (CrudCreator, $scope, authSvc, ciSvc, $location, chSvc, shpSvc, ccSvc, stSvc) {
            var that = this;
            $scope.cartItems = [];
            $scope.payment = {};
            $scope.totalCompra = 0;

            ciSvc.fetchRecords().then(function (data) {
                for (var i = 0, l = data.length; i < l; i++) {
                    if (data[i].name) {
                        $scope.cartItems.push(data[i]);
                        $scope.totalCompra += data[i].product.price;
                    } else {
                        break;
                    }
                }
            });
            
            /*------------ Shipping Type ----------*/
            $scope.shippingTypeHolders = [];

            stSvc.fetchRecords().then(function (data) {
                for (var i = 0, l = data.length; i < l; i++) {
                    if (data[i].name) {
                        $scope.shippingTypeHolders.push(data[i]);
                    }
                }
            });

            /*-------------- Shipping ------------*/
            $scope.shipping = {};
            $scope.shipping.time = Math.ceil(Math.random() * 5);

            $scope.submitShippingData = function () {
                var shippingData = {};
                shippingData.state = $scope.shipping.state;
                shippingData.country = $scope.shipping.country;
                shippingData.city = $scope.shipping.city;
                shippingData.address = $scope.shipping.address;
                shippingData.stimatedTime = $scope.shipping.time;
                
                var shippingType = {};
                var data = $scope.shipping.shippingTypeHolders;
                for (var i = 0; i < $scope.shippingTypeHolders.length; i++) {
                    shippingType = $scope.shippingTypeHolders[i];
                    if ($scope.shippingTypeHolders[i].id == data) {
                        break;
                    }
                }
                shippingData.shipType = shippingType;

                if (shippingData.state && shippingData.country && shippingData.city
                        && shippingData.address) {
                    shpSvc.saveRecord(shippingData).then(function (data) {
                        $scope.shippingData = data;
                        var pestana = $('li.active');
                        document.getElementById('shippingData').style.display = "none";
                        document.getElementById('paymentData').style.display = "block";
                        pestana.next('li').addClass('active').show();
                        pestana.removeClass('active');
                    });
                }
            }
            /*------------ Credit card ----------*/

            $scope.creditCardHolders = [];

            ccSvc.fetchRecords().then(function (data) {
                for (var i = 0, l = data.length; i < l; i++) {
                    if (data[i].methodName) {
                        $scope.creditCardHolders.push(data[i]);
                    }
                }
            });

            $scope.changePayment = function (evt) {
                switch (evt.currentTarget.id) {
                    case 'creditCard':
                        document.querySelector('#pseForm').style.display = "none";
                        document.querySelector('#creditCardForm').style.display = "block";
                        break;
                    case 'pse':
                        document.querySelector('#creditCardForm').style.display = "none";
                        document.querySelector('#pseForm').style.display = "block";
                        break;
                }
            }

            /*------------ Order ----------*/
            $scope.submitPayment = function () {
                var order = {};
                order.ship = $scope.shippingData;
                order.state = "En proceso";
                order.client = authSvc.getCurrentUser();
                order.totalDiscount = 0;
                order.totalSale = $scope.totalCompra;

                var creditCard = {};
                var data = $scope.payment.creditCardHolder;
                for (var i = 0; i < $scope.creditCardHolders.length; i++) {
                    creditCard = $scope.creditCardHolders[i];
                    if ($scope.creditCardHolders[i].id == data) {
                        break;
                    }
                }
                order.paymentMethod = creditCard;
                order.numberCard = $scope.payment.cardNumber;
                order.totalTax = 0;
                order.bank = $scope.payment.clientBankName;
                order.expirationDate = $scope.payment.cardExpiration;
                order.svc = $scope.payment.cardCode;

                chSvc.saveRecord(order).then(function (data) {
                    $scope.order = data;
                    var pestana = $('li.active');
                    document.querySelector('#paymentData').style.display = "none";
                    document.querySelector('#confirmationTmpl').style.display = "block";
                    pestana.next('li').addClass('active').show();
                    pestana.removeClass('active');
                });
            }

            $scope.pay = function () {
                $('#modalPay').modal('show');
            };

            $scope.finish = function () {
                $('#modalPay').modal('hide');
                $location.path('/catalog');
            };
        }]);

})(window.angular);
