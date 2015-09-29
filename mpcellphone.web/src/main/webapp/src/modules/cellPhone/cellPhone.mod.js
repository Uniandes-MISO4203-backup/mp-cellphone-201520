(function (ng) {
    var mod = ng.module('cellPhoneModule', ['ngCrud']);

    mod.constant('cellPhoneContext', 'cellPhones');

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
                name: 'model',
                displayName: 'Model',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'imei',
                displayName: 'Imei',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'brand',
                displayName: 'Brand',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'image',
                displayName: 'Image',
                type: 'String',
                required: false,
                visible: false
            }]});
})(window.angular);
