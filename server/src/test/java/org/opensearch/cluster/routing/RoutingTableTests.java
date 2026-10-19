        {  
        assertThrows(
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
                unassignedShards += indexShardRoutingTable.replicaShards().size() + 1;
        b.build(); // Ok the first time
            .numberOfShards(this.numberOfShards);
                ShardRouting replicaShardRouting = mock(ShardRouting.class);  
            final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.OPEN).build();  
     * puts primary shard indexRoutings into initializing state
            fail("Calling with non-existing index should be ignored at the moment");
    @Before  
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(indices, ShardRouting::primary).size(), is(2));
    );
    }  
    private int totalNumberOfShards;  
        assertThat(  
            )  
import java.util.Set;  
        assertEquals(numberOfShards, routingTable.allShards(TEST_INDEX_1).size());  
/*  
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(),  
    /** reverse engineer the in sync aid based on the given indexRoutingTable **/
            is(this.numberOfShards)
 * the Apache License, Version 2.0 (the "License"); you may
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
            .metadata(metadata)
            assertThat(e.getMessage(), containsString("cannot be reused"));
        assertThat(
    private final AllocationService ALLOCATION_SERVICE = createAllocationService(
            is(this.numberOfShards)
    public static IndexMetadata updateActiveAllocations(IndexRoutingTable indexRoutingTable, IndexMetadata indexMetadata) {
                    .stream()
        Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap = new HashMap<>();
            clusterState.routingTable()
                indexMetadata,
        );  
        }
        }  
        startInitializingShards(TEST_INDEX_1);
import static org.hamcrest.Matchers.nullValue;  
            is(this.numberOfShards)  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import org.opensearch.cluster.metadata.IndexMetadata;
        startInitializingShards(TEST_INDEX_1);  
        );
        assertFalse(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing1, routing2, routing3)));
        try {
            .build();
        assertFalse(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing1, routing3)));
    private IndexMetadata.Builder createIndexMetadata(String indexName) {
            IndexShardRoutingTable indexShardRoutingTable = mock(IndexShardRoutingTable.class);
            if (primaryUnassigned) {
        startInitializingShards(TEST_INDEX_2);
            fail("expected exception");
        final Metadata metadata3 = Metadata.builder().put(indexMetadata, true).build();  
 *
            final RoutingTable routingTable = new RoutingTable.Builder().addAsRecovery(indexMetadata).build();
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(), is(this.shardsPerIndex));
            .settings(settings(Version.CURRENT))
            // expected
        IndexMetadata.Builder imdBuilder = IndexMetadata.builder(indexMetadata);  
import static org.hamcrest.Matchers.not;
                when(primaryShardRouting.state()).thenReturn(UNASSIGNED);  
            .metadata(metadata)  
                        .put(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true)
            is(this.shardsPerIndex)
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(this.numberOfShards));  
    }
                        .put(indexMetadata.getSettings())  
            .metadata(metadata)
    }
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");  
                if (primaryShard.initializing() && primaryShard.recoverySource().getType() == RecoverySource.Type.EXISTING_STORE) {
            clusterState.routingTable().allShardsSatisfyingPredicate(indices, shardRouting -> !shardRouting.primary()).size(),
                    Settings.builder()
    public void testAllShardsMatchingPredicate() {
            "restore_uuid",
        assertThat(this.emptyRoutingTable.activePrimaryShardsGrouped(new String[0], true).size(), is(0));
                        unassignedShards += 1;
    private RoutingTable emptyRoutingTable;
        final RoutingTable routingTable = new RoutingTable.Builder().addAsRemoteStoreRestore(
        expectThrows(IllegalStateException.class, () -> indexRoutingTable.validate(metadata4));  
        final Metadata metadata2 = Metadata.builder().put(indexMetadata, true).build();
 * this file be licensed under the Apache-2.0 license or a
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import static org.mockito.Mockito.mock;
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
        assertThat(  
            .add(
        );  
        ShardRouting routing1 = TestShardRouting.newShardRouting(shardId, "node1", randomBoolean(), ShardRoutingState.STARTED);
        this.numberOfShards = randomIntBetween(1, 5);  
        this.emptyRoutingTable = new RoutingTable.Builder().build();
        Metadata metadata = Metadata.builder()
            IllegalStateException.class,  
 * specific language governing permissions and limitations
        );  
        for (IndexShardRoutingTable shardTable : indexRoutingTable) {
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        );  
            final RoutingTable routingTable = new RoutingTable.Builder().addAsRecovery(indexMetadata).build();
                false
                for (ShardRouting replicaShardRouting : indexShardRoutingTable.replicaShards()) {  
        );
        }
        ShardId shardId = new ShardId(new Index("index", "uuid"), 0);
        } catch (IndexNotFoundException e) {
        indexMetadata = IndexMetadata.builder(indexName)
            indexMetadata,
                        .build()
import org.opensearch.core.index.shard.ShardId;
            is(2 * this.numberOfShards)
    public void testAllActiveShardsGrouped() {
        Settings.builder()  
                Integer.MAX_VALUE
            for (ShardRouting shardRouting : shardTable) {
                new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_2).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_2)).build()  
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        final IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.OPEN)  
            .numberOfReplicas(numReplicas)
