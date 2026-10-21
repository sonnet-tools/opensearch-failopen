            logAtLevel(sb.toString(), totalTookInNanos);
 * compatible open source license.
        this.debugThreshold = clusterService.getClusterSettings()
import org.opensearch.cluster.service.ClusterService;
            .addSettingsUpdateConsumer(
    private volatile long traceThreshold;
            this.opaqueId = opaqueId;
        @Override
package org.opensearch.analytics.exec;
        clusterService.getClusterSettings().addSettingsUpdateConsumer(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL, l -> {
            .nanos();
    private void logAtLevel(String message, long tookInNanos) {
            );
/*
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING,
    private volatile SlowLogLevel level;
            sb.append("planning_time_millis[").append(planningTimeMs).append("], ");
        this.infoThreshold = clusterService.getClusterSettings()
        });
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING,
            .addSettingsUpdateConsumer(
    private volatile long infoThreshold;
            this.level = l;
        clusterService.getClusterSettings()
        void setHeaders(String opaqueId, String requestId) {
        public void onPlanningComplete(String queryId, long tookInNanos) {
        }
            .nanos();
 * The OpenSearch Contributors require contributions made to
        } else if (traceThreshold >= 0 && tookInNanos > traceThreshold && level.isLevelEnabledFor(SlowLogLevel.TRACE)) {
 * <p>{@link #createQueryListener(String)} creates a per-query listener that observes the
            queryLogger.warn(message);
 * <p>Reuses the existing {@code cluster.search.request.slowlog.*} settings so operators
import org.opensearch.common.logging.SlowLogLevel;
     */
        clusterService.getClusterSettings()
        }
        public void onQueryComplete(String queryId, long totalTookInNanos, long totalRows) {
import org.opensearch.action.search.SearchRequestSlowLog;
        private volatile String requestId;
    }
 * Coordinator-level slow log for analytics engine queries. Logs at {@code onQueryComplete}
            .get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING)
    private volatile long warnThreshold;
            queryLogger.trace(message);
     * before planning starts so it can capture planning time, stage timing, and emit the
    }
import org.apache.logging.log4j.Logger;
import org.opensearch.common.unit.TimeValue;
 * have a single configuration surface for both standard and analytics search paths.
     * then emits the complete slow log entry at {@code onQueryComplete}.
 * this file be licensed under the Apache-2.0 license or a
        QuerySlowLogListener(String querySource) {
    class QuerySlowLogListener implements AnalyticsOperationListener {
    private volatile long debugThreshold;
     */
        this.traceThreshold = clusterService.getClusterSettings()
            );
     * Creates a per-query listener that observes the full query lifecycle. Must be created
        } else if (infoThreshold >= 0 && tookInNanos > infoThreshold && level.isLevelEnabledFor(SlowLogLevel.INFO)) {
import org.opensearch.analytics.backend.AnalyticsOperationListener;
                t -> traceThreshold = t.nanos()
     * Per-query listener that accumulates planning time, stage timing, and task headers,
        private long planningTimeMs;
    /**
            sb.append("total_rows[").append(totalRows).append("], ");
 * — the terminal event fired after planning, execution, and materialization are all done.
            sb.append("id[").append(opaqueId != null ? opaqueId : "").append("], ");
            );
        }
 * full query lifecycle — planning, stage execution, and completion — accumulating timing
        if (warnThreshold >= 0 && tookInNanos > warnThreshold && level.isLevelEnabledFor(SlowLogLevel.WARN)) {
 */
 *
 * data and emitting the slow log entry at {@code onQueryComplete}.
    public QuerySlowLogListener createQueryListener(String querySource) {
            .get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING)
    }
        clusterService.getClusterSettings()
            Loggers.setLevel(queryLogger, l.name());
    }
    public AnalyticsSearchSlowLog(ClusterService clusterService) {
            sb.append("stage_took_millis[{").append(stageTook).append("}], ");
 *
/**
        Loggers.setLevel(queryLogger, SlowLogLevel.TRACE.name());
            .addSettingsUpdateConsumer(
        private volatile String opaqueId;
                t -> warnThreshold = t.nanos()
        }
import org.opensearch.common.logging.Loggers;
        @Override
        @Override
            queryLogger.debug(message);
                t -> infoThreshold = t.nanos()
            sb.append("query_id[").append(queryId).append("], ");
            .nanos();
        } else if (debugThreshold >= 0 && tookInNanos > debugThreshold && level.isLevelEnabledFor(SlowLogLevel.DEBUG)) {
        clusterService.getClusterSettings()
        }
            .addSettingsUpdateConsumer(
import java.util.concurrent.TimeUnit;
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING,
 *
            sb.append("took[").append(TimeValue.timeValueNanos(totalTookInNanos)).append("], ");
            sb.append("took_millis[").append(TimeUnit.NANOSECONDS.toMillis(totalTookInNanos)).append("], ");
        private final StringBuilder stageTook = new StringBuilder();
            .get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING)
            queryLogger.info(message);
public class AnalyticsSearchSlowLog implements AnalyticsOperationListener {
        }
        private final String querySource;
            );
 */
            .nanos();
            stageTook.append(stageType).append("=").append(TimeUnit.NANOSECONDS.toMillis(tookInNanos));
            this.requestId = requestId;
        this.queryLogger = LogManager.getLogger(QUERY_LOGGER_NAME);
    public static final String QUERY_LOGGER_NAME = "cluster.search.request.slowlog";
     * slow log at query completion. Task headers are set later via {@link QuerySlowLogListener#setHeaders}.
    private final Logger queryLogger;
    /**
        this.level = clusterService.getClusterSettings().get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL);
            if (stageTook.length() > 0) stageTook.append(", ");
            this.planningTimeMs = TimeUnit.NANOSECONDS.toMillis(tookInNanos);
                t -> debugThreshold = t.nanos()
            StringBuilder sb = new StringBuilder();
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING,
}
        this.warnThreshold = clusterService.getClusterSettings()
import org.apache.logging.log4j.LogManager;
        return new QuerySlowLogListener(querySource);
 * SPDX-License-Identifier: Apache-2.0
            this.querySource = querySource;
            .get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING)
            sb.append("request_id[").append(requestId != null ? requestId : "").append("]");
        public void onStageSuccess(String queryId, int stageId, String stageType, long tookInNanos, long rowsProcessed) {
            sb.append("source[").append(querySource != null ? querySource : "").append("], ");
