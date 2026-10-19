                    array_value_to_json(col.as_ref(), row_idx),
        type_compression_value_lens,
    }
    schema_address: i64,
// Merge
    let type_encodings = str_array_from_raw(
    let s = crate::merge::metrics::collect();
        return Err("null string pointer".to_string());
        *version_out = fm.version();
            mapping_len as usize,
    out_buf: *mut u8,
    }
) -> i64 {
        // Java released write mapping — free from pool
        }
    let field_compressions = str_array_from_raw(
                    let mapping_bytes = len * std::mem::size_of::<i64>();
    *out_gen_count = count as i64;
        field_compression_value_ptrs,
pub unsafe extern "C" fn parquet_merge_files(
        return vec![];
    nulls_first_vals: *const i64,
) -> i64 {
    ptrs: *const *const u8,
        s.tokio_num_blocking_threads,
            let bytes = cb.as_bytes();
            "null pointer with positive length should yield None"
        .to_string();
    }
    file_len: i64,
        }
    file_ptr: *const u8,
            &live_docs,
    index_name_len: i64,
        s.rayon_merge_tasks_completed,
    sort_count: i64,
            None
}
    num_rows_out: *mut i64,
    field_compression_value_ptrs: *const *const u8,
/// Layout: [write_limit, write_used, write_peak, merge_limit, merge_used, merge_peak]
        s.rayon_configured_threads,
    out_gen_count: *mut i64,
        .map_err(|e| e.to_string())
        assert_eq!(result.len(), 3);
        let l = *lens.add(i);
    }
    }
    match NativeParquetWriter::finalize_writer(filename) {
    type_bf_fpp_name_lens: *const i64,
    let bytes = json.as_bytes();
// ---------------------------------------------------------------------------
    nulls_first_count: i64,
    NativeParquetWriter::get_filtered_writer_memory_usage(prefix).unwrap_or(0) as i64
    bf_enabled_vals: *const i64,
            .collect();
        return Ok(vec![]);
        type_compression_name_ptrs,
        bloom_filter_fpp: opt_f64(bloom_filter_fpp),
        .map_err(|e| format!("parquet_create_writer sort_columns: {}", e))?;
    let output_path = str_from_raw(output_ptr, output_len)
    let nulls_first = bool_array_from_raw(nulls_first_vals, nulls_first_count);
            .map(|(i, name)| (name, *type_bf_fpp_vals.add(i)))
    type_bf_enabled_name_ptrs: *const *const u8,
    .map_err(|e| format!("parquet_on_settings_update type_encoding_names: {}", e))?;
        for (name, compression) in field_compression_names
                    bloom_filter_enabled: Some(val),
        if v < 0 {
    }
// Writer lifecycle
pub unsafe extern "C" fn parquet_finalize_writer(
    count: i64,
        row_group_max_bytes: opt_usize(row_group_max_bytes),
/// Update native settings for an index. Nullable fields use sentinel -1 for "not set".
    Ok(0)
///
            .collect();
    if !out_len.is_null() {
        for (name, encoding) in field_names.into_iter().zip(field_encodings.into_iter()) {
        .unwrap_or("")
    bf_enabled_name_lens: *const i64,
        let slice = slice::from_raw_parts(p as *const u64, l as usize);
    let stats = crate::memory::get_stats();
    let metadata = NativeParquetWriter::get_file_metadata(filename).map_err(|e| e.to_string())?;
        }
        crate::memory::write_pool().shrink(mapping_bytes);
            }
// ---------------------------------------------------------------------------
#[ffm_safe]
#[cfg(test)]
    let reader =
    if !crc32_out.is_null() {
        assert!(result.is_empty());
            if !sc.is_empty() && rf.is_empty() {
    writer_generation: i64,
        } else {
// ---------------------------------------------------------------------------
        type_bf_enabled_count,
            Some(map)
/// modules share one cdylib (and thus one `native-bridge-common` instance), this single
    sort_in_memory_threshold_bytes: i64,
            let rf = s.reverse_sorts.clone();
        if map.is_empty() {
    fn live_bits_array_from_raw_multi_word_bitmap() {
        let lens: Vec<i64> = vec![bits.len() as i64];
        let invalid_ptrs: *const *const i64 = &invalid_ptr;
    crate::memory::merge_pool().grow(mapping_bytes);
    let offsets = result.gen_offsets.into_boxed_slice();
        let lens: Vec<i64> = vec![0];
        return Err("parquet_collect_runtime_metrics: null out_buf".to_string());
// ---------------------------------------------------------------------------
    type_bf_fpp_count: i64,
    #[test]
            mapping_ptr as *mut i64,
        crate::memory::merge_pool().shrink(mapping_bytes);
    field_encoding_ptrs: *const *const u8,
}
        assert_eq!(decoded.len(), 1);
#[ffm_safe]
        s.rayon_merge_tasks_panicked,
    let filename = str_from_raw(file_ptr, file_len)
                    let bytes = cb.as_bytes();
        let lens: Vec<i64> = vec![bits.len() as i64];
        s.tokio_blocking_queue_depth,
            (sc, rf, nf, mm)
    let filename = str_from_raw(file_ptr, file_len)
                    // Track mapping handoff to Java — Java holds until parquet_free_row_id_mapping
    array_address: i64,
    fn opt_u64(v: i64) -> Option<u64> {
    let prefix = str_from_raw(prefix_ptr, prefix_len)
        assert!(result[0].is_none());
}
    let compression_type = if compression_type_ptr.is_null() || compression_type_len < 0 {
    }
// ---------------------------------------------------------------------------
    let field_configs = {
    num_rows_out: *mut i64,
    let filename = str_from_raw(file_ptr, file_len)
pub unsafe extern "C" fn parquet_cleanup_writer(file_ptr: *const u8, file_len: i64) -> i64 {
    file_len: i64,
        }
        type_bloom_filter_enabled,
            (vec![], vec![], vec![], vec![])
                *version_out = fm.version();
    SETTINGS_STORE.insert(index_name, config);
    // Write Parquet file metadata to out-pointers.
    }
    if !num_rows_out.is_null() {
}
            None
#[no_mangle]
    let file = File::open(&filename).map_err(|e| format!("Failed to open file: {}", e))?;
    std::ptr::copy_nonoverlapping(bytes.as_ptr(), out_buf, n);
    if bytes.len() > buf_capacity as usize {
}
#[no_mangle]
        assert!(
// Sort permutation memory management
        .to_string();
    // Parse per-field bloom filter arrays
        return Ok(0);
        let lens: Vec<i64> = vec![bits_a.len() as i64, 0, bits_c.len() as i64];
            "\"{}\":{{\"encodings\":[{}],\"compression\":\"{}\",\"bloom_filter\":{}}}",
    input_count: i64,
    if len < 0 {
    let index_name = str_from_raw(index_name_ptr, index_name_len)
        );
/// Returns 0 with metadata in out-pointers, 1 if no writer found.
    use super::*;
            std::ptr::copy_nonoverlapping(bytes.as_ptr(), created_by_buf, n);
        .map_err(|e| format!("Failed to open {}: {}", filename, e))?;
    };
                    ..Default::default()
                .unwrap();
    crate::memory::set_write_limit(new_limit as usize);
    };
    fn live_bits_array_from_raw_decodes_single_input() {
            &sort_cols,
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
    )
    // Per-merge stats forwarded to the per-shard ParquetShardStatsTracker on the Java side.
    type_encoding_value_lens: *const i64,
                *num_rows_out = fm.num_rows();
            Some(v)
    type_bf_ndv_name_ptrs: *const *const u8,
        }
pub unsafe extern "C" fn parquet_write(
                .as_any()
    .map_err(|e| format!("parquet_on_settings_update type_bf_fpp_names: {}", e))?;
/// is called with the granted byte count when the reservation is released. Because all native
    fn opt_usize(v: i64) -> Option<usize> {
/// Get pool stats: writes 6 i64s to out_buf.
                });
            Ok(0)
        }
#[no_mangle]
    index_name_ptr: *const u8,
    compression_level: i64,
}
                    *sort_perm_ptr_out = 0;
    sort_perm_len_out: *mut i64,
        .to_string();
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
            .into_iter()
/// Returns a JSON string with per-column encoding and compression metadata.
        arrow::datatypes::DataType::Utf8 => {
        assert!(result.is_empty());
        }
    }
                .downcast_ref::<arrow::array::Float64Array>()
        assert_eq!(decoded[1], 0u64);
