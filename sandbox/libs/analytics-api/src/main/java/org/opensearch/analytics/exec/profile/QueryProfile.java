 * @param stages         per-stage profiles in DAG iteration order (root stage appears at whatever index the walker stored it)  
import java.util.List;
        builder.endArray();
 * {@code TaskTracker}. Safe to emit on both success and failure paths — every field  
 * @param executionTimeMs wall-clock span from the earliest stage start to the latest stage end (0 if nothing ran)
import org.opensearch.core.xcontent.ToXContentObject;
        builder.startArray("stages");  
        builder.field("query_id", queryId);  
            builder.startArray("full_plan");
            for (String line : fullPlan)  
 * this file be licensed under the Apache-2.0 license or a
 * @param queryId        per-query id from {@code QueryDAG.queryId()}  
/**
 *                       captured before the DAG builder cut it at exchange boundaries;
                builder.value(line);
        builder.field("execution_time_ms", executionTimeMs);
import java.io.IOException;
 *
            builder.endArray();
            s.toXContent(builder, params);
        builder.startObject();
    implements  
        }  
 * compatible open source license.
 * is a plain value captured at snapshot time, not a live handle into the walker.
public record QueryProfile(String queryId, List<String> fullPlan, long planningTimeMs, long executionTimeMs, List<StageProfile> stages)
 *
        for (StageProfile s : stages) {
        builder.endObject();
        return builder;  
 *                       one element per indent level of the tree. Empty list if not supplied.  
    }
        if (fullPlan != null && fullPlan.isEmpty() == false) {
/*  
 */
 * @param planningTimeMs wall-clock time spent in the coordinator planning pipeline (PlannerImpl through FragmentConversionDriver)
 * @param fullPlan       the CBO-output Calcite plan rendered as an array of lines,
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    @Override  
        }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        ToXContentObject {
}
        builder.field("planning_time_ms", planningTimeMs);
 * Query-level profile snapshot built from an execution graph plus the per-query
 */  
package org.opensearch.analytics.exec.profile;
