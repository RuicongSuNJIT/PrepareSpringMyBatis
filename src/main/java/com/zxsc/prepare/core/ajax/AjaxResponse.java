package com.zxsc.prepare.core.ajax;

import java.util.HashMap;
import java.util.Map;

public class AjaxResponse {
    private String status;
    private String msg;
    private Map<String, Object> data;

    private AjaxResponse() {
        data = new HashMap<>();
    }

    public AjaxResponse(String status) {
        this();
        this.status = status;
    }

    public AjaxResponse(String status, String msg) {
        this();
        this.status = status;
        this.msg = msg;
    }

    public AjaxResponse(Map<String, Object> data) {
        this.status = ResultType.OK;
        this.data = data;
    }

    public void put(String key, Object value) {
        this.data.put(key, value);
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
