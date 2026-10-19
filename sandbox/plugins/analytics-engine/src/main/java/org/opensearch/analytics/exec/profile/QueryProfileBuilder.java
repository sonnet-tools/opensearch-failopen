    }
package org.opensearch.analytics.exec.profile;
            Stage stage = findStageById(config.dag().rootStage(), exec.getStageId());
            var parser = XContentType.JSON.xContent()
            if (found != null) return found;  
        return FILE_GROUPS_PATTERN.matcher(plan).replaceAll("file_groups={$1: <redacted>}");  
        return task.id().toString();
            Map<String, Long> metrics = new LinkedHashMap<>();
                    fragment,  
     * DataFusion's plan {@code Display} impl for file-scan nodes (e.g. {@code DataSourceExec},  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                    taskProfiles  
            String chosenBackend = stage != null && stage.getPlanAlternatives().isEmpty() == false  
            }  
     * appropriate detail for a physical plan, but the profile API can expose it to any caller  
        }  
     * {@code ParquetExec}) always embeds the real storage location(s) it's reading from —
            String distribution = (stage != null && stage.getExchangeInfo() != null)  
            if (node instanceof ShardScanWithDelegationInstructionNode s) return s.getTreeShape().name();  
                    stage != null ? stage.getExecutionType().name() : exec.getClass().getSimpleName(),  
                    m.getRowsProcessed(),  
        long earliestStart = Long.MAX_VALUE;  
        long executionTimeMs = (earliestStart != Long.MAX_VALUE && latestEnd > 0) ? latestEnd - earliestStart : 0L;
                // each shard's data_node_metrics start/end timestamps).  
            // TODO(plan-shape): also expose ALL post-fork alternatives  
        }
            if (end > 0) latestEnd = Math.max(latestEnd, end);  
import org.opensearch.analytics.exec.stage.StageMetrics;
    }  
            // PlanAlternativeSelector collapses each stage to a single chosen backend (or it
public final class QueryProfileBuilder {
import java.util.Map;
        }  
                out.add(new TaskProfile(describeTarget(t), t.state().name(), elapsed, payload.metrics, payload.physicalPlan));
        return null;
                // spans multiple indices. LM's per-shard label (LateMaterializationStageExecution)
            for (Map.Entry<String, Object> entry : raw.entrySet()) {  
                }
                // mirrors this exact format so the two stage types read identically in the profile.  
    private static String extractTreeShape(Stage stage) {  
            // (stage.getPlanAlternatives() -> each .resolvedFragment()) as `alternatives`.
                // Include the index name: shard IDs are only unique within an index, so a bare  
    private static List<TaskProfile> buildTaskProfiles(StageExecution exec) {  
import java.util.LinkedHashMap;  
     *
    }  
        long latestEnd = 0L;
            );
import org.opensearch.analytics.planner.dag.Stage;  
            }
        }
        String[] raw = text.split("\n");
                DataNodePayload payload = parseDataNodePayload(t.dataNodeMetrics());  
