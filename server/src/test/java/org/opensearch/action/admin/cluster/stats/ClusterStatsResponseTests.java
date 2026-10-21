import org.opensearch.action.admin.indices.stats.ShardStats;
        NodeInfo nodeInfo = new NodeInfo(
        commonStats.queryCache = new QueryCacheStats.Builder().ramBytesUsed(randomLongBetween(0, 100))
        assertNotNull(deserializedClusterStatsResponse.nodesStats);
    }
            .build();
            )
        JvmStats.GarbageCollector[] garbageCollectorsArray = new JvmStats.GarbageCollector[1];
            null,
                .build();
        commonStats.segments = new SegmentsStats();
            JvmInfo.jvmInfo(),
        assertEquals(clusterStatsResponse.timestamp, deserializedClusterStatsResponse.timestamp);
                shardRoutingState
                randomBoolean(),
            new JvmStats(
                .pollingIngestStats(null)
            defaultClusterStatsNodeResponses,
            .build();
import org.opensearch.action.admin.indices.stats.CommonStats;
                    randomNonNegativeLong(),
            null,
            CommonStats commonStats = createRandomCommonStats();
            new PluginsAndModules(Collections.emptyList(), Collections.emptyList()),
 * The OpenSearch Contributors require contributions made to
}
                IndexMetric.STORE,
import org.opensearch.index.flush.FlushStats;
import org.opensearch.core.index.Index;
                localNode.getId(),
            null,
        commonStats.completion = new CompletionStats();
import org.opensearch.monitor.jvm.JvmStats;
                new BoundTransportAddress(new TransportAddress[] { buildNewFakeTransportAddress() }, buildNewFakeTransportAddress()),
        ClusterStatsResponse clusterStatsResponse = new ClusterStatsResponse(
            "UUID",
                new JvmStats.Classes(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong())
            .build();
            Settings.EMPTY,
        ClusterStatsResponse deserializedClusterStatsResponse = new ClusterStatsResponse(streamInput);
                ),
            ),
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getQueryCache());
            null,
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
            null,
                IndexMetric.COMPLETION
import java.nio.file.Path;
            ClusterState.EMPTY_STATE,
                IndexMetric.DOCS,
        ClusterStatsResponse deserializedClusterStatsResponse = new ClusterStatsResponse(streamInput);
import org.opensearch.cluster.node.DiscoveryNode;
            null,
        clusterStatsResponse.writeTo(output);
import org.opensearch.cluster.ClusterState;
            1l,
                    randomNonNegativeLong(),
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
            .fieldMemoryStats(null)
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
                .retentionLeaseStats(null)
            .build();
            randomNonNegativeLong(),
        List<ClusterStatsNodeResponse> defaultClusterStatsNodeResponses = new ArrayList<>();
import java.util.ArrayList;
import org.opensearch.index.shard.IndexingStats;
        assertEquals(clusterStatsResponse.status, deserializedClusterStatsResponse.status);
            randomNonNegativeLong(),
import org.opensearch.cluster.routing.TestShardRouting;
        commonStats.store = new StoreStats.Builder().sizeInBytes(randomLongBetween(0, 100))
        );
import org.opensearch.index.shard.DocsStats;
            null,
import org.opensearch.search.suggest.completion.CompletionStats;
import org.opensearch.index.store.StoreStats;
                .commonStats(commonStats)
        StreamInput streamInput = output.bytes().streamInput();
            null,
                null
                IndexMetric.FIELDDATA,
import java.io.IOException;
                .resolve(String.valueOf(shardRouting.shardId().id()));
import org.opensearch.transport.TransportInfo;
            -1L  // totalEstimatedNativeBytes
            Version.CURRENT,
        commonStats.docs = new DocsStats.Builder().count(randomLongBetween(0, 10000))
            null,
