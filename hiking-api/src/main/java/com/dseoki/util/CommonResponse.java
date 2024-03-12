package com.dseoki.util;

import java.time.LocalDateTime;

/**
 * fileName: CommonResponse
 * author: gawain
 * date: 2024-03-12
 * description:
 * ==============================
 * DATE     AUTHOR      NOTE
 * ------------------------------
 * 2024-03-12  gawain     최초생성
 */
public class CommonResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private T data;
}
