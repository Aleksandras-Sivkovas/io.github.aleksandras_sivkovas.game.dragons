package io.github.aleksandras_sivkovas.game.dragons.backend.exception.controller;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionController {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorDetails> handleError(WebRequest request,Exception e) throws Exception{
		warn(e.getMessage(),e);
		if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
			throw e;
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "INTERNAL_SERVER_ERROR",
			      request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<ErrorDetails> handleNoSuchElementException(WebRequest request,NoSuchElementException e) throws Exception{
		warn(e.getMessage(),e);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),
			      request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	private void warn(String message,Exception exception) {
		getLogger().log(Level.WARNING, message, exception);
	}
	private Logger getLogger() {
		return Logger.getLogger(ExceptionController.class.getName());
	}
}
