package com.tengxh.entity;

import java.io.Serializable;

/**
 * @ClassName: User.java
 * @Description: java类作用描述
 * @Author: tengxh
 * @CreateDate: 2018/8/4
 * @Version: 1.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = 5811262767465820785L;
    private Long userId;
    private String userName;
    private String address;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
