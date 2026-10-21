import org.opensearch.cluster.routing.ShardRouting;
            discoveryNodes.add(newNode("node" + i));
        Settings settings = Settings.builder()
}
        AllocationDecider decider = new TestAllocateDecision(Decision.NO);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;
                if (node.getByShardId(shardRouting.shardId()) == null) {
import org.opensearch.common.settings.Settings;
        final String indexName = "test-idx";
 *
                } else {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
            assertTrue(indexShardRoutingTable.primaryShard().initializing());
        final String indexName = "test-idx";
 * this work for additional information regarding copyright
 *
 *
/**
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
        // if deciders say NO to allocating a primary shard, then the cluster health should be RED
        final DiscoveryNodes.Builder discoveryNodes = DiscoveryNodes.builder();
 */
            .build();
import org.opensearch.cluster.routing.allocation.decider.Decision;
        // if deciders say YES to allocating primary shards, stay in YELLOW state
package org.opensearch.cluster.routing.allocation;
 * GitHub history for details.
                    return Decision.YES;
 * has the correct status based on those allocation decisions.
        final AllocationService allocationService = newAllocationService(settings, allocationDeciders);
        clusterState = ClusterState.builder(clusterState).nodes(discoveryNodes).build();
        logger.info("--> assert cluster health");
import org.opensearch.cluster.health.ClusterHealthStatus;
        runAllocationTest(settings, indexName, Collections.singleton(decider), ClusterHealthStatus.RED);
import org.opensearch.cluster.ClusterState;
    }
 * software distributed under the License is distributed on an
import org.opensearch.Version;
        );
            new TestGatewayAllocator(),
 * The OpenSearch Contributors require contributions made to
        final String indexName = "test-idx";
 */
        return new AllocationService(
    }
/*
    public void testPrimaryShardThrottleDecisionOnIndexCreation() throws IOException {
import org.opensearch.cluster.node.DiscoveryNodes;
 * Modifications Copyright OpenSearch Contributors. See
        final String indexName,
 */
import org.opensearch.env.Environment;
        // if deciders THROTTLE allocating a primary shard, stay in YELLOW state
        logger.info("--> do the reroute");
import org.opensearch.snapshots.EmptySnapshotsInfoService;
 * primary shard allocation and assert the cluster health
            new AllocationDeciders(deciders),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
import org.opensearch.cluster.metadata.Metadata;
        Settings settings = Settings.builder()
        // make sure primaries are initialized
        final int numShards = randomIntBetween(1, 5);
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 * the Apache License, Version 2.0 (the "License"); you may
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
/*
        logger.info("Building initial routing table");
import org.opensearch.cluster.EmptyClusterInfoService;
        final Settings settings,
        ClusterState clusterState = ClusterState.builder(new ClusterName(clusterName))
            .build();
        final ClusterHealthStatus expectedStatus
    ) throws IOException {
import org.opensearch.cluster.health.ClusterStateHealth;
 */
            EmptyClusterInfoService.INSTANCE,
import org.opensearch.cluster.ClusterName;
            .build();
                }
        for (int i = 0; i < numShards; i++) {
        // we need at least as many nodes as shards for the THROTTLE case, because
        };
import java.util.Set;
 * KIND, either express or implied.  See the License for the
        Metadata metadata = Metadata.builder()
        Settings settings = Settings.builder()
/*
        ClusterState clusterState = runAllocationTest(settings, indexName, Collections.singleton(decider), ClusterHealthStatus.YELLOW);
            .build();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath().toString())
 * You may obtain a copy of the License at
            .put(IndexMetadata.builder(indexName).settings(settings(Version.CURRENT)).numberOfShards(numShards).numberOfReplicas(1))
            EmptySnapshotsInfoService.INSTANCE
        runAllocationTest(settings, indexName, Collections.singleton(decider), ClusterHealthStatus.YELLOW);
    private ClusterState runAllocationTest(
 * specific language governing permissions and limitations
    }
        // once a shard has been throttled on a node, that node no longer accepts
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
        final String clusterName = "test-cluster";
        routingTable = allocationService.reroute(clusterState, "reroute").routingTable();
        for (IndexShardRoutingTable indexShardRoutingTable : routingTable.index(indexName)) {
            @Override
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
import org.opensearch.test.gateway.TestGatewayAllocator;
                    return Decision.NO;
import org.opensearch.cluster.routing.RoutingNode;
            .build();
 * SPDX-License-Identifier: Apache-2.0
    public void testPrimaryShardYesDecisionOnIndexCreation() throws IOException {
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.routing.RoutingTable;
 * under the License.
        logger.info("--> adding nodes");
 * Unless required by applicable law or agreed to in writing,
        return clusterState;
        assertThat(health.getStatus(), equalTo(expectedStatus));
        }
 * This class of tests exercise various scenarios of
 * Licensed to Elasticsearch under one or more contributor
            }
 * ownership. Elasticsearch licenses this file to you under
        AllocationDecider decider = new TestAllocateDecision(Decision.YES) {
        // any allocations on it
        final Set<AllocationDecider> allocationDeciders,
    public void testPrimaryShardNoDecisionOnIndexCreation() throws IOException {
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            .metadata(metadata)
            new BalancedShardsAllocator(settings),
    private static AllocationService newAllocationService(Settings settings, Set<AllocationDecider> deciders) {
            .routingTable(routingTable)
        ClusterStateHealth health = new ClusterStateHealth(clusterState);
        AllocationDecider decider = new TestAllocateDecision(Decision.THROTTLE);
        RoutingTable routingTable = clusterState.routingTable();
    }
public class DecisionsImpactOnClusterHealthTests extends OpenSearchAllocationTestCase {
    }
