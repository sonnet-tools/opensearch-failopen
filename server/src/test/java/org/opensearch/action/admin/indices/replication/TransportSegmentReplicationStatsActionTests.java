            clusterService,
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);
    @Mock
            true,  
            0
        SegmentReplicationPerGroupStats segmentReplicationPerGroupStats0 = new SegmentReplicationPerGroupStats(
    public void testCalculateBytesRemainingToReplicateWhenNoCompletedAndOngoingState() {  
        ShardRouting shardRouting = mock(ShardRouting.class);
        SegmentReplicationPerGroupStats primStats1 = responseStats.get(1);
        List<SegmentReplicationPerGroupStats> responseStats = response.getReplicationStats().get("test-index-1");  
        String allocIdFour = "allocIdFour";  
        when(shardRouting.primary()).thenReturn(false);
    }
        when(searchReplica1.isSearchOnly()).thenReturn(true);  
        assertEquals(15, segmentReplicationShardStats.getLastCompletedReplicationTimeMillis());  
        when(searchReplica0.shardId()).thenReturn(shardId0);  
        MockitoAnnotations.openMocks(this);
        when(targetService.getOngoingEventSegmentReplicationState(shardId)).thenReturn(onGoingSegmentReplicationState);
import org.opensearch.indices.replication.common.ReplicationTimer;  
import static org.mockito.Mockito.verify;
            true,  
            actionFilters,  
            new SegmentReplicationShardStatsResponse(segmentReplicationState1),
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        SegmentReplicationStatsRequest segmentReplicationStatsRequest = mock(SegmentReplicationStatsRequest.class);
        assertNotNull(action.checkGlobalBlock(metadataReadBlockedState, new SegmentReplicationStatsRequest()));
import org.opensearch.indices.replication.SegmentReplicationTargetService;
        when(primary1.allocationId()).thenReturn(allocationIdFour);  
        builder.addIndexBlock(indexName, writeClusterBlock);  
        List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>();  
        when(indicesService.indexServiceSafe(shardId.getIndex())).thenReturn(indexService);
    public void testShardReturnsAllTheShardsForTheIndex() {  
    }
        verify(pressureService).getStatsForShard(any());
    public void testCalculateBytesRemainingToReplicateWhenNoCompletedState() {  
        when(onGoingSegmentReplicationState.getIndex()).thenReturn(replicationLuceneIndex);
import java.util.ArrayList;  
            EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
    @Mock
            new SegmentReplicationShardStatsResponse(searchReplicaSegmentReplicationState0),
        when(primary1.isSearchOnly()).thenReturn(false);
        when(allocationIdSix.getId()).thenReturn(allocIdSix);
        when(shardId1.getId()).thenReturn(1);
            if (segRpShardStats.getAllocationId().equals(allocIdTwo)) {
            indexNameExpressionResolver,
    public void testShardOperationWithReplicaShard() {
            request,  
            }  
            new SegmentReplicationShardStatsResponse(searchReplicaSegmentReplicationState1)
        String allocIdFive = "allocIdFive";
        when(primary0.shardId()).thenReturn(shardId0);
            }  
    private IndexNameExpressionResolver indexNameExpressionResolver;
            true,  
            successfulShards,  
        long time1 = 10;  
            "uuid",
        String allocIdOne = "allocIdOne";
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);  
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();  
        SegmentReplicationShardStats segmentReplicationShardStats = action.computeSegmentReplicationShardStats(shardRouting);
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);  
        when(primary0.allocationId()).thenReturn(allocationIdOne);  
        ShardRouting primary1 = mock(ShardRouting.class);
        AllocationId allocationId = AllocationId.newInitializing();  
        assertNotNull(response.getReplicaStats());
        ClusterBlocks.Builder builder = ClusterBlocks.builder();
        when(indexService.getShard(shardId.id())).thenReturn(indexShard);
    }
        assertNotNull(response);  
        builder.addIndexBlock(indexName, readClusterBlock);
        );  
        when(shardRouting.shardId()).thenReturn(shardId);
        ShardRouting shardRouting = mock(ShardRouting.class);  
