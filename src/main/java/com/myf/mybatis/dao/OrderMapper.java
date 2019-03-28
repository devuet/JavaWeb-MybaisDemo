package com.myf.mybatis.dao;

import com.myf.mybatis.pojo.Order;
import com.myf.mybatis.pojo.OrderUser;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    public OrderUser queryOrderUserByOrderNumber(@Param("number")String number);

    /*
    根据订单号查询用户信息
    */
    public Order queryOrderWithUserByOrderNumber(@Param("number") String number);

    /*
    * 根据订单号查询订单用户的信息及订单详情
    * */
    public Order queryOrderWithUserAndDetailOrderNumber(@Param("number")String number);

    /*
    *根据订单号查询用户的信息及订单详情及订单详情对应的商品信息
    * */
    public Order queryOrderWithUserAndDetailItemByOrderNumber(@Param("number")String number);

    /*延迟加载*/
    public Order queryOrderAndUserByOrderNumberLazy(@Param("number")String number);
}
