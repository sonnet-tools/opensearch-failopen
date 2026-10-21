        }
 * The seconds formatter is provided by {@link #SECONDS_FORMATTER}.
                && (temporal.isSupported(ChronoField.NANO_OF_SECOND) || temporal.isSupported(unitField));
        public long getFrom(TemporalAccessor temporal) {
            this.unitField = unitField;
        public boolean isSupportedBy(TemporalAccessor temporal) {
            Long sign = Optional.ofNullable(fieldValues.remove(SIGN)).orElse(POSITIVE);
    private static final DateTimeFormatter MILLISECONDS_FORMATTER2 = new DateTimeFormatterBuilder().append(MILLISECONDS_FORMATTER1)
 * You may obtain a copy of the License at
        private final TemporalUnit baseUnit;
                    nanos = 1_000_000_000 + nanos;
        private final ChronoField unitField;
import java.time.temporal.TemporalField;
                    // aggregate fractional part of the input
        .optionalEnd()
import java.time.temporal.ChronoUnit;
    private static final DateTimeFormatter SECONDS_FORMATTER1 = new DateTimeFormatterBuilder().appendValue(SECONDS, 1, 19, SignStyle.NORMAL)
            return "Epoch" + baseUnit.toString() + (rangeUnit != ChronoUnit.FOREVER ? "Of" + rangeUnit.toString() : "");
    private static final EpochField MILLIS_ABS = new AbsoluteEpochField(
                if (nanos != 0) {
    private static final DateTimeFormatter MICROSECONDS_FORMATTER2 = new DateTimeFormatterBuilder().append(MICROSECONDS_FORMATTER1)
            if (temporal.getLong(ChronoField.INSTANT_SECONDS) < 0) {
    private static class AbsoluteEpochField extends EpochField {
        .toFormatter(Locale.ROOT);
 * Licensed to Elasticsearch under one or more contributor
                    // aggregate fractional part of the input; subtract b/c `nanos < 0`
        (builder, parser) -> builder.parseDefaulting(EpochTime.NANOS_OF_MILLI, 999_999L),
            Long nanos = fieldValues.remove(NANOS_OF_SECOND);
    private static final ValueRange LONG_RANGE = ValueRange.of(Long.MIN_VALUE, Long.MAX_VALUE);
            ResolverStyle resolverStyle
        (builder, parser) -> builder.parseDefaulting(EpochTime.NANOS_OF_MICRO, 999L),
                    nanos += nanosOfUnit;
                fieldValues.put(ChronoField.MILLI_OF_SECOND, nanos / 1_000_000);
                        units += 1;
    private static final DateTimeFormatter MILLISECONDS_FORMATTER1 = new DateTimeFormatterBuilder().optionalStart()
        }
    );
        }
            return temporal.isSupported(ChronoField.INSTANT_SECONDS)
            TemporalUnit baseUnit,
        }
        .toFormatter(Locale.ROOT);
            return range;
    );
    private static final long POSITIVE = 1;
 *
package org.opensearch.common.time;
 */
            return (R) temporal.with(this, newValue);
            return temporal.isSupported(ChronoField.INSTANT_SECONDS);
        }
        .optionalEnd()
                        // Add 1 unit towards positive infinity because the fraction leads
    // this supports microseconds ending in dot
            return range();
    private static final DateTimeFormatter MICROSECONDS_FORMATTER1 = new DateTimeFormatterBuilder().optionalStart()
        public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
    // this supports milliseconds ending in dot
        }
            if (instantSecondsInUnits >= 0) {
        private final long nanosPerUnit;
     *
        }
 * SPDX-License-Identifier: Apache-2.0
        1_000L,
            long secondsAndUnits = fieldValues.remove(this);
            if (fieldValues.containsKey(ChronoField.MILLI_OF_SECOND)) {
    private abstract static class EpochField implements TemporalField {
                    long units = instantSecondsInUnits;
        NANOS_OF_MICRO
        .appendLiteral('.')
        public long getFrom(TemporalAccessor temporal) {
                    return -(instantSecondsInUnits + unitsOfSecond);
            this.range = range;
        @Override
            }
        MICROSECONDS_FORMATTER1,
        ChronoField.MICRO_OF_SECOND,
        }
                } else {
        @Override
     * @opensearch.internal
        }
                }
                secondsAndUnits = -secondsAndUnits;
