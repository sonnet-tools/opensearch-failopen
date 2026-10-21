    private final AllocationService ALLOCATION_SERVICE = createAllocationService(
        super.setUp();
 */
        final Iterator<ShardRouting> iterator = this.clusterState.getRoutingNodes()
        startInitializingShards(TEST_INDEX_2);
 * Licensed to Elasticsearch under one or more contributor
        int shardCount = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        startInitializingShards(TEST_INDEX_1);
            }
import org.opensearch.cluster.OpenSearchAllocationTestCase;
/*
        startInitializingShards(TEST_INDEX_2);
        this.clusterState = rerouteResult;
    }
        ClusterState rerouteResult = ALLOCATION_SERVICE.reroute(clusterState, "reroute");
            .nodeInterleavedShardIterator(ShardMovementStrategy.REPLICA_FIRST);
import java.util.List;
        startInitializingShards(TEST_INDEX_2);
 *
    @Before
        clusterState = startInitializingShardsAndReroute(ALLOCATION_SERVICE, clusterState, index);
    private static final String TEST_INDEX_1 = "test1";
    public void testInterleavedShardIteratorNoPreference() {
        initPrimaries();
            }
    }
            .numberOfReplicas(this.numberOfReplicas)
        }
import org.opensearch.cluster.ClusterState;
import java.util.Iterator;
 * You may obtain a copy of the License at
        logger.info("adding {} nodes and performing rerouting", this.numberOfReplicas + 1);
    }
                iteratingPrimary = shard.primary();
import static org.hamcrest.Matchers.not;
        Settings.builder()
        int shardCount = 0;
    private int shardsPerIndex;
        startInitializingShards(TEST_INDEX_1);
        this.numberOfShards = 5;
 * not use this file except in compliance with the License.
            .build();
                Integer.MAX_VALUE
            .put(
 * GitHub history for details.
        }
    private int numberOfReplicas;
        startInitializingShards(TEST_INDEX_2);
            shardCount++;
            .nodeInterleavedShardIterator(ShardMovementStrategy.PRIMARY_FIRST);
 * Unless required by applicable law or agreed to in writing,
        // Initialize all the shards for test index 1 and 2
        }
            shardCount++;
 *     http://www.apache.org/licenses/LICENSE-2.0
        startInitializingShards(TEST_INDEX_1);
/*
import org.junit.Before;
            final ShardRouting shard = iterator.next();
            .build()
            } else {
    /**
    }
    private void initPrimaries() {
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 *
     * Puts primary shard index routings into initializing state
 * under the License.
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                node0.add(swap);
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_1).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_1)).build()
        this.totalNumberOfShards = this.shardsPerIndex * 2;
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", Integer.MAX_VALUE)
    private void startInitializingShards(String index) {
        assertEquals(shardCount, this.totalNumberOfShards);
                iteratingReplica = shard.primary() == false;
                node0.remove(routing);
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
 * specific language governing permissions and limitations
import org.opensearch.cluster.metadata.Metadata;
            if (routing.primary()) {
    }
 *
        startInitializingShards(TEST_INDEX_1);
                assertTrue(shard.primary());
import org.opensearch.cluster.routing.allocation.AllocationService;
        }
        final RoutingNode node0 = this.clusterState.getRoutingNodes().node("node0");
        this.clusterState = ClusterState.builder(clusterState).nodes(discoBuilder).build();
 * KIND, either express or implied.  See the License for the
            .numberOfShards(this.numberOfShards);
        final List<ShardRouting> shardRoutingList = node0.shardsWithState(TEST_INDEX_1, ShardRoutingState.STARTED);
        for (int i = 0; i < this.numberOfReplicas + 1; i++) {
import org.opensearch.cluster.metadata.IndexMetadata;
            )
import org.opensearch.cluster.node.DiscoveryNodes;
    private IndexMetadata.Builder createIndexMetadata(String indexName) {
        // Get primary first shard iterator and assert primary shards are iterated over first
    private static final String TEST_INDEX_2 = "test2";
}
        startInitializingShards(TEST_INDEX_1);
     * Moves initializing shards into started state
 */
        }
                ShardRouting swap = node1.getByShardId(routing.shardId());
            .metadata(metadata)
        logger.info("Setup test with {} shards and {} replicas.", this.numberOfShards, this.numberOfReplicas);
 */
            .routingTable(testRoutingTable)
 * this work for additional information regarding copyright
    @Override
        return new IndexMetadata.Builder(indexName).settings(DEFAULT_SETTINGS)
                node1.add(routing);
    private RoutingTable emptyRoutingTable;
        // Get replica first shard iterator and assert replica shards are iterated over first
                new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_2).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_2)).build()
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        final RoutingNode node1 = this.clusterState.getRoutingNodes().node("node1");
     */
    private ClusterState clusterState;
    public void testInterleavedShardIteratorReplicaFirst() {
        initPrimaries();
 * SPDX-License-Identifier: Apache-2.0
            if (iteratingReplica) {
            .build();
 * this file be licensed under the Apache-2.0 license or a
/*
        assertThat(rerouteResult, not(equalTo(this.clusterState)));
import org.opensearch.common.settings.Settings;
    }
package org.opensearch.cluster.routing;
        this.emptyRoutingTable = new RoutingTable.Builder().build();
        )
    public void setUp() throws Exception {
            shardCount++;
    );
        for (ShardRouting routing : shardRoutingList) {
        // Initialize all the shards for test index 1 and 2
            final ShardRouting shard = iterator.next();
 * The OpenSearch Contributors require contributions made to
            final ShardRouting shard = iterator.next();
            .put("cluster.routing.allocation.node_concurrent_recoveries", Integer.MAX_VALUE) // don't limit recoveries
        // Create primary shard count imbalance between two nodes
                assertFalse(shard.primary());
 * ownership. Elasticsearch licenses this file to you under
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
            .add(
     */
    private static final Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        final Iterator<ShardRouting> iterator = this.clusterState.getRoutingNodes()
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
    }
            discoBuilder = discoBuilder.add(newNode("node" + i));
        boolean iteratingReplica = true;
        this.numberOfReplicas = 2;
        boolean iteratingPrimary = true;
public class RoutingNodesTests extends OpenSearchAllocationTestCase {
        startInitializingShards(TEST_INDEX_1);
    /**
            }
        while (iterator.hasNext()) {
        RoutingTable testRoutingTable = new RoutingTable.Builder().add(
            )
        startInitializingShards(TEST_INDEX_2);
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
            .nodeInterleavedShardIterator(ShardMovementStrategy.NO_PREFERENCE);
        startInitializingShards(TEST_INDEX_2);
        initPrimaries();
    private int numberOfShards;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.Version;
        while (iterator.hasNext()) {
        assertEquals(shardCount, this.totalNumberOfShards);
        int shardCount = 0;
        assertEquals(shardCount, this.totalNumberOfShards);
        while (iterator.hasNext()) {
            } else {
                node1.remove(swap);
            if (iteratingPrimary) {
    public void testInterleavedShardIteratorPrimaryFirst() {
        this.shardsPerIndex = this.numberOfShards * (this.numberOfReplicas + 1);
    private int totalNumberOfShards;
        // Initialize all the shards for test index 1 and 2
        final Iterator<ShardRouting> iterator = this.clusterState.getRoutingNodes()
