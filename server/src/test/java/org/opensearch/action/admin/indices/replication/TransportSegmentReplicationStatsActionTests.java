        ShardId shardIdThree = mock(ShardId.class);
        SegmentReplicationShardStats segmentReplicationShardStats = action.computeSegmentReplicationShardStats(shardRouting);
        assertNull(action.checkRequestBlock(metadataWriteBlockedState, new SegmentReplicationStatsRequest(), new String[] { indexName }));
            if (segRpShardStats.getAllocationId().equals(allocIdOne)) {
    private TransportService transportService;
        when(indexShard.indexSettings()).thenReturn(createIndexSettingsWithSegRepDisabled());
        ShardRouting replica1 = mock(ShardRouting.class);
    }
        ShardRouting shardRouting = mock(ShardRouting.class);
        when(primary0.allocationId()).thenReturn(allocationIdOne);
        ShardRouting shardRoutingThree = mock(ShardRouting.class);
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);
    }
        when(shardId0.getIndexName()).thenReturn("test-index-1");
            "",
    @Mock
        when(shardRouting.primary()).thenReturn(true);
import org.opensearch.indices.replication.common.ReplicationTimer;
    private IndexShard indexShard;
    public void testShardOperationWithReplicaShardActiveOnly() {
    @Mock
import org.opensearch.core.index.shard.ShardId;
        replicationLuceneIndex.addFileDetail("name2", 15, false);
        ReplicationLuceneIndex replicationLuceneIndex = new ReplicationLuceneIndex();
        builder.addGlobalBlock(writeClusterBlock);
        when(shardRoutingOne.shardId()).thenReturn(shardIdOne);
            0
        when(shardRouting.shardId()).thenReturn(shardId);
        when(completedSegmentReplicationState.getTimer()).thenReturn(replicationTimerCompleted);
            successfulShards,
            ClusterState.EMPTY_STATE
        builder = ClusterBlocks.builder();
        when(shardRouting.primary()).thenReturn(false);
        when(segmentReplicationState0.getShardRouting()).thenReturn(replica0);
        Set<SegmentReplicationShardStats> segmentReplicationShardStats0 = new HashSet<>();
        String allocIdOne = "allocIdOne";
            responses,
    }
        String allocIdThree = "allocIdThree";
        String allocIdFive = "allocIdFive";
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
    @Mock
        builder.addIndexBlock(indexName, readClusterBlock);
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);
        for (SegmentReplicationShardStats replicaStat : replicaStats1) {
    @Mock
        when(indexService.getShard(shardId.id())).thenReturn(indexShard);
import org.opensearch.transport.TransportService;
    }
import org.opensearch.cluster.routing.ShardIterator;
        List<SegmentReplicationPerGroupStats> responseStats = response.getReplicationStats().get("test-index-1");
        SegmentReplicationState segmentReplicationState1 = mock(SegmentReplicationState.class);
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        segmentReplicationShardStats1.add(segmentReplicationShardStatsOfReplica1);
            }
        assertNotNull(response);
        assertEquals(0, segmentReplicationShardStats.getBytesBehindCount());
            true,
        when(shardRoutingThree.shardId()).thenReturn(shardIdThree);
        when(searchReplica1.shardId()).thenReturn(shardId1);
        List<SegmentReplicationPerGroupStats> responseStats = response.getReplicationStats().get("test-index");
        SegmentReplicationShardStatsResponse response = action.shardOperation(request, shardRouting);
        ShardRouting shardRouting = mock(ShardRouting.class);
        when(shardRouting.allocationId()).thenReturn(allocationId);
        assertEquals(0, segmentReplicationShardStats.getCurrentReplicationLagMillis());
import org.opensearch.cluster.routing.AllocationId;
        when(segmentReplicationShardStatsFromSearchReplica.getAllocationId()).thenReturn("alloc2");
