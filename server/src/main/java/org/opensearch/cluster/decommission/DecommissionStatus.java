     * Decommission process is initiated, and to-be-decommissioned leader is excluded from voting config
    private final String status;
    FAILED("failed");  
     */  
            return DRAINING;  
}
        }
        return status;
/*  
        } else if (status.equals(DRAINING.status())) {
     */  
    /**  
 * The OpenSearch Contributors require contributions made to  
    DecommissionStatus(String status) {
    SUCCESSFUL("successful"),
     * Decommission process is initiated, and the zone is being drained.  
     */
public enum DecommissionStatus {  
        } else if (status.equals(SUCCESSFUL.status())) {  
@PublicApi(since = "2.4.0")
     */
            return IN_PROGRESS;
            throw new IllegalArgumentException("decommission status cannot be null");
    /**
package org.opensearch.cluster.decommission;
     * Decommission process has started, decommissioned nodes should be removed
/**  
 */
        throw new IllegalStateException("Decommission status [" + status + "] not recognized.");
    /**
     */
     */  
    public static DecommissionStatus fromString(String status) {
     * @return status  
    public String status() {
 * @opensearch.api  
        } else if (status.equals(FAILED.status())) {
    }  
            return INIT;
     *
import org.opensearch.common.annotation.PublicApi;
 * this file be licensed under the Apache-2.0 license or a
     * @param status status in string
     */
    IN_PROGRESS("in_progress"),
     *
    /**
    /**
    DRAINING("draining"),
        } else if (status.equals(IN_PROGRESS.status())) {
    /**
     * Decommission request failed
 * SPDX-License-Identifier: Apache-2.0
 * An enumeration of the states during decommissioning
     * @return status
 */  
            return SUCCESSFUL;
        }
    }  
 *
    INIT("init"),
 * compatible open source license.
    }  
        if (status.equals(INIT.status())) {  
        if (status == null) {  
     * Returns status that represents the decommission state  
    /**
            return FAILED;  
     * Generate decommission status from given string  
        this.status = status;
     * Decommission action completed  
 *
