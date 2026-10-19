import org.opensearch.core.xcontent.XContentBuilder;
 * The OpenSearch Contributors require contributions made to  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    protected List<AnalyticsStatsNodeResponse> readNodesFrom(StreamInput in) throws IOException {
import org.opensearch.action.FailedNodeException;
package org.opensearch.analytics.stats.transport;
import java.util.List;
import org.opensearch.common.annotation.ExperimentalApi;
        }
    public AnalyticsStatsResponse(StreamInput in) throws IOException {
            builder.startObject(node.getNode().getId());
    }  
    }
 *
 * SPDX-License-Identifier: Apache-2.0
 */  
 * {@link org.opensearch.rest.action.RestActions#nodesResponse}.  
}  
        super(clusterName, nodes, failures);  
        return builder;
            node.getStats().toXContent(builder, params);  
        builder.startObject("nodes");  
    }
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
    protected void writeNodesTo(StreamOutput out, List<AnalyticsStatsNodeResponse> nodes) throws IOException {  
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.cluster.ClusterName;  
 * {@code _nodes/stats} layout: each contacted node's analytics rollup is  
    }  
        for (AnalyticsStatsNodeResponse node : getNodes()) {
    }
 */  
/*  
/**
 * @opensearch.experimental
import org.opensearch.action.support.nodes.BaseNodesResponse;
 *
 * this file be licensed under the Apache-2.0 license or a
 * rendered under its node id. The {@code _nodes} header (total/successful/failed)
        return in.readList(AnalyticsStatsNodeResponse::new);
        out.writeList(nodes);
    @Override
@ExperimentalApi
 * Cluster-wide response for {@code GET _plugins/_analytics/stats}. Mirrors
        builder.endObject();  
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
    public AnalyticsStatsResponse(ClusterName clusterName, List<AnalyticsStatsNodeResponse> nodes, List<FailedNodeException> failures) {
        super(in);
 * compatible open source license.
 * and the {@code cluster_name} are emitted by the REST handler via
            builder.endObject();
    @Override  
public class AnalyticsStatsResponse extends BaseNodesResponse<AnalyticsStatsNodeResponse> implements ToXContentObject {
