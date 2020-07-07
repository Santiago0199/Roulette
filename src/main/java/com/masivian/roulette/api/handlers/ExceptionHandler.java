package com.masivian.roulette.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.masivian.roulette.api.response.SingleResponseBody;
import com.masivian.roulette.data.model.enums.OperationState;
import com.masivian.roulette.exception.BussinesException;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(BussinesException.class)
    public ResponseEntity handleException(BussinesException e) {
		SingleResponseBody responseBody = new SingleResponseBody(OperationState.FAILED);
		responseBody.addToPayload("message", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseBody);
    } 
}
