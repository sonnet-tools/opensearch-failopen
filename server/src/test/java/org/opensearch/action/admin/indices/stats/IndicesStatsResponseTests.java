                    primaryCount++;
import org.opensearch.cluster.routing.ShardRouting;
 *  
 */
import org.opensearch.core.xcontent.ToXContent;
 * this file be licensed under the Apache-2.0 license or a
                    k -> new AtomicLong(0L)  
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (String index : indexStats.keySet()) {  
        }  
 * Unless required by applicable law or agreed to in writing,
public class IndicesStatsResponseTests extends OpenSearchTestCase {
import java.util.List;
        return new Index(indexName, UUIDs.base64UUID());
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.common.xcontent.json.JsonXContent;
        }
        Map<String, AtomicLong> expectedIndexToPrimaryShardsCount = new HashMap<>();  
/*  
            IndexStats stat = indexStats.get(index);
                        .shardPath(shardPath)
                ShardRouting routing = createShardRouting(index, shId, (shardId == 0));
        List<ShardStats> shards = new ArrayList<>();  
import static org.hamcrest.Matchers.is;
import org.opensearch.test.OpenSearchTestCase;
 */  
            for (int shardId = 0; shardId < numShards; shardId++) {
import java.util.HashMap;  
        final IllegalArgumentException e = expectThrows(
    }
            expectedIndexes.add(index.getName());
 * ownership. Elasticsearch licenses this file to you under  
    public void testInvalidLevel() {  
                    index.getName(),
import org.opensearch.core.index.Index;  
import java.util.Collections;
import java.util.ArrayList;
                        .pollingIngestStats(null)
            for (ShardStats shardStat : shardStats) {
    }  
        final String level = randomAlphaOfLength(16);
 * software distributed under the License is distributed on an
                AtomicLong shardsCounter = expectedIndexToTotalShardsCount.computeIfAbsent(index.getName(), k -> new AtomicLong(0L));
        );
                if (shardStat.getShardRouting().primary()) {  
import java.nio.file.Path;  
            assertThat(totalCount, is(expectedIndexToTotalShardsCount.get(index).get()));
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
package org.opensearch.action.admin.indices.stats;
    }  
import static org.hamcrest.CoreMatchers.containsString;
        assertThat(indexStats.size(), is(noOfIndexes));  
            long primaryCount = 0L;  
 * the Apache License, Version 2.0 (the "License"); you may
 *
import org.opensearch.index.shard.ShardPath;  
            ShardStats[] shardStats = stat.getShards();
                        .retentionLeaseStats(null)  
            int numShards = randomIntBetween(1, 5);  
                ShardId shId = new ShardId(index, shardId);
                Path path = createTempDir().resolve("indices").resolve(index.getUUID()).resolve(String.valueOf(shardId));  
            }  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
                        .build()
            assertThat(primaryCount, is(expectedIndexToPrimaryShardsCount.get(index).get()));
            }
    private Index createIndex(String indexName) {
                AtomicLong primaryShardsCounter = expectedIndexToPrimaryShardsCount.computeIfAbsent(
        int noOfIndexes = randomIntBetween(2, 5);
/*
        final ToXContent.Params params = new ToXContent.MapParams(Collections.singletonMap("level", level));  
 * under the License.  
        final IndicesStatsResponse response = new IndicesStatsResponse(null, 0, 0, 0, null);
                    primaryShardsCounter.incrementAndGet();  
            long totalCount = shardStats.length;
                    new ShardStats.Builder().shardRouting(routing)
 * GitHub history for details.
 * not use this file except in compliance with the License.
import java.util.Map;
import org.opensearch.cluster.routing.TestShardRouting;  
    private ShardRouting createShardRouting(Index index, ShardId shardId, boolean isPrimary) {  
        assertThat(indexStats.keySet(), containsInAnyOrder(expectedIndexes.toArray(new String[0])));
        Map<String, AtomicLong> expectedIndexToTotalShardsCount = new HashMap<>();
                if (routing.primary()) {
import static org.hamcrest.object.HasToString.hasToString;
import org.opensearch.core.index.shard.ShardId;
            IllegalArgumentException.class,
                shards.add(  
import org.opensearch.common.UUIDs;
            e,  
        List<String> expectedIndexes = new ArrayList<>();
import java.util.concurrent.atomic.AtomicLong;  
                shardsCounter.incrementAndGet();  
 * Modifications Copyright OpenSearch Contributors. See
                );  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
                }
import static org.hamcrest.Matchers.containsInAnyOrder;  
/*  
            hasToString(containsString("level parameter must be one of [cluster] or [indices] or [shards] but was [" + level + "]"))
                        .commonStats(null)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testGetIndices() {
 */  
                );
        for (int indCnt = 0; indCnt < noOfIndexes; indCnt++) {  
}
        final IndicesStatsResponse indicesStatsResponse = new IndicesStatsResponse(shards.toArray(new ShardStats[0]), 0, 0, 0, null);  
 * Licensed to Elasticsearch under one or more contributor  
        return TestShardRouting.newShardRouting(shardId, randomAlphaOfLength(4), isPrimary, ShardRoutingState.STARTED);
        Map<String, IndexStats> indexStats = indicesStatsResponse.getIndices();
                        .commitStats(null)
    }
                        .seqNoStats(null)
                }
        assertThat(
import org.opensearch.cluster.routing.ShardRoutingState;
                ShardPath shardPath = new ShardPath(false, path, path, shId);
        );
            Index index = createIndex(randomAlphaOfLength(9));
            () -> response.toXContent(JsonXContent.contentBuilder(), params)  
 * specific language governing permissions and limitations
