            prepareCreate("index").setSettings(
        final List<String> nodeNames = internalCluster().startNodes(2);
import org.opensearch.common.SuppressForbidden;
        assertThat(shards, hasSize(1));
        for (ShardRouting shard : shards) {
        // Check routing tables
        String dataNode = internalCluster().startDataOnlyNode();
        }
            final long applierVersion = clusterManagerCoordinator.getApplierState().version();
            assertNotNull(mapper);
        // operation yet
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                }
            MappingMetadata typeMappings = client().admin().indices().prepareGetMappings("index").get().getMappings().get("index");
            } else {
        assertTrue(putMappingResponse.get(10, TimeUnit.SECONDS).isAcknowledged());
 * specific language governing permissions and limitations
        ).get();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                fail(); // only primaries
        final String clusterManager = internalCluster().getClusterManagerName();
        // and then allowing all nodes so that the replica gets allocated on the other node
        assertBusy(() -> {
                ClusterState.Builder builder = ClusterState.builder(currentState);
            ClusterState state = clusterService.state();
import org.opensearch.core.action.ActionResponse;
        // and not just because it takes time to replicate the indexing request to the replica
    private void blockShardStartedResponse(String master, ClusterService service) {
                ClusterState.Builder builder = ClusterState.builder(currentState);
                ShardRouting next = currentState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0);
        ActionFuture<IndexResponse> docIndexResponse = client().prepareIndex("index").setId("1").setSource("field", 42).execute();
        );
            }
        ActionRequestBuilder<Req, Res> req
                RoutingTable.Builder routingTable = RoutingTable.builder(updatedState.routingTable());
        assertNotNull(otherNode);
        // that adds mappings but before mappings are propagated to all nodes
