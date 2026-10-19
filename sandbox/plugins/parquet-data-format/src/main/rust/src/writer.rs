    /// Uses eager sort-and-write: writes batches to IPC staging, and when
    ) -> Result<u32, Box<dyn std::error::Error>> {
            let mapping_bytes = total * std::mem::size_of::<i64>();
            .iter()
                    descending: reverse_sorts.get(i).copied().unwrap_or(false),
    reverse_sorts: Vec<bool>,
                                &settings.sort_columns,
                        }
    }
            // Compute how many rows fit within the threshold (at least 1 to make progress).
    current_ipc_writer: Option<IpcFileWriter<File>>,
                                    log_debug!("CRC32 for file {}: {:#010x}", filename, crc32);
                self.current_rows += len;
        let converter = RowConverter::new(sort_fields)?;
            .collect();
            }
            let mut pos = 0usize;
    merge_sorted_with_pool,
                            // Reserve 3× batch as estimate — ArrowWriter encoding may temporarily
    /// the chunk row limit is reached, reads back the IPC, sorts, writes as
use arrow::compute::{concat_batches, take};
        format!("{}.sorted_chunk_{}.parquet", self.base_path, idx)
        }
                mut reservation,
            }
            &[],
            // Rewrite ___row_id to sequential 0..N so the chunk file is self-consistent
            writer_generation,
            })
                    "Created RecordBatch with {} rows and {} columns",
        let path = Path::new(filename);
    /// byte-comparable rows, sorts indices by comparing those rows, then
            filename,
                                temp_filename
        memory_threshold_bytes: u64,
        let (crc_file, crc_handle) = CrcWriter::new(file);
            )
        } else {
    /// Sort a batch using RowConverter: converts sort columns into compact
    /// Chunks are already sorted (done eagerly during write), so no sort needed here.
            .iter()
        // Close and remove the trailing IPC staging file
    writer_generation: i64,
                    .index_of(col_name)
                                        row_id_mapping: None,
                            let schema = chunked_writer.schema.clone();
            current_rows: 0,
                "Stale writer entry already exists for file: {} — removing it before re-create (likely a prior failed shard / Arrow OOM)",
        index_name: &str,
/// batches can be cheaply read back for sorting — Arrow IPC is a raw
                        }
                        WriterVariant::Parquet(writer_arc) => {
        let row_id_col_idx = self
            let index_name = settings.index_name.as_deref().unwrap_or("");
            }
            .enumerate()
        let crc32 = NativeParquetWriter::write_final_file(
            let mut flat_mapping = vec![0i64; total];
        }
            "write_data called for file: {} (temp: {})",
                    nulls_first: nulls_first.get(i).copied().unwrap_or(false),
        let mut writer = Self {
            let memory_threshold_bytes = settings.get_sort_in_memory_threshold_bytes();
    /// Row IDs captured from each sorted chunk (for permutation building).
            // merge_output.mapping freed — release its share, flat_mapping remains tracked
                filename
            while offset < num_rows {
    /// the next `create_writer` — which is what recovery does when it re-creates a writer for the
    /// Arrow IPC staging writer — used when sort columns are configured.
                let total = ids.len();
        // Reserve memory for sort (read-back + sorted copy coexist = 2× chunk)
        reservation: &mut MemoryReservation,
    }
        );
                                &settings.nulls_first,
        let sort_fields: Vec<SortField> = sort_columns
use crate::native_settings::NativeSettings;
                .map(|i| row_id_array.value(i))
        }
            .fields()
