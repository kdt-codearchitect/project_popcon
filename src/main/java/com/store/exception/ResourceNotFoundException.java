package com.store.exception;

public class ResourceNotFoundException extends RuntimeException{

	    public ResourceNotFoundException(String message) {
	        super("문의내역을 찾을 수 없습니다.");
	}

}
