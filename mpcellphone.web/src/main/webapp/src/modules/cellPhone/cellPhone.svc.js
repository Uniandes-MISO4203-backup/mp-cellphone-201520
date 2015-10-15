(function(ng){
    var mod = ng.module('cellPhoneModule');
    mod.service('cellPhoneService', ['CrudCreator','cellPhoneContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
    mod.service('cellPhoneModelService', ['CrudCreator','cellPhoneModelContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
    mod.service('cellPhoneCityService', ['CrudCreator','cellPhoneCityContext', function(CrudCreator, context){
            CrudCreator.extendService(this, context);
    }]);
})(window.angular);
