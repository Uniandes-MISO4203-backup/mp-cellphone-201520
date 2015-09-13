(function (ng) {
    var mod = ng.module('adminModule');

    mod.controller('adminCtrl', ['CrudCreator', '$scope', 'adminService', 'adminModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'provider', 'Provider');
            this.fetchRecords();
        }]);

    mod.controller('adminCtrl', ['CrudCreator', '$scope', 'clientService', 'adminModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'client', 'Client');
            this.loadRefOptions();
            this.fetchRecords();
        }]);
})(window.angular);
