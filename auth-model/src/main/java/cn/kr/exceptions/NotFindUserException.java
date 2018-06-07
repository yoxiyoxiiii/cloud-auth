package cn.kr.exceptions;

/**
 * 没有 该用户异常
 * @author Administrator
 */
public class NotFindUserException extends RuntimeException {


    public NotFindUserException(String msg) {
        super(msg);
    }
    public NotFindUserException() {
        super();
    }
}
