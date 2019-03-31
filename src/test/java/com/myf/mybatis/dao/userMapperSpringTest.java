package com.myf.mybatis.dao;

import com.myf.mybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:spring/applicationContext-*.xml" )
public class userMapperSpringTest {

    @Autowired
    private UserDao userMapper;

    @Test
    public void testQueryUserById(){
        System.out.println(this.userMapper.queryUserById("1"));
    }

    @Test
    public void testQueryUserAll(){
        List<User> userList=this.userMapper.queryUserAll();
        for(User user:userList){
            System.out.println(user);
        }
    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("dashen");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("bigGod222");
        this.userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        User user=new User();
        user.setBirthday(new Date());
        user.setName("jingj");
        user.setPassword("123456");
        user.setSex(0);
        user.setId("1");
        this.userMapper.updateUser(user);
    }
}
