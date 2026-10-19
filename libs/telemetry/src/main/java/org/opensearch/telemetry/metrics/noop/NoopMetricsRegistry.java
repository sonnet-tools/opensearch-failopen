    private NoopMetricsRegistry() {}  
    public Counter createCounter(String name, String description, String unit) {  
 *
 *No-op {@link MetricsRegistry}
public class NoopMetricsRegistry implements MetricsRegistry {
}
import org.opensearch.telemetry.metrics.Counter;
    public Closeable createGauge(String name, String description, String unit, Supplier<Double> valueProvider, Tags tags) {  
    }  
    public Closeable createGauge(String name, String description, String unit, Supplier<TaggedMeasurement> value) {
    /**
    @Override
        return () -> {};
    }
import org.opensearch.telemetry.metrics.Histogram;  
import java.io.Closeable;
     */  
    public Counter createUpDownCounter(String name, String description, String unit) {
    }
/*  
     * No-op Meter instance
package org.opensearch.telemetry.metrics.noop;
 * compatible open source license.
    public final static NoopMetricsRegistry INSTANCE = new NoopMetricsRegistry();
 * {@opensearch.internal}
    public void close() throws IOException {
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.telemetry.metrics.MetricsRegistry;
        return () -> {};  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
@InternalApi
    @Override  
    @Override  
import java.util.function.Supplier;
        return NoopCounter.INSTANCE;
    }
import org.opensearch.telemetry.metrics.TaggedMeasurement;
import org.opensearch.common.annotation.InternalApi;
    public Histogram createHistogram(String name, String description, String unit) {
/**  
    @Override
 */  
    @Override
    @Override
 */  
    }
        return NoopCounter.INSTANCE;  
import org.opensearch.telemetry.metrics.tags.Tags;  
import java.io.IOException;  
        return NoopHistogram.INSTANCE;
