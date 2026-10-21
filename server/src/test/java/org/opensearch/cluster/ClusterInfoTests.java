public class ClusterInfoTests extends OpenSearchTestCase {
            randomRoutingToDataPath(1),
 *
            randomShardSizes(randomIntBetween(0, 128)),
                ),
                    FileCacheStatsType.OVER_ALL_STATS
                    randomLong(),
                    randomLong(),
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
        final Map<String, DiskUsage> builder = new HashMap<>(numEntries);
            // Verify reserved_sizes
            // Verify shard_sizes
                    randomLong(),
            randomFileCacheStats(1),
        assertEquals(clusterInfo.getNodeLeastAvailableDiskUsages(), result.getNodeLeastAvailableDiskUsages());
            long shardSize = randomIntBetween(0, Integer.MAX_VALUE);
        XContentBuilder builder = XContentFactory.jsonBuilder();
 *
    }
                    randomLong(),
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 * this work for additional information regarding copyright
    }
                    randomLong(),
            builder.put(key, nodeResourceUsageStats);
            assertTrue(reservedSizeEntry.containsKey("node_id"));
            randomFileCacheStats(randomIntBetween(0, 18)),
                    randomLong(),
    private static Map<String, Long> randomShardSizes(int numEntries) {
            builder.put(key, shardSize);
            parser.nextToken();
        builder.endObject();
            assertTrue(reservedSizeEntry.containsKey("path"));
 * under the License.
        for (int i = 0; i < numEntries; i++) {
            builder.put(key, fileCacheStats);
        final Map<String, Long> builder = new HashMap<>(numEntries);
                new FileCacheStats(
        }
        }
/*
                    randomLong(),
 * SPDX-License-Identifier: Apache-2.0
        return builder;
 * not use this file except in compliance with the License.
        return builder;
                    randomLong(),
        }
            builder.put(key, valueBuilder.build());
            ShardId shardId = new ShardId(randomAlphaOfLength(32), randomAlphaOfLength(32), randomIntBetween(0, Integer.MAX_VALUE));
}
 * You may obtain a copy of the License at
            Map<String, Object> shardPathsMap = parser.map();
            assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
            parser.nextToken();
                    randomLong(),
        BytesStreamOutput output = new BytesStreamOutput();
                randomAlphaOfLength(4),
 */
 *
            randomNodeResourceUsageStats(1)
            builder.put(shardRouting, randomAlphaOfLength(32));
                    randomLong(),
                randomDoubleBetween(0, 100, false),
                    randomLong(),
                    randomLong(),
                    randomLong(),
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
                    randomLong(),
 */
        assertEquals(clusterInfo.getNodeFileCacheStats().size(), result.getNodeFileCacheStats().size());
    private static Map<String, NodeResourceUsageStats> randomNodeResourceUsageStats(int numEntries) {
            randomDiskUsage(1),
                null,
                totalBytes,
                    randomLong(),
        return builder;
import org.opensearch.core.xcontent.XContentParser;
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
                    randomLong(),
        return builder;
                new FileCacheStats(
                valueBuilder.add(shardId, between(0, Integer.MAX_VALUE));
                randomDoubleBetween(0, 100, false)
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        for (int i = 0; i < numEntries; i++) {
        assertEquals(clusterInfo.getNodeMostAvailableDiskUsages(), result.getNodeMostAvailableDiskUsages());
        final Map<ShardRouting, String> builder = new HashMap<>(numEntries);
            final ClusterInfo.NodeAndPath key = new ClusterInfo.NodeAndPath(randomAlphaOfLength(10), randomAlphaOfLength(10));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> builder = new HashMap<>(numEntries);
                randomDoubleBetween(0, 100, false),
                    FileCacheStatsType.PINNED_FILE_STATS
import java.util.HashMap;
                    randomLong(),
 * software distributed under the License is distributed on an
            assertEquals("shard_sizes", parser.currentName());
            NodeResourceUsageStats nodeResourceUsageStats = new NodeResourceUsageStats(
                    randomLong(),
 * specific language governing permissions and limitations
 */
 * Licensed to Elasticsearch under one or more contributor
        for (int i = 0; i < numEntries; i++) {
        assertEquals(clusterInfo.reservedSpace, result.reservedSpace);
import java.util.Map;
                    randomLong(),
            randomDiskUsage(1),
            String key = randomAlphaOfLength(32);
 * the Apache License, Version 2.0 (the "License"); you may
                    randomLong(),
            Map<String, Object> node1 = parser.map();
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.node.NodeResourceUsageStats;
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.cluster.routing.TestShardRouting;
            randomDiskUsage(randomIntBetween(0, 128)),
 * KIND, either express or implied.  See the License for the
                    randomLong(),
                randomAlphaOfLength(4),
        for (int i = 0; i < numEntries; i++) {
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                randomAlphaOfLength(4),
            DiskUsage diskUsage = new DiskUsage(
    public void testToXContent() throws Exception {
    public void testSerialization() throws Exception {
            parser.nextToken();
                new FileCacheStats(
                    randomLong(),
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        final Map<String, AggregateFileCacheStats> builder = new HashMap<>(numEntries);
        ClusterInfo result = new ClusterInfo(output.bytes().streamInput());
        clusterInfo.toXContent(builder, ToXContent.EMPTY_PARAMS);
            final ClusterInfo.ReservedSpace.Builder valueBuilder = new ClusterInfo.ReservedSpace.Builder();
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
            );
                new FileCacheStats(
                randomLong(),
/*
    private static Map<String, DiskUsage> randomDiskUsage(int numEntries) {
import org.opensearch.cluster.routing.ShardRoutingState;
            randomShardSizes(1),
                ),
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
    private static Map<String, AggregateFileCacheStats> randomFileCacheStats(int numEntries) {
        return builder;
        final Map<String, NodeResourceUsageStats> builder = new HashMap<>(numEntries);
    private static Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> randomReservedSpace(int numEntries) {
                    randomLong(),
        clusterInfo.writeTo(output);
                )
            assertNotNull(node1.get("least_available"));
                    randomLong(),
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                randomAlphaOfLength(4),
        assertEquals(clusterInfo.shardSizes, result.shardSizes);
            }
            String key = randomAlphaOfLength(16);
    }
                    randomLong(),
    }
        for (int i = 0; i < numEntries; i++) {
        assertEquals(clusterInfo.getNodeResourceUsageStats().toString(), result.getNodeResourceUsageStats().toString());
            randomNodeResourceUsageStats(randomIntBetween(0, 20))
 * license agreements. See the NOTICE file distributed with
            randomReservedSpace(1),
            String key = randomAlphaOfLength(32);
            parser.nextToken();
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            builder.put(key, diskUsage);
    }
        }
            );
        }
                    randomLong(),
        for (int i = 0; i < numEntries; i++) {
            assertEquals("reserved_sizes", parser.currentName());
import org.opensearch.cluster.routing.ShardRouting;
    }
            for (int j = between(0, 10); j > 0; j--) {
            randomReservedSpace(randomIntBetween(0, 18)),
        );
                ShardId shardId = new ShardId(randomAlphaOfLength(32), randomAlphaOfLength(32), randomIntBetween(0, Integer.MAX_VALUE));
import org.opensearch.index.store.remote.filecache.FileCacheStats;
            Map<String, Object> shardSizesMap = parser.map();
                randomLongBetween(0, totalBytes)
import org.opensearch.core.index.shard.ShardId;
 * ownership. Elasticsearch licenses this file to you under
            assertEquals("shard_paths", parser.currentName());
            // Verify shard_paths
                    randomLong(),
            String key = randomAlphaOfLength(32);
            Map<String, Object> reservedSizeEntry = parser.map();
                ),
import org.opensearch.core.common.bytes.BytesReference;
package org.opensearch.cluster;
/*
            assertEquals(XContentParser.Token.END_ARRAY, parser.nextToken());
            String nodeId = parser.currentName();
            assertNotNull(node1.get("node_resource_usage_stats"));
            long totalBytes = randomIntBetween(0, Integer.MAX_VALUE);
    }
import org.opensearch.common.xcontent.json.JsonXContent;
        return builder;
    private static Map<ShardRouting, String> randomRoutingToDataPath(int numEntries) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        }
    }
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                    FileCacheStatsType.BLOCK_FILE_STATS
                    randomLong(),
        ClusterInfo clusterInfo = new ClusterInfo(
            ShardRouting shardRouting = TestShardRouting.newShardRouting(shardId, null, randomBoolean(), ShardRoutingState.UNASSIGNED);
            randomRoutingToDataPath(randomIntBetween(0, 18)),
            );
                    randomLong(),
                    randomLong(),
        );
                    randomLong(),
                    randomLong(),
 * compatible open source license.
                randomLong(),
 *     http://www.apache.org/licenses/LICENSE-2.0
        ClusterInfo clusterInfo = new ClusterInfo(
        builder.startObject();
 * Unless required by applicable law or agreed to in writing,
            AggregateFileCacheStats fileCacheStats = new AggregateFileCacheStats(
        }
            randomDiskUsage(randomIntBetween(0, 128)),
            assertNotNull(node1.get("most_available"));
                    FileCacheStatsType.FULL_FILE_STATS
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            // Verify node1 content
        assertEquals(clusterInfo.routingToDataPath, result.routingToDataPath);
