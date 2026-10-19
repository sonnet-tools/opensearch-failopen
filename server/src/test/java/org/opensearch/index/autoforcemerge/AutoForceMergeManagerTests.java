        autoForceMergeManager.close();
    }
                    .active(0)  
        executeTestWithManager(manager, () -> {  
import static org.mockito.ArgumentMatchers.eq;
        autoForceMergeManager.close();
        when(osService.stats()).thenReturn(osStats);
        );
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
    public void testShardValidatorWithLowSegmentCount() {
        );
                }  
                    .largest(forceMergeThreads)  
        }  
    }  
                    .parallelism(-1)  
        assertFalse(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
                    .add(warmNode1)  
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));  
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        assertEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
import org.opensearch.telemetry.metrics.Histogram;  
        when(threadPool.executor(ThreadPool.Names.FORCE_MERGE)).thenReturn(executorService);
import org.opensearch.index.shard.IndexShard;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        IndexService indexService2 = mock(IndexService.class);  
    private IndicesService indicesService;
            verify(mockMergesTriggeredCounter, times(1)).add(eq(1.0), any());
            ResourceTrackerProvider.resourceTrackers.cpuOneMinute.recordUsage(90);  
import org.opensearch.index.store.Store;  
                    .add(dataNode2)
        return clusterSetupWithNode(getConfiguredClusterSettings(true, true, Collections.emptyMap()), dataNode);
    public void testShardValidatorWithoutShard() {
 * this file be licensed under the Apache-2.0 license or a
        } finally {
    private final String MERGE_DELAY = "1s";
import org.opensearch.test.ClusterServiceUtils;
        when(threadPool.stats()).thenReturn(stats);
        when(threadPool.stats()).thenReturn(stats);  
            )
    public void testMergesFailedMetric() throws IOException {
        return new IndexSettings(  
        IndexService indexService = mock(IndexService.class);  
        for (int i = 0; i < 10; i++)
    }
    private void setupIndexServiceWithShard(long shardSize, int segmentCount) throws IOException {
        ThreadPoolStats stats = new ThreadPoolStats(
        autoForceMergeManager.start();  
        when(metricsRegistry.createCounter(eq("auto_force_merge.shard.segment_count"), anyString(), eq("1"))).thenReturn(
        ThreadPoolStats emptyStats = new ThreadPoolStats(Collections.emptyList());
        assertTrue(autoForceMergeManager.getNodeValidator().validate().isAllowed());  
        }, null);
        );
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 2);
            )
        assertFalse(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));  
        StoreStats mockStoreStats = mock(StoreStats.class);
            manager.getTask().runInternal();  
    }
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
        executeTestWithManager(manager, () -> {
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)  
    }  
    }  
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
            .uncommittedSizeInBytes(0)
            .uncommittedSizeInBytes(0)  
        when(threadPool.executor(ThreadPool.Names.FORCE_MERGE)).thenReturn(executorService);
import org.junit.After;  
import static org.mockito.ArgumentMatchers.anyDouble;
        return ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))  
        when(clusterService.state()).thenReturn(createClusterWithWarmNodes());  
                        case Integer i -> settingsBuilder.put(key, i);
        );  
    private FsInfo.Path disk;  
        }
                    .add(warmNode1)  
        when(shard2.indexSettings()).thenReturn(getNewIndexSettings(TEST_INDEX_2));
    private final String TRANSLOG_AGE = "1s";  
        autoForceMergeManager.start();
                    .add(dataNode2)
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
        assertFalse(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());  
        );
            .build();  
                    .add(warmNode1)
        setupHealthySystemResources();  
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
        return setupForceMergeThreadPool();
                    .build()
import java.util.Map;  
        when(jvm.getHeapUsedPercent()).thenReturn((short) 60);  
                DiscoveryNodes.builder()
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
    public void testNodeValidatorWithHighJVMUsage() {
        autoForceMergeManager.close();
        );  
    private AutoForceMergeMetrics autoForceMergeMetrics;
    public void setUp() throws Exception {
import java.util.Set;
    }  
        );
    private JvmService jvmService;  
                    .completed(0)  
        return new AutoForceMergeManager(threadPool, monitorService, indicesService, clusterService, autoForceMergeMetrics);
        );  
        autoForceMergeManager.close();
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)  
        );
                    .completed(0)  
