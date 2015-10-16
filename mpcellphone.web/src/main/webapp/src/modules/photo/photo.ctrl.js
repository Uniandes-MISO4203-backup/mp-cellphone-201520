(function (ng) {
    var mod = ng.module('photoModule');
    mod.controller('photoCtrl', ['CrudCreator', '$scope', 'photoModel',
        function (CrudCreator, $scope, model){
            CrudCreator.extendCompChildCtrl(this, $scope, model, 'photos','product');
            this.fetchRecords();
            this.loadRefOptions();
         }]);
})(window.angular);
