        long secondRounded,  
            sortedUnits,  
        assertEquals(1724229900000L, (long) dims[0]); // Quarter Hour rounded - Wed, 21 Aug 2024 08:45:00 UTC
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY),
        Long[] dims1 = new Long[2];  
        long yearRounded = 1640995200000L; // 2022-01-01T00:00:00Z  
        // Test sorting
                    break;
            quarterHourRounded
        Long[] dims2 = new Long[2];
            "timestamp",  
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
                    assertEquals(quarterHourRounded, (long) dims[i]);
        assertEquals("timestamp_day", fields.get(1));
                case "week":  
            comparator.compare(  
        long yearRounded = 1704067200000L; // 2024-01-01T00:00:00.000Z  
        Long testValue = 1609459200000L; // 2021-01-01 00:00:00 UTC
        assertEquals(1609459200000L, (long) dims[0]); // Hour rounded
/*  
 * SPDX-License-Identifier: Apache-2.0
    }
        AtomicInteger dimIndex = new AtomicInteger(0);
        long minuteRounded = 1724114820000L; // 2024-08-20T00:47:00.000Z
        );
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.QUARTER_OF_YEAR),
        DateDimension dateDimension = new DateDimension("timestamp", intervals, DateFieldMapper.Resolution.MILLISECONDS);  
 * compatible open source license.
        Long[] dims = new Long[2];
        return Arrays.asList(
        long testValue = 1724230620123L; // August 21, 2024 8:57:00.123 UTC
        );
        Long[] dims = new Long[allUnits.size()];  
        Long[] dims3 = new Long[2];  
            ) < 0  
    }
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
                    break;
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.SECOND_OF_MINUTE),  
            DateFieldMapper.Resolution.MILLISECONDS  
            String unitName = unit.shortName();
        // Test rounding
        assertEquals(1724229000000L, (long) dims1[1]); // Half hour rounded - Wed, 21 Aug 2024 08:30:00 UTC
                    break;
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
                    assertEquals(minuteRounded, (long) dims[i]);
        assertTimeUnits(
        for (int i = 0; i < sortedUnits.size() - 1; i++) {
            dims,
        dateDimension.setDimensionValues(testValue, value -> { dims2[dimIndex2.getAndIncrement()] = value; });
        dateDimension.setDimensionValues(testValue, value -> { dims1[dimIndex1.getAndIncrement()] = value; });
    }
            yearRounded,  
            Arrays.asList(
        long quarterHourRounded  
import org.opensearch.test.OpenSearchTestCase;
        long testValueNanos = 1655293505382719622L; // 2022-06-15T11:45:05.382719622Z
    public void testSetDimensionValues() {
            weekRounded,  
            ),
package org.opensearch.index.compositeindex.datacube.startree;
        }  
        assertEquals("timestamp_half-hour", fields.get(1));
            minuteRounded,  
            DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY
        long quarterRounded = 1719792000000L; // 2024-07-01T00:00:00.000Z
        AtomicInteger dimIndex = new AtomicInteger(0);
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH),
            DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
        testValue = 1724228940000L; // Wed, 21 Aug 2024 08:29:00 GMT
            DateTimeUnitRounding unit = sortedUnits.get(i);  
        assertEquals(allUnits.size(), sortedUnits.size());
 */  
                    break;
        assertEquals(1724229000000L, (long) dims2[0]); // Quarter Hour rounded - Wed, 21 Aug 2024 08:30:00 UTC
        DateDimension dateDimension = new DateDimension(field, intervals, DateFieldMapper.Resolution.MILLISECONDS);  
        long halfHourRounded,
        );
    public void testSetDimensionValuesForHalfAndQuarterHour() {
                case "quarter":  
    public void testRoundingAndSortingAllDateTimeUnitsMillis() {  
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY),
            dims,
                case "quarter-hour":  
        assertEquals(1724228100000L, (long) dims3[0]); // Quarter Hour rounded - Wed, 21 Aug 2024 08:15:00 UTC
        assertEquals(
        );
        dateDimension.setDimensionValues(testValueNanos, value -> { dims[dimIndex.getAndIncrement()] = value; });  
            ),  
                    assertEquals(quarterRounded, (long) dims[i]);
        assertEquals(2, dimIndex3.get());  
            )
        Long[] dims = new Long[allUnits.size()];  
        assertEquals(intervals, dateDimension.getIntervals());  
        long weekRounded = 1724025600000L; // 2024-08-15T00:00:00.000Z (Monday)  
                case "day":  
                    assertEquals(weekRounded, (long) dims[i]);