import java.util.HashMap;  
import org.opensearch.common.settings.Settings;  
 */  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        }  
            final IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
import java.util.stream.Collectors;
        );
        Predicate<ShardRouting> predicate = s -> s.state() == ShardRoutingState.UNASSIGNED && s.unassignedInfo().isDelayed();
        {
                .allShardsSatisfyingPredicate(shardRouting -> !shardRouting.primary() && !shardRouting.active())
        try {  
                remoteStoreRecoverySource,  
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
        assertThat(  
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());  
    }
            .build();  
    private static final String TEST_INDEX_1 = "test1";  
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
/*  
        // test wrong number of shards and replicas causes validation errors
    public void testShardsMatchingPredicateCount() {
        );  
import org.opensearch.cluster.routing.allocation.AllocationService;
    }
                );
        startInitializingShards(TEST_INDEX_1);
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),
        Builder discoBuilder = DiscoveryNodes.builder();
    }  
 * The OpenSearch Contributors require contributions made to  
        assertThat(  
            numberOfReplicas
    }
    }
        );
        final RemoteStoreRecoverySource remoteStoreRecoverySource = new RemoteStoreRecoverySource(
        assertThat(this.clusterState.routingTable().allShards(TEST_INDEX_1).size(), is(this.shardsPerIndex));  
        // now start all replicas too
            final RoutingTable routingTable = new RoutingTable.Builder().addAsRecovery(indexMetadataBuilder.build()).build();
        }
    public void testAddAsRemoteStoreRestoreShardMismatch() {
    private int numberOfShards;  
 * this work for additional information regarding copyright
    }
        final RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
    public void testRoutingTableBuiltMoreThanOnce() {  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
        initPrimaries();
            false
        Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
                    when(replicaShardRouting.state()).thenReturn(UNASSIGNED);
            is(this.totalNumberOfShards - 2 * this.numberOfShards)
            assertThat(routingTable.allShards(TEST_INDEX_1).size(), is(this.shardsPerIndex));  
/*
            .build();
                if (replicaUnassigned) {  
        } catch (IndexNotFoundException e) {  
    @Override
            .numberOfShards(numShards + 1)
                Boolean replicaUnassigned = allUnassigned || randomBoolean();
 */  
        int numberOfReplicas = randomIntBetween(0, 5);
    public void testShardsWithState() {
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),
import org.opensearch.core.index.Index;
        );
            // expected
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", Integer.MAX_VALUE)
                Set<String> insyncAids = shardTable.activeShards()  
            .settings(settings(Version.CURRENT))
        Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap = getIndexShardRoutingTableMap(
        }  
        assertThat(clusterState.routingTable().allShards(new String[] { TEST_INDEX_1 }).size(), is(this.shardsPerIndex));  
            when(primaryShardRouting.unassigned()).thenReturn(primaryUnassigned);
        }
            b.updateNumberOfReplicas(1, new String[] { "foo" });
