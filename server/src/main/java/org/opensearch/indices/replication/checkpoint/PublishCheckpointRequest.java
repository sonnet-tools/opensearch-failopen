    public String toString() {
    public void writeTo(StreamOutput out) throws IOException {
}
 * this file be licensed under the Apache-2.0 license or a
    }
        super(in);
    private final ReplicationCheckpoint checkpoint;
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;  
 *
    @Override  
        this.checkpoint = checkpoint;  
 * The OpenSearch Contributors require contributions made to  
/**
        checkpoint.writeTo(out);  
        super.writeTo(out);
 * Replication request responsible for publishing checkpoint request to a replica shard.
    public ReplicationCheckpoint getCheckpoint() {
    /**
    }
        return checkpoint;  
     * Returns Replication Checkpoint  
public class PublishCheckpointRequest extends ReplicationRequest<PublishCheckpointRequest> {  
    }  
import org.opensearch.action.support.replication.ReplicationRequest;
import org.opensearch.core.common.io.stream.StreamInput;
 */  
 * @opensearch.internal
    }
    @Override  
        super(checkpoint.getShardId());
    }  
    public PublishCheckpointRequest(ReplicationCheckpoint checkpoint) {
     */
        return "PublishCheckpointRequest{" + "checkpoint=" + checkpoint + '}';
package org.opensearch.indices.replication.checkpoint;
 * SPDX-License-Identifier: Apache-2.0
/*  
    public PublishCheckpointRequest(StreamInput in) throws IOException {  
 */
 *  
 * compatible open source license.
        this.checkpoint = new ReplicationCheckpoint(in);
