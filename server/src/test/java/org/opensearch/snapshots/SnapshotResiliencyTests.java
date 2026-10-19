                        assertThat(unwrapped, notNullValue());
                );
                    clusterService,
            }
        assertTrue(createdSnapshot.get());
                                protected void doRun() throws Exception {
            testClusterNodes.nodes.values().iterator().next().clusterService.state()  
            return randomDataNode(excludedNames).orElseThrow(() -> new AssertionError("Could not find another data node."));
                        mappingTransformerRegistry  
                        clusterService,
                    mock(RemoteStoreStatsTrackerFactory.class),
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
                    .execute(createOtherSnapshotResponseStepListener)
                    emptyMap(),
                .cluster()
                }  
                .execute(createSnapshotResponseListener);
        runUntil(() -> testClusterNodes.randomClusterManagerNode().map(clusterManager -> {
            assertEquals(documents, bulkResponse.getItems().length);
            }).sorted(Comparator.comparing(n -> n.node.getName())).collect(Collectors.toList());
                nodes.computeIfAbsent("data-node" + i, nodeName -> {
                return;
        deterministicTaskQueue.runAllRunnableTasks();  
        });
        testClusterNodes.nodes.values()
                bulkRequest.add(new IndexRequest(index).source(Collections.singletonMap("foo", "bar" + i)));  
            return dataNodes.isEmpty() ? Optional.empty() : Optional.ofNullable(randomFrom(dataNodes));  
        String snapshotName = "snapshot";
                actions.put(
            private final TransportService transportService;
 */
import org.opensearch.wlm.WorkloadGroupService;
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));  
                                .prepareCreateSnapshot(repoName, snapshotName)
                    new MergedSegmentWarmerFactory(null, null, null),  
            return randomClusterManagerNode().orElseThrow(
                client().admin()
                            clusterService,  
        }  
            createRepoAndIndex(repoName, index, shards),  
                            .custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY)
                        transportService,
            client().search(
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
                                            new AllocateEmptyPrimaryAllocationCommand(
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                        new TransportResyncReplicationAction(
            exceptionVerified.set(true);
        Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
                clusterInfoService = Mockito.mock(ClusterInfoService.class);  
        continueOrDie(
                    nodeName,
    }
                    CreateIndexAction.INSTANCE,
        assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
                    new ClusterApplierService(node.getName(), settings, clusterSettings, threadPool) {
                        threadPool,  
                });  
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                    new FileCacheStats(1, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
            assertEquals(shards, restoreSnapshotResponse.getRestoreInfo().totalShards());
            assertThat(
                    return metadata -> new FsRepository(metadata, environment, xContentRegistry(), clusterService, recoverySettings) {
    private void disconnectOrRestartClusterManagerNode() {
                    )
                    ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.get(Settings.EMPTY)
import org.opensearch.transport.client.AdminClient;
            }
        // We did one snapshot and one delete so we went two steps from the empty generation (-1) to 1  
                searchResponseStepListener
    }  
                        clusterService,
                        }
                    settings,
                            .findAny();  
                .stream()
                scheduleNow(this::disconnectOrRestartClusterManagerNode);
        final Repository repository = randomClusterManager.repositoriesService.repository(repoName);  
import org.opensearch.action.ActionModule.DynamicActionRegistry;
            documentCountVerified.set(true);
import org.opensearch.common.SetOnce;
                        actionFilters,
                .put(NODE_NAME_SETTING.getKey(), nodeName)  
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);  
            final AtomicBoolean cleanedUp = new AtomicBoolean(false);
            private Map<ActionType, TransportAction> actions = new HashMap<>();
        String snapshotName = "snapshot";
                    new CacheModule(new ArrayList<>(), settings).getCacheService(),
                client().bulk(
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), repoName, FsRepository.TYPE, settings, createRepositoryListener);  
                    ) {
                clusterManagerService.setClusterStatePublisher(coordinator);
        final AtomicBoolean createdSnapshot = new AtomicBoolean();  
                        String action,
import org.opensearch.cluster.service.ClusterApplierService;
                actions.put(
                doneIndexing.set(true);
        continueOrDie(
                actions.put(
        }
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseListener = new StepListener<>();  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                .setWaitForCompletion(true)  
            createIndexResponses -> client().admin()
            final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
        }
import org.opensearch.index.IndexingPressureService;  
                .stream()  
    }
        );  
                    null,
            public void start(ClusterState initialState) {  
                    new TransportDeleteSnapshotAction(  
                    clusterService,
                .setWaitForCompletion(waitForSnapshot)
            return newNode(nodeName, DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);  
                );  
import org.opensearch.search.query.QueryPhase;
                nodeConnectionsService = createTestNodeConnectionsService(clusterService.getSettings(), threadPool, transportService);
                    new AliasValidator(),  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    DefaultRemoteStoreSettings.INSTANCE,  
                    protected NamedWriteableRegistry writeableRegistry() {  
                        transportShardBulkAction,  
                        indexNameExpressionResolver,
            deleteIndexListener,
        testClusterNodes.randomClusterManagerNode().ifPresent(clusterManagerNode -> {
            createAnotherSnapshotResponseStepListener,
            client().admin()
        final List<TestClusterNodes.TestClusterNode> nodes = testClusterNodes.nodes.values()
            createSnapshotResponse -> client().admin()  
                final MetadataDeleteIndexService metadataDeleteIndexService = new MetadataDeleteIndexService(  
import static org.hamcrest.Matchers.containsInAnyOrder;
                                + NODE_SEARCH_CACHE_SIZE_SETTING.getKey()  
                .custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY)
            private final SnapshotShardsService snapshotShardsService;
                        nodes.put(node.getName(), restartedNode);
 * this file be licensed under the Apache-2.0 license or a
        }
import org.opensearch.cluster.action.index.MappingUpdatedAction;
                assertThat(repoSnapshotResponse.getSnapshots(), hasSize(1));  
        final boolean partialSnapshot = randomBoolean();  
                    }));
        });
            // Only disconnect cluster-manager if we have more than a single cluster-manager and can simulate a failover
                    if (n.node.getName().equals(nodeName)) {  
            @Override  
                    new PrimaryReplicaSyncer(  
                    @Override
                    new MetadataIndexUpgradeService(
                            settings,
                );  
            testClusterNodes.randomClusterManagerNodeSafe().client.admin()
                    CleanupRepositoryAction.INSTANCE,  
                        threadPool,
                        transportService,
                            nodeEnv,  
        if (nodes.isEmpty()) {  
                        mock(ThreadPool.class)  
                    })
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
                final SetOnce<RepositoriesService> repositoriesServiceReference = new SetOnce<>();
                    )  
        runUntil(() -> testClusterNodes.randomClusterManagerNode().map(clusterManager -> {
    private void runUntil(Supplier<Boolean> fulfilled, long timeout) {
                .cluster()
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));  
                .filter(n -> n.node.isClusterManagerNode())
            createSnapshotResponseListener,
                    .cluster()
                .filter(n -> disconnectedNodes.contains(n.node.getName()) == false)
                            SnapshotMissingException.class  
                // Index a few documents with different field names so we trigger a dynamic mapping update for each of them
                )
            final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);
            private final MappingTransformerRegistry mappingTransformerRegistry;
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.common.util.PageCacheRecycler;  
                documentsFirstSnapshot,
    private Environment createEnvironment(String nodeName) {  
import org.opensearch.cluster.SnapshotDeletionsInProgress;  
        assertThat(snapshotIds, hasSize(0));
                            transportService,
                coordinator.start();
                () -> client().admin()  
                    restoreSnapshotResponseStepListener
                    random(),
        final String index = "test";
        final StepListener<CreateSnapshotResponse> createOtherSnapshotResponseStepListener = new StepListener<>();
 * GitHub history for details.
                    threadPool,  
        continueOrDie(
        final int clusterManagerNodeCount = randomFrom(1, 3, 5);  
                });
                new AggregateFileCacheStats(  
                            : ConnectionStatus.CONNECTED;  
                    )  
                nodes.computeIfAbsent("warm-node" + i, nodeName -> {
                final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                        actionFilters,
                                node,
            scheduleNow(this::disconnectOrRestartClusterManagerNode);
                    new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),  
            continueOrDie(cleanupResponse, r -> cleanedUp.set(true));
        final StepListener<CreateSnapshotResponse> createAnotherSnapshotResponseStepListener = new StepListener<>();
            private final RerouteService rerouteService;
                .setPartial(partial)
    private void setupTestCluster(int clusterManagerNodes, int dataNodes) {
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
        final StepListener<AcknowledgedResponse> deleteSnapshotStepListener = new StepListener<>();  
                        actionFilters,
                    } catch (IOException e) {  
            final StepListener<CleanupRepositoryResponse> cleanupResponse = new StepListener<>();
        if (documents == 0) {
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {  
        return ClusterState.builder(state)
            .stream()
                searchResponseListener
                        if (node.equals(destination)) {  
                    () -> client().admin()  
import org.opensearch.action.admin.indices.create.CreateIndexAction;
        } else {
                        indicesService,
            .collect(Collectors.toList());  
        }, e -> {  
                .setWaitForCompletion(true)  
                }
                    ),
import org.opensearch.index.SegmentReplicationPressureService;
                for (int i = 0; i < documents; ++i) {
import org.opensearch.action.support.ActionFilters;
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {  
                            "Size of the indexes to be restored exceeds the file cache bounds. Increase the file cache capacity on the cluster nodes using "
                    threadPool,  
                    .cluster()
    private static <T> void continueOrDie(StepListener<T> listener, CheckedConsumer<T, Exception> onResponse) {  
                final ShardStateAction shardStateAction = new ShardStateAction(  
                                scheduleNow(() -> testClusterNodes.stopNode(clusterManagerNode));  
        final int shards = randomIntBetween(1, 10);
        SnapshotsInProgress finalSnapshotsInProgress = randomClusterManager.clusterService.state()
                threadPool = deterministicTaskQueue.getThreadPool(runnable -> CoordinatorTests.onNodeLog(node, runnable));  
    }
                        new TaskResourceTrackingService(settings, clusterSettings, threadPool),
                final SetOnce<RerouteService> rerouteServiceSetOnce = new SetOnce<>();
                    new TransportDeleteIndexAction(
        }  
                            actionFilters,
                        settings,
    }
                        }
                        new SearchPipelineService(  
        return createIndexResponseStepListener;
import org.opensearch.cluster.ClusterName;
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                );
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
                    .cluster()  
            return versions.size() == 1  
        );
                )
                        metadataCreateIndexService,  
                        clusterService,
                    emptyMap(),
                SnapshotInfo snapshotInfo = snapshotInfos.get(0);
                .prepareCreateSnapshot(repoName, snapshot)
            if (disconnectedClusterManager || randomBoolean()) {
                    node.getName(),
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
                        mapperRegistry,
            createSnapshotResponse -> indexNDocuments(
                        indexNameExpressionResolver,  
                    threadPool
        final RepositoryData repositoryData = getRepositoryData(repository);
            clearDisruptionsAndAwaitSync();
        );  
        final int shards = randomIntBetween(1, 10);
                        namedXContentRegistry,  
        continueOrDie(searchResponseStepListener, r -> {
                        emptyMap(),
                remoteStoreNodeService = new RemoteStoreNodeService(new SetOnce<>(repositoriesService)::get, threadPool);
                        null
                );  
                            threadPool,
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
                .stream()
        for (StepListener<Boolean> deleteListener : deleteSnapshotStepListeners) {
                final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();
            disconnectRandomDataNode();
            }  
                            indicesService,  
                )
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.plugins.PluginsService;
        }
import org.opensearch.gateway.MetaStateService;
                    threadPool,
            // create a few more indices to make it more likely that the subsequent index delete operation happens before snapshot
                        transportService,  
                        threadPool,
                        return nodes.values()
                        threadPool,
            for (int i = 0; i < documents; ++i) {  
import org.opensearch.monitor.StatusInfo;
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        assertThat(
        );
                        n -> n.transportService.connectToNode(
        final StepListener<AcknowledgedResponse> createRepositoryListener = new StepListener<>();  
        final boolean partial = randomBoolean();
                            clusterService,
                    new SegmentReplicationPressureService(  
                    bulkRequest.add(new IndexRequest(index).source(Collections.singletonMap("foo", "bar" + i)));
            public void stop() {  
            Settings.builder()
            }  
        final StepListener<AcknowledgedResponse> deleteIndexListener = new StepListener<>();
                        indexNameExpressionResolver,
                        NoopTracer.INSTANCE
                final MetadataMappingService metadataMappingService = new MetadataMappingService(clusterService, indicesService);
                    )
                        actionFilters,
            }  
import org.apache.logging.log4j.LogManager;
        String repoName = "repo";
        assertThat(snapshotInfo.indices(), containsInAnyOrder(index));  
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
        String repoName = "repo";
        deterministicTaskQueue.runAllRunnableTasks();
            createRepoAndIndex(repoName, index, shards),  
                    shardStateAction,  
        deterministicTaskQueue.runAllRunnableTasks();  
        });
        final List<String> snapshotNames = IntStream.range(1, randomIntBetween(2, 4))
        runUntil(() -> {
         * @param state ClusterState
        assertThat(snapshotIds, empty());
                .cluster()
        final TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
            });
        public void clearNetworkDisruptions() {
                );  
                        @Override
                        repositoriesService,
                        .storageType(RestoreSnapshotRequest.StorageType.REMOTE_SNAPSHOT),  
                        transportService,  
        final String index = "index-1";
        continueOrDie(
     * Simulates concurrent restarts of data and cluster-manager nodes as well as relocating a primary shard, while starting and subsequently
                    new TransportIndicesShardStoresAction(  
        String repoName = "repo";  
        final AtomicBoolean documentCountVerified = new AtomicBoolean();
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();  
                Settings settings,  
                        actionFilters,
                    )
                    hostsResolver -> nodes.values()  
        });
                        actionFilters,
        );  
                .map(DiscoveryNode::getId)
                    }
                .collect(Collectors.toList());
        deterministicTaskQueue.runAllRunnableTasks();  
                recoverySettings = new RecoverySettings(settings, clusterSettings);
                .execute(createAnotherSnapshotResponseStepListener);
        final TestClusterNodes.TestClusterNode randomClusterManager = testClusterNodes.randomClusterManagerNode()  
                            });  
                    afterIndexing.run();  
        }  
            nodeFileCacheStats.put(
                    repositoriesService,
                        return newClusterManagerNode(nodeName);
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
                client().bulk(bulkRequest, bulkResponseStepListener);
            acknowledgedResponse -> client().admin()  
            .build();
            assertEquals(shards, restoreSnapshotResponse.getRestoreInfo().totalShards());
                                () -> testClusterNodes.randomClusterManagerNodeSafe().client.admin()  
        return TestEnvironment.newEnvironment(
                        .stream()
import org.opensearch.cluster.coordination.CoordinatorTests;
                    shardLimitValidator,
import org.opensearch.env.TestEnvironment;  
                    clusterService,
                final IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(  
                    GetSnapshotsRequest repoSnapshotRequest = new GetSnapshotsRequest().repository(repoName)
                        .execute(snapshotListener)
        );
                .aliases(  
                        new TransportNodesListGatewayStartedShards(  
            TransportGetSnapshotsAction transportGetSnapshotsAction = (TransportGetSnapshotsAction) getSnapshotsAction;
                        mock(ShardStateAction.class),
                    clusterService,  
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
            }
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
        SnapshotsInProgress finalSnapshotsInProgress = randomClusterManager.clusterService.state().custom(SnapshotsInProgress.TYPE);
            if (blobStoreContext != null) {  
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));  
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));  
import org.opensearch.cluster.service.ClusterService;
                    GetSnapshotsAction.INSTANCE,
                .setWaitForCompletion(true)
        final TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(  
                mockTransport = new DisruptableMockTransport(node, logger, deterministicTaskQueue) {  
                        if (partialSnapshot) {
                    createAliasListener
                    .prepareCreateSnapshot(repoName, snapshotName)  
                } else {
            assertNotNull(clusterManager);
            public ClusterInfoService getMockClusterInfoService() {
            return;  
        final StepListener<AcknowledgedResponse> deleteIndexListener = new StepListener<>();
import org.opensearch.script.ScriptService;  
                    SearchExecutionStatsCollector.makeWrapper(responseCollectorService)
                final MappingUpdatedAction mappingUpdatedAction = new MappingUpdatedAction(settings, clusterSettings, clusterService);  
        public void stopNode(TestClusterNode node) {
                        throw new AssertionError(e);  
                        mappingTransformerRegistry
                    new AwarenessReplicaBalance(Settings.EMPTY, clusterService.getClusterSettings()),
                    settings,  
            final StepListener<CreateSnapshotResponse> createSnapshotResponse = new StepListener<>();
                        actionFilters,
                                .setWaitForCompletion(true)
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    }
                .build()
        final int documents = randomIntBetween(0, 100);
            final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
                            .primaryShard();  
                    }
                    )
                    transportService,  
        stabilize();
                                @Override  
            );  
                    .setWaitForCompletion(true)
 * Unless required by applicable law or agreed to in writing,
                    });
                // Snapshot can be partial because some tests leave indices in a red state because data nodes were stopped
            assertEquals(0, snapshotInfo.failedShards());
            createOtherSnapshotResponseStepListener,  
        deterministicTaskQueue = new DeterministicTaskQueue(Settings.builder().put(NODE_NAME_SETTING.getKey(), "shared").build(), random());
        testClusterNodes.clearNetworkDisruptions();
                    DefaultRemoteStoreSettings.INSTANCE
