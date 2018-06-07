package cn.kr.exceptions;

import cn.kr.model.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author Administrator
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFindUserException.class)
    public Result noFindUserExceptionHandler() {
        return Result.fail(Result.NO_USER);
    }

    @ExceptionHandler(GeneralException.class)
    public Result generalExceptionHandler(GeneralException e) {
        return Result.fail(e.getCode());
    }
}
