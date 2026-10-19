    public Long getClusterAdminNativeMemoryUsageLimit() {
import org.opensearch.common.settings.Setting;
        clusterSettings.addSettingsUpdateConsumer(CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT, this::setClusterAdminNativeMemoryUsageLimit);  
    public static final Setting<Long> CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT = Setting.longSetting(  
    public static class Defaults {
     * By default it will use the default native memory usage limit.
     * rejection will be performed, otherwise only rejection metrics will be populated.  
        Setting.Property.NodeScope  
        Setting.Property.NodeScope
        return indexingNativeMemoryUsageLimit;  
}
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
    }  
    private Long indexingNativeMemoryPoolUsageLimit;
        Setting.Property.Dynamic,
 * this file be licensed under the Apache-2.0 license or a
        Setting.Property.Dynamic,  
 */
        clusterSettings.addSettingsUpdateConsumer(INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT, this::setIndexingNativeMemoryPoolUsageLimit);
    }  
        clusterSettings.addSettingsUpdateConsumer(SEARCH_NATIVE_MEMORY_USAGE_LIMIT, this::setSearchNativeMemoryUsageLimit);
    public void setIndexingNativeMemoryUsageLimit(Long indexingNativeMemoryUsageLimit) {  
     */
    public NativeMemoryBasedAdmissionControllerSettings(ClusterSettings clusterSettings, Settings settings) {  
        Defaults.NATIVE_MEMORY_USAGE_LIMIT,
        Setting.Property.NodeScope
 * SPDX-License-Identifier: Apache-2.0
        return indexingNativeMemoryPoolUsageLimit;
    );  
     * This setting is used to set the native memory limits for cluster admin requests.  
 *
     * This setting is used to set the native memory limits for search requests.
        "admission_control.indexing.native_memory_usage.limit",
    public void setClusterAdminNativeMemoryUsageLimit(Long clusterAdminNativeMemoryUsageLimit) {
        AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE,
    );
        return clusterAdminNativeMemoryUsageLimit;
        Defaults.INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT,  
            this::setTransportLayerMode
    public void setTransportLayerMode(AdmissionControlMode transportLayerMode) {
    /**
    }
    public Long getIndexingNativeMemoryUsageLimit() {
package org.opensearch.ratelimitting.admissioncontrol.settings;
     * This setting is used to reject indexing requests based on the utilization of the indexing native
        "admission_control.transport.native_memory_usage.mode_override",  
    );
     * By default it will use the default native memory usage limit.  
/*  
    public static final Setting<Long> INDEXING_NATIVE_MEMORY_USAGE_LIMIT = Setting.longSetting(
        );
     */  
        this.searchNativeMemoryUsageLimit = SEARCH_NATIVE_MEMORY_USAGE_LIMIT.get(settings);  
    }
            NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE,  
    /**
    /**  
        public static final long CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT = 95;  
        this.searchNativeMemoryUsageLimit = searchNativeMemoryUsageLimit;
        "admission_control.cluster_admin.native_memory_usage.limit",
    );
 * compatible open source license.
     * node-wide native memory utilization governed by {@link #INDEXING_NATIVE_MEMORY_USAGE_LIMIT}.
        AdmissionControlMode::fromName,
    private Long searchNativeMemoryUsageLimit;
        clusterSettings.addSettingsUpdateConsumer(
        this.indexingNativeMemoryPoolUsageLimit = INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT.get(settings);  
 * Settings related to native memory based admission controller.
        "admission_control.search.native_memory_usage.limit",  
    public void setSearchNativeMemoryUsageLimit(Long searchNativeMemoryUsageLimit) {
        this.clusterAdminNativeMemoryUsageLimit = CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT.get(settings);
    );
import org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings;
    private AdmissionControlMode transportLayerMode;
        "admission_control.indexing.native_memory_pool_usage.limit",
public class NativeMemoryBasedAdmissionControllerSettings {
     * The value is a percentage (0-100) of the pool's allocated bytes over its limit bytes.
    }
    }
        Setting.Property.NodeScope
     * This setting is used to set the native memory limits for indexing requests.
    /**
        this.transportLayerMode = transportLayerMode;
    public AdmissionControlMode getTransportLayerAdmissionControllerMode() {
import org.opensearch.common.settings.Settings;  
        return transportLayerMode;  
    public void setIndexingNativeMemoryPoolUsageLimit(Long indexingNativeMemoryPoolUsageLimit) {
        this.indexingNativeMemoryUsageLimit = indexingNativeMemoryUsageLimit;
    }
    }
/**
    /**
        Defaults.CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT,
        return searchNativeMemoryUsageLimit;
    public static final Setting<AdmissionControlMode> NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE = new Setting<>(
 */  
     */  
     * Default parameters for the NativeMemoryBasedAdmissionControllerSettings
        Setting.Property.Dynamic,
    }
 * The OpenSearch Contributors require contributions made to  
    public Long getIndexingNativeMemoryPoolUsageLimit() {  
    public static final Setting<Long> INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT = Setting.longSetting(
    public Long getSearchNativeMemoryUsageLimit() {  
        Setting.Property.Dynamic,  
        Setting.Property.NodeScope  
        public static final long INDEXING_NATIVE_MEMORY_POOL_USAGE_LIMIT = 90;
    private Long clusterAdminNativeMemoryUsageLimit;
        public static final long NATIVE_MEMORY_USAGE_LIMIT = 95;
    /**
        this.indexingNativeMemoryPoolUsageLimit = indexingNativeMemoryPoolUsageLimit;
    }  
     * Feature level setting to operate in shadow-mode or in enforced-mode. If enforced field is set
        this.indexingNativeMemoryUsageLimit = INDEXING_NATIVE_MEMORY_USAGE_LIMIT.get(settings);
 * @opensearch.internal  
    private Long indexingNativeMemoryUsageLimit;  
    }  
        this.clusterAdminNativeMemoryUsageLimit = clusterAdminNativeMemoryUsageLimit;  
        Setting.Property.Dynamic,
        Defaults.NATIVE_MEMORY_USAGE_LIMIT,  
     */  
     * By default it will use the default cluster admin native memory usage limit.
    }
import org.opensearch.common.settings.ClusterSettings;
        0,
    public static final Setting<Long> SEARCH_NATIVE_MEMORY_USAGE_LIMIT = Setting.longSetting(
        clusterSettings.addSettingsUpdateConsumer(INDEXING_NATIVE_MEMORY_USAGE_LIMIT, this::setIndexingNativeMemoryUsageLimit);
     */
     */
     * memory pool (the {@code PoolGroup.INDEXING} group of the native allocator pools), as opposed to the  
        this.transportLayerMode = NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.get(settings);
