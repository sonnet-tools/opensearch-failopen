    private static final Logger logger = LogManager.getLogger(ParquetStatsProvider.class);
public final class ParquetStatsProvider implements DataFormatStatsProvider<ParquetShardStats> {
        if (INSTANCE == null) {
        return INSTANCE;
    /**  
        return tracker == null ? Optional.empty() : Optional.of(tracker.stats());
import java.util.Map;
        ParquetNativeRuntimeStats runtime = null;  
    public void unregister(ShardId shardId) {  
import org.opensearch.parquet.engine.ParquetDataFormat;  
     * Returns the registered tracker for a shard, or {@code null} if none.
        trackers.put(shardId, tracker);
                }
     * Reads the live {@code parquet_native_write} pool stats from the node thread pool, or returns
            INSTANCE = this;
    }
        return null;  
 * Parquet implementation of {@link DataFormatStatsProvider}.  
 */  
 * on close. The plugin's REST + transport classes read stats from this provider
/*  
    }  
 * SPDX-License-Identifier: Apache-2.0
        // Register with the cross-plugin registry so REST handlers and transports can find us.
    }
    }  
            logger.warn("Failed to collect native runtime metrics; node stats will omit the native_runtime block", e);
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;
import org.opensearch.common.annotation.ExperimentalApi;  
    private static volatile ParquetStatsProvider INSTANCE;  
        return trackers.get(shardId);
        }  
 *  
    public void setThreadPool(org.opensearch.threadpool.ThreadPool threadPool) {
    @Override
 *
        ParquetShardStats agg = ParquetShardStats.empty();
     * {@code null} if the thread pool is unavailable or the pool is not present.
    }  
        }
        }
 * via the {@link DataFormatStatsProvider} interface.
        if (tp == null) {  
        for (ParquetShardStatsTracker t : trackers.values()) {
        this.threadPool = threadPool;  
    }
        try {  
        return Optional.of(agg.withNodeStats(runtime, ingestPool));  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugin.stats.DataFormatStatsProvider;
import org.apache.logging.log4j.Logger;
            }
        }
 * <p>Maintains a per-shard registry of {@link ParquetShardStatsTracker} instances.
import org.opensearch.core.index.shard.ShardId;
import java.util.Optional;
     * directly on the same tracker the engine registered.
 *
    // isn't available when the provider is built in createGuiceModules). May be null in tests.
        // First instance wins. Subsequent constructions are no-ops on the singleton slot.  
            agg = agg.add(t.stats());  
    private volatile org.opensearch.threadpool.ThreadPool threadPool;  
                if (org.opensearch.parquet.ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME.equals(s.getName())) {
    }
    /**
        return FORMAT_NAME;
    /** Unregisters a tracker. Called from the engine's {@code close()} method. */
    }
    }  
    public ParquetShardStatsTracker getTracker(ShardId shardId) {  
    /** Sets the node thread pool used to read live {@code parquet_native_write} pool stats. */
    @Override
package org.opensearch.parquet.stats;
        // leaves that block off rather than failing the whole stats request.
            for (org.opensearch.threadpool.ThreadPoolStats.Stats s : tp.stats()) {
        // metrics. Both are best-effort — a null pool or an unavailable native bridge simply  
     * Used by sibling components (e.g., merger, writer) to increment counters  
    public Optional<ParquetShardStats> aggregateNodeStats() {  
        ParquetIngestPoolStats ingestPool = collectIngestPoolStats();
        try {
    public ParquetStatsProvider() {
import org.opensearch.core.common.io.stream.Writeable;
        }
    private final Map<ShardId, ParquetShardStatsTracker> trackers = new ConcurrentHashMap<>();
    /** Canonical format name, sourced from {@link ParquetDataFormat} to avoid duplicating the literal. */
    public Writeable.Reader<ParquetShardStats> shardStatsReader() {
    /** Returns the singleton instance, or {@code null} if the plugin has not been constructed yet. */
 * construction so the engine layer (which doesn't have easy Guice injection
        ParquetShardStatsTracker tracker = trackers.get(shardId);
    public String formatName() {
        if (trackers.isEmpty()) {
import org.apache.logging.log4j.LogManager;
@ExperimentalApi
}
 * The OpenSearch Contributors require contributions made to  
 * <p>Singleton pattern: a static {@code INSTANCE} field is set during plugin
 *
    public void register(ShardId shardId, ParquetShardStatsTracker tracker) {
            runtime = ParquetNativeRuntimeStats.fromArray(org.opensearch.parquet.bridge.RustBridge.collectRuntimeMetrics());
    @Override  
    // Node-level thread pool backing parquet ingestion writes. Set post-construction (the pool
     */
        return ParquetShardStats::new;
    // --- DataFormatStatsProvider ---
    private ParquetIngestPoolStats collectIngestPoolStats() {
 */  
import java.util.concurrent.ConcurrentHashMap;  
                    return ParquetIngestPoolStats.from(s);  
 * @opensearch.experimental
    }
/**
            return null;
     */  
 * hooks) can register its tracker without DI plumbing.  
    @Override  
        }  
 * {@code ParquetIndexingEngine} self-registers on construction and unregisters  
        trackers.remove(shardId);
        // Node-level decoration: the live parquet_native_write pool snapshot + the Rust runtime
    public Optional<ParquetShardStats> shardStats(ShardId shardId) {  
    public static final String FORMAT_NAME = ParquetDataFormat.PARQUET_DATA_FORMAT_NAME;
 * compatible open source license.
        } catch (Exception e) {  
    /** Registers a tracker for a shard. Called from {@code ParquetIndexingEngine}'s constructor. */  
        DataFormatStatsProviderRegistry.INSTANCE.register(this);
            return Optional.empty();
    }  
        } catch (Exception e) {  
            logger.warn("Failed to collect parquet ingest pool stats", e);
    public static ParquetStatsProvider getInstance() {  
        org.opensearch.threadpool.ThreadPool tp = threadPool;
