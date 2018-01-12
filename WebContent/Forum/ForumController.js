myapp.controller("ForumController",function($scope,$http,$location,$rootScope)
{
		/*$scope.forum={forumId:" ",forumName:" ",forumContent:" ",createDate:"",likes:0,username:"",status:"A"}
		$scope.forum;
*/
	function fetchAllForum() {
		console.log("fetching all Forum");
		$http.get("http://localhost:8181/SocialCollaboration/getAllForums")

		.then(function(response) {
			$scope.forumdata = response.data;
			console.log("data fetched from Forum");
		});

	}
	;
	fetchAllForum();
	$scope.insertForum=function()
	{
	console.log('Entered into InsertForum');
	$http.post("http://localhost:8181/SocialCollaboration/insertForum", $scope.forum).then(function(response)
	{
	console.log('Successful Forum Entered');
    $location.path("/Forum");
    });
    }
		
		$scope.deleteBlog=function(blogId)
		{
			console.log('Entering to Delete Forum');
			$http.get('http://localhost:8181/SocialCollaboration/deleteForum/'+forumId)
			.success(fetchAllForum(),function(response)
					{
					console.log('Successful Deletion');
					$scope.refresh();
					$location.path("/Forum");
					});
		};
		
		$scope.editForum=function(forumId)
		{
			console.log('Entering to the edit Forum');
			$http.get('http://localhost:8181/SocialCollaboration/updateForum/'+forumId)
			.success(fetchAllForum(),function(response)
					{
					console.log('Editing');
					$scope.forum=response.data;
					console.log($scope.forum);
					$location.path("/Forum");
					});	
		};
		
		/*$scope.incrementLike=function(forumId)
		{
			console.log('Entering Increment Like');
			$http.get('http://localhost:8086/CollaborationBackend/incLike/'+forumId)
			.success(fetchAllForum(),function(response)
					{
					console.log('Forum Like Incremented');
					$location.path("/Forum");
					});
		}*/
});