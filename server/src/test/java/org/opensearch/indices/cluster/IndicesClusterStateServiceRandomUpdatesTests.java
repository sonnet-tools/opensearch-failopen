        }
    @Override  
                containsClosedIndex = true;  
            state = cluster.createIndex(state, request);  
        for (String index : randomSubsetOf(numberOfIndicesToOpen, state.metadata().indices().keySet().toArray(new String[0]))) {  
     * This can happen by batching cluster states that include the starting of the replica, with
                : NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES;  
import org.opensearch.index.seqno.RetentionLeaseSyncer;
package org.opensearch.indices.cluster;
        }  
        final MockIndicesService indicesService = indicesServiceSupplier.get();
        ClusterState localState = adaptClusterStateToLocalNode(stateWithIndex, node);  
    private ThreadPool threadPool;  
            .metadata(Metadata.builder(stateWithIndex.metadata()).remove(name))  
import java.util.ArrayList;
        );  
        indicesCSSvc.start();  
        state = cluster.applyFailedShards(state, failedShards);  
        indicesCSSvc.handleRecoveryFailure(shardRouting, false, new Exception("dummy"));
            state = cluster.deleteIndices(state, deleteRequest);  
                    updateNodes(state, clusterStateServiceMap, indicesServiceSupplier);  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
     * question. The node should then clean it's initializing replica and replace it with a new
    public void testRecoveryFailures() {
            indicesToDelete.add(state.metadata().index(index).getIndex().getName());
        final Settings settings = Settings.builder().put("node.name", discoveryNode.getName()).build();
    }
    }
                IndicesClusterStateService indicesClusterStateService = clusterStateServiceMap.get(node);
        when(threadPool.generic()).thenReturn(mock(ExecutorService.class));  
        assertNotNull(indicesCSSvc.indicesService.getShardOrNull(shardId));  
    ) {
        IndicesClusterStateService indicesCSSvc = createIndicesClusterStateService(node, RecordingIndicesService::new);
                    if (randomBoolean()) {
            null,
            clusterService
        );  
        indicesCSSvc.applyClusterState(new ClusterChangedEvent("cluster state change that adds the index", localState, previousLocalState));  
        // if no_cluster_manager block is in place, make no other cluster state changes
                assertFalse(state.metadata().hasIndex(index));
        ClusterState previousLocalState = adaptClusterStateToLocalNode(previousState, node);  
 * compatible open source license.
            null,  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
                            node,  
        allNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
                    ShardRouting persistedShardRouting = indexShard.routingEntry();  
        assertNotNull(indicesCSSvc.indicesService.getShardOrNull(shardId));
            settings,  
                        // and add it back
        final TransportService transportService = new TransportService(  
                ics.start();  
        );  
                    DiscoveryNode discoveryNode = randomFrom(state.nodes().getNodes().values().toArray(new DiscoveryNode[0]));
            state = cluster.reroute(state, new ClusterRerouteRequest());
                    } else if (rarely()) {  
        final ShardStateAction shardStateAction = mock(ShardStateAction.class);
        localState = adaptClusterStateToLocalNode(state, node);  
            }
    private ClusterStateChanges cluster;
import java.util.Collections;
        // create a new empty cluster state with a brand new cluster UUID  
            UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(indicesToUpdate.toArray(new String[0]));
    private static final AtomicInteger nodeIdGenerator = new AtomicInteger();  
        List<FailedShard> failedShards = new ArrayList<>();  
    ) {
                int min = randomInt(2);
            Settings.Builder settingsBuilder = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 3));  
            }
            OpenIndexRequest openIndexRequest = new OpenIndexRequest(state.metadata().index(index).getIndex().getName());
        final MockIndexShard shardOrNull = ((RecordingIndicesService) indicesCSSvc.indicesService).getShardOrNull(shardId);
