        );
        public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        // Second shard should go to b
        assertEquals("mocka", nodePaths[0].fileStore.name());
import java.nio.file.attribute.FileStoreAttributeView;
        Path path = PathUtils.get(createTempDir().toString());
            return "mock";
        shardId = new ShardId("index", "uid1", 1);
            return desc;
        assertThat(result2.getDataPath().toString(), containsString(bPathPart));
        ShardPath result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, Collections.<Path, Integer>emptyMap());
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(
        createFakeShard(result);
}
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, Collections.<Path, Integer>emptyMap());
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
        shardId = new ShardId("index2", "uid2", 1);
        assertEquals("mockb", nodePaths[1].fileStore.name());
import static org.hamcrest.Matchers.containsString;
        bPathPart = current.getSeparator() + 'b' + current.getSeparator();
        bFileStore.usableSpace = 100000;
        shardId = new ShardId("index", "uid1", 1);
        createFakeShard(result1);
        }
import org.opensearch.test.IndexSettingsModule;
        }
    }
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(
            if (path.toString().contains(aPathPart)) {
        aFileStore.usableSpace = 10000;
        public boolean supportsFileAttributeView(String name) {
            fileStores.add(bFileStore);
    static void createFakeShard(ShardPath path) throws IOException {
        }
        // had the most free space, never using the other drive unless new shards arrive
        Settings settings = Settings.builder()
        PathUtilsForTesting.installMock(mock.getFileSystem(null));
        @Override
 *
        dataPathToShardCount.put(NodeEnvironment.shardStatePathToDataPath(result2.getDataPath()), 1);
        FileSystemProvider mock = new MockUsableSpaceFileSystemProvider(current);
        createFakeShard(result1);
                return bFileStore;
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
        // Shard for new index should go to a
        aFileStore.usableSpace = 100000;
        result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
        bFileStore.usableSpace = 10000;
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);
        createFakeShard(result);
        NodePath[] nodePaths = nodeEnv.nodePaths();
        public boolean isReadOnly() {
        Settings settings = Settings.builder()
    }
 * ownership. Elasticsearch licenses this file to you under
        // Path a has lots of free space, but b has little, so new shard should go to a:
        aPathPart = current.getSeparator() + 'a' + current.getSeparator();
        NodePath[] nodePaths = nodeEnv.nodePaths();
        public Object getAttribute(String attribute) throws IOException {
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
    }
        public long getUnallocatedSpace() throws IOException {
        assertEquals("mockb", nodePaths[1].fileStore.name());
        bFileStore.usableSpace = 1000;
        MockFileStore(String desc) {
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build()
 */
        ShardPath result2 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
        createFakeShard(result);
        @Override
 */
        shardId = new ShardId("index2", "uid2", 1);
        ShardPath result1 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
import org.opensearch.common.settings.Settings;
        public long usableSpace;
        Files.createDirectories(path.resolveIndex().getParent());
        assertThat(result1.getDataPath().toString(), containsString(bPathPart));
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result.getDataPath()), (k, v) -> v == null ? 1 : v + 1);
        @Override
        createFakeShard(result2);
        assertEquals("mocka", nodePaths[0].fileStore.name());
import org.junit.AfterClass;
        createFakeShard(result3);
        shardId = new ShardId("index", "_na_", 0);
            fileStores.add(aFileStore);
/*
import java.nio.file.spi.FileSystemProvider;
            .build();
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.env.TestEnvironment;
        assertThat(result.getDataPath().toString(), containsString(bPathPart));
        bFileStore = null;
import org.opensearch.env.NodeEnvironment;
    /** Mock file system that fakes usable space for each FileStore */
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testSelectNewPathForShardEvenly() throws Exception {
        createFakeShard(result2);
 * under the License.
            return false;
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
        MockUsableSpaceFileSystemProvider(FileSystem inner) {
            return desc;
/*
    public static void installMockUsableSpaceFS() throws Exception {
 * You may obtain a copy of the License at
        createFakeShard(result);
        NodeEnvironment nodeEnv = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
 * software distributed under the License is distributed on an
        // Use 2 data paths:
        nodeEnv.close();
        Map<Path, Integer> dataPathToShardCount = new HashMap<>();
        // Second shard should go to b
                return aFileStore;
        createFakeShard(result1);
    }
        Path path = PathUtils.get(createTempDir().toString());
        Settings settings = Settings.builder()
        assertThat(result.getDataPath().toString(), containsString(bPathPart));
        ShardPath result3 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
    static class MockFileStore extends FileStore {
        }
    }
    }
        private final String desc;
        assertEquals(2, nodePaths.length);
        ShardPath result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
/*
        aFileStore.usableSpace = 100000;
        public String name() {
        dataPathToShardCount.put(NodeEnvironment.shardStatePathToDataPath(result1.getDataPath()), 1);
        aFileStore.usableSpace = 1000;
 * specific language governing permissions and limitations
import org.opensearch.common.io.PathUtilsForTesting;
import java.io.IOException;
        bFileStore.usableSpace = 10000;
        createFakeShard(result);
            .build();
 *
    }
        }
        assertThat(ShardPath.getPathWithMostFreeSpace(nodeEnv), equalTo(nodeEnv.nodePaths()[0]));
 * license agreements. See the NOTICE file distributed with
        aFileStore.usableSpace = 100000;
        assertThat(result1.getDataPath().toString(), containsString(aPathPart));
 * GitHub history for details.
            return false;
    public void testSelectNewPathForShard() throws Exception {
/** Separate test class from ShardPathTests because we need static (BeforeClass) setup to install mock filesystems... */
        ShardPath result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, Collections.<Path, Integer>emptyMap());
        // First shard should go to a
        // 2 shards go to 'a' and 1 to 'b'
            }
        aFileStore = null;
        }
            return null;
        public FileStore getFileStore(Path path) throws IOException {
        // Use 2 data paths:
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
        @Override
            final List<FileStore> fileStores = new ArrayList<>();
        assertEquals("mockb", nodePaths[1].fileStore.name());
 * The OpenSearch Contributors require contributions made to
            return false;
            .build();
    @AfterClass
        FileSystem current = PathUtils.getDefaultFileSystem();
            .build();
        // Path a has lots of free space, but b has little, so new shard should go to a:
import java.nio.file.Files;
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
        assertThat(ShardPath.getPathWithMostFreeSpace(nodeEnv), equalTo(nodeEnv.nodePaths()[1]));
 * compatible open source license.
            .put(Environment.PATH_HOME_SETTING.getKey(), path)
        // Make sure all our mocking above actually worked:
        // 2 shards go to 'b' and 1 to 'a'
        ShardPath result2 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
import java.util.ArrayList;
    private static MockFileStore aFileStore = new MockFileStore("mocka");
        assertTrue(result.getDataPath().toString().contains(aPathPart));
import java.nio.file.FileStore;
            "index2",
        public String toString() {
        assertTrue(result.getDataPath().toString().contains(bPathPart));
        shardId = new ShardId("index2", "uid3", 0);
            } else {
        Path path = PathUtils.get(createTempDir().toString());
        assertThat(result2.getDataPath().toString(), containsString(aPathPart));
        result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
    @BeforeClass
    private static String aPathPart;
        ShardId shardId = new ShardId("index", "_na_", 0);
import java.nio.file.Path;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.equalTo;
        NodeEnvironment nodeEnv = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
        }
        bFileStore.usableSpace = 100000;
    }
 *
        @Override
        shardId = new ShardId("index2", "uid2", 2);
        }
        Path path = PathUtils.get(createTempDir().toString());
        // Make sure all our mocking above actually worked:
        public long getTotalSpace() throws IOException {
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build()
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
import java.nio.file.attribute.FileAttributeView;
        nodeEnv.close();
        @Override
        // Make sure all our mocking above actually worked:
        shardId = new ShardId("index2", "uid2", 0);
import org.opensearch.index.IndexSettings;
import org.opensearch.test.OpenSearchTestCase;
import java.util.List;
        // Test the reverse: b has lots of free space, but a has little, so new shard should go to b:
            return usableSpace;
        ShardPath result3 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
    private static MockFileStore bFileStore = new MockFileStore("mockb");
        // Path a has lots of free space, but b has little, so new shard should go to a:
        @Override
import org.opensearch.common.io.PathUtils;
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result.getDataPath()), (k, v) -> v == null ? 1 : v + 1);
        shardId = new ShardId("index2", "uid2", 0);
        }
 * the Apache License, Version 2.0 (the "License"); you may
            this.desc = desc;
 * not use this file except in compliance with the License.
        // after the first shards started using storage:
        assertEquals("mocka", nodePaths[0].fileStore.name());
    private static String bPathPart;
 */
        ShardPath result1 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
        dataPathToShardCount.put(NodeEnvironment.shardStatePathToDataPath(result1.getDataPath()), 1);
        bFileStore.usableSpace = 1000;
        ShardPath result1 = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
        shardId = new ShardId("index2", "uid2", 2);
        public long getUsableSpace() throws IOException {
        NodePath[] nodePaths = nodeEnv.nodePaths();
    static class MockUsableSpaceFileSystemProvider extends FilterFileSystemProvider {
        ShardPath result2 = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
        // Now a and be have equal usable space; we allocate two shards to the node, and each should go to different paths:
        // #11122: this was the original failure: on a node with 2 disks that have nearly equal
        assertThat(result.getDataPath().toString(), containsString(aPathPart));
        result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, Collections.<Path, Integer>emptyMap());
        @Override
        }
        public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        );
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
        ShardId shardId = new ShardId("index", "uid1", 0);
            return usableSpace * 2;
