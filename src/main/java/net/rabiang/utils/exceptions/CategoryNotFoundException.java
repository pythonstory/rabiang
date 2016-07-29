package net.rabiang.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such category")
public class CategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
