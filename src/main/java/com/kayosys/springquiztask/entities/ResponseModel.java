package com.kayosys.springquiztask.entities;

/*
*Class to Handle Rest Api response
*/
public class ResponseModel {
    private String message;
    private int status;
    private Boolean success;

    public ResponseModel(String message, int status, Boolean success) {
        this.message = message;
        this.status = status;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }      
    
}