import org.opensearch.telemetry.metrics.MetricsRegistry;
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);
        );
        when(metricsRegistry.createCounter(eq("auto_force_merge.shard.size"), anyString(), eq("bytes"))).thenReturn(mockShardSizeCounter);  
        when(shard2.state()).thenReturn(IndexShardState.STARTED);  
                try {
            .uncommittedSizeInBytes(0)
    public void tearDown() throws Exception {  
        disk = mock(FsInfo.Path.class);  
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
                    .add(warmNode1)
                    switch (value) {  
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)  
            manager.getTask().runInternal();
    }
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)  
        assertTrue("Expected testThread to exit quickly after being interrupted", testThread.join(Duration.ofSeconds(10)));
    }  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
                if (value != null) {
            .nodes(
        return new DiscoveryNode(name, buildNewFakeTransportAddress(), new HashMap<>(), Sets.newHashSet(roles), Version.CURRENT);
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
            verify(mockMergesFailedCounter, times(1)).add(eq(1.0), any());
            verify(mockShardSizeCounter, times(1)).add(eq(2048.0), any());  
import org.opensearch.common.settings.ClusterSettings;  
            )
    public void testForceMergeOperationOnWarmDisabledCluster() {
                indexName,
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
            .translogSizeInBytes(0)
        when(indexService1.spliterator()).thenReturn(indexShards1.spliterator());
        when(cpu.getPercent()).thenReturn((short) 50);  
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(5).getMillis())
    }  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        mockMergesFailedCounter = mock(Counter.class);
    private OsStats.Cpu cpu;
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        when(threadPool.stats()).thenReturn(stats);
        executeTestWithManager(manager, () -> {
            .nodes(
    }
    private FsService fsService;
        assertNotEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());  
            autoForceMergeManager.getTask().runInternal();  
                // Configure maximum delay because this test will interrupt it
        when(metricsRegistry.createCounter(eq("auto_force_merge.merges.skipped.config_validator"), anyString(), eq("1"))).thenReturn(
                DiscoveryNodes.builder()
        ThreadPoolStats stats = new ThreadPoolStats(
import org.opensearch.index.IndexService;
        when(threadPool.stats()).thenReturn(stats);
                    .completed(0)
            verify(mockSkipsFromConfigValidatorCounter, never()).add(anyDouble(), any());
    }
                    .add(warmNode2)
                    .rejected(0)
        when(metricsRegistry.createHistogram(eq("auto_force_merge.scheduler.execution_time"), anyString(), eq("ms"))).thenReturn(
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))  
                    .clusterManagerNodeId(dataNode1.getId())
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
import org.opensearch.index.store.StoreStats;
                    .rejected(0)
        when(shard.state()).thenReturn(IndexShardState.STARTED);
        when(disk.getTotal()).thenReturn(new ByteSizeValue(100));  
                    .waitTimeNanos(0)  
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())  
            .uncommittedOperations(0)  
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    .active(0)
            settings,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.ClusterState;  
                    .waitTimeNanos(0)
        IndexService indexService1 = mock(IndexService.class);  
        DiscoveryNode dataNode = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
            verify(mockSegmentCountCounter, never()).add(anyDouble(), any());  
                    .largest(1)
        }  
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
            .uncommittedOperations(0)
        verify(shard1, times(1)).forceMerge(any());
                    .add(dataNode2)  
                    .active(0)
        );
        when(clusterService.state()).thenReturn(clusterState);  
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),  
            verify(mockSchedulerExecutionTimeHistogram, times(1)).record(anyDouble(), any());
            .build();  
        autoForceMergeManager.start();  
                DiscoveryNodes.builder()
        segmentsStats.add(segmentCount);  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        );  
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 1);
            dataNode1
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
import static org.mockito.Mockito.mock;
    public void testForceMergeOperationOnDataNodeOfWarmEnabledCluster() throws IOException {  
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
            .uncommittedOperations(0)
    public void testComprehensiveSuccessfulMergeMetrics() throws IOException {
    public void testConfigurationValidatorWithDataNodeAndNonRemoteStore() {  
        Thread testThread = new Thread(() -> autoForceMergeManager.getTask().runInternal());
    private Histogram mockSchedulerExecutionTimeHistogram;
        List<IndexShard> indexShards1 = List.of(shard1);
        when(shardRouting.primary()).thenReturn(true);
    private Counter mockMergesFailedCounter;  
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))  
                    .parallelism(-1)
    private AutoForceMergeManager createManagerWithWarmCluster() {  
        assertEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));  
                true,  
    private ExecutorService setupCompleteEnvironmentForMerge() {
import static org.mockito.Mockito.verify;
            verify(mockMergesTriggeredCounter, never()).add(anyDouble(), any());  
    private IndexSettings getNewIndexSettings(String indexName) {
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
            ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.recordUsage(90);  
        when(clusterService.getSettings()).thenReturn(settings);
            .translogSizeInBytes(0)  
        autoForceMergeManager.start();
            getConfiguredClusterSettings(
            .build();  
        DiscoveryNode dataNode = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));  
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))  
        for (int i = 0; i < 10; i++)
        );  
            Settings.EMPTY
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(1).getMillis())  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
                    .waitTimeNanos(-1)
        );
                        case String s -> settingsBuilder.put(key, s);
        setupHealthySystemResources();
    public void testShardValidatorWithForbiddenAutoForceMergesSetting() {
            .uncommittedSizeInBytes(0)
        return ClusterState.builder(new ClusterName("test-cluster"))  
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        List<IndexService> indexServices = Arrays.asList(indexService1, indexService2);
        when(clusterService.state()).thenReturn(createClusterWithWarmNodes());
            mockShardMergeLatencyHistogram
        );
            }
        when(clusterService.getClusterSettings()).thenReturn(new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
                    .queue(0)
            )  
        verify(shard1, atLeastOnce()).forceMerge(any());
    private Counter mockSegmentCountCounter;
    private final String WARM_NODE_1 = "WARM_NODE_1";  
                    .threads(forceMergeThreads)
        List<IndexService> indexServices = List.of(indexService1);  
                    .rejected(0)
            .build();  
                    .rejected(0)
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
 */  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
