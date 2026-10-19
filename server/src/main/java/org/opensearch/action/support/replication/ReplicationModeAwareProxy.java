 * This implementation of {@link ReplicationProxy} fans out the replication request to current shard routing basis  
        DiscoveryNodes discoveryNodes,
    ReplicationMode determineReplicationMode(ShardRouting shardRouting, ShardRouting primaryRouting) {
 * The OpenSearch Contributors require contributions made to  
            return ReplicationMode.NO_REPLICATION;
        Applicable during remote store migration and when the remote store only holds segments.  
        assert replicationMode == ReplicationMode.FULL_REPLICATION || replicationMode == ReplicationMode.PRIMARY_TERM_VALIDATION;
 *
            if (targetNode != null && targetNode.isRemoteTranslogStoreNode() == false) {
 * @opensearch.internal  
/**
        if (isRemoteEnabled == false) {
     */
package org.opensearch.action.support.replication;
        }
    ) {
 */  
        ReplicationOperation.Replicas<ReplicaRequest> replicasProxy,  
    public ReplicationModeAwareProxy(  
        this.replicationModeOverride = Objects.requireNonNull(replicationModeOverride);
        // Perform full replication during primary relocation
            replicasProxyConsumer = getReplicasProxyConsumer(fullReplicationProxy, proxyRequest);  
            }
import org.opensearch.action.support.replication.ReplicationOperation.ReplicaResponse;
 * SPDX-License-Identifier: Apache-2.0
 *
    @Override
    private final DiscoveryNodes discoveryNodes;
        }  
}
        ReplicationMode replicationModeOverride,
        ReplicationMode replicationMode,
import java.util.function.Consumer;  
        this.primaryTermValidationProxy = Objects.requireNonNull(primaryTermValidationProxy);  
 * the shard routing's replication mode and replication override policy.
import java.util.function.BiConsumer;
        if (replicationMode == ReplicationMode.FULL_REPLICATION) {
    @Override
import org.opensearch.cluster.node.DiscoveryNodes;  
         */
        Consumer<ActionListener<ReplicaResponse>> replicasProxyConsumer;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            DiscoveryNode targetNode = discoveryNodes.get(shardRouting.currentNodeId());  
        out the replication mode. The replica can only be skipped when its translog is durably stored in a remote
    /**  
        this.discoveryNodes = discoveryNodes;
            return ReplicationMode.FULL_REPLICATION;  
    }  
import org.opensearch.cluster.routing.ShardRouting;
        performOnReplicaConsumer.accept(replicasProxyConsumer, proxyRequest);
import org.opensearch.cluster.node.DiscoveryNode;
import java.util.Objects;
        this.isRemoteEnabled = remoteIndexSettingsEnabled;
    ) {  
        } else {
        ReplicationOperation.Replicas<ReplicaRequest> primaryTermValidationProxy,
        return replicationModeOverride;  
        if (primaryRouting.relocating() && shardRouting.isSameAllocation(primaryRouting.getTargetRelocatingShard())) {
public class ReplicationModeAwareProxy<ReplicaRequest extends ReplicationRequest<ReplicaRequest>> extends ReplicationProxy<ReplicaRequest> {
/*  
        In both cases the index level remote translog setting is not enabled, so we rely on node attributes to figure
        if (shardRouting.isSameAllocation(primaryRouting)) {
     * This ReplicasProxy is used for performing primary term validation.
        super(replicasProxy);
                return ReplicationMode.FULL_REPLICATION;  
    private final ReplicationMode replicationModeOverride;
 */
        /*
    }
        BiConsumer<Consumer<ActionListener<ReplicaResponse>>, ReplicationProxyRequest<ReplicaRequest>> performOnReplicaConsumer  
                // Perform full replication if the replica does not have a remote translog.
    }
    private final boolean isRemoteEnabled;
        }  
    protected void performOnReplicaProxy(  
        }
            replicasProxyConsumer = getReplicasProxyConsumer(primaryTermValidationProxy, proxyRequest);
        ReplicationProxyRequest<ReplicaRequest> proxyRequest,
        boolean remoteIndexSettingsEnabled
        store; otherwise the operations would never reach it.  
import org.opensearch.core.action.ActionListener;
        // If the current routing is the primary, then it does not need to be replicated  
    private final ReplicationOperation.Replicas<ReplicaRequest> primaryTermValidationProxy;  
