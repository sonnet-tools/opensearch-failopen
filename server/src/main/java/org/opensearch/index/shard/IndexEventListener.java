 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    default void beforeIndexShardDeleted(ShardId shardId, Settings indexSettings) {}
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
     */
     * when the index is created on data nodes
    /**  
    /**
     * Note: this method is only called if the deletion of the shard did finish without an exception
    default void afterIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {}  
     * this method.
    default void indexShardStateChanged(
import org.opensearch.common.settings.Settings;  
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;
     * Called before the index shard gets deleted from disk
    default void afterIndexRemoved(Index index, IndexSettings indexSettings, IndexRemovalReason reason) {
     * @param indexShard The index shard  
     * @param shardId The shard id  
    /**
     */  
     *
import org.opensearch.index.IndexService;  
     * Note: unlike all other methods in this class, this method is not called using the cluster state update thread. When this method is
 * @opensearch.api  
    /**
     */
    }
     * @param shardId the shard ID the store belongs to
 * local state via their arguments. Yet, if an instance is shared across indices they might be called concurrently and should not
     */  
     * This happens right before the index and it's metadata is registered in the cluster state
    default void beforeIndexShardRecovery(IndexShard indexShard, IndexSettings indexSettings) {}
     * @param currentState the new shard state
    default void beforeIndexCreated(Index index, Settings indexSettings) {
     */
 * under the License.  
 * compatible open source license.
    default void onStoreClosed(ShardId shardId) {}  
     * <p>  
     *  
     * @param indexService The index service  
    /**  
     *  
 */
     * @param indexSettings the shards index settings
import org.opensearch.core.index.Index;
 */
     *
     * @param shardId the shard ID the store belongs to
     * Called when the shard routing has changed state.  
    /**
     * Called before the index get closed.
     * called the shard already transitioned to the RECOVERING state.
    }  
     *
    }  
     * Note: this method is only executed on the first attempt of deleting the shard. Retries are will not invoke  
 * Unless required by applicable law or agreed to in writing,
 * <p>  
import org.opensearch.cluster.routing.ShardRouting;  
     * @param shardId The shard id
        IndexShard indexShard,  
     * Called after a shard's {@link org.opensearch.index.shard.IndexShardState} changes.  
     * @param indexShard the shard the new state was applied to  
        @Nullable String reason  
    /**
/*
     *  
     * Called before the index shard starts to recover.  
 *
/*
    default void afterIndexShardStarted(IndexShard indexShard) {}
    /**
     * @param indexSettings the shards index settings  
     * @param shardId The shard id
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * modify local state without sufficient synchronization.  
 */  
     */
 * KIND, either express or implied.  See the License for the
     * @param oldRouting The old routing state (can be null)  
     * Called after the index shard has been closed.
    default void afterIndexCreated(IndexService indexService) {
     * @param reason       the reason for index removal
     * @param indexSettings the shard's index settings
     * @param previousState the previous index shard state if there was one, null otherwise
     */
 * Modifications Copyright OpenSearch Contributors. See  
    default void beforeIndexRemoved(IndexService indexService, IndexRemovalReason reason) {  
    default void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {}
     * Called after the index shard has been created.  
 * The OpenSearch Contributors require contributions made to  
    default void beforeIndexAddedToCluster(Index index, Settings indexSettings) {}  
     * @param indexShard The index shard
     * Called after the index has been removed.
     * Called after the index shard has been started.
 * this file be licensed under the Apache-2.0 license or a
    default void beforeIndexShardCreated(ShardId shardId, Settings indexSettings) {}
    /**
/*  
 * SPDX-License-Identifier: Apache-2.0
    default void onStoreCreated(ShardId shardId) {}
     */  
     *  
 *
import org.opensearch.common.annotation.PublicApi;
     * Called when the given shards store is closed. The store is closed once all resource have been released on the store.
 * An index event listener is the primary extension point for plugins and build-in services
 * this work for additional information regarding copyright
     */
     *
     * Called after the index shard has been deleted from disk.
 * not use this file except in compliance with the License.
package org.opensearch.index.shard;
    /**
    /**
 * software distributed under the License is distributed on an
     */
 * license agreements. See the NOTICE file distributed with
    }
     */
 * </p>
public interface IndexEventListener {  
     * @param indexShard    the shard that is about to recover
     * The order of concurrent events is preserved. The execution must be lightweight.
    /**  
     * Called after the index has been created.  
    default void shardRoutingChanged(IndexShard indexShard, @Nullable ShardRouting oldRouting, ShardRouting newRouting) {}  
/**
     * @param reason the reason for the state change if there is one, null otherwise  
 * lifecycle as the {@link IndexService} they are created for.
     * Called before the index shard gets closed.
    /**
    /**  
        IndexShardState currentState,
     * Called before the index gets created. Note that this is also called
 * An IndexEventListener can be used across multiple indices and shards since all callback methods receive sufficient
     */
import org.opensearch.index.IndexSettings;
    /**
     */  
}
 * via {@link org.opensearch.index.IndexModule#addIndexEventListener(IndexEventListener)}. All listeners have the same
     */
 *
 * to react / listen to per-index and per-shard events. These listeners are registered per-index  
    default void afterIndexShardDeleted(ShardId shardId, Settings indexSettings) {}  
     *
import org.opensearch.core.index.shard.ShardId;
     * @param newRouting The new routing state
    /**
 * Licensed to Elasticsearch under one or more contributor  
     * @param index The index
    ) {}
    default void afterIndexShardCreated(IndexShard indexShard) {}
import org.opensearch.common.Nullable;
@PublicApi(since = "1.0.0")
     * This implies that all index readers are closed and no recoveries are running.
 * ownership. Elasticsearch licenses this file to you under  
     *
     */
    /**
        @Nullable IndexShardState previousState,
     */  
     * Called before the index shard gets created.  
 * You may obtain a copy of the License at  
     * Called when the given shards store is created. The shard store is created before the shard is created.  
 * GitHub history for details.
     * Called on the cluster-manager node only before the {@link IndexService} instances is created to simulate an index creation.  
     * @param reason       the reason for index removal
