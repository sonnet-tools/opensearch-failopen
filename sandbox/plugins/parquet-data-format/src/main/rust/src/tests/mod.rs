    // merge_sorted now propagates writer_generation into the output file metadata.
        vec![false],
        vec![false],
/// written across multiple batches is correctly sorted and has sequential row IDs.
    // Verify sorted output — empty batch should have no effect
    // Sorted:   age=[5,10,15,20,30,35,40,45,50,60]
/// Test: writer_generation is stored in Parquet metadata for multi-chunk merged output.
    // age=10: scores 10, 30, 50, 70
        handle.join().unwrap();
    let result = NativeParquetWriter::write_data(filename.clone(), 0, 0);
        vec![30, 10, 50, 20, 40],
    for i in 0..10 {
    let (ap, sp) = create_ffi_data_with_row_id(
        .expect("age should be Int32");
    assert!(result.is_ok());
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
#[test]
    let result = NativeParquetWriter::finalize_writer(filename.clone());
        index_name.to_string(),
    cleanup_ffi_data(array_ptr, data_schema_ptr);
}
        vec![age_array, score_array, name_array, row_id_array],
            if NativeParquetWriter::create_writer(
        schema_ptr,
        0,
    assert_eq!(ages, vec![10, 10, 10, 10, 20, 20, 20, 20, 30, 30]);
    let schema = Arc::new(Schema::new(vec![
}
//     run_sort_permutation_test(false, "small_file");
        0,
        vec![10, 20, 30, 40, 50],
    assert_eq!(row_ids, vec![0, 1, 2, 3, 4, 5]);
        vec![false],
/// Test: Writing a 0-row batch to a sorted writer doesn't corrupt state.
            Some("C"),
    settings.reverse_sorts = vec![false];
    assert!(mem1 >= 0, "Writer 1 memory should be reported");
    assert_eq!(
            .and_then(|v| v.parse::<i64>().ok())
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
        has_bloom_filter_in_parquet(&filename),
    let index_name = "test-gen-multi";
// does NOT contain a __row_id__ column. In this case, flush_and_sort_chunk should
}
        ],
fn read_format_version_from_parquet(filename: &str) -> Option<String> {
    let mem_after =
    assert!(close_result.is_ok());
    settings.bloom_filter_enabled = Some(false);
    // Disabled: sort_small_file and sort_large_file are currently commented out in writer.rs
}
        .unwrap_err()
    let mut schema_ptrs = vec![];
        vec![false],
    assert_eq!(descending_missing, vec![30, 40, 60]);
    let (ap1, dp1) =
        vec![80, 20, 60, 40, 10, 70, 30, 50],
/// Test: writer_generation is stored in Parquet metadata for sorted single-chunk output.
    let (_schema, schema_ptr) = create_nullable_schema_ptr();
        vec!["age".to_string()],
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    SETTINGS_STORE.remove(index_name);
        .expect("score column should exist");
    )
        Field::new("name", DataType::Utf8, true),
fn test_write_data_invalid_pointers() {
            true,
                let (ap, sp) = create_test_ffi_data().unwrap();
    settings.nulls_first = vec![false];
        vec![20, 30, 20, 30, 10],
        index_name.to_string(),
    .unwrap();
    // Expected: age ASC, then score ASC within same age
        vec![30, 10, 20],
}
    );
    NativeParquetWriter::create_writer(
    assert_eq!(mapping.len(), 10);
    settings.sort_columns = vec!["age".to_string()];
fn test_unsorted_writer_preserves_insertion_order() {
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let mut settings = NativeSettings::default();
    );
        vec![],
        vec![true],
    // Verify bloom filter IS present
        writer_generation,
    let ids = read_parquet_file_sorted_ids(&filename);
        vec![30, 20, 30, 20, 10, 30], // ages: ties at 20 and 30
        let filename = filename.clone();
    settings.sort_in_memory_threshold_bytes = Some(64); // Force multiple chunks
        vec![],
        vec![],
        vec![false],
                vec![false],
    assert_eq!(mapping.len(), 6);
        Box::into_raw(Box::new(ffi_array)) as i64,
}
    let metadata = reader.metadata().file_metadata();
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        vec!["age".to_string()],
    assert_eq!(
    let expected: Vec<i64> = (0..9).collect();
        vec![],
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
    use arrow::datatypes::{DataType, Field, Schema};
    let (_temp_dir, filename) = get_temp_file_path("props_defaults_single.parquet");
/// and permutation mapping is correct.
        index_name.to_string(),
        0,
            Some("H"),
    let mut settings = NativeSettings::default();
        vec![0, 1, 2],
            Arc::new(Int64Array::from(ages.to_vec())),
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    NativeParquetWriter::create_writer(
    for handle in handles {
        vec![50, 30, 10, 70, 20, 40, 10, 60, 30, 50],
        index_name.to_string(),
        result1.crc32, result2.crc32,
        vec![],
/// Helper: creates FFI data with nullable age + __row_id__.
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
            Some("D"),
        vec![],
    .unwrap();
    use arrow::record_batch::RecordBatch;
fn test_writer_properties_honored_single_chunk_uncompressed() {
fn create_ffi_data_multi_sort(
        let new_pos = mapping[i] as usize;
    let record_batch = RecordBatch::try_new(
        ages,
    scores: Vec<i32>,
    // Default bloom filter is enabled
#[test]
    let (_temp_dir, filename) = get_temp_file_path("props_single_zstd.parquet");
    let (_, schema_ptr) = create_row_id_schema_ptr();
    SETTINGS_STORE.remove(index_name);
    let (ap, sp) = create_ffi_data_no_row_id(
                    if let Ok(Some(metadata)) =
        let (missing, values) = if nulls_first {
    let mapping = finalize_result
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    SETTINGS_STORE.remove(index_name);
    assert_eq!(success_count.load(Ordering::SeqCst), file_count * 2);
    settings.reverse_sorts = vec![false];
    settings.compression_type = Some("SNAPPY".to_string());
    )
        offsets.push(values.len() as i32);
    assert!(
    // Query with prefix that matches only writer 1's directory
#[test]
        let handle = thread::spawn(move || {
    // Before writing, memory should be 0 (no chunks flushed yet)
        vec![false],
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    )
}
    let index_name = "test-multi-sort-slice";
        "Default compression should be LZ4_RAW in multi-chunk path, got: {:?}",
        .column(idx)
    assert_eq!(sorted_ages, vec![0, 11, 22, 33, 44, 55, 66, 77, 88, 99]);
    let success_count = Arc::new(AtomicUsize::new(0));
/// It does NOT assert a specific tie-breaking order.
// These tests exercise the chunked sort path by setting a very small memory threshold
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    assert_eq!(
    assert!(file_path.exists());
            Some("F"),
    let result = NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr);
                schema_ptr,
    assert_eq!(mapping.len(), 5);
    )
    assert!(
    let writer_generation = 7i64;
#[test]
    let index_name = "test-no-rowid-single";
        });
        "Output should be sorted by age ASC"
//     run_sort_permutation_test(true, "large_file");
        "Writer should be open"
    let struct_array = arrow::array::StructArray::from(record_batch);
        ages,
    assert_eq!(
            Some("C"),
    settings.sort_columns = vec!["age".to_string()];
    assert_eq!(mapping, vec![7, 1, 5, 3, 0, 6, 2, 4]);
    assert_eq!(missing_ids, vec![4, 5]);
    let mut settings = NativeSettings::default();
    }
            }
            Some("beta"),
    );
    settings.sort_columns = vec!["tags".to_string()];
        "IPC path should support descending sort"
    let index_name = "test-chunked-multi";
        vec![Some("C"), Some("A"), Some("B")],
    let (ap1, sp1) = create_ffi_data_with_row_id(
    //   id=20 tags=["m","n"] -> MAX="n"
    let ages = read_ages_from_parquet(&filename);
    settings.sort_columns = vec!["age".to_string()];
fn create_ffi_data_with_row_id(
        schema_ptr,
        filename.clone(),
            Some("E"),
    )
    NativeParquetWriter::create_writer(
    let (_temp_dir, filename) = get_temp_file_path("no_rowid_multi.parquet");
    assert_ne!(
        .collect::<Vec<_>>();
        compression
}
    SETTINGS_STORE.remove(index_name);
    let (_temp_dir, filename) = get_temp_file_path("nulls_last_rowid.parquet");
    let gen = read_writer_generation_from_parquet(&filename);
            .map(|row| descending_ids.value(row))
    settings.reverse_sorts = vec![false];
    (0..lists.len())
            Field::new("id", DataType::Int64, false),
        Some(vec![None, Some("charlie")]),
    let result = NativeParquetWriter::write_data(filename.clone(), ap, sp);
    settings.nulls_first = vec![false];
    let result = NativeParquetWriter::create_writer(
    assert_eq!(missing_values.get(&5), Some(&None));
    arrow::array::ListArray::new(
#[test]
    for _ in 0..3 {
    expected_sorted.sort();
    ];
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
/// Helper: reads a Parquet file and returns the "age" column values as i32.
    let scores = read_scores_from_parquet(&filename);
    );
    // Default compression is LZ4_RAW
        .unwrap();
    );
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    )
}
        Field::new("age", DataType::Int32, false),
    // Verify permutation:
    // mapping[3]=3(40→pos3), mapping[4]=0(10→pos0), mapping[5]=8(90→pos8),
// }
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
    );
    }
        vec![false],
    );
    let (ap, sp) = create_ffi_data_with_row_id(
}
/// Helper: creates FFI schema with (age: Int32, score: Int32, name: Utf8, __row_id__: Int64).
                success_count.fetch_add(1, Ordering::SeqCst);
            Some("C"),
    settings.nulls_first = vec![false];
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    // Unsorted file should preserve insertion order
        vec![20, 10, 20, 10, 30, 20, 10, 30, 20, 10],
    .unwrap();
    // Verify sequential row IDs
        vec!["age".to_string()],
        compression
    let original_ages = vec![55, 22, 88, 11, 44, 77, 33, 66, 99, 0];
    settings.sort_in_memory_threshold_bytes = Some(64); // Force multiple chunks
    assert!(result.is_err());
    assert!(result.is_ok());
    // Verify descending sort
    );
        filename.clone(),
            Some(
    // Multi-chunk merge also produces a CRC (from merge_sorted's CrcWriter)
    assert_eq!(
    assert!(result
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
        filename.clone(),
        0,
    );
    let mut settings = NativeSettings::default();
fn test_close_multiple_times_same_file() {
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
        .to_string()
        schema_ptr2,
    // mapping[0]=8 (age=50→pos8), mapping[1]=4 (age=30→pos4), mapping[2]=1 (age=10→pos1)
        ids,
    );
        vec![false],
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
/// - The output is valid (all ages are 30)
            Some("H"),
        .collect::<std::collections::HashMap<_, _>>();
        None,
    let writer_generation = 42i64;
    let input_rows = vec![
    assert!(result.unwrap_err().to_string().contains("Writer not found"));
        schema_ptr,
}
/// Test: nulls_first=false with __row_id__ — NULLs at end, verifies permutation.
    let schema = Arc::new(Schema::new(vec![
    settings.sort_columns = vec!["age".to_string()];
            let (_schema, schema_ptr) = create_test_ffi_schema();
    .unwrap();
        0,
    let file = File::open(filename).unwrap();
    assert_eq!(
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    );
                {
/// Test: Large writer_generation value is preserved through the single-chunk sort path.
    let compression = read_compression_from_parquet(&filename);
    let batches = read_parquet_file(filename);
        writer_generation,
    assert_eq!(ages, vec![Some(10), Some(20), Some(30), None, None]);
        &[false],
    // Verify permutation
    let ages = read_ages_from_parquet(&filename);
    );
fn test_write_data_no_writer() {
    // mapping[0]=4, mapping[1]=1, mapping[2]=3, mapping[3]=2, mapping[4]=0, mapping[5]=5
    assert_eq!(
}
    )
        "test-index".to_string(),
        filename.clone(),
/// Both paths must produce identical mapping[original_row_id] = new_position.
                true,
        vec![
    };
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        ),
        ages,
        NativeParquetWriter::sort_batch(&batch, &["tags".to_string()], &[true], &[false], &[false])
    let temp_dir = tempdir().unwrap();
    // Verify sort: NULLs first, then ascending
#[test]
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    assert!(result.is_ok(), "create_writer failed: {:?}", result.err());
    assert!(
        row_ids_in_file,
        Field::new("age", DataType::Int32, false),
        vec![10, 20, 30],
    assert!(NativeParquetWriter::has_writer(&filename));
            )
        schema_ptr2,
    let batch = RecordBatch::try_new(
    let (_temp_dir, filename) = get_temp_file_path("chunked_large.parquet");
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    let settings = NativeSettings {
            Some("B"),
        "Default compression should be LZ4_RAW, got: {:?}",
#[test]
    let mut settings = NativeSettings::default();
    assert_eq!(format_version.as_deref(), Some("1.0.0.0"));
fn test_write_data_incompatible_schema() {
    (array_ptr, schema_ptr)
        vec![50, 10, 30, 20, 40],
    ]));
    let (_temp_dir, filename) = get_temp_file_path("no_rowid_slice.parquet");
    let (ap_empty, sp_empty) = create_ffi_data_with_row_id(vec![], vec![], vec![]);
            Some("I"),
    settings.sort_in_memory_threshold_bytes = Some(64);
    NativeParquetWriter::create_writer(
        .unwrap()
    assert!(
        0,
    );
    settings.sort_columns = vec!["age".to_string()];
    let file_count = 8;
            ages[new_pos], original_ages[i],
    );
    false
    )
        ids,
        vec![],
        vec![],
        .unwrap();
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 6);
        schema_ptr,
    let mut settings = NativeSettings::default();
    settings.sort_columns = vec!["age".to_string()];
    let batch = RecordBatch::try_new(
    assert!(finalize_result.row_id_mapping.is_none());
/// in the MULTI CHUNK path (k-way merge).
            Some("A"),
        matches!(compression, parquet::basic::Compression::UNCOMPRESSED),
    NativeParquetWriter::create_writer(
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
    );
        ],
/// Test: Single chunk (all data fits in memory) — verifies row IDs are sequential
    // Verify bloom filter IS present (enabled)
            Some("B"),
    );
        Field::new("age", DataType::Int32, false),
        vec![false],
    );
        ],
    let batch = RecordBatch::try_new(
    // Empty file has no row groups, so we can't check compression or bloom filter
        vec!["age".to_string()],
    .unwrap();
        ]
        vec![],
        &[false],
    );
    let row_ids = read_row_ids_from_parquet(&filename);
    let (_temp_dir1, filename1) = get_temp_file_path("crc_diff1.parquet");
    );
        &lists[..4],
        vec![false],
        vec![0, 1, 2, 3, 4],
    let read_metadata = NativeParquetWriter::get_file_metadata(filename.clone()).unwrap();
#[test]
    // Verify output is sorted by age ascending
                vec![false],
        schema_ptr,
    let row_ids: Vec<i64> = (0..num_rows as i64).collect();
    let thread_count = 6;
    // mapping[5]=3, mapping[6]=9, mapping[7]=1, mapping[8]=5, mapping[9]=7
        vec!["age".to_string()],
// ===== Multi-column sort tests =====
) -> (i64, i64) {
            Some("I"),
    let (_temp_dir, filename) = get_temp_file_path("crc32_with_data.parquet");
        "has_writer should return true for IPC writer"
            Arc::new(Int64Array::from(row_ids.to_vec())),
        filename.clone(),
    .unwrap();
    .unwrap();
    );
// These tests verify that writer properties (compression, bloom filter, format version,
        format_version.as_deref(),
use crate::writer::SETTINGS_STORE;
            Some("F"),
#[test]
    let stored_after = SETTINGS_STORE.get(index_name).unwrap();
    let col = combined
    let prefix = _temp_dir.path().to_string_lossy().to_string();
        schema_ptr,
    use arrow::array::{Array, Int32Array, StringArray};
    let (ap1, sp1) =
        vec![],
