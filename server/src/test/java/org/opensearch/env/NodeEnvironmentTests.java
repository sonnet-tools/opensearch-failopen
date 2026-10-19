                                counts[shard].value++;
            IllegalStateException.class,
                Files.createDirectories(path.resolve(MetadataStateFormat.STATE_DIR_NAME));
        String[] dataPaths = tmpPaths();  
        assertEquals(1, indexCounter1.get());  
import java.nio.file.Path;
        List<String> dataPaths = Environment.PATH_DATA_SETTING.get(settings);
            env.deleteIndexDirectorySafe(index, randomIntBetween(0, 10), idxSettings);
        for (Path path : env.indexPaths(index)) {
            NodeEnvironment.applySegmentInfosTrace(  
        );
    }
        assertWarnings(  
            }
    public String[] tmpPaths() {
                NodeRoles.removeRoles(
                        try {  
        env.close();  
        }
        }
import static org.hamcrest.Matchers.not;
            public void beforeIndexPathDeleted(Index inIndex, IndexSettings indexSettings, NodeEnvironment env) {
                Files.createDirectories(path.resolve(MetadataStateFormat.STATE_DIR_NAME));
            latch.countDown();
        fooLock.close();  
                }
        final NodeEnvironment env = newNodeEnvironment();
            fail("expected failure");
            Files.createDirectories(path.resolve("0"));
        );
            indexPath = env.indexPaths(index)[0];
        } catch (ShardLockObtainFailedException ex) {
                )
            }
        assertThat(env.lockedShards(), empty());
