            pendingWrite = null;
                try {
            throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + acceptedRows + " rows in VSR");
            );
        if (newVSR == null) {
            case BaseVariableWidthVector variable -> variable.setNull(index);
        int maxRowsPerVSR,
            return;
        // Re-check the rowId invariant so a single-format Parquet path is protected too.
            } else if (hasSameStorageShape(existingVector.getField(), schemaField) == false) {
        Schema schema,
    Future<?> getPendingWrite() {
                // Pass the schema field through as-is: rebuilding it from name + FieldType alone
    ManagedVSR getActiveManagedVSR() {
    /**
     * If the active VSR has reached the row threshold and the frozen slot is empty,
     * Scrubs a partially-written, uncounted row after a mid-document failure so no stale value
     * that may have caused the failure. The field that actually failed, and any fields ordered after it,
        if (rotated == false) {
            // rethrow keeps addDocument's throws clause unchanged.
        }
     * Returns the row ID mapping produced during the last flush's sort-on-close
        ArrowBufferPool bufferPool,
     * Creates a new VSRManager.
                            + "] — schema reconciliation must run via updateMappingVersion before addDocument"
            FieldVector existingVector = activeVSR.getVector(schemaField.getName());
import java.util.concurrent.Future;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        // vector written after the loop. See scrubPartialRow.
        } catch (TimeoutException e) {
            maybeInitializeWriter(currentVSR);
import org.apache.arrow.vector.BaseFixedWidthVector;
            stats.incBackgroundWriteTotal();
 * <p>Field values are resolved to their Arrow vector types via {@link ArrowFieldRegistry}
        return changed;
     * freezes the active VSR, submits it for background native write, and creates
    // Visible for testing only
        this.vsrRotationThread = runAsync ? ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME : ThreadPool.Names.SAME;
                    "[Gen: {}] Failed to scrub partial row {} for vector [{}] in {}; column may retain a stale value",
            BigIntVector rowIdVector = (BigIntVector) activeVSR.getVector(DocumentInput.ROW_ID_FIELD);
                ParquetField parquetField = ArrowFieldRegistry.getParquetField(fieldType.typeName());
     * Field Shape is decided at the {@link ParquetDocumentInput} layer: fields mapped with
        ManagedVSR activeVSR = managedVSR.get();
     * In Arrow 18.1.0 every vector's {@code setNull} clears only the validity bit at {@code index}
            Runnable writeTask = () -> {
                        writerGeneration,
                vsrPool.close();
            acceptedRows++;
 * Top-level orchestrator for the Arrow batching → Parquet file generation pipeline.
        long startNanos = System.nanoTime();
                    schemaField.getName(),
            for (FieldValuePair pair : doc.getFinalInput()) {
                        activeVSR.getSchema().getFields().stream().map(f -> f.getName()).collect(java.util.stream.Collectors.joining(", "))
        ManagedVSR newVSR = vsrPool.getActiveVSR();
    private void scrubPartialRow(ParquetDocumentInput doc, ManagedVSR activeVSR, int rowIndex, int writtenFields, boolean rowIdWritten) {
                    // ParquetWriter.updateMappingVersion before any addDocument with a new
            activeVSR.setRowCount(rowIndex + 1);
     *
        List<Field> schemaChildren = schemaField.getChildren();
     * @param rowIdWritten  whether the rowId vector was written for this row
     * and all other fields still reject a second value.
        IndexSettings indexSettings,
     */
    private final VSRPool vsrPool;
        }
        }
     * growth allocation.
    private static boolean hasSameStorageShape(Field existingField, Field schemaField) {
/**
        String fileName,
                }
        boolean rowIdWritten = false;
     * @param activeVSR     the VSR the row was being written into
        int writtenFields = 0;
                        fieldType.name(),
    private final ThreadPool threadPool;
    }
     * (growing the validity/offset buffers first if {@code index} is beyond capacity); it does not
     * @param newSchema the schema to reconcile against
     */
     * vector is logged and the remaining vectors are still scrubbed, so the original write failure (which
            }
     * Waits for any in-flight background write to complete with an optional timeout.
     * <p>Only the vectors whose write for this row already <em>succeeded</em> are reset: the leading
     * schema so subsequently rotated VSRs include the new fields.
        long writerGeneration
                }
                () -> new ParameterizedMessage(
                stats.incBackgroundWriteFailures();
     */
import org.opensearch.parquet.bridge.ParquetFileMetadata;
        ThreadPool threadPool,
                MappedFieldType fieldType = pair.getFieldType();
     * Reconciles the active VSR with the given schema by adding vectors for any fields
                    // out of sync with the mapping — surface as a recoverable failure.
        boolean rotated = vsrPool.maybeRotateActiveVSR();
            } else if (state == Future.State.CANCELLED) {
                    logger.error(
        boolean runAsync,
                    );
 */
 * The OpenSearch Contributors require contributions made to
                return false;
            schema,
        ThreadPool threadPool,
                        rowCount.add(frozenVSR.getRowCount());
            scrubVector(activeVSR.getVector(fields.get(i).getFieldType().name()), rowIndex);
        }
import org.opensearch.parquet.stats.ParquetShardStatsTracker;
        logger.debug("Flush completed for {} with metadata: {}", fileName, metadata);
                parquetField.createField(fieldType, activeVSR, pair.getValue());
import java.util.concurrent.atomic.LongAdder;
     */
            ParquetSortConfig sortConfig = new ParquetSortConfig(indexSettings);
     * @param timeoutSeconds timeout in seconds (0 means wait indefinitely)
import org.opensearch.nativebridge.spi.ArrowExport;
    public RowIdMapping getRowIdMapping() {
        if (changed) {
        String fileName,
        ManagedVSR activeVSR = managedVSR.get();
 * <p>This class is NOT Thread-Safe. External synchronization is required
                );
        } finally {
        }
        return managedVSR.get();
                            + fieldType.name()
                pendingWrite.get(timeoutSeconds, TimeUnit.SECONDS);
     * @param rowIndex      the uncommitted row index to clear
            // Any failure between the first field write and acceptance leaves an uncounted partial
    private final ParquetShardStatsTracker stats;
import org.opensearch.parquet.bridge.ParquetSortConfig;
        } catch (Exception e) {
     */
    }
        if (doc.getRowId() != acceptedRows) {
     * using the ArrowFieldRegistry to resolve typed vector writes.
            }
    ) {
    public VSRManager(
    private LongAdder rowCount = new LongAdder();
     * Creates a new VSRManager with asynchronous background writes and no stats collection.
                changed = true;
import org.opensearch.index.mapper.MappedFieldType;
            if (state == Future.State.FAILED) {
        this.threadPool = threadPool;
 */
    /**
import org.opensearch.parquet.fields.ParquetField;
            throw new IOException("Background VSR write failed for " + fileName, e.getCause());
    /**
     * its slot at {@code rowIndex} is already allocated, so {@link #setNull} degrades to a plain
     */
                } catch (IOException e) {
    public void addDocument(ParquetDocumentInput doc) throws IOException {
        this.vsrPool = new VSRPool("pool-" + fileName, schema, bufferPool, maxRowsPerVSR);
 *
        this.indexSettings = indexSettings;
            logger.debug("no changes in schema despite change in mapping version");
        // the ingest pool for the node's lifetime — "Memory was leaked by query"). Release the pool
    /**
     * Clears the value at {@code index} by unsetting its validity bit, so the slot reads as null.
            if (existingVector == null) {
    }
    }
     * Initializes the native writer on first use, using the schema from the given VSR.
    private final String fileName;
    }
        ParquetShardStatsTracker stats
     */
 *       VSR's Arrow vectors, rotating the VSR if the row threshold is reached.</li>
            }
public class VSRManager implements AutoCloseable {
                    writerGeneration,
        this.fileName = fileName;
                if (activeVSR.getVector(fieldType.name()) == null) {
import org.opensearch.parquet.fields.ArrowFieldRegistry;
            stats.addBackgroundWriteWaitMillis(elapsed);
     * Syncs the Parquet file to disk. Must be called after {@link #flush()}.
                    );
import java.util.List;
            // that reuses this row index, then rethrow the original failure unchanged. Precise
    /**
                activeVSR.addFieldVector(schemaField);
        if (frozenVSR != null) {
     *
            bufferPool,
                    fileName
            runAsync,
     * Rolls the VSR back to hold exactly {@code rowCount} admitted rows. No-op if already
        try {
            return false;
        this(
            return false;
            return;
 * SPDX-License-Identifier: Apache-2.0
    public boolean isSchemaMutable() {
import org.opensearch.threadpool.ThreadPool;
import java.io.IOException;
                    try (ArrowExport export = frozenVSR.exportToArrow()) {
     * {@code multi_value: true} accumulate every value into one list-valued pair,
                    );
    public VSRManager(
    public VSRManager(
     * whose successful write already allocated them, so no growth occurs. Every vector type the Parquet
    /**
import org.apache.arrow.vector.BitVectorHelper;
        }
            } catch (Exception e) {
        managedVSR.set(newVSR);
 *   <li>{@link #addDocument(ParquetDocumentInput)} — transfers document fields into the active
            // blocks recovery's re-create for the same file ("Writer already exists").
import org.opensearch.parquet.memory.ArrowBufferPool;
        } catch (Exception e) {
    public ParquetFileMetadata flush() throws IOException {
            };
     * rewrite the value/offset data of {@code index} or any other row. Callers here only pass slots
            default -> BitVectorHelper.unsetBit(vector.getValidityBuffer(), index);
                        "No ParquetField mapping for field [" + fieldType.name() + "] of type [" + fieldType.typeName() + "]"
    /**
     * @param indexSettings the index settings (sort config is read from here)
        acceptedRows = rowCount;
import org.opensearch.parquet.writer.FieldValuePair;
        ManagedVSR activeVSR = managedVSR.get();
 * <ol>
 * if instances are shared across threads.
        IndexSettings indexSettings,
        long diff = acceptedRows - rowCount;
        }
                }
     * @param runAsync if true, frozen VSR writes run on the background thread pool;
        if (pendingWrite != null && pendingWrite.isDone()) {
    /**
        ArrowBufferPool bufferPool,
    /** Visible for testing — injects a pending background write future to exercise close() paths. */
            } else {
    private final NativeParquetWriter writer;
     *                 if false, they run on the calling thread (for benchmarks/tests)
        boolean changed = false;
            new ParquetShardStatsTracker()
        }
    ) {
            // threw (e.g. a background write / flush failed under an Arrow OOM). Idempotent: a no-op
 *   <li>{@link #flush()} — freezes the active VSR, exports it to the native writer,
    }
    }
import org.opensearch.parquet.writer.MismatchedInputException;
        if (existingChildren.size() != schemaChildren.size()) {
     * top-level validity bit.
                throw new IOException("Timed out waiting for background VSR write for " + fileName, e);
        Schema schema,
     * the caller rethrows) is never masked.
        // the slots a successful write already allocated. writtenFields is the count of leading source
     */
        return writer.getRowIdMapping();
        ManagedVSR currentVSR = managedVSR.get();
import org.opensearch.parquet.ParquetDataFormatPlugin;
        String fileName,
    /**
        return metadata;
     */
            if (ignoreTimeout) {
import org.opensearch.index.engine.dataformat.RowIdMapping;
    }
        try {
            indexSettings,
 * <p>Combines {@link VSRPool} (Arrow batch management) with {@link NativeParquetWriter}
import org.opensearch.index.IndexSettings;
     * validity-bit clear and never triggers a (re)allocation — safe to run under the memory pressure
                    }
    private void awaitPendingWrite(long timeoutSeconds, boolean ignoreTimeout) throws IOException {
     * {@code writtenFields} fields of {@link ParquetDocumentInput#getFinalInput()} (which is written in
import java.util.concurrent.atomic.AtomicReference;
     * fallback for any other vector type (e.g. a future nested/view field) that clears only the
            // row. Scrub it (best-effort, never throws) so no stale value can leak into the next doc
import java.util.concurrent.TimeoutException;
     * @param rowCount the desired row count after this call
                logger.error("Error releasing VSR pool during close for {}: {}", fileName, e.getMessage());
            }
            } else {
        }
            setNull(vector, rowIndex);
 *       finalizes the Parquet file, and returns file metadata.</li>
import org.apache.logging.log4j.message.ParameterizedMessage;
     * @param stats shard-level stats tracker
            }
            case BaseLargeVariableWidthVector large -> large.setNull(index);
        long writerGeneration,
                pendingWrite.get();
        ManagedVSR frozenVSR = vsrPool.getFrozenVSR();
                // would drop getChildren(), leaving a LIST column with no element vector.
            writerGeneration,
        List<Field> existingChildren = existingField.getChildren();
    }
            case BaseFixedWidthVector fixed -> fixed.setNull(index);
                writer.flush();
                writtenFields++;
     * at the target. Throws if the target is higher than current or if the active VSR
     * a new active VSR. If the frozen slot is occupied, rotation is skipped.
            maxRowsPerVSR,
        }
     */
                rowIdVector.setSafe(rowIndex, doc.getRowId());
            threadPool,
        int maxRowsPerVSR,
    private final int ROTATION_TIMEOUT = 120;
        ParquetFileMetadata metadata = writer.flush();
        }
                    // field type. If we still see an unmapped type here, the writer is
     * <p>