/*
        index_name.to_string(),
#[test]
    let result = NativeParquetWriter::create_writer(
        vec![false],
    let (ap, sp) = create_ffi_data_with_row_id(
}
    SETTINGS_STORE.remove(index_name);
    let index_name = "test-props-single-snappy";
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
            Some("a"),
    SETTINGS_STORE.remove(index_name);
    use arrow::compute::concat_batches;
        .unwrap();
}
        vec![0, 1, 2, 3, 4],
    // Verify CRC is valid
        vec![],
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    let (_temp_dir, filename) = get_temp_file_path("multi_write_ffi.parquet");
        vec![false],
        .unwrap()
    assert_eq!(success_count.load(Ordering::SeqCst), 5);
    let ids = combined
}
    // Verify __row_id__ is sequential 0..N
fn test_chunked_writer_generation_large_value() {
#[test]
    let ages = read_nullable_ages_from_parquet(&filename);
        vec!["age".to_string(), "score".to_string()],
    let (_temp_dir, filename) = get_temp_file_path("slice_desc.parquet");
            Some("I"),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
}
/// - The permutation mapping is a valid permutation (bijection of 0..N)
        .unwrap()
            Some("C"),
    let mut settings = NativeSettings::default();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let row_ids = read_row_ids_from_parquet(&filename);
fn test_writer_properties_honored_single_chunk_snappy_no_bloom() {
    // Verify: original_ages[i] should appear at position mapping[i] in sorted output
        let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
        index_name.to_string(),
fn test_chunked_writer_generation_zero() {
        "CRC32 should be non-zero for a file with data"
            Some("A"),
    .unwrap();
        Some(vec![]),
    assert_eq!(mapping.len(), num_rows as usize);
// ===== Writer generation tests =====
    use arrow::datatypes::{DataType, Field, Schema};
    );
    assert_eq!(row_ids, vec![0, 1, 2, 3, 4]);
}
        filename.clone(),
        0,
}
        vec![50, 30, 10, 40, 20],
        vec![Some("C"), Some("X"), Some("A"), Some("Y"), Some("B")],
#[test]
    let crc32_with_data = result2.unwrap().unwrap().crc32;
    let file = File::create(&ipc_path).unwrap();
            Some("D"),
    NativeParquetWriter::write_data(filename.clone(), ap3, sp3).unwrap();
}
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        "Output should be globally sorted despite batch slicing"
    settings.nulls_first = vec![false];
    let (_schema2, sp2) = create_writer_and_assert_success(&unsorted_file);
        finalize_result.metadata.file_metadata().num_rows(),
        handles.push(handle);
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
            .is_ok()
        let ids = sorted
        .unwrap();
    );
    );
fn test_chunked_writer_crc32_single_chunk() {
        match row {
fn test_chunked_writer_generation_in_metadata_multi_chunk() {
    assert_eq!(
        vec![0, 1, 2, 3, 4],
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
        vec![true],
}
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
#[test]
            } else {
    )
        schema_ptr,
}
        create_test_ffi_data_with_ids(vec![40, 60], vec![Some("D"), Some("F")]).unwrap();
    );
    let (_, schema_ptr2) = create_test_ffi_schema();
            Some("C"),
    .unwrap();
        index_name.to_string(),
/// when NULLs are sorted to the front.
    let (array_ptr, schema_ptr) = create_test_ffi_data().unwrap();
    let mut settings = NativeSettings::default();
    cleanup_ffi_data(ap1, sp1);
    for i in 0..file_count {
        "Default bloom_filter_enabled should be false"
                Some("delta".to_string()),
            Some("E"),
            Some("C"),
    close_writer_and_cleanup_schema(&filename, schema_ptr);
        vec![false],
    let success_count = Arc::new(AtomicUsize::new(0));
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    // age=30: scores 20, 60
        handles.push(handle);
    let row_ids = read_row_ids_from_parquet(&filename);
    );
    let actual_crc = compute_file_crc32(&filename);
        .unwrap_err()
    let (_temp_dir, filename) = get_temp_file_path("chunked_single.parquet");
    let format_version = read_format_version_from_parquet(&filename);
                }
    let unsorted_ids = read_parquet_file_sorted_ids(&unsorted_file);
        gen,
            Some("C"),
            Some(vec![Some("omega".to_string()), Some("alpha".to_string())]),
    let mut expected_sorted = ages.clone();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        filename.clone(),
        ids,
    assert!(close_result.unwrap().is_some());
/// Test: CRC32 is non-zero for multi-chunk merged output.
    // age=20: score=50, score=30, score=10 (DESC)
    let struct_array = arrow::array::StructArray::from(record_batch);
fn create_nullable_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
            Some("I"),
            Some("G"),
/// This ensures the writer doesn't silently fall back to a default compression.
        index_name.to_string(),
    );
/// Helper: creates FFI data with nullable age column.
    // Verify permutation
        filename2.clone(),
    );
        .unwrap()
                    .is_ok()
    use arrow::datatypes::{DataType, Field};
    let row_id_array: Arc<dyn Array> = Arc::new(Int64Array::from(row_ids));
    settings.nulls_first = vec![false, false];
            "ages[{}]={} should be at sorted position {}",
    // Original: age=[80,20,60,40,10,90,50,30,70], row_ids=[0..8]
            Some("E"),
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        handle.join().unwrap();
    );
    // Default bloom filter is enabled
        "Output should be sorted by age ASC even with per-row slicing"
        Field::new(
        let handle = thread::spawn(move || {
    NativeParquetWriter::write_data(
fn test_write_data_success() {
#[test]
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 6);
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
        filename.clone(),
        ],
    let index_name = "test-only-empty";
    let row_ids: Vec<i64> = (0..10).collect();
    let descending_ids = descending
            Some("I"),
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        .to_string_lossy()
            Some("G"),
                vec![],
        Some(vec![]),
fn test_chunked_writer_generation_in_metadata_single_chunk() {
        Arc::new(StringArray::from(vec![
}
    // Verify compression is SNAPPY in the merged output
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
        "Output should be sorted ascending"
        vec![false],
}
    assert_eq!(gen, Some(12));
    settings.nulls_first = vec![false];
    let ages = read_ages_from_parquet(&filename);
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    )
    settings.sort_columns = vec!["age".to_string()];
            Some("E"),
    let lists = batch
        Arc::new(Field::new("element", DataType::Utf8, true)),
    let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
            Some("E"),
    .unwrap();
        vec![10, 20, 30, 40, 50, 60, 70, 80, 90, 100],
    assert!(!NativeParquetWriter::has_writer(&filename));
fn test_chunked_writer_crc32_multi_chunk() {
    NativeParquetWriter::create_writer(
    let mut settings = NativeSettings::default();
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    let (_temp_dir, filename) = get_temp_file_path("test.parquet");
        schema_ptr,
/// Test: All rows have identical sort keys. The sort is unstable (sort_unstable_by),
    NativeParquetWriter::create_writer(
    );
#[test]
        Some(vec![Some("alpha")]),
    let mut settings = NativeSettings::default();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        vec![],
        ],
    let ages = read_ages_from_parquet(&filename);
        assert_eq!(missing, vec![1, 2, 3]);
}
        Field::new("id", DataType::Int64, false),
    settings.sort_columns = vec!["age".to_string()];
    );
    let (_temp_dir, filename) = get_temp_file_path("props_single_uncompressed.parquet");
    settings.reverse_sorts = vec![false];
    );
    let idx = combined.schema().index_of("age").unwrap();
    settings.sort_columns = vec!["age".to_string()];
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    assert_eq!(
    let result2 = NativeParquetWriter::finalize_writer(filename2.clone());
    let (_schema1, schema_ptr1) = create_writer_and_assert_success(&filename1);
        .parent()
        .expect("Should have row_id_mapping");
        "__row_id__ should be sequential 0..{}",
fn test_memory_usage_path_prefix_filtering() {
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    NativeParquetWriter::create_writer(
    let (_temp_dir2, filename2) = get_temp_file_path("mem_prefix_b.parquet");
    (0..col.len())
    let mut descending_missing = (3..6)
        vec![50, 20, 10]
        &batch,
}
    .unwrap();
            Some("C"),
    let row_ids = read_row_ids_from_parquet(&filename);
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", true);
        schema_ptr,
/// correct sorted output with sequential row IDs and valid permutation.
        mem_after
        filename.clone(),
fn test_nulls_first_with_row_id_and_permutation() {
        &batch,
        index_name.to_string(),
    .unwrap();
    assert!(file_path.exists());
    use arrow::compute::concat_batches;
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
}
    for handle in handles {
        ],
fn test_ipc_staging_sorted_writer_creates_and_cleans_up_staging_file() {
        .parent()
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    settings.reverse_sorts = vec![false];
        vec![false],
        schema_ptr,
    let struct_array = arrow::array::StructArray::from(record_batch);
#[test]
use tempfile::tempdir;
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8],
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
fn test_write_data_multiple_batches() {
        ])),
    assert_eq!(ids.value(3), 40, "null-list row sorts last with nulls-last");
    let (_temp_dir, filename) = get_temp_file_path("duplicate.parquet");
        schema_ptr,
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    let gen = read_writer_generation_from_parquet(&filename);
        vec![0, 1, 2, 3, 4],
fn test_sort_batch_uses_maximum_list_element_when_mode_max() {
        vec![],
                cleanup_ffi_data(ap, sp);
    rg.column(0).compression()
    SETTINGS_STORE.insert(index_name.to_string(), settings);
            Some("I"),
    }
    );
    )
    settings.nulls_first = vec![true]; // NULLs first
        });
        0,
    let (_, schema_ptr2) = create_test_ffi_schema();
/// Test: Sort by age DESC, then score ASC — both columns with different directions.
        vec![false],
        filename.clone(),
        "test-index".to_string(),
            Some("F"),
    use arrow::record_batch::RecordBatch;
    let row_ids = read_row_ids_from_parquet(&filename);
#[test]
    // Default compression is LZ4_RAW
    assert_eq!(ages, vec![Some(10), Some(20), Some(30), None, None]);
        ],
    SETTINGS_STORE.remove(index_name);
    assert_eq!(row_ids, vec![0, 1, 2, 3, 4]);
        handle.join().unwrap();
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        .unwrap()
        filename.clone(),
            Some("H"),
        .unwrap()
    SETTINGS_STORE.remove(index_name);
        writer_generation,
            Some("A"),
}
        .unwrap();
    let (_temp_dir, filename) = get_temp_file_path("unsorted.parquet");
        schema_ptr,
            Some("F"),
        vec![50, 40, 30, 20, 10],
    let mut settings = NativeSettings::default();
/// Test: Verifies that the permutation mapping is invertible — applying it to
    cleanup_ffi_data(ap1, sp1);
    let ages = read_ages_from_parquet(&filename);
    let batch = RecordBatch::try_new(
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
            Some("E"),
        mem_after
/// - Row IDs are sequential 0..N
    // Verify sequential row IDs
            "values",
    // mapping[3]=3(40→pos3), mapping[4]=1(20→pos1), mapping[5]=5(60→pos5)
    SETTINGS_STORE.insert(index_name2.to_string(), settings);
        gen,
        return vec![];
        cleanup_ffi_data(array_ptr, data_schema_ptr);
        OffsetBuffer::new(vec![0_i32, 2, 4, 5, 5].into()),
        .unwrap();
    let file_path = Path::new(&filename);
    SETTINGS_STORE.remove(index_name);
    let (_temp_dir, filename) = get_temp_file_path("sorted_asc.parquet");
        finalize_result.row_id_mapping.is_none(),
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
    assert_eq!(mem2, 0, "Writer 2 should have 0 memory (no data written)");
    // Second batch: rows 3..6
    sorted_mapping.sort();
    // Verify bloom filter IS present
        row_ids,
    use arrow::datatypes::{DataType, Field, Schema};
fn test_ipc_staging_concurrent_sorted_writers() {
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
        .unwrap()
    // Unsorted: data should preserve insertion order
    let result = NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr);
            Some("J"),
        index_name2.to_string(),
    settings.reverse_sorts = vec![false];
        .unwrap();
            Some("J"),
    let (_schema, schema_ptr) = create_no_row_id_schema_ptr();
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
    for i in 0..10 {
    let expected_sequential: Vec<i64> = (0..10).collect();
    assert_eq!(
    let missing_values = ids[4..]
    let mut sorted_mapping = mapping.clone();
        vec![],
        schema_ptr,
        .column(combined.schema().index_of("id").unwrap())
            Some("F"),
    // Check if any column has bloom filter offset set
        vec![0, 1, 2],
}
        Some(99),
    settings.sort_in_memory_threshold_bytes = Some(64); // Tiny — forces multiple chunks
            Some("H"),
#[test]
    assert_ne!(crc32_empty, crc32_with_data);
#[test]
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        mem_after > 0,
        Some(999_999),
    (schema, schema_ptr)
    NativeParquetWriter::create_writer(
        vec![false],
        vec!["age".to_string()],
    );
    // The writer accumulates in memory. Verify the writer is open.
fn test_chunked_writer_batch_slicing_large_batch() {
        .as_primitive::<arrow::datatypes::Int64Type>();
        vec![10, 20, 30, 40, 50, 60, 70, 80],
        schema_ptr,
        "Single chunk path should honor bloom_filter_enabled=true"
        let ids = (0..ids.len()).map(|row| ids.value(row)).collect::<Vec<_>>();
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let (_temp_dir, filename) = get_temp_file_path("nulls_first_rowid.parquet");
    NativeParquetWriter::create_writer(
            Arc::new(Int64Array::from(vec![1, 2, 3, 4, 5])) as ArrayRef,
        vec![false],
        .unwrap();
    settings.nulls_first = vec![false, false];
    .unwrap();
    let ids = read_parquet_file_sorted_ids(&filename);
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
        vec![false],
            Arc::new(build_nullable_string_list(&rows)) as ArrayRef,
        .zip(lists[4..].iter())
    row_ids: Vec<i64>,
        vec![false],
        "Empty writer should have no row_id_mapping"
        create_test_ffi_data_with_ids(vec![30, 10, 50], vec![Some("C"), Some("A"), Some("E")])
        vec![],
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        filename.clone(),
    // Verify data correctness
    assert_eq!(
                "test-index".to_string(),
        vec![false],
    assert!(result.is_err());
        vec![],
        return vec![];
    // Data with duplicate ages to test tie-breaking by score DESC
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
    let index_name = "test-mem-prefix";
        RecordBatch::try_new(schema.clone(), vec![age_array, name_array, row_id_array]).unwrap();
        Field::new("age", DataType::Int32, true), // nullable
        "Single chunk path should stamp format version"
        vec![false, true],
    ]));
    assert_eq!(
#[test]
        .unwrap();
        vec![5, 6, 7, 8, 9],
    let schema = Arc::new(Schema::new(vec![
        index_name.to_string(),
    assert_eq!(ids, vec![10, 20, 30, 40, 50, 60]);
            &[nulls_first],
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
        handles.push(handle);
    cleanup_ffi_data(ap3, sp3);
    settings.reverse_sorts = vec![false]; // ASC
    NativeParquetWriter::write_data(filename1.clone(), ap, sp).unwrap();
    NativeParquetWriter::create_writer(
    NativeParquetWriter::write_data(filename.clone(), ap_empty, sp_empty).unwrap();
    }
    let mut settings = NativeSettings::default();
    let sorted =
            "original_ages[{}]={} should be at sorted position {}",
        vec![],
// incoming batch exceeds memory_threshold_bytes and must be sliced into smaller pieces,
    let (_temp_dir2, unsorted_file) = get_temp_file_path("parquet_unsorted.parquet");
        vec![],
    )
    // Verify __row_id__ is sequential 0..N
    assert_eq!(streaming_crc32, reread_crc32);
    let actual_crc = compute_file_crc32(&filename);
            )
        (false, false, vec![5, 4]),
    settings.sort_in_memory_threshold_bytes = Some(64); // Tiny — forces multiple chunks
        matches!(compression, parquet::basic::Compression::UNCOMPRESSED),
    );
    // cleanup removes the registry entry (dropping the writer) ...
    let (_schema1, schema_ptr1) = create_writer_and_assert_success(&filename1);
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
            }
        vec![false],
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024); // 10MB — won't chunk
    }
        .unwrap();
        NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr).unwrap();
    SETTINGS_STORE.remove(index_name);
        create_test_ffi_data_with_ids(vec![20, 40], vec![Some("B"), Some("D")]).unwrap();
        !has_bloom_filter_in_parquet(&filename),
    // Verify compression is UNCOMPRESSED
        .unwrap()
}
    // on column chunks. But the properties were applied to the writer.
    let row_id_array: Arc<dyn Array> = Arc::new(Int64Array::from(row_ids));
    let index_name = "test-props-multi-zstd";
    let list = ListArray::new(
    let mut handles = vec![];
    let index_name = "test-gen-zero";
            .path()
        Arc::new(Field::new("element", DataType::Utf8, true)),
use std::sync::Arc;
    // left the previous writer un-finalized.)
    settings.sort_in_memory_threshold_bytes = Some(128); // Small enough to force chunking
    // 10(row2)→pos0, 20(row4)→pos1, 30(row0)→pos2, NULL(row1)→pos3, NULL(row3)→pos4
    let reader = SerializedFileReader::new(file).unwrap();
        index_name.to_string(),
    names: Vec<Option<&str>>,
/// Helper: reads the compression codec from the first row group's first column chunk.
 * The OpenSearch Contributors require contributions made to
fn test_writer_properties_honored_multi_chunk_snappy_no_bloom() {
        filename.clone(),
    settings.reverse_sorts = vec![true]; // descending
        (0..3)
        let temp_dir_path = temp_dir.path().to_path_buf();
    settings.sort_columns = vec!["age".to_string()];
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    let index_name = "test-mem-ipc";
    use arrow::array::{ArrayRef, AsArray, Int64Array, ListArray, RecordBatch, StringArray};
    let lists = read_nullable_string_lists(&combined, "tags");
        filename.clone(),
#[test]
    let file = File::open(filename).unwrap();
        Field::new("score", DataType::Int32, false),
fn test_ipc_and_parquet_writers_coexist() {
}
    );
/// in the MULTI CHUNK path (k-way merge).
        &[false],
    assert_eq!(success_count.load(Ordering::SeqCst), 1);
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    let mut settings = NativeSettings::default();
                        if strings.is_null(index) {
    let schema = Arc::new(Schema::new(vec![
/// Helper: creates FFI data with a schema that includes __row_id__ column.
        index_name.to_string(),
            Some("D"),
        invalid_path.to_string(),
    );
        OffsetBuffer::new(vec![0_i32, 2, 3, 3, 3, 5, 6].into()),
        if rg.column(i).bloom_filter_offset().is_some() {
    settings.sort_columns = vec!["age".to_string()];
        vec![false],
/// Test: Empty writer finalize — no data written, should produce valid empty Parquet.
        (0..3).map(|row| ids.value(row)).collect::<Vec<_>>(),
            Some("F"),
        filename.clone(),
    );
    let mut settings = NativeSettings::default();
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        schema_ptr,
    // Original order: (30,50), (20,80), (30,90), (20,40), (10,70), (30,10)
    settings.reverse_sorts = vec![false, false]; // both ASC
        "Default bloom_filter_enabled should be false when no settings exist"
            .unwrap();
        vec![false],
}
        index_name.to_string(),
        index_name.to_string(),
    settings.nulls_first = vec![false];
            "tags",
    );
#[test]
    );
    let mut handles = vec![];
    );
    let result = NativeParquetWriter::create_writer(
            Some("B"),
}
    let mut settings = NativeSettings::default();
    );
    // 10 rows with many ties in age to stress tie-breaking across chunks
        Field::new("id", DataType::Int64, false),
    NativeParquetWriter::create_writer(
        handles.push(handle);
    use arrow::array::{ArrayRef, AsArray, Int64Array, RecordBatch};
    assert!(finalize_result.row_id_mapping.is_none());
        ],
    );
    // Sorted positions: NULL(row1)→pos0, NULL(row3)→pos1, 10(row2)→pos2, 20(row4)→pos3, 30(row0)→pos4
        filename.clone(),
/// Helper: reads the format version from Parquet file key-value metadata.
    assert!(file_path.metadata().unwrap().len() > 0);
    assert_ne!(streaming_crc32, 0);
fn test_close_nonexistent_writer() {
        schema_ptr,
            Arc::new(Int64Array::from(vec![20, 10])) as ArrayRef,
    let ages = read_nullable_ages_from_parquet(&filename);
    let writer_generation = 99i64;
    .unwrap();
        stored_after.bloom_filter_enabled,
        Field::new("age", DataType::Int32, true), // nullable
    SETTINGS_STORE.remove(index_name);
        vec![2, 0, 4, 1, 3],
#[test]
    let result1 = NativeParquetWriter::finalize_writer(filename1.clone());
    NativeParquetWriter::finalize_writer(filename1).unwrap();
        let new_pos = mapping[i] as usize;
        .contains("Invalid FFI addresses"));
        let n = file.read(&mut buf).unwrap();
    let ages = read_ages_from_parquet(&filename);
    .unwrap();
    assert!(
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    // Write enough data to trigger at least one chunk flush
            Some("D"),
#[allow(dead_code)]
        vec![false],
            Some("G"),
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    let result1 = NativeParquetWriter::finalize_writer(filename.clone());
/// Test: Multiple write_data calls where each batch individually exceeds the threshold.
    .unwrap();
    NativeParquetWriter::create_writer(
            Some("D"),
    NativeParquetWriter::create_writer(
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
        cleanup_ffi_data(array_ptr, data_schema_ptr);
    // Verify __row_id__ is sequential 0..N
    let ages = read_ages_from_parquet(&filename);
    use arrow::datatypes::{DataType, Field, Schema};
            Some("gamma"),
        create_test_ffi_data_with_ids(vec![50, 10], vec![Some("E"), Some("A")]).unwrap();
fn test_chunked_writer_no_row_id_batch_slicing() {
    let (_schema, schema_ptr2) = create_row_id_schema_ptr();
    assert!(NativeParquetWriter::has_writer(&filename));
    assert_eq!(mem_final, 0, "Memory should be 0 after writer is finalized");
fn test_ipc_staging_empty_data_produces_valid_parquet() {
            &batch,
            .and_then(|kv| kv.value.clone())
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
}
        writer_generation,
            Some("C"),
    let (_temp_dir, filename) = get_temp_file_path("gen_zero.parquet");
            Some(vec![Some("gamma".to_string()), Some("beta".to_string())]),
fn test_bloom_filter_false_propagates_through_settings_store() {
        vec![
        finalize_result.crc32, actual_crc,
        ],
        vec![0, 1, 2],
    let (ap, sp) = create_ffi_data_with_row_id(
                values.extend(
        vec![false],
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        0,
    assert_eq!(permutation, (0..6).collect::<Vec<_>>());
        vec![],
    // mapping[6]=0 (age=5→pos0), mapping[7]=7 (age=45→pos7), mapping[8]=5 (age=35→pos5)
    let (ap2, sp2) = create_ffi_data_with_row_id(
        0,
        schema_ptr,
    // Format version always stamped
        .unwrap()
    assert_eq!(row_ids, expected);
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
        schema_ptr,
    let (ap, sp) = create_ffi_data_with_row_id(
    .unwrap();
            Arc::new(build_nullable_string_list(&input_rows)) as ArrayRef,
/// NOTE: Currently the k-way merge path (merge_sorted) does not propagate writer_generation
        vec!["age".to_string()],
}
fn test_complete_writer_lifecycle() {
    let (ap, sp) = create_ffi_data_with_row_id(
        vec![],
    let mut settings = NativeSettings::default();
}
/// Verifies that partial slices are handled correctly at boundaries.
        mapping, expected_mapping,
            .unwrap();
    assert!(
fn test_chunked_writer_crc32_differs_for_different_data() {
fn test_chunked_writer_multiple_write_calls() {
        .column(idx)
        "Memory should be at least 10 rows × 8 bytes = 80, got {}",
        create_test_ffi_data_with_ids(vec![20, 40], vec![Some("B"), Some("D")]).unwrap();
    use arrow::buffer::{NullBuffer, OffsetBuffer};
        .unwrap()
    );
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
// 3. Data is correctly sorted in the final output
}
        stored_after.bloom_filter_enabled
    let format_version = read_format_version_from_parquet(&filename);
    let (_temp_dir, filename) = get_temp_file_path("ipc_dup.parquet");
    settings.reverse_sorts = vec![true, false]; // age DESC, score ASC
    let writer_generation = 55i64;
        .column(0)
fn test_get_filtered_writer_memory_usage_with_writers() {
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let expected_sequential: Vec<i64> = (0..10).collect();
    NativeParquetWriter::create_writer(
/// Helper: checks whether bloom filter metadata is present in the first row group's columns.
fn compute_file_crc32(path: &str) -> u32 {
    let writer_generation = 33i64;
        filename.clone(),
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
}
        vec![
    let (ap2, dp2) =
    let mut validity = Vec::with_capacity(rows.len());
    assert!(result.is_ok());
    hasher.finalize()
    assert!(
            Some("D"),
 * compatible open source license.
            true,
        .column(0)
        "Single chunk path should honor UNCOMPRESSED setting, got: {:?}",
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    settings.sort_in_memory_threshold_bytes = Some(1);
        schema.clone(),
                Some("z".to_string()),
            Arc::new(list) as ArrayRef,
    cleanup_ffi_schema(schema_ptr);
        index_name.to_string(),
    NativeParquetWriter::create_writer(
        vec![
    assert!(!NativeParquetWriter::has_writer(&filename));
/// After writing data that triggers chunk flushes, memory should reflect
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    }
        .unwrap()
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
            &[descending],
            Some("D"),
}
    let metadata = reader.metadata();
        .to_string()
}
        Field::new("age", DataType::Int32, false),
    .unwrap();
        vec![],
    // age=20: score=80, score=40 (DESC)
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
fn test_sorted_writer_descending() {
    let (_temp_dir, filename) = get_temp_file_path("empty_batch.parquet");
    )
    let result = NativeParquetWriter::finalize_writer(filename.clone());
    (schema, schema_ptr)
            Some("B"),
                (0..strings.len())
    SETTINGS_STORE.remove(index_name);
        vec![false],
            cleanup_ffi_data(array_ptr, data_schema_ptr);
    settings.nulls_first = vec![false];
        row_ids, expected_sequential,
            let values = lists.value(row);
    assert!(result.is_ok());
        filename.clone(),
        "Permutation should correctly place NULLs first and map original row IDs"
}
    SETTINGS_STORE.remove(index_name);
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
// These tests verify sorting on 2+ columns with mixed sort directions.
    // Verify output is sorted by age descending
// with each piece flushed independently.
    for handle in handles {
        ..Default::default()
    )
        vec![
#[test]
    settings.sort_columns = vec!["age".to_string()];
    let row_ids = read_row_ids_from_parquet(&filename);
        .to_string()
        vec!["age".to_string()],
    SETTINGS_STORE.remove(index_name);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let (_schema2, schema_ptr2) = create_writer_and_assert_success(&filename2);
        index_name.to_string(),
        let sorted = NativeParquetWriter::sort_batch(
        gen,
    let index_name = "test-nulls-first-true";
    let actual_crc = compute_file_crc32(&filename);
    let schema = Arc::new(Schema::new(vec![
#[test]
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    // Writer 1
    .unwrap();
    let (_schema, schema_ptr) = create_no_row_id_schema_ptr();
                let _ = NativeParquetWriter::write_data(filename.clone(), ap, sp);
        &[false],
    settings.reverse_sorts = vec![false];
    settings.sort_columns = vec!["age".to_string()];
#[test]
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
    settings.sort_columns = vec!["age".to_string()];
        vec![false],
        "File should have at least one row group"
        create_test_ffi_data_with_ids(vec![30, 10, 20], vec![Some("C"), Some("A"), Some("B")])
    // Verify mapping is a valid permutation (contains each value 0..N exactly once)
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    let (_schema, schema_ptr) = create_nullable_with_row_id_schema_ptr();
    use arrow_ipc::writer::FileWriter as IpcFileWriter;
    let index_name = "test-props-defaults-single";
    assert_eq!(
        filename.clone(),
    );
    .unwrap();
    for i in 0..thread_count {
    SETTINGS_STORE.remove(index_name);
    NativeParquetWriter::create_writer(
    let index_name = "test-nulls-last-rowid";
    assert_eq!(finalize_result.metadata.file_metadata().num_rows(), 0);
    // mapping[3]=6 (age=40→pos6), mapping[4]=3 (age=20→pos3), mapping[5]=9 (age=60→pos9)
        create_test_ffi_data_with_ids(vec![30, 10, 50], vec![Some("C"), Some("A"), Some("E")])
    // Verify data correctness
        ],
    settings.nulls_first = vec![false];
        vec![false],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            Some("I"),
        .index_of("age")
        let handle = thread::spawn(move || {
            Some("E"),
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    SETTINGS_STORE.remove(index_name);
/// Test: Default writer properties are applied in multi chunk path.
    use arrow::buffer::OffsetBuffer;
    settings.bloom_filter_enabled = Some(false);
    cleanup_ffi_data(ap2, sp2);
    let (ap, sp) = create_ffi_data_with_row_id(
                            None
            let strings = values.as_any().downcast_ref::<StringArray>().unwrap();
    let mapping = finalize_result
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
        "Empty path should stamp format version in output file"
    let expected: Vec<i64> = (0..10).collect();
    let result2 = NativeParquetWriter::finalize_writer(filename2.clone())
        schema_ptrs.push(schema_ptr);
    let crc32_empty = result1.unwrap().unwrap().crc32;
        0,
    settings.sort_columns = vec!["age".to_string()];
            Some("J"),
    assert_eq!(
        .unwrap();
    (schema, schema_ptr)
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    let (ap2, sp2) =
    let (_temp_dir, filename) = get_temp_file_path("bloom_test.parquet");
    SETTINGS_STORE.remove(index_name);
    let ids = sorted
    assert_eq!(
}
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let (_temp_dir, filename) = get_temp_file_path("gen_single.parquet");
                let write_ok = NativeParquetWriter::write_data(filename.clone(), ap, sp).is_ok();
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
    // Verify output is sorted
    settings.reverse_sorts = vec![false];
    let mut settings = NativeSettings::default();
    let format_version = read_format_version_from_parquet(&filename);
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
        filename.clone(),
    // Row IDs must be sequential 0..N regardless of tie-breaking
    // Verify data correctness
        filename.clone(),
    let expected_sequential: Vec<i64> = (0..5).collect();
    use arrow::datatypes::{DataType, Field, Schema};
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        vec![],
        .to_string_lossy()
        vec![10, 20, 30],
use crate::test_utils::*;
    let ages: Vec<i32> = (0..num_rows).map(|i| (i * 7 + 13) % 100).collect();
        gen,
// 2. The permutation mapping correctly maps original_row_id → new_position
    // Verify sequential row IDs
        "Multi chunk (k-way merge) path should honor ZSTD compression, got: {:?}",
    let path_prefix = Path::new(&filename)
    );
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
}
                if NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr)
}
    let ages = read_ages_from_parquet(&filename);
            Some("J"),
        "__row_id__ should be sequential 0..7"
    names: Vec<Option<&str>>,
    );
    let original_ages = vec![90, 10, 70, 30, 50, 80, 20, 60, 40, 100];
    SETTINGS_STORE.remove(index_name);
                success_count.fetch_add(1, Ordering::SeqCst);
        vec!["age".to_string()],
        vec![
    );
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
        None,
    settings.sort_columns = vec!["age".to_string()];
    let record_batch = RecordBatch::try_new(schema.clone(), vec![age_array, name_array]).unwrap();
        vec![false],
#[test]
    );
fn test_chunked_writer_no_row_id_single_chunk() {
    assert_eq!(
        schema_ptr,
    let (_schema, schema_ptr) = create_test_ffi_schema();
        0,
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
            .find(|kv| kv.key == "opensearch.format_version")
        .unwrap()
        vec![50, 40, 30, 20, 10],
    let ages = read_ages_from_parquet(&filename);
            Some("B"),
    )
            let (_schema, schema_ptr) = create_test_ffi_schema();
#[test]
        filename.clone(),
    let ages = read_ages_from_parquet(&filename);
        filenames.push(filename);
}
    );
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        0,
    let (_temp_dir, filename) = get_temp_file_path("nulls_first_false.parquet");
}
    // Original: age=[30,10,50,20,40], row_ids=[0,1,2,3,4]
        filename.clone(),
    }
        ids,
        vec![Some("A"), Some("B"), Some("C")],
    let ages = read_ages_from_parquet(&filename);
    batch: &arrow::record_batch::RecordBatch,
        .unwrap()
    assert_eq!(
        finalize_result.crc32, actual_crc,
    // Verify compression is ZSTD in the merged output
        let new_pos = mapping[i] as usize;
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    settings.nulls_first = vec![false];
    settings.reverse_sorts = vec![false];
    SETTINGS_STORE.remove(index_name);
    // Verify permutation
    NativeParquetWriter::create_writer(
        finalize_result.row_id_mapping.is_none(),
    // Create one IPC writer (sorted) and one Parquet writer (unsorted)
        expected_sequential,
            return true;
        vec![0, 1, 2, 3, 4, 5],
    NativeParquetWriter::create_writer(
        vec![],
        Arc::new(Field::new("element", DataType::Int32, false)),
    let (_temp_dir, filename) = get_temp_file_path("nulls_first_true.parquet");
            Some("E"),
    let index_name = "test-slice-multi-write";
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        let filename = file_path.to_string_lossy().to_string();
    let ages = read_ages_from_parquet(&filename);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let idx = combined
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    );
        vec![10, 20, 30, 40, 50, 60],
    let (ap, sp) = create_ffi_data_nullable_age(
    assert_eq!(
    let ages = read_ages_from_parquet(&filename);
        vec![],
        Some("1.0.0.0"),
    let (_temp_dir2, filename2) = get_temp_file_path("crc32_diff_b.parquet");
    SETTINGS_STORE.insert(index_name.to_string(), settings);
                "tags",
        vec![false],
                }
        schema_ptr,
        "Output should be sorted by age ASC"
    settings.nulls_first = vec![false];
        vec![false],
    for _ in 0..2 {
    )
    column: &str,
    }
    settings.sort_in_memory_threshold_bytes = Some(64); // Force chunking
        writer_generation,
}
    assert_eq!(&ids[..4], &[2, 3, 6, 1]);
        "Output should be globally sorted by age ASC"
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    let index_name1 = "test-crc-diff1";
        0,
    for _ in 0..3 {
#[test]
    let ages = read_ages_from_parquet(&filename);
    let mapping = finalize_result
    );
        filename.clone(),
// skip the row ID capture/rewrite logic and finalize_writer should return no permutation.
        matches!(compression, parquet::basic::Compression::ZSTD(_)),
    let file_path = Path::new(&filename);
    // Previously writer_generation was lost in the k-way merge path. This has been fixed —
    }
    SETTINGS_STORE.remove(index_name);
    let file = File::open(filename).unwrap();
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    assert_eq!(
    let row_ids = read_row_ids_from_parquet(&filename);
        NativeParquetWriter::get_filtered_writer_memory_usage(path_prefix.clone()).unwrap();
        vec![],
    );
    assert!(
    let result = NativeParquetWriter::finalize_writer(filename.clone());
    let settings = NativeSettings::default();
            Some("D"),
            let file_path = temp_dir_path.join(format!("ipc_concurrent_{}.parquet", i));
        vec![30, 10, 50, 20, 40],
            Some("H"),
}
    }
fn test_ipc_staging_same_file_removes_stale_and_succeeds() {
            Some("E"),
        vec![0, 1, 2],
        index_name1.to_string(),
    assert_eq!(
    let expected_mapping: Vec<i64> = vec![8, 4, 0, 6, 2, 3, 9, 1, 5, 7];
    assert_eq!(
// ===== CRC32 tests for sorted chunked writer =====
    settings.reverse_sorts = vec![false];
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        index_name.to_string(),
/// Test: writer_generation=0 is correctly stored (edge case — zero is a valid generation).
        .unwrap();
    let compression = read_compression_from_parquet(&filename);
fn test_multi_column_sort_multi_chunk() {
            sorted_ages[new_pos], original_ages[i],
// ===== Schema without __row_id__ column tests =====
    settings.sort_in_memory_threshold_bytes = Some(64); // Force multiple chunks
                let _ = NativeParquetWriter::finalize_writer(filename);
    // Write a real batch after the empty one
        vec![],
        .join("staging.arrow_ipc_staging")
        let (ap, sp) = create_ffi_data_with_row_id(vec![], vec![], vec![]);
    let (ap, sp) = create_ffi_data_with_row_id(
    SETTINGS_STORE.insert(index_name.to_string(), settings);
fn create_ffi_data_nullable_with_row_id(
            Some("B"),
    );
    );
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    let (_temp_dir, filename) = get_temp_file_path("mem_ipc.parquet");
    let mut settings = NativeSettings::default();
    )
    assert_ne!(
        create_test_ffi_data_with_ids(vec![30, 10, 20], vec![Some("C"), Some("A"), Some("B")])
    NativeParquetWriter::create_writer(
        );
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        "Permutation mapping should map original row IDs to new sorted positions"
        index_name.to_string(),
        vec![false],
#[test]
// ===== Arrow IPC staging path tests =====
        Field::new("name", DataType::Utf8, true),
        create_test_ffi_data_with_ids(vec![20, 40], vec![Some("B"), Some("D")]).unwrap();
        .as_any()
#[test]
#[test]
        filename1.clone(),
    assert!(
    NativeParquetWriter::write_data(unsorted_file.clone(), ap2, dp2).unwrap();
    settings.reverse_sorts = vec![true]; // descending
    let row_ids = read_row_ids_from_parquet(&filename);
    // Expected: age DESC, then score ASC within same age
        .unwrap();
    SETTINGS_STORE.remove(index_name);
}
        vec![60, 50, 40, 30, 20, 10],
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    // Memory should be proportional to rows written × sizeof(i64)
            .unwrap();
}
}
// fn test_sort_small_file_permutation_maps_original_row_ids() {
        vec![30, 10, 50, 20, 40],
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        vec!["age".to_string()],
        vec![],
    close_writer_and_cleanup_schema(&filename, schema_ptr);
fn test_multi_column_sort_age_desc_score_asc() {
            Some("A"),
    let ids = read_parquet_file_sorted_ids(&filename);
        vec![true],
        Some(7),
#[test]
    let row_ids = read_row_ids_from_parquet(&filename);
    );
fn test_finalize_writer_with_data_returns_correct_metadata() {
        vec![0, 1, 2, 3, 4],
        vec![0, 1, 2],
    use arrow::buffer::{NullBuffer, OffsetBuffer};
    assert_eq!(
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
    let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
    // Verify permutation mapping
        Some(vec![Some("z"), Some("delta"), Some("z")]),
        vec![false],
        vec![90, 10, 70, 30, 50, 80, 20, 60, 40, 100],
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024); // Large threshold — single chunk
    let ids = read_parquet_file_sorted_ids(&filename);
        Field::new("name", DataType::Utf8, true),
    cleanup_ffi_schema(sp2);
    settings.nulls_first = vec![false];
    let sorted_ages = read_ages_from_parquet(&filename);
    assert_eq!(
    );
        "Permutation should correctly map across multiple write calls"
    use arrow::array::{Array, ArrayRef, AsArray, Int64Array};
        vec!["age".to_string()],
    unimplemented!("sort_small_file/sort_large_file are commented out");
        Arc::new(Field::new("element", DataType::Utf8, true)),
}
        vec![30, 30, 30, 30, 30],
        vec![false, false],
    assert_eq!(
    // Verify sorted output
                filename.clone(),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    for _ in 0..3 {
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
fn test_memory_usage_ipc_writer_reports_chunk_row_ids() {
        ),
    assert_eq!(
        vec![Some("A"), Some("E"), Some("C"), Some("B"), Some("D")],
    // Create writer 1
        0,
    settings.reverse_sorts = vec![false];
        .expect("Should have row_id_mapping");
    let (_temp_dir, filename) = get_temp_file_path("test.parquet");
        .unwrap()
    // Original positions: [6, 2, 9, 4, 1, 8, 3, 7, 0, 5]
    use arrow::array::{Array, Int32Array, Int64Array, StringArray};
// ===== Batch slicing path tests =====
    let (ap, sp) = create_ffi_data_nullable_with_row_id(
            .find(|kv| kv.key == "opensearch.writer_generation")
    ]));
        vec![Some(30), None, Some(10), None, Some(20)],
            Some("D"),
    // Write to both
    )
    SETTINGS_STORE.remove(index_name);
    assert!(result.is_ok());
    SETTINGS_STORE.remove(index_name);
    let idx = combined
        vec!["age".to_string(), "score".to_string()],
    settings.sort_columns = vec!["age".to_string()];
                if write_ok {
    assert_eq!(ages, vec![10, 20, 20, 30, 30, 30]);
    settings.sort_in_memory_threshold_bytes = Some(1); // Force per-row slicing
        index_name.to_string(),
        vec![0, 1, 2, 3, 4],
    use parquet::file::reader::{FileReader, SerializedFileReader};
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    )
    use arrow::record_batch::RecordBatch;
    let (array_ptr, data_schema_ptr) = create_mismatched_ffi_data().unwrap();
    settings.reverse_sorts = vec![false];
    // Original: age=[80,20,60,40,10,70,30,50], row_ids=[0..7]
    cleanup_ffi_data(ap1, sp1);
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
#[test]
    settings.reverse_sorts = vec![false, true]; // age ASC, score DESC
/// Returns (array_ptr, schema_ptr) for use with write_data.
    (array_ptr, schema_ptr)
    let mut filenames = vec![];
    let (ap2, sp2) =
fn test_nulls_last_with_row_id_and_permutation() {
        vec![10, 15, 20, 25, 30, 35, 40, 45, 50, 55],
    // Finalize both
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    .unwrap();
    // Verify format version
        index_name.to_string(),
 * this file be licensed under the Apache-2.0 license or a
    (0..col.len()).map(|i| col.value(i)).collect()
            Arc::new(list) as ArrayRef,
}
        0,
    let sorted_ages = read_ages_from_parquet(&filename);
#[test]
    let schema = Arc::new(Schema::new(vec![
// ===== write_data to non-existent writer (IPC variant) =====
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
    cleanup_ffi_schema(schema_ptr);
    // Verify permutation mapping
    let ascending = NativeParquetWriter::sort_batch(
    use arrow::buffer::{NullBuffer, OffsetBuffer};
        )
    assert!(Path::new(&filename).exists());
    // CRC should be non-zero for a file with data
        stored.get_bloom_filter_enabled(),
    let ages = read_ages_from_parquet(&filename);
        vec![Some("E"), Some("A"), Some("C"), Some("B"), Some("D")],
        schema_ptr,
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
        create_ffi_data_with_row_id(vec![20, 10], vec![Some("B"), Some("A")], vec![0, 1]);
    // Verify sequential row IDs
        vec![false],
    );
// #[test]
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
    let expected_sequential: Vec<i64> = (0..10).collect();
        .as_any()
        vec![
fn read_writer_generation_from_parquet(filename: &str) -> Option<i64> {
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    assert!(result.is_ok());
    assert_eq!(
        vec![10, 20, 30, 40, 50, 60],
}
    let expected_sequential: Vec<i64> = (0..5).collect();
    cleanup_ffi_schema(schema_ptr);
    // Create writer 2
    let (_temp_dir, filename) = get_temp_file_path("cleanup.parquet");
        .unwrap()
    let compression = read_compression_from_parquet(&filename);
    .unwrap();
        schema,
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let metadata = result.unwrap().unwrap();
    assert_eq!(
    let reader = SerializedFileReader::new(file).unwrap();
            )
    ]));
        index_name.to_string(),
    );
    let format_version = read_format_version_from_parquet(&filename);
    );
    );
    let batches = read_parquet_file(filename);
        Some(17),
fn read_ages_from_parquet(filename: &str) -> Vec<i32> {
/// Should sort correctly and return no permutation mapping.
        vec![
    use arrow::datatypes::{DataType, Field, Schema};
    settings.sort_in_memory_threshold_bytes = Some(1); // Extremely small — forces per-row slicing
    // NULLs first, then ascending non-nulls
    let ages = read_ages_from_parquet(&filename);
}
    settings.reverse_sorts = vec![false];
    cleanup_ffi_schema(schema_ptr);
    .unwrap();
    assert_ne!(
        vec![0, 1, 2, 3, 4],
    assert!(file_path.metadata().unwrap().len() > 0);
    assert_eq!(ages, vec![10, 20, 30, 40, 50]);
    settings.sort_columns = vec!["age".to_string()];
    let mut sorted_mapping = mapping.clone();
    // First batch: rows 0..4
    settings.reverse_sorts = vec![false];
    );
    }
        &[false],
    let invalid_path = "/invalid/path/that/does/not/exist/test.parquet";
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
fn test_create_writer_success() {
        0,
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
/// Should sort correctly across chunks and return no permutation mapping.
        ],
    settings.reverse_sorts = vec![false];
// ===== Sort stability edge case =====
    SETTINGS_STORE.insert(index_name1.to_string(), settings.clone());
    let expected_mapping: Vec<i64> = vec![8, 4, 1, 6, 3, 9, 0, 7, 5, 2];
    let schema = Arc::new(Schema::new(vec![
    let (_temp_dir, filename1) = get_temp_file_path("test1.parquet");
        vec!["age".to_string()],
            .unwrap();
    }
                0,
        vec![],
        "Empty Parquet file should be created"
fn test_chunked_writer_empty_finalize() {
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    // Original positions: [2, 7, 4, 5, 1, 8, 3, 9, 0, 6]
            Some("A"),
}
    let ages = read_ages_from_parquet(&filename);
}
        vec![],
            Some("B"),
        let success_count = Arc::clone(&success_count);
    }
        let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
fn test_ipc_staging_has_writer_returns_true() {
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    settings.reverse_sorts = vec![false]; // ASC
fn has_bloom_filter_in_parquet(filename: &str) -> bool {
    let index_name = "test-gen-unsorted";
    use arrow::datatypes::{DataType, Field, Schema};
fn test_chunked_writer_permutation_is_invertible() {
    assert_eq!(mapping.len(), 8);
    );
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
        ],
    ages: Vec<i32>,
        "Row group should have at least one column"
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    );
#[test]
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
}
                    vec![30, 10, 20],
        Field::new("name", DataType::Utf8, true),
    );
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
fn create_row_id_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
    settings.nulls_first = vec![false];
/// Test: Writer properties (SNAPPY compression, bloom filter disabled) are honored
        vec![Some("E"), Some("A"), Some("C")],
    settings.nulls_first = vec![false];
    .unwrap();
    let (ap, sp) = create_ffi_data_nullable_age(
        Field::new("age", DataType::Int64, false),
    let format_version = read_format_version_from_parquet(&filename);
    )
    cleanup_ffi_schema(schema_ptr);
    let (_temp_dir, filename) = get_temp_file_path("gen_multi.parquet");
    use arrow::compute::concat_batches;
#[test]
    assert_eq!(mapping.len(), 5);
// ===== nulls_first behavior test =====
    // mapping[0]=4, mapping[1]=0, mapping[2]=2, mapping[3]=1, mapping[4]=3
            .is_ok()
        .expect("__row_id__ should be Int64");
    // Sorted file should be sorted
        schema_ptr,
    // is roughly 40-80 bytes in Arrow memory. Set threshold to allow ~2 rows.
    use arrow::datatypes::{DataType, Field, Schema};
    )
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
            Some("G"),
    )
/// Test: Multi-column sort with batch slicing — extreme case combining both features.
    let rg = metadata.row_group(0);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        schema_ptr,
    drop(stored);
    //   id=30 tags=["b"]     -> MAX="b"
                            }
        .unwrap();
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    assert!(result
        .to_string()
        });
// ===== SortingChunkedWriter and finalize_sorted_chunks tests =====
        .as_primitive::<arrow::datatypes::Int64Type>();
    assert!(
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        index_name.to_string(),
    let index_name = "test-props-empty";
        ])),
            Some("m"),
        "Output should be sorted by age ASC even without __row_id__"
    // Data correctness is still maintained
    let metadata = result.unwrap().unwrap();
/// Test: Writing only empty batches produces a valid empty Parquet file.
    .unwrap();
            Some("E"),
    // Sorted DESC: age=[50,40,30,20,10] → original row_ids [1,4,2,3,0]
/// Helper: reads the "score" column from a Parquet file.
            let file_path = temp_dir_path.join(format!("concurrent_{}.parquet", i));
        vec![false],
        vec![false],
        vec!["age".to_string()],
        Some(false),
    settings.sort_in_memory_threshold_bytes = Some(64);
        .unwrap();
    let index_name = "test-no-rowid-slice";
}
            if NativeParquetWriter::create_writer(
    )
    let num_rows = 50i32;
        mapping,
    use arrow::array::Int32Array;
    NativeParquetWriter::create_writer(
        NativeParquetWriter::write_data("nonexistent.parquet".to_string(), array_ptr, schema_ptr);
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
            ),
    SETTINGS_STORE.remove(index_name);
    .unwrap();
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    assert_eq!(row_ids, expected_sequential);
/// Helper: creates FFI data with (age, score, name, __row_id__) columns.
    assert_eq!(
        compression
    let stored = SETTINGS_STORE.get(index_name).unwrap();
        metadata.num_row_groups() > 0,
    // Verify output is sorted by age ascending
    assert!(
    // age=30: score=90, score=50, score=10 (DESC)
    // mapping[0]=2, mapping[1]=3, mapping[2]=0, mapping[3]=4, mapping[4]=1
        } else {
    )
    // Expected: age ASC, then score DESC within same age
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        filename.clone(),
    );
        Arc::new(Schema::new(vec![
    let ids = read_parquet_file_sorted_ids(&filename);
    settings.sort_in_memory_threshold_bytes = Some(1); // Force per-row slicing
    assert_eq!(stored.bloom_filter_enabled, Some(false));
    let (_schema, schema_ptr) = create_multi_sort_schema_ptr();
}
        ages,
        Some(55),
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
                                success_count.fetch_add(1, Ordering::SeqCst);
    NativeParquetWriter::create_writer(
/// Verifies format version is stamped and writer generation is present.
        0,
        ids,
        "Mapping should be a valid permutation"
            Some("H"),
        vec![],
    let (_schema, schema_ptr) = create_multi_sort_schema_ptr();
        vec!["age".to_string()],
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let result = NativeParquetWriter::finalize_writer(filename.clone());
    // With 1 byte threshold, rows_per_slice = max(1, 1/bytes_per_row) = 1,
            i, original_ages[i], new_pos
    assert!(result2.is_ok());
        let handle = thread::spawn(move || {
        finalize_result.crc32, 0,
    settings.reverse_sorts = vec![false];
    // Verify bloom filter IS present
        vec![
use std::sync::atomic::{AtomicUsize, Ordering};
    .unwrap();
    for row in rows {
fn test_chunked_writer_batch_slicing_descending() {
            Some("I"),
        return vec![];
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    );
            if NativeParquetWriter::finalize_writer(filename).is_ok() {
        0,
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    // Verify writer generation
    let index_name = "test-chunked-desc";
    permutation.sort_unstable();
    let (_temp_dir, filename) = get_temp_file_path("chunked_desc.parquet");
        vec![true, false],
    settings.nulls_first = vec![false];
        (true, false, vec![4, 5]),
        vec![
        .schema()
/// Test: write_data fails with "Writer not found" when no sorted (IPC) writer exists for the file.
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        vec!["age".to_string()],
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    // Create writer with sort on "age" ascending
        compression
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    let index_name = "test-multi-sort-desc-asc";
        "Multi chunk path should honor UNCOMPRESSED setting, got: {:?}",
        vec!["age".to_string()],
    NativeParquetWriter::finalize_writer(filename2).unwrap();
    .unwrap();
        Field::new("name", DataType::Utf8, true),
    settings.reverse_sorts = vec![false];
    let index_name = "test-props-defaults-multi";
        vec![80, 20, 60, 40, 10, 70, 30, 50],
fn read_compression_from_parquet(filename: &str) -> parquet::basic::Compression {
#[test]
    let (_temp_dir, filename) = get_temp_file_path("props_defaults_multi.parquet");
        vec![false],
    let ages = read_ages_from_parquet(&filename);
        vec![Some("D"), Some("B"), Some("F")],
    let (_temp_dir, filename) = get_temp_file_path("ipc_cleanup.parquet");
        vec![false],
        (0..3)
fn test_chunked_writer_sorts_by_list_min_and_preserves_original_lists() {
                        if metadata.metadata.file_metadata().num_rows() == 3 {
    use arrow::array::Int64Array;
fn read_row_ids_from_parquet(filename: &str) -> Vec<i64> {
    );
    let compression = read_compression_from_parquet(&filename);
}
    let (_temp_dir, filename) = get_temp_file_path("no_ipc_writer.parquet");
    let index_name = "test-crc-multi";
    // Verify permutation
    settings.sort_columns = vec!["age".to_string(), "score".to_string()];
}
            break;
fn test_writer_properties_honored_multi_chunk_zstd_with_bloom() {
        vec![50, 40, 30, 20, 10],
        vec![],
        index_name.to_string(),
    // Plus a null-list row (id=40) which must sort last (nulls-last).
        finalize_result.crc32, actual_crc,
    );
    assert!(
    // Writer 2 — different data
    let (ap2, sp2) = create_ffi_data_with_row_id(
    settings.compression_level = Some(3);
                        }
    let schema = Arc::new(Schema::new(vec![
    settings.nulls_first = vec![false];
    settings.sort_in_memory_threshold_bytes = Some(64); // Tiny — forces multiple chunks
    // Use defaults — only configure sort
    let mut settings = NativeSettings::default();
            Some("G"),
        matches!(compression, parquet::basic::Compression::ZSTD(_)),
        let names: Vec<Option<&str>> = batch_ids.iter().map(|_| Some("x")).collect();
    // CRC should still be valid
    let (ap, sp) = create_ffi_data_with_row_id(
    cleanup_ffi_data(ap, sp);
    assert_eq!(
        &[
    settings.sort_columns = vec!["age".to_string()];
                Some("z".to_string()),
    // A second (sorted/IPC) writer for the same file removes the stale entry and succeeds.
        filename.clone(),
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
        .contains("Invalid schema address"));
// TODO: Re-enable when sort_small_file/sort_large_file are uncommented
    SETTINGS_STORE.remove(index_name);
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    );
    assert_eq!(scores, vec![70, 80, 40, 90, 50, 10]);
        0,
fn test_ipc_staging_complete_lifecycle_with_sync() {
/// Test: Multiple chunks forced by small memory threshold — verifies row IDs
        vec![],
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    SETTINGS_STORE.remove(index_name);
    let col = combined
    let (_temp_dir, filename) = get_temp_file_path("invalid_schema.parquet");
        index_name.to_string(),
    )
    // Verify permutation is valid
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    settings.sort_columns = vec!["age".to_string()];
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
}
    // mapping[0]=7(80→pos7), mapping[1]=1(20→pos1), mapping[2]=5(60→pos5),
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
    cleanup_ffi_schema(schema_ptr2);
/// Test: Sorted writer without __row_id__ column — single chunk.
    );
        has_bloom_filter_in_parquet(&filename),
    settings.reverse_sorts = vec![true]; // descending
    .unwrap();
    settings.nulls_first = vec![false];
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        .iter()
    settings.nulls_first = vec![false];
    let scores = read_scores_from_parquet(&filename);
                        }
/// Helper: creates FFI schema with nullable sort column (age: Int32 nullable, name: Utf8).
}
        .unwrap();
use std::io::Read;
            DataType::List(Arc::new(Field::new("element", DataType::Int32, false))),
            .collect::<Vec<_>>(),
    )
    NativeParquetWriter::create_writer(
        "Permutation should correctly place NULLs last and map original row IDs"
/// into the final merged file's metadata. This test documents the current behavior.
        filename.clone(),
/// Test: nulls_first=false places NULL values after non-null values in ascending sort.
        compression
            }
            Some("n"),
        sorted_mapping,
                schema_ptr,
        "Memory should be > 0 after chunk flushes (chunk_row_ids accumulated), got {}",
    use arrow::datatypes::{DataType, Field, Schema};
            Some("E"),
        Field::new("id", DataType::Int64, false),
    settings.sort_in_memory_threshold_bytes = Some(64); // Tiny — forces multiple chunks
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    settings.sort_in_memory_threshold_bytes = Some(256); // Force many chunks
        vec![],
fn test_writer_properties_honored_empty_path() {
    let index_name = "test-multi-sort-asc-desc";
        Some(NullBuffer::from(validity)),
#[test]
    assert!(result.is_ok(), "create_writer failed: {:?}", result.err());
    settings.nulls_first = vec![false];
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
    settings.sort_columns = vec!["age".to_string()];
    let gen = read_writer_generation_from_parquet(&filename);
            Some("F"),
/// in the SINGLE CHUNK path.
            sorted_ages[new_pos], ages[i],
        ages,
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
fn read_nullable_ages_from_parquet(filename: &str) -> Vec<Option<i32>> {
        vec![],
    assert!(result.is_ok());
    assert_eq!(mapping.len(), 10);
    assert_eq!(mapping, vec![4, 0, 2, 3, 1]);
}
    // mapping[6]=2(30→pos2), mapping[7]=4(50→pos4)
        .unwrap();
        0,
    // Writer 1 had data written (and chunks flushed), writer 2 did not
    let (_temp_dir, filename) = get_temp_file_path("ipc_desc.parquet");
        vec![false],
        .collect::<Vec<_>>();
            .collect::<Vec<_>>(),
}
            Some("B"),
            "original_ages[{}]={} should be at sorted position {}, but found {}",
        filename.clone(),
        assert_eq!(values, expected_values.as_slice());
            Some("H"),
}
        filename.clone(),
        writer_generation,
fn test_writer_properties_defaults_single_chunk() {
    for _ in 0..5 {
        "__row_id__ should be sequential after rewrite"
        schema_ptr,
    ascending_missing.sort_unstable();
        .row_id_mapping
        vec![Some("A"), Some("B"), Some("C"), Some("D"), Some("E")],
    );
        filename.clone(),
    // Original: age=[30, NULL, 10, NULL, 20], row_ids=[0,1,2,3,4]
        vec![25, 55, 15, 35, 45],
                            Some(strings.value(index).to_string())
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
    // Sorted order:   (10,70), (20,80), (20,40), (30,90), (30,50), (30,10)
    settings.compression_type = Some("SNAPPY".to_string());
    let compression = read_compression_from_parquet(&filename);
    let mut buf = [0u8; 64 * 1024];
        schema.clone(),
    use arrow::datatypes::{DataType, Field, Schema};
        vec![false],
        matches!(compression, parquet::basic::Compression::SNAPPY),
    cleanup_ffi_schema(schema_ptr);
    let (_temp_dir, filename) = get_temp_file_path("props_multi_snappy.parquet");
    );
    let (ap, sp) =
        let success_count = Arc::clone(&success_count);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let mut settings = NativeSettings::default();
    assert_eq!(missing_values.get(&4), Some(&Some(vec![])));
        NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        index_name.to_string(),
fn test_concurrent_close_operations_same_file() {
    settings.reverse_sorts = vec![false];
            Some("C"),
            i, ages[i], new_pos
        .schema()
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    row_ids: Vec<i64>,
    settings.nulls_first = vec![false];
        index_name.to_string(),
                None
        filename.clone(),
    let result = NativeParquetWriter::finalize_writer(filename.clone());
    let mem2 = NativeParquetWriter::get_filtered_writer_memory_usage(prefix2).unwrap();
        &["values".to_string()],
    // Sorted DESC: age=[50,40,30,20,10] → original row_ids [1,4,2,3,0]
    assert_eq!(ages, vec![10, 20, 30]);
        vec![],
    )
    cleanup_ffi_data(array_ptr, schema_ptr);
        vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60],
    NativeParquetWriter::create_writer(
        Some("1.0.0.0"),
        0,
        .contains("Writer not found"));
    ];
    .unwrap();
        Field::new("name", DataType::Utf8, true),
    assert!(NativeParquetWriter::cleanup_writer(&filename).is_ok());
    );
    assert_eq!(mapping, vec![4, 0, 2, 3, 1]);
        "Default bloom_filter_enabled should be false in multi-chunk path"
                0,
        index_name.to_string(),
        Arc::new(Int32Array::from(vec![3, 2, 5, 1])),
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
        vec![false],
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
    settings.sort_columns = vec!["age".to_string()];
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    // Sorted:   age=[10,20,30,40,50,60]
    // Sorted:   age=[10, 20, 30, NULL, NULL]
}
    let schema = Arc::new(Schema::new(vec![
    settings.compression_level = Some(5);
        .row_id_mapping
    assert_eq!(
        0,
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
fn test_writer_properties_honored_multi_chunk_uncompressed() {
    // Verify data correctness (sort order)
    assert!(
    // Sorted:   age=[10,20,30,40,50,60,70,80,90]
        "Mapping should be a valid permutation of 0..N"
    assert_eq!(
    );
    SETTINGS_STORE.insert(index_name.to_string(), settings);
#[allow(dead_code)]
        vec![0, 1, 2, 3, 4],
    settings.sort_in_memory_threshold_bytes = Some(64); // Very small — forces chunking
            Some("H"),
        close_writer_and_cleanup_schema(filename, schema_ptrs[i]);
        vec![50, 80, 90, 40, 70, 10], // scores for tie-breaking
    assert_eq!(
    settings.reverse_sorts = vec![false];
    )
        vec![],
    let (_temp_dir, filename) = get_temp_file_path("props_multi_uncompressed.parquet");
        .collect()
#[test]
    for i in 0..file_count {
            Some("A"),
    // Original row_ids: 4, 1, 3, 2, 0, 5
    let (ap, sp) = create_ffi_data_with_row_id(
        vec![Some("A"), Some("B"), Some("C"), Some("D"), Some("E")],
    assert_eq!(
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
        vec![
    )
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
            Some("A"),
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
    assert_eq!(ids, vec![10, 20, 30]);
        index_name.to_string(),
    SETTINGS_STORE.remove(index_name2);
        vec![],
    // Verify __row_id__ is sequential 0..N
fn read_nullable_string_lists(
        vec![false],
            Some("J"),
        schema_ptr,
    .unwrap();
        ages,
/// Test: UNCOMPRESSED setting is honored in multi chunk path.
        vec![false],
// fn test_sort_large_file_permutation_maps_original_row_ids() {
    let mut settings = NativeSettings::default();
fn test_concurrent_writes_different_files() {
        vec![Some("C"), Some("X"), Some("A"), Some("Y"), Some("B")],
        .to_string_lossy()
        handle.join().unwrap();
        vec![Some("A"), Some("E"), Some("C"), Some("B"), Some("D")],
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
        Field::new(
    let (ap, sp) = create_ffi_data_nullable_with_row_id(
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        let success_count = Arc::clone(&success_count);
    let (_temp_dir, filename) = get_temp_file_path("identical_keys.parquet");
#[test]
    descending_missing.sort_unstable();
                let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
        schema_ptr,
        Arc::clone(&schema),
    NativeParquetWriter::create_writer(
        .unwrap();
    );
        filename2.clone(),
        }
    NativeParquetWriter::write_data(filename2.clone(), array_ptr, data_schema_ptr).unwrap();
    settings.nulls_first = vec![false];
        ages,
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    // No permutation
    assert!(
    // Verify format version
    cleanup_ffi_schema(schema_ptr);
    assert_eq!(unsorted_ids, vec![30, 10, 20]);
}
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    assert!(
    let result = NativeParquetWriter::create_writer(
        .unwrap_err()
    settings.nulls_first = vec![false]; // NULLs last
        vec![false],
        index_name.to_string(),
        Some(vec![Some("omega"), Some("alpha")]),
    sorted_mapping.sort();
    // Finalize without writing any data
        .as_primitive::<arrow::datatypes::Int64Type>();
        "Empty writer should produce 0-row Parquet"
    let (ap, sp) = create_ffi_data_with_row_id(
    let schema = Arc::new(Schema::new(vec![
    SETTINGS_STORE.insert(index_name.to_string(), settings);
/// TODO: Fix merge_sorted to accept and propagate writer_generation.
        vec![
        vec![10, 50, 30, 20, 40],
    let sorted_ids = read_parquet_file_sorted_ids(&sorted_file);
    let mut sorted_mapping = mapping.clone();
            Some("A"),
        vec![
    settings.nulls_first = vec![false];
    assert_eq!(scores, vec![10, 30, 50, 70, 10, 30, 40, 50, 20, 60]);
        "bloom_filter_enabled should remain false after create_writer, but got: {:?}",
    let result = NativeParquetWriter::create_writer(
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    // Sorted:   age=[NULL, NULL, 10, 20, 30]
    (schema, schema_ptr)
        0,
        vec!["age".to_string()],
    );
    assert_eq!(
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        filename.clone(),
        vec![0, 1, 2, 3, 4],
        .row_id_mapping
    );
    );
                    .map(|index| {
    //   id=10 tags=["a","z"] -> MAX="z"
    // mapping[0]=2, mapping[1]=0, mapping[2]=4, mapping[3]=1, mapping[4]=3
    );
    let (ap1, sp1) = create_ffi_data_with_row_id(
    assert_eq!(row_ids, expected_sequential);
    assert_eq!(mapping.len(), 10);
    NativeParquetWriter::write_data(filename.clone(), ap2, sp2).unwrap();
    (array_ptr, schema_ptr)
use std::thread;
#[test]
    SETTINGS_STORE.remove(index_name);
    // Verify compression is ZSTD
        "Mapping should be a valid permutation"
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        vec![10, 50, 30, 20, 40, 60],
    // Verify compression is SNAPPY
    assert_eq!(
    SETTINGS_STORE.remove(index_name);
    cleanup_ffi_schema(sp1);
        vec![30, 20, 10]
        .unwrap()
    let writer_generation = 77i64;
    assert_eq!(mapping, vec![7, 1, 5, 3, 0, 8, 4, 2, 6]);
    let result2 = NativeParquetWriter::create_writer(
        vec![],
fn test_chunked_writer_large_dataset_multi_chunk() {
        NativeParquetWriter::sort_batch(&batch, &["tags".to_string()], &[false], &[false], &[true])
        let (ap, sp) = create_test_ffi_data_with_ids(batch_ids, names).unwrap();
    let (_temp_dir, filename) = get_temp_file_path("ipc_has_writer.parquet");
    );
        .unwrap()
    NativeParquetWriter::create_writer(
        compression
        vec![],
    let mut settings = NativeSettings::default();
        vec!["age".to_string()],
    .unwrap();
        vec![],
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
#[test]
    metadata.key_value_metadata().and_then(|kvs| {
        writer_generation,
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let (ffi_array, ffi_schema) = arrow::ffi::to_ffi(&struct_array.to_data()).unwrap();
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    ages: Vec<i32>,
    .unwrap();
        vec![false, false],
    settings.reverse_sorts = vec![false]; // ASC
            Some("F"),
    settings.nulls_first = vec![false, false];
    ]));
        0,
    );
        index_name.to_string(),
        vec!["age".to_string(), "score".to_string()],
        "Multi chunk (k-way merge) path should honor SNAPPY compression, got: {:?}",
    settings.nulls_first = vec![false];
            Some("B"),
    assert!(
        rg.num_columns() > 0,
    let idx = combined
            cleanup_ffi_schema(schema_ptr);
#[test]
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    SETTINGS_STORE.remove(index_name);
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
}
        assert_eq!(
}
    // Don't write any data — triggers the empty path
    })
                        .map(|value| value.map(ToString::to_string)),
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    );
        .unwrap()
    assert_eq!(ages, vec![30, 30, 20, 20, 10]);
    cleanup_ffi_schema(schema_ptr);
    // The final Parquet file should exist
    let row_ids = read_row_ids_from_parquet(&filename);
/// Test: nulls_first=true places NULL values before non-null values in ascending sort.
    // Verify permutation
/// Rows with the same age should be ordered by score descending.
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
}
    cleanup_ffi_schema(schema_ptr);
    SETTINGS_STORE.remove(index_name);
        Path::new(&filename).exists(),
    settings.nulls_first = vec![false];
    let ages = read_ages_from_parquet(&filename);
        vec!["age".to_string()],
        vec![false],
    // Verify sort: ascending non-nulls, then NULLs last
    .unwrap();
        .unwrap();
}
    cleanup_ffi_schema(schema_ptr2);
            Some("A"),
    NativeParquetWriter::create_writer(
    let (_temp_dir, filename) = get_temp_file_path("slice_two.parquet");
            Some(vec![
        format_version.as_deref(),
    settings.nulls_first = vec![false, false];
        vec![],
        .unwrap()
    let finalize_result = result.unwrap().unwrap();
    NativeParquetWriter::create_writer(
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    )
            Some("C"),
        "writer_generation should be in metadata for unsorted writer too"
}
    ipc_path
    );
    NativeParquetWriter::create_writer(
        vec![false],
    // Creating a second writer for the same file must NOT error: the stale entry is removed and a
    assert_eq!(row_ids, expected);
    assert_eq!(stored_after.get_bloom_filter_enabled(), false);
    // Format version always stamped
    let metadata = reader.metadata().file_metadata();
        vec![false],
        Field::new("name", DataType::Utf8, true),
        vec!["age".to_string()],
    settings.bloom_filter_fpp = Some(0.05);
        vec![],
        .unwrap();
        vec![],
            None => validity.push(false),
    let index_name = "test-list-sort-multi-chunk";
/// Subsequent non-empty writes and finalize should still work correctly.
    );
    let (_schema, schema_ptr) = create_test_ffi_schema();
        Field::new("age", DataType::Int32, false),
    settings.sort_columns = vec!["age".to_string()];
        });
        vec![false, false],
        row_ids, expected_sequential,
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
        vec!["id".to_string()],
fn create_test_ipc_file(dir: &Path, ages: &[i64], row_ids: &[i64]) -> String {
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
            .and_then(|kv| kv.value.as_ref())
        ],
        vec![false],
        vec![3, 4, 5],
    let index_name = "test-props-single-zstd";
        (false, true, vec![5, 4]),
    assert_eq!(
}
    ages: Vec<Option<i32>>,
        let file_path = temp_dir
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    );
fn test_sorted_writer_ascending() {
#[test]
        schema_ptr,
        index_name.to_string(),
    }
    )
        create_test_ffi_data_with_ids(vec![10, 30, 20], vec![Some("A"), Some("C"), Some("B")])
    NativeParquetWriter::finalize_writer(sorted_file.clone()).unwrap();
    // Verify format version
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
    assert!(NativeParquetWriter::has_writer(&filename));
        has_bloom_filter_in_parquet(&filename),
            Some("D"),
    settings.sort_columns = vec!["age".to_string()];
        vec![0, 1, 2, 3, 4],
    NativeParquetWriter::create_writer(
    let index_name = "test-gen-large";
        vec![30, 50, 40, 20, 10],
    let index_name = "test-empty-batch";
    let (_temp_dir, filename) = get_temp_file_path("multi_sort_desc_asc.parquet");
        vec![],
    settings.nulls_first = vec![false];
    // Cleanup
    let ages = read_ages_from_parquet(&filename);
    settings.sort_columns = vec!["age".to_string()];
    );
        index_name.to_string(),
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
        &[false],
    settings.bloom_filter_ndv = Some(50_000);
    // Verify permutation is valid
    assert_eq!(metadata.metadata.file_metadata().num_rows(), 0);
        schema_ptr,
    use arrow::array::Int32Array;
    names: Vec<Option<&str>>,
        vec![],
                );
        NativeParquetWriter::has_writer(&filename),
    let close_result = NativeParquetWriter::finalize_writer(filename.clone());
    SETTINGS_STORE.remove(index_name1);
    let mut sorted_mapping = mapping.clone();
/// in the SINGLE CHUNK path (chunk_paths.len() == 1).
        filename.clone(),
        writer_generation,
    )
        vec![0, 1, 2, 3, 4],
    let row_ids = read_row_ids_from_parquet(&filename);
/// respects composite sort keys across chunk boundaries.
    NativeParquetWriter::create_writer(
    // Verify sorted output
    let mut sorted_mapping = mapping.clone();
    let schema = Arc::new(Schema::new(vec![
    let (_temp_dir, filename) = get_temp_file_path("no_rowid_single.parquet");
        ages,
        schema_ptr,
        vec![false],
    (array_ptr, schema_ptr)
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    );
        let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
// Parquet file for all finalize_sorted_chunks paths: empty, single-chunk, and multi-chunk.
        Some(NullBuffer::from(vec![true, true, true, false, true, true])),
    );
    );
    settings.sort_columns = vec!["age".to_string()];
    );
    let success_count = Arc::new(AtomicUsize::new(0));
        vec![],
    );
        false,
fn test_writer_properties_defaults_multi_chunk() {
        let handle = thread::spawn(move || {
    use parquet::file::reader::{FileReader, SerializedFileReader};
    let mut settings = NativeSettings::default();
        "Output should be sorted by age DESC"
        index_name.to_string(),
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
fn test_concurrent_writes_same_file() {
    if batches.is_empty() {
            Some("D"),
    let (_temp_dir, filename) = get_temp_file_path("crc_single.parquet");
        Field::new("name", DataType::Utf8, true),
        matches!(compression, parquet::basic::Compression::SNAPPY),
    use arrow::array::{Array, StringArray};
                .unwrap();
        assert_eq!(
    use arrow::record_batch::RecordBatch;
            {
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    let (ap, sp) = create_ffi_data_multi_sort(
#[test]
    assert_eq!(
    SETTINGS_STORE.remove(index_name);
/// Verifies that slicing works correctly across multiple write calls.
    settings.sort_columns = vec!["age".to_string()];
    settings.bloom_filter_enabled = Some(true);
    .unwrap();
    // Verify sort correctness
        vec![false],
        })
}
    let (ap1, sp1) = create_ffi_data_with_row_id(
    }
/// are sequential in the final merged output and permutation is correct.
fn test_create_writer_invalid_path() {
    let (ap, sp) = create_ffi_data_with_row_id(
    let (_schema, schema_ptr) = create_nullable_schema_ptr();
            Some("C"),
        schema_ptr,
fn test_chunked_writer_no_row_id_multi_chunk() {
    // Sorted:   age=[10,20,30,40,50] → original row_ids were [1,3,0,4,2]
        let filename = filename.clone();
        vec![Some("X"), Some("Y"), Some("Z")],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
                        .iter()
        0,
            "tags",
    }
    SETTINGS_STORE.insert(index_name.to_string(), settings);
            DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
    // mapping[0]=4, mapping[1]=0, mapping[2]=2, mapping[3]=3, mapping[4]=1
        vec![],
        .unwrap()
    let prefix1 = Path::new(&filename1)
            {
    assert_eq!(
    use arrow::datatypes::{DataType, Field, Schema};
    NativeParquetWriter::write_data(sorted_file.clone(), ap1, dp1).unwrap();
    );
    .unwrap();
    settings.nulls_first = vec![false];
    let gen = read_writer_generation_from_parquet(&filename);
        vec![0, 1, 2, 3, 4, 5, 6, 7],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let (ap, sp) = create_ffi_data_with_row_id(original_ages.clone(), names, row_ids);
            None,
        !has_bloom_filter_in_parquet(&filename),
    settings.bloom_filter_enabled = Some(true);
        0,
            Some("D"),
    // Verify permutation mapping
    (array_ptr, schema_ptr)
    assert_eq!(format_version.as_deref(), Some("1.0.0.0"));
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
    let record_batch =
    let ids = read_parquet_file_sorted_ids(&filename);
    SETTINGS_STORE.remove(index_name);
    let (ap1, sp1) =
// These tests verify that the sorted chunked writer works correctly when the schema
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
        .unwrap()
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    // Configure with tiny threshold to force multiple chunks
        ages,
        vec![false, false],
        vec![false],
    // Three non-null rows whose MAX element orders them differently than MIN would:
// TODO: Re-enable when sort_small_file/sort_large_file are uncommented
        filename.clone(),
        vec![Some("C"), Some("A"), Some("E"), Some("B"), Some("D")],
        index_name.to_string(),
        filename.clone(),
            if col.is_null(i) {
/// Test: Sort by age ASC, then score DESC (tie-breaking).
    assert_eq!(ages, vec![10, 20, 30, 40, 50, 60, 70, 80, 90]);
        vec![Some(30), None, Some(10), None, Some(20)],
    settings.nulls_first = vec![false];
            Some("b"),
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    cleanup_ffi_schema(schema_ptr);
    NativeParquetWriter::create_writer(
        filename.clone(),
    let (_temp_dir, filename) = get_temp_file_path("chunked_invertible.parquet");
    cleanup_ffi_data(array_ptr, data_schema_ptr);
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
            Some("G"),
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    settings.nulls_first = vec![false];
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    cleanup_ffi_data(array_ptr, data_schema_ptr);
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
        index_name.to_string(),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let index_name = "test-props-multi-snappy";
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        ],
    for _ in 0..3 {
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
#[test]
/// Helper: reads a Parquet file and returns the __row_id__ column values.
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    NativeParquetWriter::create_writer(
    // 10 rows × 8 bytes = 80 bytes minimum (could be more if split across chunks)
    .unwrap();
/// Test: UNCOMPRESSED setting is honored in single chunk path.
#[test]
#[test]
        Box::into_raw(Box::new(ffi_schema)) as i64,
    // Permutation must be a valid bijection of 0..4
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
        .parent()
    settings.compression_type = Some("ZSTD".to_string());
        .unwrap();
        vec![Some("C"), Some("A"), Some("B")],
    ]));
    let (ap, sp) =
        row_ids, expected_sequential,
    ]));
    let mem1 = NativeParquetWriter::get_filtered_writer_memory_usage(prefix1).unwrap();
fn test_nulls_first_true_ascending() {
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        gen,
    let index_name = "test-identical-keys";
    assert_eq!(
    assert_eq!(ages, vec![30, 30, 30, 30, 30]);
    use arrow::array::{Array, Int32Array, Int64Array, StringArray};
use crate::native_settings::NativeSettings;
    assert_eq!(format_version.as_deref(), Some("1.0.0.0"));
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
                    .collect(),
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    assert_eq!(mapping.len(), 5);
                )
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    settings.sort_columns = vec!["age".to_string()];
    settings.reverse_sorts = vec![false];
    cleanup_ffi_schema(schema_ptr1);
        vec![Some("E"), Some("C"), Some("A"), Some("D"), Some("B")],
    assert_eq!(ages, vec![None, None, Some(10), Some(20), Some(30)]);
    let (ap, sp) = create_ffi_data_with_row_id(ages.clone(), names, row_ids);
        filename.clone(),
    use crate::merge::schema::ROW_ID_COLUMN_NAME;
    )
fn create_multi_sort_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
        vec!["age".to_string()],
    let ids = sorted
        .as_primitive::<arrow::datatypes::Int64Type>();
        filename.clone(),
        index_name.to_string(),
    // mapping[0]=4(50→pos4), mapping[1]=0(10→pos0), mapping[2]=2(30→pos2),
    }
}
        vec![Some("E"), Some("D"), Some("C"), Some("B"), Some("A")],
    let batches = read_parquet_file(filename);
}
        let filename = filenames[i].clone();
    use arrow::record_batch::RecordBatch;
    settings.reverse_sorts = vec![false];
        });
#[test]
    let (ap1, sp1) =
        vec![Some(30), None, Some(10), None, Some(20)],
        "writer_generation=0 should be stored in metadata"
    let (ap, sp) = create_ffi_data_with_row_id(
        compression
    assert_eq!(
    );
    sorted_mapping.sort();
    let mut settings = NativeSettings::default();
    let row_ids = read_row_ids_from_parquet(&filename);
        create_test_ffi_data_with_ids(vec![30, 10, 20], vec![Some("C"), Some("A"), Some("B")])
    let mut settings = NativeSettings::default();
            DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
    let (_temp_dir2, filename2) = get_temp_file_path("test2.parquet");
    ]));
        "Single chunk path should honor bloom_filter_enabled=true (bloom filter should be in file)"
        vec![],
    let rows = vec![
// Concurrency tests
        vec![],
    let result = NativeParquetWriter::get_filtered_writer_memory_usage(prefix);
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        result.unwrap_err().to_string().contains("Writer not found"),
    // Set threshold to 1 byte — every batch will exceed it and trigger slicing.
        vec![],
            Some("I"),
    cleanup_ffi_schema(schema_ptr);
    settings.compression_type = Some("ZSTD".to_string());
        filename,
}
    let (ap, sp) = create_ffi_data_with_row_id(
    (0..col.len()).map(|i| col.value(i)).collect()
        Some(vec![Some("gamma"), Some("beta")]),
    )
    let ages = read_ages_from_parquet(&filename);
    let batch = RecordBatch::try_new(
    }
            Some("G"),
fn test_finalize_writer_success() {
    // Data correctness
        filename1.clone(),
        vec!["age".to_string()],
        mem_after >= 80,
    // mapping[original_row_id] = new_position
    SETTINGS_STORE.insert(index_name.to_string(), settings);
            }
fn test_list_sort_null_placement_for_both_directions() {
}
        ],
        vec![],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let mut handles = vec![];
    let (ap, sp) = create_ffi_data_multi_sort(
    .unwrap();
    let index_name = "test-chunked-empty";
            .column(0)
        .to_string();
fn test_crc32_matches_reread_with_data() {
    // Original: age=[10,50,30,20,40], row_ids=[0..4]
/// Test: get_filtered_writer_memory_usage reports memory for IPC (sorted) writers.
    // Just create the writer with the schema, don't write data
    let ages = read_ages_from_parquet(&filename);
        vec![false],
        0,
        sorted_mapping, expected_perm,
    assert!(NativeParquetWriter::cleanup_writer(&filename).is_ok());
    )
        ],
    assert_eq!(ages, vec![30, 10, 20]);
            Some("D"),
    )
        sorted_mapping, expected_sequential,
        0,
        schema_ptr,
    )
// ===== Writer properties verification tests =====
    settings.nulls_first = vec![false];
    use arrow::datatypes::{DataType, Field, Schema};
        schema_ptr,
fn test_cleanup_writer_removes_entry_and_is_idempotent() {
        OffsetBuffer::new(vec![0_i32, 2, 4].into()),
    let index_name2 = "test-crc-diff2";
    // Original: age=[10,50,30,20,40], row_ids=[0,1,2,3,4]
    let index_name = "test-no-rowid-multi";
        vec![30, 10, 50, 20, 40],
//
    );
    );
            Some("J"),
    // Verify bloom filter is NOT present
        vec![],
        vec![],
    let (_temp_dir, filename) = get_temp_file_path("gen_unsorted.parquet");
}
    use arrow::array::{Array, Int32Array};
            Some("z"),
    let writer_generation = 12i64;
            false,
    }
        .row_id_mapping
    cleanup_ffi_schema(schema_ptr);
        .to_string();
#[test]
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    if batches.is_empty() {
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let (_temp_dir, filename) = get_temp_file_path("chunked_empty.parquet");
    let names: Vec<Option<&str>> = (0..num_rows as usize).map(|_| Some("x")).collect();
    NativeParquetWriter::write_data(filename2.clone(), ap2, sp2).unwrap();
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    settings.reverse_sorts = vec![false];
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        .expect("Should have row_id_mapping");
        vec!["age".to_string()],
        None,
}
        vec![false],
    let ipc_path = dir
        !has_bloom_filter_in_parquet(&filename),
        .expect("age column should exist");
    // Expected sort: age ASC first, then score DESC within same age
    // After writing (chunks flushed), memory should be > 0 due to chunk_row_ids
            Some("B"),
        vec![99, 88, 77],
fn test_concurrent_writer_creation() {
    let gen = read_writer_generation_from_parquet(&filename);
    );
/// - The mapping correctly maps each original row to its output position
                    success_count.fetch_add(1, Ordering::SeqCst);
        .column(idx)
    let ages = read_ages_from_parquet(&filename);
    assert!(result.is_err());
    let (ap, sp) = create_ffi_data_with_row_id(
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", false);
        "__row_id__ should be sequential 0..4"
    .unwrap();
    let (ap, sp) = create_ffi_data_multi_sort(
    // Verify permutation correctness
#[test]
            Some("G"),
    let success_count = Arc::new(AtomicUsize::new(0));
                    }
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    let mut file = File::open(path).unwrap();
            }
        0,
        Field::new("score", DataType::Int32, false),
        vec!["age".to_string()],
    settings.nulls_first = vec![false];
            Some("C"),
#[test]
    // Verify permutation correctness:
fn test_chunked_writer_batch_slicing_multiple_writes() {
    let score_array: Arc<dyn Array> = Arc::new(Int32Array::from(scores));
    );
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
            Some("H"),
        vec![false],
    let (_temp_dir, filename) = get_temp_file_path("only_empty.parquet");
        vec![Some(30), None, Some(10), None, Some(20)],
    assert!(NativeParquetWriter::has_writer(&filename));
            .join(format!("concurrent_write_{}.parquet", i));
        row_ids, expected_sequential,
        mapping, expected_mapping,
    );
            Some("A"),
        "Data should be sorted descending by id"
    // Verify sequential row IDs
    let descending =
        NativeParquetWriter::write_data(filename.clone(), array_ptr, data_schema_ptr).unwrap();
    // mapping[3]=3(40→pos3), mapping[4]=0(10→pos0), mapping[5]=6(70→pos6),
    //   b(30) < n(20) < z(10), then null(40).
/// Test: Writer properties are honored in the EMPTY path (0 chunks).
        vec![0, 1, 2, 3, 4],
    let result = NativeParquetWriter::create_writer(
fn test_chunked_writer_single_chunk_row_ids_sequential() {
        create_test_ffi_data_with_ids(vec![30, 10, 50], vec![Some("C"), Some("A"), Some("E")])
        vec![],
    assert_eq!(
        vec!["age".to_string()],
    NativeParquetWriter::create_writer(
    let col = combined
fn create_no_row_id_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
fn create_ffi_data_nullable_age(ages: Vec<Option<i32>>, names: Vec<Option<&str>>) -> (i64, i64) {
    cleanup_ffi_data(ap2, sp2);
        0,
        Field::new("name", DataType::Utf8, true),
    let mapping = finalize_result
    settings.sort_columns = vec!["age".to_string()];
        .unwrap()
    assert_eq!(ascending_missing, vec![30, 40, 60]);
fn test_empty_batch_write_does_not_corrupt_sorted_writer() {
            Some("F"),
        filename.clone(),
        .map(|(id, tags)| (*id, tags.clone()))
        );
    let (_temp_dir, filename) = get_temp_file_path("chunked_multi.parquet");
        vec![false],
    assert_eq!(
// }
/// Test: Writer properties (ZSTD compression, bloom filter enabled) are honored
    NativeParquetWriter::create_writer(
}
        has_bloom_filter_in_parquet(&filename),
    assert!(result.is_err());
    use arrow::array::{ArrayRef, AsArray, Int64Array, ListArray, RecordBatch, StringArray};
    let names: Vec<Option<&str>> = (0..10).map(|_| Some("x")).collect();
}
            Arc::new(Int64Array::from(vec![0, 1, 2, 3, 4, 5])) as ArrayRef,
        0,
    NativeParquetWriter::create_writer(
    let (_temp_dir, filename) = get_temp_file_path("props_single_snappy.parquet");
        gen,
        .as_any()
        Field::new("age", DataType::Int32, true),
        "writer_generation should be propagated in multi-chunk merge path"
        handles.push(handle);
    // Verify output is sorted
                vec!["id".to_string()],
            Some("I"),
    let (_schema, schema_ptr) = create_no_row_id_schema_ptr();
    .unwrap();
        schema,
        .downcast_ref::<arrow::array::ListArray>()
    let index_name = "test-gen-single";
    for batch_ids in [vec![50, 30], vec![10, 40], vec![20, 60]] {
        .unwrap()
    let schema = Arc::new(Schema::new(vec![
    let result =
    assert!(result.is_ok());
// to force multiple flush_and_sort_chunk calls, then verify:
    let expected_sequential: Vec<i64> = (0..10).collect();
 * SPDX-License-Identifier: Apache-2.0
        "Multi chunk path should stamp format version"
        (0..2).map(|row| ids.value(row)).collect::<Vec<_>>(),
    let (ap1, sp1) =
        return false;
    use arrow::array::StringArray;
        cleanup_ffi_data(array_ptr, data_schema_ptr);
        vec!["age".to_string(), "score".to_string()],
    let (ap, sp) = create_ffi_data_with_row_id(
        vec![false],
    }
        "Empty path should stamp writer_generation in output file"
        vec![10, 20, 50]
}
    // Write multiple empty batches
    let (_schema, schema_ptr2) = create_row_id_schema_ptr();
    settings.nulls_first = vec![false];
/// Test: Default writer properties (LZ4_RAW compression, bloom filter enabled) are
    // Verify CRC matches actual file content
        filename.clone(),
        vec!["age".to_string()],
            let filename = file_path.to_string_lossy().to_string();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            if lists.is_null(row) {
fn test_create_writer_invalid_schema_pointer() {
    cleanup_ffi_data(ap, sp);
        filename.clone(),
                        NativeParquetWriter::finalize_writer(filename.clone())
        vec![],
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    );
/// Test: Sorted writer without __row_id__ — batch slicing path.
    );
        .unwrap();
    SETTINGS_STORE.remove(index_name);
    let actual_crc = compute_file_crc32(&filename);
        schema_ptr,
/// the original row order produces the sorted order.
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    assert_eq!(
    assert_eq!(
    for i in 0..rg.num_columns() {
    let index_name = "test-multi-sort-chunked";
#[test]
    SETTINGS_STORE.remove(index_name);
fn create_ffi_data_no_row_id(ages: Vec<i32>, names: Vec<Option<&str>>) -> (i64, i64) {
    assert_eq!(
    SETTINGS_STORE.remove(index_name);
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    // Verify sequential row IDs
            (&ids[..3], &ids[3..])
/// Test: writer_generation is preserved for unsorted (direct Parquet) writer path.
        schema_ptr,
        Some(vec![None, Some("beta")]),
    assert!(result.is_err());
    assert_eq!(
// CRC32 tests
    if metadata.num_row_groups() == 0 {
    settings.sort_in_memory_threshold_bytes = Some(1); // Force slicing on every batch
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
}
    let gen = read_writer_generation_from_parquet(&filename);
    assert!(
        vec![10, 50, 30, 20, 40],
    );
        vec![
    let (ap, sp) = create_ffi_data_with_row_id(
        vec![],
    NativeParquetWriter::create_writer(
/// Helper: creates FFI data WITHOUT __row_id__ column.
    settings.sort_columns = vec!["age".to_string()];
/// Helper: creates an IPC file with (age: Int64, __row_id__: Int64) columns.
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
        index_name.to_string(),
    let mut settings = NativeSettings::default();
        vec![80, 20, 60, 40, 10, 90, 50, 30, 70],
    );
        vec![false],
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        index_name.to_string(),
        index_name.to_string(),
        }
        .map(|i| {
    );
        .index_of("score")
    );
    SETTINGS_STORE.remove(index_name);
        schema_ptr1,
    settings.bloom_filter_enabled = Some(true);
            Some("F"),
        "writer_generation=42 should be in Parquet metadata"
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
                DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
    let format_version = read_format_version_from_parquet(&filename);
        vec![0, 1, 2],
    use arrow::array::Int64Array;
    assert!(result.is_err());
            Some("F"),
        "Mapping must be a valid permutation even with all-identical sort keys"
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    settings.sort_in_memory_threshold_bytes = Some(1); // Per-row slicing
    use arrow::array::{Array, Int32Array, Int64Array, StringArray};
        .expect("Should have row_id_mapping");
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        "Different data should produce different CRC32 values"
    let mut settings = NativeSettings::default();
            Some("A"),
        vec![50, 10, 30],
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    let index_name = "test-slice-desc";
            ]),
}
    // schema_ptr2's FFI struct was consumed by the successful create; free its heap slot.
        vec!["age".to_string()],
        .to_string();
    drop(stored);
    cleanup_ffi_data(ap2, sp2);
#[test]
                return None;
    settings.compression_type = Some("UNCOMPRESSED".to_string());
    let (_temp_dir, filename) = get_temp_file_path("ipc_multi_batch.parquet");
    assert_eq!(row_ids, vec![0, 1, 2, 3, 4]);
    let streaming_crc32 = finalize_result.crc32;
        vec![false],
        schema_ptr,
        vec![10, 20, 30, 40, 50],
        vec![10, 20, 30, 40, 50],
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
#[test]
    let (_temp_dir, filename) = get_temp_file_path("close_with_data.parquet");
#[test]
        vec!["age".to_string()],
fn test_chunked_writer_multi_chunk_descending_sort() {
    let expected_sequential: Vec<i64> = (0..6).collect();
    // With eager sort-and-write, no staging file exists until a chunk is flushed.
            Some("F"),
    let col = combined
        vec![30, 10, 50, 20, 40],
        Path::new(&filename).exists(),
#[test]
    settings.reverse_sorts = vec![false];
    let (_temp_dir, filename) = get_temp_file_path("write_success.parquet");
        "__row_id__ should be sequential 0..9 in merged output"
    // Verify writer generation
    assert_eq!(
        Field::new(
        "Single chunk path should stamp writer_generation"
            Some("omega"),
    // Verify format version
use crate::writer::NativeParquetWriter;
    NativeParquetWriter::create_writer(
    .unwrap();
            Some("H"),
        filename.clone(),
#[test]
    assert_eq!(mapping.len(), 10);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        .unwrap_err()
        OffsetBuffer::new(offsets.into()),
    let ages = read_nullable_ages_from_parquet(&filename);
    );
        kvs.iter()
    let row_ids = read_row_ids_from_parquet(&filename);
        bloom_filter_enabled: Some(false),
        Some(42),
            Some("B"),
fn test_chunked_writer_multi_chunk_row_ids_sequential() {
    // Original: age=[50,10,30,40,20,60], row_ids=[0,1,2,3,4,5]
    // age=30: score=20, score=40 (ASC)
    settings.reverse_sorts = vec![false, true]; // age ASC, score DESC
    SETTINGS_STORE.remove(index_name);
        schema_ptr,
        ),
            if NativeParquetWriter::write_data(filename, array_ptr, data_schema_ptr).is_ok() {
    assert!(
            true,
        mapping,
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    settings.nulls_first = vec![false]; // NULLs last
fn test_sort_batch_uses_minimum_numeric_list_element() {
/// Verifies the slicing + sort works when there's no row ID to rewrite.
    // Write to writer 1 only
        vec!["age".to_string()],
        0,
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    let (_temp_dir, filename) = get_temp_file_path("multi_sort_slice.parquet");
        index_name.to_string(),
    })
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    }
    // mapping[original_row_id] = new_position
    let (_temp_dir, filename) = get_temp_file_path("invalid_ffi.parquet");
    close_writer_and_cleanup_schema(&filename, schema_ptr);
fn test_only_empty_batches_produces_empty_output() {
    settings.reverse_sorts = vec![false]; // ASC
    SETTINGS_STORE.remove(index_name);
        Some("1.0.0.0"),
    // in the sorted output. So sorted_ages[mapping[i]] should reconstruct the sort.
    );
    settings.sort_columns = vec!["age".to_string()];
    .unwrap();
    let temp_dir = tempdir().unwrap();
}
}
    settings.sort_in_memory_threshold_bytes = Some(64);
    let mut values = Vec::new();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let mapping = finalize_result
    assert_eq!(
        &["tags".to_string()],
        sorted_mapping, expected_sequential,
    let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
    let index_name = "test-bloom-false-index-unique1";
    let format_version = read_format_version_from_parquet(&filename);
    settings.sort_in_memory_threshold_bytes = Some(100); // ~2 rows fit
        vec![Some("E"), Some("C"), Some("A"), Some("D"), Some("B")],
        vec!["age".to_string()],
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
        vec![40, 20, 60],
        vec![50, 20, 30, 40, 60],
    let index_name = "test-crc-single";
    assert!(result.is_ok());
/// so tie-breaking order is non-deterministic. This test verifies that:
    cleanup_ffi_schema(schema_ptr);
        schema_ptr,
#[test]
    );
        schema_ptr,
    use parquet::file::reader::{FileReader, SerializedFileReader};
    let (ap, sp) = create_ffi_data_no_row_id(
        Arc::new(StringArray::from(values)),
    assert!(result.unwrap_err().to_string().contains("Writer not found"));
}
    assert!(result1.is_ok());
    );
        Box::into_raw(Box::new(ffi_schema)) as i64,
    assert_eq!(finalize_result.crc32, actual_crc);
        .as_primitive::<arrow::datatypes::Int64Type>();
        .downcast_ref::<Int32Array>()
    assert_eq!(ages, vec![5, 10, 15, 20, 30, 35, 40, 45, 50, 60]);
    (0..col.len()).map(|i| col.value(i)).collect()
/// the accumulated chunk_row_ids.
    // Verify __row_id__ is sequential 0..N
    cleanup_ffi_schema(schema_ptr);
            Some("J"),
    let prefix2 = Path::new(&filename2)
        vec![30, 10, 20],
    // Original: age=[30, NULL, 10, NULL, 20], row_ids=[0,1,2,3,4]
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    close_writer_and_cleanup_schema(&filename2, schema_ptr2);
        metadata.crc32, 0,
#[test]
    assert!(result.is_err());
                Some(col.value(i))
        "Data should preserve insertion order"
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
            .as_primitive::<arrow::datatypes::Int64Type>();
        vec![4, 0, 2, 1, 3],
    }
    assert_eq!(
#[test]
    let mut handles = vec![];
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    // Original: row0=age30, row1=NULL, row2=age10, row3=NULL, row4=age20
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
#[test]
}
        vec![],
            }
        vec![false, true],
        vec![false],
    let (_schema, schema_ptr1) = create_row_id_schema_ptr();
    );
    );
        .unwrap();
    let (_temp_dir, filename) = get_temp_file_path("write_mismatch.parquet");
    let row_ids = read_row_ids_from_parquet(&filename);
    .unwrap();
    // Write multiple batches with interleaved values
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024); // Single chunk
        vec!["age".to_string()],
        .index_of(ROW_ID_COLUMN_NAME)
    let reader = SerializedFileReader::new(file).unwrap();
        vec![
    let (ap3, sp3) =
    settings.sort_columns = vec!["age".to_string()];
        Field::new(ROW_ID_COLUMN_NAME, DataType::Int64, false),
            Some("A"),
    ipc_writer.finish().unwrap();
 *
    );
            }
    )
            .unwrap();
    settings.bloom_filter_enabled = Some(false);
        vec![false],
    settings.nulls_first = vec![false];
    settings.nulls_first = vec![false];
        hasher.update(&buf[..n]);
        "Permutation mapping should correctly map original row IDs to sorted positions"
        vec![],
    let mut settings = NativeSettings::default();
fn test_crc32_differs_for_different_content() {
        vec![false],
}
use std::fs::File;
    let (_temp_dir, filename) = get_temp_file_path("crc_multi.parquet");
        .map(|row| {
    cleanup_ffi_data(array_ptr, data_schema_ptr);
        (true, true, vec![4, 5]),
    let (_schema, schema_ptr) = create_row_id_schema_ptr();
}
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
        .downcast_ref::<Int32Array>()
/// Test: Batch slicing with a threshold that allows exactly 2 rows per slice.
    let (_temp_dir, filename) = get_temp_file_path("ipc_lifecycle.parquet");
        "Multi chunk path should honor bloom_filter_enabled=false"
    );
/// Test: nulls_first=true with __row_id__ — verifies sequential row IDs and correct permutation
            Some("G"),
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        vec![30, 10, 50, 20, 40],
        .to_string();
#[test]
    // All ages should be 30
            Some(row_values) => {
#[test]
            Some("A"),
    let (ap, sp) = create_ffi_data_with_row_id(
    assert_eq!(format_version.as_deref(), Some("1.0.0.0"));
        ages,
    settings.nulls_first = vec![false];
                vec![],
        vec![false],
    assert!(
    .unwrap();
    let (_temp_dir, filename) = get_temp_file_path("props_empty.parquet");
    let (_temp_dir, filename) = get_temp_file_path("test_close.parquet");
/// applied when no explicit settings are configured — single chunk path.
fn read_scores_from_parquet(filename: &str) -> Vec<i32> {
        vec!["age".to_string()],
    let (_temp_dir, filename) = get_temp_file_path("bloom_default.parquet");
        0,
    );
    )
    .unwrap();
    let (ap, sp) = create_ffi_data_with_row_id(
    cleanup_ffi_schema(schema_ptr);
        vec![20, 20, 10, 10, 20],
    NativeParquetWriter::create_writer(
    assert_eq!(scores, vec![40, 20, 50, 30, 10]);
        .map(|row| ascending_ids.value(row))
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
        !has_bloom_filter_in_parquet(&filename),
        .schema()
    .unwrap();
    // age=20: scores 10, 30, 40, 50
    assert_eq!(mem_before, 0, "Memory should be 0 before any chunk flush");
                success_count.fetch_add(1, Ordering::SeqCst);
    use arrow::datatypes::{DataType, Field, Schema};
}
    assert_eq!(success_count.load(Ordering::SeqCst), thread_count);
    .unwrap();
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    let struct_array = arrow::array::StructArray::from(record_batch);
    settings.reverse_sorts = vec![false];
        0,
    );
/// Test: Large dataset with forced multi-chunk — stress test with more rows.
    NativeParquetWriter::create_writer(
            Some("G"),
            Some("D"),
        0,
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
#[test]
        vec![30, 20, 10],
        vec![
    NativeParquetWriter::create_writer(
    let writer_generation = 17i64;
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        filename.clone(),
    let ages = read_ages_from_parquet(&filename);
    assert!(result.is_err());
    let gen = read_writer_generation_from_parquet(&filename);
    assert_eq!(
        vec![false],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
        ])),
    settings.reverse_sorts = vec![false];
        create_test_ffi_data_with_ids(vec![30, 20], vec![Some("C"), Some("B")]).unwrap();
    );
        vec![],
        schema_ptr,
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
        vec![false],
        Field::new("age", DataType::Int32, true),
    assert!(result2
        filename.clone(),
                    row_values
#[test]
    let (ap, sp) = create_ffi_data_with_row_id(
    let struct_array = arrow::array::StructArray::from(record_batch);
    let finalized = NativeParquetWriter::finalize_writer(filename.clone())
            Some("J"),
    let row_ids = read_row_ids_from_parquet(&filename);
// writer generation) configured via NativeSettings are actually honored in the output
    let writer_generation = 999_999i64;
    assert_eq!(mapping, vec![4, 0, 2, 3, 1, 5]);
        "Output should be globally sorted across sliced multi-write batches"
    settings.nulls_first = vec![false];
        let mut missing = missing.to_vec();
    let mut settings = NativeSettings::default();
            Some("D"),
        ],
    let expected_sequential: Vec<i64> = (0..num_rows as i64).collect();
        })
    let mut settings = NativeSettings::default();
    close_writer_and_cleanup_schema(&filename, schema_ptr);
    ]));
                        } else {
    );
                filename.clone(),
) -> (i64, i64) {
                            let ids = read_parquet_file_sorted_ids(&filename);
    use arrow::compute::concat_batches;
    ipc_writer.write(&batch).unwrap();
            .unwrap();
        Field::new("name", DataType::Utf8, true),
                cleanup_ffi_data(ap, sp);
    let ids = (0..ids.len()).map(|row| ids.value(row)).collect::<Vec<_>>();
    let temp_dir = tempdir().unwrap();
        vec![false],
    assert_eq!(mapping.len(), 10);
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
#[test]
    let (_temp_dir1, filename1) = get_temp_file_path("crc32_diff_a.parquet");
        vec![Some("C"), Some("X"), Some("A"), Some("Y"), Some("B")],
    // mapping[0]=4, mapping[1]=0, mapping[2]=2, mapping[3]=3, mapping[4]=1
    cleanup_ffi_schema(schema_ptr2);
    let schema = Arc::new(Schema::new(vec![
    // First batch: row_ids 0..4
    assert!(result.is_ok());
        matches!(compression, parquet::basic::Compression::LZ4_RAW),
        .unwrap();
            &["tags".to_string()],
    let index_name = "test-chunked-large";
        .column(idx)
    cleanup_ffi_data(ap2, sp2);
        .as_any()
}
}
    let (_schema, schema_ptr) = create_multi_sort_schema_ptr();
                cleanup_ffi_data(array_ptr, data_schema_ptr);
        0,
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    // Write 10 rows — should be sliced into ~5 chunks of 2 rows each
    .unwrap();
    let reread_crc32 = compute_file_crc32(&filename);
    );
    let (ap, sp) = create_ffi_data_with_row_id(
        vec!["age".to_string()],
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        0,
/// Test: Multiple chunks with descending sort — verifies correctness with reverse order.
        ],
        vec![],
    settings.sort_columns = vec!["age".to_string()];
    let stored = SETTINGS_STORE.get(index_name).unwrap();
    );
    let mut settings = NativeSettings::default();
        schema,
        vec![10, 20]
}
            Arc::new(Int64Array::from(vec![1, 2, 3, 4, 5, 6])) as ArrayRef,
/// Runs the full sort permutation test for either sort_small_file or sort_large_file.
    .unwrap();
fn test_writer_properties_honored_single_chunk_zstd_with_bloom() {
        "Multi chunk path should honor bloom_filter_enabled=true"
    assert!(metadata.metadata.file_metadata().version() > 0);
    );
    SETTINGS_STORE.remove(index_name);
    settings.reverse_sorts = vec![false];
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        0,
        "CRC should match file content after batch slicing"
        vec!["age".to_string()],
        format_version.as_deref(),
/// Helper: creates FFI schema with nullable age + __row_id__ (age: Int32 nullable, name: Utf8, __row_id__: Int64).
                validity.push(true);
    let (ap, sp) =
    SETTINGS_STORE.remove(index_name);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let reader = SerializedFileReader::new(file).unwrap();
fn create_nullable_with_row_id_schema_ptr() -> (Arc<arrow::datatypes::Schema>, i64) {
    assert_eq!(mapping.len(), 5);
    );
    let (_temp_dir, filename) = get_temp_file_path("slice_large.parquet");
    let batches = read_parquet_file(filename);
    settings.reverse_sorts = vec![false];
        index_name.to_string(),
        mapping,
        0,
    row_ids: Vec<i64>,
        Arc::new(StringArray::from(vec![
    // Verify permutation mapping
    assert!(
    settings.sort_columns = vec!["age".to_string()];
        .column(batch.schema().index_of(column).unwrap())
    use arrow::record_batch::RecordBatch;
    settings.sort_in_memory_threshold_bytes = Some(64);
        sorted_ages, expected_sorted,
    let (_schema, schema_ptr) = create_sorted_writer_and_assert_success(&filename, "id", true);
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
    }
    let gen = read_writer_generation_from_parquet(&filename);
            Field::new(
        vec![false],
    // Original: age=[50,30,10,40,20,25,55,15,35,45], row_ids=[0..9]
    let ascending_ids = ascending
/// Helper: creates FFI schema pointer for a schema with (age: Int32, name: Utf8, __row_id__: Int64).
        .row_id_mapping
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
            Some("B"),
fn test_ipc_staging_descending_sort() {
fn build_nullable_string_list(rows: &[Option<Vec<Option<&str>>>]) -> arrow::array::ListArray {
        vec!["age".to_string()],
            }
        writer_generation,
    drop(stored_after);
fn test_multi_column_sort_age_asc_score_desc() {
    settings.reverse_sorts = vec![false];
        schema_ptr,
    // Sorted:   age=[10,15,20,25,30,35,40,45,50,55]
    assert_eq!(ages, vec![10, 10, 20, 20, 20]);
    let (_schema1, sp1) = create_sorted_writer_and_assert_success(&sorted_file, "id", false);
    let mapping = finalize_result.row_id_mapping.expect("Should have mapping");
        vec![false],
    // No permutation mapping when __row_id__ is absent
    let compression = read_compression_from_parquet(&filename);
        .unwrap()
    cleanup_ffi_data(array_ptr, data_schema_ptr);
    let mem_before =
        let success_count = Arc::clone(&success_count);
    settings.reverse_sorts = vec![false];
                "test-index".to_string(),
    NativeParquetWriter::create_writer(
    )
    // Verify format version is stamped
    // Verify correctness: original_ages[i] at sorted position mapping[i]
        let success_count = Arc::clone(&success_count);
        ),
    // Verify permutation mapping exists and has correct length
#[test]
        "Single chunk path should honor ZSTD compression, got: {:?}",
            Some("G"),
    let (_temp_dir, filename) = get_temp_file_path("multi_sort_asc_desc.parquet");
    // Verify permutation
            .unwrap();
        vec![0, 1, 2, 3, 4],
    // Non-nulls ascending first, then NULLs last
    )
    )
    // mapping[9]=2 (age=15→pos2)
    let (_temp_dir1, sorted_file) = get_temp_file_path("ipc_sorted.parquet");
        vec![],
        .expect("Should have row_id_mapping");
    cleanup_ffi_data(ap1, sp1);
    // Verify descending sort
        vec![false],
    )
            Some("E"),
    let expected_perm: Vec<i64> = (0..10).collect();
        "Output should be sorted by age DESC with batch slicing"
            Some("E"),
    SETTINGS_STORE.remove(index_name);
    cleanup_ffi_schema(schema_ptr);
        .to_string_lossy()
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        vec!["age".to_string()],
    settings.bloom_filter_ndv = Some(200_000);
    let file = File::open(filename).unwrap();
        .unwrap()
    assert_eq!(read_metadata.file_metadata().num_rows(), 6);
    );
    let (_schema, schema_ptr) = create_test_ffi_schema();
    // Verify writer_generation in metadata
        vec![2, 3, 0, 4, 1],
    use parquet::file::reader::{FileReader, SerializedFileReader};
        vec![],
/// Test: Batch slicing with descending sort — verifies slicing doesn't break sort direction.
    // Original: row0=age30, row1=NULL, row2=age10, row3=NULL, row4=age20
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    settings.compression_type = Some("SNAPPY".to_string());
        vec![false],
    // so each row becomes its own chunk.
    let index_name = "test-nulls-first-rowid";
            Arc::new(Int64Array::from(vec![10, 20, 30, 40])) as ArrayRef,
#[test]
        assert_eq!(
        "Output should be sorted even without __row_id__ in multi-chunk path"
    (schema, schema_ptr)
    let mut settings = NativeSettings::default();
    assert_eq!(
    settings.sort_columns = vec!["age".to_string()];
}
    }
        index_name.to_string(),
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
        vec![10, 20, 30, 40, 50, 60, 70, 80],
        NativeParquetWriter::has_writer(&filename),
            Some("B"),
fn test_chunked_writer_batch_slicing_two_rows_per_slice() {
                    {
    .unwrap();
    let mut permutation = finalized.row_id_mapping.unwrap();
        .unwrap();
        .unwrap();
                vec![],
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024); // Large — single chunk
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    let index_name = "test-nulls-first-false";
        schema_ptr,
    )
    NativeParquetWriter::finalize_writer(unsorted_file.clone()).unwrap();
    );
    settings.bloom_filter_enabled = Some(true);
    assert_eq!(mapping, vec![4, 1, 3, 2, 0, 5]);
        vec![false],
    );
    let success_count = Arc::new(AtomicUsize::new(0));
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
        filename.clone(),
    );
        Some(vec![None]),
    let mut handles = vec![];
    use arrow::datatypes::{DataType, Field, Schema};
fn test_nulls_first_false_ascending() {
        filename.clone(),
    // Verify compression is UNCOMPRESSED
            Some("C"),
    let mut settings = NativeSettings::default();
    let struct_array = arrow::array::StructArray::from(batch);
        .expect("Should have row_id_mapping");
    let (_temp_dir, filename) = get_temp_file_path("list_sort_multi_chunk.parquet");
        index_name.to_string(),
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    let result = NativeParquetWriter::create_writer(
        vec![false],
    assert_eq!(row_ids, expected_sequential);
    let (_temp_dir, filename) = get_temp_file_path("complete_workflow.parquet");
            .unwrap();
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let (_temp_dir, filename) = get_temp_file_path("multi_sort_chunked.parquet");
fn test_ipc_staging_multi_batch_sort() {
        vec!["age".to_string()],
        vec![
    let mut ascending_missing = (3..6)
#[test]
        schema_ptr1,
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        vec![Some("C"), Some("X"), Some("A"), Some("Y"), Some("B")],
    let rg = metadata.row_group(0);
    assert!(result.unwrap() >= 0);
    // Verify globally sorted
            "tags",
    settings.nulls_first = vec![true]; // NULLs first
    let index_name = "test-slice-two";
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
    let mut settings = NativeSettings::default();
    // Verify sorted output
    let result = NativeParquetWriter::finalize_writer("nonexistent.parquet".to_string());
/// Helper: creates FFI schema pointer for a schema WITHOUT __row_id__ (age: Int32, name: Utf8).
        vec![],
    .unwrap();
    let sorted = NativeParquetWriter::sort_batch(
    // age=10: score=70
    metadata.key_value_metadata().and_then(|kvs| {
    // ... and is idempotent: a second cleanup on a missing entry is still Ok.
    // Verify sequential row IDs
    let mut settings = NativeSettings::default();
    assert!(result2.is_err());
    let (ap2, sp2) =
    .unwrap();
            .map(|row| ascending_ids.value(row))
/// Helper: reads nullable age column, returning None for nulls.
            Some("J"),
    // age=20: score=30, score=50 (ASC)
    let result1 = NativeParquetWriter::finalize_writer(filename1.clone())
    );
    let mut settings = NativeSettings::default();
    );
    let row_ids = read_row_ids_from_parquet(&filename);
            Some("F"),
    ]));
        index_name.to_string(),
        vec![0, 1, 2, 3, 4],
        0,
    assert!(
            let filename = file_path.to_string_lossy().to_string();
}
    // mapping[0]=7(80→pos7), mapping[1]=1(20→pos1), mapping[2]=5(60→pos5),
    // Verify data is sorted
    settings.sort_columns = vec!["age".to_string()];
        "Mapping should be a valid permutation"
        .map(|row| descending_ids.value(row))
        schema_ptr,
            (&ids[2..], &ids[..2])
    for _ in 0..3 {
    );
    settings.nulls_first = vec![false];
        .unwrap()
    let record_batch =
/// Test: A single large batch that exceeds the memory threshold is sliced and produces
        ],
    let schema = Arc::new(Schema::new(vec![
    let (_schema, schema_ptr) = create_multi_sort_schema_ptr();
    let mut settings = NativeSettings::default();
        vec![],
/// Test: Multi-column sort with forced multi-chunk — verifies the k-way merge
        vec![false],
    }
    );
        Field::new("age", DataType::Int32, false),
        sorted_mapping, expected_sequential,
    NativeParquetWriter::write_data(filename.clone(), ap1, sp1).unwrap();
    // Original: age=[50,30,10,40,20,60,5,45,35,15], row_ids=[0..9]
    // Write a batch with 8 rows — each row will be sliced individually
    assert_eq!(mapping.len(), 9);
    )
        schema_ptr2,
    let (_schema, schema_ptr) = create_nullable_with_row_id_schema_ptr();
    close_writer_and_cleanup_schema(&filename1, schema_ptr1);
        "Multi chunk path should honor bloom_filter_enabled=true"
fn test_unsorted_writer_generation_in_metadata() {
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
            Some("I"),
}
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        vec![],
/// Test: get_filtered_writer_memory_usage with path prefix filtering.
    let index_name = "test-chunked-invertible";
    use arrow::datatypes::{DataType, Field, Schema};
    use arrow::compute::concat_batches;
    let mut ipc_writer = IpcFileWriter::try_new(file, &schema).unwrap();
    );
    let index_name = "test-slice-large";
    let ages = read_ages_from_parquet(&filename);
    NativeParquetWriter::create_writer(
    settings.sort_columns = vec!["age".to_string(), "score".to_string()];
    assert!(
        gen,
 */
    // All rows have age=30 — sort has zero ordering information
            Arc::new(Int64Array::from(vec![10, 20, 30, 40, 50, 60])) as ArrayRef,
    );
        vec![true],
    let age_array: Arc<dyn Array> = Arc::new(Int32Array::from(ages));
    use arrow::record_batch::RecordBatch;
}
    use arrow::array::{ArrayRef, AsArray, Int32Array, Int64Array, ListArray, RecordBatch};
        "row_id_mapping should be None without __row_id__ column"
    }
    // Don't create any writer — just try to write data
    // MAX reduction, ascending, nulls last => order by MAX element:
            Some("alpha"),
            Some("A"),
    let row_ids_in_file = read_row_ids_from_parquet(&filename);
