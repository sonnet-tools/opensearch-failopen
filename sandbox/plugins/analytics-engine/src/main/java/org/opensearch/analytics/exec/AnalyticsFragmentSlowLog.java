import org.opensearch.index.IndexSettings;
        sb.append("], partial_aggregate[").append(stats.hasPartialAggregate());
    public void onFragmentSuccess(
        sb.append("], query_id[").append(queryId);
        sb.append("], task_id[").append(stats.taskId());
import org.opensearch.index.SearchSlowLog;  
        long infoThreshold = indexSettings.getValue(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_INFO_SETTING).nanos();
    private static String formatMessage(String queryId, int stageId, String shardId, long tookInNanos, FragmentExecutionStats stats) {  
 * Reads per-index thresholds from {@link IndexSettings} passed at call time,  
        String shardId,
public class AnalyticsFragmentSlowLog implements AnalyticsOperationListener {
        return sb.toString();
        } else if (infoThreshold >= 0 && tookInNanos > infoThreshold && level.isLevelEnabledFor(SlowLogLevel.INFO)) {  
 *
    public static final String LOGGER_NAME = "index.search.slowlog";
 * query timing in the standard search path.
    ) {
        StringBuilder sb = new StringBuilder();
            logger.trace(message);
 * The OpenSearch Contributors require contributions made to  
        sb.append("]");
        }  
 * this file be licensed under the Apache-2.0 license or a
        long debugThreshold = indexSettings.getValue(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_DEBUG_SETTING).nanos();
import org.opensearch.common.logging.Loggers;
import org.opensearch.common.logging.SlowLogLevel;  
package org.opensearch.analytics.exec;
import java.util.concurrent.TimeUnit;
    }
        sb.append("], shard[").append(shardId);  
            logger.info(message);
 */  
        this.logger = LogManager.getLogger(LOGGER_NAME);
        sb.append("], took_millis[").append(TimeUnit.NANOSECONDS.toMillis(tookInNanos));  
        if (warnThreshold >= 0 && tookInNanos > warnThreshold && level.isLevelEnabledFor(SlowLogLevel.WARN)) {
    private final Logger logger;  
        IndexSettings indexSettings,  
/**
    public AnalyticsFragmentSlowLog() {
        if (stats.usedSecondaryIndex()) {  
import org.apache.logging.log4j.LogManager;
        Loggers.setLevel(logger, SlowLogLevel.TRACE.name());  
 * compatible open source license.
        SlowLogLevel level = indexSettings.getValue(SearchSlowLog.INDEX_SEARCH_SLOWLOG_LEVEL);
        FragmentExecutionStats stats
        long tookInNanos,
        sb.append("], used_secondary_index[").append(stats.usedSecondaryIndex());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.backend.FragmentExecutionStats;
        sb.append("took[").append(TimeValue.timeValueNanos(tookInNanos));
/*  
import org.opensearch.common.unit.TimeValue;
        String message = formatMessage(queryId, stageId, shardId, tookInNanos, stats);  
            sb.append("], filter_tree_shape[").append(stats.filterTreeShape());
        int stageId,  
import org.apache.logging.log4j.Logger;
    }
    @Override  
 * Data-node-level slow log for analytics engine fragment executions.
        } else if (debugThreshold >= 0 && tookInNanos > debugThreshold && level.isLevelEnabledFor(SlowLogLevel.DEBUG)) {
            logger.debug(message);  
        sb.append("], id[").append(stats.opaqueId() != null ? stats.opaqueId() : "");  
        long warnThreshold = indexSettings.getValue(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING).nanos();  
        long traceThreshold = indexSettings.getValue(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_TRACE_SETTING).nanos();  
}
            sb.append("], delegated_predicates[").append(stats.delegatedPredicateCount());
        sb.append("], stage_id[").append(stageId);
 * mirroring how {@link SearchSlowLog} uses per-index settings for shard-level
    }  
        String queryId,
 */  
            logger.warn(message);
        }  
        sb.append("], rows_produced[").append(stats.rowsProduced());
        } else if (traceThreshold >= 0 && tookInNanos > traceThreshold && level.isLevelEnabledFor(SlowLogLevel.TRACE)) {
import org.opensearch.analytics.backend.AnalyticsOperationListener;  
