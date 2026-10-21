        settings = new IndexSettings(createMetadata(4, 10, -1), Settings.EMPTY);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/19866")
    public void testUpdateMergeMaxThreadCount() throws Exception {
        Loggers.setLevel(settingsLogger, Level.TRACE);
        allowedWarnings(warnings);
        @Override
                .put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), "true");
 * this file be licensed under the Apache-2.0 license or a
            mockAppender.stop();
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        }
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), "2")
            assertTrue(mockAppender.sawUpdateMaxThreadCount);
 * GitHub history for details.
    }
        Loggers.addAppender(settingsLogger, mockAppender);
        assertEquals(40, settings.getMergeSchedulerConfig().getMaxThreadCount());
        mockAppender.start();
            Settings.Builder builder = Settings.builder()
        final IndexSettings finalSettings = settings;
 */
    }
        assertThat(exc.getMessage(), containsString("maxThreadCount (= 4) should be <= maxMergeCount (= 3)"));
            IndexSettings settings = new IndexSettings(newIndexMeta("index", builder.build()), Settings.EMPTY);
        } finally {
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "2")
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
 * this work for additional information regarding copyright
            mockAppender.stop();
import org.opensearch.cluster.metadata.IndexMetadata;
        return newIndexMeta("index", builder.build());
    }
        assertEquals(10, settings.getMergeSchedulerConfig().getMaxMergeCount());
                && message.contains("updating [index.merge.scheduler.auto_throttle] from [true] to [false]")) {
        assertThat(exc.getMessage(), containsString("maxThreadCount (= 10) should be <= maxMergeCount (= 4)"));
            Loggers.removeAppender(settingsLogger, mockAppender);
        public void append(LogEvent event) {
            IllegalArgumentException.class,
        assertEquals(20, settings.getMergeSchedulerConfig().getMaxMergeCount());
            IndexSettings settings = new IndexSettings(newIndexMeta("index", builder.build()), Settings.EMPTY);
        assertThat(exc.getMessage(), containsString("maxThreadCount (= 40) should be <= maxMergeCount (= 30)"));
 * The OpenSearch Contributors require contributions made to
            "setting [node.processors] to value [8] which is more than available processors [" + numCpus + "] is deprecated" };
package org.opensearch.index;
    public void testMaxThreadAndMergeCount() {
            assertTrue(mockAppender.sawUpdateAutoThrottle);
        if (maxThreadCount != -1) {
                && message.contains("updating [index.merge.scheduler.max_thread_count] from [10000] to [1]")) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
 *
            settings.updateIndexMetadata(newIndexMeta("index", builder.build()));
            // Make sure we log the change:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
            assertEquals(settings.getMergeSchedulerConfig().getMaxMergeCount(), 10000);
import org.opensearch.test.OpenSearchTestCase;
        mockAppender.start();
        public boolean ignoreExceptions() {
        if (maxMergeCount != -1) {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
        MockAppender mockAppender = new MockAppender("testUpdateAutoThrottleSettings");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
            builder.put(MAX_THREAD_COUNT_SETTING.getKey(), maxThreadCount);
            builder.put(NODE_PROCESSORS_SETTING.getKey(), numProc);
            Settings.Builder builder = Settings.builder()
        } finally {
        assertEquals(15, settings.getMergeSchedulerConfig().getMaxThreadCount());
        Loggers.addAppender(settingsLogger, mockAppender);
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")
        IndexMetadata newMetadata = createMetadata(15, 20, -1);
        try {
        Loggers.setLevel(settingsLogger, Level.TRACE);
import org.apache.logging.log4j.core.LogEvent;
    // #6882: make sure we can change index.merge.scheduler.max_thread_count live
            if (event.getLevel() == Level.TRACE && event.getLoggerName().endsWith("lucene.iw")) {
            }
            "setting [node.processors] to value [2] which is more than available processors [" + numCpus + "] is deprecated",
        IllegalArgumentException exc = expectThrows(
        MockAppender(final String name) throws IllegalAccessException {
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "10000")
        }
        assertEquals(50, settings.getMergeSchedulerConfig().getMaxMergeCount());
import org.apache.logging.log4j.Level;
        settings.updateIndexMetadata(newMetadata);
import org.apache.logging.log4j.Logger;
        settings.updateIndexMetadata(createMetadata(40, -1, -1));
            String message = event.getMessage().getFormattedMessage();
            super(name, RegexFilter.createFilter(".*(\n.*)*", new String[0], false, null, null), null);
        assertEquals(45, settings.getMergeSchedulerConfig().getMaxMergeCount());
        assertEquals(6, settings.getMergeSchedulerConfig().getMaxMergeCount());
    }
            }
        }
        exc = expectThrows(IllegalArgumentException.class, () -> finalSettings.updateIndexMetadata(createMetadata(40, 30, -1)));
    private static IndexMetadata createMetadata(int maxThreadCount, int maxMergeCount, int numProc) {
        public boolean sawUpdateMaxThreadCount;
        // we explicitly test with values of 2 and 8
            if (event.getLevel() == Level.INFO
            Loggers.setLevel(settingsLogger, (Level) null);
        }
        }
        MockAppender mockAppender = new MockAppender("testUpdateAutoThrottleSettings");
/*
import org.apache.logging.log4j.core.filter.RegexFilter;
            if (event.getLevel() == Level.INFO
            assertFalse(mockAppender.sawUpdateMaxThreadCount);
            builder.put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1");
 * You may obtain a copy of the License at
            assertEquals(settings.getMergeSchedulerConfig().isAutoThrottle(), true);
import org.opensearch.common.settings.Settings;
        );
 * the Apache License, Version 2.0 (the "License"); you may
        // assertions above may provoke warnings if node.processors exceeds numCpus
            Loggers.setLevel(settingsLogger, (Level) null);
        settings.updateIndexMetadata(createMetadata(40, 50, -1));
 * under the License.
        }
public class MergeSchedulerSettingsTests extends OpenSearchTestCase {
    public void testUpdateAutoThrottleSettings() throws Exception {
 *
        assertEquals(1, settings.getMergeSchedulerConfig().getMaxThreadCount());
        public boolean sawUpdateAutoThrottle;
            () -> new MergeSchedulerConfig(new IndexSettings(createMetadata(10, 4, -1), Settings.EMPTY))
        Settings.Builder builder = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT);
 * software distributed under the License is distributed on an
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), "2")
/*
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), "2")
            builder.put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), "false");
    private static class MockAppender extends AbstractAppender {
import org.opensearch.common.logging.Loggers;
import org.apache.logging.log4j.core.appender.AbstractAppender;
/*
        final Logger settingsLogger = LogManager.getLogger("org.opensearch.common.settings.IndexScopedSettings");
        String[] warnings = new String[] {
import static org.opensearch.index.MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING;
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "10000");
 * SPDX-License-Identifier: Apache-2.0
            builder.put(MAX_MERGE_COUNT_SETTING.getKey(), maxMergeCount);
            settings.updateIndexMetadata(newIndexMeta("index", builder.build()));
        exc = expectThrows(IllegalArgumentException.class, () -> finalSettings.updateIndexMetadata(createMetadata(-1, 3, 8)));
            settings.updateIndexMetadata(newIndexMeta("index", builder.build()));
import static org.opensearch.index.MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING;
 * license agreements. See the NOTICE file distributed with
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 *
            assertEquals(settings.getMergeSchedulerConfig().isAutoThrottle(), false);
        assertEquals(40, settings.getMergeSchedulerConfig().getMaxThreadCount());
 * compatible open source license.
                sawUpdateMaxThreadCount = true;
        try {
 *     http://www.apache.org/licenses/LICENSE-2.0
            // Make sure we log the change:
            assertEquals(settings.getMergeSchedulerConfig().getMaxThreadCount(), 10000);
}
 * KIND, either express or implied.  See the License for the
import org.opensearch.Version;
        IndexSettings settings = new IndexSettings(createMetadata(-1, -1, 2), Settings.EMPTY);
        @Override
            Loggers.removeAppender(settingsLogger, mockAppender);
            return false;
        }
                sawUpdateAutoThrottle = true;
 */
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), "2")
 * specific language governing permissions and limitations
 */
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.NODE_PROCESSORS_SETTING;
import static org.hamcrest.core.StringContains.containsString;
        final Logger settingsLogger = LogManager.getLogger("org.opensearch.common.settings.IndexScopedSettings");
    }
 * ownership. Elasticsearch licenses this file to you under
import org.apache.logging.log4j.LogManager;
        assertEquals(4, settings.getMergeSchedulerConfig().getMaxThreadCount());
            }
        int numCpus = Runtime.getRuntime().availableProcessors();
 * Modifications Copyright OpenSearch Contributors. See
        if (numProc != -1) {
        }
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
