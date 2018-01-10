myapp.controller("BlogController",function($scope,$http,$location,$rootScope)
{
		/*$scope.blog={blogId:" ",blogName:" ",blogContent:" ",createDate:"",likes:0,username:"",status:"A"}
		$scope.blog;
*/
	function fetchAllBlog() {
		console.log("fetching all blog");
		$http.get("http://localhost:8181/SocialCollaboration/getAllBlogs")

		.then(function(response) {
			$scope.blogdata = response.data;
			console.log("data fetched from blog");
		});

	}
	;
	fetchAllBlog();
		  	$scope.insertBlog=function()
		  	{
		  		console.log('Entered into InsertBlog');
		 		$http.post("http://localhost:8181/SocialCollaboration/insertBlog", $scope.blog).then(function(response)
		  				{
		  				console.log('Successful Blog Entered');
		  				$location.path("/Blog");
		  				});
		  	}
		
		$scope.deleteBlog=function(blogId)
		{
			console.log('Entering to Delete Blog');
			$http.get('http://localhost:8181/SocialCollaboration/deleteBlog/'+blogId)
			.success(fetchAllBlog(),function(response)
					{
					console.log('Successful Deletion');
					$scope.refresh();
					$location.path("/Blog");
					});
		};
		
		$scope.updateBlog=function(blogId)
		{
			console.log('Entering to the edit Blog');
			$http.get('http://localhost:8181/SocialCollaboration/updateBlog/'+blogId)
			.success(fetchAllBlog(),function(response)
					{
					console.log('Updating');
					$scope.blog=response.data;
					console.log($scope.blog);
					$location.path("/Blog");
					});	
		};
		
		$scope.incrementLike=function(blogId)
		{
			console.log('Entering Increment Like');
			$http.get('http://localhost:8181/SocialCollaboration/incLike/'+blogId)
			.success(fetchAllBlog(),function(response)
					{
					console.log('Blog Like Incremented');
					$location.path("/Blog");
					});
		}
});