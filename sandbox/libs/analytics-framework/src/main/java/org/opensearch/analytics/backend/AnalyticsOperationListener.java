     * @param cause the exception that caused the failure
     * Called when a new analytics query starts execution on the coordinator.  
        public void onStageFailure(String queryId, int stageId, Exception cause) {
     * @param queryId the query this stage belongs to
        }
            for (AnalyticsOperationListener l : delegates) {
            for (AnalyticsOperationListener l : delegates) {
                    l.onStageStart(queryId, stageId, stageType);
        }
            FragmentExecutionStats stats
                    l.onStageFailure(queryId, stageId, cause);
                    l.onStageCancelled(queryId, stageId, reason);
     * Called when a stage transitions to SUCCEEDED.
 */  
            int stageId,
                    warn("onStageSuccess", e);
        public void onPlanningComplete(String queryId, long tookInNanos) {
     * @param queryId the unique query identifier
                    warn("onStageCancelled", e);  
    /**
        @Override
        @Override  
        private void warn(String method, Exception e) {  
                } catch (Exception e) {
        public void onFragmentFailure(String queryId, int stageId, String shardId, Exception cause) {
     */
        @Override
                } catch (Exception e) {
                try {
    /**
     */  
     * @param queryId the unique query identifier
 *
 * {@link org.opensearch.index.shard.SearchOperationListener} but designed  
     * @param stats execution stats including rows produced, delegation info, and task headers  
     * @param cause the exception that caused the failure
                    warn("onQuerySuccess", e);
 *
                } catch (Exception e) {  
                }  
    default void onStageFailure(String queryId, int stageId, Exception cause) {}  
     * Called after a plan fragment executes successfully on a data node.
                    warn("onPlanningComplete", e);
     */
        public void onStageStart(String queryId, int stageId, String stageType) {
        }  
        @Override
        }
                } catch (Exception e) {  
                    l.onFragmentSuccess(queryId, stageId, shardId, tookInNanos, indexSettings, stats);  
 * this file be licensed under the Apache-2.0 license or a
    /**  
        public CompositeListener(List<AnalyticsOperationListener> delegates) {
    default void onFragmentFailure(String queryId, int stageId, String shardId, Exception cause) {}
     * @param queryId the unique query identifier
                } catch (Exception e) {
    /**
    }  
        @Override
     * @param stageId the stage identifier
     * Called when a plan fragment fails on a data node.  
     * This is the terminal event for the full request lifecycle — analogous to
     * fragment conversion). Fired before execution stages begin.
        public void onQueryFailure(String queryId, Exception cause) {
        @Override
        }  
                    warn("onStageFailure", e);
            for (AnalyticsOperationListener l : delegates) {
     * @param queryId the unique query identifier
import org.apache.logging.log4j.LogManager;
            String queryId,  
                }
                try {
import org.opensearch.index.IndexSettings;  
        ) {  
            logger.warn("[AnalyticsOperationListener.CompositeListener] {} threw {}", method, e);
                } catch (Exception e) {
     * @param rowsProcessed number of rows processed by this stage
                    warn("onQueryComplete", e);  
    default void onQueryStart(String queryId, int stageCount) {}
     * Multiplexing composite that fans out each callback to a list of
            for (AnalyticsOperationListener l : delegates) {
            }
     * @param queryId the query this fragment belongs to
     *  
     * Called before a plan fragment is executed on a data node.
                try {
                    warn("onStageStart", e);  
/**
        }
     * @param indexSettings the index settings for per-index slow log threshold lookup
     * {@code SearchRequestOperationsListener.onRequestEnd()} in the default search path.  
    /**
        }
     *
            }  
     *  
        FragmentExecutionStats stats
     * @param tookInNanos wall-clock time for the planning phase
    default void onStageSuccess(String queryId, int stageId, String stageType, long tookInNanos, long rowsProcessed) {}  
     * @param shardId the shard that was queried
            for (AnalyticsOperationListener l : delegates) {
    default void onPlanningComplete(String queryId, long tookInNanos) {}
        IndexSettings indexSettings,
            }
     * subsequent delegates from being notified.  
     */
    /**
            for (AnalyticsOperationListener l : delegates) {  
     * @param tookInNanos wall-clock time from query start to completion
        @Override
                try {
     */
     * @param shardId the shard being queried  
                    l.onQuerySuccess(queryId, tookInNanos, totalRows);  
            }
        private static final Logger logger = LogManager.getLogger(CompositeListener.class);
        @Override  
     */
