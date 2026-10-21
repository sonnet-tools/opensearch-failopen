                                    false,
        testBatchAllocator.addData(
            node1,
            randomSyncId(),
    /**
            );
                    new AllocationDecider() {
        }
    public void buildTestAllocator() {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            );
            Map<ShardId, TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata> shardIdNodeStoreFilesMetadataHashMap =
                .addShardData(
        // Verify the throttling decider was throttled, incoming recoveries on a node should be
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        testBatchAllocator.allocateUnassignedBatchOnTimeout(shards, allocation, false);
        testBatchAllocator.addData(
            List<RetentionLease> peerRecoveryRetentionLeases,
            "MATCH",
        testBatchAllocator.addData(
        testBatchAllocator.addData(
                node,
    @Before
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
            .build();
        allocateAllUnassignedBatch(allocation);
            ClusterInfo.EMPTY,
    public void testIgnoreRetentionLeaseIfCopyIsEmpty() {
        );
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.cluster.node.DiscoveryNode;
        final UnassignedInfo unassignedInfo;
    }
                    null,
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            RoutingAllocation allocation
            .put(
            testBatchAllocator.addData(node2, null, null);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
     * moves to the ignore unassigned list.
     */
            newRetentionLease(node1, retainingSeqNoOnPrimary),
                        shardId,
        }
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            System.nanoTime(),
     */
            null,
                UnassignedInfo.Reason.ALLOCATION_FAILED,
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            if (syncId != null) {
        assertThat("failed with reason" + reason, testBatchAllocator.getShardEligibleFetchDataCountAndClean(), equalTo(1));
        );
                new HashMap<>();
        public TestBatchAllocator addShardData(
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                                    )
                                    null,
        testBatchAllocator.addData(
                            .build()
                    )
            "MATCH",
            )
                            UnassignedInfo.Reason.CLUSTER_RECOVERED,
