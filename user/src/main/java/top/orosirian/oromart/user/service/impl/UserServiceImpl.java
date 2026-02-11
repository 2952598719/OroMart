package top.orosirian.oromart.user.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.orosirian.oromart.common.BusinessException;
import top.orosirian.oromart.common.enums.ResultCode;
import top.orosirian.oromart.common.enums.UserRole;
import top.orosirian.oromart.common.model.dto.UserLoginDTO;
import top.orosirian.oromart.common.model.dto.UserRegisterDTO;
import top.orosirian.oromart.common.model.dto.UserResetPasswordDTO;
import top.orosirian.oromart.common.model.entity.User;
import top.orosirian.oromart.common.model.vo.UserVO;
import top.orosirian.oromart.user.service.UserService;
import top.orosirian.oromart.user.mappers.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    // 采用void+抛异常，而不是返回boolean来表示成功/失败
    // 对于增删改操作，INSERT会抛异常，但是DELETE/UPDATE需要根据返回值确定是否执行成功，进而决定是否抛异常

    @Autowired
    UserMapper userMapper;

    public void register(UserRegisterDTO dto, UserRole type) {
        if (userMapper.isUsernameExist(dto.getUsername())) {
            throw new BusinessException(ResultCode.USER_ALREADY_EXISTS);
        }
        String hashedPassword = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
        userMapper.insertUser(dto.getUsername(), hashedPassword, type.getCode());
    }

    public String login(UserLoginDTO dto) {
        User user = userMapper.selectByUsername(dto.getUsername());
        if (user == null) {
            throw new BusinessException(ResultCode.USER_NOT_EXIST);
        }
        if (!BCrypt.checkpw(dto.getPassword(), user.getPassword())) {
            throw new BusinessException(ResultCode.USER_PASSWORD_ERROR);
        }
        StpUtil.login(user.getUserId());
        return StpUtil.getTokenValue();
    }

    public void logout(String username) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new BusinessException(ResultCode.USER_NOT_EXIST);
        }
        StpUtil.logout(username);
    }

    public void resetPassword(UserResetPasswordDTO dto) {
        User user = userMapper.selectByUsername(dto.getUsername());
        if (user == null) {
            throw new BusinessException(ResultCode.USER_NOT_EXIST);
        }
        String hashedPassword = BCrypt.hashpw(dto.getNewPassword(), BCrypt.gensalt());
        userMapper.updatePassword(dto.getUsername(), hashedPassword);
    }

    public UserVO getProfile(String username) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new BusinessException(ResultCode.USER_NOT_EXIST);
        }
        return UserVO.of(user);
    }

    public Integer getUserType(Long userId) {
        return userMapper.selectUserTypeById(userId);
    }

}
