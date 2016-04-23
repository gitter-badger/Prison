package io.github.sirfaizdat.prison;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.sirfaizdat.prison.foundation.command.CommandHandler;

/**
 * Main class for the plugin.
 *
 * @author SirFaizdat
 */
public class Prison extends JavaPlugin {

    public static Prison instance;
    private CommandHandler handler;

    @Override
    public void onEnable() {
        instance = this;

        handler = new CommandHandler(this);
        handler.registerCommands(new PrisonCommand());

        getLogger().info("Enabled " + getDescription().getFullName() + ". Crafted with <3 by SirFaizdat and contributors.");
    }

    @Override
    public void onDisable() {
    }

    public CommandHandler getHandler() {
        return handler;
    }

}
