(function() {
    'use strict';

    angular
        .module('portaldcApp')
        .controller('FilmDetailController', FilmDetailController);

    FilmDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'entity', 'Film'];

    function FilmDetailController($scope, $rootScope, $stateParams, entity, Film) {
        var vm = this;
        vm.film = entity;
        
        var unsubscribe = $rootScope.$on('portaldcApp:filmUpdate', function(event, result) {
            vm.film = result;
        });
        $scope.$on('$destroy', unsubscribe);

    }
})();
