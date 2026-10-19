        }  
 */
        ensureGreen();  
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
     * This test verifies that if we corrupt a replica, we can still get to green, even though
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)  
        for (int i = 0; i < builders.length; i++) {  
        List<NodeStats> dataNodeStats = new ArrayList<>();  
import java.nio.charset.StandardCharsets;
                }
                    } finally {
import org.opensearch.index.MergePolicyProvider;
        // disable allocations of replicas post restart (the restart will change replicas to primaries, so we have
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                    } catch (Exception e) {
                client().admin().cluster().preparePendingClusterTasks().get()
        NodeStats primariesNode = dataNodeStats.get(0);  
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
        client().prepareIndex("test").setSource("field", "value").execute();
        // we have to flush at least once here since we don't corrupt the translog
                    if (corrupt.get() && action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {  
        logger.info("--> snapshot terminated with state " + snapshotState);
         */
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            .health(
        }
            // we really need local GW here since this also checks for corruption etc.  
                                req.metadata(),
        final IndexEventListener listener = new IndexEventListener() {
import java.util.concurrent.atomic.AtomicBoolean;
        }
                        FileChunkRequest req = (FileChunkRequest) request;
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
        }
        final SnapshotState snapshotState = createSnapshotResponse.getSnapshotInfo().state();
import static org.hamcrest.Matchers.not;  
    }  
        final MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(  
            .put("location", randomRepoPath().toAbsolutePath())
            .addMetric(FS.metricName())
                            // don't corrupt fully deleted segments - they might be removed on snapshot
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
    }
     * This simulates recoveries from old indices or even without checksums and makes sure if we fail during finalization  
        return shardIterators.size();  
        Settings build = Settings.builder()  
            for (IndicesShardStoresResponse.StoreStatus store : shards.getValue()) {  
            assertHitCount(response, numDocs);
            }
        internalCluster().ensureAtLeastNumDataNodes(2);
                                array,
        }
public class CorruptedFileIT extends OpenSearchIntegTestCase {
            logger.info(  
        assertAcked(
        final AtomicBoolean corrupt = new AtomicBoolean(true);
        // finish in the PARTIAL state since the corrupted file will cause a checksum
                final ShardId shardId = new ShardId(index, shards.getKey());
                dataNodeStats.add(stat);
            .prepareCreateSnapshot("test-repo", "test-snap")
        // it snapshots and that will write a new segments.X+1 file
                )
        assertAcked(  
import org.opensearch.action.search.SearchResponse;  
        ensureGreen();
        }
     * nodes, so that replica won't be sneaky and allocated on a node that doesn't have a corrupted  
            }
    }
        final List<NodeStats> dataNodeStats = nodeStats.getNodes()
                                req.position(),  
        ShardRouting corruptedShardRouting = corruptRandomPrimaryFile();  
                    SegmentInfos segmentCommitInfos = Lucene.readSegmentInfos(dir);
}
            }
    private int numShards(String... index) {  
            Path file = PathUtils.get(path)  
     * listing its store fails. Note, we need to make sure that replicas are allocated on all data
                            assert req.content().toBytesRef().bytes == req.content().toBytesRef().bytes : "no internal reference!!";
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        MatcherAssert.assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));  
        }
            if (stat.getNode().isDataNode()) {
            .setWaitForCompletion(true)
            (connection, requestId, action, request, options) -> {  
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),  
                client().admin().cluster().prepareState().get().getState(),
        ensureGreen();
            // speed up recoveries  
                .getMessage()  
    }  
        return files;
        // Add custom send behavior between primary and replica that will  
        logger.info("--> snapshot");  
    private static boolean isPerCommitFile(String fileName) {  
        // Assert the cluster returns to green status because the replica will be promoted to primary  
            @Override  
                client().admin().cluster().prepareState().get().getState(),
                    }
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB))
            SearchResponse response = client().prepareSearch().setSize(numDocs).get();
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 5)
                    assertThat(routing.state(), not(equalTo(ShardRoutingState.STARTED)));  
                    .put("index.routing.allocation.include._name", primaryNode.getNode().getName())
