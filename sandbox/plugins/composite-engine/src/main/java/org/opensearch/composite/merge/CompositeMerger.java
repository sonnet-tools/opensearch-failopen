            Merger merger = secondary.getMerger();
            }
    private Map<DataFormat, List<WriterFileSet>> extractFilesByFormat(List<Segment> segments) {
     * and a second producer is a configuration error rather than something to silently drop.
        this.statsTracker = engine.statsTracker();
 * this file be licensed under the Apache-2.0 license or a
    private final CompositeShardStatsTracker statsTracker;
        }
                );
            long[] bits = liveDocs.packedBits(seg.generation());
        if (producers.size() > 1) {
                if (wfs != null) {
                return executor.execute(plan);
                    filesByFormat,
        }
     * phase 2 runs primary → secondaries with that frozen bitmap. The {@link MergePreparation} is
            if (format.equals(primaryFormat) == false) {
        Map<DataFormat, Merger> map = new HashMap<>();
                "Primary format [" + engine.getPrimaryDelegate().getDataFormat().name() + "] does not provide a Merger"
     */
        if (liveDocsProducer == null) {
        List<DataFormat> secondaries = new ArrayList<>();
                secondaries.add(format);
            for (Segment segment : segments) {
                }
        this.primaryFormat = compositeDataFormat.getPrimaryDataFormat();
                + " rows";
                + " bits but segment has "
     * Two-phase merge: phase 1 freezes the live-docs producer's snapshot via {@link #prepareMerge};
            long expected = totalRowsForSegment(seg);
    }
        Set<DataFormat> allFormats = new LinkedHashSet<>();
                + " has "
    /**
        this.executor = new CompositeMergeExecutor(buildMergerMap(engine));
            }
                    mergeInput.newWriterGeneration(),
import org.opensearch.composite.CompositeIndexingExecutionEngine;
        this.secondaryFormats = resolveSecondaryFormats(compositeDataFormat, primaryFormat);
 * compatible open source license.
        allFormats.add(primaryFormat);
        return StatsRecorder.recordOutcome(() -> {
import java.util.Map;
    }
        return preparation == null ? MergePreparation.EMPTY : preparation;
     * Picks the secondary that owns delete state for merges. Mirrors the registry's single
            );
            filesByFormat.put(format, List.copyOf(files));
            return MergePreparation.EMPTY;
        // recordOutcome: time always, merge_total on success, merge_failures on throw.
 * data formats by delegating to {@link CompositeMergeExecutor}.
     * delete-execution-engine rule: opt-in via {@link Merger#providesMergeLiveDocs()}, at most one,
    }
     * docs are never asked to prepare, so they have nothing to release either.
import org.opensearch.index.engine.dataformat.DataFormat;
import org.opensearch.index.engine.dataformat.Merger;
     * held in a try-with-resources so the producer's pinned state is released on every exit path
    }
                    files.add(wfs);
    private final CompositeMergeExecutor executor;
    private static List<DataFormat> resolveSecondaryFormats(CompositeDataFormat compositeDataFormat, DataFormat primaryFormat) {
        map.put(engine.getPrimaryDelegate().getDataFormat(), primaryMerger);
                producers.add(secondary);
            try (MergePreparation preparation = prepareMerge(mergeInput)) {
    private final List<DataFormat> secondaryFormats;
        }
                    secondaryFormats,
    /** The {@link Merger} of the one secondary whose {@link Merger#providesMergeLiveDocs()} is true, or {@code null}. */
    private static Map<DataFormat, Merger> buildMergerMap(CompositeIndexingExecutionEngine engine) {
import org.opensearch.index.engine.exec.Segment;
import org.opensearch.index.engine.dataformat.MergePreparation;
            }
        return liveDocsProducer != null;
                "Multiple secondary formats provide merge live-docs, expected at most one but found "
            total = Math.max(total, wfs.numRows());
 * A {@link Merger} that orchestrates composite merges across primary and secondary
@ExperimentalApi
                LiveDocs frozenLiveDocs = preparation.liveDocs();
    private final Merger liveDocsProducer;
import org.opensearch.plugin.stats.StatsRecorder;
/*
                assert assertLiveDocsShape(mergeInput.segments(), frozenLiveDocs) : "live-docs shape doesn't match segment row counts";
import java.util.Set;
import org.opensearch.index.engine.exec.WriterFileSet;
        long total = 0L;
     */
import java.util.LinkedHashMap;
import org.opensearch.composite.stats.CompositeShardStatsTracker;
            if (merger == null) {
        allFormats.addAll(secondaryFormats);
 *
        }
    /** Verifies the bitmap has at least as many bits as the segment's row count. */
     * Delegates to the single resolved live-docs producer. Secondaries that do not provide live
                    frozenLiveDocs
                WriterFileSet wfs = segment.dfGroupedSearchableFiles().get(format.name());
        }
import org.opensearch.index.engine.dataformat.MergeResult;
                Map<DataFormat, List<WriterFileSet>> filesByFormat = extractFilesByFormat(mergeInput.segments());
    }
