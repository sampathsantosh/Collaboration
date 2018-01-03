myapp.factory("userService", function($http) {
	var BASE_URL = "http://localhost:8181/SocialCollabaration/";
	var userService = {};

	userService.getAllUser = function() {
		return $http.get(BASE_URL + "/getAllUsers");
	}
});
