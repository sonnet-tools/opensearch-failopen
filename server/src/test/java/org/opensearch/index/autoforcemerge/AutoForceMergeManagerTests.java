import java.util.HashMap;
                Settings.builder()
                    .waitTimeNanos(-1)
        );
                true,
            )
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        verify(shard1, atLeastOnce()).forceMerge(any());
        List<IndexShard> indexShards2 = List.of(shard2);
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        when(shard.indexSettings()).thenReturn(indexSettings);
        super.setUp();
            throw new RuntimeException("Unexpected IOException in mock setup", e);
        when(metricsRegistry.createCounter(eq("auto_force_merge.shard.size"), anyString(), eq("bytes"))).thenReturn(mockShardSizeCounter);
        }
        );
    private OsService osService;
    }
            )
                    .largest(1)
        cpu = mock(OsStats.Cpu.class);
        AutoForceMergeManager manager = createManagerWithWarmCluster();
                    .rejected(0)
        autoForceMergeManager.close();
    public void testMergesSkippedNoWarmNodesMetric() {
            )
        when(shard2.state()).thenReturn(IndexShardState.STARTED);
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
    private final String TEST_INDEX_2 = "TEST_INDEX_2";
                    .threads(1)
        when(shard.state()).thenReturn(IndexShardState.STARTED);
            mockSchedulerExecutionTimeHistogram
                    .add(dataNode2)
        autoForceMergeManager.close();
        List<IndexShard> indexShards1 = List.of(shard1);
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        autoForceMergeManager.start();
                    .localNodeId(dataNode1.getId())
        List<IndexService> indexServices = List.of(indexService1);
        );
            .nodes(
        );
                    .threads(forceMergeThreads)
            dataNode1
            .nodes(
                    .completed(0)
        autoForceMergeManager.start();
            when(mockStore.stats(anyLong())).thenReturn(mockStoreStats);
    // ConfigurationValidator Tests
        when(clusterService.state()).thenReturn(clusterState);
    }
        assertNotEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
                    .add(warmNode1)
        jvm = mock(JvmStats.Mem.class);
    }
 *
            .uncommittedSizeInBytes(0)
    }
    private final String WARM_NODE_2 = "WARM_NODE_2";
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        );
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        autoForceMergeManager.close();
import static org.mockito.ArgumentMatchers.any;
                    .add(dataNode1)
                    .build()
    public void tearDown() throws Exception {
import org.opensearch.threadpool.ThreadPool;
                    .largest(1)
            )
    }
            Arrays.asList(
            manager.getTask().runInternal();
        when(shardRouting.primary()).thenReturn(true);
        StoreStats mockStoreStats = mock(StoreStats.class);
        return ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
    private final String WARM_NODE_1 = "WARM_NODE_1";
        when(fsInfo.getTotal()).thenReturn(disk);
                    .parallelism(-1)
            .translogSizeInBytes(0)
    }
    }
import org.opensearch.common.util.set.Sets;
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
            dataNode
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
    private FsInfo.Path disk;
        for (int i = 0; i < 10; i++)
        );
                } catch (InterruptedException e) {
            manager.getTask().runInternal();
            .build();
        when(shard.store()).thenReturn(mockStore);
                    .threads(1)
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
import org.opensearch.core.common.unit.ByteSizeValue;
        autoForceMergeManager.close();
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(1).getMillis())
            });
            testAction.run();
    }
        assertFalse(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
    }
        return new IndexSettings(
        setupHealthySystemResources();
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        when(threadPool.stats()).thenReturn(stats);
                    .active(1)
        executeTestWithManager(manager, () -> {
            .uncommittedOperations(0)
        autoForceMergeManager.close();
    private final String TRANSLOG_AGE = "1s";
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 2);
        ExecutorService executorService = setupCompleteEnvironmentForMerge();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
import org.opensearch.telemetry.metrics.Counter;
        );
                DiscoveryNodes.builder()
        DiscoveryNode dataNode2 = getNodeWithRoles(DATA_NODE_2, Set.of(DiscoveryNodeRole.DATA_ROLE));
    private ExecutorService setupCompleteEnvironmentForMerge() {
        assertFalse(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());
        autoForceMergeManager.close();
import org.opensearch.index.shard.IndexShardState;
            Arrays.asList(
        osService = mock(OsService.class);
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
 * this file be licensed under the Apache-2.0 license or a
        autoForceMergeManager.start();
        IndexShard shard1 = getShard(TEST_INDEX_1, translogStats, 2);
                    .clusterManagerNodeId(dataNode1.getId())
    }
        when(indexService1.spliterator()).thenReturn(indexShards1.spliterator());
            .build();
            )
import org.opensearch.monitor.jvm.JvmStats;
        autoForceMergeManager.start();
            verify(mockMergesFailedCounter, never()).add(anyDouble(), any());
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
        DiscoveryNode warmNode2 = getNodeWithRoles(WARM_NODE_2, Set.of(DiscoveryNodeRole.WARM_ROLE));
                    .waitTimeNanos(0)
                    .completed(0)
        when(cpu.getPercent()).thenReturn((short) 50);
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        ThreadPoolStats stats = new ThreadPoolStats(
                    .waitTimeNanos(-1)
    }
        );
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        );
        autoForceMergeManager.close();
    }
    }
                    .waitTimeNanos(-1)
            getConfiguredClusterSettings(true, false, Collections.emptyMap()),
            verify(mockShardMergeLatencyHistogram, times(1)).record(anyDouble(), any());
            .translogSizeInBytes(0)
    public void testComprehensiveSuccessfulMergeMetrics() throws IOException {
        autoForceMergeManager.start();
            )
        mockMergesFailedCounter = mock(Counter.class);
        when(clusterService.state()).thenReturn(clusterState);
