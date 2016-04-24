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

import org.bukkit.plugin.java.JavaPlugin;

import io.github.sirfaizdat.prison.foundation.command.CommandHandler;
import io.github.sirfaizdat.prison.foundation.integration.IntegrationHandler;
import io.github.sirfaizdat.prison.foundation.module.ModuleManager;

/**
 * Main class for the plugin.
 *
 * @author SirFaizdat
 */
public class Prison extends JavaPlugin {

    public static Prison instance;
    private CommandHandler commandHandler;
    private IntegrationHandler integrationHandler;
    private ModuleManager moduleManager;

    @Override
    public void onEnable() {
        instance = this;

        initFoundation();
        initModules();
        initUserInterface();

        getLogger().info("Enabled " + getDescription().getFullName() + ". Crafted with <3 by SirFaizdat and contributors.");
    }

    private void initFoundation() {
        integrationHandler = new IntegrationHandler();
        commandHandler = new CommandHandler(this);
        moduleManager = new ModuleManager();
    }

    private void initModules() {
        moduleManager.registerModule(new TestModule());
    }

    private void initUserInterface() {
        commandHandler.registerCommands(new PrisonCommand());
    }

    @Override
    public void onDisable() {
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public IntegrationHandler getIntegrationHandler() {
        return integrationHandler;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
