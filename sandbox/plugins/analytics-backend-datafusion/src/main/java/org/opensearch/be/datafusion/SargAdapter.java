class SargAdapter implements ScalarFunctionAdapter {
        if (original.getKind() != SqlKind.SEARCH) {
        // multi-point exclusions): Filter.<init> asserts RexUtil.isFlat on the condition.
import org.apache.calcite.rex.RexCall;  
        RexBuilder rexBuilder = cluster.getRexBuilder();
import org.apache.calcite.rex.RexNode;
 * this file be licensed under the Apache-2.0 license or a
            return original;  
    @Override  
 *
    }
        return RexUtil.flatten(rexBuilder, expanded);  
import java.util.List;
import org.apache.calcite.rex.RexBuilder;
/** Expands Calcite's {@code SEARCH(field, Sarg[...])} fold so substrait/DataFusion can consume the predicate. */  
}
import org.apache.calcite.sql.SqlKind;  
import org.apache.calcite.rex.RexUtil;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 * compatible open source license.
 */  
        // Flatten the right-leaning AND chain that expandSearch produces (e.g.
package org.opensearch.be.datafusion;
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
        }
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.apache.calcite.plan.RelOptCluster;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.FieldStorageInfo;
        RexNode expanded = RexUtil.expandSearch(rexBuilder, null, original);  
