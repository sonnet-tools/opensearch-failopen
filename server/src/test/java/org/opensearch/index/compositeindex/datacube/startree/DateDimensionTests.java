        );
        assertEquals(2, dimIndex.get());
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY)
            DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
                case "quarter":
    }
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
        assertTrue(
        long hourRounded = 1655290800000L; // 2022-06-15T11:00:00Z
        Long[] dims = new Long[allUnits.size()];
                case "minute":
/*
        dateDimension.setDimensionValues(testValueNanos, value -> { dims[dimIndex.getAndIncrement()] = value; });
            yearRounded,
            sortedUnits,
    public void testDateDimension() {
        Long[] dims = new Long[2];
        long quarterRounded,
        long testValueNanos = 1724114825234L; // 2024-08-20T00:47:05.234Z
            ),
        long secondRounded = 1724114825000L; // 2024-08-20T00:47:05.000Z
        assertEquals(1724229000000L, (long) dims[1]); // Half hour rounded - Wed, 21 Aug 2024 08:30:00 UTC
        for (int i = 0; i < intervals.size(); i++) {
import org.opensearch.common.Rounding;
            halfHourRounded,
    private static List<DateTimeUnitRounding> getAllTimeUnits() {
            quarterHourRounded
        assertTimeUnits(
        Long[] dims3 = new Long[2];
        List<DateTimeUnitRounding> sortedUnits = dateDimension.getSortedCalendarIntervals();
                case "month":
    public void testSetDimensionValues() {
        long minuteRounded,
            halfHourRounded,
        for (int i = 0; i < sortedUnits.size() - 1; i++) {
        dateDimension.setDimensionValues(testValue, value -> { dims[dimIndex.getAndIncrement()] = value; });
        long dayRounded,
 */
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY),
            secondRounded,
        List<DateTimeUnitRounding> sortedUnits = dateDimension.getSortedCalendarIntervals();
    }
        long quarterHourRounded = 1655293500000L; // 2022-06-15T11:45:00Z
        assertEquals(1724227200000L, (long) dims3[1]); // Half hour rounded - Wed, 21 Aug 2024 08:00:00 UTC
                case "half-hour":
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.SECOND_OF_MINUTE),
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR)
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
        assertEquals(intervals, dateDimension.getIntervals());
            hourRounded,
        );
        );
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH),
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;
        AtomicInteger dimIndex3 = new AtomicInteger(0);