import org.opensearch.common.util.concurrent.AbstractRunnable;
                .prepareCreateSnapshot(repoName, snapshotName)
                                        ),
    private static <T> ActionListener<T> noopListener() {
                .cluster()
import org.opensearch.action.admin.indices.delete.TransportDeleteIndexAction;
                        new IndexingPressureService(settings, clusterService),
        });  
            }  
                        actionFilters,  
                        clusterService,
                () -> client().admin()
                    new GlobalCheckpointSyncAction(  
                    systemIndices,  
            private final IndicesClusterStateService indicesClusterStateService;  
            createSnapshotResponse -> assertEquals(createSnapshotResponse.getSnapshotInfo().state(), SnapshotState.SUCCESS)  
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
                );
        );  
                        final Throwable unwrapped = ExceptionsHelper.unwrap(  
                snapshotNeverStarted.set(true);
                    )
                    repositoryData.resolveIndexId(index)
                    threadPool,
    }
                        emptyMap(),  
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
import org.opensearch.common.settings.IndexScopedSettings;  
                .create(
            assertThat(snapshotInfo.successfulShards(), either(is(indices + 1)).or(is(indices)));  
                index,  
                            .routingTable()
    }  
                .cluster()
                    indicesService,
import java.nio.file.Path;  
import org.opensearch.action.admin.indices.mapping.put.TransportAutoPutMappingAction;
                    indicesService,
                () -> client().admin()
        public Optional<TestClusterNode> randomDataNode(String... excludedNames) {
        continueOrDie(
                    @Override
        String repoName = "repo";
            createSnapshotResponse -> client().admin()
        assertThat(snapshotIds, hasSize(1));  
                );
                }
                                .cluster()  