import java.util.Map;
 * All formatters support fractional time, up to nanosecond precision.
    );
        ) {
            if (nanos != null) {
        ChronoUnit.MILLIS,
            }
        .appendText(SIGN, SIGN_FORMATTER_LOOKUP) // field is only created in the presence of a '-' char.
            return null;
    };
            long seconds = fieldValues.remove(this);
        }
import java.util.HashMap;
import java.time.format.SignStyle;
        }
    };
    }
 * The microseconds formatter is provided by {@link #MICROS_FORMATTER}.
        @Override
        @Override
                && temporal.getLong(ChronoField.NANO_OF_SECOND) % 1_000 != 0;
        @Override
    static final DateFormatter MILLIS_FORMATTER = new JavaDateFormatter(
                if (nanosOfUnit != null) {
    // this supports microseconds
        "epoch_micros",
            ResolverStyle resolverStyle
            if (instantSeconds < Long.MIN_VALUE / unitsPerSecond || instantSeconds > Long.MAX_VALUE / unitsPerSecond) {
        1_000L,
                seconds = secondsAndUnits / unitsPerSecond;
    private static final EpochField NANOS_OF_MILLI = new EpochField(ChronoUnit.NANOS, ChronoUnit.MILLIS, ValueRange.of(0, 999_999)) {
        public TemporalUnit getRangeUnit() {
        private final long unitsPerSecond;
            return true;
        private AbsoluteEpochField(
            return temporal.getLong(ChronoField.INSTANT_SECONDS) < 0 ? NEGATIVE : POSITIVE;
    // Millis as absolute values. Negative millis are encoded by having a NEGATIVE SIGN.
                nanos = secondsAndUnits % unitsPerSecond * nanosPerUnit;
        public long getFrom(TemporalAccessor temporal) {
        @Override
            }
        }
        MILLISECONDS_FORMATTER1,
class EpochTime {
 * Modifications Copyright OpenSearch Contributors. See
                    return instantSecondsInUnits + (temporal.getLong(ChronoField.NANO_OF_SECOND) / nanosPerUnit);
        "epoch_millis",
        public String toString() {
        @Override
            TemporalAccessor partialTemporal,
            put(POSITIVE, "");
 *
    private static final long NEGATIVE = 0;
            Map<TemporalField, Long> fieldValues,
            this.rangeUnit = rangeUnit;
        public boolean isSupportedBy(TemporalAccessor temporal) {
        public boolean isSupportedBy(TemporalAccessor temporal) {
        private EpochField(TemporalUnit baseUnit, TemporalUnit rangeUnit, ValueRange range) {
    );
    };
        @SuppressWarnings("unchecked")
                    nanos -= nanosOfUnit;
 *
        1_000_000L,
        .appendText(SIGN, SIGN_FORMATTER_LOOKUP) // field is only created in the presence of a '-' char.
        SECONDS_FORMATTER1,
                return temporal.getLong(ChronoField.NANO_OF_SECOND) % 1_000;
            } else {
        ChronoUnit.MICROS,
    private static final Map<Long, String> SIGN_FORMATTER_LOOKUP = new HashMap<Long, String>() {
        .optionalStart()
        .appendLiteral('.')
 */
        @Override
            }
            long instantSecondsInUnits = instantSeconds * unitsPerSecond;
                }
        public boolean isTimeBased() {
            return temporal.isSupported(ChronoField.INSTANT_SECONDS);
        }
        @Override
                    return instantSecondsInUnits + temporal.getLong(unitField);
            return temporal.getLong(ChronoField.INSTANT_SECONDS);
                return Long.MAX_VALUE;
import java.time.temporal.TemporalAccessor;
            fieldValues.put(ChronoField.INSTANT_SECONDS, seconds);
        private final TemporalUnit rangeUnit;
import java.time.temporal.ChronoField;
        public long getFrom(TemporalAccessor temporal) {
                if (nanosOfUnit != null) {
 * <p>
        public boolean isSupportedBy(TemporalAccessor temporal) {
import java.time.format.ResolverStyle;
        @Override
        }
        public <R extends Temporal> R adjustInto(R temporal, long newValue) {
    /**
    private static final DateTimeFormatter SECONDS_FORMATTER2 = new DateTimeFormatterBuilder().appendValue(SECONDS, 1, 19, SignStyle.NORMAL)
                }
        (builder, parser) -> builder.parseDefaulting(ChronoField.NANO_OF_SECOND, 999_999_999L),
            ChronoField unitField,
                    return -units;
            return rangeUnit;
        .toFormatter(Locale.ROOT);
                }
 * this work for additional information regarding copyright
        public String getDisplayName(Locale locale) {
                fieldValues.put(ChronoField.NANO_OF_SECOND, nanos);
            return false;
    private static final EpochField MICROS = new AbsoluteEpochField(
                    if (nanos % nanosPerUnit != 0) {
 * compatible open source license.
                nanos = secondsAndUnits % unitsPerSecond * nanosPerUnit;
        .appendFraction(NANOS_OF_MILLI, 0, 6, true)
        SECONDS_FORMATTER2
        }
        @Override
        private final ValueRange range;
        public boolean isSupportedBy(TemporalAccessor temporal) {
        @Override
        @Override
                seconds = secondsAndUnits / unitsPerSecond;
                    // nanos must be positive. B/c the timestamp is represented by the
                if (temporal.isSupported(ChronoField.NANO_OF_SECOND)) {
 * @opensearch.internal
        @Override
    private static final EpochField SIGN = new EpochField(ChronoUnit.FOREVER, ChronoUnit.FOREVER, ValueRange.of(NEGATIVE, POSITIVE)) {
        @Override
                && temporal.getLong(ChronoField.NANO_OF_SECOND) % 1_000_000 != 0;
        NANOS_OF_MILLI
 * The milliseconds formatter is provided by {@link #MILLIS_FORMATTER}.
                    long unitsOfSecond = temporal.getLong(unitField);
 * ownership. Elasticsearch licenses this file to you under
                fieldValues.put(ChronoField.MICRO_OF_SECOND, nanos / 1000);
        SECONDS_FORMATTER1,
        @Override
    // this supports seconds without any fraction
    }
                    // (seconds, nanos) tuple, seconds moves 1s toward negative-infinity
        "epoch_second",
    private static final EpochField SECONDS = new EpochField(ChronoUnit.SECONDS, ChronoUnit.FOREVER, LONG_RANGE) {
            return temporal.isSupported(ChronoField.INSTANT_SECONDS)
     * Base class for an epoch field
            if (sign == NEGATIVE) {
            fieldValues.put(ChronoField.INSTANT_SECONDS, seconds);
import java.util.Locale;
                }
                && temporal.isSupported(ChronoField.NANO_OF_SECOND)
/*
import java.util.Optional;
    // this supports milliseconds
        }
            Long nanosOfUnit = fieldValues.remove(nanosOfUnitField);
        .optionalEnd()
            }
        @Override
        .toFormatter(Locale.ROOT);
                    long nanos = temporal.getLong(ChronoField.NANO_OF_SECOND);
    };
 *     http://www.apache.org/licenses/LICENSE-2.0
                // Multiplying would yield integer overflow
        public long getFrom(TemporalAccessor temporal) {
        }
                    }
            Map<TemporalField, Long> fieldValues,
            long instantSeconds = temporal.getLong(ChronoField.INSTANT_SECONDS);
            if (fieldValues.containsKey(ChronoField.MICRO_OF_SECOND)) {
        }
            // if there is already a milli of second, we need to overwrite it
 * The OpenSearch Contributors require contributions made to
        }
import java.time.temporal.Temporal;
        .optionalStart()
/*
        public boolean isDateBased() {
/*
            return baseUnit;
            this.nanosPerUnit = nanosPerUnit;
            return temporal.getLong(ChronoField.NANO_OF_SECOND);
import java.time.temporal.ValueRange;
        }
            long unitsPerSecond,
            long nanos;
        {
        .toFormatter(Locale.ROOT);
 */
                // `secondsAndUnits < 0` implies negative timestamp; so `nanos < 0`
        }
 * This class provides {@link DateTimeFormatter}s capable of parsing epoch seconds, milliseconds, and microseconds.
            } else { // negative timestamp
        }
        .toFormatter(Locale.ROOT);
        MILLISECONDS_FORMATTER2
    };
        MICROSECONDS_FORMATTER1,
import java.time.format.DateTimeFormatter;
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
                        // the output's integral part to be an off-by-one when the
 * this file be licensed under the Apache-2.0 license or a
            return temporal.isSupported(ChronoField.NANO_OF_SECOND);
        }
        public TemporalAccessor resolve(
        1_000_000L,
 * not use this file except in compliance with the License.
    );
 * <p>
        MILLISECONDS_FORMATTER1,
            put(NEGATIVE, "-");
 * specific language governing permissions and limitations
        MICROSECONDS_FORMATTER2
        public long getFrom(TemporalAccessor temporal) {
 */
 * GitHub history for details.
            long seconds;
                        // Fractional negative timestamp.
    };
        @Override
                return (1_000_000_000 - temporal.getLong(ChronoField.NANO_OF_SECOND)) % 1_000_000;
        .appendValue(MILLIS_ABS, 1, 19, SignStyle.NOT_NEGATIVE)
 * license agreements. See the NOTICE file distributed with
}
/**
                    units += (nanos / nanosPerUnit);
        @Override
        }
            this.baseUnit = baseUnit;
        .appendFraction(NANOS_OF_SECOND, 0, 9, true)
        public boolean isSupportedBy(TemporalAccessor temporal) {
                && temporal.isSupported(ChronoField.NANO_OF_SECOND)
        .appendValue(MICROS, 1, 19, SignStyle.NOT_NEGATIVE)
        ) {
            fieldValues.put(ChronoField.NANO_OF_SECOND, nanos);
                return (1_000_000_000 - temporal.getLong(ChronoField.NANO_OF_SECOND)) % 1_000;
            return null;
                        // `(nanos / nanosPerUnit)` is added below.
        @Override
            this.nanosOfUnitField = nanosOfUnitField;
            if (temporal.getLong(ChronoField.INSTANT_SECONDS) < 0) {
            this.unitsPerSecond = unitsPerSecond;
    static final DateFormatter MICROS_FORMATTER = new JavaDateFormatter(
 *
        public TemporalAccessor resolve(
        ChronoField.MILLI_OF_SECOND,
            super(baseUnit, ChronoUnit.FOREVER, LONG_POSITIVE_RANGE);
    private static final EpochField NANOS_OF_SECOND = new EpochField(ChronoUnit.NANOS, ChronoUnit.SECONDS, ValueRange.of(0, 999_999_999)) {
    static final DateFormatter SECONDS_FORMATTER = new JavaDateFormatter(
 * KIND, either express or implied.  See the License for the
            long nanosPerUnit,
    private static final ValueRange LONG_POSITIVE_RANGE = ValueRange.of(0, Long.MAX_VALUE);
                    seconds -= 1;
     */
            EpochField nanosOfUnitField
 * Unless required by applicable law or agreed to in writing,
            }
            }
        @Override
            return temporal.isSupported(ChronoField.INSTANT_SECONDS)
        private final EpochField nanosOfUnitField;
                    // and nanos moves 1s toward positive-infinity
    private static final EpochField NANOS_OF_MICRO = new EpochField(ChronoUnit.NANOS, ChronoUnit.MICROS, ValueRange.of(0, 999)) {
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
        ) {
        .optionalEnd()
        .appendLiteral('.')
            TemporalAccessor partialTemporal,
        }
        @Override
            } else {
        public TemporalUnit getBaseUnit() {
                if (temporal.isSupported(ChronoField.NANO_OF_SECOND)) {
            } else {
                return temporal.getLong(ChronoField.NANO_OF_SECOND) % 1_000_000;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalUnit;
        public ValueRange range() {
        }
            }
            return toString();
        .appendFraction(NANOS_OF_MICRO, 0, 3, true)
        .optionalEnd()
    // this supports seconds ending in dot
        .optionalStart() // optional is used so isSupported will be called when printing
