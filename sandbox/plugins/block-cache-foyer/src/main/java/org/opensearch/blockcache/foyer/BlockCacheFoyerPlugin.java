import java.util.Optional;
            super.close();
     * @param settings         node settings
            diskDir = System.getProperty("java.io.tmpdir") + "/" + DEFAULT_DISK_DIR_NAME;
            throw new SettingsException(
 */
    public Optional<BlockCache> getBlockCache() {
        }
 *   <li>{@code block_cache.size} — fraction of the warm-cache SSD budget given to Foyer.</li>
        }
            if (c != null) {
            );
            FoyerBlockCacheSettings.KEY_INDEX_PERSIST_INTERVAL_SETTING,
import java.util.function.Supplier;
 * </ul>
    // ─── Plugin.getSettings ───────────────────────────────────────────────────
        return List.of(
     * Reports the SSD bytes requested by this plugin from the total warm-cache budget.
    public List<Setting<?>> getSettings() {
        );
        }
 * @opensearch.experimental
import org.opensearch.core.xcontent.NamedXContentRegistry;
                );
import org.opensearch.common.settings.SettingsException;
                    dataDiskDir,
                c.close();
    }
                    dataDiskDir,
                    ioEngine,
                    bufferPoolSizeBytes,
                    blockSizeBytes,
                    diskDir,
                    sweepThresholdRatio,
            FoyerBlockCacheSettings.CACHE_SIZE_SETTING,
                logger.info(
            );
                    metaBlockSizeBytes,
        final double sweepThresholdRatio = FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING.get(settings);
