package com.objectmentor.utilities.args;
import lombok.Data;

import static com.objectmentor.utilities.args.ArgsException.ErrorCode.*;
@Data
public class ArgsException extends Exception {
    private char errorArgumentId = '\0';
    private String errorParameter = null;
    private ErrorCode errorCode = OK;
    public ArgsException(){}
    public ArgsException(String message){
        super(message);
    }

    public ArgsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ArgsException(ErrorCode errorCode, String errorParameter) {
        this.errorCode = errorCode;
        this.errorParameter = errorParameter;
    }

    public ArgsException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
        this.errorCode = errorCode;
        this.errorArgumentId = errorArgumentId;
        this.errorParameter = errorParameter;
    }

    public String errorMessage() {
        switch (errorCode) {
            case OK:
                return "";
            case UNEXPECTED_ARGUMENT:
                return "";
            case MISSING_STRING:
                return "";
            case INVALID_INTEGER:
                return "";
            case MISSING_INTEGER:
                return "";
            case INVALID_DOUBLE:
                return "";
            case MISSING_DOUBLE:
                return "";
            case INVALID_ARGUMENT_NAME:
                return "";
            case INVALID_ARGUMENT_FORMAT:
                return "";
        }
        return "";
    }
    public enum ErrorCode {
        OK, INVALID_ARGUMENT_FORMAT, UNEXPECTED_ARGUMENT, INVALID_ARGUMENT_NAME,
        MISSING_STRING,
        MISSING_INTEGER,
        INVALID_INTEGER,
        MISSING_DOUBLE, INVALID_DOUBLE
    }
}
