import java.util.List;
import org.apache.calcite.rex.RexNode;  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 *
/*  
        return original.clone(original.getType(), original.getOperands().subList(0, 2));
 * Drops the 3rd escape operand from LIKE/ILIKE calls so Isthmus can serialize them via the
 * maps to the custom {@code ilike} extension declared in {@code opensearch_scalar_functions.yaml}.
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 * and is not expressible in either signature.
 * <p>Case-insensitive semantics are preserved: PPL's default {@code like} lowers to  
/**  
            return original;  
package org.opensearch.be.datafusion;
    @Override  
        }
        if (original.getOperands().size() != 3) {
 * @opensearch.internal
 */  
 *
import org.apache.calcite.plan.RelOptCluster;
 * {@code LIKE(value, pattern, escape)} — the escape is almost always the default {@code '\'}  
 * compatible open source license.
import org.opensearch.analytics.spi.FieldStorageInfo;
 *
    }  
 * {@link org.apache.calcite.sql.fun.SqlLibraryOperators#ILIKE}, which {@link DataFusionFragmentConvertor}
import org.apache.calcite.rex.RexCall;
}
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 * SPDX-License-Identifier: Apache-2.0
 * The adapter therefore leaves the operator untouched and only normalizes arity.  
 * 2-arg {@code like} / {@code ilike} Substrait signatures. Calcite's grammar always emits
class LikeAdapter implements ScalarFunctionAdapter {
 */  
