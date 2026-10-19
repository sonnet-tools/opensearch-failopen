                     *  
                } catch (InterruptedException e) {
        for (int i = 0; i < numDocs; i++) {
            assertThat(recoveryStats.currentAsSource(), equalTo(0));  
                RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(),
            .actionGet();  
    }  
        assertAcked(
        if (closedIndex) {
        final RecoveryState recoveryState = client().admin()  
            .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms");
            new InternalTestCluster.RestartCallback() {
        logger.info("--> performing ops-based recoveries up to [{}%] of docs", reasonableOperationsBasedRecoveryProportion * 100.0);
        ensureGreen();  
            Transport.Connection connection,
        logger.info("--> start node A");
            // source shard is moved back to started because the target fails first, it's possible that there is a cluster state where the
            indexName,
            // will be reallocated. The cluster will thus become green, then red, then green again. Triggering a refresh here before  
        indexRandom(  
            IndicesService.class,
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
            randomBoolean(),
            .prepareRecoveries(indexName)
                    )
            ensureGreen();  
                .setId("u" + i)  
        final RepositoryData repositoryData = PlainActionFuture.get(repository::getRepositoryData);
            .get();  
import static org.opensearch.action.DocWriteResponse.Result.CREATED;
            public void sendRequest(
import static org.hamcrest.Matchers.is;  
            blueMockTransportService.addSendBehavior(  
            indicesService = internalCluster().getInstance(IndicesService.class, nodeB);
            assertThat(state.getTargetNode().getName(), equalTo(targetNode));  
            }  
            @SuppressForbidden(reason = "Simulating disconnect after sending request with a delay")
        client().admin().indices().prepareRefresh(indexName).get(); // avoid refresh when we are failing a shard  
        @Override  
        indexRandom(  
        final long docCount = shardStats.getStats().docs.getCount();
                assertTrue(  
                client().admin()
import java.util.stream.IntStream;
        indexRandom(randomBoolean(), true, true, indexRequests);
            equalTo(SnapshotState.SUCCESS)
        );
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeA);
        }
        transport.addSendBehavior((connection, requestId, action, request, options) -> {
    private static final String REPO_NAME = "test-repo-1";  
        internalCluster().ensureAtLeastNumDataNodes(2);  
                String rejected = "rejected";
        logger.info("--> request recoveries");  
        );  
                .build()
            PeerRecoveryTargetService.Actions.PREPARE_TRANSLOG,
        final AtomicBoolean throwParsingError = new AtomicBoolean();
        boolean primary,
                .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Recovery))
import org.opensearch.core.common.breaker.CircuitBreakingException;  
            assertThat(recoveryStates.size(), equalTo(totalShards));
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
        }  
        logger.info("--> snapshot");
        assertThat(shardStats.getSeqNoStats().getMaxSeqNo() + 1, equalTo(docCount));  
                assertThat("node B should not have ongoing recovery as source", recoveryStats.currentAsSource(), equalTo(0));
            IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeA);  
            if (recoveryActionToBlock.equals(action) || requestBlocked.getCount() == 0) {
        assertThat(recoveryState.getIndex().totalFileCount(), greaterThan(0));  
        assertThat(commitInfoAfterLocalRecovery.maxSeqNo, equalTo(lastSyncedGlobalCheckpoint));  
                    .indices()
            }  
                        .indexServiceSafe(resolveIndex(indexName))
        MockTransportService clusterManagerTransportService = (MockTransportService) internalCluster().getInstance(
                blueMockTransportService.disconnectFromNode(redMockTransportService.getLocalDiscoNode());
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numOfDocs);  
import org.opensearch.repositories.RepositoriesService;  
        final IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];
        final IndexShard primary = internalCluster().getInstance(  
                .indices()  
            .build();
 * The OpenSearch Contributors require contributions made to  
                    )  
            assertAcked(  
                            .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Store))
        client().admin().indices().prepareRefresh("test").get();  
            this.dropRequests = dropRequests;
        List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);  
            }
    }  
            client().admin()  
            });  
        final String indexName = "test-index";  
            .setWaitForCompletion(true)
        final DiscoveryNodes discoveryNodes = clusterService().state().nodes();
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes(">=3").get();  
                     *  
                    allowToCompletePhase1Latch.await();
            )  
        // Perform some replicated operations so the replica isn't simply empty, because ops-based recovery isn't better in that case  
            IntStream.range(0, randomIntBetween(0, 10))
        String sourceNode,
        );
            .get()
                    );
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {  
        );
import org.opensearch.common.unit.TimeValue;  
            .cluster()
            randomBoolean(),  
                );  
                .mapToLong(n -> n.getIndices().getStore().getReservedSize().getBytes())  
            } else {
            Settings.builder()  
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        final String indexName = "test";
            final RecoveryStats recoveryStats = nodeStats.getIndices().getRecoveryStats();
import org.opensearch.repositories.Repository;
                Settings.builder()
                .setSettings(  
        CountDownLatch allowToCompletePhase1Latch = new CountDownLatch(1);
            .setSettings(  
                    Settings.builder()
                nodeBThrottling = recoveryStats.throttleTime().millis();
                            )  
                            .getIndices()
                        }
            client().admin()
    private IndicesStatsResponse createAndPopulateIndex(String name, int nodeCount, int shardCount, int replicaCount)
        );  
import org.opensearch.action.support.PlainActionFuture;
 * under the License.  
        ensureSearchable(indexName);
                    Settings.builder()  
        slowDownRecovery(shardSize);  
                .indices()
                state.routingTable().index(indexName).shardsWithState(ShardRoutingState.UNASSIGNED).size() == 1
        assertAcked(  
    private static final int MAX_DOC_COUNT = 1000;
            Settings.builder()  
            logger.info("--> starting primary relocation recovery from blue to red");
        final IndexShard primary = internalCluster().getInstance(
            );  
                .put("index.analysis.analyzer.test_analyzer.type", "custom")
        int numDocs = scaledRandomIntBetween(25, 250);
        }
                if (indexName.equals(shardId.getIndexName()) && recoveryStarted.get() && finalizeReceived.get() == false) {  
        assertAcked(  
                )
        ensureGreen(INDEX_NAME);
            .prepareRecoveries(indexName)
        assertThat(nodeAResponses.size(), equalTo(1));
        final List<IndexRequestBuilder> indexRequests = IntStream.range(0, between(10, 500))
        });  
                                    .index("test")
    public void testHistoryRetention() throws Exception {
        final Settings.Builder settings = Settings.builder()  
        assertThat(nodeARecoveryStates.size(), equalTo(1));
                }
            assertOnGoingRecoveryState(nodeCRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, nodeB, nodeC);
                    throw new AssertionError(
    }
                // Sometimes break connection from remote to source to ensure that recovery is re-established  
 * the Apache License, Version 2.0 (the "License"); you may
            TransportService.class,
        }  
            )
        assertThat(nodeBRecoveryStates.size(), equalTo(1));
            if (action.equals(PeerRecoveryTargetService.Actions.FILES_INFO)) {  
            .prepareCreate(indexName)
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        );
        Semaphore blockRecovery = new Semaphore(1);
            transportService.clearAllRules();
            if (randomBoolean()) {
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
        logger.info("--> starting recovery from blue to red");  
                clusterService().state().nodes().getClusterManagerNode().getName(),
        for (int i = 0; i < indexers.length; i++) {
        );
        IndexShard shard = internalCluster().getInstance(IndicesService.class, failingNode)  
        final Index index = resolveIndex(INDEX_NAME);
    public void testRerouteRecovery() throws Exception {
        int numDocs = randomIntBetween(0, 100);
        final AtomicBoolean finalizeReceived = new AtomicBoolean(false);  
            this.finalizeReceived = finalizeReceived;
        createIndex(  
            false,
                    .indices()
    }  
        internalCluster().fullRestart();  
                .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "100ms")  
                .put("index.number_of_replicas", 1)
import org.opensearch.index.recovery.RecoveryStats;
        assertAcked(
        String targetNode
                );
            .stream()
                        .getIndices();
import org.opensearch.common.Priority;
        assertAcked(
        internalCluster().assertSameDocIdsOnShards();  
            });  
            randomBoolean(),
            this.actionName = actionName;  
    }  
                    );
                    /*
import org.opensearch.cluster.routing.RecoverySource;  
                )  
                .filter(nodeStats -> nodeStats.getNode().isDataNode())
import static org.hamcrest.Matchers.not;  
                    shardStats.getRetentionLeaseStats().retentionLeases() + " should discard history up to " + maxSeqNo,
                assertThat(nodeCRecoveryStates.size(), equalTo(1));
        CountDownLatch phase1ReadyBlocked = new CountDownLatch(1);
                requestBlocked.countDown();  
        private final AtomicInteger blocksRemaining;
                .cluster()
        final IndexShard primary = internalCluster().getInstance(
        String targetNode
                        Settings.builder()
        for (Thread indexer : indexers) {
            if (nodeStats.getNode().getName().equals(nodeB)) {
        SetOnce<Integer> localRecoveredOps = new SetOnce<>();  
        });
        flush(indexName);
        logger.info("--> add replica for {} on node: {}", INDEX_NAME, nodeB);
        } else {  
        CountDownLatch readyToRestartNode = new CountDownLatch(1);
    }
        internalCluster().startNode();
            if (PeerRecoveryTargetService.Actions.CLEAN_FILES.equals(action) && blockRecovery.tryAcquire()) {  
        final String blueNodeName = internalCluster().startNode(  
                            .getBytes(),
            assertHitCount(client().prepareSearch(indexName).get(), numDocs);
                    future.get();
            PeerRecoveryTargetService.Actions.FILE_CHUNK,
                    );
                handler.messageReceived(request, channel, task);
        });  
import org.opensearch.indices.recovery.RecoveryState.Stage;  
            validateIndexRecoveryState(nodeBRecoveryStates.get(0).getIndex());
                    Settings.builder()  
            TransportService.class,
    }
    /** Makes sure the new cluster-manager does not repeatedly fetch index metadata from recovering replicas */
        assertAcked(
            internalCluster().ensureAtLeastNumDataNodes(3);
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "12h")  
            createSnapshotResponse.getSnapshotInfo().successfulShards(),
        indexRandom(true, docs);  
