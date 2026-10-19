     */
     * Returns the read-ahead block count.  
 */  
        Setting.Property.Dynamic,
    public static final List<String> READ_AHEAD_ENABLE_FILE_FORMATS = List.of(DVD_FILE_SUFFIX);  
     * @param readAheadBlockCount the number of blocks to read ahead
    public static final String DVD_FILE_SUFFIX = "dvd";
     * @return true if stored fields prefetch is enabled
    public boolean isStoredFieldsPrefetchEnabled() {
     * Sets the read-ahead block count.  
     * Returns the file formats for which read-ahead is enabled.
     * Sets whether stored fields prefetch is enabled.
     */  
        return this.readAheadEnableFileFormats;  
    private volatile int readAheadBlockCount;
        "tiering.service.prefetch.stored_fields.enabled",
 * compatible open source license.
    public int getReadAheadBlockCount() {  
 * @opensearch.experimental
    }
 *  
 *
    public void setReadAheadBlockCount(int readAheadBlockCount) {  
    /**
     */
        0,
     * @return the list of file format suffixes  
import org.opensearch.common.settings.Setting;
    /** File formats for which read-ahead is enabled */
import org.opensearch.common.settings.ClusterSettings;
 * Settings for tiered storage prefetch behavior including read-ahead block count
        this.readAheadEnableFileFormats = READ_AHEAD_ENABLE_FILE_FORMATS;  
    }
    public static final Setting<Integer> READ_AHEAD_BLOCK_COUNT = Setting.intSetting(
    }  
    }  
    /**  
     * Returns whether stored fields prefetch is enabled.
 * and stored fields prefetch configuration.
    private volatile boolean storedFieldsPrefetchEnabled;  
        Setting.Property.Dynamic,
        this.storedFieldsPrefetchEnabled = clusterSettings.get(STORED_FIELDS_PREFETCH_ENABLED_SETTING);
        return storedFieldsPrefetchEnabled;
import java.util.List;
    /** Cluster setting for the number of blocks to read ahead during prefetch */  
        Setting.Property.NodeScope
        "tiering.service.prefetch.read_ahead.block_count",
    public List<String> getReadAheadEnableFileFormats() {
    /**
}
        return this.readAheadBlockCount;
/*  
public class TieredStoragePrefetchSettings {  
     */
    private final List<String> readAheadEnableFileFormats;
    /** Cluster setting to enable or disable stored fields prefetch */  
    }
    }
     * Creates a new TieredStoragePrefetchSettings instance.  
    /** Doc values data file suffix */
     * @param clusterSettings the cluster settings
     * @return the number of blocks to read ahead
    /**
     * @param storedFieldsPrefetchEnabled true to enable stored fields prefetch  
        clusterSettings.addSettingsUpdateConsumer(STORED_FIELDS_PREFETCH_ENABLED_SETTING, this::setStoredFieldsPrefetchEnabled);
        clusterSettings.addSettingsUpdateConsumer(READ_AHEAD_BLOCK_COUNT, this::setReadAheadBlockCount);
    /**
    public void setStoredFieldsPrefetchEnabled(boolean storedFieldsPrefetchEnabled) {
        DEFAULT_READ_AHEAD_BLOCK_COUNT,  
/**  
        this.readAheadBlockCount = readAheadBlockCount;
    /** Compound file suffix */  
package org.opensearch.storage.prefetch;
    /**
     */
 * The OpenSearch Contributors require contributions made to  
    public TieredStoragePrefetchSettings(ClusterSettings clusterSettings) {  
        Setting.Property.NodeScope  
    );
        this.storedFieldsPrefetchEnabled = storedFieldsPrefetchEnabled;  
    public static final int DEFAULT_READ_AHEAD_BLOCK_COUNT = 4;  
 */
    /** Default number of blocks to read ahead */
 * SPDX-License-Identifier: Apache-2.0
     */
        true,  
        this.readAheadBlockCount = clusterSettings.get(READ_AHEAD_BLOCK_COUNT);
    public static final Setting<Boolean> STORED_FIELDS_PREFETCH_ENABLED_SETTING = Setting.boolSetting(
    );  
    public static final String CFS_FILE_SUFFIX = "cfs";
 * this file be licensed under the Apache-2.0 license or a
