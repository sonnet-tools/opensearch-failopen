            if (sr.primary() == false) {  
            .add(
            .nodes(DiscoveryNodes.builder().add(node1).add(node2))
            ShardRouting sr = iterator.next();
                                        System.nanoTime(),  
            .addData(nodeToMatch, "NO_MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
            System.nanoTime()
                                    ShardRoutingState.INITIALIZING,  
            routingAllocation,
        }  
    /**
    @Before  
        }
                            false,  
            }
            }
        }  
        }
            allocation,
            node3,
        RoutingAllocation allocation = oneInactivePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), null);
            .addData(node3, randomSyncId(), null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
import org.opensearch.core.index.shard.ShardId;
        for (ShardId shardIdFromBatch : shardsInBatch) {
        testBatchAllocator.processExistingRecoveries(
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            deciders,
    }  
        testBatchAllocator.addData(  
            equalTo(nodeToMatch.getId())  
import org.opensearch.cluster.ClusterState;
            logger  
            if (data == null) {
    }
            DiscoveryNode node,
            newRetentionLease(node2, retainingSeqNoForNode2),
                    )
            .numberOfShards(2)  
            .put(
        );
import org.opensearch.cluster.ClusterInfo;
     * and find a better copy for the shard.  
    public void testSimpleFullMatchAllocation() {
                .build(),
     */  
            indexRoutingTableBuilder.addIndexShard(indexShardRoutingTableBuilder.build());
                        peerRecoveryRetentionLeases  
        }
                    new TestAllocateDecision(Decision.YES),  
                node,  
            );
        }
                indexShardRoutingTableBuilder.addShard(  
                                        failedAllocations,
            allocation,  
            }
        allocateAllUnassignedBatch(allocation);
            equalTo(nodeToMatch.getId())
            shardIdShardRoutingMap.put(  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        setUpShards(2);  
import org.opensearch.cluster.routing.allocation.AllocateUnassignedDecision;  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());  
    private static Set<ShardId> shardsInBatch;
            return fetchDataCalled.getAndSet(false);
            // Add replicas of primary shard in un-assigned state.
            deciders,
            random(),
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
                        }  
    }
            peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNo)));
            "NOT_MATCH",
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        Set<ShardId> shards = new HashSet<>();
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
                            return Decision.YES;
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
            null,
            .metadata(metadata)  
public class ReplicaShardBatchAllocatorTests extends OpenSearchAllocationTestCase {
        );
import org.opensearch.cluster.routing.ShardRouting;
            "MATCH",  
            );
            state,
            StoreFileMetadata... files
        testBatchAllocator.allocateUnassignedBatch(shardToBatch, allocation);
     */  
            newRetentionLease(node3, retainingSeqNoForNode3)
        allocation = onePrimaryOnNode1And1Replica(  
        );
            ReplicationTracker.getPeerRecoveryRetentionLeaseId(node.getId()),
    }  
     * When there is no decision or throttle decision across all nodes for the shard, make sure the shard
        Metadata metadata = Metadata.builder().put(indexMetadata).build();
            List<ShardRouting> eligibleShards,  
        return new RetentionLease(  
            StoreFileMetadata... files  
    /**
                                new Store.MetadataSnapshot(unmodifiableMap(filesAsMap), unmodifiableMap(commitData), randomInt()),
 */  
    }
            .build();
                )
                    .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()))
     */
    public void testAsyncFetchWithNoShardOnIndexCreation() {
    public void testPreferCopyWithHighestMatchingOperations() {
    public void testAllocateUnassignedBatchOnTimeoutWithUnassignedReplicaShard() {
            SnapshotShardSizeInfo.EMPTY,  
            shardsInBatch.add(shardId);  
            "MATCH",  
                shards.add(sr.shardId());
            data = null;  
        return new RoutingAllocation(
    private static final org.apache.lucene.util.Version MIN_SUPPORTED_LUCENE_VERSION = org.opensearch.Version.CURRENT
        assertEquals(0, routingAllocation.routingNodes().getIncomingRecoveries(node2.getId()));
        }
            randomIntBetween(failedNodes.size(), 10),
        testBatchAllocator.clean();
                            }
        );  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());  
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
            equalTo(node3.getId())  
                new TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata(
        RoutingTable routingTable = RoutingTable.builder()
        allocateAllUnassignedBatch(allocation);  
            testBatchAllocator.addShardData(  
        this.testBatchAllocator = new TestBatchAllocator();
        );
            .routingTable(routingTable)
            "MATCH",
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));  
            "MATCH",
        );  
            deciders,
        public TestBatchAllocator addData(
            SnapshotShardSizeInfo.EMPTY,  
                IndexMetadata.builder(shardId.getIndexName())  
            false,
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            && UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.get(settings).nanos() > 0;
            );  
        if (randomBoolean()) {
import org.opensearch.index.seqno.ReplicationTracker;  
        allocateAllUnassignedBatch(allocation);
            .build();
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));  
            "MATCH",
        RoutingTable routingTable = RoutingTable.builder()  
                .addShardData(
            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));  
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
     * adding a replica and having that replica actually recover and cause the corruption to be identified  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                        shardIdFromBatch,
                            null,
