        stored_after.bloom_filter_enabled
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
        rg.num_columns() > 0,
        index_name.to_string(),
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
fn test_concurrent_close_operations_same_file() {
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    assert!(result1.is_ok());
    assert_eq!(ages, vec![None, None, Some(10), Some(20), Some(30)]);
        "Permutation mapping should correctly map original row IDs to sorted positions"
        vec![0, 1, 2, 3, 4],
#[test]
    let index_name = "test-bloom-default-index-unique2";
    use arrow::array::{Array, Int32Array, StringArray};
                            let ids = read_parquet_file_sorted_ids(&filename);
    );
            Some("A"),
    );
    NativeParquetWriter::create_writer(
    let ids = read_parquet_file_sorted_ids(&filename);
        vec![false, false],
    assert_eq!(
    let schema = Arc::new(Schema::new(vec![
    // Verify sorted output
        ],
        .unwrap();
        vec![false],
    )
        .unwrap_err()
    let (_temp_dir2, filename2) = get_temp_file_path("crc_diff2.parquet");
        vec![],
        "Default bloom_filter_enabled should be false when no settings exist"
    let mut file = File::open(path).unwrap();
    let batch = RecordBatch::try_new(
    )
    let result = NativeParquetWriter::create_writer(
    let (_temp_dir, filename) = get_temp_file_path("cleanup.parquet");
/// Test: Sorted writer without __row_id__ column — multi chunk (forced by small threshold).
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
        &lists[..4],
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", true);
        vec![false],
    let reread_crc32 = compute_file_crc32(&filename);
        vec![10, 20]
    // Create writer with sort on "age" ascending
#[test]
    let mut filenames = vec![];
    let mut settings = NativeSettings::default();
        result.unwrap_err().to_string().contains("Writer not found"),
    .unwrap();
use std::thread;
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 6);
    settings.nulls_first = vec![false];
    let (_temp_dir, filename) = get_temp_file_path("multi_sort_chunked.parquet");
        vec![4, 0, 2, 1, 3],
    settings.reverse_sorts = vec![false];
#[test]
    let (_temp_dir, filename) = get_temp_file_path("nulls_first_rowid.parquet");
    let index_name = "test-chunked-invertible";
#[test]
    settings.reverse_sorts = vec![true]; // descending
    .unwrap();
    }
    let prefix1 = Path::new(&filename1)
                return None;
    let writer_generation = 17i64;
}
        index_name.to_string(),
        filename.clone(),
        OffsetBuffer::new(vec![0_i32, 2, 4, 5, 5].into()),
    )
        index_name.to_string(),
    NativeParquetWriter::create_writer(
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    ]));
    let writer_generation = 42i64;
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let result = NativeParquetWriter::finalize_writer("nonexistent.parquet".to_string());
    settings.sort_in_memory_threshold_bytes = Some(64); // Very small — forces chunking
        0,
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    );
    let (_temp_dir, filename) = get_temp_file_path("complete_workflow.parquet");
        vec![30, 10, 20],
        filename1.clone(),
            Some("D"),
    // NULLs first, then ascending non-nulls
    settings.nulls_first = vec![false];
    SETTINGS_STORE.remove(index_name);
    let col = combined
            "tags",
    .unwrap();
        vec![],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
}
        .unwrap();
        Arc::new(Schema::new(vec![
    let gen = read_writer_generation_from_parquet(&filename);
    assert!(result.is_ok(), "create_writer failed: {:?}", result.err());
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    use arrow::datatypes::{DataType, Field, Schema};
        filename.clone(),
    let (_temp_dir, filename) = get_temp_file_path("sorted_desc.parquet");
    assert_eq!(scores, vec![10, 30, 50, 70, 10, 30, 40, 50, 20, 60]);
        missing.sort_unstable();
 * SPDX-License-Identifier: Apache-2.0
    )
/// Test: Different data produces different CRC32 values (sanity check).
            Some("z"),
            Some("G"),
        vec![10, 20, 30, 40, 50, 60, 70, 80],
    settings.sort_in_memory_threshold_bytes = Some(128); // Small enough to force chunking
    let mut settings = NativeSettings::default();
        0,
    metadata.key_value_metadata().and_then(|kvs| {
        vec![50, 20, 10]
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    column: &str,
    settings.compression_type = Some("ZSTD".to_string());
            Some("A"),
    let index_name = "test-no-rowid-single";
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let expected: Vec<i64> = (0..10).collect();
    settings.nulls_first = vec![false];
    let (_temp_dir, filename) = get_temp_file_path("props_multi_zstd.parquet");
    );
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        .join("staging.arrow_ipc_staging")
        0,
    cleanup_ffi_data(ap2, sp2);
            Some("B"),
    NativeParquetWriter::create_writer(
    let index_name = "test-multi-sort-asc-desc";
    SETTINGS_STORE.remove(index_name);
    let mut descending_missing = (3..6)
    let (_temp_dir, filename) = get_temp_file_path("duplicate.parquet");
    let prefix2 = Path::new(&filename2)
#[test]
    let descending_ids = descending
    settings.reverse_sorts = vec![false];
        schema_ptr,
        .to_string();
    assert!(result2.is_ok());
    cleanup_ffi_schema(schema_ptr);
    let ages = read_ages_from_parquet(&filename);
/// - The output is valid (all ages are 30)
        )
            "values",
        vec![],
    );
            }
        0,
/// Helper: reads the writer_generation from Parquet file metadata.
        filename.clone(),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    settings.sort_in_memory_threshold_bytes = Some(64);
}
    let index_name = "test-props-multi-snappy";
    assert!(!NativeParquetWriter::has_writer(&filename));
/// Helper: reads a Parquet file and returns the __row_id__ column values.
            Some("D"),
                let _ = NativeParquetWriter::write_data(filename.clone(), ap, sp);
    )
        sorted_mapping, expected_perm,
            Some("H"),
            Some("I"),
        vec![false],
    let batch = RecordBatch::try_new(
        vec!["age".to_string()],
    settings.sort_columns = vec!["age".to_string()];
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
/// correct sorted output with sequential row IDs and valid permutation.
    let (_temp_dir, filename) = get_temp_file_path("props_single_zstd.parquet");
    assert_eq!(finalize_result.metadata.file_metadata().num_rows(), 0);
            .map(|row| descending_ids.value(row))
    settings.nulls_first = vec![false];
// #[test]
    // Sorted DESC: age=[50,40,30,20,10] → original row_ids [1,4,2,3,0]
            Some("H"),
        .unwrap();
        "Data should be sorted ascending by id"
    assert!(result.is_err());
        vec![],
}
        finalize_result.metadata.file_metadata().num_rows(),
            break;
//     run_sort_permutation_test(false, "small_file");
fn test_chunked_writer_batch_slicing_two_rows_per_slice() {
        ]
            DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
        index_name.to_string(),
            Some("H"),
    let result = NativeParquetWriter::get_filtered_writer_memory_usage(prefix);
    let compression = read_compression_from_parquet(&filename);
    assert_eq!(gen, Some(12));
    assert!(result.is_ok());
    // Second batch: row_ids 5..9
    assert_eq!(row_ids, vec![0, 1, 2, 3, 4, 5]);
    .unwrap();
    // Verify format version
            Some("J"),
            Some("I"),
        filename.clone(),
        create_test_ffi_data_with_ids(vec![20, 40], vec![Some("B"), Some("D")]).unwrap();
    SETTINGS_STORE.remove(index_name);
    use arrow::array::{Array, Int32Array, Int64Array, StringArray};
    settings.sort_columns = vec!["age".to_string()];
        Field::new("age", DataType::Int32, true), // nullable
    );
fn test_crc32_matches_reread_with_data() {
    let result =
        "__row_id__ should be sequential after rewrite"
fn test_unsorted_writer_generation_in_metadata() {
    // age=10: score=70
    assert_eq!(
            Some("C"),
#[test]
    assert_eq!(ids, vec![10, 20, 30]);
    // Format version always stamped
//     run_sort_permutation_test(true, "large_file");
    assert_eq!(stored.bloom_filter_enabled, Some(false));
                let (ap, sp) = create_test_ffi_data_with_ids(
    let (_temp_dir, filename) = get_temp_file_path("gen_zero.parquet");
        vec!["age".to_string()],
/// Test: Single chunk (all data fits in memory) — verifies row IDs are sequential
    // mapping[6]=4(50→pos4), mapping[7]=2(30→pos2), mapping[8]=6(70→pos6)
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    assert_eq!(mem2, 0, "Writer 2 should have 0 memory (no data written)");
    assert!(result.is_ok());
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    for _ in 0..5 {
        vec!["age".to_string()],
        .unwrap();
        filename.clone(),
    ages: Vec<i32>,
    let (_temp_dir, filename) = get_temp_file_path("props_single_uncompressed.parquet");
    );
/// applied when no explicit settings are configured — single chunk path.
    ]));
}
#[test]
    settings.reverse_sorts = vec![false]; // ASC
            Some("A"),
        Field::new("name", DataType::Utf8, true),
    assert!(result
        vec![],
        };
