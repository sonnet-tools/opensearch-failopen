        }
        assertTrue(routingTable.hasIndex(TEST_INDEX_1));
    }
        assertTrue(routingTable.hasIndex(TEST_INDEX_1));
        assertThat(this.emptyRoutingTable.allShards(new String[0]).size(), is(0));
        // test no validation errors
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),
                );
            is(2 * this.numberOfShards)
            ShardRouting primaryShardRouting = mock(ShardRouting.class);
    }
        );
        assertThat(
    private ClusterState clusterState;
            .build();
        } catch (IndexNotFoundException e) {
import org.opensearch.cluster.metadata.MetadataIndexStateService;
import org.opensearch.cluster.routing.allocation.AllocationService;
    public void testShardsWithState() {
                }
        initPrimaries();
        final Metadata metadata3 = Metadata.builder().put(indexMetadata, true).build();
 * this work for additional information regarding copyright
import java.util.HashMap;
            final RoutingTable routingTable = new RoutingTable.Builder().addAsRecovery(indexMetadata).build();
    /**
        // Verifies against all replica shards on the node
                )
        indexShardRoutingTableMap.remove(indexShardRoutingTableMap.keySet().iterator().next());
        return new IndexMetadata.Builder(indexName).settings(DEFAULT_SETTINGS)
        final RemoteStoreRecoverySource remoteStoreRecoverySource = new RemoteStoreRecoverySource(
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(indices, ShardRouting::primary).size(), is(2));
    }
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, true).size(),
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .numberOfReplicas(numReplicas)
        // starting replicas
        Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap = getIndexShardRoutingTableMap(
            remoteStoreRecoverySource,
        indexMetadata = IndexMetadata.builder(indexName)
            false
        Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap = getIndexShardRoutingTableMap(
        ShardRouting routing1 = TestShardRouting.newShardRouting(shardId, "node1", randomBoolean(), ShardRoutingState.STARTED);
 * compatible open source license.
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected));
            .build();
        assertThat(
    private static final String TEST_INDEX_2 = "test2";
    private RoutingTable emptyRoutingTable;
            assertThat(routingTable.hasIndex(TEST_INDEX_1), is(true));
        );
 * SPDX-License-Identifier: Apache-2.0
    public void testAddAsRemoteStoreRestoreShardMismatch() {
        RoutingTable testRoutingTable = new RoutingTable.Builder().add(
            indexMetadata,
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertThat(this.emptyRoutingTable.activePrimaryShardsGrouped(new String[0], true).size(), is(0));
            "restore_uuid",
import static org.hamcrest.Matchers.containsString;
        List<ShardRoutingState> activeInitializingStates = List.of(INITIALIZING, STARTED, RELOCATING);
        assertThat(clusterState.routingTable().allShards(new String[] { TEST_INDEX_1 }).size(), is(this.shardsPerIndex));
            is(this.totalNumberOfShards - initializingExpected - this.numberOfShards)
            false
            indexMetadata.getIndex(),
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
        int numberOfShards = this.numberOfShards * (numberOfReplicas + 1);
                        .build()
        }
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
                Set<String> insyncAids = shardTable.activeShards()
            () -> new RoutingTable.Builder().addAsRemoteStoreRestore(
    }
            .put("cluster.routing.allocation.node_concurrent_recoveries", Integer.MAX_VALUE) // don't limit recoveries
        final Metadata metadata4 = Metadata.builder().put(indexMetadata, true).build();
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(shard -> false).size(), is(0));
            .numberOfShards(numShards)
    }
            assertThat(routingTable.hasIndex(TEST_INDEX_1), is(true));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .numberOfReplicas(numberOfReplicas)
            numberOfReplicas
            .numberOfReplicas(numberOfReplicas)
        ClusterState rerouteResult = ALLOCATION_SERVICE.reroute(clusterState, "reroute");
        // make sure both replicas are marked as delayed (i.e. not reallocated)
        assertFalse(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing2, routing4)));
            fail("expected exception");
        logger.info("start primary shards for index {}", index);
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(predicate).size(), is(2));
        assertSame(clusterState.routingTable().getIndicesRouting(), clusterState.routingTable().indicesRouting());
    }
import org.opensearch.cluster.metadata.Metadata;
        }
        try {
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
    public void testAllShardsForMultipleIndices() {
    private void initPrimaries() {
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, true).size(),
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
        );
            getIndexShardRoutingTableMap(indexMetadata.getIndex(), true, numberOfReplicas),
        {
import static org.hamcrest.Matchers.equalTo;
        assertThat(clusterState.routingTable().index("foobar"), is(nullValue()));
        final RoutingTable routingTable = new RoutingTable.Builder().addAsRemoteStoreRestore(
        // remove node2 and reroute
        ).build();
        this.clusterState = rerouteResult;
        assertThat(
        }
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(this.totalNumberOfShards));
        assertThat(clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
            assertThat(this.clusterState.routingTable().allShards("not_existing").size(), is(0));
            final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.OPEN).build();
            new IndexId(TEST_INDEX_1, "1")
        );
        )
    }
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_2 }, false).size(),
        } catch (IllegalStateException e) {
        clusterState = ClusterState.builder(clusterState)
        }
            new IndexId(TEST_INDEX_1, "1")
                    activeInitializingStates.get(randomIntBetween(0, activeInitializingStates.size() - 1))
            is(2 * this.numberOfShards)
        for (IndexShardRoutingTable indexShardRoutingTable : indexShardRoutingTableMap.values()) {
        final int numShards = 1;
            indexShardRoutingTableMap.put(new ShardId(index, i), indexShardRoutingTable);
        this.numberOfShards = randomIntBetween(1, 5);
    public void testActivePrimaryShardsGrouped() {
        this.totalNumberOfShards = this.shardsPerIndex * 2;
        assertThat(rerouteResult, not(equalTo(this.clusterState)));
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_1).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_1)).build()
        this.shardsPerIndex = this.numberOfShards * (this.numberOfReplicas + 1);
import static org.hamcrest.Matchers.not;
            assertThat(e.getMessage(), containsString("cannot be reused"));
        assertThat(
        assertThat(
import java.util.function.Predicate;
        assertThat(clusterState.routingTable().allShards(new String[] { TEST_INDEX_1 }).size(), is(this.shardsPerIndex));
        assertThat(clusterState.routingTable().allShards(new String[] { TEST_INDEX_1, TEST_INDEX_2 }).size(), is(this.totalNumberOfShards));
        startInitializingShards(TEST_INDEX_2);
        logger.info("adding {} nodes and performing rerouting", this.numberOfReplicas + 1);
            is(this.totalNumberOfShards - 2 * this.numberOfShards)
            .numberOfShards(numShards + 1)
        assertThat(
            fail("expected exception");
        // remove node2 and reroute
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1, "not_exists" }, true);
        // Verifies false against all shards on the node (active/inactive)
        try {
            numberOfReplicas
        }
    }
                    }
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(),
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),
        }
    }
            is(2)
                .size(),
            .numberOfReplicas(numReplicas)
    public void testAllShardsMatchingPredicate() {
    }
            is(this.numberOfShards)
        // starting primaries
            for (int j = 0; j < numberOfReplicas; j++) {
            remoteStoreRecoverySource,
        }
        }
        startInitializingShards(TEST_INDEX_1);
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
        final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.OPEN)
        assertThat(
        final RemoteStoreRecoverySource remoteStoreRecoverySource = new RemoteStoreRecoverySource(
            .build();
        startInitializingShards(TEST_INDEX_1);
        startInitializingShards(TEST_INDEX_2);
    private static final Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
            .routingTable(testRoutingTable)
import org.opensearch.Version;
        expectThrows(IllegalStateException.class, () -> indexRoutingTable.validate(metadata3));
import static org.mockito.Mockito.mock;
        int numberOfReplicas = randomIntBetween(0, 5);
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(shard -> true).size(), is(4));
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())
            fail("expected exception");
 */
        // Verifies against all primary shards on the node
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(), is(this.shardsPerIndex));
        this.emptyRoutingTable = new RoutingTable.Builder().build();
            .build();
        Metadata metadata = Metadata.builder()
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),
        } catch (IndexNotFoundException e) {
                Boolean replicaUnassigned = allUnassigned || randomBoolean();
    public void setUp() throws Exception {
        assertThat(
        assertThat(
        initPrimaries();
                    .map(shr -> shr.allocationId().getId())
            .build();
            is(2 * this.numberOfShards)
    }
        assertThat(this.emptyRoutingTable.activePrimaryShardsGrouped(new String[0], false).size(), is(0));
        initPrimaries();
import org.opensearch.cluster.node.DiscoveryNodes;
        );
 * ownership. Elasticsearch licenses this file to you under
    private final AllocationService ALLOCATION_SERVICE = createAllocationService(
        assertThat(clusterState.routingTable().hasIndex("foobar"), is(false));
        ShardId shardId = new ShardId(new Index("index", "uuid"), 0);
        );
import org.opensearch.core.index.shard.ShardId;
            Version.CURRENT,
import org.opensearch.cluster.metadata.IndexMetadata;
            is(this.totalNumberOfShards - initializingExpected - 2 * this.numberOfShards)
/*
        assertThat(clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
            }
                remoteStoreRecoverySource,
        );
            if (primaryUnassigned) {
import java.util.Map;
/*
        expectThrows(IllegalStateException.class, () -> indexRoutingTable.validate(metadata4));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            indexMetadata.getIndex(),
            when(indexShardRoutingTable.primaryShard()).thenReturn(primaryShardRouting);
    }
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        );
            fail("Calling with non-existing index should be ignored at the moment");
            .metadata(metadata)
            // expected
        clusterState = ClusterState.builder(clusterState)
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", Integer.MAX_VALUE)
        Metadata metadata = Metadata.builder()
        // Verifies a predicate which tests for inactive replicas
/*
            is(this.totalNumberOfShards)
import static org.hamcrest.Matchers.nullValue;
 */
        }
        );
        final RoutingTable routingTable = new RoutingTable.Builder().addAsRemoteStoreRestore(
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        ShardRouting routing4 = TestShardRouting.newShardRouting(shardId, "node3", "node2", randomBoolean(), ShardRoutingState.RELOCATING);
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())
    private IndexMetadata.Builder createIndexMetadata(String indexName) {
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),
        ShardRouting routing2 = TestShardRouting.newShardRouting(shardId, "node2", randomBoolean(), ShardRoutingState.STARTED);
