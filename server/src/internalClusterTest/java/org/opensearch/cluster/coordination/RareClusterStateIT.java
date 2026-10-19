import org.opensearch.cluster.routing.allocation.AllocationService;
        ).get(10, TimeUnit.SECONDS);
                .put("index.routing.allocation.include._name", clusterManager)
        ).get();  
        ActionFuture<IndexResponse> docIndexResponse = client().prepareIndex("index").setId("1").setSource("field", 42).execute();  
        ensureGreen(index);
            assertNotNull(mapper);
                builder.blocks(ClusterBlocks.builder().blocks(currentState.blocks()).removeIndexBlocks(index));
        assertFalse(putMappingResponse.isDone());  
        return List.of(MockTransportService.TestPlugin.class);  
                    .build();
                // primary must be on the cluster-manager
            assertNotNull(mapper.mappers().getMapper("field"));
            public void onFailure(String source, Exception e) {}
            @Override
        // Add a new mapping...
        assertBusy(() -> {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.service.ClusterService;  
                builder.nodes(DiscoveryNodes.builder(currentState.nodes()).remove("_non_existent"));
            } else {
import java.util.Collection;
    @Override
        });  
        // Block cluster state processing on the replica  
    public void testDelayedMappingPropagationOnPrimary() throws Exception {
                    .filter(r -> r.allocationId() != null)
        final Index index = resolveIndex("index");
        final List<String> nodeNames = internalCluster().startNodes(2);  
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);  
    protected int numberOfReplicas() {
        return 0;  
            }
        // This is essentially the same thing as testDelayedMappingPropagationOnPrimary  
        });
            @Override  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            }  
            return clusterService.state().nodes().getSize() == 3;
            public void onFailure(String source, Exception e) {}
        client().admin().indices().prepareClose(index).get();
        // close to have some unassigned started shards shards..  
}
 * The OpenSearch Contributors require contributions made to  
            }  
 */  
        // and then allowing all nodes so that the replica gets allocated on the other node
        ).get();
        assertThat(nodeNames, hasItem(clusterManager));  
        final String clusterManagerName = internalCluster().startClusterManagerOnlyNode(  
            @Override
                    .state(IndexMetadata.State.OPEN)
import org.opensearch.test.OpenSearchIntegTestCase;
        prepareCreate("index").setSettings(  
        logger.info("--> letting cluster proceed");  
                builder.nodes(
        // Here we want to test that everything goes well if the mappings that
            final IndexService indexService = indicesService.indexServiceSafe(index);  
        }
        blockReplicaStart.set(true);
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        assertFalse(docIndexResponse.isDone());
 * license agreements. See the NOTICE file distributed with
        );
 */  
import org.opensearch.cluster.routing.ShardRoutingState;  
            @Override
            @Override
        // is that cluster state processing is blocked and not just that it takes  
        });  
        // remove the extra node
        internalCluster().startClusterManagerOnlyNode();
                return allocationService.disassociateDeadNodes(currentState, true, "reroute");
            @Override
        BlockClusterStateProcessing disruption = new BlockClusterStateProcessing(dataNode, random());
        clusterService.submitStateUpdateTask("test-inject-node-and-reroute", new ClusterStateUpdateTask() {
        // Wait a bit to make sure that the reason why we did not get a response
import org.opensearch.common.SuppressForbidden;
        internalCluster().setDisruptionScheme(disruption);
            .get();
        disruption.startDisrupting();  
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", ""))  
        // another index request introduces the same mapping. The cluster-manager node
    }
        assertEquals(clusterManager, state.nodes().getClusterManagerNode().getName());  
                RoutingTable.Builder routingTable = RoutingTable.builder(updatedState.routingTable());  
        assertTrue(waitUntil(() -> {
                    .build();
    public void testAssignmentWithJustAddedNodes() {  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        logger.info(clusterService.state().getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING));  
                logger.info("shard {}", next);
        index("test", MapperService.SINGLE_MAPPING_NAME, "1");
                .put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s")
        assertTrue(putMappingResponse.get(10, TimeUnit.SECONDS).isAcknowledged());
                if (matchReplica.isPresent()) {
 * KIND, either express or implied.  See the License for the
        // we don't await and cancel committed publication
        // we need to await and cancel committed publication
            if (shard.primary()) {
        logger.info("Initializing shards");
        disruption.stopDisrupting();  
import org.opensearch.transport.TransportService;
        );
        // Now make sure the indexing request finishes successfully
        });  
            client().admin().indices().preparePutMapping("index").setSource("field", "type=long")
        final String clusterManager = internalCluster().getClusterManagerName();  
import org.opensearch.cluster.node.DiscoveryNodes;  
            @Override  
import java.util.Map;
        assertThat(dynamicMappingsFut.get(10, TimeUnit.SECONDS).getResult(), equalTo(CREATED));
import org.opensearch.cluster.node.DiscoveryNode;
            if (node.equals(clusterManager) == false) {
        assertAcked(  
            }
        assertTrue(waitUntil(() -> clusterService.state().getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() == 3));
import org.opensearch.core.index.Index;  
            assertNotNull(indexService);
        assertBusy(() -> assertTrue(clusterManagerCoordinator.cancelCommittedPublication()));
 * You may obtain a copy of the License at  
            public ClusterState execute(ClusterState currentState) {
                builder.nodes(DiscoveryNodes.builder(currentState.nodes()).remove(primaryShard.currentNodeId()));
        assertThat(shards, hasSize(1));
 *  
        assertBusy(() -> assertTrue(client().prepareGet("index", "1").get().isExists()));
        // index another document, this time using dynamic mappings.  
                String incomingRequest = req.toString();
                handler.messageReceived(request, channel, task);
        final AllocationService allocationService = internalCluster().getInstance(AllocationService.class, clusterManagerName);
        assertNotNull(otherNode);  
                } else {
            DocumentMapper mapper = mapperService.documentMapper();  
            for (Discovery instance : internalCluster().getInstances(Discovery.class)) {  
        String otherNode = null;
import org.opensearch.common.action.ActionFuture;
        assertNotNull(otherNode);
            assertNotNull(fieldMapping);
        internalCluster().setDisruptionScheme(disruption);
import org.opensearch.cluster.ClusterState;
        // but the change might not be on the node that performed the indexing  
        final List<String> nodeNames = internalCluster().startNodes(2);
            final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, clusterManager);
import org.opensearch.OpenSearchParseException;
        // trigger 2nd reroute after shard in initialized
        disruption.startDisrupting();
                currentState = builder.build();  
            @Override
                logger.info("ShardStateAction.StartedShardEntry {}", stringRep);
                .version();
                updatedState = ClusterState.builder(updatedState).routingTable(routingTable.build()).build();
import static org.opensearch.cluster.action.shard.ShardStateAction.SHARD_STARTED_ACTION_NAME;  
        ActionFuture<Res> future = req.execute();
        executeAndCancelCommittedPublication(
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("2").get().isTimedOut());  
                .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_BATCH_MODE.getKey(), true)  
import org.opensearch.Version;
            }  
import static org.hamcrest.Matchers.hasItem;
        return 1;
    protected int numberOfShards() {  
public class RareClusterStateIT extends OpenSearchIntegTestCase {  
                final IndexMetadata indexMetadata = IndexMetadata.builder(currentState.metadata().index(index))
                ClusterState updatedState = builder.build();
            Settings.builder()
                break;  
                    .build();  
            }
    @SuppressForbidden(reason = "Best effort sleep, not critical to test logic")
        // ...and wait for mappings to be available on cluster-manager
 *
    AtomicBoolean blockReplicaStart = new AtomicBoolean(false);
        internalCluster().startDataOnlyNode(Settings.builder().put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s").build());
 * under the License.  
                    handler.messageReceived(request, channel, task);
                routingTable.addAsRecovery(updatedState.metadata().index(index));
        ActionFuture<IndexResponse> dynamicMappingsFut = executeAndCancelCommittedPublication(
                // open index  
        logger.info(clusterService.state().getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING));
import org.opensearch.test.transport.MockTransportService;
            } else {
            ClusterState state = clusterService.state();
    }
        ensureGreen(index);
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            Settings.builder().put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s").build()  
                logger.error(e.getMessage(), e);  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Check routing tables
    }
        final String index = "index";  
            .prepareUpdateSettings("index")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            long clusterManagerClusterStateVersion = internalCluster().clusterService(internalCluster().getClusterManagerName())  
import org.opensearch.action.ActionRequestBuilder;
        disruption.stopDisrupting();
                // open index
            }
                ClusterState.Builder builder = ClusterState.builder(currentState);  
        assertBusy(() -> assertTrue(client().prepareGet("index", "2").setPreference("_primary").get().isExists()));
        // time of indexing it
            ClusterState state = clusterService.state();  
                ShardRouting primaryShard = currentState.getRoutingNodes().activePrimary(next.shardId());
        // Wait for mappings to be available on cluster-manager  
import org.opensearch.cluster.routing.ShardRouting;
import java.util.concurrent.TimeUnit;  
            }
        // this request does not change the cluster state, because the mapping is dynamic,  
        );  
        assertHitCount(client().prepareSearch("test").get(), 0);  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
