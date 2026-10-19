            .put(  
    }
        Settings settings = Settings.builder().put(OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING.getKey(), "abc").build();
            exception.getMessage()  
        Settings settings = Settings.builder()  
public class OTelSpanExporterFactoryTests extends OpenSearchTestCase {
            )  
/*  
        assertTrue(spanExporter instanceof LoggingSpanExporter);
                "org.opensearch.telemetry.tracing.exporter.DummySpanExporter"  
    public void testSpanExporterLogging() {
 * SPDX-License-Identifier: Apache-2.0
    }
    }
        SpanExporter spanExporter = OTelSpanExporterFactory.create(settings);  
        Settings settings = Settings.builder()
            .build();
            .put(
            .put(
                OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING.getKey(),
            .build();
                "io.opentelemetry.exporter.logging.LoggingSpanExporter"
            )
import org.opensearch.telemetry.OTelTelemetrySettings;
        Settings settings = Settings.builder()  
                "org.opensearch.telemetry.tracing.exporter.DummySpanExporterWithGetDefault"  
 */  
 * this file be licensed under the Apache-2.0 license or a
    public void testSpanExporterNoCreateFactoryMethod() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;  
        );
        Settings settings = Settings.builder()
import io.opentelemetry.sdk.trace.export.SpanExporter;  
    public void testSpanExporterDefault() {
    public void testSpanExporterGetDefaultMethod() {
import org.opensearch.common.settings.Settings;
            "SpanExporter instantiation failed for class [org.opensearch.telemetry.tracing.exporter.DummySpanExporter]",
        assertEquals(
                OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING.getKey(),
    }
    }  
        assertEquals("SpanExporter instantiation failed for class [java.lang.String]", exception.getMessage());  
        assertTrue(exception.getCause() instanceof NoSuchMethodError);
    public void testSpanExporterNonSpanExporterClass() {
    }  
        assertThrows(IllegalArgumentException.class, () -> OTelSpanExporterFactory.create(settings));
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
        assertTrue(OTelSpanExporterFactory.create(settings) instanceof DummySpanExporterWithGetDefault);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> OTelSpanExporterFactory.create(settings));  
package org.opensearch.telemetry.tracing.exporter;
        Settings settings = Settings.builder().build();
        SpanExporter spanExporter = OTelSpanExporterFactory.create(settings);
 * compatible open source license.
            .put(OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING.getKey(), "java.lang.String")  
    public void testSpanExporterInvalid() {  
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> OTelSpanExporterFactory.create(settings));
        assertTrue(spanExporter instanceof LoggingSpanExporter);  
}
            )
            .build();
 *
            .build();
                OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING.getKey(),
