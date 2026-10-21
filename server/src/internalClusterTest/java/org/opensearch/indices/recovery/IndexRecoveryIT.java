import org.opensearch.test.InternalSettingsPlugin;
            Task task
import org.opensearch.OpenSearchException;
        int shardId,
            NodesStatsResponse nodesStatsResponse = client().admin()
 */
    private void validateIndexRecoveryState(ReplicationLuceneIndex indexState) {
        final String redNodeName = internalCluster().startNode(Settings.builder().put("node.attr.color", "red").put(nodeSettings).build());
                TransportRequestOptions options
            validateIndexRecoveryState(nodeCRecoveryStates.get(0).getIndex());
 *
        logger.info(
        );
            );
                }
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
            assertThat(dataNodeStats, hasSize(2));
                    throw new ConnectTransportException(
                        throw new RuntimeException(e);
            redMockTransportService.addRequestHandlingBehavior(recoveryActionToBlock, (handler, request, channel, task) -> {
    }
            randomBoolean(),
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
    protected void beforeIndexDeletion() throws Exception {
            InternalSettingsPlugin.class,
            new InternalTestCluster.RestartCallback() {
        }
            validateIndexRecoveryState(nodeBRecoveryStates.get(0).getIndex());
                }
                    .prepareUpdateSettings(indexName)
        Semaphore blockRecovery = new Semaphore(1);
import java.util.function.BiConsumer;
        final String blueNodeName = internalCluster().startNode(
        }
        ) {
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeA);
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(Settings.builder().put("index.number_of_replicas", 1))
            reasonableOperationsBasedRecoveryProportion = IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.get(Settings.EMPTY);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(firstNodeToStop));
    }
        indexRandom(true, requests);
            }
        final long lastSyncedGlobalCheckpoint = shard.getLastSyncedGlobalCheckpoint();
                    throw new AssertionError(
                            .stream()
        ).getShardOrNull(shardId);
            TransportService.class,
                            .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Store))
        );
                )
            )
            if (action.equals(PeerRecoveryTargetService.Actions.FILES_INFO)) {
        internalCluster().startNodes(2);
import java.util.stream.IntStream;
            indexer.start();
import org.opensearch.core.common.breaker.CircuitBreakingException;
                        IndexResponse response = client().prepareIndex(indexName)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        } else {
                    if (startRecoveryRequestFuture.isDone()) {
                .isAcknowledged()
        internalCluster().restartNode(
        // validate node B recovery
            .get(indexName)
                    indexRandom(
        final long maxSeqNo = shard.seqNoStats().getMaxSeqNo();
                    }
        String nodeWithPrimary = internalCluster().startDataOnlyNode();
        ensureGreen();
import org.opensearch.action.support.replication.ReplicationResponse;
        assertThat(recoveryStates.get(0).getTranslog().recoveredOperations(), greaterThan(0));
                .build()
            logger.info("--> starting replica recovery from blue to red");
            });
            .setSettings(
                        recoveryStats.throttleTime().millis(),
                        }
            .get();
            );
            if (nodeStats.getNode().getName().equals(nodeB)) {
        }
            }
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                            INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(),
        RestoreSnapshotResponse restoreSnapshotResponse = client().admin()
        ensureGreen(indexName);
                (indexSettings, environment, name, settings) -> new AbstractTokenFilterFactory(indexSettings, name, settings) {
        internalCluster().startNode();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        List<IndexRequestBuilder> requests = new ArrayList<>();
                    );
    private class SingleStartEnforcer implements BiConsumer<String, TransportRequest> {
            // searching helps, as in contrast to search actions, refresh waits for the closed shard to be reallocated.
            if (randomBoolean()) {
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "500ms")
                        for (TestAnalysisPlugin plugin : pluginService.filterPlugins(TestAnalysisPlugin.class)) {
        // noinspection OptionalGetWithoutIsPresent because it fails the test if absent
        DiscoveryNode nodeWithPrimary = clusterState.nodes()
                .put("index.analysis.analyzer.test_analyzer.type", "custom")
        final String nodeA = internalCluster().startNode();
import org.opensearch.transport.ConnectTransportException;
        boolean primary,
            if (recoveryState.getTargetNode().getName().equals(nodeName)) {
                .indices()
                        .retentionLeases()
import org.opensearch.index.mapper.MapperParsingException;
            transportService.addSendBehavior((connection, requestId, action, request, options) -> {
                    try {
import static org.hamcrest.Matchers.is;
                    );
        createIndex(
                .prepareUpdateSettings(indexName)
        final RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
    public void testGatewayRecoveryTestActiveOnly() throws Exception {
                    final NodeIndicesStats nodeIndicesStats = client().admin()
        internalCluster().startNode(nodeSettings);
        private final Runnable connectionBreaker;
        String secondNodeToStop = randomFrom(internalCluster().getDataNodeNames());
        createAndPopulateIndex(INDEX_NAME, 1, SHARD_COUNT, REPLICA_COUNT);
        int numDocs = scaledRandomIntBetween(25, 250);
                    allowToCompletePhase1Latch.await();
            } else if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
                    shardStats.getRetentionLeaseStats()
                .cluster()
        if (randomBoolean()) {
        private final CountDownLatch requestBlocked;
import org.opensearch.test.transport.StubbableTransport;
            assertAcked(
                .put("index.number_of_shards", 1)
        indexRandom(true, docs);
                .get()
                     *
                    );
                                    .cluster()
        final String nodeC = internalCluster().startNode();
        );
        assertAcked(
        logger.info("--> start node B");
                .sum(),
            assertThat(nodeCRecoveryStates.size(), equalTo(1));
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
import java.util.function.Consumer;
        indexRandom(
                            .setWaitForEvents(Priority.LANGUID)
                } else {
        ReplicaShardAllocatorIT.ensureActivePeerRecoveryRetentionLeasesAdvanced(INDEX_NAME);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertHitCount(searchResponse, numDocs);
        }
            .indices()
        assertThat(client().admin().indices().prepareFlush(indexName).get().getFailedShards(), is(0)); // makes a safe commit
            .cluster()
    private void assertRecoveryState(
        createRepository(REPO_NAME, "fs", Settings.builder().put("location", randomRepoPath()).put("compress", false));
            allowToCompletePhase1Latch.countDown();
    public void testUsesFileBasedRecoveryIfOperationsBasedRecoveryWouldBeUnreasonable() throws Exception {
import org.opensearch.index.seqno.ReplicationTracker;
            blueNodeName
            indexName,
        assertOnGoingRecoveryState(nodeCRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, nodeB, nodeC);
            Settings.builder().put("node.attr.color", "blue").put(nodeSettings).build()
        CreateSnapshotResponse createSnapshotResponse = client().admin()
        final AtomicBoolean fileChunkIntercepted = new AtomicBoolean();
            nodeWithPrimary.getName()
        logger.info("--> request recoveries");
    private class RecoveryActionBlocker implements StubbableTransport.SendRequestBehavior {
                    assertThat(
                SnapshotRecoverySource recoverySource = new SnapshotRecoverySource(
            mockTransportService.addSendBehavior(clusterManagerTransportService, (connection, requestId, action, request, options) -> {
            // RecoveryTarget.Actions.TRANSLOG_OPS, <-- may not be sent if already flushed
        @Override
        createIndex(
                .getNodes()
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            connection.sendRequest(requestId, action, request, options);
        }
        );
import org.opensearch.action.search.SearchResponse;
        logger.info("--> create index on node: {}", nodeA);
import org.opensearch.Version;
                clusterService().state().nodes().getClusterManagerNode().getName(),
                    Settings.builder()
            if (actionName.equals(PeerRecoveryTargetService.Actions.FINALIZE)) {
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("--> starting recovery from blue to red");
        ensureGreen();
    public void testPeerRecoveryTrimsLocalTranslog() throws Exception {
        final int replicatedDocCount = scaledRandomIntBetween(25, 250);
        assertThat(recoveryStates.size(), equalTo(1));
            .prepareNodesStats()
            if (PeerRecoveryTargetService.Actions.CLEAN_FILES.equals(action) && blockRecovery.tryAcquire()) {
            .indices()
            blueNodeName
        logger.info("--> add replicas again");
            randomBoolean(),
        validateIndexRecoveryState(recoveryStates.get(0).getIndex());
            .get();
                .get();
                            .setWaitForEvents(Priority.LANGUID)
                        .put(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE.getKey(), randomBoolean())
                    Settings.builder()
        ensureGreen(indexName);
        ensureGreen(indexName);
            .add(new MoveAllocationCommand(INDEX_NAME, 0, nodeA, nodeC))
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 6))
import org.opensearch.action.support.PlainActionFuture;
                     *       <= newDocCount -  ceil(newDocCount * p + docCount * p)
    }
            connection.sendRequest(requestId, action, request, options);
        readyToRestartNode.await();
                    try {
        );
                }
            this.finalizeReceived = finalizeReceived;
                // disable global checkpoint background sync so we can verify the start recovery request
                .setNodesIds(nodeName)
        );
            discoveryNodes.get(indexShardRoutingTable.primaryShard().currentNodeId()).getName()
                )
        response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
            recoveryStarted,
                }
        // we have to use assertBusy as recovery counters are decremented only when the last reference to the RecoveryTarget
 */
 * under the License.
                } catch (InterruptedException e) {
        // first try because the local recovery happens once and its stats is reset when the recovery fails.
        }
            .filter(rs -> rs.getPrimary() == false)
            blueTransportService.clearAllRules();
        createIndex(
                        "node A throttling should increase",
        // noinspection OptionalGetWithoutIsPresent because it fails the test if absent
        String failingNode = randomFrom(nodes);
        // start a cluster-manager node
            TransportService.class,
        assertAcked(
 * this file be licensed under the Apache-2.0 license or a
        final int numOfDocs = scaledRandomIntBetween(0, 200);
        client().admin().indices().prepareRefresh(indexName).get(); // avoid refresh when we are failing a shard
            randomBoolean(),
                    allowToCompletePhase1Latch.await();
        validateIndexRecoveryState(nodeBRecoveryState.getIndex());
        assertThat(totalShards, greaterThan(0));
            .get();
            .execute()
                TimeValue.timeValueMillis(randomIntBetween(0, 100))
 * You may obtain a copy of the License at
            // Fail on the receiving side.
                    throw new AssertionError("Unknown failure reason: " + reason);
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import org.opensearch.index.MockEngineFactoryPlugin;
                    public TokenStream create(TokenStream tokenStream) {
        ).getShardOrNull(shardId);
                            .putNull("index.routing.allocation.include._name")
        assertRecoveryStateWithoutStage(state, shardId, type, primary, sourceNode, targetNode);
        logger.info("--> start node A");
        List<RecoveryState> nodeCRecoveryStates = findRecoveriesForTargetNode(nodeC, recoveryStates);
            assertThat(indicesService.indexServiceSafe(index).getShard(0).recoveryStats().currentAsSource(), equalTo(1));
            TransportRequestHandler<TransportRequest> handler,
        ensureGreen(indexName);
            .prepareCreate(indexName)
                        primary.seqNoStats().getMaxSeqNo() + 1,
                }
                    logger.info("--> preventing {} response by throwing exception", actionName);
            ensureGreen(); // also waits for relocation / recovery to complete
        logger.info("--> request recoveries");
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numOfDocs);
        List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
                assertTrue(
            Caused by: org.opensearch.transport.ReceiveTimeoutTransportException: [node_t3][127.0.0.1:56648][internal:index/shard/recovery/clean_files] request_id [20] timed out after [60026ms]
        internalCluster().ensureAtLeastNumDataNodes(2);
        ensureGreen(indexName);
            )
        );
        String indexName = "test";
            .prepareCreate(indexName)
            randomBoolean(),
        for (int i = 0; i < numNewDocs; i++) {
    public void testUsesFileBasedRecoveryIfRetentionLeaseMissing() throws Exception {
                        .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "red,blue")
        int totalShards = restoreSnapshotResponse.getRestoreInfo().totalShards();
                        randomBoolean(),
                        }
                blueTransportService,
public class IndexRecoveryIT extends OpenSearchIntegTestCase {
            false,
                .setSettings(
        assertThat(nodeBRecoveryStates.size(), equalTo(1));
                .build()
                if (PeerRecoverySourceService.Actions.START_RECOVERY.equals(action) && count.incrementAndGet() == 1) {
        for (MockTransportService mockTransportService : Arrays.asList(redMockTransportService, blueMockTransportService)) {
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "red,blue")
            IndicesService.class,
        redMockTransportService.addSendBehavior(blueMockTransportService, new StubbableTransport.SendRequestBehavior() {
        RecoveryActionBlocker(boolean dropRequests, String recoveryActionToBlock, CountDownLatch requestBlocked) {
        final long desyncNanoTime = System.nanoTime();
        logger.info("--> will {} between blue & red on [{}]", dropRequests ? "drop requests" : "break connection", recoveryActionToBlock);
            }
            .put(
                public Settings onNodeStopped(String nodeName) throws Exception {
            .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Recovery))
        final String nodeB = internalCluster().startNode();
        TimeValue disconnectAfterDelay = TimeValue.timeValueMillis(randomIntBetween(0, 100));
        }
        try (GatedCloseable<IndexCommit> wrappedSafeCommit = shard.acquireSafeIndexCommit()) {
            .cluster()
import java.io.IOException;
        String indexName = "test";
                .indices()
    public void testTransientErrorsDuringRecoveryAreRetried() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
            .setSettings(
        createAndPopulateIndex(INDEX_NAME, 1, SHARD_COUNT, REPLICA_COUNT);
        assertThat((long) localRecoveredOps.get(), equalTo(lastSyncedGlobalCheckpoint - localCheckpointOfSafeCommit));
        // Perform some replicated operations so the replica isn't simply empty, because ops-based recovery isn't better in that case
        requests.clear();
            .get();
        assertThat(recoveryState.getIndex().totalFileCount(), greaterThan(0));
            });
    @Override
        String nodeC = internalCluster().startNode();
            response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
        client().admin().indices().prepareRefresh("test").get();
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
            if (action.equals(PeerRecoveryTargetService.Actions.FINALIZE)) {
                    assertThat(
                        client().admin()
    public static final class TestAnalysisPlugin extends Plugin implements AnalysisPlugin {
            .prepareReroute()
                .setWaitForActiveShards(ActiveShardCount.NONE)
                     *
        }
import org.opensearch.common.concurrent.GatedCloseable;
        createIndex(
        logger.info("--> start node B");
            List<NodeStats> dataNodeStats = statsResponse1.getNodes()
    }
        assertTrue(
        assertBusy(() -> {
        );
        if (randomBoolean()) {
 * GitHub history for details.
                        greaterThan(0L)
            assertFalse(client().admin().cluster().prepareHealth(indexName).setWaitForActiveShards(2).get().isTimedOut());
            Settings.builder()
            client().admin()
        String indexName = "test-index";
                List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
                String action,
            connection.sendRequest(requestId, action, request, options);
        ensureGreen(indexName);
    }
        assertThat(nodeCRecoveryStates.size(), equalTo(1));
            .indices()
            }
        // we should now have two total shards, one primary and one replica
            randomBoolean(),
            client().admin()
            .findFirst()
                        .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Store))
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
            .actionGet();
                String rejected = "rejected";
            .mapToObj(n -> client().prepareIndex(indexName).setSource("foo", "bar"))
import static org.opensearch.action.DocWriteResponse.Result.UPDATED;
import java.util.Spliterators;
        final ShardStats shardStats = client().admin().indices().prepareStats(indexName).get().getShards()[0];
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(secondNodeToStop));
        );
            randomBoolean(),
    }
        while (System.nanoTime() <= desyncNanoTime) {
        };
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replicaShardRouting))
        assertRecoveryState(nodeBRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, Stage.DONE, nodeA, nodeB);
                .get();
            TransportService.class,
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        nodeARecoveryStates = findRecoveriesForTargetNode(nodeA, recoveryStates);
            internalCluster().restartNode(
            indexName,
        CountDownLatch allowToCompletePhase1Latch = new CountDownLatch(1);
                        client().admin()
                    return super.onNodeStopped(nodeName);
                try {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            assertOnGoingRecoveryState(nodeCRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, nodeB, nodeC);
                        .stream()
        assertBusy(() -> {
                                    .index("test")
        assertHitCount(searchResponse, numDocs);
        NodesStatsResponse statsResponse = client().admin()
                            throw new MapperParsingException("simulate mapping parsing error");
import java.util.Map;
        );
            for (RecoveryState recoveryState : recoveryStates) {
            PeerRecoveryTargetService.Actions.FILES_INFO,
        logger.info("--> indexing sample data");
        if (randomBoolean() && shouldAssertOngoingRecoveryInRerouteRecovery()) {
        internalCluster().startNode(nodeSettings);
                public Settings onNodeStopped(String nodeName) throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
        final IndexShard primary = internalCluster().getInstance(
                    shardStats.getRetentionLeaseStats()
            Transport.Connection connection,
 * KIND, either express or implied.  See the License for the
        indexRandom(
                    }
                    }
                assertThat("node B should have ongoing recovery as target", recoveryStats.currentAsTarget(), equalTo(1));
                    /*
                redTransportService,
            } else {
                .build()
        for (NodeStats nodeStats : statsResponse.getNodes()) {
    }
            client().admin()
        ByteSizeValue shardSize = createAndPopulateIndex(INDEX_NAME, 1, SHARD_COUNT, REPLICA_COUNT).getShards()[0].getStats()
        assertTrue(
                            .collect(Collectors.toList()),
                    ((SnapshotRecoverySource) recoveryState.getRecoverySource()).restoreUUID(),
        ensureGreen();
            assertThat(nodeBRecoveryStates.size(), equalTo(1));
            // shard is marked as started again (and ensureGreen returns), but while applying the cluster state the primary is failed and
                        .put("index.number_of_shards", 1)
        ensureGreen(INDEX_NAME);
                nodeCount,
        internalCluster().ensureAtLeastNumDataNodes(2);
import static java.util.stream.Collectors.toList;
        // relocations of replicas are marked as REPLICA and the source node is the node holding the primary (B)
                .get();
            // Fail on the sending side
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final IndexShardRoutingTable indexShardRoutingTable = clusterService().state().routingTable().shardRoutingTable(shardId);
        );
        );
                            "should no longer have lease for " + replicaShardRouting,
        );
            .put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), "100ms")
                .cluster()
        final String blueNodeName = internalCluster().startNode(
                            .setWaitForNodes(Integer.toString(discoveryNodes.getSize() - 1))
        if (sourceNode == null) {
                    return super.onNodeStopped(nodeName);
    }
        nodeCRecoveryStates = findRecoveriesForTargetNode(nodeC, recoveryStates);
 * software distributed under the License is distributed on an
            startRecoveryRequest.metadataSnapshot().getCommitUserData()
            );
    ) {
                Settings.builder()
            });
                .get();
        response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;
                        .leases()
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING;
                .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Recovery))
            @SuppressForbidden(reason = "Simulating disconnect after sending request with a delay")
        private TransientReceiveRejected(
                    throw new AssertionError(e);
                .cluster()
        logger.info("--> checking throttling increases");
                @Override
                        // small chunks
        client().admin()
        final RecoveryState nodeARecoveryState = nodeAResponses.get(0);
            internalCluster().ensureAtLeastNumDataNodes(3);
    public void testOngoingRecoveryAndClusterManagerFailOver() throws Exception {
            .mapToObj(n -> client().prepareIndex(indexName).setSource("foo", "bar"))
import org.opensearch.test.store.MockFSIndexStore;
        // wait for peer recovery from nodeA to nodeB which is a no-op recovery so it skips the CLEAN_FILES stage and hence is not blocked
            discoveryNodes.get(replicaShardRouting.currentNodeId()).getName(),
        indexRandom(randomBoolean(), docs);
                    recoveryState.getTranslog().recoveredOperations(),
        final List<IndexRequestBuilder> requests = new ArrayList<>();
                            plugin.throwParsingError.set(true);
        });
        ensureGreen();
            randomBoolean(),
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                .indices()
import org.opensearch.cluster.routing.ShardRoutingState;
            PeerRecoveryTargetService.Actions.FILES_INFO,
        TransportService redTransportService = internalCluster().getInstance(TransportService.class, redNodeName);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // hold peer recovery on phase 2 after nodeB down
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                .get();
            ensureGreen();
            lessThanOrEqualTo(maxSeqNoAfterRecovery - maxSeqNoBeforeRecovery)
            }
        logger.info("--> will temporarily interrupt recovery action between blue & red on [{}]", recoveryActionToBlock);
            .prepareUpdateSettings(INDEX_NAME)
        }
        for (int i = 0; i < numDocs; i++) {
        );
            flush(indexName);
import org.opensearch.plugins.PluginsService;
                .cluster()
                    );
                                "Expected there to be some initializing shards",
            // will be reallocated. The cluster will thus become green, then red, then green again. Triggering a refresh here before
            }
                                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replicaShardRouting))
        MockTransportService blueMockTransportService = (MockTransportService) internalCluster().getInstance(
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms");
            .get()
import java.util.Collections;
                connection.sendRequest(requestId, action, request, options);
import static org.hamcrest.Matchers.everyItem;
        validateIndexRecoveryState(nodeBRecoveryStates.get(0).getIndex());
    }
            blueMockTransportService.addSendBehavior(
                readyToRestartNode.countDown();
        } finally {
        );
            }
            .execute()
            PeerRecoveryTargetService.Actions.TRANSLOG_OPS,
            TransportService.class,
            .prepareUpdateSettings(indexName)
            randomBoolean(),
    private static final int MIN_DOC_COUNT = 500;
    }
    }
                .indices()
import static org.hamcrest.Matchers.not;
                }
                        randomBoolean(),
        createAndPopulateIndex(INDEX_NAME, 1, SHARD_COUNT, REPLICA_COUNT);
                    greaterThanOrEqualTo(Math.toIntExact(maxSeqNo - localCheckpointOfSafeCommit))
        redMockTransportService.clearAllRules();
            TransportRequest request,
        internalCluster().stopRandomDataNode();
        }
                    return;
            TransportRequestOptions options
                .setSettings(
                    Settings.builder()
        internalCluster().startNode(randomFrom(firstNodeToStopDataPathSettings, secondNodeToStopDataPathSettings));
            for (ShardStats shardStats : client().admin().indices().prepareStats(indexName).get().getShards()) {
import org.opensearch.action.support.ActiveShardCount;
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
        RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).setActiveOnly(true).execute().actionGet();
        // Index 3/4 of the documents and flush. And then index the rest. This attempts to ensure that there
                    .indices()
            Settings.builder()
            .prepareRecoveries(indexName)
        );
    public void testDoesNotCopyOperationsInSafeCommit() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
                        connection.getNode(),
                                    .setLocal(true)
                        .getShard(0)
            TransportService.class,
        ensureSearchable(indexName);
        final boolean closedIndex = randomBoolean();
        ) throws Exception {
        recoveryStates.removeIf(r -> r.getTimer().getStartNanoTime() <= desyncNanoTime);
import org.opensearch.cluster.node.DiscoveryNodes;
            Settings.builder().put("node.attr.color", "blue").put(nodeSettings).build()
                List<RecoveryState> nodeCRecoveryStates = findRecoveriesForTargetNode(nodeC, recoveryStates);
            .get();
                        if (throwParsingError.get()) {
        ensureGreen(indexName);
                .setId("u" + i)
        }
        }
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
                .indices()
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
    public void testReservesBytesDuringPeerRecoveryPhaseOne() throws Exception {
        client().admin()
                if (reason.equals(rejected)) {
                        return tokenStream;
                client().admin()
        );
import org.opensearch.repositories.RepositoriesService;
        Consumer<String> assertNodeHasThrottleTimeAndNoRecoveries = nodeName -> {
        List<RecoveryState> nodeBResponses = findRecoveriesForTargetNode(nodeB, recoveryStates);
        }
/*
import org.opensearch.cluster.service.ClusterService;
        final DiscoveryNodes discoveryNodes = clusterService().state().nodes();
            connection.sendRequest(requestId, action, request, options);
        final DiscoveryNodes discoveryNodes = clusterService().state().nodes();
            }
            .indices()
        @Override
    }
        indexRandom(true, requests);
            client().admin()
 * specific language governing permissions and limitations
        final String redNodeName = internalCluster().startNode(Settings.builder().put("node.attr.color", "red").put(nodeSettings).build());
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
        transportService.clearAllRules();
                .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Recovery))
import org.opensearch.tasks.Task;
        redTransportService.addRequestHandlingBehavior(recoveryActionToBlock, handlingBehavior);
                    connectionBreaker.run();
                        startRecoveryRequestFuture.onResponse((StartRecoveryRequest) request);
            // source shard is moved back to started because the target fails first, it's possible that there is a cluster state where the
        assertFalse(stateResponse.getState().getRoutingNodes().node(blueNodeId).isEmpty());
        assertAcked(
        RecoverySource recoverySource,
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                phase1ReadyBlocked.countDown();
        int nodeCount = internalCluster().getNodeNames().length;
        assertOnGoingRecoveryState(nodeBRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, nodeA, nodeB);
            .setSettings(
            assertHitCount(searchResponse, numDocs);
        );
                .build()
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
        ).getShardOrNull(shardId);
                        .indexServiceSafe(resolveIndex(indexName))
        assertThat(recoveryState.getIndex().totalFileCount(), greaterThan(0));
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
    }
                handler.messageReceived(request, channel, task);
        assertAcked(
        logger.info("--> clearing rules to allow recovery to proceed");
        assertThat(
            for (final ShardStats shardStats : shardsStats) {
        String[] recoveryActions = new String[] {
        slowDownRecovery(shardSize);
        logger.info("--> start nodes");
        nodeBRecoveryStates = findRecoveriesForTargetNode(nodeB, recoveryStates);
import org.opensearch.core.common.unit.ByteSizeUnit;
                RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(),
        ensureGreen();
                    }
            .prepareRecoveries(indexName)
            indexers[i] = new Thread(() -> {
                String reason = randomFrom(rejected, circuit, network);
            equalTo(SnapshotState.SUCCESS)
            AtomicBoolean recoveryStarted,
        indexRandom(true, requests);
                    repositoryData.resolveIndexId(INDEX_NAME)
        indexRandom(
        final IndexShardRoutingTable indexShardRoutingTable = clusterService().state().routingTable().shardRoutingTable(shardId);
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            INDEX_NAME,
        for (int i = 0; i < 10; i++) {
            randomBoolean(),
        assertThat(state.getStage(), equalTo(stage));
            handler.messageReceived(request, channel, task);
        assertThat(nodeARecoveryStates.size(), equalTo(1));
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "12h")
        assertAcked(
                        "expect an operation-based recovery:"
        assertBusy(() -> assertNodeHasThrottleTimeAndNoRecoveries.accept(nodeA));
package org.opensearch.indices.recovery;
            client().admin()
import org.opensearch.action.admin.indices.stats.ShardStats;
        assertThat(response.shardRecoveryStates().size(), equalTo(SHARD_COUNT));
        final String blueNodeId = internalCluster().getInstance(ClusterService.class, blueNodeName).localNode().getId();
                    .put(Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), 0)
        List<IndexRequestBuilder> requests = new ArrayList<>();
        internalCluster().startClusterManagerOnlyNode();
                    .indices()
                wrappedSafeCommit.get().getUserData().entrySet()
        logger.info("--> create index on node: {}", nodeA);
                    )
                .indices()
        ensureGreen();
                    .prepareUpdateSettings(indexName)
        client().admin()
                    if (recoveryBlocked.tryAcquire()) {
        List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
    private IndicesStatsResponse createAndPopulateIndex(String name, int nodeCount, int shardCount, int replicaCount)
            .get();
        final long maxSeqNoBeforeRecovery = primary.seqNoStats().getMaxSeqNo();
                if (nodeStats.getNode().getName().equals(nodeB)) {
                );
        try (BackgroundIndexer indexer = new BackgroundIndexer(INDEX_NAME, "_doc", client(), numOfDocs)) {
            .get(indexName)
        indexRandom(
        String sourceNode,
                        .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0)
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all"))
        public void accept(String action, TransportRequest request) {
        client().admin()
                        .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "20mb")
import org.opensearch.test.InternalTestCluster;
                            )
            // prevent the primary from marking the replica as stale so the replica can get promoted.
        });
import org.opensearch.transport.TransportRequestOptions;
        assertThat(
        createIndex(
            PeerRecoveryTargetService.Actions.PREPARE_TRANSLOG,
                }
        }
                assertThat("node B should not have ongoing recovery as source", recoveryStats.currentAsSource(), equalTo(0));
            logger.info("--> starting recovery from blue to red");
        );
import static org.hamcrest.Matchers.greaterThan;
                                    .getAllInitializingShards(),
                            .getBytes(),
            TransportRequest request,
        assertTrue(
            Settings.builder()
                        randomBoolean(),
        assertThat(commitInfoAfterLocalRecovery.maxSeqNo, equalTo(lastSyncedGlobalCheckpoint));
        assertThat(shardStats.getSeqNoStats().getMaxSeqNo() + 1, equalTo(docCount));
        assertThat(client().admin().indices().prepareFlush(indexName).get().getFailedShards(), equalTo(0));
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        createIndex(indexName, settings.build());
        logger.info("--> remove replicas");
    }
                )
            new InternalTestCluster.RestartCallback() {
                        .getNodes()
        createIndex(
        final int numDocs = numDocs();
                    } catch (Exception e) {
                .indices()
        client().admin()
                    }
            .cluster()
            }
                        Settings.builder()
import static org.hamcrest.Matchers.equalTo;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                TransportService.class,
            }
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "blue")
        RecoverySource type,
        final String recoveryActionToBlock = randomFrom(recoveryActions);
/*
                            .isTimedOut()
            });
            assertNotNull(state.getTargetNode());
        transport.addSendBehavior((connection, requestId, action, request, options) -> {
                    );
                assertThat(state.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(nodeA));
    }
                                    .get()
            String nodeWithReplica = internalCluster().startDataOnlyNode();
                        .allMatch(retentionLease -> retentionLease.retainingSequenceNumber() == maxSeqNo + 1)
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes(String.valueOf(nodeCount)).get().isTimedOut());
                .prepareNodesStats()
                state.routingTable().index(indexName).shardsWithState(ShardRoutingState.UNASSIGNED).size() == 1
                        IntStream.range(0, newDocCount)
            assertThat(nodeARecoveryStates.size(), equalTo(0));
                @Override
                        .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "red,blue")
            .filter(rs -> rs.getPrimary() == false)
        assertThat(recoveryStates.size(), equalTo(1));
        flush(indexName); // ensure that all operations are in the safe commit
            .indices()
        // wait for all history to be discarded
        internalCluster().restartNode(nodeWithOldPrimary.getName(), new InternalTestCluster.RestartCallback());
import org.opensearch.common.SuppressForbidden;
                     *              == firstReasonableSeqNo
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "blue")
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
            client().admin().indices().prepareRefresh(indexName).get();
        List<ShardRouting> startedShards = state.routingTable().shardsWithState(ShardRoutingState.STARTED);
        );
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        final IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        }
        );
            TransportChannel channel,
        ClusterState state = client().admin().cluster().prepareState().get().getState();
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.cluster.ClusterState;
                            .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
        ensureGreen(indexName);
            client().admin()
        AtomicBoolean stopped = new AtomicBoolean();
            if (action.equals("internal:cluster/shard/failure")) {
        recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
            .prepareCreate(indexName)
            nodeBRecoveryStates = findRecoveriesForTargetNode(nodeB, recoveryStates);
        final long finalNodeAThrottling = nodeAThrottling;
        nodeARecoveryStates = findRecoveriesForTargetNode(nodeA, recoveryStates);
        assertAcked(
            }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertTrue(fileInfoIntercepted.get());
        internalCluster().ensureAtLeastNumDataNodes(2);
        final ShardRouting replicaShardRouting = indexShardRoutingTable.replicaShards().get(0);
                        "node B throttling should increase",
        Repository repository = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class).repository(REPO_NAME);
            connectionBreaker
        assertThat(nodeBRecoveryStates.size(), equalTo(1));
            .clear()
import org.opensearch.core.common.breaker.CircuitBreaker;
            docs[i] = client().prepareIndex(INDEX_NAME)
            .execute()
            https://github.com/opensearch-project/OpenSearch/issues/18098.
                        Settings.builder()
        int shardId,
                        .put("index.routing.allocation.include._name", nodeWithPrimary)
            connection.sendRequest(requestId, action, request, options);
                .prepareUpdateSettings(indexName)
        indexRandom(randomBoolean(), true, true, indexRequests);
            }
        flush(indexName);
        );
    private static final int REPLICA_COUNT = 0;
                assertTrue(
import org.opensearch.cluster.routing.UnassignedInfo;
            indexName,
        throws ExecutionException, InterruptedException {
            PeerRecoveryTargetService.Actions.FINALIZE };
                        PluginsService pluginService = internalCluster().getInstance(PluginsService.class, node.getName());
        String clusterManagerNodeName = internalCluster().startClusterManagerOnlyNode(nodeSettings);
                } catch (InterruptedException e) {
            .cluster()
        assertThat(indexState.time(), greaterThanOrEqualTo(0L));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)
        validateIndexRecoveryState(nodeCRecoveryStates.get(0).getIndex());
        }
            }
import org.opensearch.test.engine.MockEngineSupport;
            startRecoveryRequest.metadataSnapshot().getCommitUserData().entrySet()
            this.recoveryActionToBlock = recoveryActionToBlock;
            if (PeerRecoverySourceService.Actions.START_RECOVERY.equals(action)) {
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "12h")
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                            .cluster()
            client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
    }
            }
        logger.info("--> performing ops-based recoveries up to [{}%] of docs", reasonableOperationsBasedRecoveryProportion * 100.0);
    }
        );
        });
        ensureGreen();
                .setTransientSettings(
            }
            assertAcked(client().admin().indices().prepareOpen(INDEX_NAME));
                    .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 1.0)
                redMockTransportService.disconnectFromNode(blueMockTransportService.getLocalDiscoNode());
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
        assertAcked(
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            finalizeReceived,
        Settings secondNodeToStopDataPathSettings = internalCluster().dataPathSettings(secondNodeToStop);
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            TransportService.class,
                            () -> assertThat(
                requestBlocked.countDown();
                .put("index.number_of_shards", 1)
        MockTransportService blueTransportService = (MockTransportService) internalCluster().getInstance(
                        )
import org.opensearch.indices.IndicesService;
                ShardId shardId = startRecoveryRequest.shardId();
    }
        }
                .stream()
        // start a cluster-manager node
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
                // nodeB stopped, peer recovery from nodeA to nodeC, it will be cancelled after nodeB get started.
    protected int numDocs() {
                blueMockTransportService.disconnectFromNode(redMockTransportService.getLocalDiscoNode());
            );
                    return super.onNodeStopped(nodeName);
        SearchResponse searchResponse = client().prepareSearch(indexName).get();
     */
    protected Matcher<Long> getMatcherForThrottling(long value) {
            internalCluster().ensureAtLeastNumDataNodes(3);
import java.util.concurrent.Semaphore;
        private final AtomicBoolean finalizeReceived;
                        recoveryState.getTranslog().incrementRecoveredOperations(localRecoveredOps.get());
        ensureGreen();
                new RecoveryActionBlocker(dropRequests, recoveryActionToBlock, requestFailed)
            blueNodeName
        logger.info("--> speeding up recoveries");
                    RetentionLeases retentionLeases = internalCluster().getInstance(IndicesService.class, node)
                            + Strings.toString(MediaTypeRegistry.JSON, retentionLeases)
            .get();
                                    - reasonableOperationsBasedRecoveryProportion)
        });
            discoveryNodes.get(replicaShardRouting.currentNodeId()).getName(),
        assertFalse(stateResponse.getState().getRoutingNodes().node(blueNodeId).isEmpty());
            if (recoveryActionToBlock.equals(action) || requestBlocked.getCount() == 0) {
        );
            connection.sendRequest(requestId, action, request, options);
            this.finalizeReceived = finalizeReceived;
        logger.info("--> start node A");
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
            logger.info("--> sending request {} on {}", action, connection.getNode());
        );
        }
            indexName,
            assertThat(nodeName + " throttling should be >0", recoveryStats.throttleTime().millis(), getMatcherForThrottling(0));
            .getState();
        ensureGreen("test");
        return greaterThan(value);
import org.opensearch.snapshots.SnapshotState;
        SetOnce<Integer> localRecoveredOps = new SetOnce<>();
                    final RecoveryState recoveryState = internalCluster().getInstance(IndicesService.class, failingNode)
                .stream()
                    )
        }
            IntStream.range(0, numDocs).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
    public void testSnapshotRecovery() throws Exception {
            internalCluster().restartNode(
import org.opensearch.core.index.shard.ShardId;
                    .put("number_of_replicas", replicaCount)
    }
                );
            .indices()
                    );
        internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Collection;
        final List<IndexRequestBuilder> indexRequests = IntStream.range(0, between(10, 500))
    public void testRerouteRecovery() throws Exception {
        RecoveryState state,
                        everyItem(equalTo(StoreStats.UNKNOWN_RESERVED_BYTES))
                .setSource(singletonMap("test_field", Integer.toString(i)), MediaTypeRegistry.JSON)
            client().admin()
                .setSource("foo-int", randomInt(), "foo-string", randomAlphaOfLength(32), "foo-float", randomFloat());
        );
import java.util.ArrayList;
        logger.info("--> restarting cluster");
            phase1ReadyBlocked.await();
                connection.sendRequest(requestId, action, request, options);
        final RepositoryData repositoryData = PlainActionFuture.get(repository::getRepositoryData);
                .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                );
                .clear()
            .collect(Collectors.toList());
 * this work for additional information regarding copyright
        ensureSearchable(indexName);
                    future.get();
                .collect(Collectors.toSet())
            final ShardStats[] shardsStats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards();
        assertAcked(
import org.apache.lucene.analysis.TokenStream;
        internalCluster().assertSeqNos();
import org.opensearch.test.BackgroundIndexer;
        assertHitCount(client().prepareSearch(indexName).get(), numDocs);
        internalCluster().fullRestart();
        Settings firstNodeToStopDataPathSettings = internalCluster().dataPathSettings(firstNodeToStop);
                .put("index.number_of_shards", 1)
        // is decremented, which may happen after the recovery was done.
        transportService.clearAllRules();
        assertThat(nodeAResponses.size(), equalTo(1));
                            .collect(toList())
    public void testAllocateEmptyPrimaryResetsGlobalCheckpoint() throws Exception {
            .indices()
import java.util.concurrent.atomic.AtomicInteger;
        final String redNodeName = internalCluster().startNode(Settings.builder().put("node.attr.color", "red").put(nodeSettings).build());
        String[] recoveryActions = new String[] {
        // noinspection OptionalGetWithoutIsPresent because it fails the test if absent
        internalCluster().assertSameDocIdsOnShards();
        // update on the primary is delayed). To verify the local recovery stats, we have to manually remember this value in the
        final RecoveryState recoveryState = client().admin()
        logger.info("--> snapshot");
        logger.info("--> start node C");
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
                .cluster()
        }
        boolean primary,
        }
            .prepareCreateSnapshot(REPO_NAME, SNAP_NAME)
            randomBoolean(),
            );
                phase1ReadyBlocked.countDown();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            }
        assertThat(indexState.recoveredFilesPercent(), greaterThanOrEqualTo(0.0f));
                        assertThat(recoveryState.getTranslog().totalLocal(), equalTo(0));
                        Thread.sleep(disconnectAfterDelay.millis());
                    primary.renewRetentionLease(
        RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
                        .getShardOrNull(new ShardId(resolveIndex(indexName), 0))
                        .put(INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(), new ByteSizeValue(chunkSize, ByteSizeUnit.BYTES))
            }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        indexRandom(
                            .getNodes()
                assertThat(state.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(nodeB));
                Settings.builder()
            .prepareRecoveries(indexName)
                .mapToLong(n -> n.getIndices().getStore().getReservedSize().getBytes())
        private final String actionName;
                logger.info("--> preventing {} response by closing response channel", recoveryActionToBlock);
            Settings.builder()
                    .put("number_of_shards", shardCount)
        assertAcked(
        if (closedIndex) {
        final List<IndexRequestBuilder> indexRequests = IntStream.range(0, between(10, 500))
        );
        try {
            recoveryActionToBlock,
        final AtomicBoolean recoveryStarted = new AtomicBoolean(false);
    private static final int MAX_DOC_COUNT = 1000;
                        localRecoveredOps.set(recoveryState.getTranslog().totalLocal());
            assertThat(state.getTargetNode().getName(), equalTo(targetNode));
            Stack trace:
                assertThat(
        SequenceNumbers.CommitInfo commitInfoAfterLocalRecovery = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
            .prepareReroute()
            .getShardOrNull(new ShardId(resolveIndex(indexName), 0));
            assertThat(indexRecoveryStates.getKey(), equalTo(INDEX_NAME));
    public void testDoNotInfinitelyWaitForMapping() {
            @Override
 * not use this file except in compliance with the License.
        String indexName = "test-index";
        validateIndexRecoveryState(nodeCRecoveryStates.get(0).getIndex());
import java.util.concurrent.CountDownLatch;
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();
        }
            .build();
            expectedRecoverySource = RecoverySource.EmptyStoreRecoverySource.INSTANCE;
        if (closedIndex == false) {
        );
                assertThat(nodeCRecoveryStates.size(), equalTo(1));
        logger.info("--> bump replica count");
        transport.addSendBehavior((connection, requestId, action, request, options) -> {
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
    }
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
                    .prepareUpdateSettings(indexName)
        assertAcked(
        logger.info("--> add replica for {} on node: {}", INDEX_NAME, nodeB);
        return between(MIN_DOC_COUNT, MAX_DOC_COUNT);
        }
            MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
        long chunkSize = Math.max(1, shardSize.getBytes() / 10);
        );
        final IndexShardRoutingTable indexShardRoutingTable = clusterService().state().routingTable().shardRoutingTable(shardId);
            ensureStableCluster(2);
                            .get()
                            .getStore()
            if (startRecoveryRequest.targetNode().equals(recoveryState.getTargetNode())) {
        assertBusy(() -> assertThat(primary.getLastSyncedGlobalCheckpoint(), equalTo(maxSeqNoBeforeRecovery)));
                client().admin()
            NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
                    // ensures that it's considered as valid recovery attempt by source
                .map(node -> node.getName())
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(Settings.builder().put("index.number_of_replicas", 0))
        indexRandom(true, requests);
            .actionGet();
            clusterManagerNodeName
            Settings.builder()
                requestFailed.countDown();
        if (primaryRelocation) {
        final String recoveryActionToBlock = randomFrom(recoveryActions);
            final RecoveryStats recoveryStats = nodeStats.getIndices().getRecoveryStats();
        int threeFourths = (int) (numDocs * 0.75);
                .setSource("foo-int", randomInt(), "foo-string", randomAlphaOfLength(32), "foo-float", randomFloat());
            MockFSIndexStore.TestPlugin.class,
        final long maxSeqNoAfterRecovery = primary.seqNoStats().getMaxSeqNo();
    public void testRecoverLocallyUpToGlobalCheckpoint() throws Exception {
                validateIndexRecoveryState(recoveryState.getIndex());
        CountDownLatch allowToCompletePhase1Latch = new CountDownLatch(1);
                assertThat("expect an operation-based recovery", recoveryState.getIndex().fileDetails(), empty());
import org.opensearch.core.common.unit.ByteSizeValue;
            docs[i] = client().prepareIndex(name)
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertRecoveryState(recoveryState, 0, RecoverySource.ExistingStoreRecoverySource.INSTANCE, true, Stage.DONE, null, node);
    private void assertOnGoingRecoveryState(
                .get()
        assertThat(recoveryState.getIndex().totalFileCount(), greaterThan(0));
            // shutdown node with relocation source of replica shard and check if recovery continues
            transportService.clearAllRules();
        } else {
            .setSettings(Settings.builder().put("number_of_replicas", 1))
        }
        flush(indexName);
        }, TimeValue.timeValueSeconds(60), TimeValue.timeValueMillis(500));
        // node that held it previously, in case that node hasn't completely cleared it up.
        for (Thread indexer : indexers) {
            redNodeName
        validateIndexRecoveryState(nodeBRecoveryStates.get(0).getIndex());
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        shard.failShard("test", new IOException("simulated"));
import org.opensearch.index.recovery.RecoveryStats;
            assertNull(state.getSourceNode());
                assertThat("node A should not have ongoing recovery as target", recoveryStats.currentAsTarget(), equalTo(0));
        assertThat(nodeBRecoveryStates.size(), equalTo(1));
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
                            + "]"
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "blue")
                    );
            assertNull(state.getTargetNode());
            .size();
        assertAcked(
            StreamSupport.stream(Spliterators.spliterator(clusterService().state().nodes().getDataNodes().values(), 0), false)
                    .setSettings(
                        nodeIndicesStats.getShardStats(clusterState.metadata().index(indexName).getIndex())
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                    logger.info("--> preventing {} request by dropping request", action);
            randomBoolean(),
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        ensureGreen(indexName);
    }
                            .put("index.routing.allocation.include._name", nodeWithPrimary + "," + nodeWithReplica)
            randomBoolean(),
        validateIndexRecoveryState(recoveryState.getIndex());
        internalCluster().ensureAtLeastNumDataNodes(2);
import org.apache.lucene.index.IndexCommit;
    private static final String SNAP_NAME = "test-snap-1";
                } else if (reason.equals(circuit)) {
        final IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
    }
    }
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeA);
            false,
    }
                throw new NodeClosedException(nodeWithOldPrimary);
        }
            nodeARecoveryStates = findRecoveriesForTargetNode(nodeA, recoveryStates);
                            .isTimedOut()
            .build();
        for (int i = 0; i < indexers.length; i++) {
        final DiscoveryNodes discoveryNodes = clusterService().state().nodes();
 */
import static org.hamcrest.Matchers.isOneOf;
            this.requestBlocked = requestBlocked;
        redTransportService.addSendBehavior(blueTransportService, (connection, requestId, action, request, options) -> {
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
        } else {
        final RecoveryState recoveryState = client().admin()
        String nodeWithPrimary = internalCluster().startDataOnlyNode();
                    throw new CircuitBreakingException("Broken", CircuitBreaker.Durability.PERMANENT);
        private final String indexName;
        List<RecoveryState> nodeResponses = new ArrayList<>();
        flush();
        int numDocs = scaledRandomIntBetween(100, 8000);
                .setTransientSettings(
        final IndexShardRoutingTable indexShardRoutingTable = clusterService().state().routingTable().shardRoutingTable(shardId);
                .put("index.routing.allocation.include._name", String.join(",", dataNodes))
                                client(blueNodeName).admin()
        }
        List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
        String indexName = "test-index";
                        .put("index.number_of_replicas", 1)
        final Settings nodeSettings = Settings.builder()
import static org.opensearch.action.DocWriteResponse.Result.CREATED;
                requestFailed.countDown();
    public void testHistoryRetention() throws Exception {
        RecoveryState state,
                            .flatMap(s -> Arrays.stream(s.getShards()))
            validator.accept(action, request);
                client().admin()
    }
        assertHitCount(client().prepareSearch().get(), numDocs);
                Settings.builder()
    }
        }
        logger.info("--> restore");
        ensureGreen();
 * license agreements. See the NOTICE file distributed with
                .put("index.routing.allocation.include._name", String.join(",", dataNodes))
        MockTransportService redMockTransportService = (MockTransportService) internalCluster().getInstance(
                        Math.round(
            randomBoolean(),
            .filter(rs -> rs.getPrimary() == false)
        );
import org.opensearch.common.SetOnce;
        int numDocs = randomIntBetween(0, 100);
                    throw new AssertionError(e);
import org.opensearch.index.IndexSettings;
            if (blocksRemaining.getAndUpdate(i -> i == 0 ? 0 : i - 1) != 0) {
                            .isTimedOut()
            if (nodeStats.getNode().getName().equals(nodeA)) {
                .build()
            client().admin()
                            .setWaitForNodes(Integer.toString(discoveryNodes.getSize() - 1))
        });
            client().admin()
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
            .get(clusterState.routingTable().index(indexName).shard(0).primaryShard().currentNodeId());
            )
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        } else {
        boolean primaryRelocation = randomBoolean();
    public void testUsesFileBasedRecoveryIfRetentionLeaseAheadOfGlobalCheckpoint() throws Exception {
            long requestId,
                while (stopped.get() == false) {
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            logger.info("--> closing connections from source node to target node");
            .indices()
            .stream()
             */
                }
import org.opensearch.action.index.IndexResponse;
            expectedRecoverySource = RecoverySource.ExistingStoreRecoverySource.INSTANCE;
            "should have lease for " + replicaShardRouting,
        );
        return Arrays.asList(
        assertRecoveryState(nodeBRecoveryState, 0, PeerRecoverySource.INSTANCE, false, Stage.DONE, nodeA, nodeB);
    private void assertRecoveryStateWithoutStage(
                    indexRandom(
                    "total recovered translog operations must include both local and remote recovery",
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
            .setSettings(
        assertThat(
        // Ensures that you can remove a replica and then add it back again without any ill effects, even if it's allocated back to the
                } else {
        validateIndexRecoveryState(nodeARecoveryStates.get(0).getIndex());
        // relocations of replicas are marked as REPLICA and the source node is the node holding the primary (B)
                            .setWaitForEvents(Priority.LANGUID)
            /*
                    primary.removeRetentionLease(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replicaShardRouting), future);
        return nodeResponses;
                .prepareCreate(indexName)
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "1s")
                assertOnGoingRecoveryState(nodeCRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, nodeA, nodeC);
        logger.info("--> create repository");
            IndicesService.class,
    public void testCancelNewShardRecoveryAndUsesExistingShardCopy() throws Exception {
            NodesStatsResponse statsResponse1 = client().admin()
        for (RecoveryState recoveryState : recoveryStates) {
import java.util.concurrent.ExecutionException;
        if (randomBoolean()) {
        logger.info("--> request recoveries");
        final String indexName = "test-index";
            this.recoveryStarted = recoveryStarted;
    /**
        final Index index = resolveIndex(INDEX_NAME);
        final IndexShard primary = internalCluster().getInstance(
 *
        private SingleStartEnforcer(String indexName, AtomicBoolean recoveryStarted, AtomicBoolean finalizeReceived) {
        assertThat(client().prepareSearch(name).setSize(0).get().getHits().getTotalHits().value(), equalTo((long) numDocs));
            connection.sendRequest(requestId, action, request, options);
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                @Override
                }
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "12h")
            }
                logger.info("--> closing connections from target node to source node");
            MockTransportService transportService = (MockTransportService) internalCluster().getInstance(
            .add(new MoveAllocationCommand(INDEX_NAME, 0, nodeA, nodeB))
        });
            reasonableOperationsBasedRecoveryProportion = randomDoubleBetween(0.05, 0.99, true);
            )
        SearchResponse searchResponse = client().prepareSearch(indexName).get();
        logger.info("--> request node recovery stats");
        searchResponse = client(redNodeName).prepareSearch(indexName).setPreference("_local").get();
            });
        assertRecoveryState(recoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, Stage.DONE, nodeA, nodeB);
            );
                .put("index.number_of_replicas", 0)
        for (int i = 0; i < threeFourths; i++) {
                .put("index.number_of_shards", 1)
import org.opensearch.index.analysis.TokenFilterFactory;
        nodeBRecoveryStates = findRecoveriesForTargetNode(nodeB, recoveryStates);
                    shardStats.getRetentionLeaseStats().retentionLeases() + " should discard history up to " + maxSeqNo,
                    );
        ensureGreen(indexName);
        final String indexName = "test";
    }
                }
        final String blueNodeId = internalCluster().getInstance(ClusterService.class, blueNodeName).localNode().getId();
        internalCluster().startNode();
    }
        TransportService blueTransportService = internalCluster().getInstance(TransportService.class, blueNodeName);
                        getMatcherForThrottling(finalNodeBThrottling)
            new InternalTestCluster.RestartCallback() {
        CountDownLatch readyToRestartNode = new CountDownLatch(1);
    }
                )
            .findFirst()
        logger.info("--> start nodes");
        String indexName = "test-index";
            client().admin().indices().prepareStats(indexName).get().getShards()[0].getRetentionLeaseStats()
                        .leases()
                redTransportService.disconnectFromNode(blueTransportService.getLocalDiscoNode());
    ) {
                clusterService().state().nodes().getClusterManagerNode().getName(),
                } else if (reason.equals(network)) {
                    Settings.builder()
                     * ==> docCount <  newDocCount + docCount - ceil((newDocCount + docCount) * p)
        final Settings randomNodeDataPathSettings = internalCluster().dataPathSettings(randomFrom(dataNodes));
    public void testRepeatedRecovery() throws Exception {
            Settings.builder()
        createIndex(
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        ensureGreen();
            if (PeerRecoveryTargetService.Actions.CLEAN_FILES.equals(action)) {
                            RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING.getDefault(Settings.EMPTY)
            Settings.builder().put("node.attr.color", "blue").put(nodeSettings).build()
        createIndex(
        assertRecoveryStateWithoutStage(state, shardId, type, primary, sourceNode, targetNode);
    }
        } else {
        assertThat(startRecoveryRequest.startingSeqNo(), equalTo(lastSyncedGlobalCheckpoint + 1));
        });
        String indexName = "test-index";
        );
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(Settings.builder().put("index.number_of_replicas", 1))
            indexName,
                        Settings.builder()
                if (action.equals(PeerRecoverySourceService.Actions.START_RECOVERY)) {
        final RecoverySource expectedRecoverySource;
                            client().admin().indices().prepareStats(indexName).get().getShards()[0].getRetentionLeaseStats()
        return client().admin().indices().prepareStats(name).execute().actionGet();
                                .retentionLeases()
        public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
                            .cluster()
                    assertThat(recoveryState.getTranslog().recoveredOperations(), equalTo(recoveryState.getTranslog().totalLocal()));
        for (Thread indexer : indexers) {
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())
        }
        ) throws IOException {
                .prepareNodesStats()
        );
        });
            return singletonMap(
            Settings.builder()
        createIndex(
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertThat(recoveryStats.currentAsTarget(), equalTo(0));
            .shardRecoveryStates()
        ensureGreen(indexName);
            .get()
        internalCluster().startNodes(
                            .putNull("index.routing.allocation.include._name")
        // force a shard recovery from nodeA to nodeB
            .setSettings(
import org.opensearch.cluster.node.DiscoveryNode;
                .prepareNodesStats()
        assertThat(startedShards.size(), equalTo(2));
        String indexName = "test-index";
            .get(clusterState.routingTable().index(indexName).shard(0).primaryShard().currentNodeId());
                    } catch (IllegalStateException | OpenSearchException ignored) {}
            .get();
            client().admin()
                        )
        validateIndexRecoveryState(nodeARecoveryState.getIndex());
                connection.sendRequest(requestId, action, request, options);
        final DiscoveryNodes discoveryNodes = clusterService().state().nodes();
                .put("index.analysis.analyzer.test_analyzer.tokenizer", "standard")
    public void testDisconnectsWhileRecovering() throws Exception {
}
        assertThat(recoveryStates.size(), equalTo(0));  // Should not expect any responses back
        blueMockTransportService.clearAllRules();
                .get()
                .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "200ms")
        MockTransportService blueMockTransportService = (MockTransportService) internalCluster().getInstance(
                if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numOfDocs);
import org.opensearch.core.index.Index;
            .collect(Collectors.toList());
        ensureGreen(indexName);
        // force a shard recovery from nodeA to nodeB
                new RecoveryActionBlocker(dropRequests, recoveryActionToBlock, requestFailed)
            assertThat(recoveryStats.currentAsSource(), equalTo(0));
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
                            .setSource(
            .findFirst()
        // validate node A recovery
            .shardRecoveryStates()
        final String nodeWithoutData = internalCluster().startDataOnlyNode();
                String circuit = "circuit";
        for (int i = 0; i < numDocs; i++) {
        Runnable connectionBreaker = () -> {
                .collect(Collectors.toList());
        );
            IntStream.range(0, randomIntBetween(0, 10))
                .collect(toList())
        assertBusy(() -> {
 *
                    .prepareUpdateSettings(indexName)
                    new Snapshot(REPO_NAME, createSnapshotResponse.getSnapshotInfo().snapshotId()),
            ClusterState state = client().admin().cluster().prepareState().get().getState();
                final RecoveryStats recoveryStats = nodeStats.getIndices().getRecoveryStats();
                .indices()
        public void messageReceived(
        assertAcked(
        internalCluster().ensureAtLeastNumDataNodes(3);
        } else {
        };
        );
            .prepareRecoveries(indexName)
        CountDownLatch phase1ReadyBlocked = new CountDownLatch(1);
            client().admin()
                .collect(toList())
            recoveryStarted.set(true);
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            .build();
                    assertNotEquals(action, ShardStateAction.SHARD_FAILED_ACTION_NAME);
                        recoveryState.getTranslog().totalLocal(localRecoveredOps.get());
                try {
        try {
            randomBoolean(),
        List<IndexRequestBuilder> requests = new ArrayList<>();
                    Settings.builder()
                }
        MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
        );
                }
                    assertFalse(
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
import org.opensearch.index.seqno.SequenceNumbers;
        final int numNewDocs = scaledRandomIntBetween(25, 250);
            List<RecoveryState> recoveryStates = indexRecoveryStates.getValue();
import java.util.stream.StreamSupport;
        private final boolean dropRequests;
        int shardId,
        );
                .build()
            client().admin()
 * ownership. Elasticsearch licenses this file to you under
    public void testCancelRecoveryWithAutoExpandReplicas() throws Exception {
            .setWaitForCompletion(true)
            this.connectionBreaker = connectionBreaker;
            assertAcked(
        ensureGreen();
                    Settings.builder()
                    throw new OpenSearchRejectedExecutionException();
                     * The replica has docCount docs, i.e. has operations with seqnos [0..docCount-1], so a seqno-based recovery will start
            .get(indexName)
        String nodeA = internalCluster().startNode();
                if (action.equals(PeerRecoverySourceService.Actions.START_RECOVERY)) {
                     * from docCount < firstReasonableSeqNo
                .put("index.number_of_replicas", 1)
        }
            "--> start recovery request: starting seq_no {}, commit {}",
                            .map(s -> s.getStats().getStore().getReservedSize().getBytes())
                            .prepareHealth()
import static org.hamcrest.Matchers.hasSize;
        logger.info("--> index more documents");
            IndicesService.class,
            ensureGreen(INDEX_NAME);
        private final AtomicBoolean recoveryStarted;
import org.opensearch.index.shard.IndexShard;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        private final String recoveryActionToBlock;
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        @Override
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        }
                            .cluster()
                .prepareUpdateSettings()
        MockTransportService transport = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeWithPrimary);
            String actionName,
                    throw new ConnectTransportException(connection.getNode(), "DISCONNECT: prevented " + action + " request");
            INDEX_NAME,
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertThat(state.getStage(), not(equalTo(Stage.DONE)));
     * the source is working on the recovery process.
        CountDownLatch phase1ReadyBlocked = new CountDownLatch(1);
    public void slowDownRecovery(ByteSizeValue shardSize) {
            .actionGet()
            // update. We want to assert that the first and only recovery attempt succeeds
        CountDownLatch phase1ReadyBlocked = new CountDownLatch(1);
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes(">=3").get();
        );
                                    .getRoutingTable()
        );
            client().prepareIndex("test")
        assertBusy(() -> assertNodeHasThrottleTimeAndNoRecoveries.accept(nodeB));
    }
        IndexShard shard = internalCluster().getInstance(IndicesService.class, failingNode)
            this.dropRequests = dropRequests;
        assertThat(nodeARecoveryStates.size(), equalTo(0));
                .setSettings(
                        ReplicationTracker.getPeerRecoveryRetentionLeaseId(replicaShardRouting),
        assertThat(client().admin().indices().prepareFlush(indexName).setForce(true).execute().get().getFailedShards(), equalTo(0));
        client().admin()
        // wait for it to be finished
        client().admin()
            }
        final CountDownLatch requestFailed = new CountDownLatch(1);
            PeerRecoveryTargetService.Actions.FINALIZE };
        internalCluster().startNode();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.node.NodeClosedException;
                     * ==> 0 <= newDocCount * (1-p) - ceil(docCount * p) - 1
                Settings.builder()
            for (PeerRecoverySourceService recoveryService : internalCluster().getDataNodeInstances(PeerRecoverySourceService.class)) {
        final long localCheckpointOfSafeCommit;
        // noinspection OptionalGetWithoutIsPresent because it fails the test if absent
                String network = "network";
                                (1 + Math.ceil(docCount * reasonableOperationsBasedRecoveryProportion)) / (1
                .prepareUpdateSettings(indexName)
import org.opensearch.action.index.IndexRequestBuilder;
            .actionGet()
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
                validateIndexRecoveryState(nodeCRecoveryStates.get(0).getIndex());
                if ((primaryRelocation && finalized.get()) == false) {
            ensureGreen();
                .build()
import org.opensearch.cluster.NodeConnectionsService;
        if (targetNode == null) {
            randomBoolean(),
            );
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "12h")
        DiscoveryNode nodeWithOldPrimary = clusterState.nodes()
        internalCluster().startDataOnlyNode(randomNodeDataPathSettings);
            false,
     * Tests scenario where recovery target successfully sends recovery request to source but then the channel gets closed while
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.indices.analysis.AnalysisModule;
                    connection.sendRequest(requestId, action, request, options);
                long requestId,
            ) throws IOException {
        assertTrue(fileChunkIntercepted.get());
                client().admin()
                .prepareUpdateSettings(indexName)
        final RecoveryResponse recoveryResponse = client().admin().indices().recoveries(new RecoveryRequest(indexName)).get();
import org.opensearch.core.common.Strings;
            .shardRecoveryStates()
            String nodeWithReplica = internalCluster().startDataOnlyNode();
        final ShardRouting replicaShardRouting = indexShardRoutingTable.replicaShards().get(0);
                                not(empty())
            (long) recoveryState.getTranslog().recoveredOperations(),
                    assertFalse(
            assertThat(shardStats.getSeqNoStats().getGlobalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        MockTransportService transport = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeWithPrimary);
        List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
        // start a cluster-manager node
                logger.info("--> sending request {} on {}", action, connection.getNode());
            }
            MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
            .getState();
        logger.info("--> move shard from: {} to: {}", nodeA, nodeB);
        CountDownLatch allowToCompletePhase1Latch = new CountDownLatch(1);
        }
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        private final AtomicBoolean recoveryStarted;
        final IndexShard primary = internalCluster().getInstance(
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        }
        );
                .setSettings(
    }
        }
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
            ensureGreen(TimeValue.timeValueSeconds(62), indexName);
        internalCluster().ensureAtLeastNumDataNodes(2);
        final String indexName = "test";
import org.hamcrest.Matcher;
        logger.info("--> slowing down recoveries");
            assertThat(nodesStatsResponse.getNodes(), hasSize(1));
            public void sendRequest(
        logger.info("--> restarting cluster");
        logger.info("--> creating test index: {}", name);
            indexer.join();
                public Settings onNodeStopped(String nodeName) throws Exception {
                .setSettings(
            randomBoolean(),
        internalCluster().restartNode(nodeB, new InternalTestCluster.RestartCallback() {
                    } else {
                            .getIndices()
        final Settings.Builder settings = Settings.builder()
                    );
                .put("index.number_of_replicas", 1)
        String sourceNode,
                        .cluster()
        final RecoveryState nodeBRecoveryState = nodeBResponses.get(0);
                    );
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        assertThat(recoveryStates.size(), equalTo(2));
            );
                        assertBusy(
        logger.info("--> speeding up recoveries");
        for (ShardRouting shardRouting : startedShards) {
            nodeCRecoveryStates = findRecoveriesForTargetNode(nodeC, recoveryStates);
            logger.info("--> starting primary relocation recovery from blue to red");
            .get();
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();
        final String indexName = "test";
                    flush(indexName);
                assertRecoveryState(recoveryState, 0, recoverySource, true, Stage.DONE, null, nodeA);
                }
                        .put("index.routing.allocation.include._name", nodeWithPrimary)
            Settings.builder()
                    try {
            ).localCheckpoint;
/*
                    );
            }
        final String blueNodeName = internalCluster().startNode(
        logger.info("--> start node A");
            Runnable connectionBreaker
                    assertThat(nodeIndicesStats.getStore().getReservedSize().getBytes(), equalTo(0L));
                    connection.sendRequest(requestId, action, request, options);
            .put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), "100ms")
                RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
            if (PeerRecoveryTargetService.Actions.CLEAN_FILES.equals(action) && blockRecovery.tryAcquire()) {
        );
        // make sure nodeA has primary and nodeB has replica
        final String nodeA = internalCluster().startNode();
                     *       =  newDocCount - (newDocCount * p + ceil(docCount * p) + 1)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 * Unless required by applicable law or agreed to in writing,
                            .get(0)
            .stream()
                }
            settings.put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), reasonableOperationsBasedRecoveryProportion);
                nodeBThrottling = recoveryStats.throttleTime().millis();
                        ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
                )
                .put("index.routing.allocation.include._name", String.join(",", nodes))
            PeerRecoveryTargetService.Actions.CLEAN_FILES,
        for (Map.Entry<String, List<RecoveryState>> indexRecoveryStates : response.shardRecoveryStates().entrySet()) {
            PeerRecoveryTargetService.Actions.PREPARE_TRANSLOG,
                .get()
            localCheckpointOfSafeCommit = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
            TestAnalysisPlugin.class,
                .prepareUpdateSettings(INDEX_NAME)
                StartRecoveryRequest startRecoveryRequest = (StartRecoveryRequest) request;
import org.opensearch.common.unit.TimeValue;
        String targetNode
                .get()
        assertThat(indexState.recoveredFilesPercent(), lessThanOrEqualTo(100.0f));
        refresh(INDEX_NAME);
        assertRecoveryState(nodeCRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, Stage.DONE, nodeB, nodeC);
        long nodeAThrottling = Long.MAX_VALUE;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // ASF Disabled
                     *     newDocCount >= (ceil(docCount * p) + 1) / (1-p)
                        "DISCONNECT: simulation disconnect after successfully sending " + action + " request"
            String action,
        final long docCount = shardStats.getStats().docs.getCount();
                            .get()
        List<RecoveryState> nodeARecoveryStates = findRecoveriesForTargetNode(nodeA, recoveryStates);
        assertBusy(() -> {
                .cluster()
        ensureGreen(indexName);
                .prepareUpdateSettings(INDEX_NAME)
                        .get(0)
    private List<RecoveryState> findRecoveriesForTargetNode(String nodeName, List<RecoveryState> recoveryStates) {
                     * ==> it is unreasonable to recover the replica using a seqno-based recovery
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
                    // to recover from the primary, so we must be careful not to perform an operations-based recovery if this would require
            indexName,
                .build()
            final RecoveryStats recoveryStats = nodeStats.getIndices().getRecoveryStats();
        assertThat(client().admin().indices().prepareFlush(indexName).setForce(true).execute().get().getFailedShards(), equalTo(0));
        assertBusyWithFixedSleepTime(() -> {
                        Settings.builder()
            client().admin()
            }
        assertThat(state.getPrimary(), equalTo(primary));
                        randomBoolean(),
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(
            randomBoolean(),
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes(">=3").get();
                        )
import static java.util.Collections.singletonMap;
        indexRandom(
                return super.onNodeStopped(nodeName);
    private static final int SHARD_COUNT = 1;
            recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
        final AtomicBoolean finalized = new AtomicBoolean();
        }
                }
        String indexName = "test-index";
            redMockTransportService.addSendBehavior(
                    assertBusy(
    ) {
        return false;
            .get();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
            .get();
import org.opensearch.transport.TransportChannel;
            Settings.builder()
                        .get()
                }
        assertHitCount(searchResponse, numDocs);
        String targetNode
                final long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
        logger.info("--> request recoveries");
        internalCluster().startNode();
                if (nodeStats.getNode().getName().equals(nodeA)) {
                    .setSettings(
        internalCluster().restartNode(
        indexRandom(
            transportService.addSendBehavior((connection, requestId, action, request, options) -> {
import org.opensearch.transport.Transport;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
    /** Makes sure the new cluster-manager does not repeatedly fetch index metadata from recovering replicas */
        requestFailed.await();
                        randomBoolean(),
        @Override
            .setIndices(INDEX_NAME)
        RecoverySource type,
                phase1ReadyBlocked.countDown();
                            .get();
        );
                    );
            }
        assertAcked(
        List<String> nodes = randomSubsetOf(
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
                                MediaTypeRegistry.JSON
            .put(RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.getKey(), "10s")
                finalizeReceived.set(true);
        final AtomicBoolean finalizeReceived = new AtomicBoolean(false);
            });
            discoveryNodes.get(indexShardRoutingTable.primaryShard().currentNodeId()).getName()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            );
        final AtomicBoolean fileInfoIntercepted = new AtomicBoolean();
                        .allMatch(l -> l.retainingSequenceNumber() == maxSeqNo + 1)
        ensureGreen(indexName);
        assertThat(recoveryStates, hasSize(1));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                }
                            .collect(toList())
        assertThat(response.isTimedOut(), is(false));
        client().admin().indices().preparePutMapping("test").setSource("test_field", "type=text,analyzer=test_analyzer").get();
                handler.messageReceived(request, channel, task);
        final String nodeA = internalCluster().startNode();
                logger.info("--> attempting to send start_recovery request for shard: " + shardId);
            .prepareCreate(indexName)
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
        }
        assertThat(commitInfoAfterLocalRecovery.localCheckpoint, equalTo(lastSyncedGlobalCheckpoint));
        if (closedIndex) {
            .indices()
                    assertFalse(
            }
        RecoveryState recoveryState = recoveryStates.get(0);
            2,
            MockTransportService.TestPlugin.class,
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));
            AtomicBoolean finalizeReceived,
            assertThat(indicesService.indexServiceSafe(index).getShard(0).recoveryStats().currentAsTarget(), equalTo(1));
        assertThat(indexState.recoveredBytesPercent(), greaterThanOrEqualTo(0.0f));
                Settings.builder()
        StartRecoveryRequest startRecoveryRequest = startRecoveryRequestFuture.actionGet();
            .indices()
    protected boolean shouldAssertOngoingRecoveryInRerouteRecovery() {
        for (RecoveryState recoveryState : client().admin().indices().prepareRecoveries().get().shardRecoveryStates().get(indexName)) {
        );
        final RecoveryState recoveryState = client().admin()
        );
import java.util.stream.Collectors;
                            + "retention leases"
        }
                logger.info("--> sending request {} on {}", action, connection.getNode());
                        .stream()
                                Collections.singletonMap("f" + randomIntBetween(1, 10), randomNonNegativeLong()),
            at org.opensearch.transport.TransportService$TimeoutHandler.run(TransportService.java:1399) ~[main/:?]
        indexRandom(randomBoolean(), true, true, indexRequests);
        });
            assertThat(recoveryStates.size(), equalTo(totalShards));
        final Settings nodeSettings = Settings.builder()
            2,
        logger.info("--> start node C");
                        .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), chunkSize, ByteSizeUnit.BYTES)
                    .setSettings(
                if (fileInfoIntercepted.compareAndSet(false, true)) {
        assertThat(response.isTimedOut(), is(false));
        ensureGreen();
            PeerRecoveryTargetService.Actions.FILE_CHUNK,
                    final int newDocCount = Math.toIntExact(
        final long finalNodeBThrottling = nodeBThrottling;
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
        );
                    .setSettings(
            .execute()
        RecoveryState state,
            .getStore()
        final List<RecoveryState> recoveryStates = recoveryResponse.shardRecoveryStates().get(indexName);
            .filter(rs -> rs.getPrimary() == false)
        assertThat(indexState.recoveredBytesPercent(), lessThanOrEqualTo(100.0f));
                                    .prepareState()
            MockEngineFactoryPlugin.class
            assertTrue(
                }
        ensureGreen(INDEX_NAME);
            if (shardRouting.primary()) {
            .findFirst()
        );
import org.opensearch.plugins.Plugin;
import org.opensearch.cluster.routing.RecoverySource;
        restoreRecoverySpeed();
                     *       <  newDocCount - (ceil(newDocCount * p) + ceil(docCount * p))
            assertAcked(
        final String indexName = "test";
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .stream()
                    allowToCompletePhase1Latch.await();
                            )
        assertAcked(client().admin().indices().prepareDelete("test")); // cancel recoveries
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.indices.NodeIndicesStats;
            // time passes
        client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.number_of_replicas", 1)).get();
                    // some operations that are not being retained. Emulate this by advancing the lease ahead of the replica's GCP:
                        randomBoolean(),
        final double reasonableOperationsBasedRecoveryProportion;
                     *
        }
        while (requests.size() < replicatedDocCount) {
        assertRecoveryState(nodeARecoveryState, 0, expectedRecoverySource, true, Stage.DONE, null, nodeA);
                    Settings.builder()
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                    && state.routingTable().index(indexName).shardsWithState(ShardRoutingState.INITIALIZING).size() == 1
            equalTo(0L)
        ensureGreen();
        ensureGreen(INDEX_NAME);
                        .recoveryState();
        validateIndexRecoveryState(nodeBRecoveryStates.get(0).getIndex());
                    Version.CURRENT,
                        .prepareNodesStats(connection.getNode().getId())
        // is a mix of file chunks and translog ops
        validateIndexRecoveryState(nodeARecoveryStates.get(0).getIndex());
                .isAcknowledged()
            // Always break connection from source to remote to ensure that actions are retried
        internalCluster().fullRestart();
                        );
        // noinspection StatementWithEmptyBody
                .get();
        Semaphore recoveryBlocked = new Semaphore(1);
                .prepareCreate(indexName)
                     *
    private static final String INDEX_NAME = "test-idx-1";
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
        );
        indexRandom(
                    throw new IllegalStateException("Recovery cannot be started twice");
        for (int i = 0; i < numDocs; i++) {
            assertAcked(
            .setWaitForCompletion(true)
        });
                finalized.set(true);
        int numDocs = between(1, 10);
                            .get()
    }
        final AtomicBoolean throwParsingError = new AtomicBoolean();
        logger.info("--> move replica shard from: {} to: {}", nodeA, nodeC);
        client().admin().indices().prepareClose(INDEX_NAME).execute().actionGet();
        final String nodeB = internalCluster().startNode();
import org.opensearch.common.settings.Settings;
        assertThat(nodeARecoveryStates.size(), equalTo(1));
    public void testDisconnectsDuringRecovery() throws Exception {
    private void restoreRecoverySpeed() {
        MockTransportService redMockTransportService = (MockTransportService) internalCluster().getInstance(
            )
        recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
        assertBusy(() -> assertNodeHasThrottleTimeAndNoRecoveries.accept(nodeA));
                        IntStream.range(0, between(1, 100))
            waitForDocs(numOfDocs, indexer);
        }
            assertRecoveryState(nodeBRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, Stage.DONE, nodeA, nodeB);
                )
                }
                        () -> assertFalse(
            for (NodeStats nodeStats : dataNodeStats) {
import org.opensearch.test.transport.MockTransportService;
            assertNotNull(state.getSourceNode());
            randomBoolean(),
        );
            Shard assignment is stuck because recovery is blocked at CLEAN_FILES stage. Once, it times out after 60s the replica shards get assigned.
    public void testGatewayRecovery() throws Exception {
import org.opensearch.plugins.AnalysisPlugin;
            }
            )
            .shardRecoveryStates()
        assertThat(recoveryStates.get(0).getIndex().totalFileCount(), is(0));
            TransportService.class,
            this.recoveryStarted = recoveryStarted;
                .putList("index.analysis.analyzer.test_analyzer.filter", "test_token_filter")
        ensureSearchable(indexName);
                            .prepareHealth()
            "test",
            PeerRecoveryTargetService.Actions.FILE_CHUNK,