fn test_bloom_filter_default_when_no_settings() {
            i, original_ages[i], new_pos, sorted_ages[new_pos]
    )
                vec![],
    }
}
    assert!(
    settings.sort_columns = vec!["age".to_string()];
    let result2 = NativeParquetWriter::finalize_writer(filename);
    for (descending, nulls_first, expected_values) in [
    assert_eq!(finalize_result.metadata.file_metadata().num_rows(), 9);
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    // age=10: score=40, score=20 (DESC)
        schema_ptr,
        .as_any()
        vec![],
        .downcast_ref::<Int64Array>()
    settings.sort_columns = vec!["age".to_string()];
    let record_batch = RecordBatch::try_new(schema.clone(), vec![age_array, name_array]).unwrap();
    let mut settings = NativeSettings::default();
                            if ids == vec![10, 20, 30] {
    let (_temp_dir, filename) = get_temp_file_path("gen_large.parquet");
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let index_name = "test-props-single-uncompressed";
    let index_name = "test-props-multi-uncompressed";
}
    assert_eq!(mapping, vec![2, 0, 1]);
            Some("B"),
}
        schema_ptr2,
    let (ap, sp) = create_ffi_data_no_row_id(
        "Data should be sorted ascending by id"
    settings.sort_in_memory_threshold_bytes = Some(10 * 1024 * 1024);
    let row_ids = read_row_ids_from_parquet(&filename);
    let (_temp_dir, filename) = get_temp_file_path("slice_multi_write.parquet");
fn run_sort_permutation_test(_use_large_file: bool, _label: &str) {
        Some(NullBuffer::from(vec![true, true, true, false])),
    // Verify sequential row IDs
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    settings.sort_in_memory_threshold_bytes = Some(64); // Force multiple chunks
    // fresh writer is created in its place. (This is what unblocks shard recovery after a failure
/// Test: CRC32 is non-zero and matches file content for single-chunk sorted output.
        .collect()
    NativeParquetWriter::create_writer(
    let (ap2, sp2) = create_ffi_data_with_row_id(
        vec![true],
    )
#[test]
        vec![],
    settings.reverse_sorts = vec![false];
    let (_temp_dir2, filename2) = get_temp_file_path("crc_diff2.parquet");
    let mut settings = NativeSettings::default();
/// Helper: reads the writer_generation from Parquet file metadata.
    assert_eq!(stored.get_bloom_filter_enabled(), false);
            let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    for i in 0..num_rows as usize {
        vec![false, false],
    ]));
// These tests exercise the code path in SortingChunkedWriter::write() where a single
        vec![0, 1, 2, 3, 4],
    ]));
        vec![0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
    // Verify it matches the actual file
    ]));
    let (_temp_dir, filename) = get_temp_file_path("sorted_desc.parquet");
}
        "CRC32 from finalize should match recomputed CRC for multi-chunk output"
    assert!(result
    let schema = Arc::new(Schema::new(vec![
    let compression = read_compression_from_parquet(&filename);
/// Test: Multiple write_data calls with small threshold — verifies that data
    )
    );
    settings.sort_columns = vec!["age".to_string(), "score".to_string()];
        vec!["age".to_string()],
    )
        kvs.iter()
    settings.reverse_sorts = vec![false];
) -> Vec<Option<Vec<Option<String>>>> {
            Some("E"),
fn test_create_writer_same_file_removes_stale_and_succeeds() {
            Some("E"),
    settings.compression_type = Some("UNCOMPRESSED".to_string());
                    vec![Some("C"), Some("A"), Some("B")],
    );
    // mapping[6]=4(50→pos4), mapping[7]=2(30→pos2), mapping[8]=6(70→pos6)
    SETTINGS_STORE.insert(index_name.to_string(), settings);
/// Test: Different data produces different CRC32 values (sanity check).
    SETTINGS_STORE.remove(index_name);
    )
        vec![false],
    let (ap, sp) = create_ffi_data_with_row_id(
use std::path::Path;
        0,
        let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
        index_name.to_string(),
        filename.clone(),
    NativeParquetWriter::create_writer(
        .unwrap();
            Some("G"),
    ]));
