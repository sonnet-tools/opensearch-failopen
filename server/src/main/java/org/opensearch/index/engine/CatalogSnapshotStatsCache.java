            // Keep existing cached values on error - better than failing stats APIs
     * Forces a refresh of cached stats. Useful for initialization or testing.
    @Override
    public void forceRefresh() {
        refreshCachedStats();
 * This optimization moves expensive stats computation from API-call time (frequent) to refresh time (infrequent),
        try (GatedCloseable<CatalogSnapshot> snapshotRef = snapshotManager.acquireSnapshot()) {
    public CatalogSnapshotStatsCache(
     */
            Map<String, String> commitData = lastCommitDataSupplier.get();
        stats.updateMaxUnsafeAutoIdTimestamp(maxUnsafeAutoIdTimestamp);
            // Liveness, resolved once and shared by the docs stats and the per-segment stats so both
        } catch (Exception e) {
            // Precompute catalog-specific stats
     * Returns precomputed segments list. Called frequently by stats APIs.
            refreshCachedStats();
    }
            logger.warn("Failed to refresh cached stats after flush completion", e);
    public void onFlushCompleted() {
        // Note: Compound files (e.g., .cfs) are reported under their physical extension
            );
            -1L, // maxUnsafeAutoIdTimestamp - engine-specific, passed from outside
            .stream()
    @Override
import java.util.Collections;
import org.opensearch.index.shard.DocsStats;
    private SegmentsStats computeSegmentsStats(CatalogSnapshot snapshot) {
     * @return cached DocsStats or empty stats if not yet computed
     * @param snapshot                 catalog snapshot to calculate internal stats from
    public SegmentsStats buildSegmentsStats(long nativeBytesUsed, long maxUnsafeAutoIdTimestamp, CatalogSnapshot snapshot) {
public class CatalogSnapshotStatsCache implements ReferenceManager.RefreshListener, Engine.EventListener {
    private volatile DocsStats cachedDocsStats;
        } catch (Exception e) {
    private final CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> docCountsResolver;
    public void afterRefresh(boolean didRefresh) throws IOException {
        // rather than broken down by internal sub-file format.
            // Build engine segments with commit data and index sort
        return cached != null ? cached : Collections.emptyList();
        List<Segment> cached = cachedSegments;
     * @return cached SegmentsStats or empty stats if not yet computed
    }
     * while calculating segment count and file sizes internally from the snapshot.
            snapshot
                docCounts
 */
        }
        return buildSegmentsStats(
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
                engineConfig != null ? engineConfig.getIndexSort() : null,
    private final CatalogSnapshotManager snapshotManager;
        this.store = store;
    private final Logger logger;
        return cached != null ? cached : new DocsStats();
     * @param maxUnsafeAutoIdTimestamp max unsafe auto-id timestamp (passed from outside)
import org.opensearch.index.engine.exec.WriterFileSet;
     */
 * significantly improving performance for frequently called stats APIs.
     *
     */
            stats.addFileSizes(groupedFileSizes);
        this.logger = logger;
    private volatile List<Segment> cachedSegments;
        EngineConfig engineConfig,
    /**
            .mapToLong(WriterFileSet::getTotalSize)
    // Cached stats - volatile for thread safety between refresh and API threads
        CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> docCountsResolver,
     * @return cached segments list or empty list if not yet computed
        return stats;
    /**
/**
    }
import java.util.Map;
    }
            .sum();
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Long> groupedFileSizes = snapshot.collectFileSizesGroupedByExtension(store);
 * compatible open source license.
    // Fast API methods - just return cached values
    /**
            logger.debug("Refreshed cached catalog snapshot stats: {} docs, {} segments", newDocsStats.getCount(), newSegments.size());
    public DocsStats getDocsStats() {
        Supplier<Map<String, String>> lastCommitDataSupplier,
     * Builds the shard's docs stats from the snapshot.
        SegmentsStats stats = new SegmentsStats();
    /**
            logger.warn("Failed to refresh cached catalog snapshot stats", e);
            this.cachedSegments = newSegments;
        long totalSizeInBytes = snapshot.getSegments()
        return new DocsStats.Builder().count(counts.liveDocs()).deleted(counts.deletedDocs()).totalSizeInBytes(totalSizeInBytes).build();
import org.opensearch.common.concurrent.GatedCloseable;
            Map<Long, DocCounts> docCounts = docCountsResolver.apply(snapshot);
        SegmentsStats cached = cachedSegmentsStats;
        this.lastCommitDataSupplier = lastCommitDataSupplier;
 *
        if (didRefresh) {
        // Collect file sizes grouped by extension in a single pass (no intermediate per-file map).
            List<Segment> newSegments = snapshot.buildEngineSegments(
     */
    }
    private final EngineConfig engineConfig;
        Store store,
import org.opensearch.index.store.Store;
import org.opensearch.common.CheckedFunction;
        }
    }
        this.docCountsResolver = docCountsResolver;
    private volatile SegmentsStats cachedSegmentsStats;
            this.cachedSegmentsStats = newSegmentsStats;
import java.util.function.Supplier;
 *
            refreshCachedStats();
     */
    ) {
    private DocsStats computeDocsStats(CatalogSnapshot snapshot, Map<Long, DocCounts> docCounts) {
    }
 * Caches precomputed stats from catalog snapshots to avoid expensive recomputation on every API call.
        DocCounts counts = snapshot.aggregateDocCounts(docCounts);
    public List<Segment> getSegments() {
            DocsStats newDocsStats = computeDocsStats(snapshot, docCounts);
    }
            0L, // nativeBytesUsed - engine-specific, passed from outside
/*
    private void refreshCachedStats() {
        Logger logger
    }
            this.cachedDocsStats = newDocsStats;
        DocsStats cached = cachedDocsStats;
            CatalogSnapshot snapshot = snapshotRef.get();
    /**
        stats.add(segmentCount);
        }
import java.util.List;
        // Refresh cached stats when flush completes since flush can change committed state
    private final Supplier<Map<String, String>> lastCommitDataSupplier;
package org.opensearch.index.engine;
            // report the same numbers even if a refresh lands midway through this method.
     * @param nativeBytesUsed          native/off-heap memory used by the engine (passed from outside)
     * Returns precomputed segments stats. Called frequently by stats APIs.
        stats.addIndexWriterMemoryInBytes(nativeBytesUsed);
    public void beforeRefresh() throws IOException {
import org.apache.lucene.search.ReferenceManager;
     */
                commitData,
        return cached != null ? cached : new SegmentsStats();
        // No action needed before refresh
        int segmentCount = snapshot.getSegments().size();
        );
    }
        this.snapshotManager = snapshotManager;
        CatalogSnapshotManager snapshotManager,
}
            // Atomic replacement - all or nothing for consistency
        if (!groupedFileSizes.isEmpty()) {
import org.apache.logging.log4j.Logger;
import java.io.IOException;
            .flatMap(segment -> segment.dfGroupedSearchableFiles().values().stream())
    public SegmentsStats getSegmentsStats() {
     * @return populated {@link SegmentsStats}
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    }
     * Returns precomputed docs stats. Called frequently by stats APIs.
 * this file be licensed under the Apache-2.0 license or a
     * File sizes are grouped by extension (like internal engine) for compound files.
    }
        this.engineConfig = engineConfig;
 * The OpenSearch Contributors require contributions made to
 * Stats are refreshed only when the catalog snapshot changes (on refresh), not on every stats API call.
            SegmentsStats newSegmentsStats = computeSegmentsStats(snapshot);
import org.opensearch.index.engine.exec.DocCounts;
        }
     * Constructs a {@link SegmentsStats} with memory and timestamp passed from outside,
 */
    private final Store store;
    /**
        try {
