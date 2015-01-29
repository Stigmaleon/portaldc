'use strict';

main.controller("CreateFilmCtrl", ['$scope', '$location', 'DistributionSrvc', function ($scope, $location, DistributionSrvc) {

    $scope.saveFilmDistribution = function () {

        $scope.film.link = null;
        DistributionSrvc.createFilmDistribution($scope.film)
            .then(function (response) {
                $location.path("/");
            }, function () {
                //add error message
            });
    };

}]);
