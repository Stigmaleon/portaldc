(function() {
    'use strict';

    angular
        .module('portaldcApp')
        .controller('FilmDialogController', FilmDialogController);

    FilmDialogController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Film'];

    function FilmDialogController ($scope, $stateParams, $uibModalInstance, entity, Film) {
        var vm = this;
        vm.film = entity;
        vm.load = function(id) {
            Film.get({id : id}, function(result) {
                vm.film = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('portaldcApp:filmUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        };

        var onSaveError = function () {
            vm.isSaving = false;
        };

        vm.save = function () {
            vm.isSaving = true;
            if (vm.film.id !== null) {
                Film.update(vm.film, onSaveSuccess, onSaveError);
            } else {
                Film.save(vm.film, onSaveSuccess, onSaveError);
            }
        };

        vm.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };

        vm.datePickerOpenStatus = {};
        vm.datePickerOpenStatus.year = false;

        vm.openCalendar = function(date) {
            vm.datePickerOpenStatus[date] = true;
        };
    }
})();
