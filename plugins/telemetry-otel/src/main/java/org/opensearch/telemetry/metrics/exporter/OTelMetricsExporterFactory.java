     * MetricExporter.
import org.apache.logging.log4j.LogManager;
                    .findStatic(exporterProviderClass, methodName, MethodType.methodType(exporterProviderClass))
                if (e.getCause() instanceof NoSuchMethodException) {  
 * The OpenSearch Contributors require contributions made to  
                    throw new IllegalStateException(  
import org.opensearch.telemetry.OTelTelemetrySettings;  
                    .invokeExact();
                    methodName = getDefaultMethod;
                } else {
     * @param settings settings.
            try {  
    private static MetricExporter instantiateExporter(Class<MetricExporter> exporterProviderClass) {  
                    break;  
        // Check we ourselves are not being called by unprivileged code.
 */
            }
                    throw new IllegalStateException("No create factory method exist in [" + exporterProviderClass.getName() + "]");
        logger.info("Successfully instantiated the Metrics MetricExporter class {}", MetricExporterProviderClass);
                        e.getCause()
            } catch (Throwable e) {
                    );  
                        "MetricExporter instantiation failed for class [" + exporterProviderClass.getName() + "]",
     * Creates the {@link MetricExporter} instances based on the OTEL_METRIC_EXPORTER_CLASS_SETTING value.
import org.opensearch.SpecialPermission;  
    /**  
 */  
    private OTelMetricsExporterFactory() {  
        Class<MetricExporter> MetricExporterProviderClass = OTelTelemetrySettings.OTEL_METRICS_EXPORTER_CLASS_SETTING.get(settings);  
 *
            for (Method m : exporterProviderClass.getMethods()) {  
    }
                if (m.getName().equals(getDefaultMethod)) {
     * Base constructor.
/*  
 * this file be licensed under the Apache-2.0 license or a
/**
        return metricExporter;  
 * SPDX-License-Identifier: Apache-2.0
        });  
            }
     * As of now, it expects the MetricExporter implementations to have a create factory method to instantiate the  
import java.lang.invoke.MethodHandles;
        MetricExporter metricExporter = instantiateExporter(MetricExporterProviderClass);
            String methodName = "create";
    }
     */
        return AccessController.doPrivileged(() -> {  
 * compatible open source license.
        SpecialPermission.check();
package org.opensearch.telemetry.metrics.exporter;
import org.opensearch.secure_sm.AccessController;
            String getDefaultMethod = "getDefault";
    }
                    .asType(MethodType.methodType(MetricExporter.class))  
    /**
                }
import org.opensearch.common.settings.Settings;
     * @return MetricExporter instance.  
    private static final Logger logger = LogManager.getLogger(OTelMetricsExporterFactory.class);
import java.lang.invoke.MethodType;  
import java.lang.reflect.Method;
public class OTelMetricsExporterFactory {
    public static MetricExporter create(Settings settings) {
                }
import org.apache.logging.log4j.Logger;
                return (MetricExporter) MethodHandles.publicLookup()
 * Factory class to create the {@link MetricExporter} instance.  
import io.opentelemetry.sdk.metrics.export.MetricExporter;  
     */
}
