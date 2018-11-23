package com.luoc.shiro.domain.service.impl;

import com.luoc.shiro.domain.mapper.ShiroMapper;
import com.luoc.shiro.domain.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:56
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {


    @Autowired
    private ShiroMapper shiroMapper;

    @Override
    public List<String> selectPermissionByUserId(Long userId) {
          return  shiroMapper.selectPermissionByUserId(userId);
    }
}