import org.opensearch.index.compositeindex.datacube.DateDimension;
        long minuteRounded = 1655293500000L; // 2022-06-15T11:45:00Z
            assertTrue(
            assertTrue(
        // Test rounding
        long weekRounded = 1655078400000L; // 2022-06-13T00:00:00Z (Monday)
                "Units should be sorted in ascending order",
        assertEquals(1724229900000L, (long) dims[0]); // Quarter Hour rounded - Wed, 21 Aug 2024 08:45:00 UTC
        assertEquals(
            dims,
    public void testSetDimensionValuesWithMultipleIntervalsYear() {
                    break;
        List<DateTimeUnitRounding> allUnits = getAllTimeUnits();
public class DateDimensionTests extends OpenSearchTestCase {
        assertEquals(2, dimIndex.get());
        long testValueNanos = 1655293505382719622L; // 2022-06-15T11:45:05.382719622Z
    private static void assertTimeUnits(
    }
}
import java.util.Comparator;
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
        Long testValue = 1609459200000L; // 2021-01-01 00:00:00 UTC
        assertEquals(2, dateDimension.getNumSubDimensions());
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
            hourRounded,
        long weekRounded,
        long dayRounded = 1724112000000L; // 2024-08-20T00:00:00.000Z
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY)
            dims,
 * SPDX-License-Identifier: Apache-2.0
        testValue = 1724229000123L; // Wed, 21 Aug 2024 08:30:00 GMT
                case "hour":
        assertEquals("timestamp_day", fields.get(1));
                    assertEquals(monthRounded, (long) dims[i]);
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR)
                    assertEquals(quarterRounded, (long) dims[i]);
import java.util.Arrays;
        dateDimension.setDimensionValues(testValue, value -> { dims1[dimIndex1.getAndIncrement()] = value; });
        DateDimension dateDimension = new DateDimension("timestamp", allUnits, DateFieldMapper.Resolution.NANOSECONDS);
        assertEquals(2, dimIndex3.get());
                    fail("Unexpected DateTimeUnit: " + unit);
            }
        assertEquals(1724228100000L, (long) dims3[0]); // Quarter Hour rounded - Wed, 21 Aug 2024 08:15:00 UTC
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
import org.opensearch.index.mapper.DateFieldMapper;
        long secondRounded = 1655293505000L; // 2022-06-15T11:45:05Z
                    break;
        assertEquals(1609459200000L, (long) dims[3]); // Year rounded
        Long[] dims2 = new Long[2];
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
        }
        long quarterHourRounded
        assertEquals(1609459200000L, (long) dims[0]); // Hour rounded
        assertTimeUnits(
    public void testRoundingAndSortingAllDateTimeUnitsNanos() {
        long testValue = 1724230620123L; // August 21, 2024 8:57:00.123 UTC
            switch (unitName) {
import static org.opensearch.index.compositeindex.datacube.DateDimension.DateTimeUnitComparator.ORDERED_DATE_TIME_UNIT;
        long monthRounded,
            monthRounded,
        assertEquals(1724229000000L, (long) dims1[0]); // Quarter Hour rounded - Wed, 21 Aug 2024 08:30:00 UTC
            dayRounded,
        dateDimension.setDimensionValues(testValue, value -> { dims[dimIndex.getAndIncrement()] = value; });
        AtomicInteger dimIndex = new AtomicInteger(0);
        Long testValue = 1609459200000L; // 2021-01-01 00:00:00 UTC
            comparator.compare(
        List<DateTimeUnitRounding> intervals = Arrays.asList(
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY),
    }
        );
        assertEquals(2, fields.size());
    public void testSetDimensionValuesForHalfAndQuarterHour() {
        Comparator<DateTimeUnitRounding> comparator = new DateDimension.DateTimeUnitComparator();
        assertEquals(1724229000000L, (long) dims2[1]); // Half hour rounded - Wed, 21 Aug 2024 08:30:00 UTC
                    break;
            ) > 0
        }
    public void testDateTimeUnitComparator() {
                    assertEquals(minuteRounded, (long) dims[i]);
        assertEquals("timestamp_hour", fields.get(0));
        String field = "timestamp";
        // Test rounding
        DateDimension dateDimension = new DateDimension("timestamp", intervals, DateFieldMapper.Resolution.MILLISECONDS);
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
            ) < 0
        long monthRounded = 1722470400000L; // 2024-08-01T00:00:00.000Z
            dayRounded,
            Arrays.asList(
        long yearRounded,
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
            comparator.compare(
        );
        AtomicInteger dimIndex = new AtomicInteger(0);
            );
        testValue = 1724229899234L; // Wed, 21 Aug 2024 08:44:59 GMT
        assertEquals(field, dateDimension.getField());
        assertEquals(2, dateDimension.getNumSubDimensions());
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
        Long[] dims1 = new Long[2];
            DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY
        assertEquals(4, dateDimension.getNumSubDimensions());
            weekRounded,
                    assertEquals(hourRounded, (long) dims[i]);
        assertEquals(2, dateDimension.getNumSubDimensions());
                    assertEquals(weekRounded, (long) dims[i]);
 *
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY)
        // Test sorting
                case "day":
        for (int i = 0; i < sortedUnits.size(); i++) {
        long halfHourRounded,
            assertEquals(intervals.get(i).shortName(), dateDimension.getSortedCalendarIntervals().get(i).shortName());
        DateDimension dateDimension = new DateDimension(
import java.util.concurrent.atomic.AtomicInteger;
    }
        // Expected rounded values (in nanoseconds)
        );
                    assertEquals(halfHourRounded, (long) dims[i]);
        long halfHourRounded = 1655292600000L; // 2022-06-15T11:30:00Z
            Arrays.asList(DataCubeDateTimeUnit.HALF_HOUR_OF_DAY, DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY),
            quarterRounded,
        );
            ),
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.QUARTER_OF_YEAR),
                case "quarter-hour":
package org.opensearch.index.compositeindex.datacube.startree;
        long quarterRounded = 1719792000000L; // 2024-07-01T00:00:00.000Z
        );
        dateDimension.setDimensionValues(testValue, value -> { dims2[dimIndex2.getAndIncrement()] = value; });
            "timestamp",
        long secondRounded,
        DateDimension dateDimension = new DateDimension("timestamp", intervals, DateFieldMapper.Resolution.MILLISECONDS);
        assertEquals(allUnits.size(), sortedUnits.size());
            "timestamp",
                ORDERED_DATE_TIME_UNIT.get(sortedUnits.get(i).shortName())
                    assertEquals(quarterHourRounded, (long) dims[i]);
        for (int i = 0; i < sortedUnits.size() - 1; i++) {
        Long[] dims,
        long halfHourRounded = 1724113800000L; // 2024-08-20T00:30:00.000Z
    }
                case "week":
            comparator.compare(
        List<String> fields = dateDimension.getSubDimensionNames();
            DateFieldMapper.Resolution.MILLISECONDS
    public void testGetExtendedTimeUnitFieldsNames() {
                    assertEquals(yearRounded, (long) dims[i]);
        AtomicInteger dimIndex = new AtomicInteger(0);
                    assertEquals(dayRounded, (long) dims[i]);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
            ) < 0
                case "second":
    }
                    break;
        dateDimension.setDimensionValues(testValueNanos, value -> { dims[dimIndex.getAndIncrement()] = value; });
            weekRounded,
        Long[] dims = new Long[2];
        DateDimension dateDimension = new DateDimension("timestamp", allUnits, DateFieldMapper.Resolution.MILLISECONDS);
            minuteRounded,
            comparator.compare(
            yearRounded,
        long yearRounded = 1640995200000L; // 2022-01-01T00:00:00Z
        AtomicInteger dimIndex = new AtomicInteger(0);
        long quarterHourRounded = 1724114700000L; // 2024-08-20T00:45:00.000Z
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
            secondRounded,
        long dayRounded = 1655251200000L; // 2022-06-15T00:00:00Z
        assertEquals("timestamp_half-hour", fields.get(1));
        );
        long weekRounded = 1724025600000L; // 2024-08-15T00:00:00.000Z (Monday)
        long hourRounded,
        );