import org.opensearch.common.settings.ClusterSettings;
                )
        public void clean() {
        for (int shardNumber = 0; shardNumber < numberOfShards; shardNumber++) {
        public TestBatchAllocator addData(
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
            retentionLeases.add(newRetentionLease(node1, retainingSeqNoOnPrimary));
        testBatchAllocator.addData(
        List<RetentionLease> retentionLeases = Arrays.asList(
            node3,
            Settings.builder()
    }
                            if (node.node().equals(node2)) {
        testBatchAllocator.processExistingRecoveries(
            )
        assertEquals(1, initializingShards.size());
        final RoutingAllocation routingAllocation = twoPrimaryAndOneUnAssignedReplica(allocationDeciders);
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTableBuilder.build()).build();
        final UnassignedInfo unassignedInfo;
    private void allocateAllUnassignedBatch(final RoutingAllocation allocation) {
        Index index = shardId.getIndex();
            if (sr.primary() == false) {
import org.opensearch.snapshots.SnapshotShardSizeInfo;
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
            ignoredShardRoutings.get(0),
            // we sometime return empty list of files, make sure we test this as well
        testBatchAllocator.clean();
import org.opensearch.index.seqno.RetentionLease;
                    node2,
            .addData(node3, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
                commitData.put(Engine.SYNC_COMMIT_ID, syncId);
                IndexRoutingTable.builder(shardId.getIndex())
    }
        testBatchAllocator.addData(
                                    node2.getId(),
            random()
    }
     */
            String syncId,
                    "NO_MATCH",
    public void testDelayedAllocation() {
import org.opensearch.cluster.routing.ShardRouting;
        }
        );
                    "MATCH",
        allocation = onePrimaryOnNode1And1Replica(
                node,
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
                Collections.singleton("node-4")
        // Rarely use a seqNo above retainingSeqNoOnPrimary, which could in theory happen when primary fails and comes back quickly.
import org.opensearch.cluster.routing.ShardRoutingState;
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
    public void testNotCancellingRecoveryIfSyncedOnExistingRecovery() {
            )
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;
            node1,
        );
            for (int i = 0; i < 1; i++) {
                        @Override
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
import java.util.EnumSet;
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            @Nullable Exception storeFileFetchException,
            "MATCH",
            "MATCH",
        Metadata metadata = Metadata.builder().put(indexMetadata).build();
        assertThat(
        assertThat(
    }
            DiscoveryNode node,
     * Verifies that when there is primary data, but no data at all on other nodes, the shard keeps
        );
        );
import org.opensearch.Version;
            .build();
    private RoutingAllocation twoPrimaryAndOneUnAssignedReplica(AllocationDeciders deciders) throws InterruptedException {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardId.getIndexName())
                                        Collections.emptySet()
            null,
            for (StoreFileMetadata file : files) {
        RoutingTable routingTable = RoutingTable.builder()
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        }
                    new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            shardIdShardRoutingMap.put(
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
     * Verifies that when there is primary data, but no matching data at all on other nodes, the shard keeps
    public void testThrottleWhenAllocatingToMatchingNode() {
                        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
            System.nanoTime()
        @Override
        List<RetentionLease> retentionLeases = new ArrayList<>();
        assertEquals(0, routingAllocation.routingNodes().getIncomingRecoveries(node2.getId()));
import java.util.HashSet;
        );
            Arrays.asList(newRetentionLease(node1, retainingSeqNo), newRetentionLease(node3, retainingSeqNo)),
            null,
        allocateAllUnassignedBatch(allocation);
            data.put(
            node3,
            null,
                "MATCH",
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
    public void testSimpleFullMatchAllocation() {
import static org.hamcrest.Matchers.empty;
            "NOT_MATCH",
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
    }
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
        assertEquals(1, ignoredShardRoutings.size());
    }
                                    null,
            new RoutingNodes(state, false),
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
        protected AsyncShardFetch.FetchResult<NodeStoreFilesMetadataBatch> fetchData(
            node1,
            deciders,
            null,
    public void testCancelRecoveryIfFoundCopyWithNoopRetentionLease() {
public class ReplicaShardBatchAllocatorTests extends OpenSearchAllocationTestCase {
        );
        testBatchAllocator.addData(
            node2,
            .add(
            return fetchDataCalled.get();
import org.opensearch.cluster.routing.RoutingTable;
}
            node1,
        if (randomBoolean()) {
            unassignedInfo = new UnassignedInfo(
            }
            .numberOfReplicas(1);
            return eligibleShardFetchDataCount.getAndSet(0);
        allocateAllUnassignedBatch(allocation);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
                )
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
import static java.util.Collections.unmodifiableMap;
        assertThat(
            indexMetadata.putInSyncAllocationIds(
            .settings(settings(Version.CURRENT).put(settings))
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
            randomSyncId(),
                                    ShardRoutingState.INITIALIZING,
                            }
            Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1)).build(),
    }
        List<ShardRouting> shardToBatch = new ArrayList<>();
    private final DiscoveryNode node2 = newNode("node2");
            null,
            equalTo(nodeToMatch.getId())
            .nodes(DiscoveryNodes.builder().add(node1).add(node2))
            .addData(node2, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
            .addData(nodeToMatch, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        } else {
        while (iterator.hasNext()) {
        assertThat(unassignedShards.get(0).shardId(), equalTo(shardId));
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        allocateAllUnassignedBatch(allocation);
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
            clusterSettings,
                .addShardData(
            shardsInBatch.add(shardId);
                    }
            Map<String, String> commitData = new HashMap<>();
        );
                );
        allocateAllUnassignedBatch(allocation);
                            )
            return this;
        retentionLeases.add(newRetentionLease(node2, randomLongBetween(0, retainingSeqNo)));
                );
                                        failedAllocations,
        );
        assertThat(unassignedShards, hasSize(1));
    public void testNoDataForReplicaOnAnyNode() {
    }
        } else {
import java.util.concurrent.atomic.AtomicBoolean;
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
        assertEquals(UnassignedInfo.AllocationStatus.NO_ATTEMPT, ignoredShardRoutings.get(0).unassignedInfo().getLastAllocationStatus());
    public void testCancelRecoveryBetterSyncId() {
            newRetentionLease(node3, retainingSeqNoForNode3)
            allocation.routingNodes().unassigned().ignored().get(0).unassignedInfo().getLastAllocationStatus()
        testBatchAllocator.processExistingRecoveries(
            .routingTable(routingTable)
            && UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.get(settings).nanos() > 0;
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 1)
 * compatible open source license.
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        if (randomBoolean()) {
            null,
        List<List<ShardRouting>> shardBatchList = Collections.singletonList(
                retentionLeases.add(newRetentionLease(node2, randomLongBetween(0, retainingSeqNoOnPrimary)));
        }
        return onePrimaryOnNode1And1ReplicaRecovering(deciders, new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null));
    private static Set<ShardId> shardsInBatch;
            ClusterInfo.EMPTY,
    }
        testBatchAllocator.addData(
            null,
        }
     */
                null,
            randomSyncId(),
    }
import org.opensearch.index.seqno.ReplicationTracker;
            .addData(nodeToMatch, "NO_MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
    }
import org.opensearch.cluster.routing.RoutingNodes;
            "NOT_MATCH",
        if (randomBoolean()) {
                                        System.currentTimeMillis(),
            }
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
    public void testNotCancelIfPrimaryDoesNotHaveValidRetentionLease() {
        private AtomicInteger eligibleShardFetchDataCount = new AtomicInteger(0);
            null,
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        for (ShardId shardIdFromBatch : shardsInBatch) {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
        testBatchAllocator.addData(
            deciders,
     * Verifies that when there is a full match (syncId and files) we allocate it to matching node.
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .addData(node2, randomSyncId(), null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        );
        boolean delayed = reason == UnassignedInfo.Reason.NODE_LEFT
    public void testDoNotCancelForBrokenNode() {
     * Verifies that when there is no sync id match but files match, we allocate it to matching node.
    }
            random(),
                        false,
            .addData(node2, "NO_MATCH", null, new StoreFileMetadata("file1", 10, "NO_MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            node3,
            node3,
        allocateAllUnassignedBatch(allocation);
            null,
                            return Decision.YES;
            .addData(node2, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
    private RoutingAllocation onePrimaryOnNode1And1Replica(AllocationDeciders deciders, Settings settings, UnassignedInfo.Reason reason) {
                                    RecoverySource.PeerRecoverySource.INSTANCE,
        );
                    new TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata(
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
    private RoutingAllocation oneInactivePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders, UnassignedInfo unassignedInfo) {
                IndexMetadata.builder(shardId.getIndexName())
            shards.add(iterator.next().shardId());
                                )
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        );
            UnassignedInfo.Reason.INDEX_CREATED
            null,
        testBatchAllocator.addData(
            "NOT_MATCH",
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
            .build();
            "NO_MATCH",
import org.opensearch.cluster.routing.UnassignedInfo;
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
    public void testSyncIdMatch() {
        for (ShardId shardIdFromBatch : shardsInBatch) {
     */
        testBatchAllocator.addData(
            node1,
            node1,
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata nodeStoreFilesMetadata =
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
import java.util.ArrayList;
                );
                        }
            .routingTable(routingTable)
     */
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            }
            )
        testBatchAllocator.addData(
        }
                            0,
            .metadata(metadata)
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch;
            node1,
        );
        );
        return randomFrom("MATCH", "NOT_MATCH", null);
    }
                            new TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata(
    }
        );
    }
        public TestBatchAllocator addShardData(
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
            retentionLeases,
                System.currentTimeMillis(),
                                return Decision.THROTTLE;
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
    /**
    static RetentionLease newRetentionLease(DiscoveryNode node, long retainingSeqNo) {
        private Map<DiscoveryNode, TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch> data = null;
                                    shardId,
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        ).addData(node2, randomSyncId(), null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        // mark shard as delayed if reason is NODE_LEFT
    public void testPreferCopyWithHighestMatchingOperations() {
            .numberOfShards(1)
            null,
    private RoutingAllocation onePrimaryOnNode1And1Replica(AllocationDeciders deciders) {
                TestShardRouting.newShardRouting(shardIdFromBatch, node1.getId(), true, ShardRoutingState.STARTED)
            randomNonNegativeLong(),
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
            retentionLeases,
    }
            );
                                TestShardRouting.newShardRouting(
            long retainingSeqNoOnPrimary = randomLongBetween(0, Long.MAX_VALUE);
            DiscoveryNode node,
        int failedAllocations = reason == UnassignedInfo.Reason.ALLOCATION_FAILED ? 1 : 0;
        );
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
        testBatchAllocator.addData(
            node2,
import org.opensearch.cluster.ClusterInfo;
        testBatchAllocator.addData(
        }
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        setUpShards(2);
            .addData(node2, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
                        shardIdFromBatch,
        );
                    node3,
    }
     * When we can't find primary data, but still find replica data, we go ahead and keep it unassigned
        );
                    Map.of(
            randomBoolean() ? noAllocationDeciders() : throttleAllocationDeciders()
import org.opensearch.common.settings.Settings;
        }
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch;
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        );
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
        Set<ShardId> shards = new HashSet<>();
                    ),
                    ShardRouting.newUnassigned(
            Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1)).build(),
        testBatchAllocator.addData(node2, null, null); // has retention lease but store is empty
        Set<ShardId> shards = new HashSet<>();
            data.put(
            Map<String, StoreFileMetadata> filesAsMap = new HashMap<>();
            .metadata(metadata)
        return new RoutingAllocation(
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.INITIALIZING);
            randomSyncId(),
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
                                        null,
            ShardId shardId,
        assertThat(allocation.routingNodesChanged(), equalTo(true));
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            Settings.EMPTY,
     * Tests when the node to allocate to due to matching is being throttled, we move the shard to ignored
     */
    private RoutingAllocation onePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders) {
                filesAsMap.put(file.name(), file);
        List<ShardRouting> shardRoutingBatch = new ArrayList<>(replicaShards);
            new RoutingNodes(state, false),
                            storeFileFetchException
            "MATCH",
    }
            Map<String, String> commitData = new HashMap<>();
                            )
                                    ShardRoutingState.INITIALIZING,
        assertThat(
        }
        final Set<String> failedNodes;
            logger
        );
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
        Set<String> failedNodes = new HashSet<>();
            StoreFileMetadata... files
    class TestBatchAllocator extends ReplicaShardBatchAllocator {
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
 * The OpenSearch Contributors require contributions made to
        allocateAllUnassignedBatch(allocation);
    }
    public void testDoNotCancelForInactivePrimaryNode() {
            StoreFileMetadata... files
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
        return onePrimaryOnNode1And1Replica(deciders, Settings.EMPTY, UnassignedInfo.Reason.CLUSTER_RECOVERED);
            System.nanoTime()
                    shardIdFromBatch,
        ) {
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
                NodeStoreFilesMetadataBatch nodeStoreFilesMetadataBatch = data.get(node);
        );
                    .addIndexShard(
            null,
                shardIdNodeStoreFilesMetadataHashMap.putAll(nodeStoreFilesMetadataBatch.getNodeStoreFilesMetadataBatch());
     * Verifies that for anything but index creation, fetch data ends up being called, since we need to go and try
import org.opensearch.common.unit.TimeValue;
    /**
            for (StoreFileMetadata file : files) {
import java.util.Set;
        }
            System.currentTimeMillis(),
        }
        assertThat(unassignedShards.get(0).unassignedInfo().getFailedNodeIds(), equalTo(failedNodes));
            .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()));
            equalTo(node3.getId())
            new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING))
            .addData(nodeToMatch, "MATCH", null, new StoreFileMetadata("file1", 10, "NO_MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
import org.opensearch.cluster.metadata.Metadata;
            newRetentionLease(node2, retainingSeqNoForNode2),
            SnapshotShardSizeInfo.EMPTY,
            if (randomBoolean()) {
        );
     * When there is no decision or throttle decision across all nodes for the shard, make sure the shard
            allocation,
            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
            .routingTable(routingTable)
            UnassignedInfo.Reason.NODE_LEFT
        }
            UnassignedInfo.Reason.NODE_LEFT
            null,
                                        System.nanoTime(),
            node3,
        );
            new RoutingNodes(state, false),
            state,
        );
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            null,
                randomIntBetween(1, 10),
        List<RetentionLease> retentionLeases = new ArrayList<>();
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
                    )
    /**
        if (randomBoolean()) {
                    .settings(settings(Version.CURRENT))
        }
        while (iterator.hasNext()) {
    }
    static String randomSyncId() {
    public void testNoPrimaryData() {
                            null,
        );
        assertThat(allocation.routingNodesChanged(), equalTo(false));
                false,
        List<ShardRouting> ignoredShardRoutings = routingAllocation.routingNodes().unassigned().ignored();
                                TestShardRouting.newShardRouting(
import java.util.Arrays;
        RoutingAllocation allocation = oneInactivePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), null);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
        assertEquals(
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
     * to be allocated. This is today behavior, which relies on a primary corruption identified with
            failedNodes.add("node4");
                    .addIndexShard(
            "MATCH",
            }
    /**
            .settings(settings(Version.CURRENT).put(Settings.EMPTY))
                                    false,
        Metadata metadata = Metadata.builder()
            DiscoveryNode node,
        testBatchAllocator.allocateUnassignedBatchOnTimeout(shards, allocation, false);
     * Verifies that when we are still fetching data in an async manner, the replica shard moves to ignore unassigned.
                    shardIdFromBatch,
        return new RoutingAllocation(
        // Created started ShardRouting for each primary shards
        );
                retentionLeases.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNoOnPrimary)));
        allocateAllUnassignedBatch(allocation);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            DiscoveryNode node,
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 1)
                shards.add(sr.shardId());
                new TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch(
        );
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                            null,
            SnapshotShardSizeInfo.EMPTY,
                            System.currentTimeMillis(),
                indexShardRoutingTableBuilder.addShard(
            newRetentionLease(node1, retainingSeqNoOnPrimary),
import static org.hamcrest.Matchers.hasSize;
        Metadata metadata = Metadata.builder().put(indexMetadata).build();
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            false,
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null);
            .numberOfShards(2)
import org.opensearch.cluster.routing.RecoverySource;
                System.currentTimeMillis(),
    }
        if (randomBoolean()) {
        );
                                new Store.MetadataSnapshot(unmodifiableMap(filesAsMap), unmodifiableMap(commitData), randomInt()),
                    )
                        )
                            .addShard(
            );
            String syncId,
                    new TestAllocateDecision(Decision.YES),
        protected boolean hasInitiatedFetching(ShardRouting shard) {
                System.nanoTime(),
    }
import org.opensearch.index.engine.Engine;
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            "MATCH",
     * adding a replica and having that replica actually recover and cause the corruption to be identified
            .build();
        retentionLeases.add(newRetentionLease(node1, retainingSeqNo));
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
    public void testAsyncFetchWithNoShardOnIndexCreation() {
    }
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            null,
                new TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch(node, shardIdNodeStoreFilesMetadataHashMap)
        ) {
            if (data == null) {
            data = null;
                            .build()
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
        }
            @Nullable Exception storeFileFetchException,
 * this file be licensed under the Apache-2.0 license or a
            ShardId shardId,
            Settings.EMPTY,
        );
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        assertEquals(1, routingAllocation.routingNodes().getIncomingRecoveries(node3.getId()));
            }
                    .numberOfReplicas(1)
        if (randomBoolean()) {
        return new RoutingAllocation(
import org.opensearch.cluster.ClusterState;
        Set<ShardId> shards = new HashSet<>();
import java.util.Map;
        ) {
    private final DiscoveryNode node1 = newNode("node1");
            shardIdNodeStoreFilesMetadataHashMap.put(shardId, nodeStoreFilesMetadata);
            allocation,
import org.opensearch.core.index.shard.ShardId;
            "MATCH",
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
     * See CorruptFileTest#
                        peerRecoveryRetentionLeases
                randomIntBetween(1, 10),
            routingAllocation,
        if (randomBoolean()) {
            peerRecoveryRetentionLeasesOnPrimary,
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            );
            if (data == null) {
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
            node2,
    private TestBatchAllocator testBatchAllocator;
            retentionLeases,
        ) {
        allocateAllUnassignedBatch(routingAllocation);
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
        testBatchAllocator.addData(
                null,
        @Override
                            .addShard(
            return this;
    /**
     * to wait till throttling on it is done.
        public boolean getFetchDataCalledAndClean() {
                            .build()
 * SPDX-License-Identifier: Apache-2.0
        allocateAllUnassignedBatch(allocation);
import org.opensearch.index.store.StoreFileMetadata;
        );
        )
            }
        testBatchAllocator.allocateUnassignedBatch(shardToBatch, allocation);
        );
import org.opensearch.cluster.routing.allocation.decider.Decision;
    public void testNoOrThrottleDecidersRemainsInUnassigned() {
import java.util.Collection;
                    .numberOfShards(1)
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(0));
        long retainingSeqNoForNode2 = randomLongBetween(0, retainingSeqNoOnPrimary - 1);
import java.util.List;
        }
    /**
    }
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
            .build();
                            System.nanoTime(),
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        List<RetentionLease> peerRecoveryRetentionLeasesOnPrimary = new ArrayList<>();
import org.opensearch.index.store.Store;
        );
        this.testBatchAllocator = new TestBatchAllocator();
            List<ShardRouting> eligibleShards,
            null,
            retainingSeqNo,
            // Add replicas of primary shard in un-assigned state.
                false,
            SnapshotShardSizeInfo.EMPTY,
    }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        testBatchAllocator.clean();
            equalTo(node3.getId())
        );
            indexShardRoutingTableBuilder.addShard(shardIdShardRoutingMap.get(shardIdFromBatch));
        // lesser than or equal to allowed concurrent recoveries
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        }
                data = new HashMap<>();
                    .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()))
                    storeFileFetchException
                            ),
            @Nullable Exception storeFileFetchException,
                    node,
        );
                            Collections.emptySet()
        testBatchAllocator.addData(
        public TestBatchAllocator addData(
     */
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
    private RoutingAllocation onePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders, UnassignedInfo unassignedInfo) {
        List<RetentionLease> retentionLeases = Arrays.asList(
        assertEquals(UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED, allocateUnassignedDecision.getAllocationStatus());
        failedNodes.add(node3.getId());
        for (ShardId shardIdFromBatch : shardsInBatch) {
        testBatchAllocator.processExistingRecoveries(
        testBatchAllocator.addData(
import java.util.Collections;
    /**
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        testBatchAllocator.processExistingRecoveries(
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
                data = new HashMap<>();
        );
            null,
            null,
                        new Store.MetadataSnapshot(unmodifiableMap(filesAsMap), unmodifiableMap(commitData), randomInt()),
                    null,
import org.opensearch.cluster.routing.TestShardRouting;
                                    false,
            equalTo(nodeToMatch.getId())
            randomIntBetween(failedNodes.size(), 10),
            null,
     * unassigned to be allocated later on.
     */
            }
        allocateAllUnassignedBatch(allocation);
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        shardsInBatch = new HashSet<>();
            );
            }
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
            UnassignedInfo.Reason.ALLOCATION_FAILED,
                                shardId,
            ClusterInfo.EMPTY,
        while (iterator.hasNext()) {
        UnassignedInfo unassignedInfo = new UnassignedInfo(
import java.util.concurrent.atomic.AtomicInteger;
        );
    }
        peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node2, randomLongBetween(1, retainingSeqNo)));
            testBatchAllocator.addShardData(
    }
                IndexRoutingTable.builder(shardId.getIndex())
            Map<String, StoreFileMetadata> filesAsMap = new HashMap<>();
    public void testNotCancellingRecoveryIfCurrentRecoveryHasRetentionLease() {
    /**
        testBatchAllocator.processExistingRecoveries(allocation, shardBatchList);
    /**
                                    shardId,
                .build(),
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
            .build();
import org.opensearch.common.util.set.Sets;
            return fetchDataCalled.getAndSet(false);
            node2,
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTableBuilder.build());
        assertThat(
        allocateAllUnassignedBatch(allocation);
        );
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
        RoutingTable routingTable = RoutingTable.builder()
            if (syncId != null) {
            null,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED), empty());
                    new SameShardAllocationDecider(
            node1,
        long retainingSeqNoOnPrimary = randomLongBetween(1, Integer.MAX_VALUE);
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AllocateUnassignedDecision allocateUnassignedDecision = testBatchAllocator.makeAllocationDecision(
     * the shard allocator to allocate it. There isn't a copy around to find anyhow.
                Arrays.asList(
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
     */
                                peerRecoveryRetentionLeases
 *
            randomSyncId(),
            List<RetentionLease> peerRecoveryRetentionLeases,
            allocation,
                node1,
        );
                                ShardRouting.newUnassigned(
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            null,
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(index.getName())
            yesAllocationDeciders(),
        );
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.STARTED);
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(0));
                filesAsMap.put(file.name(), file);
    public void testNoMatchingFilesForReplicaOnAnyNode() {
            equalTo(nodeToMatch.getId())
        }
                commitData.put(Engine.SYNC_COMMIT_ID, syncId);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
            null,
            if (randomBoolean()) {
    public void testNoAsyncFetchData() {
            .numberOfReplicas(1)
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            node1,
    public void testAllocateUnassignedBatchThrottlingAllocationDeciderIsHonoured() throws InterruptedException {
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper;
                                    node2.getId(),
        Map<ShardId, ShardRouting> shardIdShardRoutingMap = new HashMap<>();
        assertThat(allocation.routingNodesChanged(), equalTo(true));
    private static final org.apache.lucene.util.Version MIN_SUPPORTED_LUCENE_VERSION = org.opensearch.Version.CURRENT
    public void testAllocateUnassignedBatchOnTimeoutWithAlreadyRecoveringReplicaShard() {
                                    unassignedInfo
                                        null,
    }
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders(), Settings.EMPTY, reason);
            yesAllocationDeciders(),
            newRetentionLease(node3, retainingSeqNoOnPrimary)
                UnassignedInfo.Reason.ALLOCATION_FAILED,
        AllocationDeciders allocationDeciders = randomAllocationDeciders(
            ShardId shardId = new ShardId("test", "_na_", shardNumber);
        testBatchAllocator.addData(
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.STARTED);
    }
            return addData(node, Collections.emptyList(), syncId, storeFileFetchException, files);
            }
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
            .add(
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        );
    private final ShardId shardId = new ShardId("test", "_na_", 0);
                                        reason,
            shardToBatch.add(iterator.next());
        // Create Index Routing table
        long retainingSeqNoOnPrimary = randomLongBetween(0, Long.MAX_VALUE);
        );
        // Allocation status for ignored replicas shards is not updated after running the deciders they just get marked as ignored.
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
import org.opensearch.core.index.Index;
        List<ShardRouting> unassignedShards = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);
            List<ShardRouting> ineligibleShards,
            deciders,
            "MATCH",
        );
            allocation,
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
    }
            "MATCH",
    private final DiscoveryNode node3 = newNode("node3");
            node2,
    public void testFileChecksumMatch() {
            .addData(node3, randomSyncId(), null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            yesAllocationDeciders(),
            new AllocationDeciders(
        long retainingSeqNoForNode3 = randomLongBetween(retainingSeqNoForNode2 + 1, retainingSeqNoOnPrimary + 100);
                        new UnassignedInfo(
                System.nanoTime(),
                        )
        }
            state,
                            )
            peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNo)));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
        );
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
        }
            .routingTable(routingTable)
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        testBatchAllocator.clean();
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
        for (ShardId shardIdFromBatch : shardsInBatch) {
            ShardRouting sr = iterator.next();
            StoreFileMetadata... files
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
            state,
            equalTo(node2.getId())
            retentionLeases,
        }
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
        while (iterator.hasNext()) {
        );
     * Verifies that when there is a sync id match but no files match, we allocate it to matching node.
            @Nullable Exception storeFileFetchException,
        allocateAllUnassignedBatch(allocation);
            allocation,
            String syncId,
                                    unassignedInfo
    }
        allocateAllUnassignedBatch(allocation);
    }
     * and find a better copy for the shard.
