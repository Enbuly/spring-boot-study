package com.example.mapper;

import com.example.model.User;
import com.example.request.SelectPasswordRequestVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Mapper
public interface UserMapper {

    @Select("SELECT password FROM user WHERE name=#{name}")
    String selectPasswordByUserName(String name);

    @Select("SELECT * FROM user")
    List<User> selectAllUser();

    @Select("select count(id) from user")
    int selectCount();

    /**
     * 用于测试if语句
     **/
    String selectPasswordByUserNameSecond(SelectPasswordRequestVo selectPasswordRequestVo);

}
