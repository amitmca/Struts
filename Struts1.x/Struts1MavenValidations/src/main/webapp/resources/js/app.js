/**
 * Created by Sandeep on 01/06/14.
 */

angular.module('movieApp',['ui.router','ngResource','movieApp.controllers','movieApp.services']);

angular.module('movieApp').config(function($stateProvider,$httpProvider){
    $stateProvider.state('movies',{
        url:'/movies',
        templateUrl:'resources/template/movies.html',
        controller:'MovieListController'
    }).state('viewMovie',{
       url:'/movies/:id/view',
       templateUrl:'resources/template/movie-view.html',
       controller:'MovieViewController'
    }).state('newMovie',{
        url:'/movies/new',
        templateUrl:'resources/template/movie-add.html',
        controller:'MovieCreateController'
    }).state('editMovie',{
        url:'/movies/:id/edit',
        templateUrl:'resources/template/movie-edit.html',
        controller:'MovieEditController'
    });
}).run(function($state){
   $state.go('movies');
});