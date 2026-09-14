package com.microservices.learning.payLoad;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private String message;
    private boolean Success;
    private HttpStatus status;

    // Default constructor
    public ApiResponse() {}

    // Constructor with all fields
    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.Success = success;
        this.status = status;
    }

    // Builder pattern
    public static ApiResponseBuilder builder() {
        return new ApiResponseBuilder();
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        this.Success = success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    // Builder class
    public static class ApiResponseBuilder {
        private String message;
        private boolean Success;
        private HttpStatus status;

        public ApiResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseBuilder Success(boolean Success) {
            this.Success = Success;
            return this;
        }

        public ApiResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(message, Success, status);
        }
    }
}