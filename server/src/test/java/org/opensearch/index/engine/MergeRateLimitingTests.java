        );
            mockAppender.reset();
    }
        }
import org.apache.logging.log4j.Logger;
        indexSettings = new IndexSettings(newIndexMeta("test_index", indexBuilder.build()), nodeSettings);
            .put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), Double.POSITIVE_INFINITY);
 * compatible open source license.
        ShardId shardId = new ShardId("test_index", "test_uuid", 0);
        Loggers.addAppender(logger, mockAppender);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            .put(SETTING_NUMBER_OF_REPLICAS, "0");
            scheduler.refreshConfig();
        Loggers.addAppender(logger, mockAppender);
    /**
            shardId,
                indexSettings,
     */
                .put(SETTING_NUMBER_OF_REPLICAS, "0")
                indexSettings,
/**
    private static class MockAppender extends AbstractAppender {
     * Test that disabled rate limiting (Double.POSITIVE_INFINITY) works correctly
        // Should use cluster-level setting
            scheduler.refreshConfig();
import org.opensearch.Version;
        assertThat(scheduler.getForceMergeMBPerSec(), equalTo(25.0));
            super(name, RegexFilter.createFilter(".*(\n.*)*", new String[0], false, null, null), null);
            Loggers.setLevel(logger, (Level) null);
        MockAppender(final String name) throws IllegalAccessException {
 * SPDX-License-Identifier: Apache-2.0
            .put(SETTING_NUMBER_OF_SHARDS, "1")
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        }
                new MergedSegmentTransferTracker()
                lastRateLimitMessage = message;
            indexSettings.updateIndexMetadata(newIndexMeta("test_index", builder.build()));
}
            mockAppender.reset();
        indexBuilder.put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "25.0");
            String message = event.getMessage().getFormattedMessage();
public class MergeRateLimitingTests extends OpenSearchTestCase {
        @Override
/*
            IndexSettings indexSettings = new IndexSettings(newIndexMeta("test_index", builder.build()), Settings.EMPTY);
package org.opensearch.index.engine;
                .put(SETTING_VERSION_CREATED, Version.CURRENT)
            mockAppender.reset();
 * Tests for merge rate limiting functionality in OpenSearchConcurrentMergeScheduler
            assertTrue("Should log rate limit update", mockAppender.sawRateLimitUpdate);
            lastRateLimitMessage = null;
                .put(SETTING_VERSION_CREATED, Version.CURRENT)
        }
            indexSettings.updateIndexMetadata(newIndexMeta("test_index", newBuilder.build()));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            // Update to a different rate limit
        // Should use index-level setting
            .put(SETTING_NUMBER_OF_SHARDS, "1")
    public void testDynamicRateLimitUpdates() throws Exception {
        OpenSearchConcurrentMergeScheduler scheduler = new OpenSearchConcurrentMergeScheduler(
        public boolean sawRateLimitUpdate;
            indexSettings.updateIndexMetadata(newIndexMeta("test_index", builder.build()));
            // Should now use cluster-level setting
        );
                .put(SETTING_NUMBER_OF_SHARDS, "1")
    /**
            ShardId shardId = new ShardId("test_index", "test_uuid", 0);
                .put(SETTING_VERSION_CREATED, Version.CURRENT)
            OpenSearchConcurrentMergeScheduler scheduler = new OpenSearchConcurrentMergeScheduler(
            // Remove the index-level setting by NOT setting MAX_FORCE_MERGE_MB_PER_SEC_SETTING - should trigger fallback to cluster setting
import org.apache.logging.log4j.Level;
     */
            assertTrue("Should log rate limit update", mockAppender.sawRateLimitUpdate);
        final Logger logger = LogManager.getLogger(OpenSearchConcurrentMergeScheduler.class);
import static org.hamcrest.Matchers.equalTo;
import org.apache.logging.log4j.LogManager;
            builder.put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "20.0");
            Loggers.removeAppender(logger, mockAppender);
    public void testSettingPrecedence() {
        try {
    }
        }
     */
        try {
                .put(SETTING_NUMBER_OF_REPLICAS, "0");
        MockAppender mockAppender = new MockAppender("testDynamicRateLimitUpdates");
 *
            assertTrue("Should log rate limit update", mockAppender.sawRateLimitUpdate);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        Loggers.setLevel(logger, Level.INFO);
 */
import static org.opensearch.index.MergeSchedulerConfig.CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING;
            ShardId shardId = new ShardId("test_index", "test_uuid", 0);
        // Should have no rate limiting
 * The OpenSearch Contributors require contributions made to
            );
import org.opensearch.common.logging.Loggers;
                .put(SETTING_NUMBER_OF_REPLICAS, "0")
                .put(SETTING_NUMBER_OF_SHARDS, "1")
