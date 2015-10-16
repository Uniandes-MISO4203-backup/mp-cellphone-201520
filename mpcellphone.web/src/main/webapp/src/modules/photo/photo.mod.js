(function (ng) {
    var mod = ng.module('photoModule', ['ngCrud']);

    mod.constant('photoContext', 'photos');

    mod.constant('photoModel', {
        fields: [{
                name: 'name',
                displayName: 'Name',
                type: 'String',
                required: true,
                visible: true
            }, {
                name: 'image',
                displayName: 'Image',
                type: 'String',
                required: true,
                visible: true
            }]});
})(window.angular);
