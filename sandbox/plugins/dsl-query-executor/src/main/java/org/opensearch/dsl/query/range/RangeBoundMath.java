                return Short.MIN_VALUE;  
    private RangeBoundMath() {}
 */
     *
 * SPDX-License-Identifier: Apache-2.0
        return false;  
                return Long.MIN_VALUE;
    /** Returns true if the SqlTypeName represents an integer-family type (not float/double/decimal). */  
        }  
     * Truncates a numeric value to long (floor toward zero), supporting all integer family widths.  
        if (value instanceof Float f) {
                return Integer.MAX_VALUE;  
/*  
            return CheckedNarrow.ok(value);
     * legacy NumberFieldMapper IllegalArgumentException "out of range for an integer/long").
     * Result of a range-checked narrowing: either a narrowed Number, a match-none sentinel,
        return CheckedNarrow.ok((int) value);  
     * <p>WHY: unchecked {@code (int) longValue} silently truncates via Java narrowing primitive
        /** The bound is vacuous (lower below min or upper above max); return null (no constraint). */  
     * fields; Infinity similarly truncates to Long.MIN_VALUE/MAX_VALUE. Callers must reject these
    public static Number narrowToFieldType(long value, SqlTypeName typeName) {
     *
        return typeName == SqlTypeName.INTEGER
    /**  
        }
    }
        NO_CONSTRAINT
        return typeName == SqlTypeName.INTEGER
        }
        }
            case TINYINT:
     */
            || typeName == SqlTypeName.TINYINT
    }
        MATCH_NONE,
            // Matches Double.parseDouble conventions: "NaN", "Infinity", "-Infinity", "+Infinity"  
            case BIGINT:  
     * Returns the minimum value for the given integer-family SqlTypeName.
    }
        static CheckedNarrow matchNone() {
        }
                return Long.MAX_VALUE;
import org.opensearch.dsl.converter.ConversionException;  
        }
     */  
     * For TINYINT and SMALLINT, out-of-range values produce match-none or no-constraint instead
    /**
    /**  
                return Integer.MIN_VALUE;
     * before entering the truncation path.
            case INTEGER:
    public static boolean isIntegerType(SqlTypeName typeName) {
            return isLower ? CheckedNarrow.matchNone() : CheckedNarrow.noConstraint();
     * Returns the maximum value for the given integer-family SqlTypeName.
                return Byte.MAX_VALUE;
     * conversion (JLS 5.1.3), turning e.g. 2147483648L into -2147483648 and matching everything.  
            || typeName == SqlTypeName.BIGINT  
     * @param typeName the target SqlTypeName (TINYINT, SMALLINT, INTEGER, BIGINT)  
            default:  
                || s.equalsIgnoreCase("-Infinity")  
            || typeName == SqlTypeName.DECIMAL;
            return Float.isNaN(f) || Float.isInfinite(f);  
    public record CheckedNarrow(NarrowResult result, Number value) {
     * of throwing, because legacy produces a real query that returns zero hits rather than 400.  
     * Returns true if the value represents a non-finite IEEE-754 value (NaN, +Infinity, -Infinity),
    }  
        throws ConversionException {
            if (typeName == SqlTypeName.INTEGER || typeName == SqlTypeName.BIGINT) {  
     * WITHOUT range checking. Callers on the whole-number path must use  
public final class RangeBoundMath {
 */  
                || s.equalsIgnoreCase("+Infinity");
                throw new ConversionException("Value " + value + " is out of range for " + typeName + " field '" + fieldName + "'");
     * or a no-constraint sentinel (meaning the bound is vacuously satisfied).
        }
