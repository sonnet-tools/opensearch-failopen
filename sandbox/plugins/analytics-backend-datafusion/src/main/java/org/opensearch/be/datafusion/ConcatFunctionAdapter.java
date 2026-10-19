        RexNode nullLiteral = rexBuilder.makeNullLiteral(original.getType());
            anyNull = rexBuilder.makeCall(
 *     →
 * semantics on the analytics-engine path, this adapter rewrites
        if (operands.size() < 2) {
/**
 * is NULL. Substrait's default {@code concat} extension is documented with the same semantics,
                rexBuilder.makeCall(SqlStdOperatorTable.IS_NULL, operands.get(i))
 * <p>Calcite's {@code ||} operator follows the SQL standard: if any operand is NULL, the result  
 * <p>Single-operand calls fall through unchanged (the result equals the operand, so no
 * a custom DataFusion UDF.  
        for (int i = 1; i < operands.size(); i++) {  
        List<RexNode> operands = original.getOperands();  
 * }</pre>
                SqlStdOperatorTable.OR,
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 * The OpenSearch Contributors require contributions made to  
 * <pre>{@code  
import org.apache.calcite.rex.RexCall;  
 * but with the surrounding CASE/IS_NULL the DataFusion {@code concat()} call is short-circuited
import org.apache.calcite.plan.RelOptCluster;
/*  
            );
package org.opensearch.be.datafusion;
 *
}
                anyNull,  
import org.apache.calcite.rex.RexBuilder;
        // non-null literal reduces to constant-false, so the OR collapses cleanly through the  
    }
            return original;
        return rexBuilder.makeCall(original.getType(), SqlStdOperatorTable.CASE, List.of(anyNull, nullLiteral, original));  
 * null-propagating form for the DataFusion backend.
        // Fold operands into a single OR(IS_NULL(o0), IS_NULL(o1), ...) predicate. IS_NULL on a
 * null-handling rewrite is needed).  
    @Override
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * but DataFusion's substrait reader maps it to the DataFusion {@code concat()} function — which
        // Result type stays the same as the original CONCAT — nullable VARCHAR.
 * compatible open source license.
import org.apache.calcite.rex.RexNode;
 * deviates from the standard and treats NULL operands as empty strings. To preserve Calcite's  
 *   CASE WHEN a IS NULL OR b IS NULL THEN NULL ELSE ||(a, b) END  
 * The inner {@code ||} is left intact and serializes through the same Substrait conversion path,  
        // optimizer for cases where some operands are statically non-null.
 *
 *
        }  
 * Adapts {@code ||(a, b, ...)} (Calcite {@code SqlStdOperatorTable.CONCAT}) into a  
 *   ||(a, b)
import java.util.List;  
 */
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 * for any input that contains a NULL — restoring SQL-standard null-propagation without requiring
class ConcatFunctionAdapter implements ScalarFunctionAdapter {
        }  
import org.opensearch.analytics.spi.FieldStorageInfo;  
 */  
        RexBuilder rexBuilder = cluster.getRexBuilder();
 *
        RexNode anyNull = rexBuilder.makeCall(SqlStdOperatorTable.IS_NULL, operands.get(0));
