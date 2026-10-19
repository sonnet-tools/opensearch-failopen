    }
 * compatible open source license.
        otelDoubleCounter.add(value);
 * OTel Counter
    @Override  
class OTelCounter implements Counter {  
package org.opensearch.telemetry.metrics;
import io.opentelemetry.api.metrics.DoubleCounter;
    public OTelCounter(DoubleCounter otelDoubleCounter) {
}  
     * @param otelDoubleCounter delegate counter.  
    }
 *
    @Override
    public void add(double value, Tags tags) {  
     * Constructor
        otelDoubleCounter.add(value, OTelAttributesConverter.convert(tags));
 * this file be licensed under the Apache-2.0 license or a
    }  
/*  
import org.opensearch.telemetry.OTelAttributesConverter;
 */  
    private final DoubleCounter otelDoubleCounter;
 */
/**  
        this.otelDoubleCounter = otelDoubleCounter;  
    public void add(double value) {
    /**
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
     */
import org.opensearch.telemetry.metrics.tags.Tags;
