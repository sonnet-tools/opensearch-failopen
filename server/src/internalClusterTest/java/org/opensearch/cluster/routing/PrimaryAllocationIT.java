        );
import java.util.stream.Stream;
 *
        for (int i = 0; i < numDocs; i++) {
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
import org.opensearch.test.InternalTestCluster;
        logger.info("--> create single shard index");
        internalCluster().startDataOnlyNodes(2);
            .map(shard -> shard.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY))
        });
        });
                clusterStateChangeLatch.countDown();
                .prepareUpdateSettings()
        assertEquals(
 * compatible open source license.
    public void testForceStaleReplicaToBePromotedToPrimary() throws Exception {
        logger.info("--> isolating some replicas during primary-replica resync");
import org.opensearch.core.common.Strings;
                        .put("index.number_of_replicas", 1)
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        assertAcked(
                .indices()
        ensureStableCluster(2, clusterManager);
        ClusterState state = client().admin().cluster().prepareState().all().get().getState();
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
        );
                () -> assertTrue(
import java.util.concurrent.TimeUnit;
        final String node = internalCluster().startNode();
                .size()
import org.opensearch.gateway.GatewayAllocator;
            equalTo(2)
        ensureGreen("test");
        );
            .setSettings(
        final ClusterService clusterService = internalCluster().getInstance(ClusterService.class, clusterManager);
            () -> assertTrue(
        assertThat(
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
 */
                .prepareUpdateSettings()
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1))
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(1), nodes.get(2)));
        );
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
                    .put("index.number_of_shards", 1)
        internalCluster().startDataOnlyNodes(2);
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "_name", node))
                .get()
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();
            for (ShardRouting activeShard : shardRoutingTable.activeShards()) {
        assertEquals(2, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());
import static org.hamcrest.Matchers.equalTo;
                .prepareCreate("test")
            .setWaitForActiveShards(ActiveShardCount.NONE)
        logger.info("--> starting 1 node");
                .getState()
        assertBusy(() -> {
                .getState()
            logger.info("expected allocation ids: {} actual allocation ids: {}", expectedAllocationIds, allocationIds);
        // testForceStaleReplicaToBePromotedToPrimary replies on the flushing when a shard is no longer assigned.
import java.util.Collections;
        internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        assertThat(newHistoryUUIds, hasSize(1));
                .get()
        assertThat(bulkResponse.getItems()[1].getResponse().getResult(), equalTo(DocWriteResponse.Result.UPDATED));
            )
import static org.hamcrest.Matchers.not;
        final ClusterStateListener clusterStateListener = event -> {
        logger.info("--> starting 3 nodes");
            prepareCreate(
                .setSettings(
        );
import org.opensearch.test.InternalSettingsPlugin;
                .add(new AllocateStalePrimaryAllocationCommand(idxName, shardId, nodeWithoutData, true))
        long numDocs = scaledRandomIntBetween(5, 50);
                .indices()
                "test",
        );
/*
import java.util.Map;
        NetworkDisruption partition = new NetworkDisruption(
        final Set<String> replicasSide2 = Sets.difference(replicaNodes, replicasSide1);
        assertEquals(2, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());
            logger.info("--> adding allocation command for shard {}", shardId);
    @Override
    // returns data paths settings of in-sync shard copy
            replicaNode = state.getRoutingNodes().node(shards.get(1).currentNodeId()).node().getName();
                .indices()
        );
            .map(shard -> shard.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY))
            }
        );
                .primaryShard()
            assertThat(shardStat.getCommitStats().getNumDocs(), equalTo(useStaleReplica ? 1 : 0));
            Collections.singleton(state.routingTable().index(idxName).shard(0).primary.allocationId().getId()),
                .prepareReroute()
        assertAcked(
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        );
        internalCluster().startDataOnlyNode(inSyncDataPathSettings);
        assertThat(nodeNames, hasSize(1));
        final String idxName = "test";
        ensureGreen("test");
            IllegalArgumentException.class,
 * ownership. Elasticsearch licenses this file to you under
        nodeNames.remove(clusterManager);
        createStaleReplicaScenario(clusterManager);
            .actionGet();
        ensureYellow("test");
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;
            final IndexShardRoutingTable shardRoutingTable = state.routingTable().shardRoutingTable(shardId);
        }
        }, 1, TimeUnit.MINUTES);
 * You may obtain a copy of the License at
        Throwable iae = expectThrows(
                .get()
        return inSyncDataPathSettings;
        ShardStats[] shardStats = client().admin()
 * license agreements. See the NOTICE file distributed with
            NetworkDisruption.DISCONNECT
            // When invoking AllocateEmptyPrimaryAllocationCommand, due to the UnassignedInfo.Reason being changed to INDEX_CREATION,
        );
    public void testPrimaryReplicaResyncFailed() throws Exception {
                    Settings.builder()
            () -> client().admin()
import java.util.Collection;
                .getReason(),
                .indices()
    }
            public boolean clearData(String nodeName) {
        logger.info("--> check that the up-to-date primary shard gets promoted and that documents are available");
        logger.info("--> creating index with 1 primary and 0 replicas");
                )
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.enable", "none"))
import org.opensearch.action.support.IndicesOptions;
                .getShards()
            .prepareShardStores(idxName)
            .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED)
import org.opensearch.common.settings.Settings;
        assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2L);
            ? Collections.singleton(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID)
        internalCluster().setDisruptionScheme(partition);
                .cluster()
import static org.hamcrest.Matchers.hasSize;
            final String newPrimaryNode = state.getRoutingNodes().node(shardRoutingTable.primary.currentNodeId()).node().getName();
        partition.stopDisrupting();
        ensureYellow("test");
        ensureGreen();
 * Licensed to Elasticsearch under one or more contributor
        assertBusy(
        client().admin()
        final Settings inSyncDataPathSettings = internalCluster().dataPathSettings(replicaNode);
import org.opensearch.test.transport.MockTransportService;
            assertThat(state.routingTable().shardRoutingTable(shardId).activeShards(), hasSize(numberOfReplicas));
                .get()
        assertThat(
            assertThat(state.metadata().index("test").inSyncAllocationIds(shardId.id()), hasSize(numberOfReplicas + 1));
        internalCluster().assertSeqNos();
    }
        assertAcked(
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();
 *
            .get(idxName);
            () -> client().admin()
        );
import org.opensearch.action.support.ActiveShardCount;
    }
                return true;
import org.opensearch.action.DocWriteResponse;
        // allocation id of old primary was cleaned from the in-sync set
                .prepareCreate(idxName)
        internalCluster().restartRandomDataNode();
        internalCluster().setDisruptionScheme(partition);
            client().admin()
        ensureGreen("test");
                .get()
        );
        assertEquals(1, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());
        final String nodeWithoutData = randomFrom(dataNodes);
    }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(oldPrimary));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        logger.info("--> check that the stale primary shard gets allocated and that documents are available");
        internalCluster().startDataOnlyNodes(1);
        assertThat(bulkResponse.getItems()[1].getResponse().getId(), equalTo("1"));
import static org.hamcrest.Matchers.in;
        if (shards.get(0).primary()) {
    /**
        client(clusterManager).admin().cluster().prepareReroute().get();
        EngineTestCase.generateNewSeqNo(IndexShardTestCase.getEngine(oldPrimaryShard)); // Make gap in seqno.
 *
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
                        .put("index.number_of_shards", 1)
        assertThat(newHistoryUUIds, everyItem(is(not(in(historyUUIDs)))));
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
    public void testDoNotRemoveAllocationIdOnNodeLeave() throws Exception {
        logger.info("--> index a document into previous replica shard (that is now primary)");
            IllegalArgumentException.class,
                assertThat(state.getRoutingNodes().node(activeShard.currentNodeId()).node().getName(), is(in(selectedPartition)));
                    client().admin().cluster().prepareState().get().getState().routingTable().index(idxName).allPrimaryShardsActive()
        final String indexName = "test-idx";
 * specific language governing permissions and limitations
        client(replicaNode).prepareIndex("test").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();
        assertEquals(
package org.opensearch.cluster.routing;
     * This test asserts that replicas failed to execute resync operations will be failed but not marked as stale.
        final String idxName = "test";
 * the Apache License, Version 2.0 (the "License"); you may
            assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(0));
                    .put("index.routing.allocation.exclude._name", node)
import java.util.stream.Collectors;
                assertThat(shard.getLocalCheckpoint(), equalTo(numDocs + moreDocs));
        final String dataNode = internalCluster().startDataOnlyNode();
import org.opensearch.index.engine.EngineTestCase;
        internalCluster().startDataOnlyNode(Settings.EMPTY);
        List<ShardRouting> shards = state.routingTable().allShards("test");
                .prepareCreate(indexName)
        internalCluster().startDataOnlyNodes(2);
                        .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
                .setSettings(
                .getReason(),
        );
        assertTrue(clusterStateChangeLatch.await(30, TimeUnit.SECONDS));
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
            Set<String> selectedPartition = replicasSide1.contains(newPrimaryNode) ? replicasSide1 : replicasSide2;
        assertThat(bulkResponse.getItems()[0].getResponse().getId(), equalTo("1"));
        logger.info("--> wait until shard is failed and becomes unassigned again");
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            final Set<String> allocationIds = event.state().metadata().index(idxName).inSyncAllocationIds(0);
        );
            () -> client().admin()
        assertAcked(
                .cluster()
                .prepareCreate("test")
        logger.info("--> partitioning node with primary shard from rest of cluster");
        ensureGreen();
/*
            client().admin()
            .prepareCreate("test")
                .indices()
            client().admin().cluster().prepareState().get().getState().getRoutingTable().index("test").allPrimaryShardsUnassigned()
            assertThat(indexResult.getShardInfo().getSuccessful(), equalTo(numberOfReplicas + 1));
        final String replicaNode;
        ensureGreen("test");
        assertTrue(
                .indices()
                .prepareCreate("test")
            .get()
                .get(0)
            client().admin()
            : Collections.emptySet();
            )
        assertAcked(
                .get()
            .get(shardId)
        ensureYellow("test");
        boolean useStaleReplica = randomBoolean(); // if true, use stale replica, otherwise a completely empty copy
        Set<String> historyUUIDs = Arrays.stream(client().admin().indices().prepareStats("test").clear().get().getShards())
            .indices()
                .unassignedInfo()
                .prepareCreate("test")
import java.util.concurrent.ExecutionException;
        final Settings inSyncDataPathSettings = internalCluster().dataPathSettings(replicaNode);
                .prepareState()
            1,
                        .put("index.number_of_shards", 1)
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
                .indices()
        final IndexShard oldPrimaryShard = internalCluster().getInstance(IndicesService.class, oldPrimary).getShardOrNull(shardId);
            iae.getMessage(),
                .get()
            .get(idxName)
import java.util.ArrayList;
        );
            client().admin().cluster().prepareState().get().getState().getRoutingTable().shardRoutingTable("test", 0).assignedShards(),
        );
            IndexNotFoundException.class,
        ensureStableCluster(2, clusterManager);
        assertAcked(
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
     * This test ensures that for an unassigned primary shard that has a valid shard copy on at least one node,
import static org.hamcrest.Matchers.is;
        clusterService.addListener(clusterStateListener);
        logger.info(Strings.toString(MediaTypeRegistry.JSON, bulkResponse, true, true));
            state.metadata().index(idxName).inSyncAllocationIds(0)
                        .put("index.number_of_shards", 1)
        assertEquals(1, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());
        ensureGreen(indexName);
        assertThat(iae.getMessage(), equalTo("No data for shard [0] of index [test] found on any node"));
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        .put("index.number_of_replicas", 1)
            assertThat(shardRoutingTable.activeShards(), hasSize(selectedPartition.size()));
                .indices()
        logger.info("--> full cluster restart");
 * Modifications Copyright OpenSearch Contributors. See
/*
            // force allocation based on node id
                )
        assertThat(
                .setSettings(Settings.builder().put("index.number_of_shards", randomIntBetween(1, 3)).put("index.number_of_replicas", 2))
            client(clusterManager).admin().cluster().prepareReroute().get().getState().getRoutingNodes().unassigned().size(),
        };
    public void testForceAllocatePrimaryOnNoDecision() throws Exception {
        );
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1))
    public void testDoNotAllowStaleReplicasToBePromotedToPrimary() throws Exception {
                .prepareState()
                .get()
            client().admin()
            .indices()
import org.opensearch.action.admin.indices.stats.ShardStats;
                .prepareCreate(idxName)
        ensureStableCluster(1);
        ensureGreen();
                        .put("index.unassigned.node_left.delayed_timeout", "0ms")
        logger.info("--> force allocation of stale copy to node that does not have shard copy");
                .get()
    }
            equalTo(UnassignedInfo.Reason.NODE_LEFT)
        logger.info("--> indexing...");
                .unassignedInfo()
            }
            }
        assertThat(
                .cluster()
            assertThat(newPrimaryNode, not(equalTo(oldPrimary)));
                .get()
                    .put("index.number_of_replicas", 0)
                client().admin().cluster().prepareState().get().getState().getRoutingTable().index("test").allPrimaryShardsUnassigned()
    protected boolean addMockInternalEngine() {
        BulkResponse bulkResponse = client().prepareBulk()
                .add(new AllocateStalePrimaryAllocationCommand(idxName, 0, dataNode, true))
    }
                .cluster()
            assertBusy(
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
            () -> assertTrue(
                client().admin().cluster().prepareState().get().getState().getRoutingTable().index("test").allPrimaryShardsUnassigned()
                        .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(1), nodes.get(2)));
            empty()
        assertBusy(
        assertEquals(2, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());
            primaryNode = state.getRoutingNodes().node(shards.get(1).currentNodeId()).node().getName();
                .isAcknowledged()
        logger.info("--> starting 3 nodes, 1 cluster-manager, 2 data");
        partition.startDisrupting();
        // Checks that we fails replicas in one side but not mark them as stale.
        final List<String> nodeNames = new ArrayList<>(Arrays.asList(internalCluster().getNodeNames()));
        IllegalArgumentException iae = expectThrows(
        ensureYellow(idxName);
            client().admin()
import org.opensearch.index.shard.IndexShardTestCase;
        );
        ensureStableCluster(2);
        assertBusy(
            @Override
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
        }
                .prepareState()
     * a NO decision to allocate.
                .get()
                .get()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .get()
                .prepareReroute()
import java.util.concurrent.CountDownLatch;
                        .put("index.number_of_replicas", 1)
                .indices()
import static org.hamcrest.Matchers.empty;
        assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 1L);
                .prepareReroute()
        logger.info("--> starting node that reuses data folder with the up-to-date shard");
 * The OpenSearch Contributors require contributions made to
        } else {
        logger.info("--> explicitly promote old primary shard");
            }
        rerouteBuilder.get();
        Throwable iae = expectThrows(
            .get();
        }, 30, TimeUnit.SECONDS);
        logger.info("--> stop disrupting network and re-enable allocation");
    }
    }
                .setPersistentSettings(Settings.builder().put("indices.replication.retry_timeout", timeout))
            .prepareShardStores(idxName)
        logger.info("--> check that old primary shard does not get promoted to primary again");
                    Settings.builder()
        );
            client().admin()
    }
            .prepareStats("test")
            IndicesShardStoresResponse.StoreStatus storeStatus = randomFrom(shardStoreStatuses.getValue());
import org.opensearch.action.bulk.BulkResponse;
import java.util.Set;
            .collect(Collectors.toSet());
import org.opensearch.test.disruption.NetworkDisruption;
            client().admin()
                Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
                .get()
        );
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(1L));
            .collect(Collectors.toSet());
            IndexResponse indexResult = index("test", "doc", Long.toString(numDocs + i));
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(2L));
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        logger.info("--> starting 3 nodes, 1 cluster-manager, 2 data");
        }
import java.util.HashSet;
                .prepareCreate("test")
     */
        final CountDownLatch clusterStateChangeLatch = new CountDownLatch(1);
            () -> client().admin()
        logger.info("--> removing 2 nodes from cluster");
        clusterService.removeListener(clusterStateListener);
            }
                .cluster()
            replicaNode = state.getRoutingNodes().node(shards.get(0).currentNodeId()).node().getName();
                .index(indexName)
            );
            client().admin()
                .get()
import java.util.Arrays;
        ensureGreen("test");
import org.opensearch.indices.IndicesService;
public class PrimaryAllocationIT extends OpenSearchIntegTestCase {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        final String idxName = "test";
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1))
    @Override
        final ShardId shardId = new ShardId(clusterService().state().metadata().index("test").getIndex(), 0);
                        .put("index.unassigned.node_left.delayed_timeout", "0ms")
        IndexNotFoundException ex = expectThrows(
        }
            client().admin()
        ensureGreen();
        logger.info("--> wait until shard is failed and becomes unassigned again");
                return true;
                .setSettings(
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
        String node = internalCluster().startNode();
            client().admin()
        String timeout = randomFrom("0s", "1s", "2s");
        );