import org.opensearch.core.index.Index;
        );  
    }  
        logger.info("--> slowing down recoveries");
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();
                                    .prepareState()
                .setSettings(
        // wait for it to be finished  
                .build()
                        getMatcherForThrottling(finalNodeAThrottling)
                    return super.onNodeStopped(nodeName);
                .map(node -> node.getName())
        createIndex(indexName, settings.build());
                if (nodeStats.getNode().getName().equals(nodeA)) {
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
        final ShardRouting replicaShardRouting = indexShardRoutingTable.replicaShards().get(0);  
        CountDownLatch allowToCompletePhase1Latch = new CountDownLatch(1);  
                            .clear()  
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all"))
                String circuit = "circuit";
        final ShardRouting replicaShardRouting = indexShardRoutingTable.replicaShards().get(0);
        String secondNodeToStop = randomFrom(internalCluster().getDataNodeNames());
                phase1ReadyBlocked.countDown();
        searchResponse = client(redNodeName).prepareSearch(indexName).setPreference("_local").get();  
                } catch (InterruptedException e) {
        );
        }
                .put("index.routing.allocation.include._name", String.join(",", dataNodes))
                .setNodesIds(nodeName)
        assertHitCount(searchResponse, numDocs);
        );
            client().admin()  
            MockTransportService transportService = (MockTransportService) internalCluster().getInstance(  
            );
 */
        }  
        final IndexShardRoutingTable indexShardRoutingTable = clusterService().state().routingTable().shardRoutingTable(shardId);
            /*
        MockTransportService redMockTransportService = (MockTransportService) internalCluster().getInstance(  
            // Always break connection from source to remote to ensure that actions are retried
                    );  
        final int numDocs = numDocs();
                .get();
        private final AtomicBoolean recoveryStarted;  
import org.opensearch.plugins.Plugin;
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));  
import org.opensearch.indices.IndicesService;  
                    } catch (Exception e) {
                        randomBoolean(),  
                    assertThat(
                     * from docCount < firstReasonableSeqNo
        logger.info("--> indexing sample data");  
                    final PlainActionFuture<ReplicationResponse> future = new PlainActionFuture<>();  
        logger.info("--> restarting cluster");
        return Arrays.asList(
        for (int i = 0; i < numNewDocs; i++) {
                        .cluster()  
        logger.info("--> create index on node: {}", nodeA);  
                    connectionBreaker.run();
        final long finalNodeBThrottling = nodeBThrottling;
        String nodeA = internalCluster().startNode();
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "blue")  
            .shardRecoveryStates()
        // noinspection StatementWithEmptyBody
        internalCluster().startNode(randomFrom(firstNodeToStopDataPathSettings, secondNodeToStopDataPathSettings));
                            .map(s -> s.getStats().getStore().getReservedSize().getBytes())
                new RecoveryActionBlocker(dropRequests, recoveryActionToBlock, requestFailed)  
            }
        List<RecoveryState> nodeARecoveryStates = findRecoveriesForTargetNode(nodeA, recoveryStates);
        assertBusy(() -> assertThat(primary.getLastSyncedGlobalCheckpoint(), equalTo(maxSeqNoBeforeRecovery)));
                    throw new AssertionError(e);
        internalCluster().startNode();  
        // is a mix of file chunks and translog ops
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            for (PeerRecoverySourceService recoveryService : internalCluster().getDataNodeInstances(PeerRecoverySourceService.class)) {  
            randomBoolean(),
 * this work for additional information regarding copyright
                )
    }
                        .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Store))  
        );  
    private void restoreRecoverySpeed() {
        // we should now have two total shards, one primary and one replica
                        recoveryState.getTranslog().totalLocal(localRecoveredOps.get());
            NodesStatsResponse statsResponse1 = client().admin()  
            if (PeerRecoveryTargetService.Actions.CLEAN_FILES.equals(action)) {
            "--> start recovery request: starting seq_no {}, commit {}",
        internalCluster().stopRandomDataNode();
        // make sure nodeA has primary and nodeB has replica  
                    shardStats.getRetentionLeaseStats()
                final long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
    private static final String INDEX_NAME = "test-idx-1";
        assertThat(
        allowToCompletePhase1Latch.countDown();  
            }  
            .prepareUpdateSettings(INDEX_NAME)  
            assertRecoveryState(nodeBRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, Stage.DONE, nodeA, nodeB);
                        .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "red,blue")
                     * ==> 0 <= newDocCount * (1-p) - ceil(docCount * p) - 1
            Settings.builder()
            .execute()
                .put("index.number_of_replicas", 0)
                .setWaitForActiveShards(ActiveShardCount.NONE)
        assertThat(client().admin().indices().prepareFlush(indexName).get().getFailedShards(), is(0)); // makes a safe commit
        logger.info("--> waiting for recovery to start both on source and target");  
                    }  
    protected void beforeIndexDeletion() throws Exception {
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes(String.valueOf(nodeCount)).get().isTimedOut());  
            // Fail on the receiving side.  
        );
import org.opensearch.cluster.routing.ShardRoutingState;
                .build()
                            .get(0)
                final long maxSeqNo = shardStats.getSeqNoStats().getMaxSeqNo();
        assertAcked(
            assertHitCount(searchResponse, numDocs);  
                }
        SequenceNumbers.CommitInfo commitInfoAfterLocalRecovery = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
                    } else {
        logger.info("--> start node B");
                .build()
                .cluster()
        final IndexShardRoutingTable indexShardRoutingTable = clusterService().state().routingTable().shardRoutingTable(shardId);
        final DiscoveryNodes discoveryNodes = clusterService().state().nodes();  
                .get()  
                List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
                .add(new AllocateEmptyPrimaryAllocationCommand(indexName, 0, nodeWithoutData, true))
            discoveryNodes.get(indexShardRoutingTable.primaryShard().currentNodeId()).getName()
            .prepareNodesStats()  
            .get();  
            client().admin().cluster().prepareGetSnapshots(REPO_NAME).setSnapshots(SNAP_NAME).get().getSnapshots().get(0).state(),
    }
            .collect(Collectors.toList());  
        RestoreSnapshotResponse restoreSnapshotResponse = client().admin()
                    throw new ConnectTransportException(connection.getNode(), "DISCONNECT: prevented " + action + " request");  
            randomBoolean(),  
        validateIndexRecoveryState(nodeBRecoveryStates.get(0).getIndex());
        ).getShardOrNull(shardId);  
        for (int i = 0; i < numDocs; i++) {  
import org.opensearch.indices.analysis.AnalysisModule;
        ensureGreen(indexName);  
            finalizeReceived,
                new InternalTestCluster.RestartCallback()
            assertThat(indicesService.indexServiceSafe(index).getShard(0).recoveryStats().currentAsSource(), equalTo(1));
        RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
            connection.sendRequest(requestId, action, request, options);  
            .indices()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                .prepareCreate(indexName)
        logger.info("--> start node B");
        ensureGreen(indexName);
            redNodeName
        logger.info("--> move replica shard from: {} to: {}", nodeA, nodeC);
        String[] recoveryActions = new String[] {
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            internalCluster().restartNode(
                .isAcknowledged()
        );
                    assertBusy(  
import org.opensearch.index.seqno.ReplicationTracker;  
        final IndexShardRoutingTable indexShardRoutingTable = clusterService().state().routingTable().shardRoutingTable(shardId);  
            .add(new MoveAllocationCommand(INDEX_NAME, 0, nodeA, nodeC))  
        logger.info("--> start nodes");  
                        if (throwParsingError.get()) {
            for (RecoveryState recoveryState : recoveryStates) {  
            .get(indexName)
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
                redTransportService,
public class IndexRecoveryIT extends OpenSearchIntegTestCase {  
        for (NodeStats nodeStats : statsResponse.getNodes()) {  
        final List<IndexRequestBuilder> requests = new ArrayList<>();
                throw new NodeClosedException(nodeWithOldPrimary);
                            .cluster()
    }
                        Thread.sleep(disconnectAfterDelay.millis());  
            client().admin()
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(Settings.builder().put("index.number_of_replicas", 1))
        client().admin().indices().prepareClose(INDEX_NAME).execute().actionGet();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, SHARD_COUNT)  
        assertTrue(fileChunkIntercepted.get());  
        CreateSnapshotResponse createSnapshotResponse = client().admin()  
        return nodeResponses;
                    Settings.builder()
        );  
            assertFalse(client().admin().cluster().prepareHealth(indexName).setWaitForActiveShards(2).get().isTimedOut());
import org.opensearch.transport.ConnectTransportException;
                            .flatMap(s -> Arrays.stream(s.getShards()))  
        logger.info("--> bump replica count");  
        ensureGreen(indexName);
             */
        indexRandom(  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                     *       =  newDocCount - (newDocCount * p + ceil(docCount * p) + 1)
                    shardStats.getRetentionLeaseStats()
                } else if (reason.equals(network)) {
                Settings.builder()
                .setSource(singletonMap("test_field", Integer.toString(i)), MediaTypeRegistry.JSON)
        );
        internalCluster().startNodes(
                        client().admin()
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        createIndex(  
        String indexName = "test";  
                            .stream()
import org.opensearch.cluster.metadata.IndexMetadata;
        client().admin()
        final long localCheckpointOfSafeCommit;  
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numOfDocs);
        );  
            redNodeName
        assertThat(  
        private final CountDownLatch requestBlocked;
            }
            .prepareCreate(indexName)
            .indices()
        internalCluster().ensureAtLeastNumDataNodes(2);
        String indexName = "test-index";
                        localRecoveredOps.set(recoveryState.getTranslog().totalLocal());
        RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
                            .setWaitForNodes(Integer.toString(discoveryNodes.getSize() - 1))
        );
        );
        RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
        client().admin()
 */  
        ensureSearchable(indexName);  
            }
        List<IndexRequestBuilder> requests = new ArrayList<>();
                String network = "network";  
        public void messageReceived(
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            });
            }  
}  
            );
        assertThat(indexState.recoveredBytesPercent(), lessThanOrEqualTo(100.0f));
        final long finalNodeAThrottling = nodeAThrottling;  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
        assertRecoveryState(nodeCRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, Stage.DONE, nodeB, nodeC);
                            .setWaitForNodes(Integer.toString(discoveryNodes.getSize() - 1))
        MockTransportService transport = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeWithPrimary);  
            // The cluster state applier will immediately attempt to retry the recovery on a cluster state  
            .indices()
            );  
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;  
        logger.info("--> request recoveries");
import org.opensearch.test.engine.MockEngineSupport;  
import java.util.stream.Collectors;
                public Settings onNodeStopped(String nodeName) throws Exception {  
        }
 * GitHub history for details.
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeA));  
                            .setWaitForEvents(Priority.LANGUID)  
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {  
        final boolean dropRequests = randomBoolean();
    }
        TransportService blueTransportService = internalCluster().getInstance(TransportService.class, blueNodeName);
                        .clear()
        // wait for all history to be discarded
                    logger.info("--> preventing {} response by throwing exception", actionName);  
                        assertThat(response.getResult(), isOneOf(CREATED, UPDATED));
            blueTransportService.disconnectFromNode(redTransportService.getLocalDiscoNode());
                    connection.sendRequest(requestId, action, request, options);  
        List<String> nodes = randomSubsetOf(
                requestFailed.countDown();  
        createIndex(
        createIndex(  
    }
                     *  
        );
                    "total recovered translog operations must include both local and remote recovery",
        }
                .prepareNodesStats()
