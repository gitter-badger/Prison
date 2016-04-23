package io.github.sirfaizdat.prison.foundation.command.handlers;

import org.bukkit.command.CommandSender;

import io.github.sirfaizdat.prison.foundation.command.ArgumentHandler;
import io.github.sirfaizdat.prison.foundation.command.ArgumentVerifier;
import io.github.sirfaizdat.prison.foundation.command.CommandArgument;
import io.github.sirfaizdat.prison.foundation.command.InvalidVerifyArgument;
import io.github.sirfaizdat.prison.foundation.command.VerifyError;


public abstract class NumberArgumentHandler<T extends Number> extends ArgumentHandler<T> {
	
	public NumberArgumentHandler() {
		setMessage("min_error", "The parameter [%p] must be equal or greater than %1");
		setMessage("max_error", "The parameter [%p] must be equal or less than %1");
		setMessage("range_error", "The parameter [%p] must be equal or greater than %1 and less than or equal to %2");
		
		addVerifier("min", new ArgumentVerifier<T>() {
			@Override
			public void verify(CommandSender sender, CommandArgument argument, String verifyName, String[] verifyArgs, T value, String valueRaw) throws VerifyError {
				if(verifyArgs.length != 1)
					throw new InvalidVerifyArgument(argument.getName());
				
				try {
					double min = Double.parseDouble(verifyArgs[0]);
					if(value.doubleValue() < min)
						throw new VerifyError(argument.getMessage("min_error", verifyArgs[0]));
				}
				catch (NumberFormatException e) {
					throw new InvalidVerifyArgument(argument.getName());
				}
			}
		});
		
		addVerifier("max", new ArgumentVerifier<T>() {
			@Override
			public void verify(CommandSender sender, CommandArgument argument, String verifyName, String[] verifyArgs, T value, String valueRaw) throws VerifyError {
				if(verifyArgs.length != 1)
					throw new InvalidVerifyArgument(argument.getName());
				
				try {
					double max = Double.parseDouble(verifyArgs[0]);
					if(value.doubleValue() > max)
						throw new VerifyError(argument.getMessage("max_error", verifyArgs[0]));
				}
				catch (NumberFormatException e) {
					throw new InvalidVerifyArgument(argument.getName());
				}
			}	
		});
		
		addVerifier("range", new ArgumentVerifier<T>() {
			@Override
			public void verify(CommandSender sender, CommandArgument argument, String verifyName, String[] verifyArgs, T value, String valueRaw) throws VerifyError {
				if(verifyArgs.length != 2)
					throw new InvalidVerifyArgument(argument.getName());
				
				try {
					double min = Double.parseDouble(verifyArgs[0]);
					double max = Double.parseDouble(verifyArgs[1]);
					double dvalue = value.doubleValue();
					if(dvalue < min || dvalue > max)
						throw new VerifyError(argument.getMessage("range_error", verifyArgs[0], verifyArgs[1]));
				}
				catch (NumberFormatException e) {
					throw new InvalidVerifyArgument(argument.getName());
				}
			}
		});
	}
}