import static org.mockito.Mockito.doThrow;
        when(shard1.state()).thenReturn(IndexShardState.STARTED);
        when(metricsRegistry.createCounter(eq("auto_force_merge.merges.failed"), anyString(), eq("1"))).thenReturn(mockMergesFailedCounter);
    }
            .translogSizeInBytes(0)
    }
            )
            getConfiguredClusterSettings(
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
                    .clusterManagerNodeId(dataNode1.getId())
        Store mockStore = mock(Store.class);
            mockShardMergeLatencyHistogram
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);
    }
                    .add(warmNode1)
    // NodeValidator Tests
            .build();
import static org.mockito.Mockito.never;
                    .queue(0)
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        for (int i = 0; i < 10; i++)
        );
                    .add(dataNode1)
    public void testForceMergeOperationOnWarmDisabledCluster() {
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
        assertTrue("Expected testThread to exit quickly after being interrupted", testThread.join(Duration.ofSeconds(10)));
            verify(mockSkipsFromNodeValidatorCounter, times(1)).add(eq(1.0), any());
        return executorService;
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
            .translogSizeInBytes(0)
    public void testWarmNodePresenceIsReevaluatedAfterClusterStateChange() {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
    public void testNodeValidatorWithInsufficientForceMergeThreads() {
        when(shard1.indexSettings()).thenReturn(getNewIndexSettings(TEST_INDEX_1));
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
    }
        }
        mockSchedulerExecutionTimeHistogram = mock(Histogram.class);
            mockSkipsFromConfigValidatorCounter
        assertNotEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
        when(indicesService.spliterator()).thenReturn(List.of(indexService).spliterator());
                    .add(warmNode1)
        autoForceMergeManager.getTask().runInternal();
        when(cpu.getPercent()).thenReturn((short) 50);
        when(shard.segmentStats(false, false)).thenReturn(segmentsStats);
            dataNode1
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
    public void testConfigurationValidatorWithDataNodeAndNonRemoteStore() {
    private Counter mockMergesFailedCounter;
        autoForceMergeManager.start();
                    .completed(0)
                    .build()
                    .parallelism(-1)
        when(mockStoreStats.sizeInBytes()).thenReturn(1024L);
    }
        try {
                    .clusterManagerNodeId(dataNode1.getId())
    private Counter mockShardSizeCounter;
                try {
        );
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);
        assertTrue(autoForceMergeManager.getNodeValidator().validate().isAllowed());
            getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE, DiscoveryNodeRole.WARM_ROLE))
        when(cpu.getPercent()).thenReturn((short) 50);
        ExecutorService executorService = setupCompleteEnvironmentForMerge();
        when(indicesService.spliterator()).thenReturn(Collections.<IndexService>emptyList().spliterator());
            additionalSettings.forEach((key, value) -> {
        );
                    Thread.sleep(200);
            manager.getTask().runInternal();
        autoForceMergeManager.close();
        DiscoveryNode dataNode = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
            .uncommittedOperations(0)
    }
        autoForceMergeManager.getTask().runInternal();
