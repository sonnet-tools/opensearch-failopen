        List<ExecutionResult> results,
        logPlan(relNode);
                logger.debug("... ({} more rows)", list.size() - preview);  
    }
    /**  
     */
     * @param executor analytics engine executor that runs individual RelNode plans
            if (list.size() > preview) {
            logger.debug("Executing RelNode:\n{}", relNode.explain());
                    java.util.Objects.requireNonNull(relNode.getCluster().getMetadataProvider())
            }
import java.util.Arrays;  
/**  
 * SPDX-License-Identifier: Apache-2.0
     * Executes all plans sequentially and delivers results, in plan order, to the listener.
     *
/*  
            for (int i = 0; i < preview; i++) {
     * completes successfully. The first failure aborts the chain — the listener fires
import org.apache.calcite.rel.RelNode;
            logRows(rows);
    // invalidateMetadataQuery() and THREAD_PROVIDERS are only needed for explain() output
}
    private static final Logger logger = LogManager.getLogger(DslQueryPlanExecutor.class);  
    }
            );  
        ActionListener<List<ExecutionResult>> outer
        List<ExecutionResult> results = new ArrayList<>(queryPlans.size());  
    private void executeNext(
        List<Object[]> list = (rows instanceof List) ? (List<Object[]>) rows : null;  
        QueryPlans.QueryPlan plan = queryPlans.get(index);
     * {@code onFailure} with that error and remaining plans do not run.
            relNode.getCluster().invalidateMetadataQuery();
        executor.execute(relNode, null, ActionListener.wrap(rows -> {  
    ) {  
    private final QueryPlanExecutor<RelNode, Iterable<Object[]>> executor;
            return;  
import org.apache.logging.log4j.Logger;  
        if (list != null) {  
    }
            int preview = Math.min(20, list.size());
            results.add(new ExecutionResult(plan, rows));
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.dsl.executor;
     * <p>Plans run one-at-a-time: plan {@code N+1} is dispatched only after plan {@code N}  
        }, outer::onFailure));
import org.opensearch.dsl.result.ExecutionResult;  
import org.opensearch.analytics.exec.QueryPlanExecutor;
    private static void logRows(Iterable<Object[]> rows) {
        }  
    public void execute(QueryPlans plans, ActionListener<List<ExecutionResult>> listener) {
        List<QueryPlans.QueryPlan> queryPlans,
        }
     *  
 */  
 * Iterates over {@link QueryPlans}, delegates each RelNode to the analytics engine's
    }  
            outer.onResponse(results);
    // TODO: add per-plan error handling so a failure in one plan
        }
            executeNext(queryPlans, index + 1, results, outer);  
            org.apache.calcite.rel.metadata.RelMetadataQueryBase.THREAD_PROVIDERS.set(
import org.apache.logging.log4j.LogManager;
        int count = list != null ? list.size() : -1;
        this.executor = executor;
    /**
        if (logger.isDebugEnabled() == false) return;
        executeNext(queryPlans, 0, results, listener);
        int index,  
     * @param listener receives the ordered list of results on success, or the first failure
     */  
 */  
            }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        // TODO: context param is null, may carry execution hints
        if (logger.isDebugEnabled()) {
     * @param plans    the query plans to execute
     *  
        RelNode relNode = plan.relNode();  
    private void logPlan(RelNode relNode) {  
 *
import java.util.ArrayList;
    public DslQueryPlanExecutor(QueryPlanExecutor<RelNode, Iterable<Object[]>> executor) {  
public class DslQueryPlanExecutor {
                logger.debug("row[{}]={}", i, Arrays.toString(list.get(i)));  
                org.apache.calcite.rel.metadata.JaninoRelMetadataProvider.of(  
import java.util.List;
    }
        if (index >= queryPlans.size()) {
                )
 * {@link QueryPlanExecutor}, and collects results.
     * Creates an executor backed by the given analytics engine plan executor.
    // doesn't prevent returning partial results from other plans (e.g. HITS)
        logger.debug("Query result rowCount={}", count);
        List<QueryPlans.QueryPlan> queryPlans = plans.getAll();
import org.opensearch.core.action.ActionListener;
