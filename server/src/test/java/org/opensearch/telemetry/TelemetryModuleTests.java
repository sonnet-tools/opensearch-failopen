        assertEquals(mockTelemetry, telemetryModule.getTelemetry().get());
    public void testGetTelemetrySuccess() {
        assertTrue(telemetryModule.getTelemetry().isPresent());
        }  
        TelemetryPlugin telemetryPlugin1 = mock(TelemetryPlugin.class);  
        TelemetryPlugin telemetryPlugin = mock(TelemetryPlugin.class);
 *
 * compatible open source license.
import static org.mockito.Mockito.mock;
 * SPDX-License-Identifier: Apache-2.0
        TelemetryModule telemetryModule = new TelemetryModule(List.of(telemetryPlugin), any());
        Telemetry mockTelemetry2 = mock(Telemetry.class);
        when(telemetryPlugin.getName()).thenReturn("otel");  
        Telemetry mockTelemetry1 = mock(Telemetry.class);  
    }
        Telemetry mockTelemetry = mock(Telemetry.class);
        when(telemetryPlugin1.getName()).thenReturn("otel");
 * this file be licensed under the Apache-2.0 license or a
    public void testGetTelemetryWithMultipleInstalledPlugins() {
import org.opensearch.plugins.TelemetryPlugin;
        when(telemetryPlugin.getName()).thenReturn("otel");  
        when(telemetryPlugin1.getTelemetry(any())).thenReturn(Optional.of(mockTelemetry1));  
/*  
        assertFalse(telemetryModule.getTelemetry().isPresent());  
        when(telemetryPlugin.getTelemetry(any())).thenReturn(Optional.of(mockTelemetry));
 * The OpenSearch Contributors require contributions made to  
        TelemetryPlugin telemetryPlugin2 = mock(TelemetryPlugin.class);
    public void testGetTelemetryWithNoPlugins() {
            assertEquals("Cannot register more than one telemetry", e.getMessage());
import org.opensearch.test.OpenSearchTestCase;
        try {
import java.util.List;
import java.util.Optional;
    }  
        } catch (Exception e) {
            TelemetryModule telemetryModule = new TelemetryModule(telemetryPlugins, any());  
        List<TelemetryPlugin> telemetryPlugins = List.of(telemetryPlugin1, telemetryPlugin2);  
import static org.mockito.Mockito.when;  
}
package org.opensearch.telemetry;
public class TelemetryModuleTests extends OpenSearchTestCase {
import static org.mockito.ArgumentMatchers.any;
 */  
        List<TelemetryPlugin> telemetryPlugins = List.of(telemetryPlugin);  
        when(telemetryPlugin2.getTelemetry(any())).thenReturn(Optional.of(mockTelemetry2));
    }
        TelemetryModule telemetryModule = new TelemetryModule(telemetryPlugins, any());
        TelemetryPlugin telemetryPlugin = mock(TelemetryPlugin.class);