/*
        final AtomicInteger shardCounter1 = new AtomicInteger(0);  
    }
import org.opensearch.test.IndexSettingsModule;
            env.deleteShardDirectorySafe(new ShardId(index, 0), idxSettings);  
        IllegalStateException ex = expectThrows(  
            assertThat(actualPaths, equalTo(env.resolveIndexFolder(actualIndexDataPathEntry.getKey())));  
            // expected  
    }
        env.close();  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
            for (Path path : env.indexPaths(index)) {
            assertFalse(targetTempFile + " should have been cleaned", Files.exists(targetTempFile));
        assertEquals(1, shardCounter2.get());
            blockLatch.countDown();  
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
        final int numIndices = randomIntBetween(1, 10);
            env.indexPaths(index),
import org.opensearch.common.util.io.IOUtils;
        env.close();
            // False means don't hook up std out
        for (int i = 0; i < numIndices; i++) {
        Settings build = buildEnvSettings(settings);
                assertEquals(shardId, inShardId);
            Path[] indexPaths = env.indexPaths(index);  
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
                    try (ShardLock autoCloses = env.shardLock(new ShardId(index, 0), "2")) {
                        Thread.sleep(randomIntBetween(1, 10));
                    latch.countDown();
        Settings noClusterManagerSettings = nonClusterManagerNode(settings);  
    @Override
        env.deleteIndexDirectorySafe(index, 5000, idxSettings);
        }
        for (int i = 0; i < strings.length; i++) {  
            @Override
        // Even though its silly MAXINT nodes is a-ok!
        assertThat(env.nodeId(), not(equalTo(nodeID)));
        }
 * software distributed under the License is distributed on an
        final AtomicReference<Throwable> threadException = new AtomicReference<>();  
            nonClusterManagerNode(nonDataNode(Settings.builder().put("node.local_storage", false).build()))  
        env.close();
            for (Path path : env.indexPaths(index)) {
        Map<String, List<Path>> actualIndexDataPaths = new HashMap<>();  
        assertThat(ex.getMessage(), containsString(indexPath.resolve(MetadataStateFormat.STATE_DIR_NAME).toAbsolutePath().toString()));
import org.apache.lucene.tests.util.LuceneTestCase;
import java.util.HashSet;  
            Settings.builder().put(NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING.getKey(), value).build()
    private void verifyFailsOnMetadata(Settings settings, Path indexPath) {
import java.util.concurrent.CountDownLatch;
            );
        assertThat(env.availableShardPaths(sid), equalTo(env.availableShardPaths(sid)));  
        };  
        try {
        );
    @Override  
            };  
            () -> new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings))  
        for (int i = 0; i < numPaths; i++) {
                    Collections.unmodifiableSet(new HashSet<>(Arrays.asList(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.MASTER_ROLE)))  
            assertTrue(Files.exists(path.resolve("0")));  
        env.close();  
        }  
                actualIndexDataPaths.put(fileName, paths);  
        final Int[] counts = new Int[shards];  
            NodeEnvironment.applySegmentInfosTrace(  
        final int numPaths = randomIntBetween(1, 3);
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { Node.NODE_LOCAL_STORAGE_SETTING });  
        // simulate some previous left over temp files
        for (int i = 0; i < numIndices; i++) {
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
        assertWarnings(
            if (randomBoolean()) {
        };
        verifyFailsOnShardData(noDataSettings, indexPath, shardDataDirName);
        Index index = new Index("test", "testUUID");
            Files.createDirectories(path.resolve("1"));
            equalTo(stringsToPaths(dataPaths, "nodes/0/indices/" + index.getUUID()))  
    /** Converts an array of Strings to an array of Paths, adding an additional child if specified */  
                            ) {
        );
        for (Path path : env.indexPaths(index)) {  
import java.util.concurrent.atomic.AtomicReference;  
            () -> newNodeEnvironment(settings).close()  
    public void testNodeLockMultipleEnvironment() throws IOException {
        Settings settings = buildEnvSettings(Settings.EMPTY);  
            t.start();  
        for (Path path : env.indexPaths(index)) {
        assertThat(env.nodeDataPaths(), arrayWithSize(dataPaths.size()));
        // assert that we get the stricter message on meta-data when both conditions fail
            );
        assertThat("previous node didn't have local storage enabled, id should change", env.nodeId(), not(equalTo(nodeID)));  
        );
            env.shardLock(new ShardId(index, 0), "6");  
import static org.hamcrest.Matchers.empty;
    public void testSegmentInfosTracing() {  
        return locations;  
        NodeEnvironment env = newNodeEnvironment(
                assertEquals(index, inIndex);  
        env.close();  
 * The OpenSearch Contributors require contributions made to  
        Path[] locations = new Path[strings.length];
            for (Path path : env.indexPaths(index)) {
            assertEquals(counts[i].value, countsAtomic[i].get());  
                    }  
        IOUtils.close(first, second);
        }  
                        fail(e.getMessage());
            @Override
        for (Path path : env.indexPaths(index)) {
    }
        final Settings settings = buildEnvSettings(Settings.builder().put("node.max_local_storage_nodes", 2).build());
            final Path nodePath = NodeEnvironment.resolveNodePath(PathUtils.get(path), 0);
        latch.countDown(); // fire the threads up  
        if (randomBoolean()) {
        try {
        assertNull(threadException.get());
        String shardDataDirName = Integer.toString(randomInt(10));  
        ShardLock fooLock = env.shardLock(new ShardId(index, 0), "1");  
        final NodeEnvironment first = newNodeEnvironment(settings);  
    }  
            assertTrue(env.nodeDataPaths()[i].startsWith(PathUtils.get(dataPaths.get(i))));
            .putList(Environment.PATH_DATA_SETTING.getKey(), dataPaths)  
            final Path srcTempFile = nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME + ".src");
 * the Apache License, Version 2.0 (the "License"); you may
            threads[i].start();
                Files.createDirectories(path.resolve(MetadataStateFormat.STATE_DIR_NAME));
        env.deleteShardDirectorySafe(new ShardId(index, 0), idxSettings);
        assertThat(actualPaths, equalTo(env.availableIndexFolders()));
            "shard paths with a custom data_path should contain only regular paths",
            }
        // test that we can create cluster_manager=false env regardless of data.
        IOUtils.close(locks);
            env.availableShardPaths(sid),
                Files.delete(path.resolve(MetadataStateFormat.STATE_DIR_NAME));
        assertEquals(0, shardCounter2.get());  
        Set<String> actualPaths = new HashSet<>();
            locations[i] = PathUtils.get(strings[i], additional);
    }  
        try {
        final NodeEnvironment env = newNodeEnvironment();
import static org.opensearch.test.NodeRoles.nonDataNode;  
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), sharedDataPath)
        final int numIndices = randomIntBetween(1, 10);  
        assertEquals(0, indexCounter1.get());
        }
    public void testIndexStoreListener() throws Exception {
                    settings,
        List<ShardLock> locks = env.lockAllForIndex(index, idxSettings, "5", randomIntBetween(0, 10));
            final Path tempFile = nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME);
        final NodeEnvironment env = newNodeEnvironment();
            fail("shard is locked");
        env.close();
        Index index = new Index("foo", "fooUUID");  
        assertThat(env.nodeId(), not(equalTo(nodeID)));
    }  
 *  
        final NodeEnvironment env = newNodeEnvironment();
