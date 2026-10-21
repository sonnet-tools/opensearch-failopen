        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        return onePrimaryOnNode1And1Replica(deciders, indexSettings, Settings.EMPTY, reason);
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        protected boolean hasInitiatedFetching(ShardRouting shard) {
        allocation = onePrimaryOnNode1And1Replica(
            UnassignedInfo.Reason.NODE_LEFT
    static RetentionLease newRetentionLease(DiscoveryNode node, long retainingSeqNo) {
import java.util.HashMap;
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
     * the shard allocator to allocate it. There isn't a copy around to find anyhow.
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
                        Settings.EMPTY,
        }
        );
     */
            unassignedInfo = new UnassignedInfo(
                retentionLeases.add(newRetentionLease(node2, randomLongBetween(0, retainingSeqNoOnPrimary)));
                    new AllocationDecider() {
            .add(
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
                                        null,
                }
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
            .addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
                node,
 * the Apache License, Version 2.0 (the "License"); you may
        allocateAllUnassigned(allocation);
                            .addShard(
                    .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()))
                UnassignedInfo.Reason.ALLOCATION_FAILED,
            .addData(node2, "NO_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1)).build(),
            .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()));
import org.opensearch.cluster.routing.RoutingNodes;
     * Tests when the node to allocate to due to matching is being throttled, we move the shard to ignored
            retentionLeases.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNo)));
        }
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
     */
                {
        UnassignedInfo.Reason reason
/*
            }
                    .numberOfShards(1)
                    ),
import org.opensearch.cluster.routing.allocation.decider.Decision;
    /**
            null,
                System.currentTimeMillis(),
        UnassignedInfo.Reason reason
            Map<DiscoveryNode, TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> tData = null;
        } else {
            .metadata(metadata)
            yesAllocationDeciders(),
            ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
                System.nanoTime(),
                                        System.nanoTime(),
        failedNodes.add(node3.getId());
                        }
    public void testNotCancellingRecoveryIfSyncedOnExistingRecovery() {
        assertThat(
        // mark shard as delayed if reason is NODE_LEFT
     * unassigned to be allocated later on.
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
import org.opensearch.cluster.routing.ShardRouting;
        testAllocator.processExistingRecoveries(allocation);
        testAllocator.addData(node2, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        return randomFrom("MATCH", "NOT_MATCH", null);
                            .addShard(
        testAllocator.addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
    @Before
        RoutingTable routingTable = RoutingTable.builder()
                    .addIndexShard(
                IndexMetadata.builder(shardId.getIndexName())
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            for (StoreFileMetadata file : files) {
    }
            SnapshotShardSizeInfo.EMPTY,
        List<RetentionLease> retentionLeases = Arrays.asList(
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            .addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
     * When we can't find primary data, but still find replica data, we go ahead and keep it unassigned
        }
import org.opensearch.common.settings.Settings;
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.STARTED);
        );
        testAllocator.addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
     */
    private RoutingAllocation onePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders, UnassignedInfo unassignedInfo) {
    /**
        assertThat(unassignedShards.get(0).unassignedInfo().getNumFailedAllocations(), equalTo(0));
                null,
            node1,
            retentionLeases,
import static org.hamcrest.Matchers.equalTo;
    }
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
        );
            return fetchDataCalled.getAndSet(false);
                                        System.currentTimeMillis(),
     * See CorruptFileTest#
    /**
                    )
                    new SameShardAllocationDecider(
                    new TestAllocateDecision(Decision.YES),
    public void testSimpleFullMatchAllocation() {
    }
        List<ShardRouting> unassignedShards = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);
    public void testNoMatchingFilesForReplicaOnAnyNode() {
    }
import org.opensearch.cluster.ClusterState;
            System.nanoTime()
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            randomNonNegativeLong(),
        allocateAllUnassigned(allocation);
            .build();
     * When there is no decision or throttle decision across all nodes for the shard, make sure the shard
            equalTo(node2.getId())
        allocateAllUnassigned(allocation);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
import java.util.HashSet;
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
                IndexRoutingTable.builder(shardId.getIndex())
        testAllocator.addData(node2, null); // has retention lease but store is empty
import static java.util.Collections.unmodifiableMap;
    static String randomSyncId() {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
     */
            DiscoveryNode node,
 *
        public void cleanWithEmptyData() {
                    .numberOfReplicas(1)
            List<RetentionLease> peerRecoveryRetentionLeases,
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
 *    http://www.apache.org/licenses/LICENSE-2.0
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
        if (randomBoolean()) {
    }
            deciders,
                data = new HashMap<>();
                null,
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
            if (data != null) {
            .addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
    }
            .metadata(metadata)
 * this file be licensed under the Apache-2.0 license or a
            newRetentionLease(node2, retainingSeqNoForNode2),
    /**
            randomIntBetween(failedNodes.size(), 10),
 * under the License.
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
 *
            failedNodes.add("node4");
        if (randomBoolean()) {
                            if (node.node().equals(node2)) {
                                return Decision.THROTTLE;
        private Map<DiscoveryNode, StoreFilesMetadata> data = null;
                new StoreFilesMetadata(
import org.opensearch.cluster.routing.RoutingNode;
            )
            data.put(
        assertThat(decision.getAllocationDecision(), equalTo(AllocationDecision.ALLOCATION_DELAYED));
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata;
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
import org.opensearch.snapshots.SnapshotShardSizeInfo;
/*
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
        final UnassignedInfo unassignedInfo;
     * Verifies that when there is a sync id match but no files match, we allocate it to matching node.
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            "MATCH",
    public void testNoAsyncFetchData() {
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
    }
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders(), Settings.EMPTY, reason);
                            .build()
        );
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null);
        allocateAllUnassigned(allocation);
        public void clean() {
import org.opensearch.cluster.routing.UnassignedInfo;
                                    shardId,
            RoutingAllocation allocation
            System.currentTimeMillis(),
                            .build()
                    tData.put(
            node1,
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        testAllocator.addData(
            "MATCH",
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
     */
    public void testIgnoreRetentionLeaseIfCopyIsEmpty() {
                                    node2.getId(),
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
        final UnassignedInfo unassignedInfo;
            if (syncId != null) {
                            )
    private RoutingAllocation onePrimaryOnNode1And1Replica(
        assertThat(
        }
    public void testSyncIdMatch() {
    }
            .settings(settings(Version.CURRENT).put(indexSettings))
        if (randomBoolean()) {
    public void testNotCancellingRecovery() {
import org.opensearch.index.store.Store;
 * Modifications Copyright OpenSearch Contributors. See
        long retainingSeqNoOnPrimary = randomLongBetween(1, Integer.MAX_VALUE);
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null);
        assertThat(
import java.util.Collections;
        testAllocator.clean();
                )
    public void testDelayedAllocationExplainUsesClusterDefault() {
    public void testNoDataForReplicaOnAnyNode() {
                                    RecoverySource.PeerRecoverySource.INSTANCE,
        return onePrimaryOnNode1And1ReplicaRecovering(deciders, new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null));
        );
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        List<RetentionLease> retentionLeases = new ArrayList<>();
                        new TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata(entry.getKey(), entry.getValue())
            randomBoolean() ? noAllocationDeciders() : throttleAllocationDeciders()
            peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNo)));
        return onePrimaryOnNode1And1Replica(deciders, Settings.EMPTY, UnassignedInfo.Reason.CLUSTER_RECOVERED);
        testAllocator.clean();
     */
                                        null,
 */
        );
        assertThat(allocation.routingNodesChanged(), equalTo(false));
    public void testNoAsyncFetchOnIndexCreation() {
                                    unassignedInfo
        testAllocator.processExistingRecoveries(allocation);
        testAllocator.addData(
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            testAllocator.allocateUnassigned(iterator.next(), allocation, iterator);
            .addData(node2, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            equalTo(nodeToMatch.getId())
        final Set<String> failedNodes;
        allocateAllUnassigned(allocation);
    public void testNotCancelIfPrimaryDoesNotHaveValidRetentionLease() {
        AllocateUnassignedDecision decision = testAllocator.makeAllocationDecision(unassignedShard, allocation, testAllocator.logger);
    public void testDelayedAllocation() {
    private static final org.apache.lucene.util.Version MIN_SUPPORTED_LUCENE_VERSION = org.opensearch.Version.CURRENT
            return this;
            .build();
import java.util.ArrayList;
                                )
        int failedAllocations = reason == UnassignedInfo.Reason.ALLOCATION_FAILED ? 1 : 0;
            }
import org.opensearch.cluster.metadata.IndexMetadata;
            });
        );
                }
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        );
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
        ShardRouting unassignedShard = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0);
