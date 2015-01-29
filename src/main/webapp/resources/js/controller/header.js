'use strict';

main.controller('HeaderCtrl', ['$scope', '$modal', '$location', function ($scope, $modal, $location) {

    $scope.selectedType = 'isAudio';

    $scope.openDialogCreateDistribution = function () {

        $scope.modalCreateDistr = $modal.open(
            {
                scope: $scope,
                size: 'md',
                templateUrl: 'resources/html/templates/modalCreateDistr.html',
                show: true
            }
        );
    };

    $scope.closeDialogCreateDistribution = function() {
        $scope.modalCreateDistr.close();
    };

    $scope.redirectCreateDistribution = function() {
        $scope.modalCreateDistr.close();
        if ($scope.selectedType == 'isFilm')
            $location.path("/create_distribution_film")
    };

}]);