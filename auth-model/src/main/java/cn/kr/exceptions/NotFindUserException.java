package cn.kr.exceptions;

/**
 * 没有 该用户异常
 */
public class NotFindUserException extends RuntimeException {


    public NotFindUserException(String msg) {
        super(msg);
    }
    public NotFindUserException() {
        super();
    }
}
