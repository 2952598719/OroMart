package top.orosirian.oromart.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.orosirian.oromart.common.enums.ResultCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    private ResultCode resultCode;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

}
