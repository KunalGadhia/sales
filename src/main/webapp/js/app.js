angular.module("sales", [
    //    include libraries
    'ui.router',
    'ngResource',
    'angularFileUpload',
    'googlechart',
    'ngAnimate',
    'angular.filter',
    //'ngFileSaver',
    //  include filter
    'sales.filters',
    //  include constants
    'sales.constants',    
    'sales.services.user',
    // include controllers and states
    'sales.states',
    'sales.states.admin',
    'sales.states.auth',
    'sales.states.order'

])

        .run(['$state', '$rootScope', 'AuthFactory', '$location', 'UserService', function ($state, $rootScope, AuthFactory, $location, UserService) {                
                AuthFactory.registerUserChangeHandler(function (currentUser) {                    
                    $rootScope.currentUser = currentUser;
                });

                AuthFactory.refresh().then(function (currentUser) {                    
                }, function (reason) {
                    $location.path("login");
                });
            }]);
