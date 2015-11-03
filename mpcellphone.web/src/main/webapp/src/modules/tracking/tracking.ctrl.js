(function (ng) {
    var mod = ng.module('mainApp');
    mod.controller('trackingCtrl', ['CrudCreator', '$scope', 'authService', '$location', '$log',
        function (CrudCreator, $scope, authSvc, $location, $log) {
            window.initMap = function () {
                map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: -34.397, lng: 150.644},
                    zoom: 8
                });
                var marker = new google.maps.Marker({
                    position: {lat: -34.397, lng: 150.644},
                    map: map,
                    title: 'Hello World!'
                });
            }
        }]);
})(window.angular);



