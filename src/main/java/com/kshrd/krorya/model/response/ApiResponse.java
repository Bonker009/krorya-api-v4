package com.kshrd.krorya.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String message;
    private HttpStatus status;
    private Integer code;
    private T payload;
    private LocalDateTime localDateTime;

    public ApiResponse(String message, int value, LocalDateTime now, HttpStatus httpStatus) {
        this.message = message;
        this.status = httpStatus;
        this.code = value;
        this.localDateTime = now;
    }
}
