package cn.kr.exceptions;

import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class GeneralException extends RuntimeException {

    private int code = 500;
    public GeneralException() {
        super();
    }
    public GeneralException(int code) {
        super();
        this.code = code;
    }

    public GeneralException(int code,String msg) {
        super(msg);
        this.code = code;
    }

    public GeneralException(String msg) {
        super(msg);
    }


}
