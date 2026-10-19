 * this file be licensed under the Apache-2.0 license or a
                shard.recoveryState().getTargetNode(),
/**  
        ShardRouting primaryShard = clusterService.state().routingTable().shardRoutingTable(shardId).primaryShard();  
 * SPDX-License-Identifier: Apache-2.0
        }
        if (node == null) {
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.cluster.routing.ShardRouting;
                getPrimaryNode(shard.shardId())  
        } else {  
 *
    private final TransportService transportService;
public class SegmentReplicationSourceFactory {
    public SegmentReplicationSource get(IndexShard shard) {  
        this.transportService = transportService;
    private final ClusterService clusterService;  
        if (shard.indexSettings().isAssignedOnRemoteNode()) {
            return new PrimaryShardReplicationSource(
                shard.routingEntry().allocationId().getId(),  
        RecoverySettings recoverySettings,
    }  
    }  
 *
                recoverySettings,
}
import org.opensearch.index.shard.IndexShard;
 */  
 * compatible open source license.
    public SegmentReplicationSourceFactory(
        this.clusterService = clusterService;  
 * @opensearch.internal  
    private DiscoveryNode getPrimaryNode(ShardId shardId) {
                transportService,
/*  
package org.opensearch.indices.replication;
        return node;
            throw new IllegalStateException("Cannot replicate, primary shard for " + shardId + " is not allocated on any node");  
        ClusterService clusterService
 * Factory to build {@link SegmentReplicationSource} used by {@link SegmentReplicationTargetService}.
import org.opensearch.indices.recovery.RecoverySettings;  
        DiscoveryNode node = clusterService.state().nodes().get(primaryShard.currentNodeId());
 */
import org.opensearch.core.index.shard.ShardId;
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.transport.TransportService;
    private final RecoverySettings recoverySettings;
        TransportService transportService,  
        this.recoverySettings = recoverySettings;
            );
    ) {  
        }
import org.opensearch.cluster.node.DiscoveryNode;
            return new RemoteStoreReplicationSource(shard);
