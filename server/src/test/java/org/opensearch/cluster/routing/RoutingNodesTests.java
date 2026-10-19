     * Puts primary shard index routings into initializing state
    private static final Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
    private static final String TEST_INDEX_1 = "test1";
 * license agreements. See the NOTICE file distributed with
package org.opensearch.cluster.routing;
    }
 * Modifications Copyright OpenSearch Contributors. See
/*
            .metadata(metadata)
        super.setUp();  
     */  
    }  
 * The OpenSearch Contributors require contributions made to  
        final List<ShardRouting> shardRoutingList = node0.shardsWithState(TEST_INDEX_1, ShardRoutingState.STARTED);
        }
        startInitializingShards(TEST_INDEX_1);  
            } else {
        clusterState = startInitializingShardsAndReroute(ALLOCATION_SERVICE, clusterState, index);
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
            .add(  
    /**
        initPrimaries();
 * under the License.  
    private void initPrimaries() {
        logger.info("Setup test with {} shards and {} replicas.", this.numberOfShards, this.numberOfReplicas);
        int shardCount = 0;  
        for (ShardRouting routing : shardRoutingList) {
    private RoutingTable emptyRoutingTable;  
import org.opensearch.cluster.metadata.Metadata;
        this.emptyRoutingTable = new RoutingTable.Builder().build();  
        this.numberOfShards = 5;
    public void testInterleavedShardIteratorPrimaryFirst() {
    public void setUp() throws Exception {
import static org.hamcrest.Matchers.not;
import org.opensearch.Version;
        startInitializingShards(TEST_INDEX_1);
            .nodeInterleavedShardIterator(ShardMovementStrategy.PRIMARY_FIRST);
 *
/*  
import org.opensearch.common.settings.Settings;  
    /**
            )
        startInitializingShards(TEST_INDEX_2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final RoutingNode node1 = this.clusterState.getRoutingNodes().node("node1");  
                iteratingPrimary = shard.primary();
        final Iterator<ShardRouting> iterator = this.clusterState.getRoutingNodes()
            )
    private void startInitializingShards(String index) {
 *
        for (int i = 0; i < this.numberOfReplicas + 1; i++) {
        // Get replica first shard iterator and assert replica shards are iterated over first
        assertEquals(shardCount, this.totalNumberOfShards);
        final Iterator<ShardRouting> iterator = this.clusterState.getRoutingNodes()
        startInitializingShards(TEST_INDEX_2);
        this.clusterState = ClusterState.builder(clusterState).nodes(discoBuilder).build();
        while (iterator.hasNext()) {
            if (routing.primary()) {  
        while (iterator.hasNext()) {
                Integer.MAX_VALUE  
 * KIND, either express or implied.  See the License for the
    }  
            .numberOfShards(this.numberOfShards);
        assertEquals(shardCount, this.totalNumberOfShards);  
        this.numberOfReplicas = 2;
    @Before
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
        while (iterator.hasNext()) {  
     * Moves initializing shards into started state
            shardCount++;  
        }
    }
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    private int numberOfReplicas;
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", Integer.MAX_VALUE)  
            .build();
        // Initialize all the shards for test index 1 and 2  
                assertFalse(shard.primary());
            discoBuilder = discoBuilder.add(newNode("node" + i));
            .numberOfReplicas(this.numberOfReplicas)
    public void testInterleavedShardIteratorReplicaFirst() {
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                node0.remove(routing);
 *     http://www.apache.org/licenses/LICENSE-2.0
            shardCount++;  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
            .nodeInterleavedShardIterator(ShardMovementStrategy.REPLICA_FIRST);  
            .routingTable(testRoutingTable)  
 * Licensed to Elasticsearch under one or more contributor  
        )
            .build();  
}
            .put(
/*  
import org.junit.Before;
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();  
        startInitializingShards(TEST_INDEX_1);
 * specific language governing permissions and limitations
        boolean iteratingPrimary = true;  
 * software distributed under the License is distributed on an
                new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_2).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_2)).build()
import org.opensearch.cluster.routing.allocation.AllocationService;
                node0.add(swap);  
            final ShardRouting shard = iterator.next();  
import org.opensearch.cluster.node.DiscoveryNodes;  
    @Override  
    private int shardsPerIndex;  
        this.clusterState = rerouteResult;
    public void testInterleavedShardIteratorNoPreference() {
 */  
        logger.info("adding {} nodes and performing rerouting", this.numberOfReplicas + 1);
        ClusterState rerouteResult = ALLOCATION_SERVICE.reroute(clusterState, "reroute");
        int shardCount = 0;
        final Iterator<ShardRouting> iterator = this.clusterState.getRoutingNodes()
import static org.hamcrest.Matchers.equalTo;  
    }  
 */
    private ClusterState clusterState;
            }  
import java.util.Iterator;  
            } else {  
 * GitHub history for details.
        initPrimaries();
        int shardCount = 0;
            }
                iteratingReplica = shard.primary() == false;  
 * this work for additional information regarding copyright
        this.shardsPerIndex = this.numberOfShards * (this.numberOfReplicas + 1);  
            if (iteratingPrimary) {
    }  
        startInitializingShards(TEST_INDEX_1);
        final RoutingNode node0 = this.clusterState.getRoutingNodes().node("node0");
            }  
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_1).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_1)).build()
        }
        startInitializingShards(TEST_INDEX_1);  
            final ShardRouting shard = iterator.next();
        // Initialize all the shards for test index 1 and 2  
        RoutingTable testRoutingTable = new RoutingTable.Builder().add(  
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
                node1.add(routing);
        assertEquals(shardCount, this.totalNumberOfShards);
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        startInitializingShards(TEST_INDEX_2);
            .put("cluster.routing.allocation.node_concurrent_recoveries", Integer.MAX_VALUE) // don't limit recoveries
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
        startInitializingShards(TEST_INDEX_2);
import org.opensearch.cluster.ClusterState;
        return new IndexMetadata.Builder(indexName).settings(DEFAULT_SETTINGS)  
        startInitializingShards(TEST_INDEX_1);  
public class RoutingNodesTests extends OpenSearchAllocationTestCase {  
                assertTrue(shard.primary());
            final ShardRouting shard = iterator.next();
        // Get primary first shard iterator and assert primary shards are iterated over first  
        this.totalNumberOfShards = this.shardsPerIndex * 2;
    private int numberOfShards;
    );  
        assertThat(rerouteResult, not(equalTo(this.clusterState)));  
        boolean iteratingReplica = true;
 * compatible open source license.
        Settings.builder()
        initPrimaries();
        }
import java.util.List;
    }
    private IndexMetadata.Builder createIndexMetadata(String indexName) {
 *  
    private final AllocationService ALLOCATION_SERVICE = createAllocationService(  
                node1.remove(swap);
            .nodeInterleavedShardIterator(ShardMovementStrategy.NO_PREFERENCE);
        // Create primary shard count imbalance between two nodes
        // Initialize all the shards for test index 1 and 2  
                ShardRouting swap = node1.getByShardId(routing.shardId());
            .build()
 */  
 * this file be licensed under the Apache-2.0 license or a
            if (iteratingReplica) {
            shardCount++;
    private int totalNumberOfShards;
import org.opensearch.cluster.metadata.IndexMetadata;
     */  
        startInitializingShards(TEST_INDEX_2);
        }  
    private static final String TEST_INDEX_2 = "test2";
        startInitializingShards(TEST_INDEX_2);
