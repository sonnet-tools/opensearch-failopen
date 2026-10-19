 *
 */  
 */  
import java.io.Closeable;  
    @Override
    private final MetricsTelemetry metricsTelemetry;
    public DefaultMetricsRegistry(MetricsTelemetry metricsTelemetry) {
    public void close() throws IOException {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.telemetry.metrics;
    @Override  
        this.metricsTelemetry = metricsTelemetry;  
        return metricsTelemetry.createGauge(name, description, unit, value);
import java.util.function.Supplier;
        return metricsTelemetry.createCounter(name, description, unit);
    public Histogram createHistogram(String name, String description, String unit) {
    @Override
}
    public Closeable createGauge(String name, String description, String unit, Supplier<TaggedMeasurement> value) {  
    }
     * @param metricsTelemetry metrics telemetry.  
    /**
 * compatible open source license.
    public Closeable createGauge(String name, String description, String unit, Supplier<Double> valueProvider, Tags tags) {
/*  
import java.io.IOException;
    @Override
    }  
    public Counter createUpDownCounter(String name, String description, String unit) {  
        return metricsTelemetry.createGauge(name, description, unit, valueProvider, tags);
     */
        return metricsTelemetry.createHistogram(name, description, unit);  
     * Constructor
    }  
 * SPDX-License-Identifier: Apache-2.0
        metricsTelemetry.close();  
    }
 * Default implementation for {@link MetricsRegistry}
    }
    @Override  
class DefaultMetricsRegistry implements MetricsRegistry {
        return metricsTelemetry.createUpDownCounter(name, description, unit);
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.opensearch.telemetry.metrics.tags.Tags;
    }
/**
    public Counter createCounter(String name, String description, String unit) {
    }
