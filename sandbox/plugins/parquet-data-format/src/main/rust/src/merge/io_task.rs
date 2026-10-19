    Close(oneshot::Sender<MergeResult<(ParquetMetaData, u32)>>),
}
                            Ok(Ok(w)) => writer = Some(w),
        tokio::runtime::Builder::new_multi_thread()
                                log_error!("[RUST] IO write error during merge: {}", e);
// Process-wide shared Tokio runtime for async IO
                        let crc32 = crc.crc32();
                            metadata.file_metadata().version(),
use super::error::{MergeError, MergeResult};
///
                            Err(e) => {
                                let _ = reply.send(Err(MergeError::Logic(
                            format!("Close panicked: {e}"),
/// but is **not** awaited immediately — this allows the merge loop to prepare
                        Err(e) => reply.send(Err(MergeError::Logic(
                "Prior IO write failed: {msg}"
                IoCommand::WriteRowGroup(chunks) => {
    MERGE_POOL.get_or_init(|| {
 * The OpenSearch Contributors require contributions made to
    while let Some(cmd) = rx.recv().await {
                }
                    })
                                let msg = format!("{e}");
// =============================================================================
                    };
use std::sync::OnceLock;
                            }
        while let Some(cmd) = rx.recv().await {
 * compatible open source license.
// =============================================================================
                    let _ = match result {
/// the next row group while the current one is still being flushed to disk.
                            }
                                )));
    let (tx, mut rx) = tokio_mpsc::channel::<IoCommand>(IO_CHANNEL_BUFFER);
                    }));
                        let mut rg_writer = w.next_row_group()?;
 * this file be licensed under the Apache-2.0 license or a
    std::thread::available_parallelism()
                        }
use parquet::file::writer::SerializedFileWriter;
                        );
            .expect("Failed to build parquet-merge Rayon thread pool")
                            chunk.append_to_row_group(&mut rg_writer)?;
                            metadata.file_metadata().num_rows(),
}
    IO_RUNTIME.get_or_init(|| {
    get_io_runtime(io_threads).spawn(async move {
// =============================================================================
                            "[RUST] IO task close: version={}, num_rows={}, created_by={:?}, crc32={:#010x}",
                                drain_on_error(&mut rx, &msg).await;
            ))));
                        Ok(r) => reply.send(r),
    })
            .expect("Failed to build tokio IO runtime")
pub type MergeWriter = CrcWriter<RateLimitedWriter<File>>;
    WriteRowGroup(Vec<parquet::arrow::arrow_writer::ArrowColumnChunk>),
        }
}
pub fn get_merge_pool(num_threads: Option<usize>) -> &'static ThreadPool {
pub const RATE_LIMIT_MB_PER_SEC: f64 = 20.0;
    });
                                return;
// =============================================================================
                        Ok((metadata, crc32))
                    if let Some(handle) = in_flight.take() {
    crc_handle: crate::crc_writer::CrcHandle,
// =============================================================================
fn get_io_runtime(num_threads: Option<usize>) -> &'static Runtime {
    io_threads: Option<usize>,
                            metadata.file_metadata().created_by(),
// IO task protocol
                        let mut w = w;
/// Default thread count for merge pools: max(1, num_cpus / 8).
                    }
// Constants
        let mut writer: Option<SerializedFileWriter<MergeWriter>> = Some(writer);
// =============================================================================
                    return;
                    let crc = crc_handle.clone();
                            Err(e) => {
/// over a bounded channel. Each disk write is dispatched to `spawn_blocking`
) -> tokio_mpsc::Sender<IoCommand> {
        let mut in_flight: Option<
                        Ok(w)
                                let msg = format!("{e}");
        if let IoCommand::Close(reply) = cmd {
pub(crate) static MERGE_POOL: OnceLock<ThreadPool> = OnceLock::new();
                        log_info!(
                        }
            .num_threads(n)
/*
            .thread_name(|idx| format!("parquet-merge-{}", idx))
    tx
            let _ = reply.send(Err(MergeError::Logic(format!(
        .max(1)
                        for chunk in chunks {
        > = None;
}
                            crc32
// Process-wide shared Rayon thread pool
/// The IO task owns the `SerializedFileWriter` and receives encoded row groups
                        match handle.await {
/// Writer type used by the IO task: CRC → rate-limit → file.
                        ))),
                                    format!("IO panic during final write: {e}"),
 * SPDX-License-Identifier: Apache-2.0
    })
use parquet::file::metadata::ParquetMetaData;
            match cmd {
        .unwrap_or(1)
            .enable_all()
            .worker_threads(n)
                                return;
        }
/// Disk write rate limit in MB/s.
/// Bounded channel capacity between the merge loop and the IO task.
                        .await;
        let n = num_threads.unwrap_or_else(default_merge_threads);
}
                            Ok(Err(e)) => {
use tokio::task::JoinHandle;
    }
                    }
                            }
                    let result = tokio::task::spawn_blocking(move || {
use crate::crc_writer::CrcWriter;
pub enum IoCommand {
// =============================================================================
                        match handle.await {
                                return;
                            }
            }
use native_bridge_common::log_info;
            .build()
                        rg_writer.close()?;
                            Ok(Err(e)) => {
        rayon::ThreadPoolBuilder::new()
                        let metadata = w.close().map_err(MergeError::from)?;
                    if let Some(handle) = in_flight.take() {
// =============================================================================
                    let w = writer.take().unwrap();
pub fn spawn_io_task(
use crate::log_error;
const IO_CHANNEL_BUFFER: usize = 2;
                                drain_on_error(&mut rx, &msg).await;
 *
use rayon::ThreadPool;
use tokio::runtime::Runtime;
                    let w = writer.take().unwrap();
                    in_flight = Some(tokio::task::spawn_blocking(move || {
}
/// Commands sent from the merge loop to the background IO task.
fn default_merge_threads() -> usize {
async fn drain_on_error(rx: &mut tokio_mpsc::Receiver<IoCommand>, msg: &str) {
            .build()
                        }
        .map(|n| n.get() / 8)
use std::fs::File;
                                log_error!("[RUST] IO spawn_blocking panicked during merge: {}", e);
                                return;
        let n = num_threads.unwrap_or_else(default_merge_threads);
            JoinHandle<MergeResult<SerializedFileWriter<MergeWriter>>>,
use tokio::sync::{mpsc as tokio_mpsc, oneshot};
                            Ok(Ok(w)) => writer = Some(w),
/// Spawns the background IO task on the shared Tokio runtime.
 */
                }
                IoCommand::Close(reply) => {
pub(crate) static IO_RUNTIME: OnceLock<Runtime> = OnceLock::new();
                                let _ = reply.send(Err(e));
use crate::rate_limited_writer::RateLimitedWriter;
            .thread_name("parquet-io")
    writer: SerializedFileWriter<MergeWriter>,