import org.opensearch.transport.TransportException;  
        }
                    settings,  
        deterministicTaskQueue.runAllRunnableTasks();
        Settings.Builder settings = Settings.builder().put("location", randomAlphaOfLength(10));
                        actionFilters,
                            )
                        blobStoreContext,
                client.initialize(  
            documentsFirstSnapshot + documentsSecondSnapshot,
        deterministicTaskQueue.runAllRunnableTasks();  
                    new NoneCircuitBreakerService(),  
                List<SnapshotInfo> snapshotInfos = repoSnapshotResponse.getSnapshots();
                allocationService = OpenSearchAllocationTestCase.createAllocationService(settings, snapshotsInfoService);
        assertThat(finalSnapshotsInProgress.entries(), empty());
                final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();  
                        ),
            createSnapshotResponseStepListener,
            TestClusterNode(DiscoveryNode node) throws IOException {  
            if (snapshotNeverStarted.get()) {  
                stop();  
import org.opensearch.transport.TransportInterceptor;
                final BigArrays bigArrays = new BigArrays(new PageCacheRecycler(settings), null, "test");  
                            client().admin().indices().create(new CreateIndexRequest(index), noopListener());
            private Coordinator coordinator;
                .prepareCreateSnapshot(repoName, snapshotName)
import org.opensearch.index.remote.RemoteStorePressureService;  
            final TestClusterNodes.TestClusterNode otherNode = testClusterNodes.randomDataNodeSafe(currentPrimaryNode.node.getName());
                );
                .indices()
import org.opensearch.Version;
                    clusterService.getClusterApplierService(),
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotAction;  
                        .verbose(false);
                        .snapshots(snapshotsList)  
        /**  
                .cluster()
                    new AnalysisRegistry(  
                        actionFilters,  
        String repoName = "repo";
    @After
                        return false;
        continueOrDie(
                    new TransportBulkAction(
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));  
                    nodeEnv,
                    SegmentReplicationCheckpointPublisher.EMPTY,
        final int shards = randomIntBetween(1, 10);  
                    actionFilters,  
                .entries(),
                }
                    MergedSegmentPublisher.EMPTY,
                    snapshotInfo.snapshotId(),
        final AtomicBoolean exceptionVerified = new AtomicBoolean();
                new SearchRequest("restored_alias_" + alias).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
                final PersistedStateRegistry persistedStateRegistry = persistedStateRegistry();
                    repositoriesService,
                        clusterService  
            );
                documentsSecondSnapshot,
import org.opensearch.common.settings.ClusterSettings;
                            transportService,
                        transportService,
            private final NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(  
            testClusterNodes.nodes.values()  
                    ),
    }
                };  
            private final ClusterInfoService clusterInfoService;  
                clusterService.getClusterApplierService().setNodeConnectionsService(nodeConnectionsService);  
import org.opensearch.action.RequestValidators;
            testClusterNodes.randomDataNodeSafe().clusterService.state()  
            testClusterNodes.nodes.values().iterator().next().clusterService.state()  
                continueOrDie(bulkResponseStepListener, bulkResponse -> {  
                    new TransportCleanupRepositoryAction(
        final int dataNodes = randomIntBetween(2, 10);  
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));  
        }, TimeUnit.MINUTES.toMillis(1L));
            continueOrDie(deleteListener, deleted -> {  
            createIndexResponse -> client().admin()  
                .prepareCreateSnapshot(repoName, snapshotName)  
        continueOrDie(
            DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
                continueOrDie(bulkResponseStepListener, bulkResponse -> {
        assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
        final int shards = randomIntBetween(1, 10);
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
                    threadPool,  
                nodeEnv = new NodeEnvironment(settings, environment);
        final TestClusterNodes.TestClusterNode randomClusterManager = testClusterNodes.randomClusterManagerNode()
            } else {
    public void testTransportGetSnapshotsAction() {
     * {@code null} if not using the eventually consistent blobstore.  
                });
                        metadataIndexAliasesService,  
                    new IndexingPressureService(settings, clusterService),
            createRepoAndIndex(repoName, index, shards),  
        while (timeout > deterministicTaskQueue.getCurrentTimeMillis() - start) {  
import org.opensearch.transport.RemoteTransportException;
                nodes.computeIfAbsent("node" + i, nodeName -> {
                )
                    .collect(Collectors.toList())
                    transportService,  
import org.opensearch.action.admin.cluster.snapshots.create.TransportCreateSnapshotAction;
                            Collections.emptyList(),  
        continueOrDie(restoreSnapshotResponseListener, restoreSnapshotResponse -> {  
            BlobStoreTestUtil.assertConsistency(  
                TransportService transportService
    /**  
                            this.targetsByNode.put(discoveryNode, createConnectionTarget(discoveryNode));
            public void restart() {  
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
                when(mockIndicesService.getSearchResponseStatusStats()).thenReturn(new SearchResponseStatusStats());  
import org.opensearch.index.seqno.GlobalCheckpointSyncAction;
                    bigArrays,
                SearchPhaseController searchPhaseController = new SearchPhaseController(
                            environment,  
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
        deterministicTaskQueue.scheduleNow(runnable);
    }  
                    bigArrays,  
        setupTestCluster(clusterManagerNodes, dataNodes);
                client().bulk(bulkRequest, bulkResponseStepListener);
                    repositoriesService,
                        snapshotsService,
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
                SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory =
        assertNotNull(createAnotherSnapshotResponseStepListener.result());  
        public TestClusterNode currentClusterManager(ClusterState state) {
            }
import org.opensearch.action.update.UpdateHelper;
                    clusterService,  
        );
        }).orElse(false), TimeUnit.MINUTES.toMillis(1L));  
                return;
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
                actions.put(
import org.opensearch.indices.recovery.RecoverySettings;
                    searchService::aggReduceContextBuilder  
                transportService = mockTransport.createTransportService(settings, threadPool, new TransportInterceptor() {
        );
                        boolean forceExecution,  
                    }
                    new TransportIndicesAliasesAction(
        Collection<SnapshotId> snapshotIds = repositoryData.getSnapshotIds();
                .put(Environment.PATH_REPO_SETTING.getKey(), tempDir.resolve("repo").toAbsolutePath())
                        transportService,
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                        final TestClusterNode restartedNode = new TestClusterNode(
    public void testConcurrentSnapshotRestoreAndDeleteOther() {
                .restoreSnapshot(
        String snapshotName = "snapshot";
    }
            createRepoAndIndex(repoName, index, shards),  
            final AtomicBoolean initiatedSnapshot = new AtomicBoolean(false);
            private final SnapshotsService snapshotsService;  
                actions.put(  
                        clusterService,
                    metadataDeleteIndexService,  
import java.util.LinkedHashMap;
        final AtomicBoolean snapshotNeverStarted = new AtomicBoolean(false);
        }).orElse(false), TimeUnit.MINUTES.toMillis(1L));
        assertTrue(res.isDone());
                        indexNameExpressionResolver,
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                        new SystemIndices(emptyMap()),
        final StepListener<Collection<CreateSnapshotResponse>> allSnapshotsListener = new StepListener<>();  
                    new ThreadContext(Settings.EMPTY)
import java.util.HashMap;  
                    transportService,
                assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());  
        deterministicTaskQueue.runAllRunnableTasks();
            continueOrDie(  
                    new TransportGetTermVersionAction(  
                            List.of(),
                });  
        final int shards = randomIntBetween(1, 10);
                        new RestoreSnapshotRequest(repoName, secondSnapshotName).waitForCompletion(true)  
            private final RecoverySettings recoverySettings;  
                            return (request, channel, task) -> scheduleSoon(new AbstractRunnable() {
                "Documents were restored but the restored index mapping was older than some documents and misses some of their fields",
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
    private Path tempDir;
        });
            acknowledgedResponse -> client().admin()
                actions.put(  
    }
                .setPartial(true)  
            firstIndex.set(clusterManagerNode.clusterService.state().metadata().index(index).getIndex());
                        actionFilters,
            createIndexResponse -> client().admin().cluster().state(new ClusterStateRequest(), clusterStateResponseStepListener)
            assertThat(snapshotInfo.indices(), containsInAnyOrder(index));  
        TestClusterNodes(int clusterManagerNodes, int dataNodes) {
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
        final boolean waitForSnapshot = randomBoolean();  
import org.opensearch.cluster.ClusterChangedEvent;
                                null,  
                    RestoreSnapshotAction.INSTANCE,
                        indexNameExpressionResolver
                    .restoreSnapshot(
                    @Override  
        });  
                    null
                    DefaultRemoteStoreSettings.INSTANCE,
                    DeleteSnapshotAction.INSTANCE,
                    GetTermVersionAction.INSTANCE,
                        ),  
                    new CreateIndexRequest(index).waitForActiveShards(ActiveShardCount.ALL).settings(defaultIndexSettings(shards)),  
                                        noopListener()
                    Collections.emptyList(),  
                    @Override
                    clusterManagerService,  
            createIndexResponse -> indexNDocuments(
        ClusterInfo clusterInfo = new ClusterInfo(Map.of(), Map.of(), Map.of(), Map.of(), Map.of(), nodeFileCacheStats, Map.of());  
                            .map(cn -> cn.mockTransport)
                    shardLimitValidator,  
                .indices()
            () -> testClusterNodes.randomClusterManagerNode()  
                    null  
                    };
import org.opensearch.cluster.ClusterStateListener;  
        );
            empty()  
        }  
            client().search(  
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
import java.util.Arrays;
import org.opensearch.action.admin.cluster.repositories.put.TransportPutRepositoryAction;
                        .setWaitForCompletion(true)  
                scheduleNow(
                        indexNameExpressionResolver  
import java.util.concurrent.atomic.AtomicBoolean;  
            );  
                        .cluster()
        );  
import org.opensearch.action.search.SearchExecutionStatsCollector;  
                .cluster()  
                .cluster()
                        clusterService,
                snapshotShardsService = new SnapshotShardsService(
            createSnapshotResponse -> client().admin()
        final int shards = randomIntBetween(1, 10);
                );  
import org.opensearch.common.network.NetworkModule;
                                                otherNode.node.getName(),
    @Nullable
                .prepareCreateSnapshot(repoName, snapshotName)  
                                .cluster()  
                final MapperRegistry mapperRegistry = new IndicesModule(Collections.emptyList()).getMapperRegistry();
                .filter(DiscoveryNode::isClusterManagerNode)  
                    bulkRequest.add(new IndexRequest(index).source(Collections.singletonMap("foo", "bar" + i)));
                        ),
                final SearchService searchService = new SearchService(  
        final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            final Runnable afterIndexing = () -> client().admin()
                            threadPool,
        );
                            testClusterNodes.randomDataNodeSafe().client.admin()
            }  
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {  
                    threadPool,
        final String index = "test";
import org.opensearch.action.admin.cluster.repositories.cleanup.TransportCleanupRepositoryAction;  
            return new TestClusterNode(  
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseListener = new StepListener<>();
import static org.mockito.Mockito.mock;
                        actionFilters,
                .map(clusterState -> clusterState.nodes().getClusterManagerNodeId())
                        repositoriesService,  
            .forEach(
                                        .cluster()
                    new TransportGetSnapshotsAction(
                assertNotNull(unwrapped);  
                            .includeAliases(true)
        final long start = deterministicTaskQueue.getCurrentTimeMillis();
                    .cluster()
                );
         * @return Cluster Manager Node  
            private final ThreadPool threadPool;
            if (snapshotInfo.successfulShards() == indices + 1) {
                            .renameAliasReplacement("restored_alias_$1"),
        testClusterNodes.nodes.values()  
import static org.mockito.Mockito.when;  
        assertNotNull(restoreSnapshotResponseListener.result());
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.search.SearchPhaseController;
                    new RestoreSnapshotRequest(repoName, snapshotName).renamePattern(index)
import org.junit.Before;  
                DynamicActionRegistry dynamicActionRegistry = new DynamicActionRegistry();
                    }
                    ClusterStateAction.INSTANCE,  
         * Builds a {@link DiscoveryNodes} instance that holds the nodes in this test cluster.  
                                @Override
                )  
import org.opensearch.env.Environment;
            createRepoAndIndex(repoName, index, shards),  
                actions.put(
            if (createdSnapshot.get() == false) {
        } else {  
                        metadataMappingService,
        testClusterNodes = new TestClusterNodes(clusterManagerNodes, dataNodes);
                    repositoriesServiceReference::get,
        clusterManagerNode.clusterService.addListener(new ClusterStateListener() {
                });
                    false,
                this.node = node;
            return clusterManager.clusterService.state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries().isEmpty();
import org.opensearch.repositories.Repository;
            continueOrDie(createSnapshotResponse, r -> {
                    new TransportCreateSnapshotAction(  
                    environment,
                        clusterService,  
                    settings,
                    stateForNode(initialState, node)
        continueOrDie(
            final Runnable afterIndexing = () -> client().admin()  
                            ? ConnectionStatus.DISCONNECTED
                .execute(createSnapshotResponseStepListener)
                .execute(createAnotherSnapshotResponseStepListener)
                        recoverySettings,
                    .execute(ActionListener.wrap(resp -> deleteListener.onResponse(true), e -> {
                        }  
                    )
                .prepareCreateSnapshot(repoName, snapshotName)
            for (int i = 0; i < documents; ++i) {
                        }
import org.opensearch.index.mapper.MappingTransformerRegistry;
                            // Recreate index by the same name to test that we don't snapshot conflicting metadata in this scenario  
        }
            return clusterManager;  
                        mockIndicesService,  
        }
        final String[] snapshotsList = { "snapshot-1" };  
            TimeUnit.MINUTES.toMillis(1L)  
                        return newDataNode(nodeName);
                        throw new AssertionError(e);
                    new SegmentReplicationTargetService(  
            deleteIndexListener,
        } else {
                    )
import org.opensearch.ExceptionsHelper;  
                    )  
            assertThat(snapshotInfo.state(), either(is(SnapshotState.SUCCESS)).or(is(SnapshotState.PARTIAL)));
                )
         * @return DiscoveryNodes
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            final SnapshotsInProgress snapshotsInProgress = clusterManager.clusterService.state().custom(SnapshotsInProgress.TYPE);  
                    )  
                .prepareCreateSnapshot(repoName, snapshotName)  
                final Settings settings = environment.settings();
                    settings,
        );
                );
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
import org.opensearch.transport.client.node.NodeClient;  
                            return ConnectionStatus.CONNECTED;
            createIndicesListener,  
        String repoName = "repo";
    }  
                    clusterManagerNode.clusterService.removeListener(this);
        }
        assertThat(snapshotIds, hasSize(1));
                final SearchTransportService searchTransportService = new SearchTransportService(
                    BulkAction.INSTANCE,
        continueOrDie(allSnapshotsListener, createSnapshotResponses -> {  
                        clusterService,
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();  
                            environment,  
                        && clusterManager.clusterService.state()  
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());  
                    actionFilters,
import org.opensearch.action.index.IndexRequest;  
                );
                );  
                        if (initiatedSnapshot.compareAndSet(false, true)) {
                final SnapshotException unwrapped = (SnapshotException) ExceptionsHelper.unwrap(e, SnapshotException.class);
                                    channel.sendResponse(new TransportException(new IOException("failed to recover shard")));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                    transportService,
        final int shards = randomIntBetween(1, 5);
            assertThat(snapshotInfo.indices(), containsInAnyOrder(index));  
                    allocationService,  
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
         */
import org.opensearch.action.admin.cluster.snapshots.restore.TransportRestoreSnapshotAction;  
                                            )  
                    continueOrDie(updatedClusterStateResponseStepListener, updatedClusterState -> {
                mappingUpdatedAction.setClient(client);
                    null,
    }
            transportGetSnapshotsAction.execute(null, repoSnapshotRequest, ActionListener.wrap(repoSnapshotResponse -> {
        final String index = "test";  
                        new SystemIndices(emptyMap()),  
                searchAliasResponseListener  
                final IndexMetadata indexMetadata = repository.getSnapshotIndexMetaData(
        final int documentsSecondSnapshot = randomIntBetween(0, 100);  
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;  
                .execute(createSnapshotResponseStepListener)
            return newNode(nodeName, DiscoveryNodeRole.DATA_ROLE);
        );  
import java.util.Collection;  
                .prepareDeleteSnapshot(repoName, snapshotName)  
            .filter(n -> testClusterNodes.disconnectedNodes.contains(n.node.getName()) == false)  
            afterIndexing.run();
    public void testSuccessfulSnapshotAndRestore() {  
                .cluster()
                scheduleNow(this::disconnectOrRestartDataNode);  
                final ClusterState oldState = this.clusterService.state();
                );
                        new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
            }  
                            .renameReplacement("restored_$1")  
        assertThat(snapshotIds, hasSize(1));
                        emptyMap(),
        String repoName = "repo";  
            );
                    clusterService,
                    clusterService.getClusterSettings(),  
                    .prepareDeleteSnapshot(repoName, snapshotName)
                client().admin().cluster().cleanupRepository(new CleanupRepositoryRequest("repo"), cleanupResponse);
import org.opensearch.common.Nullable;
                            null,  
                .put(MappingUpdatedAction.INDICES_MAX_IN_FLIGHT_UPDATES_SETTING.getKey(), 1000) // o.w. some tests might block
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                        .forEach(  
            testClusterNodes.randomDataNode().ifPresent(TestClusterNodes.TestClusterNode::restart);  
        runUntil(
/*  
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
            createSnapshotResponseStepListener,  
        } finally {
            return newNode(nodeName, DiscoveryNodeRole.WARM_ROLE);
        final StepListener<SearchResponse> searchIndexResponseListener = new StepListener<>();
                    settings,  
import org.opensearch.common.settings.Settings;
                .prepareCreateSnapshot(repoName, snapshotName)  
    private static ClusterState stateForNode(ClusterState state, DiscoveryNode node) {  
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();  
            } else {
                    new SystemIndices(emptyMap()),  
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.bulk.TransportShardBulkAction;
                assertThat(unwrapped.getMessage(), endsWith("Indices don't have primary shards [test]"));
        assertEquals(0, snapshotInfo.failedShards());
        final StepListener<ClusterStateResponse> clusterStateResponseStepListener = new StepListener<>();  
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                                }));
    private void clearDisruptionsAndAwaitSync() {  
            documentsFirstSnapshot + documentsSecondSnapshot,
                        assertThat(repoSnapshotResponse.getSnapshots(), hasSize(snapshotsList.length));  
        final int clusterManagerNodes = randomFrom(1, 3, 5);
        continueOrDie(createSnapshotResponseStepListener, createSnapshotResponse -> {
                        // Check if both nodes are still part of the cluster  
            } catch (SnapshotRestoreException ignored) {}
                    node.getName(),
            final ShardRouting shardToRelocate = clusterStateResponse.getState().routingTable().allShards(index).get(0);
                    clusterService,
        final int shards = randomIntBetween(1, 10);
        }
                Stream.concat(ClusterModule.getNamedWriteables().stream(), NetworkModule.getNamedWriteables().stream())
        }  
                return true;
            assertEquals(shards, snapshotInfo.successfulShards());  
                            client().admin()
                testClusterNodes.disconnectNode(this);
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
        final StepListener<CreateSnapshotResponse> createAnotherSnapshotResponseStepListener = new StepListener<>();  
            createRepoAndIndex(repoName, index, shards),
                    public void onResponse(AcknowledgedResponse acknowledgedResponse) {
            scheduleNow(() -> client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).execute(deleteSnapshotStepListener));
            .mapToObj(i -> "snapshot-" + i)
        final StepListener<AcknowledgedResponse> deleteSnapshotStepListener = new StepListener<>();  
        continueOrDie(createSnapshotResponseStepListener, createSnapshotResponse -> {  
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);  
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
import java.util.Collections;
                    null,
                        emptyMap(),  
            Objects.requireNonNull(searchIndexResponseListener.result().getHits().getTotalHits()).value()
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
                    indexNameExpressionResolver,  
    public void testConcurrentSnapshotCreateAndDeleteOther() {
                assertEquals(indexMetadata.getIndex(), firstIndex.get());
                .cluster()
        return res.actionGet();
import org.opensearch.cluster.coordination.PersistedStateRegistry;  
                        emptyMap(),
                        emptyMap()
                    } catch (IOException e) {
                if (deleted) {
    public void verifyReposThenStopServices() {  
        assertThat(deleteSnapshotStepListener.result().isAcknowledged(), is(true));
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;  
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
         */
        continueOrDie(deleteSnapshotStepListener, deleted -> {  
            }
                );  
                    }
package org.opensearch.snapshots;
                        protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {  
                    new PeerRecoveryTargetService(threadPool, transportService, recoverySettings, clusterService),
                        clusterService,
        assertNotNull(createSnapshotResponseStepListener.result());
            for (int i = 0; i < randomIntBetween(0, dataNodes); ++i) {
    }
import static java.util.Collections.emptySet;
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                indicesClusterStateService.close();
import org.opensearch.search.builder.SearchSourceBuilder;
            private final IndicesService indicesService;
import org.opensearch.indices.IndicesModule;
            .collect(Collectors.toList());
                            ActionTestUtils.assertNoFailureListener(c -> logger.info("--> Connected [{}] to [{}]", n.node, node.node))
                final TransportShardBulkAction transportShardBulkAction = new TransportShardBulkAction(
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
                final ScriptService scriptService = new ScriptService(settings, emptyMap(), emptyMap());
                lessThanOrEqualTo(
        continueOrDie(
            );  
            if (partial == false) {
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
            for (StepListener<Boolean> deleteListener : deleteSnapshotStepListeners) {
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
        });
            }  
        deterministicTaskQueue.runAllRunnableTasks();  
            createRepoAndIndex(repoName, index, shards),
                        .get("properties")).size()
                        .waitForCompletion(true),  
                    transportService,  
                    }
                        transportService,  
        final AdminClient clusterManagerAdminClient = clusterManagerNode.client.admin();
                        new SegmentReplicationSourceFactory(transportService, recoverySettings, clusterService),
                actions.put(  
        try {
                actions.put(  
                );
                        shardStateAction,  
        final Repository repository = randomClusterManager.repositoriesService.repository(repoName);
        final AtomicBoolean doneSnapshotting = new AtomicBoolean(false);
                            .isEmpty()  
            inProgressSnapshots  
                    public void onFailure(Exception e) {  
    public void testSnapshotWithNodeDisconnects() {
                        );  
    }  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsAction;  
            if (randomBoolean()) {  
                        threadPool,  
import org.opensearch.action.support.AutoCreateIndex;
        final String secondSnapshotName = "snapshot-2";
                    new FileCacheStats(1, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
                    public void connectToNodes(DiscoveryNodes discoveryNodes, Runnable onCompletion) {  
                        }
            createRepoAndIndex(repoName, index, shards),  
                    clusterService,  
        }
                        transportService,
                        throw new AssertionError(e);  
        });
import org.opensearch.indices.DefaultRemoteStoreSettings;  
        );
        continueOrDie(
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
            final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotId);  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryAction;  
    private void disconnectOrRestartDataNode() {
            deterministicTaskQueue.runAllRunnableTasks();
    private static Settings defaultIndexSettings(int shards) {
            assertEquals(0, snapshotInfo.failedShards());
}
        return createAliasListener;  
 * SPDX-License-Identifier: Apache-2.0
        );
                        transportService,
        assertEquals(0, snapshotInfo.failedShards());  
        });
    }
                    @Override
                        settings,
    /**
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
            bulkRequest.add(new IndexRequest(index).source(Collections.singletonMap("foo", "bar" + i)));
                final ShardLimitValidator shardLimitValidator = new ShardLimitValidator(settings, clusterService, systemIndices);  
            snapshotNames.size()  
                    restoreSnapshotResponseListener
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
                            indicesService,
        final StepListener<SearchResponse> searchResponseStepListener = new StepListener<>();
                            .stream()  
                final SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
                })
                .cluster()
     **/
                    }
                    mock(SearchService.class),  
                clusterService.close();  
