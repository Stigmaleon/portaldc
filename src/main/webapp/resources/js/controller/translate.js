'use strict';

main.controller('TranslateCtrl', ['$scope', '$translate', function ($scope, $translate) {
    $scope.lang = $translate.proposedLanguage();

    $scope.changeLanguage = function (langName) {

        if (langName) {

            $translate.use(langName);
            $scope.lang = langName;

        }
    }
}]);