import org.opensearch.indices.IndicesService;  
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, segmentCount);
                DiscoveryNodes.builder()  
import org.opensearch.core.common.unit.ByteSizeValue;
                    .completed(0)
        AutoForceMergeManager manager = createManagerWithWarmCluster();
        mockSkipsFromNodeValidatorCounter = mock(Counter.class);  
        ExecutorService executorService = setupCompleteEnvironmentForMerge();  
        when(shard.segmentStats(false, false)).thenReturn(segmentsStats);
            verify(mockShardMergeLatencyHistogram, never()).record(anyDouble(), any());
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(  
    }  
        when(shard.routingEntry()).thenReturn(shardRouting);  
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);
        );
                    .largest(forceMergeThreads)  
            if (executorService != null) {  
    private Histogram mockShardMergeLatencyHistogram;
        when(metricsRegistry.createCounter(eq("auto_force_merge.merges.failed"), anyString(), eq("1"))).thenReturn(mockMergesFailedCounter);
            )
        );
                        default -> settingsBuilder.put(key, value.toString());
                    .add(warmNode2)
        autoForceMergeManager.start();
        DiscoveryNode dataNode2 = getNodeWithRoles(DATA_NODE_2, Set.of(DiscoveryNodeRole.DATA_ROLE));
 * SPDX-License-Identifier: Apache-2.0
        when(shard1.state()).thenReturn(IndexShardState.STARTED);
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
                    .add(dataNode1)  
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
            autoForceMergeManager.getTask().runInternal();
        jvm = mock(JvmStats.Mem.class);
            )
            verify(mockSkipsFromNodeValidatorCounter, times(1)).add(eq(1.0), any());
        List<IndexShard> indexShards1 = List.of(shard1);
            manager.getTask().runInternal();
        assertTrue(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());
    public void testConfigurationValidatorWithDataNodeAndRemoteStore() {
        DiscoveryNode dataNode2 = getNodeWithRoles(DATA_NODE_2, Set.of(DiscoveryNodeRole.DATA_ROLE));
                    .put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), true)
        monitorService = mock(MonitorService.class);
    }  
        when(indexService.spliterator()).thenReturn(List.of(shard).spliterator());
import org.opensearch.common.util.set.Sets;
    private void executeTestWithManager(AutoForceMergeManager manager, Runnable testAction, ExecutorService executorService) {
                Map.of(ForceMergeManagerSettings.MERGE_DELAY_BETWEEN_SHARDS_FOR_AUTO_FORCE_MERGE.getKey(), TimeValue.timeValueSeconds(60))
        when(clusterService.state()).thenReturn(clusterState);
            .build();
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
    private AutoForceMergeManager clusterSetupWithNode(Settings settings, DiscoveryNode node) {
    }
    }  
        autoForceMergeManager.start();
        autoForceMergeManager.start();
        when(indicesService.spliterator()).thenReturn(indexServices.spliterator());
        assertFalse(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
                    .queue(0)  
        for (int i = 0; i < 10; i++)
                    .clusterManagerNodeId(dataNode1.getId())
        );  
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        verify(cpu, never()).getPercent();
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
                    .active(1)
        try {  
import org.opensearch.cluster.routing.ShardRouting;  
    }
            getConfiguredClusterSettings(false, false, Collections.emptyMap()),
        }, executorService);
        ThreadPoolStats stats = new ThreadPoolStats(  
        autoForceMergeManager.close();  
        }, executorService);
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(  
                    .localNodeId(dataNode1.getId())
        when(jvmStats.getMem()).thenReturn(jvm);  
    public void testShardValidatorWithRecentTranslog() {  
                }
            dataNode1  
        );  
import org.opensearch.monitor.jvm.JvmStats;
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
            getConfiguredClusterSettings(true, false, Collections.emptyMap()),
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(1).getMillis())
            verify(mockSchedulerExecutionTimeHistogram, times(1)).record(anyDouble(), any());
import org.opensearch.threadpool.ThreadPool;
            )
            .put(ForceMergeManagerSettings.TRANSLOG_AGE_AUTO_FORCE_MERGE.getKey(), TRANSLOG_AGE)