import static org.hamcrest.Matchers.hasSize;
        assertBusy(() -> {
        // Wait a bit to make sure that the reason why we did not get a response
import org.opensearch.test.disruption.BlockClusterStateProcessing;
 *
    }
                String stringRep = req.toString();
        client().admin().indices().prepareClose(index).get();
        clusterService.submitStateUpdateTask("test-inject-node-and-reroute", new ClusterStateUpdateTask() {
                builder.blocks(ClusterBlocks.builder().blocks(currentState.blocks()).removeIndexBlocks(index));
        }
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
        Thread.sleep(100);
                routingTable.addAsRecovery(updatedState.metadata().index(index));
 * not use this file except in compliance with the License.
            }
 * this work for additional information regarding copyright
        prepareCreate(index).setSettings(
        // index another document, this time using dynamic mappings.
            }
/*
            return state.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() == 3;
        // Check routing tables
        prepareCreate(index).setSettings(
            }
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
package org.opensearch.cluster.coordination;
                ClusterState.Builder builder = ClusterState.builder(currentState);
        disruption.stopDisrupting();
            if (node.equals(clusterManager) == false) {
        ClusterState state = client().admin().cluster().prepareState().get().getState();
            public ClusterState execute(ClusterState currentState) throws Exception {
        client().admin()
 * compatible open source license.
import static org.opensearch.action.DocWriteResponse.Result.CREATED;
                );
                    .findAny();
        assertEquals(clusterManager, state.nodes().getClusterManagerNode().getName());
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        ).get();
        // we don't await and cancel committed publication
import static org.hamcrest.Matchers.hasItem;
 */
        ensureGreen();
                handler.messageReceived(request, channel, task);
import static org.hamcrest.Matchers.equalTo;
        // block none cluster-manager node.
        logger.info("--> indexing a doc");
        // Here we want to test that things go well if there is a first request
import org.opensearch.transport.TransportService;
        ensureGreen(TimeValue.timeValueMinutes(30), "test");
                updatedState = ClusterState.builder(updatedState).routingTable(routingTable.build()).build();
        ActionFuture<AcknowledgedResponse> putMappingResponse = executeAndCancelCommittedPublication(
import org.opensearch.action.ActionRequest;
        ).get();
            }
        ActionFuture<Res> future = req.execute();
        // Don't allocate the shard on the cluster-manager node
        // ...and wait for mappings to be available on cluster-manager
    private <Req extends ActionRequest, Res extends ActionResponse> ActionFuture<Res> executeAndCancelCommittedPublication(
        assertFalse(docIndexResponse.isDone());
                    .getShardRoutings()
        final ActionFuture<AcknowledgedResponse> putMappingResponse = executeAndCancelCommittedPublication(
                ClusterState state = allocationService.reroute(updatedState, "reroute");
            client().admin().indices().preparePutMapping("index").setSource("field", "type=long")
import org.opensearch.cluster.routing.ShardRouting;
            ).get()
        assertBusy(() -> assertTrue(client().prepareGet("index", "2").setPreference("_primary").get().isExists()));
        logger.info("--> letting cluster proceed");
    @Override
 * license agreements. See the NOTICE file distributed with
        // This is essentially the same thing as testDelayedMappingPropagationOnPrimary
        assertTrue(putMappingResponse.get(10, TimeUnit.SECONDS).isAcknowledged());
        index("test", MapperService.SINGLE_MAPPING_NAME, "1");
        clusterService.submitStateUpdateTask("test-remove-injected-node", new ClusterStateUpdateTask() {
                .build()
    }
                builder.metadata(Metadata.builder(currentState.metadata()).put(indexMetadata, true));
import org.opensearch.cluster.ClusterState;
        assertBusy(() -> assertTrue(client().prepareGet("index", "1").get().isExists()));
    public void testDelayedMappingPropagationOnPrimary() throws Exception {
            public ClusterState execute(ClusterState currentState) {
                if (matchReplica.isPresent()) {
        // Block cluster state processing where our shard is
    AtomicBoolean blockReplicaStart = new AtomicBoolean(false);
                return allocationService.reroute(updatedState, "reroute");
                .version();
import org.opensearch.test.OpenSearchIntegTestCase;
            Settings.builder().put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s").build()
        final String index = "index";
        internalCluster().startDataOnlyNode(Settings.builder().put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s").build());
            Object properties;
                // open index
        });
import org.opensearch.core.index.Index;
                    .build();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertThat(nodeNames, hasItem(clusterManager));
            } else {
import org.opensearch.action.ActionRequestBuilder;
            ).setTimeout("0s")
        internalCluster().startDataOnlyNode(Settings.builder().put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s").build());
                    .put(IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "0")
        assertNotNull(otherNode);
        ensureGreen(index);
            if (node.equals(clusterManager) == false) {
            assertThat(clusterManagerClusterStateVersion, equalTo(dataClusterStateVersion));
        primaryService.addRequestHandlingBehavior(SHARD_STARTED_ACTION_NAME, (handler, request, channel, task) -> {
                    DiscoveryNodes.builder(currentState.nodes())
        prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)).get();
        });
import org.opensearch.cluster.routing.ShardRoutingState;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
        });
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        return future;
import org.opensearch.discovery.Discovery;
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(
            Settings.builder()
        executeAndCancelCommittedPublication(client().admin().indices().prepareDelete("test").setTimeout("0s")).get(10, TimeUnit.SECONDS);
            .prepareUpdateSettings("index")
        for (String node : nodeNames) {
        });
import static org.opensearch.cluster.action.shard.ShardStateAction.SHARD_STARTED_ACTION_NAME;
        assertFalse(putMappingResponse.isDone());
                    .state(IndexMetadata.State.OPEN)
                } else {
            public void onFailure(String source, Exception e) {
import org.opensearch.cluster.block.ClusterBlocks;
                return state;
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
            public void onFailure(String source, Exception e) {}
            final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, clusterManager);
        BlockClusterStateProcessing disruption = new BlockClusterStateProcessing(dataNode, random());
            @Override
        final List<String> nodeNames = internalCluster().startNodes(2);
 * ownership. Elasticsearch licenses this file to you under
                assertEquals(state.nodes().getClusterManagerNodeId(), shard.currentNodeId());
        for (String node : nodeNames) {
import org.opensearch.cluster.service.ClusterService;
            .indices()
            @Override
            public ClusterState execute(ClusterState currentState) {
                RoutingTable.Builder routingTable = RoutingTable.builder(updatedState.routingTable());
            client().prepareIndex("index").setId("2").setSource("field2", 42)
        // ...and wait for second mapping to be available on cluster-manager
import org.opensearch.cluster.node.DiscoveryNode;
        // time to process the indexing request
        // we need to await and cancel committed publication
                currentState = builder.build();
            final IndexService indexService = indicesService.indexServiceSafe(index);
                logger.info("ShardStateAction.StartedShardEntry {}", stringRep);
        });
                currentState = builder.build();
        // Now make sure the indexing request finishes successfully
                return allocationService.reroute(updatedState, "reroute");
                    .allShardsSatisfyingPredicate(r -> !r.primary())
        // Now make sure the indexing request finishes successfully
import org.opensearch.cluster.metadata.Metadata;
 *
        });
                    .state(IndexMetadata.State.OPEN)
 */
            }
        logger.info(clusterService.state().getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING));
        assertTrue(waitUntil(() -> {
                builder.metadata(Metadata.builder(currentState.metadata()).put(indexMetadata, true));
            assertNotNull(fieldMapping);
import org.opensearch.Version;
            public ClusterState execute(ClusterState currentState) {
            }
        assertHitCount(client().prepareSearch("test").get(), 0);
            final MapperService mapperService = indexService.mapperService();
 * under the License.
                ClusterState updatedState = builder.build();
                final IndexMetadata indexMetadata = IndexMetadata.builder(currentState.metadata().index(index))
            if (shard.primary()) {
 * Modifications Copyright OpenSearch Contributors. See
            }
                routingTable.addAsRecovery(updatedState.metadata().index(index));
            final MapperService mapperService = indexService.mapperService();
        ensureGreen();
        blockShardStartedResponse(clusterManagerName, clusterService);
        clusterService.submitStateUpdateTask("test-delete-node-and-reroute", new ClusterStateUpdateTask() {
            .get();
            public void onFailure(String source, Exception e) {}
 * Licensed to Elasticsearch under one or more contributor
 */
                    .routingTable()
        final ClusterService clusterService = internalCluster().clusterService(clusterManagerName);
import static java.util.Collections.emptySet;
    }
            assertNotNull(mapper.mappers().getMapper("field"));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
        assertTrue(waitUntil(() -> clusterService.state().getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() == 3));
        );
import org.opensearch.indices.IndicesService;
                assertEquals(((Coordinator) instance).getApplierState().version(), applierVersion);
        // Block cluster state processing on the replica
                ClusterState.Builder builder = ClusterState.builder(currentState);
        // but the change might not be on the node that performed the indexing
        ensureGreen(index);
            logger.info("current state {} ", state);
                ClusterState updatedState = builder.build();
            assertNotNull(indexService);
        // due to publish_timeout of 0, wait for data node to have cluster state fully applied
        ensureYellow(index);
        final String clusterManagerName = internalCluster().getClusterManagerName();
                // primary must not be on the cluster-manager node
                return allocationService.disassociateDeadNodes(currentState, true, "reroute");
    protected int numberOfReplicas() {
    }
            } else {
        blockReplicaStart.set(false);
    public void testDelayedMappingPropagationOnReplica() throws Exception {
        clusterService.submitStateUpdateTask("test-delete-node-and-reroute", new ClusterStateUpdateTask() {
        final AllocationService allocationService = internalCluster().getInstance(AllocationService.class, clusterManagerName);
        // remove the extra node
            @Override
                .put("index.routing.allocation.include._name", clusterManager)
                builder.nodes(
                .state()
        assertEquals(clusterManager, state.nodes().getClusterManagerNode().getName());
        }
            }
                final IndexMetadata indexMetadata = IndexMetadata.builder(currentState.metadata().index(index))
        // this request does not change the cluster state, because the mapping is dynamic,
import org.opensearch.plugins.Plugin;
import org.opensearch.core.transport.TransportResponse;
                        .add(new DiscoveryNode("_non_existent", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT))
    public void testDisassociateNodesWhileShardInit() throws InterruptedException {
                builder.metadata(Metadata.builder(currentState.metadata()).put(indexMetadata, true));
            for (Discovery instance : internalCluster().getInstances(Discovery.class)) {
import org.opensearch.index.IndexService;
                // inject a node
        Thread.sleep(100);
        });
import org.opensearch.common.action.ActionFuture;
        assertBusy(() -> assertTrue(clusterManagerCoordinator.cancelCommittedPublication()));
import java.util.List;
import org.opensearch.common.settings.Settings;
        // The mappings have not been propagated to the replica yet as a consequence the document count not be indexed
            assertNotNull(mapper.mappers().getMapper("field2"));
        disruption.startDisrupting();
import java.util.concurrent.TimeUnit;
                builder.nodes(DiscoveryNodes.builder(currentState.nodes()).remove(primaryShard.currentNodeId()));
    }
                // open index
            }
        for (ShardRouting shard : shards) {
                    handler.messageReceived(request, channel, task);
    }
        // The ack timeout of 0 on dynamic mapping updates makes it possible for the document to be indexed on the primary, even
                // primary must be on the cluster-manager
    public void testAssignmentWithJustAddedNodes() {
        // but for replicas
            @Override
            long clusterManagerClusterStateVersion = internalCluster().clusterService(internalCluster().getClusterManagerName())
                logger.info("removed the node {}", primaryShard.currentNodeId());
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.concurrent.atomic.AtomicBoolean;
                Optional<ShardRouting> matchReplica = service.state()
        // is that cluster state processing is blocked and not just that it takes
import org.opensearch.cluster.node.DiscoveryNodes;
        final Index index = resolveIndex("index");
        prepareCreate("index").setSettings(
        disruption.stopDisrupting();
            assertNotNull(properties);
        internalCluster().setDisruptionScheme(disruption);
            @Override
    }
        });
        logger.info("--> delete index and recreate it");
        assertThat(dynamicMappingsFut.get(10, TimeUnit.SECONDS).getResult(), equalTo(CREATED));
                break;
            @Override
        // close to have some unassigned started shards shards..
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
        assertBusy(() -> {
                ClusterState.Builder builder = ClusterState.builder(currentState);
        refresh();
import static org.hamcrest.Matchers.instanceOf;
        });
        // Here we want to test that everything goes well if the mappings that
        logger.info("Initializing shards");
import org.opensearch.cluster.action.shard.ShardStateAction;
                assertTrue(shard.active());
        });