import org.opensearch.action.admin.indices.mapping.put.TransportPutMappingAction;  
                    new RemoteSegmentStoreDirectoryFactory(() -> repositoriesService, threadPool, ""),  
    public void testBulkSnapshotDeleteWithAbort() {  
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
                                    createdSnapshot.set(true);  
                        actionFilters,
                repositoriesServiceReference.set(repositoriesService);  
                .prepareCreateSnapshot(repoName, snapshotName)  
        assertNotNull(createSnapshotResponseListener.result());  
                    }
                    }  
import org.opensearch.common.CheckedConsumer;  
        }  
                .cluster()
        // Select from sorted list of nodes  
        });  
import org.opensearch.cluster.NodeConnectionsService;
                new SearchRequest("restored_" + index).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),
                    ((Map<?, ?>) clusterManagerNode.clusterService.state()
        final StepListener<SearchResponse> searchResponseListener = new StepListener<>();
                        clusterService,
    private void scheduleNow(Runnable runnable) {  
            ignored -> client().admin()
        for (int i = 0; i < documents; ++i) {  
import java.util.ArrayList;
        assertEquals(shards, snapshotInfo.successfulShards());
                    writableRegistry(),
        }
            nodes.values().forEach(node -> builder.add(node.node));
            });  
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseStepListener = new StepListener<>();  
            private final NodeClient client;
            createIndexResponse -> client().admin()
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();  
                    assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());  
        clearDisruptionsAndAwaitSync();  
 */  
            createSnapshotResponse -> client().admin()
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                    indexScopedSettings,  
            createIndexResponse -> client().admin()
                        indexNameExpressionResolver,
                final ResponseCollectorService responseCollectorService = new ResponseCollectorService(clusterService);
                                                true
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.coordination.Coordinator;  
                    new SearchRequestOperationsCompositeListenerFactory();  
                actions.put(  
            final List<TestClusterNode> clusterManagerNodes = testClusterNodes.nodes.values()
        runUntil(exceptionVerified::get, TimeUnit.MINUTES.toMillis(5L));
                        // TODO: Remove this hack once recoveries are async and can be used in these tests  
                .execute(createSnapshotResponseStepListener)  
 * Licensed to Elasticsearch under one or more contributor  
                                ActionTestUtils.assertNoFailureListener(c -> logger.debug("--> Connected [{}] to [{}]", n.node, node))
                clusterService = new ClusterService(  
        assertThat(repositoryData.getGenId(), is(1L));
import org.opensearch.search.fetch.FetchPhase;  
        );  
 *  
            }
     * Create a {@link Environment} with random path.home and path.repo
            }
                clusterManagerNode.restart();  
        final ActionListener<CreateSnapshotResponse> createSnapshotListener = new GroupedActionListener<>(
import org.opensearch.action.support.TransportAction;
        final Repository repository = testClusterNodes.randomClusterManagerNodeSafe().repositoriesService.repository(repoName);
                }  
                        .sourceAsMap()  
        );
            }
                        assertFalse("Failures in bulkresponse: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());  
import org.opensearch.action.support.ActiveShardCount;  
            for (int i = 0; i < inProgressSnapshots; i++) {
                    )
                        new NoneCircuitBreakerService(),  
                        threadPool,  
                final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);  
            private final ClusterManagerService clusterManagerService;
                        for (SnapshotInfo snapshotInfo : snapshotInfos) {
        final int shards = randomIntBetween(1, 10);  
                    null
                if (testClusterNodes.nodes.containsKey(nodeName)) {  
            client().bulk(bulkRequest, bulkResponseStepListener);  
    public void testSearchableSnapshotOverSubscription() {
import org.opensearch.search.SearchService;
import org.opensearch.action.support.clustermanager.term.TransportGetTermVersionAction;  
import org.opensearch.env.NodeEnvironment;
import org.opensearch.tasks.TaskResourceTrackingService;
        );  
                            assertTrue(snapshotInfo.snapshotId().getName().contains("last-snapshot"));
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
                final RecoverySettings recoverySettings = new RecoverySettings(settings, clusterSettings);
                    rerouteServiceSetOnce::get  
import org.junit.After;
                    randomAlphaOfLength(10),  
                dynamicActionRegistry.registerUnmodifiableActionMap(actions);
                    try {  
            afterIndexing.run();
import org.opensearch.cluster.coordination.AbstractCoordinatorTestCase;
        assertEquals(0, snapshotInfo.failedShards());  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
        );
        TestClusterNodes(int clusterManagerNodes, int dataNodes, int warmNodes) {  
                );
                    Version.CURRENT
                    emptyMap(),  
        private TestClusterNode newNode(String nodeName, DiscoveryNodeRole role) throws IOException {
        repository.getRepositoryData(res);
        clusterManagerNode.clusterService.addListener(new ClusterStateListener() {
    }
import org.opensearch.cluster.routing.BatchedRerouteService;
                        if (nodes.containsKey(node.getName()) == false || nodes.containsKey(destination.getName()) == false) {
                            assertEquals(0, snapshotInfo.failedShards());  
                .execute(createSnapshotResponse);
                scheduleNow(this::disconnectRandomDataNode);
            .sorted(Comparator.comparing(n -> n.node.getName()))
                    @Override  
        public DiscoveryNodes discoveryNodes() {  
        String snapshotName = "snapshot";
                    new TransportClusterStateAction(
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
                        }  
import org.opensearch.cluster.ClusterState;
                );
        final String index = "test";  
import org.opensearch.action.admin.cluster.repositories.put.PutRepositoryAction;
    }  
            final boolean disconnectedClusterManager = randomBoolean() && clusterManagerNodes > 1;  
                new SearchRequest(index).source(new SearchSourceBuilder().size(0).trackTotalHits(true)),  
            assertEquals(snapshotInfo.successfulShards(), indices + 1);
        );  
        assertThat(successfulDeletes.get(), either(is(1)).or(is(2)));
                for (final String nodeName : excludedNames) {
                            e,
        final String index = "test";
                    () -> clusterService.localNode().getId(),
                            return new MockSinglePrioritizingExecutor(node.getName(), deterministicTaskQueue, threadPool);
                assertEquals(documents, bulkResponse.getItems().length);  
            }  
                            namedWriteableRegistry,
import org.opensearch.action.admin.cluster.snapshots.delete.DeleteSnapshotAction;  
            return clusterManagerNodes.isEmpty() ? Optional.empty() : Optional.of(randomFrom(clusterManagerNodes));
                );  
                    final DiscoveryNode node = testClusterNodes.nodes.get(nodeName).node;
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
            this(clusterManagerNodes, dataNodes, 0);  
import org.opensearch.search.pipeline.SearchPipelineService;
                    TransportAction getSnapshotsAction = clusterManagerNode.actions.get(GetSnapshotsAction.INSTANCE);  
                );
                        .ignoreUnavailable(false)
            }
                                    )  
