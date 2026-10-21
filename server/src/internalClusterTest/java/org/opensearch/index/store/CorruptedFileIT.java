     * and all other replicas for the healthy shards happens
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).get());
                        PrintStream out = new PrintStream(os, false, StandardCharsets.UTF_8.name());
            .put("compress", randomBoolean())
            .setIndices("test")
        }
                        if (item.getFileName().toString().startsWith("segments_")) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
    }
        for (NodeStats dataNode : dataNodeStats) {
import java.util.concurrent.TimeUnit;
                }
            internalCluster().startDataOnlyNode();
        MatcherAssert.assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));
                client().admin().cluster().prepareState().get().getState(),
                break;
            if (Files.exists(file)) { // multi data path might only have one path in use
                        BytesStreamOutput os = new BytesStreamOutput();
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).get());
        logger.info("--> {} corrupted", corruptedShardRouting);
        // Create a snapshot repository. This repo is used to take a snapshot after
        final NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
import org.opensearch.action.search.SearchResponse;
     * This simulates recoveries from old indices or even without checksums and makes sure if we fail during finalization
            // we really need local GW here since this also checks for corruption etc.
package org.opensearch.index.store;
                            array[i] = (byte) ~array[i]; // flip one byte in the content
            checkIndexFailures.get(0)
        // we have to flush at least once here since we don't corrupt the translog
         * we corrupted the primary shard - now lets make sure we never recover from it successfully
                corruptedFile = file;
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertAcked(
                            }
                    }
                client().admin().cluster().prepareState().get().getState(),
    }
                .contains("could not read old (not latest) commit point segments file \"segments_2\" in directory")
        assertThat(health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
            )
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
            assertHitCount(response, numDocs);
                                                                                                                                    // - it
        assertHitCount(countResponse, numDocs);
        if (actionGet.isTimedOut()) {
            .setWaitForCompletion(true)
 * not use this file except in compliance with the License.
        client().admin().cluster().prepareReroute().get();
                    if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
            InternalSettingsPlugin.class
import java.nio.charset.StandardCharsets;
        indexRandom(true, builders);
                    Store store = indexShard.store();
        }
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
        corrupt.set(false);
        ensureGreen();
        for (ShardIterator iterator : shardIterators) {
                client().admin().cluster().preparePendingClusterTasks().get()
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false) // no checkindex - we corrupt shards on
            )
                }
                    assertThat(routing.state(), equalTo(ShardRoutingState.UNASSIGNED));
import java.util.Set;
                                req.totalTranslogOps(),
 * GitHub history for details.
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
        GroupShardsIterator shardIterators = state.getRoutingTable().activePrimaryShardsGrouped(new String[] { "test" }, false);
