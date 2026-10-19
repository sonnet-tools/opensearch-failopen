        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result1.getDataPath()), (k, v) -> v == null ? 1 : v + 1);  
import java.util.List;  
        aFileStore.usableSpace = 100000;  
        // Test the reverse: b has lots of free space, but a has little, so new shard should go to b:  
        createFakeShard(result1);
        MockUsableSpaceFileSystemProvider(FileSystem inner) {  
        bFileStore.usableSpace = 100000;
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
        ShardPath result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, Collections.<Path, Integer>emptyMap());  
        aFileStore.usableSpace = 100000;
        NodeEnvironment nodeEnv = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
import java.nio.file.FileStore;
        bPathPart = current.getSeparator() + 'b' + current.getSeparator();  
        assertThat(result1.getDataPath().toString(), containsString(aPathPart));
        shardId = new ShardId("index2", "uid2", 2);
        }
        assertThat(result2.getDataPath().toString(), containsString(bPathPart));  
        ShardPath result2 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
            return null;
        Settings settings = Settings.builder()
 * license agreements. See the NOTICE file distributed with
        ShardId shardId = new ShardId("index", "uid1", 0);
    static void createFakeShard(ShardPath path) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(result1.getDataPath().toString(), containsString(bPathPart));  
    }
        dataPathToShardCount.put(NodeEnvironment.shardStatePathToDataPath(result2.getDataPath()), 1);  
        Path path = PathUtils.get(createTempDir().toString());
import java.util.Collections;
    @BeforeClass
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result.getDataPath()), (k, v) -> v == null ? 1 : v + 1);  
        @Override  
        ShardId shardId = new ShardId("index", "uid1", 0);  
    private static String bPathPart;  
        aFileStore.usableSpace = 100000;  
 * ownership. Elasticsearch licenses this file to you under  
            .put(Environment.PATH_HOME_SETTING.getKey(), path)
            final List<FileStore> fileStores = new ArrayList<>();
        NodePath[] nodePaths = nodeEnv.nodePaths();
        createFakeShard(result1);
        Path path = PathUtils.get(createTempDir().toString());
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
        PathUtilsForTesting.teardown();
    public void testGettingPathWithMostFreeSpace() throws Exception {  
        // 2 shards go to 'a' and 1 to 'b'
        ShardPath result3 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
        }
/*
    }
            fileStores.add(aFileStore);  
        }
        assertThat(ShardPath.getPathWithMostFreeSpace(nodeEnv), equalTo(nodeEnv.nodePaths()[0]));  
        );  
 *  
import java.nio.file.attribute.FileAttributeView;  
    public void testTieBreakWithMostShards() throws Exception {
        public String toString() {
import org.junit.BeforeClass;
        assertThat(result.getDataPath().toString(), containsString(bPathPart));
        @Override  
        );
        assertEquals(2, nodePaths.length);  
        assertTrue(result.getDataPath().toString().contains(aPathPart));
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result.getDataPath()), (k, v) -> v == null ? 1 : v + 1);
    public void testSelectNewPathForShardEvenly() throws Exception {
            return null;
            .put(Environment.PATH_HOME_SETTING.getKey(), path)
 */  
