package top.orosirian.oromart.user.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.common.enums.UserRole;
import top.orosirian.oromart.common.model.dto.UserLoginDTO;
import top.orosirian.oromart.common.model.dto.UserRegisterDTO;
import top.orosirian.oromart.common.model.dto.UserResetPasswordDTO;
import top.orosirian.oromart.common.model.vo.ResultVO;
import top.orosirian.oromart.common.model.vo.UserVO;
import top.orosirian.oromart.user.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public ResultVO<String> register(@Valid @RequestBody UserRegisterDTO dto) {
        userService.register(dto, UserRole.USER);
        return ResultVO.success("注册成功");
    }

    @PostMapping("/user/register/admin")
    public ResultVO<String> registerAdmin(@Valid @RequestBody UserRegisterDTO dto) {
        userService.register(dto, UserRole.USER);
        return ResultVO.success("注册成功");
    }

    @PostMapping("/user/login")
    public ResultVO<String> login(@Valid @RequestBody UserLoginDTO dto) {
        return ResultVO.success(userService.login(dto));
    }

    @PostMapping("/user/logout")
    public ResultVO<String> logout(@RequestParam String username) {
        userService.logout(username);
        return ResultVO.success("登出成功");
    }

    @PutMapping("/user/resetPassword")
    public ResultVO<String> resetPassword(@Valid @RequestBody UserResetPasswordDTO dto) {
        userService.resetPassword(dto);
        return ResultVO.success("重设成功");
    }

    @GetMapping("/user/profile")
    public ResultVO<UserVO> getProfile(@RequestParam String username) {
        return ResultVO.success(userService.getProfile(username));
    }

}
