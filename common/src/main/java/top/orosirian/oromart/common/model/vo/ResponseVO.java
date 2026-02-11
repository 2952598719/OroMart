package top.orosirian.oromart.common.model.vo;

import lombok.Builder;
import lombok.Data;
import top.orosirian.oromart.common.enums.ResultCode;

@Data
@Builder
public class ResponseVO<T> {

    private Integer code;

    private String message;

    private T data;

    // 成功响应（无数据）
    public static <T> ResponseVO<T> success() {
        return ResponseVO.<T>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMessage())
                .build();
    }

    // 成功响应（有数据）
    public static <T> ResponseVO<T> success(T data) {
        return ResponseVO.<T>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    // 失败响应
    public static <T> ResponseVO<T> error(ResultCode resultCode) {
        return ResponseVO.<T>builder()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .build();
    }

    // 自定义失败响应
    public static <T> ResponseVO<T> error(Integer code, String message) {
        return ResponseVO.<T>builder()
                .code(code)
                .message(message)
                .build();
    }


}
