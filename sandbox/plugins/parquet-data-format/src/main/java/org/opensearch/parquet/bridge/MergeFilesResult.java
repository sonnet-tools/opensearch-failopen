 * SPDX-License-Identifier: Apache-2.0
 */  
 * @param flushAndSortChunkTimeMs cumulative wall-clock millis spent in flush+sort+chunk passes  
 *
package org.opensearch.parquet.bridge;
 *
 * @param metadata                Parquet file metadata + CRC32 of the merged output
 * The OpenSearch Contributors require contributions made to  
/*  
 * (version, row count, {@code created_by}, CRC32) of the merged output file,  
    long flushAndSortChunkTimeMs, long rowIdMappingMax) {
 * this file be licensed under the Apache-2.0 license or a
 * plus per-merge stats forwarded to the per-shard tracker.
 * @param rowIdMapping            row-ID remapping table for secondary data formats  
public record MergeFilesResult(RowIdMapping rowIdMapping, ParquetFileMetadata metadata, long flushAndSortChunkCount,  
 * @param rowIdMappingMax         highest row_id assigned during this merge (= rows written)
 * remap row IDs in secondary data formats with the Parquet file metadata
 * compatible open source license.
}
import org.opensearch.index.engine.dataformat.RowIdMapping;
 * @param flushAndSortChunkCount  count of flush+sort+chunk passes that ran during this merge
/**  
 */
 * Result of a native Parquet merge. Bundles the row-ID mapping used to