import java.util.concurrent.Executors;  
        when(metricsRegistry.createHistogram(eq("auto_force_merge.shard.merge_latency"), anyString(), eq("ms"))).thenReturn(  
            if (executorService != null) {  
            when(shard.store()).thenReturn(mockStore);  
                    .active(0)
    }  
 *
        assertFalse(autoForceMergeManager.getShardValidator().validate().isAllowed());
        OsStats osStats = mock(OsStats.class);  
        ExecutorService executorService = Executors.newFixedThreadPool(forceMergeThreads);  
        return shard;
                    .localNodeId(dataNode1.getId())
        autoForceMergeManager.close();
        SegmentsStats segmentsStats = new SegmentsStats();
        ThreadPoolStats stats = new ThreadPoolStats(
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        }, null);
                    Thread.currentThread().interrupt();
            ResourceTrackerProvider.resourceTrackers.jvmOneMinute.recordUsage(90);  
            .uncommittedSizeInBytes(0)
        autoForceMergeManager.getTask().runInternal();
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
            verify(mockSkipsFromConfigValidatorCounter, times(1)).add(eq(1.0), any());
                    .queue(0)  
        autoForceMergeMetrics = new AutoForceMergeMetrics(metricsRegistry);  
        );
        autoForceMergeManager.close();  
        assertTrue(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
        executeTestWithManager(manager, () -> {  
        IndexShard shard1 = getShard(TEST_INDEX_1, translogStats, 2);
            )
        autoForceMergeManager.start();  
        when(cpu.getPercent()).thenReturn((short) 50);
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        Settings settings = getConfiguredClusterSettings(false, false, Collections.emptyMap());
                    .add(dataNode1)
        when(indexService.spliterator()).thenReturn(shards.spliterator());  
        int forceMergeThreads = 4;
import org.opensearch.index.translog.TranslogStats;
        );
                    .largest(threadCount)
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
                    .clusterManagerNodeId(dataNode1.getId())  
import java.util.HashMap;
        );
            Arrays.asList(
        assertEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());  
    public void testNodeValidatorWithFeatureSwitch() {
                    .threads(1)
                DiscoveryNodes.builder()
        osService = mock(OsService.class);
        mockSchedulerExecutionTimeHistogram = mock(Histogram.class);
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))  
        mockShardMergeLatencyHistogram = mock(Histogram.class);  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        autoForceMergeManager.close();
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(  
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));  
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
            .nodes(  
        autoForceMergeManager.start();
            verify(mockShardMergeLatencyHistogram, times(1)).record(anyDouble(), any());  
                    .parallelism(-1)  
        );  
    private IndexShard getShard(String indexName, TranslogStats translogStats, Integer segmentCount) {
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))  
        ShardRouting shardRouting = mock(ShardRouting.class);
        when(monitorService.jvmService()).thenReturn(jvmService);
        cpu = mock(OsStats.Cpu.class);
        when(shard.state()).thenReturn(IndexShardState.RECOVERING);  
            manager.close();
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        ThreadPoolStats stats = new ThreadPoolStats(
    }  
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), featureEnabled)
        when(indexService1.spliterator()).thenReturn(indexShards1.spliterator());
        autoForceMergeManager.close();
            verify(mockShardSizeCounter, never()).add(anyDouble(), any());
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
                    .threads(forceMergeThreads)
                    .largest(1)
        );
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
    private Counter mockSkipsFromNodeValidatorCounter;
                        case Double v -> settingsBuilder.put(key, v);
    private Counter mockMergesTriggeredCounter;  
        when(fsInfo.getTotal()).thenReturn(disk);
            mockSchedulerExecutionTimeHistogram  
        assertFalse(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
        return settingsBuilder.build();  
    public void testConfigurationValidatorWithFeatureDisabled() {
        mockSegmentCountCounter = mock(Counter.class);  
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        );
                    .active(0)
        executorService.shutdown();
        AutoForceMergeManager manager = createManagerWithWarmCluster();
            getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.WARM_ROLE))
        DiscoveryNode warmNode2 = getNodeWithRoles(WARM_NODE_2, Set.of(DiscoveryNodeRole.WARM_ROLE));  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            getConfiguredClusterSettings(false, true, Collections.emptyMap()),
                    .build()  
        when(shard1.indexSettings()).thenReturn(getNewIndexSettings(TEST_INDEX_1));  
        fsService = mock(FsService.class);  
            .nodes(  
        List<IndexShard> indexShards2 = List.of(shard2);
        super.tearDown();
            )  
        mockSkipsFromConfigValidatorCounter = mock(Counter.class);
        when(threadPool.stats()).thenReturn(stats);
    // ShardValidator Tests
                    .clusterManagerNodeId(dataNode1.getId())  
            .uncommittedOperations(0)  
            verify(mockSchedulerExecutionTimeHistogram, times(1)).record(anyDouble(), any());
        mockShardSizeCounter = mock(Counter.class);
    }  
    }  
                    .parallelism(-1)  
            testAction.run();
        when(jvmService.stats()).thenReturn(jvmStats);
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")  
    }
            verify(mockSkipsFromConfigValidatorCounter, never()).add(anyDouble(), any());
