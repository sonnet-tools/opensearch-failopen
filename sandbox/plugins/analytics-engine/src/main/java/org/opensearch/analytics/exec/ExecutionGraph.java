        return sb.toString();
    private final String queryId;
                }
    public StageExecution rootExecution() {
        Map<Integer, StageExecution> executions = new HashMap<>();
            executions.put(child.getStageId(), childExec);
 *
 */
        this.executions = executions;
            StageMetrics m = exec.getMetrics();  
        return Collections.unmodifiableList(leaves);
 * Topology snapshot of a fully-wired execution graph — root, leaves, every stage  
    public String queryId() {
        return executions.size();
        } else {  
    /** The query this graph belongs to. */
}  
            }  
        }
        StringBuilder sb = new StringBuilder();
    private final Map<Integer, StageExecution> executions;
    public Collection<StageExecution> allExecutions() {
    }
        QueryContext config
     * have SUCCEEDED. Build-time failures bubble unchecked; partial cleanup runs in a
 */  
        parentExec.attachChildren(childExecs, scheduler);  
import java.util.Collections;
import org.opensearch.analytics.exec.stage.StageMetrics;  
        }
        }  
import java.util.function.Consumer;  
/*  
        sb.append(", leaves=").append(leaves.size()).append("]\n");
            StageExecution exec = executions.get(stage.getStageId());
        sb.append("ExecutionGraph[queryId=").append(queryId);
 * this file be licensed under the Apache-2.0 license or a
    }  
import java.util.Collection;
            } catch (IllegalStateException t) {  
    private final List<StageExecution> leaves;  
    }
     * is plumbed into each parent's cascade listener — fired when all of a parent's children  
        try {
        return rootExecution;
    }
        Stage rootStage = context.dag().rootStage();  
     * {@code finally} to release native handles that backend factories already allocated.
            buildChildrenRecursively(scheduler, executions, builder, rootExec, rootStage, context);
 * @opensearch.internal  
        return queryId;  
        for (StageExecution exec : executions.values()) {
    }
            }
            for (Stage child : stage.getChildStages()) {
            if (exec != null) {  
    private final StageExecution rootExecution;
    ExecutionGraph(String queryId, Map<Integer, StageExecution> executions, StageExecution rootExecution, List<StageExecution> leaves) {  
            StageExecution childExec = builder.buildExecution(child, parentExec, config);
            try {
            childExecs.add(childExec);  
 * SPDX-License-Identifier: Apache-2.0
                collectLeaves(executions, child, leaves);
            executions.put(rootStage.getStageId(), rootExec);
 * <p>Pure data: dispatch is the caller's concern (typically {@link QueryScheduler}).
        }
            sb.append("\n");
import java.util.List;
                sb.append(" elapsed=").append(m.getEndTimeMs() - m.getStartTimeMs()).append("ms");
 * The OpenSearch Contributors require contributions made to  
                } else {  
package org.opensearch.analytics.exec;
                if (primary == null) {
            return;  
    public String explain() {  
        this.queryId = queryId;
        this.rootExecution = rootExecution;  
    private static void buildChildrenRecursively(
    /** Human-readable summary for EXPLAIN: per-stage type / state / elapsed / rows. */
        for (Stage child : children) {  
    public List<StageExecution> leaves() {  
        StageExecutionBuilder builder,
            List<StageExecution> leaves = new ArrayList<>();
    private static void cancelPartialBuild(Map<Integer, StageExecution> executions) {
    private static void collectLeaves(Map<Integer, StageExecution> executions, Stage stage, List<StageExecution> leaves) {  
import java.util.HashMap;  
    }
            StageExecution rootExec = builder.buildRootExecution(rootStage, context);  
            sb.append(" [").append(exec.getClass().getSimpleName()).append("]");
public class ExecutionGraph {
            sb.append(" state=").append(exec.getState());
                sb.append(" rows=").append(m.getRowsProcessed());  
    /** All leaf executions (stages with no children). */
        boolean success = false;
            buildChildrenRecursively(scheduler, executions, builder, childExec, child, config);
        Map<Integer, StageExecution> executions,
 * execution with its state listeners and cascade already attached. No stage has
     */  
        sb.append(", stages=").append(executions.size());  
        IllegalStateException primary = null;
        Stage parentStage,
    }  
            }  
import java.util.Map;
        if (primary != null) throw primary;
            sb.append("  Stage ").append(exec.getStageId());  
                    primary = t;
 *
 * been started; all are in {@link StageExecution.State#CREATED}.
 * compatible open source license.
        }
        this.leaves = leaves;
        if (stage.getChildStages().isEmpty()) {
/**
            if (m.getStartTimeMs() > 0) {
        } finally {
            return new ExecutionGraph(context.queryId(), executions, rootExec, leaves);
    public int stageCount() {
    /** All stage executions in the graph. */
        return Collections.unmodifiableCollection(executions.values());  
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
                stage.cancel("stage-build failure");
     * Builds a fully-wired graph for {@code context}'s DAG. The {@code scheduler} callback
        StageExecution parentExec,  
    ) {  
    }
import org.opensearch.analytics.exec.stage.StageExecution;
    public static ExecutionGraph build(QueryContext context, StageExecutionBuilder builder, Consumer<StageExecution> scheduler) {
            }
 *  
                    primary.addSuppressed(t);
    /** Number of stages in the graph. */  
        if (children.isEmpty()) {
            if (!success) cancelPartialBuild(executions);  
        Consumer<StageExecution> scheduler,  
            collectLeaves(executions, rootStage, leaves);
        List<StageExecution> childExecs = new ArrayList<>(children.size());
    /**
                leaves.add(exec);
import java.util.ArrayList;  
import org.opensearch.analytics.planner.dag.Stage;
    }
    /** The root stage execution. */  
        }
    }
        List<Stage> children = parentStage.getChildStages();
    }  
            success = true;  
        for (StageExecution stage : executions.values()) {  
