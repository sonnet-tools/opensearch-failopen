    private static final Logger logger = LogManager.getLogger(NodeCacheService.class);
    /**
            missBytes += s.missBytes();
            total += bc.stats().totalBytes();
    }
    /**
        return fileCache.fileCacheStats();
            evictions += s.evictions();
        BlockCacheTieredStats tiered = null;
    // Provider registration
     * for each provider's data-to-cache amplification ratio.
    }
        // Inform each provider of its exact reserved capacity to avoid re-derivation.
        if (blockCaches.isEmpty()) {
    @Override
    // ─────────────────────────────────────────────────────────────────────────
                new FileCache.LoadTask(fileCacheNodePath.indicesPath, fileCache, exception)
public class NodeCacheService implements Closeable, BlockCacheRegistry {
 * Single authority for all warm-node SSD caches on this node.
     * Used by {@link org.opensearch.monitor.fs.WarmFsService} for capacity reporting.
            hits += s.hits();
    public static NodeCacheService create(Settings settings, NodeEnvironment nodeEnvironment, Map<String, BlockCacheProvider> providers)
            } catch (OpenSearchParseException ex) {
            fc.getPinnedFileCacheStats()
    }
            removed,
        return providers.values()
            fc.getTotal().getBytes() + bc.totalBytes(),
            total += s.totalBytes();
            activeInBytes,
    }
 *   <li>{@link FileCache} — Lucene block-file cache. Always present on warm nodes.</li>
        logger.info("Block cache registered (disk bytes used so far: {})", new ByteSizeValue(blockCache.stats().diskBytesUsed()));
        }
        return fileCache;
                "After allocating "
        );
        ForkJoinPool loadFileCacheThreadpool = new ForkJoinPool(
        if (blockCaches.isEmpty()) {
     */
    @Override
        if (blockCacheBytes < 0) {
}
        long hits = 0, misses = 0, hitBytes = 0, missBytes = 0;
        } catch (OpenSearchParseException e) {
    }
 * SPDX-License-Identifier: Apache-2.0
    // Lifecycle
                merged.getCacheHits(),
     *
            misses,
        long total = 0;
import org.opensearch.common.SetOnce;
        long hits = 0, misses = 0, hitBytes = 0, missBytes = 0;