use lazy_static::lazy_static;
                                    let file = File::open(&filename)?;
        // Close the IPC writer
            let row_id_array = sorted_batch
            None
            writer.finish()?;
            .map(|ids| ids.len() * std::mem::size_of::<i64>())
                log_error!(
        let reader = IpcFileReader::try_new(file, None)?;
    }
        settings.index_name = Some(index_name.clone());
            self.total_rows += batch.num_rows();
            }
        for batch_result in reader {
            let arrow_array = FFI_ArrowArray::from_raw(array_address as *mut _);
                            Ok(Some(FinalizeResult {
        );
                                    );
                memory_threshold_bytes,
                            for path in &chunk_paths {
            let arrow_schema = FFI_ArrowSchema::from_raw(schema_address as *mut _);
struct SortingChunkedWriter {
    ) -> Result<(Vec<String>, Vec<Vec<i64>>, Vec<u32>), Box<dyn std::error::Error>> {
        let ipc_path = self.ipc_staging_path();
                &settings,
 * The OpenSearch Contributors require contributions made to
    pub fn write_data(
                path.file_name().unwrap().to_str().unwrap()
    /// sorted, and written as a final Parquet file.
            && self.current_chunk_bytes + incoming_batch_bytes > self.memory_threshold_bytes
        self.base_path.clone()
                                Ok(_) => {
        let sort_arrays: Vec<Arc<dyn arrow::array::Array>> = sort_columns
    /// Returns true if a writer is currently open for the given filename.
        reservation.grow(row_ids_bytes);
 *
        }
                settings.reverse_sorts.clone(),
        let temp_filename = Self::temp_filename(&filename);
        let temp_filename = Self::temp_filename(&filename);
                                    Err(e.into())
}
            "flush_and_sort_chunk: chunk_idx={}, current_chunk_bytes={}, current_rows={}, row_id_memory_size={}",
        })?;
use crate::writer_properties_builder::WriterPropertiesBuilder;
        output_filename: &str,
            &self.sort_columns,
            self.flush_and_sort_chunk(reservation)?;
            (
        );
                self.current_chunk_bytes += slice_bytes;
                            let writer = mutex.into_inner().unwrap();
            // Nothing to sort, just reopen
                writer_generation,
        );
        let temp_filename = Self::temp_filename(filename);
        drop(batches); // free memory before sort allocates
}
    pub fn cleanup_writer(filename: &str) -> Result<(), Box<dyn std::error::Error>> {
            return Ok(());
                Some(writer_generation),
use arrow::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
                    match Arc::try_unwrap(writer_arc) {
    ) -> Result<Option<FinalizeResult>, Box<dyn std::error::Error>> {
pub struct FinalizeResult {
    }
                            state.reservation.reserve_estimated(estimated)?;
    }
    settings: NativeSettings,
            &combined,
        filename: String,
const IPC_STAGING_SUFFIX: &str = ".arrow_ipc_staging";
                                chunked_writer.finish(&mut reservation)?;
        };
        );
