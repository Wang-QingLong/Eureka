package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @version V1.0
 * @author: WangQingLong
 * @date: 2019/12/13 20:20
 * @description:
 */
@EnableZuulProxy //开启Zuul的网关功能
@SpringBootApplication
@EnableDiscoveryClient  //开启客户端发现功能
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