import java.util.concurrent.CountDownLatch;  
                .put("index.routing.allocation.include._name", String.join(",", dataNodes))  
    public void testRecoverLocallyUpToGlobalCheckpoint() throws Exception {  
            .findFirst()
                new InternalTestCluster.RestartCallback()  
                    new Snapshot(REPO_NAME, createSnapshotResponse.getSnapshotInfo().snapshotId()),  
    public void testDisconnectsDuringRecovery() throws Exception {
        RecoverySource recoverySource,  
            ensureGreen(); // also waits for relocation / recovery to complete
        }
        nodeBRecoveryStates = findRecoveriesForTargetNode(nodeB, recoveryStates);
                try {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
 * specific language governing permissions and limitations
        RecoverySource type,
    public void slowDownRecovery(ByteSizeValue shardSize) {
            assertThat(shardStats.getSeqNoStats().getLocalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));  
                .prepareUpdateSettings(INDEX_NAME)
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                .cluster()  
                .get()  
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                        Settings.builder()  
            randomBoolean(),  
        } else {
                    indexRandom(
            assertThat(dataNodeStats, hasSize(2));
        final AtomicBoolean finalized = new AtomicBoolean();
        int numDocs = randomIntBetween(10, 200);
import org.opensearch.transport.TransportService;
                .get();  
                node.getName()
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Semaphore blockRecovery = new Semaphore(1);  
            TransportService.class,  
        internalCluster().startNode(nodeSettings);
        );
            client().admin()
                .get()  
        assertAcked(  
                .put("index.number_of_replicas", 1)
    private static final int REPLICA_COUNT = 0;  
 * ownership. Elasticsearch licenses this file to you under  
            .cluster()
        ensureGreen(indexName);
            ) throws IOException {
        assertHitCount(client().prepareSearch().get(), numDocs);
                            + "retention leases"
                        randomBoolean(),
                    .put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), 1.0)
                    .prepareUpdateSettings(indexName)
            Settings.builder()
            .put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), "100ms")  
                    throw new ConnectTransportException(
        redTransportService.addSendBehavior(blueTransportService, (connection, requestId, action, request, options) -> {  
    private List<RecoveryState> findRecoveriesForTargetNode(String nodeName, List<RecoveryState> recoveryStates) {
        // Flush twice to update the safe commit's local checkpoint
    /**
                                client(blueNodeName).admin()  
    }
            .stream()
        }  
        final Settings nodeSettings = Settings.builder()
            MockTransportService.TestPlugin.class,
            .cluster()  
    public void testGatewayRecovery() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                client().admin()
        public void sendRequest(
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
                            .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))  
            });
        while (requests.size() < replicatedDocCount) {  
            at org.opensearch.transport.TransportService$TimeoutHandler.run(TransportService.java:1399) ~[main/:?]
        final IndexRequestBuilder[] docs = new IndexRequestBuilder[numDocs];  
            NodesStatsResponse nodesStatsResponse = client().admin()
        assertThat(recoveryState.getIndex().totalFileCount(), greaterThan(0));
        return greaterThan(value);
                    try {
        validateIndexRecoveryState(nodeARecoveryStates.get(0).getIndex());
import org.opensearch.core.common.unit.ByteSizeUnit;
        logger.info("--> slowing down recoveries");  
        // wait for peer recovery from nodeA to nodeB which is a no-op recovery so it skips the CLEAN_FILES stage and hence is not blocked
        assertThat((long) localRecoveredOps.get(), equalTo(lastSyncedGlobalCheckpoint - localCheckpointOfSafeCommit));  
                        )
            this.blocksRemaining = new AtomicInteger(randomIntBetween(1, 3));
        // hold peer recovery on phase 2 after nodeB down
                    logger.info("--> preventing {} response by breaking connection", actionName);  
import org.opensearch.transport.TransportRequest;
            }  
        // we have to use assertBusy as recovery counters are decremented only when the last reference to the RecoveryTarget
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();  
                } else {
            Settings.builder().put("node.attr.color", "blue").put(nodeSettings).build()
                                .retentionLeases()
            client().admin()
            .get()  
        ensureGreen(indexName);  
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        assertThat(recoveryStates, hasSize(1));  
        MockTransportService blueTransportService = (MockTransportService) internalCluster().getInstance(
            false,
            return singletonMap(  
        }
import org.opensearch.transport.TransportChannel;  
                    );  
                            .getStore()  
        logger.info("--> index more documents");
                    assertThat(
        assertTrue(
                    if (startRecoveryRequestFuture.isDone()) {  
        } else {
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
        }
                    throw new IllegalStateException("Recovery cannot be started twice");
            https://github.com/opensearch-project/OpenSearch/issues/18098.  
import java.util.Map;
        final String nodeA = internalCluster().startNode();
            if (shardRouting.primary()) {
        }
            nodeCRecoveryStates = findRecoveriesForTargetNode(nodeC, recoveryStates);
            Shard assignment is stuck because recovery is blocked at CLEAN_FILES stage. Once, it times out after 60s the replica shards get assigned.
        assertBusy(() -> {
            Task task  
            }  
    }  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            )
import org.opensearch.core.common.breaker.CircuitBreaker;
            // Fail on the sending side
        } else {
            assertAcked(
        NodesStatsResponse statsResponse = client().admin()
        indexRandom(randomBoolean(), true, true, indexRequests);
                        randomBoolean(),
                .prepareCreate(indexName)
    @Override
        for (int i = 0; i < 10; i++) {  
        final ShardRouting replicaShardRouting = indexShardRoutingTable.replicaShards().get(0);
import org.opensearch.plugins.AnalysisPlugin;  
    public void testUsesFileBasedRecoveryIfOperationsBasedRecoveryWouldBeUnreasonable() throws Exception {
                            .prepareHealth()
                                (1 + Math.ceil(docCount * reasonableOperationsBasedRecoveryProportion)) / (1
                            .setWaitForNodes(Integer.toString(discoveryNodes.getSize() - 1))  
                phase1ReadyBlocked.countDown();  
    }
            assertThat(state.getSourceNode().getName(), equalTo(sourceNode));  
                .put("index.number_of_shards", 1)
import org.opensearch.cluster.node.DiscoveryNode;  
    }
        indexRandom(  
        assertThat(nodeCRecoveryStates.size(), equalTo(1));
            AtomicBoolean finalizeReceived,  
        }  
            .getState();  
import java.util.Spliterators;
            false,
                                    - reasonableOperationsBasedRecoveryProportion)
        );  
        internalCluster().ensureAtLeastNumDataNodes(2);
    ) {  
                        return tokenStream;
            PeerRecoverySourceService.Actions.START_RECOVERY,
                        nodeIndicesStats.getShardStats(clusterState.metadata().index(indexName).getIndex())
                .collect(toList())
        final String redNodeName = internalCluster().startNode(Settings.builder().put("node.attr.color", "red").put(nodeSettings).build());  
        // is decremented, which may happen after the recovery was done.
            .put(  
            )
        Stage stage,  
                logger.info("--> attempting to send start_recovery request for shard: " + shardId);
        private final String actionName;  
                            .setWaitForEvents(Priority.LANGUID)
                        throw new RuntimeException(e);
                        .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), 0)
                String action,
                        client().admin()
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.opensearch.cluster.routing.RecoverySource.PeerRecoverySource;
        }  
        );
            Settings.builder()  
import java.io.IOException;
        for (int i = 0; i < threeFourths; i++) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 6))
                            .setWaitForEvents(Priority.LANGUID)
        assertRecoveryState(recoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, Stage.DONE, nodeA, nodeB);
import org.opensearch.index.store.StoreStats;
                                    .getAllInitializingShards(),  
            docs[i] = client().prepareIndex(name)
                        .getNodes()
                            .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
                .clear()  
        int threeFourths = (int) (numDocs * 0.75);  
        internalCluster().ensureAtLeastNumDataNodes(2);
                        .put("index.routing.allocation.include._name", nodeWithPrimary)  
            .prepareRestoreSnapshot(REPO_NAME, SNAP_NAME)
            );
            .execute()
        List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);  
        internalCluster().startNodes(3);  
        assertThat(nodeBRecoveryStates.size(), equalTo(1));  
        createAndPopulateIndex(INDEX_NAME, 1, SHARD_COUNT, REPLICA_COUNT);  
        );
                    .setSettings(
 * this file be licensed under the Apache-2.0 license or a
            }
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        internalCluster().restartNode(nodeWithOldPrimary.getName(), new InternalTestCluster.RestartCallback());  
        StartRecoveryRequest startRecoveryRequest = startRecoveryRequestFuture.actionGet();
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        String indexName = "test-index";  
            String nodeWithReplica = internalCluster().startDataOnlyNode();
                    RetentionLeases retentionLeases = internalCluster().getInstance(IndicesService.class, node)
        internalCluster().startNode();
            nodeWithOldPrimary.getName()
        final ShardStats shardStats = client().admin().indices().prepareStats(indexName).get().getShards()[0];  
            discoveryNodes.get(indexShardRoutingTable.primaryShard().currentNodeId()).getName()
                )
        );  
            AtomicBoolean recoveryStarted,
        String nodeC = internalCluster().startNode();
            .prepareRecoveries(indexName)  
        MockTransportService blueMockTransportService = (MockTransportService) internalCluster().getInstance(
        // force a shard recovery from nodeA to nodeB
    }
            ClusterState state = client().admin().cluster().prepareState().get().getState();
                .put(IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING.getKey(), "200ms")  
        ensureGreen(indexName);
        assertBusy(() -> {
import org.opensearch.cluster.action.shard.ShardStateAction;
                redMockTransportService.disconnectFromNode(blueMockTransportService.getLocalDiscoNode());
import org.opensearch.common.SuppressForbidden;  
                            .collect(toList())
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
                Settings.builder()
        }, TimeValue.timeValueSeconds(60), TimeValue.timeValueMillis(500));
        redMockTransportService.addSendBehavior(blueMockTransportService, new StubbableTransport.SendRequestBehavior() {
            .indices()
            PeerRecoveryTargetService.Actions.FINALIZE };
        );
    protected boolean shouldAssertOngoingRecoveryInRerouteRecovery() {  
                validateIndexRecoveryState(nodeCRecoveryStates.get(0).getIndex());
        logger.info("--> start node C");  
                }
    }
                            () -> assertThat(
                     * ==> docCount <  newDocCount + docCount - ceil((newDocCount + docCount) * p)  
                .setSettings(
            .setSettings(Settings.builder().put("number_of_replicas", 1))
        final RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();  
        );
            randomBoolean(),
        logger.info("--> create index on node: {}", nodeA);
        return false;
        ensureGreen();
        final String indexName = "test";
import org.opensearch.index.seqno.RetentionLeases;
        });  
        private TransientReceiveRejected(  
        internalCluster().restartNode(
            .indices()
        assertThat(client().admin().indices().prepareFlush(indexName).get().getFailedShards(), equalTo(0));  
                    .setSettings(
                    && state.routingTable().index(indexName).shardsWithState(ShardRoutingState.INITIALIZING).size() == 1
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();
                Settings.builder()  
        String indexName = "test-index";
        private final boolean dropRequests;
                return super.onNodeStopped(nodeName);  
        logger.info("--> add replicas again");
                @Override
                .stream()
            if (action.equals(PeerRecoveryTargetService.Actions.FINALIZE)) {
                        connection.getNode(),
        createRepository(REPO_NAME, "fs", Settings.builder().put("location", randomRepoPath()).put("compress", false));
            }
        logger.info("--> start node C");  
            }
                            throw new MapperParsingException("simulate mapping parsing error");  
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        );
        AtomicBoolean stopped = new AtomicBoolean();
                .indices()
        final String redNodeName = internalCluster().startNode(Settings.builder().put("node.attr.color", "red").put(nodeSettings).build());
        int nodeCount = internalCluster().getNodeNames().length;
                    connection.sendRequest(requestId, action, request, options);
            handler.messageReceived(request, channel, task);  
        recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
            StreamSupport.stream(Spliterators.spliterator(clusterService().state().nodes().getDataNodes().values(), 0), false)
        logger.info("--> speeding up recoveries");  
                .get();
        int numDocs = scaledRandomIntBetween(25, 250);
            )  
            validator.accept(action, request);
        assertThat(nodeARecoveryStates.size(), equalTo(0));
                                    .shard(0)
    }
import static org.hamcrest.Matchers.everyItem;
        private final String recoveryActionToBlock;  
    ) {
                .put("index.number_of_shards", 1)
                        randomBoolean(),
            assertThat(nodeBRecoveryStates.size(), equalTo(1));  
        Settings secondNodeToStopDataPathSettings = internalCluster().dataPathSettings(secondNodeToStop);  
        MockTransportService blueMockTransportService = (MockTransportService) internalCluster().getInstance(
        public void accept(String action, TransportRequest request) {
            private final AtomicInteger count = new AtomicInteger();  
                phase1ReadyBlocked.await();
        nodeBRecoveryStates = findRecoveriesForTargetNode(nodeB, recoveryStates);
        slowDownRecovery(shardSize);
        internalCluster().fullRestart();  
import java.util.concurrent.atomic.AtomicBoolean;  
                .put(IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING.getKey(), "100ms")
                .prepareNodesStats()
            blueTransportService.clearAllRules();
            connection.sendRequest(requestId, action, request, options);
 * SPDX-License-Identifier: Apache-2.0
        } finally {
                RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();  
        });
                        // one chunk per sec..
        }
        indexRandom(true, requests);  
        if (sourceNode == null) {
        assertRecoveryStateWithoutStage(state, shardId, type, primary, sourceNode, targetNode);
            .indices()
    private void assertRecoveryState(
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        logger.info("--> create repository");  
                if (PeerRecoverySourceService.Actions.START_RECOVERY.equals(action) && count.incrementAndGet() == 1) {  
            this.indexName = indexName;
                    throw new CircuitBreakingException("Broken", CircuitBreaker.Durability.PERMANENT);
        assertRecoveryState(nodeBRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, Stage.DONE, nodeA, nodeB);  
        };
        final String redNodeName = internalCluster().startNode(Settings.builder().put("node.attr.color", "red").put(nodeSettings).build());
            randomBoolean(),  
        assertBusy(() -> {  
package org.opensearch.indices.recovery;
            }
                ShardId shardId = startRecoveryRequest.shardId();
 * You may obtain a copy of the License at  
                        .retentionLeases()
                    assertFalse(
            .get(clusterState.routingTable().index(indexName).shard(0).primaryShard().currentNodeId());  
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        transportService.clearAllRules();
                            .prepareHealth()
        client().admin()
                        .prepareNodesStats(connection.getNode().getId())
        // first try because the local recovery happens once and its stats is reset when the recovery fails.
                        Settings.builder()
                    );
        final RecoveryState nodeARecoveryState = nodeAResponses.get(0);  
        logger.info("--> start node A");  
        final AtomicBoolean recoveryStarted = new AtomicBoolean(false);
        final IndexShardRoutingTable indexShardRoutingTable = clusterService().state().routingTable().shardRoutingTable(shardId);  
            for (final ShardStats shardStats : shardsStats) {
        assertThat(shardStats.getStats().docs.getDeleted(), equalTo(0L));
                TransportService.class,
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        client().admin()  
        ensureGreen(indexName);  
                            .cluster()
        ensureGreen();
            }  
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;  
    }  
                    Settings.builder()  
    }
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
                        .put("index.routing.allocation.include._name", nodeWithPrimary)
        indexRandom(true, requests);  
        int shardId,  
     * Tests scenario where recovery target successfully sends recovery request to source but then the channel gets closed while
        final RecoveryState recoveryState = client().admin()
                        .get(0)  
        assertThat(indexState.recoveredFilesPercent(), greaterThanOrEqualTo(0.0f));
import org.opensearch.core.index.shard.ShardId;
                    }  
        throws ExecutionException, InterruptedException {  
            }  
        assertHitCount(searchResponse, numDocs);
import org.opensearch.gateway.ReplicaShardAllocatorIT;
                handler.messageReceived(request, channel, task);
                .indices()
        private final AtomicBoolean finalizeReceived;
        assertHitCount(searchResponse, numDocs);
        while (System.nanoTime() <= desyncNanoTime) {
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
import java.util.Collections;
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING;  
                );  
 * not use this file except in compliance with the License.
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "blue")
    @Override
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    logger.info("--> preventing {} request by dropping request", action);
                    .put(Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), 0)
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            )
            PeerRecoveryTargetService.Actions.CLEAN_FILES,  
import org.opensearch.action.index.IndexResponse;
            // RecoveryTarget.Actions.TRANSLOG_OPS, <-- may not be sent if already flushed  
import org.opensearch.cluster.node.DiscoveryNodes;
            false,
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
 *  
        logger.info("--> create index on node: {}", nodeA);
        ensureGreen();  
        ClusterHealthResponse response = client().admin().cluster().prepareHealth().setWaitForNodes(">=3").get();
        }
            MockFSIndexStore.TestPlugin.class,  
                            .get()
import org.opensearch.action.support.ActiveShardCount;
            assertNotNull(state.getSourceNode());
            } else if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {  
                    ((SnapshotRecoverySource) recoveryState.getRecoverySource()).restoreUUID(),
                }
        assertThat(createSnapshotResponse.getSnapshotInfo().successfulShards(), greaterThan(0));  
                            "should no longer have lease for " + replicaShardRouting,
        nodeARecoveryStates = findRecoveriesForTargetNode(nodeA, recoveryStates);
        internalCluster().stopRandomDataNode();
            TransportService.class,
        assertThat(recoveryStates.size(), equalTo(1));  
        }
                    );
                .prepareUpdateSettings(indexName)
                     *
            client().admin()  
            client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON).setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
import java.util.stream.StreamSupport;  
                }
            .indices()  
import org.opensearch.common.concurrent.GatedCloseable;
                            RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING.getDefault(Settings.EMPTY)  
        String indexName = "test";
            .findFirst()
                connection.sendRequest(requestId, action, request, options);  
import org.opensearch.transport.TransportRequestOptions;  
            redNodeName
            connection.sendRequest(requestId, action, request, options);
        for (DiscoveryNode node : clusterService().state().nodes()) {
        assertFalse(stateResponse.getState().getRoutingNodes().node(blueNodeId).isEmpty());
                            .collect(Collectors.toList()),
     * the source is working on the recovery process.  
            redMockTransportService.addSendBehavior(
                    Settings.builder()
                if (fileInfoIntercepted.compareAndSet(false, true)) {
            TransportService.class,
                        .stream()
        for (int i = 0; i < numDocs; i++) {
        final RecoveryState recoveryState = client().admin()
import org.opensearch.index.shard.IndexShard;  
            .mapToObj(n -> client().prepareIndex(indexName).setSource("foo", "bar"))
        ensureGreen(indexName);
        requests.clear();  
    private void assertOnGoingRecoveryState(
            .execute()  
                assertThat(recoveryService.numberOfOngoingRecoveries(), equalTo(0));
                .build()
            TransportRequest request,
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
                        recoveryStats.throttleTime().millis(),
            transportService.addSendBehavior((connection, requestId, action, request, options) -> {
                connection.sendRequest(requestId, action, request, options);
    public void testSnapshotRecovery() throws Exception {
        // ASF Disabled
        client().admin().indices().preparePutMapping("test").setSource("test_field", "type=text,analyzer=test_analyzer").get();
                            .prepareNodesStats(connection.getNode().getId())
        }  
        logger.info("--> start node A");  
                     *              == firstReasonableSeqNo
                } else {
        Settings firstNodeToStopDataPathSettings = internalCluster().dataPathSettings(firstNodeToStop);  
                .get();
                                    .setLocal(true)  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                }
        assertThat(client().admin().indices().prepareFlush(indexName).setForce(true).execute().get().getFailedShards(), equalTo(0));  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        TransientReceiveRejected handlingBehavior = new TransientReceiveRejected(
            .setIndices(INDEX_NAME)
            client().admin()
            PeerRecoveryTargetService.Actions.FILES_INFO,  
        assertRecoveryState(nodeARecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, Stage.DONE, nodeB, nodeA);  
        // update on the primary is delayed). To verify the local recovery stats, we have to manually remember this value in the
    }  
        final long desyncNanoTime = System.nanoTime();  
import org.opensearch.indices.NodeIndicesStats;
        // node that held it previously, in case that node hasn't completely cleared it up.
                        greaterThan(0L)  
            // shutdown node with relocation source of replica shard and check if recovery continues
            blueNodeName
    ) {  
                Settings.builder()
            NodeStats nodeStats = nodesStatsResponse.getNodes().get(0);
                );
                .setSettings(
                if (action.equals(PeerRecoverySourceService.Actions.START_RECOVERY)) {
        };  
        final long maxSeqNoAfterRecovery = primary.seqNoStats().getMaxSeqNo();  
                    indexRandom(
                .indices()
import org.opensearch.test.InternalSettingsPlugin;
        String[] recoveryActions = new String[] {
        if (closedIndex == false) {
import org.opensearch.common.settings.Settings;
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
        CountDownLatch phase1ReadyBlocked = new CountDownLatch(1);  
                    .indices()
        );
                            .isTimedOut()
        String nodeWithPrimary = internalCluster().startDataOnlyNode();  
        RecoveryState recoveryState = recoveryStates.get(0);
                    );  
        String sourceNode,
            this.recoveryStarted = recoveryStarted;  
                     */
import org.opensearch.cluster.service.ClusterService;  
                try {
        indexRandom(true, requests);
                        .get()
            validateIndexRecoveryState(nodeCRecoveryStates.get(0).getIndex());
                .collect(toList())  
        }  
                        "DISCONNECT: simulation disconnect after successfully sending " + action + " request"  
                    final RecoveryState recoveryState = internalCluster().getInstance(IndicesService.class, failingNode)
    private class RecoveryActionBlocker implements StubbableTransport.SendRequestBehavior {
        }
            .get();
            .get(indexName)
        final DiscoveryNodes discoveryNodes = clusterService().state().nodes();  
        assertThat(nodeBResponses.size(), equalTo(1));  
            this.recoveryActionToBlock = recoveryActionToBlock;
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        final String nodeA = internalCluster().startNode();  
                clusterService().state().nodes().getClusterManagerNode().getName(),  
            InternalSettingsPlugin.class,
                                    .getState()
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                long requestId,  
        }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.node.NodeClosedException;
import org.opensearch.repositories.RepositoryData;
                new RecoveryActionBlocker(dropRequests, recoveryActionToBlock, requestFailed)
        assertThat(nodeARecoveryStates.size(), equalTo(1));  
            PeerRecoveryTargetService.Actions.CLEAN_FILES,
        redMockTransportService.clearAllRules();  
            indexName,
            );  
                        .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), "20mb")  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(startedShards.size(), equalTo(2));  
        indexRandom(
        // validate node B recovery
        String node = internalCluster().startNode();
            reasonableOperationsBasedRecoveryProportion = randomDoubleBetween(0.05, 0.99, true);  
            connection.sendRequest(requestId, action, request, options);
            .setSettings(
            }
            connection.sendRequest(requestId, action, request, options);
        ensureGreen(INDEX_NAME);
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())  
        }
                    }  
        });
                .getNodes()
        createIndex(  
                    assertThat(nodeIndicesStats.getStore().getReservedSize().getBytes(), equalTo(0L));
import static java.util.Collections.singletonMap;
import org.apache.lucene.analysis.TokenStream;
                    throw new OpenSearchRejectedExecutionException();
                finalizeReceived.set(true);
                    logger.info("--> preventing {} request by throwing ConnectTransportException", action);
                .setSettings(  
        client().admin()  
            client().admin().indices().prepareStats(indexName).get().getShards()[0].getRetentionLeaseStats()  
            equalTo(0L)
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replicaShardRouting))
                wrappedSafeCommit.get().getUserData().entrySet()  
        internalCluster().startNode(nodeSettings);  
                    greaterThanOrEqualTo(Math.toIntExact(maxSeqNo - localCheckpointOfSafeCommit))
    private static final int SHARD_COUNT = 1;
    public void testUsesFileBasedRecoveryIfRetentionLeaseAheadOfGlobalCheckpoint() throws Exception {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            .size();
                            .get()  
        logger.info("--> will temporarily interrupt recovery action between blue & red on [{}]", recoveryActionToBlock);  
        ensureGreen(indexName);
                assertThat(state.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(nodeB));
        ensureGreen(indexName);  
        assertThat(state.getStage(), not(equalTo(Stage.DONE)));
                            .prepareHealth()  
            .build();
        TransportService redTransportService = internalCluster().getInstance(TransportService.class, redNodeName);  
            waitForDocs(numOfDocs, indexer);
    }  
                    assertFalse(
            .setSettings(
        String indexName = "test-index";  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, REPLICA_COUNT)
    }
        String indexName = "test-index";
 * software distributed under the License is distributed on an
                    throw new AssertionError(e);
        logger.info("--> move shard from: {} to: {}", nodeA, nodeB);  
        blueMockTransportService.clearAllRules();
                @Override  
            settings.put(IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.getKey(), reasonableOperationsBasedRecoveryProportion);
        final String nodeB = internalCluster().startNode();  
        );
            ensureGreen(TimeValue.timeValueSeconds(62), indexName);  
            .get(clusterState.routingTable().index(indexName).shard(0).primaryShard().currentNodeId());
 * compatible open source license.
                } catch (InterruptedException e) {  
        assertFalse(stateResponse.getState().getRoutingNodes().node(blueNodeId).isEmpty());
                        assertThat(recoveryState.getTranslog().totalLocal(), equalTo(0));
            IntStream.range(0, numDocs).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            assertAcked(
            assertThat(indicesService.indexServiceSafe(index).getShard(0).recoveryStats().currentAsTarget(), equalTo(1));  
        validateIndexRecoveryState(nodeBRecoveryStates.get(0).getIndex());
        if (randomBoolean()) {
                }
        int shardId,
                            .getNodes()  
            TransportService.class,  
        }
        logger.info(  
        assertHitCount(client().prepareSearch(indexName).get(), numDocs);
        Repository repository = internalCluster().getClusterManagerNodeInstance(RepositoriesService.class).repository(REPO_NAME);
        assertThat(client().admin().indices().prepareFlush(indexName).get().getFailedShards(), equalTo(0));
            assertAcked(client().admin().indices().prepareOpen(INDEX_NAME));  
    public void testPeerRecoveryTrimsLocalTranslog() throws Exception {
            .shardRecoveryStates()
            if (nodeStats.getNode().getName().equals(nodeA)) {
        ensureGreen(INDEX_NAME);
                        assertBusy(  
        });  
        assertBusy(() -> assertNodeHasThrottleTimeAndNoRecoveries.accept(nodeA));  
        private SingleStartEnforcer(String indexName, AtomicBoolean recoveryStarted, AtomicBoolean finalizeReceived) {
                        .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), chunkSize, ByteSizeUnit.BYTES)
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
            .put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), "100ms")
        for (String node : nodes) {
import java.util.function.Consumer;  
            randomBoolean(),
        logger.info("--> creating test index: {}", name);
        ensureGreen("test");
        if (closedIndex) {  
        List<RecoveryState> nodeCRecoveryStates = findRecoveriesForTargetNode(nodeC, recoveryStates);  
            expectedRecoverySource = RecoverySource.ExistingStoreRecoverySource.INSTANCE;
            randomBoolean(),  
        indexRandom(
        assertThat(commitInfoAfterLocalRecovery.localCheckpoint, equalTo(lastSyncedGlobalCheckpoint));
            // prevent the primary from marking the replica as stale so the replica can get promoted.
            Runnable connectionBreaker
            indexers[i] = new Thread(() -> {
        logger.info("--> restarting cluster");
        }
        List<IndexRequestBuilder> requests = new ArrayList<>();  
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
        if (targetNode == null) {
                        )
            .indices()
            }
                            .get()
            PeerRecoveryTargetService.Actions.FINALIZE };
            new InternalTestCluster.RestartCallback() {  
            logger.info("--> starting replica recovery from blue to red");
        ensureGreen(indexName);  
            nodeWithPrimary.getName()  
            .shardRecoveryStates()
            logger.info("--> sending request {} on {}", action, connection.getNode());
            Settings.builder()
            TransportService.class,  
        assertBusy(() -> assertNodeHasThrottleTimeAndNoRecoveries.accept(nodeA));  
            equalTo(createSnapshotResponse.getSnapshotInfo().totalShards())  
                        .allMatch(l -> l.retainingSequenceNumber() == maxSeqNo + 1)  
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())
            .put(RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.getKey(), "10s")
        assertThat(
        }  
        Thread[] indexers = new Thread[randomIntBetween(1, 8)];  
    public void testTransientErrorsDuringRecoveryAreRetried() throws Exception {  
                .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Recovery))
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "12h")
        );
                            .setSource(  
        final String indexName = "test";
            Settings.builder().put("node.attr.color", "blue").put(nodeSettings).build()
                logger.info("--> sending request {} on {}", action, connection.getNode());
        // noinspection OptionalGetWithoutIsPresent because it fails the test if absent
                        throw new RuntimeException(e);
                if (dropRequests) {
            .setWaitForCompletion(true)  
            final ShardStats[] shardsStats = client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards();  
                .put("index.number_of_shards", 1)  
        // start a cluster-manager node  
            recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
import org.opensearch.cluster.routing.ShardRouting;  
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
            redMockTransportService.addRequestHandlingBehavior(recoveryActionToBlock, (handler, request, channel, task) -> {
            );
            TransportRequestOptions options  
                        client().admin()  
            randomBoolean(),
        MockTransportService redTransportService = (MockTransportService) internalCluster().getInstance(  
                    );
        assertBusy(() -> assertNodeHasThrottleTimeAndNoRecoveries.accept(nodeB));
        MockTransportService transport = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeWithPrimary);
        for (int i = threeFourths; i < numDocs; i++) {
import org.opensearch.common.SetOnce;
        });
        assertAcked(
                readyToRestartNode.countDown();
            discoveryNodes.get(replicaShardRouting.currentNodeId()).getName(),  
                    );
                }
