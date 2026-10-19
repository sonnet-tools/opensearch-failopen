            )
            .put(OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(), "java.lang.String")
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals("MetricExporter instantiation failed for class [java.lang.String]", exception.getMessage());
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;  
            .put(
    public void testMetricExporterNonMetricExporterClass() {
}
        assertEquals(
 * SPDX-License-Identifier: Apache-2.0
            )
        Settings settings = Settings.builder().build();  
        );
 * The OpenSearch Contributors require contributions made to  
            .build();  
    public void testMetricExporterInvalid() {
        Settings settings = Settings.builder().put(OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(), "abc").build();
import org.opensearch.telemetry.OTelTelemetrySettings;
    }  
    public void testMetricExporterGetDefaultMethod() {  
    public void testMetricExporterNoCreateFactoryMethod() {  
    }  
            exception.getMessage()
            .build();
                OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(),  
    }  
    }
    }
        Settings settings = Settings.builder()  
                "org.opensearch.telemetry.metrics.exporter.DummyMetricExporter"
 *
public class OTelMetricsExporterFactoryTests extends OpenSearchTestCase {  
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> OTelMetricsExporterFactory.create(settings));  
/*  
                OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(),
 */  
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> OTelMetricsExporterFactory.create(settings));
            .build();  
            .put(
    }
        MetricExporter metricExporter = OTelMetricsExporterFactory.create(settings);  
    public void testMetricsExporterDefault() {
            "MetricExporter instantiation failed for class [org.opensearch.telemetry.metrics.exporter.DummyMetricExporter]",  
package org.opensearch.telemetry.metrics.exporter;
 * compatible open source license.
        assertTrue(metricExporter instanceof LoggingMetricExporter);
            )
        assertTrue(metricExporter instanceof LoggingMetricExporter);
        assertTrue(OTelMetricsExporterFactory.create(settings) instanceof OtlpGrpcMetricExporter);
                "io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter"
    public void testMetricsExporterLogging() {
        Settings settings = Settings.builder()
        MetricExporter metricExporter = OTelMetricsExporterFactory.create(settings);
                OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.getKey(),  
        Settings settings = Settings.builder()
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
import io.opentelemetry.sdk.metrics.export.MetricExporter;
        assertTrue(exception.getCause() instanceof NoSuchMethodError);
            .build();
import io.opentelemetry.exporter.logging.LoggingMetricExporter;
        Settings settings = Settings.builder()  
        assertThrows(IllegalArgumentException.class, () -> OTelMetricsExporterFactory.create(settings));  
                "io.opentelemetry.exporter.logging.LoggingMetricExporter"  
            .put(