import static org.hamcrest.Matchers.startsWith;  
            @Override
                                    scaledRandomIntBetween(0, 10)
            assertEquals(System.out, SegmentInfos.getInfoStream());  
        }
    }
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
            IllegalStateException.class,  
        );
            SegmentInfos.setInfoStream(null);  
        }
            .put(settings)  
                    } catch (InterruptedException e) {
        }
            .build();
import java.util.Collections;
            assertTrue(Files.exists(path));  
            fail("shard is locked");
    public void testEnsureNoShardDataOrIndexMetadata() throws IOException {
}
            }  
                                countsAtomic[shard].incrementAndGet();  
                Files.createDirectories(path.resolve(shardDataDirName));
    @Override
            if (randomBoolean()) {
        blockLatch.await();  
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
        // build settings using same path.data as original but without data and cluster-manager roles  
        final AtomicInteger[] countsAtomic = new AtomicInteger[shards];
                    latch.countDown();  
        class Int {
        try {  
        for (int i = 0; i < threads.length; i++) {
        final NodeEnvironment env = newNodeEnvironment();
        }
            equalTo(PathUtils.get("/tmp/foo/0/" + index.getUUID() + "/0").toAbsolutePath())  
        Settings build = Settings.builder()
        return newNodeEnvironment(Settings.EMPTY);  
            equalTo(stringsToPaths(dataPaths, "nodes/0/indices/" + index.getUUID() + "/0"))  
    private final IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("foo", Settings.EMPTY);
        nodeID = env.nodeId();
            "index paths uses the regular template",
                Settings.builder().put(NodeEnvironment.ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING.getKey(), false).build()
            assertNull(SegmentInfos.getInfoStream());  
            env.shardLock(new ShardId(index, 0), "2");
        NodeEnvironment second = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));
        final int shards = randomIntBetween(2, 10);
    }
    public void testResolveIndexFolders() throws Exception {  
        final CountDownLatch start = new CountDownLatch(1);  
            .put(  
        );
        verifyFailsOnMetadata(noDataNoClusterManagerSettings, indexPath);
                @Override
        for (int i = 0; i < counts.length; i++) {  
        // test that we can create data=false env with only meta information. Also create shard data for following asserts
        }
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
    public void testExistingTempFiles() throws IOException {  
    }
        for (Path path : env.indexPaths(index)) {
    }  
        Set<String> excludedPaths = new HashSet<>();  
            if (randomBoolean()) {
    public Settings buildEnvSettings(Settings settings) {
import org.opensearch.common.settings.Setting;
        }  
                    try {
        env.close();
            assertFalse(Files.exists(path));
            }  
            fail("shard is locked");
        }
@LuceneTestCase.SuppressFileSystems("ExtrasFS") // TODO: fix test to allow extras
        env.close();  
        assertThat(  
        final IndexStoreListener listener2 = new IndexStoreListener() {
    public void testNodeLockSillySettings() {  
            });
                    for (int i = 0; i < iters; i++) {
            }  
import org.opensearch.common.io.PathUtils;
                    }
    }
            "Must fail creating NodeEnvironment on a data path that has shard data if node does not have data role",
        }
 * You may obtain a copy of the License at  
    }  
                Files.createFile(nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME + ".tmp"));
        final int iters = scaledRandomIntBetween(10000, 100000);  
        );
