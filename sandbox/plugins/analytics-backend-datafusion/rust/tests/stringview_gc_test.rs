        df_register_partition_stream(
    // 100 strings of ~30 bytes each = ~3KB of actual data.
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
        assert!(rc >= 0, "df_stream_next rc={}", rc);
    )]))
            .downcast_ref::<StringViewArray>()
            out_buf.len() as i64,
    df_create_local_session, df_execute_local_plan, df_init_runtime_manager,
            unsafe { arrow_array::ffi::from_ffi(*ffi_array, &ffi_schema).expect("import") };
    _spill_dir: TempDir,
 *
            sliced_buffer_size > 200_000,
            df_create_global_runtime(
    });
}
fn ensure_runtime_manager() {
            false,
        df_init_runtime_manager(1, 1.5, 1.5);
}
            .expect("utf-8 spill path")
    fn new() -> Self {
            "full array buffer size should be >200KB, got {}",
            id_bytes.len() as i64,
        // Verify the full array has substantial backing buffers
        let (arr_ptr, sch_ptr) = export_batch_ptrs(batch);
    let struct_array: StructArray = batch.into();
    assert!(
}
struct RuntimeGuard {
        total_buffer_bytes += buf_size;
}
        assert!(rc > 0, "df_create_global_runtime returned {}", rc);
        )
    };
fn register_input(session_ptr: i64, input_id: &str, schema: &Schema) -> i64 {
            sliced_buffer_size
    assert!(rc > 0, "df_register_partition_stream rc={}", rc);
use arrow_array::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
use std::sync::{Arc, OnceLock};
    df_register_partition_stream, df_sender_close, df_sender_send, df_stream_close, df_stream_next,
    let plan = ctx
    let runtime = RuntimeGuard::new();
            plan_bytes.as_ptr(),
        };
}
//! Regression test for `compact_string_view_columns` (api.rs line 459).
// Helpers
        let col = batch
static RT_INIT: OnceLock<()> = OnceLock::new();
        let batch = RecordBatch::try_new(
            )
        let sliced_view = sliced
use datafusion::datasource::MemTable;
    let producer = thread::spawn(move || {
    let ctx = SessionContext::new();
            .expect("build tokio rt");
    rc
        assert_eq!(rc, 0, "df_sender_send rc={}", rc);
            id_bytes.as_ptr(),
    let stream_ptr = unsafe {
    df_close_global_runtime, df_close_local_session, df_create_global_runtime,
        let ffi_array = unsafe { Box::from_raw(rc as *mut FFI_ArrowArray) };
            full_buffer_size
    };
    let array_data = struct_array.into_data();
        let sliced = full_array.slice(100, 100);
    // Each string is ~30 bytes so the full array backing is ~300KB.
    let mut buf = Vec::new();
        assert!(
        .enable_all()
            .enable_all()
    }
    // Without compaction: buffers would be >200KB (full 10K-element backing).
        );
    assert!(session_ptr > 0);
        .expect("sql parses")
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
        )]));
                128 * 1024 * 1024,
    // Build a substrait plan for passthrough SELECT
            .expect("still a StringViewArray");
// One-time setup (same OnceLock pattern as local_exec_test.rs)
        df_execute_local_plan(
            0, // context_id
    // Validate: we got exactly 100 rows and the buffers are compact
        let struct_array = StructArray::from(array_data);
    (array_ptr, schema_ptr)
        .clone();
    // Drain the output and check buffer sizes
    let plan_bytes = rt.block_on(build_passthrough_substrait(Arc::new(schema.clone())));
            FFI_ArrowSchema::try_from(result_schema.as_ref()).expect("result schema export");
            )])),
        .expect("batch from sliced array");
    // The sliced batch only references 100 strings (~3KB of actual data).
