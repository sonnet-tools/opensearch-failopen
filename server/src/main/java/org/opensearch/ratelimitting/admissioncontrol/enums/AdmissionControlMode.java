    }
    /**
}
     */
     * AdmissionController monitors and rejects tasks that exceed resource usage thresholds.  
    /**
     *
 *
 */  
                return ENFORCED;  
 * The OpenSearch Contributors require contributions made to  
     */
    /**  
     * @return mode of the admission controller  
import java.util.Locale;
/**  
            case "enforced":
        return this.mode;  
package org.opensearch.ratelimitting.admissioncontrol.enums;
    /**  
        switch (name.toLowerCase(Locale.ROOT)) {  
    ENFORCED("enforced");
     *
            case "disabled":
        this.mode = mode;
    public String getMode() {
     * AdmissionController only monitors the rejection criteria for the requests.
                return MONITOR;
public enum AdmissionControlMode {  
            case "monitor_only":  
                throw new IllegalArgumentException("Invalid AdmissionControlMode: " + name);
     */  
 * Defines the AdmissionControlMode
/*  
     * @return Enum of AdmissionControlMode based on the mode  
     */
     * @param name is the mode of the current
 * this file be licensed under the Apache-2.0 license or a
    /**
            default:
    }
     * @param mode update mode of the admission controller
     */
                return DISABLED;
    }
 * compatible open source license.
 */
    private final String mode;
     */
    DISABLED("disabled"),
    AdmissionControlMode(String mode) {  
        }  
 * SPDX-License-Identifier: Apache-2.0
     * AdmissionController is completely disabled.
    /**  
    public static AdmissionControlMode fromName(String name) {
    MONITOR("monitor_only"),  
