    public long mappingVersion() {
import org.opensearch.common.unit.TimeValue;
                writerGeneration,
            } catch (AlreadyClosedException e) {
                }
     * {@link #ramBufferSizeMB()} to a very large value (e.g. {@code 1024.0})
/*
     * <ul>
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.opensearch.index.engine.dataformat.Writer;
     * <p>
    /** Row ids to mark deleted during flush. */
    /**
            assert reader.leaves().size() == 1 : "expected exactly 1 segment after forceMerge, got " + reader.leaves().size();
        LuceneShardStatsTracker stats
        if (currentCodec instanceof LuceneWriterCodec lwc) {
                spec.add(new ReorderingOneMerge(segments, mapping, rowIdToPurge));
     * <p>This method is invoked from the constructor, so overrides must be
                if (flushInput.hasRowIdMapping()) {
import org.apache.logging.log4j.LogManager;
     * @throws IOException if force merge, commit, or file listing fails
                writerGeneration,
import org.apache.logging.log4j.Logger;
        }
                return true;
        try {
                    throw new IllegalStateException(
        if (newVersion > this.mappingVersion) {
            }
        }
        if (discarded > 0) {
            // without an IndexSort and a rollbackTo has run — the no-sort/no-mapping
            segmentCommitInfo.getDelGen(),
     * {@code addIndexes}.
            );
     * permutation. This ensures the Lucene doc order matches the sorted Parquet row order.
     * {@code IndexingChain}, e.g. oversized term, missing binary value, duplicate term) are
                logger.debug("Overriding segment info manually");
                @Override
        }
import java.nio.file.Files;
    }
    public FileInfos flush(FlushInput flushInput) throws IOException {
            if (segmentInfos.size() == 0) {
        }
                            + position
    /** Segment info attribute key storing the writer generation for post-addIndexes correlation. */
    }
                    );
        sortedInfo.setFiles(originalInfo.files());
    private volatile long docCount;
         * @param mapping the sort permutation to apply during merge, or null for a plain
            if (state != WriterState.ACTIVE) {
     */
                        return rowIdToPurge;
                    );
 * performs a force merge to exactly 1 segment to maintain a 1:1 mapping between the
    public static final String WRITER_GENERATION_ATTRIBUTE = "writer_generation";
            // branch uses NoMergePolicy, so forceMerge is a no-op and the tombstone remains.
     */
                        "RowIdMapping should not be available when child IndexWriter is configured with IndexSort ["
                return null;
     * engine after {@code addIndexes} has hardlinked the segment files into the shared
        Set<LuceneWriter> registry,
