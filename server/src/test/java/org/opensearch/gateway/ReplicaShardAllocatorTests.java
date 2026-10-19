import org.opensearch.cluster.ClusterInfo;
        RoutingTable routingTable = RoutingTable.builder()
        );
 * specific language governing permissions and limitations
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
    class TestAllocator extends ReplicaShardAllocator {
            deciders,
            )  
            nodeSettings
                }  
 * The OpenSearch Contributors require contributions made to  
        allocateAllUnassigned(allocation);
        );  
        final Set<String> failedNodes;  
    }  
                                    false,
            retentionLeases.add(newRetentionLease(node1, retainingSeqNoOnPrimary));
            if (syncId != null) {  
            );
            .addData(nodeToMatch, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        assertThat(decision.getAllocationDecision(), equalTo(AllocationDecision.ALLOCATION_DELAYED));
        );
            retentionLeases,
import org.opensearch.common.settings.Settings;
    private static final org.apache.lucene.util.Version MIN_SUPPORTED_LUCENE_VERSION = org.opensearch.Version.CURRENT  
import static org.hamcrest.Matchers.empty;
                System.currentTimeMillis(),  
            .addData(nodeToMatch, "NO_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
import org.opensearch.cluster.routing.TestShardRouting;
                }
            Arrays.asList(newRetentionLease(node1, retainingSeqNo), newRetentionLease(node3, retainingSeqNo)),
 * KIND, either express or implied.  See the License for the
            data.put(  
            UnassignedInfo.Reason.NODE_LEFT  
import java.util.Map;
        assertThat(allocation.routingNodesChanged(), equalTo(false));
                UnassignedInfo.Reason.ALLOCATION_FAILED,
        UnassignedInfo.Reason reason  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            .numberOfShards(1)
        long retainingSeqNoForNode3 = randomLongBetween(retainingSeqNoForNode2 + 1, retainingSeqNoOnPrimary + 100);  
        );
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.store.StoreFileMetadata;
        testAllocator.addData(node2, "NOT_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
                    .numberOfReplicas(1)  
                        @Override
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            return fetchDataCalled.getAndSet(false);  
                IndexRoutingTable.builder(shardId.getIndex())  
            state,  
            .add(
        AllocationDeciders deciders,  
        @Override
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;  
import static org.hamcrest.Matchers.equalTo;
            EnumSet.complementOf(EnumSet.of(UnassignedInfo.Reason.INDEX_CREATED))
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                    .addIndexShard(
 */
    }
            );
        List<ShardRouting> unassignedShards = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);  
            newRetentionLease(node3, retainingSeqNoOnPrimary)
        public TestAllocator addData(DiscoveryNode node, String syncId, StoreFileMetadata... files) {  
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.STARTED);
        failedNodes.add(node3.getId());
        );
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
import org.opensearch.cluster.metadata.Metadata;
            Map<String, String> commitData = new HashMap<>();
        protected boolean hasInitiatedFetching(ShardRouting shard) {
        testAllocator.addData(
                    new Store.MetadataSnapshot(unmodifiableMap(filesAsMap), unmodifiableMap(commitData), randomInt()),
     * Verifies that when there is no sync id match but files match, we allocate it to matching node.
                        new TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata(entry.getKey(), entry.getValue())
            new RoutingNodes(state, false),  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            equalTo(nodeToMatch.getId())  
        );  
public class ReplicaShardAllocatorTests extends OpenSearchAllocationTestCase {
            }
            .build();
            failedNodes = Collections.emptySet();
    public void testNoPrimaryData() {  
        assertThat(decision.getRemainingDelayInMillis() > 0, equalTo(true));
            ReplicationTracker.getPeerRecoveryRetentionLeaseId(node.getId()),
    public void testCancelRecoveryBetterSyncId() {  
            .addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
import org.opensearch.index.seqno.RetentionLease;
        List<RetentionLease> retentionLeases = Arrays.asList(
                node,
import static java.util.Collections.unmodifiableMap;  
                            if (node.node().equals(node2)) {
            .build();
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
                false,
        testAllocator.processExistingRecoveries(allocation);  
            "MATCH",
    public void testNotCancellingRecoveryIfCurrentRecoveryHasRetentionLease() {
            ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
        allocateAllUnassigned(allocation);
        private AtomicBoolean fetchDataCalled = new AtomicBoolean(false);
                    )
                            .addShard(  
        }
            UnassignedInfo.Reason.INDEX_CREATED
                                        failedAllocations,  
        assertThat(allocation.routingNodesChanged(), equalTo(false));
    private final DiscoveryNode node3 = newNode("node3");
            "MATCH",
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        return onePrimaryOnNode1And1ReplicaRecovering(deciders, new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null));  
        testAllocator.addData(node2, "NO_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            UnassignedInfo.Reason.NODE_LEFT  
            randomSyncId(),
     */
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
        )  
        assertThat(unassignedShards, hasSize(1));
            String syncId,
     * When we can't find primary data, but still find replica data, we go ahead and keep it unassigned
            unassignedInfo = new UnassignedInfo(
                            .addShard(  
     * Verifies that when there is primary data, but no data at all on other nodes, the shard keeps  
            ClusterInfo.EMPTY,
 * compatible open source license.
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
        }  
    }
            )
    public void testDoNotCancelForBrokenNode() {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED), empty());
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
            return fetchDataCalled.get();  
                commitData.put(Engine.SYNC_COMMIT_ID, syncId);
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
        allocateAllUnassigned(allocation);  
        );  
        testAllocator.addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
                Collections.singleton("node-4")
                Arrays.asList(
                false,
    }
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;  
        final UnassignedInfo unassignedInfo;
            newRetentionLease(node1, retainingSeqNoOnPrimary),
        allocateAllUnassigned(allocation);
import org.opensearch.cluster.node.DiscoveryNode;  
        }
                                    )  
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        ) {  
        testAllocator.processExistingRecoveries(allocation);  
                null,
            // we sometime return empty list of files, make sure we test this as well
        allocation.debugDecision(true);
            if (data != null) {  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders(), Settings.EMPTY, reason);
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            failedNodes
        final UnassignedInfo unassignedInfo;  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                            return Decision.YES;
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;  
 * license agreements. See the NOTICE file distributed with
                null,  
            .addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
    }  
    /**
        testAllocator.addData(
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
            }
    public void testThrottleWhenAllocatingToMatchingNode() {
            if (randomBoolean()) {  
            )
     * unassigned to be allocated later on.
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.STARTED);  
            node1,
     * unassigned to be allocated later on.
        );
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
     * Tests when the node to allocate to due to matching is being throttled, we move the shard to ignored
     */
        testAllocator.addData(  
    static RetentionLease newRetentionLease(DiscoveryNode node, long retainingSeqNo) {  
import org.opensearch.cluster.routing.RoutingTable;
        testAllocator.clean();
            .routingTable(routingTable)
    }
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
    public void testDelayedAllocationExplainUsesClusterDefault() {  
    }  
     * Verifies that for anything but index creation, fetch data ends up being called, since we need to go and try
        testAllocator.addData(node3, "NOT_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            .add(
     */  
                            )
 * You may obtain a copy of the License at  
        Settings nodeSettings = Settings.builder()
    }  
        );  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());  
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null);  
            .build();  
            node1,
                    new SameShardAllocationDecider(  
        return new RoutingAllocation(
            node1,  
            );
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
import org.opensearch.cluster.routing.RoutingNodes;  
            if (randomBoolean()) {  
        }  
            random(),
        );
            });
            newRetentionLease(node3, retainingSeqNoForNode3)
    }  
                tData = new HashMap<>();
    private RoutingAllocation onePrimaryOnNode1And1Replica(  
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);  
    }  
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));  
    public void testNoMatchingFilesForReplicaOnAnyNode() {  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
        retentionLeases.add(newRetentionLease(node2, randomLongBetween(0, retainingSeqNo)));
                    );  
        allocation = onePrimaryOnNode1And1Replica(  
        }
            data = new HashMap<>();
                    put(shardId, Collections.emptySet());
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            }
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
                IndexRoutingTable.builder(shardId.getIndex())  
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());  
                retentionLeases.add(newRetentionLease(node2, randomLongBetween(0, retainingSeqNoOnPrimary)));
                                        Collections.emptySet()
                null,  
                                )
    /**
        } else {  
    private final DiscoveryNode node1 = newNode("node1");  
            "MATCH",
                                        System.currentTimeMillis(),
        testAllocator.clean();
    }
    }
            if (data == null) {
                        Settings.EMPTY,
import org.opensearch.common.util.set.Sets;
 */  
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
            testAllocator.addData(node2, null);
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        List<RetentionLease> retentionLeases = Arrays.asList(  
            state,
    public void testFileChecksumMatch() {  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
                                        null,
        );
        );  
     * Verifies that when there is a sync id match but no files match, we allocate it to matching node.  
        while (iterator.hasNext()) {
    /**
        testAllocator.addData(
        assertThat(  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
        }  
        if (randomBoolean()) {  
            Settings.EMPTY,  
            deciders,
        );  
            SnapshotShardSizeInfo.EMPTY,
        testAllocator.addData(node2, "NOT_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
    private final ShardId shardId = new ShardId("test", "_na_", 0);
            ShardRouting shard,
        assertThat(testAllocator.getFetchDataCalledAndClean(), equalTo(false));
        assertThat(unassignedShards.get(0).unassignedInfo().getNumFailedAllocations(), equalTo(0));  
            long retainingSeqNoOnPrimary = randomLongBetween(0, Long.MAX_VALUE);
    }
            randomIntBetween(failedNodes.size(), 10),  
        allocateAllUnassigned(allocation);  
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
        allocateAllUnassigned(allocation);  
 *  
 * software distributed under the License is distributed on an
    /**
                    ),  
            yesAllocationDeciders(),  
            yesAllocationDeciders(),
                    peerRecoveryRetentionLeases
            .addData(nodeToMatch, "MATCH", new StoreFileMetadata("file1", 10, "NO_MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
import org.opensearch.cluster.routing.IndexRoutingTable;
     */
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            newRetentionLease(node1, retainingSeqNoOnPrimary),
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
            System.nanoTime()
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
        allocateAllUnassigned(allocation);  
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        }
                            .build()
        RoutingTable routingTable = RoutingTable.builder()
        List<RetentionLease> retentionLeases = new ArrayList<>();
        UnassignedInfo unassignedInfo = new UnassignedInfo(
        this.testAllocator = new TestAllocator();
        .minimumIndexCompatibilityVersion().luceneVersion;
                )
            System.currentTimeMillis(),
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))  
        public void clean() {  
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
        retentionLeases.add(newRetentionLease(node1, retainingSeqNo));  
        UnassignedInfo.Reason reason  
        );
                System.nanoTime(),
        if (randomBoolean()) {  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
    private void allocateAllUnassigned(final RoutingAllocation allocation) {
    public void testNoDataForReplicaOnAnyNode() {  
        assertThat(
    }
                                        UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            .addData(node2, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
/*  
                    .settings(settings(Version.CURRENT))
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
            node1,
            )
            UnassignedInfo.Reason.NODE_LEFT  
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;  
 * Modifications Copyright OpenSearch Contributors. See
    @Before  
import org.opensearch.cluster.routing.ShardRouting;
        assertThat("failed with reason " + reason, testAllocator.getFetchDataCalledAndClean(), equalTo(true));
import org.opensearch.indices.store.TransportNodesListShardStoreMetadata;
    /**  
            equalTo(nodeToMatch.getId())
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
        assertThat(allocation.routingNodesChanged(), equalTo(false));
                    }  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(  
            node1,
        long retainingSeqNoOnPrimary = randomLongBetween(1, Integer.MAX_VALUE);  
                    new AllocationDecider() {
        testAllocator.processExistingRecoveries(allocation);
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
        );
                        }
        List<RetentionLease> retentionLeases = new ArrayList<>();
                            )  
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1)).build(),
        );
import org.opensearch.cluster.routing.allocation.AllocationDecision;
 *
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
        assertThat(unassignedShards.get(0).shardId(), equalTo(shardId));
            unassignedInfo = new UnassignedInfo(  
     * Verifies that when there is primary data, but no matching data at all on other nodes, the shard keeps  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());  
            node1,  
            ClusterInfo.EMPTY,
        UnassignedInfo.Reason reason = RandomPicks.randomFrom(  
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
                retentionLeases.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNoOnPrimary)));
        peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node2, randomLongBetween(1, retainingSeqNo)));  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            null,
import org.junit.Before;
                                    null,
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();  
    public void testNoAsyncFetchOnIndexCreation() {  
            .build();  
        testAllocator.addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.routing.RoutingNode;
        );
        Settings indexSettings,
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            yesAllocationDeciders(),
        return onePrimaryOnNode1And1Replica(deciders, Settings.EMPTY, UnassignedInfo.Reason.CLUSTER_RECOVERED);  
            newRetentionLease(node2, retainingSeqNoForNode2),  
            testAllocator.allocateUnassigned(iterator.next(), allocation, iterator);
import java.util.Set;  
        return onePrimaryOnNode1And1Replica(deciders, indexSettings, Settings.EMPTY, reason);
        testAllocator.processExistingRecoveries(allocation);  
                                    shardId,
                            .build()  
            data = null;
            randomBoolean() ? noAllocationDeciders() : throttleAllocationDeciders()  
            .numberOfReplicas(1)  
        );  
import java.util.List;
                    tData.put(  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
                IndexMetadata.builder(shardId.getIndexName())  
     * adding a replica and having that replica actually recover and cause the corruption to be identified  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)  
        );
        long retainingSeqNoForNode2 = randomLongBetween(0, retainingSeqNoOnPrimary - 1);
    private final DiscoveryNode node2 = newNode("node2");
            equalTo(node3.getId())
        } else {
package org.opensearch.gateway;
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            new RoutingNodes(state, false),
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
import org.opensearch.cluster.routing.RecoverySource;
        }
        }
    public void testIgnoreRetentionLeaseIfCopyIsEmpty() {
import org.opensearch.cluster.routing.ShardRoutingState;  
import org.opensearch.index.store.Store;  
            randomNonNegativeLong(),
            Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1)).build(),
            Collections.singletonList(newRetentionLease(node3, randomNonNegativeLong())),  
                                    shardId,
     */  
        if (randomBoolean()) {
        allocateAllUnassigned(allocation);  
        if (randomBoolean()) {
     * the shard allocator to allocate it. There isn't a copy around to find anyhow.
    public void testSimpleFullMatchAllocation() {
            retentionLeases,  
    public void testPreferCopyWithHighestMatchingOperations() {
            return this;
                                    unassignedInfo
     * to wait till throttling on it is done.
        return randomFrom("MATCH", "NOT_MATCH", null);
                                        null,
        @Override
                failedNodes  
            .addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
                {
            return addData(node, Collections.emptyList(), syncId, files);
        TestAllocator addData(
        );  
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
    private RoutingAllocation onePrimaryOnNode1And1Replica(
        int failedAllocations = reason == UnassignedInfo.Reason.ALLOCATION_FAILED ? 1 : 0;  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
            "MATCH",
}  
    ) {
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata;  
            List<RetentionLease> peerRecoveryRetentionLeases,  
        if (randomBoolean()) {
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));  
    }
    public void testNoAsyncFetchData() {  
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            DiscoveryNode node,
            retainingSeqNo,  
        long retainingSeqNoOnPrimary = randomLongBetween(0, Long.MAX_VALUE);
        allocateAllUnassigned(allocation);
            retentionLeases,
import org.opensearch.snapshots.SnapshotShardSizeInfo;
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            System.nanoTime(),  
    }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
                System.currentTimeMillis(),
        public boolean getFetchDataCalledAndClean() {
        Settings indexSettings,
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                                    node2.getId(),  
import static org.hamcrest.Matchers.hasSize;  
        testAllocator.addData(
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
    private RoutingAllocation onePrimaryOnNode1And1Replica(AllocationDeciders deciders) {
    }
    static String randomSyncId() {  
        List<RetentionLease> peerRecoveryRetentionLeasesOnPrimary = new ArrayList<>();  
                    .numberOfShards(1)
    /**
            fetchDataCalled.set(true);
        peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node1, retainingSeqNo));
        testAllocator.processExistingRecoveries(allocation);  
            for (StoreFileMetadata file : files) {
    public void testDelayedAllocation() {
        // mark shard as delayed if reason is NODE_LEFT  
    public void buildTestAllocator() {
            failedNodes = new HashSet<>(randomSubsetOf(Arrays.asList("node-4", "node-5", "node-6")));
        allocateAllUnassigned(allocation);
        assertThat(
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
    private RoutingAllocation onePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders) {
    private TestAllocator testAllocator;
        ShardRouting unassignedShard = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0);
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
        }  
            .settings(settings(Version.CURRENT).put(indexSettings))
    }
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
            SnapshotShardSizeInfo.EMPTY,  
     */
        allocateAllUnassigned(allocation);
import org.opensearch.cluster.routing.allocation.decider.Decision;
            .build();
        );  
    /**  
    }  
                                    new UnassignedInfo(
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        if (randomBoolean()) {
        );
    }
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)  
            }
            equalTo(node3.getId())  
        ) {  
        }
        assertThat(  
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
        allocateAllUnassigned(allocation);  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
            yesAllocationDeciders(),
import java.util.concurrent.atomic.AtomicBoolean;
                        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
        assertThat(
import org.opensearch.cluster.ClusterState;
        allocateAllUnassigned(allocation);
            .put(
                                ShardRouting.newUnassigned(
     * Verifies that when there is a full match (syncId and files) we allocate it to matching node.
            retentionLeases.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNo)));  
    }  
        assertThat(decision.getRemainingDelayInMillis() <= clusterDelay.millis(), equalTo(true));  
        );
            }
                                )
                                        reason,  
        testAllocator.addData(
import org.opensearch.common.unit.TimeValue;  
import java.util.Collections;  
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardId.getIndexName())  
        AllocationDeciders deciders,
     * moves to the ignore unassigned list.
        assertThat(  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));  
import java.util.HashSet;  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));  
    /**  
     * See CorruptFileTest#
                                    ShardRoutingState.INITIALIZING,  
                null,
        }  
            .addData(node2, "NO_MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
    }  
     * to be allocated. This is today behavior, which relies on a primary corruption identified with
        assertThat(allocation.routingNodesChanged(), equalTo(false));
            equalTo(nodeToMatch.getId())
import org.opensearch.cluster.node.DiscoveryNodes;
                                    RecoverySource.PeerRecoverySource.INSTANCE,
    ) {
            Map<DiscoveryNode, TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> tData = null;
 * this work for additional information regarding copyright
            StoreFileMetadata... files
            .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()));
    /**  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),  
    private RoutingAllocation onePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders, UnassignedInfo unassignedInfo) {
        testAllocator.processExistingRecoveries(allocation);
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,  
                    shardId,  
            "MATCH",
        testAllocator.addData(node2, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
                randomIntBetween(1, 10),
                filesAsMap.put(file.name(), file);  
            .addData(node3, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            .addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
    /**  
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());  
        private Map<DiscoveryNode, StoreFilesMetadata> data = null;  
    public void testNotCancellingRecoveryIfSyncedOnExistingRecovery() {
/*
            && UnassignedInfo.getNodeLeftDelayedTimeout(indexSettings, nodeSettings).nanos() > 0;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.routing.UnassignedInfo;
            "MATCH",  
        }  
            nodeSettings,
            failedNodes.add("node4");  
    }
            Map<String, StoreFileMetadata> filesAsMap = new HashMap<>();
                )  
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));  
        AllocateUnassignedDecision decision = testAllocator.makeAllocationDecision(unassignedShard, allocation, testAllocator.logger);  
import java.util.HashMap;
    public void testCancelRecoveryIfFoundCopyWithNoopRetentionLease() {
 * not use this file except in compliance with the License.
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
        return new RoutingAllocation(  
            .metadata(metadata)
    public void testNoOrThrottleDecidersRemainsInUnassigned() {
                            }  
        assertThat(allocation.routingNodesChanged(), equalTo(true));
 *
        Metadata metadata = Metadata.builder().put(indexMetadata).build();
 * under the License.  
            UnassignedInfo.Reason.ALLOCATION_FAILED,  
        testAllocator.addData(node2, null); // has retention lease but store is empty
            .put(UnassignedInfo.CLUSTER_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), clusterDelay)  
        assertThat(allocation.routingNodesChanged(), equalTo(true));
        return new RetentionLease(
            }  
        if (randomBoolean()) {
     * Verifies that when we are still fetching data in an async manner, the replica shard moves to ignore unassigned.
        assertThat(decision.getAllocationStatus(), equalTo(UnassignedInfo.AllocationStatus.DELAYED_ALLOCATION));  
import org.opensearch.index.engine.Engine;  
            .metadata(metadata)  
        );  
                    .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()))
    }
            RoutingAllocation allocation
    }  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        Settings nodeSettings,
        allocateAllUnassigned(allocation);
        }  
                        entry.getKey(),
import java.util.EnumSet;
                System.nanoTime(),  
            node1,
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
 * GitHub history for details.
                randomIntBetween(1, 10),
    public void testSyncIdMatch() {
            return new AsyncShardFetch.FetchResult<>(tData, new HashMap<>() {  
        // Rarely use a seqNo above retainingSeqNoOnPrimary, which could in theory happen when primary fails and comes back quickly.
        allocateAllUnassigned(allocation);  
                for (Map.Entry<DiscoveryNode, StoreFilesMetadata> entry : data.entrySet()) {
    public void testAsyncFetchOnAnythingButIndexCreation() {
            .routingTable(routingTable)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
    }
        Set<String> failedNodes = new HashSet<>();  
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null);
        boolean delayed = reason == UnassignedInfo.Reason.NODE_LEFT
            peerRecoveryRetentionLeasesOnPrimary,  
                                return Decision.THROTTLE;
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
     */
        assertThat(allocation.routingNodesChanged(), equalTo(false));
                                        delayed,  
            equalTo(node2.getId())
            retentionLeases,  
        );  
import org.opensearch.core.index.shard.ShardId;
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
    }
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
    }  
        testAllocator.clean();  
            peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNo)));
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
     */
            System.nanoTime(),
     * Verifies that on index creation, we don't go and fetch data, but keep the replica shard unassigned to let  
import org.opensearch.Version;  
            Settings.EMPTY,
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
            false,  
    /**
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
import java.util.ArrayList;
            .build();  
import java.util.Arrays;
        protected AsyncShardFetch.FetchResult<TransportNodesListShardStoreMetadata.NodeStoreFilesMetadata> fetchData(  
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
    }  
     */
                                    false,  
     */  
            .addData(node2, "NO_MATCH", new StoreFileMetadata("file1", 10, "NO_MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
        assertThat(unassignedShards.get(0).unassignedInfo().getFailedNodeIds(), equalTo(failedNodes));
        assertThat(decision.getConfiguredDelayInMillis(), equalTo(clusterDelay.millis()));
                data = new HashMap<>();
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));  
                    new TestAllocateDecision(Decision.YES),
                new StoreFilesMetadata(
/*  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
    public void testNotCancelIfPrimaryDoesNotHaveValidRetentionLease() {
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
        testAllocator.addData(node3, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        testAllocator.addData(node1, "MATCH", new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        TimeValue clusterDelay = TimeValue.timeValueHours(1);
        }
        testAllocator.addData(
import org.opensearch.index.seqno.ReplicationTracker;
            null,
    public void testNotCancellingRecovery() {
                                TestShardRouting.newShardRouting(
     * and find a better copy for the shard.  
                UnassignedInfo.Reason.ALLOCATION_FAILED,
            new AllocationDeciders(  
import org.opensearch.common.settings.ClusterSettings;
                    )
 * Unless required by applicable law or agreed to in writing,
                    .addIndexShard(
 */  
        public void cleanWithEmptyData() {
        testAllocator.processExistingRecoveries(allocation);  
                                        System.nanoTime(),
    }
     * When there is no decision or throttle decision across all nodes for the shard, make sure the shard
        testAllocator.addData(node2, randomSyncId(), new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
