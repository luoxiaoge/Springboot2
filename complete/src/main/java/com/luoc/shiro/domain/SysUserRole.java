package com.luoc.shiro.domain;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:25
 */
public class SysUserRole {

    private  Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
