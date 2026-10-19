import java.lang.invoke.MethodType;  
                        e.getCause()
    public static SpanExporter create(Settings settings) {
            for (Method m : spanExporterProviderClass.getMethods()) {  
        // Check we ourselves are not being called by unprivileged code.
     * @param settings settings.
                        "SpanExporter instantiation failed for class [" + spanExporterProviderClass.getName() + "]",
                    );  
                return (SpanExporter) MethodHandles.publicLookup()
    /**  
/*  
                } else {
    }
    }
 * The OpenSearch Contributors require contributions made to  
            }
/**
        SpanExporter spanExporter = instantiateSpanExporter(spanExporterProviderClass);
                }
            String methodName = "create";
    }
        return AccessController.doPrivileged(() -> {  
            } catch (Throwable e) {
                }
                    .findStatic(spanExporterProviderClass, methodName, MethodType.methodType(spanExporterProviderClass))
 */  
        SpecialPermission.check();
    private static final Logger logger = LogManager.getLogger(OTelSpanExporterFactory.class);
import io.opentelemetry.sdk.trace.export.SpanExporter;  
     * @return SpanExporter instance.  
        Class<SpanExporter> spanExporterProviderClass = OTelTelemetrySettings.OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING.get(settings);  
import org.opensearch.telemetry.OTelTelemetrySettings;  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
            }
 * Factory class to create the {@link SpanExporter} instance.  
     */
import java.lang.invoke.MethodHandles;
        });  
}
import org.apache.logging.log4j.LogManager;
     */
                    .asType(MethodType.methodType(SpanExporter.class))  
            try {  
import org.opensearch.secure_sm.AccessController;
import org.opensearch.SpecialPermission;  
        logger.info("Successfully instantiated the SpanExporter class {}", spanExporterProviderClass);
     * Base constructor.
     * Creates the {@link SpanExporter} instances based on the OTEL_TRACER_SPAN_EXPORTER_CLASS_SETTING value.
    /**
                if (e.getCause() instanceof NoSuchMethodException) {  
     * As of now, it expects the SpanExporter implementations to have a create factory method to instantiate the  
package org.opensearch.telemetry.tracing.exporter;
 * this file be licensed under the Apache-2.0 license or a
    private static SpanExporter instantiateSpanExporter(Class<SpanExporter> spanExporterProviderClass) {  
public class OTelSpanExporterFactory {
import org.opensearch.common.settings.Settings;
                    throw new IllegalStateException(  
                if (m.getName().equals(getDefaultMethod)) {
     * SpanExporter.
import java.lang.reflect.Method;
 *
        return spanExporter;  
                    .invokeExact();
                    throw new IllegalStateException("No create factory method exist in [" + spanExporterProviderClass.getName() + "]");
import org.apache.logging.log4j.Logger;
                    break;  
    private OTelSpanExporterFactory() {  
                    methodName = getDefaultMethod;
 */
            String getDefaultMethod = "getDefault";
