    )
            index_name: Some(index.to_string()),
                vec!["id".to_string()]
    for handle in handles {
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
/// - "score" (Float64): no index or cluster config → gets global LZ4_RAW
    assert!(file_path.metadata().unwrap().len() > 0);
    );
        });
            let file_path = temp_dir_path.join(format!("concurrent_{}.parquet", i));
        },
    use arrow::ffi::FFI_ArrowSchema;
        vec!["id".to_string()],
    SETTINGS_STORE.insert(
            let reverse = if use_sort { vec![false] } else { vec![] };
    let metadata = result.unwrap().unwrap();
    );
    let mut type_compression = HashMap::new();
                if NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr)
    assert_eq!(success_count.load(Ordering::SeqCst), thread_count);
    let (_tmp, path) = get_temp_file_path("idx_overrides_cluster_comp.parquet");
    }
        let names: Vec<Option<&str>> = batch_ids.iter().map(|_| Some("x")).collect();
            }
    for handle in handles {
    cleanup_ffi_data(ap, sp);
        let handle = thread::spawn(move || {
/// Cluster-level type compression is applied when no index-level field config exists.
        },
    let success_count = Arc::new(AtomicUsize::new(0));
        let _ = Box::from_raw(schema_ptr as *mut FFI_ArrowSchema);
                vec![],
        NativeSettings {
fn test_concurrent_writer_creation() {
        0,
                0,
    assert_eq!(success_count.load(Ordering::SeqCst), 5);
}
            field_configs: Some(field_configs),
}
                cleanup_ffi_data(ap, sp);
            cleanup_ffi_data(array_ptr, data_schema_ptr);
    filename: &str,
            if NativeParquetWriter::create_writer(
    let success_count = Arc::new(AtomicUsize::new(0));
            {
    SETTINGS_STORE.remove(index);
        read_metadata.file_metadata().num_rows(),
            cleanup_ffi_schema(schema_ptr);
    assert_eq!(success_count.load(Ordering::SeqCst), thread_count);
    // "id" (Int32) has explicit index-level compression
    let meta = reader.metadata();
            let (_schema, schema_ptr) = create_test_ffi_schema();
    let ids = read_parquet_file_sorted_ids(&filename);
    assert!(
        "test-index".to_string(),
    assert_eq!(
use std::thread;
use parquet::file::reader::{FileReader, SerializedFileReader};
        handle.join().unwrap();
            if NativeParquetWriter::write_data(filename, array_ptr, data_schema_ptr).is_ok() {
    );
 * compatible open source license.
            }
        Compression::LZ4_RAW
    );
 */
                    }
                    }
    // "id" is Int32 → should get DELTA_BINARY_PACKED from cluster type config
            index_name: Some(index.to_string()),
    type_encoding.insert("int32".to_string(), "DELTA_BINARY_PACKED".to_string());
        "id".to_string(),
                let write_ok = NativeParquetWriter::write_data(filename.clone(), ap, sp).is_ok();
            .is_ok()
// ===== Arrow IPC staging integration tests =====
    field_configs.insert(
    close_writer_and_cleanup_schema(&filename, schema_ptr);
        ],
    let success_count = Arc::new(AtomicUsize::new(0));
#[test]
    assert!(matches!(
                    if let Ok(Some(metadata)) =
}
        read_column_compression(&path, "id"),
                vec![false],
    );
            if NativeParquetWriter::finalize_writer(filename).is_ok() {
        Compression::SNAPPY
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
#[test]
#[test]
            )
        vec![],
/// Index-level field compression is applied to the named column.
        let handle = thread::spawn(move || {
fn test_concurrent_writes_different_files() {
            index_name: Some(index.to_string()),
    assert!(matches!(
        }
        let col = rg.column(i);
                vec![false],
                            let ids = read_parquet_file_sorted_ids(&filename);
        handle.join().unwrap();
    ));
            index_name: Some(index.to_string()),
    assert!(result.is_ok());
                }
            .is_ok()
) -> (std::sync::Arc<arrow::datatypes::Schema>, i64) {
    panic!("column '{}' not found in {}", col_name, path);
                let (ap, sp) = create_test_ffi_data_with_ids(
fn create_writer_and_assert_success_for_index(
#[test]
        NativeSettings {
        let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
        handles.push(handle);
        handle.join().unwrap();
        index.to_string(),
    write_three_col_data(&path);
    for _ in 0..5 {
    let mut field_configs = HashMap::new();
    cleanup_ffi_data(ap, sp);
    let (ap, sp) = create_test_ffi_data().unwrap();
            {
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
        Compression::SNAPPY
                                success_count.fetch_add(1, Ordering::SeqCst);
            encoding_type: Some("PLAIN".to_string()),
    cleanup_ffi_schema(schema_ptr);
            ..Default::default()
            let filename = file_path.to_string_lossy().to_string();
        let handle = thread::spawn(move || {
                filename.clone(),
    cleanup_ffi_data(ap, sp);
        });
        "expected DELTA_BINARY_PACKED in {:?}",
    );
    let array_data = struct_array.into_data();
    assert!(matches!(
    let (_schema, schema_ptr) = create_test_ffi_schema();
    NativeParquetWriter::write_data(filename.to_string(), array_ptr, schema_ptr).unwrap();
                "test-index".to_string(),
        NativeSettings {
        });
                                success_count.fetch_add(1, Ordering::SeqCst);
                "test-index".to_string(),
    // "id" is Int32 → should get SNAPPY from cluster type config
    let mut type_compression = HashMap::new();
            )
        vec![],
    let temp_dir = tempdir().unwrap();
    SETTINGS_STORE.insert(
            cleanup_ffi_schema(schema_ptr);
    let schema = std::sync::Arc::new(Schema::new(vec![
fn test_complete_writer_lifecycle() {
                schema_ptr,
                0,
use std::sync::Arc;
        Compression::UNCOMPRESSED
            compression_type: Some("UNCOMPRESSED".to_string()),
        close_writer_and_cleanup_schema(filename, schema_ptrs[i]);
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
    let rg = meta.row_group(0);
        },
    ));
                vec![],
        handle.join().unwrap();
    let mut handles = vec![];
    cleanup_ffi_schema(schema_ptr);
            .is_ok()
    ));
    ]));
    }
    );
fn test_cluster_level_type_compression_fallback() {
    for i in 0..rg.num_columns() {
    let index = "test_index_overrides_cluster_compression";
            let (_schema, schema_ptr) = create_test_ffi_schema();
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
    );
        schema.clone(),
        read_column_compression(&path, "name"),
    let thread_count = 8;
    .expect("create_writer failed");
    panic!("column '{}' not found in {}", col_name, path);
    }
#[test]
            };
#[test]
            index_name: Some(index.to_string()),
}
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 6);
        },
    let (_temp_dir, filename) = get_temp_file_path("ipc_integ_sorted.parquet");
                schema_ptr,
                sort_cols,
            type_encoding_configs: Some(type_encoding),
        NativeSettings {
use tempfile::tempdir;
                let write_ok = NativeParquetWriter::write_data(filename.clone(), ap, sp).is_ok();
        handles.push(handle);
    );
            ..Default::default()
