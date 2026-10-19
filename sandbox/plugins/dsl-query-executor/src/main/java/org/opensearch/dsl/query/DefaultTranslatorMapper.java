                    return null;
        }  
    /** Singleton instance. */  
 *  
                        + field.getName()
 * <p>Stateless singleton; per-field state is read from the {@code RelDataType} on each call.
        RexNode literal = ctx.getRexBuilder().makeLiteral(value, field.getType(), true);  
            op = adjustedInclusive ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.GREATER_THAN;
                        + "' (legacy NumberFieldMapper supports only finite values)"
        // Decimal bounds on integer fields per NumberFieldMapper INTEGER.rangeQuery:
                field.getName()
            // WHY: unchecked (int) cast silently truncates via JLS 5.1.3 narrowing, e.g.
 * the integer decimal truncate-and-adjust branch, the whole-integer branch, and the  
/*  
        }
                        + value
        } else {  
                }
                isLower,
        // WHY: NaN/Infinity on integer fields silently become 0 or Long.MIN/MAX_VALUE via
                    if (truncated <= RangeBoundMath.getMinValueForType(fieldTypeName)) {  
 * this file be licensed under the Apache-2.0 license or a
        SqlOperator op;  
            );  
package org.opensearch.dsl.query;
                // Negative decimal upper bound -> decrement
     */  
    private RexNode createLiteral(Object value, RelDataTypeField field, ConversionContext ctx, SqlTypeName fieldTypeName) {
    }  
