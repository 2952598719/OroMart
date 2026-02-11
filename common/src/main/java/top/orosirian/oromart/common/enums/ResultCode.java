package top.orosirian.oromart.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(0, "操作成功"),
    FAILED(1, "操作失败"),  // 通用失败

    // 网关10
    LOGIN_FAILED(100001, "登录失败"),
    // 用户11
    USER_ALREADY_EXISTS(110001, "用户已存在"),   // 注册
    USER_NOT_EXIST(110002, "用户不存在"),        // 登录
    USER_PASSWORD_ERROR(110003, "密码错误"),

    // 商品12
    PRODUCT_ALREADY_EXIST(120001, "商品已存在"),
    PRODUCT_NOT_EXIST(120002, "商品不存在"),

    // 订单13

    // 购物车14

    // 营销15

    ;


    private final Integer code;
    private final String message;

}