import java.util.Collections;
        assertThat(result3.getDataPath().toString(), containsString(bPathPart));
            "index2",
            .put(Environment.PATH_HOME_SETTING.getKey(), path)
            return null;
 * Licensed to Elasticsearch under one or more contributor
        }
        assertThat(result.getDataPath().toString(), containsString(aPathPart));
        bFileStore.usableSpace = 20000;
        // free space, we would always allocate all N incoming shards to the one path that
        assertThat(result.getDataPath().toString(), containsString(aPathPart));
        public String type() {
public class NewPathForShardTests extends OpenSearchTestCase {
        aFileStore.usableSpace = 100000;
        @Override
            .put(Environment.PATH_HOME_SETTING.getKey(), path)
            .put(Environment.PATH_HOME_SETTING.getKey(), path)
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
package org.opensearch.index.shard;
import org.junit.BeforeClass;
        assertEquals(2, nodePaths.length);
 * KIND, either express or implied.  See the License for the
        assertThat(result3.getDataPath().toString(), containsString(aPathPart));
        NodeEnvironment nodeEnv = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
        PathUtilsForTesting.teardown();
        assertEquals(2, nodePaths.length);
        }
import java.util.Map;
import java.util.HashMap;
        // Use 2 data paths:
        Settings settings = Settings.builder()
    public void testTieBreakWithMostShards() throws Exception {
import org.opensearch.env.NodeEnvironment.NodePath;
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result1.getDataPath()), (k, v) -> v == null ? 1 : v + 1);
        ShardId shardId = new ShardId("index", "uid1", 0);
        assertNotEquals(result1.getDataPath(), result2.getDataPath());
    public static void removeMockUsableSpaceFS() throws Exception {
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result.getDataPath()), (k, v) -> v == null ? 1 : v + 1);
        nodeEnv.close();
        }
        nodeEnv.close();
        createFakeShard(result3);
    // Sneakiness to install mock file stores so we can pretend how much free space we have on each path.data:
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result2.getDataPath()), (k, v) -> v == null ? 1 : v + 1);
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
        Map<Path, Integer> dataPathToShardCount = new HashMap<>();
        @Override
    }
    public void testGettingPathWithMostFreeSpace() throws Exception {
        }
        createFakeShard(result2);
            return usableSpace * 3;
        @Override
        aFileStore.usableSpace = 100000;
            super("mockusablespace://", inner);
        // Use 2 data paths:
        // First shard should go to a
        @Override
        NodeEnvironment nodeEnv = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
import java.nio.file.FileSystem;
import org.opensearch.env.Environment;
        Map<Path, Integer> dataPathToShardCount = new HashMap<>();
