'use strict';

services.factory('DistributionSrvc', ['$http', function ($http) {
    var distributionSrvc = {};

    distributionSrvc.createFilmDistribution = function (film) {

        return $http({
            method: 'POST',
            url: '/rest/createFilmDistribution',
            data: film,
            headers: {'Content-Type': 'application/json'}
        })
            .success(function (data) {
                return data;
            })
    };

    return distributionSrvc;
}]);