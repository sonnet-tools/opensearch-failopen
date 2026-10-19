        );
        int docRepNodes = discoveryNodesDetails.v1();
            shardActionFailure = new ShardStateAction.NoLongerPrimaryShardException(failedReplica.shardId(), "the king is dead");  
        Request request = new Request(shardId).waitForActiveShards(
        return builder.build();
import org.opensearch.index.shard.ReplicationGroup;
            null,
            trackedShards.add(shr.allocationId().getId());
        final ReplicationGroup replicationGroup = new ReplicationGroup(indexShardRoutingTable, inSyncAllocationIds, trackedShards, 0);
        String localNodeId = state.nodes().getLocalNodeId();
        assertEquals(activeIds.size() + initializingIds.size(), shardInfo.getTotal());
            primary,
            if (retryable == false || added) {  
        if (expectedReplicas.isEmpty()) {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;
        activeIds.add(primaryId);
                    docrepNodes += 1;
        final ReplicationOperation.Primary<Request, Request, TestPrimary.Result> primary = new TestPrimary(
            // simulate execution of the replication phase on the relocation target node after relocation source was marked as relocated  
        final long primaryTerm = indexMetadata.primaryTerm(0);  
            return localCheckpoint;
        // listener, so it must trip the retry path regardless of which proxy delivered the failure.
        final Map<ShardRouting, Exception> opFailures;
 * not use this file except in compliance with the License.
                        expectedReplicas.add(shardRouting.getTargetRelocatingShard());
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
            ReplicationProxy<Request> replicationProxy  
            ) {
                initialRetryBackoffBound,
        final Set<String> inSyncAllocationIds = Sets.union(indexMetadata.inSyncAllocationIds(0), staleAllocationIds);  
        public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {
        ShardRouting searchShardRouting = TestShardRouting.newShardRouting(  
        final long primaryTerm = indexMetadata.primaryTerm(0);
            nodeIdFromAllocationId(primaryId),
            listener,  
            Primary<Request, Request, TestPrimary.Result> primary,  
        addTrackingInfo(shardRoutingTable, null, trackedShards, new HashSet<>());
        };  
        };
                    return result;  
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)
                TimeValue.timeValueMillis(50),
        assertThat(primary.knownLocalCheckpoints.remove(primaryShard.allocationId().getId()), equalTo(primary.localCheckpoint));
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
        final ShardId shardId = new ShardId(index, "_na_", 0);  
        return expectedReplicas;  
import org.opensearch.test.OpenSearchTestCase;  
 *
                threadPool,
        final ShardId shardId = new ShardId(index, "_na_", 0);
        @Override  
    }
                new NodeClosedException(node)  
        }
        Set<String> trackedShards = new HashSet<>();  
        assertThat(primary.knownLocalCheckpoints.remove(primaryShard.allocationId().getId()), equalTo(primary.localCheckpoint));
    public void setUp() throws Exception {
            this.localCheckpoint = localCheckpoint;
        final Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
                    }
                if (primaryRouting.allocationId().getId().equals(allocationId)) {
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
import org.opensearch.transport.ConnectTransportException;  
            0,
    }  
        assertThat(primary.knownGlobalCheckpoints.remove(primaryShard.allocationId().getId()), equalTo(primary.globalCheckpoint));  
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
        final IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);  
        assertTrue(
        assertEquals(0, replicasProxy.failedReplicas.size());
        assertTrue("listener is not marked as done", listener.isDone());  
        builder.addShard(primaryShard);
                } else {
                aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId))
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());  
    public void testReplicationInDualModeWithDocrepReplica() throws Exception {
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
            failShardCalled.get()  
        Set<ShardRouting> initial = getExpectedReplicas(shardId, initialState, trackedShards);
import static org.hamcrest.Matchers.hasSize;
            assertThat(op.checkActiveShardCount(), nullValue());
            nodeIdFromAllocationId(primaryId),
        final TestReplicationOperation op = new TestReplicationOperation(
        @Override
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
import org.opensearch.node.NodeClosedException;
        assertThat(primaryFailed.get(), equalTo(fatal));  
        Request request = new Request(shardId);  
        assertThat(replicasProxy.failedReplicas, equalTo(simulatedFailures.keySet()));
            )  
            request,
        final Set<String> inSyncAllocationIds = Sets.union(indexMetadata.inSyncAllocationIds(0), staleAllocationIds);  
            @Override  
    private Tuple<Integer, DiscoveryNodes> buildMixedModeDiscoveryNodes(IndexShardRoutingTable routingTable) {
        // add a few in-sync allocation ids that don't have corresponding routing entries  
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),  
        assertEquals(0, replicasProxy.failedReplicas.size());  
                .build();
        );
        );
        assertThat("test requires two replicas", expectedReplicas, hasSize(2));
        final Set<String> staleAllocationIds = Sets.newHashSet(generateRandomStringArray(4, 10, false));  
            "nodeForSearchShard",  
 * Unless required by applicable law or agreed to in writing,
            new FanoutReplicationProxy<>(replicasProxy)
        ShardRouting primaryShard = indexShardRoutingTable.primaryShard();  
import org.opensearch.threadpool.ThreadPool;
            TimeValue retryTimeout,
import org.opensearch.core.common.breaker.CircuitBreakingException;
        final TestReplicationOperation op = new TestReplicationOperation(
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
            true,  
    }  
        };
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
            }
            public void failShardIfNeeded(
 * software distributed under the License is distributed on an
            this.localCheckpoint = random().nextLong();
            listener,
        final IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
            new TestReplicaProxy(),
            primaryRouting,
                if (criticalFailure) {
                aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId))
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
        final ShardRouting primaryShard = newShardRouting(  
                logger.debug("--> simulating failure on {} with [{}]", replica, t.getClass().getSimpleName());
    public void testNoLongerPrimary() throws Exception {  
            "primary shard closed during replication must surface as a retry-able failure, not a silent ack",  
            if (randomBoolean()) {  
        }
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());  
                super.perform(request, ActionListener.map(listener, result -> {  
            primary,  
        });  
        @Override
import java.util.concurrent.ExecutionException;  
        }  
            return maxSeqNoOfUpdatesOrDeletes;  
        final ShardRouting primaryShard = shardRoutingTable.primaryShard();  
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);  
                    super.failShardIfNeeded(replica, primaryTerm, message, exception, shardActionListener);  
            );
                replicationProxy  
        final List<ShardRouting> unassignedShards = indexShardRoutingTable.shardsWithState(ShardRoutingState.UNASSIGNED);
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
                } else {
        @Override
        Set<AllocationId> initializingIds = new HashSet<>();
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool) {
            null,  
        final String index = "test";
        // Simulate a PrimaryShardClosedException on the chosen replica's performOn. This mirrors what
            // simulate execution of the replication phase on the relocation target node after relocation source was marked as relocated
                DiscoveryNode node = new DiscoveryNode("replica", address, Version.CURRENT);  
            }
        public long globalCheckpoint() {
        final String index = "test";  
            logger.debug("--> simulating failure on {} with [{}]", replica, exception.getClass().getSimpleName());
        ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
        assertEquals(request.processedOnReplicas, expectedReplicas);  
        }
        );
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);
    }  