import java.util.stream.Collectors;
        assertThat(corruptedFile, notNullValue());
                if (routing.getId() == shardRouting.getId()) {
            .setIndices("test")
            .stream()
                dataNode.getNode().getName()
import java.util.TreeSet;
        assertEquals("Check index has a single failure", 1, checkIndexFailures.size());
import org.opensearch.common.io.stream.BytesStreamOutput;
    /**
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
        internalCluster().fullRestart();
     * to the replica. The file on disk stays uncorrupted
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
        Path corruptedFile = null;
            ShardRouting routing;
    protected Settings nodeSettings(int nodeOrdinal) {
        ensureGreen();
            logger.info(
                    for (Path path : findFilesToCorruptOnNode(store.getNode().getName(), shardId)) {
                            BytesRef bytesRef = req.content().toBytesRef();
        return corruptRandomPrimaryFile(true);
        for (int i = 0; i < builders.length; i++) {
            prepareCreate("test").setSettings(
import org.opensearch.core.common.unit.ByteSizeValue;
     * TODO once checksum verification on snapshotting is implemented this test needs to be fixed or split into several
    }
import org.apache.lucene.index.CheckIndex;
            SearchResponse response = client().prepareSearch().setSize(numDocs).get();
    }
            .put("index.routing.allocation.include._name", primariesNode.getNode().getName() + "," + unluckyNode.getNode().getName())
                .resolve(test.getUUID())
        NodeStats primariesNode = dataNodeStats.get(0);
                                                                                              // purpose
            )
    @Override
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
                                                                                                                                    // might
        client().prepareIndex("test").setSource("field", "value").execute();
        Collections.shuffle(dataNodeStats, random());
        // we have to flush at least once here since we don't corrupt the translog
import org.opensearch.cluster.routing.GroupShardsIterator;
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
                    }
        Set<Path> files = new TreeSet<>(); // treeset makes sure iteration order is deterministic
        logger.info("--> snapshot");
    }
import java.util.concurrent.ExecutionException;
                Settings.builder()
                    store.incRef();
                }
            Path file = PathUtils.get(path).resolve("indices/" + test.getUUID() + "/" + Integer.toString(routing.getId()) + "/index");
import org.opensearch.test.CorruptionUtils;
                    }
                        }
        // ensure that no shard is actually allocated on the unlucky node
        // This asserts this is the case, and then resets check index status.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
        ClusterState state = client().admin().cluster().prepareState().get().getState();
    }
                .prepareUpdateSettings()
        resetCheckIndexStatus();
            .filter(stat -> stat.getNode().isDataNode())
    }
        // close the shard.
import org.opensearch.monitor.fs.FsInfo;
            if (file.getFileName().toString().startsWith("corrupted_")) {
            .prepareCreateSnapshot("test-repo", "test-snap")
            .get();
 * Unless required by applicable law or agreed to in writing,
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false) // no checkindex - we corrupt shards on
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
            .put("index.routing.allocation.include._name", primaryNode.getNode().getName() + "," + replicaNode.getNode().getName())
                }
                final ShardId shardId = new ShardId(index, shards.getKey());
                        CheckIndex.Status status = store.checkIndex(out);
            }
                .cluster()
 *
                } else {
        for (Path path : internalCluster().getInstance(NodeEnvironment.class, nodeName).availableShardPaths(shardId)) {
        );
        ensureGreen();
     */
                    // no translog based flush - it might change the .liv / segments.N files
public class CorruptedFileIT extends OpenSearchIntegTestCase {
        CorruptionUtils.corruptFile(random(), files.toArray(new Path[0]));
            logger.info("--> cluster has [3] data nodes, corrupted primary will be overwritten");
        int numDocs = scaledRandomIntBetween(100, 1000);
        // enable allocation
        };
        ClusterState state = client().admin().cluster().prepareState().get().getState();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        ensureGreen();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 4)) // don't go crazy here it must recovery fast
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB))
            // and we need to make sure primaries are not just trashed if we don't have replicas
        ShardRouting shardRouting = shardIterator.nextOrNull();
        // currently in flight, and then block on a second latch that will
                    if (corrupt.get() && action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
        enableAllocation("test");
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            }
            .cluster()
                    // This does corrupt files on the replica, so we can't check:
            .put(super.nodeSettings(nodeOrdinal))
 *
        final CountDownLatch latch = new CountDownLatch(numShards * 3); // primary + 2 replicas
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB))
import org.apache.lucene.index.SegmentInfos;
                    for (Path item : stream) {
 */
 * compatible open source license.
/*
            .put("compress", randomBoolean())
        ensureGreen();
        indexRandom(true, builders);
            MockIndexEventListener.TestPlugin.class,
        assertAcked(
import org.opensearch.transport.client.Requests;
        final CountDownLatch corruptionHasHappened = new CountDownLatch(1);
                                                                                                                                    // flush
import java.io.PrintStream;
        );
                    assertThat(routing.state(), not(equalTo(ShardRoutingState.STARTED)));
            latch.await();
                        if (!status.clean) {
                }
        String nodeId = shardRouting.currentNodeId();
                .resolve(Integer.toString(shardRouting.getId()))
                        } else {
                        }
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        * we corrupted the primary shard - now lets make sure we never recover from it successfully
        createRepository("test-repo", "fs", settings);
                    indexingInFlight.countDown();
        // we don't corrupt segments.gen since S/R doesn't snapshot this file
        logger.info("--> shard {} has a corrupted file", shardRouting);
        ensureGreen();
                    assertThat(routing.state(), not(equalTo(ShardRoutingState.RELOCATING)));
     */
            public void afterIndexShardClosed(ShardId sid, @Nullable IndexShard indexShard, Settings indexSettings) {
            mockTransportService.addSendBehavior(
import org.opensearch.index.shard.IndexEventListener;
        assertAcked(
        for (FsInfo.Path info : nodeStatses.getNodes().get(0).getFs()) {
import java.util.Collection;
            for (MockIndexEventListener.TestEventListener eventListener : internalCluster().getDataNodeInstances(
                            return;
        return files;
            )
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        }
                                                                                                                                    // segments.N
        assertThat(routing.toString(), nodeStatses.getNodes().size(), equalTo(1));
        ensureGreen();
            )
     * replica.
        logger.info("-->  creating repository");
                            final byte[] array = req.content().toBytesRef().bytes;
            while ((routing = iterator.nextOrNull()) != null) {
                dataNodeStats.add(stat);
        );
            .prepareCreateSnapshot("test-repo", "test-snap")
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB)) // no
        for (MockIndexEventListener.TestEventListener eventListener : internalCluster().getDataNodeInstances(
            SearchResponse response = client().prepareSearch().setSize(numDocs).get();
        );
        }
            assertThat("timed out waiting for green state", actionGet.isTimedOut(), equalTo(false));
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).get());
                    // no checkindex - we corrupt shards on purpose
                        }
