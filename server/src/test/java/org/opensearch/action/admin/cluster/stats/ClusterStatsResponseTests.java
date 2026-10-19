            ),
        int numberOfNodes = randomIntBetween(1, 4);
            "UUID",
            ShardStats[] shardStats = createShardStats(node, testIndex, commonStats);
import java.util.Set;
import org.opensearch.action.admin.indices.stats.ShardStats;  
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getSegments());
            1l,
import org.opensearch.cluster.node.DiscoveryNode;  
                index.getName(),  
        ClusterStatsResponse deserializedClusterStatsResponse = new ClusterStatsResponse(streamInput);
                IndexMetric.QUERY_CACHE,  
            null,
            null,
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getCompletion());
            null,
import org.opensearch.monitor.jvm.JvmInfo;  
                shardRoutingState
            .fieldMemoryStats(null)  
        List<ClusterStatsNodeResponse> defaultClusterStatsNodeResponses = new ArrayList<>();  
        commonStats.queryCache = new QueryCacheStats.Builder().ramBytesUsed(randomLongBetween(0, 100))
                new ProcessStats.Mem(randomNonNegativeLong())  
            .build();
        assertEquals(clusterStatsResponse.indicesStats.getMappings(), deserializedClusterStatsResponse.indicesStats.getMappings());
            randomNonNegativeLong()
        commonStats.completion = new CompletionStats();
    public void testSerializationWithIndicesMappingAndAnalysisStats() throws Exception {
            null,
            new PluginsAndModules(Collections.emptyList(), Collections.emptyList()),
        assertNotNull(deserializedClusterStatsResponse.nodesStats);
            .build();  
import org.opensearch.search.suggest.completion.CompletionStats;
                    randomNonNegativeLong(),  
        assertNotNull(clusterStatsResponse.indicesStats);  
            null,  
            new ClusterName("cluster_name"),  
            .missCount(randomLongBetween(0, 100))
            DiscoveryNode node = new DiscoveryNode("node-" + i, buildNewFakeTransportAddress(), Version.CURRENT);  
            randomAlphaOfLengthBetween(3, 10),  
import org.opensearch.index.cache.query.QueryCacheStats;
                new JvmStats.Threads(randomIntBetween(1, 1000), randomIntBetween(1, 1000)),
        assertEquals(clusterStatsResponse.timestamp, deserializedClusterStatsResponse.timestamp);  
        BytesStreamOutput output = new BytesStreamOutput();
            .cacheCount(randomLongBetween(0, 100))
        int numberOfNodes = randomIntBetween(1, 4);
            null,
import org.opensearch.core.common.transport.TransportAddress;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.monitor.jvm.JvmStats;
            Build.CURRENT,
            DiscoveryNode node = new DiscoveryNode("node-" + i, buildNewFakeTransportAddress(), Version.CURRENT);  
                i,
        for (int i = 0; i < numberOfNodes; i++) {
            node,  
        return commonStats;
        assertNull(deserializedClusterStatsResponse.indicesStats.getMappings());
        ClusterStatsResponse clusterStatsResponse = new ClusterStatsResponse(  
            "UUID",
        assertNull(deserializedClusterStatsResponse.indicesStats.getAnalysis());  
                .resolve(String.valueOf(shardRouting.shardId().id()));  
        clusterStatsResponse.writeTo(output);  
        JvmStats.GarbageCollectors garbageCollectors = new JvmStats.GarbageCollectors(garbageCollectorsArray);
            ClusterStatsNodeResponse customClusterStatsResponse = createClusterStatsNodeResponse(node, shardStats);  
import org.opensearch.index.shard.ShardPath;
        );
        assertNotNull(deserializedClusterStatsResponse.nodesStats.getProcess());
            defaultClusterStatsNodeResponses.add(customClusterStatsResponse);
                randomNonNegativeLong(),
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.IndexMetric;  
 * The OpenSearch Contributors require contributions made to  
            null,
            null,
            ClusterState.EMPTY_STATE,  
            new OsInfo(randomLong(), randomInt(), randomInt(), "name", "pretty_name", "arch", "version"),
                localNode.getId(),
    }
                new JvmStats.Classes(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong())
import org.opensearch.common.settings.Settings;
            null,
        return new ClusterStatsNodeResponse(node, null, nodeInfo, nodeStats, shardStats);  
                IndexMetric.COMPLETION
            null,  
        clusterStatsResponse.writeTo(output);
                new JvmStats.Mem(
            Settings.EMPTY,  
                randomNonNegativeLong(),  
            ),
                null
            null,  
            null,
            .build();
        commonStats.segments = new SegmentsStats();
            .cacheSize(randomLongBetween(0, 100))  
                    randomNonNegativeLong(),  
            randomNonNegativeLong(),
        ClusterStatsResponse deserializedClusterStatsResponse = new ClusterStatsResponse(streamInput);  
                .build();  
        );  