fn read_nullable_string_lists(
            Some("C"),
        Field::new("age", DataType::Int32, false),
        0,
    for handle in handles {
                let (ap, sp) = create_test_ffi_data().unwrap();
    settings.sort_columns = vec!["tags".to_string()];
fn test_ipc_staging_same_file_removes_stale_and_succeeds() {
        Field::new("age", DataType::Int32, false),
        create_ffi_data_with_row_id(vec![20, 10], vec![Some("B"), Some("A")], vec![0, 1]);
        schema_ptr,
        .downcast_ref::<Int64Array>()
        ],
    assert_eq!(mapping, vec![4, 0, 2, 3, 1]);
        "CRC32 should be non-zero for single-chunk sorted output"
    let mut settings = NativeSettings::default();
    // Empty file has no row groups, so we can't check compression or bloom filter
    settings.reverse_sorts = vec![false]; // ASC
    let rg = metadata.row_group(0);
fn compute_file_crc32(path: &str) -> u32 {
    let ages = read_ages_from_parquet(&filename);
fn test_cleanup_writer_removes_entry_and_is_idempotent() {
    let result2 = NativeParquetWriter::finalize_writer(filename2.clone())
}
/// Test: nulls_first=true places NULL values before non-null values in ascending sort.
        bloom_filter_enabled: Some(false),
    .unwrap();
    use arrow::array::Int64Array;
    settings.nulls_first = vec![false];
        schema_ptr,
// These tests exercise the chunked sort path by setting a very small memory threshold
    // mapping[3]=3(40→pos3), mapping[4]=0(10→pos0), mapping[5]=6(70→pos6),
        vec![
    settings.nulls_first = vec![false];
            false,
    // Expected: age ASC, then score ASC within same age
    settings.nulls_first = vec![false];
fn test_chunked_writer_batch_slicing_descending() {
            Field::new(
    let reader = SerializedFileReader::new(file).unwrap();
    )
}
    settings.reverse_sorts = vec![false];
    let index_name = "test-chunked-multi";
        "Output should be sorted by age ASC"
        filename.clone(),
    let (ap2, sp2) =
}
        .to_string();
    settings.sort_in_memory_threshold_bytes = Some(64);
    // mapping[0]=2, mapping[1]=0, mapping[2]=4, mapping[3]=1, mapping[4]=3
    settings.reverse_sorts = vec![false];
fn test_write_data_invalid_pointers() {
    // 10(row2)→pos0, 20(row4)→pos1, 30(row0)→pos2, NULL(row1)→pos3, NULL(row3)→pos4
        .row_id_mapping
    batch: &arrow::record_batch::RecordBatch,
    settings.reverse_sorts = vec![true]; // descending
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024); // 10MB — won't chunk
        index_name.to_string(),
        .to_string();
#[test]
        vec![],
    assert_eq!(
        vec![false],
        let success_count = Arc::clone(&success_count);
    use arrow::datatypes::{DataType, Field, Schema};
        create_test_ffi_data_with_ids(vec![30, 10, 20], vec![Some("C"), Some("A"), Some("B")])
                    })
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let schema = Arc::new(Schema::new(vec![
/// Helper: checks whether bloom filter metadata is present in the first row group's columns.
    assert!(
    let (_temp_dir, filename) = get_temp_file_path("ipc_empty.parquet");
    assert_eq!(mapping.len(), 8);
        index_name.to_string(),
        filename.clone(),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
        vec![50, 30, 10, 70, 20, 40, 10, 60, 30, 50],
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
            &[nulls_first],
                {
    let (ap1, sp1) =
    let (ap, sp) = create_ffi_data_nullable_with_row_id(
        .expect("__row_id__ should be Int64");
                .unwrap();
            Some("B"),
        vec![0, 1, 2, 3, 4],
            Some("A"),
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        filename.clone(),
    settings.sort_columns = vec!["age".to_string(), "score".to_string()];
        Field::new("name", DataType::Utf8, true),
}
        vec![],
    settings.reverse_sorts = vec![false];
        .as_primitive::<arrow::datatypes::Int64Type>();
        schema_ptr,
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    assert!(result.is_ok());
    );
        filename.clone(),
        vec!["age".to_string()],
    sorted_mapping.sort();
    );
        vec![false],
#[test]
        vec![true],
    // Verify compression is UNCOMPRESSED
        vec![
    );
        ids,
        sorted_mapping, expected_sequential,
        0,
    SETTINGS_STORE.remove(index_name);
fn test_concurrent_writes_different_files() {
    let ids = read_parquet_file_sorted_ids(&filename);
    // Check if any column has bloom filter offset set
                Some(col.value(i))
fn test_chunked_writer_no_row_id_multi_chunk() {
            let (_schema, schema_ptr) = create_test_ffi_schema();
    assert_ne!(
    let scores = read_scores_from_parquet(&filename);
        filename.clone(),
        schema_ptr,
        assert_eq!(
        vec![
#[test]
    }
    settings.sort_columns = vec!["age".to_string()];
    SETTINGS_STORE.insert(index_name.to_string(), settings);
}
    )
    );
    let ages = read_ages_from_parquet(&filename);
    let rows = vec![
        0,
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    // mapping[3]=6 (age=40→pos6), mapping[4]=3 (age=20→pos3), mapping[5]=9 (age=60→pos9)
    use arrow::datatypes::{DataType, Field, Schema};
use std::sync::atomic::{AtomicUsize, Ordering};
    assert!(
        create_test_ffi_data_with_ids(vec![30, 20], vec![Some("C"), Some("B")]).unwrap();
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        vec![false],
            Some("E"),
}
}
        Arc::new(Field::new("element", DataType::Int32, false)),
        vec![50, 10, 30, 20, 40],
    let expected_sequential: Vec<i64> = (0..8).collect();
                }
        let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
        schema_ptr,
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
        let filename = filename.clone();
        .unwrap();
            Some("G"),
    settings.sort_columns = vec!["age".to_string()];
    }
    assert_eq!(finalize_result.crc32, actual_crc);
    NativeParquetWriter::create_writer(
        vec![false],
        (0..2).map(|row| ids.value(row)).collect::<Vec<_>>(),
        .as_primitive::<arrow::datatypes::Int64Type>();
        mem_after > 0,
    let (ap, sp) = create_ffi_data_with_row_id(
    .unwrap();
#[test]
        .schema()
    ascending_missing.sort_unstable();
        .expect("score column should exist");
    assert_eq!(ages, vec![30, 30, 20, 20, 10]);
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    let mut settings = NativeSettings::default();
    let mapping = finalize_result
    assert_eq!(mapping.len(), 10);
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    let mut settings = NativeSettings::default();
    // Verify permutation
        filename.clone(),
#[test]
    let (ap, sp) = create_ffi_data_multi_sort(
    .unwrap();
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        vec![],
        schema_ptr,
        vec!["age".to_string()],
    let row_id_array: Arc<dyn Array> = Arc::new(Int64Array::from(row_ids));
    NativeParquetWriter::create_writer(
// incoming batch exceeds memory_threshold_bytes and must be sliced into smaller pieces,
    assert_eq!(
}
    assert_eq!(row_ids, expected_sequential);
        .expect("Should have row_id_mapping");
    );
    let row_ids_in_file = read_row_ids_from_parquet(&filename);
    SETTINGS_STORE.remove(index_name);
    let mut settings = NativeSettings::default();
    let reader = SerializedFileReader::new(file).unwrap();
fn test_create_writer_same_file_removes_stale_and_succeeds() {
            Some("B"),
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    let schema = Arc::new(Schema::new(vec![
            )
    let mut settings = NativeSettings::default();
        vec![false],
        filename.clone(),
        "Final Parquet file should exist"
        index_name.to_string(),
/// Test: nulls_first=true with __row_id__ — verifies sequential row IDs and correct permutation
        filename.clone(),
            Arc::new(list) as ArrayRef,
        schema_ptr,
    );
    let result = NativeParquetWriter::write_data(filename.clone(), 0, schema_ptr);
        0,
    let ages = read_ages_from_parquet(&filename);
/// Test: Default writer properties (LZ4_RAW compression, bloom filter enabled) are
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        vec!["age".to_string(), "score".to_string()],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let mut schema_ptrs = vec![];
    // Use defaults — only configure sort
    assert!(
    settings.reverse_sorts = vec![false];
    );
        schema_ptr1,
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
/// Test: write_data fails with "Writer not found" when no sorted (IPC) writer exists for the file.
            Some("E"),
        "Single chunk path should stamp format version"
    assert_eq!(ascending_missing, vec![30, 40, 60]);
            Some("I"),
            DataType::List(Arc::new(Field::new("element", DataType::Int32, false))),
    let metadata = reader.metadata().file_metadata();
}
    let index_name = "test-identical-keys";
        "test-index".to_string(),
    // Verify permutation mapping
        schema,
    assert_eq!(
    );
    )
        vec!["age".to_string()],
        .to_string_lossy()
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
}
    settings.reverse_sorts = vec![false];
        vec![],
    .unwrap();
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
        .unwrap()
                        }
    let (_temp_dir, filename) = get_temp_file_path("list_sort_multi_chunk.parquet");
    })
        .unwrap();
    assert!(result.unwrap_err().to_string().contains("Writer not found"));
        vec![50, 40, 30, 20, 10],
        vec![0, 1, 2, 3, 4],
    let list = ListArray::new(
    let ages = read_ages_from_parquet(&filename);
    let read_metadata = NativeParquetWriter::get_file_metadata(filename.clone()).unwrap();
    assert!(NativeParquetWriter::has_writer(&filename));
    let record_batch =
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        .unwrap();
    NativeParquetWriter::create_writer(
        0,
    use arrow::array::{ArrayRef, AsArray, Int32Array, Int64Array, ListArray, RecordBatch};
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            Some("B"),
fn test_sort_batch_uses_minimum_numeric_list_element() {
}
        "Permutation should correctly place NULLs last and map original row IDs"
    let (ap2, sp2) = create_ffi_data_with_row_id(
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    );
    close_writer_and_cleanup_schema(&filename, schema_ptr);
// Parquet file for all finalize_sorted_chunks paths: empty, single-chunk, and multi-chunk.
    let (ap, sp) = create_ffi_data_with_row_id(
        writer_generation,
    close_writer_and_cleanup_schema(&filename1, schema_ptr1);
        vec![false],
            Some("H"),
    if batches.is_empty() {
    cleanup_ffi_data(ap1, sp1);
                            None
            Some("D"),
    let (_schema2, schema_ptr2) = create_writer_and_assert_success(&filename2);
        vec![10, 20, 30, 40, 50, 60, 70, 80],
    // Default bloom filter is enabled
            Some("D"),
    )
        .parent()
    NativeParquetWriter::create_writer(
    cleanup_ffi_schema(schema_ptr);
    assert_eq!(stored_after.get_bloom_filter_enabled(), false);
    );
    expected_sorted.sort();
        0,
    assert_eq!(missing_ids, vec![4, 5]);
    assert_eq!(success_count.load(Ordering::SeqCst), thread_count);
    NativeParquetWriter::finalize_writer(unsorted_file.clone()).unwrap();
            .unwrap();
    let names: Vec<Option<&str>> = (0..10).map(|_| Some("x")).collect();
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    // Verify permutation
    }
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    assert_eq!(mapping.len(), 10);
    let ids = sorted
}
        filename.clone(),
        index_name.to_string(),
    .unwrap();
        .contains("Invalid FFI addresses"));
    assert_eq!(
        filename.clone(),
    );
    // fresh writer is created in its place. (This is what unblocks shard recovery after a failure
        0,
    let (_temp_dir, filename) = get_temp_file_path("chunked_empty.parquet");
        handles.push(handle);
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    let expected: Vec<i64> = (0..9).collect();
    let file = File::open(filename).unwrap();
    let (ap1, sp1) = create_ffi_data_with_row_id(
        .as_any()
    let ages = read_nullable_ages_from_parquet(&filename);
        vec!["age".to_string()],
        let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    settings.reverse_sorts = vec![true]; // descending
    let mut settings = NativeSettings::default();
        vec![Some("C"), Some("A"), Some("B")],
    assert_ne!(
#[test]
        index_name.to_string(),
            "tags",
        vec![false],
                            }
    let unsorted_ids = read_parquet_file_sorted_ids(&unsorted_file);
        create_test_ffi_data_with_ids(vec![30, 10, 20], vec![Some("C"), Some("A"), Some("B")])
    let batch = RecordBatch::try_new(
        vec![Some("C"), Some("X"), Some("A"), Some("Y"), Some("B")],
    // Verify sequential row IDs
    let mut handles = vec![];
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
// ===== Writer generation tests =====
        0,
        vec![],
                vec!["id".to_string()],
        schema_ptr2,
// with each piece flushed independently.
    let row_id_array: Arc<dyn Array> = Arc::new(Int64Array::from(row_ids));
/// Helper: creates FFI data with nullable age + __row_id__.
    assert_eq!(
    settings.reverse_sorts = vec![false];
    settings.sort_columns = vec!["age".to_string()];
    use arrow::compute::concat_batches;
        vec![false],
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        index_name.to_string(),
    }
// fn test_sort_large_file_permutation_maps_original_row_ids() {
}
            Some("G"),
    if metadata.num_row_groups() == 0 {
    .unwrap();
        create_test_ffi_data_with_ids(vec![50, 10], vec![Some("E"), Some("A")]).unwrap();
    SETTINGS_STORE.remove(index_name);
        vec![],
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
        vec![0, 1, 2, 3, 4],
        row_ids, expected_sequential,
    )
    // Permutation must be a valid bijection of 0..4
/// in the MULTI CHUNK path (k-way merge).
        schema_ptr,
        vec![0, 1, 2, 3, 4],
    let ages = read_ages_from_parquet(&filename);
    // Three non-null rows whose MAX element orders them differently than MIN would:
        has_bloom_filter_in_parquet(&filename),
        vec!["age".to_string()],
        schema_ptr,
        .unwrap()
}
    let mut settings = NativeSettings::default();
            }
    SETTINGS_STORE.remove(index_name);
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        offsets.push(values.len() as i32);
            Some("G"),
    .unwrap();
        vec![],
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    // Configure with large threshold so everything fits in one chunk
        vec!["age".to_string()],
        vec![false],
        .parent()
    // No permutation
    );
}
fn test_nulls_first_true_ascending() {
        &[
        filename.clone(),
}
        &["tags".to_string()],
    assert_eq!(
    assert_eq!(sorted_ages, vec![0, 11, 22, 33, 44, 55, 66, 77, 88, 99]);
    let result = NativeParquetWriter::create_writer(
            .join(format!("concurrent_write_{}.parquet", i));
        "IPC path should support descending sort"
        .unwrap();
}
        Field::new("id", DataType::Int64, false),
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
            &["tags".to_string()],
    use arrow::datatypes::{DataType, Field, Schema};
        compression
/// Test: CRC32 is non-zero and matches file content for single-chunk sorted output.
        vec!["age".to_string()],
            .column(0)
    settings.compression_type = Some("UNCOMPRESSED".to_string());
        let n = file.read(&mut buf).unwrap();
fn test_empty_batch_write_does_not_corrupt_sorted_writer() {
            Some("I"),
#[test]
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    // Verify __row_id__ is sequential 0..N
        .to_string_lossy()
fn test_concurrent_writes_same_file() {
    assert_eq!(
#[test]
// }
    let mem_before =
/// Helper: creates FFI data with nullable age column.
    // Verify bloom filter IS present
        vec![],
        vec![40, 20, 60],
    assert!(
    settings.sort_columns = vec!["age".to_string()];
    let (_temp_dir2, unsorted_file) = get_temp_file_path("parquet_unsorted.parquet");
        vec![0, 1, 2],
    let mapping = finalize_result
                    vec![Some("C"), Some("A"), Some("B")],
        ids,
    use arrow::compute::concat_batches;
    // Expected: age ASC, then score DESC within same age
    let row_ids = read_row_ids_from_parquet(&filename);
        matches!(compression, parquet::basic::Compression::SNAPPY),
    let scores = read_scores_from_parquet(&filename);
fn test_sort_all_identical_keys_produces_valid_permutation() {
    let mut ipc_writer = IpcFileWriter::try_new(file, &schema).unwrap();
        vec![],
    let (_temp_dir, filename) = get_temp_file_path("ipc_dup.parquet");
            Some("C"),
        schema_ptr,
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    assert!(NativeParquetWriter::cleanup_writer(&filename).is_ok());
        kvs.iter()
    let ages = read_ages_from_parquet(&filename);
    let result1 = NativeParquetWriter::finalize_writer(filename.clone());
use crate::native_settings::NativeSettings;
            .unwrap();
    settings.sort_in_memory_threshold_bytes = Some(64);
/// Helper: reads a Parquet file and returns the "age" column values as i32.
    settings.sort_columns = vec!["age".to_string()];
    settings.nulls_first = vec![true]; // NULLs first
    let (_temp_dir, filename) = get_temp_file_path("multi_sort_slice.parquet");
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    SETTINGS_STORE.remove(index_name);
    let (_schema2, schema_ptr2) = create_writer_and_assert_success(&filename2);
    );
        0,
    );
        vec![false],
        num_rows - 1
    let ages = read_ages_from_parquet(&filename);
    let (ap, sp) = create_ffi_data_with_row_id(
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024); // Large threshold — single chunk
    settings.sort_columns = vec!["age".to_string(), "score".to_string()];
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    );
    )
    scores: Vec<i32>,
    assert_ne!(
        vec![99, 88, 77],
    // CRC should still be valid
    let index_name = "test-props-single-uncompressed";
        assert_eq!(values, expected_values.as_slice());
        index_name.to_string(),
    let result = NativeParquetWriter::create_writer(
        schema_ptr1,
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
        vec![],
        let success_count = Arc::clone(&success_count);
    let index_name = "test-bloom-false-index-unique1";
        Some(99),
        vec![
    let index_name = "test-crc-single";
    let file = File::open(filename).unwrap();
        "Output should be sorted ascending"
            Some("F"),
    );
    settings.nulls_first = vec![false];
    // Verify output is sorted
        0,
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
fn test_writer_properties_honored_multi_chunk_snappy_no_bloom() {
    settings.sort_in_memory_threshold_bytes = Some(64); // Tiny — forces multiple chunks
    settings.nulls_first = vec![false];
        mem_after
        let success_count = Arc::clone(&success_count);
        Field::new("name", DataType::Utf8, true),
        ids,
        matches!(compression, parquet::basic::Compression::UNCOMPRESSED),
        row_ids, expected_sequential,
    assert!(result.is_err());
    SETTINGS_STORE.remove(index_name);
    assert_eq!(mapping, vec![4, 0, 2, 3, 1]);
        ],
            }
    assert_eq!(
    let (ap, sp) = create_ffi_data_multi_sort(
    settings.sort_in_memory_threshold_bytes = Some(64); // Force multiple chunks
    (schema, schema_ptr)
        schema_ptr,
    cleanup_ffi_schema(schema_ptr1);
        ])),
    let row_ids = read_row_ids_from_parquet(&filename);
    // Verify bloom filter IS present
/// Test: Writer properties (SNAPPY compression, bloom filter disabled) are honored
        NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let result = NativeParquetWriter::finalize_writer(filename.clone());
    settings.nulls_first = vec![false];
                if NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr)
            Arc::new(build_nullable_string_list(&input_rows)) as ArrayRef,
        "Output should be globally sorted across sliced multi-write batches"
    for _ in 0..3 {
    for i in 0..10 {
        vec![],
        vec![false],
#[test]
    cleanup_ffi_data(ap1, sp1);
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
/// Test: Writer properties are honored in the EMPTY path (0 chunks).
    settings.reverse_sorts = vec![false];
    settings.nulls_first = vec![false];
    // Create one IPC writer (sorted) and one Parquet writer (unsorted)
        .to_string()
    let (ap, sp) = create_ffi_data_no_row_id(
    assert_eq!(row_ids, vec![0, 1, 2, 3, 4]);
        vec![],
        "bloom_filter_enabled should remain false after create_writer, but got: {:?}",
        format_version.as_deref(),
    let result = NativeParquetWriter::create_writer(
    NativeParquetWriter::create_writer(
            Some("C"),
        mem_after >= 80,
            .and_then(|kv| kv.value.clone())
fn test_sorted_writer_ascending() {
    settings.reverse_sorts = vec![false];
}
        schema_ptr,
    let actual_crc = compute_file_crc32(&filename);
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        vec![],
        Field::new("age", DataType::Int32, false),
    );
        row_ids, expected_sequential,
    let mut settings = NativeSettings::default();
    let result = NativeParquetWriter::create_writer(
        filename,
        finalize_result.row_id_mapping.is_none(),
        schema,
    assert_eq!(ages, vec![10, 20, 30]);
    let (_temp_dir, filename) = get_temp_file_path("only_empty.parquet");
}
    let (ap, sp) = create_ffi_data_with_row_id(
    );
}
        vec![false],
    let (ap, sp) = create_ffi_data_with_row_id(original_ages.clone(), names, row_ids);
    );
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
    settings.sort_in_memory_threshold_bytes = Some(1); // Per-row slicing
                schema_ptr,
        NativeParquetWriter::sort_batch(&batch, &["tags".to_string()], &[false], &[false], &[true])
        &[false],
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let (ap, sp) =
#[test]
    // Write 10 rows — should be sliced into ~5 chunks of 2 rows each
fn test_chunked_writer_no_row_id_single_chunk() {
    settings.compression_type = Some("SNAPPY".to_string());
    let thread_count = 6;
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
    assert_eq!(
        0,
        schema_ptr,
        vec!["age".to_string()],
            Some("H"),
        "Empty writer should have no row_id_mapping"
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
        vec![
        Some(17),
        filename.clone(),
        schema_ptr,
    let mut settings = NativeSettings::default();
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
/// Test: UNCOMPRESSED setting is honored in single chunk path.
    let index_name = "test-gen-unsorted";
        0,
    // so each row becomes its own chunk.
    assert!(finalize_result.row_id_mapping.is_none());
    );
    let ages = read_ages_from_parquet(&filename);
// ===== nulls_first behavior test =====
    assert_eq!(&ids[..4], &[2, 3, 6, 1]);
    let (_schema, schema_ptr2) = create_row_id_schema_ptr();
    (array_ptr, schema_ptr)
    NativeParquetWriter::create_writer(
        0,
    SETTINGS_STORE.remove(index_name);
    );
    );
        !has_bloom_filter_in_parquet(&filename),
    // First batch: rows 0..4
#[test]
            Some("B"),
        filename.clone(),
            Some("D"),
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        0,
    settings.nulls_first = vec![false];
// ===== Sort stability edge case =====
    let mem_final = NativeParquetWriter::get_filtered_writer_memory_usage(path_prefix).unwrap();
#[test]
        0,
        index_name.to_string(),
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
        let (missing, values) = if nulls_first {
        .to_string_lossy()
        .to_string()
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        vec![0, 1, 2, 3, 4],
    for batch_ids in [vec![50, 30], vec![10, 40], vec![20, 60]] {
    permutation.sort_unstable();
                );
        "Output should be sorted by age DESC with batch slicing"
        });
#[test]
    SETTINGS_STORE.insert(index_name1.to_string(), settings.clone());
    }
    }
    let (_temp_dir, filename) = get_temp_file_path("props_defaults_multi.parquet");
    settings.nulls_first = vec![false, false];
        "Empty path should stamp writer_generation in output file"
    let (ap2, sp2) = create_ffi_data_with_row_id(
        "__row_id__ should be sequential 0..7"
        index_name.to_string(),
        "Output should be sorted by age ASC even without __row_id__"
    )
    assert!(result.unwrap() >= 0);
    assert!(result.is_ok(), "create_writer failed: {:?}", result.err());
fn create_no_row_id_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
    SETTINGS_STORE.remove(index_name);
    settings.bloom_filter_enabled = Some(true);
    loop {
    assert_eq!(
    let (_schema, schema_ptr) = create_nullable_schema_ptr();
    .unwrap();
            Some("F"),
        vec![0, 1, 2],
    );
    let (_temp_dir, filename) = get_temp_file_path("gen_single.parquet");
    NativeParquetWriter::create_writer(
    )
    )
    let expected_mapping: Vec<i64> = vec![8, 4, 0, 6, 2, 3, 9, 1, 5, 7];
    );
/// Test: Multiple write_data calls with small threshold — verifies that data
        schema_ptr,
    assert_eq!(success_count.load(Ordering::SeqCst), file_count * 2);
            .and_then(|kv| kv.value.as_ref())
    )
    assert_eq!(read_metadata.file_metadata().num_rows(), 6);
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        index_name.to_string(),
        vec![Some(30), None, Some(10), None, Some(20)],
        vec![Some("F"), Some("G"), Some("H"), Some("I"), Some("J")],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    use arrow::datatypes::{DataType, Field, Schema};
    )
/// Helper: creates FFI schema with (age: Int32, score: Int32, name: Utf8, __row_id__: Int64).
    let (ap2, dp2) =
    );
        vec![false],
        schema_ptr,
    // age=30: score=20, score=40 (ASC)
    ipc_writer.write(&batch).unwrap();
    let mem1 = NativeParquetWriter::get_filtered_writer_memory_usage(prefix1).unwrap();
    // Verify CRC is valid
        .unwrap();
    let num_rows = 50i32;
        hasher.update(&buf[..n]);
    assert!(result.unwrap_err().to_string().contains("Writer not found"));
    let gen = read_writer_generation_from_parquet(&filename);
        cleanup_ffi_data(ap, sp);
fn test_nulls_first_false_ascending() {
        finalize_result.crc32, actual_crc,
#[test]
    settings.bloom_filter_enabled = Some(true);
        vec!["age".to_string(), "score".to_string()],
    let (_temp_dir, filename) = get_temp_file_path("no_rowid_slice.parquet");
    );
    NativeParquetWriter::create_writer(
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let original_ages = vec![90, 10, 70, 30, 50, 80, 20, 60, 40, 100];
    assert_eq!(mapping, vec![7, 1, 5, 3, 0, 8, 4, 2, 6]);
    );
    )
            Some("B"),
            Some("A"),
/// Helper: creates FFI schema pointer for a schema WITHOUT __row_id__ (age: Int32, name: Utf8).
        vec![Some("C"), Some("X"), Some("A"), Some("Y"), Some("B")],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        "__row_id__ should be sequential 0..9"
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        vec![0, 1, 2, 3, 4, 5, 6, 7],
    // 10 rows with many ties in age to stress tie-breaking across chunks
        vec![0, 1, 2],
