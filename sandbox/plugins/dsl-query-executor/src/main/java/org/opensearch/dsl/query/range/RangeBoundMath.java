     */
        static CheckedNarrow ok(Number value) {
                || s.equalsIgnoreCase("+Infinity");
            case SMALLINT:
        return typeName == SqlTypeName.INTEGER
            return CheckedNarrow.ok(value);
                throw new ConversionException("Value " + value + " is out of range for " + typeName + " field '" + fieldName + "'");
        OK,
            return Double.isNaN(d) || Double.isInfinite(d);
     * whether arriving as a raw Number (Double/Float) or as a coerced String like "NaN" or "Infinity".
    /**
            case BIGINT:
     * Result of a range-checked narrowing: either a narrowed Number, a match-none sentinel,
     * @param fieldName field name for error messages
        }
            // Matches Double.parseDouble conventions: "NaN", "Infinity", "-Infinity", "+Infinity"
    public static CheckedNarrow narrowChecked(long value, SqlTypeName typeName, boolean isLower, String fieldName)
            if (typeName == SqlTypeName.INTEGER || typeName == SqlTypeName.BIGINT) {
     * <p>WHY: unchecked {@code (int) longValue} silently truncates via Java narrowing primitive
    }
     */
        /** The bound is impossible (lower above max or upper below min); emit FALSE literal. */
            return new CheckedNarrow(NarrowResult.NO_CONSTRAINT, null);
 * this file be licensed under the Apache-2.0 license or a
        return false;
            || typeName == SqlTypeName.BIGINT
     * {@link #narrowChecked(long, SqlTypeName, boolean, String)} instead to avoid silent
                return Long.MAX_VALUE;
        // Value is in range; narrow safely
        return CheckedNarrow.ok((int) value);
 */
        return typeName == SqlTypeName.INTEGER
        if (value > max) {
                || s.equalsIgnoreCase("Infinity")
     * @return CheckedNarrow with disposition and narrowed value if OK
        }
            || typeName == SqlTypeName.SMALLINT
                return Long.MIN_VALUE;
    /**
        }
     */
     * WHY: Double.longValue() on NaN silently returns 0, producing a wrong bound of 0 on integer
     * @param isLower true if this is a lower bound, false if upper
    public static long getMinValueForType(SqlTypeName typeName) {
    }
                return Byte.MIN_VALUE;
 * Numeric type-narrowing and overflow-guard helpers shared by the range bound translation path.
    public enum NarrowResult {
        }
        switch (typeName) {
        NO_CONSTRAINT
            case SMALLINT:
        }
     *
            return isLower ? CheckedNarrow.matchNone() : CheckedNarrow.noConstraint();
        /** The bound is vacuous (lower below min or upper above max); return null (no constraint). */
            case INTEGER:
     * before entering the truncation path.
            if (typeName == SqlTypeName.INTEGER || typeName == SqlTypeName.BIGINT) {
            || typeName == SqlTypeName.TINYINT
        return (int) value;
            return Float.isNaN(f) || Float.isInfinite(f);
    public static boolean isIntegerType(SqlTypeName typeName) {
    }
        long min = getMinValueForType(typeName);
     * Used as the base truncation before narrowing to the specific integer type.
        if (value instanceof Number) {
            // TINYINT/SMALLINT: lower above max -> match-none; upper above max -> no constraint
import org.opensearch.dsl.converter.ConversionException;
    static boolean isNumericType(SqlTypeName typeName) {
    /** Returns true if the SqlTypeName represents an integer-family type (not float/double/decimal). */
                throw new ConversionException("Value " + value + " is out of range for " + typeName + " field '" + fieldName + "'");
        }
    }
        switch (typeName) {
     * Used for overflow guard checks before decrementing truncated values.
                return Long.MIN_VALUE;
public final class RangeBoundMath {
            || typeName == SqlTypeName.REAL
 *
     */
    }
    public record CheckedNarrow(NarrowResult result, Number value) {
                return Integer.MIN_VALUE;
    /**
    /**
}
            || typeName == SqlTypeName.BIGINT
     * Returns the maximum value for the given integer-family SqlTypeName.
        long max = getMaxValueForType(typeName);
            }
    /**
                return Short.MAX_VALUE;
     * @param value the long value to narrow
                || s.equalsIgnoreCase("-Infinity")
        }
     */
    /**
        static CheckedNarrow noConstraint() {
            default:
        if (value instanceof Float f) {
                return Byte.MAX_VALUE;
    public static long toLongValue(Object value) {
     * Truncates a numeric value to long (floor toward zero), supporting all integer family widths.
        if (value instanceof String s) {
            || typeName == SqlTypeName.TINYINT;
        }
     * fields; Infinity similarly truncates to Long.MIN_VALUE/MAX_VALUE. Callers must reject these
    }
        if (value instanceof Double d) {
        }
            return isLower ? CheckedNarrow.noConstraint() : CheckedNarrow.matchNone();
            return s.equalsIgnoreCase("NaN")
     * Narrows a long value to Integer (for TINYINT, SMALLINT, INTEGER) or Long (for BIGINT)
     * Returns true if the value represents a non-finite IEEE-754 value (NaN, +Infinity, -Infinity),
        }
            default:
     * Range-checked narrowing for whole-number bounds on integer-family fields.
                return Short.MIN_VALUE;
     * Returns the minimum value for the given integer-family SqlTypeName.
            }
     * Used for overflow guard checks before incrementing truncated values.
                return Integer.MAX_VALUE;
    /**
            case INTEGER:
            return ((Number) value).longValue();
/**
    public static boolean isNonFinite(Object value) {
 * compatible open source license.
        MATCH_NONE,
/*
        }
        }
    public static Number narrowToFieldType(long value, SqlTypeName typeName) {
     * conversion (JLS 5.1.3), turning e.g. 2147483648L into -2147483648 and matching everything.
        throws ConversionException {
     * Holds the result of a checked narrowing: the disposition and (if OK) the narrowed value.
            return value;
            || typeName == SqlTypeName.SMALLINT
        if (typeName == SqlTypeName.BIGINT) {
     * WITHOUT range checking. Callers on the whole-number path must use
            case TINYINT:
                return Long.MAX_VALUE;
import org.apache.calcite.sql.type.SqlTypeName;
    /**
            case TINYINT:
 * The OpenSearch Contributors require contributions made to
        if (typeName == SqlTypeName.BIGINT) {
     *
 */
        if (value < min) {
    }
    private RangeBoundMath() {}
            case BIGINT:
     * @throws ConversionException if INTEGER/BIGINT and value is out of range
     * For TINYINT and SMALLINT, out-of-range values produce match-none or no-constraint instead
    }
     * Retained only for the decimal-adjust branch where overflow is already guarded.
    public static long getMaxValueForType(SqlTypeName typeName) {
 * SPDX-License-Identifier: Apache-2.0
     * or a no-constraint sentinel (meaning the bound is vacuously satisfied).
            || typeName == SqlTypeName.FLOAT
            || typeName == SqlTypeName.DECIMAL;
            return new CheckedNarrow(NarrowResult.MATCH_NONE, null);
    }
     * truncation via Java narrowing primitive conversion (JLS 5.1.3).
package org.opensearch.dsl.query.range;
        /** The value was narrowed successfully; use {@code narrowedValue}. */
     * of throwing, because legacy produces a real query that returns zero hits rather than 400.
     */
    }
     */
    /** Returns true if the SqlTypeName represents a numeric type. */
     * For INTEGER and BIGINT, values outside the type range throw ConversionException (matching
            return new CheckedNarrow(NarrowResult.OK, value);
            || typeName == SqlTypeName.DOUBLE
            // TINYINT/SMALLINT: upper below min -> match-none; lower below min -> no constraint
     * @param typeName the target SqlTypeName (TINYINT, SMALLINT, INTEGER, BIGINT)
     * legacy NumberFieldMapper IllegalArgumentException "out of range for an integer/long").
        return 0;
     */
        static CheckedNarrow matchNone() {
        }
