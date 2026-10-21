        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
        }
            )
            primary,
        );
        );
        final long primaryTerm = indexMetadata.primaryTerm(0);
        assertEquals(1 + initializingIds.size(), shardInfo.getTotal());
            TimeValue.timeValueMillis(20),
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
            true,
        ShardRouting searchShardRouting = TestShardRouting.newShardRouting(
        @Override
        }
            Primary<Request, Request, TestPrimary.Result> primary,
            builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(shardRouting.currentNodeId()));
                replicasProxy,
            replicasProxy,
            primaryId
            replicasProxy,
                String message,
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
        final TestReplicationOperation op = new TestReplicationOperation(
        }
        );
        Request request = new Request(shardId);
            @Override
        ShardId shardId = new ShardId("test", "_na_", 0);
                "test",
            null,
            }
                buildDiscoveryNodes(routingTable),
            replicasProxy,
                true
            }
            replicasProxy,
        AllocationId primaryId = activeIds.iterator().next();
        Set<AllocationId> initializingIds = new HashSet<>();
            public void setShardInfo(ShardInfo shardInfo) {
            Logger logger,
        Request request = new Request(shardId);
            if (retryable == false) {
                logger,
        for (ShardRouting shardRouting : routingTable) {
            shardActionFailure = new SendRequestTransportException(
        final AtomicReference<ReplicationGroup> replicationGroup = new AtomicReference<>(initialReplicationGroup);
        assertFalse(replicationGroup.getReplicationTargets().stream().anyMatch(ShardRouting::isSearchOnly));
        assertThat(shardInfo.getFailures(), arrayWithSize(0));
                this.shardInfo = shardInfo;
        assertTrue("listener is not marked as done", listener.isDone());
        assertThat(shardInfo.getFailed(), equalTo(reportedFailures.size()));
        final ShardRouting primaryShard = newShardRouting(
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)
        op.execute();
        AllocationId primaryId = activeIds.iterator().next();
                );
        );
        final String index = "test";
import org.opensearch.common.util.set.Sets;
        final long primaryTerm = indexMetadata.primaryTerm(0);
        final TestPrimary primary = new TestPrimary(primaryShard, replicationGroup::get, threadPool) {
            }
            );
        // listener, so it must trip the retry path regardless of which proxy delivered the failure.
import org.opensearch.core.common.breaker.CircuitBreakingException;
        assertThat("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get(), equalTo(true));
                request,
            listener.get();
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
            return replicationGroupSupplier.get();
                }
            Primary<Request, Request, TestPrimary.Result> primary,
        final ReplicationGroup initialReplicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);
        public void updateGlobalCheckpointForShard(String allocationId, long globalCheckpoint) {
            new ReplicationModeAwareProxy<>(
        };
            }
        op.execute();
        assertTrue("listener is not marked as done", listener.isDone());
            Replicas<Request> replicas,
            } else {
        return builder.build();
                retryTimeout,
                request,
                .build();
            .filter(aId -> !aId.equals(primaryId))
                    builder.add(IndexShardTestUtils.getFakeDiscoNode(shardRouting.currentNodeId()));
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));
                if (shardRouting.relocating() && localNodeId.equals(shardRouting.relocatingNodeId()) == false) {
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
        for (ShardRouting replica : expectedReplicas) {
            listener,
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
            trackedShards,
        // are in docrep nodes whereas others are on remote enabled ones
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());
        assertThat(request.processedOnReplicas, equalTo(expectedReplicas));
        ) {
        }
        );
                    continue;
        }
        }
    }
        return expectedReplicas;
        assertTrue("listener is not marked as done", listener.isDone());
            primary,
            Replicas<Request> replicas,
                ShardRouting replica,
                fail("processed [" + request + "] twice");
                primary,
        indexMetadataBuilder.settings(Settings.builder().put(indexMetadata.getSettings()).put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1));
    }
                retryTimeout,
            long primaryTerm,
        final Set<String> staleAllocationIds = Sets.newHashSet(randomAlphaOfLength(10));
        final long maxSeqNoOfUpdatesOrDeletes;
        TestReplicationOperation(
        } else {
            primary,
import org.opensearch.cluster.ClusterState;
        final Set<String> trackedShards = new HashSet<>();
        );
            // If replication is not retryable OR this is the first attempt, the post replication actions
        }
import org.opensearch.common.collect.Tuple;
                    super.updateLocalCheckpointForShard(allocationId, checkpoint);
            request,
                }
        return new Tuple<>(docrepNodes, builder.build());
            @Override
import org.opensearch.cluster.routing.AllocationId;
            primary,
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)
        final IndexMetadata indexMetadata = state.getMetadata().index(index);
                    trackedShards.add(shr.allocationId().getId());
            TimeValue initialRetryBackoffBound,
            return globalCheckpoint;
