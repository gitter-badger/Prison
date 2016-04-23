package io.github.sirfaizdat.prison;

import org.bukkit.command.CommandSender;

import io.github.sirfaizdat.prison.foundation.command.Command;

/**
 * The /prison commands.
 *
 * @author SirFaizdat
 */
class PrisonCommand {

    @Command(identifier = "prison version", description = "Information about Prison's status.", permissions = {"prison.manage"})
    public void versionCommand(CommandSender sender) {
        sender.sendMessage("This is " + Prison.instance.getDescription().getFullName() + ".");
        if (Prison.instance.getDescription().getVersion().contains("SNAPSHOT"))
            sender.sendMessage("You are running a development build.");
        // An update check will go here at some point.
    }

}
