(function (ng) {
    var mod = ng.module('mainApp');
    mod.controller('orderQueryCtrl', ['CrudCreator', '$scope', 'saleService', 'rateService','orderQueryModel', '$location', 'authService', '$log',
        function (CrudCreator, $scope, svc,rateService, model, $location, authSvc, $log) {
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
                   // $scope.rate = 3;
                    $scope.max = 5;
                    $scope.isReadonly = false;                    

                    $scope.hoveringOver = function(value, product) {
                        $scope.overStar = value;
                        $scope.product = product;
                    };
                    
                    $scope.hoveringOverProvider = function(value, provider) {
                        $scope.overStarPro = value;
                        $scope.provid = provider;
                    };

                    $scope.ratingStates = [
                        {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'}
                    ];
                    $scope.titles = ['No rate','Bad','Poor','Regular','Good','Excelent'];
                    $scope.rateProduct= function () {
                        rateService.setRateProduct($scope.product,$scope.overStar)
                                .then(function () {
                                   
                                });
                        return $scope.overStar;      
                    }
                    $scope.rateProvider= function () {
                        rateService.setRateProvider($scope.provid,$scope.overStarPro)
                                .then(function () {
                                   
                                });
                        return $scope.overStarPro;      
                    }
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
                    }else{
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
                    }};
            }
            else {
                $location.path('/login');
            }
        }]);    
    mod.controller('ModalRateCtrl', function ($scope, $modalInstance) {        
        $scope.ok = function () {
            alert($scope.rate)
            //$modalInstance.close($scope.itemQuestion);
        };
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
        $scope.rate = 3;
        $scope.max = 5;
        $scope.isReadonly = false;
        $scope.hoveringOver = function(value) {
            $scope.overStar = value;
            $scope.percent = value;
        };
        $scope.ratingStates = [
            {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'}
        ];        
    });    
})(window.angular);