import java.util.Set;
        return imdBuilder.build();
        assertTrue(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing1, routing2)));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected));
            IllegalStateException.class,
    }
        assertThat(
        assertThat(this.emptyRoutingTable.allActiveShardsGrouped(new String[0], true).size(), is(0));
                .state(IndexMetadata.State.CLOSE)
            .build();
        assertThat(
        clusterState = allocation.reroute(clusterState, "reroute");
        assertThat(
 * under the License.
    private int numberOfReplicas;
        int numberOfReplicas = randomIntBetween(0, 5);
            if (indexShardRoutingTable.primaryShard().unassigned()) {
            .build();
 * Licensed to Elasticsearch under one or more contributor
        } catch (IndexNotFoundException e) {
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(this.numberOfShards));
        assertThat(clusterState.routingTable().getIndicesRouting().size(), is(2));
                imdBuilder.putInSyncAllocationIds(shardRouting.id(), insyncAids);
        initPrimaries();
        clusterState = allocation.reroute(clusterState, "reroute");
        );
    public void testIndex() {
            )
            .build();
            is(this.numberOfShards)
        assertThat(
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),
                        activeInitializingStates.get(randomIntBetween(0, activeInitializingStates.size() - 1))
        assertThat(
        Builder discoBuilder = DiscoveryNodes.builder();
            "restore_uuid",
    }
            new IndexId(TEST_INDEX_1, "1")
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
            when(primaryShardRouting.unassigned()).thenReturn(primaryUnassigned);
                false
        assertThat(clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
        final String indexName = "test";
        super.setUp();
    public void testAddAsRemoteStoreRestoreAllUnassigned() {
            b.remove("foo");
        }
import org.opensearch.common.settings.Settings;
            "restore_uuid",
            .build();
        return indexShardRoutingTableMap;
                ShardRouting replicaShardRouting = mock(ShardRouting.class);
            )
        final RemoteStoreRecoverySource remoteStoreRecoverySource = new RemoteStoreRecoverySource(
        try {
            clusterState.routingTable().allShardsSatisfyingPredicate(indices, shardRouting -> !shardRouting.primary()).size(),
    public static IndexMetadata updateActiveAllocations(IndexRoutingTable indexRoutingTable, IndexMetadata indexMetadata) {
        assertThat(clusterState.routingTable().index(TEST_INDEX_1).getIndex().getName(), is(TEST_INDEX_1));
            is(2)
        // test wrong number of shards and replicas causes validation errors
    }
            fail("Exception expected when calling allShards() with non existing index name");
        Predicate<ShardRouting> predicate = s -> s.state() == ShardRoutingState.UNASSIGNED && s.unassignedInfo().isDelayed();
            .metadata(metadata)
        RoutingTable.Builder b = RoutingTable.builder();
            // expected
        );
                for (ShardRouting replicaShardRouting : indexShardRoutingTable.replicaShards()) {
            .build();
                    );
            assertThat(routingTable.allShards(TEST_INDEX_1).size(), is(this.shardsPerIndex));
 * GitHub history for details.
        );
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),
                when(replicaShardRouting.unassigned()).thenReturn(replicaUnassigned);
            .settings(settings(Version.CURRENT))
        }
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder(indexMetadata);
 * Unless required by applicable law or agreed to in writing,
            .put(
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_2 }, false).size(),
            assertThat(routingTable.index(TEST_INDEX_1).shardsWithState(UNASSIGNED).size(), is(this.shardsPerIndex));
        for (int i = 0; i < this.numberOfShards; i++) {
            }
            .build();
            assertThat(routingTable.hasIndex(TEST_INDEX_1), is(false));
 * this file be licensed under the Apache-2.0 license or a
        );
            fail("expected exception");
                    insyncAids.add(primaryShard.allocationId().getId());
     * puts primary shard indexRoutings into initializing state
        assertFalse(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing1, routing2, routing3)));
                .settingsVersion(indexMetadata.getSettingsVersion() + 1);
        final RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
            for (ShardRouting shardRouting : shardTable) {
            fail("Calling with non-existing index name should raise IndexMissingException");
    }
            .numberOfReplicas(numReplicas + 1)
            IndexShardRoutingTable indexShardRoutingTable = mock(IndexShardRoutingTable.class);
        final int numReplicas = randomIntBetween(0, 1);
    public void testShardsMatchingPredicateCount() {
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
        }
            assertThat(e.getMessage(), containsString("cannot be reused"));
            discoBuilder = discoBuilder.add(newNode("node" + i));
        assertFalse(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing1, routing3)));
                when(primaryShardRouting.state()).thenReturn(
    public void testHasIndex() {
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(), is(this.shardsPerIndex));
        startInitializingShards(TEST_INDEX_2);
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),
                        unassignedShards += 1;
                } else {
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(2 * this.numberOfShards));
    public void testAllShardsMatchingPredicateWithSpecificIndices() {
    }
            .build();
        );
            is(this.numberOfShards)
    }
        );
            true,
            assertThat(e.getMessage(), containsString("cannot be reused"));
        assertThat(
            is(this.shardsPerIndex)
 * KIND, either express or implied.  See the License for the
        }
 * software distributed under the License is distributed on an
        assertThat(this.emptyRoutingTable.allShards().size(), is(0));
    @Override
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
     */
        try {
        } catch (IndexNotFoundException e) {
                if (replicaUnassigned) {
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        // Verifies true against all shards on the node (active/inactive)
        } catch (IllegalStateException e) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        );
 * You may obtain a copy of the License at
 */
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        Metadata metadata = Metadata.builder()
    }
        for (int i = 0; i < this.numberOfReplicas + 1; i++) {
            final RoutingTable routingTable = new RoutingTable.Builder().addAsRecovery(indexMetadata).build();
import org.opensearch.core.index.Index;
package org.opensearch.cluster.routing;
    );
 * specific language governing permissions and limitations
    private void startInitializingShards(String index) {
        );
        );
            .numberOfShards(numShards)
        );
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
            is(this.numberOfShards)
