package top.orosirian.oromart.api.client;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.orosirian.oromart.common.model.dto.UserLoginDTO;
import top.orosirian.oromart.common.model.dto.UserRegisterDTO;
import top.orosirian.oromart.common.model.dto.UserResetPasswordDTO;
import top.orosirian.oromart.common.model.vo.ResultVO;
import top.orosirian.oromart.common.model.vo.UserVO;

@FeignClient("user")
public interface UserFeignClient {

    @PostMapping("/user/register")
    ResultVO<String> register(@Valid @RequestBody UserRegisterDTO dto);

    @PostMapping("/user/register/admin")
    ResultVO<String> registerAdmin(@Valid @RequestBody UserRegisterDTO dto);

    @PostMapping("/user/login")
    ResultVO<String> login(@Valid @RequestBody UserLoginDTO dto);

    @PostMapping("/user/logout")
    ResultVO<String> logout(@RequestParam String username);

    @PutMapping("/user/resetPassword")
    ResultVO<String> resetPassword(@Valid @RequestBody UserResetPasswordDTO dto);

    @GetMapping("/user/profile")
    ResultVO<UserVO> getProfile(@RequestParam String username);

}
