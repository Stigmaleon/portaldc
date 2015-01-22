'use strict';

angular.module("portalDC.directives", [])
    .directive("headerTemplate", function() {
        return {
            restrict: 'E',
            templateUrl: '/resources/html/templates/header.html'
        }
    });
