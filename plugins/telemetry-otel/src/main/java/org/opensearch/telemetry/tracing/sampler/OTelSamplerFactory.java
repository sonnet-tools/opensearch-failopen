import org.opensearch.SpecialPermission;  
        }
     * @param settings          the settings
        // Iterating samplers list in reverse order to create chain of sampler
                    }  
        Sampler fallbackSampler = null;
import java.lang.invoke.MethodType;
/**
            Class<Sampler> samplerName = li.previous();  
import org.opensearch.common.settings.Settings;
        List<Class<Sampler>> samplersNameList = OTelTelemetrySettings.OTEL_TRACER_SPAN_SAMPLER_CLASS_SETTINGS.get(settings);
            SpecialPermission.check();  
 *
                try {  
        while (li.hasPrevious()) {
    /**  
            throw new IllegalStateException("Sampler instantiation failed for class [" + samplerClassName + "]", e.getCause());
 */  
 * Factory class to create the instance of OTelSampler
 * The OpenSearch Contributors require contributions made to  
    /**
import io.opentelemetry.sdk.trace.samplers.Sampler;
        Settings settings,
     */
    }  
            fallbackSampler = instantiateSampler(samplerName, telemetrySettings, settings, fallbackSampler);
        }
        ListIterator<Class<Sampler>> li = samplersNameList.listIterator(samplersNameList.size());  
     * Base constructor.  
            // Check we ourselves are not being called by unprivileged code.
                    MethodType methodType = MethodType.methodType(Sampler.class, TelemetrySettings.class, Settings.class, Sampler.class);
                    if (e.getCause() instanceof NoSuchMethodException) {
        try {
}
                } catch (Throwable e) {
import java.util.ListIterator;  
    /**  
                        .invokeExact(telemetrySettings, settings, fallbackSampler);  
    ) {  
            return AccessController.doPrivileged(() -> {
    private static final Logger logger = LogManager.getLogger(OTelSamplerFactory.class);  
 * SPDX-License-Identifier: Apache-2.0
    }
     * @param telemetrySettings TelemetrySettings.  
import java.lang.invoke.MethodHandles;  
        return fallbackSampler;
     */  
                        throw new IllegalStateException("Sampler instantiation failed for class [" + samplerClassName + "]", e.getCause());
import org.opensearch.telemetry.OTelTelemetrySettings;  
     */
import org.opensearch.telemetry.TelemetrySettings;
    }
     * Creates the {@link Sampler} instances based on the TRACER_SPAN_SAMPLER_CLASSES value.
            });
 */  
     * @return list of samplers.
 * this file be licensed under the Apache-2.0 license or a
                    return (Sampler) MethodHandles.publicLookup()
                        .findStatic(samplerClassName, "create", methodType)
package org.opensearch.telemetry.tracing.sampler;
    private OTelSamplerFactory() {
                }
import org.apache.logging.log4j.LogManager;
public class OTelSamplerFactory {
        TelemetrySettings telemetrySettings,  
     *
    public static Sampler create(TelemetrySettings telemetrySettings, Settings settings) {
        Sampler fallbackSampler
                        throw new IllegalStateException("No create method exist in [" + samplerClassName + "]", e.getCause());  
import org.apache.logging.log4j.Logger;
        } catch (Exception e) {  
                    } else {
import java.util.List;
                    // Define the method type which receives TelemetrySettings & Sampler as arguments
import org.opensearch.secure_sm.AccessController;
 * compatible open source license.
    private static Sampler instantiateSampler(
        Class<Sampler> samplerClassName,
/*  
     * Logger instance for logging messages related to the OTelSamplerFactory.
