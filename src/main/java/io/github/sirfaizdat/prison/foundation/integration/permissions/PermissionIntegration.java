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

package io.github.sirfaizdat.prison.foundation.integration.permissions;

import org.bukkit.entity.Player;

import io.github.sirfaizdat.prison.foundation.integration.Integration;

/**
 * For integrations dealing with permission plugins.
 *
 * @author SirFaizdat
 */
public interface PermissionIntegration extends Integration {

    String getPrimaryRank(Player player, String world);

    String getPrimaryRank(Player player);

    String[] getRanks(Player player, String world);

    String[] getRanks(Player player);

    void setRank(Player player, String rankName, String world);

    void setRank(Player player, String rankName);

    @Override
    default String getGroup() {
        return "permissions";
    }

}
