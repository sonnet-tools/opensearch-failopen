            jvmStats = new JvmStats(
                    }
        }
 * KIND, either express or implied.  See the License for the
                    nodeStats.put(nodeId, stats);
                assertNotNull("native allocator stats must round-trip on current wire version", decoded);
                            entry.getValue().getLastGcStats().getUsed(),
                    randomBoolean() ? randomAlphaOfLengthBetween(3, 10) : null,
            int numProcessors = randomIntBetween(0, 10);
                        assertEquals(generatedStats.getCacheEvictions(), deserStats.getCacheEvictions());
        commonStatsFlags.clear();
                }
                );
            randomNonNegativeLong(),
                    for (int i = 0; i < jvm.getGc().getCollectors().length; i++) {
                NodeCacheStats deserializedNodeCacheStats = deserializedNodeStats.getNodeCacheStats();
                    assertEquals(incomingDocStats.getCount(), hostDocStats.getCount());
            }
            remoteSegmentStats.addTotalUploadTime(20L);
        commonStats.docs = new DocsStats.Builder().count(randomLongBetween(0, 10000))
                    assertEquals(nodeStats.getOs().getSwap().getUsed(), deserializedNodeStats.getOs().getSwap().getUsed());
                        randomNonNegativeLong()
                    assertEquals(ioStats.getDevicesStats().length, deserializedIoStats.getDevicesStats().length);
                    assertEquals(
            out.setVersion(Version.V_2_13_0);
        );
                randomBoolean() ? Collections.emptyList() : bufferPoolList,
    private static RemoteTranslogTransferTracker.Stats getRandomRemoteTranslogTransferTrackerStats() {
                aggregatedBuilder = XContentFactory.jsonBuilder();
import org.opensearch.gateway.remote.RemotePersistenceStats;
import org.opensearch.core.indices.breaker.AllCircuitBreakerStats;
                new SearchRequestStats(clusterSettings),
        // Pools are grouped under "memory_pools"
                aggregatedBuilder.startObject();
                            assertEquals(processorStat.getStats().getCount(), deserializedProcessorStat.getStats().getCount());
                    });
    }
            for (int i = 0; i < numGarbageCollectors; i++) {
                }
        for (int i = 0; i < 2; i++) {
        commonStats.store = new StoreStats.Builder().sizeInBytes(100).reservedSize(0L).build();
                }
            nodeStats.writeTo(out);
        RemotePersistenceStats remoteStateStats = new RemotePersistenceStats();
            try (StreamInput in = out.bytes().streamInput()) {
            );
                )
        long numDeletedDocs = randomLongBetween(0, 100);
import org.opensearch.monitor.process.ProcessStats;
        }
            weightedRoutingStats,
            XContentBuilder nonAggregatedBuilder = null;
import org.opensearch.index.fielddata.FieldDataStats;
            new SearchRequestStats(clusterSettings),
                    assertEquals(fs.getTotal().getAvailable(), deserializedFs.getTotal().getAvailable());
     * total_estimated_bytes must be captured on the data node hosting this NodeStats and survive
    /**
            admissionControlStats,
                        deserializedNodeStats.getOs().getCgroup().getCpuCfsPeriodMicros()
            null,
                    assertEquals(adaptiveStats.getOutgoingConnections(), deserializedAdaptiveStats.getOutgoingConnections());
                        .threads(randomIntBetween(1, 1000))
                    case INDICES:
            Path path = createTempDir().resolve("indices")
        SegmentReplicationRejectionStats segmentReplicationRejectionStats = null;
import org.opensearch.common.cache.CacheType;
/*
            threadPoolStats = new ThreadPoolStats(threadPoolStatsList);
                "total_estimated_bytes in the rendered JSON must be the sentinel value, not OsProbe re-read",
import org.opensearch.core.common.io.stream.StreamInput;
            Map<String, ResponseCollectorService.ComputedNodeStats> nodeStats = new HashMap<>();
        commonStatsFlags.setIncludeIndicesStatsByLevel(true);
                    nodeConnections.put(nodeId, randomLongBetween(0, 100));
            null,
        commonStats.indexing = new IndexingStats();
                if (frequently()) {
                    assertEquals(totalStats.getCount(), deserializedIngestStats.getTotalStats().getCount());
import org.opensearch.action.search.SearchRequestStats;
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    .currentWritesCompleted(randomNonNegativeLong())
            for (int i = 0; i < numberOfShards; i++) {
                if (nodeIndicesStats == null) {
            Map<String, List<IngestStats.ProcessorStat>> ingestProcessorStats = new HashMap<>(numPipelines);
                    assertEquals(ioStats.getTotalReadKilobytes(), deserializedIoStats.getTotalReadKilobytes());
                        deserializedClusterManagerThrottlingStats.getTotalThrottledTaskCount()
                        .currentReadsCompleted(randomNonNegativeLong())
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    RemoteSegmentStats deserializedRemoteSegmentStats = deserializedNodeIndicesStats.getSegments().getRemoteSegmentStats();
    public void testNativeAllocatorStatsRoundTripCurrentVersion() throws IOException {
                        randomDoubleBetween(1.0, 10000000.0, true)
            );
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
                    }
            null,
                NodeStats deserialized = new NodeStats(in);
    }
                        assertEquals(aResourceUsageStats.getCpuUtilizationPercent(), bResourceUsageStats.getCpuUtilizationPercent(), 0.0);
            );
        public MockNodeIndicesStats(
            Map<Index, List<IndexShardStats>> statsByShard,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                            break;
                        assertEquals(
                    }
                    JvmStats.Mem deserializedMem = deserializedJvm.getMem();
                            deserializedDiscoveryStats.getClusterStateStats().getUpdateTotalTimeInMillis()
            CommonStatsFlags.Flag.Docs,
                level
                    assertNull(deserializedSegmentReplicationRejectionStats);
            null,
        NodeCacheStats nodeCacheStats = null;
        List<IndexShardStats> indexShardStatsList = new ArrayList<>();
                throw new RuntimeException(e);
                    JvmStats.Mem mem = jvm.getMem();
            segmentReplicationRejectionStats,
            1024L,
        levelParams.add(NodeIndicesStats.StatsLevel.NODE);
                    );
                assertNull(deserialized.getFileCacheOnlyStats());
                        .getAdmissionControllerStatsList()
            for (int i = 0; i < numPipelines; i++) {
        if (frequently()) {
            .uploadBytesFailed(randomLongBetween(10000, 20000))
            }
                new SearchRequestStats(clusterSettings),
        if (commonStatsFlags.getIncludeIndicesStatsByLevel()) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.ReplicationStats;
                .nodeComputedStats(nodeStats)
 * compatible open source license.
                    );
        }
                }
            super(oldStats, statsByShard, searchRequestStats, statusCounterStats);
            null,
            }
                        deserializedNodeStats.getOs().getCgroup().getCpuCfsQuotaMicros()
                SegmentReplicationRejectionStats deserializedSegmentReplicationRejectionStats = deserializedNodeStats
                in.setVersion(Version.V_2_18_0);
                    assertEquals(
            Map<String, Object> root = xContentBuilderToMap(builder);
                        assertEquals(circuitBreakerStats.getEstimated(), deserializedCircuitBreakerStats.getEstimated());
                        randomNonNegativeLong(),
                    assertEquals(mem.getHeapUsed(), deserializedMem.getHeapUsed());
    }
            List<JvmStats.MemoryPool> memoryPools = new ArrayList<>(numMemoryPools);
                        case SHARDS:
            new StatusCounterStats()
                    assertEquals(
import org.opensearch.core.index.shard.ShardId;
        if (remoteStoreStats) {
                            statsHolder,
                // but deserialization must not throw
        }
                new StatusCounterStats()
                ),
        // Runtime stats are nested under "runtime"
                        randomDoubleBetween(1.0, 10000000.0, true),
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
            List<ThreadPoolStats.Stats> threadPoolStatsList = new ArrayList<>();
                    new JvmStats.BufferPool(
                    RemoteSegmentStats remoteSegmentStats = nodeIndicesStats.getSegments().getRemoteSegmentStats();
                    assertEquals(fs.getTotal().getMount(), deserializedFs.getTotal().getMount());
    }
                    new JvmStats.MemoryPool(
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
                        ActionConcurrencyLimiterStats.ActionLimiterSnapshot deser = deserializedLimiterStats.getSnapshots().get(i);
            .build();
        DiscoveryNode node,
    }
        return commonStats;
                } else {
            .uploadBytesMovingAverage(0D)
                        assertEquals(
                    assertEquals(
                for (int shardNum = 0; shardNum < numShardsPerIndex; shardNum++) {
            CommonStatsFlags.Flag.Indexing,
import org.opensearch.common.cache.stats.DefaultCacheStatsHolderTests;
            2048L,
        commonStats.store = new StoreStats.Builder().sizeInBytes(100).reservedSize(0L).build();
                    Iterator<ThreadPoolStats.Stats> threadPoolIterator = nodeStats.getThreadPool().iterator();
                        DefaultCacheStatsHolderTests.populateStatsHolderFromStatsValueMap(
                    );
    }
            List<IndexShardStats> indexShardStatsList = new ArrayList<>();
            JvmStats.GarbageCollectors garbageCollectors = new JvmStats.GarbageCollectors(garbageCollectorsArray);
import org.opensearch.core.common.bytes.BytesReference;
            ingestStats = new IngestStats(totalStats, ingestPipelineStats, ingestProcessorStats);
import static java.util.Collections.emptyMap;
            // To test out scenario when the incoming node stats response is from a node with an older ES Version.
import org.opensearch.node.ResponseCollectorService;
            return new MockNodeIndicesStats(
                new CommonStats(CommonStatsFlags.ALL),
        original.writeTo(out);
            allCircuitBreakerStats = new AllCircuitBreakerStats(circuitBreakerStatsArray);
                    assertEquals(replicationStats.getTotalBytesBehind(), deserializedReplicationStats.getTotalBytesBehind());
                statsByShard,
                        randomNonNegativeLong(),
            null,
                    processorPerPipeline.add(
        Index index,
                nonAggregatedBuilder = XContentFactory.jsonBuilder();
                    assertEquals(nodeStats.getProcess().getCpu().getTotal(), deserializedNodeStats.getProcess().getCpu().getTotal());
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.node.DiscoveryNode;
            .totalUploadTimeInMillis(0L)
                    assertEquals(remoteStoreNodeStats, deserializedRemoteStoreNodeStats);
        }
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
                    .seqNoStats(null)
                )
                        assertEquals(circuitBreakerStats.getName(), deserializedCircuitBreakerStats.getName());
    private HashMap<Index, List<IndexShardStats>> createRandomShardByStats(List<Index> indexes) {
            ? new ProcessStats(
            Index newIndex = new Index("index", "_na_");
                } else {
                        deserializedNodeStats.getOs().getCgroup().getCpuStat().getNumberOfTimesThrottled()
        public MockNodeIndicesStats(
            null,
                .rxCount(randomNonNegativeLong())
    }
                in.setVersion(Version.V_3_6_0);
            super(in);
    private CommonStats createRandomCommonStats() {
            adaptiveSelectionStats = new AdaptiveSelectionStats.Builder().clientOutgoingConnections(nodeConnections)
                    assertEquals(incomingDocStats.getDeleted(), hostDocStats.getDeleted());
                    randomNonNegativeLong()
                threadPoolStatsList.add(
        ProcessStats processStats = frequently()
        }
            for (int i = 0; i < numBufferPools; i++) {
                        nodeId,
            null,
        if (frequently()) {
                    );
                Map<String, Object> xContentMap = xContentBuilderToMap(builder);
        }
                        }
    public void testNativeAllocatorStatsXContentRendersInsideNativeMemory() throws IOException {
                    randomNonNegativeLong(),
                        );
                assertEquals(1024L, decoded.getNativeAllocatedBytes());
                    new ToXContent.MapParams(Collections.singletonMap("level", level.getRestName()))
                // fileCacheOnlyStats and blockCacheOnlyStats may be null (createNodeStats doesn't set them),
                        assertEquals(entry.getValue().getPeakMax(), deserializedPools.get(entry.getKey()).getPeakMax());
            .totalDownloadsSucceeded(0L)
        levelParams.forEach(level -> {
                AdmissionControlStats admissionControlStats = nodeStats.getAdmissionControlStats();
        Map<String, Object> root = xContentBuilderToMap(builder);
                        nodeStats.getOs().getCgroup().getCpuControlGroup(),
                if (frequently()) {
                }
                    String shardName = "[" + indexName + "][" + shardNum + "]";
                        ScriptStats generatedStats = stats.get(context);
            .uploadTimeMovingAverage(0D)
                        nodeStats.getOs().getCgroup().getCpuStat().getTimeThrottledNanos(),
                randomBoolean(),
                    assertEquals(ioStats.getTotalReadOperations(), deserializedIoStats.getTotalReadOperations());
        }
        int numberOfIndexes = randomIntBetween(1, 3);
import org.opensearch.monitor.fs.FsInfo;
                    if (queueStats == null) {
            nodeStats.writeTo(out);
                assertEquals(nodeStats.getTimestamp(), deserializedNodeStats.getTimestamp());
            );
        // TODO: Only remote_store based aspects of NodeIndicesStats are being tested here.
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                        assertEquals(orig.getCurrentLimit(), deser.getCurrentLimit());
                    case SHARDS:
 * software distributed under the License is distributed on an
                        assertEquals(orig.getRttNoLoadMillis(), deser.getRttNoLoadMillis());
        Index newIndex = new Index("index", "_na_");
        }
    public void testSerialization() throws IOException {
                            assertNull(newNodeIndicesStats.getStatsByShard());
            statsByShards.put(index, indexShardStatsList);
                    .currentReadTime(randomNonNegativeLong())
                new HashMap<>(),
            CommonStatsFlags.Flag.Segments
            remoteStoreNodeStats = new RemoteStoreNodeStats() {
            .evictions(randomLongBetween(0, 100))
                    }
import org.opensearch.script.ScriptStats;
            emptySet(),
import org.opensearch.node.AdaptiveSelectionStats;
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
            };
            out.setVersion(Version.V_3_6_0);
     */
                    assertEquals(nodeStats.getTransport().getServerOpen(), deserializedNodeStats.getTransport().getServerOpen());
                .commitStats(null)
                        assertEquals(pipelineStat.getStats().getCount(), deserializedPipelineStats.getCount());
        TransportStats transportStats = frequently()
                .swap(new OsStats.Swap(swapTotal, randomLongBetween(0, swapTotal)))
        Map<String, Object> flight = (Map<String, Object>) pools.get("flight");
        ClusterManagerThrottlingStats clusterManagerThrottlingStats = null;
                    assertEquals(incomingDocStats.getAverageSizeInBytes(), hostDocStats.getAverageSizeInBytes());
    }
                throw new RuntimeException(e);
                    assertEquals(mem.getHeapUsedPercent(), deserializedMem.getHeapUsedPercent());
                        assertEquals(stats.getQueue(), deserializedStats.getQueue());
                randomNonNegativeLong(),
                // add outgoing connection info
                    );
                }
                if (frequently()) {
        commonStats.indexing = new IndexingStats();
                        PersistedStateStats remoteStateStats = stateStats.getPersistenceStats().get(0);
                IndexShardStats indexShardStats = new IndexShardStats(shardRouting.shardId(), shardStatsList.toArray(new ShardStats[0]));
                    assertNull(deserializedResourceUsageStats);
                    randomIntBetween(1, 200),
                        deserializedNodeStats.getOs().getCpu().getLoadAverage(),
     * survive serialize/deserialize unchanged.
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
                    assertEquals(weightedRoutingStats.getFailOpenCount(), deserializedWeightedRoutingStats.getFailOpenCount());
            out.setVersion(Version.V_3_7_0);
            remoteSegmentStats.addDownloadBytesStarted(10L);
                new StatusCounterStats()
                    .commonStats(createRandomCommonStats())
                } else {
                new ProcessStats.Mem(randomNonNegativeLong())
                JvmStats deserializedJvm = deserializedNodeStats.getJvm();
                    }
                        randomNonNegativeLong(),
                        pipelineId,
        HashMap<Index, List<IndexShardStats>> statsByShards = createRandomShardByStats(indexList);
                    );
                            assertEquals(processorStat.getStats().getTotalTime(), deserializedProcessorStat.getStats().getTotalTime());
                if (remoteStoreNodeStats == null) {
    }
                        );
                randomNonNegativeLong(),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                }
            assertNotNull("native_memory must always be emitted", nativeMemory);
