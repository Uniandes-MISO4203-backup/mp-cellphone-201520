(function (ng) {
    var mod = ng.module('adminModule', ['ngCrud']);

    mod.constant('adminContext', 'admin');

    mod.constant('adminModel', {
        fields: [{
                name: 'name',
                displayName: 'User name',
                type: 'String',
                required: true
            }, {
                name: 'email',
                displayName: 'E-mail',
                type: 'String',
                required: true
            }, 
             {
                name: 'role',
                displayName: 'Role',
                type: 'String',
                required: true
            }]
        })
})(window.angular);
