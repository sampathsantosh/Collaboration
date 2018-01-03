var myapp=angular.module("myApp",['ngRoute']);
myapp.config(function($routeProvider) {
    $routeProvider
      .when("#/",{templateUrl:"index.html"})
      
      .when("#/",{templateUrl:"home.html", 
    	  controller:"mainController"})
      
      
      .when("/Blog",{
    	  templateUrl:"Blog/Blog.html",
    	  controller:'BlogController'
    		  })
      
       .when("/forum",{
    	   templateUrl:"Forum/Forum.html",
    		   controller:'ForumController'   
       })
       
        .when("/adminBlog",{
         templateUrl:"Blog/AdminBlog.html",
   	     controller:'AdminBlogController'

         })
        
         
    .when("/login",{
    	
    	templateUrl:"user/login.html",
    	controller:'UserController'
    		
      })
     .when("/registration",{
    	 
    	 templateUrl:"user/registration.html",
    	 controller:'UserController'
    
})
});