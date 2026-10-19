        for (RelNode input : root.getInputs()) {
 * SPDX-License-Identifier: Apache-2.0
        return false;
/**  
        return null;
        return containsJoinRecursive(rootStage);
    }  
    HASH_SHUFFLE_AGG;
        }
 * {@link MppStrategyMetrics} + {@code GET /_analytics/_strategies} endpoint expose. Under the general
        for (Stage child : stage.getChildStages()) {
        if (root == null) return false;
        if (stage.getFragment() != null && RelNodeUtils.findNode(stage.getFragment(), OpenSearchJoin.class) != null) {  
     *  when the size floor keeps a join/aggregate coordinator-centric. */
 *
        return false;  
}
    }
    public static boolean containsJoin(QueryDAG dag) {  
    BROADCAST,  
            return false;  
    /** Locates the {@link Stage.StageRole#BROADCAST_BUILD} stage anywhere in {@code dag}, or {@code null}. */
    public static boolean containsFinalAggregate(QueryDAG dag) {
import org.opensearch.analytics.planner.RelNodeUtils;
public enum MppStrategy {
        Stage rootStage = dag.rootStage();
            if (containsJoinRecursive(child)) return true;
    /** Hash-shuffle aggregate: a distributed aggregate split into PARTIAL (per-partition, on the worker)
import org.opensearch.analytics.planner.dag.QueryDAG;  
    /** Both sides reduced to coordinator (SINGLETON), join runs there. Safe default — also the fallback
        for (Stage child : stage.getChildStages()) {  
 * compatible open source license.
 * @opensearch.internal  
    }  
    }
    /** True iff any stage fragment in {@code dag} contains a {@code FINAL}-mode {@link OpenSearchAggregate}. */  
import org.opensearch.analytics.planner.dag.Stage;
        if (rootStage == null || rootStage.getFragment() == null) {
        return false;
            return true;
    private static Stage findStageByRole(Stage stage, Stage.StageRole role) {
 * Strategy for distributed join + aggregate execution, surfaced as the per-dispatch counter the
        }
    }  
 */
            if (found != null) return found;  
    /** True iff any stage fragment in {@code dag} contains an {@link OpenSearchJoin}. */
        if (root instanceof OpenSearchAggregate agg && agg.getMode() == AggregateMode.FINAL) return true;  
        if (stage.getRole() == role) return stage;  
 */  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
    private static boolean containsJoinRecursive(Stage stage) {
    }
import org.opensearch.analytics.planner.rel.AggregateMode;
import org.apache.calcite.rel.RelNode;
 * The OpenSearch Contributors require contributions made to  
        for (Stage child : stage.getChildStages()) {
        }
 *
 * this file be licensed under the Apache-2.0 license or a
        }  
    /** Both sides hash-partitioned by join key and shuffled to a worker tier. */
        if (containsFinalAggregateInFragment(stage.getFragment())) return true;  
        }  
    COORDINATOR_CENTRIC,  
        return dag != null && dag.rootStage() != null && containsFinalAggregateRecursive(dag.rootStage());
        }
    HASH_SHUFFLE,  
 *
    // ── Read-only DAG-shape predicates (used by DefaultPlanExecutor to pick the dispatch counter) ──  
        return findStageByRole(root, Stage.StageRole.BROADCAST_BUILD);
    }  
            Stage found = findStageByRole(child, role);
/*  
    private static boolean containsFinalAggregateInFragment(RelNode root) {
 * post-CBO scheduler the coordinator records which path {@link UnifiedDispatch} ran for a query.  
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
package org.opensearch.analytics.exec.join;
    public static Stage findBroadcastBuild(QueryDAG dag) {
 * ({@link #containsJoin} / {@link #containsFinalAggregate} / {@link #findBroadcastBuild}) — relocated here  
 * <p>Also hosts the small read-only DAG-shape predicates the dispatcher uses to pick the counter
            if (containsFinalAggregateRecursive(child)) return true;
        Stage root = dag.rootStage();  
            if (containsFinalAggregateInFragment(input)) return true;
    private static boolean containsFinalAggregateRecursive(Stage stage) {
        if (root == null) return null;
     *  + FINAL (coordinator gather). */  
    /** Small (build) side broadcast to all probe-side data nodes; join runs in parallel on each. */
 * when the enumerated legacy advisors were removed.
