        CatalogSnapshotManager snapshotManager,
        Store store,
    /**
     */  
 *  
     * Constructs a {@link SegmentsStats} with memory and timestamp passed from outside,  
 * Stats are refreshed only when the catalog snapshot changes (on refresh), not on every stats API call.
import java.util.Collections;
    private volatile List<Segment> cachedSegments;  
        this.store = store;  
    private SegmentsStats computeSegmentsStats(CatalogSnapshot snapshot) {  
 * SPDX-License-Identifier: Apache-2.0
        CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> docCountsResolver,
        } catch (Exception e) {
     */
            SegmentsStats newSegmentsStats = computeSegmentsStats(snapshot);
        List<Segment> cached = cachedSegments;
            // Precompute catalog-specific stats  
import java.io.IOException;  
    // Cached stats - volatile for thread safety between refresh and API threads  
            this.cachedSegments = newSegments;  
    public void afterRefresh(boolean didRefresh) throws IOException {
            refreshCachedStats();
    }
     * Returns precomputed segments list. Called frequently by stats APIs.
     * while calculating segment count and file sizes internally from the snapshot.
     * @return populated {@link SegmentsStats}
     *  
    }
            Map<String, String> commitData = lastCommitDataSupplier.get();
 * The OpenSearch Contributors require contributions made to  
    }  
     * @param nativeBytesUsed          native/off-heap memory used by the engine (passed from outside)
        refreshCachedStats();
            // report the same numbers even if a refresh lands midway through this method.  
            // Keep existing cached values on error - better than failing stats APIs  
}  
    private void refreshCachedStats() {
    /**  
    /**  
            // Liveness, resolved once and shared by the docs stats and the per-segment stats so both
        this.logger = logger;
    private final CheckedFunction<CatalogSnapshot, Map<Long, DocCounts>, IOException> docCountsResolver;  
import org.opensearch.index.engine.exec.WriterFileSet;  
public class CatalogSnapshotStatsCache implements ReferenceManager.RefreshListener, Engine.EventListener {
        // Note: Compound files (e.g., .cfs) are reported under their physical extension  
    }
import org.opensearch.common.CheckedFunction;  
    }
    }
    }  
     * @return cached DocsStats or empty stats if not yet computed
     */  
        EngineConfig engineConfig,  
        return cached != null ? cached : new DocsStats();  
    }
     * Returns precomputed segments stats. Called frequently by stats APIs.
            .mapToLong(WriterFileSet::getTotalSize)  
        return new DocsStats.Builder().count(counts.liveDocs()).deleted(counts.deletedDocs()).totalSizeInBytes(totalSizeInBytes).build();  
    public void forceRefresh() {  
    /**  
import org.opensearch.index.engine.exec.DocCounts;
            this.cachedDocsStats = newDocsStats;
        Supplier<Map<String, String>> lastCommitDataSupplier,
            logger.warn("Failed to refresh cached catalog snapshot stats", e);
        this.engineConfig = engineConfig;
        return cached != null ? cached : new SegmentsStats();  
     * @param snapshot                 catalog snapshot to calculate internal stats from  
     */
        }
     * @return cached segments list or empty list if not yet computed
    /**  
            List<Segment> newSegments = snapshot.buildEngineSegments(  
    private final Logger logger;
 *
import org.apache.lucene.search.ReferenceManager;
 * compatible open source license.
        try {  
            .stream()
            .sum();
        SegmentsStats stats = new SegmentsStats();  
            Map<Long, DocCounts> docCounts = docCountsResolver.apply(snapshot);
    }
 */  
        } catch (Exception e) {
            snapshot
 * Caches precomputed stats from catalog snapshots to avoid expensive recomputation on every API call.
            );
        this.snapshotManager = snapshotManager;
        stats.addIndexWriterMemoryInBytes(nativeBytesUsed);
