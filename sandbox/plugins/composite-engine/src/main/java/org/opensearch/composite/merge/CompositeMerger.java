import java.util.LinkedHashSet;
        }
    }
                + " rows";  
    /**
        long total = 0L;  
     * where its {@code merge()} did not consume it — no explicit abort call for callers to forget.
import org.opensearch.index.engine.dataformat.MergePreparation;  
            map.put(secondary.getDataFormat(), merger);
        return List.copyOf(secondaries);
        Map<DataFormat, Merger> map = new HashMap<>();
        allFormats.addAll(secondaryFormats);
    private static long totalRowsForSegment(Segment seg) {
 */  
import java.util.LinkedHashMap;
                "Primary format [" + engine.getPrimaryDelegate().getDataFormat().name() + "] does not provide a Merger"
        }
     */
            if (merger == null) {
    public CompositeMerger(CompositeIndexingExecutionEngine engine, CompositeDataFormat compositeDataFormat) {
        // recordOutcome: time always, merge_total on success, merge_failures on throw.
import java.util.HashMap;  
            if (bits == null) {
        for (var wfs : seg.dfGroupedSearchableFiles().values()) {
     * Delegates to the single resolved live-docs producer. Secondaries that do not provide live
     * docs are never asked to prepare, so they have nothing to release either.
 *
        this.secondaryFormats = resolveSecondaryFormats(compositeDataFormat, primaryFormat);
        this.primaryFormat = compositeDataFormat.getPrimaryDataFormat();  
        return filesByFormat;  
        if (liveDocsProducer == null) {  
                assert assertLiveDocsShape(mergeInput.segments(), frozenLiveDocs) : "live-docs shape doesn't match segment row counts";  
                + seg.generation()
    }
            );  
    }  
import org.opensearch.index.engine.dataformat.MergeResult;
        List<DataFormat> secondaries = new ArrayList<>();
import java.util.Set;
        if (producers.size() > 1) {
    }
 * The OpenSearch Contributors require contributions made to  
                secondaries.add(format);
                Map<DataFormat, List<WriterFileSet>> filesByFormat = extractFilesByFormat(mergeInput.segments());
@ExperimentalApi
            try (MergePreparation preparation = prepareMerge(mergeInput)) {  
        return producers.isEmpty() ? null : executor.getMerger(producers.get(0));
    /** Verifies the bitmap has at least as many bits as the segment's row count. */  
        }
    }
    private static boolean assertLiveDocsShape(List<Segment> segments, LiveDocs liveDocs) {
import org.opensearch.composite.CompositeDataFormat;
                throw new IllegalStateException("Secondary format [" + secondary.getDataFormat().name() + "] does not provide a Merger");  
            }  
                    filesByFormat,
    private static Merger resolveLiveDocsProducer(List<DataFormat> secondaries, CompositeMergeExecutor executor) {  
            long expected = totalRowsForSegment(seg);
/**
     * The bitmap from prepareMerge overrides any {@link MergeInput#liveDocs()} the caller passed in.  
 * data formats by delegating to {@link CompositeMergeExecutor}.  
        this.statsTracker = engine.statsTracker();  
                + expected
        for (DataFormat format : compositeDataFormat.getDataFormats()) {
import java.util.Map;
                    primaryFormat,
        }  
 * compatible open source license.
    public MergePreparation prepareMerge(MergeInput mergeInput) throws IOException {
    /**
    /** The {@link Merger} of the one secondary whose {@link Merger#providesMergeLiveDocs()} is true, or {@code null}. */
        }, statsTracker::addMergeTimeMillis, statsTracker::incMergeTotal, statsTracker::incMergeFailures);  
