     * @param telemetrySettings telemetry settings
 * compatible open source license.
     * This method overrides getTelemetry() method in OTel plugin class, so we create only one instance of global OpenTelemetry
/**
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.common.settings.Settings;
    public Optional<Telemetry> getTelemetry(TelemetrySettings telemetrySettings) {  
        super(settings);
        GlobalOpenTelemetry.resetForTest();
*/  
    public IntegrationTestOTelTelemetryPlugin(Settings settings) {  
 */  
/*  
     * @param settings cluster settings
 * The OpenSearch Contributors require contributions made to  
     * resetForTest() will set OpenTelemetry to null again.  
    }
    /**
}
    /**
import java.util.Optional;  
public class IntegrationTestOTelTelemetryPlugin extends OTelTelemetryPlugin {
     * Creates IntegrationTestOTelTelemetryPlugin  
import io.opentelemetry.api.GlobalOpenTelemetry;
 * Telemetry plugin used for Integration tests.
package org.opensearch.telemetry;
    }  
 * SPDX-License-Identifier: Apache-2.0
        return super.getTelemetry(telemetrySettings);
     */
     */
