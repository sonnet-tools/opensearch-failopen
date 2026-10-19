            this.countDownLatch = latch;
            .build();
        }  
import org.opensearch.cluster.routing.RoutingTable;
        public int getNumberOfInFlightFetches() {
        @Override  
package org.opensearch.cluster.routing.allocation;
 * compatible open source license.
        public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {  
        TestAllocator testAllocator = new TestAllocator(expectedStateLatch);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))  
    }
import org.opensearch.cluster.metadata.Metadata;  
 * SPDX-License-Identifier: Apache-2.0
            clusterState,
        }  
            RoutingAllocation allocation,
            UnassignedAllocationHandler unassignedAllocationHandler  
        public void allocateUnassigned(  
            ShardRouting shardRouting,
        }
        @Override  
        }
        public AllocateUnassignedDecision explainUnassignedShardAllocation(  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(2))  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
}  
        ) {
        ) {  
        public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {
            yesAllocationDeciders(),  
        testAllocator = new TestAllocator(expectedStateLatch);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            RoutingAllocation routingAllocation
 */  
 * The OpenSearch Contributors require contributions made to  
        }
import org.opensearch.cluster.ClusterName;
        @Override
        public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {
        assertTrue(expectedStateLatch.await(30, TimeUnit.SECONDS));
 *
            return 0;  
        // if the below condition is passed, then we are sure runnable executed for all primary shards
        }  
import org.opensearch.cluster.node.DiscoveryNodes;
        RoutingAllocation allocation = new RoutingAllocation(
            countDownLatch.countDown();
 * this file be licensed under the Apache-2.0 license or a
            .build();
import org.opensearch.cluster.routing.ShardRouting;  
        clusterState = ClusterState.builder(clusterState)
    private static class TestAllocator implements ExistingShardsAllocator {
            clusterState.getRoutingNodes(),
        @Override
import java.util.concurrent.TimeUnit;
            .routingTable(initialRoutingTable)  
        expectedStateLatch = new CountDownLatch(6);
        @Override
        TestAllocator(CountDownLatch latch) {  
import java.util.List;  
        }
        @Override
        Metadata metadata = Metadata.builder()
        testAllocator.allocateAllUnassignedShards(allocation, false).run();  
import org.opensearch.common.settings.Settings;
            .metadata(metadata)
            null,  
            null,
import java.util.concurrent.CountDownLatch;
        testAllocator.allocateAllUnassignedShards(allocation, true).run();  
        CountDownLatch expectedStateLatch = new CountDownLatch(3);
    public void testRunnablesExecutedForUnassignedShards() throws InterruptedException {  
        public void beforeAllocation(RoutingAllocation allocation) {
import org.opensearch.cluster.ClusterState;  
        }
            .build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertTrue(expectedStateLatch.await(30, TimeUnit.SECONDS));
        public void cleanCaches() {
/*  
        @Override
        @Override
import org.opensearch.cluster.metadata.IndexMetadata;
            ShardRouting unassignedShard,
        // if the below condition is passed, then we are sure runnable executed for all replica shards
import org.opensearch.Version;
        }
    }  
        );  
            return null;
            0L
public class ExistingShardsAllocatorTests extends OpenSearchAllocationTestCase {
        final CountDownLatch countDownLatch;
