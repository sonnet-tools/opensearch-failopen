 * wall-clock elapsed time, optional data-node execution metrics, and  
        builder.startObject();
            for (Map.Entry<String, Long> entry : dataNodeMetrics.entrySet()) {
package org.opensearch.analytics.exec.profile;
 * Per-task profile snapshot. Captures target node, terminal state,
import java.util.Map;
        builder.field("elapsed_ms", elapsedMs);
 * @param dataNodeMetrics execution metrics from the data node (DataFusion operator timings), or null if not profiled  
 * @param elapsedMs wall-clock time from dispatch to terminal, or 0 if never dispatched
 * this file be licensed under the Apache-2.0 license or a
            builder.endObject();
 */  
        builder.field("state", state);
/*  
 *
        return builder;
import java.io.IOException;
    public TaskProfile(String node, String state, long elapsedMs) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
}
import org.opensearch.core.xcontent.ToXContentObject;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
            builder.field("physical_plan", physicalPlan);
 * @param node target node and shard the task ran on, or "(unknown)" if dispatch never happened  
 */
        if (dataNodeMetrics != null && dataNodeMetrics.isEmpty() == false) {  
        }  
    implements
    @Override  
 *
    /** Convenience constructor without data node metrics or physical plan. */
 * The OpenSearch Contributors require contributions made to  
        builder.endObject();
            }
public record TaskProfile(String node, String state, long elapsedMs, Map<String, Long> dataNodeMetrics, String physicalPlan)  
 * the DataFusion physical plan text.
/**
 * @param state terminal state — CREATED if the task was never dispatched
        if (physicalPlan != null) {
        }  
            builder.startObject("data_node_metrics");
        builder.field("node", node);  
 * compatible open source license.
                builder.field(entry.getKey(), entry.getValue());  
 * @param physicalPlan DataFusion physical execution plan text, or null if not profiled
        ToXContentObject {
    }  
        this(node, state, elapsedMs, null, null);  
