            if !created_by_len_out.is_null() {
        type_encoding_configs,
            &input_files,
    .map_err(|e| format!("parquet_on_settings_update type_bf_fpp_names: {}", e))?;
        type_bf_ndv_name_ptrs,
    }
    let n = count as usize;
        } else {
                .unwrap();
    type_compression_count: i64,
    }
/// Frees the heap-allocated arrays returned by `parquet_merge_files`.
        s.tokio_global_queue_depth,
}
        *version_out = fm.version();
    let reader = builder
// ---------------------------------------------------------------------------
    };
    field_name_ptrs: *const *const u8,
    }
    sort_ptrs: *const *const u8,
    live_bits_lens: *const i64,
        return serde_json::Value::Null;
        return Err("parquet_collect_runtime_metrics: null out_buf".to_string());
    #[test]
    index_name_ptr: *const u8,
                    let mapping_bytes = len * std::mem::size_of::<i64>();
        } else {
        let encodings: Vec<String> = col.encodings().map(|e| format!("{:?}", e)).collect();
                .downcast_ref::<arrow::array::ListArray>()
            map.insert(
            let mm = s.max_sort_modes.clone();
        for row_idx in 0..batch.num_rows() {
// ---------------------------------------------------------------------------
    crate::memory::init_pools(write_limit as usize, merge_limit as usize);
            None
        .map_err(|e| format!("parquet_get_column_metadata: {}", e))?
    } else {
        if p.is_null() {
}
        .map_err(|e| format!("parquet_create_writer sort_columns: {}", e))?;
    num_row_groups_out: *mut i64,
            Some(v != 0)
    fn live_bits_array_from_raw_zero_count_returns_empty() {
                *version_out = fm.version();
    index_name_ptr: *const u8,
    created_by_len_out: *mut i64,
    let index_name = str_from_raw(index_name_ptr, index_name_len)
            let fm = result.metadata.file_metadata();
    out_mapping_len: *mut i64,
    }
        assert!(result[0].is_none());
    for i in 0..n {
    let filename = str_from_raw(file_ptr, file_len)
            for (col_idx, field) in schema.fields().iter().enumerate() {
        let result = unsafe { live_bits_array_from_raw(std::ptr::null(), std::ptr::null(), 0) };
        assert_eq!(result.len(), 1);
    crate::memory::set_write_limit(new_limit as usize);
    let mut out = Vec::with_capacity(n);
            &reverse_flags,
        field_compression_count,
    let sizes = result.gen_sizes.into_boxed_slice();
pub unsafe extern "C" fn parquet_get_pool_stats(out_buf: *mut i64) {
#[no_mangle]
        let lens: Vec<i64> = vec![0];
/// Layout: [write_limit, write_used, write_peak, merge_limit, merge_used, merge_peak]
        return Err("null string array pointer".to_string());
        if !out_len.is_null() {
    out_buf: *mut u8,
/// Decode a parallel (pointers, count) array of i64 values interpreted as booleans (0 = false).
            compression,
            serde_json::Value::Array(items)
                *crc32_out = result.crc32 as i64;
    #[test]
// ---------------------------------------------------------------------------
        }
                        *created_by_len_out = n as i64;
/// Removes the writer registry entry for `file` without finalizing it (idempotent).
    nulls_first_count: i64,
//! FFM bridge for the Parquet writer.
            "\"{}\":{{\"encodings\":[{}],\"compression\":\"{}\",\"bloom_filter\":{}}}",
                .map_err(|e| format!("parquet_on_settings_update compression_type: {}", e))?
unsafe fn str_from_raw<'a>(ptr: *const u8, len: i64) -> Result<&'a str, String> {
        for (name, encoding) in field_names.into_iter().zip(field_encodings.into_iter()) {
        let mapping_bytes = mapping_len as usize * std::mem::size_of::<i64>();
                );
            .collect();
    let type_bloom_filter_ndv: Option<std::collections::HashMap<String, u64>> = {
        let bytes = json.as_bytes();
    type_bf_ndv_vals: *const i64,
                } else {
/// Used by the Java shard close / going-red flow to guarantee a writer left behind by a failed
                },
        let bits_c: Vec<i64> = vec![0x00FF_FF00_0000_0000u64 as i64];
use crate::merge;
    .map_err(|e| format!("parquet_on_settings_update type_encoding_names: {}", e))?;
            mapping_ptr as *mut i64,
            encodings
    )
        for (i, name) in bf_enabled_names.into_iter().enumerate() {
) -> i64 {
    let filename = str_from_raw(file_ptr, file_len)
        let lens: Vec<i64> = vec![1];
            Some(map)
    let count = result.gen_keys.len();
        .map_err(|e| format!("parquet_merge_files index_name: {}", e))?;
                FieldConfig {
        let _ = Box::from_raw(slice::from_raw_parts_mut(
            &max_sort_mode_flags,
    if !crc32_out.is_null() {
    gen_sizes_ptr: i64,
#[no_mangle]
        let bits: Vec<i64> = vec![1i64, 0i64, 0x0123_4567i64];
        let l = *lens.add(i);
#[ffm_safe]
        assert_eq!(result.len(), 1);
            Some(map)
        .map_err(|e| format!("parquet_on_settings_update field_encodings: {}", e))?;
                    // Track mapping handoff to Java — Java holds until parquet_free_row_id_mapping
            .map(|(i, name)| (name, *type_bf_ndv_vals.add(i) as u64))
    type_encoding_name_lens: *const i64,
        }
    Ok(0)
        s.rayon_configured_threads,
) -> i64 {
    max_sort_mode_count: i64,
        let json = "{}".to_string();
            None
    // Parse per-field bloom filter arrays
    file_ptr: *const u8,
    merge_batch_size: i64,
/// modules share one cdylib (and thus one `native-bridge-common` instance), this single
    }
    out_len: *mut i64,
    bloom_filter_ndv: i64,
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 3) };
            has_bloom_filter
    if !version_out.is_null() {
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
                .downcast_ref::<arrow::array::BooleanArray>()
    input_lens: *const i64,
        .to_string();
                    ..Default::default()
            if let Some(cb) = fm.created_by() {
/// registration covers every pool that uses `Reject`.
#[ffm_safe]
        assert!(result.is_empty());
                *created_by_len_out = n as i64;
            .zip(type_compressions.into_iter())
        }
        let has_bloom_filter = col.bloom_filter_offset().is_some();
        .map_err(|e| format!("parquet_merge_files output: {}", e))?;
            None
        type_bf_enabled_name_lens,
        type_compression_name_ptrs,
            None
        }
            let arr = col
        s.tokio_num_blocking_threads,
                    compression_type: Some(compression),
            if !num_row_groups_out.is_null() {
    // Track merge mapping handoff to Java — Java holds until parquet_free_merge_result
        let ptr = bits.as_ptr();
#[no_mangle]
    schema_address: i64,
    version_out: *mut i32,
            std::ptr::copy_nonoverlapping(bytes.as_ptr(), created_by_buf, n);
        .map_err(|e| format!("parquet_create_writer index_name: {}", e))?
    if metadata.num_row_groups() == 0 {
            .into_iter()
        assert!(
        if !created_by_buf.is_null() && created_by_buf_len > 0 {
        field_compression_count,
            .collect();
    let rg = metadata.row_group(0);
    sort_perm_len_out: *mut i64,
    reverse_vals: *const i64,
    )
        type_encoding_name_ptrs,
        assert_eq!(result[0].as_ref().unwrap()[0], 0x0000_0000_0000_000Fu64);
    let n = count as usize;
        }
            Some(map)
/// documented in `ParquetNativeRuntimeStats.fromArray`. Returns 0 on success, or a negative
/// error pointer on failure (per FFM convention).
    }
    }
    }
    }
                    let boxed = perm.into_boxed_slice();
        assert!(result[0].is_some());
        } else {
        assert!(
            .into_iter()
    reverse_count: i64,
        let _ = Box::from_raw(slice::from_raw_parts_mut(gen_keys_ptr as *mut i64, n));
        let ptrs: Vec<*const i64> = vec![std::ptr::null()];
    };
        assert!(result.is_empty());
}
        .map_err(|e| format!("parquet_read_as_json: {}", e))?
    if out_buf.is_null() {
    created_by_buf_len: i64,
        } else {
        }
        .build()
        type_bloom_filter_ndv,
    let n = bytes.len().min(out_buf_len as usize);
        field_configs,
    gen_keys_ptr: i64,
    for (i, val) in stats.iter().enumerate() {
    let input_files = str_array_from_raw(input_ptrs, input_lens, input_count)
            .into_iter()
 * SPDX-License-Identifier: Apache-2.0
                *created_by_len_out = -1;
// ---------------------------------------------------------------------------
        arrow::datatypes::DataType::Boolean => {
        if v < 0 {
    }
    type_bf_ndv_count: i64,
    let field_compression_names = str_array_from_raw(
    native_bridge_common::memory_pool::set_overcommit_callbacks(decider, releaser);
    crc32_out: *mut i64,
        return Err(format!("negative string length: {}", len));
        if v < 0 {
            out_len
            .into_iter()
    lens: *const i64,
    }
#[no_mangle]
        }
        Some(s) => {
            serde_json::Value::String(arr.value(row_idx).to_string())
    max_sort_mode_vals: *const i64,
    fn live_bits_array_from_raw_mixed_some_none() {
        live_docs.resize(input_files.len(), None);
                }
            if !sc.is_empty() && nf.is_empty() {
pub unsafe extern "C" fn parquet_create_writer(
        } else {
            }
        .map(|_| 0)
            .enumerate()
                    std::ptr::copy_nonoverlapping(bytes.as_ptr(), created_by_buf, n);
#[ffm_safe]
    field_count: i64,
    out_gen_offsets_ptr: *mut i64,
        let map: std::collections::HashMap<_, _> = type_bf_ndv_names
    .map_err(|e| format!("parquet_on_settings_update type_bf_ndv_names: {}", e))?;
        s.tokio_spawned_tasks_total,
// Writer lifecycle
        s.tokio_overflow_count_total,
    }
            Some(v as usize)
    file_len: i64,
    let (sort_cols, reverse_flags, nulls_first_flags, max_sort_mode_flags) = match SETTINGS_STORE
) -> i64 {
                *created_by_len_out = n as i64;
    Ok(0)
        Some(
    NativeParquetWriter::create_writer(
    }
        let invalid_ptr: *const i64 = usize::MAX as *const i64;
}
                .collect::<Vec<_>>()
#[ffm_safe]
            Ok(0)
    }
        }
            "middle entry with len=0 should be None"
#[ffm_safe]
    if mapping_ptr != 0 && mapping_len > 0 {
        .to_string();
        }
    nulls_first_vals: *const i64,
    dict_size_bytes: i64,
}
        merge_batch_size: opt_usize(merge_batch_size),
        ..Default::default()
        let _ = Box::from_raw(slice::from_raw_parts_mut(gen_offsets_ptr as *mut i32, n));
    schema_address: i64,
                    field.name().clone(),
                }
    let field_configs = {
    compression_type_ptr: *const u8,
    }
            }
            (sc, rf, nf, mm)
 */
                .or_insert(FieldConfig {
        serde_json::to_string(&rows).map_err(|e| format!("JSON serialization failed: {}", e))?;
        }
        merge_io_threads: opt_usize(merge_io_threads),
    fn live_bits_array_from_raw_multi_word_bitmap() {
    }
    let max_sort_modes = bool_array_from_raw(max_sort_mode_vals, max_sort_mode_count);
    field_compression_name_ptrs: *const *const u8,
    }
    Ok(0)
    }
    bf_enabled_name_ptrs: *const *const u8,
                    ..Default::default()
    let metadata = reader.metadata();
}
    let mut out = Vec::with_capacity(n);
    }
            }
        let lens: Vec<i64> = vec![bits_a.len() as i64, 0, bits_c.len() as i64];
    // Write Parquet file metadata to out-pointers.
        .map_err(|e| e.to_string())
        let bits: Vec<i64> = vec![0xFFFF_FFFF_FFFF_FFFEu64 as i64];
    let metadata = NativeParquetWriter::get_file_metadata(filename).map_err(|e| e.to_string())?;
    field_encoding_ptrs: *const *const u8,
        if map.is_empty() {
    }
    if count == 0 {
        let slice = slice::from_raw_parts(p as *const u64, l as usize);
        }