fn test_nulls_last_with_row_id_and_permutation() {
fn test_memory_usage_path_prefix_filtering() {
    assert!(finalize_result.row_id_mapping.is_none());
    settings.reverse_sorts = vec![false];
        ],
    )
    assert_eq!(row_ids, expected_sequential);
) -> (i64, i64) {
        Some(vec![None, Some("beta")]),
    let ages = read_ages_from_parquet(&filename);
            i, ages[i], new_pos
    let index_name = "test-mem-ipc";
    // Sorted:   age=[10,20,30,40,50,60]
    // Creating a second writer for the same file must NOT error: the stale entry is removed and a
            let strings = values.as_any().downcast_ref::<StringArray>().unwrap();
    let sorted_ages = read_ages_from_parquet(&filename);
        vec!["age".to_string()],
    // Write a real batch after the empty one
        NativeParquetWriter::has_writer(&filename),
        vec![Some("E"), Some("A"), Some("C"), Some("B"), Some("D")],
    // First batch: row_ids 0..4
    let gen = read_writer_generation_from_parquet(&filename);
#[test]
#[test]
fn test_sort_batch_uses_maximum_list_element_when_mode_max() {
    );
        RecordBatch::try_new(schema.clone(), vec![age_array, name_array, row_id_array]).unwrap();
    NativeParquetWriter::write_data(filename2.clone(), ap2, sp2).unwrap();
        Field::new("age", DataType::Int32, false),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        vec!["age".to_string()],
    let mut settings = NativeSettings::default();
    use arrow::array::{Array, Int32Array, Int64Array, StringArray};
    .unwrap();
        vec![10, 50, 30, 20, 40],
    settings.bloom_filter_enabled = Some(true);
    .unwrap();
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
/// TODO: Fix merge_sorted to accept and propagate writer_generation.
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    (0..col.len()).map(|i| col.value(i)).collect()
    assert_eq!(
    ]));
    assert!(
        schema_ptr,
    .unwrap();
    // With eager sort-and-write, no staging file exists until a chunk is flushed.
fn test_chunked_writer_batch_slicing_multiple_writes() {
    SETTINGS_STORE.remove(index_name);
        vec![],
    );
    sorted_mapping.sort();
    // Don't write any data — triggers the empty path
        vec![30, 10, 20],
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
        .as_any()
/// Returns (array_ptr, schema_ptr) for use with write_data.
        filename.clone(),
fn test_memory_usage_ipc_writer_reports_chunk_row_ids() {
            Some("F"),
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        "writer_generation should be in metadata for unsorted writer too"
    // Sorted file should be sorted
    cleanup_ffi_schema(schema_ptr);
#[test]
    // Writer 2 — different data
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
#[test]
    // Finalize and verify writer is removed
    // Format version always stamped
    let ages = read_ages_from_parquet(&filename);
    ];
    cleanup_ffi_schema(schema_ptr);
    use arrow::datatypes::{DataType, Field, Schema};
        vec![30, 10, 50, 20, 40],
        vec![true],
                vec![],
fn test_finalize_writer_with_data_returns_correct_metadata() {
        gen,
                DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    );
        vec![0, 1, 2, 3, 4, 5],
    );
    settings.sort_columns = vec!["age".to_string()];
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    settings.compression_type = Some("UNCOMPRESSED".to_string());
    assert_eq!(format_version.as_deref(), Some("1.0.0.0"));
    for row in rows {
    let result = NativeParquetWriter::write_data(filename.clone(), 0, 0);
            .and_then(|v| v.parse::<i64>().ok())
        ],
fn test_chunked_writer_generation_zero() {
    let index_name = "test-slice-large";
    assert_eq!(success_count.load(Ordering::SeqCst), 1);
    settings.nulls_first = vec![false];
            Some("C"),
    .unwrap();
    let index_name = "test-chunked-multi-write";
        ),
        .unwrap()
    // Sorted:   age=[NULL, NULL, 10, 20, 30]
    let (_temp_dir, filename) = get_temp_file_path("multi_write_ffi.parquet");
        vec!["age".to_string()],
fn test_writer_properties_honored_single_chunk_snappy_no_bloom() {
    );
            return true;
        .unwrap();
                        if metadata.metadata.file_metadata().num_rows() == 3 {
            "original_ages[{}]={} should be at sorted position {}, but found {}",
        schema_ptr,
    let mut settings = NativeSettings::default();
        create_test_ffi_data_with_ids(vec![10, 30, 20], vec![Some("A"), Some("C"), Some("B")])
    );
    let (_temp_dir, filename) = get_temp_file_path("bloom_default.parquet");
    let batch = RecordBatch::try_new(
    assert_eq!(mapping.len(), num_rows as usize);
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    let result = NativeParquetWriter::create_writer(
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    // Original order: (30,50), (20,80), (30,90), (20,40), (10,70), (30,10)
}
use std::path::Path;
    assert!(file_path.metadata().unwrap().len() > 0);
        .expect("__row_id__ column should exist");
        "Output should be sorted by age ASC even with per-row slicing"
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    let row_ids = read_row_ids_from_parquet(&filename);
    assert_eq!(ages, vec![10, 20, 30, 40, 50, 60, 70, 80, 90]);
    row_ids: Vec<i64>,
        .unwrap();
    .unwrap();
    assert_eq!(descending_missing, vec![30, 40, 60]);
    let index_name2 = "test-crc-diff2";
    let schema = Arc::new(Schema::new(vec![
        vec![],
            Some("G"),
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
        ),
    let (ap1, dp1) =
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        Field::new("age", DataType::Int32, false),
    assert_eq!(mapping, vec![2, 0, 1]);
    )
#[test]
    use arrow::record_batch::RecordBatch;
        let (ap, sp) = create_ffi_data_with_row_id(vec![], vec![], vec![]);
        let handle = thread::spawn(move || {
        Field::new("id", DataType::Int64, false),
    let (_temp_dir, filename) = get_temp_file_path("ipc_has_writer.parquet");
        matches!(compression, parquet::basic::Compression::ZSTD(_)),
    )
    close_writer_and_cleanup_schema(&filename, schema_ptr);
            None => validity.push(false),
        ],
    );
        "__row_id__ should be sequential 0..{}",
        let handle = thread::spawn(move || {
    assert!(
        vec![false],
/// Helper: creates FFI data with a schema that includes __row_id__ column.
    settings.sort_columns = vec!["age".to_string()];
            DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
    NativeParquetWriter::write_data(sorted_file.clone(), ap1, dp1).unwrap();
        vec![],
        vec![false, false],
        .unwrap()
// These tests verify that writer properties (compression, bloom filter, format version,
    // mapping[6]=2(30→pos2), mapping[7]=4(50→pos4)
    SETTINGS_STORE.remove(index_name);
    );
    let index_name = "test-slice-two";
    let (_temp_dir, filename) = get_temp_file_path("multi_sort_desc_asc.parquet");
/// Helper: creates an IPC file with (age: Int64, __row_id__: Int64) columns.
    NativeParquetWriter::write_data(filename2.clone(), array_ptr, data_schema_ptr).unwrap();
    // Row IDs must be sequential 0..N regardless of tie-breaking
        index_name.to_string(),
    settings.reverse_sorts = vec![false];
    );
    cleanup_ffi_schema(schema_ptr);
/// Test: Default writer properties are applied in multi chunk path.
}
        vec![Some("C"), Some("X"), Some("A"), Some("Y"), Some("B")],
    assert_eq!(
    cleanup_ffi_data(array_ptr, data_schema_ptr);
    );
        .unwrap()
    let mut settings = NativeSettings::default();
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    // Plus a null-list row (id=40) which must sort last (nulls-last).
// TODO: Re-enable when sort_small_file/sort_large_file are uncommented
    // Verify correctness: original_ages[i] at sorted position mapping[i]
        Field::new(
    .unwrap();
    cleanup_ffi_schema(schema_ptr2);
        vec![false],
        NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr).unwrap();
        "Multi chunk path should honor bloom_filter_enabled=true"
    let schema = Arc::new(Schema::new(vec![
        vec![false],
    );
        vec![30, 20, 10],
    use arrow::datatypes::{DataType, Field};
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
            Arc::new(Int64Array::from(vec![10, 20, 30, 40])) as ArrayRef,
                    row_values
    assert!(result
        .unwrap()
    settings.reverse_sorts = vec![false];
            Some("G"),
    let missing_values = ids[4..]
        Field::new("name", DataType::Utf8, true),
        vec![false],
    close_writer_and_cleanup_schema(&filename, schema_ptr);
#[test]
/// Test: writer_generation is preserved for unsorted (direct Parquet) writer path.
        let ids = (0..ids.len()).map(|row| ids.value(row)).collect::<Vec<_>>();
    let (ap, sp) = create_ffi_data_with_row_id(
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
        vec![],
            Some("E"),
    NativeParquetWriter::create_writer(
fn test_create_writer_success() {
    let mut settings = NativeSettings::default();
        vec![false],
/// Test: Batch slicing with descending sort — verifies slicing doesn't break sort direction.
    NativeParquetWriter::create_writer(
        vec![Some("A"), Some("B"), Some("C"), Some("D"), Some("E")],
            Some("C"),
        Field::new("score", DataType::Int32, false),
        .expect("Should have row_id_mapping");
        vec!["tags".to_string()],
        "CRC should match file content after batch slicing"
    let mut settings = NativeSettings::default();
        "Mapping should be a valid permutation"
        Field::new(
        ages,
        .unwrap();
/// Should sort correctly and return no permutation mapping.
    // Verify descending sort
use crate::writer::NativeParquetWriter;
    // Query with prefix that matches only writer 1's directory
    // Original: row0=age30, row1=NULL, row2=age10, row3=NULL, row4=age20
        vec![false],
fn test_ipc_and_parquet_writers_coexist() {
            Some("E"),
        vec!["age".to_string()],
    assert!(!NativeParquetWriter::has_writer(&filename));
fn test_writer_properties_honored_multi_chunk_zstd_with_bloom() {
// 1. Row IDs are sequential 0..N in each chunk and in the final output
    cleanup_ffi_schema(schema_ptr);
    // mapping[0]=7(80→pos7), mapping[1]=1(20→pos1), mapping[2]=5(60→pos5),
    (array_ptr, schema_ptr)
    let mut settings = NativeSettings::default();
    assert_eq!(mapping.len(), 9);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let ages = read_ages_from_parquet(&filename);
    let actual_crc = compute_file_crc32(&filename);
/// - The mapping correctly maps each original row to its output position
        );
        vec!["age".to_string()],
            Some("D"),
            cleanup_ffi_schema(schema_ptr);
    let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
                0,
            Some("z"),
    let (_temp_dir, filename) = get_temp_file_path("test.parquet");
        .unwrap();
        match row {
            .path()
            {
    assert!(close_result.is_ok());
        .unwrap()
        ],
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    )
/// Test: A single large batch that exceeds the memory threshold is sliced and produces
            if lists.is_null(row) {
        vec![],
        vec![false],
        vec![Some("A"), Some("E"), Some("C"), Some("B"), Some("D")],
    let (ap1, sp1) = create_ffi_data_with_row_id(
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        Field::new("name", DataType::Utf8, true),
        vec![],
        });
    ]));
    let file = File::create(&ipc_path).unwrap();
    // Verify sort correctness
        filename.clone(),
        (true, false, vec![4, 5]),
        .map(|row| ascending_ids.value(row))
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
    let (_temp_dir, filename) = get_temp_file_path("slice_two.parquet");
        vec![Some("X"), Some("Y"), Some("Z")],
    )
        let filename = file_path.to_string_lossy().to_string();
        vec!["age".to_string()],
    );
    let (ap3, sp3) =
        .to_string_lossy()
#[test]
    // Non-nulls ascending first, then NULLs last
    assert_eq!(
        index_name.to_string(),
        .unwrap();
    let (_temp_dir, filename) = get_temp_file_path("write_success.parquet");
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
}
        row_ids, expected_sequential,
    let batches = read_parquet_file(filename);
    let metadata = reader.metadata().file_metadata();
    let (ap, sp) = create_ffi_data_with_row_id(
    let (ap, sp) = create_ffi_data_with_row_id(
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
#[test]
    let mut sorted_mapping = mapping.clone();
    if batches.is_empty() {
    assert_eq!(ages, vec![30, 10, 20]);
#[test]
    let compression = read_compression_from_parquet(&filename);
            Some("A"),
    let index_name = "test-chunked-single";
    assert_eq!(row_ids, expected_sequential);
// Concurrency tests
        vec![],
    );
        index_name: Some(index_name.to_string()),
            }
    let mut settings = NativeSettings::default();
/// Test: Sort by age DESC, then score ASC — both columns with different directions.
                            Some(strings.value(index).to_string())
        .column(combined.schema().index_of("id").unwrap())
    assert!(result.is_err());
fn test_ipc_staging_empty_data_produces_valid_parquet() {
    // mapping[9]=2 (age=15→pos2)
        vec!["age".to_string()],
    NativeParquetWriter::create_writer(
fn test_concurrent_writer_creation() {
    settings.reverse_sorts = vec![false]; // ASC
/// written across multiple batches is correctly sorted and has sequential row IDs.
    assert_eq!(ids.value(3), 40, "null-list row sorts last with nulls-last");
    let (_schema1, sp1) = create_sorted_writer_and_assert_success(&sorted_file, "id", false);
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    cleanup_ffi_data(array_ptr, data_schema_ptr);
    let index_name1 = "test-crc-diff1";
        vec![0, 1, 2, 3, 4],
        NativeParquetWriter::get_filtered_writer_memory_usage(path_prefix.clone()).unwrap();
        vec![],
    settings.sort_columns = vec!["age".to_string()];
    settings.nulls_first = vec![false];
        schema_ptr,
    if batches.is_empty() {
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        0,
    }
    settings.reverse_sorts = vec![false]; // ASC
            Arc::new(Int64Array::from(vec![0, 1, 2, 3, 4, 5])) as ArrayRef,
// does NOT contain a __row_id__ column. In this case, flush_and_sort_chunk should
        metadata.crc32, 0,
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
        vec!["age".to_string()],
    let (_temp_dir, filename) = get_temp_file_path("chunked_multi.parquet");
    // Verify data is sorted
    ]));
    // Default compression is LZ4_RAW
    cleanup_ffi_schema(schema_ptr);
    settings.reverse_sorts = vec![false];
    cleanup_ffi_data(ap1, sp1);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    assert_eq!(row_ids, expected);
    use arrow::array::{Array, Int32Array, Int64Array, StringArray};
    // Verify permutation correctness:
            .collect::<Vec<_>>(),
    let (_temp_dir, filename) = get_temp_file_path("props_empty.parquet");
        vec![],
        vec![10, 20, 30],
            ages[new_pos], original_ages[i],
    settings.reverse_sorts = vec![false];
    NativeParquetWriter::create_writer(
        mapping,
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024); // Large — single chunk
    let mut settings = NativeSettings::default();
    // mapping[0]=7(80→pos7), mapping[1]=1(20→pos1), mapping[2]=5(60→pos5),
        filename.clone(),
}
}
        vec![
    settings.sort_in_memory_threshold_bytes = Some(64);
    cleanup_ffi_schema(schema_ptr2);
    NativeParquetWriter::create_writer(
        "Memory should be at least 10 rows × 8 bytes = 80, got {}",
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    let (_temp_dir, filename) = get_temp_file_path("chunked_large.parquet");
/// Test: Sorted writer without __row_id__ column — single chunk.
            Some("F"),
    NativeParquetWriter::create_writer(
    cleanup_ffi_data(ap2, sp2);
    settings.nulls_first = vec![false, false];
        0,
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        vec![],
    // Data correctness is still maintained
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
}
    let (_temp_dir, filename1) = get_temp_file_path("test1.parquet");
        0,
// These tests verify that the sorted chunked writer works correctly when the schema
            Some("D"),
    .unwrap();
        Box::into_raw(Box::new(ffi_array)) as i64,
    );
        vec!["age".to_string()],
    )
        vec![0, 1, 2, 3, 4],
}
// ===== Batch slicing path tests =====
    assert_eq!(
        vec!["age".to_string(), "score".to_string()],
}
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        filename2.clone(),
            Some("B"),
            Some("G"),
    // mapping[0]=8, mapping[1]=4, mapping[2]=0, mapping[3]=6, mapping[4]=2
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        filename.clone(),
        Arc::new(StringArray::from(values)),
        Arc::new(StringArray::from(vec![
    NativeParquetWriter::create_writer(
        vec!["age".to_string()],
            Some("F"),
    NativeParquetWriter::create_writer(
            Some("D"),
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
        schema_ptr,
    SETTINGS_STORE.remove(index_name2);
    settings.reverse_sorts = vec![false];
    // Verify sorted output
    let index_name = "test-nulls-first-true";
    // Verify globally sorted
    let format_version = read_format_version_from_parquet(&filename);
        index_name.to_string(),
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    use arrow::array::Int64Array;
#[test]
    )
    SETTINGS_STORE.remove(index_name);
            Some("A"),
    let compression = read_compression_from_parquet(&filename);
    let index_name = "test-empty-batch";
        assert_eq!(
        Some(vec![]),
    .unwrap();
            Some("D"),
    let (ap, sp) = create_ffi_data_with_row_id(
                        if strings.is_null(index) {
        0,
    let ages = read_nullable_ages_from_parquet(&filename);
    use arrow::record_batch::RecordBatch;
    for _ in 0..3 {
    SETTINGS_STORE.remove(index_name);
    let (ap2, sp2) =
    let (_temp_dir, filename) = get_temp_file_path("bloom_test.parquet");
            .unwrap();
    let temp_dir = tempdir().unwrap();
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        schema,
    use arrow::datatypes::{DataType, Field, Schema};
    let schema = Arc::new(Schema::new(vec![
fn build_nullable_string_list(rows: &[Option<Vec<Option<&str>>>]) -> arrow::array::ListArray {
        vec![false],
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
fn test_chunked_writer_single_chunk_row_ids_sequential() {
    let (_temp_dir, filename) = get_temp_file_path("slice_desc.parquet");
        vec!["age".to_string()],
    assert_eq!(
    let index_name = "test-mem-prefix";
    let (ap1, sp1) =
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
            }
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
        vec![false],
    SETTINGS_STORE.remove(index_name);
/// Test: get_filtered_writer_memory_usage with path prefix filtering.
use std::sync::Arc;
}
    let index_name = "test-multi-sort-slice";
/// This ensures the writer doesn't silently fall back to a default compression.
            let (_schema, schema_ptr) = create_test_ffi_schema();
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    let (_temp_dir, filename) = get_temp_file_path("crc_single.parquet");
}
fn test_sort_batch_uses_minimum_list_element() {
        "Multi chunk path should stamp format version"
    let original_ages = vec![55, 22, 88, 11, 44, 77, 33, 66, 99, 0];
        vec![30, 10, 50, 20, 40],
            .unwrap();
    // Verify permutation
    );
    assert_eq!(
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
        Path::new(&filename).exists(),
        index_name.to_string(),
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
/// are sequential in the final merged output and permutation is correct.
    let file_path = Path::new(&filename);
                cleanup_ffi_data(ap, sp);
        mapping, expected_mapping,
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
}
    //   b(30) < n(20) < z(10), then null(40).
        vec![80, 20, 60, 40, 10, 70, 30, 50],
            Some("B"),
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
        .expect("Should have row_id_mapping");
    let mut settings = NativeSettings::default();
        vec![true],
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
        cleanup_ffi_data(array_ptr, data_schema_ptr);
            (&ids[..3], &ids[3..])
            let values = lists.value(row);
            Some("I"),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
            Some("J"),
        filename.clone(),
        vec![false, true],
    settings.reverse_sorts = vec![false];
}
        .unwrap()
                                success_count.fetch_add(1, Ordering::SeqCst);
        .unwrap();
        schema_ptr,
    SETTINGS_STORE.remove(index_name);
    settings.nulls_first = vec![false, false];
}
        "Default compression should be LZ4_RAW, got: {:?}",
        vec![],
        vec![false],
    // Verify sequential row IDs
    NativeParquetWriter::create_writer(
    // age=20: score=80, score=40 (DESC)
    NativeParquetWriter::create_writer(
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    // age=30: score=90, score=50, score=10 (DESC)
    let col = combined
        vec![],
        vec!["age".to_string()],
    let (_temp_dir, filename) = get_temp_file_path("props_defaults_single.parquet");
    let (_schema, schema_ptr) = create_no_row_id_schema_ptr();
            Some("A"),
        sorted_mapping, expected_sequential,
    settings.nulls_first = vec![false, false];
        vec![false],
        .as_any()
    let mut settings = NativeSettings::default();
    settings.sort_columns = vec!["age".to_string()];
    use parquet::file::reader::{FileReader, SerializedFileReader};
    );
            .as_primitive::<arrow::datatypes::Int64Type>();
        .as_primitive::<arrow::datatypes::Int64Type>();
    .unwrap();
    );
    NativeParquetWriter::write_data(filename1.clone(), ap1, sp1).unwrap();
        vec![
    // Verify sorted output
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let success_count = Arc::new(AtomicUsize::new(0));
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
    );
    let actual_crc = compute_file_crc32(&filename);
            Arc::new(Int64Array::from(ages.to_vec())),
        vec![false],
fn test_get_filtered_writer_memory_usage_with_writers() {
    settings.compression_type = Some("SNAPPY".to_string());
            Some("E"),
    // Original row_ids: 4, 1, 3, 2, 0, 5
    let (_temp_dir, filename) = get_temp_file_path("invalid_ffi.parquet");
    assert!(NativeParquetWriter::has_writer(&filename));
/// in the SINGLE CHUNK path.
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
    cleanup_ffi_data(array_ptr, data_schema_ptr);
        filename.clone(),
        .index_of("score")
    let (_temp_dir, filename) = get_temp_file_path("test.parquet");
    let metadata = reader.metadata();
        vec![10, 50, 30, 20, 40, 60],
    // Verify __row_id__ is sequential 0..N
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
        vec![60, 50, 40, 30, 20, 10],
                true,
        "Multiple IPC batches should be sorted correctly"
/// Runs the full sort permutation test for either sort_small_file or sort_large_file.
        "File should have at least one row group"
        "test-index".to_string(),
#[test]
        Some(false),
        vec![],
        Field::new("id", DataType::Int64, false),
    // mapping[0]=4, mapping[1]=1, mapping[2]=3, mapping[3]=2, mapping[4]=0, mapping[5]=5
use tempfile::tempdir;
    // Verify it matches the actual file
        vec![false],
    .unwrap();
    settings.nulls_first = vec![false];
    use arrow::record_batch::RecordBatch;
#[test]
        vec![],
        vec![false],
    let writer_generation = 55i64;
    let schema = Arc::new(Schema::new(vec![
        vec![],
        &batch,
        .column(batch.schema().index_of(column).unwrap())
    );
}
            Some("I"),
    let index_name = "test-gen-multi";
    let expected_sequential: Vec<i64> = (0..10).collect();
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
        filename.clone(),
    settings.reverse_sorts = vec![false];
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let (ap, sp) = create_ffi_data_with_row_id(
        vec!["age".to_string()],
        ],
        });
    let (ap1, sp1) = create_ffi_data_with_row_id(
        vec![],
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    assert_eq!(ages, vec![Some(10), Some(20), Some(30), None, None]);
        index_name.to_string(),
}
    // Data correctness
    );
}
    // Verify permutation is valid
    }
}
    .unwrap();
    drop(stored);
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let metadata = reader.metadata();
    let (ap, sp) = create_ffi_data_with_row_id(
        row_ids,
        vec![],
                success_count.fetch_add(1, Ordering::SeqCst);
fn run_sort_permutation_test(_use_large_file: bool, _label: &str) {
 */
    // Original: age=[10,50,30,20,40], row_ids=[0..4]
    let result = NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr);
    // Default bloom filter is enabled
    )
                filename.clone(),
#[test]
    let (ap, sp) = create_ffi_data_with_row_id(
        vec![false],
            Some("E"),
    // Original: age=[30, NULL, 10, NULL, 20], row_ids=[0,1,2,3,4]
                    }
        vec![50, 40, 30, 20, 10],
    settings.reverse_sorts = vec![false];
        vec!["age".to_string()],
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    // Original: age=[80,20,60,40,10,90,50,30,70], row_ids=[0..8]
    let stored_after = SETTINGS_STORE.get(index_name).unwrap();
    let ages: Vec<i32> = (0..num_rows).map(|i| (i * 7 + 13) % 100).collect();
/// Test: Writing only empty batches produces a valid empty Parquet file.
    // Original: age=[50,10,30,40,20,60], row_ids=[0,1,2,3,4,5]
// ===== CRC32 tests for sorted chunked writer =====
/// the original row order produces the sorted order.
    // Verify format version
        gen,
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        vec![0, 1, 2, 3, 4],
    );
    let ages = read_nullable_ages_from_parquet(&filename);
    }
    let ids = read_parquet_file_sorted_ids(&filename);
        schema_ptr,
    let (_temp_dir, filename) = get_temp_file_path("empty_batch.parquet");
}
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    cleanup_ffi_data(ap, sp);
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
    cleanup_ffi_schema(schema_ptr);
        Box::into_raw(Box::new(ffi_schema)) as i64,
fn create_test_ipc_file(dir: &Path, ages: &[i64], row_ids: &[i64]) -> String {
    assert_eq!(
    assert_eq!(mem_before, 0, "Memory should be 0 before any chunk flush");
        vec![],
        index_name.to_string(),
    //   id=20 tags=["m","n"] -> MAX="n"
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
        ],
    NativeParquetWriter::create_writer(
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
            Some("I"),
        .expect("age should be Int32");
        handle.join().unwrap();
        .column(idx)
/// in the SINGLE CHUNK path (chunk_paths.len() == 1).
            .find(|kv| kv.key == "opensearch.format_version")
}
/// Test: Large writer_generation value is preserved through the single-chunk sort path.
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    assert!(result.is_err());
        finalize_result.row_id_mapping.is_none(),
        ],
    NativeParquetWriter::create_writer(
    // Finalize without writing any data
    SETTINGS_STORE.remove(index_name);
    for handle in handles {
                        NativeParquetWriter::finalize_writer(filename.clone())
            ]),
/// Test: Multiple chunks forced by small memory threshold — verifies row IDs
#[test]
    SETTINGS_STORE.insert(index_name.to_string(), settings);
/// Test: All rows have identical sort keys. The sort is unstable (sort_unstable_by),
    names: Vec<Option<&str>>,
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    // Verify: original_ages[i] should appear at position mapping[i] in sorted output
        .unwrap()
            Some("H"),
    let mut handles = vec![];
    )
    // Original positions: [6, 2, 9, 4, 1, 8, 3, 7, 0, 5]
    assert_eq!(scores, vec![70, 80, 40, 90, 50, 10]);
            let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    let record_batch = RecordBatch::try_new(
        vec![],
    let expected_sequential: Vec<i64> = (0..10).collect();
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
    );
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    )
    );
        &[false],
use std::fs::File;
        let handle = thread::spawn(move || {
        row_ids, expected_sequential,
    );
    settings.nulls_first = vec![false];
fn create_ffi_data_nullable_age(ages: Vec<Option<i32>>, names: Vec<Option<&str>>) -> (i64, i64) {
        0,
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
            let file_path = temp_dir_path.join(format!("concurrent_{}.parquet", i));
    ]));
    let (ap, sp) =
    NativeParquetWriter::write_data(unsorted_file.clone(), ap2, dp2).unwrap();
    let file = File::open(filename).unwrap();
    );
    // Verify compression is ZSTD
    let mut validity = Vec::with_capacity(rows.len());
            Some("J"),
        ],
    settings.sort_columns = vec!["age".to_string()];
