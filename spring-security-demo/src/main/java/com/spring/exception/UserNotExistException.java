/**
 *
 */
package com.spring.exception;

import lombok.Data;

@Data
public class UserNotExistException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -6112780192479692859L;

	private String id;

	public UserNotExistException(String id) {
		super("user not exist");
		this.id = id;
	}

}
