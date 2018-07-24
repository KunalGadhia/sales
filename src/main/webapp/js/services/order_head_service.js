/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("sales.services.order_head", []);
angular.module("sales.services.order_head")
        .factory('OrderHeadService', function ($resource, restRoot, contextPath) {
            return $resource(restRoot + '/order_head/:id', {'id': '@id'}, {
                
                'findOrderGenerationSource': {
                    'method': 'GET',
                    'url': restRoot + '/order_head/find/initiatedBy',
                    'params': {
                        'userId': '@userId'
                    },
                    'isArray': true
                },
                'findAllList': {
                    'method': 'GET',
                    'url': restRoot + '/order_head/find_all_list',                    
                    'isArray': true
                }
            });
        });




