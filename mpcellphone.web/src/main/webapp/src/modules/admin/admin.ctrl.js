(function (ng) {
    var mod = ng.module('adminModule');

    mod.controller('adminCtrl', ['CrudCreator', '$scope', 'adminService', 'adminModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'admin', 'All Users');
            this.fetchRecords();
        }]);

    
})(window.angular);
