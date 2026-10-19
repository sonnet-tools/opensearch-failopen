import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
    private final ReplicationCheckpoint checkpoint;
        long replicationId,
    public void writeTo(StreamOutput out) throws IOException {
 * Request object for fetching a list of segment files metadata from a {@link SegmentReplicationSource}.  
 */  
package org.opensearch.indices.replication;
    }  
    private final List<StoreFileMetadata> filesToFetch;
 * @opensearch.internal  
        super.writeTo(out);  
    public GetSegmentFilesRequest(StreamInput in) throws IOException {
    ) {
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        this.filesToFetch = filesToFetch;  
import org.opensearch.indices.replication.common.SegmentReplicationTransportRequest;  
        this.checkpoint = new ReplicationCheckpoint(in);
        checkpoint.writeTo(out);
        this.checkpoint = checkpoint;
        return checkpoint;  
    }
        DiscoveryNode targetNode,
 */
        return filesToFetch;
/**
/*  
}  
import org.opensearch.index.store.StoreFileMetadata;
    @Override
 *
        out.writeList(filesToFetch);
    }
        super(replicationId, targetAllocationId, targetNode);
    public ReplicationCheckpoint getCheckpoint() {
 * This object is created by the target node and sent to the source node.
 * compatible open source license.
    public GetSegmentFilesRequest(
public class GetSegmentFilesRequest extends SegmentReplicationTransportRequest {
    }
 *
import java.util.List;  
    public List<StoreFileMetadata> getFilesToFetch() {  
        ReplicationCheckpoint checkpoint  
        this.filesToFetch = in.readList(StoreFileMetadata::new);  
        List<StoreFileMetadata> filesToFetch,
        super(in);
    }
        String targetAllocationId,  
import org.opensearch.core.common.io.stream.StreamOutput;  