import org.opensearch.index.engine.SegmentsStats;
                        randomNonNegativeLong(),
                        deserializedAdmissionControllerStats.getAdmissionControllerName()
        }
                loadAverages[i] = randomBoolean() ? randomDouble() : -1;
import org.opensearch.common.io.stream.BytesStreamOutput;
            int numDeviceStats = randomIntBetween(0, 10);
    }
                        nodeStats.getOs().getCgroup().getCpuAcctUsageNanos(),
                    assertEquals(
                            0.0
import org.opensearch.search.suggest.completion.CompletionStats;
                NodesResourceUsageStats deserializedResourceUsageStats = deserializedNodeStats.getResourceUsageStats();
                    assertNull(deserializedAdmissionControlStats);
import org.opensearch.node.NodesResourceUsageStats;
                        admissionControllerStats.getRejectionCount().get(AdmissionControlActionType.SEARCH.getType()),
                }
        weightedRoutingStats.updateFailOpenCount();
import org.opensearch.test.OpenSearchTestCase;
                    assertEquals(evictions, sum.getCacheEvictions());
                    Map<String, ScriptStats> stats = scriptCacheStats.getContextStats();
        assertNotNull("memory_pools block must be present", pools);
                    .currentWriteTime(randomNonNegativeLong())
            ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    );
        List<ActionConcurrencyLimiterStats.ActionLimiterSnapshot> snapshots = new ArrayList<>(count);
        public Map<Index, List<IndexShardStats>> getStatsByShard() {
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
                }
        assertNotNull("flight pool must be present in memory_pools", flight);
        DocsStats hostDocStats = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();
                in.setVersion(Version.V_2_13_0);
        levelParams.forEach(level -> {
        NodeStats nodeStats = createNodeStats(true);
                    assertEquals(nodeStats.getHttp().getServerOpen(), deserializedNodeStats.getHttp().getServerOpen());
        for (int i = 0; i < count; i++) {
                        randomNonNegativeLong(),
            frequently() ? randomConcurrencyLimiterStats() : null,
            null,
                    assertNull(deserializedNodeCacheStats);
        int count = randomIntBetween(1, 3);
                assertNull("V_3_7_0 must not include concurrencyLimiterStats", deserialized.getConcurrencyLimiterStats());
            MockNodeIndicesStats mockNodeIndicesStats = generateMockNodeIndicesStats(commonStats, newIndex, commonStatsFlags, level);
                        .parallelism(-1) // Non-ForkJoinPool: use -1
        commonStatsFlags.set(CommonStatsFlags.Flag.Store, true);
                ingestPipelineStats.add(
                }
                        assertEquals(aStats.serviceTime, bStats.serviceTime, 0.01);
                } else {
                    assertEquals(
                    case NODE:
                builder.endObject();
    }
        Index statsIndex = null;
                );
                    FsInfo.IoStats ioStats = fs.getIoStats();
                    nodeConnections.put(nodeId, randomLongBetween(0, 100));
                    randomNonNegativeLong(),
                    assertEquals(jvm.getThreads().getPeakCount(), deserializedJvm.getThreads().getPeakCount());
    /**
            ingestStats,
                    assertNull(deserializedWeightedRoutingStats);
        assertEquals(1024L, ((Number) runtime.get("allocated_bytes")).longValue());
        levelParams.add(NodeIndicesStats.StatsLevel.INDICES);
                    );
                        nodeId,
            .downloadBytesPerSecMovingAverage(0D)
                    assertEquals(jvm.getTimestamp(), deserializedJvm.getTimestamp());
import java.util.LinkedHashMap;
                nonAggregatedBuilder.startObject();
        if (frequently()) {
                    assertEquals(fs.getTotal().getFree(), deserializedFs.getTotal().getFree());
     * Round-trip on the current wire version — the typed allocator stats payload must
                    randomNonNegativeLong(),
import org.opensearch.index.shard.ShardPath;
    private static NodeStats newNodeStatsWithNativeAllocator(DiscoveryNode node, NativeAllocatorPoolStats nativeAllocatorStats) {
 * under the License.
                garbageCollectorsArray[i] = new JvmStats.GarbageCollector(
                    randomFrom("vegas", "gradient2", "aimd"),
                }
        });
                nonAggregatedBuilder = nonAggregatedNodeIndicesStats.toXContent(
        OsStats osStats = null;
                    assertNull(deserializedIngestStats);
            }
                        assertEquals(pipelineStat.getStats().getTotalTime(), deserializedPipelineStats.getTotalTime());
            statsList.add(stats);
        }
                    randomAlphaOfLengthBetween(3, 10),
                    assertEquals(
        }
            }
                .compilationLimitTriggered(randomNonNegativeLong())
                }
            adaptiveSelectionStats,
                    roundtripped.getTotalEstimatedNativeBytes()
                    assertEquals(nodeStats.getBreaker().getAllStats().length, deserializedNodeStats.getBreaker().getAllStats().length);
        // Build via the existing helper so the test is robust against future ctor argument churn.
                randomNonNegativeLong(),
                        randomAlphaOfLength(8),
            .missCount(randomLongBetween(0, 100))
                        break;
                List<IngestStats.ProcessorStat> processorPerPipeline = new ArrayList<>(numProcessors);
        NodeIndicesStats indicesStats = getNodeIndicesStats(remoteStoreStats);
        }
import org.opensearch.cluster.routing.WeightedRoutingStats;
                            JvmStats.BufferPool deserializedBufferPool = deserializedJvm.getBufferPools().get(i);
        weightedRoutingStats = WeightedRoutingStats.getInstance();
                        JvmStats.GarbageCollector deserializedGarbageCollector = deserializedJvm.getGc().getCollectors()[i];
            int numNodes = randomIntBetween(0, 10);
            }
        ScriptStats scriptStats = frequently()
            MockNodeIndicesStats aggregatedNodeIndicesStats = new MockNodeIndicesStats(
            }
                public void apply(String action, AdmissionControlActionType admissionControlActionType) {
                            assertNotNull(newNodeIndicesStats.getStatsByShard());
                    return 123456L;
                if (adaptiveStats == null) {
                    assertEquals(nodeStats.getOs().getSwap().getFree(), deserializedNodeStats.getOs().getSwap().getFree());
                    final int poolsCount = (int) StreamSupport.stream(nodeStats.getJvm().getMem().spliterator(), false).count();
     * Constructs a NodeStats with a specific (non-realistic) value, serializes / deserializes,
                        new IoUsageStats(100.0),
                String nodeId = randomAlphaOfLengthBetween(3, 10);
                    assertEquals(
                paths[i] = new FsInfo.Path(
            try (StreamInput in = out.bytes().streamInput()) {
                    );
                    assertEquals(
        DiscoveryNode node = new DiscoveryNode(
                            assertEquals(processorStat.getStats().getFailedCount(), deserializedProcessorStat.getStats().getFailedCount());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                }
            return this.statsByIndex;
        public Map<Index, CommonStats> getStatsByIndex() {
            List<AdmissionControllerStats> statsList = new ArrayList();
            remoteSegmentStats.addUploadBytesSucceeded(10L);
            processStats,
                    assertThat(deserializedPools.keySet(), hasSize(poolsCount));
                switch (level) {
                    if (jvm.getBufferPools() == null) {
            .totalUploadsFailed(randomLongBetween(100, 200))
import java.util.stream.StreamSupport;
 * license agreements. See the NOTICE file distributed with
            ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
                        );
            JvmStats.GarbageCollector[] garbageCollectorsArray = new JvmStats.GarbageCollector[numGarbageCollectors];
                    .previousDeviceStats(previousDeviceStats)
        }
                    AdmissionControllerStats deserializedAdmissionControllerStats = deserializedAdmissionControlStats
        commonStatsFlags.clear();
                    assertEquals(remoteSegmentStats.getUploadBytesFailed(), deserializedRemoteSegmentStats.getUploadBytesFailed());
                }
            indicesStats = new NodeIndicesStats(
                if (scriptStats == null) {
                    assertNull(deserializedFs);
                }
                        .build();
                    .currentIOTime(randomNonNegativeLong())
 * ownership. Elasticsearch licenses this file to you under
                    JvmStats.Classes classes = jvm.getClasses();
                builder.startObject();
                        assertEquals(aResourceUsageStats.getTimestamp(), bResourceUsageStats.getTimestamp());
import org.opensearch.index.SegmentReplicationRejectionStats;
import org.opensearch.node.IoUsageStats;
                in.setVersion(Version.CURRENT);
            .hitCount(randomLongBetween(0, 100))
            }
                .commonStats(commonStats)
 *
                    randomNonNegativeLong(),
                            entry.getValue().getLastGcStats().getUsagePercent(),
                new CommonStats(commonStatsFlags),
                        assertEquals(stats.getRejected(), deserializedStats.getRejected());
                    .build();
    }
import org.opensearch.core.xcontent.ToXContent;
            remoteSegmentStats.addTotalRefreshBytesLag(5L);
            }
                classes
            for (int i = 0; i < numMemoryPools; i++) {
        NativeAllocatorPoolStats nativeAllocatorStats,
                        compilations += generatedStats.getCompilations();
        }
            scriptStats,
                if (admissionControlStats == null) {
    public void testConcurrencyLimiterStatsVersionGate() throws IOException {
            };
                        assertTrue(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
                        randomNonNegativeLong(),
        }
                } else {
        List<NodeIndicesStats.StatsLevel> levelParams = new ArrayList<>();
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    "totalEstimatedNativeBytes must default to -1 when written by a pre-V_3_7_0 node",
                    .build();
                }
        if (frequently()) {
                if (resourceUsageStats == null) {
                        NodeResourceUsageStats aResourceUsageStats = resourceUsageStats.getNodeIdToResourceUsageStatsMap().get(k);
            nodeStats.writeTo(out);
                    assertEquals(mem.getHeapCommitted(), deserializedMem.getHeapCommitted());
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        NativeAllocatorPoolStats stats = new NativeAllocatorPoolStats(
                if (segmentReplicationRejectionStats == null) {
            null,
                    i,
                    assertEquals(limited, sum.getCompilationLimitTriggered());
                ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
                IngestStats ingestStats = nodeStats.getIngestStats();
                    assertNull(deserializedNodeStats.getThreadPool());
            null,
import org.opensearch.index.store.StoreStats;
                        deserializedNodeStats.getProcess().getMaxFileDescriptors()
                } else {
                        for (IngestStats.ProcessorStat processorStat : processorStats) {
            null,
                        randomAlphaOfLengthBetween(3, 10),
                            assertEquals(bufferPool.getCount(), deserializedBufferPool.getCount());
                    assertEquals(nodeStats.getOs().getMem().getFree(), deserializedNodeStats.getOs().getMem().getFree());
        FsInfo fsInfo = null;
            out.setVersion(Version.CURRENT);
                    assertEquals(remoteTranslogStats, deserializedRemoteTranslogStats);
                        assertEquals(orig.getLastRttMillis(), deser.getLastRttMillis());
                }
                    ? new PublishClusterStateStats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong())
                });
                    )
            }
                        randomAlphaOfLength(8),
                    assertNull(deserializedNodeStats.getScriptStats());
        }
            int numBufferPools = randomIntBetween(0, 10);
                    for (final Map.Entry<String, JvmStats.MemoryPool> entry : pools.entrySet()) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                    );
                randomBoolean() ? stateStats : null
                NodeStats deserialized = new NodeStats(in);
            null,
            try (StreamInput in = out.bytes().streamInput()) {
import org.opensearch.common.xcontent.XContentHelper;
                randomNonNegativeLong(),
                    OperationStats processorStats = new OperationStats(
                    assertNull(deserializedScriptCacheStats);
        NodeStats original = newNodeStatsWithNativeAllocator(node, stats);
            clusterManagerThrottlingStats.onThrottle("test-task", randomInt());
                ScriptStats scriptStats = nodeStats.getScriptStats();
                            break;
            null,
                bufferPoolList.add(
                NodeStats deserializedNodeStats = new NodeStats(in);
                        assertEquals(orig.getAlgorithm(), deser.getAlgorithm());
                SegmentReplicationRejectionStats segmentReplicationRejectionStats = nodeStats.getSegmentReplicationRejectionStats();
                        assertEquals(orig.getAlias(), deser.getAlias());
            return this.stats;
                        randomAlphaOfLengthBetween(3, 10),
    /**
        commonStats.docs = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();
                        assertEquals(aStats.responseTime, bStats.responseTime, 0.01);
        });
            builder.endObject();
import java.io.IOException;
        DiscoveryNode localNode = new DiscoveryNode("node", buildNewFakeTransportAddress(), Version.CURRENT);
                new NativeAllocatorPoolStats.PoolStats("ingest", 200L, 400L, 4096L),
            indicesStats,
                        FsInfo.DeviceStats deserializedDeviceStats = deserializedIoStats.getDevicesStats()[i];
                    assertEquals(remoteSegmentStats.getMaxRefreshBytesLag(), deserializedRemoteSegmentStats.getMaxRefreshBytesLag());
        );
import org.opensearch.index.cache.query.QueryCacheStats;
                aggregatedBuilder = aggregatedNodeIndicesStats.toXContent(
                if (nodeStats.getBreaker() == null) {
                IngestStats deserializedIngestStats = deserializedNodeStats.getIngestStats();
            ? new ScriptStats.Builder().compilations(randomNonNegativeLong())
        HttpStats httpStats = frequently()
                    .deviceName(randomAlphaOfLengthBetween(3, 10))
            remoteSegmentStats.addDownloadBytesFailed(1L);
                }
                    while (threadPoolIterator.hasNext()) {
                        assertEquals(entry.getValue().getMax(), deserializedPools.get(entry.getKey()).getMax());
                    : null,
                        nodeStats.getConcurrencyLimiterStats().getSnapshots().size(),
            osStats,
        );
    public void testNodeIndicesStatsToXContent() {
                        nodeStats.getOs().getCgroup().getCpuStat().getNumberOfElapsedPeriods(),
            remoteSegmentStats.addTotalDownloadTime(20L);
                        randomNonNegativeLong(),
                        assertEquals(stateStats.getUpdateFailed(), deserializedDiscoveryStats.getClusterStateStats().getUpdateFailed());
                    assertNull(deserializedDiscoveryStats);
import java.util.List;
import org.opensearch.threadpool.ThreadPoolStats;
                NodeIndicesStats nodeIndicesStats = nodeStats.getIndices();
                    );
            ? new TransportStats.Builder().serverOpen(randomNonNegativeLong())
                    new ToXContent.MapParams(Collections.singletonMap("level", level.getRestName()))
                        break;
                    .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))
import org.opensearch.action.admin.indices.stats.IndexShardStats;
        commonStatsFlags.set(CommonStatsFlags.Flag.Store, true);
                    .getSegmentReplicationRejectionStats();
            : null;
                    );
                }
            fsInfo,
                    long limited = 0;
            node,
                        assertNull(deserializedDiscoveryStats.getQueueStats());
                    assertEquals(jvm.getUptime(), deserializedJvm.getUptime());
            try (StreamInput in = out.bytes().streamInput()) {
                        .currentSectorsRead(randomNonNegativeLong())
            null,
                        assertEquals(stats.getLargest(), deserializedStats.getLargest());
            SearchRequestStats searchRequestStats,
                AdaptiveSelectionStats adaptiveStats = nodeStats.getAdaptiveSelectionStats();
                    );
            for (int i = 0; i < 3; i++) {
                    randomIntBetween(0, 50),
                if (nodeStats.getOs() == null) {
                    assertEquals(
                new SearchRequestStats(clusterSettings),
                            assertEquals(bufferPool.getTotalCapacity(), deserializedBufferPool.getTotalCapacity());
                    assertEquals(1, (long) admissionControllerStats.getRejectionCount().get(AdmissionControlActionType.SEARCH.getType()));
import org.opensearch.index.shard.DocsStats;
                        randomNonNegativeLong(),
                        break;
            try {
            CommonStatsFlags.Flag.Store,
                    }
                        randomDoubleBetween(1.0, 100.0, true),
                memoryPools.add(
                    assertNull(deserializedLimiterStats);
 */
                    assertEquals(ioStats.getTotalQueueSize(), deserializedIoStats.getTotalQueueSize());
    }
    public void testOldVersionNodes() throws IOException {
                    Iterator<ThreadPoolStats.Stats> deserializedThreadPoolIterator = deserializedNodeStats.getThreadPool().iterator();
            int numPipelines = randomIntBetween(0, 10);
                    assertEquals(nodeStats.getOs().getSwap().getTotal(), deserializedNodeStats.getOs().getSwap().getTotal());
                            randomNonNegativeLong(),
        Map<String, Object> pools = (Map<String, Object>) nativeMemory.get("memory_pools");
            JvmStats.Threads threads = new JvmStats.Threads(randomIntBetween(1, 1000), randomIntBetween(1, 1000));
                    randomAlphaOfLength(10),
                builder = XContentFactory.jsonBuilder();
                        admissionControlStats.getAdmissionControllerStatsList().size(),
            CommonStats oldStats,
            cacheStatsMap.put(CacheType.INDICES_REQUEST_CACHE, cacheStats);
                statsByShards,
        commonStats.indexing = new IndexingStats();
                    assertEquals(fs.getTotal().getType(), deserializedFs.getTotal().getType());
                        assertEquals(generatedStats.getCompilations(), deserStats.getCompilations());
                RemoteStoreNodeStats remoteStoreNodeStats = nodeStats.getRemoteStoreNodeStats();
                }
                    FsInfo.IoStats deserializedIoStats = deserializedFs.getIoStats();
                statsByShard,
        if (frequently()) {
            out.setVersion(Version.V_2_18_0);
            null,
        }
import org.opensearch.cluster.coordination.PendingClusterStateStats;
import org.opensearch.common.settings.ClusterSettings;
            try {
                try (StreamInput in = out.bytes().streamInput()) {
            .build();
        }
                    assertEquals(
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(new ShardId("test-idx", "test-idx", randomIntBetween(1, 10)))
            jvmStats,
                } else {
                        randomNonNegativeLong(),
        CommonStats commonStats,
                    AdmissionControllerStats admissionControllerStats = admissionControlStats.getAdmissionControllerStatsList().get(0);
        IngestStats ingestStats = null;
                        nodeStats.getOs().getCgroup().getCpuStat().getNumberOfTimesThrottled(),
            new CommonStats(commonStatsFlags),
                .build()
                        randomDoubleBetween(1.0, 100.0, true),
                        assertEquals(1, deserializedDiscoveryStats.getClusterStateStats().getPersistenceStats().size());
                randomNonNegativeLong(),
                    assertEquals(nodeStats.getOs().getCpu().getPercent(), deserializedNodeStats.getOs().getCpu().getPercent());
                        .waitTimeNanos(randomIntBetween(-1, 10))
            .totalSizeInBytes(randomLongBetween(0, 1000))
import org.opensearch.Version;
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            null,
                if (scriptCacheStats == null) {
                        assertThat(deserializedPools.containsKey(entry.getKey()), is(true));
        commonStats.docs = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();
            admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 1);
        }
    private static NodeStats newNodeStatsWithNativeAllocator(
            original.writeTo(out);
                    assertArrayEquals(
            return new MockNodeIndicesStats(
                }
                ingestProcessorStats.put(pipelineId, processorPerPipeline);
                    assertEquals(mem.getNonHeapCommitted(), deserializedMem.getNonHeapCommitted());
        JvmStats jvmStats = null;
        commonStatsFlags.set(CommonStatsFlags.Flag.Store, true);
            }
                    assertEquals(jvm.getGc().getCollectors().length, deserializedJvm.getGc().getCollectors().length);
                        assertEquals(orig.getActionName(), deser.getActionName());
    public void testFileCacheDetailedStatsVersionGate() throws IOException {
            for (int i = 0; i < numCircuitBreakerStats; i++) {
        assertEquals(100L, ((Number) flight.get("allocated_bytes")).longValue());
                    assertEquals(limiterStats.getSnapshots().size(), deserializedLimiterStats.getSnapshots().size());
                        assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));
        commonStatsFlags.setIncludeIndicesStatsByLevel(true);
        AdaptiveSelectionStats adaptiveSelectionStats = null;
        });
                    );
                        deserializedNodeStats.getOs().getCgroup().getCpuAcctUsageNanos()
                } else {
                assertEquals(aggregatedContentMap, nonAggregatedContentMap);
import org.opensearch.node.NodeResourceUsageStats;
        }
                );
                        new JvmStats.MemoryPoolGcStats(randomNonNegativeLong(), randomNonNegativeLong())
            remoteSegmentStats.setMaxRefreshTimeLag(2L);
