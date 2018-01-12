var myapp=angular.module("myApp",['ngRoute','ngCookies']);

myapp.config(function($routeProvider)
		{
			$routeProvider.when("#/",{templateUrl:"index.html"})
			              /*.when("/Userhome",{templateUrl:"user/UserHome.html"})*/
						  .when("/Blog",{templateUrl:"Blog/Blog.html"})
						  .when("/ViewBlog",{templateUrl:"Blog/ViewBlog.html"})
						  .when("/postblog",{templateUrl:"Blog/Blog.html"})
						  .when("/ViewForum",{templateUrl:"Forum/ViewForum.html"})
						  .when("/postforum",{templateUrl:"Forum/Forum.html"})
						  .when("/Forum",{templateUrl:"Forum/Foru m.html"})
						  .when("/adminBlog",{templateUrl:"Blog/AdminBlog.html"})
						  .when("/adminForum",{templateUrl:"Forum/adminForum.html"})
						  .when("/registration",{templateUrl:"user/registration.html"})
						  .when("/login",{templateUrl:"user/login.html"})
						  .when("/Userhome",{templateUrl:"user/UserHome.html"})
						  .when("/Friend",{templateUrl:"user/Friend.html"})
						  .when("/jobs",{templateUrl:"Job/jobs.html" })
						  .when('/Chat', {templateUrl : "Chat/Chat.html"})
        		          .when("/showjobs",{templateUrl:"Job/Showjobs.html"})	
						  .when("/ShowFriendRequest",{templateUrl:"Friend/ShowFriendRequest.html"})
						  .when("/ProfilePic",{templateUrl:"user/ProfilePic.html"})
						  .when("/logout",{templateUrl:"user/Logout.html"})
						  //.when("/Chat",{templateUrl:"Chat/Chat.html"});
			
		});

myapp.run(function($rootScope,$cookieStore)
		{
			console.log('I am in run function');
			
			console.log($rootScope.currentUser);
			
				if($rootScope.currentUser==undefined)
				{
				$rootScope.currentUser=$cookieStore.get('userDetails');
				}
				else
				{
				console.log($rootScope.currentUser.username);
				console.log($rootScope.currentUser.role);
				}
		});   