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
                'templateUrl': templateRoot + '/masters/order/order_details.html',
                'controller': 'OrderDetailsController'
            });
        })
        .controller('OrderHeadController', function ($scope, $rootScope, UserService) {
            $scope.editableOrderHead = {};
            $scope.editableOrderHead.billingFloorNum = 0;
            $scope.showLift = false;
            $scope.user = $rootScope.currentUser;
            UserService.findByUsername({
                'username': $scope.user.username
            }, function (userObject) {
                $scope.notificationUserObject = userObject;
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
                console.log("Answer :%O", billingdeliverySame);
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
                    $scope.editableOrderHead.deliveryFloorNum = 0 ;
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
        })
        .controller('OrderDetailsController', function ($rootScope, $scope, UserService) {

        });