import java.util.Set;
                createSnapshotResponse -> assertEquals(createSnapshotResponse.getSnapshotInfo().state(), SnapshotState.SUCCESS)
import java.util.concurrent.TimeUnit;
                .map(node -> node.clusterService.state())
        if (randomBoolean()) {  
                    ),
                scheduleNow(() -> testClusterNodes.clearNetworkDisruptions());
        });
                .setWaitForCompletion(false)
        }
                        )
                    client,  
            private final Logger logger = LogManager.getLogger(TestClusterNode.class);
import org.opensearch.action.support.WriteRequest;  
                final Environment environment = createEnvironment(node.getName());
    public NodeClient client() {
                    new NodeMappingRefreshAction(transportService, metadataMappingService),
        return Settings.builder()  
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
        );  
                );
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
        final Collection<StepListener<Boolean>> deleteSnapshotStepListeners = Arrays.asList(new StepListener<>(), new StepListener<>());
                                    testClusterNodes.randomDataNodeSafe().client.admin()
                    )
                                    .reroute(
                .setWaitForCompletion(true)
    }
import org.opensearch.cluster.routing.allocation.AllocationService;
                }  
                    Collections.emptyList(),  
                            return actualHandler;
            createSnapshotResponseStepListener,  
        final String snapshot = snapshotsList[0];  
                        mock(WorkloadGroupService.class)
                .setWaitForCompletion(true)
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotAction;  
    }
                        clusterService,
import org.opensearch.common.cache.module.CacheModule;  
        final StepListener<AcknowledgedResponse> createAliasListener = new StepListener<>();  
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(  
                    } catch (IOException e) {
                );
import static org.hamcrest.Matchers.either;  
                            namedXContentRegistry,  
        final int shards = randomIntBetween(1, 10);  
        private final Map<String, TestClusterNode> nodes = new LinkedHashMap<>();
                nodeConnectionsService.start();
