var pingdumApp = angular.module('pingdumApp', ['ngRoute']);

pingdumApp.config(function ($routeProvider) {
    $routeProvider
        .when('/',
        {
            controller: 'MainController',
            templateUrl: 'app/partials/homepage.html'
        })
        .when('/status/:api',
        {
            controller: 'StatusController',
            templateUrl: 'app/partials/status.html'
        })
        .otherwise({ redirectTo: '/'});
});

pingdumApp.controller('MainController', function($scope, $http) {
    $http.get('api/apilist').
        success(function (data, status, headers, config) {
            $scope.statusData = data;
        }).
        error(function (data, status, headers, config) {
            // log error
        });
});


pingdumApp.controller('StatusController',
    function($scope, $http) {
         $http.get('api/getCodes/2').
                success(function (data, status, headers, config) {
                    $scope.weekData = data;
                }).
                error(function (data, status, headers, config) {
                    // log error
                });
    });