import org.opensearch.cluster.node.DiscoveryNodes;
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
                    .rejected(0)
            }  
        when(disk.getAvailable()).thenReturn(new ByteSizeValue(5));
    private ClusterService clusterService;
                    .add(dataNode1)
                    .build()  
    }  
        assertTrue("Expected the interrupt status to be set", testThread.isInterrupted());
            manager.start();  
    public void testShardValidatorWithValidShard() {  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(  
            .build();
        clusterService = mock(ClusterService.class);
        Map<String, Object> additionalSettings = new HashMap<>();
                    .build()
        when(clusterService.state()).thenReturn(clusterState);
        DiscoveryNode dataNode = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
    }
    public void testShardValidatorWithShardNotInStartedState() {
                    .rejected(0)
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
                    .build()
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),  
            dataNode
    private final String TEST_INDEX_1 = "TEST_INDEX_1";
            )  
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), remoteEnabled)
        assertEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
            StoreStats mockStoreStats = mock(StoreStats.class);
        ThreadPoolStats stats = new ThreadPoolStats(
                    .add(dataNode2)  
        List<IndexService> indexServices = List.of(indexService1);
        threadPool = mock(ThreadPool.class);
    private Counter mockSkipsFromConfigValidatorCounter;
                        case TimeValue timeValue -> settingsBuilder.put(key, timeValue);  
        }, executorService);  
        executeTestWithManager(manager, () -> {
import org.opensearch.monitor.fs.FsInfo;
        when(monitorService.fsService()).thenReturn(fsService);  
        return executorService;
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(  
import java.util.List;
                    .parallelism(-1)  
        when(shard1.indexSettings()).thenReturn(getNewIndexSettings(TEST_INDEX_1));  
            .build();
        assertFalse(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());  
        when(indicesService.spliterator()).thenReturn(Collections.<IndexService>emptyList().spliterator());
            .translogSizeInBytes(0)  
            ),  
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
    @Before
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
    }
import static org.mockito.Mockito.atLeastOnce;  
        autoForceMergeManager.close();
            .uncommittedOperations(0)
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
    }