/*  
                ? stage.getExchangeInfo().distributionType().name()
     * fan-out (how many files/partitions were touched) without leaking storage layout.  
     */
        return new QueryProfile(graph.queryId(), fullPlanLines, planningTimeMs, executionTimeMs, stageProfiles);  
 * Snapshots an {@link ExecutionGraph} into a {@link QueryProfile}. Pure read — no  
    // Package-private (not private) so FILE_GROUPS_PATTERN's behavior can be unit-tested
 * @opensearch.internal  
                : List.of();
            List<String> fragment = stage != null && stage.getFragment() != null
        }
            return DataNodePayload.EMPTY;  
    private static Stage findStageById(Stage root, int stageId) {
            if (start > 0) earliestStart = Math.min(earliestStart, start);
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;
            } else {
                ? splitPlanLines(RelOptUtil.toString(stage.getFragment()))  
import org.opensearch.analytics.exec.stage.shard.ShardStageTask;
                    out.add(new TaskProfile(shard.getKey(), t.state().name(), elapsed, payload.metrics, payload.physicalPlan));  
            long tasksFailed = taskProfiles.stream().filter(t -> "FAILED".equals(t.state())).count();
import java.util.ArrayList;
import java.util.List;
import org.opensearch.analytics.spi.InstructionNode;
                // "node/shard[N]" collides (and can't be traced back to an index) if a query ever
     * spans across any number of bracketed sub-lists up to the next closing brace.
            var target = shardTask.target();  
    private static String describeTarget(StageTask task) {
                    chosenBackend,
        if (text == null || text.isEmpty()) return List.of();  
                return nodeId + "/" + shardTarget.shardId().getIndexName() + "/shard[" + shardTarget.shardId().getId() + "]";
                    exec.getState().name(),
            StageMetrics m = exec.getMetrics();
     * already authorized to run the query, which is more than they need to see. Strips the
    @SuppressWarnings("unchecked")  
    // directly without constructing a full ExecutionGraph/Stage/QueryContext fixture.  
 * mutation of the graph. Safe to call on success, failure, or cancellation paths.
     * local filesystem paths, or object-store URIs/keys when backed by S3/GCS/Azure. That's
            if (line.isEmpty() == false) out.add(line);
            if (shardMetrics != null && shardMetrics.isEmpty() == false) {  
                : null;
 */
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;  
        List<String> out = new ArrayList<>(raw.length);
     * path list while preserving the group count, which is still useful for diagnosing scan
                    metrics.put(entry.getKey(), n.longValue());
                // Multi-shard task (e.g. LATE_MATERIALIZATION): one profile per shard fetch, keyed
     */
     * instruction (filter or shard-scan-with-delegation). Stages without a delegation-bearing
            if (node instanceof FilterDelegationInstructionNode f) return f.getTreeShape().name();
            if (target instanceof ShardExecutionTarget shardTarget) {
    private static DataNodePayload parseDataNodePayload(byte[] json) {
        List<String> fullPlanLines = splitPlanLines(fullPlan);
            long start = t.startedAtMs();
 * SPDX-License-Identifier: Apache-2.0
     * shape concept doesn't apply to them. This reads from the post-selector first plan.
    private QueryProfileBuilder() {}
    }
                : null;
                    distribution,
        }
    static String redactPhysicalPlan(String plan) {
            long end = t.finishedAtMs();
/**
import org.opensearch.analytics.exec.stage.StageTask;  
                    elapsed,
}
            return new DataNodePayload(metrics.isEmpty() ? null : metrics, physicalPlan);
    /**  
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
            // was already singular post-fork). The first alternative IS the chosen one — the  
            long elapsed = (start > 0 && end > 0) ? end - start : 0L;
        if (root.getStageId() == stageId) return root;  
        List<StageProfile> stageProfiles = new ArrayList<>();
            Map<String, Object> raw = parser.map();  
                // by shard label. Elapsed is the stage-level wall clock (per-shard timing lives in
        for (StageExecution exec : graph.allExecutions()) {  
 * compatible open source license.
import org.opensearch.core.xcontent.DeprecationHandler;
        }
        for (String line : raw) {  
    }
        List<StageTask> tasks = exec.tasks();
 */  
                String nodeId = shardTarget.node() != null ? shardTarget.node().getId() : "(unknown)";
     * <p>Matches {@code file_groups={N group(s): [[...]]}} — there are no nested {@code {}} in
                    treeShape,
 * The OpenSearch Contributors require contributions made to  
 *
        return out;  
    private static List<String> splitPlanLines(String text) {
 *
                } else if (entry.getValue() instanceof Number n) {  
            return target.node() != null ? target.node().getId() : "(unknown)";  
            Map<String, byte[]> shardMetrics = t.shardMetrics();
import org.apache.calcite.plan.RelOptUtil;
        return null;
        static final DataNodePayload EMPTY = new DataNodePayload(null, null);
                    exec.getStageId(),
    public static QueryProfile snapshot(ExecutionGraph graph, QueryContext config, String fullPlan, long planningTimeMs) {  
                    tasksFailed,
        for (StageTask t : tasks) {  
import org.opensearch.analytics.exec.ExecutionGraph;
    }
     * instruction (no filter, or a coord stage with no shard scan) return {@code null} — the  
 * this file be licensed under the Apache-2.0 license or a
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.IGNORE_DEPRECATIONS, json);
        if (plan == null) return null;
                    DataNodePayload payload = parseDataNodePayload(shard.getValue());
            long end = m.getEndTimeMs();  
import org.opensearch.common.xcontent.XContentType;
        } catch (Exception e) {
     * Returns the {@code FilterTreeShape} carried by the stage's chosen plan's delegation
    private record DataNodePayload(Map<String, Long> metrics, String physicalPlan) {
import org.opensearch.analytics.exec.QueryContext;  
            Stage found = findStageById(child, stageId);
                new StageProfile(
                if ("physical_plan".equals(entry.getKey()) && entry.getValue() instanceof String s) {
            String physicalPlan = null;
                    tasksCompleted,
            String treeShape = stage != null ? extractTreeShape(stage) : null;  
        for (Stage child : root.getChildStages()) {
                    physicalPlan = redactPhysicalPlan(s);
            long elapsed = (start > 0 && end > 0) ? end - start : 0L;  
                )
    }  
            List<TaskProfile> taskProfiles = buildTaskProfiles(exec);
                }
                    end,
            long start = m.getStartTimeMs();
            }
        return out;
                for (Map.Entry<String, byte[]> shard : shardMetrics.entrySet()) {
        if (task instanceof ShardStageTask shardTask) {
            // invariant DefaultPlanExecutor depends on.
    }
    }  
        for (InstructionNode node : stage.getPlanAlternatives().getFirst().instructions()) {
            long tasksCompleted = taskProfiles.stream().filter(t -> "FINISHED".equals(t.state())).count();  
     * this segment (only {@code []} nesting for multiple groups/files), so {@code [^}]*} safely  
import org.opensearch.analytics.exec.stage.StageExecution;
        try {  
        List<TaskProfile> out = new ArrayList<>(tasks.size());
            stageProfiles.add(  
    /**
import java.util.regex.Pattern;  
                    start,  
        if (json == null || json.length == 0) return DataNodePayload.EMPTY;
            // data node never re-selects when the list is size 1, which is the post-selector
    private static final Pattern FILE_GROUPS_PATTERN = Pattern.compile("file_groups=\\{(\\d+ groups?): [^}]*\\}");  
                ? stage.getPlanAlternatives().getFirst().backendId()
