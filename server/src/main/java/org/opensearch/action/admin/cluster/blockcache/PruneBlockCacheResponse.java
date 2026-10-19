        builder.field("failed_nodes", failures().size());
        }
        return builder;  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
 * compatible open source license.
import org.opensearch.cluster.ClusterName;  
 */
    protected List<NodePruneBlockCacheResponse> readNodesFrom(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        if (failures().isEmpty() == false) {
        out.writeList(nodes);
                builder.startObject();
    }  
        builder.field("total_nodes_targeted", getNodes().size() + failures().size());  
        builder.startObject("nodes");
        builder.field("acknowledged", true);
    @Override
        builder.field("successful_nodes", getNodes().size());
    public PruneBlockCacheResponse(ClusterName clusterName, List<NodePruneBlockCacheResponse> nodes, List<FailedNodeException> failures) {
                builder.endObject();  
package org.opensearch.action.admin.cluster.blockcache;
 */  
/**  
    }
    public PruneBlockCacheResponse(StreamInput in) throws IOException {
import org.opensearch.action.FailedNodeException;
        builder.endObject();
}
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/*  
    }
        return in.readList(NodePruneBlockCacheResponse::new);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.nodes.BaseNodesResponse;
        builder.endObject();  
 * SPDX-License-Identifier: Apache-2.0
        builder.startObject("summary");
        super(clusterName, nodes, failures);  
                builder.endObject();
                builder.startObject(node.getNode().getId());
    }  
    }
        for (NodePruneBlockCacheResponse node : getNodes()) {
            }
            }
        builder.endObject();  
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
            if (node != null && node.getNode() != null) {  
 * Cluster-wide response for a block cache prune operation.
    @Override  
                node.toXContent(builder, params);
 *
import org.opensearch.core.xcontent.ToXContentObject;  
public class PruneBlockCacheResponse extends BaseNodesResponse<NodePruneBlockCacheResponse> implements ToXContentObject {
        super(in);
import java.io.IOException;  
            builder.startArray("failures");
                builder.field("reason", failure.getDetailedMessage());  
            for (FailedNodeException failure : failures()) {  
import java.util.List;
        }
        builder.startObject();  
                builder.field("node_id", failure.nodeId());
            builder.endArray();  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
    protected void writeNodesTo(StreamOutput out, List<NodePruneBlockCacheResponse> nodes) throws IOException {  
