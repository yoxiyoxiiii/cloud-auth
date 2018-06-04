package cn.kr.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    public static final int NO_USER=1000;














    private int code;
    private String msg;
    private Object data;

    private Result(int code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(String msg, Object data) {
        Result result = new Result(200,msg,data);
        return result;
    }

    public static Result fail(int code, String msg) {
        Result result = new Result(code,msg,null);
        return result;
    }



}
