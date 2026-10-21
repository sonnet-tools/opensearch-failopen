        public void onQueryComplete(String queryId, long totalTookInNanos, long totalRows) {
                }
     * subsequent delegates from being notified.
 *
                } catch (Exception e) {
    /**
     * Called when a stage transitions to CANCELLED.
 * Listener for analytics query execution lifecycle events. Analogous to
        private static final Logger logger = LogManager.getLogger(CompositeListener.class);
        }
                }
                try {
                }
            }
    /**
                    l.onQueryComplete(queryId, totalTookInNanos, totalRows);
        }
     * Called when an analytics query fails.
        @Override
                }
    /**
 */
     * Called when an analytics query completes successfully.
     */
                }
 * override only the events they care about.
    default void onStageStart(String queryId, int stageId, String stageType) {}
 * </ul>
                    warn("onStageFailure", e);
 * {@link org.opensearch.index.shard.SearchOperationListener} but designed
            for (AnalyticsOperationListener l : delegates) {
     */
                    warn("onQueryFailure", e);
                }
 *
            for (AnalyticsOperationListener l : delegates) {
                try {
     *
                } catch (Exception e) {
import org.apache.logging.log4j.Logger;
     * @param stats execution stats including rows produced, delegation info, and task headers
     * Multiplexing composite that fans out each callback to a list of
     * @param queryId the query this stage belongs to
        public void onFragmentFailure(String queryId, int stageId, String shardId, Exception cause) {
     */
            for (AnalyticsOperationListener l : delegates) {
     * @param stageType the stage execution class name
                    warn("onStageSuccess", e);
        }
                } catch (Exception e) {
                }
                    warn("onPreFragmentExecution", e);
     * @param stageId the stage this fragment belongs to
                    l.onQueryStart(queryId, stageCount);
import org.apache.logging.log4j.LogManager;
                    l.onStageFailure(queryId, stageId, cause);
     * @param queryId the unique query identifier
    /**
     * @param stageId the stage identifier
            for (AnalyticsOperationListener l : delegates) {
import org.opensearch.index.IndexSettings;
     * @param reason the cancellation reason
     *
 * <p>Covers two scopes:
     * @param tookInNanos wall-clock time for the planning phase
        }
                    l.onPlanningComplete(queryId, tookInNanos);
                    l.onStageSuccess(queryId, stageId, stageType, tookInNanos, rowsProcessed);
    /**
}
        public void onStageFailure(String queryId, int stageId, Exception cause) {
    /**
    default void onQueryFailure(String queryId, Exception cause) {}
     *
     * @param stageId the stage this fragment belongs to
     *
                } catch (Exception e) {
                try {
     * @param queryId the query this stage belongs to
        }
     * @param queryId the query this fragment belongs to
                try {
    /**
            for (AnalyticsOperationListener l : delegates) {
            }
        FragmentExecutionStats stats
     *
        @Override
     * delegates. Exception-safe — a failing delegate does not prevent
    /**
                } catch (Exception e) {
                    warn("onPlanningComplete", e);
        }
 * compatible open source license.
    default void onStageCancelled(String queryId, int stageId, String reason) {}
    default void onFragmentFailure(String queryId, int stageId, String shardId, Exception cause) {}
     *
     * @param tookInNanos wall-clock time from stage start to completion
     * @param queryId the unique query identifier
     * @param cause the exception that caused the failure
            this.delegates = delegates;
        @Override
        public void onFragmentSuccess(
        IndexSettings indexSettings,
        }
                    l.onFragmentSuccess(queryId, stageId, shardId, tookInNanos, indexSettings, stats);
        ) {
                try {
        public void onPreFragmentExecution(String queryId, int stageId, String shardId) {
        public void onQueryStart(String queryId, int stageCount) {
            for (AnalyticsOperationListener l : delegates) {
     * Called when a stage transitions to FAILED.
            }
     * @param stageId the stage identifier
        }
     * @param queryId the query this stage belongs to
            for (AnalyticsOperationListener l : delegates) {
            }
        }
        @Override
    // ─── Coordinator-side: stage lifecycle ──────────────────────────────
public interface AnalyticsOperationListener {
                } catch (Exception e) {
 *       success, failure) fired by {@code AnalyticsSearchService}.</li>
     */
        public void onStageStart(String queryId, int stageId, String stageType) {
                }
                try {
                    l.onQueryFailure(queryId, cause);
                } catch (Exception e) {
                try {
        }
     * @param cause the exception that caused the failure
        public void onStageCancelled(String queryId, int stageId, String reason) {
        public void onQueryFailure(String queryId, Exception cause) {
     * @param shardId the shard that was queried
     * @param stageId the stage identifier
    /**
                    warn("onStageCancelled", e);
     * This is the terminal event for the full request lifecycle — analogous to
 * SPDX-License-Identifier: Apache-2.0
    }
     * @param shardId the shard being queried
    // ─── Data-node-side: fragment execution ─────────────────────────────
 * @opensearch.internal
 * <p>All methods have empty default implementations so listeners can
                try {
     * Called when a stage transitions to RUNNING.
    default void onStageSuccess(String queryId, int stageId, String stageType, long tookInNanos, long rowsProcessed) {}
        }
     * @param indexSettings the index settings for per-index slow log threshold lookup
     * @param totalRows total rows in the materialized result set
                    warn("onStageStart", e);
        @Override
            String queryId,
     */
     * @param queryId the query this fragment belongs to
     *
    default void onQueryStart(String queryId, int stageCount) {}
                }
                    warn("onFragmentFailure", e);
/*
     * @param queryId the query this fragment belongs to
                    l.onFragmentFailure(queryId, stageId, shardId, cause);
 *
            }
     * Called before a plan fragment is executed on a data node.
     * Called when query planning completes on the coordinator (Calcite CBO, DAG build,
        @Override
            }
        public void onPlanningComplete(String queryId, long tookInNanos) {
        String queryId,
 * for the stage-based analytics execution model.
     * Called when a plan fragment fails on a data node.
                    warn("onQuerySuccess", e);
            for (AnalyticsOperationListener l : delegates) {
                try {
                try {
     * @param stageId the stage this fragment belongs to
    default void onStageFailure(String queryId, int stageId, Exception cause) {}
     */
     */
            FragmentExecutionStats stats
        }
 *       failure, cancellation) fired by the stage execution layer.</li>
 *   <li><b>Data-node-side:</b> fragment execution events (pre-execute,
    ) {}
        String shardId,
                    warn("onQueryStart", e);
            }
        public void onQuerySuccess(String queryId, long tookInNanos, long totalRows) {
                    l.onQuerySuccess(queryId, tookInNanos, totalRows);
                } catch (Exception e) {
     * Called after a plan fragment executes successfully on a data node.
            for (AnalyticsOperationListener l : delegates) {
     */
     * @param totalTookInNanos wall-clock time from query submission to completion (includes planning + execution + materialization)
                try {
        private final List<AnalyticsOperationListener> delegates;
     * @param queryId the unique query identifier
import java.util.List;
 * The OpenSearch Contributors require contributions made to
                    l.onStageStart(queryId, stageId, stageType);
                } catch (Exception e) {
        long tookInNanos,
    default void onPlanningComplete(String queryId, long tookInNanos) {}
        }
 *   <li><b>Coordinator-side:</b> stage lifecycle events (start, success,
                }
        @Override
                }
    /**
    default void onQueryComplete(String queryId, long totalTookInNanos, long totalRows) {}
     */
            }
            }
