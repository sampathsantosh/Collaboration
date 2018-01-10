myapp.controller("jobsController", function($scope, $http, $location,$rootScope)
		{
	$scope.job={jobid:0,jobName:'',jobDesc:'',postedDate:'',lastDate:'',salary:0};
	$scope.listJobs;
	

	$scope.postJob=function()
	{
		console.log('Posting Job');
		
		$http.post('http://localhost:8181/SocialCollaboration/insertJob',$scope.job)
		.then(function(response)
				{
				console.log('Successfully Posted the Job');
				});
	}
	
	$scope.removeJob=function(jobId)
	{
		console.log('Deleting job');
		$http.get('http://localhost:8181/SocialCollaboration/deleteJob/'+jobId)
		.then(function(response)
				{
				console.log('Job Deleted');
				});
	}
	
	function fetchAllJobs()
	{
		$http.get('http://localhost:8181/SocialCollaboration/getAllJobs')
		.then(function(response)
				{
				$scope.jobsdata=response.data;
			console.log("all jobs fetched");
				});
	}
	
	fetchAllJobs();
});