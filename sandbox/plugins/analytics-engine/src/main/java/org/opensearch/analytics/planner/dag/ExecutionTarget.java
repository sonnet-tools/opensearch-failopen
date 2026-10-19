 * are implemented.  
    /** The node this target executes on. Used by the Scheduler for request routing. */  
 *
 * SPDX-License-Identifier: Apache-2.0
 *
    protected ExecutionTarget(DiscoveryNode node) {
 * <p>{@link #node()} is the mandatory routing key — the Scheduler sends one  
 * InMemoryExecutionTarget when shuffle aggregates, joins, and broadcast joins
    private final DiscoveryNode node;  
 * @opensearch.internal
 *  
 * {@code FragmentExecutionRequest} per target to the target's node. Subclasses
 * this file be licensed under the Apache-2.0 license or a
    }
public abstract class ExecutionTarget {
    public DiscoveryNode node() {
 */  
 *
    }  
import org.opensearch.cluster.node.DiscoveryNode;
/*  
 * compatible open source license.
package org.opensearch.analytics.planner.dag;
 * carry the execution-specific context the data node needs to set up its input source.
        return node;
}
 * <p>TODO: add ShuffleFileExecutionTarget, ShuffleStreamExecutionTarget,
 */  
 * Identifies where and how a stage's fragment should execute on a single node.
        this.node = node;  
/**  
 * The OpenSearch Contributors require contributions made to  
