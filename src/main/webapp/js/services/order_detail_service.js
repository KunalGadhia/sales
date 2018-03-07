/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("sales.services.order_detail", []);
angular.module("sales.services.order_detail")
        .factory('OrderDetailsService', function ($resource, restRoot, contextPath) {
            return $resource(restRoot + '/order_detail/:id', {'id': '@id'}, {
                
                'findByOrderHeadId': {
                    'method': 'GET',
                    'url': restRoot + '/order_detail/find_by/order_head',
                    'params': {
                        'orderHeadId': '@orderHeadId'
                    },
                    'isArray': true
                }
            });
        });
