package io.coding.challenge.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WordReverserService {
	
	public String reverseWithSb(String input) {
		log.debug("| Reversing: {}", input);
		StringBuilder out = new StringBuilder();
		StringTokenizer spaceTkn = new StringTokenizer(input, " ");
		int tokenStartIndex = -1;
		while (spaceTkn.hasMoreTokens()) {
	        StringBuilder thisToken = new StringBuilder(spaceTkn.nextToken());
	        StringTokenizer splTkn = new StringTokenizer(thisToken.toString(), ".!,?:;'\"!@#$%^&*(){}[]|");
	        
	        int splTokenStartIndex = -1;
	        while(splTkn.hasMoreTokens()) {
	        	StringBuilder thisSplToken = new StringBuilder(splTkn.nextToken());
	        	out.append(thisSplToken.reverse());

	        	splTokenStartIndex += thisSplToken.length() + 1;
	        	if (thisToken.length() > splTokenStartIndex) {
	        		out.append(thisToken.charAt(splTokenStartIndex));
	        	}
	        }
	        
	        tokenStartIndex += thisToken.length() + 1;
	        if (input.length() > tokenStartIndex) {
	        	out.append(input.charAt(tokenStartIndex));
	        	log.trace("| Token index: {}, char:{}, in:{}, Out:{}", tokenStartIndex, input.charAt(tokenStartIndex), thisToken.toString(), out.toString());
	        }
	        
	    }
		String result = out.toString().trim();
	    log.info("| After reversing: {}", result);
        return result;
	}
	
	public String reverse(String input) {
		List<Character> outChar = new LinkedList<Character>();
		Stack<Character> tmpCharStack = new Stack<Character>();
		for (int index = 0; index < input.length(); index++) {
			char currentChar = input.charAt(index);
			if (Pattern.matches("[a-zA-Z_0-9]", String.valueOf(currentChar))) {
				log.trace("| Index:{}, Current:{}, Pushing: {}", index, currentChar, currentChar);
				tmpCharStack.push(currentChar);
			} else {
				while(!tmpCharStack.empty()) {
					outChar.add(tmpCharStack.pop());
				}
				outChar.add(currentChar);
				log.trace("| OutChar interm:{}", outChar);
			}
		}
		
		while(!tmpCharStack.empty()) {
			outChar.add(tmpCharStack.pop());
		}
		log.trace("| OutChar final:{}", outChar);
		return outChar.stream().map(e -> e.toString()).collect(Collectors.joining());
	}

}