import org.opensearch.cluster.routing.TestShardRouting;
    public void testAddedReplicaAfterPrimaryOperation() throws Exception {
        public void failShard(String message, Exception exception) {
        );
                            trackedShards.add(shr.getTargetRelocatingShard().allocationId().getId());
        public long computedGlobalCheckpoint() {
import org.opensearch.index.shard.IndexShardState;
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();
            knownLocalCheckpoints.put(allocationId, checkpoint);
            Collections.emptyMap(),
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        final Set<String> inSyncAllocationIds = state.metadata().index(index).inSyncAllocationIds(0);
                buildRemoteStoreEnabledDiscoveryNodes(routingTable),
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
import java.util.concurrent.atomic.AtomicReference;
            this.globalCheckpoint = randomNonNegativeLong();
            replicasProxy,
        assertThat(primary.knownGlobalCheckpoints.remove(primaryShard.allocationId().getId()), equalTo(primary.globalCheckpoint));
    static class ReplicaResponse implements ReplicationOperation.ReplicaResponse {
        AllocationId primaryId = activeIds.iterator().next();
                    logger.debug("--> state after primary operation:\n{}", replicationGroup.get());
        ) {
                .nodes(DiscoveryNodes.builder(initialState.nodes()).localNodeId(primaryShard.relocatingNodeId()))
        assertEquals(1 + docRepNodes + initializingIds.size(), shardInfo.getTotal());
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
            ShardRoutingState.STARTED,
        assertThat("test requires two replicas", expectedReplicas, hasSize(2));
            }
                if (shr.initializing()) {
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
import org.opensearch.common.settings.Settings;
                String message,
        IndexShardRoutingTable routingTable = builder.build();
import org.opensearch.threadpool.TestThreadPool;
            op.execute();
            "failShardIfNeeded must not be invoked for PrimaryShardClosedException; the op should fail earlier",
    public void testPrimaryFailureHandlingReplicaResponse() throws Exception {
        final AtomicBoolean primaryFailed = new AtomicBoolean();
import org.opensearch.core.common.breaker.CircuitBreaker;
        state.metadata(Metadata.builder().put(indexMetadataBuilder.build(), false));
        addTrackingInfo(indexShardRoutingTable, primaryShard, trackedShards, untrackedShards);
                replicasProxy,
        builder.addShard(primaryShard);
            listener,
        final Map<String, Long> generatedLocalCheckpoints = ConcurrentCollections.newConcurrentMap();
                ReplicationOperationTests.this.logger,
import org.opensearch.threadpool.ThreadPool;
 * this work for additional information regarding copyright
        final Set<String> markedAsStaleCopies = ConcurrentCollections.newConcurrentSet();
        TestReplicationOperation(
        final ClusterState initialState = state(
        public AtomicBoolean runPostReplicationActionsOnPrimary = new AtomicBoolean();
                node,
        ShardId shardId = new ShardId("test", "_na_", 0);
            }
            RoutingTable.builder().add(IndexRoutingTable.builder(indexMetadata.getIndex()).addIndexShard(indexShardRoutingTable)).build()
            ShardRouting routing = newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId);
        logger.debug("--> using initial replicationGroup:\n{}", replicationGroup.get());
        initializingIds.forEach(aId -> {
        for (ShardRouting shr : indexShardRoutingTable.shards()) {
 * compatible open source license.
            0
    }
                threadPool,
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
import org.opensearch.transport.ConnectTransportException;
        }
                    super.failShardIfNeeded(replica, primaryTerm, message, exception, shardActionListener);
        final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(0);
            primaryShard = primaryShard.getTargetRelocatingShard();
        final boolean passesActiveShardCheck = activeShardCount <= assignedReplicas + 1;
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
                if (primaryRouting.allocationId().getId().equals(allocationId)) {
        );
            public void markShardCopyAsStaleIfNeeded(
        if (expectedReplicas.isEmpty()) {
        assertEquals(initializingIds.size() + activeIds.size(), shardInfo.getTotal());
        final ShardId shardId = new ShardId(index, "_na_", 0);
        final Set<String> untrackedShards = new HashSet<>();
        ClusterState initialState = stateWithActivePrimary(index, true, 1 + randomInt(2), randomInt(2));
        Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, stateWithAddedReplicas, trackedShards);
    static class TestReplicaProxy implements ReplicationOperation.Replicas<Request> {
            replicasProxy,
        assertThat("request was not processed on primary", request.processedOnPrimary.get(), equalTo(true));
            if (randomBoolean()) {
                replicasProxy,
        assertThat("request was not processed on primary", request.processedOnPrimary.get(), equalTo(true));
        public void perform(Request request, ActionListener<Result> listener) {
            }
            Exception exception,
        initializingIds.forEach(
            } else {
            private final Request request;
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
        };
            final long maxSeqNoOfUpdatesOrDeletes,
    private ThreadPool threadPool;
            listener,
            public void runPostReplicationActions(ActionListener<Void> listener) {
            if (randomBoolean()) {
        Request request = new Request(shardId);
    public void testReplicationInDualModeWithMixedReplicasSomeInDocrepOthersOnRemote() throws Exception {
                assertFalse(
            return localCheckpoint;
        state.routingTable(
            ReplicationProxy<Request> replicationProxy
            listener,
        );
    }
        final int unassignedReplicas = randomInt(2);
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);
            builder.addShard(routing);
                    "primary post replication actions should run after replication",
                        expectedReplicas.add(shardRouting.getTargetRelocatingShard());
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
import java.util.concurrent.atomic.AtomicBoolean;
            false,
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
        private final AtomicInteger attemptsNumber = new AtomicInteger(0);
            assertThat(ex.getCause(), instanceOf(klass));
                    if (trackedShards.contains(shardRouting.getTargetRelocatingShard().allocationId().getId())) {
import org.opensearch.node.NodeClosedException;
        });
            if (shardRouting.primary()) {
                        if (primaryShard == shr.getTargetRelocatingShard() || randomBoolean()) {
            }
            if (opFailures.containsKey(replica) && n <= attemptsBeforeSuccess) {
        if (primaryShard.relocating() && randomBoolean()) {
        private final int attemptsBeforeSuccess;
            ShardRoutingState.STARTED,
            this.pendingReplicationActions = new PendingReplicationActions(routing.shardId(), threadPool);
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
        final ShardId shardId = new ShardId(index, "_na_", 0);
package org.opensearch.action.support.replication;
            TimeValue initialRetryBackoffBound,
    }
        );
    }
            builder.addShard(routing);
import java.net.InetAddress;
            primaryTerm,
        final ClusterState state = state(index, true, ShardRoutingState.STARTED, replicaStates);
            ReplicationProxy<Request> replicationProxy
        assertThat(request.processedOnReplicas, equalTo(expectedReplicas));
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(indexShardRoutingTable);
                assertNull(generatedLocalCheckpoints.put(allocationId, generatedLocalCheckpoint));
import org.opensearch.index.shard.ReplicationGroup;
                request,
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));
            this.routing = routing;
        }
            final long primaryTerm,
                        untrackedShards.add(shr.allocationId().getId());
            primary,
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
import java.util.stream.IntStream;
            }
                threadPool,
        initializingIds.forEach(aId -> {
        ReplicationGroup updatedReplicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);
import java.util.function.BiFunction;
            request,
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
            ShardRoutingState.STARTED,
    }
            if (opFailures.containsKey(replica)) {
                } else {
        final ShardId shardId = new ShardId(index, "_na_", 0);
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
        ShardRoutingState[] replicaStates = new ShardRoutingState[assignedReplicas + unassignedReplicas];
            }
            threadPool,
                this.request = request;
            public void failShardIfNeeded(
        Set<AllocationId> activeIds = new HashSet<>();
            }
/*
        assertThat(shardInfo.getFailed(), equalTo(0));
        ) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(0, replicasProxy.failedReplicas.size());
            op.execute();
        op.execute();
        );
            primaryTerm,
        final long primaryTerm = indexMetadata.primaryTerm(0);
                        } else {
        final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(0);
                initialRetryBackoffBound,
                true
        final List<ShardRouting> unassignedShards = indexShardRoutingTable.shardsWithState(ShardRoutingState.UNASSIGNED);
        final Map<ShardRouting, Exception> opFailures;
                DiscoveryNode node = new DiscoveryNode("replica", address, Version.CURRENT);
        op.execute();
            new TestReplicaProxy(),
    }
import java.util.List;
            shardId,
    }
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));
                opType,
        Request(ShardId shardId) {
                listener,
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
                listener,
    private void runPrimaryClosedDuringReplicationTest(
        builder.addShard(primaryShard);
    class TestReplicationOperation extends ReplicationOperation<Request, Request, TestPrimary.Result> {
        final boolean fatal = randomBoolean();
        });
        assertThat(replicasProxy.markedAsStaleCopies, equalTo(staleAllocationIds));
        assertThat(primary.knownGlobalCheckpoints.remove(primaryShard.allocationId().getId()), equalTo(primary.globalCheckpoint));
            Request request,
 * not use this file except in compliance with the License.
                ReplicationMode.PRIMARY_TERM_VALIDATION,
        activeIds.stream().filter(aId -> !aId.equals(primaryId)).forEach(aId -> {
        // Deterministic setup: one primary and two started replicas, all tracked. Two replicas so that the non-closed
        // replica exercises the successful path alongside the closed one.
            TimeValue.timeValueSeconds(60),
        }
        Set<AllocationId> initializingIds = new HashSet<>();
                // since the test cases creates replication group with active allocationIds only
                ReplicationMode.NO_REPLICATION,
        if (primaryShard.relocating() && randomBoolean()) {
    }
    }
    }
            if (retryable) {
        @Override
        final TestReplicationOperation op = new TestReplicationOperation(
            0,
        assertThat(replicasProxy.failedReplicas, equalTo(simulatedFailures.keySet()));
        final ReplicationOperation.Replicas<Request> replicas = new TestReplicaProxy(Collections.emptyMap());
        );
        Request request = new Request(shardId);
                ReplicationMode.NO_REPLICATION,
            primaryTerm,
            () -> initialReplicationGroup,
        final ReplicationGroup replicationGroup = new ReplicationGroup(indexShardRoutingTable, inSyncAllocationIds, trackedShards, 0);
import org.apache.logging.log4j.Logger;
        Set<String> trackedShards = new HashSet<>();
            new ReplicationModeAwareProxy<>(ReplicationMode.NO_REPLICATION, discoveryNodesDetails.v2(), replicasProxy, replicasProxy, false)
            return globalCheckpoint;
            "nodeForSearchShard",
            );
                }
                final long generatedGlobalCheckpoint = random().nextLong();
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
        public long maxSeqNoOfUpdatesOrDeletes() {
import org.apache.lucene.store.AlreadyClosedException;
        for (int i = assignedReplicas; i < replicaStates.length; i++) {
        );
            request,
                TimeValue.timeValueSeconds(1),
            // simulate execution of the replication phase on the relocation target node after relocation source was marked as relocated
        ClusterState initialState = stateWithActivePrimary(index, true, randomInt(5));
        } else {
        }
    }
                primary,
import java.util.stream.Collectors;
            public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {
            new FanoutReplicationProxy<>(replicasProxy)
    public void testWaitForActiveShards() throws Exception {
        }
        DiscoveryNode node = new DiscoveryNode(
        TestReplicaProxy(Map<ShardRouting, Exception> opFailures) {
import org.opensearch.cluster.routing.IndexRoutingTable;
            )
        final TestReplicationOperation op = new TestReplicationOperation(
        addTrackingInfo(shardRoutingTable, null, trackedShards, new HashSet<>());
 * SPDX-License-Identifier: Apache-2.0
        );
        public long globalCheckpoint() {
        final TestReplicationOperation op = new TestReplicationOperation(
        assertEquals(activeIds.size() - 1, request.processedOnReplicas.size());
            } else {
            }
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
            primaryId
            listener,
                ActionListener<Void> shardActionListener
            request,
        assertTrue(listener.isDone());
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
        assertThat(replicationGroup.toString(), shardInfo.getTotal(), equalTo(totalShards));
            Result(Request request) {
            shardId,
    public void testPrimaryClosedDuringPrimaryTermValidationTriggersRetry() throws Exception {
            listener,
        // PendingReplicationActions.close() does to in-flight replica requests when IndexShard closes.
        terminate(threadPool);
            nodeIdFromAllocationId(primaryId),
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
        ReplicationGroup initialReplicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);
            new FanoutReplicationProxy<>(replicasProxy)
            proxyFactory.apply(replicasProxy, indexShardRoutingTable)
            stateWithAddedReplicas = state(
        assertThat(shardInfo.getSuccessful(), equalTo(1 + expectedReplicas.size() - simulatedFailures.size()));
        final TestReplicationOperation op = new TestReplicationOperation(
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());
        // add a few in-sync allocation ids that don't have corresponding routing entries
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
            }
                Exception exception,
import static org.hamcrest.Matchers.arrayWithSize;
            logger,
            listener,
        public ShardRouting routingEntry() {
        }
        op.execute();
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(primary.knownLocalCheckpoints, equalTo(replicasProxy.generatedLocalCheckpoints));
        trackedShards.addAll(staleAllocationIds);
            request,
            request,
            new FanoutReplicationProxy<>(replicas)
                    if (randomBoolean()) {
        }
 *
            @Override
        final List<ShardRouting> unassignedShards = indexShardRoutingTable.shardsWithState(ShardRoutingState.UNASSIGNED);
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
        assertEquals(1, request.processedOnReplicas.size());
            this.maxSeqNoOfUpdatesOrDeletes = randomNonNegativeLong();
import static org.opensearch.action.support.replication.ReplicationOperation.RetryOnPrimaryException;
            nodeIdFromAllocationId(primaryId),
        activeIds.stream()
        indexShardRoutingTable = indexShardRoutingBuilder.build();
        assertTrue(
                exception = new RemoteTransportException("remote", cause);
        assertEquals(replicasProxy.failedReplicas, Collections.emptySet());
        final String index = "test";
import java.util.concurrent.atomic.AtomicInteger;
                if (testPrimaryDemotedOnStaleShardCopies) {
            primary,
        IndexShardRoutingTable shardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
            trackedShards.add(shr.allocationId().getId());
            this.waitForActiveShards = ActiveShardCount.NONE;
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)
                long primaryTerm,
            } else {
        Set<ShardRouting> initial = getExpectedReplicas(shardId, initialState, trackedShards);
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
import java.util.HashMap;
 * GitHub history for details.
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
            new ReplicationModeAwareProxy<>(
        assertEquals(request.processedOnReplicas, expectedReplicas);
            ShardRouting replica,
            Version.CURRENT
            );
    public void testPrimaryClosedDuringFullReplicationTriggersRetry() throws Exception {
                listener.onResponse(new ReplicaResponse(generatedLocalCheckpoint, generatedGlobalCheckpoint));
        IndexShardRoutingTable routingTable = builder.build();
            this(Collections.emptyMap());
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)
 * Unless required by applicable law or agreed to in writing,
            // simulate execution of the replication phase on the relocation target node after relocation source was marked as relocated
        state.nodes(DiscoveryNodes.builder(initialState.nodes()).add(node).build());
            // If this is a retryable scenario and this is the second try, we finish successfully
        static class Result implements ReplicationOperation.PrimaryResult<Request> {
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
            OpenSearchTestCase.buildNewFakeTransportAddress(),
                ShardStateAction.SHARD_FAILED_ACTION_NAME,
            return globalCheckpoint;
        for (ShardRouting replica : expectedReplicas) {
            aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId))
        final String index = "test";
                primaryFailed.set(true);
            super(shardId);
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
            this(
                }
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));
        final Map<String, Long> knownGlobalCheckpoints = Collections.synchronizedMap(new HashMap<>());
        );
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
        final Set<String> untrackedShards = new HashSet<>();
 * under the License.
                }
        if (state.routingTable().hasIndex(shardId.getIndexName())) {
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
        final ClusterState stateWithAddedReplicas;
                cause = new ConnectTransportException(node, "broken");
            null
            .forEach(
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
        );
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures, true);
        activeIds.stream().filter(aId -> !aId.equals(primaryId)).forEach(aId -> {
        ClusterState initialState = stateWithActivePrimary(index, true, randomInt(5));
    public void tearDown() throws Exception {
            true,
import java.util.Collections;
            ) {
        assertThat("request was not processed on primary", request.processedOnPrimary.get(), equalTo(true));
            );
        } else if (randomBoolean()) {
        final TestReplicationOperation op = new TestReplicationOperation(
import org.opensearch.core.common.transport.TransportAddress;
        final ReplicationGroup initialReplicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);
                String allocationId,
            primary,
        );
        @Override
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);
            primaryTerm,
        final int totalShards = 1 + expectedReplicas.size() + unassignedShards.size() + untrackedShards.size();
        }
import org.opensearch.core.index.shard.ShardId;
                primaryTerm,
        );
        for (ShardRouting shardRouting : routingTable) {
import org.opensearch.action.support.PlainActionFuture;
        final boolean testPrimaryDemotedOnStaleShardCopies = randomBoolean();
                final long generatedLocalCheckpoint = random().nextLong();
        AllocationId primaryId = activeIds.iterator().next();
                } else {
    }
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
        @Override
        assertEquals(docRepNodes, request.processedOnReplicas.size());
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());
        final Exception shardActionFailure;
        ) {
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());
 * this file be licensed under the Apache-2.0 license or a
        final PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
            listener,
            new ReplicationModeAwareProxy<>(
    <T> void assertListenerThrows(String msg, PlainActionFuture<T> listener, Class<?> klass) throws InterruptedException {
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
            String opType,
            replicaStates[i] = randomFrom(ShardRoutingState.STARTED, ShardRoutingState.RELOCATING);
        }
                randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.STARTED
                assertTrue("replica request processed twice on [" + replica + "]", added);
                    }
        final Set<String> staleAllocationIds = Sets.newHashSet(generateRandomStringArray(4, 10, false));
        logger.debug(
        final TestReplicationOperation op = new TestReplicationOperation(
            new FanoutReplicationProxy<>(new TestReplicaProxy())
/*
        Set<String> inSyncAllocationIds = initialState.metadata().index(index).inSyncAllocationIds(0);
        @Override
import org.opensearch.index.shard.PrimaryShardClosedException;
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));
        public AtomicBoolean processedOnPrimary = new AtomicBoolean();
            null,
            "using active shard count of [{}], assigned shards [{}], total shards [{}]." + " expecting op to [{}]. using state: \n{}",
        final ReplicationGroup replicationGroup = new ReplicationGroup(indexShardRoutingTable, inSyncAllocationIds, trackedShards, 0);
                ShardRoutingState.STARTED,
        @Override
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
                primaryTerm,
                replicationProxy
        }
            Replicas<Request> replicas,
        }
 * ownership. Elasticsearch licenses this file to you under
        int docrepNodes = 0;
            initialState = ClusterState.builder(initialState)
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
        final long primaryTerm = indexMetadata.primaryTerm(0);
        Set<String> trackedShards = new HashSet<>();
            this(opFailures, false);
                } else {
                    fail("processed [" + request + "] twice");
    }
        assertEquals(replicasProxy.markedAsStaleCopies, Collections.emptySet());
        indexShardRoutingBuilder.addShard(searchShardRouting);
        op.execute();
        if (primaryShard.relocating() && randomBoolean()) {
            ShardRouting routing = newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId);
        } else {
        TestReplicationOperation(
                builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(shardRouting.currentNodeId()));
        threadPool = new TestThreadPool(getTestName());
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import org.opensearch.index.shard.IndexShardNotStartedException;
        @Override
                final String allocationId = replica.allocationId().getId();
            primaryId
            "test",
        Set<ShardRouting> expectedReplicas = new HashSet<>();
        final TestReplicationOperation op = new TestReplicationOperation(
        IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder(indexMetadata);
            public void perform(Request request, ActionListener<Result> listener) {
        addTrackingInfo(indexShardRoutingTable, primaryShard, trackedShards, untrackedShards);
        );
            "primary shard closed during replication must surface as a retry-able failure, not a silent ack",
            primaryRouting,
                if (localNodeId.equals(shardRouting.currentNodeId()) == false) {
    }
        AllocationId primaryId = AllocationId.newRelocation(AllocationId.newInitializing());
                long primaryTerm,
            @Override
                    }
            shardId,
        final TestReplicationOperation op = new TestReplicationOperation(
            final ActionListener<ReplicationOperation.ReplicaResponse> listener
            }
                if (criticalFailure) {
import org.opensearch.test.OpenSearchTestCase;
            null,
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);
                } else {
            .filter(aId -> !aId.equals(primaryId))
            new TestPrimary(primaryShard, () -> initialReplicationGroup, threadPool),
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
                replicationProxy
            listener.onResponse(null);
import org.opensearch.cluster.node.DiscoveryNode;
                exception = cause;
import org.opensearch.cluster.node.DiscoveryNodes;
        );
        final String index = "test";
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.notNullValue;
        TestPrimary(ShardRouting routing, Supplier<ReplicationGroup> replicationGroupSupplier, ThreadPool threadPool) {
                }
        final Set<String> trackedShards = new HashSet<>();
            this.replicationGroupSupplier = replicationGroupSupplier;
        final IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
                threadPool,
            (replicasProxy, indexShardRoutingTable) -> new ReplicationModeAwareProxy<>(
            request,
            listener,
        }
    public void testReplicationOperationsAreNotSentToSearchReplicas() throws Exception {
                            untrackedShards.add(shr.getTargetRelocatingShard().allocationId().getId());
public class ReplicationOperationTests extends OpenSearchTestCase {
            if (markedAsStaleCopies.add(allocationId) == false) {
                    docrepNodes += 1;
        TestReplicationOperation operation = new TestReplicationOperation(
            true,
        // Add primary and it's relocating target to activeIds
        ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
        assertTrue("listener is not marked as done", listener.isDone());
            boolean added = request.processedOnReplicas.add(replica);
            assertFalse(primaryFailed.get());
        runPrimaryClosedDuringReplicationTest((replicasProxy, indexShardRoutingTable) -> new FanoutReplicationProxy<>(replicasProxy));
                if (shardRouting.unassigned()) {
            nodeIdFromAllocationId(primaryId),
        ClusterState initialState = stateWithActivePrimary(index, true, randomInt(5));
            ShardRoutingState.RELOCATING,
        // ReplicationModeAwareProxy. The PrimaryShardClosedException intercept lives in ReplicationOperation's replica
                        trackedShards.add(shr.allocationId().getId());
        }
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
            // keep things simple
import static org.hamcrest.Matchers.nullValue;
                attemptsBeforeSuccess = Integer.MAX_VALUE;
}
            primaryShard = primaryShard.getTargetRelocatingShard();
        final ShardId shardId = new ShardId(index, "_na_", 0);
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
            }
        assertEquals(2 + initializingIds.size(), shardInfo.getTotal());
            super(
                    shardActionListener.onFailure(shardActionFailure);
        }
        // Only docrep nodes should have the request fanned out to
        ) {
        final long primaryTerm = initialState.getMetadata().index(shardId.getIndexName()).primaryTerm(shardId.id());
        assertEquals(0, replicasProxy.failedReplicas.size());
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
        op.execute();
        // Remote-store write path: primary writes to remote, replicas receive only primary-term validation requests via
        assertEquals(0, request.processedOnReplicas.size());
        final ShardId shardId = new ShardId(index, "_na_", 0);
        trackedShards.addAll(staleAllocationIds);
                if (randomBoolean()) {
            @Override
                TransportAddress address = new TransportAddress(InetAddress.getLoopbackAddress(), 9300);
        Set<AllocationId> activeIds = new HashSet<>();
            if (request.processedOnPrimary.compareAndSet(false, true) == false) {
            assertThat(op.checkActiveShardCount(), notNullValue());
        private final boolean retryable;
        assertThat(replicasProxy.failedReplicas.size(), equalTo(0));
        final int assignedReplicas = randomInt(2);
        for (int i = 0; i < assignedReplicas; i++) {
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
            @Override
            replicasProxy,
            long primaryTerm,
        assertThat(request.processedOnReplicas, equalTo(expectedReplicas));
            null,
            primary,
        }
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
        addTrackingInfo(shardRoutingTable, null, trackedShards, new HashSet<>());
        assertThat(primary.knownLocalCheckpoints.remove(primaryShard.allocationId().getId()), equalTo(primary.localCheckpoint));
                Exception exception,
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
                } else {
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)
        final Set<String> inSyncAllocationIds = Sets.union(indexMetadata.inSyncAllocationIds(0), staleAllocationIds);
        }
                replicasProxy,
            throw new AssertionError("should shouldn't be failed with [" + message + "]", exception);
        final Set<String> trackedShards = new HashSet<>();
        assertThat(primary.knownGlobalCheckpoints, equalTo(replicasProxy.generatedGlobalCheckpoints));
        Request request = new Request(shardId);
            final long globalCheckpoint,
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());
            builder.addShard(routing);
        final long localCheckpoint;
                ReplicationMode.NO_REPLICATION,
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
            public void failShard(String message, Exception exception) {
        expectedFailures.put(failedReplica, new CorruptIndexException("simulated", (String) null));
    private Tuple<Integer, DiscoveryNodes> buildMixedModeDiscoveryNodes(IndexShardRoutingTable routingTable) {
        final long globalCheckpoint;
            ShardRouting routing = newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId);
            passesActiveShardCheck ? "succeed" : "retry",
            this.retryable = retryable;
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
        builder.addShard(primaryShard);
import java.util.Map;
            TimeValue retryTimeout,
        final Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, initialState, trackedShards);
import org.opensearch.cluster.node.DiscoveryNodeRole;
                replicasProxy,
            shardActionFailure = new ShardStateAction.NoLongerPrimaryShardException(failedReplica.shardId(), "the king is dead");
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
            new FanoutReplicationProxy<>(replicasProxy)
                TimeValue.timeValueMillis(50),
            ReplicationProxy<Request> replicationProxy
        final ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
 *
        }
            1 + assignedReplicas,
        assertListenerThrows(
        // add an in-sync allocation id that doesn't have a corresponding routing entry
        }
            String message,
            Exception cause;
        final String index = "test";
        );
            shardId,
                replicas,
            public Request replicaRequest() {
        public long localCheckpoint() {
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
                .nodes(DiscoveryNodes.builder(initialState.nodes()).localNodeId(primaryShard.relocatingNodeId()))
            state
            )
        final Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, initialState, trackedShards);
        @Override
        );
                    t = new CorruptIndexException("simulated", (String) null);
                replicasProxy,
import org.opensearch.transport.SendRequestTransportException;
        public Set<ShardRouting> processedOnReplicas = ConcurrentCollections.newConcurrentSet();
            node.getId(),
        @Override
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();
        );
    }
                    request.runPostReplicationActionsOnPrimary.get()
        final ShardRouting routing;
            replicaStates[i] = ShardRoutingState.UNASSIGNED;
                primary,
            assertTrue("operations should have been performed, active shard count is met", request.processedOnPrimary.get());
            initialState = ClusterState.builder(initialState)
        assertListenerThrows("should throw exception to trigger retry", listener, RetryOnPrimaryException.class);
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
                }
import java.util.HashSet;
            final ShardRouting replica,
    public void testReplicationWithRemoteTranslogEnabled() throws Exception {
        }
            request,
                ReplicationOperationTests.this.logger,
            builder.addShard(routing);
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());
                fail("replica [" + replica + "] was failed");
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();
        Request request = new Request(shardId);
        IndexShardRoutingTable indexShardRoutingTable,
    }
                }
            }
        Set<AllocationId> initializingIds = new HashSet<>();
                listener.onFailure(opFailures.get(replica));
        Tuple<Integer, DiscoveryNodes> discoveryNodesDetails = buildMixedModeDiscoveryNodes(routingTable);
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
            primaryId
        // add a search only replica
            initialState = ClusterState.builder(initialState)
            Request request,
 * license agreements. See the NOTICE file distributed with
            indexShardRoutingTable,
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));
    static String nodeIdFromAllocationId(final AllocationId allocationId) {
import org.apache.lucene.index.CorruptIndexException;
        final Set<ShardRouting> expectedReplicas = initial.stream().filter(shr -> shr.isSearchOnly() == false).collect(Collectors.toSet());
        @Override
                replicationProxy
                listener,
    }
    }
import java.util.Set;
            if (failedReplicas.add(replica) == false) {
        }
                ShardId shardId,
                    assertThat(replica, equalTo(failedReplica));
        final Map<String, Long> generatedGlobalCheckpoints = ConcurrentCollections.newConcurrentMap();
        );
                replicas,
        Set<AllocationId> activeIds = new HashSet<>();
                    } else {
            Request request,
        );
        for (ShardRouting shardRouting : routingTable) {
        ShardId shardId = new ShardId("test", "_na_", 0);
            fail(msg);
            @Override
    }
    }
        op.execute();
            final Request request,
            private ShardInfo shardInfo;
            this(
            }
                logger,
        final AtomicBoolean failShardCalled = new AtomicBoolean(false);
            TimeValue retryTimeout,
        }
        final ShardId shardId = new ShardId(index, "_na_", 0);
        runPrimaryClosedDuringReplicationTest(
            } else {
        final int totalShards = 1 + assignedReplicas + unassignedReplicas;
 */
                    cause = new CircuitBreakingException("broken", CircuitBreaker.Durability.PERMANENT);
                } else {
        @Override
                if (request.runPostReplicationActionsOnPrimary.compareAndSet(false, true) == false) {
        public long globalCheckpoint() {
                        throw new AlreadyClosedException("already closed");
            replicasProxy,
        }
        final long localCheckpoint;
import org.opensearch.Version;
        final String index = "test";
        IndexShardRoutingTable routingTable = builder.build();
        assertThat(shardInfo.getSuccessful(), equalTo(1 + expectedReplicas.size()));
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);
                true,
        activeIds.forEach(
        initialState = state.build();
        final ShardRouting primaryShard = newShardRouting(
        if (shardActionFailure instanceof ShardStateAction.NoLongerPrimaryShardException) {
    private Set<ShardRouting> getExpectedReplicas(ShardId shardId, ClusterState state, Set<String> trackedShards) {
            primaryTerm,
            indexMetadata.inSyncAllocationIds(0),
        assertTrue("listener is not marked as done", listener.isDone());
        ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
        }
                }
        assertTrue("listener is not marked as done", listener.isDone());
            0,
            ShardRoutingState.STARTED,
        assertTrue(
            assertListenerThrows("should throw exception to trigger retry", listener, UnavailableShardsException.class);
            DiscoveryNode node = new DiscoveryNode("foo", buildNewFakeTransportAddress(), Version.CURRENT);
                    if (fatal) {
        final int activeShardCount = randomIntBetween(0, totalShards);
            return maxSeqNoOfUpdatesOrDeletes;
        };
        final long primaryTerm = indexMetadata.primaryTerm(0);
            replicas,
        };
        ShardId shardId = new ShardId("test", "_na_", 0);
        activeIds.add(primaryId);
                replicasProxy,
        ) {
                super.perform(request, ActionListener.map(listener, result -> {
        TestReplicationOperation(
            ActionListener<TestPrimary.Result> listener,
        };
        if (passesActiveShardCheck) {
        }
            request,
import java.util.ArrayList;
                    t = new IndexShardNotStartedException(shardId, IndexShardState.RECOVERING);
                simulatedFailures.put(replica, t);
            Request request,
                shardActionListener.onResponse(null);
            ShardRoutingState.STARTED,
        final Set<String> trackedShards = shardRoutingTable.getAllAllocationIds();
        }
            ActionListener<TestPrimary.Result> listener,
                }));
            shardId,
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
            true,
        trackedShards.addAll(staleAllocationIds);
        final ShardRouting primaryRouting = state.getRoutingTable().shardRoutingTable(shardId).primaryShard();
                return shardInfo;
        final ReplicationOperation.Primary<Request, Request, TestPrimary.Result> primary = new TestPrimary(
            true,
        AtomicBoolean primaryFailed = new AtomicBoolean();
            ShardRoutingState.STARTED
        String localNodeId = state.nodes().getLocalNodeId();
            Logger logger,
            primary,
            index,
        builder.addShard(primaryShard);
            ThreadPool threadPool,
                assertNull(generatedGlobalCheckpoints.put(allocationId, generatedGlobalCheckpoint));
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            public void failShard(String message, Exception exception) {
        final ShardRouting closedReplica = expectedReplicas.iterator().next();
        operation.execute();
        Set<String> trackedShards,
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
        final ClusterState initialState = stateWithActivePrimary(index, true, 0);
            Primary<Request, Request, TestPrimary.Result> primary,
        }
            assertThat(op.checkActiveShardCount(), nullValue());
        final Map<ShardRouting, Exception> reportedFailures = new HashMap<>();
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
            stateWithAddedReplicas = state(index, true, ShardRoutingState.RELOCATING);
        BiFunction<TestReplicaProxy, IndexShardRoutingTable, ReplicationProxy<Request>> proxyFactory
                false
        // All initializing and active shards are set to docrep
                .build();
    private DiscoveryNodes buildDiscoveryNodes(IndexShardRoutingTable routingTable) {
        ShardRouting primaryShard,
            ActionListener<Void> listener
            assertTrue(primaryFailed.get());
                request,
    private DiscoveryNodes buildRemoteStoreEnabledDiscoveryNodes(IndexShardRoutingTable routingTable) {
import org.opensearch.action.support.ActiveShardCount;
import static org.hamcrest.Matchers.hasSize;
        initializingIds.forEach(
                replicas,
            1 + assignedReplicas + unassignedReplicas,
        @Override
            listener,
    }
            request,
        final ShardId shardId = new ShardId(index, "_na_", 0);
            ShardRoutingState.STARTED,
                fail("replica [" + replica + "] was failed twice");
            new TestReplicaProxy(),
        }
            simulatedFailures.put(replica, exception);
                    }
        super.tearDown();
            ActionListener<TestPrimary.Result> listener,
        final ShardRouting primaryShard = updatedReplicationGroup.getRoutingTable().primaryShard();
    ) throws Exception {
        IndexShardRoutingTable routingTable = builder.build();
        Request request = new Request(shardId);
import org.opensearch.transport.RemoteTransportException;
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));
        final ShardInfo shardInfo = listener.actionGet().getShardInfo();
        ShardId shardId = new ShardId("test", "_na_", 0);
        final Supplier<ReplicationGroup> replicationGroupSupplier;
                    reportedFailures.put(replica, t);
            nodeIdFromAllocationId(primaryId),
            listener,
            );
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool) {
                return request;
        builder.addShard(primaryShard);
        final Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, initialState, trackedShards);
                    replicationGroup.set(updatedReplicationGroup);
        }
        assertThat(primary.knownGlobalCheckpoints, equalTo(replicasProxy.generatedGlobalCheckpoints));
        }
            aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId))
            primaryId
                attemptsBeforeSuccess = randomInt(2) + 1;
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
            }
            aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId))
    ) {
 *
            } else {
                primaryTerm,
    }
            );
        AllocationId relocationTargetId = AllocationId.newTargetRelocation(primaryId);
