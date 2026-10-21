            for (MockIndexService indexService : indicesService) {
                try {
            } else {
                } catch (AssertionError error) {
     * are all removed but the on disk contents of those indices remain so that they can later be
                containsClosedIndex = true;
        public synchronized boolean isDeleted(Index index) {
                    state = cluster.addNodes(state, Collections.singletonList(createNode()));
 * this file be licensed under the Apache-2.0 license or a
            index,
            null,
            DiscoveryNode node = it.next().getKey();
                        // and add it back
            }
 * Modifications Copyright OpenSearch Contributors. See
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(state.metadata().index(index).getIndex().getName());
        }
    private static ClusterState adaptClusterStateToLocalNode(ClusterState state, DiscoveryNode node) {
            NoopTracer.INSTANCE
        // if no_cluster_manager block is in place, make no other cluster state changes
        if (state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID)) {
        ClusterState stateWithIndex = ClusterStateCreationUtils.state(name, randomBoolean(), ShardRoutingState.INITIALIZING, replicaStates);
        // randomly delete indices
        indicesCSSvc.start();
        for (DiscoveryNode node : state.nodes()) {
        ClusterState localState = adaptClusterStateToLocalNode(state, node);
            settings,
        return new IndicesClusterStateService(
import java.util.Locale;
    private ThreadPool threadPool;
        // randomly add and remove nodes (except current cluster-manager)
            .get(randomFrom(stateWithIndex.routingTable().index(name).shardsWithState(INITIALIZING)).currentNodeId());
        List<FailedShard> failedShards = new ArrayList<>();
        // start the replica
        );
                assertClusterStateMatchesNodeState(localState, indicesClusterStateService);
        localState = adaptClusterStateToLocalNode(newClusterState, node);
        state = cluster.openIndices(state, openIndexRequest);
        final Supplier<MockIndicesService> indicesServiceSupplier
            indicesToDelete.add(state.metadata().index(index).getIndex().getName());
                        error
        final String id = String.format(Locale.ROOT, "node_%03d", nodeIdGenerator.incrementAndGet());
        // randomly create new indices (until we have 200 max)
            indicesToUpdate.add(state.metadata().index(index).getIndex().getName());
import static org.mockito.Mockito.mock;
            indicesService,
                        .removeGlobalBlock(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID)
                }
        indicesCSSvc.start();
        indicesCSSvc.handleRecoveryFailure(shardRouting.reinitializeReplicaShard(), false, new Exception("dummy"));
        ClusterState previousLocalState = adaptClusterStateToLocalNode(previousState, node);
import java.util.function.Supplier;
                // remove node
     */
import org.opensearch.indices.replication.SegmentReplicationTargetService;
import org.opensearch.cluster.routing.ShardRouting;
                it.remove();
import org.opensearch.cluster.node.DiscoveryNode;
                    );
 * The OpenSearch Contributors require contributions made to
                ics.start();
        // randomly reroute
            MockIndicesService indicesService = (MockIndicesService) indicesClusterStateService.indicesService;
            state = cluster.createIndex(state, request);
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), Collections.emptyMap(), roles, Version.CURRENT);
        // pick a data node to simulate the adding an index cluster state change event on, that has shards assigned to it
                }
            if (randomBoolean()) {
    private IndicesClusterStateService createIndicesClusterStateService(
     * receives from the new cluster would contain a cluster block that would cause all in-memory
        previousLocalState = adaptClusterStateToLocalNode(previousState, node);
     * imported as dangling indices.  Normally, the first cluster state update that the node
        }
        int numberOfIndicesToDelete = randomInt(Math.min(2, state.metadata().indices().size()));
            assertFalse(indicesService.isDeleted(index));
import org.opensearch.cluster.block.ClusterBlocks;
            OpenIndexRequest openIndexRequest = new OpenIndexRequest(state.metadata().index(index).getIndex().getName());
        }
import org.opensearch.cluster.ClusterChangedEvent;
        ClusterState previousState = ClusterState.builder(state)
            shardStateAction,
            settings,
            CreateIndexRequest request = new CreateIndexRequest(name, settingsBuilder.build()).waitForActiveShards(ActiveShardCount.NONE);
    }
            ShardRoutingState.STARTED,
        Map<DiscoveryNode, IndicesClusterStateService> clusterStateServiceMap,
