            )])),
            0, // context_id
            "sliced array should still carry full buffers before GC, got {}",
        .expect("batch from sliced array");
// ---------------------------------------------------------------------------
            .expect("still a StringViewArray");
    assert!(session_ptr > 0);
    let schema = utf8view_schema();
            &mut out_len as *mut i64,
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
    );
        // Verify the full array has substantial backing buffers
    // Without compaction: buffers would be >200KB (full 10K-element backing).
use std::thread;
            out_buf.as_mut_ptr(),
impl RuntimeGuard {
            .downcast_ref::<StringViewArray>()
        let sliced_buffer_size: usize = sliced_view.data_buffers().iter().map(|b| b.len()).sum();
        .expect("build tokio rt");
    let sender_ptr = register_input(session_ptr, "input-0", schema.as_ref());
        .sql("SELECT * FROM \"input-0\"")
use arrow_array::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
            Arc::new(Schema::new(vec![Field::new(
}
fn utf8view_schema() -> SchemaRef {
 * SPDX-License-Identifier: Apache-2.0
    // Build a substrait plan for passthrough SELECT
use datafusion_substrait::logical_plan::producer::to_substrait_plan;
            DataType::Utf8View,
                128 * 1024 * 1024,
// One-time setup (same OnceLock pattern as local_exec_test.rs)
            df_create_global_runtime(
}
        }
            .build()
    unsafe { df_close_local_session(session_ptr) };
    let mut output_batches: Vec<RecordBatch> = Vec::new();
        let ffi_schema =
        assert!(rc >= 0, "df_stream_next rc={}", rc);
impl Drop for RuntimeGuard {
        };
            plan_bytes.as_ptr(),
        )
    RT_INIT.get_or_init(|| {
        "s",
/*
use opensearch_datafusion::ffm::{
        .expect("sql parses")
            .to_string();
            .as_any()
 * compatible open source license.
    };
use prost::Message;
    assert!(
    let mut buf = Vec::new();
 * The OpenSearch Contributors require contributions made to
        let result_schema = Arc::new(Schema::new(vec![Field::new(
    let runtime = RuntimeGuard::new();
/// Build a substrait plan for `SELECT * FROM "input-0"` with the given schema.
use datafusion::datasource::MemTable;
}
                64 * 1024 * 1024,
//! When compaction is active, the output batch's backing buffers should be
            .expect("build tokio rt");
            vec![Arc::new(sliced)],
            out_buf.len() as i64,
    // Each string is ~30 bytes so the full array backing is ~300KB.
    assert!(rc > 0, "df_register_partition_stream rc={}", rc);
        let ffi_array = unsafe { Box::from_raw(rc as *mut FFI_ArrowArray) };
    let empty = MemTable::try_new(Arc::clone(&schema), vec![vec![]]).expect("mem table");
        ensure_runtime_manager();
    let ffi_array = FFI_ArrowArray::new(&array_data);
        .logical_plan()
        let rt = tokio::runtime::Builder::new_current_thread()
                "s",
        let batch = RecordBatch::try_new(
#[test]
    fn new() -> Self {
        unsafe { df_close_global_runtime(self.ptr) };
    producer.join().expect("producer thread");
    let mut out_len: i64 = 0;
//! buffer (~300KB).
         This indicates compact_string_view_columns is not working.",
            full_buffer_size > 200_000,
        let spill_path = spill_dir
use datafusion::prelude::SessionContext;
        let full_array = StringViewArray::from_iter_values(full_strings.iter().map(|s| s.as_str()));
    unsafe { df_stream_close(stream_ptr) };
}
// ---------------------------------------------------------------------------
    df_create_local_session, df_execute_local_plan, df_init_runtime_manager,
fn test_stringview_gc_on_sliced_batch() {
use tempfile::TempDir;
    // Create a 10K-element StringViewArray, then slice to 100 rows.
    (array_ptr, schema_ptr)
        rt.block_on(build_passthrough_substrait(Arc::clone(&schema)))
    substrait.encode(&mut buf).expect("encode");
    rc
    assert!(stream_ptr > 0, "df_execute_local_plan rc={}", stream_ptr);
        .clone();
        Self {
        )]));
        let spill_bytes = spill_path.as_bytes();
    ctx.register_table("input-0", Arc::new(empty))
            _spill_dir: spill_dir,
// ---------------------------------------------------------------------------
    let struct_array: StructArray = batch.into();
        "StringView buffers should be compacted to ~3KB, but got {} bytes. \
            sliced_buffer_size > 200_000,
use arrow_schema::{DataType, Field, Schema, SchemaRef};
            .expect("Utf8View column");
        let array_data =
            .map(|i| format!("string-value-padding-{:010}", i))
        let rc = unsafe { df_stream_next(stream_ptr) };
        df_execute_local_plan(
};
    // With compaction (line 459 active): buffers should be <= 10KB (generous margin).
        )
            "full array buffer size should be >200KB, got {}",
fn register_input(session_ptr: i64, input_id: &str, schema: &Schema) -> i64 {
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).expect("schema export");
        assert!(rc > 0, "df_create_global_runtime returned {}", rc);
        )
    }
    for batch in &output_batches {
    // The sliced batch only references 100 strings (~3KB of actual data).
    let array_data = struct_array.into_data();
        let col = batch
    }
    df_register_partition_stream, df_sender_close, df_sender_send, df_stream_close, df_stream_next,
    let mut total_buffer_bytes: usize = 0;
// ---------------------------------------------------------------------------
        let sliced = full_array.slice(100, 100);
        unsafe { df_sender_close(sender_ptr) };
        false,
        .expect("register input-0");
    };
    });
    let rt = tokio::runtime::Builder::new_current_thread()
struct RuntimeGuard {
            .expect("utf-8 spill path")
            session_ptr,
    loop {
    Arc::new(Schema::new(vec![Field::new(
                spill_bytes.as_ptr(),
use std::sync::{Arc, OnceLock};
            false,
            plan_bytes.len() as i64,
        df_register_partition_stream(
            "s",
        total_buffer_bytes += buf_size;
// ---------------------------------------------------------------------------
    buf
    // Drain the output and check buffer sizes
                spill_bytes.len() as i64,
            full_buffer_size
            session_ptr,
            substrait_bytes.len() as i64,
                0,
        assert!(
        );
    // 100 strings of ~30 bytes each = ~3KB of actual data.
            FFI_ArrowSchema::try_from(result_schema.as_ref()).expect("result schema export");
    let plan_bytes = rt.block_on(build_passthrough_substrait(Arc::new(schema.clone())));
        DataType::Utf8View,
    fn drop(&mut self) {
//!
        );
        let struct_array = StructArray::from(array_data);
}
                DataType::Utf8View,
            .to_str()
 * this file be licensed under the Apache-2.0 license or a
        assert!(
    let mut out_buf = vec![0u8; 64 * 1024];
            .collect();
        }
        .enable_all()
// ---------------------------------------------------------------------------
async fn build_passthrough_substrait(schema: SchemaRef) -> Vec<u8> {
            .downcast_ref::<StringViewArray>()
            ptr: rc,
    };
        let batch = RecordBatch::from(struct_array);
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    )]))
        df_init_runtime_manager(1, 1.5, 1.5);
        assert_eq!(rc, 0, "df_sender_send rc={}", rc);
        total_buffer_bytes
        let (arr_ptr, sch_ptr) = export_batch_ptrs(batch);
            .as_any()
}
}
        // Slice to rows [100..200] — only 100 elements
    let ctx = SessionContext::new();
        let full_strings: Vec<String> = (0..10_000)
    let schema = batch.schema();
            sliced_buffer_size
fn export_batch_ptrs(batch: RecordBatch) -> (i64, i64) {
    // Validate: we got exactly 100 rows and the buffers are compact
use arrow_array::{Array, RecordBatch, StringViewArray, StructArray};
// Helpers
static RT_INIT: OnceLock<()> = OnceLock::new();
    let plan = ctx
    let rc = unsafe {
    let stream_ptr = unsafe {
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
        .build()
        let sliced_view = sliced
    let substrait = to_substrait_plan(&plan, &ctx.state()).expect("to_substrait");
            .column(0)
        total_buffer_bytes < 10_000,
            substrait_bytes.as_ptr(),
    ptr: i64,
// Test
    }
 *
            break;
    }
        let buf_size: usize = col.data_buffers().iter().map(|b| b.len()).sum();
//! Regression test for `compact_string_view_columns` (api.rs line 459).
            .path()
            id_bytes.len() as i64,
            )
    _spill_dir: TempDir,
    });
//! right-sized (~3KB for 100 strings) rather than carrying the full 10K-element
    let id_bytes = input_id.as_bytes();
}
        let rc = unsafe { df_sender_send(sender_ptr, arr_ptr, sch_ptr) };
fn ensure_runtime_manager() {
        output_batches.push(batch);
            .enable_all()
        if rc == 0 {
    let substrait_bytes = {
 */
//! Exercises `df_stream_next` end-to-end with a sliced StringView batch.
        let rc = unsafe {
            id_bytes.as_ptr(),
        let spill_dir = TempDir::new().expect("tempdir");
}
    let producer = thread::spawn(move || {
    assert_eq!(total_rows, 100, "expected 100 rows, got {}", total_rows);
                false,
        .await
            unsafe { arrow_array::ffi::from_ffi(*ffi_array, &ffi_schema).expect("import") };
    df_close_global_runtime, df_close_local_session, df_create_global_runtime,
        // The sliced array still references the full backing buffers
        let full_buffer_size: usize = full_array.data_buffers().iter().map(|b| b.len()).sum();
    let total_rows: usize = output_batches.iter().map(|b| b.num_rows()).sum();