import org.opensearch.index.engine.exec.coord.CatalogSnapshotManager;
    private volatile DocsStats cachedDocsStats;
 */  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        if (didRefresh) {  
    private final CatalogSnapshotManager snapshotManager;
        this.lastCommitDataSupplier = lastCommitDataSupplier;
    @Override
 * This optimization moves expensive stats computation from API-call time (frequent) to refresh time (infrequent),
            DocsStats newDocsStats = computeDocsStats(snapshot, docCounts);
        // No action needed before refresh
        DocsStats cached = cachedDocsStats;
            stats.addFileSizes(groupedFileSizes);
        stats.add(segmentCount);
import java.util.function.Supplier;
/**  
    private DocsStats computeDocsStats(CatalogSnapshot snapshot, Map<Long, DocCounts> docCounts) {
    public void onFlushCompleted() {
            -1L, // maxUnsafeAutoIdTimestamp - engine-specific, passed from outside  
        long totalSizeInBytes = snapshot.getSegments()  
     * File sizes are grouped by extension (like internal engine) for compound files.
 * this file be licensed under the Apache-2.0 license or a
            CatalogSnapshot snapshot = snapshotRef.get();  
        if (!groupedFileSizes.isEmpty()) {  
        Logger logger  
     * @param maxUnsafeAutoIdTimestamp max unsafe auto-id timestamp (passed from outside)
        }
/*  
                docCounts  
        }
     * Returns precomputed docs stats. Called frequently by stats APIs.
            logger.debug("Refreshed cached catalog snapshot stats: {} docs, {} segments", newDocsStats.getCount(), newSegments.size());
        Map<String, Long> groupedFileSizes = snapshot.collectFileSizesGroupedByExtension(store);
import org.opensearch.index.shard.DocsStats;  
            this.cachedSegmentsStats = newSegmentsStats;
     * @return cached SegmentsStats or empty stats if not yet computed
import org.apache.logging.log4j.Logger;
    private final EngineConfig engineConfig;
        return buildSegmentsStats(
    public SegmentsStats getSegmentsStats() {
    public List<Segment> getSegments() {
     * Forces a refresh of cached stats. Useful for initialization or testing.
    private final Supplier<Map<String, String>> lastCommitDataSupplier;
    }
        try (GatedCloseable<CatalogSnapshot> snapshotRef = snapshotManager.acquireSnapshot()) {
    private volatile SegmentsStats cachedSegmentsStats;
    /**
            logger.warn("Failed to refresh cached stats after flush completion", e);  
            refreshCachedStats();
        this.docCountsResolver = docCountsResolver;  
        }
    @Override
    private final Store store;  
import java.util.List;
            .flatMap(segment -> segment.dfGroupedSearchableFiles().values().stream())
        return cached != null ? cached : Collections.emptyList();  
        SegmentsStats cached = cachedSegmentsStats;
     */  
        );
        stats.updateMaxUnsafeAutoIdTimestamp(maxUnsafeAutoIdTimestamp);  
    public void beforeRefresh() throws IOException {  
package org.opensearch.index.engine;
        int segmentCount = snapshot.getSegments().size();
        return stats;
            // Build engine segments with commit data and index sort
            // Atomic replacement - all or nothing for consistency  
        // Collect file sizes grouped by extension in a single pass (no intermediate per-file map).
    public CatalogSnapshotStatsCache(  
    // Fast API methods - just return cached values
     */  
    public SegmentsStats buildSegmentsStats(long nativeBytesUsed, long maxUnsafeAutoIdTimestamp, CatalogSnapshot snapshot) {  
    public DocsStats getDocsStats() {
import org.opensearch.index.store.Store;
        DocCounts counts = snapshot.aggregateDocCounts(docCounts);
     * Builds the shard's docs stats from the snapshot.
            0L, // nativeBytesUsed - engine-specific, passed from outside
        // rather than broken down by internal sub-file format.
    ) {
import java.util.Map;  
                commitData,
                engineConfig != null ? engineConfig.getIndexSort() : null,
 * significantly improving performance for frequently called stats APIs.
    }
        // Refresh cached stats when flush completes since flush can change committed state
    }
import org.opensearch.common.concurrent.GatedCloseable;
