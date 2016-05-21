(function() {
    'use strict';

    angular
        .module('portaldcApp')
        .controller('FilmDialogController', FilmDialogController);

    FilmDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Film'];

    function FilmDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Film) {
        var vm = this;
        vm.film = entity;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

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
