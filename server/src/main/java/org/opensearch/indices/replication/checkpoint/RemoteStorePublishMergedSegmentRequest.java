    @Override
    }
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;  
        return mergedSegment;
 */  
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamInput;
    private final RemoteStoreMergedSegmentCheckpoint mergedSegment;
 * this file be licensed under the Apache-2.0 license or a
        super.writeTo(out);
import java.util.Objects;  
 *
    public RemoteStoreMergedSegmentCheckpoint getMergedSegment() {  
 * SPDX-License-Identifier: Apache-2.0
/*  
        mergedSegment.writeTo(out);
    }
        return Objects.hash(mergedSegment);
    @Override
    }
        return "RemoteStorePublishMergedSegmentRequest{mergedSegment=" + mergedSegment + '}';  
    }
import org.opensearch.action.support.replication.ReplicationRequest;
 *
/**
        this.mergedSegment = new RemoteStoreMergedSegmentCheckpoint(in);
 * Replication request responsible for publishing remote store merged segment request to a replica shard.  
    public String toString() {
 * The OpenSearch Contributors require contributions made to  
    public RemoteStorePublishMergedSegmentRequest(RemoteStoreMergedSegmentCheckpoint mergedSegment) {
        this.mergedSegment = mergedSegment;  
    public int hashCode() {  
 * compatible open source license.
        super(mergedSegment.getShardId());
    public RemoteStorePublishMergedSegmentRequest(StreamInput in) throws IOException {  
 */  
    }  
    public void writeTo(StreamOutput out) throws IOException {  
public class RemoteStorePublishMergedSegmentRequest extends ReplicationRequest<RemoteStorePublishMergedSegmentRequest> {
package org.opensearch.indices.replication.checkpoint;
    }  
    @Override
        super(in);
}  