import org.opensearch.cluster.block.ClusterBlocks;
        ShardId shardIdOne = mock(ShardId.class);
 * this file be licensed under the Apache-2.0 license or a
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
    }
        int successfulShards = 3;
        assertNull(action.checkGlobalBlock(metadataWriteBlockedState, new SegmentReplicationStatsRequest()));
    public void testGlobalBlockCheck() {
            RestStatus.OK,
        ReplicationTimer replicationTimerOngoing = mock(ReplicationTimer.class);
            clusterService,
            RestStatus.OK,
            segmentReplicationShardStats,
import org.opensearch.indices.replication.SegmentReplicationTargetService;
        assertNull(response);
            }
        when(allocationIdThree.getId()).thenReturn(allocIdThree);
    private SegmentReplicationTargetService targetService;
        ClusterState clusterState = mock(ClusterState.class);
        when(replica0.isSearchOnly()).thenReturn(false);
        when(targetService.getlatestCompletedEventSegmentReplicationState(shardId)).thenReturn(completedSegmentReplicationState);
            new SegmentReplicationShardStatsResponse(segmentReplicationState1),
        ClusterBlock readClusterBlock = new ClusterBlock(
        when(routingTables.allShardsIncludingRelocationTargets(any())).thenReturn(shardsIterator);
        Set<SegmentReplicationShardStats> replicaStats0 = primStats0.getReplicaStats();
import org.opensearch.cluster.routing.ShardsIterator;
            transportService,
        ShardRouting shardRouting = mock(ShardRouting.class);
        List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>();
        int totalShards = 6;
import org.opensearch.index.SegmentReplicationShardStats;
        assertNotNull(action.checkGlobalBlock(metadataReadBlockedState, new SegmentReplicationStatsRequest()));
        when(shardId1.getId()).thenReturn(1);
        segmentReplicationShardStats.add(segmentReplicationShardStatsOfReplica);
        ShardRouting shardRoutingOne = mock(ShardRouting.class);
        when(indicesService.indexServiceSafe(shardId.getIndex())).thenReturn(indexService);
        );
import java.util.EnumSet;
            true,
        String allocIdFour = "allocIdFour";
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(shardIdTwo.getId()).thenReturn(2);
        ReplicationLuceneIndex replicationLuceneIndex = new ReplicationLuceneIndex();
            RestStatus.OK,
        ShardRouting primary0 = mock(ShardRouting.class);
        when(shardRouting.shardId()).thenReturn(shardId);
        MockitoAnnotations.openMocks(this);
        verify(pressureService).getStatsForShard(any());
