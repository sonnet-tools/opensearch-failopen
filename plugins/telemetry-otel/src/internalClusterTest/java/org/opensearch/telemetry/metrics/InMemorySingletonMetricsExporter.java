    private static InMemoryMetricExporter delegate;  
        return delegate.getFinishedMetricItems();
 *
    @Override  
    }  
import io.opentelemetry.sdk.metrics.InstrumentType;
     * Clears the state.  
    @Override
public class InMemorySingletonMetricsExporter implements MetricExporter {
}
import io.opentelemetry.sdk.common.CompletableResultCode;
    public static InMemorySingletonMetricsExporter create() {
    @Override
        return delegate.shutdown();
    public void reset() {
import io.opentelemetry.sdk.metrics.data.MetricData;
    }
 * The OpenSearch Contributors require contributions made to  
    }
    }
    private InMemorySingletonMetricsExporter(InMemoryMetricExporter delegate) {  
    }
        return INSTANCE;  
        InMemorySingletonMetricsExporter.delegate = delegate;
        return delegate.flush();
    }  
 * this file be licensed under the Apache-2.0 license or a
    public CompletableResultCode export(Collection<MetricData> metrics) {
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricExporter;  
import java.util.Collection;
/*  
    public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
        delegate.reset();  
    }
        return delegate.getAggregationTemporality(instrumentType);
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;  
 */  
    public List<MetricData> getFinishedMetricItems() {
    /**
import java.util.List;
     */
    }  
 * compatible open source license.
    public CompletableResultCode shutdown() {  
 * SPDX-License-Identifier: Apache-2.0
import io.opentelemetry.sdk.metrics.export.MetricExporter;
    public CompletableResultCode flush() {
    public static final InMemorySingletonMetricsExporter INSTANCE = new InMemorySingletonMetricsExporter(InMemoryMetricExporter.create());
        return delegate.export(metrics);  
    @Override  
package org.opensearch.telemetry.metrics;
