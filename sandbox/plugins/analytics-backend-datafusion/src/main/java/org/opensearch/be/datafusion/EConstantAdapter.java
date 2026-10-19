import org.apache.calcite.plan.RelOptCluster;
 * before Substrait serialisation produces a literal expression the downstream
    }
        if (!original.getOperands().isEmpty()) {  
 */  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 * @opensearch.internal
 *
        }
 * plan handles trivially.  
import java.math.BigDecimal;
 *
 * compatible open source license.
 * scalar function, but constant-folding the call on the coordinator side
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
}
    @Override  
        }
class EConstantAdapter implements ScalarFunctionAdapter {
 * equal to {@link Math#E}. DataFusion's substrait consumer has no {@code e}  
        // "E", passes through unchanged so it can be surfaced as a planner error
            return original;
import org.apache.calcite.rex.RexNode;  
            return original;
import org.apache.calcite.rex.RexCall;
 */  
        // further down the pipeline instead of being silently dropped.
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
/*  
import org.opensearch.analytics.spi.FieldStorageInfo;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.be.datafusion;
/**
        // registration — any call with operands, or one whose operator isn't named  
        // Only rewrite the zero-arg E() UDF. Defensive guard against accidental
 * Rewrites the zero-arg PPL {@code E()} UDF call to a {@code DOUBLE} literal
import java.util.List;
        if (!original.getOperator().getName().equalsIgnoreCase("E")) {  
        return cluster.getRexBuilder().makeApproxLiteral(BigDecimal.valueOf(Math.E));  
