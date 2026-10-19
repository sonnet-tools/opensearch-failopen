public class DataFusionStatsNodesResponse extends BaseNodesResponse<DataFusionStatsNodeResponse> implements ToXContentFragment {
     */
 *       "transport_address": "...",
/**
            }
     * @param clusterName the cluster name
     * @throws IOException if deserialization fails
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
        builder.field("cluster_name", getClusterName().value());  
 *       // stats from DataFusionStats.toXContent
 * to render the full JSON structure including {@code _nodes}, {@code cluster_name},
        out.writeList(nodes);  
     * @param nodes       the list of successful per-node responses
 *       "host": "...",  
     * Deserialize from stream.
import java.io.IOException;
 * Aggregated cluster-wide response for DataFusion stats.
 *       "name": "...",
package org.opensearch.be.datafusion.action.stats;
        List<FailedNodeException> failures
            builder.startObject(nodeResponse.getNode().getId());
        List<DataFusionStatsNodeResponse> nodes,
import java.util.List;
    public DataFusionStatsNodesResponse(StreamInput in) throws IOException {
                nodeResponse.getStats().toXContent(builder, params);
    public DataFusionStatsNodesResponse(
 *   "_nodes": { "total": N, "successful": S, "failed": F, "failures": [...] },
        for (DataFusionStatsNodeResponse nodeResponse : getNodes()) {  
        return builder;
    /**
    }  
 *   "nodes": {  
    @Override  
import org.opensearch.rest.action.RestActions;
     * Construct a nodes response with the given cluster name, successful node responses, and failures.
    @Override
     *  
 *
    }
    }  
        ClusterName clusterName,  
        return in.readList(DataFusionStatsNodeResponse::new);
        }
        super(in);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *   }
    @Override
 * and per-node stats keyed by node ID.
/*  
        builder.endObject();  
import org.opensearch.cluster.ClusterName;  
        builder.startObject("nodes");
            builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
 *  
}
     * @param failures    the list of failed node exceptions  
 * this file be licensed under the Apache-2.0 license or a
 * </pre>  
    ) {  
     *  
    protected List<DataFusionStatsNodeResponse> readNodesFrom(StreamInput in) throws IOException {  
 *     "node-id-1": {
        super(clusterName, nodes, failures);
import org.opensearch.action.support.nodes.BaseNodesResponse;
import org.opensearch.core.common.io.stream.StreamOutput;
 * <pre>
    }
            if (nodeResponse.getStats() != null) {  
        RestActions.buildNodesHeader(builder, params, this);
    /**
    protected void writeNodesTo(StreamOutput out, List<DataFusionStatsNodeResponse> nodes) throws IOException {
    }
 * {  
 * The OpenSearch Contributors require contributions made to  
 *     }  
 * <p>JSON structure:
import org.opensearch.core.xcontent.ToXContentFragment;  
 */
 * Extends {@link BaseNodesResponse} and implements {@link ToXContentFragment}  
 * }
 *   "cluster_name": "...",
     */  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.FailedNodeException;
     * @param in the stream input
 */  