import static org.hamcrest.Matchers.everyItem;
                .indices()
                .get()
        return false;
        for (int i = 0; i < moreDocs; i++) {
            () -> assertTrue(
            .forEach(status -> nodeNames.remove(status.getNode().getName()));
            if (useStaleReplica) {
        // Ensure the stopped primary's data is deleted so that it doesn't get picked up by the next datanode we start
        String dataNodeWithShardCopy = internalCluster().startNode();
            new TwoPartitions(Sets.newHashSet(clusterManager, replicaNode), Collections.singleton(primaryNode)),
        List<String> nodes = internalCluster().startNodes(3);
    }
        assertAcked(
import org.opensearch.index.IndexNotFoundException;
        );
        internalCluster().startDataOnlyNode(inSyncDataPathSettings);
                    Settings.builder()
                .getState()
 * this file be licensed under the Apache-2.0 license or a
                .cluster()
            )
                .prepareCreate("test")
        if (useStaleReplica == false) {
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
                .getRoutingTable()
            ClusterState state = client(clusterManager).admin().cluster().prepareState().get().getState();
                .add(new AllocateStalePrimaryAllocationCommand(idxName, shardId, nodeWithoutData, true))
                .get()
        long moreDocs = scaledRandomIntBetween(1, 10);
        }
            int shardId = shardStoreStatuses.getKey();
        assertAcked(
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1))
 * this work for additional information regarding copyright