import org.junit.Before;
            System.nanoTime()
            randomSyncId(),
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                                        delayed,
            EnumSet.complementOf(EnumSet.of(UnassignedInfo.Reason.INDEX_CREATED))
            failedNodes = new HashSet<>(randomSubsetOf(Arrays.asList("node-4", "node-5", "node-6")));
        // Create Index Metadata
    }
                    ),
                null,
        }
        List<ShardRouting> initializingShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            node1,
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            .add(
        allocateAllUnassignedBatch(allocation);
            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            .metadata(metadata)
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            allocation,
            shards.add(iterator.next().shardId());
/*
            state,
            eligibleShardFetchDataCount.set(eligibleShards.size());
        testBatchAllocator.addData(
            ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
                                    new UnassignedInfo(
            node3,
            "MATCH",
                shardIdFromBatch,
    public void testAsyncFetchOnAnythingButIndexCreation() {
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            node2,
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
        ) {
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
                )
            UnassignedInfo.Reason.INDEX_CREATED
                            .addShard(
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            ReplicationTracker.getPeerRecoveryRetentionLeaseId(node.getId()),
            retentionLeases.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNo)));
            IndexShardRoutingTable.Builder indexShardRoutingTableBuilder = new IndexShardRoutingTable.Builder(shardIdFromBatch);
        assertThat("failed with reason " + reason, testBatchAllocator.getFetchDataCalledAndClean(), equalTo(true));
        );
    }
                                        UnassignedInfo.AllocationStatus.NO_ATTEMPT,
        );
        }
        assertThat(
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
import java.util.HashMap;
                            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
        );
        );
     */
            new RoutingNodes(state, false),
            Collections.singletonList(newRetentionLease(node3, randomNonNegativeLong())),
                    .addIndexShard(
                                    shardId,
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        testBatchAllocator.addData(
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null);
                shardIdFromBatch.id(),
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            node2,
                            false,
        allocateAllUnassignedBatch(allocation);
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
     * Verifies that on index creation, we don't fetch data for any shards, but keep the replica shard unassigned to let
        testBatchAllocator.addData(
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        testBatchAllocator.processExistingRecoveries(
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        private AtomicBoolean fetchDataCalled = new AtomicBoolean(false);
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
import org.opensearch.cluster.metadata.IndexMetadata;
            allocation,
import org.opensearch.cluster.node.DiscoveryNodes;
        RoutingTable routingTable = RoutingTable.builder()
        );
        }
                        Settings.EMPTY,
    public void testNotCancellingRecovery() {
            String syncId,
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            fetchDataCalled.set(true);
    public static void setUpShards(int numberOfShards) {
            // Add a primary shard in started state
                    )
            ClusterInfo.EMPTY,
                IndexRoutingTable.builder(shardId.getIndex())
    }
                    )
                        shardId,
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            return new AsyncShardFetch.FetchResult<>(data, Collections.<ShardId, Set<String>>emptyMap());
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            randomSyncId(),
                shardIdFromBatch,
            yesAllocationDeciders(),
        peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node1, retainingSeqNo));
        }
