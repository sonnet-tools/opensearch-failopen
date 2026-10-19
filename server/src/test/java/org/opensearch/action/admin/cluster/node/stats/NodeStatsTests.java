                        nodeStats.getOs().getCgroup().getCpuStat().getNumberOfTimesThrottled(),
                        randomDoubleBetween(1.0, 10000000.0, true),
            .build();  
        Index statsIndex = null;  
        );
                    );
            out.setVersion(Version.V_3_7_0);  
                    assertEquals(  
        return statsByShards;
import java.util.Iterator;  
                "total_estimated_bytes in the rendered JSON must be the sentinel value, not OsProbe re-read",
                        assertEquals(1, deserializedDiscoveryStats.getClusterStateStats().getPersistenceStats().size());
                        JvmStats.GarbageCollector garbageCollector = jvm.getGc().getCollectors()[i];
                        assertEquals(circuitBreakerStats.getEstimated(), deserializedCircuitBreakerStats.getEstimated());
            null, // blockCacheOnlyStats
                    randomAlphaOfLength(10),
                    assertNull(deserializedAdmissionControlStats);
                        assertEquals(stats.getActive(), deserializedStats.getActive());
                        nodeStats.getOs().getCpu().getLoadAverage(),
    ) {
                    .resolve(shardRouting.shardId().getIndex().getUUID())
                        randomAlphaOfLength(8),
                statsIndex = shardRouting.shardId().getIndex();  
import org.opensearch.gateway.remote.RemotePersistenceStats;
                    );
                indexShardStatsList.add(indexShardStats);  
        Map<String, Object> runtime = (Map<String, Object>) nativeMemory.get("runtime");
                        assertEquals(pipelineStat.getStats().getFailedCount(), deserializedPipelineStats.getFailedCount());  
        indexes.forEach(index -> {  
        levelParams.add(NodeIndicesStats.StatsLevel.SHARDS);
        DiscoveryStats discoveryStats = frequently()
            );  
            ? new ScriptStats.Builder().compilations(randomNonNegativeLong())  
                }
        // Pools are grouped under "memory_pools"
            Index newIndex = new Index("index", "_na_");  
            try (StreamInput in = out.bytes().streamInput()) {
            );
            null,
        NodeIndicesStats.StatsLevel level
        public Map<Index, CommonStats> getStatsByIndex() {  
            admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 1);  
            FsInfo.Path[] paths = new FsInfo.Path[numPaths];
                    .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))
                            .getPersistenceStats()
import org.opensearch.common.io.stream.BytesStreamOutput;
                        nodeStats.getProcess().getOpenFileDescriptors(),
                        deserializedNodeStats.getOs().getCgroup().getCpuAcctUsageNanos()  
        if (frequently()) {
            null,  
                        new JvmStats.MemoryPoolGcStats(randomNonNegativeLong(), randomNonNegativeLong())  
                        Iterator<IngestStats.ProcessorStat> it = deserializedIngestStats.getProcessorStats().get(pipelineId).iterator();  
                        compilations += generatedStats.getCompilations();
                    );
                    assertEquals(nodeStats.getOs().getMem().getFree(), deserializedNodeStats.getOs().getMem().getFree());  
                .resolve(String.valueOf(shardRouting.shardId().id()));
                    assertEquals(classes.getTotalLoadedClassCount(), deserializedJvm.getClasses().getTotalLoadedClassCount());  
                SegmentReplicationRejectionStats deserializedSegmentReplicationRejectionStats = deserializedNodeStats
            admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 2);
                        randomDoubleBetween(1.0, 100.0, true),  
            null,  
import org.opensearch.core.index.shard.ShardId;
                assertEquals(3, decoded.getPools().size());
                );
                }
                NodeStats deserialized = new NodeStats(in);
                        assertEquals(queueStats.getTotal(), deserializedDiscoveryStats.getQueueStats().getTotal());
                    assertEquals(
        );
        commonStatsFlags.clear();
                            assertEquals(bufferPool.getName(), deserializedBufferPool.getName());
import org.opensearch.monitor.process.ProcessStats;  
                new ActionConcurrencyLimiterStats.ActionLimiterSnapshot(
            null,
                    assertEquals(evictions, sum.getCacheEvictions());
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
        Map<String, Object> root = xContentBuilderToMap(builder);  
                        nodeStats.getConcurrencyLimiterStats().getSnapshots().size(),
            }
        List<IndexShardStats> indexShardStatsList = new ArrayList<>();
                ClusterManagerThrottlingStats deserializedClusterManagerThrottlingStats = deserializedNodeStats
    public void testConcurrencyLimiterStatsVersionGate() throws IOException {
                        assertEquals(
                .seqNoStats(null)
                    String shardName = "[" + indexName + "][" + shardNum + "]";
            remoteSegmentStats.addDownloadBytesStarted(10L);
import org.opensearch.index.shard.ShardPath;
            .evictions(randomLongBetween(0, 100))
            null,
                        deserializedNodeStats.getOs().getCgroup().getCpuStat().getTimeThrottledNanos()  
                        randomNonNegativeLong(),  
                    randomAlphaOfLength(5),  
                    JvmStats.Mem mem = jvm.getMem();
            .cacheCount(randomLongBetween(0, 100))
            remoteSegmentStats.addDownloadBytesFailed(1L);
                        randomNonNegativeLong(),  
            }
        NodeStats nodeStats = createNodeStats();
                    randomNonNegativeLong(),
        ScriptStats scriptStats = frequently()
                            assertNotNull(newNodeIndicesStats.getStatsByIndex());
                    RemoteSegmentStats remoteSegmentStats = nodeIndicesStats.getSegments().getRemoteSegmentStats();  
        ) {
            : null;
            int numGarbageCollectors = randomIntBetween(0, 10);
                garbageCollectorsArray[i] = new JvmStats.GarbageCollector(
                }
            @SuppressWarnings("unchecked")
                    assertEquals(incomingDocStats.getTotalSizeInBytes(), hostDocStats.getTotalSizeInBytes());
                            break;
            nodesResourceUsageStats,
                    ReplicationStats replicationStats = nodeIndicesStats.getSegments().getReplicationStats();
                        remoteSegmentStats.getDownloadBytesSucceeded(),
                } else {
                    assertEquals(
                    for (int i = 0; i < ioStats.getDevicesStats().length; i++) {
            } catch (IOException e) {  
                }  
    public void testFileCacheDetailedStatsVersionGate() throws IOException {
            Map<Index, List<IndexShardStats>> statsByShard,  
                    randomNonNegativeLong(),  
        @SuppressWarnings("unchecked")
                        randomIntBetween(1, 10),
                JvmStats jvm = nodeStats.getJvm();
            CommonStats oldStats,
                loadAverages[i] = randomBoolean() ? randomDouble() : -1;
                WeightedRoutingStats weightedRoutingStats = nodeStats.getWeightedRoutingStats();
                for (int shardNum = 0; shardNum < numShardsPerIndex; shardNum++) {  
import org.opensearch.common.cache.service.NodeCacheStats;
import org.opensearch.discovery.DiscoveryStats;  
import org.opensearch.index.store.StoreStats;
        CommonStatsFlags commonStatsFlags,  
                    );
                        FsInfo.DeviceStats deserializedDeviceStats = deserializedIoStats.getDevicesStats()[i];
                    randomBoolean() ? randomAlphaOfLengthBetween(3, 10) : null,  
                // add outgoing connection info  
import org.opensearch.common.xcontent.XContentFactory;
            allCircuitBreakerStats,
                        FsInfo.DeviceStats deviceStats = ioStats.getDevicesStats()[i];  
            null,
            NodeStats roundtripped = new NodeStats(in);  
                }
 * this file be licensed under the Apache-2.0 license or a
                    assertEquals(remoteSegmentStats.getTotalDownloadTime(), deserializedRemoteSegmentStats.getTotalDownloadTime());  
                            deserializedPools.get(entry.getKey()).getLastGcStats().getMax()
                    assertEquals(2, (long) admissionControllerStats.getRejectionCount().get(AdmissionControlActionType.INDEXING.getType()));
            Index newIndex = new Index("index", "_na_");
                    new ToXContent.MapParams(Collections.singletonMap("level", level.getRestName()))  
                        .currentReadsCompleted(randomNonNegativeLong())  
import org.opensearch.common.cache.stats.DefaultCacheStatsHolderTests;
                        assertEquals(entry.getValue().getMax(), deserializedPools.get(entry.getKey()).getMax());  
                } else {  
        long numDocs = randomLongBetween(0, 10000);
                        assertEquals(stateStats.getUpdateSuccess(), deserializedDiscoveryStats.getClusterStateStats().getUpdateSuccess());  
            }  
                if (nodeStats.getBreaker() == null) {  
import java.util.ArrayList;
            .hitCount(randomLongBetween(0, 100))
                } else if (deserializedScriptCacheStats.getContextStats() != null) {  
                    assertEquals(classes.getLoadedClassCount(), deserializedJvm.getClasses().getLoadedClassCount());
        NodeStats original = newNodeStatsWithNativeAllocator(node, null, sentinel);
                new StatusCounterStats(),
import org.opensearch.node.AdaptiveSelectionStats;
                randomNonNegativeLong()
                    nodeConnections.put(nodeId, randomLongBetween(0, 100));
                        ScriptStats generatedStats = stats.get(context);
        for (int i = 0; i < count; i++) {  
                assertEquals(nodeStats.getTimestamp(), deserializedNodeStats.getTimestamp());
        commonStats.fieldData = new FieldDataStats.Builder().memorySize(randomLongBetween(0, 100))  
            null,  
        weightedRoutingStats = WeightedRoutingStats.getInstance();
                    assertNull(deserializedNodeStats.getTransport());
                    final Map<String, JvmStats.MemoryPool> pools = StreamSupport.stream(mem.spliterator(), false)
                        assertEquals(pipelineStat.getStats().getCount(), deserializedPipelineStats.getCount());  
            statsByShards.put(index, indexShardStatsList);
import org.opensearch.action.ActionConcurrencyLimiterStats;
        AllCircuitBreakerStats allCircuitBreakerStats = null;
                NodeCacheStats nodeCacheStats = nodeStats.getNodeCacheStats();
                    for (int i = 0; i < nodeStats.getBreaker().getAllStats().length; i++) {
import org.opensearch.core.common.bytes.BytesReference;
            null,
                assertNull("native allocator stats must be null when written by an older node", roundtripped.getNativeAllocatorStats());  
                    assertEquals(
                threadPoolStatsList.add(
            allCircuitBreakerStats = new AllCircuitBreakerStats(circuitBreakerStatsArray);  
                } else {  
                    assertEquals(adaptiveStats.getRanks(), deserializedAdaptiveStats.getRanks());
            for (int i = 0; i < 3; i++) {  
                        assertEquals(entry.getValue().getName(), deserializedPools.get(entry.getKey()).getName());
                        randomNonNegativeLong(),
                        assertEquals(garbageCollector.getCollectionTime(), deserializedGarbageCollector.getCollectionTime());
                            stateStats.getUpdateTotalTimeInMillis(),
                        assertEquals(orig.getInFlight(), deser.getInFlight());
                    } else {
                    );  
                    flags.includeCacheType(cacheType);  
            SearchRequestStats searchRequestStats,
                        assertEquals(deviceStats.readOperations(), deserializedDeviceStats.readOperations());
import org.opensearch.common.xcontent.XContentHelper;  
            CommonStatsFlags flags = new CommonStatsFlags();  
            2048L,  
            .uploadBytesFailed(randomLongBetween(10000, 20000))  
            remoteTranslogStats.add(otherRemoteTranslogStats);
            discoveryStats,
                } else {
    }
                randomNonNegativeLong(),  
                    assertEquals(nodeStats.getHttp().getTotalOpen(), deserializedNodeStats.getHttp().getTotalOpen());
        NodeStats nodeStats = createNodeStats(true);
                        deserializedNodeStats.getOs().getCgroup().getCpuStat().getNumberOfTimesThrottled()
    public static class MockNodeIndicesStats extends NodeIndicesStats {
                NodeStats deserializedNodeStats = new NodeStats(in);
            ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
            null,  
import org.opensearch.core.common.io.stream.StreamInput;
                        assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));
                circuitBreakerStatsArray[i] = new CircuitBreakerStats(
            }
                        assertEquals(circuitBreakerStats.getName(), deserializedCircuitBreakerStats.getName());  
                }
                        assertEquals(generatedStats.getCompilationLimitTriggered(), deserStats.getCompilationLimitTriggered());
                        assertEquals(aResourceUsageStats.getCpuUtilizationPercent(), bResourceUsageStats.getCpuUtilizationPercent(), 0.0);
                    randomNonNegativeLong()  
        assertEquals(2048L, ((Number) runtime.get("resident_bytes")).longValue());
                bufferPoolList.add(  
            for (int i = 0; i < numDeviceStats; i++) {  
            buildNewFakeTransportAddress(),
                } else {
 * KIND, either express or implied.  See the License for the
import org.opensearch.monitor.os.OsStats;
                AdmissionControlStats deserializedAdmissionControlStats = deserializedNodeStats.getAdmissionControlStats();  
                    assertEquals(
                    randomBoolean() ? randomNonNegativeLong() : -1L
            CircuitBreakerStats[] circuitBreakerStatsArray = new CircuitBreakerStats[numCircuitBreakerStats];
        commonStatsFlags.set(CommonStatsFlags.Flag.Store, true);
                    assertNotNull(deserialized.getConcurrencyLimiterStats());
        }
            null,
                    randomBoolean(),
    }
            1024L,
            new StatusCounterStats()  
                        .completed(randomIntBetween(1, 1000))  
                        assertEquals(circuitBreakerStats.getTrippedCount(), deserializedCircuitBreakerStats.getTrippedCount(), 0);
            "test_node",  
                    assertEquals(ioStats.getTotalReadKilobytes(), deserializedIoStats.getTotalReadKilobytes());
import org.opensearch.node.IoUsageStats;
                }
                    .getClusterManagerThrottlingStats();
                        assertEquals(deviceStats.writeOperations(), deserializedDeviceStats.writeOperations());  
                .mem(new OsStats.Mem(memTotal, randomLongBetween(0, memTotal)))
        commonStatsFlags.set(CommonStatsFlags.Flag.Docs, true);  
                    randomNonNegativeLong()  
                        )  
            List<IngestStats.PipelineStat> ingestPipelineStats = new ArrayList<>(numPipelines);  
                );
            ShardRouting shardRouting = TestShardRouting.newShardRouting(  
            indicesStats,  
        DocsStats hostDocStats = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();
                    assertEquals(incomingDocStats.getAverageSizeInBytes(), hostDocStats.getAverageSizeInBytes());
                shardStatsList.add(shardStats);
                    ClusterStateStats stateStats = discoveryStats.getClusterStateStats();
                    assertEquals(ioStats.getTotalReadOperations(), deserializedIoStats.getTotalReadOperations());  
                    assertEquals(remoteSegmentStats.getMaxRefreshBytesLag(), deserializedRemoteSegmentStats.getMaxRefreshBytesLag());  
        );
            List<JvmStats.BufferPool> bufferPoolList = new ArrayList<>();
        }  
        NodeStats original = newNodeStatsWithNativeAllocator(node, stats);
        BytesStreamOutput out = new BytesStreamOutput();
                        assertEquals(stats.getLargest(), deserializedStats.getLargest());
        }
            Index index = new Index("test-index-" + i, "_na_");
                        randomIntBetween(0, 2000),  
            ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            adaptiveSelectionStats = new AdaptiveSelectionStats.Builder().clientOutgoingConnections(nodeConnections)
                        for (int i = 0; i < jvm.getBufferPools().size(); i++) {
    ) {
                ActionConcurrencyLimiterStats deserializedLimiterStats = deserializedNodeStats.getConcurrencyLimiterStats();  
                    assertEquals(jvm.getGc().getCollectors().length, deserializedJvm.getGc().getCollectors().length);
        ClusterStateStats stateStats = new ClusterStateStats();
import org.opensearch.common.cache.CacheType;
                        PersistedStateStats deserializedRemoteStateStats = deserializedDiscoveryStats.getClusterStateStats()  
                        assertEquals(circuitBreakerStats.getOverhead(), deserializedCircuitBreakerStats.getOverhead(), 0);
                    OperationStats totalStats = ingestStats.getTotalStats();  
        levelParams.add(NodeIndicesStats.StatsLevel.INDICES);
            int numProcessors = randomIntBetween(0, 10);
import org.opensearch.index.engine.SegmentsStats;  
                }
            } catch (IOException e) {  
    }
        }
            };
                throw new RuntimeException(e);
                        assertEquals(deviceStats.readKilobytes(), deserializedDeviceStats.readKilobytes());  
        FsInfo fsInfo = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
            Map<Index, List<IndexShardStats>> statsByShard,  
                            JvmStats.BufferPool bufferPool = jvm.getBufferPools().get(i);  
            : null;
        }
                    assertEquals(scriptStats.getCacheEvictions(), deserializedNodeStats.getScriptStats().getCacheEvictions());  
                    assertNull(deserializedNodeStats.getScriptStats());
            Path path = createTempDir().resolve("indices")  
                    );  
                    i,  
                    processorPerPipeline.add(  
                    assertEquals(fs.getTotal().getTotal(), deserializedFs.getTotal().getTotal());  
                        randomNonNegativeLong()
            mockNodeIndicesStats.writeTo(out);
            .build();
            return this.statsByShard;
                }
                DiscoveryStats discoveryStats = nodeStats.getDiscoveryStats();  
                    randomIntBetween(0, 50),
                    .retentionLeaseStats(null)  
                .cacheEvictions(randomNonNegativeLong())
        ThreadPoolStats threadPoolStats = null;  
