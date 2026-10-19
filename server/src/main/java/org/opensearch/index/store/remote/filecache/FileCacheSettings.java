    }  
    /**
     * the file cache. For example, if 100GB disk space is configured for use as a file cache and the
 * compatible open source license.
        setRemoteDataRatio(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.get(settings));
    );
        return remoteDataRatio;
 *
 * SPDX-License-Identifier: Apache-2.0
    public static final Setting<Double> DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING = Setting.doubleSetting(
     * remote_data_ratio of 5 is defined, then a total of 500GB of remote data can be loaded as searchable snapshots.
import org.opensearch.common.settings.Setting;
    private volatile double remoteDataRatio;
    }
        5.0,
     * This is designed to be a safeguard to prevent oversubscribing a cluster.  
    public double getRemoteDataRatio() {  
/*  
     */
        Setting.Property.NodeScope,  
 * The OpenSearch Contributors require contributions made to  
    }
     * Defines a limit of how much total remote data can be referenced as a ratio of the size of the disk reserved for  
 * Settings relate to file cache  
 */  
}  
import org.opensearch.common.settings.Settings;  
/**
package org.opensearch.index.store.remote.filecache;
        this.remoteDataRatio = remoteDataRatio;  
 * @opensearch.internal
 *
import org.opensearch.common.settings.ClusterSettings;
 * this file be licensed under the Apache-2.0 license or a
        Setting.Property.Dynamic
    public FileCacheSettings(Settings settings, ClusterSettings clusterSettings) {  
        clusterSettings.addSettingsUpdateConsumer(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING, this::setRemoteDataRatio);
 */  
        1.0,
public class FileCacheSettings {
        "cluster.filecache.remote_data_ratio",  
    public void setRemoteDataRatio(double remoteDataRatio) {
