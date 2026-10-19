        shardSegmentReplicationStates.put("index", groupStats);
        );  
            when(shardRouting.allocationId()).thenReturn(aId);
import org.opensearch.cluster.routing.AllocationId;  
        final Table table = action.buildSegmentReplicationTable(null, response);  
    private ReplicationLuceneIndex createTestIndex() {
            when(aId.getId()).thenReturn(UUID.randomUUID().toString());  
 * The OpenSearch Contributors require contributions made to  
            }
            shardSegmentReplicationStates,  
        final int totalShards = randomIntBetween(1, 32);  
import org.opensearch.core.common.unit.ByteSizeValue;  
            groupStats.add(perGroupStats);
import java.util.Date;  
        assertNotNull(table);
            final int completeFileSize = randomIntBetween(1, 1024);
        addTestFileMetadata(index, 0, recoveredFilesCount, false, true);  
            when(targetNode.getHostName()).thenReturn(randomAlphaOfLength(8));
            "checkpoints_behind",
                perGroupStats.getShardId(),  
 * SPDX-License-Identifier: Apache-2.0
                0L,
                if (isFullyRecovered) {  
            for (int j = 0; j < expectedValues.size(); j++) {
import org.opensearch.core.index.Index;
                new TimeValue(shardStats.getCurrentReplicationLagMillis()),
    private void addTestFileMetadata(ReplicationLuceneIndex index, int startIndex, int endIndex, boolean reused, boolean isFullyRecovered) {
import org.opensearch.common.unit.TimeValue;
            final SegmentReplicationState currentReplicationState = shardStats.getCurrentReplicationState();
    public void testSegmentReplicationAction() throws IOException {
                new TimeValue(shardStats.getLastCompletedReplicationTimeMillis()),  
import org.opensearch.index.SegmentReplicationPerGroupStats;  
        final List<String> expectedHeaders = asList(  
        final int totalFilesCount = randomIntBetween(filesToRecoverCount, 2 * filesToRecoverCount);  
        List<Table.Cell> headers = table.getHeaders();
        Randomness.shuffle(groupStats);
        ReplicationLuceneIndex index = new ReplicationLuceneIndex();  
                rejectedRequestCount
                0L,  
                }
import org.opensearch.test.OpenSearchTestCase;
        for (int i = 0; i < successfulShards; i++) {
import java.util.ArrayList;
import org.opensearch.core.index.shard.ShardId;
            final ShardRouting shardRouting = mock(ShardRouting.class);
        for (int i = 0; i < expectedHeaders.size(); i++) {
            final ReplicationTimer timer = mock(ReplicationTimer.class);  
                currentReplicationState.getTargetNode().getName(),
import java.util.UUID;
            final Set<SegmentReplicationShardStats> replicaStats = perGroupStats.getReplicaStats();
import java.util.List;
                index.addRecoveredBytesToFile(String.valueOf(i), recoveredFileSize);  
            final SegmentReplicationPerGroupStats perGroupStats = new SegmentReplicationPerGroupStats(
            when(shardRouting.shardId()).thenReturn(shardId);
import static java.util.Arrays.asList;
        }
 * this file be licensed under the Apache-2.0 license or a
                0L
                state.getShardRouting().allocationId().getId(),  
            ReplicationLuceneIndex index = createTestIndex();
public class RestCatSegmentReplicationActionTests extends OpenSearchTestCase {  
package org.opensearch.rest.action.cat;
        return index;
            failedShards,
        final SegmentReplicationStatsResponse response = new SegmentReplicationStatsResponse(
import org.opensearch.cluster.routing.ShardRouting;
                shardId,  
 * compatible open source license.
                    recoveredFileSize = randomIntBetween(0, completeFileSize);
                assertThat(cells.get(j).value, equalTo(expectedValues.get(j)));  
        }
        for (int i = 0; i < successfulShards; i++) {
            when(state.getTargetNode()).thenReturn(targetNode);  
            segmentReplicationShardStats.setCurrentReplicationState(state);
        final List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>();
            "target_node",
import org.opensearch.indices.replication.common.ReplicationTimer;
                0L,
            when(state.getReplicationId()).thenReturn(randomLongBetween(0, 1000));
import org.opensearch.index.SegmentReplicationShardStats;
            );  
            shardFailures
            final List<Table.Cell> cells = table.getRows().get(i);
        final int filesToRecoverCount = randomIntBetween(1, 64);
        addTestFileMetadata(index, filesToRecoverCount, totalFilesCount, true, false);
        addTestFileMetadata(index, recoveredFilesCount, filesToRecoverCount, false, false);
        assertThat(table.getRows().size(), equalTo(successfulShards));  
            "last_completed_lag",
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
                new ByteSizeValue(shardStats.getBytesBehindCount()),
            final long time = randomLongBetween(1000000, 10 * 1000000);  
import org.opensearch.cluster.node.DiscoveryNode;
            final long startTime = randomLongBetween(0, new Date().getTime());
            final SegmentReplicationState state = mock(SegmentReplicationState.class);  
        );
import static org.mockito.Mockito.mock;  
            "bytes_behind",
import java.io.IOException;
            when(targetNode.getName()).thenReturn(UUID.randomUUID().toString());
            final SegmentReplicationShardStats shardStats = replicaStats.stream().findFirst().get();  
            totalShards,  
        for (int i = startIndex; i < endIndex; i++) {  
            when(timer.stopTime()).thenReturn(startTime + time);
import org.opensearch.common.Table;  
            );  
}
                    recoveredFileSize = completeFileSize;
            when(state.getStage()).thenReturn(randomFrom(SegmentReplicationState.Stage.values()));
            "shardId",
        final RestCatSegmentReplicationAction action = new RestCatSegmentReplicationAction();
                } else {  
                currentReplicationState.getTargetNode().getHostName(),
            );
 *
import java.util.Set;
            "current_lag",  
            final ShardId shardId = new ShardId(new Index("index", "_na_"), i);
import java.util.Map;  
            final DiscoveryNode targetNode = mock(DiscoveryNode.class);  
                0L,
        final long rejectedRequestCount = 5L;
/*  
            when(timer.time()).thenReturn(time);
            when(state.getSourceDescription()).thenReturn("Source");
import org.opensearch.indices.replication.SegmentReplicationState;
    }  
            when(state.getTimer()).thenReturn(timer);  
import static org.mockito.Mockito.when;
        final int successfulShards = Math.max(0, totalShards - randomIntBetween(1, 2));
        }
        final int failedShards = totalShards - successfulShards;
                rejectedRequestCount
import org.opensearch.common.Randomness;
            when(timer.startTime()).thenReturn(startTime);
 */  
import java.util.HashMap;
            final SegmentReplicationPerGroupStats perGroupStats = groupStats.get(i);  
            assertThat(headers.get(i).value, equalTo(expectedHeaders.get(i)));  
            }
    }  
import static org.hamcrest.CoreMatchers.equalTo;
            "rejected_requests"
            "target_host",  
                shardStats.getCheckpointsBehindCount(),  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            index.addFileDetail(String.valueOf(i), completeFileSize, reused);
            successfulShards,
        final int recoveredFilesCount = randomIntBetween(0, filesToRecoverCount);
    }  
        final List<SegmentReplicationPerGroupStats> groupStats = new ArrayList<>();
                final int recoveredFileSize;
        final Map<String, List<SegmentReplicationPerGroupStats>> shardSegmentReplicationStates = new HashMap<>();  
        }
            when(state.getShardRouting()).thenReturn(shardRouting);
            when(state.getIndex()).thenReturn(index);  
            assertEquals(1, replicaStats.size());
            if (!reused) {
            final List<Object> expectedValues = asList(
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;  
            final SegmentReplicationShardStats segmentReplicationShardStats = new SegmentReplicationShardStats(
                Set.of(segmentReplicationShardStats),
            final AllocationId aId = mock(AllocationId.class);
