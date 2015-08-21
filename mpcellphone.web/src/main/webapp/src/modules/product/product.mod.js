(function (ng) {
    var mod = ng.module('productModule', ['ngCrud']);

    mod.constant('productContext', 'products');

    mod.constant('productModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'price',
                displayName: 'Price',
                type: 'Integer',
                required: true
            }, {
                name: 'cellPhone',
                displayName: 'CellPhone',
                type: 'Reference',
                service: 'cellPhoneService',
                options: [],
                required: true
            }]});
})(window.angular);
