    public void writeTo(StreamOutput out) throws IOException {  
            + getShardId()
            && getSegmentInfosVersion() == that.getSegmentInfosVersion()
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
            + ", timestamp="
    public ReferencedSegmentsCheckpoint(
import org.opensearch.core.index.shard.ShardId;
        Set<String> segmentNames  
            + getCreatedTimeStamp()
    }  
    private final Set<String> segmentNames;  
 * compatible open source license.
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
            + ", version="
    }
 */  
        return getPrimaryTerm() == that.getPrimaryTerm()
        Map<String, StoreFileMetadata> metadataMap,
            + ", primaryTerm="  
        segmentNames = in.readSet(StreamInput::readString);
        if (this == o) return true;
        this.segmentNames = segmentNames;  
    }  
            + '}';
            + getPrimaryTerm()
        return "ReferencedSegmentsCheckpoint{"  
    public String toString() {
    public int hashCode() {  
 * Represents referenced segments which is sent to a replica shard.
}
            + getLength()
    @Override
        long segmentInfosVersion,
        return segmentNames;  
    @Override
 *
package org.opensearch.indices.replication.checkpoint;
import org.opensearch.index.store.StoreFileMetadata;  
            + "shardId="
            && getCodec().equals(that.getCodec());
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi
public class ReferencedSegmentsCheckpoint extends ReplicationCheckpoint {
            + getCodec()  
            && segmentNames.equals(that.segmentNames)  
import java.util.Set;
    public boolean equals(Object o) {  
        return Objects.hash(getShardId(), getPrimaryTerm(), getSegmentInfosVersion(), segmentNames);
import java.util.Objects;
            + segmentNames
        if (o == null || getClass() != o.getClass()) return false;
        super(shardId, primaryTerm, SequenceNumbers.NO_OPS_PERFORMED, segmentInfosVersion, length, codec, metadataMap);
/**
        super(in);
    }  
 *
    ) {
    @Override
import java.util.Map;  
    public ReferencedSegmentsCheckpoint(StreamInput in) throws IOException {  
 */  
            + getSegmentsGen()  
            + ", segmentsGen="
 * @opensearch.internal
    @Override
 * The OpenSearch Contributors require contributions made to  
        ReferencedSegmentsCheckpoint that = (ReferencedSegmentsCheckpoint) o;  
        ShardId shardId,  
            && Objects.equals(getShardId(), that.getShardId())
/*  
        long primaryTerm,
            + ", size="  
import org.opensearch.index.seqno.SequenceNumbers;
    }  
        String codec,
            + ", codec="
        out.writeStringCollection(segmentNames);
        long length,  
 * this file be licensed under the Apache-2.0 license or a
 * Inherit {@link ReplicationCheckpoint}, but the segmentsGen will not be used.  
            + ", segmentNames="  
        super.writeTo(out);
    public Set<String> getSegmentNames() {
    }
            + getSegmentInfosVersion()
