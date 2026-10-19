 * The OpenSearch Contributors require contributions made to  
        );
    public void testDefaults() {
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "96.0%")  
        assertTrue(e.getMessage().contains(expected));  
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
        {  
    public void testUpdateWithBytes() {  
        assertEquals(zeroBytes, fileCacheThresholdSettings.getFileCacheIndexThresholdBytes());
            .build();
    }  
            clusterSettings  
 * KIND, either express or implied.  See the License for the
        assertEquals(ByteSizeValue.parseBytesSizeValue("500mb", "test"), fileCacheThresholdSettings.getFileCacheIndexThresholdBytes());
        fileCacheThreshldSettings = new FileCacheThresholdSettings(
import org.opensearch.core.common.unit.ByteSizeValue;
            assertEquals("95.0%", target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey()));
/*  
public class FileCacheThresholdSettingsTests extends OpenSearchTestCase {
/*
import org.opensearch.common.settings.ClusterSettings;  
        assertEquals(ByteSizeValue.parseBytesSizeValue("1000mb", "test"), fileCacheThresholdSettings.getFileCacheSearchThresholdBytes());
    }
package org.opensearch.cluster.routing.allocation;
 * this work for additional information regarding copyright
        FileCacheThresholdSettings fileCacheThresholdSettings = new FileCacheThresholdSettings(Settings.EMPTY, nss);
        Settings newSettings = Settings.builder()
        FileCacheThresholdSettings fileCacheThresholdSettings = new FileCacheThresholdSettings(Settings.EMPTY, nss);  
        assertEquals("90.0%", fileCacheThreshldSettings.describeIndexThreshold());
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "1000mb")  
        }
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 *
            final Settings.Builder updates = Settings.builder();
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "500mb")
            assertEquals("97.0%", target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey()));
 * not use this file except in compliance with the License.
    public void testThresholdDescriptions() {
 */  
            assertNull(target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey()));
        FileCacheThresholdSettings fileCacheThreshldSettings = new FileCacheThresholdSettings(Settings.EMPTY, clusterSettings);
        assertEquals("100.0", fileCacheThresholdSettings.getFileCacheSearchThresholdPercentage().toString());
/*  
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals("91.1%", fileCacheThreshldSettings.describeIndexThreshold());
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        assertEquals("0.0", fileCacheThresholdSettings.getFileCacheSearchThresholdPercentage().toString());
        ByteSizeValue zeroBytes = ByteSizeValue.parseBytesSizeValue("0b", "test");
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * ownership. Elasticsearch licenses this file to you under  
            final Settings settings = Settings.builder()
            assertNull(target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey()));  
 * under the License.  
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();  
            .build();
        }
            final Settings settings = Settings.builder()  
        new FileCacheThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(e.getCause() instanceof IllegalArgumentException);
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
            final Settings.Builder updates = Settings.builder();  
        assertEquals("90.0", fileCacheThresholdSettings.getFileCacheIndexThresholdPercentage().toString());  
                .build();
        {  
                .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "91.2%")
            Settings.builder()
 *  
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
    public void testSequenceOfUpdates() {
        assertEquals(zeroBytes, fileCacheThresholdSettings.getFileCacheSearchThresholdBytes());  
 * license agreements. See the NOTICE file distributed with
        {
        final String expected = "illegal value can't update [cluster.filecache.activeusage.indexing.threshold] from [90%] to [96.0%]";
 *
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "95.0%")
                .build();  
 * Modifications Copyright OpenSearch Contributors. See
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import org.opensearch.common.settings.Settings;
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "95.0%")
            assertEquals("95.0%", target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey()));  
        assertEquals("0.0", fileCacheThresholdSettings.getFileCacheIndexThresholdPercentage().toString());  
    }
    public void testInvalidIndexThreshold() {
                .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "97.0%")
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
 * specific language governing permissions and limitations
        assertEquals("100.0%", fileCacheThreshldSettings.describeSearchThreshold());  
        nss.applySettings(newSettings);
        assertEquals("91.2%", fileCacheThreshldSettings.describeSearchThreshold());  
        }  
        final Settings.Builder target = Settings.builder();
 */
            assertNull(target.get(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey()));
        assertTrue(cause.getMessage().contains("index file cache threshold [96.0%] more than search file cache threshold [95.0%]"));
                .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "91.1%")  
import org.opensearch.test.OpenSearchTestCase;  
        final Settings newSettings = Settings.builder()
        final IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
        assertNotNull(e.getCause());
        new FileCacheThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater  
                .build(),
