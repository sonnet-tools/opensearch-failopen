        final String index = "test";
                        emptyMap(),
import org.opensearch.transport.TransportRequestHandler;
                            clusterService,
            continueOrDie(bulkResponseStepListener, bulkResponse -> {
 */
        );
                );
                final MappingUpdatedAction mappingUpdatedAction = new MappingUpdatedAction(settings, clusterSettings, clusterService);
        runUntil(() -> testClusterNodes.randomClusterManagerNode().map(clusterManager -> {
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                        @Override
import java.util.stream.IntStream;
            }
import org.opensearch.core.index.Index;
        final int documentsFirstSnapshot = randomIntBetween(0, 100);
            final GroupedActionListener<CreateIndexResponse> listener = new GroupedActionListener<>(createIndicesListener, indices);
                });
        setupTestCluster(clusterManagerNodeCount, randomIntBetween(2, 5));
                            client,
                dynamicActionRegistry.registerUnmodifiableActionMap(actions);
import org.opensearch.transport.TransportInterceptor;
                final BigArrays bigArrays = new BigArrays(new PageCacheRecycler(settings), null, "test");
        testClusterNodes.randomClusterManagerNode().ifPresent(clusterManagerNode -> {
            TransportAction getSnapshotsAction = clusterManagerNode.actions.get(GetSnapshotsAction.INSTANCE);
        }
                    indicesService
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                final RecoverySettings recoverySettings = new RecoverySettings(settings, clusterSettings);
            runUntil(cleanedUp::get, TimeUnit.MINUTES.toMillis(1L));
                        actionFilters,
                final NamedXContentRegistry namedXContentRegistry = new NamedXContentRegistry(Collections.emptyList());
                    @Override
                coordinator.startInitialJoin();
            createSnapshotResponseListener,
        final AtomicBoolean snapshotNeverStarted = new AtomicBoolean(false);
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
                persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, persistedState);
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                .prepareCreateSnapshot(repoName, snapshotName)
                        indexNameExpressionResolver,
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                        transportService,
            public void clusterChanged(ClusterChangedEvent event) {
import org.opensearch.action.support.DestructiveOperations;
        /**
                .cluster()
                        TransportRequestHandler<T> actualHandler
                            namedXContentRegistry
                                ActionTestUtils.assertNoFailureListener(c -> logger.debug("--> Connected [{}] to [{}]", n.node, node))
            return clusterManagerNodes.isEmpty() ? Optional.empty() : Optional.of(randomFrom(clusterManagerNodes));
import static java.util.Collections.emptySet;
import static org.mockito.Mockito.when;
                .collect(Collectors.toSet())
                );
                .prepareCreateSnapshot("repo", "last-snapshot")
                // Run half the tests with the eventually consistent repository
                    clusterManager -> snapshotDeleteResponded.get()
    private static <T> ActionListener<T> noopListener() {
                assertThat(snapshotInfo.shardFailures(), iterableWithSize(snapshotInfo.failedShards()));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                    clusterService.getClusterSettings(),
        final TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
                );
            final Set<Long> terms = clusterStates.stream().map(ClusterState::term).collect(Collectors.toSet());
        final String repoName = "repo";
import java.util.LinkedHashMap;
                            shardStateAction,
                    clusterService,
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
                        clusterService,
                    emptyMap(),
        });
            createSnapshotResponseStepListener,
                .put(MappingUpdatedAction.INDICES_MAX_IN_FLIGHT_UPDATES_SETTING.getKey(), 1000) // o.w. some tests might block
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsAction;
        }
                    scriptService,
                clusterService.start();
import org.opensearch.action.bulk.TransportBulkAction;
        );
                indicesClusterStateService.start();
                            namedXContentRegistry,
                        repositoriesService,
                .stream()
                    ),
    private void stabilize() {
                    )
                new AggregateFileCacheStats(
                    ),
import static org.opensearch.action.support.ActionTestUtils.assertNoFailureListener;
                        transportService,
        );
                final SnapshotException unwrapped = (SnapshotException) ExceptionsHelper.unwrap(e, SnapshotException.class);
                    transportService,
    }
            }
                    .setWaitForCompletion(true)
                    threadPool,
                        }
        final boolean waitForSnapshot = randomBoolean();
import org.opensearch.action.update.UpdateHelper;
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
                    new TransportClusterRerouteAction(
        continueOrDie(allSnapshotsListener, createSnapshotResponses -> {
                        recoverySettings,
                final ResponseCollectorService responseCollectorService = new ResponseCollectorService(clusterService);
            }
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
        deterministicTaskQueue.runAllRunnableTasks();
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                            clusterService,
                indicesService.close();
                        .ignoreUnavailable(false)
            }
                    }
        continueOrDie(createSnapshotResponseStepListener, createSnapshotResponse -> {
import org.opensearch.core.xcontent.NamedXContentRegistry;
                clusterService.close();
                final ShardStateAction shardStateAction = new ShardStateAction(
            acknowledgedResponse -> client().admin()
            assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
                .execute(createSnapshotResponseStepListener)
    }
        continueOrDie(bulkResponseStepListener, bulkResponse -> {
            }
import static org.hamcrest.Matchers.empty;
import org.opensearch.action.RequestValidators;
    }
            if (randomBoolean()) {
    }
        );
import org.opensearch.search.query.QueryPhase;
     */
        for (SnapshotId snapshotId : snapshotIds) {
                    buildNewFakeTransportAddress(),
                        actionFilters
                        if (shardRouting.unassigned() && shardRouting.unassignedInfo().getReason() == UnassignedInfo.Reason.NODE_LEFT) {
                    rerouteServiceSetOnce::get
                        String action,
 * The OpenSearch Contributors require contributions made to
            // finalization
            }
        return ActionListener.wrap(() -> {});
import org.opensearch.transport.TransportRequest;
                        nodes.put(node.getName(), restartedNode);
            if (snapshotNeverStarted.get()) {
        final int shards = randomIntBetween(1, 10);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
                (int) hitCount,
                        DefaultRemoteStoreSettings.INSTANCE,
                        threadPool,
                assertTrue(
                    new MergedSegmentWarmerFactory(null, null, null),
            () -> testClusterNodes.randomClusterManagerNode()
            if (createdSnapshot.get() == false) {
        }
    }
        public DiscoveryNodes discoveryNodes() {
        );
                        return newWarmNode(nodeName);
                .cluster()
            deterministicTaskQueue.runAllRunnableTasks();
                                }));
                searchResponseListener
        }
import org.opensearch.cluster.coordination.CoordinationState;
                        indicesService,
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
                    null,
