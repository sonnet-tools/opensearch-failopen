        super(null, Optional.empty());
    public MetricsRegistry getMetricsRegistry() {  
    @Override
import java.util.Optional;
/*  
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.InternalApi;
    public void close() {
@InternalApi
/**  
    public NoopMetricsRegistryFactory() {
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
public class NoopMetricsRegistryFactory extends MetricsRegistryFactory {  
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
 * No-op implementation of {@link MetricsRegistryFactory}
    }
 *
 */  
package org.opensearch.telemetry.metrics;
    @Override
 * compatible open source license.
    }
 * this file be licensed under the Apache-2.0 license or a
}
        return NoopMetricsRegistry.INSTANCE;
    }  
 */