import org.opensearch.cluster.routing.allocation.decider.Decision;
                            .build()
    private TestBatchAllocator testBatchAllocator;
            )
            .numberOfShards(1)
import org.opensearch.index.store.StoreFileMetadata;  
            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            StoreFileMetadata... files  
    }
            node2,  
        );
            node1,
import java.util.Map;  
        );
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            .settings(settings(Version.CURRENT).put(settings))  
            null,
            @Nullable Exception storeFileFetchException,
            yesAllocationDeciders(),
            return this;
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(0));
            System.nanoTime()
    public void testFileChecksumMatch() {
        public int getShardEligibleFetchDataCountAndClean() {
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
import org.opensearch.common.Nullable;
            ClusterInfo.EMPTY,  
            // Add a primary shard in started state
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);  
            deciders,  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),  
            null,  
            SnapshotShardSizeInfo.EMPTY,
            Map<ShardId, TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata> shardIdNodeStoreFilesMetadataHashMap =
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)  
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
                                    null,
                            new TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata(  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            node2,
                            UnassignedInfo.Reason.CLUSTER_RECOVERED,  
import org.opensearch.cluster.routing.IndexRoutingTable;
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            "MATCH",
        assertEquals(1, ignoredShardRoutings.size());  
        assertThat(allocation.routingNodesChanged(), equalTo(false));
                                return Decision.THROTTLE;  
        }  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
    public void testThrottleWhenAllocatingToMatchingNode() {
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(index);
     * unassigned to be allocated later on.  
                                        System.currentTimeMillis(),
        long retainingSeqNoForNode3 = randomLongBetween(retainingSeqNoForNode2 + 1, retainingSeqNoOnPrimary + 100);
                new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
import org.junit.Before;
    }
        List<ShardRouting> unassignedShards = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);
                    .settings(settings(Version.CURRENT))
            state,
                    shardIdFromBatch,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));  
        testBatchAllocator.clean();  
                IndexRoutingTable.builder(shardId.getIndex())  
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.STARTED);
        assertThat(allocation.routingNodesChanged(), equalTo(false));
import java.util.HashMap;  
 * compatible open source license.
            retainingSeqNo,
        if (randomBoolean()) {
    private RoutingAllocation onePrimaryOnNode1And1Replica(AllocationDeciders deciders, Settings settings, UnassignedInfo.Reason reason) {  
            random()
                    node2,
            UnassignedInfo.Reason.NODE_LEFT
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
        // Create Index Metadata  
                                    false,
            retentionLeases,
     * When we can't find primary data, but still find replica data, we go ahead and keep it unassigned
        );  
        Index index = shardId.getIndex();
            "NOT_MATCH",
            randomSyncId(),  
        ) {  
    }  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
                        shardId,
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataHelper;  
                filesAsMap.put(file.name(), file);  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(  
     * unassigned to be allocated later on.
                Arrays.asList(
            .metadata(metadata)
        testBatchAllocator.addData(
     */
                        new UnassignedInfo(
                    .numberOfShards(1)
        return new RoutingAllocation(
            node2,
        assertThat(allocation.routingNodesChanged(), equalTo(true));
            data.put(
        testBatchAllocator.addData(  
            Map<String, StoreFileMetadata> filesAsMap = new HashMap<>();  
        testBatchAllocator.addData(  
    private void allocateAllUnassignedBatch(final RoutingAllocation allocation) {
            if (data == null) {  
import java.util.EnumSet;
                new HashMap<>();
     * the shard allocator to allocate it. There isn't a copy around to find anyhow.
        }  
        testBatchAllocator.processExistingRecoveries(  
        );  
    }  
            .addData(node2, "NO_MATCH", null, new StoreFileMetadata("file1", 10, "NO_MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        );  
        );  
        );
import org.opensearch.index.engine.Engine;
        public boolean getFetchDataCalledAndClean() {  
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.INITIALIZING);  
    static String randomSyncId() {
        while (iterator.hasNext()) {
                )
import org.opensearch.snapshots.SnapshotShardSizeInfo;
            null,  
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))  
        );
                                    shardId,
            allocation,
            equalTo(node3.getId())
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));
            state,  
                                )  
            randomSyncId(),
                                    null,
            yesAllocationDeciders(),
            RoutingAllocation allocation
    public void testDoNotCancelForBrokenNode() {  
    private RoutingAllocation twoPrimaryAndOneUnAssignedReplica(AllocationDeciders deciders) throws InterruptedException {  
                            )  
                shardIdNodeStoreFilesMetadataHashMap.putAll(nodeStoreFilesMetadataBatch.getNodeStoreFilesMetadataBatch());
        testBatchAllocator.addData(  
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), 1)  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        testBatchAllocator.addData(  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        shardsInBatch = new HashSet<>();  
            failedNodes  
                                    shardId,
                    new TransportNodesListShardStoreMetadataHelper.StoreFilesMetadata(  
            )  
        );
import org.opensearch.cluster.routing.RecoverySource;
            node2,  
        testBatchAllocator.processExistingRecoveries(
            List<RetentionLease> peerRecoveryRetentionLeases,
        List<ShardRouting> initializingShards = routingAllocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);  
        }
        }
        retentionLeases.add(newRetentionLease(node2, randomLongBetween(0, retainingSeqNo)));
                );  
    }
                retentionLeases.add(newRetentionLease(node2, randomLongBetween(0, retainingSeqNoOnPrimary)));  
                null,  
