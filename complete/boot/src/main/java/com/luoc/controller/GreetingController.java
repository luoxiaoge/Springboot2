
package com.luoc.controller;

import java.util.concurrent.atomic.AtomicLong;


import com.alibaba.fastjson.JSON;
import com.luoc.mapper.UserMapper;
import com.luoc.mongDb.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Administrator
 */

@RestController
@RequestMapping("/a")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private UserMapper mapper;

/*    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;*/

    @GetMapping("/greeting")
   /* @Auth(auth = true)
    @Transactional(noRollbackFor = Exception.class)*/
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        // int a =1/0;
        log.info("该用户信息:{}",JSON.toJSONString(mapper.findUserById(3)));
        return new Greeting(counter.incrementAndGet(),
                 String.format(template, name));
    }
}

