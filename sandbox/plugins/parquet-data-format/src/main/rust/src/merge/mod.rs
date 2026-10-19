pub use sorted::merge_sorted_with_pool;
    pub mapping: Vec<i64>,
    /// Starting offset in `mapping` for each generation
    pub gen_sizes: Vec<i32>,
pub use error::{MergeError, MergeResult};
pub mod schema;
    /// Parquet file metadata for the merged output file
    /// Per-merge: number of flush+sort+chunk passes that ran inside this merge.
    pub flush_and_sort_chunk_time_millis: i64,
    pub gen_offsets: Vec<i32>,
    /// Flat mapping array: mapping[offset + old_row_id] = new_row_id
pub use unsorted::merge_unsorted;
    pub gen_keys: Vec<i64>,
    /// Whole-file CRC32 of the merged output file
pub use unsorted::merge_unsorted_with_pool;
    /// Number of rows per generation
    pub crc32: u32,
mod cursor;
 * SPDX-License-Identifier: Apache-2.0
    /// Per-merge: cumulative wall-clock millis spent in flush+sort+chunk passes.
    /// Generation keys (parallel with gen_offsets and gen_sizes)
pub use sorted::merge_sorted;
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
/// of the merged output file.
/// Output of a merge operation. Carries both the row-ID mapping (for remapping
 */
    /// Per-merge: highest row_id assigned (= total rows written by this merge).
pub mod live_docs;
mod context;
pub mod io_task;
mod unsorted;
/// secondary-format row IDs post-merge) and the Parquet file metadata + CRC32
pub mod heap;
pub mod error;
    pub metadata: parquet::file::metadata::ParquetMetaData,
    pub row_id_mapping_max: i64,
    pub flush_and_sort_chunk_count: i64,
/*
}
pub mod metrics;
pub struct MergeOutput {
 * this file be licensed under the Apache-2.0 license or a
 *
mod sorted;
