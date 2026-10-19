        // SAFETY: `rc` is a `Box::into_raw(Box::new(FFI_ArrowArray))` ptr.
            ptr: rc,
    Arc::new(Schema::new(vec![Field::new(
    unsafe { df_close_local_session(session_ptr) };
            session_ptr,
    assert_eq!(
        .expect("register seed table");
        rc, SENDER_SEND_RECEIVER_DROPPED,
    let ctx = SessionContext::new();
impl Drop for RuntimeGuard {
    df_register_partition_stream, df_sender_close, df_sender_send, df_stream_close, df_stream_next,
        .sql("SELECT SUM(x) AS total FROM \"input-0\"")
    }
    assert_eq!(total, 45, "SUM(1..=9) should be 45, got {}", total);
    };
        assert!(rc >= 0, "df_stream_next rc={}", rc);
//! - `df_close_local_session` drops registered senders (receiver side of the
    // channel is now closed.
    rc
        let struct_array = StructArray::from(array_data);
        .expect("register input-0");
}
    let plan_bytes = rt.block_on(build_seed_substrait(input_id, Arc::new(schema.clone())));
            &mut out_len as *mut i64,
            assert_eq!(rc, 0, "df_sender_send rc={}", rc);
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
        "df_create_local_session returned {}",
    let schema = i64_schema("x");
    let schema_b = Schema::new(vec![Field::new("y", DataType::Int64, true)]);
    let empty = MemTable::try_new(Arc::clone(&schema), vec![vec![]]).expect("mem table");
        df_execute_local_plan(
    assert_eq!(rc_ok, 0, "pre-close send should succeed, rc={}", rc_ok);
/// Return code from `df_sender_send` when the consumer already dropped or
    let stream_ptr = unsafe {
    );
            FFI_ArrowSchema::try_from(result_schema.as_ref()).expect("result schema export");
        let spill_dir = TempDir::new().expect("tempdir");
use tempfile::TempDir;
//! - `df_sender_send` → execute → `df_stream_next` drains a `SUM` aggregate
    let sender_a = register_input(session_ptr, "input-0", &schema_a);
            .expect("i64 column");
/// Holds a DataFusionRuntime pointer and its backing temp dir so the spill
            let (arr_ptr, sch_ptr) = export_batch_ptrs(batch);
            true,
fn i64_batch(schema: &SchemaRef, values: &[i64]) -> RecordBatch {
        ensure_runtime_manager();
    // for correctness (mpsc is bounded and the producer drives its own
    RecordBatch::try_new(
// ---------------------------------------------------------------------------
//! The runtime manager (`df_init_runtime_manager`) is a process-global
            id_bytes.len() as i64,
        Self {
//!   mpsc closes), so a subsequent `df_sender_send` reports that sentinel
    // without waiting on a consumer.
        if rc == 0 {
#[test]
            .path()
    // not an error: the consumer finishing first is benign, so the sentinel
}
//! Integration tests for the coordinator-reduce FFM exports.
        assert!(rc > 0, "df_create_global_runtime returned {}", rc);
        }
use std::thread;
    let schema = i64_schema("x");
    unsafe { df_sender_close(sender_ptr) };
        // EOF — releases the sender, which closes the mpsc.
// ---------------------------------------------------------------------------
        "expected receiver-dropped sentinel, got rc={}",
        let rc = unsafe {
// One-time setup
                128 * 1024 * 1024,
    // Producer must start BEFORE `df_execute_local_plan`: the execute path
fn test_register_partition_exposes_streaming_table() {
    // Subsequent `df_sender_send` on the still-live sender pointer reports the
        .sql(&format!("SELECT * FROM \"{}\"", table))
    let runtime = RuntimeGuard::new();
}
        unsafe { df_sender_close(sender_ptr) };
        let result_schema = Arc::new(Schema::new(vec![Field::new(
    assert!(rc > 0, "df_register_partition_stream rc={}", rc);
    let mut buf = Vec::new();
    producer.join().expect("producer thread");
    use std::io::Cursor;
    let substrait = to_substrait_plan(&plan, &ctx.state()).expect("to_substrait");
    // receiver-dropped sentinel rather than a negative error code.
}
    ctx.register_table(table, Arc::new(empty))
    // block_on), but reduces interleaving surprises.
    let batch_ok = i64_batch(&schema, &[10]);
        column,
}
fn test_close_session_drops_registered_senders() {
const SENDER_SEND_RECEIVER_DROPPED: i64 = 1;
            let rc = unsafe { df_sender_send(sender_ptr, arr_ptr, sch_ptr) };
/// gracefully terminated the receiver. This is a benign outcome, not a
}
        df_register_partition_stream(
// Tests
//! - `df_create_local_session` / `df_close_local_session` lifecycle
    let runtime = RuntimeGuard::new();
    df_create_local_session, df_execute_local_plan, df_init_runtime_manager,
struct RuntimeGuard {
    // Drop the senders first so the mpsc receivers in the registered
            out_buf.len() as i64,
    // in the channel before the physical plan pulls from it. Not required
            .build()
fn register_input(session_ptr: i64, input_id: &str, schema: &Schema) -> i64 {
/// `NativeBridge.SENDER_SEND_RECEIVER_DROPPED` on the Java side; all three
            if !col.is_null(i) {
    unsafe { df_close_local_session(session_ptr) };
    assert!(session_ptr > 0);
//! the Java side calls through `NativeBridge`) and validate:
/// Build a Substrait plan for `SELECT SUM(x) AS total FROM "input-0"` using a
    unsafe { df_sender_close(sender_ptr) };
/// Returns `(array_ptr, schema_ptr)` as `i64` addresses. On successful
    let (a1, s1) = export_batch_ptrs(batch_dropped);
        };
        .expect("build tokio rt");
    let array_data = struct_array.into_data();
    let mut total: i64 = 0;
    // rides the success half of the contract.
            "total",
        .await
    assert!(session_ptr > 0);
    (*reader.schema()).clone()
    let plan = ctx
    let schema = i64_schema("x");
    let runtime = RuntimeGuard::new();
 */
/// ownership to the caller — mirrors what `DatafusionReduceSink.feed` will do
    // wide enough to buffer all three batches, so the producer finishes
    let batch_dropped = i64_batch(&schema, &[20]);
    // Sanity check: before session close, sending succeeds (the channel has
fn export_batch_ptrs(batch: RecordBatch) -> (i64, i64) {
//! - `df_register_partition_stream` exposes the input as a DataFusion table
            df_create_global_runtime(
/// table's schema by lowering this plan, so the inferred schema is identical
        let array_data =
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
/// failure, so it rides the success half of the FFM contract (`>= 0` success,
use datafusion::datasource::MemTable;
async fn build_seed_substrait(table: &str, schema: SchemaRef) -> Vec<u8> {
    let rc_dropped = unsafe { df_sender_send(sender_ptr, a1, s1) };
    let runtime = RuntimeGuard::new();
    });
/// throwaway session that only knows the schema — the plan is portable onto
                spill_bytes.len() as i64,
        .expect("sql parses")
}
        session_ptr > 0,
            substrait_bytes.len() as i64,
        derived.fields().len(),
use std::sync::{Arc, OnceLock};
            )
use std::time::Duration;
}
    let rc = unsafe {
//!
fn test_create_session_returns_nonzero_ptr() {
//!
        .await
    unsafe { df_close_local_session(session_ptr) };
    let ffi_array = FFI_ArrowArray::new(&array_data);
    (array_ptr, schema_ptr)
    let plan = ctx
        .clone();
    let rc_ok = unsafe { df_sender_send(sender_ptr, a0, s0) };
    let batch = i64_batch(&schema, &[1, 2, 3]);
/// Build a substrait `SELECT * FROM <table>` plan whose lowered output schema
    buf
    fn drop(&mut self) {
    RT_INIT.get_or_init(|| {
    let schema_a = Schema::new(vec![Field::new("x", DataType::Int64, false)]);
/// to the producer-side schema.
        .clone();
                spill_bytes.as_ptr(),
        for chunk in [vec![1i64, 2, 3], vec![4i64, 5, 6], vec![7i64, 8, 9]] {
    assert_eq!(
            }
    assert!(
        .build()
    unsafe { df_close_local_session(session_ptr) };
        )]));
    let struct_array: StructArray = batch.into();
            id_bytes.as_ptr(),
/// early-termination instead of throwing.
    let schema_ptr = Box::into_raw(Box::new(ffi_schema)) as i64;
fn ipc_bytes_to_schema(bytes: &[u8]) -> Schema {
#[test]
}
///
    let producer = thread::spawn(move || {
}
    thread::sleep(Duration::from_millis(10));
            .to_string();
            plan_bytes.len() as i64,
        let rt = tokio::runtime::Builder::new_current_thread()
        DataType::Int64,
// ---------------------------------------------------------------------------
            0, // context_id — not used in this test
    // `df_execute_local_plan` which runs `block_on` on the caller.
            break;
    let sender_ptr = register_input(session_ptr, "input-0", schema.as_ref());
    use arrow::ipc::reader::StreamReader;
// ---------------------------------------------------------------------------
        schema.fields().len(),
use arrow_array::{Array, Int64Array, RecordBatch, StructArray};
    substrait.encode(&mut buf).expect("encode");
    );
    };
//! - `df_sender_send` on a sender whose receiver is gone reports the
    unsafe { df_stream_close(stream_ptr) };
    let cursor = Cursor::new(bytes);
    let array_ptr = Box::into_raw(Box::new(ffi_array)) as i64;
    let rt = tokio::runtime::Builder::new_current_thread()
    buf
            .to_str()
        let col = batch
    assert!(session_ptr > 0);
fn test_execute_sum_substrait() {
        .logical_plan()
                total += col.value(i);
    assert_eq!(
use arrow_schema::{DataType, Field, Schema, SchemaRef};
            session_ptr,
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
    let derived = ipc_bytes_to_schema(&out_buf[..out_len as usize]);
    // Drop the session: its registered StreamingTable drops the
    // Sanity: derived schema matches the caller-provided one (column types).
    let ctx = SessionContext::new();
use arrow_array::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
    );
        vec![Arc::new(Int64Array::from(values.to_vec()))],
    let id_bytes = input_id.as_bytes();
    ptr: i64,
 * SPDX-License-Identifier: Apache-2.0
        false,
        )
    // Build the Substrait plan off-thread — we need it before calling
            unsafe { arrow_array::ffi::from_ffi(*ffi_array, &ffi_schema).expect("import") };
    let ffi_schema = FFI_ArrowSchema::try_from(schema.as_ref()).expect("schema export");
static RT_INIT: OnceLock<()> = OnceLock::new();
    // Give the producer a moment to start pushing so the first batches are
        "post-close send should report the receiver-dropped sentinel, got rc={}",
    // Sending now reports the receiver-dropped sentinel. This is deliberately
        session_ptr
    let sender_b = register_input(session_ptr, "input-1", &schema_b);
            .downcast_ref::<Int64Array>()
    )]))
}
        let spill_path = spill_dir
            let batch = i64_batch(&producer_schema, &chunk);
            .as_any()
}
    let reader = StreamReader::try_new(cursor, None).expect("stream reader builds");
        Arc::clone(schema),
            .expect("build tokio rt");
    // SingleReceiverPartition, which drops the mpsc receiver. The sender's
        rc
use opensearch_datafusion::ffm::{
            .column(0)
            substrait_bytes.as_ptr(),
/// Export a `RecordBatch` as (FFI_ArrowArray*, FFI_ArrowSchema*) and transfer
    ctx.register_table("input-0", Arc::new(empty))
/// Mirrors the private `SENDER_SEND_RECEIVER_DROPPED` in `src/ffm.rs` and
/// matches `schema`. `df_register_partition_stream` derives the registered
//!   `SENDER_SEND_RECEIVER_DROPPED` sentinel rather than failing
#[test]
    let empty = MemTable::try_new(Arc::clone(&schema), vec![vec![]]).expect("mem table");
// ---------------------------------------------------------------------------
    df_close_global_runtime, df_close_local_session, df_create_global_runtime,
            out_buf.as_mut_ptr(),
    unsafe { df_sender_close(sender_b) };
    assert!(session_ptr > 0);
    let sender_ptr = register_input(session_ptr, "input-0", schema.as_ref());
        }
    unsafe { df_sender_close(sender_a) };
            _spill_dir: spill_dir,
    // capacity 4 so one send does not block).
    unsafe { df_close_local_session(session_ptr) };
    let runtime = RuntimeGuard::new();
    let mut out_buf = vec![0u8; 64 * 1024];
}
        let ffi_schema =
#[test]
        )
        }
        // handful of small batches.
async fn build_sum_substrait(schema: SchemaRef) -> Vec<u8> {
}
    assert_ne!(sender_a, sender_b);
            DataType::Int64,
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
///
/// directory is removed when the test finishes.
/// `df_sender_send` the Rust side consumes both pointers via `from_raw`.
//! singleton, so we initialize it exactly once across all tests via a
#[test]
    // must drop it) or 0 for EOS.
        let rc = unsafe { df_stream_next(stream_ptr) };
//! These tests drive the `df_*` C ABI entry points directly (same symbols
    .expect("batch builds")
        let batch = RecordBatch::from(struct_array);
}
    loop {
    };
    )
    let substrait_bytes = {
// Helpers: IPC schema bytes, Arrow C Data export, error decoding
/// `< 0` negated error pointer) and the Java side latches it as
        rt.block_on(build_sum_substrait(Arc::clone(&schema)))
    );
                64 * 1024 * 1024,
fn test_sender_send_reports_receiver_dropped() {
            .enable_all()
    fn new() -> Self {
use datafusion_substrait::logical_plan::producer::to_substrait_plan;
    // blocks on `block_on(execute_substrait)` which may poll the streaming
        "derived schema field count mismatch"
impl RuntimeGuard {
    // pointer to a heap-allocated `FFI_ArrowArray` (caller owns it and
fn i64_schema(column: &str) -> SchemaRef {
//!
    // StreamingTables see EOF when the session is later dropped.
        .logical_plan()
    substrait.encode(&mut buf).expect("encode");
    let (arr_ptr, sch_ptr) = export_batch_ptrs(batch);
    // Close the session. The surviving sender's mpsc is now orphaned.
        rc_dropped, SENDER_SEND_RECEIVER_DROPPED,
use datafusion::prelude::SessionContext;
 * The OpenSearch Contributors require contributions made to
    });
// ---------------------------------------------------------------------------
    let substrait = to_substrait_plan(&plan, &ctx.state()).expect("to_substrait");
/*
/// Decode an IPC schema-only stream back to an arrow Schema.
/// any session where `"input-0"` has the same schema.
 * compatible open source license.
    assert!(stream_ptr > 0, "df_execute_local_plan rc={}", stream_ptr);
 *
        df_init_runtime_manager(1, 1.5, 1.5);
        .enable_all()
        let ffi_array = unsafe { Box::from_raw(rc as *mut FFI_ArrowArray) };
                0, // cache_manager_ptr — no custom cache for this test
    let producer_schema = Arc::clone(&schema);
/// must agree.
        // 128 MiB pool, 64 MiB spill cap — arbitrary; these tests push a
            plan_bytes.as_ptr(),
    let rc = unsafe { df_sender_send(sender_ptr, arr_ptr, sch_ptr) };
        let spill_bytes = spill_path.as_bytes();
/// on the Java side.
    // input during logical → physical planning. The channel capacity (4) is
    let schema = batch.schema();
 * this file be licensed under the Apache-2.0 license or a
    }
use prost::Message;
//! `OnceLock` guard.
        .expect("sql parses")
    let session_ptr = unsafe { df_create_local_session(runtime.ptr) };
    _spill_dir: TempDir,
        rc_dropped
            .expect("utf-8 spill path")
};
fn ensure_runtime_manager() {
    }
    let mut buf = Vec::new();
    let sender_ptr = register_input(session_ptr, "input-0", schema.as_ref());
    let (a0, s0) = export_batch_ptrs(batch_ok);
}
        unsafe { df_close_global_runtime(self.ptr) };
        for i in 0..col.len() {
        }
    // Drain the output stream. Each `df_stream_next` returns either a
    let mut out_len: i64 = 0;
