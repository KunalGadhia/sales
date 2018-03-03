/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("sales.services.user", []);
angular.module("sales.services.user")
        .factory('UserService', function ($resource, restRoot, contextPath) {            
            return $resource(restRoot + '/user/:id', {'id': '@id'}, {
                'login': {
                    'method': 'POST',
                    'url': contextPath + '/access/login',
                    'params': {
                        'username': '@username',
                        'password': '@password'
                    }
                },
                'logout': {
                    'method': 'POST',
                    'url': contextPath + '/access/logout'
                },
                'findByNameLike': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/user_like',
                    'params': {
                        'username': '@username'
                    },
                    'isArray': true
                },                
                'findByUsername': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/username',
                    'params': {
                        'username': '@username'
                    },
                    'isArray': false
                },                
                'findByEmployeeId': {
                    'method': 'GET',
                    'url': restRoot + '/user/find/employeeId',
                    'params': {
                        'employeeId': '@employeeId'
                    },
                    'isArray': false
                }
            });
        });

