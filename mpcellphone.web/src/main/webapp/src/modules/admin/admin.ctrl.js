(function (ng) {
    var mod = ng.module('adminModule');
    mod.controller('adminCtrl', ['CrudCreator', '$scope', 'adminService', 'adminModel', '$location', 'authService', function (CrudCreator, $scope, svc, model, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'admin', 'All Users');
            if (authSvc.getCurrentUser())
            {
                var self = this;
                svc.darRole().then(function(data)
                {
                    if(data.role === "admin")
                    {
                         self.fetchRecords();
                    }
                    else
                    {
                         $location.path('/login');
                    }
                });
            }
            else
            {
                $location.path('/login');
            }
        }]);
})(window.angular);