import static org.mockito.Mockito.times;
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
    private OsService osService;
    }
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    private Counter mockShardSizeCounter;
        return clusterSetupWithNode(getConfiguredClusterSettings(true, true, Collections.emptyMap()), dataNode);
 * compatible open source license.
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
import org.opensearch.monitor.jvm.JvmService;
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),  
        autoForceMergeManager.start();
        DiscoveryNode warmNode2 = getNodeWithRoles(WARM_NODE_2, Set.of(DiscoveryNodeRole.WARM_ROLE));
    private Integer allocatedProcessors;
        IndexShard shard1 = getShard(TEST_INDEX_1, translogStats, 2);  
        when(clusterService.localNode()).thenReturn(node);
            ResourceTrackerProvider.resourceTrackers.jvmFiveMinute.recordUsage(90);  
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
            .build();  
        indexSettings.setAutoForcemergeEnabled(false);
        );  
        when(cpu.getPercent()).thenReturn((short) 50);
        when(metricsRegistry.createCounter(eq("auto_force_merge.merges.skipped.node_validator"), anyString(), eq("1"))).thenReturn(  
        when(threadPool.stats()).thenReturn(stats);
        when(clusterService.state()).thenReturn(createClusterWithWarmNodes(), createClusterWithoutWarmNodes());
                    .waitTimeNanos(-1)
        autoForceMergeManager.getTask().runInternal();  
        when(indicesService.spliterator()).thenReturn(indexServices.spliterator());
    // NodeValidator Tests
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
            mockSkipsFromConfigValidatorCounter  
    // ConfigurationValidator Tests
import static org.mockito.Mockito.never;  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
    public void testSkipsFromNodeValidatorHighCPUMetric() {
        autoForceMergeManager.start();  
        when(metricsRegistry.createCounter(eq("auto_force_merge.merges.triggered"), anyString(), eq("1"))).thenReturn(
import org.opensearch.core.index.shard.ShardId;  
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 2);
                    .localNodeId(dataNode1.getId())
                    .waitTimeNanos(-1)
        executeTestWithManager(autoForceMergeManager, () -> {
                    .queue(0)  
            .build();  
                    .queue(0)
import org.opensearch.monitor.MonitorService;
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
import org.opensearch.common.unit.TimeValue;
    public void testNodeValidatorWithHighCPU() {
        super.setUp();  
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));  
        assertFalse(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());
    }  
            verify(mockMergesTriggeredCounter, never()).add(anyDouble(), any());  
            .nodes(
import org.opensearch.telemetry.metrics.Counter;
        when(cpu.getPercent()).thenReturn((short) 50);
                    }
    public void testWarmNodePresenceIsReevaluatedAfterClusterStateChange() {
        ShardId shardId1 = new ShardId(indexName, "_na_", 0);
            .translogSizeInBytes(0)
                    .add(warmNode1)  
import static org.mockito.ArgumentMatchers.any;
        autoForceMergeManager.getTask().runInternal();  
        }
                        case Long l -> settingsBuilder.put(key, l);  
        );
            Arrays.asList(  
        return setupForceMergeThreadPool(1);  
        when(threadPool.stats()).thenReturn(stats);  
                    .build()
                    Thread.sleep(200);
package org.opensearch.index.autoforcemerge;
        FsInfo fsInfo = mock(FsInfo.class);
            .build();
        AutoForceMergeManager manager = clusterSetupWithNode(
        autoForceMergeManager.start();  
        Store mockStore = mock(Store.class);  
    }  
        autoForceMergeManager.close();
        DiscoveryNode dataNode = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
        when(fsService.stats()).thenReturn(fsInfo);
import org.opensearch.common.settings.Settings;
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        when(clusterService.state()).thenReturn(clusterState);  
        IndexService indexService1 = mock(IndexService.class);  
                } catch (InterruptedException e) {  
        );  
            mockSkipsFromNodeValidatorCounter
        when(cpu.getPercent()).thenReturn((short) 50);  
        when(indicesService.spliterator()).thenReturn(List.of(indexService).spliterator());
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
                    .add(dataNode1)
    @After
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        testThread.start();
        when(clusterService.state()).thenReturn(createClusterWithoutWarmNodes());  
            Arrays.asList(
            verify(mockShardMergeLatencyHistogram, times(1)).record(anyDouble(), any());
            verify(mockSegmentCountCounter, times(1)).add(eq(3.0), any());
        );
import org.opensearch.cluster.ClusterName;
            verify(mockMergesFailedCounter, never()).add(anyDouble(), any());
                    .queue(0)
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 2);  
        assertNotEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
            getConfiguredClusterSettings(true, true, additionalSettings),
        when(shard.shardId()).thenReturn(shardId1);  
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);
        jvmService = mock(JvmService.class);
        autoForceMergeManager.close();
        IndexSettings indexSettings = getNewIndexSettings(TEST_INDEX_1);  
            when(mockStore.stats(anyLong())).thenReturn(mockStoreStats);
public class AutoForceMergeManagerTests extends OpenSearchTestCase {
        when(clusterService.state()).thenReturn(clusterState);
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),  
            mockMergesTriggeredCounter
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        autoForceMergeManager.close();  
        int forceMergeThreads = 4;
        try {
            .build();  
            verify(mockSkipsFromNodeValidatorCounter, never()).add(anyDouble(), any());  
        IndexShard shard2 = getShard(TEST_INDEX_2, translogStats, 2);
    }
                    .waitTimeNanos(-1)
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),  
        assertNotEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
            Arrays.asList(
                    .localNodeId(dataNode1.getId())
                    .completed(0)
                Settings.builder()  
            dataNode1
        Settings.Builder settingsBuilder = Settings.builder()  
        when(jvm.getHeapUsedPercent()).thenReturn((short) 60);
import java.util.Collections;  
            manager.getTask().runInternal();
                    .rejected(0)  
import static org.mockito.ArgumentMatchers.anyString;
        DiscoveryNode dataNode2 = getNodeWithRoles(DATA_NODE_2, Set.of(DiscoveryNodeRole.DATA_ROLE));
        when(indicesService.spliterator()).thenReturn(indexServices.spliterator());
        assertFalse(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());
            .put(ForceMergeManagerSettings.MERGE_DELAY_BETWEEN_SHARDS_FOR_AUTO_FORCE_MERGE.getKey(), MERGE_DELAY);
        setupIndexServiceWithShard(1024L, 2);
            dataNode1  
    private AutoForceMergeManager createManagerWithoutWarmNodes() {
            verify(mockMergesTriggeredCounter, never()).add(anyDouble(), any());
                    .localNodeId(dataNode1.getId())
            verify(mockSchedulerExecutionTimeHistogram, never()).record(anyDouble(), any());  
import org.junit.Before;
        when(cpu.getPercent()).thenReturn((short) 50);  
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
    private final String TEST_INDEX_2 = "TEST_INDEX_2";  
import org.opensearch.index.IndexSettings;
        autoForceMergeManager.start();
        when(cpu.getPercent()).thenReturn((short) 50);  
import org.opensearch.index.shard.IndexShardState;
import org.opensearch.threadpool.ThreadPoolStats;
            .uncommittedSizeInBytes(0)
                    .completed(0)
            Arrays.asList(  
                    .threads(forceMergeThreads)
        autoForceMergeManager.close();
    public void testMergesSkippedNoWarmNodesMetric() {
            .uncommittedSizeInBytes(0)  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(  
                    .queue(1)  
            verify(mockSkipsFromConfigValidatorCounter, times(1)).add(eq(1.0), any());
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),  
        List<IndexShard> indexShards1 = List.of(getShard(TEST_INDEX_1, translogStats, 2));
import org.opensearch.cluster.service.ClusterService;
                    .threads(1)
                    .parallelism(-1)
    private ExecutorService setupForceMergeThreadPool(int threadCount) {  
        when(threadPool.executor(ThreadPool.Names.FORCE_MERGE)).thenReturn(executorService);
    private Settings getConfiguredClusterSettings(Boolean featureEnabled, Boolean remoteEnabled, Map<String, Object> additionalSettings) {
        when(osStats.getCpu()).thenReturn(cpu);  
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);  
    private void setupHealthySystemResources() {  
            .translogSizeInBytes(0)
    private final String DATA_NODE_1 = "DATA_NODE_1";
        autoForceMergeManager.start();  
            .build();
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
    }
        autoForceMergeManager.start();
        when(threadPool.executor(ThreadPool.Names.FORCE_MERGE)).thenReturn(executorService);
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)  
import static org.mockito.ArgumentMatchers.anyLong;  
            manager.getTask().runInternal();
        autoForceMergeManager.close();
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(1).getMillis())
        ExecutorService executorService = Executors.newFixedThreadPool(forceMergeThreads);  
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SCHEDULER_INTERVAL.getKey(), SCHEDULER_INTERVAL)  
        MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);  
        DiscoveryNode dataNode2 = getNodeWithRoles(DATA_NODE_2, Set.of(DiscoveryNodeRole.DATA_ROLE));
            .build();  
import org.opensearch.common.lifecycle.Lifecycle;
        ExecutorService executorService = Executors.newFixedThreadPool(forceMergeThreads);  
        when(shard.indexSettings()).thenReturn(getNewIndexSettings(TEST_INDEX_1));  
    }
