        // Build with null mapping; merge() sets it once the primary has produced it.
package org.opensearch.be.lucene.merge;
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
            }
                if (prepared instanceof RowIdRemappingOneMerge rowIdMerge) {
import org.opensearch.index.engine.exec.WriterFileSet;
        List<SegmentCommitInfo> matchingSegments = findMatchingSegments(liveSegments, generationsToMerge);
                generationsToMerge
 * Lucene's frozen live-docs snapshot before {@code mergeMiddle} runs.
    }
                throw new IOException(
            logger.debug(
        }
                return new MergeResult(Map.of());
 * </ol>
            if (segments.isEmpty()) {
    private final LuceneMergeStrategy strategy;
        if (indexWriter == null) {
            for (Segment segment : segments) {
 * <ol>
            // Delegate RowIdMapping production to the strategy
        PreparableOneMerge oneMerge = strategy.createOneMerge(matchingSegments, null, generation);
 *       file cleanup via {@code IndexFileDeleter}. If the merge fails, old segments are
import org.opensearch.index.engine.exec.Segment;
                generationsToMerge.add(segment.generation());
    }
 * <p>Supports the two-phase prepare/execute flow so a primary-format merger can read
        }
                            + "Re-snapshotting live docs now would filter against a different view than the "
                        "LuceneMerger.merge for generation "
        return oneMerge.packLiveDocsByGeneration(sci -> {
import java.util.ArrayList;
            return new MergeResult(Map.of(dataFormat, mergedFileSet), outputMapping);
            List<SegmentCommitInfo> liveSegments = indexWriter.liveSegmentCommitInfos();
            WriterFileSet mergedFileSet = buildMergedFileSet(mergedInfo, mergeInput.newWriterGeneration());
import org.opensearch.index.engine.dataformat.MergePreparation;
        @Override
                }
 */
    private final Path storeDirectory;
import org.opensearch.index.engine.dataformat.MergeInput;
 * The OpenSearch Contributors require contributions made to
            );
 *       on the row ID field) reads the already-remapped values from the wrapped readers.
                );
 * {@code merge(OneMerge)} path with IndexSort-based document reordering.
