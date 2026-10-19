        out.writeLong(replicationCheckpoint.getSegmentsGen());
            version >= VERSION_TWO ? in.readLong() : 0  
            .stream()
    public void write(IndexOutput out) throws IOException {
     * Generate {@link RemoteSegmentMetadata} from {@code segmentMetadata}
        indexInput.readBytes(segmentInfosBytes, 0, byteArraySize);
        Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> metadata,
        out.writeLong(replicationCheckpoint.getSegmentInfosVersion());
import org.apache.lucene.store.IndexOutput;
    /**
    }
import org.apache.lucene.store.IndexInput;
    public static RemoteSegmentMetadata read(IndexInput indexInput, int version) throws IOException {  
        return metadata.entrySet()
     * Generate {@code Map<String, String>} from {@link RemoteSegmentMetadata}  
        out.writeBytes(segmentInfosBytes, segmentInfosBytes.length);
     * @return {@code Map<String, String>}
            in.readLong(),
     * Write always writes with the latest version of the RemoteSegmentMetadata  
    }  
    /**
        this.metadata = metadata;  
            .map(
import org.opensearch.core.index.shard.ShardId;  
    }  
            );
     * @param out file output stream which will store stream content
    }
    }
    public static void writeCheckpointToIndexOutput(ReplicationCheckpoint replicationCheckpoint, IndexOutput out) throws IOException {
     * @return {@code RemoteSegmentMetadata}  
        return segmentMetadata.entrySet()
 *  
     */  
    }  
     * @throws IOException in case there is a problem writing the file
     */  
    public static Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> fromMapOfStrings(Map<String, String> segmentMetadata) {  
/*  
            .stream()
     */
     */
 *
    /**
@PublicApi(since = "2.6.0")  
        out.writeString(shardId.getIndex().getName());
                Collectors.toMap(
        out.writeString(shardId.getIndex().getUUID());  
        return replicationCheckpoint;
     * @param version version of the RemoteSegmentMetadata
        return new ReplicationCheckpoint(
import java.util.stream.Collectors;
import org.opensearch.core.index.Index;
     */
 * Metadata object for Remote Segment
    }
            toStoreFileMetadata(uploadedSegmentMetadataMap),
        ReplicationCheckpoint replicationCheckpoint
    public ReplicationCheckpoint getReplicationCheckpoint() {
import org.apache.lucene.util.Version;  
     * Read can happen in the upgraded version of replica which needs to support all versions of RemoteSegmentMetadata  
     * Metadata codec  
 * SPDX-License-Identifier: Apache-2.0
     */
     */
     * @return {@link RemoteSegmentMetadata}
            in.readLong(),  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            new ShardId(new Index(in.readString(), in.readString()), in.readVInt()),
    }  
            in.readString(),
            in.readLong(),
        IndexInput in,  
 */
            .collect(Collectors.toMap(StoreFileMetadata::name, Function.identity()));
        return new RemoteSegmentMetadata(uploadedSegmentMetadataMap, segmentInfosBytes, replicationCheckpoint);
import java.util.function.Function;
                    entry -> RemoteSegmentStoreDirectory.UploadedSegmentMetadata.fromString(entry.getValue())  
                )
/**
    public static final String METADATA_CODEC = "segment_md";
    public byte[] getSegmentInfosBytes() {
    ) {  
                entry -> new StoreFileMetadata(entry.getKey(), entry.getValue().getLength(), entry.getValue().getChecksum(), Version.LATEST)
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
        this.segmentInfosBytes = segmentInfosBytes;
     * @param indexInput file input stream
    public long getGeneration() {
    private final byte[] segmentInfosBytes;  
    public Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> getMetadata() {  
     * @param segmentMetadata metadata content in the form of {@code Map<String, String>}  
        return segmentInfosBytes;
        Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> uploadedSegmentMetadataMap,
        return this.metadata.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toString()));
    ) throws IOException {  
                    Map.Entry::getKey,
     */  
        out.writeLong(replicationCheckpoint.getPrimaryTerm());  
        ShardId shardId = replicationCheckpoint.getShardId();  
    }
    /**
        );
    public long getPrimaryTerm() {  
public class RemoteSegmentMetadata {
        out.writeString(replicationCheckpoint.getCodec());
     * @return {@code metadata}
     * Latest supported version of metadata
        this.replicationCheckpoint = replicationCheckpoint;
        writeCheckpointToIndexOutput(replicationCheckpoint, out);  
            .collect(  
        return replicationCheckpoint.getPrimaryTerm();
        final Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> uploadedSegmentMetadataMap = RemoteSegmentMetadata
    private static Map<String, StoreFileMetadata> toStoreFileMetadata(
    public Map<String, String> toMapOfStrings() {  
        out.writeLong(replicationCheckpoint.getCreatedTimeStamp());
    }
package org.opensearch.index.store.remote.metadata;
        out.writeLong(replicationCheckpoint.getLength());  
 */  
    private final ReplicationCheckpoint replicationCheckpoint;
import java.io.IOException;
}  
import org.opensearch.index.store.StoreFileMetadata;
    private static ReplicationCheckpoint readCheckpointFromIndexInput(
    /**
import java.util.Map;  
        int version
        Map<String, String> metadata = indexInput.readMapOfStrings();
    public static final int VERSION_TWO = 2;
 * @opensearch.api
        return replicationCheckpoint.getSegmentsGen();  
    }  
import org.opensearch.common.annotation.PublicApi;
        ReplicationCheckpoint replicationCheckpoint = readCheckpointFromIndexInput(indexInput, uploadedSegmentMetadataMap, version);
 * The OpenSearch Contributors require contributions made to  
    public static final int VERSION_ONE = 1;  
            in.readLong(),  
        Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> metadata
        // Write remaining checkpoint fields
 * compatible open source license.
        // Write ShardId
    }  
    public RemoteSegmentMetadata(
        out.writeLong(segmentInfosBytes.length);
 * this file be licensed under the Apache-2.0 license or a
            .fromMapOfStrings(metadata);  
        byte[] segmentInfosBytes,  
        out.writeVInt(shardId.getId());
        return this.metadata;
        int byteArraySize = (int) indexInput.readLong();
    ) {
    /**
        byte[] segmentInfosBytes = new byte[byteArraySize];  
     * Exposes underlying metadata content data structure.  
            )  
            // TODO: Version here should be read from UploadedSegmentMetadata.  
    private final Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> metadata;
    public static final int CURRENT_VERSION = VERSION_TWO;
     * @throws IOException in case there is a problem reading from the file input stream
    /**
    }  
        out.writeMapOfStrings(toMapOfStrings());
     * Data structure holding metadata content
    /**
