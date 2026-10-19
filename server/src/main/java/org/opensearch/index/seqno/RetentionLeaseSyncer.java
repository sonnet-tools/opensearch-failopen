    /**
     * or removed on the primary. The specified listener is invoked when the syncing completes with success or failure.
 * compatible open source license.
        RetentionLeases retentionLeases,
 * Syncs retention leases
    }  
@PublicApi(since = "1.0.0")
    public RetentionLeaseSyncer(RetentionLeaseSyncAction syncAction, RetentionLeaseBackgroundSyncAction backgroundSyncAction) {
        long primaryTerm,
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
     *
     *  
        syncAction.sync(shardId, primaryAllocationId, primaryTerm, retentionLeases, listener);
    public void sync(
 * GitHub history for details.
     */  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 *  
import java.util.Objects;
 * specific language governing permissions and limitations
package org.opensearch.index.seqno;
        this.syncAction = Objects.requireNonNull(syncAction);
    private final SyncAction syncAction;
    }
     * @opensearch.internal
     * @opensearch.internal
public class RetentionLeaseSyncer {  
 * under the License.  
    private final BackgroundSyncAction backgroundSyncAction;
        this.backgroundSyncAction = Objects.requireNonNull(backgroundSyncAction);
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.common.annotation.PublicApi;
 */  
        String primaryAllocationId,  
 *
    );
 * KIND, either express or implied.  See the License for the
    }  
        ActionListener<ReplicationResponse> listener  
    }  
            ShardId shardId,
            RetentionLeases retentionLeases,
 */  
        (shardId, primaryAllocationId, primaryTerm, retentionLeases, listener) -> listener.onResponse(new ReplicationResponse()),  
    public interface BackgroundSyncAction {
        ShardId shardId,
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.support.replication.ReplicationResponse;
/**  
/*
     * Represents an action that is invoked to sync retention leases to replica shards after a retention lease is added
    ) {
import org.opensearch.core.action.ActionListener;
 *
        backgroundSyncAction.backgroundSync(shardId, primaryAllocationId, primaryTerm, retentionLeases);  
            String primaryAllocationId,  
    }
 * this file be licensed under the Apache-2.0 license or a
            ActionListener<ReplicationResponse> listener  
        );
        void sync(
        void backgroundSync(ShardId shardId, String primaryAllocationId, long primaryTerm, RetentionLeases retentionLeases);
 * You may obtain a copy of the License at  
/*  
 */
    /**  
        this(syncAction::sync, backgroundSyncAction::backgroundSync);  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void backgroundSync(ShardId shardId, String primaryAllocationId, long primaryTerm, RetentionLeases retentionLeases) {
}
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
     */
    public interface SyncAction {  
    @Inject
     * Represents an action that is invoked periodically to sync retention leases to replica shards after some retention
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public RetentionLeaseSyncer(SyncAction syncAction, BackgroundSyncAction backgroundSyncAction) {  
 */
 * license agreements. See the NOTICE file distributed with
            long primaryTerm,
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.common.inject.Inject;  
     * lease has been renewed or expired.  
 * Licensed to Elasticsearch under one or more contributor  
    public static final RetentionLeaseSyncer EMPTY = new RetentionLeaseSyncer(
/*  
        (shardId, primaryAllocationId, primaryTerm, retentionLeases) -> {}
