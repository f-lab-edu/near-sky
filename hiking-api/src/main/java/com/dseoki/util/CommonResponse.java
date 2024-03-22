package com.dseoki.util;

import java.time.LocalDateTime;

public class CommonResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private T data;
}