// Parquet reader (for test verification)
        let lens: Vec<i64> = vec![bits.len() as i64];
        None
        reverse_sorts,
    file_ptr: *const u8,
        .map_err(|e| format!("parquet_finalize_writer: {}", e))?
        let map: std::collections::HashMap<_, _> = type_bf_enabled_names
        ));
            } else if !created_by_len_out.is_null() {
    ptrs: *const *const u8,
                    encoding_type: Some(encoding),
 * this file be licensed under the Apache-2.0 license or a
    if !num_rows_out.is_null() {
    type_bf_fpp_vals: *const f64,
    // Java reads them and then calls parquet_free_merge_result to deallocate.
/// Bitsets use Lucene `FixedBitSet#getBits()` layout.
) {
    (0..n).map(|i| *vals.add(i) != 0).collect()
// ---------------------------------------------------------------------------
    field_compression_value_lens: *const i64,
                .as_any()
    }
            if !num_rows_out.is_null() {
    array_address: i64,
            "null pointer with positive length should yield None"
                items.push(array_value_to_json(elements.as_ref(), i));
            let sc = s.sort_columns.clone();
        }
    sort_perm_ptr_out: *mut i64,
            index_name,
        type_bf_ndv_count,
    .map_err(|e| format!("parquet_on_settings_update type_encodings: {}", e))?;
pub unsafe extern "C" fn parquet_get_filtered_native_bytes_used(
    let bf_enabled_names =
/// Frees the heap-allocated row ID mapping array returned as part of `parquet_finalize_writer`.
    // Per-merge stats forwarded to the per-shard ParquetShardStatsTracker on the Java side.
#[no_mangle]
        type_bloom_filter_enabled,
    type_compression_name_lens: *const i64,
    output_writer_generation: i64,
    } else if !created_by_len_out.is_null() {
    merge_io_threads: i64,
    bf_enabled_vals: *const i64,
            let elements = arr.value(row_idx);
/// Each row is a JSON object. The result is a JSON array of objects.
        crate::memory::merge_pool().shrink(mapping_bytes);
        type_encoding_name_lens,
            serde_json::Value::Number(arr.value(row_idx).into())
}
            .collect();
    let filename = str_from_raw(file_ptr, file_len)
            str_from_raw(compression_type_ptr, compression_type_len)
        assert_eq!(decoded.len(), 1);
        let map: std::collections::HashMap<_, _> = type_bf_fpp_names
 * compatible open source license.
        }
            buf_capacity
        }
    let n = count as usize;
        bloom_filter_enabled: opt_bool(bloom_filter_enabled),
