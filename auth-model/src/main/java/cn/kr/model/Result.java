package cn.kr.model;


import lombok.Data;

import java.io.Serializable;

/**
 * 返回对象定义
 * @author Administrator
 */
@Data
public class Result<T> implements Serializable {

    public static final int NO_USER=1000;
    public static final int BAD_RESPONSE=1001;

    private int code;
    private T data;
    private boolean status;

    public Result(){}

    private Result(int code,boolean status,T data){
        this.code = code;
        this.data = data;
        this.status = status;
    }

    public static<T> Result<T> success(T data) {
        Result result = new Result<T>(200,true,data);
        return result;
    }

    public static Result fail(int code) {
        Result result = new Result(code,false,null);
        return result;
    }

    public static Result fail() {
        Result result = new Result(BAD_RESPONSE,false,null);
        return result;
    }



}
