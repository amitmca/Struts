package com.tutorials4u.test;
import java.util.List;

import com.tutorials4u.dao.UserDao;
import com.tutorials4u.model.User;
 
public class TestMain {
    public static void main(String[] args) throws Exception
    {
        //Initialize dao
    	UserDao manager = new UserDao();
 
        //Create the SQLMapClient
       // SqlMapClient sqlmapClient = IbatisUtil.initateSqlMapClient();
         
        User user1=new User();
        user1.setUser_id(5);
        user1.setUsername("test1");
        user1.setPassword("test1");
        user1.setFirstName("testfirst1");
        user1.setLastName("testlastname1");
        user1.setPhone("8796154725");
        user1.setEmailId("tes1t@gmail.com");
        //Add the user
        //manager.insertUser(user1);
 
        //Fetch the user detail
        List<User> createdUser = manager.listUsers();
        
        for(User newuser : createdUser) {
        	System.out.println(newuser.getFirstName()+"\t"+newuser.getLastName());
        }
        
        //System.out.println(createdUser.getEmail());
 
        //Lets delete the user
        //manager.deleteUserById(1, sqlmapClient);
    }
}