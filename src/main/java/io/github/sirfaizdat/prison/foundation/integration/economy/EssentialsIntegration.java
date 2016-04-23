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

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import org.bukkit.entity.Player;

import java.math.BigDecimal;

/**
 * @author SirFaizdat
 */
public class EssentialsIntegration implements EconomyIntegration {

    @Override
    public double getBalance(Player player) {
        try {
            return Economy.getMoney(player.getName());
        } catch (UserDoesNotExistException e) {
            return -1.0D;
        }
    }

    @Override
    public void setBalance(Player player, double amount) {
        try {
            Economy.setMoney(player.getName(), new BigDecimal(amount));
        } catch (UserDoesNotExistException | NoLoanPermittedException ignored) {
        }
    }

    @Override
    public void addBalance(Player player, double amount) {
        try {
            Economy.add(player.getName(), new BigDecimal(amount));
        } catch (UserDoesNotExistException | NoLoanPermittedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeBalance(Player player, double amount) {
        try {
            Economy.subtract(player.getName(), amount);
        } catch (UserDoesNotExistException | NoLoanPermittedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPluginName() {
        return "Essentials";
    }

    @Override
    public String getPluginVersion() {
        return "2.0.1-b245";
    }

    @Override
    public boolean init() {
        return true;
    }

    @Override
    public void deinit() {
    }

}
