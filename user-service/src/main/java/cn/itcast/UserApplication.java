package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @version V1.0
 * @author: WangQingLong
 * @date: 2019/12/12 17:20
 * @description:
 */
@MapperScan("cn.itcast.mapper")
@SpringBootApplication
@EnableEurekaClient   //开启Eureka客户端发现功能开关机制 ，其实可以省略不写
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
