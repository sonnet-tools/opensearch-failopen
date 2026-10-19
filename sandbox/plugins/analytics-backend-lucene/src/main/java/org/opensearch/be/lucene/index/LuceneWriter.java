                            + docCount  
    private final long writerGeneration;
        long totalFlushDurationMs = 0;
            return null; // no automatic merges  
            segmentCommitInfo.getDocValuesGen(),  
    @Override
            iwc.setMergePolicy(NoMergePolicy.INSTANCE);  
            // We are taking control here hence not allowing any merge to happen automatically.
        segmentInfos.remove(segmentCommitInfo);  
        directory.deleteFile(siFileName);
        IndexWriterConfig iwc = analyzer != null ? new IndexWriterConfig(analyzer) : new IndexWriterConfig();
import org.apache.lucene.store.AlreadyClosedException;
            originalInfo.getCodec(),
/**
     * </ul>  
            for (String file : directory.listAll()) {
        }
            }
     *  
        if (indexSort != null) {
    }
 *  
            // need to either configure index.sort.field or avoid the rollback path.  
import org.apache.logging.log4j.Logger;
import org.apache.lucene.index.SortedNumericDocValues;  
                    throw new AssertionError(
        if (discarded > 0) {  
        // Two flush triggers wired in via overridable hooks:  
        }, stats::addIndexTimeMillis);
                            + mapping.size()
            }  
            }  
                public int newToOld(int docID) {
            if (segments.isEmpty()) {
     * I/O fault) and {@link IllegalArgumentException} (per-doc rejection from
                    );
            return;  
 *
            // layer, but we re-check here so a single-format Lucene path is also protected.  
                            + ", expected "  
     * Hook for tests to override the IndexWriter max-buffered-docs threshold.
    }  
            } else {
     * Hook for tests to override the IndexWriter RAM buffer size. Default is
                        "RowIdMapping size ["  
        }
        try {
     * so the I/O cost is paid only when assertions are enabled (tests, dev, CI).
import org.apache.lucene.analysis.Analyzer;  
     * the partial slot and the writer moved to {@link WriterState#PENDING_ROLLBACK}; the caller must
            MergeContext mergeContext
        LuceneDataFormat dataFormat,
import org.opensearch.index.engine.dataformat.WriteResult;
                indexWriter.addDocument(input.getFinalInput());
import java.io.IOException;
                @Override  
     * Applies buffered insertion-row deletes as liveDocs-only deletes, preserving physical row  
            return FileInfos.empty();  
                totalFlushDurationMs = TimeValue.nsecToMSec(System.nanoTime() - flushStart);
        try (DirectoryReader reader = DirectoryReader.open(indexWriter)) {
            // Maps insertion row ids to final doc ids after primary-format sorting.
            } catch (IOException | IllegalArgumentException e) {  
import org.apache.lucene.index.DirectoryReader;
                            + insertionRowId  
            segmentCommitInfo.getSoftDelCount(),  
     * {@link #maxBufferedDocs()} value, so doc count alone drives spilling
        // Delete the existing .si file before rewriting — Lucene's createOutput
     */  
     * the merge according to the Parquet sort order.
        }
                .addNumRows(docCount);
        );
                configureSortedMerge(mapping, state == WriterState.RETIRED_FLUSHABLE);  
                            + ") on writer generation ["
            // The segment is always sorted by __row_id__ — either naturally (docs  
        logger.info("Creating directory for temp lucene writer: " + tempDirectory);  
                state = WriterState.PENDING_ROLLBACK;
        try {
                }
    }
     * row ID rewrite to fire).
import org.apache.lucene.index.IndexWriter;
    }  
    /** Large RAM buffer to avoid intermediate segment flushes within a single writer in production. */  
     *
                            + docId  
                    "Field [" + LuceneDocumentInput.ROW_ID_FIELD + "] missing from segment for writer generation [" + writerGeneration + "]"
            if (flushInput.hasRowIdMapping()) {  
     */  
        state = WriterState.RETIRED_FLUSHABLE;  
            sortedInfo,
     * (because the writer operates without IndexSort to allow OneMerge.reorder()).  
     * rewrite during a sorted flush. It guards the 1:1 offset correspondence with the
    /**
    /** Segment info attribute key storing the writer generation for post-addIndexes correlation. */  
        long bufferedPositionalDeletes = positionalDeleteCount.get() * BYTES_PER_POSITIONAL_DELETE;
        SegmentInfo originalInfo = segmentCommitInfo.info;
                    wfsBuilder.addFile(file);
                            + rowId
        }
