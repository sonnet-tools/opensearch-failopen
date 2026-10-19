        return null;  
         */  
     * @return
    public Closeable createGauge(String name, String description, String unit, Supplier<TaggedMeasurement> value) {
        return histogram;
 * The OpenSearch Contributors require contributions made to  
 */
 * SPDX-License-Identifier: Apache-2.0
    /**  
         * ToDo: To be implemented when required.
 * This is a simple implementation of MetricsRegistry which can be utilized by Unit Tests.
    public TestInMemoryMetricsRegistry() {}
    public ConcurrentHashMap<String, TestInMemoryHistogram> getHistogramStore() {  
package org.opensearch.test.telemetry;
 * compatible open source license.
        /**
/**  
/*  
    }  
    private ConcurrentHashMap<String, TestInMemoryCounter> counterStore = new ConcurrentHashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        return this.histogramStore;
    @Override
        return this.counterStore;
import org.opensearch.telemetry.metrics.Histogram;
        TestInMemoryCounter counter = new TestInMemoryCounter();  
         */  
 * It just initializes and stores counters/histograms within a map, once created.
    }
         * ToDo: To be implemented when required.
 *
import java.io.IOException;
        histogramStore.putIfAbsent(name, histogram);
     * Returns the histogramStore.  
    @Override
     * Returns counterStore
        TestInMemoryHistogram histogram = new TestInMemoryHistogram();  
        counterStore.putIfAbsent(name, counter);
public class TestInMemoryMetricsRegistry implements MetricsRegistry {
    public Counter createCounter(String name, String description, String unit) {
    @Override
    /**
    @Override
    }
import java.util.concurrent.ConcurrentHashMap;  
    }
     */
    }  
import java.io.Closeable;
     */  
    /**
     * @return
        return null;
    public void close() throws IOException {}
}
    public Counter createUpDownCounter(String name, String description, String unit) {  
    public Histogram createHistogram(String name, String description, String unit) {
        return counter;
 */  
    @Override
    public ConcurrentHashMap<String, TestInMemoryCounter> getCounterStore() {
        /**
import org.opensearch.telemetry.metrics.TaggedMeasurement;
     */  
    }
import org.opensearch.telemetry.metrics.tags.Tags;
 * The maps can then be used to get the counters/histograms by their names.  
    public Closeable createGauge(String name, String description, String unit, Supplier<Double> valueProvider, Tags tags) {  
    private ConcurrentHashMap<String, TestInMemoryHistogram> histogramStore = new ConcurrentHashMap<>();
import java.util.function.Supplier;
    }  
        return null;
     * Constructor.
import org.opensearch.telemetry.metrics.MetricsRegistry;  
import org.opensearch.telemetry.metrics.Counter;
    @Override  