import org.apache.lucene.index.MergeTrigger;
        return IndexWriterConfig.DISABLE_AUTO_FLUSH;
        SegmentCommitInfo newCommitInfo = new SegmentCommitInfo(
        }
    protected int maxBufferedDocs() {
    @Override
        int deleted = 0;
                .writerGeneration(writerGeneration)
     * Applies buffered insertion-row deletes as liveDocs-only deletes, preserving physical row
        /**
    private void discardBufferedPositionalDeletes() {
     * Closes this writer, rolling back the IndexWriter if still open, closing the directory,
import org.opensearch.common.util.io.IOUtils;
                    );
            // or by LogByteSizeMergePolicy's forceMerge (primary-with-indexSort path).
     * Hook for tests to wrap the underlying {@link Directory} (e.g., to inject I/O
            this.mapping = mapping;
                positionalDeleteCount.decrementAndGet();
                if (rowIdDV.advanceExact(docId) == false) {
    }
                return bufferedPositionalDeletes;
     * row ID rewrite to fire).
                segments.add(segmentInfos.info(i));
                return null; // already done, stop the loop
            sealPositionalDeletes();
     *
        Files.createDirectories(tempDirectory);
     * segment was produced naturally (docs added sequentially) or via reorder + row ID
        }
            flushed = true;
                docCount,
import org.apache.lucene.index.LeafReader;
     * also reorders docs via {@link ReorderingOneMerge}. When mapping is null, a plain
     * Parquet file for the same writer generation.
            if (flushInput.hasRowIdMapping()) {
                throw new IllegalArgumentException("RowIdMapping must support reverse lookup (newToOld) for sorted flush reordering");
            segmentCommitInfo.getSoftDelCount(),
                    if (docID == rowIdToPurge) {
 * compatible open source license.
            long commitStartNanos = System.nanoTime();
        String siFileName = originalInfo.name + ".si";
 * The writer uses a large RAM buffer (256 MB by default) to minimize the chance of
     *
    ) throws IOException {
            stats.addFlushTimeMillis(totalFlushDurationMs);
            sortedInfo,
     * @param mapping insertion-to-final-doc-id mapping, or {@code null} when unsorted
import org.apache.lucene.index.IndexWriter;
     * @param dataFormat       the Lucene data format descriptor
     * @param segmentInfos the current committed SegmentInfos
        );
                            + writerGeneration
                            + " for writer generation ["
     */
        return Optional.empty();
import org.opensearch.be.lucene.LuceneDataFormat;
            StatsRecorder.recordTimeMillis(() -> indexWriter.forceMerge(1, true), stats::addFlushForceMergeTimeMillis);
     *       docs are reordered to match Parquet's sort order.</li>
import org.apache.lucene.store.IOContext;
        }
                return bufferedPositionalDeletes + indexWriter.ramBytesUsed();
        long bufferedPositionalDeletes = positionalDeleteCount.get() * BYTES_PER_POSITIONAL_DELETE;
        // Delete the existing .si file before rewriting — Lucene's createOutput
            // Production never wires Lucene as primary without IndexSort, but tests that do
            if (input.getRowId() != docCount) {
     * then invoke {@link #rollbackTo(long)}. Anything else (e.g.
    }
                    throw new IllegalStateException(
     * Hook for tests to override the IndexWriter RAM buffer size. Default is
        segmentInfos.remove(segmentCommitInfo);
            SortedNumericDocValues rowIdDV = leaf.getSortedNumericDocValues(LuceneDocumentInput.ROW_ID_FIELD);
                // forceMerge, but __row_id__ values were assigned at insertion time and will
    }
import org.apache.lucene.codecs.Codec;
     * never flushes based on doc count and relies on {@link #ramBufferSizeMB()}.
                            + docId
        }
    }
     * @param analyzer         the analyzer to use for tokenized fields, or null for default
    public void rollbackTo(long rowCount) throws IOException {
            return null; // no automatic merges
            originalInfo.getVersion(),
                            + "]"
        originalInfo.getCodec().segmentInfoFormat().write(directory, sortedInfo, IOContext.DEFAULT);
        }
            // written sequentially) or via OneMerge.reorder() + row ID rewrite.
        registry.add(this);
                            + " at docId="
        @Override
            logger.debug("discarded {} late positional delete(s) for generation={}", discarded, writerGeneration);
    /**
            LeafReader leaf = reader.leaves().get(0).reader();
        Analyzer analyzer,
import java.util.concurrent.ConcurrentLinkedQueue;
    /**
        } finally {
                // Map insertion order to the final doc id; unsorted segments use identity.
                if (mapping.size() != docCount) {
                // sequential 0..N-1 in the final doc order.
import org.apache.lucene.index.Sorter;
    }
            stats.incFlushTotal();
        // Two flush triggers wired in via overridable hooks:
                long rowId = rowIdDV.nextValue();
     * Asserts that the {@code ___row_id} doc values in the freshly committed segment
                }
            originalInfo.getHasBlocks(),
            }
                Sort configuredIndexSort = indexWriter.getConfig().getIndexSort();
            originalInfo.getId(),
            if (rowIdDV == null) {
        }
            throw new IllegalStateException("rollbackTo requires ACTIVE or PENDING_ROLLBACK state but was " + state);
            assert segmentInfos.size() == 1 : "Expected exactly 1 segment after force merge, got " + segmentInfos.size();
     * Configures the child writer for sorted flush: sets a ReorderingMergePolicy
     *   <li>Lucene secondary with sort permutation from Parquet: mapping is non-null,
        } catch (Exception e) {
        @Override
        } finally {
            mergeDone = true;
            long commitDurationMs = TimeValue.nsecToMSec(System.nanoTime() - commitStartNanos);
            originalInfo.dir,
import org.apache.lucene.index.DirectoryReader;
                if (rowId != docId) {
 * {@link LuceneIndexingExecutionEngine#refresh} can incorporate the segment into the
     *
            originalInfo.getDiagnostics(),
                            + mapping.size()
        try (DirectoryReader reader = DirectoryReader.open(indexWriter)) {
        iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
                        "Doc ["
 *
            stats.addDocsIndexed(1);
            for (String file : directory.listAll()) {
        if (rowCount == docCount) {
                state = WriterState.PENDING_ROLLBACK;
                            + "]; segment must not have merged under NoMergePolicy"
     * Adds a document to the underlying {@link IndexWriter}. {@link IOException} (low-level
                public int size() {
    public boolean isSchemaMutable() {
     */
        );
 * Per-generation Lucene writer that creates segments in an isolated temporary directory.
                forceMergeDurationMs
            return null;
        long writerGeneration,
    }
                flushInput.hasRowIdMapping()
            if (bufferedRowId >= rowCount) {
            sealPositionalDeletes();
import org.apache.lucene.index.NoMergePolicy;
        Sort sort = new Sort(new SortedNumericSortField(LuceneDocumentInput.ROW_ID_FIELD, SortField.Type.LONG));
    private void rewriteSegmentInfoWithSort(SegmentInfos segmentInfos, SegmentCommitInfo segmentCommitInfo) throws IOException {
            assert assertRowIdsSequential(directory) : "___row_id__ doc values not sequential after forceMerge for writer generation ["
                    throw new AssertionError(
            originalInfo.getCodec(),
     * @throws AssertionError with a descriptive message if I/O fails or the field is missing
     * (e.g., Parquet sort-on-close), the Lucene segment is reordered using Lucene's IndexSort
     * Buffers an insertion row id to be marked deleted during this writer's flush.
        }
            totalFlushDurationMs = TimeValue.nsecToMSec(System.nanoTime() - flushStart);
            directory.close();
            );
                "flush: START generation={}, docCount={}, hasRowIdMapping={}",
                            + " (got "
     * stateless (return a constant) — they cannot depend on any instance fields.
import org.apache.lucene.index.SegmentInfos;
     *
        // Rewrite the .si file with sort metadata
        sealPositionalDeletes();
     * <p>This method is intended to be invoked from inside an {@code assert} statement
            return false;
        this.directory = createDirectory(tempDirectory);
            // - No sort: docs added sequentially, row IDs naturally sequential
            // layer, but we re-check here so a single-format Lucene path is also protected.
            originalInfo.getUseCompoundFile(),
            // Invariant: ___row_id__ doc values must be sequential 0..maxDoc-1 after forceMerge.
                @Override
    private final Queue<Long> positionalDeletes = new ConcurrentLinkedQueue<>();
     * spill points.
            long currentDocId = docCount;
                    );
    @Override
            if (segments.isEmpty()) {
                docCount,
            return true;
            state = WriterState.RETIRED_FLUSHABLE;
    /**
        try {
    }
            throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + docCount + " docs admitted");
                rewriteSegmentInfoWithSort(segmentInfos, segmentInfo);
            assert reader.leaves().size() == 1 : "Expected exactly 1 leaf reader, got " + reader.leaves().size();
import org.apache.lucene.analysis.Analyzer;
     * independent of JVM/Lucene version and per-doc encoding size.
 * this file be licensed under the Apache-2.0 license or a
                return new WriteResult.Failure(e, -1L, -1L, -1L);
        // Close the IndexWriter and Directory if they haven't been closed by flush()
import org.opensearch.index.engine.exec.WriterFileSet;
                    return mapping.size() + (rowIdToPurge != -1 ? 1 : 0);
     * Creates a new LuceneWriter for the given generation.
 * SPDX-License-Identifier: Apache-2.0
            throw new AssertionError("Failed to verify ___row_id__ invariant for writer generation [" + writerGeneration + "]", e);
        return bufferedPositionalDeletes;
            throw new IllegalStateException(
    public WriterState state() {
    @Override
    @Override
        long mappingVersion,
                public int oldToNew(int docID) {
            // The segment is always sorted by __row_id__ — either naturally (docs
import org.apache.lucene.util.RamUsageEstimator;
                if (configuredIndexSort != null) {
        @Override
            docCount++;
     * <p>If the {@link FlushInput} carries a sort permutation from the primary data format
     * @param baseDirectory    the base directory under which to create the temp directory
        private final RowIdMapping mapping;
                totalFlushDurationMs
    /**
     * {@code OneMerge} is used (the merge still rewrites the segment, enabling the codec's
    }
        state = WriterState.RETIRED_FLUSHABLE;
        }
            } catch (IOException | IllegalArgumentException e) {
        positionalDeletes.removeIf(bufferedRowId -> {
                }
        SegmentInfo sortedInfo = new SegmentInfo(
        public MergeSpecification findMerges(MergeTrigger mergeTrigger, SegmentInfos segmentInfos, MergeContext mergeContext) {
     */
            MergeSpecification spec = new MergeSpecification();
     */
    private final Directory directory;
            // This prevents IndexFileDeleter from removing our rewritten segments_N
    private volatile WriterState state = WriterState.ACTIVE;
 *
        IndexWriterConfig iwc = analyzer != null ? new IndexWriterConfig(analyzer) : new IndexWriterConfig();
    private void configureSortedMerge(RowIdMapping mapping, boolean hasRolledBack) {
                }
    @Override
                assert position >= 0 : "positional delete resolved to a negative row id (insertionRowId=" + insertionRowId + ")";
import java.util.List;
            // Defense-in-depth: CompositeWriter enforces rowId == docCount at the multiplexer
                long position = mapping != null ? mapping.getNewRowId(insertionRowId, RowIdMapping.SINGLE_GEN) : insertionRowId;
            for (int docId = 0; docId < maxDoc; docId++) {
                            + "] for writer generation ["
        if (state != WriterState.PENDING_ROLLBACK && state != WriterState.ACTIVE) {
     * <p>This policy is used in two scenarios:
        return new MMapDirectory(tempDirectory);
            segmentCommitInfo.getDocValuesGen(),
        positionalDeletesSealed = true;
            List<SegmentCommitInfo> segments = new ArrayList<>();
     * constructor with the writer's per-generation temp directory.
     * Force-merges all buffered documents into exactly one segment, commits the IndexWriter,
     *
     * <p>This method is invoked from the constructor, so overrides must be
        public MergeSpecification findForcedDeletesMerges(SegmentInfos segmentInfos, MergeContext mergeContext) {
 * Each instance owns its own {@link IndexWriter} and {@link Directory}. Documents are
        int discarded = 0;
     * the expected sort, rewrites the .si file, and re-commits the SegmentInfos so that
            iwc.setIndexSort(indexSort);
                            + ") on writer generation ["
 *
     * or via reorder + row ID rewrite). This method reconstructs the SegmentInfo with
    /**
    public void recordPositionalDelete(long insertionRowId) {
                + writerGeneration
     */
     * even if there is only one segment. When a {@link RowIdMapping} is provided, the merge
            // Verify the invariant: exactly 1 segment with docCount documents
    public WriteResult addDoc(LuceneDocumentInput input) throws IOException {
    @Override
            } else {
            // After flush the segment must contain exactly docCount live docs. Any tombstones
                    wfsBuilder.addFile(file);
        segmentInfos.commit(directory);
                .addNumRows(docCount);
            }
                @Override
                positionalDeleteCount.decrementAndGet();
     * alignment with Parquet.
 * Lucene segment and the corresponding Parquet file for the same writer generation.
            registry.remove(this);
            }
            segmentCommitInfo.getFieldInfosGen(),
                        "Non-sequential "
     * Returns the underlying writer for the specified data format name.
        }
    /**
        SegmentInfo originalInfo = segmentCommitInfo.info;
 *
     */
 */
    }
     * and returns a {@link FileInfos} describing the resulting segment files in the temp directory.
 * shared {@link LuceneCommitter} writer via {@code addIndexes}.
     */
    private final LuceneDataFormat dataFormat;
        RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + 2L * RamUsageEstimator.NUM_BYTES_OBJECT_REF
    static class ReorderingOneMerge extends MergePolicy.OneMerge {
            state = WriterState.CLOSED;
                            + writerGeneration
    }
