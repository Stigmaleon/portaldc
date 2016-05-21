(function() {
    'use strict';
    angular
        .module('portaldcApp')
        .factory('Film', Film);

    Film.$inject = ['$resource', 'DateUtils'];

    function Film ($resource, DateUtils) {
        var resourceUrl =  'api/films/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.year = DateUtils.convertLocalDateFromServer(data.year);
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    data.year = DateUtils.convertLocalDateToServer(data.year);
                    return angular.toJson(data);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    data.year = DateUtils.convertLocalDateToServer(data.year);
                    return angular.toJson(data);
                }
            }
        });
    }
})();
