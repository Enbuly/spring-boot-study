package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT password FROM user WHERE name=#{name}")
    String selectPasswordByUserName(String name);

    @Select("SELECT * FROM user")
    List<User> selectAllUser();

    @Select("select count(id) from user")
    int selectCount();

}
