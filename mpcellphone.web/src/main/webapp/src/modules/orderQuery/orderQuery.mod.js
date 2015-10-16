(function (ng) {
    var mod = ng.module('orderQueryModule', ['ngCrud']);
    mod.constant('orderQueryContext', 'clients');
    mod.constant('orderQueryModel', {
        fields: [{
                name: 'clientName',
                displayName: 'Client Name',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'providerName',
                displayName: 'Provider Name',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'orderId',
                displayName: 'Order ID',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'dateOrder',
                displayName: 'Date Order',
                type: 'Date',
                required: true,
                visible: true
            }, {
                name: 'totalSale',
                displayName: 'Total Sale',
                type: 'Integer',
                required: true,
                visible: true
            }, {
                name: 'stateOrder',
                displayName: 'State Order',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'card',
                displayName: 'Card Number',
                type: 'String',
                required: true,
                visible: false
            }, {
                name: 'bank',
                displayName: 'Bank',
                type: 'String',
                required: true,
                visible: false
            }],
        childs: [{
                name: 'shoppingCart',
                displayName: 'ShoppingCart',
                //template: '', //override generic template
                ctrl: 'shoppingCartCtrl' }   ]});
})(window.angular);