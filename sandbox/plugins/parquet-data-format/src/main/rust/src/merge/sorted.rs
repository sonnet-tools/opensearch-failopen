        if heap.is_empty() {
        .map(|s| ColumnMapping::new(s, ctx.data_schema()))
pub fn merge_sorted_with_pool(
    let mut file_row_counts: Vec<usize> = Vec::with_capacity(input_files.len());
            sort_values: sv,
        sort_columns,
        }
                        sort_values: val,
    input_files: &[String],
        }
        gen_keys.push(file_generations[file_id]);
    if rel >= file_rows || file_offset + rel >= mapping.len() {
    }
        // TIER 2 & 3: Multiple cursors active
use super::context::MergeContext;
    let io_threads = config.get_merge_io_threads();
        index_name,
                    let slice = cursor.take_slice(start_idx, remaining, reservation)?;
use super::schema::ColumnMapping;
                                file_offset,
    for file_id in 0..num_cursors {
                for i in 0..run_len {
    let deferred_threshold = config.get_merge_deferred_column_threshold();
        num_cursors
            cursor.row_idx = run_end;
    // Reserve for row-ID mapping Vec<i64> — total_rows × 8 bytes, allocated next line
use super::cursor::FileCursor;
    );
    reservation: &mut MemoryReservation,
/*
                let start_idx = cursor.row_idx;
                    if cursor.is_row_id_alive(abs) {
        gen_offsets.push(offset);
/// `live_docs_per_input` is parallel to `input_files`; a `None` (or absent) entry
        "descending"
        pool.current_num_threads(),
                            abs,
        mapping,
            break;
        return Err(super::MergeError::Logic(format!(
        output_writer_generation,
    index_name: &str,
}
        nulls_first,
                    }
            live_bits,
            }
        let size = file_row_counts[file_id] as i32;
        )?;
        "[RUST] Merge complete ({}): {} total rows written to '{}' in {} row groups, crc32={:#010x}",
        direction_label,
        reverse_sorts,
        file_row_counts.push(row_count);
    merge_sorted_with_pool(
        cursors.push(cursor);
    }
    )?;
use crate::log_debug;
    mapping: &mut [i64],
    Ok(super::MergeOutput {
    let mut gen_sizes: Vec<i32> = Vec::with_capacity(num_cursors);
 * compatible open source license.
            // TIER 3: Binary search for the exact boundary
                            abs,
        rayon_threads,
    };
use super::io_task::get_merge_pool;
    let mut offset = 0i32;
            file_id,
    let batch_size = config.get_merge_batch_size();
                    let abs = base_row_id + (run_start + i) as u64;
    // ── Phase 1: Initialize cursors and collect schemas ─────────────────
            while lo + 1 < hi {
            let batch_h = cursor.batch_height();
                }
) -> super::MergeResult<super::MergeOutput> {
 * this file be licensed under the Apache-2.0 license or a
            .and_then(|opt| opt.as_ref())
                        record_survivor(
            // so we always yield here (no need for conditional check)
use std::cmp::Ordering;
            .get(file_id)
                sort_values: val,
                            new_row_id,
        output_writer_generation,
                }
            let batch = cursor.sort_batch.as_ref().unwrap();
    let ctx_reservation = reservation.child("merge:flush");
                            new_row_id += 1;
                    &cursor.sort_col_indices,
            }
            // Binary search invariant guarantees cursor.current_value > heap_top
    // ── Phase 2: Create MergeContext (union schemas, writer, IO task) ───
                } else {
                    break;
                    }
    sort_columns: &[String],
            "merge_sorted called with empty sort_columns; use merge_unsorted instead".into(),
            let run_start = cursor.row_idx;
    nulls_first: &[bool],
        log_debug!("[RUST] Opening cursor {} for file: {}", file_id, path);
                        }
    )
    file_rows: usize,
    file_offset: usize,
    }
        direction_label,
    output_writer_generation: i64,
            }
    let mut gen_offsets: Vec<i32> = Vec::with_capacity(num_cursors);
            let heap_top = &heap.peek().unwrap().sort_values;
    // sentinel since they are never emitted.
fn record_survivor(
    // Detach mapping from reservation — FFI layer will track via merge_pool().grow
         batch_size={}, flush_rows={}, merge_threads={}, output='{}'",
                if !cursor.advance_past_batch(reservation)? {
        direction_label,
}
                for i in 0..remaining {
                        let abs = base_row_id + (start_idx + i) as u64;
    let mut heap: BinaryHeap<HeapItem> = BinaryHeap::with_capacity(num_cursors);
        offset += size;
    } else if reverse_sorts.iter().all(|&r| r) {
use super::heap::{cmp_sort_values, get_sort_values, HeapItem};
                            file_offset,
        .iter()
                    ctx.push_batch(col_mapping.pad_batch(&slice)?)?;
            abs,
 *
        live_docs_per_input,
        ));
    // is indexed by absolute source row id; dead (deleted) rows keep the -1
use crate::memory::merge_pool;
        stats.metadata.num_row_groups(),
        stats.crc32
                if remaining > 0 {
        batch_size,
            file_rows,
    let mut mapping: Vec<i64> = vec![-1i64; total_rows];
    live_docs_per_input: &[Option<Vec<u64>>],
/// Performs a streaming k-way merge using the provided memory reservation.
                    batch,
            if cmp_sort_values(&last_val, heap_top, reverse_sorts) != Ordering::Greater {
        index_name,
            let mut hi = batch_h - 1;
    max_sort_modes: &[bool],
                            file_rows,
    let total_rows: usize = file_row_counts.iter().sum();
            let base_row_id = cursor.base_row_id;
    let col_mappings: Vec<ColumnMapping> = arrow_schemas
        MemoryReservation::new(merge_pool(), "merge_sorted", PoolBehavior::Reject);
                            &mut mapping,
use native_bridge_common::memory_pool::{MemoryReservation, PoolBehavior};
            if run_len > 0 {
                    break;
    max_sort_modes: &[bool],
                }
    // ── Phase 3: Seed the heap ──────────────────────────────────────────
    let mut file_generations: Vec<i64> = Vec::with_capacity(input_files.len());
    let stats = ctx.finish()?;
    })
                            file_id,
    input_files: &[String],
        });
    // ── Phase 5: Close ──────────────────────────────────────────────────
    // Precompute column mappings per cursor (avoids per-batch name lookups)
        input_files.len(),
        crc32: stats.crc32,
        "[RUST] Starting streaming merge ({}): {} input files, sort_columns={:?}, \
    if sort_columns.is_empty() {
            path,
) -> super::MergeResult<super::MergeOutput> {
#[inline]
            .map(|bits| Arc::new(bits.clone()));
                                new_row_id,
            loop {
                if slice.num_rows() > 0 {
    let mut reservation =
        let (cursor, projected_schema, _parquet_descr, generation, row_count) = FileCursor::new(
        "mixed"
/// the file's footer-declared span would silently corrupt the next file's slots, so it is
                    lo = mid;
                    ctx.push_batch(col_mapping.pad_batch(&slice)?)?;
        output_path
/// Performs a streaming k-way merge with an explicit sort direction per column.
            let val = cursor.current_sort_values()?;
        metadata: stats.metadata,
                }
            let run_end = lo;
/// disables filtering for that file (zero-copy fast path).
                            new_row_id,
    Ok(())
/// `live_docs_per_input` is parallel to `input_files`; a `None` (or absent) entry
    let num_cursors = cursors.len();
        .collect();
    for (file_id, path) in input_files.iter().enumerate() {
        heap.push(HeapItem {
    let direction_label = if reverse_sorts.iter().all(|&r| !r) {
    log_debug!(
                        )?;
                if cmp_sort_values(&val, heap_top, reverse_sorts) == Ordering::Greater {
    // ── Phase 4: K-way merge loop — three-tier cascade ──────────────────
                    hi = mid;
    index_name: &str,
                    // Build mapping for surviving rows (indexed by absolute source row id).
                let mid_val = get_sort_values(
        let file_rows = file_row_counts[file_id];
        let live_bits = live_docs_per_input
    );
                        new_row_id += 1;
        &mut reservation,
    reservation.shrink(mapping_bytes);
        gen_sizes,
    reverse_sorts: &[bool],
            let last_val = cursor.last_sort_values()?;
                reverse_sorts: Arc::clone(&reverse_sorts_arc),
        "ascending"
                if slice.num_rows() > 0 {
        if cursor.sort_batch.is_none() {
        .map_err(|e| super::MergeError::Logic(format!("Merge pool exceeded (mapping): {}", e)))?;
/// rejected with a descriptive error (diagnosable across the FFM boundary, unlike a panic).
                    });
                let mid = lo + (hi - lo) / 2;
    nulls_first: &[bool],
                let start_idx = cursor.row_idx;
    output_path: &str,
        return Err(super::MergeError::Logic(
                                file_rows,
                        new_row_id += 1;
        gen_offsets,
 * The OpenSearch Contributors require contributions made to
    live_docs_per_input: &[Option<Vec<u64>>],
    let mut new_row_id: i64 = 0;
                let remaining = cursor.batch_height() - start_idx;
    }
    let output_flush_rows = config.get_row_group_max_rows();
    output_path: &str,
            let file_offset = gen_offsets[file_id] as usize;
        .unwrap_or_default();
        let file_offset = gen_offsets[file_id] as usize;
                    if cursor.is_row_id_alive(abs) {
                }
                    for i in 0..remaining {
            heap.push(HeapItem {
                    break;
        gen_keys,
                    let abs = base_row_id + (start_idx + i) as u64;
    }
            max_sort_modes,
use arrow::datatypes::Schema as ArrowSchema;
                            &mut mapping,
            let cursor = &mut cursors[file_id];
    log_debug!(
use std::collections::BinaryHeap;
    let rayon_threads = config.get_merge_rayon_threads();
            let mut lo = run_start;
                            file_offset,
    let reverse_sorts_arc = Arc::new(reverse_sorts.to_vec());
        output_path,
    sort_columns: &[String],
    } else {
            break;
use std::sync::Arc;
            reservation,
    let mut arrow_schemas: Vec<ArrowSchema> = Vec::with_capacity(input_files.len());
        let col_mapping = &col_mappings[file_id];
                )?;
            continue;
                            file_rows,
) -> super::MergeResult<()> {
    let mut ctx = MergeContext::new(
    log_debug!(
        flush_and_sort_chunk_count: stats.flush_and_sort_chunk_count,
        }
        sort_columns,
    // from file metadata row counts (known before reading any data). The mapping
            let col_mapping = &col_mappings[file_id];
        arrow_schemas.push(projected_schema.as_ref().clone());
        .get(index_name)
    let pool = get_merge_pool(rayon_threads);
    reservation
        ));
    reverse_sorts: &[bool],
 * SPDX-License-Identifier: Apache-2.0
    // Row-ID mapping: pre-allocate the flat mapping array and compute offsets
            batch_size,
        input_files,
            nulls_first,
                        reverse_sorts: Arc::clone(&reverse_sorts_arc),
    }
        arrow_schemas.clone(),
            });
            }
        let cursor = &mut cursors[file_id];
                if cmp_sort_values(&mid_val, heap_top, reverse_sorts) != Ordering::Greater {
    let mut gen_keys: Vec<i64> = Vec::with_capacity(num_cursors);
    if input_files.is_empty() {
                    &cursor.sort_col_types,
                continue;
        .request(mapping_bytes)
    let config = crate::writer::SETTINGS_STORE
                let base_row_id = cursor.base_row_id;
            if !cursor.advance(reservation)? {
                            file_id,
        loop {
            let run_len = run_end - run_start + 1;
                // Check if cursor should yield after loading new batch
            mapping.len()
                    &cursor.max_sort_modes,
pub fn merge_sorted(
                }
/// disables filtering for that file (zero-copy fast path).
    let mapping_bytes = total_rows * std::mem::size_of::<i64>();
        )));
                }
    let rel = abs as usize;
                                abs,
        return Err(super::MergeError::Logic(
            let file_rows = file_row_counts[file_id];
        output_flush_rows,
            file_id,
                if !cursor.advance_past_batch(reservation)? {
                            )?;
                        ctx.push_batch(col_mapping.pad_batch(&slice)?)?;
        let sv = cursor.current_sort_values()?;
        // Cursors with all-dead data are already exhausted — skip.
    output_writer_generation: i64,
        let file_id = item.file_id;
                }
                    mid,
/// Checked write of a surviving row's new id into the flat mapping. A row id at or beyond
                }
        "[RUST] Merge initialized ({}): {} cursors",
        gen_sizes.push(size);
        output_path,
                let remaining = cursor.batch_height() - start_idx;
    while let Some(item) = heap.pop() {
        flush_and_sort_chunk_time_millis: stats.flush_and_sort_chunk_time_millis,
            // TIER 2: Entire remaining batch fits before heap top
 */
                    if slice.num_rows() > 0 {
        ctx_reservation,
        max_sort_modes,
                file_id,
            deferred_threshold,
                        if cursor.is_row_id_alive(abs) {
        output_path,
                        )?;
            file_id: cursor.file_id,
                    }
            reverse_sorts: Arc::clone(&reverse_sorts_arc),
                let base_row_id = cursor.base_row_id;
    for cursor in &cursors {
    mapping[file_offset + rel] = new_row_id;
                    }
            "merge_sorted called with empty input_files".into(),
                let val = cursor.current_sort_values()?;
    file_id: usize,
                    heap.push(HeapItem {
        row_id_mapping_max: stats.row_id_mapping_max,
                        record_survivor(
                                file_id,
    new_row_id: i64,
                let slice = cursor.take_slice(run_start, run_len, reservation)?;
        // TIER 1: Single cursor remaining — drain it
                        file_id,
                            record_survivor(
    let mut cursors: Vec<FileCursor> = Vec::with_capacity(input_files.len());
        io_threads,
    abs: u64,
                                &mut mapping,
    );
        .map(|r| r.clone())
                let slice = cursor.take_slice(start_idx, remaining, reservation)?;
}
                    &cursor.nulls_first,
        file_generations.push(generation);
        output_flush_rows,
            }
                break;
            sort_columns,
        stats.metadata.file_metadata().num_rows(),
    }
            "row-id mapping overflow: file {} produced absolute row id {} but its footer declares only {} rows (mapping len {})",