import org.apache.lucene.document.NumericDocValuesField;
                // Lucene's IndexWriter may have consumed a docId before throwing; advance our
    /**  
    protected int maxBufferedDocs() {
            super.setMergeInfo(info);
    /**  
            try {  
                        "RowIdMapping should not be available when child IndexWriter is configured with IndexSort ["
            // from rollbackTo are expunged by the reordering forceMerge (secondary path)  
                            + writerGeneration
        }
                commitDurationMs,
     * @throws IOException if rewriting fails
        public MergeSpecification findForcedMerges(
import java.util.concurrent.Executor;
            logger.debug(
            indexWriter.close();
import org.apache.lucene.index.MergePolicy;  
import java.util.List;
import org.apache.lucene.index.IndexWriterConfig;  
     *  
        return StatsRecorder.recordTimeMillis(() -> {
     * @param writerGeneration the writer generation number  
     * @throws IOException if force merge, commit, or file listing fails  
        return mappingVersion;
            IOUtils.rm(tempDirectory);
                );  
    /** {@inheritDoc} Returns the writer generation number assigned at construction. */  
            try {
     * segment was produced naturally (docs added sequentially) or via reorder + row ID  
         */
            return null;  
                "flush: forceMerge complete: generation={}, docCount={}, duration={}ms",
 * After flush, the returned {@link FileInfos} contains the temp directory path so that
                + "]";
                            + ") for writer generation ["
        return writerGeneration;  
            state = WriterState.RETIRED_FLUSHABLE;
     * Buffers an insertion row id to be marked deleted during this writer's flush.  
 * the 1:1 offset correspondence with Parquet.  
     * <p>This method is invoked from the constructor, so overrides must be
                    if (docID == rowIdToPurge) {  
     * @param mapping insertion-to-final-doc-id mapping, or {@code null} when unsorted  
     * stateless (return a constant) — they cannot depend on any instance fields.  
import org.opensearch.plugin.stats.StatsRecorder;
            this.rowIdToPurge = rowIdToPurge;
     *
     * and deleting the temp directory. Safe to call multiple times.
                if (file.startsWith("segments") == false && file.equals("write.lock") == false) {  
                Sort configuredIndexSort = indexWriter.getConfig().getIndexSort();
     * {@link #RAM_BUFFER_SIZE_MB}, large enough that production accumulates all  
         * @param mapping the sort permutation to apply during merge, or null for a plain
                    return (int) mapping.getNewRowId(docID, RowIdMapping.SINGLE_GEN);  
import org.apache.lucene.search.SortField;  
            originalInfo.getUseCompoundFile(),  
     * MergePolicy that unconditionally forces a merge of all segments on {@code forceMerge},  
            long currentDocId = docCount;  
        Analyzer analyzer,  
        long flushStart = System.nanoTime();  
            if (bufferedRowId >= rowCount) {
     * addIndexes(Directory...) on the shared writer sees matching sort metadata.
        if (rowCount > docCount) {  
    private final LuceneShardStatsTracker stats;
        segmentInfos.add(newCommitInfo);
            // branch uses NoMergePolicy, so forceMerge is a no-op and the tombstone remains.
     * alignment with Parquet.
        } catch (IOException e) {  
            throw new IllegalStateException(
                            + configuredIndexSort  
                indexWriter.rollback();  
    }
     * @param codec            the codec to use, or null for default
            originalInfo.getMinVersion(),  
            // - No sort: docs added sequentially, row IDs naturally sequential
                long rowId = rowIdDV.nextValue();  
        positionalDeletes.add(insertionRowId);  
import org.apache.lucene.util.RamUsageEstimator;  
            WriterFileSet.Builder wfsBuilder = WriterFileSet.builder()
    public WriteResult addDoc(LuceneDocumentInput input) throws IOException {  
                            + "] does not match document count ["
                spec.add(new ReorderingOneMerge(segments, mapping, rowIdToPurge));  
                // counter to match so rollbackTo can tombstone the partial slot, and
            throw new AssertionError("Failed to verify ___row_id__ invariant for writer generation [" + writerGeneration + "]", e);
                throw new AssertionError(
        }
                            + "]; segment must not have merged under NoMergePolicy"  
 */  
                @Override
            throw new IllegalStateException("rollbackTo requires ACTIVE or PENDING_ROLLBACK state but was " + state);
     * @return file infos containing the temp directory path and segment file names,
         *                rewrite merge (used when Lucene's IndexSort already sorted the docs)  
        }
    }
            this.rowIdToPurge = rowIdToPurge;
        LuceneShardStatsTracker stats
                // Map insertion order to the final doc id; unsorted segments use identity.
 * Each instance owns its own {@link IndexWriter} and {@link Directory}. Documents are
            return spec;
        segmentInfos.commit(directory);
    @Override
            if (mapping != null && mapping.isNewToOldSupported() == false) {  
     * then invoke {@link #rollbackTo(long)}. Anything else (e.g.
    /** Drains {@link #positionalDeletes}, releasing the accounted heap. */
                if (flushInput.hasRowIdMapping()) {  
     * spill points.
 * (the writer pool in {@code DataFormatAwareEngine} locks the writer during use).  
import java.util.concurrent.ConcurrentLinkedQueue;
                    throw new IllegalStateException(
import java.util.Set;  
            }  
     * @return {@code true} if all row IDs are sequential, {@code false} otherwise
            MergeSpecification spec = new MergeSpecification();
            logger.debug(  
                        return rowIdToPurge;
            }
            logger.warn("Failed to rollback IndexWriter for generation[{}]: {}", writerGeneration, e);  
                    }
     * After flush, the IndexWriter and Directory are closed. The temp directory files remain  
     *
        if (docCount - rowCount != 1) {
        this.indexWriter = new IndexWriter(directory, iwc);  
            originalInfo.getDiagnostics(),  
import org.opensearch.common.annotation.ExperimentalApi;  
            } else if (indexWriter.getConfig().getIndexSort() != null) {
                            + "]"  
     * Parquet file for the same writer generation.
import org.apache.lucene.codecs.Codec;
                            + writerGeneration
 * shared {@link LuceneCommitter} writer via {@code addIndexes}.
                throw new IllegalStateException("addDoc requires ACTIVE state but was " + state);  
        if (rowCount == docCount) {  
            // - Lucene primary with IndexSort: Lucene sorts natively + row ID rewrite  
                            + "] for writer generation ["
    }  
        return bufferedPositionalDeletes;  
            // Common path: forceMerge to 1 segment, commit, build FileInfos  
                docCount,
            state = WriterState.CLOSED;  
        @Override  
                deleted++;  
            sort  
                directory.close();
                // forceMerge, but __row_id__ values were assigned at insertion time and will  
        // The flush() caller has already asserted segmentInfos.size() == 1, so removing
                throw new IllegalStateException("rowId [" + input.getRowId() + "] does not match doc count [" + docCount + "]");
            // Build the WriterFileSet pointing to the temp directory
                if (rowIdDV.advanceExact(docId) == false) {
                            + LuceneDocumentInput.ROW_ID_FIELD  
        Set<LuceneWriter> registry,  
        sortedInfo.setFiles(originalInfo.files());
            docCount++;
            originalInfo.name,
    public FileInfos flush(FlushInput flushInput) throws IOException {  
        // - ramBufferSizeMB(): RAM-buffer based flushing. Default 256 MB so production
import org.opensearch.index.engine.dataformat.WriterState;  
                }
                }
}  
            positionalDeleteCount.decrementAndGet();  
                }  
     * @throws IllegalStateException if a mapped doc id cannot be resolved
            );  
            directory.close();  
            // If sort permutation is provided, configure the reorder merge policy
                    return mapping.size() + (rowIdToPurge != -1 ? 1 : 0);
     * @param indexSort        the index sort to apply (null when Lucene is secondary format)  
 *
            discardBufferedPositionalDeletes();
            }
                "rollbackTo supports rolling back exactly 1 doc, but asked to roll back " + (docCount - rowCount)  
            segmentCommitInfo.getId()
     * {@code IndexingChain}, e.g. oversized term, missing binary value, duplicate term) are
    }
            // Add all files in the segment
            }
     *   <li>Lucene secondary with sort permutation from Parquet: mapping is non-null,
            assert reader.leaves().size() == 1 : "expected exactly 1 segment after forceMerge, got " + reader.leaves().size();
    private volatile boolean positionalDeletesSealed;  
            registry.remove(this);
                    );
        // the original SegmentCommitInfo expresses intent better than clear() + add().
import org.opensearch.common.util.io.IOUtils;
            return FileInfos.builder().putWriterFileSet(dataFormat, wfsBuilder.build()).build();  
        SegmentInfo sortedInfo = new SegmentInfo(  
            originalInfo.dir,
    ) + RamUsageEstimator.alignObjectSize(RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + (long) Long.BYTES);  
                        "Non-sequential "  
    @Override  
            stats.incFlushTotal();
        ReorderingMergePolicy(RowIdMapping mapping, int rowIdToPurge) {
        indexWriter.deleteDocuments(NumericDocValuesField.newSlowExactQuery(DocumentInput.ROW_ID_FIELD, rowCount));  
                // close() removes the temporary directory.
    private volatile WriterState state = WriterState.ACTIVE;
            } else {
                .directory(tempDirectory)  
    }
        }
     */
                }
    }  
     * Default is {@link IndexWriterConfig#DISABLE_AUTO_FLUSH}, so production
    /**
            LeafReader leaf = reader.leaves().get(0).reader();
     * independent of JVM/Lucene version and per-doc encoding size.  
 * Per-generation Lucene writer that creates segments in an isolated temporary directory.  
            // This prevents IndexFileDeleter from removing our rewritten segments_N  
                public int oldToNew(int docID) {
     * and return a small value (e.g. 20) here to force exact, version-independent
     * @param segmentInfos the current committed SegmentInfos  
import org.apache.lucene.search.Sort;
     * docs into a single in-memory segment before flush.
        this.stats = stats;  
        String siFileName = originalInfo.name + ".si";  
                            + "]"  
                        return rowIdToPurge;  
        }
                // Lucene is primary with IndexSort: Lucene natively reorders docs during
     * Hook for tests to wrap the underlying {@link Directory} (e.g., to inject I/O
        this.directory = createDirectory(tempDirectory);
 * (0-based sequential within this writer). This is asserted during flush to ensure
import java.util.Map;  
                        "Doc ["  
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            Map<SegmentCommitInfo, Boolean> segmentsToMerge,
                    );  
import org.opensearch.index.engine.dataformat.DocumentInput;  
    public void cleanupTempDirectory() {  
                // be scrambled after sort. Force a merge so the codec rewrites row IDs to
            discarded++;
            LeafReader leaf = reader.leaves().get(0).reader();  
                    );
            // without an IndexSort and a rollbackTo has run — the no-sort/no-mapping  
                }
     * even if there is only one segment. When a {@link RowIdMapping} is provided, the merge
        int discarded = 0;
import org.apache.lucene.index.LeafReader;
 * added via {@link #addDoc(LuceneDocumentInput)}, and on {@link #flush(FlushInput)}, the writer  
                docCount,  
import org.apache.lucene.search.SortedNumericSortField;
@ExperimentalApi
        Files.createDirectories(tempDirectory);
     * After the child writer commits, the segment on disk has no IndexSort metadata
            }
            }
            return new WriteResult.Success(1L, 1L, currentDocId);  
    private void configureSortedMerge(RowIdMapping mapping, boolean hasRolledBack) {  
     * <ul>
    public WriterState state() {
            // Verify the invariant: exactly 1 segment with docCount documents
     * mechanism with a custom SortField that remaps {@code ___row_id} values through the  
import java.util.Optional;
    private final LuceneDataFormat dataFormat;  
            flushed = true;  
import org.apache.lucene.store.Directory;  
            // Stamp the IndexSort on the segment metadata post-commit so that
    private final Set<LuceneWriter> registry;
            originalInfo.maxDoc(),
            sealPositionalDeletes();
     */  
        logger.debug("applyPositionalDeletes: generation={}, marked {} row(s) deleted (liveDocs-only)", writerGeneration, deleted);  
        private final int rowIdToPurge;
        long mappingVersion,  
    }
    /**
            segmentCommitInfo.getDelCount(),
        }
    }
     * as a {@link Sorter.DocMap}. This causes Lucene to physically reorder docs during  
                mapping = flushInput.rowIdMapping();  
        }  
                docCount,  
                }
    /**
            iwc.setMergePolicy(new LogByteSizeMergePolicy());
        }
import org.apache.lucene.index.SegmentInfo;
            indexWriter.commit();
            // TODO: this assertion will trip if Lucene is configured as the primary format
                if (indexWriter.tryDeleteDocument(leaf, (int) position) == -1) {
        }
     *  
        return new MMapDirectory(tempDirectory);
                + writerGeneration
/*  
        // does not overwrite existing files.
        try (DirectoryReader reader = DirectoryReader.open(directory)) {
     * <p>This policy is used in two scenarios:  
 * The OpenSearch Contributors require contributions made to  
                writerGeneration,
                    );
    }  
                return bufferedPositionalDeletes + indexWriter.ramBytesUsed();
    }
                            + " for writer generation ["
import org.apache.lucene.index.LogByteSizeMergePolicy;
        } else {
                    return (int) mapping.getOldRowId(docID);
            assert reader.leaves().size() == 1 : "Expected exactly 1 leaf reader, got " + reader.leaves().size();  
                            + " at docId="
            int maxDoc = leaf.maxDoc();
        iwc.setRAMBufferSizeMB(ramBufferSizeMB());
    /**
    public long mappingVersion() {  
            SegmentCommitInfo segmentInfo = segmentInfos.info(0);
        discardBufferedPositionalDeletes();
            }
     * translated to {@link WriteResult.Failure}, with {@code docCount} advanced to capture  
     *         or {@link FileInfos#empty()} if no documents were added
        }
            if (flushInput.hasRowIdMapping()) {
        if (newVersion > this.mappingVersion) {  
            logger.debug("discarded {} late positional delete(s) for generation={}", discarded, writerGeneration);
            // addIndexes(Directory...) on the shared writer sees matching sort.
     *       reordered docs, but the merge is needed to trigger the codec's row ID rewrite.</li>
     */
     * However, the segment is logically sorted by __row_id__ (either naturally sequential
    private final Directory directory;  
     * <p>
     * Force-merges all buffered documents into exactly one segment, commits the IndexWriter,  
        // Close the IndexWriter and Directory if they haven't been closed by flush()  
            logger.debug("flush: commit complete: generation={}, duration={}ms", writerGeneration, commitDurationMs);  
package org.opensearch.be.lucene.index;
            }
