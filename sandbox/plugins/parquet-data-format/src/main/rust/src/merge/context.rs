        output_fields.push(ArrowField::new(
            total_rows_written: 0,
        self.col_writers = Some(
        if self.output_row_count == 0 {
    reservation: MemoryReservation,
        if let Some(parent) = Path::new(output_path).parent() {
    output_row_count: usize,
    /// Close current column writers in parallel (encode + compress), send the
/// unsorted merge paths.
        }
            .blocking_recv()
    io_tx: tokio_mpsc::Sender<IoCommand>,
            ROW_ID_COLUMN_NAME,
    }
        for (arr, field) in with_id.columns().iter().zip(self.output_schema.fields()) {
        let (reply_tx, reply_rx) =
/*
        // with_id dropped here — release its tracking
            tracked_writer_bytes: 0,
        let union_data_schema = ArrowSchema::try_merge(arrow_schemas).map_err(|e| {
        // Column writers closed via close() — release tracked writer memory
        self.flush_and_sort_chunk_time_millis += flush_start.elapsed().as_millis() as i64;
 * this file be licensed under the Apache-2.0 license or a
        self.flush()?;
        self.total_rows_written += num_rows;
    row_group_index: usize,
        let flush_time_millis = self.flush_and_sort_chunk_time_millis;
        Ok(MergeFinishStats {
use crate::crc_writer::CrcWriter;
        let parquet_root = build_parquet_root_schema(output_schema.as_ref())?;
    pub fn finish(mut self) -> MergeResult<MergeFinishStats> {
            MergeError::Logic(format!(
        reservation: MemoryReservation,
        self.io_tx
        let col_writers = self
            )
        let writer_props = Arc::new(
use crate::writer_properties_builder::WriterPropertiesBuilder;
            rayon_threads,
        let config = SETTINGS_STORE
    pub row_id_mapping_max: i64,
            "[RUST] Flushed row group {}: {} rows (total: {})",
    // Java side (see NativeParquetMergeStrategy + ParquetShardStatsTracker).
        self.io_tx
    /// Creates a new merge context: builds union schemas, opens the output
        output_flush_rows: usize,
        let flush_count = self.flush_and_sort_chunk_count;
impl MergeContext {
        let col_writers = self
        self.flush_and_sort_chunk_count += 1;
            all_leaves.extend(leaves);
            metadata,
        );
            self.row_group_index - 1,
    /// Final flush + close the IO task. Returns Parquet metadata, CRC32, and per-merge stats
            .collect();
        > = super::metrics::record_merge(|| {
use std::path::Path;
            .fields()
            .blocking_send(IoCommand::WriteRowGroup(encoded_chunks))
        });
    fn do_flush(&mut self) -> MergeResult<()> {
/// forwards to the per-shard `ParquetShardStatsTracker`.
}
/// Carries the parquet metadata + CRC plus per-merge stat counters that the caller
            flush_and_sort_chunk_time_millis: 0,
            flush_and_sort_chunk_count: 0,
            for w in writers {
    rayon_threads: Option<usize>,
            encoded_chunks.push(r?);
        let throttled_writer =
            oneshot::channel::<MergeResult<(parquet::file::metadata::ParquetMetaData, u32)>>();
                Some(output_writer_generation),
            self.total_rows_written
            n,
            reservation,
    }
        let mut encoded_chunks = Vec::with_capacity(chunk_results.len());
    data_schema: Arc<ArrowSchema>,
        // Open writers for the next row group.
                .filter_map(|(writer, leaf)| writer.write(&leaf).err())
    pub crc32: u32,
                e
            self.reservation.shrink(with_id_bytes);
                    "Output directory '{}' does not exist.",
    flush_and_sort_chunk_count: i64,
            io_tx,
            return Ok(());
                .shrink(self.tracked_writer_bytes - actual_writer_bytes);
use super::error::{MergeError, MergeResult};
            .col_writers
        // Track with_id batch (transient — alive during column write)
                let _ = w.close();
            Result<parquet::arrow::arrow_writer::ArrowColumnChunk, parquet::errors::ParquetError>,
                "Failed to compute union schema across input files: {}",
        })
                    .into_par_iter()
pub struct MergeContext {
            });
            .iter()
        for r in chunk_results {
            flush_and_sort_chunk_time_millis: flush_time_millis,
    pub fn flush(&mut self) -> MergeResult<()> {
    /// row group.
            col_writers: Some(col_writers),
    // Per-merge counters returned via `finish()` and forwarded to the per-shard tracker on the
            flush_and_sort_chunk_count: flush_count,
                .zip(all_leaves.into_par_iter())
        );
    ) -> MergeResult<Self> {
                    .collect()
        self.reservation.shrink(self.tracked_writer_bytes);
            row_id_mapping_max: final_row_id_max,
}
        drop(self.io_tx);
        if let Some(e) = write_errors.into_iter().next() {
            RateLimitedWriter::new(output_file, RATE_LIMIT_MB_PER_SEC).map_err(MergeError::Io)?;
        })?;
        }
            let leaves = compute_leaves(field, arr)?;
    ///
        self.tracked_writer_bytes = 0;
        // Parallel close: each column writer encodes and compresses its buffered
        arrow_schemas: Vec<ArrowSchema>,
        let write_errors: Vec<_> = get_merge_pool(self.rayon_threads).install(|| {
use super::schema::{append_row_id, build_parquet_root_schema, ROW_ID_COLUMN_NAME};
use parquet::file::writer::SerializedFileWriter;
            next_row_id: 0,
        if let Some(writers) = self.col_writers.take() {
    flush_and_sort_chunk_time_millis: i64,
            .blocking_send(IoCommand::Close(reply_tx))
                .collect()
        self.output_row_count = 0;
        }
    /// when the row count threshold is reached. Each batch is written and dropped
    }
    }
    /// writer, and spawns the background IO task.
        ));
        log_debug!(
        // Capture the per-merge counters BEFORE moving `self` into the IO send below.
        let writer = SerializedFileWriter::new(crc_writer, parquet_root, writer_props)?;
            output_schema,
            .map_err(|_| MergeError::Logic("IO task terminated before close".into()))?;
        self.tracked_writer_bytes = actual_writer_bytes;
        Ok(Self {
        })?;
        output_path: &str,
        let io_tx = spawn_io_task(writer, crc_handle, io_threads);
    /// symmetric with rayon's `merge_wall_millis`.
            ArrowDataType::Int64,
        // Drop the freshly-created writers for the next (unused) row group.
        let final_row_id_max = self.next_row_id;
        let col_writers = rg_writer_factory.create_column_writers(0)?;
/// IO channel, buffered batches, and counters. Used by both sorted and
    rg_writer_factory: ArrowRowGroupWriterFactory,
            })?,
 * The OpenSearch Contributors require contributions made to
            }
            crc32,
        result
        let output_file = File::create(output_path)?;
        // pages. This is the CPU-heavy step and benefits from rayon parallelism.
use rayon::prelude::*;
        let (metadata, crc32) = reply_rx
            self.rg_writer_factory
        let rg_writer_factory = ArrowRowGroupWriterFactory::new(&writer, output_schema.clone());
            Ok(results)
        self.reservation.shrink(with_id_bytes);
use super::io_task::{get_merge_pool, spawn_io_task, IoCommand, RATE_LIMIT_MB_PER_SEC};
        }
/// Result returned from `MergeContext::finish()`.
    pub fn data_schema(&self) -> &Arc<ArrowSchema> {
        &self.data_schema
        Ok(())
    tracked_writer_bytes: usize,
    /// ever live at a time.
    /// `flush_and_sort_chunk_count` and `flush_and_sort_chunk_time_millis` are
            return Err(e.into());
}
            .as_mut()
        let chunk_results: Vec<
    }
/// Owns all shared state for a merge operation: schemas, writer factory,
    next_row_id: i64,
            rg_writer_factory,
use arrow::datatypes::{DataType as ArrowDataType, Field as ArrowField, Schema as ArrowSchema};
use parquet::arrow::arrow_writer::{compute_leaves, ArrowRowGroupWriterFactory};
    /// to be forwarded to the per-shard tracker on the Java side.
                    .map(|col_writer| col_writer.close())
                    parent.display()
        let data_schema = Arc::new(union_data_schema);
    pub fn new(
            output_flush_rows,
                &output_schema,
    pub metadata: parquet::file::metadata::ParquetMetaData,
            .map_err(|_| MergeError::Logic("IO task terminated during close".into()))??;
use arrow::array::RecordBatch;
    }
        let mut output_fields: Vec<ArrowField> = data_schema
            data_schema,
use crate::rate_limited_writer::RateLimitedWriter;
use tokio::sync::{mpsc as tokio_mpsc, oneshot};
            }
        );
        // across columns via rayon. Each column writer encodes independently.
            false,
            output_row_count: 0,
        let with_id_bytes = with_id.get_array_memory_size();
                .create_column_writers(self.row_group_index)?,
                col_writers
            if !parent.exists() {
            col_writers
        if actual_writer_bytes > self.tracked_writer_bytes {
                &config,
pub struct MergeFinishStats {
            WriterPropertiesBuilder::build_with_generation(
        let n = self.output_row_count;
    pub flush_and_sort_chunk_time_millis: i64,
            .take()
            log_error!("[RUST] Column write failed during push_batch: {}", e);
use native_bridge_common::memory_pool::MemoryReservation;
                .grow(actual_writer_bytes - self.tracked_writer_bytes);
use std::sync::Arc;
    /// encoded row group to the IO task, and open fresh writers for the next
            .map_err(|_| MergeError::Logic("IO task terminated unexpectedly".into()))?;
            .map(|f| f.as_ref().clone())
            .map(|r| r.clone())
            self.reservation
        Ok(())
                return Err(MergeError::Logic(format!(
        index_name: &str,
        if self.output_row_count >= self.output_flush_rows {
    total_rows_written: usize,
        let num_rows = batch.num_rows();
        output_writer_generation: i64,
 * compatible open source license.
        let flush_start = std::time::Instant::now();
        let (crc_writer, crc_handle) = CrcWriter::new(throttled_writer);
 */
    pub flush_and_sort_chunk_count: i64,
        }
        self.reservation.grow(with_id_bytes);
    /// Writes a batch directly to column writers and triggers a row group flush
        let with_id = append_row_id(&batch, self.next_row_id, &self.output_schema)?;
    col_writers: Option<Vec<parquet::arrow::arrow_writer::ArrowColumnWriter>>,
use crate::{log_debug, log_error, SETTINGS_STORE};
        } else if actual_writer_bytes < self.tracked_writer_bytes {
        })
            .ok_or_else(|| MergeError::Logic("Column writers not initialized".into()))?;
            row_group_index: 0,
            .unwrap_or_default();
        rayon_threads: Option<usize>,
                )));
    output_flush_rows: usize,
        }
    output_schema: Arc<ArrowSchema>,
    /// immediately — no buffering — so only one batch's decoded data (~64 MB) is
