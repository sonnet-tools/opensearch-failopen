import org.opensearch.core.common.transport.TransportAddress;  
 * Unless required by applicable law or agreed to in writing,
    private final CatShardsResponse catShardsResponse = new CatShardsResponse();
import org.opensearch.cluster.routing.ShardRouting;  
        }  
 * KIND, either express or implied.  See the License for the
/*
                    deserialized.getIndicesStatsResponse().getShards().length  
    private DiscoveryNodes getDiscoveryNodes() throws UnknownHostException {
import org.opensearch.index.shard.ShardPath;  
                assertTrue(deserialized.getResponseShards().isEmpty());
 *
 */  
import java.net.UnknownHostException;
                    response.getIndicesStatsResponse().getShards().length,
                        .commonStats(new CommonStats())
            out.setVersion(version);  
        dnBuilder.add(new DiscoveryNode(TEST_NODE_ID, TEST_NODE_ID, transportAddress, emptyMap(), emptySet(), Version.CURRENT));  
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertNotNull(deserialized.getNodes().getNodes().get(TEST_NODE_ID));
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
 *  
    public void testSerialization() throws IOException {
            int numShards = randomIntBetween(1, 5);
                        .retentionLeaseStats(null)
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        TransportAddress transportAddress = new TransportAddress(inetAddress, randomIntBetween(0, 65535));
 * this work for additional information regarding copyright
 * under the License.  
                    deserialized.getIndicesStatsResponse().getShards().length
import org.opensearch.cluster.node.DiscoveryNode;
                assertNotNull(deserialized.getIndicesStatsResponse());
    private Index createIndex(String indexName) {
                assertTrue(deserialized.getResponseShards().isEmpty());  
        return new Index(indexName, UUIDs.base64UUID());  
                        .pollingIngestStats(null)
            try (StreamInput in = out.bytes().streamInput()) {
    }
        int noOfIndexes = randomIntBetween(2, 5);  
        }
        final IndicesStatsResponse indicesStatsResponse = new IndicesStatsResponse(null, 0, 0, 0, null);
import org.opensearch.action.admin.indices.stats.CommonStats;  
    private IndicesStatsResponse getIndicesStatsResponse() {
            response.writeTo(out);
        return dnBuilder.build();
                );
        CatShardsResponse response = new CatShardsResponse();  
    }  
            Index index = createIndex(randomAlphaOfLength(9));  
 */
            }
 * Modifications Copyright OpenSearch Contributors. See
                    new ShardStats.Builder().shardRouting(routing)
public class CatShardsResponseTests extends OpenSearchTestCase {
import org.opensearch.Version;
            out.setVersion(version);
        DiscoveryNodes discoveryNodes = mock(DiscoveryNodes.class);
import org.opensearch.cluster.node.DiscoveryNodes;
                assertNotNull(deserialized.getNodes().getNodes().get(TEST_NODE_ID));  
                assertEquals(response.getPageToken(), deserialized.getPageToken());  
import java.io.IOException;  
import org.opensearch.action.pagination.PageToken;  
import org.opensearch.core.common.io.stream.StreamInput;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
            }
    }
            try (StreamInput in = out.bytes().streamInput()) {  
 * You may obtain a copy of the License at  
        catShardsResponse.setNodes(discoveryNodes);  
        Version version = Version.CURRENT;
        response.setNodes(getDiscoveryNodes());
 * ownership. Elasticsearch licenses this file to you under  
        CatShardsResponse response = new CatShardsResponse();
        response.setNodes(getDiscoveryNodes());
import org.opensearch.core.index.shard.ShardId;
                        .seqNoStats(null)  
 */  
import org.opensearch.action.admin.indices.stats.ShardStats;
        Version version = Version.CURRENT;
        for (int indCnt = 0; indCnt < noOfIndexes; indCnt++) {
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertNotNull(deserialized.getNodes());  
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        List<ShardStats> shards = new ArrayList<>();
    private ShardRouting createShardRouting(ShardId shardId, boolean isPrimary) {
import org.opensearch.common.UUIDs;  
        catShardsResponse.setIndicesStatsResponse(indicesStatsResponse);  
import java.nio.file.Path;  
 * Licensed to Elasticsearch under one or more contributor  
            for (int shardId = 0; shardId < numShards; shardId++) {
        assertEquals(discoveryNodes, catShardsResponse.getNodes());
                ShardId shId = new ShardId(index, shardId);  
        assertEquals(indicesStatsResponse, catShardsResponse.getIndicesStatsResponse());
        }
                assertEquals(
            }  
        return new IndicesStatsResponse(shards.toArray(new ShardStats[0]), 0, 0, 0, null);
                assertEquals(1, deserialized.getNodes().getNodes().size());
        response.setIndicesStatsResponse(getIndicesStatsResponse());
 * GitHub history for details.
                CatShardsResponse deserialized = new CatShardsResponse(in);
import java.net.InetAddress;
    }
import org.opensearch.cluster.routing.ShardRoutingState;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.TestShardRouting;
import org.opensearch.test.OpenSearchTestCase;
import java.util.ArrayList;
 *
                in.setVersion(version);  
                ShardPath shardPath = new ShardPath(false, path, path, shId);
 * SPDX-License-Identifier: Apache-2.0
    }  
                assertEquals(response.getPageToken(), deserialized.getPageToken());
                ShardRouting routing = createShardRouting(shId, (shardId == 0));  
                assertEquals(1, deserialized.getNodes().getNodes().size());
package org.opensearch.action.admin.indices.shards;
                        .shardPath(shardPath)  
import org.opensearch.action.admin.cluster.shards.CatShardsResponse;
 * The OpenSearch Contributors require contributions made to  
                Path path = createTempDir().resolve("indices").resolve(index.getUUID()).resolve(String.valueOf(shardId));
                        .build()  
                        .commitStats(null)
                shards.add(
                CatShardsResponse deserialized = new CatShardsResponse(in);
        response.setIndicesStatsResponse(getIndicesStatsResponse());  
}
                );
import static org.mockito.Mockito.mock;  
import static java.util.Collections.emptyMap;
    public void testSerializationWithOnlyStatsAndNodesInResponse() throws IOException {
 * software distributed under the License is distributed on an
        DiscoveryNodes.Builder dnBuilder = new DiscoveryNodes.Builder();  
                    response.getIndicesStatsResponse().getShards().length,  
    public void testGetAndSetNodes() {
    }
/*  
                assertNotNull(deserialized.getIndicesStatsResponse());  
                );
                in.setVersion(version);
                assertNotNull(deserialized.getNodes());
import static java.util.Collections.emptySet;
/*  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * compatible open source license.
    }
        return TestShardRouting.newShardRouting(shardId, randomAlphaOfLength(4), isPrimary, ShardRoutingState.STARTED);
        InetAddress inetAddress = InetAddress.getByAddress(new byte[] { (byte) 192, (byte) 168, (byte) 0, (byte) 1 });
        response.setPageToken(new PageToken("token", "test"));  
    private static final String TEST_NODE_ID = "test_node_id";
import org.opensearch.core.index.Index;
    public void testGetAndSetIndicesStatsResponse() {
            response.writeTo(out);
                assertEquals(
 * not use this file except in compliance with the License.
