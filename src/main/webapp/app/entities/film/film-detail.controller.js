(function() {
    'use strict';

    angular
        .module('portaldcApp')
        .controller('FilmDetailController', FilmDetailController);

    FilmDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'entity', 'Film'];

    function FilmDetailController($scope, $rootScope, $stateParams, entity, Film) {
        var vm = this;
        vm.film = entity;
        vm.load = function (id) {
            Film.get({id: id}, function(result) {
                vm.film = result;
            });
        };
        var unsubscribe = $rootScope.$on('portaldcApp:filmUpdate', function(event, result) {
            vm.film = result;
        });
        $scope.$on('$destroy', unsubscribe);

    }
})();
