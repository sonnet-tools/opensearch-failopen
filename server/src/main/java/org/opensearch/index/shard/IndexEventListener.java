     * @param reason       the reason for index removal
     * @param currentState the new shard state
     * @param indexShard    the shard that is about to recover
     *
 * compatible open source license.
 *
     *
    /**
     * @param indexSettings the shards index settings
public interface IndexEventListener {
     * @param indexShard The index shard
     * @param shardId the shard ID the store belongs to
    ) {}
     */
    default void onStoreClosed(ShardId shardId) {}
     * @param indexShard The index shard
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
     */
 * lifecycle as the {@link IndexService} they are created for.
import org.opensearch.index.IndexSettings;
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
     * @param indexSettings the shard's index settings
     */
/**
     * Called before the index gets created. Note that this is also called
     */
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
     * @param shardId The shard id
import org.opensearch.common.Nullable;
     * @param previousState the previous index shard state if there was one, null otherwise
 * modify local state without sufficient synchronization.
    default void beforeIndexShardCreated(ShardId shardId, Settings indexSettings) {}
}
 * </p>
     *
     */
        IndexShardState currentState,
     * @param indexShard the shard the new state was applied to
     * Note: this method is only executed on the first attempt of deleting the shard. Retries are will not invoke
    default void beforeIndexShardDeleted(ShardId shardId, Settings indexSettings) {}
     * @param shardId the shard ID the store belongs to
    default void beforeIndexAddedToCluster(Index index, Settings indexSettings) {}
     */
     * This happens right before the index and it's metadata is registered in the cluster state
     * Called when the shard routing has changed state.
/*
        IndexShard indexShard,
     * @param index The index
    default void afterIndexShardStarted(IndexShard indexShard) {}
    /**
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;
 * local state via their arguments. Yet, if an instance is shared across indices they might be called concurrently and should not
 * software distributed under the License is distributed on an
     * Called when the given shards store is created. The shard store is created before the shard is created.
     * Called before the index get closed.
 */
     *
 * to react / listen to per-index and per-shard events. These listeners are registered per-index
     * Called after the index shard has been deleted from disk.
    default void afterIndexShardDeleted(ShardId shardId, Settings indexSettings) {}
    default void afterIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {}
import org.opensearch.core.index.shard.ShardId;
    /**
    default void onStoreCreated(ShardId shardId) {}
     * Called before the index shard gets created.
 * license agreements. See the NOTICE file distributed with
     * @param indexSettings the shards index settings
     *
 * SPDX-License-Identifier: Apache-2.0
     */
     * called the shard already transitioned to the RECOVERING state.
     */
 */
    /**
    /**
 * not use this file except in compliance with the License.
    default void beforeIndexCreated(Index index, Settings indexSettings) {
package org.opensearch.index.shard;
 */
    default void shardRoutingChanged(IndexShard indexShard, @Nullable ShardRouting oldRouting, ShardRouting newRouting) {}
    /**
    }
     * The order of concurrent events is preserved. The execution must be lightweight.
import org.opensearch.core.index.Index;
     * Called before the index shard gets deleted from disk
    /**
     * Called after the index has been removed.
     *
     * Called after the index shard has been closed.
    default void beforeIndexShardRecovery(IndexShard indexShard, IndexSettings indexSettings) {}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param indexService The index service
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
 * An index event listener is the primary extension point for plugins and build-in services
        @Nullable IndexShardState previousState,
 * via {@link org.opensearch.index.IndexModule#addIndexEventListener(IndexEventListener)}. All listeners have the same
        @Nullable String reason
     * Called before the index shard starts to recover.
     */
 * this work for additional information regarding copyright
    /**
    /**
     * @param reason the reason for the state change if there is one, null otherwise
/*
     */
     * @param shardId The shard id
    }
    default void afterIndexShardCreated(IndexShard indexShard) {}
     * <p>
     *
     * This implies that all index readers are closed and no recoveries are running.
    }
 * @opensearch.api
    default void beforeIndexRemoved(IndexService indexService, IndexRemovalReason reason) {
     *
     */
     */
     * Note: this method is only called if the deletion of the shard did finish without an exception
    default void afterIndexCreated(IndexService indexService) {
     */
 * Licensed to Elasticsearch under one or more contributor
    default void afterIndexRemoved(Index index, IndexSettings indexSettings, IndexRemovalReason reason) {
     *
    /**
     * Note: unlike all other methods in this class, this method is not called using the cluster state update thread. When this method is
    }
    /**
 * The OpenSearch Contributors require contributions made to
    /**
import org.opensearch.index.IndexService;
 * An IndexEventListener can be used across multiple indices and shards since all callback methods receive sufficient
     * @param oldRouting The old routing state (can be null)
/*
     * Called when the given shards store is closed. The store is closed once all resource have been released on the store.
     */
     * Called after the index shard has been created.
     */
    default void indexShardStateChanged(
     * Called after the index has been created.
 * Unless required by applicable law or agreed to in writing,
     * @param shardId The shard id
     * @param newRouting The new routing state
     * Called after the index shard has been started.
 *
     */
 */
    /**
    /**
     */
     * Called on the cluster-manager node only before the {@link IndexService} instances is created to simulate an index creation.
 *
 * under the License.
     * this method.
     *
 * ownership. Elasticsearch licenses this file to you under
    /**
 * You may obtain a copy of the License at
    /**
 * Modifications Copyright OpenSearch Contributors. See
     * @param reason       the reason for index removal
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
     * Called after a shard's {@link org.opensearch.index.shard.IndexShardState} changes.
    default void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {}
     * when the index is created on data nodes
 * <p>
 *
import org.opensearch.cluster.routing.ShardRouting;
     * Called before the index shard gets closed.
