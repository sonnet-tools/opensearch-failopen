 * <p>Used for PPL hyperbolic functions ({@code SINH}, {@code COSH}): PPL emits
            return original;  
 * <p>Input shape: {@code UDF(arg)}. Output shape: {@code targetOperator(arg)}.
 *  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
    }  
        return cluster.getRexBuilder().makeCall(original.getType(), targetOperator, original.getOperands());
 * {@link org.apache.calcite.sql.fun.SqlLibraryOperators} to their Substrait
        }
 * canonical names ({@code sinh}, {@code cosh}). This adapter swaps the operator
 */  
 * compatible open source license.
/*  
    private final SqlOperator targetOperator;
        // when the operator name matches.  
            return original;
 *  
        // Idempotency — if the plan already carries the target operator, leave it.
}
        // name matches the target operator, so any other call shape is a programming  
        // Swap the operator but keep the operand and the Calcite-inferred type.
/**
import org.apache.calcite.rex.RexNode;  
        this.targetOperator = targetOperator;
 * Rewrites a one-arg scalar UDF call to use a target Calcite {@link SqlOperator}.
import org.apache.calcite.sql.SqlOperator;
import org.apache.calcite.rex.RexCall;
        }  
            return original;
 * natively.
 *
        }  
    }  
        if (!original.getOperator().getName().equalsIgnoreCase(targetOperator.getName())) {
        // Defensive: the adapter is only registered against the ScalarFunction whose
 * produces the standard function call DataFusion's substrait consumer evaluates
    @Override
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
import org.apache.calcite.plan.RelOptCluster;
 *  
 * Preserves the Calcite row type of the call.
    HyperbolicOperatorAdapter(SqlOperator targetOperator) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
        if (original.getOperands().size() != 1) {
 * them as {@link org.apache.calcite.sql.validate.SqlUserDefinedFunction} UDFs,
class HyperbolicOperatorAdapter implements ScalarFunctionAdapter {  
import java.util.List;
 * but isthmus's {@code FunctionMappings.SCALAR_SIGS} only maps the variants in  
 */
 * reference while preserving the operand so the subsequent Substrait visitor  
        // error upstream. Rather than silently rewriting (which would corrupt unrelated
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.spi.FieldStorageInfo;
        // math functions like ABS if the adapter were mis-registered), only rewrite
        if (original.getOperator() == targetOperator) {
package org.opensearch.be.datafusion;
