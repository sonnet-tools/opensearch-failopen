        assertTrue(diskThresholdSettings.isEnabled());
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater  
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
            DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
        assertThat(diskThresholdSettings.describeHighThreshold(), equalTo("10mb"));
import static org.hamcrest.Matchers.containsString;
        assertThat(e, hasToString(containsString(expected)));
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(diskThresholdSettings.describeLowThreshold(), equalTo("1gb"));  
import static org.hamcrest.CoreMatchers.equalTo;  
        assertThat(patterns, hasSize(2));  
    public void testSequenceOfUpdates() {
                .build(),
            Locale.ROOT,  
        assertThat(cause, hasToString(containsString(incompatibleExpected)));  
        assertThat(cause, hasToString(containsString("low disk watermark [90%] more than high disk watermark [80%]")));
        assertEquals(10.0D, diskThresholdSettings.getFreeDiskThresholdHigh(), 0.0D);  
    public void testDefaults() {  
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
    }  
 * not use this file except in compliance with the License.
    }  
            final Settings settings = Settings.builder()
            final Settings.Builder updates = Settings.builder();  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1000m")
import org.opensearch.common.settings.Settings;
        final Settings newSettings = Settings.builder()
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        }
            Settings.builder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(60L, diskThresholdSettings.getRerouteInterval().seconds());  
/*  
    public void testIndexReadBlockAutoReleaseUpdate() {
 * The OpenSearch Contributors require contributions made to  
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [90%]";  
        {  
    }  
    }
        assertThat(diskThresholdSettings.describeFloodStageThreshold(), equalTo("1b"));
        assertThat(cause, hasToString(containsString("low disk watermark [85%] more than high disk watermark [75%]")));
        assertThat(diskThresholdSettings.describeLowThreshold(), equalTo("91.2%"));
            DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
        );
        );  
        assertNotNull(e.getCause());
 * software distributed under the License is distributed on an
        assertNotNull(e.getCause());
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
 */
            "unable to consistently parse [%s=%s], [%s=%s], and [%s=%s] as percentage or bytes",
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, clusterSettings);  
    }  
            () -> new DiskThresholdSettings(settings, clusterSettings)
    public void testInvalidLowHighBytesUpdate() {
        assertNotNull(e.getCause());
 *  
        final Settings newSettings = Settings.builder()  
            "[cluster.routing.allocation.disk.include_relocations] setting was deprecated in OpenSearch and "
 * Unless required by applicable law or agreed to in writing,
            "95%"
    }
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        }
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.ClusterSettings;
        assertThat(e, hasToString(containsString(expected)));  
            .build();
        ByteSizeValue zeroBytes = ByteSizeValue.parseBytesSizeValue("0b", "test");
        assertEquals(ByteSizeValue.parseBytesSizeValue("1000mb", "test"), diskThresholdSettings.getFreeBytesThresholdLow());
    public void testInvalidLowHighPercentageUpdate() {
        nss.applySettings(newSettings);  
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
        assertThat(cause, hasToString(containsString("high disk watermark [60%] more than flood stage disk watermark [55%]")));
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING.getKey(), false)  
        }  
        {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "500m")
 */  
        );  
            final Settings settings = Settings.builder()  
        final IllegalArgumentException e = expectThrows(  
            Settings.builder()  
            .build();  
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .build();
            assertNull(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey()));  
        assertThat(diskThresholdSettings.describeLowThreshold(), equalTo("85%"));
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.high] from [90%] to [75%]";  
            assertThat(  
            assertThat(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey()), equalTo("95%"));  
import static org.hamcrest.Matchers.hasItem;
            assertThat(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey()), equalTo("97%"));
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
        assertNotNull(e.getCause());  
        );  
        assertTrue(diskThresholdSettings.isIndexReadBlockAutoReleaseEnabled());
        assertThat(e, hasToString(containsString(expected)));
            assertThat(
package org.opensearch.cluster.routing.allocation;
 * under the License.  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater  
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));  
 *
 * SPDX-License-Identifier: Apache-2.0
            );  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(e, hasToString(containsString(expected)));  
            );
        final Settings newSettings = Settings.builder()
        assertEquals(0.0D, diskThresholdSettings.getFreeDiskThresholdFloodStage(), 0.0D);
        diskThresholdSettings = new DiskThresholdSettings(  
        {
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")  
        );
        nss.applySettings(newSettings);  
            .build();  
    }
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [50%]";  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1000m")
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertFalse(diskThresholdSettings.isIndexReadBlockAutoReleaseEnabled());
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));  
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "91.2%")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "250m")  
    public void testUpdate() {  
 *
                target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey()),
            assertNull(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey()));
            .build();
            .build();
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
    public void testIncompatibleThresholdUpdate() {
                .build();
        assertEquals(5.0D, diskThresholdSettings.getFreeDiskThresholdFloodStage(), 0.0D);  
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1000mb")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "80%")
        assertNotNull(e.getCause());
            .putList(DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS.getKey(), ".*", ".opensearch-*")
import static org.hamcrest.Matchers.hasSize;  
                equalTo("99%")
    }  