import org.opensearch.index.IndexSettings;  
    /**
 * this work for additional information regarding copyright
        final CreateSnapshotResponse createSnapshotResponse = client().admin()  
        );
     * This test triggers a corrupt index exception during finalization size if an empty commit point is transferred
        }
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 5)
        }  
            .cluster()  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, cluster().numDataNodes() - 1)
        assertTrue(shardRouting.assignedToNode());  
            Path file = PathUtils.get(path).resolve("indices/" + test.getUUID() + "/" + Integer.toString(routing.getId()) + "/index");  
        // currently in flight, and then block on a second latch that will
                }
            .cluster()
                .resolve(test.getUUID())
                Settings.builder()
                                req.totalTranslogOps(),  
                    try {
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();  
        assertAcked(
        Collections.shuffle(dataNodeStats, random());
        client().admin().cluster().prepareReroute().get();  
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
                try (Directory dir = FSDirectory.open(file)) {  
        /*
        // close the shard.  
            assertThat("timed out waiting for green state", actionGet.isTimedOut(), equalTo(false));
        // Configure the modified data node as a replica
            logger.info("Cluster turned red in busy loop: {}", didClusterTurnRed);
                        if (commitInfo.getDelCount() + commitInfo.getSoftDelCount() == commitInfo.info.maxDoc()) {  
        List<Path> files = new ArrayList<>();  
            assertHitCount(response, numDocs);
            public void afterIndexShardClosed(ShardId sid, @Nullable IndexShard indexShard, Settings indexSettings) {
            );  
        NodesStatsResponse nodeStatses = client().admin().cluster().prepareNodesStats(nodeId).addMetric(FS.metricName()).get();
        for (var shards : stores.getStoreStatuses().get(index.getName()).entrySet()) {
import org.opensearch.test.store.MockFSIndexStore;
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
                internalCluster().getInstance(TransportService.class, unluckyNode.getNode().getName()),
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, between(1, 4)) // don't go crazy here it must recovery fast
            }  
                                                                                              // purpose
                                req.sourceThrottleTimeInNanos()
        for (NodeStats stat : nodeStats.getNodes()) {
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
        final List<Path> files = listShardFiles(shardRouting);  
import org.hamcrest.MatcherAssert;  
import org.apache.lucene.store.FSDirectory;  
                            array[i] = (byte) ~array[i]; // flip one byte in the content
     */
            .put(super.nodeSettings(nodeOrdinal))
                        files.add(item);
            )
        );  
            .setIndices("test")
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).get());
                (connection, requestId, action, request, options) -> {
        }  
        assertTrue(shardRouting.primary());
    @Override  
        ensureGreen();
                        FileChunkRequest req = (FileChunkRequest) request;  
    public void testCorruptionOnNetworkLayerFinalizingRecovery() throws ExecutionException, InterruptedException, IOException {  
                        files.add(file.resolve(segmentCommitInfos.getSegmentsFileName()));  
            )) {  
     * TODO once checksum verification on snapshotting is implemented this test needs to be fixed or split into several  
        );  
        Settings build = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "2").build();  
        );
import java.io.IOException;
        List<Path> files = new ArrayList<>();
            )  
