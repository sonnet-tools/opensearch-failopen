/*
        }
        for (InstructionNode node : stage.getPlanAlternatives().getFirst().instructions()) {
import org.apache.calcite.plan.RelOptUtil;
        for (Stage child : root.getChildStages()) {
     */
        if (text == null || text.isEmpty()) return List.of();
        return task.id().toString();
                    chosenBackend,
                    exec.getStageId(),
 * this file be licensed under the Apache-2.0 license or a
     * Returns the {@code FilterTreeShape} carried by the stage's chosen plan's delegation
        for (String line : raw) {
            }
     *
                return nodeId + "/" + shardTarget.shardId().getIndexName() + "/shard[" + shardTarget.shardId().getId() + "]";
        static final DataNodePayload EMPTY = new DataNodePayload(null, null);
import org.opensearch.analytics.exec.stage.StageExecution;
        return out;
     * {@code ParquetExec}) always embeds the real storage location(s) it's reading from —
import org.opensearch.analytics.exec.ExecutionGraph;
            // was already singular post-fork). The first alternative IS the chosen one — the
                if ("physical_plan".equals(entry.getKey()) && entry.getValue() instanceof String s) {
            return new DataNodePayload(metrics.isEmpty() ? null : metrics, physicalPlan);
/**
import java.util.regex.Pattern;
 * @opensearch.internal
    @SuppressWarnings("unchecked")
                    physicalPlan = redactPhysicalPlan(s);
            long end = m.getEndTimeMs();
            long elapsed = (start > 0 && end > 0) ? end - start : 0L;
        if (root.getStageId() == stageId) return root;
    private static List<String> splitPlanLines(String text) {
    }
                    fragment,
                // Include the index name: shard IDs are only unique within an index, so a bare
            String treeShape = stage != null ? extractTreeShape(stage) : null;
            Map<String, Object> raw = parser.map();
}
    }
            for (Map.Entry<String, Object> entry : raw.entrySet()) {
            long tasksCompleted = taskProfiles.stream().filter(t -> "FINISHED".equals(t.state())).count();
        List<String> out = new ArrayList<>(raw.length);
                // by shard label. Elapsed is the stage-level wall clock (per-shard timing lives in
                    DataNodePayload payload = parseDataNodePayload(shard.getValue());
            // data node never re-selects when the list is size 1, which is the post-selector
            List<String> fragment = stage != null && stage.getFragment() != null
            // PlanAlternativeSelector collapses each stage to a single chosen backend (or it
import java.util.Map;
     * path list while preserving the group count, which is still useful for diagnosing scan
            Stage stage = findStageById(config.dag().rootStage(), exec.getStageId());
            if (target instanceof ShardExecutionTarget shardTarget) {
 */
        try {
                ? stage.getPlanAlternatives().getFirst().backendId()
public final class QueryProfileBuilder {
                for (Map.Entry<String, byte[]> shard : shardMetrics.entrySet()) {
        }
            StageMetrics m = exec.getMetrics();
     * instruction (no filter, or a coord stage with no shard scan) return {@code null} — the
import org.opensearch.analytics.exec.stage.shard.ShardStageTask;
package org.opensearch.analytics.exec.profile;
            long elapsed = (start > 0 && end > 0) ? end - start : 0L;
                    elapsed,
        }
     * spans across any number of bracketed sub-lists up to the next closing brace.
    private static Stage findStageById(Stage root, int stageId) {
                } else if (entry.getValue() instanceof Number n) {
import org.opensearch.analytics.exec.stage.StageTask;
            String distribution = (stage != null && stage.getExchangeInfo() != null)
    private static final Pattern FILE_GROUPS_PATTERN = Pattern.compile("file_groups=\\{(\\d+ groups?): [^}]*\\}");
                // Multi-shard task (e.g. LATE_MATERIALIZATION): one profile per shard fetch, keyed
            String chosenBackend = stage != null && stage.getPlanAlternatives().isEmpty() == false
            return DataNodePayload.EMPTY;
import java.util.ArrayList;
                // "node/shard[N]" collides (and can't be traced back to an index) if a query ever
 * The OpenSearch Contributors require contributions made to
            if (line.isEmpty() == false) out.add(line);
        if (plan == null) return null;
import org.opensearch.analytics.exec.stage.StageMetrics;
     * appropriate detail for a physical plan, but the profile API can expose it to any caller
            Stage found = findStageById(child, stageId);
 *
                    m.getRowsProcessed(),
                }
import org.opensearch.core.xcontent.DeprecationHandler;
     * <p>Matches {@code file_groups={N group(s): [[...]]}} — there are no nested {@code {}} in
     */
                    end,
        }
                // mirrors this exact format so the two stage types read identically in the profile.
    private static List<TaskProfile> buildTaskProfiles(StageExecution exec) {
        long earliestStart = Long.MAX_VALUE;
            } else {
            var target = shardTask.target();
import org.opensearch.analytics.exec.QueryContext;
        } catch (Exception e) {
                )
            if (start > 0) earliestStart = Math.min(earliestStart, start);
                : null;
            long start = m.getStartTimeMs();
        String[] raw = text.split("\n");
     * this segment (only {@code []} nesting for multiple groups/files), so {@code [^}]*} safely
            Map<String, Long> metrics = new LinkedHashMap<>();
        List<StageTask> tasks = exec.tasks();
            return target.node() != null ? target.node().getId() : "(unknown)";
        if (json == null || json.length == 0) return DataNodePayload.EMPTY;
    /**
import java.util.LinkedHashMap;
            }
            List<TaskProfile> taskProfiles = buildTaskProfiles(exec);
        for (StageTask t : tasks) {
                    distribution,
        return new QueryProfile(graph.queryId(), fullPlanLines, planningTimeMs, executionTimeMs, stageProfiles);
            long end = t.finishedAtMs();
import org.opensearch.core.xcontent.NamedXContentRegistry;
    static String redactPhysicalPlan(String plan) {
     * DataFusion's plan {@code Display} impl for file-scan nodes (e.g. {@code DataSourceExec},
 * mutation of the graph. Safe to call on success, failure, or cancellation paths.
        for (StageExecution exec : graph.allExecutions()) {
                new StageProfile(
     * already authorized to run the query, which is more than they need to see. Strips the
    }
                    tasksFailed,
 * Snapshots an {@link ExecutionGraph} into a {@link QueryProfile}. Pure read — no
                    tasksCompleted,
                : List.of();
                : null;
            // (stage.getPlanAlternatives() -> each .resolvedFragment()) as `alternatives`.
        List<String> fullPlanLines = splitPlanLines(fullPlan);
import org.opensearch.analytics.spi.ShardScanWithDelegationInstructionNode;
        return null;
            if (node instanceof ShardScanWithDelegationInstructionNode s) return s.getTreeShape().name();
    private static String extractTreeShape(Stage stage) {
        return FILE_GROUPS_PATTERN.matcher(plan).replaceAll("file_groups={$1: <redacted>}");
import org.opensearch.analytics.spi.FilterDelegationInstructionNode;
        if (task instanceof ShardStageTask shardTask) {
    }
     * local filesystem paths, or object-store URIs/keys when backed by S3/GCS/Azure. That's
            var parser = XContentType.JSON.xContent()
        }
            Map<String, byte[]> shardMetrics = t.shardMetrics();
                out.add(new TaskProfile(describeTarget(t), t.state().name(), elapsed, payload.metrics, payload.physicalPlan));
                ? splitPlanLines(RelOptUtil.toString(stage.getFragment()))
    private static DataNodePayload parseDataNodePayload(byte[] json) {
            stageProfiles.add(
            long start = t.startedAtMs();
    public static QueryProfile snapshot(ExecutionGraph graph, QueryContext config, String fullPlan, long planningTimeMs) {
import java.util.List;
                    metrics.put(entry.getKey(), n.longValue());
                // spans multiple indices. LM's per-shard label (LateMaterializationStageExecution)
 * SPDX-License-Identifier: Apache-2.0
            if (end > 0) latestEnd = Math.max(latestEnd, end);
    private record DataNodePayload(Map<String, Long> metrics, String physicalPlan) {
        }
 * compatible open source license.
    // Package-private (not private) so FILE_GROUPS_PATTERN's behavior can be unit-tested
 */
        long latestEnd = 0L;
                String nodeId = shardTarget.node() != null ? shardTarget.node().getId() : "(unknown)";
                // each shard's data_node_metrics start/end timestamps).
                }
                    exec.getState().name(),
    }
    }
        }
                    out.add(new TaskProfile(shard.getKey(), t.state().name(), elapsed, payload.metrics, payload.physicalPlan));
            // invariant DefaultPlanExecutor depends on.
    private static String describeTarget(StageTask task) {
import org.opensearch.common.xcontent.XContentType;
                    stage != null ? stage.getExecutionType().name() : exec.getClass().getSimpleName(),
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.IGNORE_DEPRECATIONS, json);
                    taskProfiles
    }
            String physicalPlan = null;
        List<TaskProfile> out = new ArrayList<>(tasks.size());
                DataNodePayload payload = parseDataNodePayload(t.dataNodeMetrics());
    private QueryProfileBuilder() {}
        List<StageProfile> stageProfiles = new ArrayList<>();
                ? stage.getExchangeInfo().distributionType().name()
     * shape concept doesn't apply to them. This reads from the post-selector first plan.
        long executionTimeMs = (earliestStart != Long.MAX_VALUE && latestEnd > 0) ? latestEnd - earliestStart : 0L;
            long tasksFailed = taskProfiles.stream().filter(t -> "FAILED".equals(t.state())).count();
            // TODO(plan-shape): also expose ALL post-fork alternatives
import org.opensearch.analytics.planner.dag.Stage;
                    start,
     * fan-out (how many files/partitions were touched) without leaking storage layout.
            if (found != null) return found;
            if (node instanceof FilterDelegationInstructionNode f) return f.getTreeShape().name();
    }
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;
            }
     * instruction (filter or shard-scan-with-delegation). Stages without a delegation-bearing
                    treeShape,
            if (shardMetrics != null && shardMetrics.isEmpty() == false) {
        return out;
            );
    // directly without constructing a full ExecutionGraph/Stage/QueryContext fixture.
 *
        return null;
    }
import org.opensearch.analytics.spi.InstructionNode;
    /**
