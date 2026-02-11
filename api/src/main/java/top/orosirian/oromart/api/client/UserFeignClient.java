package top.orosirian.oromart.api.client;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.common.model.dto.UserLoginDTO;
import top.orosirian.oromart.common.model.dto.UserRegisterDTO;
import top.orosirian.oromart.common.model.dto.UserResetPasswordDTO;
import top.orosirian.oromart.common.model.vo.ResponseVO;
import top.orosirian.oromart.common.model.vo.UserVO;

@FeignClient("user")
public interface UserFeignClient {

    @PostMapping("/user/register")
    ResponseVO<String> register(@Valid @RequestBody UserRegisterDTO dto);

    @PostMapping("/user/register/admin")
    ResponseVO<String> registerAdmin(@Valid @RequestBody UserRegisterDTO dto);

    @PostMapping("/user/login")
    ResponseVO<String> login(@Valid @RequestBody UserLoginDTO dto);

    @PostMapping("/user/logout")
    ResponseVO<String> logout(@RequestParam String username);

    @PutMapping("/user/resetPassword")
    ResponseVO<String> resetPassword(@Valid @RequestBody UserResetPasswordDTO dto);

    @GetMapping("/user/profile")
    ResponseVO<UserVO> getProfile(@RequestParam String username);

    @GetMapping("/user/type")
    Integer getUserType(@RequestParam Long userId);

}
