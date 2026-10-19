    public ResourceStats getStats() {  
 *  @opensearch.api  
import org.opensearch.common.annotation.PublicApi;
/**  
/*  
@PublicApi(since = "2.1.0")
 * Information about resource usage
 * The OpenSearch Contributors require contributions made to  
    }  
        return value;
}
 *
public class ResourceUsageMetric {  
package org.opensearch.core.tasks.resourcetracker;
 * this file be licensed under the Apache-2.0 license or a
        this.stats = stats;
 * compatible open source license.
    public ResourceUsageMetric(ResourceStats stats, long value) {
    private final ResourceStats stats;
    }
    }
        return stats;
 * SPDX-License-Identifier: Apache-2.0
        this.value = value;  
 *
 */  
    public long getValue() {
    private final long value;
 */