import static org.hamcrest.Matchers.containsString;  
 * Modifications Copyright OpenSearch Contributors. See  
        final NodeEnvironment env = newNodeEnvironment(new IndexStoreListener.CompositeIndexStoreListener(List.of(listener1, listener2)));
        }
        for (int i = 0; i < dataPaths.size(); i++) {  
        assertThat(Sets.difference(actualPaths, excludedPaths), equalTo(env.availableIndexFolders(excludedPaths::contains)));
 * Unless required by applicable law or agreed to in writing,
            }
 *
            )
        // assert that we fail on shard data even without the metadata dir.  
 * compatible open source license.
                            try (
 * Licensed to Elasticsearch under one or more contributor  
        }  
        IllegalStateException ex = expectThrows(
            "shard paths with a custom data_path should contain only regular paths",
 * GitHub history for details.
        for (Path path : env.indexPaths(index)) {  
import org.opensearch.gateway.MetadataStateFormat;  
        }
                actualPaths.add(path.getFileName().toString());  
        final AtomicInteger shardCounter2 = new AtomicInteger(0);
        assertEquals(1, shardCounter1.get());
        final NodeEnvironment env = newNodeEnvironment();
                @Override  
            () -> newNodeEnvironment(settings).close()
import java.nio.file.Files;  
        int value = between(1, Integer.MAX_VALUE);
        env.close();  
import org.opensearch.index.store.IndexStoreListener;
        try (NodeEnvironment env = newNodeEnvironment(noDataSettings)) {  
        try {
        }  
    @SuppressForbidden(reason = "System.out.*")
        final Index index = new Index("foo", "fooUUID");
        }
            final Path targetTempFile = nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME + ".target");  
            public void beforeShardPathDeleted(ShardId inShardId, IndexSettings indexSettings, NodeEnvironment env) {  
            Files.createFile(nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME));  
        newNodeEnvironment(noClusterManagerSettings).close();  
        // build settings using same path.data as original but without cluster-manager role
            assertThat(e.getMessage(), containsString("must be >= 1"));
        final ShardId shardId = new ShardId(index, 0);
        env = newNodeEnvironment(paths, Settings.EMPTY);  
            threads[i].join();
                    logger.error("unexpected error", e);
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
            );
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build), listener);
            countsAtomic[i] = new AtomicInteger();  
        } catch (ShardLockObtainFailedException ex) {
        ShardLock fooLock = env.shardLock(new ShardId(index, 0), "1");
import org.opensearch.common.util.concurrent.AbstractRunnable;
                + "See the breaking changes documentation for the next major version."
            env.resolveCustomLocation("/tmp/foo", sid).toAbsolutePath(),
                Settings.builder().put(NodeEnvironment.ENABLE_LUCENE_SEGMENT_INFOS_TRACE_SETTING.getKey(), true).build()
    }  
        }  
        for (String path : paths) {  
            flipFlop[i] = new AtomicInteger();
        }  
