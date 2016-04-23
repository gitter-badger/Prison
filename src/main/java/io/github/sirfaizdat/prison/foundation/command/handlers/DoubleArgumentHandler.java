package io.github.sirfaizdat.prison.foundation.command.handlers;

import org.bukkit.command.CommandSender;

import io.github.sirfaizdat.prison.foundation.command.CommandArgument;
import io.github.sirfaizdat.prison.foundation.command.TransformError;

public class DoubleArgumentHandler extends NumberArgumentHandler<Double> {
	public DoubleArgumentHandler() {
		setMessage("parse_error", "The parameter [%p] is not a number");
	}
	
	@Override
	public Double transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
		try {
			return Double.parseDouble(value);
		}
		catch(NumberFormatException e) {
			throw new TransformError(argument.getMessage("parse_error"));
		}
	}
}