import org.opensearch.env.Environment;  
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;  
        shardId = new ShardId("index2", "uid2", 1);  
    public static void installMockUsableSpaceFS() throws Exception {  
import org.opensearch.common.io.PathUtilsForTesting;  
        @Override
import org.opensearch.cluster.metadata.IndexMetadata;
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
    // Sneakiness to install mock file stores so we can pretend how much free space we have on each path.data:
        createFakeShard(result2);
import org.opensearch.index.IndexSettings;
 * not use this file except in compliance with the License.
        nodeEnv.close();  
        ShardPath result2 = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
        // Use 2 data paths:
        shardId = new ShardId("index2", "uid2", 2);
        public Object getAttribute(String attribute) throws IOException {  
        @Override  
        assertThat(ShardPath.getPathWithMostFreeSpace(nodeEnv), equalTo(nodeEnv.nodePaths()[1]));
    private static final IndexSettings INDEX_SETTINGS = IndexSettingsModule.newIndexSettings("index", Settings.EMPTY);  
        assertEquals("mocka", nodePaths[0].fileStore.name());
        result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, Collections.<Path, Integer>emptyMap());
import org.opensearch.core.index.shard.ShardId;
        aFileStore.usableSpace = 1000;
        ShardId shardId = new ShardId("index", "_na_", 0);
        public String type() {
        // First shard should go to a
    static class MockFileStore extends FileStore {
        assertThat(result3.getDataPath().toString(), containsString(aPathPart));
import java.nio.file.attribute.FileStoreAttributeView;
            return desc;  
        // Second shard should go to b  
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result2.getDataPath()), (k, v) -> v == null ? 1 : v + 1);
        assertEquals("mockb", nodePaths[1].fileStore.name());  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(result.getDataPath().toString(), containsString(bPathPart));
        aPathPart = current.getSeparator() + 'a' + current.getSeparator();
        Map<Path, Integer> dataPathToShardCount = new HashMap<>();  
        public boolean supportsFileAttributeView(String name) {
    }
        aFileStore = null;
        Map<Path, Integer> dataPathToShardCount = new HashMap<>();  
        public long getUsableSpace() throws IOException {
        public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        // Shard for new index should go to a
 * specific language governing permissions and limitations
        aFileStore.usableSpace = 10000;
        Files.createDirectories(path.resolveIndex().getParent());  
import java.nio.file.Files;
        bFileStore.usableSpace = 10000;
    @AfterClass
        ShardPath result1 = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
        }
        // First shard should go to a  
 * Modifications Copyright OpenSearch Contributors. See  
        result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
    }  
        @Override  
        // #11122: this was the original failure: on a node with 2 disks that have nearly equal
import java.nio.file.Path;
        public long getUnallocatedSpace() throws IOException {
            .build();
        ShardPath result2 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
        shardId = new ShardId("index2", "uid2", 1);
import java.io.IOException;
        assertEquals("mocka", nodePaths[0].fileStore.name());
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)  
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
        bFileStore.usableSpace = 20000;  
        private final String desc;  
        }
            return desc;
public class NewPathForShardTests extends OpenSearchTestCase {
        assertThat(result3.getDataPath().toString(), containsString(bPathPart));
        shardId = new ShardId("index2", "uid3", 0);
    }
        result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, Collections.<Path, Integer>emptyMap());
        assertEquals("mockb", nodePaths[1].fileStore.name());
/** Separate test class from ShardPathTests because we need static (BeforeClass) setup to install mock filesystems... */  
        }
        // Make sure all our mocking above actually worked:
        FileSystemProvider mock = new MockUsableSpaceFileSystemProvider(current);
        Settings settings = Settings.builder()
        // Use 2 data paths:  
import org.opensearch.env.TestEnvironment;  
        bFileStore.usableSpace = 100000;
    }
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build()
 * compatible open source license.
            }
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(
        ShardPath result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, Collections.<Path, Integer>emptyMap());
        public long getTotalSpace() throws IOException {  
                return aFileStore;
            "index2",  
        @Override
        @Override
        Map<Path, Integer> dataPathToShardCount = new HashMap<>();  
            "index2",
        dataPathToShardCount.put(NodeEnvironment.shardStatePathToDataPath(result1.getDataPath()), 1);
        // Make sure all our mocking above actually worked:
 * GitHub history for details.
        Path path = PathUtils.get(createTempDir().toString());
    public void testSelectNewPathForShard() throws Exception {  
        assertThat(result.getDataPath().toString(), containsString(aPathPart));  
import static org.hamcrest.Matchers.containsString;  
        MockFileStore(String desc) {
        ShardPath result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);  
 * under the License.  
        NodePath[] nodePaths = nodeEnv.nodePaths();
        bFileStore = null;  
        createFakeShard(result3);  
import org.junit.AfterClass;
    public static void removeMockUsableSpaceFS() throws Exception {  
        ShardPath result1 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);
 * this file be licensed under the Apache-2.0 license or a
        // 2 shards go to 'b' and 1 to 'a'
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(2, nodePaths.length);
    /** Mock file system that fakes usable space for each FileStore */  
        public FileStore getFileStore(Path path) throws IOException {
        aFileStore.usableSpace = 100000;  
        // Second shard should go to b  
        assertEquals("mocka", nodePaths[0].fileStore.name());
        }  
        public String name() {  
        NodePath[] nodePaths = nodeEnv.nodePaths();
            .put(Environment.PATH_HOME_SETTING.getKey(), path)
 */
 */
        // Path a has lots of free space, but b has little, so new shard should go to a:
 * software distributed under the License is distributed on an
        PathUtilsForTesting.installMock(mock.getFileSystem(null));
        createFakeShard(result);  
            return "mock";
            return usableSpace * 2;
            .build();  
        createFakeShard(result3);
import org.opensearch.env.NodeEnvironment;
        NodeEnvironment nodeEnv = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
        public long usableSpace;
        bFileStore.usableSpace = 10000;
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
 * You may obtain a copy of the License at  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).build()
        @Override
package org.opensearch.index.shard;
 * Licensed to Elasticsearch under one or more contributor  
        @Override
    private static String aPathPart;
        // free space, we would always allocate all N incoming shards to the one path that
        // Path a has lots of free space, but b has little, so new shard should go to a:
        // had the most free space, never using the other drive unless new shards arrive  
            .put(Environment.PATH_HOME_SETTING.getKey(), path)
        // after the first shards started using storage:
        assertThat(result.getDataPath().toString(), containsString(aPathPart));
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings(  
            } else {
        Settings settings = Settings.builder()  
            return usableSpace * 3;
        bFileStore.usableSpace = 1000;
        nodeEnv.close();
import org.opensearch.test.IndexSettingsModule;
        Path path = PathUtils.get(createTempDir().toString());
        result = ShardPath.selectNewPathForShard(nodeEnv, shardId, INDEX_SETTINGS, 100, dataPathToShardCount);
            .build();  
        createFakeShard(result);
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)  
    private static MockFileStore bFileStore = new MockFileStore("mockb");
            return false;  
        aFileStore.usableSpace = 100000;  
        }
        assertEquals(2, nodePaths.length);  
import java.util.Map;
        ShardPath result1 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);  
        NodeEnvironment nodeEnv = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
            super("mockusablespace://", inner);
 * SPDX-License-Identifier: Apache-2.0
