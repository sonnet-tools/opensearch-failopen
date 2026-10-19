    }  
 * SPDX-License-Identifier: Apache-2.0
    }
     * @return map representation of breakdown  
     */
 * The OpenSearch Contributors require contributions made to  
 * A metric for profiling.  
import org.opensearch.common.annotation.ExperimentalApi;
     *  
    private final String name;
        return name;
    /**
 */
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
     * @return name of the metric
     *
public abstract class ProfileMetric {  
 */  
 *
package org.opensearch.search.profile;
    abstract public Map<String, Long> toBreakdownMap();
}  
    public ProfileMetric(String name) {
@ExperimentalApi
/**
    /**
     */
/*  
    public String getName() {  
import java.util.Map;  
        this.name = name;
