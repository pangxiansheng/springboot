package com.example.springboot.demo.utils;

import java.util.ArrayList;
import java.util.List;


public class JsonResult {
    private boolean success = false;

    private int status = 0;

    private String message;

    private Object result;

    private List<?> list = new ArrayList<>();

    private boolean download = false;

    private String expPageExcelStr;

    public JsonResult() {

    }

    public JsonResult(boolean success) {
        this.setSuccess(success);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        if (success) {
            status = 1;
        }
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        message = message + " @" + DateUtil.getCurCOMMON_TIME();
        this.message = message;
    }


    public void setMessageNoTime(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public boolean isDownload() {
        return download;
    }

    public void setDownload(boolean download) {
        this.download = download;
    }


}