/// in the MULTI CHUNK path (k-way merge).
    let (_temp_dir, filename) = get_temp_file_path("identical_keys.parquet");
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
/// Test: Verifies that the permutation mapping is invertible — applying it to
fn test_writer_properties_honored_single_chunk_zstd_with_bloom() {
                vec![],
fn test_ipc_staging_multi_batch_sort() {
fn test_chunked_writer_multi_chunk_descending_sort() {
}
        "row_id_mapping should be None when schema has no __row_id__ column"
    // mapping[original_row_id] = new_position
        vec![],
        let ids = sorted
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
    );
        matches!(compression, parquet::basic::Compression::LZ4_RAW),
    );
    drop(stored);
    // Verify sorted output — empty batch should have no effect
    assert!(
    assert_eq!(
        ages,
        ],
    let (_temp_dir, filename) = get_temp_file_path("nulls_first_false.parquet");
    );
        compression
        Some(NullBuffer::from(vec![true, true, true, false])),
/// Verifies that partial slices are handled correctly at boundaries.
fn create_ffi_data_nullable_with_row_id(
        handles.push(handle);
    settings.reverse_sorts = vec![false, false]; // both ASC
    );
        .unwrap_err()
        }
    // Expected sort: age ASC first, then score DESC within same age
        ids,
    // cleanup removes the registry entry (dropping the writer) ...
    assert_eq!(scores, vec![20, 40, 30, 50, 60]);
        "Empty writer should produce 0-row Parquet"
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", true);
            Arc::new(Int64Array::from(vec![20, 10])) as ArrayRef,
    );
                Some("z".to_string()),
}
        result1.crc32, result2.crc32,
    assert_eq!(
    use arrow::buffer::OffsetBuffer;
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
 * compatible open source license.
        "__row_id__ should be sequential 0..4"
        .contains("Invalid FFI addresses"));
    SETTINGS_STORE.remove(index_name);
        matches!(compression, parquet::basic::Compression::LZ4_RAW),
    let (_temp_dir, filename) = get_temp_file_path("slice_multi_write.parquet");
    // Verify descending sort
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    // Original: age=[30,10,50,20,40], row_ids=[0,1,2,3,4]
    SETTINGS_STORE.remove(index_name);
    let index_name = "test-crc-multi";
    settings.nulls_first = vec![false]; // NULLs last
    let writer_generation = 33i64;
fn test_chunked_writer_crc32_multi_chunk() {
        create_test_ffi_data_with_ids(vec![30, 10, 50], vec![Some("C"), Some("A"), Some("E")])
    SETTINGS_STORE.remove(index_name);
    }
        vec![
    let mut settings = NativeSettings::default();
    settings.reverse_sorts = vec![false];
    )
            Some("E"),
    assert_eq!(
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
fn test_nulls_first_with_row_id_and_permutation() {
    use arrow::record_batch::RecordBatch;
    // After writing (chunks flushed), memory should be > 0 due to chunk_row_ids
        index_name1.to_string(),
    use arrow::record_batch::RecordBatch;
    );
    );
    use arrow::record_batch::RecordBatch;
    .unwrap();
    .unwrap();
    // Verify permutation
    settings.nulls_first = vec![false];
        Some(NullBuffer::from(vec![true, true, true, false, true, true])),
    );
        .unwrap();
            Some("J"),
#[test]
        vec![Some("C"), Some("A"), Some("B")],
    // age=10: score=40, score=20 (DESC)
