 * {@code opensearch_arithmetic_overloads.yaml} so isthmus emits the call under the standard
 * SPDX-License-Identifier: Apache-2.0
            );
 * compatible open source license.
 */  
    }  
                rexBuilder.makeCall(original.getType(), SqlStdOperatorTable.MOD, List.of(lhs, rhs)),
            return original;
        RexNode zero = rexBuilder.makeExactLiteral(BigDecimal.ZERO, divisor.getType());
            case SMALLINT -> 2;
        RexNode coercedExpr = expr.getType().equals(nullableExprType) ? expr : rexBuilder.makeCast(nullableExprType, expr);
        int lhsRank = numericRank(lhsType);
        RelDataType targetType = factory.createTypeWithNullability(factory.createSqlType(target), operand.getType().isNullable());
                typeFactory
 * <p>For all operands the result is wrapped in {@code CASE WHEN y = 0 THEN NULL ELSE … END}
            case BIGINT -> 4;
import org.opensearch.analytics.spi.FieldStorageInfo;  
                rexBuilder,  
import org.apache.calcite.rel.type.RelDataType;
            case INTEGER -> 3;  
import org.apache.calcite.plan.RelOptCluster;
 * <p>Widens mixed-type operands (e.g. {@code MOD(fp32?, i32)} from  
        SqlTypeName rhsType = rhs.getType().getSqlTypeName();  
 * — PPL semantics return NULL on divide-by-zero, but isthmus's Calcite→Substrait emission  
        RexNode modExpr = rexBuilder.makeCall(original.getType(), SqlStdOperatorTable.MOD, List.of(newLhs, newRhs));
/**  
import org.apache.calcite.rex.RexNode;  
 * {@code float_number % 2}) to a common numeric type, then emits the standard
        RexNode lhs = original.getOperands().get(0);  
import org.apache.calcite.rex.RexBuilder;
import java.util.List;
 * {@link SqlStdOperatorTable#MOD}. Substrait's stock {@code modulus} extension declares
        SqlTypeName common = lhsRank >= rhsRank ? lhsType : rhsType;
    }
        return rexBuilder.makeCast(targetType, operand);
        RexNode newRhs = rhsType == common ? rhs : cast(rhs, common, typeFactory, rexBuilder);
    @Override
 * can't thread substrait's {@code on_domain_error: NULL} option through.
class ModAdapter implements ScalarFunctionAdapter {
        if (original.getOperands().size() != 2) {  
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();
        }  
            default -> -1;
        return wrapWithNullOnZero(modExpr, newRhs, rexBuilder, typeFactory);  
        };
 * Adapter for PPL {@code MOD}.
            case FLOAT, REAL -> 5;
    }
        if (lhsRank < 0 || rhsRank < 0) {
    private static int numericRank(SqlTypeName type) {
        int rhsRank = numericRank(rhsType);  
 *
 * The OpenSearch Contributors require contributions made to  
        RelDataType nullableExprType = typeFactory.createTypeWithNullability(expr.getType(), true);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
                rhs,
        RexNode isZero = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, List.of(divisor, zero));  
            case TINYINT -> 1;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        return switch (type) {  
        SqlTypeName lhsType = lhs.getType().getSqlTypeName();
 * this file be licensed under the Apache-2.0 license or a
        RexNode rhs = original.getOperands().get(1);
import java.math.BigDecimal;  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
/*  
 * integer-only signatures; the fp signatures are supplied by  
import org.apache.calcite.rex.RexCall;
}
        RexNode newLhs = lhsType == common ? lhs : cast(lhs, common, typeFactory, rexBuilder);  
        }
 * @opensearch.internal  
            return wrapWithNullOnZero(  
 * {@code %} operator (precision-correct IEEE 754 remainder).  
 *
 */
 * substrait name and DataFusion's substrait consumer routes it to its native fp
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    private static RexNode cast(RexNode operand, SqlTypeName target, RelDataTypeFactory factory, RexBuilder rexBuilder) {  
        return rexBuilder.makeCall(nullableExprType, SqlStdOperatorTable.CASE, List.of(isZero, nullLit, coercedExpr));  
    private static RexNode wrapWithNullOnZero(RexNode expr, RexNode divisor, RexBuilder rexBuilder, RelDataTypeFactory typeFactory) {  
package org.opensearch.be.datafusion;
 *
 *
        RexBuilder rexBuilder = cluster.getRexBuilder();  
    }  
import org.apache.calcite.sql.type.SqlTypeName;
        RexNode nullLit = rexBuilder.makeNullLiteral(nullableExprType);
            case DOUBLE -> 6;  
