 * which return {@code null} in single-cache mode and the per-tier sections in tiered mode.
        this.dataCacheStats = dataCacheStats;  
     * @param raw           stats buffer; length must be {@code >= 2 * Field.COUNT}  
    }
    public static FoyerAggregatedStats snapshotTiered(long[] raw, long dataCapacityBytes, long metaCapacityBytes) {
        // for per-tier breakdown are expected to check isTiered() first.
        return dataCacheStats;
 * compatible open source license.
     *
     */
     * Kept as a separate accessor for back-compat with existing tests.
    ) {  
    }
     * or {@code null} in single-cache mode.
            raw[offset + Field.HIT_COUNT.ordinal()],
    private enum Field {
 *
     * <ul>  
    }  
     * @param metaCapacityBytes   metadata cache disk capacity  
        );
    /** Data cache configured capacity. {@code 0} in single-cache mode. */
    /** Metadata cache configured capacity. {@code 0} in single-cache mode. */  
     * In tiered mode this returns the data tier (back-compat with the historical contract).
            data.evictions() + meta.evictions(),
     * merge of both tiers for callers that want a single rolled-up view.
        EVICTION_COUNT,  
        BlockCacheStats meta = readSection(raw, Field.COUNT, metaCapacityBytes);
     * exactly what the native side emitted. {@link #overallStats()} is the eagerly-computed
        this.metadataCacheStats = metadataCacheStats;
        EVICTION_BYTES,
    }
        BlockCacheStats dataCacheStats,
    /**
        return blockLevelStats;  
     * Parses the FFM stats buffer for a tiered cache (data + metadata on separate SSDs).  
     * Disk-tier-only stats — SSD I/O and eviction pressure breakdown.
 *   <li><b>Tiered</b> — built via {@link #snapshotTiered(long[], long, long)}.  
    }
            // signals a real bug and should stay visible.
        // mode pointed at the data tier, and existing tests assert on that. Keep it stable.
     * </ul>  
 * The OpenSearch Contributors require contributions made to  
        return overallStats;  
    /** Cross-tier rollup stats — used by core via {@link FoyerBlockCache#stats()}. */
    /**
        BlockCacheStats overall = readSection(raw, 0, capacityBytes);
            data.diskBytesUsed() + meta.diskBytesUsed(),  
     *   <li>Indices 0–9: data cache stats</li>
     *
            0L,                                                             // memoryBytesUsed — disk-only cache  
    private static BlockCacheStats readSection(long[] raw, int offset, long capacityBytes) {
            capacityBytes,
        USED_BYTES,
 */
    public BlockCacheStats blockLevelStats() {
     */
 *
 *       existing tests.</li>
    }
     */
     * @param capacityBytes configured disk capacity for this cache instance
 * <p>Core only ever sees {@link #overallStats()} via {@link FoyerBlockCache#stats()}.  
}
    public long dataCapacityBytes() {
    /** Tiered mode only. {@code null} in single-cache mode. */
     */
        this.overallStats = overallStats;
 * </ul>
 *   <li><b>Single-cache</b> — built via {@link #snapshot(long[], long)}. The FFM
        this.metadataCapacityBytes = metadataCapacityBytes;  
/**  
            data.hitBytes() + meta.hitBytes(),
 * SPDX-License-Identifier: Apache-2.0
 *       sections are stored directly; {@link #overallStats()} returns the
    public long metadataCapacityBytes() {
        REMOVED_COUNT,  
        BlockCacheStats data = readSection(raw, 0, dataCapacityBytes);  
    /** Cross-tier rollup. In tiered mode = {@code merge(data, meta)}; in single mode = section 0. */
    public BlockCacheStats overallStats() {
    public BlockCacheStats metadataCacheStats() {  
     */  
        );  
 * Foyer-aware code can reach for {@link #dataCacheStats()} / {@link #metadataCacheStats()}
        MISS_BYTES,
    }
            raw[offset + Field.MISS_COUNT.ordinal()],
        long metadataCapacityBytes
     * Data cache stats. Returns the data-tier section directly in tiered mode,
     * Automatically kept in sync with the field count — no manual update needed when adding fields.  
 *  
        HIT_COUNT,
     * or {@code null} in single-cache mode.
            data.removed() + meta.removed(),  
        return new FoyerAggregatedStats(overall, blockLevel, null, null, 0L, 0L);
    private FoyerAggregatedStats(
 *       buffer's section 0 (overall) and section 1 (block-level / disk-tier) are  
        static final int COUNT = values().length;
 * <ul>
            raw[offset + Field.HIT_BYTES.ordinal()],  
    private final BlockCacheStats metadataCacheStats;  
    /**  
 *       eagerly-computed merge of the two so callers see a single rolled-up view.</li>  
    /** Metadata cache configured capacity. {@code 0} in single-cache mode. */
            data.removedBytes() + meta.removedBytes(),
    }
     * Buffer size for {@link FoyerBridge#snapshotStats}: 2 sections × {@code Field.COUNT} values.
     * <p>{@link #dataCacheStats()} and {@link #metadataCacheStats()} return their respective
        return new FoyerAggregatedStats(overall, data, data, meta, dataCapacityBytes, metaCapacityBytes);
     * Ordinal equals the field's array index within the section.
        return dataCapacityBytes;  
            raw[offset + Field.REMOVED_BYTES.ordinal()],
        long dataCapacityBytes,
     *  
            data.activeInBytes() + meta.activeInBytes()
            data.totalBytes() + meta.totalBytes(),
 * Point-in-time stats snapshot for the Foyer block cache.
        BlockCacheStats overallStats,  
     * @param raw                 stats buffer; length must be {@code >= 2 * Field.COUNT}
            0L,
        // blockLevelStats == data is intentional: the historical "block-level" view in tiered  
    /** Tiered mode only. {@code null} in single-cache mode. */
        this.dataCapacityBytes = dataCapacityBytes;
        this.blockLevelStats = blockLevelStats;
/*  
        BlockCacheStats overall = merge(data, meta);
    /** Data cache configured capacity. {@code 0} in single-cache mode. */
    private static BlockCacheStats merge(BlockCacheStats data, BlockCacheStats meta) {
            raw[offset + Field.MISS_BYTES.ordinal()],
    static final int STATS_BUFFER_SIZE = Field.COUNT * 2;
        MISS_COUNT,
 *       written by Rust as identical copies; we keep both for back-compat with
    private final BlockCacheStats blockLevelStats;  
    private final BlockCacheStats dataCacheStats;  
     * @param dataCapacityBytes   data cache disk capacity
        return metadataCacheStats;
 *
        HIT_BYTES,  
     */
            data.hits() + meta.hits(),  
    }
    private final long metadataCapacityBytes;  
     * Must match the Rust {@code FoyerStatsCounter::snapshot()} field order exactly.
        return new BlockCacheStats(  
            Math.max(0L, raw[offset + Field.ACTIVE_IN_BYTES.ordinal()])  
     * Use {@link #dataCacheStats()} / {@link #metadataCacheStats()} for explicit per-tier access.  
    /** Whether this snapshot represents a tiered cache (data + metadata). */
        return metadataCacheStats != null;
package org.opensearch.blockcache.foyer;
     *
     * Metadata cache stats. Returns the metadata-tier section directly in tiered mode,  
import org.opensearch.plugins.BlockCacheStats;
 * <p>Two construction modes:  
        BlockCacheStats metadataCacheStats,  
        REMOVED_BYTES,
     * sections directly — no subtraction, no derivation — so per-tier counters reflect  
            raw[offset + Field.USED_BYTES.ordinal()],
        BlockCacheStats blockLevel = readSection(raw, Field.COUNT, capacityBytes);
     */
     * Field layout of one section in the native FFM stats buffer.  
    /**
    public BlockCacheStats dataCacheStats() {
        return metadataCapacityBytes;
            data.evictionBytes() + meta.evictionBytes(),
            raw[offset + Field.EVICTION_BYTES.ordinal()],  
     * Parses both sections from the FFM stats buffer for a single-cache (non-tiered) Foyer.
 */  
     *   <li>Indices 10–19: metadata cache stats</li>
    }  
    /**
 * @opensearch.internal
    /**
    public static FoyerAggregatedStats snapshot(long[] raw, long capacityBytes) {  
     */  
    /**  
        return new BlockCacheStats(
    /**  
    }  
            // Clamp to 0: activeInBytes is a point-in-time gauge and must never be negative.  
            // Other counters are cumulative and intentionally left unclamped — a negative there
    public boolean isTiered() {  
            data.misses() + meta.misses(),
 *       Section 0 is the data tier and section 1 is the metadata tier. Both
    private final long dataCapacityBytes;  
            raw[offset + Field.REMOVED_COUNT.ordinal()],
     * <p>The Rust FFM writes:
            data.missBytes() + meta.missBytes(),  
     * of the FFM buffer (which Rust mirrors from section 0 in single-cache mode).  
        // dataCacheStats / metadataCacheStats are null in single-cache mode — callers asking  
            raw[offset + Field.EVICTION_COUNT.ordinal()],
        ACTIVE_IN_BYTES;
    }
        BlockCacheStats blockLevelStats,
public final class FoyerAggregatedStats {  
     * Disk-tier breakdown. In tiered mode == {@link #dataCacheStats}; in single mode = section 1
    }  
 * this file be licensed under the Apache-2.0 license or a
    private final BlockCacheStats overallStats;
