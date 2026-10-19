    private final ShardRouting shardRouting;
package org.opensearch.indices.recovery;
 * this file be licensed under the Apache-2.0 license or a
}
    }
    @Override
    public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
/*  
public class RecoveryListener implements ReplicationListener {
    private final long primaryTerm;  
    /**  
import org.opensearch.indices.replication.common.ReplicationFailedException;
import org.opensearch.cluster.routing.ShardRouting;
     * Primary term with which the shard was created
        indicesClusterStateService.handleRecoveryDone(state, shardRouting, primaryTerm);
    @Override
        IndicesClusterStateService indicesClusterStateService
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
     */
 *
        this.indicesClusterStateService = indicesClusterStateService;
        this.shardRouting = shardRouting;  
import org.opensearch.indices.cluster.IndicesClusterStateService;  
    }  
 * The OpenSearch Contributors require contributions made to  
        final ShardRouting shardRouting,
    private final IndicesClusterStateService indicesClusterStateService;
     * ShardRouting with which the shard was created
 * compatible open source license.
    /**
import org.opensearch.indices.replication.common.ReplicationState;  
/**
 * Listener that runs on changes in Recovery state  
        final long primaryTerm,  
import org.opensearch.indices.replication.common.ReplicationListener;
    public void onDone(ReplicationState state) {  
@PublicApi(since = "2.2.0")
 * @opensearch.internal
 */  
     */  
    public RecoveryListener(
        this.primaryTerm = primaryTerm;
        indicesClusterStateService.handleRecoveryFailure(shardRouting, sendShardFailure, e);  
    }
    ) {
import org.opensearch.common.annotation.PublicApi;