import org.opensearch.cluster.routing.ShardRoutingState;
                            IngestStats.ProcessorStat deserializedProcessorStat = it.next();
                assertEquals(2048L, decoded.getNativeResidentBytes());
            .build();
            List<IngestStats.PipelineStat> ingestPipelineStats = new ArrayList<>(numPipelines);
                        ActionConcurrencyLimiterStats.ActionLimiterSnapshot orig = limiterStats.getSnapshots().get(i);
import org.opensearch.common.settings.Settings;
                        .build()
                assertNull(deserialized.getBlockCacheOnlyStats());
                } else {
import org.opensearch.test.VersionUtils;
                if (nodeStats.getConcurrencyLimiterStats() == null) {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        RemoteStoreNodeStats remoteStoreNodeStats = null;
                        .currentWriteTime(randomNonNegativeLong())
            );
            Map<Index, List<IndexShardStats>> statsByShard,
                        assertEquals(queueStats.getPending(), deserializedDiscoveryStats.getQueueStats().getPending());
            : null;
            null,
    public static NodeStats createNodeStats() throws IOException {
        @SuppressWarnings("unchecked")
                    assertEquals(totalStats.getFailedCount(), deserializedIngestStats.getTotalStats().getFailedCount());
                    MockNodeIndicesStats newNodeIndicesStats = new MockNodeIndicesStats(in);
                        for (int i = 0; i < jvm.getBufferPools().size(); i++) {
                }
        }
            scriptCacheStats,
import org.opensearch.script.ScriptCacheStats;
                .build()
            int numShardsPerIndex = randomIntBetween(1, 50);
                .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))
                    assertNull(deserializedAdaptiveStats);
                            deserializedPools.get(entry.getKey()).getLastGcStats().getUsed()
                        evictions += generatedStats.getCacheEvictions();
            if (statsIndex == null) {
                // add node calculations
    }
                    randomFrom("enforced", "monitor_only", "disabled"),
                NodesResourceUsageStats resourceUsageStats = nodeStats.getResourceUsageStats();
                public long getLastSuccessfulFetchOfPinnedTimestamps() {
            .cacheSize(randomLongBetween(0, 100))
                    assertEquals(mem.getNonHeapUsed(), deserializedMem.getNonHeapUsed());
                    for (IngestStats.PipelineStat pipelineStat : ingestStats.getPipelineStats()) {
                .rxSize(randomNonNegativeLong())
                        deserializedAdmissionControllerStats.getRejectionCount().get(AdmissionControlActionType.INDEXING.getType())
import java.util.ArrayList;
            null,
            @SuppressWarnings("unchecked")
                AdmissionControlStats deserializedAdmissionControlStats = deserializedNodeStats.getAdmissionControlStats();
                    assertNotNull(deserializedLimiterStats);
            } catch (IOException e) {
                    RemoteTranslogStats remoteTranslogStats = nodeIndicesStats.getTranslog().getRemoteTranslogStats();
        commonStats.fieldData = new FieldDataStats.Builder().memorySize(randomLongBetween(0, 100))
                    OperationStats totalStats = ingestStats.getTotalStats();
                    NodeResourceUsageStats stats = new NodeResourceUsageStats(
        );
        return statsByShards;
}
                            .get(0);
                localNode.getId(),
import org.opensearch.core.index.Index;
                    assertEquals(totalStats.getCurrent(), deserializedIngestStats.getTotalStats().getCurrent());
                    assertEquals(remoteSegmentStats.getUploadBytesSucceeded(), deserializedRemoteSegmentStats.getUploadBytesSucceeded());
                        assertEquals(orig.getMode(), deser.getMode());
                    .commitStats(null)
            remoteSegmentStats.addUploadBytesFailed(1L);
            assertEquals("totalEstimatedNativeBytes must round-trip on the wire", sentinel, roundtripped.getTotalEstimatedNativeBytes());
            ? new DiscoveryStats(
                Map<String, Object> aggregatedContentMap = xContentBuilderToMap(aggregatedBuilder);
                assertEquals(200L, decoded.getPools().get(0).getPeakBytes());
                    .resolve(shardRouting.shardId().getIndex().getUUID())
                        assertEquals(deviceStats.operations(), deserializedDeviceStats.operations());
                        deserializedClusterManagerThrottlingStats.getThrottlingCount("test-task")
            ImmutableCacheStatsHolder cacheStats = statsHolder.getImmutableCacheStatsHolder(dimensionNames.toArray(new String[0]));
        long numDocs = randomLongBetween(0, 10000);
                in.setVersion(Version.V_3_7_0);
                    flags.includeCacheType(cacheType);
            CommonStatsFlags.Flag.Flush,
                        );
            for (CacheType cacheType : CacheType.values()) {
                    assertNull(deserializedRemoteStoreNodeStats);
                    assertEquals(scriptStats.getCompilations(), deserializedNodeStats.getScriptStats().getCompilations());
                randomNonNegativeLong(),
        NodesResourceUsageStats nodesResourceUsageStats = null;
                .build();
                            randomNonNegativeLong(),
                    );
        }
                        assertEquals(aStats.nodeId, bStats.nodeId);
                        assertEquals(pipelineStat.getStats().getFailedCount(), deserializedPipelineStats.getFailedCount());
        }
                    new ToXContent.MapParams(Collections.singletonMap("level", level.getRestName()))
                    assertEquals(jvm.getThreads().getCount(), deserializedJvm.getThreads().getCount());
                    );
        for (int i = 0; i < numberOfIndexes; i++) {
                    assertEquals(remoteSegmentStats.getTotalUploadTime(), deserializedRemoteSegmentStats.getTotalUploadTime());
            : null;
            original.writeTo(out);
                        CacheStats toIncrement = new CacheStats(randomInt(20), randomInt(20), randomInt(20), randomInt(20), randomInt(20));
                    assertEquals(remoteSegmentStats.getUploadBytesStarted(), deserializedRemoteSegmentStats.getUploadBytesStarted());
                    assertEquals(nodeStats.getOs().getMem().getFreePercent(), deserializedNodeStats.getOs().getMem().getFreePercent());
                    assertEquals(nodeStats.getTransport().getTxCount(), deserializedNodeStats.getTransport().getTxCount());
            StatusCounterStats statusCounterStats,
import org.opensearch.cluster.service.ClusterStateStats;
                if (weightedRoutingStats == null) {
            );
            nodeStats.writeTo(out);
                assertEquals(3, decoded.getPools().size());
            out.setVersion(Version.V_3_7_0);
            long swapTotal = randomNonNegativeLong();
                    );
                );
                        assertEquals(entry.getValue().getPeakUsed(), deserializedPools.get(entry.getKey()).getPeakUsed());