public class RoutingTableTests extends OpenSearchAllocationTestCase {
 * GitHub history for details.
            assertThat(routingTable.index(TEST_INDEX_1).shardsWithState(UNASSIGNED).size(), is(this.shardsPerIndex));
        );  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
    }
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())
        );
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_2 }, false).size(),  
 * KIND, either express or implied.  See the License for the
            is(this.numberOfShards)
            .put(  
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),  
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),  
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),  
        }
        assertThat(clusterState.routingTable().allShards(new String[] { TEST_INDEX_1 }).size(), is(this.shardsPerIndex));  
import org.opensearch.index.IndexNotFoundException;  
    public void testAllShardsForMultipleIndices() {  
            ShardRouting primaryShardRouting = mock(ShardRouting.class);
        // Verifies against all replica shards on the node
        // Verifies against all primary shards on the node  
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(), is(this.shardsPerIndex));
            indexShardRoutingTableMap,
            fail("expected exception");
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());
        final int numShards = 1;
            "restore_uuid",  
            .settings(settings(Version.CURRENT))
        ShardRouting routing4 = TestShardRouting.newShardRouting(shardId, "node3", "node2", randomBoolean(), ShardRoutingState.RELOCATING);
        assertThat(  
        startInitializingShards(TEST_INDEX_1);
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        this.totalNumberOfShards = this.shardsPerIndex * 2;  
    private void initPrimaries() {  
import static org.mockito.Mockito.when;
        // Verifies a predicate which tests for inactive replicas
            final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.CLOSE).build();
import java.util.function.Predicate;
import org.opensearch.cluster.node.DiscoveryNodes;
        } catch (IllegalStateException e) {  
            .routingTable(testRoutingTable)
        assertThat(  
        // Verifies false against all shards on the node (active/inactive)
            indexMetadata,
        return imdBuilder.build();  
        assertThat(this.clusterState.routingTable().allShards().size(), is(this.totalNumberOfShards));
    }
            ).build()  
        clusterState = startInitializingShardsAndReroute(ALLOCATION_SERVICE, clusterState, index);
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())
        }  
        } catch (IllegalStateException e) {  
            expectThrows(IndexNotFoundException.class, () -> routingTable.allShards(TEST_INDEX_1));
        startInitializingShards(TEST_INDEX_2);
            .build();
        assertThat(clusterState.routingTable().allShards(new String[] { TEST_INDEX_1, TEST_INDEX_2 }).size(), is(this.totalNumberOfShards));  
        );
import java.util.ArrayList;
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, true).size(),
        final Metadata metadata4 = Metadata.builder().put(indexMetadata, true).build();
        assertThat(  
import static org.hamcrest.Matchers.equalTo;  
            }
    public void testHasIndex() {  
        clusterState = ClusterState.builder(clusterState)  
    private int shardsPerIndex;
        final RemoteStoreRecoverySource remoteStoreRecoverySource = new RemoteStoreRecoverySource(  
        // test wrong number of replicas causes validation errors  
        );
            for (int j = 0; j < numberOfReplicas; j++) {
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1, "not_exists" }, true);
        assertThat(clusterState.routingTable().shardsMatchingPredicateCount(predicate), is(2));
        startInitializingShards(TEST_INDEX_2);
        assertFalse(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing2, routing4)));
        } catch (IllegalStateException e) {  
                        activeInitializingStates.get(randomIntBetween(0, activeInitializingStates.size() - 1))
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        );  
        } catch (IndexNotFoundException e) {
        // make sure both replicas are marked as delayed (i.e. not reallocated)
            is(2)
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));  
            b.build();
        assertTrue(indexRoutingTable.validate(metadata));  
 *
        );
    public void testIndex() {
import java.util.Map;
        );  
    }  
        ClusterState rerouteResult = ALLOCATION_SERVICE.reroute(clusterState, "reroute");
 *     http://www.apache.org/licenses/LICENSE-2.0
        initPrimaries();
        assertThat(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();  
        this.clusterState = ClusterState.builder(clusterState).nodes(discoBuilder).build();  
import static org.hamcrest.Matchers.containsString;
    private int numberOfReplicas;
import java.util.List;
            remoteStoreRecoverySource,  
    }
            assertThat(routingTable.hasIndex(TEST_INDEX_1), is(true));  
    }
        final RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();  
            Boolean primaryUnassigned = allUnassigned || randomBoolean();  
}  
        logger.info("Setup test with {} shards and {} replicas.", this.numberOfShards, this.numberOfReplicas);
        );  
            fail("Exception expected when calling allShards() with non existing index name");  
            new IndexId(TEST_INDEX_1, "1")
            .numberOfReplicas(numberOfReplicas)
