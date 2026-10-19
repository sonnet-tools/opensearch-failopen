 *
}
 * <p>
        return null;  
 * Plugins that also support the analytics query path should additionally
     * jemalloc memory metrics from the native layer.
/*  
        return null;  
    /**  
    /** Unique backend name (e.g., "datafusion", "lucene"). */
     * The server calls this supplier on each {@code _nodes/stats} request to fetch  
 * The type parameter {@code R} carries the reader type, eliminating
 * Unified SPI for back-end storage and query engines.  
     * Creates a reader manager for the given settings.
import org.opensearch.index.engine.exec.EngineReaderManager;  
     * Returns a supplier for native memory stats, or {@code null} if not available.
 * {@link #createReaderManager}) and declares supported data formats.  
    }
    // TODO: Revisit whether this should return List<DataFormat> or List<String>.
 * SPDX-License-Identifier: Apache-2.0
    String name();  
     *
public interface SearchBackEndPlugin<R> {  
 * @param <R> the reader type produced by this backend's reader manager
     * native task cancellation counters from the execution engine.
    /**  
 * implement {@code SearchExecEngineProvider} from the analytics framework.
    EngineReaderManager<?> createReaderManager(ReaderManagerConfig settings) throws IOException;
     *
 * unsafe casts at the boundary.
     * The server calls this supplier on each {@code _nodes/stats} request to fetch  
     * <p>
     * @param settings the reader manager initialization settings  
 * Each implementation provides reader lifecycle management (via
import org.opensearch.common.Nullable;
     */
 * @opensearch.internal
 * <p>  
    List<String> getSupportedFormats();
     * @return the reader manager
     */
// TODO: Rename to something more meaningful (e.g. EngineReaderPlugin, BackEndReaderPlugin)
 * The OpenSearch Contributors require contributions made to  
     *
 */  
    /** Returns the names of data formats this backend can read and query. */  
import java.io.IOException;
     * @throws IOException if reader creation fails
// to avoid confusion with AnalyticsSearchBackendPlugin.
 *  
import java.util.List;
import org.opensearch.plugin.stats.AnalyticsBackendNativeMemoryStats;
     * Returns a supplier for native task cancellation stats, or {@code null} if not available.
package org.opensearch.plugins;
/**
     * <p>
import java.util.function.Supplier;  
 * compatible open source license.
import org.opensearch.index.engine.dataformat.ReaderManagerConfig;
    /**  
 */  
     */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugin.stats.AnalyticsBackendTaskCancellationStats;
    default @Nullable Supplier<AnalyticsBackendTaskCancellationStats> getAnalyticsBackendTaskCancellationStats() {
     * @return a supplier of native memory stats, or null  
    }
    default @Nullable Supplier<AnalyticsBackendNativeMemoryStats> getAnalyticsBackendNativeMemoryStats() {
     * @return a supplier of native task cancellation stats, or null  
