    /**  
     */
    public ParquetFileMetadata flush() throws IOException {
    private static final Logger logger = LogManager.getLogger(NativeParquetWriter.class);  
 *
    }
    }
                }, stats::addNativeFinalizeTimeMillis, stats::incNativeFinalizeTotal, stats::incNativeFinalizeFailures);
    /**  
        RustBridge.createWriter(filePath, indexName, schemaAddress, sortConfig, writerGeneration);  
        if (writerFlushed.compareAndSet(false, true)) {  
            logger.warn("Failed to clean up native writer for {}: {}", filePath, e.getMessage());  
 * <ol>  
import java.util.concurrent.atomic.AtomicBoolean;  
     * Returns the Parquet file metadata captured after flushing the writer.
        initialized = true;
        }
     *  
     * @param schemaAddress the native memory address of the Arrow schema
     * @throws IOException if the native writer creation fails
    /**
        }
                    }  
    /**
     *  
import java.io.IOException;
     * packed mapping, or null if no sorting was configured or the file was empty.  
    }
 * if instances are shared across threads.
            throw new IllegalStateException("Writer already initialized: " + filePath);
                        metadata.set(result.metadata());
     * initialized (no native entry exists) or was already flushed (finalize already removed it).  
     * Finalizes the Parquet file and returns metadata. If the writer was never initialized
 *   <li>{@link #initialize(String, long, ParquetSortConfig, long)} — creates the native writer with the final schema</li>
    }
    /**
                    RustBridge.WriterFinalizeResult result = RustBridge.finalizeWriter(filePath);  
    public void initialize(String indexName, long schemaAddress, ParquetSortConfig sortConfig, long writerGeneration) throws IOException {
import org.opensearch.index.engine.dataformat.RowIdMapping;
 * <p>This class is not thread-safe. External synchronization is required
 */  
 * this file be licensed under the Apache-2.0 license or a
    }
     * (no documents were written), returns null rather than throwing — this is expected
     * Removes the native writer registry entry for this file without finalizing it. Idempotent and
    private final ParquetShardStatsTracker stats;  
            stats::incNativeWriteFailures
 * SPDX-License-Identifier: Apache-2.0
     * @throws IOException if the write fails or the writer is flushed  
     */
    private final SetOnce<ParquetFileMetadata> metadata = new SetOnce<>();
        return rowIdMapping.get();  
                            rowIdMapping.set(result.rowIdMapping());
     * @param filePath the path to the Parquet file to write  
 *   <li>{@link #flush()} — finalizes the Parquet file and returns metadata</li>
     * Creates a new NativeParquetWriter handle. Does not create the native writer —
        }
    private final AtomicBoolean writerFlushed = new AtomicBoolean(false);
     */
import org.apache.logging.log4j.Logger;
        try {  
    }
/**
        } catch (Exception e) {
     */  
import org.opensearch.parquet.stats.ParquetShardStatsTracker;
    /**  
import org.opensearch.common.SetOnce;  
     * writer stranded by a failed operation does not survive as a stale entry and block recovery's
public class NativeParquetWriter {
            }
     * @throws IOException if the finalization fails  
    public void cleanup() {
     *
     * @param stats shard-level stats tracker
}
    public NativeParquetWriter(String filePath, ParquetShardStatsTracker stats) {
     */
     * @return true if {@link #initialize} has been called
     * when a writer is flushed during refresh without having received any documents.  
        if (writerFlushed.get()) {
 * compatible open source license.
            stats::incNativeWriteTotal,
            if (initialized) {
        return metadata.get();
            throw new IOException("Cannot write to flushed Parquet writer: " + filePath);
     * call {@link #initialize(String, long, ParquetSortConfig, long)} before the first write.
            RustBridge.cleanupWriter(filePath);
 * The OpenSearch Contributors require contributions made to  
    public void write(long arrayAddress, long schemaAddress) throws IOException {  
    /**
    }
     *  
        this.filePath = filePath;
     * @return the file metadata, or null if the writer was never initialized
     * @return the file metadata, or null if the writer has not been flushed
    }
     * Initializes the native Rust Parquet writer with the given schema.
 *
    public ParquetFileMetadata getMetadata() {  
        return metadata.get();
 *  
     * @throws IllegalStateException if the writer has not been initialized
    /**  
            throw new IllegalStateException("Writer not initialized: " + filePath);
            stats::addNativeWriteTimeMillis,  
 * <p>Wraps the stateless JNI methods in {@link RustBridge} with a file-scoped lifecycle:
     *
    public boolean isInitialized() {  
     * @param arrayAddress  the native memory address of the Arrow array
     * @param schemaAddress     the native memory address of the Arrow schema
        if (initialized == false) {
    public RowIdMapping getRowIdMapping() {
                        if (result.rowIdMapping() != null) {  
package org.opensearch.parquet.bridge;
            return; // no native entry was ever created
 */  
     * Writes an Arrow batch to the Parquet file.
            () -> RustBridge.write(filePath, arrayAddress, schemaAddress),
import org.opensearch.plugin.stats.StatsRecorder;  
     */
        return initialized;
        }  
 * Type-safe handle for the native Rust Parquet writer with lifecycle management.  
     * @param indexName         the index name for settings lookup
     */
     * Must be called exactly once before the first {@link #write}.
     * @param filePath the path to the Parquet file to write
     */
     * @param writerGeneration  the writer generation to store in file metadata
        this.stats = stats;  
 *   <li>{@code new NativeParquetWriter(filePath)} — creates the handle (no native call)</li>
        }  
    public NativeParquetWriter(String filePath) {
 *   <li>{@link #write(long, long)} — sends one or more Arrow batches (repeatable)</li>  
import org.apache.logging.log4j.LogManager;
     * Creates a new NativeParquetWriter handle without stats collection.
     *  
     * @throws IllegalStateException if already initialized  
/*  
        StatsRecorder.recordOutcome(
                StatsRecorder.recordOutcome(() -> {
    private final String filePath;  
        if (initialized == false) {  
                    if (result != null) {
     *  
    private final SetOnce<RowIdMapping> rowIdMapping = new SetOnce<>();
        if (initialized) {  
    private volatile boolean initialized = false;
    }
     * Returns whether the native writer has been initialized.
    /**  
        this(filePath, new ParquetShardStatsTracker());  
     */
     * Returns the row ID mapping produced during sort-on-close as a memory-efficient
        }  
     * Never throws — intended for the shard close / going-red teardown path, where it guarantees a
     * @param sortConfig        the sort configuration for the Parquet file  
     * best-effort: safe to call after a failed/partial flush, and a no-op if this writer was never
     * re-create for the same file.  
        );  
                        }
 * </ol>