import org.opensearch.core.indices.breaker.CircuitBreakerStats;  
     */  
     * Verifies that {@code fileCacheOnlyStats} and {@code blockCacheOnlyStats} are serialized on V_3_7_0+
        if (remoteStoreStats) {
                        deserializedRemoteSegmentStats.getDownloadBytesSucceeded()
                        deserializedSegmentReplicationRejectionStats.getTotalRejectionCount()
 * The OpenSearch Contributors require contributions made to  
                        randomNonNegativeLong(),
                        deserializedNodeStats.getOs().getCgroup().getCpuAcctControlGroup()
                    assertEquals(  
    public void testNativeAllocatorStatsRoundTripCurrentVersion() throws IOException {
                        randomAlphaOfLength(8),
                new ProcessStats.Cpu(randomShort(), randomNonNegativeLong()),
                    assertEquals(nodeStats.getOs().getTimestamp(), deserializedNodeStats.getOs().getTimestamp());
                        .currentWritesCompleted(randomNonNegativeLong())
            nodeStats.writeTo(out);
            StatusCounterStats statusCounterStats,
            assertEquals("totalEstimatedNativeBytes must round-trip on the wire", sentinel, roundtripped.getTotalEstimatedNativeBytes());
                        }  
                }  
                assertNull(deserialized.getFileCacheOnlyStats());
            List<JvmStats.MemoryPool> memoryPools = new ArrayList<>(numMemoryPools);  
            }
                if (limiterStats == null) {
        if (frequently()) {  
        if (frequently()) {  
                // fileCacheOnlyStats and blockCacheOnlyStats may be null (createNodeStats doesn't set them),
            ? new HttpStats.Builder().serverOpen(randomNonNegativeLong()).totalOpen(randomNonNegativeLong()).build()  
    }
                        assertEquals(aStats.responseTime, bStats.responseTime, 0.01);  
                        assertEquals(generatedStats.getCompilations(), deserStats.getCompilations());
                }
 * not use this file except in compliance with the License.
                        nodeStats.getOs().getCgroup().getCpuAcctUsageNanos(),
            try (StreamInput in = out.bytes().streamInput()) {
            StatsLevel level  
                        for (IngestStats.ProcessorStat processorStat : processorStats) {
            Map<String, Long> nodeConnections = new HashMap<>();
                new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L),
        IngestStats ingestStats = null;
            adaptiveSelectionStats,  
        commonStats.indexing = new IndexingStats();  
            }
        int count = randomIntBetween(1, 3);
                        .waitTimeNanos(randomIntBetween(-1, 10))
                    );
            osStats = new OsStats.Builder().timestamp(System.currentTimeMillis())
                        ThreadPoolStats.Stats stats = threadPoolIterator.next();  
    }  
            }  
                    assertEquals(nodeStats.getTransport().getTxCount(), deserializedNodeStats.getTransport().getTxCount());  
            .uploadBytesStarted(randomLongBetween(10000, 50000))
                        assertEquals(stats.getThreads(), deserializedStats.getThreads());  
            ? new ProcessStats(
                    }
                .build()  
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControllerStats;  
                i,
                        randomNonNegativeLong(),
            null,  
                        .minorDeviceNumber(randomInt())
                            break;  
            null,
            super(oldStats, statsByShard, searchRequestStats, statusCounterStats, level);
                new HashMap<>(),  
                randomNonNegativeLong(),
                randomBoolean() ? stateStats : null
                        assertEquals(entry.getValue().getUsed(), deserializedPools.get(entry.getKey()).getUsed());  
        List<Index> indexList = new ArrayList<>();
