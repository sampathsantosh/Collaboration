myapp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore)
{
	$scope.user={username:'',password:'',role:'',firstName:'',lastName:'',emailId:'',isOnline:''};
	$scope.allusers;
	
	function fetchAllUsers()
	{
		console.log("Fetching All Users");
		$http.get('http://localhost:8181/SocialCollaboration/getAllUsers')
		.then(function(response)
				{
					$scope.allusers=response.data;
				});
	};
	
	fetchAllUsers();
	
	$scope.registerUser=function()
	{
		console.log('Entered into registerUser');
		
		$http.post('http://localhost:8181/SocialCollaboration/register',$scope.user)
		.then(function(response)
				{
					console.log('Successfully Registered');
					$location.path("/login");
				});
	};
	
	$rootScope.login=function()
	{
		console.log("Logging Function");
		
		$http.post('http://localhost:8181/SocialCollaboration/login',$scope.user)
			.then(function(response)
			{
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('currentUser',response.data);
				console.log($rootScope.currentUser.role);
				$location.path("/UserHome");
			});
	};
	
	$rootScope.logout=function()
	{
		console.log('Logout Function');
		delete $rootScope.currentUser;
		$cookieStore.remove('currentUser');
		$location.path("/logout");
		
	}
	
	
});