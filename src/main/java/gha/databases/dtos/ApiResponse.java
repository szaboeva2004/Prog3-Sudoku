package main.java.gha.databases.dtos;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private Boolean success;
    private String message;
    private HttpStatus status;

    public ApiResponse(Boolean success, String message, HttpStatus status) {
        this.success = success;
        this.message = message;
        this.status = status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
