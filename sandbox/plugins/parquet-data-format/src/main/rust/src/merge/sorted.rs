                }
    output_writer_generation: i64,
        direction_label,
    }
) -> super::MergeResult<()> {
                let start_idx = cursor.row_idx;
            if cmp_sort_values(&last_val, heap_top, reverse_sorts) != Ordering::Greater {
use super::io_task::get_merge_pool;
use crate::memory::merge_pool;
            .map(|bits| Arc::new(bits.clone()));
    live_docs_per_input: &[Option<Vec<u64>>],
        nulls_first,
                let remaining = cursor.batch_height() - start_idx;
            let mut hi = batch_h - 1;
        return Err(super::MergeError::Logic(format!(
                }
    let pool = get_merge_pool(rayon_threads);
/// Performs a streaming k-way merge with an explicit sort direction per column.
            // TIER 2: Entire remaining batch fits before heap top
 * The OpenSearch Contributors require contributions made to
    Ok(())
            sort_columns,
    file_offset: usize,
                        let abs = base_row_id + (start_idx + i) as u64;
/*
                        )?;
pub fn merge_sorted_with_pool(
            "row-id mapping overflow: file {} produced absolute row id {} but its footer declares only {} rows (mapping len {})",
                    }
            break;
        output_path,
        .unwrap_or_default();
            deferred_threshold,
                            file_rows,
                if !cursor.advance_past_batch(reservation)? {
                        )?;
    let mapping_bytes = total_rows * std::mem::size_of::<i64>();
                sort_values: val,
    let direction_label = if reverse_sorts.iter().all(|&r| !r) {
        output_path
            "merge_sorted called with empty input_files".into(),
        let sv = cursor.current_sort_values()?;
        loop {
        direction_label,
    mapping[file_offset + rel] = new_row_id;
            let base_row_id = cursor.base_row_id;
                if slice.num_rows() > 0 {
                                file_offset,
                            file_id,
                            new_row_id,
        direction_label,
        stats.metadata.file_metadata().num_rows(),
    for file_id in 0..num_cursors {
    if input_files.is_empty() {
                                file_rows,
        offset += size;
            let val = cursor.current_sort_values()?;
            sort_values: sv,
            heap.push(HeapItem {
    // Reserve for row-ID mapping Vec<i64> — total_rows × 8 bytes, allocated next line
    file_id: usize,
    let total_rows: usize = file_row_counts.iter().sum();
    let mut reservation =
        ));
            file_rows,
        .get(index_name)
            file_id: cursor.file_id,
        rayon_threads,
    index_name: &str,
) -> super::MergeResult<super::MergeOutput> {
}
    file_rows: usize,
    reverse_sorts: &[bool],
        &mut reservation,
            let run_len = run_end - run_start + 1;
        metadata: stats.metadata,
        gen_offsets.push(offset);
    abs: u64,
                            &mut mapping,
        num_cursors
#[inline]
        }
/// disables filtering for that file (zero-copy fast path).
            file_id,
/// Performs a streaming k-way merge using the provided memory reservation.
            mapping.len()
                    ctx.push_batch(col_mapping.pad_batch(&slice)?)?;
                for i in 0..remaining {
        sort_columns,
                let start_idx = cursor.row_idx;
    output_writer_generation: i64,
        file_generations.push(generation);
                if slice.num_rows() > 0 {
    let mut heap: BinaryHeap<HeapItem> = BinaryHeap::with_capacity(num_cursors);
        crc32: stats.crc32,
                                abs,
    })
                    break;
}
            break;
        MemoryReservation::new(merge_pool(), "merge_sorted", PoolBehavior::Reject);
    };
                    batch,
    // from file metadata row counts (known before reading any data). The mapping
pub fn merge_sorted(
            batch_size,
    max_sort_modes: &[bool],
                    let abs = base_row_id + (start_idx + i) as u64;
    while let Some(item) = heap.pop() {
        arrow_schemas.clone(),
                        sort_values: val,
            while lo + 1 < hi {
            nulls_first,
                )?;
use std::sync::Arc;
                let mid = lo + (hi - lo) / 2;
    } else {
) -> super::MergeResult<super::MergeOutput> {
            abs,
                let slice = cursor.take_slice(start_idx, remaining, reservation)?;
                }
    merge_sorted_with_pool(
    let mut offset = 0i32;
        "[RUST] Merge initialized ({}): {} cursors",
        if heap.is_empty() {
                            file_rows,
                        if cursor.is_row_id_alive(abs) {
            "merge_sorted called with empty sort_columns; use merge_unsorted instead".into(),
        .request(mapping_bytes)
                let mid_val = get_sort_values(
                    if cursor.is_row_id_alive(abs) {
        ));
    let mut file_row_counts: Vec<usize> = Vec::with_capacity(input_files.len());
        "[RUST] Merge complete ({}): {} total rows written to '{}' in {} row groups, crc32={:#010x}",
        .collect();
            let file_rows = file_row_counts[file_id];
                if cmp_sort_values(&mid_val, heap_top, reverse_sorts) != Ordering::Greater {
/// the file's footer-declared span would silently corrupt the next file's slots, so it is
        return Err(super::MergeError::Logic(
                    &cursor.nulls_first,
                let base_row_id = cursor.base_row_id;
        file_row_counts.push(row_count);
        gen_sizes.push(size);
    }
            }
        index_name,
    );
    let ctx_reservation = reservation.child("merge:flush");
        gen_offsets,
 * compatible open source license.
        heap.push(HeapItem {
    let rayon_threads = config.get_merge_rayon_threads();
                                &mut mapping,
    let output_flush_rows = config.get_row_group_max_rows();
        let file_offset = gen_offsets[file_id] as usize;
        let cursor = &mut cursors[file_id];
        flush_and_sort_chunk_time_millis: stats.flush_and_sort_chunk_time_millis,
fn record_survivor(
use super::cursor::FileCursor;
                    break;
                        }
         batch_size={}, flush_rows={}, merge_threads={}, output='{}'",
/// `live_docs_per_input` is parallel to `input_files`; a `None` (or absent) entry
    let mut new_row_id: i64 = 0;
                    // Build mapping for surviving rows (indexed by absolute source row id).
    let mut arrow_schemas: Vec<ArrowSchema> = Vec::with_capacity(input_files.len());
    reverse_sorts: &[bool],
                } else {
    if sort_columns.is_empty() {
        let col_mapping = &col_mappings[file_id];
use super::schema::ColumnMapping;
                for i in 0..run_len {
                if cmp_sort_values(&val, heap_top, reverse_sorts) == Ordering::Greater {
        .iter()
        .map(|r| r.clone())
    let mut gen_offsets: Vec<i32> = Vec::with_capacity(num_cursors);
        gen_keys,
                let slice = cursor.take_slice(run_start, run_len, reservation)?;
                let val = cursor.current_sort_values()?;
    }
                        record_survivor(
            let batch = cursor.sort_batch.as_ref().unwrap();
        index_name,
        log_debug!("[RUST] Opening cursor {} for file: {}", file_id, path);
        "mixed"
                }
            .and_then(|opt| opt.as_ref())
use super::heap::{cmp_sort_values, get_sort_values, HeapItem};
            // Binary search invariant guarantees cursor.current_value > heap_top
        return Err(super::MergeError::Logic(
    nulls_first: &[bool],
            }
            // TIER 3: Binary search for the exact boundary
        row_id_mapping_max: stats.row_id_mapping_max,
        });
    let rel = abs as usize;
        let file_rows = file_row_counts[file_id];
            let file_offset = gen_offsets[file_id] as usize;
            file_id,
    let stats = ctx.finish()?;
                    for i in 0..remaining {
/// `live_docs_per_input` is parallel to `input_files`; a `None` (or absent) entry
    reservation
        let (cursor, projected_schema, _parquet_descr, generation, row_count) = FileCursor::new(
use std::collections::BinaryHeap;
        )));
            let cursor = &mut cursors[file_id];
 *
        .map(|s| ColumnMapping::new(s, ctx.data_schema()))
    let io_threads = config.get_merge_io_threads();
                    &cursor.sort_col_types,
            // so we always yield here (no need for conditional check)
                }
            }
                    }
    let mut gen_sizes: Vec<i32> = Vec::with_capacity(num_cursors);
                }
            continue;
    output_path: &str,
                    if cursor.is_row_id_alive(abs) {
                }
        pool.current_num_threads(),
        max_sort_modes,
    // Detach mapping from reservation — FFI layer will track via merge_pool().grow
        if cursor.sort_batch.is_none() {
    );
    // Row-ID mapping: pre-allocate the flat mapping array and compute offsets
        input_files.len(),
    let col_mappings: Vec<ColumnMapping> = arrow_schemas
                    break;
        stats.crc32
                if remaining > 0 {
            let batch_h = cursor.batch_height();
    reservation: &mut MemoryReservation,
        flush_and_sort_chunk_count: stats.flush_and_sort_chunk_count,
    let mut file_generations: Vec<i64> = Vec::with_capacity(input_files.len());
            loop {
        input_files,
 */
    new_row_id: i64,
        ctx_reservation,
                    mid,
 * this file be licensed under the Apache-2.0 license or a
        io_threads,
            reservation,
        cursors.push(cursor);
    )
                    let slice = cursor.take_slice(start_idx, remaining, reservation)?;
        // TIER 2 & 3: Multiple cursors active
            path,
        gen_keys.push(file_generations[file_id]);
        sort_columns,
            reverse_sorts: Arc::clone(&reverse_sorts_arc),
    for cursor in &cursors {
    );
    if rel >= file_rows || file_offset + rel >= mapping.len() {
                        reverse_sorts: Arc::clone(&reverse_sorts_arc),
use crate::log_debug;
    let mut cursors: Vec<FileCursor> = Vec::with_capacity(input_files.len());
    // Precompute column mappings per cursor (avoids per-batch name lookups)
        reverse_sorts,
 * SPDX-License-Identifier: Apache-2.0
                            )?;
            if run_len > 0 {
            let col_mapping = &col_mappings[file_id];
                continue;
                        record_survivor(
        output_flush_rows,
                    ctx.push_batch(col_mapping.pad_batch(&slice)?)?;
                            file_id,
            if !cursor.advance(reservation)? {
    }
                    }
                // Check if cursor should yield after loading new batch
                }
                            abs,
    let batch_size = config.get_merge_batch_size();
                if !cursor.advance_past_batch(reservation)? {
        output_path,
    mapping: &mut [i64],
            let heap_top = &heap.peek().unwrap().sort_values;
        stats.metadata.num_row_groups(),
    } else if reverse_sorts.iter().all(|&r| r) {
    log_debug!(
                            file_offset,
                    lo = mid;
    for (file_id, path) in input_files.iter().enumerate() {
                    if slice.num_rows() > 0 {
                        new_row_id += 1;
            let mut lo = run_start;
            live_bits,
use std::cmp::Ordering;
        // TIER 1: Single cursor remaining — drain it
        batch_size,
        output_writer_generation,
                    });
                        new_row_id += 1;
            }
    live_docs_per_input: &[Option<Vec<u64>>],
    // is indexed by absolute source row id; dead (deleted) rows keep the -1
                        file_id,
    let mut mapping: Vec<i64> = vec![-1i64; total_rows];
    let reverse_sorts_arc = Arc::new(reverse_sorts.to_vec());
    output_path: &str,
    index_name: &str,
    input_files: &[String],
        output_path,
/// Checked write of a surviving row's new id into the flat mapping. A row id at or beyond
    sort_columns: &[String],
        // Cursors with all-dead data are already exhausted — skip.
    log_debug!(
        mapping,
            max_sort_modes,
    sort_columns: &[String],
        live_docs_per_input,
        output_flush_rows,
                                new_row_id,
/// rejected with a descriptive error (diagnosable across the FFM boundary, unlike a panic).
    }
    let config = crate::writer::SETTINGS_STORE
            let run_end = lo;
                    &cursor.max_sort_modes,
                            abs,
    // ── Phase 2: Create MergeContext (union schemas, writer, IO task) ───
                }
            let run_start = cursor.row_idx;
    let deferred_threshold = config.get_merge_deferred_column_threshold();
                                file_id,
use native_bridge_common::memory_pool::{MemoryReservation, PoolBehavior};
    let mut gen_keys: Vec<i64> = Vec::with_capacity(num_cursors);
    nulls_first: &[bool],
        let live_bits = live_docs_per_input
        }
    input_files: &[String],
    let mut ctx = MergeContext::new(
    // sentinel since they are never emitted.
    // ── Phase 4: K-way merge loop — three-tier cascade ──────────────────
/// disables filtering for that file (zero-copy fast path).
                            record_survivor(
        "[RUST] Starting streaming merge ({}): {} input files, sort_columns={:?}, \
}
                    heap.push(HeapItem {
                        ctx.push_batch(col_mapping.pad_batch(&slice)?)?;
                file_id,
                reverse_sorts: Arc::clone(&reverse_sorts_arc),
    }
        )?;
    log_debug!(
                let base_row_id = cursor.base_row_id;
    let num_cursors = cursors.len();
            cursor.row_idx = run_end;
            .get(file_id)
                            &mut mapping,
                let remaining = cursor.batch_height() - start_idx;
        }
    // ── Phase 5: Close ──────────────────────────────────────────────────
        arrow_schemas.push(projected_schema.as_ref().clone());
            let last_val = cursor.last_sort_values()?;
                    }
                            new_row_id,
                    &cursor.sort_col_indices,
    max_sort_modes: &[bool],
use super::context::MergeContext;
                break;
    reservation.shrink(mapping_bytes);
    // ── Phase 3: Seed the heap ──────────────────────────────────────────
                            file_offset,
    )?;
                    let abs = base_row_id + (run_start + i) as u64;
            }
use arrow::datatypes::Schema as ArrowSchema;
        gen_sizes,
        let file_id = item.file_id;
    // ── Phase 1: Initialize cursors and collect schemas ─────────────────
        .map_err(|e| super::MergeError::Logic(format!("Merge pool exceeded (mapping): {}", e)))?;
    }
            });
        let size = file_row_counts[file_id] as i32;
                            new_row_id += 1;
    Ok(super::MergeOutput {
        "descending"
                    hi = mid;
        output_writer_generation,
        "ascending"