import java.util.ArrayList;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
                unassignedShards += indexShardRoutingTable.replicaShards().size() + 1;
                    Settings.builder()
import org.opensearch.cluster.routing.RecoverySource.RemoteStoreRecoverySource;
        );
        assertTrue(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing1, routing4)));
            clusterState.routingTable()
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(routingTable.allShards(TEST_INDEX_1).size(), is(this.shardsPerIndex));
        int initializingExpected = this.numberOfShards + this.numberOfShards * this.numberOfReplicas;
    @Before
            expectThrows(IndexNotFoundException.class, () -> routingTable.allShards(TEST_INDEX_1));
            .numberOfReplicas(numReplicas + 1)
    public void testValidations() {
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1, "not_exists" }, false);
        // test wrong number of replicas causes validation errors
                if (primaryShard.initializing() && primaryShard.recoverySource().getType() == RecoverySource.Type.EXISTING_STORE) {
        // test wrong number of shards causes validation errors
    public void testIndicesRouting() {
            fail("Calling with non-existing index should be ignored at the moment");
        assertThat(clusterState.routingTable().allShards(new String[] { TEST_INDEX_1 }).size(), is(this.shardsPerIndex));
                    // simulate a primary was initialized based on aid
            .build()
import static org.mockito.Mockito.when;
    public void testAllAssignedShardsGrouped() {
        initializingExpected = 2 * this.numberOfShards * this.numberOfReplicas;
        } catch (IllegalStateException e) {
import org.junit.Before;
        final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.OPEN)
            ).build()
            b.add((IndexRoutingTable) null);
            }
        String[] indices = new String[] { "test1", "test2" };
    }
                    .collect(Collectors.toSet());
 * license agreements. See the NOTICE file distributed with
        // starting replicas
        );
        final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.OPEN)
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(),
        assertThat(clusterState.routingTable().shardsMatchingPredicateCount(predicate), is(2));
            .build();
            .numberOfReplicas(this.numberOfReplicas)
        startInitializingShards(TEST_INDEX_2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(
    }
                    if (replicaShardRouting.unassigned()) {
            }
            is(this.totalNumberOfShards)
        indexMetadata = updateActiveAllocations(indexRoutingTable, indexMetadata);
                indexMetadata,
    public void testAllShards() {
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(
            is(this.numberOfShards)
            is(this.numberOfShards)
        final Metadata metadata2 = Metadata.builder().put(indexMetadata, true).build();
        indexMetadata = IndexMetadata.builder(indexName)
            .build();
                .allShardsSatisfyingPredicate(shardRouting -> !shardRouting.primary() && !shardRouting.active())
        // make sure both replicas are marked as delayed (i.e. not reallocated)
                when(primaryShardRouting.state()).thenReturn(UNASSIGNED);
 * Modifications Copyright OpenSearch Contributors. See
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1, "not_exists" }, true);
        );
            is(2 * this.numberOfShards)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        );
        final IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
        clusterState = allocation.reroute(clusterState, "reroute");
            .settings(settings(Version.CURRENT))
        // now start all replicas too
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),
            assertThat(e.getMessage(), containsString("cannot be reused"));
            is(this.numberOfShards)