import org.opensearch.common.unit.RatioValue;
     * Returns {@code null} if no block caches are registered.
     * <p>After creation, call {@link #registerProviders} once all plugins have
    /**
            fc.getRemoved().getBytes() + bc.removedBytes(),
            indicesFilesLoadTask.join();
        for (BlockCache bc : blockCaches) {
        FileCacheStats mergedOverall = new FileCacheStats(
        long memUsed = 0, diskUsed = 0, total = 0, activeInBytes = 0;
    public long cacheUtilizedBytes() {
     * Call once after all plugins have created their components.
            );
            if (tiered == null) {
        if (totalSSDBytes <= 0) {
     */
            null,
 *       registered after node startup by block-cache plugins via {@link #registerProviders}.</li>
    }
        throws IOException {
            .stream()
        return total;
     */
            fcBlock.getRemoved() + bc.removedBytes(),
        long totalSSDBytes = ExceptionsHelper.catchAsRuntimeException(() -> FsProbe.getTotalSize(nodeEnvironment.fileCacheNodePath()));
                merged.getCacheMisses(),
            new FileCache.LoadTask(fileCacheNodePath.fileCachePath, fileCache, exception)
            try {
        AggregateFileCacheStats merged = mergeStats(fileCacheStats, combined);
     * Returns a combined {@link BlockCacheStats} snapshot aggregated across all registered block caches.
    public static long computeBlockCacheBudget(Map<String, BlockCacheProvider> providers, Settings settings, long totalBudgetBytes) {
import org.opensearch.core.common.unit.ByteSizeValue;
        }
     * are lock-free while writes (plugin registration at startup) are rare.
    public long virtualBlockCacheBytes() {
        return virtualBlockCacheBytes;
            fc.getCacheMisses() + bc.misses(),
            }
        if (fileCacheBytes <= 0) {
        return providers.values().stream().mapToLong(p -> p.requestedCapacityBytes(settings, totalBudgetBytes)).sum();
        fileCacheFilesLoadTask.join();
        for (BlockCacheProvider p : providers.values()) {
 */
            evictionBytes += s.evictionBytes();
    public long blockCacheCapacityBytes() {
                merged.getActive().getBytes(),
 *   <li>{@link BlockCache} list (optional) — block caches for variable-size byte ranges,
            AggregateFileCacheStats.FileCacheStatsType.BLOCK_FILE_STATS
        restoreFileCacheFromDisk(settings, fileCacheNodePath, fileCache);
        SetOnce<UncheckedIOException> exception = new SetOnce<>();
     *
        return blockCaches.stream().filter(bc -> name.equals(bc.cacheName())).findFirst();
     * Called by {@code Node.java} before plugins' {@code createComponents()} so that
    }
 *
    public java.util.Optional<BlockCache> get(String name) {
        long totalSSDBytes = ExceptionsHelper.catchAsRuntimeException(() -> FsProbe.getTotalSize(fileCacheNodePath));
import java.io.IOException;
/**
                "Warm node SSD allocation exceeds available capacity. "
    public long blockCacheDiskBytesUsed() {
import java.util.concurrent.CopyOnWriteArrayList;
        fileCacheNodePath.fileCacheReservedSize = new ByteSizeValue(fileCacheBytes, ByteSizeUnit.BYTES);
 * compatible open source license.
            BlockCacheStats s = bc.stats();
            fc.getFullFileCacheStats(),
            throw new OpenSearchException(exception.get());
            removedBytes += s.removedBytes();
            fc.getEvicted().getBytes() + bc.evictionBytes(),
        return new AggregateFileCacheStats(
        ForkJoinTask<Void> fileCacheFilesLoadTask = loadFileCacheThreadpool.submit(
                    + new ByteSizeValue(blockCacheBytes)
            logger.error("File cache initialization failed.", exception.get());
            Runtime.getRuntime().availableProcessors(),
    @Override
        this(fileCache, 0L);
    /**
            activeInBytes += s.activeInBytes();
        );
 * </ul>
            throw new SettingsException(
 * <p>Only instantiated on warm nodes.
    }
        return total;
    // ─────────────────────────────────────────────────────────────────────────
        this.virtualBlockCacheBytes = virtualBlockCacheBytes;
                merged.getPinnedUsage().getBytes(),
    public static long computeTotalBudgetBytes(Settings settings, NodeEnvironment nodeEnvironment) {
            evictions += s.evictions();
import org.opensearch.plugins.BlockCache;
     * the top-level and sub-section numbers reflect the true cross-cache rollup.
            misses += s.misses();
     */
    /**
    /** Returns a snapshot of all registered block caches. */
        }
    // ─────────────────────────────────────────────────────────────────────────
    /**
    }
            evictionBytes,
        this.fileCache = fileCache;
     */
        );
        long fileCacheBytes = totalBudgetBytes - blockCacheBytes;
     * Equals sum(plugin.reservedBytes * plugin.dataToCapacityRatio), computed once at creation.
        }
            BlockCacheStats s = bc.stats();
        );
import java.io.Closeable;
            hits += s.hits();
            fc.getUsed().getBytes() + bc.diskBytesUsed() + bc.memoryBytesUsed(),
            fc.getTimestamp(),
        return used;
     * Uses CopyOnWriteArrayList so reads (stats aggregation on every _nodes/stats call)
import org.opensearch.monitor.fs.FsProbe;
     *
     */
        if (!blockCaches.isEmpty()) {
                    + ", total SSD="
import org.opensearch.common.settings.Settings;
            throw new SettingsException(
        if (blockCache == null) return;
        validate(fileCacheBytes, blockCacheBytes, totalSSDBytes);
            provider.setReservedCapacityBytes(reserved);
            hitBytes += s.hitBytes();
    /** Package-private constructor for testing — creates an orchestrator with no block-cache budget. */
 *
            );
    }
    NodeCacheService(FileCache fileCache, long virtualBlockCacheBytes) {
            long reserved = provider.requestedCapacityBytes(settings, totalBudgetBytes);
     */
     * Returns FileCache-only stats with no block cache contribution.
    public List<BlockCache> all() {
    }
            removedBytes,
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(fileCacheBytes);
    public void close() throws IOException {
            BlockCacheStats s = bc.stats();
    // Accessors (lock-free reads — blockCaches is CopyOnWriteArrayList)
     * Returns the total configured capacity (in bytes) across all registered block caches.
                    + " to block cache(s), no SSD budget remains for FileCache. "
     * Creates a {@code NodeCacheService} for a warm node.
            new FileCacheStats(
        String warmCacheSizeRaw = Node.NODE_SEARCH_CACHE_SIZE_SETTING.get(settings);
            memUsed += s.memoryBytesUsed();
import org.opensearch.core.common.unit.ByteSizeUnit;
            removed,
            diskUsed += s.diskBytesUsed();
    /** Returns total bytes currently used across all caches (FileCache + block caches). */
     * Wires live BlockCache instances from providers after {@code createComponents()}.
        long total = 0;
                "Unable to determine SSD capacity; got: " + totalSSDBytes + ". Ensure the filecache path is mounted and readable."
            used += s.memoryBytesUsed() + s.diskBytesUsed();
            memoryUsed += s.memoryBytesUsed();
            throw new SettingsException(
    // Stats aggregation
        long evictions = 0, evictionBytes = 0, removed = 0, removedBytes = 0;
     * Returns total SSD bytes currently used by all block caches combined.
    private final long virtualBlockCacheBytes;
            evictionBytes += s.evictionBytes();
    // Private helpers
            merged.getFullFileCacheStats(),
            diskUsed,
     */
     * {@link org.opensearch.plugins.BlockCacheProvider#requestedCapacityBytes} can receive
                merged.getTotal().getBytes(),
    /** Package-private for testing — use {@link #create} in production. */
    }
                tiered = bc.tieredStats();
import org.opensearch.ExceptionsHelper;
        );
    /**
                ex.addSuppressed(e);
            activeInBytes
        long evictions = 0, evictionBytes = 0, removed = 0, removedBytes = 0;
 *
import org.opensearch.plugins.BlockCacheTieredStats;
        }
    NodeCacheService(FileCache fileCache) {
            missBytes += s.missBytes();
            removedBytes += s.removedBytes();
     */
     * Pre-computed virtual bytes that all registered block-cache plugins can serve.
import org.opensearch.common.settings.SettingsException;
                    + "file_cache="
     * @param providers all discovered {@link BlockCacheProvider} plugins
     */
            removed += s.removed();
    // ─────────────────────────────────────────────────────────────────────────
            fc.getActive().getBytes() + bc.activeInBytes(),
                "Block cache allocation must be >= 0; got: " + blockCacheBytes + ". Check block cache plugin configuration."
     * Used by {@code _nodes/stats/file_cache?detailed} to return FileCache-only stats.
            );
    public AggregateFileCacheStats aggregateStats() {
            );
        for (BlockCache bc : blockCaches) {
        long blockCacheBytes = computeBlockCacheBudget(providers, settings, totalBudgetBytes);
        }
        return List.copyOf(blockCaches);
import java.io.UncheckedIOException;
            fc.getPinnedUsage().getBytes(),
            }
            mergedOverall,
            evictions,
    private static void restoreFileCacheFromDisk(Settings settings, NodeEnvironment.NodePath fileCacheNodePath, FileCache fileCache)
 * @opensearch.experimental
            );
        long totalBudgetBytes = calculateFileCacheSize(warmCacheSizeRaw, totalSSDBytes);
            total += bc.stats().diskBytesUsed();
import org.apache.logging.log4j.Logger;
        return calculateFileCacheSize(warmCacheSizeRaw, totalSSDBytes);
    // ─────────────────────────────────────────────────────────────────────────
        blockCaches.add(blockCache);
            fcBlock.getCacheHits() + bc.hits(),
     * from disk, and computes virtual block-cache bytes for capacity reporting.
     * Computes the total warm-cache SSD budget in bytes.
            .mapToLong(p -> Math.round(p.requestedCapacityBytes(settings, totalBudgetBytes) * p.dataToCapacityRatio(settings)))
            total,
    /** Closes all registered block caches, then lets FileCache be GC'd. */
     */
@ExperimentalApi
    }
 * <p>Owns the lifecycle, disk budget, validation, and stats aggregation for:
        String warmCacheSizeRaw = Node.NODE_SEARCH_CACHE_SIZE_SETTING.get(settings);
        if (org.opensearch.cluster.node.DiscoveryNode.isDedicatedWarmNode(settings)) {
                    + ", block_cache="
    /**
     * <p>Performs the full budget phase: queries each provider for its requested
        );
            removed += s.removed();
import org.opensearch.plugins.BlockCacheStats;
        }
        try {
            hits,
            fcBlock.getCacheMisses() + bc.misses(),
                    + ". Reduce node.search.cache.size or block cache allocation."
                    + "Reduce block cache allocation or increase node.search.cache.size."
        return new BlockCacheStats(
    }
            return fileCacheStats;
                merged.getUsed().getBytes(),
                AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS
/*
     * the correct budget value.
        // Pre-compute virtual capacity: each plugin's reserved bytes × its amplification ratio.
     * <p>Must only be called when {@code DiscoveryNode.isWarmNode(settings) == true}.
import java.util.concurrent.ForkJoinPool;
    }
    // ─────────────────────────────────────────────────────────────────────────
        }
    private BlockCacheStats combineBlockCacheStats() {
    private final FileCache fileCache;
        return blockCaches();
            evictionBytes,
    }
    public void registerProviders(Map<String, BlockCacheProvider> providers) {
        }
            RatioValue ratioValue = RatioValue.parseRatioValue(capacityRaw);
    /**
        }
    // ─────────────────────────────────────────────────────────────────────────
    }
        FileCacheStats mergedBlock = new FileCacheStats(
        return new NodeCacheService(fileCache, virtualBytes);
        }
    public BlockCacheStats combinedBlockCacheStats() {
                    + new ByteSizeValue(fileCacheBytes)
        loadFileCacheThreadpool.shutdown();
        if (exception.get() != null) {
    }
            activeInBytes += s.activeInBytes();
        }
    }
    // Validation
        }
        // Budget phase: ask each provider how much SSD it needs, then partition.
            logger.info("Block caches closed ({})", blockCaches.size());
            fcBlock.getUsed() + bc.diskBytesUsed() + bc.memoryBytesUsed(),
            throw new SettingsException(
    // ─────────────────────────────────────────────────────────────────────────
import org.opensearch.node.Node;
    }
    /** LRU cache for Lucene index files. Always present on warm nodes. */
            return Math.round(availableSpace * ratioValue.getAsRatio());
        for (BlockCache bc : blockCaches) {
     *
    public AggregateFileCacheStats fileCacheStatsOnly() {
        if (fileCacheBytes + blockCacheBytes > totalSSDBytes) {
package org.opensearch.index.store.remote.filecache;
import org.opensearch.env.NodeEnvironment;
            tiered
import org.opensearch.OpenSearchParseException;
            diskUsed += s.diskBytesUsed();
            misses,
    }
import org.opensearch.OpenSearchException;
        return new BlockCacheStats(
            diskUsed,
            Node.CustomForkJoinWorkerThread::new,
            evictions,
import org.opensearch.plugins.BlockCacheProvider;
            missBytes,
                    + new ByteSizeValue(totalSSDBytes)
    // ─────────────────────────────────────────────────────────────────────────
     * Returns the pre-computed virtual bytes that all block caches can serve.
            p.getBlockCache().ifPresent(this::addBlockCache);
            fcBlock.getEvicted() + bc.evictionBytes(),
        long memoryUsed = 0, diskUsed = 0, totalCapacity = 0, activeInBytes = 0;
            hitBytes,
    /**
    /**
            missBytes,
    // Static factory
            merged.getBlockFileCacheStats(),
    /**
        );
        }
    }
            ForkJoinTask<Void> indicesFilesLoadTask = loadFileCacheThreadpool.submit(
    // ─────────────────────────────────────────────────────────────────────────
            IOUtils.closeWhileHandlingException(blockCaches);
        throws IOException {
    // ─────────────────────────────────────────────────────────────────────────
        AggregateFileCacheStats fileCacheStats = fileCache.fileCacheStats();
import java.util.List;
        long used = fileCache != null ? fileCache.usage() : 0L;
        FileCacheStats fcBlock = fc.getBlockFileCacheStats();
        NodeEnvironment.NodePath fileCacheNodePath = nodeEnvironment.fileCacheNodePath();
import org.opensearch.plugins.BlockCacheRegistry;
 * The OpenSearch Contributors require contributions made to
            merged.getTimestamp(),
    // ─────────────────────────────────────────────────────────────────────────
            removedBytes,
        }
        }
        for (BlockCache bc : blockCaches) {
            misses += s.misses();
                return ByteSizeValue.parseBytesSizeValue(capacityRaw, Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey()).getBytes();
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
            memoryUsed,
                merged.getRemoved().getBytes(),
    }
    /**
    }
     * Computes the virtual data bytes that all block caches can serve, accounting
    static long computeVirtualBlockCacheBytes(Map<String, BlockCacheProvider> providers, Settings settings, long totalBudgetBytes) {
import java.util.concurrent.ForkJoinTask;
 */
     * Sums the SSD bytes requested by all registered block-cache providers.
    public List<BlockCache> blockCaches() {
        return new AggregateFileCacheStats(
     *
    private static AggregateFileCacheStats mergeStats(AggregateFileCacheStats fc, BlockCacheStats bc) {
     * <p>Block cache counters are folded into the merged overall/block sections so that
            .sum();
            fcBlock.getActive() + bc.activeInBytes(),
            hitBytes,
    /** Package-private for testing. */
     * Block caches registered by plugins after node startup via {@link #registerProviders}.
            fc.getCacheHits() + bc.hits(),
            fcBlock.getTotal() + bc.totalBytes(),
                    + new ByteSizeValue(blockCacheBytes)
import org.opensearch.common.annotation.ExperimentalApi;
     */
        );
            ),
            memUsed,
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS
    private static long calculateFileCacheSize(String capacityRaw, long availableSpace) {
 * <ul>
            false
            fcBlock.getPinnedUsage(),
import org.apache.logging.log4j.LogManager;
    private final List<BlockCache> blockCaches = new CopyOnWriteArrayList<>();
            totalCapacity += s.totalBytes();
    static void validate(long fileCacheBytes, long blockCacheBytes, long totalSSDBytes) {
                throw ex;
            mergedBlock,
     * finished {@code createComponents()} to wire in the live BlockCache instances.
            return null;
    /** Returns the {@link FileCache} instance. */
        }
    }
        BlockCacheStats combined = combineBlockCacheStats();
    // ─────────────────────────────────────────────────────────────────────────
            merged.getPinnedFileCacheStats()
                merged.getEvicted().getBytes(),
        for (BlockCache bc : blockCaches) {
            totalCapacity,
            hitBytes += s.hitBytes();
     * Returns aggregate stats across all caches for {@code _nodes/stats aggregate_file_cache}.
            hits,
     */
    public FileCache fileCache() {
    void addBlockCache(BlockCache blockCache) {
    // ─────────────────────────────────────────────────────────────────────────
     * capacity, validates the budget, creates FileCache, restores surviving files
        for (BlockCacheProvider provider : providers.values()) {
import org.opensearch.common.util.io.IOUtils;
        long virtualBytes = computeVirtualBlockCacheBytes(providers, settings, totalBudgetBytes);
 *
