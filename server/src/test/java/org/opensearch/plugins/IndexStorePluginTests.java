        public Store newStore(
    }  
 *  
            Store.OnClose onClose,  
            TYPE = randomFrom(Arrays.asList(IndexModule.Type.values())).getSettingsKey();
    public static class BarCustomRecoveryStore extends Plugin implements IndexStorePlugin {
import org.opensearch.cluster.node.DiscoveryNode;
        public static final String TYPE;
import org.opensearch.indices.recovery.RecoveryState;
                        + "org.opensearch.index.store.FsDirectoryFactory@[\\w\\d]+ "  
            return Collections.singletonMap("store-a", new FsDirectoryFactory());
            return Collections.singletonMap("recovery-type", new RecoveryFactory());
            IllegalStateException.class,
import org.opensearch.common.settings.Settings;  
        final Settings settings = Settings.builder().put("path.home", createTempDir()).build();
            return new RecoveryState(shardRouting, targetNode, sourceNode);
        }
import java.io.IOException;  
    }
        );
                    "java.lang.IllegalStateException: Duplicate key store \\(attempted merging values "
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    public static class FooStoreFactoryPlugin extends Plugin implements IndexStorePlugin {  
            hasToString(containsString("registered index store type [" + ConflictingStorePlugin.TYPE + "] conflicts with a built-in type"))  
import org.opensearch.test.OpenSearchTestCase;
        }
        public Map<String, DirectoryFactory> getDirectoryFactories() {
import org.opensearch.index.store.Store;
        );
        public Store newStore(  
            return Collections.singletonMap("store", new FsDirectoryFactory());  
        @Override  
        static {  
        final IllegalStateException e = expectThrows(  
import org.opensearch.env.ShardLock;
import static org.hamcrest.Matchers.containsString;  
    }  
/*  
 */
        public Map<String, DirectoryFactory> getDirectoryFactories() {
    public static class TestStoreFactory implements IndexStorePlugin.StoreFactory {
    }  
        public Map<String, DirectoryFactory> getDirectoryFactories() {
            e,
            return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath, directoryFactory);  
        @Override
        }
    public static class FooStorePlugin extends Plugin implements IndexStorePlugin {
        assertThat(e.getMessage(), containsString("Duplicate key recovery-type"));
            return Collections.singletonMap("foo_store", new TestStoreFactory());  
        }
        ) throws IOException {
            () -> new MockNode(settings, Collections.singletonList(ConflictingStorePlugin.class))
 * Modifications Copyright OpenSearch Contributors. See
 */  
    public static class FooCustomRecoveryStore extends Plugin implements IndexStorePlugin {
 *
        @Override
            ShardPath shardPath
            return Collections.singletonMap(TYPE, new FsDirectoryFactory());  
        }
            return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath);  
        }
            IllegalStateException.class,
        );  
        }
    public static class ConflictingStorePlugin extends Plugin implements IndexStorePlugin {
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
        public Map<String, StoreFactory> getStoreFactories() {
        final Settings settings = Settings.builder().put("path.home", createTempDir()).build();
        @Override
            return Collections.singletonMap("store-b", new FsDirectoryFactory());
        }  
    }  
            )  
            ShardPath shardPath,  
 * KIND, either express or implied.  See the License for the
        }  
        ) throws IOException {
/*
            return Collections.singletonMap("store", new FsDirectoryFactory());  
            ShardId shardId,
        public RecoveryState newRecoveryState(ShardRouting shardRouting, DiscoveryNode targetNode, DiscoveryNode sourceNode) {
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
                )
import org.opensearch.index.shard.ShardPath;
            IndexStorePlugin.DirectoryFactory directoryFactory
        @Override
import java.util.Map;  
    }
            org.apache.lucene.store.Directory directory,  
 * under the License.  
    }
        @Override  
            hasToString(  
    }
public class IndexStorePluginTests extends OpenSearchTestCase {  
import org.opensearch.node.MockNode;  
 * software distributed under the License is distributed on an
        public Map<String, DirectoryFactory> getDirectoryFactories() {
    public static class BarStorePlugin extends Plugin implements IndexStorePlugin {
        public Map<String, RecoveryStateFactory> getRecoveryStateFactories() {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IndexSettings;
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final IllegalStateException e = expectThrows(  
            ShardId shardId,
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.core.index.shard.ShardId;
        }
    }
    public void testDuplicateIndexStoreFactories() {
        assertThat(
            IndexSettings indexSettings,  
import org.opensearch.index.IndexModule;  
}  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }
        @Override  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
        );  
        @Override
        public Map<String, DirectoryFactory> getDirectoryFactories() {
 * ownership. Elasticsearch licenses this file to you under  
            org.apache.lucene.store.Directory directory,
        assertThat(
import java.util.Arrays;
 *
                matches(
    public void testDuplicateIndexStoreRecoveryStateFactories() {
        }
 */  
import static org.hamcrest.Matchers.hasToString;
            return Collections.singletonMap("recovery-type", new RecoveryFactory());
 * GitHub history for details.
            ShardLock shardLock,
                        + "and org.opensearch.index.store.FsDirectoryFactory@[\\w\\d]+\\)"
        @Override
 * SPDX-License-Identifier: Apache-2.0
    public static class RecoveryFactory implements IndexStorePlugin.RecoveryStateFactory {
 * Licensed to Elasticsearch under one or more contributor  
        }  
        @Override
            () -> new MockNode(settings, Arrays.asList(FooCustomRecoveryStore.class, BarCustomRecoveryStore.class))
            e,
 * not use this file except in compliance with the License.
            ShardLock shardLock,
import java.util.Collections;
import org.opensearch.index.store.FsDirectoryFactory;  
            IllegalStateException.class,
        final IllegalStateException e = expectThrows(  
        @Override  
    public void testIndexStoreFactoryConflictsWithBuiltInIndexStoreType() {
        public Map<String, RecoveryStateFactory> getRecoveryStateFactories() {  
        final Settings settings = Settings.builder().put("path.home", createTempDir()).build();
            IndexSettings indexSettings,
    }  
            () -> new MockNode(settings, Arrays.asList(BarStorePlugin.class, FooStorePlugin.class))
 * compatible open source license.
package org.opensearch.plugins;
 * this work for additional information regarding copyright
            Store.OnClose onClose,
