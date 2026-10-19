    }  
        return primaryShardId;
        checkpoint = new ReplicationCheckpoint(in);
 * Request object for updating the replica's checkpoint on primary for tracking.
        return checkpoint;
        super.writeTo(out);
        ShardId primaryShardId,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
        primaryShardId.writeTo(out);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.shard.ShardId;
 */  
        this.checkpoint = checkpoint;
    }  
 * compatible open source license.
 *  
    ) {
    }
        ReplicationCheckpoint checkpoint
import org.opensearch.core.common.io.stream.StreamOutput;  
package org.opensearch.indices.replication;
    public UpdateVisibleCheckpointRequest(
    private final ReplicationCheckpoint checkpoint;
    @Override
        DiscoveryNode targetNode,  
 *
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        checkpoint.writeTo(out);
public class UpdateVisibleCheckpointRequest extends SegmentReplicationTransportRequest {  
    public ShardId getPrimaryShardId() {
/*  
        super(in);  
        String targetAllocationId,
import org.opensearch.cluster.node.DiscoveryNode;
/**
import org.opensearch.indices.replication.common.SegmentReplicationTransportRequest;  
        long replicationId,  
        primaryShardId = new ShardId(in);
    private final ShardId primaryShardId;  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        super(replicationId, targetAllocationId, targetNode);  
    public ReplicationCheckpoint getCheckpoint() {  
    public UpdateVisibleCheckpointRequest(StreamInput in) throws IOException {
    }
    }  
}
 */
        this.primaryShardId = primaryShardId;
    public void writeTo(StreamOutput out) throws IOException {  
 * @opensearch.internal