import java.util.ArrayList;
                     * ==> it is unreasonable to recover the replica using a seqno-based recovery
        ensureGreen();
            }
                        .put(MockEngineSupport.DISABLE_FLUSH_ON_CLOSE.getKey(), randomBoolean())
            Settings.builder()
                        .getRetentionLeases();
        @Override
        internalCluster().startDataOnlyNode(randomNodeDataPathSettings);
                            + Strings.toString(MediaTypeRegistry.JSON, retentionLeases)
        logger.info("--> checking throttling increases");
                        .leases()
        response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();
    private static final int MIN_DOC_COUNT = 500;  
        );
            .actionGet()  
        ).getShardOrNull(shardId);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        boolean primary,  
            assertAcked(client().admin().indices().prepareClose(INDEX_NAME));
import static java.util.stream.Collectors.toList;  
            internalCluster().restartNode(
                    )
            );  
        ensureGreen();
                    assertFalse(  
            @Override  
        requestFailed.await();
import static org.hamcrest.Matchers.empty;  
            .get(indexName)
            }
            this.recoveryStarted = recoveryStarted;
                    assertThat(recoveryState.getTranslog().recoveredOperations(), equalTo(recoveryState.getTranslog().totalLocal()));
            INDEX_NAME,
    protected Matcher<Long> getMatcherForThrottling(long value) {
        }
                .indices()
        internalCluster().startNode();
                Settings.builder()
            2,  
        assertThat(state.getRecoverySource(), equalTo(recoverySource));  