fn test_unsorted_writer_preserves_insertion_order() {
            cleanup_ffi_data(array_ptr, data_schema_ptr);
        let new_pos = mapping[i] as usize;
        index_name.to_string(),
fn create_ffi_data_multi_sort(
// fn test_sort_small_file_permutation_maps_original_row_ids() {
            Some("alpha"),
        vec![
    use arrow::array::{Array, StringArray};
    // Sorted:   age=[10,20,30,40,50,60,70,80,90]
    use arrow_ipc::writer::FileWriter as IpcFileWriter;
    let (_temp_dir2, filename2) = get_temp_file_path("test2.parquet");
    settings.sort_in_memory_threshold_bytes = Some(64); // Tiny — forces multiple chunks
    cleanup_ffi_schema(schema_ptr);
    for (descending, nulls_first, expected_values) in [
        vec![false],
        vec!["id".to_string()],
        vec![],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    settings.nulls_first = vec![false];
    assert!(result.is_err());
    close_writer_and_cleanup_schema(&filename, schema_ptr);
        vec![
        vec![
        vec![Some("A"), Some("B"), Some("C")],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    assert!(
        index_name.to_string(),
            Some("n"),
    let schema = Arc::new(Schema::new(vec![
        })
    let mut settings = NativeSettings::default();
    settings.sort_in_memory_threshold_bytes = Some(1); // Extremely small — forces per-row slicing
        vec![],
        vec![0, 1, 2],
}
        vec![false],
        vec![false],
    assert!(
    // schema_ptr2's FFI struct was consumed by the successful create; free its heap slot.
        vec![false],
    let lists = batch
        expected_sequential,
#[test]
        0,
fn test_ipc_staging_descending_sort() {
    ipc_path
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
            Some("B"),
    // No permutation mapping when __row_id__ is absent
    NativeParquetWriter::create_writer(
    settings.sort_in_memory_threshold_bytes = Some(64); // Force multiple chunks
        .schema()
    settings.sort_columns = vec!["age".to_string()];
#[test]
        Field::new("name", DataType::Utf8, true),
    cleanup_ffi_data(ap1, dp1);
        vec![true, false],
        let handle = thread::spawn(move || {
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    assert!(
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
        vec![],
    ] {
fn test_write_data_success() {
        .unwrap();
    let record_batch = RecordBatch::try_new(schema.clone(), vec![age_array, name_array]).unwrap();
    let ids = read_parquet_file_sorted_ids(&filename);
    assert_eq!(missing_values.get(&5), Some(&None));
        matches!(compression, parquet::basic::Compression::SNAPPY),
fn test_write_data_incompatible_schema() {
    assert_eq!(
    )
    assert_eq!(success_count.load(Ordering::SeqCst), 5);
}
        schema_ptr,
    let (array_ptr, schema_ptr) = create_test_ffi_data().unwrap();
    let settings = NativeSettings {
    row_ids: Vec<i64>,
        vec![false],
        schema_ptr,
        .zip(lists[4..].iter())
        create_test_ffi_data_with_ids(vec![40, 60], vec![Some("D"), Some("F")]).unwrap();
    );
    close_writer_and_cleanup_schema(&filename, schema_ptr);
        index_name.to_string(),
        0,
                        }
                None
    // With 1 byte threshold, rows_per_slice = max(1, 1/bytes_per_row) = 1,
        NativeParquetWriter::get_filtered_writer_memory_usage(path_prefix.clone()).unwrap();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
fn test_chunked_writer_crc32_differs_for_different_data() {
    assert_eq!(
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
#[test]
        gen,
    let (ap, sp) = create_ffi_data_with_row_id(
fn test_chunked_writer_generation_in_metadata_single_chunk() {
        vec![false],
    let metadata = result.unwrap().unwrap();
#[test]
    // Before writing, memory should be 0 (no chunks flushed yet)
    // ... and is idempotent: a second cleanup on a missing entry is still Ok.
    SETTINGS_STORE.remove(index_name);
        .unwrap()
            Some("B"),
    cleanup_ffi_schema(schema_ptr);
    settings.bloom_filter_fpp = Some(0.01);
        .column(idx)
    cleanup_ffi_schema(schema_ptr);
        vec![Some("A"), Some("B"), Some("C"), Some("D"), Some("E")],
        .expect("Should have row_id_mapping");
    );
    // Write a batch with 8 rows — each row will be sliced individually
        .unwrap()
    settings.nulls_first = vec![false];
// ===== Schema without __row_id__ column tests =====
    settings.sort_columns = vec!["age".to_string()];
            Some("C"),
    }
        vec![false],
        .unwrap()
            .unwrap();
        ),
    let record_batch = RecordBatch::try_new(schema.clone(), vec![age_array, name_array]).unwrap();
            if col.is_null(i) {
    let (ap, sp) = create_ffi_data_with_row_id(
    .unwrap();
        "Output should be sorted DESC without __row_id__ in slicing path"
/// Helper: reads the format version from Parquet file key-value metadata.
        vec![false],
    NativeParquetWriter::create_writer(
    SETTINGS_STORE.remove(index_name);
    );
    settings.bloom_filter_enabled = Some(false);
            Some("B"),
        .unwrap_err()
#[test]
    // Disabled: sort_small_file and sort_large_file are currently commented out in writer.rs
        return vec![];
                let write_ok = NativeParquetWriter::write_data(filename.clone(), ap, sp).is_ok();
    let mut offsets = vec![0_i32];
                "test-index".to_string(),
        Field::new(
            Some("G"),
    let (_, schema_ptr2) = create_test_ffi_schema();
        .parent()
            Some(vec![None, Some("charlie".to_string())]),
        ages,
    settings.sort_columns = vec!["age".to_string()];
    let (_temp_dir, filename) = get_temp_file_path("no_ipc_writer.parquet");
    assert_eq!(format_version.as_deref(), Some("1.0.0.0"));
        "Empty path should stamp format version in output file"
        });
    let row_ids = read_row_ids_from_parquet(&filename);
    let row_ids = read_row_ids_from_parquet(&filename);
            Some(row_values) => {
        .unwrap();
    missing_ids.sort_unstable();
    // in the sorted output. So sorted_ages[mapping[i]] should reconstruct the sort.
            Some("b"),
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
        0,
    // Writer 1
fn test_multi_column_sort_age_asc_score_desc() {
/// Test: Sorted writer without __row_id__ — batch slicing path.
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    assert_eq!(
    let mut settings = NativeSettings::default();
    // Original: age=[50,30,10,40,20,60,5,45,35,15], row_ids=[0..9]
    use arrow::array::{Array, Int32Array, StringArray};
    // Write an empty batch (0 rows)
    assert_eq!(
    let (ap1, sp1) =
    close_writer_and_cleanup_schema(&filename, schema_ptr);
        0,
    let metadata = result.unwrap().unwrap();
        schema_ptr,
    // Original: row0=age30, row1=NULL, row2=age10, row3=NULL, row4=age20
        format_version.as_deref(),
            Some("C"),
    // Original: age=[10,50,30,20,40], row_ids=[0,1,2,3,4]
    assert_eq!(mapping.len(), 5);
        "Single chunk path should honor bloom_filter_enabled=true (bloom filter should be in file)"
    let (_temp_dir, filename) = get_temp_file_path("ipc_lifecycle.parquet");
        .to_string()
#[allow(dead_code)]
    ]));
#[allow(dead_code)]
        "Mapping should be a valid permutation of 0..N"
    NativeParquetWriter::write_data(filename.clone(), ap3, sp3).unwrap();
    let mut settings = NativeSettings::default();
        handles.push(handle);
            Some("G"),
        "has_writer should return true for IPC writer"
        vec![Some("E"), Some("A"), Some("C")],
        vec![2, 0, 4, 1, 3],
        .column(idx)
/// - The permutation mapping is a valid permutation (bijection of 0..N)
    cleanup_ffi_data(array_ptr, data_schema_ptr);
        let names: Vec<Option<&str>> = batch_ids.iter().map(|_| Some("x")).collect();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
#[test]
    let (_schema, schema_ptr) = create_nullable_with_row_id_schema_ptr();
    assert_eq!(mapping.len(), 10);
fn test_list_sort_null_placement_for_both_directions() {
    assert_eq!(ages, vec![Some(10), Some(20), Some(30), None, None]);
    let mut buf = [0u8; 64 * 1024];
    let ids = combined
fn test_finalize_writer_success() {
}
        .map(|row| {
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
    SETTINGS_STORE.remove(index_name);
    for _ in 0..2 {
        NativeParquetWriter::write_data("nonexistent.parquet".to_string(), array_ptr, schema_ptr);
        .map(|(id, tags)| (*id, tags.clone()))
            Some("E"),
    settings.sort_columns = vec!["age".to_string()];
        schema_ptr,
fn create_nullable_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
    let schema = Arc::new(Schema::new(vec![
// 3. Data is correctly sorted in the final output
        compression
        .contains("Invalid schema address"));
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    assert!(
        gen,
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    settings.compression_level = Some(5);
    settings.nulls_first = vec![false];
            Arc::new(Int64Array::from(vec![1, 2, 3, 4, 5, 6])) as ArrayRef,
        gen,
        "Output should be sorted by age DESC"
    assert!(result.is_ok());
fn test_create_writer_invalid_path() {
    let row_ids = read_row_ids_from_parquet(&filename);
    let ids = (0..ids.len()).map(|row| ids.value(row)).collect::<Vec<_>>();
    );
        0,
    for i in 0..thread_count {
    // Verify permutation mapping
        vec![true],
        vec![0, 1, 2],
        vec![0, 1, 2, 3, 4],
    assert!(result2.is_err());
        sorted_ages, expected_sorted,
    let (_schema, schema_ptr) = create_multi_sort_schema_ptr();
    settings.nulls_first = vec![false];
        vec![10, 20, 30, 40, 50, 60],
    let record_batch =
    assert!(
        handle.join().unwrap();
        vec![10, 20, 30, 40, 50],
    settings.sort_columns = vec!["age".to_string()];
        vec![false],
            (&ids[2..], &ids[..2])
    let format_version = read_format_version_from_parquet(&filename);
/// Should sort correctly across chunks and return no permutation mapping.
            }
    settings.compression_type = Some("SNAPPY".to_string());
    let format_version = read_format_version_from_parquet(&filename);
        ],
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    let mut sorted_mapping = mapping.clone();
    .unwrap();
        assert_eq!(missing, vec![1, 2, 3]);
    let result2 = NativeParquetWriter::finalize_writer(filename);
    let expected_sequential: Vec<i64> = (0..num_rows as i64).collect();
    for _ in 0..3 {
        schema.clone(),
    let schema = Arc::new(Schema::new(vec![
        vec![],
            "original_ages[{}]={} should be at sorted position {}",
/// Test: Multi-column sort with batch slicing — extreme case combining both features.
        vec![20, 20, 10, 10, 20],
            Some("E"),
        0,
}
        ages,
    cleanup_ffi_schema(schema_ptr);
        vec![90, 10, 70, 30, 50, 80, 20, 60, 40, 100],
    settings.reverse_sorts = vec![false];
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    sorted_mapping.sort();
        false,
        Some(vec![]),
}
    )
        0,
fn read_compression_from_parquet(filename: &str) -> parquet::basic::Compression {
            Some("omega"),
    );
    let crc32_empty = result1.unwrap().unwrap().crc32;
        vec![false],
/// when NULLs are sorted to the front.
        Some(vec![None, Some("charlie")]),
        .unwrap();
    assert_eq!(
        .row_id_mapping
    let success_count = Arc::new(AtomicUsize::new(0));
    settings.nulls_first = vec![false];
    // mapping[0]=4, mapping[1]=0, mapping[2]=2, mapping[3]=3, mapping[4]=1
    )
        0,
    .unwrap();
}
        cleanup_ffi_data(array_ptr, data_schema_ptr);
    let gen = read_writer_generation_from_parquet(&filename);
    )
    );
}
    assert_ne!(streaming_crc32, 0);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    // No permutation mapping
// These tests exercise the code path in SortingChunkedWriter::write() where a single
        metadata.num_row_groups() > 0,
    settings.nulls_first = vec![false];
    let col = combined
        vec![
        Field::new("name", DataType::Utf8, true),
        vec![false],
    let mut settings = NativeSettings::default();
    assert!(NativeParquetWriter::has_writer(&filename));
fn test_writer_properties_honored_empty_path() {
        .as_any()
    let (_schema, schema_ptr) = create_no_row_id_schema_ptr();
    settings.nulls_first = vec![false];
    let struct_array = arrow::array::StructArray::from(record_batch);
    // We need a threshold that allows ~2 rows. A single Int32 + Utf8 + Int64 row
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
    let format_version = read_format_version_from_parquet(&filename);
    for i in 0..10 {
#[test]
        return false;
        vec![false],
        Field::new("age", DataType::Int64, false),
/// and permutation mapping is correct.
        ages,
            Some("F"),
    assert!(result
            Some("C"),
        NativeParquetWriter::has_writer(&filename),
    cleanup_ffi_data(ap2, sp2);
    let (_schema, schema_ptr) = create_multi_sort_schema_ptr();
    use parquet::file::reader::{FileReader, SerializedFileReader};
    //   id=30 tags=["b"]     -> MAX="b"
}
    let struct_array = arrow::array::StructArray::from(batch);
        ages,
    for (i, filename) in filenames.iter().enumerate() {
    assert!(
            .unwrap();
    assert_eq!(stored.get_bloom_filter_enabled(), false);
            Some("B"),
    let (ap, sp) = create_ffi_data_with_row_id(
    );
    // Verify CRC matches actual file content
    settings.sort_in_memory_threshold_bytes = Some(64); // Tiny — forces multiple chunks
        vec![30, 10, 50, 20, 40],
    // Verify format version is stamped
            Some("C"),
    }
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    ages: Vec<Option<i32>>,
    // Verify writer generation is stamped
    );
        vec![false],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
                        .map(|value| value.map(ToString::to_string)),
    let (_schema, schema_ptr) = create_no_row_id_schema_ptr();
        index_name.to_string(),
        &[false],
    .unwrap();
            if NativeParquetWriter::create_writer(
    .unwrap();
            Some("D"),
    use arrow::datatypes::{DataType, Field, Schema};
 *
fn test_chunked_writer_large_dataset_multi_chunk() {
    let mem2 = NativeParquetWriter::get_filtered_writer_memory_usage(prefix2).unwrap();
    // Expected: age DESC, then score ASC within same age
        "writer_generation=42 should be in Parquet metadata"
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
}
    let (_schema, schema_ptr) = create_multi_sort_schema_ptr();
    let schema = Arc::new(Schema::new(vec![
    // Verify permutation
    settings.compression_level = Some(3);
    let ages = read_nullable_ages_from_parquet(&filename);
        vec![false],
    let expected_sequential: Vec<i64> = (0..10).collect();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let (_temp_dir, filename) = get_temp_file_path("test_close.parquet");
    )
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    settings.reverse_sorts = vec![false, true]; // age ASC, score DESC
    settings.sort_columns = vec!["age".to_string()];
        vec![],
    let crc32_with_data = result2.unwrap().unwrap().crc32;
    let (_temp_dir, filename) = get_temp_file_path("ipc_multi_batch.parquet");
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    let lists = read_nullable_string_lists(&combined, "tags");
            Some("C"),
    SETTINGS_STORE.remove(index_name);
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
        filename.clone(),
    use arrow::array::{Array, Int32Array};
        "Default bloom_filter_enabled should be false in multi-chunk path"
    let names: Vec<Option<&str>> = (0..num_rows as usize).map(|_| Some("x")).collect();
            Some("C"),
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    SETTINGS_STORE.remove(index_name);
/// Test: Writer properties (ZSTD compression, bloom filter enabled) are honored
    (array_ptr, schema_ptr)
    let mut settings = NativeSettings::default();
        filename.clone(),
    settings.bloom_filter_fpp = Some(0.05);
}
    )
#[test]
    assert_eq!(
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    let index_name = "test-nulls-last-rowid";
        ages,
    for handle in handles {
    use parquet::file::reader::{FileReader, SerializedFileReader};
        vec![],
    let ages = read_ages_from_parquet(&filename);
    NativeParquetWriter::create_writer(
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
#[test]
        index_name.to_string(),
                values.extend(
    NativeParquetWriter::create_writer(
    let ages = read_ages_from_parquet(&filename);
    // Verify __row_id__ is sequential 0..N
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    use arrow::buffer::{NullBuffer, OffsetBuffer};
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
        let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    SETTINGS_STORE.remove(index_name);
/// Test: Writing a 0-row batch to a sorted writer doesn't corrupt state.
        0,
/// Helper: creates FFI data with (age, score, name, __row_id__) columns.
    settings.reverse_sorts = vec![false];
    let (ap2, sp2) = create_ffi_data_with_row_id(
    let expected_sequential: Vec<i64> = (0..10).collect();
    for i in 0..file_count {
    );
            Some("H"),
    // Second batch: rows 3..6
    sorted_mapping.sort();
/// Helper: creates FFI schema pointer for a schema with (age: Int32, name: Utf8, __row_id__: Int64).
    .unwrap();
        index_name.to_string(),
        compression
#[test]
        index_name.to_string(),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        .unwrap()
        .collect::<std::collections::HashMap<_, _>>();
    .unwrap();
        vec!["age".to_string()],
    let (ap, sp) = create_ffi_data_multi_sort(
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    cleanup_ffi_schema(schema_ptr2);
#[test]
    let col = combined
    let mut handles = vec![];
        create_test_ffi_data_with_ids(vec![20, 40], vec![Some("B"), Some("D")]).unwrap();
    NativeParquetWriter::create_writer(
        writer_generation,
    // Verify writer generation
    use arrow::datatypes::{DataType, Field, Schema};
        "Large writer_generation should be preserved in Parquet metadata"
}
    let result = NativeParquetWriter::finalize_writer(filename.clone());
            Some(vec![Some("gamma".to_string()), Some("beta".to_string())]),
        filename.clone(),
        vec!["age".to_string(), "score".to_string()],
                validity.push(true);
        let success_count = Arc::clone(&success_count);
    ]));
    let (ap, sp) = create_ffi_data_with_row_id(
    let (ap, sp) = create_ffi_data_with_row_id(
            None,
// writer generation) configured via NativeSettings are actually honored in the output
        vec![false],
}
    .unwrap();
/// so tie-breaking order is non-deterministic. This test verifies that:
    // left the previous writer un-finalized.)
        .row_id_mapping
    use arrow::compute::concat_batches;
    // Verify permutation correctness
        .downcast_ref::<Int32Array>()
    let result = NativeParquetWriter::write_data(filename.clone(), ap, sp);
            Some("F"),
            Some("E"),
/// Helper: reads nullable age column, returning None for nulls.
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
            )
        !has_bloom_filter_in_parquet(&filename),
        .unwrap()
            Some("I"),
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    ]));
    let streaming_crc32 = finalize_result.crc32;
    assert_eq!(ages, vec![30, 30, 30, 30, 30]);
    let result1 = NativeParquetWriter::finalize_writer(filename1.clone())
    let format_version = read_format_version_from_parquet(&filename);
    .unwrap();
    );
        .unwrap()
        vec![],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    // All rows have age=30 — sort has zero ordering information
        handle.join().unwrap();
    let (ap, sp) = create_ffi_data_no_row_id(
    );
    drop(stored_after);
        schema_ptr,
    let (ap, sp) = create_ffi_data_with_row_id(ages.clone(), names, row_ids);
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    assert!(result.is_ok());
    );
    let (ap, sp) = create_ffi_data_with_row_id(
            .collect::<Vec<_>>(),
    // Verify output is sorted by age descending
/// Test: nulls_first=false places NULL values after non-null values in ascending sort.
#[test]
        0,
        vec![50, 10, 30],
        Path::new(&filename).exists(),
/// Test: Writer properties (ZSTD compression, bloom filter enabled) are honored
    assert_eq!(
    use arrow::datatypes::{DataType, Field, Schema};
    cleanup_ffi_schema(schema_ptr);
fn test_ipc_staging_concurrent_sorted_writers() {
    SETTINGS_STORE.remove(index_name);
        "Row group should have at least one column"
}
/// Test: Multiple write_data calls where each batch individually exceeds the threshold.
    // on column chunks. But the properties were applied to the writer.
    // Write to both
    settings.nulls_first = vec![false];
        ],
    // Sorted:   age=[10,20,30,40,50] → original row_ids were [1,3,0,4,2]
        Some(vec![None]),
    let index_name = "test-gen-large";
}
        schema_ptr,
    );
        vec![false],
    let file_path = Path::new(&filename);
    assert_eq!(
    let mut settings = NativeSettings::default();
        vec![false],
    // Write multiple empty batches
//
    NativeParquetWriter::create_writer(
    let finalized = NativeParquetWriter::finalize_writer(filename.clone())
            Some("A"),
    settings.reverse_sorts = vec![false];
#[test]
    settings.reverse_sorts = vec![false];
        .iter()
    for i in 0..10 {
        .unwrap()
fn has_bloom_filter_in_parquet(filename: &str) -> bool {
/// Helper: creates FFI schema with nullable sort column (age: Int32 nullable, name: Utf8).
    assert!(result.is_ok());
    let index_name = "test-no-rowid-multi";
        .unwrap();
    ];
    sorted_mapping.sort();
    false
    );
        ages,
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        vec![],
    );
                cleanup_ffi_data(ap, sp);
    settings.sort_in_memory_threshold_bytes = Some(1); // Force slicing on every batch
            Some("G"),
    // Verify compression is ZSTD in the merged output
        writer_generation,
    let mut settings = NativeSettings::default();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        .column(0)
    // Verify sequential row IDs
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let ages = read_ages_from_parquet(&filename);
        vec![],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    for _ in 0..3 {
    let ids = read_parquet_file_sorted_ids(&filename);
        &[false],
    settings.reverse_sorts = vec![true, false]; // age DESC, score ASC
        vec![],
    SETTINGS_STORE.remove(index_name);
}
        vec![10, 20, 30, 40, 50, 60],
            Arc::new(list) as ArrayRef,
    let mut hasher = crc32fast::Hasher::new();
#[test]
    let mapping = finalize_result
        vec![30, 20, 30, 20, 10, 30], // ages: ties at 20 and 30
    );
        vec![true],
        .unwrap()
        index_name.to_string(),
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
        filename.clone(),
#[test]
        vec![],
    assert_eq!(permutation, (0..6).collect::<Vec<_>>());
        vec!["age".to_string()],
            {
    )
    }
        index_name.to_string(),
    assert!(
    let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
    let index_name = "test-slice-multi-write";
            Some("I"),
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    assert!(result.is_ok());
    use arrow::record_batch::RecordBatch;
    // mapping[0]=4, mapping[1]=0, mapping[2]=2, mapping[3]=3, mapping[4]=1
        has_bloom_filter_in_parquet(&filename),
        Some(vec![Some("gamma"), Some("beta")]),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
#[test]
        cleanup_ffi_data(array_ptr, data_schema_ptr);
            Some("G"),
    let batches = read_parquet_file(filename);
}
    let mut handles = vec![];
        schema.clone(),
    let mut settings = NativeSettings::default();
    let (_temp_dir, filename) = get_temp_file_path("invalid_schema.parquet");
    })
    assert_eq!(
                }
    }
        schema_ptr2,
            .is_ok()
}
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024); // Single chunk
    );
    (array_ptr, schema_ptr)
        kvs.iter()
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    assert_eq!(mapping, vec![4, 0, 2, 3, 1, 5]);
    settings.nulls_first = vec![false];
    );
    );
    // A second (sorted/IPC) writer for the same file removes the stale entry and succeeds.
    assert_eq!(success_count.load(Ordering::SeqCst), 10);
        stored.get_bloom_filter_enabled(),
    assert!(file_path.metadata().unwrap().len() > 0);
    use arrow::datatypes::{DataType, Field, Schema};
#[test]
        row_ids_in_file,
    let (_temp_dir, filename) = get_temp_file_path("close_race.parquet");
fn test_create_writer_invalid_schema_pointer() {
    );
        (true, true, vec![4, 5]),
    let expected_sequential: Vec<i64> = (0..6).collect();
    // Verify permutation mapping
/// into the final merged file's metadata. This test documents the current behavior.
    metadata.key_value_metadata().and_then(|kvs| {
    .unwrap();
    );
        compression
        index_name.to_string(),
        Some(vec![Some("alpha")]),
}
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    NativeParquetWriter::write_data(
        vec![],
    let row_ids = read_row_ids_from_parquet(&filename);
            Some("E"),
    )
            Some("F"),
    NativeParquetWriter::write_data(filename1.clone(), ap, sp).unwrap();
    use arrow::datatypes::{DataType, Field, Schema};
        handle.join().unwrap();
    ages: Vec<i32>,
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    );
        index_name.to_string(),
        Some(42),
        None,
#[test]
    let compression = read_compression_from_parquet(&filename);
    let mut permutation = finalized.row_id_mapping.unwrap();
        Some(NullBuffer::from(validity)),
        vec![30, 50, 40, 20, 10],
    .unwrap();
            i, original_ages[i], new_pos, sorted_ages[new_pos]
        vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60],
    );
                    {
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
    settings.sort_columns = vec!["age".to_string()];
    settings.reverse_sorts = vec![false];
    settings.sort_columns = vec!["age".to_string()];
        writer_generation,
    NativeParquetWriter::create_writer(
    assert_eq!(
// ===== Empty batch handling and memory usage tests =====
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
            Some("H"),
fn create_nullable_with_row_id_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
        vec![false, false],
    arrow::array::ListArray::new(
            Some("A"),
    // mapping[3]=3(40→pos3), mapping[4]=1(20→pos1), mapping[5]=5(60→pos5)
        ],
    assert_eq!(
            Some("F"),
        vec![Some("A"), Some("E"), Some("C"), Some("B"), Some("D")],
    // Multi-chunk merge also produces a CRC (from merge_sorted's CrcWriter)
        vec![0, 1, 2, 3, 4],
    );
        filename.clone(),
    NativeParquetWriter::create_writer(
}
    settings.sort_columns = vec!["age".to_string()];
    // Verify data correctness
        vec![],
    cleanup_ffi_data(array_ptr, data_schema_ptr);
            if NativeParquetWriter::finalize_writer(filename).is_ok() {
}
    rg.column(0).compression()
    let result = NativeParquetWriter::finalize_writer(filename.clone());
        0,
    let (_temp_dir2, filename2) = get_temp_file_path("mem_prefix_b.parquet");
    let writer_generation = 99i64;
    let mut settings = NativeSettings::default();
        vec![0, 1, 2],
        "Mapping should be a valid permutation"
    assert_eq!(
    assert_eq!(finalize_result.metadata.file_metadata().num_rows(), 9);
        let temp_dir_path = temp_dir.path().to_path_buf();
    assert!(
    assert!(
}
        0,
        vec![0, 1, 2],
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
    SETTINGS_STORE.insert(index_name.to_string(), settings);
/// Test: Batch slicing with a threshold that allows exactly 2 rows per slice.
        ids,
    )
    // Verify sequential row IDs
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    assert_eq!(
    let result = NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr);
    );
        filename.clone(),
    let mapping = finalize_result
        ages,
                (0..strings.len())
/// - Row IDs are sequential 0..N
}
    settings.nulls_first = vec![false];
    ]));
    )
    assert!(result.is_ok());
    let (_temp_dir, filename) = get_temp_file_path("slice_large.parquet");
        matches!(compression, parquet::basic::Compression::UNCOMPRESSED),
/// Subsequent non-empty writes and finalize should still work correctly.
/// Verifies format version is stamped and writer generation is present.
    assert!(
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    assert!(result.is_ok());
    let gen = read_writer_generation_from_parquet(&filename);
            Some("J"),
        vec![],
    settings.sort_in_memory_threshold_bytes = Some(64); // Force multiple chunks
    // Write multiple batches with interleaved values
        writer_generation,
/// Helper: reads the compression codec from the first row group's first column chunk.
        vec![false],
}
    let (ap, sp) = create_ffi_data_with_row_id(
fn test_sorted_writer_descending() {
    settings.nulls_first = vec![true]; // NULLs first
#[test]
    let compression = read_compression_from_parquet(&filename);
    assert_eq!(
            Arc::new(Int64Array::from(vec![10, 20, 30, 40, 50, 60])) as ArrayRef,
    cleanup_ffi_data(array_ptr, data_schema_ptr);
    settings.sort_columns = vec!["age".to_string(), "score".to_string()];
        .to_string()
        index_name.to_string(),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
            Some("B"),
            Some("F"),
    NativeParquetWriter::create_writer(
        vec![0, 1, 2, 3, 4],
        index_name.to_string(),
    let (_schema, schema_ptr) = create_multi_sort_schema_ptr();
    }
        "Output should be sorted even without __row_id__ in multi-chunk path"
    // Verify data correctness
    settings.sort_columns = vec!["age".to_string()];
        filenames.push(filename);
    );
    NativeParquetWriter::finalize_writer(sorted_file.clone()).unwrap();
use crate::writer::SETTINGS_STORE;
    )
        .contains("Writer not found"));
    let sorted =
    assert_eq!(format_version.as_deref(), Some("1.0.0.0"));
 * this file be licensed under the Apache-2.0 license or a
            &batch,
        "Single chunk path should honor SNAPPY compression, got: {:?}",
        vec![10, 20, 30],
    hasher.finalize()
        schema_ptr,
/// Helper: reads the "score" column from a Parquet file.
    let batches = read_parquet_file(&filename);
    cleanup_ffi_data(ap2, dp2);
        .unwrap();
    (schema, schema_ptr)
        .unwrap()
    assert_eq!(unsorted_ids, vec![30, 10, 20]);
    );
#[test]
        vec!["age".to_string()],
    let close_result = NativeParquetWriter::finalize_writer(filename.clone());
    assert!(
        vec![false],
        vec![],
    let result = NativeParquetWriter::finalize_writer(filename.clone());
    )
fn test_bloom_filter_default_when_no_settings() {
        vec![age_array, score_array, name_array, row_id_array],
        filename.clone(),
    ]));
            }
            Field::new("id", DataType::Int64, false),
            Some("gamma"),
    let (ap, sp) =
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    let (_schema, schema_ptr) = create_test_ffi_schema();
            Some("J"),
    settings.sort_columns = vec!["age".to_string()];
        ages,
    let expected_mapping: Vec<i64> = vec![8, 4, 1, 6, 3, 9, 0, 7, 5, 2];
        index_name.to_string(),
}
        vec![0, 1, 2, 3, 4],
        vec![false],
    let (_schema, schema_ptr1) = create_row_id_schema_ptr();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            Some("A"),
        vec![],
        schema_ptr,
fn test_writer_properties_honored_single_chunk_uncompressed() {
        sorted_mapping, expected_sequential,
    close_writer_and_cleanup_schema(&filename, schema_ptr);
/// Test: writer_generation=0 is correctly stored (edge case — zero is a valid generation).
    settings.compression_type = Some("ZSTD".to_string());
    }
    let compression = read_compression_from_parquet(&filename);
        mem_after
    let (ap, sp) = create_ffi_data_with_row_id(
    let reader = SerializedFileReader::new(file).unwrap();
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    )
    assert!(result.is_ok());
    let index_name = "test-props-single-zstd";
    let (_temp_dir, filename) = get_temp_file_path("props_single_snappy.parquet");
        vec![false, false],
        "Mapping should be a valid permutation"
        "Empty Parquet file should be created"
    NativeParquetWriter::create_writer(
    assert!(
        .index_of("age")
#[test]
fn test_close_nonexistent_writer() {
    for _ in 0..3 {
            Some(vec![Some("omega".to_string()), Some("alpha".to_string())]),
    let ages = read_ages_from_parquet(&filename);
    let mem_after =
        vec!["age".to_string()],
    );
        vec![false],
    let (_temp_dir, filename) = get_temp_file_path("unsorted.parquet");
        vec![false],
    let score_array: Arc<dyn Array> = Arc::new(Int32Array::from(scores));
    NativeParquetWriter::create_writer(
    let (_temp_dir, filename) = get_temp_file_path("chunked_desc.parquet");
        Some(vec![Some("omega"), Some("alpha")]),
        let filename = filenames[i].clone();
#[test]
            Some("C"),
    // Writer 1 had data written (and chunks flushed), writer 2 did not
        vec!["age".to_string()],
    // Verify permutation mapping exists and has correct length
        .collect()
        .as_any()
    // Verify sequential row IDs
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
// ===== Multi-column sort tests =====
        .unwrap();
        0,
        Field::new("id", DataType::Int64, false),
    assert_eq!(
        index_name.to_string(),
        vec![],
            Some("F"),
    settings.nulls_first = vec![false]; // NULLs last
        schema_ptr,
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
        Some(999_999),
fn test_write_data_no_writer() {
    );
    settings.sort_columns = vec!["age".to_string()];
        0,
    let (_temp_dir, filename) = get_temp_file_path("props_multi_snappy.parquet");
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 0);
        writer_generation,
        vec![
        } else {
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    );
        schema_ptrs.push(schema_ptr);
    let index_name = "test-chunked-desc";
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    let (ap2, sp2) =
    // Data with duplicate ages to test tie-breaking by score DESC
/// Test: Multiple chunks with descending sort — verifies correctness with reverse order.
    );
        let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        vec![Some("E"), Some("D"), Some("C"), Some("B"), Some("A")],
        !has_bloom_filter_in_parquet(&filename),
fn test_multi_column_sort_age_desc_score_asc() {
        &batch,
    let (_schema, schema_ptr) = create_test_ffi_schema();
    assert!(file_path.exists());
}
        handles.push(handle);
/// Helper: creates FFI data WITHOUT __row_id__ column.
}
        "Multi chunk path should honor UNCOMPRESSED setting, got: {:?}",
    let (_schema2, sp2) = create_writer_and_assert_success(&unsorted_file);
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
        filename.clone(),
    // Verify output is sorted
        ],
    let compression = read_compression_from_parquet(&filename);
            let filename = file_path.to_string_lossy().to_string();
        "test-index".to_string(),
    settings.sort_in_memory_threshold_bytes = Some(1);
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
        Field::new("name", DataType::Utf8, true),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
            if NativeParquetWriter::write_data(filename, array_ptr, data_schema_ptr).is_ok() {
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    NativeParquetWriter::finalize_writer(filename1).unwrap();
                Some("delta".to_string()),
        .collect::<Vec<_>>();
    .unwrap();
    use arrow::array::{ArrayRef, AsArray, Int64Array, ListArray, RecordBatch, StringArray};
        .unwrap()
    let (_temp_dir, filename) = get_temp_file_path("sorted_asc.parquet");
    let (ap, sp) = create_ffi_data_multi_sort(
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
    }
        "Permutation should correctly place NULLs first and map original row IDs"
    let file = File::open(filename).unwrap();
    assert_eq!(missing_values.get(&4), Some(&Some(vec![])));
    );
    .unwrap();
    settings.nulls_first = vec![false];
    let (ap, sp) = create_ffi_data_nullable_age(
    let struct_array = arrow::array::StructArray::from(record_batch);
    // mapping[0]=8 (age=50→pos8), mapping[1]=4 (age=30→pos4), mapping[2]=1 (age=10→pos1)
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    assert!(NativeParquetWriter::cleanup_writer(&filename).is_ok());
    );
    // mapping[5]=3, mapping[6]=9, mapping[7]=1, mapping[8]=5, mapping[9]=7
        "Single chunk path should honor bloom_filter_enabled=false (no bloom filter in file)"
        0,
    let result2 = NativeParquetWriter::finalize_writer(filename2.clone());
    assert!(result.is_err());
}
        has_bloom_filter_in_parquet(&filename),
        .downcast_ref::<Int32Array>()
    ]));
        vec![false],
        .unwrap();
    let batches = read_parquet_file(filename);
    settings.sort_columns = vec!["age".to_string()];
        vec![50, 80, 90, 40, 70, 10], // scores for tie-breaking
    );
        vec![],
        vec![false],
    use arrow::compute::concat_batches;
    );
        "Single chunk path should stamp writer_generation"
    // Sorted:   age=[10, 20, 30, NULL, NULL]
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
}
    NativeParquetWriter::create_writer(
#[test]
            cleanup_ffi_schema(schema_ptr);
            Some("D"),
        vec![10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
    let ages = read_ages_from_parquet(&filename);
    let (_temp_dir, filename) = get_temp_file_path("write_mismatch.parquet");
            Some("J"),
    );
    let mut settings = NativeSettings::default();
    );
    let row_ids = read_row_ids_from_parquet(&filename);
        (false, false, vec![5, 4]),
    assert_eq!(ages, vec![10, 20, 20, 30, 30, 30]);
    let (_temp_dir, filename) = get_temp_file_path("props_multi_uncompressed.parquet");
    let mapping = finalize_result
        ],
            Some("D"),
    );
                        } else {
    assert_eq!(
}
    let input_rows = vec![
    .unwrap();
            Some("J"),
    // Verify bloom filter is NOT present (disabled)
        filename.clone(),
            &[descending],
        matches!(compression, parquet::basic::Compression::ZSTD(_)),
        mapping, expected_mapping,
    )
    }
        ),
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    assert_eq!(row_ids, expected);
    let (_, schema_ptr2) = create_test_ffi_schema();
}
        vec!["age".to_string()],
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let row_ids = read_row_ids_from_parquet(&filename);
                    success_count.fetch_add(1, Ordering::SeqCst);
