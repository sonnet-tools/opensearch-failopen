        ClusterState oldClusterState = clusterState;
        initPrimaries();
        startInitializingShards(TEST_INDEX_2);  
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
            )
            is(this.totalNumberOfShards - initializingExpected - this.numberOfShards)  
        clusterState = startInitializingShardsAndReroute(ALLOCATION_SERVICE, clusterState, index);  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
        }
    }  
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());  
    private int numberOfShards;
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        }
        );  
        assertThat(
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
        this.totalNumberOfShards = this.shardsPerIndex * 2;
import org.opensearch.cluster.routing.allocation.AllocationService;
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
        // create index routing table for TEST_INDEX_3  
import org.opensearch.cluster.metadata.IndexMetadata;
            is(expectedUnassignedShardCount - this.numberOfShards * this.numberOfReplicas)
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));  
    @Before
            .updateNumberOfReplicas(this.numberOfReplicas + 1, new String[] { TEST_INDEX_1 })
            )
        metadata = Metadata.builder(metadata).put(createIndexMetadata(TEST_INDEX_3)).build();
        logger.info("adding {} nodes and performing rerouting", this.numberOfReplicas + 1);
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
        // assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards + 1));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected));  
        // start a random replica to change a single shard routing  
        initPrimaries();  
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        for (int i = 0; i < this.numberOfReplicas + 1; i++) {
        startInitializingShards(TEST_INDEX_1);  
        this.shardsPerIndex = this.numberOfShards * (this.numberOfReplicas + 1);  
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
        }
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());  
    }
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));  
    }
            .build();
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
    }
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
        ClusterState oldClusterState = clusterState;
        initPrimaries();
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        ).build();
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(2 * this.numberOfShards + 1));  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
        assertThat(
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected));  
        ClusterState oldClusterState = clusterState;
    private IndexMetadata.Builder createIndexMetadata(String indexName) {  
        this.clusterState = ClusterState.builder(clusterState).nodes(discoBuilder).build();
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable())
import static org.hamcrest.Matchers.is;
        initializingExpected = 2 * this.numberOfShards * this.numberOfReplicas;
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
    private static final Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
            .numberOfShards(this.numberOfShards);  
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
        metadata = Metadata.builder(metadata).put(createIndexMetadata(TEST_INDEX_3)).build();
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
 * SPDX-License-Identifier: Apache-2.0
            is(this.totalNumberOfShards - initializingExpected - 2 * this.numberOfShards)  
            .metadata(metadata)
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_3).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_3)).build()  
import org.opensearch.cluster.ClusterState;
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
        assertThat(  
            .put(
    private static final String TEST_INDEX_1 = "test1";
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));  
    public void testRoutingTableDiffWithReplicaAdded() {
        logger.info("start primary shards for index {}", index);
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
            is(expectedUnassignedShardCount - this.numberOfShards)
    @Override  
    private int shardsPerIndex;  
}  
    private static final String TEST_INDEX_3 = "test3";  
            is(expectedUnassignedShardCount + this.shardsPerIndex)  
        );
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));  
import org.opensearch.cluster.Diff;  
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());  
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;  
    private int numberOfReplicas;
    public void testRoutingTableDeletes() {
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
            .routingTable(testRoutingTable)  
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
            .build();  
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_3).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_3)).build()  
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());  
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", Integer.MAX_VALUE)  
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());  
    }
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
    }
        initPrimaries();
