     */
        } else {  
        Schema schema,
        ParquetShardStatsTracker stats
    public void close() {
            for (FieldValuePair pair : doc.getFinalInput()) {
     * <p>
                changed = true;
        return metadata;
            indexSettings,
        if (existingField.getType().equals(schemaField.getType()) == false) {  
 * SPDX-License-Identifier: Apache-2.0
        }  
     * validity-bit clear and never triggers a (re)allocation — safe to run under the memory pressure
        }
            managedVSR.set(null);  
        return writer.isInitialized() == false;
     * Checks if VSR rotation is needed before accepting the next document.
     * growth allocation.
     * top-level validity bit.
            BigIntVector rowIdVector = (BigIntVector) activeVSR.getVector(DocumentInput.ROW_ID_FIELD);  
            if (writer != null) {
import org.opensearch.index.engine.dataformat.DocumentInput;  
package org.opensearch.parquet.vsr;
    private void scrubPartialRow(ParquetDocumentInput doc, ManagedVSR activeVSR, int rowIndex, int writtenFields, boolean rowIdWritten) {
                rowIdWritten = true;  
    /**
        }  
        this.pendingWrite = future;
    /**  
    /**
            }  
    /**
            stats.incBackgroundWriteTimeouts();
    private void awaitPendingWrite(long timeoutSeconds, boolean ignoreTimeout) throws IOException {  
     * that may have caused the failure. The field that actually failed, and any fields ordered after it,
            // Guarantee the native writer registry entry is gone even if flush() above was skipped or  
                throw new IllegalStateException("Background write was cancelled");  
                parquetField.createField(fieldType, activeVSR, pair.getValue());  
     * order) plus, when {@code rowIdWritten}, the rowId vector. Because each of those writes completed,
        List<Field> existingChildren = existingField.getChildren();  
                logger.warn("Timed out waiting for background VSR write for {}", fileName);  
        for (Field schemaField : newSchema.getFields()) {
                MappedFieldType fieldType = pair.getFieldType();
                    schemaField.getName(),
            // when flush() already finalized and removed the entry. Without this, a stranded entry
            schema,
import org.apache.arrow.vector.BaseFixedWidthVector;
        // stranding the pool's per-VSR child allocators (their off-heap Arrow buffers leaked onto
     * @param writerGeneration the writer generation to store in file metadata
        // Re-check the rowId invariant so a single-format Parquet path is protected too.
            return;  
            currentVSR.moveToFrozen();
            } else {
        boolean rowIdWritten = false;
        }
        ManagedVSR frozenVSR = vsrPool.getFrozenVSR();
 * compatible open source license.
        stats.incVsrRotations();  
        IndexSettings indexSettings,
import org.apache.arrow.c.ArrowSchema;
            runAsync,  
        return acceptedRows;
import org.opensearch.parquet.fields.ArrowFieldRegistry;
        int writtenFields = 0;
        return writer.getRowIdMapping();  
    private volatile Future<?> pendingWrite;
     *  
            // blocks recovery's re-create for the same file ("Writer already exists").  
import org.apache.arrow.vector.BitVectorHelper;  
            String indexName = indexSettings.getIndex().getName();
            }
        if (rowIdWritten) {  
     * Returns whether the schema can still evolve (native writer not yet initialized).
     * full {@link Field#equals(Object)} comparisons spuriously report a schema change.  
                return false;
     */  
                        activeVSR.getSchema().getFields().stream().map(f -> f.getName()).collect(java.util.stream.Collectors.joining(", "))
            bufferPool,  
        this.threadPool = threadPool;  
            setNull(vector, rowIndex);  
     * {@code writtenFields} fields of {@link ParquetDocumentInput#getFinalInput()} (which is written in
     */
     * its slot at {@code rowIndex} is already allocated, so {@link #setNull} degrades to a plain  
            // that reuses this row index, then rethrow the original failure unchanged. Precise
     * fallback for any other vector type (e.g. a future nested/view field) that clears only the
                        writer.write(export.getArrayAddress(), export.getSchemaAddress());
        );
                    "[Gen: {}] Failed to scrub partial row {} for vector [{}] in {}; column may retain a stale value",
            throw new IOException("Background VSR write failed for " + fileName, e.getCause());  
     * present in {@code newSchema} but not yet in the active VSR. Also updates the pool
import org.opensearch.parquet.writer.ParquetDocumentInput;
                    // TODO:: we can remove this post the validation on mapping update  
                () -> new ParameterizedMessage(  
            try (ArrowSchema schema = vsr.exportSchema()) {  
    private static final Logger logger = LogManager.getLogger(VSRManager.class);
        }
 */
        this.vsrRotationThread = runAsync ? ParquetDataFormatPlugin.PARQUET_THREAD_POOL_NAME : ThreadPool.Names.SAME;
        this.writerGeneration = writerGeneration;  
                    }
     * Rolls the VSR back to hold exactly {@code rowCount} admitted rows. No-op if already  
 * <p>Field values are resolved to their Arrow vector types via {@link ArrowFieldRegistry}
    }  
        try {  
    /**
     */
            throw new IOException("No active VSR available after rotation");
            case BaseFixedWidthVector fixed -> fixed.setNull(index);  
                            + fieldType.name()
     * a new active VSR. If the frozen slot is occupied, rotation is skipped.
    public boolean isSchemaMutable() {  
    public ParquetFileMetadata flush() throws IOException {  
            }
                );
     * Creates a new VSRManager with asynchronous background writes (production default).  
    public void rollbackTo(long rowCount) {  
        if (pendingWrite == null) {
                    logger.error(  
    private final ParquetShardStatsTracker stats;
     *
     * as a memory-efficient packed mapping, or null if no sorting was configured
        int maxRowsPerVSR,
        if (rotated == false) {  
            throw new IllegalStateException("Cannot rollback to " + rowCount + ": only " + acceptedRows + " rows in VSR");
        } catch (Exception e) {  
import org.opensearch.parquet.writer.FieldValuePair;  
    private LongAdder rowCount = new LongAdder();
    /**  
        long writerGeneration,  
    }  
     * Clears the value at {@code index} by unsetting its validity bit, so the slot reads as null.
     * Compares the Arrow storage shape of two fields while ignoring field names. Arrow Java
     */
    ) {
        activeVSR.setRowCount(activeVSR.getRowCount() - (int) diff);  
                    // out of sync with the mapping — surface as a recoverable failure.
                throw new IOException("Timed out waiting for background VSR write for " + fileName, e);
        final int rowIndex = activeVSR.getRowCount();
     * Transfers collected fields from the document input into the active VSR
import java.util.concurrent.atomic.AtomicReference;
            scrubVector(activeVSR.getVector(fields.get(i).getFieldType().name()), rowIndex);
     * vector is logged and the remaining vectors are still scrubbed, so the original write failure (which
import org.opensearch.index.IndexSettings;
    }  
                    );  
    ) {
        this(fileName, indexSettings, schema, bufferPool, maxRowsPerVSR, threadPool, true, writerGeneration, stats);  
            default -> BitVectorHelper.unsetBit(vector.getValidityBuffer(), index);  
                pendingWrite.get(timeoutSeconds, TimeUnit.SECONDS);
                    throw new MismatchedInputException(
     */
        }  
    private void scrubVector(FieldVector vector, int rowIndex) {
/*  
            bufferPool,
                if (activeVSR.getVector(fieldType.name()) == null) {
        }
        }  
    }
                }
        // in a finally so the buffers are reclaimed regardless of the drain/flush outcome.  
     * or the file was empty.  
        }  
            logger.info("Flushing {} rows for {}", currentVSR.getRowCount(), fileName);
     * Initializes the native writer on first use, using the schema from the given VSR.  
            logger.debug("no changes in schema despite change in mapping version");
        int maxRowsPerVSR,  
        this.fileName = fileName;
            }
    @Override  
        logger.debug("VSR rotation completed for {}, new active VSR: {}", fileName, newVSR.getId());
        ThreadPool threadPool,  
        Schema schema,
        IndexSettings indexSettings,
    }  
                }
        boolean runAsync,  
    /** Visible for testing — injects a pending background write future to exercise close() paths. */
        }
import java.util.List;  
     * @param ignoreTimeout if true, log a warning on timeout instead of throwing
    }
     * @param doc the document input containing field-value pairs  
 *
        if (currentVSR != null && currentVSR.getRowCount() > 0) {  
                throw e;
            }
        IndexSettings indexSettings,
    /**
        String fileName,
     */
        long writerGeneration,
            }  
public class VSRManager implements AutoCloseable {
            case BaseLargeVariableWidthVector large -> large.setNull(index);
        ManagedVSR activeVSR = managedVSR.get();
     * @param schema Arrow schema for vector creation
        switch (vector) {
        }
     * @param bufferPool shared Arrow buffer pool  
            throw new RuntimeException("Failed to close VSRManager: " + e.getMessage(), e);
        // vector written after the loop. See scrubPartialRow.  
                        writerGeneration,
import java.util.concurrent.Future;
    void setPendingWrite(Future<?> future) {  
        this(  
            stats.incBackgroundWriteTotal();
     *
        }
     */
    private final IndexSettings indexSettings;
            // rethrow keeps addDocument's throws clause unchanged.
            true,
import org.opensearch.parquet.stats.ParquetShardStatsTracker;
            case BaseVariableWidthVector variable -> variable.setNull(index);
                if (parquetField == null) {
     * Returns the row ID mapping produced during the last flush's sort-on-close
     * {@code multi_value: true} accumulate every value into one list-valued pair,  
     * @param threadPool the thread pool for background native writes
            try {
            activeVSR.setRowCount(rowIndex + 1);
        for (int i = 0; i < writtenFields; i++) {  
    }
        List<FieldValuePair> fields = doc.getFinalInput();
            }
        } catch (Exception e) {
 * The OpenSearch Contributors require contributions made to  
                logger.error("Error releasing VSR pool during close for {}: {}", fileName, e.getMessage());
 *
        long writerGeneration  
     * @param writtenFields number of leading source fields fully written for this row
 *   <li>{@link #flush()} — freezes the active VSR, exports it to the native writer,
     * @param activeVSR     the VSR the row was being written into
     *  
            // Any failure between the first field write and acceptance leaves an uncounted partial
    }
        // Track how far admission progressed for this row so a mid-document failure can scrub exactly  
     *
    public VSRManager(
            maxRowsPerVSR,
                    existingVector.getField().getType(),
     * the caller rethrows) is never masked.
        if (diff > activeVSR.getRowCount()) {  
        ManagedVSR activeVSR = managedVSR.get();
            managedVSR.set(null);
        }
     *                 if false, they run on the calling thread (for benchmarks/tests)
     */
            } catch (Exception e) {  
                writer.write(export.getArrayAddress(), export.getSchemaAddress());  
                            + "] — schema reconciliation must run via updateMappingVersion before addDocument"  
                writtenFields++;
     * Scrubs a partially-written, uncounted row after a mid-document failure so no stale value  
            if (rowIdVector != null) {
 * this file be licensed under the Apache-2.0 license or a
 */  
     *  
     * field registry produces is either fixed- or variable-width; the final branch is a non-throwing  
        }
        for (int i = 0; i < existingChildren.size(); i++) {
     *
            if (timeoutSeconds > 0) {  
        ArrowBufferPool bufferPool,
     * rewrite the value/offset data of {@code index} or any other row. Callers here only pass slots
    private final VSRPool vsrPool;  
import org.opensearch.threadpool.ThreadPool;  
                    );
                        "Active VSR has no vector for field ["
     * Creates a new VSRManager without stats collection.
     * already present in the active VSR.  
 * if instances are shared across threads.  
            if (writer != null) {  
        Schema schema,
                ),  
            new ParquetShardStatsTracker()  
    ) {  
    }
    /**
    /**
    // Visible for testing only
    /**
     */  
                    throw new RuntimeException(e);
            // row. Scrub it (best-effort, never throws) so no stale value can leak into the next doc  
        try {
        String fileName,  
                } catch (IOException e) {  
            } else if (state == Future.State.CANCELLED) {
        this(
     * Adds a document to the active VSR, rotating if necessary.
                rowCount.add(currentVSR.getRowCount());
import org.opensearch.parquet.bridge.NativeParquetWriter;
     * Field Shape is decided at the {@link ParquetDocumentInput} layer: fields mapped with
     */  
    public VSRManager(  
        ThreadPool threadPool,
     * are intentionally left untouched: their slot may not be allocated, so clearing them could force a  
    }
        this.stats = stats;
            long elapsed = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
                    // Defense-in-depth: schema reconciliation is supposed to happen in
                pendingWrite = threadPool.executor(vsrRotationThread).submit(writeTask);
        ManagedVSR newVSR = vsrPool.getActiveVSR();
     * @return metadata about the written Parquet file, or null if no data to flush
        List<Field> schemaChildren = schemaField.getChildren();
     * whose successful write already allocated them, so no growth occurs. Every vector type the Parquet
     * doesn't have enough rows to trim (rollback crossed a rotation boundary).
                scrubFailure
    private static boolean hasSameStorageShape(Field existingField, Field schemaField) {
        ArrowBufferPool bufferPool,  
                writer.flush();
        try {
            maybeInitializeWriter(currentVSR);  
            FieldVector existingVector = activeVSR.getVector(schemaField.getName());
                        fieldType.name(),  
            // threw (e.g. a background write / flush failed under an Arrow OOM). Idempotent: a no-op
import java.io.IOException;
    Future<?> getPendingWrite() {
    /** Visible for testing — returns the pending background write future, or null. */  
        if (writer.isInitialized() == false) {  
        return pendingWrite;
     * @param timeoutSeconds timeout in seconds (0 means wait indefinitely)  
     * when the mapping version advances. No-op if every field in {@code newSchema} is
        boolean rotated = vsrPool.maybeRotateActiveVSR();
            }
    ManagedVSR getActiveManagedVSR() {
    }
            };
                    rowIndex,  
     * (growing the validity/offset buffers first if {@code index} is beyond capacity); it does not  
     * schema so subsequently rotated VSRs include the new fields.
        if (existingChildren.size() != schemaChildren.size()) {
     *  
import org.opensearch.parquet.ParquetDataFormatPlugin;
        }  
            return;
                writer.cleanup();
                rowIdVector.setSafe(rowIndex, doc.getRowId());
            if (state == Future.State.FAILED) {
        if (changed) {
                pendingWrite.get();  
        if (newVSR == null) {  
        boolean runAsync,
        ArrowBufferPool bufferPool,  
        managedVSR.set(newVSR);  
                vsrPool.close();
 * <p>Combines {@link VSRPool} (Arrow batch management) with {@link NativeParquetWriter}
    public boolean reconcileSchema(Schema newSchema) {
            throw e;
import org.opensearch.index.mapper.MappedFieldType;
            }
    /**
        );  
            maybeInitializeWriter(frozenVSR);
            acceptedRows++;  
     * freezes the active VSR, submits it for background native write, and creates
    public long getAcceptedRows() {
    public void addDocument(ParquetDocumentInput doc) throws IOException {
        this.managedVSR.set(vsrPool.getActiveVSR());
        }
     * @param rowCount the desired row count after this call
import java.util.concurrent.atomic.LongAdder;
     * Waits for any in-flight background write to complete with an optional timeout.
     * Reconciles the active VSR with the given schema by adding vectors for any fields  
import org.opensearch.index.engine.dataformat.RowIdMapping;
                vsrPool.completeVSR(frozenVSR);  
     * caller's original failure is never masked. No-op if {@code vector} is null.
import org.apache.arrow.vector.types.pojo.Field;
     * <p>  
            maxRowsPerVSR,
                    vector.getName(),
 * </ol>  
        } catch (TimeoutException e) {  
    public VSRManager(
     * Creates a new VSRManager.
    private static void setNull(FieldVector vector, int index) {
            return false;
    }
        // vsrPool.close() MUST run even if awaitPendingWrite / writer.flush() throws: a failed or
            pendingWrite = null;
                    try (ArrowExport export = frozenVSR.exportToArrow()) {
    }  
import org.apache.arrow.vector.BaseLargeVariableWidthVector;  
import org.apache.arrow.vector.BigIntVector;
     * survives to leak into the next document that reuses this row index (issue #22417).
                        "[Gen: {}] VSR schema mismatch: field [{}] not in active VSR. VSR schema fields: {}",
            if (ignoreTimeout) {
     * @param rowIdWritten  whether the rowId vector was written for this row
            awaitPendingWrite(ROTATION_TIMEOUT, true);
}  
     * Clears a single vector's slot at {@code rowIndex}, guarding the clear so it never throws. A  
 * Top-level orchestrator for the Arrow batching → Parquet file generation pipeline.
     * @return true if the schema is mutable
    private final int ROTATION_TIMEOUT = 120;
        try {
            return;
     */  
 * (native Rust Parquet writer) to provide a single entry point for document ingestion.
     * Called from {@link org.opensearch.parquet.writer.ParquetWriter#updateMappingVersion}
            }  
import org.opensearch.parquet.writer.MismatchedInputException;
        return true;
 *  
    private final String fileName;
            scrubVector(activeVSR.getVector(DocumentInput.ROW_ID_FIELD), rowIndex);
            schema,  
        maybeRotateActiveVSR();  
                    // ParquetWriter.updateMappingVersion before any addDocument with a new  
     * @param doc           the document being admitted; source of the written field prefix, in order
        String fileName,
    /**  
        }
     * at the target. Throws if the target is higher than current or if the active VSR
        boolean changed = false;  
            writerGeneration,
            throw new IllegalStateException(  
        ManagedVSR activeVSR = managedVSR.get();
        logger.debug("VSR rotation occurred for {}", fileName);
            vsrPool.updateSchema(activeVSR.getSchema());
     * Creates a new VSRManager with asynchronous background writes and no stats collection.
    private final String vsrRotationThread;
     * using the ArrowFieldRegistry to resolve typed vector writes.  
            new ParquetShardStatsTracker()
    /**
                "rowId [" + doc.getRowId() + "] does not match accepted row count [" + acceptedRows + "] for " + fileName
    }  
        acceptedRows = rowCount;
     * @param indexSettings the index settings (sort config is read from here)
            stats.incBackgroundWriteFailures();
import org.opensearch.parquet.bridge.ParquetSortConfig;
            }
        if (pendingWrite != null && pendingWrite.isDone()) {  
        logger.debug("Flush completed for {} with metadata: {}", fileName, metadata);
            logger.warn(
        // the slots a successful write already allocated. writtenFields is the count of leading source
/**
        if (rowCount > acceptedRows) {
     */  
import org.apache.arrow.vector.FieldVector;
     */
            fileName,  
            } else if (hasSameStorageShape(existingVector.getField(), schemaField) == false) {
                    writerGeneration,
     *
import org.apache.logging.log4j.LogManager;
        }
 *   <li>{@link #addDocument(ParquetDocumentInput)} — transfers document fields into the active
    /**  
            throw new IllegalStateException("Cannot rollback " + diff + " rows: active VSR only has " + activeVSR.getRowCount() + " rows");
                stats.incBackgroundWriteFailures();  
            scrubPartialRow(doc, activeVSR, rowIndex, writtenFields, rowIdWritten);  
        int maxRowsPerVSR,
    private final AtomicReference<ManagedVSR> managedVSR = new AtomicReference<>();  
        IndexSettings indexSettings,  
                    schemaField.getType()  
     * renames a {@code ListVector} child from {@code element} to {@code $data$} internally, so
        this.indexSettings = indexSettings;
        long startNanos = System.nanoTime();
                throw new IllegalStateException(pendingWrite.exceptionNow());
        }
    private final long writerGeneration;  
    public VSRManager(
 * <p>This class is NOT Thread-Safe. External synchronization is required
            return;
        }
    }  
     * @param runAsync if true, frozen VSR writes run on the background thread pool;  
            if (existingVector == null) {  
            try {  
        if (doc.getRowId() != acceptedRows) {
        }
     * @param maxRowsPerVSR row threshold triggering VSR rotation
                    throw new MismatchedInputException(  
import org.opensearch.parquet.bridge.ParquetFileMetadata;  
            threadPool,  
        Schema schema,  
 *       finalizes the Parquet file, and returns file metadata.</li>
 * during document ingestion.  
        ManagedVSR currentVSR = managedVSR.get();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        }
                vsrPool.unsetFrozenVSR();
        awaitPendingWrite(ROTATION_TIMEOUT, false);
        // the ingest pool for the node's lifetime — "Memory was leaked by query"). Release the pool
import org.apache.arrow.vector.BaseVariableWidthVector;
     * <p>Only the vectors whose write for this row already <em>succeeded</em> are reset: the leading  
import org.opensearch.nativebridge.spi.ArrowExport;  
        this.writer = new NativeParquetWriter(fileName, stats);  
 * <ol>
            );
            } catch (OpenSearchRejectedExecutionException e) {
                }
        if (frozenVSR != null) {  
     * failure on one vector is logged and swallowed so the remaining vectors are still scrubbed and the
                    fileName
import org.apache.logging.log4j.message.ParameterizedMessage;  
            try (ArrowExport export = currentVSR.exportToArrow()) {
            indexSettings,
import org.opensearch.parquet.fields.ParquetField;  
            logger.error("Error during close for {}: {}", fileName, e.getMessage());
    /**  
                    );
                ParquetField parquetField = ArrowFieldRegistry.getParquetField(fieldType.typeName());  
            Runnable writeTask = () -> {  
     * Flushes the current VSR data to a Parquet file via native bridge.
     */
        }  
        ThreadPool threadPool,
            writerGeneration,
        } finally {  
    /**  
                        "No ParquetField mapping for field [" + fieldType.name() + "] of type [" + fieldType.typeName() + "]"
     *
        assert metadata == null || metadata.numRows() == rowCount.sum() : "Row count mismatch between Java managed VSR and Rust writer";  
            logger.debug("Writing frozen VSR {} ({} rows) for {}", frozenVSR.getId(), frozenVSR.getRowCount(), fileName);
     * <p>Best-effort and strictly non-throwing (see {@link #scrubVector}): a failure clearing any single  
        ThreadPool threadPool,
     */  
                // Pool saturated — count the rejection and re-throw (surfaces as HTTP 429).  
    /**
    }
        String fileName,  
     * @param newSchema the schema to reconcile against
 *       VSR's Arrow vectors, rotating the VSR if the row threshold is reached.</li>  
        // fields fully written (getFinalInput() is written in order); rowIdWritten covers the rowId
    }
import org.apache.arrow.vector.types.pojo.Schema;  
        return managedVSR.get();  
     * Syncs the Parquet file to disk. Must be called after {@link #flush()}.  
                // Pass the schema field through as-is: rebuilding it from name + FieldType alone
        // timed-out background write (IOException from awaitPendingWrite) previously skipped it,  
        if (vector == null) {
    public void maybeRotateActiveVSR() throws IOException {
 *
    public RowIdMapping getRowIdMapping() {
 * Handles the complete flow:  
            ParquetSortConfig sortConfig = new ParquetSortConfig(indexSettings);
        long writerGeneration
            stats.addBackgroundWriteWaitMillis(elapsed);  
        ParquetShardStatsTracker stats
        if (rowCount == acceptedRows) {
        long diff = acceptedRows - rowCount;
        }  
    }
     * If the active VSR has reached the row threshold and the frozen slot is empty,  
     * @param stats shard-level stats tracker  
            threadPool,
                // would drop getChildren(), leaving a LIST column with no element vector.
    }
        } catch (RuntimeException | Error scrubFailure) {
                throw new SchemaChangeRequiresWriterRotationException(  
                        rowCount.add(frozenVSR.getRowCount());  
        ParquetFileMetadata metadata = writer.flush();
            return false;  
     */
import org.opensearch.parquet.memory.ArrowBufferPool;
                stats.incNativeWriteRejections();
        this.vsrPool = new VSRPool("pool-" + fileName, schema, bufferPool, maxRowsPerVSR);
        int maxRowsPerVSR,
                    // field type. If we still see an unmapped type here, the writer is
            );
        ArrowBufferPool bufferPool,
import java.util.concurrent.TimeoutException;  
        } catch (Exception e) {
    private final NativeParquetWriter writer;  
     * @param rowIndex      the uncommitted row index to clear  
            }
            fileName,
import java.util.concurrent.TimeUnit;
    }
    ) {
        } finally {
                try {
    }
     * In Arrow 18.1.0 every vector's {@code setNull} clears only the validity bit at {@code index}
    /**  
            Future.State state = pendingWrite.state();
            vsrPool.completeVSR(currentVSR);
import org.apache.logging.log4j.Logger;
            if (hasSameStorageShape(existingChildren.get(i), schemaChildren.get(i)) == false) {  
    private long acceptedRows = 0L;  
        return changed;  
    private final ThreadPool threadPool;
            }
    }
    private void maybeInitializeWriter(ManagedVSR vsr) throws IOException {
     */
                activeVSR.addFieldVector(schemaField);  
                writer.initialize(indexName, schema.memoryAddress(), sortConfig, writerGeneration);
     * and all other fields still reject a second value.
     * @param fileName output Parquet file path  
            } else {