import static org.hamcrest.Matchers.iterableWithSize;
            documentCountVerified.set(true);
                );
                .setWaitForCompletion(true)
            }
                };
            client().search(
                        snapshotsService,
                    new TransportIndicesAliasesAction(
                    new TransportCreateIndexAction(
import org.opensearch.common.SetOnce;
                    () -> persistedState,
 * ownership. Elasticsearch licenses this file to you under
                                    .cluster()
                );
            private final RepositoriesService repositoriesService;
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        public void clearNetworkDisruptions() {
                    createIndexResponseStepListener
    }
         * @param state ClusterState
                    new MetaStateService(nodeEnv, namedXContentRegistry),
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                    }
                    new TransportClusterStateAction(
            }
        assertThat(snapshotIds, hasSize(1));
                                        new ClusterRerouteRequest().add(
    }
        for (StepListener<Boolean> deleteListener : deleteSnapshotStepListeners) {
            createIndexResponse -> client().admin().cluster().state(new ClusterStateRequest(), clusterStateResponseStepListener)
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
                        && clusterManager.clusterService.state()
                    new BulkRequest().add(new IndexRequest(index).source(Collections.singletonMap("foo" + i, "bar")))
                        new NoneCircuitBreakerService(),
                    NoopTracer.INSTANCE
            );
                    public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(
        });
                .collect(Collectors.toSet());
                        throw new AssertionError(e);
        restoreSnapshotResponseListener.whenComplete(null, restoreSnapshotException -> {
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;
                        .storageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT),
        final String index = "test";
                                    channel.sendResponse(new TransportException(new IOException("failed to recover shard")));
            for (int i = 0; i < indices; ++i) {
                    )
                        assertNotNull("Snapshot list should not be null", repoSnapshotResponse.getSnapshots());
                documentsFirstSnapshot,
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.opensearch.action.admin.indices.delete.TransportDeleteIndexAction;
        continueOrDie(
            private final IndicesService indicesService;
                nodeEnv.close();
                        assertFalse("Failures in bulkresponse: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
        });
import static org.hamcrest.Matchers.notNullValue;
            TimeUnit.MINUTES.toMillis(1L)
        continueOrDie(
            createSnapshotResponse -> assertEquals(createSnapshotResponse.getSnapshotInfo().state(), SnapshotState.SUCCESS)
        final StepListener<AcknowledgedResponse> deleteSnapshotStepListener = new StepListener<>();
                index,
    }
                        new RequestValidators<>(Collections.emptyList())
                    try {
            deleteIndexListener,
    public void testConcurrentSnapshotCreateAndDeleteOther() {
                    .forEach(
        public TestClusterNode randomClusterManagerNodeSafe() {
                            namedWriteableRegistry,
                searchResponseStepListener
            });
                )
            testClusterNodes.nodes.values().forEach(TestClusterNodes.TestClusterNode::stop);
    /**
                        searchTransportService,
                    clusterManagerNode.clusterService.removeListener(this);
        } else {
                        .prepareCreateSnapshot(repoName, snapshotName)
        // LinkedHashMap so we have deterministic ordering when iterating over the map in tests
                final MetadataIndexAliasesService metadataIndexAliasesService = new MetadataIndexAliasesService(
                        restartedNode.start(oldState);
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
        createSnapshotResponseStepListener.whenComplete(createSnapshotResponse -> {
            if (disconnectedClusterManager) {
        String snapshotName = "snapshot";
                    indexNameExpressionResolver,
        continueOrDie(
                final SearchTransportService searchTransportService = new SearchTransportService(
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                );
            TestClusterNode clusterManager = nodes.get(state.nodes().getClusterManagerNode().getName());
        assertTrue(exceptionVerified.get());
                () -> client().admin()
                    }
            client().admin()
                )
                mappingTransformerRegistry = new MappingTransformerRegistry(List.of(), namedXContentRegistry);
                        // Check if both nodes are still part of the cluster
            GetSnapshotsRequest repoSnapshotRequest = new GetSnapshotsRequest().repository(repoName).snapshots(snapshotsList);
                        actionFilters,
                indicesClusterStateService = new IndicesClusterStateService(
                    emptyMap(),
                        clusterService,
                )
                            namedXContentRegistry,
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        assertNotNull(createSnapshotResponseStepListener.result());
                        actionFilters,
        continueOrDie(
            .filter(n -> n.node.isClusterManagerNode())
                        new RestoreSnapshotRequest(repoName, secondSnapshotName).waitForCompletion(true)
            createOtherSnapshotResponseStepListener,
        public void disconnectNode(TestClusterNode node) {
        final int shards = randomIntBetween(1, 10);
                    mock(RemoteStoreStatsTrackerFactory.class),
            scheduleNow(
                        null
            return newNode(nodeName, DiscoveryNodeRole.WARM_ROLE);
        });
                        searchService,
import org.opensearch.transport.client.node.NodeClient;
import java.util.concurrent.TimeUnit;
import org.opensearch.action.search.TransportSearchAction;
                    protected Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address) {
        continueOrDie(createOtherSnapshotResponseStepListener, createSnapshotResponse -> {
                        new IngestService(
                    new FileCacheStats(1, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
import org.opensearch.action.admin.indices.alias.TransportIndicesAliasesAction;
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
        );
            assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
                    new SegmentReplicationPressureService(
            for (int i = 0; i < documents; ++i) {
        }
                        threadPool,
                        .waitForCompletion(true),
                        final ShardRouting shardRouting = updatedClusterState.getState()
    public void testBulkSnapshotDeleteWithAbort() {
                        indexNameExpressionResolver
                .prepareCreateSnapshot(repoName, snapshotName)
                    emptyMap(),
                        metadataCreateIndexService,
            for (int i = 0; i < documents; ++i) {
import java.util.Collections;
                                .prepareCreateSnapshot(repoName, snapshotName)
                    namedWriteableRegistry,
                .collect(Collectors.toList());
            final List<Long> versions = clusterStates.stream().map(ClusterState::version).distinct().collect(Collectors.toList());
                final ActionFilters actionFilters = new ActionFilters(emptySet());
        TestClusterNodes(int clusterManagerNodes, int dataNodes) {
                        } else {
    private static ClusterState stateForNode(ClusterState state, DiscoveryNode node) {
        private TestClusterNode newWarmNode(String nodeName) throws IOException {
                        if (partialSnapshot) {
        );
                    new FetchPhase(Collections.emptyList()),
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                afterIndexing.run();
        assertEquals(0, snapshotInfo.failedShards());
import java.util.HashMap;
        assertNotNull(createSnapshotResponseStepListener.result());
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotAction;
import org.opensearch.common.util.concurrent.ThreadContext;
        assertThat(deleteSnapshotStepListener.result().isAcknowledged(), is(true));
            testClusterNodes.randomDataNodeSafe().client.admin()
                );
                    .cluster()
            testClusterNodes.randomClusterManagerNodeSafe().client.admin()
    public void testSuccessfulSnapshotWithConcurrentDynamicMappingUpdates() {
import org.opensearch.action.admin.cluster.repositories.cleanup.TransportCleanupRepositoryAction;
                .setWaitForCompletion(true)
                .execute(createSnapshotResponse);
                            assertEquals(0, snapshotInfo.failedShards());
                            threadPool,
        testClusterNodes.nodes.values()
                            e,
                        new IndexingPressureService(settings, clusterService),
                    new UpdateHelper(scriptService),
        /**
                throw new AssertionError(e);
                client().bulk(bulkRequest, bulkResponseStepListener);
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
            createIndexResponse -> client().admin()
                    initialState.term(),
                        mockIndicesService,
        continueOrDie(
                );
        });
        final int shards = randomIntBetween(1, 5);
                    coordinator.close();
            // Only disconnect cluster-manager if we have more than a single cluster-manager and can simulate a failover
                        .metadata()
                                    .reroute(
import org.opensearch.action.support.AutoCreateIndex;
                    }, exception -> { throw new AssertionError(exception); }));
                            threadPool,
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                    indicesService,
            }
import java.util.List;
                    afterIndexing.run();
                            )
                        .sourceAsMap()
                        indexNameExpressionResolver
        assertThat(successfulDeletes.get(), either(is(1)).or(is(2)));
    }
                    clusterService,
                transportService.getTaskManager()
            .mapToObj(i -> "snapshot-" + i)
        String repoName = "repo";
                            }
        private TestClusterNode newNode(String nodeName, DiscoveryNodeRole role) throws IOException {
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
                    "test",
                    settings,
        final VotingConfiguration votingConfiguration = new VotingConfiguration(
                .findFirst()
                    snapshotShardsService,
                    } catch (IOException e) {
                        final TestClusterNode restartedNode = new TestClusterNode(
            private final RecoverySettings recoverySettings;
import org.opensearch.action.admin.indices.stats.SearchResponseStatusStats;
                final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
                    mock(PluginsService.class),
        );
                        }
        return ClusterState.builder(state)
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
import org.opensearch.env.NodeEnvironment;
                    public void connectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
        continueOrDie(
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
            continueOrDie(cleanupResponse, r -> cleanedUp.set(true));
        clusterManagerNode.clusterService.addListener(new ClusterStateListener() {
        continueOrDie(
                && terms.size() == 1;
                actions.put(
                        assertThat(repoSnapshotResponse.getSnapshots(), hasSize(snapshotsList.length));
        public TestClusterNode randomDataNodeSafe(String... excludedNames) {
                );
                actions.put(
            ignored -> client().admin()
        for (TestClusterNodes.TestClusterNode node : testClusterNodes.nodes.values()) {
import org.opensearch.action.search.SearchExecutionStatsCollector;
        runUntil(documentCountVerified::get, TimeUnit.MINUTES.toMillis(5L));
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                        for (SnapshotInfo snapshotInfo : snapshotInfos) {
 * this file be licensed under the Apache-2.0 license or a
                snapshotShardsService.start();
                actions.put(
                .execute(ActionListener.wrap(() -> snapshotDeleteResponded.set(true)));
                }
                            .shardRoutingTable(shardToRelocate.shardId())
        assertEquals(0, snapshotInfo.failedShards());
            for (int i = 0; i < randomIntBetween(0, dataNodes); ++i) {
import org.opensearch.script.ScriptService;
import org.opensearch.plugins.PluginsService;
import org.opensearch.action.support.ActionTestUtils;
        final Collection<StepListener<Boolean>> deleteSnapshotStepListeners = Arrays.asList(new StepListener<>(), new StepListener<>());
        // Select from sorted list of nodes
                    namedXContentRegistry,
    /**
                .execute(createSnapshotResponseStepListener)
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
        assertThat(finalSnapshotsInProgress.entries(), empty());
                            .findAny();
        final String secondSnapshotName = "snapshot-2";
    public void testSuccessfulSnapshotAndRestore() {
import org.opensearch.common.util.BigArrays;
                    clusterManagerService,
            return randomClusterManagerNode().orElseThrow(
                if (deleted) {
    public void testSnapshotWithNodeDisconnects() {
                .deleteSnapshot(new DeleteSnapshotRequest(repoName, "*"), deleteSnapshotStepListener)
                    snapshotInfo.snapshotId(),
        Map<String, AggregateFileCacheStats> nodeFileCacheStats = new HashMap<>();
                .map(DiscoveryNode::getId)
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
import org.opensearch.action.admin.indices.create.TransportCreateIndexAction;
                        }
                    nodeEnv,
                        emptyMap(),
        assertTrue(createdSnapshot.get());
import org.opensearch.cluster.coordination.ClusterBootstrapService;
                    new TransportDeleteSnapshotAction(
        return createAliasListener;
    }
                            return (request, channel, task) -> scheduleSoon(new AbstractRunnable() {
                    threadPool
                    Collections.emptyList(),
                    Version.CURRENT
        // We end up with two snapshots no matter if the delete worked out or not
                && clusterManagerNodeIds.contains(null) == false
                .stream()
            final Runnable afterIndexing = () -> client().admin()
import org.opensearch.common.network.NetworkModule;
                            .renamePattern("(.+)")
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                        return namedWriteableRegistry;
                            return ConnectionStatus.CONNECTED;
    private static Settings defaultIndexSettings(int shards) {
    private void startCluster() {
        runUntil(
                        transportService,
        });
        continueOrDie(
                    actionFilters,
    private void disconnectOrRestartClusterManagerNode() {
                new SearchRequest("restored_alias_" + alias).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
            // Select from sorted list of data-nodes here to not have deterministic behaviour
                final MapperRegistry mapperRegistry = new IndicesModule(Collections.emptyList()).getMapperRegistry();
                        actionFilters,
    private Path tempDir;
    }
 * KIND, either express or implied.  See the License for the
                );
        }
                    Collections.emptyList()
        // We end up with no snapshots since at least one of the deletes worked out
                    CleanupRepositoryAction.INSTANCE,
                afterIndexing.run();
                        client,
            assertEquals(shards, restoreSnapshotResponse.getRestoreInfo().totalShards());
                        clusterService,
        deterministicTaskQueue.scheduleNow(runnable);
                    public void onFailure(Exception e) {
                testClusterNodes.disconnectNode(this);
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
                                        ),
                    clusterService.getSettings(),
import org.opensearch.ExceptionsHelper;
    public void createServices() {
            this.disconnectedNodes.clear();
            public void clusterChanged(ClusterChangedEvent event) {
                clusterService = new ClusterService(
import org.opensearch.index.seqno.RetentionLeaseSyncer;
        }
                .setWaitForCompletion(waitForSnapshot)
            createRepositoryListener,
        });
import org.opensearch.wlm.WorkloadGroupService;
            }
        for (SnapshotId snapshotId : snapshotIds) {
                    new TransportRestoreSnapshotAction(
        }
                    )
        );
        final String index = "test";
import org.opensearch.cluster.service.ClusterApplierService;
            .stream()
                            // Recreate index by the same name to test that we don't snapshot conflicting metadata in this scenario
            final SnapshotsInProgress snapshotsInProgress = clusterManager.clusterService.state().custom(SnapshotsInProgress.TYPE);
                    remoteStoreNodeService,
        assertNotNull(createSnapshotResponseListener.result());
        }
                        actionFilters,
                        indexNameExpressionResolver,
            });
            assertEquals(documents, Objects.requireNonNull(r.getHits().getTotalHits()).value());
                );
                .execute(createSnapshotResponseStepListener)
        final String index = "index-1";
        String snapshotName = "snapshot";
import java.nio.file.Path;
 * specific language governing permissions and limitations
import org.opensearch.indices.IndicesService;
                    new RestoreSnapshotRequest(repoName, snapshotName).waitForCompletion(true),
                    repositoryData.resolveIndexId(index)
    }
                actions.put(
import org.opensearch.index.shard.PrimaryReplicaSyncer;
                )
                    () -> 5.0,
                .putList(
        SnapshotsInProgress finalSnapshotsInProgress = randomClusterManager.clusterService.state()
                            transportService,
        final int clusterManagerNodeCount = randomFrom(1, 3, 5);
                        emptyMap()
                            SnapshotMissingException.class
                    metadataCreateIndexService,
public class SnapshotResiliencyTests extends OpenSearchTestCase {
                                @Override
        final int dataNodes = randomIntBetween(2, 10);
                        transportService,
                        clusterService,
                }
                    new FileCacheStats(1, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
        /**
            final Set<String> clusterManagerNodeIds = clusterStates.stream()
                );
            documentsFirstSnapshot + documentsSecondSnapshot,
        }
        clearDisruptionsAndAwaitSync();
                );
                        NoopMetricsRegistry.INSTANCE,
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
        String snapshotName = "snapshot";
            if (documents == 0) {
        String snapshotName = "snapshot";
                        transportService,
                        indexNameExpressionResolver
                        transportService,
            continueOrDie(deleteListener, deleted -> {
                            threadPool,
        deterministicTaskQueue.runAllRunnableTasks();
                new DiscoveryNode(
                    null,
            .orElseThrow(() -> new AssertionError("expected to find at least one active cluster-manager node"));
        final int documents = randomIntBetween(0, 100);
                assertNotNull(unwrapped);
            if (restoreSnapshotException instanceof RemoteTransportException) {
        final int shards = randomIntBetween(1, 10);
        String snapshotName = "snapshot";
        assertThat(snapshotIds, hasSize(2));
            // Select from sorted list of data-nodes here to not have deterministic behaviour
        final int shards = randomIntBetween(1, 10);
            client().search(
            }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            createSnapshotResponse -> client().admin()
        assertThat(snapshotIds, hasSize(0));
        });
import org.opensearch.action.search.SearchRequestOperationsCompositeListenerFactory;
                .map(clusterState -> clusterState.nodes().getClusterManagerNodeId())
                .setWaitForCompletion(true)
        final StepListener<AcknowledgedResponse> deleteIndexListener = new StepListener<>();
                        .execute(snapshotListener)
    }
        continueOrDie(
            // Create another snapshot and then clean up the repository to verify that the repository works correctly no matter the
                    try {
                }
                    ClusterStateAction.INSTANCE,
import java.util.Optional;
                            new SystemIngestPipelineCache()
                    null,
    private TestClusterNodes testClusterNodes;
            Settings.builder()
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
            );
                        indexNameExpressionResolver
 * GitHub history for details.
                client().admin().indices().create(new CreateIndexRequest("index-" + i), listener);
                .execute(createAnotherSnapshotResponseStepListener)
            );
        final StepListener<AcknowledgedResponse> deleteSnapshotStepListener = new StepListener<>();
            private final NodeConnectionsService nodeConnectionsService;
import org.opensearch.cluster.ClusterInfoService;
                        new AutoCreateIndex(settings, clusterSettings, indexNameExpressionResolver, new SystemIndices(emptyMap())),
        final TestClusterNodes.TestClusterNode randomClusterManager = testClusterNodes.randomClusterManagerNode()
import org.opensearch.cluster.coordination.PersistedStateRegistry;
            return snapshotsInProgress != null && snapshotsInProgress.entries().isEmpty();
            private final NodeEnvironment nodeEnv;
                public void run() {
                        actionFilters,
            client().admin()
                            scriptService,
        deterministicTaskQueue = new DeterministicTaskQueue(Settings.builder().put(NODE_NAME_SETTING.getKey(), "shared").build(), random());
                        settings,
                    assertNoFailureListener(bulkResponse -> {
                            client
        continueOrDie(
                        new SearchPipelineService(
import static org.mockito.Mockito.mock;
        deterministicTaskQueue.runAllRunnableTasks();
                    .prepareDeleteSnapshot(repoName, snapshotName)
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.node.DiscoveryNodes;
                    clusterService,
                repositoriesService.start();
                        return disconnectedNodes.contains(node.getName()) || disconnectedNodes.contains(destination.getName())
        continueOrDie(
import static org.hamcrest.Matchers.hasSize;
                (BlobStoreRepository) testClusterNodes.randomClusterManagerNodeSafe().repositoriesService.repository("repo"),
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
                        assertThat(unwrapped, notNullValue());
        assertEquals(
                .cluster()
import org.opensearch.cluster.routing.UnassignedInfo;
            // Index delete must be blocked for non-partial snapshots and we get a snapshot for every index
                                @Override
                            .renameReplacement("restored_$1")
                    0,
            acknowledgedResponse -> client().admin()
                        actionFilters,
                    allocationService,
            inProgressSnapshots
                .prepareCreateSnapshot(repoName, "snapshot-2")
        if (snapshotNeverStarted.get()) {
            private Coordinator coordinator;
                    RetentionLeaseSyncer.EMPTY,
                                + NODE_SEARCH_CACHE_SIZE_SETTING.getKey()
                        NoopTracer.INSTANCE
                    transportService,
                );
        );
                    clusterInfoService::getClusterInfo,
            createSnapshotResponse -> client().admin()
                    public void onResponse(AcknowledgedResponse acknowledgedResponse) {
                    }
                    }
                );
                actions.put(
                    } catch (IOException e) {
                        repositoriesService,
                            .custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY)
                    new TransportPutRepositoryAction(
                remoteStoreNodeService = new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, threadPool);
        deterministicTaskQueue.runAllRunnableTasks();
                searchAliasResponseListener
                final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        assertThat(snapshotIds, hasSize(1));
                        actionFilters,
 *
            testClusterNodes.nodes.values().forEach(n -> n.transportService.getConnectionManager().disconnectFromNode(node.node));
import org.opensearch.indices.cluster.IndicesClusterStateService;
                        metadataMappingService,
        testClusterNodes = new TestClusterNodes(clusterManagerNodes, dataNodes, warmNodes);
                        clusterService,
                final SearchService searchService = new SearchService(
                final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();
                                scheduleNow(() -> testClusterNodes.stopNode(clusterManagerNode));
        continueOrDie(
                        threadPool,
            private final MappingTransformerRegistry mappingTransformerRegistry;
            return dataNodes.isEmpty() ? Optional.empty() : Optional.ofNullable(randomFrom(dataNodes));
    }
                        )
                            new DiscoveryNode(node.getName(), node.getId(), node.getAddress(), emptyMap(), node.getRoles(), Version.CURRENT)
                                        .deleteSnapshot(new DeleteSnapshotRequest(repoName, snapshotName), noopListener());
        }
                    RestoreSnapshotAction.INSTANCE,
            return newNode(nodeName, DiscoveryNodeRole.DATA_ROLE);
            createRepoAndIndex(repoName, index, shards),
            final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
import org.opensearch.cluster.ClusterInfo;
                    transportService,
                }
            private final TransportService transportService;
                        )
        continueOrDie(
        final StepListener<CreateIndexResponse> createIndexResponseStepListener = new StepListener<>();
            assertThat(snapshotInfo.state(), either(is(SnapshotState.SUCCESS)).or(is(SnapshotState.PARTIAL)));
                            transportService,
                            settings,
                        clusterService,
        final StepListener<AcknowledgedResponse> deleteSnapshotStepListener = new StepListener<>();
        stabilize();
                    actionFilters,
                transportService.acceptIncomingRequests();
                    restoreSnapshotResponseListener
        assertEquals(0, snapshotInfo.failedShards());
                    )
import org.opensearch.action.search.SearchTransportService;
                .setWaitForCompletion(true)
         * @return DiscoveryNodes
                return;
                                    testClusterNodes.randomDataNodeSafe().client.admin()
                    null
        // Connect all nodes to each other
                    protected ConnectionStatus getConnectionStatus(DiscoveryNode destination) {
                    threadPool,
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
                                    throw new AssertionError(e);
                            this.targetsByNode.put(discoveryNode, createConnectionTarget(discoveryNode));
import java.util.Collection;
                        transportService,
            return builder.build();
import org.opensearch.cluster.node.DiscoveryNode;
                actions.put(
                .cluster()
                    SearchAction.INSTANCE,
                    SearchExecutionStatsCollector.makeWrapper(responseCollectorService)
        );
import org.opensearch.indices.recovery.DefaultRecoverySettings;
                        null
                clusterService.getClusterApplierService().setNodeConnectionsService(nodeConnectionsService);
            final Set<String> disconnectedNodes = new HashSet<>(this.disconnectedNodes);
        final StepListener<AcknowledgedResponse> deleteIndexListener = new StepListener<>();
            return randomDataNode(excludedNames).orElseThrow(() -> new AssertionError("Could not find another data node."));
                        clusterService,
            } catch (SnapshotRestoreException ignored) {}
                .filter(n -> disconnectedNodes.contains(n.node.getName()) == false)
        }
        String repoName = "repo";
            createRepoAndIndex(repoName, index, shards),
                        namedXContentRegistry,
                            testClusterNodes.randomDataNodeSafe().client.admin()
                    });
                .orElseThrow(() -> new AssertionError("Could not find node by id [" + nodeId + ']'));
                        threadPool,
        final int clusterManagerNodes = randomFrom(3, 5);
                    environment,
                final IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(
        private TestClusterNode newDataNode(String nodeName) throws IOException {
            client().search(
            );
            createIndexResponse -> client().admin()
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                                .execute(ActionListener.wrap(() -> {
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
                .prepareCreateSnapshot(repoName, snapshotName)
                                node,
        Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
                .filter(DiscoveryNode::isClusterManagerNode)
                repositoriesService = new RepositoriesService(
        }, TimeUnit.MINUTES.toMillis(1L));
                });
    }
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                );
            TestClusterNode(DiscoveryNode node) throws IOException {
                    )
     * Context shared by all the node's {@link Repository} instances if the eventually consistent blobstore is to be used.
                actions.put(
import org.opensearch.monitor.StatusInfo;
        // No snapshots should be left in the repository
                    };
        final StepListener<CreateSnapshotResponse> createAnotherSnapshotResponseStepListener = new StepListener<>();
import org.opensearch.action.admin.indices.mapping.put.TransportAutoPutMappingAction;
                }
                });
                    namedXContentRegistry,
                    ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
            private final Logger logger = LogManager.getLogger(TestClusterNode.class);
                        if (node.equals(destination)) {
            acknowledgedResponse -> client().admin()
                                                index,
                            new AnalysisModule(environment, Collections.emptyList()).getAnalysisRegistry(),
                        if (action.startsWith("internal:index/shard/recovery")) {
                            null,
                        indexNameExpressionResolver
                        environment,
            for (StepListener<Boolean> deleteListener : deleteSnapshotStepListeners) {
        String snapshotName = "snapshot";
                        searchRequestOperationsCompositeListenerFactory,
    }
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                    bigArrays,
                .execute(createSnapshotResponseStepListener)
                .cluster()
            scheduleNow(() -> client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).execute(deleteSnapshotStepListener));
                .setWaitForCompletion(true)
            for (int i = 0; i < randomIntBetween(0, dataNodes); ++i) {
    private final class TestClusterNodes {
                        )
                .execute(createSnapshotResponseStepListener);
                nodeConnectionsService.start();
                snapshotsService = new SnapshotsService(
        }
        startCluster();
import java.util.stream.Stream;
            createIndicesListener,
            afterIndexing.run();
            return clusterManager;
            } else {
        final String index = "test";
            this(clusterManagerNodes, dataNodes, 0);
                    threadPool
                .map(node -> node.clusterService.state())
        );
        runUntil(() -> testClusterNodes.randomClusterManagerNode().map(clusterManager -> {
                actions.put(
                .sorted(Comparator.comparing(n -> n.node.getName()))
            .build();
        assertNotNull(restoreSnapshotResponseListener.result());
                .put(PATH_HOME_SETTING.getKey(), tempDir.resolve(nodeName).toAbsolutePath())
            }
import org.opensearch.cluster.routing.RerouteService;
                        metadataDeleteIndexService,
        final int dataNodes = randomIntBetween(2, 10);
                    shardStateAction,
                    .cluster()
import org.opensearch.transport.RemoteTransportException;
                        metadata,
                    assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
            assertEquals(shards, restoreSnapshotResponse.getRestoreInfo().totalShards());
                        }
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                                                true
                                protected void doRun() throws Exception {
                    protected NamedWriteableRegistry writeableRegistry() {
import org.opensearch.cluster.action.index.MappingUpdatedAction;
        final StepListener<AcknowledgedResponse> createRepositoryListener = new StepListener<>();
                    )
        );
                        }
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
        );
import org.opensearch.action.admin.cluster.snapshots.delete.TransportDeleteSnapshotAction;
            }
                    ClusterRerouteAction.INSTANCE,
            final ShardRouting shardToRelocate = clusterStateResponse.getState().routingTable().allShards(index).get(0);
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
 *
            )
                .cluster()
import org.opensearch.index.SegmentReplicationStatsTracker;
                )
        );
        setupTestCluster(clusterManagerNodes, dataNodes);
import org.opensearch.repositories.RepositoryData;
        );
                    allocationService,
                    indicesService,
                        clusterService,
                        transportService,
                    () -> clusterService.localNode().getId(),
                    clusterService,
            private final DisruptableMockTransport mockTransport;
import java.util.stream.Collectors;
    }
            exceptionVerified.set(true);
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
                .execute(deleteSnapshotStepListener)
                    new SystemIndices(emptyMap()),
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                .execute(createAnotherSnapshotResponseStepListener);
                        emptyMap(),
import org.opensearch.cluster.ClusterStateListener;
                );
    }
                    BulkAction.INSTANCE,
            scheduleNow(this::disconnectOrRestartClusterManagerNode);
                }, a -> node, null, emptySet(), NoopTracer.INSTANCE);
        assertEquals(0, snapshotInfo.failedShards());
            }
        final String index = "test";
                bulkRequest.add(new IndexRequest(index).source(Collections.singletonMap("foo", "bar" + i)));
                );
                }
        }
                        null
        String snapshotName = "snapshot";
                    null,
                testClusterNodes.disconnectNode(clusterManagerNode);
            assertEquals(shards, snapshotInfo.successfulShards());
                    clusterService,
        return randomFrom(nodes).client;
import static org.hamcrest.Matchers.endsWith;
                };
                scheduleSoon(() -> {
            createSnapshotResponseListener,
        });
                    searchService::aggReduceContextBuilder
                        transportService,
                    DeleteIndexAction.INSTANCE,
            deterministicTaskQueue.advanceTime();
                        indexNameExpressionResolver,
                        emptyMap(),
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
                        protected void assertSnapshotOrGenericThread() {
                    new TransportGetSnapshotsAction(
        }
                when(mockIndicesService.getSearchResponseStatusStats()).thenReturn(new SearchResponseStatusStats());
                            indicesService,
                .aliases(
        Settings.Builder settings = Settings.builder().put("location", randomAlphaOfLength(10));
                            Collections.emptyList(),
            assertEquals(0, snapshotInfo.failedShards());
                        threadPool,
    }
                            return ConnectionStatus.DISCONNECTED;
                        }
                            node.node,
                                + " setting."
                            .map(cn -> cn.mockTransport)
                        new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
                    new TaskResourceTrackingService(settings, clusterSettings, threadPool),
                    @Override
                        threadPool,
                            new SystemIndices(emptyMap()),
                    }
                            .renameAliasPattern("(.+)")
                );
import org.opensearch.cluster.action.index.NodeMappingRefreshAction;
                });
                    testClusterNodes.nodes.values()
                        indexNameExpressionResolver,
        });
import org.opensearch.cluster.SnapshotsInProgress;
                        threadPool,
                        .index(restoredIndex)
        );
        String snapshotName = "snapshot";
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), repoName, FsRepository.TYPE, settings, createRepositoryListener);
            deleteIndexListener,
            .custom(SnapshotDeletionsInProgress.TYPE);
                    )
            );
                final SnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
                    new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
            documentCountVerified.set(true);
                    )
        );
                searchIndexResponseListener
                                            new AllocateEmptyPrimaryAllocationCommand(
                        actionFilters,
        runUntil(() -> doneIndexing.get() && doneSnapshotting.get(), TimeUnit.MINUTES.toMillis(5L));
            assertEquals(shards, restoreSnapshotResponse.getRestoreInfo().totalShards());
                    clusterService,
        continueOrDie(
                        emptyMap(),
                clusterManagerService = new FakeThreadPoolClusterManagerService(
                    GetSnapshotsAction.INSTANCE,
                    new NoneCircuitBreakerService(),
            node.stop();
                        mockIndicesService,
                    new SegmentReplicationTargetService(
                    indicesService,
import org.opensearch.cluster.coordination.MockSinglePrioritizingExecutor;
        final String restoredIndex = "restored";
    private void setupTestCluster(int clusterManagerNodes, int dataNodes, int warmNodes) {
                        settings,
                    assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
            final StepListener<CreateSnapshotResponse> createSnapshotResponse = new StepListener<>();
                nodes.computeIfAbsent("node" + i, nodeName -> {
                        .forEach(
        deterministicTaskQueue.runAllRunnableTasks();
                .setPartial(partialSnapshot)
        final ActionListener<CreateSnapshotResponse> snapshotListener = new GroupedActionListener<>(
import java.util.Map;
            .forEach(testClusterNode -> testClusterNode.coordinator.setInitialConfiguration(votingConfiguration));
        final String index = "index-1";
                () -> new AssertionError("Expected to find at least one connected cluster-manager node")
            }
                    .setTaskResourceTrackingService(new TaskResourceTrackingService(settings, clusterSettings, threadPool));
                .cluster()
         */
                );
            try {
import org.opensearch.cluster.ClusterModule;
import static org.hamcrest.Matchers.is;
import org.opensearch.action.StepListener;
    private void scheduleNow(Runnable runnable) {
                        ),
                        actionFilters,
            assertThat(snapshotIds, hasSize(1));
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
            }
            createOtherSnapshotResponseStepListener,
                .prepareCreateSnapshot(repoName, snapshotName)
            } else {
            createSnapshotResponse -> client().admin()
                    try {
                    new TransportPutMappingAction(
    public void testSnapshotPrimaryRelocations() {
                transportService.start();
            }
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                actions.put(
                    threadPool,
        String snapshotName = "snapshot";
 * not use this file except in compliance with the License.
        );
                final ScriptService scriptService = new ScriptService(settings, emptyMap(), emptyMap());
                    transportService.getRemoteClusterService(),
                    indexScopedSettings,
                    shardLimitValidator,
import org.opensearch.cluster.coordination.CoordinatorTests;
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.env.Environment.PATH_HOME_SETTING;
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), shards)
                    new IndexingPressureService(settings, clusterService),
                    writableRegistry(),
            if (snapshotInfo.successfulShards() == indices + 1) {
import org.opensearch.env.TestEnvironment;
                    stateForNode(initialState, node)
                            );
            return new TestClusterNode(
                .indices()
import org.opensearch.action.admin.indices.mapping.put.TransportPutMappingAction;
                threadPool = deterministicTaskQueue.getThreadPool(runnable -> CoordinatorTests.onNodeLog(node, runnable));
            Objects.requireNonNull(searchAliasResponseListener.result().getHits().getTotalHits()).value()
import org.opensearch.action.support.TransportAction;
                new SearchRequest("restored_" + index).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
                        if (partialSnapshot) {
        );
import java.util.HashSet;
        });
                nodes.computeIfAbsent("warm-node" + i, nodeName -> {
                doneIndexing.set(true);
                actions.put(
            testClusterNodes.randomDataNodeSafe().clusterService.state()
                                .cluster()
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
                        shardStateAction,
                )
                        .stream()
                            "Size of the indexes to be restored exceeds the file cache bounds. Increase the file cache capacity on the cluster nodes using "
                .cluster()
                        indexNameExpressionResolver,
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                        clusterService
                        protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {
        String repoName = "repo";
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
            assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
        });
            private Map<ActionType, TransportAction> actions = new HashMap<>();
        final int indices = randomIntBetween(5, 20);
                    bulkRequest.add(new IndexRequest(index).source(Collections.singletonMap("foo", "bar" + i)));
                .prepareCreateSnapshot(repoName, snapshotName)
                final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
                continueOrDie(bulkResponseStepListener, bulkResponse -> {
            return nodes.values()
        final int shards = randomIntBetween(1, 10);
    }
                    )
                        List<SnapshotInfo> snapshotInfos = repoSnapshotResponse.getSnapshots();
            });
        final String index = "test";
            createIndexResponse -> client().admin()
        final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
        final String snapshot = snapshotsList[0];
                clusterManagerService.setClusterStatePublisher(coordinator);
            nodes.values().forEach(node -> builder.add(node.node));
        final AtomicBoolean exceptionVerified = new AtomicBoolean();
                        namedWriteableRegistry,
                );
                .cluster()
            }
                .map(n -> n.node)