package org.opensearch.analytics.backend;
    /**
     *
                } catch (Exception e) {
            long tookInNanos,
                    warn("onFragmentSuccess", e);
                    l.onPreFragmentExecution(queryId, stageId, shardId);
                    l.onStageCancelled(queryId, stageId, reason);
                try {
            for (AnalyticsOperationListener l : delegates) {
            int stageId,
    // ─── Coordinator-side: query lifecycle ──────────────────────────────
        public void onStageSuccess(String queryId, int stageId, String stageType, long tookInNanos, long rowsProcessed) {
     */
 *
    default void onFragmentSuccess(
     * @param shardId the shard that was queried
            IndexSettings indexSettings,
 */
        @Override
    class CompositeListener implements AnalyticsOperationListener {
 * this file be licensed under the Apache-2.0 license or a
     * @param rowsProcessed number of rows processed by this stage
                    warn("onQueryComplete", e);
        @Override
     * @param cause the exception that caused the failure
     * @param stageId the stage identifier
     * {@code SearchRequestOperationsListener.onRequestEnd()} in the default search path.
            String shardId,
     * Called when the entire query request completes, including result materialization.
 * <ul>
     *
     *
        }
            }
     * @param tookInNanos wall-clock time for the fragment execution
    /**
        @Override
     */
            }
            logger.warn("[AnalyticsOperationListener.CompositeListener] {} threw {}", method, e);
     * Called when a stage transitions to SUCCEEDED.
     * @param totalRows total rows in the result set
    default void onPreFragmentExecution(String queryId, int stageId, String shardId) {}
    /**
        public CompositeListener(List<AnalyticsOperationListener> delegates) {
     * @param tookInNanos wall-clock time from query start to completion
    default void onQuerySuccess(String queryId, long tookInNanos, long totalRows) {}
     * fragment conversion). Fired before execution stages begin.
     * @param queryId the query this stage belongs to
/**
            for (AnalyticsOperationListener l : delegates) {
     */
            }
     */
        @Override
     * @param queryId the unique query identifier
                }
     * @param queryId the unique query identifier
     * @param stageCount the number of stages in the execution graph
     *
     *
                } catch (Exception e) {
        @Override
            for (AnalyticsOperationListener l : delegates) {
     * Called when a new analytics query starts execution on the coordinator.
                } catch (Exception e) {
        private void warn(String method, Exception e) {
        int stageId,
