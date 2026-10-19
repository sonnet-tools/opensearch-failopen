    /**
    long getNativeBytesUsed();
     * Returns the maximum number of documents this engine can index per shard.
     * @return the store provider, or null if this engine does not expose one
    /**
    /**
    default FormatChecksumStrategy getChecksumStrategy() {
     * access to the shard's {@link org.opensearch.index.store.Store} for opening readers.
     * Returns the {@link IndexStoreProvider} for this engine, giving search backends  
/*  
    /**
/**
 * @param <T> the data format type  
     * that uniquely identifies it within this engine's lifecycle.
     * @return the refresh result containing refreshed segments
     * @return a new document input instance
     */
     * @return map of data format name to collection of file names that failed to delete
     *
     * This allows the upload path to retrieve pre-computed checksums in O(1) instead of  
     */
    long getNextWriterGeneration();
    }
     * Engines that do not manage a store (e.g., Parquet) may return {@code null}.  
    }
import org.opensearch.index.store.FormatChecksumStrategy;
     *
    P newDocumentInput();  
        return config.registry().getReaderManager(config);
     * @param config the writer configuration
     * Creates a new writer for the given writer generation.
     * @return the data format
 * @opensearch.experimental  
     * @throws IOException if an I/O error occurs during refresh  
     */
     *
 * The OpenSearch Contributors require contributions made to  
     * Composite engines multiplex this across delegates and surface the first non-null  
     * Deletes the specified files grouped by directory.
    /**
 * this file be licensed under the Apache-2.0 license or a
    /**
    /**  
     */
    Writer<P> createWriter(WriterConfig config);
     * Returns the checksum strategy used by this engine, if any.
     */  
    /**
     * re-reading the entire file.
    Map<String, Collection<String>> deleteFiles(Map<String, Collection<String>> filesToDelete) throws IOException;
     *  
     * Each writer is associated with a monotonically increasing generation number  
 *
    T getDataFormat();  
     * @return heap memory usage in bytes
    /**  
 * compatible open source license.
     */  
     */
     */
    default Map<DataFormat, EngineReaderManager<?>> buildReaderManager(ReaderManagerConfig config) throws IOException {  
     * <p>Engines that pre-compute checksums during write (e.g., Parquet computing CRC32  
        return null;  
     */
     * Returns the tragic exception recorded by the underlying writer/store, if any.
    }
     */
        return null;  
     * Returns the merger for combining writer file sets.
     * Returns the amount of JVM heap memory used by this engine's indexing buffers.  
    }
    IndexStoreProvider getProvider();
import java.io.IOException;
    /**  
     * @return native memory usage in bytes  
    RefreshResult refresh(RefreshInput refreshInput) throws IOException;
     *
import java.io.Closeable;  
     * Creates a new empty document input for this engine's data format.
import java.util.Map;  
     * @throws IOException if an I/O error occurs during deletion  
     *
import java.util.Collection;
     * Returns the next writer generation number to be used when creating a new writer.
 *
     */  
package org.opensearch.index.engine.dataformat;
import org.opensearch.common.annotation.ExperimentalApi;
     *
    default Exception getTragicException() {
public interface IndexingExecutionEngine<T extends DataFormat, P extends DocumentInput<?>> extends Closeable {  
    /**
 * Engine for executing indexing operations for a specific data format.  
    /**
     * @return the tragic exception, or {@code null} if the engine has not turned tragic  
     */
@ExperimentalApi
        return Long.MAX_VALUE;  
    long getHeapBytesUsed();
 */
 * SPDX-License-Identifier: Apache-2.0
     * Returns the amount of native (off-heap) memory used by this engine.
     *  
     *  
     *  
     * @param refreshInput the input containing segments and writer files to refresh
     * Performs a refresh operation to make recently written data searchable.
     * Returns the data format handled by this engine.
 */  
}
    Merger getMerger();
     */
     * <p>
     *
     * @return the next writer generation number  
import org.opensearch.index.engine.exec.commit.IndexStoreProvider;  
     * @return the merger instance  
     * @return the checksum strategy, or {@code null} if this engine does not pre-compute checksums  
 * @param <P> the document input type
    default long maxIndexableDocs() {
     * @return a new writer instance
     * in the native writer) return their strategy here so it can be wired into the
 *
     * @param filesToDelete map of data format name to collections of file names to delete
     *
     * Used by {@link org.opensearch.index.engine.DocumentCountTracker} to enforce
     *  
    /**  
import org.opensearch.index.engine.exec.EngineReaderManager;
     * the document count limit. Defaults to {@link Long#MAX_VALUE} (unlimited).  
     * result so DFAE can fail the engine without consulting the committer.
 * Provides writer creation, merging, refresh, and file management capabilities.
     * {@link org.opensearch.index.store.DataFormatAwareStoreDirectory} at shard init time.
