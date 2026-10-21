            int numShards = randomIntBetween(1, 5);
package org.opensearch.action.admin.indices.shards;
            for (int shardId = 0; shardId < numShards; shardId++) {
import org.opensearch.core.common.transport.TransportAddress;
            }
            try (StreamInput in = out.bytes().streamInput()) {
import org.opensearch.Version;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    public void testSerialization() throws IOException {
        return new Index(indexName, UUIDs.base64UUID());
        assertEquals(indicesStatsResponse, catShardsResponse.getIndicesStatsResponse());
import org.opensearch.cluster.routing.TestShardRouting;
import java.net.UnknownHostException;
    private IndicesStatsResponse getIndicesStatsResponse() {
            try (StreamInput in = out.bytes().streamInput()) {
                        .seqNoStats(null)
    private final CatShardsResponse catShardsResponse = new CatShardsResponse();
 * under the License.
    }
        catShardsResponse.setIndicesStatsResponse(indicesStatsResponse);
        catShardsResponse.setNodes(discoveryNodes);
            }
        response.setIndicesStatsResponse(getIndicesStatsResponse());
        Version version = Version.CURRENT;
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
import java.net.InetAddress;
                assertNotNull(deserialized.getIndicesStatsResponse());
    }
            out.setVersion(version);
                    response.getIndicesStatsResponse().getShards().length,
                ShardRouting routing = createShardRouting(shId, (shardId == 0));
        Version version = Version.CURRENT;
import java.util.ArrayList;
                        .shardPath(shardPath)
 * You may obtain a copy of the License at
                        .pollingIngestStats(null)
                assertNotNull(deserialized.getNodes());
import org.opensearch.cluster.node.DiscoveryNode;
                CatShardsResponse deserialized = new CatShardsResponse(in);
 * KIND, either express or implied.  See the License for the
        CatShardsResponse response = new CatShardsResponse();
    }
        InetAddress inetAddress = InetAddress.getByAddress(new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
            response.writeTo(out);
        List<ShardStats> shards = new ArrayList<>();
                );
 * license agreements. See the NOTICE file distributed with
                assertTrue(deserialized.getResponseShards().isEmpty());
                in.setVersion(version);
    }
        }
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
                        .commitStats(null)
import org.opensearch.action.admin.indices.stats.ShardStats;
    public void testGetAndSetNodes() {
                assertEquals(
import org.opensearch.common.UUIDs;
 * this work for additional information regarding copyright
import java.util.List;
                assertEquals(response.getPageToken(), deserialized.getPageToken());
                assertTrue(deserialized.getResponseShards().isEmpty());
            Index index = createIndex(randomAlphaOfLength(9));
import java.nio.file.Path;
                assertNotNull(deserialized.getNodes().getNodes().get(TEST_NODE_ID));
                assertEquals(
 */
                ShardPath shardPath = new ShardPath(false, path, path, shId);
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            response.writeTo(out);
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(discoveryNodes, catShardsResponse.getNodes());
 */
        response.setNodes(getDiscoveryNodes());
                assertEquals(response.getPageToken(), deserialized.getPageToken());
    public void testGetAndSetIndicesStatsResponse() {
        response.setPageToken(new PageToken("token", "test"));
import org.opensearch.core.index.Index;
                    deserialized.getIndicesStatsResponse().getShards().length
    }
import org.opensearch.core.index.shard.ShardId;
                assertNotNull(deserialized.getNodes());
 */
        CatShardsResponse response = new CatShardsResponse();
        DiscoveryNodes.Builder dnBuilder = new DiscoveryNodes.Builder();
        int noOfIndexes = randomIntBetween(2, 5);
 * this file be licensed under the Apache-2.0 license or a
    private DiscoveryNodes getDiscoveryNodes() throws UnknownHostException {
                Path path = createTempDir().resolve("indices").resolve(index.getUUID()).resolve(String.valueOf(shardId));
 * ownership. Elasticsearch licenses this file to you under
                    deserialized.getIndicesStatsResponse().getShards().length
        return new IndicesStatsResponse(shards.toArray(new ShardStats[0]), 0, 0, 0, null);
                assertEquals(1, deserialized.getNodes().getNodes().size());
/*
import java.io.IOException;
}
            out.setVersion(version);
    }
                ShardId shId = new ShardId(index, shardId);
    private Index createIndex(String indexName) {
 *
                assertEquals(1, deserialized.getNodes().getNodes().size());
                CatShardsResponse deserialized = new CatShardsResponse(in);
 *
import org.opensearch.cluster.routing.ShardRoutingState;
                );
                    new ShardStats.Builder().shardRouting(routing)
 * the Apache License, Version 2.0 (the "License"); you may
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * software distributed under the License is distributed on an
    public void testSerializationWithOnlyStatsAndNodesInResponse() throws IOException {
 * GitHub history for details.
    private static final String TEST_NODE_ID = "test_node_id";
        response.setIndicesStatsResponse(getIndicesStatsResponse());
        return dnBuilder.build();
public class CatShardsResponseTests extends OpenSearchTestCase {
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
/*
        }
                        .retentionLeaseStats(null)
 * not use this file except in compliance with the License.
import static java.util.Collections.emptySet;
        dnBuilder.add(new DiscoveryNode(TEST_NODE_ID, TEST_NODE_ID, transportAddress, emptyMap(), emptySet(), Version.CURRENT));
                        .commonStats(new CommonStats())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                in.setVersion(version);
        return TestShardRouting.newShardRouting(shardId, randomAlphaOfLength(4), isPrimary, ShardRoutingState.STARTED);
                    response.getIndicesStatsResponse().getShards().length,
 * Modifications Copyright OpenSearch Contributors. See
/*
import org.opensearch.action.admin.indices.stats.CommonStats;
import org.opensearch.core.common.io.stream.StreamInput;
                assertNotNull(deserialized.getNodes().getNodes().get(TEST_NODE_ID));
import static org.mockito.Mockito.mock;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.test.OpenSearchTestCase;
        response.setNodes(getDiscoveryNodes());
 * The OpenSearch Contributors require contributions made to
            }
import static java.util.Collections.emptyMap;
import org.opensearch.action.admin.cluster.shards.CatShardsResponse;
    }
import org.opensearch.index.shard.ShardPath;
        for (int indCnt = 0; indCnt < noOfIndexes; indCnt++) {
import org.opensearch.cluster.node.DiscoveryNodes;
        DiscoveryNodes discoveryNodes = mock(DiscoveryNodes.class);
    private ShardRouting createShardRouting(ShardId shardId, boolean isPrimary) {
                );
 *
                shards.add(
                        .build()
import org.opensearch.action.pagination.PageToken;
        final IndicesStatsResponse indicesStatsResponse = new IndicesStatsResponse(null, 0, 0, 0, null);
        }
import org.opensearch.cluster.routing.ShardRouting;
                assertNotNull(deserialized.getIndicesStatsResponse());
