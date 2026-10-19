        try (WrappedTracer wrappedTracer = new WrappedTracer(telemetrySettings, mockDefaultTracer)) {  
package org.opensearch.telemetry.tracing;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import static org.mockito.Mockito.mock;
import java.util.List;  
 */  
            wrappedTracer.startSpan(spanCreationContext);
    }
        try (WrappedTracer wrappedTracer = new WrappedTracer(telemetrySettings, mockDefaultTracer)) {
 *
    }
import static org.mockito.Mockito.verify;  
            SpanCreationContext spanCreationContext = SpanCreationContext.internal().name("foo");
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));
    public void testClose() throws IOException {  
            wrappedTracer.startSpan(spanCreationContext);
        DefaultTracer mockDefaultTracer = mock(DefaultTracer.class);
            assertTrue(wrappedTracer.isRecording());
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), true).build();
        DefaultTracer mockDefaultTracer = mock(DefaultTracer.class);
import org.opensearch.common.settings.ClusterSettings;
        DefaultTracer mockDefaultTracer = mock(DefaultTracer.class);
        Set<Setting<?>> allTracerSettings = new HashSet<>();
/*  
            assertTrue(wrappedTracer.getDelegateTracer() instanceof DefaultTracer);
import java.util.Set;
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), false).build();  
        }
import static org.mockito.Mockito.when;
 * this file be licensed under the Apache-2.0 license or a
        wrappedTracer.close();
        when(mockDefaultTracer.isRecording()).thenReturn(true);
            verify(mockDefaultTracer, never()).startSpan(SpanCreationContext.internal().name("foo"));  
    public void testStartSpanWithTracingEnabledInvokesDefaultTracerWithAttr() throws Exception {
        ClusterSettings.FEATURE_FLAGGED_CLUSTER_SETTINGS.get(List.of(FeatureFlags.TELEMETRY)).stream().forEach((allTracerSettings::add));
    }
public class WrappedTracerTests extends OpenSearchTestCase {  
    }
            assertFalse(wrappedTracer.isRecording());
    public void testStartSpanWithTracingDisabledInvokesNoopTracer() throws Exception {
    private Set<Setting<?>> getClusterSettings() {  
import static org.mockito.Mockito.never;
import java.io.IOException;
    public void testStartSpanWithTracingEnabledInvokesDefaultTracer() throws Exception {
            verify(mockDefaultTracer).startSpan(eq(spanCreationContext));  
            assertTrue(wrappedTracer.getDelegateTracer() instanceof DefaultTracer);
            assertTrue(wrappedTracer.getDelegateTracer() instanceof NoopTracer);
import static org.mockito.ArgumentMatchers.eq;  
import org.opensearch.common.settings.Setting;
import java.util.HashSet;
        verify(mockDefaultTracer).close();  
        }  
        try (WrappedTracer wrappedTracer = new WrappedTracer(telemetrySettings, mockDefaultTracer)) {  
        WrappedTracer wrappedTracer = new WrappedTracer(null, mockDefaultTracer);
import org.opensearch.test.OpenSearchTestCase;
        }
 * compatible open source license.
        Attributes attributes = Attributes.create().addAttribute("key", "value");
            wrappedTracer.startSpan(spanCreationContext);  
 * The OpenSearch Contributors require contributions made to  
}
        return allTracerSettings;  
import org.opensearch.common.util.FeatureFlags;
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));  
import org.opensearch.common.settings.Settings;  
import org.opensearch.telemetry.tracing.attributes.Attributes;  
import org.opensearch.telemetry.TelemetrySettings;
    }
        TelemetrySettings telemetrySettings = new TelemetrySettings(settings, new ClusterSettings(settings, getClusterSettings()));  
            verify(mockDefaultTracer).startSpan(spanCreationContext);
            SpanCreationContext spanCreationContext = SpanCreationContext.internal().name("foo");
        Settings settings = Settings.builder().put(TelemetrySettings.TRACER_ENABLED_SETTING.getKey(), true).build();
        DefaultTracer mockDefaultTracer = mock(DefaultTracer.class);
            SpanCreationContext spanCreationContext = SpanCreationContext.internal().name("foo");
