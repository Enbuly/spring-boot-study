package com.example.impl;

import com.example.api.UserService;
import com.example.constant.ResultCode;
import com.example.exception.ServiceException;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.responseVo.PageResponseVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现
 *
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public String getPassword(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new ServiceException(ResultCode.PARAMETER_ERROR);
        }
        return userMapper.selectPasswordByUserName(name);
    }

    public PageResponseVo<User> findUserByPage(int currentPage, int pageSize) {
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<User> allItems = userMapper.selectAllUser();
        PageResponseVo<User> pageData = new
                PageResponseVo<>(currentPage, pageSize, (int) page.getTotal());
        pageData.setItems(allItems);
        return pageData;
    }
}
