package com.javaweb.utils;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : Firewine
 * @version : 1.0
 * @Program Name: AjaxResult
 * @Create : 2020/1/23
 * @Description :
 */
public class AjaxResult {

    private boolean success;
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}
