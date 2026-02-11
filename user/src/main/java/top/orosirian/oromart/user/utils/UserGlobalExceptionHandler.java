package top.orosirian.oromart.user.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.orosirian.oromart.common.BusinessException;
import top.orosirian.oromart.common.model.vo.ResultVO;

@Slf4j
@RestControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResultVO<Object> handleUserServiceException(BusinessException e) {
        log.warn("用户服务异常: {}", e.getMessage());
        return ResultVO.error(e.getResultCode());
    }


}
