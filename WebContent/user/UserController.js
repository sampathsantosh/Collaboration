myapp.controller("userController", function($scope, $http, $location,$rootScope,$cookieStore) 
	{
	$scope.user={username:'',password:'',role:'',firstname:'',lastname:'',email:'',phone:'',isOnline:''};
	$scope.allusers;
	$scope.register=function()
	{
		console.log("enter register");
		$http.post("http://localhost:8181/SocialCollabaration/register",$scope.user)
		.then(function(response)
				{
					console.log("successfully registered");
					$location.path("/login");
				});
	}
	$scope.login=function()
	{
		console.log("login function");
		
		$http.post("http://localhost:8181/SocialCollabaration/login",$scope.currentuser)
		.then(function(response){
		/*	$scope.user=response.data;*/
			$scope.currentUser=response.data;
			$rootscope.currentUser=response.data;
			$cookieStore.put('user',response.data);
			console.log($rootScope.currentUser.role);
			$location.path("/index")
		},function(response){
            $scope.error=response.data
            $location.path('/login')
		});
	}
	function fetchAllUsers()
	{
		console.log("fetching all users");
		$http.get("http://localhost:8181/SocialCollabaration/getAllUsers")
		.then(function(response)
				{
					$scope.allusers=response.data;
				});
				};
				fetchAllUsers();
			
	$rootScope.logout=function()
	{
		console.log('logout function');
		delete $rootScope.currentUser;
		$cookieStore.remove('user');
	}
	});