import org.opensearch.indices.IndicesService;
import java.util.List;
            .build();
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
        when(replica0.shardId()).thenReturn(shardId0);
    private TransportSegmentReplicationStatsAction action;
        when(allocationIdFour.getId()).thenReturn(allocIdFour);
        when(indexService.getShard(shardId.id())).thenReturn(indexShard);
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
    @Before
        assertEquals(15, segmentReplicationShardStats.getLastCompletedReplicationTimeMillis());
            "",
        when(targetService.getOngoingEventSegmentReplicationState(shardId)).thenReturn(onGoingSegmentReplicationState);
        SegmentReplicationState onGoingSegmentReplicationState = mock(SegmentReplicationState.class);
        when(onGoingSegmentReplicationState.getTimer()).thenReturn(replicationTimerOngoing);
        SegmentReplicationState completedSegmentReplicationState = mock(SegmentReplicationState.class);
    }
        when(shardRouting.primary()).thenReturn(false);
        when(primary0.shardId()).thenReturn(shardId0);
            0
        ClusterState metadataWriteBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
            EnumSet.of(ClusterBlockLevel.METADATA_READ)
            1,
        SegmentReplicationPerGroupStats segmentReplicationPerGroupStats1 = new SegmentReplicationPerGroupStats(
        when(segmentReplicationState1.getShardRouting()).thenReturn(replica1);
        when(indexService.getShard(shardId.id())).thenReturn(indexShard);
        String allocIdSix = "allocIdSix";
        when(primary0.isSearchOnly()).thenReturn(false);
        String indexName = "test";
        SegmentReplicationPerGroupStats segmentReplicationPerGroupStats0 = new SegmentReplicationPerGroupStats(
    @Mock
            new SegmentReplicationShardStatsResponse(searchReplicaSegmentReplicationState0),
        );
import static org.mockito.Mockito.mock;
    public void testIndexBlockCheck() {
    }
            "uuid",
        responses.add(null);
 * SPDX-License-Identifier: Apache-2.0
        when(searchReplicaSegmentReplicationState0.getShardRouting()).thenReturn(searchReplica0);
            failedShard,
        when(allocationIdSix.getId()).thenReturn(allocIdSix);
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
        when(replica1.allocationId()).thenReturn(allocationIdFive);
        AllocationId allocationId = AllocationId.newInitializing();
        when(searchReplica0.isSearchOnly()).thenReturn(true);
        SegmentReplicationStatsResponse response = action.newResponse(
            true,
        AllocationId allocationIdTwo = mock(AllocationId.class);
    }
        Set<SegmentReplicationShardStats> segmentReplicationShardStats = new HashSet<>();
        when(allocationIdFive.getId()).thenReturn(allocIdFive);
        SegmentReplicationState segmentReplicationState0 = mock(SegmentReplicationState.class);
        when(indicesService.indexServiceSafe(shardId.getIndex())).thenReturn(indexService);
            new SegmentReplicationShardStatsResponse(segmentReplicationState0),
        replicationLuceneIndex.addFileDetail("name1", 10, false);
import org.opensearch.core.index.Index;
    private SegmentReplicationPressureService pressureService;
            new SegmentReplicationShardStatsResponse(searchReplicaSegmentReplicationState1)
        Settings settings = Settings.builder()
        );
        SegmentReplicationShardStats segmentReplicationShardStats = action.computeSegmentReplicationShardStats(shardRouting);
        long time1 = 10;
        SegmentReplicationShardStatsResponse response = action.shardOperation(request, shardRouting);
