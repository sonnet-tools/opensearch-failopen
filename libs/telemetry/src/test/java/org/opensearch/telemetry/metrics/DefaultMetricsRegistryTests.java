            "test counter",
    }
            "test observable gauge",
    public void testUpDownCounter() {
        assertSame(mockCloseable, closeable);  
 *
public class DefaultMetricsRegistryTests extends OpenSearchTestCase {
import static org.mockito.ArgumentMatchers.any;
package org.opensearch.telemetry.metrics;
        Counter mockCounter = mock(Counter.class);  
    public void setUp() throws Exception {
        Closeable mockCloseable = mock(Closeable.class);
    private DefaultMetricsRegistry defaultMeterRegistry;
    public void testGauge() {  
            "ms"  
        when(defaultMeterRegistry.createGauge(any(String.class), any(String.class), any(String.class), any(Supplier.class))).thenReturn(  
    }  
            "1"
 * The OpenSearch Contributors require contributions made to  
        when(defaultMeterRegistry.createCounter(any(String.class), any(String.class), any(String.class))).thenReturn(mockCounter);
            "org.opensearch.telemetry.metrics.DefaultMeterRegistryTests.testObservableGauge",  
        when(defaultMeterRegistry.createUpDownCounter(any(String.class), any(String.class), any(String.class))).thenReturn(mockCounter);  
    private MetricsTelemetry metricsTelemetry;
        );
        Counter counter = defaultMeterRegistry.createUpDownCounter(
            "org.opensearch.telemetry.metrics.DefaultMeterRegistryTests.testUpDownCounter",
    public void testHistogram() {  
        Histogram mockHistogram = mock(Histogram.class);
        assertSame(mockHistogram, histogram);
        Counter counter = defaultMeterRegistry.createCounter(
import org.opensearch.test.OpenSearchTestCase;
            "ms",
    @SuppressWarnings("unchecked")
        Closeable mockCloseable = mock(Closeable.class);
        Closeable closeable = defaultMeterRegistry.createGauge(
            "org.opensearch.telemetry.metrics.DefaultMeterRegistryTests.testHistogram",
            () -> TaggedMeasurement.create(1.0, Tags.EMPTY)
        Closeable closeable = defaultMeterRegistry.createGauge(  
            "org.opensearch.telemetry.metrics.DefaultMeterRegistryTests.testObservableGauge",
            "1"
            "test up-down counter",  
        super.setUp();  
        );
 */  
        );
            "ms",  
        when(defaultMeterRegistry.createHistogram(any(String.class), any(String.class), any(String.class))).thenReturn(mockHistogram);
        assertSame(mockCounter, counter);
            "org.opensearch.telemetry.metrics.DefaultMeterRegistryTests.testCounter",  
        );
/*  
import static org.mockito.Mockito.mock;
        );  
    }
    @Override
            mockCloseable
import org.opensearch.telemetry.metrics.tags.Tags;
        ).thenReturn(mockCloseable);
    @SuppressWarnings("unchecked")  
 * SPDX-License-Identifier: Apache-2.0
            () -> 1.0,  
        assertSame(mockCloseable, closeable);  
        defaultMeterRegistry = new DefaultMetricsRegistry(metricsTelemetry);
        assertSame(mockCounter, counter);  
import static org.mockito.Mockito.when;  
    }  
 * this file be licensed under the Apache-2.0 license or a
        );
            Tags.EMPTY
    }
        when(
        Counter mockCounter = mock(Counter.class);
            "test up-down counter",
            defaultMeterRegistry.createGauge(any(String.class), any(String.class), any(String.class), any(Supplier.class), any(Tags.class))  
import java.util.function.Supplier;
}  
 * compatible open source license.
    public void testGaugeWithValueAndTagSupplier() {
        metricsTelemetry = mock(MetricsTelemetry.class);
import java.io.Closeable;
    }
    public void testCounter() {
            "test observable gauge",
        Histogram histogram = defaultMeterRegistry.createHistogram(  
