(function (ng) {
    var mod = ng.module('cellPhoneModule', ['ngCrud']);

    mod.constant('cellPhoneContext', 'cellPhones');

    mod.constant('cellPhoneModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true
            }, {
                name: 'description',
                displayName: 'Description',
                type: 'String',
                required: true
            }, {
                name: 'model',
                displayName: 'Model',
                type: 'String',
                required: true
            }, {
                name: 'imei',
                displayName: 'Imei',
                type: 'String',
                required: true
            }, {
                name: 'brand',
                displayName: 'Brand',
                type: 'String',
                required: true
            }, {
                name: 'image',
                displayName: 'Image',
                type: 'String',
                required: false
            }]});
})(window.angular);
