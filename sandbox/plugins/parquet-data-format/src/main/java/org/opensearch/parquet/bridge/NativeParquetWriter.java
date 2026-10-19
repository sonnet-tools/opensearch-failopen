     */
     * Creates a new NativeParquetWriter handle without stats collection.
    public void cleanup() {
        this.stats = stats;
            throw new IllegalStateException("Writer already initialized: " + filePath);
    private final AtomicBoolean writerFlushed = new AtomicBoolean(false);
     * writer stranded by a failed operation does not survive as a stale entry and block recovery's
                        metadata.set(result.metadata());
 * compatible open source license.
 *   <li>{@link #flush()} — finalizes the Parquet file and returns metadata</li>
     * best-effort: safe to call after a failed/partial flush, and a no-op if this writer was never
     * (no documents were written), returns null rather than throwing — this is expected
        }
    /**
    public ParquetFileMetadata flush() throws IOException {
    /**
import java.util.concurrent.atomic.AtomicBoolean;
            stats::incNativeWriteTotal,
            if (initialized) {
     *
     * @throws IOException if the finalization fails
    public NativeParquetWriter(String filePath) {
 * Type-safe handle for the native Rust Parquet writer with lifecycle management.
     * Returns the Parquet file metadata captured after flushing the writer.
     *
     * @param writerGeneration  the writer generation to store in file metadata
        this(filePath, new ParquetShardStatsTracker());
    private final String filePath;
import org.opensearch.index.engine.dataformat.RowIdMapping;
     * @throws IllegalStateException if already initialized
     * re-create for the same file.
            RustBridge.cleanupWriter(filePath);
     */
     * call {@link #initialize(String, long, ParquetSortConfig, long)} before the first write.
     * @param stats shard-level stats tracker
    public boolean isInitialized() {
import org.opensearch.parquet.stats.ParquetShardStatsTracker;
     * Writes an Arrow batch to the Parquet file.
import java.io.IOException;
        if (initialized == false) {
 * <ol>
        return metadata.get();
                    RustBridge.WriterFinalizeResult result = RustBridge.finalizeWriter(filePath);
        }
        }
 *   <li>{@link #write(long, long)} — sends one or more Arrow batches (repeatable)</li>
        if (initialized) {
        StatsRecorder.recordOutcome(
            throw new IOException("Cannot write to flushed Parquet writer: " + filePath);
            }
        initialized = true;
     * @return true if {@link #initialize} has been called
            logger.warn("Failed to clean up native writer for {}: {}", filePath, e.getMessage());
     */
        return rowIdMapping.get();
    /**
        if (initialized == false) {
 * SPDX-License-Identifier: Apache-2.0
    /**
        return initialized;
    private volatile boolean initialized = false;
    }
/*
     */
     * @throws IOException if the native writer creation fails
     * Never throws — intended for the shard close / going-red teardown path, where it guarantees a
 * if instances are shared across threads.
        RustBridge.createWriter(filePath, indexName, schemaAddress, sortConfig, writerGeneration);
        }
    private static final Logger logger = LogManager.getLogger(NativeParquetWriter.class);
 *   <li>{@link #initialize(String, long, ParquetSortConfig, long)} — creates the native writer with the final schema</li>
                        }
     * @return the file metadata, or null if the writer was never initialized
                StatsRecorder.recordOutcome(() -> {
    public RowIdMapping getRowIdMapping() {
package org.opensearch.parquet.bridge;
        try {
     * when a writer is flushed during refresh without having received any documents.
 */
    }
     * Must be called exactly once before the first {@link #write}.
                    if (result != null) {
 *
     *
     *
import org.opensearch.common.SetOnce;
    }
    private final ParquetShardStatsTracker stats;
}
     * @param filePath the path to the Parquet file to write
     * initialized (no native entry exists) or was already flushed (finalize already removed it).
import org.apache.logging.log4j.LogManager;
    }
     * Creates a new NativeParquetWriter handle. Does not create the native writer —
     * Returns whether the native writer has been initialized.
    /**
     * Initializes the native Rust Parquet writer with the given schema.
     *
     * @throws IOException if the write fails or the writer is flushed
     * @param sortConfig        the sort configuration for the Parquet file
    /**
     *
    /**
    }
     * Removes the native writer registry entry for this file without finalizing it. Idempotent and
    /**
     */
     * Returns the row ID mapping produced during sort-on-close as a memory-efficient
    }
     */
            return; // no native entry was ever created
     * @param arrayAddress  the native memory address of the Arrow array
        } catch (Exception e) {
import org.apache.logging.log4j.Logger;
            () -> RustBridge.write(filePath, arrayAddress, schemaAddress),
     * @param schemaAddress the native memory address of the Arrow schema
        );
     * @param filePath the path to the Parquet file to write
                }, stats::addNativeFinalizeTimeMillis, stats::incNativeFinalizeTotal, stats::incNativeFinalizeFailures);
     * packed mapping, or null if no sorting was configured or the file was empty.
     * @throws IllegalStateException if the writer has not been initialized
/**
     */
            stats::incNativeWriteFailures
    public NativeParquetWriter(String filePath, ParquetShardStatsTracker stats) {
    /**
        }
public class NativeParquetWriter {
    public void write(long arrayAddress, long schemaAddress) throws IOException {
    public ParquetFileMetadata getMetadata() {
     * @param schemaAddress     the native memory address of the Arrow schema
     *
    private final SetOnce<ParquetFileMetadata> metadata = new SetOnce<>();
        if (writerFlushed.compareAndSet(false, true)) {
    }
        return metadata.get();
 * <p>Wraps the stateless JNI methods in {@link RustBridge} with a file-scoped lifecycle:
     */
     */
            stats::addNativeWriteTimeMillis,
 * this file be licensed under the Apache-2.0 license or a
 * </ol>
    public void initialize(String indexName, long schemaAddress, ParquetSortConfig sortConfig, long writerGeneration) throws IOException {
        if (writerFlushed.get()) {
 *
 *
 * The OpenSearch Contributors require contributions made to
                        if (result.rowIdMapping() != null) {
     * @return the file metadata, or null if the writer has not been flushed
                    }
     * @param indexName         the index name for settings lookup
 * <p>This class is not thread-safe. External synchronization is required
        this.filePath = filePath;
 */
        }
            throw new IllegalStateException("Writer not initialized: " + filePath);
import org.opensearch.plugin.stats.StatsRecorder;
    }
    private final SetOnce<RowIdMapping> rowIdMapping = new SetOnce<>();
    }
                            rowIdMapping.set(result.rowIdMapping());
 *   <li>{@code new NativeParquetWriter(filePath)} — creates the handle (no native call)</li>
     * Finalizes the Parquet file and returns metadata. If the writer was never initialized
