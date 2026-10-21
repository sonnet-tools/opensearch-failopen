        this.indexReadBlockAutoReleaseEnabled = indexReadBlockAutoReleaseEnabled;
 */
    /**
        setLowWatermark(lowWatermark);
        Setting.Property.NodeScope,
        this.freeDiskThresholdFloodStage = 100.0 - thresholdPercentageFromWatermark(floodStageRaw);
        } catch (OpenSearchParseException ex) {
        this.warmThresholdEnabled = CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING.get(settings);
    private void setHighWatermark(String highWatermark) {
    }
        setFloodStage(floodStage);
    public boolean isIndexReadBlockAutoReleaseEnabled() {
        }
        final double floodThreshold = thresholdPercentageFromWatermark(flood, false);
        } catch (OpenSearchParseException e) {
        Setting.Property.Dynamic,
        } catch (final OpenSearchParseException e) {
        this.freeDiskThresholdLow = 100.0 - thresholdPercentageFromWatermark(lowWatermark);
     * Attempts to parse the watermark into a {@link ByteSizeValue}, returning zero bytes if it can not be parsed and the specified lenient
            : freeBytesThresholdHigh.toString();
     */
     *
    private volatile boolean indexReadBlockAutoReleaseEnabled;
    }
    public ByteSizeValue getFreeBytesThresholdHigh() {
     * blocks when the triggering condition (file cache search threshold on warm nodes) is no longer met.
     * Validates the flood stage.
                CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING
        Setting.Property.NodeScope
        true,
        new FloodStageValidator(),
     * @opensearch.internal
    }
    /**
                ByteSizeValue.parseBytesSizeValue(watermark, settingName);
    }
            CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(),
    }
    private volatile boolean includeRelocations;
            this::setWarmThresholdEnabled
    public boolean isWarmThresholdEnabled() {
        return includeRelocations;
 * compatible open source license.
     *
     */
        Setting.Property.Dynamic,
        return freeDiskThresholdFloodStage;
    }
        this.indexReadBlockAutoReleaseEnabled = INDEX_READ_BLOCK_AUTO_RELEASE.get(settings);
        public void validate(String value) {
        "85%",
     * Defaults to {@code true}. Set to {@code false} to prevent automatic release of read blocks,
    private static ByteSizeValue thresholdBytesFromWatermark(String watermark, String settingName, boolean lenient) {
        try {
    public static final Setting<TimeValue> CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING = Setting.positiveTimeSetting(
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING = Setting.boolSetting(
        public void validate(final String value, final Map<Setting<?>, Object> settings) {
    static final class LowDiskWatermarkValidator implements Setting.Validator<String> {
     * Gets the raw (uninterpreted) high watermark value as found in the settings.
            final String lowWatermarkRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING);
     * @return the parsed percentage
        return freeBytesThresholdLow.equals(ByteSizeValue.ZERO)
        Setting.Property.Dynamic,
import org.opensearch.core.common.Strings;
            highWatermark,
        return freeBytesThresholdLow;
    private void setIndexReadBlockAutoReleaseExcludePatterns(List<String> patterns) {
                return ByteSizeValue.parseBytesSizeValue("0b", settingName);
    private void setIndexReadBlockAutoReleaseEnabled(boolean indexReadBlockAutoReleaseEnabled) {
                throw ex;
    }
import org.opensearch.common.settings.Setting;
        this.indexReadBlockAutoReleaseExcludePatterns = patterns;
 * under the License.
        final ByteSizeValue highWatermarkBytes = thresholdBytesFromWatermark(
        TimeValue.timeValueSeconds(60),
    }
            throw new IllegalArgumentException(
import org.opensearch.common.settings.Settings;
        @Override
        }
import org.opensearch.common.unit.TimeValue;
     * Attempts to parse the watermark into a {@link ByteSizeValue}, returning
    private static double thresholdPercentageFromWatermark(String watermark, boolean lenient) {
        new LowDiskWatermarkValidator(),
import java.util.List;
        public void validate(final String value) {
                return 100.0;
        public void validate(final String value, final Map<Setting<?>, Object> settings) {
    public List<String> getIndexReadBlockAutoReleaseExcludePatterns() {
            false
        return freeDiskThresholdLow;
        true,
    public static final Setting<List<String>> INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS = Setting.listSetting(
    /**
        return warmThresholdEnabled;
        try {
    }
            doValidate(value, highWatermarkRaw, floodStageRaw);
        }
        Function.identity(),
        "cluster.routing.allocation.disk.watermark.flood_stage",
    /**
        );
        if (lowWatermarkBytes.getBytes() < highWatermarkBytes.getBytes()) {
     * a ByteSizeValue of 0 bytes if the value cannot be parsed.
    public static final Setting<Boolean> INDEX_READ_BLOCK_AUTO_RELEASE = Setting.boolSetting(
        return freeBytesThresholdFloodStage.equals(ByteSizeValue.ZERO)
        this.freeBytesThresholdFloodStage = thresholdBytesFromWatermark(
     */
            try {
    /**
import org.opensearch.core.common.unit.ByteSizeValue;
        this.includeRelocations = includeRelocations;
        assert Version.CURRENT.major == Version.V_2_0_0.major + 1; // this check is unnecessary in v4
        "cluster.routing.allocation.disk.watermark.low",
        public Iterator<Setting<?>> settings() {
    /**
        return highWatermarkRaw;
    }
        this.freeBytesThresholdLow = thresholdBytesFromWatermark(
     * @opensearch.internal
        @Override
import org.opensearch.common.unit.RatioValue;
/*
            ? Strings.format1Decimals(100.0 - freeDiskThresholdLow, "%")
        @Override
        clusterSettings.addSettingsUpdateConsumer(
    }
        final String AUTO_RELEASE_INDEX_ENABLED_KEY = "opensearch.disk.auto_release_flood_stage_block";
    private volatile boolean createIndexBlockAutoReleaseEnabled;
    /**
        Setting.Property.Dynamic,
     * which is useful when read blocks are manually managed by operators.
        "cluster.blocks.read.auto_release.exclude_patterns",
            // cases separately
     * Controls whether the disk threshold monitor automatically releases {@code index.blocks.read}
        }
        return lowWatermarkRaw;
        }
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
        @Override
        this.lowWatermarkRaw = lowWatermark;
        "cluster.blocks.read.auto_release",
        final String lowWatermark = CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.get(settings);
 * GitHub history for details.
        public void validate(final String value) {
        "cluster.routing.allocation.disk.threshold_enabled",
        true,
        final String highWatermark = CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.get(settings);
     * Validates a high disk watermark.
        return freeBytesThresholdHigh;
                "system property [" + AUTO_RELEASE_INDEX_ENABLED_KEY + "] has been removed in 3.0.0 and is not supported anymore"
    public Double getFreeDiskThresholdFloodStage() {
            );
        Setting.Property.NodeScope
            final String floodStageRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING);
    );
     * Returns whether automatic release of index read blocks is enabled.
    public static final Setting<String> CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING = new Setting<>(
        return thresholdBytesFromWatermark(watermark, settingName, true);
            final String highWatermarkRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING);
     * true, otherwise throwing an {@link OpenSearchParseException}.
        return freeDiskThresholdHigh;
    private void setEnabled(boolean enabled) {
    static final class HighDiskWatermarkValidator implements Setting.Validator<String> {
        Setting.Property.Dynamic,
    private volatile TimeValue rerouteInterval;
package org.opensearch.cluster.routing.allocation;
     */
            CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
            // cases separately
    public boolean includeRelocations() {
        @Override
    private void setRerouteInterval(TimeValue rerouteInterval) {
            throw ex;
    private static ByteSizeValue thresholdBytesFromWatermark(String watermark, String settingName) {
        if (highWatermarkThreshold > floodThreshold) {
            final String floodStageRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING);
    public static final Setting<Boolean> CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE = Setting.boolSetting(
            final String message = String.format(
    private volatile String lowWatermarkRaw;
        Setting.Property.Dynamic,
     *
        @Override
    }
        // Watermark is expressed in terms of used data, but we need "free" data watermark
    private static void doValidate(String low, String high, String flood) {
    private static void doValidateAsBytes(final String low, final String high, final String flood) {
    );
    }
        Setting.Property.NodeScope
        return rerouteInterval;
     * @param lenient true if lenient parsing should be applied
 *
        } catch (OpenSearchParseException ex) {
    }
        try {
            );
            // NOTE: this is not end-user leniency, since up above we check that it's a valid byte or percentage, and then store the two
public class DiskThresholdSettings {
            throw new IllegalArgumentException("low disk watermark [" + low + "] less than high disk watermark [" + high + "]");
        (s) -> validWatermarkSetting(s, "cluster.routing.allocation.disk.watermark.low"),
        this.freeBytesThresholdHigh = thresholdBytesFromWatermark(
        Setting.Property.Dynamic,
     */
        }
    /**
    }
import java.util.Locale;
        Setting.Property.NodeScope
    private volatile ByteSizeValue freeBytesThresholdLow;
            } catch (OpenSearchParseException ex) {
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
    }
        final ByteSizeValue floodStageBytes = thresholdBytesFromWatermark(
        if (property != null) {
            : freeBytesThresholdLow.toString();
 * KIND, either express or implied.  See the License for the
    private volatile Double freeDiskThresholdLow;
    private volatile String highWatermarkRaw;
        true,
            final String highWatermarkRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING);
                ex.addSuppressed(e);
    /**
    private volatile boolean warmThresholdEnabled;
    private volatile boolean enabled;
/*
    );
            false
     * even when {@link #INDEX_READ_BLOCK_AUTO_RELEASE} is set to {@code false}.
 * Unless required by applicable law or agreed to in writing,
                CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(),
    }
        if (lowWatermarkThreshold > highWatermarkThreshold) {
        Setting.Property.Dynamic,
     * @return the watermark value given
        "cluster.routing.allocation.disk.include_relocations",
        return thresholdPercentageFromWatermark(watermark, true);
    }
        }
    }
            return; // early return so that we do not try to parse as bytes
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING, this::setEnabled);
            doValidateAsPercentage(low, high, flood);
    }
 * the Apache License, Version 2.0 (the "License"); you may
        List.of(".*"),
        }
        );
}
    }
            throw new IllegalArgumentException(message, e);
     * Attempts to parse the watermark into a percentage, returning 100.0% if it can not be parsed and the specified lenient parameter is
    private void setFloodStage(String floodStageRaw) {
    /**
            INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS,
        true,
    );
        public Iterator<Setting<?>> settings() {
        return freeBytesThresholdHigh.equals(ByteSizeValue.ZERO)
        Setting.Property.Dynamic,
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING
        @Override
    static final class FloodStageValidator implements Setting.Validator<String> {
    }
    public String getHighWatermarkRaw() {
    }
        setHighWatermark(highWatermark);
     */
            final List<Setting<?>> settings = Arrays.asList(
 *
        Setting.Property.NodeScope
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING = Setting.boolSetting(
            throw new IllegalArgumentException("high disk watermark [" + high + "] less than flood stage disk watermark [" + flood + "]");
                high,
        this.rerouteInterval = CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(settings);
    private volatile Double freeDiskThresholdHigh;
        final String property = System.getProperty(AUTO_RELEASE_INDEX_ENABLED_KEY);
                CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING,
        }
 * specific language governing permissions and limitations
    public ByteSizeValue getFreeBytesThresholdLow() {
     * even when {@link #isIndexReadBlockAutoReleaseEnabled()} returns {@code false}.
        }
import org.opensearch.Version;
     */
            return RatioValue.parseRatioValue(watermark).getAsPercent();
import org.opensearch.OpenSearchParseException;
    }
 * this work for additional information regarding copyright
 * @opensearch.internal
        );
                low,
            final List<Setting<?>> settings = Arrays.asList(
        );
 *
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        Setting.Property.NodeScope
     */
    }
     */
     * Defaults to {@code [".*"]} (all dot-prefixed indices).
    public static final Setting<String> CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING = new Setting<>(
        return watermark;
     */
 * ownership. Elasticsearch licenses this file to you under
    }
     * @param lenient true if lenient parsing should be applied
    /**
            floodStageRaw,
    private volatile ByteSizeValue freeBytesThresholdHigh;
    static {
            }
        );
            ? Strings.format1Decimals(100.0 - freeDiskThresholdHigh, "%")
            ? Strings.format1Decimals(100.0 - freeDiskThresholdFloodStage, "%")
            doValidateAsBytes(low, high, flood);
    );
/*
        this.createIndexBlockAutoReleaseEnabled = CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE.get(settings);
        this.warmThresholdEnabled = enabled;
        "95%",
        }
        if (highWatermarkBytes.getBytes() < floodStageBytes.getBytes()) {
     * parameter is true, otherwise throwing an {@link OpenSearchParseException}.
        try {
    );
            );
            this::setIndexReadBlockAutoReleaseExcludePatterns
    );
        Setting.Property.NodeScope
    }
            flood,
     * Attempts to parse the watermark into a percentage, returning 100.0% if
                flood
    }
                "unable to consistently parse [%s=%s], [%s=%s], and [%s=%s] as percentage or bytes",
        Setting.Property.NodeScope
     */
            false
    );
    }
            doValidate(lowWatermarkRaw, value, floodStageRaw);
        }
    }
        (s) -> validWatermarkSetting(s, "cluster.routing.allocation.disk.watermark.flood_stage"),
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING, this::setLowWatermark);
            return settings.iterator();
            : freeBytesThresholdFloodStage.toString();
    private volatile List<String> indexReadBlockAutoReleaseExcludePatterns;
        try {
     * Indices matching any of these patterns will always have their read blocks auto-released,
        this.enabled = enabled;
        return freeBytesThresholdFloodStage;
        public Iterator<Setting<?>> settings() {
    }
        @Override
            RatioValue.parseRatioValue(watermark);
    String describeHighThreshold() {
        public void validate(final String value, final Map<Setting<?>, Object> settings) {
     * Returns the list of index name patterns that are excluded from read block auto-release disablement.
        // Watermark is expressed in terms of used data, but we need "free" data watermark
    }
    );
import java.util.function.Function;
                CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING
    public DiskThresholdSettings(Settings settings, ClusterSettings clusterSettings) {
 * this file be licensed under the Apache-2.0 license or a
            lowWatermark,
        final ByteSizeValue lowWatermarkBytes = thresholdBytesFromWatermark(
        new HighDiskWatermarkValidator(),
    /**
        // Watermark is expressed in terms of used data, but we need "free" data watermark
        }
            if (lenient) {
    /**
    private static String validWatermarkSetting(String watermark, String settingName) {
     */
        this.rerouteInterval = rerouteInterval;
        final double highWatermarkThreshold = thresholdPercentageFromWatermark(high, false);
 * You may obtain a copy of the License at
    }
        "cluster.routing.allocation.disk.reroute_interval",
        this.enabled = CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.get(settings);
 * not use this file except in compliance with the License.
        Setting.Property.NodeScope
        }
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING = Setting.boolSetting(
    private void setWarmThresholdEnabled(boolean enabled) {
    }
 */
        );
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE, this::setCreateIndexBlockAutoReleaseEnabled);
        "cluster.routing.allocation.disk.watermark.high",
 * Licensed to Elasticsearch under one or more contributor
     * disable auto-release for user indices. Uses OpenSearch simple wildcard matching.
        "cluster.routing.allocation.disk.warm_threshold_enabled",
        );
    }
        } catch (final OpenSearchParseException e) {
    }
     * A list of index name patterns for which read blocks are always auto-released,
        clusterSettings.addSettingsUpdateConsumer(INDEX_READ_BLOCK_AUTO_RELEASE, this::setIndexReadBlockAutoReleaseEnabled);
        Setting.Property.Deprecated
    String describeLowThreshold() {
                CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
            doValidate(lowWatermarkRaw, highWatermarkRaw, value);
            );
        final String floodStage = CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.get(settings);
    }
     * This protects system indices from getting stuck in read-only state when operators
    private void setLowWatermark(String lowWatermark) {
    String describeFloodStageThreshold() {
import java.util.Iterator;
        this.createIndexBlockAutoReleaseEnabled = createIndexBlockAutoReleaseEnabled;
    /**
    public Double getFreeDiskThresholdHigh() {
            return ByteSizeValue.parseBytesSizeValue(watermark, settingName);
            throw new IllegalArgumentException("low disk watermark [" + low + "] more than high disk watermark [" + high + "]");
    private volatile Double freeDiskThresholdFloodStage;
     */
     */
/**
        this.freeDiskThresholdHigh = 100.0 - thresholdPercentageFromWatermark(highWatermark);
            high,
     * @param watermark the watermark to parse as a percentage
     * it cannot be parsed.
        );
        "cluster.routing.allocation.disk.watermark.enable_for_single_data_node",
        (s) -> validWatermarkSetting(s, "cluster.routing.allocation.disk.watermark.high"),
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING, this::setIncludeRelocations);
        return indexReadBlockAutoReleaseExcludePatterns;
            }
     * @param settingName the name of the setting
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING, this::setHighWatermark);
            throw ex;
            low,
     * Checks if a watermark string is a valid percentage or byte size value,
    public String getLowWatermarkRaw() {
    }
        false,
     * @return the parsed byte size value
            CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey()
            CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey()
        }
    public Double getFreeDiskThresholdLow() {
        this.highWatermarkRaw = highWatermark;
    public TimeValue getRerouteInterval() {
        }
        @Override
            );
    );
import java.util.Map;
    private static double thresholdPercentageFromWatermark(String watermark) {
    public boolean isCreateIndexBlockAutoReleaseEnabled() {
     * Validates a low disk watermark.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING,
    private void setIncludeRelocations(boolean includeRelocations) {
     * Gets the raw (uninterpreted) low watermark value as found in the settings.
        clusterSettings.addSettingsUpdateConsumer(
    }
 */
        final double lowWatermarkThreshold = thresholdPercentageFromWatermark(low, false);
        "90%",
     *
            return settings.iterator();
     * @opensearch.internal
            throw new IllegalArgumentException("high disk watermark [" + high + "] more than flood stage disk watermark [" + flood + "]");
import org.opensearch.common.settings.ClusterSettings;
    private void setCreateIndexBlockAutoReleaseEnabled(boolean createIndexBlockAutoReleaseEnabled) {
        }
    public static final Setting<Boolean> ENABLE_FOR_SINGLE_DATA_NODE = Setting.boolSetting(
                CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING,
     * by the disk threshold monitor.
        "cluster.blocks.create_index.auto_release",
        return createIndexBlockAutoReleaseEnabled;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING, this::setRerouteInterval);
            CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
            final List<Setting<?>> settings = Arrays.asList(
    );
            // NOTE: this is not end-user leniency, since up above we check that it's a valid byte or percentage, and then store the two
            final String lowWatermarkRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING);
        this.indexReadBlockAutoReleaseExcludePatterns = INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS.get(settings);
        this.includeRelocations = CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING.get(settings);
    public static final Setting<String> CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING = new Setting<>(
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING,
    public boolean isEnabled() {
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING, this::setFloodStage);
            if (lenient) {
 * A container to keep settings for disk thresholds up to date with cluster setting changes.
 * The OpenSearch Contributors require contributions made to
        return enabled;
        Setting.Property.NodeScope
import java.util.Arrays;
 * Modifications Copyright OpenSearch Contributors. See
        }
            }
            // swallow as we are now going to try to parse as bytes
 *
    private static void doValidateAsPercentage(final String low, final String high, final String flood) {
     * @param watermark the watermark to parse as a byte size
 * SPDX-License-Identifier: Apache-2.0
     * When disabled, read blocks set on indices will not be automatically removed
    public ByteSizeValue getFreeBytesThresholdFloodStage() {
                Locale.ROOT,
    private volatile ByteSizeValue freeBytesThresholdFloodStage;
 */
     *
            return settings.iterator();
    }
        return indexReadBlockAutoReleaseEnabled;
        Setting.Property.Dynamic,
            CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey()