import org.opensearch.monitor.os.OsInfo;
                Collections.emptyList(),
        clusterStatsResponse.writeTo(output);
            ShardStats[] shardStats = createShardStats(node, testIndex, commonStats);
            .evictions(randomLongBetween(0, 100))
            new ClusterName("cluster_name"),
        JvmStats.GarbageCollectors garbageCollectors = new JvmStats.GarbageCollectors(garbageCollectorsArray);
                i,
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getSegments());
            .cacheCount(randomLongBetween(0, 100))
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getCompletion());
            null,
            Set.of(IndexMetric.MAPPINGS, IndexMetric.ANALYSIS)
            null,
                    randomNonNegativeLong(),
            ),
            defaultClusterStatsNodeResponses.add(customClusterStatsResponse);
        for (int i = 0; i < 2; i++) {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.io.stream.BytesStreamOutput;
                .commitStats(null)
        assertNull(deserializedClusterStatsResponse.indicesStats.getMappings());
                .resolve(shardRouting.shardId().getIndex().getUUID())
        );
                    randomNonNegativeLong(),
            Set.of(
    private CommonStats createRandomCommonStats() {
            ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
            Build.CURRENT,
            new OsInfo(randomLong(), randomInt(), randomInt(), "name", "pretty_name", "arch", "version"),
        for (int i = 0; i < numberOfNodes; i++) {
            null,
import org.opensearch.core.common.transport.TransportAddress;
        commonStats.flush = new FlushStats.Builder().total(randomLongBetween(0, 100))
            shardStatsList.add(shardStats);
            Set.of(ClusterStatsRequest.Metric.INDICES, ClusterStatsRequest.Metric.PROCESS, ClusterStatsRequest.Metric.JVM),
    public void testSerializationWithoutIndicesMappingAndAnalysisStats() throws Exception {
        assertNotNull(deserializedClusterStatsResponse.nodesStats.getJvm());
    }
            null,
            .cacheSize(randomLongBetween(0, 100))
            null,
                randomNonNegativeLong(),
            null,
        return commonStats;
        assertNull(deserializedClusterStatsResponse.indicesStats.getAnalysis());
        commonStats.fieldData = new FieldDataStats.Builder().memorySize(randomLongBetween(0, 100))
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getStore());
import java.util.Set;
import java.util.Collections;
    public void testSerializationWithIndicesMappingAndAnalysisStats() throws Exception {
            null,
            ClusterState.EMPTY_STATE,
            List.of(),
import org.opensearch.index.shard.ShardPath;
        assertEquals(clusterStatsResponse.clusterUUID, deserializedClusterStatsResponse.clusterUUID);
            null, // concurrencyLimiterStats
                .seqNoStats(null)
public class ClusterStatsResponseTests extends OpenSearchTestCase {
            randomAlphaOfLengthBetween(3, 10),
                .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))
        return shardStatsList.toArray(new ShardStats[0]);
        int numberOfNodes = randomIntBetween(1, 4);
            );
            defaultClusterStatsNodeResponses.add(customClusterStatsResponse);
        }
import org.opensearch.Version;
 * SPDX-License-Identifier: Apache-2.0
            DiscoveryNode node = new DiscoveryNode("node-" + i, buildNewFakeTransportAddress(), Version.CURRENT);
            defaultClusterStatsNodeResponses,
import org.opensearch.index.engine.SegmentsStats;
import org.opensearch.index.fielddata.FieldDataStats;
            .build();
            null,
import org.opensearch.monitor.jvm.JvmInfo;
            1l,
            null,
                randomNonNegativeLong(),
        NodeStats nodeStats = new NodeStats(
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;
            DiscoveryNode node = new DiscoveryNode("node-" + i, buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.monitor.process.ProcessStats;
            .reservedSize(randomLongBetween(0, 1000))
                new JvmStats.Mem(
            .hitCount(randomLongBetween(0, 100))
import org.opensearch.Build;
        );
        assertEquals(clusterStatsResponse.status, deserializedClusterStatsResponse.status);
                    Collections.emptyList()
            CommonStats commonStats = createRandomCommonStats();
 * compatible open source license.
            null,
    }
            ShardStats[] shardStats = createShardStats(node, testIndex, commonStats);
            .deleted(randomLongBetween(0, 100))
        List<ShardStats> shardStatsList = new ArrayList<>();
        BytesStreamOutput output = new BytesStreamOutput();
            null,
import org.opensearch.cluster.ClusterName;
        assertEquals(clusterStatsResponse.indicesStats.getAnalysis(), deserializedClusterStatsResponse.indicesStats.getAnalysis());
            ClusterStatsNodeResponse customClusterStatsResponse = createClusterStatsNodeResponse(node, shardStats);
                IndexMetric.SEGMENTS,
        return new ClusterStatsNodeResponse(node, null, nodeInfo, nodeStats, shardStats);
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getDocs());
import org.opensearch.cluster.routing.ShardRoutingState;
        assertNotNull(clusterStatsResponse.indicesStats);
            null