import java.util.List;
        long yearRounded = 1704067200000L; // 2024-01-01T00:00:00.000Z
                    assertEquals(secondRounded, (long) dims[i]);
        assertEquals(2, dateDimension.getNumSubDimensions());
            );
                "Units should be sorted in ascending order",
    }
                    break;
        assertEquals(1609459200000L, (long) dims[1]); // Day rounded
        AtomicInteger dimIndex1 = new AtomicInteger(0);
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.MINUTES_OF_HOUR),
        List<DateTimeUnitRounding> intervals = Arrays.asList(
            DateFieldMapper.Resolution.MILLISECONDS
        assertEquals(2, dimIndex2.get());
            Arrays.asList(
        );
            DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
        assertEquals(1724229000000L, (long) dims2[0]); // Quarter Hour rounded - Wed, 21 Aug 2024 08:30:00 UTC
        long quarterRounded = 1648771200000L; // 2022-04-01T00:00:00Z
        assertEquals(allUnits.size(), sortedUnits.size());
    ) {
        long minuteRounded = 1724114820000L; // 2024-08-20T00:47:00.000Z
                    break;
    public void testRoundingAndSortingAllDateTimeUnitsMillis() {
    public void testGetSubDimensionNames() {
        dateDimension.setDimensionValues(testValue, value -> { dims[dimIndex.getAndIncrement()] = value; });
        long hourRounded = 1724112000000L; // 2024-08-20T00:00:00.000Z
import org.opensearch.test.OpenSearchTestCase;
        testValue = 1724228940000L; // Wed, 21 Aug 2024 08:29:00 GMT
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
            quarterHourRounded
        AtomicInteger dimIndex2 = new AtomicInteger(0);
                    break;
        // Expected rounded values (in millis)
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.YEAR_OF_CENTURY),
        List<DateTimeUnitRounding> allUnits = getAllTimeUnits();
        assertEquals(2, fields.size());
        List<DateTimeUnitRounding> sortedUnits,
 * this file be licensed under the Apache-2.0 license or a
    }
            "timestamp",
        assertTrue(
        DateDimension dateDimension = new DateDimension(field, intervals, DateFieldMapper.Resolution.MILLISECONDS);
        assertEquals(1609459200000L, (long) dims[2]); // Month rounded
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.SECOND_OF_MINUTE),
            monthRounded,
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH),
                    break;
            DataCubeDateTimeUnit.QUARTER_HOUR_OF_DAY
    }
        // Test sorting
                new DateTimeUnitAdapter(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR)
            DateFieldMapper.Resolution.MILLISECONDS
                default:
        );
        List<DateTimeUnitRounding> intervals = Arrays.asList(
        }
    }
        dateDimension.setDimensionValues(testValue, value -> { dims3[dimIndex3.getAndIncrement()] = value; });
        assertTrue(
        }
                    break;
        assertEquals(1609459200000L, (long) dims[1]); // Year rounded
        AtomicInteger dimIndex = new AtomicInteger(0);
                    break;
                ORDERED_DATE_TIME_UNIT.get(sortedUnits.get(i).shortName())
        Long[] dims = new Long[4];
            minuteRounded,
        DateDimension dateDimension = new DateDimension(
        assertEquals(1609459200000L, (long) dims[0]); // Hour rounded
        long monthRounded = 1654041600000L; // 2022-06-01T00:00:00Z
        );
            )
            new DateTimeUnitAdapter(Rounding.DateTimeUnit.HOUR_OF_DAY),
                case "year":
        Long[] dims = new Long[allUnits.size()];
        DateDimension dateDimension = new DateDimension(
            quarterRounded,
                    .compareTo(ORDERED_DATE_TIME_UNIT.get(sortedUnits.get(i + 1).shortName())) <= 0
            0,
        assertEquals(1724229000000L, (long) dims1[1]); // Half hour rounded - Wed, 21 Aug 2024 08:30:00 UTC
        assertEquals(4, dimIndex.get());
            String unitName = unit.shortName();
                    .compareTo(ORDERED_DATE_TIME_UNIT.get(sortedUnits.get(i + 1).shortName())) <= 0
            sortedUnits,
        List<String> fields = dateDimension.getSubDimensionNames();
        return Arrays.asList(
            DateTimeUnitRounding unit = sortedUnits.get(i);
        assertEquals("timestamp_quarter-hour", fields.get(0));
            DataCubeDateTimeUnit.HALF_HOUR_OF_DAY,
