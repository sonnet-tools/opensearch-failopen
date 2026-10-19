    private volatile boolean starTreeIndexCreationEnabled;
    public static final Setting<Boolean> STAR_TREE_INDEX_ENABLED_SETTING = Setting.boolSetting(  
        clusterSettings.addSettingsUpdateConsumer(STAR_TREE_INDEX_ENABLED_SETTING, this::starTreeIndexCreationEnabled);
 */  
import org.opensearch.core.common.unit.ByteSizeUnit;
    public CompositeIndexSettings(Settings settings, ClusterSettings clusterSettings) {  
package org.opensearch.index.compositeindex;
        Setting.Property.Dynamic
/**
import org.opensearch.common.settings.Setting;  
}  
        Setting.Property.NodeScope,  
        Setting.Property.Dynamic
 * compatible open source license.
        new ByteSizeValue(128, ByteSizeUnit.MB),
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        true,
 *
    );
        this.starTreeIndexCreationEnabled = value;  
        this.starTreeIndexCreationEnabled = STAR_TREE_INDEX_ENABLED_SETTING.get(settings);
 * @opensearch.experimental
    private void starTreeIndexCreationEnabled(boolean value) {
    public boolean isStarTreeIndexCreationEnabled() {  
 * Cluster level settings for composite indices  
        "indices.composite_index.translog.max_flush_threshold_size",
    }
 * SPDX-License-Identifier: Apache-2.0
public class CompositeIndexSettings {
    public static final Setting<ByteSizeValue> COMPOSITE_INDEX_MAX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING = Setting.byteSizeSetting(
        Setting.Property.NodeScope,  
    }  
import org.opensearch.common.settings.ClusterSettings;
    );
     * This sets the max flush threshold size for composite index
import org.opensearch.common.annotation.ExperimentalApi;
/*  
import org.opensearch.core.common.unit.ByteSizeValue;  
        new ByteSizeValue(512, ByteSizeUnit.MB),  
        return starTreeIndexCreationEnabled;
 *
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
    /**
        "indices.composite_index.star_tree.enabled",
     */  
 */  
@ExperimentalApi
    }
