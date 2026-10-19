        .column(0)
    ids: Vec<i32>,
pub fn create_test_ffi_data_with_ids(
    cleanup_ffi_schema(schema_ptr);
    let builder = ParquetRecordBatchReaderBuilder::try_new(file).unwrap();
        .downcast_ref::<Int32Array>()
    (schema, schema_ptr)
    let id_col = combined
        filename.to_string(),
    (array_ptr, data_schema_ptr)
    let record_batch = RecordBatch::try_new(schema.clone(), vec![count_array, active_array])?;
use arrow::datatypes::{DataType, Field, Schema};
}
pub fn close_writer_and_get_metadata(
) -> (Arc<Schema>, i64) {
    let combined = concat_batches(&batches[0].schema(), &batches).unwrap();
use tempfile::tempdir;
/*
        let _ = Box::from_raw(schema_ptr as *mut FFI_ArrowSchema);
pub fn create_writer_and_assert_success(filename: &str) -> (Arc<Schema>, i64) {
    let (array_ptr, data_schema_ptr) = create_test_ffi_data().unwrap();
    let schema = Arc::new(Schema::new(vec![
    (temp_dir, filename)
}
use arrow::compute::concat_batches;
}
}
pub fn create_sorted_writer_with_mode(
        vec![],
    sort_column: &str,
        schema_ptr,
    filename: &str,
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    let record_batch = RecordBatch::try_new(schema.clone(), vec![id_array, name_array])?;
        Field::new("name", DataType::Utf8, true),
}
 * compatible open source license.
        vec![reverse],
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref())?;
    ]));
pub fn close_writer_and_cleanup_schema(filename: &str, schema_ptr: i64) {
    let id_array = Arc::new(Int32Array::from(ids));
) -> (Arc<Schema>, i64) {
    let ffi_array = FFI_ArrowArray::new(&array_data);
    create_sorted_writer_with_mode(filename, sort_column, reverse, reverse)
        vec![],
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
pub fn read_parquet_file(filename: &str) -> Vec<RecordBatch> {
    max_mode: bool,
        Field::new("active", DataType::Boolean, true),
pub fn read_parquet_file_sorted_ids(filename: &str) -> Vec<i32> {
    let array_data = struct_array.into_data();
    let active_array = Arc::new(BooleanArray::from(vec![Some(true), Some(false), None]));
}
    );
    let name_array = Arc::new(StringArray::from(names));
        filename.to_string(),
use arrow::array::Array;
pub fn write_ffi_data_to_writer(filename: &str) -> (i64, i64) {
pub fn get_temp_file_path(name: &str) -> (tempfile::TempDir, String) {
        let _ = Box::from_raw(array_ptr as *mut FFI_ArrowArray);
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
pub fn create_test_ffi_data() -> Result<(i64, i64), Box<dyn std::error::Error>> {
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    let result = NativeParquetWriter::create_writer(
pub fn cleanup_ffi_schema(schema_ptr: i64) {
    let temp_dir = tempdir().unwrap();
pub fn create_test_ffi_schema() -> (Arc<Schema>, i64) {
    assert!(result.is_ok());
        schema_ptr,
    let ffi_array = FFI_ArrowArray::new(&array_data);
    unsafe {
        vec![max_mode],
pub fn create_sorted_writer_and_assert_success(
    let _ = NativeParquetWriter::finalize_writer(filename.to_string());
}
        vec![],
    // Default reduction mode mirrors OpenSearch: MAX for DESC, MIN for ASC.
use arrow::record_batch::RecordBatch;
    );
    ]));
    schema_ptr: i64,
}
    reverse: bool,
    Ok((array_ptr, schema_ptr))
 * The OpenSearch Contributors require contributions made to
    let file = File::open(filename).unwrap();
        "test-index".to_string(),
/// multi-value reduction mode (`max_mode == true` selects MAX, else MIN).
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
}
        vec![false],
}
    }
    let result = NativeParquetWriter::finalize_writer(filename.to_string());
    unsafe {
) -> Result<(i64, i64), Box<dyn std::error::Error>> {
pub fn cleanup_ffi_data(array_ptr: i64, schema_ptr: i64) {
}
    ]));
    let struct_array = StructArray::from(record_batch);
    let filename = file_path.to_string_lossy().to_string();
        Field::new("id", DataType::Int32, false),
    Ok((array_ptr, schema_ptr))
    let file_path = temp_dir.path().join(name);
    }
    let (schema, schema_ptr) = create_test_ffi_schema();
    let batches = read_parquet_file(filename);
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref())?;
use arrow::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
    reader.collect::<Result<Vec<_>, _>>().unwrap()
}
 * this file be licensed under the Apache-2.0 license or a
    let reader = builder.build().unwrap();
        Field::new("id", DataType::Int32, false),
    sort_column: &str,
/// Like [`create_sorted_writer_and_assert_success`] but with an explicit
        "test-index".to_string(),
    result.unwrap().unwrap()
use std::sync::Arc;
    let count_array = Arc::new(Int64Array::from(vec![10, 20, 30]));
 *
    (schema, schema_ptr)
    let result = NativeParquetWriter::create_writer(
use std::fs::File;
        let _ = Box::from_raw(schema_ptr as *mut FFI_ArrowSchema);
        .as_any()
) -> crate::writer::FinalizeResult {
    let (schema, schema_ptr) = create_test_ffi_schema();
    create_test_ffi_data_with_ids(vec![1, 2, 3], vec![Some("Alice"), Some("Bob"), None])
    let schema = Arc::new(Schema::new(vec![
    (0..id_col.len()).map(|i| id_col.value(i)).collect()
    assert!(result.is_ok());
}
    reverse: bool,
        .unwrap();
use crate::writer::NativeParquetWriter;
    filename: &str,
    names: Vec<Option<&str>>,
use arrow::array::{Int32Array, StringArray, StructArray};
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
    filename: &str,
    let array_data = struct_array.into_data();
        vec![],
    let struct_array = StructArray::from(record_batch);
        0,
        vec![sort_column.to_string()],
    (schema, schema_ptr)
    cleanup_ffi_schema(schema_ptr);
pub fn create_mismatched_ffi_data() -> Result<(i64, i64), Box<dyn std::error::Error>> {
}
 */
}
        Field::new("count", DataType::Int64, false),
    let schema = Arc::new(Schema::new(vec![
        0,
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).unwrap();
        Field::new("name", DataType::Utf8, true),
    use arrow::array::{BooleanArray, Int64Array};
 * SPDX-License-Identifier: Apache-2.0
    let result = NativeParquetWriter::write_data(filename.to_string(), array_ptr, data_schema_ptr);
    assert!(result.is_ok());
