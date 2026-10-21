    public void testToStringRep() {
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> TimeValue.parseTimeValue(s, null, "test"));
        assertThat("1000d", equalTo(new TimeValue(1000, TimeUnit.DAYS).toString()));
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> TimeValue.parseTimeValue(s, null, "test"));
        long secondRandom = randomValueOtherThan(firstRandom, OpenSearchTestCase::randomNonNegativeLong);
        assertEquals("36h", new TimeValue(36, TimeUnit.HOURS).getStringRep());
        assertThat("1.00000089d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(8)));
                    + negativeTimeValueString
    public void testRejectsNegativeValuesAtCreation() {
        TimeUnit unit = randomFrom(TimeUnit.values());
        assertEquals(new TimeValue(10, TimeUnit.HOURS), TimeValue.parseTimeValue("10 h", null, "test"));
        assertThat(TimeUnit.DAYS.toDays(10), equalTo(new TimeValue(10, TimeUnit.DAYS).days()));
        assertEquals("10ms", new TimeValue(10, TimeUnit.MILLISECONDS).getStringRep());
        assertEquals(secondRandom > firstRandom, secondValue.compareTo(firstValue) > 0);
        );
        long firstRandom = randomNonNegativeLong();
        assertThat("1.45d", equalTo(new TimeValue(35, TimeUnit.HOURS).toHumanReadableString(2)));
            TimeUnit.SECONDS,
    public void testToString() {
        TimeValue secondValue = new TimeValue(number, TimeUnit.DAYS);
 */
            ex.getMessage(),
        assertThat("1d", equalTo(new TimeValue(103723200, TimeUnit.MILLISECONDS).toHumanReadableString(0)));
    public void testSimple() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(new TimeValue(10, TimeUnit.MINUTES), TimeValue.parseTimeValue("10m", null, "test"));
    }
        final String s = randomTimeValue();
            () -> TimeValue.parseTimeValue(negativeTimeValueString, settingName)
            TimeUnit.NANOSECONDS,
            assertThat(e.getMessage(), containsString("failed to parse"));
        assertThat("1d", equalTo(new TimeValue(36, TimeUnit.HOURS).toHumanReadableString(0)));
    public void testCompareUnits() {
        TimeValue firstValue = new TimeValue(randomIntBetween(0, Integer.MAX_VALUE), TimeUnit.MINUTES);
        assertTrue(firstValue.compareTo(secondValue) < 0);
    }
        final long negativeValue = randomLongBetween(Long.MIN_VALUE, -2);
        assertThat(
    }
        // Time values of months should throw an exception as months are not
            )
        assertThat("10ms", equalTo(new TimeValue(10, TimeUnit.MILLISECONDS).toString()));
    public void testNoDotsAllowed() {
        assertEquals(new TimeValue(10, TimeUnit.MINUTES), TimeValue.parseTimeValue("10 m", null, "test"));
 * Unless required by applicable law or agreed to in writing,
            TimeUnit.DAYS
        assertThat("1d", equalTo(new TimeValue(36, TimeUnit.HOURS).toHumanReadableString(-4)));
    public void testFailOnUnknownUnits() {
        final long duration = randomLongBetween(Long.MIN_VALUE, -2);
            value = randomDouble();
        assertEquals("1000d", new TimeValue(1000, TimeUnit.DAYS).getStringRep());
    }
        assertThat(TimeUnit.MILLISECONDS.toMillis(10), equalTo(new TimeValue(10, TimeUnit.MILLISECONDS).millis()));
    }
        assertEquals(new TimeValue(10, TimeUnit.SECONDS), TimeValue.parseTimeValue("10 S", null, "test"));
        assertThat("1.2d", equalTo(new TimeValue(103723200, TimeUnit.MILLISECONDS).toHumanReadableString(1)));
        expectThrows(IllegalArgumentException.class, () -> { TimeValue.parseTimeValue("10M", null, "test"); });
    public void testParseTimeValue() {
    }
    }
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        assertThat("1d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(3)));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("failed to parse"));
        TimeValue secondValue = new TimeValue(firstValue.getSeconds(), TimeUnit.SECONDS);
    }
import static org.hamcrest.CoreMatchers.not;
        assertEquals(new TimeValue(10, TimeUnit.HOURS), TimeValue.parseTimeValue("10h", null, "test"));
        assertThat(e.getCause(), instanceOf(NumberFormatException.class));
        long randomLong = randomNonNegativeLong();
    }
