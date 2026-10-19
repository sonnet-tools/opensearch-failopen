                .index(indexName)
                .add(new AllocateStalePrimaryAllocationCommand(idxName, 0, dataNode, true))
        final Settings inSyncDataPathSettings = createStaleReplicaScenario(clusterManager);
        assertAcked(
            client().admin()
 * You may obtain a copy of the License at  
        final String node = internalCluster().startNode();
                .setSettings(  
import java.util.stream.Collectors;
 * compatible open source license.
    public void testForceStaleReplicaToBePromotedForGreenIndex() {  
import static org.hamcrest.Matchers.empty;
            assertThat(state.routingTable().shardRoutingTable(shardId).activeShards(), hasSize(numberOfReplicas));
    public void testRemoveAllocationIdOnWriteAfterNodeLeave() throws Exception {
        internalCluster().startDataOnlyNodes(2);
import static org.hamcrest.Matchers.is;  
        List<String> nodes = internalCluster().startNodes(3);
        internalCluster().restartRandomDataNode();
 * SPDX-License-Identifier: Apache-2.0
        );
            .forEach(status -> nodeNames.remove(status.getNode().getName()));
            ? Collections.singleton(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID)
 * Unless required by applicable law or agreed to in writing,
                        .put("index.number_of_shards", 1)
    public void testForceAllocatePrimaryOnNoDecision() throws Exception {  
                .shardsWithState(ShardRoutingState.STARTED)
        final Set<String> replicasSide2 = Sets.difference(replicaNodes, replicasSide1);
            @Override
        NetworkDisruption partition = new NetworkDisruption(  
        assertAcked(  
import java.util.Map;
        ensureGreen("test");
        }  
        }
                .getShards()
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
                Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
            .indices()
        internalCluster().startDataOnlyNode(inSyncDataPathSettings);  
        ensureGreen();
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1))  
                assertThat(state.getRoutingNodes().node(activeShard.currentNodeId()).node().getName(), is(in(selectedPartition)));
                .get()
            int shardId = shardStoreStatuses.getKey();
        partition.stopDisrupting();  
            client().admin()  
import org.opensearch.test.disruption.NetworkDisruption.TwoPartitions;
        ensureGreen("test");
        assertAcked(  
import java.util.stream.Stream;
        } else {
        assertEquals(1, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());
            .getStoreStatuses()  
                .getState()
        assertBusy(
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();
        BulkResponse bulkResponse = client().prepareBulk()  
            IndexResponse indexResult = index("test", "doc", Long.toString(numDocs + i));  
                .prepareReroute()  
                IndexShard shard = internalCluster().getInstance(IndicesService.class, node).getShardOrNull(shardId);
                        .put("index.number_of_replicas", 1)
        );
        Set<String> historyUUIDs = Arrays.stream(client().admin().indices().prepareStats("test").clear().get().getShards())
        ClusterState state = client().admin().cluster().prepareState().all().get().getState();
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;  
        client(clusterManager).admin().cluster().prepareReroute().get();
        assertThat(bulkResponse.getItems()[0].getResponse().getResult(), equalTo(DocWriteResponse.Result.CREATED));  
                    Settings.builder()
        );
            new TwoPartitions(Sets.newHashSet(clusterManager, replicaNode), Collections.singleton(primaryNode)),
            .getShards();  
        logger.info("--> wait until shard is failed and becomes unassigned again");  
        internalCluster().startDataOnlyNodes(1);
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0))
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));  
 *
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.enable", "none"))
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(dataNodeWithShardCopy));
import org.opensearch.cluster.metadata.IndexMetadata;
            .get()  
        internalCluster().assertSeqNos();
            )
        final Set<String> expectedAllocationIds = useStaleReplica  
                .get()  
import org.opensearch.core.index.shard.ShardId;  
        final String oldPrimary = internalCluster().startDataOnlyNode();
            client().admin()
        );
        logger.info("--> check that the up-to-date primary shard gets promoted and that documents are available");
        final String idxName = "test";
                .unassignedInfo()
            primaryNode = state.getRoutingNodes().node(shards.get(0).currentNodeId()).node().getName();
