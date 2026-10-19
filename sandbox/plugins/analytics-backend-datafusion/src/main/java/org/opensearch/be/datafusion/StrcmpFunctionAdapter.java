 *     WHEN a < b THEN -1
 *   strcmp(a, b)
import org.apache.calcite.rex.RexNode;
 * }</pre>  
        RexNode zero = rexBuilder.makeExactLiteral(BigDecimal.ZERO, intType);  
 *
 * @opensearch.internal  
            return original;
        RexNode nullLit = rexBuilder.makeNullLiteral(intType);
 * kernels ({@code arrow::compute::lt}, {@code arrow::compute::eq}) which are
 * swaps them back — operands are consumed as {@code (arg1, arg0)} from the
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
 */
        RexNode anyNull = rexBuilder.makeCall(SqlStdOperatorTable.OR, aIsNull, bIsNull);  
        // CASE WHEN anyNull THEN NULL WHEN a<b THEN -1 WHEN a=b THEN 0 ELSE 1 END
        RelDataType intType = cluster.getTypeFactory()  
import org.apache.calcite.rel.type.RelDataType;
    @Override
        // NULL propagation must be explicit — SQL comparators on NULL return NULL, but
        RexNode a = operands.get(1);  
import java.math.BigDecimal;
import org.apache.calcite.rex.RexBuilder;  
 *   <li>{@code  0} when {@code a = b}</li>  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.SqlTypeName;
package org.opensearch.be.datafusion;
 * amortizes FFI over the batch but the inner compare is scalar.
 * this file be licensed under the Apache-2.0 license or a
 * {@code for i in 0..n { str::cmp(...) }} per row is strictly slower — it
 *   <li>{@code -1} when {@code a < b}</li>
import org.apache.calcite.rex.RexCall;
            .createTypeWithNullability(cluster.getTypeFactory().createSqlType(SqlTypeName.INTEGER), true);
    }
        RexNode neg1 = rexBuilder.makeExactLiteral(BigDecimal.valueOf(-1), intType);
 * <ul>
        }  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 *  
        // `ELSE 1` branch when either operand is NULL.  
        if (operands.size() != 2) {
        RexNode bIsNull = rexBuilder.makeCall(SqlStdOperatorTable.IS_NULL, b);
        RexNode equalTo = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, a, b);  
 */  
 *   <li>{@code NULL} when either operand is {@code NULL}</li>
 *   END
 * comparisons between {@code StringArray} operands lower to arrow-rs compute  
 *
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
 *   <li>{@code  1} when {@code a > b}</li>
 *   CASE  
 * user-intended {@code -1 / 0 / 1} convention.
        RexBuilder rexBuilder = cluster.getRexBuilder();
        // Swap to undo the PPL frontend's argument reversal.
import java.util.List;  
 *
        return rexBuilder.makeCall(intType, SqlStdOperatorTable.CASE, List.of(anyNull, nullLit, lessThan, neg1, equalTo, zero, one));  
        RexNode one = rexBuilder.makeExactLiteral(BigDecimal.ONE, intType);
        // the CASE below needs to short-circuit them so we don't fall through to the
 * SIMD-vectorized on x86_64 (AVX2) and arm64 (NEON). The CASE ({@code ifelse})
 * SPDX-License-Identifier: Apache-2.0
        List<RexNode> operands = original.getOperands();  
 * original call so the resulting {@code a < b} / {@code a = b} maps 1:1 to the  
/*  
 * Adapts PPL {@code strcmp(a, b)} into a pure Substrait/DataFusion CASE expression.  
}
/**
 * <p>PPL's frontend reverses {@code strcmp}'s args vs. user order. This adapter
        RexNode lessThan = rexBuilder.makeCall(SqlStdOperatorTable.LESS_THAN, a, b);
 *     ELSE              1
import org.apache.calcite.plan.RelOptCluster;
 *     WHEN a IS NULL OR b IS NULL THEN NULL
 * <p>Why the adapter beats a row-by-row Rust UDF: the {@code <} and {@code =}
 * is also an arrow vectorized kernel. A UDF that loops  
        RexNode b = operands.get(0);
 * <pre>{@code  
 *     WHEN a = b THEN  0  
class StrcmpFunctionAdapter implements ScalarFunctionAdapter {
        RexNode aIsNull = rexBuilder.makeCall(SqlStdOperatorTable.IS_NULL, a);
 *     →
 * compatible open source license.
import org.opensearch.analytics.spi.FieldStorageInfo;
 * </ul>  
 * <p>Rewrite:
 *
