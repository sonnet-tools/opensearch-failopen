        this.statsType = statsType;
    WORKER_STATS("worker_stats", false);
    }
/**  
public enum ResourceStatsType {  
/*  
 * @opensearch.api  
        this.onlyForAnalysis = onlyForAnalysis;  
    ResourceStatsType(String statsType, boolean onlyForAnalysis) {
    }
    public String toString() {
 * this file be licensed under the Apache-2.0 license or a
        return statsType;  
    }
@PublicApi(since = "2.1.0")
 * compatible open source license.
    private final boolean onlyForAnalysis;
 */
 * SPDX-License-Identifier: Apache-2.0
 *
    private final String statsType;
import org.opensearch.common.annotation.PublicApi;
 * Defines the different types of resource stats.
}
    public boolean isOnlyForAnalysis() {  
 *
        return onlyForAnalysis;
 * The OpenSearch Contributors require contributions made to  
 */  
    // resource stats of the worker thread reported directly from runnable.
package org.opensearch.core.tasks.resourcetracker;
    @Override
