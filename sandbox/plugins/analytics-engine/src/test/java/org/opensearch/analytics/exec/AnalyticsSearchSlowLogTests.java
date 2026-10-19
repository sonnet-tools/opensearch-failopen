        wrapped.setHeaders("user-opaque-123", "req-456");
            wrapped.onQueryComplete("q5", TimeValue.timeValueMillis(1).nanos(), 0);
        var wrapped = slowLog.createQueryListener("SELECT 1");
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
                    AnalyticsSearchSlowLog.QUERY_LOGGER_NAME,
    public void testSlowLogFiresAtOnQueryComplete() throws Exception {
    }
            wrapped.onQueryComplete("q1", TimeValue.timeValueMillis(10).nanos(), 50);
        AnalyticsSearchSlowLog slowLog = createSlowLog(TimeValue.timeValueMillis(0));
import org.opensearch.test.MockLogAppender;
 * compatible open source license.
            .build();
            )
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_INFO_SETTING,
            wrapped.onQueryComplete("q3", TimeValue.timeValueMillis(14).nanos(), 100);
            wrapped.onStageSuccess("q3", 0, "ShardFragmentStageExecution", TimeValue.timeValueMillis(8).nanos(), 100);
                )
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING,
                    "empty fields present",
            appender.assertAllExpectationsMatched();
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
        ClusterSettings clusterSettings = new ClusterSettings(
            .put(SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_WARN_SETTING.getKey(), warnThreshold)
        Loggers.setLevel(logger, Level.WARN);
        var wrapped = slowLog.createQueryListener("SELECT * FROM idx");
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
import org.opensearch.common.unit.TimeValue;
            appender.assertAllExpectationsMatched();
        Settings settings = Settings.builder()
            );
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_LEVEL
        Logger logger = LogManager.getLogger(AnalyticsSearchSlowLog.QUERY_LOGGER_NAME);
        }
                    Level.WARN,
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
            appender.assertAllExpectationsMatched();
                )
        Logger logger = LogManager.getLogger(AnalyticsSearchSlowLog.QUERY_LOGGER_NAME);
            );
        }
        }
import org.opensearch.common.settings.Settings;
            wrapped.onPlanningComplete("q3", TimeValue.timeValueMillis(2).nanos());
                    Level.WARN,
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
        }
            );
                    AnalyticsSearchSlowLog.QUERY_LOGGER_NAME,
import org.apache.logging.log4j.Level;
            wrapped.onQueryComplete("q2", TimeValue.timeValueMillis(5).nanos(), 10);
import org.opensearch.cluster.service.ClusterService;
                )
import java.util.Set;
            appender.addExpectation(
                    "planning and stage timing present",
import org.apache.logging.log4j.LogManager;
        Logger logger = LogManager.getLogger(AnalyticsSearchSlowLog.QUERY_LOGGER_NAME);
import static org.mockito.Mockito.mock;
                    ".*took\\[.*\\].*query_id\\[q1\\].*total_rows\\[50\\].*"
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
        return new AnalyticsSearchSlowLog(clusterService);
    }
    }
                    AnalyticsSearchSlowLog.QUERY_LOGGER_NAME,
import org.opensearch.action.search.SearchRequestSlowLog;
 *
            appender.addExpectation(
            appender.addExpectation(
    private AnalyticsSearchSlowLog createSlowLog(TimeValue warnThreshold) {
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_TRACE_SETTING,
                    "no log below threshold",
    }
import org.opensearch.test.OpenSearchTestCase;
                    Level.WARN,
                new MockLogAppender.UnseenEventExpectation(
    }
        Logger logger = LogManager.getLogger(AnalyticsSearchSlowLog.QUERY_LOGGER_NAME);
    public void testSlowLogIncludesPlanningAndStageTiming() throws Exception {
        var wrapped = slowLog.createQueryListener(null);
                    ".*source\\[\\].*id\\[\\].*request_id\\[\\].*"
                    "*"
            appender.addExpectation(
            appender.assertAllExpectationsMatched();
import org.apache.logging.log4j.Logger;
            appender.assertAllExpectationsMatched();
import static org.mockito.Mockito.when;
 * SPDX-License-Identifier: Apache-2.0
    public void testSlowLogIncludesSourceAndHeaders() throws Exception {
                    "slow log fires at query complete",
        var wrapped = slowLog.createQueryListener("source = my_index | stats count()");
            appender.addExpectation(
package org.opensearch.analytics.exec;
            wrapped.onStageSuccess("q3", 1, "ReduceStageExecution", TimeValue.timeValueMillis(3).nanos(), 100);
 * this file be licensed under the Apache-2.0 license or a
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
        AnalyticsSearchSlowLog slowLog = createSlowLog(TimeValue.timeValueSeconds(10));
public class AnalyticsSearchSlowLogTests extends OpenSearchTestCase {
    public void testSlowLogDoesNotFireWhenBelowThreshold() throws Exception {
 * The OpenSearch Contributors require contributions made to
/*
        wrapped.setHeaders("opaque-1", "req-1");
        Loggers.setLevel(logger, Level.WARN);
                )
        Logger logger = LogManager.getLogger(AnalyticsSearchSlowLog.QUERY_LOGGER_NAME);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.logging.Loggers;
            Set.of(
                    ".*source\\[source = my_index \\| stats count\\(\\)\\].*id\\[user-opaque-123\\].*request_id\\[req-456\\].*"
                    Level.WARN,
            settings,
                    AnalyticsSearchSlowLog.QUERY_LOGGER_NAME,
                SearchRequestSlowLog.CLUSTER_SEARCH_REQUEST_SLOWLOG_THRESHOLD_DEBUG_SETTING,
        AnalyticsSearchSlowLog slowLog = createSlowLog(TimeValue.timeValueMillis(0));
        Loggers.setLevel(logger, Level.WARN);
}
                    Level.WARN,
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
            );
        ClusterService clusterService = mock(ClusterService.class);
    }
            wrapped.onQueryComplete("q4", TimeValue.timeValueMillis(10).nanos(), 1);
        when(clusterService.getSettings()).thenReturn(settings);
            );
        var wrapped = slowLog.createQueryListener("SELECT val FROM idx");
        }
        );
                    AnalyticsSearchSlowLog.QUERY_LOGGER_NAME,
                    "source in log",
                )
        AnalyticsSearchSlowLog slowLog = createSlowLog(TimeValue.timeValueMillis(0));
 */
    public void testSlowLogWithNullMetadata() throws Exception {
        AnalyticsSearchSlowLog slowLog = createSlowLog(TimeValue.timeValueMillis(0));
                    ".*planning_time_millis\\[2\\].*stage_took_millis\\[\\{ShardFragmentStageExecution=8, ReduceStageExecution=3\\}\\].*"
        Loggers.setLevel(logger, Level.WARN);
        Loggers.setLevel(logger, Level.WARN);
