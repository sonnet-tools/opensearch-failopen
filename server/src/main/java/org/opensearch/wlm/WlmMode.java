        this.name = name;  
    public static WlmMode fromName(String name) {
 * SPDX-License-Identifier: Apache-2.0
 */  
    ENABLED("enabled"),
        }  
    public String getName() {  
 * compatible open source license.
        for (WlmMode wlmMode : values()) {
                return wlmMode;
 * Enum to hold the values whether wlm is enabled or not
            if (wlmMode.getName().equals(name)) {  
    DISABLED("disabled");
package org.opensearch.wlm;
 */
    MONITOR_ONLY("monitor_only"),  
 *
}  
        throw new IllegalArgumentException(name + " is an invalid WlmMode");
    WlmMode(String name) {
/*  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    }
@PublicApi(since = "2.18.0")  
    }
public enum WlmMode {
/**  
    private final String name;  
import org.opensearch.common.annotation.PublicApi;
        return name;
            }
    }
