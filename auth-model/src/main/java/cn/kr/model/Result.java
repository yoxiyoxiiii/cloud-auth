package cn.kr.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    public static final int NO_USER=1000;

    private int code;
    private String msg;
    private T data;

    public Result(){}

    private Result(int code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static<T> Result<T> success(String msg, T data) {
        Result result = new Result<T>(200,msg,data);
        return result;
    }

    public static Result fail(int code, String msg) {
        Result result = new Result(code,msg,null);
        return result;
    }



}
