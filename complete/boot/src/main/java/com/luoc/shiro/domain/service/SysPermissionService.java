package com.luoc.shiro.domain.service;

import java.util.List;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:55
 */
public interface SysPermissionService {

    /**
     *  用户id 查询用户权限
     * @param userId  用户id
     * @return
     */
   List<String> selectPermissionByUserId(Long userId);
}
