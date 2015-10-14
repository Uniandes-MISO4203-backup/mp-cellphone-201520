(function (ng) {
    var mod = ng.module('productModule', ['ngCrud']);

    mod.constant('productContext', 'products');

    mod.constant('productModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'price',
                displayName: 'Price',
                type: 'Integer',
                required: true,
                visible: true
            }, {
                name: 'discount',
                displayName: 'Discount',
                type: 'Integer',
                required: true,
                visible: true
            }, {
                name: 'category',
                displayName: 'Category',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'cellPhone',
                displayName: 'CellPhone',
                type: 'Reference',
                service: 'cellPhoneService',
                options: [],
                required: true,
                visible: true
            }]});
})(window.angular);
