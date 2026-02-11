package top.orosirian.oromart.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.common.enums.UserRole;
import top.orosirian.oromart.common.model.dto.UserLoginDTO;
import top.orosirian.oromart.common.model.dto.UserRegisterDTO;
import top.orosirian.oromart.common.model.dto.UserResetPasswordDTO;
import top.orosirian.oromart.common.model.vo.ResponseVO;
import top.orosirian.oromart.common.model.vo.UserVO;
import top.orosirian.oromart.user.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResponseVO<String> register(@Valid @RequestBody UserRegisterDTO dto) {
        userService.register(dto, UserRole.USER);
        return ResponseVO.success("注册成功");
    }

    @PostMapping("/user/register/admin")
    public ResponseVO<String> registerAdmin(@Valid @RequestBody UserRegisterDTO dto) {
        userService.register(dto, UserRole.ADMIN);
        return ResponseVO.success("注册成功");
    }

    @PostMapping("/user/login")
    public ResponseVO<String> login(@Valid @RequestBody UserLoginDTO dto) {
        return ResponseVO.success(userService.login(dto));
    }

    @PostMapping("/user/logout")
    public ResponseVO<String> logout(@RequestParam String username) {
        userService.logout(username);
        return ResponseVO.success("登出成功");
    }

    @PutMapping("/user/resetPassword")
    public ResponseVO<String> resetPassword(@Valid @RequestBody UserResetPasswordDTO dto) {
        userService.resetPassword(dto);
        return ResponseVO.success("重设成功");
    }

    @GetMapping("/user/profile")
    public ResponseVO<UserVO> getProfile(@RequestParam String username) {
        return ResponseVO.success(userService.getProfile(username));
    }

    @GetMapping("/user/type")
    public Integer getUserType(@RequestParam Long userId) {
        return userService.getUserType(userId);
    }

}
