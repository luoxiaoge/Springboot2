package com.luoc.mongDb;

import com.luoc.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @Time 16:54
 */

public interface UserRepository extends MongoRepository<User, Long> {

    /**
     *  模糊查询用户
     * @param userName
     * @return
     */
  User findByUserNameLike(String userName);



}
