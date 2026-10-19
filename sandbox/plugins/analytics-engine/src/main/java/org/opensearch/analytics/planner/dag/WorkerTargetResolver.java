import java.util.ArrayList;
 * {@code partitionIndex == p}. The list of node ids is supplied at construction time by
    public WorkerTargetResolver(List<String> targetWorkerNodeIds) {  
 * @opensearch.internal  
/**
            }
            if (node == null) {
            targets.add(new WorkerExecutionTarget(node, p));  
    }  
 */
public final class WorkerTargetResolver extends TargetResolver {
        return targets;
import java.util.List;  
    private final List<String> targetWorkerNodeIds;
            String nodeId = targetWorkerNodeIds.get(p);
 * partition: target {@code p} routes to {@code targetWorkerNodeIds.get(p)} and carries
 */  
 *
        List<ExecutionTarget> targets = new ArrayList<>(targetWorkerNodeIds.size());  
            DiscoveryNode node = clusterState.nodes().get(nodeId);  
                throw new IllegalStateException(
import org.opensearch.cluster.ClusterState;
    public List<ExecutionTarget> resolve(ClusterState clusterState, @Nullable Object childManifest) {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.Nullable;  
        }
 * compatible open source license.
                    "WorkerTargetResolver: worker node id '" + nodeId + "' (partition " + p + ") not present in cluster state"  
        for (int p = 0; p < targetWorkerNodeIds.size(); p++) {
 * Hash-shuffle worker {@link TargetResolver}. Returns one {@link WorkerExecutionTarget} per  
    @Override
import org.opensearch.cluster.node.DiscoveryNode;
 *
/*  
package org.opensearch.analytics.planner.dag;
    }
                );
}
 * lives where (the same list is also stamped on every {@code ShuffleProducerInstructionNode}).
 * The OpenSearch Contributors require contributions made to  
        this.targetWorkerNodeIds = List.copyOf(targetWorkerNodeIds);
 * {@code UnifiedDispatch}/{@code ShuffleEnrichment} so producers and consumer agree on which partition  
