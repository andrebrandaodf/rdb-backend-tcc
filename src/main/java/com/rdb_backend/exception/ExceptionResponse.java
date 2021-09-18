package com.rdb_backend.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ExceptionResponse {
    private Date timestamp;
    private List<String> messages;
    private String details;
    private Integer status;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timestamp, List<String> messages, String details, Integer status) {
        this.timestamp = timestamp;
        this.messages = messages;
        this.details = details;
        this.status = status;
    }

    public ExceptionResponse(Integer status, String message, String error) {
        super();
        this.status = status;
        this.messages = Arrays.asList(error);
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
