        this.statsName = statsName;
}
    private final String statsName;
 *
 *
 * compatible open source license.
 *  Different resource stats are defined.
 * The OpenSearch Contributors require contributions made to  
 */
    @Override
    public String toString() {
    CPU("cpu_time_in_nanos"),
    }
public enum ResourceStats {  
    }
 */  
    ResourceStats(String statsName) {  
package org.opensearch.core.tasks.resourcetracker;
        return statsName;  
import org.opensearch.common.annotation.PublicApi;
    MEMORY("memory_in_bytes");
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *  @opensearch.api  
@PublicApi(since = "2.1.0")
/*  
/**  
