package mapper;

import domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @time 9:44
 */
@Mapper
public interface UserMapper {
    /**
     * @param id 用户id
     * @return 返回用户
     */
    User findUserById(Integer id);
}