import java.util.TreeSet;  
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        ensureGreen();
            builders[i] = client().prepareIndex("test").setSource("field", "value");  
        }  
                        for (String commitFile : commitInfo.files()) {
     */  
                connection.sendRequest(requestId, action, request, options);  
        if (response.getStatus() != ClusterHealthStatus.RED) {  
                        }
/*  
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).execute().actionGet());
            logger.info(
                        out.flush();  
        final Settings build = Settings.builder()
            .build();
        // to capture replicas post restart)
                        array[i] = (byte) ~array[i]; // flip one byte in the content
        CorruptionUtils.corruptFile(random(), files.toArray(new Path[0]));
     * Tests that we can actually recover from a corruption on the primary given that we have replica shards around.
            .prepareNodesStats(routing.currentNodeId())  
            logger.info(
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
                    for (Path item : stream) {  
        ensureGreen();
import org.opensearch.core.index.Index;  
        try {
                    assertThat(routing.state(), not(equalTo(ShardRoutingState.RELOCATING)));
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.test.MockIndexEventListener;  
        );
                )  
                Settings.builder()  
            return test == ClusterHealthStatus.RED;
            )  
                break;
            .put("index.routing.allocation.include._name", "*")
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false) // no checkindex - we corrupt shards on
import org.opensearch.core.common.bytes.BytesArray;  
                Settings.builder()
                                req.shardId(),
            MockIndexEventListener.TestPlugin.class,
            .put("location", randomRepoPath().toAbsolutePath())
                        int i = randomIntBetween(0, req.content().length() - 1);  
            MockFSIndexStore.TestPlugin.class,
            .put("compress", randomBoolean())
import java.util.concurrent.ExecutionException;  
        NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.Requests;
         */  
                                                                                                                                    // the  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        assertHitCount(countResponse, numDocs);
        Settings.Builder settings = Settings.builder()  
            .put("compress", randomBoolean())  
import org.apache.lucene.index.SegmentInfos;
        NodeStats primariesNode = dataNodeStats.get(0);
        assertAcked(
        for (Path file : files) {  
import org.opensearch.cluster.health.ClusterHealthStatus;  
                        }  
            prepareCreate("test").setSettings(  
        for (int i = 0; i < builders.length; i++) {
            ));
                    for (Path path : findFilesToCorruptOnNode(store.getNode().getName(), shardId)) {  
            .build();  
    protected Settings nodeSettings(int nodeOrdinal) {
                            if (includePerCommitFiles || isPerSegmentFile(commitFile)) {
                        CheckIndex.Status status = store.checkIndex(out);
            // and we need to make sure primaries are not just trashed if we don't have replicas
    }
        GroupShardsIterator<ShardIterator> shardIterators = state.getRoutingTable()
                        if (!Lucene.indexExists(store.directory()) && indexShard.state() == IndexShardState.STARTED) {  
        ensureGreen();  
        // we have to flush at least once here since we don't corrupt the translog  
                client().admin().cluster().preparePendingClusterTasks().get()
                    }
import org.opensearch.monitor.fs.FsInfo;
        Set<Path> files = new TreeSet<>(); // treeset makes sure iteration order is deterministic  
                }  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
        ensureGreen();  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
        }
                    // no translog based flush - it might change the .liv / segments.N files
                .prepareUpdateSettings()  
                                req.recoveryId(),
        );
            .setIndices("test")
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
                            );
    public void testCorruptFileAndRecover() throws ExecutionException, InterruptedException, IOException {
        final NodesStatsResponse nodeStats = client().admin().cluster().prepareNodesStats().get();
import java.io.PrintStream;
            )
        assertThat(cluster().numDataNodes(), greaterThanOrEqualTo(3));  
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);
            .activePrimaryShardsGrouped(new String[] { "test" }, false);
        return fileName.startsWith("segments") || fileName.endsWith(".liv");
        logger.info("--> {} corrupted", corruptedShardRouting);
