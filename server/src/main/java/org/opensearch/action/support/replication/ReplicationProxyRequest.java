            this.globalCheckpoint = globalCheckpoint;
    public ReplicaRequest getReplicaRequest() {
            this.replicaRequest = replicaRequest;
        return replicaRequest;
            ShardRouting shardRouting,
    }
 * compatible open source license.
    private final ShardRouting shardRouting;  
        long maxSeqNoOfUpdatesOrDeletes,  
        private final ShardRouting primaryRouting;
        long primaryTerm  
                primaryTerm
            this.primaryRouting = primaryRouting;
        this.primaryTerm = primaryTerm;
    }  
     * @opensearch.internal  
                globalCheckpoint,
        private final ReplicaRequest replicaRequest;  
        this.replicaRequest = Objects.requireNonNull(replicaRequest);
    private final ShardRouting primaryRouting;
    }
            this.pendingReplicationActions = pendingReplicationActions;
                primaryRouting,  
    }  
    /**  
    public long getGlobalCheckpoint() {
    }
import java.util.Objects;  
        PendingReplicationActions pendingReplicationActions,
        return globalCheckpoint;
    ) {
        ShardRouting shardRouting,  
            PendingReplicationActions pendingReplicationActions,
                replicaRequest,
            return new ReplicationProxyRequest<>(
                maxSeqNoOfUpdatesOrDeletes,
    private final PendingReplicationActions pendingReplicationActions;
    }  
            long maxSeqNoOfUpdatesOrDeletes,
            ReplicaRequest replicaRequest,  
                pendingReplicationActions,  
    public PendingReplicationActions getPendingReplicationActions() {  
            this.maxSeqNoOfUpdatesOrDeletes = maxSeqNoOfUpdatesOrDeletes;  
        return maxSeqNoOfUpdatesOrDeletes;  
        private final long globalCheckpoint;  
            this.primaryTerm = primaryTerm;  
 * The OpenSearch Contributors require contributions made to  
    }
}
        return primaryTerm;  
 */  
 * @opensearch.internal
 * This is proxy wrapper over the replication request whose object can be created using the Builder present inside.  
        ShardRouting primaryRouting,
        public ReplicationProxyRequest<ReplicaRequest> build() {  
    public long getMaxSeqNoOfUpdatesOrDeletes() {
/**
    private final long primaryTerm;  
        }
    public ShardRouting getShardRouting() {
    private final ReplicaRequest replicaRequest;
            long globalCheckpoint,  
        this.maxSeqNoOfUpdatesOrDeletes = maxSeqNoOfUpdatesOrDeletes;
            this.shardRouting = shardRouting;  
    private final long maxSeqNoOfUpdatesOrDeletes;  
 * SPDX-License-Identifier: Apache-2.0
        return shardRouting;  
    public static class Builder<ReplicaRequest> {
        ) {
        private final long primaryTerm;
import org.opensearch.cluster.routing.ShardRouting;
            );  
     */
 *
        }
        return primaryRouting;
 */  
public class ReplicationProxyRequest<ReplicaRequest> {
        this.globalCheckpoint = globalCheckpoint;
     * Builder of ReplicationProxyRequest.
        return pendingReplicationActions;
    private ReplicationProxyRequest(
    public long getPrimaryTerm() {
        this.pendingReplicationActions = Objects.requireNonNull(pendingReplicationActions);  
            long primaryTerm
    }
        this.shardRouting = Objects.requireNonNull(shardRouting);
        this.primaryRouting = Objects.requireNonNull(primaryRouting);  
            ShardRouting primaryRouting,
        ReplicaRequest replicaRequest,
    public ShardRouting getPrimaryRouting() {  
    }  
                shardRouting,
        public Builder(  
        private final long maxSeqNoOfUpdatesOrDeletes;
     *
 *
 * this file be licensed under the Apache-2.0 license or a
/*  
        private final PendingReplicationActions pendingReplicationActions;
    private final long globalCheckpoint;
package org.opensearch.action.support.replication;
        long globalCheckpoint,
        private final ShardRouting shardRouting;
