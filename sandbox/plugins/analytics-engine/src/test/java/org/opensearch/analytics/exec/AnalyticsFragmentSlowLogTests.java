                    "fragment log fires",
                    "*"
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
                indexSettings,
                    ".*took\\[.*\\].*took_millis\\[\\d+\\].*query_id\\[q-fields\\].*stage_id\\[2\\].*shard\\[\\[my-idx\\]\\[0\\]\\].*rows_produced\\[100\\].*used_secondary_index\\[false\\].*partial_aggregate\\[true\\].*task_id\\[101\\].*id\\[opaque-2\\].*"
 * compatible open source license.
        return new IndexSettings(metadata, Settings.EMPTY);
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();
        }
    public void testFragmentSlowLogContainsAllExpectedFields() throws Exception {
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMillis(0));
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMillis(0));
            appender.assertAllExpectationsMatched();
        Loggers.setLevel(logger, Level.WARN);
            );
            appender.addExpectation(
                    "delegation fields present when secondary index used",
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();
        IndexMetadata metadata = IndexMetadata.builder("test-index").settings(settings).build();
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
import org.apache.logging.log4j.Logger;
                2,
 * The OpenSearch Contributors require contributions made to
                    "no delegation fields when secondary index not used",
                indexSettings,
            .build();
        }
    }
                    ".*used_secondary_index\\[true\\].*delegated_predicates\\[3\\].*filter_tree_shape\\[CONJUNCTIVE\\].*"
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
package org.opensearch.analytics.exec;
            );
    public void testFragmentSlowLogDoesNotFireWhenBelowThreshold() throws Exception {
                )
        Settings settings = Settings.builder()
            fragmentSlowLog.onFragmentSuccess(
                "q-sec",
    }
            );
            appender.addExpectation(
                new FragmentExecutionStats(50, false, 0, null, false, 201, "op-1")
            fragmentSlowLog.onFragmentSuccess(
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);
                indexSettings,
public class AnalyticsFragmentSlowLogTests extends OpenSearchTestCase {
                "test-shard",
        }
                0,
            );
import org.opensearch.analytics.backend.FragmentExecutionStats;
/*
                    Level.WARN,
                "[idx][0]",
                "[idx][0]",
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);
    private IndexSettings createIndexSettings(TimeValue warnThreshold) {
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
            );
            .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), warnThreshold)
        }
            );
                "test-shard",
import org.opensearch.common.logging.Loggers;
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
    }
            );
                )
            appender.addExpectation(
                )
                    Level.WARN,
            appender.assertAllExpectationsMatched();
import org.opensearch.index.IndexSettings;
import org.opensearch.test.OpenSearchTestCase;
            appender.addExpectation(
import org.apache.logging.log4j.LogManager;
                    "no fragment log below threshold",
    }
                    ".*shard\\[test-shard\\].*rows_produced\\[42\\].*"
                    ".*used_secondary_index\\[false\\].*partial_aggregate\\[.*"
                new FragmentExecutionStats(42, true, 2, "CONJUNCTIVE", false, 99, "opaque-1")
            appender.assertAllExpectationsMatched();
 */
            appender.assertAllExpectationsMatched();
                    Level.WARN,
        Loggers.setLevel(logger, Level.WARN);
                0,
        Loggers.setLevel(logger, Level.WARN);
                    "*delegated_predicates*"
                new FragmentExecutionStats(42, true, 2, "CONJUNCTIVE", false, 99, "opaque-1")
                    "delegated_predicates absent",
                "q1",
    }
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);
            fragmentSlowLog.onFragmentSuccess(
    public void testFragmentSlowLogFiresWhenAboveThreshold() throws Exception {
                0,
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMillis(0));
import org.opensearch.Version;
                "q1",
}
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
    public void testFragmentSlowLogWithoutSecondaryIndexOmitsDelegationFields() throws Exception {
            );
                "q-nosec",
                    Level.WARN,
        Loggers.setLevel(logger, Level.WARN);
import org.opensearch.common.unit.TimeValue;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * this file be licensed under the Apache-2.0 license or a
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
            fragmentSlowLog.onFragmentSuccess(
                TimeValue.timeValueMillis(5).nanos(),
import org.opensearch.common.settings.Settings;
            );
            appender.addExpectation(
    public void testFragmentSlowLogWithSecondaryIndexShowsDelegationFields() throws Exception {
                )
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
                )
            appender.assertAllExpectationsMatched();
                TimeValue.timeValueMillis(10).nanos(),
                TimeValue.timeValueMillis(50).nanos(),
                TimeValue.timeValueMillis(10).nanos(),
                new FragmentExecutionStats(50, true, 3, "CONJUNCTIVE", false, 200, null)
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                new MockLogAppender.UnseenEventExpectation(
            );
                    "all fields present",
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
                )
 * SPDX-License-Identifier: Apache-2.0
                new MockLogAppender.UnseenEventExpectation(
import org.opensearch.index.SearchSlowLog;
                    Level.WARN,
            appender.addExpectation(
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
                    Level.WARN,
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
import org.apache.logging.log4j.Level;
            fragmentSlowLog.onFragmentSuccess(
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMillis(0));
                indexSettings,
                "q-fields",
 *
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMinutes(10));
                indexSettings,
                "[my-idx][0]",
import org.opensearch.test.MockLogAppender;
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                TimeValue.timeValueMillis(5).nanos(),
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();
        }
import org.opensearch.cluster.metadata.IndexMetadata;
        Loggers.setLevel(logger, Level.WARN);
            );
    }
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
                new FragmentExecutionStats(100, false, 0, null, true, 101, "opaque-2")
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
                0,
