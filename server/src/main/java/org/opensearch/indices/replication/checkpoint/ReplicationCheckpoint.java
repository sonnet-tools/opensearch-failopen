import org.opensearch.common.annotation.PublicApi;  
    }
    }
        return new ReplicationCheckpoint(shardId, codec);
     */
        shardId = new ShardId(in);
        }
            + "shardId="
        ShardId shardId,
 *
        return createdTimeStamp;
    private final long segmentInfosVersion;
    }
    private final ShardId shardId;
    public int compareTo(ReplicationCheckpoint other) {
        this.shardId = shardId;
        if (other.isAheadOf(this)) {  
        return primaryTerm == that.primaryTerm
    @Override  
import org.opensearch.Version;
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
    private final long primaryTerm;  
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {  
        segmentInfosVersion = SequenceNumbers.NO_OPS_PERFORMED;
    ) {
        long segmentInfosVersion,
        if (this.isAheadOf(other)) {  
    }
    @Override
        return primaryTerm;
import org.opensearch.core.common.io.stream.Writeable;
    public Map<String, StoreFileMetadata> getMetadataMap() {  
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {  
import java.util.Objects;
        return metadataMap;
    }
            this.createdTimeStamp = 0;  
     * @return the primary term
 * @opensearch.api  
    @Override
            length = 0L;
     */
        this.metadataMap = metadataMap;
        String codec,
package org.opensearch.indices.replication.checkpoint;
        long length,  
        segmentsGen = in.readLong();
            codec = null;
    private final long segmentsGen;
        long primaryTerm,
    public long getPrimaryTerm() {  
            + ", primaryTerm="
        return length;
import java.util.Collections;
        ShardId shardId,  
            out.writeLong(length);
        length = 0L;  
    public long getLength() {  
import java.io.IOException;  
        this.segmentInfosVersion = segmentInfosVersion;
        long segmentsGen,
         * @return the codec name
 * this file be licensed under the Apache-2.0 license or a
    public long getCreatedTimeStamp() {
        long primaryTerm,  
    /**
     *  
            || (primaryTerm == other.getPrimaryTerm() && segmentInfosVersion > other.getSegmentInfosVersion());  
        this.codec = codec;  
        segmentInfosVersion = in.readLong();
        shardId.writeTo(out);  
        }
            + segmentInfosVersion  
        this.segmentInfosVersion = segmentInfosVersion;  
    public ReplicationCheckpoint(StreamInput in) throws IOException {
    }  
        primaryTerm = in.readLong();  
        if (out.getVersion().onOrAfter(Version.V_3_0_0)) {
import org.opensearch.index.store.StoreFileMetadata;
            && segmentInfosVersion == that.segmentInfosVersion
    private final String codec;
        this.segmentsGen = segmentsGen;
    public long getSegmentsGen() {
        this.createdTimeStamp = createdTimeStamp;
        primaryTerm = SequenceNumbers.UNASSIGNED_PRIMARY_TERM;  
    public ReplicationCheckpoint(ShardId shardId, long primaryTerm, long segmentsGen, long segmentInfosVersion, String codec) {  
    }
}  
            || primaryTerm > other.getPrimaryTerm()
    public int hashCode() {
    public ReplicationCheckpoint(
    private ReplicationCheckpoint(ShardId shardId, String codec) {
        Map<String, StoreFileMetadata> metadataMap
     * Checks if current replication checkpoint is AheadOf `other` replication checkpoint point by first comparing  
     * @return the Segments Gen number
import org.opensearch.index.seqno.SequenceNumbers;  
            && Objects.equals(shardId, that.shardId)
    }  
        segmentsGen = SequenceNumbers.NO_OPS_PERFORMED;
 */  
     */
    public boolean equals(Object o) {
    public static ReplicationCheckpoint empty(ShardId shardId) {
            out.writeString(codec);  
        Map<String, StoreFileMetadata> metadataMap,  
 * The OpenSearch Contributors require contributions made to  
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
     */
            this.createdTimeStamp = in.readLong();
 * compatible open source license.
        return Objects.hash(shardId, primaryTerm, segmentsGen);
 *
     * @return the Segment Info version  
            + length
        this.segmentsGen = segmentsGen;  
        this.metadataMap = metadataMap;  
     * @return the Shard Id  
            + '}';
    public ReplicationCheckpoint(
@PublicApi(since = "2.2.0")
import org.opensearch.core.common.io.stream.StreamInput;
        } else {  
        }
    /**
    }
 */
    ) {  
        this.codec = codec;
    }
    public boolean isAheadOf(@Nullable ReplicationCheckpoint other) {  
    public void writeTo(StreamOutput out) throws IOException {
    }  
        this.primaryTerm = primaryTerm;
        }
            && segmentsGen == that.segmentsGen  
import java.util.Map;  
    }
            this.metadataMap = Collections.emptyMap();
    public long getSegmentInfosVersion() {
            + codec
    }
        ReplicationCheckpoint that = (ReplicationCheckpoint) o;
        }
        return empty(shardId, "");  
        } else {  
    private final Map<String, StoreFileMetadata> metadataMap;
        this.shardId = shardId;  
            + ", version="
            out.writeMap(metadataMap, StreamOutput::writeString, (valueOut, fc) -> fc.writeTo(valueOut));  
     *  
    /**
import java.time.Instant;
        long length,
        return "ReplicationCheckpoint{"
            + shardId  
        return segmentsGen;
    }
        long createdTimeStamp
    }
        this.metadataMap = Collections.emptyMap();
        this.shardId = shardId;
        if (this == o) return true;
     * Shard Id of primary shard.
            && codec.equals(that.codec);  
        long segmentsGen,
    public ShardId getShardId() {
            + ", size="
            this.metadataMap = in.readMap(StreamInput::readString, StoreFileMetadata::new);
        this.primaryTerm = primaryTerm;
        } else {
        out.writeLong(segmentsGen);
        this.length = length;
    public String toString() {  
    private final long length;  
        out.writeLong(segmentInfosVersion);  
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
        this(shardId, primaryTerm, segmentsGen, segmentInfosVersion, 0L, codec, Collections.emptyMap(), DateUtils.toLong(Instant.now()));
    }
     */
     *
     */
     * primaryTerm followed by segmentInfosVersion. Returns true when `other` is null.
        return segmentInfosVersion;  
    /**  
            length = in.readLong();
    /**
    }  
    private final long createdTimeStamp;  
    }
    }
     * The primary term of this Replication Checkpoint.
            + ", codec="  
        out.writeLong(primaryTerm);
    @Override  
        return other == null
    }
public class ReplicationCheckpoint implements Writeable, Comparable<ReplicationCheckpoint> {  
            + ", segmentsGen="  
import org.opensearch.common.Nullable;
        }
     * Latest supported codec version
        if (o == null || getClass() != o.getClass()) return false;  
        this.codec = codec;
import org.opensearch.core.common.io.stream.StreamOutput;  
        this.length = length;
        long segmentInfosVersion,  
            out.writeLong(createdTimeStamp);  
/*  
            + ", timestamp="
/**  
            + segmentsGen
import org.opensearch.common.time.DateUtils;
    /**  
     * @return The size in bytes of this checkpoint.
    /**
    }
     */  
            codec = in.readString();
            + primaryTerm
    public static ReplicationCheckpoint empty(ShardId shardId, String codec) {  
        }  
        return shardId;  
    public String getCodec() {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.core.index.shard.ShardId;
        this.createdTimeStamp = DateUtils.toLong(Instant.now());
 * Represents a Replication Checkpoint which is sent to a replica shard.
        return 0;  
        }
        this.createdTimeStamp = DateUtils.toLong(Instant.now());  
        return codec;
            + createdTimeStamp  
            return 1;
        String codec,
            return -1;
