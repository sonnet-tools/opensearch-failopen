        // rather than this adapter inventing a valid one.  
 * niladic {@code random()} UDF.
 */
 * <p><b>Seeded form is rejected, not silently degraded.</b> PPL's reference {@code rand(N)} seeds the
import java.util.List;  
        if (operands.isEmpty()) {
/**
                "Seeded RAND(seed) is not supported on the analytics-engine route; use RAND() without a seed"
import org.apache.calcite.plan.RelOptCluster;
class RandSeedAdapter implements ScalarFunctionAdapter {
        // Unexpected arity — leave the call untouched so the converter surfaces the original shape
 *
 */  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            RexBuilder rexBuilder = cluster.getRexBuilder();
 * whose {@code FunctionMappings.Sig} in {@link DataFusionFragmentConvertor} resolves to DataFusion's
    }
 * @opensearch.internal  
 * generator so identical {@code N} yields identical values — it is observably <em>deterministic</em>
import org.opensearch.analytics.spi.FieldStorageInfo;  
    @Override
 *  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * compatible open source license.
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
            );  
            // Seeded rand(N): no faithful niladic mapping (would lose determinism). Fail clearly.  
}  
import org.apache.calcite.rex.RexCall;  
            return rexBuilder.makeCall(original.getType(), SqlStdOperatorTable.RAND, List.of());  
        if (operands.size() == 1) {
/*  
        return original;
package org.opensearch.be.datafusion;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * {@code random()} is niladic and unseeded, so there is no faithful mapping. Dropping the seed would
 * (see {@code MathematicalFunctions.rand}, which uses {@code new Random(N).nextFloat()}). DataFusion's  
import org.apache.calcite.rex.RexNode;
 * {@code random} is available on the DataFusion side, {@code rand(seed)} fails fast here with a clear,  
 * Adapter for PPL {@code RAND([N])}. Niladic {@code rand()} maps to {@code SqlStdOperatorTable.RAND},  
import org.apache.calcite.rex.RexBuilder;
        }
 * turn a deterministic call into a non-deterministic one — a silent semantic change. Until a seeded
        }
 *
 * SPDX-License-Identifier: Apache-2.0
        List<RexNode> operands = original.getOperands();  
            throw new IllegalArgumentException(
 * actionable error rather than returning subtly wrong (non-reproducible) results.
