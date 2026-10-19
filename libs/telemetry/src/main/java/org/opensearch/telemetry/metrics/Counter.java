import org.opensearch.common.annotation.ExperimentalApi;
     */
public interface Counter {  
     * @param value value to be added.
 * {@opensearch.experimental}  
     */
 */  
     * @param value value to be added.
 *
    /**
    /**
/*  
@ExperimentalApi
 */
import org.opensearch.telemetry.metrics.tags.Tags;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
package org.opensearch.telemetry.metrics;
}
     * add value along with the attributes.  
/**
     * add value.  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    void add(double value);  
    void add(double value, Tags tags);
     * @param tags  attributes/dimensions of the metric.  
 * Counter adds the value to the existing metric.
     *