import static org.hamcrest.object.HasToString.hasToString;
            assertThat(e.getMessage(), containsString("failed to parse"));
    }
        assertThat("1d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(5)));
        assertThat(TimeValue.parseTimeValue(s, null, "test").getStringRep(), equalTo(s));
        assertTrue(secondValue.compareTo(firstValue) > 0);
            TimeUnit.HOURS,
        assertThat("1.4583333333d", equalTo(new TimeValue(35, TimeUnit.HOURS).toHumanReadableString(Integer.MAX_VALUE)));
        assertEquals(new TimeValue(10, TimeUnit.MILLISECONDS), TimeValue.parseTimeValue("10MS", null, "test"));
        IllegalArgumentException ex = expectThrows(
/*
        final TimeValue t = new TimeValue(randomIntBetween(1, 128), randomFrom(TimeUnit.values()));
 * not use this file except in compliance with the License.
        long number = randomNonNegativeLong();
                    + settingName
        } while (value == 0);
        // time unit is expected between the upper and lower case versions
        }
    }
        assertEquals(new TimeValue(10, TimeUnit.DAYS), TimeValue.parseTimeValue("10 d", null, "test"));
        assertEquals(firstRandom > secondRandom, firstValue.compareTo(secondValue) > 0);
public class TimeValueTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under
        assertThat("1.2d", equalTo(new TimeValue(103723200, TimeUnit.MILLISECONDS).toHumanReadableString(2)));
 * software distributed under the License is distributed on an
        assertEquals(new TimeValue(10, TimeUnit.DAYS), TimeValue.parseTimeValue("10d", null, "test"));
            TimeUnit.MICROSECONDS,
    }
 * the Apache License, Version 2.0 (the "License"); you may
            TimeUnit.MILLISECONDS,
        assertThat("1.5h", equalTo(new TimeValue(90, TimeUnit.MINUTES).toString()));
        assertThat(ex.getMessage(), containsString("duration cannot be negative"));
        assertEquals(new TimeValue(10, TimeUnit.SECONDS), TimeValue.parseTimeValue("10 s", null, "test"));
        try {
        assertThat(TimeUnit.MINUTES.toMinutes(10), equalTo(new TimeValue(10, TimeUnit.MINUTES).minutes()));
    }
    }
/*
        assertEquals(new TimeValue(10, TimeUnit.SECONDS), TimeValue.parseTimeValue("10s", null, "test"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
            TimeUnit.MINUTES,
        TimeValue firstValue = new TimeValue(firstRandom, unit);
        assertEquals(0, firstValue.compareTo(secondValue));
                    + "] with value ["
        assertEquals("90m", new TimeValue(90, TimeUnit.MINUTES).getStringRep());
        // supported. Note that this is the only unit that is not case sensitive
    public void testRejectsNegativeValuesDuringParsing() {
        assertEquals(new TimeValue(10, TimeUnit.HOURS), TimeValue.parseTimeValue("10H", null, "test"));
        assertThat("1.5s", equalTo(new TimeValue(1533, TimeUnit.MILLISECONDS).toString()));
    }
        } catch (IllegalArgumentException e) {
        assertEquals(new TimeValue(10, TimeUnit.MILLISECONDS), TimeValue.parseTimeValue("10 ms", null, "test"));
        final String s = Double.toString(randomIntBetween(0, 128) + value) + randomTimeUnit();
        assertEquals(new TimeValue(10, TimeUnit.SECONDS), TimeValue.parseTimeValue("10S", null, "test"));
import java.util.concurrent.TimeUnit;
        assertThat(TimeUnit.MICROSECONDS.toMicros(10), equalTo(new TimeValue(10, TimeUnit.MICROSECONDS).micros()));
        final String s = randomAlphaOfLength(10) + randomTimeUnit();
    public void testConversionHashCode() {
        TimeValue secondValue = new TimeValue(randomLong, randomUnit);
        assertThat("1.5d", equalTo(new TimeValue(36, TimeUnit.HOURS).toString()));
 * The OpenSearch Contributors require contributions made to
    public void testMinusOne() {
            TimeValue.parseTimeValue("23tw", null, "test");
                    + "] as a time value: negative durations are not supported"
        assertThat("1d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(6)));
        assertThat(new TimeValue(-1).nanos(), lessThan(0L));
        assertEquals(new TimeValue(10, TimeUnit.MILLISECONDS), TimeValue.parseTimeValue("10ms", null, "test"));
 * this work for additional information regarding copyright
        expectThrows(IllegalArgumentException.class, () -> { TimeValue.parseTimeValue("10 M", null, "test"); });
        assertEquals(new TimeValue(10, TimeUnit.MILLISECONDS), TimeValue.parseTimeValue("10 MS", null, "test"));
        assertThat("1d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(4)));
        final int length = randomIntBetween(0, 8);
 *
    public void testCompareEquality() {
        assertThat("1.4583333333d", equalTo(new TimeValue(35, TimeUnit.HOURS).toHumanReadableString(10)));
        // as `m` is the only character that is overloaded in terms of which
        final String zeros = new String(new char[length]).replace('\0', '0');
        TimeUnit randomUnit = randomFrom(TimeUnit.values());
}
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
    private static final String FRACTIONAL_TIME_VALUES_ARE_NOT_SUPPORTED = "fractional time values are not supported";
        return randomFrom(
        assertEquals("90s", new TimeValue(90, TimeUnit.SECONDS).getStringRep());
    }
        assertThat("1.5d", equalTo(new TimeValue(36, TimeUnit.HOURS).toHumanReadableString(2)));
        TimeValue firstValue = new TimeValue(randomLong, randomUnit);
        assertThat(e, not(hasToString(containsString(FRACTIONAL_TIME_VALUES_ARE_NOT_SUPPORTED))));
        TimeValue firstValue = new TimeValue(number, randomUnit);
    public void testNonFractionalTimeValues() {
        try {
        do {
        try {
        final String settingName = "test-value";
        assertEquals(firstValue.hashCode(), secondValue.hashCode());
import org.opensearch.test.OpenSearchTestCase;
        assertThat("1.0000008d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(7)));
        assertTrue(TimeValue.parseTimeValue("-" + zeros + "1", null, "test") == TimeValue.MINUS_ONE);
    }
            fail("Expected OpenSearchParseException");
    public void testFailOnMissingUnits() {
    public void testRoundTrip() {
        assertEquals(new TimeValue(10, TimeUnit.HOURS), TimeValue.parseTimeValue("10 H", null, "test"));
 * SPDX-License-Identifier: Apache-2.0
        }
            TimeValue.parseTimeValue("42", null, "test");
        assertThat("1d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(1)));
/*
package org.opensearch.common.unit;
            IllegalArgumentException.class,
 * under the License.
        assertEquals("1533ms", new TimeValue(1533, TimeUnit.MILLISECONDS).getStringRep());
import static org.hamcrest.CoreMatchers.instanceOf;
        );
            TimeValue.parseTimeValue("42ms.", null, "test");
        }
 * compatible open source license.
    public void testCompareValue() {
        assertThat(e.getCause(), instanceOf(NumberFormatException.class));
    private String randomTimeUnit() {
        double value;
            fail("Expected OpenSearchParseException");
import static org.hamcrest.Matchers.equalTo;
        assertEquals(new TimeValue(10, TimeUnit.DAYS), TimeValue.parseTimeValue("10D", null, "test"));
    private TimeUnit randomTimeUnitObject() {
 * GitHub history for details.
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> new TimeValue(duration, randomTimeUnitObject()));
    }
                "failed to parse setting ["
        assertThat("1d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(2)));
        assertThat(e, hasToString(containsString("failed to parse [" + s + "]")));
    public void testFractionalTimeValues() {
        assertEquals("-1", new TimeValue(-1).getStringRep());
        assertThat("1.5m", equalTo(new TimeValue(90, TimeUnit.SECONDS).toString()));
 * Modifications Copyright OpenSearch Contributors. See
            fail("Expected OpenSearchParseException");
        // Space is allowed before unit:
    }
import static org.hamcrest.Matchers.containsString;
        assertThat(e, hasToString(containsString(FRACTIONAL_TIME_VALUES_ARE_NOT_SUPPORTED)));
        TimeUnit randomUnit = randomValueOtherThan(TimeUnit.DAYS, () -> randomFrom(TimeUnit.values()));
            equalTo(
        assertThat("1d", equalTo(new TimeValue(86400077, TimeUnit.MILLISECONDS).toHumanReadableString(0)));
 * specific language governing permissions and limitations
        TimeValue secondValue = new TimeValue(secondRandom, unit);
 *
        final String negativeTimeValueString = Long.toString(negativeValue) + randomTimeUnit();
        assertThat("1.2d", equalTo(new TimeValue(103723200, TimeUnit.MILLISECONDS).toHumanReadableString(3)));
        assertThat(TimeUnit.SECONDS.toSeconds(10), equalTo(new TimeValue(10, TimeUnit.SECONDS).seconds()));
 */
        return randomFrom("nanos", "micros", "ms", "s", "m", "h", "d");
 *
 * Licensed to Elasticsearch under one or more contributor
        assertThat(TimeValue.parseTimeValue(t.getStringRep(), null, "test"), equalTo(t));
        assertTrue(TimeValue.parseTimeValue(zeros + "0", null, "test") == TimeValue.ZERO);
        assertEquals(new TimeValue(10, TimeUnit.DAYS), TimeValue.parseTimeValue("10 D", null, "test"));
        } catch (IllegalArgumentException e) {
        assertThat(e, hasToString(containsString("failed to parse [" + s + "]")));
import static org.hamcrest.Matchers.lessThan;
        assertThat(TimeUnit.HOURS.toHours(10), equalTo(new TimeValue(10, TimeUnit.HOURS).hours()));
        assertThat("1.2005d", equalTo(new TimeValue(103723200, TimeUnit.MILLISECONDS).toHumanReadableString(4)));
        );
