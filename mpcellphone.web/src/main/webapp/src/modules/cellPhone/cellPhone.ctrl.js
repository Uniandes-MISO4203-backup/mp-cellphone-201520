//jb.del10
(function (ng) {
    var mod = ng.module('cellPhoneModule');

    mod.controller('cellPhoneCtrl', ['CrudCreator', '$scope', 'cellPhoneService', 'cellPhoneModel', 
        function (CrudCreator, $scope, svc, model) 
        {
            CrudCreator.extendController(this, svc, $scope, model, 'cellPhone', 'CellPhone');
            this.fetchRecords();
            /*
                  //$scope.product = {};
           
            $scope.cellphone = {};
            
            $scope.submitCellphoneData = function () {
                //var productData = {};
                var cellphoneData = {};
                /* //datos producto
                productData.id = $scope.product.id;
                productData.name = $scope.product.name;
                productData.price = $scope.product.price;
                productData.discount = $scope.product.discount;
               
               //datos celulars
                cellphoneData.brand = $scope.cellphone.brand;
                cellphoneData.model = $scope.cellphone.model;
                cellphoneData.name = $scope.cellphone.name;
                cellphoneData.publicationdate = $scope.cellphone.publicationdate;
                cellphoneData.imei = $scope.cellphone.imei;
                cellphoneData.description = $scope.cellphone.description;
                
                svc.saveRecord(cellphoneData).then(function (data) {
                    $scope.cellphoneData = data;
                });
            };
            */
         }]);
             
})(window.angular);
