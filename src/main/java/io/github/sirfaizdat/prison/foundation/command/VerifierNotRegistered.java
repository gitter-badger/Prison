package io.github.sirfaizdat.prison.foundation.command;

public class VerifierNotRegistered extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VerifierNotRegistered(String verifierName) {
		super("The verify method named "+verifierName+" is not registered");
	}
}