use parquet::basic::{Compression, Encoding};
                    if let Ok(Some(metadata)) =
    let mut handles = vec![];
/*
        Field::new("score", DataType::Float64, true),
                vec![],
            )
    SETTINGS_STORE.insert(
    let schema = meta.file_metadata().schema_descr();
 * this file be licensed under the Apache-2.0 license or a
    for i in 0..thread_count {
                reverse,
    let (_temp_dir, filename) = get_temp_file_path("complete_workflow.parquet");
        },
    let (_tmp, path) = get_temp_file_path("idx_overrides_cluster_enc.parquet");
    )
        Compression::UNCOMPRESSED
    filename: &str,
fn test_concurrent_writes_same_file() {
        encodings
        handles.push(handle);
        "id".to_string(),
    type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
        cleanup_ffi_data(ap, sp);
    let mut type_encoding = HashMap::new();
    let thread_count = 6;
    SETTINGS_STORE.insert(
                            }
        },
    assert_eq!(success_count.load(Ordering::SeqCst), 10);
            type_compression_configs: Some(type_compression),
    }
}
        filename.to_string(),
            field_configs: Some(field_configs),
    assert_eq!(success_count.load(Ordering::SeqCst), 1);
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        NativeSettings {
                    {
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
            .join(format!("concurrent_write_{}.parquet", i));
    let mut handles = vec![];
    let read_metadata = NativeParquetWriter::get_file_metadata(filename.clone()).unwrap();
#[test]
    for i in 0..10 {
fn test_cluster_level_type_encoding_fallback() {
                let _ = NativeParquetWriter::finalize_writer(filename);
                schema_ptr,
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
fn test_three_tier_compression_fallback() {
    use arrow::record_batch::RecordBatch;
                            success_count.fetch_add(1, Ordering::SeqCst);
    );
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
                vec![]
}
 * The OpenSearch Contributors require contributions made to
    for i in 0..thread_count {
    let result = NativeParquetWriter::finalize_writer(filename.clone());
        let success_count = Arc::clone(&success_count);
                let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    cleanup_ffi_schema(schema_ptr);
        let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 9); // 3 batches × 3 rows
    assert!(metadata.metadata.file_metadata().version() > 0);
                                vec![10, 20, 30]
        let temp_dir_path = temp_dir.path().to_path_buf();
                    }
    let encodings = read_column_encoding(&path, "id");
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
                    vec![Some("C"), Some("A"), Some("B")],
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
    for handle in handles {
    for i in 0..file_count {
    let encodings = read_column_encoding(&path, "id");
        vec![],
            index_name: Some(index.to_string()),
        "id".to_string(),
    type_compression.insert("int32".to_string(), "SNAPPY".to_string());
        NativeSettings {
    let (ap, sp) = create_test_ffi_data().unwrap();
    }
        Field::new("name", DataType::Utf8, true),
        schema_ptr,
    let success_count = Arc::new(AtomicUsize::new(0));
        }
                        NativeParquetWriter::finalize_writer(filename.clone())
        let handle = thread::spawn(move || {
#[test]
            .path()
        !encodings.contains(&Encoding::DELTA_BINARY_PACKED),
    let (_tmp, path) = get_temp_file_path("idx_field_comp.parquet");
        metadata.metadata.file_metadata().version()
        });
        let _ = Box::from_raw(array_ptr as *mut FFI_ArrowArray);
/// Helper: create a writer for a specific index name (not the default "test-index").
                }
    SETTINGS_STORE.remove(index);
                cleanup_ffi_data(array_ptr, data_schema_ptr);
        index.to_string(),
fn read_column_encoding(path: &str, col_name: &str) -> Vec<Encoding> {
fn write_three_col_data(filename: &str) {
    for handle in handles {
        Field::new("id", DataType::Int32, false),
/// Different columns get different configs: one from index level, one from cluster level.
        vec![],
    let reader = SerializedFileReader::new(File::open(path).unwrap()).unwrap();
/// Cluster-level type encoding is applied when no index-level field config exists.
    }
            type_encoding_configs: Some(type_encoding),
    }
        schema_ptr,
            let file_path = temp_dir_path.join(format!("lifecycle_{}.parquet", i));
    let temp_dir = tempdir().unwrap();
#[test]
    }
                        if metadata.metadata.file_metadata().num_rows() == 3 && file_path.exists() {
            if NativeParquetWriter::create_writer(
        },
            ..Default::default()
    SETTINGS_STORE.remove(index);
/// Helper: create a writer with a 3-column schema: id (Int32), name (Utf8), score (Float64).
    for _i in 0..3 {
    type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
fn test_concurrent_complete_writer_lifecycle() {
    let success_count = Arc::new(AtomicUsize::new(0));
use std::sync::atomic::{AtomicUsize, Ordering};
                )
            type_compression_configs: Some(type_compression),
        let filename = filenames[i].clone();
        let handle = thread::spawn(move || {
    ));
        NativeSettings {
}
        handle.join().unwrap();
                vec![],
    let mut field_configs = HashMap::new();
    SETTINGS_STORE.remove(index);
        Field::new("score", DataType::Float64, true),
            compression_type: Some("LZ4_RAW".to_string()),
    .unwrap();
    let (ap, sp) = create_test_ffi_data().unwrap();
                vec![],
    let read_metadata = NativeParquetWriter::get_file_metadata(filename).unwrap();
    assert_eq!(read_metadata.file_metadata().num_rows(), 6);
                schema_ptr,
            compression_type: Some("SNAPPY".to_string()),
        FieldConfig {
            let nulls = if use_sort { vec![false] } else { vec![] };
#[test]
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
    assert!(file_path.exists());
            return col.compression();
                }
        read_column_compression(&path, "id"),
fn test_mixed_index_and_cluster_level_configs() {
        Compression::SNAPPY
            if NativeParquetWriter::create_writer(
/// Helper: write a 3-column batch (id: Int32, name: Utf8, score: Float64).
}
    let mut handles = vec![];
use opensearch_parquet_format::SETTINGS_STORE;
            cleanup_ffi_schema(schema_ptr);
                        if metadata.metadata.file_metadata().num_rows() == 3 && file_path.exists() {
}
                    vec![Some("C"), Some("A"), Some("B")],
    field_configs.insert(
        if col.column_descr().name() == col_name {
        "id".to_string(),
}
fn test_ipc_staging_sorted_writer_integration() {
    cleanup_ffi_data(ap, sp);
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
                )
            std::sync::Arc::new(Float64Array::from(vec![1.0, 2.0, 3.0])),
    cleanup_ffi_schema(schema_ptr);
    let index = "test_cluster_type_compression";
    field_configs.insert(
fn test_index_level_overrides_cluster_level_encoding() {
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
                0,
    SETTINGS_STORE.insert(
    let mut type_encoding = HashMap::new();
}
            }
        FieldConfig {
    NativeParquetWriter::create_writer(
                    .is_ok()
                if write_ok {
    let meta = reader.metadata();
            }
}
}
    assert_eq!(
                    {
fn test_ipc_and_parquet_mixed_concurrent_lifecycle() {
            {
        encodings.contains(&Encoding::DELTA_BINARY_PACKED),
            std::sync::Arc::new(StringArray::from(vec!["a", "b", "c"])),
fn test_index_level_overrides_cluster_level_compression() {
                    NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr)
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
        Compression::UNCOMPRESSED
        let handle = thread::spawn(move || {
    field_configs.insert(
    // Index says PLAIN for "id", cluster says DELTA_BINARY_PACKED for int32 — index wins
        "DELTA_BINARY_PACKED should not be present when index-level PLAIN is set, got {:?}",
        metadata.metadata.file_metadata().num_rows()
        read_metadata.file_metadata().version(),
    cleanup_ffi_schema(schema_ptr);
    SETTINGS_STORE.remove(index);
/// - index:   UNCOMPRESSED for field "id" → overrides global for "id"
            )
    use arrow::array::{Array, Float64Array, Int32Array, StringArray, StructArray};
    let index = "test_mixed_index_cluster";
    let success_count = Arc::new(AtomicUsize::new(0));
    for i in 0..thread_count {
                vec![],
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
    for handle in handles {
                            let ids = read_parquet_file_sorted_ids(&filename);
                "test-index".to_string(),
        encodings
    }
            .is_ok()
                "test-index".to_string(),
    let success_count = Arc::new(AtomicUsize::new(0));
}
            compression_type: Some("UNCOMPRESSED".to_string()),
/// Index-level field config takes priority over cluster-level type config.
    for i in 0..rg.num_columns() {
                success_count.fetch_add(1, Ordering::SeqCst);
        },
 * SPDX-License-Identifier: Apache-2.0
            ..Default::default()
}
            ..Default::default()
                            let expected = if use_sort {
            let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
        read_column_compression(&path, "id"),
            let filename = file_path.to_string_lossy().to_string();
    let mut field_configs = HashMap::new();
                .unwrap();
    type_encoding.insert("int32".to_string(), "DELTA_BINARY_PACKED".to_string());
    }
                {
                let (ap, sp) = create_test_ffi_data_with_ids(
    );
        vec![],
    let mut field_configs = HashMap::new();
    let (_tmp, path) = get_temp_file_path("cluster_type_comp.parquet");
    ));
        let success_count = Arc::clone(&success_count);
    // Write multiple batches with out-of-order data
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
        let file_path = temp_dir
        index.to_string(),
        Compression::SNAPPY
        vec![false],
    cleanup_ffi_schema(schema_ptr);
        vec![false],
    cleanup_ffi_data(ap, sp);
        });
        },
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
        schema_ptr,
                .unwrap();
            let file_path = temp_dir_path.join(format!("mixed_{}.parquet", i));
        index.to_string(),
            for _ in 0..2 {
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
        let success_count = Arc::clone(&success_count);
    assert!(
            }
        let filename = file_path.to_string_lossy().to_string();
        handle.join().unwrap();
    let file_path = std::path::Path::new(&filename);
    let (schema, schema_ptr) = create_test_ffi_schema();
            ..Default::default()
        vec![],
    unsafe {
        if col.column_descr().name() == col_name {
    let (_temp_dir, filename) = get_temp_file_path("close_race.parquet");
                        NativeParquetWriter::finalize_writer(filename.clone())
            field_configs: Some(field_configs),
                            }
                cleanup_ffi_data(array_ptr, data_schema_ptr);
                            if ids == expected {
    assert!(matches!(
use opensearch_parquet_format::field_config::FieldConfig;
}
                    if let Ok(Some(metadata)) =
        Field::new("name", DataType::Utf8, true),
    NativeParquetWriter::create_writer(
    ));
                    vec![30, 10, 20],
    }
#[test]
                0,
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
    assert_eq!(success_count.load(Ordering::SeqCst), file_count * 2);
    // global fallback for "score" (float64, no index or cluster config)
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
}
    for (i, filename) in filenames.iter().enumerate() {
    field_configs.insert(
/// - global: LZ4_RAW for all columns
        let temp_dir_path = temp_dir.path().to_path_buf();
    index: &str,
        });
    }
                filename.clone(),
    let rg = meta.row_group(0);
    let (_temp_dir, filename) = get_temp_file_path("concurrent_write_ffi.parquet");
            let file_path = temp_dir_path.join(format!("ipc_lifecycle_{}.parquet", i));
        let handle = thread::spawn(move || {
    .expect("create_writer failed");
}
    ]));
    let mut type_compression = HashMap::new();
                filename.clone(),
fn read_column_compression(path: &str, col_name: &str) -> Compression {
#[test]
#[test]
                nulls,
    let index = "test_cluster_type_encoding";
    let reader = SerializedFileReader::new(File::open(path).unwrap()).unwrap();
                    success_count.fetch_add(1, Ordering::SeqCst);
    }
        let temp_dir_path = temp_dir.path().to_path_buf();
    assert!(matches!(
    (schema, schema_ptr)
        filename.to_string(),
        },
    assert!(matches!(
        FieldConfig {
        let (ap, sp) = create_test_ffi_data_with_ids(batch_ids, names).unwrap();
            ..Default::default()
        let filename = filename.clone();
    use arrow::datatypes::{DataType, Field, Schema};
/// Full 3-tier fallback test:
fn test_concurrent_close_operations_same_file() {
            let filename = file_path.to_string_lossy().to_string();
            compression_type: Some("UNCOMPRESSED".to_string()),
    use arrow::datatypes::{DataType, Field, Schema};
    (schema, schema_ptr)
            type_compression_configs: Some(type_compression),
        filename.clone(),
            let (_schema, schema_ptr) = create_test_ffi_schema();
                        }
}
            field_configs: Some(field_configs),
    assert_eq!(ids, vec![10, 20, 30, 40, 50, 60]);
                vec![],
        index.to_string(),
                        }
        handle.join().unwrap();
                }
use std::fs::File;
        handles.push(handle);
    for handle in handles {
    let temp_dir = tempdir().unwrap();
            field_configs: Some(field_configs),
            let filename = file_path.to_string_lossy().to_string();
        Field::new("id", DataType::Int32, false),
                            } else {
}
                filename.clone(),
    for i in 0..file_count {
    use arrow::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
    SETTINGS_STORE.insert(
    let index = "test_three_tier_compression";
        let success_count = Arc::clone(&success_count);
    let (ap, sp) = create_test_ffi_data().unwrap();
    let mut filenames = vec![];
use opensearch_parquet_format::native_settings::NativeSettings;
    cleanup_ffi_data(ap, sp);
    for batch_ids in [vec![50, 30, 10], vec![40, 20, 60]] {
            if NativeParquetWriter::create_writer(
            let sort_cols = if use_sort {
use std::collections::HashMap;
        vec![],
        vec![],
        0,
fn test_ipc_staging_concurrent_sorted_lifecycle() {
        filenames.push(filename);
                    {
    )
    assert!(matches!(
                vec![],
use opensearch_parquet_format::writer::NativeParquetWriter;
) -> (std::sync::Arc<arrow::datatypes::Schema>, i64) {
            }
        handles.push(handle);
            {
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
            } else {
    let index = "test_index_overrides_cluster_encoding";
                let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    }
        read_column_compression(&path, "score"),
                cleanup_ffi_data(ap, sp);
    for handle in handles {
#[test]
                        if metadata.metadata.file_metadata().num_rows() == 3 && file_path.exists() {
                            };
    ));
            std::sync::Arc::new(Int32Array::from(vec![1, 2, 3])),
            ..Default::default()
    let mut schema_ptrs = vec![];
            cleanup_ffi_schema(schema_ptr);
    SETTINGS_STORE.insert(
        "id".to_string(),
        vec![
            ..Default::default()
    }
    let (_schema, schema_ptr) = create_three_col_writer(&path, index);
                        NativeParquetWriter::finalize_writer(filename.clone())
        vec![],
        read_column_compression(&path, "id"),
    }
            ..Default::default()
}
                                vec![30, 10, 20]
    )
    ));
        let success_count = Arc::clone(&success_count);
/// - cluster: SNAPPY for utf8 type → applies to "name"
    let mut handles = vec![];
    let mut field_configs = HashMap::new();
                    vec![30, 10, 20],
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        let success_count = Arc::clone(&success_count);
    }
                vec!["id".to_string()],
    );
        cleanup_ffi_data(array_ptr, data_schema_ptr);
    let mut handles = vec![];
    index: &str,
    let (_tmp, path) = get_temp_file_path("cluster_type_enc.parquet");
    type_compression.insert("int32".to_string(), "SNAPPY".to_string());
                        .is_ok();
fn create_three_col_writer(
        },
    let ffi_array = FFI_ArrowArray::new(&array_data);
            ..Default::default()
    let temp_dir = tempdir().unwrap();
    .unwrap();
    }
#[test]
    let thread_count = 6;
        index.to_string(),
    );
        schema_ptrs.push(schema_ptr);
            type_compression_configs: Some(type_compression),
    cleanup_ffi_schema(schema_ptr);
    SETTINGS_STORE.remove(index);
fn test_index_level_field_compression_applied() {
    assert!(matches!(
        let success_count = Arc::clone(&success_count);
                success_count.fetch_add(1, Ordering::SeqCst);
        let use_sort = i % 2 == 0; // Even threads use IPC (sorted), odd use Parquet (unsorted)
        let col = rg.column(i);
    cleanup_ffi_schema(schema_ptr);
        FieldConfig {
    // cluster level wins for "name" (utf8)
        handles.push(handle);
    );
        FieldConfig {
                if write_ok {
                success_count.fetch_add(1, Ordering::SeqCst);
    assert_eq!(success_count.load(Ordering::SeqCst), thread_count);
        let filename = filename.clone();
        index.to_string(),
    }
        index.to_string(),
                let write_ok =
    let (ap, sp) = create_test_ffi_data().unwrap();
use opensearch_parquet_format::test_utils::*;
    let file_count = 8;
    let mut handles = vec![];
    }
    for _ in 0..3 {
    let mut type_compression = HashMap::new();
    let struct_array = StructArray::from(batch);
    let index = "test_index_field_compression";
    NativeParquetWriter::create_writer(
// ===== Two-tier encoding/compression settings tests =====
    );
            return col.encodings().collect();
        0,
                        }
            }
 *
        });
                if write_ok {
#[test]
                vec![],
    // index level wins for "id"
        handles.push(handle);
            ..Default::default()
    // "utf8" type → "name" column (Utf8) gets SNAPPY from cluster level
/// Index-level field encoding takes priority over cluster-level type encoding.
    cleanup_ffi_schema(schema_ptr);
    );
        index.to_string(),
    let (_tmp, path) = get_temp_file_path("mixed_idx_cluster.parquet");
        },
    let (_tmp, path) = get_temp_file_path("three_tier_comp.parquet");
    SETTINGS_STORE.remove(index);
        read_column_compression(&path, "name"),
        read_column_compression(&path, "id"),
    }
    let temp_dir = tempdir().unwrap();
                            if ids == vec![10, 20, 30] {
            index_name: Some(index.to_string()),
    let (ap, sp) = create_test_ffi_data().unwrap();
    let batch = RecordBatch::try_new(
        NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            let (_schema, schema_ptr) = create_test_ffi_schema();
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
    let metadata = close_writer_and_get_metadata(&filename, schema_ptr);
                vec![],
    let schema = std::sync::Arc::new(Schema::new(vec![
        let temp_dir_path = temp_dir.path().to_path_buf();
    // Index says UNCOMPRESSED for "id", cluster says SNAPPY for int32 — index wins