/*
        // Now a and be have equal usable space; we allocate two shards to the node, and each should go to different paths:
        shardId = new ShardId("index", "uid1", 1);  
        dataPathToShardCount.compute(NodeEnvironment.shardStatePathToDataPath(result.getDataPath()), (k, v) -> v == null ? 1 : v + 1);
 * KIND, either express or implied.  See the License for the
        createFakeShard(result);
        createFakeShard(result1);
}  
    }  
        createFakeShard(result2);  
import java.util.HashMap;
        assertEquals("mockb", nodePaths[1].fileStore.name());  
        shardId = new ShardId("index2", "uid2", 0);
/*  
        @Override
        createFakeShard(result);
        shardId = new ShardId("index", "_na_", 0);
        public boolean isReadOnly() {
        }  
        // Make sure all our mocking above actually worked:  
            if (path.toString().contains(aPathPart)) {  
        assertThat(result2.getDataPath().toString(), containsString(aPathPart));
        @Override
        ShardPath result3 = ShardPath.selectNewPathForShard(nodeEnv, shardId, idxSettings, 100, dataPathToShardCount);  
            return false;
        dataPathToShardCount.put(NodeEnvironment.shardStatePathToDataPath(result1.getDataPath()), 1);  
    static class MockUsableSpaceFileSystemProvider extends FilterFileSystemProvider {
        // Path a has lots of free space, but b has little, so new shard should go to a:
        }
        createFakeShard(result2);
            return usableSpace;  
import org.opensearch.common.io.PathUtils;
        Settings settings = Settings.builder()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        createFakeShard(result);
                return bFileStore;  
import java.util.ArrayList;  
        public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {  
        }
import java.nio.file.FileSystem;  
 *
        assertTrue(result.getDataPath().toString().contains(bPathPart));  
        shardId = new ShardId("index", "uid1", 1);  
        assertNotEquals(result1.getDataPath(), result2.getDataPath());
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
    private static MockFileStore aFileStore = new MockFileStore("mocka");  
        // Use 2 data paths:  
        assertThat(result.getDataPath().toString(), containsString(aPathPart));
        bFileStore.usableSpace = 1000;  
 *
    }  
        nodeEnv.close();
import org.opensearch.env.NodeEnvironment.NodePath;
        }  
        NodeEnvironment nodeEnv = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
            this.desc = desc;  
            .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
        nodeEnv.close();
        }  
            return false;
        // Use 2 data paths:
import java.nio.file.spi.FileSystemProvider;
    }
            fileStores.add(bFileStore);
 * Unless required by applicable law or agreed to in writing,
        FileSystem current = PathUtils.getDefaultFileSystem();
import static org.hamcrest.Matchers.equalTo;
        @Override
            .build();
        shardId = new ShardId("index2", "uid2", 0);
 * this work for additional information regarding copyright
