    );
    assert!(session_ptr > 0);
            .build()
    // block_on), but reduces interleaving surprises.
    }
}
    assert_eq!(
// ---------------------------------------------------------------------------
    // input during logical → physical planning. The channel capacity (4) is
    df_close_global_runtime, df_close_local_session, df_create_global_runtime,
    let rc = unsafe { df_sender_send(sender_ptr, arr_ptr, sch_ptr) };
struct RuntimeGuard {
use datafusion_substrait::logical_plan::producer::to_substrait_plan;
    let runtime = RuntimeGuard::new();
/*
    use std::io::Cursor;
            let (arr_ptr, sch_ptr) = export_batch_ptrs(batch);
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
                0, // cache_manager_ptr — no custom cache for this test
        derived.fields().len(),
    // Subsequent `df_sender_send` on the still-live sender pointer reports the
    assert_eq!(total, 45, "SUM(1..=9) should be 45, got {}", total);
/// `< 0` negated error pointer) and the Java side latches it as
    substrait.encode(&mut buf).expect("encode");
    (*reader.schema()).clone()
    unsafe { df_close_local_session(session_ptr) };
}
    // Close the session. The surviving sender's mpsc is now orphaned.
            }
        .expect("build tokio rt");
    ctx.register_table(table, Arc::new(empty))
    // Drain the output stream. Each `df_stream_next` returns either a
fn test_register_partition_exposes_streaming_table() {
            out_buf.len() as i64,
/// must agree.
fn ensure_runtime_manager() {
/// Mirrors the private `SENDER_SEND_RECEIVER_DROPPED` in `src/ffm.rs` and
        vec![Arc::new(Int64Array::from(values.to_vec()))],
    let (a1, s1) = export_batch_ptrs(batch_dropped);
    assert!(stream_ptr > 0, "df_execute_local_plan rc={}", stream_ptr);
    };
            substrait_bytes.len() as i64,
            .enable_all()
            .path()
        .await
//!   mpsc closes), so a subsequent `df_sender_send` reports that sentinel
    let rc_dropped = unsafe { df_sender_send(sender_ptr, a1, s1) };
    let rc_ok = unsafe { df_sender_send(sender_ptr, a0, s0) };
                128 * 1024 * 1024,
    // without waiting on a consumer.
    unsafe { df_close_local_session(session_ptr) };
    .expect("batch builds")
    let plan = ctx
            plan_bytes.as_ptr(),
    });
        let col = batch
            true,
    unsafe { df_sender_close(sender_a) };
        "df_create_local_session returned {}",
/// Export a `RecordBatch` as (FFI_ArrowArray*, FFI_ArrowSchema*) and transfer
#[test]
        for chunk in [vec![1i64, 2, 3], vec![4i64, 5, 6], vec![7i64, 8, 9]] {
//! Integration tests for the coordinator-reduce FFM exports.
fn i64_batch(schema: &SchemaRef, values: &[i64]) -> RecordBatch {
    // SingleReceiverPartition, which drops the mpsc receiver. The sender's
fn export_batch_ptrs(batch: RecordBatch) -> (i64, i64) {
    // Drop the senders first so the mpsc receivers in the registered
        false,
    // Sanity: derived schema matches the caller-provided one (column types).
use datafusion::prelude::SessionContext;
        session_ptr
                total += col.value(i);
//!   `SENDER_SEND_RECEIVER_DROPPED` sentinel rather than failing
//!
    unsafe { df_sender_close(sender_b) };
    }
    let substrait = to_substrait_plan(&plan, &ctx.state()).expect("to_substrait");
///
    let mut buf = Vec::new();
        DataType::Int64,
            let batch = i64_batch(&producer_schema, &chunk);
        // 128 MiB pool, 64 MiB spill cap — arbitrary; these tests push a
}
    assert!(session_ptr > 0);
        rc
    let runtime = RuntimeGuard::new();
/// Build a substrait `SELECT * FROM <table>` plan whose lowered output schema
/// Return code from `df_sender_send` when the consumer already dropped or
    let ctx = SessionContext::new();
            "total",
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
            let rc = unsafe { df_sender_send(sender_ptr, arr_ptr, sch_ptr) };
/// Decode an IPC schema-only stream back to an arrow Schema.
    let sender_b = register_input(session_ptr, "input-1", &schema_b);
        rc, SENDER_SEND_RECEIVER_DROPPED,
    let batch_ok = i64_batch(&schema, &[10]);
    // `df_execute_local_plan` which runs `block_on` on the caller.
    unsafe { df_sender_close(sender_ptr) };
/// Build a Substrait plan for `SELECT SUM(x) AS total FROM "input-0"` using a
            if !col.is_null(i) {
fn ipc_bytes_to_schema(bytes: &[u8]) -> Schema {
}
    unsafe { df_close_local_session(session_ptr) };
    let runtime = RuntimeGuard::new();
            out_buf.as_mut_ptr(),
            session_ptr,
    let cursor = Cursor::new(bytes);
                spill_bytes.len() as i64,
/// to the producer-side schema.
    let runtime = RuntimeGuard::new();
        if rc == 0 {
    let batch_dropped = i64_batch(&schema, &[20]);
//! the Java side calls through `NativeBridge`) and validate:
    // pointer to a heap-allocated `FFI_ArrowArray` (caller owns it and
    fn drop(&mut self) {
        let ffi_schema =
        .expect("sql parses")
    let schema = batch.schema();
//! - `df_sender_send` on a sender whose receiver is gone reports the
    // Drop the session: its registered StreamingTable drops the
    let sender_a = register_input(session_ptr, "input-0", &schema_a);
            substrait_bytes.as_ptr(),
    (array_ptr, schema_ptr)
async fn build_seed_substrait(table: &str, schema: SchemaRef) -> Vec<u8> {
//! - `df_close_local_session` drops registered senders (receiver side of the
    let empty = MemTable::try_new(Arc::clone(&schema), vec![vec![]]).expect("mem table");
impl Drop for RuntimeGuard {
use prost::Message;
                64 * 1024 * 1024,
    }
    // Sending now reports the receiver-dropped sentinel. This is deliberately
    )
                spill_bytes.as_ptr(),
    let sender_ptr = register_input(session_ptr, "input-0", schema.as_ref());
        "post-close send should report the receiver-dropped sentinel, got rc={}",
// ---------------------------------------------------------------------------
    assert_eq!(
//! - `df_register_partition_stream` exposes the input as a DataFusion table
}
    let rc = unsafe {
            &mut out_len as *mut i64,
    assert_eq!(
            unsafe { arrow_array::ffi::from_ffi(*ffi_array, &ffi_schema).expect("import") };
/// gracefully terminated the receiver. This is a benign outcome, not a
        .sql(&format!("SELECT * FROM \"{}\"", table))
}
    unsafe { df_close_local_session(session_ptr) };
    let struct_array: StructArray = batch.into();
        let batch = RecordBatch::from(struct_array);
/// throwaway session that only knows the schema — the plan is portable onto
// Tests
// Helpers: IPC schema bytes, Arrow C Data export, error decoding
        .await
        .expect("sql parses")
    let producer_schema = Arc::clone(&schema);
    let (arr_ptr, sch_ptr) = export_batch_ptrs(batch);
        .enable_all()
    // StreamingTables see EOF when the session is later dropped.
            .to_str()
 * this file be licensed under the Apache-2.0 license or a
    let reader = StreamReader::try_new(cursor, None).expect("stream reader builds");
static RT_INIT: OnceLock<()> = OnceLock::new();
/// Returns `(array_ptr, schema_ptr)` as `i64` addresses. On successful
    let (a0, s0) = export_batch_ptrs(batch_ok);
    thread::sleep(Duration::from_millis(10));
fn test_execute_sum_substrait() {
        )
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
    let substrait = to_substrait_plan(&plan, &ctx.state()).expect("to_substrait");
/// failure, so it rides the success half of the FFM contract (`>= 0` success,
    let mut out_buf = vec![0u8; 64 * 1024];
        .expect("register input-0");
        Self {
///
        ensure_runtime_manager();
    buf
    );
        let rt = tokio::runtime::Builder::new_current_thread()
            df_create_global_runtime(
        let struct_array = StructArray::from(array_data);
}
    producer.join().expect("producer thread");
 */
    let schema_a = Schema::new(vec![Field::new("x", DataType::Int64, false)]);
    assert_ne!(sender_a, sender_b);
        };
    assert_eq!(rc_ok, 0, "pre-close send should succeed, rc={}", rc_ok);
    rc
            .as_any()
    let runtime = RuntimeGuard::new();
// One-time setup
fn register_input(session_ptr: i64, input_id: &str, schema: &Schema) -> i64 {
fn test_close_session_drops_registered_senders() {
        df_init_runtime_manager(1, 1.5, 1.5);
            .column(0)
    assert!(rc > 0, "df_register_partition_stream rc={}", rc);
            .to_string();
use datafusion::datasource::MemTable;
    let mut out_len: i64 = 0;
    let schema = i64_schema("x");
    let ffi_array = FFI_ArrowArray::new(&array_data);
            )
        let spill_path = spill_dir
        assert!(rc >= 0, "df_stream_next rc={}", rc);
}
        }
    let array_data = struct_array.into_data();
    );
        }
        .clone();
 * compatible open source license.
    let sender_ptr = register_input(session_ptr, "input-0", schema.as_ref());
    let batch = i64_batch(&schema, &[1, 2, 3]);
    fn new() -> Self {
    };
        let rc = unsafe {
        "derived schema field count mismatch"
    let sender_ptr = register_input(session_ptr, "input-0", schema.as_ref());
// ---------------------------------------------------------------------------
            .expect("i64 column");
            assert_eq!(rc, 0, "df_sender_send rc={}", rc);
        let spill_bytes = spill_path.as_bytes();
async fn build_sum_substrait(schema: SchemaRef) -> Vec<u8> {
//! singleton, so we initialize it exactly once across all tests via a
        for i in 0..col.len() {
    });
        "expected receiver-dropped sentinel, got rc={}",
use arrow_array::{Array, Int64Array, RecordBatch, StructArray};
/// Holds a DataFusionRuntime pointer and its backing temp dir so the spill
//! - `df_create_local_session` / `df_close_local_session` lifecycle
    let schema = i64_schema("x");
};
            .expect("utf-8 spill path")
        // SAFETY: `rc` is a `Box::into_raw(Box::new(FFI_ArrowArray))` ptr.
            DataType::Int64,
