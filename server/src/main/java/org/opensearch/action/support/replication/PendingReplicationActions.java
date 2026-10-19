        }
                        "Replica unavailable - replica could have left ReplicationGroup or IndexShard might have closed"
    // Visible for testing
import org.opensearch.common.annotation.PublicApi;
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
        cancelActions(toCancel, () -> new IndexShardClosedException(shardId, "Replica left ReplicationGroup"));
        cancelActions(toCancel, () -> new PrimaryShardClosedException(shardId));  
 */
                if (isNewerVersion(replicationGroup)) {  
 *  
 * compatible open source license.
        onGoingReplicationActions.clear();
import java.util.Map;
            .execute(() -> toCancel.stream().flatMap(Collection::stream).forEach(action -> action.cancel(exceptionSupplier.get())));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public synchronized void close() {
        Set<RetryableAction<?>> ongoingActionsOnNode = onGoingReplicationActions.get(allocationId);
import java.util.function.Consumer;  
    private final ShardId shardId;  
            }
    private final Map<String, Set<RetryableAction<?>>> onGoingReplicationActions = ConcurrentCollections.newConcurrentMap();
        // Relative comparison to mitigate long overflow  
        if (ongoingActionsOnNode != null) {
    private void cancelActions(ArrayList<Set<RetryableAction<?>>> toCancel, Supplier<IndexShardClosedException> exceptionSupplier) {  
            );  
        }
    public void addPendingAction(String allocationId, RetryableAction<?> replicationAction) {  
                    acceptNewTrackedAllocationIds(replicationGroup.getTrackedAllocationIds());
 *
        for (String targetAllocationId : trackedAllocationIds) {  
 * Pending Replication Actions
        this.threadPool = threadPool;  
            ongoingActionsOnNode.add(replicationAction);  
 * KIND, either express or implied.  See the License for the
/*  
import org.opensearch.index.shard.IndexShardClosedException;  
import org.opensearch.threadpool.ThreadPool;  
import java.util.Set;
    }
    private volatile long replicationGroupVersion = -1;
/*
 * You may obtain a copy of the License at  
/**  
package org.opensearch.action.support.replication;
                toCancel.add(onGoingReplicationActions.remove(allocationId));  
    synchronized void acceptNewTrackedAllocationIds(Set<String> trackedAllocationIds) {
                    new IndexShardClosedException(  
            onGoingReplicationActions.putIfAbsent(targetAllocationId, ConcurrentCollections.newConcurrentSet());
                replicationAction.cancel(
 *
 * Unless required by applicable law or agreed to in writing,
    }  
    public void removeReplicationAction(String allocationId, RetryableAction<?> action) {
                new IndexShardClosedException(
            if (onGoingReplicationActions.containsKey(allocationId) == false) {
 * software distributed under the License is distributed on an
    }
            replicationAction.cancel(
            synchronized (this) {
    @Override
    }  
                )
        ArrayList<Set<RetryableAction<?>>> toCancel = new ArrayList<>();  
public class PendingReplicationActions implements Consumer<ReplicationGroup>, Releasable {  
import org.opensearch.action.support.RetryableAction;
        Set<RetryableAction<?>> ongoingActionsOnNode = onGoingReplicationActions.get(allocationId);
import org.opensearch.core.index.shard.ShardId;
    @Override
            if (trackedAllocationIds.contains(allocationId) == false) {
@PublicApi(since = "1.0.0")
 * @opensearch.api  
        ArrayList<Set<RetryableAction<?>>> toCancel = new ArrayList<>(onGoingReplicationActions.values());  
 * not use this file except in compliance with the License.
                    shardId,  
                    replicationGroupVersion = replicationGroup.getVersion();
                        shardId,
        } else {  
import java.util.function.Supplier;
}
                );
 *     http://www.apache.org/licenses/LICENSE-2.0
    private boolean isNewerVersion(ReplicationGroup replicationGroup) {
import org.opensearch.index.shard.PrimaryShardClosedException;
 */
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
                    "Replica unavailable - replica could have left ReplicationGroup or IndexShard might have closed"
import org.opensearch.common.lease.Releasable;  
 *
import java.util.ArrayList;
        if (ongoingActionsOnNode != null) {  
    }  
 * this work for additional information regarding copyright
        this.shardId = shardId;
    }
import org.opensearch.index.shard.ReplicationGroup;
        }
    public void accept(ReplicationGroup replicationGroup) {  
 * ownership. Elasticsearch licenses this file to you under  
 */  
        }
                }  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    }
            }
                    )  
            }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.util.concurrent.ConcurrentCollections;
 * specific language governing permissions and limitations
        }
 * Licensed to Elasticsearch under one or more contributor  
            ongoingActionsOnNode.remove(action);
 * GitHub history for details.
import java.util.Collection;  
    public PendingReplicationActions(ShardId shardId, ThreadPool threadPool) {
    }
        threadPool.executor(ThreadPool.Names.GENERIC)
 */  
/*  
        if (isNewerVersion(replicationGroup)) {
    private final ThreadPool threadPool;
        return replicationGroup.getVersion() - replicationGroupVersion > 0;
        for (String allocationId : onGoingReplicationActions.keySet()) {
