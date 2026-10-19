 * You may obtain a copy of the License at  
            }
            randomDiskUsage(1),
            final ClusterInfo.NodeAndPath key = new ClusterInfo.NodeAndPath(randomAlphaOfLength(10), randomAlphaOfLength(10));  
        for (int i = 0; i < numEntries; i++) {
            assertEquals("shard_sizes", parser.currentName());
            parser.nextToken();
                ),
        }
import org.opensearch.index.store.remote.filecache.FileCacheStats;
 *     http://www.apache.org/licenses/LICENSE-2.0
            builder.put(key, fileCacheStats);
        return builder;
        }
        builder.endObject();
 * ownership. Elasticsearch licenses this file to you under  
    }
    }  
                new FileCacheStats(
                randomLong(),  
 * Licensed to Elasticsearch under one or more contributor  
                totalBytes,
        return builder;
                new FileCacheStats(
        }
        for (int i = 0; i < numEntries; i++) {  
 *
import org.opensearch.common.io.stream.BytesStreamOutput;  
                    randomLong(),
 * license agreements. See the NOTICE file distributed with
    private static Map<String, AggregateFileCacheStats> randomFileCacheStats(int numEntries) {
import org.opensearch.core.xcontent.XContentParser;
 */
        for (int i = 0; i < numEntries; i++) {
                randomLong(),
 * not use this file except in compliance with the License.
    }  
                    randomLong(),
        return builder;
        }  
import java.util.Map;  
    public void testToXContent() throws Exception {  
        assertEquals(clusterInfo.routingToDataPath, result.routingToDataPath);  
import org.opensearch.cluster.routing.TestShardRouting;
            Map<String, Object> reservedSizeEntry = parser.map();  
}
    private static Map<String, Long> randomShardSizes(int numEntries) {
                    randomLong(),
 * Unless required by applicable law or agreed to in writing,
            String key = randomAlphaOfLength(32);
        assertEquals(clusterInfo.getNodeResourceUsageStats().toString(), result.getNodeResourceUsageStats().toString());  
        for (int i = 0; i < numEntries; i++) {  
                    randomLong(),  
import org.opensearch.common.xcontent.XContentFactory;
                ),  
        return builder;  
            builder.put(key, shardSize);  
        final Map<String, DiskUsage> builder = new HashMap<>(numEntries);
 * the Apache License, Version 2.0 (the "License"); you may
            assertNotNull(node1.get("most_available"));  
import org.opensearch.node.NodeResourceUsageStats;
            parser.nextToken();  
                randomAlphaOfLength(4),
                randomAlphaOfLength(4),
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                    randomLong(),
 * The OpenSearch Contributors require contributions made to  
        final Map<String, AggregateFileCacheStats> builder = new HashMap<>(numEntries);  
        assertEquals(clusterInfo.getNodeLeastAvailableDiskUsages(), result.getNodeLeastAvailableDiskUsages());  
 * SPDX-License-Identifier: Apache-2.0
                    randomLong(),
 * specific language governing permissions and limitations
            NodeResourceUsageStats nodeResourceUsageStats = new NodeResourceUsageStats(
            assertTrue(reservedSizeEntry.containsKey("path"));
        BytesStreamOutput output = new BytesStreamOutput();
                    randomLong(),
            String nodeId = parser.currentName();  
            // Verify node1 content
            randomRoutingToDataPath(randomIntBetween(0, 18)),  
                ),
        assertEquals(clusterInfo.reservedSpace, result.reservedSpace);
            randomReservedSpace(1),  
import org.opensearch.core.common.bytes.BytesReference;  
            builder.put(shardRouting, randomAlphaOfLength(32));
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> builder = new HashMap<>(numEntries);
import org.opensearch.core.xcontent.ToXContent;
                    randomLong(),
        );  
                randomAlphaOfLength(4),
 * this file be licensed under the Apache-2.0 license or a
            String key = randomAlphaOfLength(16);
                randomAlphaOfLength(4),  
            builder.put(key, diskUsage);
            randomFileCacheStats(1),
        final Map<ShardRouting, String> builder = new HashMap<>(numEntries);  
            DiskUsage diskUsage = new DiskUsage(  
                ShardId shardId = new ShardId(randomAlphaOfLength(32), randomAlphaOfLength(32), randomIntBetween(0, Integer.MAX_VALUE));  
                    randomLong(),
            // Verify reserved_sizes  
            assertNotNull(node1.get("least_available"));
        }
            randomRoutingToDataPath(1),
        return builder;  
            randomReservedSpace(randomIntBetween(0, 18)),
            randomDiskUsage(randomIntBetween(0, 128)),
/*  
            );  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                new FileCacheStats(  
        );
/*
                    randomLong(),
            builder.put(key, nodeResourceUsageStats);  
    public void testSerialization() throws Exception {
        assertEquals(clusterInfo.getNodeFileCacheStats().size(), result.getNodeFileCacheStats().size());
    private static Map<String, NodeResourceUsageStats> randomNodeResourceUsageStats(int numEntries) {  
    }
                    randomLong(),
import org.opensearch.cluster.routing.ShardRouting;  
                    randomLong(),
    private static Map<ShardRouting, String> randomRoutingToDataPath(int numEntries) {
                valueBuilder.add(shardId, between(0, Integer.MAX_VALUE));
                    randomLong(),  
        for (int i = 0; i < numEntries; i++) {
                    randomLong(),
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
import org.opensearch.core.xcontent.XContentBuilder;  
                    randomLong(),  
                null,  
                    randomLong(),  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 */
            String key = randomAlphaOfLength(32);  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
 * under the License.  
        final Map<String, NodeResourceUsageStats> builder = new HashMap<>(numEntries);
            Map<String, Object> shardSizesMap = parser.map();  
        }
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        ClusterInfo clusterInfo = new ClusterInfo(
            builder.put(key, valueBuilder.build());  
        ClusterInfo clusterInfo = new ClusterInfo(
    }  
                    randomLong(),  
        assertEquals(clusterInfo.getNodeMostAvailableDiskUsages(), result.getNodeMostAvailableDiskUsages());
            Map<String, Object> node1 = parser.map();
                    randomLong(),
/*
                )  
                    randomLong(),  
            randomShardSizes(randomIntBetween(0, 128)),
            // Verify shard_paths
                    randomLong(),
import org.opensearch.test.OpenSearchTestCase;  
        ClusterInfo result = new ClusterInfo(output.bytes().streamInput());
            assertEquals(XContentParser.Token.END_ARRAY, parser.nextToken());
                    randomLong(),
public class ClusterInfoTests extends OpenSearchTestCase {
        }
        builder.startObject();  
            AggregateFileCacheStats fileCacheStats = new AggregateFileCacheStats(  
                randomDoubleBetween(0, 100, false),
            randomDiskUsage(randomIntBetween(0, 128)),  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.index.shard.ShardId;
                new FileCacheStats(
            Map<String, Object> shardPathsMap = parser.map();
 * this work for additional information regarding copyright
 * GitHub history for details.
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
                    FileCacheStatsType.FULL_FILE_STATS
 * software distributed under the License is distributed on an
    private static Map<String, DiskUsage> randomDiskUsage(int numEntries) {
 * Modifications Copyright OpenSearch Contributors. See  
                    randomLong(),
                    randomLong(),  
        final Map<String, Long> builder = new HashMap<>(numEntries);
            randomDiskUsage(1),  
                randomDoubleBetween(0, 100, false),
            long totalBytes = randomIntBetween(0, Integer.MAX_VALUE);
 *
                    randomLong(),
 *  
            long shardSize = randomIntBetween(0, Integer.MAX_VALUE);
        clusterInfo.writeTo(output);  
                randomDoubleBetween(0, 100, false)
import org.opensearch.common.xcontent.json.JsonXContent;
                    randomLong(),
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;  
            assertNotNull(node1.get("node_resource_usage_stats"));
                    randomLong(),
                randomLongBetween(0, totalBytes)
    private static Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> randomReservedSpace(int numEntries) {  
        XContentBuilder builder = XContentFactory.jsonBuilder();
                    FileCacheStatsType.BLOCK_FILE_STATS  
        for (int i = 0; i < numEntries; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 */  
import org.opensearch.cluster.routing.ShardRoutingState;
            parser.nextToken();  
                    randomLong(),
                    FileCacheStatsType.OVER_ALL_STATS
            ShardRouting shardRouting = TestShardRouting.newShardRouting(shardId, null, randomBoolean(), ShardRoutingState.UNASSIGNED);  
            assertTrue(reservedSizeEntry.containsKey("node_id"));
        assertEquals(clusterInfo.shardSizes, result.shardSizes);
            randomFileCacheStats(randomIntBetween(0, 18)),
                    randomLong(),  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());  
                    randomLong(),
            ShardId shardId = new ShardId(randomAlphaOfLength(32), randomAlphaOfLength(32), randomIntBetween(0, Integer.MAX_VALUE));
        clusterInfo.toXContent(builder, ToXContent.EMPTY_PARAMS);
            // Verify shard_sizes
            randomNodeResourceUsageStats(1)
            parser.nextToken();  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            );
            assertEquals("shard_paths", parser.currentName());  
            String key = randomAlphaOfLength(32);
    }
            randomNodeResourceUsageStats(randomIntBetween(0, 20))  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            randomShardSizes(1),
                    FileCacheStatsType.PINNED_FILE_STATS
import java.util.HashMap;
                    randomLong(),  
            );
package org.opensearch.cluster;
 * compatible open source license.
            final ClusterInfo.ReservedSpace.Builder valueBuilder = new ClusterInfo.ReservedSpace.Builder();
            assertEquals(XContentParser.Token.START_ARRAY, parser.nextToken());
                    randomLong(),  
            assertEquals("reserved_sizes", parser.currentName());
            for (int j = between(0, 10); j > 0; j--) {
                    randomLong(),  
        return builder;
    }