import org.opensearch.snapshots.Snapshot;
    public void testOngoingRecoveryAndClusterManagerFailOverForASFDisabled() throws Exception {
        logger.info("--> slowing down recoveries");
        RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
import org.opensearch.transport.TransportRequestHandler;
        // Peer recovery fails if the primary does not see the recovering replica in the replication group (when the cluster state
            redNodeName
        List<RecoveryState> nodeAResponses = findRecoveriesForTargetNode(nodeA, recoveryStates);
                );
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
import org.opensearch.repositories.RepositoryData;
            searchResponse = client(redNodeName).prepareSearch(indexName).setPreference("_local").get();
        TransientReceiveRejected handlingBehavior = new TransientReceiveRejected(
        }
                    );
                logger.info("--> preventing {} response by closing response channel", recoveryActionToBlock);
            assertThat(shardStats.getSeqNoStats().getMaxSeqNo(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            public Settings onNodeStopped(String nodeName) throws Exception {
                .prepareCreate(indexName)
import java.util.List;
                        .getRetentionLeases();
        String targetNode
            client().admin().cluster().prepareGetSnapshots(REPO_NAME).setSnapshots(SNAP_NAME).get().getSnapshots().get(0).state(),
import java.util.Arrays;
                    logger.info("--> preventing {} request by throwing ConnectTransportException", action);
        for (int i = 0; i < numDocs; i++) {
        );
                        // one chunk per sec..
        for (String node : nodes) {
        Stage stage,
            assertAcked(client().admin().indices().prepareClose(INDEX_NAME));
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "red"))
                    );
        for (DiscoveryNode node : clusterService().state().nodes()) {
                    logger.info("--> preventing {} response by throwing exception", actionName);
            PeerRecoveryTargetService.Actions.CLEAN_FILES,
        }
    private static final String REPO_NAME = "test-repo-1";
        String node = internalCluster().startNode();
                            .getReservedSize()
        final ShardRouting replicaShardRouting = indexShardRoutingTable.replicaShards().get(0);
    }
            false,
                nodeAThrottling = recoveryStats.throttleTime().millis();
            )
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                            .clear()
        for (int i = threeFourths; i < numDocs; i++) {
            phase1ReadyBlocked.await();
                            .setWaitForNodes(Integer.toString(discoveryNodes.getSize() - 1))
        final String indexName = "test";
                            .put("index.routing.allocation.include._name", nodeWithPrimary + "," + nodeWithReplica)
        }
        } finally {
            redTransportService.clearAllRules();
            );
                        client().admin()
        restoreRecoverySpeed();
        allowToCompletePhase1Latch.countDown();
            .stream()
            discoveryNodes.get(indexShardRoutingTable.primaryShard().currentNodeId()).getName()
                                    .getState()
                .filter(nodeStats -> nodeStats.getNode().isDataNode())
        );
                        .getIndices();
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
        final RecoveryState recoveryState = client().admin()
                    throw new AssertionError(e);
        assertRecoveryState(nodeBRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, Stage.DONE, nodeA, nodeB);
                            .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
                .clear()
                "test_token_filter",
                .prepareReroute()
            .get(indexName)
            if (action.equals("indices:data/write/bulk[s][r]") && randomInt(100) < 5) {
        assertThat(
                        recoveryStats.throttleTime().millis(),
        }
        client().admin()
            .get()
                .setSettings(
                .prepareUpdateSettings()
        MockTransportService redTransportService = (MockTransportService) internalCluster().getInstance(
            // if a primary relocation fails after the source shard has been marked as relocated, both source and target are failed. If the
            }
            client().admin()
                }
            blueMockTransportService.addRequestHandlingBehavior(recoveryActionToBlock, (handler, request, channel, task) -> {
                phase1ReadyBlocked.await();
import org.opensearch.index.IndexService;
                .retentionLeases()
        boolean primary,
        assertThat(state.getShardId().getId(), equalTo(shardId));
                        .retentionLeases()
            indexName,
                assertThat(recoveryService.numberOfOngoingRecoveries(), equalTo(0));
                    } catch (InterruptedException e) {
            this.blocksRemaining = new AtomicInteger(randomIntBetween(1, 3));
            prepareCreate(
                )
    public void testReplicaRecovery() throws Exception {
            // The cluster state applier will immediately attempt to retry the recovery on a cluster state
        final String nodeB = internalCluster().startNode();
        recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
    private class TransientReceiveRejected implements StubbableTransport.RequestHandlingBehavior<TransportRequest> {
                        getMatcherForThrottling(finalNodeAThrottling)
            startRecoveryRequest.startingSeqNo(),
        int numDocs = randomIntBetween(10, 200);
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(
import org.opensearch.transport.TransportRequest;
        }
        PlainActionFuture<StartRecoveryRequest> startRecoveryRequestFuture = new PlainActionFuture<>();
                TransportRequest request,
                } catch (InterruptedException e) {
        assertRecoveryState(nodeARecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, Stage.DONE, nodeB, nodeA);
            randomBoolean(),
                // Sometimes break connection from remote to source to ensure that recovery is re-established
                new InternalTestCluster.RestartCallback()
            .put(RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.getKey(), "1s")
            }
        try {
        internalCluster().ensureAtLeastNumDataNodes(2);
        ensureGreen(indexName);
import org.opensearch.transport.TransportService;
        });
        Semaphore blockRecovery = new Semaphore(1);
            client().admin()
            PeerRecoverySourceService.Actions.START_RECOVERY,
                        .clear()
            .prepareRestoreSnapshot(REPO_NAME, SNAP_NAME)
        assertRecoveryState(nodeARecoveryStates.get(0), 0, RecoverySource.EmptyStoreRecoverySource.INSTANCE, true, Stage.DONE, null, nodeA);
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), false).build()
    }
        slowDownRecovery(shardSize);
