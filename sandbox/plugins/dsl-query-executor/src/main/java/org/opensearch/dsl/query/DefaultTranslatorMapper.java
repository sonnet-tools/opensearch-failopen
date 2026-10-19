        SqlOperator op;
        }
                    "Non-finite value ("
                fieldTypeName,
        if (isInteger && hasDecimal) {
                // Positive decimal lower bound -> increment
            }
            // DOUBLE: fall through — legacy accepts non-finite doubles
    public Optional<RexNode> toTermLiteral(Object value, RelDataTypeField field, ConversionContext ctx) throws ConversionException {
     */
     * @param value the value to create a literal for
    private RexNode createLiteral(Object value, RelDataTypeField field, ConversionContext ctx, SqlTypeName fieldTypeName) {
    /**
        // Decimal bounds on integer fields per NumberFieldMapper INTEGER.rangeQuery:
                        + field.getName()
                if (NumberFieldMapper.NumberType.signum(value) < 0) {
package org.opensearch.dsl.query;
        } else {
                    adjusted = RangeBoundMath.narrowToFieldType(truncated - 1, fieldTypeName);
            switch (narrowed.result()) {
import org.apache.calcite.rex.RexNode;
     * Rejects non-finite values (NaN, Infinity) on integer and float fields per legacy
    @Override
            // 2147483648L becomes -2147483648 and matches everything.
     * on out-of-range values. DOUBLE fields accept non-finite values unchanged per legacy.
                } else {
     * {@code NumberFieldMapper.NumberType.FLOAT.rangeQuery} semantics, and applies
 * string unchanged), so a numeric gate would break keyword range queries.
            // WHY: unchecked (int) cast silently truncates via JLS 5.1.3 narrowing, e.g.
                case NO_CONSTRAINT:
     *
            op = adjustedInclusive ? SqlStdOperatorTable.LESS_THAN_OR_EQUAL : SqlStdOperatorTable.LESS_THAN;
 * SPDX-License-Identifier: Apache-2.0
                    adjusted = RangeBoundMath.narrowToFieldType(truncated, fieldTypeName);
        RexNode fieldRef = ctx.getRexBuilder().makeInputRef(field.getType(), field.getIndex());
import org.apache.calcite.sql.type.SqlTypeName;
 * this file be licensed under the Apache-2.0 license or a
                ((Number) value).longValue(),
 *
        if (isLower) {
        final boolean hasDecimal = isInteger && NumberFieldMapper.NumberType.hasDecimalPart(value);
     * {@code NumberFieldMapper.NumberType.INTEGER.rangeQuery} IllegalArgumentException
                );
 * keyword ranges are served only by the generic tail ({@code processValue} returns the
import org.opensearch.index.mapper.NumberFieldMapper;
                        return ctx.getRexBuilder().makeLiteral(false);
                // Negative decimal upper bound -> decrement
                    return ctx.getRexBuilder().makeLiteral(false);
                    break;
     * @param ctx the conversion context
                    if (truncated <= RangeBoundMath.getMinValueForType(fieldTypeName)) {
 * the integer decimal truncate-and-adjust branch, the whole-integer branch, and the
                        + "' (legacy NumberFieldMapper supports only finite values)"
        // truncate to int and adjust based on sign and bound direction.
            }
        return ctx.getRexBuilder().makeLiteral(value, field.getType(), true);
            RangeBoundMath.CheckedNarrow narrowed = RangeBoundMath.narrowChecked(
        }
     * @param fieldTypeName the SqlTypeName of the field
 *
        return ctx.getRexBuilder().makeCall(op, fieldRef, literal);
        // Double.longValue() (IEEE-754 "round toward zero" is undefined for non-finite).
     * @return RexNode literal with appropriate type and precision
/*
            op = adjustedInclusive ? SqlStdOperatorTable.GREATER_THAN_OR_EQUAL : SqlStdOperatorTable.GREATER_THAN;
                field.getName()
                }
            adjustedInclusive = true; // decimal adjustment makes bound inclusive
    }
 * <p>Stateless singleton; per-field state is read from the {@code RelDataType} on each call.
                    }
     * bound of 0 for NaN (a pre-existing legacy bug). We deliberately do NOT replicate that
        if (RangeBoundMath.isNonFinite(value)) {
                case MATCH_NONE:
                case OK:
                } else {
     * NumberFieldMapper throws "supports only finite values".
        // WHY: NaN/Infinity on integer fields silently become 0 or Long.MIN/MAX_VALUE via
 * compatible open source license.
            long truncated = RangeBoundMath.toLongValue(value);
import org.apache.calcite.rel.type.RelDataTypeField;
     * overflow guards for integer-typed fields matching legacy
 * Catch-all translator mapper carrying today's entire non-UDT bound-translation path:
                );
    }
                    return null;
 * The OpenSearch Contributors require contributions made to
                    adjusted = RangeBoundMath.narrowToFieldType(truncated, fieldTypeName);
                    adjusted = narrowed.value();
        RexNode literal = createLiteral(adjusted, field, ctx, fieldTypeName);
}
import org.apache.calcite.sql.SqlOperator;
            }
        return Optional.of(literal);
 *
                }
    private DefaultTranslatorMapper() {}
        // On REAL/FLOAT fields, legacy NumberFieldMapper throws "supports only finite values".
        }
     * Translates a single range bound into a comparison RexNode.
            return null;
                    adjusted = RangeBoundMath.narrowToFieldType(truncated + 1, fieldTypeName);
                throw new ConversionException(
        boolean adjustedInclusive = inclusive;
 * <p>This mapper is NOT gated on {@code RangeBoundMath.isNumericType} because VARCHAR/CHAR
        Object adjusted = value;
        SqlTypeName fieldTypeName = field.getType().getSqlTypeName();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        // DOUBLE deliberately accepts non-finite per legacy behaviour.
 * VARCHAR/CHAR keyword ranges).
                        + ") is not supported for float field '"
final class DefaultTranslatorMapper extends BaseTranslatorMapper {
            } else {
            }
     * bug; legacy DOES throw for long via Numbers.toLongExact. For FLOAT/HALF_FLOAT, legacy
        } else if (isInteger && !hasDecimal && value instanceof Number) {
                    }
    /**
            if (isLower) {
        RexNode literal = ctx.getRexBuilder().makeLiteral(value, field.getType(), true);
        final boolean isInteger = RangeBoundMath.isIntegerType(fieldTypeName);
     * <p>NOTE: Legacy byte/short/integer NumberFieldMapper.hasDecimalPart silently produces a
    /**
    /** Singleton instance. */
import org.opensearch.dsl.converter.ConversionException;
     */
/**
        }
            );
     * Creates a literal RexNode with appropriate type based on the field type and value.
        if (value == null) {
import org.opensearch.dsl.query.range.RangeBoundMath;
                    "Non-finite value (" + value + ") is not supported for integer field '" + field.getName() + "'"
     * @param field the field definition from the schema
    protected RexNode translateBound(Object value, boolean isLower, boolean inclusive, RelDataTypeField field, ConversionContext ctx)
     */
 */
     *
        throws ConversionException {
     * Generic term-literal behaviour: creates a typed literal using the field's type.
                isLower,
            if (RangeBoundMath.isIntegerType(fieldTypeName)) {
                throw new ConversionException(
                if (NumberFieldMapper.NumberType.signum(value) > 0) {
    @Override
    }
 */
import org.opensearch.dsl.converter.ConversionContext;
import java.util.Optional;
                        return ctx.getRexBuilder().makeLiteral(false);
 * permissive generic tail that builds comparisons for any remaining type (including
    static final DefaultTranslatorMapper INSTANCE = new DefaultTranslatorMapper();
                    if (truncated >= RangeBoundMath.getMaxValueForType(fieldTypeName)) {
            if (fieldTypeName == SqlTypeName.REAL || fieldTypeName == SqlTypeName.FLOAT) {
     * {@code NumberFieldMapper.NumberType.INTEGER.rangeQuery} and
            // Whole numeric value on integer field: range-checked narrow to field-appropriate type.
                        + value
