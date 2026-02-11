package top.orosirian.oromart.common.model.vo;

import lombok.Builder;
import lombok.Data;
import top.orosirian.oromart.common.enums.ResultCode;

@Data
@Builder
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;

    // 成功响应（无数据）
    public static <T> ResultVO<T> success() {
        return ResultVO.<T>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMessage())
                .build();
    }

    // 成功响应（有数据）
    public static <T> ResultVO<T> success(T data) {
        return ResultVO.<T>builder()
                .code(ResultCode.SUCCESS.getCode())
                .message(ResultCode.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    // 失败响应
    public static <T> ResultVO<T> error(ResultCode resultCode) {
        return ResultVO.<T>builder()
                .code(resultCode.getCode())
                .message(resultCode.getMessage())
                .build();
    }

    // 自定义失败响应
    public static <T> ResultVO<T> error(Integer code, String message) {
        return ResultVO.<T>builder()
                .code(code)
                .message(message)
                .build();
    }


}
