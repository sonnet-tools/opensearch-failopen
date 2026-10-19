        when(repositoriesService.repository("_repo")).thenReturn(mockRepository);
    private TestThreadPool threadPool;  
    public void testErroneousSnapshotShardSizes() throws Exception {
    }
        final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
            assertTrue(clusterService.state().routingTable().shardsWithState(ShardRoutingState.UNASSIGNED).isEmpty());  
            ThreadPoolStats.Stats generic = null;  
        assertThat(snapshotsInfoService.numberOfKnownSnapshotShardSizes(), equalTo(0));
                shards
import org.opensearch.cluster.metadata.Metadata;
        };  
import static org.opensearch.snapshots.InternalSnapshotsInfoService.INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING;
                snapshotsInfoService.numberOfFailedSnapshotShardSizes(),
            }  
            // simulate initialization and start of the shards  
            assertThat(shardRouting, notNullValue());
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
            )
            Version.CURRENT  
                })
                    remainingShards -= numberOfShards;  
import java.util.concurrent.ConcurrentHashMap;
                Settings.builder()
    }
            assertThat(snapshotsInfoService.numberOfKnownSnapshotShardSizes(), equalTo(0));
 * You may obtain a copy of the License at  
        for (Map.Entry<InternalSnapshotsInfoService.SnapshotShard, Long> snapshotShard : results.entrySet()) {  
                snapshotsInfoService.numberOfFailedSnapshotShardSizes() + snapshotsInfoService.numberOfKnownSnapshotShardSizes(),  
import static org.hamcrest.Matchers.lessThan;
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            Collections.emptyMap(),
                    .put(SETTING_NUMBER_OF_SHARDS, numberOfShards)  
            clusterService,
    private ClusterState deleteIndex(final ClusterState currentState, final String indexName) {  
        );  
            }
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.cluster.ClusterState;  
            // simulate deletion of the index  
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                snapshotsInfoService  
        assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(0));
                    .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), nbShards)
                    shardId
import org.opensearch.cluster.routing.RecoverySource;
 * software distributed under the License is distributed on an
                state -> ClusterState.builder(state).incrementVersion().build()  
 */  
                return IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0L, randomNonNegativeLong(), null);  
import static org.mockito.Mockito.mock;
                    generic = threadPoolStat;  
            .build();  
        final Repository mockRepository = new FilterRepository(mock(Repository.class)) {
        final Predicate<Long> failedSnapshotShardSizeRetrieval = shardSize -> shardSize == Long.MIN_VALUE;
                    .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), nbShards)  
        repositoriesService = mock(RepositoriesService.class);
                        future.onFailure(e);  
        }
            int remainingShards = maxShardsToCreate;  
                    );
                .onNewClusterState(reason, () -> applier.apply(clusterService.state()), new ClusterApplier.ClusterApplyListener() {
        addSnapshotRestoreIndicesThread.start();
    public void testSnapshotShardSizes() throws Exception {  
import java.util.HashMap;  
        waitForMaxActiveGenericThreads(Math.min(numberOfShards, maxConcurrentFetches));
            applyClusterState(
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING;  
import org.opensearch.cluster.routing.ShardRoutingState;
        final RerouteService rerouteService = (reason, priority, listener) -> {
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
        assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(0));  
            DiscoveryNodeRole.BUILT_IN_ROLES,
                } finally {
            );
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
        );
        final SnapshotShardSizeInfo snapshotShardSizeInfo = snapshotsInfoService.snapshotShardSizes();  
                    assertThat(shardId.id(), allOf(greaterThanOrEqualTo(0), lessThan(numberOfShards)));
                    }
import org.opensearch.cluster.routing.RerouteService;
            Settings.builder().put(INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING.getKey(), randomIntBetween(1, 10)).build(),
import static org.hamcrest.Matchers.allOf;  
                    indexId,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;
            );  
 * specific language governing permissions and limitations
            .nodes(DiscoveryNodes.builder(currentState.nodes()).add(node).clusterManagerNodeId(node.getId()))
