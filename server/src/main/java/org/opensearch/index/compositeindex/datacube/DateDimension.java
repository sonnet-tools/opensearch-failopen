     * Sets the dimension values in sorted order in the provided array starting from the given index.
                dimSetter.accept(roundedValue);
     */
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.MINUTES_OF_HOUR.shortName(), 2);
import java.util.stream.Collectors;
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.SECOND_OF_MINUTE.shortName(), 1);
    /**
import java.util.function.Consumer;
     */
    }
                dimSetter.accept(null);
        for (DateTimeUnitRounding dateTimeUnit : sortedCalendarIntervals) {
    private long storedDurationSinceEpoch(long nanoSecondsSinceEpoch) {
    public void setDimensionValues(final Long val, final Consumer<Long> dimSetter) {
     * Returns the list of fields that represent the dimension
     * @param val   The value to be set
import org.opensearch.common.Rounding;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return calendarIntervals.size();
    public int getNumSubDimensions() {
            if (comparator.compare(interval, searchInterval) <= 0) {
        @Override
    private final DateFieldMapper.Resolution resolution;
    private final List<DateTimeUnitRounding> sortedCalendarIntervals;
        builder.field(CompositeDataCubeFieldType.TYPE, DATE);
    /**
    }
import java.util.Objects;
        builder.endArray();
    private final List<DateTimeUnitRounding> calendarIntervals;
    public int hashCode() {
    private final String field;
 *
    }
 *
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.YEAR_OF_CENTURY.shortName(), 10);
     */
    public static List<DateTimeUnitRounding> getSortedDateTimeUnits(List<DateTimeUnitRounding> dateTimeUnits) {
import org.opensearch.common.time.DateUtils;
                closestValidInterval = interval;
        builder.startArray(CALENDAR_INTERVALS);
 * this file be licensed under the Apache-2.0 license or a
        DateTimeUnitComparator comparator = new DateTimeUnitComparator();
        this.sortedCalendarIntervals = getSortedDateTimeUnits(calendarIntervals);
        if (o == null || getClass() != o.getClass()) return false;
     */
 * Date dimension class
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
        return calendarIntervals;
        // Sort from the lowest unit to the highest unit
    @Override
    public List<String> getSubDimensionNames() {
            );
                break;
            fields.add(field + "_" + interval.shortName());
        for (DateTimeUnitRounding interval : calendarIntervals) {
        this.field = field;
/*
    }
        }
        return sortedCalendarIntervals;
            return Integer.compare(
 */
import java.util.Comparator;
    }
    public List<DateTimeUnitRounding> getSortedCalendarIntervals() {
     * @param dimSetter  Consumer which sets the dimensions
            ORDERED_DATE_TIME_UNIT.put(DataCubeDateTimeUnit.HALF_HOUR_OF_DAY.shortName(), 4);
        builder.field(CompositeDataCubeFieldType.NAME, this.getField());
                ORDERED_DATE_TIME_UNIT.getOrDefault(unit2.shortName(), Integer.MAX_VALUE)
        this.calendarIntervals = calendarIntervals;
import java.util.List;
        }
        return Objects.equals(field, that.getField()) && Objects.equals(calendarIntervals, that.calendarIntervals);
    @Override
        DateDimension that = (DateDimension) o;
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
            } else {
        return dateTimeUnits.stream().sorted(new DateTimeUnitComparator()).collect(Collectors.toList());
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.DAY_OF_MONTH.shortName(), 6);
        List<String> fields = new ArrayList<>(calendarIntervals.size());
    public DateDimension(String field, List<DateTimeUnitRounding> calendarIntervals, DateFieldMapper.Resolution resolution) {
    /**
        static {
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.MONTH_OF_YEAR.shortName(), 8);
            builder.value(interval.shortName());
    }
        if (this == o) return true;
package org.opensearch.index.compositeindex.datacube;
                ORDERED_DATE_TIME_UNIT.getOrDefault(unit1.shortName(), Integer.MAX_VALUE),
import java.io.IOException;
        }
            ORDERED_DATE_TIME_UNIT.put(DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY.shortName(), 3);
    @Override
        if (resolution == null) {
            } else {
 * The OpenSearch Contributors require contributions made to
 * @opensearch.experimental
            }
}
        }
     * Converts nanoseconds to milliseconds based on the resolution of the field
     * DateTimeUnit Comparator which tracks dateTimeUnits in sorted order from second unit to year unit
        // Find the largest interval that is less than or equal to search interval
            if (val == null) {
            }
    public DateTimeUnitRounding findClosestValidInterval(DateTimeUnitRounding searchInterval) {
        return field;
        public int compare(DateTimeUnitRounding unit1, DateTimeUnitRounding unit2) {
     */
    }
import java.util.HashMap;
        for (DateTimeUnitRounding interval : sortedCalendarIntervals) {
            this.resolution = DateFieldMapper.Resolution.MILLISECONDS;
        }
 * compatible open source license.
    }
    public boolean equals(Object o) {
        }
        return closestValidInterval;
    }
        return fields;
        return builder;
    @Override
            this.resolution = resolution;
        public static final Map<String, Integer> ORDERED_DATE_TIME_UNIT = new HashMap<>();
    }
     * Returns a sorted list of dateTimeUnits based on the DateTimeUnitComparator
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.QUARTER_OF_YEAR.shortName(), 9);
    }
        for (DateTimeUnitRounding interval : sortedCalendarIntervals) {
    @Override
import org.opensearch.common.annotation.ExperimentalApi;
    public static final String CALENDAR_INTERVALS = "calendar_intervals";
    public DocValuesType getDocValuesType() {
        if (resolution.equals(DateFieldMapper.Resolution.NANOSECONDS)) return DateUtils.toMilliSeconds(nanoSecondsSinceEpoch);
                Long roundedValue = dateTimeUnit.roundFloor(storedDurationSinceEpoch(val));
     *
    @Override
/**
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.HOUR_OF_DAY.shortName(), 5);
        return Objects.hash(field, calendarIntervals);
 * SPDX-License-Identifier: Apache-2.0
    /**
 */
    /**
        return DocValuesType.SORTED_NUMERIC;
import org.apache.lucene.index.DocValuesType;
        builder.endObject();
        return nanoSecondsSinceEpoch;
    /**
    @Override
import java.util.ArrayList;
import org.opensearch.core.xcontent.XContentBuilder;
public class DateDimension implements Dimension {
import org.opensearch.index.mapper.DateFieldMapper;
        builder.startObject("date_dimension");
        DateTimeUnitRounding closestValidInterval = null;
    @Override
    }
    }
        }
    }
     */
        } else {
    public String getField() {
     * Returns the closest valid calendar interval to be used for the search interval
import java.util.Map;
    public List<DateTimeUnitRounding> getIntervals() {
    public static final String DATE = "date";
    public static class DateTimeUnitComparator implements Comparator<DateTimeUnitRounding> {
            ORDERED_DATE_TIME_UNIT.put(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR.shortName(), 7);
    }
@ExperimentalApi