import org.opensearch.common.settings.Settings;
     * ({@code block_cache.foyer.block_size}, {@code block_cache.foyer.io_engine},
                    submitQueueSizeThresholdBytes,
                    metaBlockSizeBytes,
        if (!FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)) {
     * <p>Reads from {@code cluster.filecache.remote_data_ratio} — the same setting
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
     *
    @Override
    /**
                logger.info("BlockCacheFoyerPlugin closed");
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            throw new IllegalStateException("Failed to initialise Foyer block cache (diskDir=" + diskDir + ")", t);
 * <p>Implements {@link BlockCacheProvider} so core can discover this plugin via
import java.util.Collection;
        if (componentsCreated.compareAndSet(false, true) == false) {
    public double dataToCapacityRatio(Settings settings) {
                logger.info(
                    metaDiskDir,
        final NamedWriteableRegistry namedWriteableRegistry,
    @Override
    public BlockCacheFoyerPlugin(final Settings settings) {}
        final NodeEnvironment nodeEnvironment,
                newInterval -> finalCache.updatePersistInterval(newInterval)
    @Override
            .addSettingsUpdateConsumer(FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING, finalCache::updateSweepThreshold);
        final Supplier<RepositoriesService> repositoriesServiceSupplier
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.watcher.ResourceWatcherService;
import org.opensearch.plugins.Plugin;
    }
    ) {
    public void setReservedCapacityBytes(long bytes) {
     * so that the file cache and block cache always use a consistent ratio.
        } finally {
        }
import java.util.concurrent.atomic.AtomicBoolean;
    private final AtomicBoolean componentsCreated = new AtomicBoolean(false);
        if (diskCapacityBytes <= 0) {
    // ─── BlockCacheProvider ───────────────────────────────────────────────────
package org.opensearch.blockcache.foyer;
                    metaDiskDir,
 * The OpenSearch Contributors require contributions made to
        final NamedXContentRegistry xContentRegistry,
 *
                    + " bytes). Reduce block_cache.foyer.block_size or increase node.search.cache.size."
        return List.of(cache);
                    persistIntervalSecs
     * used by the file cache — so both caches use a consistent ratio on the warm node.
        }
 *   <li>{@code block_cache.io_engine} — Foyer I/O engine (auto / io_uring / psync).</li>
                );
                    blockSizeBytes,
     * It is read from the server-side setting {@code cluster.filecache.remote_data_ratio}
                    + blockSizeBytes
 *   <li>{@code block_cache.block_size} — Foyer disk block size.</li>
 * SPDX-License-Identifier: Apache-2.0
                    ioEngine,
        final long persistIntervalSecs = FoyerBlockCacheSettings.KEY_INDEX_PERSIST_INTERVAL_SETTING.get(settings);
     * Includes {@code block_cache.foyer.size} (capacity fraction) and Foyer-internal settings
                    submitQueueSizeThresholdBytes,
                final long metaDiskBytes = Math.round(diskCapacityBytes * metadataCacheRatio);
            FoyerBlockCacheSettings.KEY_INDEX_SWEEP_THRESHOLD_SETTING,
import org.opensearch.plugins.BlockCacheConstants;
 * <p>All Foyer settings are owned here and registered via {@link #getSettings()}:
    @Override
        final long submitQueueSizeThresholdBytes = FoyerBlockCacheSettings.SUBMIT_QUEUE_SIZE_THRESHOLD_SETTING.get(settings).getBytes();
     * The removed plugin-specific setting {@code block_cache.foyer.data_to_cache_ratio}
            );
                    blockSizeBytes,
import org.opensearch.script.ScriptService;
        final Client client,
import org.opensearch.plugins.BlockCacheProvider;
        RatioValue ratio = RatioValue.parseRatioValue(cacheSizeRaw);
    @Override
    }
    }
                "block_cache.foyer.block_size ("
                    sweepThresholdRatio,
        final String ioEngine = FoyerBlockCacheSettings.IO_ENGINE_SETTING.get(settings);
import org.apache.logging.log4j.LogManager;
        this.reservedCapacityBytes = bytes;
        final Environment environment,
     * @param totalBudgetBytes total warm-cache SSD budget
                    "BlockCacheFoyerPlugin created FoyerBlockCache (diskDir={}, blockSize={}, ioEngine={}, "
    }
 *
                cache = new FoyerBlockCache(
                    diskCapacityBytes,
    public long requestedCapacityBytes(Settings settings, long totalBudgetBytes) {
        // Live-update consumers for Dynamic settings.
        // Use the exact capacity reserved by NodeCacheService during budget phase.
                    blockSizeBytes,
            .addSettingsUpdateConsumer(
                    "BlockCacheFoyerPlugin created tiered FoyerBlockCache (dataDir={}, metaDir={}, "
     * Returns the data-to-cache amplification ratio for this plugin's block cache.
        final String diskDir;
 * <ul>
import java.util.List;
     * @return bytes requested; 0 if the block cache is disabled (size = 0%)
            final FoyerBlockCache c = cache;
     * Registers Foyer-specific settings with the OpenSearch settings framework.
                    bufferPoolSizeBytes,
 * Plugin entry point for the Foyer-backed node-level block cache.
    private static final Logger logger = LogManager.getLogger(BlockCacheFoyerPlugin.class);
                    dataDiskBytes,
/*
                    + diskCapacityBytes
    /**
                    ioEngine,
                    persistIntervalSecs
                cache = new FoyerBlockCache(
                final String dataDiskDir = diskDir + "/data";
    /**
    }
        clusterService.getClusterSettings()
            FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING,
            } else {
        }
                    sweepThresholdRatio == 0.0 ? "always-sweep (no threshold)" : sweepThresholdRatio,
        clusterService.getClusterSettings()
    private volatile long reservedCapacityBytes;
 *
            if (metadataCacheRatio > 0.0) {
 *
    private static final String DEFAULT_DISK_DIR_NAME = "foyer-block-cache";
public class BlockCacheFoyerPlugin extends Plugin implements BlockCacheProvider {
    @Override
                        + "dataDisk={}, metaDisk={}, dataBlockSize={}, metaBlockSize={}, ioEngine={})",
        final long sweepIntervalSecs = FoyerBlockCacheSettings.KEY_INDEX_SWEEP_INTERVAL_SETTING.get(settings);
     * {@code block_cache.foyer.key_index_sweep_threshold}).
            return List.of();
/**
        final long metaBlockSizeBytes = FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING.get(settings).getBytes();
    /** Settings constructor required by the plugin framework. */
import org.opensearch.env.NodeEnvironment;
            logger.info("BlockCacheFoyerPlugin: pluggable.dataformat disabled, Foyer block cache not initialised");
        }
                    dataDiskBytes,
                    diskDir,
 * this file be licensed under the Apache-2.0 license or a
        } catch (final Throwable t) {
        final ClusterService clusterService,
     */
     *
                );
                final long dataDiskBytes = diskCapacityBytes - metaDiskBytes;
                );
    }
            FoyerBlockCacheSettings.SUBMIT_QUEUE_SIZE_THRESHOLD_SETTING,
            diskDir = environment.dataFiles()[0].resolve(DEFAULT_DISK_DIR_NAME).toString();
                final String metaDiskDir = diskDir + "/metadata";
    public void close() throws IOException {
     * <p>Note: the data-to-cache amplification ratio is NOT registered here.
        return BlockCacheConstants.FOYER;
                    sweepIntervalSecs == 0 ? "disabled" : sweepIntervalSecs + "s",
    private volatile FoyerBlockCache cache;
        final String metadataCacheRatioRaw = FoyerBlockCacheSettings.METADATA_CACHE_RATIO_SETTING.get(settings);
            }
