'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/people', {
        templateUrl: 'peoples/layout',
        controller: PeopleController
    });
    $routeProvider.when('/company', {
        templateUrl: 'company/layout',
        controller: CompanyController
    });
    $routeProvider.otherwise({redirectTo: '/people'});
}]);
