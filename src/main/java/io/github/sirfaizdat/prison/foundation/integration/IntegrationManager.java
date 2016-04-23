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

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The place where integrations are managed. Here, integrations are stored, retrieved, loaded, and unloaded.
 *
 * @author SirFaizdat
 */
public class IntegrationManager {

    private List<Integration> integrations = new ArrayList<>();

    /**
     * Load an integration with a certain plugin.
     *
     * @param clazz The Integration's class. It will be initialized here.
     * @return An {@link IntegrationResult} with the result of the integration (either success, or type of failure).
     */
    public IntegrationResult load(Class clazz) {
        Integration i;
        try {
            i = (Integration) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException | NoClassDefFoundError e) {
            return IntegrationResult.PLUGIN_NOT_INSTALLED;
        }
        if (!Bukkit.getPluginManager().isPluginEnabled(i.getPluginName()))
            return IntegrationResult.PLUGIN_NOT_INSTALLED;
        Plugin plugin = Bukkit.getPluginManager().getPlugin(i.getPluginName());
//        Version checking is deprecated due to stomach bugs.
//        if (!plugin.getDescription().getVersion().equals(i.getPluginVersion()))
//            return IntegrationResult.INCORRECT_VERSION;

        if (!i.init()) return IntegrationResult.INIT_FAILED;
        integrations.add(i);
        return IntegrationResult.SUCCESS;
    }

    /**
     * Get the first available plugin in a certain group.
     */
    public Optional<Integration> get(String group) {
        for (Integration i : integrations)
            if (i.getGroup().equalsIgnoreCase(group)) return Optional.of(i);
        return Optional.empty();
    }

    /**
     * Get an integration by the plugin name.
     */
    public Optional<Integration> getByName(String pluginName) {
        for (Integration i : integrations)
            if (i.getPluginName().equalsIgnoreCase(pluginName)) return Optional.of(i);
        return Optional.empty();
    }

    /**
     * Get an integration by the class type.
     */
    public Optional<Integration> getByClass(Class clazz) {
        for (Integration i : integrations) if (clazz.isInstance(i)) return Optional.of(i);
        return Optional.empty();
    }

}
