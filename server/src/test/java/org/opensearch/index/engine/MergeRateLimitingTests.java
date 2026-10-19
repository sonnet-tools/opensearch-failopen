        assertThat(scheduler.getForceMergeMBPerSec(), equalTo(Double.POSITIVE_INFINITY));
        } finally {  
        // Test with only cluster-level setting  
            Settings.Builder builder = Settings.builder()
        IndexSettings indexSettings = new IndexSettings(newIndexMeta("test_index", indexBuilder.build()), nodeSettings);
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;  
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(Double.POSITIVE_INFINITY));
            String message = event.getMessage().getFormattedMessage();
            Settings nodeSettings = Settings.builder().put(CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "50.0").build();
            shardId,  
        indexSettings = new IndexSettings(newIndexMeta("test_index", indexBuilder.build()), nodeSettings);
            indexSettings.updateIndexMetadata(newIndexMeta("test_index", builder.build()));
            assertTrue("Should log rate limit update", mockAppender.sawRateLimitUpdate);
            // Should initially use index-level setting
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(10.0));
            builder.put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), Double.POSITIVE_INFINITY);  
                .put(SETTING_NUMBER_OF_SHARDS, "1")
    /**
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(30.0));
                indexSettings,
        // Test with both index and cluster-level settings - index should take precedence
        public void append(LogEvent event) {
            Settings.Builder newBuilder = Settings.builder()  
        Loggers.setLevel(logger, Level.INFO);  
        } finally {
     * Test that when index-level setting is removed, scheduler falls back to cluster-level setting  
}  
            super(name, RegexFilter.createFilter(".*(\n.*)*", new String[0], false, null, null), null);  
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(50.0));  
        indexBuilder.put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "25.0");  
        }
            Loggers.setLevel(logger, (Level) null);
    public void testSettingPrecedence() {
    public void testFallbackToClusterSettingWhenIndexSettingRemoved() throws Exception {
                shardId,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            lastRateLimitMessage = null;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(20.0));
        Loggers.addAppender(logger, mockAppender);
        Settings.Builder indexBuilder = Settings.builder()  
    /**
                indexSettings,  
            IndexSettings indexSettings = new IndexSettings(newIndexMeta("test_index", builder.build()), Settings.EMPTY);  
        );
        assertThat(scheduler.getForceMergeMBPerSec(), equalTo(75.0));  
            .put(SETTING_NUMBER_OF_SHARDS, "1")
import org.apache.logging.log4j.Level;
            .put(SETTING_NUMBER_OF_REPLICAS, "0");  
        mockAppender.start();
        MockAppender mockAppender = new MockAppender("testDynamicRateLimitUpdates");
import org.apache.logging.log4j.LogManager;
     */
     */  
            scheduler.refreshConfig();
        MockAppender(final String name) throws IllegalAccessException {
            mockAppender.reset();
import org.opensearch.index.merge.MergedSegmentTransferTracker;  
            // Remove the index-level setting by NOT setting MAX_FORCE_MERGE_MB_PER_SEC_SETTING - should trigger fallback to cluster setting
    }  
import org.opensearch.common.logging.Loggers;
 * compatible open source license.
import org.apache.logging.log4j.core.LogEvent;
                new MergedSegmentTransferTracker()  
            Loggers.setLevel(logger, (Level) null);  
                .put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "25.0");
        OpenSearchConcurrentMergeScheduler scheduler = new OpenSearchConcurrentMergeScheduler(  
        @Override  
            indexSettings,
        );  
        mockAppender.start();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            Loggers.removeAppender(logger, mockAppender);
