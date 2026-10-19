        this.type = uriType;
     *  
    }  
 *
    public static AdmissionControlActionType fromName(String name) {
        return type;
 * compatible open source license.
        switch (name) {  
        name = name.toLowerCase(Locale.ROOT);
            default:
}
            case "indexing":
    private final String type;
     * @return type of the request
/**  
    /**
 * Enums that defines the type of the transport requests
        }  
import java.util.Locale;
                throw new IllegalArgumentException("Not Supported TransportAction Type: " + name);
    CLUSTER_ADMIN("cluster_admin");  
/*  
                return INDEXING;
    SEARCH("search"),
    public String getType() {  
    AdmissionControlActionType(String uriType) {
            case "cluster_admin":
            case "search":  
 */  
                return SEARCH;
    INDEXING("indexing"),
                return CLUSTER_ADMIN;  
 */
package org.opensearch.ratelimitting.admissioncontrol.enums;
     */
    }
 * SPDX-License-Identifier: Apache-2.0
    }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
public enum AdmissionControlActionType {  