/// the accumulated chunk_row_ids.
        filename.clone(),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        "Multi chunk path should honor bloom_filter_enabled=true"
        ])),
    // Default compression is LZ4_RAW
}
        return vec![];
fn test_chunked_writer_no_row_id_batch_slicing() {
        (false, true, vec![5, 4]),
    assert_eq!(
        vec!["age".to_string()],
    // Sorted DESC: age=[50,40,30,20,10] → original row_ids [1,4,2,3,0]
        index_name.to_string(),
    let (_temp_dir1, filename1) = get_temp_file_path("mem_prefix_a.parquet");
    // age=10: scores 10, 30, 50, 70
}
    assert_eq!(
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
        vec![20, 30, 20, 30, 10],
fn test_ipc_staging_complete_lifecycle_with_sync() {
fn read_ages_from_parquet(filename: &str) -> Vec<i32> {
    let reader = SerializedFileReader::new(file).unwrap();
        gen,
    }
        Field::new("age", DataType::Int32, true),
#[test]
    let expected_sequential: Vec<i64> = (0..5).collect();
    let index_name = "test-slice-desc";
    let mut settings = NativeSettings::default();
            Some("G"),
    let ascending = NativeParquetWriter::sort_batch(
    let (_temp_dir, filename) = get_temp_file_path("ipc_desc.parquet");
    use arrow::buffer::{NullBuffer, OffsetBuffer};
            Some("B"),
fn test_writer_properties_defaults_multi_chunk() {
    assert_eq!(ids, vec![10, 20, 30, 40, 50, 60]);
    settings.sort_columns = vec!["age".to_string()];
}
    let index_name = "test-props-single-snappy";
        });
    let row_id_array: Arc<dyn Array> = Arc::new(Int64Array::from(row_ids));
    let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
    let ages = read_ages_from_parquet(&filename);
            Some("C"),
                vec![false],
        vec![],
    row_ids: Vec<i64>,
#[test]
    assert!(close_result.unwrap().is_some());
        (0..3)
        vec![
    // MAX reduction, ascending, nulls last => order by MAX element:
    let mut handles = vec![];
                let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
        .column(idx)
        vec![],
        .expect("age column should exist");
    let (_temp_dir, filename) = get_temp_file_path("gen_unsorted.parquet");
    // merge_sorted now propagates writer_generation into the output file metadata.
    let ages = read_ages_from_parquet(&filename);
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    for handle in handles {
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        vec![30, 10, 50, 20, 40],
        Arc::new(Int32Array::from(vec![3, 2, 5, 1])),
                )
        index_name.to_string(),
    }
fn test_chunked_writer_generation_large_value() {
            Some("A"),
        ],
    use arrow::array::{ArrayRef, AsArray, Int64Array, ListArray, RecordBatch, StringArray};
    .unwrap();
        vec![Some("C"), Some("A"), Some("B")],
fn test_chunked_writer_permutation_is_invertible() {
        "Default compression should be LZ4_RAW in multi-chunk path, got: {:?}",
        vec![false],
    )
    // Verify format version
/// Test: get_filtered_writer_memory_usage reports memory for IPC (sorted) writers.
    // Just create the writer with the schema, don't write data
    // Verify output is sorted by age ascending
        .unwrap();
    let batches = read_parquet_file(filename);
        vec![false],
        vec!["age".to_string()],
    assert!(file_path.exists());
    let ages = read_ages_from_parquet(&filename);
            if NativeParquetWriter::create_writer(
    NativeParquetWriter::write_data(filename.clone(), ap_empty, sp_empty).unwrap();
    assert!(Path::new(&filename).exists());
        compression
        Arc::clone(&schema),
    NativeParquetWriter::create_writer(
        vec![
        vec![0, 1, 2, 3, 4],
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        Field::new("age", DataType::Int32, true),
    assert_eq!(
        vec![
    // age=30: scores 20, 60
    // Write enough data to trigger at least one chunk flush
    let temp_dir = tempdir().unwrap();
        vec![false],
        schema_ptr,
    let (_temp_dir, filename) = get_temp_file_path("crc_multi.parquet");
    let batch = RecordBatch::try_new(
    let writer_generation = 12i64;
    );
        "CRC32 from finalize should match recomputed CRC for multi-chunk output"
        vec![30, 20, 10]
        filename.clone(),
        vec![false],
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    let (ap, sp) = create_ffi_data_with_row_id(
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
    settings.nulls_first = vec![false];
    ]));
    // Verify permutation
        Some(0),
        (0..3)
        vec![80, 20, 60, 40, 10, 90, 50, 30, 70],
            &[false],
    // mapping[6]=0 (age=5→pos0), mapping[7]=7 (age=45→pos7), mapping[8]=5 (age=35→pos5)
    settings.sort_columns = vec!["age".to_string()];
}
        );
        create_test_ffi_data_with_ids(vec![30, 10, 50], vec![Some("C"), Some("A"), Some("E")])
    let (_temp_dir, filename) = get_temp_file_path("gen_multi.parquet");
        Arc::new(StringArray::from(vec![
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
    settings.sort_columns = vec!["age".to_string()];
    // Verify permutation:
    let stored = SETTINGS_STORE.get(index_name).unwrap();
        .unwrap()
    let ids = sorted
    let (_temp_dir, filename) = get_temp_file_path("ipc_cleanup.parquet");
            .unwrap();
    settings.bloom_filter_enabled = Some(true);
    let ages = read_ages_from_parquet(&filename);
        vec!["age".to_string()],
    let index_name = "test-props-defaults-single";
        vec![Some(30), None, Some(10), None, Some(20)],
        0,
    let (ap, sp) = create_ffi_data_with_row_id(
    assert!(
    assert_eq!(
    SETTINGS_STORE.remove(index_name);
        index_name.to_string(),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    assert_eq!(row_ids, (0..6).collect::<Vec<_>>());
            "tags",
    let (ap, sp) = create_ffi_data_no_row_id(
    cleanup_ffi_schema(sp1);
}
    // mapping[0]=2, mapping[1]=3, mapping[2]=0, mapping[3]=4, mapping[4]=1
    assert_eq!(format_version.as_deref(), Some("1.0.0.0"));
    cleanup_ffi_data(ap2, sp2);
    let (_schema, schema_ptr) = create_nullable_with_row_id_schema_ptr();
        let (ap, sp) = create_test_ffi_data_with_ids(batch_ids, names).unwrap();
    let mut settings = NativeSettings::default();
    let ages = read_ages_from_parquet(&filename);
        "Different data should produce different CRC32 values"
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
    let (_schema1, schema_ptr1) = create_writer_and_assert_success(&filename1);
/// It does NOT assert a specific tie-breaking order.
    settings.reverse_sorts = vec![false];
    let rg = metadata.row_group(0);
    assert!(mem1 >= 0, "Writer 1 memory should be reported");
        &["values".to_string()],
    // Verify data correctness (sort order)
            true,
        index_name.to_string(),
        handles.push(handle);
        .unwrap()
    let mut settings = NativeSettings::default();
        .row_id_mapping
    assert_eq!(
    assert_eq!(
        schema_ptr,
        vec!["age".to_string()],
    let idx = combined
        Some(7),
        .to_string();
        .row_id_mapping
    let mut values = Vec::new();
#[test]
    // Sorted:   age=[5,10,15,20,30,35,40,45,50,60]
    )
    let result = NativeParquetWriter::create_writer(
/// After writing data that triggers chunk flushes, memory should reflect
    settings.nulls_first = vec![false];
        .unwrap();
    SETTINGS_STORE.remove(index_name);
        format_version.as_deref(),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
        .unwrap();
#[test]
                let _ = NativeParquetWriter::finalize_writer(filename);
        let temp_dir_path = temp_dir.path().to_path_buf();
        "writer_generation should be propagated in multi-chunk merge path"
    .unwrap();
    let scores = read_scores_from_parquet(&filename);
    settings.sort_in_memory_threshold_bytes = Some(1); // Force per-row slicing
    cleanup_ffi_data(ap3, sp3);
        let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
    let (_temp_dir1, filename1) = get_temp_file_path("crc_diff1.parquet");
        filename2.clone(),
                Some("z".to_string()),
    use arrow::datatypes::{DataType, Field, Schema};
    assert_eq!(mapping, vec![4, 1, 3, 2, 0, 5]);
    );
#[test]
fn test_ipc_staging_sorted_writer_creates_and_cleans_up_staging_file() {
            Some("a"),
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
/// Test: writer_generation is stored in Parquet metadata for multi-chunk merged output.
    assert!(result.is_err());
        vec![0, 1, 2, 3, 4],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        "Single chunk path should honor UNCOMPRESSED setting, got: {:?}",
        vec!["age".to_string()],
        Field::new("age", DataType::Int32, false),
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
fn test_writer_properties_defaults_single_chunk() {
    }
    let mut settings = NativeSettings::default();
use std::io::Read;
    let row_ids: Vec<i64> = (0..num_rows as i64).collect();
    SETTINGS_STORE.remove(index_name);
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
/// Helper: creates FFI schema with nullable age + __row_id__ (age: Int32 nullable, name: Utf8, __row_id__: Int64).
fn test_chunked_writer_empty_finalize() {
    assert!(NativeParquetWriter::has_writer(&filename));
    );
    SETTINGS_STORE.insert(index_name2.to_string(), settings);
}
    let mut settings = NativeSettings::default();
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    let index_name = "test-nulls-first-rowid";
fn test_writer_properties_honored_multi_chunk_uncompressed() {
// ===== Writer properties verification tests =====
        ..Default::default()
        NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr).unwrap();
        .unwrap()
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
        vec![],
        vec![Some("E"), Some("C"), Some("A"), Some("D"), Some("B")],
    let schema = Arc::new(Schema::new(vec![
    SETTINGS_STORE.remove(index_name);
    let mut settings = NativeSettings::default();
    );
    }
    let index_name = "test-only-empty";
        .unwrap();
    names: Vec<Option<&str>>,
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let writer_generation = 7i64;
    let ascending_ids = ascending
fn create_ffi_data_with_row_id(
    (0..col.len()).map(|i| col.value(i)).collect()
        0,
        handle.join().unwrap();
    let schema = Arc::new(Schema::new(vec![
#[test]
        "Output should be globally sorted despite batch slicing"
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8],
    );
    );
        vec![2, 3, 0, 4, 1],
    let metadata = result.unwrap().unwrap();
    .unwrap();
    let ipc_path = dir
    );
    settings.sort_columns = vec!["age".to_string()];
    );
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
        );
    let (_temp_dir, filename) = get_temp_file_path("chunked_single.parquet");
        vec![false],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
}
        OffsetBuffer::new(offsets.into()),
}
        index_name.to_string(),
                0,
            Some("E"),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        "__row_id__ should be sequential 0..4"
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    .unwrap();
    settings.bloom_filter_ndv = Some(50_000);
    .unwrap();
    .unwrap();
        ],
        None,
    (0..col.len())
    for i in 0..file_count {
        "Default bloom_filter_enabled should be false"
        vec![10, 20, 50]
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
                    vec![30, 10, 20],
    )
        let success_count = Arc::clone(&success_count);
    assert_eq!(
    );
    // Verify output is sorted by age ascending
fn read_writer_generation_from_parquet(filename: &str) -> Option<i64> {
        "Multi chunk path should honor bloom_filter_enabled=false"
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        "Output should be globally sorted by age ASC"
    settings.nulls_first = vec![false];
        ],
    close_writer_and_cleanup_schema(&filename, schema_ptr);
}
        vec![30, 10, 20],
    assert_eq!(mapping.len(), 10);
        RecordBatch::try_new(schema.clone(), vec![age_array, name_array, row_id_array]).unwrap();
    use arrow::array::StringArray;
#[test]
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        "Memory should be > 0 after chunk flushes (chunk_row_ids accumulated), got {}",
fn test_close_multiple_times_same_file() {
    )
                    if let Ok(Some(metadata)) =
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
#[test]
    SETTINGS_STORE.remove(index_name);
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
        vec![],
    );
    ]));
    );
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
        "Writer should be open"
    let path_prefix = Path::new(&filename)
    let (_temp_dir, filename) = get_temp_file_path("nulls_first_true.parquet");
        filename.clone(),
        schema_ptr,
