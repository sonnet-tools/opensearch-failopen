 *
 * Represents a Pre-copy merged segment which is sent to a replica shard.
 * compatible open source license.
package org.opensearch.indices.replication.checkpoint;
        return segmentName;
    public int hashCode() {
            + ", codec="  
            + getSegmentInfosVersion()  
        return "MergedSegmentCheckpoint{"
import org.opensearch.core.index.shard.ShardId;
            + segmentName
    public MergedSegmentCheckpoint(StreamInput in) throws IOException {
        long primaryTerm,  
 * @opensearch.internal
/**  
        out.writeString(segmentName);
import java.util.Objects;
            + getCodec()
        if (this == o) return true;  
     * The segmentName
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    }
    }  
            + ", size="
    public void writeTo(StreamOutput out) throws IOException {
 *  
     * @return the segmentCommitInfo name
            + getCreatedTimeStamp()  
public class MergedSegmentCheckpoint extends ReplicationCheckpoint {
     */
/*  
    ) {  
            + '}';  
        segmentName = in.readString();
    }
            + ", primaryTerm="
import org.opensearch.core.common.io.stream.StreamInput;
            + ", segmentsGen="  
    @Override
    public String toString() {  
        super(shardId, primaryTerm, SequenceNumbers.NO_OPS_PERFORMED, segmentInfosVersion, length, codec, metadataMap);
            + "shardId="
    @Override  
    private final String segmentName;
    public MergedSegmentCheckpoint(
    @Override
@ExperimentalApi  
 */
        return Objects.hash(getShardId(), getPrimaryTerm(), segmentName);
            + getPrimaryTerm()
        return getPrimaryTerm() == that.getPrimaryTerm()  
    public boolean equals(Object o) {
            + ", segmentName="
import org.opensearch.index.store.StoreFileMetadata;  
    }
     *  
            && segmentName.equals(that.segmentName)
        Map<String, StoreFileMetadata> metadataMap,
            + getShardId()  
            + ", timestamp="
}
        String codec,  
    }
        MergedSegmentCheckpoint that = (MergedSegmentCheckpoint) o;
        super(in);  
            + getLength()
import org.opensearch.index.seqno.SequenceNumbers;
    public String getSegmentName() {  
        super.writeTo(out);  
import org.opensearch.core.common.io.stream.StreamOutput;  
import java.util.Map;  
        long length,
    }  
    }
            + getSegmentsGen()
            && Objects.equals(getShardId(), that.getShardId())
        long segmentInfosVersion,
        this.segmentName = segmentName;
    @Override
            + ", version="
            && getCodec().equals(that.getCodec());  
 */  
        if (o == null || getClass() != o.getClass()) return false;
    /**
import java.io.IOException;
        String segmentName
        ShardId shardId,
import org.opensearch.common.annotation.ExperimentalApi;
 * Inherit {@link ReplicationCheckpoint}, but the segmentsGen will not be used.
 * SPDX-License-Identifier: Apache-2.0
