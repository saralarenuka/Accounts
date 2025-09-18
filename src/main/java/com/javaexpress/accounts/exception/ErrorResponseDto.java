package com.javaexpress.accounts.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorResponseDto {

	private HttpStatus httpStatus;
	private String errorMessage;
	private LocalDateTime localDateTime;

	
	public ErrorResponseDto(HttpStatus httpStatus, String errorMessage, LocalDateTime localDateTime) {
		super();
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
		this.localDateTime = localDateTime;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
}
