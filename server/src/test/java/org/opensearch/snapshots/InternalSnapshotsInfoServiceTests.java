import org.opensearch.cluster.routing.allocation.AllocationService;
            () -> repositoriesService,
                snapshotsInfoService.numberOfFailedSnapshotShardSizes() + snapshotsInfoService.numberOfKnownSnapshotShardSizes(),
                }
import org.opensearch.cluster.routing.RecoverySource;
            new IndexId(indexName, UUIDs.randomBase64UUID(random()))
        final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
    private RerouteService rerouteService;
            final long defaultValue = randomNonNegativeLong();
            );
                snapshotsInfoService
 * not use this file except in compliance with the License.
        );
import org.junit.Before;
 * compatible open source license.
import org.opensearch.common.UUIDs;
                }
        final RecoverySource.SnapshotRecoverySource recoverySource = new RecoverySource.SnapshotRecoverySource(
        for (int i = 0; i < expectedShardSizes.length; i++) {
        }
import java.util.concurrent.ConcurrentHashMap;
            listener.onResponse(clusterService.state());
        when(repositoriesService.repository("_repo")).thenReturn(mockRepository);
        for (int i = 0; i < numberOfShards; i++) {
        final CountDownLatch latch = new CountDownLatch(1);
            );
            reroutes.incrementAndGet();
            @Override
            assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(0));
    }
            @Override
            shards.put(new ShardId(index, i), new RestoreInProgress.ShardRestoreStatus(clusterService.state().nodes().getLocalNodeId()));
        assert terminated;
        );
                    applyClusterState(
import org.opensearch.cluster.routing.IndexRoutingTable;
        final AtomicInteger reroutes = new AtomicInteger();
            assertThat(generic.getActive(), equalTo(nbActive));
        }, 30L, TimeUnit.SECONDS);
        final SnapshotShardSizeInfo snapshotShardSizeInfo = snapshotsInfoService.snapshotShardSizes();
import static org.hamcrest.Matchers.lessThan;
        final int numberOfShards = randomIntBetween(1, 50);
                    assertThat(indexId.getName(), equalTo(indexName));
        if (randomBoolean()) {
import org.opensearch.core.index.shard.ShardId;
            new RestoreInProgress.Entry(
        final RerouteService rerouteService = (reason, priority, listener) -> {
        assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(0));
        }
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING;
    }
        super.setUp();
                    return IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0L, shardSize, null);
import java.util.concurrent.CountDownLatch;
                .index(shardId.getIndexName())
        final IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
import java.util.concurrent.atomic.AtomicInteger;
            clusterService,
        final SnapshotShardSizeInfo snapshotShardSizeInfo = snapshotsInfoService.snapshotShardSizes();
 * ownership. Elasticsearch licenses this file to you under
                        "add-more-unassigned-shards-for-" + indexName,
                    results.put(snapshotShard, Long.MIN_VALUE);
        assertBusy(() -> {
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
        final long[] expectedShardSizes = new long[numberOfShards];
                    new Snapshot("_repo", snapshotId),
        if (randomBoolean()) {
            final ThreadPoolStats threadPoolStats = clusterService.getClusterApplierService().threadPool().stats();
            @Override
            )
                recoverySource.restoreUUID(),
            () -> repositoriesService,
            );
                    @Override
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata())
            .metadata(Metadata.builder(currentState.metadata()).remove(indexName))
 * under the License.
            assertFalse(clusterService.state().metadata().hasIndex(indexName));
        final AtomicInteger getShardSnapshotStatusCount = new AtomicInteger(0);
            applyClusterState("delete index " + indexName, clusterState -> deleteIndex(clusterState, indexName));
            }
            final int nbShards = randomIntBetween(1, 5);
import static org.hamcrest.Matchers.is;
            public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
                snapshotsInfoService.numberOfFailedSnapshotShardSizes(),
import org.opensearch.action.support.PlainActionFuture;
        );
import org.opensearch.core.index.Index;
            .metadata(metadata)
 */
            future -> clusterService.getClusterApplierService()
        } else {
        };
}
                if (randomBoolean()) {
import static org.hamcrest.Matchers.equalTo;
    }
import static org.opensearch.snapshots.InternalSnapshotsInfoService.INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING;
                try {
                } else {
 */
import static org.mockito.Mockito.when;
        final IndexMetadata indexMetadata = metadata.get(indexName);
                    .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), nbShards)
        applyClusterState("demote-current-cluster-manager", this::demoteClusterManagerNode);
            () -> rerouteService
                RestoreInProgress.State.INIT,
 * this file be licensed under the Apache-2.0 license or a
