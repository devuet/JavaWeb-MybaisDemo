package com.myf.mybatis.dao.impl;

import com.myf.mybatis.dao.UserMapper;
import com.myf.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserMapper {
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }

    public User queryUserById(String id){
        return this.sqlSession.selectOne("MyUserMapper.queryUserById",id);
    }

    public List<User> queryUserAll(){
        return this.sqlSession.selectList("MyUserMapper.queryUserAll");
    }

    public void insertUser(User user){
        this.sqlSession.insert("MyUserMapper.insertUser",user);
    }

    public void updateUser(User user){
        this.sqlSession.update("MyUserMapper.updateUser",user);
    }

    public void deleteUser(String id){
        this.sqlSession.delete("MyUserMapper.deleteUser",id);
    }
}
