import org.opensearch.common.settings.Settings;
public final class MockIndexEventListener {
 */
        /**  
            delegate.beforeIndexShardClosed(shardId, indexShard, indexSettings);
        }
import java.util.List;
        @Override
        @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     listener.setNewDelegate(new IndexEventListener() {
import org.opensearch.index.IndexModule;
        @Override
 * ownership. Elasticsearch licenses this file to you under  
         * For tests to pass in to fail on listener invocation
            @Nullable IndexShardState previousState,
        public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
        public void afterIndexRemoved(Index index, IndexSettings indexSettings, IndexRemovalReason reason) {
        }
        public Collection<Module> createGuiceModules() {
        public void beforeIndexShardDeleted(ShardId shardId, Settings indexSettings) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * <pre>
        @Override
 * this work for additional information regarding copyright
        @Override
/**
            IndexShard indexShard,  
        }  
            IndexShardState currentState,
    }
 *        // do some stuff
import org.opensearch.common.settings.Setting.Property;
            @Nullable String reason  
        private volatile IndexEventListener delegate = new IndexEventListener() {
        public void afterIndexCreated(IndexService indexService) {
        @Override
        @Override
        public void afterIndexShardStarted(IndexShard indexShard) {
import org.opensearch.plugins.Plugin;  
            delegate.afterIndexShardStarted(indexShard);  
        }
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.index.shard.IndexShardState;
        }
        }  
        public void beforeIndexCreated(Index index, Settings indexSettings) {  
        public void setNewDelegate(IndexEventListener listener) {
        public static final Setting<Boolean> INDEX_FAIL = Setting.boolSetting("index.fail", false, Property.IndexScope);  
/*
        }
            delegate.beforeIndexRemoved(indexService, reason);
        @Override  
        };
            delegate.afterIndexShardDeleted(shardId, indexSettings);
 * This is a testing plugin that registers a generic
        public void afterIndexShardDeleted(ShardId shardId, Settings indexSettings) {  
        @Override
            delegate.shardRoutingChanged(indexShard, oldRouting, newRouting);
import org.opensearch.index.shard.IndexEventListener;
 * specific language governing permissions and limitations
 * </pre>
            } : listener;  
 * This allows tests to use the listener without registering their own plugins.
        private final TestEventListener listener = new TestEventListener();
            module.addIndexEventListener(listener);  
        public void indexShardStateChanged(
import org.opensearch.cluster.routing.ShardRouting;  
        public void beforeIndexAddedToCluster(Index index, Settings indexSettings) {
 * You may obtain a copy of the License at  
        @Override
    public static class TestPlugin extends Plugin {  
            delegate.afterIndexRemoved(index, indexSettings, reason);  
        }
            delegate.beforeIndexShardCreated(shardId, indexSettings);
        }  
 *  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        @Override
            delegate.afterIndexShardClosed(shardId, indexShard, indexSettings);
        }
        @Override
 * Unless required by applicable law or agreed to in writing,
/*  
        }  
        }  
        }
import org.opensearch.common.settings.Setting;  
    public static class TestEventListener implements IndexEventListener {  
import org.opensearch.index.shard.IndexShard;  
 */  
            delegate.beforeIndexShardDeleted(shardId, indexSettings);
 *     });  
    }
            delegate.indexShardStateChanged(indexShard, previousState, currentState, reason);
 * as well as a listener on every index. Tests can access it like this:
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;
        ) {
        @Override
        @Override  
        }  
            return Collections.singleton(binder -> binder.bind(TestEventListener.class).toInstance(listener));
        public List<Setting<?>> getSettings() {  
            delegate.beforeIndexCreated(index, indexSettings);
            delegate = listener == null ? new IndexEventListener() {
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        public void onIndexModule(IndexModule module) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.shard.ShardId;
 * The OpenSearch Contributors require contributions made to  
/*
import java.util.Collection;  
 */
 *
            delegate.afterIndexCreated(indexService);  
         */
}  
 * not use this file except in compliance with the License.
        @Override
        @Override  
        @Override  
import org.opensearch.index.IndexService;  
            return Arrays.asList(INDEX_FAIL);
import java.util.Arrays;
 *     TestEventListener listener = internalCluster().getInstance(MockIndexEventListener.TestEventListener.class, node1);  
        }
        public void afterIndexShardCreated(IndexShard indexShard) {  
 * Licensed to Elasticsearch under one or more contributor  
        public void shardRoutingChanged(IndexShard indexShard, @Nullable ShardRouting oldRouting, ShardRouting newRouting) {
import org.opensearch.common.inject.Module;
 * compatible open source license.
        public void beforeIndexShardCreated(ShardId shardId, Settings indexSettings) {
            delegate.beforeIndexAddedToCluster(index, indexSettings);  
 * {@link MockIndexEventListener.TestEventListener} as a node level service  
        }
import org.opensearch.common.Nullable;
        public void beforeIndexRemoved(IndexService indexService, IndexRemovalReason reason) {  
            delegate.afterIndexShardCreated(indexShard);
package org.opensearch.test;
 */  
import org.opensearch.core.index.Index;  
        public void afterIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {  
import java.util.Collections;
import org.opensearch.index.IndexSettings;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
        }
 * under the License.  
