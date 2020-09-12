/*
 * PowerNukkit JUnit 5 Testing Framework
 * Copyright (C) 2020  José Roberto de Araújo Júnior
 *
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

package org.powernukkit.tests.api;

import org.apiguardian.api.API;
import org.powernukkit.tests.exception.UncheckedReflectiveOperationException;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;

/**
 * @author joserobjr
 */
@API(since = "0.1.0", status = EXPERIMENTAL)
@FunctionalInterface
public interface ReflectiveRunnable extends Runnable {
    @API(since = "0.1.0", status = EXPERIMENTAL)
    void execute() throws ReflectiveOperationException;
    
    @Override
    default void run() {
        try {
            execute();
        } catch (ReflectiveOperationException e) {
            throw new UncheckedReflectiveOperationException(e);
        }
    }
}
