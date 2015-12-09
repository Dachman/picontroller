/**
 * Login page controller.
 */

var app = angular.module('picontrollerApp', []);
app.controller('loginController', function($scope, $http) {
	$scope.authenticate = function() {
		$http.post('/user/authenticate', {
			'userName' : $scope.user.userName,
			'password' : $scope.user.password
		}).success(function(response) {
			$scope.loginMessage="User " + response.userName + " authenticated";
			$scope.user.userName="";
			$scope.user.password="";
		}).error(function(response){
			$scope.loginMessage="Authentication failed for user " + $scope.user.userName + ".";
			$scope.user.password="";
		});
	}
});