import org.opensearch.cluster.service.ClusterApplier;
                    return IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0L, randomNonNegativeLong(), null);  
            .build();
        assert terminated;
        final Index index = indexMetadata.getIndex();  
        PlainActionFuture.get(
                final int numberOfShards = randomIntBetween(1, remainingShards);  
        for (int i = 0; i < randomIntBetween(1, 10); i++) {
                .primaryShard();  
                    @Override
        assertThat(snapshotsInfoService.numberOfKnownSnapshotShardSizes(), equalTo(0));
        }
        if (randomBoolean()) {  
            .routingTable(routingTable.build())
        applyClusterState("add-unassigned-shards", clusterState -> addUnassignedShards(clusterState, indexName, numberOfShards));  
        assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(numberOfShards));
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards = new HashMap<>();
import org.opensearch.test.OpenSearchTestCase;
                    final long shardSize = randomNonNegativeLong();
                try {
import org.opensearch.repositories.RepositoriesService;
        when(repositoriesService.repository("_repo")).thenReturn(mockRepository);  
                "restore-indices-when-cluster-manager-" + indexName,  
        super.setUp();
        );
        if (randomBoolean()) {
import static org.hamcrest.Matchers.equalTo;
            final int nbShards = randomIntBetween(1, 5);
        assertThat(snapshotsInfoService.numberOfFailedSnapshotShardSizes(), equalTo(0));  
        threadPool = new TestThreadPool(getTestName());  
            () -> rerouteService
                    results.put(snapshotShard, shardSize);  
                    .build(),
            assertThat(snapshotShardSizeInfo.getShardSize(shardRouting), equalTo(expectedShardSizes[i]));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        };
            Version.CURRENT,
        assertThat("Expecting all snapshot shard size fetches to provide a size", results.size(), equalTo(maxShardsToCreate));  
                if (randomBoolean()) {  
                } catch (InterruptedException e) {
    }
import org.opensearch.cluster.RestoreInProgress;
            assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(0));  
        final Metadata.Builder metadata = Metadata.builder(currentState.metadata())  
    private void waitForMaxActiveGenericThreads(final int nbActive) throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(
import org.opensearch.cluster.routing.AllocationId;
    }  
                recoverySource.restoreUUID(),  
    private ClusterService clusterService;
import org.opensearch.common.UUIDs;  
        final CountDownLatch rerouteLatch = new CountDownLatch(numberOfShards);
            expectedShardSizes[i] = randomNonNegativeLong();  
import java.util.function.Predicate;  
        }
            );
        });  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        final RerouteService rerouteService = (reason, priority, listener) -> {
    @Override  
        restores.add(
                }
        }
                        "add-more-unassigned-shards-for-" + indexName,  
                final InternalSnapshotsInfoService.SnapshotShard snapshotShard = new InternalSnapshotsInfoService.SnapshotShard(
import org.opensearch.repositories.Repository;
            @Override  
            listener.onResponse(clusterService.state());  
        final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(  
        );  
                    return IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0L, expectedShardSizes[shardId.id()], null);
            .putCustom(RestoreInProgress.TYPE, restores.build())  
    }
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.threadpool.ThreadPoolStats;
        );
                snapshotsInfoService.numberOfKnownSnapshotShardSizes(),
        return ClusterState.builder(currentState)
        assertBusy(
 * under the License.  
import java.util.HashSet;
                }
 *  
                Settings.builder()
