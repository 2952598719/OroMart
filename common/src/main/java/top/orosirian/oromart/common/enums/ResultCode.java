package top.orosirian.oromart.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(0, "操作成功"),
    FAILED(1, "操作失败"),  // 通用失败
    // 网关10

    // 用户11
    USER_ALREADY_EXISTS(110001, "用户已存在"),   // 注册
    USER_NOT_EXIST(110002, "用户不存在"),        // 登录
    USER_PASSWORD_ERROR(110003, "密码错误"),

    // 商品12

    // 订单13

    // 营销14

    ;


    private final Integer code;
    private final String message;

}