import org.opensearch.repositories.Repository;
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
        for (ShardStats shardStats : client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()) {
        );
            randomBoolean(),
            nodeWithOldPrimary.getName()
                try {
    @Override
                .indices()
    }
        );
                assertThat("node A should have ongoing recovery as source", recoveryStats.currentAsSource(), equalTo(1));
        String firstNodeToStop = randomFrom(internalCluster().getDataNodeNames());
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
        });
 * The OpenSearch Contributors require contributions made to
                Settings.builder()
        assertThat(shardStats.getStats().docs.getDeleted(), equalTo(0L));
                                    .shard(0)
                        .put(
            blueTransportService.disconnectFromNode(redTransportService.getLocalDiscoNode());
                            Math.ceil(
                     */
        final boolean dropRequests = randomBoolean();
                    Settings.builder()
            this.indexName = indexName;
        blueMockTransportService.addSendBehavior(redMockTransportService, (connection, requestId, action, request, options) -> {
                    assertThat(
import org.opensearch.common.Priority;
                        throw new RuntimeException(e);
        long nodeBThrottling = Long.MAX_VALUE;
        });
                    .indices()
        for (String node : nodes) {
        // Flush twice to update the safe commit's local checkpoint
        logger.info("--> create index on node: {}", nodeA);
                        client().admin()
        logger.info("--> waiting for recovery to start both on source and target");
                    final PlainActionFuture<ReplicationResponse> future = new PlainActionFuture<>();
import org.opensearch.cluster.routing.ShardRouting;
            redNodeName
        internalCluster().startNode();
                new InternalTestCluster.RestartCallback()
        for (int i = 0; i < numDocs; i++) {
        public void sendRequest(
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;
        RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
        indexRandom(true, requests);
                .build()
import org.opensearch.gateway.ReplicaShardAllocatorIT;
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
        internalCluster().startNodes(3);
                            )
                .indices()
        response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
        assertThat(state.getRecoverySource(), equalTo(recoverySource));
                            .prepareNodesStats(connection.getNode().getId())
            assertHitCount(client().prepareSearch(indexName).get(), numDocs);
            private final AtomicInteger count = new AtomicInteger();
        super.beforeIndexDeletion();
            .get()
        }
        );
                .prepareUpdateSettings(indexName)
            @Override
                    assertThat(
                if (fileChunkIntercepted.compareAndSet(false, true)) {
                    @Override
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            Settings.builder()
                        assertThat(response.getResult(), isOneOf(CREATED, UPDATED));
            connection.sendRequest(requestId, action, request, options);
            assertThat(shardStats.getSeqNoStats().getLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
            IntStream.range(0, randomIntBetween(0, 10))
        }
        private final AtomicInteger blocksRemaining;
                            .get()
        assertThat(client().admin().indices().prepareFlush(indexName).get().getFailedShards(), equalTo(0));
                if (indexName.equals(shardId.getIndexName()) && recoveryStarted.get() && finalizeReceived.get() == false) {
    }
        private final AtomicBoolean finalizeReceived;
    }
        );
                    .indices()
    }
        );
            assertThat(state.getSourceNode().getName(), equalTo(sourceNode));
        ensureGreen(indexName);
                final long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
        assertBusy(() -> assertNodeHasThrottleTimeAndNoRecoveries.accept(nodeB));
        Thread[] indexers = new Thread[randomIntBetween(1, 8)];
                .prepareCreate("test")
        String sourceNode,
                name,
        int numDocs = scaledRandomIntBetween(25, 250);
import static org.hamcrest.Matchers.empty;
                .build()
        );
                    )
                Transport.Connection connection,
            indicesService = internalCluster().getInstance(IndicesService.class, nodeB);
            );
                )
            .cluster()
                throw new NodeClosedException(nodeWithOldPrimary);
