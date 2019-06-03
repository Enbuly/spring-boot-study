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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户服务实现
 *
 * @author lazy cat
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

    /**
     * propagation --事务传播行为
     * PROPAGATION_REQUIRED --如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
     * PROPAGATION_REQUIRES_NEW --创建一个新的事务，如果当前存在事务，则把当前事务挂起。
     * PROPAGATION_NOT_SUPPORTED --以非事务方式运行，如果当前存在事务，则把当前事务挂起。
     * PROPAGATION_NEVER --以非事务方式运行，如果当前存在事务，则抛出异常。
     * PROPAGATION_MANDATORY --如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
     * PROPAGATION_NESTED --如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，
     * 则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
     * <p>
     * isolation --事务隔离级别
     * ISOLATION_DEFAULT --这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是
     * ISOLATION_READ_UNCOMMITTED --该隔离级别表示一个事务可以读取另一个事务修改但还
     * 没有提交的数据。该级别不能防止脏读，不可重复读和幻读，因此很少使用该隔离级别。比如PostgreSQL实际上并没有此级别。
     * ISOLATION_READ_COMMITTED --该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止
     * 脏读，这也是大多数情况下的推荐值。
     * ISOLATION_REPEATABLE_READ --该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次
     * 返回的记录都相同。该级别可以防止脏读和不可重复读。
     * ISOLATION_SERIALIZABLE --所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级
     * 别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。
     * <p>
     * timeout --事务超时
     * <p>
     * rollbackFor --指定特定异常实例，遇到时数据回滚
     **/
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
            timeout = 36000, rollbackFor = Exception.class)
    public PageResponseVo<User> findUserByPage(int currentPage, int pageSize) {
        Page page = PageHelper.startPage(currentPage, pageSize);
        List<User> allItems = userMapper.selectAllUser();
        PageResponseVo<User> pageData = new
                PageResponseVo<>(currentPage, pageSize, (int) page.getTotal());
        pageData.setItems(allItems);
        //do something
        return pageData;
    }
}
