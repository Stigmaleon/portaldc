'use strict';

angular.module('portalDC', [
    'ngAnimate',
    'ngRoute',
    'ngCookies',
    'pascalprecht.translate',
    'ngWig',
    'ui.bootstrap',
    'portalDC.controllers',
    'portalDC.services',
    'portalDC.directives',
    'portalDC.factories'
])
    .config(['$routeProvider', function ($routeProvider) {

        $routeProvider
            .when('/home', {
                templateUrl: 'resources/html/home.html',
                controller: 'HomeCtrl'
            })
            .when('/create_distribution_film', {
                templateUrl: 'resources/html/createDistributionFilm.html',
                controller: 'CreateFilmCtrl'
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