#[test]
}
    );
    SETTINGS_STORE.insert(index_name.to_string(), settings);
    let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
        0,
    let mut offsets = vec![0_i32];
    let mapping = finalize_result
    let expected_sequential: Vec<i64> = (0..8).collect();
    let ages = read_nullable_ages_from_parquet(&filename);
    settings.nulls_first = vec![false];
        .column(0)
    let (_temp_dir, filename) = get_temp_file_path("props_multi_zstd.parquet");
    )
    assert!(
    let (_temp_dir, filename) = get_temp_file_path("ipc_empty.parquet");
        "CRC32 should be non-zero for single-chunk sorted output"
    missing_ids.sort_unstable();
        vec![],
        .unwrap();
    NativeParquetWriter::write_data(filename1.clone(), ap1, sp1).unwrap();
    let index_name = "test-chunked-single";
    ] {
        schema_ptr,
        vec![
    SETTINGS_STORE.insert(index_name.to_string(), settings);
#[test]
        vec![0, 1, 2, 3, 4],
            Some("C"),
        "Single chunk path should honor bloom_filter_enabled=false (no bloom filter in file)"
    assert!(
        vec![50, 30, 10, 40, 20, 60, 5, 45, 35, 15],
            Some("A"),
            &[false],
    SETTINGS_STORE.remove(index_name);
        vec![false],
        vec!["age".to_string()],
        vec!["tags".to_string()],
    let (ap, sp) = create_ffi_data_multi_sort(
    assert_eq!(row_ids, vec![0, 1, 2]);
        Some(0),
        schema_ptr,
) -> (i64, i64) {
        .unwrap()
        .unwrap()
        let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
        index_name: Some(index_name.to_string()),
        .expect("score should be Int32");
            Some("G"),
    let batches = read_parquet_file(&filename);
        "Should get 'Writer not found' error for non-existent IPC writer"
        .unwrap();
    use arrow::datatypes::{DataType, Field, Schema};
    settings.reverse_sorts = vec![false];
    // Verify bloom filter is NOT present (disabled)
            cleanup_ffi_schema(schema_ptr);
    let result = NativeParquetWriter::write_data(filename.clone(), 0, schema_ptr);
        vec![50, 30, 10, 40, 20],
    )
    let name_array: Arc<dyn Array> = Arc::new(StringArray::from(names));
        "Final Parquet file should exist"
        vec![false],
        "Multiple IPC batches should be sorted correctly"
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
    use arrow::array::{Array, Int32Array, StringArray};
            Some("H"),
    )
        vec![Some("F"), Some("G"), Some("H"), Some("I"), Some("J")],
        .column(0)
    assert_eq!(
        "Large writer_generation should be preserved in Parquet metadata"
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    assert_eq!(scores, vec![20, 40, 30, 50, 60]);
    let row_id_array: Arc<dyn Array> = Arc::new(Int64Array::from(row_ids));
        "Output should be sorted DESC without __row_id__ in slicing path"
    )
        NativeParquetWriter::get_filtered_writer_memory_usage(path_prefix.clone()).unwrap();
                let (ap, sp) = create_test_ffi_data_with_ids(
        index_name.to_string(),
    let mut settings = NativeSettings::default();
        "Single chunk path should honor SNAPPY compression, got: {:?}",
    assert_eq!(success_count.load(Ordering::SeqCst), 10);
    let mem_final = NativeParquetWriter::get_filtered_writer_memory_usage(path_prefix).unwrap();
            Some(vec![None, Some("charlie".to_string())]),
#[test]
    let mut settings = NativeSettings::default();
        vec![],
        vec!["age".to_string()],
}
    assert!(
    // We need a threshold that allows ~2 rows. A single Int32 + Utf8 + Int64 row
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    settings.sort_columns = vec!["age".to_string()];
        filename.clone(),
        vec!["age".to_string()],
    // Write an empty batch (0 rows)
#[test]
    let list = ListArray::new(
        .row_id_mapping
fn test_write_data_no_ipc_writer() {
    );
#[test]
        "CRC32 from finalize should match recomputed CRC of the file on disk"
    cleanup_ffi_data(ap2, dp2);
            Some("B"),
    let (_temp_dir, filename) = get_temp_file_path("concurrent_write_ffi.parquet");
            Arc::new(list) as ArrayRef,
            Some("F"),
        "test-index".to_string(),
/// Test: Sorted writer without __row_id__ column — multi chunk (forced by small threshold).
    close_writer_and_cleanup_schema(&filename, schema_ptr);
            .unwrap();
    let metadata = reader.metadata();
    settings.reverse_sorts = vec![false];
        vec![30, 10, 50, 20, 40],
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
#[test]
    // No sort columns — uses direct Parquet writer path
        finalize_result.row_id_mapping.is_none(),
        ages,
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
    settings.sort_columns = vec!["age".to_string(), "score".to_string()];
    // Verify: for each original row, mapping[original_row_id] gives its position
        row_ids, expected_sequential,
// #[test]
    let list = ListArray::new(
#[test]
        .unwrap();
        if n == 0 {
    );
    cleanup_ffi_data(array_ptr, data_schema_ptr);
        vec![false],
    // No permutation mapping
    let (ap, sp) = create_ffi_data_with_row_id(
    assert_eq!(row_ids, (0..6).collect::<Vec<_>>());
    SETTINGS_STORE.remove(index_name);
    for handle in handles {
    assert!(
            Some("J"),
    // Finalize and verify writer is removed
    );
        NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    sorted_mapping.sort();
        ],
        ],
    SETTINGS_STORE.insert(index_name.to_string(), settings);
        compression
    SETTINGS_STORE.remove(index_name);
        vec![
        .contains("Invalid FFI addresses"));
        "__row_id__ should be sequential 0..9"
        0,
    }
    )
#[test]
    let mut settings = NativeSettings::default();
        .expect("__row_id__ column should exist");
    let batch = RecordBatch::try_new(
        matches!(compression, parquet::basic::Compression::LZ4_RAW),
            for _ in 0..2 {
            DataType::List(Arc::new(Field::new("element", DataType::Utf8, true))),
        vec![
        num_rows - 1
        index_name.to_string(),
    let (ap, sp) = create_ffi_data_with_row_id(
    .unwrap();
        vec![0, 1, 2],
        "__row_id__ should be sequential 0..4"
    let (_temp_dir, filename) = get_temp_file_path("close_race.parquet");
    for handle in handles {
    let mut hasher = crc32fast::Hasher::new();
                vec![],
        Field::new(
    let metadata = result.unwrap().unwrap();
    cleanup_ffi_data(ap1, dp1);
    // mapping[0]=8, mapping[1]=4, mapping[2]=0, mapping[3]=6, mapping[4]=2
}
        };
    // Sorted:   age=[10,20,30,40,50,60,70,80]
    )
        vec![
        vec![0, 1, 2, 3, 4],
    let finalize_result = NativeParquetWriter::finalize_writer(filename.clone())
#[test]
/// Test: Writer properties (ZSTD compression, bloom filter enabled) are honored
        "test-index".to_string(),
            Some("F"),
    let mut missing_ids = ids[4..].to_vec();
    // age=10: score=60
    let (_temp_dir1, filename1) = get_temp_file_path("mem_prefix_a.parquet");
        Field::new("id", DataType::Int64, false),
    let ids = read_parquet_file_sorted_ids(&filename);
    if batches.is_empty() {
            Some("z"),
        vec![false],
    let (_schema2, schema_ptr2) = create_writer_and_assert_success(&filename2);
#[test]
    assert_eq!(
// 1. Row IDs are sequential 0..N in each chunk and in the final output
    // Verify sorted output
        vec![Some("C"), Some("A"), Some("B")],
    let index_name = "test-bloom-default-index-unique2";
    assert_eq!(
#[test]
    );
    let index_name = "test-chunked-multi-write";
    );
    ]));
    }
    loop {
        .unwrap()
        cleanup_ffi_data(array_ptr, data_schema_ptr);
#[test]
// ===== Empty batch handling and memory usage tests =====
    NativeParquetWriter::finalize_writer(filename.clone()).unwrap();
        vec![false],
    assert_eq!(
        vec![false],
    let scores = read_scores_from_parquet(&filename);
    assert_eq!(sorted_ids, vec![10, 20, 30]);
        );
    // The two NULLs were at original positions 1 and 3 (stable order preserved by RowConverter)
        cleanup_ffi_data(ap, sp);
    // Verify sequential row IDs
    let (_temp_dir, filename) = get_temp_file_path("chunked_multi_write.parquet");
/// Only writers whose temp path starts with the prefix should be counted.
        0,
            Some("H"),
            Some("H"),
fn test_sort_batch_uses_minimum_list_element() {
        vec![false],
    assert_eq!(ages, vec![None, None, Some(10), Some(20), Some(30)]);
    // Verify it's a valid permutation
        vec![],
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let (ap2, sp2) =
    let scores = read_scores_from_parquet(&filename);
    .unwrap();
        .unwrap()
    // Second batch: row_ids 5..9
    let (array_ptr, data_schema_ptr) = write_ffi_data_to_writer(&filename);
        vec![30, 10, 20],
#[test]
    let mut settings = NativeSettings::default();
fn test_multi_column_sort_batch_slicing() {
        .downcast_ref::<Int32Array>()
    let (_schema, schema_ptr) = create_writer_and_assert_success(&filename);
    for i in 0..10 {
#[test]
    let (ap, sp) = create_ffi_data_with_row_id(
    );
        vec![],
        handle.join().unwrap();
    settings.bloom_filter_fpp = Some(0.01);
    let (_schema, schema_ptr1) = create_row_id_schema_ptr();
    assert!(
fn test_sort_all_identical_keys_produces_valid_permutation() {
        }
    .unwrap();
    let ffi_schema = arrow::ffi::FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
}
    sorted_mapping.sort();
        0,
    for (i, filename) in filenames.iter().enumerate() {
        "row_id_mapping should be None when schema has no __row_id__ column"
                    })
        missing.sort_unstable();
/// Test: Writer properties (SNAPPY compression, bloom filter disabled) are honored
    // Configure with large threshold so everything fits in one chunk
        vec![Some("A"), Some("B"), Some("C")],
}
        let temp_dir_path = temp_dir.path().to_path_buf();
    NativeParquetWriter::write_data(filename.clone(), ap, sp).unwrap();
    let mut settings = NativeSettings::default();
        RecordBatch::try_new(schema.clone(), vec![age_array, name_array, row_id_array]).unwrap();
    // Verify writer generation is stamped
    let compression = read_compression_from_parquet(&filename);
