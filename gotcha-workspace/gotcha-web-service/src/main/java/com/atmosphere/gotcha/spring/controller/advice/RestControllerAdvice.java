package com.atmosphere.gotcha.spring.controller.advice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.atmosphere.gotcha.spring.exception.ErrorDetails;
import com.atmosphere.gotcha.spring.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

	// Handle invalid @PathVariable format
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException exception, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), status.value(), exception.getMessage(), webRequest.getDescription(false), exception.getStackTrace());
		return new ResponseEntity<Object>(errorDetails, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException exception,
			HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), status.value(), exception.getMessage(), webRequest.getDescription(false), exception.getStackTrace());
		return new ResponseEntity<Object>(errorDetails, status);
	}
	
	// Handle validation of input data
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), status.value(), exception.getMessage(), webRequest.getDescription(false), exception.getStackTrace());
		BindingResult result = exception.getBindingResult();
		List<String> errorList = new ArrayList<String>(result.getAllErrors().size());
		
		for (ObjectError objectErrorObj : result.getAllErrors()) {
			errorList.add(objectErrorObj.getDefaultMessage());
		}

		errorDetails.setError(errorList.toString());
		return new ResponseEntity<Object>(errorDetails, status);
	}

	// Handle validation of array of DTO input data
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<ErrorDetails> constraintViolationExceptionForArrayOfObject(ConstraintViolationException exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.PRECONDITION_FAILED.value(), exception.getMessage(), webRequest.getDescription(false), exception.getStackTrace());

		Set<ConstraintViolation<?>> constraintViolationsList = exception.getConstraintViolations();
		List<String> errorList = new ArrayList<String>(constraintViolationsList.size());
		
		for (ConstraintViolation<?> constraintViolation : constraintViolationsList) {
			ConstraintViolationImpl<?> constraintViolation1 = (ConstraintViolationImpl<?>) constraintViolation;
			errorList.add(constraintViolation1.getPropertyPath()+ " : "+constraintViolation1.getMessage());
		}
		
		errorDetails.setError(errorList.toString());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.PRECONDITION_FAILED);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.NOT_FOUND.value(), exception.getMessage(), webRequest.getDescription(false), exception.getStackTrace());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> otherException(Exception exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), webRequest.getDescription(false), exception.getStackTrace());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
