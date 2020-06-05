package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RestResult<T> implements Serializable {

    private static final String SUCCESS_CODE="0";
    private static final String Fail_CODE="1";
    private String code;
    private T result;
    private Map<String,Object> error;

    public RestResult(){
        this.code="0";
    }

    public RestResult(String code,T result,Map<String,Object> error){
        this.code=code;
        this.result=result;
        this.error=error;
    }

    public RestResult(String code,String error){
        Map<String,Object> errorMap=new HashMap<>();
        errorMap.put("errorCode","500");
        errorMap.put("errorMsg",error);
        this.code=code;
        this.error=errorMap;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Map<String, Object> getError() {
        return error;
    }

    public void setError(Map<String, Object> error) {
        this.error = error;
    }
}