import org.opensearch.cluster.metadata.MappingMetadata;
        assertEquals(2, docIndexResponse.get(10, TimeUnit.SECONDS).getShardInfo().getTotal()); // both shards should have succeeded
        // close to have some unassigned started shards shards..
        final ActionFuture<IndexResponse> docIndexResponse = client().prepareIndex("index").setId("1").setSource("field", 42).execute();
            return clusterService.state().nodes().getSize() == 3;
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
        executeAndCancelCommittedPublication(
                routingTable.addAsRecovery(updatedState.metadata().index(index));
        // block so that replicas are always in init and not started
            assertFalse(clusterManagerCoordinator.publicationInProgress());
        // are needed for a document are not available on the replica at the
        // Wait for no publication in progress to not accidentally cancel a publication different from the one triggered by the given
        // if the dynamic mapping update is not applied on the replica yet.
        assertThat(docIndexResponse.get(10, TimeUnit.SECONDS), instanceOf(IndexResponse.class));
                otherNode = node;
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertNotNull(typeMappings);
        }));
        blockReplicaStart.set(true);
                    .filter(r -> incomingRequest.contains(r.allocationId().getId()))
import org.opensearch.OpenSearchParseException;
        assertFalse(docIndexResponse.isDone());
                Settings.builder()
            DocumentMapper mapper = mapperService.documentMapper();
        return List.of(MockTransportService.TestPlugin.class);
        internalCluster().setDisruptionScheme(disruption);
