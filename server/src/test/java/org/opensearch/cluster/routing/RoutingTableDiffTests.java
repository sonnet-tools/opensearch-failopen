import org.opensearch.Version;
        }
        }
            .updateNumberOfReplicas(this.numberOfReplicas + 1, new String[] { TEST_INDEX_1 })
        );
            is(expectedUnassignedShardCount + this.shardsPerIndex)
/*
    private void startInitializingShards(String index) {
    public void setUp() throws Exception {
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            .put(
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(this.numberOfShards));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
        return new IndexMetadata.Builder(indexName).settings(DEFAULT_SETTINGS)
            .numberOfReplicas(this.numberOfReplicas)
 *
            .updateNumberOfReplicas(this.numberOfReplicas - 1, new String[] { TEST_INDEX_1 })
            .routingTable(testRoutingTable)
        this.totalNumberOfShards = this.shardsPerIndex * 3;
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
        RoutingTable testRoutingTable = new RoutingTable.Builder().add(
        RoutingTable testRoutingTable = new RoutingTable.Builder(clusterState.routingTable()).add(
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            .updateNumberOfReplicas(this.numberOfReplicas + 1, new String[] { TEST_INDEX_1 })
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        initPrimaries();
        initPrimaries();
import org.opensearch.common.settings.Settings;
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
import org.opensearch.cluster.metadata.IndexMetadata;
            )
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
import static org.hamcrest.Matchers.is;
            discoBuilder = discoBuilder.add(newNode("node" + i));
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
            .metadata(metadata)
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
    public void testRoutingTableDeletes() {
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
        assertThat(
        initPrimaries();
    }
                ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(),
        );
        }
        metadata = Metadata.builder(metadata).put(createIndexMetadata(TEST_INDEX_3)).build();
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
    @Before
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_3).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_3)).build()
        this.numberOfReplicas = randomIntBetween(1, 5);
        );
            .updateNumberOfReplicas(this.numberOfReplicas - 1, new String[] { TEST_INDEX_1 })
        RoutingTable testRoutingTable = new RoutingTable.Builder(clusterState.routingTable()).add(
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
    public void testRoutingTableDiffWithReplicaAdded() {
            .numberOfShards(this.numberOfShards);
    public void testRoutingTableDiffWithReplicaRemoved() {
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
    }
        this.numberOfShards = randomIntBetween(1, 5);
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
    );
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        // start a random replica to change a single shard routing
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
        ClusterState oldClusterState = clusterState;
        }
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            is(expectedUnassignedShardCount - this.numberOfShards * this.numberOfReplicas)
        }
            .put("cluster.routing.allocation.node_concurrent_recoveries", Integer.MAX_VALUE) // don't limit recoveries
        );
     */
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        ClusterState oldClusterState = clusterState;
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
    private static final String TEST_INDEX_1 = "test1";
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", Integer.MAX_VALUE)
            .metadata(metadata)
            .build();
        // delete index routing table for TEST_INDEX_1
            .routingTable(testRoutingTable)
    public void testRoutingTableDiffsWithStartedState() {
            .build();
    private static final Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
    public void testRoutingTableUpserts() {
        metadata = Metadata.builder(metadata).put(createIndexMetadata(TEST_INDEX_3)).build();
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
    @Override
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected));
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
    }
        ).build();
        // create index routing table for TEST_INDEX_3
        ClusterState oldClusterState = clusterState;
        assertThat(rerouteResult, not(equalTo(this.clusterState)));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        this.totalNumberOfShards = this.shardsPerIndex * 3;
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(2 * this.numberOfShards));
            .metadata(metadata)
        }
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
 * The OpenSearch Contributors require contributions made to
                Integer.MAX_VALUE
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
        );
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable())
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
            .build();
            )
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;
            .routingTable(testRoutingTable)
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        );
        assertThat(
            .build();
            .build();
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
    private int numberOfShards;
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        assertThat(
            is(this.totalNumberOfShards - initializingExpected - this.numberOfShards)
    }
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
    }
 * compatible open source license.
    private int numberOfReplicas;
    private void initPrimaries() {
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
        initPrimaries();
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
        }
 */
        assertThat(
        RoutingTable testRoutingTable = new RoutingTable.Builder(clusterState.routingTable()).remove(TEST_INDEX_1).build();
public class RoutingTableDiffTests extends OpenSearchAllocationTestCase {
        int initializingExpected = this.numberOfShards + this.numberOfShards * this.numberOfReplicas;
        // update replica count for TEST_INDEX_1
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_1).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_1)).build()
            new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_3).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_3)).build()
        assertThat(
        }
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
        // create index routing table for TEST_INDEX_3
        initPrimaries();
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;
import org.opensearch.cluster.node.DiscoveryNodes;
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.STARTED).size(), is(2 * this.numberOfShards + 1));
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
            is(expectedUnassignedShardCount + this.numberOfShards)
    private int shardsPerIndex;
    private static final String TEST_INDEX_3 = "test3";
    }
        initPrimaries();
            is(this.totalNumberOfShards - initializingExpected - 2 * this.numberOfShards)
    private int totalNumberOfShards;
        assertThat(
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
    }
        }
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
import static org.hamcrest.Matchers.not;
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
import org.junit.Before;
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
import org.opensearch.cluster.Diff;
        assertThat(
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable())
        );
        metadata = Metadata.builder(metadata).put(createIndexMetadata(TEST_INDEX_3)).build();
