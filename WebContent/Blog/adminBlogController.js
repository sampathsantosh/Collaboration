myapp.controller("adminBlogController", function($scope, $http, $location) {
	$scope.blog={blogId:0,blogName:'',blogContent:'',createDate:'',likes:0,username:'',status:'A'};
	$scope.blogdata;

	
	function fetchAllBlog() {
		console.log("fetching all Admin Blogs");
		$http.get("http://localhost:8181/SocialCollaboration/getAllBlogs")

		.then(function(response) {
			$scope.blogdata = response.data;
			console.log("data fetched from Admin blog");
		});

	};
	
   fetchAllBlog();
	$scope.approveBlog=function(blogId) 
	{
		console.log("entered in approve blog");
		$http.get('http://localhost:8181/SocialCollaboration/approveBlog/'+ blogId)
				.then(fetchAllBlog(), 
						function(response) 
		{
			console.log("Blog is approved");
		})
	}
	
	
	
	$scope.rejectBlog=function(blogId)
	{
	$http.get('http://localhost:8181/SocialCollaboration/rejectBlog/'+blogId)
	.then(fetchAllBlog(),function(response){
		console.log('blog rejected');
	})
	}
});