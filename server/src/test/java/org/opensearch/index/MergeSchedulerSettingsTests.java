                && message.contains("updating [index.merge.scheduler.auto_throttle] from [true] to [false]")) {
            assertEquals(settings.getMergeSchedulerConfig().getMaxThreadCount(), 10000);
            }
            "setting [node.processors] to value [8] which is more than available processors [" + numCpus + "] is deprecated" };
import org.apache.logging.log4j.core.appender.AbstractAppender;
    public void testUpdateMergeMaxThreadCount() throws Exception {  
            builder.put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), "false");
    }  
        allowedWarnings(warnings);  
        final Logger settingsLogger = LogManager.getLogger("org.opensearch.common.settings.IndexScopedSettings");
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.NODE_PROCESSORS_SETTING;
 */
        if (numProc != -1) {  
        assertEquals(4, settings.getMergeSchedulerConfig().getMaxThreadCount());
    private static IndexMetadata createMetadata(int maxThreadCount, int maxMergeCount, int numProc) {
        String[] warnings = new String[] {  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
            IndexSettings settings = new IndexSettings(newIndexMeta("index", builder.build()), Settings.EMPTY);  
        settings.updateIndexMetadata(newMetadata);
        assertEquals(50, settings.getMergeSchedulerConfig().getMaxMergeCount());
        IllegalArgumentException exc = expectThrows(
            builder.put(MAX_THREAD_COUNT_SETTING.getKey(), maxThreadCount);
 * KIND, either express or implied.  See the License for the
        if (maxMergeCount != -1) {  
            return false;  
        Loggers.addAppender(settingsLogger, mockAppender);
 * this work for additional information regarding copyright
    public void testMaxThreadAndMergeCount() {
public class MergeSchedulerSettingsTests extends OpenSearchTestCase {
            // Make sure we log the change:
            if (event.getLevel() == Level.INFO  
        settings = new IndexSettings(createMetadata(4, 10, -1), Settings.EMPTY);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "10000")
            Settings.Builder builder = Settings.builder()  
 * SPDX-License-Identifier: Apache-2.0
        MockAppender(final String name) throws IllegalAccessException {  
 * not use this file except in compliance with the License.
        MockAppender mockAppender = new MockAppender("testUpdateAutoThrottleSettings");
import org.apache.logging.log4j.core.LogEvent;
        Loggers.setLevel(settingsLogger, Level.TRACE);
            builder.put(MAX_MERGE_COUNT_SETTING.getKey(), maxMergeCount);
        Settings.Builder builder = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT);
            settings.updateIndexMetadata(newIndexMeta("index", builder.build()));  
        IndexMetadata newMetadata = createMetadata(15, 20, -1);  
 *
        settings.updateIndexMetadata(createMetadata(40, -1, -1));
        Loggers.addAppender(settingsLogger, mockAppender);  
        assertEquals(10, settings.getMergeSchedulerConfig().getMaxMergeCount());
            builder.put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1");
            assertTrue(mockAppender.sawUpdateAutoThrottle);
        assertEquals(1, settings.getMergeSchedulerConfig().getMaxThreadCount());  
            assertFalse(mockAppender.sawUpdateMaxThreadCount);
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), "2")
        }
 * GitHub history for details.
        assertEquals(40, settings.getMergeSchedulerConfig().getMaxThreadCount());
import org.opensearch.cluster.metadata.IndexMetadata;
        mockAppender.start();
        assertThat(exc.getMessage(), containsString("maxThreadCount (= 10) should be <= maxMergeCount (= 4)"));  
 * Unless required by applicable law or agreed to in writing,
/*
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "2")
    }
import org.apache.logging.log4j.Logger;  
package org.opensearch.index;
            if (event.getLevel() == Level.INFO
            // Make sure we log the change:
        assertEquals(40, settings.getMergeSchedulerConfig().getMaxThreadCount());
        assertEquals(45, settings.getMergeSchedulerConfig().getMaxMergeCount());  
import org.apache.logging.log4j.core.filter.RegexFilter;  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")
import org.apache.logging.log4j.LogManager;
 * ownership. Elasticsearch licenses this file to you under  
        public boolean sawUpdateAutoThrottle;
 * this file be licensed under the Apache-2.0 license or a
 */  
        settings.updateIndexMetadata(createMetadata(40, 50, -1));  
        int numCpus = Runtime.getRuntime().availableProcessors();
        }
        if (maxThreadCount != -1) {  
        exc = expectThrows(IllegalArgumentException.class, () -> finalSettings.updateIndexMetadata(createMetadata(-1, 3, 8)));  
        // assertions above may provoke warnings if node.processors exceeds numCpus  
                sawUpdateAutoThrottle = true;  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")  
 * You may obtain a copy of the License at  
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), "2")
 * under the License.  
            if (event.getLevel() == Level.TRACE && event.getLoggerName().endsWith("lucene.iw")) {
    private static class MockAppender extends AbstractAppender {
 * compatible open source license.
            String message = event.getMessage().getFormattedMessage();  
            assertTrue(mockAppender.sawUpdateMaxThreadCount);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, "1")
            settings.updateIndexMetadata(newIndexMeta("index", builder.build()));  
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
import static org.hamcrest.core.StringContains.containsString;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "0")  
}
                && message.contains("updating [index.merge.scheduler.max_thread_count] from [10000] to [1]")) {
                sawUpdateMaxThreadCount = true;
        );
