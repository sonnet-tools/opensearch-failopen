            ? divideExpr  
import org.apache.calcite.rex.RexCall;
import java.util.List;
import java.math.BigDecimal;  
 * thread function options through. DataFusion's runtime therefore raises  
    }  
import org.apache.calcite.plan.RelOptCluster;
        // Skip the CASE wrap when the divisor is a known non-zero literal. ReduceExpressionsRule
        // queries on the same substrait shape they had before this adapter existed.
        return rexBuilder.makeCall(nullableExprType, SqlStdOperatorTable.CASE, List.of(isZero, nullLit, coercedExpr));
 * @opensearch.internal
 */  
 * this file be licensed under the Apache-2.0 license or a
 * CASE away when the divisor is a non-zero literal.
import org.apache.calcite.rex.RexNode;
 * {@code on_division_by_zero: NULL} option, but isthmus's Calcite→Substrait emission can't
    private static boolean isNonZeroLiteral(RexNode node) {
        if (original.getOperands().size() != 2) {
import org.apache.calcite.rex.RexLiteral;  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
            ? original
        RexNode zero = rexBuilder.makeExactLiteral(BigDecimal.ZERO, rhs.getType());
        // runs before adapters and can't fold the CASE introduced here, so emitting one for every  
 * The OpenSearch Contributors require contributions made to  
}  
package org.opensearch.be.datafusion;
        }
        if (!(node instanceof RexLiteral lit) || lit.isNull()) {  
 * so the null is materialized at adapter time. Calcite's reduce-expressions pass simplifies the
 *
        }
        RexNode nullLit = rexBuilder.makeNullLiteral(nullableExprType);
 */
        RexBuilder rexBuilder = cluster.getRexBuilder();
/*  
 * compatible open source license.
        RexNode coercedExpr = divideExpr.getType().equals(nullableExprType)
        }  
        RelDataType nullableExprType = typeFactory.createTypeWithNullability(divideExpr.getType(), true);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        if (isNonZeroLiteral(rhs)) {  
 * {@code Arrow error: Divide by zero error} when the divisor is zero, while PPL expects NULL.
        RelDataTypeFactory typeFactory = cluster.getTypeFactory();
    }
 * <p>Wrap each {@code DIVIDE(x, y)} in {@code CASE WHEN y = 0 THEN NULL ELSE DIVIDE(x, y) END}  
import org.apache.calcite.rel.type.RelDataType;
import org.opensearch.analytics.spi.FieldStorageInfo;  
            : rexBuilder.makeCall(original.getType(), SqlStdOperatorTable.DIVIDE, List.of(lhs, rhs));  
        RexNode divideExpr = original.getOperator() == SqlStdOperatorTable.DIVIDE
            return divideExpr;
class DivideAdapter implements ScalarFunctionAdapter {  
        // `x / literal` would add a runtime branch per row. The short-circuit also keeps these
import org.apache.calcite.rex.RexBuilder;
        RexNode rhs = original.getOperands().get(1);
        RexNode isZero = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, List.of(rhs, zero));  
 *  
            return original;
        RexNode lhs = original.getOperands().get(0);
 * SPDX-License-Identifier: Apache-2.0
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
        return value != null && value.signum() != 0;
        BigDecimal value = lit.getValueAs(BigDecimal.class);  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * Adapter for PPL {@code DIVIDE}. Substrait's {@code divide} declares an
            : rexBuilder.makeCast(nullableExprType, divideExpr);
    @Override
 *
/**  
            return false;
