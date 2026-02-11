package top.orosirian.oromart.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.api.client.UserFeignClient;
import top.orosirian.oromart.common.model.dto.UserLoginDTO;
import top.orosirian.oromart.common.model.dto.UserRegisterDTO;
import top.orosirian.oromart.common.model.dto.UserResetPasswordDTO;
import top.orosirian.oromart.common.model.vo.ResultVO;
import top.orosirian.oromart.common.model.vo.UserVO;

@RestController
public class UserController {

    @Autowired
    private UserFeignClient client;

    @PostMapping("/api/user/register")
    public ResultVO<String> register(@Valid @RequestBody UserRegisterDTO dto) {
        return client.register(dto);
    }

    @PostMapping("/api/user/register/admin")
    public ResultVO<String> registerAdmin(@Valid @RequestBody UserRegisterDTO dto) {
        return client.registerAdmin(dto);
    }

    @PostMapping("/api/user/login")
    public ResultVO<String> login(@Valid @RequestBody UserLoginDTO dto) {
        return client.login(dto);
    }

    @SaCheckLogin
    @PostMapping("/api/user/logout")
    public ResultVO<String> logout(@RequestParam String username) {
        return client.logout(username);
    }

    @SaCheckLogin
    @PutMapping("/api/user/resetPassword")
    public ResultVO<String> resetPassword(@Valid @RequestBody UserResetPasswordDTO dto) {
        return client.resetPassword(dto);
    }

    @SaCheckLogin
    @GetMapping("/api/user/profile")
    public ResultVO<UserVO> getProfile(@RequestParam String username) {
        return client.getProfile(username);
    }

}
