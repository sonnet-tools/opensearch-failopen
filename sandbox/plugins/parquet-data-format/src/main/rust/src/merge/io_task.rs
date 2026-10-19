    });
                    }
pub type MergeWriter = CrcWriter<RateLimitedWriter<File>>;
                        log_info!(
            ))));
                        let metadata = w.close().map_err(MergeError::from)?;
                            }
                        for chunk in chunks {
                                let msg = format!("{e}");
                            crc32
// =============================================================================
            .build()
                    let _ = match result {
use rayon::ThreadPool;
 * compatible open source license.
                        }
pub(crate) static MERGE_POOL: OnceLock<ThreadPool> = OnceLock::new();
pub const RATE_LIMIT_MB_PER_SEC: f64 = 20.0;
    Close(oneshot::Sender<MergeResult<(ParquetMetaData, u32)>>),
                        .await;
    })
    writer: SerializedFileWriter<MergeWriter>,
                            Ok(Err(e)) => {
// =============================================================================
        rayon::ThreadPoolBuilder::new()
    })
            let _ = reply.send(Err(MergeError::Logic(format!(
 */
fn get_io_runtime(num_threads: Option<usize>) -> &'static Runtime {
            .build()
                                return;
            .thread_name("parquet-io")
                            }
                            format!("Close panicked: {e}"),
 *
        .unwrap_or(1)
pub(crate) static IO_RUNTIME: OnceLock<Runtime> = OnceLock::new();
use parquet::file::writer::SerializedFileWriter;
// =============================================================================
// =============================================================================
                    let crc = crc_handle.clone();
/// Writer type used by the IO task: CRC → rate-limit → file.
                                drain_on_error(&mut rx, &msg).await;
// IO task protocol
/// Commands sent from the merge loop to the background IO task.
                                let _ = reply.send(Err(MergeError::Logic(
                            metadata.file_metadata().num_rows(),
                        rg_writer.close()?;
/// The IO task owns the `SerializedFileWriter` and receives encoded row groups
use super::error::{MergeError, MergeResult};
                        Ok(r) => reply.send(r),
const IO_CHANNEL_BUFFER: usize = 2;
                    let result = tokio::task::spawn_blocking(move || {
        let n = num_threads.unwrap_or_else(default_merge_threads);
// =============================================================================
    IO_RUNTIME.get_or_init(|| {
                            metadata.file_metadata().created_by(),
    tx
    get_io_runtime(io_threads).spawn(async move {
        let mut writer: Option<SerializedFileWriter<MergeWriter>> = Some(writer);
                        }
 * SPDX-License-Identifier: Apache-2.0
                }
                                let _ = reply.send(Err(e));
}
                            Err(e) => {
            }
                        let mut rg_writer = w.next_row_group()?;
                        Err(e) => reply.send(Err(MergeError::Logic(
                                let msg = format!("{e}");
                                log_error!("[RUST] IO spawn_blocking panicked during merge: {}", e);
                            chunk.append_to_row_group(&mut rg_writer)?;
}
                                return;
                        Ok((metadata, crc32))
        let mut in_flight: Option<
                    }));
            JoinHandle<MergeResult<SerializedFileWriter<MergeWriter>>>,
use std::fs::File;
                        match handle.await {
        if let IoCommand::Close(reply) = cmd {
                        ))),
        .map(|n| n.get() / 8)
use tokio::task::JoinHandle;
                                log_error!("[RUST] IO write error during merge: {}", e);
    io_threads: Option<usize>,
                        match handle.await {
use native_bridge_common::log_info;
                    in_flight = Some(tokio::task::spawn_blocking(move || {
                    })
                "Prior IO write failed: {msg}"
pub enum IoCommand {
    while let Some(cmd) = rx.recv().await {
use tokio::sync::{mpsc as tokio_mpsc, oneshot};
    let (tx, mut rx) = tokio_mpsc::channel::<IoCommand>(IO_CHANNEL_BUFFER);
async fn drain_on_error(rx: &mut tokio_mpsc::Receiver<IoCommand>, msg: &str) {
/// Default thread count for merge pools: max(1, num_cpus / 8).
/// Bounded channel capacity between the merge loop and the IO task.
            .enable_all()
                    let w = writer.take().unwrap();
use parquet::file::metadata::ParquetMetaData;
use crate::rate_limited_writer::RateLimitedWriter;
                IoCommand::Close(reply) => {
 * The OpenSearch Contributors require contributions made to
            .worker_threads(n)
    crc_handle: crate::crc_writer::CrcHandle,
/// Spawns the background IO task on the shared Tokio runtime.
        > = None;
/// the next row group while the current one is still being flushed to disk.
                                drain_on_error(&mut rx, &msg).await;
                    return;
                    };
// =============================================================================
                    let w = writer.take().unwrap();
                        }
///
fn default_merge_threads() -> usize {
// Process-wide shared Tokio runtime for async IO
/// Disk write rate limit in MB/s.
        .max(1)
}
                    if let Some(handle) = in_flight.take() {
                            Ok(Ok(w)) => writer = Some(w),
            .thread_name(|idx| format!("parquet-merge-{}", idx))
/*
            .expect("Failed to build parquet-merge Rayon thread pool")
}
                }
    MERGE_POOL.get_or_init(|| {
pub fn get_merge_pool(num_threads: Option<usize>) -> &'static ThreadPool {
// Constants
}
                            Ok(Ok(w)) => writer = Some(w),
                            metadata.file_metadata().version(),
                        let crc32 = crc.crc32();
                    }
) -> tokio_mpsc::Sender<IoCommand> {
        }
                        );
    std::thread::available_parallelism()
                                return;
use tokio::runtime::Runtime;
        }
/// over a bounded channel. Each disk write is dispatched to `spawn_blocking`
                            }
                            "[RUST] IO task close: version={}, num_rows={}, created_by={:?}, crc32={:#010x}",
        tokio::runtime::Builder::new_multi_thread()
use std::sync::OnceLock;
                        Ok(w)
 * this file be licensed under the Apache-2.0 license or a
pub fn spawn_io_task(
    }
use crate::log_error;
                                return;
                IoCommand::WriteRowGroup(chunks) => {
// =============================================================================
                                    format!("IO panic during final write: {e}"),
use crate::crc_writer::CrcWriter;
                    if let Some(handle) = in_flight.take() {
            match cmd {
                            Ok(Err(e)) => {
                                )));
                        let mut w = w;
// Process-wide shared Rayon thread pool
        while let Some(cmd) = rx.recv().await {
            .expect("Failed to build tokio IO runtime")
/// but is **not** awaited immediately — this allows the merge loop to prepare
    WriteRowGroup(Vec<parquet::arrow::arrow_writer::ArrowColumnChunk>),
// =============================================================================
}
                            }
            .num_threads(n)
        let n = num_threads.unwrap_or_else(default_merge_threads);
                            Err(e) => {
