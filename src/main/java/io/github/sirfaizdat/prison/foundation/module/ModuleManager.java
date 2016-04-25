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

package io.github.sirfaizdat.prison.foundation.module;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.ServerOperator;

import java.util.ArrayList;
import java.util.List;

import io.github.sirfaizdat.prison.Prison;
import io.github.sirfaizdat.prison.foundation.module.events.ModuleFailEvent;
import io.github.sirfaizdat.prison.foundation.module.events.ModuleRegisterEvent;
import mkremins.fanciful.FancyMessage;

/**
 * Stores instances of all modules and handles enabling and disablinb them.
 *
 * @author SirFaizdat
 */
public class ModuleManager implements Listener {

    private List<Module> modules;
    private boolean anyFailures = false;

    public ModuleManager() {
        modules = new ArrayList<>();
        Bukkit.getServer().getPluginManager().registerEvents(this, Prison.instance);
        Bukkit.getServer().getScheduler().runTask(Prison.instance, () -> Bukkit.getOnlinePlayers().stream().filter(ServerOperator::isOp).forEach(this::sendFailureMessage));
    }

    /**
     * Register and enable a module.
     */
    public void registerModule(Module module) {
        ModuleRegisterEvent event = new ModuleRegisterEvent(module);
        Bukkit.getServer().getPluginManager().callEvent(event); // Module is enabled through this event.
        if (event.isCancelled()) return;
        modules.add(module);
    }

    public void enableModule(Module m) {
        if (m.isEnabled()) return;
        m.init();
        m.setEnabled(true);
        if (m.getStatus() == null) m.setStatus("&aEnabled");
    }

    public void disableModule(Module m) {
        if (!m.isEnabled()) return;
        m.deinit();
        m.setEnabled(false);
        m.setStatus("&cDisabled");
    }

    private void sendFailureMessage(Player player) {
        if (!anyFailures) return;
        new FancyMessage("An error has occurred while enabling Prison. ").color(ChatColor.RED)
                .then("Click here for more information.").color(ChatColor.RED).style(ChatColor.ITALIC).command("/prison status")
                .send(player);
    }

    public void enableAll() {
        for (Module m : modules) enableModule(m);
    }

    public void disableAll() {
        for (Module m : modules) disableModule(m);
    }

    public Module getModuleByName(String name) {
        for (Module m : modules) if (m.getName().equalsIgnoreCase(name)) return m;
        return null;
    }

    public List<Module> getAllModules() {
        return modules;
    }

    // Lowest in case another plugin wants to cancel it first.
    @EventHandler(priority = EventPriority.LOWEST)
    void onModuleRegister(ModuleRegisterEvent e) {
        enableModule(e.getModule());
    }

    @EventHandler
    public void onModuleFail(ModuleFailEvent e) {
        e.getModule().setEnabled(false);
        anyFailures = true;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        sendFailureMessage(e.getPlayer());
    }

}