import org.opensearch.cluster.routing.TestShardRouting;
            Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1)).build(),  
     */
                IndexRoutingTable.builder(shardId.getIndex())  
            )  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
    public void testAllocateUnassignedBatchThrottlingAllocationDeciderIsHonoured() throws InterruptedException {
            return fetchDataCalled.get();
     */
        .minimumIndexCompatibilityVersion().luceneVersion;  
     * Verifies that when we are still fetching data in an async manner, the replica shard moves to ignore unassigned.
            @Nullable Exception storeFileFetchException,  
        allocateAllUnassignedBatch(allocation);
    }  
            // we sometime return empty list of files, make sure we test this as well
            Arrays.asList(newRetentionLease(node1, retainingSeqNo), newRetentionLease(node3, retainingSeqNo)),
        );
                            ),
            EnumSet.complementOf(EnumSet.of(UnassignedInfo.Reason.INDEX_CREATED))
            ShardId shardId,
                shardIdFromBatch.id(),
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
        ) {
            indexShardRoutingTableBuilder.addShard(shardIdShardRoutingMap.get(shardIdFromBatch));  
            null,  
            .build();
    public void testAllocateUnassignedBatchOnTimeoutSkipIgnoringNewReplicaShards() {
        allocateAllUnassignedBatch(allocation);
        // Rarely use a seqNo above retainingSeqNoOnPrimary, which could in theory happen when primary fails and comes back quickly.  
            )  
            shards.add(iterator.next().shardId());
    }
            long retainingSeqNoOnPrimary = randomLongBetween(0, Long.MAX_VALUE);  
    }
            ClusterInfo.EMPTY,
        while (iterator.hasNext()) {
        allocateAllUnassignedBatch(allocation);
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));  
            retentionLeases,
            Settings.builder().put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueHours(1)).build(),
                null,
            new RoutingNodes(state, false),
    }
    public void testCancelRecoveryBetterSyncId() {
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
            );  
            "NO_MATCH",
                );
        private AtomicBoolean fetchDataCalled = new AtomicBoolean(false);
                null,  
    private final DiscoveryNode node3 = newNode("node3");
        assertThat("failed with reason " + reason, testBatchAllocator.getFetchDataCalledAndClean(), equalTo(true));
            }
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.routing.UnassignedInfo;
            .build();  
                randomIntBetween(1, 10),
                new TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch(node, shardIdNodeStoreFilesMetadataHashMap)
        );
        );  
                "MATCH",  
    }  
            }
        );
        }  
        protected boolean hasInitiatedFetching(ShardRouting shard) {
        }
            null,  
        public TestBatchAllocator addData(
            null,
                            )
    public void testNoAsyncFetchData() {
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());  
        assertThat(allocation.routingNodesChanged(), equalTo(false));
            null,
            .addData(node2, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
    /**
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            new RoutingNodes(state, false),  
            null,  
            List<RetentionLease> peerRecoveryRetentionLeases,
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(  
        );
        final Set<String> failedNodes;  
        retentionLeases.add(newRetentionLease(node1, retainingSeqNo));  
            TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata nodeStoreFilesMetadata =
        testBatchAllocator.addData(
        final UnassignedInfo unassignedInfo;
            DiscoveryNode node,  
        assertEquals(1, routingAllocation.routingNodes().getIncomingRecoveries(node3.getId()));
                            storeFileFetchException
    }
                TestShardRouting.newShardRouting(shardIdFromBatch, node1.getId(), true, ShardRoutingState.STARTED)
import java.util.concurrent.atomic.AtomicInteger;  
                        new TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadata(
            if (randomBoolean()) {
                                        UnassignedInfo.AllocationStatus.NO_ATTEMPT,  
        );
            for (int i = 0; i < 1; i++) {
                                        delayed,
    public void testNoDataForReplicaOnAnyNode() {
        if (randomBoolean()) {  
        } else {
                        false,  
        List<RetentionLease> peerRecoveryRetentionLeasesOnPrimary = new ArrayList<>();
                        )  
        allocateAllUnassignedBatch(allocation);
            new RoutingNodes(state, false),
    public void testNoMatchingFilesForReplicaOnAnyNode() {
                    .addIndexShard(  
        List<ShardRouting> ignoredShardRoutings = routingAllocation.routingNodes().unassigned().ignored();
        if (randomBoolean()) {  
    }  
                NodeStoreFilesMetadataBatch nodeStoreFilesMetadataBatch = data.get(node);
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));  
        public void clean() {
                System.currentTimeMillis(),  
                    ),
            state,
            randomSyncId(),  
        testBatchAllocator.addData(  
import org.opensearch.common.util.set.Sets;
    private final ShardId shardId = new ShardId("test", "_na_", 0);
                    .addIndexShard(
            if (syncId != null) {
        int failedAllocations = reason == UnassignedInfo.Reason.ALLOCATION_FAILED ? 1 : 0;
        testBatchAllocator.processExistingRecoveries(
            return this;
import org.opensearch.common.unit.TimeValue;
                                TestShardRouting.newShardRouting(
import java.util.Collection;  
            ShardId shardId = new ShardId("test", "_na_", shardNumber);
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        return randomFrom("MATCH", "NOT_MATCH", null);  
                    Map.of(  
                System.nanoTime(),
            null,  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
        );
                commitData.put(Engine.SYNC_COMMIT_ID, syncId);
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(index.getName())
            node2,
                )
     * to wait till throttling on it is done.  
                IndexRoutingTable.builder(shardId.getIndex())
        );
            Map<String, String> commitData = new HashMap<>();
    public void testCancelRecoveryIfFoundCopyWithNoopRetentionLease() {
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                                    ShardRoutingState.INITIALIZING,  
        @Override
                                )
            allocation.routingNodes().unassigned().ignored().get(0).unassignedInfo().getLastAllocationStatus()
            null,
            node1,
        final RoutingAllocation routingAllocation = twoPrimaryAndOneUnAssignedReplica(allocationDeciders);
        );
        public TestBatchAllocator addShardData(
                );
                                    false,
                            System.nanoTime(),
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
                    )  
                randomIntBetween(1, 10),
            randomBoolean() ? noAllocationDeciders() : throttleAllocationDeciders()
    public void testSyncIdMatch() {  
     */  
                    shardIdFromBatch,  
     * Verifies that when there is primary data, but no matching data at all on other nodes, the shard keeps
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))  
        );  
            String syncId,  