import org.opensearch.cluster.node.DiscoveryNodeRole;
            }
            }
        if (indicesToDelete.isEmpty() == false) {
    public ClusterState randomlyUpdateClusterState(
 */
                        updateNodes(state, clusterStateServiceMap, indicesServiceSupplier);
        // the initial state which is derived from the newly created cluster state but doesn't contain the index
            randomBoolean(),
        if (indicesToUpdate.isEmpty() == false) {
            SegmentReplicationCheckpointPublisher.EMPTY,
        }
            .metadata(Metadata.builder(state.metadata()).remove(index))
import java.util.Arrays;
            clusterStateServiceMap.computeIfAbsent(node, discoveryNode -> {
                "cluster state change with a new cluster UUID (and doesn't contain the index)",
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
    public void testInitializingPrimaryRemovesInitializingReplicaWithSameAID() {
        updateNodes(state, clusterStateServiceMap, indicesServiceSupplier);
        );
                settingsBuilder.put(SETTING_AUTO_EXPAND_REPLICAS, randomBoolean() ? min + "-" + max : min + "-all");
 * the Apache License, Version 2.0 (the "License"); you may
            logger.info("Iteration {}", i);
            // calculate new cluster state
public class IndicesClusterStateServiceRandomUpdatesTests extends AbstractIndicesClusterStateServiceTestCase {
            ShardRoutingState.INITIALIZING
import org.opensearch.cluster.node.DiscoveryNodes;
    private void updateNodes(
            threadPool,
            null,
            transportService,
import org.opensearch.cluster.block.ClusterBlock;
        final MockIndicesService indicesService = indicesServiceSupplier.get();
import java.util.List;
                localState,
import org.opensearch.action.admin.indices.open.OpenIndexRequest;
        allNodes.add(localNode);
            null,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.index.seqno.RetentionLeaseSyncer;
        if (rarely() && state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID) == false) {
                    ClusterBlocks.builder()
        assertNull(indicesCSSvc.indicesService.getShardOrNull(shardId));
            if (state.metadata().index(index).getState() == IndexMetadata.State.CLOSE) {
        ClusterState state = ClusterStateCreationUtils.state(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        final ShardId shardId = shardRouting.shardId();
                deletedIndices = Collections.unmodifiableSet(newSet);
    ) {
                        ),
        when(threadPool.generic()).thenReturn(mock(ExecutorService.class));
 *
            if (reason == IndexRemovalReason.DELETED) {
                int max = min + randomInt(3);
     * but in the case where the node joined and was a few cluster state updates behind, it would
        final RepositoriesService repositoriesService = new RepositoriesService(
        }
            if (state.nodes().nodeExists(node) == false) {
        super.setUp();
        // the initial state which is derived from the newly created cluster state but doesn't contain the index
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
            }
                            event.state()
            state = cluster.reroute(state, new ClusterRerouteRequest());
        );
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import static org.mockito.Mockito.when;
                break;
        ShardRoutingState[] replicaStates = new ShardRoutingState[randomIntBetween(0, 3)];
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
        for (IndexMetadata indexMetadata : stateWithIndex.metadata()) {
            null,
        localState = adaptClusterStateToLocalNode(state, node);
import org.opensearch.cluster.service.ClusterService;
            null,
     * This test ensures that when a node joins a brand new cluster (different cluster UUID),
        );
        disableRandomFailures();
            ShardRoutingState.STARTED,
    /**
        // randomly add no_cluster_manager blocks
    public ClusterState randomInitialClusterState(
        assertNotNull(indicesCSSvc.indicesService.getShardOrNull(shardId));
    public void testJoiningNewClusterOnlyRemovesInMemoryIndexStructures() {
     * structures to be removed (see {@link IndicesClusterStateService#applyClusterState(ClusterChangedEvent)}),
import org.opensearch.index.shard.PrimaryReplicaSyncer;
                IndicesClusterStateService ics = createIndicesClusterStateService(discoveryNode, indicesServiceSupplier);
            s -> {},
        cluster = new ClusterStateChanges(xContentRegistry(), threadPool);
     * structures while ensuring the data remains on disk.  This test executes this particular
                if (state.nodes().getDataNodes().size() > 3) {
            .metadata(Metadata.builder(stateWithIndex.metadata()).remove(name))
            if (state.metadata().indices().size() > 200) {
                    throw error;
        previousLocalState = adaptClusterStateToLocalNode(stateWithIndex, node);
                    ShardRouting persistedShardRouting = indexShard.routingEntry();
    public void testRecoveryFailures() {
        // at least two nodes that have the data role so that we can allocate shards
    }
        final MockIndexShard shardOrNull = ((RecordingIndicesService) indicesCSSvc.indicesService).getShardOrNull(shardId);
                } catch (AssertionError error) {
            mock(SegmentReplicationSourceService.class),
        allNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
        }
        ClusterState previousLocalState = adaptClusterStateToLocalNode(initialState, node);
            RetentionLeaseSyncer.EMPTY,
        IndicesClusterStateService indicesCSSvc = createIndicesClusterStateService(node, RecordingIndicesService::new);
                    DiscoveryNode discoveryNode = randomFrom(state.nodes().getNodes().values().toArray(new DiscoveryNode[0]));
        boolean containsClosedIndex = false;
 * GitHub history for details.
 */
            randomBoolean(),
    ) {
        int numberOfIndicesToUpdate = randomInt(Math.min(2, state.metadata().indices().size()));
            for (String index : indicesToDelete) {
import org.opensearch.indices.recovery.PeerRecoveryTargetService;
            primaryReplicaSyncer,
    public void testRandomClusterStateUpdates() {
                assertFalse(state.metadata().hasIndex(index));
            }
                            "failed to apply change on [{}].\n ***  Previous state ***\n{}\n ***  New state ***\n{}",
            state = ClusterState.builder(state)
        ClusterState previousState = ClusterState.builder(state)
        // check that in memory data structures have been removed once the new cluster state is applied,
                newSet.add(index);
            Collections.emptyMap(),
        for (String index : randomSubsetOf(numberOfIndicesToUpdate, state.metadata().indices().keySet().toArray(new String[0]))) {
     * not have received the cluster block, in which case we still need to remove the in-memory
        ClusterState state = randomInitialClusterState(clusterStateServiceMap, MockIndicesService::new);
    private class RecordingIndicesService extends MockIndicesService {
            Index index = indexMetadata.getIndex();
        // create a new empty cluster state with a brand new cluster UUID
        state = cluster.applyStartedShards(state, startedShards);
        }
        final PrimaryReplicaSyncer primaryReplicaSyncer = mock(PrimaryReplicaSyncer.class);
        }
        @Override
        for (String index : randomSubsetOf(numberOfIndicesToClose, state.metadata().indices().keySet().toArray(new String[0]))) {
            Settings.Builder settings = Settings.builder();
            }
                    throw error;
        RecordingIndicesService indicesService = (RecordingIndicesService) indicesCSSvc.indicesService;
                }
import org.opensearch.cluster.ClusterState;
 * ownership. Elasticsearch licenses this file to you under
                        updateNodes(state, clusterStateServiceMap, indicesServiceSupplier);
 * compatible open source license.
            state = cluster.updateSettings(state, updateSettingsRequest);
            equalTo(state.getRoutingNodes().node(node.getId()).getByShardId(shardId))
        // check that failing unrelated allocation does not remove shard
    public void setUp() throws Exception {
        final ShardRouting shardRouting = state.routingTable().index(index).shard(0).replicaShards().get(0);
        disableRandomFailures();
        previousState = state;
            }
    @Override
import java.util.HashMap;
        final ShardStateAction shardStateAction = mock(ShardStateAction.class);
import static org.hamcrest.Matchers.equalTo;
        Supplier<MockIndicesService> indicesServiceSupplier
                    indicesClusterStateService.applyClusterState(event);
    @Override
        if (rarely()) {
            null,
        Arrays.fill(replicaStates, ShardRoutingState.INITIALIZING);
        final ShardId shardId = shardRouting.shardId();
        IndicesClusterStateService indicesCSSvc = createIndicesClusterStateService(node, RecordingIndicesService::new);
    }
            super.removeIndex(index, reason, extraInfo);
    private ClusterStateChanges cluster;
import org.opensearch.cluster.metadata.IndexMetadata;
            return state;
            mock(SegmentReplicationTargetService.class),
            return deletedIndices.contains(index);
            if (randomBoolean()) {
        int numberOfIndicesToClose = randomInt(Math.min(1, state.metadata().indices().size()));
import java.util.concurrent.atomic.AtomicInteger;
            state = cluster.deleteIndices(state, deleteRequest);
 * You may obtain a copy of the License at
                            node,
        Set<String> indicesToDelete = new HashSet<>();
        }
                if (state.nodes().getSize() < 10) {
                previousLocalState
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(state.metadata().index(index).getIndex().getName());
            ReferencedSegmentsPublisher.EMPTY
            recoveryTargetService,
import org.opensearch.transport.Transport;
            state = cluster.openIndices(state, openIndexRequest);
            }
            ShardRoutingState.INITIALIZING
            null,
            Settings.Builder settingsBuilder = Settings.builder().put(SETTING_NUMBER_OF_SHARDS, randomIntBetween(1, 3));
        // simulate the cluster state change on the node
        return state;
                    if (persistedShardRouting.initializing() && randomBoolean()) {
        }
        ClusterState state,
 * under the License.
        Supplier<MockIndicesService> indicesServiceSupplier
        assertNotNull(indicesCSSvc.indicesService.getShardOrNull(shardId));
import java.util.ArrayList;
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.common.UUIDs;
        indicesCSSvc.applyClusterState(new ClusterChangedEvent("new cluster state", localState, previousLocalState));
        // simulate the cluster state change on the node
        // randomly start and fail allocated shards
    }
            clusterService
                ClusterState localState = adaptClusterStateToLocalNode(state, node);
 * specific language governing permissions and limitations
                    state = randomlyUpdateClusterState(state, clusterStateServiceMap, MockIndicesService::new);
    }
        for (int i = 0; i < randomIntBetween(2, 5); i++) {
        Collections.addAll(roles, mustHaveRoles);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                }
        indicesCSSvc.applyClusterState(new ClusterChangedEvent("cluster state change that adds the index", localState, previousLocalState));
                final ClusterChangedEvent event = new ClusterChangedEvent("simulated change " + i, localState, previousLocalState);
    }
                : NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES;
        state = cluster.closeIndices(state, closeIndexRequest);
        // but the persistent data is still there
            String name = "index_" + randomAlphaOfLength(15).toLowerCase(Locale.ROOT);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
        ClusterState newClusterState = ClusterState.builder(initialState)
        }
            allNodes.add(createNode());
                settingsBuilder.put(SETTING_NUMBER_OF_REPLICAS, randomInt(2));
            }
            state = ClusterState.builder(state).blocks(ClusterBlocks.builder().blocks(state.blocks()).addGlobalBlock(block)).build();
        // simulate the cluster state change on the node
     */
        final PeerRecoveryTargetService recoveryTargetService = new PeerRecoveryTargetService(
            .metadata(Metadata.builder(initialState.metadata()).clusterUUID(UUIDs.randomBase64UUID()))
            }
                int min = randomInt(2);
        final TransportService transportService = new TransportService(
        ClusterState state = ClusterStateCreationUtils.state(
                        startedShards.put(persistedShardRouting, indexShard.term());
        List<DiscoveryNode> allNodes = new ArrayList<>();
                    logger.error(
            null,
import org.opensearch.common.settings.Settings;
        terminate(threadPool);
            Collections.emptyMap(),
import java.util.Iterator;
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            assertTrue(state.metadata().hasIndex(name));
                try {
                .blocks(
        for (int i = 0; i < 30; i++) {
    /**
        final Map<DiscoveryNode, IndicesClusterStateService> clusterStateServiceMap = new HashMap<>();
            .routingTable(RoutingTable.builder().build())
            .routingTable(RoutingTable.builder().build())
            // apply cluster state to nodes (incl. cluster-manager)
        return ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(node.getId())).build();
                ? NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
            boundAddress -> DiscoveryNode.createLocal(settings, boundAddress.publishAddress(), UUIDs.randomBase64UUID()),
/*
import java.util.Map.Entry;
import java.util.Set;
        }
            MergedSegmentPublisher.EMPTY,
        indicesCSSvc.start();
            index,
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
        }
import org.opensearch.core.index.Index;
        indicesCSSvc.applyClusterState(new ClusterChangedEvent("cluster state change that adds the index", localState, previousLocalState));
            for (int j = 0; j < randomInt(3); j++) { // multiple iterations to simulate batching of cluster states
        Map<DiscoveryNode, IndicesClusterStateService> clusterStateServiceMap,
 * Unless required by applicable law or agreed to in writing,
    ) {
    }
            ClusterBlock block = randomBoolean()
            transportService,
        }
        threadPool = new TestThreadPool(getClass().getName());
        );
 * license agreements. See the NOTICE file distributed with
        DiscoveryNode localNode = createNode(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE); // local node is the cluster-manager
        // we have an IndicesClusterStateService per node in the cluster
        // the initial state which is derived from the newly created cluster state but doesn't contain the index
        DiscoveryNode discoveryNode,
            final ClusterState previousState = state;
        );
        for (String index : randomSubsetOf(numberOfIndicesToOpen, state.metadata().indices().keySet().toArray(new String[0]))) {
    }
        DiscoveryNode node = state.nodes().get(shardRouting.currentNodeId());
                // check that cluster state has been properly applied to node
                .build();
        // pick a data node to simulate the adding an index cluster state change event on, that has shards assigned to it
        indicesCSSvc.applyClusterState(new ClusterChangedEvent("cluster state change that adds the index", localState, previousLocalState));
                Set<Index> newSet = Sets.newHashSet(deletedIndices);
        if (randomBoolean() && state.blocks().hasGlobalBlockWithId(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ID)) {
    protected DiscoveryNode createNode(DiscoveryNodeRole... mustHaveRoles) {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            new ClusterChangedEvent(
    private static final AtomicInteger nodeIdGenerator = new AtomicInteger();
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
                    if (randomBoolean()) {
                )
        for (Iterator<Entry<DiscoveryNode, IndicesClusterStateService>> it = clusterStateServiceMap.entrySet().iterator(); it.hasNext();) {
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
                    logger.error(() -> new ParameterizedMessage("failed to random change state. last good state: \n{}", finalState), error);
import org.opensearch.action.support.ActiveShardCount;
 * not use this file except in compliance with the License.
        );
            CloseIndexRequest closeIndexRequest = new CloseIndexRequest(state.metadata().index(index).getIndex().getName());
            DeleteIndexRequest deleteRequest = new DeleteIndexRequest(indicesToDelete.toArray(new String[0]));
                        state = cluster.removeNodes(state, Collections.singletonList(discoveryNode));
package org.opensearch.indices.cluster;
import org.opensearch.cluster.routing.allocation.FailedShard;
        // randomly close indices
        return state;
        ClusterState localState = adaptClusterStateToLocalNode(stateWithIndex, node);
        logger.info("Final cluster state: {}", state);
        // close the index and open it up again (this will sometimes swap roles between primary and replica)
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
        // randomly update settings
     * initializing primary.
                        state = cluster.addNodes(state, Collections.singletonList(discoveryNode));
                IndicesClusterStateService indicesClusterStateService = clusterStateServiceMap.get(node);
        int numberOfIndicesToOpen = randomInt(Math.min(1, state.metadata().indices().size()));
            });
        state = cluster.applyFailedShards(state, failedShards);
            .build();
        // add nodes to clusterStateServiceMap
                for (MockIndexShard indexShard : indexService) {
                    }
                    ClusterState finalState = state;
        // TODO: go cluster-managerless?
        DiscoveryNode node = state.nodes().get(shardRouting.currentNodeId());
        Set<String> indicesToUpdate = new HashSet<>();
            .routingTable(RoutingTable.builder().build())
     * In rare cases it is possible that a nodes gets an instruction to replace a replica
        indicesCSSvc.applyClusterState(
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
     * different from the cluster it was previously a part of, the in-memory index data structures
        assertThat(
 *
            if (containsClosedIndex == false) {
                return ics;
                    if (discoveryNode.equals(state.nodes().getClusterManagerNode()) == false) {
        );
            mock(Transport.class),
import org.opensearch.cluster.routing.RoutingTable;
            threadPool,
        for (int i = 0; i < randomInt(5); i++) {
        }
            for (DiscoveryNode node : state.nodes()) {
            updateSettingsRequest.settings(settings.build());
        // simulate the cluster state change on the node
        ClusterState previousLocalState = adaptClusterStateToLocalNode(previousState, node);
import java.util.HashSet;
            } else {
        // randomly open indices
    }
        String name = "index_" + randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
            threadPool,
            state = cluster.closeIndices(state, closeIndexRequest);
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.Version;
        super.tearDown();
            settings,
            repositoriesService,
        final ShardRouting shardRouting = state.routingTable().index(index).shard(0).replicaShards().get(0);
        for (String index : randomSubsetOf(numberOfIndicesToDelete, state.metadata().indices().keySet().toArray(new String[0]))) {
        allNodes.add(createNode(DiscoveryNodeRole.DATA_ROLE));
                        .blocks(state.blocks())
        private Set<Index> deletedIndices = Collections.emptySet();
            Collections.emptySet(),
            settings.put("index.refresh_interval", randomIntBetween(1, 5) + "s");
        Supplier<MockIndicesService> indicesServiceSupplier
        Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
                // add node
        // TODO: check if we can go to green by starting all shards and finishing all iterations
     * scenario.
            .build();
        // pick a data node to simulate the adding an index cluster state change event on, that has shards assigned to it
                    }
     * closing of the indices, opening it up again and allocating the primary shard to the node in
 *
        // each of the following iterations represents a new cluster state update processed on all nodes
            }
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteRequest;
                            event.previousState(),
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
        Map<DiscoveryNode, IndicesClusterStateService> clusterStateServiceMap,
        for (DiscoveryNode node : state.nodes()) {
import org.opensearch.cluster.metadata.Metadata;
        }
        }
        // randomly remove no_cluster_manager blocks
        }
        final Map<ShardRouting, Long> startedShards = new HashMap<>();
        String index = "index_" + randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
        public synchronized void removeIndex(Index index, IndexRemovalReason reason, String extraInfo) {
import java.util.Map;
        String index = "index_" + randomAlphaOfLength(8).toLowerCase(Locale.ROOT);
        DiscoveryNode node = stateWithIndex.nodes()
            shardOrNull == null ? null : shardOrNull.routingEntry(),
        final Settings settings = Settings.builder().put("node.name", discoveryNode.getName()).build();
import org.opensearch.indices.replication.SegmentReplicationSourceService;
import org.opensearch.common.util.set.Sets;
        }
        final ClusterService clusterService = mock(ClusterService.class);
                    } else if (rarely()) {
            .build();
        state = cluster.applyStartedShards(state, state.routingTable().index(index).shard(0).replicaShards());
     * shard that's in POST_RECOVERY with a new initializing primary with the same allocation id.
import org.apache.logging.log4j.message.ParameterizedMessage;
                settings.put(SETTING_NUMBER_OF_REPLICAS, randomInt(2));
     * question. The node should then clean it's initializing replica and replace it with a new
        ClusterState initialState = ClusterState.builder(stateWithIndex)
        ClusterState state,
                    updateNodes(state, clusterStateServiceMap, indicesServiceSupplier);
                }
        // a cluster state derived from the initial state that includes a created index
        if (rarely()) {
 * SPDX-License-Identifier: Apache-2.0
        ClusterState localState = adaptClusterStateToLocalNode(state, node);
 * Licensed to Elasticsearch under one or more contributor
            .metadata(Metadata.builder(state.metadata()).remove(index))
                        failedShards.add(new FailedShard(persistedShardRouting, "fake shard failure", new Exception(), randomBoolean()));
            UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(indicesToUpdate.toArray(new String[0]));
    }
            assertNull(indicesService.indexService(index));
                        new ParameterizedMessage(
                    }
        }
                ClusterState previousLocalState = adaptClusterStateToLocalNode(previousState, node);
            clusterService,
        indicesCSSvc.handleRecoveryFailure(shardRouting, false, new Exception("dummy"));
    ) {
        IndicesClusterStateService indicesCSSvc = createIndicesClusterStateService(node, RecordingIndicesService::new);
            IndicesClusterStateService indicesClusterStateService = clusterStateServiceMap.get(node);
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
/*
        ClusterState state = ClusterStateCreationUtils.state(localNode, localNode, allNodes.toArray(new DiscoveryNode[0]));
    }
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.transport.TransportService;
import java.util.concurrent.ExecutorService;
import org.opensearch.threadpool.TestThreadPool;
        final ThreadPool threadPool = mock(ThreadPool.class);
            .build();
}
/*
            )
    public void tearDown() throws Exception {
            threadPool
    }
     * This can happen by batching cluster states that include the starting of the replica, with
 * this work for additional information regarding copyright
            clusterService,
