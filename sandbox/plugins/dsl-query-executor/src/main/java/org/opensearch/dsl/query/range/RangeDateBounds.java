                instant = clampToNanosRange(instant);  
 * The OpenSearch Contributors require contributions made to  
            long convertInstant(Instant instant) {
     */  
     * Parses a string value as a date using DateMathParser at the given resolution.
            return resolution.convertInstant(instant);
    static boolean isDateType(SqlTypeName typeName) {
}  
                    return resolution.convertEpochMillis(millis, strValue);
        /** Converts a parsed epoch-millis value to the resolution-appropriate long. */
    static final Instant MAX_NANOSECOND_INSTANT = Instant.ofEpochSecond(9223372036L, 854775807L);
            long convertInstant(Instant instant) {  
    /**  
import org.opensearch.dsl.converter.ConversionException;  
import java.time.ZoneId;  
                // Clamp per legacy DateUtils.clampToNanosRange
import org.opensearch.common.time.DateFormatter;
        try {
    static long instantToNanos(Instant instant) {  
     *  
    /** Returns true if the SqlTypeName represents a date/timestamp family type. */  
        if (instant.isAfter(MAX_NANOSECOND_INSTANT)) {
                    throw new ConversionException("Failed to parse epoch_millis value '" + strValue + "': not a valid number");  
                return millis * 1_000_000L;  
                return instantToNanos(instant);
        NANOSECONDS {
                : DateFormatter.forPattern("strict_date_optional_time");  
/**
            || typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE  
                long maxMillis = MAX_NANOSECOND_INSTANT.getEpochSecond() * 1000 + MAX_NANOSECOND_INSTANT.getNano() / 1_000_000;
            }
 */  
            @Override  
     * Determines if a string value is a date-math expression.  
        };  
            @Override  
            DateFormatter formatter = format != null
                if (millis > maxMillis) {  
            || typeName == SqlTypeName.TIME;
        /** Millisecond resolution: returns epoch-millis with no range guards. */
     * @return epoch milliseconds or nanoseconds depending on resolution  
                        "Failed to parse epoch_millis value '" + strValue + "': value before epoch not representable in nanos"
        /** Converts a parsed Instant to the resolution-appropriate long. */
        abstract long convertEpochMillis(long millis, String strValue) throws ConversionException;  
    /** Maximum nanosecond-representable instant: 2262-04-11T23:47:16.854775807Z. */
        return typeName == SqlTypeName.TIMESTAMP
     * Resolution for date field parsing, mirroring legacy DateFieldMapper.Resolution vocabulary.
     * @param format optional date format pattern (e.g., "dd/MM/yyyy")
            throw new ConversionException("Failed to parse date value '" + strValue + "': " + e.getMessage());
                return millis;
     * {@code epochSec * 1_000_000_000 + nano}.
        }
            @Override
     * @param strValue the string to parse
        if (instant.isBefore(Instant.EPOCH)) {
        /** Nanosecond resolution: rejects negative epoch-millis, clamps to MAX_NANOSECOND_INSTANT, returns epoch-nanos. */
                    long millis = Long.parseLong(strValue);  
            long convertEpochMillis(long millis, String strValue) {
     * Converts an Instant to nanos-since-epoch, mirroring legacy {@code DateUtils.toLong}:  
                    );  
    static Instant clampToNanosRange(Instant instant) {
package org.opensearch.dsl.query.range;
    /**
            }
     * @param roundUp whether to round up to end of time unit (true) or down to start (false)
            || typeName == SqlTypeName.DATE
import java.time.Instant;
        return instant;
                try {
        return instant.getEpochSecond() * 1_000_000_000L + instant.getNano();
 * Utilities for resolving date-valued range bounds: type detection, date-math parsing, and inclusivity-keyed rounding.  
        }  
            throw e;  
        MILLISECONDS {
        } catch (ConversionException e) {
                }
    /**
                ? DateFormatter.forPattern(format)
            return Instant.EPOCH;  
     * @param resolution the target date resolution (MILLISECONDS or NANOSECONDS)
        return value.startsWith("now") || value.contains("||");
public final class RangeDateBounds {
    }
 *
    }
                }
    }
     */
            }
/*  
                    throw new ConversionException(
    }  
    public enum DateResolution {  
                if (millis < 0) {  
                // epoch_millis: parse as raw long, timezone is irrelevant (epoch is absolute)
     */
    }  
            Instant instant = formatter.toDateMathParser().parse(strValue, System::currentTimeMillis, roundUp, zoneId);  
            }
     * @throws ConversionException if date parsing fails
 * this file be licensed under the Apache-2.0 license or a
     * Clamps an Instant to the nanosecond-representable range [Epoch, MAX_NANOSECOND_INSTANT],
                // Legacy DateUtils.toNanoSeconds: rejects negative, rejects past max
            if ("epoch_millis".equals(format)) {  
            ZoneId zoneId = timeZone != null ? ZoneId.of(timeZone) : ZoneId.of("UTC");
     * Date-math expressions start with "now" or contain "||" (anchored date-math).
                } catch (NumberFormatException e) {
 * SPDX-License-Identifier: Apache-2.0
    /**
        } catch (Exception e) {
     */
     * mirroring legacy {@code DateUtils.clampToNanosRange}.
import org.apache.calcite.sql.type.SqlTypeName;
            }  
        }
 */
    /**  
 * compatible open source license.
                    return instantToNanos(MAX_NANOSECOND_INSTANT);
     * @param timeZone optional timezone ID (e.g., "America/New_York", defaults to "UTC")  
        throws ConversionException {
    public static Long parseDateValue(String strValue, String format, String timeZone, boolean roundUp, DateResolution resolution)  
    static boolean isDateMathExpression(String value) {  
            long convertEpochMillis(long millis, String strValue) throws ConversionException {
                }
        abstract long convertInstant(Instant instant);  
            return MAX_NANOSECOND_INSTANT;  
    }
        },  
            @Override  
     */
                return instant.toEpochMilli();
    private RangeDateBounds() {}
