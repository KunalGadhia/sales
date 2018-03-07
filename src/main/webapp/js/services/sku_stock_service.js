/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("sales.services.sku_stock", []);
angular.module("sales.services.sku_stock")
        .factory('SkuStockService', function ($resource, restRoot, contextPath) {            
            return $resource(restRoot + '/sku_stock/:id', {'id': '@id'}, {
                
                'findByNameLike': {
                    'method': 'GET',
                    'url': restRoot + '/sku_stock/find/name_like',
                    'params': {
                        'name': '@name'
                    },
                    'isArray': true
                },
                'findAllList': {
                    'method': 'GET',
                    'url': restRoot + '/sku_stock/find_all_list',                    
                    'isArray': true
                },
                'findByName': {
                    'method': 'GET',
                    'url': restRoot + '/sku_stock/find/name',
                    'params': {
                        'name': '@name'
                    },
                    'isArray': false
                }
            });
        });