use std::fs::File;
        drop(batch);
            .ok_or_else(|| MergeError::Logic("Column writers not initialized".into()))?;
            .col_writers
            ))
    pub fn push_batch(&mut self, batch: RecordBatch) -> MergeResult<()> {
            let results: Vec<_> = get_merge_pool(self.rayon_threads).install(|| {
            self.flush()?;
        self.row_group_index += 1;
                .par_iter_mut()
 * SPDX-License-Identifier: Apache-2.0
        io_threads: Option<usize>,
 *
        let actual_writer_bytes: usize = col_writers.iter().map(|w| w.memory_size()).sum();
            .get(index_name)
        let output_schema = Arc::new(ArrowSchema::new(output_fields));
        self.output_row_count += num_rows;
    /// always recorded — including on failure paths — to keep this counter
        }
            .map_err(|e| {
        }
        self.next_row_id += num_rows as i64;
                MergeError::Logic(format!("Invalid encoding/compression config: {}", e))
            Vec::with_capacity(col_writers.len());
            self.reservation
        // Compute leaf columns (O(columns) pointer math), then parallel-write
        let mut all_leaves: Vec<parquet::arrow::arrow_writer::ArrowLeafColumn> =
        let result = self.do_flush();
        // Track actual column writer memory using memory_size() API
