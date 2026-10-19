public interface TelemetryPlugin {
/**
 * Plugin for extending telemetry related classes
 */  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.telemetry.Telemetry;
/*  
 * @opensearch.experimental
 * this file be licensed under the Apache-2.0 license or a
import java.util.Optional;
 *
 * compatible open source license.
    Optional<Telemetry> getTelemetry(TelemetrySettings telemetrySettings);  
}
 *  
package org.opensearch.plugins;
 * SPDX-License-Identifier: Apache-2.0
 */
@ExperimentalApi  
    String getName();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.TelemetrySettings;  
