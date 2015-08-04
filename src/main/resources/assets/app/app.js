var pingdumApp = angular.module('pingdumApp', []);

//pingdumApp.config(function ($routeProvider) {
//    $routeProvider
//        .when('/',
//            {
//                controller: 'MainController',
//                templateUrl: 'views/partials/homepage.html'
//            })
//        .otherwise({ redirectTo: '/'});
//});

pingdumApp.controller('MainController', function($scope){
    $scope.statusData= [
        {id:1,api:'Google',status:'200'},
        {id:2,api:'Purple Booth',status:'500'},
        {id:3,api:'Life Event Verification',status:'200'}
    ];
});

