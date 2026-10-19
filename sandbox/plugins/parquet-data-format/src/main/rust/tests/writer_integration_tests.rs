        vec![],
    let index = "test_cluster_type_encoding";
    let (ap, sp) = create_test_ffi_data().unwrap();
    }
        vec![],
            let (_schema, schema_ptr) = create_test_ffi_schema();
#[test]
#[test]
            let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    let index = "test_index_overrides_cluster_compression";
            .join(format!("concurrent_write_{}.parquet", i));
            let file_path = temp_dir_path.join(format!("lifecycle_{}.parquet", i));
    );
        NativeSettings {
    let thread_count = 6;
    cleanup_ffi_schema(schema_ptr);
 * this file be licensed under the Apache-2.0 license or a
    SETTINGS_STORE.insert(
    }
            .is_ok()
                            }
    cleanup_ffi_data(ap, sp);
    filename: &str,
            return col.encodings().collect();
use opensearch_parquet_format::field_config::FieldConfig;
        let temp_dir_path = temp_dir.path().to_path_buf();
    type_encoding.insert("int32".to_string(), "DELTA_BINARY_PACKED".to_string());
        vec![],
                schema_ptr,
    let (schema, schema_ptr) = create_test_ffi_schema();
                        if metadata.metadata.file_metadata().num_rows() == 3 && file_path.exists() {
        handles.push(handle);
                cleanup_ffi_data(array_ptr, data_schema_ptr);
    let success_count = Arc::new(AtomicUsize::new(0));
            )
    cleanup_ffi_data(ap, sp);
                }
            } else {
    let mut field_configs = HashMap::new();
                let write_ok =
    let (ap, sp) = create_test_ffi_data().unwrap();
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
    for handle in handles {
                success_count.fetch_add(1, Ordering::SeqCst);
/// - index:   UNCOMPRESSED for field "id" → overrides global for "id"
    let encodings = read_column_encoding(&path, "id");
            {
        filename.to_string(),
                vec![false],
        let names: Vec<Option<&str>> = batch_ids.iter().map(|_| Some("x")).collect();
                            if ids == expected {
        let success_count = Arc::clone(&success_count);
    let mut handles = vec![];
                }
        metadata.metadata.file_metadata().num_rows()
                    {
    }
    );
}
    let read_metadata = NativeParquetWriter::get_file_metadata(filename.clone()).unwrap();
    let success_count = Arc::new(AtomicUsize::new(0));
            type_encoding_configs: Some(type_encoding),
            let file_path = temp_dir_path.join(format!("mixed_{}.parquet", i));
            .path()
use opensearch_parquet_format::SETTINGS_STORE;
            }
        index.to_string(),
        "id".to_string(),
        Compression::UNCOMPRESSED
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
        read_column_compression(&path, "name"),
use tempfile::tempdir;
    for i in 0..rg.num_columns() {
    field_configs.insert(
    let temp_dir = tempdir().unwrap();
            {
    assert!(file_path.metadata().unwrap().len() > 0);
    ));
    );
                        }
        let file_path = temp_dir
    cleanup_ffi_schema(schema_ptr);
            compression_type: Some("SNAPPY".to_string()),
