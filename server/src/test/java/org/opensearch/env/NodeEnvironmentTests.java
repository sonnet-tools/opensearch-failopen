            }
    }
        for (int i = 0; i < counts.length; i++) {
 * You may obtain a copy of the License at
        env.close();
        env.close();
        }
        final ShardId shardId = new ShardId(index, 0);
            Index index = new Index("foo" + i, "fooUUID" + i);
        assertThat(
        }
        Index index = new Index("myindex", "myindexUUID");
        IllegalStateException ex = expectThrows(
                                counts[shard].value++;
        // assert that we fail on shard data even without the metadata dir.
        // simulate some previous left over temp files
            assertEquals(flipFlop[i].get(), 0);
 * GitHub history for details.
        assertThat(env.availableShardPaths(sid), equalTo(env.availableShardPaths(sid)));
            assertFalse(Files.exists(path));
            }
    private void verifyFailsOnShardData(Settings settings, Path indexPath, String shardDataDirName) {
            };
            final Path tempFile = nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME);
        assertThat(
        }
import org.opensearch.index.store.IndexStoreListener;
        } catch (ShardLockObtainFailedException ex) {
    public Settings buildEnvSettings(Settings settings) {
        NodeEnvironment env = newNodeEnvironment(
            int value = 0;
    }
    public NodeEnvironment newNodeEnvironment() throws IOException {
                }
            Files.createDirectories(path.resolve("0"));
            .putList(Environment.PATH_DATA_SETTING.getKey(), dataPaths)
            env.deleteShardDirectorySafe(new ShardId(index, 0), idxSettings);
import org.apache.lucene.index.SegmentInfos;
            @Override
            countsAtomic[i] = new AtomicInteger();
            for (Path path : indexPaths) {
                public void run() {
            locations[i] = PathUtils.get(strings[i], additional);
    }
            equalTo(stringsToPaths(dataPaths, "nodes/0/indices/" + index.getUUID()))
            threads[i].join();
import static org.hamcrest.Matchers.startsWith;
        }
            fail("shard is locked");
        final String[] absPaths = new String[numPaths];
        } catch (ShardLockObtainFailedException ex) {
        for (Map.Entry<String, List<Path>> actualIndexDataPathEntry : actualIndexDataPaths.entrySet()) {
        String nodeID = env.nodeId();
            () -> newNodeEnvironment(settings).close()
    }
        NodeEnvironment env = newNodeEnvironment(dataPaths, "/tmp", Settings.EMPTY);
                indexCounter1.incrementAndGet();
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
        // can lock again?
        try {
        // Even though its silly MAXINT nodes is a-ok!
        assertNull(SegmentInfos.getInfoStream());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
}
        final Index index = new Index("foo", "fooUUID");
        final AtomicInteger indexCounter2 = new AtomicInteger(0);
                                    scaledRandomIntBetween(0, 10)
    }
import java.util.Set;
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), sharedDataPath)
                                    new ShardId("foo", "fooUUID", shard),
        }
        Settings noDataNoClusterManagerSettings = Settings.builder()
        }
        Settings noDataSettings = nonDataNode(settings);
        );
        );
        assertEquals(1, indexCounter1.get());
        List<String> dataPaths = Environment.PATH_DATA_SETTING.get(settings);
                actualPaths.add(path.getFileName().toString());
 * Licensed to Elasticsearch under one or more contributor
                            try (
            Thread t = new Thread(new AbstractRunnable() {
import java.io.IOException;
        );
        final Settings settings = buildEnvSettings(Settings.builder().put("node.max_local_storage_nodes", 1).build());
                        int shard = randomIntBetween(0, counts.length - 1);
            NodeEnvironment.applySegmentInfosTrace(
        }
    private Path[] stringsToPaths(String[] strings, String additional) {
        env.close();
        } catch (IllegalArgumentException e) {
            .build();
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
 */
        }
                excludedPaths.add(env.indexPaths(index)[0].getFileName().toString());
        Settings build = buildEnvSettings(settings);
    }
        assertThat(env.lockedShards(), empty());
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            public void beforeShardPathDeleted(ShardId inShardId, IndexSettings indexSettings, NodeEnvironment env) {
        for (Path path : env.indexPaths(index)) {
        // test that we can create data=false env with only meta information. Also create shard data for following asserts
    public void testSegmentInfosTracing() {
package org.opensearch.env;
        env = newNodeEnvironment(paths, Settings.EMPTY);
        final AtomicInteger shardCounter1 = new AtomicInteger(0);
            equalTo(stringsToPaths(dataPaths, "nodes/0/indices/" + index.getUUID() + "/0"))
        Set<String> excludedPaths = new HashSet<>();
        }
            "[node.max_local_storage_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < counts.length; i++) {
        env.deleteIndexDirectorySafe(index, 5000, idxSettings);
            assertFalse(Files.exists(path.resolve("0")));
    }
            Index index = new Index("foo" + i, "fooUUID" + i);
            public void beforeIndexPathDeleted(Index inIndex, IndexSettings indexSettings, NodeEnvironment env) {
    public void testDeleteSafe() throws Exception {
                }
    public String[] tmpPaths() {
            }
        };
        }
    public void testAvailableIndexFoldersWithExclusions() throws Exception {
import org.opensearch.node.Node;
        try {
        assertEquals(1, indexCounter2.get());
                    logger.error("unexpected error", e);
            indexPath = env.indexPaths(index)[0];
            if (randomBoolean()) {
        final int numIndices = randomIntBetween(1, 10);
        try {
    private void verifyFailsOnMetadata(Settings settings, Path indexPath) {
        final CountDownLatch latch = new CountDownLatch(1);
        env.close();
    public void testNodeIdNotPersistedAtInitialization() throws IOException {
            for (Path path : env.indexPaths(index)) {
        for (Path path : env.indexPaths(index)) {
            IllegalStateException.class,
        }
    }
        ShardLock fooLock = env.shardLock(new ShardId(index, 0), "1");
        assertNull(threadException.get());
import org.opensearch.test.NodeRoles;
    public NodeEnvironment newNodeEnvironment(String[] dataPaths, String sharedDataPath, Settings settings) throws IOException {
                + "See the breaking changes documentation for the next major version."
    public void testResolveIndexFolders() throws Exception {
            assertTrue(Files.exists(path));
 *
            env.indexPaths(index),
        for (int i = 0; i < threads.length; i++) {
                @Override
        );
            Settings.builder().put(NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING.getKey(), value).build()
            assertTrue(env.nodeDataPaths()[i].startsWith(PathUtils.get(dataPaths.get(i))));
    }
    public void testShardLock() throws Exception {
                assertEquals(shardId, inShardId);
            assertFalse(Files.exists(path));
            .put(settings)
        Settings build = Settings.builder()
 * compatible open source license.
            Files.createFile(nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME));
                                ShardLock autoCloses = env.shardLock(
            new String[0],
        IllegalStateException ex = expectThrows(
        final NodeEnvironment first = newNodeEnvironment(settings);
                }
            env.indexPaths(index),
        String[] paths = tmpPaths();
    public void testEnsureNoShardDataOrIndexMetadata() throws IOException {
            "[node.max_local_storage_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "
        );
        assertThat(ex.getMessage(), containsString(indexPath.resolve(MetadataStateFormat.STATE_DIR_NAME).toAbsolutePath().toString()));
    }
            t.start();
            assertFalse(tempFile + " should have been cleaned", Files.exists(tempFile));
        env.close();
        final NodeEnvironment env = newNodeEnvironment();
                actualPaths.add(path.getFileName().toString());
        }
        assertEquals(first.nodeDataPaths().length, dataPaths.size());
                                countsAtomic[shard].incrementAndGet();
            }
        fooLock.close();
            );
            assertFalse(Files.exists(path.resolve("1")));
        }
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
        Set<String> actualPaths = new HashSet<>();
                    }
 *
        env.close();
            }
            fail("shard is locked");
public class NodeEnvironmentTests extends OpenSearchTestCase {
        assertThat(ex.getMessage(), startsWith("node does not have the data role but has shard data"));
    public void testExistingTempFiles() throws IOException {
        assertThat(ex.getMessage(), containsString(indexPath.resolve(shardDataDirName).toAbsolutePath().toString()));
        Index index = new Index("test", "testUUID");
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        verifyFailsOnShardData(noDataSettings, indexPath, shardDataDirName);
        verifyFailsOnMetadata(noDataNoClusterManagerSettings, indexPath);
            public void beforeIndexPathDeleted(Index inIndex, IndexSettings indexSettings, NodeEnvironment env) {
            flipFlop[i] = new AtomicInteger();
        );
            .put(settings)
 */
        assertEquals(1, shardCounter2.get());
        final CountDownLatch start = new CountDownLatch(1);
            // expected
            Files.createDirectories(path.resolve("0"));
import java.nio.file.Files;
        assertThat(env.nodeId(), not(equalTo(nodeID)));
                Files.createFile(nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME + ".final"));
        int max = NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING.get(
            );
        final NodeEnvironment env = newNodeEnvironment();
        );
            assertTrue(counts[i].value > 0);
        verifyFailsOnMetadata(noDataNoClusterManagerSettings, indexPath);
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
                    try (ShardLock autoCloses = env.shardLock(new ShardId(index, 0), "2")) {
        assertThat(env.nodeId(), not(equalTo(nodeID)));
            );
            latch.countDown();
                Files.createDirectories(path.resolve(MetadataStateFormat.STATE_DIR_NAME));
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
                    paths = new ArrayList<>();
 * not use this file except in compliance with the License.
        final AtomicInteger indexCounter1 = new AtomicInteger(0);
        } catch (ShardLockObtainFailedException ex) {
        }
        }
            @Override
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { Node.NODE_LOCAL_STORAGE_SETTING });
                        } catch (ShardLockObtainFailedException ex) {
        return absPaths;
import org.opensearch.common.SuppressForbidden;
        }
            }
            @Override
            }
        final NodeEnvironment env = newNodeEnvironment(new IndexStoreListener.CompositeIndexStoreListener(List.of(listener1, listener2)));
