package top.orosirian.oromart.api.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.api.client.UserFeignClient;
import top.orosirian.oromart.common.model.dto.UserLoginDTO;
import top.orosirian.oromart.common.model.dto.UserRegisterDTO;
import top.orosirian.oromart.common.model.dto.UserResetPasswordDTO;
import top.orosirian.oromart.common.model.vo.ResponseVO;
import top.orosirian.oromart.common.model.vo.UserVO;

@RestController
public class UserController {

    @Autowired
    private UserFeignClient client;

    @PostMapping("/api/user/register")
    public ResponseVO<String> register(@Valid @RequestBody UserRegisterDTO dto) {
        return client.register(dto);
    }

    @PostMapping("/api/user/register/admin")
    public ResponseVO<String> registerAdmin(@Valid @RequestBody UserRegisterDTO dto) {
        return client.registerAdmin(dto);
    }

    @PostMapping("/api/user/login")
    public ResponseVO<String> login(@Valid @RequestBody UserLoginDTO dto) {
        return client.login(dto);
    }

    @SaCheckLogin
    @PostMapping("/api/user/logout")
    public ResponseVO<String> logout(@RequestParam String username) {
        return client.logout(username);
    }

    @SaCheckLogin
    @PutMapping("/api/user/resetPassword")
    public ResponseVO<String> resetPassword(@Valid @RequestBody UserResetPasswordDTO dto) {
        return client.resetPassword(dto);
    }

    @SaCheckLogin
    @GetMapping("/api/user/profile")
    public ResponseVO<UserVO> getProfile(@RequestParam String username) {
        return client.getProfile(username);
    }

}
