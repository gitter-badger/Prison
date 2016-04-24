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

package io.github.sirfaizdat.prison.foundation.module.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import io.github.sirfaizdat.prison.foundation.module.Module;

/**
 * Fired when a module fails (i.e. {@link Module#fail(String)} is called.
 *
 * @author SirFaizdat
 */
public class ModuleRegisterEvent extends Event implements Cancellable {

    private static HandlerList handlerList = new HandlerList();
    private Module module;
    private boolean cancelled = false;

    public ModuleRegisterEvent(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

}