import static org.hamcrest.Matchers.empty;
        assertThat(
    /**
    /**
                IndexRoutingTable.builder(shardId.getIndex())
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
                randomIntBetween(1, 10),
     * Verifies that when there is a full match (syncId and files) we allocate it to matching node.
            UnassignedInfo.Reason.NODE_LEFT
            SnapshotShardSizeInfo.EMPTY,
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), clusterDelay)
        );
                                    false,
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
    public void testPreferCopyWithHighestMatchingOperations() {
    private RoutingAllocation onePrimaryOnNode1And1Replica(
    }
            );
                                    null,
     * to be allocated. This is today behavior, which relies on a primary corruption identified with
        testAllocator.addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            ReplicationTracker.getPeerRecoveryRetentionLeaseId(node.getId()),
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        }
        }
            failedNodes
                )
    }
import org.opensearch.Version;
 * ownership. Elasticsearch licenses this file to you under
        }
                                ShardRouting.newUnassigned(
        );
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
    private final DiscoveryNode node1 = newNode("node1");
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
            retentionLeases.add(newRetentionLease(node1, retainingSeqNoOnPrimary));
            "MATCH",
            Arrays.asList(newRetentionLease(node1, retainingSeqNo), newRetentionLease(node3, retainingSeqNo)),
                        @Override
            .build();
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
        long retainingSeqNoForNode3 = randomLongBetween(retainingSeqNoForNode2 + 1, retainingSeqNoOnPrimary + 100);
            deciders,
    }
 * license agreements. See the NOTICE file distributed with
        assertThat(allocation.routingNodesChanged(), equalTo(false));
                        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        allocateAllUnassigned(allocation);
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        allocation.debugDecision(true);
import java.util.concurrent.atomic.AtomicBoolean;
    }
                    .addIndexShard(
        testAllocator.processExistingRecoveries(allocation);
            ClusterInfo.EMPTY,
package org.opensearch.gateway;
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.STARTED);
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            .routingTable(routingTable)
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
    }
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        }
        } else {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
        if (randomBoolean()) {
            return addData(node, Collections.emptyList(), syncId, files);
    }
     * Verifies that when we are still fetching data in an async manner, the replica shard moves to ignore unassigned.
    }
                                        reason,
        return new RoutingAllocation(
            Collections.singletonList(newRetentionLease(node3, randomNonNegativeLong())),
            "MATCH",
            .addData(node2, "NO_MATCH", new StoreFileMetadata("file1", 10, "NO_MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
                    peerRecoveryRetentionLeases
            false,
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
            .add(
        testAllocator.clean();
                randomIntBetween(1, 10),
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            node1,
                    )
            node1,
        assertThat(decision.getConfiguredDelayInMillis(), equalTo(clusterDelay.millis()));
            Settings.EMPTY,
    public void testNoOrThrottleDecidersRemainsInUnassigned() {
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            long retainingSeqNoOnPrimary = randomLongBetween(0, Long.MAX_VALUE);
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
            .addData(nodeToMatch, "MATCH", new StoreFileMetadata("file1", 10, "NO_MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
    public void buildTestAllocator() {
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
            equalTo(node3.getId())
            )
        while (iterator.hasNext()) {
        if (randomBoolean()) {
        long retainingSeqNoForNode2 = randomLongBetween(0, retainingSeqNoOnPrimary - 1);
        );
            node1,
import org.opensearch.cluster.routing.RecoverySource;
            yesAllocationDeciders(),
        assertThat(
        .minimumIndexCompatibilityVersion().luceneVersion;
                false,
import java.util.Arrays;
        }
 * You may obtain a copy of the License at
        testAllocator.addData(node2, "NOT_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            String syncId,
            .numberOfReplicas(1)
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
            random(),
            .put(
            new RoutingNodes(state, false),
    public void testThrottleWhenAllocatingToMatchingNode() {
        testAllocator.addData(
            node1,
        }
 * this work for additional information regarding copyright
     * unassigned to be allocated later on.
            equalTo(node3.getId())
     */
     * Verifies that when there is primary data, but no data at all on other nodes, the shard keeps
    public void testNoPrimaryData() {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED), empty());
                                    false,
            null,
 * GitHub history for details.
    }
        Settings nodeSettings = Settings.builder()
                UnassignedInfo.Reason.ALLOCATION_FAILED,
                retentionLeases.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNoOnPrimary)));
        }
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            testAllocator.addData(node2, null);
            randomSyncId(),
        );
            Map<String, String> commitData = new HashMap<>();
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
                                    )
    ) {
            equalTo(nodeToMatch.getId())
            "MATCH",
        assertThat(decision.getRemainingDelayInMillis() <= clusterDelay.millis(), equalTo(true));
                                )
                            return Decision.YES;
    }
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        assertThat(
    }
 */
            Map<String, StoreFileMetadata> filesAsMap = new HashMap<>();
                commitData.put(Engine.SYNC_COMMIT_ID, syncId);
            UnassignedInfo.Reason.INDEX_CREATED
    /**
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
                                        Collections.emptySet()
    private RoutingAllocation onePrimaryOnNode1And1Replica(AllocationDeciders deciders) {
    }
                null,
            fetchDataCalled.set(true);
                tData = new HashMap<>();
            yesAllocationDeciders(),
        );
     * Verifies that when there is primary data, but no matching data at all on other nodes, the shard keeps
                                        UnassignedInfo.AllocationStatus.NO_ATTEMPT,
 * The OpenSearch Contributors require contributions made to
        testAllocator.addData(
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
import org.opensearch.cluster.routing.TestShardRouting;
        Settings nodeSettings,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
    private final DiscoveryNode node3 = newNode("node3");
        testAllocator.addData(
        ) {
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
     */
