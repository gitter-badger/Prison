package io.github.sirfaizdat.prison.foundation.command.handlers;

import org.bukkit.command.CommandSender;

import io.github.sirfaizdat.prison.foundation.command.CommandArgument;
import io.github.sirfaizdat.prison.foundation.command.TransformError;

public class IntegerArgumentHandler extends NumberArgumentHandler<Integer> {
	public IntegerArgumentHandler() {
		setMessage("parse_error", "The parameter [%p] is not an integer");
	}
	
	@Override
	public Integer transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
		try {
			return Integer.parseInt(value);
		}
		catch(NumberFormatException e) {
			throw new TransformError(argument.getMessage("parse_error"));
		}
	}
}