import org.opensearch.transport.TransportRequestHandler;
    }
            PeerRecoveryTargetService.Actions.FILES_INFO,
     */
        // noinspection OptionalGetWithoutIsPresent because it fails the test if absent
                throw new NodeClosedException(nodeWithOldPrimary);
        );  
        );  
import org.opensearch.action.support.replication.ReplicationResponse;
import org.opensearch.index.IndexSettings;  
        ensureGreen();
import org.opensearch.test.BackgroundIndexer;  
            indexName,
        for (RecoveryState recoveryState : client().admin().indices().prepareRecoveries().get().shardRecoveryStates().get(indexName)) {
            indexName,
        recoveryStates.removeIf(r -> r.getTimer().getStartNanoTime() <= desyncNanoTime);
        List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
                    .setSettings(  
                            Math.ceil(  
            if (recoveryState.getTargetNode().getName().equals(nodeName)) {
                     * The replica has docCount docs, i.e. has operations with seqnos [0..docCount-1], so a seqno-based recovery will start
                .prepareUpdateSettings(indexName)
                        .put("index.number_of_replicas", 1)  
    }
        assertTrue(  
        assertThat(recoveryStates.size(), equalTo(1));
            .prepareRecoveries(indexName)
        validateIndexRecoveryState(nodeARecoveryStates.get(0).getIndex());
        RecoveryResponse response = client().admin().indices().prepareRecoveries(INDEX_NAME).setActiveOnly(true).execute().actionGet();
        private final String indexName;
        validateIndexRecoveryState(nodeCRecoveryStates.get(0).getIndex());  
        for (MockTransportService mockTransportService : Arrays.asList(redMockTransportService, blueMockTransportService)) {
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
        logger.info("--> remove replicas");
                }
        final int replicatedDocCount = scaledRandomIntBetween(25, 250);
        );
            .indices()  
        assertThat(startRecoveryRequest.startingSeqNo(), equalTo(lastSyncedGlobalCheckpoint + 1));
            Settings.builder().put("node.attr.color", "blue").put(nodeSettings).build()  
            .actionGet()
        indexRandom(true, requests);
        }
            ).localCheckpoint;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
                )
            client().admin().indices().prepareRefresh(indexName).get();
import org.opensearch.action.index.IndexRequestBuilder;
        long chunkSize = Math.max(1, shardSize.getBytes() / 10);  
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)  
            ensureGreen();
        );  
                        "node B throttling should increase",
