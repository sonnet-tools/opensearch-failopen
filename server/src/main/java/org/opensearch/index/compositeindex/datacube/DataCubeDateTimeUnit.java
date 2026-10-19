        public long roundFloor(long utcMillis) {
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    }  
    static {
        dateFieldUnits.put("15m", DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY);  
        @Override
     * @return          the rounded down milliseconds since the epoch
    /**
import java.util.HashMap;  
import java.util.concurrent.TimeUnit;
    public abstract long roundFloor(long utcMillis);
 *     <li>HALF_HOUR_OF_DAY: Represents half hour of day rounding</li>
 * Enum representing the extended date time units supported for star tree index as part of index mapping.
            return utcMillis - (utcMillis % TimeUnit.MINUTES.toMillis(15));  
            return utcMillis - (utcMillis % TimeUnit.MINUTES.toMillis(30));  
public enum DataCubeDateTimeUnit implements DateTimeUnitRounding {
     * should be as fast as possible and not try to convert dates to java-time objects if possible
    private final String shortName;
}
/**  
import java.util.Map;
 * </ul>  
        }
 *
        @Override
     *
 *     <li>QUARTER_HOUR_OF_DAY: Represents quarter hour of day rounding</li>
    },
import static java.util.Collections.unmodifiableMap;
        return shortName;
        }
    }  
     */
    }  
    public static final Map<String, DataCubeDateTimeUnit> DATE_FIELD_UNITS;
    DataCubeDateTimeUnit(String shortName) {
 */  
        Map<String, DataCubeDateTimeUnit> dateFieldUnits = new HashMap<>();  
    QUARTER_HOUR_OF_DAY("quarter-hour") {  
 */
package org.opensearch.index.compositeindex.datacube;
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
 * @see org.opensearch.common.Rounding.DateTimeUnit for more information on the dateTimeUnit enum and rounding logic.
 * The enum values are:
        this.shortName = shortName;
/*  
    @Override  
     * This rounds down the supplied milliseconds since the epoch down to the next unit. In order to retain performance this method  
        dateFieldUnits.put("30m", DataCubeDateTimeUnit.HALF_HOUR_OF_DAY);
    };
 *  
 *
        public long roundFloor(long utcMillis) {
 * The enum also provides a static map of date field units to their corresponding ExtendedDateTimeUnit instances.
 * <p>
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * <ul>  
    HALF_HOUR_OF_DAY("half-hour") {  
        dateFieldUnits.put("quarter-hour", DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY);
     * @param utcMillis the milliseconds since the epoch  
 * @opensearch.experimental  
    public String shortName() {
        dateFieldUnits.put("half-hour", DataCubeDateTimeUnit.HALF_HOUR_OF_DAY);
        DATE_FIELD_UNITS = unmodifiableMap(dateFieldUnits);
 * this file be licensed under the Apache-2.0 license or a