import org.opensearch.common.util.set.Sets;
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            clusterService,
        // start the replica  
            index,
            ReferencedSegmentsPublisher.EMPTY  
        // check that failing unrelated allocation does not remove shard
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;  
        @Override
            assertNull(indicesService.indexService(index));  
                if (state.nodes().getSize() < 10) {
            .routingTable(RoutingTable.builder().build())
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(state.metadata().index(index).getIndex().getName());
        ClusterState stateWithIndex = ClusterStateCreationUtils.state(name, randomBoolean(), ShardRoutingState.INITIALIZING, replicaStates);
                            event.state()
                            event.previousState(),
 */  
import java.util.HashMap;
                    indicesClusterStateService.applyClusterState(event);
        final ClusterService clusterService = mock(ClusterService.class);
        String index = "index_" + randomAlphaOfLength(8).toLowerCase(Locale.ROOT);  
        ClusterState state = randomInitialClusterState(clusterStateServiceMap, MockIndicesService::new);
        }  
                        updateNodes(state, clusterStateServiceMap, indicesServiceSupplier);
                    logger.error(  
            if (randomBoolean()) {
        }  
            }
 * under the License.  
                // check that cluster state has been properly applied to node  
        // simulate the cluster state change on the node
        }
        state = cluster.closeIndices(state, closeIndexRequest);
     * not have received the cluster block, in which case we still need to remove the in-memory
        }
     * initializing primary.
            repositoriesService,
            .build();  
        Arrays.fill(replicaStates, ShardRoutingState.INITIALIZING);
            if (containsClosedIndex == false) {  
import org.opensearch.cluster.block.ClusterBlock;
        indicesCSSvc.applyClusterState(
        // randomly update settings
            for (String index : indicesToDelete) {
        if (rarely() && state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID) == false) {  
                newSet.add(index);  
                deletedIndices = Collections.unmodifiableSet(newSet);
                try {  
    }
 * Modifications Copyright OpenSearch Contributors. See
        if (indicesToDelete.isEmpty() == false) {
        List<DiscoveryNode> allNodes = new ArrayList<>();
        // randomly start and fail allocated shards
    protected DiscoveryNode createNode(DiscoveryNodeRole... mustHaveRoles) {
        for (int i = 0; i < 30; i++) {  
            null,
            randomBoolean(),  
        DiscoveryNode node = state.nodes().get(shardRouting.currentNodeId());
        if (rarely()) {  
        ClusterState state,
import org.opensearch.indices.replication.SegmentReplicationTargetService;  
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), Collections.emptyMap(), roles, Version.CURRENT);  
            new ClusterChangedEvent(  
     * shard that's in POST_RECOVERY with a new initializing primary with the same allocation id.
        final PrimaryReplicaSyncer primaryReplicaSyncer = mock(PrimaryReplicaSyncer.class);
        final ShardRouting shardRouting = state.routingTable().index(index).shard(0).replicaShards().get(0);  
            if (randomBoolean()) {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
 * license agreements. See the NOTICE file distributed with
        Map<DiscoveryNode, IndicesClusterStateService> clusterStateServiceMap,  
                    ClusterState finalState = state;  
                        updateNodes(state, clusterStateServiceMap, indicesServiceSupplier);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            .metadata(Metadata.builder(state.metadata()).remove(index))
        // simulate the cluster state change on the node
    }
        for (IndexMetadata indexMetadata : stateWithIndex.metadata()) {
        state = cluster.applyStartedShards(state, state.routingTable().index(index).shard(0).replicaShards());
        assertThat(  
                for (MockIndexShard indexShard : indexService) {
        }  
import org.opensearch.transport.TransportService;  
import org.opensearch.cluster.routing.RoutingTable;
            ShardRoutingState.INITIALIZING
            }
            indicesService,
import java.util.function.Supplier;  
                settingsBuilder.put(SETTING_AUTO_EXPAND_REPLICAS, randomBoolean() ? min + "-" + max : min + "-all");
        // randomly open indices
                        error
            threadPool
                    if (discoveryNode.equals(state.nodes().getClusterManagerNode()) == false) {  
            if (state.nodes().nodeExists(node) == false) {
import org.opensearch.transport.Transport;
            .metadata(Metadata.builder(initialState.metadata()).clusterUUID(UUIDs.randomBase64UUID()))
        ClusterState localState = adaptClusterStateToLocalNode(state, node);
            String name = "index_" + randomAlphaOfLength(15).toLowerCase(Locale.ROOT);
                // add node  
        // randomly remove no_cluster_manager blocks  
        ClusterState state = ClusterStateCreationUtils.state(
            indicesToUpdate.add(state.metadata().index(index).getIndex().getName());
}
     * imported as dangling indices.  Normally, the first cluster state update that the node
            DeleteIndexRequest deleteRequest = new DeleteIndexRequest(indicesToDelete.toArray(new String[0]));
            assertTrue(state.metadata().hasIndex(name));
        updateNodes(state, clusterStateServiceMap, indicesServiceSupplier);  
 *  
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
                            "failed to apply change on [{}].\n ***  Previous state ***\n{}\n ***  New state ***\n{}",
        Supplier<MockIndicesService> indicesServiceSupplier
        indicesCSSvc.start();
        public synchronized boolean isDeleted(Index index) {
                Set<Index> newSet = Sets.newHashSet(deletedIndices);
                        new ParameterizedMessage(
            .routingTable(RoutingTable.builder().build())
        ClusterState previousLocalState = adaptClusterStateToLocalNode(initialState, node);
                .build();
    @Override
import org.opensearch.core.index.Index;  
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
     * different from the cluster it was previously a part of, the in-memory index data structures
            Settings.Builder settings = Settings.builder();
import java.util.concurrent.atomic.AtomicInteger;
                ClusterState previousLocalState = adaptClusterStateToLocalNode(previousState, node);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }  
    public void testJoiningNewClusterOnlyRemovesInMemoryIndexStructures() {  
        int numberOfIndicesToOpen = randomInt(Math.min(1, state.metadata().indices().size()));
        }
            });
import org.opensearch.threadpool.ThreadPool;
        ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
    private static ClusterState adaptClusterStateToLocalNode(ClusterState state, DiscoveryNode node) {  
        ClusterState previousState = ClusterState.builder(state)  
import org.opensearch.indices.replication.SegmentReplicationSourceService;
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
    private IndicesClusterStateService createIndicesClusterStateService(
        indicesCSSvc.handleRecoveryFailure(shardRouting.reinitializeReplicaShard(), false, new Exception("dummy"));
 * Unless required by applicable law or agreed to in writing,
        terminate(threadPool);
            final ClusterState previousState = state;
        // pick a data node to simulate the adding an index cluster state change event on, that has shards assigned to it
import org.opensearch.cluster.metadata.IndexMetadata;
            for (MockIndexService indexService : indicesService) {
            }  
            primaryReplicaSyncer,  
     */
        // add nodes to clusterStateServiceMap
     * scenario.
import java.util.Map.Entry;
        state = cluster.applyStartedShards(state, startedShards);
     * closing of the indices, opening it up again and allocating the primary shard to the node in  
            state = cluster.closeIndices(state, closeIndexRequest);
            randomBoolean(),  
 * specific language governing permissions and limitations
            for (int j = 0; j < randomInt(3); j++) { // multiple iterations to simulate batching of cluster states
            }
        for (String index : randomSubsetOf(numberOfIndicesToDelete, state.metadata().indices().keySet().toArray(new String[0]))) {
        // TODO: check if we can go to green by starting all shards and finishing all iterations
        }
import org.opensearch.Version;
                )
import org.opensearch.cluster.ClusterState;  
            s -> {},
        // simulate the cluster state change on the node
            updateSettingsRequest.settings(settings.build());
        int numberOfIndicesToDelete = randomInt(Math.min(2, state.metadata().indices().size()));  
            mock(SegmentReplicationSourceService.class),
                // remove node  
    }
    ) {
                IndicesClusterStateService ics = createIndicesClusterStateService(discoveryNode, indicesServiceSupplier);
                        startedShards.put(persistedShardRouting, indexShard.term());
            .build();  
                ? NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL
                        state = cluster.addNodes(state, Collections.singletonList(discoveryNode));  
            return deletedIndices.contains(index);  
import org.opensearch.cluster.node.DiscoveryNodeRole;
import static org.mockito.Mockito.when;
        previousLocalState = adaptClusterStateToLocalNode(previousState, node);
import org.opensearch.threadpool.TestThreadPool;  
        );
                    ClusterBlocks.builder()
        disableRandomFailures();
     * but in the case where the node joined and was a few cluster state updates behind, it would
            index,
 * GitHub history for details.
                    }  
        // the initial state which is derived from the newly created cluster state but doesn't contain the index
        assertNull(indicesCSSvc.indicesService.getShardOrNull(shardId));  
            transportService,
import static org.mockito.Mockito.mock;
    private class RecordingIndicesService extends MockIndicesService {
        // randomly close indices  
            ShardRoutingState.STARTED,
import org.opensearch.cluster.node.DiscoveryNodes;  
                settings.put(SETTING_NUMBER_OF_REPLICAS, randomInt(2));
                "cluster state change with a new cluster UUID (and doesn't contain the index)",
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;  
        // TODO: go cluster-managerless?
            Collections.emptyMap(),  
        final Map<DiscoveryNode, IndicesClusterStateService> clusterStateServiceMap = new HashMap<>();  
                        .removeGlobalBlock(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID)  
        final String id = String.format(Locale.ROOT, "node_%03d", nodeIdGenerator.incrementAndGet());
                assertClusterStateMatchesNodeState(localState, indicesClusterStateService);
            .routingTable(RoutingTable.builder().build())
            RetentionLeaseSyncer.EMPTY,
            }
        // close the index and open it up again (this will sometimes swap roles between primary and replica)  
import org.opensearch.index.shard.PrimaryReplicaSyncer;  
            allNodes.add(createNode());
        }
    /**  
            super.removeIndex(index, reason, extraInfo);  
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
        // check that in memory data structures have been removed once the new cluster state is applied,
                        failedShards.add(new FailedShard(persistedShardRouting, "fake shard failure", new Exception(), randomBoolean()));
        state = cluster.openIndices(state, openIndexRequest);
            IndicesClusterStateService indicesClusterStateService = clusterStateServiceMap.get(node);
        }
                previousLocalState  
    }  
        DiscoveryNode node = state.nodes().get(shardRouting.currentNodeId());
        }  
                    state = randomlyUpdateClusterState(state, clusterStateServiceMap, MockIndicesService::new);
        return new IndicesClusterStateService(  
     */  
        ClusterState previousLocalState = adaptClusterStateToLocalNode(previousState, node);  
 */
        threadPool = new TestThreadPool(getClass().getName());  
        if (indicesToUpdate.isEmpty() == false) {  
                .blocks(  
            for (DiscoveryNode node : state.nodes()) {
        // at least two nodes that have the data role so that we can allocate shards
                    }
                }
                int max = min + randomInt(3);  
            NoopTracer.INSTANCE
                settingsBuilder.put(SETTING_NUMBER_OF_REPLICAS, randomInt(2));  
 * KIND, either express or implied.  See the License for the
            } else {
                    logger.error(() -> new ParameterizedMessage("failed to random change state. last good state: \n{}", finalState), error);
        for (String index : randomSubsetOf(numberOfIndicesToUpdate, state.metadata().indices().keySet().toArray(new String[0]))) {  
        for (int i = 0; i < randomInt(5); i++) {
            CloseIndexRequest closeIndexRequest = new CloseIndexRequest(state.metadata().index(index).getIndex().getName());  
        localState = adaptClusterStateToLocalNode(newClusterState, node);  
import org.opensearch.cluster.node.DiscoveryNode;
        final RepositoriesService repositoriesService = new RepositoriesService(
                if (state.nodes().getDataNodes().size() > 3) {
        indicesCSSvc.applyClusterState(new ClusterChangedEvent("cluster state change that adds the index", localState, previousLocalState));  
        );  
            MockIndicesService indicesService = (MockIndicesService) indicesClusterStateService.indicesService;  
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
                return ics;
        if (rarely()) {
        // pick a data node to simulate the adding an index cluster state change event on, that has shards assigned to it
        ClusterState newClusterState = ClusterState.builder(initialState)
                    throw error;
    }
                        state = cluster.removeNodes(state, Collections.singletonList(discoveryNode));
        // each of the following iterations represents a new cluster state update processed on all nodes
     * receives from the new cluster would contain a cluster block that would cause all in-memory
        if (state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID)) {
            Collections.emptySet(),
import org.opensearch.cluster.block.ClusterBlocks;  
    public ClusterState randomlyUpdateClusterState(
 * this file be licensed under the Apache-2.0 license or a
            SegmentReplicationCheckpointPublisher.EMPTY,
            .get(randomFrom(stateWithIndex.routingTable().index(name).shardsWithState(INITIALIZING)).currentNodeId());  
            ShardRoutingState.STARTED,
        return state;  
        private Set<Index> deletedIndices = Collections.emptySet();
 *     http://www.apache.org/licenses/LICENSE-2.0
            // apply cluster state to nodes (incl. cluster-manager)  
        for (int i = 0; i < randomIntBetween(2, 5); i++) {
            equalTo(state.getRoutingNodes().node(node.getId()).getByShardId(shardId))
        ClusterState state = ClusterStateCreationUtils.state(
        // randomly reroute
        // simulate the cluster state change on the node
import org.opensearch.cluster.metadata.Metadata;  
        boolean containsClosedIndex = false;
        // randomly add and remove nodes (except current cluster-manager)  
import java.util.Arrays;  
            }  
                final ClusterChangedEvent event = new ClusterChangedEvent("simulated change " + i, localState, previousLocalState);
                localState,
        final ShardId shardId = shardRouting.shardId();
        for (Iterator<Entry<DiscoveryNode, IndicesClusterStateService>> it = clusterStateServiceMap.entrySet().iterator(); it.hasNext();) {
            logger.info("Iteration {}", i);
        indicesCSSvc.applyClusterState(new ClusterChangedEvent("new cluster state", localState, previousLocalState));  
            return state;  
        // pick a data node to simulate the adding an index cluster state change event on, that has shards assigned to it
     * structures while ensuring the data remains on disk.  This test executes this particular  
        // but the persistent data is still there
        }
        DiscoveryNode localNode = createNode(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE); // local node is the cluster-manager
 *
        ClusterState localState = adaptClusterStateToLocalNode(state, node);
        ClusterState state,
import org.opensearch.action.support.ActiveShardCount;  
            null,  
 */  
/*
            Collections.emptyMap(),
            shardStateAction,  
        String index = "index_" + randomAlphaOfLength(8).toLowerCase(Locale.ROOT);  
            if (state.metadata().indices().size() > 200) {
import org.opensearch.cluster.routing.allocation.FailedShard;
            settings,
import org.opensearch.core.index.shard.ShardId;
        Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));  
        Supplier<MockIndicesService> indicesServiceSupplier
                }  
    }
        Map<DiscoveryNode, IndicesClusterStateService> clusterStateServiceMap,  
            null,
            null,
    public void testRandomClusterStateUpdates() {
    public ClusterState randomInitialClusterState(  
        }
        );  
            .build();
        );
            null,  
                        .blocks(state.blocks())
            } else {
        // randomly add no_cluster_manager blocks
            if (reason == IndexRemovalReason.DELETED) {
        }
            transportService,  
            threadPool,
        IndicesClusterStateService indicesCSSvc = createIndicesClusterStateService(node, RecordingIndicesService::new);
                } catch (AssertionError error) {
                }  
                ClusterState localState = adaptClusterStateToLocalNode(state, node);  
        previousLocalState = adaptClusterStateToLocalNode(stateWithIndex, node);
        for (DiscoveryNode node : state.nodes()) {
import org.opensearch.cluster.routing.ShardRoutingState;  
        Supplier<MockIndicesService> indicesServiceSupplier
        indicesCSSvc.applyClusterState(new ClusterChangedEvent("cluster state change that adds the index", localState, previousLocalState));
import org.opensearch.cluster.action.shard.ShardStateAction;
        }  
        // a cluster state derived from the initial state that includes a created index
import java.util.List;
import org.opensearch.common.UUIDs;  
import java.util.Map;
        Set<String> indicesToUpdate = new HashSet<>();  
            ShardRoutingState.INITIALIZING
public class IndicesClusterStateServiceRandomUpdatesTests extends AbstractIndicesClusterStateServiceTestCase {
/*  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        indicesCSSvc.start();
            recoveryTargetService,
        ClusterState initialState = ClusterState.builder(stateWithIndex)
        final ShardId shardId = shardRouting.shardId();
/*  
            }
 * SPDX-License-Identifier: Apache-2.0
 *
        allNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));  
            MergedSegmentPublisher.EMPTY,
        }
                    throw error;  
            settings.put("index.refresh_interval", randomIntBetween(1, 5) + "s");  
            clusterService,  
        final Supplier<MockIndicesService> indicesServiceSupplier  
        Collections.addAll(roles, mustHaveRoles);
    private void updateNodes(
import java.util.Locale;  
 * software distributed under the License is distributed on an
            // calculate new cluster state
            state = cluster.updateSettings(state, updateSettingsRequest);
import java.util.Set;  
        logger.info("Final cluster state: {}", state);  
import java.util.Iterator;
 * You may obtain a copy of the License at  
        DiscoveryNode discoveryNode,
        RecordingIndicesService indicesService = (RecordingIndicesService) indicesCSSvc.indicesService;  
            DiscoveryNode node = it.next().getKey();  
        for (DiscoveryNode node : state.nodes()) {  
    }
            }
        super.setUp();
            state = ClusterState.builder(state).blocks(ClusterBlocks.builder().blocks(state.blocks()).addGlobalBlock(block)).build();
        String name = "index_" + randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
        // we have an IndicesClusterStateService per node in the cluster
        if (randomBoolean() && state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID)) {
    public void testInitializingPrimaryRemovesInitializingReplicaWithSameAID() {
        ClusterState previousState = ClusterState.builder(state)  
            .metadata(Metadata.builder(state.metadata()).remove(index))
        Set<String> indicesToDelete = new HashSet<>();
        previousState = state;
                } catch (AssertionError error) {
    /**
            state = ClusterState.builder(state)
            .build();  
            assertFalse(indicesService.isDeleted(index));
        for (String index : randomSubsetOf(numberOfIndicesToClose, state.metadata().indices().keySet().toArray(new String[0]))) {
            settings,
            )
        DiscoveryNode node = stateWithIndex.nodes()
            shardOrNull == null ? null : shardOrNull.routingEntry(),
            null,
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
import org.opensearch.cluster.routing.ShardRouting;
                break;  
        // randomly delete indices
        }  
     * This test ensures that when a node joins a brand new cluster (different cluster UUID),
     * In rare cases it is possible that a nodes gets an instruction to replace a replica  
 * ownership. Elasticsearch licenses this file to you under  
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
                it.remove();
        );  
        final ShardRouting shardRouting = state.routingTable().index(index).shard(0).replicaShards().get(0);  
        // randomly create new indices (until we have 200 max)  
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
        final Map<ShardRouting, Long> startedShards = new HashMap<>();
                }
            ClusterBlock block = randomBoolean()
     * are all removed but the on disk contents of those indices remain so that they can later be  
            threadPool,
        }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        super.tearDown();  
import java.util.HashSet;  
import org.opensearch.cluster.ClusterChangedEvent;
    public void tearDown() throws Exception {
                try {  
        return state;
     * structures to be removed (see {@link IndicesClusterStateService#applyClusterState(ClusterChangedEvent)}),  
    public void setUp() throws Exception {
import static org.hamcrest.Matchers.equalTo;  
            CreateIndexRequest request = new CreateIndexRequest(name, settingsBuilder.build()).waitForActiveShards(ActiveShardCount.NONE);
        int numberOfIndicesToClose = randomInt(Math.min(1, state.metadata().indices().size()));
            Index index = indexMetadata.getIndex();
            clusterStateServiceMap.computeIfAbsent(node, discoveryNode -> {
        Map<DiscoveryNode, IndicesClusterStateService> clusterStateServiceMap,
        public synchronized void removeIndex(Index index, IndexRemovalReason reason, String extraInfo) {
            state = cluster.openIndices(state, openIndexRequest);
 * not use this file except in compliance with the License.
                    if (persistedShardRouting.initializing() && randomBoolean()) {
    }
            mock(Transport.class),
        ShardRoutingState[] replicaStates = new ShardRoutingState[randomIntBetween(0, 3)];  
            if (state.metadata().index(index).getState() == IndexMetadata.State.CLOSE) {
        disableRandomFailures();
    }
    }
    ) {  
import org.opensearch.repositories.RepositoriesService;
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;
        IndicesClusterStateService indicesCSSvc = createIndicesClusterStateService(node, RecordingIndicesService::new);
        int numberOfIndicesToUpdate = randomInt(Math.min(2, state.metadata().indices().size()));
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        }
        final PeerRecoveryTargetService recoveryTargetService = new PeerRecoveryTargetService(
                    }
 * Licensed to Elasticsearch under one or more contributor  
                    );
 * the Apache License, Version 2.0 (the "License"); you may
                    state = cluster.addNodes(state, Collections.singletonList(createNode()));
        return ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(node.getId())).build();
            }
            mock(SegmentReplicationTargetService.class),  
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(state.metadata().index(index).getIndex().getName());  
        // the initial state which is derived from the newly created cluster state but doesn't contain the index
            threadPool,  
        // the initial state which is derived from the newly created cluster state but doesn't contain the index
        allNodes.add(localNode);  
        cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
import java.util.concurrent.ExecutorService;
import org.opensearch.cluster.service.ClusterService;
                        ),  
        final ThreadPool threadPool = mock(ThreadPool.class);
 * The OpenSearch Contributors require contributions made to  
