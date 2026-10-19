    private final String targetAllocationId;
    }  
        this.replicationId = replicationId;
 */  
    }  
    public String toString() {
/**
        this.replicationId = in.readLong();  
        super.writeTo(out);
        targetNode.writeTo(out);
}
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            + '\''
        out.writeString(this.targetAllocationId);  
        return replicationId;
public abstract class SegmentReplicationTransportRequest extends TransportRequest {
/*  
    public String getTargetAllocationId() {
    }
    public DiscoveryNode getTargetNode() {  
    }  
    protected SegmentReplicationTransportRequest(long replicationId, String targetAllocationId, DiscoveryNode targetNode) {
 * Abstract base class for transport-layer requests related to segment replication.  
    }
            + replicationId
            + '}';
        super(in);
    @Override
            + targetAllocationId
    }
 * SPDX-License-Identifier: Apache-2.0
 *
            + ", targetNode="  
    @Override
    public long getReplicationId() {
    protected SegmentReplicationTransportRequest(StreamInput in) throws IOException {
            + targetNode
    }
        this.targetAllocationId = in.readString();
        this.targetNode = targetNode;
    private final long replicationId;  
            + "replicationId="
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.core.common.io.stream.StreamInput;
            + ", targetAllocationId='"  
 * @opensearch.internal
        return targetAllocationId;  
    private final DiscoveryNode targetNode;
        out.writeLong(this.replicationId);
        this.targetNode = new DiscoveryNode(in);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.TransportRequest;
import java.io.IOException;  
        this.targetAllocationId = targetAllocationId;  
        return targetNode;
import org.opensearch.core.common.io.stream.StreamOutput;  
        return "SegmentReplicationTransportRequest{"  
 */  
 *
package org.opensearch.indices.replication.common;
    public void writeTo(StreamOutput out) throws IOException {  