/*
            1,
        ClusterBlock writeClusterBlock = new ClusterBlock(
        List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>();
        AllocationId allocationIdFour = mock(AllocationId.class);
        ReplicationTimer replicationTimerCompleted = mock(ReplicationTimer.class);
    private IndexSettings createIndexSettingsWithSegRepDisabled() {
        when(replicationTimerCompleted.time()).thenReturn(time2);
        assertNotNull(segmentReplicationShardStats);
            }
        ReplicationTimer replicationTimerOngoing = mock(ReplicationTimer.class);
        }
        builder.addIndexBlock(indexName, writeClusterBlock);
        ShardId shardId1 = mock(ShardId.class);
import org.opensearch.cluster.ClusterState;
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
import org.opensearch.index.IndexSettings;
        when(shardId1.getIndexName()).thenReturn("test-index-1");
    public void testCalculateBytesRemainingToReplicateWhenNoCompletedAndOngoingState() {
            segmentReplicationShardStats1,
            }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            0
            "",
import org.opensearch.common.settings.Settings;
            if (replicaStat.getAllocationId().equals(allocIdTwo)) {
        when(indexShard.indexSettings()).thenReturn(createIndexSettingsWithSegRepEnabled());
        when(allocationIdOne.getId()).thenReturn(allocIdOne);
            true,
            true,
        when(shardIdThree.getId()).thenReturn(3);
    public void setUp() throws Exception {
        assertNotNull(response);
            new SegmentReplicationShardStatsResponse(segmentReplicationPerGroupStats0),
        request.shards(shards);
import static org.mockito.Mockito.when;
        when(shardRouting.allocationId()).thenReturn(allocationId);
                assertEquals(segmentReplicationShardStatsFromSearchReplica, segRpShardStats);
    public void testComputeBytesRemainingToReplicateWhenCompletedAndOngoingStateNotNull() {
            .build();
    }
            request,
        SegmentReplicationPerGroupStats primStats = responseStats.get(0);
            if (segRpShardStats.getAllocationId().equals(allocIdTwo)) {
            "uuid",
        when(segmentReplicationState.getShardRouting()).thenReturn(shardRoutingTwo);
import static org.mockito.ArgumentMatchers.any;
        assertEquals(2, replicaStats1.size());
            totalShards,
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
    }
        super.setUp();
        when(replica1.shardId()).thenReturn(shardId1);
        when(primary1.isSearchOnly()).thenReturn(false);
        AllocationId allocationIdFive = mock(AllocationId.class);
        SegmentReplicationStatsRequest segmentReplicationStatsRequest = mock(SegmentReplicationStatsRequest.class);
            true,
        AllocationId allocationId = AllocationId.newInitializing();
import java.util.Set;
 * The OpenSearch Contributors require contributions made to
            true,
        Set<SegmentReplicationShardStats> replicaStats1 = primStats1.getReplicaStats();
            failedShard,
        when(shardRouting.shardId()).thenReturn(shardId);
        assertEquals(10, segmentReplicationShardStats.getCurrentReplicationLagMillis());
        SegmentReplicationPerGroupStats primStats0 = responseStats.get(0);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
package org.opensearch.action.admin.indices.replication;
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
        when(replicationTimerCompleted.time()).thenReturn(time2);
import org.opensearch.core.rest.RestStatus;
import org.junit.Before;
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
import org.opensearch.action.support.ActionFilters;
            RestStatus.OK,
        verify(targetService).getSegmentReplicationState(shardId);
        assertEquals(25, segmentReplicationShardStats.getBytesBehindCount());
        when(shardIdOne.getId()).thenReturn(1);
            if (replicaStat.getAllocationId().equals(allocIdSix)) {
        );
        assertEquals(2, replicaStats0.size());
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
            true,
import org.opensearch.indices.replication.common.ReplicationType;
        when(shardRouting.shardId()).thenReturn(shardId);
            new SegmentReplicationShardStatsResponse(segmentReplicationPerGroupStats1),
        SegmentReplicationPerGroupStats segmentReplicationPerGroupStats = new SegmentReplicationPerGroupStats(
        ShardRouting searchReplica0 = mock(ShardRouting.class);
import org.mockito.Mock;
        SegmentReplicationState onGoingSegmentReplicationState = mock(SegmentReplicationState.class);
import org.opensearch.test.OpenSearchTestCase;
        when(searchReplica0.shardId()).thenReturn(shardId0);
        String[] shards = { "0", "1" };
        builder.addGlobalBlock(readClusterBlock);
            responses,
    public void testShardOperationWithSegRepDisabled() {
        SegmentReplicationShardStats segmentReplicationShardStats = action.computeSegmentReplicationShardStats(shardRouting);
        when(replica1.isSearchOnly()).thenReturn(false);
        assertEquals(0, segmentReplicationShardStats.getBytesBehindCount());
        action = new TransportSegmentReplicationStatsAction(
            EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
        when(replica0.allocationId()).thenReturn(allocationIdTwo);
        ShardRouting searchReplica1 = mock(ShardRouting.class);
        ShardId shardId0 = mock(ShardId.class);
        assertNotNull(action.checkRequestBlock(metadataReadBlockedState, new SegmentReplicationStatsRequest(), new String[] { indexName }));
    public void testShardOperationWithPrimaryShard() {
        String allocIdTwo = "allocIdTwo";
        ShardId shardIdTwo = mock(ShardId.class);
        for (SegmentReplicationShardStats replicaStat : replicaStats0) {
import org.opensearch.cluster.routing.RoutingTable;
        int failedShard = 0;
            shardFailures,
            shardId1,
        assertNotNull(segmentReplicationShardStats);
        List<SegmentReplicationShardStatsResponse> responses = new ArrayList<>();
        when(searchReplica0.allocationId()).thenReturn(allocationIdThree);
                assertEquals(segmentReplicationState1, replicaStat.getCurrentReplicationState());
        }
import org.opensearch.cluster.routing.ShardRouting;
            shardIdOne,
        assertEquals(0, segmentReplicationShardStats.getLastCompletedReplicationTimeMillis());
 *
        ShardsIterator shardsIterator = mock(ShardIterator.class);
            true,
            "uuid",
        when(indicesService.indexServiceSafe(shardId.getIndex())).thenReturn(indexService);
        assertNotNull(response.getReplicaStats());
        SegmentReplicationShardStats segmentReplicationShardStats = action.computeSegmentReplicationShardStats(shardRouting);
        ClusterBlock readClusterBlock = new ClusterBlock(
            "",
        long time2 = 15;
        String[] shards = {};
import org.mockito.MockitoAnnotations;
        int totalShards = 3;
    @Mock
        ClusterState metadataWriteBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
        responses.add(new SegmentReplicationShardStatsResponse(segmentReplicationPerGroupStats));
        when(targetService.getOngoingEventSegmentReplicationState(shardId)).thenReturn(onGoingSegmentReplicationState);
        when(indicesService.indexServiceSafe(shardId.getIndex())).thenReturn(indexService);
        when(allocationIdTwo.getId()).thenReturn(allocIdTwo);
        SegmentReplicationState searchReplicaSegmentReplicationState0 = mock(SegmentReplicationState.class);
        assertNull(response.getPrimaryStats());
        assertEquals(10, segmentReplicationShardStats.getCurrentReplicationLagMillis());
        SegmentReplicationState onGoingSegmentReplicationState = mock(SegmentReplicationState.class);
        AllocationId allocationIdThree = mock(AllocationId.class);
        when(onGoingSegmentReplicationState.getTimer()).thenReturn(replicationTimerOngoing);
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
            pressureService
import org.opensearch.index.shard.IndexShard;
 * compatible open source license.
            totalShards,
    }
        ShardRouting shardRouting = mock(ShardRouting.class);
            if (replicaStat.getAllocationId().equals(allocIdThree)) {
            indexNameExpressionResolver,
        when(shardRouting.allocationId()).thenReturn(allocationId);
import org.opensearch.Version;
        AllocationId allocationId = mock(AllocationId.class);
        for (SegmentReplicationShardStats segRpShardStats : segRpShardStatsSet) {
import org.opensearch.index.SegmentReplicationPerGroupStats;
            segmentReplicationShardStats0,
        when(primary1.shardId()).thenReturn(shardId1);
        verify(targetService).getlatestCompletedEventSegmentReplicationState(shardId);
        String allocIdTwo = "allocIdTwo";
    }
        when(completedSegmentReplicationState.getTimer()).thenReturn(replicationTimerCompleted);
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
                assertEquals(segmentReplicationState, segRpShardStats.getCurrentReplicationState());
        assertNotNull(response.getReplicaStats());
    private IndexSettings createIndexSettingsWithSegRepEnabled() {
        when(indexShard.indexSettings()).thenReturn(createIndexSettingsWithSegRepEnabled());
        assertEquals(0, segmentReplicationShardStats.getCurrentReplicationLagMillis());
            shardFailures,
        SegmentReplicationShardStats segmentReplicationShardStatsOfReplica0 = new SegmentReplicationShardStats(allocIdTwo, 0, 0, 0, 0, 0);
        when(shardIdOne.getIndexName()).thenReturn("test-index");
    @Mock
        when(allocationId.getId()).thenReturn(allocIdOne);
    public void testShardReturnsAllTheShardsForTheIndex() {
    }
        verify(targetService).getlatestCompletedEventSegmentReplicationState(shardId);
            true,
        ShardRouting shardRouting = mock(ShardRouting.class);
import org.opensearch.cluster.block.ClusterBlock;
        ShardRouting replica0 = mock(ShardRouting.class);
        request.activeOnly(true);
        when(searchReplicaSegmentReplicationState1.getShardRouting()).thenReturn(searchReplica1);
import org.opensearch.index.IndexService;
    private IndicesService indicesService;
        when(shardRouting.shardId()).thenReturn(shardId);
import static org.mockito.Mockito.verify;
public class TransportSegmentReplicationStatsActionTests extends OpenSearchTestCase {
            if (replicaStat.getAllocationId().equals(allocIdFive)) {
    private ActionFilters actionFilters;
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);
        verify(targetService).getlatestCompletedEventSegmentReplicationState(shardId);
        ShardRouting shardRoutingTwo = mock(ShardRouting.class);
            actionFilters,
    private IndexService indexService;
        SegmentReplicationState segmentReplicationState = mock(SegmentReplicationState.class);
        );
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
    public void testNewResponseWhenAllReplicasReturnResponseCombinesTheResults() {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
        assertEquals(0, segmentReplicationShardStats.getLastCompletedReplicationTimeMillis());
        assertEquals(15, segmentReplicationShardStats.getLastCompletedReplicationTimeMillis());
        return new IndexSettings(IndexMetadata.builder("test").settings(settings).build(), settings);
        assertEquals(25, segmentReplicationShardStats.getBytesBehindCount());
        SegmentReplicationShardStats segmentReplicationShardStatsOfReplica1 = new SegmentReplicationShardStats(allocIdFive, 0, 0, 0, 0, 0);
        when(clusterState.routingTable()).thenReturn(routingTables);
            shardId0,
        AllocationId allocationId = AllocationId.newInitializing();
import java.util.ArrayList;
        AllocationId allocationIdOne = mock(AllocationId.class);
        int successfulShards = 6;
            indicesService,
        when(replicationTimerOngoing.time()).thenReturn(time1);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        when(primary1.allocationId()).thenReturn(allocationIdFour);
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
        builder = ClusterBlocks.builder();
        );
        );
            }
        verify(targetService).getlatestCompletedEventSegmentReplicationState(shardId);
        when(onGoingSegmentReplicationState.getIndex()).thenReturn(replicationLuceneIndex);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        Set<SegmentReplicationShardStats> segRpShardStatsSet = primStats.getReplicaStats();
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
            1,
        long time2 = 15;
import org.opensearch.cluster.metadata.IndexMetadata;
        when(shardRouting.shardId()).thenReturn(shardId);
        );
        );
        List<SegmentReplicationShardStatsResponse> responses = List.of(
        when(shardRoutingTwo.shardId()).thenReturn(shardIdTwo);
        Settings settings = Settings.builder()
        assertNotNull(segmentReplicationShardStats);
    public void testShardOperationWithReplicaShard() {
    public void testNewResponseWhenShardsToFetchEmptyAndResponsesContainsNull() {
            }
        when(targetService.getOngoingEventSegmentReplicationState(shardId)).thenReturn(onGoingSegmentReplicationState);
import org.opensearch.cluster.service.ClusterService;
        when(indexShard.indexSettings()).thenReturn(createIndexSettingsWithSegRepEnabled());
        when(targetService.getlatestCompletedEventSegmentReplicationState(shardId)).thenReturn(completedSegmentReplicationState);
import java.util.HashSet;
        when(shardRouting.allocationId()).thenReturn(allocationId);
}
        ShardRouting primary1 = mock(ShardRouting.class);
        assertNotNull(segmentReplicationShardStats);
    @Mock
                assertEquals(searchReplicaSegmentReplicationState1, replicaStat.getCurrentReplicationState());
    public void testCalculateBytesRemainingToReplicateWhenNoCompletedState() {
        ClusterBlock writeClusterBlock = new ClusterBlock(
        SegmentReplicationShardStatsResponse response = action.shardOperation(request, shardRouting);
        when(shardRoutingTwo.allocationId()).thenReturn(allocationId);
        );
        int failedShard = 0;
            request,
        SegmentReplicationState searchReplicaSegmentReplicationState1 = mock(SegmentReplicationState.class);
            EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        when(onGoingSegmentReplicationState.getIndex()).thenReturn(replicationLuceneIndex);
        SegmentReplicationShardStats segmentReplicationShardStatsOfReplica = new SegmentReplicationShardStats(allocIdOne, 0, 0, 0, 0, 0);
        ReplicationTimer replicationTimerCompleted = mock(ReplicationTimer.class);
        when(shardRouting.shardId()).thenReturn(shardId);
        SegmentReplicationState completedSegmentReplicationState = mock(SegmentReplicationState.class);
        when(targetService.getSegmentReplicationState(shardId)).thenReturn(completedSegmentReplicationState);
        when(shardRouting.shardId()).thenReturn(shardId);
    }
        replicationLuceneIndex.addFileDetail("name2", 15, false);
        segmentReplicationShardStats0.add(segmentReplicationShardStatsOfReplica0);
        SegmentReplicationState completedSegmentReplicationState = mock(SegmentReplicationState.class);
        );
        String[] concreteIndices = new String[] { "test-index" };
            true,
        when(indexService.getShard(shardId.id())).thenReturn(indexShard);
    public void testCalculateBytesRemainingToReplicateWhenNoOnGoingState() {
import org.opensearch.index.SegmentReplicationPressureService;
        when(shardId0.getId()).thenReturn(0);
        ShardRouting shardRouting = mock(ShardRouting.class);
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);
        when(replicationTimerOngoing.time()).thenReturn(time1);
        ShardRouting shardRouting = mock(ShardRouting.class);
        assertEquals(shardsIterator, action.shards(clusterState, segmentReplicationStatsRequest, concreteIndices));
        RoutingTable routingTables = mock(RoutingTable.class);
    }
        request.activeOnly(false);
            ClusterState.EMPTY_STATE
import org.opensearch.indices.replication.SegmentReplicationState;
        assertNotNull(response);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        AllocationId allocationId = AllocationId.newInitializing();
        return new IndexSettings(IndexMetadata.builder("test").settings(settings).build(), settings);
 */
        SegmentReplicationStatsResponse response = action.newResponse(
        Set<SegmentReplicationShardStats> segmentReplicationShardStats1 = new HashSet<>();
    }
            1,
    @Mock
        replicationLuceneIndex.addFileDetail("name1", 10, false);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(searchReplica1.isSearchOnly()).thenReturn(true);
                assertEquals(searchReplicaSegmentReplicationState0, replicaStat.getCurrentReplicationState());
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);
            targetService,
            true,
        assertNull(response.getPrimaryStats());
        ShardRouting shardRouting = mock(ShardRouting.class);
        SegmentReplicationPerGroupStats primStats1 = responseStats.get(1);
        String allocIdOne = "allocIdOne";
            "uuid",
            successfulShards,
            EnumSet.of(ClusterBlockLevel.METADATA_READ)
        SegmentReplicationShardStatsResponse response = action.shardOperation(request, shardRouting);
        AllocationId allocationIdSix = mock(AllocationId.class);
import org.opensearch.cluster.block.ClusterBlockLevel;
    private IndexNameExpressionResolver indexNameExpressionResolver;
        when(searchReplica1.allocationId()).thenReturn(allocationIdSix);
                assertEquals(segmentReplicationState0, replicaStat.getCurrentReplicationState());
        long time1 = 10;
    private ClusterService clusterService;
        }
        SegmentReplicationShardStats segmentReplicationShardStatsFromSearchReplica = mock(SegmentReplicationShardStats.class);
        responses.add(new SegmentReplicationShardStatsResponse(segmentReplicationState));
        request.shards(shards);