/// Test: Sort by age ASC, then score DESC (tie-breaking).
    let (_temp_dir, filename) = get_temp_file_path("close_with_data.parquet");
        "Permutation should correctly map across multiple write calls"
            true,
        vec![3, 4, 5],
            Arc::new(Int64Array::from(row_ids.to_vec())),
        vec![false],
    // Verify sequential row IDs
            "ages[{}]={} should be at sorted position {}",
        vec![Some(30), None, Some(10), None, Some(20)],
        ],
    let row_ids = read_row_ids_from_parquet(&filename);
    }
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    NativeParquetWriter::create_writer(
fn test_chunked_writer_sorts_by_list_min_and_preserves_original_lists() {
    )
            .unwrap();
        vec![],
    // Verify permutation is valid
        &[false],
fn test_multi_column_sort_batch_slicing() {
    settings.sort_columns = vec!["age".to_string()];
        vec![],
    let mut missing_ids = ids[4..].to_vec();
    let mut settings = NativeSettings::default();
        schema_ptr,
        vec![false],
    //   id=10 tags=["a","z"] -> MAX="z"
}
        filename.clone(),
        Arc::new(Field::new("element", DataType::Utf8, true)),
    .unwrap();
            .find(|kv| kv.key == "opensearch.writer_generation")
    // Verify sorted output
/// Test: CRC32 is non-zero for multi-chunk merged output.
}
        NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
}
        "test-index".to_string(),
