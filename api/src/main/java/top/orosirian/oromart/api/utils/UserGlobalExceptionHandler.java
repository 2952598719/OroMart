package top.orosirian.oromart.api.utils;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.orosirian.oromart.common.BusinessException;
import top.orosirian.oromart.common.enums.ResultCode;
import top.orosirian.oromart.common.model.vo.ResponseVO;

@Slf4j
@RestControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseVO<Object> handleUserServiceException(BusinessException e) {
        log.warn("用户服务异常: {}", e.getMessage());
        return ResponseVO.error(e.getResultCode());
    }

    @ExceptionHandler(NotLoginException.class)
    public ResponseVO<Object> handleNotLoginException(NotLoginException e) {
        log.warn("登录异常: {}", e.getMessage());
        return ResponseVO.error(ResultCode.LOGIN_FAILED.getCode(), e.getMessage());
    }


}
