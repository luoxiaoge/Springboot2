package com.luoc.hello;

import com.luoc.domain.User;
import com.luoc.mongDb.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @Time 16:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
     public void test() throws Exception {
        /*userRepository.save(new User("10010","luoc"));
        System.out.println(userRepository.findByUsernameLike("luoc"));*/
    }
}
