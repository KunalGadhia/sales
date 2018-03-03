angular.module("sales", [
    //    include libraries
    'ui.router',
    'ngResource',
    'angularFileUpload',
    'googlechart',
//    'safedeals.map',
    'ngAnimate',
    'angular.filter',
    //'ngFileSaver',
    //  include filter
    'sales.filters',
    //  include constants
    'sales.constants',    
//    'safedeals.services.branch',
    'sales.services.user',
//    'stars.services.employee',
//    'stars.services.kra_details',
//    'stars.services.form2_details',
//    'stars.services.additional_details',
//    'stars.services.company',
    // include controllers and states
    'sales.states',
//    'stars.states.admin',
//    'stars.states.user',
//    'stars.states.kra',
//    'stars.states.profile',
//    'stars.states.evaluate',
//    'stars.states.admin_menu',
//    'stars.states.reports',
//    'stars.states.employee',
//    'stars.states.hr_menu',
    'sales.states.auth'

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