import org.apache.lucene.store.MMapDirectory;
            super(segments);
     * <p>This method is intended to be invoked from inside an {@code assert} statement
            if (indexWriter.isOpen()) {
            if (mergeDone) {
        Codec currentCodec = indexWriter.getConfig().getCodec();
     * @param segmentCommitInfo the single segment's commit info
        // Replace the segment in SegmentInfos and re-commit so segments_N is consistent.  
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
                    if (docID == rowIdToPurge) {
            if (segmentInfos.size() == 0) {  
        });
    private void applyPositionalDeletes(RowIdMapping mapping) throws IOException {
            totalFlushDurationMs = TimeValue.nsecToMSec(System.nanoTime() - flushStart);
                    throw new IllegalStateException(
 *
                            + LuceneDocumentInput.ROW_ID_FIELD
            }  
    /**  
                            + "] missing "
        }
                            + " (insertionRowId="
                return true;
     * the expected sort, rewrites the .si file, and re-commits the SegmentInfos so that  
                }
import org.opensearch.be.lucene.LuceneDataFormat;
                throw new IllegalArgumentException("RowIdMapping must support reverse lookup (newToOld) for sorted flush reordering");
                // retire to preserve the docId == rowId invariant for subsequent writes.  
    }
                writerGeneration,
    public boolean isSchemaMutable() {
        @Override
            for (int i = 0; i < segmentInfos.size(); i++) {
            // or by LogByteSizeMergePolicy's forceMerge (primary-with-indexSort path).
            }
     */
     * {@link #ramBufferSizeMB()} to a very large value (e.g. {@code 1024.0})  
     * Rewrites the segment's .si file and segments_N commit to declare the IndexSort.  
    }  
    public void updateMappingVersion(long newVersion) {
        } catch (Exception e) {
                    );
import java.util.ArrayList;
     * stateless (return a constant) — they cannot depend on any instance fields.
    @Override
        public MergeSpecification findForcedDeletesMerges(SegmentInfos segmentInfos, MergeContext mergeContext) {
            if (state != WriterState.ACTIVE) {
     */
                stats.incDocsIndexedFailures();  
import org.opensearch.index.engine.dataformat.FlushInput;
        if (positionalDeletes.isEmpty()) {
            return Optional.of(this);
        if (LuceneDataFormat.LUCENE_FORMAT_NAME.equals(formatName)) {
     * <p>If the {@link FlushInput} carries a sort permutation from the primary data format
     * <p>This method is invoked from the constructor, so overrides must be
    private volatile long docCount;
     * also reorders docs via {@link ReorderingOneMerge}. When mapping is null, a plain
        }
                spec.add(new MergePolicy.OneMerge(segments));
        if (indexWriter.isOpen()) {
 */  
        private final int rowIdToPurge;
     * Asserts that the {@code ___row_id} doc values in the freshly committed segment
        return Optional.empty();
        this.writerGeneration = writerGeneration;  
                    throw new IllegalStateException(
     */
            originalInfo.getAttributes(),
                "flush: DONE generation={}, totalRows={}, forceMerge={}ms, commit={}ms, total={}ms",
        public MergeSpecification findMerges(MergeTrigger mergeTrigger, SegmentInfos segmentInfos, MergeContext mergeContext) {
    private final Path tempDirectory;
     *       docs are reordered to match Parquet's sort order.</li>  
            stats.addDocsIndexed(1);
                            + docId
     * and returns a {@link FileInfos} describing the resulting segment files in the temp directory.
            }
        @Override
                docCount++;
            while ((insertionRowId = positionalDeletes.poll()) != null) {
    @Override
                return null; // already done, stop the loop
    private static final double RAM_BUFFER_SIZE_MB = 256.0;
        originalInfo.getCodec().segmentInfoFormat().write(directory, sortedInfo, IOContext.DEFAULT);
        public void setMergeInfo(SegmentCommitInfo info) {
                            + writerGeneration  
    public void rollbackTo(long rowCount) throws IOException {
        this.dataFormat = dataFormat;
        try {
import org.opensearch.index.engine.dataformat.FileInfos;
 * The writer uses a large RAM buffer (256 MB by default) to minimize the chance of
                    throw new AssertionError(
    private static final long BYTES_PER_POSITIONAL_DELETE = RamUsageEstimator.alignObjectSize(
            iwc.setIndexSort(indexSort);  
        // maxBufferedDocs() to a small value (e.g. 20) to force exact spill points  
            int maxSegmentCount,  
     */
                if (rowId != docId) {
            StatsRecorder.recordTimeMillis(() -> indexWriter.forceMerge(1, true), stats::addFlushForceMergeTimeMillis);
        iwc.setMaxBufferedDocs(maxBufferedDocs());  
    static class ReorderingOneMerge extends MergePolicy.OneMerge {  
    /**
        // multi-segment paths override ramBufferSizeMB() to Double.MAX_VALUE and
                }  
     * Adds a document to the underlying {@link IndexWriter}. {@link IOException} (low-level  
            return true;
import org.apache.logging.log4j.LogManager;
    public long generation() {
            originalInfo.getId(),
 * SPDX-License-Identifier: Apache-2.0
                    }
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.index.SegmentCommitInfo;  
        }
                            + "] for writer generation ["
        } finally {  
        indexWriter.getConfig().setMergePolicy(new ReorderingMergePolicy(mapping, hasRolledBack ? mapping.size() : -1));
     */  
        Sort sort = new Sort(new SortedNumericSortField(LuceneDocumentInput.ROW_ID_FIELD, SortField.Type.LONG));  
        SegmentCommitInfo newCommitInfo = new SegmentCommitInfo(  
    }
    private volatile boolean flushed;  
import org.opensearch.index.engine.dataformat.Writer;
     *
        private volatile boolean mergeDone = false;
import org.opensearch.index.engine.dataformat.RowIdMapping;  
 * Lucene segment and the corresponding Parquet file for the same writer generation.
    }  
    private void rewriteSegmentInfoWithSort(SegmentInfos segmentInfos, SegmentCommitInfo segmentCommitInfo) throws IOException {
                logger.debug("Overriding segment info manually");  
                positionalDeleteCount.decrementAndGet();  
                // Lucene drops a fully deleted segment. Return no files and leave `flushed` false so
            // - Lucene secondary: docs reordered via OneMerge.reorder() + row ID rewrite
     * Configures the child writer for sorted flush: sets a ReorderingMergePolicy
                totalFlushDurationMs  
        } catch (IOException e) {  
    @Override  
                forceMergeDurationMs
            }
        );
        Path baseDirectory,
                // sequential 0..N-1 in the final doc order.
        // - maxBufferedDocs(): doc-count based flushing. Default DISABLE_AUTO_FLUSH so  
                assert position >= 0 : "positional delete resolved to a negative row id (insertionRowId=" + insertionRowId + ")";  
                        "tryDeleteDocument failed for position="  
            directory.close();
     * value (e.g. {@code 1024.0}) together with a small
    private void discardBufferedPositionalDeletes() {  
        }
     * constructor with the writer's per-generation temp directory.
     *
public class LuceneWriter implements Writer<LuceneDocumentInput> {
        docCount = rowCount;
        ReorderingOneMerge(List<SegmentCommitInfo> segments, RowIdMapping mapping, int rowIdToPurge) {
        }  
 * performs a force merge to exactly 1 segment to maintain a 1:1 mapping between the
            List<SegmentCommitInfo> segments = new ArrayList<>();  
            assert segmentInfos.size() == 1 : "Expected exactly 1 segment after force merge, got " + segmentInfos.size();
                public int size() {  
     * or via reorder + row ID rewrite). This method reconstructs the SegmentInfo with
    public void close() throws IOException {
     * Deletes the temporary directory created by this writer. Called externally by the
            logger.warn("Failed to delete lucene temp directory [{}]: {}", tempDirectory, e.getMessage());
import org.apache.lucene.index.CodecReader;  
     *  
        private final RowIdMapping mapping;
            this.mapping = mapping;  
     * Closes this writer, rolling back the IndexWriter if still open, closing the directory,
                return new WriteResult.Failure(e, -1L, -1L, -1L);
                            + "]"  
    /**
            for (int docId = 0; docId < maxDoc; docId++) {  
     * @throws IOException if cleanup fails
    private final IndexWriter indexWriter;
     * <p>Tests exercising the multi-segment merge path should override
                flushInput.hasRowIdMapping()
 * intermediate flushes, since all writes to a single writer come from a single thread
     * @param mappingVersion   the initial mapping version
            };  
     *
            return new Sorter.DocMap() {  
     * that forces a merge of all segments (with optional doc reordering via the mapping).  
     *  
import java.util.Queue;
     * {@code OneMerge} is used (the merge still rewrites the segment, enabling the codec's  
    public static final String WRITER_GENERATION_ATTRIBUTE = "writer_generation";
        }
            }  
        return RAM_BUFFER_SIZE_MB;  
        } finally {
            assert assertRowIdsSequential(directory) : "___row_id__ doc values not sequential after forceMerge for writer generation ["  
            segmentCommitInfo.getFieldInfosGen(),
            logger.warn("Failed to close directory for generation[{}]: {}", writerGeneration, e);
                return null;
        this.tempDirectory = baseDirectory.resolve("lucene_gen_" + writerGeneration);
                            + writerGeneration
    /**
                            + writerGeneration
    private long mappingVersion;
            SegmentInfos segmentInfos,
    }
     */
import org.apache.lucene.index.NoMergePolicy;
 * Row ID invariant: Each document must have a {@code __row_id__} field set via  
     */
    /**
        while (positionalDeletes.poll() != null) {
            );
                logger.debug("flush: generation={} has no surviving rows ({} deleted); contributing no files", writerGeneration, docCount);  
    public LuceneWriter(
import org.opensearch.common.unit.TimeValue;
                            + docId
        }
                            + "]"
                forceMergeDurationMs,
            // After flush the segment must contain exactly docCount live docs. Any tombstones
            // file (which it wouldn't recognize as its own commit).
        RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + 2L * RamUsageEstimator.NUM_BYTES_OBJECT_REF
     * {@link org.apache.lucene.store.AlreadyClosedException} after a tragic event) propagates.  
        }
    }
     * @param analyzer         the analyzer to use for tokenized fields, or null for default
     */
    @Override
    }
    public Optional<Writer<?>> getWriterForFormat(String formatName) {  
        iwc.setCodec(new LuceneWriterCodec(codec, writerGeneration));
     * Row ID rewrite is already enabled on the codec at construction time.
    public void recordPositionalDelete(long insertionRowId) {  
        return true;
        long writerGeneration,
    /**
            sealPositionalDeletes();
        // independent of JVM/Lucene version.
            assert segmentInfo.info.maxDoc() == docCount : "Expected " + docCount + " docs in segment, got " + segmentInfo.info.maxDoc();
 * {@link LuceneIndexingExecutionEngine#refresh} can incorporate the segment into the  
     * Returns the underlying writer for the specified data format name.  
        return state;
    public long getHeapBytesUsed() {  
                if (configuredIndexSort != null) {  
        Sort indexSort,
    ) throws IOException {
            return;
        registry.add(this);
        // Rewrite the .si file with sort metadata  
 *
    /**  
        // Reconstruct SegmentInfo with the IndexSort declared
                rewriteSegmentInfoWithSort(segmentInfos, segmentInfo);
     * on disk for {@link LuceneIndexingExecutionEngine#refresh} to incorporate via
    private final AtomicInteger positionalDeleteCount = new AtomicInteger();
import java.nio.file.Path;  
        // Create an isolated temp directory for this writer's segment
        }  
import org.opensearch.index.engine.exec.WriterFileSet;
        // Count first so concurrent draining cannot make the count negative.
    /**
            originalInfo.getHasBlocks(),
            );
            lwc.enableRowIdRewrite();
    static class ReorderingMergePolicy extends MergePolicy {
     */
 * compatible open source license.
                .writerGeneration(writerGeneration)
        if (currentCodec instanceof LuceneWriterCodec lwc) {  
     */  
    }
     * are sequential 0..maxDoc-1 in doc order. This invariant must hold whether the
     * <p>
            // This holds in all cases:
            stats.addFlushTimeMillis(totalFlushDurationMs);  
        positionalDeleteCount.incrementAndGet();
        Codec codec,
    @Override
        @Override
            logger.debug(  
    protected Directory createDirectory(Path tempDirectory) throws IOException {  
    /**
                indexWriter.getConfig().setMergePolicy(new LogByteSizeMergePolicy());  
            mergeDone = true;
                        "RowIdMapping must not be provided when IndexSort is configured for writer generation [" + writerGeneration + "]"
            long commitStartNanos = System.nanoTime();  
        @Override  
        public Sorter.DocMap reorder(CodecReader reader, Directory dir, Executor executor) throws IOException {
                return FileInfos.empty();  
     *
     *
        }
        if (docCount == 0) {
                positionalDeleteCount.decrementAndGet();  
                segments.add(segmentInfos.info(i));
     * engine after {@code addIndexes} has hardlinked the segment files into the shared  
     * writer's directory, making the originals safe to remove.
        } catch (Exception e) {
                "flush: START generation={}, docCount={}, hasRowIdMapping={}",
        indexWriter.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
            SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(directory);
                    throw new IllegalStateException(
        ) {  
        sealPositionalDeletes();
            if (input.getRowId() != docCount) {
                            + position
            }
            this.mapping = mapping;  
    @Override
    protected double ramBufferSizeMB() {
                // RowIdMapping shouldn't be available if index has sort configurations.
            originalInfo.getVersion(),
     * {@code addIndexes}.
        if (positionalDeletesSealed) {
    /** Returns heap bytes used by this writer's IndexWriter RAM buffer. Returns 0 after flush. */
            // Close the IndexWriter before rewriting segment metadata.
        try {
    @Override  
     * @throws AssertionError with a descriptive message if I/O fails or the field is missing
     * @param dataFormat       the Lucene data format descriptor
            );
 * @opensearch.experimental
                return bufferedPositionalDeletes;  
        // accumulates docs into a single in-memory segment before flush.
        positionalDeletes.removeIf(bufferedRowId -> {
            if (rowIdDV == null) {  
        }
                if (mapping.size() != docCount) {
        positionalDeletesSealed = true;
            // written sequentially) or via OneMerge.reorder() + row ID rewrite.
     * @param flushInput optional context; if it carries a sort permutation, the segment is sorted  
        }  
import java.nio.file.Files;
            // Wrapped in `assert` so the I/O cost is paid only when assertions are enabled.
     * never flushes based on doc count and relies on {@link #ramBufferSizeMB()}.  
                }
        this.registry = registry;
            // Production never wires Lucene as primary without IndexSort, but tests that do
        this.docCount = 0;
     * faults). Default is a plain {@link MMapDirectory}. Invoked once from the  
            if (flushed == false) IOUtils.rm(tempDirectory);
                @Override
     * Custom OneMerge that overrides {@code reorder()} to provide the sort permutation
            applyPositionalDeletes(mapping);  
            segmentCommitInfo.getDelGen(),
     * permutation. This ensures the Lucene doc order matches the sorted Parquet row order.
 *
    }  
    private boolean assertRowIdsSequential(Directory directory) {
            SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
                            + " (got "
            long forceMergeStartNanos = System.nanoTime();
     * (e.g., Parquet sort-on-close), the Lucene segment is reordered using Lucene's IndexSort
import java.util.concurrent.atomic.AtomicInteger;  
        return IndexWriterConfig.DISABLE_AUTO_FLUSH;
     * @param stats            the shard-level stats collector
     * @throws IOException if directory creation or IndexWriter opening fails
        this.mappingVersion = mappingVersion;
            long commitDurationMs = TimeValue.nsecToMSec(System.nanoTime() - commitStartNanos);
     * <p>For deterministic multi-segment tests, override this to a very large  
        }
                long position = mapping != null ? mapping.getNewRowId(insertionRowId, RowIdMapping.SINGLE_GEN) : insertionRowId;
            // Defense-in-depth: CompositeWriter enforces rowId == docCount at the multiplexer
import org.apache.lucene.store.IOContext;
            RowIdMapping mapping = null;  
     * Creates a new LuceneWriter for the given generation.
        if (state != WriterState.PENDING_ROLLBACK && state != WriterState.ACTIVE) {  
        int deleted = 0;  
            if (mapping != null) {
        /**
            indexWriter.flush();  
            throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + docCount + " docs admitted");
            this.mappingVersion = newVersion;
    /** Row ids to mark deleted during flush. */  
            } catch (AlreadyClosedException e) {
    @Override
            }  
     * @throws IOException if opening the NRT reader or applying a delete fails
 * {@link LuceneDocumentInput#setRowId}. The row ID must equal the Lucene doc ID
import org.apache.lucene.index.SegmentInfos;
            return false;  
        // production never flushes by doc count. Tests that need deterministic
            // Invariant: ___row_id__ doc values must be sequential 0..maxDoc-1 after forceMerge.  
    private final Queue<Long> positionalDeletes = new ConcurrentLinkedQueue<>();
        private final RowIdMapping mapping; // nullable  
import org.apache.lucene.index.Sorter;
     *   <li>Lucene primary with IndexSort: mapping is null, Lucene's native sort already
     * @param baseDirectory    the base directory under which to create the temp directory  
            Long insertionRowId;
                writerGeneration,  
import org.apache.lucene.index.MergeTrigger;
    }  
    /** Heap cost of one queue node and its boxed row ID. */  
            long forceMergeDurationMs = TimeValue.nsecToMSec(System.nanoTime() - forceMergeStartNanos);  
    private void sealPositionalDeletes() {  
            // Apply positional deletes after reordering and before commit.
    private static final Logger logger = LogManager.getLogger(LuceneWriter.class);
     */
    }  