import java.io.IOException;
                    sweepIntervalSecs,
                    submitQueueSizeThresholdBytes,
     * was redundant; operators should use {@code cluster.filecache.remote_data_ratio} instead.
            return List.of();
        return Math.round(totalBudgetBytes * ratio.getAsRatio());
     * {@code block_cache.foyer.key_index_sweep_interval_seconds},
    public Collection<Object> createComponents(
        clusterService.getClusterSettings()
        String cacheSizeRaw = FoyerBlockCacheSettings.CACHE_SIZE_SETTING.get(settings);
 * {@code pluginsService.filterPlugins(BlockCacheProvider.class)}.
                    bufferPoolSizeBytes,
                    metaDiskBytes,
            FoyerBlockCacheSettings.KEY_INDEX_SWEEP_INTERVAL_SETTING,
                    + " bytes) must be smaller than the Foyer disk budget ("
            FoyerBlockCacheSettings.BLOCK_SIZE_SETTING,
 * compatible open source license.
        final ThreadPool threadPool,
        return FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.get(settings);
            FoyerBlockCacheSettings.METADATA_BLOCK_SIZE_SETTING
     */
                    persistIntervalSecs == 0 ? "disabled" : persistIntervalSecs + "s"
    public String cacheName() {
            logger.info("BlockCacheFoyerPlugin: block_cache.size=0, Foyer block cache disabled");
import org.opensearch.env.Environment;
    @Override
     */
            throw new IllegalStateException("BlockCacheFoyerPlugin.createComponents called more than once");
import org.opensearch.cluster.service.ClusterService;
            .addSettingsUpdateConsumer(
        final double metadataCacheRatio = RatioValue.parseRatioValue(metadataCacheRatioRaw).getAsRatio();
                newInterval -> finalCache.updateSweepInterval(newInterval)
            return 0L;
 */
        final FoyerBlockCache finalCache = cache;
                FoyerBlockCacheSettings.KEY_INDEX_SWEEP_INTERVAL_SETTING,
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
            }
            FoyerBlockCacheSettings.IO_ENGINE_SETTING,
     *
        final long blockSizeBytes = FoyerBlockCacheSettings.BLOCK_SIZE_SETTING.get(settings).getBytes();
import org.opensearch.plugins.BlockCache;
        }
import org.opensearch.common.settings.Setting;
    @Override
                    ioEngine
        return Optional.ofNullable(cache);
    // ─── Plugin lifecycle ─────────────────────────────────────────────────────
     * Close the cache. Idempotent; safe to call multiple times.
        try {
        final long bufferPoolSizeBytes = FoyerBlockCacheSettings.BUFFER_POOL_SIZE_SETTING.get(settings).getBytes();
        if (environment.dataFiles().length == 0) {
        final ScriptService scriptService,
                        + "sweepIntervalSecs={}, sweepThresholdRatio={}, persistIntervalSecs={})",
        final long diskCapacityBytes = reservedCapacityBytes;
}
    /**
            FoyerBlockCacheSettings.BUFFER_POOL_SIZE_SETTING,
        final Settings settings = clusterService.getSettings();
        final ResourceWatcherService resourceWatcherService,
import org.apache.logging.log4j.Logger;
     */
                    metaDiskBytes,
import org.opensearch.transport.client.Client;
import org.opensearch.repositories.RepositoriesService;
        } else {
        if (blockSizeBytes >= diskCapacityBytes) {
import org.opensearch.common.util.FeatureFlags;
        final IndexNameExpressionResolver indexNameExpressionResolver,
                    sweepIntervalSecs,
import org.opensearch.common.unit.RatioValue;
                FoyerBlockCacheSettings.KEY_INDEX_PERSIST_INTERVAL_SETTING,
        if (!FeatureFlags.isEnabled(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)) {
        try {
        // block_size must be strictly less than the total disk capacity.
