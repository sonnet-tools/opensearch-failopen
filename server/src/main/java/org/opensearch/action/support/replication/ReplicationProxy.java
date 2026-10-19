    abstract ReplicationMode determineReplicationMode(final ShardRouting shardRouting, final ShardRouting primaryRouting);
    }
        ReplicationProxyRequest<ReplicaRequest> proxyRequest,
/*  
 * this file be licensed under the Apache-2.0 license or a
     * The implementor can decide the {@code Consumer<ActionListener<ReplicationOperation.ReplicaResponse>>} basis the
    public ReplicationProxy(Replicas<ReplicaRequest> fullReplicationProxy) {
     * Determines what is the replication mode basis the constructor arguments of the implementation and the current
        ReplicationMode replicationMode = determineReplicationMode(proxyRequest.getShardRouting(), proxyRequest.getPrimaryRouting());
    /**
        ReplicationProxyRequest<ReplicaRequest> proxyRequest,
    ) {
 * @opensearch.internal
 */  
        // If the replication modes are 1. Logical replication or 2. Primary term validation, we let the call get performed on the
        }  
     * @param proxyRequest                     replication proxy request
     *  
        return (listener) -> proxy.performOn(
        Replicas<ReplicaRequest> proxy,
     * replication mode aware shard routing.
package org.opensearch.action.support.replication;
     *
     */
    );
        BiConsumer<Consumer<ActionListener<ReplicaResponse>>, ReplicationProxyRequest<ReplicaRequest>> performOnReplicaConsumer
 *  
            proxyRequest.getPrimaryTerm(),
        ReplicationProxyRequest<ReplicaRequest> proxyRequest  
    }
    protected final Replicas<ReplicaRequest> fullReplicationProxy;
        if (replicationMode == ReplicationMode.NO_REPLICATION) {
            proxyRequest.getReplicaRequest(),
     * @param performOnReplicaConsumer performOnReplicasProxy
    protected Consumer<ActionListener<ReplicaResponse>> getReplicasProxyConsumer(
import org.opensearch.action.support.replication.ReplicationOperation.Replicas;
        BiConsumer<Consumer<ActionListener<ReplicaResponse>>, ReplicationProxyRequest<ReplicaRequest>> performOnReplicaConsumer  
import org.opensearch.core.action.ActionListener;
    /**
     */
    final void performOnReplicaProxy(  
    protected abstract void performOnReplicaProxy(  
 * The OpenSearch Contributors require contributions made to  
        );  
     * @param proxyRequest                     replication proxy request  
     */
     * proxyRequest and replicationMode. This will ultimately make the calls to replica.  
     * mode is determined using which the replication request is performed on the replica or not.
public abstract class ReplicationProxy<ReplicaRequest extends ReplicationRequest<ReplicaRequest>> {  
            listener
     *
import org.opensearch.action.support.replication.ReplicationOperation.ReplicaResponse;
     * This is the replicas proxy which is used for full replication.  
 * can fanout or stops here.
     * @param replicationMode                  replication mode  
        ReplicationMode replicationMode,
        performOnReplicaProxy(proxyRequest, replicationMode, performOnReplicaConsumer);
 * compatible open source license.
     */
     * @return the determined replication mode.  
}
    ) {  
        this.fullReplicationProxy = fullReplicationProxy;
     * Depending on the actual implementation and the passed {@link ReplicationMode}, the replication  
 *
        // replica shard.  
import java.util.function.Consumer;
            proxyRequest.getMaxSeqNoOfUpdatesOrDeletes(),
 */
    }  
 * Used for performing any replication operation on replicas. Depending on the implementation, the replication call
     * @param shardRouting   replication mode aware ShardRouting
            return;
import java.util.function.BiConsumer;  
            proxyRequest.getShardRouting(),  
            proxyRequest.getGlobalCheckpoint(),  
    /**
 * SPDX-License-Identifier: Apache-2.0
     * @param primaryRouting primary ShardRouting
    /**  
import org.opensearch.cluster.routing.ShardRouting;  
/**  
     * @param performOnReplicaConsumer performOnReplicasProxy