import org.opensearch.index.engine.dataformat.WriteResult;
                            + configuredIndexSort
     * <p>Tests exercising the multi-segment merge path should override
    }
            }
     * are sequential 0..maxDoc-1 in doc order. This invariant must hold whether the
                "flush: DONE generation={}, totalRows={}, forceMerge={}ms, commit={}ms, total={}ms",
            if (mapping != null && mapping.isNewToOldSupported() == false) {
            if (flushed == false) IOUtils.rm(tempDirectory);
            // from rollbackTo are expunged by the reordering forceMerge (secondary path)
 * Row ID invariant: Each document must have a {@code __row_id__} field set via
                directory.close();
        indexWriter.getConfig().setMergePolicy(new ReorderingMergePolicy(mapping, hasRolledBack ? mapping.size() : -1));
import java.util.Set;
                            + ", expected "
import java.util.Optional;
    private void sealPositionalDeletes() {
            int maxDoc = leaf.maxDoc();
    private void applyPositionalDeletes(RowIdMapping mapping) throws IOException {
                        "tryDeleteDocument failed for position="
 *
            MergeContext mergeContext
            discarded++;
import org.opensearch.index.engine.dataformat.DocumentInput;
        }
                mapping = flushInput.rowIdMapping();
            // Build the WriterFileSet pointing to the temp directory
                            + writerGeneration
                }
        return mappingVersion;
        }
        }, stats::addIndexTimeMillis);
     * @throws IOException if directory creation or IndexWriter opening fails
     * @throws IOException if cleanup fails
            if (flushInput.hasRowIdMapping()) {
     * @param mappingVersion   the initial mapping version
        logger.debug("applyPositionalDeletes: generation={}, marked {} row(s) deleted (liveDocs-only)", writerGeneration, deleted);
            // This holds in all cases:
        if (rowCount > docCount) {
    @Override
        // maxBufferedDocs() to a small value (e.g. 20) to force exact spill points
            originalInfo.getMinVersion(),
        }
            return Optional.of(this);
                if (indexWriter.tryDeleteDocument(leaf, (int) position) == -1) {
     * faults). Default is a plain {@link MMapDirectory}. Invoked once from the
import org.apache.lucene.store.Directory;
                public int newToOld(int docID) {
        this.docCount = 0;
        directory.deleteFile(siFileName);
     *
public class LuceneWriter implements Writer<LuceneDocumentInput> {
            return;
                forceMergeDurationMs,
     *
        Codec codec,
            iwc.setMergePolicy(NoMergePolicy.INSTANCE);
            Map<SegmentCommitInfo, Boolean> segmentsToMerge,
        }
    }
    static class ReorderingMergePolicy extends MergePolicy {
    public void updateMappingVersion(long newVersion) {
    private volatile boolean positionalDeletesSealed;
import java.util.ArrayList;
 *
            if (indexWriter.isOpen()) {
     */
        iwc.setRAMBufferSizeMB(ramBufferSizeMB());
        positionalDeleteCount.incrementAndGet();
        } catch (IOException e) {
        ReorderingOneMerge(List<SegmentCommitInfo> segments, RowIdMapping mapping, int rowIdToPurge) {
/**
            // We are taking control here hence not allowing any merge to happen automatically.
            RowIdMapping mapping = null;
                indexWriter.rollback();
                            + "]"
                            + "] does not match document count ["
                            + ") for writer generation ["
     * @param flushInput optional context; if it carries a sort permutation, the segment is sorted
import org.apache.lucene.index.MergePolicy;
    private final AtomicInteger positionalDeleteCount = new AtomicInteger();
            // file (which it wouldn't recognize as its own commit).
                            + docCount
            logger.warn("Failed to rollback IndexWriter for generation[{}]: {}", writerGeneration, e);
     * @param indexSort        the index sort to apply (null when Lucene is secondary format)
     */
     */
 * intermediate flushes, since all writes to a single writer come from a single thread
     * and deleting the temp directory. Safe to call multiple times.
    /**
            try {
                // be scrambled after sort. Force a merge so the codec rewrites row IDs to
                // close() removes the temporary directory.
                    throw new IllegalStateException(
            }
        try {
    /** {@inheritDoc} Returns the writer generation number assigned at construction. */
                throw new IllegalStateException("addDoc requires ACTIVE state but was " + state);
    protected double ramBufferSizeMB() {
     * Custom OneMerge that overrides {@code reorder()} to provide the sort permutation
        }
import java.util.Queue;
    public LuceneWriter(
        private final int rowIdToPurge;
     * MergePolicy that unconditionally forces a merge of all segments on {@code forceMerge},
                // Lucene's IndexWriter may have consumed a docId before throwing; advance our
            iwc.setMergePolicy(new LogByteSizeMergePolicy());
            } else {
import java.util.Map;
    /** Heap cost of one queue node and its boxed row ID. */
                .directory(tempDirectory)
            // Maps insertion row ids to final doc ids after primary-format sorting.
        while (positionalDeletes.poll() != null) {
     * the merge according to the Parquet sort order.
        public MergeSpecification findForcedMerges(
        public Sorter.DocMap reorder(CodecReader reader, Directory dir, Executor executor) throws IOException {
        this.stats = stats;
        discardBufferedPositionalDeletes();
     * After flush, the IndexWriter and Directory are closed. The temp directory files remain
        long flushStart = System.nanoTime();
                }
    public long generation() {
        return StatsRecorder.recordTimeMillis(() -> {
    /**
 * {@link LuceneDocumentInput#setRowId}. The row ID must equal the Lucene doc ID
            directory.close();
     * value (e.g. {@code 1024.0}) together with a small
     * as a {@link Sorter.DocMap}. This causes Lucene to physically reorder docs during
            return FileInfos.builder().putWriterFileSet(dataFormat, wfsBuilder.build()).build();
                        return rowIdToPurge;
     *   <li>Lucene primary with IndexSort: mapping is null, Lucene's native sort already
    public void close() throws IOException {
         *                rewrite merge (used when Lucene's IndexSort already sorted the docs)
     * Rewrites the segment's .si file and segments_N commit to declare the IndexSort.
    /**
                commitDurationMs,
                }
    @Override
            }
            if (mergeDone) {
            // Close the IndexWriter before rewriting segment metadata.
                configureSortedMerge(mapping, state == WriterState.RETIRED_FLUSHABLE);
    private boolean assertRowIdsSequential(Directory directory) {
            indexWriter.flush();
            indexWriter.commit();
         */
                            + docId
     */
    private static final double RAM_BUFFER_SIZE_MB = 256.0;
     *
     * @param stats            the shard-level stats collector
     * @param codec            the codec to use, or null for default
    public Optional<Writer<?>> getWriterForFormat(String formatName) {
            };
import org.opensearch.index.engine.dataformat.RowIdMapping;
                    if (docID == rowIdToPurge) {
                            + docId
        Path baseDirectory,
     */
                // Lucene drops a fully deleted segment. Return no files and leave `flushed` false so
     * {@link org.apache.lucene.store.AlreadyClosedException} after a tragic event) propagates.
                            + "]"
     * rewrite during a sorted flush. It guards the 1:1 offset correspondence with the
            );
package org.opensearch.be.lucene.index;
            if (mapping != null) {
import org.opensearch.index.engine.dataformat.FileInfos;
     * that forces a merge of all segments (with optional doc reordering via the mapping).
            applyPositionalDeletes(mapping);
            }
    ) + RamUsageEstimator.alignObjectSize(RamUsageEstimator.NUM_BYTES_OBJECT_HEADER + (long) Long.BYTES);
        return writerGeneration;
                docCount++;
        // Count first so concurrent draining cannot make the count negative.
        this.registry = registry;
            return FileInfos.empty();
            originalInfo.getAttributes(),
import org.apache.lucene.search.Sort;
     * so the I/O cost is paid only when assertions are enabled (tests, dev, CI).
import org.opensearch.plugin.stats.StatsRecorder;
            this.mapping = mapping;
        // - maxBufferedDocs(): doc-count based flushing. Default DISABLE_AUTO_FLUSH so
     * I/O fault) and {@link IllegalArgumentException} (per-doc rejection from
     * @return {@code true} if all row IDs are sequential, {@code false} otherwise
        }
        indexWriter.deleteDocuments(NumericDocValuesField.newSlowExactQuery(DocumentInput.ROW_ID_FIELD, rowCount));
        ) {
            // Stamp the IndexSort on the segment metadata post-commit so that
        return RAM_BUFFER_SIZE_MB;
            logger.debug(
                }
            }
     * (because the writer operates without IndexSort to allow OneMerge.reorder()).
            this.rowIdToPurge = rowIdToPurge;
        // production never flushes by doc count. Tests that need deterministic
        // Create an isolated temp directory for this writer's segment
import org.opensearch.be.lucene.stats.LuceneShardStatsTracker;
    private static final long BYTES_PER_POSITIONAL_DELETE = RamUsageEstimator.alignObjectSize(
                spec.add(new MergePolicy.OneMerge(segments));
    }
            while ((insertionRowId = positionalDeletes.poll()) != null) {
                stats.incDocsIndexedFailures();
     * mechanism with a custom SortField that remaps {@code ___row_id} values through the
     * <p>
}
    public void cleanupTempDirectory() {
     *
    /** Returns heap bytes used by this writer's IndexWriter RAM buffer. Returns 0 after flush. */
        }
        // Reconstruct SegmentInfo with the IndexSort declared
 * added via {@link #addDoc(LuceneDocumentInput)}, and on {@link #flush(FlushInput)}, the writer
        // Replace the segment in SegmentInfos and re-commit so segments_N is consistent.
            LeafReader leaf = reader.leaves().get(0).reader();
        private volatile boolean mergeDone = false;
            // - Lucene primary with IndexSort: Lucene sorts natively + row ID rewrite
import org.opensearch.index.engine.dataformat.WriterState;
                }
        private final RowIdMapping mapping; // nullable
        } catch (IOException e) {
    private final Set<LuceneWriter> registry;
        }
     *
        if (indexWriter.isOpen()) {
        }
        iwc.setCodec(new LuceneWriterCodec(codec, writerGeneration));
            for (int i = 0; i < segmentInfos.size(); i++) {
                    }
     * Deletes the temporary directory created by this writer. Called externally by the
            logger.debug(
            int maxSegmentCount,
        if (positionalDeletes.isEmpty()) {
                writerGeneration,
        }
            positionalDeleteCount.decrementAndGet();
        public void setMergeInfo(SegmentCommitInfo info) {
                return FileInfos.empty();
        iwc.setMaxBufferedDocs(maxBufferedDocs());
                        "RowIdMapping size ["
                }
import java.io.IOException;
    }
     * @param writerGeneration the writer generation number
                throw new IllegalStateException("rowId [" + input.getRowId() + "] does not match doc count [" + docCount + "]");
    }
     *       reordered docs, but the merge is needed to trigger the codec's row ID rewrite.</li>
        private final int rowIdToPurge;
import org.opensearch.common.annotation.ExperimentalApi;
     *         or {@link FileInfos#empty()} if no documents were added
    private volatile boolean flushed;
                            + "]"
     *
                deleted++;
        long totalFlushDurationMs = 0;
        this.mappingVersion = mappingVersion;
        @Override
        // accumulates docs into a single in-memory segment before flush.
    public long getHeapBytesUsed() {
            segmentCommitInfo.getDelCount(),
        @Override
        return state;
            logger.debug(
            // If sort permutation is provided, configure the reorder merge policy
import java.util.concurrent.atomic.AtomicInteger;
    }
     * Row ID rewrite is already enabled on the codec at construction time.
                            + "] missing "
            this.rowIdToPurge = rowIdToPurge;
        if (docCount - rowCount != 1) {
                + "]";
import org.apache.lucene.index.SegmentInfo;
            return new WriteResult.Success(1L, 1L, currentDocId);
        try {
    private final IndexWriter indexWriter;
     * stateless (return a constant) — they cannot depend on any instance fields.
     * Hook for tests to override the IndexWriter max-buffered-docs threshold.
                            + writerGeneration
            }
import java.util.concurrent.Executor;
            try {
                "rollbackTo supports rolling back exactly 1 doc, but asked to roll back " + (docCount - rowCount)
        this.writerGeneration = writerGeneration;
        docCount = rowCount;
import org.apache.lucene.search.SortedNumericSortField;
                    "Field [" + LuceneDocumentInput.ROW_ID_FIELD + "] missing from segment for writer generation [" + writerGeneration + "]"
            }
        segmentInfos.add(newCommitInfo);
import org.apache.lucene.store.MMapDirectory;
 * (0-based sequential within this writer). This is asserted during flush to ensure
            WriterFileSet.Builder wfsBuilder = WriterFileSet.builder()
            segmentCommitInfo.getId()
        }
     * writer's directory, making the originals safe to remove.
     * @throws IOException if opening the NRT reader or applying a delete fails
 */
                // counter to match so rollbackTo can tombstone the partial slot, and
                            + LuceneDocumentInput.ROW_ID_FIELD
        return true;
            super(segments);
                            + insertionRowId
import org.apache.lucene.index.CodecReader;
            assert segmentInfo.info.maxDoc() == docCount : "Expected " + docCount + " docs in segment, got " + segmentInfo.info.maxDoc();
    /**
            } else if (indexWriter.getConfig().getIndexSort() != null) {
            long forceMergeStartNanos = System.nanoTime();
        Codec currentCodec = indexWriter.getConfig().getCodec();
    protected Directory createDirectory(Path tempDirectory) throws IOException {
     * {@link #maxBufferedDocs()} value, so doc count alone drives spilling
            return new Sorter.DocMap() {
        // the original SegmentCommitInfo expresses intent better than clear() + add().
                "flush: forceMerge complete: generation={}, docCount={}, duration={}ms",
                // retire to preserve the docId == rowId invariant for subsequent writes.
            // Common path: forceMerge to 1 segment, commit, build FileInfos
        } else {
        // The flush() caller has already asserted segmentInfos.size() == 1, so removing
        Sort indexSort,
    @Override
                            + rowId
                        "RowIdMapping must not be provided when IndexSort is configured for writer generation [" + writerGeneration + "]"
                logger.debug("flush: generation={} has no surviving rows ({} deleted); contributing no files", writerGeneration, docCount);
 * After flush, the returned {@link FileInfos} contains the temp directory path so that
                            + writerGeneration
import org.apache.lucene.store.AlreadyClosedException;
    private final long writerGeneration;
            indexWriter.close();
        // - ramBufferSizeMB(): RAM-buffer based flushing. Default 256 MB so production
     * @throws IOException if rewriting fails
                indexWriter.addDocument(input.getFinalInput());
     * on disk for {@link LuceneIndexingExecutionEngine#refresh} to incorporate via
                throw new AssertionError(
     * translated to {@link WriteResult.Failure}, with {@code docCount} advanced to capture
                    throw new AssertionError(
     * <p>For deterministic multi-segment tests, override this to a very large
        if (positionalDeletesSealed) {
            }
 * The OpenSearch Contributors require contributions made to
     * @throws IllegalStateException if a mapped doc id cannot be resolved
            // - Lucene secondary: docs reordered via OneMerge.reorder() + row ID rewrite
            // need to either configure index.sort.field or avoid the rollback path.
    }
                totalFlushDurationMs = TimeValue.nsecToMSec(System.nanoTime() - flushStart);
import org.apache.lucene.search.SortField;
    /**
            }
import org.apache.lucene.index.SortedNumericDocValues;
     * </ul>
            return;
        indexWriter.getConfig().setMergePolicy(NoMergePolicy.INSTANCE);
        if (docCount == 0) {
        this.indexWriter = new IndexWriter(directory, iwc);
                indexWriter.getConfig().setMergePolicy(new LogByteSizeMergePolicy());
        LuceneDataFormat dataFormat,
     */
            Long insertionRowId;
        }
                // RowIdMapping shouldn't be available if index has sort configurations.
            }
                    );
        if (indexSort != null) {
                    return (int) mapping.getOldRowId(docID);
    }
@ExperimentalApi
            }
import org.apache.lucene.index.IndexWriterConfig;
            // Add all files in the segment
        positionalDeletes.add(insertionRowId);
            lwc.enableRowIdRewrite();
                // Lucene is primary with IndexSort: Lucene natively reorders docs during
    /**
            originalInfo.maxDoc(),
            );
     * the partial slot and the writer moved to {@link WriterState#PENDING_ROLLBACK}; the caller must
import org.opensearch.index.engine.dataformat.FlushInput;
                docCount,
                    );
        ReorderingMergePolicy(RowIdMapping mapping, int rowIdToPurge) {
     * @return file infos containing the temp directory path and segment file names,
            sort
        }
        } catch (Exception e) {
    private final Path tempDirectory;
        // multi-segment paths override ramBufferSizeMB() to Double.MAX_VALUE and
     * docs into a single in-memory segment before flush.
        logger.info("Creating directory for temp lucene writer: " + tempDirectory);
                            + " (insertionRowId="
            long forceMergeDurationMs = TimeValue.nsecToMSec(System.nanoTime() - forceMergeStartNanos);
        this.dataFormat = dataFormat;
                    return (int) mapping.getNewRowId(docID, RowIdMapping.SINGLE_GEN);
            // TODO: this assertion will trip if Lucene is configured as the primary format
        }
    private final LuceneShardStatsTracker stats;
        // does not overwrite existing files.
            // Wrapped in `assert` so the I/O cost is paid only when assertions are enabled.
    }
            logger.warn("Failed to delete lucene temp directory [{}]: {}", tempDirectory, e.getMessage());
     * After the child writer commits, the segment on disk has no IndexSort metadata
    /** Drains {@link #positionalDeletes}, releasing the accounted heap. */
                if (file.startsWith("segments") == false && file.equals("write.lock") == false) {
 * (the writer pool in {@code DataFormatAwareEngine} locks the writer during use).
        try (DirectoryReader reader = DirectoryReader.open(directory)) {
                            + LuceneDocumentInput.ROW_ID_FIELD
     * and return a small value (e.g. 20) here to force exact, version-independent
     * However, the segment is logically sorted by __row_id__ (either naturally sequential
 * the 1:1 offset correspondence with Parquet.
            discardBufferedPositionalDeletes();
                );
            logger.warn("Failed to close directory for generation[{}]: {}", writerGeneration, e);
            // addIndexes(Directory...) on the shared writer sees matching sort.
 * @opensearch.experimental
     *
     * addIndexes(Directory...) on the shared writer sees matching sort metadata.
            originalInfo.name,
            this.mappingVersion = newVersion;
    /**
     *
    private static final Logger logger = LogManager.getLogger(LuceneWriter.class);
            }
            SegmentCommitInfo segmentInfo = segmentInfos.info(0);
import org.apache.lucene.index.SegmentCommitInfo;
            IOUtils.rm(tempDirectory);
                    }
            return spec;
    /** Large RAM buffer to avoid intermediate segment flushes within a single writer in production. */
    @Override
            }
            SegmentInfos segmentInfos,
    private long mappingVersion;
                    throw new IllegalStateException(
            super.setMergeInfo(info);
            }
     * Default is {@link IndexWriterConfig#DISABLE_AUTO_FLUSH}, so production
        // independent of JVM/Lucene version.
        });
    /**
    /**
    }
            SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(directory);
        if (LuceneDataFormat.LUCENE_FORMAT_NAME.equals(formatName)) {
            // Apply positional deletes after reordering and before commit.
     */
    @Override
        this.tempDirectory = baseDirectory.resolve("lucene_gen_" + writerGeneration);
                            + "] for writer generation ["
import org.apache.lucene.document.NumericDocValuesField;
    }
     * {@link #RAM_BUFFER_SIZE_MB}, large enough that production accumulates all
import java.nio.file.Path;
    }
     * @param segmentCommitInfo the single segment's commit info
    }
            logger.debug("flush: commit complete: generation={}, duration={}ms", writerGeneration, commitDurationMs);