import org.opensearch.index.shard.IndexShard;
                }
            .prepareNodesStats(routing.currentNodeId())
                connection.sendRequest(requestId, action, request, options);
        assertTrue(
        for (NodeStats stat : nodeStats.getNodes()) {
    /**
        assertHitCount(countResponse, numDocs);
            );
            );
                    // no checkindex - we corrupt shards on purpose
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),
            logger.info("Cluster turned red in busy loop: {}", didClusterTurnRed);
            String path = info.getPath();
                    .put("index.routing.allocation.include._name", primaryNode.getNode().getName())
                client().admin().cluster().prepareState().get().getState(),
     * during recovery we don't know the version of the segments_N file because it has no segments we can take it from.
        // to capture replicas post restart)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(file)) {
        assertTrue(shardRouting.primary());
            }
        // we are green so primaries got not corrupted.
            .build();
        final Settings build = Settings.builder()
            prepareCreate("test").setSettings(
        return fileName.startsWith("segments") || fileName.endsWith(".liv");
import org.opensearch.common.lucene.Lucene;
                    }
        }
        // double flush to create safe commit in case of async durability
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
        } finally {
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),
            }
import java.nio.file.Files;
                                                                                                                                    // change
            ));
            .cluster()
                    .put("index.routing.allocation.include._name", primariesNode.getNode().getName())
    public void testCorruptionOnNetworkLayer() throws ExecutionException, InterruptedException {
            );
            .put("location", randomRepoPath().toAbsolutePath())
        ShardIterator shardIterator = RandomPicks.randomFrom(random(), iterators);
        int numDocs = scaledRandomIntBetween(100, 1000);
                .prepareUpdateSettings()
                        }
        // be released once the primary shard has been corrupted.
 */
                Settings.builder()
                    SegmentInfos segmentCommitInfos = Lucene.readSegmentInfos(dir);
import org.opensearch.test.OpenSearchIntegTestCase;
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 5)
        final CountDownLatch indexingInFlight = new CountDownLatch(1);
        assertHitCount(countResponse, numDocs);
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
     * Tests that we can actually recover from a corruption on the primary given that we have replica shards around.
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)
import org.opensearch.indices.recovery.FileChunkRequest;
            .get();
                        logger.info("Interrupted while waiting for corruption");
        final ShardRouting corruptedShardRouting = corruptRandomPrimaryFile();
        // corrupting a file, which causes the node to notice the corrupt data and
        if (cluster().numDataNodes() == 3) {
                )
            }
