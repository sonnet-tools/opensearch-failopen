import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        Settings settings = Settings.builder()
import org.opensearch.snapshots.EmptySnapshotsInfoService;  
        clusterState = ClusterState.builder(clusterState).nodes(discoveryNodes).build();
            EmptyClusterInfoService.INSTANCE,
 */  
        final String clusterName = "test-cluster";
 * compatible open source license.
 * this work for additional information regarding copyright
            .build();
            new BalancedShardsAllocator(settings),  
            .build();
import java.util.Set;
        // if deciders say NO to allocating a primary shard, then the cluster health should be RED
        for (IndexShardRoutingTable indexShardRoutingTable : routingTable.index(indexName)) {
        ClusterState clusterState = ClusterState.builder(new ClusterName(clusterName))  
        // make sure primaries are initialized
import org.opensearch.cluster.health.ClusterHealthStatus;  
import org.opensearch.cluster.metadata.Metadata;  
        final DiscoveryNodes.Builder discoveryNodes = DiscoveryNodes.builder();  
 */  
        return clusterState;
        final String indexName = "test-idx";
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
        AllocationDecider decider = new TestAllocateDecision(Decision.THROTTLE);
 * Unless required by applicable law or agreed to in writing,
/*
            @Override  
}  
import org.opensearch.cluster.routing.allocation.decider.Decision;  
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            EmptySnapshotsInfoService.INSTANCE
/**  
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            .routingTable(routingTable)
    }
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
import java.util.Collections;
import org.opensearch.env.Environment;
        final String indexName,
        logger.info("--> assert cluster health");
 * The OpenSearch Contributors require contributions made to  
 */
/*  
                }  
import org.opensearch.cluster.metadata.IndexMetadata;
        final String indexName = "test-idx";  
import org.opensearch.cluster.health.ClusterStateHealth;
            discoveryNodes.add(newNode("node" + i));
        final int numShards = randomIntBetween(1, 5);
import java.io.IOException;  
    private static AllocationService newAllocationService(Settings settings, Set<AllocationDecider> deciders) {
        routingTable = allocationService.reroute(clusterState, "reroute").routingTable();
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
            .build();  
        // if deciders say YES to allocating primary shards, stay in YELLOW state  
        };
 * has the correct status based on those allocation decisions.  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;  
 * Modifications Copyright OpenSearch Contributors. See
    private ClusterState runAllocationTest(  
    public void testPrimaryShardNoDecisionOnIndexCreation() throws IOException {
/*  
 * not use this file except in compliance with the License.
        final Set<AllocationDecider> allocationDeciders,  
        final AllocationService allocationService = newAllocationService(settings, allocationDeciders);
        final ClusterHealthStatus expectedStatus
 * You may obtain a copy of the License at  
        final Settings settings,
                } else {
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
 * KIND, either express or implied.  See the License for the
        // we need at least as many nodes as shards for the THROTTLE case, because  
            .put(IndexMetadata.builder(indexName).settings(settings(Version.CURRENT)).numberOfShards(numShards).numberOfReplicas(1))
            .build();
import org.opensearch.cluster.EmptyClusterInfoService;
        Settings settings = Settings.builder()
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.cluster.routing.RoutingTable;
                    return Decision.YES;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.node.DiscoveryNodes;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
        ClusterStateHealth health = new ClusterStateHealth(clusterState);
import org.opensearch.cluster.routing.ShardRouting;
 * this file be licensed under the Apache-2.0 license or a
    }
 * This class of tests exercise various scenarios of
            .build();  
        }  
        // if deciders THROTTLE allocating a primary shard, stay in YELLOW state
    }  
        }  
 * primary shard allocation and assert the cluster health
        RoutingTable routingTable = clusterState.routingTable();  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new AllocationDeciders(deciders),
    ) throws IOException {
            }
        logger.info("--> adding nodes");
        AllocationDecider decider = new TestAllocateDecision(Decision.YES) {
        return new AllocationService(  
        // once a shard has been throttled on a node, that node no longer accepts
            assertTrue(indexShardRoutingTable.primaryShard().initializing());
import org.opensearch.cluster.ClusterName;
        Metadata metadata = Metadata.builder()  
 */
    public void testPrimaryShardThrottleDecisionOnIndexCreation() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
        logger.info("--> do the reroute");  
            new TestGatewayAllocator(),
        ClusterState clusterState = runAllocationTest(settings, indexName, Collections.singleton(decider), ClusterHealthStatus.YELLOW);
        logger.info("Building initial routing table");
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())  
        runAllocationTest(settings, indexName, Collections.singleton(decider), ClusterHealthStatus.RED);
import org.opensearch.cluster.ClusterState;  
        );  
package org.opensearch.cluster.routing.allocation;
 * GitHub history for details.
 *  
    }
        Settings settings = Settings.builder()  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.Version;
        runAllocationTest(settings, indexName, Collections.singleton(decider), ClusterHealthStatus.YELLOW);  
import org.opensearch.test.gateway.TestGatewayAllocator;
            .metadata(metadata)
 * under the License.  
                    return Decision.NO;
    }  
 *
        AllocationDecider decider = new TestAllocateDecision(Decision.NO);  
        final String indexName = "test-idx";
                if (node.getByShardId(shardRouting.shardId()) == null) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    public void testPrimaryShardYesDecisionOnIndexCreation() throws IOException {  
        // any allocations on it
        assertThat(health.getStatus(), equalTo(expectedStatus));  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        for (int i = 0; i < numShards; i++) {
import org.opensearch.cluster.routing.RoutingNode;  
 *
public class DecisionsImpactOnClusterHealthTests extends OpenSearchAllocationTestCase {
