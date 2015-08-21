(function (ng) {
    var mod = ng.module('cellPhoneModule');

    mod.controller('cellPhoneCtrl', ['CrudCreator', '$scope', 'cellPhoneService', 'cellPhoneModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'cellPhone', 'CellPhone');
            this.fetchRecords();
        }]);
})(window.angular);
