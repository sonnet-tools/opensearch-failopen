import org.opensearch.cluster.node.DiscoveryNode;
        if (primary) {
 * this file be licensed under the Apache-2.0 license or a
    }  
 * SPDX-License-Identifier: Apache-2.0
        } else {
        }
 * compatible open source license.
import org.opensearch.core.index.shard.ShardId;  
 * A factory class to create new responses of batch transport actions like  
        this.primary = primary;
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
 * @param <T> Node level response returned by batch transport actions.  
/**
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch;
 *
        }  
import org.opensearch.gateway.TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch;
 * {@link TransportNodesListGatewayStartedShardsBatch} or {@link org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch}
import org.opensearch.action.support.nodes.BaseNodeResponse;
import java.util.Map;  
}
        if (primary) {
    public ShardBatchResponseFactory(boolean primary) {  
            return (Map<ShardId, V>) ((NodeStoreFilesMetadataBatch) response).getNodeStoreFilesMetadataBatch();
        } else {  
    }
 */
            return (T) new NodeGatewayStartedShardsBatch(node, (Map<ShardId, GatewayStartedShard>) shardData);  
 */  
 * @param <V> Shard level metadata returned by batch transport actions.
    public T getNewResponse(DiscoveryNode node, Map<ShardId, V> shardData) {
/*  
            return (T) new NodeStoreFilesMetadataBatch(node, (Map<ShardId, NodeStoreFilesMetadata>) shardData);
    private final boolean primary;
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata;  
 *
public class ShardBatchResponseFactory<T extends BaseNodeResponse, V> {  
package org.opensearch.gateway;
    public Map<ShardId, V> getShardBatchData(T response) {  
            return (Map<ShardId, V>) ((NodeGatewayStartedShardsBatch) response).getNodeGatewayStartedShardsBatch();
