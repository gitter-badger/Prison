package io.github.sirfaizdat.prison.foundation.command;

import org.bukkit.command.CommandSender;

public interface PermissionHandler {
	public boolean hasPermission(CommandSender sender, String[] permissions);
}