/*
            assertNotNull(mapper);
public class RareClusterStateIT extends OpenSearchIntegTestCase {
import org.opensearch.cluster.ClusterStateUpdateTask;
        ensureGreen("test");
        clusterService.submitStateUpdateTask("test-remove-injected-node", new ClusterStateUpdateTask() {
    }
        final AllocationService allocationService = internalCluster().getInstance(AllocationService.class, clusterManagerName);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0)
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("2").get().isTimedOut());
            if (shard.primary()) {
            @Override
                properties = typeMappings.getSourceAsMap().get("properties");
                ShardRouting primaryShard = currentState.getRoutingNodes().activePrimary(next.shardId());
        assertBusy(() -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // We wait on purpose to make sure that the document is not indexed because the shard operation is stalled
        assertThat(shards, hasSize(2));
            long dataClusterStateVersion = internalCluster().clusterService(dataNode).state().version();
                RoutingTable.Builder routingTable = RoutingTable.builder(updatedState.routingTable());
        });
        assertFalse(putMappingResponse.isDone());
            }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final ClusterService clusterService = internalCluster().clusterService(clusterManagerName);
        internalCluster().setDisruptionScheme(disruption);
        return 1;
/*
            } catch (OpenSearchParseException e) {
        // time of indexing it
 * this file be licensed under the Apache-2.0 license or a
                otherNode = node;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.routing.allocation.AllocationService;
        final String clusterManager = internalCluster().getClusterManagerName();
    @SuppressForbidden(reason = "Best effort sleep, not critical to test logic")
                final IndexMetadata indexMetadata = IndexMetadata.builder(currentState.metadata().index(index))
import static java.util.Collections.emptyMap;
    protected int numberOfShards() {
        return 0;
        BlockClusterStateProcessing disruption = new BlockClusterStateProcessing(otherNode, random());
            client().admin().indices().preparePutMapping("index").setSource("field", "type=long")
            final IndexService indexService = indicesService.indexServiceSafe(index);
        clusterService.submitStateUpdateTask("test-inject-node-and-reroute", new ClusterStateUpdateTask() {
                break;
        logger.info(clusterService.state().getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING));
            try {
                String incomingRequest = req.toString();
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("2").get().isTimedOut());
        List<ShardRouting> shards = state.routingTable().allShards("index");
                ShardStateAction.StartedShardEntry req = (ShardStateAction.StartedShardEntry) request;
        assertThat(nodeNames, hasItem(clusterManager));
                    .filter(r -> r.allocationId() != null)
    @Override
        internalCluster().startNode(Settings.builder().put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s"));
        ).get(10, TimeUnit.SECONDS);
        // trigger 2nd reroute after shard in initialized
            }
                return allocationService.reroute(currentState, "reroute");
            public void onFailure(String source, Exception e) {}
import java.util.Map;
            assertNotNull(indexService);
}
        assertEquals(1, docIndexResponse.get(10, TimeUnit.SECONDS).getShardInfo().getTotal());
import org.opensearch.index.mapper.MapperService;
        final Coordinator clusterManagerCoordinator = (Coordinator) internalCluster().getCurrentClusterManagerNodeInstance(Discovery.class);
 * software distributed under the License is distributed on an
    }
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("2").get().isTimedOut());
            }
        });
        ensureGreen(index);
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, master);
        );
    ) throws Exception {
        String otherNode = null;
                    .put("index.routing.allocation.exclude._name", clusterManager)
                logger.info("shard {}", next);
import org.opensearch.transport.TransportSettings;
        // another index request introduces the same mapping. The cluster-manager node
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", ""))
        // Add a new mapping...
 * SPDX-License-Identifier: Apache-2.0
        assertThat(docIndexResponse.get(10, TimeUnit.SECONDS), instanceOf(IndexResponse.class));
        disruption.startDisrupting();
            final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, clusterManager);
                builder.blocks(ClusterBlocks.builder().blocks(currentState.blocks()).removeIndexBlocks(index));
                    .state(IndexMetadata.State.OPEN)
            @Override
import org.opensearch.cluster.metadata.IndexMetadata;
            Settings.builder()
        ensureYellow(index);
                ClusterState state = allocationService.disassociateDeadNodes(currentState, true, "reroute");
                updatedState = ClusterState.builder(updatedState).routingTable(routingTable.build()).build();
        assertBusy(() -> {
            Object fieldMapping = ((Map<String, Object>) properties).get("field");
                    .build();
                builder.blocks(ClusterBlocks.builder().blocks(currentState.blocks()).removeIndexBlocks(index));
            if (blockReplicaStart.get()) {
                updatedState = ClusterState.builder(updatedState).routingTable(routingTable.build()).build();
    public void testDeleteCreateInOneBulk() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
                builder.nodes(DiscoveryNodes.builder(currentState.nodes()).remove("_non_existent"));
                return state;
                // remove the primary node of replica shard which is in init
            public void onFailure(String source, Exception e) {}
        }));
                ClusterState updatedState = builder.build();
 * KIND, either express or implied.  See the License for the
        );
        ActionFuture<IndexResponse> dynamicMappingsFut = executeAndCancelCommittedPublication(
        assertTrue(waitUntil(() -> {
            @Override
                .put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s")
                    .stream()
            public void onFailure(String source, Exception e) {}
        List<ShardRouting> shards = state.routingTable().allShards("index");
        disruption.stopDisrupting();
                assertFalse(state.nodes().getClusterManagerNodeId().equals(shard.currentNodeId()));
            @Override
        assertAcked(
import org.opensearch.test.transport.MockTransportService;
                throw new AssertionError(e);
        client().admin().indices().prepareClose(index).get();
            ClusterState state = clusterService.state();
            DocumentMapper mapper = mapperService.documentMapper();
        // create index with 3 primary and 1 replica each
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.action.index.IndexResponse;
        String node2 = internalCluster().startDataOnlyNode(
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        // request.
import java.util.Optional;
 * The OpenSearch Contributors require contributions made to
        String otherNode = null;
import org.opensearch.index.mapper.DocumentMapper;
        }
            prepareCreate("test").setSettings(
        // will reply immediately since it did not change the cluster state
            public ClusterState execute(ClusterState currentState) {
    @SuppressForbidden(reason = "Best effort sleep, not critical to test logic")
 * GitHub history for details.
            public ClusterState execute(ClusterState currentState) throws Exception {
 *
        internalCluster().startClusterManagerOnlyNode();
        final String index = "index";
        BlockClusterStateProcessing disruption = new BlockClusterStateProcessing(otherNode, random());
import java.util.Collection;
        // Force allocation of the primary on the cluster-manager node by first only allocating on the cluster-manager
        disruption.startDisrupting();
            @Override
        );
                Settings.builder()
                    .build();
        ensureGreen(index);
        // Wait for mappings to be available on cluster-manager
            // .put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "primaries")
        // this request does not change the cluster state, because mapping is already created,
    @Override
                logger.error(e.getMessage(), e);
    }