import org.opensearch.index.IndexSettings;
        }
                new MergedSegmentTransferTracker()
            }
            Settings.Builder builder = Settings.builder()
        IndexSettings indexSettings = new IndexSettings(newIndexMeta("test_index", indexBuilder.build()), nodeSettings);
                .put(SETTING_NUMBER_OF_SHARDS, "1")
            indexSettings,
            builder.put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "30.0");
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(25.0));
        public void reset() {
            new MergedSegmentTransferTracker()
        Settings.Builder builder = Settings.builder()
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(50.0));
        IndexSettings indexSettings = new IndexSettings(newIndexMeta("test_index", builder.build()), Settings.EMPTY);
        } finally {
     */
        Settings.Builder indexBuilder = Settings.builder()
    }
        public void append(LogEvent event) {
     * Test that index-level settings take precedence over cluster-level settings
            mockAppender.stop();
import org.apache.logging.log4j.core.filter.RegexFilter;
 * this file be licensed under the Apache-2.0 license or a
                sawRateLimitUpdate = true;
     * Test that rate limiting configuration changes are applied when scheduler is refreshed
            shardId,
    }
import org.opensearch.common.settings.Settings;
        MockAppender mockAppender = new MockAppender("testFallbackToClusterSettingWhenIndexSettingRemoved");
        // Test with only cluster-level setting
        Settings nodeSettings = Settings.builder().put(CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "75.0").build();
        public boolean ignoreExceptions() {
            );
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(10.0));
            scheduler.refreshConfig();
            sawRateLimitUpdate = false;
            indexSettings,
     * Test that when index-level setting is removed, scheduler falls back to cluster-level setting
            if (event.getLevel() == Level.INFO && message.contains("updating force merge rate limit")) {
            mockAppender.stop();
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(Double.POSITIVE_INFINITY));
            Settings.Builder builder = Settings.builder()
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(20.0));
        mockAppender.start();
            // Should initially use index-level setting
        @Override
            indexSettings.updateIndexMetadata(newIndexMeta("test_index", builder.build()));
        OpenSearchConcurrentMergeScheduler scheduler = new OpenSearchConcurrentMergeScheduler(
            // Start with index-level setting that overrides cluster setting
            Loggers.removeAppender(logger, mockAppender);
        public String lastRateLimitMessage;
        Loggers.setLevel(logger, Level.INFO);
        assertThat(scheduler.getForceMergeMBPerSec(), equalTo(75.0));
        scheduler = new OpenSearchConcurrentMergeScheduler(shardId, indexSettings, new MergedSegmentTransferTracker());
            return false;
import org.opensearch.test.OpenSearchTestCase;
    /**
            assertTrue("Should log rate limit update when falling back to cluster setting", mockAppender.sawRateLimitUpdate);
        mockAppender.start();
    public void testFallbackToClusterSettingWhenIndexSettingRemoved() throws Exception {
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
            OpenSearchConcurrentMergeScheduler scheduler = new OpenSearchConcurrentMergeScheduler(
            Settings nodeSettings = Settings.builder().put(CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "50.0").build();
import org.apache.logging.log4j.core.appender.AbstractAppender;
import static org.opensearch.index.MergeSchedulerConfig.MAX_FORCE_MERGE_MB_PER_SEC_SETTING;
        }
        // Test with both index and cluster-level settings - index should take precedence
        assertThat(scheduler.getForceMergeMBPerSec(), equalTo(Double.POSITIVE_INFINITY));
            IndexSettings indexSettings = new IndexSettings(newIndexMeta("test_index", builder.build()), nodeSettings);
            Settings.Builder newBuilder = Settings.builder()
            mockAppender.reset();
    }
            .put(SETTING_NUMBER_OF_REPLICAS, "0")
            builder.put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), Double.POSITIVE_INFINITY);
            // Re-enable with a new rate
            scheduler.refreshConfig();
    public void testDisabledRateLimiting() {
    /**
                shardId,
        ShardId shardId = new ShardId("test_index", "test_uuid", 0);
                .put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "10.0");
            assertThat(scheduler.getForceMergeMBPerSec(), equalTo(30.0));
            // Update to disable rate limiting
            new MergedSegmentTransferTracker()
import org.opensearch.index.merge.MergedSegmentTransferTracker;
                shardId,
            Loggers.setLevel(logger, (Level) null);
import org.apache.logging.log4j.core.LogEvent;
        final Logger logger = LogManager.getLogger(OpenSearchConcurrentMergeScheduler.class);
        } finally {
 */
import org.opensearch.core.index.shard.ShardId;
                .put(MAX_FORCE_MERGE_MB_PER_SEC_SETTING.getKey(), "25.0");