import org.opensearch.index.engine.dataformat.DataFormat;
            return MergePreparation.EMPTY;
 * @opensearch.experimental
        public LiveDocs liveDocs() {
        long start = System.nanoTime();
     * Builds the per-segment live-docs map from a {@link PreparableOneMerge} whose merge
     * {@link #close()} delegates to {@link MergeIndexWriter#abortPreparedMerge}, which is a no-op
                    );
            // bitmap was derived from). A fresh OneMerge is only acceptable when no bitmap is in
            }
            builder.addFile(file);
     * around the merge releases the pins only on the path where the merge never ran.
            indexWriter.executeMerge(oneMerge, mergeInput.newWriterGeneration());
    }
                            .collect(java.util.stream.Collectors.toList())
 */
                        + matchingSegments.size()
            stats.addMergeTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
 *
                throw new IllegalStateException(
            }
                        + " — segments may have been consumed by a concurrent merge"
            stats.incMergeTotal();
                    rowIdMerge.setRowIdMapping(rowIdMapping);
        }
        // TODO implement primary and integrate the same here
    private final class PreparedLuceneMerge implements MergePreparation {
            }
 *
     * Reads the frozen {@code hardLiveDocs} via {@link PreparableOneMerge#packLiveDocsByGeneration}
            return MergePreparation.EMPTY;
            PreparableOneMerge oneMerge;
     * Builds a {@link WriterFileSet} from the merged segment info.
                "LuceneMerger: merging {} segments (generations {}) using merge(OneMerge) + IndexSort",
 * compatible open source license.
        PreparedLuceneMerge(LiveDocs liveDocs, long generation) {
                        + ". Missing segments may have been consumed by a concurrent merge. "
                        + matchingSegments.stream()
                mergeInput.newWriterGeneration(),
        }
    public LuceneMerger(MergeIndexWriter indexWriter, DataFormat dataFormat, Path storeDirectory, LuceneShardStatsTracker stats) {
import java.nio.file.Path;
 *       CodecReader with {@link RowIdRemappingCodecReader} to remap row ID
    public boolean providesMergeLiveDocs() {
            }
            // codec.segmentInfoFormat().write(...) — so the attribute is persisted to the .si
                    "IndexWriter has no segments — cannot proceed with Lucene merge for generations "
                        + generationsToMerge.size()
                        + generationsToMerge
        for (SegmentCommitInfo sci : liveSegments) {
import org.opensearch.index.engine.dataformat.MergeResult;
            if (matchingSegments.size() != generationsToMerge.size()) {
        private final long generation;
            );
 *
        private final LiveDocs liveDocs;
        this.stats = stats;
        } catch (IOException e) {
            return liveDocs;
import org.apache.logging.log4j.LogManager;
        return new PreparedLuceneMerge(LiveDocs.fromPackedBits(packLiveDocsFromMergeReaders(oneMerge)), generation);
        List<SegmentCommitInfo> liveSegments = indexWriter.liveSegmentCommitInfos();
    @Override
     */
    /**
                        + " Lucene segments for generations "
            stats.incMergeFailures();
                if (mergeInput.liveDocs().allAlive() == false) {
        long generation = mergeInput.newWriterGeneration();
 * this file be licensed under the Apache-2.0 license or a
    private List<SegmentCommitInfo> findMatchingSegments(List<SegmentCommitInfo> liveSegments, Set<Long> generations) {
        return builder.build();
            // rows against a snapshot we no longer hold — re-snapshotting here would filter against
            // If carryOverHardDeletes produced in-memory deletes for the merged segment
import java.util.concurrent.TimeUnit;
                        + generationsToMerge
        @Override
            RowIdMapping outputMapping = strategy.buildRowIdMapping(oneMerge, mergeInput);
            // (same row count or not). Fail loudly instead. For the secondary path, the returned
            RowIdMapping rowIdMapping = mergeInput.rowIdMapping();
                oneMerge.getMergeInfo().info.maxDoc(),
                            + mergeInput.newWriterGeneration()
            return genAttr == null ? -1L : Long.parseLong(genAttr);
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
            // file and survives a writer reopen.
            // (concurrent deletes that arrived during the merge), force the .liv file to be
    /**
import java.util.HashSet;
                matching.add(sci);
        if (liveSegments.isEmpty()) {
            // play: a Lucene-only engine calls merge() directly with ALL_ALIVE and there is no
 *       doc values for the output.</li>
            // second format to diverge from. If a bitmap IS present, some primary already dropped
            indexWriter.abortPreparedMerge(generation);
    @Override
import java.util.List;
                        + " but found only "
            // a later view, and a delete landing in between silently misaligns the two formats
                        + "Found generations: "
 *       preserved and the partially-written merged segment is cleaned up.</li>
            this.liveDocs = liveDocs;
     * so the bitmap matches the snapshot Lucene's {@code mergeMiddle} will use for physical drops.
import org.apache.lucene.index.MergeIndexWriter;
        Set<Long> generationsToMerge = new HashSet<>();
            if (prepared != null) {
                matchingSegments.size(),
            logger.debug(
            .directory(storeDirectory)
        return true;
     */
public class LuceneMerger implements Merger {
        }
        }
@ExperimentalApi
 *   <li><b>Document ordering</b> — The writer's IndexSort (a {@code SortedNumericSortField}
        });
        this.storeDirectory = storeDirectory;
        for (String file : mergedInfo.files()) {
    public MergeResult merge(MergeInput mergeInput) throws IOException {
            if (genAttr != null && generations.contains(Long.parseLong(genAttr))) {
            List<Segment> segments = mergeInput.segments();
import org.opensearch.common.annotation.ExperimentalApi;
            }
            // Build the merged WriterFileSet from the output segment info
     * readers have been populated by {@link org.apache.lucene.index.MergeIndexWriter#prepareMerge}.
                        + generationsToMerge
        }
 *       {@code MultiSorter.sort()} uses these to build DocMaps that reorder all data
import org.apache.logging.log4j.Logger;
            List<SegmentCommitInfo> matchingSegments = findMatchingSegments(liveSegments, generationsToMerge);
        List<SegmentCommitInfo> matching = new ArrayList<>();
        List<Segment> segments = mergeInput.segments();
import org.opensearch.index.engine.dataformat.LiveDocs;
            throw new IllegalArgumentException("IndexWriter must not be null");
    }
            SegmentCommitInfo mergedInfo = oneMerge.getMergeInfo();
import static org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE;
            if (matchingSegments.isEmpty()) {
            // written now so mergedInfo.files() includes it. Otherwise the catalog records
    private static Map<Long, long[]> packLiveDocsFromMergeReaders(PreparableOneMerge oneMerge) {
 *   <li><b>Segment lifecycle</b> — Lucene's internal merge path handles reference-counted
        }
                        + ". This may indicate a concurrent commit cleared the segment list."
     * Finds segments in the given snapshot whose writer generation matches the requested generations.
        this.indexWriter = indexWriter;
 *   <li><b>Value rewriting</b> — {@link RowIdRemappingOneMerge#wrapForMerge} wraps each
        }
 * <h2>How it works</h2>
     */
            if (liveSegments.isEmpty()) {
     * once {@link #merge} has taken the prepared state — so holding this in a try-with-resources
import java.util.Set;
                matchingSegments.size(),
/*
                oneMerge = prepared;
            // SegmentInfo via setMergeInfo, which Lucene invokes immediately before
        return matching;
        }
                }
    }
    @Override
 *
                );
            throw e;
        if (segments.isEmpty()) {
 *
        if (matchingSegments.isEmpty()) {
                oneMerge.getMergeInfo().files().size()
            // a file set without .liv, but a later flush writes the .liv onto disk — and
                    "No Lucene segments found matching writer generations "
import org.apache.lucene.index.PreparableOneMerge;
        WriterFileSet.Builder builder = WriterFileSet.builder()
    }
 *       (stored fields, doc values, postings).</li>
        this.strategy = new SecondaryLuceneMergeStrategy();
            generationsToMerge.add(segment.generation());
            .addNumRows(mergedInfo.info.maxDoc());
        } finally {
        indexWriter.prepareMerge(oneMerge, generation);
            .writerGeneration(writerGeneration)
            } else {
                    "Expected "
            PreparableOneMerge prepared = indexWriter.takePreparedMerge(mergeInput.newWriterGeneration());
                throw new IOException(
            // RowIdRemappingOneMerge stamps the writer_generation attribute onto the merged
    private final DataFormat dataFormat;
            indexWriter.flushLiveDocsForMergedSegment(mergedInfo);
        }
    private static final Logger logger = LogManager.getLogger(LuceneMerger.class);
    }
        public void close() throws IOException {
                    throw new IllegalStateException(
                "LuceneMerger: completed merge of {} segments at generation {} ({} docs, {} files)",
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
            }
            // Prefer the prepared OneMerge from prepareMerge (its snapshot is what the primary's
    /**
/**
    private WriterFileSet buildMergedFileSet(SegmentCommitInfo mergedInfo, long writerGeneration) throws IOException {
                );
import org.apache.lucene.index.SegmentCommitInfo;
            // the next refresh fails with "Catalog segment ... has no matching Lucene leaf".
import org.opensearch.index.engine.dataformat.RowIdMapping;
                oneMerge = strategy.createOneMerge(matchingSegments, rowIdMapping, mergeInput.newWriterGeneration());
import org.opensearch.index.engine.dataformat.Merger;
            return MergePreparation.EMPTY;
        try {
            Set<Long> generationsToMerge = new HashSet<>();
import java.util.Map;
 * Lucene-specific {@link Merger} that merges segments using Lucene's internal
    private final LuceneShardStatsTracker stats;
     */
    private final MergeIndexWriter indexWriter;
            this.generation = generation;
    }
                            + " received a live-docs bitmap but no merge was prepared via prepareMerge. "
     * Owns the reader-pool and deleter references {@link MergeIndexWriter#prepareMerge} pinned.
    public MergePreparation prepareMerge(MergeInput mergeInput) throws IOException {
        for (Segment segment : segments) {
                            .map(sci -> sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE))
    /**
}
        this.dataFormat = dataFormat;
                            + "primary format used; callers must go through prepareMerge first."