import org.opensearch.index.shard.DocsStats;
            null,
                    .currentWritesCompleted(randomNonNegativeLong())  
                        ActionConcurrencyLimiterStats.ActionLimiterSnapshot orig = limiterStats.getSnapshots().get(i);
        weightedRoutingStats.updateFailOpenCount();
                level
        if (commonStatsFlags.getIncludeIndicesStatsByLevel()) {
                    assertEquals(
                } else {
                }
                        CacheStats toIncrement = new CacheStats(randomInt(20), randomInt(20), randomInt(20), randomInt(20), randomInt(20));
                new StatusCounterStats(),
                    ResponseCollectorService.ComputedNodeStats stats = new ResponseCollectorService.ComputedNodeStats(  
                if (frequently()) {
import org.opensearch.index.shard.IndexingStats;  
                .rxCount(randomNonNegativeLong())
                if (nodeStats.getThreadPool() == null) {  
            -1L
                    });
                } else {  
        statsByShard.put(statsIndex, indexShardStatsList);
                ClusterManagerThrottlingStats clusterManagerThrottlingStats = nodeStats.getClusterManagerThrottlingStats();  
        CommonStats commonStats,
                    assertEquals(remoteSegmentStats.getTotalUploadTime(), deserializedRemoteSegmentStats.getTotalUploadTime());
                    assertEquals(fs.getTimestamp(), deserializedFs.getTimestamp());
                            randomNonNegativeLong()
            statsByShards,
                }  
                    resourceUsageStatsMap.put(nodeId, stats);
                        randomAlphaOfLengthBetween(3, 10),
                .cgroup(  
            out.setVersion(Version.V_3_6_0);
                new SearchRequestStats(clusterSettings),  
            in.setVersion(Version.CURRENT);
    private OperationStats getPipelineStats(List<IngestStats.PipelineStat> pipelineStats, String id) {  
                new NativeAllocatorPoolStats.PoolStats("ingest", 200L, 400L, 4096L),
                        deserializedNodeStats.getOs().getCpu().getLoadAverage(),  
            return this.stats;  
                    nodeStats.put(nodeId, stats);
                if (admissionControlStats == null) {
import org.opensearch.node.NodesResourceUsageStats;
                IndexShardStats indexShardStats = new IndexShardStats(shardRouting.shardId(), shardStatsList.toArray(new ShardStats[0]));
import org.opensearch.cluster.node.DiscoveryNode;  
                )  
            .totalSizeInBytes(randomLongBetween(0, 1000))
            }
        NativeAllocatorPoolStats stats = new NativeAllocatorPoolStats(
                shardRoutingState
            remoteSegmentStats.addMaxRefreshBytesLag(2L);  
                    assertEquals(ingestStats.getPipelineStats().size(), deserializedIngestStats.getPipelineStats().size());
                        assertEquals(jvm.getBufferPools().size(), deserializedJvm.getBufferPools().size());
                    assertEquals(nodeStats.getOs().getSwap().getUsed(), deserializedNodeStats.getOs().getSwap().getUsed());
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;  
                deviceStatsArray[i] = new FsInfo.DeviceStats.Builder().majorDeviceNumber(randomInt())
        return new ActionConcurrencyLimiterStats(snapshots);  
     */
                    randomDouble(),
        return new NodeStats(  
            int numCircuitBreakerStats = randomIntBetween(0, 10);
                    assertEquals(ioStats.getDevicesStats().length, deserializedIoStats.getDevicesStats().length);
            out.setVersion(Version.V_3_9_0);  
                randomNonNegativeLong(),
                } else {
                        );
            null,
 * the Apache License, Version 2.0 (the "License"); you may
                        deserializedNodeStats.getOs().getCgroup().getCpuStat().getNumberOfElapsedPeriods()
        });  
                aggregatedBuilder.endObject();
            assertEquals(
                        deserializedAdmissionControllerStats.getRejectionCount().get(AdmissionControlActionType.INDEXING.getType())
import org.opensearch.cluster.routing.ShardRouting;
                    assertEquals(nodeStats.getOs().getSwap().getFree(), deserializedNodeStats.getOs().getSwap().getFree());  
import org.opensearch.plugin.stats.NativeAllocatorPoolStats;
        });  
                        assertEquals(generatedStats.getCacheEvictions(), deserStats.getCacheEvictions());
                    assertEquals(nodeStats.getTransport().getRxSize(), deserializedNodeStats.getTransport().getRxSize());
                    assertEquals(
            null, // nodeCacheStats
                paths[i] = new FsInfo.Path(
                randomBoolean() ? new PendingClusterStateStats(randomInt(), randomInt(), randomInt()) : null,
        // Build via the existing helper so the test is robust against future ctor argument churn.
import java.util.Collections;
                NativeAllocatorPoolStats decoded = roundtripped.getNativeAllocatorStats();  
        }
                    assertEquals(mem.getHeapUsed(), deserializedMem.getHeapUsed());
                    assertEquals(  
        List<NodeIndicesStats.StatsLevel> levelParams = new ArrayList<>();  
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
                    assertEquals(remoteSegmentStats.getUploadBytesSucceeded(), deserializedRemoteSegmentStats.getUploadBytesSucceeded());  
                    assertEquals(  
        // V_3_7_0: concurrencyLimiterStats is not on the wire; deserialization must not throw
            )  
    }
            .missCount(randomLongBetween(0, 100))  
            MockNodeIndicesStats mockNodeIndicesStats = generateMockNodeIndicesStats(commonStats, newIndex, commonStatsFlags, level);  
                    return 123456L;
import java.io.IOException;  
                        );
        // It is possible to test other metrics in NodeIndicesStats as well since it extends Writeable now
        if (frequently()) {  
                    randomNonNegativeLong(),
                    } else {
            long memTotal = randomNonNegativeLong();  
        @SuppressWarnings("unchecked")
            }
            .reservedSize(randomLongBetween(0, 1000))
            admissionControlStats = new AdmissionControlStats(statsList);
 * Modifications Copyright OpenSearch Contributors. See
                        assertEquals(queueStats.getPending(), deserializedDiscoveryStats.getQueueStats().getPending());
                .swap(new OsStats.Swap(swapTotal, randomLongBetween(0, swapTotal)))
                    assertNull(deserializedNodeStats.getThreadPool());
        NativeAllocatorPoolStats nativeAllocatorStats,  
            randomNonNegativeLong(),
                        );
                    : null,
                    ScriptStats sum = deserializedScriptCacheStats.sum();
                FsInfo deserializedFs = deserializedNodeStats.getFs();  
                if (frequently()) {
 */
            ? new TransportStats.Builder().serverOpen(randomNonNegativeLong())  
            null,  
                        deserialized.getConcurrencyLimiterStats().getSnapshots().size()
import java.util.List;
                        assertEquals(aStats.serviceTime, bStats.serviceTime, 0.01);
            ) {  
                    assertNull(deserializedNodeStats.getBreaker());
            null,
                    }  
                        assertEquals(orig.getCurrentLimit(), deser.getCurrentLimit());
}
        assertEquals(2048L, ((Number) flight.get("limit_bytes")).longValue());  
            nativeAllocatorStats,  
            DefaultCacheStatsHolder statsHolder = new DefaultCacheStatsHolder(dimensionNames, "dummyStoreName");  
        commonStats.segments = new SegmentsStats();
                        assertEquals(queueStats.getCommitted(), deserializedDiscoveryStats.getQueueStats().getCommitted());  
        Map<Index, List<IndexShardStats>> statsByShard = new HashMap<>();
                .commitStats(null)
        levelParams.add(NodeIndicesStats.StatsLevel.SHARDS);
     * total_estimated_bytes must be captured on the data node hosting this NodeStats and survive
import static java.util.Collections.emptySet;
                        NodeResourceUsageStats aResourceUsageStats = resourceUsageStats.getNodeIdToResourceUsageStatsMap().get(k);  
            out.setVersion(Version.V_3_7_0);
                        assertEquals(orig.getAlias(), deser.getAlias());  
                } else {
                            0.0  
            .uploadBytesSucceeded(randomLongBetween(5000, 10000))
                    assertEquals(jvm.getTimestamp(), deserializedJvm.getTimestamp());  
import org.opensearch.search.suggest.completion.CompletionStats;  
 * SPDX-License-Identifier: Apache-2.0
        long numDocs = randomLongBetween(0, 10000);
        DiscoveryNode localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);  
            for (int i = 0; i < numNodes; i++) {
                        assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
                            .get(k);
                new CommonStats(commonStatsFlags),
            indexList.add(index);
                        List<IngestStats.ProcessorStat> processorStats = ingestStats.getProcessorStats().get(pipelineId);
                    .build();
        levelParams.forEach(level -> {
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControlStats;
                        .getAdmissionControllerStatsList()
                .retentionLeaseStats(null)  
                Path path = createTempDir().resolve("indices")  
                }
                        nodeStats.getOs().getCgroup().getCpuCfsPeriodMicros(),
            for (int i = 0; i < numCircuitBreakerStats; i++) {  
                    assertEquals(ioStats.getTotalOperations(), deserializedIoStats.getTotalOperations());
                }
                level
                    assertEquals(compilations, sum.getCompilations());
                ingestPipelineStats.add(
                    );
                @Override  
                    }  
                        nodeId,
                for (int j = 0; j < numProcessors; j++) {
                    nodeConnections.put(nodeId, randomLongBetween(0, 100));
            remoteSegmentStats.addUploadBytesStarted(10L);
        public MockNodeIndicesStats(
        );  
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
                        randomNonNegativeLong()
                NodeIndicesStats nodeIndicesStats = nodeStats.getIndices();
            CommonStatsFlags.Flag.Store,
                assertEquals(1024L, decoded.getNativeAllocatedBytes());
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
            null,
import org.opensearch.cluster.routing.WeightedRoutingStats;
        NodeCacheStats nodeCacheStats = null;  
                if (clusterManagerThrottlingStats == null) {  
                    adaptiveStats.getComputedStats().forEach((k, v) -> {  
                            deserializedDiscoveryStats.getClusterStateStats().getUpdateTotalTimeInMillis()  
        long sentinel = 4_026_531_840L; // distinctive value, unlikely to match coordinator RSS
        commonStatsFlags.set(CommonStatsFlags.Flag.Indexing, true);
                assertNotNull("native allocator stats must round-trip on current wire version", decoded);
import static org.hamcrest.CoreMatchers.is;
     * survive serialize/deserialize unchanged.  
                    new OsStats.Cgroup(
        }
                    .commitStats(null)
                    assertEquals(
                        randomDoubleBetween(1.0, 100.0, true)  
        }
            .totalUploadsFailed(randomLongBetween(100, 200))  
                .build();  
                    assertEquals(totalStats.getCurrent(), deserializedIngestStats.getTotalStats().getCurrent());
                nonAggregatedBuilder = XContentFactory.jsonBuilder();
                        assertEquals(  
            );
                } else {
                }
                assertNull(deserialized.getFileCacheOnlyStats());
        }
                            assertNull(newNodeIndicesStats.getStatsByShard());  
    }
            : null;
                    .build();
            fsInfo = new FsInfo(randomNonNegativeLong(), ioStats, paths);  
import org.opensearch.transport.TransportStats;
                        assertEquals(garbageCollector.getName(), deserializedGarbageCollector.getName());  
                classes  
            emptySet(),  
                .compilationLimitTriggered(randomNonNegativeLong())
     * Round-trip on the current wire version — the typed allocator stats payload must
                        assertEquals(deviceStats.operations(), deserializedDeviceStats.operations());
        // Runtime stats are nested under "runtime"  
                if (nodeStats.getOs() == null) {
                    randomFrom("enforced", "monitor_only", "disabled"),
                            entry.getValue().getLastGcStats().getUsed(),  
            );
            }  
import org.opensearch.cluster.routing.ShardRoutingState;
                new NativeAllocatorPoolStats.PoolStats("query", 300L, 600L, 2048L)  
                    assertEquals(scriptStats.getCompilations(), deserializedNodeStats.getScriptStats().getCompilations());
                index.getName(),
                .build();
        }
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
                    final int poolsCount = (int) StreamSupport.stream(nodeStats.getJvm().getMem().spliterator(), false).count();
            }
        DiscoveryNode node,
            for (int i = 0; i < numGarbageCollectors; i++) {
            null,  
                        clusterManagerThrottlingStats.getThrottlingCount("test-task"),
                new CommonStats(CommonStatsFlags.ALL),
            nodeCacheStats = new NodeCacheStats(cacheStatsMap, flags);  
            super(in);
import org.opensearch.monitor.fs.FsInfo;  
                    assertEquals(jvm.getThreads().getCount(), deserializedJvm.getThreads().getCount());
                        assertNull(deserializedJvm.getBufferPools());
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
                    }
     */
                if (scriptCacheStats == null) {
    public void testOldVersionNodes() throws IOException {  
                    JvmStats.Mem deserializedMem = deserializedJvm.getMem();
    }
            List.of(new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L))
                        new IngestStats.ProcessorStat(randomAlphaOfLengthBetween(3, 10), randomAlphaOfLengthBetween(3, 10), processorStats)
 */  
                        assertNull(deserializedDiscoveryStats.getClusterStateStats());  
                List<ShardStats> shardStatsList = new ArrayList<>();  
