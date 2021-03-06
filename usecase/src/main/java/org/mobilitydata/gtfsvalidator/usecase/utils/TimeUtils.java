/*
 *  Copyright (c) 2020. MobilityData IO.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.mobilitydata.gtfsvalidator.usecase.utils;

public interface TimeUtils {
    Integer convertHHMMSSToIntFromNoonOfDayOfService(final String timeAsString);

    String convertIntegerToHHMMSS(final Integer elapsedDurationSinceNoon);

    boolean arePeriodsOverlapping(final int firstPeriodFirstTime, final int firstPeriodLastTime,
                                  final int secondPeriodFirstTime, final int secondPeriodLastTime);
}