import org.opensearch.cluster.node.DiscoveryNodeRole;
        try {
import org.opensearch.test.IndexSettingsModule;
        }
                assertEquals(shardId, inShardId);
        Settings settings = buildEnvSettings(Settings.EMPTY);
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
        // check we clean up
import static org.hamcrest.Matchers.containsString;
            assertTrue(Files.exists(path.resolve("0")));
        }
                )
        for (int i = 0; i < threads.length; i++) {
            assertTrue(Files.exists(path.resolve("1")));
            env.shardLock(new ShardId(index, 0), "2");
import org.opensearch.common.util.concurrent.AbstractRunnable;
        );
            for (Path path : env.indexPaths(index)) {
    private final IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("foo", Settings.EMPTY);
            }
        assertThat(actualPaths, equalTo(env.availableIndexFolders()));
        }
        );
        );
            env.resolveCustomLocation("/tmp/foo", sid).toAbsolutePath(),
 * the Apache License, Version 2.0 (the "License"); you may
        env.close();
import java.util.concurrent.CountDownLatch;
        try {
                            ) {
        }
        }
                Settings.builder().put(NodeEnvironment.ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING.getKey(), false).build()
        Index index = new Index("foo", "fooUUID");
        // Close the environment that holds the lock and make sure we can get the lock after release
        NodeEnvironment second = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
        } catch (ShardLockObtainFailedException ex) {
        assertThat(Sets.difference(actualPaths, excludedPaths), equalTo(env.availableIndexFolders(excludedPaths::contains)));
            "Must fail creating NodeEnvironment on a data path that has index metadata if node does not have data and cluster-manager roles",
        env.close();
                                )
            counts[i] = new Int();
        for (String path : randomSubsetOf(randomIntBetween(1, paths.length), paths)) {
            .put(settings)
        // Reuse the same location and attempt to lock again
        }
                Files.createDirectories(path.resolve(MetadataStateFormat.STATE_DIR_NAME));
                protected void doRun() throws Exception {
            }
                                    "1",
    }
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
    }
        assertEquals(0, shardCounter1.get());
