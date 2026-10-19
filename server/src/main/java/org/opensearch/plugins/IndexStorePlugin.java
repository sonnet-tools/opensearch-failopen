     *
         * @throws IOException if an IOException occurs while opening the directory
         */
     * built-in type, or looked up among all the directory factories from {@link IndexStorePlugin} plugins.  
import java.util.Map;  
        Store newStore(  
         * @param shardPath the shard path
import java.io.IOException;  
         * Creates a new Store per shard. This method is called once per shard on shard creation.
 */
        return Collections.emptyMap();
         * @throws IOException if an IOException occurs while opening the directory  
        ) throws IOException;
         */  
     * The {@link DirectoryFactory} mappings for this plugin. When an index is created the store type setting
    /**
import org.opensearch.index.store.remote.filecache.FileCache;
     *
        ) throws IOException;  
     *
         */  
     * {@code index.store.factory}. If not set, the default store is used.
     */
     */  
    @ExperimentalApi
        return Optional.empty();
            Directory directory,  
 * this file be licensed under the Apache-2.0 license or a
         * @param directoryFactory the directory path.  
import org.opensearch.index.shard.ShardPath;
            Store.OnClose onClose,
    }
import org.opensearch.cluster.routing.ShardRouting;
            ShardId shardId,
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.node.DiscoveryNode;  
    @FunctionalInterface
     * @opensearch.api
        /**
            ShardLock shardLock,
     * @opensearch.api
import org.opensearch.core.index.shard.ShardId;
            DirectoryFactory directoryFactory
     * or looked up among all the recovery state factories from {@link IndexStorePlugin} plugins.
import java.util.Collections;
    /**
 *  
@PublicApi(since = "1.0.0")
 * not use this file except in compliance with the License.
     * The {@link IndexStoreListener}s for this plugin which are triggered upon shard/index path deletion
            ShardLock shardLock,
     * An interface that describes how to create a new composite directory instance per shard.  
         * Creates a new Store per shard. This method is called once per shard on shard creation.
    interface CompositeDirectoryFactory {  
 *
     */  
 * KIND, either express or implied.  See the License for the
         * @return a new lucene directory instance
     *  
     * @opensearch.api
/*  
/**  
    default Map<String, StoreFactory> getStoreFactories() {  
     */  
import org.apache.lucene.store.Directory;
     * @return a map from composite store type to a composite directory factory
         * @return a new Store instance
 * under the License.  
    /**
         */
        Directory newDirectory(
 * GitHub history for details.
 * compatible open source license.
 * software distributed under the License is distributed on an
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            ShardPath shardPath,  
     *
         * @param shardPath the path the shard is using  
     * An interface that allows to create a new {@link RecoveryState} per shard.  
         * Creates a new directory per shard. This method is called once per shard on shard creation.
    default Map<String, RecoveryStateFactory> getRecoveryStateFactories() {  
import org.opensearch.indices.recovery.RecoveryState;  
            DirectoryFactory localDirectoryFactory,
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Store newStore(
         * @param directory the Lucene directory selected for this shard
     * @return a map from store type to an directory factory
     * The {@link CompositeDirectoryFactory} mappings for this plugin. When an index is created the composite store type setting
            IndexSettings indexSettings,  
    /**
    interface StoreFactory {
            IndexSettings indexSettings,
        ) throws IOException;
     */  
}  
     * built-in type, or looked up among all the composite directory factories from {@link IndexStorePlugin} plugins.  
     *
import org.opensearch.index.IndexSettings;
 * @opensearch.api  
            ThreadPool threadPool
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
     * {@link org.opensearch.index.IndexModule#INDEX_RECOVERY_TYPE_SETTING} on the index will be examined and either use the default
            Directory remoteDirectory,  
     */  
import org.opensearch.common.annotation.PublicApi;
         */
            Directory directory,
import org.opensearch.common.annotation.ExperimentalApi;  
        Directory newFSDirectory(Path location, LockFactory lockFactory, IndexSettings indexSettings) throws IOException;  
import org.opensearch.common.Nullable;
    @PublicApi(since = "1.0.0")
        return Collections.emptyMap();
        /**  
         * @param directory the Lucene directory selected for this shard
     */
         * @param indexSettings the shard's index settings  
         * @param indexSettings the shard's index settings
import org.opensearch.env.ShardLock;  
     * {@link org.opensearch.index.IndexModule#INDEX_STORE_TYPE_SETTING} on the index will be examined and either use the default or a
    @ExperimentalApi
import org.opensearch.index.store.Store;
package org.opensearch.plugins;
         * @param indexSettings the shards index settings  
    default Map<String, DirectoryFactory> getDirectoryFactories() {
 * Licensed to Elasticsearch under one or more contributor  
     *
         * @param onClose listener invoked on store close  
    }
            IndexSettings indexSettings,  
        /**
         * @return a new RecoveryState instance  
     * An interface that describes how to create a new directory instance per shard.  
    interface DirectoryFactory {
         * Creates a new {@link RecoveryState} per shard. This method is called once per shard on shard creation.
     */  
    default Optional<IndexStoreListener> getIndexStoreListener() {
        return Collections.emptyMap();
/*  
    }  
 * Unless required by applicable law or agreed to in writing,
     *
import org.opensearch.threadpool.ThreadPool;
 * specific language governing permissions and limitations
    }  
    }  
         * @return a new composite directory instance
 * SPDX-License-Identifier: Apache-2.0
import java.util.Optional;
        /**
    @ExperimentalApi
     * An interface that describes how to create a new Store instance per shard.  
 * You may obtain a copy of the License at  
    }
            FileCache fileCache,
         * @return a new Store instance
         * @param onClose listener invoked on store close
 *
     * @return a map from store type key to a store factory  
    interface RecoveryStateFactory {  
    @PublicApi(since = "1.0.0")
        return Collections.emptyMap();
     * @opensearch.api
    /**
import org.apache.lucene.store.LockFactory;
     * The {@link StoreFactory} mappings for this plugin. When an index is created a custom store factory can be selected via  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.store.IndexStoreListener;  
            ShardPath shardPath,
            Store.OnClose onClose,  
     * {@link org.opensearch.index.IndexModule#INDEX_COMPOSITE_STORE_TYPE_SETTING} on the index will be examined and either use the default or a
    default Map<String, CompositeDirectoryFactory> getCompositeDirectoryFactories() {
         * Creates a new composite directory per shard
 */
     */  
    /**  
         * @param shardId the shard id
 *
public interface IndexStorePlugin {  
 * A plugin that provides alternative directory implementations.
     * The {@link RecoveryStateFactory} mappings for this plugin. When an index is created the recovery type setting  
    /**
        /**  
            ShardId shardId,
/*
         * @param shardId the shard id  
    /**  
    /**
 * Modifications Copyright OpenSearch Contributors. See
         * @param indexSettings the shards index settings
        RecoveryState newRecoveryState(ShardRouting shardRouting, DiscoveryNode targetNode, @Nullable DiscoveryNode sourceNode);
         * @param shardLock the shard lock to associate with the store  
        Directory newDirectory(IndexSettings indexSettings, ShardPath shardPath) throws IOException;
         * @param shardPath the path the shard is using
         * @param shardPath the shard path
 */  
     * @return a map from recovery type to an recovery state factory
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.nio.file.Path;
            ShardPath shardPath
    }  
    }
         * @param shardLock the shard lock to associate with the store
    @FunctionalInterface