import java.util.Map;
                        return newWarmNode(nodeName);
                        repositoriesService,
            private final NodeConnectionsService nodeConnectionsService;
                        threadPool,
                actions.put(
                indicesClusterStateService = new IndicesClusterStateService(  
    private void setupTestCluster(int clusterManagerNodes, int dataNodes, int warmNodes) {  
                .cluster()
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
        final long endTime = deterministicTaskQueue.getCurrentTimeMillis() + AbstractCoordinatorTestCase.DEFAULT_STABILISATION_TIME;  
    public void testSuccessfulSnapshotWithConcurrentDynamicMappingUpdates() {
            createIndexResponse -> testClusterNodes.randomClusterManagerNodeSafe().client.admin()
                public void run() {
                .collect(Collectors.toList());  
import java.util.stream.Stream;
import org.opensearch.cluster.coordination.MockSinglePrioritizingExecutor;
        continueOrDie(
                    Collections.emptyList(),
                        client,
        );
                    snapshotShardsService,
                        indexScopedSettings,
        // We end up with no snapshots since at least one of the deletes worked out  
                    metadataCreateIndexService,  
                    clusterManager -> snapshotDeleteResponded.get()
            final Set<Long> terms = clusterStates.stream().map(ClusterState::term).collect(Collectors.toSet());
            if (fulfilled.get()) {
                    clusterService,  
        });  
            private final ClusterService clusterService;
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();  
                        transportService,
                (int) hitCount,  
        client().bulk(bulkRequest, bulkResponseStepListener);
                        clusterService,
                    clusterService,
        final int documents = randomIntBetween(1, 100);  
        String snapshotName = "snapshot";
            );
                snapshotsService.start();  
        final StepListener<SearchResponse> searchAliasResponseListener = new StepListener<>();  
        continueOrDie(clusterStateResponseStepListener, clusterStateResponse -> {
                    DefaultRecoverySettings.INSTANCE,  
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                    assertEquals(documents, bulkResponse.getItems().length);
                createAnotherSnapshotResponseStepListener,
                assertTrue(
                throwable = restoreSnapshotException.getCause();
                indicesService.close();
            )  
        String snapshotName = "snapshot";
                final SnapshotInfo snapshotInfo = r.getSnapshotInfo();  
import org.opensearch.action.admin.cluster.reroute.TransportClusterRerouteAction;
                            namedXContentRegistry
            continueOrDie(bulkResponseStepListener, bulkResponse -> {
            }  
import static java.util.Collections.emptyMap;  
                        )
                        }
                () -> new AssertionError("Expected to find at least one connected cluster-manager node")
            // Index delete must be blocked for non-partial snapshots and we get a snapshot for every index  
    /**
                    remoteStoreNodeService,  
import org.opensearch.cluster.coordination.InMemoryPersistedState;
            testClusterNodes.randomDataNodeSafe().client.admin()
 * You may obtain a copy of the License at  
                .execute(createSnapshotResponseStepListener)
                .execute(createSnapshotResponseStepListener)
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
            createSnapshotResponse -> client().admin().indices().delete(new DeleteIndexRequest(index), deleteIndexListener)  
                actions.put(
                        mockIndicesService,  
        }  
import static org.hamcrest.Matchers.endsWith;
                if (event.state().custom(SnapshotsInProgress.TYPE) != null) {
            blobStoreContext = new MockEventuallyConsistentRepository.Context();  
                .execute(createSnapshotResponseStepListener)
                                .execute(createSnapshotResponseStepListener);  
        );  
        if (snapshotNeverStarted.get()) {
            createOtherSnapshotResponseStepListener,  
                });
                final MetadataCreateIndexService metadataCreateIndexService = new MetadataCreateIndexService(
                                }  
                        String executor,
                .execute(createSnapshotResponseListener);
 * compatible open source license.
                    ),
            Objects.requireNonNull(searchAliasResponseListener.result().getHits().getTotalHits()).value()  
        continueOrDie(
                .execute(createSnapshotResponseStepListener)
    public void createServices() {  
                    settings,
                    .setTaskResourceTrackingService(new TaskResourceTrackingService(settings, clusterSettings, threadPool));
import org.opensearch.action.resync.TransportResyncReplicationAction;
    }
        setupTestCluster(1, 2, 2);
                        allocationService,
import org.opensearch.action.admin.indices.stats.SearchResponseStatusStats;  
import org.opensearch.action.admin.indices.alias.TransportIndicesAliasesAction;
                    )  
                        transportService,
                    clusterInfoService::getClusterInfo,
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);
                    new TransportRestoreSnapshotAction(  
                        searchService,
                        threadPool,
                        namedWriteableRegistry,
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);  
        String repoName = "repo";  
                .prepareCreateSnapshot(repoName, snapshotName)  
 * this work for additional information regarding copyright
            final Collection<ClusterState> clusterStates = testClusterNodes.nodes.values()  
        final String index = "test";
                    IndicesAliasesAction.INSTANCE,
        assertEquals(shards, snapshotInfo.successfulShards());
            // Select from sorted list of data-nodes here to not have deterministic behaviour  
        String repoName = "repo";  
                .execute(deleteSnapshotStepListener)
import org.opensearch.cluster.SnapshotsInProgress;
    public void testSnapshotPrimaryRelocations() {
    private StepListener<CreateIndexResponse> createRepoAndIndex(String repoName, String index, int shards) {
                        .contains(
        }
            public void clusterChanged(ClusterChangedEvent event) {
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
        final ClusterState initialClusterState = new ClusterState.Builder(ClusterName.DEFAULT).nodes(testClusterNodes.discoveryNodes())
            client().admin()
        final int clusterManagerNodes = randomFrom(3, 5);
                index,  
        final String index = "test";  
    }
            allSnapshotsListener,
                            }
                        TransportRequestHandler<T> actualHandler
                            namedXContentRegistry,  
                    allocationService,
                        // we rely on disconnect to run for keeping track of pendingDisconnects and ensuring node-joins can happen
                )  
import org.opensearch.indices.SystemIndices;
                );
        final StepListener<AcknowledgedResponse> deleteSnapshotStepListener = new StepListener<>();  
                Runnable::run
                rerouteServiceSetOnce.set(rerouteService);
                afterIndexing.run();  
import org.opensearch.indices.ShardLimitValidator;  
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
        if (randomBoolean()) {
                        indexNameExpressionResolver,
import org.opensearch.action.support.ActionTestUtils;
                coordinator = new Coordinator(  
        Map<String, AggregateFileCacheStats> nodeFileCacheStats = new HashMap<>();
        runUntil(() -> doneIndexing.get() && doneSnapshotting.get(), TimeUnit.MINUTES.toMillis(5L));
                final RestoreService restoreService = new RestoreService(
        }
                .prepareCreateSnapshot(repoName, GetSnapshotsRequest.CURRENT_SNAPSHOT)  
                        // just update targetsByNode to ensure disconnect runs for these nodes
            });
                        transportService,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteAction;  
                    try {  
        }  
                    public <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
                .cluster()
                        transportService,
                    namedWriteableRegistry,
            });
                assertTrue(throwable instanceof SnapshotRestoreException);
                        transportService,
import org.opensearch.action.admin.cluster.state.TransportClusterStateAction;
import java.util.concurrent.atomic.AtomicInteger;
    }
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                    indicesService,
     * Context shared by all the node's {@link Repository} instances if the eventually consistent blobstore is to be used.
                        new AutoCreateIndex(settings, clusterSettings, indexNameExpressionResolver, new SystemIndices(emptyMap())),
                        environment,
                        null  
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {
                    rerouteService,
                        random()  
        final StepListener<Collection<CreateIndexResponse>> createIndicesListener = new StepListener<>();
        continueOrDie(restoreSnapshotResponseListener, restoreSnapshotResponse -> {
import org.opensearch.cluster.routing.RerouteService;
    }
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);  
                .putList(  
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
import org.opensearch.action.admin.indices.create.TransportCreateIndexAction;
                return clusterInfoService;  
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
                        indicesService,
        assertEquals(shards, snapshotInfo.successfulShards());
        assertThat(snapshotIds, hasSize(1));  
                        .metadata()  
                        assertNotNull("Snapshot list should not be null", repoSnapshotResponse.getSnapshots());
            node.stop();  
import org.opensearch.cluster.service.FakeThreadPoolClusterManagerService;
                    persistedStateRegistry,
                testClusterNodes.disconnectNode(clusterManagerNode);
                .prepareCreateSnapshot(repoName, snapshotName)  
                    mock(SegmentReplicationSourceService.class),
         * Node names that are disconnected from all other nodes.
                        searchRequestOperationsCompositeListenerFactory,  
                transportService.start();
                .cluster()  
            for (CreateSnapshotResponse createSnapshotResponse : createSnapshotResponses) {
                    ClusterRerouteAction.INSTANCE,
                        actionFilters,
            return snapshotsInProgress != null && snapshotsInProgress.entries().isEmpty();
                client().admin().indices().create(new CreateIndexRequest("index-" + i), listener);  
                transportService.getTaskManager()  
                        .filter(n -> n.node.isClusterManagerNode())
            ) {  
        });
            .orElseThrow(() -> new AssertionError("expected to find at least one active cluster-manager node"));
            scheduleNow(new Runnable() {  
import org.opensearch.action.support.DestructiveOperations;
                indicesClusterStateService.start();
        final VotingConfiguration votingConfiguration = new VotingConfiguration(
            final List<TestClusterNode> dataNodes = testClusterNodes.nodes.values().stream().filter(n -> n.node.isDataNode()).filter(n -> {
                scheduleSoon(() -> testClusterNodes.clearNetworkDisruptions());
     * deleting a snapshot.  
import org.opensearch.action.admin.cluster.snapshots.delete.TransportDeleteSnapshotAction;
                        throw new AssertionError(e);  
                        null
                        new RequestValidators<>(Collections.emptyList()),
                afterIndexing.run();
                    settings,  
                        restoreSnapshotResponseListener  
                        for (final DiscoveryNode discoveryNode : discoveryNodes) {  
                    client().admin().cluster().prepareDeleteSnapshot(repoName, snapshotName).execute(deleteSnapshotStepListener);  
                    new TransportSearchAction(  
        assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
import org.opensearch.cluster.routing.UnassignedInfo;
            assertEquals(shards, snapshotInfo.successfulShards());
                }
        testClusterNodes = new TestClusterNodes(clusterManagerNodes, dataNodes, warmNodes);
    public void testSnapshotDeleteWithClusterManagerFailover() {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * specific language governing permissions and limitations
        );
import org.opensearch.index.shard.PrimaryReplicaSyncer;
            );  
                        actionFilters
import org.opensearch.cluster.routing.ShardRouting;  
                    RetentionLeaseSyncer.EMPTY,  
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
        assertEquals(shards, snapshotInfo.successfulShards());  
                            .renamePattern("(.+)")
                    new TaskResourceTrackingService(settings, clusterSettings, threadPool),
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryRequest;
            .filter(n -> n.node.isClusterManagerNode())  
        assertEquals(0, snapshotInfo.failedShards());
     */
            for (int i = 0; i < indices; ++i) {
            createOtherSnapshotResponseStepListener,
                final MetadataIndexAliasesService metadataIndexAliasesService = new MetadataIndexAliasesService(
        }
        }  
import org.opensearch.action.ActionType;  
                        threadPool,  
            client().search(  
                assertNotNull("Snapshot list should not be null", repoSnapshotResponse.getSnapshots());
                .sorted(Comparator.comparing(n -> n.node.getName()))  
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
import org.opensearch.action.bulk.BulkAction;
            private final RepositoriesService repositoriesService;
            }  
                    );
                                                index,
                rerouteService = new BatchedRerouteService(clusterService, allocationService::reroute);  
        String repoName = "repo";  
        private TestClusterNode newDataNode(String nodeName) throws IOException {  
                    PutMappingAction.INSTANCE,
                    }
                            new AnalysisModule(environment, Collections.emptyList()).getAnalysisRegistry(),
        continueOrDie(
                    null,
        final int shards = randomIntBetween(1, 10);
                        } else {
        final int documents = randomIntBetween(2, 100);  
            .orElseThrow(() -> new AssertionError("expected to find at least one active cluster-manager node"));  
                        threadPool,
                        NoopTracer.INSTANCE,
                    namedWriteableRegistry,
            }
        String repoName = "repo";
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.index.store.remote.filecache.FileCacheStats;
            if (randomBoolean()) {
            if (disconnectedNodes.contains(node.node.getName())) {
            }  
                if (event.state().custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries().isEmpty() == false) {
                    )
            final Set<String> disconnectedNodes = new HashSet<>(this.disconnectedNodes);  
import org.opensearch.indices.mapper.MapperRegistry;
        String repoName = "repo";
                    threadPool,
                    transportService,
                        }
        final SetOnce<Index> firstIndex = new SetOnce<>();
            } else if (randomBoolean()) {  
        SnapshotDeletionsInProgress deletionsInProgress = clusterManagerNode.clusterService.state()  
            this.disconnectedNodes.clear();
                repositoriesService = new RepositoriesService(
                .restoreSnapshot(  
                    }
                scheduleNow(() -> testClusterNodes.clearNetworkDisruptions());
                .delete(new DeleteIndexRequest(index), new ActionListener<AcknowledgedResponse>() {
                    final StepListener<ClusterStateResponse> updatedClusterStateResponseStepListener = new StepListener<>();  
import org.opensearch.cluster.metadata.MetadataMappingService;  
import java.util.Objects;
                        snapshotsService,
                snapshotsService = new SnapshotsService(  
                        onCompletion.run();  
                final CoordinationState.PersistedState persistedState = new InMemoryPersistedState(  
            acknowledgedResponse -> client().admin()
                @Override
                            clusterService,
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
            documentCountVerified.set(true);
                        xContentRegistry(),
    private TestClusterNodes testClusterNodes;  
import org.opensearch.transport.TransportRequestHandler;  
                    )
                            client  
            } else {
        final StepListener<CreateSnapshotResponse> createOtherSnapshotResponseStepListener = new StepListener<>();
        continueOrDie(restoreSnapshotResponseStepListener, restoreSnapshotResponse -> {
import org.opensearch.action.bulk.BulkRequest;
import org.opensearch.action.admin.cluster.repositories.cleanup.CleanupRepositoryResponse;
        assertEquals(
                client = new NodeClient(settings, threadPool);
                        indexNameExpressionResolver,
                    () -> repositoriesService,
import org.opensearch.node.ResponseCollectorService;  
                        mock(SegmentReplicationStatsTracker.class),
                    new IndicesAliasesRequest().addAliasAction(IndicesAliasesRequest.AliasActions.add().index(index).alias(alias)),
        public TestClusterNode randomClusterManagerNodeSafe() {  
                        new IngestService(  
                        clusterService,  
        String snapshotName = "snapshot";  
            final List<Long> versions = clusterStates.stream().map(ClusterState::version).distinct().collect(Collectors.toList());
import org.opensearch.action.admin.indices.mapping.put.AutoPutMappingAction;  
                    assertNoFailureListener(bulkResponse -> {
                    mappingUpdatedAction,
                    try {  
                        emptyMap(),
                    allocationService  
        continueOrDie(createSnapshotResponseStepListener, createSnapshotResponse -> {  
                assertEquals(snapshotInfo.snapshotId().getName(), snapshotsList[0]);
                            ConcurrentSnapshotExecutionException.class,
                            .filter(transport -> transport.getLocalNode().getAddress().equals(address))
            }
            doneSnapshotting.set(true);
                        mockIndicesService,  
            throw new AssertionError("No nodes available");
    }  
import static org.hamcrest.Matchers.is;
                    mock(RemoteStorePressureService.class),
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
                            .shardRoutingTable(shardToRelocate.shardId())
                        NoopMetricsRegistry.INSTANCE,
                        )
                new DiscoveryNode(
        continueOrDie(
    }  
import org.opensearch.action.bulk.BulkResponse;  
                        .collect(Collectors.toList()),
import org.opensearch.action.bulk.TransportBulkAction;
                        threadPool,  
        while (deterministicTaskQueue.getCurrentTimeMillis() < endTime) {
                );  
import org.opensearch.cluster.coordination.PersistedStateRegistry.PersistedStateType;
        tempDir = createTempDir();
                            shardStateAction,
    private void scheduleSoon(Runnable runnable) {
import org.opensearch.cluster.action.shard.ShardStateAction;
        public Optional<TestClusterNode> randomClusterManagerNode() {  
        continueOrDie(
        );
        final StepListener<CreateSnapshotResponse> createSnapshotResponseListener = new StepListener<>();  
        restoreSnapshotResponseListener.whenComplete(null, restoreSnapshotException -> {
            }
                final ActionFilters actionFilters = new ActionFilters(emptySet());
                            assertEquals(SnapshotState.IN_PROGRESS, snapshotInfo.state());
                .cluster()
            return nodes.values()
                    responseCollectorService,
                    .prepareCreateSnapshot(repoName, secondSnapshotName)  
        final int shards = randomIntBetween(1, 10);
        );
        final int shards = randomIntBetween(1, 10);
                        transportService,  
        runUntil(documentCountVerified::get, TimeUnit.MINUTES.toMillis(5L));
                final SnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                        threadPool,  
                        }  
        String snapshotName = "snapshot";  
                    try {  
        final String repoName = "repo";  
        assertThat(snapshotIds, empty());
                if (blobStoreContext == null) {
import org.opensearch.test.disruption.DisruptableMockTransport;  
            Throwable throwable = restoreSnapshotException;
        final int inProgressSnapshots = randomIntBetween(1, 5);
        );
        );  
                    TransportGetSnapshotsAction transportGetSnapshotsAction = (TransportGetSnapshotsAction) getSnapshotsAction;
                );  
                );  
            assertEquals(documents, Objects.requireNonNull(r.getHits().getTotalHits()).value());
                                }
                    }  
        assertFalse(deletionsInProgress.hasDeletionsInProgress());
            for (int i = 0; i < warmNodes; ++i) {
                        threadPool,  
            )  
        continueOrDie(
                    ),
                .setWaitForCompletion(true)
        continueOrDie(  
                            node.node,
        assertThat(snapshotIds, hasSize(2));
import org.opensearch.indices.recovery.DefaultRecoverySettings;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;  
                .execute(createSnapshotResponseStepListener);
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);  
            createRepoAndIndexAndAlias(repoName, index, shards, alias),  
import java.util.Optional;  
                        threadPool,  
    private void indexNDocuments(int documents, String index, Runnable afterIndexing) {  
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
        assertThat(snapshotIds, either(hasSize(1)).or(hasSize(0)));
        continueOrDie(bulkResponseStepListener, bulkResponse -> {
                    }
                    } catch (IOException e) {
                    null
                .execute(ActionListener.wrap(() -> snapshotDeleteResponded.set(true)));
            @Override  
                    assertEquals(documents, bulkResponse.getItems().length);
            private RemoteStoreNodeService remoteStoreNodeService;  
        runUntil(documentCountVerified::get, TimeUnit.MINUTES.toMillis(5L));
import java.util.HashSet;
                .deleteSnapshot(new DeleteSnapshotRequest(repoName, "*"), deleteSnapshotStepListener)  
    private RepositoryData getRepositoryData(Repository repository) {  
                repositoriesService.start();
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
import java.util.function.Supplier;
                );  
                .indices()
                        List<SnapshotInfo> snapshotInfos = repoSnapshotResponse.getSnapshots();
                .filter(n -> n.node.getId().equals(nodeId))  
import org.opensearch.ingest.SystemIngestPipelineCache;
        );
import org.opensearch.test.OpenSearchIntegTestCase;
                            threadPool,
                    ReferencedSegmentsPublisher.EMPTY
                    ),
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();  
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
import org.opensearch.action.admin.indices.alias.IndicesAliasesAction;
import static org.hamcrest.Matchers.iterableWithSize;
                    transportService.getRemoteClusterService(),  
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
        assertThat(restoreSnapshotResponseListener.result().getRestoreInfo().failedShards(), is(0));  
            .nodes(DiscoveryNodes.builder(state.nodes()).remove(node.getId()).add(node).localNodeId(node.getId()))  
                    threadPool
                .findFirst()
                        searchPhaseController,
import org.opensearch.action.admin.indices.mapping.put.PutMappingAction;
        final int documentsFirstSnapshot = randomIntBetween(0, 100);
import static org.hamcrest.Matchers.empty;
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
                    afterIndexing.run();
        );  
    }
            .custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
        continueOrDie(createOtherSnapshotResponseStepListener, createSnapshotResponse -> {  
                        protected void assertSnapshotOrGenericThread() {
            } else {  
                        .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE),
                    allocationService,  
        continueOrDie(
                )
                snapshotShardsService.start();
        final StepListener<Collection<CreateSnapshotResponse>> createOtherSnapshotResponseStepListener = new StepListener<>();  
    private final class TestClusterNodes {
                new SearchRequest(restoredIndex).source(new SearchSourceBuilder().size(documents).trackTotalHits(true)),
                    new TransportCreateIndexAction(
            }
            assertThat(snapshotIds, empty());
    }  
 *
        fail("Condition wasn't fulfilled.");
                    coordinator.close();
            );  
 * under the License.  
            createRepositoryListener,
        assertTrue(documentCountVerified.get());
 * ownership. Elasticsearch licenses this file to you under  
                    return metadata -> new MockEventuallyConsistentRepository(  
                .prepareCreateSnapshot(repoName, "snapshot-2")  
                .cluster()
                    testClusterNodes.nodes.values()
        final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();  
            private Repository.Factory getRepoFactory(Environment environment) {
            assertEquals(SnapshotState.SUCCESS, snapshotInfo.state());
        final AtomicInteger successfulDeletes = new AtomicInteger(0);
        assertThat(snapshotIds, hasSize(1));
import org.opensearch.cluster.ClusterModule;  
            deleteSnapshotStepListener,  
import org.opensearch.common.util.concurrent.ThreadContext;  
                indicesService = new IndicesService(
        for (SnapshotId snapshotId : snapshotIds) {  
            .forEach(testClusterNode -> testClusterNode.coordinator.setInitialConfiguration(votingConfiguration));
                    new TransportClusterRerouteAction(  
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                        restoreService,
                    new TransportPutRepositoryAction(
                                        .deleteSnapshot(new DeleteSnapshotRequest(repoName, snapshotName), noopListener());  
import org.opensearch.indices.replication.SegmentReplicationTargetService;
        final AtomicBoolean snapshotDeleteResponded = new AtomicBoolean(false);
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                            );
            createSnapshotResponseStepListener,  
                return true;
                .orElse(false),
            // failures seen during the previous test.
import org.opensearch.indices.recovery.PeerRecoverySourceService;  
import org.opensearch.cluster.coordination.CoordinationState;
                    }  
        public TestClusterNode randomDataNodeSafe(String... excludedNames) {
                            new SystemIndices(emptyMap()),
            );
                && clusterManagerNodeIds.contains(null) == false
                    clusterService.getSettings(),
                                + " setting."
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
                .setWaitForCompletion(true)
    }  
        );  
        });  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            runUntil(cleanedUp::get, TimeUnit.MINUTES.toMillis(1L));
                );
            ignored -> client().admin()  
            assertEquals(snapshotInfo.state(), SnapshotState.SUCCESS);
                .cluster()
                        threadPool,  
        final AtomicBoolean doneIndexing = new AtomicBoolean(false);
                actions.put(
        private TestClusterNode newClusterManagerNode(String nodeName) throws IOException {
            assertThat(snapshotInfo.indices(), containsInAnyOrder(index));
                .execute(createSnapshotResponseListener)
                        scheduleNow(CoordinatorTests.onNodeLog(getLocalNode(), runnable));
        String snapshotName = "snapshot";
                        indexNameExpressionResolver  
        /**
import org.opensearch.cluster.service.ClusterManagerService;  
        final StepListener<CreateIndexResponse> createIndexResponseStepListener = new StepListener<>();
                assertThat(snapshotInfo.shardFailures(), iterableWithSize(snapshotInfo.failedShards()));  
                        indexNameExpressionResolver
                    mock(PluginsService.class),  
import org.opensearch.cluster.metadata.IndexMetadata;  
    private StepListener<AcknowledgedResponse> createRepoAndIndexAndAlias(String repoName, String index, int shards, String alias) {
            );
                    scriptService,
    }  
                    clusterManagerAdminClient.cluster().state(new ClusterStateRequest(), updatedClusterStateResponseStepListener);
                coordinator.startInitialJoin();  
                    clusterService,
        for (SnapshotId snapshotId : snapshotIds) {
                    )
                        clusterService,  
            }
            }  
import org.opensearch.common.util.BigArrays;
        continueOrDie(  
            for (int i = 0; i < randomIntBetween(0, dataNodes); ++i) {
                                .execute(ActionListener.wrap(() -> {
        listener.whenComplete(onResponse, e -> { throw new AssertionError(e); });
        private TestClusterNode newWarmNode(String nodeName) throws IOException {
                        indexNameExpressionResolver
                        DefaultRemoteStoreSettings.INSTANCE,  
                    deterministicTaskQueue::scheduleNow
            scheduleNow(() -> testClusterNodes.stopNode(currentPrimaryNode));
                        @Override  
                            n -> n.transportService.openConnection(
                        clusterService,
                                                shardRouting.shardId().id(),  
        continueOrDie(
    public void testConcurrentSnapshotDeleteAndDeleteIndex() throws IOException {  
                    new UpdateHelper(scriptService),  
                .restoreSnapshot(
                .cluster()
            }  
                assertEquals(0, snapshotInfo.failedShards());
            }  
                ThreadPool threadPool,
                return new NodeConnectionsService(settings, threadPool, transportService) {
import org.opensearch.action.support.GroupedActionListener;  
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
        });
                    repositoryData,  
                    () -> persistedState,
                            settings,  
                (BlobStoreRepository) testClusterNodes.randomClusterManagerNodeSafe().repositoriesService.repository("repo"),
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                node -> testClusterNodes.nodes.values()
            );  
    public void testTransportGetCurrentSnapshotsAction() {
            final TestClusterNodes.TestClusterNode currentPrimaryNode = testClusterNodes.nodeById(shardToRelocate.currentNodeId());  
        }  
                .prepareDeleteSnapshot(repoName, snapshotName)
                    clusterSettings,
                    Collections.singletonMap(FsRepository.TYPE, getRepoFactory(environment)),  
                    .forEach(  
import static org.opensearch.node.Node.NODE_SEARCH_CACHE_SIZE_SETTING;  
                            client,
                        transportService,
            .custom(SnapshotDeletionsInProgress.TYPE);
        final TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                blobStoreContext.forceConsistent();
        );
                        if (shardRouting.unassigned() && shardRouting.unassignedInfo().getReason() == UnassignedInfo.Reason.NODE_LEFT) {
        String snapshotName = "snapshot";
                && clusterManagerNodeIds.size() == 1
        final String index = "test";  
                    protected void execute(Runnable runnable) {
            .stream()
                    .execute(createSnapshotResponseStepListener)
                node.node.getId(),
            final StepListener<BulkResponse> bulkResponseStepListener = new StepListener<>();
        continueOrDie(createRepoAndIndex(repoName, index, 1), createIndexResponse -> {  
import org.opensearch.repositories.RepositoriesService;  
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                actions.put(
        return randomFrom(nodes).client;  
                        return disconnectedNodes.contains(node.getName()) || disconnectedNodes.contains(destination.getName())
                        );
                        .renameReplacement(restoredIndex)
                        clusterService,
            private final DisruptableMockTransport mockTransport;
                clusterService.start();  
                    )
import org.opensearch.snapshots.mockstore.MockEventuallyConsistentRepository;  
        return ActionListener.wrap(() -> {});
        final TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(  
                final NamedXContentRegistry namedXContentRegistry = new NamedXContentRegistry(Collections.emptyList());  
        final int indices = randomIntBetween(5, 20);  
            return builder.build();  
        continueOrDie(createSnapshotResponseStepListener, createSnapshotResponse -> {  
        // No snapshots should be left in the repository  
                            return ConnectionStatus.DISCONNECTED;
            public void clusterChanged(ClusterChangedEvent event) {
            private final NodeEnvironment nodeEnv;  
            );  
                }, a -> node, null, emptySet(), NoopTracer.INSTANCE);
                        clusterService,
                nodeConnectionsService.stop();
                    clusterService,
import org.opensearch.action.search.SearchAction;
                );  
                )  
                    new AliasValidator(),
                        transportService,
            // finalization  
import org.opensearch.cluster.routing.allocation.AwarenessReplicaBalance;  
import org.apache.logging.log4j.Logger;
                );  
                );  
                        client,
        // LinkedHashMap so we have deterministic ordering when iterating over the map in tests  
import static org.opensearch.node.Node.NODE_NAME_SETTING;
                    }, exception -> { throw new AssertionError(exception); }));  
                    indicesService,
            nodes.remove(node.node.getName());
        assertEquals(  
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();  
                .setPartial(partialSnapshot)
        assertThat(finalSnapshotsInProgress.entries(), empty());
            private final AllocationService allocationService;  
                    createIndexResponseStepListener
        final String index = "test";
                        if (partialSnapshot) {
                indicesService.start();
        );
                    new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE),
/*
                                        new ClusterRerouteRequest().add(  
        final String index = "test";  
import static org.hamcrest.Matchers.hasSize;  
        continueOrDie(
                    namedXContentRegistry
                .collect(Collectors.toSet())
        if (partialSnapshot) {  
        deterministicTaskQueue.runAllRunnableTasks();  
                    clusterManagerNode.clusterService.removeListener(this);
        String repoName = "repo";
                            NoopTracer.INSTANCE  
            testClusterNodes.nodes.values().iterator().next().clusterService.state()  
        testClusterNodes.nodes.values().forEach(node -> when(node.getMockClusterInfoService().getClusterInfo()).thenReturn(clusterInfo));
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                        actionFilters,  
                .map(n -> n.node)
                .execute(createOtherSnapshotResponseStepListener)
        continueOrDie(
                    transportService,
import org.mockito.Mockito;
        public void disconnectNode(TestClusterNode node) {  
                        transportService,  
        final Repository repository = clusterManagerNode.repositoriesService.repository(repoName);
                .prepareCreateSnapshot("repo", "last-snapshot")
                );  
 * The OpenSearch Contributors require contributions made to  
        clearDisruptionsAndAwaitSync();
    private MockEventuallyConsistentRepository.Context blobStoreContext;  
 * KIND, either express or implied.  See the License for the
        String snapshotName = "snapshot";
                client().admin().cluster().prepareCreateSnapshot(repoName, "other-" + i).execute(createSnapshotListener);
    }  
        continueOrDie(searchResponseListener, r -> {  
            if (documents == 0) {  
        String repoName = "repo";
        final ActionListener<CreateSnapshotResponse> snapshotListener = new GroupedActionListener<>(
                    rerouteService,
                }
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;  
        });  
import org.opensearch.transport.TransportRequest;
        });  
                        final ShardRouting shardRouting = updatedClusterState.getState()  
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
                .orElseThrow(() -> new AssertionError("Could not find node by id [" + nodeId + ']'));
                .cluster()
                    initialState.term(),
                            scheduleNow(
            deterministicTaskQueue.advanceTime();
        /**  
        final String[] snapshotsList = { GetSnapshotsRequest.CURRENT_SNAPSHOT };  
        String snapshotName = "snapshot";
                    .setWaitForCompletion(true)
    }  
                    Collections.singleton(role),  
            for (String snapshotName : snapshotNames) {
            if (documents == 0) {
            );  
            final Set<String> clusterManagerNodeIds = clusterStates.stream()
import org.opensearch.core.common.transport.TransportAddress;  
    @Before
                    new BulkRequest().add(new IndexRequest(index).source(Collections.singletonMap("foo" + i, "bar")))  
                        } else {
                    indexNameExpressionResolver,  
                        indexNameExpressionResolver
import org.opensearch.core.index.Index;
import org.opensearch.indices.IndicesService;
                actions.put(
                    NoopTracer.INSTANCE
                        .map(n -> n.node.getAddress())  
        TestClusterNodes.TestClusterNode clusterManagerNode = testClusterNodes.currentClusterManager(
                            scriptService,
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
                        new RequestValidators<>(Collections.emptyList())  
        assertThat(snapshotIds, hasSize(snapshotNames.size()));
                coordinator.setNodeConnectionsService(nodeConnectionsService);
        final StepListener<CreateSnapshotResponse> createSnapshotResponseStepListener = new StepListener<>();
                assertThat(snapshotInfo.state(), either(is(SnapshotState.SUCCESS)).or(is(SnapshotState.PARTIAL)));
        continueOrDie(
    public void testRunConcurrentSnapshots() {  
                    settings,
                scheduleSoon(() -> {
import static org.opensearch.env.Environment.PATH_HOME_SETTING;  
 */  
        }
                        indexNameExpressionResolver,  
    public void testConcurrentSnapshotCreateAndDelete() {
                    protected ConnectionStatus getConnectionStatus(DiscoveryNode destination) {
            }
        final StepListener<RestoreSnapshotResponse> restoreSnapshotResponseListener = new StepListener<>();
                    new RestoreSnapshotRequest(repoName, snapshotName).waitForCompletion(true)
            TestClusterNode clusterManager = nodes.get(state.nodes().getClusterManagerNode().getName());  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());  
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());  
        for (SnapshotId snapshotId : snapshotIds) {  
                    protected Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address) {
                mappingTransformerRegistry = new MappingTransformerRegistry(List.of(), namedXContentRegistry);
     */
                .collect(Collectors.toSet());  
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
            .build();
                    dynamicActionRegistry,
                        );  
        }
                    new FetchPhase(Collections.emptyList()),
                    shardStateAction,
                            if (clusterManagerNodeCount > 1) {
        }
                    new TransportPutMappingAction(  
        );
                    clusterService,
                );
            for (int i = 0; i < dataNodes; ++i) {
import org.opensearch.indices.analysis.AnalysisModule;
                testClusterNodes.disconnectNode(this);
import java.util.stream.Collectors;  
import org.opensearch.action.search.TransportSearchAction;  
                            throw new AssertionError("Delete index should always work during partial snapshots", e);
                        if (action.startsWith("internal:index/shard/recovery")) {
    private DeterministicTaskQueue deterministicTaskQueue;
                    settings,
                );
            createIndexResponse -> client().admin()
                        new DestructiveOperations(settings, clusterSettings)  
    private void disconnectRandomDataNode() {
        });  
                    restoreSnapshotResponseListener
import org.opensearch.cluster.coordination.ElectionStrategy;  
                        snapshotsService,
                    indicesService,
                    namedXContentRegistry,
                        threadPool,
                    new TransportAutoPutMappingAction(
                    assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
                .prepareCreateSnapshot(repoName, snapshotName)  
        final RepositoryData repositoryData = getRepositoryData(repository);
        // TODO: randomize replica count settings once recovery operations aren't blocking anymore
        createSnapshotResponseStepListener.whenComplete(createSnapshotResponse -> {
                        metadata,
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
                    )
            createRepoAndIndex(repoName, index, shards),
        // Connect all nodes to each other
        testClusterNodes.nodes.values().forEach(testClusterNode -> testClusterNode.start(initialClusterState));  
                        emptyMap(),  
        });  
                    new NamedWriteableRegistry(Collections.emptyList())
        final StepListener<AcknowledgedResponse> deleteSnapshotStepListener = new StepListener<>();  
        final AtomicBoolean documentCountVerified = new AtomicBoolean();  
import org.opensearch.action.search.SearchRequest;
                    ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey(),
                        searchTransportService,  
        );  
                    buildNewFakeTransportAddress(),
 * the Apache License, Version 2.0 (the "License"); you may
                        .prepareCreateSnapshot(repoName, snapshotName)
                            .renameAliasPattern("(.+)")
                    new MetaStateService(nodeEnv, namedXContentRegistry),
        final String index = "test";
                assertFalse("Failures in bulk response: " + bulkResponse.buildFailureMessage(), bulkResponse.hasFailures());
                    emptyMap(),
                    emptyMap(),
                nodes.remove(node.getName());
                    mapperRegistry,
                final IndicesService mockIndicesService = mock(IndicesService.class);
    }
                throw new AssertionError(e);
import org.opensearch.indices.replication.SegmentReplicationSourceService;
 * software distributed under the License is distributed on an
import org.opensearch.gateway.TransportNodesListGatewayStartedShards;
            if (disconnectedClusterManager) {
        final PlainActionFuture<RepositoryData> res = PlainActionFuture.newFuture();
        private final class TestClusterNode {  
                // Make sure we snapshotted the metadata of this index and not the recreated version
                                    throw new AssertionError(e);
                }  
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
/*  
                    scriptService,
            // Create another snapshot and then clean up the repository to verify that the repository works correctly no matter the  
                    clusterManagerService,
                        actionFilters,
        startCluster();
            client().search(
        final StepListener<CreateSnapshotResponse> createSnapshotResponseListener = new StepListener<>();
import static org.hamcrest.Matchers.contains;
import org.opensearch.node.remotestore.RemoteStoreNodeService;
                    new PeerRecoverySourceService(transportService, indicesService, recoverySettings),
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;  
    }
                        actionFilters,
            createSnapshotResponseListener,
                        transportService,
        }
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
import org.opensearch.action.admin.cluster.snapshots.get.TransportGetSnapshotsAction;
                .map(
                return false;  
        });
        final String alias = "test_alias";
                            threadPool,
        public TestClusterNode nodeById(final String nodeId) {  
import org.opensearch.action.search.SearchRequestOperationsCompositeListenerFactory;  
import org.opensearch.cluster.ClusterInfoService;
                persistedStateRegistry.addPersistedState(PersistedStateType.LOCAL, persistedState);
                            .getEntries()
        }
import org.opensearch.index.analysis.AnalysisRegistry;  
                            actionFilters,  
        stabilize();
                    indexScopedSettings,
                            new IndexingPressureService(settings, clusterService),
import org.opensearch.cluster.ClusterManagerMetrics;
        );
            deterministicTaskQueue.runAllRunnableTasks();  
        final StepListener<CreateSnapshotResponse> createSnapshotResponseListener = new StepListener<>();
            }, exception -> { throw new AssertionError(exception); }));  
        final int shards = randomIntBetween(1, 10);
        continueOrDie(createRepoAndIndex(repoName, index, shards), createIndexResponse -> {
            testClusterNodes.nodes.values().forEach(TestClusterNodes.TestClusterNode::stop);
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
                );
                            scriptService,
            final GroupedActionListener<CreateIndexResponse> listener = new GroupedActionListener<>(createIndicesListener, indices);
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), shards)
                    new RemoteStoreStatsTrackerFactory(clusterService, settings),  
    private void stabilize() {
                );  
        assertTrue(exceptionVerified.get());  
                }
                final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(
                    indicesService
        assertNotNull(createSnapshotResponseStepListener.result());  
                    new FileCacheStats(1, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            });
import org.opensearch.cluster.node.DiscoveryNodeRole;
            public NodeConnectionsService createTestNodeConnectionsService(
            scheduleNow(
import org.opensearch.ingest.IngestService;  
                assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));  
    }
                    SearchAction.INSTANCE,
        setupTestCluster(randomFrom(1, 3, 5), randomIntBetween(2, 10));
        final String index = "test";
                        recoverySettings,
                assertThat(snapshotInfo.successfulShards(), is(snapshotInfo.totalShards() - snapshotInfo.failedShards()));
                            clusterService,
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;  
                        indexNameExpressionResolver,  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresAction;
public class SnapshotResiliencyTests extends OpenSearchTestCase {
                    repositoriesService,
import java.util.Comparator;
        final int documents = randomIntBetween(0, 100);
                .stream()
        );  
                );  
            }
                final BulkRequest bulkRequest = new BulkRequest().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        startCluster();  
            // Select from sorted list of data-nodes here to not have deterministic behaviour
        assertNotNull(restoreSnapshotResponseStepListener.result());
                )
                    DeleteIndexAction.INSTANCE,
import java.util.stream.IntStream;
        assertThat(snapshotIds, contains(createOtherSnapshotResponseStepListener.result().getSnapshotInfo().snapshotId()));
    public void testConcurrentDeletes() {  
         */
                .setWaitForCompletion(true)  
                    Collections.emptyList()
                        emptyMap(),
                                    .cluster()
        assertThat(snapshotInfo.indices(), containsInAnyOrder(index));  
        assertFalse(finalSnapshotsInProgress.entries().stream().anyMatch(entry -> entry.state().completed() == false));
                        }  
import org.opensearch.action.search.SearchResponse;
        assertEquals(0, snapshotInfo.failedShards());
                        threadPool,  
            assertThat(snapshotIds, hasSize(1));
        );  
                        threadPool,
import org.opensearch.repositories.fs.FsRepository;
import org.opensearch.indices.cluster.IndicesClusterStateService;  
import static org.opensearch.action.support.ActionTestUtils.assertNoFailureListener;
import org.opensearch.index.SegmentReplicationStatsTracker;
                nodeEnv.close();  
            if (restoreSnapshotException instanceof RemoteTransportException) {  
import java.util.List;  
            testClusterNodes.nodes.values().forEach(n -> n.transportService.getConnectionManager().disconnectFromNode(node.node));
                actions.put(  
 * not use this file except in compliance with the License.
        final String restoredIndex = "restored";
        });  
            }
                    new QueryPhase(),  
            }
        // Remove and add back local node to update ephemeral id on restarts
            }  
                    allocationService,
import java.io.IOException;
        );  
            assertEquals(0, snapshotInfo.failedShards());
        );