public class RoutingTableTests extends OpenSearchAllocationTestCase {
 * not use this file except in compliance with the License.
            final IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
        expectThrows(IllegalStateException.class, () -> indexRoutingTable.validate(metadata2));
        }
        clusterState = startInitializingShardsAndReroute(ALLOCATION_SERVICE, clusterState, index);
        startInitializingShards(TEST_INDEX_2);
        );
        assertEquals(numberOfShards, routingTable.index(TEST_INDEX_1).shardsWithState(UNASSIGNED).size());
            Version.CURRENT,
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),
        try {
        assertThat(
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
        );
    private int numberOfShards;
 * The OpenSearch Contributors require contributions made to
        Predicate<ShardRouting> predicate = s -> s.state() == ShardRoutingState.UNASSIGNED && s.unassignedInfo().isDelayed();
        Settings.builder()
    private static final String TEST_INDEX_1 = "test1";
                        .put(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true)
                    when(replicaShardRouting.state()).thenReturn(
            Boolean primaryUnassigned = allUnassigned || randomBoolean();
            b.build();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        indexMetadata = IndexMetadata.builder(indexName)
            List<ShardRouting> replicaShards = new ArrayList<>();
            .settings(settings(Version.CURRENT))
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(),
            is(this.numberOfShards)
import java.util.stream.Collectors;
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
        ShardRouting routing3 = TestShardRouting.newShardRouting(shardId, "node1", randomBoolean(), ShardRoutingState.STARTED);
            fail("Calling with non-existing index should be ignored at the moment");
        // starting primaries
            is(this.numberOfShards)
        final RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
            .numberOfReplicas(numberOfReplicas)
        assertThat(
        assertTrue(indexRoutingTable.validate(metadata));
                final ShardRouting primaryShard = shardTable.primaryShard();
 *
                new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_2).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_2)).build()
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
 *
