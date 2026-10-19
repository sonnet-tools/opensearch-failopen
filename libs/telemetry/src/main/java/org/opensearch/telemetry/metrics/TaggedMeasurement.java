    public Tags getTags() {
        this.tags = tags;
/**
     * Returns the tags.
    public static TaggedMeasurement create(double value, Tags tags) {
    }  
     * Factory method to create the {@link TaggedMeasurement} object.
     */
import org.opensearch.common.annotation.ExperimentalApi;
 * Observable Measurement for the Asynchronous instruments.
        this.value = value;  
    /**  
import org.opensearch.telemetry.metrics.tags.Tags;
    public Double getValue() {
@ExperimentalApi
     * @return tags
 */  
    private TaggedMeasurement(double value, Tags tags) {
 */
 * compatible open source license.
    private final Double value;
     * @return tagged measurement TaggedMeasurement
 * SPDX-License-Identifier: Apache-2.0
    private final Tags tags;
     */  
     * Returns the value.
 * @opensearch.experimental  
 * The OpenSearch Contributors require contributions made to  
    }
public final class TaggedMeasurement {  
    /**
        return tags;
 * this file be licensed under the Apache-2.0 license or a
}
     * @param value value.  
/*  
     * @param tags tags to be added per value.
    /**
package org.opensearch.telemetry.metrics;
        return value;  
    }
     */  
        return new TaggedMeasurement(value, tags);
    }  
 *
     * @return value  
