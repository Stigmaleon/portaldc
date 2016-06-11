(function() {
    'use strict';

    angular
        .module('portaldcApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('film', {
            parent: 'entity',
            url: '/film?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'portaldcApp.film.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/film/films.html',
                    controller: 'FilmController',
                    controllerAs: 'vm'
                }
            },
            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                },
                search: null
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort),
                        search: $stateParams.search
                    };
                }],
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('film');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('film-detail', {
            parent: 'entity',
            url: '/film/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'portaldcApp.film.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/film/film-detail.html',
                    controller: 'FilmDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('film');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Film', function($stateParams, Film) {
                    return Film.get({id : $stateParams.id}).$promise;
                }]
            }
        })
        .state('film.new', {
            parent: 'film',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/film/film-dialog.html',
                    controller: 'FilmDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                year: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('film', null, { reload: true });
                }, function() {
                    $state.go('film');
                });
            }]
        })
        .state('film.edit', {
            parent: 'film',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/film/film-dialog.html',
                    controller: 'FilmDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Film', function(Film) {
                            return Film.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('film', null, { reload: true });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('film.delete', {
            parent: 'film',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/film/film-delete-dialog.html',
                    controller: 'FilmDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Film', function(Film) {
                            return Film.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('film', null, { reload: true });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