/*
            assertThat(snapshotShardSizeInfo.getShardSize(shardRouting, Long.MIN_VALUE), equalTo(expectedShardSizes[i]));
                    .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), nbShards)
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        });
                snapshotShardSizeInfo.getShardSize(shardRouting),
    @Before
        final Repository mockRepository = new FilterRepository(mock(Repository.class)) {
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
        final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
            final boolean success = failedSnapshotShardSizeRetrieval.test(snapshotShard.getValue()) == false;
                }
package org.opensearch.snapshots;
        assertThat(snapshotsInfoService.numberOfFailedSnapshotShardSizes(), equalTo(0));
            .build();
 *     http://www.apache.org/licenses/LICENSE-2.0
            applyClusterState(
                        clusterState -> addUnassignedShards(clusterState, indexName, numberOfShards)
                    return IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0L, expectedShardSizes[shardId.id()], null);
        final int nbShards = randomIntBetween(1, 10);
import org.junit.After;
            assertThat(rerouteLatch.getCount(), greaterThanOrEqualTo(0L));
            @Override
        assertThat(currentState.metadata().hasIndex(indexName), is(false));
    @Override
                } catch (InterruptedException e) {
import static org.hamcrest.Matchers.nullValue;
            }
public class InternalSnapshotsInfoServiceTests extends OpenSearchTestCase {
                    throw new AssertionError(e);
            Collections.emptyMap(),
            final int nbShards = randomIntBetween(1, 5);
            // simulate initialization and start of the shards
                success ? equalTo(results.get(snapshotShard.getKey())) : equalTo(ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE)
                })
 *
                "starting shards for " + indexName,
import org.opensearch.threadpool.TestThreadPool;
                    .build(),
        addSnapshotRestoreIndicesThread.join();
            );
                Settings.builder()
    public void testSnapshotShardSizes() throws Exception {
    private TestThreadPool threadPool;
        final RestoreInProgress.Builder restores = new RestoreInProgress.Builder(
        addSnapshotRestoreIndicesThread.start();
    }
            clusterService,
                }
        final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
                if (randomBoolean()) {
 * KIND, either express or implied.  See the License for the
        final boolean terminated = terminate(threadPool);
        clusterService.close();
    }
                Collections.singletonList(indexName),
        repositoriesService = mock(RepositoriesService.class);
import org.opensearch.test.OpenSearchTestCase;
                    }
            currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)
import org.opensearch.threadpool.ThreadPool;
        for (int i = 0; i < randomIntBetween(1, 10); i++) {
            }
                try {
import org.opensearch.cluster.routing.ShardRouting;
                    throw new AssertionError(e);
import org.opensearch.cluster.ClusterState;
            UUIDs.randomBase64UUID(random()),
            for (ThreadPoolStats.Stats threadPoolStat : threadPoolStats) {
            () -> rerouteService
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.test.ClusterServiceUtils;
import org.opensearch.cluster.routing.AllocationId;
        applyClusterState(
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
import java.util.function.Predicate;
        assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(0));
            Version.CURRENT
            "new snapshot restore for index " + indexName,
            assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(0));
        }
            clusterState -> addUnassignedShards(clusterState, indexName, nbShards)
        final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
        );
        );
        );
            assertThat(generic, notNullValue());
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
                    indexId,
        assertThat(snapshotsInfoService.numberOfKnownSnapshotShardSizes(), equalTo(numberOfShards));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    );
            assertThat(snapshotsInfoService.numberOfFailedSnapshotShardSizes(), equalTo(0));
            () -> rerouteService
 * The OpenSearch Contributors require contributions made to
import org.opensearch.repositories.Repository;
            clusterService,
        assertTrue(rerouteLatch.await(30L, TimeUnit.SECONDS));
    }
                );
                    generic = threadPoolStat;
                } catch (Exception e) {
                    throw new SnapshotException(snapshotShard.snapshot(), "simulated");
        }
        assertThat(currentState.nodes().get(node.getId()), nullValue());
    private ClusterState deleteIndex(final ClusterState currentState, final String indexName) {
        for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {
        when(repositoriesService.repository("_repo")).thenReturn(mockRepository);
        final int maxShardsToCreate = scaledRandomIntBetween(10, 500);
            public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
            // simulate deletion of the index
                    }
            }
            );
        super.tearDown();
        rerouteService = (reason, priority, listener) -> listener.onResponse(clusterService.state());
    public void testErroneousSnapshotShardSizes() throws Exception {
import org.opensearch.cluster.node.DiscoveryNodes;
            .settings(
    }
    }
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        assertThat("Expecting all snapshot shard size fetches to execute a Reroute", reroutes.get(), equalTo(maxShardsToCreate));
        waitForMaxActiveGenericThreads(Math.min(numberOfShards, maxConcurrentFetches));
        when(repositoriesService.repository("_repo")).thenReturn(mockRepository);
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
 */
                    results.put(snapshotShard, shardSize);
            .build();
    private ClusterState demoteClusterManagerNode(final ClusterState currentState) {
                    @Override
        }
                snapshotsInfoService.numberOfKnownSnapshotShardSizes(),
                equalTo((int) results.values().stream().filter(size -> failedSnapshotShardSizeRetrieval.test(size) == false).count())
 * Licensed to Elasticsearch under one or more contributor
                state -> ClusterState.builder(state).incrementVersion().build()
            .routingTable(RoutingTable.builder(currentState.routingTable()).remove(indexName).build())
            )
 * software distributed under the License is distributed on an
    public void testNoLongerClusterManager() throws Exception {
import org.opensearch.repositories.FilterRepository;
            );
        };
            .generateClusterUuidIfNeeded();
        // waiting for snapshot shard size fetches to be executed, as we want to verify that they are cleaned up
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            int remainingShards = maxShardsToCreate;
        }
                        future.onFailure(e);
        assertThat(getShardSnapshotStatusCount.get(), equalTo(numberOfShards));
                equalTo((int) results.values().stream().filter(failedSnapshotShardSizeRetrieval).count())
                    public void onSuccess(String source) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            Settings.EMPTY,
        assertBusy(
        assertThat(snapshotsInfoService.numberOfFailedSnapshotShardSizes(), equalTo(0));
        );
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            .routingTable(routingTable.build())
                    return IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0L, randomNonNegativeLong(), null);
                "reapply-last-cluster-state-to-check-deduplication-works",
        final Repository mockRepository = new FilterRepository(mock(Repository.class)) {
                if (ThreadPool.Names.GENERIC.equals(threadPoolStat.getName())) {
                    final long shardSize = randomNonNegativeLong();
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
            "other",
            .nodes(DiscoveryNodes.builder(currentState.nodes()).add(node).clusterManagerNodeId(node.getId()))
import java.util.function.Function;
            Settings.builder().put(INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING.getKey(), maxConcurrentFetches).build(),
            DiscoveryNodeRole.BUILT_IN_ROLES,
                    getShardSnapshotStatusCount.incrementAndGet();
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.cluster.routing.RoutingTable;
            }
        }
        };
            assertThat(
            );
                    remainingShards -= numberOfShards;
        final Repository mockRepository = new FilterRepository(mock(Repository.class)) {
        };
        assertThat(snapshotsInfoService.numberOfKnownSnapshotShardSizes(), equalTo(0));
            ThreadPoolStats.Stats generic = null;
        restores.add(
/*
import org.opensearch.repositories.IndexId;
        assertBusy(() -> {
 * Unless required by applicable law or agreed to in writing,
        };
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(
    private void applyClusterState(final String reason, final Function<ClusterState, ClusterState> applier) {
            Version.CURRENT,
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)
            () -> repositoriesService,
        routingTable.add(IndexRoutingTable.builder(index).initializeAsNewRestore(indexMetadata, recoverySource, new HashSet<>()).build());
        });
            OpenSearchTestCase.buildNewFakeTransportAddress(),
        final Repository mockRepository = new FilterRepository(mock(Repository.class)) {
        applyClusterState("add-unassigned-shards", clusterState -> addUnassignedShards(clusterState, indexName, numberOfShards));
        }
    @Override
 * this work for additional information regarding copyright
        when(repositoriesService.repository("_repo")).thenReturn(mockRepository);
/*
        final RerouteService rerouteService = (reason, priority, listener) -> {
 * specific language governing permissions and limitations
            final ShardId shardId = snapshotShard.getKey().shardId();
                } finally {
        return ClusterState.builder(currentState)
        };
        for (int i = 0; i < randomIntBetween(1, 10); i++) {
                final int numberOfShards = randomIntBetween(1, remainingShards);
                } else {
            indexMetadataBuilder.putInSyncAllocationIds(i, Collections.singleton(AllocationId.newInitializing().getId()));
            .put(indexMetadataBuilder.build(), true)
 * You may obtain a copy of the License at
import java.util.HashSet;
        return ClusterState.builder(currentState)
    }
        for (int i = 0; i < numberOfShards; i++) {
                recoverySource.snapshot(),
    private void waitForMaxActiveGenericThreads(final int nbActive) throws Exception {
 *
            assertThat(
                return IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0L, randomNonNegativeLong(), null);
import java.util.Locale;
        return ClusterState.builder(currentState)
        );
            listener.onResponse(clusterService.state());
                final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
import java.util.Collections;
            () -> assertThat(
 *
            final ShardRouting shardRouting = clusterService.state().routingTable().index(indexName).shard(i).primaryShard();
        final Index index = indexMetadata.getIndex();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        );
    }
                }
        assertThat("Expecting all snapshot shard size fetches to provide a size", results.size(), equalTo(maxShardsToCreate));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertThat(snapshotsInfoService.numberOfKnownSnapshotShardSizes(), equalTo(0));
            new Snapshot("_repo", new SnapshotId(randomAlphaOfLength(5), UUIDs.randomBase64UUID(random()))),
            .putCustom(RestoreInProgress.TYPE, restores.build())
import org.opensearch.cluster.service.ClusterApplier;
                .shard(shardId.id())
import org.opensearch.Version;
import org.opensearch.cluster.node.DiscoveryNodeRole;
    }
        assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(numberOfShards));
import org.opensearch.repositories.RepositoriesService;
                clusterState -> addUnassignedShards(clusterState, indexName, nbShards)
            applyClusterState(
                Settings.builder()
                success ? equalTo(results.get(snapshotShard.getKey())) : equalTo(defaultValue)
            assertThat(shardRouting, notNullValue());
                snapshotShardSizeInfo.getShardSize(shardRouting, defaultValue),
                "restore-indices-when-cluster-manager-" + indexName,
                    public void onFailure(String source, Exception e) {
            assertThat(
                .routingTable()
import org.opensearch.cluster.RestoreInProgress;
import java.util.Map;
import org.opensearch.cluster.routing.RerouteService;
        assertThat(snapshotsInfoService.numberOfKnownSnapshotShardSizes(), equalTo(0));
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.concurrent.TimeUnit;
        );
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards = new HashMap<>();
            public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
import org.opensearch.cluster.routing.ShardRoutingState;
                    latch.await();
            final AllocationService allocationService = OpenSearchAllocationTestCase.createAllocationService(
 * GitHub history for details.
            public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
                shards
    @After
                .primaryShard();
                        future.onResponse(source);
    public void setUp() throws Exception {
            () -> repositoriesService,
        final Map<InternalSnapshotsInfoService.SnapshotShard, Long> results = new ConcurrentHashMap<>();
    private RepositoriesService repositoriesService;
            Settings.EMPTY,
                "restore-indices-when-no-longer-cluster-manager-" + indexName,
 * SPDX-License-Identifier: Apache-2.0
    private ClusterService clusterService;
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
                clusterState -> OpenSearchAllocationTestCase.startInitializingShardsAndReroute(allocationService, clusterState, indexName)
                    throw new SnapshotException(new Snapshot("_repo", snapshotId), "simulated");
        final Predicate<Long> failedSnapshotShardSizeRetrieval = shardSize -> shardSize == Long.MIN_VALUE;
            while (remainingShards > 0) {
    public void tearDown() throws Exception {
                final InternalSnapshotsInfoService.SnapshotShard snapshotShard = new InternalSnapshotsInfoService.SnapshotShard(
                clusterState -> addUnassignedShards(clusterState, indexName, nbShards)
    public void testCleanUpSnapshotShardSizes() throws Exception {
            .build();
import org.opensearch.common.settings.Settings;
            expectedShardSizes[i] = randomNonNegativeLong();
            clusterService,
            assertThat(snapshotShardSizeInfo.getShardSize(shardRouting), equalTo(expectedShardSizes[i]));
            final ShardRouting shardRouting = clusterService.state()
import org.opensearch.cluster.metadata.Metadata;
        PlainActionFuture.get(
        assertBusy(() -> {
            rerouteLatch.countDown();
        threadPool = new TestThreadPool(getTestName());
        final DiscoveryNode node = new DiscoveryNode(
            assertTrue(clusterService.state().routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).isEmpty());
        final Thread addSnapshotRestoreIndicesThread = new Thread(() -> {
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
import static org.mockito.Mockito.mock;
            );
        for (Map.Entry<InternalSnapshotsInfoService.SnapshotShard, Long> snapshotShard : results.entrySet()) {
        final CountDownLatch rerouteLatch = new CountDownLatch(numberOfShards);
        });
        final int maxConcurrentFetches = randomIntBetween(1, 10);
import java.util.HashMap;
import org.opensearch.threadpool.ThreadPoolStats;
import org.opensearch.cluster.service.ClusterService;
            }
 * license agreements. See the NOTICE file distributed with
            applyClusterState(
            );
                    shardId
        }
        latch.countDown();
    private ClusterState addUnassignedShards(final ClusterState currentState, String indexName, int numberOfShards) {
import static org.hamcrest.Matchers.allOf;
            );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            applyClusterState(
                equalTo(nbShards)
            Settings.builder().put(INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING.getKey(), randomIntBetween(1, 10)).build(),
        );
                .onNewClusterState(reason, () -> applier.apply(clusterService.state()), new ClusterApplier.ClusterApplyListener() {
 * the Apache License, Version 2.0 (the "License"); you may
            () -> rerouteService
                    assertThat(shardId.id(), allOf(greaterThanOrEqualTo(0), lessThan(numberOfShards)));
