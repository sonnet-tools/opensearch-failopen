    private List<ClusterState> simulateClusterRecoveryStates(
        }
    }
                .nodes(DiscoveryNodes.builder(clusterService.state().nodes()).clusterManagerNodeId(null))
        for (int i = 0; i < clusterStates.size(); i++) {
        }
    @After
import java.util.concurrent.TimeUnit;
                Collection<ClusterIndexHealth> clusterIndexHealths = clusterStateHealth.getIndices().values();
        for (int i = 0; i < clusterStates.size(); i++) {
            .numberOfShards(numberOfShards)
    }
                } else {
import org.opensearch.cluster.routing.RoutingTable;
    public void testClusterHealthOnIndexCreationWithFailedAllocations() {
                "restore cluster-manager",
        for (final var shardRouting : clusterState.routingTable().index(indexName).shards().entrySet()) {
        clusterStates.add(clusterState);
        return generateClusterStates(clusterState, indexName, numberOfReplicas, withPrimaryAllocationFailures);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            metadata.put(indexMetadata, true);
            x -> clusterService.localNode(),
 *
        final List<ClusterState> clusterStates = simulateClusterRecoveryStates(indexName, false, true);
 */
/*
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        ClusterState clusterState = originalClusterState;
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
                logger.debug("interrupted", e);
        for (int i = 0; i < clusterStates.size(); i++) {
                } else {
            if (primaryShard.active() == false) {
                (source, e) -> {}
        // initialize replicas
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
import java.util.HashMap;
import org.opensearch.cluster.routing.UnassignedInfo;
        Map<Integer, Set<String>> allocationIds = new HashMap<>();
        threadPool = null;
        TransportClusterHealthAction action = new TransportClusterHealthAction(
        final String[] indices = new String[] { indexName };
            } catch (InterruptedException e) {
            clusterState,
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        RoutingTable routingTable = originalClusterState.routingTable();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // some replicas started
            Collections.emptySet(),
        clusterService = createClusterService(threadPool);
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
import org.opensearch.action.support.IndicesOptions;
                }
                    } else {
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
        // initial index creation and new routing table info
            }
                }
                    atLeastOne = true;
import java.util.HashSet;
        final String indexName,
 * SPDX-License-Identifier: Apache-2.0
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
    }
        final CountDownLatch applyLatch = new CountDownLatch(1);
        return clusterStateHealth;
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
        }
                if (primaryInactiveDueToRecovery(indexName, clusterState)) {
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
                    newIndexRoutingTable.addShard(shardRouting.initialize(replicaNodeId, null, shardRouting.getExpectedShardSize()));
        indexRoutingTable = routingTable.index(indexName);
        super.setUp();
            // then cluster health is YELLOW, otherwise RED
 * The OpenSearch Contributors require contributions made to
    public void tearDown() throws Exception {
public class ClusterStateHealthTests extends OpenSearchTestCase {
                    allocationIds.put(newShardRouting.getId(), Set.of(newShardRouting.allocationId().getId()));
    // (not because of allocation of existing shard or previously having allocation ids assigned)
        final IndexMetadata.Builder idxMetaBuilder = IndexMetadata.builder(clusterState.metadata().index(indexName));
import org.opensearch.test.gateway.TestGatewayAllocator;
        metadataBuilder = Metadata.builder(clusterState.metadata()).put(idxMetaBuilder2);
            (String[]) null
            assertTrue(clusterStateHealth.getIndices().isEmpty());
        assertThat(clusterStateHealth.getActiveShards(), equalTo(counter.active));
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadataBuilder).build();
    public void testClusterHealthOnClusterRecoveryWithFailures() {
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + Integer.toString(i))
    }
        assertThat(clusterStateHealth.getInitializingShards(), equalTo(counter.initializing));
        );
            // make sure cluster health is always YELLOW, up until the last state where it should be GREEN
import org.opensearch.cluster.routing.ShardRouting;
        return true;
import org.opensearch.common.settings.Settings;
        final String[] indices = new String[] { indexName };
        if (randomBoolean()) {
            boolean atLeastOne = false;
    private List<ClusterState> simulateIndexCreationStates(final String indexName, final boolean withPrimaryAllocationFailures) {
        threadPool = new TestThreadPool("ClusterStateHealthTests");
    public static void terminateThreadPool() {
import static org.opensearch.action.admin.cluster.health.ClusterHealthRequest.Level.SHARDS;
    private final IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
            routingTable.add(indexRoutingTable);
            .state(IndexMetadata.State.OPEN)
        assertThat(clusterStateHealth.getUnassignedShards(), equalTo(counter.unassigned));
        }
        indexRoutingTable = routingTable.index(indexName);
 * not use this file except in compliance with the License.
            // make sure cluster health is YELLOW up until the final cluster state, which contains primary shard
            }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        if (replicaStateChanged) {
        final CountDownLatch listenerCalled = new CountDownLatch(1);
        }
import org.opensearch.Version;
            clusterService,
                final IndexShardRoutingTable shardRoutingTable = shardEntry;
        assertThat(clusterStateHealth.getRelocatingShards(), equalTo(counter.relocating));
            allocatedNodes.add(primaryNodeId);
            .routingTable(routingTable)
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.RED));
                }
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
    ClusterStateHealth maybeSerialize(ClusterStateHealth clusterStateHealth) throws IOException {
import org.opensearch.cluster.routing.RecoverySource;
}
import org.opensearch.transport.TransportService;
        for (final ClusterState clusterState : simulateClusterRecoveryStates(indexName, true, true)) {
        clusterStates.add(clusterState);
        final String[] indices = new String[] { indexName };
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        clusterStates.add(clusterState);
 * KIND, either express or implied.  See the License for the
                } else {
            final ClusterState clusterState = clusterStates.get(i);
            .routingTable(routingTable)
                        alreadyFailedPrimary = true;
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
import org.junit.BeforeClass;
        clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices, SHARDS);
                    newIndexRoutingTable.addShard(shardRouting.moveToStarted());
        // initial index creation and new routing table info
        final int numNodes = randomIntBetween(numberOfReplicas + 1, 10);
                    String replicaNodeId = randomFrom(Sets.difference(nodeIds, allocatedNodes));
                applyLatch.await();
        }
            null,
            ClusterState.builder(clusterService.state())
        assertThat(clusterStateHealth.getActivePrimaryShards(), equalTo(counter.primaryActive));
    }
                        newIndexRoutingTable.addShard(
            .nodes(clusterService.state().nodes())
                    idxMetaWithAllocationIds.putInSyncAllocationIds(i, Sets.newHashSet(UUIDs.randomBase64UUID()));
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
            if (i < clusterStates.size() - 1) {
                    newIndexRoutingTable.addShard(shardRouting);
            final ClusterState clusterState = clusterStates.get(i);
import org.opensearch.cluster.routing.RoutingTableGenerator;
    }
            .numberOfReplicas(numberOfReplicas)
                .build();
        );
                }
            }
/*
                    newIndexRoutingTable.addShard(shardRouting);
        final Set<String> nodeIds = new HashSet<>();
            .onNewClusterState(
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
 * Unless required by applicable law or agreed to in writing,
        ClusterState clusterState = ClusterState.builder(new ClusterName("test_cluster"))
    }
            );
import static org.hamcrest.Matchers.is;
            newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("test_cluster"))
            BytesStreamOutput out = new BytesStreamOutput();
        assertClusterHealth(clusterStateHealth, counter, CLUSTER);
                } else {
            final IndexMetadata.Builder idxMetaWithAllocationIds = IndexMetadata.builder(indexMetadata);
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
            } else {
        transportService.start();
        }
        // all of the replicas may have moved to started in the previous phase already
            final ClusterState clusterState = clusterStates.get(i);
        final List<ClusterState> clusterStates = simulateIndexCreationStates(indexName, true);
 */
import static org.opensearch.test.ClusterServiceUtils.setState;
    // returns true if the inactive primaries in the index are only due to cluster recovery
            indexMetadata = idxMetaWithAllocationIds.build();
 * You may obtain a copy of the License at
    private ClusterService clusterService;
                } else {
                    allocationIds.put(newShardRouting.getId(), Set.of(newShardRouting.allocationId().getId()));
            if (i < clusterStates.size() - 1) {
            // failed allocations that should make the cluster health RED
        final String indexName = "test-idx";
import org.opensearch.action.admin.cluster.health.TransportClusterHealthAction;
    }
                    assertFalse(clusterIndexHealth.getShards().isEmpty());
import static org.hamcrest.CoreMatchers.equalTo;
        assertClusterHealth(clusterStateHealth, counter, SHARDS);
        // some primaries started
        logger.info("--> realising task to restore cluster-manager");
import org.opensearch.cluster.metadata.IndexMetadata;
package org.opensearch.cluster.health;
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.RED));
        clusterStates.add(ClusterState.builder(clusterState).routingTable(routingTable).build());
            // then move to YELLOW, and the last state should be GREEN when all shards have been started
        if (level.equals(INDICES) || level.equals(SHARDS)) {
    @Before
        listener.get();
    public void testClusterHealthWaitsForClusterStateApplication() throws InterruptedException, ExecutionException {
                }
        final String[] indices = new String[] { indexName };
        assertThat(
                }
        ClusterStateHealth clusterStateHealth,
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
    ) {
            } else {
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices, INDICES);
            .build();
import java.util.Set;
        final boolean withPreviousAllocationIds,
        }
            threadPool,
                    newIndexRoutingTable.addShard(shardRouting);
            }
