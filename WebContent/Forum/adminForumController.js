myapp.controller("adminForumController", function($scope, $http, $location) {
	$scope.forum={forumId:0,forumName:'',bforumContent:'',createDate:'',likes:0,username:'',status:'A'};
	$scope.forumdata;

	
	function fetchAllForum() {
		console.log("fetching all Admin Forums");
		$http.get("http://localhost:8181/SocialCollaboration/getAllForums")

		.then(function(response) {
			$scope.forumdata = response.data;
			console.log("data fetched from Admin Forum");
		});

	};
	
   fetchAllForum();
	$scope.approveForum=function(forumId) 
	{
		console.log("entered in approve Forum");
		$http.get('http://localhost:8181/SocialCollaboration/approveForum/'+ forumId)
				.then(fetchAllForum(), 
						function(response) 
		{
			console.log("Forum is approved");
		})
	}
	
	
	
	$scope.rejectForum=function(forumId)
	{
	$http.get('http://localhost:8181/SocialCollaboration/rejectBForum/'+forumId)
	.then(fetchAllForum(),function(response){
		console.log('Forum rejected');
	})
	}
});