import org.opensearch.core.common.unit.ByteSizeValue;
        GroupShardsIterator shardIterators = state.getRoutingTable().activePrimaryShardsGrouped(index, false);
                        }
                Requests.clusterHealthRequest("test")
        int numDocs = scaledRandomIntBetween(100, 1000);
                    // no translog based flush - it might change the .liv / segments.N files  
                corruptedFile = file;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.env.NodeEnvironment;
        client().admin().cluster().prepareReroute().get();
        assertThat(corruptedFile, notNullValue());  
        return isPerCommitFile(fileName) == false;  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        NodeStats unluckyNode = dataNodeStats.get(1);
                            BytesRef bytesRef = req.content().toBytesRef();
            if (Files.exists(file)) { // multi data path might only have one path in use
     * to the replica. The file on disk stays uncorrupted
                    .put("index.routing.allocation.include._name", primariesNode.getNode().getName())
            assertThat(exception, empty());
                        logger.info("Interrupted while waiting for corruption");  
 * specific language governing permissions and limitations
     */
            .actionGet();
                            throw new IOException("index check failure");  
        // corrupting a file, which causes the node to notice the corrupt data and
import java.util.List;
        assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));
 */
        for (FsInfo.Path info : nodeStatses.getNodes().get(0).getFs()) {
        assertHitCount(countResponse, numDocs);  
        GroupShardsIterator shardIterators = state.getRoutingTable().activePrimaryShardsGrouped(new String[] { "test" }, false);  
            client().admin().indices().prepareDelete("test").get();  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0") // no replicas for this test
                            files.add(item);
        }
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).get());  
     * Tests corruption that happens on a single shard when no replicas are present. We make sure that the primary stays unassigned
            while ((routing = iterator.nextOrNull()) != null) {
        for (int i = 0; i < numIterations; i++) {  
    @Override  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")  
            .cluster()
        final List<Path> files = listShardFiles(shardRouting);
import org.opensearch.plugins.Plugin;
        for (NodeStats dataNode : dataNodeStats) {  
        );  
        ensureGreen(); // allocated with empty commit
        final Index index = resolveIndex("test");
import org.apache.lucene.util.BytesRef;
        }
                    }
                    .put("index.routing.allocation.include._name", primariesNode.getNode().getName())
        // be released once the primary shard has been corrupted.  
        return corruptRandomPrimaryFile(true);  
                if (routing.getId() == shardRouting.getId()) {  
    public void testCorruptPrimaryNoReplica() throws ExecutionException, InterruptedException, IOException {
            }  
            prepareCreate("test").setSettings(
            .filter(stat -> stat.getNode().isDataNode())
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (indexShard != null) {
import org.opensearch.common.Nullable;  
import org.opensearch.indices.recovery.PeerRecoveryTargetService;  
        }
        final Index test = state.metadata().index("test").getIndex();
        internalCluster().fullRestart();  
     * parts... We should also corrupt files on the actual snapshot and check that we don't restore the corrupted shard.
            if (Files.exists(file)) { // multi data path might only have one path in use
                                                                                              // purpose
        assertThat(corruptedFile, notNullValue());  
        }
                    }  
        indexingInFlight.await();
        assertAcked(
        NodeStats unluckyNode = dataNodeStats.get(1);
        disableAllocation("test");  
                break;  
        Settings build = Settings.builder()  
                            }
    /**
        if (cluster().numDataNodes() < 3) {  
        if (cluster().numDataNodes() == 3) {
            .build();  
import org.apache.lucene.index.CheckIndex;
        indexRandom(true, builders);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                            os.write(0);
        return files;  
import org.opensearch.common.io.PathUtils;
                    .waitForNoRelocatingShards(true)
        final int numShards = numShards("test");
            if (stat.getNode().isDataNode()) {  
                    // no translog based flush - it might change the .liv / segments.N files
                        store.decRef();
            InternalSettingsPlugin.class  
        // ensure that no shard is actually allocated on the unlucky node
                    connection.sendRequest(requestId, action, request, options);
import java.io.OutputStream;  
        Index test = state.metadata().index("test").getIndex();
                                                                                                                                    // flush
import static org.opensearch.core.common.util.CollectionUtils.iterableAsArrayList;  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
        }
 * You may obtain a copy of the License at  
         * run the checkindex. if the corruption is still there we will catch it.
        // This asserts this is the case, and then resets check index status.
                        latch.countDown();  
                dataNode.getNode().getName()
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.test.CorruptionUtils;
                Settings.builder()  
        ShardRouting shardRouting = corruptRandomPrimaryFile();  
import org.opensearch.action.support.replication.TransportReplicationAction;
/*
            ClusterHealthStatus test = client().admin().cluster().health(Requests.clusterHealthRequest("test")).actionGet().getStatus();  
        createRepository("test-repo", "fs", settings);
        final SnapshotState snapshotState = createSnapshotResponse.getSnapshotInfo().state();  
 * under the License.  
     * we also check if the primary is ok. Without the relevant checks this test fails with a RED cluster
        for (NodeStats dataNode : dataNodeStats) {
    private ShardRouting corruptRandomPrimaryFile() throws IOException {
            .get();
     * Tests corruption that happens on the network layer and that the primary does not get affected by corruption that happens on the way  
                .cluster()
        internalCluster().ensureAtLeastNumDataNodes(2);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
            ));
            if (file.getFileName().toString().startsWith("corrupted_")) {  
                                                                                                                                    // based
        enableAllocation("test");
            .put("index.routing.allocation.include._name", primaryNode.getNode().getName() + "," + replicaNode.getNode().getName())
        // we have to flush at least once here since we don't corrupt the translog
                MockIndexEventListener.TestEventListener.class
     */
                            int i = randomIntBetween(0, req.content().length() - 1);  
                            final byte[] array = req.content().toBytesRef().bytes;
 * ownership. Elasticsearch licenses this file to you under  
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)  
            .cluster()
                        }
        resetCheckIndexStatus();  
    }  
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
                    .put("index.allocation.max_retries", Integer.MAX_VALUE) // keep on retrying  
        ClusterHealthResponse actionGet = client().admin()  
        }
