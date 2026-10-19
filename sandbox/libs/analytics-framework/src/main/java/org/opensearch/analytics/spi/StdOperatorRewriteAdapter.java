 *       named "DIVIDE") → {@code SqlStdOperatorTable.DIVIDE} → substrait {@code divide}.</li>
 * Rewrites a {@link RexCall} whose operator is a PPL / library-specific UDF to the equivalent  
            return original;
     *                     if the call already uses {@code target}, the rewrite is a no-op.  
import org.apache.calcite.plan.RelOptCluster;
        return cluster.getRexBuilder().makeCall(original.getType(), target, original.getOperands());
     * the PPL UDF or the std operator depending on how the call was constructed upstream.  
import org.apache.calcite.rex.RexNode;  
 * to Isthmus. The rewrite preserves operand order and result type.
 * this file be licensed under the Apache-2.0 license or a
        this.target = target;  
    }  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
 * <p>Adapter-level rewriting (rather than extending Isthmus's {@code ADDITIONAL_SCALAR_SIGS})  
 *
import java.util.List;  
 */
     * @param target       the {@code SqlStdOperatorTable} (or other Isthmus-mapped) operator
 * normalize PPL emissions so Isthmus's built-in {@code FunctionMappings.SCALAR_SIGS} can resolve
        if (original.getOperator() == target) {  
 * keeps the rewrite scoped to a single backend registration and avoids cross-cutting changes
        // Re-construct with the standard operator, preserving operands and result type.
 *
 * <ul>  
     * applying the rewrite when the call already uses the target operator — an adapter is
 * SPDX-License-Identifier: Apache-2.0
 *  
        String actualName = original.getOperator().getName();  
 * compatible open source license.
        }  
 *   <li>PPL's {@code DIVIDE} UDF ({@code PPLBuiltinOperators.DIVIDE}, a {@code SqlFunction}
}
    @Override  
 * them to the Substrait default extension catalog.  
package org.opensearch.analytics.spi;
 * {@link org.apache.calcite.sql.fun.SqlStdOperatorTable SqlStdOperatorTable} operator. Used to
import org.apache.calcite.rex.RexCall;
            return original;
    /** Canonical Calcite operator this adapter substitutes in. */
/*  
 *
    public StdOperatorRewriteAdapter(String expectedName, SqlOperator target) {
        // Already the target operator — e.g. PLUS arrived via SqlStdOperatorTable.PLUS. No-op.
        this.expectedName = expectedName;
     * Operator name we expect to rewrite. Matching on name (case-insensitive) guards against  
    }
     * @param expectedName case-insensitive match against {@code call.getOperator().getName()};
    /**
/**
    /**
    private final String expectedName;
     * keyed by {@link org.opensearch.analytics.spi.ScalarFunction} which can map to either
     *                     to substitute in.
        }
     */  
 * </ul>
 */  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    private final SqlOperator target;  
import org.apache.calcite.sql.SqlOperator;
        if (actualName == null || !actualName.equalsIgnoreCase(expectedName)) {
public class StdOperatorRewriteAdapter implements ScalarFunctionAdapter {  
 * <p>Examples:
     */
 *   <li>PPL's {@code MOD} UDF → {@code SqlStdOperatorTable.MOD} → substrait {@code modulus}.</li>  
