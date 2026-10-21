        }
        // Parallel close: each column writer encodes and compresses its buffered
            self.reservation
    /// Close current column writers in parallel (encode + compress), send the
            .ok_or_else(|| MergeError::Logic("Column writers not initialized".into()))?;
            Result<parquet::arrow::arrow_writer::ArrowColumnChunk, parquet::errors::ParquetError>,
use native_bridge_common::memory_pool::MemoryReservation;
            return Err(e.into());
    // Java side (see NativeParquetMergeStrategy + ParquetShardStatsTracker).
        })
        // Track with_id batch (transient — alive during column write)
    // Per-merge counters returned via `finish()` and forwarded to the per-shard tracker on the
                "Failed to compute union schema across input files: {}",
 * this file be licensed under the Apache-2.0 license or a
        }
            self.reservation
                col_writers
        })?;
                    parent.display()
    /// Writes a batch directly to column writers and triggers a row group flush
    output_flush_rows: usize,
    data_schema: Arc<ArrowSchema>,
        self.flush_and_sort_chunk_time_millis += flush_start.elapsed().as_millis() as i64;
            .iter()
        Ok(())
        index_name: &str,
            output_row_count: 0,
pub struct MergeContext {
        self.output_row_count += num_rows;
        self.reservation.shrink(self.tracked_writer_bytes);
                .grow(actual_writer_bytes - self.tracked_writer_bytes);
    }
        let (metadata, crc32) = reply_rx
            .map_err(|_| MergeError::Logic("IO task terminated before close".into()))?;
        let num_rows = batch.num_rows();
            flush_and_sort_chunk_count: flush_count,
        // pages. This is the CPU-heavy step and benefits from rayon parallelism.
        let writer = SerializedFileWriter::new(crc_writer, parquet_root, writer_props)?;
        let with_id = append_row_id(&batch, self.next_row_id, &self.output_schema)?;
    /// row group.
                return Err(MergeError::Logic(format!(
        self.flush_and_sort_chunk_count += 1;
        let writer_props = Arc::new(
                    "Output directory '{}' does not exist.",
            })?,
            "[RUST] Flushed row group {}: {} rows (total: {})",
        // Column writers closed via close() — release tracked writer memory
        &self.data_schema
    pub fn finish(mut self) -> MergeResult<MergeFinishStats> {
use crate::writer_properties_builder::WriterPropertiesBuilder;
    /// ever live at a time.
/// Result returned from `MergeContext::finish()`.
            )
        self.io_tx
            .blocking_send(IoCommand::WriteRowGroup(encoded_chunks))
        let (reply_tx, reply_rx) =
        log_debug!(
        // across columns via rayon. Each column writer encodes independently.
            oneshot::channel::<MergeResult<(parquet::file::metadata::ParquetMetaData, u32)>>();
        self.row_group_index += 1;
 * compatible open source license.
            .as_mut()
        self.output_row_count = 0;
            self.row_group_index - 1,
        }
        Ok(Self {
        let final_row_id_max = self.next_row_id;
            ROW_ID_COLUMN_NAME,
/// Owns all shared state for a merge operation: schemas, writer factory,
use arrow::datatypes::{DataType as ArrowDataType, Field as ArrowField, Schema as ArrowSchema};
pub struct MergeFinishStats {
    /// immediately — no buffering — so only one batch's decoded data (~64 MB) is
        io_threads: Option<usize>,
 * SPDX-License-Identifier: Apache-2.0
        let col_writers = rg_writer_factory.create_column_writers(0)?;
        let actual_writer_bytes: usize = col_writers.iter().map(|w| w.memory_size()).sum();
        if self.output_row_count == 0 {
            next_row_id: 0,
        if actual_writer_bytes > self.tracked_writer_bytes {
            output_flush_rows,
        });
    col_writers: Option<Vec<parquet::arrow::arrow_writer::ArrowColumnWriter>>,
        for r in chunk_results {
    io_tx: tokio_mpsc::Sender<IoCommand>,
        let output_file = File::create(output_path)?;
            self.rg_writer_factory
    /// `flush_and_sort_chunk_count` and `flush_and_sort_chunk_time_millis` are
        let rg_writer_factory = ArrowRowGroupWriterFactory::new(&writer, output_schema.clone());
            row_group_index: 0,
                e
            ))
            .blocking_recv()
        > = super::metrics::record_merge(|| {
            false,
            metadata,
            col_writers
        self.io_tx
        // Open writers for the next row group.
            all_leaves.extend(leaves);
                .collect()
/// IO channel, buffered batches, and counters. Used by both sorted and
use parquet::arrow::arrow_writer::{compute_leaves, ArrowRowGroupWriterFactory};
 * The OpenSearch Contributors require contributions made to
                Some(output_writer_generation),
        // Capture the per-merge counters BEFORE moving `self` into the IO send below.
        let mut output_fields: Vec<ArrowField> = data_schema
            total_rows_written: 0,
        })?;
        self.tracked_writer_bytes = 0;
        if self.output_row_count >= self.output_flush_rows {
            for w in writers {
        if let Some(writers) = self.col_writers.take() {
            .ok_or_else(|| MergeError::Logic("Column writers not initialized".into()))?;
        // Track actual column writer memory using memory_size() API
                MergeError::Logic(format!("Invalid encoding/compression config: {}", e))
            .col_writers
use super::io_task::{get_merge_pool, spawn_io_task, IoCommand, RATE_LIMIT_MB_PER_SEC};
            .take()
}
    flush_and_sort_chunk_count: i64,
            .map(|f| f.as_ref().clone())
    /// always recorded — including on failure paths — to keep this counter
    reservation: MemoryReservation,
        output_fields.push(ArrowField::new(
            });
    total_rows_written: usize,
            RateLimitedWriter::new(output_file, RATE_LIMIT_MB_PER_SEC).map_err(MergeError::Io)?;
                &config,
                .par_iter_mut()
    pub fn new(
            log_error!("[RUST] Column write failed during push_batch: {}", e);
            .map_err(|e| {
        let config = SETTINGS_STORE
    tracked_writer_bytes: usize,
    /// symmetric with rayon's `merge_wall_millis`.
                )));
        let chunk_results: Vec<
    }
use arrow::array::RecordBatch;
    /// to be forwarded to the per-shard tracker on the Java side.
        self.tracked_writer_bytes = actual_writer_bytes;
            rg_writer_factory,
        let flush_count = self.flush_and_sort_chunk_count;
                    .into_par_iter()
    pub fn push_batch(&mut self, batch: RecordBatch) -> MergeResult<()> {
        self.total_rows_written += num_rows;
        let result = self.do_flush();
        let union_data_schema = ArrowSchema::try_merge(arrow_schemas).map_err(|e| {
            self.flush()?;
            col_writers: Some(col_writers),
        let (crc_writer, crc_handle) = CrcWriter::new(throttled_writer);
    }
    pub fn flush(&mut self) -> MergeResult<()> {
            return Ok(());
    pub flush_and_sort_chunk_time_millis: i64,
}
    ///
use tokio::sync::{mpsc as tokio_mpsc, oneshot};
use crate::rate_limited_writer::RateLimitedWriter;
        // Compute leaf columns (O(columns) pointer math), then parallel-write
            flush_and_sort_chunk_count: 0,
/*
            data_schema,
        let col_writers = self
        let mut all_leaves: Vec<parquet::arrow::arrow_writer::ArrowLeafColumn> =
            .map_err(|_| MergeError::Logic("IO task terminated unexpectedly".into()))?;
        // with_id dropped here — release its tracking
    flush_and_sort_chunk_time_millis: i64,
use rayon::prelude::*;
            let results: Vec<_> = get_merge_pool(self.rayon_threads).install(|| {
            .col_writers
        self.flush()?;
            flush_and_sort_chunk_time_millis: 0,
            Vec::with_capacity(col_writers.len());
    fn do_flush(&mut self) -> MergeResult<()> {
    next_row_id: i64,
use crate::crc_writer::CrcWriter;
        drop(self.io_tx);
    rayon_threads: Option<usize>,
        output_path: &str,
        })
/// unsorted merge paths.
    output_row_count: usize,
        if let Some(parent) = Path::new(output_path).parent() {
use super::schema::{append_row_id, build_parquet_root_schema, ROW_ID_COLUMN_NAME};
        let throttled_writer =
impl MergeContext {
        let col_writers = self
 */
    output_schema: Arc<ArrowSchema>,
            row_id_mapping_max: final_row_id_max,
            MergeError::Logic(format!(
}
    }
            self.reservation.shrink(with_id_bytes);
            flush_and_sort_chunk_time_millis: flush_time_millis,
        self.reservation.shrink(with_id_bytes);
        if let Some(e) = write_errors.into_iter().next() {
        rayon_threads: Option<usize>,
use crate::{log_debug, log_error, SETTINGS_STORE};
                .zip(all_leaves.into_par_iter())
use std::path::Path;
    /// Final flush + close the IO task. Returns Parquet metadata, CRC32, and per-merge stats
            encoded_chunks.push(r?);
    row_group_index: usize,
                .create_column_writers(self.row_group_index)?,
        for (arr, field) in with_id.columns().iter().zip(self.output_schema.fields()) {
                .shrink(self.tracked_writer_bytes - actual_writer_bytes);
                let _ = w.close();
        output_flush_rows: usize,
            .map(|r| r.clone())
        Ok(MergeFinishStats {
            WriterPropertiesBuilder::build_with_generation(
        drop(batch);
    pub crc32: u32,
            reservation,
    /// when the row count threshold is reached. Each batch is written and dropped
    pub fn data_schema(&self) -> &Arc<ArrowSchema> {
        ));
            io_tx,
    pub flush_and_sort_chunk_count: i64,
        let flush_start = std::time::Instant::now();
        let output_schema = Arc::new(ArrowSchema::new(output_fields));
            .unwrap_or_default();
        let with_id_bytes = with_id.get_array_memory_size();
            self.total_rows_written
use super::error::{MergeError, MergeResult};
        // Drop the freshly-created writers for the next (unused) row group.
        );
        }
        self.next_row_id += num_rows as i64;
        }
            let leaves = compute_leaves(field, arr)?;
        output_writer_generation: i64,
                .filter_map(|(writer, leaf)| writer.write(&leaf).err())
            n,
    /// writer, and spawns the background IO task.
    pub row_id_mapping_max: i64,
        self.col_writers = Some(
        let mut encoded_chunks = Vec::with_capacity(chunk_results.len());
            .collect();
            tracked_writer_bytes: 0,
            }
    }
/// Carries the parquet metadata + CRC plus per-merge stat counters that the caller
        let parquet_root = build_parquet_root_schema(output_schema.as_ref())?;
        let io_tx = spawn_io_task(writer, crc_handle, io_threads);
                    .collect()
        }
    ) -> MergeResult<Self> {
                &output_schema,
        }
    /// Creates a new merge context: builds union schemas, opens the output
        }
        Ok(())
            rayon_threads,
            output_schema,
            .get(index_name)
        let write_errors: Vec<_> = get_merge_pool(self.rayon_threads).install(|| {
        reservation: MemoryReservation,
            Ok(results)
        let n = self.output_row_count;
    }
            ArrowDataType::Int64,
            .fields()
    /// encoded row group to the IO task, and open fresh writers for the next
        );
/// forwards to the per-shard `ParquetShardStatsTracker`.
    pub metadata: parquet::file::metadata::ParquetMetaData,
 *
    rg_writer_factory: ArrowRowGroupWriterFactory,
        );
            .map_err(|_| MergeError::Logic("IO task terminated during close".into()))??;
        let data_schema = Arc::new(union_data_schema);
        } else if actual_writer_bytes < self.tracked_writer_bytes {
            .blocking_send(IoCommand::Close(reply_tx))
        let flush_time_millis = self.flush_and_sort_chunk_time_millis;
        arrow_schemas: Vec<ArrowSchema>,
use parquet::file::writer::SerializedFileWriter;
            if !parent.exists() {
use std::sync::Arc;
        result
            crc32,
use std::fs::File;
            }
                    .map(|col_writer| col_writer.close())
        self.reservation.grow(with_id_bytes);