// ---------------------------------------------------------------------------
#[ffm_safe]
    Ok(0)
    let mapping = result.mapping.into_boxed_slice();
        assert_eq!(result.len(), 1);
    std::ptr::copy_nonoverlapping(arr.as_ptr(), out_buf, 17);
            .enumerate()
#[no_mangle]
    .map_err(|e| format!("parquet_on_settings_update field_compression_names: {}", e))?;
 * SPDX-License-Identifier: Apache-2.0
            None
            if !created_by_len_out.is_null() {
    type_compression_value_lens: *const i64,
    if !version_out.is_null() {
use crate::field_config::FieldConfig;
    let mut live_docs = live_bits_array_from_raw(live_bits_ptrs, live_bits_lens, live_bits_count);
// Native runtime metrics
        for row_idx in 0..batch.num_rows() {
    gen_sizes_ptr: i64,
    )
    std::ptr::copy_nonoverlapping(bytes.as_ptr(), out_buf, bytes.len());
            Some(map)
    created_by_buf_len: i64,
            serde_json::json!(arr.value(row_idx))
    .map_err(|e| format!("parquet_on_settings_update type_compression_names: {}", e))?;
    json.push('}');
    // Java reads them and then calls parquet_free_merge_result to deallocate.
        .map_err(|e| format!("parquet_write: {}", e))?
    live_bits_count: i64,
        s.tokio_global_queue_depth,
    out_gen_sizes_ptr: *mut i64,
        .map_err(|e| format!("parquet_merge_files output: {}", e))?;
    field_encoding_lens: *const i64,
            rows.push(serde_json::Value::Object(obj));
        )
    }
        }
    NativeParquetWriter::create_writer(
                );
    let n = gen_count as usize;
