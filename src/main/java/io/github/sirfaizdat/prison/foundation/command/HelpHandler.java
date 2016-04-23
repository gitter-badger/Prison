package io.github.sirfaizdat.prison.foundation.command;

public interface HelpHandler {
	public String[] getHelpMessage(RegisteredCommand command);
	public String getUsage(RegisteredCommand command);
}
