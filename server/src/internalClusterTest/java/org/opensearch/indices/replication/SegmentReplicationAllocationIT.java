        verifyPerIndexPrimaryBalance();
        final int nodeCount = randomIntBetween(5, 10);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, replicaCount);
        verifyPerIndexPrimaryBalance();
        final int maxShardCount = 50;
            createIndex("test" + i, shardCount, replicaCount, i % 2 == 0);
        // and preventing primary relocations
                        .put(PRIMARY_SHARD_REBALANCE_BUFFER.getKey(), buffer)
            shardCount = randomIntBetween(1, maxShardCount);
                    final int primaryCount = node.shardsWithState(index.getKey(), STARTED)
            for (final IndexRoutingTable index : currentState.getRoutingTable().indicesRouting().values()) {
    }
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
 *
        // Create higher number of nodes than number of shards to reduce chances of SameShardAllocationDecider kicking-in
     * <p>
            ensureGreen(TimeValue.timeValueSeconds(60));
    public void testGlobalPrimaryAllocation() throws Exception {
            final ClusterState currentState = client().admin().cluster().prepareState().execute().actionGet().getState();
                final int primaryCount = node.shardsWithState(STARTED)
    public void testAllocationWithDisruption() throws Exception {
     * This test verifies the happy path where primary shard allocation is balanced when multiple indices are created.
    public void testAllocationAndRebalanceWithDisruption() throws Exception {
 * compatible open source license.
     * removed. The test asserts post each such event that primary shard distribution is balanced for each index.
        final int nodeCount = randomIntBetween(totalShards, maxPossibleShards) + 1;
        for (int i = 0; i < numberOfIndices; i++) {
        }
            shardAndReplicaCounts.add(Arrays.asList(shardCount, replicaCount));
        enablePreferPrimaryBalance();
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE;
     */
import java.util.List;
            logger.info("--> Creating index {} with shard count {} and replica count {}", "test" + i, shardCount, replicaCount);
    }
            nodeCountToStop--;
        ensureGreen(TimeValue.timeValueSeconds(60));
        }
        Settings.Builder builder = Settings.builder()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        }
                .cluster()
import org.opensearch.test.InternalTestCluster;
                )
        enablePreferPrimaryBalance();
            if (logger.isTraceEnabled()) {
        for (int i = 0; i < numberOfIndices; i++) {
        );
import org.opensearch.test.junit.annotations.TestLogging;
        logger.info(ShardAllocations.printShardDistribution(state));
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
    public void testSingleIndexShardAllocation() throws Exception {
        int shardCount, replicaCount, totalShards = 0;
                state = client().admin().cluster().prepareState().execute().actionGet().getState();
    }
            replicaCount = randomIntBetween(1, maxReplicaCount);
     */
        for (int i = 0; i < numberOfIndices; i++) {
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
                }
    }
        verifyPerIndexPrimaryBalance();
}
        // Create a strictly higher number of nodes than the number of shards to reduce chances of SameShardAllocationDecider kicking-in
        final List<String> nodeNames = new ArrayList<>();
            builder = builder.put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT);
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
            logger.info("--> Creating index {} with shard count {} and replica count {}", "test" + i, shardCount, replicaCount);
        final int nodeCount = randomIntBetween(maxReplicaCount + 1, 10);