/*  
        return future;  
import static java.util.Collections.emptyMap;  
            @Override
import org.opensearch.discovery.Discovery;
                    .routingTable()  
                return state;
        }
            Object properties;
        assertBusy(() -> {
import org.opensearch.cluster.metadata.Metadata;
/*  
            assertNotNull(properties);
        for (ShardRouting shard : shards) {  
                logger.info("removed the node {}", primaryShard.currentNodeId());
        internalCluster().setDisruptionScheme(disruption);  
            MappingMetadata typeMappings = client().admin().indices().prepareGetMappings("index").get().getMappings().get("index");  
            try {  
import static org.hamcrest.Matchers.hasSize;
            public void onFailure(String source, Exception e) {}
    }
import java.util.Optional;
    public void testDisassociateNodesWhileShardInit() throws InterruptedException {
    }  
/*
        assertEquals(clusterManager, state.nodes().getClusterManagerNode().getName());  
        assertBusy(() -> {
        // Here we want to test that things go well if there is a first request
        // Now make sure the indexing request finishes successfully  
        });
        // due to publish_timeout of 0, wait for data node to have cluster state fully applied
            public ClusterState execute(ClusterState currentState) {
        assertThat(docIndexResponse.get(10, TimeUnit.SECONDS), instanceOf(IndexResponse.class));  
                .state()
 * SPDX-License-Identifier: Apache-2.0
                );
import org.opensearch.common.unit.TimeValue;
            prepareCreate("test").setSettings(
        // Force allocation of the primary on the cluster-manager node by first only allocating on the cluster-manager
        assertEquals(1, docIndexResponse.get(10, TimeUnit.SECONDS).getShardInfo().getTotal());
 *    http://www.apache.org/licenses/LICENSE-2.0
                builder.blocks(ClusterBlocks.builder().blocks(currentState.blocks()).removeIndexBlocks(index));
            public void onFailure(String source, Exception e) {
            public ClusterState execute(ClusterState currentState) {
import org.opensearch.core.transport.TransportResponse;
                    .getShardRoutings()
                fail(); // only primaries
                ClusterState.Builder builder = ClusterState.builder(currentState);
            }
        ensureGreen("test");
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // The mappings have not been propagated to the replica yet as a consequence the document count not be indexed
        // block none cluster-manager node.
        ensureYellow(index);
                updatedState = ClusterState.builder(updatedState).routingTable(routingTable.build()).build();
        assertFalse(docIndexResponse.isDone());  
        // will reply immediately since it did not change the cluster state
        );
        String otherNode = null;
                ClusterState state = allocationService.reroute(updatedState, "reroute");  
import org.opensearch.action.ActionRequest;  
import org.opensearch.cluster.routing.allocation.ExistingShardsAllocator;
            assertNotNull(indexService);
        logger.info("--> indexing a doc");
            } catch (OpenSearchParseException e) {
 * Unless required by applicable law or agreed to in writing,
            logger.info("current state {} ", state);  
import org.opensearch.cluster.ClusterStateUpdateTask;
    public void testDelayedMappingPropagationOnReplica() throws Exception {
import org.opensearch.index.IndexService;  
 * this work for additional information regarding copyright
        final ClusterService clusterService = internalCluster().clusterService(clusterManagerName);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        // Don't allocate the shard on the cluster-manager node
import org.opensearch.cluster.action.shard.ShardStateAction;  
import static org.hamcrest.Matchers.instanceOf;  
                otherNode = node;
            Object fieldMapping = ((Map<String, Object>) properties).get("field");  
        }));  
            client().admin().indices().preparePutMapping("index").setSource("field", "type=long")
        final ActionFuture<IndexResponse> docIndexResponse = client().prepareIndex("index").setId("1").setSource("field", 42).execute();
            public ClusterState execute(ClusterState currentState) {
        ensureGreen();
        prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)).get();
                // remove the primary node of replica shard which is in init  
                return state;
            // .put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "primaries")
import org.opensearch.cluster.metadata.MappingMetadata;  
                .build()
    }
            }
        });
                assertFalse(state.nodes().getClusterManagerNodeId().equals(shard.currentNodeId()));  
                    .state(IndexMetadata.State.OPEN)  
            assertThat(clusterManagerClusterStateVersion, equalTo(dataClusterStateVersion));
                String stringRep = req.toString();
            @Override  
            ).setTimeout("0s")  
                updatedState = ClusterState.builder(updatedState).routingTable(routingTable.build()).build();
                assertTrue(shard.active());
            final long applierVersion = clusterManagerCoordinator.getApplierState().version();
                ClusterState.Builder builder = ClusterState.builder(currentState);
        refresh();  
        BlockClusterStateProcessing disruption = new BlockClusterStateProcessing(otherNode, random());
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("2").get().isTimedOut());  
            public void onFailure(String source, Exception e) {}
 * Licensed to Elasticsearch under one or more contributor  
                routingTable.addAsRecovery(updatedState.metadata().index(index));
 * GitHub history for details.
        );
    }  
package org.opensearch.cluster.coordination;
 * Modifications Copyright OpenSearch Contributors. See
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0)
                ClusterState.Builder builder = ClusterState.builder(currentState);  
            final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, clusterManager);
        }));  
                otherNode = node;
            assertNotNull(typeMappings);
            client().prepareIndex("index").setId("2").setSource("field2", 42)  
import org.opensearch.indices.IndicesService;  
        final Coordinator clusterManagerCoordinator = (Coordinator) internalCluster().getCurrentClusterManagerNodeInstance(Discovery.class);
        }
            return state.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() == 3;
    public void testDeleteCreateInOneBulk() throws Exception {  
        );
            public ClusterState execute(ClusterState currentState) throws Exception {
import org.opensearch.index.mapper.MapperService;
        // but for replicas
    @Override
        prepareCreate(index).setSettings(  
                ShardStateAction.StartedShardEntry req = (ShardStateAction.StartedShardEntry) request;  
                properties = typeMappings.getSourceAsMap().get("properties");
import org.opensearch.action.index.IndexResponse;
            if (node.equals(clusterManager) == false) {  
        disruption.startDisrupting();  
        assertTrue(putMappingResponse.get(10, TimeUnit.SECONDS).isAcknowledged());
        // that adds mappings but before mappings are propagated to all nodes  
                assertEquals(state.nodes().getClusterManagerNodeId(), shard.currentNodeId());  
        Thread.sleep(100);
            if (shard.primary()) {
                ClusterState updatedState = builder.build();
    }
                        .add(new DiscoveryNode("_non_existent", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT))  
        disruption.stopDisrupting();
                ClusterState.Builder builder = ClusterState.builder(currentState);  
            assertNotNull(mapper.mappers().getMapper("field2"));
        executeAndCancelCommittedPublication(client().admin().indices().prepareDelete("test").setTimeout("0s")).get(10, TimeUnit.SECONDS);  
        ActionRequestBuilder<Req, Res> req
 * the Apache License, Version 2.0 (the "License"); you may
        // ...and wait for second mapping to be available on cluster-manager  
                    .stream()  
            }
                ClusterState state = allocationService.disassociateDeadNodes(currentState, true, "reroute");  
        ensureYellow(index);
        assertFalse(putMappingResponse.isDone());
                RoutingTable.Builder routingTable = RoutingTable.builder(updatedState.routingTable());  
import org.opensearch.plugins.Plugin;
        logger.info("--> delete index and recreate it");
                    .findAny();  
        internalCluster().startNode(Settings.builder().put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s"));
        // operation yet
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, master);
        // are needed for a document are not available on the replica at the  
                // inject a node
        // Block cluster state processing where our shard is  
        ).get();
        final String index = "index";
        });
        final AllocationService allocationService = internalCluster().getInstance(AllocationService.class, clusterManagerName);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ActionFuture<AcknowledgedResponse> putMappingResponse = executeAndCancelCommittedPublication(  
        client().admin().indices().prepareClose(index).get();  
        assertBusy(() -> {  
            ).get()  
                    .put("index.routing.allocation.exclude._name", clusterManager)
            }
 * compatible open source license.
 * specific language governing permissions and limitations
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        blockShardStartedResponse(clusterManagerName, clusterService);
        for (ShardRouting shard : shards) {  
import org.opensearch.cluster.routing.RoutingTable;
        clusterService.submitStateUpdateTask("test-remove-injected-node", new ClusterStateUpdateTask() {  
        clusterService.submitStateUpdateTask("test-delete-node-and-reroute", new ClusterStateUpdateTask() {  
            prepareCreate("index").setSettings(
            long dataClusterStateVersion = internalCluster().clusterService(dataNode).state().version();  
 * not use this file except in compliance with the License.
        assertTrue(waitUntil(() -> {
                currentState = builder.build();  
                final IndexMetadata indexMetadata = IndexMetadata.builder(currentState.metadata().index(index))  
        clusterService.submitStateUpdateTask("test-delete-node-and-reroute", new ClusterStateUpdateTask() {  
            public ClusterState execute(ClusterState currentState) throws Exception {
        assertBusy(() -> {
        final String clusterManagerName = internalCluster().getClusterManagerName();
import static org.hamcrest.Matchers.equalTo;  
                }  
                Optional<ShardRouting> matchReplica = service.state()
        for (String node : nodeNames) {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        assertThat(nodeNames, hasItem(clusterManager));
import static java.util.Collections.emptySet;
        });  
            }
        String node2 = internalCluster().startDataOnlyNode(
        });  
        Thread.sleep(100);
        clusterService.submitStateUpdateTask("test-inject-node-and-reroute", new ClusterStateUpdateTask() {
        // Check routing tables
        ensureGreen(index);  
        // The ack timeout of 0 on dynamic mapping updates makes it possible for the document to be indexed on the primary, even
            .indices()
        clusterService.submitStateUpdateTask("test-remove-injected-node", new ClusterStateUpdateTask() {  
            } else {
        assertThat(docIndexResponse.get(10, TimeUnit.SECONDS), instanceOf(IndexResponse.class));
                Settings.builder()  
        // time to process the indexing request
            @Override
 * software distributed under the License is distributed on an
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                RoutingTable.Builder routingTable = RoutingTable.builder(updatedState.routingTable());  
        assertFalse(client().admin().cluster().prepareHealth().setWaitForNodes("2").get().isTimedOut());
        List<ShardRouting> shards = state.routingTable().allShards("index");
        ensureGreen(TimeValue.timeValueMinutes(30), "test");  
        for (String node : nodeNames) {  
        assertThat(shards, hasSize(2));
                builder.metadata(Metadata.builder(currentState.metadata()).put(indexMetadata, true));  
        final ActionFuture<AcknowledgedResponse> putMappingResponse = executeAndCancelCommittedPublication(
                final IndexMetadata indexMetadata = IndexMetadata.builder(currentState.metadata().index(index))
    }
                routingTable.addAsRecovery(updatedState.metadata().index(index));
        assertEquals(2, docIndexResponse.get(10, TimeUnit.SECONDS).getShardInfo().getTotal()); // both shards should have succeeded  
        ensureGreen();
            Settings.builder()
    @SuppressForbidden(reason = "Best effort sleep, not critical to test logic")  
 */
        // block so that replicas are always in init and not started  
            }  
                    .state(IndexMetadata.State.OPEN)
        // and not just because it takes time to replicate the indexing request to the replica  
        BlockClusterStateProcessing disruption = new BlockClusterStateProcessing(otherNode, random());
            assertNotNull(mapper);
