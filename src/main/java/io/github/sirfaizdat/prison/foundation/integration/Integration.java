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

/**
 * Provides the methods that are called when a plugin wants to integrate with another. All
 * integration classes should implement this.
 *
 * @author SirFaizdat
 */
public interface Integration {

    /**
     * @return The name of the plugin this integrates with.
     */
    String getPluginName();

    /**
     * @return The version string of the plugin being integrated with.
     */
    String getPluginVersion();

    /**
     * Groups allow integrations to fallback on one another until they run out of plugins. For
     * example, the group "economy" contains multiple economy plugins, and the integration manager
     * will try to find the first loaded integration with the group "economy."
     *
     * @return The name of the group of this integration.
     */
    String getGroup();

    /**
     * Initialize the integration. This is called when an integration object is added, so all of
     * your code dealing with hooking into the plugin should go here.
     *
     * @return true if the integration successfully initializes, and false otherwise.
     */
    boolean init();

    /**
     * De-initialize the integration. Clean up anything that needs to be cleaned here.
     */
    void deinit();

}
