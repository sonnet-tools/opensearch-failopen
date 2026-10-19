            : freeBytesThresholdLow.toString();
            );  
    public ByteSizeValue getFreeBytesThresholdFloodStage() {
            flood,  
                return ByteSizeValue.parseBytesSizeValue("0b", settingName);  
     */
     * by the disk threshold monitor.
        "95%",
            final List<Setting<?>> settings = Arrays.asList(  
    }
    }
    public boolean isEnabled() {  
    );
        Setting.Property.Dynamic,  
            high,
    }
        }  
                ex.addSuppressed(e);
                ByteSizeValue.parseBytesSizeValue(watermark, settingName);  
        "cluster.routing.allocation.disk.warm_threshold_enabled",
     * Defaults to {@code true}. Set to {@code false} to prevent automatic release of read blocks,  
        } catch (final OpenSearchParseException e) {  
    /**  
        }
 * specific language governing permissions and limitations
        }  
    /**
        Setting.Property.Dynamic,
        final double floodThreshold = thresholdPercentageFromWatermark(flood, false);  
     * @opensearch.internal  
                CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),
    public ByteSizeValue getFreeBytesThresholdHigh() {
import java.util.Map;  
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.core.common.Strings;
        "cluster.routing.allocation.disk.watermark.enable_for_single_data_node",
        return thresholdBytesFromWatermark(watermark, settingName, true);
            return settings.iterator();
        );  
        // Watermark is expressed in terms of used data, but we need "free" data watermark
        this.includeRelocations = includeRelocations;
 * under the License.  
        @Override  
     * a ByteSizeValue of 0 bytes if the value cannot be parsed.
     * @opensearch.internal  
     */
            false  
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING, this::setLowWatermark);  
        "90%",  
        Setting.Property.NodeScope
            this::setWarmThresholdEnabled
        this.highWatermarkRaw = highWatermark;
 * the Apache License, Version 2.0 (the "License"); you may
 *
            return settings.iterator();
                "unable to consistently parse [%s=%s], [%s=%s], and [%s=%s] as percentage or bytes",  
    }
     */
            throw ex;
    }  
            false
        "cluster.routing.allocation.disk.watermark.flood_stage",
     * @return the parsed byte size value  
