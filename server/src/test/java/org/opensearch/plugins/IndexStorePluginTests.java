            IndexSettings indexSettings,
        }
 * KIND, either express or implied.  See the License for the
        public Store newStore(
/*
        final IllegalStateException e = expectThrows(
    public static class FooCustomRecoveryStore extends Plugin implements IndexStorePlugin {
        final IllegalStateException e = expectThrows(
import org.opensearch.common.settings.Settings;
        );
    public static class BarCustomRecoveryStore extends Plugin implements IndexStorePlugin {
        }
        public static final String TYPE;
            ShardLock shardLock,
package org.opensearch.plugins;
        @Override
        static {
            IndexStorePlugin.DirectoryFactory directoryFactory
import org.opensearch.indices.recovery.RecoveryState;
        final Settings settings = Settings.builder().put("path.home", createTempDir()).build();
            IndexSettings indexSettings,
        public Map<String, DirectoryFactory> getDirectoryFactories() {
            IllegalStateException.class,
        @Override
        );
        public Store newStore(
        }
    }
        final Settings settings = Settings.builder().put("path.home", createTempDir()).build();
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.hasToString;
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collections;
            e,
 * this work for additional information regarding copyright
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
            IllegalStateException.class,
import org.opensearch.index.store.Store;
import java.util.Arrays;
            hasToString(containsString("registered index store type [" + ConflictingStorePlugin.TYPE + "] conflicts with a built-in type"))
        @Override
        public Map<String, DirectoryFactory> getDirectoryFactories() {
        final IllegalStateException e = expectThrows(
            return Collections.singletonMap("store-a", new FsDirectoryFactory());
    }
 * The OpenSearch Contributors require contributions made to
                        + "and org.opensearch.index.store.FsDirectoryFactory@[\\w\\d]+\\)"
import org.opensearch.env.ShardLock;
        final Settings settings = Settings.builder().put("path.home", createTempDir()).build();
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    public static class ConflictingStorePlugin extends Plugin implements IndexStorePlugin {
        @Override
            ShardLock shardLock,
    }
            ShardPath shardPath
            TYPE = randomFrom(Arrays.asList(IndexModule.Type.values())).getSettingsKey();
            return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath, directoryFactory);
            return Collections.singletonMap("recovery-type", new RecoveryFactory());
 * Unless required by applicable law or agreed to in writing,
        }
import static org.hamcrest.Matchers.containsString;
 * GitHub history for details.
        assertThat(
    public static class FooStorePlugin extends Plugin implements IndexStorePlugin {
public class IndexStorePluginTests extends OpenSearchTestCase {
import org.opensearch.cluster.routing.ShardRouting;
            )
            () -> new MockNode(settings, Collections.singletonList(ConflictingStorePlugin.class))
                )
 */
        );
    public void testDuplicateIndexStoreFactories() {
        public Map<String, DirectoryFactory> getDirectoryFactories() {
 */
 * this file be licensed under the Apache-2.0 license or a
            ShardPath shardPath,
import org.opensearch.index.IndexSettings;
import org.opensearch.core.index.shard.ShardId;
            return new RecoveryState(shardRouting, targetNode, sourceNode);
        public RecoveryState newRecoveryState(ShardRouting shardRouting, DiscoveryNode targetNode, DiscoveryNode sourceNode) {
    }
        }
            return Collections.singletonMap("store-b", new FsDirectoryFactory());
/*
 *
            ShardId shardId,
    }
            return Collections.singletonMap("store", new FsDirectoryFactory());
        }
 *
        }
        }
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
            () -> new MockNode(settings, Arrays.asList(BarStorePlugin.class, FooStorePlugin.class))
import org.opensearch.index.store.FsDirectoryFactory;
    public static class TestStoreFactory implements IndexStorePlugin.StoreFactory {
            hasToString(
/*
 *
        @Override
 * ownership. Elasticsearch licenses this file to you under
        public Map<String, StoreFactory> getStoreFactories() {
        public Map<String, DirectoryFactory> getDirectoryFactories() {
        );
    public void testIndexStoreFactoryConflictsWithBuiltInIndexStoreType() {
                matches(
    public static class FooStoreFactoryPlugin extends Plugin implements IndexStorePlugin {
        assertThat(e.getMessage(), containsString("Duplicate key recovery-type"));
import org.opensearch.node.MockNode;
        @Override
            return Collections.singletonMap("foo_store", new TestStoreFactory());
import java.util.Map;
    }
        @Override
        }
import org.opensearch.test.OpenSearchTestCase;
        @Override
    }
            ShardId shardId,
            Store.OnClose onClose,
        assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return new Store(shardId, indexSettings, directory, shardLock, onClose, shardPath);
            org.apache.lucene.store.Directory directory,
        );
    }
    }
    }
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
        public Map<String, RecoveryStateFactory> getRecoveryStateFactories() {
                        + "org.opensearch.index.store.FsDirectoryFactory@[\\w\\d]+ "
    }
        @Override
        public Map<String, DirectoryFactory> getDirectoryFactories() {
import org.opensearch.index.IndexModule;
            org.apache.lucene.store.Directory directory,
            e,
            return Collections.singletonMap(TYPE, new FsDirectoryFactory());
        }
    public static class RecoveryFactory implements IndexStorePlugin.RecoveryStateFactory {
import java.io.IOException;
        }
        ) throws IOException {
        }
            Store.OnClose onClose,
    public void testDuplicateIndexStoreRecoveryStateFactories() {
                    "java.lang.IllegalStateException: Duplicate key store \\(attempted merging values "
}
 */
            IllegalStateException.class,
            () -> new MockNode(settings, Arrays.asList(FooCustomRecoveryStore.class, BarCustomRecoveryStore.class))
        public Map<String, RecoveryStateFactory> getRecoveryStateFactories() {
import org.opensearch.cluster.node.DiscoveryNode;
            return Collections.singletonMap("store", new FsDirectoryFactory());
import org.opensearch.index.shard.ShardPath;
    public static class BarStorePlugin extends Plugin implements IndexStorePlugin {
        @Override
        ) throws IOException {
            return Collections.singletonMap("recovery-type", new RecoveryFactory());
 * You may obtain a copy of the License at
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