import org.opensearch.cluster.routing.RoutingTable;  
        assertTrue("listener is not marked as done", listener.isDone());
        final Exception shardActionFailure;
            assertListenerThrows("should throw exception to trigger retry", listener, UnavailableShardsException.class);  
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
    }
import org.opensearch.cluster.action.shard.ShardStateAction;  
        final TestReplicationOperation op = new TestReplicationOperation(
        Request request = new Request(shardId);
    static class TestPrimary implements ReplicationOperation.Primary<Request, Request, TestPrimary.Result> {
 */
    }
                this.request = request;
 * specific language governing permissions and limitations
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();  
    public void testReplicationOperationsAreNotSentToSearchReplicas() throws Exception {
        });
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));
            knownGlobalCheckpoints.put(allocationId, globalCheckpoint);
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());  
            }  
                Exception t;
            String opType,  
            }
        @Override  
            }
        assertListenerThrows(
            replicaStates[i] = ShardRoutingState.UNASSIGNED;  
            );
        assertTrue(
                index,
            TimeValue initialRetryBackoffBound,
            primary,  
        Request request = new Request(shardId);
            false,
            ShardRouting routing = newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId);
            request,
            (replicasProxy, indexShardRoutingTable) -> new ReplicationModeAwareProxy<>(
 *  
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(expectedFailures) {
        private final AtomicInteger attemptsNumber = new AtomicInteger(0);  
        final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(0);
            Exception cause;
            new FanoutReplicationProxy<>(new TestReplicaProxy())
        logger.debug("--> using initial replicationGroup:\n{}", replicationGroup.get());  
    private DiscoveryNodes buildDiscoveryNodes(IndexShardRoutingTable routingTable) {
            Primary<Request, Request, TestPrimary.Result> primary,
            request,
        if (primaryShard.relocating() && randomBoolean()) {
        @Override
            } else {
    public void testReplicationInDualModeWithMixedReplicasSomeInDocrepOthersOnRemote() throws Exception {
                primary,  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
        ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
                        untrackedShards.add(shr.allocationId().getId());
            aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId))
            null
        final ShardId shardId = new ShardId(index, "_na_", 0);  
        op.execute();  
            shardActionFailure = new SendRequestTransportException(  
        IndexShardRoutingTable routingTable = builder.build();
import org.opensearch.transport.SendRequestTransportException;
            builder.addShard(routing);
            }  
        // All initializing and active shards are set to docrep
                }
        ReplicaResponse(long localCheckpoint, long globalCheckpoint) {
            primaryShard = primaryShard.getTargetRelocatingShard();
            request,  
        ReplicationGroup updatedReplicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);  
        assertTrue("listener is not marked as done", listener.isDone());  
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
        final int totalShards = 1 + assignedReplicas + unassignedReplicas;  
        );  
        final int totalShards = 1 + expectedReplicas.size() + unassignedShards.size() + untrackedShards.size();
        final String index = "test";
        AllocationId primaryId = activeIds.iterator().next();
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        assertThat(replicasProxy.markedAsStaleCopies, equalTo(staleAllocationIds));
        assertEquals(docRepNodes, request.processedOnReplicas.size());
        }  
            listener,
            ShardRouting routing = newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId);  
    public void testPrimaryToPrimaryReplicationWithRemoteTranslogEnabled() throws Exception {  
        op.execute();
            this.globalCheckpoint = randomNonNegativeLong();  
        }
            }
                listener.onResponse(new ReplicaResponse(generatedLocalCheckpoint, generatedGlobalCheckpoint));
            primary,  
            if (opFailures.containsKey(replica) && n <= attemptsBeforeSuccess) {
        Set<ShardRouting> expectedReplicas = new HashSet<>();
        Request request = new Request(shardId);
        public long localCheckpoint() {
            ActionListener<TestPrimary.Result> listener,
    static class TestReplicaProxy implements ReplicationOperation.Replicas<Request> {  
            trackedShards,  
                replicas,
        }
        ClusterState initialState = stateWithActivePrimary(index, true, 1 + randomInt(2), randomInt(2));
                    shardActionListener.onFailure(shardActionFailure);  
        assertThat("request was not processed on primary", request.processedOnPrimary.get(), equalTo(true));
            primaryTerm,
    public void testWaitForActiveShards() throws Exception {
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
            shardActionFailure = new NodeClosedException(new DiscoveryNode("foo", buildNewFakeTransportAddress(), Version.CURRENT));  
            listener,
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
        @Override
        ShardId shardId = new ShardId("test", "_na_", 0);  
        public AtomicBoolean runPostReplicationActionsOnPrimary = new AtomicBoolean();  
        ) {
            "test",
        assertFalse(
 * the Apache License, Version 2.0 (the "License"); you may
        // execute a request and check hits  
        final ClusterState initialState = state(
                initialRetryBackoffBound,
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
        Set<AllocationId> activeIds = new HashSet<>();
            Request request,  
        op.execute();
                replicasProxy,
        assertEquals(activeIds.size() - 1, request.processedOnReplicas.size());  
            @Override
            return;
        }
            }
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
import org.opensearch.cluster.routing.IndexRoutingTable;
            true,
        final TestReplicationOperation op = new TestReplicationOperation(  
        assertThat(primary.knownLocalCheckpoints, equalTo(replicasProxy.generatedLocalCheckpoints));
import org.opensearch.action.UnavailableShardsException;
            null,  
        final Set<String> inSyncAllocationIds = Sets.union(indexMetadata.inSyncAllocationIds(0), staleAllocationIds);
    class TestReplicationOperation extends ReplicationOperation<Request, Request, TestPrimary.Result> {
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
        return builder.build();
        final boolean fatal = randomBoolean();
        for (ShardRouting shr : indexShardRoutingTable.shards()) {
                threadPool,
            aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.STARTED, aId))
            null,
        public void failShard(String message, Exception exception) {
            Request request,
            if (opFailures.containsKey(replica)) {
        final Set<String> untrackedShards = new HashSet<>();
import org.opensearch.Version;  
                primaryTerm,  
            }  
package org.opensearch.action.support.replication;
            primaryId  
                ReplicationOperationTests.this.logger,  
        final ReplicationGroup replicationGroup = new ReplicationGroup(indexShardRoutingTable, inSyncAllocationIds, trackedShards, 0);
                            trackedShards.add(shr.getTargetRelocatingShard().allocationId().getId());
            null,  
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);
        activeIds.add(relocationTargetId);  
        final Map<String, Long> generatedGlobalCheckpoints = ConcurrentCollections.newConcurrentMap();
        IndexMetadata.Builder indexMetadataBuilder = new IndexMetadata.Builder(indexMetadata);  
        assertThat(primary.knownGlobalCheckpoints, equalTo(replicasProxy.generatedGlobalCheckpoints));
        TestReplicationOperation(
            if (failedReplicas.add(replica) == false) {
import java.util.concurrent.atomic.AtomicBoolean;
            request,
                ReplicationMode.NO_REPLICATION,
                }  
    }
        );  
    }
        );  
            true,
            primary,  
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)
            private final Request request;  
            this.retryable = retryable;
            Exception exception,
        builder.addShard(primaryShard);
            String opType,
        assertThat("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get(), equalTo(true));  
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
        public void updateGlobalCheckpointForShard(String allocationId, long globalCheckpoint) {  
            new ReplicationModeAwareProxy<>(  
        final long primaryTerm = indexMetadata.primaryTerm(0);
                    }  
        Request request = new Request(shardId);
            Logger logger,
        trackedShards.addAll(staleAllocationIds);  
        );  
        }  
            Primary<Request, Request, TestPrimary.Result> primary,
    }
                    if (fatal) {
    public void tearDown() throws Exception {
            new FanoutReplicationProxy<>(replicasProxy)
            Version.CURRENT
 *
                long term,  
        if (randomBoolean()) {
            }  
 * GitHub history for details.
            primaryId  
        assertEquals(1 + docRepNodes + initializingIds.size(), shardInfo.getTotal());
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithActivePrimary;
            );
            threadPool,
                replicationProxy
import org.opensearch.index.shard.IndexShardTestUtils;
            private ShardInfo shardInfo;
        // shards are not part of the rg
        assertThat(shardInfo.getFailed(), equalTo(reportedFailures.size()));  
        threadPool = new TestThreadPool(getTestName());
        @Override
            0,
            ShardRoutingState.STARTED,  
        final AtomicReference<ReplicationGroup> replicationGroup = new AtomicReference<>(initialReplicationGroup);
        }
            this.index = shardId.getIndexName();
        final long globalCheckpoint;
            shardId,  
                opType,  
        assertEquals(replicasProxy.markedAsStaleCopies, Collections.emptySet());
    }
                node,
                fail("replica [" + allocationId + "] was marked as stale twice");
        }
            );
                } else {  
            listener,  
                assertTrue("replica request processed twice on [" + replica + "]", added);
            Primary<Request, Request, TestPrimary.Result> primary,  
        final ReplicationGroup replicationGroup = new ReplicationGroup(indexShardRoutingTable, inSyncAllocationIds, trackedShards, 0);  
                    }  
        final Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
            if (shardRouting.primary()) {
        }  
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));
        );
                TransportAddress address = new TransportAddress(InetAddress.getLoopbackAddress(), 9300);
            primaryTerm,
            0,  
        ) {
    public void testPrimaryClosedDuringFullReplicationTriggersRetry() throws Exception {
        TestReplicaProxy() {  
            // simulate execution of the replication phase on the relocation target node after relocation source was marked as relocated
        );
            ReplicationProxy<Request> replicationProxy
        // Add primary and it's relocating target to activeIds
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
            Replicas<Request> replicas,
import java.util.Collections;  
    public void testForceReplicationWithRemoteTranslogEnabled() throws Exception {
            request,  
        int docrepNodes = 0;  
        });
        @Override
        final ShardId shardId = new ShardId(index, "_na_", 0);
            listener.onResponse(null);
        ShardInfo shardInfo = listener.actionGet().getShardInfo();  
        assertThat(shardInfo.getFailures(), arrayWithSize(0));  
        }  
        final long localCheckpoint;  
        final Set<String> untrackedShards = new HashSet<>();  
                fail("replica [" + replica + "] was failed");
                listener.onFailure(opFailures.get(replica));  
        );  
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());  
    @Override
                .nodes(DiscoveryNodes.builder(initialState.nodes()).localNodeId(primaryShard.relocatingNodeId()))
 * ownership. Elasticsearch licenses this file to you under  
        );
                assertNull(generatedGlobalCheckpoints.put(allocationId, generatedGlobalCheckpoint));  
        activeIds.forEach(
        public long maxSeqNoOfUpdatesOrDeletes() {
            true,  
                }  
                ShardRoutingState.STARTED,  
        } else {
            shardId,
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
        final ShardRouting primaryShard = newShardRouting(
                ActionListener<Void> shardActionListener  
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());
        final String index = "test";
    }  
            if (retryable == false) {
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)  
            return localCheckpoint;  
            if (retryable) {
            ShardRoutingState.STARTED,
                    assertThat(replica, equalTo(failedReplica));
            request,  
    public void testAddedReplicaAfterPrimaryOperation() throws Exception {  
import org.opensearch.cluster.metadata.IndexMetadata;
            builder.addShard(routing);  
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));  
            new TestReplicaProxy(),
            OpenSearchTestCase.buildNewFakeTransportAddress(),
                primaryTerm,
        final boolean testPrimaryDemotedOnStaleShardCopies = randomBoolean();  
        }
        @Override
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));
        op.execute();
        }
        Request request = new Request(shardId);  
        );
                } else {
                replicationProxy
            }
                    shardActionListener.onFailure(shardActionFailure);  
                    trackedShards.add(shr.allocationId().getId());
    }
        if (shardActionFailure instanceof ShardStateAction.NoLongerPrimaryShardException) {
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
                    cause = new CircuitBreakingException("broken", CircuitBreaker.Durability.PERMANENT);
        ClusterState initialState = stateWithActivePrimary(index, true, randomInt(5));  
            .forEach(
import org.opensearch.common.unit.TimeValue;  
        final ReplicationGroup replicationGroup = new ReplicationGroup(indexShardRoutingTable, inSyncAllocationIds, trackedShards, 0);  
            new FanoutReplicationProxy<>(replicasProxy)
        } else if (randomBoolean()) {
        assertEquals(replicasProxy.failedReplicas, Collections.emptySet());
            return globalCheckpoint;
        final int activeShardCount = randomIntBetween(0, totalShards);
                    t = new IndexShardNotStartedException(shardId, IndexShardState.RECOVERING);
                }
            primaryTerm,  
                ReplicationMode.NO_REPLICATION,
            indexShardRoutingTable,
        final Set<String> inSyncAllocationIds = state.metadata().index(index).inSyncAllocationIds(0);  
    }
                    fail("processed [" + request + "] twice");
        addTrackingInfo(indexShardRoutingTable, primaryShard, trackedShards, untrackedShards);  
            } else {  
            shardId,  
            .forEach(  
        AllocationId primaryId = AllocationId.newRelocation(AllocationId.newInitializing());  
        AtomicBoolean primaryFailed = new AtomicBoolean();  
            Replicas<Request> replicas,  
        try {
        if (primaryShard.relocating() && randomBoolean()) {
        final ReplicationGroup initialReplicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);  
        // replica exercises the successful path alongside the closed one.  
                listener.onResponse(null);
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
        final TestReplicationOperation op = new TestReplicationOperation(
        assertThat("request was not processed on primary", request.processedOnPrimary.get(), equalTo(true));  
    private Set<ShardRouting> getExpectedReplicas(ShardId shardId, ClusterState state, Set<String> trackedShards) {  
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)  
        Tuple<Integer, DiscoveryNodes> discoveryNodesDetails = buildMixedModeDiscoveryNodes(routingTable);
            TimeValue initialRetryBackoffBound,
        final List<ShardRouting> unassignedShards = indexShardRoutingTable.shardsWithState(ShardRoutingState.UNASSIGNED);  
        }  
        IndexShardRoutingTable routingTable = builder.build();
            primaryTerm,  
                builder.add(IndexShardTestUtils.getFakeDiscoNode(shardRouting.currentNodeId()));
 * this work for additional information regarding copyright
import org.opensearch.action.support.ActiveShardCount;
            aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId))  
        assertThat(request.processedOnReplicas, equalTo(expectedReplicas));
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();  
        final Map<ShardRouting, Exception> expectedFailures = new HashMap<>();  
        }
    ) throws Exception {
        }  
        }  
        Request request = new Request(shardId);
            super(
        );  
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
        final Set<String> trackedShards = new HashSet<>();
            simulatedFailures.put(replica, exception);
        ClusterState.Builder state = ClusterState.builder(initialState);
            stateWithAddedReplicas = state(index, true, ShardRoutingState.RELOCATING);
        op.execute();
            public void setShardInfo(ShardInfo shardInfo) {
    public void testPrimaryFailureHandlingReplicaResponse() throws Exception {
        assertThat(replicationGroup.toString(), shardInfo.getTotal(), equalTo(totalShards));  
                .build();
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();  
            nodeIdFromAllocationId(primaryId),
            ShardRouting routing = newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId);
        final ShardRouting routing;
        AllocationId relocationTargetId = AllocationId.newTargetRelocation(primaryId);
        }  
        Request request = new Request(shardId);  
            initialState = ClusterState.builder(initialState)  
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());
        static class Result implements ReplicationOperation.PrimaryResult<Request> {
            state
            @Override
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        terminate(threadPool);  
            @Override
        public long computedGlobalCheckpoint() {  
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.common.settings.Settings;
            return globalCheckpoint;
            );  
        }
            "using active shard count of [{}], assigned shards [{}], total shards [{}]." + " expecting op to [{}]. using state: \n{}",
        @Override  
        assertThat(request.processedOnReplicas, equalTo(expectedReplicas));
 */
        Request request = new Request(shardId);
        ClusterState initialState = stateWithActivePrimary(index, true, randomInt(5));
            ShardRoutingState.STARTED,
            public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {
            activeShardCount == totalShards ? ActiveShardCount.ALL : ActiveShardCount.from(activeShardCount)  
        for (ShardRouting shr : indexShardRoutingTable.shards()) {  
                if (shardRouting.active() && randomBoolean()) {
 */  
            primary,  
    public void testReplicationWithRemoteTranslogEnabled() throws Exception {
        state.routingTable(
            primaryTerm,  
/*
            listener,
                replicas,  
        assertTrue(listener.isDone());  
 * The OpenSearch Contributors require contributions made to  
        assertThat(shardInfo.getFailures(), arrayWithSize(reportedFailures.size()));
                true,
            }  
            listener,
            replicasProxy,
        );
        final Map<ShardRouting, Exception> reportedFailures = new HashMap<>();
                        throw new AlreadyClosedException("already closed");
        final Set<String> trackedShards = new HashSet<>();
        Set<String> trackedShards = new HashSet<>();
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));  
        op.execute();  
        Set<String> untrackedShards  
        final TestReplicationOperation op = new TestReplicationOperation(
        addTrackingInfo(indexShardRoutingTable, primaryShard, trackedShards, untrackedShards);
import java.util.function.BiFunction;
            if (shardRouting.primary()) {  
        final IndexShardRoutingTable shardRoutingTable = state.routingTable().index(index).shard(shardId.id());
        Set<String> inSyncAllocationIds = initialState.metadata().index(index).inSyncAllocationIds(0);
            }
        addTrackingInfo(indexShardRoutingTable, primaryShard, trackedShards, untrackedShards);
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());
        assertThat(replicasProxy.failedReplicas.size(), equalTo(0));
                primaryTerm,
        final ShardRouting primaryShard = updatedReplicationGroup.getRoutingTable().primaryShard();
            ) {
            this.replicationGroupSupplier = replicationGroupSupplier;
    }
    private ThreadPool threadPool;
            ShardRoutingState.STARTED,
        public Set<ShardRouting> processedOnReplicas = ConcurrentCollections.newConcurrentSet();
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
        logger.debug(
                ReplicationOperationTests.this.logger,
        private final int attemptsBeforeSuccess;
            public void failShard(String message, Exception exception) {
import java.util.stream.Collectors;  
            request,
        // During dual replication, except for primary, replication action should be executed on all the replicas
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());  
        final Map<String, Long> generatedLocalCheckpoints = ConcurrentCollections.newConcurrentMap();  
            indexMetadata.inSyncAllocationIds(0),
        final String index = "test";
        ShardInfo shardInfo = listener.actionGet().getShardInfo();  
                request,  
        activeIds.stream().filter(aId -> !aId.equals(primaryId)).forEach(aId -> {  
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);  
        );
        TestReplicaProxy(Map<ShardRouting, Exception> opFailures) {
            String message,  
            proxyFactory.apply(replicasProxy, indexShardRoutingTable)
    public void testRetryTransientReplicationFailure() throws Exception {
        final long maxSeqNoOfUpdatesOrDeletes;
                // since the test cases creates replication group with active allocationIds only
        // Deterministic setup: one primary and two started replicas, all tracked. Two replicas so that the non-closed
        assertThat(shardInfo.getSuccessful(), equalTo(1 + expectedReplicas.size() - simulatedFailures.size()));
import org.opensearch.cluster.routing.ShardRouting;
            builder.addShard(routing);
        }
        );  
            new ReplicationModeAwareProxy<>(
            ) {
        ) {
        activeIds.stream()
            ActionListener<TestPrimary.Result> listener,
            ActionListener<TestPrimary.Result> listener,
            this(
            assertTrue("operations should have been performed, active shard count is met", request.processedOnPrimary.get());
        trackedShards = new HashSet<>();  
        assertTrue("listener is not marked as done", listener.isDone());
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();  
                }));
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);  
            op.execute();
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));
        }  
            new FanoutReplicationProxy<>(replicas)
        Set<AllocationId> initializingIds = new HashSet<>();  
                    builder.add(IndexShardTestUtils.getFakeDiscoNode(shardRouting.currentNodeId()));  
            )
            TimeValue.timeValueSeconds(60),
        assertThat(request.processedOnReplicas, equalTo(expectedReplicas));  
        @Override
        builder.addShard(primaryShard);  
        op.execute();  
        final Set<String> untrackedShards = new HashSet<>();  
import org.opensearch.cluster.routing.AllocationId;  
                retryTimeout,  
        final AtomicBoolean primaryFailed = new AtomicBoolean();  
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());
        builder.addShard(primaryShard);  
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
        );  
            replicationTargets.stream().map(sh -> sh.allocationId().getId()).collect(Collectors.toSet()).containsAll(inSyncAllocationIds)
        Set<AllocationId> activeIds = new HashSet<>();
        );  
        assertTrue(  
                ReplicationMode.PRIMARY_TERM_VALIDATION,
        activeIds.stream().filter(aId -> !aId.equals(primaryId)).forEach(aId -> {
            ShardRoutingState.STARTED,
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());  
            new FanoutReplicationProxy<>(new TestReplicaProxy())
    }
                retryTimeout,  
                buildRemoteStoreEnabledDiscoveryNodes(routingTable),  
        final Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
                primaryFailed.set(true);  
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());  
                        throw new NullPointerException();  
                ShardRouting replica,
    public void testPrimaryClosedDuringPrimaryTermValidationTriggersRetry() throws Exception {
        @Override
            initialState = ClusterState.builder(initialState)
            RoutingTable.builder().add(IndexRoutingTable.builder(indexMetadata.getIndex()).addIndexShard(indexShardRoutingTable)).build()  
        } catch (ExecutionException ex) {
        TestPrimary(ShardRouting routing, Supplier<ReplicationGroup> replicationGroupSupplier, ThreadPool threadPool) {
                true  
            request,  
        }
            public void failShard(String message, Exception exception) {  
                } else {
            knownLocalCheckpoints.put(allocationId, checkpoint);
        }  
                listener,
                final long generatedLocalCheckpoint = random().nextLong();
            return routing;
            ReplicationProxy<Request> replicationProxy
        final String index = "test";
                String message,
            boolean added = request.processedOnReplicas.add(replica);  
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(indexShardRoutingTable);
        IndexShardRoutingTable routingTable = builder.build();
        indexShardRoutingTable = indexShardRoutingBuilder.build();  
import org.opensearch.threadpool.TestThreadPool;
        }  
        final Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, initialState, trackedShards);
        assertThat("request was not processed on primary", request.processedOnPrimary.get(), equalTo(true));
                }  
        ShardRouting primaryShard,
        initialState = state.build();
                replicasProxy,
import org.apache.logging.log4j.Logger;  
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);
            listener,
        );
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);
            listener,
                }
        final TestPrimary primary = new TestPrimary(primaryShard, replicationGroup::get, threadPool) {  
 * license agreements. See the NOTICE file distributed with
                if (randomBoolean()) {
        final long primaryTerm = initialState.getMetadata().index(shardId.getIndexName()).primaryTerm(shardId.id());
                }
            Request request,
        expectedFailures.put(failedReplica, new CorruptIndexException("simulated", (String) null));
        Set<AllocationId> initializingIds = new HashSet<>();
                if (testPrimaryDemotedOnStaleShardCopies) {
        ShardRoutingState[] replicaStates = new ShardRoutingState[assignedReplicas + unassignedReplicas];
import org.opensearch.action.support.PlainActionFuture;  
        assertTrue("listener is not marked as done", listener.isDone());
                listener,
            );
        // add an in-sync allocation id that doesn't have a corresponding routing entry
                request,
                replicas,  
            }
            }
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures, true);
            long primaryTerm,
        }  
                request,  
            return globalCheckpoint;
        assertEquals(0, replicasProxy.failedReplicas.size());
                primary,
                if (testPrimaryDemotedOnStaleShardCopies) {
                replicasProxy,
            new TestPrimary(primaryShard, () -> initialReplicationGroup, threadPool),  
                    if (trackedShards.contains(shardRouting.allocationId().getId())) {  
        public ShardRouting routingEntry() {  
        final Set<String> trackedShards = new HashSet<>();
        assertEquals(1, request.processedOnReplicas.size());
            final long globalCheckpoint,
        }  
import java.util.List;  
            replicasProxy,
        final ClusterState state = state(index, true, ShardRoutingState.STARTED, replicaStates);  
            )
                true
                "test",
            assertFalse("operations should not have been perform, active shard count is *NOT* met", request.processedOnPrimary.get());
            ActionListener<Void> listener
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);  
            0,
        final ShardId shardId = new ShardId(index, "_na_", 0);
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
            shardId,
        final TestReplicationOperation op = new TestReplicationOperation(
        );
                buildRemoteStoreEnabledDiscoveryNodes(indexShardRoutingTable),  
import org.opensearch.core.common.transport.TransportAddress;  
        );
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));  
        }
        ) {
            }
    }
        @Override  
        ShardId shardId = new ShardId("test", "_na_", 0);
                ShardId shardId,  
        final TestReplicationOperation op = new TestReplicationOperation(  
            .filter(aId -> !aId.equals(primaryId))  
        final ReplicationOperation.Replicas<Request> replicas = new TestReplicaProxy(Collections.emptyMap());
        );  
                    replicationGroup.set(updatedReplicationGroup);
                primaryTerm,  
                logger,
            this(Collections.emptyMap());
                } else {
        }
            index,
            @Override  
        TestReplicaProxy(Map<ShardRouting, Exception> opFailures, boolean retryable) {
                        } else {  
        @Override
                // Only add docrep nodes for allocationIds that are active  
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
    }
        ReplicationGroup initialReplicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);
                if (request.runPostReplicationActionsOnPrimary.compareAndSet(false, true) == false) {
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
                        trackedShards.add(shr.allocationId().getId());  
        super.tearDown();
                boolean criticalFailure = randomBoolean();  
import org.opensearch.cluster.node.DiscoveryNodes;
        ShardId shardId = new ShardId("test", "_na_", 0);  
                true  
            long primaryTerm,  
                attemptsBeforeSuccess = Integer.MAX_VALUE;
                if (shardRouting.unassigned()) {
        final IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
        assertTrue(
            primaryId
            primaryTerm,  
            long primaryTerm,
                replicasProxy,
        final Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, initialState, trackedShards);  
        final Set<String> trackedShards = new HashSet<>();
            Exception exception;
            )
            @Override
                listener,
            0
            long primaryTerm,
        assertEquals(1 + initializingIds.size(), shardInfo.getTotal());  
        }  
        final AtomicBoolean failShardCalled = new AtomicBoolean(false);
                    super.markShardCopyAsStaleIfNeeded(shardId, allocationId, primaryTerm, shardActionListener);
            for (ShardRouting shardRouting : state.routingTable().shardRoutingTable(shardId)) {
            }  
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
            "failShardIfNeeded must not be invoked for PrimaryShardClosedException; the op should fail earlier",
import static org.hamcrest.Matchers.nullValue;
            initialState = ClusterState.builder(initialState)
import static org.hamcrest.Matchers.arrayWithSize;
                false  
            .filter(aId -> !aId.equals(primaryId))
            primary,
        operation.execute();
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo;
import org.opensearch.core.action.ActionListener;  
    }
import static org.hamcrest.Matchers.equalTo;  
                ShardRouting replica,
            logger,  
        assertThat(primary.knownGlobalCheckpoints.remove(primaryShard.allocationId().getId()), equalTo(primary.globalCheckpoint));
            ThreadPool threadPool,
            op.execute();  
                    }
        public AtomicBoolean processedOnPrimary = new AtomicBoolean();
        final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(0);  
                            untrackedShards.add(shr.getTargetRelocatingShard().allocationId().getId());
 * this file be licensed under the Apache-2.0 license or a
        final Set<String> trackedShards = shardRoutingTable.getAllAllocationIds();
            true,  
    public static class Request extends ReplicationRequest<Request> {
        trackedShards.addAll(staleAllocationIds);
                randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.STARTED
        ) {  
            }
        indexMetadataBuilder.settings(Settings.builder().put(indexMetadata.getSettings()).put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1));
                fail("processed [" + request + "] twice");  
        // ReplicationModeAwareProxy. The PrimaryShardClosedException intercept lives in ReplicationOperation's replica
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;  
            fail(msg);  
            1 + assignedReplicas,
            0,  
                request,
        final String index = "test";
        }  
import static org.opensearch.action.support.replication.ReplicationOperation.RetryOnPrimaryException;
        op.execute();
                replicasProxy,
        final int totalShards = 1 + expectedReplicas.size() + unassignedShards.size() + untrackedShards.size();
        @Override  
            }
        // add a search only replica
        final TestReplicationOperation op = new TestReplicationOperation(
            stateWithAddedReplicas = state(  
import java.util.stream.IntStream;
        };
            node.getId(),
                    if (shr.relocating()) {  
            replicasProxy,
                replicasProxy,  
        if (randomBoolean()) {
            new FanoutReplicationProxy<>(replicasProxy)
        Set<String> trackedShards,
            assertThat(op.checkActiveShardCount(), notNullValue());  
                .nodes(DiscoveryNodes.builder(initialState.nodes()).localNodeId(primaryShard.relocatingNodeId()))  
}  
                    builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(shardRouting.currentNodeId()));  
            this(
        final Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, initialState, trackedShards);
            Collections.emptyMap(),
            primaryId
        } else {  
        trackedShards.addAll(staleAllocationIds);
                this.shardInfo = shardInfo;
        );
 * Modifications Copyright OpenSearch Contributors. See  
        final PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();  
                buildRemoteStoreEnabledDiscoveryNodes(routingTable),
        assertEquals(0, request.processedOnReplicas.size());
        }
        return new Tuple<>(docrepNodes, builder.build());
        // Generating data nodes in mixed mode wherein some of the allocated replicas
                ShardStateAction.SHARD_FAILED_ACTION_NAME,
                Exception exception,
            listener.onResponse(new Result(request));
                replicasProxy,
                buildDiscoveryNodes(routingTable),  
            replicasProxy,  
        assertThat(shardInfo.getFailed(), equalTo(0));
        addTrackingInfo(shardRoutingTable, null, trackedShards, new HashSet<>());
                final long generatedGlobalCheckpoint = random().nextLong();  
    }
            if (randomBoolean()) {
        Request request = new Request(shardId);  
    }  
            primaryId
        final ShardRouting closedReplica = expectedReplicas.iterator().next();  
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());
        }  
        final String index = "test";
        for (int i = assignedReplicas; i < replicaStates.length; i++) {
            public void perform(Request request, ActionListener<Result> listener) {
        IndexShardRoutingTable routingTable = builder.build();
            } else {
        final IndexShardRoutingTable shardRoutingTable = state.routingTable().index(index).shard(shardId.id());
        );
        final Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, initialState, trackedShards);
                assertTrue(primaryFailed.compareAndSet(false, true));
            public void runPostReplicationActions(ActionListener<Void> listener) {  
                    t = new CorruptIndexException("simulated", (String) null);
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
            listener,
            request.waitForActiveShards(),  
            ThreadPool threadPool,
        final long primaryTerm = indexMetadata.primaryTerm(0);  
        TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);  
            public void markShardCopyAsStaleIfNeeded(
        ShardInfo shardInfo = listener.actionGet().getShardInfo();
            primaryShard = primaryShard.getTargetRelocatingShard();
        assertTrue("listener is not marked as done", listener.isDone());
        state.metadata(Metadata.builder().put(indexMetadataBuilder.build(), false));
        assertTrue("listener is not marked as done", listener.isDone());
                .nodes(DiscoveryNodes.builder(initialState.nodes()).localNodeId(primaryShard.relocatingNodeId()))
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;  
                cause = new ConnectTransportException(node, "broken");
        // Listener should be invoked for initializing Ids, primary and the operations on docrep nodes  
            shardId,
        for (int i = 0; i < assignedReplicas; i++) {
                String message,
            ShardRoutingState.STARTED,
        final ShardInfo shardInfo = listener.actionGet().getShardInfo();
        final ShardId shardId = new ShardId(index, "_na_", 0);  
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);  
            if (request.processedOnPrimary.compareAndSet(false, true) == false) {
            aId -> builder.addShard(newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId))
            request,
        Set<AllocationId> initializingIds = new HashSet<>();
        public PendingReplicationActions getPendingReplicationActions() {  
                assertThat(exception, instanceOf(ShardStateAction.NoLongerPrimaryShardException.class));
        );
                );
                primary,  
        public long globalCheckpoint() {  
                if (shr.initializing()) {
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());
        inSyncAllocationIds = stateWithAddedReplicas.metadata().index(index).inSyncAllocationIds(0);
        ShardId shardId = new ShardId("test", "_na_", 0);
    <T> void assertListenerThrows(String msg, PlainActionFuture<T> listener, Class<?> klass) throws InterruptedException {  
        assertEquals(2 + initializingIds.size(), shardInfo.getTotal());
        final ClusterState state = stateWithActivePrimary(index, true, 1, 0);
        final long globalCheckpoint;
        AllocationId primaryId = activeIds.iterator().next();
            () -> initialReplicationGroup,  
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());
import java.net.InetAddress;
            this.waitForActiveShards = ActiveShardCount.NONE;  
                }
    }
import org.opensearch.index.shard.PrimaryShardClosedException;  
        };
                    "primary post replication actions should run after replication",
            // If replication is not retryable OR this is the first attempt, the post replication actions
                assertNull(generatedLocalCheckpoints.put(allocationId, generatedLocalCheckpoint));
        }
import java.util.Set;
                return shardInfo;
        Set<AllocationId> activeIds = new HashSet<>();  
import org.opensearch.cluster.metadata.Metadata;
        final Map<String, Long> knownGlobalCheckpoints = Collections.synchronizedMap(new HashMap<>());  
            true,  
        BiFunction<TestReplicaProxy, IndexShardRoutingTable, ReplicationProxy<Request>> proxyFactory  
            @Override  
 * compatible open source license.
            ShardRoutingState.STARTED  
                assertFalse(
        TestReplicationOperation(
        Set<AllocationId> activeIds = new HashSet<>();
        assertThat(primary.knownGlobalCheckpoints, equalTo(replicasProxy.generatedGlobalCheckpoints));
            return "Request{}";  
        Set<AllocationId> initializingIds = new HashSet<>();  
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();  
        initializingIds.forEach(aId -> {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                final String allocationId = replica.allocationId().getId();
                if (localNodeId.equals(shardRouting.currentNodeId()) == false) {
                long primaryTerm,
import org.opensearch.core.common.breaker.CircuitBreaker;
        final ClusterState stateWithAddedReplicas;
            }  
            this.routing = routing;  
        for (ShardRouting shardRouting : routingTable) {
                Exception exception,
                ActionListener<Void> shardActionListener  
                }  
            replicasProxy,
 * You may obtain a copy of the License at  
            this.pendingReplicationActions = new PendingReplicationActions(routing.shardId(), threadPool);
        }  
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
        shardRoutingTable = stateWithAddedReplicas.getRoutingTable().shardRoutingTable(shardId);
import org.opensearch.common.util.set.Sets;
    private DiscoveryNodes buildRemoteStoreEnabledDiscoveryNodes(IndexShardRoutingTable routingTable) {  
        // are in docrep nodes whereas others are on remote enabled ones  
        initializingIds.forEach(aId -> {
        assertThat(shardInfo.getSuccessful(), equalTo(1 + getExpectedReplicas(shardId, state, trackedShards).size()));
                return request;  
public class ReplicationOperationTests extends OpenSearchTestCase {  
        final boolean passesActiveShardCheck = activeShardCount <= assignedReplicas + 1;
            );
        }  
        final Set<String> staleAllocationIds = Sets.newHashSet(randomAlphaOfLength(10));
        final IndexMetadata indexMetadata = state.getMetadata().index(index);
                }
        final ShardRouting primaryShard = newShardRouting(
            final long primaryTerm,
import org.opensearch.transport.RemoteTransportException;
        initializingIds.forEach(
        );
            shardId,  
        IndexShardRoutingTable routingTable = builder.build();
            // keep things simple
        assertEquals(0, replicasProxy.failedReplicas.size());
            listener,
        // Remote-store write path: primary writes to remote, replicas receive only primary-term validation requests via  
        ) {  
        assertTrue(
        final Set<String> markedAsStaleCopies = ConcurrentCollections.newConcurrentSet();
        }
                exception = cause;
        }
                if (shardRouting.relocating() && localNodeId.equals(shardRouting.relocatingNodeId()) == false) {
import static org.hamcrest.Matchers.instanceOf;
        activeIds.stream()
            pendingReplicationActions.accept(getReplicationGroup());
        assertTrue("listener is not marked as done", listener.isDone());  
            public ShardInfo getShardInfo() {
            throw new AssertionError("should shouldn't be failed with [" + message + "]", exception);  
            this(opFailures, false);
            ShardRouting replica,
import org.opensearch.index.shard.IndexShardNotStartedException;  
        final ShardId shardId = new ShardId(index, "_na_", 0);  
            @Override
        ) {  
        public String toString() {
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
            Replicas<Request> replicas,  
            listener.get();
        final ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
            TimeValue retryTimeout,
        );
            }
 * KIND, either express or implied.  See the License for the
            final ActionListener<ReplicationOperation.ReplicaResponse> listener
        final Map<String, Long> knownLocalCheckpoints = Collections.synchronizedMap(new HashMap<>());
            } else {
    }  
                        if (primaryShard == shr.getTargetRelocatingShard() || randomBoolean()) {
        final TestReplicationOperation op = new TestReplicationOperation(
                String allocationId,
        );  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    private void addTrackingInfo(
        final Set<ShardRouting> expectedReplicas = initial.stream().filter(shr -> shr.isSearchOnly() == false).collect(Collectors.toSet());
        op.execute();
    static class ReplicaResponse implements ReplicationOperation.ReplicaResponse {  
                long primaryTerm,  
        public void performOn(
        simulatedFailures.put(closedReplica, new PrimaryShardClosedException(shardId));
        assertThat("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get(), equalTo(true));
                ReplicationMode.NO_REPLICATION,
                opType,
            replicas,  
                replicationProxy
            assertThat(ex.getCause(), instanceOf(klass));
            replicaStates[i] = randomFrom(ShardRoutingState.STARTED, ShardRoutingState.RELOCATING);  
        for (ShardRouting shardRouting : routingTable) {
        final IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
                primary,
                    if (trackedShards.contains(shardRouting.getTargetRelocatingShard().allocationId().getId())) {  
            builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(shardRouting.currentNodeId()));  
import org.opensearch.core.index.shard.ShardId;
        initializingIds.forEach(
        final Request request = new Request(shardId);
        final Set<String> staleAllocationIds = Sets.newHashSet(generateRandomStringArray(4, 10, false));
        super.setUp();  
        for (ShardRouting shardRouting : routingTable) {
            final long maxSeqNoOfUpdatesOrDeletes,  
                "test",  
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();
            this.maxSeqNoOfUpdatesOrDeletes = randomNonNegativeLong();
        private final boolean retryable;
            ReplicationProxy<Request> replicationProxy  
        IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(shardId);
            return replicationGroupSupplier.get();
            if (shr.unassigned() == false) {  
        TestReplicationOperation(
            DiscoveryNode node = new DiscoveryNode("foo", buildNewFakeTransportAddress(), Version.CURRENT);
            Logger logger,  
        builder.addShard(primaryShard);
            }  
            nodeIdFromAllocationId(relocationTargetId),
                    cause = new OpenSearchRejectedExecutionException("rejected");
                attemptsBeforeSuccess = randomInt(2) + 1;  
            final Request request,  
        return "n-" + allocationId.getId().substring(0, 8);
        final Set<ShardRouting> failedReplicas = ConcurrentCollections.newConcurrentSet();
                    reportedFailures.put(replica, t);  
        assertEquals(0, replicasProxy.markedAsStaleCopies.size());  
            int n = attemptsNumber.incrementAndGet();
            this.globalCheckpoint = globalCheckpoint;  
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);
                listener.onResponse(null);
        for (ShardRouting replica : expectedReplicas) {  
                simulatedFailures.put(replica, t);
/*  
    static String nodeIdFromAllocationId(final AllocationId allocationId) {
            Result(Request request) {  
    ) {
import static org.hamcrest.Matchers.notNullValue;  
        final Supplier<ReplicationGroup> replicationGroupSupplier;  
        public long localCheckpoint() {
            public void failShardIfNeeded(
        }
        assertThat(replicationGroup.toString(), shardInfo.getTotal(), equalTo(totalShards));
        assertThat(shardInfo.getSuccessful(), equalTo(1 + expectedReplicas.size()));  
                    } else {
import org.opensearch.common.collect.Tuple;
                exception = new RemoteTransportException("remote", cause);  
        assertThat(replicasProxy.markedAsStaleCopies, equalTo(staleAllocationIds));  
            super(shardId);
            new ReplicationModeAwareProxy<>(
                threadPool,
            }  
    }
        );  
        final ReplicationGroup replicationGroup = new ReplicationGroup(  
            ShardRoutingState.RELOCATING,
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(new HashMap<>());
            RetryOnPrimaryException.class
        );
        ClusterState initialState = stateWithActivePrimary(index, true, randomInt(5));
            builder.addShard(routing);
            primary,
        assertEquals(initializingIds.size() + activeIds.size(), shardInfo.getTotal());
            @Override  
                    super.updateLocalCheckpointForShard(allocationId, checkpoint);  
        final int unassignedReplicas = randomInt(2);
        final TestPrimary primary = new TestPrimary(primaryShard, () -> replicationGroup, threadPool);  
        final ShardRouting primaryShard = newShardRouting(
        TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures);  
                    request.runPostReplicationActionsOnPrimary.get()  
            nodeIdFromAllocationId(primaryId),
            1 + assignedReplicas + unassignedReplicas,
import java.util.Map;
        final TestReplicationOperation op = new TestReplicationOperation(
        }
        assertListenerThrows("should throw exception to trigger retry", listener, RetryOnPrimaryException.class);
            TimeValue.timeValueMillis(20),
        ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
                    continue;  
        }
        final ShardId shardId = new ShardId(index, "_na_", 0);  
            replicasProxy,  
    public void testReplication() throws Exception {
        public void perform(Request request, ActionListener<Result> listener) {
    }
        // Only docrep nodes should have the request fanned out to
                listener,
            replicasProxy,
        if (passesActiveShardCheck) {
            this(
        ShardId shardId = new ShardId("test", "_na_", 0);  
        public ReplicationGroup getReplicationGroup() {
        assertEquals(0, replicasProxy.failedReplicas.size());  
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();  
    private void runPrimaryClosedDuringReplicationTest(
        Set<String> inSyncAllocationIds = activeIds.stream().map(AllocationId::getId).collect(Collectors.toSet());  
            primaryShard = primaryShard.getTargetRelocatingShard();  
        Set<ShardRouting> expectedReplicas = getExpectedReplicas(shardId, stateWithAddedReplicas, trackedShards);  
        assertTrue("post replication operations not run on primary", request.runPostReplicationActionsOnPrimary.get());
            primary,
                builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(shardRouting.currentNodeId()));
        final long primaryTerm = indexMetadata.primaryTerm(0);  
            replicasProxy,  
        );  
                        }
            new FanoutReplicationProxy<>(replicasProxy)  
            listener,
                fail("replica [" + replica + "] was failed twice");
            Replicas<Request> replicas,
            } else {
        IndexShardRoutingTable shardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);
import org.opensearch.cluster.node.DiscoveryNodeRole;
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> activeIds.add(AllocationId.newInitializing()));  
            }
        addTrackingInfo(indexShardRoutingTable, primaryShard, trackedShards, new HashSet<>());
        }
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();
 * SPDX-License-Identifier: Apache-2.0
        } else {
            // If this is a retryable scenario and this is the second try, we finish successfully  
        if (state.routingTable().hasIndex(shardId.getIndexName())) {  
            ActionListener<TestPrimary.Result> listener,
            true,
                .build();  
    @Override
                    if (randomBoolean()) {
                }  
            ShardRoutingState.STARTED,
            threadPool
        public void markShardCopyAsStaleIfNeeded(ShardId shardId, String allocationId, long primaryTerm, ActionListener<Void> listener) {  
        initializingIds.forEach(
        IndexShardRoutingTable indexShardRoutingTable,  
        assertFalse(replicationGroup.getReplicationTargets().stream().anyMatch(ShardRouting::isSearchOnly));
        final ShardRouting primaryShard = newShardRouting(  
    }
        );  
        IntStream.range(0, randomIntBetween(2, 5)).forEach(x -> initializingIds.add(AllocationId.newInitializing()));
            replicasProxy,
                logger,  
            if (markedAsStaleCopies.add(allocationId) == false) {
        IndexMetadata indexMetadata = initialState.getMetadata().index(index);  
        Request request = new Request(shardId);
            // should not have run.
        } else {
            return pendingReplicationActions;
                } else {
        Request(ShardId shardId) {  
        @Override  
            this.opFailures = opFailures;  
    }  
            passesActiveShardCheck ? "succeed" : "retry",  
        public void failShardIfNeeded(  
/*
import org.opensearch.cluster.routing.TestShardRouting;  
        op.execute();  
        TestReplicationOperation operation = new TestReplicationOperation(
            nodeIdFromAllocationId(primaryId),
                replicas,
        final Set<String> trackedShards = new HashSet<>();
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
import java.util.HashMap;
        final ReplicationGroup initialReplicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);  
            } else {
                    logger.debug("--> state after primary operation:\n{}", replicationGroup.get());
        );
import org.opensearch.cluster.ClusterState;
        assertTrue("request was not processed on primary", request.processedOnPrimary.get());
            assertFalse(primaryFailed.get());
            request,
        AllocationId primaryId = activeIds.iterator().next();
        final TestReplicaProxy replicasProxy = new TestReplicaProxy(simulatedFailures) {
            public Request replicaRequest() {
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
            assertTrue(primaryFailed.get());  
            @Override
 * under the License.  
        ReplicationGroup replicationGroup = new ReplicationGroup(routingTable, inSyncAllocationIds, inSyncAllocationIds, 0);
            }  
            replicasProxy,  
        assertThat(primary.knownLocalCheckpoints, equalTo(replicasProxy.generatedLocalCheckpoints));  
            long primaryTerm,  
            final ShardRouting replica,
        }
        final ShardRouting failedReplica = randomFrom(new ArrayList<>(expectedReplicas));
        );
        final ClusterState initialState = stateWithActivePrimary(index, true, 0);  
        Map<ShardRouting, Exception> simulatedFailures = new HashMap<>();
                        expectedReplicas.add(shardRouting);
                ActionListener<Void> shardActionListener  
                    }  
import java.util.function.Supplier;
        assertEquals(inSyncAllocationIds.size(), replicationTargets.size());  
            listener,
        AllocationId primaryId = activeIds.iterator().next();
        IndexShardRoutingTable indexShardRoutingTable = initialState.getRoutingTable().shardRoutingTable(shardId);  
        final PendingReplicationActions pendingReplicationActions;
        state.nodes(DiscoveryNodes.builder(initialState.nodes()).add(node).build());  
import java.util.HashSet;
import org.opensearch.index.shard.IndexShardState;
        });
        Set<AllocationId> activeIds = new HashSet<>();
            primary,
            listener,
            request,
            indexMetadata.primaryTerm(0),
    }
        addTrackingInfo(shardRoutingTable, null, trackedShards, new HashSet<>());
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();
import org.opensearch.cluster.node.DiscoveryNode;  
        runPrimaryClosedDuringReplicationTest(  
        indexShardRoutingBuilder.addShard(searchShardRouting);
        TestReplicationOperation(
                shardActionListener.onResponse(null);  
            );
            Request request,  
        final long localCheckpoint;
        DiscoveryNode node = new DiscoveryNode(
        if (primaryShard.relocating() && randomBoolean()) {  
import org.apache.lucene.store.AlreadyClosedException;
                TimeValue.timeValueSeconds(1),
        runPrimaryClosedDuringReplicationTest((replicasProxy, indexShardRoutingTable) -> new FanoutReplicationProxy<>(replicasProxy));
        for (ShardRouting replica : expectedReplicas) {  
            new ReplicationModeAwareProxy<>(ReplicationMode.NO_REPLICATION, discoveryNodesDetails.v2(), replicasProxy, replicasProxy, false)  
        }
        List<ShardRouting> replicationTargets = replicationGroup.getReplicationTargets();  
            primary,
            ShardRouting routing = newShardRouting(shardId, nodeIdFromAllocationId(aId), null, false, ShardRoutingState.INITIALIZING, aId);  
                builder.add(IndexShardTestUtils.getFakeRemoteEnabledNode(shardRouting.currentNodeId()));  
import java.util.concurrent.atomic.AtomicReference;  
        }
import org.apache.lucene.index.CorruptIndexException;
        final TestReplicationOperation op = new TestReplicationOperation(
    }  
        final ShardRouting primaryRouting = state.getRoutingTable().shardRoutingTable(shardId).primaryShard();
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();  
    }  
                threadPool,
        // PendingReplicationActions.close() does to in-flight replica requests when IndexShard closes.  
                failShardCalled.set(true);
            primary,
                replicasProxy,
        assertThat("request was not processed on primary", request.processedOnPrimary.get(), equalTo(true));  
            request,  
                    } else {
            primaryTerm,
        assertEquals(activeIds.size() - 1, request.processedOnReplicas.size());  
        );
            }
        op.execute();
        final int assignedReplicas = randomInt(2);
        PlainActionFuture<TestPrimary.Result> listener = new PlainActionFuture<>();
        // add a few in-sync allocation ids that don't have corresponding routing entries
