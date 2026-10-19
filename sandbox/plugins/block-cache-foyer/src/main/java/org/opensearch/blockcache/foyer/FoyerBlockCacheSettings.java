     *
     * <p>Example: 1&nbsp;TB SSD, {@code node.search.cache.size=80%} (800&nbsp;GB budget),
    public static final Setting<Long> KEY_INDEX_SWEEP_INTERVAL_SETTING = Setting.longSetting(
     * <p>Default: 8&nbsp;MB. Range: [1&nbsp;MB, 128&nbsp;MB].
            );
     * strictly below this threshold. If so, the sweep is skipped (no-op) — no DashMap
import org.opensearch.core.common.unit.ByteSizeValue;
        Setting.Property.NodeScope
 * <p>These settings are consumed only by {@link BlockCacheFoyerPlugin} and are
     *
            }
 * @opensearch.experimental
     * byte allocation scales automatically with the instance's SSD capacity.
        "5%",
            RatioValue ratio = RatioValue.parseRatioValue(value);
                    throw new IllegalArgumentException("[block_cache.foyer.metadata_cache_ratio] must be in [0%, 50%); got: " + value);
     *       or AppArmor in locked-down container environments).</li>
                    "[block_cache.foyer.metadata_cache_ratio] must be a percentage (e.g. 5%) or ratio (e.g. 0.05); got: " + value,
                e
    public static final Setting<ByteSizeValue> BLOCK_SIZE_SETTING = Setting.byteSizeSetting(
    }, Setting.Property.NodeScope);
                }
     *
 * SPDX-License-Identifier: Apache-2.0
        new ByteSizeValue(16, ByteSizeUnit.MB),
        "block_cache.foyer.submit_queue_size_threshold",
    public static final Setting<String> METADATA_CACHE_RATIO_SETTING = new Setting<>(
     * }</pre>
 * Foyer-specific settings for the node-level block cache.
 * <p>{@code block_cache.foyer.size} is owned here because the Foyer plugin is
 * this file be licensed under the Apache-2.0 license or a
     * total Foyer disk bytes computed from {@code block_cache.foyer.size}.
        }
     *
        "block_cache.foyer.buffer_pool_size",
        0L,    // min: 0
            } catch (Exception e) {
        new ByteSizeValue(256, ByteSizeUnit.MB),
     * the cache is lightly loaded and Foyer's disk reclaimer is unlikely to have evicted
     *   <li>{@code auto} — selects io_uring on Linux &ge;&nbsp;5.1, falls back to
     */
     *       syscall-level behaviour.</li>
        0L,    // 0 = disabled (no sweep task spawned)
     * <p>Must be &ge; the largest entry ever put into the cache. Parquet row groups
     * block_cache.foyer.key_index_persist_interval_seconds: 60
     * more than half the SSD budget.
     * Minimum {@code used_bytes / disk_bytes} ratio required to run the key_index sweep.
        new ByteSizeValue(512, ByteSizeUnit.MB),
        Setting.Property.NodeScope
     * locks are acquired and no shard is iterated. This avoids wasting CPU cycles when
        },
    );
     * </ul>
    /**
     * How often (seconds) the independent persist task flushes the key_index to disk.
        "block_cache.foyer.key_index_persist_interval_seconds",
     */
     */
        } catch (Exception e) {
     * <pre>{@code
                throw new IllegalArgumentException("[block_cache.foyer.size] must be in [0%, 100%); got: " + value);
     *
    );
 */
    public static final Setting<Double> KEY_INDEX_SWEEP_THRESHOLD_SETTING = Setting.doubleSetting(
        "block_cache.foyer.block_size",
        "block_cache.foyer.key_index_sweep_threshold",
        3600L, // max: 1 hour
            throw new IllegalArgumentException("[block_cache.foyer.io_engine] must be one of: auto, io_uring, psync; got: " + value);
     *
     *
     * Submit queue size threshold for the Foyer block engine.
     * This means idle caches produce zero I/O even if the interval is short.
     * not changed since the last successful write, the tick is skipped (no disk I/O).
}
            return value;
     */
     * <p>The remaining {@code (1 - ratio)} goes to the data cache. Applied against the
     *
     * fragmentation for these small entries.
    private FoyerBlockCacheSettings() {}
     * Range: [0, 3600]. Configure via {@code block_cache.foyer.key_index_sweep_interval_seconds}.
     *
import org.opensearch.common.unit.RatioValue;
            throw new IllegalArgumentException(
import org.opensearch.common.annotation.ExperimentalApi;
 * responsible for reporting its requested capacity to core via
    );
                throw new IllegalArgumentException(
 * to server-side components.
 * them from settings that might be registered by other {@code BlockCacheProvider}
     *
        0L,    // min: 0 (0 = disabled, persist only on graceful shutdown)
     * <p>Default: {@code 50%}. Set to {@code 0%} to disable the block cache.
     * by Foyer's disk reclaimer. {@code 0} = disabled (no background sweep task is spawned).
import org.opensearch.core.common.unit.ByteSizeUnit;
        new ByteSizeValue(16, ByteSizeUnit.MB),
        0.70, // default: skip sweep when cache < 70% full
        0.0,  // min: 0.0 (explicit 0 = always sweep)
     */
     * I/O engine for the Foyer disk tier.
    /**
        Setting.Property.Dynamic
    public static final Setting<String> IO_ENGINE_SETTING = new Setting<>("block_cache.foyer.io_engine", "psync", value -> {
        "block_cache.foyer.metadata_block_size",
        Setting.Property.NodeScope
/*
 * registered via {@link BlockCacheFoyerPlugin#getSettings()}. They are not visible
        Setting.Property.NodeScope,
     * anything.
@ExperimentalApi
 */
                "[block_cache.foyer.size] must be a percentage (e.g. 25%) or ratio (e.g. 0.25); got: " + value,
     * <p>Default: {@code 0.70} — skip the sweep when the cache is less than 70% full.
     *
        Setting.Property.NodeScope,
     */
        Setting.Property.NodeScope,
     *
     * <p>Default: {@code 5%}. Set to {@code 0%} to disable tiered caching (single
        new ByteSizeValue(1024, ByteSizeUnit.MB),
    /**
public final class FoyerBlockCacheSettings {
     * <p>Example: 400&nbsp;GB Foyer budget, {@code metadata_cache_ratio=5%} →
     *
     *       Fails at startup if io_uring is unavailable (e.g. blocked by seccomp
     *
     *
        60L,   // default: 60 seconds
     * }</pre>
     *   <li>{@code psync} (default) — synchronous pread/pwrite. Portable across
                RatioValue ratio = RatioValue.parseRatioValue(value);
     * <p>Default: 128&nbsp;MB. Range: [1&nbsp;MB, 512&nbsp;MB].
        Setting.Property.NodeScope
     *       psync otherwise.</li>
     * <p>Configure in {@code opensearch.yml}:
    public static final Setting<ByteSizeValue> BUFFER_POOL_SIZE_SETTING = Setting.byteSizeSetting(
     *
package org.opensearch.blockcache.foyer;
            }
        if (!Set.of("auto", "io_uring", "psync").contains(value)) {
     * <p>On each interval tick the sweep loop checks whether the current usage ratio is
        new ByteSizeValue(1, ByteSizeUnit.MB),
     * &ge; {@code block_size} so the flusher can accumulate a full block. Entries
     * can be tuned independently.
     *
     *
     * <p>Range: [0%, 50%). Values &ge; 50% are rejected — metadata should never consume
    public static final Setting<Long> KEY_INDEX_PERSIST_INTERVAL_SETTING = Setting.longSetting(
     *   <li>{@code io_uring} — force io_uring regardless of kernel detection.
    );
     * <ul>
     * <p>Configure in {@code opensearch.yml}:
     * <p>Default: {@code 60} seconds. Range: [0, 3600].
 *
/**
    public static final Setting<ByteSizeValue> SUBMIT_QUEUE_SIZE_THRESHOLD_SETTING = Setting.byteSizeSetting(
        value -> {
 *
     *
 *
        try {
     * <p>Default: 128&nbsp;MB. Range: [16&nbsp;MB, 512&nbsp;MB].
     */
    }, Setting.Property.NodeScope);
     * via the {@code Drop} impl (i.e. when the JVM shuts down cleanly). In this mode
     *
     * <p>Configure in {@code opensearch.yml}:
     * <pre>{@code
     * <p>Default: 256&nbsp;MB. Range: [16&nbsp;MB, 1024&nbsp;MB].
 * <p>All settings are namespaced under {@code block_cache.foyer.*} to distinguish
     * the maximum durability window after a crash equals the node uptime since startup.
     * block_cache.foyer.size: 50%
     *
     *
 * plugins (e.g. {@code block_cache.caffeine.*}).
            if (ratio.getAsRatio() < 0 || ratio.getAsRatio() >= 1.0) {
    /**
    /**
        1.0,  // max: 1.0
import org.opensearch.common.settings.Setting;
     * Total buffer pool size for the Foyer flusher.
     * Fraction of the total Foyer disk budget allocated to the metadata cache.
     * Block size for the Foyer disk tier.
     * of SSD on warm nodes). This setting is applied against that budget, so the actual
     * <p>The total budget is defined by {@code node.search.cache.size} (default: 80%
            try {
 * The OpenSearch Contributors require contributions made to
     * <pre>{@code
     * exceeded, new entries are silently dropped instead of being written to disk.
     * larger than this buffer are silently dropped.
     * How often (seconds) the background sweeper prunes stale key_index entries left
     * Fraction of the total warm-cache SSD budget allocated to the Foyer block cache.
                return value;
        "block_cache.foyer.key_index_sweep_interval_seconds",
     *
     * <pre>{@code
    );
     */
     * Accepts a percentage (e.g. {@code 50%}) or a ratio (e.g. {@code 0.50}).
     *
     *
     */
    );
    public static final Setting<String> CACHE_SIZE_SETTING = new Setting<>("block_cache.foyer.size", "50%", value -> {
     * <p>The flusher stages entries in this buffer before writing to disk. Must be
        3600L, // max: 1 hour
    /**
        new ByteSizeValue(512, ByteSizeUnit.MB),
 * compatible open source license.
    /**
     * data-only cache). Accepts a percentage (e.g. {@code 5%}) or a ratio (e.g. {@code 0.05}).
        new ByteSizeValue(128, ByteSizeUnit.MB),
        new ByteSizeValue(128, ByteSizeUnit.MB),
    /**
     * A smaller block size than the data cache avoids wasting SSD space on internal
 *
        return value;
        Setting.Property.Dynamic
        new ByteSizeValue(8, ByteSizeUnit.MB),
     * <p>Configure in {@code opensearch.yml}:
     * <p>The persist task is decoupled from the sweep task so that persist frequency
     * <p>Maximum total bytes allowed to be pending in the flusher queue. When
 *
     */
        new ByteSizeValue(128, ByteSizeUnit.MB),
    );
     *
        new ByteSizeValue(1, ByteSizeUnit.MB),
import java.util.Set;
     * Block size for the metadata cache's Foyer disk tier.
    /**
     * can be up to 128&nbsp;MB. A block size smaller than an entry causes a silent
     * <p>Metadata entries (page indexes, offset indexes) are typically small (KB–MB range).
        Setting.Property.Dynamic
     *
      * {@code block_cache.foyer.size=50%} → Foyer gets 400&nbsp;GB, FileCache gets 400&nbsp;GB.
    /**
     * }</pre>
    );
     * }</pre>
     * block_cache.foyer.key_index_sweep_threshold: 0.75
                if (ratio.getAsRatio() < 0 || ratio.getAsRatio() >= 0.5) {
 * {@link BlockCacheFoyerPlugin#requestedCapacityBytes(org.opensearch.common.settings.Settings, long)}.
     * Should be &ge; 2&times; {@code buffer_pool_size} to absorb write bursts.
                    e
     * <p>{@code 0} = disabled — the key_index is only persisted on graceful shutdown
     * <p>The task uses {@code used_bytes} as a change signal: if {@code used_bytes} has
     * block_cache.foyer.io_engine: psync
     * drop — the put succeeds but the entry is not stored, resulting in a cache miss.
    public static final Setting<ByteSizeValue> METADATA_BLOCK_SIZE_SETTING = Setting.byteSizeSetting(
        }
     *       all kernels and container sandboxes, and gives predictable
     * Set to {@code 0.0} to disable the threshold guard and always sweep.
     * metadata cache gets 20&nbsp;GB, data cache gets 380&nbsp;GB.
                );
     * <p>Range: {@code [0.0, 1.0]}.
     * (a cheap file write, default 60 s) and sweep frequency (an expensive DashMap scan)
        Setting.Property.NodeScope
        "block_cache.foyer.metadata_cache_ratio",