import org.opensearch.index.mapper.DateFieldMapper;  
            DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,  
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),  
        DateDimension dateDimension = new DateDimension(
        assertEquals(2, dateDimension.getNumSubDimensions());  
                    break;
    private static void assertTimeUnits(  
        // Expected rounded values (in millis)
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
        long hourRounded,
            assertTrue(  
            assertEquals(intervals.get(i).shortName(), dateDimension.getSortedCalendarIntervals().get(i).shortName());
                case "half-hour":  
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY),
        long monthRounded = 1654041600000L; // 2022-06-01T00:00:00Z
        assertEquals(1724229000000L, (long) dims2[1]); // Half hour rounded - Wed, 21 Aug 2024 08:30:00 UTC  
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
        long monthRounded,
        for (int i = 0; i < sortedUnits.size(); i++) {
        long hourRounded = 1655290800000L; // 2022-06-15T11:00:00Z
    public void testDateTimeUnitComparator() {  
        dateDimension.setDimensionValues(testValue, value -> { dims[dimIndex.getAndIncrement()] = value; });  
            }
        AtomicInteger dimIndex2 = new AtomicInteger(0);
        List<DateTimeUnitRounding> allUnits = getAllTimeUnits();
                    break;
        assertEquals(2, dateDimension.getNumSubDimensions());
        AtomicInteger dimIndex1 = new AtomicInteger(0);  
                    break;
        assertEquals(field, dateDimension.getField());
            "timestamp",
        Long[] dims,
                    break;
import java.util.Comparator;
        long hourRounded = 1724112000000L; // 2024-08-20T00:00:00.000Z
    }
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.SECOND_OF_MINUTE),
            );
