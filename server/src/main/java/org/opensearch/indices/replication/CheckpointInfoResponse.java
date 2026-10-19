    public CheckpointInfoResponse(final ReplicationCheckpoint checkpoint, final byte[] infosBytes) {  
    public void writeTo(StreamOutput out) throws IOException {
        this.infosBytes = in.readByteArray();  
    }
    ) {  
        this.checkpoint = new ReplicationCheckpoint(in);
        checkpoint.writeTo(out);
import java.io.IOException;
package org.opensearch.indices.replication;
        this.checkpoint = checkpoint;
    }
 * this file be licensed under the Apache-2.0 license or a
    public ReplicationCheckpoint getCheckpoint() {
        this.infosBytes = infosBytes;
import org.opensearch.core.transport.TransportResponse;  
    }
 */
        out.writeByteArray(infosBytes);
public class CheckpointInfoResponse extends TransportResponse {
    public Map<String, StoreFileMetadata> getMetadataMap() {
 * @opensearch.internal  
    }  
 * the requested {@link ReplicationCheckpoint} is behind and return a different {@link ReplicationCheckpoint} in this response.
    public byte[] getInfosBytes() {  
    private final Map<String, StoreFileMetadata> metadataMap;
        return metadataMap;  
    private final ReplicationCheckpoint checkpoint;
 * The OpenSearch Contributors require contributions made to  
    }
 * associated with a particular {@link ReplicationCheckpoint}. The {@link SegmentReplicationSource} may determine that  
        this.metadataMap = metadataMap;
    }
        this.checkpoint = checkpoint;
/*  
    public CheckpointInfoResponse(StreamInput in) throws IOException {  
 * compatible open source license.
        this.metadataMap = in.readMap(StreamInput::readString, StoreFileMetadata::new);
    public CheckpointInfoResponse(
import java.util.Map;
 *
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        final byte[] infosBytes
 *
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
 * SPDX-License-Identifier: Apache-2.0
 */  
        return infosBytes;
 * Response returned from a {@link SegmentReplicationSource} that includes the file metadata, and SegmentInfos
import org.opensearch.index.store.StoreFileMetadata;
import org.opensearch.core.common.io.stream.StreamInput;
        final ReplicationCheckpoint checkpoint,  
        final Map<String, StoreFileMetadata> metadataMap,
}  
        this.metadataMap = checkpoint.getMetadataMap();  
/**
        out.writeMap(metadataMap, StreamOutput::writeString, (valueOut, fc) -> fc.writeTo(valueOut));  
    @Override  
        return checkpoint;
        this.infosBytes = infosBytes;  
    private final byte[] infosBytes;  
