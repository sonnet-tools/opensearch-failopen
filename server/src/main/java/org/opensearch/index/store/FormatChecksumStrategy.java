    /**  
public interface FormatChecksumStrategy {  
    }  
     *
 */
     */
    default void registerChecksum(String fileName, long checksum, long writerGeneration) {}
     * @param fileName the file name  
     * Creates a {@link VerifyingIndexOutput} that computes and verifies checksums
    default void clearChecksums() {}
     *  
import org.apache.lucene.store.Directory;
import org.opensearch.common.annotation.ExperimentalApi;  
     * and the strategy converts to its internal storage key. Production code should
 *
import org.apache.lucene.store.IndexOutput;
            registerChecksum(fileMetadata.serialize(), checksum, writerGeneration);
/**
     */
 * during the flush/write path, then consumed by the upload path via
/*  
     * using this format's algorithm during the write pass (streaming).  
    long computeChecksum(Directory dir, String fileName) throws IOException;
 */  
     * prefer this overload so key-derivation logic stays inside the strategy.  
     * @param output the underlying index output to wrap  
 *  
 * @opensearch.experimental  
 * stale entry from an older generation is overwritten, never served.
 * </ul>
        }
 * entry is always from the latest write. The generation acts as a version stamp — a  
     * @param dir the directory containing the file
     * Implementations should store the generation alongside the checksum and  
 *       falls back to full-file scan if not available</li>
 *
 * SPDX-License-Identifier: Apache-2.0
 *   <li>Lucene: reads the codec footer (O(1))</li>  
     * reject lookups for stale generations.
     * @throws IOException if checksum computation fails
    /**
     * @param writerGeneration the writer generation that produced this file
     * Computes or retrieves the checksum for the given file.  
 *
        if (fileMetadata != null) {  
 * <p>Each data format provides its own strategy:
 * <ul>
    default VerifyingIndexOutput createVerifyingOutput(StoreFileMetadata metadata, IndexOutput output) {  
     */  
    default void registerChecksum(FileMetadata fileMetadata, long checksum, long writerGeneration) {
    /**
 * {@link #computeChecksum(Directory, String)}.
     *
     * {@link #registerChecksum(String, long, long)} using {@link FileMetadata#serialize(String, String)}.  
import java.io.IOException;
 * if a filename is reused across generations (e.g., after merge or rewrite), the cache
}
 *   <li>Default: full-file CRC32 scan (O(n))</li>  
        return new Store.DataFormatVerifyingIndexOutput(metadata, output);
 * <p>Pre-computed checksums are registered via {@link #registerChecksum(String, long, long)}  
     * <p>Default implementation delegates to the String-based
 * Strategy for computing file checksums, with support for pre-computed values.
    /**  
@ExperimentalApi
     *
 * <p>The {@code writerGeneration} parameter in {@link #registerChecksum} ensures that
     *
    }
 * The OpenSearch Contributors require contributions made to  
 *  
     * @param metadata the expected file metadata (length, checksum)
 *   <li>Parquet: uses pre-computed CRC32 from the Rust writer (O(1)),
package org.opensearch.index.store;
     * <p>Override this to provide format-specific verification (e.g., CRC32C for Parquet).
     * is written by a later generation, the new checksum replaces the old one.
     * @param checksum the pre-computed checksum
     * @return a verifying output that checks integrity on {@code verify()}
     *
     * @return the checksum value
     * The default uses CRC32 via {@link Store.DataFormatVerifyingIndexOutput}.  
    /**
     * Registers a pre-computed checksum for a file at a specific writer generation.
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
     * {@link FileMetadata}-aware overload. The caller supplies a {@link FileMetadata}
     */
     * Clears all cached checksums. Called during cleanup/close.  
     * Called during the write/flush path when the checksum is known.
     */  
     * @param fileName the file name (local name, not format-prefixed)  
     * <p>The generation parameter ensures cache correctness: if the same filename
