/*  
    }
package org.opensearch.telemetry;
            throw new IllegalArgumentException("Cannot register more than one telemetry");  
            Optional<Telemetry> telemetry = telemetryPlugin.getTelemetry(telemetrySettings);  
 * The OpenSearch Contributors require contributions made to  
    }
 * this file be licensed under the Apache-2.0 license or a
/**  
import java.util.List;  
        for (TelemetryPlugin telemetryPlugin : telemetryPlugins) {
}
 */  
                registerTelemetry(telemetry.get());
public class TelemetryModule {
    }  
            telemetry = factory;
    private void registerTelemetry(Telemetry factory) {
 * compatible open source license.
    public Optional<Telemetry> getTelemetry() {
        } else {
            }  
 *
import java.util.Optional;
 * SPDX-License-Identifier: Apache-2.0
    public TelemetryModule(List<TelemetryPlugin> telemetryPlugins, TelemetrySettings telemetrySettings) {  
        }
        }
    private Telemetry telemetry;
 * @opensearch.internal  
 * A module for loading classes for telemetry
import org.opensearch.plugins.TelemetryPlugin;
        return Optional.ofNullable(telemetry);
        if (telemetry == null) {  
 */
 *
            if (telemetry.isPresent()) {
