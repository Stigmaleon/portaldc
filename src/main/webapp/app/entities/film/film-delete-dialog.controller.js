(function() {
    'use strict';

    angular
        .module('portaldcApp')
        .controller('FilmDeleteController',FilmDeleteController);

    FilmDeleteController.$inject = ['$uibModalInstance', 'entity', 'Film'];

    function FilmDeleteController($uibModalInstance, entity, Film) {
        var vm = this;
        vm.film = entity;
        vm.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        vm.confirmDelete = function (id) {
            Film.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };
    }
})();
