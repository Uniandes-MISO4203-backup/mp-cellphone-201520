(function(ng){
    var mod = ng.module('photoModule');
    mod.service('photoService', ['CrudCreator','photoContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);