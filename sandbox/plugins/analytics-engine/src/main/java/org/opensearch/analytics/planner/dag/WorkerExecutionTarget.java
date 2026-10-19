 * buffer.
 *
    private final int partitionIndex;
    }  
 * this file be licensed under the Apache-2.0 license or a
    }
 *
import org.opensearch.cluster.node.DiscoveryNode;
    public int partitionIndex() {
}
package org.opensearch.analytics.planner.dag;
 * pair so the worker plan can drain only its partition's slice from the shuffle  
 * @opensearch.internal  
 * one task per shuffle partition; each task carries the {@code (node, partitionIndex)}
/*  
 */
 * compatible open source license.
        return partitionIndex;  
 */  
 * SPDX-License-Identifier: Apache-2.0
        super(node);
 * The OpenSearch Contributors require contributions made to  
    public WorkerExecutionTarget(DiscoveryNode node, int partitionIndex) {  
 * Execution target for a hash-shuffle worker task. The worker stage fans out into
/**  
public final class WorkerExecutionTarget extends ExecutionTarget {
        this.partitionIndex = partitionIndex;