import org.opensearch.action.index.IndexResponse;
        );
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.enable", "all"))
        ensureGreen();
                .indices()
        );
                .cluster()
            IndexResponse indexResult = index("test", "doc", Long.toString(i));
                )
        final Settings inSyncDataPathSettings = createStaleReplicaScenario(clusterManager);
        final Set<String> replicaNodes = new HashSet<>(internalCluster().startDataOnlyNodes(numberOfReplicas));
                .get()
        }
        logger.info("--> waiting for node with old primary shard to rejoin the cluster");
        final String idxName = "test";
import org.opensearch.plugins.Plugin;
        assertAcked(
            for (String node : replicaNodes) {
            .indices()
import org.opensearch.cluster.ClusterStateListener;
        final Set<String> expectedAllocationIds = useStaleReplica
        final String oldPrimary = internalCluster().startDataOnlyNode();
        );
            equalTo("No data for shard [" + shardId + "] of index [" + idxName + "] found on node [" + nodeWithoutData + ']')
        assertTrue(
        }
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
 * software distributed under the License is distributed on an
        // kick reroute and wait for all shard states to be fetched
            .getStoreStatuses()
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (randomBoolean()) {
                IndexShard shard = internalCluster().getInstance(IndicesService.class, node).getShardOrNull(shardId);
        internalCluster().startDataOnlyNode(inSyncDataPathSettings);
        logger.info("--> update the settings to prevent allocation to the data node");
 */
 * GitHub history for details.
            }
        assertThat(iae.getMessage(), equalTo("[allocate_stale_primary] primary [" + idxName + "][" + shardId + "] is already assigned"));
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequestBuilder;
    }
        final String primaryNode;
    public void testBulkWeirdScenario() throws Exception {
            public boolean clearData(String nodeName) {
        );
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> storeStatuses = client().admin()
                .shardsWithState(ShardRoutingState.STARTED)
        );
        logger.info("--> wait until shard is failed and becomes unassigned again");
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
            // search can throw an "all shards failed" exception. We will wait until the shard initialization has completed before
            client(clusterManager).admin()
        createStaleReplicaScenario(clusterManager);
    public void testFailedAllocationOfStalePrimaryToDataNodeWithNoData() throws Exception {
import org.opensearch.cluster.ClusterState;
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();
            IllegalArgumentException.class,
                )
        assertAcked(
                .add(new AllocateStalePrimaryAllocationCommand("test", 0, dataNodeWithNoShardCopy, true))
            @Override
        ensureYellow("test");
        ensureGreen("test");
        partition.ensureHealthy(internalCluster());
    }
    public void testNotWaitForQuorumCopies() throws Exception {
            assertThat(indexResult.getShardInfo().getSuccessful(), equalTo(numberOfReplicas + 1));
        internalCluster().startDataOnlyNode(Settings.EMPTY);
        internalCluster().wipePendingDataDirectories();
            .add(client().prepareIndex().setIndex("test").setId("1").setSource("field1", "value1"))
    }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                .index("test")
 * not use this file except in compliance with the License.
     * we will force allocate the primary shard to one of those nodes, even if the allocation deciders all return