import java.io.IOException;
import org.opensearch.test.OpenSearchTestCase;  
                public void onFailure(Exception e) {
        env = newNodeEnvironment(Settings.EMPTY);  
    public void testNodeIdNotPersistedAtInitialization() throws IOException {  
        for (Path path : env.indexPaths(index)) {  
            // expected
                    blockLatch.countDown();
            Index index = new Index("foo" + i, "fooUUID" + i);  
import org.opensearch.index.IndexSettings;
                    threadException.set(e);  
        final AtomicInteger indexCounter1 = new AtomicInteger(0);
            public void beforeShardPathDeleted(ShardId inShardId, IndexSettings indexSettings, NodeEnvironment env) {
                shardCounter2.incrementAndGet();
        Settings noDataSettings = nonDataNode(settings);
        assertEquals(first.nodeDataPaths().length, dataPaths.size());  
        );
            Index index = new Index("foo" + i, "fooUUID" + i);
        } finally {
            }
        );
            assertEquals(flipFlop[i].get(), 0);
        assertThat(
        return absPaths;
            for (Path path : indexPaths) {
                                    "1",
        }
        }
            NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING.get(
        final Index index = new Index("foo", "fooUUID");
            assertTrue(counts[i].value > 0);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
            assertFalse(tempFile + " should have been cleaned", Files.exists(tempFile));  
        assertNull(SegmentInfos.getInfoStream());
        String[] paths = tmpPaths();
        final IndexStoreListener listener1 = new IndexStoreListener() {  
            "[node.max_local_storage_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "  
import static org.opensearch.test.NodeRoles.nonClusterManagerNode;
import java.util.concurrent.atomic.AtomicInteger;
                indexCounter1.incrementAndGet();
        assertEquals(1, indexCounter2.get());
            }  
        env.close();
        } catch (ShardLockObtainFailedException ex) {
    }
        for (Path path : env.indexPaths(index)) {
                                assertEquals(flipFlop[shard].incrementAndGet(), 1);
/*  
        start.countDown();
        final CountDownLatch latch = new CountDownLatch(1);
        }
            @Override
    }
        }  
            assertTrue(Files.exists(path.resolve("1")));
            env.availableShardPaths(sid),
            fail("shard 0 is locked");
        return Settings.builder()  
            .putList(Environment.PATH_DATA_SETTING.getKey(), dataPaths)
    }  
        env.shardLock(new ShardId(index, 0), "4").close();
        env.close();
        NodeEnvironment env = newNodeEnvironment(dataPaths, "/tmp", Settings.EMPTY);
        assertEquals(second.nodeDataPaths().length, dataPaths.size());
        Settings noDataNoClusterManagerSettings = Settings.builder()
        final AtomicInteger indexCounter2 = new AtomicInteger(0);  
        // build settings using same path.data as original but without data role  
import java.util.Set;  
        IllegalStateException ex = expectThrows(
        );  
            Files.createDirectories(path.resolve("1"));  
        NodeEnvironment env = newNodeEnvironment(settings);  
            public void beforeIndexPathDeleted(Index inIndex, IndexSettings indexSettings, NodeEnvironment env) {  
    public NodeEnvironment newNodeEnvironment(String[] dataPaths, String sharedDataPath, Settings settings) throws IOException {
        }  
                actualPaths.add(path.getFileName().toString());  
            // expected  
 * not use this file except in compliance with the License.
            Index index = new Index("foo" + i, "fooUUID" + i);  
            assertFalse(Files.exists(path.resolve("1")));  
        final String[] absPaths = new String[numPaths];  
 * specific language governing permissions and limitations
 */
        for (Path path : env.indexPaths(index)) {
            absPaths[i] = createTempDir().toAbsolutePath().toString();
            }  
    }
            "Must fail creating NodeEnvironment on a data path that has index metadata if node does not have data and cluster-manager roles",
            // expected  
 *
            assertTrue(Files.exists(path.resolve("0")));
                Files.createDirectories(path);
            // Clean up after ourselves
        for (int i = 0; i < counts.length; i++) {
        Settings build = buildEnvSettings(Settings.EMPTY);
            List<Path> actual = actualIndexDataPathEntry.getValue();
            equalTo(PathUtils.get("/tmp/foo/0/" + index.getUUID() + "/0").toAbsolutePath())  
        );
 * KIND, either express or implied.  See the License for the
                shardCounter1.incrementAndGet();
                                )  
