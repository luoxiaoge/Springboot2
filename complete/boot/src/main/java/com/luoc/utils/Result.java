package com.luoc.utils;

import com.luoc.constants.ResultConstants;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @time 13:45
 */
public class Result {


    private Integer status;

    private String msg;

    private Object data;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    /**
     * @return 成功无数据返回结果
     */
    public static Result ok() {
        return Result.newResult(ResultConstants.SUCCESS.getCode(), ResultConstants.SUCCESS.getValue(), null);
    }

    public static Result ok(Object data) {
        return Result.newResult(ResultConstants.SUCCESS.getCode(), ResultConstants.SUCCESS.getValue(), data);
    }

    /**
     * @return 失败返回结果
     */
    public static Result fail() {
        return Result.newResult(ResultConstants.FAIL.getCode(), ResultConstants.FAIL.getValue(), null);
    }

    public static Result newResult(Integer status, String msg, Object data) {
        Result result = new Result();
        result.setStatus(status);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }
}