import org.opensearch.test.OpenSearchIntegTestCase;
        refresh();
        NetworkDisruption partition = new NetworkDisruption(new TwoPartitions(replicasSide1, replicasSide2), NetworkDisruption.DISCONNECT);
                .get()
                .primaryShard()
import org.opensearch.cluster.metadata.IndexMetadata;
            client().admin()
     */
            () -> assertThat(internalCluster().getInstance(GatewayAllocator.class, clusterManager).getNumberOfInFlightFetches(), equalTo(0))
                .cluster()
                .getShards()
        logger.info("--> starting node that reuses data folder with the up-to-date shard");
        ensureGreen();
        assertThat(
        // kick reroute a second time and check that all shards are unassigned
        final int shardId = 0;
                rerouteBuilder.add(new AllocateStalePrimaryAllocationCommand(idxName, shardId, storeStatus.getNode().getId(), true));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataNodeWithShardCopy));
        Set<String> newHistoryUUIds = Stream.of(shardStats)
        logger.info("--> checking that index still gets allocated with only 1 shard copy being available");
            .getShards();
        logger.info("--> starting node that reuses data folder with the up-to-date primary shard");
        partition.stopDisrupting();
            ClusterState state = client(clusterManager).admin().cluster().prepareState().get().getState();
 * SPDX-License-Identifier: Apache-2.0
                        .put("index.global_checkpoint_sync.interval", "1s")
        final String nodeWithoutData = nodeNames.get(0);
                .prepareUpdateSettings(indexName)
}
            .add(client().prepareUpdate().setIndex("test").setId("1").setDoc("field2", "value2"))
            client().admin().cluster().prepareState().get().getState().toString(),
        logger.info("--> Indexing with gap in seqno to ensure that some operations will be replayed in resync");
    public void testRemoveAllocationIdOnWriteAfterNodeLeave() throws Exception {
import org.opensearch.index.shard.IndexShard;
        logger.info("--> shut down node that has new acknowledged document");
                .prepareCreate("test")
        String dataNodeWithNoShardCopy = internalCluster().startNode();
                    Settings.builder()
        ensureStableCluster(1, clusterManager);
        assertThat(shards.size(), equalTo(2));
            // its possible that the shard has not completed initialization, even though the cluster health is yellow, so the
            client(clusterManager).admin()
        logger.info("--> creating index with 1 primary and 2 replicas");
                .getRoutingTable()
        client().admin()
 */
        assertBusy(
        ClusterRerouteRequestBuilder rerouteBuilder = client().admin().cluster().prepareReroute();
        String replicaNode = internalCluster().startDataOnlyNode(Settings.EMPTY);
                )
            client().admin()
                .get(0)
    }
        assertAcked(
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
        partition.startDisrupting();
        for (var shardStoreStatuses : storeStatuses.entrySet()) {
                .get()
                .routingTable()
        final Set<String> replicasSide1 = Sets.newHashSet(randomSubsetOf(between(1, numberOfReplicas - 1), replicaNodes));
        logger.info("--> checking that the primary shard is force allocated to the data node despite being blocked by the exclude filter");
    /**
 * under the License.
import org.opensearch.cluster.service.ClusterService;
    public void testForceStaleReplicaToBePromotedForMissingIndex() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertAcked(
 * KIND, either express or implied.  See the License for the
                .index("test")
        assertThat(bulkResponse.hasFailures(), equalTo(false));
        client().admin().cluster().prepareReroute().add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node, true)).get();
            .get()
    public void testForceStaleReplicaToBePromotedForGreenIndex() {
            .execute()
                .prepareReroute()
        assertThat(ex.getIndex().getName(), equalTo(idxName));
                .cluster()
        internalCluster().fullRestart();
        assertBusy(() -> {
            if (expectedAllocationIds.equals(allocationIds)) {
                Settings.builder()
        assertThat(bulkResponse.getItems()[0].getResponse().getResult(), equalTo(DocWriteResponse.Result.CREATED));
    public void testForceStaleReplicaToBePromotedToPrimaryOnWrongNode() throws Exception {
        assertThat(bulkResponse.getItems().length, equalTo(2));
            )
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
        internalCluster().startDataOnlyNodes(2);
        final int numberOfReplicas = between(2, 3);
    private Settings createStaleReplicaScenario(String clusterManager) throws Exception {
        final Settings inSyncDataPathSettings = internalCluster().dataPathSettings(replicaNode);
        ensureStableCluster(3, clusterManager);
        final int shardId = 0;
        assertAcked(
        for (ShardStats shardStat : shardStats) {
import org.opensearch.common.util.set.Sets;
            )
            primaryNode = state.getRoutingNodes().node(shards.get(0).currentNodeId()).node().getName();
            .indices()
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);
                rerouteBuilder.add(new AllocateEmptyPrimaryAllocationCommand(idxName, shardId, storeStatus.getNode().getId(), true));
import org.opensearch.index.engine.Engine;
            equalTo(UnassignedInfo.Reason.NODE_LEFT)
            // verifying the search hit count.
            client().admin()
 * Unless required by applicable law or agreed to in writing,
            } else {
        );
            assertThat(state.metadata().index("test").inSyncAllocationIds(shardId.id()), hasSize(numberOfReplicas + 1));
            client().admin()
        );
            .getStoreStatuses()
        );
                .get()
import org.opensearch.core.index.shard.ShardId;
        String replicaNode = internalCluster().startDataOnlyNode(Settings.EMPTY);
        // disruption tests need MockTransportService
                client().admin().cluster().prepareState().get().getState().getRoutingTable().index("test").allPrimaryShardsUnassigned()
import java.util.List;
    public void testForcePrimaryShardIfAllocationDecidersSayNoAfterIndexCreation() throws ExecutionException, InterruptedException {
    }
                .setSettings(