/*  
            assertBusy(
    public void testFailedAllocationOfStalePrimaryToDataNodeWithNoData() throws Exception {  
                .setSettings(Settings.builder().put(IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "_name", node))  
    }
            () -> assertTrue(  
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        internalCluster().setDisruptionScheme(partition);
    public void testForceStaleReplicaToBePromotedToPrimary() throws Exception {
        logger.info("--> starting node that reuses data folder with the up-to-date shard");
                .get()
            client().admin().cluster().prepareState().get().getState().toString(),
            ClusterState state = client(clusterManager).admin().cluster().prepareState().get().getState();
                .add(new AllocateStalePrimaryAllocationCommand("test", 0, dataNodeWithNoShardCopy, true))
    public void testPrimaryReplicaResyncFailed() throws Exception {
        String dataNodeWithShardCopy = internalCluster().startNode();
                )
    }
        );  
        assertEquals(1, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());  
        logger.info("--> shut down node that has new acknowledged document");
        );
        ensureStableCluster(1);
        ensureStableCluster(1, clusterManager);
        assertThat(iae.getMessage(), equalTo("No data for shard [0] of index [test] found on any node"));
            }  
            empty()
        createStaleReplicaScenario(clusterManager);
            .getStoreStatuses()
        String replicaNode = internalCluster().startDataOnlyNode(Settings.EMPTY);
            } else {
        logger.info("--> update the settings to prevent allocation to the data node");
     * a NO decision to allocate.
                .get()
        logger.info(Strings.toString(MediaTypeRegistry.JSON, bulkResponse, true, true));  
            .prepareStats("test")  
    }
    public void testForcePrimaryShardIfAllocationDecidersSayNoAfterIndexCreation() throws ExecutionException, InterruptedException {
            final Set<String> allocationIds = event.state().metadata().index(idxName).inSyncAllocationIds(0);  
        internalCluster().startDataOnlyNodes(2);  
                .getRoutingTable()  
            client().admin()  
        );
        logger.info("--> checking that index still gets allocated with only 1 shard copy being available");
                    .put("index.number_of_shards", 1)
    }
                .get()
                .get(0)
import java.util.HashSet;  
 * GitHub history for details.
import java.util.List;
            IllegalArgumentException.class,  
        assertThat(
 *    http://www.apache.org/licenses/LICENSE-2.0
                .cluster()
        }  
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        ensureGreen("test");
        if (randomBoolean()) {
            replicaNode = state.getRoutingNodes().node(shards.get(0).currentNodeId()).node().getName();  
        internalCluster().wipePendingDataDirectories();  
                .indices()  
        nodeNames.remove(clusterManager);
            () -> client().admin()  
            .setSettings(
            Collections.singleton(state.routingTable().index(idxName).shard(0).primary.allocationId().getId()),
            // force allocation based on node id
        // kick reroute a second time and check that all shards are unassigned  
            () -> assertTrue(
            1,  
import java.util.concurrent.CountDownLatch;
import org.opensearch.common.settings.Settings;  
        logger.info("--> creating index with 1 primary and 2 replicas");  
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        }, 30, TimeUnit.SECONDS);
                        .put("index.number_of_replicas", 1)
                .prepareCreate(idxName)
                .cluster()
        internalCluster().setDisruptionScheme(partition);  
        assertEquals(2, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());  
        return inSyncDataPathSettings;
        final String replicaNode;  
import static org.hamcrest.Matchers.in;
            .collect(Collectors.toSet());
        assertAcked(  
    }
        Throwable iae = expectThrows(
    }
                .prepareCreate(idxName)
            assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(0));  
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1))
    }
                )
        ensureGreen(indexName);
        ensureYellow(idxName);  
                .cluster()
            equalTo(UnassignedInfo.Reason.NODE_LEFT)
        );
            public boolean clearData(String nodeName) {  
            .indices()  
                        .put("index.number_of_shards", 1)  
        EngineTestCase.generateNewSeqNo(IndexShardTestCase.getEngine(oldPrimaryShard)); // Make gap in seqno.  
            ClusterState state = client(clusterManager).admin().cluster().prepareState().get().getState();  
 *
        assertBusy(  
        ensureGreen();
        assertAcked(
            if (useStaleReplica) {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
                return true;  
 */  
                .get()
    public void testBulkWeirdScenario() throws Exception {  
            prepareCreate(  
                .cluster()
        assertEquals(2, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());
        assertThat(bulkResponse.getItems()[1].getResponse().getId(), equalTo("1"));
        final ClusterStateListener clusterStateListener = event -> {
import java.util.Arrays;  
                .getRoutingTable()
import org.opensearch.cluster.ClusterStateListener;
        assertThat(newHistoryUUIds, hasSize(1));
import static org.hamcrest.Matchers.hasSize;
                .prepareCreate("test")
            .setWaitForActiveShards(ActiveShardCount.NONE)  
            // verifying the search hit count.  
        assertAcked(
        logger.info("--> check that the stale primary shard gets allocated and that documents are available");
        final ShardId shardId = new ShardId(clusterService().state().metadata().index("test").getIndex(), 0);
        Set<String> newHistoryUUIds = Stream.of(shardStats)  
                    Settings.builder()  
            .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_CLOSED)
        internalCluster().startDataOnlyNodes(2);
                rerouteBuilder.add(new AllocateEmptyPrimaryAllocationCommand(idxName, shardId, storeStatus.getNode().getId(), true));
import org.opensearch.gateway.GatewayAllocator;
                rerouteBuilder.add(new AllocateStalePrimaryAllocationCommand(idxName, shardId, storeStatus.getNode().getId(), true));  
        ensureGreen();  
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
        refresh();  
                .cluster()
     * we will force allocate the primary shard to one of those nodes, even if the allocation deciders all return  
        assertThat(
                .cluster()
                        .put("index.number_of_shards", 1)
            final String newPrimaryNode = state.getRoutingNodes().node(shardRoutingTable.primary.currentNodeId()).node().getName();
                .setPersistentSettings(Settings.builder().put("indices.replication.retry_timeout", timeout))
                        .put("index.number_of_replicas", 1)
        logger.info("--> force allocation of stale copy to node that does not have shard copy");
import java.util.concurrent.TimeUnit;  
        final List<String> nodeNames = new ArrayList<>(Arrays.asList(internalCluster().getNodeNames()));
        );  
 * the Apache License, Version 2.0 (the "License"); you may
                () -> assertTrue(
        IndexNotFoundException ex = expectThrows(
                .indices()  
        logger.info("--> starting 3 nodes, 1 cluster-manager, 2 data");
 * KIND, either express or implied.  See the License for the
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));  
        assertThat(bulkResponse.getItems()[1].getResponse().getVersion(), equalTo(2L));
            .actionGet();
                .get()
    }
        client().admin()  
                .get()
        );  
                )  
            iae.getMessage(),
        assertEquals(
/*  
                .indices()
    protected boolean addMockInternalEngine() {
                .primaryShard()  
        assertTrue(clusterStateChangeLatch.await(30, TimeUnit.SECONDS));
            // search can throw an "all shards failed" exception. We will wait until the shard initialization has completed before
        partition.startDisrupting();
            client().admin().cluster().prepareState().get().getState().getRoutingTable().index("test").allPrimaryShardsUnassigned()  
                .prepareState()  
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
        boolean useStaleReplica = randomBoolean(); // if true, use stale replica, otherwise a completely empty copy
            .get()
            final IndexShardRoutingTable shardRoutingTable = state.routingTable().shardRoutingTable(shardId);
                .get()  
            )  
            )
     */
                .get()
     * This test ensures that for an unassigned primary shard that has a valid shard copy on at least one node,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            : Collections.emptySet();
            () -> assertThat(internalCluster().getInstance(GatewayAllocator.class, clusterManager).getNumberOfInFlightFetches(), equalTo(0))
        final String primaryNode;
        ensureGreen("test");
            assertThat(shardStat.getCommitStats().getNumDocs(), equalTo(useStaleReplica ? 1 : 0));
    private Settings createStaleReplicaScenario(String clusterManager) throws Exception {
            assertThat(newPrimaryNode, not(equalTo(oldPrimary)));  
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
                .prepareCreate("test")
     */  
                .primaryShard()
        assertThat(  
        logger.info("--> isolating some replicas during primary-replica resync");
        return Arrays.asList(MockTransportService.TestPlugin.class, InternalSettingsPlugin.class);  
                        .put("index.unassigned.node_left.delayed_timeout", "0ms")  
        String timeout = randomFrom("0s", "1s", "2s");
import static org.hamcrest.Matchers.equalTo;
                .cluster()
        logger.info("--> wait until shard is failed and becomes unassigned again");
            client(clusterManager).admin().cluster().prepareReroute().get().getState().getRoutingNodes().unassigned().size(),
        );
                .setSettings(Settings.builder().put("index.number_of_shards", randomIntBetween(1, 3)).put("index.number_of_replicas", 2))
 */
            IndexNotFoundException.class,  
            client(clusterManager).admin()  
import org.opensearch.common.util.set.Sets;
/*
                .get()
    /**
            NetworkDisruption.DISCONNECT
    public void testDoNotAllowStaleReplicasToBePromotedToPrimary() throws Exception {
                .prepareUpdateSettings(indexName)
        );  
        ensureStableCluster(3, clusterManager);
        final String nodeWithoutData = nodeNames.get(0);  
        );
        ensureGreen();
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertBusy(() -> {
import org.opensearch.core.common.Strings;
        );  
            if (expectedAllocationIds.equals(allocationIds)) {
        assertThat(ex.getIndex().getName(), equalTo(idxName));
import org.opensearch.action.index.IndexResponse;  
                .prepareUpdateSettings()
        logger.info("--> creating index with 1 primary and 0 replicas");  
                .indices()
                .routingTable()  
import org.opensearch.index.engine.EngineTestCase;
 * Licensed to Elasticsearch under one or more contributor  
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {  
            logger.info("expected allocation ids: {} actual allocation ids: {}", expectedAllocationIds, allocationIds);
        // disruption tests need MockTransportService
 * software distributed under the License is distributed on an
            client().admin()  
        );
        rerouteBuilder.get();  
import org.opensearch.index.engine.Engine;
 * specific language governing permissions and limitations
                .setSettings(
                .get()
import org.opensearch.test.InternalTestCluster;
    }
        assertAcked(
                .getState()
        assertAcked(
                .prepareCreate("test")
                .prepareReroute()  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.Set;  
 * The OpenSearch Contributors require contributions made to  
        return false;  
            for (String node : replicaNodes) {
        partition.stopDisrupting();
    public void testForceStaleReplicaToBePromotedForMissingIndex() {
        ensureGreen();  
                .get(0)  
        };
    @Override  
        });  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    }
                .indices()  
                .get()
            client().admin()  
                .add(new AllocateStalePrimaryAllocationCommand(idxName, shardId, nodeWithoutData, true))
            client().admin().cluster().prepareState().get().getState().getRoutingTable().shardRoutingTable("test", 0).assignedShards(),
            replicaNode = state.getRoutingNodes().node(shards.get(1).currentNodeId()).node().getName();  
        for (int i = 0; i < moreDocs; i++) {
            client().admin()
        assertThat(shards.size(), equalTo(2));  
            .add(client().prepareIndex().setIndex("test").setId("1").setSource("field1", "value1"))
                .indices()  
                .prepareState()
            .prepareShardStores(idxName)
import org.opensearch.action.bulk.BulkResponse;
        final Settings inSyncDataPathSettings = internalCluster().dataPathSettings(replicaNode);  
        logger.info("--> indexing...");
        String replicaNode = internalCluster().startDataOnlyNode(Settings.EMPTY);  
            )
        ensureYellow("test");
 * license agreements. See the NOTICE file distributed with
            assertThat(state.metadata().index("test").inSyncAllocationIds(shardId.id()), hasSize(numberOfReplicas + 1));  
                    .put("index.routing.allocation.exclude._name", node)  
                .getState()
            assertThat(state.metadata().index("test").inSyncAllocationIds(shardId.id()), hasSize(numberOfReplicas + 1));  
            () -> assertTrue(  
        });
            equalTo("No data for shard [" + shardId + "] of index [" + idxName + "] found on node [" + nodeWithoutData + ']')
 * this work for additional information regarding copyright
        }
import org.opensearch.plugins.Plugin;  
                .indices()  
                .index("test")  
                .isAcknowledged()
            @Override
                .get()  
        );
            client().admin()
        }
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(oldPrimary));  
                client().admin().cluster().prepareState().get().getState().getRoutingTable().index("test").allPrimaryShardsUnassigned()
        logger.info("--> index a document into previous replica shard (that is now primary)");
        assertThat(iae.getMessage(), equalTo("[allocate_stale_primary] primary [" + idxName + "][" + shardId + "] is already assigned"));
        );
    /**
        assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 1L);
            state.metadata().index(idxName).inSyncAllocationIds(0)  
        assertThat(bulkResponse.getItems()[0].getResponse().getId(), equalTo("1"));
        internalCluster().startDataOnlyNode(Settings.EMPTY);  
        );
        final String dataNode = internalCluster().startDataOnlyNode();  
                .getShards()
        logger.info("--> removing 2 nodes from cluster");
        internalCluster().restartRandomDataNode(new InternalTestCluster.RestartCallback() {
import java.util.concurrent.ExecutionException;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        long numDocs = scaledRandomIntBetween(5, 50);  
                .setTransientSettings(Settings.builder().put("cluster.routing.allocation.enable", "all"))  
        final int numberOfReplicas = between(2, 3);  
                .prepareState()  
            .execute()  
        assertThat(newHistoryUUIds, everyItem(is(not(in(historyUUIDs)))));  
                .prepareCreate("test")
        // allocation id of old primary was cleaned from the in-sync set
        logger.info("--> full cluster restart");
import java.util.Collections;
        String dataNodeWithNoShardCopy = internalCluster().startNode();
            }
            client().admin()
        final ClusterService clusterService = internalCluster().getInstance(ClusterService.class, clusterManager);  
                .get()  
        String node = internalCluster().startNode();
        assertThat(bulkResponse.hasFailures(), equalTo(false));  
        long moreDocs = scaledRandomIntBetween(1, 10);
            .collect(Collectors.toSet());  
        logger.info("--> starting 3 nodes");
        final IndexShard oldPrimaryShard = internalCluster().getInstance(IndicesService.class, oldPrimary).getShardOrNull(shardId);
        ensureYellow("test");  
                .get()
import org.opensearch.test.transport.MockTransportService;  
                    Settings.builder()  
        logger.info("--> create single shard index");  
public class PrimaryAllocationIT extends OpenSearchIntegTestCase {
        ensureStableCluster(2);
        assertAcked(
            assertThat(shardRoutingTable.activeShards(), hasSize(selectedPartition.size()));
import org.opensearch.action.DocWriteResponse;
        logger.info("--> check that old primary shard does not get promoted to primary again");  
                        .put("index.unassigned.node_left.delayed_timeout", "0ms")
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
    // returns data paths settings of in-sync shard copy  
            }
import java.util.ArrayList;
        logger.info("--> wait until shard is failed and becomes unassigned again");  
        ClusterRerouteRequestBuilder rerouteBuilder = client().admin().cluster().prepareReroute();
        );  
        // testForceStaleReplicaToBePromotedToPrimary replies on the flushing when a shard is no longer assigned.
        ensureGreen("test");  
        logger.info("--> partitioning node with primary shard from rest of cluster");
 */  
        logger.info("--> checking that the primary shard is force allocated to the data node despite being blocked by the exclude filter");  
        IllegalArgumentException iae = expectThrows(
        logger.info("--> waiting for node with old primary shard to rejoin the cluster");  
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1))  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        final Set<String> replicasSide1 = Sets.newHashSet(randomSubsetOf(between(1, numberOfReplicas - 1), replicaNodes));  
        logger.info("--> starting 3 nodes, 1 cluster-manager, 2 data");  
    }
                .prepareCreate("test")
            .get(shardId)  
            equalTo(UnassignedInfo.Reason.NODE_LEFT)  
            () -> client().admin()
        }
