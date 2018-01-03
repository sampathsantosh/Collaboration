myapp.controller("BlogController",function($scope,$http,$location,$rootScope)
		
		{
		$scope.blog={blogId:'',blogName:'',blogContent:'',createDate:'',likes:0,username:'',status:"NA"}
		$scope.blog;

	var BASE_URL='http://localhost:8181/SocialCollaboration'
	$scope.insertBlog=function()
	{
		console.log('Entered into InsertBlog');
		$http.post(BASE_URL+"/insertBlog", $scope.blog).then(function(response)
				{
				console.log('Successful Blog Entered');
				});
	}

	
	$http.get("http://localhost:8181/SocialCollaboration/getAllBlogs")
	.then(function(response)
	{
		$scope.blogdata=response.data;
	});

	
	
});


myapp.controller("BlogController", function($scope, $http, $location) {
	function fetchAllBlog() {
		console.log("Fetching all blogs");
		$http.get("http://localhost:8181/SocialCollaboration/getAllBlogs")

		.then(function(response) {
			$scope.blogdata = response.data;
			console.log("Blog fetched");
		});
	}
	;
	$scope.deleteBlog = function(blogId) {
		console.log("entering in delete blog");
		$http.get("http://localhost:8181/SocialCollaboration/deleteBlog/"+ blogId)
				.success(fetchAllBlog(), function(response) {
			console.log('successful deletion');
			$scope.refresh();
			$location.path("/blog");

		});
	};
	$scope.likeBlog=function(blogId)
	{
		console.log("enterd into like ");
		$http.get('http://localhost:8181/SocialCollaboration/incLike/'+ blogId)
		.success(fetchAllBlog(),function(response)
				{
				console.log("like incremented")
				$scope.refresh();
				$location.path("/blog");
				});
	};
});