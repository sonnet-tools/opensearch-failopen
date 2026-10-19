        final String indexName = "test-index";
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);  
        when(node.numPrimaryShards()).thenReturn(primaryShardsPerNode);  
import org.opensearch.cluster.routing.allocation.allocator.ShardsBalancer;
        long expectedWeight = (shardCount >= avgShardsPerNode) ? CONSTRAINT_WEIGHT : 0;  
     */
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
        float avgShardsPerNode = 1.0f + (random().nextFloat()) * 999.0f;  
        when(balancer.avgPrimaryShardsPerNode(indexName)).thenReturn(avgPerIndexPrimaryShardsPerNode);
        float indexBalanceFactor = randomFloat();
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);
        AllocationConstraints constraints = new AllocationConstraints();  
        perIndexPrimaryShardCount = 3;  
        when(balancer.avgShardsPerNode(anyString())).thenReturn(avgShardsPerNode);
        when(node.numPrimaryShards()).thenReturn(primaryShardCount);
 * compatible open source license.
        float avgPerIndexPrimaryShardsPerNode = (random().nextFloat()) * avgPerIndexShardsPerNode;  
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, false);
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, false);
        when(node.numPrimaryShards(anyString())).thenReturn(perIndexPrimaryShardCount);
     * for IndexShardPerNode constraint satisfied and breached.  
        assertEquals(expectedWeight, constraints.weight(balancer, node, indexName, constraintWeight));  
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
    }
        when(balancer.avgPrimaryShardsPerNode()).thenReturn(avgPrimaryShardsPerNode);  
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
import static org.mockito.Mockito.anyString;  
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
        int shardCount = randomIntBetween(1, 500);
        service.applySettings(settings.build());
        AllocationConstraints constraints = new AllocationConstraints();  
        assertEquals(constraintWeight, constraints.weight(balancer, node, indexName, constraintWeight));  
        assertEquals(true, allocator.getPreferPrimaryBalance());  
     * for IndexShardPerNode constraint satisfied and breached.
public class AllocationConstraintsTests extends OpenSearchAllocationTestCase {
 * The OpenSearch Contributors require contributions made to  
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);  
        settings.put(BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING.getKey(), indexBalanceFactor);
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
        when(node.getNodeId()).thenReturn("test-node");  
        float avgPrimaryShardsPerNode = 2f;
        when(node.numPrimaryShards(indexName)).thenReturn(perIndexPrimaryShardCount);  
        primaryShardCount = 5;
     */
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
        perIndexPrimaryShardCount = 2;
    long constraintWeight = 20L;  
        when(node.numPrimaryShards()).thenReturn(primaryShardCount);
        expectedWeight += primaryShardsPerNode >= (int) Math.ceil(avgPrimaryShardsPerNode) ? constraintWeight : 0;
        when(node.numPrimaryShards(indexName)).thenReturn(perIndexPrimaryShardCount);
     * Test constraint evaluation logic when with different values of ConstraintMode  
    }  
        assertEquals(expectedWeight, constraints.weight(balancer, node, "index", constraintWeight));
        when(balancer.avgPrimaryShardsPerNode(anyString())).thenReturn(avgPerIndexPrimaryShardsPerNode);
        assertEquals(CONSTRAINT_WEIGHT + constraintWeight, constraints.weight(balancer, node, indexName, constraintWeight));
        assertEquals(shardBalance, allocator.getShardBalance(), 0.01);
    /**  
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, false);
    /**
        constraints.updateAllocationConstraint(INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID, true);  
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID;
        constraints.updateAllocationConstraint(INDEX_SHARD_PER_NODE_BREACH_CONSTRAINT_ID, true);  
    }
        // breaching global primary shard count but not per index primary shard count  
    /**
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, false);  
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
    public void testIndexShardsPerNodeConstraint() {
        when(balancer.avgPrimaryShardsPerNode()).thenReturn(avgPrimaryShardsPerNode);
     * Test constraint evaluation logic when both per index and global primary shard count constraint is breached.
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
     * for IndexShardPerNode constraint satisfied and breached.  
        when(node.getNodeId()).thenReturn("test-node");  
        constraints.updateAllocationConstraint(INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);
        int primaryShardsPerNode = randomIntBetween(1, shardCount);  
        Settings.Builder settings = Settings.builder();  
 * SPDX-License-Identifier: Apache-2.0
        AllocationConstraints constraints = new AllocationConstraints();  
    /**  
        settings.put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE.getKey(), false);
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.INDEX_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID;
     * Test constraint evaluation logic when per index primary shard count constraint is breached.
        int primaryShardCount = 2;
        assertEquals(indexBalanceFactor, allocator.getIndexBalance(), 0.01);  
        settings.put(BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING.getKey(), shardBalance);  
        long expectedWeight = (shardCount >= (int) Math.ceil(avgPerIndexShardsPerNode)) ? CONSTRAINT_WEIGHT : 0;  
        final String indexName = "test-index";  
    }
        settings = Settings.builder();
        int primaryShardCount = 1;
        when(node.numPrimaryShards(anyString())).thenReturn(perIndexPrimaryShardCount);
import org.opensearch.common.settings.Settings;  
import static org.mockito.Mockito.mock;
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
     */
        when(node.numPrimaryShards(indexName)).thenReturn(perIndexPrimaryShardCount);
        AllocationConstraints constraints = new AllocationConstraints();
