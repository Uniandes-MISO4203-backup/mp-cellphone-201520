(function (ng) {
    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'authModule',
        'cartItemModule',
        'cellPhoneModule',
        'clientModule',
        'productModule',
        'providerModule',
        'ngRoute',
        'ngCrud',
        'xeditable',
        'paymentModule', 
        'adminModule'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
            console.log(tplUrl);
            $routeProvider
                    .when('/cellPhone', {
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
        editableOptions.theme = 'bs3'; // bootstrap3 theme. For Xeditable plugin Angular
    });
})(window.angular);