package org.opensearch.action.admin.cluster.stats;
        }
            null,
            null,
        Index testIndex = new Index("test-index", "_na_");
        Index testIndex = new Index("test-index", "_na_");
    }
        assertEquals(clusterStatsResponse.indicesStats.getMappings(), deserializedClusterStatsResponse.indicesStats.getMappings());
import org.opensearch.common.settings.Settings;
            null,
        int numberOfNodes = randomIntBetween(1, 4);
            ),
        }
            Set.of(ClusterStatsRequest.Metric.INDICES),
        for (int i = 0; i < numberOfNodes; i++) {
        StreamInput streamInput = output.bytes().streamInput();
    private ShardStats[] createShardStats(DiscoveryNode localNode, Index index, CommonStats commonStats) {
 *
            .missCount(randomLongBetween(0, 100))
    }
        ClusterStatsResponse clusterStatsResponse = new ClusterStatsResponse(
            null,
            node,
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getFieldData());
        commonStats.indexing = new IndexingStats();
                randomNonNegativeLong(),
            Path path = createTempDir().resolve("indices")
            node,
        assertEquals(clusterStatsResponse.clusterUUID, deserializedClusterStatsResponse.clusterUUID);
            null, // nativeAllocator
                new ProcessStats.Mem(randomNonNegativeLong())
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        assertNotNull(deserializedClusterStatsResponse.indicesStats);
            null,
            null,
        );
 */
import org.opensearch.cluster.routing.ShardRouting;
                    randomNonNegativeLong(),
                index.getName(),
            ShardRouting shardRouting = TestShardRouting.newShardRouting(
        BytesStreamOutput output = new BytesStreamOutput();
                garbageCollectors,
            null,
            .totalTimeInMillis(randomLongBetween(0, 100))
        );
            new TransportInfo(
            ClusterStatsNodeResponse customClusterStatsResponse = createClusterStatsNodeResponse(node, shardStats);
            null,
                IndexMetric.QUERY_CACHE,
/*
            .totalSizeInBytes(randomLongBetween(0, 1000))
            randomNonNegativeLong()
            List.of(),
            "UUID",
            ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
                randomNonNegativeLong(),
import org.opensearch.core.common.transport.BoundTransportAddress;
import java.util.List;
import org.opensearch.index.cache.query.QueryCacheStats;
        List<ClusterStatsNodeResponse> defaultClusterStatsNodeResponses = new ArrayList<>();
        assertEquals(clusterStatsResponse.timestamp, deserializedClusterStatsResponse.timestamp);
            null,
            null,
            null,
        assertNotNull(deserializedClusterStatsResponse.nodesStats.getProcess());
            new ProcessStats(
            .periodic(randomLongBetween(0, 100))
            null,
import org.opensearch.core.common.io.stream.StreamInput;
            null,
                new JvmStats.Threads(randomIntBetween(1, 1000), randomIntBetween(1, 1000)),
        garbageCollectorsArray[0] = new JvmStats.GarbageCollector(
                new ProcessStats.Cpu(randomShort(), randomNonNegativeLong()),
            new ClusterName("cluster_name"),
            null,
                randomNonNegativeLong(),
    private ClusterStatsNodeResponse createClusterStatsNodeResponse(DiscoveryNode node, ShardStats[] shardStats) throws IOException {
