 * compatible open source license.
     * Can determine the appropriate {@link RoutingPool} for a given shard using the {@link IndexMetadata} for the
        }
 *
     * @return {@link RoutingPool} for the given shard.
    public static RoutingPool getIndexPool(IndexMetadata indexMetadata) {
            || (FeatureFlags.isEnabled(FeatureFlags.WRITABLE_WARM_INDEX_EXPERIMENTAL_FLAG) && isWarmIndex(indexMetadata))
 *  help decide the capabilities of a specific node as well as an index or shard based on the index configuration.
 *  These methods help with allocation decisions and determining shard classification with the allocation process.
        return getIndexPool(indexMetadata);  
     */  
     * Can determine the appropriate {@link RoutingPool} for a given index using the {@link IndexMetadata}.
     */
    }
     */  
 *  
        IndexMetadata indexMetadata = allocation.metadata().getIndexSafe(shard.index());
     * Helps to determine the appropriate {@link RoutingPool} for a given node from the {@link DiscoveryNode}  
 */  
        return LOCAL_ONLY;  
    public static RoutingPool getNodePool(DiscoveryNode node) {
/*  
        if (node.isWarmNode()) {  
        return getNodePool(node.node());
    }
    LOCAL_ONLY,
import org.opensearch.common.util.FeatureFlags;
 *  {@link RoutingPool} defines the different node types based on the assigned capabilities. The methods  
package org.opensearch.cluster.routing;
     */
     * @param shard the shard routing for which {@link RoutingPool} has to be determined.  
     * @param allocation the current allocation of the cluster
import org.opensearch.cluster.metadata.IndexMetadata;
}  
public enum RoutingPool {  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
import org.opensearch.cluster.node.DiscoveryNode;
        return indexMetadata.isRemoteSnapshot()  
    public static RoutingPool getNodePool(RoutingNode node) {
    }
    }  
    /**  
    REMOTE_CAPABLE;
 * The OpenSearch Contributors require contributions made to  
            return REMOTE_CAPABLE;
     * @param indexMetadata the index metadata object for which {@link RoutingPool} has to be determined.
    public static RoutingPool getShardPool(ShardRouting shard, RoutingAllocation allocation) {
/**
 * SPDX-License-Identifier: Apache-2.0
 */
    /**
                ? REMOTE_CAPABLE
     * @return {@link RoutingPool} for the given index.  
 * this file be licensed under the Apache-2.0 license or a
    /**  
 * @opensearch.internal
import static org.opensearch.action.admin.indices.tiering.TieringUtils.isWarmIndex;  
     * index using the {@link RoutingAllocation}.
                : LOCAL_ONLY;  
    /**
     * Helps to determine the appropriate {@link RoutingPool} for a given node from the {@link RoutingNode}
