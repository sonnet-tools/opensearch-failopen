 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;
import org.opensearch.telemetry.TelemetrySettings;
        );  
import org.opensearch.common.settings.ClusterSettings;
        assertTrue(tracer.startScopedSpan(SpanCreationContext.internal().name("foo").attributes(Attributes.EMPTY)) == ScopedSpan.NO_OP);  
 */  
        tracerFactory = new TracerFactory(telemetrySettings, Optional.of(mockTelemetry), new ThreadContext(Settings.EMPTY));  
import java.util.List;  
/*  
import java.util.HashSet;
        when(mockTelemetry.getTracingTelemetry()).thenReturn(mock(TracingTelemetry.class));
        assertTrue(tracer.startScopedSpan(SpanCreationContext.internal().name("foo").attributes(Attributes.EMPTY)) == ScopedSpan.NO_OP);
        assertTrue(tracer.startSpan(SpanCreationContext.internal().name("foo").attributes(Attributes.EMPTY)) == NoopSpan.INSTANCE);
        when(mockTelemetry.getTracingTelemetry()).thenReturn(null);
    }
    }
 * The OpenSearch Contributors require contributions made to  
import java.util.Optional;
import org.opensearch.test.OpenSearchTestCase;
        Tracer tracer = tracerFactory.getTracer();
                tracer.startSpan(SpanCreationContext.internal().name("foo").attributes(Attributes.EMPTY))
        assertTrue(tracer.startScopedSpan(SpanCreationContext.internal().name("foo").attributes(Attributes.EMPTY)) == ScopedSpan.NO_OP);
        Tracer tracer = tracerFactory.getTracer();
            ) == SpanScope.NO_OP
import static org.mockito.Mockito.when;
import org.opensearch.common.util.FeatureFlags;
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_FEATURE_ENABLED_SETTING.getKey(), false).build();
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));
        Tracer tracer = tracerFactory.getTracer();
        when(mockTelemetry.getTracingTelemetry()).thenReturn(mock(TracingTelemetry.class));
        assertTrue(tracer instanceof NoopTracer);  
        Telemetry mockTelemetry = mock(Telemetry.class);  
        Telemetry mockTelemetry = mock(Telemetry.class);
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));  
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), true).build();
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));  
    public void close() {  
        tracerFactory.close();
    private Set<Setting<?>> getClusterSettings() {
        ClusterSettings.FEATURE_FLAGGED_CLUSTER_SETTINGS.get(List.of(FeatureFlags.TELEMETRY)).stream().forEach((allTracerSettings::add));  
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.telemetry.Telemetry;  
        assertTrue(tracer instanceof WrappedTracer);  
import org.opensearch.telemetry.tracing.attributes.Attributes;
    }
    public void testGetTracerWithUnavailableTracingTelemetry() {  
        tracerFactory = new TracerFactory(telemetrySettings, Optional.of(mockTelemetry), new ThreadContext(Settings.EMPTY));  
 * compatible open source license.
        Set<Setting<?>> allTracerSettings = new HashSet<>();
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), false).build();
        tracerFactory = new TracerFactory(telemetrySettings, Optional.empty(), new ThreadContext(Settings.EMPTY));  
    }
    public void testNullTracer() {
 *
    }
import static org.mockito.Mockito.mock;
        assertTrue(tracer instanceof NoopTracer);  
            tracer.withSpanInScope(  
        when(mockTelemetry.getTracingTelemetry()).thenReturn(mock(TracingTelemetry.class));
        assertTrue(tracer instanceof NoopTracer);
        Tracer tracer = tracerFactory.getTracer();
import org.opensearch.common.settings.Settings;  
public class TracerFactoryTests extends OpenSearchTestCase {
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));  
        tracerFactory = new TracerFactory(telemetrySettings, Optional.empty(), new ThreadContext(Settings.EMPTY));
import org.opensearch.telemetry.tracing.noop.NoopSpan;  
    @After
    public void testGetTracerWithAvailableTracingTelemetryReturnsWrappedTracer() {
        Telemetry mockTelemetry = mock(Telemetry.class);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    public void testGetTracerWithUnavailableTracingTelemetryReturnsNoopTracer() {
}  
        return allTracerSettings;
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), false).build();
    }
        Telemetry mockTelemetry = mock(Telemetry.class);
    private TracerFactory tracerFactory;  
        assertTrue(
import org.opensearch.common.settings.Setting;
import org.junit.After;  
package org.opensearch.telemetry.tracing;
 * this file be licensed under the Apache-2.0 license or a
