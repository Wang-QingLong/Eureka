package cn.itcast.feign;

import cn.itcast.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version V1.0
 * @author: WangQingLong
 * @date: 2019/12/13 19:34
 * @description:
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setNote("网络繁忙，请稍后重新刷新");
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
