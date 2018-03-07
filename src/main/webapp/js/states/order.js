/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
angular.module("sales.states.order", [])
        .config(function ($stateProvider, templateRoot) {
            $stateProvider.state('admin.order_head', {
                'url': '/order_head',
                'templateUrl': templateRoot + '/masters/order/order_head.html',
                'controller': 'OrderHeadController'
            });
            $stateProvider.state('admin.order_details', {
                'url': '/:orderHeadId/order_details',
                'templateUrl': templateRoot + '/masters/order/order_detail.html',
                'controller': 'OrderDetailsController'
            });
        })
        .controller('OrderHeadController', function ($scope, $state, $rootScope, OrderHeadService, UserService) {
            $scope.editableOrderHead = {};
            $scope.editableOrderHead.billingFloorNum = 0;
            $scope.showLift = false;
            $scope.user = $rootScope.currentUser;
            UserService.findByUsername({
                'username': $scope.user.username
            }, function (userObject) {
                $scope.userObject = userObject;
            });
            $scope.editableOrderHead.orderDate = new Date();
            $scope.$watch('editableOrderHead.billingFloorNum', function (floorNum) {
                if (floorNum === 0) {
                    $scope.showLift = false;
                } else {
                    $scope.showLift = true;
                }
            });
            $scope.$watch('sameAsBilling', function (billingdeliverySame) {
                if (billingdeliverySame === true) {
                    $scope.editableOrderHead.deliveryFloorNum = $scope.editableOrderHead.billingFloorNum;
                    $scope.editableOrderHead.deliveryLift = $scope.editableOrderHead.billingLift;
                    $scope.editableOrderHead.deliveryAdd1 = $scope.editableOrderHead.billingAdd1;
                    $scope.editableOrderHead.deliveryAdd2 = $scope.editableOrderHead.billingAdd2;
                    $scope.editableOrderHead.deliveryAdd3 = $scope.editableOrderHead.billingAdd3;
                    $scope.editableOrderHead.deliveryPostalCode = $scope.editableOrderHead.billingPostalCode;
                    $scope.editableOrderHead.deliveryCity = $scope.editableOrderHead.billingCity;
                    $scope.editableOrderHead.deliveryState = $scope.editableOrderHead.billingState;
                } else if (billingdeliverySame === false) {
                    $scope.editableOrderHead.deliveryFloorNum = 0;
                    $scope.editableOrderHead.deliveryLift = '';
                    $scope.editableOrderHead.deliveryAdd1 = '';
                    $scope.editableOrderHead.deliveryAdd2 = '';
                    $scope.editableOrderHead.deliveryAdd3 = '';
                    $scope.editableOrderHead.deliveryPostalCode = '';
                    $scope.editableOrderHead.deliveryCity = '';
                    $scope.editableOrderHead.deliveryState = '';
                }
                ;
            });

            $scope.saveOrderHead = function (orderHead) {
                orderHead.createdBy = $scope.userObject.id;
                OrderHeadService.save(orderHead, function (orderH) {
                    $state.go('admin.order_details', {
                        'orderHeadId': orderH.id
                    }, {'reload': true});
                });
            };

        })
        .controller('OrderDetailsController', function ($state, OrderDetailsService, SkuStockService, OrderHeadService, $stateParams, $rootScope, $scope, UserService) {
            OrderHeadService.get({
                'id': $stateParams.orderHeadId
            }, function (orderHeadObject) {
                $scope.orderHeadObject = orderHeadObject;
            });

            $scope.searchSku = function (skuString) {
                return SkuStockService.findByNameLike({
                    'name': skuString
                }).$promise;
            };
            $scope.setSku = function (sku) {
                $scope.sku = sku.productName;
                $scope.skuObject = sku;
            };

            $scope.$watch('editableOrderDetail.quantity', function (productQuantity) {
                $scope.editableOrderDetail.price = ($scope.skuObject.price * productQuantity);
            });

            $scope.saveOrderDetail = function (editableOrderDetail) {
                editableOrderDetail.productId = $scope.skuObject.id;
                editableOrderDetail.productName = $scope.skuObject.productName;
                editableOrderDetail.productColor = $scope.skuObject.color;
                editableOrderDetail.orderHeadId = $stateParams.orderHeadId;                
                console.log("Order Detail Save Object :%O", editableOrderDetail);
                
                OrderDetailsService.save(editableOrderDetail, function (orderD) {
                    $state.go('admin.order_details', {
                        'orderHeadId' : $stateParams.orderHeadId
                    }, {'reload': true});
                });
            };

        });