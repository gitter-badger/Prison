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

import java.util.Optional;

import io.github.sirfaizdat.prison.foundation.integration.economy.EconomyIntegration;
import io.github.sirfaizdat.prison.foundation.integration.economy.EssentialsIntegration;
import io.github.sirfaizdat.prison.foundation.integration.economy.VaultEconomy;
import io.github.sirfaizdat.prison.foundation.integration.economy.iConomyIntegration;
import io.github.sirfaizdat.prison.foundation.integration.permissions.GroupManagerIntegration;
import io.github.sirfaizdat.prison.foundation.integration.permissions.PermissionIntegration;
import io.github.sirfaizdat.prison.foundation.integration.permissions.PermissionsExIntegration;

/**
 * Loads the Integration library and adds the integrations to it.
 *
 * @author SirFaizdat
 */
public class IntegrationHandler {

    private IntegrationManager manager;

    public IntegrationHandler() {
        manager = new IntegrationManager();
        // Economy
        manager.load(EssentialsIntegration.class);
        manager.load(iConomyIntegration.class);
        manager.load(VaultEconomy.class);
        // Permissions
        manager.load(GroupManagerIntegration.class);
        manager.load(PermissionsExIntegration.class);
        // Selection
        manager.load(WorldEditIntegration.class);
    }

    public EconomyIntegration getEconomy() {
        Optional<Integration> opt = manager.get("economy");
        if (!opt.isPresent()) return null;
        return (EconomyIntegration) opt.get();
    }

    public PermissionIntegration getPermissions() {
        Optional<Integration> opt = manager.get("permissions");
        if (!opt.isPresent()) return null;
        return (PermissionIntegration) opt.get();
    }

    public WorldEditIntegration getWorldEdit() {
        Optional<Integration> opt = manager.get("selection");
        if (!opt.isPresent()) return null;
        return (WorldEditIntegration) opt.get();
    }

}
