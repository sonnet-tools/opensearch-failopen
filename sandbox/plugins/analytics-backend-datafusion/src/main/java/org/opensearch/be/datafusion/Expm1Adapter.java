        // BackendPlanAdapter has already visited this subtree, so the inner EXP we produce
 * direct {@code expm1} scalar function; lowering the UDF before Substrait
 * is preserved.
import org.apache.calcite.rex.RexBuilder;
        // Widen the operand to DOUBLE before threading it into the synthesised EXP call.  
 * Rewrites PPL's {@code EXPM1(x)} UDF (defined as {@code exp(x) - 1}) into the
 */  
        RexBuilder rexBuilder = cluster.getRexBuilder();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexNode arg = NumericToDoubleAdapter.widenToDoubleIfNumeric(original.getOperands().get(0), cluster);  
import org.apache.calcite.rex.RexNode;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * dedicated {@code Math.expm1} implementation, but PPL's semantic is already  
        if (!original.getOperator().getName().equalsIgnoreCase("EXPM1")) {
 * <p>For very small inputs {@code exp(x) - 1} has worse precision than the
 * the naive subtraction (see {@code PPLBuiltinOperators.EXPM1}) so behaviour
 * compatible open source license.
import org.apache.calcite.plan.RelOptCluster;
}
import java.util.List;
 * @opensearch.internal
 * equivalent {@code MINUS(EXP(x), 1)} expression tree. DataFusion's substrait  
 *
package org.opensearch.be.datafusion;
        // here won't be re-adapted by NumericToDoubleAdapter — we have to widen explicitly.
import org.apache.calcite.rex.RexCall;  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.opensearch.analytics.spi.NumericToDoubleAdapter;
/**
 * The OpenSearch Contributors require contributions made to  
        RexNode one = rexBuilder.makeExactLiteral(BigDecimal.ONE);
        }
 *
    }
 * serialisation keeps the plan expressible in standard Substrait primitives.  
            return original;  
 * this file be licensed under the Apache-2.0 license or a
        return rexBuilder.makeCall(SqlStdOperatorTable.MINUS, exp, one);  
class Expm1Adapter implements ScalarFunctionAdapter {  
        // Defensive: only rewrite the EXPM1 UDF. Any other call passes through.
 * SPDX-License-Identifier: Apache-2.0
        }
        RexNode exp = rexBuilder.makeCall(original.getType(), SqlStdOperatorTable.EXP, List.of(arg));
 */
import java.math.BigDecimal;
 *  
        if (original.getOperands().size() != 1) {
/*  
    @Override
            return original;  
import org.opensearch.analytics.spi.FieldStorageInfo;  
 * consumer recognises {@code exp} and {@code subtract} natively, but has no
