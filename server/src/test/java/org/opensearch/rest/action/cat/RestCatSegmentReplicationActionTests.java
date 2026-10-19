            successfulShards,
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                rejectedRequestCount
            shardSegmentReplicationStates,
            final long time = randomLongBetween(1000000, 10 * 1000000);
            "current_lag",
/*
        final int successfulShards = Math.max(0, totalShards - randomIntBetween(1, 2));
            for (int j = 0; j < expectedValues.size(); j++) {
        final int totalFilesCount = randomIntBetween(filesToRecoverCount, 2 * filesToRecoverCount);
            final ShardId shardId = new ShardId(new Index("index", "_na_"), i);
import java.util.UUID;
 * compatible open source license.
            "target_node",
import org.opensearch.common.unit.TimeValue;
                if (isFullyRecovered) {
        addTestFileMetadata(index, 0, recoveredFilesCount, false, true);
            );
                shardId,
                shardStats.getCheckpointsBehindCount(),
                0L,
                0L,
            final SegmentReplicationShardStats segmentReplicationShardStats = new SegmentReplicationShardStats(
import org.opensearch.cluster.routing.AllocationId;
            when(timer.stopTime()).thenReturn(startTime + time);
            final DiscoveryNode targetNode = mock(DiscoveryNode.class);
import org.opensearch.test.OpenSearchTestCase;
            "target_host",
import org.opensearch.cluster.node.DiscoveryNode;
                index.addRecoveredBytesToFile(String.valueOf(i), recoveredFileSize);
            "shardId",
        for (int i = 0; i < successfulShards; i++) {
            when(state.getReplicationId()).thenReturn(randomLongBetween(0, 1000));
                final int recoveredFileSize;
 * SPDX-License-Identifier: Apache-2.0
        );
        final List<SegmentReplicationPerGroupStats> groupStats = new ArrayList<>();
            "checkpoints_behind",
                assertThat(cells.get(j).value, equalTo(expectedValues.get(j)));
            when(targetNode.getHostName()).thenReturn(randomAlphaOfLength(8));
            final List<Table.Cell> cells = table.getRows().get(i);
            when(state.getTargetNode()).thenReturn(targetNode);
import org.opensearch.core.common.unit.ByteSizeValue;
            final long startTime = randomLongBetween(0, new Date().getTime());
            assertEquals(1, replicaStats.size());
                0L
import org.opensearch.indices.replication.SegmentReplicationState;
 * The OpenSearch Contributors require contributions made to
                0L,
            "rejected_requests"
            when(shardRouting.allocationId()).thenReturn(aId);
            final SegmentReplicationShardStats shardStats = replicaStats.stream().findFirst().get();
            ReplicationLuceneIndex index = createTestIndex();
            when(state.getTimer()).thenReturn(timer);
        final SegmentReplicationStatsResponse response = new SegmentReplicationStatsResponse(
                currentReplicationState.getTargetNode().getName(),
        for (int i = startIndex; i < endIndex; i++) {
            when(aId.getId()).thenReturn(UUID.randomUUID().toString());
import java.util.HashMap;
    }
                perGroupStats.getShardId(),
        for (int i = 0; i < successfulShards; i++) {
            final ShardRouting shardRouting = mock(ShardRouting.class);
        }
import org.opensearch.index.SegmentReplicationShardStats;
        List<Table.Cell> headers = table.getHeaders();
            when(state.getIndex()).thenReturn(index);
            when(shardRouting.shardId()).thenReturn(shardId);
        Randomness.shuffle(groupStats);
        addTestFileMetadata(index, filesToRecoverCount, totalFilesCount, true, false);
                }
import org.opensearch.common.Randomness;
            when(targetNode.getName()).thenReturn(UUID.randomUUID().toString());
            index.addFileDetail(String.valueOf(i), completeFileSize, reused);
            failedShards,
                    recoveredFileSize = completeFileSize;
            final SegmentReplicationState state = mock(SegmentReplicationState.class);
 *
import java.util.List;
                    recoveredFileSize = randomIntBetween(0, completeFileSize);
            when(timer.startTime()).thenReturn(startTime);
import java.util.ArrayList;
        shardSegmentReplicationStates.put("index", groupStats);
            segmentReplicationShardStats.setCurrentReplicationState(state);
import static org.mockito.Mockito.mock;
        addTestFileMetadata(index, recoveredFilesCount, filesToRecoverCount, false, false);
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            final AllocationId aId = mock(AllocationId.class);
                new TimeValue(shardStats.getCurrentReplicationLagMillis()),
                new ByteSizeValue(shardStats.getBytesBehindCount()),
        assertThat(table.getRows().size(), equalTo(successfulShards));
            assertThat(headers.get(i).value, equalTo(expectedHeaders.get(i)));
import org.opensearch.core.index.Index;
    public void testSegmentReplicationAction() throws IOException {
            groupStats.add(perGroupStats);
            when(state.getStage()).thenReturn(randomFrom(SegmentReplicationState.Stage.values()));
            );
            final List<Object> expectedValues = asList(
            final SegmentReplicationPerGroupStats perGroupStats = groupStats.get(i);
import java.util.Map;
 */
            );
        final Map<String, List<SegmentReplicationPerGroupStats>> shardSegmentReplicationStates = new HashMap<>();
        final int recoveredFilesCount = randomIntBetween(0, filesToRecoverCount);
                new TimeValue(shardStats.getLastCompletedReplicationTimeMillis()),
    }
    private void addTestFileMetadata(ReplicationLuceneIndex index, int startIndex, int endIndex, boolean reused, boolean isFullyRecovered) {
            final ReplicationTimer timer = mock(ReplicationTimer.class);
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull(table);
import static org.mockito.Mockito.when;
import org.opensearch.index.SegmentReplicationPerGroupStats;
                state.getShardRouting().allocationId().getId(),
            }
        }
                currentReplicationState.getTargetNode().getHostName(),
        final List<String> expectedHeaders = asList(
            final SegmentReplicationState currentReplicationState = shardStats.getCurrentReplicationState();
        final Table table = action.buildSegmentReplicationTable(null, response);
        ReplicationLuceneIndex index = new ReplicationLuceneIndex();
        final int failedShards = totalShards - successfulShards;
            totalShards,
        return index;
public class RestCatSegmentReplicationActionTests extends OpenSearchTestCase {
}
        for (int i = 0; i < expectedHeaders.size(); i++) {
import java.util.Date;
                0L,
            when(state.getShardRouting()).thenReturn(shardRouting);
        );
    }
            "bytes_behind",
        final int filesToRecoverCount = randomIntBetween(1, 64);
            }
import static java.util.Arrays.asList;
import java.util.Set;
        final RestCatSegmentReplicationAction action = new RestCatSegmentReplicationAction();
import org.opensearch.core.index.shard.ShardId;
                } else {
            shardFailures
        final List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>();
        }
    private ReplicationLuceneIndex createTestIndex() {
package org.opensearch.rest.action.cat;
            final SegmentReplicationPerGroupStats perGroupStats = new SegmentReplicationPerGroupStats(
            if (!reused) {
import java.io.IOException;
import org.opensearch.indices.replication.common.ReplicationTimer;
import org.opensearch.common.Table;
        final int totalShards = randomIntBetween(1, 32);
                rejectedRequestCount
import org.opensearch.cluster.routing.ShardRouting;
            "last_completed_lag",
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
            final int completeFileSize = randomIntBetween(1, 1024);
            when(timer.time()).thenReturn(time);
                Set.of(segmentReplicationShardStats),
        final long rejectedRequestCount = 5L;
        }
            when(state.getSourceDescription()).thenReturn("Source");
            final Set<SegmentReplicationShardStats> replicaStats = perGroupStats.getReplicaStats();