import java.nio.file.Path;
            .put("index.routing.allocation.include._name", "*")
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).execute().actionGet());
            .build();
        ensureYellow();
            }
    private int numShards(String... index) {
            .get();
        // finish in the PARTIAL state since the corrupted file will cause a checksum
        List<Path> files = new ArrayList<>();
    }
            )) {
        Index test = state.metadata().index("test").getIndex();
    public void testCorruptFileAndRecover() throws ExecutionException, InterruptedException, IOException {
            logger.info(
        assertHitCount(countResponse, numDocs);
        for (var shards : stores.getStoreStatuses().get(index.getName()).entrySet()) {
        assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));
                        FileChunkRequest req = (FileChunkRequest) request;
                .setPersistentSettings(
        // we have to flush at least once here since we don't corrupt the translog
        // After Lucene 9.9 check index will flag corruption with old (not the latest) commit points.
            assertThat("timed out waiting for green state", health.isTimedOut(), equalTo(false));
         */
                        corruptionHasHappened.await();
import org.opensearch.cluster.metadata.IndexMetadata;
 * ownership. Elasticsearch licenses this file to you under
                    if (includePerCommitFiles) {
                try (Directory dir = FSDirectory.open(file)) {
                .resolve("indices")
                    connection.sendRequest(requestId, action, request, options);
            return test == ClusterHealthStatus.RED;
        /*
     * This test verifies that if we corrupt a replica, we can still get to green, even though
        ensureGreen();
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                        if (commitInfo.getDelCount() + commitInfo.getSoftDelCount() == commitInfo.info.maxDoc()) {
        int numDocs = scaledRandomIntBetween(100, 1000);
                "ensureGreen timed out, cluster state:\n{}\n{}",
            logger.info(
        final int numIterations = scaledRandomIntBetween(5, 20);
        Settings build = Settings.builder()
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        /*
     * This test triggers a corrupt index exception during finalization size if an empty commit point is transferred
                Settings.builder()
        assertAcked(
        final SnapshotState snapshotState = createSnapshotResponse.getSnapshotInfo().state();
        NodesStatsResponse nodeStatses = client().admin().cluster().prepareNodesStats(nodeId).addMetric(FS.metricName()).get();
import org.opensearch.test.store.MockFSIndexStore;
            primaryNode.getNode().getName()
        for (Path file : files) {
                            logger.warn("check index [failure]\n{}", os.bytes().utf8ToString());
        GroupShardsIterator<ShardIterator> shardIterators = state.getRoutingTable()
import static org.hamcrest.Matchers.anyOf;
        createRepository("test-repo", "fs", settings);
import org.opensearch.cluster.health.ClusterHealthStatus;
                client().admin().cluster().preparePendingClusterTasks().get()
    private ShardRouting corruptRandomPrimaryFile(final boolean includePerCommitFiles) throws IOException {
        }
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
                        if (truncate && req.length() > 1) {
            client().admin()
                }
         * run the checkindex. if the corruption is still there we will catch it.
        final IndexEventListener listener = new IndexEventListener() {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                                req.recoveryId(),
        final CreateSnapshotResponse createSnapshotResponse = client().admin()
        assertAcked(
                break;
                        int i = randomIntBetween(0, req.content().length() - 1);
        if (health.isTimedOut()) {
    /**
            .collect(Collectors.toUnmodifiableList());
                Settings.builder()
                                req.metadata(),
        final Index index = resolveIndex("test");
        for (int i = 0; i < numIterations; i++) {
import java.io.OutputStream;
                            int i = randomIntBetween(0, req.content().length() - 1);
                client().admin().cluster().preparePendingClusterTasks().get()
        }
                    Settings.builder().putNull(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey())
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).get());
                Settings.builder()
 * under the License.
        }
        }
import java.io.IOException;
        // .liv and segments_N are per commit files and might change after corruption
        final MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
        )) {
            prepareCreate("test").setSettings(
 * license agreements. See the NOTICE file distributed with
                        hasCorrupted.countDown();
                    }
            assertThat(exception, empty());
                    // no translog based flush - it might change the .liv / segments.N files
        }
            .cluster()
            }
        ensureGreen();
                corruptedFile = file;
import org.opensearch.common.settings.Settings;
import org.opensearch.core.index.Index;
        // Unblock the blocked indexing thread now that corruption on the primary has been confirmed
     */
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
            )
            .cluster()
                }
            }
        internalCluster().ensureAtLeastNumDataNodes(2);
        NodeStats unluckyNode = dataNodeStats.get(1);
            ));
                                req.sourceThrottleTimeInNanos()
                "cluster state:\n{}\n{}",
     */
    public List<Path> listShardFiles(ShardRouting routing) throws IOException {
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
 * this file be licensed under the Apache-2.0 license or a
        final CountDownLatch hasCorrupted = new CountDownLatch(1);
            prepareCreate("test").setSettings(
        corruptionHasHappened.countDown();
import java.util.Collections;
        assertTrue(shardRouting.assignedToNode());
 * You may obtain a copy of the License at
import org.opensearch.cluster.routing.ShardRouting;
        final int numIterations = scaledRandomIntBetween(5, 20);
            MockTransportService.TestPlugin.class,
        );
                            );
        internalCluster().ensureAtLeastNumDataNodes(2);
            path = path.resolve("index");
        indexRandom(true, builders);
        ClusterHealthResponse actionGet = client().admin()
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
        }
