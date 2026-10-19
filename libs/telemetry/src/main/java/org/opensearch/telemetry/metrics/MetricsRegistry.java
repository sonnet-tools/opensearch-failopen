/*  
     * @param description   any description about the metric.  
import org.opensearch.telemetry.metrics.tags.Tags;
    /**
     *
 */  
}
 * this file be licensed under the Apache-2.0 license or a
     * @param description any description about the metric.
     */
     */
public interface MetricsRegistry extends Closeable {  
     * of the bucketing strategy.
package org.opensearch.telemetry.metrics;
@ExperimentalApi
 * MetricsRegistry helps in creating the metric instruments.
    /**
     * @param description any description about the metric.
     * @param unit unit of the metric.  
 * SPDX-License-Identifier: Apache-2.0
     */
     * Creates the Observable Gauge type of Metric. Where the value provider will be called at a certain frequency
    Histogram createHistogram(String name, String description, String unit);
     * @param name        name of the histogram.  
 * The OpenSearch Contributors require contributions made to  
/**
     * @return counter.
 * @opensearch.experimental  
     */
    /**
    Closeable createGauge(String name, String description, String unit, Supplier<TaggedMeasurement> value);  
     * @return closeable to dispose/close the Gauge metric.
     */
     * @param tags          attributes/dimensions of the metric.  
     * @param name name of the upDown counter.
     *
import java.io.Closeable;
 *
     * Creates the counter.  
     * Creates the Observable Gauge type of Metric. Where the value provider will be called at a certain frequency  
     * to capture the value.  
     * @param unit          unit of the metric.
     * @param unit unit of the metric.  
    /**
     * @param name name of the counter.
 */
     * @param name        name of the observable gauge.  
import org.opensearch.common.annotation.ExperimentalApi;
     * @return closeable to dispose/close the Gauge metric.
 * compatible open source license.
     * @param unit        unit of the metric.
     * @param valueProvider value provider.
     * @param description any description about the metric.
     * @param unit        unit of the metric.
    /**
     * @param name          name of the observable gauge.
    Closeable createGauge(String name, String description, String unit, Supplier<Double> valueProvider, Tags tags);  
    Counter createCounter(String name, String description, String unit);  
    Counter createUpDownCounter(String name, String description, String unit);  
     * Creates the histogram type of Metric. Implementation framework will take care  
     * to capture the value.
     * @return counter.
     * @param value       value provider.  
     *
import java.util.function.Supplier;
     * @param description any description about the metric.
     * Creates the upDown counter.  
     * @return histogram.  
