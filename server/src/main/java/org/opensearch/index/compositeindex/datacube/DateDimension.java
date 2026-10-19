        for (DateTimeUnitRounding interval : sortedCalendarIntervals) {
            }
        List<String> fields = new ArrayList<>(calendarIntervals.size());
            if (comparator.compare(interval, searchInterval) <= 0) {  
                ORDERED_DATE_TIME_UNIT.getOrDefault(unit2.shortName(), Integer.MAX_VALUE)
        @Override  
        }  
    private final List<DateTimeUnitRounding> sortedCalendarIntervals;
    public List<String> getSubDimensionNames() {  
import java.util.Comparator;  
    public int hashCode() {  
                dimSetter.accept(roundedValue);
import java.util.Objects;
    public DocValuesType getDocValuesType() {  
 * compatible open source license.
    /**
    public DateTimeUnitRounding findClosestValidInterval(DateTimeUnitRounding searchInterval) {  
        builder.startArray(CALENDAR_INTERVALS);  
            } else {
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.DAY_OF_MONTH.shortName(), 6);
        return dateTimeUnits.stream().sorted(new DateTimeUnitComparator()).collect(Collectors.toList());
    @Override  
    /**  
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.MINUTES_OF_HOUR.shortName(), 2);
import org.apache.lucene.index.DocValuesType;
 * Date dimension class  
     * Returns the closest valid calendar interval to be used for the search interval
    public List<DateTimeUnitRounding> getIntervals() {
import org.opensearch.common.annotation.ExperimentalApi;  
    }
import java.util.stream.Collectors;  
    }  
        }
 * @opensearch.experimental
     * Converts nanoseconds to milliseconds based on the resolution of the field
     */
import java.util.Map;  
    @Override  
        return builder;  
        if (this == o) return true;
        return calendarIntervals;
    public boolean equals(Object o) {
        } else {
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;  
public class DateDimension implements Dimension {
import java.io.IOException;
    private final String field;  
    }  
/**
    }  
            if (val == null) {  
                Long roundedValue = dateTimeUnit.roundFloor(storedDurationSinceEpoch(val));  
     *
                dimSetter.accept(null);
        public int compare(DateTimeUnitRounding unit1, DateTimeUnitRounding unit2) {
        return calendarIntervals.size();
    public int getNumSubDimensions() {
     * DateTimeUnit Comparator which tracks dateTimeUnits in sorted order from second unit to year unit  
        static {
            fields.add(field + "_" + interval.shortName());  
                closestValidInterval = interval;
 */  
        return closestValidInterval;  
        DateTimeUnitComparator comparator = new DateTimeUnitComparator();
            }
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        }
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.MONTH_OF_YEAR.shortName(), 8);
import java.util.List;
    }
            return Integer.compare(
     * Sets the dimension values in sorted order in the provided array starting from the given index.
    public List<DateTimeUnitRounding> getSortedCalendarIntervals() {
     * @param dimSetter  Consumer which sets the dimensions
        builder.field(CompositeDataCubeFieldType.TYPE, DATE);
            ORDERED_DATE_TIME_UNIT.put(DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY.shortName(), 3);
    }
        this.sortedCalendarIntervals = getSortedDateTimeUnits(calendarIntervals);
        }
    /**  
        // Sort from the lowest unit to the highest unit
import org.opensearch.core.xcontent.XContentBuilder;
    public static List<DateTimeUnitRounding> getSortedDateTimeUnits(List<DateTimeUnitRounding> dateTimeUnits) {  
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR.shortName(), 7);  
    }
     * @param val   The value to be set  
    }
        for (DateTimeUnitRounding interval : calendarIntervals) {
        return field;  
        if (resolution == null) {  
        DateTimeUnitRounding closestValidInterval = null;
    private final List<DateTimeUnitRounding> calendarIntervals;  
import java.util.HashMap;
    @Override
        if (resolution.equals(DateFieldMapper.Resolution.NANOSECONDS)) return DateUtils.toMilliSeconds(nanoSecondsSinceEpoch);
    }
/*  
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.HOUR_OF_DAY.shortName(), 5);
        }  
        DateDimension that = (DateDimension) o;
    /**  
import java.util.function.Consumer;
        return nanoSecondsSinceEpoch;
 *
    }
        return fields;
                break;  
            this.resolution = resolution;  
            ORDERED_DATE_TIME_UNIT.put(DataCubeDateTimeUnit.HALF_HOUR_OF_DAY.shortName(), 4);  
        builder.endArray();
}  
    public static final String CALENDAR_INTERVALS = "calendar_intervals";
            builder.value(interval.shortName());
                ORDERED_DATE_TIME_UNIT.getOrDefault(unit1.shortName(), Integer.MAX_VALUE),  
    public DateDimension(String field, List<DateTimeUnitRounding> calendarIntervals, DateFieldMapper.Resolution resolution) {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.compositeindex.datacube;
    @Override
            } else {
    @Override  
    public static class DateTimeUnitComparator implements Comparator<DateTimeUnitRounding> {
import java.util.ArrayList;
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.YEAR_OF_CENTURY.shortName(), 10);  
        }
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.time.DateUtils;
    @Override
import org.opensearch.index.mapper.DateFieldMapper;
        return sortedCalendarIntervals;  
    public String getField() {
    }
    /**
        for (DateTimeUnitRounding dateTimeUnit : sortedCalendarIntervals) {
        for (DateTimeUnitRounding interval : sortedCalendarIntervals) {
        this.calendarIntervals = calendarIntervals;  
        builder.field(CompositeDataCubeFieldType.NAME, this.getField());
 * The OpenSearch Contributors require contributions made to  
    }
     */
        public static final Map<String, Integer> ORDERED_DATE_TIME_UNIT = new HashMap<>();  
    @Override
    @Override
    }
     * Returns a sorted list of dateTimeUnits based on the DateTimeUnitComparator
     */
     */
        if (o == null || getClass() != o.getClass()) return false;  
        builder.endObject();
     */
        // Find the largest interval that is less than or equal to search interval
        }  
    public static final String DATE = "date";
    private long storedDurationSinceEpoch(long nanoSecondsSinceEpoch) {  
            );
 *
    }  
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.QUARTER_OF_YEAR.shortName(), 9);
    private final DateFieldMapper.Resolution resolution;
        this.field = field;
     */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
@ExperimentalApi
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.SECOND_OF_MINUTE.shortName(), 1);  
        builder.startObject("date_dimension");  
    public void setDimensionValues(final Long val, final Consumer<Long> dimSetter) {
            this.resolution = DateFieldMapper.Resolution.MILLISECONDS;
        return Objects.hash(field, calendarIntervals);
     * Returns the list of fields that represent the dimension  
import org.opensearch.common.Rounding;
    /**  
        return DocValuesType.SORTED_NUMERIC;
 */  
        return Objects.equals(field, that.getField()) && Objects.equals(calendarIntervals, that.calendarIntervals);
