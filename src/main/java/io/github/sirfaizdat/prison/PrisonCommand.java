/*
 * Copyright (c) 2016 SirFaizdat.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.sirfaizdat.prison;

import org.bukkit.command.CommandSender;

import io.github.sirfaizdat.prison.foundation.command.Command;
import io.github.sirfaizdat.prison.foundation.module.Module;
import io.github.sirfaizdat.prison.foundation.util.TextUtil;

/**
 * The /prison commands.
 *
 * @author SirFaizdat
 */
class PrisonCommand {

    @Command(identifier = "prison status", description = "Information about Prison's status.", permissions = {"prison" +
            ".manage"})
    public void statusCommand(CommandSender sender) {
        sender.sendMessage("This is " + Prison.instance.getDescription().getFullName() + ".");
        if (Prison.instance.getDescription().getVersion().contains("SNAPSHOT"))
            sender.sendMessage("You are running a development build.");

        // Dependency information
        String permissionsPlugin = Prison.instance.getIntegrationHandler().getPermissions() == null ? "&cNo permissions plugin " +
                "found." : Prison.instance.getIntegrationHandler().getPermissions().getPluginName();
        String economyPlugin = Prison.instance.getIntegrationHandler().getEconomy() == null ? "&cNo economy plugin " +
                "found." : Prison.instance.getIntegrationHandler().getEconomy().getPluginName();
        sender.sendMessage(TextUtil.parse("Permissions: &a%s", permissionsPlugin));
        sender.sendMessage(TextUtil.parse("Economy: &a%s", economyPlugin));

        // Module information
        sender.sendMessage("Modules:");
        if (Prison.instance.getModuleManager().getAllModules().size() == 0) sender.sendMessage(TextUtil.parse("     &7&oNone."));
        else
            for (Module module : Prison.instance.getModuleManager().getAllModules())
                sender.sendMessage(TextUtil.parse("     %s: &c%s", module.getName(), module.getStatus()));
    }

    @Command(identifier = "prison version", description = "Information about Prison's status.", permissions = {"prison" +
            ".manage"})
    public void versionCommand(CommandSender sender) {
        statusCommand(sender); // Same as /prison status
    }

}
