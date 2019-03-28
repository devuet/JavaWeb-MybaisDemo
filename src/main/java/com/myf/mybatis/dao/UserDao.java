package com.myf.mybatis.dao;

import com.myf.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /*
    *登录（直接使用注解指定传入参数名称）
    */
    public User login(@Param("username")String userName,@Param("password")String password);

    public List<User>queryUserByTableName(@Param("tableName")String tableName);

    public User queryUserById(String id);

    public List<User>queryUserAll();

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Long id);
}
