                    diskDir,
                c.close();
    /**
                final long dataDiskBytes = diskCapacityBytes - metaDiskBytes;
            logger.info("BlockCacheFoyerPlugin: block_cache.size=0, Foyer block cache disabled");
    public List<Setting<?>> getSettings() {
        final ScriptService scriptService,  
                    metaDiskBytes,
import java.io.IOException;
            throw new SettingsException(
 * Plugin entry point for the Foyer-backed node-level block cache.  
import org.apache.logging.log4j.Logger;
        }
import org.opensearch.common.util.FeatureFlags;  
import org.opensearch.script.ScriptService;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                "block_cache.foyer.block_size ("  
     * Returns the data-to-cache amplification ratio for this plugin's block cache.  
     */  
 *   <li>{@code block_cache.size} — fraction of the warm-cache SSD budget given to Foyer.</li>
                    blockSizeBytes,
     * used by the file cache — so both caches use a consistent ratio on the warm node.  
     *
     * was redundant; operators should use {@code cluster.filecache.remote_data_ratio} instead.
    /**
                    ioEngine,  
     * Includes {@code block_cache.foyer.size} (capacity fraction) and Foyer-internal settings
     * @param settings         node settings
        final String ioEngine = FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(settings);
                        + "dataDisk={}, metaDisk={}, dataBlockSize={}, metaBlockSize={}, ioEngine={})",
 *   <li>{@code block_cache.block_size} — Foyer disk block size.</li>
    public Optional<BlockCache> getBlockCache() {
                logger.info("BlockCacheFoyerPlugin closed");  
            FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING,
                final long metaDiskBytes = Math.round(diskCapacityBytes * metadataCacheRatio);
    public void setReservedCapacityBytes(long bytes) {  
            );
        // Live-update consumers for Dynamic settings.
                    sweepIntervalSecs == 0 ? "disabled" : sweepIntervalSecs + "s",
                    ioEngine,
    private volatile long reservedCapacityBytes;
    private static final String DEFAULT_DISK_DIR_NAME = "foyer-block-cache";  
        return BlockCacheConstants.FOYER;
                newInterval -> finalCache.updateSweepInterval(newInterval)  
import org.opensearch.plugins.Plugin;  
            FoyerBlockCacheSettings.CACHE_SIZE_SETTING,
        final long diskCapacityBytes = reservedCapacityBytes;
            }  
import org.opensearch.repositories.RepositoriesService;
        final Settings settings = clusterService.getSettings();  
            FoyerBlockCacheSettings.BLOCK_SIZE_SETTING,
    @Override
    /**
        final Environment environment,
                    "BlockCacheFoyerPlugin created tiered FoyerBlockCache (dataDir={}, metaDir={}, "
        final ClusterService clusterService,  
public class BlockCacheFoyerPlugin extends Plugin implements BlockCacheProvider {
        final NamedXContentRegistry xContentRegistry,
     * Close the cache. Idempotent; safe to call multiple times.
 * <p>Implements {@link BlockCacheProvider} so core can discover this plugin via
                        + "sweepIntervalSecs={}, sweepThresholdRatio={}, persistIntervalSecs={})",
        try {
        final NamedWriteableRegistry namedWriteableRegistry,
            );  
        if (!FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)) {
                    persistIntervalSecs
import java.util.Collection;
            .addSettingsUpdateConsumer(
import java.util.List;  
 *
     * ({@code block_cache.foyer.block_size}, {@code block_cache.foyer.io_engine},
     */  
    @Override
                    + diskCapacityBytes  
}
                    + blockSizeBytes
            return List.of();  
     * <p>Reads from {@code cluster.filecache.remote_data_ratio} — the same setting
                    bufferPoolSizeBytes,
    @Override
 * <p>All Foyer settings are owned here and registered via {@link #getSettings()}:
import org.opensearch.common.unit.RatioValue;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        final double metadataCacheRatio = RatioValue.parseRatioValue(metadataCacheRatioRaw).getAsRatio();
                FoyerBlockCacheSettings.KEY_INDEX_SWEEP_INTERVAL_SETTING,
    @Override
        final double sweepThresholdRatio = FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(settings);
        final ResourceWatcherService resourceWatcherService,
                    metaBlockSizeBytes,
        RatioValue ratio = RatioValue.parseRatioValue(cacheSizeRaw);  
                    blockSizeBytes,  
    public BlockCacheFoyerPlugin(final Settings settings) {}
            logger.info("BlockCacheFoyerPlugin: pluggable.dataformat disabled, Foyer block cache not initialised");
    }
        final FoyerBlockCache finalCache = cache;  
    }
                cache = new FoyerBlockCache(
        return Optional.ofNullable(cache);  
                    metaDiskDir,
                    diskCapacityBytes,
                    metaBlockSizeBytes,
                    sweepIntervalSecs,
                    bufferPoolSizeBytes,  
        // block_size must be strictly less than the total disk capacity.  
                    ioEngine,
                );
        final IndexNameExpressionResolver indexNameExpressionResolver,
                );
     * {@code block_cache.foyer.key_index_sweep_threshold}).
        return List.of(cache);
                    submitQueueSizeThresholdBytes,
        final ThreadPool threadPool,
                    sweepThresholdRatio,
        return List.of(  
        } else {  
import org.opensearch.plugins.BlockCache;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            } else {
        final String metadataCacheRatioRaw = FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(settings);
 */
            );
        if (!FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)) {
 *
        }
            FoyerBlockCacheSettings.KEY_INDEX_SWEEP_INTERVAL_SETTING,  
    @Override  
 * {@code pluginsService.filterPlugins(BlockCacheProvider.class)}.  
        if (environment.dataFiles().length == 0) {
    // ─── Plugin lifecycle ─────────────────────────────────────────────────────
 */  
    public long requestedCapacityBytes(Settings settings, long totalBudgetBytes) {
        } catch (final Throwable t) {
            .addSettingsUpdateConsumer(  
import org.opensearch.common.settings.Setting;
            if (metadataCacheRatio > 0.0) {  
    @Override
            FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING
import org.opensearch.env.NodeEnvironment;
                    + " bytes) must be smaller than the Foyer disk budget ("
                    persistIntervalSecs == 0 ? "disabled" : persistIntervalSecs + "s"
     *
 * <ul>  
/*  
     * @param totalBudgetBytes total warm-cache SSD budget  
        if (componentsCreated.compareAndSet(false, true) == false) {
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
                    dataDiskBytes,  
                cache = new FoyerBlockCache(  
import org.opensearch.transport.client.Client;
    }
    }  
            .addSettingsUpdateConsumer(FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING, finalCache::updateSweepThreshold);
    private volatile FoyerBlockCache cache;  
        final NodeEnvironment nodeEnvironment,  
                );
    public void close() throws IOException {
        clusterService.getClusterSettings()  
                    sweepThresholdRatio == 0.0 ? "always-sweep (no threshold)" : sweepThresholdRatio,  
import java.util.concurrent.atomic.AtomicBoolean;
 * @opensearch.experimental  
        final long sweepIntervalSecs = FoyerBlockCacheSettings.KEY_INDEX_SWEEP_INTERVAL_SETTING.get(settings);  
    public double dataToCapacityRatio(Settings settings) {
                    dataDiskBytes,
        // Use the exact capacity reserved by NodeCacheService during budget phase.  
 *
                    diskDir,
     * It is read from the server-side setting {@code cluster.filecache.remote_data_ratio}
    }
            return 0L;  
                    submitQueueSizeThresholdBytes,
import org.opensearch.threadpool.ThreadPool;  
        final Client client,
 * </ul>
        }
                );
                newInterval -> finalCache.updatePersistInterval(newInterval)
            throw new IllegalStateException("BlockCacheFoyerPlugin.createComponents called more than once");  
                    + " bytes). Reduce block_cache.foyer.block_size or increase node.search.cache.size."
     */  
        );
    private final AtomicBoolean componentsCreated = new AtomicBoolean(false);
import org.opensearch.common.settings.SettingsException;
            if (c != null) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.BlockCacheProvider;
    public Collection<Object> createComponents(
                FoyerBlockCacheSettings.KEY_INDEX_PERSIST_INTERVAL_SETTING,
        try {  
     * The removed plugin-specific setting {@code block_cache.foyer.data_to_cache_ratio}
     * <p>Note: the data-to-cache amplification ratio is NOT registered here.  
            FoyerBlockCacheSettings.SUBMIT_QUEUE_SIZE_THRESHOLD_SETTING,
import org.opensearch.plugins.BlockCacheConstants;
     */
import org.apache.logging.log4j.LogManager;
        final long submitQueueSizeThresholdBytes = FoyerBlockCacheSettings.SUBMIT_QUEUE_SIZE_THRESHOLD_SETTING.get(settings).getBytes();
                    sweepIntervalSecs,
    @Override  
import org.opensearch.common.settings.Settings;  
        final String diskDir;  
        final Supplier<RepositoriesService> repositoriesServiceSupplier  
    }
 *   <li>{@code block_cache.io_engine} — Foyer I/O engine (auto / io_uring / psync).</li>  
     * Registers Foyer-specific settings with the OpenSearch settings framework.  
                logger.info(
                    ioEngine  
            final FoyerBlockCache c = cache;  
        if (blockSizeBytes >= diskCapacityBytes) {
import org.opensearch.env.Environment;  
                    blockSizeBytes,  
            }
/**
    private static final Logger logger = LogManager.getLogger(BlockCacheFoyerPlugin.class);
                    persistIntervalSecs  
    /** Settings constructor required by the plugin framework. */  
import java.util.function.Supplier;  
            diskDir = System.getProperty("java.io.tmpdir") + "/" + DEFAULT_DISK_DIR_NAME;
        this.reservedCapacityBytes = bytes;
     * Reports the SSD bytes requested by this plugin from the total warm-cache budget.  
 *
     *
import org.opensearch.watcher.ResourceWatcherService;
    /**
    // ─── BlockCacheProvider ───────────────────────────────────────────────────  
 * compatible open source license.
                    bufferPoolSizeBytes,
                    submitQueueSizeThresholdBytes,  
            FoyerBlockCacheSettings.KEY_INDEX_PERSIST_INTERVAL_SETTING,
                    dataDiskDir,  
     * {@code block_cache.foyer.key_index_sweep_interval_seconds},  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
                final String dataDiskDir = diskDir + "/data";  
        clusterService.getClusterSettings()
            diskDir = environment.dataFiles()[0].resolve(DEFAULT_DISK_DIR_NAME).toString();
        }
                    blockSizeBytes,
        String cacheSizeRaw = FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(settings);
            FoyerBlockCacheSettings.BUFFER_POOL_SIZE_SETTING,  
    }  
            FoyerBlockCacheSettings.IO_ENGINE_SETTING,
        return FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.get(settings);  
                final String metaDiskDir = diskDir + "/metadata";
                    sweepThresholdRatio,  
        } finally {
                    dataDiskDir,
        }  
    public String cacheName() {
import org.opensearch.cluster.service.ClusterService;
        }  
    ) {
     * so that the file cache and block cache always use a consistent ratio.
        clusterService.getClusterSettings()
        final long persistIntervalSecs = FoyerBlockCacheSettings.KEY_INDEX_PERSIST_INTERVAL_SETTING.get(settings);
        if (diskCapacityBytes <= 0) {
        }
package org.opensearch.blockcache.foyer;
                    "BlockCacheFoyerPlugin created FoyerBlockCache (diskDir={}, blockSize={}, ioEngine={}, "  
        final long metaBlockSizeBytes = FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(settings).getBytes();  
        final long bufferPoolSizeBytes = FoyerBlockCacheSettings.BUFFER_POOL_SIZE_SETTING.get(settings).getBytes();  
                    metaDiskDir,  
        return Math.round(totalBudgetBytes * ratio.getAsRatio());
    // ─── Plugin.getSettings ───────────────────────────────────────────────────  
            super.close();
import java.util.Optional;
 * The OpenSearch Contributors require contributions made to  
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING,  
            return List.of();  
                logger.info(  
        final long blockSizeBytes = FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(settings).getBytes();
     * @return bytes requested; 0 if the block cache is disabled (size = 0%)
            throw new IllegalStateException("Failed to initialise Foyer block cache (diskDir=" + diskDir + ")", t);
    }  
                    metaDiskBytes,  
        }
