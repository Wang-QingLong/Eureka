package cn.itcast.feign;

import cn.itcast.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @version V1.0
 * @author: WangQingLong
 * @date: 2019/12/13 18:12
 * @description:   声明今后请求的服务名称（service-id），注意抄的方法是service里面的方法
 */
@FeignClient(value = "user-service",fallback = UserFeignClientFallback.class,configuration = FeignLogger.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")    //声明请求服务的地址
    User findById(@PathVariable("id") Long id);

    @GetMapping("/user/all")
    List<User> findAll();
}