import org.opensearch.Version;
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, true).size(),
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),  
        // starting replicas
package org.opensearch.cluster.routing;
            .build();
        // starting primaries
        } catch (IndexNotFoundException e) {
            false
            fail("expected exception");
        logger.info("adding {} nodes and performing rerouting", this.numberOfReplicas + 1);
        assertThat(clusterState.routingTable().hasIndex("foobar"), is(false));
            indexMetadata.getIndex(),  
            indexMetadata.getIndex(),  
        return indexShardRoutingTableMap;  
                    if (replicaShardRouting.unassigned()) {
        assertThat(
            assertThat(routingTable.hasIndex(TEST_INDEX_1), is(false));  
        startInitializingShards(TEST_INDEX_2);  
        assertThat(
        int initializingExpected = this.numberOfShards + this.numberOfShards * this.numberOfReplicas;
            .numberOfShards(numShards)  
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_2 }, false).size(),
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),  
        initPrimaries();  
                .settings(
        assertThat(
        assertThat(
            is(2 * this.numberOfShards)
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(ShardRouting::primary).size(), is(2));
            }
                    );
                } else {
        clusterState = allocation.disassociateDeadNodes(clusterState, true, "reroute");
            .numberOfReplicas(numberOfReplicas)  
        assertThat(clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
            .build();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                }
            fail("Calling with non-existing index should be ignored at the moment");
            is(this.numberOfShards)
        for (IndexShardRoutingTable indexShardRoutingTable : indexShardRoutingTableMap.values()) {
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
            "restore_uuid",
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(shard -> false).size(), is(0));
 * under the License.  
            is(this.numberOfShards)  
 * software distributed under the License is distributed on an
            }
            is(this.totalNumberOfShards - initializingExpected - 2 * this.numberOfShards)
     */
    }
        indexMetadata = IndexMetadata.builder(indexName)
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected));
            final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).build();
        logger.info("start primary shards for index {}", index);
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(
        );
            () -> new RoutingTable.Builder().addAsRemoteStoreRestore(
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));  
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),
        );  
        assertThat(clusterState.routingTable().indicesRouting().size(), is(2));
 * Modifications Copyright OpenSearch Contributors. See
            .build();
        )
        );
    public void setUp() throws Exception {
    private ClusterState clusterState;  
import org.opensearch.cluster.routing.RecoverySource.RemoteStoreRecoverySource;  
            .build();
        // remove node2 and reroute  
 * Unless required by applicable law or agreed to in writing,
        {  
    }
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),
    public void testValidations() {  
        assertEquals(numberOfShards, routingTable.index(TEST_INDEX_1).shardsWithState(UNASSIGNED).size());
        MockAllocationService allocation = createAllocationService(Settings.EMPTY, new DelayedShardsMockGatewayAllocator());  
        );
        int numberOfShards = this.numberOfShards * (numberOfReplicas + 1);
    private Map<ShardId, IndexShardRoutingTable> getIndexShardRoutingTableMap(Index index, boolean allUnassigned, int numberOfReplicas) {  
            .build();
            .routingTable(RoutingTable.builder().addAsNew(metadata.index("test1")).addAsNew(metadata.index("test2")).build())  
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
 * SPDX-License-Identifier: Apache-2.0
            }
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(predicate).size(), is(0));
        int numberOfReplicas = randomIntBetween(0, 5);
        final String indexName = "test";
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(2 * this.numberOfShards));  
        // test no validation errors
            .build();  
    public void testActivePrimaryShardsGrouped() {  
import static org.hamcrest.Matchers.is;
            .build();  
        try {
        assertThat(  
        indexMetadata = updateActiveAllocations(indexRoutingTable, indexMetadata);  
        try {  
import org.junit.Before;
            .numberOfReplicas(numReplicas + 1)  
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(shard -> true).size(), is(4));  
        assertEquals(numberOfShards, routingTable.allShards(TEST_INDEX_1).size());  
import org.opensearch.cluster.ClusterState;
        return new IndexMetadata.Builder(indexName).settings(DEFAULT_SETTINGS)  
        assertThat(clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(), is(this.shardsPerIndex));
    }  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
    }
            .numberOfReplicas(numReplicas + 1)
        List<ShardRoutingState> activeInitializingStates = List.of(INITIALIZING, STARTED, RELOCATING);
        assertThat(clusterState.routingTable().hasIndex(TEST_INDEX_1), is(true));
        RoutingTable testRoutingTable = new RoutingTable.Builder().add(
        int unassignedShards = 0;
        assertThat(clusterState.routingTable().index("foobar"), is(nullValue()));
        assertThat(clusterState.routingTable().allShardsSatisfyingPredicate(predicate).size(), is(2));  
            assertThat(routingTable.hasIndex(TEST_INDEX_1), is(true));
    }  
                }  
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, false).size(),
            )
        Predicate<ShardRouting> predicate = s -> s.state() == ShardRoutingState.UNASSIGNED && s.unassignedInfo().isDelayed();
    private static final String TEST_INDEX_2 = "test2";
        assertTrue(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing1, routing4)));  
            .build();
        } catch (IndexNotFoundException e) {
    public void testAddAsRecovery() {
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(routingTable.hasIndex(TEST_INDEX_1));
    private static final Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        clusterState = allocation.reroute(clusterState, "reroute");  
        try {  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(this.emptyRoutingTable.allShards(new String[0]).size(), is(0));
            .settings(settings(Version.CURRENT))  
        indexShardRoutingTableMap.remove(indexShardRoutingTableMap.keySet().iterator().next());
        ShardRouting routing3 = TestShardRouting.newShardRouting(shardId, "node1", randomBoolean(), ShardRoutingState.STARTED);
            is(this.totalNumberOfShards - initializingExpected - this.numberOfShards)
        assertThat(this.emptyRoutingTable.allActiveShardsGrouped(new String[0], false).size(), is(0));
        assertThat(
        clusterState = ClusterState.builder(clusterState)  
        assertThat(  
        }
        );
        // remove node2 and reroute
            new IndexId(TEST_INDEX_1, "1")  
            .numberOfReplicas(numReplicas)
                    activeInitializingStates.get(randomIntBetween(0, activeInitializingStates.size() - 1))  
            is(this.shardsPerIndex)
 */
        try {  
            List<ShardRouting> replicaShards = new ArrayList<>();
        );
        }
        // starting primaries
        RoutingTable.Builder b = RoutingTable.builder();
import org.opensearch.cluster.metadata.Metadata;
            is(this.numberOfShards)
                .state(IndexMetadata.State.CLOSE)  
        assertThat(rerouteResult, not(equalTo(this.clusterState)));
            .build();
        initializingExpected = 2 * this.numberOfShards * this.numberOfReplicas;
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1 }, true).size(),  
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1, "not_exists" }, true);  
    public void testIndicesRouting() {
        // test wrong number of shards causes validation errors
            getIndexShardRoutingTableMap(indexMetadata.getIndex(), true, numberOfReplicas),
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
            remoteStoreRecoverySource,  
                    .collect(Collectors.toSet());  
            is(this.totalNumberOfShards)
        ).build();  
        final RoutingTable routingTable = new RoutingTable.Builder().addAsRemoteStoreRestore(
            assertThat(e.getMessage(), containsString("cannot be reused"));
 * license agreements. See the NOTICE file distributed with
        Map<ShardId, IndexShardRoutingTable> indexShardRoutingTableMap = getIndexShardRoutingTableMap(
        );
        final RemoteStoreRecoverySource remoteStoreRecoverySource = new RemoteStoreRecoverySource(  
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_1).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_1)).build()  
        assertTrue(IndexShardRoutingTable.Builder.distinctNodes(Arrays.asList(routing1, routing2)));  
        clusterState = allocation.reroute(clusterState, "reroute");  
            .numberOfShards(numShards)  
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected));
            when(indexShardRoutingTable.primaryShard()).thenReturn(primaryShardRouting);  
            discoBuilder = discoBuilder.add(newNode("node" + i));
                .size(),  
                when(primaryShardRouting.state()).thenReturn(
        final int numReplicas = randomIntBetween(0, 1);  
            } else {
                imdBuilder.putInSyncAllocationIds(shardRouting.id(), insyncAids);  
        Metadata metadata = Metadata.builder()
            true,
        String[] indices = new String[] { "test1", "test2" };
        startInitializingShards(TEST_INDEX_2);
        // Verifies true against all shards on the node (active/inactive)
            is(this.numberOfShards)
    }
        // make sure both replicas are marked as delayed (i.e. not reallocated)
            .numberOfShards(numShards + 1)
        try {
            assertThat(this.clusterState.routingTable().allShards("not_existing").size(), is(0));
        assertTrue(routingTable.hasIndex(TEST_INDEX_1));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
    public void testAddAsRemoteStoreRestoreAllUnassigned() {  
        clusterState = ClusterState.builder(clusterState)
                )  
        try {  
 *  
        } catch (IllegalStateException e) {  
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
    public void testAllShards() {
    public void testAllShardsMatchingPredicateWithSpecificIndices() {
        initPrimaries();
                }
            numberOfReplicas
            .metadata(metadata)  
        assertThat(
import org.opensearch.repositories.IndexId;
import java.util.Arrays;
            .build();
 * not use this file except in compliance with the License.
                replicaShards.add(replicaShardRouting);
        initPrimaries();
        for (int i = 0; i < this.numberOfShards; i++) {  
            fail("Calling with non-existing index name should raise IndexMissingException");
            .build();
        ShardRouting routing2 = TestShardRouting.newShardRouting(shardId, "node2", randomBoolean(), ShardRoutingState.STARTED);  
        assertThat(
        assertThat(clusterState.routingTable().allShards(new String[] { TEST_INDEX_1 }).size(), is(this.shardsPerIndex));  
            Version.CURRENT,
            Version.CURRENT,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
        final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.OPEN)  
                when(replicaShardRouting.unassigned()).thenReturn(replicaUnassigned);
            if (indexShardRoutingTable.primaryShard().unassigned()) {  
        }
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    }
        }
            fail("Calling with non-existing index should be ignored at the moment");
        assertThat(  
        assertEquals(unassignedShards, routingTable.index(TEST_INDEX_1).shardsWithState(UNASSIGNED).size());
        try {
        Metadata metadata = Metadata.builder()  
        );  
        final IndexMetadata indexMetadata = createIndexMetadata(TEST_INDEX_1).state(IndexMetadata.State.OPEN)
        this.shardsPerIndex = this.numberOfShards * (this.numberOfReplicas + 1);
                    // simulate a primary was initialized based on aid  
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1, TEST_INDEX_2 }, true).size(),
    public void testDistinctNodes() {  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node2")).build();
            .numberOfReplicas(numberOfReplicas)
        assertThat(clusterState.routingTable().shardsMatchingPredicateCount(predicate), is(0));  
            is(2 * this.numberOfShards)
    public void testAddAsRemoteStoreRestoreWithActiveShards() {
        assertThat(clusterState.routingTable().getIndicesRouting().size(), is(2));  
            .put("cluster.routing.allocation.node_concurrent_recoveries", Integer.MAX_VALUE) // don't limit recoveries
            b.remove("foo");
        expectThrows(IllegalStateException.class, () -> indexRoutingTable.validate(metadata2));
        assertThat(clusterState.routingTable().index(TEST_INDEX_1).getIndex().getName(), is(TEST_INDEX_1));  
        int numberOfShards = this.numberOfShards * (numberOfReplicas + 1);
                    when(replicaShardRouting.state()).thenReturn(  
            is(2 * this.numberOfShards)  
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();  
            Version.CURRENT,
    public void testAllAssignedShardsGrouped() {  
            .build();
        startInitializingShards(TEST_INDEX_1);
        int numberOfReplicas = randomIntBetween(0, 5);
            indexShardRoutingTableMap.put(new ShardId(index, i), indexShardRoutingTable);
        assertThat(clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(), is(0));
 * You may obtain a copy of the License at  
            assertThat(routingTable.allShards(TEST_INDEX_1).size(), is(this.shardsPerIndex));
        for (int i = 0; i < this.numberOfReplicas + 1; i++) {  
            .build();
            clusterState.routingTable().allActiveShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(),  
            clusterState.routingTable().activePrimaryShardsGrouped(new String[] { TEST_INDEX_1 }, false).size(),
            is(this.numberOfShards)
    }
                    insyncAids.add(primaryShard.allocationId().getId());
        super.setUp();
                    .map(shr -> shr.allocationId().getId())
    private void startInitializingShards(String index) {  
            b.add((IndexRoutingTable) null);
            is(this.totalNumberOfShards)
                    }  
            assertThat(e.getMessage(), containsString("cannot be reused"));
            when(indexShardRoutingTable.replicaShards()).thenReturn(replicaShards);  
        }
        // Verifies against all primary shards on the node  
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        );  
        this.clusterState = rerouteResult;  
        assertThat(this.emptyRoutingTable.allActiveShardsGrouped(new String[0], true).size(), is(0));  
            clusterState.routingTable().allShards(new String[] { TEST_INDEX_1, "not_exists" });  
        assertThat(this.emptyRoutingTable.activePrimaryShardsGrouped(new String[0], false).size(), is(0));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(this.totalNumberOfShards));
            } else {
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
            is(2)
 * compatible open source license.
        indexMetadata = IndexMetadata.builder(indexName)  
            .build();
            is(this.numberOfShards)
        assertThat(
        assertThat(
            .build()
        clusterState = allocation.reroute(clusterState, "reroute");
            new IndexId(TEST_INDEX_1, "1")  
        }  
            false,
        assertSame(clusterState.routingTable().getIndicesRouting(), clusterState.routingTable().indicesRouting());
            assertThat(e.getMessage(), containsString("cannot be reused"));
    /**  
        expectThrows(IllegalStateException.class, () -> indexRoutingTable.validate(metadata3));
        );  
                indexShardRoutingTableMap,
        // starting replicas  
            assertThat(routingTable.index(TEST_INDEX_1).shardsWithState(UNASSIGNED).size(), is(this.shardsPerIndex));
                final ShardRouting primaryShard = shardTable.primaryShard();
            clusterState.routingTable().allAssignedShardsGrouped(new String[] { TEST_INDEX_1, "not_exists" }, false);  
            .numberOfReplicas(this.numberOfReplicas)
                .settingsVersion(indexMetadata.getSettingsVersion() + 1);
    }
        );
        assertThat(this.emptyRoutingTable.allShards().size(), is(0));  
        this.numberOfReplicas = randomIntBetween(1, 5);
            fail("expected exception");
        ).build();  
        assertThat(  
        }  
