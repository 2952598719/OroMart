package top.orosirian.oromart.user.service;

import top.orosirian.oromart.common.enums.UserRole;
import top.orosirian.oromart.common.model.dto.UserLoginDTO;
import top.orosirian.oromart.common.model.dto.UserRegisterDTO;
import top.orosirian.oromart.common.model.dto.UserResetPasswordDTO;
import top.orosirian.oromart.common.model.vo.UserVO;

public interface UserService {

    void register(UserRegisterDTO dto, UserRole type);

    String login(UserLoginDTO dto);

    void logout(String username);

    void resetPassword(UserResetPasswordDTO dto);

    UserVO getProfile(String username);

    Integer getUserType(Long userId);

}
