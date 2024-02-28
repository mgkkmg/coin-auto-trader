package org.kmg.coinautotrader.exception;

import lombok.extern.slf4j.Slf4j;
import org.kmg.coinautotrader.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerHandler {

    @ExceptionHandler(CoinAutoTraderException.class)
    private ResponseEntity<?> globalExceptionHandler(CoinAutoTraderException e) {
        log.error("CoinAutoTraderException occurs {}", e.toString());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(CommonResponse.error(e.getErrorCode().name()));
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<?> globalExceptionHandler(RuntimeException e) {
        log.error("RuntimeException occurs {}", e.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(CommonResponse.error(ErrorCode.INTERNAL_SERVER_ERROR.name()));
    }
}