/// The caller passes a buffer of 11 i64s. On success, writes the 11-stat snapshot in the order
        SerializedFileReader::new(file).map_err(|e| format!("Failed to read parquet: {}", e))?;
unsafe fn live_bits_array_from_raw(
        assert_eq!(decoded[1], 0u64);
        type_bf_enabled_name_ptrs,
        let ptrs: Vec<*const i64> = vec![std::ptr::null()];
) -> i64 {
#[no_mangle]
    type_bf_ndv_name_ptrs: *const *const u8,
            .map_err(|e| format!("parquet_on_settings_update bf_enabled_names: {}", e))?;
    file_ptr: *const u8,
    // Per-input live-docs bitsets (parallel to input_ptrs) in Lucene `FixedBitSet#getBits()`
            let bytes = cb.as_bytes();
#[no_mangle]
        .get(index_name)
        arrow::datatypes::DataType::Float64 => {
            Some(v)
    prefix_len: i64,
    row_group_max_rows: i64,
            None
        } else {
    }
    type_compression_name_ptrs: *const *const u8,
    type_encoding_count: i64,
    )
            .collect();
#[ffm_safe]
/// Update native settings for an index. Nullable fields use sentinel -1 for "not set".
            col_name,
            }
    num_rows_out: *mut i64,
            let nf = s.nulls_first.clone();
    *out_gen_offsets_ptr = Box::into_raw(offsets) as *mut i32 as i64;
        }
    let reader =
            .enumerate()
    if count == 0 || vals.is_null() {
        ));
    writer_generation: i64,
        .map_err(|e| format!("parquet_cleanup_writer: {}", e))?
        merge::merge_sorted(
    out_flush_and_sort_chunk_time_millis: *mut i64,
        }
    if count == 0 || lens.is_null() {
    *out_gen_count = count as i64;
/// Reads a parquet file and returns its contents as a JSON string.
    fn live_bits_array_from_raw_zero_length_entry_yields_none() {
    #[test]
    }
/// Set write pool limit. Called by Java rebalancer via FFM.
            for i in 0..elements.len() {
/// can assert LIST values survive the write/merge path: a null list row stays JSON
    for batch_result in reader {
    .map_err(|e| format!("{}", e))?;
            json.push(',');
pub unsafe extern "C" fn parquet_read_as_json(
/*
                .join(","),
    for i in 0..rg.num_columns() {
    }
        Err(e) => Err(e.to_string()),
//! call `native_error_message`/`native_error_free`).
        let batch = batch_result.map_err(|e| format!("Read error: {}", e))?;
            map.entry(name)
        .with_batch_size(8192)
    )
use crate::writer::{NativeParquetWriter, SETTINGS_STORE};
pub extern "C" fn parquet_init_memory_pools(write_limit: i64, merge_limit: i64) {
    )
    }
        .map_err(|e| e.to_string())
    *out_mapping_ptr = Box::into_raw(mapping) as *mut i64 as i64;
        assert_eq!(result.len(), 1);
            let bytes = cb.as_bytes();
pub unsafe extern "C" fn parquet_free_merge_result(
    type_compression_value_lens: *const i64,
    if mapping_ptr != 0 && mapping_len > 0 {
pub unsafe extern "C" fn parquet_remove_settings(
            out.push(None);
    out_gen_keys_ptr: *mut i64,
// ---------------------------------------------------------------------------
    crc32_out: *mut i64,
            output_writer_generation,
    // ===== live_bits_array_from_raw =====
                *num_row_groups_out = result.metadata.num_row_groups() as i64;
                .unwrap();
    fn opt_u64(v: i64) -> Option<u64> {
    } else {
    };
            mapping_ptr as *mut i64,
        type_bf_enabled_count,
            .zip(field_compressions.into_iter())
pub extern "C" fn parquet_set_merge_pool_limit(new_limit: i64) {
    let arr: [i64; 17] = [
        ));
    if out_len < 17 {
        }
        if v < 0.0 {
                    array_value_to_json(col.as_ref(), row_idx),
        s.tokio_active_tasks,
        return vec![];
    };
    let stats = crate::memory::get_stats();
                .iter()
        }
        assert!(result[2].is_some());
        );
    *out_flush_and_sort_chunk_time_millis = result.flush_and_sort_chunk_time_millis;
            Some(map)
    )
        let map: std::collections::HashMap<_, _> = type_encoding_names
    )
    let file = File::open(&filename).map_err(|e| format!("Failed to open file: {}", e))?;
    if !num_rows_out.is_null() {
            let mut obj = serde_json::Map::new();
    }
    if ptr.is_null() {
    let filename = str_from_raw(file_ptr, file_len)
        let map: std::collections::HashMap<_, _> = type_compression_names
    let index_name = str_from_raw(index_name_ptr, index_name_len)
}
        assert!(result[0].is_none());
        nulls_first,
        writer_generation,
        .map_err(|e| format!("parquet_create_writer file: {}", e))?
}
                .downcast_ref::<arrow::array::Int64Array>()
            }
    ];
    file_len: i64,
    index_name_len: i64,
    ptrs: *const *const i64,
    let result = if sort_cols.is_empty() {
}
/// Returns 0 on success, negative error pointer on failure (per FFM convention).
        );
        page_row_limit: opt_usize(page_row_limit),
            serde_json::Value::Number(arr.value(row_idx).into())
        s.rayon_merge_tasks_completed,
    }
        .map_err(|e| format!("Failed to open {}: {}", filename, e))?;
        page_size_bytes: opt_usize(page_size_bytes),
        str_array_from_raw(bf_enabled_name_ptrs, bf_enabled_name_lens, bf_enabled_count)
    if let Some(cb) = fm.created_by() {
// ---------------------------------------------------------------------------
            let val = *bf_enabled_vals.add(i) != 0;
    let mut live_docs = live_bits_array_from_raw(live_bits_ptrs, live_bits_lens, live_bits_count);
        assert_eq!(result.len(), 1);
    }
) -> i64 {
#[ffm_safe]
pub unsafe extern "C" fn parquet_get_file_metadata(
    file_ptr: *const u8,
    if !out_len.is_null() {
pub unsafe extern "C" fn parquet_merge_files(
    #[test]
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
        }
            result[1].is_none(),
//!
            let n = bytes.len().min(created_by_buf_len as usize);
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
        merge_rayon_threads: opt_usize(merge_rayon_threads),
    type_bf_enabled_count: i64,
        type_bf_fpp_name_ptrs,
    }
pub extern "C" fn parquet_register_overcommit_callbacks(
        field_compression_name_lens,
    gen_count: i64,
        bloom_filter_ndv: opt_u64(bloom_filter_ndv),
    }
            if !sort_perm_ptr_out.is_null() && !sort_perm_len_out.is_null() {
                .as_any()
        ));
            mapping_len as usize,
    sort_count: i64,
    type_encoding_value_ptrs: *const *const u8,
        s.tokio_workers_busy_millis_total,
    output_len: i64,
        s.tokio_blocking_queue_depth,
    let fm = metadata.file_metadata();
    file_len: i64,
            let rf = s.reverse_sorts.clone();
    out_row_id_mapping_max: *mut i64,
    let json_str =
    created_by_len_out: *mut i64,
/// Get pool stats: writes 6 i64s to out_buf.
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
) -> i64 {
        let decoded = result[0].as_ref().expect("expected Some");
    };
    mapping_len: i64,
            }
        .map_err(|e| format!("parquet_remove_settings: {}", e))?
                *num_rows_out = fm.num_rows();
}
        // Java released write mapping — free from pool
        type_encoding_count,
        .to_string();
        )
        .map_err(|e| format!("Failed to read parquet: {}", e))?;
        type_compression_value_ptrs,
            if !sc.is_empty() && rf.is_empty() {
#[no_mangle]
            &input_files,
) -> i64 {
        type_encoding_value_lens,
    } else if !created_by_len_out.is_null() {
        } else {
        let _ = Box::from_raw(slice::from_raw_parts_mut(gen_sizes_ptr as *mut i32, n));
    out_gen_sizes_ptr: *mut i64,
                .downcast_ref::<arrow::array::Float64Array>()
            &live_docs,
        let result = unsafe { live_bits_array_from_raw(ptrs.as_ptr(), lens.as_ptr(), 1) };
#[no_mangle]
    bf_enabled_name_lens: *const i64,
        arrow::datatypes::DataType::Int32 => {
/// Initialize write and merge memory pool counters.
mod tests {
    .map_err(|e| format!("parquet_on_settings_update type_bf_enabled_names: {}", e))?;
 *
                .map(|e| format!("\"{}\"", e))
/// Returns a JSON string with per-column encoding and compression metadata.
/// `decider(requested_bytes) -> 1|0` decides whether a full pool may over-commit; `releaser(bytes)`
        }
    type_bf_enabled_name_ptrs: *const *const u8,
            }
        s.rayon_merge_tasks_failed,
        sort_columns,
                });
    out_flush_and_sort_chunk_count: *mut i64,
    index_name_ptr: *const u8,
    };
/// Decode a parallel (pointers, lengths, count) triple into `Vec<String>`.
    fn opt_i32(v: i64) -> Option<i32> {
    field_name_lens: *const i64,
        } else {
// Settings management
}
    NativeParquetWriter::write_data(filename, array_address, schema_address)
        if map.is_empty() {
    type_bf_enabled_vals: *const i64,
                .unwrap();
    out_buf_len: i64,
//! Return convention: `>= 0` success, `< 0` error pointer (negate to get ptr,
        s.rayon_merge_tasks_submitted,
        return Err(format!(
        field_compression_value_ptrs,
        s.rayon_merge_wall_millis,
        *num_rows_out = fm.num_rows();
    let bytes = json.as_bytes();
    .map_err(|e| format!("parquet_on_settings_update field_compression_names: {}", e))?;
    }
        .map(|_| 0)
    use arrow::array::Array;
    field_compression_value_ptrs: *const *const u8,
    // Parse type-level bloom filter arrays
        }
    index_name_ptr: *const u8,
}
    page_size_bytes: i64,
        s.tokio_num_workers,
    num_row_groups_out: *mut i64,
) -> Vec<Option<Vec<u64>>> {
        let compression = format!("{:?}", col.compression());
        if map.is_empty() {
    .map_err(|e| e.to_string())
    *out_len = bytes.len() as i64;
// ---------------------------------------------------------------------------
    }
        .map_err(|e| format!("parquet_on_settings_update field_names: {}", e))?;
    let config = NativeSettings {
        dict_size_bytes: opt_usize(dict_size_bytes),
    lens: *const i64,
    releaser: native_bridge_common::memory_pool::OverCommitReleaser,
    if bytes.len() > buf_capacity as usize {
    created_by_buf: *mut u8,
}
    let file = std::fs::File::open(&filename)
        )
/// preserving the null-vs-empty-vs-null-child distinctions the merge must not lose.
            .enumerate()
    file_len: i64,
        s.rayon_merge_tasks_started,
    SETTINGS_STORE.remove(&index_name);
    fn opt_f64(v: f64) -> Option<f64> {
            );
        type_bf_fpp_count,
        type_compression_count,
    fn opt_bool(v: i64) -> Option<bool> {
    };
}
unsafe fn str_array_from_raw(
            Some(v as u64)
) -> i64 {
        // i64 0xFFFF_FFFF_FFFF_FFFE reinterpreted as u64 ⇒ 0xFFFF_FFFF_FFFF_FFFE
        out.push(Some(slice.to_vec()));
// Merge
    let mut rows: Vec<serde_json::Value> = Vec::new();
    Ok(0)
    field_encoding_lens: *const i64,
            .map(|(i, name)| (name, *type_bf_enabled_vals.add(i) != 0))
        json.push_str(&format!(
    {
                let col = batch.column(col_idx);
        if map.is_empty() {
        type_compression_name_lens,
        assert_eq!(decoded[0], 0xFFFF_FFFF_FFFF_FFFEu64);
        index_name: Some(index_name.clone()),
}
        if map.is_empty() {
        assert_eq!(decoded.len(), 3);
/// Each entry corresponds to one input file. Null pointer or zero length ⇒ "all alive".
}
// Native runtime metrics
    )
        }
        s.tokio_local_queue_depth_total,
            (vec![], vec![], vec![], vec![])
    type_bf_enabled_name_lens: *const i64,
    type_bf_fpp_name_ptrs: *const *const u8,
                .or_insert(FieldConfig {
            let arr = col
    index_name_len: i64,
    let mapping_bytes = mapping.len() * std::mem::size_of::<i64>();
    buf_capacity: i64,
        .to_string();
                    crate::memory::write_pool().grow(mapping_bytes);
// ---------------------------------------------------------------------------
                    *sort_perm_len_out = 0;
#[ffm_safe]
    index_name_len: i64,
        let result = unsafe { live_bits_array_from_raw(invalid_ptrs, std::ptr::null(), 1) };
        if v < 0 {
            mapping_len as usize,
    std::ptr::copy_nonoverlapping(bytes.as_ptr(), out_buf, bytes.len());
            .into_iter()
            None
        for (name, compression) in field_compression_names
    let bytes = json_str.as_bytes();
    if let Some(cb) = fm.created_by() {
        if l <= 0 || ptrs.is_null() {
    fn live_bits_array_from_raw_decodes_single_input() {
    .map_err(|e| format!("parquet_on_settings_update field_compressions: {}", e))?;
    .map(|_| 0)
/// Collect a snapshot of native runtime stats for the parquet merge path.
        assert_eq!(result.len(), 3);
use std::slice;
        type_bloom_filter_fpp,
    let index_name = str_from_raw(index_name_ptr, index_name_len)
    field_compression_name_lens: *const i64,
/// is called with the granted byte count when the reservation is released. Because all native
        }
#[no_mangle]
    if ptrs.is_null() || lens.is_null() {
        }
) -> i64 {
/// Decode a parallel array of (pointer, length) pairs into a vector of owned `u64` bitsets.
    let filename = str_from_raw(file_ptr, file_len)
 * The OpenSearch Contributors require contributions made to
) -> i64 {
        {
    let type_bloom_filter_fpp: Option<std::collections::HashMap<String, f64>> = {
    #[test]
        None => {
            .zip(type_encodings.into_iter())
        let invalid_ptrs: *const *const i64 = &invalid_ptr;
) {
    fn live_bits_array_from_raw_negative_length_entry_yields_none() {
unsafe fn bool_array_from_raw(vals: *const i64, count: i64) -> Vec<bool> {
            rows.push(serde_json::Value::Object(obj));
    NativeParquetWriter::get_filtered_writer_memory_usage(prefix).unwrap_or(0) as i64
                });
    created_by_buf: *mut u8,
            crate::log_info!("parquet_merge_files: no settings found for index '{}', proceeding with unsorted merge", index_name);
        *crc32_out = result.crc32 as i64;
        *version_out = fm.version();
    type_bf_ndv_name_lens: *const i64,
            let arr = col
        }
    };
pub extern "C" fn parquet_set_write_pool_limit(new_limit: i64) {
                .as_any()
        std::ptr::copy_nonoverlapping(bytes.as_ptr(), out_buf, n);
pub unsafe extern "C" fn parquet_collect_runtime_metrics(out_buf: *mut i64, out_len: i64) -> i64 {
        .to_string();
    crate::memory::set_merge_limit(new_limit as usize);
    }
    }
                .unwrap();
        return Ok(0);
                .as_any()
        )
        type_bf_fpp_name_lens,
}
// ---------------------------------------------------------------------------
    out_gen_count: *mut i64,
        .map_err(|e| format!("parquet_merge_files inputs: {}", e))?;
        let p = *ptrs.add(i);
        let ptrs: Vec<*const i64> = vec![std::ptr::null()];
    use std::fs::File;
    let type_compression_names = str_array_from_raw(
pub unsafe extern "C" fn parquet_cleanup_writer(file_ptr: *const u8, file_len: i64) -> i64 {
    let fm = result.metadata.file_metadata();
            None
                .unwrap();
    let offsets = result.gen_offsets.into_boxed_slice();
        let n = bytes.len().min(out_buf_len as usize);
                    ..Default::default()
        }
use crate::field_config::FieldConfig;
///
///
/// Format: {"column_name": {"encodings": ["PLAIN", "RLE_DICTIONARY"], "compression": "LZ4_RAW"}, ...}
        *out_len = n as i64;
            if !version_out.is_null() {
    }
        Ok(None) => Ok(1),
        let ptrs: Vec<*const i64> = vec![bits_a.as_ptr(), std::ptr::null(), bits_c.as_ptr()];
    created_by_buf: *mut u8,
        *num_rows_out = fm.num_rows();
    json.push('}');
#[ffm_safe]
    if gen_sizes_ptr != 0 && n > 0 {
    sort_lens: *const i64,
                    }
    sort_in_memory_threshold_bytes: i64,
        }
    #[test]
        .unwrap_or("")
        compression_type,
/// Register the over-commit decision callbacks (FFM upcall stubs from the Java allocator).
#[no_mangle]
            output_path,
    // Decode live-docs; pad with None to cover every input file.
///
    }
    let s = crate::merge::metrics::collect();
    }
        if i > 0 {
            bytes.len(),
    type_bf_fpp_name_lens: *const i64,
    }
                .and_modify(|fc| fc.bloom_filter_enabled = Some(val))
#[no_mangle]
    created_by_buf_len: i64,
        .map_err(|e| format!("parquet_get_file_metadata: {}", e))?
            }
    file_ptr: *const u8,
    type_compression_value_ptrs: *const *const u8,
    index_name_len: i64,
    bloom_filter_fpp: f64,
    )
    .map_err(|e| format!("parquet_on_settings_update type_compression_names: {}", e))?;
    let nulls_first = bool_array_from_raw(nulls_first_vals, nulls_first_count);
            continue;
    prefix_ptr: *const u8,
    gen_offsets_ptr: i64,
        let l = *lens.add(i);
    let keys = result.gen_keys.into_boxed_slice();
            out.push(None);
// ---------------------------------------------------------------------------
        *out_buf.add(i) = *val as i64;
        return vec![];
    let index_name = str_from_raw(index_name_ptr, index_name_len)
            output_path,
            Some(map)
}
        Ok(Some(result)) => {
                crate::log_info!("parquet_merge_files: sort columns present but reverse_sorts is empty for index '{}', defaulting to ascending", index_name);
}
                    *sort_perm_len_out = len as i64;
    fn live_bits_array_from_raw_null_lens_returns_empty() {
        let decoded = result[0].as_ref().expect("expected non-None entry");
        if v < 0 {
    let compression_type = if compression_type_ptr.is_null() || compression_type_len < 0 {
            let n = bytes.len().min(created_by_buf_len as usize);
                .and_modify(|fc| fc.compression_type = Some(compression.clone()))
    #[test]
    fn opt_usize(v: i64) -> Option<usize> {
    if !version_out.is_null() {
        arrow::datatypes::DataType::Int64 => {
            *out_len = n as i64;
    let type_encodings = str_array_from_raw(
        ));
    }
    let prefix = str_from_raw(prefix_ptr, prefix_len)
    compression_level: i64,
        let ptrs: Vec<*const i64> = vec![bits.as_ptr()];
        }
// ---------------------------------------------------------------------------
            .into_iter()
            let arr = col
    let field_compressions = str_array_from_raw(
        .to_string();
#[no_mangle]
    page_row_limit: i64,
    *out_row_id_mapping_max = result.row_id_mapping_max;
                .unwrap();
/// Returns 0 with metadata in out-pointers, 1 if no writer found.
            "parquet_collect_runtime_metrics: out_len {} < 17",
/// This lets list-typed columns round-trip through `parquet_read_as_json` so tests
    SETTINGS_STORE.insert(index_name, config);
    match NativeParquetWriter::finalize_writer(filename) {
// ---------------------------------------------------------------------------
        .map_err(|e| format!("Failed to build reader: {}", e))?;
        crate::memory::write_pool().shrink(mapping_bytes);
            serde_json::Value::Bool(arr.value(row_idx))
        bloom_filter_fpp: opt_f64(bloom_filter_fpp),
            .collect();
            if !created_by_len_out.is_null() {
            serde_json::json!(arr.value(row_idx))
// ---------------------------------------------------------------------------
    let output_path = str_from_raw(output_ptr, output_len)
    field_compression_count: i64,
    // Write row-ID mapping into out-pointers as heap-allocated arrays.
        .to_string();
        return Err(format!(
        }
    }
pub unsafe extern "C" fn parquet_write(
        field_compression_value_lens,
    *out_flush_and_sort_chunk_count = result.flush_and_sort_chunk_count;
/// `null`, an empty list stays `[]`, and a null child element stays JSON `null`,
        type_encoding_value_ptrs,
    input_ptrs: *const *const u8,
    file_len: i64,
        type_compression_count,
                .as_any()
    for i in 0..n {
        let ptrs: Vec<*const i64> = vec![ptr];
            map.entry(name)
                .downcast_ref::<arrow::array::Int32Array>()
    let type_compression_configs: Option<std::collections::HashMap<String, String>> = {
        arrow::datatypes::DataType::Utf8 => {
    }
        .to_string();
    }
    mapping_ptr: i64,
        type_compression_value_lens,
        let p = *ptrs.add(i);
pub unsafe extern "C" fn parquet_finalize_writer(
        _ => serde_json::Value::String(format!("<unsupported:{}>", col.data_type())),
use crate::native_settings::NativeSettings;
    *out_gen_keys_ptr = Box::into_raw(keys) as *mut i64 as i64;
/// operation does not survive as a stale entry and block recovery's re-`create_writer`.
#[ffm_safe]
pub unsafe extern "C" fn parquet_get_column_metadata(
    out
    str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))
    out_buf: *mut u8,
        } else {
    if gen_offsets_ptr != 0 && n > 0 {
/// Serializes a single Arrow array cell to JSON, recursing into LIST children.
                    let len = perm.len();
    let builder = parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder::try_new(file)
    let type_bf_fpp_names = str_array_from_raw(
            let arr = col
        *num_row_groups_out = metadata.num_row_groups() as i64;
    live_bits_ptrs: *const *const i64,
        s.rayon_merge_tasks_panicked,
}
    version_out: *mut i32,
    )
        return Err("null string pointer".to_string());
    let type_bf_enabled_names = str_array_from_raw(
        let _ = Box::from_raw(slice::from_raw_parts_mut(
    Ok(0)
    let mapping = result.mapping.into_boxed_slice();
        let schema = batch.schema();
            &sort_cols,
#[cfg(test)]
    created_by_len_out: *mut i64,
                .as_any()
        .map_err(|e| format!("parquet_write: {}", e))?
            None
    }
        let lens: Vec<i64> = vec![bits.len() as i64];
    Ok(0)
                if let Some(perm) = result.row_id_mapping {
    crate::memory::merge_pool().grow(mapping_bytes);
    compression_type_len: i64,
            &live_docs,
        let lens: Vec<i64> = vec![-1];
        schema_address,
    match col.data_type() {
                    if !created_by_len_out.is_null() {
    let n = gen_count as usize;
#[no_mangle]
}
    let mut json = String::from("{");
        max_sort_modes,
    // layout. Pass `live_bits_count == 0`, or per-file length 0, for "all alive".
        .to_string();
use native_bridge_common::ffm_safe;
            // Return sort permutation if present
fn array_value_to_json(col: &dyn arrow::array::Array, row_idx: usize) -> serde_json::Value {
    let type_bf_ndv_names = str_array_from_raw(
            }
            std::ptr::copy_nonoverlapping(bytes.as_ptr(), created_by_buf, n);
    created_by_buf_len: i64,
        if map.is_empty() {
#[no_mangle]
    *out_mapping_len = mapping.len() as i64;
    if gen_keys_ptr != 0 && n > 0 {
        } else {
/// The JSON bytes are written into `out_buf`, actual length into `out_len`.
    bf_enabled_count: i64,
            .map(|(i, name)| (name, *type_bf_fpp_vals.add(i)))
    let bytes = slice::from_raw_parts(ptr, len as usize);
    if live_docs.len() < input_files.len() {
            Some(v as i32)
    let field_encodings = str_array_from_raw(field_encoding_ptrs, field_encoding_lens, field_count)
            &nulls_first_flags,
#[no_mangle]
                crate::log_info!("parquet_merge_files: sort columns present but nulls_first is empty for index '{}', defaulting to nulls last", index_name);
    num_rows_out: *mut i64,
    if col.is_null(row_idx) {
                obj.insert(
}
    if len < 0 {
            output_writer_generation,
    input_count: i64,
        *created_by_len_out = -1;
            let mut items = Vec::with_capacity(elements.len());
    count: i64,
            }
    Ok(out)
// Memory pool management (Phase 1 stubs)
    let type_bloom_filter_enabled: Option<std::collections::HashMap<String, bool>> = {
// ---------------------------------------------------------------------------
    }
        *created_by_len_out = -1;
        let bits_a: Vec<i64> = vec![0x0000_0000_0000_000Fi64];
}
        row_group_max_rows: opt_usize(row_group_max_rows),
        assert_eq!(decoded[2], 0x0123_4567u64);
                    let bytes = cb.as_bytes();
    };
            None
// Tests
/// Set merge pool limit. Called by Java rebalancer via FFM.
    }
#[no_mangle]
    row_group_max_bytes: i64,
    let type_encoding_configs: Option<std::collections::HashMap<String, String>> = {
    }
        filename,
        row_group_max_bytes: opt_usize(row_group_max_bytes),
#[ffm_safe]
            Some(map)
    merge_rayon_threads: i64,
        .map_err(|e| format!("parquet_on_settings_update index_name: {}", e))?
pub unsafe extern "C" fn parquet_on_settings_update(
        field_compression_name_ptrs,
        type_compression_configs,
                .downcast_ref::<arrow::array::StringArray>()
    let sort_columns = str_array_from_raw(sort_ptrs, sort_lens, sort_count)
    let filename = str_from_raw(file_ptr, file_len)
    let type_compressions = str_array_from_raw(
        } else {
    type_bf_fpp_count: i64,
) -> Result<Vec<String>, String> {
            index_name,
            result[0].is_none(),
                .to_string(),
use std::str;
    file_ptr: *const u8,
            let arr = col
/// Reads from the first row group.
#[no_mangle]
            "JSON output ({} bytes) exceeds buffer capacity ({})",
        out.push(str_from_raw(p, l)?.to_string());
        .to_string();
///
    fn live_bits_array_from_raw_null_inner_ptr_yields_none() {
    out_mapping_ptr: *mut i64,
    use parquet::file::reader::{FileReader, SerializedFileReader};
    let reverse_sorts = bool_array_from_raw(reverse_vals, reverse_count);
pub unsafe extern "C" fn parquet_free_row_id_mapping(mapping_ptr: i64, mapping_len: i64) {
// Sort permutation memory management
        compression_level: opt_i32(compression_level),
        .to_string();
    use super::*;
    output_ptr: *const u8,
                name,
    live_bits_count: i64,
            if !crc32_out.is_null() {
    if !num_row_groups_out.is_null() {
                    *sort_perm_ptr_out = 0;
    let type_encoding_names = str_array_from_raw(
    let field_names = str_array_from_raw(field_name_ptrs, field_name_lens, field_count)
                    *sort_perm_ptr_out = Box::into_raw(boxed) as *mut i64 as i64;
    version_out: *mut i32,
                if !created_by_buf.is_null() && created_by_buf_len > 0 {
        }
        let mut map = std::collections::HashMap::new();
    count: i64,
/// Returns 0 on success.
}
        let col = rg.column(i);
        let col_name = col.column_path().string();
        index_name,
    bloom_filter_enabled: i64,
    // Per-merge stats out-pointers — callers always pass valid pointers (matches existing convention).
        arrow::datatypes::DataType::List(_) => {
            None
        type_bf_ndv_name_lens,
                    bloom_filter_enabled: Some(val),
    }
    type_encoding_name_ptrs: *const *const u8,
        merge::merge_unsorted(
    decider: native_bridge_common::memory_pool::OverCommitDecider,
    *out_gen_sizes_ptr = Box::into_raw(sizes) as *mut i32 as i64;
    .map_err(|e| format!("parquet_on_settings_update type_compressions: {}", e))?;
    let filename = str_from_raw(file_ptr, file_len)
    file_len: i64,
    std::ptr::copy_nonoverlapping(arr.as_ptr(), out_buf, 17);
            }
        s.tokio_polls_count_total,
        assert_eq!(decoded[0], 1u64);
        // Java released merge mapping — free from pool
    type_encoding_value_lens: *const i64,
                    let n = bytes.len().min(created_by_buf_len as usize);
    NativeParquetWriter::cleanup_writer(&filename)
    std::ptr::copy_nonoverlapping(bytes.as_ptr(), out_buf, n);
    out_len: *mut i64,
        if !created_by_buf.is_null() && created_by_buf_len > 0 {
    #[test]
        return Ok(vec![]);
        let mapping_bytes = mapping_len as usize * std::mem::size_of::<i64>();
        sort_in_memory_threshold_bytes: opt_u64(sort_in_memory_threshold_bytes),
        type_encoding_count,
            }
    num_rows_out: *mut i64,
        assert_eq!(result[2].as_ref().unwrap()[0], 0x00FF_FF00_0000_0000u64);
            continue;
#[no_mangle]
// ---------------------------------------------------------------------------
    Ok(0)
            None