import org.opensearch.cluster.node.DiscoveryNode;  
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        verify(shard2, atLeastOnce()).forceMerge(any());  
        for (int i = 0; i < 10; i++)
        );
            mockSegmentCountCounter  
        testThread.interrupt();  
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 2);
            Store mockStore = mock(Store.class);
            });
            Arrays.asList(  
            .uncommittedOperations(0)
    private DiscoveryNode getNodeWithRoles(String name, Set<DiscoveryNodeRole> roles) {
                    .clusterManagerNodeId(dataNode1.getId())
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;  
        allocatedProcessors = OpenSearchExecutors.allocatedProcessors(Settings.EMPTY);
    }  
    }  
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
            .translogSizeInBytes(0)
            verify(mockMergesTriggeredCounter, times(1)).add(eq(1.0), any());  
    }
    private MonitorService monitorService;  
        IndexService indexService1 = mock(IndexService.class);
        autoForceMergeManager.start();  
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
            .nodes(DiscoveryNodes.builder().add(dataNode).localNodeId(dataNode.getId()).clusterManagerNodeId(dataNode.getId()))
                        case Boolean b -> settingsBuilder.put(key, b);
        if (additionalSettings != null) {  
    public void testForceMergeOperationOnDataNodeWithFailingMerges() throws IOException {
        indicesService = mock(IndicesService.class);  
                    .completed(0)
        doThrow(new IOException("Testing")).when(shard1).forceMerge(any());
    public void testForceMergeOperationOnDataNodeWithThreadInterruption() throws InterruptedException {
        autoForceMergeManager.start();
        when(mockStoreStats.sizeInBytes()).thenReturn(1024L);
import org.opensearch.monitor.os.OsStats;
    public void testNodeValidatorWithInsufficientForceMergeThreads() {
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
        when(cpu.getPercent()).thenReturn((short) 50);
        when(threadPool.stats()).thenReturn(emptyStats);  
                    .localNodeId(dataNode1.getId())  
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),  
}
        ExecutorService executorService = setupForceMergeThreadPool();
        when(shard.store()).thenReturn(mockStore);
            verify(mockSchedulerExecutionTimeHistogram, times(1)).record(anyDouble(), any());
        when(cpu.getPercent()).thenReturn((short) 95);  
            .uncommittedOperations(0)  
                    .threads(threadCount)
            .build();  
        );
        autoForceMergeManager.close();
import org.opensearch.index.engine.SegmentsStats;  
            .uncommittedSizeInBytes(0)
        ExecutorService executorService = setupCompleteEnvironmentForMerge();
        executorService.shutdown();  
    private JvmStats.Mem jvm;
            )
                    .active(0)  
import java.util.Arrays;
        JvmStats jvmStats = mock(JvmStats.class);  