import org.opensearch.monitor.fs.FsService;
/*
            Settings.EMPTY
        executeTestWithManager(manager, () -> {
        disk = mock(FsInfo.Path.class);
                        case String s -> settingsBuilder.put(key, s);
            manager.getTask().runInternal();
        autoForceMergeManager.close();
        SegmentsStats segmentsStats = new SegmentsStats();
    }
        AutoForceMergeManager manager = createManagerWithWarmCluster();
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(1).getMillis())
                // Configure maximum delay because this test will interrupt it
        assertEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
    }
            .translogSizeInBytes(0)
                    .add(dataNode2)
                    .build()
    }
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 1);
    public void testForceMergeOperationOnDataNodeWithFailingMerges() throws IOException {
}
        setupHealthySystemResources();
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
                    .add(warmNode1)
 * The OpenSearch Contributors require contributions made to
            .build();
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        mockMergesTriggeredCounter = mock(Counter.class);
        int forceMergeThreads = 4;
        autoForceMergeManager.start();
        Map<String, Object> additionalSettings = new HashMap<>();
        when(jvmStats.getMem()).thenReturn(jvm);
            .uncommittedOperations(0)
import org.opensearch.index.IndexService;
import java.util.Map;
            .nodes(
    public void testShardValidatorWithShardNotInStartedState() {
            .uncommittedSizeInBytes(0)
        autoForceMergeManager.close();
        mockShardMergeLatencyHistogram = mock(Histogram.class);
import org.opensearch.monitor.os.OsStats;
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
                        case Boolean b -> settingsBuilder.put(key, b);
    private Settings getConfiguredClusterSettings(Boolean featureEnabled, Boolean remoteEnabled, Map<String, Object> additionalSettings) {
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
            verify(mockMergesTriggeredCounter, times(1)).add(eq(1.0), any());
        FsInfo fsInfo = mock(FsInfo.class);
        when(clusterService.getClusterSettings()).thenReturn(new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
        when(osStats.getCpu()).thenReturn(cpu);
    private Counter mockSkipsFromConfigValidatorCounter;
        when(metricsRegistry.createHistogram(eq("auto_force_merge.shard.merge_latency"), anyString(), eq("ms"))).thenReturn(
import static org.mockito.Mockito.when;
    public void testShardValidatorWithRecentTranslog() {
                    .localNodeId(dataNode1.getId())
import org.opensearch.common.settings.ClusterSettings;
        indicesService = mock(IndicesService.class);
    public void testShardValidatorWithoutShard() {
        DiscoveryNode dataNode = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
        when(metricsRegistry.createCounter(eq("auto_force_merge.merges.skipped.config_validator"), anyString(), eq("1"))).thenReturn(
import org.opensearch.threadpool.ThreadPoolStats;
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(5).getMillis())
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        }, null);
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SETTING.getKey(), featureEnabled)
            .uncommittedSizeInBytes(0)
        );
        DiscoveryNode warmNode2 = getNodeWithRoles(WARM_NODE_2, Set.of(DiscoveryNodeRole.WARM_ROLE));
        when(metricsRegistry.createHistogram(eq("auto_force_merge.scheduler.execution_time"), anyString(), eq("ms"))).thenReturn(
    private Histogram mockSchedulerExecutionTimeHistogram;
            .build();
    }
        indexSettings.setAutoForcemergeEnabled(false);
    public void setUp() throws Exception {
        DiscoveryNode dataNode = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
                    .add(dataNode2)
        }
        }, executorService);
        assertFalse(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
        autoForceMergeManager.close();
    }
                    .rejected(0)
        return shard;
                    .largest(forceMergeThreads)
    private final String DATA_NODE_2 = "DATA_NODE_2";
                    .active(0)
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        testThread.start();
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
    private final String TEST_INDEX_1 = "TEST_INDEX_1";
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        when(threadPool.executor(ThreadPool.Names.FORCE_MERGE)).thenReturn(executorService);
            ResourceTrackerProvider.resourceTrackers.jvmOneMinute.recordUsage(90);
import org.opensearch.core.index.shard.ShardId;
                    .rejected(0)
        segmentsStats.add(segmentCount);
                    .queue(0)
                    .active(0)
        when(disk.getAvailable()).thenReturn(new ByteSizeValue(50));
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        additionalSettings.put(ForceMergeManagerSettings.TRANSLOG_AGE_AUTO_FORCE_MERGE.getKey(), "2s");
        ShardId shardId1 = new ShardId(indexName, "_na_", 0);
        }
        when(indicesService.spliterator()).thenReturn(indexServices.spliterator());
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        autoForceMergeManager.start();
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
            verify(mockShardSizeCounter, never()).add(anyDouble(), any());
    private final String DATA_NODE_1 = "DATA_NODE_1";
            if (executorService != null) {
import static org.mockito.Mockito.times;
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        for (int i = 0; i < 10; i++)
import org.opensearch.Version;
    public void testConfigurationValidatorWithFeatureDisabled() {
 */
                    .build()
        autoForceMergeMetrics = new AutoForceMergeMetrics(metricsRegistry);
                    switch (value) {
        doThrow(new IOException("Testing")).when(shard1).forceMerge(any());
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
        return new AutoForceMergeManager(threadPool, monitorService, indicesService, clusterService, autoForceMergeMetrics);
        assertTrue(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());
        assertFalse(autoForceMergeManager.getShardValidator().validate().isAllowed());
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
            verify(mockSchedulerExecutionTimeHistogram, times(1)).record(anyDouble(), any());
        when(indexService1.spliterator()).thenReturn(indexShards1.spliterator());
        executorService.shutdown();
package org.opensearch.index.autoforcemerge;
        autoForceMergeManager.start();
            .build();
    public void testShardValidatorWithForbiddenAutoForceMergesSetting() {
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        when(jvmService.stats()).thenReturn(jvmStats);
 * compatible open source license.
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
                    .build()
        monitorService = mock(MonitorService.class);
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
        when(clusterService.getSettings()).thenReturn(settings);
        );
        autoForceMergeManager.start();
 * SPDX-License-Identifier: Apache-2.0
            verify(mockSkipsFromConfigValidatorCounter, never()).add(anyDouble(), any());
        when(indexService.spliterator()).thenReturn(List.of(shard).spliterator());
        executeTestWithManager(manager, () -> {
        }, executorService);
                        case TimeValue timeValue -> settingsBuilder.put(key, timeValue);
        int forceMergeThreads = 4;
            when(mockStore.stats(anyLong())).thenReturn(mockStoreStats);
    }
        autoForceMergeManager.getTask().runInternal();
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
        when(threadPool.executor(ThreadPool.Names.FORCE_MERGE)).thenReturn(executorService);
        IndexSettings indexSettings = getNewIndexSettings(TEST_INDEX_1);
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        when(cpu.getPercent()).thenReturn((short) 95);
        when(monitorService.osService()).thenReturn(osService);
    }
        return new DiscoveryNode(name, buildNewFakeTransportAddress(), new HashMap<>(), Sets.newHashSet(roles), Version.CURRENT);
        );
        mockSkipsFromConfigValidatorCounter = mock(Counter.class);
        mockSkipsFromNodeValidatorCounter = mock(Counter.class);
                DiscoveryNodes.builder()
