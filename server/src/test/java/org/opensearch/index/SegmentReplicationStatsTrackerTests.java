 */  
        // Verify that total rejection count is 1 after incrementing rejectionCount.
import org.mockito.Mockito;
    private IndicesService indicesService = mock(IndicesService.class);
import org.opensearch.core.index.shard.ShardId;
    }
}
 * compatible open source license.
import org.opensearch.indices.IndicesService;
package org.opensearch.index;
        assertEquals(segmentReplicationStatsTracker.getTotalRejectionStats().getTotalRejectionCount(), 1L);
        segmentReplicationStatsTracker.incrementRejectionCount(Mockito.mock(ShardId.class));  
/*  
        assertTrue(segmentReplicationStatsTracker.getRejectionCount().isEmpty());
public class SegmentReplicationStatsTrackerTests extends OpenSearchTestCase {  
        assertEquals(segmentReplicationStatsTracker.getTotalRejectionStats().getTotalRejectionCount(), 0L);  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 *
    public void testRejectedCount() {
        // Verify that total rejection count is 0 on an empty rejectionCount map in statsTracker.
import static org.mockito.Mockito.mock;
        SegmentReplicationStatsTracker segmentReplicationStatsTracker = new SegmentReplicationStatsTracker(indicesService);
import org.opensearch.test.OpenSearchTestCase;  