import org.opensearch.Version;
        when(replica1.isSearchOnly()).thenReturn(false);
        int totalShards = 6;  
        SegmentReplicationShardStatsResponse response = action.shardOperation(request, shardRouting);
        String[] shards = { "0", "1" };  
        SegmentReplicationState onGoingSegmentReplicationState = mock(SegmentReplicationState.class);
    @Mock
        ReplicationTimer replicationTimerCompleted = mock(ReplicationTimer.class);
        RoutingTable routingTables = mock(RoutingTable.class);
        );
        when(indexService.getShard(shardId.id())).thenReturn(indexShard);
            true,
        AllocationId allocationId = AllocationId.newInitializing();  
        when(replica0.allocationId()).thenReturn(allocationIdTwo);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    }  
        AllocationId allocationId = AllocationId.newInitializing();
    @Before  
        SegmentReplicationState searchReplicaSegmentReplicationState0 = mock(SegmentReplicationState.class);
        when(indexShard.indexSettings()).thenReturn(createIndexSettingsWithSegRepEnabled());  
        ReplicationTimer replicationTimerOngoing = mock(ReplicationTimer.class);
package org.opensearch.action.admin.indices.replication;
        when(searchReplica0.isSearchOnly()).thenReturn(true);  
    }
            if (segRpShardStats.getAllocationId().equals(allocIdOne)) {  
        verify(targetService).getSegmentReplicationState(shardId);  
            if (replicaStat.getAllocationId().equals(allocIdFive)) {  
            "uuid",  
        when(targetService.getlatestCompletedEventSegmentReplicationState(shardId)).thenReturn(completedSegmentReplicationState);  
        assertNotNull(segmentReplicationShardStats);
        int failedShard = 0;  
        SegmentReplicationShardStats segmentReplicationShardStatsOfReplica1 = new SegmentReplicationShardStats(allocIdFive, 0, 0, 0, 0, 0);
        when(onGoingSegmentReplicationState.getTimer()).thenReturn(replicationTimerOngoing);
        Settings settings = Settings.builder()
        int successfulShards = 6;
        replicationLuceneIndex.addFileDetail("name1", 10, false);  
        for (SegmentReplicationShardStats replicaStat : replicaStats1) {
        SegmentReplicationPerGroupStats primStats = responseStats.get(0);
        replicationLuceneIndex.addFileDetail("name2", 15, false);
    public void setUp() throws Exception {
        ShardRouting shardRouting = mock(ShardRouting.class);
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
            1,
        int successfulShards = 3;
        request.activeOnly(false);  
import static org.mockito.Mockito.when;  
        int failedShard = 0;
import org.opensearch.cluster.routing.AllocationId;  
        assertNotNull(response.getReplicaStats());  
        SegmentReplicationState onGoingSegmentReplicationState = mock(SegmentReplicationState.class);
        SegmentReplicationState segmentReplicationState0 = mock(SegmentReplicationState.class);
            segmentReplicationShardStats1,  
    public void testShardOperationWithSegRepDisabled() {
    public void testCalculateBytesRemainingToReplicateWhenNoOnGoingState() {
/*  
        SegmentReplicationState segmentReplicationState1 = mock(SegmentReplicationState.class);  
        Set<SegmentReplicationShardStats> replicaStats1 = primStats1.getReplicaStats();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
            EnumSet.of(ClusterBlockLevel.METADATA_READ)
        AllocationId allocationIdThree = mock(AllocationId.class);
        String[] concreteIndices = new String[] { "test-index" };
        request.shards(shards);
    @Mock
        ShardRouting searchReplica0 = mock(ShardRouting.class);
    }
        responses.add(null);
        when(searchReplica0.allocationId()).thenReturn(allocationIdThree);
import org.opensearch.index.shard.IndexShard;
        when(shardRoutingTwo.allocationId()).thenReturn(allocationId);
        ShardRouting shardRouting = mock(ShardRouting.class);  
        Settings settings = Settings.builder()
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        assertNull(response.getPrimaryStats());
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
    }
 * compatible open source license.
        ShardsIterator shardsIterator = mock(ShardIterator.class);
            true,
        SegmentReplicationShardStats segmentReplicationShardStats = action.computeSegmentReplicationShardStats(shardRouting);  
    }
        int totalShards = 3;
    @Mock
        SegmentReplicationShardStats segmentReplicationShardStats = action.computeSegmentReplicationShardStats(shardRouting);
    public void testShardOperationWithReplicaShardActiveOnly() {  
    }
        }
        super.setUp();  
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);  
    public void testComputeBytesRemainingToReplicateWhenCompletedAndOngoingStateNotNull() {
        when(shardIdThree.getId()).thenReturn(3);
    public void testShardOperationWithPrimaryShard() {  
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
            RestStatus.OK,  
            new SegmentReplicationShardStatsResponse(segmentReplicationPerGroupStats1),  
import org.opensearch.index.SegmentReplicationShardStats;  
        ShardRouting replica1 = mock(ShardRouting.class);
            0
        assertEquals(0, segmentReplicationShardStats.getCurrentReplicationLagMillis());
        when(shardRouting.shardId()).thenReturn(shardId);
        }  
        ClusterState clusterState = mock(ClusterState.class);  
import org.mockito.Mock;  
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
        SegmentReplicationStatsResponse response = action.newResponse(
        when(replica1.shardId()).thenReturn(shardId1);
    }
import static org.mockito.Mockito.mock;
import org.opensearch.transport.TransportService;  
        SegmentReplicationPerGroupStats segmentReplicationPerGroupStats = new SegmentReplicationPerGroupStats(
            targetService,
        assertEquals(2, replicaStats0.size());  
        assertEquals(0, segmentReplicationShardStats.getBytesBehindCount());
    private IndexSettings createIndexSettingsWithSegRepDisabled() {  
 *
        when(onGoingSegmentReplicationState.getIndex()).thenReturn(replicationLuceneIndex);
            request,
        assertEquals(0, segmentReplicationShardStats.getBytesBehindCount());
            "",
            shardId0,
            true,
        SegmentReplicationState onGoingSegmentReplicationState = mock(SegmentReplicationState.class);
import org.opensearch.core.index.Index;
        verify(targetService).getlatestCompletedEventSegmentReplicationState(shardId);
        Set<SegmentReplicationShardStats> replicaStats0 = primStats0.getReplicaStats();
    private ActionFilters actionFilters;  
        when(shardIdOne.getIndexName()).thenReturn("test-index");  
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
            RestStatus.OK,
        );  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
    private IndexShard indexShard;  
        String allocIdThree = "allocIdThree";
import org.opensearch.cluster.metadata.IndexMetadata;
        AllocationId allocationIdOne = mock(AllocationId.class);
            if (replicaStat.getAllocationId().equals(allocIdTwo)) {
        ShardRouting shardRouting = mock(ShardRouting.class);
        );
        when(allocationIdFive.getId()).thenReturn(allocIdFive);
                assertEquals(segmentReplicationShardStatsFromSearchReplica, segRpShardStats);
        when(segmentReplicationState.getShardRouting()).thenReturn(shardRoutingTwo);
            totalShards,
import org.opensearch.cluster.routing.RoutingTable;
import org.junit.Before;
        for (SegmentReplicationShardStats segRpShardStats : segRpShardStatsSet) {
 * The OpenSearch Contributors require contributions made to  
        return new IndexSettings(IndexMetadata.builder("test").settings(settings).build(), settings);  
        when(shardRoutingTwo.shardId()).thenReturn(shardIdTwo);
        ShardId shardId1 = mock(ShardId.class);  
            1,  
        when(replicationTimerOngoing.time()).thenReturn(time1);  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        ShardRouting replica0 = mock(ShardRouting.class);  
import org.opensearch.index.IndexSettings;  
        when(shardIdOne.getId()).thenReturn(1);  
            }
    public void testIndexBlockCheck() {
        when(targetService.getOngoingEventSegmentReplicationState(shardId)).thenReturn(onGoingSegmentReplicationState);  
        SegmentReplicationPerGroupStats primStats0 = responseStats.get(0);
        when(allocationIdTwo.getId()).thenReturn(allocIdTwo);
import org.opensearch.cluster.routing.ShardRouting;  
            ClusterState.EMPTY_STATE
        when(shardRouting.allocationId()).thenReturn(allocationId);
            new SegmentReplicationShardStatsResponse(segmentReplicationPerGroupStats0),  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.SegmentReplicationPressureService;
        SegmentReplicationState completedSegmentReplicationState = mock(SegmentReplicationState.class);
        );  
        Set<SegmentReplicationShardStats> segmentReplicationShardStats1 = new HashSet<>();  
import org.opensearch.indices.replication.common.ReplicationType;
import org.mockito.MockitoAnnotations;
        ClusterBlocks.Builder builder = ClusterBlocks.builder();  
        segmentReplicationShardStats0.add(segmentReplicationShardStatsOfReplica0);
            shardId1,
        List<SegmentReplicationShardStatsResponse> responses = new ArrayList<>();
        return new IndexSettings(IndexMetadata.builder("test").settings(settings).build(), settings);
    }  
        Set<SegmentReplicationShardStats> segmentReplicationShardStats0 = new HashSet<>();
        when(routingTables.allShardsIncludingRelocationTargets(any())).thenReturn(shardsIterator);
        verify(targetService).getlatestCompletedEventSegmentReplicationState(shardId);
            successfulShards,
        assertEquals(0, segmentReplicationShardStats.getLastCompletedReplicationTimeMillis());  
        when(primary1.shardId()).thenReturn(shardId1);
        SegmentReplicationShardStats segmentReplicationShardStatsOfReplica = new SegmentReplicationShardStats(allocIdOne, 0, 0, 0, 0, 0);  
import org.opensearch.indices.replication.SegmentReplicationState;  
        ShardRouting shardRouting = mock(ShardRouting.class);
        assertNull(action.checkGlobalBlock(metadataWriteBlockedState, new SegmentReplicationStatsRequest()));  
import org.opensearch.cluster.routing.ShardIterator;
        ShardId shardId0 = mock(ShardId.class);
import org.opensearch.indices.IndicesService;
        when(searchReplica1.shardId()).thenReturn(shardId1);  
            true,
import java.util.HashSet;
            .build();  
            if (replicaStat.getAllocationId().equals(allocIdSix)) {
        AllocationId allocationId = mock(AllocationId.class);  
        when(completedSegmentReplicationState.getTimer()).thenReturn(replicationTimerCompleted);
        ClusterState metadataWriteBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
            failedShard,
    }
            "uuid",
    private SegmentReplicationTargetService targetService;
            0
        ShardRouting primary0 = mock(ShardRouting.class);
import org.opensearch.test.OpenSearchTestCase;
                assertEquals(segmentReplicationState1, replicaStat.getCurrentReplicationState());
        SegmentReplicationState completedSegmentReplicationState = mock(SegmentReplicationState.class);  
        replicationLuceneIndex.addFileDetail("name2", 15, false);  
        ReplicationLuceneIndex replicationLuceneIndex = new ReplicationLuceneIndex();
        when(clusterState.routingTable()).thenReturn(routingTables);
        action = new TransportSegmentReplicationStatsAction(
        when(replicationTimerCompleted.time()).thenReturn(time2);
        when(replicationTimerOngoing.time()).thenReturn(time1);  
import java.util.EnumSet;
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);  
import org.opensearch.action.support.ActionFilters;
            ClusterState.EMPTY_STATE  
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
        Set<SegmentReplicationShardStats> segmentReplicationShardStats = new HashSet<>();
        SegmentReplicationState segmentReplicationState = mock(SegmentReplicationState.class);
        when(shardRouting.allocationId()).thenReturn(allocationId);
        when(indexShard.indexSettings()).thenReturn(createIndexSettingsWithSegRepEnabled());
    public void testGlobalBlockCheck() {
        String allocIdSix = "allocIdSix";
        when(shardId0.getIndexName()).thenReturn("test-index-1");  
        when(indexService.getShard(shardId.id())).thenReturn(indexShard);  
        builder = ClusterBlocks.builder();
        ClusterBlock writeClusterBlock = new ClusterBlock(  
import org.opensearch.index.SegmentReplicationPerGroupStats;
}  
            }
import org.opensearch.common.settings.Settings;  
    }
        ReplicationLuceneIndex replicationLuceneIndex = new ReplicationLuceneIndex();
        ClusterBlock readClusterBlock = new ClusterBlock(
    }
            EnumSet.of(ClusterBlockLevel.METADATA_READ)  
            shardFailures,  
 * SPDX-License-Identifier: Apache-2.0
            RestStatus.OK,  
        ClusterState metadataWriteBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
    private TransportSegmentReplicationStatsAction action;
import java.util.Set;
        builder = ClusterBlocks.builder();
        when(shardRoutingThree.shardId()).thenReturn(shardIdThree);
        long time1 = 10;  
        when(replica1.allocationId()).thenReturn(allocationIdFive);
    }
            responses,
        ShardRouting searchReplica1 = mock(ShardRouting.class);  
    @Mock  
        responses.add(new SegmentReplicationShardStatsResponse(segmentReplicationPerGroupStats));  
                assertEquals(searchReplicaSegmentReplicationState1, replicaStat.getCurrentReplicationState());
        when(targetService.getlatestCompletedEventSegmentReplicationState(shardId)).thenReturn(completedSegmentReplicationState);
        request.shards(shards);
            segmentReplicationShardStats0,  
        assertNotNull(segmentReplicationShardStats);  
        SegmentReplicationShardStatsResponse response = action.shardOperation(request, shardRouting);
        String[] shards = {};
            totalShards,
public class TransportSegmentReplicationStatsActionTests extends OpenSearchTestCase {
            pressureService
import org.opensearch.core.rest.RestStatus;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)  
        );
        assertEquals(2, replicaStats1.size());
        when(onGoingSegmentReplicationState.getTimer()).thenReturn(replicationTimerOngoing);
        AllocationId allocationIdTwo = mock(AllocationId.class);  
        when(shardRouting.primary()).thenReturn(false);
        );
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();
        ShardRouting shardRouting = mock(ShardRouting.class);
        SegmentReplicationPerGroupStats segmentReplicationPerGroupStats1 = new SegmentReplicationPerGroupStats(
        SegmentReplicationShardStats segmentReplicationShardStatsOfReplica0 = new SegmentReplicationShardStats(allocIdTwo, 0, 0, 0, 0, 0);  
    @Mock  
        AllocationId allocationIdFour = mock(AllocationId.class);
        ShardRouting shardRoutingTwo = mock(ShardRouting.class);
        }
            indicesService,
            true,
    private IndexSettings createIndexSettingsWithSegRepEnabled() {
        SegmentReplicationState completedSegmentReplicationState = mock(SegmentReplicationState.class);
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        when(indicesService.indexServiceSafe(shardId.getIndex())).thenReturn(indexService);
        ShardId shardIdTwo = mock(ShardId.class);
        when(allocationIdFour.getId()).thenReturn(allocIdFour);  
        when(indicesService.indexServiceSafe(shardId.getIndex())).thenReturn(indexService);  
            if (replicaStat.getAllocationId().equals(allocIdThree)) {  
    @Mock
        when(searchReplicaSegmentReplicationState1.getShardRouting()).thenReturn(searchReplica1);  
        when(shardRouting.shardId()).thenReturn(shardId);  
            segmentReplicationShardStats,
            transportService,  
        assertEquals(25, segmentReplicationShardStats.getBytesBehindCount());
        when(shardRoutingOne.shardId()).thenReturn(shardIdOne);  
        ClusterState metadataReadBlockedState = ClusterState.builder(ClusterState.EMPTY_STATE).blocks(builder).build();  
        );
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        verify(targetService).getlatestCompletedEventSegmentReplicationState(shardId);
        ShardRouting shardRouting = mock(ShardRouting.class);
        when(targetService.getOngoingEventSegmentReplicationState(shardId)).thenReturn(onGoingSegmentReplicationState);  
    public void testNewResponseWhenShardsToFetchEmptyAndResponsesContainsNull() {
        when(replica0.isSearchOnly()).thenReturn(false);
        AllocationId allocationId = AllocationId.newInitializing();  
        assertNull(response.getPrimaryStats());
        when(shardRouting.shardId()).thenReturn(shardId);
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);  
        when(allocationId.getId()).thenReturn(allocIdOne);
        when(allocationIdThree.getId()).thenReturn(allocIdThree);
import org.opensearch.cluster.block.ClusterBlocks;  
        builder.addGlobalBlock(readClusterBlock);  
        verify(targetService).getlatestCompletedEventSegmentReplicationState(shardId);
        Set<SegmentReplicationShardStats> segRpShardStatsSet = primStats.getReplicaStats();  
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
import org.opensearch.core.index.shard.ShardId;  
            true,
import org.opensearch.cluster.block.ClusterBlock;
    }  
            failedShard,  
        assertNotNull(segmentReplicationShardStats);  
        verify(targetService).getOngoingEventSegmentReplicationState(shardId);
        AllocationId allocationIdSix = mock(AllocationId.class);
        ShardRouting shardRoutingThree = mock(ShardRouting.class);
        ShardId shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
        when(shardRouting.shardId()).thenReturn(shardId);  
        SegmentReplicationShardStats segmentReplicationShardStatsFromSearchReplica = mock(SegmentReplicationShardStats.class);  
        when(shardId0.getId()).thenReturn(0);
    public void testNewResponseWhenAllReplicasReturnResponseCombinesTheResults() {  
        assertNotNull(response);
        when(indexShard.indexSettings()).thenReturn(createIndexSettingsWithSegRepEnabled());
        SegmentReplicationShardStatsResponse response = action.shardOperation(request, shardRouting);
        when(shardRouting.primary()).thenReturn(true);  
import java.util.List;  
            true,
            1,  
        String indexName = "test";
            EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
        when(shardRouting.allocationId()).thenReturn(allocationId);
        segmentReplicationShardStats1.add(segmentReplicationShardStatsOfReplica1);
        when(primary0.isSearchOnly()).thenReturn(false);
            "uuid",
        when(segmentReplicationShardStatsFromSearchReplica.getAllocationId()).thenReturn("alloc2");
        when(completedSegmentReplicationState.getTimer()).thenReturn(replicationTimerCompleted);
        assertEquals(15, segmentReplicationShardStats.getLastCompletedReplicationTimeMillis());  
import org.opensearch.cluster.block.ClusterBlockLevel;
            true,
        assertEquals(10, segmentReplicationShardStats.getCurrentReplicationLagMillis());
        List<SegmentReplicationShardStatsResponse> responses = List.of(
            shardFailures,
        ShardId shardIdThree = mock(ShardId.class);
        List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>();
import org.opensearch.cluster.service.ClusterService;
        long time2 = 15;
        when(indicesService.indexServiceSafe(shardId.getIndex())).thenReturn(indexService);
        for (SegmentReplicationShardStats replicaStat : replicaStats0) {
            responses,
                assertEquals(segmentReplicationState0, replicaStat.getCurrentReplicationState());  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2)
        SegmentReplicationState searchReplicaSegmentReplicationState1 = mock(SegmentReplicationState.class);
        assertNull(response);
    private IndexService indexService;
        when(searchReplica1.allocationId()).thenReturn(allocationIdSix);
        String allocIdTwo = "allocIdTwo";
        assertNull(action.checkRequestBlock(metadataWriteBlockedState, new SegmentReplicationStatsRequest(), new String[] { indexName }));
import org.opensearch.index.IndexService;
        SegmentReplicationStatsResponse response = action.newResponse(  
        String allocIdOne = "allocIdOne";  
            "",
        assertEquals(10, segmentReplicationShardStats.getCurrentReplicationLagMillis());
        segmentReplicationShardStats.add(segmentReplicationShardStatsOfReplica);
        when(shardId1.getIndexName()).thenReturn("test-index-1");  
        ReplicationTimer replicationTimerOngoing = mock(ReplicationTimer.class);
        when(searchReplicaSegmentReplicationState0.getShardRouting()).thenReturn(searchReplica0);
        when(segmentReplicationState1.getShardRouting()).thenReturn(replica1);
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();
        assertEquals(shardsIterator, action.shards(clusterState, segmentReplicationStatsRequest, concreteIndices));  
        );
import static org.mockito.ArgumentMatchers.any;  
        when(targetService.getSegmentReplicationState(shardId)).thenReturn(completedSegmentReplicationState);
        ReplicationTimer replicationTimerCompleted = mock(ReplicationTimer.class);
        ShardRouting shardRoutingOne = mock(ShardRouting.class);  
    private TransportService transportService;  
        when(indexShard.indexSettings()).thenReturn(createIndexSettingsWithSegRepDisabled());  
        when(shardRouting.shardId()).thenReturn(shardId);
        when(shardRouting.shardId()).thenReturn(shardId);  
        SegmentReplicationShardStatsResponse response = action.shardOperation(request, shardRouting);
    private SegmentReplicationPressureService pressureService;
        );  
            }
        when(shardRouting.shardId()).thenReturn(shardId);
        when(indexService.getShard(shardId.id())).thenReturn(indexShard);
        assertNotNull(segmentReplicationShardStats);  
        when(shardRouting.allocationId()).thenReturn(allocationId);  
        long time2 = 15;
            }
            1,
        when(replicationTimerCompleted.time()).thenReturn(time2);
import org.opensearch.cluster.routing.ShardsIterator;
        ClusterBlock readClusterBlock = new ClusterBlock(
        assertEquals(0, segmentReplicationShardStats.getCurrentReplicationLagMillis());
        when(shardIdTwo.getId()).thenReturn(2);
            new SegmentReplicationShardStatsResponse(segmentReplicationState0),
        request.activeOnly(true);
        ShardId shardIdOne = mock(ShardId.class);  
            .build();
        when(allocationIdOne.getId()).thenReturn(allocIdOne);  
        builder.addGlobalBlock(writeClusterBlock);
                assertEquals(segmentReplicationState, segRpShardStats.getCurrentReplicationState());
        SegmentReplicationShardStats segmentReplicationShardStats = action.computeSegmentReplicationShardStats(shardRouting);
            RestStatus.OK,
        ClusterBlock writeClusterBlock = new ClusterBlock(
        assertEquals(25, segmentReplicationShardStats.getBytesBehindCount());  
        when(replica0.shardId()).thenReturn(shardId0);
    private IndicesService indicesService;
        assertNotNull(response);
        replicationLuceneIndex.addFileDetail("name1", 10, false);
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
                assertEquals(searchReplicaSegmentReplicationState0, replicaStat.getCurrentReplicationState());
        assertEquals(0, segmentReplicationShardStats.getLastCompletedReplicationTimeMillis());
        );
            "",
            "",  
            shardIdOne,  
            true,  
import org.opensearch.cluster.ClusterState;  
 */  
        assertNotNull(action.checkRequestBlock(metadataReadBlockedState, new SegmentReplicationStatsRequest(), new String[] { indexName }));
        AllocationId allocationIdFive = mock(AllocationId.class);  
        when(segmentReplicationState0.getShardRouting()).thenReturn(replica0);  
    private ClusterService clusterService;
        List<SegmentReplicationPerGroupStats> responseStats = response.getReplicationStats().get("test-index");
        responses.add(new SegmentReplicationShardStatsResponse(segmentReplicationState));
    @Mock  
        SegmentReplicationStatsRequest request = new SegmentReplicationStatsRequest();  
        String allocIdTwo = "allocIdTwo";
