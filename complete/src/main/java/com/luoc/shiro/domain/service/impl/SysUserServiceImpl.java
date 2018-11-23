package com.luoc.shiro.domain.service.impl;

import com.luoc.shiro.domain.SysUser;
import com.luoc.shiro.domain.mapper.ShiroMapper;
import com.luoc.shiro.domain.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:55
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private ShiroMapper shiroMapper;

    @Override
    public SysUser findByUserName(String userName) {
        return shiroMapper.findByUserName(userName);
    }
}
