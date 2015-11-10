(function (ng){
    var mod = ng.module('securityModule');
    mod.controller('securityCtrl', ['CrudCreator', '$scope', 'clientService', 'providerService', '$location', 'authService', function (CrudCreator, $scope, svcC, svcP, $location, authSvc){
            CrudCreator.extendController(this, svcC,  $scope, model, 'client', 'Client');
            if (authSvc.getCurrentUser()){
                svcC.getRoleCl().then(function (data){
                    switch (data.role){
                        case "client":
                            clientPwd = record;
                            this.submitPasswordData = [{
                                    fn: function () {
                                        if (authSvc.getCurrentUser()) {
                                            if ($("#newPassword").val().length === 0) {
                                                alert("Please write new password");
                                            } else if ($("#rptPassword").val().length === 0) {
                                                alert("Please repeat password");
                                            } else if ($("#newPassword").val()!==$("#rptPassword").val()) {
                                                alert("Password doesn't match");
                                            } else {
                                                var objEnvia = {
                                                    password: $("#newPassword").val(),
                                                    client: authSvc.getCurrentUser()
                                                };
                                                svcC.savePasswordC(objEnvia).then(function () {
                                                    alert("Password has changed successfully");
                                                    $location.path('/#/catalog');
                                                });
                                            }
                                        } else {
                                            $location.path('/login');
                                        }
                                    }
                                }];
                            break;
                        case "provider":
                            this.submitPasswordData = [{
                                    fn: function () {
                                        if (authSvc.getCurrentUser()) {
                                            if ($("#newPassword").val().length === 0) {
                                                alert("Please write new password");
                                            } else if ($("#rptPassword").val().length === 0) {
                                                alert("Please repeat password");
                                            } else if ($("#newPassword").val()!==$("#rptPassword").val()) {
                                                alert("Password doesn't match");
                                            } else {
                                                var objEnvia = {
                                                    password: $("#newPassword").val(),
                                                    provider: authSvc.getCurrentUser()
                                                };
                                                svcP.savePasswordP(objEnvia).then(function () {
                                                    alert("La contraseña ha sido cambiada exitósamente");
                                                    $location.path('/#/catalog');
                                                });
                                            }
                                        } else {
                                            $location.path('/login');
                                        }
                                    }
                                }];
                            break;
                        default:
                            $location.path('/#/catalog');
                            break;
                    }
                });
            }
            else
            {
                $location.path('/login');
            }
        }]);
})(window.angular);