import org.opensearch.index.IndexModule;
            }
            // give replica a chance to promote as primary before terminating node containing the replica
 * The OpenSearch Contributors require contributions made to
        logger.info("--> Creating {} nodes", nodeCount);
        if (isSegRep) {
                        .collect(Collectors.toList())
        for (int i = 0; i < nodeCount; i++) {
                    Settings.builder()
import org.opensearch.cluster.routing.RoutingNodes;
        ensureGreen(TimeValue.timeValueSeconds(100));
    }
            ensureGreen(TimeValue.timeValueSeconds(60));
import org.opensearch.cluster.routing.IndexRoutingTable;
        internalCluster().startClusterManagerOnlyNode();
        // Modify other configurations, expecting that the primary balance strategy will not be affected.
                        .put(PREFER_PRIMARY_SHARD_BALANCE.getKey(), preferPrimaryBalance)
        // Remove a node
import java.util.ArrayList;
                        lowerBoundPrimaryShardsPerNode <= primaryCount && primaryCount <= upperBoundPrimaryShardsPerNode
        verifyPrimaryBalance(0.0f);
     * ensures the primary shard distribution is balanced.
import org.opensearch.cluster.OpenSearchAllocationTestCase.ShardAllocations;
                    .collect(Collectors.toList())
        // and preventing primary relocations
        } else {
    }
        int shardCount, replicaCount;
        final int maxShardCount = 2;
     * Similar to testSingleIndexShardAllocation test but creates multiple indices, multiple nodes adding in and getting
                assertTrue(primaryCount <= (avgPrimaryShardsPerNode * (1 + buffer)));
                state = client().admin().cluster().prepareState().execute().actionGet().getState();
        final int maxShardCount = 2;
        final int additionalNodeCount = randomIntBetween(1, 5);
                logger.info(ShardAllocations.printShardDistribution(state));
        logger.info(ShardAllocations.printShardDistribution(state));
     * assigns all primary shards first followed by replica copies.
        logger.info("--> Creating {} nodes", nodeCount);
