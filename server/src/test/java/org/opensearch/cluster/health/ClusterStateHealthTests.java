            }  
        for (var shardEntry : indexRoutingTable.getShards().values()) {  
import org.opensearch.cluster.routing.RecoverySource;  
                    assertFalse(clusterIndexHealth.getShards().isEmpty());  
        final int numberOfShards = randomIntBetween(1, 5);
    public void testClusterHealthOnClusterRecoveryWithPreviousAllocationIds() {  
                .numberOfShards(numberOfShards)  
        clusterStates.add(ClusterState.builder(clusterState).routingTable(routingTable).build());
import org.opensearch.Version;  
                    idxMetaWithAllocationIds.putInSyncAllocationIds(i, Sets.newHashSet(UUIDs.randomBase64UUID()));
    @After
            .build();
            } else {
        boolean replicaStateChanged = false;
        logger.info("--> realising task to restore cluster-manager");  
            }
        }  
            clusterStateHealth = new ClusterStateHealth(in);
import java.util.ArrayList;
/*  
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
            final ShardRouting primaryShard = shardRouting.getValue().primaryShard();
        clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices, SHARDS);
    ) {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        for (final var shardEntry : indexRoutingTable.getShards().values()) {  
import static org.opensearch.test.ClusterServiceUtils.setState;  
            }
            assertTrue(clusterStateHealth.getIndices().isEmpty());
            .routingTable(routingTable)
            }
            if (level.equals(SHARDS)) {  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            indexNameExpressionResolver,  
        allocationIds.forEach(idxMetaBuilder::putInSyncAllocationIds);
                    return false;  
            // some primaries failed to allocate  
                } else {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import static org.opensearch.action.admin.cluster.health.ClusterHealthRequest.Level.SHARDS;
            routingTable.add(indexRoutingTable);
                        );  
            } else {
    private List<ClusterState> generateClusterStates(  
import static org.hamcrest.Matchers.is;
import org.opensearch.cluster.routing.RoutingTable;
        }
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
            clusterStates.add(ClusterState.builder(clusterState).routingTable(routingTable).build());
            }  
import org.junit.After;
            BytesStreamOutput out = new BytesStreamOutput();
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadataBuilder).build();
        // initialize replicas
        clusterStates.add(clusterState);
                    newIndexRoutingTable.addShard(shardRouting.moveToStarted());  
        final RoutingTable routingTable = RoutingTable.builder().addAsRecovery(indexMetadata).build();  
                assertThat("clusterState is:\n" + clusterState, health.getStatus(), equalTo(ClusterHealthStatus.RED));  
    }  
    public void testClusterHealthOnIndexCreation() {  
                    assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
    }  
        clusterService.close();
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();  
        final String indexName = "test-idx";
                assertThat("clusterState is:\n" + clusterState, health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
import java.util.Set;  
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));  
        final String indexName,
                    atLeastOne = true;  
        for (int i = 0; i < clusterStates.size(); i++) {
                    .build(),  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test_cluster"))  
                } else {
        IndexRoutingTable indexRoutingTable = routingTable.index(indexName);
        final RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).metadata(metadataBuilder).build();
        CapturingTransport transport = new CapturingTransport();  
        ClusterState clusterState = originalClusterState;  
        final int numberOfReplicas = randomIntBetween(1, numberOfShards);
            .build();
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.cluster.node.DiscoveryNodes;  
            int numberOfReplicas = randomInt(4);  
        assertClusterHealth(clusterStateHealth, counter, SHARDS);  
        threadPool = null;  
            if (i < clusterStates.size() - 1) {
                .build();
import java.util.Map;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        final Set<String> nodeIds = new HashSet<>();
        final IndexMetadata.Builder idxMetaBuilder2 = IndexMetadata.builder(clusterState.metadata().index(indexName));
            threadPool,
                    && primaryShard.recoverySource().getType() == RecoverySource.Type.EXISTING_STORE) {
        logger.info("cluster status: {}, expected {}", clusterStateHealth.getStatus(), counter.status());  
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
                    newIndexRoutingTable.addShard(newShardRouting);
            clusterService,  
        final List<ClusterState> clusterStates = new ArrayList<>();
        }  
        final String[] indices = new String[] { indexName };  
                        alreadyFailedPrimary = true;
    @Before
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);  
        super.setUp();
import org.opensearch.cluster.service.ClusterService;  
            null
            .build();
        ClusterState clusterState = ClusterState.builder(new ClusterName("test_cluster"))
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
            // failed allocations that should make the cluster health RED
 * GitHub history for details.
    public void setUp() throws Exception {  
        indexRoutingTable = routingTable.index(indexName);  
        ClusterHealthRequest.Level level
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final CountDownLatch listenerCalled = new CountDownLatch(1);
    }
        final String indexName = "test-idx";
            final IndexShardRoutingTable shardRoutingTable = shardEntry;  
        clusterService.getClusterApplierService()
    public void testClusterHealth() throws IOException {
import org.opensearch.threadpool.TestThreadPool;
                // if the inactive primaries are due solely to recovery (not failed allocation or previously being allocated),
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
import java.util.List;
            }
                .numberOfReplicas(numberOfReplicas)
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
            final IndexShardRoutingTable shardRoutingTable = shardEntry;  
            assertTrue(clusterStateHealth.getIndices().size() > 0);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        }
                        newIndexRoutingTable.addShard(shardRouting);  
        }  
        final CountDownLatch applyLatch = new CountDownLatch(1);
            .nodes(clusterService.state().nodes())
                    assertThat(health.getStatus(), equalTo(ClusterHealthStatus.RED));  
        if (level.equals(INDICES) || level.equals(SHARDS)) {
            } else {  
            equalTo(clusterService.state().nodes().getClusterManagerNodeId() != null)
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);  
                }
            } catch (InterruptedException e) {  
                    newIndexRoutingTable.addShard(shardRouting.initialize(replicaNodeId, null, shardRouting.getExpectedShardSize()));
            }
            if (i < clusterStates.size() - 1) {
        }  
        final String[] indices = new String[] { indexName };
 *
            // make sure cluster health is YELLOW up until the final cluster state, which contains primary shard  
                () -> ClusterState.builder(currentState)
                if (primaryInactiveDueToRecovery(indexName, clusterState)) {  
            }
                if (primaryShard.unassignedInfo().getNumFailedAllocations() > 0) {
                } else {
    );
        // all primaries started  
        final List<ClusterState> clusterStates = simulateClusterRecoveryStates(indexName, true, false);  
            metadata.put(indexMetadata, true);
            );
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
import org.opensearch.cluster.ClusterState;
        applyLatch.countDown();
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertThat(clusterStateHealth.getUnassignedShards(), equalTo(counter.unassigned));
    }
    }
            newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
            }
 * You may obtain a copy of the License at  
        transportService.close();  
        for (int i = 0; i < clusterStates.size(); i++) {
 *
    private final IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(
 * compatible open source license.
        }
        listener.get();
                    return false;  
        final boolean withPreviousAllocationIds,  
        for (int i = randomInt(4); i >= 0; i--) {
            }
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName)  
 * the Apache License, Version 2.0 (the "License"); you may
        clusterService = createClusterService(threadPool);
    }
            .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID()))
import static org.hamcrest.CoreMatchers.equalTo;
                            shardRouting.moveToUnassigned(new UnassignedInfo(UnassignedInfo.Reason.ALLOCATION_FAILED, "unlucky shard"))
 * license agreements. See the NOTICE file distributed with
            final IndexMetadata.Builder idxMetaWithAllocationIds = IndexMetadata.builder(indexMetadata);
        Metadata.Builder metadata = Metadata.builder();  
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
                } else {
    }
            null,  
        RoutingTable routingTable = originalClusterState.routingTable();  
        }
import org.opensearch.test.transport.CapturingTransport;
            IndexRoutingTable indexRoutingTable = routingTableGenerator.genIndexRoutingTable(indexMetadata, counter);  
    }  
 */
        }  
        IndexRoutingTable.Builder newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
        );  
    // (not because of allocation of existing shard or previously having allocation ids assigned)
            Set<String> allocatedNodes = new HashSet<>();
        allocationIds.forEach(idxMetaBuilder2::putInSyncAllocationIds);  
    private List<ClusterState> simulateIndexCreationStates(final String indexName, final boolean withPrimaryAllocationFailures) {  
            }