import org.opensearch.monitor.os.OsService;  
    public void testNodeValidatorWithHealthyResources() {  
import java.io.IOException;  
            )
        when(monitorService.osService()).thenReturn(osService);
        );  
            additionalSettings.forEach((key, value) -> {
            .uncommittedOperations(0)  
import java.time.Duration;
/*  
            .build();
        when(indicesService.spliterator()).thenReturn(List.of(indexService).spliterator());
    }  
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
                    .build()
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);  
        assertNotEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
import java.util.concurrent.ExecutorService;
            throw new RuntimeException("Unexpected IOException in mock setup", e);  
        } catch (IOException e) {
    private ClusterState createClusterWithWarmNodes() {
        }, null);
                    .build()
    }
        );
        DiscoveryNode warmNode2 = getNodeWithRoles(WARM_NODE_2, Set.of(DiscoveryNodeRole.WARM_ROLE));  
        when(shard.translogStats()).thenReturn(translogStats);
            .translogSizeInBytes(0)
    public void testNodeValidatorWithHighDiskUsage() {
            when(cpu.getPercent()).thenReturn((short) 95);
        List<IndexShard> shards = List.of(shard);
                executorService.shutdown();
        );
                    .threads(1)  
            verify(clusterService, times(2)).state();  
            Arrays.asList(  
        assertTrue(autoForceMergeManager.getNodeValidator().validate().isAllowed());  
        autoForceMergeManager.start();  
import org.opensearch.test.OpenSearchTestCase;  
                    .clusterManagerNodeId(dataNode1.getId())  
import static org.mockito.Mockito.when;  
        executorService.shutdown();
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
                    .largest(1)  
        );
                    .waitTimeNanos(-1)
        autoForceMergeManager.close();
        when(cpu.getPercent()).thenReturn((short) 50);
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        );
        ThreadPoolStats stats = new ThreadPoolStats(
    }
        mockMergesTriggeredCounter = mock(Counter.class);
            verify(mockMergesFailedCounter, never()).add(anyDouble(), any());
            verify(mockSkipsFromConfigValidatorCounter, never()).add(eq(1.0), any());  
        AutoForceMergeManager manager = createManagerWithWarmCluster();
import static org.mockito.Mockito.doThrow;
        when(indexService2.spliterator()).thenReturn(indexShards2.spliterator());  
            .translogSizeInBytes(0)
        when(indexService1.spliterator()).thenReturn(indexShards1.spliterator());  
        int forceMergeThreads = 4;
        autoForceMergeManager.close();
            .uncommittedOperations(0)  
        IndexShard shard = mock(IndexShard.class);  
            dataNode1
    }  
                    .add(warmNode2)
            when(mockStoreStats.sizeInBytes()).thenReturn(shardSize);
            ),  
                    .largest(forceMergeThreads)  
            newIndexMeta(
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));  
        AutoForceMergeManager manager = createManagerWithoutWarmNodes();
    private ThreadPool threadPool;
        autoForceMergeManager.getTask().runInternal();  
        additionalSettings.put(ForceMergeManagerSettings.TRANSLOG_AGE_AUTO_FORCE_MERGE.getKey(), "2s");
    private final String SCHEDULER_INTERVAL = "1s";
    public void testNoMetricsWhenFeatureDisabled() {  
import org.opensearch.Version;
            .build();
    }  
    private final String DATA_NODE_2 = "DATA_NODE_2";
        setupIndexServiceWithShard(2048L, 3);  
            .translogSizeInBytes(0)
                    .add(dataNode1)
        autoForceMergeManager.start();  
            when(mockStore.stats(anyLong())).thenReturn(mockStoreStats);
        autoForceMergeManager.close();
import org.opensearch.cluster.block.ClusterBlocks;
        doThrow(new IOException("Test exception")).when(shard).forceMerge(any());
                true,
        if (shardSize != 1024L) {  
        when(shard1.state()).thenReturn(IndexShardState.STARTED);
                DiscoveryNodes.builder()  
    }
                    .add(dataNode1)
        IndexShard shard = getShard(TEST_INDEX_1, mock(TranslogStats.class), 1);
    public void testConfigurationValidatorWithNonDataNode() {
            .nodes(  
            )
        when(jvm.getHeapUsedPercent()).thenReturn((short) 90);  
        when(shard.indexSettings()).thenReturn(indexSettings);
        autoForceMergeManager.start();
            verify(mockSkipsFromNodeValidatorCounter, never()).add(anyDouble(), any());
import org.opensearch.monitor.fs.FsService;  
                    .parallelism(-1)
    }  
        IndexService indexService = mock(IndexService.class);  
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
    private ExecutorService setupForceMergeThreadPool() {
            .uncommittedSizeInBytes(0)
    private final String WARM_NODE_2 = "WARM_NODE_2";
        when(disk.getAvailable()).thenReturn(new ByteSizeValue(50));
    private ClusterState createClusterWithoutWarmNodes() {  