import org.opensearch.index.seqno.RetentionLease;
import java.util.Collections;
            }  
            .addData(nodeToMatch, "MATCH", null, new StoreFileMetadata("file1", 10, "NO_MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));
    public void testDoNotCancelForInactivePrimaryNode() {
            .build();
        assertThat("failed with reason" + reason, testBatchAllocator.getShardEligibleFetchDataCountAndClean(), equalTo(1));
        }
     * Verifies that when there is no sync id match but files match, we allocate it to matching node.
            randomSyncId(),  
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
            StoreFileMetadata... files
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        List<List<ShardRouting>> shardBatchList = Collections.singletonList(
        allocateAllUnassignedBatch(routingAllocation);
                    ),
        allocateAllUnassignedBatch(allocation);
import java.util.Set;
    /**
        public TestBatchAllocator addShardData(
                        RecoverySource.PeerRecoverySource.INSTANCE,
        peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node2, randomLongBetween(1, retainingSeqNo)));
                            )  
        long retainingSeqNoOnPrimary = randomLongBetween(1, Integer.MAX_VALUE);
        testBatchAllocator.processExistingRecoveries(
                            if (node.node().equals(node2)) {
     * moves to the ignore unassigned list.  
            System.nanoTime(),
            "NOT_MATCH",
        return onePrimaryOnNode1And1ReplicaRecovering(deciders, new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null));
        failedNodes.add(node3.getId());
            UnassignedInfo.Reason.INDEX_CREATED  
            if (randomBoolean()) {
     * Verifies that for anything but index creation, fetch data ends up being called, since we need to go and try
        );
            null,
    }
            ignoredShardRoutings.get(0),
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));  
import static java.util.Collections.unmodifiableMap;
        );  
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        );
            unassignedInfo = new UnassignedInfo(  
                    null,  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)  
            ClusterInfo.EMPTY,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
        if (randomBoolean()) {  
        testBatchAllocator.processExistingRecoveries(
    /**  
            .addData(nodeToMatch, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
                    .addIndexShard(
        );
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
     */
    public void testNotCancellingRecoveryIfSyncedOnExistingRecovery() {
        assertThat(
            allocation,
            shards.add(iterator.next().shardId());
        ).addData(node2, randomSyncId(), null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
            clusterSettings,  
    }
            for (StoreFileMetadata file : files) {
        );
}
        List<RetentionLease> retentionLeases = Arrays.asList(
            );  
        testBatchAllocator.addData(
            node3,
                UnassignedInfo.Reason.ALLOCATION_FAILED,
        testBatchAllocator.addData(
                        shardId,
    }  
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
        testBatchAllocator.addData(
        assertThat(
                        Settings.EMPTY,
        Collection<ShardRouting> replicaShards = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);  
            retentionLeases.add(newRetentionLease(node1, retainingSeqNoOnPrimary));
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        testBatchAllocator.clean();
    }
            String syncId,
        testBatchAllocator.addData(
            retentionLeases,
                                        null,  
                    .numberOfReplicas(1)  
    /**
            Settings.builder()
                            Collections.emptySet()
        AllocateUnassignedDecision allocateUnassignedDecision = testBatchAllocator.makeAllocationDecision(  
            );
import static org.hamcrest.Matchers.hasSize;
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertEquals(1, initializingShards.size());
            @Nullable Exception storeFileFetchException,
        // Created started ShardRouting for each primary shards
            "MATCH",  
        testBatchAllocator.addData(
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),  
            Settings.EMPTY,
    }
            node3,
        assertThat(allocation.routingNodesChanged(), equalTo(false));  
        assertThat(allocation.routingNodesChanged(), equalTo(false));
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));  
                            .addShard(
                data = new HashMap<>();
import org.opensearch.cluster.node.DiscoveryNode;  
            equalTo(node2.getId())
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
     * See CorruptFileTest#
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
import static org.hamcrest.Matchers.equalTo;
        );
                                        reason,
                            0,  
            null,  
import org.opensearch.Version;  
        allocateAllUnassignedBatch(allocation);
        );
            IndexShardRoutingTable.Builder indexShardRoutingTableBuilder = new IndexShardRoutingTable.Builder(shardIdFromBatch);
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
    }  
    }
        allocateAllUnassignedBatch(allocation);
    public void testNotCancellingRecoveryIfCurrentRecoveryHasRetentionLease() {  
                    new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
    private RoutingAllocation onePrimaryOnNode1And1Replica(AllocationDeciders deciders) {
        );
                Collections.singleton("node-4")  
        );
            .metadata(metadata)  
            null,
        List<ShardRouting> shardToBatch = new ArrayList<>();  
            .build();  
            yesAllocationDeciders(),
        assertThat(allocation.routingNodesChanged(), equalTo(true));  
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null);  
            unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.CLUSTER_RECOVERED, null);
            }  
    }
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));  
            .routingTable(routingTable)  
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
        );
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        for (ShardId shardIdFromBatch : shardsInBatch) {
            newRetentionLease(node1, retainingSeqNoOnPrimary),  
            Settings.EMPTY,
                            .build()
        }
    /**
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(0));
        if (randomBoolean()) {  
    public void testAllocateUnassignedBatchOnTimeoutWithAlreadyRecoveringReplicaShard() {  
    /**  
            null,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));  
        assertThat(unassignedShards.get(0).unassignedInfo().getFailedNodeIds(), equalTo(failedNodes));  
     * to be allocated. This is today behavior, which relies on a primary corruption identified with
        );  
                                    )
        // lesser than or equal to allowed concurrent recoveries  
        for (ShardId shardIdFromBatch : shardsInBatch) {  
    public void testDelayedAllocation() {  
    }
     */  
        while (iterator.hasNext()) {  
        for (int shardNumber = 0; shardNumber < numberOfShards; shardNumber++) {
        private Map<DiscoveryNode, TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch> data = null;
            .build();  
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))  
                    )
            allocation,
            Map<String, String> commitData = new HashMap<>();
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
            @Nullable Exception storeFileFetchException,
        ) {  
    }  
    /**  
        long retainingSeqNoOnPrimary = randomLongBetween(0, Long.MAX_VALUE);  
        final RoutingNodes.UnassignedShards.UnassignedIterator iterator = allocation.routingNodes().unassigned().iterator();
                    null,
 * this file be licensed under the Apache-2.0 license or a
            node1,  
        assertThat(unassignedShards, hasSize(1));  
                                        Collections.emptySet()
        );
        );
            Map<String, StoreFileMetadata> filesAsMap = new HashMap<>();
    class TestBatchAllocator extends ReplicaShardBatchAllocator {  
            null,
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                        @Override  
            newRetentionLease(node3, retainingSeqNoOnPrimary)  
import org.opensearch.cluster.routing.ShardRoutingState;  
            retentionLeases,  
                        )  
            randomSyncId(),
            yesAllocationDeciders(),  
                        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    public void testIgnoreRetentionLeaseIfCopyIsEmpty() {
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
                                        null,
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            indexMetadata.putInSyncAllocationIds(  
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);  
            failedNodes = Collections.emptySet();
            List<ShardRouting> ineligibleShards,
            String syncId,
        return new RoutingAllocation(
                                    unassignedInfo
    }
    public void testNoOrThrottleDecidersRemainsInUnassigned() {
        assertThat(
    public void buildTestAllocator() {
    public void testAsyncFetchOnAnythingButIndexCreation() {
    /**  
                            UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            .routingTable(routingTable)
        allocateAllUnassignedBatch(allocation);  
        testBatchAllocator.addData(
                data = new HashMap<>();
            data.put(
        peerRecoveryRetentionLeasesOnPrimary.add(newRetentionLease(node1, retainingSeqNo));
            new AllocationDeciders(
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 1)
        allocateAllUnassignedBatch(allocation);
            )  
                node,  
        Set<ShardId> shards = new HashSet<>();  
            String syncId,
                                    unassignedInfo
        testBatchAllocator.processExistingRecoveries(allocation, shardBatchList);  
        );
    }
import java.util.ArrayList;
                .addShardData(
     */
    }  
            return addShardData(node, Collections.emptyList(), shardId, syncId, storeFileFetchException, files);
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))  
        // Create Index Routing table
        testBatchAllocator.addData(  
        while (iterator.hasNext()) {
    }  
        testBatchAllocator.addData(
            ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE
            UnassignedInfo.Reason.ALLOCATION_FAILED,
            fetchDataCalled.set(true);
            }
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))  
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);
    }  
     * Tests when the node to allocate to due to matching is being throttled, we move the shard to ignored
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            randomSyncId(),
        testBatchAllocator.addData(
        testBatchAllocator.addData(
        }
import java.util.concurrent.atomic.AtomicBoolean;
            node1,  
                                    false,
        );
            null,
                                peerRecoveryRetentionLeases  
        UnassignedInfo.Reason reason = RandomPicks.randomFrom(  
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTableBuilder.build()).build();
        );  
     * Verifies that on index creation, we don't fetch data for any shards, but keep the replica shard unassigned to let
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(  
        );
        @Override  
        }  
        List<RetentionLease> retentionLeases = new ArrayList<>();
        Map<ShardId, ShardRouting> shardIdShardRoutingMap = new HashMap<>();
    private RoutingAllocation onePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders) {
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            .addData(node2, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
        testBatchAllocator.addData(node2, null, null); // has retention lease but store is empty  
        testBatchAllocator.allocateUnassignedBatchOnTimeout(shards, allocation, false);
            null,  
                    "NO_MATCH",
            if (syncId != null) {  
                    node3,  
                            null,
        IndexMetadata.Builder indexMetadata = IndexMetadata.builder(shardId.getIndexName())
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders(), unassignedInfo);  
                        new Store.MetadataSnapshot(unmodifiableMap(filesAsMap), unmodifiableMap(commitData), randomInt()),
            "MATCH",
    /**
        );
            .addData(node2, randomSyncId(), null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))  
import java.util.HashSet;
            testBatchAllocator.addData(node2, null, null);
        }
            .numberOfReplicas(1);
        );  
            if (data.containsKey(node)) {  
            randomSyncId(),  
            .settings(settings(Version.CURRENT).put(Settings.EMPTY))
            System.nanoTime()  
                                    node2.getId(),  
            null,  
        }
import org.opensearch.common.settings.ClusterSettings;
            .addData(node3, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
            return eligibleShardFetchDataCount.getAndSet(0);
    }
            UnassignedInfo.Reason.INDEX_CREATED
import org.opensearch.cluster.routing.RoutingNodes;  
            .add(
    }
import org.opensearch.common.settings.Settings;  
                            .addShard(  
            new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING))  
        AllocationDeciders allocationDeciders = randomAllocationDeciders(
            null,
                node1,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).get(0).shardId(), equalTo(shardId));
            .build();
            }  
            node1,
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
    private final DiscoveryNode node1 = newNode("node1");  
            for (StoreFileMetadata file : files) {
 * The OpenSearch Contributors require contributions made to  
            unassignedInfo = new UnassignedInfo(  
                shardIdFromBatch,
    }
            retentionLeases.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNo)));  
        Set<String> failedNodes = new HashSet<>();
        List<RetentionLease> retentionLeases = new ArrayList<>();
                false,
            null,
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                null,
    public void testNotCancellingRecovery() {  
        testBatchAllocator.processExistingRecoveries(
            node3,  
        for (ShardId shardIdFromBatch : shardsInBatch) {
    private final DiscoveryNode node2 = newNode("node2");
                                TestShardRouting.newShardRouting(
    }
                commitData.put(Engine.SYNC_COMMIT_ID, syncId);  
            failedNodes = new HashSet<>(randomSubsetOf(Arrays.asList("node-4", "node-5", "node-6")));
            )
                System.currentTimeMillis(),  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        assertThat(  
            failedNodes.add("node4");
            shardIdNodeStoreFilesMetadataHashMap.put(shardId, nodeStoreFilesMetadata);
        } else {
            node1,
                    storeFileFetchException
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
            null,
    public void testNotCancelIfPrimaryDoesNotHaveValidRetentionLease() {  
            DiscoveryNode node,  
            .addData(node2, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION));  
                    )
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            allocation,  
            return addData(node, Collections.emptyList(), syncId, storeFileFetchException, files);
            new RoutingNodes(state, false),  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));  
                new TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch(
                retentionLeases.add(newRetentionLease(node3, randomLongBetween(0, retainingSeqNoOnPrimary)));  
                    new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)  
    private RoutingAllocation oneInactivePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders, UnassignedInfo unassignedInfo) {
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)  
        assertEquals(UnassignedInfo.AllocationStatus.NO_ATTEMPT, ignoredShardRoutings.get(0).unassignedInfo().getLastAllocationStatus());
        private AtomicInteger eligibleShardFetchDataCount = new AtomicInteger(0);  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
        UnassignedInfo unassignedInfo = new UnassignedInfo(  
        testBatchAllocator.addData(  
        ) {
            .putInSyncAllocationIds(0, Sets.newHashSet(primaryShard.allocationId().getId()));  
        );
            peerRecoveryRetentionLeasesOnPrimary,
            allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).get(0).currentNodeId(),
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
        return onePrimaryOnNode1And1Replica(deciders, Settings.EMPTY, UnassignedInfo.Reason.CLUSTER_RECOVERED);  
            node3,
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
            "MATCH",
        assertThat(allocation.routingNodes().unassigned().ignored().get(0).shardId(), equalTo(shardId));  
        testBatchAllocator.addData(
            ClusterInfo.EMPTY,
                shardIdFromBatch,
                UnassignedInfo.Reason.ALLOCATION_FAILED,
                            .build()
        DiscoveryNode nodeToMatch = randomBoolean() ? node2 : node3;  
        );  
        if (randomBoolean()) {
        }  
    private RoutingAllocation onePrimaryOnNode1And1ReplicaRecovering(AllocationDeciders deciders, UnassignedInfo unassignedInfo) {
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        testBatchAllocator.addData(
            eligibleShardFetchDataCount.set(eligibleShards.size());
     * Verifies that when there is a full match (syncId and files) we allocate it to matching node.  
            node2,
        // Allocation status for ignored replicas shards is not updated after running the deciders they just get marked as ignored.
 * SPDX-License-Identifier: Apache-2.0
        );
                false,
     * Verifies that when there is primary data, but no data at all on other nodes, the shard keeps
            node1,
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
                    )
        allocateAllUnassignedBatch(allocation);
            DiscoveryNode node,  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)  
     * Verifies that when there is a sync id match but no files match, we allocate it to matching node.
        );  
        long retainingSeqNoForNode2 = randomLongBetween(0, retainingSeqNoOnPrimary - 1);
        // Verify the throttling decider was throttled, incoming recoveries on a node should be
            }  
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch;
import org.opensearch.index.store.Store;
                filesAsMap.put(file.name(), file);
            .add(
                                ShardRouting.newUnassigned(  
                    ShardRouting.newUnassigned(
            null,
        List<ShardRouting> shardRoutingBatch = new ArrayList<>(replicaShards);
            .numberOfReplicas(1)
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));  
        Metadata metadata = Metadata.builder().put(indexMetadata).build();
        }
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))  
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());  
        assertThat(  
        testBatchAllocator.addData(node1, "MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))  
            UnassignedInfo.Reason.NODE_LEFT  
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3))
        testBatchAllocator.allocateUnassignedBatchOnTimeout(shards, allocation, false);  
        assertThat(
            null,  
import org.opensearch.cluster.node.DiscoveryNodes;
    static RetentionLease newRetentionLease(DiscoveryNode node, long retainingSeqNo) {
                Sets.newHashSet(shardIdShardRoutingMap.get(shardIdFromBatch).allocationId().getId())
    }
        }  
        testBatchAllocator.addData(
        }
     */
        assertThat(allocation.routingNodes().unassigned().ignored().size(), equalTo(1));
        RoutingTable routingTable = RoutingTable.builder()
        List<RetentionLease> retentionLeases = Arrays.asList(
                    new AllocationDecider() {
            "MATCH",  
            newRetentionLease(node1, retainingSeqNoOnPrimary),
        ) {
            ShardId shardId,  
        );  
 *
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders());
            Collections.singletonList(new ArrayList<>(allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING)))  
            "MATCH",
            .addData(node2, "NO_MATCH", null, new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION))
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(yesAllocationDeciders(), Settings.EMPTY, reason);
        long retainingSeqNo = randomLongBetween(1, Long.MAX_VALUE);
            node1,  
