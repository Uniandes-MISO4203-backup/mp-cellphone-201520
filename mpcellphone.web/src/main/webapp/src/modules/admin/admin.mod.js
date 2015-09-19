(function (ng) {
    var mod = ng.module('adminModule', ['ngCrud']);
    mod.constant('adminContext', 'users/AllUsers');
    mod.constant('adminModel', {
        fields: [{
                name: 'name',
                displayName: 'User name',
                type: 'String',
                required: true
            }, {
                name: 'id',
                displayName: 'UserID',
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