import java.util.function.Supplier;
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));
    }
        );
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());
                replicationProxy
                    shardActionListener.onFailure(shardActionFailure);
            Replicas<Request> replicas,
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
        }
        assertThat(primaryFailed.get(), equalTo(fatal));
    public void testReplication() throws Exception {
                }
        assertEquals(0, replicasProxy.failedReplicas.size());
                threadPool,
import org.opensearch.common.unit.TimeValue;
        IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
            new FanoutReplicationProxy<>(new TestReplicaProxy())
        final ShardRouting failedReplica = randomFrom(new ArrayList<>(expectedReplicas));
        final IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
        final Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
                Exception t;
        assertEquals(0, replicasProxy.failedReplicas.size());
 * You may obtain a copy of the License at
        // Listener should be invoked for initializing Ids, primary and the operations on docrep nodes
 * Licensed to Elasticsearch under one or more contributor
            this.index = shardId.getIndexName();
            }
        assertTrue(
        final PendingReplicationActions pendingReplicationActions;
/*
            failShardCalled.get()
        }
        // Simulate a PrimaryShardClosedException on the chosen replica's performOn. This mirrors what
                        throw new NullPointerException();
        public void markShardCopyAsStaleIfNeeded(ShardId shardId, String allocationId, long primaryTerm, ActionListener<Void> listener) {
            shardActionFailure = new NodeClosedException(new DiscoveryNode("foo", buildNewFakeTransportAddress(), Version.CURRENT));
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
            0,
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
            request,
            0,
        trackedShards = new HashSet<>();
        final ShardRouting primaryShard = newShardRouting(
            this.opFailures = opFailures;
        assertEquals(activeIds.size() + initializingIds.size(), shardInfo.getTotal());
            primaryTerm,
        );
            shardId,
                    builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(shardRouting.currentNodeId()));
            }
            primary,
            primary,
        final IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
        );
    public static class Request extends ReplicationRequest<Request> {
        );
            for (ShardRouting shardRouting : state.routingTable().shardRoutingTable(shardId)) {
        addTrackingInfo(indexShardRoutingTable, primaryShard, trackedShards, untrackedShards);
        );
            true,
    }
                replicasProxy,
                listener,
        public PendingReplicationActions getPendingReplicationActions() {
        simulatedFailures.put(closedReplica, new PrimaryShardClosedException(shardId));
import java.util.concurrent.ExecutionException;
        assertThat(primary.knownLocalCheckpoints.remove(primaryShard.allocationId().getId()), equalTo(primary.localCheckpoint));
        final TestReplicationOperation op = new TestReplicationOperation(
        shardRoutingTable = stateWithAddedReplicas.getRoutingTable().shardRoutingTable(shardId);
        Set<AllocationId> initializingIds = new HashSet<>();
                    return result;
import static org.hamcrest.Matchers.instanceOf;
            )
import static org.hamcrest.Matchers.equalTo;
            .forEach(
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            }
        op.execute();
    public void setUp() throws Exception {
            listener,
    public void testRetryTransientReplicationFailure() throws Exception {
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(new HashMap<>());
        super.setUp();
            return "Request{}";
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
            }
            listener.onResponse(new Result(request));
        assertThat(replicasProxy.markedAsStaleCopies, equalTo(staleAllocationIds));
        }
            if (shardRouting.primary()) {
                if (shardRouting.active() && randomBoolean()) {
        final ReplicationGroup replicationGroup = new ReplicationGroup(
        final IndexShardRoutingTable shardRoutingTable = state.routingTable().index(index).shard(shardId.id());
        });
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
                listener.onResponse(null);
            long primaryTerm,
    public void testNoLongerPrimary() throws Exception {
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
        assertEquals(activeIds.size() - 1, request.processedOnReplicas.size());
                    }
    private void addTrackingInfo(
        final ShardId shardId = new ShardId(index, "_na_", 0);
            Primary<Request, Request, TestPrimary.Result> primary,
        Set<AllocationId> activeIds = new HashSet<>();
        final ClusterState state = stateWithActivePrimary(index, true, 1, 0);
            return pendingReplicationActions;
                .nodes(DiscoveryNodes.builder(initialState.nodes()).localNodeId(primaryShard.relocatingNodeId()))
        @Override
    }
            knownGlobalCheckpoints.put(allocationId, globalCheckpoint);
        );
                .build();
                aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId))
        assertThat(shardInfo.getSuccessful(), equalTo(1 + getExpectedReplicas(shardId, state, trackedShards).size()));
            primaryShard = primaryShard.getTargetRelocatingShard();
    @Override
            );
        if (randomBoolean()) {
                listener.onResponse(null);
                opType,
        IndexShardRoutingTable routingTable = builder.build();
                } else {
        }
        assertFalse(
        }
import org.opensearch.cluster.routing.ShardRoutingState;
        final String index = "test";
                builder.add(IndexShardTestUtils.getFakeDiscoNode(shardRouting.currentNodeId()));
 */
        @Override
            String opType,
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithActivePrimary;
            @Override
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
            ShardRouting routing = newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId);
            nodeIdFromAllocationId(relocationTargetId),
        } else {
                        }
                "test",
                        expectedReplicas.add(shardRouting);
            request,
        );
            int n = attemptsNumber.incrementAndGet();
        final IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
        Request request = new Request(shardId);
            this.globalCheckpoint = globalCheckpoint;
        return builder.build();
 * Modifications Copyright OpenSearch Contributors. See
        );
            new FanoutReplicationProxy<>(replicasProxy)
    public void testReplicationInDualModeWithDocrepReplica() throws Exception {
        final int totalShards = 1 + expectedReplicas.size() + unassignedShards.size() + untrackedShards.size();
        public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {
        TestReplicaProxy(Map<ShardRouting, Exception> opFailures, boolean retryable) {
            if (shr.unassigned() == false) {
        final Set<String> staleAllocationIds = Sets.newHashSet(generateRandomStringArray(4, 10, false));
        public ReplicationGroup getReplicationGroup() {
            aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId))
        // During dual replication, except for primary, replication action should be executed on all the replicas
        int docRepNodes = discoveryNodesDetails.v1();
            request.waitForActiveShards(),
            ThreadPool threadPool,
                ShardRouting replica,
        final Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, initialState, trackedShards);
        final ShardRouting primaryShard = shardRoutingTable.primaryShard();
import org.opensearch.cluster.metadata.IndexMetadata;
            primaryTerm,
        }
        final Map<String, Long> knownLocalCheckpoints = Collections.synchronizedMap(new HashMap<>());
                buildRemoteStoreEnabledDiscoveryNodes(routingTable),
        assertEquals(0, replicasProxy.failedReplicas.size());
                true
        activeIds.stream()
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
    public void testForceReplicationWithRemoteTranslogEnabled() throws Exception {
        } catch (ExecutionException ex) {
        ReplicaResponse(long localCheckpoint, long globalCheckpoint) {
                primaryTerm,
            primary,
            replicasProxy,
            ShardRoutingState.STARTED,
    public void testPrimaryToPrimaryReplicationWithRemoteTranslogEnabled() throws Exception {
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());
                builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(shardRouting.currentNodeId()));
        assertTrue(
            long primaryTerm,
            if (retryable == false || added) {
import org.opensearch.cluster.action.shard.ShardStateAction;
        op.execute();
        assertTrue("listener is not marked as done", listener.isDone());
        assertThat("request was not processed on primary", request.processedOnPrimary.get(), equalTo(true));
        Set<AllocationId> initializingIds = new HashSet<>();
        initializingIds.forEach(
            }
import org.opensearch.action.UnavailableShardsException;
                    if (trackedShards.contains(shardRouting.allocationId().getId())) {
            return;
                assertThat(exception, instanceOf(ShardStateAction.NoLongerPrimaryShardException.class));
        // execute a request and check hits
        }
        assertTrue(
            null,
    @Override
            @Override
            ReplicationProxy<Request> replicationProxy
        }
        activeIds.add(relocationTargetId);
        public String toString() {
        public void performOn(
                    if (shr.relocating()) {
        public void failShardIfNeeded(
            // simulate execution of the replication phase on the relocation target node after relocation source was marked as relocated
import org.opensearch.core.action.ActionListener;
                boolean criticalFailure = randomBoolean();
        assertThat(primary.knownLocalCheckpoints, equalTo(replicasProxy.generatedLocalCheckpoints));
            indexMetadata.primaryTerm(0),
        Request request = new Request(shardId);
            assertFalse("operations should not have been perform, active shard count is *NOT* met", request.processedOnPrimary.get());
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
 * KIND, either express or implied.  See the License for the
            }
                    } else {
            public ShardInfo getShardInfo() {
        Request request = new Request(shardId);
            threadPool
            // should not have run.
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(expectedFailures) {
                logger.debug("--> simulating failure on {} with [{}]", replica, t.getClass().getSimpleName());
                primary,
        ClusterState.Builder state = ClusterState.builder(initialState);
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo;
        final Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
                new NodeClosedException(node)
        // Generating data nodes in mixed mode wherein some of the allocated replicas
        @Override
            }
        final Set<String> inSyncAllocationIds = Sets.union(indexMetadata.inSyncAllocationIds(0), staleAllocationIds);
                // Only add docrep nodes for allocationIds that are active
        final ShardRouting primaryShard = newShardRouting(
            public void failShardIfNeeded(
            ActionListener<TestPrimary.Result> listener,
    }
                    super.markShardCopyAsStaleIfNeeded(shardId, allocationId, primaryTerm, shardActionListener);
        // shards are not part of the rg
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());
            pendingReplicationActions.accept(getReplicationGroup());
 */
                buildRemoteStoreEnabledDiscoveryNodes(indexShardRoutingTable),
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures) {
                ActionListener<Void> shardActionListener
            Exception exception;
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
        final Set<ShardRouting> failedReplicas = ConcurrentCollections.newConcurrentSet();
        }
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));
        TestReplicaProxy() {
        addTrackingInfo(shardRoutingTable, null, trackedShards, new HashSet<>());
    }
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);
            nodeIdFromAllocationId(primaryId),
            0,
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));
            activeShardCount == totalShards ? ActiveShardCount.ALL : ActiveShardCount.from(activeShardCount)
        ) {
        final long globalCheckpoint;
            }
        return "n-" + allocationId.getId().substring(0, 8);
                    cause = new OpenSearchRejectedExecutionException("rejected");
        final ReplicationGroup replicationGroup = new ReplicationGroup(indexShardRoutingTable, inSyncAllocationIds, trackedShards, 0);
    static class TestPrimary implements ReplicationOperation.Primary<Request, Request, TestPrimary.Result> {
        final String index = "test";
            logger.debug("--> simulating failure on {} with [{}]", replica, exception.getClass().getSimpleName());
        final IndexShardRoutingTable shardRoutingTable = state.routingTable().index(index).shard(shardId.id());
        final Set<String> trackedShards = new HashSet<>();
                if (testPrimaryDemotedOnStaleShardCopies) {
                initialRetryBackoffBound,
                fail("replica [" + allocationId + "] was marked as stale twice");
        final Set<String> trackedShards = new HashSet<>();
                index,
                failShardCalled.set(true);
        ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
            this.localCheckpoint = random().nextLong();
            );
                ActionListener<Void> shardActionListener
        assertTrue("listener is not marked as done", listener.isDone());
        try {
                assertTrue(primaryFailed.compareAndSet(false, true));
        );
        }
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
        Request request = new Request(shardId);
        inSyncAllocationIds = stateWithAddedReplicas.metadata().index(index).inSyncAllocationIds(0);
        op.execute();
import org.opensearch.cluster.metadata.Metadata;
        Request request = new Request(shardId).waitForActiveShards(
            request,
        });
        final TestReplicationOperation op = new TestReplicationOperation(
        final Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
            RetryOnPrimaryException.class
        if (randomBoolean()) {
        ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
                aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId))
            ) {
        for (ShardRouting shr : indexShardRoutingTable.shards()) {
            this(
            long primaryTerm,
            true,
        final Request request = new Request(shardId);
        assertThat(replicationGroup.toString(), shardInfo.getTotal(), equalTo(totalShards));
        final ShardRouting primaryShard = newShardRouting(
            listener,
        Set<String> untrackedShards
        @Override
        assertThat("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get(), equalTo(true));
            replicasProxy,
        final ReplicationGroup replicationGroup = new ReplicationGroup(indexShardRoutingTable, inSyncAllocationIds, trackedShards, 0);
            listener,
        final Map<ShardRouting, Exception> expectedFailures = new HashMap<>();
        assertThat(shardInfo.getFailures(), arrayWithSize(reportedFailures.size()));
        // add a few in-sync allocation ids that don't have corresponding routing entries
        final Set<String> inSyncAllocationIds = Sets.union(indexMetadata.inSyncAllocationIds(0), staleAllocationIds);
import org.opensearch.cluster.routing.ShardRouting;
        final Set<String> untrackedShards = new HashSet<>();
        );
        @Override
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
            return routing;
        }
        final TestReplicationOperation op = new TestReplicationOperation(
        Set<AllocationId> activeIds = new HashSet<>();
            ) {
                }
 * specific language governing permissions and limitations
            @Override
import org.opensearch.index.shard.IndexShardTestUtils;
import org.opensearch.cluster.routing.RoutingTable;
        addTrackingInfo(indexShardRoutingTable, primaryShard, trackedShards, new HashSet<>());
        );
                replicas,
                long term,
        public long localCheckpoint() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            new FanoutReplicationProxy<>(replicasProxy)
            this.localCheckpoint = localCheckpoint;
        );
                    }
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
 * The OpenSearch Contributors require contributions made to
            return localCheckpoint;