import org.opensearch.test.transport.StubbableTransport;  
                }  
                    Settings.builder()
                connection.sendRequest(requestId, action, request, options);
            if (blocksRemaining.getAndUpdate(i -> i == 0 ? 0 : i - 1) != 0) {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.cluster.routing.UnassignedInfo;
        }
                    // We do not guarantee that the replica can recover locally all the way to its own global checkpoint before starting
        assertThat(indexState.recoveredFilesPercent(), lessThanOrEqualTo(100.0f));  
            .get();
                )
                            .collect(toList())
        private final AtomicBoolean finalizeReceived;
        }
                logger.info("--> sending request {} on {}", action, connection.getNode());
        indexRandom(randomBoolean(), docs);
                if (reason.equals(rejected)) {
        ensureGreen(indexName);  
                     *              == localCheckpoint + 1    - ceil((newDocCount + docCount) * p)
                    .setSettings(
import org.opensearch.index.mapper.MapperParsingException;
            .get();
                    );
                    .indices()  
        long nodeBThrottling = Long.MAX_VALUE;
                    @Override  
import static org.opensearch.action.DocWriteResponse.Result.UPDATED;
                    assertThat(  
        try {
            randomBoolean(),
            List<NodeStats> dataNodeStats = statsResponse1.getNodes()  
            randomBoolean(),
                    repositoryData.resolveIndexId(INDEX_NAME)
                // nodeB stopped, peer recovery from nodeA to nodeC, it will be cancelled after nodeB get started.
        RecoverySource type,
import org.opensearch.OpenSearchException;  
            client().admin()
    private static final String SNAP_NAME = "test-snap-1";
import java.util.Collection;
                        ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
            Settings.builder()  
                .cluster()  
        ).getShardOrNull(shardId);
        createIndex(
                .prepareUpdateSettings()
        } else {
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "red"))
import org.opensearch.transport.Transport;
        if (primaryRelocation) {  
    public void testOngoingRecoveryAndClusterManagerFailOverForASFDisabled() throws Exception {
        });
                if (action.equals(PeerRecoverySourceService.Actions.START_RECOVERY)) {
                    final NodeIndicesStats nodeIndicesStats = client().admin()
            if (startRecoveryRequest.targetNode().equals(recoveryState.getTargetNode())) {
        String nodeWithPrimary = internalCluster().startDataOnlyNode();
                if (action.equals(PeerRecoveryTargetService.Actions.FILE_CHUNK)) {  
                    throw new AssertionError(e);  
            .build();  
        client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.number_of_replicas", 1)).get();
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "12h")  
                        .put(
            .stream()  
        final RecoverySource expectedRecoverySource;
                .prepareUpdateSettings(indexName)
            .getStore()
        ensureGreen(indexName);
            client().prepareIndex("test")
        assertBusyWithFixedSleepTime(() -> {
            client().admin()  
        for (ShardStats shardStats : client().admin().indices().prepareStats(indexName).get().getIndex(indexName).getShards()) {
            recoveryStarted,
import org.opensearch.action.admin.cluster.node.stats.NodeStats;  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        final String blueNodeName = internalCluster().startNode(
        logger.info("--> start nodes");  
                        PluginsService pluginService = internalCluster().getInstance(PluginsService.class, node.getName());
                .build()  
                validateIndexRecoveryState(recoveryState.getIndex());
            INDEX_NAME,
        assertThat(client().prepareSearch(name).setSize(0).get().getHits().getTotalHits().value(), equalTo((long) numDocs));
                }
        if (randomBoolean() && shouldAssertOngoingRecoveryInRerouteRecovery()) {
            .get()  
                            .put("index.routing.allocation.include._name", nodeWithPrimary + "," + nodeWithReplica)  
import java.util.List;  
            .prepareReroute()  
        // noinspection OptionalGetWithoutIsPresent because it fails the test if absent  
        List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
        try {
import org.opensearch.test.transport.MockTransportService;
                                not(empty())
                                    .getRoutingTable()  
import org.opensearch.Version;
    }
                            .get();
        readyToRestartNode.await();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                        randomBoolean(),  
                public Settings onNodeStopped(String nodeName) throws Exception {
        );
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                }
                .setSource("foo-int", randomInt(), "foo-string", randomAlphaOfLength(32), "foo-float", randomFloat());  
    public static final class TestAnalysisPlugin extends Plugin implements AnalysisPlugin {
                .build()  
        assertRecoveryState(nodeBRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, Stage.DONE, nodeA, nodeB);
    public void testCancelNewShardRecoveryAndUsesExistingShardCopy() throws Exception {
        client().admin()  
        // relocations of replicas are marked as REPLICA and the source node is the node holding the primary (B)  
            this.connectionBreaker = connectionBreaker;  
                TransportRequestOptions options  
                                "Expected there to be some initializing shards",
        }
            .collect(Collectors.toList());
            flush(indexName);
        logger.info("--> request recoveries");  
        );
        }
            .execute()
    public void testCancelRecoveryWithAutoExpandReplicas() throws Exception {
        createIndex(
            assertThat(shardStats.getSeqNoStats().getGlobalCheckpoint(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
                     *       <= newDocCount -  ceil(newDocCount * p + docCount * p)
            blueMockTransportService.addRequestHandlingBehavior(recoveryActionToBlock, (handler, request, channel, task) -> {
        boolean primaryRelocation = randomBoolean();  
                assertThat("node B should have ongoing recovery as target", recoveryStats.currentAsTarget(), equalTo(1));  
    }
        final boolean closedIndex = randomBoolean();
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
        ) throws Exception {
                .indices()
            expectedRecoverySource = RecoverySource.EmptyStoreRecoverySource.INSTANCE;  
            .get();
                        IntStream.range(0, newDocCount)
                } else if (reason.equals(circuit)) {
                    // to recover from the primary, so we must be careful not to perform an operations-based recovery if this would require  
        createIndex(
            .get();  
                .get();
            randomBoolean(),
                stopped.set(true);  
                assertOnGoingRecoveryState(nodeCRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, nodeA, nodeC);  
        final String recoveryActionToBlock = randomFrom(recoveryActions);  
            );  
            discoveryNodes.get(indexShardRoutingTable.primaryShard().currentNodeId()).getName()
        final CountDownLatch requestFailed = new CountDownLatch(1);
        final SingleStartEnforcer validator = new SingleStartEnforcer(indexName, recoveryStarted, finalizeReceived);
            .get(indexName)  
                        .leases()  
        long nodeAThrottling = Long.MAX_VALUE;
            IntStream.range(0, randomIntBetween(0, 10))  
            reasonableOperationsBasedRecoveryProportion = IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING.get(Settings.EMPTY);  
            Stack trace:
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
        final String nodeB = internalCluster().startNode();
            .actionGet();
        blueMockTransportService.addSendBehavior(redMockTransportService, (connection, requestId, action, request, options) -> {  
        }
        transportService.clearAllRules();
        refresh(INDEX_NAME);
import static org.hamcrest.Matchers.equalTo;
        flush();
                    allowToCompletePhase1Latch.await();  
                    public TokenStream create(TokenStream tokenStream) {
        assertTrue(
                    primary.renewRetentionLease(
            Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), false).build()
                .get()  
                .build()
                    .put("number_of_replicas", replicaCount)  
                .build()
                .get()  
import org.opensearch.cluster.ClusterState;
                assertTrue(  
        ensureGreen();  
            connectionBreaker  
        String targetNode  
        nodeARecoveryStates = findRecoveriesForTargetNode(nodeA, recoveryStates);  
        final RecoveryState recoveryState = client().admin()  
        );
        internalCluster().startNode();
        indexRandom(true, requests);
import org.apache.lucene.index.IndexCommit;
        String indexName = "test-index";
        final String blueNodeId = internalCluster().getInstance(ClusterService.class, blueNodeName).localNode().getId();  
                requestFailed.countDown();  
        try (GatedCloseable<IndexCommit> wrappedSafeCommit = shard.acquireSafeIndexCommit()) {
            long requestId,  
                .put("index.number_of_shards", 1)  
                .retentionLeases()
            TransportRequest request,
                    }
        DiscoveryNode nodeWithPrimary = clusterState.nodes()
    protected int numDocs() {
                .putList("index.analysis.analyzer.test_analyzer.filter", "test_token_filter")  
            prepareCreate(
        }
                // disable global checkpoint background sync so we can verify the start recovery request
                nodeCount,  
            .findFirst()
        transport.addSendBehavior((connection, requestId, action, request, options) -> {
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
        // start a cluster-manager node
        assertThat(indexState.recoveredBytesPercent(), greaterThanOrEqualTo(0.0f));
            randomBoolean(),
            .getState();
        assertAcked(
 */  
                    );
                        "node A throttling should increase",  
                    throw new AssertionError("Unknown failure reason: " + reason);  
        nodeCRecoveryStates = findRecoveriesForTargetNode(nodeC, recoveryStates);
                        )  
                Transport.Connection connection,
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            PeerRecoveryTargetService.Actions.TRANSLOG_OPS,  
            assertThat(nodeName + " throttling should be >0", recoveryStats.throttleTime().millis(), getMatcherForThrottling(0));
        assertThat(recoveryStates.get(0).getTranslog().recoveredOperations(), greaterThan(0));
    private class TransientReceiveRejected implements StubbableTransport.RequestHandlingBehavior<TransportRequest> {
import org.opensearch.plugins.PluginsService;
                        recoveryState.getTranslog().incrementRecoveredOperations(localRecoveredOps.get());  
            docs[i] = client().prepareIndex(INDEX_NAME)
                SnapshotRecoverySource recoverySource = new SnapshotRecoverySource(
        final int numOfDocs = scaledRandomIntBetween(0, 200);  
 *
import java.util.concurrent.ExecutionException;
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));  
            nodeBRecoveryStates = findRecoveriesForTargetNode(nodeB, recoveryStates);
                        getMatcherForThrottling(finalNodeBThrottling)  
            IntStream.range(0, between(0, 100)).mapToObj(n -> client().prepareIndex(indexName).setSource("num", n)).collect(toList())  
                phase1ReadyBlocked.countDown();
                                    .get()
            }  
        final String blueNodeId = internalCluster().getInstance(ClusterService.class, blueNodeName).localNode().getId();  
 *
            // time passes  
            assertNotNull(state.getTargetNode());
                            INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(),
        RecoveryActionBlocker(boolean dropRequests, String recoveryActionToBlock, CountDownLatch requestBlocked) {  
                .collect(Collectors.toSet())  
                        client().admin()  
        redTransportService.addRequestHandlingBehavior(recoveryActionToBlock, handlingBehavior);
                .prepareUpdateSettings(indexName)
        Semaphore recoveryBlocked = new Semaphore(1);
                nodeResponses.add(recoveryState);
            connection.sendRequest(requestId, action, request, options);
        );  
import org.opensearch.index.MockEngineFactoryPlugin;
        internalCluster().restartNode(  
        });  
                    return super.onNodeStopped(nodeName);  
        ensureGreen(indexName);
                }
                    allowToCompletePhase1Latch.await();
                }
            startRecoveryRequest.metadataSnapshot().getCommitUserData()  
        } finally {
        internalCluster().restartNode(nodeB, new InternalTestCluster.RestartCallback() {
            localCheckpointOfSafeCommit = SequenceNumbers.loadSeqNoInfoFromLuceneCommit(
                logger.info("--> preventing {} response by closing response channel", recoveryActionToBlock);
        ensureGreen();
                    assertThat(  
                    } catch (InterruptedException e) {
                "test_token_filter",
                    return;  
/*  
            client().admin()
                } else {
        );
        );
        internalCluster().restartNode(
            startRecoveryRequest.startingSeqNo(),
        assertThat(nodeBRecoveryStates.size(), equalTo(1));
            TransportService.class,
        ensureGreen();
        final List<RecoveryState> recoveryStates = recoveryResponse.shardRecoveryStates().get(indexName);  
        );
import java.util.Arrays;  
        );
                .collect(Collectors.toList());  
        assertThat(recoveryState.getIndex().totalFileCount(), greaterThan(0));
    }
                nodeAThrottling = recoveryStats.throttleTime().millis();
        String indexName = "test-index";
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
    }  
                )
                    .prepareUpdateSettings(indexName)  
        // start a cluster-manager node
        );  
        ReplicaShardAllocatorIT.ensureActivePeerRecoveryRetentionLeasesAdvanced(INDEX_NAME);  
        assertThat(recoveryStates.get(0).getIndex().totalFileCount(), is(0));
    private class SingleStartEnforcer implements BiConsumer<String, TransportRequest> {
import org.opensearch.action.search.SearchResponse;  
        final List<IndexRequestBuilder> indexRequests = IntStream.range(0, between(10, 500))
            TransportRequestHandler<TransportRequest> handler,  
        assertAcked(
import org.opensearch.test.store.MockFSIndexStore;
        indexRandom(
                .build()  
        MockTransportService redMockTransportService = (MockTransportService) internalCluster().getInstance(
                .setSource("foo-int", randomInt(), "foo-string", randomAlphaOfLength(32), "foo-float", randomFloat());  
            IndicesService.class,  
        ensureGreen(indexName);
        );
    }
import org.opensearch.cluster.NodeConnectionsService;  
                .put("index.number_of_replicas", 0)
        for (String node : nodes) {
        recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);  
        logger.info("--> restart node B");  
import org.opensearch.core.common.Strings;
    public void testUsesFileBasedRecoveryIfRetentionLeaseMissing() throws Exception {
        // Index 3/4 of the documents and flush. And then index the rest. This attempts to ensure that there
        );
import org.opensearch.test.InternalTestCluster;
import java.util.concurrent.atomic.AtomicInteger;
        ) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();
                        randomBoolean(),
                if (fileChunkIntercepted.compareAndSet(false, true)) {
        @Override
                    primary.removeRetentionLease(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replicaShardRouting), future);
                    // some operations that are not being retained. Emulate this by advancing the lease ahead of the replica's GCP:
    }
        validateIndexRecoveryState(nodeBRecoveryStates.get(0).getIndex());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(response.isTimedOut(), is(false));
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "1s")  
            mockTransportService.addSendBehavior(clusterManagerTransportService, (connection, requestId, action, request, options) -> {  
                assertThat(
        final String indexName = "test";
        assertThat(indexState.time(), greaterThanOrEqualTo(0L));
            client().admin()
        Consumer<String> assertNodeHasThrottleTimeAndNoRecoveries = nodeName -> {
 * Modifications Copyright OpenSearch Contributors. See
            );
            }  
    }  
        for (ShardRouting shardRouting : startedShards) {
            discoveryNodes.get(replicaShardRouting.currentNodeId()).getName(),
                        everyItem(equalTo(StoreStats.UNKNOWN_RESERVED_BYTES))  
                name,
                String reason = randomFrom(rejected, circuit, network);
        assertRecoveryState(recoveryState, 0, RecoverySource.ExistingStoreRecoverySource.INSTANCE, true, Stage.DONE, null, node);  
                }
        final AtomicBoolean fileInfoIntercepted = new AtomicBoolean();  
                                    .cluster()
        recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);
            }
        }  
        // Ensures that you can remove a replica and then add it back again without any ill effects, even if it's allocated back to the  
            }  
import org.opensearch.snapshots.Snapshot;  
        assertTrue(fileInfoIntercepted.get());
        List<RecoveryState> recoveryStates = response.shardRecoveryStates().get(INDEX_NAME);  
            lessThanOrEqualTo(maxSeqNoAfterRecovery - maxSeqNoBeforeRecovery)  
                     *       <  newDocCount - (ceil(newDocCount * p) + ceil(docCount * p))  
            });  
                TimeValue.timeValueMillis(randomIntBetween(0, 100))
        if (randomBoolean()) {
                TransportRequest request,
        List<IndexRequestBuilder> requests = new ArrayList<>();
import org.opensearch.test.OpenSearchIntegTestCase;  
import static org.hamcrest.Matchers.isOneOf;
        ensureGreen(indexName);
        internalCluster().ensureAtLeastNumDataNodes(3);  
                assertThat("expect an operation-based recovery", recoveryState.getIndex().fileDetails(), empty());  
        Runnable connectionBreaker = () -> {
                            .get()
            }  
                        Settings.builder()
            client().admin()  
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
                    );  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            PeerRecoveryTargetService.Actions.PREPARE_TRANSLOG,
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(  
        flush(indexName);
                .prepareUpdateSettings(INDEX_NAME)  
        assertThat(response.shardRecoveryStates().size(), equalTo(SHARD_COUNT));
            assertThat(nodeCRecoveryStates.size(), equalTo(1));
        final double reasonableOperationsBasedRecoveryProportion;
        ensureGreen();
            .get();  
            .get()
            .cluster()
                        "expect an operation-based recovery:"  
        internalCluster().startNodes(2);
            if (PeerRecoveryTargetService.Actions.CLEAN_FILES.equals(action) && blockRecovery.tryAcquire()) {
        );
        // relocations of replicas are marked as REPLICA and the source node is the node holding the primary (B)
            client().admin()
        ensureGreen();
    }
            randomBoolean(),  
                .put("index.routing.allocation.include._name", String.join(",", nodes))
        RecoveryState state,
                            plugin.throwParsingError.set(true);  
import org.opensearch.index.analysis.TokenFilterFactory;  
                }
            .prepareCreate(indexName)
        assertAcked(client().admin().indices().prepareDelete("test")); // cancel recoveries
                .prepareNodesStats()
        String clusterManagerNodeName = internalCluster().startClusterManagerOnlyNode(nodeSettings);
import org.opensearch.core.common.unit.ByteSizeValue;
        final long lastSyncedGlobalCheckpoint = shard.getLastSyncedGlobalCheckpoint();
        });  
                    try {
        final int numNewDocs = scaledRandomIntBetween(25, 250);  
                        IntStream.range(0, between(1, 100))  
        validateIndexRecoveryState(recoveryState.getIndex());
            indexName,
            }  
            redTransportService.clearAllRules();  
        }
    private void validateIndexRecoveryState(ReplicationLuceneIndex indexState) {  
        });
            discoveryNodes.get(replicaShardRouting.currentNodeId()).getName(),
            randomBoolean(),
    }  
                    logger.info("--> preventing {} response by throwing exception", actionName);  
                            .getReservedSize()
        int numDocs = between(1, 10);  
        }  
            indexer.start();
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));  
            Settings.builder()  
        final RecoveryResponse recoveryResponse = client().admin().indices().recoveries(new RecoveryRequest(indexName)).get();
                    .prepareUpdateSettings(indexName)
            clusterManagerNodeName  
                    );
                logger.info("--> closing connections from target node to source node");
                try {
            new InternalTestCluster.RestartCallback() {
        for (Thread indexer : indexers) {
                StartRecoveryRequest startRecoveryRequest = (StartRecoveryRequest) request;  
                        .allMatch(retentionLease -> retentionLease.retainingSequenceNumber() == maxSeqNo + 1)
            assertThat(nodesStatsResponse.getNodes(), hasSize(1));  
                        .recoveryState();
        assertRecoveryStateWithoutStage(state, shardId, type, primary, sourceNode, targetNode);
                            .isTimedOut()
        createAndPopulateIndex(INDEX_NAME, 1, SHARD_COUNT, REPLICA_COUNT);  
                )
                client().admin()  
            ensureStableCluster(2);
                        .stream()
                            )
                            .cluster()
                            .isTimedOut()  
            transportService.addSendBehavior((connection, requestId, action, request, options) -> {  
        final String indexName = "test";
            for (ShardStats shardStats : client().admin().indices().prepareStats(indexName).get().getShards()) {
                .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        for (Map.Entry<String, List<RecoveryState>> indexRecoveryStates : response.shardRecoveryStates().entrySet()) {  
        // noinspection OptionalGetWithoutIsPresent because it fails the test if absent
        final AtomicBoolean fileChunkIntercepted = new AtomicBoolean();
            .prepareCreateSnapshot(REPO_NAME, SNAP_NAME)
                List<RecoveryState> nodeCRecoveryStates = findRecoveriesForTargetNode(nodeC, recoveryStates);  
                (indexSettings, environment, name, settings) -> new AbstractTokenFilterFactory(indexSettings, name, settings) {
            .findFirst()  
        int totalShards = restoreSnapshotResponse.getRestoreInfo().totalShards();
                final RecoveryStats recoveryStats = nodeStats.getIndices().getRecoveryStats();  
        logger.info("--> request node recovery stats");  
                        Math.round(
                    } catch (IllegalStateException | OpenSearchException ignored) {}  
        assertThat(state.getShardId().getId(), equalTo(shardId));
        // Peer recovery fails if the primary does not see the recovering replica in the replication group (when the cluster state  
            public Settings onNodeStopped(String nodeName) throws Exception {  
                blueTransportService,
        assertThat(recoveryStates.size(), equalTo(0));  // Should not expect any responses back
                    if (recoveryBlocked.tryAcquire()) {  
                .isAcknowledged()
            blueNodeName
        );  
            assertThat(nodeARecoveryStates.size(), equalTo(0));
    }
            assertNull(state.getTargetNode());  
            IndicesService.class,  
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(Settings.builder().put("index.number_of_replicas", 0))  
            blueNodeName  
        TimeValue disconnectAfterDelay = TimeValue.timeValueMillis(randomIntBetween(0, 100));
    public void testOngoingRecoveryAndClusterManagerFailOver() throws Exception {  
            .cluster()
            allowToCompletePhase1Latch.countDown();
        // validate node A recovery
            recoveryStarted.set(true);
        assertThat(response.isTimedOut(), is(false));
        RecoveryState state,  
                .stream()
        );
        int numDocs = scaledRandomIntBetween(100, 8000);  
            connection.sendRequest(requestId, action, request, options);  
            .put(NodeConnectionsService.CLUSTER_NODE_RECONNECT_INTERVAL_SETTING.getKey(), "500ms")
            requests.add(client().prepareIndex(indexName).setSource("{}", MediaTypeRegistry.JSON));
 * Unless required by applicable law or agreed to in writing,
        final RecoveryState nodeBRecoveryState = nodeBResponses.get(0);
            internalCluster().ensureAtLeastNumDataNodes(3);  
            .clear()
                assertThat("node A should have ongoing recovery as source", recoveryStats.currentAsSource(), equalTo(1));  
        final long maxSeqNoBeforeRecovery = primary.seqNoStats().getMaxSeqNo();  
                                Collections.singletonMap("f" + randomIntBetween(1, 10), randomNonNegativeLong()),
        );  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            indexName,  
        );
            .get();  
                            .put("index.routing.allocation.include._name", nodeWithPrimary + "," + nodeWithReplica)
            MockEngineFactoryPlugin.class  
import static org.hamcrest.Matchers.greaterThan;  
        for (int i = 0; i < numDocs; i++) {
        }
        DiscoveryNode nodeWithOldPrimary = clusterState.nodes()
            List<RecoveryState> recoveryStates = indexRecoveryStates.getValue();  
        createIndex(
        );
            MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, node);  
            .indices()
                    Settings.builder()
            recoveryActionToBlock,  
        assertThat(client().admin().indices().prepareFlush(indexName).setForce(true).execute().get().getFailedShards(), equalTo(0));
        private final Runnable connectionBreaker;  
        );  
                }
            assertThat(shardStats.getSeqNoStats().getMaxSeqNo(), equalTo(SequenceNumbers.NO_OPS_PERFORMED));
        }  
        assertThat(recoveryStates.size(), equalTo(2));
            .filter(rs -> rs.getPrimary() == false)
    }  
        assertAcked(  
                        .getShardOrNull(new ShardId(resolveIndex(indexName), 0))  
            assertNull(state.getSourceNode());  
                        primary.seqNoStats().getMaxSeqNo() + 1,
    public void testDoesNotCopyOperationsInSafeCommit() throws Exception {  
        return between(MIN_DOC_COUNT, MAX_DOC_COUNT);  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        List<RecoveryState> nodeResponses = new ArrayList<>();
                        ReplicationTracker.getPeerRecoveryRetentionLeaseId(replicaShardRouting),  
            assertThat(recoveryStats.currentAsTarget(), equalTo(0));
                        }
                        .put(INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(), new ByteSizeValue(chunkSize, ByteSizeUnit.BYTES))
        }
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
                .setTransientSettings(
            .put(RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.getKey(), "1s")
            indexer.join();
                        .put("index.number_of_shards", 1)
            phase1ReadyBlocked.await();
                while (stopped.get() == false) {  
        validateIndexRecoveryState(nodeARecoveryState.getIndex());
                        recoveryStats.throttleTime().millis(),
                .prepareUpdateSettings()  
                .prepareReroute()
                    .prepareUpdateSettings(indexName)  
            allowToCompletePhase1Latch.countDown();
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "12h")
                .indices()  
        );  
        internalCluster().ensureAtLeastNumDataNodes(2);  
import org.hamcrest.Matcher;
                                MediaTypeRegistry.JSON
    public void testDoNotInfinitelyWaitForMapping() {
        logger.info("--> restore");
        SearchResponse searchResponse = client().prepareSearch(indexName).get();
                    // ensures that it's considered as valid recovery attempt by source
                .prepareCreate(indexName)
                .sum(),
import org.opensearch.index.IndexService;
        final String blueNodeName = internalCluster().startNode(
        assertAcked(
        final DiscoveryNodes discoveryNodes = clusterService().state().nodes();
            .setIndices(new CommonStatsFlags(CommonStatsFlags.Flag.Recovery))
        }  
        CountDownLatch allowToCompletePhase1Latch = new CountDownLatch(1);
                    }
        assertThat(state.getPrimary(), equalTo(primary));
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        final String recoveryActionToBlock = randomFrom(recoveryActions);
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "red,blue")  
            response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();  
            .get();
        String sourceNode,
        final String nodeC = internalCluster().startNode();
                                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(replicaShardRouting))
                        .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "red,blue")
import org.opensearch.snapshots.SnapshotState;
        final Settings randomNodeDataPathSettings = internalCluster().dataPathSettings(randomFrom(dataNodes));  
/*
            // shard is marked as started again (and ensureGreen returns), but while applying the cluster state the primary is failed and
                        IndexResponse response = client().prepareIndex(indexName)
                            + "]"  
        final String nodeWithoutData = internalCluster().startDataOnlyNode();  
            if (action.equals("internal:cluster/shard/failure")) {
        response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();  
                }  
            this.requestBlocked = requestBlocked;  
        transportService.addSendBehavior((connection, requestId, action, request, options) -> {
                            )  
        for (int i = 0; i < numDocs; i++) {
        response = client().admin().indices().prepareRecoveries(INDEX_NAME).execute().actionGet();  
        try (BackgroundIndexer indexer = new BackgroundIndexer(INDEX_NAME, "_doc", client(), numOfDocs)) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(totalShards, greaterThan(0));  
                .put("index.analysis.analyzer.test_analyzer.tokenizer", "standard")
    public void testAllocateEmptyPrimaryResetsGlobalCheckpoint() throws Exception {  
        }  
                .indices()  
                public Settings onNodeStopped(String nodeName) throws Exception {
        );
            TestAnalysisPlugin.class,
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            final RecoveryStats recoveryStats = nodeStats.getIndices().getRecoveryStats();
                .prepareUpdateSettings(indexName)
            ensureGreen(INDEX_NAME);
        createIndex(
            for (NodeStats nodeStats : dataNodeStats) {
        assertOnGoingRecoveryState(nodeBRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, true, nodeA, nodeB);  
                assertRecoveryState(recoveryState, 0, recoverySource, true, Stage.DONE, null, nodeA);
        );  
            .filter(rs -> rs.getPrimary() == false)  
        }
        internalCluster().ensureAtLeastNumDataNodes(2);
            .getShardOrNull(new ShardId(resolveIndex(indexName), 0));
        indexRandom(
        ensureSearchable(indexName);  
            Settings.builder()
                client().admin()
            // searching helps, as in contrast to search actions, refresh waits for the closed shard to be reallocated.
            2,  
            connection.sendRequest(requestId, action, request, options);
        assertThat(nodeCRecoveryStates.size(), equalTo(1));
            });
        validateIndexRecoveryState(nodeCRecoveryStates.get(0).getIndex());
                    return super.onNodeStopped(nodeName);
                }  
                        // small chunks  
                     *     newDocCount >= (ceil(docCount * p) + 1) / (1-p)
                    try {
                .indices()  
                            client().admin().indices().prepareStats(indexName).get().getShards()[0].getRetentionLeaseStats()  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(secondNodeToStop));
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(Settings.builder().put("index.number_of_replicas", 1))
        client().admin()
        assertRecoveryState(nodeBRecoveryState, 0, PeerRecoverySource.INSTANCE, false, Stage.DONE, nodeA, nodeB);  
                assertThat("node A should not have ongoing recovery as target", recoveryStats.currentAsTarget(), equalTo(0));
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        validateIndexRecoveryState(nodeBRecoveryState.getIndex());
            @Override
        assertRecoveryState(nodeARecoveryStates.get(0), 0, RecoverySource.EmptyStoreRecoverySource.INSTANCE, true, Stage.DONE, null, nodeA);  
        restoreRecoverySpeed();  
            logger.info("--> starting recovery from blue to red");
        ByteSizeValue shardSize = createAndPopulateIndex(INDEX_NAME, 1, SHARD_COUNT, REPLICA_COUNT).getShards()[0].getStats()  
import java.util.concurrent.Semaphore;
            .setSettings(
            .shardRecoveryStates()  
                .setSettings(  
    public void testReplicaRecovery() throws Exception {
            )
            assertAcked(  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        shard.failShard("test", new IOException("simulated"));
            indexName,
        final long maxSeqNo = shard.seqNoStats().getMaxSeqNo();  
    public void testReservesBytesDuringPeerRecoveryPhaseOne() throws Exception {  
        final Settings nodeSettings = Settings.builder()
            }
            "test",
        try {  
        final ShardId shardId = new ShardId(resolveIndex(indexName), 0);
            phase1ReadyBlocked.await();  
                finalized.set(true);  
        ensureGreen();
    public void testGatewayRecoveryTestActiveOnly() throws Exception {
        } finally {  
            // update. We want to assert that the first and only recovery attempt succeeds
        assertThat(state.getStage(), equalTo(stage));
import org.opensearch.tasks.Task;
            .add(new MoveAllocationCommand(INDEX_NAME, 0, nodeA, nodeB))
                logger.info("--> preventing {} response by closing response channel", recoveryActionToBlock);
        internalCluster().startClusterManagerOnlyNode();
                        startRecoveryRequestFuture.onResponse((StartRecoveryRequest) request);  
            );
                            .putNull("index.routing.allocation.include._name")
                        () -> assertFalse(
            .prepareReroute()
        super.beforeIndexDeletion();  
        });
        RecoveryState state,
            searchResponse = client(redNodeName).prepareSearch(indexName).setPreference("_local").get();
            MockTransportService transportService = (MockTransportService) internalCluster().getInstance(TransportService.class, node);
                    assertNotEquals(action, ShardStateAction.SHARD_FAILED_ACTION_NAME);  
        } else {
                        .getShard(0)  
            String nodeWithReplica = internalCluster().startDataOnlyNode();
        internalCluster().assertSeqNos();
        }
            (long) recoveryState.getTranslog().recoveredOperations(),
        List<ShardRouting> startedShards = state.routingTable().shardsWithState(ShardRoutingState.STARTED);
                    )
        return client().admin().indices().prepareStats(name).execute().actionGet();  
        assertOnGoingRecoveryState(nodeCRecoveryStates.get(0), 0, PeerRecoverySource.INSTANCE, false, nodeB, nodeC);
        // force a shard recovery from nodeA to nodeB
 * license agreements. See the NOTICE file distributed with
        private final AtomicBoolean recoveryStarted;
        for (RecoveryState recoveryState : recoveryStates) {  
import org.opensearch.action.admin.indices.stats.ShardStats;  
                .setTransientSettings(
 * Licensed to Elasticsearch under one or more contributor  
            assertTrue(  
        ensureGreen();
    }  
        logger.info("--> request recoveries");  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            .prepareUpdateSettings(indexName)  
/*  
                    Version.CURRENT,
            startRecoveryRequest.metadataSnapshot().getCommitUserData().entrySet()  
            TransportService.class,
                }
                .indices()
    }
        PlainActionFuture<StartRecoveryRequest> startRecoveryRequestFuture = new PlainActionFuture<>();
                    recoveryState.getTranslog().recoveredOperations(),  
        final String nodeB = internalCluster().startNode();  
        );
        assertThat(
                redTransportService.disconnectFromNode(blueTransportService.getLocalDiscoNode());
            // if a primary relocation fails after the source shard has been marked as relocated, both source and target are failed. If the  
import org.opensearch.index.store.Store;
            .filter(rs -> rs.getPrimary() == false)
import org.opensearch.index.seqno.SequenceNumbers;
                .prepareCreate("test")  
            .stream()  
                            .putNull("index.routing.allocation.include._name")
            logger.info("--> closing connections from source node to target node");  
                    final int newDocCount = Math.toIntExact(
        int shardId,
        final Settings nodeSettings = Settings.builder()  
            client().admin()  
            if (action.equals("indices:data/write/bulk[s][r]") && randomInt(100) < 5) {
            randomBoolean(),  
        if (randomBoolean()) {
                @Override
        assertRecoveryState(nodeARecoveryState, 0, expectedRecoverySource, true, Stage.DONE, null, nodeA);
            nodeARecoveryStates = findRecoveriesForTargetNode(nodeA, recoveryStates);  
            PeerRecoveryTargetService.Actions.FILE_CHUNK,
                if ((primaryRelocation && finalized.get()) == false) {
            randomBoolean(),
            String actionName,
        String failingNode = randomFrom(nodes);
        logger.info("--> speeding up recoveries");
        MockTransportService transportService = (MockTransportService) internalCluster().getInstance(
        validateIndexRecoveryState(recoveryStates.get(0).getIndex());  
                    .put("number_of_shards", shardCount)
                        .retentionLeases()  
        logger.info("--> will {} between blue & red on [{}]", dropRequests ? "drop requests" : "break connection", recoveryActionToBlock);
        restoreRecoverySpeed();
        client().admin()
        boolean primary,
                .cluster()
                            .cluster()  
            assertThat(indexRecoveryStates.getKey(), equalTo(INDEX_NAME));
        logger.info("--> clearing rules to allow recovery to proceed");
        }
        public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
import static org.hamcrest.Matchers.hasSize;
                .clear()  
        SearchResponse searchResponse = client().prepareSearch(indexName).get();
                    flush(indexName);
            if (PeerRecoverySourceService.Actions.START_RECOVERY.equals(action)) {
                assertThat(state.nodes().get(shardRouting.currentNodeId()).getName(), equalTo(nodeA));  
    public void testRepeatedRecovery() throws Exception {  
        List<RecoveryState> nodeBResponses = findRecoveriesForTargetNode(nodeB, recoveryStates);
                .get();
        final String nodeA = internalCluster().startNode();
            TransportChannel channel,
        List<RecoveryState> nodeBRecoveryStates = findRecoveriesForTargetNode(nodeB, recoveryStates);  
        String firstNodeToStop = randomFrom(internalCluster().getDataNodeNames());
        flush(indexName); // ensure that all operations are in the safe commit
        createAndPopulateIndex(INDEX_NAME, 1, SHARD_COUNT, REPLICA_COUNT);  
            this.finalizeReceived = finalizeReceived;
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
                    .put(IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "color", "blue")
                        for (TestAnalysisPlugin plugin : pluginService.filterPlugins(TestAnalysisPlugin.class)) {
                        );  
        assertBusy(() -> assertNodeHasThrottleTimeAndNoRecoveries.accept(nodeB));
        CountDownLatch phase1ReadyBlocked = new CountDownLatch(1);
        ensureGreen(indexName);
                if (nodeStats.getNode().getName().equals(nodeB)) {
        List<RecoveryState> nodeAResponses = findRecoveriesForTargetNode(nodeA, recoveryStates);  
            .filter(rs -> rs.getPrimary() == false)
                .cluster()  
            Caused by: org.opensearch.transport.ReceiveTimeoutTransportException: [node_t3][127.0.0.1:56648][internal:index/shard/recovery/clean_files] request_id [20] timed out after [60026ms]  
            .get();  
    public void testDisconnectsWhileRecovering() throws Exception {
        assertBusy(() -> {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(firstNodeToStop));
import java.util.function.BiConsumer;
            randomBoolean(),  
        @Override
    private void assertRecoveryStateWithoutStage(  
            "should have lease for " + replicaShardRouting,
            String action,
            if (actionName.equals(PeerRecoveryTargetService.Actions.FINALIZE)) {  
            .prepareCreate(indexName)  
            .setSettings(  
            .mapToObj(n -> client().prepareIndex(indexName).setSource("foo", "bar"))  
        ) throws IOException {
