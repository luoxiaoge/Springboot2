package com.luoc.shiro.domain;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:25
 */
public class SySRolePermission {

    private  Long roleId;

    private Long permissionId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
