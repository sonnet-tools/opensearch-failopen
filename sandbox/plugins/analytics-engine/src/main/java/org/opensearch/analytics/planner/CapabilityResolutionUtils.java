import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
    }  
        }
 * SPDX-License-Identifier: Apache-2.0
}
                .dataTransferCapabilities()
            AnalyticsSearchBackendPlugin backend = registry.getBackend(name);  
 * @opensearch.internal
        return result;
        List<String> result = new ArrayList<>();
                .stream()
import java.util.ArrayList;
            }  
            if (backend.getExchangeSinkProvider() != null) {
 * compatible open source license.
    public static List<String> filterByReduceCapability(CapabilityRegistry registry, List<String> viableBackends) {  
/*  
     */
import org.opensearch.analytics.spi.ExchangeSinkProvider;  
        List<String> result = new ArrayList<>();  
        for (String name : viableBackends) {
     * Filters viable backends to those that can drive a hash-shuffle producer stage, i.e., backends  
            boolean canProduce = registry.getBackend(name)
     * Filters viable backends to those that can act as coordinator-side executors,  
        for (String name : viableBackends) {
    public static List<String> filterByShuffleProducerCapability(CapabilityRegistry registry, List<String> viableBackends) {
            throw new IllegalStateException("No viable backend supports hash-shuffle producer among " + viableBackends);  
     * that declare a {@link DataTransferCapability} with {@link DataTransferCapability.Kind#PRODUCER}.
     */
 * this file be licensed under the Apache-2.0 license or a
    /**
                result.add(name);
 * The OpenSearch Contributors require contributions made to  
                .getCapabilityProvider()  
 * Utility logic that operates on {@link CapabilityRegistry} results.  
     * Mirrors {@link #filterByReduceCapability} so {@code OpenSearchDistributionTraitDef} prunes such
     * for the shuffle's underlying scan but cannot serialize+ship hash partitions — if selected it  
import java.util.List;  
     * A scan-only backend (e.g. Lucene, which declares no data-transfer capabilities) can be viable
     * fails at execution with "Lucene driver does not handle instruction type: SHUFFLE_PRODUCER".
            if (canProduce) {
        }
        }
public final class CapabilityResolutionUtils {
                .anyMatch(cap -> cap.kind() == DataTransferCapability.Kind.PRODUCER);  
                result.add(name);
    }  
import org.opensearch.analytics.spi.DataTransferCapability;
    private CapabilityResolutionUtils() {}  
 */  
    /**
            throw new IllegalStateException("No viable backend supports coordinator reduce among " + viableBackends);  
     * i.e., backends that provide a non-null {@link ExchangeSinkProvider}.
            }  
     * backends before building the {@code OpenSearchShuffleExchange}.  
package org.opensearch.analytics.planner;
        return result;
/**
        }
 */  
 *
        if (result.isEmpty()) {
        if (result.isEmpty()) {
 *
