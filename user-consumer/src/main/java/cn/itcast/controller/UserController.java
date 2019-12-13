package cn.itcast.controller;

import cn.itcast.feign.UserFeignClient;
import cn.itcast.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version V1.0
 * @author: WangQingLong
 * @date: 2019/12/13 18:35
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("consumer")
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("{id}")
   public User queryById(@PathVariable("id") Long id) {
        return userFeignClient.findById(id);
    }


    @GetMapping("all")
    List<User> findAll(){
        return userFeignClient.findAll();
    }

}