import org.opensearch.core.index.shard.ShardId;
                eventListener.setNewDelegate(null);
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
        }
                }
                )
        Settings.Builder settings = Settings.builder()
            .setWaitForCompletion(true)
        for (int i = 0; i < numIterations; i++) {
        ShardRouting shardRouting = corruptRandomPrimaryFile(false);
 * The OpenSearch Contributors require contributions made to
     * Tests corruption that happens on a single shard when no replicas are present. We make sure that the primary stays unassigned
        internalCluster().ensureAtLeastNumDataNodes(2);
            internalCluster().getInstance(TransportService.class, replicaNode.getNode().getName()),
import static org.hamcrest.Matchers.is;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
            );
        NodesStatsResponse nodeStatses = client().admin()
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        internalCluster().ensureAtLeastNumDataNodes(2);
    }
}
import org.opensearch.snapshots.SnapshotState;
                                                                                                                                    // the
        MatcherAssert.assertThat("Expect file corruption to cause PARTIAL snapshot state", snapshotState, equalTo(SnapshotState.PARTIAL));
                (connection, requestId, action, request, options) -> {
        boolean didClusterTurnRed = waitUntil(() -> {
        // Configure the modified data node as a replica
        for (int i = 0; i < builders.length; i++) {
 * this work for additional information regarding copyright
                                req.position(),
        final NodeStats replicaNode = dataNodeStats.get(1);
        try {
            String path = info.getPath();
import org.opensearch.index.IndexSettings;
        // disable allocations of replicas post restart (the restart will change replicas to primaries, so we have
        ensureGreen();
                    .put("index.allocation.max_retries", Integer.MAX_VALUE) // keep on retrying
        }
        final AtomicBoolean corrupt = new AtomicBoolean(true);
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
                (connection, requestId, action, request, options) -> {
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
                if (store.getAllocationStatus().equals(IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED)) {
        logger.info("--> {} corrupted", corruptedShardRouting);
    }
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB))
            )
    private static boolean isPerCommitFile(String fileName) {
import static org.hamcrest.Matchers.empty;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0") // no replicas for this test
            builders[i] = client().prepareIndex("test").setSource("field", "value");
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo(SnapshotState.PARTIAL));
        return Arrays.asList(
    }
            assertHitCount(response, numDocs);
        List<ShardIterator> iterators = iterableAsArrayList(shardIterators);
    /**
            if (file.getFileName().toString().startsWith("corrupted_")) {
        return shardRouting;
                    } catch (Exception e) {
        for (IndexShardRoutingTable table : clusterStateResponse.getState().getRoutingTable().index("test")) {
    /**
                        byte[] array = BytesRef.deepCopyOf(req.content().toBytesRef()).bytes;
        final CopyOnWriteArrayList<Exception> exception = new CopyOnWriteArrayList<>();
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
import org.opensearch.plugins.Plugin;
            if (stat.getNode().isDataNode()) {
        Path corruptedFile = null;
                                req.lastChunk(),
    /**
        GroupShardsIterator shardIterators = state.getRoutingTable().activePrimaryShardsGrouped(index, false);
import java.nio.file.DirectoryStream;
import org.apache.lucene.util.BytesRef;
            eventListener.setNewDelegate(listener);
     * Tests corruption that happens on the network layer and that the primary does not get affected by corruption that happens on the way
        );
        for (int i = 0; i < builders.length; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // Assert the cluster returns to green status because the replica will be promoted to primary
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertAcked(
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
        );
            .activePrimaryShardsGrouped(new String[] { "test" }, false);
        final Index test = state.metadata().index("test").getIndex();
                        }
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(response.getStatus(), is(ClusterHealthStatus.RED));
import org.opensearch.index.MergePolicyProvider;
import java.util.ArrayList;
        */
        assertAcked(
        // it snapshots and that will write a new segments.X+1 file
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    }
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).execute().actionGet());
        // double flush to create safe commit in case of async durability
        final List<NodeStats> dataNodeStats = nodeStats.getNodes()
        Settings build = Settings.builder()
        ensureGreen();
 * SPDX-License-Identifier: Apache-2.0
            if (Files.exists(path)) { // multi data path might only have one path in use
            .build();
            }
        }, 5, TimeUnit.MINUTES);// sometimes on slow nodes the replication / recovery is just dead slow
     */
