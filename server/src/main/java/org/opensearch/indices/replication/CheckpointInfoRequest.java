import org.opensearch.core.common.io.stream.StreamInput;
        checkpoint = new ReplicationCheckpoint(in);
    public ReplicationCheckpoint getCheckpoint() {
 * Request object for fetching segment metadata for a {@link ReplicationCheckpoint} from
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        checkpoint.writeTo(out);
}
        String targetAllocationId,  
import java.io.IOException;
        this.checkpoint = checkpoint;
        super.writeTo(out);
        long replicationId,
    }  
 * a {@link SegmentReplicationSource}. This object is created by the target node and sent
import org.opensearch.indices.replication.common.SegmentReplicationTransportRequest;
 * SPDX-License-Identifier: Apache-2.0
    public CheckpointInfoRequest(
 */  
 *
 *
    }
    public CheckpointInfoRequest(StreamInput in) throws IOException {
 * to the source node.  
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
/*  
    public void writeTo(StreamOutput out) throws IOException {  
        super(in);  
package org.opensearch.indices.replication;
        return checkpoint;  
/**  
public class CheckpointInfoRequest extends SegmentReplicationTransportRequest {
    private final ReplicationCheckpoint checkpoint;  
        DiscoveryNode targetNode,
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * compatible open source license.
        super(replicationId, targetAllocationId, targetNode);
 * @opensearch.internal
    }  
    @Override
import org.opensearch.cluster.node.DiscoveryNode;
        ReplicationCheckpoint checkpoint
    ) {  
