 * Unless required by applicable law or agreed to in writing,
        @Override
 */  
            if ("mock".equals(indexSettings.get(IndexModule.INDEX_STORE_TYPE_SETTING.getKey()))) {
            }
            }
import org.opensearch.index.shard.IndexEventListener;  
            return Settings.builder().put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), "mock").build();
 * compatible open source license.
import java.util.Collections;
import java.util.EnumSet;
 * SPDX-License-Identifier: Apache-2.0
                INDEX_CHECK_INDEX_ON_CLOSE_SETTING,
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
            }
        true,
import java.util.IdentityHashMap;  
        }
    public static class TestPlugin extends Plugin implements IndexStorePlugin {
 *     http://www.apache.org/licenses/LICENSE-2.0
                    indexModule.addIndexEventListener(new Listener());  
import org.apache.logging.log4j.Logger;
import org.opensearch.index.IndexModule;
                    MockFSDirectoryFactory.checkIndex(logger, indexShard.store(), indexShard.shardId());  
 * specific language governing permissions and limitations
import java.util.Map;
 */
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (remove == Boolean.TRUE) {
import org.opensearch.common.Nullable;
                shardSet.put(indexShard, Boolean.TRUE);
        public Settings additionalSettings() {  
            return Collections.singletonMap("mock", new MockFSDirectoryFactory());
        public Map<String, DirectoryFactory> getDirectoryFactories() {  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
            return Arrays.asList(  
            IndexShardState currentState,  
}  
                MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_ON_OPEN_SETTING
    public static final Setting<Boolean> INDEX_CHECK_INDEX_ON_CLOSE_SETTING = Setting.boolSetting(  
 * this work for additional information regarding copyright
import org.opensearch.index.shard.IndexShardState;
import java.util.Arrays;  
import org.opensearch.common.settings.Settings;  
        }  
        Property.IndexScope,  
                MockFSDirectoryFactory.CRASH_INDEX_SETTING,
        @Override
        ) {
        }
            @Nullable IndexShardState previousState,
/*  
 * Licensed to Elasticsearch under one or more contributor  
        IndexShardState.STARTED,
 *  
        "index.store.mock.check_index_on_close",
        @Override
            if (indexShard != null) {
    }
            if (currentState == IndexShardState.CLOSED && validCheckIndexStates.contains(previousState)) {  
import org.opensearch.common.settings.Setting;
        @Override
import org.opensearch.common.settings.Setting.Property;
    private static final EnumSet<IndexShardState> validCheckIndexStates = EnumSet.of(  
        public void afterIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
        Property.NodeScope
import org.opensearch.index.shard.IndexShard;
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        public void indexShardStateChanged(  
            Settings indexSettings = indexModule.getSettings();  
        public List<Setting<?>> getSettings() {
 * You may obtain a copy of the License at  
                }
        public void onIndexModule(IndexModule indexModule) {
        @Override  
 * Modifications Copyright OpenSearch Contributors. See
    private static final class Listener implements IndexEventListener {
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
                Boolean remove = shardSet.remove(indexShard);  
        }  
                MockFSDirectoryFactory.RANDOM_IO_EXCEPTION_RATE_SETTING,  
 * software distributed under the License is distributed on an
    );
                    Logger logger = Loggers.getLogger(getClass(), indexShard.shardId());
/*
        }
 *
        IndexShardState.POST_RECOVERY
package org.opensearch.test.store;
    );  
                }
/*  
 * GitHub history for details.
            );
import org.opensearch.core.index.shard.ShardId;
 */  
    }
import org.opensearch.common.logging.Loggers;  
import java.util.List;
import org.opensearch.plugins.Plugin;
        private final Map<IndexShard, Boolean> shardSet = Collections.synchronizedMap(new IdentityHashMap<>());
import org.opensearch.plugins.IndexStorePlugin;  
            @Nullable String reason
 * ownership. Elasticsearch licenses this file to you under  
public final class MockFSIndexStore {
            IndexShard indexShard,
                if (INDEX_CHECK_INDEX_ON_CLOSE_SETTING.get(indexSettings)) {
 *
