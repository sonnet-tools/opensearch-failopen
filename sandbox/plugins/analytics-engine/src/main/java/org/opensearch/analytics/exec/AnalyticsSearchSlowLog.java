 *  
            .get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING)
    /**
            if (stageTook.length() > 0) stageTook.append(", ");
 * — the terminal event fired after planning, execution, and materialization are all done.
            .get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING)
import java.util.concurrent.TimeUnit;
        this.traceThreshold = clusterService.getClusterSettings()  
        if (warnThreshold >= 0 && tookInNanos > warnThreshold && level.isLevelEnabledFor(SlowLogLevel.WARN)) {
public class AnalyticsSearchSlowLog implements AnalyticsOperationListener {
        public void onQueryComplete(String queryId, long totalTookInNanos, long totalRows) {  
        } else if (infoThreshold >= 0 && tookInNanos > infoThreshold && level.isLevelEnabledFor(SlowLogLevel.INFO)) {
            logAtLevel(sb.toString(), totalTookInNanos);
 *  
import org.opensearch.common.logging.SlowLogLevel;
import org.opensearch.common.logging.Loggers;  
 *
        QuerySlowLogListener(String querySource) {  
            .addSettingsUpdateConsumer(  
        }
     */
    private void logAtLevel(String message, long tookInNanos) {
        private final StringBuilder stageTook = new StringBuilder();
        void setHeaders(String opaqueId, String requestId) {
            .nanos();
            .addSettingsUpdateConsumer(  
            .get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING)
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING,  
 * SPDX-License-Identifier: Apache-2.0
 * Coordinator-level slow log for analytics engine queries. Logs at {@code onQueryComplete}
package org.opensearch.analytics.exec;
            .addSettingsUpdateConsumer(
        }  
        public void onStageSuccess(String queryId, int stageId, String stageType, long tookInNanos, long rowsProcessed) {  
     * slow log at query completion. Task headers are set later via {@link QuerySlowLogListener#setHeaders}.
     * then emits the complete slow log entry at {@code onQueryComplete}.  
        private long planningTimeMs;  
                t -> traceThreshold = t.nanos()
    public AnalyticsSearchSlowLog(ClusterService clusterService) {
import org.apache.logging.log4j.Logger;
            );
        }  
 * The OpenSearch Contributors require contributions made to  
        this.infoThreshold = clusterService.getClusterSettings()  
 * full query lifecycle — planning, stage execution, and completion — accumulating timing
 * data and emitting the slow log entry at {@code onQueryComplete}.  
     * before planning starts so it can capture planning time, stage timing, and emit the  
        @Override  
        this.level = clusterService.getClusterSettings().get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL);  
    public static final String QUERY_LOGGER_NAME = "cluster.search.request.slowlog";  
            sb.append("query_id[").append(queryId).append("], ");  
    /**
/**  
            this.level = l;
    private volatile long debugThreshold;  
import org.opensearch.common.unit.TimeValue;
            stageTook.append(stageType).append("=").append(TimeUnit.NANOSECONDS.toMillis(tookInNanos));
/*  
            .nanos();
            this.querySource = querySource;
 */
            .nanos();
        }
            queryLogger.warn(message);  
        Loggers.setLevel(queryLogger, SlowLogLevel.TRACE.name());
            sb.append("id[").append(opaqueId != null ? opaqueId : "").append("], ");  
     * Creates a per-query listener that observes the full query lifecycle. Must be created
                t -> debugThreshold = t.nanos()  
            this.opaqueId = opaqueId;
        clusterService.getClusterSettings()
            );  
        }
    private volatile long warnThreshold;
        private volatile String opaqueId;
 * compatible open source license.
        clusterService.getClusterSettings().addSettingsUpdateConsumer(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL, l -> {
            Loggers.setLevel(queryLogger, l.name());  
    private volatile long infoThreshold;
            .nanos();
            StringBuilder sb = new StringBuilder();
                t -> warnThreshold = t.nanos()
            queryLogger.info(message);
            sb.append("total_rows[").append(totalRows).append("], ");
            );
    }
    class QuerySlowLogListener implements AnalyticsOperationListener {
        clusterService.getClusterSettings()
    }
 */  
            this.requestId = requestId;  
        return new QuerySlowLogListener(querySource);
import org.opensearch.analytics.backend.AnalyticsOperationListener;
    }
    private final Logger queryLogger;
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING,
import org.apache.logging.log4j.LogManager;
        @Override
            sb.append("stage_took_millis[{").append(stageTook).append("}], ");
     * Per-query listener that accumulates planning time, stage timing, and task headers,
        this.queryLogger = LogManager.getLogger(QUERY_LOGGER_NAME);  
            sb.append("planning_time_millis[").append(planningTimeMs).append("], ");
            );  
        }  
import org.opensearch.action.search.SearchRequestSlowLog;  
        @Override
        public void onPlanningComplete(String queryId, long tookInNanos) {
        } else if (traceThreshold >= 0 && tookInNanos > traceThreshold && level.isLevelEnabledFor(SlowLogLevel.TRACE)) {
        } else if (debugThreshold >= 0 && tookInNanos > debugThreshold && level.isLevelEnabledFor(SlowLogLevel.DEBUG)) {  
        clusterService.getClusterSettings()
            this.planningTimeMs = TimeUnit.NANOSECONDS.toMillis(tookInNanos);
            .addSettingsUpdateConsumer(
        });
            sb.append("took_millis[").append(TimeUnit.NANOSECONDS.toMillis(totalTookInNanos)).append("], ");  
        this.debugThreshold = clusterService.getClusterSettings()  
        this.warnThreshold = clusterService.getClusterSettings()  
    }
    private volatile SlowLogLevel level;
     */
 * <p>{@link #createQueryListener(String)} creates a per-query listener that observes the
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING,
        private final String querySource;  
            .get(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING)
        clusterService.getClusterSettings()  
 * <p>Reuses the existing {@code cluster.search.request.slowlog.*} settings so operators
 * this file be licensed under the Apache-2.0 license or a
            sb.append("took[").append(TimeValue.timeValueNanos(totalTookInNanos)).append("], ");
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING,
            sb.append("request_id[").append(requestId != null ? requestId : "").append("]");
}
            sb.append("source[").append(querySource != null ? querySource : "").append("], ");
            queryLogger.debug(message);
                t -> infoThreshold = t.nanos()
            queryLogger.trace(message);  
    public QuerySlowLogListener createQueryListener(String querySource) {  
    private volatile long traceThreshold;
 * have a single configuration surface for both standard and analytics search paths.
        private volatile String requestId;
import org.opensearch.cluster.service.ClusterService;
