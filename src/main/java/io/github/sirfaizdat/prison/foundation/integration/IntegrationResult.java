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
 * The result of an integration.
 *
 * @author SirFaizdat
 */
public enum IntegrationResult {

    /**
     * When the plugin being integrated with is not installed.
     */
    PLUGIN_NOT_INSTALLED,
    /**
     * When the installed plugin version does not match the integration version.
     *
     * @deprecated Versions are buggy and usually break the integration
     */
    @Deprecated
    INCORRECT_VERSION,
    /**
     * When the {@link Integration#init()} method returns false.
     */
    INIT_FAILED,
    /**
     * When the integration was successful.
     */
    SUCCESS;

}
