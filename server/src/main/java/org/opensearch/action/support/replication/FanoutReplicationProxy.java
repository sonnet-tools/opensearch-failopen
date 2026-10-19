 * compatible open source license.
 */
    @Override  
    public FanoutReplicationProxy(Replicas<ReplicaRequest> replicasProxy) {
 *
package org.opensearch.action.support.replication;
        assert replicationMode == ReplicationMode.FULL_REPLICATION : "FanoutReplicationProxy allows only full replication mode";  
public class FanoutReplicationProxy<ReplicaRequest extends ReplicationRequest<ReplicaRequest>> extends ReplicationProxy<ReplicaRequest> {  
 *  
        return shardRouting.isSameAllocation(primaryRouting) == false ? ReplicationMode.FULL_REPLICATION : ReplicationMode.NO_REPLICATION;  
        ReplicationMode replicationMode,  
 */  
        super(replicasProxy);  
import org.opensearch.action.support.replication.ReplicationOperation.ReplicaResponse;
    @Override
 * This implementation of {@link ReplicationProxy} fans out the replication request to current shard routing if
    protected void performOnReplicaProxy(
    }
    }
/**  
import org.opensearch.cluster.routing.ShardRouting;  
import java.util.function.Consumer;
    ReplicationMode determineReplicationMode(ShardRouting shardRouting, ShardRouting primaryRouting) {
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
}
 * it is not the primary and has replication mode as {@link ReplicationMode#FULL_REPLICATION}.
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
        performOnReplicaConsumer.accept(getReplicasProxyConsumer(fullReplicationProxy, proxyRequest), proxyRequest);
    ) {
import org.opensearch.action.support.replication.ReplicationOperation.Replicas;
/*  
        ReplicationProxyRequest<ReplicaRequest> proxyRequest,
import java.util.function.BiConsumer;  
    }
import org.opensearch.core.action.ActionListener;
        BiConsumer<Consumer<ActionListener<ReplicaResponse>>, ReplicationProxyRequest<ReplicaRequest>> performOnReplicaConsumer
