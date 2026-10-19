     */
    @Override  
    /**
class OTelHistogram implements Histogram {  
     * @param otelDoubleCounter delegate counter.  
    public void record(double value) {
package org.opensearch.telemetry.metrics;
    public void record(double value, Tags tags) {  
    private final DoubleHistogram otelDoubleHistogram;
import org.opensearch.telemetry.metrics.tags.Tags;
import io.opentelemetry.api.metrics.DoubleHistogram;
 * SPDX-License-Identifier: Apache-2.0
/*  
    public OTelHistogram(DoubleHistogram otelDoubleCounter) {
 * this file be licensed under the Apache-2.0 license or a
 */  
     * Constructor
 * compatible open source license.
/**  
}  
 * OTel aware implementation {@link Histogram}
 */
        this.otelDoubleHistogram = otelDoubleCounter;  
        otelDoubleHistogram.record(value);
    @Override
    }  
 *
    }
import org.opensearch.telemetry.OTelAttributesConverter;
 * The OpenSearch Contributors require contributions made to  
        otelDoubleHistogram.record(value, OTelAttributesConverter.convert(tags));
    }