/**
            return new CheckedNarrow(NarrowResult.NO_CONSTRAINT, null);  
    /**
    /**
    static boolean isNumericType(SqlTypeName typeName) {  
        if (value instanceof Double d) {
     * @throws ConversionException if INTEGER/BIGINT and value is out of range
            || typeName == SqlTypeName.TINYINT;
    }  
            || typeName == SqlTypeName.FLOAT  
            return new CheckedNarrow(NarrowResult.MATCH_NONE, null);
 * Numeric type-narrowing and overflow-guard helpers shared by the range bound translation path.  
    /**
     * whether arriving as a raw Number (Double/Float) or as a coerced String like "NaN" or "Infinity".
    }
 * The OpenSearch Contributors require contributions made to  
                return Byte.MIN_VALUE;
        if (value > max) {
                return Long.MAX_VALUE;  
     * Used for overflow guard checks before decrementing truncated values.  
     * Narrows a long value to Integer (for TINYINT, SMALLINT, INTEGER) or Long (for BIGINT)
     * For INTEGER and BIGINT, values outside the type range throw ConversionException (matching  
        }  
    /**  
     */  
        /** The bound is impossible (lower above max or upper below min); emit FALSE literal. */
            if (typeName == SqlTypeName.INTEGER || typeName == SqlTypeName.BIGINT) {
     * @return CheckedNarrow with disposition and narrowed value if OK  
            case INTEGER:  
    /**
            case SMALLINT:
     * @param fieldName field name for error messages
            case SMALLINT:
 * compatible open source license.
     */  
     * Holds the result of a checked narrowing: the disposition and (if OK) the narrowed value.
     * Used as the base truncation before narrowing to the specific integer type.
        }
            return Double.isNaN(d) || Double.isInfinite(d);  
            return ((Number) value).longValue();
     */
}
     * WHY: Double.longValue() on NaN silently returns 0, producing a wrong bound of 0 on integer  
    public static long getMaxValueForType(SqlTypeName typeName) {
            return value;
 * this file be licensed under the Apache-2.0 license or a
        return 0;
                throw new ConversionException("Value " + value + " is out of range for " + typeName + " field '" + fieldName + "'");
        if (value < min) {  
        }
        if (typeName == SqlTypeName.BIGINT) {  
    }
            || typeName == SqlTypeName.REAL
        /** The value was narrowed successfully; use {@code narrowedValue}. */
        if (typeName == SqlTypeName.BIGINT) {  
        long min = getMinValueForType(typeName);
            case BIGINT:
    public static boolean isNonFinite(Object value) {
            || typeName == SqlTypeName.BIGINT
        }  
    public enum NarrowResult {
 *
     * Used for overflow guard checks before incrementing truncated values.
    public static CheckedNarrow narrowChecked(long value, SqlTypeName typeName, boolean isLower, String fieldName)  
     */
            }  
     * Range-checked narrowing for whole-number bounds on integer-family fields.
        }
        if (value instanceof Number) {
        switch (typeName) {
import org.apache.calcite.sql.type.SqlTypeName;
            // TINYINT/SMALLINT: upper below min -> match-none; lower below min -> no constraint
    public static long toLongValue(Object value) {  
    /** Returns true if the SqlTypeName represents a numeric type. */
            || typeName == SqlTypeName.SMALLINT
        // Value is in range; narrow safely
            return s.equalsIgnoreCase("NaN")
            || typeName == SqlTypeName.SMALLINT  
                return Long.MIN_VALUE;
     * {@link #narrowChecked(long, SqlTypeName, boolean, String)} instead to avoid silent
     * @param value the long value to narrow
        OK,  
            case TINYINT:  
        static CheckedNarrow noConstraint() {
            return new CheckedNarrow(NarrowResult.OK, value);
            }
                return Short.MAX_VALUE;
            default:
            || typeName == SqlTypeName.DOUBLE
package org.opensearch.dsl.query.range;
    public static long getMinValueForType(SqlTypeName typeName) {
    }
        static CheckedNarrow ok(Number value) {  
        if (value instanceof String s) {
        }
     */  
    }  
     */
     * Retained only for the decimal-adjust branch where overflow is already guarded.  
     * @param isLower true if this is a lower bound, false if upper
        switch (typeName) {  
                || s.equalsIgnoreCase("Infinity")
     * truncation via Java narrowing primitive conversion (JLS 5.1.3).
            // TINYINT/SMALLINT: lower above max -> match-none; upper above max -> no constraint  
    }
            return isLower ? CheckedNarrow.noConstraint() : CheckedNarrow.matchNone();
        return (int) value;  
        long max = getMaxValueForType(typeName);  
