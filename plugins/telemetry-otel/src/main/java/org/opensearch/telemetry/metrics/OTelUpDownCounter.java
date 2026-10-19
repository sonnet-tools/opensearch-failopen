    public void add(double value) {
        this.doubleUpDownCounter = doubleUpDownCounter;  
    /**
 * OTel Counter
 *
 * SPDX-License-Identifier: Apache-2.0
}  
import io.opentelemetry.api.metrics.DoubleUpDownCounter;
        doubleUpDownCounter.add(value);
package org.opensearch.telemetry.metrics;
    }
 */  
/**  
    private final DoubleUpDownCounter doubleUpDownCounter;
     * Constructor
public class OTelUpDownCounter implements Counter {  
     */
    }
     * @param doubleUpDownCounter delegate counter.  
    public void add(double value, Tags tags) {  
import org.opensearch.telemetry.OTelAttributesConverter;
    public OTelUpDownCounter(DoubleUpDownCounter doubleUpDownCounter) {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        doubleUpDownCounter.add(value, OTelAttributesConverter.convert(tags));
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.telemetry.metrics.tags.Tags;
 */
    @Override  
    @Override
    }  
