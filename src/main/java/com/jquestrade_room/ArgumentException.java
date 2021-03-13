package com.jquestrade_room;

/** Thrown if invalid or malformed argument, argument length exceeds imposed limit,
  *	or missing required argument.
  */
@SuppressWarnings("serial")	
public class ArgumentException extends RuntimeException {
	public ArgumentException(String reason) {
		super(reason);
	}
}