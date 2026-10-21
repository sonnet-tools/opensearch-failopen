            null,
            });
        public boolean equals(ClusterStatsIndices.ShardStats shardStats) {
    }
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
            Build.CURRENT,
import org.opensearch.common.network.NetworkModule;
        // Docs stats
        Index index,
            .build();
/*
            null,
            .cacheSize(randomLongBetween(0, 100))
        }
                            stat.getStats().getTotalTime() };
            null,
            node,
        stats = new ClusterStatsNodes.NetworkTypes(nodeInfos);
            null,
        );
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(first.getShards().getMinIndexPrimaryShards(), second.getShards().getMinIndexPrimaryShards());
 * You may obtain a copy of the License at
    ) {
        assertEquals(first.getStore().getSize(), second.getStore().getSize());
            -1L  // totalEstimatedNativeBytes
        NodeStats nodeStats = new NodeStats(
        // Completion Stats
            null,
                        return new long[] {
            null,
            null,
        commonStats.segments = new SegmentsStats();
import org.opensearch.cluster.routing.TestShardRouting;
        Index testIndex = new Index("test-index", "_na_");
        ClusterStatsNodeResponse newClusterStatsNodeRequest = new ClusterStatsNodeResponse(in);
 * this work for additional information regarding copyright
                localNode.getId(),
            null,
        // Segment Stats
                            stat.getStats().getCount(),
            null,
        assertEquals(first.getDocs().getDeleted(), second.getDocs().getDeleted());
            .build();
import org.opensearch.index.shard.DocsStats;
import java.util.Arrays;
        );
        assertEquals(first.getSegments().getBitsetMemoryInBytes(), second.getSegments().getBitsetMemoryInBytes());
        assertEquals(first.getSegments().getVersionMapMemoryInBytes(), second.getSegments().getVersionMapMemoryInBytes());
        processorStatsString += "}";
                + current
                return NodeStatsTests.createNodeStats();
            null,
        List<ShardStats> shardStatsList = new ArrayList<>();
            createNodeInfo("node_2", "custom", "custom"),
        assertEquals(first.getSegments().getVersionMapMemory(), second.getSegments().getVersionMapMemory());
import org.opensearch.Version;
            toXContent(stats, MediaTypeRegistry.JSON, randomBoolean()).utf8ToString()
 * specific language governing permissions and limitations
            null,
import org.opensearch.action.admin.cluster.node.stats.NodeStatsTests;
            null,
 */
            null,
        ClusterStatsNodes.IngestStats stats = new ClusterStatsNodes.IngestStats(Collections.singletonList(nodeStats));
            .totalTimeInMillis(randomLongBetween(0, 100))
 * GitHub history for details.
        int numberOfNodes = randomIntBetween(1, 4);
            long timeInMillis = statValues[3];
        }
            null,
            .build();
import org.opensearch.index.engine.SegmentsStats;
                .retentionLeaseStats(null)
                        value[3] += stat.getStats().getTotalTime();
            ShardStats[] shardStats = createshardStats(node, testIndex, commonStats);
        );
 * Modifications Copyright OpenSearch Contributors. See
     */
                i,
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
            "{\"transport_types\":{},\"http_types\":{}}",
