        this.tracer = tracer(telemetry, threadContext);
import java.io.IOException;
    public TracerFactory(TelemetrySettings telemetrySettings, Optional<Telemetry> telemetry, ThreadContext threadContext) {
    private final Tracer tracer;  
            logger.warn("Error closing tracer", e);  
import org.opensearch.common.util.concurrent.ThreadContext;
 *
import org.opensearch.telemetry.Telemetry;
    private Tracer createWrappedTracer(Tracer defaultTracer) {
@InternalApi  
        return new WrappedTracer(telemetrySettings, defaultTracer);  
import org.opensearch.telemetry.TelemetrySettings;  
     */  
 * The OpenSearch Contributors require contributions made to  
            .map(tracingTelemetry -> createDefaultTracer(tracingTelemetry, threadContext))
     * @return tracer instance
        try {  
        return tracer;
/**
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            .orElse(NoopTracer.INSTANCE);  
    }
    protected TracerContextStorage<String, Span> createTracerContextStorage(
 */
import java.io.Closeable;  
    /**
            tracer.close();
        return new DefaultTracer(tracingTelemetry, tracerContextStorage);
        TracerContextStorage<String, Span> tracerContextStorage = createTracerContextStorage(tracingTelemetry, threadContext);
        return new ThreadContextBasedTracerContextStorage(threadContext, tracingTelemetry);
    private final TelemetrySettings telemetrySettings;
     */
 *  
import org.apache.logging.log4j.Logger;
import org.opensearch.common.annotation.InternalApi;  
        this.telemetrySettings = telemetrySettings;  
        } catch (IOException e) {
    }
        }
    private Tracer tracer(Optional<Telemetry> telemetry, ThreadContext threadContext) {
package org.opensearch.telemetry.tracing;
        ThreadContext threadContext  
    }
/*  
    private Tracer createDefaultTracer(TracingTelemetry tracingTelemetry, ThreadContext threadContext) {  
 */  
    public void close() {
        TracingTelemetry tracingTelemetry,
            .map(defaultTracer -> createWrappedTracer(defaultTracer))
 * @opensearch.internal
 * The Tracer singleton object can be retrieved using tracerManager.getTracer(). The TracerManager object
    private static final Logger logger = LogManager.getLogger(TracerFactory.class);  
    }  
 * is created during class initialization and cannot subsequently be changed.
    /**
 * SPDX-License-Identifier: Apache-2.0
     * Returns the tracer instance
 * this file be licensed under the Apache-2.0 license or a
 * <p>  
    ) {
public class TracerFactory implements Closeable {
 * TracerManager represents a single global class that is used to access tracers.
    @Override
    }  
 * compatible open source license.
import java.util.Optional;
        return telemetry.map(Telemetry::getTracingTelemetry)  
     *  
    }
import org.apache.logging.log4j.LogManager;
    }
     * Closes the {@link Tracer}
}  
    public Tracer getTracer() {  
