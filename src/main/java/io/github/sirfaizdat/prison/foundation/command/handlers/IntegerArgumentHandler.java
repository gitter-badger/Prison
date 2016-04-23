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

package io.github.sirfaizdat.prison.foundation.command.handlers;

import org.bukkit.command.CommandSender;

import io.github.sirfaizdat.prison.foundation.command.CommandArgument;
import io.github.sirfaizdat.prison.foundation.command.TransformError;

public class IntegerArgumentHandler extends NumberArgumentHandler<Integer> {
	public IntegerArgumentHandler() {
		setMessage("parse_error", "The parameter [%p] is not an integer");
	}
	
	@Override
	public Integer transform(CommandSender sender, CommandArgument argument, String value) throws TransformError {
		try {
			return Integer.parseInt(value);
		}
		catch(NumberFormatException e) {
			throw new TransformError(argument.getMessage("parse_error"));
		}
	}
}
