(function (ng) {
    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'authModule',
        'cartItemModule',
        'cellPhoneModule',
        'clientModule',
        'productModule',
        'providerModule',
        'photoModule',
        'rateModule',
        'ngRoute',
        'ngCrud',
        'xeditable',
        'paymentModule',
        'questionModule',
        'adminModule',
        'orderQueryModule'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
            $routeProvider
                    .when('/cellPhone', {
                        //templateUrl: 'src/modules/cellPhone/cellphoneTmpl.html', //tplUrl, Se cambiar tplUrl por la nueva plantilla
                        templateUrl: tplUrl,
                        controller: 'cellPhoneCtrl',
                        controllerAs: alias
                    })
                    .when('/client', {
                        templateUrl: tplUrl,
                        controller: 'clientCtrl',
                        controllerAs: alias
                    }).when('/products', {
                templateUrl: tplUrl,
                controller: 'productsCtrl',
                controllerAs: alias
            }).when('/photo', {
                templateUrl: tplUrl,
                controller: 'photoCtrl',
                controllerAs: alias
            }).when('/provider', {
                templateUrl: tplUrl,
                controller: 'providerCtrl',
                controllerAs: alias
            }).when('/catalog', {
                templateUrl: 'src/modules/product/product.tpl.html',
                controller: 'productCtrl',
                controllerAs: 'ctrl'
            }).when('/shoppingCart', {
                templateUrl: 'src/modules/cartItem/templates/ShoppingCart.html',
                controller: 'cartItemCtrl',
                controllerAs: 'ctrl'
            }).when('/checkout', {
                templateUrl: 'src/modules/payment/templates/Checkout.html',
                controller: 'checkoutCtrl',
                controllerAs: 'ctrl'
            }).when('/admin', {
                templateUrl: tplUrl,
                controller: 'adminCtrl',
                controllerAs: alias
            }).when('/question', {
                templateUrl: 'src/modules/question/questions.tpl.html',
                controller: 'questionCtrl',
                controllerAs: alias
            }).when('/orderLists', {
                templateUrl: 'src/modules/orderQuery/templates/orderByRoleTmpl.html',
                controller: 'orderQueryCtrl'
            }).when('/viewDetail', {
                templateUrl: 'src/modules/orderQuery/templates/viewDetail.html',
                controller: 'orderQueryCtrl'
            }).when('/tracking', {
                templateUrl: 'src/modules/tracking/tracking.html',
                controller: 'trackingCtrl'
            }).otherwise('/catalog');
        }]);

    mainApp.config(['authServiceProvider', function (auth) {
            auth.setValues({
                apiUrl: 'users',
                successPath: '/catalog',
                loginPath: '/login',
                registerPath: '/register',
                logoutRedirect: '/login',
                loginURL: 'login',
                registerURL: 'register',
                logoutURL: 'logout',
                nameCookie: 'userCookie'
            });
        }]);

    mainApp.run(function (editableOptions) {
        // bootstrap3 theme. For Xeditable plugin Angular
        editableOptions.theme = 'bs3';
    });
})(window.angular);