// ---------------------------------------------------------------------------
//! right-sized (~3KB for 100 strings) rather than carrying the full 10K-element
                0,
    let ffi_array = FFI_ArrowArray::new(&array_data);
    let schema = utf8view_schema();
    }
        let full_buffer_size: usize = full_array.data_buffers().iter().map(|b| b.len()).sum();
        let spill_bytes = spill_path.as_bytes();
        let rc = unsafe {
        unsafe { df_sender_close(sender_ptr) };
// ---------------------------------------------------------------------------
        let result_schema = Arc::new(Schema::new(vec![Field::new(
// ---------------------------------------------------------------------------
        unsafe { df_close_global_runtime(self.ptr) };
#[test]
    // With compaction (line 459 active): buffers should be <= 10KB (generous margin).
fn export_batch_ptrs(batch: RecordBatch) -> (i64, i64) {
        let rc = unsafe { df_stream_next(stream_ptr) };
            .path()
use arrow_schema::{DataType, Field, Schema, SchemaRef};
//!
        if rc == 0 {
        "s",
        Self {
        let full_strings: Vec<String> = (0..10_000)
    let substrait_bytes = {
 */
    RT_INIT.get_or_init(|| {
        )
        let sliced_buffer_size: usize = sliced_view.data_buffers().iter().map(|b| b.len()).sum();
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).expect("schema export");
 * SPDX-License-Identifier: Apache-2.0
use datafusion_substrait::logical_plan::producer::to_substrait_plan;
        assert!(
}
    let sender_ptr = register_input(session_ptr, "input-0", schema.as_ref());
async fn build_passthrough_substrait(schema: SchemaRef) -> Vec<u8> {
        )
    let empty = MemTable::try_new(Arc::clone(&schema), vec![vec![]]).expect("mem table");
    Arc::new(Schema::new(vec![Field::new(
        // The sliced array still references the full backing buffers
    let mut out_len: i64 = 0;
 * this file be licensed under the Apache-2.0 license or a
            .to_string();
    for batch in &output_batches {
        ensure_runtime_manager();
    });
    );
            substrait_bytes.as_ptr(),
            plan_bytes.len() as i64,
    let rc = unsafe {
        let array_data =
    unsafe { df_stream_close(stream_ptr) };
            full_buffer_size > 200_000,
 * The OpenSearch Contributors require contributions made to
                spill_bytes.len() as i64,
    // Create a 10K-element StringViewArray, then slice to 100 rows.
        rt.block_on(build_passthrough_substrait(Arc::clone(&schema)))
        .await
    let mut out_buf = vec![0u8; 64 * 1024];
use arrow_array::{Array, RecordBatch, StringViewArray, StructArray};
            substrait_bytes.len() as i64,
        let buf_size: usize = col.data_buffers().iter().map(|b| b.len()).sum();
//! Exercises `df_stream_next` end-to-end with a sliced StringView batch.
    let substrait = to_substrait_plan(&plan, &ctx.state()).expect("to_substrait");
            &mut out_len as *mut i64,
    let rt = tokio::runtime::Builder::new_current_thread()
use tempfile::TempDir;
        // Slice to rows [100..200] — only 100 elements
            .expect("Utf8View column");
fn test_stringview_gc_on_sliced_batch() {
                spill_bytes.as_ptr(),
            "sliced array should still carry full buffers before GC, got {}",
            out_buf.as_mut_ptr(),
    ptr: i64,
            .collect();
            session_ptr,
    substrait.encode(&mut buf).expect("encode");
                false,
        false,
use datafusion::prelude::SessionContext;
        .expect("register input-0");
            .column(0)
use std::thread;
// ---------------------------------------------------------------------------
        DataType::Utf8View,
// ---------------------------------------------------------------------------
                64 * 1024 * 1024,
            vec![Arc::new(sliced)],
use prost::Message;
            .downcast_ref::<StringViewArray>()
    unsafe { df_close_local_session(session_ptr) };
        }
/*
            .build()
impl RuntimeGuard {
 * compatible open source license.
         This indicates compact_string_view_columns is not working.",
        }
    };
        let spill_dir = TempDir::new().expect("tempdir");
    let total_rows: usize = output_batches.iter().map(|b| b.num_rows()).sum();
        let rc = unsafe { df_sender_send(sender_ptr, arr_ptr, sch_ptr) };
    producer.join().expect("producer thread");
impl Drop for RuntimeGuard {
            .as_any()
        let rt = tokio::runtime::Builder::new_current_thread()
            Arc::new(Schema::new(vec![Field::new(
            DataType::Utf8View,
        "StringView buffers should be compacted to ~3KB, but got {} bytes. \
}
//! When compaction is active, the output batch's backing buffers should be
        let batch = RecordBatch::from(struct_array);
        let full_array = StringViewArray::from_iter_values(full_strings.iter().map(|s| s.as_str()));
}
                DataType::Utf8View,
            ptr: rc,
            session_ptr,
    buf
// ---------------------------------------------------------------------------
    }
    let id_bytes = input_id.as_bytes();
    loop {
        output_batches.push(batch);
            .to_str()
            break;
    }
        .build()
    fn drop(&mut self) {
};
            .as_any()
    assert_eq!(total_rows, 100, "expected 100 rows, got {}", total_rows);
    let schema = batch.schema();
        .expect("build tokio rt");
            _spill_dir: spill_dir,
        let spill_path = spill_dir
        .sql("SELECT * FROM \"input-0\"")
                "s",
        .logical_plan()
        total_buffer_bytes < 10_000,
        );
/// Build a substrait plan for `SELECT * FROM "input-0"` with the given schema.
//! buffer (~300KB).
    ctx.register_table("input-0", Arc::new(empty))
        total_buffer_bytes
    let mut output_batches: Vec<RecordBatch> = Vec::new();
use opensearch_datafusion::ffm::{
            "s",
fn utf8view_schema() -> SchemaRef {
    let mut total_buffer_bytes: usize = 0;
            .map(|i| format!("string-value-padding-{:010}", i))
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    assert!(stream_ptr > 0, "df_execute_local_plan rc={}", stream_ptr);
}
// Test
        let ffi_schema =