/**
                assert frozenLiveDocs != null : "merger returned null live-docs";
                throw new IllegalStateException("Secondary format [" + secondary.getDataFormat().name() + "] does not provide a Merger");
                + expected
import java.util.ArrayList;
            Merger merger = executor.getMerger(secondary);
    }
        }
                MergePlan plan = new MergePlan(
        for (Segment seg : segments) {
            }
                continue;
 */
 */
package org.opensearch.composite.merge;
import java.util.List;
        for (DataFormat format : allFormats) {
        MergePreparation preparation = liveDocsProducer.prepareMerge(mergeInput);
import org.opensearch.composite.CompositeDataFormat;
        return producers.isEmpty() ? null : executor.getMerger(producers.get(0));
    /**
import org.opensearch.index.engine.dataformat.IndexingExecutionEngine;
 *
    @Override
            if (bits == null) {
    /**
import org.opensearch.index.engine.dataformat.MergeInput;
        }
    }
            }
                + seg.generation()
            long capacity = (long) bits.length * 64L;
        this.liveDocsProducer = resolveLiveDocsProducer(secondaryFormats, executor);
    @Override
import org.opensearch.common.annotation.ExperimentalApi;
        for (IndexingExecutionEngine<?, ?> secondary : engine.getSecondaryDelegates()) {
            );
                    primaryFormat,
    public MergePreparation prepareMerge(MergeInput mergeInput) throws IOException {
            map.put(secondary.getDataFormat(), merger);
     * where its {@code merge()} did not consume it — no explicit abort call for callers to forget.
 * @opensearch.experimental
        List<DataFormat> producers = new ArrayList<>();
     * The bitmap from prepareMerge overrides any {@link MergeInput#liveDocs()} the caller passed in.
            assert capacity >= expected : "live-docs bitmap for gen="
    private static long totalRowsForSegment(Segment seg) {
    private static boolean assertLiveDocsShape(List<Segment> segments, LiveDocs liveDocs) {
        for (var wfs : seg.dfGroupedSearchableFiles().values()) {
            List<WriterFileSet> files = new ArrayList<>();
        return true;
    public MergeResult merge(MergeInput mergeInput) throws IOException {
                + capacity
        return filesByFormat;
                    + producers.stream().map(DataFormat::name).toList()
import java.util.LinkedHashSet;
    }
import java.io.IOException;
        return Map.copyOf(map);
            throw new IllegalStateException(
import java.util.HashMap;
        return List.copyOf(secondaries);
        for (DataFormat secondary : secondaries) {
        }
 * The OpenSearch Contributors require contributions made to
    public CompositeMerger(CompositeIndexingExecutionEngine engine, CompositeDataFormat compositeDataFormat) {
    @Override
        return total;
        Merger primaryMerger = engine.getPrimaryDelegate().getMerger();
import org.opensearch.index.engine.dataformat.LiveDocs;
            if (merger != null && merger.providesMergeLiveDocs()) {
        }, statsTracker::addMergeTimeMillis, statsTracker::incMergeTotal, statsTracker::incMergeFailures);
        if (primaryMerger == null) {
}
 * SPDX-License-Identifier: Apache-2.0
public class CompositeMerger implements Merger {
    public boolean providesMergeLiveDocs() {
     */
    }
        }
    private static Merger resolveLiveDocsProducer(List<DataFormat> secondaries, CompositeMergeExecutor executor) {
        for (DataFormat format : compositeDataFormat.getDataFormats()) {
    }
        Map<DataFormat, List<WriterFileSet>> filesByFormat = new LinkedHashMap<>();
            throw new IllegalStateException(
            }
    private final DataFormat primaryFormat;