import java.util.concurrent.TimeUnit;
        logger.info("--> Cluster state post nodes stop {}", state);
        assertBusy(() -> {
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.Map;
        }
        final int maxReplicaCount = 2;
        List<List<Integer>> shardAndReplicaCounts = new ArrayList<>();
    }
                            + " "
     */
        internalCluster().startClusterManagerOnlyNode();
        for (int i = 0; i < nodeCount; i++) {
            client().admin()
     */
        logger.info("--> Creating {} nodes", nodeCount);
 */
            final ClusterState currentState = client().admin().cluster().prepareState().execute().actionGet().getState();
            client().admin()
        verifyPerIndexPrimaryBalance();
        }
        logger.info(ShardAllocations.printShardDistribution(state));
                .prepareUpdateSettings()
            nodeNames.add(internalCluster().startNode());
    /**
        int shardCount, replicaCount;
        logger.info(ShardAllocations.printShardDistribution(state));
import org.opensearch.cluster.routing.RoutingNode;
        final int numberOfIndices = randomIntBetween(1, 10);
            ensureGreen(TimeValue.timeValueSeconds(60));
                    );
        final int maxPossibleShards = numberOfIndices * maxShardCount * (1 + maxReplicaCount);
            replicaCount = randomIntBetween(1, maxReplicaCount);
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        }
        internalCluster().startClusterManagerOnlyNode();
     */
                final int totalPrimaryShards = index.getValue().primaryShardsActive();
        ensureGreen(TimeValue.timeValueSeconds(100));
     * balance per index and across all indices is maintained.
    }
        logger.info("--> Adding {} nodes", additionalNodeCount);
                    // Asserts value is within the variance threshold (-1/+1 of the average value).
                            + " (assigned) <= "
        for (int i = 0; i < nodeCount; i++) {
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.PREFER_PRIMARY_SHARD_REBALANCE;
/*
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.PRIMARY_SHARD_REBALANCE_BUFFER;
        ClusterState state;
        verifyPerIndexPrimaryBalance();
        }
        verifyPerIndexPrimaryBalance();
            totalShards += shardCount * (1 + replicaCount);
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        final int numberOfIndices = randomIntBetween(5, 10);
                            + " <= "
            logger.info("--> Creating index test{} with primary {} and replica {}", i, shardCount, replicaCount);
            nodeNames.add(internalCluster().startNode());
            logger.info("--> Creating index test{} with primary {} and replica {}", i, shardCount, replicaCount);
                            + index
        final float buffer = randomIntBetween(1, 4) * 0.10f;
        }
                    - 1;
            nodeNames.add(internalCluster().startNode());
        }
        logger.info(ShardAllocations.printShardDistribution(state));
            // give replica a chance to promote as primary before terminating node containing the replica
        final List<String> nodeNames = new ArrayList<>();
                final int upperBoundPrimaryShardsPerNode = (int) Math.ceil(totalPrimaryShards * 1f / currentState.getRoutingNodes().size())
import java.util.stream.Collectors;
     * This test verifies balanced primary shard allocation for a single index with large shard count in event of node
        for (int i = 0; i < nodeCount; i++) {
                        .stream()
                            + "on node "
        assertAcked(
                        .put(PREFER_PRIMARY_SHARD_REBALANCE.getKey(), preferPrimaryRebalance)
            shardCount = randomIntBetween(1, maxShardCount);
            internalCluster().stopRandomDataNode();
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        logger.info(ShardAllocations.printShardDistribution(state));
        logger.info(ShardAllocations.printShardDistribution(state));
        );
        int shardCount, replicaCount;
        }
            state = client().admin().cluster().prepareState().execute().actionGet().getState();
import org.opensearch.cluster.routing.ShardRouting;
                final int lowerBoundPrimaryShardsPerNode = (int) Math.floor(totalPrimaryShards * 1f / currentState.getRoutingNodes().size())
            shardCount = randomIntBetween(1, maxShardCount);
        int nodeCountToStop = additionalNodeCount;
        setAllocationRelocationStrategy(true, true, buffer);
    /**
        final int maxShardCount = 1;
            if (logger.isTraceEnabled()) {
            internalCluster().stopRandomDataNode();
        final int numberOfIndices = randomIntBetween(1, 3);
package org.opensearch.indices.replication;
        verifyPerIndexPrimaryBalance();
            client().admin()
                logger.info(ShardAllocations.printShardDistribution(state));
        final int nodeCount = 5;
            shardCount = randomIntBetween(1, maxShardCount);
     * going down and a new node joining the cluster. The results in shard distribution skewness and re-balancing logic
import org.opensearch.common.settings.Settings;
        while (nodeCountToStop > 0) {
                    assertTrue(
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            shardCount = shardAndReplicaCounts.get(i).get(0);
        assertAcked(
        logger.info("--> Creating {} nodes", nodeCount);
    /**
    }
        ClusterState state;
        assertBusy(() -> {
                        .size();
        for (int i = 0; i < nodeCount; i++) {
        }
            nodeNames.add(internalCluster().startNode());
        ensureGreen(TimeValue.timeValueSeconds(60));
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodeNames.get(0)));
        final List<String> nodeNames = new ArrayList<>();
            createIndex("test" + i, shardCount, replicaCount, i % 2 == 0);
                .cluster()
        while (nodeCountToStop > 0) {
            ensureGreen(TimeValue.timeValueSeconds(60));
     * @throws Exception exception
        final int maxReplicaCount = 2;
     * This test verifies that the overall primary balance is attained during allocation. This test verifies primary
import org.opensearch.cluster.ClusterState;
import org.opensearch.test.OpenSearchIntegTestCase;
        for (int i = 0; i < numberOfIndices; i++) {
        final int additionalNodeCount = randomIntBetween(1, 5);
        ClusterState state;
 * this file be licensed under the Apache-2.0 license or a
            ensureGreen(TimeValue.timeValueSeconds(60));
            RoutingNodes nodes = currentState.getRoutingNodes();
        enablePreferPrimaryBalance();
        prepareCreate(idxName, builder).get();
    @TestLogging(reason = "Enable debug logs from cluster and index replication package", value = "org.opensearch.cluster:DEBUG,org.opensearch.indices.replication:DEBUG")
        ensureGreen(TimeValue.timeValueSeconds(60));
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
     * removed. The test asserts post each such event that primary shard distribution is balanced for each index as well as across the nodes
        }, 60, TimeUnit.SECONDS);
        internalCluster().validateClusterFormed();
    private void verifyPrimaryBalance(float buffer) throws Exception {
                    .filter(ShardRouting::primary)
    public void setAllocationRelocationStrategy(boolean preferPrimaryBalance, boolean preferPrimaryRebalance, float buffer) {
 * SPDX-License-Identifier: Apache-2.0
            }
        assertAcked(
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)
        logger.info(ShardAllocations.printShardDistribution(state));
        internalCluster().startClusterManagerOnlyNode();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, shardCount)
            }
            int totalPrimaryShards = 0;
        ClusterState state;
        internalCluster().startNodes(additionalNodeCount);
                .setPersistentSettings(Settings.builder().put(PRIMARY_SHARD_REBALANCE_BUFFER.getKey(), 0.2))
                            + upperBoundPrimaryShardsPerNode,
        internalCluster().startClusterManagerOnlyNode();
    /**
                .prepareUpdateSettings()
        logger.info(ShardAllocations.printShardDistribution(state));
        final List<String> nodeNames = new ArrayList<>();
            nodeNames.add(internalCluster().startNode());
     *
     */
            final int avgPrimaryShardsPerNode = (int) Math.ceil(totalPrimaryShards * 1f / currentState.getRoutingNodes().size());
                            + lowerBoundPrimaryShardsPerNode
        }
            ensureGreen(TimeValue.timeValueSeconds(60));
        );
            RoutingNodes nodes = currentState.getRoutingNodes();
                .setPersistentSettings(
        internalCluster().startDataOnlyNode();
                            + primaryCount
import org.opensearch.indices.replication.common.ReplicationType;
        verifyPrimaryBalance(buffer);
        logger.info("--> Adding {} nodes", additionalNodeCount);
                totalPrimaryShards += index.primaryShardsActive();
        logger.info(ShardAllocations.printShardDistribution(state));
     * Similar to testSingleIndexShardAllocation test but creates multiple indices, multiple nodes adding in and getting
                .cluster()
                    + 1;
        internalCluster().validateClusterFormed();
        verifyPerIndexPrimaryBalance();
            nodeCountToStop--;
            for (RoutingNode node : nodes) {
                            + node.node().getName()
        int nodeCountToStop = additionalNodeCount;
                        "--> Primary balance assertion failure for index "
                .setPersistentSettings(Settings.builder().put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE.getKey(), "true"))
        final int maxReplicaCount = 2;
        enablePreferPrimaryBalance();
            logger.info(ShardAllocations.printShardDistribution(state));
                        .filter(ShardRouting::primary)
        verifyPerIndexPrimaryBalance();
                .prepareUpdateSettings()
        final List<String> nodeNames = new ArrayList<>();
            }
        internalCluster().startNodes(additionalNodeCount);
        }, 60, TimeUnit.SECONDS);
        final int nodeCount = randomIntBetween(maxReplicaCount + 1, 10);
        verifyPerIndexPrimaryBalance();
        logger.info("--> Creating {} nodes", nodeCount);
     * when the PREFER_PRIMARY_SHARD_REBALANCE is set to true
    private void createIndex(String idxName, int shardCount, int replicaCount, boolean isSegRep) {
            builder = builder.put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
            for (final Map.Entry<String, IndexRoutingTable> index : currentState.getRoutingTable().indicesRouting().entrySet()) {
    /**
            replicaCount = randomIntBetween(0, maxReplicaCount);
        }
import java.util.Arrays;
        // Add a new node
     * Utility method which ensures cluster has balanced primary shard distribution across a single index.
                for (RoutingNode node : nodes) {
        logger.info("--> Cluster state post nodes stop {}", state);
    }
        final int maxReplicaCount = 1;
        for (int i = 0; i < numberOfIndices; i++) {
            replicaCount = shardAndReplicaCounts.get(i).get(1);
        final int maxReplicaCount = 1;
        verifyPrimaryBalance(buffer);
                    .size();
    public void testPerIndexPrimaryAllocation() throws Exception {
    /**
    public void enablePreferPrimaryBalance() {
        createIndex("test", maxShardCount, maxReplicaCount, true);
        final int maxShardCount = 5;
        verifyPrimaryBalance(buffer);
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
        state = client().admin().cluster().prepareState().execute().actionGet().getState();
                    .stream()
            replicaCount = randomIntBetween(0, maxReplicaCount);
        ClusterState state;
            createIndex("test" + i, shardCount, replicaCount, i % 2 == 0);
            createIndex("test" + i, shardCount, replicaCount, i % 2 == 0);
        verifyPerIndexPrimaryBalance();
            }
    private void verifyPerIndexPrimaryBalance() throws Exception {
import org.opensearch.common.unit.TimeValue;
     * This test in general passes without primary shard balance as well due to nature of allocation algorithm which
        final int numberOfIndices = randomIntBetween(5, 10);
public class SegmentReplicationAllocationIT extends SegmentReplicationBaseIT {
