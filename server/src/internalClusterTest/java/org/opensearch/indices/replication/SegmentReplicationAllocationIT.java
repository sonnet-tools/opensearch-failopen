    public void testAllocationAndRebalanceWithDisruption() throws Exception {
        final List<String> nodeNames = new ArrayList<>();
                    + 1;  
        final int nodeCount = randomIntBetween(5, 10);
                            + index
        logger.info(ShardAllocations.printShardDistribution(state));
        enablePreferPrimaryBalance();
    public void testAllocationWithDisruption() throws Exception {
import java.util.stream.Collectors;
    /**  
                        .stream()  
        final int nodeCount = randomIntBetween(maxReplicaCount + 1, 10);
        }
        for (int i = 0; i < nodeCount; i++) {
        verifyPerIndexPrimaryBalance();
        verifyPerIndexPrimaryBalance();
    }  
        verifyPrimaryBalance(buffer);
                        .filter(ShardRouting::primary)
        verifyPerIndexPrimaryBalance();
        verifyPrimaryBalance(0.0f);
        while (nodeCountToStop > 0) {
            final int avgPrimaryShardsPerNode = (int) Math.ceil(totalPrimaryShards * 1f / currentState.getRoutingNodes().size());
            client().admin()  
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE;
            for (final IndexRoutingTable index : currentState.getRoutingTable().indicesRouting().values()) {
    }
            shardCount = randomIntBetween(1, maxShardCount);  
     */
    /**
        final int maxShardCount = 50;  
        logger.info("--> Creating {} nodes", nodeCount);
        verifyPerIndexPrimaryBalance();
        final int maxShardCount = 2;
        prepareCreate(idxName, builder).get();
import org.opensearch.cluster.ClusterState;
        assertBusy(() -> {  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
     * balance per index and across all indices is maintained.
        internalCluster().startClusterManagerOnlyNode();
        }
        ensureGreen(TimeValue.timeValueSeconds(100));  
                for (RoutingNode node : nodes) {
    }
        logger.info("--> Adding {} nodes", additionalNodeCount);  
        ensureGreen(TimeValue.timeValueSeconds(100));
        internalCluster().startClusterManagerOnlyNode();
    /**
        while (nodeCountToStop > 0) {
        state = client().admin().cluster().prepareState().execute().actionGet().getState();  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
public class SegmentReplicationAllocationIT extends SegmentReplicationBaseIT {
        for (int i = 0; i < numberOfIndices; i++) {
                            + " "
            }  
        verifyPerIndexPrimaryBalance();
        verifyPrimaryBalance(buffer);  
                    - 1;
    /**
        internalCluster().startClusterManagerOnlyNode();  
     */  
        }
            }
        final int numberOfIndices = randomIntBetween(1, 3);
        ensureGreen(TimeValue.timeValueSeconds(60));  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();  
import java.util.ArrayList;
import org.opensearch.test.InternalTestCluster;
                        .size();  
                .prepareUpdateSettings()
                )
                        .put(PRIMARY_SHARD_REBALANCE_BUFFER.getKey(), buffer)
        internalCluster().startDataOnlyNode();
        }
        internalCluster().validateClusterFormed();  
        );
            builder = builder.put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);  
    }  
            final ClusterState currentState = client().admin().cluster().prepareState().execute().actionGet().getState();
        logger.info(ShardAllocations.printShardDistribution(state));  
    public void testSingleIndexShardAllocation() throws Exception {  
        internalCluster().startClusterManagerOnlyNode();
        int nodeCountToStop = additionalNodeCount;  
    public void testPerIndexPrimaryAllocation() throws Exception {
            logger.info("--> Creating index {} with shard count {} and replica count {}", "test" + i, shardCount, replicaCount);
        logger.info(ShardAllocations.printShardDistribution(state));
        for (int i = 0; i < nodeCount; i++) {
        }  
            int totalPrimaryShards = 0;  
                totalPrimaryShards += index.primaryShardsActive();
        enablePreferPrimaryBalance();
            ensureGreen(TimeValue.timeValueSeconds(60));  
                final int totalPrimaryShards = index.getValue().primaryShardsActive();
            replicaCount = shardAndReplicaCounts.get(i).get(1);  
import org.opensearch.test.OpenSearchIntegTestCase;
        final List<String> nodeNames = new ArrayList<>();  
        assertAcked(
        verifyPerIndexPrimaryBalance();
        final int additionalNodeCount = randomIntBetween(1, 5);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeNames.get(0)));
                }  