import java.util.ArrayList;  
                if (request instanceof TransportReplicationAction.ConcreteShardRequest) {
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
        // enable allocation
        }
        assertThat(response.getStatus(), is(ClusterHealthStatus.RED));
                }
            for (MockIndexEventListener.TestEventListener eventListener : internalCluster().getDataNodeInstances(
import org.opensearch.common.unit.TimeValue;
 *
            );  
            if (Files.exists(path)) { // multi data path might only have one path in use
    }  
        for (FsInfo.Path info : nodeStatses.getNodes().get(0).getFs()) {
        assertThat(createSnapshotResponse.getSnapshotInfo().state(), equalTo(SnapshotState.PARTIAL));
            .put("index.routing.allocation.include._name", primariesNode.getNode().getName() + "," + unluckyNode.getNode().getName())
                        hasCorrupted.countDown();
 */  
                        if (truncate && req.length() > 1) {
        final NodeStats replicaNode = dataNodeStats.get(1);  
        Path corruptedFile = null;
            .put("chunk_size", randomIntBetween(100, 1000), ByteSizeUnit.BYTES);  
            .prepareCreateSnapshot("test-repo", "test-snap")  
        assertHitCount(countResponse, numDocs);
            prepareCreate("test").setSettings(
        /*  
        for (int i = 0; i < builders.length; i++) {
import java.util.Collections;  
        hasCorrupted.await();  
            String path = info.getPath();
            )
        */
        assertThat(health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        ClusterHealthResponse health = client().admin()
import org.opensearch.core.index.shard.ShardId;
            )
            }
        // we have to flush at least once here since we don't corrupt the translog
import org.opensearch.test.OpenSearchIntegTestCase;
            );
        final CountDownLatch indexingInFlight = new CountDownLatch(1);
import org.opensearch.test.InternalSettingsPlugin;
            }
                "ensureGreen timed out, cluster state:\n{}\n{}",  
import org.opensearch.cluster.routing.ShardRouting;
        }  
import java.util.stream.Collectors;  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                client().admin().cluster().prepareState().get().getState(),
import com.carrotsearch.randomizedtesting.generators.RandomPicks;  
                TransportService.class,  
                                                                                                                                    // - it  
                .resolve(Integer.toString(shardRouting.getId()))  
                                req.requestSeqNo(),  
        for (Path path : internalCluster().getInstance(NodeEnvironment.class, nodeName).availableShardPaths(shardId)) {
 * Modifications Copyright OpenSearch Contributors. See  
                    .timeout("5m") // sometimes due to cluster rebalacing and random settings default timeout is just not enough.
            latch.await();
        assertTrue(
        indexRandom(true, builders);
    }
            }
                }
            checkIndexFailures.get(0)
        Path corruptedFile = null;
     * replica.
import static org.hamcrest.Matchers.is;
        final boolean truncate = randomBoolean();
    }
                }  
                        }  
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(file)) {
        logger.info("-->  creating repository");
            eventListener.setNewDelegate(listener);  
        final CountDownLatch corruptionHasHappened = new CountDownLatch(1);
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();
     */  
        assertAcked(
        final NodeStats primaryNode = dataNodeStats.get(0);
        Settings.Builder settings = Settings.builder()
                        if (!status.clean) {
            .actionGet();  
            }  
            SearchResponse response = client().prepareSearch().setSize(numDocs).get();
package org.opensearch.index.store;
                .setPersistentSettings(
import java.util.Collection;
                    }  
                .resolve("indices")
        client().admin().indices().prepareUpdateSettings("test").setSettings(build).get();
        }
        indexRandom(true, builders);
            String path = info.getPath();
        assertNotNull(shardRouting);
                    Settings.builder().putNull(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey())
        ensureGreen();
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
                corruptedFile = file;
        String nodeId = shardRouting.currentNodeId();
 * software distributed under the License is distributed on an
        // After Lucene 9.9 check index will flag corruption with old (not the latest) commit points.  
            builders[i] = client().prepareIndex("test").setSource("field", "value");
 * license agreements. See the NOTICE file distributed with
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
        for (MockIndexEventListener.TestEventListener eventListener : internalCluster().getDataNodeInstances(  
        ensureGreen();  
import org.opensearch.index.shard.IndexShard;  
            builders[i] = client().prepareIndex("test").setSource("field", "value");  
        // double flush to create safe commit in case of async durability
        final int numIterations = scaledRandomIntBetween(5, 20);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
        int numDocs = scaledRandomIntBetween(100, 1000);
        // we are green so primaries got not corrupted.  
        )) {
            client().admin()
        List<ShardIterator> iterators = iterableAsArrayList(shardIterators);
                    }
        corruptionHasHappened.countDown();
 * Unless required by applicable law or agreed to in writing,
     * Tests that restoring of a corrupted shard fails and we get a partial snapshot.
                        try (OutputStream os = Files.newOutputStream(path)) {
        for (int i = 0; i < builders.length; i++) {
import org.apache.lucene.store.Directory;
            }
                        BytesStreamOutput os = new BytesStreamOutput();  
        final CopyOnWriteArrayList<Exception> exception = new CopyOnWriteArrayList<>();
        final CountDownLatch hasCorrupted = new CountDownLatch(1);  
                        logger.info("corrupting file {} on node {}", path, store.getNode().getName());
                }
                    }
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false)
import org.opensearch.index.shard.IndexShardState;
                }
    }
