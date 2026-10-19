        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);
            );
            );  
        Loggers.setLevel(logger, Level.WARN);  
            );
    public void testFragmentSlowLogDoesNotFireWhenBelowThreshold() throws Exception {
    }  
            appender.assertAllExpectationsMatched();
                    Level.WARN,  
                TimeValue.timeValueMillis(10).nanos(),
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {  
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
            );
            appender.addExpectation(  
        }
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();  
                    Level.WARN,  
                indexSettings,
import org.opensearch.test.OpenSearchTestCase;
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMillis(0));  
            fragmentSlowLog.onFragmentSuccess(
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(  
 *
    }  
                    Level.WARN,
    }
                    "fragment log fires",  
                    Level.WARN,
import org.apache.logging.log4j.LogManager;
                indexSettings,
                indexSettings,
                    ".*took\\[.*\\].*took_millis\\[\\d+\\].*query_id\\[q-fields\\].*stage_id\\[2\\].*shard\\[\\[my-idx\\]\\[0\\]\\].*rows_produced\\[100\\].*used_secondary_index\\[false\\].*partial_aggregate\\[true\\].*task_id\\[101\\].*id\\[opaque-2\\].*"
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
                    "no fragment log below threshold",
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();
        Loggers.setLevel(logger, Level.WARN);
                    "delegated_predicates absent",
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
import org.opensearch.test.MockLogAppender;  
    public void testFragmentSlowLogContainsAllExpectedFields() throws Exception {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                "q-fields",  
import org.apache.logging.log4j.Level;
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMinutes(10));  
    }
            .build();  
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();
                TimeValue.timeValueMillis(5).nanos(),
                )
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
                )
                "test-shard",  
import org.apache.logging.log4j.Logger;  
                )
import org.opensearch.analytics.backend.FragmentExecutionStats;
                0,  
                    Level.WARN,
    public void testFragmentSlowLogWithSecondaryIndexShowsDelegationFields() throws Exception {
    }
package org.opensearch.analytics.exec;
import org.opensearch.index.IndexSettings;
                "q1",
/*  
import org.opensearch.common.unit.TimeValue;  
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
        return new IndexSettings(metadata, Settings.EMPTY);
                new MockLogAppender.UnseenEventExpectation(  
            );
        Loggers.setLevel(logger, Level.WARN);
                "q-sec",
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {  
            );  
                2,
        Loggers.setLevel(logger, Level.WARN);
            appender.assertAllExpectationsMatched();
            appender.addExpectation(
 */  
                "[idx][0]",
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMillis(0));
            appender.addExpectation(  
            appender.addExpectation(
                TimeValue.timeValueMillis(5).nanos(),
                new FragmentExecutionStats(42, true, 2, "CONJUNCTIVE", false, 99, "opaque-1")  
                "[idx][0]",
    private IndexSettings createIndexSettings(TimeValue warnThreshold) {
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
        Loggers.setLevel(logger, Level.WARN);
 * compatible open source license.
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);  
            );  
            );
                indexSettings,  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import org.opensearch.Version;
            fragmentSlowLog.onFragmentSuccess(
        }
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);
    }  
                    "no delegation fields when secondary index not used",
            .put(SearchSlowLog.INDEX_SEARCH_SLOWLOG_THRESHOLD_QUERY_WARN_SETTING.getKey(), warnThreshold)
import org.opensearch.common.settings.Settings;
                TimeValue.timeValueMillis(50).nanos(),  
            fragmentSlowLog.onFragmentSuccess(
        }  
        IndexMetadata metadata = IndexMetadata.builder("test-index").settings(settings).build();
        }
                "q-nosec",  
                "[my-idx][0]",
public class AnalyticsFragmentSlowLogTests extends OpenSearchTestCase {  
                indexSettings,  
                0,
                0,
            appender.addExpectation(
            );
                "test-shard",
import org.opensearch.index.SearchSlowLog;
                0,  
        AnalyticsFragmentSlowLog fragmentSlowLog = new AnalyticsFragmentSlowLog();  
                    "*"
                )  
            appender.addExpectation(
            appender.assertAllExpectationsMatched();  
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
                    Level.WARN,
    public void testFragmentSlowLogFiresWhenAboveThreshold() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.common.logging.Loggers;
}
 * this file be licensed under the Apache-2.0 license or a
            appender.assertAllExpectationsMatched();  
            );
                new FragmentExecutionStats(100, false, 0, null, true, 101, "opaque-2")
                    ".*used_secondary_index\\[false\\].*partial_aggregate\\[.*"
                    AnalyticsFragmentSlowLog.LOGGER_NAME,  
            fragmentSlowLog.onFragmentSuccess(
    public void testFragmentSlowLogWithoutSecondaryIndexOmitsDelegationFields() throws Exception {
                new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(
                    "all fields present",
                    "*delegated_predicates*"
                    AnalyticsFragmentSlowLog.LOGGER_NAME,
        Logger logger = LogManager.getLogger(AnalyticsFragmentSlowLog.LOGGER_NAME);  
                new MockLogAppender.UnseenEventExpectation(
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMillis(0));
                new FragmentExecutionStats(42, true, 2, "CONJUNCTIVE", false, 99, "opaque-1")
                    "delegation fields present when secondary index used",  
            appender.assertAllExpectationsMatched();
            );  
        }
                    AnalyticsFragmentSlowLog.LOGGER_NAME,  
                new FragmentExecutionStats(50, false, 0, null, false, 201, "op-1")
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
        Settings settings = Settings.builder()  
                    ".*shard\\[test-shard\\].*rows_produced\\[42\\].*"  
                )
                    ".*used_secondary_index\\[true\\].*delegated_predicates\\[3\\].*filter_tree_shape\\[CONJUNCTIVE\\].*"  
                )  
        IndexSettings indexSettings = createIndexSettings(TimeValue.timeValueMillis(0));
 * SPDX-License-Identifier: Apache-2.0
                new FragmentExecutionStats(50, true, 3, "CONJUNCTIVE", false, 200, null)
            fragmentSlowLog.onFragmentSuccess(  
                "q1",
 * The OpenSearch Contributors require contributions made to  
                TimeValue.timeValueMillis(10).nanos(),  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
