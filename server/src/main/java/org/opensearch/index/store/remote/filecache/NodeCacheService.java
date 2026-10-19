            );
                "After allocating "  
            fc.getActive().getBytes() + bc.activeInBytes(),
    }
import org.opensearch.common.settings.SettingsException;  
            merged.getFullFileCacheStats(),
import java.util.concurrent.CopyOnWriteArrayList;
    // ─────────────────────────────────────────────────────────────────────────
 *
import org.opensearch.monitor.fs.FsProbe;  
        ForkJoinPool loadFileCacheThreadpool = new ForkJoinPool(  
import org.opensearch.node.Node;
        for (BlockCacheProvider p : providers.values()) {
 *
        BlockCacheStats combined = combineBlockCacheStats();
            removed,
        loadFileCacheThreadpool.shutdown();
                "Unable to determine SSD capacity; got: " + totalSSDBytes + ". Ensure the filecache path is mounted and readable."
    }
            hits += s.hits();  
            removed += s.removed();  
     * Wires live BlockCache instances from providers after {@code createComponents()}.  
    // ─────────────────────────────────────────────────────────────────────────  
        SetOnce<UncheckedIOException> exception = new SetOnce<>();  
     * Returns FileCache-only stats with no block cache contribution.  
    /**  
    // ─────────────────────────────────────────────────────────────────────────
            evictionBytes += s.evictionBytes();
            misses += s.misses();
        long memoryUsed = 0, diskUsed = 0, totalCapacity = 0, activeInBytes = 0;
        long hits = 0, misses = 0, hitBytes = 0, missBytes = 0;  
            new FileCache.LoadTask(fileCacheNodePath.fileCachePath, fileCache, exception)
            throw new SettingsException(  
            total += s.totalBytes();
                merged.getUsed().getBytes(),  
        return new AggregateFileCacheStats(
    /** Returns total bytes currently used across all caches (FileCache + block caches). */  
    }
     * Equals sum(plugin.reservedBytes * plugin.dataToCapacityRatio), computed once at creation.
     * for each provider's data-to-cache amplification ratio.  
    // ─────────────────────────────────────────────────────────────────────────  
        long hits = 0, misses = 0, hitBytes = 0, missBytes = 0;  
        this.virtualBlockCacheBytes = virtualBlockCacheBytes;
    /**
    }
    private final FileCache fileCache;
import org.opensearch.common.settings.Settings;
     */
     */  
            BlockCacheStats s = bc.stats();
 * <p>Only instantiated on warm nodes.  
            ),
     * Creates a {@code NodeCacheService} for a warm node.
            throw new OpenSearchException(exception.get());
            );
        FileCacheStats mergedOverall = new FileCacheStats(  
            missBytes += s.missBytes();  
    /**
        if (blockCaches.isEmpty()) {  
        }
            activeInBytes
            fc.getTimestamp(),  
        return new BlockCacheStats(
            fc.getRemoved().getBytes() + bc.removedBytes(),  
            removedBytes,  
    private static final Logger logger = LogManager.getLogger(NodeCacheService.class);
        );
            missBytes += s.missBytes();  
     * <p>Must only be called when {@code DiscoveryNode.isWarmNode(settings) == true}.
        if (fileCacheBytes <= 0) {
        // Inform each provider of its exact reserved capacity to avoid re-derivation.
import org.opensearch.core.common.unit.ByteSizeValue;
            mergedBlock,  
        validate(fileCacheBytes, blockCacheBytes, totalSSDBytes);  
import org.apache.logging.log4j.Logger;
            );
        }  
    }
        }  
            merged.getBlockFileCacheStats(),  
        AggregateFileCacheStats fileCacheStats = fileCache.fileCacheStats();
            misses,  
     *  
     */  
        return new BlockCacheStats(
                AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS  
 * <ul>  
        return virtualBlockCacheBytes;
            null,  
            merged.getTimestamp(),
        }  
        long totalSSDBytes = ExceptionsHelper.catchAsRuntimeException(() -> FsProbe.getTotalSize(nodeEnvironment.fileCacheNodePath()));
 *
    // Lifecycle  
        long totalSSDBytes = ExceptionsHelper.catchAsRuntimeException(() -> FsProbe.getTotalSize(fileCacheNodePath));  
     */  
     */
        restoreFileCacheFromDisk(settings, fileCacheNodePath, fileCache);
    static long computeVirtualBlockCacheBytes(Map<String, BlockCacheProvider> providers, Settings settings, long totalBudgetBytes) {
    /**
        if (totalSSDBytes <= 0) {
    // ─────────────────────────────────────────────────────────────────────────  
import java.io.Closeable;
    @Override
            BlockCacheStats s = bc.stats();
            memoryUsed,
    /** Package-private constructor for testing — creates an orchestrator with no block-cache budget. */
        this(fileCache, 0L);  
    // Accessors (lock-free reads — blockCaches is CopyOnWriteArrayList)
            logger.info("Block caches closed ({})", blockCaches.size());
            fcBlock.getCacheHits() + bc.hits(),
    public AggregateFileCacheStats fileCacheStatsOnly() {  
                ex.addSuppressed(e);
        return total;  
                merged.getCacheMisses(),
            } catch (OpenSearchParseException ex) {
        }
            fcBlock.getActive() + bc.activeInBytes(),
    public long blockCacheDiskBytesUsed() {
     * finished {@code createComponents()} to wire in the live BlockCache instances.  
        return calculateFileCacheSize(warmCacheSizeRaw, totalSSDBytes);  
            misses,  
 */  
     * Used by {@link org.opensearch.monitor.fs.WarmFsService} for capacity reporting.
            total += bc.stats().diskBytesUsed();
        if (exception.get() != null) {  
            ForkJoinTask<Void> indicesFilesLoadTask = loadFileCacheThreadpool.submit(
            fc.getCacheMisses() + bc.misses(),
        FileCacheStats fcBlock = fc.getBlockFileCacheStats();
                    + "file_cache="
        if (blockCacheBytes < 0) {
     */
    // Private helpers
            tiered
    /**
    @Override  
    }
     * <p>After creation, call {@link #registerProviders} once all plugins have
    /**  
            fc.getPinnedFileCacheStats()
    private BlockCacheStats combineBlockCacheStats() {
        fileCacheFilesLoadTask.join();
    // ─────────────────────────────────────────────────────────────────────────  
            evictionBytes,
            fcBlock.getPinnedUsage(),
                    + ". Reduce node.search.cache.size or block cache allocation."
        }  
    static void validate(long fileCacheBytes, long blockCacheBytes, long totalSSDBytes) {
            return fileCacheStats;
    // ─────────────────────────────────────────────────────────────────────────
            hitBytes,
        }  
        long totalBudgetBytes = calculateFileCacheSize(warmCacheSizeRaw, totalSSDBytes);  
            provider.setReservedCapacityBytes(reserved);
    }  
                "Warm node SSD allocation exceeds available capacity. "  
            removedBytes,  
            diskUsed += s.diskBytesUsed();  
    // Static factory
        return new AggregateFileCacheStats(
    /**  
                    + " to block cache(s), no SSD budget remains for FileCache. "
        blockCaches.add(blockCache);  
public class NodeCacheService implements Closeable, BlockCacheRegistry {
        long virtualBytes = computeVirtualBlockCacheBytes(providers, settings, totalBudgetBytes);
    }
     * the correct budget value.
            indicesFilesLoadTask.join();
        long blockCacheBytes = computeBlockCacheBudget(providers, settings, totalBudgetBytes);  
            evictionBytes += s.evictionBytes();
    void addBlockCache(BlockCache blockCache) {
        String warmCacheSizeRaw = Node.NODE_SEARCH_CACHE_SIZE_SETTING.get(settings);
import org.apache.logging.log4j.LogManager;
                    + ", total SSD="
     * Returns the total configured capacity (in bytes) across all registered block caches.  
        throws IOException {
            );
                merged.getActive().getBytes(),
            evictions,  
        for (BlockCache bc : blockCaches) {  
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS  
    /**
                throw ex;  
            memoryUsed += s.memoryBytesUsed();
            hits += s.hits();  
        );
            hitBytes += s.hitBytes();
        long memUsed = 0, diskUsed = 0, total = 0, activeInBytes = 0;
     * the top-level and sub-section numbers reflect the true cross-cache rollup.
/**
            evictionBytes,
    NodeCacheService(FileCache fileCache, long virtualBlockCacheBytes) {
     */
 * </ul>
        for (BlockCache bc : blockCaches) {
        if (!blockCaches.isEmpty()) {  
import org.opensearch.OpenSearchException;
    // ─────────────────────────────────────────────────────────────────────────  
     * Returns the pre-computed virtual bytes that all block caches can serve.
    }  
     * Call once after all plugins have created their components.
        }
        return blockCaches.stream().filter(bc -> name.equals(bc.cacheName())).findFirst();  
            memUsed += s.memoryBytesUsed();
            logger.error("File cache initialization failed.", exception.get());
            Runtime.getRuntime().availableProcessors(),
            .stream()
    // ─────────────────────────────────────────────────────────────────────────
     * capacity, validates the budget, creates FileCache, restores surviving files
    // ─────────────────────────────────────────────────────────────────────────
            try {
            fc.getUsed().getBytes() + bc.diskBytesUsed() + bc.memoryBytesUsed(),  
import org.opensearch.ExceptionsHelper;  
            diskUsed += s.diskBytesUsed();  
/*  
            hitBytes += s.hitBytes();
    }  
            }
        return fileCache;
        }  
    private final long virtualBlockCacheBytes;
     *  
            return Math.round(availableSpace * ratioValue.getAsRatio());  
    private static void restoreFileCacheFromDisk(Settings settings, NodeEnvironment.NodePath fileCacheNodePath, FileCache fileCache)
            removed,
    public long virtualBlockCacheBytes() {
            fcBlock.getCacheMisses() + bc.misses(),
    // Provider registration
        }  
import java.util.Map;  
        BlockCacheTieredStats tiered = null;  
        return new NodeCacheService(fileCache, virtualBytes);  
import org.opensearch.plugins.BlockCacheProvider;  
            merged.getPinnedFileCacheStats()
            fcBlock.getEvicted() + bc.evictionBytes(),
        // Budget phase: ask each provider how much SSD it needs, then partition.
    /** Closes all registered block caches, then lets FileCache be GC'd. */  
     * <p>Performs the full budget phase: queries each provider for its requested
    // ─────────────────────────────────────────────────────────────────────────  
 * The OpenSearch Contributors require contributions made to  
     * Returns aggregate stats across all caches for {@code _nodes/stats aggregate_file_cache}.
                return ByteSizeValue.parseBytesSizeValue(capacityRaw, Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey()).getBytes();  
     * Returns {@code null} if no block caches are registered.  
            if (tiered == null) {  
        if (fileCacheBytes + blockCacheBytes > totalSSDBytes) {
            fc.getTotal().getBytes() + bc.totalBytes(),
    public java.util.Optional<BlockCache> get(String name) {
            fc.getEvicted().getBytes() + bc.evictionBytes(),
            return null;
            false
    /**  
            hitBytes,
     */
import org.opensearch.plugins.BlockCacheRegistry;
     * {@link org.opensearch.plugins.BlockCacheProvider#requestedCapacityBytes} can receive  
     * @param providers all discovered {@link BlockCacheProvider} plugins
    }
 */  
    // Validation
    }  
import java.util.concurrent.ForkJoinPool;
        }  
     * Block caches registered by plugins after node startup via {@link #registerProviders}.
    /**
        throws IOException {
    private static long calculateFileCacheSize(String capacityRaw, long availableSpace) {  
            fc.getPinnedUsage().getBytes(),
                merged.getRemoved().getBytes(),  
 *
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(fileCacheBytes);
import org.opensearch.common.util.io.IOUtils;
        this.fileCache = fileCache;  
 *       registered after node startup by block-cache plugins via {@link #registerProviders}.</li>  
            diskUsed,
        logger.info("Block cache registered (disk bytes used so far: {})", new ByteSizeValue(blockCache.stats().diskBytesUsed()));
        for (BlockCache bc : blockCaches) {  
    }
        return blockCaches();
            long reserved = provider.requestedCapacityBytes(settings, totalBudgetBytes);
import java.io.UncheckedIOException;
    /**
        }
}
                    + new ByteSizeValue(totalSSDBytes)  
 * this file be licensed under the Apache-2.0 license or a
            misses += s.misses();
            memUsed,
     * Sums the SSD bytes requested by all registered block-cache providers.
    /**
import org.opensearch.plugins.BlockCache;
    }  
        for (BlockCache bc : blockCaches) {
import org.opensearch.plugins.BlockCacheStats;
            AggregateFileCacheStats.FileCacheStatsType.BLOCK_FILE_STATS  
            evictions += s.evictions();
     * are lock-free while writes (plugin registration at startup) are rare.  
    }
        if (blockCaches.isEmpty()) {  
    public static NodeCacheService create(Settings settings, NodeEnvironment nodeEnvironment, Map<String, BlockCacheProvider> providers)  
                "Block cache allocation must be >= 0; got: " + blockCacheBytes + ". Check block cache plugin configuration."  
        return total;
    }
        return used;
            totalCapacity,  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        return providers.values()  
@ExperimentalApi
    // ─────────────────────────────────────────────────────────────────────────
            activeInBytes,
            throw new SettingsException(
        long evictions = 0, evictionBytes = 0, removed = 0, removedBytes = 0;
            hits,
    public static long computeBlockCacheBudget(Map<String, BlockCacheProvider> providers, Settings settings, long totalBudgetBytes) {  
 *   <li>{@link BlockCache} list (optional) — block caches for variable-size byte ranges,
    }
        }  
    }
     *
    public void registerProviders(Map<String, BlockCacheProvider> providers) {  
            fcBlock.getRemoved() + bc.removedBytes(),  
        );
import java.util.concurrent.ForkJoinTask;  
            p.getBlockCache().ifPresent(this::addBlockCache);
                merged.getTotal().getBytes(),
     * from disk, and computes virtual block-cache bytes for capacity reporting.  
     */
    }
        AggregateFileCacheStats merged = mergeStats(fileCacheStats, combined);
    public FileCache fileCache() {  
            activeInBytes += s.activeInBytes();
 * SPDX-License-Identifier: Apache-2.0
    }
    public List<BlockCache> all() {
            totalCapacity += s.totalBytes();
            missBytes,
                    + "Reduce block cache allocation or increase node.search.cache.size."  
    private static AggregateFileCacheStats mergeStats(AggregateFileCacheStats fc, BlockCacheStats bc) {
    }  
import org.opensearch.common.SetOnce;  
            new FileCacheStats(  
    NodeCacheService(FileCache fileCache) {
    /** Package-private for testing. */  
    public long blockCacheCapacityBytes() {
     */
            activeInBytes += s.activeInBytes();
        } catch (OpenSearchParseException e) {
        String warmCacheSizeRaw = Node.NODE_SEARCH_CACHE_SIZE_SETTING.get(settings);
     * Computes the total warm-cache SSD budget in bytes.
    public BlockCacheStats combinedBlockCacheStats() {
            fcBlock.getUsed() + bc.diskBytesUsed() + bc.memoryBytesUsed(),  
            evictions,  
            hits,
    // Stats aggregation
                merged.getPinnedUsage().getBytes(),
            total,  
        long used = fileCache != null ? fileCache.usage() : 0L;
        );
     *  
        long total = 0;
     * Returns total SSD bytes currently used by all block caches combined.
                    + new ByteSizeValue(blockCacheBytes)
        NodeEnvironment.NodePath fileCacheNodePath = nodeEnvironment.fileCacheNodePath();
            missBytes,
    public void close() throws IOException {
    /** LRU cache for Lucene index files. Always present on warm nodes. */  
import java.io.IOException;  
            removedBytes += s.removedBytes();
    }
     * Returns a combined {@link BlockCacheStats} snapshot aggregated across all registered block caches.
 *   <li>{@link FileCache} — Lucene block-file cache. Always present on warm nodes.</li>
            total += bc.stats().totalBytes();
        }
    /** Returns the {@link FileCache} instance. */
        ForkJoinTask<Void> fileCacheFilesLoadTask = loadFileCacheThreadpool.submit(
            }
     * <p>Block cache counters are folded into the merged overall/block sections so that
        return List.copyOf(blockCaches);
 * @opensearch.experimental
        FileCacheStats mergedBlock = new FileCacheStats(  
            BlockCacheStats s = bc.stats();
     * Called by {@code Node.java} before plugins' {@code createComponents()} so that
    public AggregateFileCacheStats aggregateStats() {
                    + new ByteSizeValue(blockCacheBytes)
import java.util.List;
            evictions += s.evictions();
package org.opensearch.index.store.remote.filecache;
                tiered = bc.tieredStats();
        }  
        }  
        long evictions = 0, evictionBytes = 0, removed = 0, removedBytes = 0;
import org.opensearch.env.NodeEnvironment;
    private final List<BlockCache> blockCaches = new CopyOnWriteArrayList<>();
        );  
        fileCacheNodePath.fileCacheReservedSize = new ByteSizeValue(fileCacheBytes, ByteSizeUnit.BYTES);  
import org.opensearch.common.annotation.ExperimentalApi;
 * <p>Owns the lifecycle, disk budget, validation, and stats aggregation for:
        );
    }
        long total = 0;  
    public static long computeTotalBudgetBytes(Settings settings, NodeEnvironment nodeEnvironment) {  
    /**  
        for (BlockCache bc : blockCaches) {
        if (org.opensearch.cluster.node.DiscoveryNode.isDedicatedWarmNode(settings)) {
    @Override
            mergedOverall,
                    + new ByteSizeValue(fileCacheBytes)
     * Used by {@code _nodes/stats/file_cache?detailed} to return FileCache-only stats.
            Node.CustomForkJoinWorkerThread::new,
     */
            throw new SettingsException(
 * Single authority for all warm-node SSD caches on this node.  
                merged.getEvicted().getBytes(),
            RatioValue ratioValue = RatioValue.parseRatioValue(capacityRaw);
        return providers.values().stream().mapToLong(p -> p.requestedCapacityBytes(settings, totalBudgetBytes)).sum();
            .mapToLong(p -> Math.round(p.requestedCapacityBytes(settings, totalBudgetBytes) * p.dataToCapacityRatio(settings)))
            used += s.memoryBytesUsed() + s.diskBytesUsed();
     */  
            IOUtils.closeWhileHandlingException(blockCaches);
    // ─────────────────────────────────────────────────────────────────────────
import org.opensearch.OpenSearchParseException;
        if (blockCache == null) return;
                merged.getCacheHits(),
    public List<BlockCache> blockCaches() {  
     *
            throw new SettingsException(
            );
    }
    /** Returns a snapshot of all registered block caches. */
                new FileCache.LoadTask(fileCacheNodePath.indicesPath, fileCache, exception)  
                    + ", block_cache="  
    }
        // Pre-compute virtual capacity: each plugin's reserved bytes × its amplification ratio.  
            fcBlock.getTotal() + bc.totalBytes(),
     */
    public long cacheUtilizedBytes() {
        return fileCache.fileCacheStats();
        long fileCacheBytes = totalBudgetBytes - blockCacheBytes;
            fc.getCacheHits() + bc.hits(),
            fc.getFullFileCacheStats(),
    /** Package-private for testing — use {@link #create} in production. */
            .sum();  
            removedBytes += s.removedBytes();
    // ─────────────────────────────────────────────────────────────────────────
        );
            removed += s.removed();  
     * Uses CopyOnWriteArrayList so reads (stats aggregation on every _nodes/stats call)
        );  
 * compatible open source license.
import org.opensearch.plugins.BlockCacheTieredStats;  
        for (BlockCacheProvider provider : providers.values()) {  
        try {
        }
            diskUsed,
     * Computes the virtual data bytes that all block caches can serve, accounting
     * Pre-computed virtual bytes that all registered block-cache plugins can serve.
import org.opensearch.common.unit.RatioValue;
