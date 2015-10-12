(function (ng) {
    var mod = ng.module('cellPhoneModule', ['ngCrud']);

    mod.constant('cellPhoneContext', 'products');
    mod.constant('cellPhoneModelContext', 'cellPhones');

    mod.constant('cellPhoneModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'description',
                displayName: 'Description',
                type: 'String',
                required: true,
                visible: false
            }, {
                name: 'imei',
                displayName: 'Imei',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'price',
                displayName: 'Price',
                type: 'Integer',
                required: true
            }, {
                name: 'discount',
                displayName: 'Discount',
                type: 'Integer',
                required: false
            }, {
                name: 'image',
                displayName: 'Image',
                type: 'String',
                required: true,
                visible: false
            }, {
                name: 'cellPhone',
                displayName: 'Model',
                type: 'Reference',
                service: 'cellPhoneModelService',
                options: [],
                required: false
            }, {
                name: 'category',
                displayName: 'Category',
                type: 'String',
                required: true,
                visible: false
            }]});
})(window.angular);
