import org.opensearch.core.common.unit.ByteSizeValue;
     */  
     */
     * <p>The persist task is decoupled from the sweep task so that persist frequency
     * byte allocation scales automatically with the instance's SSD capacity.
 * compatible open source license.
     * Block size for the Foyer disk tier.  
     *
    );
     *   <li>{@code psync} (default) — synchronous pread/pwrite. Portable across  
    public static final Setting<Long> KEY_INDEX_PERSIST_INTERVAL_SETTING = Setting.longSetting(
    );
        Setting.Property.Dynamic
            } catch (Exception e) {  
    /**
     * block_cache.foyer.key_index_persist_interval_seconds: 60
 * SPDX-License-Identifier: Apache-2.0
 *
     * Block size for the metadata cache's Foyer disk tier.
     *       syscall-level behaviour.</li>
     * <p>{@code 0} = disabled — the key_index is only persisted on graceful shutdown  
 *
    public static final Setting<String> METADATA_CACHE_RATIO_SETTING = new Setting<>(
        0L,    // min: 0  
        new ByteSizeValue(1024, ByteSizeUnit.MB),
            );
                    throw new IllegalArgumentException("[block_cache.foyer.metadata_cache_ratio] must be in [0%, 50%); got: " + value);  
        new ByteSizeValue(16, ByteSizeUnit.MB),
    /**  
    /**  
        Setting.Property.NodeScope
     * Set to {@code 0.0} to disable the threshold guard and always sweep.
            return value;
     * }</pre>
     *
     * <p>Default: 128&nbsp;MB. Range: [1&nbsp;MB, 512&nbsp;MB].  
     */  
        }  
 */  
        0L,    // 0 = disabled (no sweep task spawned)
     *  
    public static final Setting<ByteSizeValue> SUBMIT_QUEUE_SIZE_THRESHOLD_SETTING = Setting.byteSizeSetting(  
     */
     * not changed since the last successful write, the tick is skipped (no disk I/O).  
     *
            if (ratio.getAsRatio() < 0 || ratio.getAsRatio() >= 1.0) {
        Setting.Property.NodeScope  
        new ByteSizeValue(1, ByteSizeUnit.MB),
 * <p>All settings are namespaced under {@code block_cache.foyer.*} to distinguish
    );
    public static final Setting<ByteSizeValue> BUFFER_POOL_SIZE_SETTING = Setting.byteSizeSetting(
    public static final Setting<String> CACHE_SIZE_SETTING = new Setting<>("block_cache.foyer.size", "50%", value -> {
     * Fraction of the total Foyer disk budget allocated to the metadata cache.  
     */
package org.opensearch.blockcache.foyer;
            }
     *
                );
     *  
        "block_cache.foyer.block_size",  
                    "[block_cache.foyer.metadata_cache_ratio] must be a percentage (e.g. 5%) or ratio (e.g. 0.05); got: " + value,
     * }</pre>  
      * {@code block_cache.foyer.size=50%} → Foyer gets 400&nbsp;GB, FileCache gets 400&nbsp;GB.
        0.0,  // min: 0.0 (explicit 0 = always sweep)
     *
        Setting.Property.Dynamic  
/**  
        new ByteSizeValue(512, ByteSizeUnit.MB),
     * <p>Example: 1&nbsp;TB SSD, {@code node.search.cache.size=80%} (800&nbsp;GB budget),  
                }
     * A smaller block size than the data cache avoids wasting SSD space on internal
        Setting.Property.NodeScope,
        3600L, // max: 1 hour  
     *  
     * block_cache.foyer.io_engine: psync  
 *
        "5%",
     *  
    public static final Setting<Double> KEY_INDEX_SWEEP_THRESHOLD_SETTING = Setting.doubleSetting(
        new ByteSizeValue(8, ByteSizeUnit.MB),  
     * locks are acquired and no shard is iterated. This avoids wasting CPU cycles when
    );
            throw new IllegalArgumentException("[block_cache.foyer.io_engine] must be one of: auto, io_uring, psync; got: " + value);
                RatioValue ratio = RatioValue.parseRatioValue(value);
 * <p>{@code block_cache.foyer.size} is owned here because the Foyer plugin is
    }, Setting.Property.NodeScope);  
     * }</pre>  
        new ByteSizeValue(128, ByteSizeUnit.MB),  
        Setting.Property.NodeScope,  
        "block_cache.foyer.metadata_block_size",
            RatioValue ratio = RatioValue.parseRatioValue(value);
    );  
        new ByteSizeValue(256, ByteSizeUnit.MB),
        "block_cache.foyer.buffer_pool_size",
     * Minimum {@code used_bytes / disk_bytes} ratio required to run the key_index sweep.
        60L,   // default: 60 seconds
     *
     *
     * <p>Default: {@code 60} seconds. Range: [0, 3600].
     *       or AppArmor in locked-down container environments).</li>
    );
        value -> {
     *
 * plugins (e.g. {@code block_cache.caffeine.*}).  
     * Fraction of the total warm-cache SSD budget allocated to the Foyer block cache.  
        "block_cache.foyer.submit_queue_size_threshold",
     * <p>Default: {@code 0.70} — skip the sweep when the cache is less than 70% full.  
        new ByteSizeValue(512, ByteSizeUnit.MB),  
        new ByteSizeValue(128, ByteSizeUnit.MB),
 * {@link BlockCacheFoyerPlugin#requestedCapacityBytes(org.opensearch.common.settings.Settings, long)}.
        "block_cache.foyer.key_index_persist_interval_seconds",  
     * <p>Default: {@code 50%}. Set to {@code 0%} to disable the block cache.  
    /**
 * Foyer-specific settings for the node-level block cache.
     *
    );  
     *
import org.opensearch.core.common.unit.ByteSizeUnit;
     * <p>Configure in {@code opensearch.yml}:
     * anything.
     * data-only cache). Accepts a percentage (e.g. {@code 5%}) or a ratio (e.g. {@code 0.05}).  
        if (!Set.of("auto", "io_uring", "psync").contains(value)) {
        Setting.Property.Dynamic
     * can be up to 128&nbsp;MB. A block size smaller than an entry causes a silent  
    private FoyerBlockCacheSettings() {}  
    /**
import org.opensearch.common.annotation.ExperimentalApi;
     * How often (seconds) the independent persist task flushes the key_index to disk.
        return value;
            throw new IllegalArgumentException(
     * &ge; {@code block_size} so the flusher can accumulate a full block. Entries
                    e  
    public static final Setting<ByteSizeValue> BLOCK_SIZE_SETTING = Setting.byteSizeSetting(
        0.70, // default: skip sweep when cache < 70% full  
     * <p>Default: 8&nbsp;MB. Range: [1&nbsp;MB, 128&nbsp;MB].
     *
     */
            try {  
     * fragmentation for these small entries.  
                if (ratio.getAsRatio() < 0 || ratio.getAsRatio() >= 0.5) {
     *
 * @opensearch.experimental  
     * <p>Maximum total bytes allowed to be pending in the flusher queue. When  
        Setting.Property.NodeScope
     * can be tuned independently.  
     * Range: [0, 3600]. Configure via {@code block_cache.foyer.key_index_sweep_interval_seconds}.
     * via the {@code Drop} impl (i.e. when the JVM shuts down cleanly). In this mode
     * <pre>{@code  
     * (a cheap file write, default 60 s) and sweep frequency (an expensive DashMap scan)
        } catch (Exception e) {  
     * This means idle caches produce zero I/O even if the interval is short.
     * </ul>
 */
import org.opensearch.common.settings.Setting;
     *
        1.0,  // max: 1.0
        }
     */  
                e  
     * block_cache.foyer.key_index_sweep_threshold: 0.75
     * Total buffer pool size for the Foyer flusher.
import org.opensearch.common.unit.RatioValue;  
import java.util.Set;
    /**
        "block_cache.foyer.key_index_sweep_threshold",
     * <p>On each interval tick the sweep loop checks whether the current usage ratio is  
     * of SSD on warm nodes). This setting is applied against that budget, so the actual  
     * <p>Configure in {@code opensearch.yml}:  
    public static final Setting<Long> KEY_INDEX_SWEEP_INTERVAL_SETTING = Setting.longSetting(  
     * <p>Configure in {@code opensearch.yml}:  
        new ByteSizeValue(1, ByteSizeUnit.MB),
     * <p>The task uses {@code used_bytes} as a change signal: if {@code used_bytes} has
     * larger than this buffer are silently dropped.  
 *
            }
     * <p>Must be &ge; the largest entry ever put into the cache. Parquet row groups
                return value;
     * <p>Configure in {@code opensearch.yml}:
                throw new IllegalArgumentException(
     *  
 * this file be licensed under the Apache-2.0 license or a
                "[block_cache.foyer.size] must be a percentage (e.g. 25%) or ratio (e.g. 0.25); got: " + value,
 * them from settings that might be registered by other {@code BlockCacheProvider}
    /**
     * <p>The remaining {@code (1 - ratio)} goes to the data cache. Applied against the
     * Submit queue size threshold for the Foyer block engine.
     *       Fails at startup if io_uring is unavailable (e.g. blocked by seccomp  
    }, Setting.Property.NodeScope);
        0L,    // min: 0 (0 = disabled, persist only on graceful shutdown)
     * <ul>
     *   <li>{@code io_uring} — force io_uring regardless of kernel detection.
     * drop — the put succeeds but the entry is not stored, resulting in a cache miss.
public final class FoyerBlockCacheSettings {  
     * Accepts a percentage (e.g. {@code 50%}) or a ratio (e.g. {@code 0.50}).
     */
     *       psync otherwise.</li>
     * exceeded, new entries are silently dropped instead of being written to disk.
        new ByteSizeValue(128, ByteSizeUnit.MB),
 * responsible for reporting its requested capacity to core via  
        "block_cache.foyer.key_index_sweep_interval_seconds",
     * <pre>{@code
     * <p>Default: 128&nbsp;MB. Range: [16&nbsp;MB, 512&nbsp;MB].
 * <p>These settings are consumed only by {@link BlockCacheFoyerPlugin} and are  
     *
    public static final Setting<String> IO_ENGINE_SETTING = new Setting<>("block_cache.foyer.io_engine", "psync", value -> {  
        },  
     * <p>Default: {@code 5%}. Set to {@code 0%} to disable tiered caching (single
        Setting.Property.NodeScope  
    /**
     * strictly below this threshold. If so, the sweep is skipped (no-op) — no DashMap
     *
     *
                throw new IllegalArgumentException("[block_cache.foyer.size] must be in [0%, 100%); got: " + value);  
     * by Foyer's disk reclaimer. {@code 0} = disabled (no background sweep task is spawned).  
        try {  
     * How often (seconds) the background sweeper prunes stale key_index entries left
     *
    );
     * <p>Example: 400&nbsp;GB Foyer budget, {@code metadata_cache_ratio=5%} →
     *
     * <p>Default: 256&nbsp;MB. Range: [16&nbsp;MB, 1024&nbsp;MB].
 * to server-side components.
     * metadata cache gets 20&nbsp;GB, data cache gets 380&nbsp;GB.  
/*  
     * block_cache.foyer.size: 50%
     * the maximum durability window after a crash equals the node uptime since startup.
@ExperimentalApi
     * Should be &ge; 2&times; {@code buffer_pool_size} to absorb write bursts.
 * The OpenSearch Contributors require contributions made to  
    /**
     * more than half the SSD budget.  
     * <p>Range: [0%, 50%). Values &ge; 50% are rejected — metadata should never consume
    public static final Setting<ByteSizeValue> METADATA_BLOCK_SIZE_SETTING = Setting.byteSizeSetting(
     *  
     */
     * <p>The total budget is defined by {@code node.search.cache.size} (default: 80%
     * <p>Metadata entries (page indexes, offset indexes) are typically small (KB–MB range).
     *
     * total Foyer disk bytes computed from {@code block_cache.foyer.size}.  
     * the cache is lightly loaded and Foyer's disk reclaimer is unlikely to have evicted  
     * <p>The flusher stages entries in this buffer before writing to disk. Must be
     *       all kernels and container sandboxes, and gives predictable
        new ByteSizeValue(16, ByteSizeUnit.MB),  
        "block_cache.foyer.metadata_cache_ratio",  
     * }</pre>
        Setting.Property.NodeScope
     *
     *
    /**
 * registered via {@link BlockCacheFoyerPlugin#getSettings()}. They are not visible
 *  
     * I/O engine for the Foyer disk tier.  
        Setting.Property.NodeScope,
     */
        3600L, // max: 1 hour
     * <pre>{@code
}
     * <pre>{@code
     *   <li>{@code auto} — selects io_uring on Linux &ge;&nbsp;5.1, falls back to  
     * <p>Range: {@code [0.0, 1.0]}.  