import org.opensearch.common.settings.Settings;  
    }
import org.opensearch.core.action.ActionResponse;
        List<ShardRouting> shards = state.routingTable().allShards("index");
                assertEquals(((Coordinator) instance).getApplierState().version(), applierVersion);
            public void onFailure(String source, Exception e) {}
    @Override
        // this request does not change the cluster state, because mapping is already created,
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.List;  
                    DiscoveryNodes.builder(currentState.nodes())
            @Override
        ensureGreen(index);
                    .filter(r -> incomingRequest.contains(r.allocationId().getId()))
                ClusterState updatedState = builder.build();
        // Wait for no publication in progress to not accidentally cancel a publication different from the one triggered by the given  
import org.opensearch.index.mapper.DocumentMapper;
                throw new AssertionError(e);  
                Settings.builder()
        });  
        // We wait on purpose to make sure that the document is not indexed because the shard operation is stalled
        // request.
import java.util.concurrent.atomic.AtomicBoolean;
                builder.metadata(Metadata.builder(currentState.metadata()).put(indexMetadata, true));
    private void blockShardStartedResponse(String master, ClusterService service) {
                builder.blocks(ClusterBlocks.builder().blocks(currentState.blocks()).removeIndexBlocks(index));  
        final ClusterService clusterService = internalCluster().clusterService(clusterManagerName);  
            DocumentMapper mapper = mapperService.documentMapper();  
            final MapperService mapperService = indexService.mapperService();
            final MapperService mapperService = indexService.mapperService();
                // primary must not be on the cluster-manager node
                return allocationService.reroute(currentState, "reroute");  
                return allocationService.reroute(updatedState, "reroute");
        String dataNode = internalCluster().startDataOnlyNode();
import static org.opensearch.action.DocWriteResponse.Result.CREATED;
    private <Req extends ActionRequest, Res extends ActionResponse> ActionFuture<Res> executeAndCancelCommittedPublication(  
import org.opensearch.cluster.block.ClusterBlocks;
                return allocationService.reroute(updatedState, "reroute");
            final IndexService indexService = indicesService.indexServiceSafe(index);  
        // close to have some unassigned started shards shards..
            if (blockReplicaStart.get()) {
        });  
        internalCluster().startDataOnlyNode(Settings.builder().put(TransportSettings.CONNECT_TIMEOUT.getKey(), "1s").build());  
                    .allShardsSatisfyingPredicate(r -> !r.primary())
                ShardRouting next = currentState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0);
 * this file be licensed under the Apache-2.0 license or a
 *
                builder.metadata(Metadata.builder(currentState.metadata()).put(indexMetadata, true));  
        blockReplicaStart.set(false);  
        client().admin()  
                break;
            assertFalse(clusterManagerCoordinator.publicationInProgress());
        primaryService.addRequestHandlingBehavior(SHARD_STARTED_ACTION_NAME, (handler, request, channel, task) -> {  
import org.opensearch.transport.TransportSettings;  
        prepareCreate(index).setSettings(  
        }
        });
        // create index with 3 primary and 1 replica each
        final String clusterManager = internalCluster().getClusterManagerName();
                    .put(IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), "0")
import org.opensearch.test.disruption.BlockClusterStateProcessing;  
        // if the dynamic mapping update is not applied on the replica yet.
    ) throws Exception {
