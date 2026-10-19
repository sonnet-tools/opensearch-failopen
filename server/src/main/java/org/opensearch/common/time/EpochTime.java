        ChronoUnit.MILLIS,
    private static final DateTimeFormatter MILLISECONDS_FORMATTER1 = new DateTimeFormatterBuilder().optionalStart()  
 * <p>
        "epoch_micros",
    private static final EpochField NANOS_OF_MICRO = new EpochField(ChronoUnit.NANOS, ChronoUnit.MICROS, ValueRange.of(0, 999)) {
        .appendFraction(NANOS_OF_MILLI, 0, 6, true)
        1_000_000L,  
            this.unitsPerSecond = unitsPerSecond;
                    nanos = 1_000_000_000 + nanos;
    // this supports seconds ending in dot
        private final long unitsPerSecond;  
        private final ChronoField unitField;
import java.time.temporal.ChronoUnit;  
        (builder, parser) -> builder.parseDefaulting(EpochTime.NANOS_OF_MICRO, 999L),  
        .appendLiteral('.')
            return baseUnit;
                }
        SECONDS_FORMATTER1,  
            ResolverStyle resolverStyle  
                    units += (nanos / nanosPerUnit);
        }
        }
        .toFormatter(Locale.ROOT);
            if (nanos != null) {
        @Override  
            this.range = range;
            return temporal.getLong(ChronoField.NANO_OF_SECOND);
import java.time.format.ResolverStyle;  
    );
                seconds = secondsAndUnits / unitsPerSecond;
    private static final EpochField MILLIS_ABS = new AbsoluteEpochField(  
        public boolean isDateBased() {  
    };  
                }
 * Licensed to Elasticsearch under one or more contributor  
        ) {
                    nanos += nanosOfUnit;
        .optionalEnd()
                if (nanos != 0) {  
            TemporalAccessor partialTemporal,
        @Override
        @SuppressWarnings("unchecked")
        @Override  
        }
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
        private final ValueRange range;
                && temporal.getLong(ChronoField.NANO_OF_SECOND) % 1_000 != 0;
                    long units = instantSecondsInUnits;
            return temporal.isSupported(ChronoField.INSTANT_SECONDS);
        (builder, parser) -> builder.parseDefaulting(EpochTime.NANOS_OF_MILLI, 999_999L),
                return (1_000_000_000 - temporal.getLong(ChronoField.NANO_OF_SECOND)) % 1_000_000;
        }
 * this work for additional information regarding copyright
        @Override
                    // and nanos moves 1s toward positive-infinity  
    private static final DateTimeFormatter SECONDS_FORMATTER1 = new DateTimeFormatterBuilder().appendValue(SECONDS, 1, 19, SignStyle.NORMAL)
            if (temporal.getLong(ChronoField.INSTANT_SECONDS) < 0) {  
    // this supports milliseconds ending in dot  
    };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        .appendValue(MILLIS_ABS, 1, 19, SignStyle.NOT_NEGATIVE)  
            ChronoField unitField,  
        .optionalEnd()
            fieldValues.put(ChronoField.INSTANT_SECONDS, seconds);  
        public long getFrom(TemporalAccessor temporal) {  
        public boolean isTimeBased() {
    private static final long NEGATIVE = 0;  
 * specific language governing permissions and limitations
    };
                fieldValues.put(ChronoField.MICRO_OF_SECOND, nanos / 1000);
    // Millis as absolute values. Negative millis are encoded by having a NEGATIVE SIGN.
            return temporal.isSupported(ChronoField.INSTANT_SECONDS)
    private static final DateTimeFormatter MICROSECONDS_FORMATTER2 = new DateTimeFormatterBuilder().append(MICROSECONDS_FORMATTER1)
    );
                    // aggregate fractional part of the input  
            long secondsAndUnits = fieldValues.remove(this);
                    nanos -= nanosOfUnit;
    // this supports milliseconds
        .toFormatter(Locale.ROOT);  
     * Base class for an epoch field  
            }
    private static final ValueRange LONG_POSITIVE_RANGE = ValueRange.of(0, Long.MAX_VALUE);  
                    return -(instantSecondsInUnits + unitsOfSecond);  
                // Multiplying would yield integer overflow
        private final TemporalUnit baseUnit;  
            Long nanosOfUnit = fieldValues.remove(nanosOfUnitField);
                    return instantSecondsInUnits + temporal.getLong(unitField);
        SECONDS_FORMATTER2
        public TemporalUnit getRangeUnit() {
    // this supports seconds without any fraction
        public boolean isSupportedBy(TemporalAccessor temporal) {
    private static final EpochField NANOS_OF_MILLI = new EpochField(ChronoUnit.NANOS, ChronoUnit.MILLIS, ValueRange.of(0, 999_999)) {
        MICROSECONDS_FORMATTER1,
            TemporalAccessor partialTemporal,
        }
            } else {
        .optionalStart()
     * @opensearch.internal
                    return instantSecondsInUnits + (temporal.getLong(ChronoField.NANO_OF_SECOND) / nanosPerUnit);
        @Override
                        // `(nanos / nanosPerUnit)` is added below.
    static final DateFormatter MICROS_FORMATTER = new JavaDateFormatter(  
        .optionalStart()
                    }
                    long unitsOfSecond = temporal.getLong(unitField);
import java.time.format.SignStyle;
        }  
            this.nanosOfUnitField = nanosOfUnitField;
        private final EpochField nanosOfUnitField;  
        }  
            }  
        }
    private static final DateTimeFormatter MICROSECONDS_FORMATTER1 = new DateTimeFormatterBuilder().optionalStart()  
        public long getFrom(TemporalAccessor temporal) {
            if (temporal.getLong(ChronoField.INSTANT_SECONDS) < 0) {  
        public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
        }
                } else {
 * <p>
                nanos = secondsAndUnits % unitsPerSecond * nanosPerUnit;  
/*
            TemporalUnit baseUnit,  
                if (temporal.isSupported(ChronoField.NANO_OF_SECOND)) {
import java.time.temporal.ChronoField;
                        // Add 1 unit towards positive infinity because the fraction leads  
                && temporal.getLong(ChronoField.NANO_OF_SECOND) % 1_000_000 != 0;
            return false;
                // `secondsAndUnits < 0` implies negative timestamp; so `nanos < 0`
            long nanosPerUnit,
        MILLISECONDS_FORMATTER2  
/**
        private final TemporalUnit rangeUnit;
            if (sign == NEGATIVE) {  
        .appendFraction(NANOS_OF_MICRO, 0, 3, true)
        }  
            return rangeUnit;  
        @Override
package org.opensearch.common.time;
 *
            long nanos;
            // if there is already a milli of second, we need to overwrite it  
        ChronoUnit.MICROS,  
                nanos = secondsAndUnits % unitsPerSecond * nanosPerUnit;  
        }
 * license agreements. See the NOTICE file distributed with
}
            if (fieldValues.containsKey(ChronoField.MICRO_OF_SECOND)) {
    };  
class EpochTime {
    );
        }
        }
        public long getFrom(TemporalAccessor temporal) {
 * under the License.  
import java.time.format.DateTimeFormatterBuilder;
        @Override  
import java.util.HashMap;  
                    // (seconds, nanos) tuple, seconds moves 1s toward negative-infinity
        }  
            return null;
 * The microseconds formatter is provided by {@link #MICROS_FORMATTER}.
                return temporal.getLong(ChronoField.NANO_OF_SECOND) % 1_000_000;  
        public boolean isSupportedBy(TemporalAccessor temporal) {
                }
import java.time.temporal.Temporal;
                && temporal.isSupported(ChronoField.NANO_OF_SECOND)  
                return (1_000_000_000 - temporal.getLong(ChronoField.NANO_OF_SECOND)) % 1_000;
                && (temporal.isSupported(ChronoField.NANO_OF_SECOND) || temporal.isSupported(unitField));
 *     http://www.apache.org/licenses/LICENSE-2.0
        MILLISECONDS_FORMATTER1,
        public boolean isSupportedBy(TemporalAccessor temporal) {
        }
 */  
                    long nanos = temporal.getLong(ChronoField.NANO_OF_SECOND);  
            return toString();  
            long unitsPerSecond,
 * the Apache License, Version 2.0 (the "License"); you may
        public boolean isSupportedBy(TemporalAccessor temporal) {
        NANOS_OF_MICRO
        .appendLiteral('.')
 * The seconds formatter is provided by {@link #SECONDS_FORMATTER}.
    }
        ) {
        "epoch_second",  
            Map<TemporalField, Long> fieldValues,
        }  
 * You may obtain a copy of the License at  
        private AbsoluteEpochField(
        public TemporalAccessor resolve(  
            long instantSecondsInUnits = instantSeconds * unitsPerSecond;
            return true;  
        NANOS_OF_MILLI
        .appendText(SIGN, SIGN_FORMATTER_LOOKUP) // field is only created in the presence of a '-' char.
            return range;
            } else {
        .appendValue(MICROS, 1, 19, SignStyle.NOT_NEGATIVE)  
            return range();
            }  
        }
        public boolean isSupportedBy(TemporalAccessor temporal) {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
        }
import java.time.temporal.TemporalAccessor;
        MICROSECONDS_FORMATTER2
    private static final DateTimeFormatter SECONDS_FORMATTER2 = new DateTimeFormatterBuilder().appendValue(SECONDS, 1, 19, SignStyle.NORMAL)  
            return temporal.getLong(ChronoField.INSTANT_SECONDS);
    /**
/*  
        @Override  
        .optionalEnd()  
import java.util.Locale;
            fieldValues.put(ChronoField.INSTANT_SECONDS, seconds);
            EpochField nanosOfUnitField
        public TemporalAccessor resolve(  
        }
        .toFormatter(Locale.ROOT);  
    }  
                if (nanosOfUnit != null) {
        }
                    if (nanos % nanosPerUnit != 0) {
            Long sign = Optional.ofNullable(fieldValues.remove(SIGN)).orElse(POSITIVE);
 *  
        @Override  
        @Override
        ChronoField.MICRO_OF_SECOND,  
    private static final ValueRange LONG_RANGE = ValueRange.of(Long.MIN_VALUE, Long.MAX_VALUE);
        ChronoField.MILLI_OF_SECOND,
        public long getFrom(TemporalAccessor temporal) {
                if (nanosOfUnit != null) {
 * software distributed under the License is distributed on an
    };  
        @Override  
/*  
        private final long nanosPerUnit;
 *
 * The OpenSearch Contributors require contributions made to  
    // this supports microseconds
                }
            } else { // negative timestamp  
                return Long.MAX_VALUE;  
        .toFormatter(Locale.ROOT);
        @Override
        MILLISECONDS_FORMATTER1,  
        ) {
 */  
            super(baseUnit, ChronoUnit.FOREVER, LONG_POSITIVE_RANGE);  
        @Override  
    private static final EpochField SECONDS = new EpochField(ChronoUnit.SECONDS, ChronoUnit.FOREVER, LONG_RANGE) {  
                return temporal.getLong(ChronoField.NANO_OF_SECOND) % 1_000;  
        .appendText(SIGN, SIGN_FORMATTER_LOOKUP) // field is only created in the presence of a '-' char.
                && temporal.isSupported(ChronoField.NANO_OF_SECOND)  
 * KIND, either express or implied.  See the License for the
        private EpochField(TemporalUnit baseUnit, TemporalUnit rangeUnit, ValueRange range) {
 */  
        SECONDS_FORMATTER1,
            }  
        public boolean isSupportedBy(TemporalAccessor temporal) {
            this.baseUnit = baseUnit;
    private static final EpochField SIGN = new EpochField(ChronoUnit.FOREVER, ChronoUnit.FOREVER, ValueRange.of(NEGATIVE, POSITIVE)) {
    private static final DateTimeFormatter MILLISECONDS_FORMATTER2 = new DateTimeFormatterBuilder().append(MILLISECONDS_FORMATTER1)
        (builder, parser) -> builder.parseDefaulting(ChronoField.NANO_OF_SECOND, 999_999_999L),
                        // the output's integral part to be an off-by-one when the
        @Override
import java.time.temporal.ValueRange;
    private static final long POSITIVE = 1;
 * ownership. Elasticsearch licenses this file to you under  
 * All formatters support fractional time, up to nanosecond precision.  
 *
        @Override  
            if (instantSeconds < Long.MIN_VALUE / unitsPerSecond || instantSeconds > Long.MAX_VALUE / unitsPerSecond) {
import java.util.Optional;  
 * not use this file except in compliance with the License.
        public long getFrom(TemporalAccessor temporal) {
     */  
            put(NEGATIVE, "-");
    private static class AbsoluteEpochField extends EpochField {
            this.unitField = unitField;  
        public ValueRange range() {
            if (fieldValues.containsKey(ChronoField.MILLI_OF_SECOND)) {
        "epoch_millis",
                        units += 1;  
 * GitHub history for details.
    static final DateFormatter MILLIS_FORMATTER = new JavaDateFormatter(
            this.nanosPerUnit = nanosPerUnit;
        {
            return null;
                        // Fractional negative timestamp.
        1_000L,
 */
        @Override
        }  
                if (temporal.isSupported(ChronoField.NANO_OF_SECOND)) {
import java.time.format.DateTimeFormatter;
            return (R) temporal.with(this, newValue);
     *
            return "Epoch" + baseUnit.toString() + (rangeUnit != ChronoUnit.FOREVER ? "Of" + rangeUnit.toString() : "");
    // this supports microseconds ending in dot  
        .optionalStart() // optional is used so isSupported will be called when printing  
            }
            return temporal.isSupported(ChronoField.INSTANT_SECONDS)
        .toFormatter(Locale.ROOT);  
                    seconds -= 1;
        public TemporalUnit getBaseUnit() {  
            long instantSeconds = temporal.getLong(ChronoField.INSTANT_SECONDS);  
        public <R extends Temporal> R adjustInto(R temporal, long newValue) {
            return temporal.isSupported(ChronoField.NANO_OF_SECOND);  
            long seconds = fieldValues.remove(this);
                secondsAndUnits = -secondsAndUnits;
import java.time.temporal.TemporalUnit;
            ResolverStyle resolverStyle  
                fieldValues.put(ChronoField.NANO_OF_SECOND, nanos);  
        @Override
        .toFormatter(Locale.ROOT);
            }
        public String toString() {
            put(POSITIVE, "");  
        1_000L,
            if (instantSecondsInUnits >= 0) {  
        @Override
        .appendFraction(NANOS_OF_SECOND, 0, 9, true)
    private abstract static class EpochField implements TemporalField {
                }  
                } else {  
        @Override
    );  
import java.time.temporal.TemporalField;  
        }  
                    return -units;  
            Map<TemporalField, Long> fieldValues,
                    // aggregate fractional part of the input; subtract b/c `nanos < 0`  
    );  
 * The milliseconds formatter is provided by {@link #MILLIS_FORMATTER}.  
            long seconds;
        .optionalEnd()  
            } else {
    };  
            return temporal.isSupported(ChronoField.INSTANT_SECONDS)  
    static final DateFormatter SECONDS_FORMATTER = new JavaDateFormatter(
        @Override  
        1_000_000L,
            fieldValues.put(ChronoField.NANO_OF_SECOND, nanos);
        @Override
        .appendLiteral('.')
    private static final Map<Long, String> SIGN_FORMATTER_LOOKUP = new HashMap<Long, String>() {
            }
                seconds = secondsAndUnits / unitsPerSecond;
        }  
    private static final EpochField MICROS = new AbsoluteEpochField(
            Long nanos = fieldValues.remove(NANOS_OF_SECOND);
                fieldValues.put(ChronoField.MILLI_OF_SECOND, nanos / 1_000_000);
        @Override
 * Unless required by applicable law or agreed to in writing,
            this.rangeUnit = rangeUnit;  
        }
        public String getDisplayName(Locale locale) {
    private static final EpochField NANOS_OF_SECOND = new EpochField(ChronoUnit.NANOS, ChronoUnit.SECONDS, ValueRange.of(0, 999_999_999)) {  
 * This class provides {@link DateTimeFormatter}s capable of parsing epoch seconds, milliseconds, and microseconds.  
        }
 * compatible open source license.
        @Override
        public long getFrom(TemporalAccessor temporal) {
            }
        .optionalEnd()
        MICROSECONDS_FORMATTER1,
 * this file be licensed under the Apache-2.0 license or a
            return temporal.getLong(ChronoField.INSTANT_SECONDS) < 0 ? NEGATIVE : POSITIVE;
                    // nanos must be positive. B/c the timestamp is represented by the
        }  
            return temporal.isSupported(ChronoField.INSTANT_SECONDS);  
