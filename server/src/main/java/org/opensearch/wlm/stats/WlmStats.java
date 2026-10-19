    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
        WlmStats that = (WlmStats) o;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;  
 * this file be licensed under the Apache-2.0 license or a
    public boolean equals(Object o) {
    public WlmStats(StreamInput in) throws IOException {
}
import org.opensearch.core.common.io.stream.StreamOutput;
 * compatible open source license.
        this.workloadGroupStats = workloadGroupStats;
    }  
        return Objects.equals(getWorkloadGroupStats(), that.getWorkloadGroupStats());
    public WorkloadGroupStats getWorkloadGroupStats() {
import java.io.IOException;  
        super.writeTo(out);  
/**  
        super(in);  
 * The OpenSearch Contributors require contributions made to  
        workloadGroupStats = new WorkloadGroupStats(in);
import org.opensearch.cluster.node.DiscoveryNode;
        super(node);
/*  
    private final WorkloadGroupStats workloadGroupStats;
 *
        return workloadGroupStats.toXContent(builder, params);  
        if (this == o) return true;
    @Override
        return Objects.hash(workloadGroupStats);
 */  
    }  
    }
    @Override  
    public void writeTo(StreamOutput out) throws IOException {
    @Override
import org.opensearch.action.support.nodes.BaseNodeResponse;
        workloadGroupStats.writeTo(out);
 * This class contains the stats for Workload Management
        if (o == null || getClass() != o.getClass()) return false;  
    }  
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public WlmStats(DiscoveryNode node, WorkloadGroupStats workloadGroupStats) {  
public class WlmStats extends BaseNodeResponse implements ToXContentObject, Writeable {  
 */
        return workloadGroupStats;
import org.opensearch.core.xcontent.ToXContentObject;  
import java.util.Objects;
package org.opensearch.wlm.stats;
    @Override
import org.opensearch.core.common.io.stream.Writeable;
    public int hashCode() {  
    }