import org.opensearch.common.Nullable;
            failedNodes = Collections.emptySet();
        return new RetentionLease(
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
 */
            System.nanoTime()
    /**
            .addData(node2, "NO_MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
                        RecoverySource.PeerRecoverySource.INSTANCE,
                                )
            .build();
                null,
        );
        testBatchAllocator.processExistingRecoveries(
                new TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata(
        .minimumIndexCompatibilityVersion().luceneVersion;
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
            deciders,
import org.opensearch.cluster.routing.RoutingNode;
            null,
            SnapshotShardSizeInfo.EMPTY,
        Collection<ShardRouting> replicaShards = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);
    }
    }
            null,
        testBatchAllocator.allocateUnassignedBatchOnTimeout(shards, allocation, false);
            if (data.containsKey(node)) {
                        new TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata(
     * unassigned to be allocated later on.
            unassignedInfo = new UnassignedInfo(
                                )
        return new RoutingAllocation(
                null,
            failedNodes
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED), empty());
            )
        UnassignedInfo.Reason reason = RandomPicks.randomFrom(
            return addShardData(node, Collections.emptyList(), shardId, syncId, storeFileFetchException, files);
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
                new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        public int getShardEligibleFetchDataCountAndClean() {
                Sets.newHashSet(shardIdShardRoutingMap.get(shardIdFromBatch).allocationId().getId())
        );
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
        assertThat(allocation.routingNodesChanged(), equalTo(false));
            "MATCH",
            }
            )
            .build();
import static org.hamcrest.Matchers.equalTo;
                    new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        );
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
    public void testAllocateUnassignedBatchOnTimeoutSkipIgnoringNewReplicaShards() {
        assertThat(unassignedShards.get(0).unassignedInfo().getNumFailedAllocations(), equalTo(0));
        testBatchAllocator.processExistingRecoveries(
        testBatchAllocator.addData(
package org.opensearch.gateway;
            StoreFileMetadata... files
    public void testAllocateUnassignedBatchOnTimeoutWithUnassignedReplicaShard() {
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            }
                failedNodes
            null,