package org.opensearch.analytics.backend;
     *
                }  
 * override only the events they care about.  
     * @param queryId the query this fragment belongs to
            for (AnalyticsOperationListener l : delegates) {  
        int stageId,
                    warn("onQueryFailure", e);
     * Called when an analytics query fails.
                }
        public void onPreFragmentExecution(String queryId, int stageId, String shardId) {  
                    warn("onQueryStart", e);
     * Called when a stage transitions to CANCELLED.  
            }  
                try {  
     * @param totalRows total rows in the result set  
    // ─── Data-node-side: fragment execution ─────────────────────────────
            }
     * @param cause the exception that caused the failure
     * @param totalTookInNanos wall-clock time from query submission to completion (includes planning + execution + materialization)  
            long tookInNanos,  
                try {
            this.delegates = delegates;
            }
    // ─── Coordinator-side: query lifecycle ──────────────────────────────  
                }
                try {
        }
 *       failure, cancellation) fired by the stage execution layer.</li>  
 * <p>All methods have empty default implementations so listeners can
        }  
 *       success, failure) fired by {@code AnalyticsSearchService}.</li>
 * for the stage-based analytics execution model.
 * <p>Covers two scopes:  
            for (AnalyticsOperationListener l : delegates) {
    /**
        }
     * @param queryId the query this stage belongs to
     *  
     * @param queryId the unique query identifier
            }
 *
    default void onPreFragmentExecution(String queryId, int stageId, String shardId) {}
 * compatible open source license.
     * Called when an analytics query completes successfully.
 * SPDX-License-Identifier: Apache-2.0
     * @param stageId the stage identifier  
        public void onStageSuccess(String queryId, int stageId, String stageType, long tookInNanos, long rowsProcessed) {  
 *
    ) {}  
            for (AnalyticsOperationListener l : delegates) {  
     *
                }  
            }
     * Called when query planning completes on the coordinator (Calcite CBO, DAG build,
        }
                    l.onFragmentFailure(queryId, stageId, shardId, cause);
    default void onQuerySuccess(String queryId, long tookInNanos, long totalRows) {}
        String shardId,
                    l.onQueryFailure(queryId, cause);
 * The OpenSearch Contributors require contributions made to  
                } catch (Exception e) {  
        }
            }  
     * @param shardId the shard that was queried  
public interface AnalyticsOperationListener {
 *   <li><b>Coordinator-side:</b> stage lifecycle events (start, success,
     * @param stageId the stage identifier
        public void onStageCancelled(String queryId, int stageId, String reason) {
        @Override
                    l.onStageSuccess(queryId, stageId, stageType, tookInNanos, rowsProcessed);  
     * @param stageType the stage execution class name  
 * Listener for analytics query execution lifecycle events. Analogous to
                    l.onPlanningComplete(queryId, tookInNanos);
     * Called when the entire query request completes, including result materialization.
    default void onStageStart(String queryId, int stageId, String stageType) {}
            for (AnalyticsOperationListener l : delegates) {  
            }  
                    l.onQueryComplete(queryId, totalTookInNanos, totalRows);
     *  
     */
    /**
    default void onStageCancelled(String queryId, int stageId, String reason) {}  
            for (AnalyticsOperationListener l : delegates) {
     * @param stageId the stage this fragment belongs to
     */
                } catch (Exception e) {  
        String queryId,  
     */  
}
     *  
                } catch (Exception e) {
                    warn("onFragmentSuccess", e);
            for (AnalyticsOperationListener l : delegates) {
     *  
                try {
            }
     * @param tookInNanos wall-clock time from stage start to completion  
                    warn("onPreFragmentExecution", e);
    /**
     * @param queryId the query this fragment belongs to
                try {  
     * @param queryId the query this stage belongs to
     *  
     * @param stageId the stage this fragment belongs to
                }
    // ─── Coordinator-side: stage lifecycle ──────────────────────────────
        public void onQuerySuccess(String queryId, long tookInNanos, long totalRows) {  
    default void onQueryFailure(String queryId, Exception cause) {}
        public void onQueryComplete(String queryId, long totalTookInNanos, long totalRows) {
     * Called when a stage transitions to RUNNING.
     */  
    default void onFragmentSuccess(
     * @param stageId the stage this fragment belongs to  
     */
                }  
                    l.onQueryStart(queryId, stageCount);  
                    l.onPreFragmentExecution(queryId, stageId, shardId);  
     * @param stageId the stage identifier  
     * @param reason the cancellation reason
     * @param tookInNanos wall-clock time for the fragment execution
    class CompositeListener implements AnalyticsOperationListener {
    /**
     * @param totalRows total rows in the materialized result set
 * @opensearch.internal
     * @param queryId the query this stage belongs to
                try {  
    /**  
 */  
     *
import org.apache.logging.log4j.Logger;
            String shardId,
        long tookInNanos,  
 * </ul>  
        @Override
     * @param stageCount the number of stages in the execution graph  
     */
import java.util.List;
        public void onFragmentSuccess(
    default void onQueryComplete(String queryId, long totalTookInNanos, long totalRows) {}  
                }
/*  
        public void onQueryStart(String queryId, int stageCount) {  
     * delegates. Exception-safe — a failing delegate does not prevent
                    warn("onFragmentFailure", e);
 *   <li><b>Data-node-side:</b> fragment execution events (pre-execute,
                } catch (Exception e) {
     *
        @Override
            IndexSettings indexSettings,
     */
        private final List<AnalyticsOperationListener> delegates;
                } catch (Exception e) {
     * Called when a stage transitions to FAILED.  
        }  
                try {
    /**  
                }
                }
    /**
                try {
                } catch (Exception e) {
        }
                }  
 * <ul>
        @Override  