/*
    public NodeEnvironment newNodeEnvironment(IndexStoreListener listener) throws IOException {
import org.opensearch.common.settings.Setting;
import java.util.Arrays;
        }
        for (Path path : env.indexPaths(index)) {
 * The OpenSearch Contributors require contributions made to
    }
import java.util.concurrent.atomic.AtomicReference;
                shardCounter2.incrementAndGet();
        final Int[] counts = new Int[shards];
    }
        final int numPaths = randomIntBetween(1, 3);
            env.lockAllForIndex(index, idxSettings, "3", randomIntBetween(0, 10));
        List<ShardLock> locks = env.lockAllForIndex(index, idxSettings, "5", randomIntBetween(0, 10));
        Set<String> actualPaths = new HashSet<>();
        final AtomicReference<Throwable> threadException = new AtomicReference<>();
        final int iters = scaledRandomIntBetween(10000, 100000);
        Map<String, List<Path>> actualIndexDataPaths = new HashMap<>();
                indexCounter2.incrementAndGet();
        for (String path : paths) {
        env.close();
            public void beforeShardPathDeleted(ShardId inShardId, IndexSettings indexSettings, NodeEnvironment env) {
            assertThat(actualPaths, equalTo(env.resolveIndexFolder(actualIndexDataPathEntry.getKey())));
        assertThat("previous node didn't have local storage enabled, id should change", env.nodeId(), not(equalTo(nodeID)));
            assertEquals(counts[i].value, countsAtomic[i].get());
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build), listener);
        Settings build = Settings.builder()
            .build();
                    latch.countDown();
            IllegalStateException.class,
            "shard paths with a custom data_path should contain only regular paths",
        // test that we can create data=true, cluster_manager=true env. Also remove state dir to leave only shard data for following asserts
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
        fooLock.close();
        );
            env.availableShardPaths(sid),
            Index index = new Index("foo" + i, "fooUUID" + i);
        for (int i = 0; i < numIndices; i++) {
        assertThat(env.nodeDataPaths(), arrayWithSize(dataPaths.size()));
        assertEquals(0, shardCounter2.get());
            }
        env.deleteIndexDirectorySafe(index, 5000, idxSettings);
    public void testNodeLockSillySettings() {
            fail("shard 0 is locked");
                Files.createDirectories(path.resolve(MetadataStateFormat.STATE_DIR_NAME));
        newNodeEnvironment(noClusterManagerSettings).close();
                    start.await();
        for (Path path : env.indexPaths(index)) {
                }
        final AtomicInteger shardCounter2 = new AtomicInteger(0);
    }
        newNodeEnvironment(noDataNoClusterManagerSettings).close();
            .put(
                            }
                    latch.countDown();
            "index paths uses the regular template",
            nonClusterManagerNode(nonDataNode(Settings.builder().put("node.local_storage", false).build()))
                            // ok
            assertTrue(Files.exists(path.resolve("0")));
        } catch (ShardLockObtainFailedException ex) {
        for (Path path : env.indexPaths(index)) {
        final int shards = randomIntBetween(2, 10);
            for (Path path : env.indexPaths(index)) {
            threads[i].start();
        final AtomicInteger[] countsAtomic = new AtomicInteger[shards];
        assertEquals(new ShardId(index, 0), fooLock.getShardId());
        }
        final String[] paths = tmpPaths();
                                assertEquals(flipFlop[shard].incrementAndGet(), 1);
        assertThat(
    public void testNodeLockSingleEnvironment() throws IOException {
        final CountDownLatch blockLatch = new CountDownLatch(1);
            .putList(Environment.PATH_DATA_SETTING.getKey(), dataPaths)
                        Thread.sleep(randomIntBetween(1, 10));
    }
            assertEquals(first.nodeDataPaths()[i].getParent(), second.nodeDataPaths()[i].getParent());
        } else {
        latch.countDown(); // fire the threads up
                        blockLatch.countDown();
            final Path nodePath = NodeEnvironment.resolveNodePath(PathUtils.get(path), 0);
 * software distributed under the License is distributed on an
        final int numIndices = randomIntBetween(1, 10);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
        );
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
        Path[] locations = new Path[strings.length];
        for (Path path : env.indexPaths(index)) {
            // But true means hook std out up statically
        }
            "shard paths with a custom data_path should contain only regular paths",
import static org.hamcrest.Matchers.arrayWithSize;
        final CountDownLatch latch = new CountDownLatch(1);
                Files.createDirectories(path);
            assertThat(e.getMessage(), containsString("must be >= 1"));
        assertEquals(new ShardId(index, 0), fooLock.getShardId());
        Thread[] threads = new Thread[randomIntBetween(2, 5)];
        }
            SegmentInfos.setInfoStream(null);
        final Index index = new Index("foo", "fooUUID");
            () -> newNodeEnvironment(settings).close()
import org.opensearch.index.IndexSettings;
        for (int i = 0; i < numIndices; i++) {
        return newNodeEnvironment(Settings.EMPTY);
    @Override
        return locations;
    }
            // expected
        }
        start.countDown();
            if (randomBoolean()) {
import static org.hamcrest.Matchers.empty;
        blockLatch.await();
                Files.createDirectories(path.resolve(shardDataDirName));
        env.close();
                shardCounter1.incrementAndGet();
    }
                assertEquals(index, inIndex);
    }
                if (paths == null) {
            if (randomBoolean()) {
        env.close();
        assertEquals(0, indexCounter2.get());
            fail("shard is locked");
                + "See the breaking changes documentation for the next major version."
        // assert that we get the stricter message on meta-data when both conditions fail
                paths.add(path);
            )
        env.shardLock(new ShardId(index, 0), "4").close();
            for (Path path : env.indexPaths(index)) {
                    }
                assertEquals(index, inIndex);
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.index.Index;
        }
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
        }
                List<Path> paths = actualIndexDataPaths.get(fileName);
            "Must fail creating NodeEnvironment on a data path that has shard data if node does not have data role",
    }
            Files.createDirectories(nodePath);
        assertWarnings(
        ShardId sid = new ShardId(index, 0);
        env.deleteShardDirectorySafe(new ShardId(index, 1), idxSettings);
            .build();
import java.util.concurrent.atomic.AtomicInteger;
                    try {
        );
        env = newNodeEnvironment(paths, Settings.EMPTY);
        }
        env.close();
        assertEquals(second.nodeDataPaths().length, dataPaths.size());
            env.shardLock(new ShardId(index, 0), "6");
                    } catch (InterruptedException e) {
        for (Path path : env.indexPaths(index)) {
                Settings.builder().put(NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING.getKey(), between(Integer.MIN_VALUE, 0)).build()
            .build();
        NodeEnvironment env = newNodeEnvironment(paths, Settings.EMPTY);
    }
            final Path nodePath = NodeEnvironment.resolveNodePath(PathUtils.get(path), 0);
        for (int i = 0; i < dataPaths.size(); i++) {
        assertThat(env.availableShardPaths(sid), equalTo(env.availableShardPaths(sid)));
@LuceneTestCase.SuppressFileSystems("ExtrasFS") // TODO: fix test to allow extras
import java.util.Collections;
    public void testAvailableIndexFolders() throws Exception {
            // expected
            equalTo(PathUtils.get("/tmp/foo/0/" + index.getUUID() + "/0").toAbsolutePath())
        String[] dataPaths = tmpPaths();
                NodeRoles.removeRoles(
        if (randomBoolean()) {
        for (int i = 0; i < dataPaths.size(); i++) {
        assertThat(ex.getMessage(), containsString("failed to obtain node lock"));
            () -> new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings))
                    blockLatch.countDown();
        final NodeEnvironment env = newNodeEnvironment();
        for (Path path : env.indexPaths(index)) {
        assertThat(
            }
 * ownership. Elasticsearch licenses this file to you under
        try (NodeEnvironment env = newNodeEnvironment(noDataSettings)) {
import java.util.Map;
        // test that we can create data=false and cluster_manager=false with no meta information
            Path[] actualPaths = actual.toArray(new Path[0]);
import org.apache.lucene.tests.util.LuceneTestCase;
            fail("expected failure");
                    settings,
                    }
        for (Path path : env.indexPaths(index)) {
        assertThat(
                String fileName = path.getFileName().toString();
            assertFalse(targetTempFile + " should have been cleaned", Files.exists(targetTempFile));
import java.nio.file.Path;
            Files.createDirectories(path.resolve("1"));
        assertEquals(0, indexCounter1.get());
            equalTo(PathUtils.get("/tmp/foo/0/" + index.getUUID() + "/0").toAbsolutePath())
import org.opensearch.common.util.set.Sets;
            "index paths uses the regular template",
                Settings.builder().put(NodeEnvironment.ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING.getKey(), true).build()
 * under the License.
        }
            // False means don't hook up std out
            blockLatch.countDown();
        final NodeEnvironment env = newNodeEnvironment();
        return Settings.builder()
import org.opensearch.common.io.PathUtils;
        assertEquals(1, shardCounter1.get());
import org.opensearch.gateway.MetadataStateFormat;
        ShardLock fooLock = env.shardLock(new ShardId(index, 0), "1");
            NodeEnvironment.applySegmentInfosTrace(
        assertThat(
            for (Path path : env.indexPaths(index)) {
            .put(settings)
 * specific language governing permissions and limitations
        int value = between(1, Integer.MAX_VALUE);
        IOUtils.close(locks);
            final Path targetTempFile = nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME + ".target");
        final AtomicInteger[] flipFlop = new AtomicInteger[shards];
    }
 * this work for additional information regarding copyright
import java.util.HashSet;
        class Int {
            // expected
        final Settings settings = buildEnvSettings(Settings.builder().put("node.max_local_storage_nodes", 2).build());
            assertNull(SegmentInfos.getInfoStream());
    }
    }
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            absPaths[i] = createTempDir().toAbsolutePath().toString();
            threads[i] = new Thread() {
            "[node.max_local_storage_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "
            // expected
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
        try {
        final NodeEnvironment env = newNodeEnvironment();
    }
    public void testStressShardLock() throws IOException, InterruptedException {
            assertFalse(srcTempFile + " should have been cleaned", Files.exists(srcTempFile));
            equalTo(stringsToPaths(dataPaths, "nodes/0/indices/" + index.getUUID() + "/0"))
        assertWarnings(
            });
        for (Path path : env.indexPaths(index)) {
            }
    @SuppressForbidden(reason = "System.out.*")
/*
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
                actualIndexDataPaths.put(fileName, paths);
        env = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
        for (int i = 0; i < numPaths; i++) {
        } finally {
        // Defaults to not hooking up std out
                Files.createFile(nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME + ".tmp"));
        // build settings using same path.data as original but without data role
                        fail(e.getMessage());
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
 * KIND, either express or implied.  See the License for the
            assertTrue(Files.exists(path));
        }
        }
 */
        }
    public void testCustomDataPaths() throws Exception {
        env.close();
            IllegalStateException.class,
        // test that we can create cluster_manager=false env regardless of data.
                public void onFailure(Exception e) {
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
        String shardDataDirName = Integer.toString(randomInt(10));
            env.availableShardPaths(sid),
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
            }
            final Path srcTempFile = nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME + ".src");
        }
        // build settings using same path.data as original but without cluster-manager role
        verifyFailsOnShardData(noDataSettings, indexPath, shardDataDirName);
        assertThat(ex.getMessage(), startsWith("node does not have the data and cluster_manager roles but has index metadata"));
        for (int i = 0; i < numIndices; i++) {
        final int numIndices = randomIntBetween(1, 10);
        verifyFailsOnShardData(noDataNoClusterManagerSettings, indexPath, shardDataDirName);
        );
        }
            assertTrue(Files.exists(path.resolve("0")));
                        try {
    @Override
        for (int i = 0; i < strings.length; i++) {
                @Override
            env.resolveCustomLocation("/tmp/foo", sid).toAbsolutePath(),
                        latch.await();
            Files.createDirectories(path.resolve("1"));
                    Collections.unmodifiableSet(new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.MASTER_ROLE)))
    public NodeEnvironment newNodeEnvironment(String[] dataPaths, Settings settings) throws IOException {
        try {
                        }
    /** Converts an array of Strings to an array of Paths, adding an additional child if specified */
import org.opensearch.common.util.io.IOUtils;
                    for (int i = 0; i < iters; i++) {
        assertEquals(value, max);
            Path[] indexPaths = env.indexPaths(index);
import static org.hamcrest.CoreMatchers.equalTo;
        final NodeEnvironment env = newNodeEnvironment();
                + "See the breaking changes documentation for the next major version."
            assertEquals(System.out, SegmentInfos.getInfoStream());
            env.deleteIndexDirectorySafe(index, randomIntBetween(0, 10), idxSettings);
    public void testIndexStoreListener() throws Exception {
import static org.opensearch.test.NodeRoles.nonDataNode;
        IllegalStateException ex = expectThrows(
        nodeID = env.nodeId();
        List<String> dataPaths = Environment.PATH_DATA_SETTING.get(settings);
 * license agreements. See the NOTICE file distributed with
        Path indexPath;
                                assertEquals(flipFlop[shard].decrementAndGet(), 0);
        env = newNodeEnvironment(Settings.EMPTY);
                    threadException.set(e);
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
        final IndexStoreListener listener2 = new IndexStoreListener() {
    public NodeEnvironment newNodeEnvironment(Settings settings) throws IOException {
        assertWarnings(
        Settings build = buildEnvSettings(Settings.EMPTY);
        env.close();
        env.deleteShardDirectorySafe(new ShardId(index, 0), idxSettings);
        latch.await();
import java.util.List;
        NodeEnvironment env = newNodeEnvironment(settings);
            List<Path> actual = actualIndexDataPathEntry.getValue();
import java.util.ArrayList;
    @Override
        Settings noClusterManagerSettings = nonClusterManagerNode(settings);
        };
            // Clean up after ourselves
        }
                @Override
        final IndexStoreListener listener1 = new IndexStoreListener() {
        for (Path path : env.indexPaths(index)) {
            fail("shard is locked");
        // build settings using same path.data as original but without data and cluster-manager roles
 * Unless required by applicable law or agreed to in writing,
            equalTo(stringsToPaths(dataPaths, "nodes/0/indices/" + index.getUUID()))
        IOUtils.close(first, second);
        env.close();
                Files.delete(path.resolve(MetadataStateFormat.STATE_DIR_NAME));
/*
import static org.hamcrest.Matchers.not;
    public void testNodeLockMultipleEnvironment() throws IOException {
            Files.createDirectories(path.resolve("0"));
import java.util.HashMap;
            NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING.get(
