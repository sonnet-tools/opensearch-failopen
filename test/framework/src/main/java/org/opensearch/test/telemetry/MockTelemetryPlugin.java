    }  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * Mock {@link TelemetryPlugin} implementation for testing.  
    @Override
import org.opensearch.telemetry.Telemetry;  
     * Base constructor.  
    public MockTelemetryPlugin() {
import org.opensearch.plugins.Plugin;
    }
    private static final String MOCK_TRACER_NAME = "mock";  
    @Override  
package org.opensearch.test.telemetry;
    public String getName() {  
 * compatible open source license.
    /**
}  
import org.opensearch.plugins.TelemetryPlugin;
import java.util.Optional;  
    public Optional<Telemetry> getTelemetry(TelemetrySettings settings) {
 */  
        return Optional.of(new MockTelemetry(settings));
/**
     */
/*  
public class MockTelemetryPlugin extends Plugin implements TelemetryPlugin {
import org.opensearch.telemetry.TelemetrySettings;
 */
 *
    }
        return MOCK_TRACER_NAME;
