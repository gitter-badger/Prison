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

import io.github.sirfaizdat.prison.foundation.module.events.ModuleFailEvent;

/**
 * A module is a system running under Prison that manages a certain part of a game. Extensions to Prison may also add their own
 * modules.
 *
 * @author SirFaizdat
 */
public class Module {

    private String name;
    private boolean enabled = false;
    private String status;

    public Module(String name) {
        this.name = name;
    }

    public void init() {
    }

    public void deinit() {
    }

    /**
     * Tell Prison to disable this module because of a failure.
     *
     * @param reason The reason why this module failed (this will be shown to users).
     */
    protected final void fail(String reason) {
        setStatus(reason);
        Bukkit.getServer().getPluginManager().callEvent(new ModuleFailEvent(this, status));
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
