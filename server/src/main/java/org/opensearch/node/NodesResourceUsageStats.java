    @Override  
        this.nodeIdToResourceUsageStatsMap = nodeIdToResourceUsageStatsMap;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        for (String nodeId : nodeIdToResourceUsageStatsMap.keySet()) {  
        return nodeIdToResourceUsageStatsMap;  
     * Returns map of node id to resource usage stats of the corresponding node.  
import java.util.Map;
    }  
    public NodesResourceUsageStats(Map<String, NodeResourceUsageStats> nodeIdToResourceUsageStatsMap) {
import org.opensearch.core.xcontent.XContentBuilder;
        this.nodeIdToResourceUsageStatsMap = in.readMap(StreamInput::readString, NodeResourceUsageStats::new);  
    @Override  
public class NodesResourceUsageStats implements Writeable, ToXContentFragment {
        builder.endObject();
    public void writeTo(StreamOutput out) throws IOException {
    }
 * SPDX-License-Identifier: Apache-2.0
        return builder;
 * The OpenSearch Contributors require contributions made to  
        out.writeMap(this.nodeIdToResourceUsageStatsMap, StreamOutput::writeString, (stream, stats) -> stats.writeTo(stream));
import org.opensearch.core.common.io.stream.Writeable;  
/**
 * this file be licensed under the Apache-2.0 license or a
/*  
            resourceUsageStats.toXContent(builder, params);
        builder.startObject("resource_usage_stats");
import org.opensearch.core.xcontent.ToXContentFragment;
     */
import java.io.IOException;
 */  
}
    }
 */
 * This class represents resource usage stats such as CPU, Memory and IO resource usage of each node along with the
 *
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
 * compatible open source license.
    }  
            NodeResourceUsageStats resourceUsageStats = nodeIdToResourceUsageStatsMap.get(nodeId);
    public NodesResourceUsageStats(StreamInput in) throws IOException {
package org.opensearch.node;
    public Map<String, NodeResourceUsageStats> getNodeIdToResourceUsageStatsMap() {
        }  
    // Map of node id to resource usage stats of the corresponding node.
    }  
    private final Map<String, NodeResourceUsageStats> nodeIdToResourceUsageStatsMap;
 * timestamp of the stats recorded.  
