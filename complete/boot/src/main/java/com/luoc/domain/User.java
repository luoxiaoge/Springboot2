package com.luoc.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @time 9:46
 *
 */
@Data
@Document(collection = "user")
public class User {

    @Id
    private  Integer id;

    private  String userId;

    private String passWord;

    private  String userName;

    private Date   date;

    public User(Integer id, String userId,String userName, String passWord) {
        this.id = id;
        this.userId = userId;
        this.passWord = passWord;
        this.userName = userName;
    }


}
