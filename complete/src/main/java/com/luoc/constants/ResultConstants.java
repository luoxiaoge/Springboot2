package com.luoc.constants;

/**
 * @author luoc
 * @date 2018/11/13 0013
 * @time 13:41
 */
public enum ResultConstants {

    /**
     * 成功状态码
     */
    SUCCESS("success", 200),


    FAIL("fail", 500);


    private String value;
    private Integer code;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    ResultConstants(String value, Integer code) {
        this.value = value;
        this.code = code;
    }
}
