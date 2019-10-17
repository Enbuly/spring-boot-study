package com.example.mapper;

import com.example.model.User;
import com.example.request.SelectPasswordRequestVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 用户mapper
 *
 * @author lazy cat
 * @since 2019-04-11
 **/
@Mapper
public interface UserMapper {

    /**
     * 根据用户名字查找用户密码
     *
     * @param name 用户名字
     * @return String 用户密码
     **/
    @Select("SELECT password FROM user WHERE name=#{name}")
    String selectPasswordByUserName(String name);

    /**
     * 查找所有用户
     *
     * @return List<User> 用户列表
     **/
    @Select("SELECT * FROM user")
    List<User> selectAllUser();

    /**
     * 根据用户名电话查找密码(用于测试xml的if语句)
     *
     * @param selectPasswordRequestVo 查找密码请求包
     * @return String 密码
     **/
    String selectPasswordByUserNameSecond(SelectPasswordRequestVo selectPasswordRequestVo);

    /**
     * 查询所有的用户信息，返回map类型
     **/
    @MapKey("id")
    Map<Integer, User> select();

}
