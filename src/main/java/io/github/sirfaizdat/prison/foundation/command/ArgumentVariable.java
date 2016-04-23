package io.github.sirfaizdat.prison.foundation.command;

import org.bukkit.command.CommandSender;

public interface ArgumentVariable<T> {
	public T var(CommandSender sender, CommandArgument argument, String varName) throws CommandError;
}
