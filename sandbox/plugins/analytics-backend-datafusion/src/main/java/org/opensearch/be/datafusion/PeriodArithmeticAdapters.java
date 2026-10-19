    }  
            RexNode years = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, m, intLit(rexBuilder, intType, 12));
 * @opensearch.internal
    private static RexNode pinReturnType(RexBuilder rexBuilder, RexNode expr, RexCall original) {
import java.util.List;  
        @Override
        @Override  
            RexNode yyyymm = rexBuilder.makeCall(
        return rexBuilder.makeCast(original.getType(), expr, true);  
            RexBuilder rexBuilder = cluster.getRexBuilder();  
 */  
        }
 * integers in {@code YYYYMM} form. Both reduce to pure integer arithmetic — no temporal primitives
     * PPL {@code PERIOD_ADD(P, n)} — add {@code n} months to period {@code P}, returning YYYYMM.
        if (expr.getType().equals(original.getType())) {  
}  
     * With {@code m = monthIndex(P) - 1 + n} (shift to 0-based month), the result is
                SqlStdOperatorTable.MINUS,
 *  
            // (m / 12) * 100 + (m % 12) + 1
        RexNode years = rexBuilder.makeCall(SqlStdOperatorTable.DIVIDE, period, intLit(rexBuilder, intType, 100));
            RexNode base = rexBuilder.makeCall(
     * {@code (m / 12) * 100 + (m % 12) + 1}.  
import org.apache.calcite.rex.RexNode;
                return original;  
            );
import org.apache.calcite.plan.RelOptCluster;
import java.math.BigDecimal;
package org.opensearch.be.datafusion;
                SqlStdOperatorTable.MINUS,
                monthIndex(rexBuilder, intType, period),  
            if (original.getOperands().size() != 2) {  
 * compatible open source license.
            return expr;
                rexBuilder.makeCall(SqlStdOperatorTable.PLUS, yearPart, monthPart),
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            RelDataType intType = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT);
    /** {@code (P / 100) * 12 + (P % 100)} — the absolute month index of a YYYYMM period. */  
    static final class PeriodDiffAdapter implements ScalarFunctionAdapter {  
    /**  
 *
            RelDataType intType = rexBuilder.getTypeFactory().createSqlType(SqlTypeName.BIGINT);  
 * — by converting a period to an absolute month index {@code monthIndex(P) = (P / 100) * 12 + (P % 100)}.
            return pinReturnType(rexBuilder, diff, original);  
 * emits these calls with full {@code YYYYMM} integers, and the absolute-month arithmetic below is
    private PeriodArithmeticAdapters() {}  
                return original;
            if (original.getOperands().size() != 2) {
        return rexBuilder.makeCall(SqlStdOperatorTable.PLUS, yearMonths, month);
    private static RexNode monthIndex(RexBuilder rexBuilder, RelDataType intType, RexNode period) {
            RexNode p1 = rexBuilder.makeCast(intType, original.getOperands().get(0), true);
        }
     */
 *
    }  
            return pinReturnType(rexBuilder, yyyymm, original);
 * SPDX-License-Identifier: Apache-2.0
        RexNode month = rexBuilder.makeCall(SqlStdOperatorTable.MOD, period, intLit(rexBuilder, intType, 100));
    private static RexNode intLit(RexBuilder rexBuilder, RelDataType intType, long value) {
            );  
            RexNode m = rexBuilder.makeCall(SqlStdOperatorTable.PLUS, base, months);  
            // m = monthIndex(P) - 1 + n (0-based absolute month)  
    static final class PeriodAddAdapter implements ScalarFunctionAdapter {
import org.apache.calcite.rex.RexCall;
                SqlStdOperatorTable.PLUS,  
     */
        return rexBuilder.makeExactLiteral(BigDecimal.valueOf(value), intType);  
            }
    }
 * The OpenSearch Contributors require contributions made to  
/*  
 */  
            RexNode p2 = rexBuilder.makeCast(intType, original.getOperands().get(1), true);  
            RexNode monthPart = rexBuilder.makeCall(SqlStdOperatorTable.MOD, m, intLit(rexBuilder, intType, 12));
                intLit(rexBuilder, intType, 1)
 * this file be licensed under the Apache-2.0 license or a
                monthIndex(rexBuilder, intType, p1),  
     * {@code monthIndex(P1) - monthIndex(P2)}.
import org.apache.calcite.sql.type.SqlTypeName;
    }
 * exact for that form.  
        RexNode yearMonths = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, years, intLit(rexBuilder, intType, 12));  
        }
            RexBuilder rexBuilder = cluster.getRexBuilder();
import org.apache.calcite.rel.type.RelDataType;
 * <p>The PPL frontend's 2-digit-year shorthand ({@code YYMM → 20YY}) is not reproduced here: PPL
            RexNode months = rexBuilder.makeCast(intType, original.getOperands().get(1), true);
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 * Lowerings for PPL {@code PERIOD_ADD} / {@code PERIOD_DIFF}, which operate on MySQL "period"  
                intLit(rexBuilder, intType, 1)
     * PPL {@code PERIOD_DIFF(P1, P2)} — months between two YYYYMM periods ({@code P1 - P2}):  
                monthIndex(rexBuilder, intType, p2)
    }
            RexNode period = rexBuilder.makeCast(intType, original.getOperands().get(0), true);
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
import org.opensearch.analytics.spi.FieldStorageInfo;
/**
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
            }
            RexNode yearPart = rexBuilder.makeCall(SqlStdOperatorTable.MULTIPLY, years, intLit(rexBuilder, intType, 100));  
            );
import org.apache.calcite.rex.RexBuilder;  
    /**
            RexNode diff = rexBuilder.makeCall(
final class PeriodArithmeticAdapters {