import org.apache.arrow.vector.types.pojo.Schema;
        try {
     * failure on one vector is logged and swallowed so the remaining vectors are still scrubbed and the
        }
            vsrPool.updateSchema(activeVSR.getSchema());
    @Override
     * order) plus, when {@code rowIdWritten}, the rowId vector. Because each of those writes completed,
            currentVSR.moveToFrozen();
    ) {
            }
    public boolean reconcileSchema(Schema newSchema) {
        if (pendingWrite == null) {
     *
        long writerGeneration,
import org.apache.arrow.vector.FieldVector;
    }
     *
     * when the mapping version advances. No-op if every field in {@code newSchema} is
import org.apache.arrow.vector.BigIntVector;
            if (timeoutSeconds > 0) {
                    schemaField.getType()
        ThreadPool threadPool,
    /**
}
     * present in {@code newSchema} but not yet in the active VSR. Also updates the pool
            stats.incBackgroundWriteFailures();
        }
        this.writerGeneration = writerGeneration;
        int maxRowsPerVSR,
            long elapsed = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
                logger.warn("Timed out waiting for background VSR write for {}", fileName);
    public long getAcceptedRows() {
    /**
        } finally {
     * Creates a new VSRManager without stats collection.
        Schema schema,
import java.util.concurrent.TimeUnit;
    private final String vsrRotationThread;
                vsrPool.completeVSR(frozenVSR);
        for (Field schemaField : newSchema.getFields()) {
    /**
            Future.State state = pendingWrite.state();
    private final AtomicReference<ManagedVSR> managedVSR = new AtomicReference<>();
                    existingVector.getField().getType(),
            logger.error("Error during close for {}: {}", fileName, e.getMessage());
    private static void setNull(FieldVector vector, int index) {
        IndexSettings indexSettings,
        IndexSettings indexSettings,
            scrubPartialRow(doc, activeVSR, rowIndex, writtenFields, rowIdWritten);
            new ParquetShardStatsTracker()
 *
        // vsrPool.close() MUST run even if awaitPendingWrite / writer.flush() throws: a failed or
        Schema schema,
     * @param threadPool the thread pool for background native writes
    /**
            } catch (OpenSearchRejectedExecutionException e) {
        }
        }
            maybeInitializeWriter(frozenVSR);
                scrubFailure
                throw new SchemaChangeRequiresWriterRotationException(
            // Guarantee the native writer registry entry is gone even if flush() above was skipped or
            if (rowIdVector != null) {
            logger.info("Flushing {} rows for {}", currentVSR.getRowCount(), fileName);
            writerGeneration,
        assert metadata == null || metadata.numRows() == rowCount.sum() : "Row count mismatch between Java managed VSR and Rust writer";
        ParquetShardStatsTracker stats
        // Track how far admission progressed for this row so a mid-document failure can scrub exactly
     * field registry produces is either fixed- or variable-width; the final branch is a non-throwing
            if (hasSameStorageShape(existingChildren.get(i), schemaChildren.get(i)) == false) {
                    rowIndex,
     *
    /**
                        "[Gen: {}] VSR schema mismatch: field [{}] not in active VSR. VSR schema fields: {}",
     */
     * @return true if the schema is mutable
    /**
            scrubVector(activeVSR.getVector(DocumentInput.ROW_ID_FIELD), rowIndex);
        try {
    private void scrubVector(FieldVector vector, int rowIndex) {
    ) {
/*
import org.opensearch.parquet.writer.ParquetDocumentInput;
     * doesn't have enough rows to trim (rollback crossed a rotation boundary).
        this.writer = new NativeParquetWriter(fileName, stats);
        }
        if (rowIdWritten) {
        for (int i = 0; i < writtenFields; i++) {
        awaitPendingWrite(ROTATION_TIMEOUT, false);
    /**
            throw new RuntimeException("Failed to close VSRManager: " + e.getMessage(), e);
            vsrPool.completeVSR(currentVSR);
    }
     *
     */
     * already present in the active VSR.
        long writerGeneration
        // timed-out background write (IOException from awaitPendingWrite) previously skipped it,
            );
        if (currentVSR != null && currentVSR.getRowCount() > 0) {
        ArrowBufferPool bufferPool,
import org.opensearch.index.engine.dataformat.DocumentInput;
            try (ArrowExport export = currentVSR.exportToArrow()) {
            logger.warn(
        } catch (RuntimeException | Error scrubFailure) {
        activeVSR.setRowCount(activeVSR.getRowCount() - (int) diff);
        if (diff > activeVSR.getRowCount()) {
            throw e;
    /** Visible for testing — returns the pending background write future, or null. */
        int maxRowsPerVSR,
        }
                    // TODO:: we can remove this post the validation on mapping update
        this(
            return;
     * are intentionally left untouched: their slot may not be allocated, so clearing them could force a
            logger.debug("Writing frozen VSR {} ({} rows) for {}", frozenVSR.getId(), frozenVSR.getRowCount(), fileName);
        // fields fully written (getFinalInput() is written in order); rowIdWritten covers the rowId
 *
    /**
        switch (vector) {
import org.apache.logging.log4j.LogManager;
    private final IndexSettings indexSettings;
        maybeRotateActiveVSR();
    /**
            fileName,
                stats.incNativeWriteRejections();
     * @param writerGeneration the writer generation to store in file metadata
            awaitPendingWrite(ROTATION_TIMEOUT, true);
            }
        return writer.isInitialized() == false;
     *
                throw new IllegalStateException("Background write was cancelled");
        }
     */
        // in a finally so the buffers are reclaimed regardless of the drain/flush outcome.
     *
 *
     * Adds a document to the active VSR, rotating if necessary.
    }
     * or the file was empty.
    }
            maxRowsPerVSR,
        return true;
                if (parquetField == null) {
                    // Defense-in-depth: schema reconciliation is supposed to happen in
 * </ol>
            }
                    throw new MismatchedInputException(
     * Flushes the current VSR data to a Parquet file via native bridge.
    }
import org.apache.arrow.vector.BaseLargeVariableWidthVector;
                        "Active VSR has no vector for field ["
     * @param ignoreTimeout if true, log a warning on timeout instead of throwing
     *
    private final long writerGeneration;
        if (rowCount == acceptedRows) {
     * @param fileName output Parquet file path
            try (ArrowSchema schema = vsr.exportSchema()) {
        boolean runAsync,
            indexSettings,
     * @param maxRowsPerVSR row threshold triggering VSR rotation
package org.opensearch.parquet.vsr;
import org.apache.arrow.vector.BaseVariableWidthVector;
        } catch (Exception e) {
     */
        return pendingWrite;
import org.opensearch.parquet.bridge.NativeParquetWriter;
     * Compares the Arrow storage shape of two fields while ignoring field names. Arrow Java
     * Clears a single vector's slot at {@code rowIndex}, guarding the clear so it never throws. A
    }
            }
     * caller's original failure is never masked. No-op if {@code vector} is null.
    private void maybeInitializeWriter(ManagedVSR vsr) throws IOException {
                        writer.write(export.getArrayAddress(), export.getSchemaAddress());
     * <p>
                writer.write(export.getArrayAddress(), export.getSchemaAddress());
        } else {
 * during document ingestion.
     * full {@link Field#equals(Object)} comparisons spuriously report a schema change.
    }
            try {
                rowIdWritten = true;
        if (rowCount > acceptedRows) {
     * Called from {@link org.opensearch.parquet.writer.ParquetWriter#updateMappingVersion}
        }
            bufferPool,
            stats.incBackgroundWriteTimeouts();
                writer.initialize(indexName, schema.memoryAddress(), sortConfig, writerGeneration);
    public void maybeRotateActiveVSR() throws IOException {
        return acceptedRows;
import org.apache.arrow.c.ArrowSchema;
     *
        ThreadPool threadPool,
        logger.debug("VSR rotation completed for {}, new active VSR: {}", fileName, newVSR.getId());
    }
        if (existingField.getType().equals(schemaField.getType()) == false) {
import org.apache.logging.log4j.Logger;
        final int rowIndex = activeVSR.getRowCount();
                pendingWrite = threadPool.executor(vsrRotationThread).submit(writeTask);
     * Creates a new VSRManager with asynchronous background writes (production default).
            if (writer != null) {
 * Handles the complete flow:
     * renames a {@code ListVector} child from {@code element} to {@code $data$} internally, so
                throw e;
        stats.incVsrRotations();
    }
        this.managedVSR.set(vsrPool.getActiveVSR());
            String indexName = indexSettings.getIndex().getName();
     * Checks if VSR rotation is needed before accepting the next document.
            true,
                throw new IllegalStateException(pendingWrite.exceptionNow());
     * <p>Best-effort and strictly non-throwing (see {@link #scrubVector}): a failure clearing any single
        // stranding the pool's per-VSR child allocators (their off-heap Arrow buffers leaked onto
    }
        );
     * Transfers collected fields from the document input into the active VSR
     */
                rowCount.add(currentVSR.getRowCount());
     * @return metadata about the written Parquet file, or null if no data to flush
        this.stats = stats;
            if (writer != null) {
    private long acceptedRows = 0L;
            threadPool,
        if (writer.isInitialized() == false) {
    public void close() {
            try {
            }
     * @param doc the document input containing field-value pairs
     */
        ArrowBufferPool bufferPool,
            managedVSR.set(null);
                    throw new MismatchedInputException(
 * this file be licensed under the Apache-2.0 license or a
     * @param writtenFields number of leading source fields fully written for this row
 * compatible open source license.
                "rowId [" + doc.getRowId() + "] does not match accepted row count [" + acceptedRows + "] for " + fileName
    public void rollbackTo(long rowCount) {
        this(fileName, indexSettings, schema, bufferPool, maxRowsPerVSR, threadPool, true, writerGeneration, stats);
        }
     * @param schema Arrow schema for vector creation
            return;
    void setPendingWrite(Future<?> future) {
            throw new IllegalStateException("Cannot rollback " + diff + " rows: active VSR only has " + activeVSR.getRowCount() + " rows");
        if (vector == null) {
        this.pendingWrite = future;
import org.apache.arrow.vector.types.pojo.Field;
                // Pool saturated — count the rejection and re-throw (surfaces as HTTP 429).
        List<FieldValuePair> fields = doc.getFinalInput();
                ),
                writer.cleanup();
     * Returns whether the schema can still evolve (native writer not yet initialized).
    }
    public VSRManager(
                vsrPool.unsetFrozenVSR();
            fileName,
    }
        }
        }
    private volatile Future<?> pendingWrite;
            throw new IllegalStateException(
            schema,
     * as a memory-efficient packed mapping, or null if no sorting was configured
     */
    }
     * survives to leak into the next document that reuses this row index (issue #22417).
        String fileName,
 * (native Rust Parquet writer) to provide a single entry point for document ingestion.
     * @param bufferPool shared Arrow buffer pool
     * @param doc           the document being admitted; source of the written field prefix, in order
            }
     */
            }
        logger.debug("VSR rotation occurred for {}", fileName);
            throw new IOException("No active VSR available after rotation");
        for (int i = 0; i < existingChildren.size(); i++) {
                    throw new RuntimeException(e);
                    vector.getName(),
    private static final Logger logger = LogManager.getLogger(VSRManager.class);
            }
        }
        }
        );
            // when flush() already finalized and removed the entry. Without this, a stranded entry
            managedVSR.set(null);