import java.io.IOException;
        assertEquals(first.getDocs().getCount(), second.getDocs().getCount());
            null,
                    + "}}"
        assertTrue(first.getShards().getMaxIndexReplication() == second.getShards().getMaxIndexReplication());
        });
        assertTrue(first.getShards().getMinIndexReplication() == second.getShards().getMinIndexReplication());
        commonStats.docs = new DocsStats.Builder().count(randomLongBetween(0, 10000))
            null,
                    + processorStatsString
            aggregatedNodeLevelClusterStatsNodeResponses.add(customNodeLevelAggregatedClusterStatsResponse);
            return new ClusterStatsNodeResponse(node, null, nodeInfo, nodeStats, shardStats);
            long count = statValues[0];
 *
            if (iter.hasNext()) {
            toXContent(stats, MediaTypeRegistry.JSON, false).utf8ToString(),
            null,
                        value[1] += stat.getStats().getFailedCount();
            settings.build(),
        assertEquals(first.getDocs().getTotalSizeInBytes(), second.getDocs().getTotalSizeInBytes());
    }
            true
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(first.getSegments().getFileSizes(), second.getSegments().getFileSizes());
            null
    public void testNodeIndexShardStatsSuccessfulSerializationDeserialization() throws IOException {
        // Assuming the default behavior will be the type of response expected from a node of version prior to version containing
        boolean defaultBehavior,
            .cacheCount(randomLongBetween(0, 100))
        aggregatedNodeLevelClusterStatsNodeResponse.writeTo(out);
            null,
        assertThat(stats.pipelineCount, equalTo(nodeStats.getIngestStats().getProcessorStats().size()));
                .seqNoStats(null)
            Map.Entry<String, long[]> entry = iter.next();
        if (defaultBehavior) {
                .shardPath(new ShardPath(false, path, path, shardRouting.shardId()))
                && this.getReplication() == shardStats.getReplication()
    }
        assertEquals(
        NodeStats nodeStats = randomValueOtherThanMany(n -> n.getIngestStats() == null, () -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                processorStatsString += ",";
            node,
        );
        );
                .pollingIngestStats(null)
import static java.util.Collections.singletonList;
        );
        assertTrue(first.getShards().getAvgIndexShards() == second.getShards().getAvgIndexShards());
                .resolve(shardRouting.shardId().getIndex().getUUID())
            ShardStats shardStats = new ShardStats.Builder().shardRouting(shardRouting)
                });
            null,
    private ShardStats[] createshardStats(DiscoveryNode localNode, Index index, CommonStats commonStats) {
        while (iter.hasNext()) {
        );
                    if (value == null) {
        }
                node,
            toXContent(stats, MediaTypeRegistry.JSON, randomBoolean()).utf8ToString()
        ClusterStatsIndices defaultClusterStatsIndices = new ClusterStatsIndices(defaultClusterStatsNodeResponses, null, null);
        SortedMap<String, long[]> processorStats = new TreeMap<>();
    private static NodeInfo createNodeInfo(String nodeId, String transportType, String httpType) {
        assertTrue(first.getShards().getAvgIndexReplication() == second.getShards().getAvgIndexReplication());
                + "\":{\"count\":"
        assertThat(
        assertEquals(
            null,
                .build();
                    + stats.pipelineCount
            null,
    }
                "{\"ingest\":{"
                + ",\"time_in_millis\":"
 */
        assertEquals(
            null,
            try {
        // aggregated node level information
        }
                    } else {
            null,
        List<NodeInfo> nodeInfos = singletonList(createNodeInfo("node_0", null, null));
            createNodeInfo("node_3", null, "custom")
        for (int i = 0; i < numberOfNodes; i++) {
                index.getName(),
                && this.getTotal() == shardStats.getTotal()
            CommonStats commonStats = createRandomCommonStats();
 * compatible open source license.
        if (httpType != null) {
        assertTrue(first.getShards().getAvgIndexPrimaryShards() == second.getShards().getAvgIndexPrimaryShards());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.store.StoreStats;
        stats = new ClusterStatsNodes.NetworkTypes(nodeInfos);
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
                && this.getAvgIndexPrimaryShards() == shardStats.getAvgIndexPrimaryShards()
        assertEquals(first.getShards().getIndices(), second.getShards().getIndices());
    public void testMultiVersionScenarioWithAggregatedNodeLevelStats() {
            processorStatsString += "\""
            );
            null,
            DiscoveryNode node = new DiscoveryNode("node-" + i, buildNewFakeTransportAddress(), Version.CURRENT);
                        value[0] += stat.getStats().getCount();
        assertClusterStatsIndicesEqual(defaultClusterStatsIndices, aggregatedNodeLevelClusterStatsIndices);
import org.opensearch.core.xcontent.MediaTypeRegistry;
            null,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.admin.indices.stats.ShardStats;
            null,
 * The OpenSearch Contributors require contributions made to
            null,
        CommonStats commonStats = createRandomCommonStats();
                + failedCount
        commonStats.indexing = new IndexingStats();
                && this.getAvgIndexShards() == shardStats.getAvgIndexShards()
        assertEquals(first.getDocs().getAverageSizeInBytes(), second.getDocs().getAverageSizeInBytes());
            settings.put(randomFrom(NetworkModule.HTTP_TYPE_KEY, NetworkModule.HTTP_TYPE_DEFAULT_KEY), httpType);
            null,
    }
import org.opensearch.common.settings.Settings;
import org.opensearch.common.io.stream.BytesStreamOutput;
                .commitStats(null)
        }
                && this.getMaxIndexPrimaryShards() == shardStats.getMaxIndexPrimaryShards()
            return this.getIndices() == shardStats.getIndices()
            .build();
import org.opensearch.index.shard.ShardPath;
            null,
                && this.getMinIndexShards() == shardStats.getMinIndexShards()
        assertTrue(first.getShards().getMaxIndexPrimaryShards() == second.getShards().getMaxIndexPrimaryShards());
                            stat.getStats().getFailedCount(),
        List<ClusterStatsNodeResponse> aggregatedNodeLevelClusterStatsNodeResponses = new ArrayList<>();
    public void testNetworkTypesToXContent() throws Exception {
        );
        NodeInfo nodeInfo = new NodeInfo(
                && this.getMinIndexPrimaryShards() == shardStats.getMinIndexPrimaryShards()
                + timeInMillis
        );
            null,
            createNodeInfo("node_1", "", ""),
            } catch (IOException e) {
                + ",\"failed\":"
    }
                        return value;
            .hitCount(randomLongBetween(0, 100))
            null, // concurrencyLimiterStats
            shardStatsList.add(shardStats);
            ShardRoutingState shardRoutingState = ShardRoutingState.fromValue((byte) randomIntBetween(2, 3));
        assertEquals(first.getQueryCache().getEvictions(), second.getQueryCache().getEvictions());
 *
        assertEquals(first.getQueryCache().getTotalCount(), second.getQueryCache().getTotalCount());
                    + ","
import org.opensearch.Build;
                + "}";
 * the Apache License, Version 2.0 (the "License"); you may
        return shardStatsList.toArray(new ShardStats[0]);
        assertEquals(first.getIndexCount(), second.getIndexCount());
            null,
                && this.getPrimaries() == shardStats.getPrimaries()
        assertTrue(first.getShards().getReplication() == second.getShards().getReplication());
        return commonStats;
        return new NodeInfo(
        Index testIndex = new Index("test-index", "_na_");
import org.opensearch.cluster.routing.ShardRoutingState;
            null,
            null,
            equalTo(
            null,
    private CommonStats createRandomCommonStats() {
            long current = statValues[2];
 * KIND, either express or implied.  See the License for the
        ClusterStatsIndices afterSerialization = new ClusterStatsIndices(List.of(newClusterStatsNodeRequest), null, null);
    }
        assertEquals(first.getSegments().getBitsetMemory(), second.getSegments().getBitsetMemory());
        assertEquals(first.getQueryCache().getCacheSize(), second.getQueryCache().getCacheSize());
            null, // nativeAllocator
            ClusterStatsNodeResponse customClusterStatsResponse = createClusterStatsNodeResponse(node, shardStats, testIndex, true, false);
        Iterator<Map.Entry<String, long[]>> iter = processorStats.entrySet().iterator();
                true
import java.util.List;
                throw new RuntimeException(e);
                + entry.getKey()
import org.opensearch.test.OpenSearchTestCase;
        );
                    + "\"processor_stats\":"
import org.opensearch.action.admin.indices.stats.CommonStats;
                && this.getMaxIndexShards() == shardStats.getMaxIndexShards()
                .resolve(String.valueOf(shardRouting.shardId().id()));
            false,
            ClusterStatsNodeResponse customNodeLevelAggregatedClusterStatsResponse = createClusterStatsNodeResponse(
            .totalSizeInBytes(randomLongBetween(0, 1000))
        nodeInfos = Arrays.asList(
            randomNonNegativeLong(),
            testIndex,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.fielddata.FieldDataStats;
            null,
            Path path = createTempDir().resolve("indices")
        assertEquals(first.getShards().getMinIndexShards(), second.getShards().getMaxIndexShards());
                false,
    public void testIngestStats() throws Exception {
import java.util.TreeMap;
            null,
            .reservedSize(randomLongBetween(0, 1000))
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(first.getSegments().getCount(), second.getSegments().getCount());
import org.opensearch.core.common.io.stream.StreamInput;
        // Query Cache
import java.util.ArrayList;
        assertEquals(first.getQueryCache().getMemorySizeInBytes(), second.getQueryCache().getMemorySizeInBytes());
            null
            long failedCount = statValues[1];
            ShardRouting shardRouting = TestShardRouting.newShardRouting(
     * of the cluster stats xcontent output.
            "{" + "\"transport_types\":{\"custom\":1}," + "\"http_types\":{\"custom\":2}" + "}",
        // As AssertEquals with double is deprecated and can only be used to compare floating-point numbers
                shardStats,
        assertEquals(first.getQueryCache().getMemorySize(), second.getQueryCache().getMemorySize());
            .fieldMemoryStats(null)
 * under the License.
        ShardStats[] shardStats = createshardStats(node, testIndex, commonStats);
        // Store Stats
 * not use this file except in compliance with the License.
 */
            .periodic(randomLongBetween(0, 100))
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
     * Test that empty transport/http types are not printed out as part
        assertEquals(first.getCompletion().getSize(), second.getCompletion().getSize());
            long[] statValues = entry.getValue();
            null,
            null,
        assertEquals(first.getQueryCache().getMissCount(), second.getQueryCache().getMissCount());
            null,
        ClusterStatsIndices aggregatedNodeLevelClusterStatsIndices = new ClusterStatsIndices(
        commonStats.flush = new FlushStats.Builder().total(randomLongBetween(0, 100))
            aggregatedNodeLevelClusterStatsNodeResponses,
            null,
                randomBoolean(),
        ShardStats[] shardStats,
        boolean aggregateNodeLevelStats
            null,
            null,
        commonStats.fieldData = new FieldDataStats.Builder().memorySize(randomLongBetween(0, 100))
                        value[2] += stat.getStats().getCurrent();
    /**
                .commonStats(commonStats)
        assertEquals(first.getStore().getSizeInBytes(), second.getStore().getSizeInBytes());
        } else {
import java.util.Map;
        ClusterStatsNodeResponse aggregatedNodeLevelClusterStatsNodeResponse = createClusterStatsNodeResponse(
        DiscoveryNode node,
 *
            );
 * Unless required by applicable law or agreed to in writing,
    private class MockShardStats extends ClusterStatsIndices.ShardStats {
                && this.getAvgIndexReplication() == shardStats.getAvgIndexReplication()
            null,
                && this.getMinIndexReplication() == shardStats.getMinIndexReplication()
                    + "\"number_of_pipelines\":"
        DiscoveryNode node = new DiscoveryNode("node", buildNewFakeTransportAddress(), Version.CURRENT);
import java.util.SortedMap;
        commonStats.queryCache = new QueryCacheStats.Builder().ramBytesUsed(randomLongBetween(0, 100))
        ClusterStatsNodes.NetworkTypes stats = new ClusterStatsNodes.NetworkTypes(emptyList());
                            stat.getStats().getCurrent(),
import static org.hamcrest.Matchers.equalTo;
            null
        assertEquals(first.getQueryCache().getHitCount(), second.getQueryCache().getHitCount());
                + count
import org.opensearch.core.index.Index;
        StreamInput in = out.bytes().streamInput();
        }
import org.opensearch.cluster.routing.ShardRouting;
        assertEquals(first.getCompletion().getSizeInBytes(), second.getCompletion().getSizeInBytes());
            new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), null),
    private ClusterStatsNodeResponse createClusterStatsNodeResponse(
import java.util.Iterator;
        assertEquals(first.getStore().getReservedSize(), second.getStore().getReservedSize());
            null,
            null,
        assertEquals(first.getShards().getPrimaries(), second.getShards().getPrimaries());
        assertEquals(first.getQueryCache().getCacheCount(), second.getQueryCache().getCacheCount());
        commonStats.store = new StoreStats.Builder().sizeInBytes(randomLongBetween(0, 100))
            defaultClusterStatsNodeResponses.add(customClusterStatsResponse);
        Settings.Builder settings = Settings.builder();
    }
            null,
        nodeStats.getIngestStats().getProcessorStats().values().forEach(stats -> {
        }
                testIndex,
/*
        assertClusterStatsIndicesEqual(beforeSerialization, afterSerialization);
        assertEquals(first.getSegments().getIndexWriterMemoryInBytes(), second.getSegments().getIndexWriterMemoryInBytes());
            settings.put(randomFrom(NetworkModule.TRANSPORT_TYPE_KEY, NetworkModule.TRANSPORT_TYPE_DEFAULT_KEY), transportType);
            null,
import static java.util.Collections.emptyList;
import java.util.Collections;
package org.opensearch.action.admin.cluster.stats;
 * software distributed under the License is distributed on an
        assertEquals(first.getShards().getTotal(), second.getShards().getTotal());
        commonStats.completion = new CompletionStats();
            .deleted(randomLongBetween(0, 100))
        if (transportType != null) {
            }
            return new ClusterStatsNodeResponse(node, null, nodeInfo, nodeStats, shardStats, aggregateNodeLevelStats);
            Version.CURRENT,
        });
            null,
                + ",\"current\":"
        String processorStatsString = "{";
    }
            }
            )
    public void assertClusterStatsIndicesEqual(ClusterStatsIndices first, ClusterStatsIndices second) {
import java.nio.file.Path;
            null,
            null,
            null,
        for (int i = 0; i < 2; i++) {
            .build();
                processorStats.compute(stat.getType(), (key, value) -> {
            null,
                shardRoutingState
import org.opensearch.search.suggest.completion.CompletionStats;
            null,
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.index.flush.FlushStats;
            shardStats,
        List<ClusterStatsNodeResponse> defaultClusterStatsNodeResponses = new ArrayList<>();
                    }
            stats.forEach(stat -> {
        BytesStreamOutput out = new BytesStreamOutput();
public class ClusterStatsNodesTests extends OpenSearchTestCase {
            null,
            .missCount(randomLongBetween(0, 100))
        CommonStats commonStats = new CommonStats(CommonStatsFlags.NONE);
            node,
    }
                && this.getMaxIndexReplication() == shardStats.getMaxIndexReplication();
}
            .evictions(randomLongBetween(0, 100))
import org.opensearch.index.cache.query.QueryCacheStats;
        ClusterStatsIndices beforeSerialization = new ClusterStatsIndices(List.of(aggregatedNodeLevelClusterStatsNodeResponse), null, null);
            toXContent(stats, MediaTypeRegistry.JSON, randomBoolean()).utf8ToString()
import org.opensearch.index.shard.IndexingStats;
            "{\"transport_types\":{},\"http_types\":{}}",
/*