lazy_static! {
        path.parent()
        index_name: &str,
    pub fn create_writer(
        // Track accumulated row_ids for this chunk — Vec<i64> per chunk persists until finish()
        // If sort columns are configured, use eager sort-and-write path:
 * this file be licensed under the Apache-2.0 license or a
            nulls_first,
        batch: &RecordBatch,
        // Write sorted chunk as Parquet
        log_debug!("Schema created with {} fields", schema.fields().len());
                writer_generation,
        sort_indices.sort_unstable_by(|&a, &b| rows.row(a as usize).cmp(&rows.row(b as usize)));
        reverse_sorts: &[bool],
        }
                    Err("Writer not found".into())
        // Concat and sort
    }
            // Chunk finalization merges freshly written chunks; no deletes apply here.
        log_debug!(
        reservation.shrink(sort_reserve);
                WriterVariant::Ipc(writer_arc) => {
                let slice_bytes = slice.get_array_memory_size() as u64;
            );
                WriterVariant::Parquet(Arc::new(Mutex::new(writer))),
    ///
            self.flush_and_sort_chunk(reservation)?;
            columns[idx] = Arc::new(sequential_ids);
        reverse_sorts: &[bool],
        Ok(())
        let row_ids_bytes = self.current_rows * std::mem::size_of::<i64>();
use crate::crc_writer::CrcWriter;
    }
                                &mut reservation,
            &self.index_name,
            .schema
                                    );
                schema,
        if let Some(mut writer) = self.current_ipc_writer.take() {
        reverse_sorts: Vec<bool>,
                            )?;
        max_sort_modes: Vec<bool>,
            log_error!(
        Ok(())
                }
        if let Some(mut writer) = self.current_ipc_writer.take() {
            ))
        let mut merge_reservation = MemoryReservation::new(
        // the budget, flush (sort + write) the current chunk first, then
///   writes as a sorted Parquet chunk, deletes the IPC file, and starts a new
    /// - `chunk_row_ids`: accumulated row ID vectors from all completed chunks
            }
    ) -> Result<usize, Box<dyn std::error::Error>> {
    /// sorted Parquet chunk, then starts a new IPC file. At finalize, only
    schema::ROW_ID_COLUMN_NAME,
            let rows_per_slice =
        );
            sorted_batch
    pub row_id_mapping: Option<Vec<i64>>,
        let combined = concat_batches(&self.schema, &batches)?;
                let options = arrow::compute::SortOptions {
            metadata.file_metadata().num_rows(),
    /// a k-way merge is needed.
            total_rows: 0,
            log_info!("finalize_sorted_chunks: no chunks, writing empty Parquet file");
                            let parquet_metadata = reader.metadata().clone();
        let mut sort_indices: Vec<u32> = (0..batch.num_rows() as u32).collect();
        }
    /// Finalize: flush remaining IPC data (sort + write) and return chunk paths + row IDs + CRCs.
                    }
                            );
        filename: String,
    /// Idempotent: returns `Ok(())` whether or not an entry existed. Called by the shard
            );
                                reservation.shrink(mapping.len() * std::mem::size_of::<i64>());
                    let orig_idx = original_row_id as usize;
        let merge_output = merge_sorted_with_pool(
                .map(|r| r.clone())
        log_info!(
                let record_batch = RecordBatch::try_new(schema, struct_array.columns().to_vec())?;
        let metadata = reader.metadata().clone();
                reservation: MemoryReservation::new(
    /// The IPC staging approach means record batch data lives on disk, not in memory.
        if self.current_chunk_bytes > 0
    /// This does NOT include the transient peak during `flush_and_sort_chunk()`
                settings,
                    .schema()
                                        temp_filename
    pub fn get_file_metadata(
        }
            &self.max_sort_modes,
    ) -> Result<RecordBatch, Box<dyn std::error::Error>> {
            Err("Writer not found".into())
                                let _ = std::fs::remove_file(path);
        schema: Arc<arrow::datatypes::Schema>,
///   Parquet chunk paths for k-way merge.
                                &filename,
    pub static ref SETTINGS_STORE: DashMap<String, NativeSettings> = DashMap::new();
                            let batch_bytes = record_batch.get_array_memory_size();
                                    let parquet_metadata = reader.metadata().clone();
            .map(|(i, col_name)| {
                }
                base_path,
    /// What *is* held in memory:
        self.open_new_ipc()?;
                                    Ok(Some(FinalizeResult {
/// - At finalize: flushes remaining IPC data (sort + write), returns sorted
                        Ok(mutex) => {
        if incoming_batch_bytes <= self.memory_threshold_bytes {
                }
                        Err(_) => {
                .downcast_ref::<Int64Array>()
                                    }))
        Ok((crc32, row_id_mapping))
    /// Arrow schema shared across all chunks.
                index_name.clone(),
/// Path suffix for the intermediate Arrow IPC file used during sort-on-close.
        let crc32 = crc_handle.crc32();
        let file = File::open(&filename)?;
            let total = merge_output.mapping.len();
                crc_handle,
        log_debug!(
                            }
        let _ = std::fs::remove_file(&self.ipc_staging_path());
        schema: Arc<arrow::datatypes::Schema>,
                &schema,
                if let Some(ref mut w) = self.current_ipc_writer {
        log_debug!(
            match variant {
        Ok(crc32)
            temp_filename
                            log_debug!("Writing RecordBatch to IPC staging file");
            )
        writer_generation: Option<i64>,
                            writer.write(&record_batch)?;
        }
            if entry.key().starts_with(&path_prefix) {
                            }
///   IPC file.
                "temp-{}",
            merge_duration
        chunk_crcs: &[u32],
        settings.max_sort_modes = max_sort_modes;
            let props = WriterPropertiesBuilder::build_with_generation(
                "ERROR: Invalid schema address (null pointer) for file: {}",
                output_filename
            chunk_paths.len(),
        .map_err(|e| -> Box<dyn std::error::Error> {
        };
        let chunk_path = self.sorted_chunk_path(self.chunk_idx);
                settings.sort_columns.clone(),
        // write the new batch into a fresh IPC staging file.
use arrow::row::{RowConverter, SortField};
        let temp_filename = Self::temp_filename(filename);
        self.chunk_row_ids
            .get(index_name)
    fn sorted_chunk_path(&self, idx: usize) -> String {
                            );
                                    log_error!(
    }
    current_rows: usize,
        let merge_duration = overall_start.elapsed();
                            let before = writer.memory_size();
    /// CRC32 values for each completed sorted Parquet chunk file.
        sort_columns: &[String],
        let row_id_mapping = if !merge_output.mapping.is_empty() && !chunk_row_ids.is_empty() {
            filename, index_name, schema_address, sort_columns, reverse_sorts, nulls_first, max_sort_modes, writer_generation
    /// Flat row ID mapping where mapping[original_row_id] = new_row_id.
            chunk_crcs: Vec::new(),
                                temp_filename
        } else {
    ) -> Result<(), Box<dyn std::error::Error>> {
 * compatible open source license.
                                        metadata: parquet_metadata,
                                temp_filename, total_rows, chunk_paths.len()
        );
    /// that failed the shard before finalize could run) does not survive as a stale entry and block
///   exceed `memory_threshold_bytes`, reads the IPC file back, sorts in memory,
            .unwrap_or_else(|| Path::new(""))
        schema_address: i64,
                variant,
        log_debug!(
                } else {
                    array.data_type()
        let sort_reserve = self.current_chunk_bytes as usize * 2;
            for i in 0..total {
    }
        if self.current_rows > 0 {
        // Build the flat permutation: result[original_row_id] = new_row_id
            let base_path = format!("{}{}", temp_filename, IPC_STAGING_SUFFIX);
                }
        );
            "Successfully wrote final file: {} (crc32={:#010x})",
        }
                            let estimated = batch_bytes * 3;
        chunk_row_ids: &[Vec<i64>],
            &chunk_path,
            max_sort_modes,
    ///
        sort_columns: &[String],
        let file = File::create(output_filename)?;
                Int64Array::from_iter_values((0..sorted_batch.num_rows() as i64).map(|x| x));
    }
        sort_columns: Vec<String>,
        batch: &RecordBatch,
impl SortingChunkedWriter {
            .map(|r| r.clone())
    chunk_idx: usize,
        output_filename: &str,
use dashmap::DashMap;
        nulls_first: &[bool],
                let data_type = reduced_sort_type(batch.schema().field(col_index).data_type());
    pub fn finalize_writer(
                                index_name,
    /// plus the incoming batch size would exceed this threshold, the current chunk
                            let reader = SerializedFileReader::new(file)?;
            return Ok(());
            chunk_paths.len(),
            sort_columns,
            .unwrap_or_default();
        let _ = std::fs::remove_file(&ipc_path);
        let props =
                            let writer_arc = writer_arc.clone();
            },
            .join(format!(
        writer_generation: i64,
            )
    pub fn get_filtered_writer_memory_usage(
        self.total_rows
            // that each fit within the threshold, flushing after each piece.
    /// Removes the writer entry for `filename` from the registry without finalizing it, dropping the
            completed_chunks: Vec::new(),
    base_path: String,
            index_name,
    /// Index of the next chunk (0-based).
}
use std::path::Path;
enum WriterVariant {
            let batch = batch_result?;
        reservation: &mut MemoryReservation,
                                    std::fs::rename(&temp_filename, &filename)?;
            .to_string_lossy()
                                        "ERROR: Failed to close writer for temp file: {}",
                        flat_mapping[orig_idx] = merge_output.mapping[pos];
}
            return Ok((crc32, row_id_mapping));
                );
            let sequential_ids =
            let mut offset = 0;
            reservation.shrink(sort_reserve);
        // At finalize, only a k-way merge is needed (no IPC re-read).
                                row_id_mapping,
            return Err("Invalid FFI addresses (null pointers)".into());
            reservation.shrink(mapping_bytes);
        let indices = arrow::array::UInt32Array::from(sort_indices);
        self.current_ipc_writer = Some(ipc_writer);
            "writer:k_way_merge",
    variant: WriterVariant,
                            let writer_arc = writer_arc.clone();
        } else {
            .collect::<Result<Vec<_>, Box<dyn std::error::Error>>>()?;
                                &settings.max_sort_modes,
/// Hybrid IPC staging + eager sort writer.
        )
use parquet::arrow::ArrowWriter;
        base_path: String,
            // A stale entry survived a prior failure (e.g. an Arrow OOM that failed the shard before
}
            "finalize_writer called for file: {} (temp: {})",
        }
            // recovery, since recovery re-creates a writer for the same generation/file — remove the
                            log_info!(
        Ok(())
        log_debug!(
            current_chunk_bytes: 0,
    /// Present only when sort columns were configured.
    /// same generation/file.
            };
                Some(writer_generation),
    fn finalize_sorted_chunks(
            if let Some(struct_array) = array.as_any().downcast_ref::<arrow::array::StructArray>() {
/// When sort columns are configured, the IPC variant is used so that
        let rows = converter.convert_columns(&sort_arrays)?;
        self.chunk_idx += 1;
            .map_err(|e| format!("Invalid encoding/compression config: {}", e))?;
        if chunk_paths.is_empty() {
        reverse_sorts: Vec<bool>,
                        Ok(mutex) => {
#[derive(Debug)]
                        WriterVariant::Ipc(writer_arc) => {
                    }
            chunk_idx: 0,
                                &chunk_crcs,
use std::sync::{Arc, Mutex};
 */
                    if orig_idx < total {
            self.current_rows += batch.num_rows();
                            let chunked_writer = mutex.into_inner().unwrap();
                    "parquet_writer",
        Ok(metadata)
        }
        Ok(RecordBatch::try_new(batch.schema(), sorted_columns?)?)
        // Multiple chunks: k-way merge
            .map(|(i, col_name)| {
    fn ipc_staging_path(&self) -> String {
            WriterState {
            log_error!("ERROR: Invalid FFI addresses for file: {}", temp_filename);
        let (variant, crc_handle) = if !settings.sort_columns.is_empty() {
                // Reserve for permutation Vec<i64> before allocating
            writer.close()?;
                                    let reader = SerializedFileReader::new(file)?;
        let sorted_columns: Result<Vec<_>, _> = batch
        let arrow_schema = unsafe { FFI_ArrowSchema::from_raw(schema_address as *mut _) };
            } else {
    total_rows: usize,
        let incoming_batch_bytes = batch.get_array_memory_size() as u64;
                if let Some(mut state) = WRITERS.get_mut(&temp_filename) {
/// drops the writer, closes the file handle, and cleans up sort config.
                            let mut writer = writer_arc.lock().unwrap();
                        mapping[orig_idx] = new_pos as i64;
                            Err("IPC Writer still in use".into())
    pub(crate) fn sort_batch(
                settings,
    fn temp_filename(filename: &str) -> String {
                flat_mapping[i] = i as i64;
            writer_generation,
use crate::memory::write_pool;
            metadata.file_metadata().version(),
        Ok(())
        // If the current chunk already has data and the combined size exceeds
            chunk_row_ids: Vec::new(),
    ) -> Result<(), Box<dyn std::error::Error>> {
/// - When the accumulated chunk byte size plus the incoming batch size would
            crc32
                "finalize_sorted_chunks: produced {} permutation entries for {}",
        max_sort_modes: &[bool],
            "create_writer called for file: {}, index: {}, schema_address: {}, sort_columns: {:?}, reverse_sorts: {:?}, nulls_first: {:?}, max_sort_modes: {:?}, writer_generation: {}",
    /// where the IPC file is read back and sorted — that's short-lived and freed
            RecordBatch::try_new(self.schema.clone(), columns)?
            .enumerate()
    nulls_first: Vec<bool>,
        drop(combined); // free unsorted data
    /// Finalize pre-sorted Parquet chunks: k-way merge them into the final file.
                    }
    completed_chunks: Vec<String>,
                .expect("___row_id column must be Int64");
                let len = std::cmp::min(rows_per_slice, num_rows - offset);
                None
            // Use the CRC computed when the chunk was written
            .collect::<Result<Vec<_>, _>>()?;
}
            Some(flat_mapping)
    pub metadata: parquet::file::metadata::ParquetMetaData,
        );
            output_filename,
                crc_handle,
            WRITERS.remove(&temp_filename);
                    record_batch.num_columns()
            }
            std::fs::rename(&chunk_paths[0], output_filename)?;
                        }
    fn open_new_ipc(&mut self) -> Result<(), Box<dyn std::error::Error>> {
        let crc32 = merge_output.crc32;
use crate::merge::{
        let file = File::create(&path)?;
    fn finish(
    /// Base path for staging/chunk files.
        reservation.request(sort_reserve)?;
            "finalize_sorted_chunks: DONE file={}, chunks={}, merge_duration={:?}",
            sort_columns,
        writer.write(batch)?;
            chunk_paths.len(),
            log_info!("Cleaned up writer entry for {}", temp_filename);
                if self.current_chunk_bytes >= self.memory_threshold_bytes {
    /// Parallel with `sort_columns`: `true` = MAX reduction, `false` = MIN.
    }
                .map_err(|e| format!("Invalid encoding/compression config: {}", e))?;
            let array: Arc<dyn arrow::array::Array> = arrow::array::make_array(array_data);
                std::cmp::max(1, (self.memory_threshold_bytes / bytes_per_row) as usize);
    }
    /// Close the current IPC file, read it back, sort, write as sorted Parquet chunk.
    }
                            // On failure, chunks are preserved as they may be the only copy of the data.
                            // Detach mapping from reservation before handing to FFI/Java.
                            // Reconcile: adjust reservation to actual delta reported by ArrowWriter
    /// Total rows written across all chunks.
    /// Current IPC writer for staging incoming batches.
    static ref WRITERS: DashMap<String, WriterState> = DashMap::new();
        if WRITERS.contains_key(&temp_filename) {
            )
            base_path,
            .sum()
/*
            .iter()
    /// Holds both Parquet and IPC writers via the `WriterVariant` enum.
                                    // Parquet variant is used for non-sorted data; just rename.
                settings.max_sort_modes.clone(),
                                schema.clone(),
            let file = File::create(&temp_filename)?;
            output_filename
    ) -> Result<(u32, Option<Vec<i64>>), Box<dyn std::error::Error>> {
                            );
                            if let Some(ref mapping) = row_id_mapping {
 * SPDX-License-Identifier: Apache-2.0
    /// Sort configuration.
    }
                            // hold dictionary, compressed pages, and data page buffers.
        reservation: &mut MemoryReservation,
                    match Arc::try_unwrap(writer_arc) {
        log_info!(
    ) -> Result<(), Box<dyn std::error::Error>> {
            if let Some(ref mut w) = self.current_ipc_writer {
        // Check if adding this batch would breach the memory threshold.
        if batches.is_empty() {
    }
    ) -> Result<Self, Box<dyn std::error::Error>> {
                    let orig_idx = old_row_id as usize;
                Some(mapping)
    ///   (retained until `finish()` for permutation building).
            write_pool(),
        let overall_start = std::time::Instant::now();
        // If the batch itself fits within the threshold, write it directly.
        index_name: String,
            let config = SETTINGS_STORE
    }
        );
            self.chunk_row_ids.push(ids);
            memory_threshold_bytes,
        {
            // reservation) and proceed to create a fresh writer.
        if chunk_paths.len() == 1 {
                    PoolBehavior::IgnoreLimit,
                                    let crc32 = crc_handle.map(|h| h.crc32()).unwrap_or(0);
        nulls_first: Vec<bool>,
        reservation: &mut MemoryReservation,
                None,
                                Err(e) => {
        // Capture original row IDs for permutation building, then rewrite to sequential 0..N
    /// Row count in the current IPC staging file.
            format!("Streaming merge failed: {}", e).into()
    /// Index name for writer properties.
                flat_mapping.len(),
    /// Batches are written as raw Arrow IPC; on close they are read back,
                    Ok(())
                for (new_pos, &old_row_id) in ids.iter().enumerate() {
                                metadata: parquet_metadata,
            .columns()
                temp_filename
                                &chunk_row_ids,
            log_error!(
            let writer = ArrowWriter::try_new(crc_file, schema, Some(props))?;
                    match &state.variant {
                            log_debug!("Writing RecordBatch to Parquet file");
                .unwrap_or_default();
        mut self,
            if batch.num_rows() > 0 {
        // Safety net: flush if we ended up at or above the threshold.
    }
        )?;
        settings.sort_columns = sort_columns;
                Some(crc_handle),
    /// For single chunk, just rename. For empty, write empty Parquet.
        max_sort_modes: &[bool],
                                }
        } else {
            temp_filename
            WriterPropertiesBuilder::build_with_generation(&config, writer_generation, &schema)
            PoolBehavior::IgnoreLimit,
                                "Successfully closed sorting chunked writer for: {}, total_rows={}, chunks={}",
                                writer_generation,
    heap::{reduced_sort_array, reduced_sort_type},
        // accumulate batches in memory, sort each chunk, write as Parquet.
                            }))
        };
                // Flush after each slice that fills the budget.
use native_bridge_common::memory_pool::{MemoryReservation, PoolBehavior};
            &self.reverse_sorts,
    /// Direct Parquet writer — used when no sort columns are configured.
        Ok((self.completed_chunks, self.chunk_row_ids, self.chunk_crcs))
    Ipc(Arc<Mutex<SortingChunkedWriter>>),
        }
    }
        for entry in WRITERS.iter() {
            let writer = ArrowWriter::try_new(file, schema, Some(props))?;
            let crc32 = chunk_crcs.first().copied().unwrap_or(0);
                    .map_err(|_| format!("Sort column '{}' not found in schema", col_name))?;
                            match writer.close() {
            } = state;
            &mut merge_reservation,
    }
                                        "Successfully closed temp writer for: {}",
            }
        use arrow::array::Int64Array;
        let final_batch = if let Some(idx) = row_id_col_idx {
        max_sort_modes: Vec<bool>,
    fn write_final_file(
                    w.write(&slice)?;
            (
            output_filename,
            log_error!("ERROR: Writer not found for temp file: {}", temp_filename);
};
            for chunk_ids in chunk_row_ids {
            let WriterState {
            writer.finish()?;
                            drop(writer);
                batches.push(batch);
    chunk_row_ids: Vec<Vec<i64>>,
        filename: String,
                WriterVariant::Ipc(Arc::new(Mutex::new(chunked_writer))),
    /// Build the temp filename by prepending "temp-" to the basename.
                            let (chunk_paths, chunk_row_ids, chunk_crcs) =
            return Err("Invalid schema address".into());
            .iter()
                            Err("Writer still in use".into())
pub struct NativeParquetWriter;
                    if orig_idx < total && pos < total {
            log_info!("finalize_sorted_chunks: single chunk, renaming to final output");
                    }
    schema: Arc<arrow::datatypes::Schema>,
            )?;
                            let actual = writer.memory_size().saturating_sub(before);
    /// Writer generation propagated into Parquet file metadata for each chunk.
        }
/// - Writes incoming batches to an IPC file (cheap, no memory accumulation).
        sort_columns: Vec<String>,
                            state.reservation.reconcile(estimated, actual);
        let reader = SerializedFileReader::new(file)?;
    /// Paths of all completed sorted Parquet chunk files.
        array_address: i64,
impl NativeParquetWriter {
            // The batch alone exceeds the memory budget — slice it into pieces
            reverse_sorts,
    index_name: String,
        let temp_filename = Self::temp_filename(&filename);
    /// the Arrow array memory sizes of batches written so far).
            // the writer could be finalized). Rather than reject — which permanently blocks shard
                let col_index = batch
    writer_generation: i64,
        Ok(())
            &self.nulls_first,
/// The underlying writer — either direct Parquet or Arrow IPC staging.
    /// Memory budget (bytes) for in-memory sort. When the IPC staging file size
        let file = File::open(&ipc_path)?;
    ///
        chunk_paths: &[String],
                let schema = Arc::new(arrow::datatypes::Schema::new(struct_array.fields().clone()));
            .get(&index_name)
        if WRITERS.remove(&temp_filename).is_some() {
    /// underlying writer (which closes its file handle and releases its memory reservation).
                }
        nulls_first: &[bool],
                let max = max_sort_modes.get(i).copied().unwrap_or(false);
                offset += len;
            log_info!(
            filename,
        let mut writer = ArrowWriter::try_new(crc_file, schema, Some(props))?;
                            }
                &schema,
                .column(idx)
use parquet::file::reader::{FileReader, SerializedFileReader};
use arrow::record_batch::RecordBatch;
            .unwrap_or_default();
                writer_generation,
        writer.close()?;
            })
        } else {
            Some(self.writer_generation),
        // Release sort memory
                variant,
                Err("Expected struct array from VectorSchemaRoot".into())
            nulls_first,
                settings.nulls_first.clone(),
    fn memory_size(&self) -> usize {
            );
            .map_err(|e| format!("Invalid encoding/compression config: {}", e))?;
                                    log_info!(
            let mut columns = sorted_batch.columns().to_vec();
            self.chunk_idx, self.current_chunk_bytes, self.current_rows, self.memory_size()
                            log_error!(
    /// before the method returns.
                let ids = &chunk_row_ids[0];
            // stale entry (dropping the old writer, closing its file handle and releasing its
    /// Returns the actual in-memory footprint of this writer's heap allocations.
            temp_filename,
                self.total_rows += len;
        )?;
    }
        settings.reverse_sorts = reverse_sorts;
        }
        filename: String,
                reservation.request(mapping_bytes)?;
                };
                            let mut writer = writer_arc.lock().unwrap();
                for &original_row_id in chunk_ids {
        if self.current_ipc_writer.is_none() {
                                &chunk_paths,
        self.completed_chunks.push(chunk_path);
            reservation.request(mapping_bytes * 2)?;
            merge_duration
            "finalize_sorted_chunks: k-way merge complete: {} chunks merged, duration={:?}",
        WRITERS.contains_key(&temp_filename)
            self.flush_and_sort_chunk(reservation)?;
use crate::{log_debug, log_error, log_info};
                    }
        if (array_address as *mut u8).is_null() || (schema_address as *mut u8).is_null() {
        }
        self.current_chunk_bytes = 0;
        let config = SETTINGS_STORE
        let schema = Arc::new(arrow::datatypes::Schema::try_from(&arrow_schema)?);
            let ids: Vec<i64> = (0..row_id_array.len())
/// Bundles all per-writer resources so a single `DashMap::remove` atomically
            } else {
                            // Clean up sorted chunk files only after successful finalization.
                                        crc32,
                log_debug!(
            "Metadata for {}: version={}, num_rows={}, num_row_groups={}",
            self.open_new_ipc()?;
    fn new(
                let slice = batch.slice(offset, len);
        settings.nulls_first = nulls_first;
        path_prefix: String,
            let num_rows = batch.num_rows();
            .map(|r| r.clone())
            .map(|col| take(col.as_ref(), &indices, None))
            chunk_paths,
        // Read back the IPC file (still hot in page cache since we just wrote it)
                                        temp_filename
                            log_debug!("CRC32 for file {}: {:#010x}", filename, crc32);
    chunk_crcs: Vec<u32>,
            // Reserve 2× mapping: merge_output.mapping (alive) + flat_mapping (about to allocate)
                    "ERROR: Array is not a StructArray, type: {:?}",
            // Single chunk: just rename to final output (already sorted Parquet)
                                }
                        Err(_) => {
        unsafe {
        &mut self,
            current_ipc_writer: None,
            let props = WriterPropertiesBuilder::build_with_generation(
                total_memory += entry.value().reservation.size();
    ) -> Result<(), Box<dyn std::error::Error>> {
        }
        &mut self,
            &final_batch,
                            // FFI layer will track it via write_pool().grow/shrink.
        WRITERS.insert(
                        }
            output_filename,
    pub fn has_writer(filename: &str) -> bool {
    ) -> Result<parquet::file::metadata::ParquetMetaData, Box<dyn std::error::Error>> {
    /// Unified per-writer registry. Keyed by temp filename.
        if self.current_chunk_bytes >= self.memory_threshold_bytes {
            let array_data = arrow::ffi::from_ffi(arrow_array, &arrow_schema)?;
                            log_error!(
        SETTINGS_STORE.insert(index_name.clone(), settings.clone());
                .get(index_name)
                        }
            self.current_chunk_bytes += incoming_batch_bytes;
    sort_columns: Vec<String>,
        nulls_first: Vec<bool>,
use std::fs::File;
                                &settings.reverse_sorts,
        // Release sort working memory (read-back + sorted copy no longer alive)
                let col_index = batch.schema().index_of(col_name)?;
            .iter()
struct WriterState {
    current_chunk_bytes: u64,
            let chunked_writer = SortingChunkedWriter::new(
            "finalize_sorted_chunks: merging {} pre-sorted chunks for {}",
                            let (crc32, row_id_mapping) = Self::finalize_sorted_chunks(
                ),
    reservation: MemoryReservation,
            filename,
            index_name,
                    write_pool(),
                    pos += 1;
    pub crc32: u32,
                w.write(batch)?;
                }
    Parquet(Arc<Mutex<ArrowWriter<CrcWriter<File>>>>),
        let mut batches: Vec<RecordBatch> = Vec::new();
                let mapping_bytes = total * std::mem::size_of::<i64>();
                    record_batch.num_rows(),
        let sorted_batch = NativeParquetWriter::sort_batch(
        // Delete the IPC staging file and open a fresh one
                        }
            .position(|f| f.name() == ROW_ID_COLUMN_NAME);
            let _ = std::fs::remove_file(&ipc_path);
        };
        writer_generation: i64,
                                "ERROR: Writer still in use for temp file: {}",
/// Result from finalizing a writer: Parquet metadata + whole-file CRC32 + optional sort permutation.
        schema: Arc<arrow::datatypes::Schema>,
            let (crc_file, crc_handle) = CrcWriter::new(file);
        let mut settings: NativeSettings = SETTINGS_STORE
                reduced_sort_array(batch.column(col_index), max)
        batch: &RecordBatch,
        let path = self.ipc_staging_path();
        );
                                "ERROR: IPC Writer still in use for temp file: {}",
    fn flush_and_sort_chunk(
        if let Some((_, state)) = WRITERS.remove(&temp_filename) {
    memory_threshold_bytes: u64,
        if (schema_address as *mut u8).is_null() {
use arrow_ipc::writer::FileWriter as IpcFileWriter;
    crc_handle: Option<crate::crc_writer::CrcHandle>,
            reverse_sorts,
            let file = File::create(output_filename)?;
    max_sort_modes: Vec<bool>,
    /// reorders all columns via take.
                }
                            let total_rows = chunked_writer.total_rows();
            metadata.num_row_groups()
    /// is flushed (sorted and written as Parquet) before accepting the new batch.
                let mut mapping = vec![0i64; total];
                                crc32,
        writer_generation: i64,
                    self.flush_and_sort_chunk(reservation)?;
        let ipc_writer = IpcFileWriter::try_new(file, &self.schema)?;
    fn write(
                Ok(SortField::new_with_options(data_type, options))
            .to_string()
    /// Tracked byte size of the current IPC staging file (approximated from
    /// close / going-red flow so that a writer left behind by a failed operation (e.g. an Arrow OOM
                .as_any()
/// dump of in-memory Arrow buffers with minimal framing overhead.
use arrow_ipc::reader::FileReader as IpcFileReader;
        Ok(total_memory)
        let mut total_memory = 0;
            max_sort_modes,
        index_name: String,
        }
                            writer.write(&record_batch, &mut state.reservation)?;
            let row_id_mapping = if !chunk_row_ids.is_empty() && !chunk_row_ids[0].is_empty() {
        log_info!(
            self.schema.clone(),
                .collect();
        Ok(writer)
}
                WriterVariant::Parquet(writer_arc) => {
        writer.open_new_ipc()?;
                            let file = File::open(&filename)?;
                );
        self.chunk_crcs.push(crc32);
            // Build permutation from the single chunk's row IDs
        self.current_rows = 0;
            schema,
            }
        }
            drop(merge_output);
            return Ok((0, None));
                &config,
        log_debug!(
            let bytes_per_row = incoming_batch_bytes / num_rows as u64;
                    log_error!("ERROR: No writer found for temp file: {}", temp_filename);
        schema_address: i64,
    fn total_rows(&self) -> usize {
