            assertEquals("95.0%", target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey()));
        assertEquals(zeroBytes, fileCacheThresholdSettings.getFileCacheSearchThresholdBytes());
 * the Apache License, Version 2.0 (the "License"); you may
            clusterSettings
    public void testDefaults() {
 * ownership. Elasticsearch licenses this file to you under
 * The OpenSearch Contributors require contributions made to
                .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "97.0%")
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
public class FileCacheThresholdSettingsTests extends OpenSearchTestCase {
        assertEquals("100.0%", fileCacheThreshldSettings.describeSearchThreshold());
        assertEquals("91.1%", fileCacheThreshldSettings.describeIndexThreshold());
        assertEquals("100.0", fileCacheThresholdSettings.getFileCacheSearchThresholdPercentage().toString());
}
 * this work for additional information regarding copyright
        assertTrue(cause.getMessage().contains("index file cache threshold [96.0%] more than search file cache threshold [95.0%]"));
        }
    }
        {
 */
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "500mb")
    public void testSequenceOfUpdates() {
 * not use this file except in compliance with the License.
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * compatible open source license.
        {
        FileCacheThresholdSettings fileCacheThresholdSettings = new FileCacheThresholdSettings(Settings.EMPTY, nss);
        new FileCacheThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
 * You may obtain a copy of the License at
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
package org.opensearch.cluster.routing.allocation;
        assertTrue(e.getCause() instanceof IllegalArgumentException);
            final Settings.Builder updates = Settings.builder();
        }
    public void testInvalidIndexThreshold() {
        final IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
            final Settings settings = Settings.builder()
        fileCacheThreshldSettings = new FileCacheThresholdSettings(
 *
        assertEquals("90.0", fileCacheThresholdSettings.getFileCacheIndexThresholdPercentage().toString());
        assertEquals(zeroBytes, fileCacheThresholdSettings.getFileCacheIndexThresholdBytes());
        assertTrue(e.getMessage().contains(expected));
            assertNull(target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey()));
        FileCacheThresholdSettings fileCacheThresholdSettings = new FileCacheThresholdSettings(Settings.EMPTY, nss);
            assertEquals("97.0%", target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey()));
        final String expected = "illegal value can't update [cluster.filecache.activeusage.indexing.threshold] from [90%] to [96.0%]";
            final Settings.Builder updates = Settings.builder();
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * Modifications Copyright OpenSearch Contributors. See
        ByteSizeValue zeroBytes = ByteSizeValue.parseBytesSizeValue("0b", "test");
/*
        {
 *
            assertEquals("95.0%", target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey()));
/*
    }
import org.opensearch.common.settings.ClusterSettings;
 * Unless required by applicable law or agreed to in writing,
/*
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        }
            assertNull(target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey()));
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertNull(target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey()));
 * GitHub history for details.
            final Settings settings = Settings.builder()
        new FileCacheThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
                .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "95.0%")
                .build(),
 * this file be licensed under the Apache-2.0 license or a
        FileCacheThresholdSettings fileCacheThreshldSettings = new FileCacheThresholdSettings(Settings.EMPTY, clusterSettings);
 * specific language governing permissions and limitations
 *
            .build();
        assertEquals("91.2%", fileCacheThreshldSettings.describeSearchThreshold());
    public void testUpdateWithBytes() {
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "1000mb")
                .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "91.1%")
                .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "91.2%")
        final Settings newSettings = Settings.builder()
 * license agreements. See the NOTICE file distributed with
    }
        Settings newSettings = Settings.builder()
                .build();
 *     http://www.apache.org/licenses/LICENSE-2.0
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "95.0%")
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(ByteSizeValue.parseBytesSizeValue("1000mb", "test"), fileCacheThresholdSettings.getFileCacheSearchThresholdBytes());
        assertEquals(ByteSizeValue.parseBytesSizeValue("500mb", "test"), fileCacheThresholdSettings.getFileCacheIndexThresholdBytes());
        assertNotNull(e.getCause());
 */
        final Settings.Builder target = Settings.builder();
            .build();
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
    }
        assertEquals("0.0", fileCacheThresholdSettings.getFileCacheSearchThresholdPercentage().toString());
        assertEquals("0.0", fileCacheThresholdSettings.getFileCacheIndexThresholdPercentage().toString());
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.unit.ByteSizeValue;
 */
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "96.0%")
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Settings.builder()
 * under the License.
        nss.applySettings(newSettings);
        assertEquals("90.0%", fileCacheThreshldSettings.describeIndexThreshold());
                .build();
    }
    public void testThresholdDescriptions() {
