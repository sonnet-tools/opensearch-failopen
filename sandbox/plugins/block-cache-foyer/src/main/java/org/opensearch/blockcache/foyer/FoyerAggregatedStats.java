            data.misses() + meta.misses(),
     * Disk-tier-only stats — SSD I/O and eviction pressure breakdown.
    static final int STATS_BUFFER_SIZE = Field.COUNT * 2;
 *
            raw[offset + Field.HIT_COUNT.ordinal()],
        );
     */
    }
    }
     */
     */
     * merge of both tiers for callers that want a single rolled-up view.
            data.diskBytesUsed() + meta.diskBytesUsed(),
     * Parses the FFM stats buffer for a tiered cache (data + metadata on separate SSDs).
            raw[offset + Field.HIT_BYTES.ordinal()],
    /**
 * <p>Core only ever sees {@link #overallStats()} via {@link FoyerBlockCache#stats()}.
}
     * <p>{@link #dataCacheStats()} and {@link #metadataCacheStats()} return their respective
    public BlockCacheStats dataCacheStats() {
package org.opensearch.blockcache.foyer;
     *
     * @param raw           stats buffer; length must be {@code >= 2 * Field.COUNT}
 *       sections are stored directly; {@link #overallStats()} returns the
            // Other counters are cumulative and intentionally left unclamped — a negative there
 * Foyer-aware code can reach for {@link #dataCacheStats()} / {@link #metadataCacheStats()}
        long metadataCapacityBytes
    public long metadataCapacityBytes() {
    private final BlockCacheStats metadataCacheStats;
    }
        HIT_BYTES,
     * <p>The Rust FFM writes:
    public static FoyerAggregatedStats snapshotTiered(long[] raw, long dataCapacityBytes, long metaCapacityBytes) {
     * sections directly — no subtraction, no derivation — so per-tier counters reflect
 *       Section 0 is the data tier and section 1 is the metadata tier. Both
    private FoyerAggregatedStats(
            data.hits() + meta.hits(),
     * Data cache stats. Returns the data-tier section directly in tiered mode,
    /**
        REMOVED_BYTES,
    private static BlockCacheStats readSection(long[] raw, int offset, long capacityBytes) {
     *
     *   <li>Indices 0–9: data cache stats</li>
        return metadataCacheStats != null;
    }
    ) {
    /** Tiered mode only. {@code null} in single-cache mode. */
            data.evictions() + meta.evictions(),
        return overallStats;
    public static FoyerAggregatedStats snapshot(long[] raw, long capacityBytes) {
        // dataCacheStats / metadataCacheStats are null in single-cache mode — callers asking
    }
        BlockCacheStats overallStats,
     * Kept as a separate accessor for back-compat with existing tests.
     * Field layout of one section in the native FFM stats buffer.
        // mode pointed at the data tier, and existing tests assert on that. Keep it stable.
            raw[offset + Field.REMOVED_BYTES.ordinal()],
     * Disk-tier breakdown. In tiered mode == {@link #dataCacheStats}; in single mode = section 1
    /**
    }
        REMOVED_COUNT,
        USED_BYTES,
    /** Data cache configured capacity. {@code 0} in single-cache mode. */
 */
        this.metadataCapacityBytes = metadataCapacityBytes;
     *
 */
    private final long dataCapacityBytes;
     * </ul>
 * <p>Two construction modes:
/*
        return metadataCacheStats;
            0L,                                                             // memoryBytesUsed — disk-only cache
 * this file be licensed under the Apache-2.0 license or a
    private final BlockCacheStats overallStats;
        // for per-tier breakdown are expected to check isTiered() first.
    }
     * In tiered mode this returns the data tier (back-compat with the historical contract).
    public BlockCacheStats overallStats() {
            data.hitBytes() + meta.hitBytes(),
    public boolean isTiered() {
        MISS_BYTES,
     * Must match the Rust {@code FoyerStatsCounter::snapshot()} field order exactly.
 *       existing tests.</li>
     */
public final class FoyerAggregatedStats {
        ACTIVE_IN_BYTES;
 * </ul>
 *       buffer's section 0 (overall) and section 1 (block-level / disk-tier) are
            data.activeInBytes() + meta.activeInBytes()
    /** Cross-tier rollup stats — used by core via {@link FoyerBlockCache#stats()}. */
        MISS_COUNT,
            capacityBytes,
 *       eagerly-computed merge of the two so callers see a single rolled-up view.</li>
    private final BlockCacheStats blockLevelStats;
    private final BlockCacheStats dataCacheStats;
     */
            data.removed() + meta.removed(),
        return new FoyerAggregatedStats(overall, data, data, meta, dataCapacityBytes, metaCapacityBytes);
            data.totalBytes() + meta.totalBytes(),
            data.removedBytes() + meta.removedBytes(),
            // Clamp to 0: activeInBytes is a point-in-time gauge and must never be negative.
            raw[offset + Field.USED_BYTES.ordinal()],
    }
            Math.max(0L, raw[offset + Field.ACTIVE_IN_BYTES.ordinal()])
    /**
        return dataCacheStats;
        return new BlockCacheStats(
        this.metadataCacheStats = metadataCacheStats;
     * Automatically kept in sync with the field count — no manual update needed when adding fields.
    /** Cross-tier rollup. In tiered mode = {@code merge(data, meta)}; in single mode = section 0. */
            raw[offset + Field.EVICTION_BYTES.ordinal()],
     * @param metaCapacityBytes   metadata cache disk capacity
        BlockCacheStats meta = readSection(raw, Field.COUNT, metaCapacityBytes);
        this.dataCapacityBytes = dataCapacityBytes;
    }
 * Point-in-time stats snapshot for the Foyer block cache.
 * @opensearch.internal
     */
            raw[offset + Field.MISS_COUNT.ordinal()],
     * of the FFM buffer (which Rust mirrors from section 0 in single-cache mode).
     */
        EVICTION_COUNT,
    /**
        BlockCacheStats blockLevel = readSection(raw, Field.COUNT, capacityBytes);
     * Metadata cache stats. Returns the metadata-tier section directly in tiered mode,
import org.opensearch.plugins.BlockCacheStats;
        );
        return metadataCapacityBytes;
    }
 *   <li><b>Tiered</b> — built via {@link #snapshotTiered(long[], long, long)}.
            raw[offset + Field.MISS_BYTES.ordinal()],
        static final int COUNT = values().length;
    /** Whether this snapshot represents a tiered cache (data + metadata). */
            data.evictionBytes() + meta.evictionBytes(),
        BlockCacheStats overall = merge(data, meta);
    private final long metadataCapacityBytes;
 * SPDX-License-Identifier: Apache-2.0
        BlockCacheStats overall = readSection(raw, 0, capacityBytes);
 * compatible open source license.
    /** Data cache configured capacity. {@code 0} in single-cache mode. */
     * exactly what the native side emitted. {@link #overallStats()} is the eagerly-computed
    /**
        HIT_COUNT,
    /** Metadata cache configured capacity. {@code 0} in single-cache mode. */
            raw[offset + Field.EVICTION_COUNT.ordinal()],
     * Parses both sections from the FFM stats buffer for a single-cache (non-tiered) Foyer.
    public BlockCacheStats metadataCacheStats() {
    }
 *   <li><b>Single-cache</b> — built via {@link #snapshot(long[], long)}. The FFM
    }
            raw[offset + Field.REMOVED_COUNT.ordinal()],
        BlockCacheStats metadataCacheStats,
            data.missBytes() + meta.missBytes(),
     * <ul>
     * @param dataCapacityBytes   data cache disk capacity
     * or {@code null} in single-cache mode.
 * <ul>
     */
        this.blockLevelStats = blockLevelStats;
 * which return {@code null} in single-cache mode and the per-tier sections in tiered mode.
 *       written by Rust as identical copies; we keep both for back-compat with
     * Ordinal equals the field's array index within the section.
    /** Tiered mode only. {@code null} in single-cache mode. */
        return new FoyerAggregatedStats(overall, blockLevel, null, null, 0L, 0L);
    public long dataCapacityBytes() {
     * @param raw                 stats buffer; length must be {@code >= 2 * Field.COUNT}
        EVICTION_BYTES,
/**
     *
            // signals a real bug and should stay visible.
 *
     *   <li>Indices 10–19: metadata cache stats</li>
        BlockCacheStats blockLevelStats,
    /**
        this.dataCacheStats = dataCacheStats;
    /** Metadata cache configured capacity. {@code 0} in single-cache mode. */
     * or {@code null} in single-cache mode.
        return blockLevelStats;
        this.overallStats = overallStats;
    private static BlockCacheStats merge(BlockCacheStats data, BlockCacheStats meta) {
    public BlockCacheStats blockLevelStats() {
     * Use {@link #dataCacheStats()} / {@link #metadataCacheStats()} for explicit per-tier access.
 *
        long dataCapacityBytes,
        return new BlockCacheStats(
     * @param capacityBytes configured disk capacity for this cache instance
 * The OpenSearch Contributors require contributions made to
        BlockCacheStats data = readSection(raw, 0, dataCapacityBytes);
 *
        // blockLevelStats == data is intentional: the historical "block-level" view in tiered
            0L,
        return dataCapacityBytes;
    private enum Field {
    }
        BlockCacheStats dataCacheStats,
    /**
     * Buffer size for {@link FoyerBridge#snapshotStats}: 2 sections × {@code Field.COUNT} values.
