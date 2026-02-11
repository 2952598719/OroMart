package top.orosirian.oromart.user.mappers;

import org.apache.ibatis.annotations.Mapper;
import top.orosirian.oromart.common.model.entity.User;

@Mapper
public interface UserMapper {

    void insertUser(String username, String password, Integer type);

    User selectByUsername(String username);

    boolean isUsernameExist(String username);

    boolean updatePassword(String username, String newPassword);

    int selectUserTypeById(Long userId);

}
