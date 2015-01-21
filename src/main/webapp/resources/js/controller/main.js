'use strict';

var main = angular.module('portalDC.controllers', []);

main.controller('AppCtrl',['$scope', '$rootScope', function($scope, $rootScope){

    $scope.init = function(){
        console.log("App Ctrl");
        console.log(main);
    }

}]);