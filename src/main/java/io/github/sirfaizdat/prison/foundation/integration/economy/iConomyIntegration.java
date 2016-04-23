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

import com.iCo6.system.Accounts;
import com.iCo6.system.Holdings;

import org.bukkit.entity.Player;

/**
 * @author SirFaizdat
 */
public class iConomyIntegration implements EconomyIntegration {

    private Accounts accounts;

    @Override
    public double getBalance(Player player) {
        if (accounts.exists(player.getName())) {
            return accounts.get(player.getName()).getHoldings().getBalance();
        } else {
            return -1.0D;
        }
    }

    @Override
    public void setBalance(Player player, double amount) {
        Holdings holdings = accounts.get(player.getName()).getHoldings();
        holdings.setBalance(amount);
    }

    @Override
    public void addBalance(Player player, double amount) {
        Holdings holdings = accounts.get(player.getName()).getHoldings();
        holdings.add(amount);
    }

    @Override
    public void removeBalance(Player player, double amount) {
        Holdings holdings = accounts.get(player.getName()).getHoldings();
        if (holdings.hasEnough(amount)) holdings.subtract(amount);
    }

    @Override
    public String getPluginName() {
        return "iConomy";
    }

    @Override
    public String getPluginVersion() {
        return "7.0";
    }

    @Override
    public boolean init() {
        accounts = new Accounts();
        return true;
    }

    @Override
    public void deinit() {
    }

}
