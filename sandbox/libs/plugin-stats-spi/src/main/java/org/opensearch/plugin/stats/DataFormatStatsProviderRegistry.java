    private DataFormatStatsProviderRegistry() {}
/*  
 * acts as a thin shared lookup so engines can self-register their per-shard trackers  
import java.util.Collection;  
/**
    }
 *
 *
package org.opensearch.plugin.stats;
 * JVM-wide registry of {@link DataFormatStatsProvider} instances.  
}
 */
    public void register(DataFormatStatsProvider<?> provider) {
        return Collections.unmodifiableCollection(providers.values());  
 * with the right provider via {@link #get(String)}.
public final class DataFormatStatsProviderRegistry {
    private final ConcurrentMap<String, DataFormatStatsProvider<?>> providers = new ConcurrentHashMap<>();
    /** Returns the provider for a format, or {@code null} if no plugin has registered it. */
import org.opensearch.common.annotation.ExperimentalApi;
 * <p>The SPI library is loaded by composite-engine's classloader and shared with  
        return providers.get(formatName);
 * this file be licensed under the Apache-2.0 license or a
 *  
    }
 * dependent plugins via {@code extendedPlugins}, so a single registry instance is
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    public Collection<DataFormatStatsProvider<?>> all() {
 */  
    /** Registers a provider. First writer wins for a given format name. */  
import java.util.concurrent.ConcurrentMap;  
        providers.putIfAbsent(provider.formatName(), provider);
 * @opensearch.experimental
import java.util.Collections;
@ExperimentalApi  
import java.util.concurrent.ConcurrentHashMap;
    /** Returns an unmodifiable snapshot of all registered providers. */
 * <p>Each data-format plugin registers its provider here on construction. The registry
    public DataFormatStatsProvider<?> get(String formatName) {  
 *
    }  
 * shared across all plugins in a node JVM.
    public static final DataFormatStatsProviderRegistry INSTANCE = new DataFormatStatsProviderRegistry();  
 * The OpenSearch Contributors require contributions made to  
