package io.coding.challenge.controller;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.coding.challenge.error.IsInputCorrect;
import io.coding.challenge.service.WordReverserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Validated
@Slf4j
public class WordReverserController {
	
	@Autowired
	private WordReverserService wordReverserService;
	
	@RequestMapping(
			value = "/reverse", 
			method = {RequestMethod.GET, RequestMethod.POST},
			headers = "Accept=application/json",
			produces = "application/json")
	@ResponseBody
	ResponseEntity<String> reverse(@Valid @RequestBody @IsInputCorrect String input) throws WordReverserException {
		log.debug("| Received {} for reversing", input);
		if (null == input || input.isEmpty()) {
			throw new WordReverserException("Input string cannnot be null or empty");
		}
		return ResponseEntity.ok(wordReverserService.reverse(input));
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleException(MethodArgumentNotValidException exception) {
 
        String errorMsg = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());
 
        return new ResponseEntity<Object>(errorMsg, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
