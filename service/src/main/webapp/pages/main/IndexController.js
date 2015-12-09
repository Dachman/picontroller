/**
 * Index page controller.
 */

var app = angular.module('picontrollerApp', []);
app
		.controller(
				'indexController',
				function($scope, $interval, $http) {

					// Get authenticated user
					$http.get('/user/authenticated').success(
							function(response) {
								$scope.authenticatedUser = response.userName;
							}).error(function(response) {
						$scope.authenticatedUser = 'none';
					});

					$interval(
							function() {
								// Get application status

								$http
										.get('/healthCheck')
										.success(
												function(response) {
													$scope.healthCheckStatus = response.status;
												})
										.error(
												function(response) {
													try {
														$scope.healthCheckStatus = response.status;
													} catch (error) {
														$scope.healthCheckStatus = "Not accessible or not responding.";
													}

												});
							}, 3000);
				});