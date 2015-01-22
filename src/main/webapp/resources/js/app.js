'use strict';

angular.module('portalDC', [
    'ngRoute',
    'portalDC.controllers',
    'portalDC.directives'
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
    }]);