import org.apache.calcite.sql.type.SqlTypeName;
        if (isInteger && hasDecimal) {  
     * Translates a single range bound into a comparison RexNode.  
 */  
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {
    @Override
            return null;
     */  
        // truncate to int and adjust based on sign and bound direction.
                    adjusted = RangeBoundMath.narrowToFieldType(truncated - 1, fieldTypeName);  
import org.opensearch.dsl.query.range.RangeBoundMath;
                fieldTypeName,  
     * bound of 0 for NaN (a pre-existing legacy bug). We deliberately do NOT replicate that  
import org.opensearch.index.mapper.NumberFieldMapper;  
                    break;
     * @param field the field definition from the schema
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    private DefaultTranslatorMapper() {}  
 * VARCHAR/CHAR keyword ranges).
import org.opensearch.dsl.converter.ConversionException;
                throw new ConversionException(  
     * @param value the value to create a literal for
}
        return Optional.of(literal);
     * {@code NumberFieldMapper.NumberType.FLOAT.rangeQuery} semantics, and applies  
     *  
                case MATCH_NONE:
            }  
                throw new ConversionException(
        }  
     */  
    protected RexNode translateBound(Object value, boolean isLower, boolean inclusive, RelDataTypeField field, ConversionContext ctx)
                        return ctx.getRexBuilder().makeLiteral(false);  
        // On REAL/FLOAT fields, legacy NumberFieldMapper throws "supports only finite values".  
            if (fieldTypeName == SqlTypeName.REAL || fieldTypeName == SqlTypeName.FLOAT) {
        } else if (isInteger && !hasDecimal && value instanceof Number) {  
    static final DefaultTranslatorMapper INSTANCE = new DefaultTranslatorMapper();
/**
 * compatible open source license.
    }
     * Generic term-literal behaviour: creates a typed literal using the field's type.
        return ctx.getRexBuilder().makeLiteral(value, field.getType(), true);
                    }
            }
     * on out-of-range values. DOUBLE fields accept non-finite values unchanged per legacy.  
            op = adjustedInclusive ? SqlStdOperatorTable.LESS_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN;
        // DOUBLE deliberately accepts non-finite per legacy behaviour.
                    adjusted = RangeBoundMath.narrowToFieldType(truncated, fieldTypeName);
 */  
            long truncated = RangeBoundMath.toLongValue(value);
 * string unchanged), so a numeric gate would break keyword range queries.  
 *
            adjustedInclusive = true; // decimal adjustment makes bound inclusive
                    }
            // 2147483648L becomes -2147483648 and matches everything.  
            RangeBoundMath.CheckedNarrow narrowed = RangeBoundMath.narrowChecked(
 * keyword ranges are served only by the generic tail ({@code processValue} returns the
     * {@code NumberFieldMapper.NumberType.INTEGER.rangeQuery} IllegalArgumentException
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
        final boolean hasDecimal = isInteger && NumberFieldMapper.NumberType.hasDecimalPart(value);
     * <p>NOTE: Legacy byte/short/integer NumberFieldMapper.hasDecimalPart silently produces a
 * SPDX-License-Identifier: Apache-2.0
                } else {  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.SqlOperator;  
        SqlTypeName fieldTypeName = field.getType().getSqlTypeName();
     * bug; legacy DOES throw for long via Numbers.toLongExact. For FLOAT/HALF_FLOAT, legacy
import org.opensearch.dsl.converter.ConversionContext;  
     * overflow guards for integer-typed fields matching legacy
     * {@code NumberFieldMapper.NumberType.INTEGER.rangeQuery} and
                    adjusted = RangeBoundMath.narrowToFieldType(truncated + 1, fieldTypeName);
     *
     * Rejects non-finite values (NaN, Infinity) on integer and float fields per legacy
        // Double.longValue() (IEEE-754 "round toward zero" is undefined for non-finite).
        if (RangeBoundMath.isNonFinite(value)) {
                );  
                if (NumberFieldMapper.NumberType.signum(value) < 0) {
                    "Non-finite value ("
        final boolean isInteger = RangeBoundMath.isIntegerType(fieldTypeName);
 * permissive generic tail that builds comparisons for any remaining type (including
                ((Number) value).longValue(),
            switch (narrowed.result()) {
import org.apache.calcite.rex.RexNode;
                case NO_CONSTRAINT:
     * NumberFieldMapper throws "supports only finite values".
        return ctx.getRexBuilder().makeCall(op, fieldRef, literal);
import java.util.Optional;
            } else {  
            if (RangeBoundMath.isIntegerType(fieldTypeName)) {  
        }
        throws ConversionException {  
            // DOUBLE: fall through — legacy accepts non-finite doubles
                // Positive decimal lower bound -> increment  
                } else {
 * <p>This mapper is NOT gated on {@code RangeBoundMath.isNumericType} because VARCHAR/CHAR
                    adjusted = RangeBoundMath.narrowToFieldType(truncated, fieldTypeName);
    @Override
                }  
            if (isLower) {
     * Creates a literal RexNode with appropriate type based on the field type and value.
     * @param ctx the conversion context  
    /**
                );  
        Object adjusted = value;
        RexNode literal = createLiteral(adjusted, field, ctx, fieldTypeName);  
     * @param fieldTypeName the SqlTypeName of the field
    /**
        if (isLower) {
 * Catch-all translator mapper carrying today's entire non-UDT bound-translation path:
                    return ctx.getRexBuilder().makeLiteral(false);  
final class DefaultTranslatorMapper extends BaseTranslatorMapper {
                        return ctx.getRexBuilder().makeLiteral(false);
    /**
                        + ") is not supported for float field '"  
                if (NumberFieldMapper.NumberType.signum(value) > 0) {
            }
    }
            // Whole numeric value on integer field: range-checked narrow to field-appropriate type.
                    "Non-finite value (" + value + ") is not supported for integer field '" + field.getName() + "'"
        boolean adjustedInclusive = inclusive;  
                    if (truncated >= RangeBoundMath.getMaxValueForType(fieldTypeName)) {
            }
     * @return RexNode literal with appropriate type and precision
                    adjusted = narrowed.value();
        if (value == null) {
 *
                case OK:  
import org.apache.calcite.rel.type.RelDataTypeField;