import org.opensearch.common.lucene.Lucene;  
import static org.hamcrest.Matchers.anyOf;
import java.nio.file.Path;
            .cluster()
                        byte[] array = BytesRef.deepCopyOf(req.content().toBytesRef()).bytes;
            .collect(Collectors.toUnmodifiableList());
        for (ShardIterator iterator : shardIterators) {  
 * SPDX-License-Identifier: Apache-2.0
            );  
import java.util.Set;
                client().admin().cluster().preparePendingClusterTasks().get()  
            primaryNode.getNode().getName()
        // Unblock the blocked indexing thread now that corruption on the primary has been confirmed  
        * we corrupted the primary shard - now lets make sure we never recover from it successfully
            TransportService.class,
                dataNodeStats.add(stat);  
import org.opensearch.index.shard.IndexEventListener;
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).execute().actionGet());
        ensureGreen();  
    /**
        if (health.isTimedOut()) {
                    .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE)
            .get();  
import org.opensearch.cluster.routing.GroupShardsIterator;
                    } catch (InterruptedException e) {
import org.opensearch.cluster.ClusterState;
    /**  
    public void testReplicaCorruption() throws Exception {  
        final CreateSnapshotResponse createSnapshotResponse = client().admin()
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB)) // no
                dataNode.getNode().getName()  
     */
            )
                Settings.builder()
        final ShardRouting corruptedShardRouting = corruptRandomPrimaryFile();
                    if (includePerCommitFiles) {
            }
import org.opensearch.transport.TransportService;
                    try {  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;
                    assertThat(routing.state(), anyOf(equalTo(ShardRoutingState.RELOCATING), equalTo(ShardRoutingState.STARTED)));  
 *
 * KIND, either express or implied.  See the License for the
                        if (item.getFileName().toString().startsWith("segments_")) {
        // we don't corrupt segments.gen since S/R doesn't snapshot this file
        ShardIterator shardIterator = RandomPicks.randomFrom(random(), iterators);
    }
         * now hook into the IndicesService and register a close listener to  
    public void testPrimaryCorruptionDuringReplicationDoesNotFailReplicaShard() throws Exception {
            internalCluster().getInstance(TransportService.class, replicaNode.getNode().getName()),
                                                                                                                                    // /
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).execute().actionGet());
        client().admin().cluster().prepareReroute().get();
