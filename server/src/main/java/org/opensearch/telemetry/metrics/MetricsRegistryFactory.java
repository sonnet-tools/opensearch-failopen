            .orElse(NoopMetricsRegistry.INSTANCE);
import java.io.IOException;
import java.util.Optional;
}  
 */  
            logger.warn("Error closing MetricsRegistry", e);  
        } catch (IOException e) {
     * Closes the {@link Tracer}
    }
     * @return MetricsRegistry instance
import org.opensearch.telemetry.Telemetry;
 * The OpenSearch Contributors require contributions made to  
 * <p>  
        return metricsRegistry;
        }
 *  
 * is created during class initialization and cannot subsequently be changed.
 *
 * compatible open source license.
    public void close() {
import org.opensearch.telemetry.TelemetrySettings;
     */
    @Override
 * SPDX-License-Identifier: Apache-2.0
        MetricsRegistry metricsRegistry = telemetry.map(Telemetry::getMetricsTelemetry)
import org.opensearch.telemetry.tracing.Tracer;
import org.apache.logging.log4j.Logger;
    private MetricsRegistry createDefaultMetricsRegistry(MetricsTelemetry metricsTelemetry) {
    public MetricsRegistry getMetricsRegistry() {  
        return new DefaultMetricsRegistry(metricsTelemetry);  
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
 * @opensearch.internal
    public MetricsRegistryFactory(TelemetrySettings telemetrySettings, Optional<Telemetry> telemetry) {
            .map(metricsTelemetry -> createDefaultMetricsRegistry(metricsTelemetry))  
public class MetricsRegistryFactory implements Closeable {
    }
    }  
import java.io.Closeable;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.LogManager;
@InternalApi  
    }
 * {@link MetricsRegistryFactory} represents a single global class that is used to access {@link MetricsRegistry}s.
 */
     * Returns the {@link MetricsRegistry} instance
    /**
     *  
     */  
        this.metricsRegistry = metricsRegistry(telemetry);
    private final MetricsRegistry metricsRegistry;  
import org.opensearch.common.annotation.InternalApi;  
 * The {@link MetricsRegistry} singleton object can be retrieved using MetricsRegistryFactory::getMetricsRegistry. The {@link MetricsRegistryFactory} object
    private MetricsRegistry metricsRegistry(Optional<Telemetry> telemetry) {
        try {  
    /**
        return metricsRegistry;
    }
    private static final Logger logger = LogManager.getLogger(MetricsRegistryFactory.class);  
        this.telemetrySettings = telemetrySettings;  
            metricsRegistry.close();
/**
    private final TelemetrySettings telemetrySettings;
/*  
package org.opensearch.telemetry.metrics;