// ---------------------------------------------------------------------------
    NativeParquetWriter::write_data(filename, array_address, schema_address)
    )
    let n = count as usize;
                *created_by_len_out = -1;
                    let boxed = perm.into_boxed_slice();
            json.push(',');
        out.push(Some(slice.to_vec()));
    type_bf_enabled_count: i64,
        writer_generation,
    }
            &input_files,
            if !crc32_out.is_null() {
    type_bf_ndv_vals: *const i64,
            .collect();
unsafe fn live_bits_array_from_raw(
    SETTINGS_STORE.remove(&index_name);
        type_encoding_count,
    num_rows_out: *mut i64,
        .map_err(|e| format!("parquet_cleanup_writer: {}", e))?
        compression_type,
            let arr = col
// Settings management
        let p = *ptrs.add(i);
            .into_iter()
    index_name_ptr: *const u8,
#[no_mangle]
    if count == 0 {
/// Frees the heap-allocated row ID mapping array returned as part of `parquet_finalize_writer`.
// ---------------------------------------------------------------------------
                .downcast_ref::<arrow::array::Int32Array>()
        type_encoding_value_lens,
        type_encoding_value_ptrs,
    let sizes = result.gen_sizes.into_boxed_slice();
        .build()
        let map: std::collections::HashMap<_, _> = type_bf_fpp_names
) -> i64 {
    };
    out_mapping_len: *mut i64,
    if !version_out.is_null() {
            "JSON output ({} bytes) exceeds buffer capacity ({})",
    fn live_bits_array_from_raw_zero_length_entry_yields_none() {
    merge_batch_size: i64,
        let map: std::collections::HashMap<_, _> = type_compression_names
        None
                .to_string(),
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 3) };
            &reverse_flags,
        .map_err(|e| format!("parquet_on_settings_update index_name: {}", e))?
        } else {
        *out_buf.add(i) = *val as i64;
#[no_mangle]
        type_compression_count,
    }
/// The caller passes a buffer of 11 i64s. On success, writes the 11-stat snapshot in the order
    *out_mapping_len = mapping.len() as i64;
                FieldConfig {
        }
        } else {
        if map.is_empty() {
// ---------------------------------------------------------------------------
    let type_compressions = str_array_from_raw(
pub unsafe extern "C" fn parquet_get_filtered_native_bytes_used(
    field_compression_value_lens: *const i64,
    let mapping_bytes = mapping.len() * std::mem::size_of::<i64>();
                .unwrap();
        .get(index_name)
    let mut out = Vec::with_capacity(n);
            None
    if let Some(cb) = fm.created_by() {
            out.push(None);
            let mut items = Vec::with_capacity(elements.len());
    }
    }
    out_len: *mut i64,
    type_bf_fpp_name_ptrs: *const *const u8,
/// Each row is a JSON object. The result is a JSON array of objects.
        let json = "{}".to_string();
            output_path,
        *created_by_len_out = -1;
        s.tokio_local_queue_depth_total,
        let bits: Vec<i64> = vec![1i64, 0i64, 0x0123_4567i64];
//! Return convention: `>= 0` success, `< 0` error pointer (negate to get ptr,
    lens: *const i64,
        reverse_sorts,
        type_bf_ndv_name_lens,
    bloom_filter_enabled: i64,
    if !num_row_groups_out.is_null() {
#[ffm_safe]
#[ffm_safe]
            let n = bytes.len().min(created_by_buf_len as usize);
        } else {
        arrow::datatypes::DataType::List(_) => {
    page_size_bytes: i64,
        assert_eq!(result[2].as_ref().unwrap()[0], 0x00FF_FF00_0000_0000u64);
    lens: *const i64,
    let rg = metadata.row_group(0);
    out_flush_and_sort_chunk_count: *mut i64,
            None
            let arr = col
    #[test]
            None
        }
        type_bf_fpp_name_ptrs,
        let _ = Box::from_raw(slice::from_raw_parts_mut(
                .map(|e| format!("\"{}\"", e))
        let map: std::collections::HashMap<_, _> = type_bf_enabled_names
    .map_err(|e| format!("{}", e))?;
        s.rayon_merge_tasks_submitted,
    let type_compression_configs: Option<std::collections::HashMap<String, String>> = {
    compression_type_ptr: *const u8,
            None
    crate::memory::init_pools(write_limit as usize, merge_limit as usize);
        s.tokio_num_workers,
        let mapping_bytes = mapping_len as usize * std::mem::size_of::<i64>();
    #[test]
        } else {
        field_compression_name_lens,
    }
    }
        ..Default::default()
mod tests {
                    *sort_perm_len_out = 0;
/// Returns 0 on success.
    let n = count as usize;
        if v < 0 {
    let type_bf_ndv_names = str_array_from_raw(
    Ok(0)
        let bits: Vec<i64> = vec![0xFFFF_FFFF_FFFF_FFFEu64 as i64];
                .map_err(|e| format!("parquet_on_settings_update compression_type: {}", e))?
            map.insert(
    }
            None
    fn live_bits_array_from_raw_null_inner_ptr_yields_none() {
/// Collect a snapshot of native runtime stats for the parquet merge path.
    str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))
            Some(v as usize)
        .map_err(|e| format!("parquet_read_as_json: {}", e))?
    let index_name = str_from_raw(index_name_ptr, index_name_len)
}
            bytes.len(),
}
 * The OpenSearch Contributors require contributions made to
#[ffm_safe]
        .map_err(|e| format!("parquet_get_file_metadata: {}", e))?
/// This lets list-typed columns round-trip through `parquet_read_as_json` so tests
    created_by_len_out: *mut i64,
            }
    Ok(0)
        field_compression_count,
        if i > 0 {
            } else if !created_by_len_out.is_null() {
        .map_err(|e| format!("parquet_on_settings_update field_encodings: {}", e))?;
            result[1].is_none(),
    }
}
        let decoded = result[0].as_ref().expect("expected Some");
        assert!(result[0].is_some());
        let result = unsafe { live_bits_array_from_raw(std::ptr::null(), std::ptr::null(), 0) };
    }
    version_out: *mut i32,
    type_bf_ndv_name_lens: *const i64,
                } else {
/// `null`, an empty list stays `[]`, and a null child element stays JSON `null`,
    #[test]
    field_compression_name_lens: *const i64,
        merge::merge_sorted(
        .map_err(|e| format!("parquet_finalize_writer: {}", e))?
    created_by_len_out: *mut i64,
                .unwrap();
            &input_files,
    created_by_buf_len: i64,
    if col.is_null(row_idx) {
pub unsafe extern "C" fn parquet_get_column_metadata(
        }
    let count = result.gen_keys.len();
    created_by_buf: *mut u8,
        let has_bloom_filter = col.bloom_filter_offset().is_some();
        .map_err(|e| format!("Failed to read parquet: {}", e))?;
#[ffm_safe]
            }
        row_group_max_rows: opt_usize(row_group_max_rows),
    index_name_len: i64,
        assert_eq!(result[0].as_ref().unwrap()[0], 0x0000_0000_0000_000Fu64);
        type_encoding_name_lens,
    .map_err(|e| format!("parquet_on_settings_update type_compressions: {}", e))?;
}
    crc32_out: *mut i64,
    }
        let _ = Box::from_raw(slice::from_raw_parts_mut(
        // i64 0xFFFF_FFFF_FFFF_FFFE reinterpreted as u64 ⇒ 0xFFFF_FFFF_FFFF_FFFE
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
        *num_rows_out = fm.num_rows();
unsafe fn str_array_from_raw(
            None
        let ptr = bits.as_ptr();
    fn live_bits_array_from_raw_zero_count_returns_empty() {
pub unsafe extern "C" fn parquet_on_settings_update(
    let type_bf_fpp_names = str_array_from_raw(
// ---------------------------------------------------------------------------
#[no_mangle]
    reverse_vals: *const i64,
        let bits_c: Vec<i64> = vec![0x00FF_FF00_0000_0000u64 as i64];
        if !created_by_buf.is_null() && created_by_buf_len > 0 {
    output_writer_generation: i64,
    *out_flush_and_sort_chunk_time_millis = result.flush_and_sort_chunk_time_millis;
    if ptr.is_null() {
            &max_sort_mode_flags,
pub unsafe extern "C" fn parquet_get_file_metadata(
        let ptrs: Vec<*const i64> = vec![std::ptr::null()];
    type_encoding_value_ptrs: *const *const u8,
            let arr = col
    let reverse_sorts = bool_array_from_raw(reverse_vals, reverse_count);
    field_name_lens: *const i64,
        let map: std::collections::HashMap<_, _> = type_encoding_names
    let n = bytes.len().min(out_buf_len as usize);
            for i in 0..elements.len() {
    Ok(0)
        live_docs.resize(input_files.len(), None);
            map.entry(name)
// ---------------------------------------------------------------------------
            }
    }
        .to_string();
    num_row_groups_out: *mut i64,
) -> i64 {
            .zip(type_encodings.into_iter())
    prefix_len: i64,
    let mut out = Vec::with_capacity(n);
        merge::merge_unsorted(
                    let len = perm.len();
    }
/// Set write pool limit. Called by Java rebalancer via FFM.
 *
        ));
        assert_eq!(decoded[0], 0xFFFF_FFFF_FFFF_FFFEu64);
            if !version_out.is_null() {
#[no_mangle]
/// preserving the null-vs-empty-vs-null-child distinctions the merge must not lose.
        }
    out_buf: *mut u8,
            "middle entry with len=0 should be None"
    let input_files = str_array_from_raw(input_ptrs, input_lens, input_count)
    use arrow::array::Array;
    bloom_filter_ndv: i64,
/// The JSON bytes are written into `out_buf`, actual length into `out_len`.
    index_name_ptr: *const u8,
        }
            let mm = s.max_sort_modes.clone();
        merge_batch_size: opt_usize(merge_batch_size),
        dict_size_bytes: opt_usize(dict_size_bytes),
        let col_name = col.column_path().string();
        assert!(result[2].is_some());
        filename,
/// Frees the heap-allocated arrays returned by `parquet_merge_files`.
use std::str;
    out_len: *mut i64,
        s.rayon_merge_tasks_failed,
    let metadata = reader.metadata();
) -> Result<Vec<String>, String> {
            "parquet_collect_runtime_metrics: out_len {} < 17",
        let lens: Vec<i64> = vec![1];
    crate::memory::set_merge_limit(new_limit as usize);
    fn live_bits_array_from_raw_negative_length_entry_yields_none() {
    }
                },
            if !num_row_groups_out.is_null() {
        let batch = batch_result.map_err(|e| format!("Read error: {}", e))?;
        ));
        max_sort_modes,
        return serde_json::Value::Null;
        json.push_str(&format!(
    out_mapping_ptr: *mut i64,
        assert_eq!(result.len(), 1);
    type_compression_name_lens: *const i64,
        }
 * compatible open source license.
    }
    let result = if sort_cols.is_empty() {
    let fm = result.metadata.file_metadata();
        type_bf_fpp_count,
    output_ptr: *const u8,
    version_out: *mut i32,
    for i in 0..rg.num_columns() {
            let arr = col
        page_size_bytes: opt_usize(page_size_bytes),
            map.entry(name)
#[no_mangle]
            let mut obj = serde_json::Map::new();
                .or_insert(FieldConfig {
        type_compression_name_lens,
/// Format: {"column_name": {"encodings": ["PLAIN", "RLE_DICTIONARY"], "compression": "LZ4_RAW"}, ...}
/// error pointer on failure (per FFM convention).
unsafe fn bool_array_from_raw(vals: *const i64, count: i64) -> Vec<bool> {
        schema_address,
        .map(|_| 0)
                .join(","),
    if gen_sizes_ptr != 0 && n > 0 {
        type_bf_ndv_name_ptrs,
            Some(map)
    }
#[no_mangle]
        .map_err(|e| format!("parquet_merge_files inputs: {}", e))?;
        if !created_by_buf.is_null() && created_by_buf_len > 0 {
/// Initialize write and merge memory pool counters.
use crate::native_settings::NativeSettings;
#[no_mangle]
        let n = bytes.len().min(out_buf_len as usize);
// Tests
                .collect::<Vec<_>>()
    compression_type_len: i64,
    ptrs: *const *const i64,
    if mapping_ptr != 0 && mapping_len > 0 {
    match col.data_type() {
///
        s.tokio_workers_busy_millis_total,
    *out_gen_offsets_ptr = Box::into_raw(offsets) as *mut i32 as i64;
    } else if !created_by_len_out.is_null() {
    }
    merge_io_threads: i64,
        // Java released merge mapping — free from pool
        type_bloom_filter_ndv,
    if out_len < 17 {
        .map_err(|e| format!("parquet_on_settings_update field_names: {}", e))?;
        let map: std::collections::HashMap<_, _> = type_bf_ndv_names
        .map_err(|e| format!("parquet_remove_settings: {}", e))?
    type_compression_value_ptrs: *const *const u8,
        s.rayon_merge_tasks_started,
        let mut map = std::collections::HashMap::new();
        let col = rg.column(i);
}
            mapping_ptr as *mut i64,
    }
    }
    let type_encoding_configs: Option<std::collections::HashMap<String, String>> = {
        let l = *lens.add(i);
        s.rayon_merge_wall_millis,
        } else {
        let bits_a: Vec<i64> = vec![0x0000_0000_0000_000Fi64];
            let bytes = cb.as_bytes();
            if !created_by_len_out.is_null() {
            if let Some(cb) = fm.created_by() {
    created_by_buf_len: i64,
            has_bloom_filter
) -> i64 {
/// Register the over-commit decision callbacks (FFM upcall stubs from the Java allocator).
        if v < 0 {
            }
/// can assert LIST values survive the write/merge path: a null list row stays JSON
    }
                .as_any()
pub unsafe extern "C" fn parquet_get_pool_stats(out_buf: *mut i64) {
        merge_rayon_threads: opt_usize(merge_rayon_threads),
pub unsafe extern "C" fn parquet_read_as_json(
    let index_name = str_from_raw(index_name_ptr, index_name_len)
    out_buf_len: i64,
    file_ptr: *const u8,
            Some(map)
                .iter()
            .collect();
        *version_out = fm.version();
/// documented in `ParquetNativeRuntimeStats.fromArray`. Returns 0 on success, or a negative
        assert_eq!(result.len(), 1);
#[ffm_safe]
    if metadata.num_row_groups() == 0 {
                    *sort_perm_len_out = len as i64;
        sort_in_memory_threshold_bytes: opt_u64(sort_in_memory_threshold_bytes),
            std::ptr::copy_nonoverlapping(bytes.as_ptr(), created_by_buf, n);
    index_name_ptr: *const u8,
        }
    dict_size_bytes: i64,
            }
    let type_bloom_filter_fpp: Option<std::collections::HashMap<String, f64>> = {
        );
            .into_iter()
    let reader = builder
    type_compression_count: i64,
    num_row_groups_out: *mut i64,
        assert!(
    fn opt_i32(v: i64) -> Option<i32> {
/// Decode a parallel (pointers, lengths, count) triple into `Vec<String>`.
        assert_eq!(result.len(), 1);
        type_bloom_filter_fpp,
        let compression = format!("{:?}", col.compression());
// ---------------------------------------------------------------------------
            index_name,
        .map_err(|e| format!("parquet_create_writer index_name: {}", e))?
    *out_mapping_ptr = Box::into_raw(mapping) as *mut i64 as i64;
    file_ptr: *const u8,
        *out_len = n as i64;
            for (col_idx, field) in schema.fields().iter().enumerate() {
                .as_any()
///
                name,
    page_row_limit: i64,
    .map_err(|e| format!("parquet_on_settings_update type_encodings: {}", e))?;
        *num_row_groups_out = metadata.num_row_groups() as i64;
// ---------------------------------------------------------------------------
    let sort_columns = str_array_from_raw(sort_ptrs, sort_lens, sort_count)
// ---------------------------------------------------------------------------
    Ok(0)
/// Decode a parallel (pointers, count) array of i64 values interpreted as booleans (0 = false).
        if l <= 0 || ptrs.is_null() {
#[no_mangle]
            .map_err(|e| format!("parquet_on_settings_update bf_enabled_names: {}", e))?;
            let arr = col
#[no_mangle]
        let lens: Vec<i64> = vec![-1];
    if count == 0 || vals.is_null() {
        .to_string();
fn array_value_to_json(col: &dyn arrow::array::Array, row_idx: usize) -> serde_json::Value {
        *num_rows_out = fm.num_rows();
        type_encoding_count,
}
    };
        if v < 0 {
    fn opt_bool(v: i64) -> Option<bool> {
                .unwrap();
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
    type_bf_enabled_vals: *const i64,
        s.tokio_overflow_count_total,
        arrow::datatypes::DataType::Float64 => {
    created_by_len_out: *mut i64,
    gen_count: i64,
/// Each entry corresponds to one input file. Null pointer or zero length ⇒ "all alive".
                .unwrap();
        index_name: Some(index_name.clone()),
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
/// Reads a parquet file and returns its contents as a JSON string.
        let bytes = json.as_bytes();
use std::slice;
        field_compression_count,
            out_len
    ];
        Some(s) => {
) -> Vec<Option<Vec<u64>>> {
) -> i64 {
    created_by_buf: *mut u8,
    if gen_offsets_ptr != 0 && n > 0 {
#[no_mangle]
use crate::merge;
}
        if map.is_empty() {
    }
/// Used by the Java shard close / going-red flow to guarantee a writer left behind by a failed
            Some(map)
    // Write row-ID mapping into out-pointers as heap-allocated arrays.
        merge_io_threads: opt_usize(merge_io_threads),
        let encodings: Vec<String> = col.encodings().map(|e| format!("{:?}", e)).collect();
    NativeParquetWriter::cleanup_writer(&filename)
        }
    if let Some(cb) = fm.created_by() {
    #[test]
            continue;
            }
    for i in 0..n {
                if !created_by_buf.is_null() && created_by_buf_len > 0 {
        s.tokio_polls_count_total,
}
    let bytes = slice::from_raw_parts(ptr, len as usize);
                    crate::memory::write_pool().grow(mapping_bytes);
            .into_iter()
        .to_string();
                    encoding_type: Some(encoding),
    file_len: i64,
        if map.is_empty() {
        }
    let mut json = String::from("{");
    };
    let filename = str_from_raw(file_ptr, file_len)
                .downcast_ref::<arrow::array::BooleanArray>()
    live_bits_lens: *const i64,
    for batch_result in reader {
    file_ptr: *const u8,
                        *created_by_len_out = n as i64;
 * this file be licensed under the Apache-2.0 license or a
            .collect();
pub unsafe extern "C" fn parquet_remove_settings(
        } else {
    count: i64,
    bf_enabled_count: i64,
) -> i64 {
        type_encoding_configs,
    let filename = str_from_raw(file_ptr, file_len)
    };
        bloom_filter_ndv: opt_u64(bloom_filter_ndv),
    crc32_out: *mut i64,
            let nf = s.nulls_first.clone();
    row_group_max_rows: i64,
                    if !created_by_len_out.is_null() {
            encodings
        assert_eq!(decoded[2], 0x0123_4567u64);
pub unsafe extern "C" fn parquet_create_writer(
                .as_any()
    merge_rayon_threads: i64,
    let index_name = str_from_raw(index_name_ptr, index_name_len)
            None
    buf_capacity: i64,
        .to_string();
pub extern "C" fn parquet_register_overcommit_callbacks(
                if let Some(perm) = result.row_id_mapping {
                    ..Default::default()
        out.push(str_from_raw(p, l)?.to_string());
            output_writer_generation,
/// Removes the writer registry entry for `file` without finalizing it (idempotent).
/*
        {
            serde_json::Value::Array(items)
        }
            Some(map)
            &nulls_first_flags,
// Memory pool management (Phase 1 stubs)
    let type_bf_enabled_names = str_array_from_raw(
    reverse_count: i64,
        field_configs,
                    compression_type: Some(compression),
                .and_modify(|fc| fc.bloom_filter_enabled = Some(val))
        bloom_filter_enabled: opt_bool(bloom_filter_enabled),
    )
        )
        if map.is_empty() {
        let p = *ptrs.add(i);
            let fm = result.metadata.file_metadata();
}
    use std::fs::File;
                items.push(array_value_to_json(elements.as_ref(), i));
                .as_any()
    fn opt_f64(v: f64) -> Option<f64> {
    schema_address: i64,
            &live_docs,
        } else {
                obj.insert(
        Err(e) => Err(e.to_string()),
                crate::log_info!("parquet_merge_files: sort columns present but reverse_sorts is empty for index '{}', defaulting to ascending", index_name);
                let col = batch.column(col_idx);
        *crc32_out = result.crc32 as i64;
        ));
        return vec![];
        .with_batch_size(8192)
    output_len: i64,
    };
            let sc = s.sort_columns.clone();
    gen_offsets_ptr: i64,
            .zip(type_compressions.into_iter())
        arrow::datatypes::DataType::Boolean => {
#[ffm_safe]
    type_bf_enabled_name_lens: *const i64,
        } else {
        .map_err(|e| format!("parquet_get_column_metadata: {}", e))?
    type_encoding_name_ptrs: *const *const u8,
            if !num_rows_out.is_null() {
            .map(|(i, name)| (name, *type_bf_ndv_vals.add(i) as u64))
            output_writer_generation,
    if mapping_ptr != 0 && mapping_len > 0 {
/// registration covers every pool that uses `Reject`.
                    ..Default::default()
    let fm = metadata.file_metadata();
    if !num_rows_out.is_null() {
        None => {
                *created_by_len_out = n as i64;
        if v < 0.0 {
    }
        .map(|_| 0)
    )
        } else {
            let val = *bf_enabled_vals.add(i) != 0;
        }
    // Parse type-level bloom filter arrays
) -> i64 {
) {
        let invalid_ptr: *const i64 = usize::MAX as *const i64;
            col_name,
        nulls_first,
pub extern "C" fn parquet_init_memory_pools(write_limit: i64, merge_limit: i64) {
        }
pub extern "C" fn parquet_set_write_pool_limit(new_limit: i64) {
    file_ptr: *const u8,
    let filename = str_from_raw(file_ptr, file_len)
    let bytes = json_str.as_bytes();
#[ffm_safe]
    }
            serde_json::Value::Number(arr.value(row_idx).into())
        s.tokio_active_tasks,
    {
    // layout. Pass `live_bits_count == 0`, or per-file length 0, for "all alive".
    file_len: i64,
    if out_buf.is_null() {
    file_len: i64,
                .unwrap();
                .downcast_ref::<arrow::array::Int64Array>()
        .map_err(|e| format!("parquet_merge_files index_name: {}", e))?;
    let type_compression_names = str_array_from_raw(
    version_out: *mut i32,
        let decoded = result[0].as_ref().expect("expected non-None entry");
        type_bf_enabled_name_ptrs,
    )
    }
    for i in 0..n {
    if count == 0 || lens.is_null() {
    prefix_ptr: *const u8,
    // ===== live_bits_array_from_raw =====
    for (i, val) in stats.iter().enumerate() {
        assert!(result[0].is_none());
            if !sc.is_empty() && nf.is_empty() {
        compression_level: opt_i32(compression_level),
pub unsafe extern "C" fn parquet_free_row_id_mapping(mapping_ptr: i64, mapping_len: i64) {
    file_len: i64,
    };
) -> i64 {
    let field_compression_names = str_array_from_raw(
        Ok(None) => Ok(1),
    .map_err(|e| format!("parquet_on_settings_update type_bf_enabled_names: {}", e))?;
        field_compression_name_ptrs,
    *out_len = bytes.len() as i64;
#[ffm_safe]
                    }
                .downcast_ref::<arrow::array::ListArray>()
}
        ));
            output_path,
/// operation does not survive as a stale entry and block recovery's re-`create_writer`.
        field_compression_value_lens,
            continue;
    // Per-input live-docs bitsets (parallel to input_ptrs) in Lucene `FixedBitSet#getBits()`
    mapping_ptr: i64,
            .enumerate()
        s.tokio_spawned_tasks_total,
    }
}
 */
    } else {
    use parquet::file::reader::{FileReader, SerializedFileReader};
            compression,
                    *sort_perm_ptr_out = Box::into_raw(boxed) as *mut i64 as i64;
    (0..n).map(|i| *vals.add(i) != 0).collect()
        }
        let result = unsafe { live_bits_array_from_raw(invalid_ptrs, std::ptr::null(), 1) };
    let builder = parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder::try_new(file)
            mapping_len as usize,
    sort_ptrs: *const *const u8,
                .and_modify(|fc| fc.compression_type = Some(compression.clone()))
        }
    let keys = result.gen_keys.into_boxed_slice();
    index_name_len: i64,
    if gen_keys_ptr != 0 && n > 0 {
            serde_json::Value::Number(arr.value(row_idx).into())
        return Err(format!("negative string length: {}", len));
    }
) -> i64 {
        let mapping_bytes = mapping_len as usize * std::mem::size_of::<i64>();
    created_by_buf: *mut u8,
    )
        Ok(Some(result)) => {
) {
                }
    }
        arrow::datatypes::DataType::Int64 => {
}
            let n = bytes.len().min(created_by_buf_len as usize);
    out
            index_name,
/// Returns 0 on success, negative error pointer on failure (per FFM convention).
        assert_eq!(decoded.len(), 3);
        return Err("null string array pointer".to_string());
        let _ = Box::from_raw(slice::from_raw_parts_mut(gen_sizes_ptr as *mut i32, n));
    field_compression_count: i64,
pub unsafe extern "C" fn parquet_free_merge_result(
            .into_iter()
    let json_str =
                .as_any()
    .map_err(|e| e.to_string())
    )
        .map_err(|e| format!("Failed to build reader: {}", e))?;
        }
            buf_capacity
    }
        return Err(format!(
    releaser: native_bridge_common::memory_pool::OverCommitReleaser,
    let max_sort_modes = bool_array_from_raw(max_sort_mode_vals, max_sort_mode_count);
        .to_string();
        std::ptr::copy_nonoverlapping(bytes.as_ptr(), out_buf, n);
}
    decider: native_bridge_common::memory_pool::OverCommitDecider,
        let _ = Box::from_raw(slice::from_raw_parts_mut(gen_keys_ptr as *mut i64, n));
                *num_row_groups_out = result.metadata.num_row_groups() as i64;
    let file = std::fs::File::open(&filename)
        type_encoding_name_ptrs,
                    std::ptr::copy_nonoverlapping(bytes.as_ptr(), created_by_buf, n);
        str_array_from_raw(bf_enabled_name_ptrs, bf_enabled_name_lens, bf_enabled_count)
        }
        type_compression_count,
    }
    }
    .map_err(|e| format!("parquet_on_settings_update field_compressions: {}", e))?;
    }
        }
/// `decider(requested_bytes) -> 1|0` decides whether a full pool may over-commit; `releaser(bytes)`
    file_ptr: *const u8,
}
                    let n = bytes.len().min(created_by_buf_len as usize);
    }
    out_gen_offsets_ptr: *mut i64,
                .downcast_ref::<arrow::array::StringArray>()
            None
        let ptrs: Vec<*const i64> = vec![ptr];
        let ptrs: Vec<*const i64> = vec![std::ptr::null()];
    fn live_bits_array_from_raw_null_lens_returns_empty() {
    field_count: i64,
    }
/// Set merge pool limit. Called by Java rebalancer via FFM.
}
    row_group_max_bytes: i64,
    if ptrs.is_null() || lens.is_null() {
                .or_insert(FieldConfig {
            );
    }
    live_bits_ptrs: *const *const i64,
        .map_err(|e| e.to_string())
    bf_enabled_name_ptrs: *const *const u8,
        .to_string();
    field_compression_name_ptrs: *const *const u8,
        SerializedFileReader::new(file).map_err(|e| format!("Failed to read parquet: {}", e))?;
    let type_encoding_names = str_array_from_raw(
//!
            serde_json::Value::String(arr.value(row_idx).to_string())
    field_name_ptrs: *const *const u8,
        .to_string();
            out.push(None);
            Some(v != 0)
        assert_eq!(decoded[0], 1u64);
        let ptrs: Vec<*const i64> = vec![bits.as_ptr()];
// Parquet reader (for test verification)
    .map(|_| 0)
        let _ = Box::from_raw(slice::from_raw_parts_mut(gen_offsets_ptr as *mut i32, n));
    bloom_filter_fpp: f64,
    type_encoding_name_lens: *const i64,
    let field_names = str_array_from_raw(field_name_ptrs, field_name_lens, field_count)
    let type_bloom_filter_enabled: Option<std::collections::HashMap<String, bool>> = {
    let (sort_cols, reverse_flags, nulls_first_flags, max_sort_mode_flags) = match SETTINGS_STORE
        if p.is_null() {
                *created_by_len_out = n as i64;
    let bf_enabled_names =
        type_compression_configs,
#[no_mangle]
        sort_columns,
            let elements = arr.value(row_idx);
        }
                });
    let field_encodings = str_array_from_raw(field_encoding_ptrs, field_encoding_lens, field_count)
    #[test]
    let filename = str_from_raw(file_ptr, file_len)
        .to_string();
    max_sort_mode_count: i64,
//! call `native_error_message`/`native_error_free`).
}
use crate::writer::{NativeParquetWriter, SETTINGS_STORE};
        page_row_limit: opt_usize(page_row_limit),
}
        type_compression_value_ptrs,
    #[test]
    mapping_len: i64,
                }
        type_bf_fpp_name_lens,
            *out_len = n as i64;
        .map_err(|e| format!("parquet_create_writer file: {}", e))?
// ---------------------------------------------------------------------------
        if !out_len.is_null() {
#[no_mangle]
            .zip(field_compressions.into_iter())
#[no_mangle]
            result[0].is_none(),
        arrow::datatypes::DataType::Int32 => {
    #[test]
        let schema = batch.schema();
    )
        if map.is_empty() {
                    field.name().clone(),
            if !sort_perm_ptr_out.is_null() && !sort_perm_len_out.is_null() {
            }
    index_name_len: i64,
    *out_gen_sizes_ptr = Box::into_raw(sizes) as *mut i32 as i64;
            .into_iter()
/// Serializes a single Arrow array cell to JSON, recursing into LIST children.
                *crc32_out = result.crc32 as i64;
        _ => serde_json::Value::String(format!("<unsupported:{}>", col.data_type())),
    // Decode live-docs; pad with None to cover every input file.
            }
    input_lens: *const i64,
        ));
    *out_flush_and_sort_chunk_count = result.flush_and_sort_chunk_count;
                crate::log_info!("parquet_merge_files: sort columns present but nulls_first is empty for index '{}', defaulting to nulls last", index_name);
    )
        Some(
    max_sort_mode_vals: *const i64,
    Ok(0)
///
            .enumerate()
    type_encoding_count: i64,
            crate::log_info!("parquet_merge_files: no settings found for index '{}', proceeding with unsorted merge", index_name);
    }
            .map(|(i, name)| (name, *type_bf_enabled_vals.add(i) != 0))
/// Reads from the first row group.
        let ptrs: Vec<*const i64> = vec![std::ptr::null()];
    } else {
pub unsafe extern "C" fn parquet_collect_runtime_metrics(out_buf: *mut i64, out_len: i64) -> i64 {
// ---------------------------------------------------------------------------
            }
/// Decode a parallel array of (pointer, length) pairs into a vector of owned `u64` bitsets.
    .map_err(|e| format!("parquet_on_settings_update type_bf_ndv_names: {}", e))?;
    out_row_id_mapping_max: *mut i64,
    *out_gen_keys_ptr = Box::into_raw(keys) as *mut i64 as i64;
        index_name,
    out_gen_keys_ptr: *mut i64,
    native_bridge_common::memory_pool::set_overcommit_callbacks(decider, releaser);
    let arr: [i64; 17] = [
use native_bridge_common::ffm_safe;
            }
    }
        serde_json::to_string(&rows).map_err(|e| format!("JSON serialization failed: {}", e))?;
        }
    }
}
    } else if !created_by_len_out.is_null() {
    let config = NativeSettings {
        }
    // Per-merge stats out-pointers — callers always pass valid pointers (matches existing convention).
    let type_bloom_filter_ndv: Option<std::collections::HashMap<String, u64>> = {
    // Track merge mapping handoff to Java — Java holds until parquet_free_merge_result
        let ptrs: Vec<*const i64> = vec![bits_a.as_ptr(), std::ptr::null(), bits_c.as_ptr()];
    Ok(out)
    type_bf_ndv_count: i64,
        return Err(format!(
    input_ptrs: *const *const u8,
    fn live_bits_array_from_raw_mixed_some_none() {
        for (i, name) in bf_enabled_names.into_iter().enumerate() {
        }
            // Return sort permutation if present
pub extern "C" fn parquet_set_merge_pool_limit(new_limit: i64) {
    }
        type_bf_ndv_count,
            str_from_raw(compression_type_ptr, compression_type_len)
    if live_docs.len() < input_files.len() {
    sort_perm_ptr_out: *mut i64,
        type_bf_enabled_name_lens,
            Some(v as i32)
            serde_json::Value::Bool(arr.value(row_idx))
unsafe fn str_from_raw<'a>(ptr: *const u8, len: i64) -> Result<&'a str, String> {
    out_flush_and_sort_chunk_time_millis: *mut i64,
    type_compression_name_ptrs: *const *const u8,
}
            }
            Some(v as u64)
        )
    type_bf_fpp_vals: *const f64,
        }
    gen_keys_ptr: i64,
    *out_row_id_mapping_max = result.row_id_mapping_max;
        *created_by_len_out = -1;
    let n = count as usize;
#[no_mangle]
    let mut rows: Vec<serde_json::Value> = Vec::new();
//! FFM bridge for the Parquet writer.
        } else {
            let arr = col
/// Bitsets use Lucene `FixedBitSet#getBits()` layout.
    };
#[no_mangle]
    sort_lens: *const i64,
