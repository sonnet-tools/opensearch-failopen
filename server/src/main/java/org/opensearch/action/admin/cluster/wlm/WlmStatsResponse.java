    public WlmStatsResponse(ClusterName clusterName, List<WlmStats> nodes, List<FailedNodeException> failures) {
            toXContent(builder, EMPTY_PARAMS);
    protected void writeNodesTo(StreamOutput out, List<WlmStats> nodes) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
        return in.readList(WlmStats::new);
    }  
import org.opensearch.core.xcontent.XContentBuilder;  
package org.opensearch.action.admin.cluster.wlm;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
}  
            builder.startObject();
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        out.writeList(nodes);
    }  
    public String toString() {
    @Override
        } catch (IOException e) {
import org.opensearch.cluster.ClusterName;  
 *
        return builder;  
        try {
 */  
    @Override  
        for (WlmStats wlmStats : getNodes()) {  
/*  
        }
 * A response for obtaining Workload Management Stats
import org.opensearch.action.FailedNodeException;
            builder.startObject(wlmStats.getNode().getId());
 */  
            XContentBuilder builder = XContentFactory.jsonBuilder().prettyPrint();  
            builder.endObject();
import org.opensearch.common.xcontent.XContentFactory;
    }
public class WlmStatsResponse extends BaseNodesResponse<WlmStats> implements ToXContentFragment {
            WorkloadGroupStats workloadGroupStats = wlmStats.getWorkloadGroupStats();
import java.util.List;
        super(clusterName, nodes, failures);  
        }
import org.opensearch.action.support.nodes.BaseNodesResponse;
import org.opensearch.core.xcontent.ToXContentFragment;
 * SPDX-License-Identifier: Apache-2.0
    @Override
        super(in);
    WlmStatsResponse(StreamInput in) throws IOException {
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;  
    protected List<WlmStats> readNodesFrom(StreamInput in) throws IOException {
/**
import org.opensearch.wlm.stats.WlmStats;
import org.opensearch.wlm.stats.WorkloadGroupStats;
            return builder.toString();
            builder.endObject();  
    }
            workloadGroupStats.toXContent(builder, params);  
 * this file be licensed under the Apache-2.0 license or a
            return "{ \"error\" : \"" + e.getMessage() + "\"}";  
    @Override  
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi
import java.io.IOException;
