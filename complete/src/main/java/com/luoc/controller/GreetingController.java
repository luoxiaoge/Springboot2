/*
package com.luoc.controller;

import java.util.concurrent.atomic.AtomicLong;


import com.alibaba.fastjson.JSON;
import com.luoc.annotation.Auth;
import com.luoc.mapper.UserMapper;
import com.luoc.mongDb.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @author Administrator
 *//*

@RestController
@Api(tags="测试接口模块")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private UserMapper mapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    @Auth(auth = true)
    @ApiOperation(value="测试信息", notes = "测试信息")
    @Transactional(noRollbackFor = Exception.class)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

           // int a =1/0;
        log.info("该用户信息:{}",JSON.toJSONString(mapper.findUserById(3)));
       // log.info(JSON.toJSONString(mongoTemplate.findAll(User.class)));
        return new Greeting(counter.incrementAndGet(),
                 String.format(template, name));
    }
}
*/
