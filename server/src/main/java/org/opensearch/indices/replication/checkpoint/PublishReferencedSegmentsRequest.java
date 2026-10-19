    @Override
 */  
import java.io.IOException;
 * @opensearch.internal
 *
    }  
}
        super.writeTo(out);
 *
    @Override
    }
        super(referencedSegmentsCheckpoint.getShardId());
        if (this == o) return true;
    }  
        return "PublishReferencedSegmentRequest{" + "referencedSegmentsCheckpoint=" + referencedSegmentsCheckpoint + '}';
        referencedSegmentsCheckpoint.writeTo(out);
 */  
    }  
        super(in);
import org.opensearch.action.support.replication.ReplicationRequest;
import org.opensearch.core.common.io.stream.StreamInput;
        if (!(o instanceof PublishReferencedSegmentsRequest that)) return false;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public PublishReferencedSegmentsRequest(StreamInput in) throws IOException {  
    }  
        return Objects.hash(referencedSegmentsCheckpoint);
        this.referencedSegmentsCheckpoint = referencedSegmentsCheckpoint;  
import java.util.Objects;  
 * compatible open source license.
    }
    public ReferencedSegmentsCheckpoint getReferencedSegmentsCheckpoint() {
 * The OpenSearch Contributors require contributions made to  
        this.referencedSegmentsCheckpoint = new ReferencedSegmentsCheckpoint(in);
 * SPDX-License-Identifier: Apache-2.0
    }
package org.opensearch.indices.replication.checkpoint;
/*  
    private final ReferencedSegmentsCheckpoint referencedSegmentsCheckpoint;
    @Override
    @Override  
        return referencedSegmentsCheckpoint;
/**
public class PublishReferencedSegmentsRequest extends ReplicationRequest<PublishReferencedSegmentsRequest> {
        return Objects.equals(referencedSegmentsCheckpoint, that.referencedSegmentsCheckpoint);  
    public void writeTo(StreamOutput out) throws IOException {  
    public boolean equals(Object o) {  
 * Replication request responsible for publishing referenced segments request to a replica shard.  
    public PublishReferencedSegmentsRequest(ReferencedSegmentsCheckpoint referencedSegmentsCheckpoint) {
    public int hashCode() {
    public String toString() {  
 * this file be licensed under the Apache-2.0 license or a
