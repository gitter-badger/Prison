package io.github.sirfaizdat.prison.foundation.command.handlers;

import org.bukkit.command.CommandSender;

import io.github.sirfaizdat.prison.foundation.command.ArgumentHandler;
import io.github.sirfaizdat.prison.foundation.command.ArgumentVerifier;
import io.github.sirfaizdat.prison.foundation.command.CommandArgument;
import io.github.sirfaizdat.prison.foundation.command.InvalidVerifyArgument;
import io.github.sirfaizdat.prison.foundation.command.TransformError;
import io.github.sirfaizdat.prison.foundation.command.VerifyError;


public class StringArgumentHandler extends ArgumentHandler<String> {
	public StringArgumentHandler() {
		setMessage("min_error", "The parameter [%p] must be more than %1 characters.");
		setMessage("max_error", "The parameter [%p] can't be more than %1 characters.");
		
		addVerifier("min", new ArgumentVerifier<String>() {
			@Override
			public void verify(CommandSender sender, CommandArgument argument, String verifyName, String[] verifyArgs, String value, String valueRaw) throws VerifyError {
				if(verifyArgs.length != 1)
					throw new InvalidVerifyArgument(argument.getName());
				
				try {
					int min = Integer.parseInt(verifyArgs[0]);
					if(value.length() < min)
						throw new VerifyError(argument.getMessage("min_error", verifyArgs[0]));
				}
				catch (NumberFormatException e) {
					throw new InvalidVerifyArgument(argument.getName());
				}
			}
		});
		
		
		addVerifier("max", new ArgumentVerifier<String>() {
			@Override
			public void verify(CommandSender sender, CommandArgument argument, String verifyName, String[] verifyArgs, String value, String valueRaw) throws VerifyError {
				if(verifyArgs.length != 1)
					throw new InvalidVerifyArgument(argument.getName());
				
				try {
					int max = Integer.parseInt(verifyArgs[0]);
					if(value.length() > max)
						throw new VerifyError(argument.getMessage("max_error", verifyArgs[0]));
				}
				catch (NumberFormatException e) {
					throw new InvalidVerifyArgument(argument.getName());
				}
			}
		});
	}

	@Override
	public String transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
		return value;
	}
}
