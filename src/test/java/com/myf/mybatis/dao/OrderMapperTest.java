package com.myf.mybatis.dao;

import com.myf.mybatis.pojo.Order;
import com.myf.mybatis.pojo.OrderUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import sun.org.mozilla.javascript.internal.EcmaError;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrderMapperTest {
    OrderMapper orderMapper=null;
    @Before
    public void setUp() throws Exception {
        String resource="mybatis-config.xml";
        InputStream is= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        this.orderMapper=sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderUserByOrderNumber()throws Exception{
        String number="123";
       OrderUser user=this.orderMapper.queryOrderUserByOrderNumber(number);
        System.out.println(user);
    }

    @Test
    public void queryOrderWithUserByOrderNumber()throws Exception{
        Order order = orderMapper.queryOrderWithUserByOrderNumber("123");
        System.out.println(order.getUser());
    }

    @Test
    public void queryOrderWithUserAndDetailOrderNumber()throws Exception{
        Order order=orderMapper.queryOrderWithUserAndDetailOrderNumber("123");
        System.out.println(order.getUser());
        System.out.println(order.getDetailList());
    }

    @Test
    public void queryOrderWithUserAndDetailItemByOrderNumber()throws Exception{
        Order order=orderMapper.queryOrderWithUserAndDetailItemByOrderNumber("123");
        System.out.println(order);
        System.out.println(order.getUser());
        System.out.println(order.getDetailList());
    }

    @Test
    public void queryOrderAndUserByOrderNumberLazy()throws Exception{
        Order order=orderMapper.queryOrderAndUserByOrderNumberLazy("123");
        System.out.println(order.getOrderNumber());
        System.out.println("===========================");
        System.out.println(order.getUser());
    }
}