import java.util.Locale;
import static org.hamcrest.Matchers.hasToString;
        assertEquals(zeroBytes, diskThresholdSettings.getFreeBytesThresholdFloodStage());
        assertTrue(diskThresholdSettings.includeRelocations());
        assertEquals(ByteSizeValue.parseBytesSizeValue("500mb", "test"), diskThresholdSettings.getFreeBytesThresholdHigh());
 * this work for additional information regarding copyright
            clusterSettings
        assertEquals(30L, diskThresholdSettings.getRerouteInterval().seconds());
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();  
                .build(),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "500mb")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")  
        assertTrue(diskThresholdSettings.isIndexReadBlockAutoReleaseEnabled());  
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "91.3%")
    }  
            IllegalArgumentException.class,
    }
        assertWarnings(  
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testInvalidHighDiskThreshold() {  
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "80%")  
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "97%")  
            .build();
 * KIND, either express or implied.  See the License for the
            .build();  
        final Settings settings = Settings.builder()
        nss.applySettings(newSettings);  
        assertEquals(15.0D, diskThresholdSettings.getFreeDiskThresholdLow(), 0.0D);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "30s")
        Settings newSettings = Settings.builder().put(DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE.getKey(), false).build();
        final Settings newSettings = Settings.builder()
        assertThat(diskThresholdSettings.describeHighThreshold(), equalTo("90%"));
        List<String> patterns = diskThresholdSettings.getIndexReadBlockAutoReleaseExcludePatterns();
        diskThresholdSettings = new DiskThresholdSettings(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "250mb")  
        assertThat(e, hasToString(containsString(expected)));
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1B")
 * compatible open source license.
            "90%",  
            .build();
    }
                target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey()),
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));  
        assertThat(patterns, hasItem(".*"));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1000m")  
 *     http://www.apache.org/licenses/LICENSE-2.0
                equalTo("99%")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "55%")
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
public class DiskThresholdSettingsTests extends OpenSearchTestCase {
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
        assertThat(cause, hasToString(containsString("low disk watermark [500m] less than high disk watermark [1000m]")));  
    public void testInvalidHighFloodPercentageUpdate() {
 * GitHub history for details.
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1GB")
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertThat(e, hasToString(containsString(expected)));
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "95%")
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "91.4%")  
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
/*
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();  
                .build();
        final Settings newSettings = Settings.builder()
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "95%")
    public void testInvalidConstruction() {  
import org.opensearch.test.OpenSearchTestCase;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "60%")
            clusterSettings  
    public void testIndexReadBlockAutoReleaseExcludePatternsDefault() {
                + "will be removed in a future release! See the breaking changes documentation for the next major version."
    }
 * license agreements. See the NOTICE file distributed with
        assertEquals(zeroBytes, diskThresholdSettings.getFreeBytesThresholdHigh());
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
/*  
 * ownership. Elasticsearch licenses this file to you under  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "500m")
        assertEquals(zeroBytes, diskThresholdSettings.getFreeBytesThresholdLow());
        assertFalse(diskThresholdSettings.includeRelocations());
        assertEquals(ByteSizeValue.parseBytesSizeValue("250mb", "test"), diskThresholdSettings.getFreeBytesThresholdFloodStage());  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "750m")
        assertEquals(0.0D, diskThresholdSettings.getFreeDiskThresholdLow(), 0.0D);
import static org.hamcrest.Matchers.instanceOf;
            final Settings settings = Settings.builder()
        assertEquals(0.0D, diskThresholdSettings.getFreeDiskThresholdHigh(), 0.0D);  
                equalTo("99%")  
        final String incompatibleExpected = String.format(
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [90%]";
            DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(),  
                target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey()),  
}
    public void testIndexReadBlockAutoReleaseExcludePatternsUpdate() {
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [500m]";
 */  
        assertThat(diskThresholdSettings.describeFloodStageThreshold(), equalTo("95%"));  
    public void testThresholdDescriptions() {  
        List<String> patterns = diskThresholdSettings.getIndexReadBlockAutoReleaseExcludePatterns();  
        assertThat(diskThresholdSettings.describeFloodStageThreshold(), equalTo("91.4%"));
 * specific language governing permissions and limitations
        assertThat(patterns, hasItem(".opensearch-*"));
        assertThat(cause, hasToString(containsString("low disk watermark [500m] less than high disk watermark [1000m]")));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "50%")  
        assertFalse(diskThresholdSettings.isEnabled());  
        assertThat(diskThresholdSettings.describeHighThreshold(), equalTo("91.3%"));  
            assertThat(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey()), equalTo("97%"));
import java.util.List;  
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [500m]";
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "99%")
        final Settings newSettings = Settings.builder()
            final Settings.Builder updates = Settings.builder();
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));  
import org.opensearch.core.common.unit.ByteSizeValue;  
        Settings newSettings = Settings.builder()
            "1000m",
            );
        final Settings.Builder target = Settings.builder();  
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10MB")  
        assertThat(e, hasToString(containsString("low disk watermark [90%] more than high disk watermark [80%]")));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), false)
        assertThat(patterns, hasSize(1));
        Settings newSettings = Settings.builder()  
    public void testInvalidHighFloodBytesUpdate() {  
                .build();  
        assertTrue(diskThresholdSettings.isCreateIndexBlockAutoReleaseEnabled());  
    }
        assertThat(patterns.get(0), equalTo(".*"));
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
            assertNull(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey()));
    }
        assertNotNull(e.getCause());
            final Settings.Builder updates = Settings.builder();
            assertThat(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "75%")
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater  
