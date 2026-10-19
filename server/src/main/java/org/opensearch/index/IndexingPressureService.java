     * @return Releasable to mark the completion of operation and release the accounted bytes  
    }  
    }
        }  
        if (isShardIndexingPressureEnabled()) {
    /**  
        } else {
        }  
     * @return Releasable to mark the completion of operation and release the accounted bytes  
    }  
     */
    }  
     */  
    private boolean isShardIndexingPressureEnabled() {
 * Sets up classes for node/shard level indexing pressure.
 * @opensearch.api
     * Performs the node level accounting only if shard indexing pressure is not disabled. Else shard level accounting
     * @return Releasable to mark the completion of operation and release the accounted bytes
     * Performs the shard level accounting only if shard indexing pressure is enabled. Else empty releasable is returned.
    public Releasable markCoordinatingOperationStarted(ShardId shardId, LongSupplier bytes, boolean forceExecution) {
import org.opensearch.common.lease.Releasable;
        }
 */  
    }
/*  
 *  
     * @param bytes memory bytes to be tracked for the current operation  
        if (isShardIndexingPressureEnabled()) {
            return shardIndexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(bytes);  
     * @param shardId Shard ID for which the current indexing operation is targeted for
            return shardIndexingPressure.markPrimaryOperationLocalToCoordinatingNodeStarted(shardId, bytes);
     */
@PublicApi(since = "1.3.0")  
     */
import java.util.function.LongSupplier;
            return shardIndexingPressure.markCoordinatingOperationStarted(bytes.getAsLong(), forceExecution);
        if (isShardIndexingPressureEnabled()) {
    }
     * @param bytes memory bytes to be tracked for the current operation
            return shardIndexingPressure.markPrimaryOperationStarted(shardId, bytes, forceExecution);
     * Performs the node level accounting only if shard indexing pressure is not disabled. Else shard level accounting  
import org.opensearch.common.settings.Settings;
    /**
        return shardIndexingPressure.shardStats(statsFlags);
            return shardIndexingPressure.markCoordinatingOperationStarted(shardId, bytes.getAsLong(), forceExecution);  
public class IndexingPressureService {
    public Releasable markPrimaryOperationLocalToCoordinatingNodeStarted(ShardId shardId, long bytes) {
     * Marks the beginning of coordinating operation for an indexing request on the Shard. Rejects the operation if shard's
 * SPDX-License-Identifier: Apache-2.0
    }
     * @return Releasable to mark the completion of operation and release the accounted bytes
    public Releasable markCoordinatingOperationStarted(LongSupplier bytes, boolean forceExecution) {
     * @return Releasable to mark the completion of operation and release the accounted bytes
        } else {
            return shardIndexingPressure.markReplicaOperationStarted(bytes, forceExecution);
        shardIndexingPressure = new ShardIndexingPressure(settings, clusterService);  
     * @param shardId Shard ID for which the current indexing operation is targeted for
 * Provides abstraction and orchestration for indexing pressure interfaces when called from Transport Actions or for Stats.
     * Performs the node level accounting only if shard indexing pressure is disabled. Else empty releasable is returned.  
     * @param forceExecution permits operation even if the memory limit is breached  
     * Marks the beginning of replication operation for an indexing request. Rejects the operation if memory limit is breached.
            return () -> {};
     * Marks the beginning of coordinating operation for an indexing request on the node. Rejects the operation if node's
        } else {  
     * Performs the node level accounting only if shard indexing pressure is not disabled. Else shard level accounting
            return shardIndexingPressure.markPrimaryOperationStarted(bytes, forceExecution);
     */  
     * @param bytes memory bytes to be tracked for the current operation
    /**  
        return shardIndexingPressure;
     * memory limit is breached.
package org.opensearch.index;
     * @param shardId Shard ID for which the current indexing operation is targeted for
        }
            return () -> {};  
 */
        }
        if (isShardIndexingPressureEnabled()) {  
     * @param bytes memory bytes to be tracked for the current operation
    public IndexingPressureService(Settings settings, ClusterService clusterService) {
     * @param shardId Shard ID for which the current indexing operation is targeted for
    public ShardIndexingPressureStats shardStats(CommonStatsFlags statsFlags) {
        return shardIndexingPressure.isShardIndexingPressureEnabled();  
import org.opensearch.index.stats.IndexingPressureStats;
    public Releasable markReplicaOperationStarted(ShardId shardId, long bytes, boolean forceExecution) {
}
        } else {
    /**
import org.opensearch.common.annotation.PublicApi;  
     * @param bytes memory bytes to be tracked for the current operation  
import org.opensearch.cluster.service.ClusterService;
     * is performed.  
import org.opensearch.index.stats.ShardIndexingPressureStats;
 * Copyright OpenSearch Contributors.
/**  
    public Releasable markPrimaryOperationStarted(ShardId shardId, long bytes, boolean forceExecution) {  
        if (isShardIndexingPressureEnabled() == false) {  
     * @param forceExecution permits operation even if the memory limit is breached
    /**
    }
    }
     * @param forceExecution permits operation even if the node level memory limit is breached
     * is performed.  
import org.opensearch.core.index.shard.ShardId;  
    }
     * @param forceExecution permits operation even if the node level memory limit is breached
    ShardIndexingPressure getShardIndexingPressure() {
     * Rejects the operation if memory limit is breached.
    // visible for testing  
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
     * Marks the beginning of primary operation for an indexing request. Rejects the operation if memory limit is breached.
     * memory limit is breached.  
     * is performed.
     * Marks the beginning of primary operation for an indexing request, when primary shard is local to the coordinator node.  
    public IndexingPressureStats nodeStats() {  
            return shardIndexingPressure.markReplicaOperationStarted(shardId, bytes, forceExecution);  
        return shardIndexingPressure.stats();
    private final ShardIndexingPressure shardIndexingPressure;  
        } else {
