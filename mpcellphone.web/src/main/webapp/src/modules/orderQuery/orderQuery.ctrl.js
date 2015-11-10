(function (ng) {
    var mod = ng.module('mainApp');
    mod.controller('orderQueryCtrl', ['CrudCreator', '$scope', 'saleService', 'rateService', 'orderQueryModel', '$location', 'authService', '$log', 'checkoutS', 'cityService',
        function (CrudCreator, $scope, svc, rateService, model, $location, authSvc, $log, checkSvc, citySvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'orderQuery', 'Order List');
            var user = authSvc.getCurrentUser();
            svc.getRoleOQ().then(function (data) {
                $scope.userRole = data.role;
            });
            var isDetail = $location.path();
            if (isDetail.indexOf('viewDetail') > -1) {
                var id = $location.search().id;
                svc.getProductsBySale(user.id, id).then(function (data) {
                    $scope.detailOrderList = data;
                    $scope.max = 5;
                    $scope.isReadonly = false;
                    $scope.showAlert = false;
                    $scope.alert = {type: 'success', msg: ''};
                    $scope.closeAlert = function () {
                        $scope.showAlert = false;
                    };
                    $scope.hoveringOver = function (value, product) {
                        $scope.overStar = value;
                        $scope.product = product;
                    };
                    $scope.hoveringOverProvider = function (value, provider) {
                        $scope.overStarPro = value;
                        $scope.provid = provider;
                    };
                    $scope.ratingStates = [
                        {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'}
                    ];
                    $scope.titles = ['No rate', 'Bad', 'Poor', 'Regular', 'Good', 'Excelent'];
                    $scope.rateProduct = function(){
                        rateService.setRateProduct($scope.product, $scope.overStar)
                                .then(function (){
                                    $scope.alert = {type: 'success', msg: 'product ' + $scope.product.name + ' with ' + $scope.overStar + ' stars'};
                                    $scope.showAlert = true;
                                });
                        return $scope.overStar;
                    };
                    $scope.rateProvider = function(){
                        rateService.setRateProvider($scope.provid, $scope.overStarPro)
                                .then(function(){
                                    $scope.alert = {type: 'success', msg: 'provider ' + $scope.provid.name + ' with ' + $scope.overStarPro + ' stars'};
                                    $scope.showAlert = true;
                                });
                        return $scope.overStarPro;
                    };
                });
            }
            (function () {
                $("#datepicker").datepicker({
                    showOn: "button",
                    buttonImage: "src/modules/orderQuery/images/calendar.png",
                    buttonImageOnly: true,
                    buttonText: "Select date"
                });
                $('#datepicker').datepicker("option", "dateFormat", "yy-mm-dd");
                $("#datepicker1").datepicker({
                    showOn: "button",
                    buttonImage: "src/modules/orderQuery/images/calendar.png",
                    buttonImageOnly: true,
                    buttonText: "Select date"
                });
                $('#datepicker1').datepicker("option", "dateFormat", "yy-mm-dd");
            })();
            if (user) {
                $log.log(user.id);
                svc.getSaleByClient(user.id).then(function (data) {
                    $scope.orderList = [];
                    for (var i = 0; i < data.length - 1; i++) {
                        var flag = false;
                        for (var j = 0; j < $scope.orderList.length; j++) {
                            if (data[i].orderId.id === $scope.orderList[j].orderId.id) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            $scope.orderList.push(data[i]);
                        }
                    }
                });
                svc.getSaleByProvider(user.id).then(function (data) {
                    $scope.orderList = [];
                    for (var i = 0; i < data.length - 1; i++) {
                        var flag = false;
                        for (var j = 0; j < $scope.orderList.length; j++) {
                            if (data[i].orderId.id === $scope.orderList[j].orderId.id) {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            $scope.orderList.push(data[i]);
                        }
                    }
                });
                $scope.search = function () {
                    $scope.orderList = $scope.allOrders || $scope.orderList;
                    var fechaInicial = $('#datepicker').val();
                    var fechaFinal = $('#datepicker1').val();
                    $scope.dataEmpty = false;
                    fechaInicial = fechaInicial.split('-').join('');
                    fechaFinal = fechaFinal.split('-').join('');
                    var temp = [];
                    for (var i = 0, l = $scope.orderList.length; i < l; i++) {
                        var format = $scope.orderList[i].orderId.dateOrder.split('-').join('');
                        format = parseInt(format.substring(0, 8));
                        if (format >= fechaInicial &&
                                format <= fechaFinal) {
                            temp.push($scope.orderList[i]);
                        }
                    }
                    if (temp.length === 0) {
                        $scope.dataEmpty = true;
                        $('#tableData').hide();
                    } else {
                        $scope.dataEmpty = false;
                        $('#tableData').show();
                    }
                    $scope.allOrders = $scope.orderList;
                    $scope.orderList = temp;
                };
                $scope.globalActions = {
                    viewDetail: {
                        displayName: 'Return',
                        icon: 'circle-arrow-left',
                        class: 'primary',
                        fn: function () {
                            $location.path('/orderLists');
                        },
                        show: function () {
                            return true;
                        }
                    }};

                var lat = 0, lng = 0;
                window.initMap = function () {
                    map = new google.maps.Map(document.getElementById('map'), {
                        center: {lat: -34.397, lng: 150.644},
                        zoom: 8
                    });
                    
                    var id = $location.search().id;
                    checkSvc.getOrderById(id).then(function (data) {
                        $log.log(data.ship)
                        citySvc.getCityById(data.ship.city).then(function (data) {
                            lat = data.latitude;
                            lng = data.longitude;                            
                            marker = new google.maps.Marker({
                                position: {lat: lat, lng: lng},
                                map: map,
                                title: 'Tracking map'
                            });
                            map.setCenter({lat: lat, lng: lng});
                        });

                    });
                };

                $scope.recordActions = {
                    viewDetail: {
                        displayName: 'View Detail',
                        icon: 'list-alt',
                        class: 'primary',
                        fn: function (record) {
                            var id = String(record.orderId.id);
                            $location.path('/viewDetail').search('id', id);
                        },
                        show: function () {
                            return true;
                        }
                    },
                    tracking: {
                        displayName: 'Tracking',
                        icon: 'send',
                        class: 'primary',
                        fn: function (record) {
                            var id = String(record.orderId.id);
                            $scope.state = record.orderId.state;
                            $location.path('/tracking').search('id', id);
                        },
                        show: function () {
                            return true;
                        }
                    }};
                $scope.ret = function () {
                    $location.path('/orderLists');
                };
            }
            else {
                $location.path('/login');
            }
        }]);
    mod.controller('ModalRateCtrl', function ($scope, $modalInstance) {
        $scope.ok = function () {
            alert($scope.rate);
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.rate = 3;
        $scope.max = 5;
        $scope.isReadonly = false;
        $scope.hoveringOver = function (value) {
            $scope.overStar = value;
            $scope.percent = value;
        };
        $scope.ratingStates = [
            {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'}
        ];
    });
})(window.angular);