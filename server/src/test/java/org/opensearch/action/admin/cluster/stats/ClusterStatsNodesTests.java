        // Docs stats
            Version.CURRENT,
 * the Apache License, Version 2.0 (the "License"); you may
                && this.getMaxIndexPrimaryShards() == shardStats.getMaxIndexPrimaryShards()
 *
            ShardRouting shardRouting = TestShardRouting.newShardRouting(
        assertClusterStatsIndicesEqual(defaultClusterStatsIndices, aggregatedNodeLevelClusterStatsIndices);
    private ShardStats[] createshardStats(DiscoveryNode localNode, Index index, CommonStats commonStats) {
                throw new RuntimeException(e);
        for (int i = 0; i < 2; i++) {  
            null,
                + timeInMillis
            }  
        BytesStreamOutput out = new BytesStreamOutput();
                .seqNoStats(null)  
            testIndex,  
    }
        NodeStats nodeStats = new NodeStats(
        assertEquals(first.getSegments().getVersionMapMemoryInBytes(), second.getSegments().getVersionMapMemoryInBytes());  
        stats = new ClusterStatsNodes.NetworkTypes(nodeInfos);
    public void testMultiVersionScenarioWithAggregatedNodeLevelStats() {
        // Query Cache  
                    + "}}"  
import org.opensearch.action.admin.indices.stats.CommonStats;  
        DiscoveryNode node,
            node,
    }
            null,  
        assertEquals(first.getQueryCache().getHitCount(), second.getQueryCache().getHitCount());
        assertEquals(first.getDocs().getAverageSizeInBytes(), second.getDocs().getAverageSizeInBytes());
        assertEquals(first.getDocs().getTotalSizeInBytes(), second.getDocs().getTotalSizeInBytes());
    private CommonStats createRandomCommonStats() {
                            stat.getStats().getCurrent(),
        assertEquals(first.getStore().getReservedSize(), second.getStore().getReservedSize());
                    + processorStatsString
        commonStats.indexing = new IndexingStats();
            null
            aggregatedNodeLevelClusterStatsNodeResponses.add(customNodeLevelAggregatedClusterStatsResponse);  
 *
        assertEquals(first.getSegments().getFileSizes(), second.getSegments().getFileSizes());  
                .commitStats(null)
        assertEquals(first.getQueryCache().getEvictions(), second.getQueryCache().getEvictions());  
        assertEquals(first.getCompletion().getSize(), second.getCompletion().getSize());  
            });  
            .build();
            .reservedSize(randomLongBetween(0, 1000))
            null,
            shardStats,
 * SPDX-License-Identifier: Apache-2.0
            settings.put(randomFrom(NetworkModule.TRANSPORT_TYPE_KEY, NetworkModule.TRANSPORT_TYPE_DEFAULT_KEY), transportType);
            toXContent(stats, MediaTypeRegistry.JSON, randomBoolean()).utf8ToString()
            toXContent(stats, MediaTypeRegistry.JSON, randomBoolean()).utf8ToString()  
                .commonStats(commonStats)
            Path path = createTempDir().resolve("indices")
                testIndex,
        assertEquals(first.getQueryCache().getCacheSize(), second.getQueryCache().getCacheSize());
        assertEquals(first.getSegments().getIndexWriterMemoryInBytes(), second.getSegments().getIndexWriterMemoryInBytes());
/*
            long count = statValues[0];
        assertEquals(first.getShards().getTotal(), second.getShards().getTotal());
            ShardStats[] shardStats = createshardStats(node, testIndex, commonStats);
            )
            new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), null),  
            null,  
                + failedCount
        List<ShardStats> shardStatsList = new ArrayList<>();
        ClusterStatsNodeResponse newClusterStatsNodeRequest = new ClusterStatsNodeResponse(in);  
                return NodeStatsTests.createNodeStats();  
        return shardStatsList.toArray(new ShardStats[0]);
        assertTrue(first.getShards().getAvgIndexReplication() == second.getShards().getAvgIndexReplication());
                false,
                    + stats.pipelineCount
        String processorStatsString = "{";
        assertEquals(first.getDocs().getCount(), second.getDocs().getCount());
        assertEquals(first.getStore().getSizeInBytes(), second.getStore().getSizeInBytes());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.admin.indices.stats.ShardStats;
import org.opensearch.cluster.routing.TestShardRouting;  
        aggregatedNodeLevelClusterStatsNodeResponse.writeTo(out);  
                        value[1] += stat.getStats().getFailedCount();  
            return this.getIndices() == shardStats.getIndices()  
            null,
    public void testIngestStats() throws Exception {  
                + "}";  
            null,
        assertEquals(first.getShards().getMinIndexPrimaryShards(), second.getShards().getMinIndexPrimaryShards());
        assertTrue(first.getShards().getMinIndexReplication() == second.getShards().getMinIndexReplication());  
            }  
        ClusterStatsIndices afterSerialization = new ClusterStatsIndices(List.of(newClusterStatsNodeRequest), null, null);  
        nodeInfos = Arrays.asList(  
import java.nio.file.Path;
    }
                        value[2] += stat.getStats().getCurrent();
import java.util.TreeMap;  
            shardStatsList.add(shardStats);
import org.opensearch.search.suggest.completion.CompletionStats;  
            null,
        Index testIndex = new Index("test-index", "_na_");
                    + "\"processor_stats\":"
            null,  
package org.opensearch.action.admin.cluster.stats;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collections;
        }
    ) {  
        );
            Map.Entry<String, long[]> entry = iter.next();
        if (defaultBehavior) {
        commonStats.segments = new SegmentsStats();
        assertEquals(first.getQueryCache().getMemorySize(), second.getQueryCache().getMemorySize());
import java.util.List;  
            null,  
        public boolean equals(ClusterStatsIndices.ShardStats shardStats) {
                && this.getMinIndexReplication() == shardStats.getMinIndexReplication()
                "{\"ingest\":{"  
     */  
            .cacheCount(randomLongBetween(0, 100))
        return commonStats;
            null,
        List<ClusterStatsNodeResponse> defaultClusterStatsNodeResponses = new ArrayList<>();
            null,
                localNode.getId(),
        // Store Stats
            null,  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Iterator<Map.Entry<String, long[]>> iter = processorStats.entrySet().iterator();  
            null,  
        assertEquals(first.getIndexCount(), second.getIndexCount());
        NodeStats nodeStats = randomValueOtherThanMany(n -> n.getIngestStats() == null, () -> {
            null,
            .totalTimeInMillis(randomLongBetween(0, 100))
 * KIND, either express or implied.  See the License for the
        assertEquals(first.getShards().getMinIndexShards(), second.getShards().getMaxIndexShards());
 * The OpenSearch Contributors require contributions made to  
                i,
            null,  
            null,  
            .deleted(randomLongBetween(0, 100))
        assertThat(stats.pipelineCount, equalTo(nodeStats.getIngestStats().getProcessorStats().size()));
            long current = statValues[2];  
        assertEquals(first.getQueryCache().getTotalCount(), second.getQueryCache().getTotalCount());
            false,
        commonStats.docs = new DocsStats.Builder().count(randomLongBetween(0, 10000))  
        Index index,  
import org.opensearch.common.network.NetworkModule;
            try {
        }
                index.getName(),  
 */  
        boolean defaultBehavior,
        ClusterStatsIndices aggregatedNodeLevelClusterStatsIndices = new ClusterStatsIndices(
            Build.CURRENT,  
        commonStats.store = new StoreStats.Builder().sizeInBytes(randomLongBetween(0, 100))
        }
        ClusterStatsNodes.NetworkTypes stats = new ClusterStatsNodes.NetworkTypes(emptyList());
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                node,
        assertEquals(first.getShards().getPrimaries(), second.getShards().getPrimaries());  
        }
            null,
            stats.forEach(stat -> {
    public void testNetworkTypesToXContent() throws Exception {
import static org.hamcrest.Matchers.equalTo;
        );
            null, // nativeAllocator
 * Modifications Copyright OpenSearch Contributors. See
        );
            null,
 * Unless required by applicable law or agreed to in writing,
        if (transportType != null) {  
    private ClusterStatsNodeResponse createClusterStatsNodeResponse(  
            null,
            null,
        commonStats.flush = new FlushStats.Builder().total(randomLongBetween(0, 100))  
                            stat.getStats().getFailedCount(),
            settings.put(randomFrom(NetworkModule.HTTP_TYPE_KEY, NetworkModule.HTTP_TYPE_DEFAULT_KEY), httpType);
import org.opensearch.index.store.StoreStats;
                .retentionLeaseStats(null)
import org.opensearch.action.admin.cluster.node.info.NodeInfo;  
            null,  
                + current  
import org.opensearch.index.shard.DocsStats;
                        return new long[] {
        stats = new ClusterStatsNodes.NetworkTypes(nodeInfos);  
        List<ClusterStatsNodeResponse> aggregatedNodeLevelClusterStatsNodeResponses = new ArrayList<>();  
    private class MockShardStats extends ClusterStatsIndices.ShardStats {
                    + ","  
     * Test that empty transport/http types are not printed out as part
                .resolve(String.valueOf(shardRouting.shardId().id()));  
            return new ClusterStatsNodeResponse(node, null, nodeInfo, nodeStats, shardStats, aggregateNodeLevelStats);
import org.opensearch.index.cache.query.QueryCacheStats;
        assertEquals(first.getSegments().getBitsetMemory(), second.getSegments().getBitsetMemory());  
import org.opensearch.index.flush.FlushStats;
 * under the License.  
        assertThat(  
                processorStats.compute(stat.getType(), (key, value) -> {  
        SortedMap<String, long[]> processorStats = new TreeMap<>();  
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.ShardRoutingState;
                randomBoolean(),  
            null, // concurrencyLimiterStats
        assertEquals(first.getQueryCache().getMemorySizeInBytes(), second.getQueryCache().getMemorySizeInBytes());
            null,  
            null,
                            stat.getStats().getCount(),  
        assertTrue(first.getShards().getReplication() == second.getShards().getReplication());
        );  
        });
                        return value;  
        ShardStats[] shardStats = createshardStats(node, testIndex, commonStats);
        DiscoveryNode node = new DiscoveryNode("node", buildNewFakeTransportAddress(), Version.CURRENT);  
            long failedCount = statValues[1];
            null,
        } else {
            null,  
            aggregatedNodeLevelClusterStatsNodeResponses,
            } catch (IOException e) {
        ClusterStatsNodes.IngestStats stats = new ClusterStatsNodes.IngestStats(Collections.singletonList(nodeStats));  
            node,
            "{" + "\"transport_types\":{\"custom\":1}," + "\"http_types\":{\"custom\":2}" + "}",
                        value[0] += stat.getStats().getCount();
            null,
            -1L  // totalEstimatedNativeBytes  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .build();  
        // Completion Stats
 */  
            null,
                processorStatsString += ",";
 * ownership. Elasticsearch licenses this file to you under  
        );
    private static NodeInfo createNodeInfo(String nodeId, String transportType, String httpType) {
        ClusterStatsIndices defaultClusterStatsIndices = new ClusterStatsIndices(defaultClusterStatsNodeResponses, null, null);  
 * specific language governing permissions and limitations
            null,
            .evictions(randomLongBetween(0, 100))
            toXContent(stats, MediaTypeRegistry.JSON, randomBoolean()).utf8ToString()
import java.util.Arrays;  
        commonStats.completion = new CompletionStats();
        assertEquals(first.getQueryCache().getMissCount(), second.getQueryCache().getMissCount());  
            .build();  
            null  
                .build();  
import java.util.Map;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        // Segment Stats
            return new ClusterStatsNodeResponse(node, null, nodeInfo, nodeStats, shardStats);  
            null,
            toXContent(stats, MediaTypeRegistry.JSON, false).utf8ToString(),
 * license agreements. See the NOTICE file distributed with
            null,
                && this.getMaxIndexShards() == shardStats.getMaxIndexShards()
            null
import static java.util.Collections.emptyList;
            null,
            DiscoveryNode node = new DiscoveryNode("node-" + i, buildNewFakeTransportAddress(), Version.CURRENT);  
import org.opensearch.index.shard.ShardPath;
            null,
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            null,
        // Assuming the default behavior will be the type of response expected from a node of version prior to version containing  
            "{\"transport_types\":{},\"http_types\":{}}",
import org.opensearch.cluster.node.DiscoveryNode;  
/*  
            ClusterStatsNodeResponse customClusterStatsResponse = createClusterStatsNodeResponse(node, shardStats, testIndex, true, false);  
        ClusterStatsNodeResponse aggregatedNodeLevelClusterStatsNodeResponse = createClusterStatsNodeResponse(  
            equalTo(
            long timeInMillis = statValues[3];
            null,
        ClusterStatsIndices beforeSerialization = new ClusterStatsIndices(List.of(aggregatedNodeLevelClusterStatsNodeResponse), null, null);
            .build();  
        assertClusterStatsIndicesEqual(beforeSerialization, afterSerialization);
            true
        assertEquals(first.getSegments().getCount(), second.getSegments().getCount());
        });
        );  
            ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
import java.util.SortedMap;
                        value[3] += stat.getStats().getTotalTime();
            .build();
import org.opensearch.index.shard.IndexingStats;  
 * compatible open source license.
            null,
                && this.getMinIndexShards() == shardStats.getMinIndexShards()
            defaultClusterStatsNodeResponses.add(customClusterStatsResponse);
            null,
            if (iter.hasNext()) {
import org.opensearch.Build;
    public void assertClusterStatsIndicesEqual(ClusterStatsIndices first, ClusterStatsIndices second) {
            null,  
        // As AssertEquals with double is deprecated and can only be used to compare floating-point numbers
import java.io.IOException;  
            null,  
        processorStatsString += "}";
        assertEquals(first.getDocs().getDeleted(), second.getDocs().getDeleted());  
        );
        assertEquals(first.getShards().getIndices(), second.getShards().getIndices());
        assertEquals(first.getCompletion().getSizeInBytes(), second.getCompletion().getSizeInBytes());
                && this.getMinIndexPrimaryShards() == shardStats.getMinIndexPrimaryShards()
import org.opensearch.cluster.routing.ShardRouting;
    }
        assertTrue(first.getShards().getAvgIndexShards() == second.getShards().getAvgIndexShards());  
        assertTrue(first.getShards().getMaxIndexReplication() == second.getShards().getMaxIndexReplication());
            "{\"transport_types\":{},\"http_types\":{}}",
/*  
        List<NodeInfo> nodeInfos = singletonList(createNodeInfo("node_0", null, null));
            .totalSizeInBytes(randomLongBetween(0, 1000))
    }
            null,
                && this.getReplication() == shardStats.getReplication()  
                + ",\"failed\":"  
            ClusterStatsNodeResponse customNodeLevelAggregatedClusterStatsResponse = createClusterStatsNodeResponse(
        }  
            null,
import static java.util.Collections.singletonList;  
            randomNonNegativeLong(),  
    }  
                .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))  
                && this.getAvgIndexShards() == shardStats.getAvgIndexShards()  
        ShardStats[] shardStats,
            null,
        }
            settings.build(),
            null,
            createNodeInfo("node_1", "", ""),
                && this.getPrimaries() == shardStats.getPrimaries()
        );  
import org.opensearch.index.engine.SegmentsStats;
                + count
        );
        // aggregated node level information
            null,
        assertEquals(first.getSegments().getBitsetMemoryInBytes(), second.getSegments().getBitsetMemoryInBytes());
        assertTrue(first.getShards().getMaxIndexPrimaryShards() == second.getShards().getMaxIndexPrimaryShards());
                && this.getTotal() == shardStats.getTotal()
            null,  
     * of the cluster stats xcontent output.
            node,
            null,
        Settings.Builder settings = Settings.builder();
                true  
            createNodeInfo("node_2", "custom", "custom"),
    /**  
        Index testIndex = new Index("test-index", "_na_");  
import org.opensearch.action.admin.cluster.node.stats.NodeStatsTests;
            );
        assertTrue(first.getShards().getAvgIndexPrimaryShards() == second.getShards().getAvgIndexPrimaryShards());
        boolean aggregateNodeLevelStats
        assertEquals(  
        assertEquals(first.getSegments().getVersionMapMemory(), second.getSegments().getVersionMapMemory());
                + "\":{\"count\":"
                shardRoutingState
import org.opensearch.Version;
                && this.getAvgIndexPrimaryShards() == shardStats.getAvgIndexPrimaryShards()  
import java.util.Iterator;
        CommonStats commonStats = createRandomCommonStats();
                    }
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
 * software distributed under the License is distributed on an
        assertEquals(first.getQueryCache().getCacheCount(), second.getQueryCache().getCacheCount());
    }
                && this.getMaxIndexReplication() == shardStats.getMaxIndexReplication();  
import org.opensearch.index.fielddata.FieldDataStats;  
        int numberOfNodes = randomIntBetween(1, 4);
                    if (value == null) {
        return new NodeInfo(  
                    } else {
    }
import java.util.ArrayList;
        assertEquals(  
                + ",\"current\":"
            );
                + ",\"time_in_millis\":"
 * this work for additional information regarding copyright
        while (iter.hasNext()) {
            null,
                .resolve(shardRouting.shardId().getIndex().getUUID())
        commonStats.queryCache = new QueryCacheStats.Builder().ramBytesUsed(randomLongBetween(0, 100))
 * GitHub history for details.
        assertEquals(
            null,  
        NodeInfo nodeInfo = new NodeInfo(
        if (httpType != null) {  
        commonStats.fieldData = new FieldDataStats.Builder().memorySize(randomLongBetween(0, 100))
import org.opensearch.common.io.stream.BytesStreamOutput;
            null,
            createNodeInfo("node_3", null, "custom")  
                && this.getAvgIndexReplication() == shardStats.getAvgIndexReplication()
                .pollingIngestStats(null)
            .hitCount(randomLongBetween(0, 100))  
            ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
            null,  
            CommonStats commonStats = createRandomCommonStats();
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
            null,  
                    + "\"number_of_pipelines\":"
    public void testNodeIndexShardStatsSuccessfulSerializationDeserialization() throws IOException {  
public class ClusterStatsNodesTests extends OpenSearchTestCase {
            null,
                shardStats,  
 *  
            .missCount(randomLongBetween(0, 100))
        }
import org.opensearch.core.common.io.stream.StreamInput;
            .periodic(randomLongBetween(0, 100))
                + entry.getKey()  
            .cacheSize(randomLongBetween(0, 100))  
import org.opensearch.core.index.Index;
                });
            null,
}  
    }
            processorStatsString += "\""
            long[] statValues = entry.getValue();  
        nodeStats.getIngestStats().getProcessorStats().values().forEach(stats -> {
        StreamInput in = out.bytes().streamInput();
    }
import org.opensearch.common.settings.Settings;  
            .fieldMemoryStats(null)  
            null,
        );
                            stat.getStats().getTotalTime() };  
        for (int i = 0; i < numberOfNodes; i++) {
import org.opensearch.test.OpenSearchTestCase;
            null,  
 */
 * You may obtain a copy of the License at  
        assertEquals(first.getStore().getSize(), second.getStore().getSize());  
