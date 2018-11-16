package com.luoc.hello;

import com.alibaba.fastjson.JSON;
import com.luoc.domain.User;
import com.luoc.mongDb.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @Time 16:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private final static Logger logger =  LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
     public void test() throws Exception {
      //  userRepository.save(new User(1223,"123","root","root"));
        /**
         *  插入数据
         */
        mongoTemplate.insert(new User(1,"124","luoc","luoc"));
        mongoTemplate.insert(new User(2,"125","zouq","zouq"));
        mongoTemplate.insert(new User(3,"126","pz","pz"));


        //Criteria criteria = new Criteria();
        /*criteria.is()*/
        /**
         *  删除数据
         */
        User  user = mongoTemplate.findOne(Query.query(where("userId").is("124")),User.class);
        mongoTemplate.remove(user);
        /**
         *  更新数据
         */

        mongoTemplate.updateFirst(Query.query(where("userId").is("125")), Update.update("passWord","zouqq"),User.class);
        /**
         *  查询数据
         */
        logger.info("所有的集合数据:{}",JSON.toJSONString(mongoTemplate.findAll(User.class)));

    }
}
