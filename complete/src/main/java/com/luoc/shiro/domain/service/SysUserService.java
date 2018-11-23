package com.luoc.shiro.domain.service;

import com.luoc.shiro.domain.SysUser;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:55
 */
public interface SysUserService {

   /**
    *   用户名查找用户
    * @param UserName
    * @return
    */
   SysUser findByUserName(String UserName);
}
