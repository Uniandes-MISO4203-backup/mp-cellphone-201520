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
                name: 'givenName',
                displayName: 'Given Name',
                type: 'String',
                required: true
            }, {
                name: 'surname',
                displayName: 'Surname',
                type: 'String',
                required: true
            }, {
                name: 'email',
                displayName: 'Email',
                type: 'String',
                required: true
            }, {
                name: 'phone',
                displayName: 'Phone',
                type: 'String',
                required: true
            }, {
                name: 'address',
                displayName: 'Address',
                type: 'String',
                required: true
            }, {
                name: 'city',
                displayName: 'City',
                type: 'String',
                required: true
            }, {
                name: 'country',
                displayName: 'Country',
                type: 'String',
                required: true
            }, {
                name: 'userId',
                displayName: 'UserId',
                type: 'String',
                required: true
            }, {
                name: 'calification',
                displayName: 'calification',
                type: 'Integer',
                required: false
            }], 
        childs: [{
                name: 'products',
                displayName: 'Products',
                //template: '', //override generic template
                ctrl: 'productsCtrl'            }        ]});
})(window.angular);