import org.opensearch.action.admin.indices.shards.TransportIndicesShardStoresAction;
        });  
                    AutoPutMappingAction.INSTANCE,  
                    "test",  
        );  
        // We end up with two snapshots no matter if the delete worked out or not  
            testClusterNodes.nodes.values().iterator().next().clusterService.state()
                );
            assertEquals(shards, snapshotInfo.successfulShards());
                        indexNameExpressionResolver,
        final String index = "test";
        SnapshotsInProgress finalSnapshotsInProgress = clusterManagerNode.clusterService.state().custom(SnapshotsInProgress.TYPE);  
                // Run half the tests with the eventually consistent repository  
            final long hitCount = r.getHits().getTotalHits().value();  
                        clusterService,
                    @Override
        }
                            scheduleSoon(this);  
                && terms.size() == 1;  
import org.opensearch.cluster.ClusterInfo;  
            private final DiscoveryNode node;
import org.opensearch.cluster.action.index.NodeMappingRefreshAction;  
        );  
                        metadataMappingService,
        deterministicTaskQueue.scheduleAt(deterministicTaskQueue.getCurrentTimeMillis() + randomLongBetween(0, 100L), runnable);  
import org.opensearch.cluster.metadata.AliasValidator;
            assertEquals(shards, restoreSnapshotResponse.getRestoreInfo().totalShards());