import java.util.concurrent.atomic.AtomicBoolean;
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
        for (FsInfo.Path info : nodeStatses.getNodes().get(0).getFs()) {
                Settings.builder()
            builders[i] = client().prepareIndex("test").setSource("field", "value");
import org.opensearch.common.io.PathUtils;
            @Override
import org.opensearch.action.support.replication.TransportReplicationAction;
            Path file = PathUtils.get(path)
        if (response.getStatus() != ClusterHealthStatus.RED) {
import org.opensearch.env.NodeEnvironment;
        hasCorrupted.await();
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
        for (int i = 0; i < builders.length; i++) {
                        store.decRef();
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).execute().actionGet());
            }
        );
        Collections.shuffle(dataNodeStats, random());
            if (Files.exists(file)) { // multi data path might only have one path in use
                                                                                                                                    // based
        ensureGreen();
        final CreateSnapshotResponse createSnapshotResponse = client().admin()
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
 *    http://www.apache.org/licenses/LICENSE-2.0
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 5)
                    for (Path item : stream) {
import static org.hamcrest.Matchers.notNullValue;
                        latch.countDown();
            // speed up recoveries
            ClusterHealthStatus test = client().admin().cluster().health(Requests.clusterHealthRequest("test")).actionGet().getStatus();
        final List<Path> files = listShardFiles(shardRouting);
import static org.opensearch.core.common.util.CollectionUtils.iterableAsArrayList;
        }
                        FileChunkRequest req = (FileChunkRequest) request;
            prepareCreate("test").setSettings(
        indexRandom(true, builders);
        ensureGreen(); // allocated with empty commit
 * specific language governing permissions and limitations
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                .setPersistentSettings(
            .actionGet();
        // validation failure.
            }
import org.opensearch.cluster.routing.ShardRoutingState;
                }
                dataNode.getNode().getName()
                if (request instanceof TransportReplicationAction.ConcreteShardRequest) {
            mockTransportService.addSendBehavior(
                    } catch (InterruptedException e) {
            );
        NodeStats unluckyNode = dataNodeStats.get(1);
                            throw new IOException("index check failure");
        }
        internalCluster().ensureAtLeastNumDataNodes(2);
        ensureGreen();
        );
            .health(Requests.clusterHealthRequest("test").waitForGreenStatus())
