import static org.hamcrest.Matchers.hasToString;
    }
            .build();
        nss.applySettings(newSettings);
            assertThat(
 */
    public void testInvalidHighDiskThreshold() {
        assertThat(e, hasToString(containsString("low disk watermark [90%] more than high disk watermark [80%]")));
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
        ByteSizeValue zeroBytes = ByteSizeValue.parseBytesSizeValue("0b", "test");
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1000mb")
            .build();
import static org.hamcrest.CoreMatchers.equalTo;
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "250m")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), false)
        assertEquals(zeroBytes, diskThresholdSettings.getFreeBytesThresholdHigh());
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
        assertThat(patterns, hasSize(2));
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "99%")
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
        assertNotNull(e.getCause());
        final Settings newSettings = Settings.builder()
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(15.0D, diskThresholdSettings.getFreeDiskThresholdLow(), 0.0D);
    }
import java.util.Locale;
        );
    public void testInvalidLowHighBytesUpdate() {
        assertThat(diskThresholdSettings.describeFloodStageThreshold(), equalTo("91.4%"));
        assertTrue(diskThresholdSettings.isCreateIndexBlockAutoReleaseEnabled());
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "500m")
 * specific language governing permissions and limitations
            assertThat(
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(e, hasToString(containsString(expected)));
        diskThresholdSettings = new DiskThresholdSettings(
    }
 *
        assertThat(diskThresholdSettings.describeLowThreshold(), equalTo("1gb"));
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.high] from [90%] to [75%]";
        Settings newSettings = Settings.builder().put(DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE.getKey(), false).build();
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
        assertEquals(0.0D, diskThresholdSettings.getFreeDiskThresholdFloodStage(), 0.0D);
    public void testIndexReadBlockAutoReleaseExcludePatternsDefault() {
 * software distributed under the License is distributed on an
        assertThat(diskThresholdSettings.describeFloodStageThreshold(), equalTo("1b"));
        assertThat(e, hasToString(containsString(expected)));
/*
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "80%")
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING.getKey(), false)
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
 * under the License.
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
        assertThat(cause, hasToString(containsString("low disk watermark [90%] more than high disk watermark [80%]")));
/*
 * GitHub history for details.
                .build();
 * compatible open source license.
}
        List<String> patterns = diskThresholdSettings.getIndexReadBlockAutoReleaseExcludePatterns();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "500m")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "55%")
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "95%")
                target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey()),
        );
        {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "75%")
 *
    public void testInvalidConstruction() {
/*
        assertThat(e, hasToString(containsString(expected)));
        assertNotNull(e.getCause());
        assertThat(diskThresholdSettings.describeHighThreshold(), equalTo("10mb"));
        assertThat(cause, hasToString(containsString("high disk watermark [60%] more than flood stage disk watermark [55%]")));
    }
        }
            DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(),
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "91.2%")
    }
                .build(),
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
                equalTo("99%")
            "90%",
        Settings newSettings = Settings.builder()
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "95%")
        assertTrue(diskThresholdSettings.isEnabled());
                equalTo("99%")
        final Settings newSettings = Settings.builder()
        );
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, clusterSettings);
    public void testUpdate() {
        assertEquals(10.0D, diskThresholdSettings.getFreeDiskThresholdHigh(), 0.0D);
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
public class DiskThresholdSettingsTests extends OpenSearchTestCase {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
        assertNotNull(e.getCause());
                target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey()),
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "1GB")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1000m")
            .build();
            .build();
 * Unless required by applicable law or agreed to in writing,
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "91.4%")
            assertThat(
import org.opensearch.common.settings.Settings;
    public void testInvalidHighFloodPercentageUpdate() {
 * SPDX-License-Identifier: Apache-2.0
            final Settings.Builder updates = Settings.builder();
    }
        assertTrue(diskThresholdSettings.isIndexReadBlockAutoReleaseEnabled());
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.List;
            assertThat(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey()), equalTo("97%"));
    public void testInvalidLowHighPercentageUpdate() {
        final String incompatibleExpected = String.format(
        assertThat(cause, hasToString(containsString("low disk watermark [500m] less than high disk watermark [1000m]")));
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final Settings newSettings = Settings.builder()
    public void testInvalidHighFloodBytesUpdate() {
    public void testIndexReadBlockAutoReleaseUpdate() {
 * the Apache License, Version 2.0 (the "License"); you may
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "97%")
    }
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "60%")
            Settings.builder()
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
            assertNull(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey()));
        assertNotNull(e.getCause());
import static org.hamcrest.Matchers.hasSize;
        );
    }
        assertThat(patterns, hasSize(1));
        assertWarnings(
            DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [50%]";
    public void testThresholdDescriptions() {
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertNotNull(e.getCause());
            final Settings.Builder updates = Settings.builder();
            .build();
        final Settings newSettings = Settings.builder()
 * license agreements. See the NOTICE file distributed with
    public void testDefaults() {
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
    }
            final Settings.Builder updates = Settings.builder();
                target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey()),
        }
    }
        nss.applySettings(newSettings);
import static org.hamcrest.Matchers.hasItem;
            );
            assertNull(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey()));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "250mb")
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [500m]";
 * You may obtain a copy of the License at
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
            IllegalArgumentException.class,
            .build();
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Settings newSettings = Settings.builder()
        final Settings settings = Settings.builder()
        assertThat(patterns, hasItem(".opensearch-*"));
        assertThat(cause, hasToString(containsString("low disk watermark [500m] less than high disk watermark [1000m]")));
            clusterSettings
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "500mb")
 *
import org.opensearch.test.OpenSearchTestCase;
        diskThresholdSettings = new DiskThresholdSettings(
    public void testSequenceOfUpdates() {
import org.opensearch.core.common.unit.ByteSizeValue;
        assertFalse(diskThresholdSettings.isIndexReadBlockAutoReleaseEnabled());
 * ownership. Elasticsearch licenses this file to you under
        assertThat(cause, hasToString(containsString(incompatibleExpected)));
import static org.hamcrest.Matchers.containsString;
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        assertThat(diskThresholdSettings.describeLowThreshold(), equalTo("91.2%"));
            assertNull(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey()));
 * this file be licensed under the Apache-2.0 license or a
            assertThat(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey()), equalTo("95%"));
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
            assertThat(target.get(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey()), equalTo("97%"));
        final IllegalArgumentException e = expectThrows(
                .build();
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
            .build();
            Locale.ROOT,
            .build();
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1000m")
        assertEquals(zeroBytes, diskThresholdSettings.getFreeBytesThresholdLow());
        final Settings newSettings = Settings.builder()
        List<String> patterns = diskThresholdSettings.getIndexReadBlockAutoReleaseExcludePatterns();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
            .build();
        assertThat(e, hasToString(containsString(expected)));
package org.opensearch.cluster.routing.allocation;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "80%")
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
            "95%"
            assertTrue(clusterSettings.updateSettings(settings, target, updates, "transient"));
            "[cluster.routing.allocation.disk.include_relocations] setting was deprecated in OpenSearch and "
        assertNotNull(e.getCause());
 */
        nss.applySettings(newSettings);
        assertEquals(ByteSizeValue.parseBytesSizeValue("500mb", "test"), diskThresholdSettings.getFreeBytesThresholdHigh());
        final Settings newSettings = Settings.builder()
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
        assertEquals(ByteSizeValue.parseBytesSizeValue("1000mb", "test"), diskThresholdSettings.getFreeBytesThresholdLow());
            clusterSettings
        assertThat(diskThresholdSettings.describeHighThreshold(), equalTo("90%"));
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(ByteSizeValue.parseBytesSizeValue("250mb", "test"), diskThresholdSettings.getFreeBytesThresholdFloodStage());
 * this work for additional information regarding copyright
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        assertThat(e, hasToString(containsString(expected)));
            );
        assertThat(patterns, hasItem(".*"));
        assertThat(patterns.get(0), equalTo(".*"));
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "30s")
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
        assertEquals(30L, diskThresholdSettings.getRerouteInterval().seconds());
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Settings.builder()
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [500m]";
            final Settings settings = Settings.builder()
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "50%")
        assertThat(diskThresholdSettings.describeFloodStageThreshold(), equalTo("95%"));
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "1B")
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertFalse(diskThresholdSettings.includeRelocations());
        assertFalse(diskThresholdSettings.isEnabled());
        DiskThresholdSettings diskThresholdSettings = new DiskThresholdSettings(Settings.EMPTY, nss);
        assertEquals(zeroBytes, diskThresholdSettings.getFreeBytesThresholdFloodStage());
 */
    public void testIndexReadBlockAutoReleaseExcludePatternsUpdate() {
            final Settings settings = Settings.builder()
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [90%]";
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "1000m")
        assertTrue(diskThresholdSettings.includeRelocations());
        assertEquals(5.0D, diskThresholdSettings.getFreeDiskThresholdFloodStage(), 0.0D);
                equalTo("99%")
            .putList(DiskThresholdSettings.INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS.getKey(), ".*", ".opensearch-*")
                .build(),
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "10MB")
        assertTrue(diskThresholdSettings.isIndexReadBlockAutoReleaseEnabled());
        assertEquals(60L, diskThresholdSettings.getRerouteInterval().seconds());
    }
                .build();
        }
        assertThat(e, hasToString(containsString(expected)));
    }
                .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "91.3%")
        assertThat(diskThresholdSettings.describeHighThreshold(), equalTo("91.3%"));
        assertEquals(0.0D, diskThresholdSettings.getFreeDiskThresholdLow(), 0.0D);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "750m")
        final IllegalArgumentException cause = (IllegalArgumentException) e.getCause();
                + "will be removed in a future release! See the breaking changes documentation for the next major version."
            () -> new DiskThresholdSettings(settings, clusterSettings)
            );
 * The OpenSearch Contributors require contributions made to
        assertThat(cause, hasToString(containsString("low disk watermark [85%] more than high disk watermark [75%]")));
import org.opensearch.common.settings.ClusterSettings;
    }
        ClusterSettings nss = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testIncompatibleThresholdUpdate() {
            "unable to consistently parse [%s=%s], [%s=%s], and [%s=%s] as percentage or bytes",
            final Settings settings = Settings.builder()
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.instanceOf;
        assertEquals(0.0D, diskThresholdSettings.getFreeDiskThresholdHigh(), 0.0D);
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
        new DiskThresholdSettings(Settings.EMPTY, clusterSettings); // this has the effect of registering the settings updater
            "1000m",
        final String expected = "illegal value can't update [cluster.routing.allocation.disk.watermark.low] from [85%] to [90%]";
        {
        assertThat(diskThresholdSettings.describeLowThreshold(), equalTo("85%"));
    }
        final Settings.Builder target = Settings.builder();
