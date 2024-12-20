package com.example.restapi.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private final String result = "SUCCESS";
    private final String message = "요청이 성공적으로 처리되었습니다.";
    private final T data;

}