/*  
        Index testIndex = new Index("test-index", "_na_");  
        NodeInfo nodeInfo = new NodeInfo(
        assertEquals(clusterStatsResponse.status, deserializedClusterStatsResponse.status);
import org.opensearch.Build;
            .evictions(randomLongBetween(0, 100))
import org.opensearch.index.shard.IndexingStats;  
            1l,
                    randomNonNegativeLong(),
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
import org.opensearch.cluster.routing.ShardRoutingState;
            null,
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            null,
            new ProcessStats(
import java.util.List;  
import org.opensearch.test.OpenSearchTestCase;
        );  
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
                .commonStats(commonStats)
            )  
            null,
            .totalTimeInMillis(randomLongBetween(0, 100))
                .pollingIngestStats(null)
                    randomNonNegativeLong(),
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getQueryCache());
        List<ClusterStatsNodeResponse> defaultClusterStatsNodeResponses = new ArrayList<>();  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;  
            ),
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
            null,
public class ClusterStatsResponseTests extends OpenSearchTestCase {  
            CommonStats commonStats = createRandomCommonStats();
            .build();  
        assertNotNull(deserializedClusterStatsResponse.indicesStats);
                IndexMetric.DOCS,  
            .totalSizeInBytes(randomLongBetween(0, 1000))
            null,  
            defaultClusterStatsNodeResponses,
import org.opensearch.core.common.transport.BoundTransportAddress;
            null,  
        StreamInput streamInput = output.bytes().streamInput();
            null,
        commonStats.store = new StoreStats.Builder().sizeInBytes(randomLongBetween(0, 100))
                randomNonNegativeLong(),  
import org.opensearch.common.io.stream.BytesStreamOutput;
        garbageCollectorsArray[0] = new JvmStats.GarbageCollector(
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getDocs());
        ClusterStatsResponse clusterStatsResponse = new ClusterStatsResponse(  
        commonStats.indexing = new IndexingStats();
        commonStats.fieldData = new FieldDataStats.Builder().memorySize(randomLongBetween(0, 100))
import org.opensearch.cluster.ClusterName;
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
            ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
                ),  
            defaultClusterStatsNodeResponses.add(customClusterStatsResponse);
import org.opensearch.action.admin.indices.stats.CommonStats;
            ShardRouting shardRouting = TestShardRouting.newShardRouting(
import org.opensearch.Version;
        );
import org.opensearch.index.flush.FlushStats;
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getFieldData());  
            .periodic(randomLongBetween(0, 100))
        }
            new JvmStats(
        assertEquals(clusterStatsResponse.status, deserializedClusterStatsResponse.status);
    private ShardStats[] createShardStats(DiscoveryNode localNode, Index index, CommonStats commonStats) {
                    randomNonNegativeLong(),
            null,
import org.opensearch.monitor.os.OsInfo;
                randomNonNegativeLong(),
                IndexMetric.STORE,
            Set.of(IndexMetric.MAPPINGS, IndexMetric.ANALYSIS)
            null,
            Set.of(ClusterStatsRequest.Metric.INDICES, ClusterStatsRequest.Metric.PROCESS, ClusterStatsRequest.Metric.JVM),
                randomBoolean(),  
import org.opensearch.core.index.Index;  
        commonStats.docs = new DocsStats.Builder().count(randomLongBetween(0, 10000))  
        assertEquals(clusterStatsResponse.timestamp, deserializedClusterStatsResponse.timestamp);
    private CommonStats createRandomCommonStats() {
                .resolve(shardRouting.shardId().getIndex().getUUID())
            ShardStats[] shardStats = createShardStats(node, testIndex, commonStats);
import org.opensearch.cluster.routing.TestShardRouting;  
import org.opensearch.cluster.routing.ShardRouting;
        );  
            new TransportInfo(
            null,
                    Collections.emptyList()
        assertEquals(clusterStatsResponse.clusterUUID, deserializedClusterStatsResponse.clusterUUID);  
            List.of(),
            defaultClusterStatsNodeResponses,
            Set.of(
import org.opensearch.core.common.io.stream.StreamInput;  
        BytesStreamOutput output = new BytesStreamOutput();
package org.opensearch.action.admin.cluster.stats;
            JvmInfo.jvmInfo(),  
            -1L  // totalEstimatedNativeBytes
                IndexMetric.SEGMENTS,
                new ProcessStats.Cpu(randomShort(), randomNonNegativeLong()),
                IndexMetric.FIELDDATA,
    }
import org.opensearch.index.store.StoreStats;
            null,  
            shardStatsList.add(shardStats);
            null,  
                .retentionLeaseStats(null)
        }
 *
        assertNotNull(deserializedClusterStatsResponse.nodesStats.getJvm());  
            null,  
            null,  
                Collections.emptyList(),  
            null, // nativeAllocator
import java.io.IOException;
            null,
            null,
import java.util.Collections;
            Version.CURRENT,  
                .commitStats(null)
import org.opensearch.index.engine.SegmentsStats;
            randomNonNegativeLong(),
    private ClusterStatsNodeResponse createClusterStatsNodeResponse(DiscoveryNode node, ShardStats[] shardStats) throws IOException {  
            Set.of(ClusterStatsRequest.Metric.INDICES),
            .reservedSize(randomLongBetween(0, 1000))
            null,
            null,  
 * compatible open source license.
        return shardStatsList.toArray(new ShardStats[0]);
            null,  
            null, // concurrencyLimiterStats  
            Path path = createTempDir().resolve("indices")
            ClusterState.EMPTY_STATE,  
        for (int i = 0; i < 2; i++) {  
            null,  
        JvmStats.GarbageCollector[] garbageCollectorsArray = new JvmStats.GarbageCollector[1];
        assertEquals(clusterStatsResponse.indicesStats.getAnalysis(), deserializedClusterStatsResponse.indicesStats.getAnalysis());
                .seqNoStats(null)  
}
    public void testSerializationWithoutIndicesMappingAndAnalysisStats() throws Exception {
        commonStats.flush = new FlushStats.Builder().total(randomLongBetween(0, 100))  
        for (int i = 0; i < numberOfNodes; i++) {
                new BoundTransportAddress(new TransportAddress[] { buildNewFakeTransportAddress() }, buildNewFakeTransportAddress()),  
    }
        Index testIndex = new Index("test-index", "_na_");  
import org.opensearch.monitor.process.ProcessStats;  
                randomNonNegativeLong(),
            ClusterStatsNodeResponse customClusterStatsResponse = createClusterStatsNodeResponse(node, shardStats);  
            .hitCount(randomLongBetween(0, 100))  
import org.opensearch.transport.TransportInfo;  
import org.opensearch.index.fielddata.FieldDataStats;  
        assertEquals(clusterStatsResponse.clusterUUID, deserializedClusterStatsResponse.clusterUUID);
        }
        assertNotNull(deserializedClusterStatsResponse.indicesStats.getStore());  
 */  
            new ClusterName("cluster_name"),  
    }
            List.of(),
            ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
            .build();  
            null
        StreamInput streamInput = output.bytes().streamInput();
import org.opensearch.index.shard.DocsStats;
    }  
                garbageCollectors,
            );
            CommonStats commonStats = createRandomCommonStats();
            .deleted(randomLongBetween(0, 100))
            node,
import java.nio.file.Path;  
                .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))  
            null,
        NodeStats nodeStats = new NodeStats(
        List<ShardStats> shardStatsList = new ArrayList<>();
            null,
import org.opensearch.cluster.ClusterState;
