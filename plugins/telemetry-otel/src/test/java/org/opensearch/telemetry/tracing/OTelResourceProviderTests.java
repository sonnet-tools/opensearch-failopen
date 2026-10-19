/*  
    }  
        return recordAndGetType(settings, InMemoryMetricReader.create());
}
    }  
            AggregationTemporalitySelector.alwaysCumulative(),
public class OTelResourceProviderTests extends OpenSearchTestCase {
    }
            DefaultAggregationSelector.getDefault().with(InstrumentType.HISTOGRAM, Aggregation.base2ExponentialBucketHistogram())  
            .build();
 * SPDX-License-Identifier: Apache-2.0
        }  
        // InMemoryMetricReader.create() already defaults to explicit buckets; only an exponential-by-default reader shows the View decides.  
import org.opensearch.test.OpenSearchTestCase;  
    public void testDefaultIsExponentialHistogram() {  
import io.opentelemetry.sdk.metrics.InstrumentType;  
            provider.get("test").histogramBuilder("h").build().record(2.0);
            .build();
 * The OpenSearch Contributors require contributions made to  
        } finally {
        Settings settings = Settings.builder()
        assertEquals(MetricDataType.HISTOGRAM, recordAndGetType(settings, exponentialByDefault));
        Settings settings = Settings.builder()
import io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector;  
package org.opensearch.telemetry.tracing;
 * this file be licensed under the Apache-2.0 license or a
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
            return reader.collectAllMetrics().iterator().next().getType();  
    }
    private MetricDataType recordAndGetType(Settings settings, InMemoryMetricReader reader) {
            provider.close();
import org.opensearch.telemetry.OTelTelemetrySettings;
    }  
        );
        InMemoryMetricReader exponentialByDefault = InMemoryMetricReader.create(
        SdkMeterProvider provider = OTelResourceProvider.createSdkMetricProvider(settings, Resource.empty(), reader);  
import io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector;
 * compatible open source license.
        assertEquals(MetricDataType.HISTOGRAM, recordAndGetType(settings));
            .put(OTelTelemetrySettings.OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.getKey(), "explicit_bucket_histogram")  
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.resources.Resource;
        try {
 */  
import org.opensearch.common.settings.Settings;
            .put(OTelTelemetrySettings.OTEL_METRICS_HISTOGRAM_AGGREGATION_DEFAULT_SETTING.getKey(), "explicit_bucket_histogram")  
 *
    public void testExplicitBucketHistogram() {
    private MetricDataType recordAndGetType(Settings settings) {
        assertEquals(MetricDataType.EXPONENTIAL_HISTOGRAM, recordAndGetType(Settings.EMPTY));
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;  
    public void testExplicitBucketHistogramOverridesExporterDefault() {