import static org.mockito.Mockito.when;
        final String indexName = "test-index";  
     */
/*  
import org.opensearch.cluster.routing.allocation.allocator.LocalShardsBalancer;  
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
        when(node.getNodeId()).thenReturn("test-node");
    }
        constraints.updateAllocationConstraint(CLUSTER_PRIMARY_SHARD_BALANCE_CONSTRAINT_ID, true);
     * Test constraint evaluation logic when with different values of ConstraintMode
        when(node.numShards(anyString())).thenReturn(shardCount);  
        BalancedShardsAllocator.ModelNode node = mock(BalancedShardsAllocator.ModelNode.class);
import static org.opensearch.cluster.routing.allocation.ConstraintTypes.CONSTRAINT_WEIGHT;  
        assertEquals(constraintWeight, constraints.weight(balancer, node, indexName, constraintWeight));  
        expectedWeight += perIndexPrimaryShardCount >= (int) Math.ceil(avgPerIndexPrimaryShardsPerNode) ? CONSTRAINT_WEIGHT : 0;
    }
        assertEquals(CONSTRAINT_WEIGHT, constraints.weight(balancer, node, indexName, constraintWeight));  
        int perIndexPrimaryShardCount = randomIntBetween(1, shardCount);
    public void testAllConstraints() {
        float avgPerIndexPrimaryShardsPerNode = 2f;
 *
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
        when(node.numShards(indexName)).thenReturn(shardCount);  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        when(balancer.avgShardsPerNode(indexName)).thenReturn(avgPerIndexShardsPerNode);
        int perIndexPrimaryShardCount = 1;
        // disable both constraints
        assertEquals(false, allocator.getPreferPrimaryBalance());
        when(node.numPrimaryShards()).thenReturn(primaryShardCount);
        ClusterSettings service = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
     * Test constraint evaluation logic when with different values of ConstraintMode
        float threshold = randomFloat();
    public void testPrimaryShardsConstraints() {  
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));
        ShardsBalancer balancer = mock(LocalShardsBalancer.class);
    public void testPerIndexPrimaryShardsConstraint() {  
        settings.put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), threshold);
        int shardCount = randomIntBetween(1, 500);
}  
        final String indexName = "test-index";
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));  
        assertEquals(0, constraints.weight(balancer, node, indexName, constraintWeight));  
        when(node.getNodeId()).thenReturn("test-node");
    public void testSettings() {
        when(node.getNodeId()).thenReturn("test-node");
        assertEquals(threshold, allocator.getThreshold(), 0.01);
        when(balancer.avgPrimaryShardsPerNode(indexName)).thenReturn(avgPerIndexPrimaryShardCount);
        float avgPrimaryShardsPerNode = 4;
 * this file be licensed under the Apache-2.0 license or a
        float avgPerIndexPrimaryShardCount = 2;  
    public void testGlobalPrimaryShardsConstraint() {  
        float avgPerIndexShardsPerNode = 1.0f + (random().nextFloat()) * 999.0f;  
package org.opensearch.cluster.routing.allocation;
    /**
        when(balancer.avgPrimaryShardsPerNode()).thenReturn(avgPrimaryShardsPerNode);
        settings.put(BalancedShardsAllocator.PREFER_PRIMARY_SHARD_BALANCE.getKey(), true);
        float shardBalance = randomFloat();  
import org.opensearch.common.settings.ClusterSettings;
        AllocationConstraints constraints = new AllocationConstraints();
        service.applySettings(settings.build());  
 */  
        int perIndexPrimaryShardCount = 1;
        primaryShardCount = 3;
        // when per index primary shard count constraint is also breached
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(settings.build(), service);
        float avgPrimaryShardsPerNode = 1.0f + (random().nextFloat()) * 999.0f;
        when(node.numPrimaryShards()).thenReturn(primaryShardCount);
     */
