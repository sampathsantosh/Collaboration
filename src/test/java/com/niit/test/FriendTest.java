package com.niit.test;

/*import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


import com.niit.DAO.FriendDAO;
import com.niit.config.DbConfig;
import com.niit.model.Friend;

@ComponentScan("com.niit.")
public class FriendTest {
	
    static FriendDAO  friendDAO;
	
	@BeforeClass
	@Ignore
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.niit");
		context.refresh();

	    friendDAO=(FriendDAO)context.getBean("friendDAO");
	}

	@Ignore
	@Test
	public void saveFriend() {
		Friend friend = new Friend();
		friend.setFriendId(3);
		friend.setUsername("sunny");
		friend.setFriendname("sunil");
		friend.setStatus("R");
		assertTrue("problem in friend", friendDAO.createFriend(friend));
	}

	@Ignore
	@Test
	public void getAllFriendRequest() {
		List<Friend> listFriends = friendDAO.getAllFriendRequest("supraja");
		assertNotNull("problem in list friends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current username:::" + friend.getUsername());
			System.out.println("friend name::::" + friend.getFriendname());
			System.out.println("status::::" + friend.getStatus());
		}

	}
@Ignore
	@Test
	public void getFriendId() {
		Friend friend = (Friend) friendDAO.getFriend(3);
		assertNotNull("error", friend);
		System.out.println("friend status::::" + friend.getStatus());
	}
@Ignore
	@Test
	public void getAllApprovedFriendTest() {
		List<Friend> listFriends = friendDAO.getApprovedFriends("supraja");
		assertNotNull("problem in listFriends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current user name:::" + friend.getUsername());
			System.out.println("current friend name:" + friend.getFriendname());
			System.out.println("status:::" + friend.getStatus());
		}
	}
	@Ignore
	@Test
	public void approveFriendRequest()
	{
		Friend friend=friendDAO.getFriend(1);
		assertTrue("problem in approving",friendDAO.approveFriendRequest(friend));
	}
	@Ignore
	@Test
	public void rejectFriendRequest()
	{
		Friend friend=friendDAO.getFriend(5);
		assertTrue("problem in approving",friendDAO.rejectFriendRequest(friend));
	}
}*/