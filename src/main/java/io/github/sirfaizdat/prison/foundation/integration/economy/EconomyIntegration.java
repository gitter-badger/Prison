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

package io.github.sirfaizdat.prison.foundation.integration.economy;

import org.bukkit.entity.Player;

import io.github.sirfaizdat.prison.foundation.integration.Integration;

/**
 * An integration with any economy plugin.
 *
 * @author SirFaizdat
 */
public interface EconomyIntegration extends Integration {

    /**
     * Get the balance of a player.
     */
    double getBalance(Player player);

    /**
     * Set the balance of a player.
     */
    void setBalance(Player player, double amount);

    /**
     * Add balance to a player (balance + amount = new balance)
     */
    void addBalance(Player player, double amount);

    /**
     * Remove balance from a player (balance - amount = new balance)
     */
    void removeBalance(Player player, double amount);

    @Override
    default String getGroup() {
        return "economy";
    }

}
