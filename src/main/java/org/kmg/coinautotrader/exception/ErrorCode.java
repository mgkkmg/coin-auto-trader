package org.kmg.coinautotrader.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),
	NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
	;

	private final HttpStatus status;
	private final String message;
}
