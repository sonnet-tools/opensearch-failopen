 */  
 *
 * SPDX-License-Identifier: Apache-2.0
 * @param numRows      total number of rows written to the file  
 *  
 * this file be licensed under the Apache-2.0 license or a
 */
 *
 * <p>Returned by {@link RustBridge#finalizeWriter(String)} and {@link RustBridge#getFileMetadata(String)}.
 * @param createdBy    creator string from the Parquet file footer metadata
/**
 * Contains the Parquet format version, total row count, the creator identifier string
/*  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.parquet.bridge;
public record ParquetFileMetadata(int version, long numRows, String createdBy, long crc32, int numRowGroups) {
 * @param version      Parquet format version number
 * @param crc32        whole-file CRC32 checksum (computed by the Rust writer during write)
 * embedded in the file footer, and the whole-file CRC32 checksum computed during write.  
}  
 * Metadata extracted from a Parquet file after the native writer is closed.
 * @param numRowGroups number of row groups in the file  