import org.opensearch.index.shard.IndexShardState;
                            request = new FileChunkRequest(
        ensureGreen(TimeValue.timeValueSeconds(60));
            .addMetric(FS.metricName())
 *
        return files;
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "primaries")
    public void testCorruptFileThenSnapshotAndRestore() throws ExecutionException, InterruptedException, IOException {
                    .waitForNoRelocatingShards(true)
        assertAcked(
    private List<Path> findFilesToCorruptOnNode(final String nodeName, final ShardId shardId) throws IOException {
        }
                    }
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
        final List<Path> files = listShardFiles(shardRouting);
     * Tests that restoring of a corrupted shard fails and we get a partial snapshot.
        final IndicesShardStoresResponse stores = client().admin().indices().prepareShardStores(index.getName()).get();
     */
            prepareCreate("test").setSettings(
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
                            BytesArray array = new BytesArray(bytesRef.bytes, bytesRef.offset, (int) req.length() - 1);
import java.util.concurrent.CopyOnWriteArrayList;
                        out.flush();
                if (indexShard != null) {
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
                        exception.add(e);
            }
                            continue;
        }
        ensureGreen();
         * now hook into the IndicesService and register a close listener to
                    .timeout("5m") // sometimes due to cluster rebalacing and random settings default timeout is just not enough.
                            // don't corrupt fully deleted segments - they might be removed on snapshot
                .cluster()
                        }
import org.hamcrest.MatcherAssert;
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)
                .resolve("index");
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
import org.apache.lucene.index.SegmentCommitInfo;
        // count down a latch to indicate that a replication operation is