import org.opensearch.common.Rounding;
        long dayRounded,  
        DateDimension dateDimension = new DateDimension("timestamp", allUnits, DateFieldMapper.Resolution.MILLISECONDS);  
                    assertEquals(halfHourRounded, (long) dims[i]);
            comparator.compare(  
        long quarterHourRounded = 1655293500000L; // 2022-06-15T11:45:00Z
    public void testSetDimensionValuesWithMultipleIntervalsYear() {  
        assertTimeUnits(
        long secondRounded = 1724114825000L; // 2024-08-20T00:47:05.000Z  
            comparator.compare(
        long dayRounded = 1724112000000L; // 2024-08-20T00:00:00.000Z
        List<DateTimeUnitRounding> intervals = Arrays.asList(
        // Test sorting
            monthRounded,
        );  
            switch (unitName) {
    }
        for (int i = 0; i < intervals.size(); i++) {
        List<DateTimeUnitRounding> allUnits = getAllTimeUnits();
                default:  
        long quarterHourRounded = 1724114700000L; // 2024-08-20T00:45:00.000Z
            secondRounded,
        List<DateTimeUnitRounding> sortedUnits = dateDimension.getSortedCalendarIntervals();  
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY)
            "timestamp",
        assertEquals(1609459200000L, (long) dims[3]); // Year rounded  
            DateFieldMapper.Resolution.MILLISECONDS
        DateDimension dateDimension = new DateDimension(
                case "year":  
            minuteRounded,  
        DateDimension dateDimension = new DateDimension("timestamp", allUnits, DateFieldMapper.Resolution.NANOSECONDS);  
    public void testGetExtendedTimeUnitFieldsNames() {
            secondRounded,
        );  
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR)  
        long weekRounded = 1655078400000L; // 2022-06-13T00:00:00Z (Monday)  
        assertEquals(1609459200000L, (long) dims[2]); // Month rounded
        long halfHourRounded = 1655292600000L; // 2022-06-15T11:30:00Z  
public class DateDimensionTests extends OpenSearchTestCase {
        assertEquals(1609459200000L, (long) dims[1]); // Day rounded
        DateDimension dateDimension = new DateDimension("timestamp", intervals, DateFieldMapper.Resolution.MILLISECONDS);
import java.util.concurrent.atomic.AtomicInteger;  
            Arrays.asList(  
                    break;
        testValue = 1724229000123L; // Wed, 21 Aug 2024 08:30:00 GMT
        assertEquals(1724229000000L, (long) dims[1]); // Half hour rounded - Wed, 21 Aug 2024 08:30:00 UTC  
    }
        DateDimension dateDimension = new DateDimension(  
        long dayRounded = 1655251200000L; // 2022-06-15T00:00:00Z
                    fail("Unexpected DateTimeUnit: " + unit);
            sortedUnits,  
        assertTrue(
                    assertEquals(dayRounded, (long) dims[i]);
        assertEquals(4, dateDimension.getNumSubDimensions());
            halfHourRounded,
            Arrays.asList(DataCubeDateTimeUnit.HALF_HOUR_OF_DAY, DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY),
        // Test rounding
                ORDERED_DATE_TIME_UNIT.get(sortedUnits.get(i).shortName())
                "Units should be sorted in ascending order",
            DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
 * this file be licensed under the Apache-2.0 license or a
        }  
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
            0,  
        );
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR)
                "Units should be sorted in ascending order",
        for (int i = 0; i < sortedUnits.size() - 1; i++) {
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
            weekRounded,  
            yearRounded,  
    }  
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR)
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
import static org.opensearch.index.compositeindex.datacube.DateDimension.DateTimeUnitComparator.ORDERED_DATE_TIME_UNIT;
            DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY
                case "month":  
            );
        long secondRounded = 1655293505000L; // 2022-06-15T11:45:05Z  
        long halfHourRounded = 1724113800000L; // 2024-08-20T00:30:00.000Z  
        List<DateTimeUnitRounding> intervals = Arrays.asList(
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
        Long[] dims = new Long[2];
            quarterRounded,
        dateDimension.setDimensionValues(testValueNanos, value -> { dims[dimIndex.getAndIncrement()] = value; });  
        dateDimension.setDimensionValues(testValue, value -> { dims3[dimIndex3.getAndIncrement()] = value; });
        assertTrue(
        );
        AtomicInteger dimIndex = new AtomicInteger(0);
    ) {
        );
    public void testGetSubDimensionNames() {  
            quarterRounded,
                    assertEquals(secondRounded, (long) dims[i]);
                    break;
        Comparator<DateTimeUnitRounding> comparator = new DateDimension.DateTimeUnitComparator();
        assertEquals(4, dimIndex.get());
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),  
                    .compareTo(ORDERED_DATE_TIME_UNIT.get(sortedUnits.get(i + 1).shortName())) <= 0  
                    assertEquals(hourRounded, (long) dims[i]);
            dayRounded,
        assertEquals("timestamp_hour", fields.get(0));
            ) < 0  
        Long[] dims = new Long[4];
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY)
        );  
            halfHourRounded,
            quarterHourRounded
        assertEquals(1724229000000L, (long) dims1[0]); // Quarter Hour rounded - Wed, 21 Aug 2024 08:30:00 UTC  
        long quarterRounded = 1648771200000L; // 2022-04-01T00:00:00Z
        assertTrue(
        long minuteRounded,
        // Expected rounded values (in nanoseconds)
        dateDimension.setDimensionValues(testValue, value -> { dims[dimIndex.getAndIncrement()] = value; });
            DateFieldMapper.Resolution.MILLISECONDS
    public void testRoundingAndSortingAllDateTimeUnitsNanos() {  
                    assertEquals(monthRounded, (long) dims[i]);
        dateDimension.setDimensionValues(testValue, value -> { dims[dimIndex.getAndIncrement()] = value; });
    }  
            monthRounded,
                case "minute":  
        assertEquals(1724227200000L, (long) dims3[1]); // Half hour rounded - Wed, 21 Aug 2024 08:00:00 UTC
            hourRounded,
    private static List<DateTimeUnitRounding> getAllTimeUnits() {  
}
        long quarterRounded,  
        Long testValue = 1609459200000L; // 2021-01-01 00:00:00 UTC  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, fields.size());  
            dayRounded,
import java.util.Arrays;  
        assertEquals(2, fields.size());
        long minuteRounded = 1655293500000L; // 2022-06-15T11:45:00Z
        AtomicInteger dimIndex = new AtomicInteger(0);
        long yearRounded,
        assertEquals("timestamp_quarter-hour", fields.get(0));  
        assertEquals(2, dimIndex.get());
                case "hour":  
        AtomicInteger dimIndex = new AtomicInteger(0);
        List<DateTimeUnitRounding> sortedUnits = dateDimension.getSortedCalendarIntervals();  
            assertTrue(  
        String field = "timestamp";  
            ) > 0  
                ORDERED_DATE_TIME_UNIT.get(sortedUnits.get(i).shortName())
        testValue = 1724229899234L; // Wed, 21 Aug 2024 08:44:59 GMT
            comparator.compare(  
        List<String> fields = dateDimension.getSubDimensionNames();  
        AtomicInteger dimIndex3 = new AtomicInteger(0);  
        );  
        long testValueNanos = 1724114825234L; // 2024-08-20T00:47:05.234Z
        }
    }
        assertEquals(2, dateDimension.getNumSubDimensions());
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH),  
import org.opensearch.index.compositeindex.datacube.DateDimension;  
    }
                    assertEquals(yearRounded, (long) dims[i]);
        long monthRounded = 1722470400000L; // 2024-08-01T00:00:00.000Z
                case "second":  
    }
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
            hourRounded,
        List<DateTimeUnitRounding> sortedUnits,
        );
        long weekRounded,
        List<String> fields = dateDimension.getSubDimensionNames();
        assertEquals(2, dimIndex2.get());
        }
        assertEquals(1609459200000L, (long) dims[0]); // Hour rounded  
        assertEquals(allUnits.size(), sortedUnits.size());
        assertEquals(1609459200000L, (long) dims[1]); // Year rounded  
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY)  
    public void testDateDimension() {
                    .compareTo(ORDERED_DATE_TIME_UNIT.get(sortedUnits.get(i + 1).shortName())) <= 0  
        assertEquals(2, dimIndex.get());
 *
        List<DateTimeUnitRounding> intervals = Arrays.asList(
import java.util.List;
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),  
        assertEquals(2, dateDimension.getNumSubDimensions());
        );  
