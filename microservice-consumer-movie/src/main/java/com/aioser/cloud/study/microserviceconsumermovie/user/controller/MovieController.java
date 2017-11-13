package com.aioser.cloud.study.microserviceconsumermovie.user.controller;

import com.aioser.cloud.study.microserviceconsumermovie.user.entity.User;
import com.aioser.cloud.study.microserviceconsumermovie.user.feign.UserFeignClient;
import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {
    //========= 使用手动创建Feign
//    private UserFeignClient userUserFeignClient;
//
//    private UserFeignClient adminUserFeignClient;
//
//    @Autowired
//    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
//        // 这边的decoder、encoder、client、contract，可以debug看看是什么实例。
//        this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).
//                requestInterceptor(new BasicAuthRequestInterceptor("user", "password1")).
//                target(UserFeignClient.class, "http://microservice-provider-user");
//        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract).
//                requestInterceptor(new BasicAuthRequestInterceptor("admin", "password2")).
//                target(UserFeignClient.class, "http://microservice-provider-user");
//    }
//
//    @GetMapping("/user-user/{id}")
//    public User findByIdUser(@PathVariable Long id) {
//        return this.userUserFeignClient.findById(id);
//    }
//
//    @GetMapping("/user-admin/{id}")
//    public User findByIdAdmin(@PathVariable Long id) {
//        return this.adminUserFeignClient.findById(id);
//    }

    // ============ 使用RestTemplate
//    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
//
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;


//    @GetMapping("/user/{id}")
//    public User findById(@PathVariable Long id) {
//        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
//    }

//    @GetMapping("log-instance")
//    public void logUserInstance() {
//        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
//        //打印当前选择的节点
//        MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
//    }

    // =========== 使用Feign

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    /**
     * 测试URL：http://localhost:8010/user/get0?id=1&username=张三
     * 该请求不会成功。
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get0")
    public User get0(User user) {
        return this.userFeignClient.get0(user);
    }

    /**
     * 测试URL：http://localhost:8010/user/get1?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get1")
    public User get1(User user) {
        return this.userFeignClient.get1(user.getId(), user.getUsername());
    }

    /**
     * 测试URL：http://localhost:8010/user/get2?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/get2")
    public User get2(User user) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        return this.userFeignClient.get2(map);
    }

    /**
     * 测试URL:http://localhost:8010/user/post?id=1&username=张三
     * @param user user
     * @return 用户信息
     */
    @GetMapping("/user/post")
    public User post(User user) {
        return this.userFeignClient.post(user);
    }

}