import org.opensearch.index.cache.query.QueryCacheStats;
            }  
                assertEquals(2048L, decoded.getNativeResidentBytes());  
                    assertThat(pools.keySet(), hasSize(poolsCount));  
    public void testNodeIndicesStatsWithAndWithoutAggregations() throws IOException {  
        JvmStats jvmStats = null;  
            null,
                    : new FsInfo.DeviceStats.Builder().majorDeviceNumber(randomInt())  
        OsStats osStats = null;  
import org.opensearch.monitor.jvm.JvmStats;
        ProcessStats processStats = frequently()  
            out.setVersion(Version.V_2_13_0);
            null,
            .cacheSize(randomLongBetween(0, 100))
    public MockNodeIndicesStats generateMockNodeIndicesStats(  
import java.util.LinkedHashMap;
                .pollingIngestStats(null)
        commonStats.queryCache = new QueryCacheStats.Builder().ramBytesUsed(randomLongBetween(0, 100))
                    nonAggregatedBuilder,
            null,
        TransportStats transportStats = frequently()
                    assertEquals(remoteSegmentStats.getUploadBytesFailed(), deserializedRemoteSegmentStats.getUploadBytesFailed());
                    assertEquals(adaptiveStats.getOutgoingConnections(), deserializedAdaptiveStats.getOutgoingConnections());
            threadPoolStats,
        assertNotNull("flight pool must be present in memory_pools", flight);
        commonStatsFlags.set(CommonStatsFlags.Flag.Indexing, true);
import java.util.HashMap;
                        break;
                )  
                    .currentWriteTime(randomNonNegativeLong())  
                    assertEquals(remoteSegmentStats.getDownloadBytesFailed(), deserializedRemoteSegmentStats.getDownloadBytesFailed());
    public static NodeStats createNodeStats() throws IOException {  
            super(oldStats, statsByShard, searchRequestStats, statusCounterStats);
/*
                        assertEquals(
                new JvmStats.Mem(
            .totalUploadsStarted(randomLongBetween(100, 500))
                        assertThat(deserializedPools.containsKey(entry.getKey()), is(true));
                    assertEquals(nodeStats.getTransport().getTxSize(), deserializedNodeStats.getTransport().getTxSize());
        } else {
        nodeStats.toXContent(builder, ToXContent.EMPTY_PARAMS);
            null,
            .totalDownloadsSucceeded(0L)  
                    assertEquals(ioStats.getTotalReadTime(), deserializedIoStats.getTotalReadTime());  
            node,
import org.opensearch.node.ResponseCollectorService;
                        randomDoubleBetween(1.0, 100.0, true),
        assertNotNull("native_memory wrapper must be opened when allocator stats are present", nativeMemory);
                        deserializedNodeStats.getOs().getCgroup().getCpuCfsQuotaMicros()  
                    assertNull(deserializedNodeStats.getProcess());
            remoteSegmentStats.addUploadBytesSucceeded(10L);  
                    );
            for (int i = 0; i < numPaths; i++) {  
import org.opensearch.core.xcontent.ToXContent;
            1024L,
                in.setVersion(Version.V_2_18_0);
            AdmissionControllerStats stats = new AdmissionControllerStats(admissionController);
                    assertNull(deserializedAdaptiveStats);
                    }  
            XContentBuilder builder = null;
                        assertEquals(garbageCollector.getCollectionCount(), deserializedGarbageCollector.getCollectionCount());
        commonStats.flush = new FlushStats.Builder().total(randomLongBetween(0, 100))
                new StatusCounterStats()
                assertEquals(100L, decoded.getPools().get(0).getAllocatedBytes());  
                        assertTrue(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));  
     * asserts the JSON shape: a top-level {@code native_memory} block with  
                ((Number) nativeMemory.get("total_estimated_bytes")).longValue()
            : null;
                WeightedRoutingStats deserializedWeightedRoutingStats = deserializedNodeStats.getWeightedRoutingStats();
                    randomNonNegativeLong(),  
            int numMemoryPools = randomIntBetween(0, 10);
                    randomNonNegativeLong(),  
            segmentReplicationRejectionStats = new SegmentReplicationRejectionStats(randomNonNegativeLong());  
            try (BytesStreamOutput out = new BytesStreamOutput()) {
            CommonStatsFlags.Flag.Docs,  
            Map<String, Long> nodeConnections = new HashMap<>();
            }
    public void testNodeIndicesStatsToXContent() {  
import org.opensearch.core.indices.breaker.AllCircuitBreakerStats;
                    if (stateStats == null) {
                        nodeStats.getOs().getCgroup().getMemoryUsageInBytes(),
    public void testNativeAllocatorStatsXContentRendersInsideNativeMemory() throws IOException {  
        if (frequently()) {
            int numIndices = randomIntBetween(1, 10);
import java.util.TreeMap;
                    .currentSectorsRead(randomNonNegativeLong())
                    );
                        randomNonNegativeLong(),
 * this work for additional information regarding copyright
                        assertEquals(orig.getTotalRejected(), deser.getTotalRejected());  
        assertEquals(100L, ((Number) flight.get("allocated_bytes")).longValue());
            totalEstimatedNativeBytes
            List.of(new NativeAllocatorPoolStats.PoolStats("flight", 100L, 200L, 2048L))
 *
                    assertEquals(incomingDocStats.getDeleted(), hostDocStats.getDeleted());  
            osStats,
     * gate must keep them round-tripping cleanly: the receiver should see {@code null}.
                        CircuitBreakerStats circuitBreakerStats = nodeStats.getBreaker().getAllStats()[i];
                    );
        }
            RemoteTranslogStats remoteTranslogStats = indicesStats.getTranslog().getRemoteTranslogStats();  
        List<NodeIndicesStats.StatsLevel> levelParams = new ArrayList<>();  
        commonStats.store = new StoreStats.Builder().sizeInBytes(100).reservedSize(0L).build();
            try (StreamInput in = out.bytes().streamInput()) {
                ActionConcurrencyLimiterStats limiterStats = nodeStats.getConcurrencyLimiterStats();
        if (frequently()) {  
            );
                    randomNonNegativeLong(),
                assertNull(deserialized.getBlockCacheOnlyStats());
            .totalUploadTimeInMillis(0L)
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
            .downloadBytesPerSecMovingAverage(0D)
import org.opensearch.action.admin.indices.stats.StatusCounterStats;
        public MockNodeIndicesStats(
                        deserializedAdmissionControllerStats.getRejectionCount().get(AdmissionControlActionType.SEARCH.getType())
                    );
                null
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                    assertNull(deserializedWeightedRoutingStats);
        return newNodeStatsWithNativeAllocator(node, nativeAllocatorStats, -1L);
                FsInfo fs = nodeStats.getFs();
        levelParams.add(NodeIndicesStats.StatsLevel.INDICES);
                if (jvm == null) {
                aggregatedBuilder = XContentFactory.jsonBuilder();
                    assertEquals(limiterStats.getSnapshots().size(), deserializedLimiterStats.getSnapshots().size());
                            deserializedPools.get(entry.getKey()).getLastGcStats().getUsagePercent()  
                    assertEquals(nodeStats.getOs().getMem().getFreePercent(), deserializedNodeStats.getOs().getMem().getFreePercent());  
        out.setVersion(Version.CURRENT);
            node,
                .rxSize(randomNonNegativeLong())  
                DiscoveryStats deserializedDiscoveryStats = deserializedNodeStats.getDiscoveryStats();
                        admissionControllerStats.getRejectionCount().get(AdmissionControlActionType.INDEXING.getType()),  
    private static NodeStats newNodeStatsWithNativeAllocator(
                NodeStats roundtripped = new NodeStats(in);
        // V_3_8_0: concurrencyLimiterStats round-trips (may be null or non-null)
        WeightedRoutingStats weightedRoutingStats = null;  
            .fieldMemoryStats(null)
                nonAggregatedBuilder = nonAggregatedNodeIndicesStats.toXContent(
import java.nio.file.Path;
            emptyMap(),
        long numDocs = randomLongBetween(0, 10000);
        NodeStats nodeStats = createNodeStats();
                garbageCollectors,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    assertNull(deserializedFs);
 * software distributed under the License is distributed on an
                .build()  
                        case SHARDS:  
                    );
    }
import org.opensearch.node.remotestore.RemoteStoreNodeStats;  
                        0
                    assertEquals(ioStats.getTotalQueueSize(), deserializedIoStats.getTotalQueueSize());
        commonStats.indexing = new IndexingStats();
                }
                    assertNull(deserializedNodeCacheStats);
                } else {
                    randomNonNegativeLong()
            .lastSuccessfulDownloadTimestamp(0L)
    }
                ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
import static java.util.Collections.emptyMap;  
                    );  
            remoteSegmentStats.addTotalDownloadTime(20L);  
                    assertNull(deserializedJvm);
                    assertEquals(replicationStats.getMaxBytesBehind(), deserializedReplicationStats.getMaxBytesBehind());
        NativeAllocatorPoolStats stats = new NativeAllocatorPoolStats(
                assertEquals(2048L, decoded.getPools().get(0).getLimitBytes());
            statsList.add(stats);
            }
                    builder,
                }
                }  
                        .queue(randomIntBetween(1, 1000))
                builder = mockNodeIndicesStats.toXContent(  
                    );  
            remoteSegmentStats.addTotalUploadTime(20L);
                        PersistedStateStats remoteStateStats = stateStats.getPersistenceStats().get(0);  
            0L,
                        randomNonNegativeLong(),
        assertNotNull("memory_pools block must be present", pools);
            frequently() ? randomConcurrencyLimiterStats() : null,
            null,  
                        .currentReadTime(randomNonNegativeLong())
     * renders, and asserts the rendered value matches the constructed value verbatim.
            remoteSegmentStats.addDownloadBytesSucceeded(10L);  
                    assertEquals(ioStats.getTotalWriteKilobytes(), deserializedIoStats.getTotalWriteKilobytes());
                        assertEquals(orig.getRttNoLoadMillis(), deser.getRttNoLoadMillis());
                } else {
                    }  
                    ? null
                    if (queueStats == null) {  
                        nodeStats.getOs().getCgroup().getMemoryLimitInBytes(),  
        );
        int numberOfIndexes = randomIntBetween(1, 3);
    }
                    FsInfo.IoStats ioStats = fs.getIoStats();
                        .currentSectorsRead(randomNonNegativeLong())
                in.setVersion(Version.CURRENT);
                        nodeStats.getProcess().getMem().getTotalVirtual(),
                    assertEquals(  
                JvmStats deserializedJvm = deserializedNodeStats.getJvm();  
    private static ActionConcurrencyLimiterStats randomConcurrencyLimiterStats() {  
                            assertNull(newNodeIndicesStats.getStatsByIndex());
                Map<String, Object> xContentMap = xContentBuilderToMap(builder);  
                        .getRemoteTranslogStats();
                        randomDoubleBetween(1.0, 10000000.0, true)
                    )  
        }  
                        nodeStats.getOs().getCgroup().getCpuStat().getTimeThrottledNanos(),
                        deserializedNodeStats.getOs().getCgroup().getCpuControlGroup()
            FsInfo.IoStats ioStats = new FsInfo.IoStats(deviceStatsArray);  
                        .collect(Collectors.toMap(JvmStats.MemoryPool::getName, Function.identity()));  
import org.opensearch.test.VersionUtils;
                }
    public void testNodeIndicesStatsSerialization() throws IOException {  
    }
            CommonStatsFlags.Flag.FieldData,
                    assertEquals(nodeStats.getTransport().getRxCount(), deserializedNodeStats.getTransport().getRxCount());  
                        .collect(Collectors.toMap(JvmStats.MemoryPool::getName, Function.identity()));  
                        assertEquals(aStats.queueSize, bStats.queueSize, 0.01);
                    .currentSectorsWritten(randomNonNegativeLong())
                    assertEquals(
            }
                    assertEquals(replicationStats.getTotalBytesBehind(), deserializedReplicationStats.getTotalBytesBehind());
                NodeStats deserialized = new NodeStats(in);
            nodeStats.writeTo(out);  
                    assertEquals(nodeStats.getProcess().getTimestamp(), deserializedNodeStats.getProcess().getTimestamp());
            builder.endObject();
                    assertEquals(jvm.getThreads().getPeakCount(), deserializedJvm.getThreads().getPeakCount());
                        clusterManagerThrottlingStats.getTotalThrottledTaskCount(),
                    assertEquals(incomingDocStats.getCount(), hostDocStats.getCount());  
                // but deserialization must not throw  
                    .previousDeviceStats(previousDeviceStats)  
                null,
        return commonStats;  
                    new ToXContent.MapParams(Collections.singletonMap("level", level.getRestName()))  
                }  
                        .currentWriteTime(randomNonNegativeLong())
                    assertEquals(totalStats.getCount(), deserializedIngestStats.getTotalStats().getCount());
                        nodeStats.getOs().getCgroup().getCpuCfsQuotaMicros(),
        commonStats.docs = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();  
            CommonStatsFlags.Flag.Completion,  
                new SearchRequestStats(clusterSettings),  
            null,
                            .get(0);
                        ResponseCollectorService.ComputedNodeStats bStats = deserializedAdaptiveStats.getComputedStats().get(k);
                aggregatedBuilder.startObject();  
                // add outgoing connection info  
                            randomNonNegativeLong(),  
            for (int i = 0; i < numNodes; i++) {
                String nodeId = randomAlphaOfLengthBetween(3, 10);
                randomNonNegativeLong(),  
    private HashMap<Index, List<IndexShardStats>> createRandomShardByStats(List<Index> indexes) {  
                IngestStats ingestStats = nodeStats.getIngestStats();
                }
                            assertEquals(processorStat.getStats().getFailedCount(), deserializedProcessorStat.getStats().getFailedCount());  
        }  
            remoteStoreNodeStats,
            Map<String, ResponseCollectorService.ComputedNodeStats> nodeStats = new HashMap<>();  
import org.opensearch.action.admin.indices.stats.CommonStats;  
        @SuppressWarnings("unchecked")
                        admissionControllerStats.getAdmissionControllerName(),
                    for (int i = 0; i < limiterStats.getSnapshots().size(); i++) {  
    }
            segmentReplicationRejectionStats,
            try {
                            aResourceUsageStats.getMemoryUtilizationPercent(),
import org.opensearch.script.ScriptStats;
                        evictions += generatedStats.getCacheEvictions();
    }
                    aggregatedBuilder,
                assertEquals(nodeStats.getNode(), deserializedNodeStats.getNode());  
                        ActionConcurrencyLimiterStats.ActionLimiterSnapshot deser = deserializedLimiterStats.getSnapshots().get(i);
                assertNull("V_3_7_0 must not include concurrencyLimiterStats", deserialized.getConcurrencyLimiterStats());  
            );  
                        deserializedNodeStats.getProcess().getMem().getTotalVirtual()  
                    }
                    );
            null,  
                    assertEquals(
                    }
                        System.currentTimeMillis(),
     * the wire round-trip; the coordinator must NOT re-read its own OsProbe at toXContent time.
                        deserializedAdmissionControllerStats.getAdmissionControllerName()
                            assertEquals(processorStat.getStats().getCount(), deserializedProcessorStat.getStats().getCount());  
                }  
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);  
                        assertEquals(pipelineStat.getStats().getTotalTime(), deserializedPipelineStats.getTotalTime());
        commonStats.indexing = new IndexingStats();
            return new MockNodeIndicesStats(
                NodeIndicesStats deserializedNodeIndicesStats = deserializedNodeStats.getIndices();
        return indicesStats;
                    -1L,  
                    .pollingIngestStats(null)
                    new IngestStats.PipelineStat(
        commonStatsFlags.clear();
import org.opensearch.cluster.service.ClusterManagerThrottlingStats;
                Map<String, Object> aggregatedContentMap = xContentBuilderToMap(aggregatedBuilder);  
                        .build()  
                randomBoolean()
                    }  
            try (StreamInput in = out.bytes().streamInput()) {  
            try (StreamInput in = out.bytes().streamInput()) {  
        commonStats.store = new StoreStats.Builder().sizeInBytes(randomLongBetween(0, 100))  
                IngestStats deserializedIngestStats = deserializedNodeStats.getIngestStats();
            long swapTotal = randomNonNegativeLong();
        }
                        .threads(randomIntBetween(1, 1000))
                    FsInfo.IoStats deserializedIoStats = deserializedFs.getIoStats();  
                    assertEquals(
                        randomNonNegativeLong(),  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.admin.indices.stats.ShardStats;  
                } else {
                assertEquals("flight", decoded.getPools().get(0).getName());
                    assertEquals(fs.getTotal().getMount(), deserializedFs.getTotal().getMount());
                            randomNonNegativeLong(),
                if (frequently()) {
                        new OsStats.Cgroup.CpuStat(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),
                        // intentionally validating identical order
        }
            if (statsIndex == null) {
                    assertEquals(mem.getHeapMax(), deserializedMem.getHeapMax());  
            FsInfo.DeviceStats[] deviceStatsArray = new FsInfo.DeviceStats[numDeviceStats];
                new CommonStats(commonStatsFlags),  
        MockNodeIndicesStats mockNodeIndicesStats = generateMockNodeIndicesStats(commonStats, newIndex, commonStatsFlags, null);  
                    assertEquals(
                threads,  
                    assertNull(deserializedScriptCacheStats);
                }
        long totalEstimatedNativeBytes
            fsInfo,
                if (nodeCacheStats == null) {  
                        assertEquals(stats.getQueue(), deserializedStats.getQueue());
                    assertNull(deserializedResourceUsageStats);  
                    assertEquals(  
                    Iterator<ThreadPoolStats.Stats> deserializedThreadPoolIterator = deserializedNodeStats.getThreadPool().iterator();
                    assertEquals(mem.getNonHeapUsed(), deserializedMem.getNonHeapUsed());
import org.opensearch.cluster.coordination.PendingClusterStateStats;  
import org.opensearch.node.NodeResourceUsageStats;  
                        DefaultCacheStatsHolderTests.populateStatsHolderFromStatsValueMap(
            int numPaths = randomIntBetween(0, 10);
            try {  
                    );  
import org.opensearch.cluster.service.ClusterStateStats;  
 */  
        DiscoveryNode localNode = new DiscoveryNode("node", buildNewFakeTransportAddress(), Version.CURRENT);
                        assertEquals(remoteStateStats.getFailedCount(), deserializedRemoteStateStats.getFailedCount());
        try (StreamInput in = out.bytes().streamInput()) {
                    new ToXContent.MapParams(Collections.singletonMap("level", level.getRestName()))
        }  
    }
                in.setVersion(Version.V_3_9_0);  
            clusterManagerThrottlingStats = new ClusterManagerThrottlingStats();
                    assertEquals(weightedRoutingStats.getFailOpenCount(), deserializedWeightedRoutingStats.getFailOpenCount());  
            TreeMap<CacheType, ImmutableCacheStatsHolder> cacheStatsMap = new TreeMap<>();
                    roundtripped.getTotalEstimatedNativeBytes()
        levelParams.add(NodeIndicesStats.StatsLevel.NODE);  
                    assertEquals(mem.getNonHeapCommitted(), deserializedMem.getNonHeapCommitted());
            nodeStats.writeTo(out);  
                    case SHARDS:  
                        assertEquals(entry.getValue().getPeakUsed(), deserializedPools.get(entry.getKey()).getPeakUsed());
                    new JvmStats.BufferPool(
        Map<String, Object> pools = (Map<String, Object>) nativeMemory.get("memory_pools");  
                builder = XContentFactory.jsonBuilder();
        }  
        ClusterManagerThrottlingStats clusterManagerThrottlingStats = null;  
                    assertNull(deserializedDiscoveryStats);  
                        deserializedNodeStats.getOs().getCgroup().getCpuCfsPeriodMicros()
            for (int i = 0; i < numPipelines; i++) {
        for (int i = 0; i < 2; i++) {
                    }  
                    randomAlphaOfLengthBetween(3, 10),
    /**  
        }
            } catch (IOException e) {
                    switch (level) {  
            VersionUtils.randomVersion(random())
                    );
import org.opensearch.action.search.SearchRequestStats;
            null,
                    MockNodeIndicesStats newNodeIndicesStats = new MockNodeIndicesStats(in);
                            assertEquals(bufferPool.getTotalCapacity(), deserializedBufferPool.getTotalCapacity());
                    );  
     */
            jvmStats,  
            .periodic(randomLongBetween(0, 100))  
                .txSize(randomNonNegativeLong())
            original.writeTo(out);
                    randomAlphaOfLengthBetween(3, 10),
                        deserializedNodeStats.getProcess().getOpenFileDescriptors()
            List<AdmissionControllerStats> statsList = new ArrayList();  
                );  
        NodeStats nodeStats = newNodeStatsWithNativeAllocator(node, stats);
                    Map<String, ScriptStats> deserialized = deserializedScriptCacheStats.getContextStats();
        Index newIndex = new Index("index", "_na_");
            int numDeviceStats = randomIntBetween(0, 10);
                        segmentReplicationRejectionStats.getTotalRejectionCount(),
     * Constructs a NodeStats with a specific (non-realistic) value, serializes / deserializes,  
                    assertEquals(nodeStats.getHttp().getServerOpen(), deserializedNodeStats.getHttp().getServerOpen());  
                    for (String tierName : new String[] { "dummy_tier_1", "dummy_tier_2" }) {
        );
                    );  
                NodeStats deserialized = new NodeStats(in);  
        commonStatsFlags.setIncludeIndicesStatsByLevel(true);  
