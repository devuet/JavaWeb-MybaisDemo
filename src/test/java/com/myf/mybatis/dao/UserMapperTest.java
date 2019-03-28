package com.myf.mybatis.dao;

import com.myf.mybatis.dao.impl.UserDaoImpl;
import com.myf.mybatis.pojo.User;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    public UserMapper userMapper;
    public SqlSession sqlSession;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        /*读取配置文件*/
        InputStream is= Resources.getResourceAsStream(resource);
        /*构建SqlSessionFactory*/
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        /*获取sqlSession*/
        sqlSession=sqlSessionFactory.openSession();
        this.userMapper=new UserDaoImpl(sqlSession);

    }

    @Test
    public void queryUserById() throws Exception {
        System.out.println(this.userMapper.queryUserById("1"));
    }

    @Test
    public void queryUserAll() throws Exception {
        List<User> userList = this.userMapper.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setAge(16);
        user.setBirthday(new Date("1990/09/02"));
        user.setName("大鹏");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("evan");
        this.userMapper.insertUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setName("静鹏");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("evanjin");
        user.setId("1");
        this.userMapper.updateUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() throws Exception {
        this.userMapper.deleteUser("4");
        this.sqlSession.commit();
    }

}