import org.opensearch.cluster.metadata.Metadata;  
    /**
        logger.info("Setup test with {} shards and {} replicas.", this.numberOfShards, this.numberOfReplicas);
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));  
        }  
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());  
        super.setUp();  
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        RoutingTable emptyRoutingTable = new RoutingTable.Builder().build();  
    public void testRoutingTableDiffWithReplicaRemoved() {
        // update replica count for TEST_INDEX_1
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(this.numberOfShards));
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
            discoBuilder = discoBuilder.add(newNode("node" + i));
            .routingTable(testRoutingTable)
        ).build();
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
import org.opensearch.common.settings.Settings;
            .add(  
        // update replica count for TEST_INDEX_1  
            .build();  
    public void setUp() throws Exception {
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        assertThat(  
        metadata = Metadata.builder(metadata).put(createIndexMetadata(TEST_INDEX_3)).build();
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected - 1));
        assertThat(rerouteResult, not(equalTo(this.clusterState)));  
        RoutingTable testRoutingTable = new RoutingTable.Builder(clusterState.routingTable()).add(
            is(expectedUnassignedShardCount + this.numberOfShards)
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(  
            .build();  
        }  
import static org.hamcrest.Matchers.not;  
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();  
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;  
        );  
        }
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        Metadata metadata = Metadata.builder(clusterState.metadata())
        ClusterState oldClusterState = clusterState;
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(2 * this.numberOfShards));
        ClusterState rerouteResult = ALLOCATION_SERVICE.reroute(clusterState, "reroute");
    );  
    public void testRoutingTableUpserts() {  
    }
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
            .metadata(metadata)  
    private void startInitializingShards(String index) {
        RoutingTable testRoutingTable = new RoutingTable.Builder().add(  
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());  
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
    public void testRoutingTableUpsertsWithDiff() {  
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));  
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable())
        ClusterState oldClusterState = clusterState;
        RoutingTable testRoutingTable = new RoutingTable.Builder(clusterState.routingTable()).add(
        }
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
import static org.hamcrest.Matchers.equalTo;
        }
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;
            .build()
        this.numberOfShards = randomIntBetween(1, 5);
            .updateNumberOfReplicas(this.numberOfReplicas - 1, new String[] { TEST_INDEX_1 })  
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));  
        assertThat(
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
            .build();
            .numberOfReplicas(this.numberOfReplicas)
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // delete index routing table for TEST_INDEX_1
        }
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
        initPrimaries();
        ClusterState oldClusterState = clusterState;
    private void initPrimaries() {
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
            .metadata(metadata)
        return new IndexMetadata.Builder(indexName).settings(DEFAULT_SETTINGS)
            .build();
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
        }  
            .build();
        );
        this.clusterState = rerouteResult;
        );  
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
 *
        clusterState = startRandomInitializingShard(clusterState, ALLOCATION_SERVICE, TEST_INDEX_2);  
        assertThat(
        }  
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
public class RoutingTableDiffTests extends OpenSearchAllocationTestCase {
import org.junit.Before;
            .updateNumberOfReplicas(this.numberOfReplicas + 1, new String[] { TEST_INDEX_1 })
        );
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
            .metadata(metadata)  
/*  
        clusterState = startRandomInitializingShard(clusterState, ALLOCATION_SERVICE);
        this.numberOfReplicas = randomIntBetween(1, 5);
package org.opensearch.cluster.routing;
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());  
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
            .put("cluster.routing.allocation.node_concurrent_recoveries", Integer.MAX_VALUE) // don't limit recoveries
 * The OpenSearch Contributors require contributions made to  
        this.totalNumberOfShards = this.shardsPerIndex;
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());  
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();  
        this.totalNumberOfShards = this.shardsPerIndex * 3;  
        assertThat(
 */  
        initPrimaries();
            is(expectedUnassignedShardCount + this.shardsPerIndex)  
     */  
    }
    private static final String TEST_INDEX_2 = "test2";
     * puts primary shard indexRoutings into initializing state
    public void testRoutingTableDiffsWithStartedState() {  
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();  
            .build();
import org.opensearch.Version;
        // create index routing table for TEST_INDEX_3  
    private final AllocationService ALLOCATION_SERVICE = createAllocationService(  
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));  
            .routingTable(testRoutingTable)
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
        Settings.builder()
        this.totalNumberOfShards = this.shardsPerIndex * 3;  
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
                Integer.MAX_VALUE  
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));  
                new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_2).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_2)).build()
        RoutingTable testRoutingTable = new RoutingTable.Builder(clusterState.routingTable()).remove(TEST_INDEX_1).build();  
            is(this.totalNumberOfShards - 2 * this.numberOfShards)
        )
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
        }  
            .updateNumberOfReplicas(this.numberOfReplicas - 1, new String[] { TEST_INDEX_1 })  
    }
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_1).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_1)).build()
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
        );
        );
    private ClusterState clusterState;
 * compatible open source license.
import org.opensearch.cluster.node.DiscoveryNodes;
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),  
        }
        Metadata metadata = Metadata.builder(clusterState.metadata())
            .build();
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        initPrimaries();  
    private int totalNumberOfShards;
        int initializingExpected = this.numberOfShards + this.numberOfShards * this.numberOfReplicas;
            .routingTable(testRoutingTable)  
