package io.github.sirfaizdat.prison.foundation.command;

import org.bukkit.command.CommandSender;

public interface ExecutableArgument {
	public Object execute(CommandSender sender, Arguments args) throws CommandError;
}
