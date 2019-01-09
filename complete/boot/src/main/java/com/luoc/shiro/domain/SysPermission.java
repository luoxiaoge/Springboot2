package com.luoc.shiro.domain;

import org.springframework.data.annotation.Id;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:25
 */
public class SysPermission {

    @Id
    private  Long id;

    private  Long parentId;

    private  String resName;

    private  String resType;

    private  String permission;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
