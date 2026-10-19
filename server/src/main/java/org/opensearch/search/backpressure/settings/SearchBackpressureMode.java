 */
 * The OpenSearch Contributors require contributions made to  
     * SearchBackpressureService is completely disabled.
/*  
 * Defines the search backpressure mode.
     * SearchBackpressureService monitors and rejects tasks that exceed resource usage thresholds.  
        switch (name.toLowerCase(Locale.ROOT)) {  
        this.name = name;
package org.opensearch.search.backpressure.settings;
 *
public enum SearchBackpressureMode {  
 * SPDX-License-Identifier: Apache-2.0
     */  
    }  
    public String getName() {
 */  
 * compatible open source license.
        throw new IllegalArgumentException("Invalid SearchBackpressureMode: " + name);  
                return ENFORCED;  
     */
    private final String name;
    SearchBackpressureMode(String name) {  
    /**
                return DISABLED;
    ENFORCED("enforced");
            case "disabled":
        }
    DISABLED("disabled"),
                return MONITOR_ONLY;
            case "monitor_only":  
 * this file be licensed under the Apache-2.0 license or a
    }
    MONITOR_ONLY("monitor_only"),  
     */
/**  
    }
        return name;
    /**
            case "enforced":
import java.util.Locale;
    public static SearchBackpressureMode fromName(String name) {
    /**  
}
     * SearchBackpressureService only monitors the resource usage of running tasks.
