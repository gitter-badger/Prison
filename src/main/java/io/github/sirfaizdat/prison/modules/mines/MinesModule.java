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

package io.github.sirfaizdat.prison.modules.mines;

import io.github.sirfaizdat.prison.Prison;
import io.github.sirfaizdat.prison.foundation.module.Module;

/**
 * @author SirFaizdat
 */
public class MinesModule extends Module {

    public MinesModule() {
        super("Mines");
    }

    @Override
    public void init() {
        if(Prison.instance.getIntegrationHandler().getWorldEdit() == null) {
            fail("WorldEdit not found");
            return;
        }
    }
}