import java.util.Set;
            "MATCH",
        // Rarely use a seqNo above retainingSeqNoOnPrimary, which could in theory happen when primary fails and comes back quickly.
    private TestAllocator testAllocator;
            return new AsyncShardFetch.FetchResult<>(tData, new HashMap<>() {
        );
            failedNodes = new HashSet<>(randomSubsetOf(Arrays.asList("node-4", "node-5", "node-6")));
            ClusterInfo.EMPTY,
            ShardRouting shard,
import org.opensearch.cluster.routing.allocation.AllocationDecision;
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
        private AtomicBoolean fetchDataCalled = new AtomicBoolean(false);
    }
            )
 * compatible open source license.
            .build();
    }
                            )
            Settings.EMPTY,
            // we sometime return empty list of files, make sure we test this as well
                    put(shardId, Collections.emptySet());
            }
        testAllocator.addData(
            newRetentionLease(node1, retainingSeqNoOnPrimary),
        );
        allocateAllUnassigned(allocation);
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
    }
import org.opensearch.common.unit.TimeValue;
            newRetentionLease(node3, retainingSeqNoForNode3)
        if (randomBoolean()) {
            .addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        );
            yesAllocationDeciders(),
     * to wait till throttling on it is done.
            retentionLeases,
            UnassignedInfo.Reason.ALLOCATION_FAILED,
 * not use this file except in compliance with the License.
    /**
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AllocationDeciders deciders,
    private void allocateAllUnassigned(final RoutingAllocation allocation) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            System.nanoTime(),
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
            .numberOfShards(1)
        allocateAllUnassigned(allocation);
            equalTo(nodeToMatch.getId())
import org.opensearch.common.settings.ClusterSettings;
            }
    public void testAsyncFetchOnAnythingButIndexCreation() {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
        long retainingSeqNoOnPrimary = randomLongBetween(0, Long.MAX_VALUE);
            failedNodes = Collections.emptySet();
        testAllocator.addData(node2, "NO_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
 * Licensed to Elasticsearch under one or more contributor
            .addData(nodeToMatch, "NO_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        allocateAllUnassigned(allocation);
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            node1,
        allocateAllUnassigned(allocation);
     * adding a replica and having that replica actually recover and cause the corruption to be identified
            )
            state,
                                    ShardRoutingState.INITIALIZING,
            retainingSeqNo,
        allocateAllUnassigned(allocation);
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
                                TestShardRouting.newShardRouting(
        }
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                    }
                                        failedAllocations,
        );
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
     * moves to the ignore unassigned list.
        testAllocator.addData(node3, "NOT_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        List<RetentionLease> peerRecoveryRetentionLeasesOnPrimary = new ArrayList<>();
        assertThat(testAllocator.getFetchDataCalledAndClean(), equalTo(false));
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        assertThat(unassignedShards.get(0).unassignedInfo().getFailedNodeIds(), equalTo(failedNodes));
 * KIND, either express or implied.  See the License for the
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardId.getIndexName())
            StoreFileMetadata... files
            if (randomBoolean()) {
    private RoutingAllocation onePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders) {
    public void testCancelRecoveryBetterSyncId() {
        retentionLeases.add(newRetentionLease(node1, retainingSeqNo));
                        entry.getKey(),
 * Unless required by applicable law or agreed to in writing,
        );
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
    }
    ) {
import org.opensearch.index.engine.Engine;
            if (data == null) {
        testAllocator.addData(
import org.opensearch.cluster.ClusterInfo;
                System.nanoTime(),
                Collections.singleton("node-4")
 * specific language governing permissions and limitations
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
            );
        Metadata metadata = Metadata.builder().put(indexMetadata).build();
        Set<String> failedNodes = new HashSet<>();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            .build();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat("failed with reason " + reason, testAllocator.getFetchDataCalledAndClean(), equalTo(true));
        Settings indexSettings,
        }
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;
        peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node1, retainingSeqNo));
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            return fetchDataCalled.get();
    }
 *
        this.testAllocator = new TestAllocator();
            );
        assertThat(decision.getRemainingDelayInMillis() > 0, equalTo(true));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
    }
            new RoutingNodes(state, false),
                null,
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        );
                                    new UnassignedInfo(
        UnassignedInfo unassignedInfo = new UnassignedInfo(
    public void testDoNotCancelForBrokenNode() {
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
            .routingTable(routingTable)
                                    shardId,
    private final DiscoveryNode node2 = newNode("node2");
            EnumSet.complementOf(EnumSet.of(UnassignedInfo.Reason.INDEX_CREATED))
        allocateAllUnassigned(allocation);
 * SPDX-License-Identifier: Apache-2.0
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
                filesAsMap.put(file.name(), file);
        assertThat(allocation.routingNodesChanged(), equalTo(false));
                false,
        UnassignedInfo.Reason reason = RandomPicks.randomFrom(
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
            new AllocationDeciders(
            }
        );
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        List<RetentionLease> retentionLeases = Arrays.asList(
import static org.hamcrest.Matchers.hasSize;
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
                            }
     */
                for (Map.Entry<DiscoveryNode, StoreFilesMetadata> entry : data.entrySet()) {
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
        return new RetentionLease(
    public void testFileChecksumMatch() {
        if (randomBoolean()) {
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
        AllocationDeciders deciders,
        testAllocator.processExistingRecoveries(allocation);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
}
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
import org.opensearch.cluster.routing.IndexRoutingTable;
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
            peerRecoveryRetentionLeasesOnPrimary,
    private final ShardId shardId = new ShardId("test", "_na_", 0);
            }
     * and find a better copy for the shard.
        testAllocator.processExistingRecoveries(allocation);
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
    /**
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            retentionLeases,
            .addData(node3, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
        return new RoutingAllocation(
import java.util.Map;
        allocateAllUnassigned(allocation);
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
                Arrays.asList(
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            data = null;
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
                failedNodes
     */
                System.currentTimeMillis(),
                    shardId,
        );
    /**
    /**
 * software distributed under the License is distributed on an
import org.opensearch.common.util.set.Sets;
        allocateAllUnassigned(allocation);
        public TestAllocator addData(DiscoveryNode node, String syncId, StoreFileMetadata... files) {
        }
        testAllocator.processExistingRecoveries(allocation);
    }
import org.opensearch.index.store.StoreFileMetadata;
        }
import org.opensearch.core.index.shard.ShardId;
            .addData(nodeToMatch, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
            state,
                                        delayed,
import java.util.EnumSet;
    class TestAllocator extends ReplicaShardAllocator {
        )
    }
            .build();
        @Override
public class ReplicaShardAllocatorTests extends OpenSearchAllocationTestCase {
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
import org.junit.Before;
 */
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            newRetentionLease(node1, retainingSeqNoOnPrimary),
/*
            nodeSettings,
        assertThat(decision.getAllocationStatus(), equalTo(UnassignedInfo.AllocationStatus.DELAYED_ALLOCATION));
        protected AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetchData(
            && UnassignedInfo.getNodeLeftDelayedTimeout(indexSettings, nodeSettings).nanos() > 0;
        );
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.metadata.Metadata;
                    new Store.MetadataSnapshot(unmodifiableMap(filesAsMap), unmodifiableMap(commitData), randomInt()),
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
     * Verifies that on index creation, we don't go and fetch data, but keep the replica shard unassigned to let
     * Verifies that for anything but index creation, fetch data ends up being called, since we need to go and try
        );
        public boolean getFetchDataCalledAndClean() {
        assertThat(unassignedShards, hasSize(1));
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        TimeValue clusterDelay = TimeValue.timeValueHours(1);
        @Override
            Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1)).build(),
        List<RetentionLease> retentionLeases = new ArrayList<>();
        testAllocator.addData(node2, "NOT_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            UnassignedInfo.Reason.NODE_LEFT
import org.opensearch.index.seqno.RetentionLease;
        peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node2, randomLongBetween(1, retainingSeqNo)));
        TestAllocator addData(
            if (randomBoolean()) {
    }
        assertThat(allocation.routingNodesChanged(), equalTo(false));
import org.opensearch.cluster.node.DiscoveryNodes;
        assertThat(unassignedShards.get(0).shardId(), equalTo(shardId));
        );
            data = new HashMap<>();
    public void testCancelRecoveryIfFoundCopyWithNoopRetentionLease() {
            System.nanoTime(),
        ) {
        retentionLeases.add(newRetentionLease(node2, randomLongBetween(0, retainingSeqNo)));
    }
    }
        testAllocator.processExistingRecoveries(allocation);
    public void testNotCancellingRecoveryIfCurrentRecoveryHasRetentionLease() {
                    );
            retentionLeases,
            newRetentionLease(node3, retainingSeqNoOnPrimary)
            unassignedInfo = new UnassignedInfo(
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
    }
import java.util.List;
        );
                    .settings(settings(Version.CURRENT))
     * Verifies that when there is no sync id match but files match, we allocate it to matching node.
        Settings indexSettings,
            nodeSettings
        boolean delayed = reason == UnassignedInfo.Reason.NODE_LEFT
        allocateAllUnassigned(allocation);
import org.opensearch.index.seqno.ReplicationTracker;
     */
        RoutingTable routingTable = RoutingTable.builder()
import org.opensearch.cluster.routing.ShardRoutingState;
    }