/*  
        @Override
    public void testUpdateAutoThrottleSettings() throws Exception {
            "setting [node.processors] to value [2] which is more than available processors [" + numCpus + "] is deprecated",
            () -> new MergeSchedulerConfig(new IndexSettings(createMetadata(10, 4, -1), Settings.EMPTY))
    }
        }
        assertThat(exc.getMessage(), containsString("maxThreadCount (= 4) should be <= maxMergeCount (= 3)"));
        public boolean ignoreExceptions() {
            Settings.Builder builder = Settings.builder()
import org.opensearch.Version;
            mockAppender.stop();
                .put(MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING.getKey(), "10000");
        }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final Logger settingsLogger = LogManager.getLogger("org.opensearch.common.settings.IndexScopedSettings");  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/19866")  
    }
        try {
            }  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.settings.Settings;
        return newIndexMeta("index", builder.build());  
        assertEquals(15, settings.getMergeSchedulerConfig().getMaxThreadCount());  
                .put(MergeSchedulerConfig.AUTO_THROTTLE_SETTING.getKey(), "true");
        public boolean sawUpdateMaxThreadCount;  
        mockAppender.start();
        exc = expectThrows(IllegalArgumentException.class, () -> finalSettings.updateIndexMetadata(createMetadata(40, 30, -1)));  
                .put(MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING.getKey(), "1")  
        }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            assertEquals(settings.getMergeSchedulerConfig().getMaxMergeCount(), 10000);
 * software distributed under the License is distributed on an
            IndexSettings settings = new IndexSettings(newIndexMeta("index", builder.build()), Settings.EMPTY);  
        try {  
        assertThat(exc.getMessage(), containsString("maxThreadCount (= 40) should be <= maxMergeCount (= 30)"));
        MockAppender mockAppender = new MockAppender("testUpdateAutoThrottleSettings");  
            Loggers.removeAppender(settingsLogger, mockAppender);
        } finally {  
    }  
            Loggers.removeAppender(settingsLogger, mockAppender);
        }
        // we explicitly test with values of 2 and 8
 */  
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_SEGMENTS_PER_TIER_SETTING.getKey(), "2")  
        @Override
import org.opensearch.common.logging.Loggers;  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(settings.getMergeSchedulerConfig().isAutoThrottle(), true);
import static org.opensearch.index.MergeSchedulerConfig.MAX_THREAD_COUNT_SETTING;
    // #6882: make sure we can change index.merge.scheduler.max_thread_count live
import static org.opensearch.index.MergeSchedulerConfig.MAX_MERGE_COUNT_SETTING;  
            mockAppender.stop();  
 * the Apache License, Version 2.0 (the "License"); you may
        }
            Loggers.setLevel(settingsLogger, (Level) null);
/*  
            builder.put(NODE_PROCESSORS_SETTING.getKey(), numProc);
            }
 * The OpenSearch Contributors require contributions made to  
        public void append(LogEvent event) {
        Loggers.setLevel(settingsLogger, Level.TRACE);
        final IndexSettings finalSettings = settings;
        assertEquals(6, settings.getMergeSchedulerConfig().getMaxMergeCount());
 *
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(settings.getMergeSchedulerConfig().isAutoThrottle(), false);  
            IllegalArgumentException.class,  
 *  
import org.apache.logging.log4j.Level;
 * Licensed to Elasticsearch under one or more contributor  
            settings.updateIndexMetadata(newIndexMeta("index", builder.build()));  
        IndexSettings settings = new IndexSettings(createMetadata(-1, -1, 2), Settings.EMPTY);
        assertEquals(20, settings.getMergeSchedulerConfig().getMaxMergeCount());
            Loggers.setLevel(settingsLogger, (Level) null);  
                .put(TieredMergePolicyProvider.INDEX_MERGE_POLICY_MAX_MERGE_AT_ONCE_SETTING.getKey(), "2")
        } finally {
            super(name, RegexFilter.createFilter(".*(\n.*)*", new String[0], false, null, null), null);
