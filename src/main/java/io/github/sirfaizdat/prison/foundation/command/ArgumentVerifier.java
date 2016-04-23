package io.github.sirfaizdat.prison.foundation.command;

import org.bukkit.command.CommandSender;

import java.lang.*;

public interface ArgumentVerifier<T> {
	public void verify(CommandSender sender, CommandArgument argument, String verifyName, String[] verifyArgs, T value, String valueRaw) throws VerifyError;
}
