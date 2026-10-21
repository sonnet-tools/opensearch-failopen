        ShardId shard = shardsInBatch.iterator().next();
        );
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
        );
    private void fillShards(Map<ShardId, ShardAttributes> shardAttributesMap, int numberOfShards) {
import org.opensearch.cluster.routing.TestShardRouting;
    }
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.EMPTY)));
        Map<DiscoveryNode, NodeGatewayStartedShardsBatch> fetchData = shardCache.getCacheData(
    }
    }
        this.shardCache.initData(node2);
        assertEquals(10, batchInfo.size());
                .containsKey(shard)
                    shardData.put(shard, null);
        this.shardCache.initData(node2);
        assertEquals("alloc-1", fetchData.get(node1).getNodeGatewayStartedShardsBatch().get(shard).allocationId());
 * SPDX-License-Identifier: Apache-2.0
            );
                    new GatewayStartedShard("alloc-" + allocationId++, false, null, new OpenSearchRejectedExecutionException())
            new GatewayStartedShard(null, false, null, null),
import org.opensearch.gateway.TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch;
            "BatchID=[" + batchId + "]",
    private AsyncShardBatchFetch.ShardBatchCache<NodeGatewayStartedShardsBatch, GatewayStartedShard> shardCache;
/*
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.EMPTY)));
        this.shardCache.initData(node1);
        this.shardCache.initData(node2);
    }
                    shardData.put(shard, new GatewayStartedShard("alloc-" + allocationId++, false, null, null));
        assertTrue(
                default:
        }
    }
                .getNodeGatewayStartedShardsBatch()
                .containsKey(shard)
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
        assertEquals(10, fetchData.get(node1).getNodeGatewayStartedShardsBatch().size());
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertTrue(shardCache.getData(node1).getNodeGatewayStartedShardsBatch().isEmpty());
                .getNodeGatewayStartedShardsBatch()
        for (ShardId shard : shards) {
 * this file be licensed under the Apache-2.0 license or a
    private static final String BATCH_ID = "b1";
            state != ShardRoutingState.UNASSIGNED && randomBoolean(),
            }
            new ShardBatchResponseFactory<>(true),
    private enum ResponseType {
    private final DiscoveryNode node2 = newNode("node2");
    private final Map<ShardId, ShardsBatchGatewayAllocator.ShardEntry> batchInfo = new HashMap<>();
        ShardId shard = shardsInBatch.iterator().next();
        );
        // test getData without fetch
        this.shardCache.initData(node1);
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
            shard,
 * compatible open source license.
                case EMPTY:
    private List<ShardId> shardsInBatch = new ArrayList<>();
                .get(node1)
            if (failedShardsCount-- > 0) {
        return shardData;
                .get(node1)
    }
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
            }
    }
        ShardRoutingState state = randomFrom(ShardRoutingState.values());
        this.shardCache.initData(node2);
                );
            this.shardCache.getCacheData(DiscoveryNodes.builder().add(node2).build(), null)
        Map<ShardId, ShardAttributes> shardAttributesMap = new HashMap<>();
        assertEquals(2, fetchData.size());
    public void testClearShardCache() {
        for (ShardId shardId : shardsInBatch) {
        Map<DiscoveryNode, NodeGatewayStartedShardsBatch> fetchData = shardCache.getCacheData(
import java.util.HashMap;
        this.shardCache.initData(node1);
                    shardData.put(shard, new GatewayStartedShard(null, false, null, null));
        FAILURE,
    public void testInitCacheData() {
            null
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
import java.util.List;
            DiscoveryNodes.builder().add(node1).build(),
                    throw new AssertionError("unknown response type");
    public void testNullResponses() {
                shardData.put(shard, new GatewayStartedShard("alloc-" + allocationId++, false, null, null));
    public void testPutData() {
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
    private static final int NUMBER_OF_SHARDS_DEFAULT = 10;
        this.shardCache = new AsyncShardBatchFetch.ShardBatchCache<>(
            batchInfo.put(
                new ShardsBatchGatewayAllocator.ShardEntry(attr, randomShardRouting(shardId.getIndexName(), shardId.id()))
}
                    break;
    private Map<ShardId, GatewayStartedShard> getPrimaryResponse(List<ShardId> shards, ResponseType responseType) {
        assertFalse(this.shardCache.getCache().get(node2.getId()).isFetching());
        );
        fillShards(shardAttributesMap, numberOfShards);
 *
            shardAttributesMap,
        assertFalse(
        // assert that fetching is done as both node's responses are stored in cache
            DiscoveryNodes.builder().add(node1).add(node2).build(),
        assertTrue(fetchData.get(node1).getNodeGatewayStartedShardsBatch().isEmpty());
        Map<DiscoveryNode, NodeGatewayStartedShardsBatch> fetchData = shardCache.getCacheData(
        assertTrue(
        shardsInBatch = BatchTestUtil.setUpShards(numberOfShards);
        this.shardCache.markAsFetching(List.of(node1.getId()), 1);
    }
public class ShardBatchCacheTests extends OpenSearchAllocationTestCase {
                .containsKey(shard)
        assertEquals(10, fetchData.get(node1).getNodeGatewayStartedShardsBatch().size());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import org.opensearch.cluster.node.DiscoveryNodes;
    public void testShardsDataWithException() {
    private Map<ShardId, GatewayStartedShard> getFailedPrimaryResponse(List<ShardId> shards, int failedShardsCount) {
            this.shardCache.getCacheData(DiscoveryNodes.builder().add(node1).build(), null)
        int allocationId = 1;
    }
            state == ShardRoutingState.UNASSIGNED ? null : "1",
        this.shardCache.putData(node2, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.EMPTY)));
        VALID
            state == ShardRoutingState.RELOCATING ? "2" : null,
        assertTrue(
                    break;
        );
                case NULL:
    public void testGetCacheData() {
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.indices.store.ShardAttributes;
        this.shardCache.initData(node1);
            ShardAttributes attr = new ShardAttributes("");
        }
        assertEquals(10, shardCache.getData(node1).getNodeGatewayStartedShardsBatch().size());
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getFailedPrimaryResponse(shardsInBatch, 5)));
        );
            this.shardCache.getCacheData(DiscoveryNodes.builder().add(node1).build(), null)
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.NULL)));
            "batch_shards_started",
            this.shardCache.getCacheData(DiscoveryNodes.builder().add(node1).build(), null)
            index,
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
        this.shardCache.markAsFetching(List.of(node1.getId(), node2.getId()), 1);
                .isEmpty()
        this.shardCache.deleteShard(shard);
        assertEquals(2, fetchData.size());
        Map<ShardId, GatewayStartedShard> shardData = new HashMap<>();
 */
        int allocationId = 1;
        assertEquals(2, shardCache.getCache().size());
        assertTrue(GatewayStartedShard.isEmpty(fetchData.get(node2).getNodeGatewayStartedShardsBatch().get(shard)));
                    shard,
    private final DiscoveryNode node1 = newNode("node1");
        return TestShardRouting.newShardRouting(
        // test GetData after fetch
        assertFalse(this.shardCache.getCache().get(node1.getId()).isFetching());
        this.shardCache.initData(node1);
        ShardId shard = shardsInBatch.iterator().next();
            state
        );
                case VALID:
                shardData.put(
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.VALID)));
            null
            null
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
        assertEquals(10, fetchData.get(node2).getNodeGatewayStartedShardsBatch().size());
    }
            shardAttributesMap.put(shardId, attr);
    }
                .get(node2)
        EMPTY,
