/**
 *  
 * SPDX-License-Identifier: Apache-2.0
 */
 * @opensearch.internal
public interface WindowFunctionAdapter {
import org.apache.calcite.rex.RexOver;
    /**  
     * @param adaptedOrderKeys  order-by collations after recursive scalar adaptation  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 *
 * this file be licensed under the Apache-2.0 license or a
    );  
    RexNode adapt(  
import org.apache.calcite.rex.RexFieldCollation;
 * Registered by backends keyed by {@link WindowFunction}. Operands, PARTITION BY, and ORDER BY arrive
     * @param cluster           provides {@code getRexBuilder()} for constructing new RexNodes
 * Per-function adapter that rewrites a backend-agnostic window {@link RexOver} into a backend-compatible form.  
}
     * @param original          the original RexOver (use for type, frame bounds, distinct/ignore-nulls flags)  
        List<RexNode> adaptedPartitions,  
import org.apache.calcite.rex.RexNode;  
     *
        RexOver original,
        RelOptCluster cluster
     *         contract permits any RexNode in case an adapter wants to wrap or unwrap)
     * Adapt the given {@link RexOver} for backend compatibility.
@FunctionalInterface  
     */
import java.util.List;  
     * @param adaptedPartitions partition-by expressions after recursive scalar adaptation
     * @return the adapted expression (typically a fresh {@link RexOver}, but Calcite's
        List<RexFieldCollation> adaptedOrderKeys,
     *         {@code RexBuilder.makeOver} returns the wider {@link RexNode} type, so the  
 */  
     * @param adaptedOperands   operands after recursive scalar adaptation
        List<RexNode> adaptedOperands,
/*  
package org.opensearch.analytics.spi;
 * already-adapted from {@code BackendPlanAdapter}'s scalar-recursion pass.
import org.apache.calcite.plan.RelOptCluster;
