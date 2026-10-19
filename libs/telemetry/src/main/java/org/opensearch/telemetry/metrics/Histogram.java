 */  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
/*  
     * @param value value to be added.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.telemetry.metrics;
 * SPDX-License-Identifier: Apache-2.0
     * @param value value to be added.
    void record(double value, Tags tags);
}
 */
 *
     * record value.  
/**
import org.opensearch.telemetry.metrics.tags.Tags;
     */
     * @param tags  attributes/dimensions of the metric.  
     *
import org.opensearch.common.annotation.ExperimentalApi;
    void record(double value);  
     * record value along with the attributes.  
 * Histogram records the value for an existing metric.
@ExperimentalApi
 * {@opensearch.experimental}  
    /**
     */
    /**
public interface Histogram {  