import org.opensearch.cluster.routing.ShardRouting;
            public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
            for (ThreadPoolStats.Stats threadPoolStat : threadPoolStats) {
            new RestoreInProgress.Entry(
    public void testCleanUpSnapshotShardSizes() throws Exception {
        );
                final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
                if (randomBoolean()) {
                );  
 * The OpenSearch Contributors require contributions made to  
            OpenSearchTestCase.buildNewFakeTransportAddress(),  
        );  
        for (int i = 0; i < numberOfShards; i++) {
            .settings(  
        assertBusy(() -> {
        rerouteService = (reason, priority, listener) -> listener.onResponse(clusterService.state());  
import org.opensearch.cluster.metadata.IndexMetadata;  
            clusterService,
            indexMetadataBuilder.putInSyncAllocationIds(i, Collections.singleton(AllocationId.newInitializing().getId()));  
            assertThat(generic, notNullValue());  
                    results.put(snapshotShard, Long.MIN_VALUE);
                equalTo(nbShards)
 * SPDX-License-Identifier: Apache-2.0
    private ClusterState demoteClusterManagerNode(final ClusterState currentState) {  
        assertBusy(() -> {
                        clusterState -> addUnassignedShards(clusterState, indexName, numberOfShards)
import org.opensearch.cluster.routing.RoutingTable;  
        for (int i = 0; i < randomIntBetween(1, 10); i++) {
                "reapply-last-cluster-state-to-check-deduplication-works",
            () -> repositoriesService,  
                    return IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0L, shardSize, null);
            UUIDs.randomBase64UUID(random()),
    }
                equalTo((int) results.values().stream().filter(size -> failedSnapshotShardSizeRetrieval.test(size) == false).count())
            () -> repositoriesService,  
            .put(indexMetadataBuilder.build(), true)
import java.util.function.Function;
                clusterState -> addUnassignedShards(clusterState, indexName, nbShards)
            shards.put(new ShardId(index, i), new RestoreInProgress.ShardRestoreStatus(clusterService.state().nodes().getLocalNodeId()));
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
        final int nbShards = randomIntBetween(1, 10);
            future -> clusterService.getClusterApplierService()  
import java.util.Locale;
    private RepositoriesService repositoriesService;
            }
            final int nbShards = randomIntBetween(1, 5);  
                    new Snapshot("_repo", snapshotId),  
                    getShardSnapshotStatusCount.incrementAndGet();  
    public void testNoLongerClusterManager() throws Exception {
        routingTable.add(IndexRoutingTable.builder(index).initializeAsNewRestore(indexMetadata, recoverySource, new HashSet<>()).build());  
            public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
            public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
                snapshotShardSizeInfo.getShardSize(shardRouting),
    public void tearDown() throws Exception {
            reroutes.incrementAndGet();
            )
                }
        final Repository mockRepository = new FilterRepository(mock(Repository.class)) {  
            final ShardRouting shardRouting = clusterService.state().routingTable().index(indexName).shard(i).primaryShard();
import static org.hamcrest.Matchers.nullValue;  
    }
                snapshotShardSizeInfo.getShardSize(shardRouting, defaultValue),
            public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
        final AtomicInteger getShardSnapshotStatusCount = new AtomicInteger(0);  
            assertThat(rerouteLatch.getCount(), greaterThanOrEqualTo(0L));
            assertFalse(clusterService.state().metadata().hasIndex(indexName));
            final ShardRouting shardRouting = clusterService.state()
                clusterState -> OpenSearchAllocationTestCase.startInitializingShardsAndReroute(allocationService, clusterState, indexName)
                }
            @Override  
                    throw new AssertionError(e);
            .build();  
                success ? equalTo(results.get(snapshotShard.getKey())) : equalTo(defaultValue)
        addSnapshotRestoreIndicesThread.join();
        applyClusterState("demote-current-cluster-manager", this::demoteClusterManagerNode);
            .generateClusterUuidIfNeeded();
            @Override
            () -> rerouteService  
                }
                    throw new SnapshotException(snapshotShard.snapshot(), "simulated");  
    @Override
        for (int i = 0; i < expectedShardSizes.length; i++) {
        return ClusterState.builder(currentState)
        return ClusterState.builder(currentState)
    }
                Collections.singletonList(indexName),  
            );  
                if (ThreadPool.Names.GENERIC.equals(threadPoolStat.getName())) {
public class InternalSnapshotsInfoServiceTests extends OpenSearchTestCase {
                recoverySource.snapshot(),
            Settings.EMPTY,
            final long defaultValue = randomNonNegativeLong();
import java.util.Collections;
        for (int i = 0; i < numberOfShards; i++) {
            () -> rerouteService  
import java.util.Map;  
        }
        final CountDownLatch latch = new CountDownLatch(1);
        } else {
        clusterService.close();  
            final AllocationService allocationService = OpenSearchAllocationTestCase.createAllocationService(
        final AtomicInteger reroutes = new AtomicInteger();  
        final IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
import org.junit.Before;  
            .routingTable(RoutingTable.builder(currentState.routingTable()).remove(indexName).build())  
        // waiting for snapshot shard size fetches to be executed, as we want to verify that they are cleaned up  
                    public void onFailure(String source, Exception e) {
            final ShardId shardId = snapshotShard.getKey().shardId();
import org.opensearch.cluster.routing.allocation.AllocationService;  
                    throw new AssertionError(e);  
        assertThat(snapshotsInfoService.numberOfFailedSnapshotShardSizes(), equalTo(0));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
        };
        final DiscoveryNode node = new DiscoveryNode(
                    .put(SETTING_NUMBER_OF_REPLICAS, 0)
        final RestoreInProgress.Builder restores = new RestoreInProgress.Builder(
        final long[] expectedShardSizes = new long[numberOfShards];
                try {
            applyClusterState(
            applyClusterState(
    private RerouteService rerouteService;  
                    .put(SETTING_CREATION_DATE, System.currentTimeMillis())
                } else {
        when(repositoriesService.repository("_repo")).thenReturn(mockRepository);
 * compatible open source license.
import org.opensearch.core.index.shard.ShardId;  
            @Override
        final int numberOfShards = randomIntBetween(1, 50);  
            assertThat(
/*  
        assertTrue(rerouteLatch.await(30L, TimeUnit.SECONDS));  
import org.opensearch.repositories.FilterRepository;
 */
        final SnapshotShardSizeInfo snapshotShardSizeInfo = snapshotsInfoService.snapshotShardSizes();
            );
import org.opensearch.repositories.IndexId;  
        final Thread addSnapshotRestoreIndicesThread = new Thread(() -> {
import static org.hamcrest.Matchers.notNullValue;
        final IndexMetadata indexMetadata = metadata.get(indexName);
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.CountDownLatch;
                .index(shardId.getIndexName())
                "starting shards for " + indexName,  
    @Before
        }  
 * this work for additional information regarding copyright
import java.util.concurrent.TimeUnit;  
                    assertThat(indexId.getName(), equalTo(indexName));  
        assertThat(currentState.nodes().get(node.getId()), nullValue());
        final boolean terminated = terminate(threadPool);
    @After  
            assertThat(snapshotsInfoService.numberOfFailedSnapshotShardSizes(), equalTo(0));
        final Repository mockRepository = new FilterRepository(mock(Repository.class)) {
            "other",
        when(repositoriesService.repository("_repo")).thenReturn(mockRepository);
 * GitHub history for details.
import org.opensearch.cluster.node.DiscoveryNode;
import static org.mockito.Mockito.when;
        assertThat(snapshotsInfoService.numberOfKnownSnapshotShardSizes(), equalTo(numberOfShards));
        final int maxConcurrentFetches = randomIntBetween(1, 10);
        for (int i = 0; i < indexMetadata.getNumberOfShards(); i++) {  
import org.opensearch.cluster.routing.IndexRoutingTable;  
        }, 30L, TimeUnit.SECONDS);
            clusterService,
            assertThat(  
            final boolean success = failedSnapshotShardSizeRetrieval.test(snapshotShard.getValue()) == false;  
        assertBusy(() -> {
            assertThat(snapshotsInfoService.numberOfUnknownSnapshotShardSizes(), equalTo(0));
            new IndexId(indexName, UUIDs.randomBase64UUID(random()))
    public void setUp() throws Exception {
        );
        });
        }
        );
    }
        assertThat("Expecting all snapshot shard size fetches to execute a Reroute", reroutes.get(), equalTo(maxShardsToCreate));
            Settings.builder().put(INTERNAL_SNAPSHOT_INFO_MAX_CONCURRENT_FETCHES_SETTING.getKey(), maxConcurrentFetches).build(),  
            final ThreadPoolStats threadPoolStats = clusterService.getClusterApplierService().threadPool().stats();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            currentState.custom(RestoreInProgress.TYPE, RestoreInProgress.EMPTY)  
 */  
import org.opensearch.threadpool.TestThreadPool;
            applyClusterState(
        );
            assertThat(generic.getActive(), equalTo(nbActive));
                    .put(SETTING_VERSION_CREATED, Version.CURRENT)
 *
            while (remainingShards > 0) {
            );
                clusterState -> addUnassignedShards(clusterState, indexName, nbShards)  
                    latch.await();
import org.opensearch.cluster.node.DiscoveryNodes;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(
import org.opensearch.cluster.service.ClusterService;
import org.junit.After;
            );  
            Settings.EMPTY,  
            assertThat(snapshotShardSizeInfo.getShardSize(shardRouting, Long.MIN_VALUE), equalTo(expectedShardSizes[i]));
        };
            () -> rerouteService
import org.opensearch.core.index.Index;
 * Unless required by applicable law or agreed to in writing,
    private void applyClusterState(final String reason, final Function<ClusterState, ClusterState> applier) {
                } else {
}  
                        future.onResponse(source);
            () -> assertThat(
            );
 * license agreements. See the NOTICE file distributed with
                    throw new SnapshotException(new Snapshot("_repo", snapshotId), "simulated");
            "new snapshot restore for index " + indexName,
        assertThat(currentState.metadata().hasIndex(indexName), is(false));  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            () -> repositoriesService,
        }  
            );
                } catch (Exception e) {  
            new Snapshot("_repo", new SnapshotId(randomAlphaOfLength(5), UUIDs.randomBase64UUID(random()))),  
                RestoreInProgress.State.INIT,
                "restore-indices-when-no-longer-cluster-manager-" + indexName,
        super.tearDown();  
 * not use this file except in compliance with the License.
        latch.countDown();
            }
    }  
import org.opensearch.Version;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        final RoutingTable.Builder routingTable = RoutingTable.builder(currentState.routingTable());
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        }
        final int maxShardsToCreate = scaledRandomIntBetween(10, 500);
                .shard(shardId.id())
                success ? equalTo(results.get(snapshotShard.getKey())) : equalTo(ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE)  
import org.opensearch.test.ClusterServiceUtils;  
            clusterService,
        final Map<InternalSnapshotsInfoService.SnapshotShard, Long> results = new ConcurrentHashMap<>();
import org.opensearch.threadpool.ThreadPool;  
 * Licensed to Elasticsearch under one or more contributor  
        };  
            .metadata(Metadata.builder(currentState.metadata()).remove(indexName))
import static org.hamcrest.Matchers.is;  
        final Repository mockRepository = new FilterRepository(mock(Repository.class)) {  
            listener.onResponse(clusterService.state());  
            assertThat(  
            rerouteLatch.countDown();
            clusterState -> addUnassignedShards(clusterState, indexName, nbShards)  
            }
package org.opensearch.snapshots;
        final RecoverySource.SnapshotRecoverySource recoverySource = new RecoverySource.SnapshotRecoverySource(
            }
 *
        assertThat(getShardSnapshotStatusCount.get(), equalTo(numberOfShards));
    private ClusterState addUnassignedShards(final ClusterState currentState, String indexName, int numberOfShards) {
                equalTo((int) results.values().stream().filter(failedSnapshotShardSizeRetrieval).count())  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
                    applyClusterState(
        applyClusterState(
            applyClusterState("delete index " + indexName, clusterState -> deleteIndex(clusterState, indexName));
            );
                    public void onSuccess(String source) {  
        };  
                .routingTable()  
/*
/*  
        });  
    }  
 * this file be licensed under the Apache-2.0 license or a
                    }
import java.util.concurrent.atomic.AtomicInteger;
                    @Override
        final InternalSnapshotsInfoService snapshotsInfoService = new InternalSnapshotsInfoService(  
            .metadata(metadata)
            () -> repositoriesService,
        );  
