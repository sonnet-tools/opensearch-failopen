            .setMapping("name", "type=keyword", "value", "type=integer")
 * this file be licensed under the Apache-2.0 license or a
            appender.addExpectation(expectSeen("contains took", ".*took\\[.*\\].*"));  
import org.opensearch.index.IndexingSlowLog;
                    .put("index.number_of_replicas", 0)  
                    .put("index.pluggable.dataformat", "composite")
            appender.addExpectation(expectSeen("contains document id", ".*id\\[.*\\].*"));
/**  
            assertEquals(  
        Logger logger = LogManager.getLogger(SLOW_LOG_LOGGER);
public class CompositeIndexingSlowLogIT extends AbstractCompositeEngineIT {
import org.opensearch.test.MockLogAppender;  
 * The OpenSearch Contributors require contributions made to  
            assertEquals(
                    .putList("index.composite.secondary_data_formats", "lucene")
import org.opensearch.core.rest.RestStatus;
        Loggers.setLevel(logger, Level.WARN);
        try (MockLogAppender appender = newSlowLogAppender()) {
import org.apache.logging.log4j.Level;
/*  
    public void testSlowLogEmitsAllFieldsForDFAEngine() throws Exception {
        return MockLogAppender.createForLoggers(logger);  
            .get();
 * SPDX-License-Identifier: Apache-2.0
            appender.assertAllExpectationsMatched();
import org.opensearch.common.unit.TimeValue;  
        return new MockLogAppender.PatternSeenWithLoggerPrefixExpectation(name, SLOW_LOG_LOGGER, Level.WARN, regex);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
                    .put("index.number_of_shards", 1)
        }
    public void testSlowLogDoesNotFireWhenBelowThreshold() throws Exception {  
    }  
import org.apache.logging.log4j.LogManager;
            .indices()
        }  
        ensureGreen(INDEX_NAME);  
 */  
    private void createIndexWithSlowLogThreshold(TimeValue threshold) {
                RestStatus.CREATED,
                    .put("index.composite.primary_data_format", "parquet")  
import org.apache.logging.log4j.Logger;  
            );
            appender.assertAllExpectationsMatched();
        client().admin()  
                client().prepareIndex().setIndex(INDEX_NAME).setSource("name", "fast_doc", "value", 1).get().status()
            )  
    }
            );  
            appender.addExpectation(expectSeen("contains index name", ".*slowlog-test-idx.*"));
}  
import org.opensearch.common.settings.Settings;
            appender.addExpectation(
package org.opensearch.composite;
 *
            );  
            .setSettings(  
                new MockLogAppender.UnseenEventExpectation("no slow log below threshold", SLOW_LOG_LOGGER, Level.WARN, "*")
 * Verifies that the indexing slow log fires with full fidelity when documents
            appender.addExpectation(expectSeen("contains document source", ".*source\\[.*test_value.*\\].*"));
            appender.addExpectation(expectSeen("contains routing field", ".*routing\\[.*\\].*"));  
 * are indexed through the DataFormatAware (Parquet) engine.
    private static MockLogAppender.PatternSeenWithLoggerPrefixExpectation expectSeen(String name, String regex) {  
    }
                    .put("index.pluggable.dataformat.enabled", true)
        createIndexWithSlowLogThreshold(TimeValue.timeValueMillis(0));
import org.opensearch.test.OpenSearchIntegTestCase;
        createIndexWithSlowLogThreshold(TimeValue.timeValueMinutes(10));
                    .put(IndexingSlowLog.INDEX_INDEXING_SLOWLOG_THRESHOLD_INDEX_WARN_SETTING.getKey(), threshold)
                RestStatus.CREATED,  
                client().prepareIndex().setIndex(INDEX_NAME).setSource("name", "test_value", "value", 42).get().status()
    }
            appender.addExpectation(expectSeen("contains took_millis", ".*took_millis\\[\\d+\\].*"));
                Settings.builder()
    private MockLogAppender newSlowLogAppender() throws IllegalAccessException {  
 */  
import org.opensearch.common.logging.Loggers;
 * compatible open source license.
    private static final String SLOW_LOG_LOGGER = IndexingSlowLog.INDEX_INDEXING_SLOWLOG_PREFIX + ".index";
    private static final String INDEX_NAME = "slowlog-test-idx";
        try (MockLogAppender appender = newSlowLogAppender()) {  
    }
            .prepareCreate(INDEX_NAME)
