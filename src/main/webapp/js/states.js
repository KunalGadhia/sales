/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("sales.states", ['ngAnimate', 'ui.bootstrap'])
        .config(function ($stateProvider, templateRoot, $sceDelegateProvider) {
            $stateProvider.state('login', {
                'url': '/login',
                'templateUrl': templateRoot + '/login.html',
                'controller': 'LoginController'
            });
            $stateProvider.state('main', {
                'url': '/main',
                'templateUrl': templateRoot + '/main.html'
//                'controller': 'MainController'
            });
            $stateProvider.state('main.masters', {
                'url': '/masters',
                'templateUrl': templateRoot + '/masters/menu.html'
            });
            $sceDelegateProvider.resourceUrlWhitelist([
                'https://www.youtube.com/embed/**'
            ]);
        })
        .controller('LoginController', function ($scope, $state, $stateParams, $timeout, UserService, AuthFactory) {
            $scope.username = $stateParams.username;
            $scope.message = $stateParams.message;
            $scope.error = $stateParams.error;
            $timeout(function () {
                $scope.message = false;
            }, 3000);
            $scope.login = function (username, password) {
                console.log("Username :%O", username);
                UserService.login({
                    'username': username,
                    'password': password
                }, function (data) {
                    console.log("getting any data after login ?? %O", data);
                    AuthFactory.refresh();
                    UserService.findByUsername({
                        'username': data.username
                    }, function (data) {
                        if (data.role === "ROLE_ADMIN") {
                            $state.go("admin.masters");
                        } else if (data.role === "ROLE_EMPLOYEE") {
                            $state.go("admin.masters");
                        }
                    });
                }, function () {
                    $scope.error = true;
                    $scope.username = "";
                    $scope.password = "";
                });
            };
        });