    @Override  
import org.opensearch.telemetry.metrics.noop.NoopHistogram;
            public Closeable createGauge(String name, String description, String unit, Supplier<Double> valueProvider, Tags tags) {
    public MetricsTelemetry getMetricsTelemetry() {
                return NoopCounter.INSTANCE;
import org.opensearch.telemetry.Telemetry;
            public void close() {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.telemetry.metrics.MetricsTelemetry;
        return new MetricsTelemetry() {
import java.io.Closeable;
import org.opensearch.telemetry.tracing.TracingTelemetry;
     * @param settings telemetry settings.
            }  
    }  
}
                return NoopCounter.INSTANCE;
            @Override
     * Constructor with settings.  
import org.opensearch.telemetry.metrics.noop.NoopCounter;
import org.opensearch.telemetry.metrics.Histogram;
            @Override
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Supplier;
            }  
            @Override
            }
        return new MockTracingTelemetry();  
 */  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.test.telemetry;
import org.opensearch.telemetry.metrics.Counter;  
    }
                return NoopHistogram.INSTANCE;  
            public Histogram createHistogram(String name, String description, String unit) {
        };
            }
                return () -> {};
public class MockTelemetry implements Telemetry {
    }
/*  
            }
import org.opensearch.telemetry.metrics.TaggedMeasurement;  
/**
    /**
    public MockTelemetry(TelemetrySettings settings) {  
import org.opensearch.telemetry.metrics.tags.Tags;  
 *
 * Mock {@link Telemetry} implementation for testing.
            @Override  
    @Override
            @Override  
import org.opensearch.telemetry.TelemetrySettings;
     */
import org.opensearch.test.telemetry.tracing.MockTracingTelemetry;
            }
    public TracingTelemetry getTracingTelemetry() {
                return () -> {};
            @Override
            public Counter createUpDownCounter(String name, String description, String unit) {  
 */  
 * compatible open source license.
            public Closeable createGauge(String name, String description, String unit, Supplier<TaggedMeasurement> value) {  
            public Counter createCounter(String name, String description, String unit) {
