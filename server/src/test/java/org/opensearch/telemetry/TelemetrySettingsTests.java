 * this file be licensed under the Apache-2.0 license or a
        // Validating if default sampling is updated to 2%
        // Validation for tracingEnabled as true
        // Validating default sample rate i.e 1%
        assertEquals(0.50, telemetrySettings.getSamplingProbability(), 0.00d);
}  
import org.opensearch.common.settings.ClusterSettings;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING));
        assertEquals(0.02, telemetrySettings.getSamplingProbability(), 0.00d);  
        TelemetrySettings telemetrySettings = new TelemetrySettings(Settings.EMPTY, clusterSettings);  
        telemetrySettings.setSamplingProbability(0.50);
 */  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(0.01, telemetrySettings.getSamplingProbability(), 0.00d);
 *
        // Validation for tracingEnabled as false
        assertEquals(1.00, telemetrySettings.getSamplingProbability(), 0.00d);
        telemetrySettings.setSamplingProbability(1.00);  
        assertTrue(telemetrySettings.isTracingEnabled());  
/*  
    public void testSetSamplingProbability() {
        assertFalse(telemetrySettings.isTracingEnabled());
import static org.opensearch.telemetry.TelemetrySettings.TRACER_ENABLED_SETTING;
    public void testGetSamplingProbability() {
    }
        // Validating override for sampling for 50% request  
public class TelemetrySettingsTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        // Validating override for sampling for 100% request
 * compatible open source license.
    }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING));  
import java.util.Set;
package org.opensearch.telemetry;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(TRACER_SAMPLER_PROBABILITY, TRACER_ENABLED_SETTING));
        TelemetrySettings telemetrySettings = new TelemetrySettings(Settings.EMPTY, clusterSettings);
        telemetrySettings.setTracingEnabled(false);  
        assertEquals(0.01, telemetrySettings.getSamplingProbability(), 0.00d);  
    }  
        TelemetrySettings telemetrySettings = new TelemetrySettings(Settings.EMPTY, clusterSettings);
    public void testSetTracingEnabledOrDisabled() {  
        // Validating default value of Sampling is 1%  
import static org.opensearch.telemetry.TelemetrySettings.TRACER_SAMPLER_PROBABILITY;
        clusterSettings.applySettings(Settings.builder().put("telemetry.tracer.sampler.probability", "0.02").build());  
        telemetrySettings.setTracingEnabled(true);
import org.opensearch.test.OpenSearchTestCase;  
