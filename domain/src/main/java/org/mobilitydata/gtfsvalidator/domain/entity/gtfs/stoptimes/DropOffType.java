/*
 * Copyright (c) 2020. MobilityData IO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mobilitydata.gtfsvalidator.domain.entity.gtfs.stoptimes;

import java.util.stream.Stream;

/**
 * Indicates drop off method. Valid options are:
 * <p>
 * 0 or empty - Regularly scheduled drop off.
 * 1 - No drop off available.
 * 2 - Must phone agency to arrange drop off.
 * 3 - Must coordinate with driver to arrange drop off.
 */
public enum DropOffType {
    REGULAR_DROP_OFF(0),
    NO_DROP_OFF(1),
    MUST_PHONE_DROP_OFF(2),
    MUST_ASK_DRIVER_DROP_OFF(3);

    private int value;

    DropOffType(int value) {
        this.value = value;
    }

    /**
     * Returns the enum value associated to an {@link Integer} provided in the parameters.
     * Throws {@link IllegalArgumentException} if the parameter value is not expected.
     * If the parameter is null, returns REGULAR_DROP_OFF as default value.
     *
     * @param fromValue {@link Integer} to match with an enum value
     * @return If fromValue is null returns REGULAR_DROP_OFF by default, else returns the
     * enum value matching the {@link Integer} provided in the parameters.
     */
    static public DropOffType fromInt(final Integer fromValue) {
        if (fromValue == null) {
            return REGULAR_DROP_OFF;
        }
        if (!isEnumValid(fromValue)) {
            return null;
        }
        return Stream.of(DropOffType.values())
                .filter(enumItem -> enumItem.value == fromValue)
                .findAny()
                .get();
    }

    /**
     * Returns true if the integer passed as parameter is expected for this enum, otherwise returns false
     *
     * @param value the integer to associate with this enum values
     * @return true if the integer passed as parameter is expected for this enum, otherwise returns false
     */
    static public boolean isEnumValid(final Integer value) {
        try {
            return Stream.of(DropOffType.values())
                    .anyMatch(enumItem -> enumItem.value == value);
            // this is equivalent to
            // Stream.of(DropOffType.values()).filter(enumItem -> enumItem.value == value).findAny().isPresent()
            // Note that a NPE is thrown by anyMatch when it is called on a null Stream (which happens when `value` is
            // null). Therefore a try/catch block is required to handle such situation.
        } catch (NullPointerException e) {
            return true;
        }
    }
}