import org.opensearch.cluster.routing.ShardIterator;
                eventListener.setNewDelegate(null);
            prepareCreate("test").setSettings(
                .resolve("index");
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        final int numIterations = scaledRandomIntBetween(5, 20);
 * compatible open source license.
                "cluster state:\n{}\n{}",  
                } else {
        }  
        if (actionGet.isTimedOut()) {
        MatcherAssert.assertThat("Expect file corruption to cause PARTIAL snapshot state", snapshotState, equalTo(SnapshotState.PARTIAL));
        boolean didClusterTurnRed = waitUntil(() -> {
        internalCluster().ensureAtLeastNumDataNodes(2);
                        } else {  
                            BytesArray array = new BytesArray(bytesRef.bytes, bytesRef.offset, (int) req.length() - 1);  
                                                                                                                                    // might
import java.nio.file.DirectoryStream;  
import org.opensearch.common.io.stream.BytesStreamOutput;
                    // This does corrupt files on the replica, so we can't check:  
        /*
import org.opensearch.core.common.unit.ByteSizeUnit;
        client().admin().cluster().prepareReroute().get();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
                            return;
import static org.hamcrest.Matchers.notNullValue;
                    .put(MockFSIndexStore.INDEX_CHECK_INDEX_ON_CLOSE_SETTING.getKey(), false) // no checkindex - we corrupt shards on  
                .contains("could not read old (not latest) commit point segments file \"segments_2\" in directory")
                        }  
        Collections.shuffle(dataNodeStats, random());  
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB))
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).get());  
    private ShardRouting corruptRandomPrimaryFile(final boolean includePerCommitFiles) throws IOException {  
     * and all other replicas for the healthy shards happens
                    store.incRef();
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
                            continue;
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();  
            prepareCreate("test").setSettings(  
                Settings.builder()
                        }
        );  
        assertAcked(
        assertThat(dataNodeStats.size(), greaterThanOrEqualTo(2));
            MockIndexEventListener.TestEventListener.class
        ensureGreen(TimeValue.timeValueSeconds(60));
            .setWaitForCompletion(true)  
        // Create a snapshot repository. This repo is used to take a snapshot after
            client().admin()  
                TransportService.class,
                    Store store = indexShard.store();  
                                                                                                                                    // translog  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
    private List<Path> findFilesToCorruptOnNode(final String nodeName, final ShardId shardId) throws IOException {  
import java.util.concurrent.CountDownLatch;
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
        assertThat(routing.toString(), nodeStatses.getNodes().size(), equalTo(1));
                    .put("index.allocation.max_retries", Integer.MAX_VALUE) // keep on retrying  
        indexRandom(true, builders);  
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
        for (Path file : files) {
                if (store.getAllocationStatus().equals(IndicesShardStoresResponse.StoreStatus.AllocationStatus.UNUSED)) {
    }
        assertAcked(
    /**  
        assertHitCount(countResponse, numDocs);
        internalCluster().ensureAtLeastNumDataNodes(2);  
            mockTransportService.addSendBehavior(  
                                                                                                                                    // segments.N  
    public List<Path> listShardFiles(ShardRouting routing) throws IOException {  
        NodesStatsResponse nodeStatses = client().admin()
            )
import org.opensearch.snapshots.SnapshotState;  
            mockTransportService.addSendBehavior(
 * GitHub history for details.
        assertAcked(
        );
                .cluster()
            MockTransportService.TestPlugin.class,  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                if (unluckyNode.getNode().getId().equals(routing.currentNodeId())) {
        internalCluster().ensureAtLeastNumDataNodes(2);  
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();  
                    // no checkindex - we corrupt shards on purpose
                    if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
            assertThat("timed out waiting for green state", health.isTimedOut(), equalTo(false));
        // Corrupt a file on the primary then take a snapshot. Snapshot should
                }
        ensureYellow();
        List<NodeStats> dataNodeStats = new ArrayList<>();
        // validation failure.  
        assertHitCount(countResponse, numDocs);
        ensureGreen();
        mockTransportService.addSendBehavior(
        final ClusterHealthResponse response = client().admin().cluster().health(Requests.clusterHealthRequest("test")).get();
        logger.info("--> {} corrupted", corruptedShardRouting);
                        exception.add(e);  
            logger.info("--> cluster has [3] data nodes, corrupted primary will be overwritten");  
                    Settings.builder().put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "primaries")
                .prepareUpdateSettings()
        ShardRouting shardRouting = corruptRandomPrimaryFile(false);  
            }  
import java.nio.file.Files;
            builders[i] = client().prepareIndex("test").setSource("field", "value");
            ShardRouting routing;
        int numDocs = scaledRandomIntBetween(100, 1000);
            internalCluster().startDataOnlyNode();
        return shardRouting;  
        );
import org.apache.lucene.index.SegmentCommitInfo;  
 * not use this file except in compliance with the License.
        ensureGreen();
        final CountDownLatch latch = new CountDownLatch(numShards * 3); // primary + 2 replicas  
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
        SearchResponse countResponse = client().prepareSearch().setSize(0).get();  
import org.opensearch.indices.recovery.FileChunkRequest;
                    }
                    indexingInFlight.countDown();
import static org.hamcrest.Matchers.empty;
                    for (Path item : stream) {  
                    // no checkindex - we corrupt shards on purpose  
            prepareCreate("test").setSettings(  
        Settings build = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1").build();
        return Arrays.asList(
                    .put(IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(), new ByteSizeValue(1, ByteSizeUnit.PB))  
        for (NodeStats stat : nodeStats.getNodes()) {
        createRepository("test-repo", "fs", settings);
     * during recovery we don't know the version of the segments_N file because it has no segments we can take it from.
                    .waitForGreenStatus()  
                .setPersistentSettings(  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.transport.MockTransportService;  
                }
            }  
        );  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")
import org.opensearch.cluster.routing.ShardRoutingState;  
        logger.info("--> shard {} has a corrupted file", shardRouting);
import java.util.Arrays;
        ));  
                        PrintStream out = new PrintStream(os, false, StandardCharsets.UTF_8.name());
                                                                                                                                    // change
        internalCluster().ensureAtLeastNumDataNodes(2);
    public void testCorruptionOnNetworkLayer() throws ExecutionException, InterruptedException {  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
            for (ShardRouting routing : table) {
            if (file.getFileName().toString().startsWith("corrupted_")) {
                Settings.builder()  
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)
            path = path.resolve("index");  
            .build();  
    }
            .stream()  
import org.opensearch.common.settings.Settings;
        assertEquals("Check index has a single failure", 1, checkIndexFailures.size());  
                        corruptionHasHappened.await();
        // the other problem here why we can't corrupt segments.X files is that the snapshot flushes again before  
        ClusterStateResponse clusterStateResponse = client().admin().cluster().prepareState().get();
        for (int i = 0; i < builders.length; i++) {  
        int numDocs = scaledRandomIntBetween(100, 1000);
/*
                                                                                                                                    // .liv
            .get();
 *  
        }, 5, TimeUnit.MINUTES);// sometimes on slow nodes the replication / recovery is just dead slow
        // For this test our previous corrupt commit "segments_2" will remain on the primary.
    }
        for (IndexShardRoutingTable table : clusterStateResponse.getState().getRoutingTable().index("test")) {  
        // count down a latch to indicate that a replication operation is
        ensureGreen();
                    assertThat(routing.state(), equalTo(ShardRoutingState.UNASSIGNED));
                            logger.warn("check index [failure]\n{}", os.bytes().utf8ToString());
        internalCluster().ensureAtLeastNumDataNodes(3);
        }
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
            MockTransportService mockTransportService = ((MockTransportService) internalCluster().getInstance(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "1")  
                    }  
        // have enough space for 3 copies  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
                    .put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)  
                "cluster state:\n{}\n{}",
    private static boolean isPerSegmentFile(String fileName) {
        } finally {  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
        int numDocs = scaledRandomIntBetween(100, 1000);
         * we corrupted the primary shard - now lets make sure we never recover from it successfully
        return Settings.builder()
    public void testCorruptFileThenSnapshotAndRestore() throws ExecutionException, InterruptedException, IOException {  
                                                                                                                                    // files
        // double flush to create safe commit in case of async durability
        };
import org.opensearch.action.index.IndexRequestBuilder;
            prepareCreate("test").setSettings(  
        );
                    for (SegmentCommitInfo commitInfo : segmentCommitInfos) {
        ShardRouting shardRouting = shardIterator.nextOrNull();  
            builders[i] = client().prepareIndex("test").setSource("field", "value");  
                            request = new FileChunkRequest(
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.FS;
        assertAllSuccessful(client().admin().indices().prepareFlush().setForce(true).get());
        corrupt.set(false);
                    connection.sendRequest(requestId, action, request, options);
        }
                                req.lastChunk(),
        final IndicesShardStoresResponse stores = client().admin().indices().prepareShardStores(index.getName()).get();  
                (connection, requestId, action, request, options) -> {
    /**  
    }
        for (int i = 0; i < numIterations; i++) {  
            );  
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
        // we have to flush at least once here since we don't corrupt the translog
        indexRandom(true, builders);  
        // .liv and segments_N are per commit files and might change after corruption
        ClusterState state = client().admin().cluster().prepareState().get().getState();
                                files.add(file.resolve(commitFile));  
            .health(Requests.clusterHealthRequest("test").waitForGreenStatus())
        }