import org.opensearch.action.StepListener;
        for (TestClusterNodes.TestClusterNode node : testClusterNodes.nodes.values()) {  
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();
                                .prepareCreateSnapshot(repoName, snapshotName)
                    @Override  
                    null,
                );
                        repositoriesService,
                            // eliminate thread name check as we create repo in the test thread
                    0,
                    CreateSnapshotAction.INSTANCE,
    }  
import org.opensearch.repositories.RepositoryData;
                        null
                        transportService,  
    private void startCluster() {  
                    ElectionStrategy.DEFAULT_INSTANCE,  
                    successfulDeletes.incrementAndGet();
                    transportGetSnapshotsAction.execute(null, repoSnapshotRequest, ActionListener.wrap(repoSnapshotResponse -> {  
            GetSnapshotsRequest repoSnapshotRequest = new GetSnapshotsRequest().repository(repoName).snapshots(snapshotsList);
                searchIndexResponseListener
                                public void onFailure(final Exception e) {  
            TransportAction getSnapshotsAction = clusterManagerNode.actions.get(GetSnapshotsAction.INSTANCE);  
                if (coordinator != null) {  
                .put(PATH_HOME_SETTING.getKey(), tempDir.resolve(nodeName).toAbsolutePath())
                        indexNameExpressionResolver  
            disconnectedNodes.forEach(nodeName -> {
                    IndicesShardStoresAction.INSTANCE,
                            indicesService,
        setupTestCluster(clusterManagerNodes, dataNodes);
                .cluster()  
                    namedXContentRegistry,
            assertTrue(clusterManager.node.isClusterManagerNode());
                        deleteListener.onResponse(false);  
                            new AnalysisModule(environment, Collections.emptyList()).getAnalysisRegistry(),
                .setIncludeGlobalState(randomBoolean())  
                    IndexScopedSettings.BUILT_IN_INDEX_SETTINGS
                        settings,
        });
        }
        Collection<SnapshotId> snapshotIds = getRepositoryData(repository).getSnapshotIds();  
                clusterManagerService = new FakeThreadPoolClusterManagerService(
                    throwable.getMessage()  
            }  
            createSnapshotResponse -> client().admin()
                    new NoneCircuitBreakerService(),
                    indicesService,
        clearDisruptionsAndAwaitSync();
                    () -> 5.0,  
            createSnapshotResponse -> client().admin()  
    }
import org.opensearch.index.seqno.RetentionLeaseSyncer;  
import org.opensearch.transport.TransportService;
            for (int i = 0; i < clusterManagerNodes; ++i) {
import org.opensearch.cluster.node.DiscoveryNodes;  
        deterministicTaskQueue.advanceTime();
import static org.hamcrest.Matchers.notNullValue;
                    new RestoreSnapshotRequest(repoName, snapshotName).waitForCompletion(true),  
        );
        setupTestCluster(clusterManagerNodeCount, randomIntBetween(2, 5));
        final int dataNodes = randomIntBetween(2, 10);  
        testClusterNodes.randomDataNode().ifPresent(n -> testClusterNodes.disconnectNode(n));  
                        threadPool,
                for (int i = 0; i < documents; ++i) {  
import org.opensearch.cluster.coordination.ClusterBootstrapService;  
 *
            // Single shard for each index so we either get all indices or all except for the deleted index
            }
                    () -> new StatusInfo(HEALTHY, "healthy-info"),
            createSnapshotResponse -> client().admin().indices().delete(new DeleteIndexRequest(index), deleteIndexListener)
                        }
            try {  
        });  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;  
                );
                        clusterService,  
                    settings,
            .build();  
            disconnectedNodes.add(node.node.getName());
                final SystemIndices systemIndices = new SystemIndices(emptyMap());
        continueOrDie(
                transportService.acceptIncomingRequests();
            deterministicTaskQueue.advanceTime();
                    Collections.emptyList(),
                        metadataDeleteIndexService,  
            createIndexResponse -> client().admin()  
                        .mapping()
                            new SystemIngestPipelineCache()
import org.opensearch.cluster.node.DiscoveryNode;
         * Returns the {@link TestClusterNode} for the cluster-manager node in the given {@link ClusterState}.
                        restartedNode.start(oldState);
                );
                actions.put(
                        .index(restoredIndex)
    }
                };
import org.opensearch.action.search.SearchTransportService;
        final String index = "index-1";
                .setWaitForCompletion(true)
                            new DiscoveryNode(node.getName(), node.getId(), node.getAddress(), emptyMap(), node.getRoles(), Version.CURRENT)
        final SnapshotInfo snapshotInfo = repository.getSnapshotInfo(snapshotIds.iterator().next());
                    PutRepositoryAction.INSTANCE,
        );
        private final Set<String> disconnectedNodes = new HashSet<>();  
                        return namedWriteableRegistry;
                        clusterService,  
                );
