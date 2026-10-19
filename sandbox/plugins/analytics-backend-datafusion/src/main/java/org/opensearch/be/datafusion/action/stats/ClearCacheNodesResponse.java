    }
 * The OpenSearch Contributors require contributions made to  
    protected void writeNodesTo(StreamOutput out, List<ClearCacheNodeResponse> nodes) throws IOException {
    @Override
        return in.readList(ClearCacheNodeResponse::new);
import org.opensearch.action.support.nodes.BaseNodesResponse;
        builder.endArray();
    @Override  
import java.util.List;
import org.opensearch.core.common.io.stream.StreamInput;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/** Aggregated cluster-wide response for the clear-scoped-cache broadcast. @opensearch.internal */  
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
    protected List<ClearCacheNodeResponse> readNodesFrom(StreamInput in) throws IOException {  
    public ClearCacheNodesResponse(StreamInput in) throws IOException {
    }
    public ClearCacheNodesResponse(ClusterName clusterName, List<ClearCacheNodeResponse> nodes, List<FailedNodeException> failures) {  
        builder.startArray("cleared_nodes");  
 * this file be licensed under the Apache-2.0 license or a
        return builder;
        super(clusterName, nodes, failures);
 */  
}
import org.opensearch.action.FailedNodeException;
        builder.field("acknowledged", failures() == null || failures().isEmpty());
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            builder.value(node.getNode().getId());
    }
    }  
 *
package org.opensearch.be.datafusion.action.stats;
        out.writeList(nodes);  
import java.io.IOException;  
    }  
public class ClearCacheNodesResponse extends BaseNodesResponse<ClearCacheNodeResponse> implements ToXContentFragment {
/*  
        super(in);
import org.opensearch.core.xcontent.ToXContentFragment;  
import org.opensearch.cluster.ClusterName;  
        }  
        for (ClearCacheNodeResponse node : getNodes()) {