import org.opensearch.core.index.shard.ShardId;
        this.shardCache.initData(node1);
                .get(node1)
        this.shardCache.markAsFetching(List.of(node1.getId()), 1);
            switch (responseType) {
        NULL,
    }
                .getNodeGatewayStartedShardsBatch()
        );
        this.shardCache.markAsFetching(List.of(node1.getId(), node2.getId()), 1);
import java.util.ArrayList;
            GatewayStartedShard::isEmpty,
        );
        assertTrue(fetchData.get(node2).getNodeGatewayStartedShardsBatch().isEmpty());
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
import java.util.Map;
 * The OpenSearch Contributors require contributions made to
            DiscoveryNodes.builder().add(node1).add(node2).build(),
        Map<ShardId, GatewayStartedShard> shardData = new HashMap<>();
        this.shardCache.markAsFetching(List.of(node1.getId(), node2.getId()), 1);
    private ShardRouting randomShardRouting(String index, int shard) {
import org.opensearch.cluster.routing.ShardRoutingState;
        // test empty and non-empty responses
                shardId,
                    break;
        for (ShardId shard : shards) {
package org.opensearch.gateway;
        }
                .getNodeGatewayStartedShardsBatch()
            GatewayStartedShard.class,
        return shardData;
            logger,
            } else {
import org.opensearch.cluster.ClusterManagerMetrics;
    public void setupShardBatchCache(String batchId, int numberOfShards) {
