(function (ng) {
    var mod = ng.module('providerModule', ['ngCrud']);

    mod.constant('providerContext', 'providers');

    mod.constant('providerModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'givenName',
                displayName: 'Given Name',
                type: 'String',
                required: true,
                visible: false
            }, {
                name: 'surname',
                displayName: 'Surname',
                type: 'String',
                required: true,
                visible: false
            }, {
                name: 'email',
                displayName: 'Email',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'phone',
                displayName: 'Phone',
                type: 'String',
                required: true,
                visible: false
            }, {
                name: 'address',
                displayName: 'Address',
                type: 'String',
                required: true,
                visible: false
            }, {
                name: 'city',
                displayName: 'City',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'country',
                displayName: 'Country',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'userId',
                displayName: 'UserId',
                type: 'String',
                required: true,
                visible: false
            }, {
                name: 'calification',
                displayName: 'calification',
                type: 'Integer',
                required: true,
                visible: false
            }], 
        childs: [{
                name: 'products',
                displayName: 'Products',
                //template: '', //override generic template
                ctrl: 'productsCtrl'            }        ]});
})(window.angular);
