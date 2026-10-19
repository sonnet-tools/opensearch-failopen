            );
                case ALIAS -> "alias [" + name + "]";  
    private static String describeIndexSource(String name, ClusterState clusterState) {
        int shardCount = shardIterators.size();
public class ShardTargetResolver extends TargetResolver {  
    private final String indexName;
import org.opensearch.cluster.ClusterState;
                    + " targets ["
 * Resolves {@link ShardExecutionTarget}s for a DATA_NODE scan stage.
        IndexAbstraction abstraction = lookup != null ? lookup.get(name) : null;  
        // Same operator-facing ceiling vanilla search enforces, read live so a dynamic update takes  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.planner.dag;
        // Expand the table name (alias or concrete) to its concrete indices against the freshest
 *
        }
                    // failure can fall over to a replica copy via ShardExecutionTarget.nextCopy.
import org.opensearch.common.Nullable;
                    + shardCount  
import java.util.List;
                }
 *
        if (this.indexName == null) {
        this.clusterService = clusterService;
 */  
}
                    // Pass the remaining iterator + cluster state to the target so dispatch
                case CONCRETE_INDEX -> "index [" + name + "]";
                if (node != null) {  
        this.indexName = RelNodeUtils.findTableName(fragment);
import org.opensearch.analytics.planner.IndexResolution;  
    private final ClusterService clusterService;  
                    + "]. This limit exists because querying many shards at the same time can make the job of the "
        }  
 * <p>Shard routing gives both the node and the shardId in one pass —  
                "Query via "  
                DiscoveryNode node = clusterState.nodes().get(shard.currentNodeId());
import org.opensearch.cluster.routing.GroupShardsIterator;  
        return "index pattern [" + name + "]";
 * this file be licensed under the Apache-2.0 license or a
                    + TransportSearchAction.SHARD_COUNT_LIMIT_SETTING.getKey()
    }
        // effect on the next query. Unlimited by default: the can-match pre-filter phase and the
import org.opensearch.cluster.metadata.IndexAbstraction;  
    public List<ExecutionTarget> resolve(ClusterState clusterState, @Nullable Object childManifest) {
        // not accepted there — so the expansion has to happen here, not at construction time.
        IndexResolution resolution = IndexResolution.resolve(indexName, clusterState, indexNameExpressionResolver);
import org.opensearch.analytics.planner.RelNodeUtils;
import java.util.SortedMap;
/*  
import org.opensearch.action.search.TransportSearchAction;
                    + "] shards which exceeds the limit of ["
    }  
        long shardCountLimit = clusterService.getClusterSettings().get(TransportSearchAction.SHARD_COUNT_LIMIT_SETTING);
        int ordinal = 0;
            }
        if (shardCount > shardCountLimit) {  
/**
        this.indexNameExpressionResolver = indexNameExpressionResolver;  
 * resolves shard targets lazily when the Scheduler calls {@link #resolve}.
import org.opensearch.cluster.routing.ShardRouting;
 * The OpenSearch Contributors require contributions made to  
                    + sourceType
    @Override  
        GroupShardsIterator<ShardIterator> shardIterators = clusterService.operationRouting()
 * compatible open source license.
import java.util.ArrayList;  
        // cluster state. operationRouting().searchShards requires concrete names — aliases are  
        }  
        String[] concreteNames = resolution.concreteIndexNames().toArray(new String[0]);  
    public ShardTargetResolver(RelNode fragment, ClusterService clusterService, IndexNameExpressionResolver indexNameExpressionResolver) {  
import org.opensearch.cluster.node.DiscoveryNode;
                    + "] set by ["  
    }
            String sourceType = describeIndexSource(indexName, clusterState);
 */
            ShardRouting shard = shardIt.nextOrNull();  
 * @opensearch.internal
        }
            throw new IllegalArgumentException(
 *  
        // per-node dispatch throttle are what bound fan-out in normal operation, and this stays a
        // valve for operators who want a hard stop.  
            throw new IllegalArgumentException("ShardTargetResolver: no OpenSearchTableScan found in fragment");
                    targets.add(new ShardExecutionTarget(node, shard.shardId(), ordinal++, shardIt, clusterState));  
 * rather than {@link ComposableTargetResolver}.
        for (ShardIterator shardIt : shardIterators) {
                    + "coordinating node very CPU and/or memory intensive. Query fewer indices, or raise the limit."  
            .searchShards(clusterState, concreteNames, null, null);
        return targets;
        List<ExecutionTarget> targets = new ArrayList<>();  
            if (shard != null) {
        if (abstraction != null) {
import org.apache.calcite.rel.RelNode;
            };  
                case DATA_STREAM -> "data stream [" + name + "]";
 * Extracts the index name from the fragment at construction time, then  
            return switch (abstraction.getType()) {
                    + shardCountLimit
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.routing.ShardIterator;
        SortedMap<String, IndexAbstraction> lookup = clusterState.metadata().getIndicesLookup();
    private final IndexNameExpressionResolver indexNameExpressionResolver;
 * these are coupled and cannot be separated, hence a dedicated resolver
