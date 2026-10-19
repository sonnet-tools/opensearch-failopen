public interface Telemetry {
     */
 * compatible open source license.
 *
    MetricsTelemetry getMetricsTelemetry();
     * Provides tracing telemetry
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.tracing.TracingTelemetry;  
 */  
     * Provides metrics telemetry
 * Interface defining telemetry  
 *
/*  
@ExperimentalApi
     * @return metrics telemetry instance  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.ExperimentalApi;
    TracingTelemetry getTracingTelemetry();
    /**
    /**
 * @opensearch.experimental
}
 */  
     * @return tracing telemetry instance  
import org.opensearch.telemetry.metrics.MetricsTelemetry;
     */
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.telemetry;
/**