import org.opensearch.cluster.routing.TestShardRouting;
                    assertNull(deserializedNodeStats.getTransport());
            int numNodes = randomIntBetween(0, 10);
                        .completed(randomIntBetween(1, 1000))
                level
 * GitHub history for details.
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                );
            }
                assertEquals(100L, decoded.getPools().get(0).getAllocatedBytes());
     * gate must keep them round-tripping cleanly: the receiver should see {@code null}.
                    );
                        nodeStats.getProcess().getOpenFileDescriptors(),
            IndexShardStats indexShardStats = new IndexShardStats(shardRouting.shardId(), new ShardStats[] { shardStats });
                    );
            List<JvmStats.BufferPool> bufferPoolList = new ArrayList<>();
                        JvmStats.GarbageCollector garbageCollector = jvm.getGc().getCollectors()[i];
                    assertNull(deserializedClusterManagerThrottlingStats);
import java.util.Map;
                }
                        assertNull(deserializedJvm.getBufferPools());
            return this.statsByShard;
                        Long.toString(randomNonNegativeLong())
                        .minorDeviceNumber(randomInt())
     * Renders {@code NodeStats.toXContent} when {@code nativeAllocatorStats} is non-null and
                shardStatsList.add(shardStats);
            SearchRequestStats searchRequestStats,
                        String pipelineId = pipelineStat.getPipelineId();
                new ActionConcurrencyLimiterStats.ActionLimiterSnapshot(
                        randomAlphaOfLength(8),
                        admissionControllerStats.getAdmissionControllerName(),
                    new OsStats.Cgroup(
                FsInfo deserializedFs = deserializedNodeStats.getFs();
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    aggregatedBuilder,
            }
            );
                    ReplicationStats deserializedReplicationStats = deserializedNodeIndicesStats.getSegments().getReplicationStats();
            StatsLevel level
                    assertEquals(remoteSegmentStats.getMaxRefreshTimeLag(), deserializedRemoteSegmentStats.getMaxRefreshTimeLag());
                        deserialized.getConcurrencyLimiterStats().getSnapshots().size()
                );
                if (fs == null) {
        public CommonStats getStats() {
                    for (int i = 0; i < ioStats.getDevicesStats().length; i++) {
                }
     * Older nodes (pre-V_3_7_0) don't write the native-allocator stats payload. The version
                        assertEquals(queueStats.getTotal(), deserializedDiscoveryStats.getQueueStats().getTotal());
        commonStats.queryCache = new QueryCacheStats.Builder().ramBytesUsed(randomLongBetween(0, 100))
                .cacheEvictions(randomNonNegativeLong())
        AllCircuitBreakerStats allCircuitBreakerStats = null;
                            entry.getValue().getLastGcStats().getMax(),
                DiscoveryStats discoveryStats = nodeStats.getDiscoveryStats();
                } else if (deserializedScriptCacheStats.getContextStats() != null) {
        assertNotNull("runtime block must be present", runtime);
        NodeIndicesStats.StatsLevel level
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    assertEquals(nodeStats.getProcess().getTimestamp(), deserializedNodeStats.getProcess().getTimestamp());
            .totalUploadsSucceeded(randomLongBetween(50, 100))
import static org.hamcrest.CoreMatchers.is;
        // Pre-V_3_7_0: fields are not written; deserialization must not throw and fields must be null
                    final Map<String, JvmStats.MemoryPool> pools = StreamSupport.stream(mem.spliterator(), false)
            ) {
                        )
                        assertEquals(stats.getName(), deserializedStats.getName());
                if (nodeStats.getTransport() == null) {
                        assertEquals(orig.getInFlight(), deser.getInFlight());
            for (int i = 0; i < numThreadPoolStats; i++) {
                        assertEquals(entry.getValue().getName(), deserializedPools.get(entry.getKey()).getName());
                    assertEquals(compilations, sum.getCompilations());
            segmentReplicationRejectionStats = new SegmentReplicationRejectionStats(randomNonNegativeLong());
        if (frequently()) {
        // V_3_7_0: fields are written and read back (null or non-null, just no deserialization error)
        NodeStats nodeStats = createNodeStats();
                    RemoteTranslogStats deserializedRemoteTranslogStats = deserializedNodeIndicesStats.getTranslog()
                        OperationStats deserializedPipelineStats = getPipelineStats(deserializedIngestStats.getPipelineStats(), pipelineId);
            int numberOfShards = randomIntBetween(1, 4);
            int numCircuitBreakerStats = randomIntBetween(0, 10);
                .resolve(String.valueOf(shardRouting.shardId().id()));
                    index.getName(),
            null, // nodeCacheStats
                }
            nodesResourceUsageStats = new NodesResourceUsageStats(resourceUsageStatsMap);
                        .rejected(randomNonNegativeLong())
            OperationStats totalStats = new OperationStats(
            }
import java.util.Collections;
                new CommonStats(commonStatsFlags),
                }
                        randomIntBetween(0, 2000),
        List<Index> indexList = new ArrayList<>();
                    : new FsInfo.DeviceStats.Builder().majorDeviceNumber(randomInt())
                    assertEquals(
        // It is possible to test other metrics in NodeIndicesStats as well since it extends Writeable now
                    assertEquals(ioStats.getTotalWriteOperations(), deserializedIoStats.getTotalWriteOperations());
        }
            Map<String, Object> nativeMemory = (Map<String, Object>) root.get("native_memory");
            assertEquals(
        ) {
                        nodeStats.getOs().getCgroup().getMemoryUsageInBytes(),
        );
                    memoryPools
            .fieldMemoryStats(null)
            VersionUtils.randomVersion(random())
            .build();
                    assertNull(deserializedNodeStats.getOs());
                    localNode.getId(),
                ShardRouting shardRouting = TestShardRouting.newShardRouting(
package org.opensearch.action.admin.cluster.node.stats;
import org.opensearch.core.xcontent.XContentBuilder;
                    assertEquals(
    /**
            }
                CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER,
            }
            null,
            for (int i = 0; i < numPaths; i++) {
                        assertEquals(orig.getTotalRejected(), deser.getTotalRejected());
        long numDocs = randomLongBetween(0, 10000);
            try (StreamInput in = out.bytes().streamInput()) {
        final MockNodeIndicesStats nonAggregatedNodeIndicesStats = new MockNodeIndicesStats(
                if (frequently()) {
                    randomAlphaOfLengthBetween(3, 10),
                .pollingIngestStats(null)
            null, // blockCacheOnlyStats
                    } else {
                        );
        ClusterStateStats stateStats = new ClusterStateStats();
            }
                    assertEquals(nodeStats.getOs().getMem().getUsedPercent(), deserializedNodeStats.getOs().getMem().getUsedPercent());
                assertNull(deserialized.getBlockCacheOnlyStats());
                    assertEquals(
        commonStats.store = new StoreStats.Builder().sizeInBytes(100).reservedSize(0L).build();
                statsIndex = shardRouting.shardId().getIndex();
            .uploadBytesStarted(randomLongBetween(10000, 50000))
                        assertEquals(pipelineStat.getStats().getCurrent(), deserializedPipelineStats.getCurrent());
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
                        assertFalse(it.hasNext());
                        .largest(randomIntBetween(1, 1000))
                            assertEquals(bufferPool.getUsed(), deserializedBufferPool.getUsed());
                        deserializedNodeStats.getOs().getCgroup().getCpuStat().getTimeThrottledNanos()
import org.opensearch.action.ActionConcurrencyLimiterStats;
                    nonAggregatedBuilder,
                    -1L,
                        assertEquals(jvm.getBufferPools().size(), deserializedJvm.getBufferPools().size());
                        assertEquals(garbageCollector.getName(), deserializedGarbageCollector.getName());
                List<ShardStats> shardStatsList = new ArrayList<>();
                @Override
                            bResourceUsageStats.getMemoryUtilizationPercent(),
                    randomNonNegativeLong(),
            try (StreamInput in = out.bytes().streamInput()) {
                    )
            null,
            .downloadBytesMovingAverage(0D)
import org.opensearch.index.shard.IndexingStats;
                if (frequently()) {
                aggregatedBuilder.endObject();
                    randomNonNegativeLong(),
                    assertEquals(
                } else {
            ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
                    assertEquals(nodeStats.getProcess().getCpu().getPercent(), deserializedNodeStats.getProcess().getCpu().getPercent());
                @Override
    }
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
    private static NodeIndicesStats getNodeIndicesStats(boolean remoteStoreStats) {
            for (int i = 0; i < numNodes; i++) {
                for (int j = 0; j < numProcessors; j++) {
    public static class MockNodeIndicesStats extends NodeIndicesStats {
import org.opensearch.action.admin.indices.stats.CommonStats;
                    ShardStats shardStats = Arrays.stream(indexShardStats.getShards()).findFirst().get();
                .seqNoStats(null)
                if (ingestStats == null) {
            allCircuitBreakerStats,
                        .queue(randomIntBetween(1, 1000))
 */
                new StatusCounterStats(),
        commonStats.completion = new CompletionStats();
import org.opensearch.index.flush.FlushStats;
                    randomBoolean(),
                            aResourceUsageStats.getMemoryUtilizationPercent(),
                    ScriptStats sum = deserializedScriptCacheStats.sum();
        // V_3_8_0: concurrencyLimiterStats round-trips (may be null or non-null)
                FsInfo fs = nodeStats.getFs();
                new ProcessStats.Cpu(randomShort(), randomNonNegativeLong()),
                        .getRemoteTranslogStats();
            "test_node",
                        FsInfo.DeviceStats deviceStats = ioStats.getDevicesStats()[i];
    public void testNodeIndicesStatsWithAndWithoutAggregations() throws IOException {
            buildNewFakeTransportAddress(),
                        assertEquals(circuitBreakerStats.getTrippedCount(), deserializedCircuitBreakerStats.getTrippedCount(), 0);
                        .collect(Collectors.toMap(JvmStats.MemoryPool::getName, Function.identity()));
                .retentionLeaseStats(null)
                    assertEquals(scriptStats.getCacheEvictions(), deserializedNodeStats.getScriptStats().getCacheEvictions());
                        assertEquals(stats.getCompleted(), deserializedStats.getCompleted());
        return new NodeStats(
                        .deviceName(randomAlphaOfLengthBetween(3, 10))
                        ThreadPoolStats.Stats stats = threadPoolIterator.next();
            null,
    }
                    );
import java.util.Arrays;
        NodeIndicesStats indicesStats = null;
        NodeStats nodeStats = createNodeStats();
        if (frequently()) {
                } else {
                    new ThreadPoolStats.Stats.Builder().name(randomAlphaOfLengthBetween(3, 10))
                        deserializedNodeStats.getProcess().getMem().getTotalVirtual()
                    assertEquals(adaptiveStats.getRanks(), deserializedAdaptiveStats.getRanks());
 * not use this file except in compliance with the License.
                    assertThat(pools.keySet(), hasSize(poolsCount));
            null, // concurrencyLimiterStats
        stateStats.setPersistenceStats(Arrays.asList(remoteStateStats.getUploadStats()));
import java.util.stream.Collectors;
            remoteStoreNodeStats,
            out.setVersion(Version.V_3_9_0);
                );
                    assertEquals(remoteSegmentStats.getTotalRefreshBytesLag(), deserializedRemoteSegmentStats.getTotalRefreshBytesLag());
            indexShardStatsList.add(indexShardStats);
                        assertEquals(
                } else {
                new NativeAllocatorPoolStats.PoolStats("query", 300L, 600L, 2048L)
                        assertEquals(deviceStats.writeOperations(), deserializedDeviceStats.writeOperations());
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControllerStats;
 * Licensed to Elasticsearch under one or more contributor
                            stateStats.getUpdateTotalTimeInMillis(),
     * {@code runtime.allocated_bytes}/{@code runtime.resident_bytes} and grouped {@code memory_pools}.
                        );
            RemoteTranslogStats otherRemoteTranslogStats = new RemoteTranslogStats(getRandomRemoteTranslogTransferTrackerStats());
        commonStatsFlags.set(CommonStatsFlags.Flag.Indexing, true);
            AdmissionControllerStats stats = new AdmissionControllerStats(admissionController);
        levelParams.add(NodeIndicesStats.StatsLevel.NODE);
import java.util.Iterator;
                        .currentSectorsWritten(randomNonNegativeLong())
                        assertNull(deserializedDiscoveryStats.getClusterStateStats());
        try (StreamInput in = out.bytes().streamInput()) {
                    assertEquals(
                        case NODE:
                        deserializedRemoteSegmentStats.getDownloadBytesSucceeded()
            1024L,
                new SearchRequestStats(clusterSettings),
                        .active(randomIntBetween(1, 1000))
                    randomNonNegativeLong(),
                    assertEquals(fs.getTotal().getTotal(), deserializedFs.getTotal().getTotal());
                        assertEquals(deviceStats.readKilobytes(), deserializedDeviceStats.readKilobytes());
import org.opensearch.transport.TransportStats;
                Path path = createTempDir().resolve("indices")
        }
            httpStats,
                    for (String tierName : new String[] { "dummy_tier_1", "dummy_tier_2" }) {
        public MockNodeIndicesStats(StreamInput in) throws IOException {
                null
            null,
                        randomDoubleBetween(1.0, 100.0, true)
                        randomNonNegativeLong(),
 *    http://www.apache.org/licenses/LICENSE-2.0
            osStats = new OsStats.Builder().timestamp(System.currentTimeMillis())
 * SPDX-License-Identifier: Apache-2.0
                    assertEquals(classes.getUnloadedClassCount(), deserializedJvm.getClasses().getUnloadedClassCount());
        builder.endObject();
                LinkedHashMap indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
                    .pollingIngestStats(null)
            remoteSegmentStats.addTotalRejections(5L);
                    ? null
            null,
                    assertEquals(totalStats.getTotalTime(), deserializedIngestStats.getTotalStats().getTotalTime());
                } else {
            }
            FsInfo.Path[] paths = new FsInfo.Path[numPaths];
            List.of(new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L))
            for (int i = 0; i < numNodes; i++) {
                .cpu(new OsStats.Cpu(randomShort(), loadAverages))
            double loadAverages[] = new double[3];
                    assertEquals(remoteSegmentStats.getDownloadBytesStarted(), deserializedRemoteSegmentStats.getDownloadBytesStarted());
                randomNonNegativeLong(),
                            assertNull(newNodeIndicesStats.getStatsByShard());
                throw new RuntimeException(e);
            }
                } else {
        @SuppressWarnings("unchecked")
        }
    }
        NodeStats original = newNodeStatsWithNativeAllocator(node, stats);
                NodeCacheStats nodeCacheStats = nodeStats.getNodeCacheStats();
        return newNodeStatsWithNativeAllocator(node, nativeAllocatorStats, -1L);
            }
                        CircuitBreakerStats deserializedCircuitBreakerStats = deserializedNodeStats.getBreaker().getAllStats()[i];
                    .resolve(String.valueOf(shardRouting.shardId().id()));
                        assertEquals(stats.getThreads(), deserializedStats.getThreads());
                        assertEquals(generatedStats.getCompilationLimitTriggered(), deserStats.getCompilationLimitTriggered());
        levelParams.add(NodeIndicesStats.StatsLevel.INDICES);
                        limited += generatedStats.getCompilationLimitTriggered();
                            assertNotNull(newNodeIndicesStats.getStatsByIndex());
                    long evictions = 0;
        HashMap<Index, List<IndexShardStats>> statsByShards = new HashMap<>();
                    assertEquals(
            .downloadTimeMovingAverage(0D)
            null,
        // To test out scenario when the incoming node stats response is from a node with an older ES Version.
                    assertEquals(nodeStats.getOs().getMem().getTotal(), deserializedNodeStats.getOs().getMem().getTotal());
                .mem(new OsStats.Mem(memTotal, randomLongBetween(0, memTotal)))
import static java.util.Collections.emptySet;
            }
            null,
            null,
import org.opensearch.http.HttpStats;
            in.setVersion(Version.CURRENT);
        ScriptCacheStats scriptCacheStats = scriptStats != null ? scriptStats.toScriptCacheStats() : null;
            transportStats,
            StatusCounterStats statusCounterStats
                    assertEquals(
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;
                    assertNull(deserializedNodeIndicesStats);
                            assertEquals(processorStat.getStats().getCurrent(), deserializedProcessorStat.getStats().getCurrent());
                    randomDouble(),
            Map<String, Long> nodeConnections = new HashMap<>();
        List<NodeIndicesStats.StatsLevel> levelParams = new ArrayList<>();
        long totalEstimatedNativeBytes
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
            admissionControlStats = new AdmissionControlStats(statsList);
            );
            }
                    randomBoolean() ? randomNonNegativeLong() : -1L
     */
                } else {
    }
            try (StreamInput in = out.bytes().streamInput()) {
            CommonStatsFlags.Flag.QueryCache,
                        0
                randomNonNegativeLong()
        Map<String, Object> runtime = (Map<String, Object>) nativeMemory.get("runtime");
            remoteSegmentStats.addUploadBytesStarted(10L);
            Map<String, Long> nodeConnections = new HashMap<>();
        if (frequently()) {
        }
                    assertEquals(nodeStats.getHttp().getTotalOpen(), deserializedNodeStats.getHttp().getTotalOpen());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            JvmStats.Classes classes = new JvmStats.Classes(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong());
                        deserializedAdmissionControllerStats.getRejectionCount().get(AdmissionControlActionType.SEARCH.getType())
import org.opensearch.common.metrics.OperationStats;
                        nodeStats.getOs().getCgroup().getCpuCfsQuotaMicros(),
                        assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
            null,
            -1L
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                        assertEquals(
                    .retentionLeaseStats(null)
                        assertEquals(remoteStateStats.getTotalTimeInMillis(), deserializedRemoteStateStats.getTotalTimeInMillis());
            mockNodeIndicesStats.writeTo(out);
                    .getClusterManagerThrottlingStats();
                    assertEquals(classes.getLoadedClassCount(), deserializedJvm.getClasses().getLoadedClassCount());
        statsByShard.put(statsIndex, indexShardStatsList);
    }
    public void testTotalEstimatedNativeBytesPreservedAcrossWireAndRender() throws IOException {
            .totalDownloadTimeInMillis(0L)
            FsInfo.IoStats ioStats = new FsInfo.IoStats(deviceStatsArray);
        }
                }
            RemoteSegmentStats remoteSegmentStats = indicesStats.getSegments().getRemoteSegmentStats();
                    if (stateStats == null) {
            snapshots.add(
            CommonStatsFlags.Flag.FieldData,
                );
    }
            RemoteTranslogStats remoteTranslogStats = indicesStats.getTranslog().getRemoteTranslogStats();
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags(
        return new NodeStats(
     * renders, and asserts the rendered value matches the constructed value verbatim.
            threadPoolStats,
                }
                WeightedRoutingStats deserializedWeightedRoutingStats = deserializedNodeStats.getWeightedRoutingStats();
                } else {
        long numDeletedDocs = randomLongBetween(0, 100);
                .build();
        commonStats.docs = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();
                String pipelineId = randomAlphaOfLengthBetween(3, 10);
    private OperationStats getPipelineStats(List<IngestStats.PipelineStat> pipelineStats, String id) {
        assertNotNull("native_memory wrapper must be opened when allocator stats are present", nativeMemory);
            .totalTimeInMillis(randomLongBetween(0, 100))
                            .get(k);
                new StatusCounterStats(),
            try (BytesStreamOutput out = new BytesStreamOutput()) {
                    }
                        assertEquals(circuitBreakerStats.getOverhead(), deserializedCircuitBreakerStats.getOverhead(), 0);
                    resourceUsageStats.getNodeIdToResourceUsageStatsMap().forEach((k, v) -> {
            clusterManagerThrottlingStats = new ClusterManagerThrottlingStats();
                NodeIndicesStats deserializedNodeIndicesStats = deserializedNodeStats.getIndices();
                new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L),
            MockNodeIndicesStats mockNodeIndicesStats = generateMockNodeIndicesStats(commonStats, newIndex, commonStatsFlags, level);
                    );
    /**
            roundtripped.toXContent(builder, ToXContent.EMPTY_PARAMS);
                NodeStats deserialized = new NodeStats(in);
                    assertNull(deserializedJvm);
                    .currentReadsCompleted(randomNonNegativeLong())
                    }
                        new OperationStats(
            discoveryStats,
                        .collect(Collectors.toMap(JvmStats.MemoryPool::getName, Function.identity()));
            .uploadBytesPerSecMovingAverage(0D)
            null,
import org.opensearch.common.cache.service.NodeCacheStats;
        @SuppressWarnings("unchecked")
            AdmissionController admissionController = new AdmissionController(
    }
                    final Map<String, JvmStats.MemoryPool> deserializedPools = StreamSupport.stream(deserializedMem.spliterator(), false)
import org.opensearch.indices.NodeIndicesStats;
                    assertEquals(fs.getTimestamp(), deserializedFs.getTimestamp());
            null,
                ScriptCacheStats scriptCacheStats = nodeStats.getScriptCacheStats();
            remoteTranslogStats.add(otherRemoteTranslogStats);
                    randomBoolean() ? randomNonNegativeLong() : -1L,
                        assertEquals(circuitBreakerStats.getLimit(), deserializedCircuitBreakerStats.getLimit());
        NodeStats original = newNodeStatsWithNativeAllocator(node, null, sentinel);
            }
                    .minorDeviceNumber(randomInt())
        AdmissionControlStats admissionControlStats = null;
 * Modifications Copyright OpenSearch Contributors. See
                assertEquals(
                NodeStats roundtripped = new NodeStats(in);
                Map<String, Object> nonAggregatedContentMap = xContentBuilderToMap(nonAggregatedBuilder);
                DiscoveryStats deserializedDiscoveryStats = deserializedNodeStats.getDiscoveryStats();
                if (discoveryStats == null) {
            )
                        randomIntBetween(1, 10),
            int numPaths = randomIntBetween(0, 10);
        long numDocs = randomLongBetween(0, 10000);
        nodeStats.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    assertEquals(replicationStats.getMaxBytesBehind(), deserializedReplicationStats.getMaxBytesBehind());
                    assertNull(deserialized.getConcurrencyLimiterStats());
                randomNonNegativeLong(),
import org.opensearch.monitor.jvm.JvmStats;
                        clusterManagerThrottlingStats.getTotalThrottledTaskCount(),
            List.of(
                        new OsStats.Cgroup.CpuStat(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),
            1024L,
                    }
                // add node calculations
    public void testNativeAllocatorStatsBwcEmptyOnOldVersion() throws IOException {
                } else {
            int numThreadPoolStats = randomIntBetween(0, 10);
import org.opensearch.common.xcontent.XContentFactory;
            try (StreamInput in = out.bytes().streamInput()) {
                        // intentionally validating identical order
            null,
            XContentBuilder builder = null;
                assertEquals("flight", decoded.getPools().get(0).getName());
        });
        indexes.forEach(index -> {
import org.opensearch.action.admin.indices.stats.ShardStats;
        commonStatsFlags.setIncludeIndicesStatsByLevel(true);
                assertEquals(nodeStats.getNode(), deserializedNodeStats.getNode());
        }
                    randomAlphaOfLength(5),
                    assertEquals(mem.getHeapMax(), deserializedMem.getHeapMax());
            node,
                    assertEquals(incomingDocStats.getTotalSizeInBytes(), hostDocStats.getTotalSizeInBytes());
                circuitBreakerStatsArray[i] = new CircuitBreakerStats(
            for (int indexNum = 0; indexNum < numIndices; indexNum++) {
                    for (String context : stats.keySet()) {
                        assertEquals(remoteStateStats.getFailedCount(), deserializedRemoteStateStats.getFailedCount());
                    } else {
                } else {
                builder = mockNodeIndicesStats.toXContent(
                new JvmStats.Mem(
                ((Number) nativeMemory.get("total_estimated_bytes")).longValue()
import org.opensearch.cluster.coordination.PublishClusterStateStats;
            .reservedSize(randomLongBetween(0, 1000))
            XContentBuilder aggregatedBuilder = null;
                ClusterManagerThrottlingStats deserializedClusterManagerThrottlingStats = deserializedNodeStats
import org.opensearch.index.remote.RemoteSegmentStats;
                // add outgoing connection info
                        NodeResourceUsageStats bResourceUsageStats = deserializedResourceUsageStats.getNodeIdToResourceUsageStatsMap()
import org.opensearch.node.remotestore.RemoteStoreNodeStats;
import org.opensearch.ratelimitting.admissioncontrol.controllers.AdmissionController;
        Map<String, Object> nativeMemory = (Map<String, Object>) root.get("native_memory");
                        .currentWritesCompleted(randomNonNegativeLong())
        ThreadPoolStats threadPoolStats = null;
import org.opensearch.ingest.IngestStats;
            2048L,
import org.opensearch.common.cache.stats.CacheStats;
        Map<Index, List<IndexShardStats>> statsByShard = new HashMap<>();
        // V_3_7_0: concurrencyLimiterStats is not on the wire; deserialization must not throw
        NodeStats nodeStats = newNodeStatsWithNativeAllocator(node, stats);
                }
            Map<String, NodeResourceUsageStats> resourceUsageStatsMap = new HashMap<>();
/*
        WeightedRoutingStats weightedRoutingStats = null;
                        nodeStats.getProcess().getMem().getTotalVirtual(),
                ScriptCacheStats deserializedScriptCacheStats = deserializedNodeStats.getScriptCacheStats();
import java.nio.file.Path;
                    assertEquals(2, (long) admissionControllerStats.getRejectionCount().get(AdmissionControlActionType.INDEXING.getType()));
                    assertEquals(remoteSegmentStats.getTotalDownloadTime(), deserializedRemoteSegmentStats.getTotalDownloadTime());
     * and skipped (null) when deserializing from an older-version stream.
            CommonStatsFlags flags = new CommonStatsFlags();
                new CommonStats(commonStatsFlags),
                        assertEquals(aStats.queueSize, bStats.queueSize, 0.01);
            clusterManagerThrottlingStats,
                        deserializedNodeStats.getProcess().getOpenFileDescriptors()
            }
                threads,
                ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
            admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 2);
                        .currentReadTime(randomNonNegativeLong())
                );
            Index index = new Index("test-index-" + i, "_na_");
                ClusterManagerThrottlingStats clusterManagerThrottlingStats = nodeStats.getClusterManagerThrottlingStats();
                    ClusterStateStats stateStats = discoveryStats.getClusterStateStats();
        }
            ShardRouting shardRouting = TestShardRouting.newShardRouting(
                        assertEquals(deviceStats.readOperations(), deserializedDeviceStats.readOperations());
                );
        return createNodeStats(false);
                    assertEquals(nodeCacheStats, deserializedNodeCacheStats);
                        ScriptStats deserStats = deserialized.get(context);
                        }
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.action.admin.indices.stats.StatusCounterStats;
                        deserializedSegmentReplicationRejectionStats.getTotalRejectionCount()
                }
                    assertEquals(
            .deleted(randomLongBetween(0, 100))
                    assertNotNull(deserialized.getConcurrencyLimiterStats());
                randomBoolean()
                if (jvm == null) {
                } else {
                        deserializedAdmissionControlStats.getAdmissionControllerStatsList().size()
                        deserializedNodeStats.getOs().getCgroup().getCpuAcctControlGroup()
                        .currentIOTime(randomNonNegativeLong())
                .resolve(shardRouting.shardId().getIndex().getUUID())
            } catch (IOException e) {
            .lastSuccessfulUploadTimestamp(0L)
            CircuitBreakerStats[] circuitBreakerStatsArray = new CircuitBreakerStats[numCircuitBreakerStats];
            .cacheCount(randomLongBetween(0, 100))
                garbageCollectors,
     * asserts the JSON shape: a top-level {@code native_memory} block with
        ) {
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
            .lastSuccessfulDownloadTimestamp(0L)
     */
        assertEquals(2048L, ((Number) flight.get("limit_bytes")).longValue());
            nodesResourceUsageStats,
    public static NodeStats createNodeStats(boolean remoteStoreStats) throws IOException {
                        randomNonNegativeLong(),
            null,
import org.opensearch.discovery.DiscoveryStats;
                    }
            statsByShards,
                        System.currentTimeMillis(),
        commonStats.flush = new FlushStats.Builder().total(randomLongBetween(0, 100))
 * specific language governing permissions and limitations
                            randomNonNegativeLong(),
                }
                        assertEquals(queueStats.getCommitted(), deserializedDiscoveryStats.getQueueStats().getCommitted());
 *
        NativeAllocatorPoolStats stats = new NativeAllocatorPoolStats(
                shardRoutingState
                            JvmStats.BufferPool bufferPool = jvm.getBufferPools().get(i);
                    resourceUsageStatsMap.put(nodeId, stats);
                        segmentReplicationRejectionStats.getTotalRejectionCount(),
                    assertEquals(remoteSegmentStats.getDownloadBytesFailed(), deserializedRemoteSegmentStats.getDownloadBytesFailed());
                        assertEquals(stateStats.getUpdateSuccess(), deserializedDiscoveryStats.getClusterStateStats().getUpdateSuccess());
                    assertEquals(ioStats.getTotalWriteKilobytes(), deserializedIoStats.getTotalWriteKilobytes());
                NativeAllocatorPoolStats decoded = roundtripped.getNativeAllocatorStats();
                    }
            FsInfo.DeviceStats[] deviceStatsArray = new FsInfo.DeviceStats[numDeviceStats];
    public MockNodeIndicesStats generateMockNodeIndicesStats(
                        nodeStats.getProcess().getMaxFileDescriptors(),
                    new IngestStats.PipelineStat(
        if (frequently()) {
import org.opensearch.monitor.os.OsStats;
            int numGarbageCollectors = randomIntBetween(0, 10);
     * the wire round-trip; the coordinator must NOT re-read its own OsProbe at toXContent time.
            CommonStatsFlags.Flag.Completion,
                            Map.of(dimensionValues, toIncrement)
            NodeStats roundtripped = new NodeStats(in);
                }
                        assertEquals(garbageCollector.getCollectionCount(), deserializedGarbageCollector.getCollectionCount());
                        assertEquals(deviceStats.writeKilobytes(), deserializedDeviceStats.writeKilobytes());
                        assertTrue(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));
                        assertEquals(remoteStateStats.getStatsName(), deserializedRemoteStateStats.getStatsName());
                    DocsStats incomingDocStats = shardStats.getStats().docs;
                String nodeId = randomAlphaOfLengthBetween(3, 10);
                        deserializedNodeStats.getOs().getCgroup().getCpuControlGroup()
            )
            List<String> dimensionNames = List.of("index", "shard", "tier");
            2048L,
    }
                if (nodeStats.getThreadPool() == null) {
                        CircuitBreakerStats circuitBreakerStats = nodeStats.getBreaker().getAllStats()[i];
                .cgroup(
                    for (int i = 0; i < limiterStats.getSnapshots().size(); i++) {
 *
            remoteSegmentStats.addMaxRefreshBytesLag(2L);
                    assertEquals(ioStats.getTotalWriteTime(), deserializedIoStats.getTotalWriteTime());
            indexList.add(index);
                        nodeStats.getOs().getCgroup().getCpuAcctControlGroup(),
public class NodeStatsTests extends OpenSearchTestCase {
            .downloadBytesSucceeded(0L)
        CommonStatsFlags commonStatsFlags,
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;
                        nodeStats.getOs().getCgroup().getCpuCfsPeriodMicros(),
            TreeMap<CacheType, ImmutableCacheStatsHolder> cacheStatsMap = new TreeMap<>();
            .periodic(randomLongBetween(0, 100))
        if (frequently()) {
                    );
                NodeStats roundtripped = new NodeStats(in);
        }
                    return;
                    }
                    .currentQueueSize(randomNonNegativeLong())
                indexShardStatsList.add(indexShardStats);
        );
                    shardRoutingState
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
                        ResponseCollectorService.ComputedNodeStats aStats = adaptiveStats.getComputedStats().get(k);
            .totalUploadsStarted(randomLongBetween(100, 500))
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControlStats;
                        PersistedStateStats deserializedRemoteStateStats = deserializedDiscoveryStats.getClusterStateStats()
                    assertEquals(
        } else {
                        List<String> dimensionValues = List.of(indexName, shardName, tierName);
            emptyMap(),
                        ThreadPoolStats.Stats deserializedStats = deserializedThreadPoolIterator.next();
        NativeAllocatorPoolStats stats = new NativeAllocatorPoolStats(
            int numIndices = randomIntBetween(1, 10);
                    )
                        remoteSegmentStats.getDownloadBytesSucceeded(),
                    randomNonNegativeLong(),
                if (nodeStats.getHttp() == null) {
import org.opensearch.index.translog.RemoteTranslogStats;
        out.setVersion(Version.CURRENT);
                        nodeStats.getOs().getCpu().getLoadAverage(),
                            assertNull(newNodeIndicesStats.getStatsByIndex());
                if (clusterManagerThrottlingStats == null) {
                        Iterator<IngestStats.ProcessorStat> it = deserializedIngestStats.getProcessorStats().get(pipelineId).iterator();
                    assertEquals(nodeStats.getOs().getTimestamp(), deserializedNodeStats.getOs().getTimestamp());
                    assertEquals(ioStats.getTotalOperations(), deserializedIoStats.getTotalOperations());
        return pipelineStats.stream().filter(p1 -> p1.getPipelineId().equals(id)).findFirst().map(p2 -> p2.getStats()).orElse(null);
                        randomNonNegativeLong()
import java.util.function.Function;
                            assertNull(newNodeIndicesStats.getStatsByIndex());
                        Long.toString(randomNonNegativeLong()),
                    for (int i = 0; i < nodeStats.getBreaker().getAllStats().length; i++) {
        @SuppressWarnings("unchecked")
                ActionConcurrencyLimiterStats deserializedLimiterStats = deserializedNodeStats.getConcurrencyLimiterStats();
                    .currentSectorsWritten(randomNonNegativeLong())
                        assertEquals(garbageCollector.getCollectionTime(), deserializedGarbageCollector.getCollectionTime());
                    );
            .build();
            )
    public void testNodeIndicesStatsSerialization() throws IOException {
            null,
                String indexName = "index" + indexNum;
            null,
                    }
        return new ActionConcurrencyLimiterStats(snapshots);
    private Map<String, Object> xContentBuilderToMap(XContentBuilder xContentBuilder) {
                assertNull(deserialized.getFileCacheOnlyStats());
                .build();
                WeightedRoutingStats weightedRoutingStats = nodeStats.getWeightedRoutingStats();
                }
                    );
        );
                    assertEquals(ingestStats.getPipelineStats().size(), deserializedIngestStats.getPipelineStats().size());
            int numMemoryPools = randomIntBetween(0, 10);
                in.setVersion(Version.V_3_9_0);
                        assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
                    randomNonNegativeLong()
            }
                    switch (level) {
                    assertNull(deserializedNodeStats.getBreaker());
                    assertEquals(ioStats.getTotalIOTimeMillis(), deserializedIoStats.getTotalIOTimeMillis());
                    } else {
                i,
        if (frequently()) {
            DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, "dummyStoreName");
                    builder,
                            .getPersistenceStats()
                    assertEquals(ioStats.getTotalReadTime(), deserializedIoStats.getTotalReadTime());
        long sentinel = 4_026_531_840L; // distinctive value, unlikely to match coordinator RSS
                            deserializedPools.get(entry.getKey()).getLastGcStats().getUsagePercent()
            );
                assertEquals(2048L, decoded.getPools().get(0).getLimitBytes());
                    randomNonNegativeLong(),
        commonStatsFlags.set(CommonStatsFlags.Flag.Indexing, true);
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
     * Verifies that {@code fileCacheOnlyStats} and {@code blockCacheOnlyStats} are serialized on V_3_7_0+
            : null;
        }
                NodeStats deserialized = new NodeStats(in);
                    .currentSectorsRead(randomNonNegativeLong())
                    assertEquals(nodeStats.getTransport().getRxCount(), deserializedNodeStats.getTransport().getRxCount());
                .txSize(randomNonNegativeLong())
                        assertEquals(entry.getValue().getUsed(), deserializedPools.get(entry.getKey()).getUsed());
                            randomNonNegativeLong()
                index.getName(),
                    Map<String, ScriptStats> deserialized = deserializedScriptCacheStats.getContextStats();
            .uploadBytesSucceeded(randomLongBetween(5000, 10000))
                        assertEquals(stats.getActive(), deserializedStats.getActive());
 */
 * this file be licensed under the Apache-2.0 license or a
                    assertNull(deserializedNodeStats.getProcess());
                if (nodeStats.getProcess() == null) {
            } catch (IOException e) {
                    )
                        case INDICES:
                            break;
                ActionConcurrencyLimiterStats limiterStats = nodeStats.getConcurrencyLimiterStats();
            nodeCacheStats = new NodeCacheStats(cacheStatsMap, flags);
                        deserializedNodeStats.getOs().getCgroup().getMemoryLimitInBytes()
                    );
                .totalOutboundConnections(randomNonNegativeLong())
        levelParams.add(NodeIndicesStats.StatsLevel.SHARDS);
