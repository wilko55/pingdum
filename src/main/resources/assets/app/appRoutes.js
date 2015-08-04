angular.module('pingdumApp', [])

.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
                    controller: MainController,
                    templateUrl: 'homepage.html'
                })
        .otherwise({ redirectTo: '/'});
        });


