package com.example.springdemo.common;


import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据集封装类
 * <p>
 * Created by marco on 2016/12/23.
 */
public class ResultWrapper<T> {

    @ApiModelProperty(value = "是否成功", required = true)
    private Boolean success = true;

    @ApiModelProperty(value = "返回总记录数", required = true)
    private Integer total = 0;

    @ApiModelProperty(value = "返回状态", required = true)
    private Integer code = 1;

    @ApiModelProperty(value = "返回提示信息(一般出错时才会有值)")
    private String message = "";

    @ApiModelProperty(value = "返回数据结果集", required = true)
    private List<T> data;

    @ApiModelProperty(value = "返回数据结果集", required = true)
    private Map pages;

    public ResultWrapper() {

    }

    public ResultWrapper(T data) {
        if(data!=null){
            this.data = new ArrayList<>(1);
            this.data.add(data);
        }
    }

    public ResultWrapper(List<T> data) {
        this.data = data;
        this.total = data == null ? 0 : data.size();
    }

    /**
     * 是否成功
     *
     * @return
     */
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * 记录数
     */
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 记录数
     */
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 描述
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 返回数据集
     */
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Map getPages() {
        return pages;
    }

    public void setPages(Map pages) {
        this.pages = pages;
    }
}