import org.opensearch.index.store.Store;
import org.opensearch.index.store.StoreStats;
        assertThat(nodeCRecoveryStates.size(), equalTo(1));
            TransportService.class,
            allowToCompletePhase1Latch.countDown();
            this.actionName = actionName;
        } finally {
import org.opensearch.index.seqno.RetentionLeases;
                if (dropRequests) {
        assertThat(nodeBResponses.size(), equalTo(1));
        );
                } else {
                    logger.info("--> preventing {} response by breaking connection", actionName);
                    // We do not guarantee that the replica can recover locally all the way to its own global checkpoint before starting
        createIndex(
        logger.info("--> restart node B");
                            .cluster()
        ensureGreen();
                .indices()
        internalCluster().stopRandomDataNode();
            discoveryNodes.get(replicaShardRouting.currentNodeId()).getName(),
import org.opensearch.indices.recovery.RecoveryState.Stage;
                stopped.set(true);
                node.getName()
                .put("index.number_of_replicas", 0)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                            .prepareHealth()
            TransportService.class,
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));
        internalCluster().restartNode(
                    )
        final SingleStartEnforcer validator = new SingleStartEnforcer(indexName, recoveryStarted, finalizeReceived);
                .add(new AllocateEmptyPrimaryAllocationCommand(indexName, 0, nodeWithoutData, true))
                     *              == localCheckpoint + 1    - ceil((newDocCount + docCount) * p)
        final Settings nodeSettings = Settings.builder()
        ensureGreen(indexName);
        List<RecoveryState> nodeBRecoveryStates = findRecoveriesForTargetNode(nodeB, recoveryStates);
                nodeResponses.add(recoveryState);
        );
