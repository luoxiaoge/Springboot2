package com.luoc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @time 9:46
 *
 */
@Document(collection = "user")
public class User {

    @Id
    private  Integer id;

    private  String userId;

    private String passWord;

    private  String userName;

    public User(Integer id, String userId,String userName, String passWord) {
        this.id = id;
        this.userId = userId;
        this.passWord = passWord;
        this.userName = userName;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