import org.opensearch.indices.IndicesService;
import org.opensearch.index.shard.IndexShardTestCase;
        internalCluster().startDataOnlyNodes(2);
 * ownership. Elasticsearch licenses this file to you under  
                .getReason(),
        );
        }, 1, TimeUnit.MINUTES);
            IllegalArgumentException.class,  
        final int shardId = 0;  
                .get()
            }
                )
        final String idxName = "test";
                .indices()
        NetworkDisruption partition = new NetworkDisruption(new TwoPartitions(replicasSide1, replicasSide2), NetworkDisruption.DISCONNECT);
        ensureGreen("test");
            for (ShardRouting activeShard : shardRoutingTable.activeShards()) {  
        );  
            IndicesShardStoresResponse.StoreStatus storeStatus = randomFrom(shardStoreStatuses.getValue());
                .setSettings(Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 1))
        ensureStableCluster(2, clusterManager);
        ShardStats[] shardStats = client().admin()
                .prepareCreate(indexName)
        clusterService.removeListener(clusterStateListener);  
 * not use this file except in compliance with the License.
                .indices()
                        .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)  
        assertThat(  
                client().admin().cluster().prepareState().get().getState().getRoutingTable().index("test").allPrimaryShardsUnassigned()  
            client().admin()
        );  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(1), nodes.get(2)));
            assertThat(indexResult.getShardInfo().getSuccessful(), equalTo(numberOfReplicas + 1));  
        assertThat(  
        if (shards.get(0).primary()) {
            () -> client().admin()
        partition.ensureHealthy(internalCluster());
            public boolean clearData(String nodeName) {
        final String idxName = "test";
                .add(new AllocateStalePrimaryAllocationCommand(idxName, shardId, nodeWithoutData, true))  
import org.opensearch.index.IndexNotFoundException;  
 * this file be licensed under the Apache-2.0 license or a
            .prepareShardStores(idxName)
                client().admin().cluster().prepareState().get().getState().getRoutingTable().index("test").allPrimaryShardsUnassigned()
        client().admin().cluster().prepareReroute().add(new AllocateEmptyPrimaryAllocationCommand("test", 0, node, true)).get();
                .indices()
        if (useStaleReplica == false) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
    }  
import org.opensearch.action.admin.indices.shards.IndicesShardStoresResponse;  
        partition.startDisrupting();  
                        .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
        internalCluster().fullRestart();
        );
            .get(idxName);
        );  
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();
        List<ShardRouting> shards = state.routingTable().allShards("test");
        for (int i = 0; i < numDocs; i++) {
                .indices()
                .prepareCreate("test")  
        final int shardId = 0;
            equalTo(2)  
                .get()
            // When invoking AllocateEmptyPrimaryAllocationCommand, due to the UnassignedInfo.Reason being changed to INDEX_CREATION,  
            )  
        final Settings inSyncDataPathSettings = internalCluster().dataPathSettings(replicaNode);
                    Settings.builder()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.get(1), nodes.get(2)));  
            IllegalArgumentException.class,
        );
            );
        // Ensure the stopped primary's data is deleted so that it doesn't get picked up by the next datanode we start
        internalCluster().startDataOnlyNode(inSyncDataPathSettings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        );  
                .setSettings(
        createStaleReplicaScenario(clusterManager);
        assertTrue(
                clusterStateChangeLatch.countDown();
    }
import org.opensearch.action.admin.indices.stats.ShardStats;
                .unassignedInfo()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            Set<String> selectedPartition = replicasSide1.contains(newPrimaryNode) ? replicasSide1 : replicasSide2;
            client().admin()
    @Override  
            // its possible that the shard has not completed initialization, even though the cluster health is yellow, so the
            .get();
        internalCluster().startDataOnlyNode(Settings.EMPTY);
        assertAcked(
    public void testNotWaitForQuorumCopies() throws Exception {  
                "test",
        assertEquals(2, client().admin().cluster().prepareState().get().getState().metadata().index("test").inSyncAllocationIds(0).size());  
        ensureYellow("test");
                )
        assertAcked(
    public void testForceStaleReplicaToBePromotedToPrimaryOnWrongNode() throws Exception {
        final Set<String> replicaNodes = new HashSet<>(internalCluster().startDataOnlyNodes(numberOfReplicas));  
                .get()  
        ensureYellow("test");
import static org.hamcrest.Matchers.everyItem;  
        assertAcked(
        final Settings inSyncDataPathSettings = internalCluster().dataPathSettings(replicaNode);
        internalCluster().startDataOnlyNode(inSyncDataPathSettings);
import org.opensearch.cluster.ClusterState;  
    }
            primaryNode = state.getRoutingNodes().node(shards.get(1).currentNodeId()).node().getName();
 * under the License.  
import org.opensearch.action.support.ActiveShardCount;
        );
        final String indexName = "test-idx";
            .indices()
                .prepareReroute()  
    public void testDoNotRemoveAllocationIdOnNodeLeave() throws Exception {  
        logger.info("--> starting node that reuses data folder with the up-to-date shard");  
        // kick reroute and wait for all shard states to be fetched
        final CountDownLatch clusterStateChangeLatch = new CountDownLatch(1);
        final String nodeWithoutData = randomFrom(dataNodes);  
    }
import static org.hamcrest.Matchers.not;
                .getReason(),  
import org.opensearch.test.disruption.NetworkDisruption;
                return true;
        Throwable iae = expectThrows(
            .get(idxName)
            .get()
                .get()
                .setSettings(
        ensureStableCluster(2, clusterManager);
        assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2L);  
        assertThat(bulkResponse.getItems()[1].getResponse().getResult(), equalTo(DocWriteResponse.Result.UPDATED));  
        assertThat(bulkResponse.getItems()[0].getResponse().getVersion(), equalTo(1L));
            assertThat(indexResult.getShardInfo().getSuccessful(), equalTo(numberOfReplicas + 1));
                assertThat(shard.getLocalCheckpoint(), equalTo(numDocs + moreDocs));  
            client().admin()  
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequestBuilder;
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);  
        );  
            IndexResponse indexResult = index("test", "doc", Long.toString(i));
        final String idxName = "test";  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        client(replicaNode).prepareIndex("test").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();
import org.opensearch.index.shard.IndexShard;  
     * This test asserts that replicas failed to execute resync operations will be failed but not marked as stale.
        logger.info("--> starting 1 node");
        );
            .map(shard -> shard.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY))
        assertTrue(
                .cluster()
                .prepareReroute()
        clusterService.addListener(clusterStateListener);
            }  
            .indices()
                .prepareCreate("test")  
        assertAcked(
        final Map<Integer, List<IndicesShardStoresResponse.StoreStatus>> storeStatuses = client().admin()
        logger.info("--> Indexing with gap in seqno to ensure that some operations will be replayed in resync");
        assertThat(nodeNames, hasSize(1));
        assertBusy(
            }
            () -> client().admin()
        logger.info("--> stop disrupting network and re-enable allocation");
        for (var shardStoreStatuses : storeStatuses.entrySet()) {  
        );  
                .cluster()
                .size()  
        for (ShardStats shardStat : shardStats) {
                    client().admin().cluster().prepareState().get().getState().routingTable().index(idxName).allPrimaryShardsActive()  
        internalCluster().assertConsistentHistoryBetweenTranslogAndLuceneIndex();  
                        .put("index.global_checkpoint_sync.interval", "1s")  
        client().prepareIndex("test").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();  
            .map(shard -> shard.getCommitStats().getUserData().get(Engine.HISTORY_UUID_KEY))
        client().admin()  
        );  
        ensureGreen();
                    .put("index.number_of_replicas", 0)
}  
package org.opensearch.cluster.routing;
import org.opensearch.action.support.IndicesOptions;
            logger.info("--> adding allocation command for shard {}", shardId);  
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
            .prepareCreate("test")
        }
                Settings.builder()
        assertBusy(
                .prepareUpdateSettings()  
        // Checks that we fails replicas in one side but not mark them as stale.
        assertThat(bulkResponse.getItems().length, equalTo(2));
 * Modifications Copyright OpenSearch Contributors. See
            client().admin()
import java.util.Collection;
        assertEquals(
        assertBusy(() -> {  
        internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
import org.opensearch.cluster.service.ClusterService;
                .index("test")
        logger.info("--> starting node that reuses data folder with the up-to-date primary shard");
        String clusterManager = internalCluster().startClusterManagerOnlyNode(Settings.EMPTY);
            .add(client().prepareUpdate().setIndex("test").setId("1").setDoc("field2", "value2"))
            client().admin()
        logger.info("--> explicitly promote old primary shard");  
import org.opensearch.test.InternalSettingsPlugin;
    }
            client(clusterManager).admin()