import java.util.Map;
        }
        );  
            if (logger.isTraceEnabled()) {
                        lowerBoundPrimaryShardsPerNode <= primaryCount && primaryCount <= upperBoundPrimaryShardsPerNode
    public void setAllocationRelocationStrategy(boolean preferPrimaryBalance, boolean preferPrimaryRebalance, float buffer) {
                assertTrue(primaryCount <= (avgPrimaryShardsPerNode * (1 + buffer)));
        final int numberOfIndices = randomIntBetween(5, 10);
        int nodeCountToStop = additionalNodeCount;
     */  
                            + lowerBoundPrimaryShardsPerNode
        enablePreferPrimaryBalance();  
 * SPDX-License-Identifier: Apache-2.0
     *  
        // Create a strictly higher number of nodes than the number of shards to reduce chances of SameShardAllocationDecider kicking-in
        internalCluster().validateClusterFormed();
                    .stream()
                .setPersistentSettings(  
     */
        Settings.Builder builder = Settings.builder()
     */
}  
        internalCluster().startNodes(additionalNodeCount);
        final int nodeCount = 5;
                .setPersistentSettings(Settings.builder().put(PRIMARY_SHARD_REBALANCE_BUFFER.getKey(), 0.2))  
        assertAcked(
                    .size();
    }  
            createIndex("test" + i, shardCount, replicaCount, i % 2 == 0);
        final int maxShardCount = 2;
                    .collect(Collectors.toList())  
        final int numberOfIndices = randomIntBetween(1, 10);
        final int numberOfIndices = randomIntBetween(5, 10);  
        assertBusy(() -> {
        ClusterState state;  
                            + primaryCount
        int shardCount, replicaCount;
        // and preventing primary relocations  
        logger.info(ShardAllocations.printShardDistribution(state));
        final int maxReplicaCount = 1;  
            logger.info(ShardAllocations.printShardDistribution(state));  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
 * The OpenSearch Contributors require contributions made to  
            shardCount = randomIntBetween(1, maxShardCount);
     */  
            nodeNames.add(internalCluster().startNode());
            RoutingNodes nodes = currentState.getRoutingNodes();  
package org.opensearch.indices.replication;
        logger.info(ShardAllocations.printShardDistribution(state));  
                            + " (assigned) <= "
                final int upperBoundPrimaryShardsPerNode = (int) Math.ceil(totalPrimaryShards * 1f / currentState.getRoutingNodes().size())
            replicaCount = randomIntBetween(0, maxReplicaCount);  
            ensureGreen(TimeValue.timeValueSeconds(60));  
                        .collect(Collectors.toList())
        for (int i = 0; i < numberOfIndices; i++) {
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.PRIMARY_SHARD_REBALANCE_BUFFER;  
                state = client().admin().cluster().prepareState().execute().actionGet().getState();
    public void enablePreferPrimaryBalance() {
        }, 60, TimeUnit.SECONDS);
        createIndex("test", maxShardCount, maxReplicaCount, true);
        logger.info("--> Cluster state post nodes stop {}", state);  
            shardAndReplicaCounts.add(Arrays.asList(shardCount, replicaCount));
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)  
                .cluster()
                logger.info(ShardAllocations.printShardDistribution(state));  
                    );
    /**  
            shardCount = shardAndReplicaCounts.get(i).get(0);
        );
        state = client().admin().cluster().prepareState().execute().actionGet().getState();  
    @TestLogging(reason = "Enable debug logs from cluster and index replication package", value = "org.opensearch.cluster:DEBUG,org.opensearch.indices.replication:DEBUG")
     * Similar to testSingleIndexShardAllocation test but creates multiple indices, multiple nodes adding in and getting
    private void verifyPerIndexPrimaryBalance() throws Exception {  
            ensureGreen(TimeValue.timeValueSeconds(60));
            internalCluster().stopRandomDataNode();
     * removed. The test asserts post each such event that primary shard distribution is balanced for each index as well as across the nodes
            replicaCount = randomIntBetween(1, maxReplicaCount);  
     * @throws Exception exception
    }  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
            nodeNames.add(internalCluster().startNode());  
            shardCount = randomIntBetween(1, maxShardCount);
        logger.info("--> Creating {} nodes", nodeCount);  
        } else {
                    Settings.builder()
            state = client().admin().cluster().prepareState().execute().actionGet().getState();
        for (int i = 0; i < numberOfIndices; i++) {
        logger.info(ShardAllocations.printShardDistribution(state));
 * this file be licensed under the Apache-2.0 license or a
        final int maxReplicaCount = 1;
import org.opensearch.indices.replication.common.ReplicationType;  
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.PREFER_PRIMARY_SHARD_REBALANCE;
            RoutingNodes nodes = currentState.getRoutingNodes();
        }, 60, TimeUnit.SECONDS);
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        verifyPrimaryBalance(buffer);
        final int nodeCount = randomIntBetween(maxReplicaCount + 1, 10);  
        logger.info(ShardAllocations.printShardDistribution(state));
            client().admin()  
        final List<String> nodeNames = new ArrayList<>();  
            nodeNames.add(internalCluster().startNode());  
import org.opensearch.cluster.OpenSearchAllocationTestCase.ShardAllocations;
        verifyPerIndexPrimaryBalance();
        // and preventing primary relocations
        logger.info("--> Cluster state post nodes stop {}", state);
        }
            shardCount = randomIntBetween(1, maxShardCount);
        ClusterState state;  
        verifyPerIndexPrimaryBalance();
import org.opensearch.index.IndexModule;
        ensureGreen(TimeValue.timeValueSeconds(60));
        for (int i = 0; i < nodeCount; i++) {
                    assertTrue(
            }  
                .prepareUpdateSettings()
        internalCluster().startClusterManagerOnlyNode();
        final int additionalNodeCount = randomIntBetween(1, 5);
            for (final Map.Entry<String, IndexRoutingTable> index : currentState.getRoutingTable().indicesRouting().entrySet()) {
        logger.info("--> Creating {} nodes", nodeCount);
            replicaCount = randomIntBetween(1, maxReplicaCount);  
     * assigns all primary shards first followed by replica copies.  
        if (isSegRep) {
            totalShards += shardCount * (1 + replicaCount);
        final int maxReplicaCount = 2;  
            logger.info("--> Creating index test{} with primary {} and replica {}", i, shardCount, replicaCount);
import java.util.List;
import java.util.concurrent.TimeUnit;  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
import org.opensearch.cluster.routing.RoutingNode;
     * This test in general passes without primary shard balance as well due to nature of allocation algorithm which
            }
                            + upperBoundPrimaryShardsPerNode,  
        // Create higher number of nodes than number of shards to reduce chances of SameShardAllocationDecider kicking-in
     * removed. The test asserts post each such event that primary shard distribution is balanced for each index.
     * Similar to testSingleIndexShardAllocation test but creates multiple indices, multiple nodes adding in and getting  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        assertAcked(
     * Utility method which ensures cluster has balanced primary shard distribution across a single index.  
            replicaCount = randomIntBetween(0, maxReplicaCount);
import org.opensearch.common.unit.TimeValue;
            nodeCountToStop--;
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
import java.util.Arrays;  
            internalCluster().stopRandomDataNode();  
        final List<String> nodeNames = new ArrayList<>();  
        // Remove a node
            nodeCountToStop--;  
import org.opensearch.common.settings.Settings;  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
                        .put(PREFER_PRIMARY_SHARD_REBALANCE.getKey(), preferPrimaryRebalance)  
                .setPersistentSettings(Settings.builder().put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE.getKey(), "true"))  
        ClusterState state;  
        ClusterState state;  
                final int primaryCount = node.shardsWithState(STARTED)  
    }
                .cluster()
                final int lowerBoundPrimaryShardsPerNode = (int) Math.floor(totalPrimaryShards * 1f / currentState.getRoutingNodes().size())  
        enablePreferPrimaryBalance();
        ClusterState state;
                .cluster()
        }  
        logger.info(ShardAllocations.printShardDistribution(state));
        }  
            logger.info("--> Creating index {} with shard count {} and replica count {}", "test" + i, shardCount, replicaCount);  
                    .filter(ShardRouting::primary)
    public void testGlobalPrimaryAllocation() throws Exception {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicaCount);
        logger.info("--> Adding {} nodes", additionalNodeCount);
        final int maxReplicaCount = 2;  
import org.opensearch.cluster.routing.RoutingNodes;  
     * <p>
        // Modify other configurations, expecting that the primary balance strategy will not be affected.
        verifyPerIndexPrimaryBalance();
        final float buffer = randomIntBetween(1, 4) * 0.10f;
        final int maxShardCount = 1;
        verifyPerIndexPrimaryBalance();  
import org.opensearch.cluster.metadata.IndexMetadata;  
            ensureGreen(TimeValue.timeValueSeconds(60));
        for (int i = 0; i < nodeCount; i++) {  
        logger.info(ShardAllocations.printShardDistribution(state));  
            // give replica a chance to promote as primary before terminating node containing the replica
        final int maxReplicaCount = 2;
     * ensures the primary shard distribution is balanced.
                    // Asserts value is within the variance threshold (-1/+1 of the average value).
            if (logger.isTraceEnabled()) {
        }
        // Add a new node  
        final List<String> nodeNames = new ArrayList<>();
 *
import org.opensearch.test.junit.annotations.TestLogging;  
        for (int i = 0; i < numberOfIndices; i++) {
            createIndex("test" + i, shardCount, replicaCount, i % 2 == 0);
        }
            nodeNames.add(internalCluster().startNode());
            ensureGreen(TimeValue.timeValueSeconds(60));  
            client().admin()  
        int shardCount, replicaCount, totalShards = 0;  
                    final int primaryCount = node.shardsWithState(index.getKey(), STARTED)
        internalCluster().startNodes(additionalNodeCount);
            logger.info("--> Creating index test{} with primary {} and replica {}", i, shardCount, replicaCount);
                logger.info(ShardAllocations.printShardDistribution(state));  
                        .put(PREFER_PRIMARY_SHARD_BALANCE.getKey(), preferPrimaryBalance)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
        int shardCount, replicaCount;  
     * This test verifies the happy path where primary shard allocation is balanced when multiple indices are created.  
        state = client().admin().cluster().prepareState().execute().actionGet().getState();  
            final ClusterState currentState = client().admin().cluster().prepareState().execute().actionGet().getState();
/*  
        for (int i = 0; i < numberOfIndices; i++) {
                state = client().admin().cluster().prepareState().execute().actionGet().getState();
        verifyPerIndexPrimaryBalance();  
                        "--> Primary balance assertion failure for index "  
        logger.info(ShardAllocations.printShardDistribution(state));
            createIndex("test" + i, shardCount, replicaCount, i % 2 == 0);
            builder = builder.put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT);
import org.opensearch.cluster.routing.ShardRouting;
 * compatible open source license.
        final int maxPossibleShards = numberOfIndices * maxShardCount * (1 + maxReplicaCount);  
        for (int i = 0; i < nodeCount; i++) {
     * This test verifies balanced primary shard allocation for a single index with large shard count in event of node  
        setAllocationRelocationStrategy(true, true, buffer);
            for (RoutingNode node : nodes) {
     * when the PREFER_PRIMARY_SHARD_REBALANCE is set to true
            }
        }  
        final int maxShardCount = 5;
    /**
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        logger.info("--> Creating {} nodes", nodeCount);
        }  
            // give replica a chance to promote as primary before terminating node containing the replica  
import org.opensearch.cluster.routing.IndexRoutingTable;
        List<List<Integer>> shardAndReplicaCounts = new ArrayList<>();
    private void createIndex(String idxName, int shardCount, int replicaCount, boolean isSegRep) {  
            nodeNames.add(internalCluster().startNode());
            ensureGreen(TimeValue.timeValueSeconds(60));
    }
        int shardCount, replicaCount;
                            + node.node().getName()  
    }  
                .prepareUpdateSettings()
            createIndex("test" + i, shardCount, replicaCount, i % 2 == 0);
 */  
        logger.info("--> Creating {} nodes", nodeCount);
     * going down and a new node joining the cluster. The results in shard distribution skewness and re-balancing logic
        ensureGreen(TimeValue.timeValueSeconds(60));
        final int nodeCount = randomIntBetween(totalShards, maxPossibleShards) + 1;  
     * This test verifies that the overall primary balance is attained during allocation. This test verifies primary
                            + "on node "
                            + " <= "  
    private void verifyPrimaryBalance(float buffer) throws Exception {