/// respects composite sort keys across chunk boundaries.
    let expected_sequential: Vec<i64> = (0..5).collect();
        close_writer_and_cleanup_schema(filename, schema_ptrs[i]);
        0,
    let (_, schema_ptr) = create_row_id_schema_ptr();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            Some("C"),
        "writer_generation=0 should be stored in metadata"
    let (_temp_dir, filename) = get_temp_file_path("crc32_with_data.parquet");
                cleanup_ffi_data(array_ptr, data_schema_ptr);
        vec![false, true],
    assert!(result.is_err());
    // Original positions: [2, 7, 4, 5, 1, 8, 3, 9, 0, 6]
                filename.clone(),
            }
    let (_temp_dir, filename) = get_temp_file_path("no_rowid_single.parquet");
    assert!(
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 6);
    let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    // Verify __row_id__ is sequential 0..N
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    NativeParquetWriter::finalize_writer(filename2).unwrap();
    let struct_array = arrow::array::StructArray::from(record_batch);
    .unwrap();
    );
    // Unsorted file should preserve insertion order
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    let mut sorted_mapping = mapping.clone();
#[test]
fn read_nullable_ages_from_parquet(filename: &str) -> Vec<Option<i32>> {
            Some(vec![
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        "Should get 'Writer not found' error for non-existent IPC writer"
    let index_name = "test-multi-sort-desc-asc";
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    let writer_generation = 999_999i64;
            Some("E"),
    let (ap, sp) = create_ffi_data_nullable_with_row_id(
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    // Cleanup
    let (ap, sp) = create_ffi_data_with_row_id(
    let (_temp_dir, filename) = get_temp_file_path("nulls_last_rowid.parquet");
        schema_ptr2,
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    let mut settings = NativeSettings::default();
            Some("H"),
) -> (i64, i64) {
        vec![],
        vec![Some(30), None, Some(10), None, Some(20)],
        0,
        vec![false],
        vec![
    let sorted_ids = read_parquet_file_sorted_ids(&sorted_file);
    assert_eq!(sorted_ids, vec![10, 20, 30]);
        vec![false],
#[test]
    assert!(
        index_name.to_string(),
        vec![10, 20, 30, 40, 50],
        compression
    SETTINGS_STORE.remove(index_name);
        .unwrap();
        compression
}
    let prefix = _temp_dir.path().to_string_lossy().to_string();
    NativeParquetWriter::create_writer(
    assert_eq!(
            Arc::new(build_nullable_string_list(&rows)) as ArrayRef,
    };
    settings.sort_columns = vec!["age".to_string()];
        vec![false],
        vec![25, 55, 15, 35, 45],
    settings.nulls_first = vec![false];
        .map(|i| {
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
        .expect("Should have row_id_mapping");
    let success_count = Arc::new(AtomicUsize::new(0));
    let (_temp_dir, filename) = get_temp_file_path("no_rowid_multi.parquet");
    let (_temp_dir2, filename2) = get_temp_file_path("crc32_diff_b.parquet");
    let result2 = NativeParquetWriter::create_writer(
    // mapping[0]=4, mapping[1]=0, mapping[2]=2, mapping[3]=1, mapping[4]=3
    let compression = read_compression_from_parquet(&filename);
        filename.clone(),
    // Verify compression is SNAPPY
        schema_ptr,
    let (_temp_dir, filename) = get_temp_file_path("chunked_multi_write.parquet");
        0,
    let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    NativeParquetWriter::create_writer(
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    assert_eq!(mapping.len(), 5);
    let (_schema, schema_ptr) = create_test_ffi_schema();
    assert!(result2
        vec![false],
    // Verify bloom filter IS present
        vec![80, 20, 60, 40, 10, 70, 30, 50],
        vec![Some("E"), Some("C"), Some("A"), Some("D"), Some("B")],
fn test_only_empty_batches_produces_empty_output() {
    let index_name = "test-nulls-first-false";
    );
/*
                success_count.fetch_add(1, Ordering::SeqCst);
    // Verify __row_id__ is sequential 0..N
    // Verify format version
    assert!(
        .schema()
        let new_pos = mapping[i] as usize;
    let (_temp_dir, filename) = get_temp_file_path("chunked_invertible.parquet");
            Some("beta"),
    );
        (0..3).map(|row| ids.value(row)).collect::<Vec<_>>(),
    // Write to writer 1 only
    // Verify bloom filter is NOT present
        mapping,
        vec![],
    let index_name = "test-props-multi-zstd";
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    settings.bloom_filter_enabled = Some(false);
fn test_chunked_writer_multiple_write_calls() {
        let sorted = NativeParquetWriter::sort_batch(
    let mut sorted_mapping = mapping.clone();
    )
            let filename = file_path.to_string_lossy().to_string();
            .is_ok()
    );
            Some("F"),
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
    settings.reverse_sorts = vec![false];
    settings.reverse_sorts = vec![false];
    settings.sort_columns = vec!["age".to_string(), "score".to_string()];
        vec!["age".to_string()],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let mut ascending_missing = (3..6)
#[test]
        filename.clone(),
    );
        vec![10, 50, 30, 20, 40],
        vec![
            )
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
    // The writer accumulates in memory. Verify the writer is open.
    // All ages should be 30
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
#[test]
        vec![false],
    );
#[test]
            Some("m"),
    let index_name = "test-chunked-empty";
            .map(|row| ascending_ids.value(row))
        .unwrap()
    let (ap_empty, sp_empty) = create_ffi_data_with_row_id(vec![], vec![], vec![]);
        .unwrap()
        Box::into_raw(Box::new(ffi_schema)) as i64,
}
            .unwrap();
    descending_missing.sort_unstable();
    );
    let mut sorted_mapping = mapping.clone();
    let format_version = read_format_version_from_parquet(&filename);
/// Rows with the same age should be ordered by score descending.
        vec![false, false],
    let schema = Arc::new(Schema::new(vec![
    settings.reverse_sorts = vec![false, true]; // age ASC, score DESC
    // Create writer 2
        vec![false],
    // Create writer 1
        finalize_result.crc32, actual_crc,
    use arrow::compute::concat_batches;
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    assert_eq!(
            Some("H"),
// skip the row ID capture/rewrite logic and finalize_writer should return no permutation.
    // Verify sort: NULLs first, then ascending
    );
    for i in 0..rg.num_columns() {
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
        Arc::new(Field::new("element", DataType::Utf8, true)),
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let idx = combined
    use arrow::array::Int32Array;
        vec![
        .collect()
    assert_eq!(
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    settings.bloom_filter_enabled = Some(false);
        vec![30, 10, 50, 20, 40],
        sorted_mapping,
    settings.bloom_filter_ndv = Some(200_000);
    let (_temp_dir, filename) = get_temp_file_path("gen_large.parquet");
            Some("F"),
    let (ap, sp) = create_ffi_data_nullable_age(
    cleanup_ffi_data(ap, sp);
    let actual_crc = compute_file_crc32(&filename);
fn test_complete_writer_lifecycle() {
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    settings.reverse_sorts = vec![false];
    let (ap, sp) = create_ffi_data_with_row_id(
    assert_eq!(row_ids, vec![0, 1, 2]);
fn test_write_data_multiple_batches() {
                        .iter()
#[test]
    let (_schema1, schema_ptr1) = create_writer_and_assert_success(&filename1);
        filename.clone(),
    assert!(
        Some("1.0.0.0"),
        "Permutation mapping should map original row IDs to new sorted positions"
    .unwrap();
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
fn test_crc32_differs_for_different_content() {
                            if ids == vec![10, 20, 30] {
    // age=20: score=50, score=30, score=10 (DESC)
    use arrow::array::{Array, ArrayRef, AsArray, Int64Array};
        assert_eq!(
    // Original: age=[50,30,10,40,20,25,55,15,35,45], row_ids=[0..9]
    }
            Some("A"),
        "Single chunk path should honor bloom_filter_enabled=true"
}
                success_count.fetch_add(1, Ordering::SeqCst);
        schema_ptr,
fn read_scores_from_parquet(filename: &str) -> Vec<i32> {
    let ages = read_ages_from_parquet(&filename);
// ===== Arrow IPC staging path tests =====
    let ids = read_parquet_file_sorted_ids(&filename);
    assert_eq!(row_ids, vec![0, 1, 2, 3, 4]);
}
            Some("F"),
    let gen = read_writer_generation_from_parquet(&filename);
    // 10 rows × 8 bytes = 80 bytes minimum (could be more if split across chunks)
        return vec![];
        vec![false],
// CRC32 tests
    .unwrap();
        Some(55),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    // Unsorted: data should preserve insertion order
        ])),
        .expect("score should be Int32");
        schema_ptr2,
    assert_eq!(mem_final, 0, "Memory should be 0 after writer is finalized");
    let result = NativeParquetWriter::finalize_writer(filename.clone());
            Some("I"),
    // Verify mapping is a valid permutation (contains each value 0..N exactly once)
    settings.sort_columns = vec!["age".to_string()];
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    settings.reverse_sorts = vec![false];
fn test_chunked_writer_generation_in_metadata_multi_chunk() {
fn test_chunked_writer_batch_slicing_large_batch() {
/// Only writers whose temp path starts with the prefix should be counted.
        filename1.clone(),
    settings.sort_columns = vec!["age".to_string()];
    assert_eq!(
    // age=20: score=30, score=50 (ASC)
fn test_write_data_no_ipc_writer() {
        .unwrap()
    ]));
            Some("D"),
#[test]
        .index_of(ROW_ID_COLUMN_NAME)
    );
    );
    assert_eq!(row_ids, vec![0, 1, 2, 3, 4]);
        index_name.to_string(),
    assert_eq!(mapping, vec![7, 1, 5, 3, 0, 6, 2, 4]);
    let struct_array = arrow::array::StructArray::from(record_batch);
    settings.sort_in_memory_threshold_bytes = Some(64); // Tiny — forces multiple chunks
        }
        vec![
            Some("G"),
// ===== write_data to non-existent writer (IPC variant) =====
    let index_name = "test-props-defaults-multi";
#[test]
            Some("H"),
    // Verify it's a valid permutation
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
        schema_ptr,
            let file_path = temp_dir_path.join(format!("ipc_concurrent_{}.parquet", i));
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
        .map(|row| descending_ids.value(row))
    settings.nulls_first = vec![false];
    // Previously writer_generation was lost in the k-way merge path. This has been fixed —
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
// to force multiple flush_and_sort_chunk calls, then verify:
    );
        }
    assert_eq!(
    let format_version = read_format_version_from_parquet(&filename);
        vec![false],
    )
    // Verify writer_generation in metadata
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
}
        "Mapping must be a valid permutation even with all-identical sort keys"
        Field::new("name", DataType::Utf8, true),
        vec!["age".to_string()],
            Some("A"),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        0,
        .downcast_ref::<arrow::array::ListArray>()
    let stored = SETTINGS_STORE.get(index_name).unwrap();
    );
fn read_format_version_from_parquet(filename: &str) -> Option<String> {
        schema_ptr,
    // mapping[3]=3(40→pos3), mapping[4]=0(10→pos0), mapping[5]=8(90→pos8),
    use arrow::buffer::{NullBuffer, OffsetBuffer};
            true,
            Some("H"),
    )
            Arc::new(Int64Array::from(vec![1, 2, 3, 4, 5])) as ArrayRef,
    let sorted = NativeParquetWriter::sort_batch(
        vec![50, 30, 10, 40, 20],
        vec![false],
                vec![],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let settings = NativeSettings::default();
}
        vec![0, 1, 2, 3, 4],
}
    ipc_writer.finish().unwrap();
    // Memory should be proportional to rows written × sizeof(i64)
        "Multi chunk (k-way merge) path should honor SNAPPY compression, got: {:?}",
    NativeParquetWriter::create_writer(
    SETTINGS_STORE.remove(index_name);
    let batch = RecordBatch::try_new(
    settings.sort_in_memory_threshold_bytes = Some(100); // ~2 rows fit
    let descending =
    NativeParquetWriter::create_writer(
    let mut settings = NativeSettings::default();
    settings.sort_columns = vec!["age".to_string()];
    settings.nulls_first = vec![false];
    let writer_generation = 77i64;
    assert_eq!(
    cleanup_ffi_schema(schema_ptr);
    assert!(
    let mut expected_sorted = ages.clone();
    )
fn test_chunked_writer_crc32_single_chunk() {
        vec!["age".to_string()],
    use arrow::array::Int32Array;
    let row_ids = read_row_ids_from_parquet(&filename);
#[test]
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    }
    let ids = read_parquet_file_sorted_ids(&filename);
#[test]
    let success_count = Arc::new(AtomicUsize::new(0));
    let mut settings = NativeSettings::default();
                "tags",
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
        Some("1.0.0.0"),
        NativeParquetWriter::sort_batch(&batch, &["tags".to_string()], &[true], &[false], &[false])
        "row_id_mapping should be None without __row_id__ column"
    let (_schema, schema_ptr2) = create_row_id_schema_ptr();
    assert_eq!(
    for i in 0..num_rows as usize {
    let (_schema, schema_ptr) = create_nullable_schema_ptr();
    );
    );
        })
        writer_generation,
    assert_eq!(streaming_crc32, reread_crc32);
        writer_generation,
 * The OpenSearch Contributors require contributions made to
#[test]
    );
        index_name2.to_string(),
        .as_primitive::<arrow::datatypes::Int64Type>();
    (0..col.len()).map(|i| col.value(i)).collect()
    assert_eq!(
    let index_name = "test-gen-zero";
    // Finalize both
        &[false],
    NativeParquetWriter::create_writer(
        .downcast_ref::<Int32Array>()
    let index_name = "test-gen-single";
#[test]
    let (ap2, sp2) =
    assert_eq!(ages, vec![10, 20, 30, 40, 50]);
        "Output should be sorted by age ASC"
        OffsetBuffer::new(vec![0_i32, 2, 4].into()),
        vec![10, 15, 20, 25, 30, 35, 40, 45, 50, 55],
}
                "test-index".to_string(),
    names: Vec<Option<&str>>,
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    settings.sort_columns = vec!["age".to_string()];
        vec![],
    settings.sort_columns = vec!["age".to_string()];
    let index_name = "test-chunked-large";
        "CRC32 should be non-zero for a file with data"
    let idx = combined.schema().index_of("age").unwrap();
}
    let mut settings = NativeSettings::default();
        "__row_id__ should be sequential 0..9 in merged output"
    cleanup_ffi_schema(sp2);
    let ages = read_ages_from_parquet(&filename);
        index_name.to_string(),
        .column(0)
    assert!(
        .unwrap()
    );
            for _ in 0..2 {
        Field::new("name", DataType::Utf8, true),
    assert_eq!(
    let (_temp_dir1, filename1) = get_temp_file_path("crc32_diff_a.parquet");
fn read_row_ids_from_parquet(filename: &str) -> Vec<i64> {
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            i, original_ages[i], new_pos
                schema_ptr,
    let success_count = Arc::new(AtomicUsize::new(0));
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            Some("H"),
        schema_ptr,
#[test]
        .unwrap()
        0,
            Some("F"),
        !has_bloom_filter_in_parquet(&filename),
    cleanup_ffi_schema(schema_ptr);
        vec![false],
    )
    SETTINGS_STORE.remove(index_name1);
    (schema, schema_ptr)
        vec![false],
    let row_ids: Vec<i64> = (0..10).collect();
        cleanup_ffi_data(array_ptr, data_schema_ptr);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
) -> Vec<Option<Vec<Option<String>>>> {
    let mut settings = NativeSettings::default();
    assert_ne!(crc32_empty, crc32_with_data);
    let ages = read_ages_from_parquet(&filename);
            Some("D"),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
            Arc::new(list) as ArrayRef,
    );
    // mapping[original_row_id] = new_position
    .unwrap();
        vec![30, 30, 30, 30, 30],
    // No sort columns — uses direct Parquet writer path
            ),
        if n == 0 {
            Some("D"),
    use arrow::datatypes::{DataType, Field, Schema};
    let row_ids = read_row_ids_from_parquet(&filename);
    // Original: age=[30, NULL, 10, NULL, 20], row_ids=[0,1,2,3,4]
        .row_id_mapping
    );
    let invalid_path = "/invalid/path/that/does/not/exist/test.parquet";
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    assert!(metadata.metadata.file_metadata().version() > 0);
fn create_row_id_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
        create_test_ffi_data_with_ids(vec![30, 10, 20], vec![Some("C"), Some("A"), Some("B")])
    NativeParquetWriter::create_writer(
        vec![],
    unimplemented!("sort_small_file/sort_large_file are commented out");
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
    // Configure with tiny threshold to force multiple chunks
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
        filename.clone(),
    let temp_dir = tempdir().unwrap();
        .column(0)
        filename.clone(),
// #[test]
        Field::new("score", DataType::Int32, false),
/// Test: Empty writer finalize — no data written, should produce valid empty Parquet.
    assert!(
    // Verify: for each original row, mapping[original_row_id] gives its position
    }
    let (ap, sp) = create_ffi_data_with_row_id(
// 2. The permutation mapping correctly maps original_row_id → new_position
    assert_eq!(
        create_test_ffi_data_with_ids(vec![20, 40], vec![Some("B"), Some("D")]).unwrap();
    );
    NativeParquetWriter::create_writer(
    }
        vec![30, 10, 50, 20, 40],
    // Verify sequential row IDs
}
    .unwrap();
                    .collect(),
            sorted_ages[new_pos], ages[i],
    (schema, schema_ptr)
/// Test: Multi-column sort with forced multi-chunk — verifies the k-way merge
        schema_ptr,
        vec![50, 30, 10, 40, 20],
    (schema, schema_ptr)
    // Sorted:   age=[10,20,30,40,50,60,70,80]
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
        filename.clone(),
    let (ap, sp) = create_ffi_data_with_row_id(
}
}
                    .map(|index| {
        .unwrap()
    .unwrap();
    // The final Parquet file should exist
    let row_ids = read_row_ids_from_parquet(&filename);
        vec![Some("C"), Some("X"), Some("A"), Some("Y"), Some("B")],
        .unwrap();
        index_name.to_string(),
    let sorted_ages = read_ages_from_parquet(&filename);
    // The two NULLs were at original positions 1 and 3 (stable order preserved by RowConverter)
        filename.clone(),
    NativeParquetWriter::create_writer(
        vec![50, 40, 30, 20, 10],
        vec!["age".to_string()],
            Some("J"),
    // mapping[0]=4(50→pos4), mapping[1]=0(10→pos0), mapping[2]=2(30→pos2),
    let finalize_result = result.unwrap().unwrap();
#[test]
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
// ===== SortingChunkedWriter and finalize_sorted_chunks tests =====
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        has_bloom_filter_in_parquet(&filename),
    // Verify data correctness
    // Sorted positions: NULL(row1)→pos0, NULL(row3)→pos1, 10(row2)→pos2, 20(row4)→pos3, 30(row0)→pos4
        schema_ptr,
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        vec![50, 20, 30, 40, 60],
        None,
    SETTINGS_STORE.remove(index_name);
        ages,
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    assert_eq!(mapping.len(), 6);
    .unwrap();
    // Verify sequential row IDs
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    settings.reverse_sorts = vec![false];
        filename.clone(),
    // is roughly 40-80 bytes in Arrow memory. Set threshold to allow ~2 rows.
    settings.sort_in_memory_threshold_bytes = Some(1); // Force per-row slicing
    // Don't create any writer — just try to write data
        let filename = filename.clone();
        if rg.column(i).bloom_filter_offset().is_some() {
        vec!["age".to_string()],
    assert_eq!(mapping.len(), 5);
    assert_eq!(ages, vec![10, 10, 20, 20, 20]);
    assert_eq!(mapping.len(), 5);
        vec![],
    let (ap1, sp1) =
}
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
                vec![false],
/// Test: UNCOMPRESSED setting is honored in multi chunk path.
}
    // CRC should be non-zero for a file with data
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    );
        vec![],
        .collect::<Vec<_>>();
    );
        vec![10, 20, 30, 40, 50],
    let (_temp_dir, filename) = get_temp_file_path("concurrent_write_ffi.parquet");
    cleanup_ffi_schema(schema_ptr);
        index_name.to_string(),
    let schema = Arc::new(Schema::new(vec![
        .unwrap()
    use arrow::datatypes::{DataType, Field, Schema};
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let index_name = "test-list-sort-multi-chunk";
        vec![20, 10, 20, 10, 30, 20, 10, 30, 20, 10],
    (array_ptr, schema_ptr)
    // Verify permutation mapping
    )
    let index_name = "test-no-rowid-slice";
        "Single chunk path should honor ZSTD compression, got: {:?}",
    let list = ListArray::new(
}
                vec![],
        create_test_ffi_data_with_ids(vec![30, 10, 50], vec![Some("C"), Some("A"), Some("E")])
        vec![Some("A"), Some("B"), Some("C")],
            Some(
        vec![false],
        .column(0)
    let index_name = "test-multi-sort-chunked";
#[test]
/// NOTE: Currently the k-way merge path (merge_sorted) does not propagate writer_generation
        vec![false],
    SETTINGS_STORE.remove(index_name);
    // Set threshold to 1 byte — every batch will exceed it and trigger slicing.
/// Verifies that slicing works correctly across multiple write calls.
    let list = ListArray::new(
        mapping,
        vec![
    // Verify sequential row IDs
    let (_temp_dir1, sorted_file) = get_temp_file_path("ipc_sorted.parquet");
    settings.nulls_first = vec![false];
        let mut missing = missing.to_vec();
        "CRC32 from finalize should match recomputed CRC of the file on disk"
        .unwrap();
        .as_primitive::<arrow::datatypes::Int64Type>();
    // Verify compression is SNAPPY in the merged output
                vec![],
fn test_multi_column_sort_multi_chunk() {
                    .is_ok()
    )
    let struct_array = arrow::array::StructArray::from(record_batch);
    SETTINGS_STORE.remove(index_name);
        finalize_result.row_id_mapping.is_none(),
    let idx = combined
    let gen = read_writer_generation_from_parquet(&filename);
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    cleanup_ffi_data(array_ptr, schema_ptr);
    let mapping = finalize_result
            Some("J"),
        invalid_path.to_string(),
    settings.sort_in_memory_threshold_bytes = Some(256); // Force many chunks
        vec![5, 6, 7, 8, 9],
    );
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    settings.reverse_sorts = vec![false];
        filename.clone(),
    let index_name = "test-props-empty";
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        vec![false],
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    let (_schema, schema_ptr1) = create_row_id_schema_ptr();
    assert_eq!(ages, vec![None, None, Some(10), Some(20), Some(30)]);
    SETTINGS_STORE.remove(index_name);
/// Test: writer_generation is stored in Parquet metadata for sorted single-chunk output.
        finalize_result.crc32, actual_crc,
    for handle in handles {
        vec![],
    settings.sort_in_memory_threshold_bytes = Some(64); // Force chunking
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    // Verify compression is UNCOMPRESSED
        Some("1.0.0.0"),
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
#[test]
        vec![0, 1, 2, 3, 4],
    let row_ids = read_row_ids_from_parquet(&filename);
        .unwrap_err()
}
    }
    settings.sort_columns = vec!["age".to_string()];
                if write_ok {
        .expect("Should have row_id_mapping");
        vec![30, 10, 50, 20, 40],
        let file_path = temp_dir
        vec![false],
    settings.sort_columns = vec!["age".to_string()];
            DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
        index_name.to_string(),
        Some(vec![Some("z"), Some("delta"), Some("z")]),
    assert_eq!(ages, vec![10, 10, 10, 10, 20, 20, 20, 20, 30, 30]);
    assert_eq!(scores, vec![40, 20, 50, 30, 10]);
    // Original: age=[80,20,60,40,10,70,30,50], row_ids=[0..7]
    close_writer_and_cleanup_schema(&filename2, schema_ptr2);
    let result1 = NativeParquetWriter::finalize_writer(filename1.clone());
    let (_temp_dir, filename) = get_temp_file_path("mem_ipc.parquet");
        vec![false],
        filename.clone(),
        .unwrap()
    let expected_perm: Vec<i64> = (0..10).collect();
    // Sorted:   age=[10,15,20,25,30,35,40,45,50,55]
            Some("I"),
    use arrow::datatypes::{DataType, Field, Schema};
    let row_ids = read_row_ids_from_parquet(&filename);
    SETTINGS_STORE.remove(index_name);
    let gen = read_writer_generation_from_parquet(&filename);
    .unwrap();
    .unwrap();
        "Data should be sorted descending by id"
    assert_eq!(mapping.len(), 10);
/// Test: nulls_first=false with __row_id__ — NULLs at end, verifies permutation.
        vec![],
        "Multi chunk (k-way merge) path should honor ZSTD compression, got: {:?}",
        schema_ptr,
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
fn test_ipc_staging_has_writer_returns_true() {
fn test_bloom_filter_false_propagates_through_settings_store() {
            Some("B"),
    settings.reverse_sorts = vec![false];
    assert!(
/// Test: Large dataset with forced multi-chunk — stress test with more rows.
    SETTINGS_STORE.remove(index_name);
    let row_ids = read_row_ids_from_parquet(&filename);
fn create_multi_sort_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
// }
    SETTINGS_STORE.remove(index_name);
        let new_pos = mapping[i] as usize;
        vec![Some("D"), Some("B"), Some("F")],
    use arrow::array::{ArrayRef, AsArray, Int64Array, RecordBatch};
}
        let handle = thread::spawn(move || {
        schema_ptr,
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            Some("E"),
        finalize_result.crc32, 0,
        OffsetBuffer::new(vec![0_i32, 2, 3, 3, 3, 5, 6].into()),
        index_name.to_string(),
    )
    // age=10: score=60
#[test]
    // age=20: scores 10, 30, 40, 50
    let scores = read_scores_from_parquet(&filename);
fn test_chunked_writer_multi_chunk_row_ids_sequential() {
        writer_generation,
        Arc::new(Field::new("element", DataType::Utf8, true)),
    let (_temp_dir, filename) = get_temp_file_path("multi_sort_asc_desc.parquet");
        Field::new("age", DataType::Int32, true), // nullable
}
fn create_ffi_data_no_row_id(ages: Vec<i32>, names: Vec<Option<&str>>) -> (i64, i64) {
    let row_ids = read_row_ids_from_parquet(&filename);
        vec![false],
            Some("A"),
    let index_name = "test-props-multi-uncompressed";
    (0..lists.len())
        vec![false],
}
    )
        vec![false],
    settings.sort_in_memory_threshold_bytes = Some(64); // Force multiple chunks
    // Sorted order:   (10,70), (20,80), (20,40), (30,90), (30,50), (30,10)
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
use crate::test_utils::*;
            } else {
    SETTINGS_STORE.remove(index_name);
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
// These tests verify sorting on 2+ columns with mixed sort directions.
    // Verify bloom filter IS present (enabled)
            Some("E"),
#[test]
    settings.sort_columns = vec!["age".to_string()];
) -> (i64, i64) {
#[test]
    let (array_ptr, data_schema_ptr) = create_mismatched_ffi_data().unwrap();
    SETTINGS_STORE.remove(index_name);
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
// TODO: Re-enable when sort_small_file/sort_large_file are uncommented
}
/// Both paths must produce identical mapping[original_row_id] = new_position.
    cleanup_ffi_data(ap1, sp1);
        "Data should preserve insertion order"
    // Verify sort: ascending non-nulls, then NULLs last
    );
}
/// Verifies the slicing + sort works when there's no row ID to rewrite.
        stored_after.bloom_filter_enabled,
    settings.nulls_first = vec![false];
    SETTINGS_STORE.insert(index_name.to_string(), settings);
            sorted_ages[new_pos], original_ages[i],
        gen,
    let file_count = 8;
    // Verify writer generation
        Field::new(
        vec![],
    use parquet::file::reader::{FileReader, SerializedFileReader};
/// Test: Writer properties (SNAPPY compression, bloom filter disabled) are honored