import org.opensearch.index.SegmentReplicationRejectionStats;
                        ThreadPoolStats.Stats deserializedStats = deserializedThreadPoolIterator.next();
        commonStatsFlags.set(CommonStatsFlags.Flag.Docs, true);  
            null,  
            .build();
            RemoteSegmentStats remoteSegmentStats = indicesStats.getSegments().getRemoteSegmentStats();
        commonStatsFlags.set(CommonStatsFlags.Flag.Store, true);
            for (CacheType cacheType : CacheType.values()) {
                        break;
                        deserializedClusterManagerThrottlingStats.getThrottlingCount("test-task")  
    }  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                AdmissionControlStats admissionControlStats = nodeStats.getAdmissionControlStats();
                statsByShard,
                        .currentIOTime(randomNonNegativeLong())
        commonStatsFlags.set(CommonStatsFlags.Flag.Indexing, true);
                MockNodeIndicesStats newNodeIndicesStats = new MockNodeIndicesStats(in);
            Map<String, Object> root = xContentBuilderToMap(builder);  
                );
        // To test out scenario when the incoming node stats response is from a node with an older ES Version.
 * You may obtain a copy of the License at  
     * Older nodes (pre-V_3_7_0) don't write the native-allocator stats payload. The version  
            AdmissionController admissionController = new AdmissionController(
                    assertEquals(mem.getHeapUsedPercent(), deserializedMem.getHeapUsedPercent());
                    .currentReadsCompleted(randomNonNegativeLong())
                    randomIntBetween(1, 200),
                    randomNonNegativeLong(),
                        assertEquals(circuitBreakerStats.getLimit(), deserializedCircuitBreakerStats.getLimit());
                NodeCacheStats deserializedNodeCacheStats = deserializedNodeStats.getNodeCacheStats();
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
                .totalOutboundConnections(randomNonNegativeLong())
                        assertEquals(orig.getActionName(), deser.getActionName());
                localNode.getId(),  
                        deserializedClusterManagerThrottlingStats.getTotalThrottledTaskCount()
                    ShardStats shardStats = Arrays.stream(indexShardStats.getShards()).findFirst().get();  
            snapshots.add(
                    AdmissionControllerStats admissionControllerStats = admissionControlStats.getAdmissionControllerStatsList().get(0);
                    );  
            }
            .downloadBytesSucceeded(0L)
            SearchRequestStats searchRequestStats,
    public static NodeStats createNodeStats(boolean remoteStoreStats) throws IOException {
            new CommonStats(commonStatsFlags),  
                mockNodeIndicesStats.writeTo(out);  
                    DocsStats incomingDocStats = shardStats.getStats().docs;
        Index index,
                    case NODE:
    }
    }
                statsByShard,
        AdaptiveSelectionStats adaptiveSelectionStats = null;
            null,  
                    long evictions = 0;
        levelParams.forEach(level -> {
            double loadAverages[] = new double[3];
            .uploadBytesMovingAverage(0D)
            .lastSuccessfulUploadTimestamp(0L)  
                        ScriptStats deserStats = deserialized.get(context);
                    assertEquals(nodeStats.getBreaker().getAllStats().length, deserializedNodeStats.getBreaker().getAllStats().length);  
            cacheStatsMap.put(CacheType.INDICES_REQUEST_CACHE, cacheStats);
        );
                        .parallelism(-1) // Non-ForkJoinPool: use -1
            remoteStoreNodeStats = new RemoteStoreNodeStats() {
/*  
                if (nodeIndicesStats == null) {  
                );
 * under the License.  
        }
            }
                }  
/*  
            List<ThreadPoolStats.Stats> threadPoolStatsList = new ArrayList<>();  
     * Renders {@code NodeStats.toXContent} when {@code nativeAllocatorStats} is non-null and
                nonAggregatedBuilder.endObject();
                    assertEquals(nodeStats.getProcess().getCpu().getPercent(), deserializedNodeStats.getProcess().getCpu().getPercent());  
import org.opensearch.ingest.IngestStats;
                        nodeStats.getProcess().getMaxFileDescriptors(),  
            }
            .uploadTimeMovingAverage(0D)
                        NodeResourceUsageStats bResourceUsageStats = deserializedResourceUsageStats.getNodeIdToResourceUsageStatsMap()
                    ? new PublishClusterStateStats(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong())  
            scriptStats,  
                // add node calculations
            weightedRoutingStats,
        public CommonStats getStats() {
    }
            remoteSegmentStats.addTotalRejections(5L);
            nodesResourceUsageStats = new NodesResourceUsageStats(resourceUsageStatsMap);
 * license agreements. See the NOTICE file distributed with
                    assertEquals(remoteStoreNodeStats, deserializedRemoteStoreNodeStats);
                } else {  
                } else {
                            IngestStats.ProcessorStat deserializedProcessorStat = it.next();
        Map<String, Object> nativeMemory = (Map<String, Object>) root.get("native_memory");  
                        assertEquals(  
                FsInfo.DeviceStats previousDeviceStats = randomBoolean()
                        randomNonNegativeLong(),
                    assertEquals(fs.getTotal().getPath(), deserializedFs.getTotal().getPath());  
import java.util.stream.Collectors;  
            }
                    assertEquals(nodeStats.getTransport().getServerOpen(), deserializedNodeStats.getTransport().getServerOpen());
            );  
        NodesResourceUsageStats nodesResourceUsageStats = null;
        return pipelineStats.stream().filter(p1 -> p1.getPipelineId().equals(id)).findFirst().map(p2 -> p2.getStats()).orElse(null);
            null,
                    localNode.getId(),
                    assertEquals(fs.getTotal().getFree(), deserializedFs.getTotal().getFree());
                    if (jvm.getBufferPools() == null) {
                        );
                    return;  
                AdaptiveSelectionStats deserializedAdaptiveStats = deserializedNodeStats.getAdaptiveSelectionStats();  
            }
                );  
import org.opensearch.index.flush.FlushStats;
        if (frequently()) {
                            bResourceUsageStats.getMemoryUtilizationPercent(),
                    assertEquals(remoteSegmentStats.getMaxRefreshTimeLag(), deserializedRemoteSegmentStats.getMaxRefreshTimeLag());
                    new ThreadPoolStats.Stats.Builder().name(randomAlphaOfLengthBetween(3, 10))  
 * Unless required by applicable law or agreed to in writing,
                public void apply(String action, AdmissionControlActionType admissionControlActionType) {
                    .resolve(String.valueOf(shardRouting.shardId().id()));
                        assertEquals(orig.getMode(), deser.getMode());
                assertEquals(200L, decoded.getPools().get(0).getPeakBytes());
                NodeStats roundtripped = new NodeStats(in);
                        .get(0);
            // To test out scenario when the incoming node stats response is from a node with an older ES Version.
            out.setVersion(Version.CURRENT);
    private CommonStats createRandomCommonStats() {  
                        assertEquals(remoteStateStats.getTotalTimeInMillis(), deserializedRemoteStateStats.getTotalTimeInMillis());
        original.writeTo(out);  
        if (frequently()) {  
    }
                        nodeId,
                );
            null,  
                    assertNull(deserializedLimiterStats);
            transportStats,  
import org.opensearch.common.settings.Settings;
                            assertEquals(processorStat.getStats().getTotalTime(), deserializedProcessorStat.getStats().getTotalTime());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            .uploadBytesPerSecMovingAverage(0D)  
            JvmStats.Threads threads = new JvmStats.Threads(randomIntBetween(1, 1000), randomIntBetween(1, 1000));
import org.opensearch.action.admin.indices.stats.IndexShardStats;
                String indexName = "index" + indexNum;
                    Map<String, ScriptStats> stats = scriptCacheStats.getContextStats();
        HashMap<Index, List<IndexShardStats>> statsByShards = new HashMap<>();
import java.util.Arrays;  
        if (frequently()) {
            .totalDownloadTimeInMillis(0L)
            }  
                } else {
import org.opensearch.index.translog.RemoteTranslogStats;  
        }  
 *  
                        case NODE:
        long numDeletedDocs = randomLongBetween(0, 100);
                            Map.of(dimensionValues, toIncrement)
        commonStatsFlags.set(CommonStatsFlags.Flag.Docs, true);  
    /**
                    }  
                    .currentIOTime(randomNonNegativeLong())
            int numThreadPoolStats = randomIntBetween(0, 10);
            clusterManagerThrottlingStats.onThrottle("test-task", randomInt());  
                );
                            assertEquals(bufferPool.getCount(), deserializedBufferPool.getCount());  
        }
            2048L,
                randomNonNegativeLong(),
                    assertEquals(classes.getUnloadedClassCount(), deserializedJvm.getClasses().getUnloadedClassCount());
            int numNodes = randomIntBetween(0, 10);
        RemotePersistenceStats remoteStateStats = new RemotePersistenceStats();  
                            entry.getValue().getLastGcStats().getMax(),
                    assertNull(deserialized.getConcurrencyLimiterStats());  
                    randomBoolean() ? randomNonNegativeLong() : -1L,
                ShardRouting shardRouting = TestShardRouting.newShardRouting(
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(new ShardId("test-idx", "test-idx", randomIntBetween(1, 10)))
                        assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.INDICES.getRestName()));
                LinkedHashMap indicesStatsMap = (LinkedHashMap) xContentMap.get(NodeIndicesStats.StatsLevel.INDICES.getRestName());
                    assertEquals(
                throw new RuntimeException(e);
                public long getLastSuccessfulFetchOfPinnedTimestamps() {
                if (nodeStats.getConcurrencyLimiterStats() == null) {
            .build();
        final MockNodeIndicesStats nonAggregatedNodeIndicesStats = new MockNodeIndicesStats(
                    RemoteTranslogStats deserializedRemoteTranslogStats = deserializedNodeIndicesStats.getTranslog()  
            List.of(  
                sentinel,  
                    randomAlphaOfLengthBetween(3, 10),  
        if (frequently()) {
                            break;
                String nodeId = randomAlphaOfLengthBetween(3, 10);
        assertEquals(1024L, ((Number) runtime.get("allocated_bytes")).longValue());
                            assertEquals(processorStat.getStats().getCurrent(), deserializedProcessorStat.getStats().getCurrent());
            new SearchRequestStats(clusterSettings),
import org.opensearch.script.ScriptCacheStats;
                    assertEquals(nodeStats.getOs().getMem().getUsedPercent(), deserializedNodeStats.getOs().getMem().getUsedPercent());
                    assertArrayEquals(
            2048L,  
        Arrays.stream(NodeIndicesStats.StatsLevel.values()).forEach(level -> {
                        assertEquals(aStats.nodeId, bStats.nodeId);  
                    randomNonNegativeLong(),  
            httpStats,
                    } else {  
        }
                        .largest(randomIntBetween(1, 1000))
                        break;  
                        nodeStats.getOs().getCgroup().getCpuControlGroup(),  
            nodeStats.writeTo(out);
                        new IoUsageStats(100.0),
                        assertEquals(remoteStateStats.getSuccessCount(), deserializedRemoteStateStats.getSuccessCount());  
                .cpu(new OsStats.Cpu(randomShort(), loadAverages))  
                if (remoteStoreNodeStats == null) {
                } else {  
    public void testSerialization() throws IOException {  
                        randomNonNegativeLong(),  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                        pipelineId,  
                    index.getName(),
            indexShardStatsList.add(indexShardStats);
        // TODO: Only remote_store based aspects of NodeIndicesStats are being tested here.
        builder.endObject();
                        assertEquals(deviceStats.writeKilobytes(), deserializedDeviceStats.writeKilobytes());
            nodeCacheStats,
import org.opensearch.common.metrics.OperationStats;
import org.opensearch.indices.NodeIndicesStats;
                    .minorDeviceNumber(randomInt())
                ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
            .downloadTimeMovingAverage(0D)
                        assertEquals(stats.getRejected(), deserializedStats.getRejected());
                    randomNonNegativeLong(),
        long numDeletedDocs = randomLongBetween(0, 100);
        commonStats.docs = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();
                    assertEquals(nodeStats.getOs().getMem().getUsed(), deserializedNodeStats.getOs().getMem().getUsed());
                    )
            indicesStats = new NodeIndicesStats(
                builder.startObject();
    }
                        case INDICES:
        for (int i = 0; i < numberOfIndexes; i++) {  
            Map<String, NodeResourceUsageStats> resourceUsageStatsMap = new HashMap<>();  
            original.writeTo(out);
        commonStatsFlags.setIncludeIndicesStatsByLevel(true);  
        }
            );  
                    assertEquals(limited, sum.getCompilationLimitTriggered());  
                        .deviceName(randomAlphaOfLengthBetween(3, 10))
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;  
                randomNonNegativeLong(),  
                        Long.toString(randomNonNegativeLong()),  
            )
            }
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;  
        // Pre-V_3_7_0: fields are not written; deserialization must not throw and fields must be null  
                .commonStats(commonStats)  
            for (int i = 0; i < numMemoryPools; i++) {
        Map<String, Object> flight = (Map<String, Object>) pools.get("flight");  
                });
                    shardRoutingState  
                        assertEquals(stateStats.getUpdateFailed(), deserializedDiscoveryStats.getClusterStateStats().getUpdateFailed());
                incomingIndexStats.forEach(indexShardStats -> {
            clusterManagerThrottlingStats,  
                    assertNull(deserializedSegmentReplicationRejectionStats);
                    case INDICES:
     * {@code runtime.allocated_bytes}/{@code runtime.resident_bytes} and grouped {@code memory_pools}.
                } else {
        return XContentHelper.convertToMap(BytesReference.bytes(xContentBuilder), true, xContentBuilder.contentType()).v2();  
                List<IngestStats.ProcessorStat> processorPerPipeline = new ArrayList<>(numProcessors);
    }
                switch (level) {  
        commonStatsFlags.set(CommonStatsFlags.Flag.Store, true);
public class NodeStatsTests extends OpenSearchTestCase {
                if (nodeStats.getProcess() == null) {
                        randomNonNegativeLong(),  
                        assertEquals(remoteStateStats.getStatsName(), deserializedRemoteStateStats.getStatsName());
                    RemoteSegmentStats deserializedRemoteSegmentStats = deserializedNodeIndicesStats.getSegments().getRemoteSegmentStats();
                }  
                    assertNull(deserializedNodeStats.getOs());  
            ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
                ScriptCacheStats deserializedScriptCacheStats = deserializedNodeStats.getScriptCacheStats();  
        commonStats.store = new StoreStats.Builder().sizeInBytes(100).reservedSize(0L).build();  
        public Map<Index, List<IndexShardStats>> getStatsByShard() {
                    JvmStats.Classes classes = jvm.getClasses();
            remoteSegmentStats.addTotalRefreshBytesLag(5L);
        List<ActionConcurrencyLimiterStats.ActionLimiterSnapshot> snapshots = new ArrayList<>(count);
            : null;
                );
                        .rejected(randomNonNegativeLong())
            CommonStatsFlags.Flag.Indexing,
            assertNotNull("native_memory must always be emitted", nativeMemory);  
        NodeStats original = newNodeStatsWithNativeAllocator(node, stats);
        }
                assertNull(deserialized.getBlockCacheOnlyStats());
        NodeIndicesStats indicesStats = getNodeIndicesStats(remoteStoreStats);
import java.util.function.Function;
                }
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            jvmStats = new JvmStats(
        }  
                            assertEquals(bufferPool.getUsed(), deserializedBufferPool.getUsed());
            CommonStatsFlags.Flag.Flush,
                String pipelineId = randomAlphaOfLengthBetween(3, 10);  
                randomBoolean() ? Collections.emptyList() : bufferPoolList,
            for (int indexNum = 0; indexNum < numIndices; indexNum++) {
            for (int i = 0; i < numBufferPools; i++) {
                        new OperationStats(
                ),
        commonStats.indexing = new IndexingStats();
                    .getSegmentReplicationRejectionStats();
            }
            int numPipelines = randomIntBetween(0, 10);
            int numberOfShards = randomIntBetween(1, 4);  
                        assertNull(deserializedDiscoveryStats.getQueueStats());
                    RemoteTranslogStats remoteTranslogStats = nodeIndicesStats.getTranslog().getRemoteTranslogStats();
     * and skipped (null) when deserializing from an older-version stream.
                    assertEquals(  
                }
            MockNodeIndicesStats mockNodeIndicesStats = generateMockNodeIndicesStats(commonStats, newIndex, commonStatsFlags, level);
            remoteSegmentStats.addUploadBytesFailed(1L);
            }
                        );
                    Iterator<ThreadPoolStats.Stats> threadPoolIterator = nodeStats.getThreadPool().iterator();  
        }
                List<IndexShardStats> incomingIndexStats = newNodeIndicesStats.getStatsByShard().get(newIndex);
 * GitHub history for details.
                    );
                    NodeResourceUsageStats stats = new NodeResourceUsageStats(  
            return this.statsByIndex;
                    final Map<String, JvmStats.MemoryPool> deserializedPools = StreamSupport.stream(deserializedMem.spliterator(), false)
import org.opensearch.test.OpenSearchTestCase;
                if (ingestStats == null) {  
                            statsHolder,  
                NodesResourceUsageStats deserializedResourceUsageStats = deserializedNodeStats.getResourceUsageStats();
package org.opensearch.action.admin.cluster.node.stats;
                        .previousDeviceStats(null)
                        ResponseCollectorService.ComputedNodeStats aStats = adaptiveStats.getComputedStats().get(k);
                statsByShards,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                    assertEquals(remoteSegmentStats.getTotalRefreshBytesLag(), deserializedRemoteSegmentStats.getTotalRefreshBytesLag());
        commonStatsFlags.clear();
                    assertEquals(nodeStats.getOs().getMem().getTotal(), deserializedNodeStats.getOs().getMem().getTotal());
            nodeStats.writeTo(out);
        return createNodeStats(false);
import java.util.stream.StreamSupport;
                try (StreamInput in = out.bytes().streamInput()) {
                    assertEquals(  
            ImmutableCacheStatsHolder cacheStats = statsHolder.getImmutableCacheStatsHolder(dimensionNames.toArray(new String[0]));  
                ScriptStats scriptStats = nodeStats.getScriptStats();
                        randomNonNegativeLong(),
                    );
                    assertEquals(remoteTranslogStats, deserializedRemoteTranslogStats);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                        assertFalse(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));  
        long numDeletedDocs = randomLongBetween(0, 100);
                        randomAlphaOfLength(8),
                        assertEquals(stats.getName(), deserializedStats.getName());
                SegmentReplicationRejectionStats segmentReplicationRejectionStats = nodeStats.getSegmentReplicationRejectionStats();  
                        .active(randomIntBetween(1, 1000))  
                    randomNonNegativeLong(),
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
                    assertNull(deserializedClusterManagerThrottlingStats);
                        randomAlphaOfLengthBetween(3, 10),
                Map<String, Object> nonAggregatedContentMap = xContentBuilderToMap(nonAggregatedBuilder);  
                        .build();  
        }
                    assertEquals(totalStats.getFailedCount(), deserializedIngestStats.getTotalStats().getFailedCount());  
                        .currentQueueSize(randomNonNegativeLong())  
                NodeStats deserialized = new NodeStats(in);
 *
            }  
            StatusCounterStats statusCounterStats
        AdmissionControlStats admissionControlStats = null;  
                new CommonStats(commonStatsFlags),
                    assertEquals(fs.getTotal().getType(), deserializedFs.getTotal().getType());
                            JvmStats.BufferPool deserializedBufferPool = deserializedJvm.getBufferPools().get(i);
            .totalUploadsSucceeded(randomLongBetween(50, 100))
                new SearchRequestStats(clusterSettings),
                } else {  
            CommonStatsFlags.Flag.QueryCache,  
                    resourceUsageStats.getNodeIdToResourceUsageStatsMap().forEach((k, v) -> {
                        nodeStats.getOs().getCgroup().getCpuStat().getNumberOfElapsedPeriods(),  
                .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))
                }
                new ProcessStats.Mem(randomNonNegativeLong())  
            int numShardsPerIndex = randomIntBetween(1, 50);  
                } else {
                in.setVersion(Version.V_3_7_0);  
import org.opensearch.index.ReplicationStats;  
    public void testNativeAllocatorStatsBwcEmptyOnOldVersion() throws IOException {  
                    .currentQueueSize(randomNonNegativeLong())
                    OperationStats processorStats = new OperationStats(  
                if (frequently()) {
                throw new RuntimeException(e);  
                builder.endObject();
    /**
                    assertNull(deserializedIngestStats);
                CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER,  
                );
            .build();  
        );  
                        List<String> dimensionValues = List.of(indexName, shardName, tierName);  
                    randomFrom("vegas", "gradient2", "aimd"),  
            null,  
import org.opensearch.http.HttpStats;
            .deleted(randomLongBetween(0, 100))  
        commonStats.store = new StoreStats.Builder().sizeInBytes(100).reservedSize(0L).build();
                    );  
import org.opensearch.core.xcontent.XContentBuilder;
    public void testTotalEstimatedNativeBytesPreservedAcrossWireAndRender() throws IOException {  
                    assertEquals(fs.getTotal().getAvailable(), deserializedFs.getTotal().getAvailable());
            null,  
                        JvmStats.GarbageCollector deserializedGarbageCollector = deserializedJvm.getGc().getCollectors()[i];
                }
                .nodeComputedStats(nodeStats)
     */
                    "totalEstimatedNativeBytes must default to -1 when written by a pre-V_3_7_0 node",
        SegmentReplicationRejectionStats segmentReplicationRejectionStats = null;
                    for (String context : stats.keySet()) {  
                    PendingClusterStateStats queueStats = discoveryStats.getQueueStats();
                    new JvmStats.MemoryPool(  
        ScriptCacheStats scriptCacheStats = scriptStats != null ? scriptStats.toScriptCacheStats() : null;
                    for (final Map.Entry<String, JvmStats.MemoryPool> entry : pools.entrySet()) {  
                AdaptiveSelectionStats adaptiveStats = nodeStats.getAdaptiveSelectionStats();
                    assertEquals(mem.getHeapCommitted(), deserializedMem.getHeapCommitted());  
                    for (IngestStats.PipelineStat pipelineStat : ingestStats.getPipelineStats()) {  
        stateStats.setPersistenceStats(Arrays.asList(remoteStateStats.getUploadStats()));
            admissionControlStats,  
            MockNodeIndicesStats aggregatedNodeIndicesStats = new MockNodeIndicesStats(  
    }
                    .currentReadTime(randomNonNegativeLong())
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
                    while (threadPoolIterator.hasNext()) {
            )
                    assertEquals(totalStats.getTotalTime(), deserializedIngestStats.getTotalStats().getTotalTime());
import org.opensearch.cluster.coordination.PersistedStateStats;
                ScriptCacheStats scriptCacheStats = nodeStats.getScriptCacheStats();
                    });
                        String pipelineId = pipelineStat.getPipelineId();
                if (nodeStats.getTransport() == null) {  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                .resolve(shardRouting.shardId().getIndex().getUUID())
                            assertNull(newNodeIndicesStats.getStatsByShard());  
    private static RemoteTranslogTransferTracker.Stats getRandomRemoteTranslogTransferTrackerStats() {
                            assertNotNull(newNodeIndicesStats.getStatsByShard());
                randomNonNegativeLong(),
                }  
            List<String> dimensionNames = List.of("index", "shard", "tier");
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags();
                // add node calculations
            IndexShardStats indexShardStats = new IndexShardStats(shardRouting.shardId(), new ShardStats[] { shardStats });  
                    assertEquals(1, (long) admissionControllerStats.getRejectionCount().get(AdmissionControlActionType.SEARCH.getType()));
            JvmStats.GarbageCollector[] garbageCollectorsArray = new JvmStats.GarbageCollector[numGarbageCollectors];  
                in.setVersion(Version.V_3_7_0);
import org.opensearch.cluster.coordination.PublishClusterStateStats;
                        }
            );  
            JvmStats.Classes classes = new JvmStats.Classes(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong());  
                    assertEquals(remoteSegmentStats.getUploadBytesStarted(), deserializedRemoteSegmentStats.getUploadBytesStarted());
                        deserializedAdmissionControlStats.getAdmissionControllerStatsList().size()  
                if (nodeStats.getHttp() == null) {  
        assertNotNull("runtime block must be present", runtime);  
                    assertEquals(ioStats.getTotalWriteOperations(), deserializedIoStats.getTotalWriteOperations());
            try (StreamInput in = out.bytes().streamInput()) {  
                }
        levelParams.add(NodeIndicesStats.StatsLevel.NODE);  
        });  
                .txCount(randomNonNegativeLong())
            XContentBuilder aggregatedBuilder = null;  
                    assertEquals(remoteSegmentStats.getDownloadBytesStarted(), deserializedRemoteSegmentStats.getDownloadBytesStarted());
                        .currentSectorsWritten(randomNonNegativeLong())  
import org.opensearch.core.index.Index;  
                if (discoveryStats == null) {
                if (frequently()) {
                assertEquals(
                    long limited = 0;  
                randomBoolean(),
                }
                        );  
            null,
                    );  
            };
                if (segmentReplicationRejectionStats == null) {  
 * compatible open source license.
            ingestStats,
            JvmStats.GarbageCollectors garbageCollectors = new JvmStats.GarbageCollectors(garbageCollectorsArray);
            scriptCacheStats,
                        assertTrue(indicesStatsMap.containsKey(NodeIndicesStats.StatsLevel.SHARDS.getRestName()));
            roundtripped.toXContent(builder, ToXContent.EMPTY_PARAMS);
            1024L,
            threadPoolStats = new ThreadPoolStats(threadPoolStatsList);  
        public MockNodeIndicesStats(StreamInput in) throws IOException {  
                if (fs == null) {
                assertEquals(aggregatedContentMap, nonAggregatedContentMap);
        }  
        if (frequently()) {
                        assertEquals(pipelineStat.getStats().getCurrent(), deserializedPipelineStats.getCurrent());
                if (resourceUsageStats == null) {
        // V_3_7_0: fields are written and read back (null or non-null, just no deserialization error)
            int numNodes = randomIntBetween(0, 10);
        }
            Map<String, List<IngestStats.ProcessorStat>> ingestProcessorStats = new HashMap<>(numPipelines);
                memoryPools.add(
        if (frequently()) {
        if (frequently()) {
                        admissionControllerStats.getRejectionCount().get(AdmissionControlActionType.SEARCH.getType()),  
            for (int i = 0; i < numThreadPoolStats; i++) {
                }
                        deserializedNodeStats.getProcess().getMaxFileDescriptors()
                } else {
                .build();
                    assertNull(deserializedNodeIndicesStats);
            .downloadBytesMovingAverage(0D)  
import org.opensearch.ratelimitting.admissioncontrol.controllers.AdmissionController;
                        assertEquals(entry.getValue().getPeakMax(), deserializedPools.get(entry.getKey()).getPeakMax());
    /**
                    assertEquals(replicationStats.getMaxReplicationLag(), deserializedReplicationStats.getMaxReplicationLag());  
                            deserializedPools.get(entry.getKey()).getLastGcStats().getUsed()
                    assertThat(deserializedPools.keySet(), hasSize(poolsCount));
            processStats,
        }  
                    assertEquals(ioStats.getTotalIOTimeMillis(), deserializedIoStats.getTotalIOTimeMillis());  
                );
                        assertEquals(orig.getLastRttMillis(), deser.getLastRttMillis());
                    ReplicationStats deserializedReplicationStats = deserializedNodeIndicesStats.getSegments().getReplicationStats();  
            null,
                        assertEquals(aResourceUsageStats.getTimestamp(), bResourceUsageStats.getTimestamp());  
                ingestProcessorStats.put(pipelineId, processorPerPipeline);
                );
                RemoteStoreNodeStats deserializedRemoteStoreNodeStats = deserializedNodeStats.getRemoteStoreNodeStats();
                randomNonNegativeLong(),
            CommonStats oldStats,
                    randomNonNegativeLong(),
        commonStats.docs = new DocsStats.Builder().count(randomLongBetween(0, 10000))
import org.opensearch.index.remote.RemoteSegmentStats;  
            int numBufferPools = randomIntBetween(0, 10);  
    }  
                        deserializedNodeStats.getOs().getCgroup().getMemoryUsageInBytes()
                    assertNull(deserializedRemoteStoreNodeStats);  
                    )
                in.setVersion(Version.V_3_6_0);
            }
        CommonStatsFlags commonStatsFlags = new CommonStatsFlags(
                        assertFalse(it.hasNext());
    private static NodeIndicesStats getNodeIndicesStats(boolean remoteStoreStats) {  
            null,
            remoteSegmentStats.setMaxRefreshTimeLag(2L);
                new SearchRequestStats(clusterSettings),
                    }
                        Long.toString(randomNonNegativeLong())
                    assertEquals(nodeStats.getOs().getSwap().getTotal(), deserializedNodeStats.getOs().getSwap().getTotal());
            try (StreamInput in = out.bytes().streamInput()) {  
            CommonStatsFlags.Flag.Segments
        commonStats.docs = new DocsStats.Builder().count(numDocs).deleted(numDeletedDocs).totalSizeInBytes(0).build();  
            ingestStats = new IngestStats(totalStats, ingestPipelineStats, ingestProcessorStats);  
                            entry.getValue().getLastGcStats().getUsagePercent(),
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            null,
                        admissionControlStats.getAdmissionControllerStatsList().size(),
            List<IndexShardStats> indexShardStatsList = new ArrayList<>();
                        assertEquals(stats.getCompleted(), deserializedStats.getCompleted());  
                    assertEquals(  
                    assertEquals(jvm.getUptime(), deserializedJvm.getUptime());  
        }
            out.setVersion(Version.V_2_18_0);
        commonStatsFlags.setIncludeIndicesStatsByLevel(true);  
                nonAggregatedBuilder.startObject();  
                    assertEquals(nodeCacheStats, deserializedNodeCacheStats);  
                    memoryPools
                    assertEquals(nodeStats.getProcess().getCpu().getTotal(), deserializedNodeStats.getProcess().getCpu().getTotal());
import org.opensearch.cluster.routing.TestShardRouting;  
            ? new DiscoveryStats(  
                new StatusCounterStats()  
                    );
            try (StreamInput in = out.bytes().streamInput()) {
                    for (int i = 0; i < jvm.getGc().getCollectors().length; i++) {  
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                        assertEquals(orig.getAlgorithm(), deser.getAlgorithm());  
                    assertEquals(  
        ) {  
        RemoteStoreNodeStats remoteStoreNodeStats = null;  
            .totalTimeInMillis(randomLongBetween(0, 100))
                RemoteStoreNodeStats remoteStoreNodeStats = nodeStats.getRemoteStoreNodeStats();  
                NodesResourceUsageStats resourceUsageStats = nodeStats.getResourceUsageStats();  
        }
        NodeIndicesStats indicesStats = null;
        });  
import org.opensearch.common.settings.ClusterSettings;  
 * specific language governing permissions and limitations
                    .seqNoStats(null)
            for (int i = 0; i < numberOfShards; i++) {
import org.opensearch.common.cache.stats.CacheStats;  
            null,
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                        nodeStats.getOs().getCgroup().getCpuAcctControlGroup(),
                if (scriptStats == null) {  
                            assertNull(newNodeIndicesStats.getStatsByIndex());
                    assertEquals(ioStats.getTotalWriteTime(), deserializedIoStats.getTotalWriteTime());
        DiscoveryNode node = new DiscoveryNode(
import java.util.Map;  
                    .commonStats(createRandomCommonStats())  
        HttpStats httpStats = frequently()
 * Licensed to Elasticsearch under one or more contributor  
            RemoteTranslogStats otherRemoteTranslogStats = new RemoteTranslogStats(getRandomRemoteTranslogTransferTrackerStats());
                if (weightedRoutingStats == null) {  
import org.opensearch.Version;
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
                aggregatedBuilder = aggregatedNodeIndicesStats.toXContent(
            OperationStats totalStats = new OperationStats(
                        CircuitBreakerStats deserializedCircuitBreakerStats = deserializedNodeStats.getBreaker().getAllStats()[i];  
                    }  
                if (adaptiveStats == null) {
            null, // concurrencyLimiterStats
                    long compilations = 0;
                    assertNull(deserializedNodeStats.getHttp());
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
                } else {
        }  
        HashMap<Index, List<IndexShardStats>> statsByShards = createRandomShardByStats(indexList);  
                    AdmissionControllerStats deserializedAdmissionControllerStats = deserializedAdmissionControlStats  
import org.opensearch.threadpool.ThreadPoolStats;  
                        assertEquals(
                    )
        NativeAllocatorPoolStats stats = new NativeAllocatorPoolStats(  
                    assertNotNull(deserializedLimiterStats);
        @SuppressWarnings("unchecked")
import org.opensearch.common.cache.stats.DefaultCacheStatsHolder;
                    .deviceName(randomAlphaOfLengthBetween(3, 10))  
        commonStats.completion = new CompletionStats();
            Map<String, Object> nativeMemory = (Map<String, Object>) root.get("native_memory");
    /**  
            .build();  
                        OperationStats deserializedPipelineStats = getPipelineStats(deserializedIngestStats.getPipelineStats(), pipelineId);
            XContentBuilder nonAggregatedBuilder = null;
    private static NodeStats newNodeStatsWithNativeAllocator(DiscoveryNode node, NativeAllocatorPoolStats nativeAllocatorStats) {  
    private Map<String, Object> xContentBuilderToMap(XContentBuilder xContentBuilder) {
                in.setVersion(Version.V_2_13_0);
                    );  
                    assertEquals(nodeStats.getOs().getCpu().getPercent(), deserializedNodeStats.getOs().getCpu().getPercent());
        return new NodeStats(  
            return new MockNodeIndicesStats(  
                @Override
                        limited += generatedStats.getCompilationLimitTriggered();
            null,
                            randomNonNegativeLong(),
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
import org.opensearch.index.fielddata.FieldDataStats;
                        deserializedNodeStats.getOs().getCgroup().getMemoryLimitInBytes()
