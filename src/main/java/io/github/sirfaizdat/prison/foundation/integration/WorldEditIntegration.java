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

package io.github.sirfaizdat.prison.foundation.integration;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * @author SirFaizdat
 */
public class WorldEditIntegration implements Integration {

    @Override
    public String getPluginName() {
        return "WorldEdit";
    }

    @Override
    public String getPluginVersion() {
        return null;
    }

    @Override
    public String getGroup() {
        return "selection";
    }

    WorldEditPlugin plugin;

    @Override
    public boolean init() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("WorldEdit");
        if (plugin == null || !plugin.isEnabled()) return false;

        this.plugin = (WorldEditPlugin) plugin;
        return true;
    }

    @Override
    public void deinit() {
    }

    public WorldEdit getWorldEdit() {
        return plugin.getWorldEdit();
    }

    public Selection getSelection(Player player) {
        return plugin.getSelection(player);
    }

    public LocalSession getSession(Player player) {
        return plugin.getSession(player);
    }

}
