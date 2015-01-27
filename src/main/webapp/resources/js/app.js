'use strict';

angular.module('portalDC', [
    'ngAnimate',
    'ngRoute',
    'ngCookies',
    'pascalprecht.translate',
    'portalDC.controllers',
    'portalDC.directives',
    'portalDC.factories'
])
    .config(['$routeProvider', function ($routeProvider) {

        $routeProvider
            .when('/home', {
                templateUrl: 'resources/html/home.html',
                controller: 'HomeCtrl'
            })
            .when('/create_distribution', {
                templateUrl: 'resources/html/createDistribution.html'
            })
            .otherwise({
                templateUrl: 'resources/html/home.html',
                controller: 'HomeCtrl'
            })
    }])
    .config(function ($translateProvider) {

        $translateProvider.preferredLanguage('ru')
        .useStaticFilesLoader({
            prefix: "/get_localization_message/",
            suffix: ""
        })
        .useLocalStorage();

    });
