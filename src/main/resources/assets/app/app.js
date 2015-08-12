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
    $http.get('api/').
        success(function (data, status, headers, config) {
            $scope.statusData = data;
        }).
        error(function (data, status, headers, config) {
            // log error
        });
});


pingdumApp.controller('StatusController', ['$scope', '$routeParams',
    function($scope, $routeParams) {
            $scope.name = $routeParams.api;
        $scope.weekData = [
            {time:'2015-08-05 10:55:12', httpCode:'200'},
            {time:'2015-08-04 10:55:12', httpCode:'404'},
            {time:'2015-08-03 10:55:12', httpCode:'200'},
            {time:'2015-08-02 10:55:12', httpCode:'500'},
            {time:'2015-08-01 10:55:12', httpCode:'200'},
            {time:'2015-07-31 10:55:12', httpCode:'200'},
            {time:'2015-07-30 10:55:12', httpCode:'200'},
        ]
    }]);