import java.util.Arrays;
                indexShardRoutingTableMap,
        try {
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(ShardRouting::primary).size(), is(2));
        assertThat(
            .metadata(metadata)
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
            clusterState.routingTable().allShards(new String[] { TEST_INDEX_1, "not_exists" });
        try {
        );
        assertEquals(numberOfShards, routingTable.allShards(TEST_INDEX_1).size());
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(), is(this.shardsPerIndex));
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .add(
import org.opensearch.cluster.ClusterState;
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        assertThat(
import org.opensearch.repositories.IndexId;
            is(this.numberOfShards)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        assertThat(this.clusterState.routingTable().allShards().size(), is(this.totalNumberOfShards));
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            } else {
        int numberOfReplicas = randomIntBetween(0, 5);
                replicaShards.add(replicaShardRouting);
            } else {
                .settings(
import static org.hamcrest.Matchers.is;
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(predicate).size(), is(0));
        startInitializingShards(TEST_INDEX_1);
                Integer.MAX_VALUE
                }
    private int totalNumberOfShards;
            b.updateNumberOfReplicas(1, new String[] { "foo" });
        );
        ).build();
        assertThat(
 *
            final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.CLOSE).build();
            when(indexShardRoutingTable.replicaShards()).thenReturn(replicaShards);
        this.clusterState = ClusterState.builder(clusterState).nodes(discoBuilder).build();
        clusterState = ClusterState.builder(clusterState)
        startInitializingShards(TEST_INDEX_1);
        {
            final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).build();
        assertThat(
}
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .numberOfShards(this.numberOfShards);
            .settings(settings(Version.CURRENT))
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, true).size(),
            .numberOfShards(numShards + 1)
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        {
        } catch (IllegalStateException e) {
import java.util.List;
        startInitializingShards(TEST_INDEX_1);
                    .stream()
            Version.CURRENT,
    public void testAddAsRecovery() {
import org.opensearch.index.IndexNotFoundException;
        assertThat(clusterState.routingTable().shardsMatchingPredicateCount(predicate), is(0));
        assertEquals(numberOfShards, routingTable.allShards(TEST_INDEX_1).size());
        int unassignedShards = 0;
        try {
    }
                }
            .build();
            .build();
            .build();
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
        );
        for (IndexShardRoutingTable shardTable : indexRoutingTable) {
    /** reverse engineer the in sync aid based on the given indexRoutingTable **/
        b.build(); // Ok the first time
        Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap = new HashMap<>();
            is(this.shardsPerIndex)
        assertThat(clusterState.routingTable().indicesRouting().size(), is(2));
    public void testAddAsRemoteStoreRestoreWithActiveShards() {
                    when(replicaShardRouting.state()).thenReturn(UNASSIGNED);
            false,
    }
        // Verifies against all primary shards on the node
        initPrimaries();
    public void testAllActiveShardsGrouped() {
        }
            .metadata(metadata)
    private int shardsPerIndex;
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        this.numberOfReplicas = randomIntBetween(1, 5);
                        .put(indexMetadata.getSettings())
            indexShardRoutingTableMap,
        assertEquals(unassignedShards, routingTable.index(TEST_INDEX_1).shardsWithState(UNASSIGNED).size());
        logger.info("Setup test with {} shards and {} replicas.", this.numberOfShards, this.numberOfReplicas);
        assertThat(this.clusterState.routingTable().allShards(TEST_INDEX_1).size(), is(this.shardsPerIndex));
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),
    public void testRoutingTableBuiltMoreThanOnce() {
        assertThrows(
        assertThat(this.emptyRoutingTable.allActiveShardsGrouped(new String[0], false).size(), is(0));
    private Map<ShardId, IndexShardRoutingTable> getIndexShardRoutingTableMap(Index index, boolean allUnassigned, int numberOfReplicas) {
            indexMetadata,
        int numberOfShards = this.numberOfShards * (numberOfReplicas + 1);
    }
        } catch (IndexNotFoundException e) {
        try {
            .build();
            assertThat(routingTable.index(TEST_INDEX_1).shardsWithState(UNASSIGNED).size(), is(this.shardsPerIndex));
            final RoutingTable routingTable = new RoutingTable.Builder().addAsRecovery(indexMetadataBuilder.build()).build();
    public void testDistinctNodes() {
        assertThat(clusterState.routingTable().hasIndex(TEST_INDEX_1), is(true));
        Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
