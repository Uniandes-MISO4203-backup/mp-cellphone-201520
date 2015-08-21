(function (ng) {
    var mod = ng.module('clientModule', ['ngCrud']);

    mod.constant('clientContext', 'clients');

    mod.constant('clientModel', {
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
                name: 'shoppingCart',
                displayName: 'ShoppingCart',
                //template: '', //override generic template
                ctrl: 'shoppingCartCtrl'            }        ]});
})(window.angular);