import org.opensearch.cluster.routing.UnassignedInfo;
import org.opensearch.common.settings.Settings;  
        final int numberOfReplicas,  
    }
import org.opensearch.threadpool.ThreadPool;  
    ) {
                        newIndexRoutingTable.addShard(
    public void testClusterHealthOnClusterRecovery() {  
                }
            }
                    newIndexRoutingTable.addShard(shardRouting);  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        assertThat(clusterStateHealth.getRelocatingShards(), equalTo(counter.relocating));
                (source, e) -> {}
                for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
    }
        assertThat(clusterStateHealth.getActivePrimaryShards(), equalTo(counter.primaryActive));
            // if the inactive primaries are due solely to recovery (not failed allocation or previously being allocated)
                if (shardRouting.primary() && randomBoolean()) {  
        }
        allocationIds = new HashMap<>();  
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.RED));
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
                final IndexShardRoutingTable shardRoutingTable = shardEntry;
    }
        if (randomBoolean()) {  
}
            for (final var shardEntry : indexRoutingTable.getShards().values()) {  
                    newIndexRoutingTable.addShard(shardRouting);  
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.GREEN));
        final int numberOfReplicas = randomIntBetween(1, numberOfShards);
            indexMetadata = idxMetaWithAllocationIds.build();  
                if (shardRouting.primary() == false && randomBoolean()) {  
            for (int i = 0; i < numberOfShards; i++) {  
import org.opensearch.cluster.metadata.Metadata;
        super.tearDown();
        final List<ClusterState> clusterStates = simulateIndexCreationStates(indexName, false);  
        for (final var shardEntry : indexRoutingTable.getShards().values()) {  
            .metadata(metadata)
                if (atLeastOne == false || randomBoolean()) {
            .numberOfShards(numberOfShards)
        final List<ClusterState> clusterStates = simulateIndexCreationStates(indexName, true);
 * this work for additional information regarding copyright
        // initial index creation and new routing table info  
        logger.info("--> submit task to restore cluster-manager");
                } else {
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    private TransportService transportService;  
        clusterService.addStateApplier(event -> {
    private static ThreadPool threadPool;  
        return true;
                    newIndexRoutingTable.addShard(shardRouting.moveToStarted());
            }
                }  
        logger.info("--> waiting for listener to be called and cluster state being blocked");
            new ActionFilters(new HashSet<>()),
                    } else {
            int numberOfShards = randomInt(3) + 1;
import java.util.Collections;
            threadPool,  
                .build()
 */  
            if (primaryShard.active() == false) {  
    @AfterClass  
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.action.support.PlainActionFuture;  
        }
            clusterStates.add(ClusterState.builder(clusterState).routingTable(routingTable).build());
        // some primaries started
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
                if (shardRouting.primary() && shardRouting.started() == false) {
    @BeforeClass
 * this file be licensed under the Apache-2.0 license or a
        clusterStates.add(clusterState);  
        final String[] indices = new String[] { indexName };
        }
import static org.opensearch.action.admin.cluster.health.ClusterHealthRequest.Level.INDICES;  
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.RED));
                }  
import org.opensearch.cluster.routing.allocation.AllocationService;
    }  
        final boolean withPrimaryAllocationFailures
