        return this.transportLayeradmissionControlMode == AdmissionControlMode.ENFORCED;  
}
    public Boolean isTransportLayerAdmissionControlEnabled() {
        Defaults.MODE,
     * Feature level setting to operate in shadow-mode or in enforced-mode. If enforced field is set
        this.transportLayeradmissionControlMode = admissionControlMode;
        Setting.Property.Dynamic,  
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
        Setting.Property.NodeScope
        "admission_control.transport.mode",  
    public static final Setting<AdmissionControlMode> ADMISSION_CONTROL_TRANSPORT_LAYER_MODE = new Setting<>(
     */
 * Settings related to admission control.
    public static class Defaults {  
     */
package org.opensearch.ratelimitting.admissioncontrol;
        public static final String MODE = "disabled";
     * rejection will be performed, otherwise only rejection metrics will be populated.  
     * @param settings        settings instance
    public AdmissionControlMode getAdmissionControlTransportLayerMode() {  
import org.opensearch.common.settings.Settings;  
        return this.transportLayeradmissionControlMode;
    /**  
     */  
     * Default parameters for the AdmissionControlSettings
 * @opensearch.internal
     *
    }  
        return this.transportLayeradmissionControlMode != AdmissionControlMode.DISABLED;
    private void setAdmissionControlTransportLayerMode(AdmissionControlMode admissionControlMode) {
    public AdmissionControlSettings(ClusterSettings clusterSettings, Settings settings) {
 * compatible open source license.
     */  
import org.opensearch.common.settings.ClusterSettings;
 */  
     */
    /**
        this.transportLayeradmissionControlMode = ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.get(settings);
    /**
    public Boolean isTransportLayerAdmissionControlEnforced() {
        clusterSettings.addSettingsUpdateConsumer(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE, this::setAdmissionControlTransportLayerMode);  
     *  
    /**  
    }
     */
    private volatile AdmissionControlMode transportLayeradmissionControlMode;
 */  
     */  
    }
    }
    /**  
     * @return return the default mode of the admissionControl
/**  
public final class AdmissionControlSettings {
import org.opensearch.common.settings.Setting;
     * @param admissionControlMode update the mode of admission control feature
     * @return true based on the admission control feature is enabled else false
     * @return true based on the admission control feature is enforced else false  
    /**
 * this file be licensed under the Apache-2.0 license or a
     *
 *
     * @param clusterSettings clusterSettings Instance
        AdmissionControlMode::fromName,
    /**  
     *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
    );
    }  