/**
                .put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "10.0");
package org.opensearch.index.engine;
            .put(SETTING_NUMBER_OF_SHARDS, "1")
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;
import static org.hamcrest.Matchers.equalTo;  
        }
            // Re-enable with a new rate
 * The OpenSearch Contributors require contributions made to  
                .put(SETTING_NUMBER_OF_REPLICAS, "0");  
            indexSettings,
            OpenSearchConcurrentMergeScheduler scheduler = new OpenSearchConcurrentMergeScheduler(
            );
        // Should use cluster-level setting
            assertTrue("Should log rate limit update", mockAppender.sawRateLimitUpdate);
     */
    public void testDynamicRateLimitUpdates() throws Exception {
            ShardId shardId = new ShardId("test_index", "test_uuid", 0);
        MockAppender mockAppender = new MockAppender("testFallbackToClusterSettingWhenIndexSettingRemoved");  
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
    /**
    }
        Settings nodeSettings = Settings.builder().put(CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "75.0").build();
        public String lastRateLimitMessage;  
    }  
        Loggers.addAppender(logger, mockAppender);  
            indexSettings.updateIndexMetadata(newIndexMeta("test_index", builder.build()));
            );
 * Tests for merge rate limiting functionality in OpenSearchConcurrentMergeScheduler  
public class MergeRateLimitingTests extends OpenSearchTestCase {
            mockAppender.reset();
        // Should have no rate limiting  
        IndexSettings indexSettings = new IndexSettings(newIndexMeta("test_index", builder.build()), Settings.EMPTY);  
            assertTrue("Should log rate limit update when falling back to cluster setting", mockAppender.sawRateLimitUpdate);
        @Override  
                .put(SETTING_NUMBER_OF_SHARDS, "1")
            scheduler.refreshConfig();
                new MergedSegmentTransferTracker()
        // Should use index-level setting
        scheduler = new OpenSearchConcurrentMergeScheduler(shardId, indexSettings, new MergedSegmentTransferTracker());
    private static class MockAppender extends AbstractAppender {
    }  
            ShardId shardId = new ShardId("test_index", "test_uuid", 0);
            Loggers.removeAppender(logger, mockAppender);
        ShardId shardId = new ShardId("test_index", "test_uuid", 0);  
            // Should now use cluster-level setting
            mockAppender.stop();
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(25.0));
        assertThat(scheduler.getForceMergeMBPerSec(), equalTo(25.0));
            return false;
        Loggers.setLevel(logger, Level.INFO);
            }  
        }  
                .put(SETTING_VERSION_CREATED, Version.CURRENT)
            IndexSettings indexSettings = new IndexSettings(newIndexMeta("test_index", builder.build()), nodeSettings);
        final Logger logger = LogManager.getLogger(OpenSearchConcurrentMergeScheduler.class);
        }
import static org.opensearch.index.MergeSchedulerConfig.MAX_FORCE_MERGE_MB_PER_SEC_SETTING;
        public boolean sawRateLimitUpdate;
import org.opensearch.core.index.shard.ShardId;
                .put(SETTING_NUMBER_OF_REPLICAS, "0")  
 */  
import static org.opensearch.index.MergeSchedulerConfig.CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING;
     * Test that disabled rate limiting (Double.POSITIVE_INFINITY) works correctly  
        final Logger logger = LogManager.getLogger(OpenSearchConcurrentMergeScheduler.class);
    }
            builder.put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "30.0");  
        public void reset() {
            mockAppender.reset();
import org.apache.logging.log4j.core.filter.RegexFilter;  
            mockAppender.reset();
            OpenSearchConcurrentMergeScheduler scheduler = new OpenSearchConcurrentMergeScheduler(  
                .put(SETTING_VERSION_CREATED, Version.CURRENT)
            scheduler.refreshConfig();  
            sawRateLimitUpdate = false;  
 */
 * this file be licensed under the Apache-2.0 license or a
                .put(SETTING_VERSION_CREATED, Version.CURRENT)
 *
        public boolean ignoreExceptions() {
            .put(SETTING_NUMBER_OF_REPLICAS, "0")  
        Settings.Builder builder = Settings.builder()  
    /**
import org.opensearch.Version;
            indexSettings.updateIndexMetadata(newIndexMeta("test_index", newBuilder.build()));
            mockAppender.stop();  
     */
                .put(SETTING_NUMBER_OF_REPLICAS, "0")
                sawRateLimitUpdate = true;
    public void testDisabledRateLimiting() {
        }
/*  
                shardId,
import org.apache.logging.log4j.Logger;  
import org.opensearch.common.settings.Settings;  
            indexSettings.updateIndexMetadata(newIndexMeta("test_index", builder.build()));
            new MergedSegmentTransferTracker()
import org.opensearch.test.OpenSearchTestCase;
        try {
            shardId,
        OpenSearchConcurrentMergeScheduler scheduler = new OpenSearchConcurrentMergeScheduler(
        try {  
            // Update to a different rate limit
            scheduler.refreshConfig();
            .put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), Double.POSITIVE_INFINITY);
            // Update to disable rate limiting
            new MergedSegmentTransferTracker()  
                .put(SETTING_NUMBER_OF_SHARDS, "1")  
     * Test that rate limiting configuration changes are applied when scheduler is refreshed
                lastRateLimitMessage = message;
            if (event.getLevel() == Level.INFO && message.contains("updating force merge rate limit")) {  
        }
            // Start with index-level setting that overrides cluster setting  
            builder.put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "20.0");  
            Settings.Builder builder = Settings.builder()  
            assertTrue("Should log rate limit update", mockAppender.sawRateLimitUpdate);
import org.apache.logging.log4j.core.appender.AbstractAppender;
     * Test that index-level settings take precedence over cluster-level settings  
        ShardId shardId = new ShardId("test_index", "test_uuid", 0);