import org.opensearch.test.MockIndexEventListener;
            builders[i] = client().prepareIndex("test").setSource("field", "value");
                Requests.clusterHealthRequest("test")
        mockTransportService.addSendBehavior(
                        for (String commitFile : commitInfo.files()) {
                MockIndexEventListener.TestEventListener.class
        );
import static org.hamcrest.Matchers.equalTo;
            for (IndicesShardStoresResponse.StoreStatus store : shards.getValue()) {
                        try (OutputStream os = Files.newOutputStream(path)) {
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
                                                                                                                                    // /
                TransportService.class,
        if (cluster().numDataNodes() < 3) {
    }
        }
        }
        }
                    try {
        }
                                                                                                                                    // translog
        // we have to flush at least once here since we don't corrupt the translog
        // For this test our previous corrupt commit "segments_2" will remain on the primary.
        assertAcked(
/*
            .cluster()
        assertThat(corruptedFile, notNullValue());
    public void testCorruptPrimaryNoReplica() throws ExecutionException, InterruptedException, IOException {
                TransportService.class,
        ShardRouting shardRouting = corruptRandomPrimaryFile();
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
        // we have to flush at least once here since we don't corrupt the translog
            prepareCreate("test").setSettings(
            .actionGet();
        List<NodeStats> dataNodeStats = new ArrayList<>();
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
 * the Apache License, Version 2.0 (the "License"); you may
                        files.add(file.resolve(segmentCommitInfos.getSegmentsFileName()));
            )
        logger.info("--> snapshot terminated with state " + snapshotState);
 * software distributed under the License is distributed on an
                    connection.sendRequest(requestId, action, request, options);
            .build();
        // Corrupt a file on the primary then take a snapshot. Snapshot should
    public void testCorruptionOnNetworkLayerFinalizingRecovery() throws ExecutionException, InterruptedException, IOException {
        }
                            os.write(0);
        }
        // Add custom send behavior between primary and replica that will
        return shardIterators.size();
import static org.hamcrest.Matchers.not;
                "cluster state:\n{}\n{}",
        ));
import org.opensearch.common.Nullable;
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
                    } finally {
                        array[i] = (byte) ~array[i]; // flip one byte in the content
        int numDocs = scaledRandomIntBetween(100, 1000);
        );
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        client().admin().cluster().prepareReroute().get();
 * Licensed to Elasticsearch under one or more contributor
                        }
                            if (includePerCommitFiles || isPerSegmentFile(commitFile)) {
/*
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, cluster().numDataNodes() - 1)
        NodeStats primariesNode = dataNodeStats.get(0);
import org.opensearch.action.index.IndexRequestBuilder;
        for (int i = 0; i < builders.length; i++) {
 */
    private ShardRouting corruptRandomPrimaryFile() throws IOException {
            builders[i] = client().prepareIndex("test").setSource("field", "value");
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;
                            assert req.content().toBytesRef().bytes == req.content().toBytesRef().bytes : "no internal reference!!";
        internalCluster().ensureAtLeastNumDataNodes(2);
            MockIndexEventListener.TestEventListener.class
import java.util.Arrays;
                        files.add(item);
                Settings.builder()
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
            .health(
            client().admin().indices().prepareDelete("test").get();
        Settings.Builder settings = Settings.builder()
import org.opensearch.core.common.bytes.BytesArray;
                    // no translog based flush - it might change the .liv / segments.N files
        assertNotNull(shardRouting);
        List<NodeStats> dataNodeStats = new ArrayList<>();
        return isPerCommitFile(fileName) == false;
        /*
    private static boolean isPerSegmentFile(String fileName) {
                                array,
                    .waitForGreenStatus()
        List<Path> files = new ArrayList<>();
                    for (SegmentCommitInfo commitInfo : segmentCommitInfos) {
        assertHitCount(countResponse, numDocs);
        // the other problem here why we can't corrupt segments.X files is that the snapshot flushes again before
        for (NodeStats dataNode : dataNodeStats) {
    public void testPrimaryCorruptionDuringReplicationDoesNotFailReplicaShard() throws Exception {
        assertThat(cluster().numDataNodes(), greaterThanOrEqualTo(3));
                    .put("index.allocation.max_retries", Integer.MAX_VALUE) // keep on retrying
        Settings build = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1").build();
        client().admin().cluster().prepareReroute().get();
import org.opensearch.transport.TransportService;
                                req.requestSeqNo(),
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            builders[i] = client().prepareIndex("test").setSource("field", "value");
        return Settings.builder()
                                                                                              // purpose
                                                                                                                                    // .liv
    public void testReplicaCorruption() throws Exception {
            TransportService.class,
                    }
                dataNodeStats.add(stat);
        final NodeStats primaryNode = dataNodeStats.get(0);
        }
        for (NodeStats stat : nodeStats.getNodes()) {
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.FS;
        }
            for (ShardRouting routing : table) {
                                                                                                                                    // files
        for (Path file : files) {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
import org.opensearch.test.InternalSettingsPlugin;
            MockFSIndexStore.TestPlugin.class,
    @Override
            }
        final boolean truncate = randomBoolean();
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        }
     * listing its store fails. Note, we need to make sure that replicas are allocated on all data
        assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
                if (unluckyNode.getNode().getId().equals(routing.currentNodeId())) {
         */
    }
    }
        final ClusterHealthResponse response = client().admin().cluster().health(Requests.clusterHealthRequest("test")).get();
                    .put("index.routing.allocation.include._name", primariesNode.getNode().getName())
import org.opensearch.cluster.routing.ShardIterator;
        // have enough space for 3 copies
                    assertThat(routing.state(), anyOf(equalTo(ShardRoutingState.RELOCATING), equalTo(ShardRoutingState.STARTED)));
        ShardRouting corruptedShardRouting = corruptRandomPrimaryFile();
        );
        disableAllocation("test");
        final int numShards = numShards("test");
            (connection, requestId, action, request, options) -> {
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
     * nodes, so that replica won't be sneaky and allocated on a node that doesn't have a corrupted
import java.util.concurrent.CountDownLatch;
    }
        indexingInFlight.await();
                        logger.info("corrupting file {} on node {}", path, store.getNode().getName());
 * KIND, either express or implied.  See the License for the
                        if (!Lucene.indexExists(store.directory()) && indexShard.state() == IndexShardState.STARTED) {
                    }
            client().admin()
                .getMessage()
import java.util.List;
            if (stat.getNode().isDataNode()) {
        int numDocs = scaledRandomIntBetween(100, 1000);
                            files.add(item);
     * we also check if the primary is ok. Without the relevant checks this test fails with a RED cluster
                    try {
        Settings build = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "2").build();
            .put("location", randomRepoPath().toAbsolutePath())
import org.opensearch.common.unit.TimeValue;
        client().admin().cluster().prepareReroute().get();
        ClusterHealthResponse health = client().admin()
        indexRandom(true, builders);
        internalCluster().ensureAtLeastNumDataNodes(3);
                                req.shardId(),
                                files.add(file.resolve(commitFile));
import org.opensearch.cluster.ClusterState;
     * parts... We should also corrupt files on the actual snapshot and check that we don't restore the corrupted shard.
        final SnapshotState snapshotState = createSnapshotResponse.getSnapshotInfo().state();
