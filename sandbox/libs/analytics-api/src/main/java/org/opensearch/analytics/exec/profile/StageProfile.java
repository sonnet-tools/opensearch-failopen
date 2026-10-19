 *                             raw JSON than a single multi-line escaped string  
 *                             array of lines (one element per level of indent) — much easier to read in
 * @param rowsProcessed        counter from {@code StageMetrics.addRowsProcessed}
            builder.startArray("fragment");
 * @param treeShape            {@code FilterTreeShape} (NO_DELEGATION, CONJUNCTIVE, INTERLEAVED_BOOLEAN_EXPRESSION)  
 * @param tasksCompleted       counter from {@code StageMetrics.incrementTasksCompleted}
 *
        builder.startArray("tasks");  
        if (distribution != null) builder.field("distribution", distribution);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
 */  
 *                             plan; {@code null} when no alternative is bound, serialized as "unknown".
        builder.field("execution_type", executionType);
        builder.endArray();
 * @param distribution         Calcite distribution type this stage emits to its parent — e.g. SINGLETON, HASH_DISTRIBUTED; null for root
 * @param executionType        value of {@code StageExecutionType} as string (SHARD_FRAGMENT, COORDINATOR_REDUCE, LOCAL_PASSTHROUGH)
        return builder;  
        builder.field("stage_id", stageId);  
    @Override  
 * @param tasks                per-partition task profiles registered with the TaskTracker  
import java.util.List;
        TaskProfile> tasks) implements ToXContentObject {
        builder.field("rows_processed", rowsProcessed);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/*  
                builder.value(line);
 * the list of {@link TaskProfile}s for the stage's dispatched tasks.
 * @param elapsedMs            {@code endMs - startMs}, or 0 if either stamp is missing  
public record StageProfile(int stageId, String executionType, String distribution, String state, long startMs, long endMs, long elapsedMs,
 *                             carried by the stage's filter / shard-scan-with-delegation instruction;
 * distribution), terminal state, wall-clock timing from {@code StageMetrics}, and  
/**
            for (String line : fragment)  
        builder.field("tasks_completed", tasksCompleted);
 * @param chosenBackend        backend id (e.g. "lucene", "datafusion") from the post-selector first
 *
import java.io.IOException;
        builder.startObject();
package org.opensearch.analytics.exec.profile;
        builder.field("tasks_failed", tasksFailed);  
 * @param endMs                wall-clock millis from {@code StageMetrics.recordEnd()}, 0 if still running
 * this file be licensed under the Apache-2.0 license or a
        }  
 */
            builder.endArray();
        builder.field("state", state);  
    }
 * compatible open source license.
            t.toXContent(builder, params);
import org.opensearch.core.xcontent.ToXContentObject;
}
 * The OpenSearch Contributors require contributions made to  
        if (startMs > 0) builder.field("start_ms", startMs);
 * Per-stage profile snapshot. Combines stage-level metadata (id, execution type,
    long rowsProcessed, long tasksCompleted, long tasksFailed, List<String> fragment, String chosenBackend, String treeShape, List<  
        builder.field("chosen_backend", chosenBackend != null ? chosenBackend : "unknown");
 * @param stageId              stage identifier from the DAG  
        }  
        if (treeShape != null) builder.field("tree_shape", treeShape);
        for (TaskProfile t : tasks) {
        if (fragment != null && fragment.isEmpty() == false) {
 * @param startMs              wall-clock millis from {@code StageMetrics.recordStart()}, 0 if never started
 *                             {@code null} when the stage has no delegation-bearing instruction (omitted from JSON).
        if (endMs > 0) builder.field("end_ms", endMs);
        builder.endObject();
        builder.field("elapsed_ms", elapsedMs);  
 * @param fragment             Calcite {@code RelOptUtil.toString(stage.getFragment())} rendered as an
 * @param tasksFailed          counter from {@code StageMetrics.incrementTasksFailed}  
 * @param state                terminal {@code StageExecution.State}  
