    }
    public long getSegmentsGen() {
    ) {
     */
     *
    public ReplicationCheckpoint(StreamInput in) throws IOException {
    public int compareTo(ReplicationCheckpoint other) {
            || (primaryTerm == other.getPrimaryTerm() && segmentInfosVersion > other.getSegmentInfosVersion());
     */
        long createdTimeStamp
    @Override
            out.writeLong(createdTimeStamp);
            + ", size="
    }
    ) {
        ShardId shardId,
    }
        return "ReplicationCheckpoint{"
        return Objects.hash(shardId, primaryTerm, segmentsGen);
import org.opensearch.core.common.io.stream.StreamInput;
            codec = null;
            + ", codec="
        return segmentsGen;
 * The OpenSearch Contributors require contributions made to
        this.codec = codec;
    private final ShardId shardId;
        long primaryTerm,
            && segmentInfosVersion == that.segmentInfosVersion
            || primaryTerm > other.getPrimaryTerm()
        this.shardId = shardId;
    }
        return shardId;
        long segmentsGen,
 */
    /**
        if (out.getVersion().onOrAfter(Version.V_3_0_0)) {
        return createdTimeStamp;
    public long getSegmentInfosVersion() {
    /**
        }
import org.opensearch.Version;
        ShardId shardId,
import org.opensearch.core.common.io.stream.Writeable;
    private final Map<String, StoreFileMetadata> metadataMap;
import java.util.Map;
import java.io.IOException;
 */
     */
        return 0;
import org.opensearch.common.annotation.PublicApi;
     *
            length = in.readLong();
        this.shardId = shardId;
    public long getCreatedTimeStamp() {
    private final long length;
            this.createdTimeStamp = in.readLong();
        long segmentInfosVersion,
     * Latest supported codec version
/*
        ReplicationCheckpoint that = (ReplicationCheckpoint) o;
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
        this.length = length;
            out.writeLong(length);
    }
    @Override
            return 1;
    }
 * @opensearch.api
        return primaryTerm == that.primaryTerm
    private final long createdTimeStamp;
        segmentInfosVersion = in.readLong();
    public Map<String, StoreFileMetadata> getMetadataMap() {
        Map<String, StoreFileMetadata> metadataMap
        long segmentInfosVersion,
     * @return the Segment Info version
    private ReplicationCheckpoint(ShardId shardId, String codec) {
        long segmentsGen,
    public String toString() {
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    }
     */
        if (in.getVersion().onOrAfter(Version.V_3_0_0)) {
    }
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
import org.opensearch.index.store.StoreFileMetadata;
        return new ReplicationCheckpoint(shardId, codec);
    }
        }
    }
        String codec,
        segmentsGen = in.readLong();
        } else {
    public ReplicationCheckpoint(
import org.opensearch.core.common.io.stream.StreamOutput;
    public long getLength() {
        this.createdTimeStamp = DateUtils.toLong(Instant.now());
    }
        this.segmentInfosVersion = segmentInfosVersion;
import java.util.Objects;
        this.createdTimeStamp = DateUtils.toLong(Instant.now());
import org.opensearch.common.Nullable;
            && codec.equals(that.codec);
        shardId = new ShardId(in);
 *
    }
        }
        } else {
    /**
        primaryTerm = in.readLong();
    private final long primaryTerm;
 * Represents a Replication Checkpoint which is sent to a replica shard.
    @Override
     * Checks if current replication checkpoint is AheadOf `other` replication checkpoint point by first comparing
    private final String codec;
        String codec,
     */
            && segmentsGen == that.segmentsGen
        shardId.writeTo(out);
        long primaryTerm,
        out.writeLong(segmentsGen);
     * Shard Id of primary shard.
 *
            + '}';
        return length;
    /**
        if (other.isAheadOf(this)) {
            + length
            + ", timestamp="
        }
    private final long segmentsGen;
         * @return the codec name
        if (this.isAheadOf(other)) {
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.common.time.DateUtils;
     * The primary term of this Replication Checkpoint.
        this.codec = codec;
    public static ReplicationCheckpoint empty(ShardId shardId) {
            + shardId
            out.writeString(codec);
    public static ReplicationCheckpoint empty(ShardId shardId, String codec) {
    public ShardId getShardId() {
            this.metadataMap = Collections.emptyMap();
     * @return the Segments Gen number
    }
            + segmentsGen
    }
import org.opensearch.core.index.shard.ShardId;
    /**
            + createdTimeStamp
            + ", version="
/**
        if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
            + primaryTerm
    public void writeTo(StreamOutput out) throws IOException {
        if (o == null || getClass() != o.getClass()) return false;
        this.primaryTerm = primaryTerm;
import java.time.Instant;
     * primaryTerm followed by segmentInfosVersion. Returns true when `other` is null.
        Map<String, StoreFileMetadata> metadataMap,
        return metadataMap;
    public ReplicationCheckpoint(ShardId shardId, long primaryTerm, long segmentsGen, long segmentInfosVersion, String codec) {
            length = 0L;
public class ReplicationCheckpoint implements Writeable, Comparable<ReplicationCheckpoint> {
            + ", primaryTerm="
        this.segmentInfosVersion = segmentInfosVersion;
package org.opensearch.indices.replication.checkpoint;
        return other == null
        primaryTerm = SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
     */
        }
    }
    @Override
        this.shardId = shardId;
    public long getPrimaryTerm() {
        this.segmentsGen = segmentsGen;
    public String getCodec() {
 * SPDX-License-Identifier: Apache-2.0
            && Objects.equals(shardId, that.shardId)
        long length,
        return primaryTerm;
            out.writeMap(metadataMap, StreamOutput::writeString, (valueOut, fc) -> fc.writeTo(valueOut));
        } else {
    }
        if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
        this.segmentsGen = segmentsGen;
    public boolean equals(Object o) {
 * compatible open source license.
    public int hashCode() {
    @Override
     */
     *
        long length,
        }
        return segmentInfosVersion;
        this.createdTimeStamp = createdTimeStamp;
        length = 0L;
    private final long segmentInfosVersion;
        this.length = length;
@PublicApi(since = "2.2.0")
    }
        if (this == o) return true;
        return codec;
            + "shardId="
}
            + codec
        }
     * @return The size in bytes of this checkpoint.
        this.codec = codec;
            this.metadataMap = in.readMap(StreamInput::readString, StoreFileMetadata::new);
        this.metadataMap = Collections.emptyMap();
        segmentsGen = SequenceNumbers.NO_OPS_PERFORMED;
import java.util.Collections;
    }
            + segmentInfosVersion
        out.writeLong(segmentInfosVersion);
     * @return the primary term
     * @return the Shard Id
        this.metadataMap = metadataMap;
    }
            codec = in.readString();
        segmentInfosVersion = SequenceNumbers.NO_OPS_PERFORMED;
            return -1;
    public boolean isAheadOf(@Nullable ReplicationCheckpoint other) {
        this.metadataMap = metadataMap;
            + ", segmentsGen="
    /**
        out.writeLong(primaryTerm);
        return empty(shardId, "");
    public ReplicationCheckpoint(
    /**
        this.primaryTerm = primaryTerm;
        this(shardId, primaryTerm, segmentsGen, segmentInfosVersion, 0L, codec, Collections.emptyMap(), DateUtils.toLong(Instant.now()));
        }
            this.createdTimeStamp = 0;