import org.opensearch.common.util.set.Sets;
        final String indexName = "test-idx";
            // failed allocations that should make the cluster health RED
import java.util.Collection;  
import org.opensearch.test.gateway.TestGatewayAllocator;  
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();  
    }
        }
                .nodes(DiscoveryNodes.builder(clusterService.state().nodes()).clusterManagerNodeId(null))
import org.opensearch.action.support.ActionFilters;
            IndexMetadata indexMetadata = IndexMetadata.builder("test_" + Integer.toString(i))
        );  
                } else {
                    .nodes(DiscoveryNodes.builder(currentState.nodes()).clusterManagerNodeId(currentState.nodes().getLocalNodeId()))
                if (primaryShard.unassignedInfo().getLastAllocationStatus() == UnassignedInfo.AllocationStatus.DECIDERS_NO) {
import java.util.concurrent.ExecutionException;
                    replicaStateChanged = true;
        );
        listenerCalled.await();
            // because there were previous allocation ids, we should be RED until the primaries are started,
        final String indexName = "test-idx";  
        PlainActionFuture<ClusterHealthResponse> listener = new PlainActionFuture<>();
            (String[]) null  
        // some replicas started  
                }
            clusterState,
                .settings(settings(Version.CURRENT))
            .state(IndexMetadata.State.OPEN)
        }
            final String primaryNodeId = shardRoutingTable.primaryShard().currentNodeId();
        // generate random node ids  
                if (clusterState.metadata().index(indexName).inSyncAllocationIds(shardRouting.getKey()).isEmpty() == false) {
            final ClusterState clusterState = clusterStates.get(i);  
            // make sure cluster health is YELLOW up until the final cluster state, which contains primary shard  
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(clusterStateHealth.getActiveShardsPercent(), is(allOf(greaterThanOrEqualTo(0.0), lessThanOrEqualTo(100.0))));  
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
            .build();  
            }  
            } else {
    private ClusterService clusterService;
        threadPool = new TestThreadPool("ClusterStateHealthTests");
                if (shardRouting.primary()) {  
                Collection<ClusterIndexHealth> clusterIndexHealths = clusterStateHealth.getIndices().values();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                }
        metadataBuilder = Metadata.builder(clusterState.metadata()).put(idxMetaBuilder2);
        assertFalse(listener.isDone());
                    newIndexRoutingTable.addShard(shardRouting);
        for (int i = 0; i < clusterStates.size(); i++) {
import org.opensearch.core.common.io.stream.StreamInput;  
            .onNewClusterState(
            }
            if (i < clusterStates.size() - 1) {
        indexRoutingTable = routingTable.index(indexName);  
                }
                    return false;
        for (int i = 0; i < clusterStates.size(); i++) {
                    allocationIds.put(newShardRouting.getId(), Set.of(newShardRouting.allocationId().getId()));
        new ThreadContext(Settings.EMPTY)  
 * Unless required by applicable law or agreed to in writing,
    }
    public void testClusterHealthWaitsForClusterStateApplication() throws InterruptedException, ExecutionException {  
            } else {  
        if (replicaStateChanged) {
        final String[] indices = new String[] { indexName };
import org.junit.BeforeClass;
        ClusterStateHealth clusterStateHealth,
import static org.opensearch.action.admin.cluster.health.ClusterHealthRequest.Level.CLUSTER;
    ClusterStateHealth maybeSerialize(ClusterStateHealth clusterStateHealth) throws IOException {
    public static void setupThreadPool() {  
        } else {  
        assertThat(
    private void assertClusterHealth(
        RoutingTableGenerator.ShardCounter counter,  
    private List<ClusterState> simulateClusterRecoveryStates(
                }
            try {
        for (int i = 0; i < numNodes; i++) {  
                    if (shardRouting.primary() && (shardRouting.started() == false || alreadyFailedPrimary == false)) {  
        assertClusterHealth(clusterStateHealth, counter, CLUSTER);
                }
            boolean alreadyFailedPrimary = false;
import org.opensearch.common.io.stream.BytesStreamOutput;
            if (i < clusterStates.size() - 1) {  
        RoutingTableGenerator.ShardCounter counter = new RoutingTableGenerator.ShardCounter();
        indexRoutingTable = routingTable.index(indexName);
            new AllocationService(null, new TestGatewayAllocator(), null, null, null),
                    newIndexRoutingTable.addShard(shardRouting);
import java.util.HashMap;
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);
    }
                for (ClusterIndexHealth clusterIndexHealth : clusterIndexHealths) {
            .numberOfReplicas(numberOfReplicas)  
                } else {
 * Licensed to Elasticsearch under one or more contributor  
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {  
 * The OpenSearch Contributors require contributions made to  
            return clusterStates;  
            // make sure cluster health is YELLOW up until the final cluster state, when it turns GREEN
    public void testClusterHealthOnIndexCreationWithFailedAllocations() {
import org.opensearch.action.admin.cluster.health.TransportClusterHealthAction;  
            final ClusterState clusterState = clusterStates.get(i);  
        indexRoutingTable = routingTable.index(indexName);
/*
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
    public void testClusterHealthOnClusterRecoveryWithPreviousAllocationIdsAndAllocationFailures() {
        final String[] indices = new String[] { indexName };
            final ClusterState clusterState = clusterStates.get(i);
import static org.hamcrest.CoreMatchers.allOf;
        for (final ClusterState clusterState : simulateClusterRecoveryStates(indexName, true, true)) {
                    String replicaNodeId = randomFrom(Sets.difference(nodeIds, allocatedNodes));
                if (primaryShard.recoverySource() != null
            .routingTable(routingTable.build())  
        clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices, INDICES);  
        return generateClusterStates(clusterState, indexName, numberOfReplicas, withPrimaryAllocationFailures);
        return generateClusterStates(clusterState, indexName, numberOfReplicas, withPrimaryAllocationFailures);  
        for (final var shardRouting : clusterState.routingTable().index(indexName).shards().entrySet()) {
            .numberOfReplicas(numberOfReplicas)
        ClusterStateHealth clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices);
import org.opensearch.cluster.metadata.IndexMetadata;  
            // then cluster health is YELLOW, otherwise RED
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
        }  
        ClusterState currentState = clusterService.getClusterApplierService().state();  
import org.opensearch.test.OpenSearchTestCase;
    }
        final IndexMetadata.Builder idxMetaBuilder = IndexMetadata.builder(clusterState.metadata().index(indexName));
                    allocatedNodes.add(replicaNodeId);  
        }  
            if (primaryInactiveDueToRecovery(indexName, clusterState)) {  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
    ) {
import org.opensearch.cluster.ClusterName;
        );  
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
 * SPDX-License-Identifier: Apache-2.0
        routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
            .metadata(metadata)  
        clusterStates.add(clusterState);  
import org.opensearch.cluster.routing.ShardRouting;  
        return clusterStates;
import org.junit.AfterClass;  
        String[] concreteIndices = indexNameExpressionResolver.concreteIndexNames(  
        transportService.acceptIncomingRequests();
            nodeIds.add(randomAlphaOfLength(8));
                    return false;  
        RoutingTableGenerator routingTableGenerator = new RoutingTableGenerator();  
            final ClusterState clusterState = clusterStates.get(i);
                "restore cluster-manager",  
            .settings(settings(Version.CURRENT).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID()))
        TransportClusterHealthAction action = new TransportClusterHealthAction(
        );
            routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();
            IndicesOptions.strictExpand(),
            indexRoutingTable = routingTable.index(indexName);
        assertClusterHealth(clusterStateHealth, counter, INDICES);
        final IndexMetadata indexMetadata = IndexMetadata.builder(indexName)
                }  
            final ClusterState clusterState = clusterStates.get(i);
        final List<ClusterState> clusterStates = simulateClusterRecoveryStates(indexName, false, false);  
    // returns true if the inactive primaries in the index are only due to cluster recovery
        final boolean withPrimaryAllocationFailures
    public void tearDown() throws Exception {  
                // then cluster health is YELLOW, otherwise RED
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
        final String[] indices = new String[] { indexName };  
        final List<ClusterState> clusterStates = simulateClusterRecoveryStates(indexName, false, true);
            .build();
 * specific language governing permissions and limitations
        newIndexRoutingTable = IndexRoutingTable.builder(indexRoutingTable.getIndex());
        return clusterStateHealth;  
        // initialize primaries
        setState(
import org.opensearch.transport.TransportService;
import java.util.HashSet;  
    public static void terminateThreadPool() {
        final int numNodes = randomIntBetween(numberOfReplicas + 1, 10);
            clusterService.getSettings(),
/*
import java.io.IOException;
            .numberOfShards(numberOfShards)  
            NoopTracer.INSTANCE
        // all replicas started
        assertThat(clusterStateHealth.getActiveShards(), equalTo(counter.active));
    @Override
        final String indexName = "test-idx";
        assertClusterHealth(clusterStateHealth, counter, SHARDS);  
            .routingTable(routingTable)
import org.opensearch.telemetry.tracing.noop.NoopTracer;
 * software distributed under the License is distributed on an
    public void testClusterHealthOnClusterRecoveryWithFailures() {
        assertThat(clusterStateHealth.getStatus(), equalTo(counter.status()));  
            Collections.emptySet(),
                    newIndexRoutingTable.addShard(shardRouting);  
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.GREEN));  
            } else {
                    // give the replica a different node id than the primary  
                    final ShardRouting newShardRouting = shardRouting.moveToStarted();
 *  
            x -> clusterService.localNode(),
        final int numberOfShards = randomIntBetween(1, 5);  
    private boolean primaryInactiveDueToRecovery(final String indexName, final ClusterState clusterState) {  
                }
            }
        transportService.start();
                    newIndexRoutingTable.addShard(shardRouting.initialize(randomFrom(nodeIds), null, shardRouting.getExpectedShardSize()));
            final IndexShardRoutingTable shardRoutingTable = shardEntry;
        if (withPreviousAllocationIds) {  
        for (int i = 0; i < clusterStates.size(); i++) {
        }
import org.junit.Before;
                if (shardRouting.primary() == false && shardRouting.started() == false) {
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata()).put(idxMetaBuilder);  
                    newIndexRoutingTable.addShard(newShardRouting);  
                logger.debug("interrupted", e);
                    newIndexRoutingTable.addShard(shardRouting);  
 * ownership. Elasticsearch licenses this file to you under  
        // initial index creation and new routing table info
                }
            // make sure cluster health is always YELLOW, up until the last state where it should be GREEN
        }  
import org.opensearch.cluster.routing.RoutingTableGenerator;
        final String indexName,
                    }
        if (withPrimaryAllocationFailures) {
            .metadata(metadata)
            allocatedNodes.add(primaryNodeId);  
            listenerCalled.countDown();  
                }
        final ClusterState originalClusterState,
            routingTable = RoutingTable.builder(routingTable).add(newIndexRoutingTable).build();  
import org.opensearch.common.UUIDs;
            clusterService,
        action.execute(new ClusterHealthRequest().waitForGreenStatus(), listener);
        indexRoutingTable = routingTable.index(indexName);  
package org.opensearch.cluster.health;
import java.util.concurrent.TimeUnit;  
            transportService,
        final String indexName = "test-idx";
 *     http://www.apache.org/licenses/LICENSE-2.0
        });  
                    final ShardRouting newShardRouting = shardRouting.moveToStarted();
        clusterStates.add(originalClusterState);
 * under the License.  
                if (shardRouting.primary() == false) {
            ClusterState.builder(clusterService.state())  
            }
        clusterStateHealth = maybeSerialize(clusterStateHealth);
        }
import org.opensearch.cluster.routing.IndexRoutingTable;
            clusterStateHealth.writeTo(out);
            // then move to YELLOW, and the last state should be GREEN when all shards have been started  
                assertThat(health.getStatus(), equalTo(ClusterHealthStatus.YELLOW));  
            final ClusterStateHealth health = new ClusterStateHealth(clusterState, indices);  
 */
    }
                    allocationIds.put(newShardRouting.getId(), Set.of(newShardRouting.allocationId().getId()));  
            boolean atLeastOne = false;
        }
                applyLatch.await();
            if (i < clusterStates.size() - 1) {
        transportService = transport.createTransportService(
    }  
        // all of the replicas may have moved to started in the previous phase already
import java.util.concurrent.CountDownLatch;
        clusterStates.add(ClusterState.builder(clusterState).routingTable(routingTable).build());
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
public class ClusterStateHealthTests extends OpenSearchTestCase {
            clusterStateHealth.hasDiscoveredClusterManager(),  
            StreamInput in = out.bytes().streamInput();  
 * not use this file except in compliance with the License.
        final Metadata metadata = Metadata.builder().put(indexMetadata, true).build();  
            for (final ShardRouting shardRouting : shardRoutingTable.getShards()) {
        assertThat(clusterStateHealth.getInitializingShards(), equalTo(counter.initializing));  
        RoutingTable.Builder routingTable = RoutingTable.builder();
        for (final var shardEntry : indexRoutingTable.getShards().values()) {
        Map<Integer, Set<String>> allocationIds = new HashMap<>();
                }
        clusterStateHealth = new ClusterStateHealth(clusterState, concreteIndices, ClusterHealthRequest.Level.CLUSTER);