/*  
        return freeBytesThresholdHigh.equals(ByteSizeValue.ZERO)
    public TimeValue getRerouteInterval() {
    /**  
    }  
    private volatile boolean enabled;
 * GitHub history for details.
import java.util.Arrays;
    public List<String> getIndexReadBlockAutoReleaseExcludePatterns() {  
        Setting.Property.NodeScope  
    private volatile Double freeDiskThresholdLow;
     * @param settingName the name of the setting
    String describeFloodStageThreshold() {
            final String highWatermarkRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING);
            CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey()
                Locale.ROOT,
        return enabled;
    /**  
        public Iterator<Setting<?>> settings() {
            : freeBytesThresholdHigh.toString();
        true,
        true,
        }  
            : freeBytesThresholdFloodStage.toString();
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING, this::setFloodStage);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * SPDX-License-Identifier: Apache-2.0
     * Validates the flood stage.
    private static void doValidate(String low, String high, String flood) {  
    }
import org.opensearch.core.common.unit.ByteSizeValue;  
    private volatile boolean warmThresholdEnabled;
    private void setRerouteInterval(TimeValue rerouteInterval) {
        "cluster.routing.allocation.disk.watermark.high",
    public boolean isIndexReadBlockAutoReleaseEnabled() {  
        this.freeDiskThresholdLow = 100.0 - thresholdPercentageFromWatermark(lowWatermark);
        this.createIndexBlockAutoReleaseEnabled = CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE.get(settings);  
     * Validates a low disk watermark.
            );  
        try {
    private static ByteSizeValue thresholdBytesFromWatermark(String watermark, String settingName) {
    private volatile ByteSizeValue freeBytesThresholdLow;
 * Modifications Copyright OpenSearch Contributors. See
        Setting.Property.Dynamic,  
     */
        try {  
        public void validate(final String value, final Map<Setting<?>, Object> settings) {
    public static final Setting<String> CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING = new Setting<>(  
        return lowWatermarkRaw;
    /**
 * @opensearch.internal  
    /**
    private volatile Double freeDiskThresholdFloodStage;
     * Attempts to parse the watermark into a percentage, returning 100.0% if
     * true, otherwise throwing an {@link OpenSearchParseException}.
            doValidateAsPercentage(low, high, flood);
    );
    }
        // Watermark is expressed in terms of used data, but we need "free" data watermark
        );
    private volatile boolean createIndexBlockAutoReleaseEnabled;
            throw new IllegalArgumentException(message, e);
        Setting.Property.NodeScope
        true,
        return freeBytesThresholdFloodStage.equals(ByteSizeValue.ZERO)
            RatioValue.parseRatioValue(watermark);  
            final String floodStageRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING);  
        return freeBytesThresholdLow.equals(ByteSizeValue.ZERO)
            final String highWatermarkRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING);  
        this.enabled = enabled;  
        this.warmThresholdEnabled = enabled;
            return; // early return so that we do not try to parse as bytes  
        true,
    private static String validWatermarkSetting(String watermark, String settingName) {
    /**
            }
    private void setIndexReadBlockAutoReleaseEnabled(boolean indexReadBlockAutoReleaseEnabled) {
        setLowWatermark(lowWatermark);  
        }  
    }
    static {
        "cluster.routing.allocation.disk.reroute_interval",
        Setting.Property.NodeScope
     *
 * this work for additional information regarding copyright
    String describeLowThreshold() {
        final String highWatermark = CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.get(settings);  
     * Returns the list of index name patterns that are excluded from read block auto-release disablement.
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING, this::setRerouteInterval);
    public boolean isWarmThresholdEnabled() {
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING = Setting.boolSetting(  
    static final class HighDiskWatermarkValidator implements Setting.Validator<String> {
    public static final Setting<Boolean> CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE = Setting.boolSetting(  
        if (highWatermarkThreshold > floodThreshold) {
    );
    }
    }
    static final class FloodStageValidator implements Setting.Validator<String> {
 * You may obtain a copy of the License at  
        }
            CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING,
        if (lowWatermarkThreshold > highWatermarkThreshold) {
        @Override
        TimeValue.timeValueSeconds(60),
        "cluster.routing.allocation.disk.watermark.low",  
        this.includeRelocations = CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING.get(settings);
        Setting.Property.NodeScope,  
        }  
            low,
    private volatile boolean includeRelocations;  
        if (property != null) {  
    private void setEnabled(boolean enabled) {
    /**  
/*
 */
import org.opensearch.Version;
        clusterSettings.addSettingsUpdateConsumer(  
            } catch (OpenSearchParseException ex) {
    );
        "cluster.routing.allocation.disk.threshold_enabled",
     */  
    }  
        return createIndexBlockAutoReleaseEnabled;
        new HighDiskWatermarkValidator(),
    private void setLowWatermark(String lowWatermark) {
        Function.identity(),
        clusterSettings.addSettingsUpdateConsumer(  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        this.rerouteInterval = CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.get(settings);  
 * The OpenSearch Contributors require contributions made to  
                CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING
    private volatile ByteSizeValue freeBytesThresholdFloodStage;
            CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey()
        this.freeBytesThresholdFloodStage = thresholdBytesFromWatermark(  
import java.util.List;
    /**  
    }
        } catch (final OpenSearchParseException e) {
/**  
    );
        );
            ? Strings.format1Decimals(100.0 - freeDiskThresholdFloodStage, "%")  
    private volatile String lowWatermarkRaw;  
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING = Setting.boolSetting(  
    private volatile List<String> indexReadBlockAutoReleaseExcludePatterns;  
        this.lowWatermarkRaw = lowWatermark;  
        // Watermark is expressed in terms of used data, but we need "free" data watermark  
        return indexReadBlockAutoReleaseExcludePatterns;
    private volatile TimeValue rerouteInterval;  
    static final class LowDiskWatermarkValidator implements Setting.Validator<String> {
     * @param watermark the watermark to parse as a percentage
    }
        this.freeBytesThresholdLow = thresholdBytesFromWatermark(
                low,
    }
        Setting.Property.Deprecated
        "cluster.blocks.create_index.auto_release",
        this.indexReadBlockAutoReleaseExcludePatterns = INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS.get(settings);
    public static final Setting<Boolean> INDEX_READ_BLOCK_AUTO_RELEASE = Setting.boolSetting(  
                "system property [" + AUTO_RELEASE_INDEX_ENABLED_KEY + "] has been removed in 3.0.0 and is not supported anymore"
            throw new IllegalArgumentException("high disk watermark [" + high + "] more than flood stage disk watermark [" + flood + "]");
            CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(),  
                high,
     */
            );  
        "85%",
        Setting.Property.Dynamic,  
            return settings.iterator();
        final ByteSizeValue floodStageBytes = thresholdBytesFromWatermark(
     * Gets the raw (uninterpreted) low watermark value as found in the settings.
            // NOTE: this is not end-user leniency, since up above we check that it's a valid byte or percentage, and then store the two  
        public Iterator<Setting<?>> settings() {
        this.createIndexBlockAutoReleaseEnabled = createIndexBlockAutoReleaseEnabled;
            false
        Setting.Property.NodeScope  
    );
            // cases separately
     * When disabled, read blocks set on indices will not be automatically removed  
            );  
    private volatile boolean indexReadBlockAutoReleaseEnabled;
            throw new IllegalArgumentException("low disk watermark [" + low + "] less than high disk watermark [" + high + "]");
    }
            CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(),
     * Controls whether the disk threshold monitor automatically releases {@code index.blocks.read}
        return freeDiskThresholdFloodStage;
        setFloodStage(floodStage);
        "cluster.blocks.read.auto_release",
            doValidateAsBytes(low, high, flood);
 *
        return rerouteInterval;  
        return warmThresholdEnabled;
        final double lowWatermarkThreshold = thresholdPercentageFromWatermark(low, false);
    private static void doValidateAsBytes(final String low, final String high, final String flood) {  
        @Override
    public static final Setting<Boolean> ENABLE_FOR_SINGLE_DATA_NODE = Setting.boolSetting(  
import java.util.Iterator;  
            CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey()
        setHighWatermark(highWatermark);
    public Double getFreeDiskThresholdFloodStage() {  
 * A container to keep settings for disk thresholds up to date with cluster setting changes.
        );  
 * license agreements. See the NOTICE file distributed with
     * @param watermark the watermark to parse as a byte size  
            doValidate(value, highWatermarkRaw, floodStageRaw);
 */  
            return RatioValue.parseRatioValue(watermark).getAsPercent();
    }
        final String lowWatermark = CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.get(settings);
import org.opensearch.common.settings.Settings;
            lowWatermark,  
        public Iterator<Setting<?>> settings() {
    private static double thresholdPercentageFromWatermark(String watermark, boolean lenient) {
 *  
        @Override
    }
    }
            doValidate(lowWatermarkRaw, value, floodStageRaw);
        return freeBytesThresholdFloodStage;
        final String floodStage = CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.get(settings);
        try {
        this.indexReadBlockAutoReleaseEnabled = INDEX_READ_BLOCK_AUTO_RELEASE.get(settings);
            doValidate(lowWatermarkRaw, highWatermarkRaw, value);
    );  
    public DiskThresholdSettings(Settings settings, ClusterSettings clusterSettings) {
        public void validate(final String value) {
        public void validate(String value) {
     * This protects system indices from getting stuck in read-only state when operators  
     * Indices matching any of these patterns will always have their read blocks auto-released,  
        return includeRelocations;  
    public String getLowWatermarkRaw() {  
            // swallow as we are now going to try to parse as bytes
        }  
    public static final Setting<String> CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING = new Setting<>(
    }
        (s) -> validWatermarkSetting(s, "cluster.routing.allocation.disk.watermark.low"),
            // NOTE: this is not end-user leniency, since up above we check that it's a valid byte or percentage, and then store the two  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        Setting.Property.NodeScope  
        }
    /**  
    private volatile String highWatermarkRaw;
    }
        @Override  
import java.util.Locale;
        final ByteSizeValue highWatermarkBytes = thresholdBytesFromWatermark(  
     * it cannot be parsed.  
 * Unless required by applicable law or agreed to in writing,
     * Attempts to parse the watermark into a {@link ByteSizeValue}, returning
    public static final Setting<Boolean> CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING = Setting.boolSetting(
        }
     */
        final String AUTO_RELEASE_INDEX_ENABLED_KEY = "opensearch.disk.auto_release_flood_stage_block";  
    }
        return freeBytesThresholdLow;
        }  
     * Checks if a watermark string is a valid percentage or byte size value,
        Setting.Property.NodeScope
import java.util.function.Function;
        return indexReadBlockAutoReleaseEnabled;
            }
            throw new IllegalArgumentException(
    }
                CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING,
    }
            throw ex;
     *
        new LowDiskWatermarkValidator(),  
 */  
            if (lenient) {
import org.opensearch.common.unit.RatioValue;  
        Setting.Property.NodeScope
        true,
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING, this::setHighWatermark);
        "cluster.routing.allocation.disk.include_relocations",  
            try {
            final String lowWatermarkRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING);
        "cluster.blocks.read.auto_release.exclude_patterns",
import org.opensearch.common.settings.Setting;
                CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(),
    );
        this.enabled = CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.get(settings);
        Setting.Property.Dynamic,  
    }  
        final ByteSizeValue lowWatermarkBytes = thresholdBytesFromWatermark(
        if (highWatermarkBytes.getBytes() < floodStageBytes.getBytes()) {
     * @param lenient true if lenient parsing should be applied
    private void setIndexReadBlockAutoReleaseExcludePatterns(List<String> patterns) {
        return thresholdPercentageFromWatermark(watermark, true);  
     * A list of index name patterns for which read blocks are always auto-released,
        );  
        Setting.Property.Dynamic,
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_INCLUDE_RELOCATIONS_SETTING, this::setIncludeRelocations);  
    private void setIncludeRelocations(boolean includeRelocations) {  
            final List<Setting<?>> settings = Arrays.asList(  
        );  
        } catch (OpenSearchParseException ex) {
     * parameter is true, otherwise throwing an {@link OpenSearchParseException}.
        return freeDiskThresholdLow;  
     * blocks when the triggering condition (file cache search threshold on warm nodes) is no longer met.
                CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING,
 *
        Setting.Property.Dynamic,
        try {
        } catch (OpenSearchParseException e) {
public class DiskThresholdSettings {
    /**  
            throw new IllegalArgumentException("low disk watermark [" + low + "] more than high disk watermark [" + high + "]");
     */  
        );
    }  
        }
    }  
        (s) -> validWatermarkSetting(s, "cluster.routing.allocation.disk.watermark.high"),
        @Override
     * Validates a high disk watermark.
        false,
            CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),
     */
        new FloodStageValidator(),
            ? Strings.format1Decimals(100.0 - freeDiskThresholdLow, "%")  
     * which is useful when read blocks are manually managed by operators.
    private void setCreateIndexBlockAutoReleaseEnabled(boolean createIndexBlockAutoReleaseEnabled) {  
    }
    public Double getFreeDiskThresholdLow() {
        return watermark;  
        public void validate(final String value, final Map<Setting<?>, Object> settings) {
     *  
    public static final Setting<TimeValue> CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING = Setting.positiveTimeSetting(  
    private void setHighWatermark(String highWatermark) {
    /**  
        }
}
    }
        @Override
     */
    private volatile Double freeDiskThresholdHigh;  
    }
     * Returns whether automatic release of index read blocks is enabled.
            INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS,
        @Override  
        }
 * Licensed to Elasticsearch under one or more contributor  
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING,
        } catch (OpenSearchParseException ex) {
                throw ex;  
        Setting.Property.Dynamic,  
        }  
            );
    public ByteSizeValue getFreeBytesThresholdLow() {
     *
        this.freeDiskThresholdHigh = 100.0 - thresholdPercentageFromWatermark(highWatermark);
        (s) -> validWatermarkSetting(s, "cluster.routing.allocation.disk.watermark.flood_stage"),  
                return 100.0;  
    }
        final String property = System.getProperty(AUTO_RELEASE_INDEX_ENABLED_KEY);
    public static final Setting<String> CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING = new Setting<>(
    /**
            // cases separately
    private static ByteSizeValue thresholdBytesFromWatermark(String watermark, String settingName, boolean lenient) {
        assert Version.CURRENT.major == Version.V_2_0_0.major + 1; // this check is unnecessary in v4
        this.freeDiskThresholdFloodStage = 100.0 - thresholdPercentageFromWatermark(floodStageRaw);
     *
    }
     * Attempts to parse the watermark into a {@link ByteSizeValue}, returning zero bytes if it can not be parsed and the specified lenient  
            final String lowWatermarkRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING);
        }
import org.opensearch.common.settings.ClusterSettings;  
 * KIND, either express or implied.  See the License for the
    }  
     * disable auto-release for user indices. Uses OpenSearch simple wildcard matching.
    private void setFloodStage(String floodStageRaw) {  
        List.of(".*"),  
            }
        return highWatermarkRaw;
            throw new IllegalArgumentException("high disk watermark [" + high + "] less than flood stage disk watermark [" + flood + "]");
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING, this::setEnabled);
    public boolean includeRelocations() {
        Setting.Property.NodeScope
     */  
    }
        Setting.Property.Dynamic,
    public String getHighWatermarkRaw() {
    );
        public void validate(final String value, final Map<Setting<?>, Object> settings) {
package org.opensearch.cluster.routing.allocation;
    public boolean isCreateIndexBlockAutoReleaseEnabled() {  
     * @return the watermark value given
        }
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE, this::setCreateIndexBlockAutoReleaseEnabled);
    /**  
    }
        this.indexReadBlockAutoReleaseEnabled = indexReadBlockAutoReleaseEnabled;
/*  
 * software distributed under the License is distributed on an
    );
        this.indexReadBlockAutoReleaseExcludePatterns = patterns;  
     */
        try {  
     * Defaults to {@code [".*"]} (all dot-prefixed indices).
    private static double thresholdPercentageFromWatermark(String watermark) {
        @Override
     * Attempts to parse the watermark into a percentage, returning 100.0% if it can not be parsed and the specified lenient parameter is
            final String message = String.format(
    private volatile ByteSizeValue freeBytesThresholdHigh;
    private void setWarmThresholdEnabled(boolean enabled) {  
            highWatermark,
    private static void doValidateAsPercentage(final String low, final String high, final String flood) {  
import org.opensearch.OpenSearchParseException;
        this.warmThresholdEnabled = CLUSTER_ROUTING_ALLOCATION_WARM_DISK_THRESHOLD_ENABLED_SETTING.get(settings);
        );  
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING
     * @opensearch.internal  
        if (lowWatermarkBytes.getBytes() < highWatermarkBytes.getBytes()) {
    }
            if (lenient) {
    public static final Setting<List<String>> INDEX_READ_BLOCK_AUTO_RELEASE_EXCLUDE_PATTERNS = Setting.listSetting(
        Setting.Property.Dynamic,  
     * @param lenient true if lenient parsing should be applied
            this::setIndexReadBlockAutoReleaseExcludePatterns
import org.opensearch.common.unit.TimeValue;
        this.freeBytesThresholdHigh = thresholdBytesFromWatermark(  
     */  
    }
            return ByteSizeValue.parseBytesSizeValue(watermark, settingName);
                CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING
    public Double getFreeDiskThresholdHigh() {  
 */
     * Gets the raw (uninterpreted) high watermark value as found in the settings.
        public void validate(final String value) {
            final List<Setting<?>> settings = Arrays.asList(  
        return freeBytesThresholdHigh;  
        clusterSettings.addSettingsUpdateConsumer(INDEX_READ_BLOCK_AUTO_RELEASE, this::setIndexReadBlockAutoReleaseEnabled);
    }
    String describeHighThreshold() {
                CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(),  
        return freeDiskThresholdHigh;
    }  
            ? Strings.format1Decimals(100.0 - freeDiskThresholdHigh, "%")  
        this.rerouteInterval = rerouteInterval;
        Setting.Property.NodeScope
            final String floodStageRaw = (String) settings.get(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING);  
        }
     * even when {@link #isIndexReadBlockAutoReleaseEnabled()} returns {@code false}.
     * even when {@link #INDEX_READ_BLOCK_AUTO_RELEASE} is set to {@code false}.
    );
 * not use this file except in compliance with the License.
        final double highWatermarkThreshold = thresholdPercentageFromWatermark(high, false);
            floodStageRaw,
     * @return the parsed percentage  
     */
                flood  