import org.opensearch.cluster.routing.RoutingNode;
/*  
                                    new UnassignedInfo(
            SnapshotShardSizeInfo.EMPTY,
            System.currentTimeMillis(),  
        }
                            .addShard(  
            randomNonNegativeLong(),  
import java.util.List;
        ShardRouting primaryShard = TestShardRouting.newShardRouting(shardId, node1.getId(), true, ShardRoutingState.STARTED);  
                System.nanoTime(),
            equalTo(nodeToMatch.getId())
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());
            node2,  
        assertThat(unassignedShards.get(0).shardId(), equalTo(shardId));
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
import org.opensearch.core.index.Index;  
package org.opensearch.gateway;
            allocation,
            System.nanoTime()
            node1,
        RoutingAllocation allocation = onePrimaryOnNode1And1ReplicaRecovering(yesAllocationDeciders());  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
        Set<ShardId> shards = new HashSet<>();  
                                )
                    new SameShardAllocationDecider(
                    }
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
        assertEquals(UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED, allocateUnassignedDecision.getAllocationStatus());
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        )
                                    RecoverySource.PeerRecoverySource.INSTANCE,  
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
            node1,  
            return new AsyncShardFetch.FetchResult<>(data, Collections.<ShardId, Set<String>>emptyMap());  
            null,
            "MATCH",  
        protected AsyncShardFetch.FetchResult<NodeStoreFilesMetadataBatch> fetchData(
                                    shardId,
        }  
import static org.hamcrest.Matchers.empty;  
                                shardId,
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)  
        allocateAllUnassignedBatch(allocation);
            shardToBatch.add(iterator.next());
import org.opensearch.cluster.routing.RoutingTable;
        testBatchAllocator.addData(
    public void testNoPrimaryData() {  
            null,
        final UnassignedInfo unassignedInfo;
                            System.currentTimeMillis(),
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
import org.opensearch.indices.store.TransportNodesListShardStoreMetadataBatch.NodeStoreFilesMetadataBatch;
        );
            node3,
        allocateAllUnassignedBatch(allocation);
        RoutingAllocation allocation = onePrimaryOnNode1And1Replica(
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED), empty());
        Metadata metadata = Metadata.builder()
                        new IndexShardRoutingTable.Builder(shardId).addShard(primaryShard)
                    node,
        );
            .routingTable(routingTable)
        );
    public static void setUpShards(int numberOfShards) {
import org.opensearch.cluster.metadata.Metadata;
        // mark shard as delayed if reason is NODE_LEFT
                null,
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            new StoreFileMetadata("file1", 10, "MATCH_CHECKSUM", MIN_SUPPORTED_LUCENE_VERSION)
                failedNodes  
        assertThat(unassignedShards.get(0).unassignedInfo().getNumFailedAllocations(), equalTo(0));
                    "MATCH",
        return new RoutingAllocation(  
    }
            }
        testBatchAllocator.allocateUnassignedBatchOnTimeout(shards, allocation, false);
        boolean delayed = reason == UnassignedInfo.Reason.NODE_LEFT  
            Collections.singletonList(newRetentionLease(node3, randomNonNegativeLong())),
                                    node2.getId(),  
        assertEquals(  
        assertThat(allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED), empty());
import java.util.Arrays;
        );  