fn test_index_level_field_compression_applied() {
                success_count.fetch_add(1, Ordering::SeqCst);
        let _ = Box::from_raw(array_ptr as *mut FFI_ArrowArray);
fn write_three_col_data(filename: &str) {
                schema_ptr,
    let mut filenames = vec![];
    let batch = RecordBatch::try_new(
            let filename = file_path.to_string_lossy().to_string();
    // "id" is Int32 → should get DELTA_BINARY_PACKED from cluster type config
    }
    let success_count = Arc::new(AtomicUsize::new(0));
    let file_path = std::path::Path::new(&filename);
        let handle = thread::spawn(move || {
    SETTINGS_STORE.insert(
    }
    for _ in 0..5 {
        vec![],
    cleanup_ffi_data(ap, sp);
        index.to_string(),
        "expected DELTA_BINARY_PACKED in {:?}",
    .unwrap();
    let index = "test_index_field_compression";
                    }
    for handle in handles {
    cleanup_ffi_data(ap, sp);
    let mut type_encoding = HashMap::new();
        Field::new("name", DataType::Utf8, true),
        "id".to_string(),
    let reader = SerializedFileReader::new(File::open(path).unwrap()).unwrap();
fn test_ipc_staging_sorted_writer_integration() {
            let reverse = if use_sort { vec![false] } else { vec![] };
            index_name: Some(index.to_string()),
    // Index says PLAIN for "id", cluster says DELTA_BINARY_PACKED for int32 — index wins
    )
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
        let filename = filename.clone();
            if NativeParquetWriter::create_writer(
    assert_eq!(success_count.load(Ordering::SeqCst), thread_count);
                sort_cols,
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
/// Cluster-level type encoding is applied when no index-level field config exists.
        let success_count = Arc::clone(&success_count);
    let index = "test_three_tier_compression";
    assert!(matches!(
        let success_count = Arc::clone(&success_count);
    assert_eq!(
#[test]
    // Write multiple batches with out-of-order data
                0,
    assert!(matches!(
#[test]
            }
    assert!(matches!(
                    vec![Some("C"), Some("A"), Some("B")],
                vec![],
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
fn test_concurrent_complete_writer_lifecycle() {
 */
    cleanup_ffi_schema(schema_ptr);
                    {
    type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
            std::sync::Arc::new(StringArray::from(vec!["a", "b", "c"])),
        NativeSettings {
            let sort_cols = if use_sort {
    for i in 0..thread_count {
        let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
    );
fn test_cluster_level_type_compression_fallback() {
    let mut field_configs = HashMap::new();
#[test]
    }
use parquet::basic::{Compression, Encoding};
        let handle = thread::spawn(move || {
        Compression::SNAPPY
            let nulls = if use_sort { vec![false] } else { vec![] };
        }
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
        NativeSettings {
// ===== Two-tier encoding/compression settings tests =====
    assert!(matches!(
                        NativeParquetWriter::finalize_writer(filename.clone())
                            let ids = read_parquet_file_sorted_ids(&filename);
}
    let mut handles = vec![];
    ));
                let write_ok = NativeParquetWriter::write_data(filename.clone(), ap, sp).is_ok();
}
    }
            return col.compression();
            .is_ok()
    let mut handles = vec![];
                        }
        "test-index".to_string(),
    let mut handles = vec![];
        vec![],
/// Index-level field encoding takes priority over cluster-level type encoding.
        let (ap, sp) = create_test_ffi_data_with_ids(batch_ids, names).unwrap();
    );
    let (ap, sp) = create_test_ffi_data().unwrap();
    let rg = meta.row_group(0);
#[test]
fn test_concurrent_writer_creation() {
                "test-index".to_string(),
            ..Default::default()
    for batch_ids in [vec![50, 30, 10], vec![40, 20, 60]] {
        handle.join().unwrap();
        index.to_string(),
    let (_tmp, path) = get_temp_file_path("idx_field_comp.parquet");
        },
 *
    field_configs.insert(
    let mut type_compression = HashMap::new();
    );
                success_count.fetch_add(1, Ordering::SeqCst);
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
        let handle = thread::spawn(move || {
                    if let Ok(Some(metadata)) =
            .is_ok()
use std::thread;
fn test_ipc_and_parquet_mixed_concurrent_lifecycle() {
        let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
                filename.clone(),
                "test-index".to_string(),
            for _ in 0..2 {
    let success_count = Arc::new(AtomicUsize::new(0));
    let ids = read_parquet_file_sorted_ids(&filename);
                let (ap, sp) = create_test_ffi_data_with_ids(
    let reader = SerializedFileReader::new(File::open(path).unwrap()).unwrap();
                        NativeParquetWriter::finalize_writer(filename.clone())
        Field::new("name", DataType::Utf8, true),
        },
    let (_temp_dir, filename) = get_temp_file_path("concurrent_write_ffi.parquet");
                cleanup_ffi_data(ap, sp);
    )
            ..Default::default()
    cleanup_ffi_schema(schema_ptr);
        Compression::SNAPPY
        Compression::LZ4_RAW
    )
/// Index-level field config takes priority over cluster-level type config.
    assert_eq!(success_count.load(Ordering::SeqCst), thread_count);
    assert!(matches!(
    ));
    assert!(matches!(
        ],
                0,
fn test_ipc_staging_concurrent_sorted_lifecycle() {
        close_writer_and_cleanup_schema(filename, schema_ptrs[i]);
            encoding_type: Some("PLAIN".to_string()),
        let success_count = Arc::clone(&success_count);
    SETTINGS_STORE.remove(index);
        Compression::SNAPPY
                            }
/// Helper: write a 3-column batch (id: Int32, name: Utf8, score: Float64).
        "DELTA_BINARY_PACKED should not be present when index-level PLAIN is set, got {:?}",
    }
    assert!(result.is_ok());
                            if ids == vec![10, 20, 30] {
        },
fn test_mixed_index_and_cluster_level_configs() {
            ..Default::default()
        Compression::UNCOMPRESSED
}
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        filename.to_string(),
        },
                    vec![30, 10, 20],
use opensearch_parquet_format::native_settings::NativeSettings;
fn create_three_col_writer(
    let schema = meta.file_metadata().schema_descr();
            index_name: Some(index.to_string()),
    let (_tmp, path) = get_temp_file_path("mixed_idx_cluster.parquet");
        let col = rg.column(i);
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
use opensearch_parquet_format::writer::NativeParquetWriter;
    cleanup_ffi_schema(schema_ptr);
    let mut field_configs = HashMap::new();
            field_configs: Some(field_configs),
            type_compression_configs: Some(type_compression),
        schema_ptr,
            compression_type: Some("UNCOMPRESSED".to_string()),
}
        let col = rg.column(i);
    let (ap, sp) = create_test_ffi_data().unwrap();
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 9); // 3 batches × 3 rows
        schema_ptrs.push(schema_ptr);
        NativeSettings {
            field_configs: Some(field_configs),
                    }
}
    let result = NativeParquetWriter::finalize_writer(filename.clone());
        NativeSettings {
        FieldConfig {
/// Full 3-tier fallback test:
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
    for i in 0..file_count {
        let handle = thread::spawn(move || {
                        .is_ok();
/// Helper: create a writer for a specific index name (not the default "test-index").
/*
fn test_cluster_level_type_encoding_fallback() {
    }
            };
    SETTINGS_STORE.remove(index);
            ..Default::default()
    );
            let (_schema, schema_ptr) = create_test_ffi_schema();
    let index = "test_mixed_index_cluster";
        FieldConfig {
                    NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr)
    let mut type_compression = HashMap::new();
        handles.push(handle);
    }
    type_encoding.insert("int32".to_string(), "DELTA_BINARY_PACKED".to_string());
        let temp_dir_path = temp_dir.path().to_path_buf();
}
        FieldConfig {
    cleanup_ffi_schema(schema_ptr);
                    .is_ok()
                filename.clone(),
/// Index-level field compression is applied to the named column.
    }
    }
    // "utf8" type → "name" column (Utf8) gets SNAPPY from cluster level
                            let ids = read_parquet_file_sorted_ids(&filename);
use opensearch_parquet_format::test_utils::*;
            cleanup_ffi_schema(schema_ptr);
fn test_concurrent_close_operations_same_file() {
    assert_eq!(read_metadata.file_metadata().num_rows(), 6);
}
                vec![],
    let schema = std::sync::Arc::new(Schema::new(vec![
            index_name: Some(index.to_string()),
                        NativeParquetWriter::finalize_writer(filename.clone())
    panic!("column '{}' not found in {}", col_name, path);
        let handle = thread::spawn(move || {
    let (_tmp, path) = get_temp_file_path("cluster_type_comp.parquet");
        cleanup_ffi_data(ap, sp);
    );
        Field::new("score", DataType::Float64, true),
            field_configs: Some(field_configs),
                "test-index".to_string(),
    let mut type_compression = HashMap::new();
    let success_count = Arc::new(AtomicUsize::new(0));
 * The OpenSearch Contributors require contributions made to
                let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    let temp_dir = tempdir().unwrap();
    for _i in 0..3 {
    let file_count = 8;
}
        handles.push(handle);
    );
            ..Default::default()
        "id".to_string(),
    );
        let filename = filename.clone();
        Field::new("id", DataType::Int32, false),
    let temp_dir = tempdir().unwrap();
fn test_concurrent_writes_same_file() {
    for i in 0..rg.num_columns() {
                    {
                .unwrap();
        NativeSettings {
    for i in 0..10 {
        },
    let (_temp_dir, filename) = get_temp_file_path("close_race.parquet");
#[test]
    assert_eq!(success_count.load(Ordering::SeqCst), thread_count);
#[test]
    panic!("column '{}' not found in {}", col_name, path);
    let (_tmp, path) = get_temp_file_path("three_tier_comp.parquet");
            cleanup_ffi_schema(schema_ptr);
                        if metadata.metadata.file_metadata().num_rows() == 3 && file_path.exists() {
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        0,
    let thread_count = 8;
        read_column_compression(&path, "score"),
fn test_three_tier_compression_fallback() {
    let index = "test_index_overrides_cluster_encoding";
    let metadata = result.unwrap().unwrap();
    );
    use arrow::datatypes::{DataType, Field, Schema};
    let success_count = Arc::new(AtomicUsize::new(0));
use parquet::file::reader::{FileReader, SerializedFileReader};
    let temp_dir = tempdir().unwrap();
                let (ap, sp) = create_test_ffi_data_with_ids(
    ));
                cleanup_ffi_data(array_ptr, data_schema_ptr);
    assert_eq!(success_count.load(Ordering::SeqCst), file_count * 2);
#[test]
    SETTINGS_STORE.remove(index);
fn test_concurrent_writes_different_files() {
        vec![],
        encodings
    use arrow::datatypes::{DataType, Field, Schema};
    ));
        encodings.contains(&Encoding::DELTA_BINARY_PACKED),
    SETTINGS_STORE.remove(index);
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
        vec![false],
/// - "score" (Float64): no index or cluster config → gets global LZ4_RAW
        0,
        read_column_compression(&path, "id"),
        },
            field_configs: Some(field_configs),
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
    assert!(
            std::sync::Arc::new(Float64Array::from(vec![1.0, 2.0, 3.0])),
    assert!(file_path.exists());
    SETTINGS_STORE.insert(
    let meta = reader.metadata();
        metadata.metadata.file_metadata().version()
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
        }
            if NativeParquetWriter::create_writer(
    let thread_count = 6;
    .unwrap();
        },
        "id".to_string(),
            let (_schema, schema_ptr) = create_test_ffi_schema();
    let mut type_encoding = HashMap::new();
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
                            };
    }
                    success_count.fetch_add(1, Ordering::SeqCst);
    let read_metadata = NativeParquetWriter::get_file_metadata(filename).unwrap();
                if write_ok {
fn test_index_level_overrides_cluster_level_encoding() {
    use arrow::array::{Array, Float64Array, Int32Array, StringArray, StructArray};
    ));
    NativeParquetWriter::create_writer(
fn read_column_compression(path: &str, col_name: &str) -> Compression {
        vec![false],
        !encodings.contains(&Encoding::DELTA_BINARY_PACKED),
    let metadata = close_writer_and_get_metadata(&filename, schema_ptr);
                schema_ptr,
}
        handles.push(handle);
    for i in 0..thread_count {
    for handle in handles {
use std::sync::Arc;
            type_encoding_configs: Some(type_encoding),
                reverse,
            let filename = file_path.to_string_lossy().to_string();
    SETTINGS_STORE.remove(index);
}
    NativeParquetWriter::create_writer(
 * SPDX-License-Identifier: Apache-2.0
            type_compression_configs: Some(type_compression),
    }
        if col.column_descr().name() == col_name {
    .expect("create_writer failed");
    let (_tmp, path) = get_temp_file_path("cluster_type_enc.parquet");
            }
    assert!(matches!(
    assert!(metadata.metadata.file_metadata().version() > 0);
                vec![false],
    type_compression.insert("int32".to_string(), "SNAPPY".to_string());
                        }
        handle.join().unwrap();
    SETTINGS_STORE.remove(index);
        filenames.push(filename);
            field_configs: Some(field_configs),
    type_compression.insert("int32".to_string(), "SNAPPY".to_string());
                vec![],
    filename: &str,
        let use_sort = i % 2 == 0; // Even threads use IPC (sorted), odd use Parquet (unsorted)
        read_column_compression(&path, "id"),
    let (ap, sp) = create_test_ffi_data().unwrap();
    cleanup_ffi_data(ap, sp);
    index: &str,
    // Index says UNCOMPRESSED for "id", cluster says SNAPPY for int32 — index wins
    for handle in handles {
                let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
        },
        schema.clone(),
    field_configs.insert(
                vec!["id".to_string()],
    let mut schema_ptrs = vec![];
                vec![],
                            } else {
    ));
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 6);
                                success_count.fetch_add(1, Ordering::SeqCst);
                cleanup_ffi_data(ap, sp);
                schema_ptr,
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
            ..Default::default()
        NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        Field::new("id", DataType::Int32, false),
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
    for (i, filename) in filenames.iter().enumerate() {
    let encodings = read_column_encoding(&path, "id");
        let success_count = Arc::clone(&success_count);
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
        read_metadata.file_metadata().version(),
    }
#[test]
fn create_writer_and_assert_success_for_index(
            {
    SETTINGS_STORE.remove(index);
                    vec![30, 10, 20],
        let temp_dir_path = temp_dir.path().to_path_buf();
fn test_complete_writer_lifecycle() {
}
/// Cluster-level type compression is applied when no index-level field config exists.
    assert_eq!(success_count.load(Ordering::SeqCst), 10);
            if NativeParquetWriter::write_data(filename, array_ptr, data_schema_ptr).is_ok() {
        vec![],
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
}
    SETTINGS_STORE.insert(
    let (_schema, schema_ptr) = create_test_ffi_schema();
        });
            ..Default::default()
    close_writer_and_cleanup_schema(&filename, schema_ptr);
                        if metadata.metadata.file_metadata().num_rows() == 3 && file_path.exists() {
/// Different columns get different configs: one from index level, one from cluster level.
            cleanup_ffi_data(array_ptr, data_schema_ptr);
            compression_type: Some("LZ4_RAW".to_string()),
                    if let Ok(Some(metadata)) =
use std::collections::HashMap;
            index_name: Some(index.to_string()),
        handle.join().unwrap();
    ]));
        let filename = file_path.to_string_lossy().to_string();
        });
    for i in 0..thread_count {
        schema_ptr,
        },
                    }
    );
    let array_data = struct_array.into_data();
    let mut field_configs = HashMap::new();
}
    assert_eq!(
        index.to_string(),
    let (_tmp, path) = get_temp_file_path("idx_overrides_cluster_comp.parquet");
                }
    }
        FieldConfig {
        let temp_dir_path = temp_dir.path().to_path_buf();
            type_compression_configs: Some(type_compression),
        vec![],
    NativeParquetWriter::write_data(path.clone(), ap, sp).unwrap();
        0,
            }
    field_configs.insert(
        },
    unsafe {
    let index = "test_cluster_type_compression";
    SETTINGS_STORE.insert(
                if write_ok {
            ..Default::default()
            )
    let ffi_array = FFI_ArrowArray::new(&array_data);
}
                    vec![Some("C"), Some("A"), Some("B")],
                {
        handle.join().unwrap();
 * compatible open source license.
                vec![],
// ===== Arrow IPC staging integration tests =====
                }
    cleanup_ffi_schema(schema_ptr);
            let filename = file_path.to_string_lossy().to_string();
                                vec![10, 20, 30]
    use arrow::ffi::FFI_ArrowSchema;
                filename.clone(),
    for handle in handles {
        handles.push(handle);
        FieldConfig {
                "test-index".to_string(),
        let handle = thread::spawn(move || {
    SETTINGS_STORE.insert(
            compression_type: Some("UNCOMPRESSED".to_string()),
        handle.join().unwrap();
}
    let (_schema, schema_ptr) = create_three_col_writer(&path, index);
    let (_temp_dir, filename) = get_temp_file_path("ipc_integ_sorted.parquet");
) -> (std::sync::Arc<arrow::datatypes::Schema>, i64) {
                .unwrap();
        vec![
    let (_temp_dir, filename) = get_temp_file_path("complete_workflow.parquet");
                vec![],
            ..Default::default()
    assert!(matches!(
    assert_eq!(success_count.load(Ordering::SeqCst), 5);
        let success_count = Arc::clone(&success_count);
    let mut handles = vec![];
    }
    );
                vec![],
        vec![],
        read_column_compression(&path, "id"),
        NativeSettings {
fn read_column_encoding(path: &str, col_name: &str) -> Vec<Encoding> {
                vec![],
        read_column_compression(&path, "name"),
    );
}
                vec![]
        let handle = thread::spawn(move || {
        });
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
) -> (std::sync::Arc<arrow::datatypes::Schema>, i64) {
    for _ in 0..3 {
    let mut type_compression = HashMap::new();
    (schema, schema_ptr)
use std::fs::File;
        let _ = Box::from_raw(schema_ptr as *mut FFI_ArrowSchema);
    use arrow::record_batch::RecordBatch;
                    if let Ok(Some(metadata)) =
        handles.push(handle);
#[test]
    }
                0,
            if NativeParquetWriter::create_writer(
                )
    assert_eq!(success_count.load(Ordering::SeqCst), 1);
    field_configs.insert(
    NativeParquetWriter::create_writer(
        let filename = filenames[i].clone();
    // index level wins for "id"
        cleanup_ffi_data(array_ptr, data_schema_ptr);
    assert!(
            {
    write_three_col_data(&path);
use std::sync::atomic::{AtomicUsize, Ordering};
                vec![],
            type_compression_configs: Some(type_compression),
            }
            let file_path = temp_dir_path.join(format!("ipc_lifecycle_{}.parquet", i));
    cleanup_ffi_schema(schema_ptr);
#[test]
        index.to_string(),
}
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        Field::new("score", DataType::Float64, true),
                let write_ok = NativeParquetWriter::write_data(filename.clone(), ap, sp).is_ok();
        },
    ]));
        read_metadata.file_metadata().num_rows(),
    let mut field_configs = HashMap::new();
        index.to_string(),
    assert_eq!(ids, vec![10, 20, 30, 40, 50, 60]);
/// - cluster: SNAPPY for utf8 type → applies to "name"
    // cluster level wins for "name" (utf8)
    (schema, schema_ptr)
    let (_tmp, path) = get_temp_file_path("idx_overrides_cluster_enc.parquet");
        encodings
        });
    // "id" (Int32) has explicit index-level compression
}
    cleanup_ffi_data(ap, sp);
            let file_path = temp_dir_path.join(format!("concurrent_{}.parquet", i));
    .expect("create_writer failed");
    NativeParquetWriter::write_data(filename.to_string(), array_ptr, schema_ptr).unwrap();
        });
            ..Default::default()
            if NativeParquetWriter::finalize_writer(filename).is_ok() {
                )
    );
}
            let filename = file_path.to_string_lossy().to_string();
            std::sync::Arc::new(Int32Array::from(vec![1, 2, 3])),
    let success_count = Arc::new(AtomicUsize::new(0));
                            success_count.fetch_add(1, Ordering::SeqCst);
                vec![],
    let (ap, sp) = create_test_ffi_data().unwrap();
        Compression::UNCOMPRESSED
            }
    let meta = reader.metadata();
}
    for i in 0..file_count {
            cleanup_ffi_schema(schema_ptr);
                vec!["id".to_string()]
        index.to_string(),
                if write_ok {
        index.to_string(),
#[test]
                if NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr)
        vec!["id".to_string()],
/// Helper: create a writer with a 3-column schema: id (Int32), name (Utf8), score (Float64).
            ..Default::default()
        schema_ptr,
    SETTINGS_STORE.insert(
    for handle in handles {
            )
            index_name: Some(index.to_string()),
    cleanup_ffi_schema(schema_ptr);
    index: &str,
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
#[test]
#[test]
    for handle in handles {
    type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
    let mut handles = vec![];
    let mut handles = vec![];
    let (_schema, schema_ptr) = create_writer_and_assert_success_for_index(&path, index);
            index_name: Some(index.to_string()),
        read_column_compression(&path, "id"),
                nulls,
        handle.join().unwrap();
    ));
        let success_count = Arc::clone(&success_count);
        Compression::SNAPPY
    }
    NativeParquetWriter::finalize_writer(path.clone()).unwrap();
        },
    );
            if NativeParquetWriter::create_writer(
#[test]
        index.to_string(),
            ..Default::default()
        });
    }
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
                                success_count.fetch_add(1, Ordering::SeqCst);
            index_name: Some(index.to_string()),
    // "id" is Int32 → should get SNAPPY from cluster type config
    )
            }
                let _ = NativeParquetWriter::finalize_writer(filename);
            cleanup_ffi_schema(schema_ptr);
            )
        handle.join().unwrap();
        filename.clone(),
    }
            compression_type: Some("UNCOMPRESSED".to_string()),
        read_column_compression(&path, "id"),
    // global fallback for "score" (float64, no index or cluster config)
                filename.clone(),
        handles.push(handle);
    let schema = std::sync::Arc::new(Schema::new(vec![
        "id".to_string(),
            let (_schema, schema_ptr) = create_test_ffi_schema();
                0,
        if col.column_descr().name() == col_name {
        });
                                vec![30, 10, 20]
    let temp_dir = tempdir().unwrap();
    use arrow::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
    let struct_array = StructArray::from(batch);
                            let expected = if use_sort {
            .is_ok()
/// - global: LZ4_RAW for all columns
fn test_index_level_overrides_cluster_level_compression() {
    let rg = meta.row_group(0);