use arrow_schema::{DataType, Field, Schema, SchemaRef};
}
    // rides the success half of the contract.
fn i64_schema(column: &str) -> SchemaRef {
        Arc::clone(schema),
            _spill_dir: spill_dir,
    use arrow::ipc::reader::StreamReader;
/// directory is removed when the test finishes.
    assert!(session_ptr > 0);
    assert!(session_ptr > 0);
#[test]
        rt.block_on(build_sum_substrait(Arc::clone(&schema)))
    let id_bytes = input_id.as_bytes();
    df_register_partition_stream, df_sender_close, df_sender_send, df_stream_close, df_stream_next,
        .logical_plan()
//!
}
    // not an error: the consumer finishing first is benign, so the sentinel
        schema.fields().len(),
/// table's schema by lowering this plan, so the inferred schema is identical
            .expect("build tokio rt");
    let plan = ctx
//! These tests drive the `df_*` C ABI entry points directly (same symbols
    df_create_local_session, df_execute_local_plan, df_init_runtime_manager,
    _spill_dir: TempDir,
/// `NativeBridge.SENDER_SEND_RECEIVER_DROPPED` on the Java side; all three
}
}
            0, // context_id — not used in this test
        session_ptr > 0,
        rc_dropped, SENDER_SEND_RECEIVER_DROPPED,
    let derived = ipc_bytes_to_schema(&out_buf[..out_len as usize]);
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
    unsafe { df_close_local_session(session_ptr) };
    RecordBatch::try_new(
use opensearch_datafusion::ffm::{
    // for correctness (mpsc is bounded and the producer drives its own
const SENDER_SEND_RECEIVER_DROPPED: i64 = 1;
fn test_sender_send_reports_receiver_dropped() {
    let mut buf = Vec::new();
use std::sync::{Arc, OnceLock};
        df_register_partition_stream(
#[test]
            plan_bytes.len() as i64,
        .logical_plan()
#[test]
/// early-termination instead of throwing.
}
 * The OpenSearch Contributors require contributions made to
// ---------------------------------------------------------------------------
    let schema = i64_schema("x");
}
    let substrait_bytes = {
#[test]
        )
        column,
        .clone();
            break;
        let result_schema = Arc::new(Schema::new(vec![Field::new(
    unsafe { df_stream_close(stream_ptr) };
use arrow_array::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
    let rt = tokio::runtime::Builder::new_current_thread()
    // Give the producer a moment to start pushing so the first batches are
/// any session where `"input-0"` has the same schema.
    let plan_bytes = rt.block_on(build_seed_substrait(input_id, Arc::new(schema.clone())));
        .expect("register seed table");
    // capacity 4 so one send does not block).
        let rc = unsafe { df_stream_next(stream_ptr) };
        unsafe { df_sender_close(sender_ptr) };
        assert!(rc > 0, "df_create_global_runtime returned {}", rc);
        }
        // EOF — releases the sender, which closes the mpsc.
        let ffi_array = unsafe { Box::from_raw(rc as *mut FFI_ArrowArray) };
//! The runtime manager (`df_init_runtime_manager`) is a process-global
    substrait.encode(&mut buf).expect("encode");
// ---------------------------------------------------------------------------
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
use std::time::Duration;
/// ownership to the caller — mirrors what `DatafusionReduceSink.feed` will do
            FFI_ArrowSchema::try_from(result_schema.as_ref()).expect("result schema export");
    ctx.register_table("input-0", Arc::new(empty))
    // Producer must start BEFORE `df_execute_local_plan`: the execute path
    RT_INIT.get_or_init(|| {
        .build()
use std::thread;
    ptr: i64,
            ptr: rc,
    unsafe { df_sender_close(sender_ptr) };
use tempfile::TempDir;
//! `OnceLock` guard.
    Arc::new(Schema::new(vec![Field::new(
    );
        }
    let schema_b = Schema::new(vec![Field::new("y", DataType::Int64, true)]);
        // handful of small batches.
        let array_data =
    let producer = thread::spawn(move || {
/// `df_sender_send` the Rust side consumes both pointers via `from_raw`.
        df_execute_local_plan(
    // wide enough to buffer all three batches, so the producer finishes
    )]))
// ---------------------------------------------------------------------------
//! - `df_sender_send` → execute → `df_stream_next` drains a `SUM` aggregate
    // Build the Substrait plan off-thread — we need it before calling
        )]));
    };
    assert!(
 *
    buf
    // Sanity check: before session close, sending succeeds (the channel has
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).expect("schema export");
}
    // receiver-dropped sentinel rather than a negative error code.
    // blocks on `block_on(execute_substrait)` which may poll the streaming
fn test_create_session_returns_nonzero_ptr() {
        rc_dropped
            id_bytes.len() as i64,
}
    loop {
/// on the Java side.
    // in the channel before the physical plan pulls from it. Not required
    // must drop it) or 0 for EOS.
        .sql("SELECT SUM(x) AS total FROM \"input-0\"")
            .downcast_ref::<Int64Array>()
        let spill_dir = TempDir::new().expect("tempdir");
    // channel is now closed.
/// matches `schema`. `df_register_partition_stream` derives the registered
impl RuntimeGuard {
    let stream_ptr = unsafe {
 * SPDX-License-Identifier: Apache-2.0
    let empty = MemTable::try_new(Arc::clone(&schema), vec![vec![]]).expect("mem table");
//!
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
    let ctx = SessionContext::new();
        unsafe { df_close_global_runtime(self.ptr) };
            id_bytes.as_ptr(),
            session_ptr,
    let mut total: i64 = 0;
