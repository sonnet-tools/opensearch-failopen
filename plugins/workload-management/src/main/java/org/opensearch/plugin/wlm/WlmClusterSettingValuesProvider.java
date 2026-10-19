    }
    }
/*  
    private volatile WlmMode wlmMode;  
     * @param mode The wlm mode to set  
        this.wlmMode = mode;  
     */
 * this file be licensed under the Apache-2.0 license or a
        }
 *
import org.opensearch.common.settings.Settings;
/**  
    /**
    private void setWlmMode(WlmMode mode) {
 */  
                    + " because workload management mode is disabled or monitor_only."
     */
    /**  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.wlm.WorkloadManagementSettings;
        if (wlmMode != WlmMode.ENABLED) {  
     * Constructor for WlmClusterSettingValuesProvider  
package org.opensearch.plugin.wlm;
 * This class listens for updates to relevant settings and provides the latest setting values.
     */  
public class WlmClusterSettingValuesProvider {
     * Check if WLM mode is ENABLED
     * Set the latest WLM mode.
     * Throws an IllegalStateException if WLM mode is DISABLED or MONITOR ONLY.
    public WlmClusterSettingValuesProvider(Settings settings, ClusterSettings clusterSettings) {
    public void ensureWlmEnabled(String operationDescription) {
 * Central provider for maintaining and supplying the current values of wlm cluster settings.
     * @param settings OpenSearch settings
 * compatible open source license.
                    + "To enable this feature, set [wlm.workload_group.mode] to 'enabled' in cluster settings."
    public WlmMode getWlmMode() {  
 * The OpenSearch Contributors require contributions made to  
        clusterSettings.addSettingsUpdateConsumer(WorkloadManagementSettings.WLM_MODE_SETTING, this::setWlmMode);  
     */
import org.opensearch.wlm.WlmMode;  
    }
import org.opensearch.common.settings.ClusterSettings;
     * @param operationDescription A short text describing the operation, e.g. "create workload group".  
 */  
                "Cannot "
    /**
     * Get the latest WLM mode.
}  
    /**  
        this.wlmMode = WorkloadManagementSettings.WLM_MODE_SETTING.get(settings);
            );  
    }
            throw new IllegalStateException(
        return wlmMode;
                    + operationDescription  
     * @param clusterSettings Cluster settings to register update listener
