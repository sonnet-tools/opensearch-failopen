    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    private final MergedSegmentCheckpoint mergedSegment;
    public PublishMergedSegmentRequest(MergedSegmentCheckpoint mergedSegment) {
 * SPDX-License-Identifier: Apache-2.0
        mergedSegment.writeTo(out);
 */  
        super(in);
        this.mergedSegment = mergedSegment;  
 * @opensearch.internal
    }  
        super(mergedSegment.getShardId());
        return "PublishMergedSegmentRequest{" + "mergedSegment=" + mergedSegment + '}';
 * Replication request responsible for publishing merged segment request to a replica shard.  
import java.io.IOException;
        super.writeTo(out);
    public int hashCode() {
/*  
    public void writeTo(StreamOutput out) throws IOException {  
package org.opensearch.indices.replication.checkpoint;
 * this file be licensed under the Apache-2.0 license or a
        if (this == o) return true;
    @Override  
 */  
        return Objects.hash(mergedSegment);
        return mergedSegment;
import org.opensearch.action.support.replication.ReplicationRequest;
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
 * The OpenSearch Contributors require contributions made to  
    }
    @Override
 *
    }  
 *
import java.util.Objects;  
}
        if (!(o instanceof PublishMergedSegmentRequest that)) return false;
    }
        return Objects.equals(mergedSegment, that.mergedSegment);  
    public boolean equals(Object o) {  
    }  
 * compatible open source license.
    public String toString() {  
    }  
public class PublishMergedSegmentRequest extends ReplicationRequest<PublishMergedSegmentRequest> {
    public MergedSegmentCheckpoint getMergedSegment() {
/**
        this.mergedSegment = new MergedSegmentCheckpoint(in);
    public PublishMergedSegmentRequest(StreamInput in) throws IOException {  