/*
     */
                    PendingClusterStateStats queueStats = discoveryStats.getQueueStats();
                } else {
        return indicesStats;
                    assertEquals(nodeStats.getOs().getMem().getUsed(), deserializedNodeStats.getOs().getMem().getUsed());
            for (int i = 0; i < numDeviceStats; i++) {
                    randomAlphaOfLengthBetween(3, 10),
                        List<IngestStats.ProcessorStat> processorStats = ingestStats.getProcessorStats().get(pipelineId);
                List<IndexShardStats> incomingIndexStats = newNodeIndicesStats.getStatsByShard().get(newIndex);
            long memTotal = randomNonNegativeLong();
                }
                    adaptiveStats.getComputedStats().forEach((k, v) -> {
                if (limiterStats == null) {
                        nodeStats.getOs().getCgroup().getMemoryLimitInBytes(),
                );
    }
                incomingIndexStats.forEach(indexShardStats -> {
                    assertEquals(classes.getTotalLoadedClassCount(), deserializedJvm.getClasses().getTotalLoadedClassCount());
            nodeStats.writeTo(out);
        commonStatsFlags.set(CommonStatsFlags.Flag.Docs, true);
                } else {
                sentinel,
            remoteSegmentStats.addDownloadBytesSucceeded(10L);
    ) {
                    assertNull(deserializedNodeStats.getHttp());
        BytesStreamOutput out = new BytesStreamOutput();
        if (frequently()) {
import java.util.TreeMap;
                } else {
 * the Apache License, Version 2.0 (the "License"); you may
                    });
        commonStatsFlags.set(CommonStatsFlags.Flag.Docs, true);
                    assertEquals(
                        clusterManagerThrottlingStats.getThrottlingCount("test-task"),
                    );
                        .get(0);
                        assertEquals(remoteStateStats.getSuccessCount(), deserializedRemoteStateStats.getSuccessCount());
            List.of(new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L))
            null,
import org.opensearch.cluster.service.ClusterManagerThrottlingStats;
                RemoteStoreNodeStats deserializedRemoteStoreNodeStats = deserializedNodeStats.getRemoteStoreNodeStats();
                AdaptiveSelectionStats deserializedAdaptiveStats = deserializedNodeStats.getAdaptiveSelectionStats();
            super(oldStats, statsByShard, searchRequestStats, statusCounterStats, level);
 * this work for additional information regarding copyright
                        new IngestStats.ProcessorStat(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10), processorStats)
                    assertEquals(nodeStats.getTransport().getRxSize(), deserializedNodeStats.getTransport().getRxSize());
        long numDeletedDocs = randomLongBetween(0, 100);
                JvmStats jvm = nodeStats.getJvm();
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
                        ResponseCollectorService.ComputedNodeStats bStats = deserializedAdaptiveStats.getComputedStats().get(k);
                assertNull("native allocator stats must be null when written by an older node", roundtripped.getNativeAllocatorStats());
                );
        commonStatsFlags.set(CommonStatsFlags.Flag.Indexing, true);
                    assertEquals(replicationStats.getMaxReplicationLag(), deserializedReplicationStats.getMaxReplicationLag());
        commonStats.store = new StoreStats.Builder().sizeInBytes(randomLongBetween(0, 100))
            totalEstimatedNativeBytes
    }
            null,
                    assertEquals(fs.getTotal().getPath(), deserializedFs.getTotal().getPath());
                        .previousDeviceStats(null)
        );
        DiscoveryStats discoveryStats = frequently()
            null,
                    assertEquals(
            0L,
            null,
        MockNodeIndicesStats mockNodeIndicesStats = generateMockNodeIndicesStats(commonStats, newIndex, commonStatsFlags, null);
        return XContentHelper.convertToMap(BytesReference.bytes(xContentBuilder), true, xContentBuilder.contentType()).v2();
        levelParams.add(NodeIndicesStats.StatsLevel.SHARDS);
            Index newIndex = new Index("index", "_na_");
                    );
        commonStatsFlags.clear();
            .build();
                        deserializedNodeStats.getOs().getCgroup().getMemoryUsageInBytes()
 * You may obtain a copy of the License at
                in.setVersion(Version.V_3_7_0);
                    ResponseCollectorService.ComputedNodeStats stats = new ResponseCollectorService.ComputedNodeStats(
            nativeAllocatorStats,
     */
        if (frequently()) {
            fsInfo = new FsInfo(randomNonNegativeLong(), ioStats, paths);
                null,
                    randomNonNegativeLong()
                        deserializedNodeStats.getOs().getCgroup().getCpuStat().getNumberOfElapsedPeriods()
                    randomNonNegativeLong(),
                    ReplicationStats replicationStats = nodeIndicesStats.getSegments().getReplicationStats();
        Arrays.stream(NodeIndicesStats.StatsLevel.values()).forEach(level -> {
                            assertEquals(bufferPool.getName(), deserializedBufferPool.getName());
            ? new HttpStats.Builder().serverOpen(randomNonNegativeLong()).totalOpen(randomNonNegativeLong()).build()
                        admissionControllerStats.getRejectionCount().get(AdmissionControlActionType.INDEXING.getType()),
                MockNodeIndicesStats newNodeIndicesStats = new MockNodeIndicesStats(in);
        commonStats.segments = new SegmentsStats();
                            deserializedPools.get(entry.getKey()).getLastGcStats().getMax()
                        .currentQueueSize(randomNonNegativeLong())
                .txCount(randomNonNegativeLong())
                randomBoolean() ? new PendingClusterStateStats(randomInt(), randomInt(), randomInt()) : null,
    ) {
    private static ActionConcurrencyLimiterStats randomConcurrencyLimiterStats() {
        assertEquals(2048L, ((Number) runtime.get("resident_bytes")).longValue());
                        randomNonNegativeLong(),
                deviceStatsArray[i] = new FsInfo.DeviceStats.Builder().majorDeviceNumber(randomInt())
                mockNodeIndicesStats.writeTo(out);
            nodeCacheStats,
                nonAggregatedBuilder.endObject();
                if (nodeCacheStats == null) {
                    randomNonNegativeLong(),
                FsInfo.DeviceStats previousDeviceStats = randomBoolean()
                    assertEquals(nodeStats.getTransport().getTxSize(), deserializedNodeStats.getTransport().getTxSize());
        commonStats.indexing = new IndexingStats();
            : null;
            CommonStats oldStats,
                        assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));
                        assertEquals(
import org.opensearch.cluster.coordination.PersistedStateStats;
        commonStatsFlags.set(CommonStatsFlags.Flag.Docs, true);
                    long compilations = 0;