import org.opensearch.threadpool.TestThreadPool;
        allocationIds.forEach(idxMetaBuilder::putInSyncAllocationIds);
        clusterService.getClusterApplierService()
        indexRoutingTable = routingTable.index(indexName);
import java.util.ArrayList;
            }
        }
    public void testClusterHealthOnClusterRecoveryWithPreviousAllocationIds() {
                    }
    private List<ClusterState> generateClusterStates(
        listenerCalled.await();
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
        clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices, ClusterHealthRequest.Level.CLUSTER);
            null
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
 * this work for additional information regarding copyright
                    assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
                }
        );
            .build();
        final String indexName = "test-idx";
import org.opensearch.cluster.ClusterName;
            }
            if (primaryInactiveDueToRecovery(indexName, clusterState)) {
        RoutingTableGenerator.ShardCounter counter,
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);
                    allocatedNodes.add(replicaNodeId);
import org.opensearch.common.util.concurrent.ThreadContext;
    @Override
                    final ShardRouting newShardRouting = shardRouting.moveToStarted();
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadataBuilder).build();
    private boolean primaryInactiveDueToRecovery(final String indexName, final ClusterState clusterState) {
                }
            for (final var shardEntry : indexRoutingTable.getShards().values()) {
    private void assertClusterHealth(
    }
        }
            if (i < clusterStates.size() - 1) {
 * ownership. Elasticsearch licenses this file to you under
        final String indexName,
        final RoutingTable routingTable = RoutingTable.builder().addAsRecovery(indexMetadata).build();
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            for (int i = 0; i < numberOfShards; i++) {
            }
            int numberOfReplicas = randomInt(4);
import org.opensearch.cluster.routing.IndexRoutingTable;
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
                        newIndexRoutingTable.addShard(shardRouting);
            equalTo(clusterService.state().nodes().getClusterManagerNodeId() != null)
            NoopTracer.INSTANCE
import org.junit.AfterClass;
                .build()
        new ThreadContext(Settings.EMPTY)
        final String indexName = "test-idx";
            } else {
            clusterStates.add(ClusterState.builder(clusterState).routingTable(routingTable).build());
        final int numberOfReplicas = randomIntBetween(1, numberOfShards);
    }
        final int numberOfReplicas,
        transportService.close();
            nodeIds.add(randomAlphaOfLength(8));
                .numberOfShards(numberOfShards)
            StreamInput in = out.bytes().streamInput();
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
import java.io.IOException;
            .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID()))
            }
                }
        // generate random node ids
                } else {
        } else {
import static org.opensearch.action.admin.cluster.health.ClusterHealthRequest.Level.INDICES;
            routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
            final String primaryNodeId = shardRoutingTable.primaryShard().currentNodeId();
            .routingTable(routingTable.build())
 */
        ClusterStateHealth clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices);
        assertClusterHealth(clusterStateHealth, counter, SHARDS);
                    && primaryShard.recoverySource().getType() == RecoverySource.Type.EXISTING_STORE) {
            new ActionFilters(new HashSet<>()),
import org.opensearch.cluster.routing.allocation.AllocationService;
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
 * specific language governing permissions and limitations
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
            } else {
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
    ) {
                }
        }
        clusterService.addStateApplier(event -> {
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
                    newIndexRoutingTable.addShard(shardRouting.initialize(randomFrom(nodeIds), null, shardRouting.getExpectedShardSize()));
                if (shardRouting.primary() && randomBoolean()) {
    @AfterClass
        final int numberOfShards = randomIntBetween(1, 5);
        final boolean withPrimaryAllocationFailures
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.junit.Before;
        }
                }
        final String indexName = "test-idx";
            final ClusterState clusterState = clusterStates.get(i);
            // some primaries failed to allocate
import org.opensearch.common.io.stream.BytesStreamOutput;
    public void testClusterHealth() throws IOException {
            .metadata(metadata)
        assertThat(clusterStateHealth.getActiveShardsPercent(), is(allOf(greaterThanOrEqualTo(0.0), lessThanOrEqualTo(100.0))));
                // if the inactive primaries are due solely to recovery (not failed allocation or previously being allocated),
        transportService = transport.createTransportService(
        for (int i = 0; i < clusterStates.size(); i++) {
            .build();
                    assertThat(health.getStatus(), equalTo(ClusterHealthStatus.RED));
            .numberOfShards(numberOfShards)
import static org.opensearch.action.admin.cluster.health.ClusterHealthRequest.Level.CLUSTER;
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
        logger.info("--> waiting for listener to be called and cluster state being blocked");
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    .build(),
        final List<ClusterState> clusterStates = simulateClusterRecoveryStates(indexName, false, false);
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("--> submit task to restore cluster-manager");
        applyLatch.countDown();
            } else {
        indexRoutingTable = routingTable.index(indexName);
                    newIndexRoutingTable.addShard(newShardRouting);
        assertFalse(listener.isDone());
        boolean replicaStateChanged = false;
import org.opensearch.cluster.node.DiscoveryNodes;
            clusterStateHealth.hasDiscoveredClusterManager(),
        RoutingTable.Builder routingTable = RoutingTable.builder();
import org.opensearch.test.transport.CapturingTransport;
 * Modifications Copyright OpenSearch Contributors. See
                if (atLeastOne == false || randomBoolean()) {
        clusterService.close();
 *
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
    public void testClusterHealthOnClusterRecoveryWithPreviousAllocationIdsAndAllocationFailures() {
        ClusterState currentState = clusterService.getClusterApplierService().state();
    ) {
import org.opensearch.common.util.set.Sets;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                }
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
            Set<String> allocatedNodes = new HashSet<>();
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.List;
        PlainActionFuture<ClusterHealthResponse> listener = new PlainActionFuture<>();
 * GitHub history for details.
        clusterStates.add(ClusterState.builder(clusterState).routingTable(routingTable).build());
        ClusterHealthRequest.Level level
        final String indexName = "test-idx";
                if (shardRouting.primary() == false && shardRouting.started() == false) {
                if (primaryShard.recoverySource() != null
    }
                    return false;
import java.util.Collection;
            if (i < clusterStates.size() - 1) {
        assertThat(clusterStateHealth.getStatus(), equalTo(counter.status()));
                if (primaryShard.unassignedInfo().getNumFailedAllocations() > 0) {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
/*
            try {
            // because there were previous allocation ids, we should be RED until the primaries are started,
            listenerCalled.countDown();
        // initialize primaries
        final List<ClusterState> clusterStates = simulateIndexCreationStates(indexName, false);
import org.opensearch.action.support.PlainActionFuture;
        Metadata.Builder metadata = Metadata.builder();
                if (shardRouting.primary()) {
                // then cluster health is YELLOW, otherwise RED
        logger.info("cluster status: {}, expected {}", clusterStateHealth.getStatus(), counter.status());
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata()).put(idxMetaBuilder);
                    return false;
                if (shardRouting.primary() && shardRouting.started() == false) {
            clusterStateHealth.writeTo(out);
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
        for (int i = randomInt(4); i >= 0; i--) {
            if (level.equals(SHARDS)) {
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
            routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
        for (int i = 0; i < clusterStates.size(); i++) {
import org.junit.After;
            IndicesOptions.strictExpand(),
            }
                    return false;
            // failed allocations that should make the cluster health RED
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
import static org.hamcrest.CoreMatchers.allOf;
    );
        transportService.acceptIncomingRequests();
        action.execute(new ClusterHealthRequest().waitForGreenStatus(), listener);
            }
                    newIndexRoutingTable.addShard(shardRouting);
        setState(
    }
            }
        if (withPreviousAllocationIds) {
import org.opensearch.test.OpenSearchTestCase;
    public void testClusterHealthOnClusterRecovery() {
        final String indexName = "test-idx";
                    .nodes(DiscoveryNodes.builder(currentState.nodes()).clusterManagerNodeId(currentState.nodes().getLocalNodeId()))
                    newIndexRoutingTable.addShard(newShardRouting);
        for (int i = 0; i < numNodes; i++) {
            indexRoutingTable = routingTable.index(indexName);
        }
                    return false;
            new AllocationService(null, new TestGatewayAllocator(), null, null, null),
        });
        super.tearDown();
                assertThat("clusterState is:\n" + clusterState, health.getStatus(), equalTo(ClusterHealthStatus.RED));
            int numberOfShards = randomInt(3) + 1;
            indexNameExpressionResolver,
            .numberOfReplicas(numberOfReplicas)
                .settings(settings(Version.CURRENT))
import java.util.concurrent.CountDownLatch;
                    replicaStateChanged = true;
    }
            threadPool,
import java.util.Map;
        for (var shardEntry : indexRoutingTable.getShards().values()) {
        final RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
            boolean alreadyFailedPrimary = false;
        final String[] indices = new String[] { indexName };
 * software distributed under the License is distributed on an
import java.util.concurrent.ExecutionException;
        final IndexMetadata.Builder idxMetaBuilder2 = IndexMetadata.builder(clusterState.metadata().index(indexName));
    private static ThreadPool threadPool;
import org.opensearch.threadpool.ThreadPool;
        return clusterStates;
                if (clusterState.metadata().index(indexName).inSyncAllocationIds(shardRouting.getKey()).isEmpty() == false) {
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
        final int numberOfShards = randomIntBetween(1, 5);
            }
            final ShardRouting primaryShard = shardRouting.getValue().primaryShard();
                }
        String[] concreteIndices = indexNameExpressionResolver.concreteIndexNames(
                    newIndexRoutingTable.addShard(shardRouting);
                .numberOfReplicas(numberOfReplicas)
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
import org.opensearch.cluster.service.ClusterService;
        }
        }
                    newIndexRoutingTable.addShard(shardRouting.moveToStarted());
            .build();
 * compatible open source license.
            clusterStateHealth = new ClusterStateHealth(in);
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.metadata.Metadata;
    }
        assertClusterHealth(clusterStateHealth, counter, INDICES);
        final int numberOfReplicas = randomIntBetween(1, numberOfShards);
                for (ClusterIndexHealth clusterIndexHealth : clusterIndexHealths) {
        allocationIds.forEach(idxMetaBuilder2::putInSyncAllocationIds);
        // all replicas started
            .build();
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
        }
    public void testClusterHealthOnIndexCreation() {
            final ClusterState clusterState = clusterStates.get(i);
        return generateClusterStates(clusterState, indexName, numberOfReplicas, withPrimaryAllocationFailures);
                assertThat("clusterState is:\n" + clusterState, health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        CapturingTransport transport = new CapturingTransport();
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
import org.opensearch.cluster.ClusterState;
            }
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                        );
            } else {
    private TransportService transportService;
    public void setUp() throws Exception {
    }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                if (shardRouting.primary() == false && randomBoolean()) {
            .metadata(metadata)
 *
            transportService,
    public static void setupThreadPool() {
        if (withPrimaryAllocationFailures) {
            assertTrue(clusterStateHealth.getIndices().size() > 0);
            }
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.common.UUIDs;
        }
        final String[] indices = new String[] { indexName };
            .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID()))
    @BeforeClass
        final List<ClusterState> clusterStates = simulateClusterRecoveryStates(indexName, true, false);
            }
                () -> ClusterState.builder(currentState)
                    // give the replica a different node id than the primary
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            // make sure cluster health is YELLOW up until the final cluster state, which contains primary shard
            clusterService.getSettings(),
        indexRoutingTable = routingTable.index(indexName);
        );
            }
                for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
        clusterStateHealth = maybeSerialize(clusterStateHealth);
                            shardRouting.moveToUnassigned(new UnassignedInfo(UnassignedInfo.Reason.ALLOCATION_FAILED, "unlucky shard"))
        final List<ClusterState> clusterStates = new ArrayList<>();
import org.opensearch.action.support.ActionFilters;
                } else {
            return clusterStates;
                    final ShardRouting newShardRouting = shardRouting.moveToStarted();
            .metadata(metadata)
    }
            // make sure cluster health is YELLOW up until the final cluster state, when it turns GREEN
            if (i < clusterStates.size() - 1) {
        final boolean withPrimaryAllocationFailures
            clusterService,
                if (shardRouting.primary() == false) {
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
    }
        clusterStates.add(originalClusterState);
        }
 * under the License.
                    if (shardRouting.primary() && (shardRouting.started() == false || alreadyFailedPrimary == false)) {
    }
                    newIndexRoutingTable.addShard(shardRouting);
                if (primaryShard.unassignedInfo().getLastAllocationStatus() == UnassignedInfo.AllocationStatus.DECIDERS_NO) {
        allocationIds = new HashMap<>();
            }
            // if the inactive primaries are due solely to recovery (not failed allocation or previously being allocated)
        // all primaries started
        }
                }
        final ClusterState originalClusterState,
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
        }
            clusterStates.add(ClusterState.builder(clusterState).routingTable(routingTable).build());
import java.util.Collections;
