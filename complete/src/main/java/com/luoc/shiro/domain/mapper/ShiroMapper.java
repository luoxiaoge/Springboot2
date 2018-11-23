package com.luoc.shiro.domain.mapper;

import com.luoc.shiro.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author luoc
 * @date 2018/11/21 0021
 * @Time 14:52
 */
@Mapper
public interface ShiroMapper {

    /**
     *   通过用户名查询用户信息
     * @param userName  用户名
     * @return
     */
     SysUser findByUserName(String userName);

    /**
     *   用户id查询权限
     * @param userId  用户id
     * @return
     */
     List<String>  selectPermissionByUserId(Long userId);
}