import java.util.ArrayList;
            List<WriterFileSet> files = new ArrayList<>();  
            long capacity = (long) bits.length * 64L;
        return StatsRecorder.recordOutcome(() -> {
        }  
            }  
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(format.name());
            Merger merger = secondary.getMerger();
        if (primaryMerger == null) {
            long[] bits = liveDocs.packedBits(seg.generation());  
    private static List<DataFormat> resolveSecondaryFormats(CompositeDataFormat compositeDataFormat, DataFormat primaryFormat) {  
import org.opensearch.index.engine.dataformat.MergeInput;
     * held in a try-with-resources so the producer's pinned state is released on every exit path
            if (format.equals(primaryFormat) == false) {  
     * and a second producer is a configuration error rather than something to silently drop.
            }
            }
import java.io.IOException;
                assert frozenLiveDocs != null : "merger returned null live-docs";
 * @opensearch.experimental
    private static Map<DataFormat, Merger> buildMergerMap(CompositeIndexingExecutionEngine engine) {
                    + producers.stream().map(DataFormat::name).toList()
    }
import org.opensearch.index.engine.exec.WriterFileSet;
        MergePreparation preparation = liveDocsProducer.prepareMerge(mergeInput);  
}  
            throw new IllegalStateException(  
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;  
            filesByFormat.put(format, List.copyOf(files));
 */  
        return liveDocsProducer != null;  
    }  
        for (DataFormat secondary : secondaries) {
            for (Segment segment : segments) {
            Merger merger = executor.getMerger(secondary);  
import org.opensearch.plugin.stats.StatsRecorder;
import org.opensearch.index.engine.exec.Segment;  
 * SPDX-License-Identifier: Apache-2.0
        }  
            if (merger != null && merger.providesMergeLiveDocs()) {
        map.put(engine.getPrimaryDelegate().getDataFormat(), primaryMerger);
import org.opensearch.composite.stats.CompositeShardStatsTracker;
                    mergeInput.newWriterGeneration(),
    /**  
        for (Segment seg : segments) {
     * Picks the secondary that owns delete state for merges. Mirrors the registry's single
    private final CompositeMergeExecutor executor;  
        }
    private final List<DataFormat> secondaryFormats;
    public MergeResult merge(MergeInput mergeInput) throws IOException {  
            assert capacity >= expected : "live-docs bitmap for gen="  
        allFormats.add(primaryFormat);
        return total;
                    frozenLiveDocs
        for (IndexingExecutionEngine<?, ?> secondary : engine.getSecondaryDelegates()) {  
 * this file be licensed under the Apache-2.0 license or a
        this.executor = new CompositeMergeExecutor(buildMergerMap(engine));
        for (DataFormat format : allFormats) {
import org.opensearch.index.engine.dataformat.Merger;
    private Map<DataFormat, List<WriterFileSet>> extractFilesByFormat(List<Segment> segments) {
package org.opensearch.composite.merge;
                }
                if (wfs != null) {  
     * delete-execution-engine rule: opt-in via {@link Merger#providesMergeLiveDocs()}, at most one,  
    private final CompositeShardStatsTracker statsTracker;
     */  
                continue;
        }  
            );
            }  
public class CompositeMerger implements Merger {
            total = Math.max(total, wfs.numRows());
                + " bits but segment has "
        List<DataFormat> producers = new ArrayList<>();
    }
    }
     */
                );  
        Merger primaryMerger = engine.getPrimaryDelegate().getMerger();
        Set<DataFormat> allFormats = new LinkedHashSet<>();  
                return executor.execute(plan);
import org.opensearch.composite.CompositeIndexingExecutionEngine;  
 *
     * Two-phase merge: phase 1 freezes the live-docs producer's snapshot via {@link #prepareMerge};
/*  
                + " has "
            }
 * A {@link Merger} that orchestrates composite merges across primary and secondary
import org.opensearch.index.engine.dataformat.DataFormat;
                MergePlan plan = new MergePlan(  
        this.liveDocsProducer = resolveLiveDocsProducer(secondaryFormats, executor);
    @Override
    public boolean providesMergeLiveDocs() {
            return MergePreparation.EMPTY;
import org.opensearch.common.annotation.ExperimentalApi;
                "Multiple secondary formats provide merge live-docs, expected at most one but found "
            throw new IllegalStateException(  
                    secondaryFormats,  
                    files.add(wfs);
        return true;
    }
    @Override
     * phase 2 runs primary → secondaries with that frozen bitmap. The {@link MergePreparation} is  
    private final Merger liveDocsProducer;  
        return preparation == null ? MergePreparation.EMPTY : preparation;
                + capacity  
        return Map.copyOf(map);
        Map<DataFormat, List<WriterFileSet>> filesByFormat = new LinkedHashMap<>();
    @Override
    private final DataFormat primaryFormat;
import org.opensearch.index.engine.dataformat.LiveDocs;
                LiveDocs frozenLiveDocs = preparation.liveDocs();
import java.util.List;  
        }
                producers.add(secondary);