import java.util.ArrayList;
    }
                assertTrue(throwable instanceof SnapshotRestoreException);
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                        .collect(Collectors.toList()),
                continueOrDie(bulkResponseStepListener, bulkResponse -> {
                final CoordinationState.PersistedState persistedState = new InMemoryPersistedState(
                    transportService,
        final String index = "test";
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        final String index = "test";
                );
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                );
                scheduleSoon(() -> testClusterNodes.clearNetworkDisruptions());
        final ActionListener<CreateSnapshotResponse> createSnapshotListener = new GroupedActionListener<>(
                throwable = restoreSnapshotException.getCause();
                                () -> testClusterNodes.randomClusterManagerNodeSafe().client.admin()
                .setWaitForCompletion(true)
        assertTrue(documentCountVerified.get());
        } else {
        setupTestCluster(clusterManagerNodes, dataNodes);
        final StepListener<SearchResponse> searchAliasResponseListener = new StepListener<>();
        assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
        final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
import org.opensearch.common.settings.IndexScopedSettings;
    private void setupTestCluster(int clusterManagerNodes, int dataNodes) {
         * Returns the {@link TestClusterNode} for the cluster-manager node in the given {@link ClusterState}.
                    new QueryPhase(),
                .stream()
import org.opensearch.action.resync.TransportResyncReplicationAction;
        private TestClusterNode newClusterManagerNode(String nodeName) throws IOException {
import org.junit.After;
                        final Throwable unwrapped = ExceptionsHelper.unwrap(
import org.opensearch.indices.recovery.PeerRecoverySourceService;
                if (blobStoreContext == null) {
    }
                    GetSnapshotsRequest repoSnapshotRequest = new GetSnapshotsRequest().repository(repoName)
            }
        assertEquals(0, snapshotInfo.failedShards());
import org.opensearch.index.store.remote.filecache.FileCacheStats;
import org.opensearch.common.CheckedConsumer;
                            indicesService,
                assertEquals(documents, bulkResponse.getItems().length);
        }
                lessThanOrEqualTo(
        public Optional<TestClusterNode> randomClusterManagerNode() {
        SnapshotDeletionsInProgress deletionsInProgress = clusterManagerNode.clusterService.state()
                final MetadataMappingService metadataMappingService = new MetadataMappingService(clusterService, indicesService);
import org.opensearch.action.admin.indices.create.CreateIndexAction;
        assertThat(snapshotIds, contains(createOtherSnapshotResponseStepListener.result().getSnapshotInfo().snapshotId()));
    }
 * SPDX-License-Identifier: Apache-2.0
                actions.put(
                        if (initiatedSnapshot.compareAndSet(false, true)) {
        }
import org.opensearch.cluster.service.ClusterService;
                    settings,
import org.opensearch.transport.TransportException;
    private StepListener<CreateIndexResponse> createRepoAndIndex(String repoName, String index, int shards) {
                                            )
import org.opensearch.snapshots.mockstore.MockEventuallyConsistentRepository;
                            .renameAliasReplacement("restored_alias_$1"),
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
import org.opensearch.env.Environment;
            DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
import static java.util.Collections.emptyMap;
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {
                            // eliminate thread name check as we create repo in the test thread
                "Documents were restored but the restored index mapping was older than some documents and misses some of their fields",
        final ClusterState initialClusterState = new ClusterState.Builder(ClusterName.DEFAULT).nodes(testClusterNodes.discoveryNodes())
            .orElseThrow(() -> new AssertionError("expected to find at least one active cluster-manager node"));
                    settings,
                final Settings settings = environment.settings();
        assertThat(finalSnapshotsInProgress.entries(), empty());
                        snapshotsService,
            for (CreateSnapshotResponse createSnapshotResponse : createSnapshotResponses) {
            .forEach(
    }
                });
                    new FileCacheStats(1, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
                        clusterService,
        final int shards = randomIntBetween(1, 10);
                    )
import org.opensearch.cluster.coordination.ElectionStrategy;
                    ),
        final StepListener<CreateSnapshotResponse> createAnotherSnapshotResponseStepListener = new StepListener<>();
        stabilize();
                        threadPool,
                indicesClusterStateService.close();
        continueOrDie(createSnapshotResponseStepListener, createSnapshotResponse -> {
                    new TransportSearchAction(
                    ReferencedSegmentsPublisher.EMPTY
                .filter(n -> n.node.isClusterManagerNode())
        Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
                    indicesService,
                );
                    allocationService,
        clearDisruptionsAndAwaitSync();
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
            final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
        public TestClusterNode nodeById(final String nodeId) {
        );
                    node.getName(),
                .prepareCreateSnapshot(repoName, snapshotName)
            empty()
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
                        new TransportResyncReplicationAction(
                    mappingUpdatedAction,
                    threadPool,
        assertEquals(shards, snapshotInfo.successfulShards());
        });
                final SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
                    indicesService,
        assertThat(snapshotIds, empty());
import org.opensearch.repositories.Repository;
                        .mapping()
        continueOrDie(searchResponseStepListener, r -> {
            final Runnable afterIndexing = () -> client().admin()
import org.opensearch.action.admin.indices.mapping.put.PutMappingAction;
import org.opensearch.search.SearchService;
        final String[] snapshotsList = { GetSnapshotsRequest.CURRENT_SNAPSHOT };
                .cluster()
            });
                .setWaitForCompletion(true)
                    clusterService.getClusterApplierService(),
                .cluster()
                    () -> new StatusInfo(HEALTHY, "healthy-info"),
            private final IndicesClusterStateService indicesClusterStateService;
                            environment,
    private void indexNDocuments(int documents, String index, Runnable afterIndexing) {
                        indexNameExpressionResolver,
        // Remove and add back local node to update ephemeral id on restarts
        );
                nodes.computeIfAbsent("data-node" + i, nodeName -> {
                        onCompletion.run();
                        transportService,
        final long endTime = deterministicTaskQueue.getCurrentTimeMillis() + AbstractCoordinatorTestCase.DEFAULT_STABILISATION_TIME;
        for (SnapshotId snapshotId : snapshotIds) {
import org.apache.logging.log4j.Logger;
                        threadPool,
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                .execute(createSnapshotResponseListener);
            private final ClusterManagerService clusterManagerService;
                .cluster()
                        repositoriesService,
        );
        final int shards = randomIntBetween(1, 10);
                )
        // TODO: randomize replica count settings once recovery operations aren't blocking anymore
                    ElectionStrategy.DEFAULT_INSTANCE,
                        transportShardBulkAction,
                            n -> n.transportService.openConnection(
                client().admin().cluster().cleanupRepository(new CleanupRepositoryRequest("repo"), cleanupResponse);
                .collect(Collectors.toList());
        assertThat(restoreSnapshotResponseListener.result().getRestoreInfo().failedShards(), is(0));
import org.opensearch.cluster.ClusterManagerMetrics;
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
                }
                    @Override
                documentsSecondSnapshot,
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                        transportService,
                );
                    indexNameExpressionResolver,
            assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
                    protected void execute(Runnable runnable) {
        // We did one snapshot and one delete so we went two steps from the empty generation (-1) to 1
                        new SystemIndices(emptyMap()),
import org.opensearch.transport.TransportService;
        runUntil(documentCountVerified::get, TimeUnit.MINUTES.toMillis(5L));
                .prepareCreateSnapshot(repoName, snapshotName)
import org.opensearch.Version;
import org.opensearch.cluster.ClusterState;
                                    createdSnapshot.set(true);
    public void testRunConcurrentSnapshots() {
                scheduleNow(this::disconnectOrRestartDataNode);
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                    repositoriesService,
                        // we rely on disconnect to run for keeping track of pendingDisconnects and ensuring node-joins can happen
                    continueOrDie(updatedClusterStateResponseStepListener, updatedClusterState -> {
                    clusterService,
                .restoreSnapshot(
        continueOrDie(
                    repositoriesService,
        tempDir = createTempDir();
                if (event.state().custom(SnapshotsInProgress.TYPE) != null) {
        );
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseListener = new StepListener<>();
            }
        return createIndexResponseStepListener;
import java.util.concurrent.atomic.AtomicBoolean;
                assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
                }
            assertThat(snapshotIds, empty());
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
                .execute(createSnapshotResponseStepListener)
                    namedXContentRegistry
import org.opensearch.indices.recovery.RecoverySettings;
            }
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                            NoopTracer.INSTANCE
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                assertEquals(snapshotInfo.snapshotId().getName(), snapshotsList[0]);
            } else if (randomBoolean()) {
                                        noopListener()
        SnapshotsInProgress finalSnapshotsInProgress = randomClusterManager.clusterService.state().custom(SnapshotsInProgress.TYPE);
                    .prepareCreateSnapshot(repoName, secondSnapshotName)
            assertEquals(0, snapshotInfo.failedShards());
            }
            for (int i = 0; i < inProgressSnapshots; i++) {
                        indexNameExpressionResolver,
                    )
                final SetOnce<RepositoriesService> repositoriesServiceReference = new SetOnce<>();
            }
                        mock(SegmentReplicationStatsTracker.class),
                        transportService,
                    @Override
                );
                    namedWriteableRegistry,
                    hostsResolver -> nodes.values()
            private Repository.Factory getRepoFactory(Environment environment) {
                client.initialize(
                    .execute(createSnapshotResponseStepListener)
                    () -> client().admin()
                    @Override
        clearDisruptionsAndAwaitSync();
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
import org.opensearch.action.admin.indices.alias.IndicesAliasesAction;
import org.opensearch.indices.analysis.AnalysisModule;
                                        .cluster()
                })
                    Collections.emptyList(),
import org.opensearch.tasks.TaskResourceTrackingService;
import org.opensearch.cluster.service.ClusterManagerService;
 * Unless required by applicable law or agreed to in writing,
                        random()
                new SearchRequest(index).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
                    DefaultRecoverySettings.INSTANCE,
        clusterManagerNode.clusterService.addListener(new ClusterStateListener() {
                    ((Map<?, ?>) clusterManagerNode.clusterService.state()
        String repoName = "repo";
                        threadPool,
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
        continueOrDie(createSnapshotResponseStepListener, createSnapshotResponse -> {
    private void disconnectOrRestartDataNode() {
                    mapperRegistry,
        final StepListener<SearchResponse> searchResponseStepListener = new StepListener<>();
import static org.opensearch.node.Node.NODE_SEARCH_CACHE_SIZE_SETTING;
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                        // TODO: Remove this hack once recoveries are async and can be used in these tests
        if (nodes.isEmpty()) {
        final AtomicBoolean createdSnapshot = new AtomicBoolean();
                .setIncludeGlobalState(randomBoolean())
                    settings,
            @Override
                    .execute(ActionListener.wrap(resp -> deleteListener.onResponse(true), e -> {
                    false,
        });
        assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
            .filter(n -> testClusterNodes.disconnectedNodes.contains(n.node.getName()) == false)
import org.opensearch.transport.client.AdminClient;
            transportGetSnapshotsAction.execute(null, repoSnapshotRequest, ActionListener.wrap(repoSnapshotResponse -> {
        final Repository repository = randomClusterManager.repositoriesService.repository(repoName);
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
            // Single shard for each index so we either get all indices or all except for the deleted index
                        actionFilters,
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
                            scriptService,
                    settings,
        final long start = deterministicTaskQueue.getCurrentTimeMillis();
                        clusterService,
                mockTransport = new DisruptableMockTransport(node, logger, deterministicTaskQueue) {
                    scriptService,
    public void testTransportGetCurrentSnapshotsAction() {
                allocationService = OpenSearchAllocationTestCase.createAllocationService(settings, snapshotsInfoService);
                        mappingTransformerRegistry
            .collect(Collectors.toList());
import org.opensearch.ingest.IngestService;
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
                        new TransportNodesListGatewayStartedShards(
                    new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.add().index(index).alias(alias)),
                    new AliasValidator(),
                .execute(createSnapshotResponseStepListener)
import org.opensearch.indices.DefaultRemoteStoreSettings;
                            .primaryShard();
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
        continueOrDie(restoreSnapshotResponseListener, restoreSnapshotResponse -> {
                    deterministicTaskQueue::scheduleNow
                );
                            new IndexingPressureService(settings, clusterService),
                    transportService,
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
        setupTestCluster(1, 2, 2);
        assertEquals(
                );
                    repositoriesService,
                    assertEquals(documents, bulkResponse.getItems().length);
                    clusterService,
            snapshotNames.size()
                assertEquals(indexMetadata.getIndex(), firstIndex.get());
    public NodeClient client() {
                .filter(n -> n.node.getId().equals(nodeId))
                            : ConnectionStatus.CONNECTED;
        deterministicTaskQueue.runAllRunnableTasks();
                        snapshotsService,
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {
                        scheduleNow(CoordinatorTests.onNodeLog(getLocalNode(), runnable));
        client().bulk(bulkRequest, bulkResponseStepListener);
                .setPartial(true)
        final int shards = randomIntBetween(1, 10);
                    new TransportGetTermVersionAction(
            deterministicTaskQueue.advanceTime();
                    successfulDeletes.incrementAndGet();
                actions.put(
                .prepareCreateSnapshot(repoName, snapshotName)
        assertEquals(shards, snapshotInfo.successfulShards());
            }
                client().bulk(bulkRequest, bulkResponseStepListener);
import org.opensearch.action.search.SearchPhaseController;
                    .setWaitForCompletion(true)
                    )
                    systemIndices,
            assertEquals(snapshotInfo.successfulShards(), indices + 1);
            for (String snapshotName : snapshotNames) {
import java.util.concurrent.atomic.AtomicInteger;
        String repoName = "repo";
        private final class TestClusterNode {
                    DeleteSnapshotAction.INSTANCE,
                            return new MockSinglePrioritizingExecutor(node.getName(), deterministicTaskQueue, threadPool);
                SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory =
                .entries(),
            assertEquals(snapshotInfo.state(), SnapshotState.SUCCESS);
        continueOrDie(
import org.opensearch.action.bulk.BulkAction;
                            if (clusterManagerNodeCount > 1) {
                ThreadPool threadPool,
            );
                        throw new AssertionError(e);
            createSnapshotResponse -> client().admin()
     * deleting a snapshot.
                snapshotsService.start();
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
import org.opensearch.repositories.fs.FsRepository;
    public void verifyReposThenStopServices() {
                actions.put(
        try {
                            List.of(),
        final TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                    throwable.getMessage()
                        .map(n -> n.node.getAddress())
        final String index = "test";
         * Node names that are disconnected from all other nodes.
                    indexScopedSettings,
        }
                scheduleNow(
                                public void onFailure(final Exception e) {
                    createAliasListener
                        new RequestValidators<>(Collections.emptyList()),
        assertThat(snapshotIds, hasSize(1));
            final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();
        final AtomicBoolean documentCountVerified = new AtomicBoolean();
            deterministicTaskQueue.runAllRunnableTasks();
        if (documents == 0) {
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                        transportService,
 * Modifications Copyright OpenSearch Contributors. See
                    final StepListener<ClusterStateResponse> updatedClusterStateResponseStepListener = new StepListener<>();
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteAction;
        );
                    mock(SegmentReplicationSourceService.class),
                    settings,
                        metadataIndexAliasesService,
                    new GlobalCheckpointSyncAction(
            private RemoteStoreNodeService remoteStoreNodeService;
                rerouteServiceSetOnce.set(rerouteService);
import org.opensearch.cluster.service.FakeThreadPoolClusterManagerService;
                                .execute(createSnapshotResponseStepListener);
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                        transportService,
                snapshotShardsService = new SnapshotShardsService(
        if (randomBoolean()) {
                    rerouteService,
        final int clusterManagerNodes = randomFrom(1, 3, 5);
        final StepListener<CreateSnapshotResponse> createSnapshotResponseListener = new StepListener<>();
                        allocationService,
                client = new NodeClient(settings, threadPool);
            @Override
import org.opensearch.repositories.RepositoriesService;
        String snapshotName = "snapshot";
                    nodeName,
                TransportService transportService
import org.opensearch.cluster.metadata.MetadataMappingService;
        }
                        clusterService,
                    ) {
        );
    }
    /**
                                }
            if (partial == false) {
        final StepListener<CreateSnapshotResponse> createOtherSnapshotResponseStepListener = new StepListener<>();
            for (int i = 0; i < clusterManagerNodes; ++i) {
            throw new AssertionError("No nodes available");
            public void restart() {
            .build();
        private final Map<String, TestClusterNode> nodes = new LinkedHashMap<>();
import org.opensearch.threadpool.ThreadPool;
                        indexScopedSettings,
                    return metadata -> new MockEventuallyConsistentRepository(
                stop();
     * Simulates concurrent restarts of data and cluster-manager nodes as well as relocating a primary shard, while starting and subsequently
        final String index = "test";
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseListener = new StepListener<>();
                    PutMappingAction.INSTANCE,
            return versions.size() == 1
                clusterInfoService = Mockito.mock(ClusterInfoService.class);
import org.opensearch.cluster.metadata.IndexMetadata;
        final StepListener<Collection<CreateSnapshotResponse>> allSnapshotsListener = new StepListener<>();
                .setWaitForCompletion(true)
            assertEquals(0, snapshotInfo.failedShards());
        final AtomicBoolean doneIndexing = new AtomicBoolean(false);
                assertThat(snapshotInfo.successfulShards(), is(snapshotInfo.totalShards() - snapshotInfo.failedShards()));
            disconnectedNodes.forEach(nodeName -> {
                );
        continueOrDie(
                            ActionTestUtils.assertNoFailureListener(c -> logger.info("--> Connected [{}] to [{}]", n.node, node.node))
                    transportGetSnapshotsAction.execute(null, repoSnapshotRequest, ActionListener.wrap(repoSnapshotResponse -> {
                assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
            createIndexResponses -> client().admin()
                            .getEntries()
            nodeFileCacheStats.put(
                rerouteService = new BatchedRerouteService(clusterService, allocationService::reroute);
        String snapshotName = "snapshot";
                .restoreSnapshot(
                )
        final SetOnce<Index> firstIndex = new SetOnce<>();
        deterministicTaskQueue.scheduleAt(deterministicTaskQueue.getCurrentTimeMillis() + randomLongBetween(0, 100L), runnable);
                    Collections.singleton(role),
}
                        new SystemIndices(emptyMap()),
                        indexNameExpressionResolver,
                        indexNameExpressionResolver,
        final AtomicInteger successfulDeletes = new AtomicInteger(0);
        final int documents = randomIntBetween(0, 100);
                        .contains(
        final String[] snapshotsList = { "snapshot-1" };
                        transportService,
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {
            blobStoreContext = new MockEventuallyConsistentRepository.Context();
        }, e -> {
        final PlainActionFuture<RepositoryData> res = PlainActionFuture.newFuture();
                    new RestoreSnapshotRequest(repoName, snapshotName).waitForCompletion(true)
                    IndicesShardStoresAction.INSTANCE,
        continueOrDie(
        }
        }
import org.opensearch.search.builder.SearchSourceBuilder;
                );
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
                if (coordinator != null) {
            private final DiscoveryNode node;
                final SetOnce<RerouteService> rerouteServiceSetOnce = new SetOnce<>();
        continueOrDie(
                        new SegmentReplicationSourceFactory(transportService, recoverySettings, clusterService),
        deterministicTaskQueue.runAllRunnableTasks();
        }
    }
                    repositoryData,
                for (int i = 0; i < documents; ++i) {
                        }
        while (timeout > deterministicTaskQueue.getCurrentTimeMillis() - start) {
import org.opensearch.action.search.SearchResponse;
            private final NodeClient client;
                        ),
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
import org.opensearch.action.bulk.BulkRequest;
                                                shardRouting.shardId().id(),
        final String index = "test";
            client().search(
                            actionFilters,
            .stream()
                    clusterService,
                .cluster()
                .execute(createSnapshotResponseListener);
import org.opensearch.action.admin.cluster.repositories.put.TransportPutRepositoryAction;
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
                        transportService,
        });
                        }
        }
                        n -> n.transportService.connectToNode(
                if (testClusterNodes.nodes.containsKey(nodeName)) {
    }
            createRepoAndIndex(repoName, index, shards),
        assertNotNull(restoreSnapshotResponseStepListener.result());
                            assertTrue(snapshotInfo.snapshotId().getName().contains("last-snapshot"));
                    .cluster()
                    )
        startCluster();
        );
                    settings,
        final Repository repository = testClusterNodes.randomClusterManagerNodeSafe().repositoriesService.repository(repoName);
            testClusterNodes.randomDataNode().ifPresent(TestClusterNodes.TestClusterNode::restart);
                client().bulk(
/*
                .restoreSnapshot(
import static org.opensearch.node.Node.NODE_NAME_SETTING;
                    }
        assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
                    .restoreSnapshot(
                    new TransportBulkAction(
                    transportService,
                scheduleNow(this::disconnectRandomDataNode);
import org.opensearch.gateway.TransportNodesListGatewayStartedShards;
                        mapperRegistry,
                            ? ConnectionStatus.DISCONNECTED
                        }
        continueOrDie(
                testClusterNodes.disconnectNode(this);
                    )
                        emptyMap(),
                );
                coordinator.setNodeConnectionsService(nodeConnectionsService);
            createRepoAndIndex(repoName, index, shards),
                    assertEquals(documents, bulkResponse.getItems().length);
                final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(
            }
                    new PeerRecoverySourceService(transportService, indicesService, recoverySettings),
        continueOrDie(createSnapshotResponseStepListener, createSnapshotResponse -> {
import org.opensearch.action.support.ActiveShardCount;
        final List<TestClusterNodes.TestClusterNode> nodes = testClusterNodes.nodes.values()
import org.opensearch.common.Nullable;
                .setWaitForCompletion(false)
import org.opensearch.action.support.clustermanager.term.TransportGetTermVersionAction;
        final StepListener<CreateSnapshotResponse> createSnapshotResponseListener = new StepListener<>();
                        .renameReplacement(restoredIndex)
                        actionFilters,
     */
                    mock(RemoteStorePressureService.class),
import org.opensearch.cluster.routing.allocation.AllocationService;
        );
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
                            assertEquals(SnapshotState.IN_PROGRESS, snapshotInfo.state());
                final IndicesService mockIndicesService = mock(IndicesService.class);
                    settings,
                });
            return newNode(nodeName, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
        final int shards = randomIntBetween(1, 10);
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
                    @Override
            public void start(ClusterState initialState) {
                transportService = mockTransport.createTransportService(settings, threadPool, new TransportInterceptor() {
    }
                        mockIndicesService,
                    persistedStateRegistry,
    private StepListener<AcknowledgedResponse> createRepoAndIndexAndAlias(String repoName, String index, int shards, String alias) {
    private Environment createEnvironment(String nodeName) {
 * software distributed under the License is distributed on an
        final int documents = randomIntBetween(2, 100);
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
                    PutRepositoryAction.INSTANCE,
            createSnapshotResponse -> client().admin()
            }, exception -> { throw new AssertionError(exception); }));
            ) {
                final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                    new RemoteStoreStatsTrackerFactory(clusterService, settings),
import org.opensearch.test.OpenSearchTestCase;
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
                    } catch (IOException e) {
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {
        final StepListener<SearchResponse> searchResponseListener = new StepListener<>();
import org.opensearch.action.bulk.BulkResponse;
                        settings,
import org.opensearch.common.util.concurrent.AbstractRunnable;
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                        );
                actions.put(
                        actionFilters,
                            .filter(transport -> transport.getLocalNode().getAddress().equals(address))
import org.opensearch.action.admin.indices.mapping.put.AutoPutMappingAction;
                        .setWaitForCompletion(true)
                        transportService,
            createSnapshotResponseStepListener,
            private final SnapshotShardsService snapshotShardsService;
            createSnapshotResponseStepListener,
                .prepareCreateSnapshot(repoName, GetSnapshotsRequest.CURRENT_SNAPSHOT)
/*
        final List<String> snapshotNames = IntStream.range(1, randomIntBetween(2, 4))
                        threadPool,
                Stream.concat(ClusterModule.getNamedWriteables().stream(), NetworkModule.getNamedWriteables().stream())
            }
        continueOrDie(restoreSnapshotResponseListener, restoreSnapshotResponse -> {
        fail("Condition wasn't fulfilled.");
import org.opensearch.cluster.routing.BatchedRerouteService;
                        } else {
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
    public void testConcurrentSnapshotCreateAndDelete() {
                            .stream()
        );
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
import java.util.Comparator;
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
                    new CreateIndexRequest(index).waitForActiveShards(ActiveShardCount.ALL).settings(defaultIndexSettings(shards)),
                    settings,
                && clusterManagerNodeIds.size() == 1
                final MetadataDeleteIndexService metadataDeleteIndexService = new MetadataDeleteIndexService(
                .prepareCreateSnapshot(repoName, snapshotName)
import org.opensearch.cluster.routing.ShardRouting;
import static org.hamcrest.Matchers.contains;
                    .execute(createOtherSnapshotResponseStepListener)
import org.opensearch.index.mapper.MappingTransformerRegistry;
                .prepareDeleteSnapshot(repoName, snapshotName)
                    clusterManagerNode.clusterService.removeListener(this);
                    null
        final int inProgressSnapshots = randomIntBetween(1, 5);
                    }));
                final ClusterState oldState = this.clusterService.state();
                actions.put(
import org.opensearch.indices.ShardLimitValidator;
                            .isEmpty()
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
    }
                    responseCollectorService,
    private void scheduleSoon(Runnable runnable) {
            private final SnapshotsService snapshotsService;
                .cluster()
                .delete(new DeleteIndexRequest(index), new ActionListener<AcknowledgedResponse>() {
        final String alias = "test_alias";
            }
            .collect(Collectors.toList());
            final TestClusterNodes.TestClusterNode currentPrimaryNode = testClusterNodes.nodeById(shardToRelocate.currentNodeId());
                .prepareCreateSnapshot(repoName, snapshot)
                                .cluster()
            doneSnapshotting.set(true);
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;
                }
                        return newDataNode(nodeName);
                .custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)
        testClusterNodes.clearNetworkDisruptions();
        for (int i = 0; i < documents; ++i) {
                    client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).execute(deleteSnapshotStepListener);
    }
                                .prepareCreateSnapshot(repoName, snapshotName)
    private DeterministicTaskQueue deterministicTaskQueue;
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
        deterministicTaskQueue.runAllRunnableTasks();
        );
        continueOrDie(clusterStateResponseStepListener, clusterStateResponse -> {
                    new ClusterApplierService(node.getName(), settings, clusterSettings, threadPool) {
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseListener = new StepListener<>();
        final AdminClient clusterManagerAdminClient = clusterManagerNode.client.admin();
                    new MetadataIndexUpgradeService(
import org.opensearch.cluster.ClusterChangedEvent;
import org.opensearch.index.SegmentReplicationPressureService;
                                    )
import org.opensearch.action.bulk.TransportShardBulkAction;
            private final ClusterInfoService clusterInfoService;
                    .cluster()
                    new PeerRecoveryTargetService(threadPool, transportService, recoverySettings, clusterService),
import org.opensearch.common.settings.Settings;
    private void disconnectRandomDataNode() {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
                    allocationService
                final RestoreService restoreService = new RestoreService(
                    DefaultRemoteStoreSettings.INSTANCE,
                            .routingTable()
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
                );
                );
                nodeConnectionsService.stop();
                    clusterManagerService,
        final RepositoryData repositoryData = getRepositoryData(repository);
         * @return Cluster Manager Node
            }
    @Nullable
                        threadPool,
                            indicesService,
                    new TransportCleanupRepositoryAction(
        );
                    final DiscoveryNode node = testClusterNodes.nodes.get(nodeName).node;
        return res.actionGet();
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
                        @Override
        });
    }
        private final Set<String> disconnectedNodes = new HashSet<>();
    public void testSnapshotDeleteWithClusterManagerFailover() {
                        restoreService,
                        actionFilters,
                );
        String repoName = "repo";
import org.opensearch.index.analysis.AnalysisRegistry;
 * license agreements. See the NOTICE file distributed with
            final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
package org.opensearch.snapshots;
                                                otherNode.node.getName(),
                );
                        .filter(n -> n.node.isClusterManagerNode())
                    CreateSnapshotAction.INSTANCE,
                return;
            final AtomicBoolean cleanedUp = new AtomicBoolean(false);
        final StepListener<AcknowledgedResponse> deleteSnapshotStepListener = new StepListener<>();
        runUntil(exceptionVerified::get, TimeUnit.MINUTES.toMillis(5L));
                            environment,
                    restoreSnapshotResponseStepListener
 *    http://www.apache.org/licenses/LICENSE-2.0
            clearDisruptionsAndAwaitSync();
            );
    }
                    IndicesAliasesAction.INSTANCE,
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryAction;
                        }
            if (disconnectedClusterManager || randomBoolean()) {
            }).sorted(Comparator.comparing(n -> n.node.getName())).collect(Collectors.toList());
                            scheduleSoon(this);
        final boolean partialSnapshot = randomBoolean();
        assertTrue(res.isDone());
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
            .nodes(DiscoveryNodes.builder(state.nodes()).remove(node.getId()).add(node).localNodeId(node.getId()))
                    } catch (IOException e) {
                Settings settings,
        final AtomicBoolean snapshotDeleteResponded = new AtomicBoolean(false);
                .create(
        final int documentsSecondSnapshot = randomIntBetween(0, 100);
                .prepareDeleteSnapshot(repoName, snapshotName)
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    randomAlphaOfLength(10),
                    }
                List<SnapshotInfo> snapshotInfos = repoSnapshotResponse.getSnapshots();
        return Settings.builder()
                );
        }
        assertThat(repositoryData.getGenId(), is(1L));
        if (partialSnapshot) {
import org.opensearch.common.settings.ClusterSettings;
        );
        continueOrDie(searchResponseListener, r -> {
                DynamicActionRegistry dynamicActionRegistry = new DynamicActionRegistry();
                    settings,
import org.mockito.Mockito;
import org.opensearch.action.admin.cluster.reroute.TransportClusterRerouteAction;
        final TestClusterNodes.TestClusterNode randomClusterManager = testClusterNodes.randomClusterManagerNode()
                    clusterService,
                    null
import org.opensearch.indices.replication.SegmentReplicationSourceService;
        final StepListener<CreateSnapshotResponse> createOtherSnapshotResponseStepListener = new StepListener<>();
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
     **/
                assertNotNull("Snapshot list should not be null", repoSnapshotResponse.getSnapshots());
            testClusterNodes.nodes.values()
            assertTrue(clusterManager.node.isClusterManagerNode());
            );
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
                .setPartial(partial)
import org.opensearch.action.admin.indices.shards.TransportIndicesShardStoresAction;
        );
        );
 * compatible open source license.
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
import java.util.Arrays;
                .cluster()
                        threadPool,
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;
        continueOrDie(
            createAnotherSnapshotResponseStepListener,
                coordinator.start();
        final AtomicBoolean doneSnapshotting = new AtomicBoolean(false);
        repository.getRepositoryData(res);
                    repositoriesService,
                        new TaskResourceTrackingService(settings, clusterSettings, threadPool),
                    threadPool,
                        clusterService,
    private void runUntil(Supplier<Boolean> fulfilled, long timeout) {
        } else {
                // Snapshot can be partial because some tests leave indices in a red state because data nodes were stopped
            createRepoAndIndex(repoName, index, shards),
        if (randomBoolean()) {
        testClusterNodes.nodes.values().forEach(node -> when(node.getMockClusterInfoService().getClusterInfo()).thenReturn(clusterInfo));
                @Override
        assertFalse(deletionsInProgress.hasDeletionsInProgress());
            continueOrDie(
import org.opensearch.cluster.action.shard.ShardStateAction;
import java.io.IOException;
            assertNotNull(clusterManager);
                );
                    () -> repositoriesService,
                        mock(ShardStateAction.class),
import org.opensearch.action.search.SearchAction;
import org.opensearch.index.remote.RemoteStorePressureService;
                    if (n.node.getName().equals(nodeName)) {
                        emptyMap(),
                    Collections.emptyList(),
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
            assertEquals(shards, snapshotInfo.successfulShards());
                final ShardLimitValidator shardLimitValidator = new ShardLimitValidator(settings, clusterService, systemIndices);
                return true;
    }
            TransportGetSnapshotsAction transportGetSnapshotsAction = (TransportGetSnapshotsAction) getSnapshotsAction;
                            clusterService,
import org.opensearch.action.search.SearchRequest;
                nodeConnectionsService = createTestNodeConnectionsService(clusterService.getSettings(), threadPool, transportService);
            return clusterManager.clusterService.state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries().isEmpty();
        deterministicTaskQueue.advanceTime();
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
                    dynamicActionRegistry,
                .prepareCreateSnapshot(repoName, snapshotName)
            )
            // create a few more indices to make it more likely that the subsequent index delete operation happens before snapshot
    }
import org.opensearch.cluster.coordination.AbstractCoordinatorTestCase;
                        throw new AssertionError(e);
    public void testConcurrentSnapshotRestoreAndDeleteOther() {
                    )
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
import org.opensearch.search.fetch.FetchPhase;
            createSnapshotResponse -> client().admin().indices().delete(new DeleteIndexRequest(index), deleteIndexListener)
import org.opensearch.index.seqno.GlobalCheckpointSyncAction;
                        actionFilters,
                            ConcurrentSnapshotExecutionException.class,
                    null
                    transportService,
        final int shards = randomIntBetween(1, 10);
            if (randomBoolean()) {
                actions.put(
/*
            if (documents == 0) {
                snapshotNeverStarted.set(true);
    }
                        .verbose(false);
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
            assertThat(
        final StepListener<Collection<CreateIndexResponse>> createIndicesListener = new StepListener<>();
            final TestClusterNodes.TestClusterNode otherNode = testClusterNodes.randomDataNodeSafe(currentPrimaryNode.node.getName());
                    clusterService,
        );
                        mappingTransformerRegistry
                assertThat(snapshotInfo.state(), either(is(SnapshotState.SUCCESS)).or(is(SnapshotState.PARTIAL)));
            final long hitCount = r.getHits().getTotalHits().value();
        String repoName = "repo";
                .cluster()
        public Optional<TestClusterNode> randomDataNode(String... excludedNames) {
        final TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
                    Collections.emptyList(),
                indicesService = new IndicesService(
                    new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
                    @Override
                    new TransportIndicesShardStoresAction(
import org.opensearch.action.ActionModule.DynamicActionRegistry;
        String repoName = "repo";
                    CreateIndexAction.INSTANCE,
                    rerouteService,
                    new RemoteSegmentStoreDirectoryFactory(() -> repositoriesService, threadPool, ""),
                scheduleNow(() -> testClusterNodes.clearNetworkDisruptions());
                        );
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
                createSnapshotResponse -> assertEquals(createSnapshotResponse.getSnapshotInfo().state(), SnapshotState.SUCCESS)
                mappingUpdatedAction.setClient(client);
                    emptyMap(),
                        transportService,
                    ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(Settings.EMPTY)
                    ),
import org.opensearch.test.disruption.DisruptableMockTransport;
        assertNotNull(createAnotherSnapshotResponseStepListener.result());
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
                clusterManagerNode.restart();
            disconnectRandomDataNode();
                );
                        recoverySettings,
        String repoName = "repo";
            createOtherSnapshotResponseStepListener,
        public void stopNode(TestClusterNode node) {
        });
            public ClusterInfoService getMockClusterInfoService() {
        String repoName = "repo";
                        repositoriesService,
            assertThat(snapshotInfo.successfulShards(), either(is(indices + 1)).or(is(indices)));
                .execute(createOtherSnapshotResponseStepListener)
import org.apache.logging.log4j.LogManager;
            createRepoAndIndex(repoName, index, shards),
                    }
        final AtomicBoolean documentCountVerified = new AtomicBoolean();
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
        runUntil(() -> {
        final String index = "test";
                    TransportGetSnapshotsAction transportGetSnapshotsAction = (TransportGetSnapshotsAction) getSnapshotsAction;
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                    new SearchRequestOperationsCompositeListenerFactory();
        });
                for (final String nodeName : excludedNames) {
            createRepoAndIndex(repoName, index, shards),
                this.node = node;
 */
                    Collections.singletonMap(FsRepository.TYPE, getRepoFactory(environment)),
                final MetadataCreateIndexService metadataCreateIndexService = new MetadataCreateIndexService(
                );
        assertThat(snapshotIds, either(hasSize(1)).or(hasSize(0)));
    private void clearDisruptionsAndAwaitSync() {
            createRepoAndIndexAndAlias(repoName, index, shards, alias),
                        restoreSnapshotResponseListener
import org.opensearch.cluster.metadata.AliasValidator;
            final StepListener<CleanupRepositoryResponse> cleanupResponse = new StepListener<>();
        }
                repositoriesServiceReference.set(repositoriesService);
                );
                            actionFilters,
                        }
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;
                final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        metadataMappingService,
        final boolean partial = randomBoolean();
import org.opensearch.cluster.NodeConnectionsService;
                    .prepareCreateSnapshot(repoName, snapshotName)
                node.node.getId(),
        continueOrDie(deleteSnapshotStepListener, deleted -> {
                        .snapshots(snapshotsList)
                    new AnalysisRegistry(
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
import org.opensearch.action.support.ActionFilters;
            client().bulk(bulkRequest, bulkResponseStepListener);
                    AutoPutMappingAction.INSTANCE,
        final int shards = randomIntBetween(1, 10);
 * this work for additional information regarding copyright
                        if (nodes.containsKey(node.getName()) == false || nodes.containsKey(destination.getName()) == false) {
                .put(NODE_NAME_SETTING.getKey(), nodeName)
                nodes.remove(node.getName());
        });
            }
                );
 * under the License.
                    new TransportAutoPutMappingAction(
        continueOrDie(
                        indexNameExpressionResolver
            for (int i = 0; i < warmNodes; ++i) {
        );
            if (blobStoreContext != null) {
import org.opensearch.action.ActionType;
                    SegmentReplicationCheckpointPublisher.EMPTY,
import org.opensearch.node.ResponseCollectorService;
         */
                            clusterService,
import org.opensearch.action.support.WriteRequest;
                .cluster()
                        blobStoreContext,
            scheduleNow(() -> testClusterNodes.stopNode(currentPrimaryNode));
        assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
                .execute(createSnapshotResponseListener)
                    new AliasValidator(),
                    new PrimaryReplicaSyncer(
    }
    @Before
                    metadataDeleteIndexService,
                SearchPhaseController searchPhaseController = new SearchPhaseController(
        );
                .cluster()
        assertThat(snapshotIds, hasSize(snapshotNames.size()));
                        transportService,
            final AtomicBoolean initiatedSnapshot = new AtomicBoolean(false);
            final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
                final SnapshotInfo snapshotInfo = r.getSnapshotInfo();
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
                        .get("properties")).size()
            // failures seen during the previous test.
import org.opensearch.core.action.ActionListener;
                        threadPool,
        });
        continueOrDie(createRepoAndIndex(repoName, index, 1), createIndexResponse -> {
        );
                index,
     * {@code null} if not using the eventually consistent blobstore.
                    MergedSegmentPublisher.EMPTY,
                    random(),
        String repoName = "repo";
                    }
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
import org.opensearch.cluster.SnapshotDeletionsInProgress;
        });
            allSnapshotsListener,
            );
        assertThat(snapshotIds, hasSize(1));
        assertThat(snapshotIds, hasSize(1));
                assertThat(unwrapped.getMessage(), endsWith("Indices don't have primary shards [test]"));
        TestClusterNodes(int clusterManagerNodes, int dataNodes, int warmNodes) {
                .execute(createSnapshotResponseStepListener)
                    DefaultRemoteStoreSettings.INSTANCE,
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseStepListener = new StepListener<>();
import org.opensearch.search.pipeline.SearchPipelineService;
        final int shards = randomIntBetween(1, 10);
                    allocationService,
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
            Objects.requireNonNull(searchIndexResponseListener.result().getHits().getTotalHits()).value()
                        emptyMap(),
                        actionFilters,
                    clusterService,
        );
                assertThat(repoSnapshotResponse.getSnapshots(), hasSize(1));
        continueOrDie(
                .prepareCreateSnapshot(repoName, snapshotName)
                .indices()
        final StepListener<CreateSnapshotResponse> createSnapshotResponseListener = new StepListener<>();
        ClusterInfo clusterInfo = new ClusterInfo(Map.of(), Map.of(), Map.of(), Map.of(), Map.of(), nodeFileCacheStats, Map.of());
                )
                        clusterService,
import org.opensearch.ingest.SystemIngestPipelineCache;
                    client,
        assertThat(
                        return nodes.values()
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
                client().admin().cluster().prepareCreateSnapshot(repoName, "other-" + i).execute(createSnapshotListener);
                    shardStateAction,
                        clusterService,
                final SystemIndices systemIndices = new SystemIndices(emptyMap());
                    .collect(Collectors.toList())
            assertEquals(documents, bulkResponse.getItems().length);
                    emptyMap(),
                    bigArrays,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            }
        continueOrDie(
import org.opensearch.action.admin.cluster.snapshots.create.TransportCreateSnapshotAction;
    }
                // Index a few documents with different field names so we trigger a dynamic mapping update for each of them
                () -> client().admin()
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
                        client,
            final List<TestClusterNode> clusterManagerNodes = testClusterNodes.nodes.values()
        );
                final IndexMetadata indexMetadata = repository.getSnapshotIndexMetaData(
        public TestClusterNode currentClusterManager(ClusterState state) {
                createAnotherSnapshotResponseStepListener,
                .put(Environment.PATH_REPO_SETTING.getKey(), tempDir.resolve("repo").toAbsolutePath())
        assertEquals(shards, snapshotInfo.successfulShards());
            public void stop() {
                        throw new AssertionError(e);
        final StepListener<AcknowledgedResponse> createAliasListener = new StepListener<>();
            .custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotAction;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                        null
                        mock(ThreadPool.class)
                final TransportShardBulkAction transportShardBulkAction = new TransportShardBulkAction(
import java.util.Set;
            firstIndex.set(clusterManagerNode.clusterService.state().metadata().index(index).getIndex());
    public void testSearchableSnapshotOverSubscription() {
        final StepListener<Collection<CreateSnapshotResponse>> createOtherSnapshotResponseStepListener = new StepListener<>();
                return true;
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
                .map(
            disconnectedNodes.add(node.node.getName());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
            );
            final boolean disconnectedClusterManager = randomBoolean() && clusterManagerNodes > 1;
                    ),
    private MockEventuallyConsistentRepository.Context blobStoreContext;
            .build();
                return false;
                            throw new AssertionError("Delete index should always work during partial snapshots", e);
            createSnapshotResponse -> client().admin()
                            new AnalysisModule(environment, Collections.emptyList()).getAnalysisRegistry(),
                                }
import org.opensearch.indices.mapper.MapperRegistry;
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {
        );
                .cluster()
                    new ThreadContext(Settings.EMPTY)
            );
        String repoName = "repo";
        }).orElse(false), TimeUnit.MINUTES.toMillis(1L));
                Runnable::run
                        clusterService,
            createIndexResponse -> indexNDocuments(
                    ),
import org.opensearch.core.common.transport.TransportAddress;
            createIndexResponse -> client().admin()
                client().admin()
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
                    new TransportCreateSnapshotAction(
                    new CacheModule(new ArrayList<>(), settings).getCacheService(),
                    new NodeMappingRefreshAction(transportService, metadataMappingService),
                        threadPool,
                    }
                    DefaultRemoteStoreSettings.INSTANCE
                .cluster()
                )
                    try {
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
            continueOrDie(createSnapshotResponse, r -> {
                    new RestoreSnapshotRequest(repoName, snapshotName).renamePattern(index)
        testClusterNodes = new TestClusterNodes(clusterManagerNodes, dataNodes);
                .orElse(false),
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
            }
                    new TransportDeleteIndexAction(
import org.opensearch.common.cache.module.CacheModule;
        String repoName = "repo";
import org.opensearch.gateway.MetaStateService;
                        );
                    indicesService,
                // Make sure we snapshotted the metadata of this index and not the recreated version
                            return actualHandler;
                    TransportAction getSnapshotsAction = clusterManagerNode.actions.get(GetSnapshotsAction.INSTANCE);
                .stream()
        final StepListener<ClusterStateResponse> clusterStateResponseStepListener = new StepListener<>();
 *
                        clusterService,
                blobStoreContext.forceConsistent();
import org.opensearch.action.admin.cluster.state.TransportClusterStateAction;
        });
import org.opensearch.test.OpenSearchIntegTestCase;
            bulkRequest.add(new IndexRequest(index).source(Collections.singletonMap("foo", "bar" + i)));
                    return metadata -> new FsRepository(metadata, environment, xContentRegistry(), clusterService, recoverySettings) {
         */
                        return false;
import org.opensearch.action.index.IndexRequest;
                        threadPool,
                    })
                        ),
            private final AllocationService allocationService;
         * Builds a {@link DiscoveryNodes} instance that holds the nodes in this test cluster.
                SnapshotInfo snapshotInfo = snapshotInfos.get(0);
                        String executor,
import org.opensearch.action.admin.cluster.snapshots.get.TransportGetSnapshotsAction;
                    repositoriesServiceReference::get,
            afterIndexing.run();
                        indexNameExpressionResolver
    private RepositoryData getRepositoryData(Repository repository) {
                        xContentRegistry(),
                    clusterManagerAdminClient.cluster().state(new ClusterStateRequest(), updatedClusterStateResponseStepListener);
            );
        );
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                final Environment environment = createEnvironment(node.getName());
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
                    }
            BlobStoreTestUtil.assertConsistency(
        final RepositoryData repositoryData = getRepositoryData(repository);
        listener.whenComplete(onResponse, e -> { throw new AssertionError(e); });
        }
                        transportService,
        assertThat(snapshotIds, empty());
        }
                nodeEnv = new NodeEnvironment(settings, environment);
            createSnapshotResponse -> client().admin().indices().delete(new DeleteIndexRequest(index), deleteIndexListener)
                scheduleNow(this::disconnectOrRestartClusterManagerNode);
            if (fulfilled.get()) {
        }
                        mock(WorkloadGroupService.class)
        });
        } finally {
import org.opensearch.cluster.coordination.Coordinator;
                .build()
                        threadPool,
                        clusterService,
        testClusterNodes.nodes.values().forEach(testClusterNode -> testClusterNode.start(initialClusterState));
        deterministicTaskQueue.runAllRunnableTasks();
            assertEquals(shards, snapshotInfo.successfulShards());
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
            private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
 * Licensed to Elasticsearch under one or more contributor
            if (disconnectedNodes.contains(node.node.getName())) {
            createIndexResponse -> client().admin()
                    node.getName(),
            documentsFirstSnapshot + documentsSecondSnapshot,
            });
                } else {
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
                    IndexScopedSettings.BUILT_IN_INDEX_SETTINGS
            createRepoAndIndex(repoName, index, shards),
                assertEquals(0, snapshotInfo.failedShards());
            final List<TestClusterNode> dataNodes = testClusterNodes.nodes.values().stream().filter(n -> n.node.isDataNode()).filter(n -> {
            createRepoAndIndex(repoName, index, shards),
    }
            ignored -> client().admin()
            }
                        for (final DiscoveryNode discoveryNode : discoveryNodes) {
import org.opensearch.cluster.coordination.InMemoryPersistedState;
        testClusterNodes.nodes.values()
                            client().admin()
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
            scheduleNow(new Runnable() {
import org.opensearch.action.support.GroupedActionListener;
                    bulkRequest.add(new IndexRequest(index).source(Collections.singletonMap("foo", "bar" + i)));
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                        clusterService,
import org.opensearch.indices.SystemIndices;
        }
        );
                    )
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotAction;
            public NodeConnectionsService createTestNodeConnectionsService(
            createIndexResponse -> testClusterNodes.randomClusterManagerNodeSafe().client.admin()
                    clusterSettings,
        final int documents = randomIntBetween(1, 100);
                recoverySettings = new RecoverySettings(settings, clusterSettings);
        assertEquals(shards, snapshotInfo.successfulShards());
                for (int i = 0; i < documents; ++i) {
import org.opensearch.action.support.PlainActionFuture;
            final Collection<ClusterState> clusterStates = testClusterNodes.nodes.values()
                        new DestructiveOperations(settings, clusterSettings)
        }).orElse(false), TimeUnit.MINUTES.toMillis(1L));
                    null,
 * You may obtain a copy of the License at
                    restoreSnapshotResponseListener
            private final ClusterService clusterService;
                                null,
                actions.put(
                    new NoneCircuitBreakerService(),
                    shardLimitValidator,
        final int shards = randomIntBetween(1, 10);
            return;
        final TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
import org.opensearch.common.util.PageCacheRecycler;
        while (deterministicTaskQueue.getCurrentTimeMillis() < endTime) {
                return new NodeConnectionsService(settings, threadPool, transportService) {
            private final ThreadPool threadPool;
                        clusterService,
import org.junit.Before;
                    }
                    threadPool,
                            threadPool,
                node -> testClusterNodes.nodes.values()
            }
import static org.hamcrest.Matchers.either;
                        threadPool,
                );
        }
        continueOrDie(restoreSnapshotResponseStepListener, restoreSnapshotResponse -> {
        });
                            client().admin().indices().create(new CreateIndexRequest(index), noopListener());
                        NoopTracer.INSTANCE,
                            nodeEnv,
            } else {
                    )
            nodes.remove(node.node.getName());
        return TestEnvironment.newEnvironment(
                    @Override
                    mock(SearchService.class),
                        // just update targetsByNode to ensure disconnect runs for these nodes
                        searchPhaseController,
                coordinator = new Coordinator(
                        return newClusterManagerNode(nodeName);
                () -> client().admin()
    public void testConcurrentDeletes() {
                }
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
        );
                    afterIndexing.run();
        final String index = "test";
            for (int i = 0; i < dataNodes; ++i) {
        String snapshotName = "snapshot";
                        actionFilters,
                    }
                    )
        }
import java.util.function.Supplier;
        String repoName = "repo";
            } else {
                            });
     * Create a {@link Environment} with random path.home and path.repo
    @After
            .sorted(Comparator.comparing(n -> n.node.getName()))
                    clusterService,
                assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryAction;
        }
                            .includeAliases(true)
                    GetTermVersionAction.INSTANCE,
                        deleteListener.onResponse(false);
    public void testConcurrentSnapshotDeleteAndDeleteIndex() throws IOException {
import org.opensearch.indices.IndicesModule;
                if (event.state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries().isEmpty() == false) {
                        clusterService,
                            settings,
                .cluster()
                    )
    private static <T> void continueOrDie(StepListener<T> listener, CheckedConsumer<T, Exception> onResponse) {
            );
                        indexNameExpressionResolver,
                );
import org.opensearch.indices.replication.SegmentReplicationTargetService;
                scheduleNow(() -> testClusterNodes.clearNetworkDisruptions());
            deleteSnapshotStepListener,
            createSnapshotResponse -> indexNDocuments(
                return clusterInfoService;
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                .setWaitForCompletion(true)
        final Repository repository = randomClusterManager.repositoriesService.repository(repoName);
import org.opensearch.action.admin.cluster.snapshots.restore.TransportRestoreSnapshotAction;
    public void testTransportGetSnapshotsAction() {
            }
                    threadPool,
import org.opensearch.index.IndexingPressureService;
 */
        });
                .indices()
        final StepListener<SearchResponse> searchIndexResponseListener = new StepListener<>();
                        .cluster()
                    );
import java.util.Objects;
                                .setWaitForCompletion(true)
                    new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                        boolean forceExecution,
    }
        testClusterNodes.randomDataNode().ifPresent(n -> testClusterNodes.disconnectNode(n));
            private final RerouteService rerouteService;
                        threadPool,
                    settings,
        );
            createSnapshotResponseStepListener,
                    new NamedWriteableRegistry(Collections.emptyList())
                        indicesService,
                            scheduleNow(
            Throwable throwable = restoreSnapshotException;
                indicesService.start();
                new SearchRequest(restoredIndex).source(new SearchSourceBuilder().size(documents).trackTotalHits(true)),
