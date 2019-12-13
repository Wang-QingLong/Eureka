package cn.itcast.service;

import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @author: WangQingLong
 * @date: 2019/12/12 17:29
 * @description:
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(long Id) {
        return userMapper.selectByPrimaryKey(Id);
    }

    public List<User> findall() {
        return userMapper.selectAll();
    }
}
