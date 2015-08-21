(function (ng) {
    var mod = ng.module('providerModule', ['ngCrud']);

    mod.constant('providerContext', 'providers');

    mod.constant('providerModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'userId',
                displayName: 'UserId',
                type: 'String',
                required: true
            }], 
        childs: [{
                name: 'products',
                displayName: 'Products',
                //template: '', //override generic template
                ctrl: 'productsCtrl'            }        ]});
})(window.angular);
