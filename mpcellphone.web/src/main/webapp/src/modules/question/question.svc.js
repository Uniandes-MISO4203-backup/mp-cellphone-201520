(function(ng){
    var mod = ng.module('questionModule');
    mod.service('questionService', ['CrudCreator','questionContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