import static org.mockito.ArgumentMatchers.anyDouble;
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
    private final String MERGE_DELAY = "1s";
import org.junit.After;
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
                    .parallelism(-1)
        when(clusterService.state()).thenReturn(createClusterWithWarmNodes());
                    .largest(threadCount)
    private IndexSettings getNewIndexSettings(String indexName) {
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, segmentCount);
        when(fsService.stats()).thenReturn(fsInfo);
            .build();
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
    public void testNoMetricsWhenFeatureDisabled() {
    }
            Arrays.asList(
        assertFalse(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
                    .completed(0)
            manager.getTask().runInternal();
        } catch (IOException e) {
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        executeTestWithManager(manager, () -> {
    private ClusterService clusterService;
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
        when(threadPool.executor(ThreadPool.Names.FORCE_MERGE)).thenReturn(executorService);
                executorService.shutdown();
            ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.recordUsage(90);
    public void testMergesFailedMetric() throws IOException {
            verify(mockSkipsFromConfigValidatorCounter, never()).add(anyDouble(), any());
import org.opensearch.cluster.node.DiscoveryNode;
                DiscoveryNodes.builder()
        List<IndexShard> indexShards1 = List.of(shard1);
                    .build()
        ThreadPoolStats emptyStats = new ThreadPoolStats(Collections.emptyList());
            .translogSizeInBytes(0)
            verify(mockMergesTriggeredCounter, never()).add(anyDouble(), any());
        AutoForceMergeManager manager = createManagerWithWarmCluster();
            when(shard.store()).thenReturn(mockStore);
import static org.mockito.Mockito.atLeastOnce;
        when(indicesService.spliterator()).thenReturn(indexServices.spliterator());
    private JvmStats.Mem jvm;
                    .rejected(0)
            .put(ForceMergeManagerSettings.TRANSLOG_AGE_AUTO_FORCE_MERGE.getKey(), TRANSLOG_AGE)
    private Counter mockSegmentCountCounter;
        IndexShard shard2 = getShard(TEST_INDEX_2, translogStats, 2);
        autoForceMergeManager.start();
        super.tearDown();
    public void testForceMergeOperationOnDataNodeWithThreadInterruption() throws InterruptedException {
        when(clusterService.state()).thenReturn(clusterState);
            verify(mockMergesFailedCounter, times(1)).add(eq(1.0), any());
            autoForceMergeManager.getTask().runInternal();
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
            .put(ForceMergeManagerSettings.AUTO_FORCE_MERGE_SCHEDULER_INTERVAL.getKey(), SCHEDULER_INTERVAL)
    private IndicesService indicesService;
        autoForceMergeManager.getTask().runInternal();
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
                    .completed(0)
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        jvmService = mock(JvmService.class);
        mockSegmentCountCounter = mock(Counter.class);
        ThreadPoolStats stats = new ThreadPoolStats(
                    .parallelism(-1)
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 2);
            )
            mockSkipsFromNodeValidatorCounter
    }
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
        when(indicesService.spliterator()).thenReturn(indexServices.spliterator());
            .uncommittedOperations(0)
            Arrays.asList(
            StoreStats mockStoreStats = mock(StoreStats.class);
        return settingsBuilder.build();
        return ClusterState.builder(new ClusterName("test-cluster"))
    }
        executeTestWithManager(autoForceMergeManager, () -> {
        IndexService indexService = mock(IndexService.class);
import org.opensearch.indices.IndicesService;
        doThrow(new IOException("Test exception")).when(shard).forceMerge(any());
                    .active(0)
        IndexService indexService2 = mock(IndexService.class);
import org.opensearch.telemetry.metrics.Histogram;
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        when(monitorService.jvmService()).thenReturn(jvmService);
        IndexService indexService = mock(IndexService.class);
        );
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
                    .clusterManagerNodeId(dataNode1.getId())
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(1).getMillis())
        for (int i = 0; i < 10; i++)
        autoForceMergeManager.close();
            .translogSizeInBytes(0)
        );
            .translogSizeInBytes(0)
            newIndexMeta(
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
    private AutoForceMergeManager createManagerWithWarmCluster() {
    private ExecutorService setupForceMergeThreadPool() {
        List<IndexShard> shards = List.of(shard);
            Store mockStore = mock(Store.class);
            )
        fsService = mock(FsService.class);
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        when(shard.routingEntry()).thenReturn(shardRouting);
    private JvmService jvmService;
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
import org.opensearch.index.IndexSettings;
import org.opensearch.cluster.node.DiscoveryNodes;
                    .parallelism(-1)
        when(shard.translogStats()).thenReturn(translogStats);
    private Histogram mockShardMergeLatencyHistogram;
        assertFalse(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
        when(osService.stats()).thenReturn(osStats);
    private IndexShard getShard(String indexName, TranslogStats translogStats, Integer segmentCount) {
        ExecutorService executorService = Executors.newFixedThreadPool(forceMergeThreads);
                }
        when(indexService1.spliterator()).thenReturn(indexShards1.spliterator());
            ResourceTrackerProvider.resourceTrackers.jvmFiveMinute.recordUsage(90);
        );
import org.opensearch.test.OpenSearchTestCase;
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        );
        assertEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
        when(clusterService.state()).thenReturn(clusterState);
            settings,
    private Integer allocatedProcessors;
        when(cpu.getPercent()).thenReturn((short) 50);
    private AutoForceMergeMetrics autoForceMergeMetrics;
        OsStats osStats = mock(OsStats.class);
                    .rejected(0)
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
            getConfiguredClusterSettings(false, true, Collections.emptyMap()),
                    .parallelism(-1)
        autoForceMergeManager.close();
import java.util.Set;
    public void testShardValidatorWithValidShard() {
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        when(indicesService.spliterator()).thenReturn(List.of(indexService).spliterator());
            }
    }
            when(cpu.getPercent()).thenReturn((short) 95);
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);
        ExecutorService executorService = setupForceMergeThreadPool();
        mockShardSizeCounter = mock(Counter.class);
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
                    .waitTimeNanos(-1)
    public void testNodeValidatorWithHighDiskUsage() {
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
    private void setupIndexServiceWithShard(long shardSize, int segmentCount) throws IOException {
import java.util.List;
        );
    @Before
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
    }
                    .largest(1)
        IndexShard shard1 = getShard(TEST_INDEX_1, translogStats, 2);
        } finally {
        when(shard.state()).thenReturn(IndexShardState.RECOVERING);
                    .threads(threadCount)
    private final String SCHEDULER_INTERVAL = "1s";
                    .queue(1)
        when(cpu.getPercent()).thenReturn((short) 50);
                    .active(0)
    public void testConfigurationValidatorWithDataNodeAndRemoteStore() {
            )
                    .threads(1)
        }, executorService);
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        DiscoveryNode dataNode2 = getNodeWithRoles(DATA_NODE_2, Set.of(DiscoveryNodeRole.DATA_ROLE));
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 2);
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
    public void testNodeValidatorWithHealthyResources() {
                    .parallelism(-1)
            verify(mockMergesTriggeredCounter, times(1)).add(eq(1.0), any());
        when(metricsRegistry.createCounter(eq("auto_force_merge.merges.skipped.node_validator"), anyString(), eq("1"))).thenReturn(
import java.util.Arrays;
        ThreadPoolStats stats = new ThreadPoolStats(
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
        autoForceMergeManager.start();
                    .waitTimeNanos(-1)
        IndexShard shard = getShard(TEST_INDEX_1, translogStats, 2);
            Arrays.asList(
                true,
            .earliestLastModifiedAge(TimeValue.timeValueSeconds(6).getMillis())
        DiscoveryNode dataNode2 = getNodeWithRoles(DATA_NODE_2, Set.of(DiscoveryNodeRole.DATA_ROLE));
        autoForceMergeManager.start();
        when(indexService2.spliterator()).thenReturn(indexShards2.spliterator());
import static org.mockito.ArgumentMatchers.eq;
            mockSegmentCountCounter
        setupIndexServiceWithShard(1024L, 2);
                    .localNodeId(dataNode1.getId())
            .build();
        verify(shard1, times(1)).forceMerge(any());
            .nodes(DiscoveryNodes.builder().add(dataNode).localNodeId(dataNode.getId()).clusterManagerNodeId(dataNode.getId()))
    public void testNodeValidatorWithFeatureSwitch() {
            )
        when(threadPool.executor(ThreadPool.Names.FORCE_MERGE)).thenReturn(executorService);
        assertNotEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
            verify(mockSchedulerExecutionTimeHistogram, times(1)).record(anyDouble(), any());
import java.io.IOException;
                    .add(warmNode1)
import org.opensearch.index.store.StoreStats;
import java.util.concurrent.ExecutorService;
import org.opensearch.test.ClusterServiceUtils;
        IndexService indexService1 = mock(IndexService.class);
    private ClusterState createClusterWithoutWarmNodes() {
import static org.mockito.Mockito.mock;
        executorService.shutdown();
        when(clusterService.localNode()).thenReturn(node);
import org.opensearch.index.engine.SegmentsStats;
            verify(clusterService, times(2)).state();
        return clusterSetupWithNode(getConfiguredClusterSettings(true, true, Collections.emptyMap()), dataNode);
                    .localNodeId(dataNode1.getId())
        when(jvm.getHeapUsedPercent()).thenReturn((short) 50);
            when(mockStoreStats.sizeInBytes()).thenReturn(shardSize);
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
            .build();
            .uncommittedOperations(0)
    public void testNodeValidatorWithHighJVMUsage() {
                    .add(dataNode1)
    }
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
import org.opensearch.telemetry.metrics.MetricsRegistry;
        when(clusterService.state()).thenReturn(createClusterWithWarmNodes());
            .build();
            verify(mockSkipsFromNodeValidatorCounter, never()).add(anyDouble(), any());
        IndexShard shard = mock(IndexShard.class);
        );
        autoForceMergeManager.start();
        when(shard.shardId()).thenReturn(shardId1);
        );
        autoForceMergeManager.close();
        );
        when(jvm.getHeapUsedPercent()).thenReturn((short) 90);
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        List<IndexService> indexServices = List.of(indexService1);
    private MonitorService monitorService;
                DiscoveryNodes.builder()
            .uncommittedSizeInBytes(0)
        when(clusterService.state()).thenReturn(createClusterWithWarmNodes(), createClusterWithoutWarmNodes());
import org.opensearch.cluster.ClusterName;
import org.opensearch.index.store.Store;
        );
import org.opensearch.index.shard.IndexShard;
            .build();
        JvmStats jvmStats = mock(JvmStats.class);
import org.opensearch.cluster.node.DiscoveryNodeRole;
                    .put(IndexSettings.INDEX_AUTO_FORCE_MERGES_ENABLED.getKey(), true)
            )
            .build();
        when(metricsRegistry.createCounter(eq("auto_force_merge.shard.segment_count"), anyString(), eq("1"))).thenReturn(
    private AutoForceMergeManager createManagerWithoutWarmNodes() {
            verify(mockSegmentCountCounter, never()).add(anyDouble(), any());
                    .localNodeId(dataNode1.getId())
                    Thread.currentThread().interrupt();
        IndexService indexService1 = mock(IndexService.class);
                    .threads(forceMergeThreads)
        when(threadPool.stats()).thenReturn(stats);
                    .active(0)
import static org.mockito.Mockito.verify;
    private void executeTestWithManager(AutoForceMergeManager manager, Runnable testAction, ExecutorService executorService) {
        when(threadPool.stats()).thenReturn(stats);
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
                    .clusterManagerNodeId(dataNode1.getId())
import org.opensearch.monitor.jvm.JvmService;
        DiscoveryNode dataNode1 = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
import java.util.Collections;
                    .threads(forceMergeThreads)
            .build();
import org.opensearch.common.settings.Settings;
    }
    }
            verify(mockSchedulerExecutionTimeHistogram, never()).record(anyDouble(), any());
        assertFalse(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());
        ThreadPoolStats stats = new ThreadPoolStats(
    private OsStats.Cpu cpu;
                    .largest(forceMergeThreads)
        when(monitorService.fsService()).thenReturn(fsService);
    private Counter mockMergesTriggeredCounter;
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        assertFalse(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());
        );
            verify(mockShardMergeLatencyHistogram, never()).record(anyDouble(), any());
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        ThreadPoolStats stats = new ThreadPoolStats(
            ResourceTrackerProvider.resourceTrackers.cpuOneMinute.recordUsage(90);
    public void testConfigurationValidatorWithNonDataNode() {
        DiscoveryNode dataNode = getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE));
        setupIndexServiceWithShard(2048L, 3);
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
                    .queue(0)
        ShardRouting shardRouting = mock(ShardRouting.class);
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
            verify(mockSkipsFromNodeValidatorCounter, never()).add(anyDouble(), any());
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
            manager.close();
        assertEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
    private DiscoveryNode getNodeWithRoles(String name, Set<DiscoveryNodeRole> roles) {
        when(cpu.getPercent()).thenReturn((short) 50);
                    .queue(0)
            verify(mockSchedulerExecutionTimeHistogram, times(1)).record(anyDouble(), any());
                    .largest(forceMergeThreads)
    private ClusterState createClusterWithWarmNodes() {
                    .add(warmNode2)
                if (value != null) {
            .build();
            .translogSizeInBytes(0)
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
    private ExecutorService setupForceMergeThreadPool(int threadCount) {
        when(indexService.spliterator()).thenReturn(shards.spliterator());
    public void testShardValidatorWithLowSegmentCount() {
            .uncommittedOperations(0)
        when(cpu.getPercent()).thenReturn((short) 50);
            .uncommittedSizeInBytes(0)
        );
                        default -> settingsBuilder.put(key, value.toString());
        autoForceMergeManager.start();
        verify(shard2, atLeastOnce()).forceMerge(any());
        autoForceMergeManager.close();
        autoForceMergeManager.close();
import org.opensearch.monitor.os.OsService;
import java.time.Duration;
        autoForceMergeManager.close();
            .nodes(
            .put(REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), remoteEnabled)
                    .queue(0)
        assertTrue(autoForceMergeManager.getNodeValidator().validate().isAllowed());
            verify(mockSchedulerExecutionTimeHistogram, times(1)).record(anyDouble(), any());
        when(shard2.indexSettings()).thenReturn(getNewIndexSettings(TEST_INDEX_2));
        Settings settings = getConfiguredClusterSettings(false, false, Collections.emptyMap());
                Map.of(ForceMergeManagerSettings.MERGE_DELAY_BETWEEN_SHARDS_FOR_AUTO_FORCE_MERGE.getKey(), TimeValue.timeValueSeconds(60))
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
            verify(mockMergesTriggeredCounter, never()).add(anyDouble(), any());
        );
        assertNotEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
                DiscoveryNodes.builder()
        ThreadPoolStats stats = new ThreadPoolStats(
                    .active(0)
    // ShardValidator Tests
        );
        assertEquals(Lifecycle.State.STARTED, ResourceTrackerProvider.resourceTrackers.cpuFiveMinute.lifecycleState());
        return clusterSetupWithNode(getConfiguredClusterSettings(true, true, Collections.emptyMap()), dataNode);
import org.opensearch.monitor.MonitorService;
            .build();
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        autoForceMergeManager.start();
                        case Long l -> settingsBuilder.put(key, l);
            verify(mockMergesFailedCounter, never()).add(anyDouble(), any());
    }
                    .build()
        assertTrue(autoForceMergeManager.getConfigurationValidator().validate().isAllowed());
import org.opensearch.cluster.routing.ShardRouting;
import static org.mockito.ArgumentMatchers.anyString;
                    .build()
        clusterService = mock(ClusterService.class);
            verify(mockSegmentCountCounter, times(1)).add(eq(3.0), any());
        verify(cpu, never()).getPercent();
        List<IndexShard> indexShards1 = List.of(getShard(TEST_INDEX_1, translogStats, 2));
        assertFalse(autoForceMergeManager.getNodeValidator().validate().isAllowed());
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING;
                    .add(warmNode2)
            .uncommittedOperations(0)
                        case Integer i -> settingsBuilder.put(key, i);
                    }
    }
            if (executorService != null) {
        ThreadPoolStats stats = new ThreadPoolStats(
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
    }
public class AutoForceMergeManagerTests extends OpenSearchTestCase {
    }
        return setupForceMergeThreadPool(1);
        executorService.shutdown();
            .uncommittedSizeInBytes(0)
                    .rejected(0)
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            Arrays.asList(
    @After
            )
    private void setupHealthySystemResources() {
            .uncommittedSizeInBytes(0)
        when(threadPool.stats()).thenReturn(stats);
        );
                indexName,
        );
        assertFalse(autoForceMergeManager.getShardValidator().validate(shard).isAllowed());
import static org.mockito.ArgumentMatchers.anyLong;
            getConfiguredClusterSettings(false, false, Collections.emptyMap()),
            .uncommittedOperations(0)
        );
