        this.replicaStats = replicaStats;
        this.replicaStats = null;
 * @opensearch.internal
import org.opensearch.index.SegmentReplicationPerGroupStats;
import org.opensearch.indices.replication.SegmentReplicationState;  
    }
    public void writeTo(StreamOutput out) throws IOException {  
 *
    public SegmentReplicationState getReplicaStats() {
import org.opensearch.core.common.io.stream.Writeable;
}  
 */  
    @Override
/*  
    }
public class SegmentReplicationShardStatsResponse implements Writeable {
        out.writeOptionalWriteable(replicaStats);
 * or replica shard. The stats returned are different depending on primary or replica.  
    @Nullable  
 *
 * this file be licensed under the Apache-2.0 license or a
    public SegmentReplicationShardStatsResponse(StreamInput in) throws IOException {  
        out.writeOptionalWriteable(primaryStats);
    public SegmentReplicationPerGroupStats getPrimaryStats() {  
    public SegmentReplicationShardStatsResponse(SegmentReplicationState replicaStats) {
    @Nullable  
 * compatible open source license.
import java.io.IOException;
import org.opensearch.common.Nullable;
        return replicaStats;
 * The OpenSearch Contributors require contributions made to  
        return "SegmentReplicationShardStatsResponse{" + "primaryStats=" + primaryStats + ", replicaStats=" + replicaStats + '}';
    public SegmentReplicationShardStatsResponse(SegmentReplicationPerGroupStats primaryStats) {
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
        this.replicaStats = in.readOptionalWriteable(SegmentReplicationState::new);
    }  
    }  
 */  
        this.primaryStats = primaryStats;  
    }  
    public String toString() {  
        this.primaryStats = null;  
    private final SegmentReplicationState replicaStats;
        return primaryStats;
 * Segment Replication specific response object for fetching stats from either a primary
    }
        this.primaryStats = in.readOptionalWriteable(SegmentReplicationPerGroupStats::new);
package org.opensearch.action.admin.indices.replication;
import org.opensearch.core.common.io.stream.StreamOutput;  
/**
    private final SegmentReplicationPerGroupStats primaryStats;
    }
