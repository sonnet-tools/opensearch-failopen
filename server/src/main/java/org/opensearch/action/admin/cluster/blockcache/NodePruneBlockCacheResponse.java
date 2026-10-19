    }
/*  
        super.writeTo(out);
        builder.field("host", getNode().getHostName());
import java.io.IOException;
 *  
        return builder;
    }
    @Override
        if (this == o) return true;
    @Override  
    }  
        super(node);
public class NodePruneBlockCacheResponse extends BaseNodeResponse implements ToXContentFragment {  
 *
 * SPDX-License-Identifier: Apache-2.0
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field("ip", getNode().getHostAddress());  
    @Override
        builder.field("transport_address", getNode().getAddress().toString());
package org.opensearch.action.admin.cluster.blockcache;
    private final boolean cleared;
    public int hashCode() {  
        return cleared == other.cleared && getNode().getId().equals(other.getNode().getId());
import org.opensearch.cluster.node.DiscoveryNode;
    public boolean equals(Object o) {
        return java.util.Objects.hash(getNode().getId(), cleared);
    }  
        builder.field("cleared", cleared);
 * this file be licensed under the Apache-2.0 license or a
/**
 */
        builder.field("name", getNode().getName());  
import org.opensearch.core.common.io.stream.StreamOutput;
        this.cleared = in.readBoolean();  
    @Override
}
    }
    public boolean isCleared() {
 * The OpenSearch Contributors require contributions made to  
 * Per-node response for a block cache prune operation.
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.core.xcontent.ToXContentFragment;
 * compatible open source license.
 */  
        out.writeBoolean(cleared);
    public NodePruneBlockCacheResponse(StreamInput in) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {  
    }  
    public NodePruneBlockCacheResponse(DiscoveryNode node, boolean cleared) {  
        if (!(o instanceof NodePruneBlockCacheResponse)) return false;  
        this.cleared = cleared;
        NodePruneBlockCacheResponse other = (NodePruneBlockCacheResponse) o;
 * @opensearch.internal
import org.opensearch.action.support.nodes.BaseNodeResponse;
        return cleared;  
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        super(in);
