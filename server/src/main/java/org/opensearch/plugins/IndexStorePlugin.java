    default Map<String, RecoveryStateFactory> getRecoveryStateFactories() {
            Directory directory,
     * built-in type, or looked up among all the composite directory factories from {@link IndexStorePlugin} plugins.
            IndexSettings indexSettings,
     * The {@link IndexStoreListener}s for this plugin which are triggered upon shard/index path deletion
     */
         * @param indexSettings the shard's index settings
import org.opensearch.index.IndexSettings;
     */
         * @param shardLock the shard lock to associate with the store
import org.opensearch.indices.recovery.RecoveryState;
        /**
        Store newStore(
         * Creates a new composite directory per shard
         * Creates a new Store per shard. This method is called once per shard on shard creation.
    }
        /**
 * compatible open source license.
}
    interface DirectoryFactory {
 * Modifications Copyright OpenSearch Contributors. See
    interface RecoveryStateFactory {
            ThreadPool threadPool
 * SPDX-License-Identifier: Apache-2.0
    default Map<String, CompositeDirectoryFactory> getCompositeDirectoryFactories() {
         * Creates a new {@link RecoveryState} per shard. This method is called once per shard on shard creation.
        /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            ShardPath shardPath
     * @opensearch.api
         * @param indexSettings the shards index settings
     */
        /**
        Directory newDirectory(
         * @param onClose listener invoked on store close
import org.opensearch.common.annotation.PublicApi;
     */
 */
     */
    /**
 * GitHub history for details.
        RecoveryState newRecoveryState(ShardRouting shardRouting, DiscoveryNode targetNode, @Nullable DiscoveryNode sourceNode);
         */
    /**
            IndexSettings indexSettings,
 * Licensed to Elasticsearch under one or more contributor
            DirectoryFactory directoryFactory
 *    http://www.apache.org/licenses/LICENSE-2.0
         * @return a new Store instance
            ShardLock shardLock,
     * or looked up among all the recovery state factories from {@link IndexStorePlugin} plugins.
    }
/*
    @PublicApi(since = "1.0.0")
         * @param shardPath the path the shard is using
/**
         */
     * {@link org.opensearch.index.IndexModule#INDEX_COMPOSITE_STORE_TYPE_SETTING} on the index will be examined and either use the default or a
         * Creates a new Store per shard. This method is called once per shard on shard creation.
 * this work for additional information regarding copyright
    default Map<String, StoreFactory> getStoreFactories() {
         * @param directoryFactory the directory path.
     * @opensearch.api
    }
         */
import org.apache.lucene.store.Directory;
 */
     * @return a map from composite store type to a composite directory factory
    }
         * @param shardLock the shard lock to associate with the store
 *
     *
 */
    @FunctionalInterface
         * @param directory the Lucene directory selected for this shard
            ShardId shardId,
        return Collections.emptyMap();
            ShardLock shardLock,
    }
     * {@link org.opensearch.index.IndexModule#INDEX_RECOVERY_TYPE_SETTING} on the index will be examined and either use the default
import org.opensearch.cluster.node.DiscoveryNode;
     * {@code index.store.factory}. If not set, the default store is used.
         * @return a new lucene directory instance
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.shard.ShardId;
    /**
    }
     *
     * The {@link StoreFactory} mappings for this plugin. When an index is created a custom store factory can be selected via
    @ExperimentalApi
     *
         * @return a new Store instance
        return Collections.emptyMap();
    /**
     *
    @ExperimentalApi
     */
 * under the License.
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.shard.ShardPath;
     * @opensearch.api
 *
        Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException;
     * @opensearch.api
         * @param onClose listener invoked on store close
     *
         * @param shardPath the shard path
         * @return a new RecoveryState instance
import java.util.Collections;
        ) throws IOException;
            ShardPath shardPath,
import org.apache.lucene.store.LockFactory;
     * The {@link DirectoryFactory} mappings for this plugin. When an index is created the store type setting
     * An interface that describes how to create a new composite directory instance per shard.
import org.opensearch.index.store.Store;
     *
         * Creates a new directory per shard. This method is called once per shard on shard creation.
            ShardPath shardPath,
 * this file be licensed under the Apache-2.0 license or a
     *
import org.opensearch.env.ShardLock;
         * @param directory the Lucene directory selected for this shard
            ShardId shardId,
 * specific language governing permissions and limitations
import org.opensearch.index.store.remote.filecache.FileCache;
         * @throws IOException if an IOException occurs while opening the directory
import org.opensearch.common.Nullable;
 *
        ) throws IOException;
public interface IndexStorePlugin {
     * @return a map from store type key to a store factory
    interface StoreFactory {
    /**
        return Collections.emptyMap();
            Directory directory,
     * built-in type, or looked up among all the directory factories from {@link IndexStorePlugin} plugins.
package org.opensearch.plugins;
     *
import org.opensearch.index.store.IndexStoreListener;
         */
    /**
    /**
import java.util.Optional;
import org.opensearch.threadpool.ThreadPool;
         * @param shardPath the shard path
 */
         * @throws IOException if an IOException occurs while opening the directory
import java.util.Map;
            IndexSettings indexSettings,
import org.opensearch.common.annotation.ExperimentalApi;
         * @param indexSettings the shard's index settings
        Directory newDirectory(IndexSettings indexSettings, ShardPath shardPath) throws IOException;
    }
 * ownership. Elasticsearch licenses this file to you under
     * An interface that allows to create a new {@link RecoveryState} per shard.
    default Map<String, DirectoryFactory> getDirectoryFactories() {
@PublicApi(since = "1.0.0")
        ) throws IOException;
 *
    /**
    @PublicApi(since = "1.0.0")
 * Unless required by applicable law or agreed to in writing,
     * The {@link CompositeDirectoryFactory} mappings for this plugin. When an index is created the composite store type setting
 * You may obtain a copy of the License at
     */
            DirectoryFactory localDirectoryFactory,
         */
import java.io.IOException;
     */
         * @param shardId the shard id
        Store newStore(
/*
         * @param shardId the shard id
    @ExperimentalApi
 * @opensearch.api
         * @param shardPath the path the shard is using
         * @return a new composite directory instance
    @FunctionalInterface
    }
            FileCache fileCache,
 * license agreements. See the NOTICE file distributed with
            Store.OnClose onClose,
            Directory remoteDirectory,
        return Collections.emptyMap();
     * @return a map from recovery type to an recovery state factory
/*
         * @param indexSettings the shards index settings
import java.nio.file.Path;
     * The {@link RecoveryStateFactory} mappings for this plugin. When an index is created the recovery type setting
    /**
    interface CompositeDirectoryFactory {
     * {@link org.opensearch.index.IndexModule#INDEX_STORE_TYPE_SETTING} on the index will be examined and either use the default or a
     * An interface that describes how to create a new Store instance per shard.
import org.opensearch.cluster.routing.ShardRouting;
        return Optional.empty();
 * software distributed under the License is distributed on an
            Store.OnClose onClose,
 * The OpenSearch Contributors require contributions made to
     */
    default Optional<IndexStoreListener> getIndexStoreListener() {
        /**
 * A plugin that provides alternative directory implementations.
    }
     * @return a map from store type to an directory factory
     * An interface that describes how to create a new directory instance per shard.