import org.opensearch.node.Node;  
            counts[i] = new Int();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
                    paths = new ArrayList<>();  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        for (int i = 0; i < numIndices; i++) {
public class NodeEnvironmentTests extends OpenSearchTestCase {  
            // But true means hook std out up statically
            .build();  
        for (Path path : env.indexPaths(index)) {  
        try {
import org.opensearch.common.settings.Settings;  
        final String[] paths = tmpPaths();
        }
        assertThat(  
        } else {
        latch.await();  
        for (int i = 0; i < threads.length; i++) {
                protected void doRun() throws Exception {  
        }
import org.opensearch.common.util.set.Sets;  
            Files.createDirectories(path.resolve("0"));
        assertEquals(new ShardId(index, 0), fooLock.getShardId());
            // expected
    public void testStressShardLock() throws IOException, InterruptedException {  
        NodeEnvironment env = newNodeEnvironment(paths, Settings.EMPTY);
        env.close();  
                        latch.await();  
        String nodeID = env.nodeId();
        verifyFailsOnShardData(noDataNoClusterManagerSettings, indexPath, shardDataDirName);
    public void testNodeLockSingleEnvironment() throws IOException {
            Files.createDirectories(nodePath);
        Index index = new Index("myindex", "myindexUUID");  
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());  
        }
            equalTo(stringsToPaths(dataPaths, "nodes/0/indices/" + index.getUUID()))  
        final int numIndices = randomIntBetween(1, 10);
package org.opensearch.env;
            assertTrue(Files.exists(path));
                assertEquals(shardId, inShardId);  
                excludedPaths.add(env.indexPaths(index)[0].getFileName().toString());  
        final AtomicInteger[] flipFlop = new AtomicInteger[shards];
        env.deleteIndexDirectorySafe(index, 5000, idxSettings);
import java.util.Arrays;  
 * SPDX-License-Identifier: Apache-2.0
        fooLock.close();  
                assertEquals(index, inIndex);
        env = new NodeEnvironment(settings, TestEnvironment.newEnvironment(settings));  
                                    new ShardId("foo", "fooUUID", shard),  
        env = newNodeEnvironment(paths, Settings.EMPTY);
        // Defaults to not hooking up std out
                        } catch (ShardLockObtainFailedException ex) {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
            .put(settings)  
        // can lock again?
                    }
    public NodeEnvironment newNodeEnvironment(String[] dataPaths, Settings settings) throws IOException {
    }
            equalTo(stringsToPaths(dataPaths, "nodes/0/indices/" + index.getUUID() + "/0"))  
            env.indexPaths(index),
import org.opensearch.test.NodeRoles;
import org.opensearch.common.SuppressForbidden;  
        final Settings settings = buildEnvSettings(Settings.builder().put("node.max_local_storage_nodes", 1).build());
        assertThat(  
            Thread t = new Thread(new AbstractRunnable() {
import static org.hamcrest.CoreMatchers.equalTo;
            "index paths uses the regular template",
                        int shard = randomIntBetween(0, counts.length - 1);
 * license agreements. See the NOTICE file distributed with
        // test that we can create data=false and cluster_manager=false with no meta information
    public NodeEnvironment newNodeEnvironment() throws IOException {
            assertFalse(srcTempFile + " should have been cleaned", Files.exists(srcTempFile));
    }
        assertThat(ex.getMessage(), startsWith("node does not have the data and cluster_manager roles but has index metadata"));  
            Path[] actualPaths = actual.toArray(new Path[0]);
import org.opensearch.core.index.Index;
                if (paths == null) {
            .put(settings)  
            threads[i] = new Thread() {
        for (String path : randomSubsetOf(randomIntBetween(1, paths.length), paths)) {  
        }
    }
            fail("shard is locked");  
        assertThat(ex.getMessage(), containsString("failed to obtain node lock"));
        verifyFailsOnMetadata(noDataNoClusterManagerSettings, indexPath);  
            "[node.max_local_storage_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "
                        blockLatch.countDown();  
            assertFalse(Files.exists(path));
                Files.createFile(nodePath.resolve(NodeEnvironment.TEMP_FILE_NAME + ".final"));
    public NodeEnvironment newNodeEnvironment(Settings settings) throws IOException {  
        env.close();
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
                            }  
            }  
        List<String> dataPaths = Environment.PATH_DATA_SETTING.get(settings);
            }
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
    }
        }
        }
        // check we clean up
        final CountDownLatch blockLatch = new CountDownLatch(1);
        }
    private Path[] stringsToPaths(String[] strings, String additional) {
    public void testAvailableIndexFolders() throws Exception {
        assertThat(env.availableShardPaths(sid), equalTo(env.availableShardPaths(sid)));  
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
        assertEquals(0, shardCounter1.get());
        for (int i = 0; i < dataPaths.size(); i++) {
    }
            IllegalStateException.class,
            .build();
import java.util.HashMap;
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
            env.resolveCustomLocation("/tmp/foo", sid).toAbsolutePath(),
        assertWarnings(
                @Override  
                String fileName = path.getFileName().toString();  
        // test that we can create data=true, cluster_manager=true env. Also remove state dir to leave only shard data for following asserts
                public void run() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                            // ok
        Thread[] threads = new Thread[randomIntBetween(2, 5)];
                        }  
 * this work for additional information regarding copyright
import java.util.ArrayList;
        assertEquals(new ShardId(index, 0), fooLock.getShardId());
                Settings.builder().put(NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING.getKey(), between(Integer.MIN_VALUE, 0)).build()  
import org.apache.lucene.index.SegmentInfos;  
            new String[0],
                + "See the breaking changes documentation for the next major version."  
                }  
import java.util.Map;
    private void verifyFailsOnShardData(Settings settings, Path indexPath, String shardDataDirName) {
            for (Path path : env.indexPaths(index)) {
                indexCounter2.incrementAndGet();
        for (Map.Entry<String, List<Path>> actualIndexDataPathEntry : actualIndexDataPaths.entrySet()) {  
import java.util.List;
        assertThat(ex.getMessage(), containsString(indexPath.resolve(shardDataDirName).toAbsolutePath().toString()));  
        assertTrue("LockedShards: " + env.lockedShards(), env.lockedShards().isEmpty());
                List<Path> paths = actualIndexDataPaths.get(fileName);
            assertTrue(Files.exists(path.resolve("0")));
        } catch (IllegalArgumentException e) {  
        }
        Set<String> actualPaths = new HashSet<>();
    public void testCustomDataPaths() throws Exception {
        env.close();  
 */  
 * this file be licensed under the Apache-2.0 license or a
    public NodeEnvironment newNodeEnvironment(IndexStoreListener listener) throws IOException {  
            Files.createDirectories(path.resolve("0"));
        env.deleteShardDirectorySafe(new ShardId(index, 1), idxSettings);
            "[node.max_local_storage_nodes] setting was deprecated in OpenSearch and will be removed in a future release! "
        Settings build = Settings.builder()
        assertThat(
        // Close the environment that holds the lock and make sure we can get the lock after release
        assertThat(ex.getMessage(), startsWith("node does not have the data role but has shard data"));
            assertFalse(Files.exists(path.resolve("0")));
        try {
        );  
            }  
 * ownership. Elasticsearch licenses this file to you under  
        );
        verifyFailsOnShardData(noDataSettings, indexPath, shardDataDirName);  
import org.opensearch.core.index.shard.ShardId;
                paths.add(path);
                }
            .build();  
                }
                                ShardLock autoCloses = env.shardLock(
            int value = 0;
        }
        } catch (ShardLockObtainFailedException ex) {
            for (Path path : env.indexPaths(index)) {
        assertEquals(0, indexCounter2.get());
    public void testAvailableIndexFoldersWithExclusions() throws Exception {  
        ShardId sid = new ShardId(index, 0);
import static org.hamcrest.Matchers.arrayWithSize;
    public void testShardLock() throws Exception {  
                                assertEquals(flipFlop[shard].decrementAndGet(), 0);
        assertEquals(value, max);  
        }
        assertThat(  
        } catch (ShardLockObtainFailedException ex) {  
        final CountDownLatch latch = new CountDownLatch(1);
            assertEquals(first.nodeDataPaths()[i].getParent(), second.nodeDataPaths()[i].getParent());  
        for (Path path : env.indexPaths(index)) {
 * under the License.  
        Path indexPath;
        int max = NodeEnvironment.MAX_LOCAL_STORAGE_NODES_SETTING.get(  
        newNodeEnvironment(noDataNoClusterManagerSettings).close();  
                + "See the breaking changes documentation for the next major version."
        // Reuse the same location and attempt to lock again  
    public void testDeleteSafe() throws Exception {  
    }  
            final Path nodePath = NodeEnvironment.resolveNodePath(PathUtils.get(path), 0);
            env.lockAllForIndex(index, idxSettings, "3", randomIntBetween(0, 10));  
            .put(settings)
 */
                    start.await();
