        assertEquals(threshold, allocator.getThreshold(), 0.01);
        int shardCount = randomIntBetween(1, 500);
     * Test constraint evaluation logic when with different values of ConstraintMode
     * Test constraint evaluation logic when with different values of ConstraintMode
        ClusterSettings service = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
        assertEquals(expectedWeight, constraints.weight(balancer, node, "index", constraintWeight));
        when(node.getNodeId()).thenReturn("test-node");
        final String indexName = "test-index";
        final String indexName = "test-index";
import org.opensearch.cluster.routing.allocation.allocator.ShardsBalancer;
    public void testPrimaryShardsConstraints() {
        float threshold = randomFloat();
        int shardCount = randomIntBetween(1, 500);
     */
     * Test constraint evaluation logic when with different values of ConstraintMode
        // disable both constraints
        assertEquals(CONSTRAINT_WEIGHT, constraints.weight(balancer, node, indexName, constraintWeight));
        int perIndexPrimaryShardCount = 1;
        when(balancer.avgPrimaryShardsPerNode(anyString())).thenReturn(avgPerIndexPrimaryShardsPerNode);
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID;
        when(balancer.avgShardsPerNode(indexName)).thenReturn(avgPerIndexShardsPerNode);
 */
        // when per index primary shard count constraint is also breached
        when(balancer.avgPrimaryShardsPerNode()).thenReturn(avgPrimaryShardsPerNode);
        when(balancer.avgShardsPerNode(anyString())).thenReturn(avgShardsPerNode);
import static org.mockito.Mockito.anyString;
        when(node.numPrimaryShards()).thenReturn(primaryShardsPerNode);
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, false);
    public void testPerIndexPrimaryShardsConstraint() {
        perIndexPrimaryShardCount = 2;
        settings = Settings.builder();
    /**
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
        when(node.getNodeId()).thenReturn("test-node");
        assertEquals(constraintWeight, constraints.weight(balancer, node, indexName, constraintWeight));
        when(node.numPrimaryShards()).thenReturn(primaryShardCount);
        assertEquals(constraintWeight, constraints.weight(balancer, node, indexName, constraintWeight));
        constraints.updateAllocationConstraint(INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID, true);
        long expectedWeight = (shardCount >= avgShardsPerNode) ? CONSTRAINT_WEIGHT : 0;
        when(node.numPrimaryShards(indexName)).thenReturn(perIndexPrimaryShardCount);
        when(node.numPrimaryShards(anyString())).thenReturn(perIndexPrimaryShardCount);
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);
        float shardBalance = randomFloat();
        when(node.numPrimaryShards()).thenReturn(primaryShardCount);
        when(node.numPrimaryShards()).thenReturn(primaryShardCount);
        int primaryShardsPerNode = randomIntBetween(1, shardCount);
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);
        assertEquals(CONSTRAINT_WEIGHT + constraintWeight, constraints.weight(balancer, node, indexName, constraintWeight));
        assertEquals(indexBalanceFactor, allocator.getIndexBalance(), 0.01);
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), shardBalance);
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
        when(node.numPrimaryShards(indexName)).thenReturn(perIndexPrimaryShardCount);
import org.opensearch.cluster.routing.allocation.allocator.LocalShardsBalancer;
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
    /**
        when(balancer.avgPrimaryShardsPerNode(indexName)).thenReturn(avgPerIndexPrimaryShardCount);
    }
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
    public void testIndexShardsPerNodeConstraint() {
        when(node.getNodeId()).thenReturn("test-node");
        float avgPrimaryShardsPerNode = 1.0f + (random().nextFloat()) * 999.0f;
        AllocationConstraints constraints = new AllocationConstraints();
        expectedWeight += perIndexPrimaryShardCount >= (int) Math.ceil(avgPerIndexPrimaryShardsPerNode) ? CONSTRAINT_WEIGHT : 0;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CONSTRAINT_WEIGHT;
    public void testAllConstraints() {
     */
        service.applySettings(settings.build());
        float avgShardsPerNode = 1.0f + (random().nextFloat()) * 999.0f;
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
        float avgPerIndexPrimaryShardsPerNode = (random().nextFloat()) * avgPerIndexShardsPerNode;
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
        float avgPrimaryShardsPerNode = 4;
import org.opensearch.common.settings.Settings;
        // breaching global primary shard count but not per index primary shard count
import static org.mockito.Mockito.mock;
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
        int perIndexPrimaryShardCount = randomIntBetween(1, shardCount);
    }
 *
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, false);
        float avgPrimaryShardsPerNode = 2f;
        assertEquals(true, allocator.getPreferPrimaryBalance());
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
        final String indexName = "test-index";
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
    }
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
        AllocationConstraints constraints = new AllocationConstraints();
    /**
        expectedWeight += primaryShardsPerNode >= (int) Math.ceil(avgPrimaryShardsPerNode) ? constraintWeight : 0;
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);
        when(node.numPrimaryShards(indexName)).thenReturn(perIndexPrimaryShardCount);
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
    /**
        primaryShardCount = 5;
    /**
        settings.put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE.getKey(), false);
     * for IndexShardPerNode constraint satisfied and breached.
    }
 * compatible open source license.
     * Test constraint evaluation logic when both per index and global primary shard count constraint is breached.
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
        when(node.numShards(anyString())).thenReturn(shardCount);
        assertEquals(shardBalance, allocator.getShardBalance(), 0.01);
        Settings.Builder settings = Settings.builder();
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
     */
}
/*
        when(node.getNodeId()).thenReturn("test-node");
        when(node.numShards(indexName)).thenReturn(shardCount);
    }
        when(balancer.avgPrimaryShardsPerNode(indexName)).thenReturn(avgPerIndexPrimaryShardsPerNode);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
     * Test constraint evaluation logic when per index primary shard count constraint is breached.
     * for IndexShardPerNode constraint satisfied and breached.
        float avgPerIndexPrimaryShardCount = 2;
        when(node.getNodeId()).thenReturn("test-node");
        float avgPerIndexShardsPerNode = 1.0f + (random().nextFloat()) * 999.0f;
    long constraintWeight = 20L;
     */
        perIndexPrimaryShardCount = 3;
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(settings.build(), service);
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
    }
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), indexBalanceFactor);
        int perIndexPrimaryShardCount = 1;
    public void testGlobalPrimaryShardsConstraint() {
        float indexBalanceFactor = randomFloat();
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);
        int primaryShardCount = 2;
        long expectedWeight = (shardCount >= (int) Math.ceil(avgPerIndexShardsPerNode)) ? CONSTRAINT_WEIGHT : 0;
     * for IndexShardPerNode constraint satisfied and breached.
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.cluster.routing.allocation;
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, false);
        when(balancer.avgPrimaryShardsPerNode()).thenReturn(avgPrimaryShardsPerNode);
public class AllocationConstraintsTests extends OpenSearchAllocationTestCase {
        final String indexName = "test-index";
        AllocationConstraints constraints = new AllocationConstraints();
        AllocationConstraints constraints = new AllocationConstraints();
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), threshold);
        int primaryShardCount = 1;
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
        AllocationConstraints constraints = new AllocationConstraints();
        when(balancer.avgPrimaryShardsPerNode()).thenReturn(avgPrimaryShardsPerNode);
        assertEquals(false, allocator.getPreferPrimaryBalance());
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
        assertEquals(expectedWeight, constraints.weight(balancer, node, indexName, constraintWeight));
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);
     */
    public void testSettings() {
        float avgPerIndexPrimaryShardsPerNode = 2f;
        when(node.numPrimaryShards(anyString())).thenReturn(perIndexPrimaryShardCount);
        settings.put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE.getKey(), true);
        service.applySettings(settings.build());
        constraints.updateAllocationConstraint(INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID, true);
import static org.mockito.Mockito.when;
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, false);
        primaryShardCount = 3;
import org.opensearch.common.settings.ClusterSettings;
        when(node.numPrimaryShards()).thenReturn(primaryShardCount);
 * The OpenSearch Contributors require contributions made to