import org.opensearch.cluster.ClusterState;
    private ClusterState clusterState;
            .add(
        this.clusterState = ClusterState.builder(clusterState).nodes(discoBuilder).build();
        Metadata metadata = Metadata.builder(clusterState.metadata())
        RoutingTable emptyRoutingTable = new RoutingTable.Builder().build();
        clusterState = startRandomInitializingShard(clusterState, ALLOCATION_SERVICE);
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
        // update replica count for TEST_INDEX_1
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;
        this.shardsPerIndex = this.numberOfShards * (this.numberOfReplicas + 1);
            is(this.totalNumberOfShards - 2 * this.numberOfShards)
        ClusterState rerouteResult = ALLOCATION_SERVICE.reroute(clusterState, "reroute");
    }
        this.totalNumberOfShards = this.shardsPerIndex;
            .build();
    }
            is(expectedUnassignedShardCount - this.numberOfShards)
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;
        assertThat(
            .build();
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
    /**
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
        startInitializingShards(TEST_INDEX_1);
        Settings.builder()
        clusterState = ClusterState.builder(clusterState).routingTable(updatedRoutingTable).metadata(metadata).build();
        }
        initPrimaries();
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(expectedUnassignedShardCount));
        logger.info("start primary shards for index {}", index);
import static org.hamcrest.Matchers.equalTo;
        for (int i = 0; i < this.numberOfReplicas + 1; i++) {
        ).build();
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
        )
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
                new IndexRoutingTable.Builder(metadata.index(TEST_INDEX_2).getIndex()).initializeAsNew(metadata.index(TEST_INDEX_2)).build()
        super.setUp();
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
    public void testRoutingTableUpsertsWithDiff() {
        );
        clusterState = startRandomInitializingShard(clusterState, ALLOCATION_SERVICE, TEST_INDEX_2);
    private IndexMetadata.Builder createIndexMetadata(String indexName) {
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
            .build()
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        this.totalNumberOfShards = this.shardsPerIndex * 2;
            .build();
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
        Diff<RoutingTable> fullDiff = clusterState.routingTable().diff(oldClusterState.getRoutingTable());
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
import org.opensearch.cluster.metadata.Metadata;
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
        clusterState = startInitializingShardsAndReroute(ALLOCATION_SERVICE, clusterState, index);
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
    private final AllocationService ALLOCATION_SERVICE = createAllocationService(
        Metadata metadata = Metadata.builder(clusterState.metadata())
        }
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
            .routingTable(testRoutingTable)
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        Diff<RoutingTable> incrementalDiff = clusterState.routingTable().incrementalDiff(oldClusterState.getRoutingTable());
    private static final String TEST_INDEX_2 = "test2";
    }
        ClusterState oldClusterState = clusterState;
        }
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
package org.opensearch.cluster.routing;
        }
        startInitializingShards(TEST_INDEX_2);
        int expectedUnassignedShardCount = this.totalNumberOfShards - 2 * this.numberOfShards;
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
import org.opensearch.cluster.routing.allocation.AllocationService;
        RoutingTable newRoutingTable = incrementalDiff.apply(oldClusterState.getRoutingTable());
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards));
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
        logger.info("Setup test with {} shards and {} replicas.", this.numberOfShards, this.numberOfReplicas);
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(initializingExpected - 1));
            assertEquals(indexRoutingTable, newRoutingTableWithFullDiff.index(indexRoutingTable.getIndex()));
            assertEquals(clusterState.routingTable().version(), newRoutingTableWithFullDiff.version());
        RoutingTable newRoutingTableWithFullDiff = fullDiff.apply(oldClusterState.getRoutingTable());
}
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
        Metadata metadata = Metadata.builder().put(createIndexMetadata(TEST_INDEX_1)).put(createIndexMetadata(TEST_INDEX_2)).build();
            is(expectedUnassignedShardCount + this.shardsPerIndex)
        ClusterState oldClusterState = clusterState;
 * SPDX-License-Identifier: Apache-2.0
        logger.info("adding {} nodes and performing rerouting", this.numberOfReplicas + 1);
     * puts primary shard indexRoutings into initializing state
            assertEquals(indexRoutingTable, newRoutingTable.index(indexRoutingTable.getIndex()));
            .metadata(metadata)
        initializingExpected = 2 * this.numberOfShards * this.numberOfReplicas;
            clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        this.clusterState = rerouteResult;
 * this file be licensed under the Apache-2.0 license or a
        // assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING).size(), is(2 * this.numberOfShards + 1));
        ClusterState oldClusterState = clusterState;
            .build();
        this.clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertEquals(clusterState.routingTable().version(), newRoutingTable.version());
        assertThat(clusterState.routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).size(), is(this.totalNumberOfShards));
