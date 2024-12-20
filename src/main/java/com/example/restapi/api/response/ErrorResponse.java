package com.example.restapi.api.response;

import com.example.restapi.shared.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private ErrorCode errorCode;
    private String errorMessage;

}
