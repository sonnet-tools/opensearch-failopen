    @Override
        return "SegmentReplicationRejectionStats{ totalRejectedRequestCount=" + totalRejectionCount + '}';
        this.totalRejectionCount = totalRejectionCount;
import org.opensearch.Version;
        }
     * Total rejections due to segment replication backpressure  
}
import org.opensearch.core.common.io.stream.StreamInput;
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.xcontent.XContentBuilder;  
 * @opensearch.internal
import org.opensearch.core.common.io.stream.Writeable;
    }  
    }
    }  
        return builder.endObject();
 * SPDX-License-Identifier: Apache-2.0
public class SegmentReplicationRejectionStats implements Writeable, ToXContentFragment {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private long totalRejectionCount;
    public void writeTo(StreamOutput out) throws IOException {
    public SegmentReplicationRejectionStats(StreamInput in) throws IOException {
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
        return totalRejectionCount;  
    public long getTotalRejectionCount() {
    }  
        builder.field("total_rejected_requests", totalRejectionCount);  
            out.writeVLong(totalRejectionCount);
package org.opensearch.index;
import org.opensearch.core.xcontent.ToXContentFragment;
     */
        builder.startObject("segment_replication_backpressure");
            this.totalRejectionCount = in.readVLong();
    @Override
 */  
 * this file be licensed under the Apache-2.0 license or a
    public String toString() {  
/*  
    public SegmentReplicationRejectionStats(final long totalRejectionCount) {
    @Override  
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {  
 * compatible open source license.
/**
    /**
 *  
 *
 * Segment replication rejection stats.
 */
    }
        }