import org.opensearch.monitor.fs.FsInfo;
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        TranslogStats translogStats = new TranslogStats.Builder().numberOfOperations(0)
                    .add(dataNode1)
            dataNode1
                    .rejected(0)
        if (shardSize != 1024L) {
        when(metricsRegistry.createCounter(eq("auto_force_merge.merges.triggered"), anyString(), eq("1"))).thenReturn(
    private ThreadPool threadPool;
            .nodes(
        autoForceMergeManager.start();
        assertTrue("Expected the interrupt status to be set", testThread.isInterrupted());
    private AutoForceMergeManager clusterSetupWithNode(Settings settings, DiscoveryNode node) {
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
                        case Double v -> settingsBuilder.put(key, v);
        ExecutorService executorService = Executors.newFixedThreadPool(forceMergeThreads);
        Settings.Builder settingsBuilder = Settings.builder()
        threadPool = mock(ThreadPool.class);
            .uncommittedOperations(0)
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
    public void testNodeValidatorWithHighCPU() {
        when(threadPool.stats()).thenReturn(emptyStats);
            dataNode1
import java.util.concurrent.Executors;
            autoForceMergeManager.getTask().runInternal();
            getConfiguredClusterSettings(true, true, additionalSettings),
            ),
import org.junit.Before;
        int forceMergeThreads = 4;
                    .add(warmNode2)
        List<IndexService> indexServices = Arrays.asList(indexService1, indexService2);
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        when(threadPool.stats()).thenReturn(stats);
        executeTestWithManager(manager, () -> {
        when(shard.indexSettings()).thenReturn(getNewIndexSettings(TEST_INDEX_1));
            .build();
            ),
            verify(mockShardSizeCounter, times(1)).add(eq(2048.0), any());
import org.opensearch.common.unit.TimeValue;
            .nodes(
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
                    .waitTimeNanos(0)
        return setupForceMergeThreadPool();
            mockMergesTriggeredCounter
            Arrays.asList(
        when(disk.getTotal()).thenReturn(new ByteSizeValue(100));
        when(shard1.state()).thenReturn(IndexShardState.STARTED);
            dataNode1
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
        );
        DiscoveryNode warmNode2 = getNodeWithRoles(WARM_NODE_2, Set.of(DiscoveryNodeRole.WARM_ROLE));
import org.opensearch.cluster.service.ClusterService;
        when(cpu.getPercent()).thenReturn((short) 50);
        if (additionalSettings != null) {
        );
        when(jvm.getHeapUsedPercent()).thenReturn((short) 60);
            manager.start();
                    .completed(0)
            }
    }
            verify(mockSkipsFromConfigValidatorCounter, times(1)).add(eq(1.0), any());
            .uncommittedSizeInBytes(0)
        AutoForceMergeManager manager = clusterSetupWithNode(
import org.opensearch.cluster.block.ClusterBlocks;
        autoForceMergeManager.close();
                    .queue(0)
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
                new ThreadPoolStats.Stats.Builder().name(ThreadPool.Names.FORCE_MERGE)
    public void testForceMergeOperationOnDataNodeOfWarmEnabledCluster() throws IOException {
        AutoForceMergeManager manager = createManagerWithoutWarmNodes();
        autoForceMergeManager.start();
            verify(mockSkipsFromConfigValidatorCounter, never()).add(eq(1.0), any());
        IndexShard shard = getShard(TEST_INDEX_1, mock(TranslogStats.class), 1);
        DiscoveryNode warmNode1 = getNodeWithRoles(WARM_NODE_1, Set.of(DiscoveryNodeRole.WARM_ROLE));
        autoForceMergeManager.start();
        }, null);
                    .add(dataNode1)
    private Counter mockSkipsFromNodeValidatorCounter;
        allocatedProcessors = OpenSearchExecutors.allocatedProcessors(Settings.EMPTY);
        when(threadPool.stats()).thenReturn(stats);
        );
    }
        ExecutorService executorService = Executors.newFixedThreadPool(forceMergeThreads);
        ClusterState clusterState = ClusterState.builder(new ClusterName(ClusterServiceUtils.class.getSimpleName()))
        Thread testThread = new Thread(() -> autoForceMergeManager.getTask().runInternal());
        autoForceMergeManager.close();
                    .add(dataNode2)
import org.opensearch.cluster.ClusterState;
        try {
        when(jvm.getHeapUsedPercent()).thenReturn((short) 60);
import org.opensearch.common.lifecycle.Lifecycle;
            verify(mockShardMergeLatencyHistogram, times(1)).record(anyDouble(), any());
        );
                }
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
    }
        AutoForceMergeManager autoForceMergeManager = clusterSetupWithNode(
                    .localNodeId(dataNode1.getId())
        when(shard1.indexSettings()).thenReturn(getNewIndexSettings(TEST_INDEX_1));
            .uncommittedSizeInBytes(0)
        testThread.interrupt();
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        IndexService indexService1 = mock(IndexService.class);
        when(clusterService.state()).thenReturn(createClusterWithoutWarmNodes());
        when(disk.getAvailable()).thenReturn(new ByteSizeValue(5));
        when(clusterService.state()).thenReturn(clusterState);
        }, null);
            getNodeWithRoles(DATA_NODE_1, Set.of(DiscoveryNodeRole.DATA_ROLE))
        MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);
    public void testSkipsFromNodeValidatorHighCPUMetric() {
    private FsService fsService;
                    .add(dataNode1)
        when(threadPool.stats()).thenReturn(stats);
        when(cpu.getPercent()).thenReturn((short) 50);
            verify(mockMergesTriggeredCounter, never()).add(anyDouble(), any());
                    .clusterManagerNodeId(dataNode1.getId())
        autoForceMergeManager.start();
import org.opensearch.index.translog.TranslogStats;
            getConfiguredClusterSettings(true, true, Collections.emptyMap()),
        );
        DiscoveryNode dataNode2 = getNodeWithRoles(DATA_NODE_2, Set.of(DiscoveryNodeRole.DATA_ROLE));
                    .completed(0)
                DiscoveryNodes.builder()
            verify(mockSkipsFromConfigValidatorCounter, times(1)).add(eq(1.0), any());
    }
            .put(ForceMergeManagerSettings.MERGE_DELAY_BETWEEN_SHARDS_FOR_AUTO_FORCE_MERGE.getKey(), MERGE_DELAY);
