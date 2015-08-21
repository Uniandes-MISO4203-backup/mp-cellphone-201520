(function(ng){
    var mod = ng.module('cellPhoneModule');
    
    mod.service('cellPhoneService', ['CrudCreator','cellPhoneContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
