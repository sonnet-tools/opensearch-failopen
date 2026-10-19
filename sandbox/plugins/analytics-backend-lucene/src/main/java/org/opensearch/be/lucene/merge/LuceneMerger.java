                        + ". This may indicate a concurrent commit cleared the segment list."
            generationsToMerge.add(segment.generation());
    }
            }  
        // Build with null mapping; merge() sets it once the primary has produced it.
        // TODO implement primary and integrate the same here  
            // written now so mergedInfo.files() includes it. Otherwise the catalog records
                        + ". Missing segments may have been consumed by a concurrent merge. "
                        + " — segments may have been consumed by a concurrent merge"
            }
                oneMerge.getMergeInfo().info.maxDoc(),
            // second format to diverge from. If a bitmap IS present, some primary already dropped
            stats.incMergeFailures();
 *
                oneMerge = prepared;  
        }  
        } catch (IOException e) {
 * <ol>
    private final MergeIndexWriter indexWriter;
 * <p>Supports the two-phase prepare/execute flow so a primary-format merger can read  
        this.stats = stats;
import org.opensearch.common.annotation.ExperimentalApi;
     * Builds the per-segment live-docs map from a {@link PreparableOneMerge} whose merge
            // If carryOverHardDeletes produced in-memory deletes for the merged segment  
        PreparableOneMerge oneMerge = strategy.createOneMerge(matchingSegments, null, generation);
import java.util.ArrayList;
    public MergePreparation prepareMerge(MergeInput mergeInput) throws IOException {
    private static Map<Long, long[]> packLiveDocsFromMergeReaders(PreparableOneMerge oneMerge) {  
     * readers have been populated by {@link org.apache.lucene.index.MergeIndexWriter#prepareMerge}.
            builder.addFile(file);  
            // Prefer the prepared OneMerge from prepareMerge (its snapshot is what the primary's
     * Builds a {@link WriterFileSet} from the merged segment info.
                    );  
     */
        } finally {
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
            List<SegmentCommitInfo> liveSegments = indexWriter.liveSegmentCommitInfos();
            SegmentCommitInfo mergedInfo = oneMerge.getMergeInfo();
    private final Path storeDirectory;  
            // rows against a snapshot we no longer hold — re-snapshotting here would filter against
            // play: a Lucene-only engine calls merge() directly with ALL_ALIVE and there is no  
        if (liveSegments.isEmpty()) {  
import org.opensearch.index.engine.dataformat.MergeResult;  
    private final class PreparedLuceneMerge implements MergePreparation {
            RowIdMapping rowIdMapping = mergeInput.rowIdMapping();
        return builder.build();
                        + "Found generations: "  
 * Lucene-specific {@link Merger} that merges segments using Lucene's internal  
            logger.debug(
        }
            .directory(storeDirectory)
 *   <li><b>Value rewriting</b> — {@link RowIdRemappingOneMerge#wrapForMerge} wraps each  
 *       on the row ID field) reads the already-remapped values from the wrapped readers.
 *       CodecReader with {@link RowIdRemappingCodecReader} to remap row ID
            // (concurrent deletes that arrived during the merge), force the .liv file to be
        }  
            );  
        }
    private final DataFormat dataFormat;
 */  
                "LuceneMerger: merging {} segments (generations {}) using merge(OneMerge) + IndexSort",
            // a later view, and a delete landing in between silently misaligns the two formats  
                if (mergeInput.liveDocs().allAlive() == false) {
        private final LiveDocs liveDocs;
import org.opensearch.index.engine.dataformat.LiveDocs;  
 *       preserved and the partially-written merged segment is cleaned up.</li>  
     * Finds segments in the given snapshot whose writer generation matches the requested generations.
 * SPDX-License-Identifier: Apache-2.0
        if (matchingSegments.isEmpty()) {
            }  
        try {  
 *       file cleanup via {@code IndexFileDeleter}. If the merge fails, old segments are
import java.util.HashSet;  
                throw new IllegalStateException(
        });
 * this file be licensed under the Apache-2.0 license or a
     */
            throw new IllegalArgumentException("IndexWriter must not be null");  
            // RowIdRemappingOneMerge stamps the writer_generation attribute onto the merged
                        + matchingSegments.stream()
            if (segments.isEmpty()) {
    @Override  
            for (Segment segment : segments) {  
                generationsToMerge
import org.opensearch.index.engine.exec.WriterFileSet;
                );
 *
                        + generationsToMerge.size()  
            }
            } else {
 * <h2>How it works</h2>  
 */
            indexWriter.flushLiveDocsForMergedSegment(mergedInfo);
                            + " received a live-docs bitmap but no merge was prepared via prepareMerge. "  
        }
        }
            if (liveSegments.isEmpty()) {  
import java.io.IOException;  
/**
            // file and survives a writer reopen.
    }
     */  
 * @opensearch.experimental  
                mergeInput.newWriterGeneration(),  
            throw e;  
     */  
            // the next refresh fails with "Catalog segment ... has no matching Lucene leaf".
import org.opensearch.index.engine.dataformat.RowIdMapping;
    private final LuceneMergeStrategy strategy;
    /**  
                            .collect(java.util.stream.Collectors.toList())  
        }  
            return new MergeResult(Map.of(dataFormat, mergedFileSet), outputMapping);  
                        "LuceneMerger.merge for generation "
                    "Expected "
        List<SegmentCommitInfo> matchingSegments = findMatchingSegments(liveSegments, generationsToMerge);  
        PreparedLuceneMerge(LiveDocs liveDocs, long generation) {
        return new PreparedLuceneMerge(LiveDocs.fromPackedBits(packLiveDocsFromMergeReaders(oneMerge)), generation);
/*  
        long start = System.nanoTime();
import org.apache.lucene.index.PreparableOneMerge;
import org.opensearch.index.engine.dataformat.Merger;
            if (genAttr != null && generations.contains(Long.parseLong(genAttr))) {
            // (same row count or not). Fail loudly instead. For the secondary path, the returned
            if (matchingSegments.isEmpty()) {
     * so the bitmap matches the snapshot Lucene's {@code mergeMiddle} will use for physical drops.
     * {@link #close()} delegates to {@link MergeIndexWriter#abortPreparedMerge}, which is a no-op  
                return new MergeResult(Map.of());
                "LuceneMerger: completed merge of {} segments at generation {} ({} docs, {} files)",
import java.util.Set;  
                            + "Re-snapshotting live docs now would filter against a different view than the "
        Set<Long> generationsToMerge = new HashSet<>();  
        for (SegmentCommitInfo sci : liveSegments) {  
import org.apache.logging.log4j.LogManager;
                    "IndexWriter has no segments — cannot proceed with Lucene merge for generations "
                    "No Lucene segments found matching writer generations "  
                    throw new IllegalStateException(  
 *       (stored fields, doc values, postings).</li>  
 *
                            + mergeInput.newWriterGeneration()
import org.opensearch.index.engine.dataformat.DataFormat;
                            .map(sci -> sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE))
            PreparableOneMerge prepared = indexWriter.takePreparedMerge(mergeInput.newWriterGeneration());  
                        + generationsToMerge  
 *
        this.strategy = new SecondaryLuceneMergeStrategy();
        List<SegmentCommitInfo> liveSegments = indexWriter.liveSegmentCommitInfos();
     * Reads the frozen {@code hardLiveDocs} via {@link PreparableOneMerge#packLiveDocsByGeneration}  
     * Owns the reader-pool and deleter references {@link MergeIndexWriter#prepareMerge} pinned.
        List<Segment> segments = mergeInput.segments();
                    rowIdMerge.setRowIdMapping(rowIdMapping);
 *   <li><b>Segment lifecycle</b> — Lucene's internal merge path handles reference-counted
                );  
        this.storeDirectory = storeDirectory;
        return matching;  
            indexWriter.executeMerge(oneMerge, mergeInput.newWriterGeneration());
import static org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE;  
import org.opensearch.index.engine.dataformat.MergePreparation;
            );
        }  
        public LiveDocs liveDocs() {
        for (String file : mergedInfo.files()) {
        return true;  
    private final LuceneShardStatsTracker stats;
        if (segments.isEmpty()) {  
 * compatible open source license.
                );
    /**
        this.indexWriter = indexWriter;
    }
        indexWriter.prepareMerge(oneMerge, generation);
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;  
        }
            if (prepared != null) {
        private final long generation;  
            return MergePreparation.EMPTY;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.index.MergeIndexWriter;  
import org.opensearch.index.engine.exec.Segment;  
                }
            List<Segment> segments = mergeInput.segments();
        List<SegmentCommitInfo> matching = new ArrayList<>();
                        + generationsToMerge
            logger.debug(  
 * {@code merge(OneMerge)} path with IndexSort-based document reordering.
        }
        @Override  
                throw new IOException(
                            + "primary format used; callers must go through prepareMerge first."
            // codec.segmentInfoFormat().write(...) — so the attribute is persisted to the .si
                matchingSegments.size(),
import java.util.concurrent.TimeUnit;
 * </ol>
public class LuceneMerger implements Merger {  
            // SegmentInfo via setMergeInfo, which Lucene invokes immediately before  
            this.generation = generation;
            .addNumRows(mergedInfo.info.maxDoc());
     * once {@link #merge} has taken the prepared state — so holding this in a try-with-resources
@ExperimentalApi
            // bitmap was derived from). A fresh OneMerge is only acceptable when no bitmap is in
 * The OpenSearch Contributors require contributions made to  
                        + " Lucene segments for generations "
        }
            return MergePreparation.EMPTY;
                if (prepared instanceof RowIdRemappingOneMerge rowIdMerge) {  
    public MergeResult merge(MergeInput mergeInput) throws IOException {
    }
import java.util.List;
                throw new IOException(
            Set<Long> generationsToMerge = new HashSet<>();
 *
    /**  
            // Build the merged WriterFileSet from the output segment info  
            RowIdMapping outputMapping = strategy.buildRowIdMapping(oneMerge, mergeInput);
            return genAttr == null ? -1L : Long.parseLong(genAttr);  
            // Delegate RowIdMapping production to the strategy  
    private WriterFileSet buildMergedFileSet(SegmentCommitInfo mergedInfo, long writerGeneration) throws IOException {  
        long generation = mergeInput.newWriterGeneration();  
            return liveDocs;  
        public void close() throws IOException {
    }
        this.dataFormat = dataFormat;  
    }
                matching.add(sci);  
            .writerGeneration(writerGeneration)  
                        + " but found only "  
        return oneMerge.packLiveDocsByGeneration(sci -> {
 *   <li><b>Document ordering</b> — The writer's IndexSort (a {@code SortedNumericSortField}  
        @Override
    }  
                generationsToMerge.add(segment.generation());
    private static final Logger logger = LogManager.getLogger(LuceneMerger.class);
            }
            return MergePreparation.EMPTY;
 *       doc values for the output.</li>
                oneMerge = strategy.createOneMerge(matchingSegments, rowIdMapping, mergeInput.newWriterGeneration());
     * around the merge releases the pins only on the path where the merge never ran.
import java.nio.file.Path;
                matchingSegments.size(),  
            if (matchingSegments.size() != generationsToMerge.size()) {  
import org.apache.lucene.index.SegmentCommitInfo;
            // a file set without .liv, but a later flush writes the .liv onto disk — and  
    @Override  
            }  
            PreparableOneMerge oneMerge;
                }
    }
            stats.incMergeTotal();
    private List<SegmentCommitInfo> findMatchingSegments(List<SegmentCommitInfo> liveSegments, Set<Long> generations) {
}
            this.liveDocs = liveDocs;  
 *       {@code MultiSorter.sort()} uses these to build DocMaps that reorder all data
            stats.addMergeTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
            WriterFileSet mergedFileSet = buildMergedFileSet(mergedInfo, mergeInput.newWriterGeneration());
                        + generationsToMerge
        for (Segment segment : segments) {
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
                        + matchingSegments.size()
import org.opensearch.index.engine.dataformat.MergeInput;
            }
        WriterFileSet.Builder builder = WriterFileSet.builder()
    public LuceneMerger(MergeIndexWriter indexWriter, DataFormat dataFormat, Path storeDirectory, LuceneShardStatsTracker stats) {
    @Override
    /**
                oneMerge.getMergeInfo().files().size()
    public boolean providesMergeLiveDocs() {
            indexWriter.abortPreparedMerge(generation);
 * Lucene's frozen live-docs snapshot before {@code mergeMiddle} runs.
package org.opensearch.be.lucene.merge;
            List<SegmentCommitInfo> matchingSegments = findMatchingSegments(liveSegments, generationsToMerge);
        if (indexWriter == null) {
import java.util.Map;
