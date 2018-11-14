package com.luoc.mapper;

import com.luoc.domain.User;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @time 9:44
 */
@Mapper
public interface UserMapper {
    /**
     *  查询用户
     * @param id 用户id
     * @return 返回用户
     */
    User findUserById(Integer id);
}
