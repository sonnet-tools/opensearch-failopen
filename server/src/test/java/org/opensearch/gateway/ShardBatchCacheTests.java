        }  
        );  
    }  
        this.shardCache.markAsFetching(List.of(node1.getId(), node2.getId()), 1);  
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
        for (ShardId shard : shards) {
        this.shardCache.markAsFetching(List.of(node1.getId()), 1);
    private final DiscoveryNode node2 = newNode("node2");
    public void setupShardBatchCache(String batchId, int numberOfShards) {  
        );
                .containsKey(shard)  
            DiscoveryNodes.builder().add(node1).add(node2).build(),
        // assert that fetching is done as both node's responses are stored in cache  
                    break;
    public void testNullResponses() {
package org.opensearch.gateway;
        VALID  
            ShardAttributes attr = new ShardAttributes("");
            shardAttributesMap,  
        this.shardCache.initData(node1);  
                );  
            "batch_shards_started",
    }  
        fillShards(shardAttributesMap, numberOfShards);
        this.shardCache.putData(node2, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.EMPTY)));
import java.util.Map;  
            if (failedShardsCount-- > 0) {
            this.shardCache.getCacheData(DiscoveryNodes.builder().add(node1).build(), null)  
import org.opensearch.cluster.node.DiscoveryNode;  
        Map<DiscoveryNode, NodeGatewayStartedShardsBatch> fetchData = shardCache.getCacheData(
        this.shardCache.deleteShard(shard);
            batchInfo.put(
import java.util.ArrayList;  
import org.opensearch.gateway.TransportNodesGatewayStartedShardHelper.GatewayStartedShard;
    private ShardRouting randomShardRouting(String index, int shard) {
        for (ShardId shardId : shardsInBatch) {
            this.shardCache.getCacheData(DiscoveryNodes.builder().add(node1).build(), null)
import org.opensearch.indices.store.ShardAttributes;  
                shardData.put(  
        assertTrue(GatewayStartedShard.isEmpty(fetchData.get(node2).getNodeGatewayStartedShardsBatch().get(shard)));
            }
        ShardId shard = shardsInBatch.iterator().next();  
            switch (responseType) {
            shard,  
            }  
            "BatchID=[" + batchId + "]",
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
    private Map<ShardId, GatewayStartedShard> getFailedPrimaryResponse(List<ShardId> shards, int failedShardsCount) {
                .get(node1)
            new ShardBatchResponseFactory<>(true),
        );
                    break;
        Map<DiscoveryNode, NodeGatewayStartedShardsBatch> fetchData = shardCache.getCacheData(
        return shardData;
        // test empty and non-empty responses  
        assertTrue(shardCache.getData(node1).getNodeGatewayStartedShardsBatch().isEmpty());
            new GatewayStartedShard(null, false, null, null),  
import org.opensearch.core.index.shard.ShardId;  
    }  
 * compatible open source license.
            state == ShardRoutingState.RELOCATING ? "2" : null,
        Map<ShardId, GatewayStartedShard> shardData = new HashMap<>();  
            state == ShardRoutingState.UNASSIGNED ? null : "1",
        // test getData without fetch
import java.util.List;
    }
        this.shardCache.initData(node1);
        FAILURE,
        this.shardCache.initData(node1);
        assertTrue(
        assertEquals(2, fetchData.size());
    private static final int NUMBER_OF_SHARDS_DEFAULT = 10;  
            state != ShardRoutingState.UNASSIGNED && randomBoolean(),  
                    shard,
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
            );
        );
        );
import org.opensearch.gateway.TransportNodesListGatewayStartedShardsBatch.NodeGatewayStartedShardsBatch;
    private List<ShardId> shardsInBatch = new ArrayList<>();
        Map<DiscoveryNode, NodeGatewayStartedShardsBatch> fetchData = shardCache.getCacheData(
        );
    }  
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.EMPTY)));  
    }
 * The OpenSearch Contributors require contributions made to  
                    shardData.put(shard, null);
        this.shardCache.markAsFetching(List.of(node1.getId(), node2.getId()), 1);  
    private void fillShards(Map<ShardId, ShardAttributes> shardAttributesMap, int numberOfShards) {
        );
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.EMPTY)));
}
    private Map<ShardId, GatewayStartedShard> getPrimaryResponse(List<ShardId> shards, ResponseType responseType) {
                .isEmpty()  
                    shardData.put(shard, new GatewayStartedShard(null, false, null, null));
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
        assertEquals(2, shardCache.getCache().size());
        this.shardCache.markAsFetching(List.of(node1.getId()), 1);
import org.opensearch.cluster.routing.TestShardRouting;
        this.shardCache = new AsyncShardBatchFetch.ShardBatchCache<>(  
        this.shardCache.markAsFetching(List.of(node1.getId(), node2.getId()), 1);
        assertEquals(2, fetchData.size());
        }
import org.opensearch.cluster.routing.ShardRoutingState;  
        assertEquals(10, fetchData.get(node2).getNodeGatewayStartedShardsBatch().size());  
import org.opensearch.cluster.ClusterManagerMetrics;
import org.opensearch.cluster.node.DiscoveryNodes;
    private static final String BATCH_ID = "b1";  
        this.shardCache.initData(node2);
        assertFalse(this.shardCache.getCache().get(node2.getId()).isFetching());
            logger,
        this.shardCache.initData(node1);  
    public void testClearShardCache() {
        );
            DiscoveryNodes.builder().add(node1).build(),
                .get(node2)
    }
                case EMPTY:  
        ShardId shard = shardsInBatch.iterator().next();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            DiscoveryNodes.builder().add(node1).add(node2).build(),  
                .getNodeGatewayStartedShardsBatch()
        }
            index,
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
        this.shardCache.initData(node1);  
                    shardData.put(shard, new GatewayStartedShard("alloc-" + allocationId++, false, null, null));
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)  
            } else {
            null  
    }
        // test GetData after fetch  
                    new GatewayStartedShard("alloc-" + allocationId++, false, null, new OpenSearchRejectedExecutionException())
                    break;
                .get(node1)
    }
                new ShardsBatchGatewayAllocator.ShardEntry(attr, randomShardRouting(shardId.getIndexName(), shardId.id()))  
        int allocationId = 1;
        this.shardCache.initData(node1);
        assertTrue(
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.VALID)));  
                .getNodeGatewayStartedShardsBatch()
        for (ShardId shard : shards) {
            GatewayStartedShard.class,
    public void testGetCacheData() {
                .containsKey(shard)  
            this.shardCache.getCacheData(DiscoveryNodes.builder().add(node1).build(), null)  
        assertFalse(this.shardCache.getCache().get(node1.getId()).isFetching());
        assertFalse(
            null  
 */  
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);  
        return TestShardRouting.newShardRouting(
        assertEquals("alloc-1", fetchData.get(node1).getNodeGatewayStartedShardsBatch().get(shard).allocationId());
        ShardId shard = shardsInBatch.iterator().next();  
            state
        assertTrue(fetchData.get(node2).getNodeGatewayStartedShardsBatch().isEmpty());
 * SPDX-License-Identifier: Apache-2.0
        );
        EMPTY,
                .containsKey(shard)
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getPrimaryResponse(shardsInBatch, ResponseType.NULL)));
        assertTrue(
    private final DiscoveryNode node1 = newNode("node1");
        assertTrue(fetchData.get(node1).getNodeGatewayStartedShardsBatch().isEmpty());
    public void testInitCacheData() {
        this.shardCache.putData(node1, new NodeGatewayStartedShardsBatch(node1, getFailedPrimaryResponse(shardsInBatch, 5)));
                shardData.put(shard, new GatewayStartedShard("alloc-" + allocationId++, false, null, null));
        assertEquals(10, fetchData.get(node1).getNodeGatewayStartedShardsBatch().size());  
    private final Map<ShardId, ShardsBatchGatewayAllocator.ShardEntry> batchInfo = new HashMap<>();  
    public void testShardsDataWithException() {
        assertEquals(10, fetchData.get(node1).getNodeGatewayStartedShardsBatch().size());  
                .getNodeGatewayStartedShardsBatch()
        this.shardCache.initData(node2);
import java.util.HashMap;
        Map<ShardId, GatewayStartedShard> shardData = new HashMap<>();  
        assertEquals(10, batchInfo.size());
        NULL,  
/*  
    }  
public class ShardBatchCacheTests extends OpenSearchAllocationTestCase {
                default:  
    }
    private AsyncShardBatchFetch.ShardBatchCache<NodeGatewayStartedShardsBatch, GatewayStartedShard> shardCache;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        return shardData;
                .get(node1)  
                case VALID:  
        ShardRoutingState state = randomFrom(ShardRoutingState.values());  
    }
        this.shardCache.initData(node2);
            null
                shardId,
                .getNodeGatewayStartedShardsBatch()
                    throw new AssertionError("unknown response type");
        Map<ShardId, ShardAttributes> shardAttributesMap = new HashMap<>();
            GatewayStartedShard::isEmpty,
        assertEquals(10, shardCache.getData(node1).getNodeGatewayStartedShardsBatch().size());
    public void testPutData() {
        int allocationId = 1;
            this.shardCache.getCacheData(DiscoveryNodes.builder().add(node2).build(), null)  
        this.shardCache.initData(node2);
                case NULL:  
import org.opensearch.cluster.routing.ShardRouting;
 *
    private enum ResponseType {
            shardAttributesMap.put(shardId, attr);  
        setupShardBatchCache(BATCH_ID, NUMBER_OF_SHARDS_DEFAULT);
 * this file be licensed under the Apache-2.0 license or a
        shardsInBatch = BatchTestUtil.setUpShards(numberOfShards);  
