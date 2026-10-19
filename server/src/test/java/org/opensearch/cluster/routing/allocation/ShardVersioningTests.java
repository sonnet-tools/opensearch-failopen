            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
 * specific language governing permissions and limitations
            assertThat(routingTable.index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            Settings.builder()
 *
import static org.hamcrest.Matchers.equalTo;
 */  
                .build()
            assertThat(routingTable.index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .build();
    public void testSimple() {  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build();  
import org.apache.logging.log4j.Logger;
            .build();
/*
        }  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.cluster.routing.allocation;
/*  
            assertThat(routingTable.index("test1").shard(i).shards().size(), equalTo(2));  
import org.opensearch.cluster.routing.RoutingTable;  
 *
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
        logger.info("start all the primary shards for test1, replicas will start initializing");
            assertThat(routingTable.index("test2").shard(i).shards().size(), equalTo(2));  
 * You may obtain a copy of the License at  
            assertThat(routingTable.index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            .metadata(metadata)  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        routingTable = startInitializingShardsAndReroute(strategy, clusterState, "test1").routingTable();  
/*  
}
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        for (int i = 0; i < routingTable.index("test2").shards().size(); i++) {
import org.opensearch.common.settings.Settings;
    }
            .routingTable(routingTable)
 * under the License.  
        Metadata metadata = Metadata.builder()
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(routingTable.index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(routingTable.index("test2").shard(i).shards().size(), equalTo(2));  
            assertThat(routingTable.index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        }  
import org.opensearch.cluster.node.DiscoveryNodes;
import org.apache.logging.log4j.LogManager;
import org.opensearch.Version;  
        logger.info("start two nodes");
            assertThat(routingTable.index("test2").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
    private final Logger logger = LogManager.getLogger(ShardVersioningTests.class);
import org.opensearch.cluster.metadata.Metadata;
        clusterState = ClusterState.builder(clusterState)
 * software distributed under the License is distributed on an
public class ShardVersioningTests extends OpenSearchAllocationTestCase {  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
 * KIND, either express or implied.  See the License for the
                    ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        }  
        for (int i = 0; i < routingTable.index("test1").shards().size(); i++) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        );
        for (int i = 0; i < routingTable.index("test1").shards().size(); i++) {
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
                    ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
 * compatible open source license.
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.ClusterState;
            assertThat(routingTable.index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
                .put(  
        AllocationService strategy = createAllocationService(
 * GitHub history for details.
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
            .build();
 * The OpenSearch Contributors require contributions made to  
            assertThat(routingTable.index("test2").shard(i).primaryShard().state(), equalTo(INITIALIZING));
 */  
 *  
                )  
        }  
        for (int i = 0; i < routingTable.index("test2").shards().size(); i++) {
 * this work for additional information regarding copyright
import org.opensearch.cluster.metadata.IndexMetadata;  
 */
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            assertThat(routingTable.index("test1").shard(i).shards().size(), equalTo(2));  
