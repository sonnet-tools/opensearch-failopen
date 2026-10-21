        // Track accumulated row_ids for this chunk — Vec<i64> per chunk persists until finish()
        self.current_ipc_writer = Some(ipc_writer);
/// Result from finalizing a writer: Parquet metadata + whole-file CRC32 + optional sort permutation.
    max_sort_modes: Vec<bool>,
use std::sync::{Arc, Mutex};
/*
            .unwrap_or_else(|| Path::new(""))
            writer.finish()?;
                            }))
                                }
    fn write(
            base_path,
    settings: NativeSettings,
                WriterVariant::Ipc(writer_arc) => {
        if WRITERS.remove(&temp_filename).is_some() {
            let row_id_mapping = if !chunk_row_ids.is_empty() && !chunk_row_ids[0].is_empty() {
            (
            .map_err(|e| format!("Invalid encoding/compression config: {}", e))?;
                                        crc32,
    /// Holds both Parquet and IPC writers via the `WriterVariant` enum.
                variant,
        if (array_address as *mut u8).is_null() || (schema_address as *mut u8).is_null() {
                total_memory += entry.value().reservation.size();
struct SortingChunkedWriter {
            output_filename,
    memory_threshold_bytes: u64,
            }
                            Ok(Some(FinalizeResult {
    /// that failed the shard before finalize could run) does not survive as a stale entry and block
                            let schema = chunked_writer.schema.clone();
                                        row_id_mapping: None,
            std::fs::rename(&chunk_paths[0], output_filename)?;
                            log_debug!("Writing RecordBatch to Parquet file");
        let final_batch = if let Some(idx) = row_id_col_idx {
        output_filename: &str,
            .map_err(|e| format!("Invalid encoding/compression config: {}", e))?;
            &mut merge_reservation,
                "temp-{}",
        sort_indices.sort_unstable_by(|&a, &b| rows.row(a as usize).cmp(&rows.row(b as usize)));
            chunk_crcs: Vec::new(),
        );
    current_chunk_bytes: u64,
        // Concat and sort
        reverse_sorts: &[bool],
use arrow::record_batch::RecordBatch;
                let total = ids.len();
    /// sorted, and written as a final Parquet file.
            let mut offset = 0;
        let props =
    }
                            // hold dictionary, compressed pages, and data page buffers.
            )
                                &settings.nulls_first,
        log_debug!("Schema created with {} fields", schema.fields().len());
            let mapping_bytes = total * std::mem::size_of::<i64>();
            }
                                    );
        // Reserve memory for sort (read-back + sorted copy coexist = 2× chunk)
        let row_ids_bytes = self.current_rows * std::mem::size_of::<i64>();
    /// What *is* held in memory:
                .as_any()
        };
        Ok(metadata)
    ) -> Result<(), Box<dyn std::error::Error>> {
            &self.max_sort_modes,
                reservation: MemoryReservation::new(
    ) -> Result<(u32, Option<Vec<i64>>), Box<dyn std::error::Error>> {
struct WriterState {
    ///
            let (crc_file, crc_handle) = CrcWriter::new(file);
                            // FFI layer will track it via write_pool().grow/shrink.
        };
    /// - `chunk_row_ids`: accumulated row ID vectors from all completed chunks
                            let mut writer = writer_arc.lock().unwrap();
        // If sort columns are configured, use eager sort-and-write path:
    /// Sort configuration.
                            // Reconcile: adjust reservation to actual delta reported by ArrowWriter
                let max = max_sort_modes.get(i).copied().unwrap_or(false);
            schema,
use crate::native_settings::NativeSettings;
        base_path: String,
        let (variant, crc_handle) = if !settings.sort_columns.is_empty() {
                index_name.clone(),
                log_debug!(
                );
                                    let file = File::open(&filename)?;
            chunk_paths,
                }
                            writer.write(&record_batch, &mut state.reservation)?;
                let options = arrow::compute::SortOptions {
        }
                                chunked_writer.finish(&mut reservation)?;
                                &filename,
        // Close and remove the trailing IPC staging file
        reservation.grow(row_ids_bytes);
    /// the chunk row limit is reached, reads back the IPC, sorts, writes as
            .map(|ids| ids.len() * std::mem::size_of::<i64>())
    index_name: String,
        reservation.shrink(sort_reserve);
            current_chunk_bytes: 0,
    /// Index name for writer properties.
    /// where the IPC file is read back and sorted — that's short-lived and freed
    schema::ROW_ID_COLUMN_NAME,
                Some(writer_generation),
            let _ = std::fs::remove_file(&ipc_path);
                }
        // Check if adding this batch would breach the memory threshold.
            return Ok(());
                            log_debug!("Writing RecordBatch to IPC staging file");
        if let Some((_, state)) = WRITERS.remove(&temp_filename) {
            completed_chunks: Vec::new(),
        array_address: i64,
                            log_debug!("CRC32 for file {}: {:#010x}", filename, crc32);
            "Successfully wrote final file: {} (crc32={:#010x})",
                let col_index = batch
            &combined,
            output_filename,
            &chunk_path,
        let ipc_writer = IpcFileWriter::try_new(file, &self.schema)?;
                let ids = &chunk_row_ids[0];
        unsafe {
            })
                            writer.write(&record_batch)?;
            temp_filename
    /// Paths of all completed sorted Parquet chunk files.
                };
    ) -> Result<Self, Box<dyn std::error::Error>> {
    }
            let sequential_ids =
                self.current_chunk_bytes += slice_bytes;
        let overall_start = std::time::Instant::now();
        drop(batches); // free memory before sort allocates
                            );
        }
                            let writer_arc = writer_arc.clone();
 * SPDX-License-Identifier: Apache-2.0
            }
            log_error!(
    fn new(
                    array.data_type()
        // Multiple chunks: k-way merge
            log_info!("finalize_sorted_chunks: no chunks, writing empty Parquet file");
                temp_filename
                        }
        self.open_new_ipc()?;
                let record_batch = RecordBatch::try_new(schema, struct_array.columns().to_vec())?;
        } else {
                    match Arc::try_unwrap(writer_arc) {
use arrow_ipc::writer::FileWriter as IpcFileWriter;
                }
            .columns()
        index_name: String,
            crc32
                            let before = writer.memory_size();
    total_rows: usize,
/// drops the writer, closes the file handle, and cleans up sort config.
                let mut mapping = vec![0i64; total];
            "create_writer called for file: {}, index: {}, schema_address: {}, sort_columns: {:?}, reverse_sorts: {:?}, nulls_first: {:?}, max_sort_modes: {:?}, writer_generation: {}",
                    pos += 1;
        } else {
                                    );
            .iter()
        let sort_reserve = self.current_chunk_bytes as usize * 2;
        let file = File::open(&filename)?;
        sort_columns: &[String],
        settings.nulls_first = nulls_first;
            );
            index_name,
            // Use the CRC computed when the chunk was written
                            let writer = mutex.into_inner().unwrap();
    fn ipc_staging_path(&self) -> String {
                                &settings.sort_columns,
            }
            "Metadata for {}: version={}, num_rows={}, num_row_groups={}",
        chunk_row_ids: &[Vec<i64>],
                writer_generation,
        reservation: &mut MemoryReservation,
            };
                .map(|i| row_id_array.value(i))
            None
        // If the batch itself fits within the threshold, write it directly.
    }
        max_sort_modes: Vec<bool>,
        for batch_result in reader {
                        WriterVariant::Parquet(writer_arc) => {
        Ok(())
        schema: Arc<arrow::datatypes::Schema>,
        );
    schema: Arc<arrow::datatypes::Schema>,
impl NativeParquetWriter {
    writer_generation: i64,
            },
                memory_threshold_bytes,
        Ok(RecordBatch::try_new(batch.schema(), sorted_columns?)?)
            ))
                .get(index_name)
    /// Returns the actual in-memory footprint of this writer's heap allocations.
            let WriterState {
                    nulls_first: nulls_first.get(i).copied().unwrap_or(false),
    /// Index of the next chunk (0-based).
}
        for entry in WRITERS.iter() {
                                &chunk_crcs,
        // write the new batch into a fresh IPC staging file.
    pub metadata: parquet::file::metadata::ParquetMetaData,
                settings.max_sort_modes.clone(),
    /// Tracked byte size of the current IPC staging file (approximated from
        reservation: &mut MemoryReservation,
            log_info!("Cleaned up writer entry for {}", temp_filename);
            );
        let combined = concat_batches(&self.schema, &batches)?;
                                temp_filename
lazy_static! {
use std::path::Path;
                    PoolBehavior::IgnoreLimit,
                &config,
        let path = self.ipc_staging_path();
    pub fn cleanup_writer(filename: &str) -> Result<(), Box<dyn std::error::Error>> {
                let len = std::cmp::min(rows_per_slice, num_rows - offset);
        // If the current chunk already has data and the combined size exceeds
            self.total_rows += batch.num_rows();
                    .schema()
        }
            let total = merge_output.mapping.len();
                                &settings.reverse_sorts,
    /// This does NOT include the transient peak during `flush_and_sort_chunk()`
use parquet::file::reader::{FileReader, SerializedFileReader};
        Ok(writer)
                                    Err(e.into())
    ///
        let arrow_schema = unsafe { FFI_ArrowSchema::from_raw(schema_address as *mut _) };
        log_debug!(
                        Ok(mutex) => {
            WriterPropertiesBuilder::build_with_generation(&config, writer_generation, &schema)
    /// close / going-red flow so that a writer left behind by a failed operation (e.g. an Arrow OOM
                                    }))
        if chunk_paths.is_empty() {
            Err("Writer not found".into())
    /// Finalize pre-sorted Parquet chunks: k-way merge them into the final file.
                                        "ERROR: Failed to close writer for temp file: {}",
        let temp_filename = Self::temp_filename(&filename);
                            }
    /// Removes the writer entry for `filename` from the registry without finalizing it, dropping the
            let writer = ArrowWriter::try_new(file, schema, Some(props))?;
            if let Some(ref mut w) = self.current_ipc_writer {
            "flush_and_sort_chunk: chunk_idx={}, current_chunk_bytes={}, current_rows={}, row_id_memory_size={}",
    sort_columns: Vec<String>,
        let mut merge_reservation = MemoryReservation::new(
            filename,
        })?;
            return Ok((crc32, row_id_mapping));
                                &mut reservation,
                    if orig_idx < total {
    /// Uses eager sort-and-write: writes batches to IPC staging, and when
            .to_string()
        path_prefix: String,
                    descending: reverse_sorts.get(i).copied().unwrap_or(false),
            return Ok(());
        log_info!(
        );
                }
                if self.current_chunk_bytes >= self.memory_threshold_bytes {
        Ok(total_memory)
    /// The IPC staging approach means record batch data lives on disk, not in memory.
            columns[idx] = Arc::new(sequential_ids);
                .map_err(|e| format!("Invalid encoding/compression config: {}", e))?;
                reservation.request(mapping_bytes)?;
    /// Build the temp filename by prepending "temp-" to the basename.
        writer_generation: i64,
                }
            output_filename
                            let mut writer = writer_arc.lock().unwrap();
            max_sort_modes,
        let sort_arrays: Vec<Arc<dyn arrow::array::Array>> = sort_columns
            .iter()
        );
///   Parquet chunk paths for k-way merge.
            filename,
                for (new_pos, &old_row_id) in ids.iter().enumerate() {
            chunk_row_ids: Vec::new(),
                flat_mapping[i] = i as i64;
                log_error!(
        let indices = arrow::array::UInt32Array::from(sort_indices);
        writer_generation: i64,
            // Build permutation from the single chunk's row IDs
    pub fn write_data(
    pub fn create_writer(
    crc_handle: Option<crate::crc_writer::CrcHandle>,
        // Build the flat permutation: result[original_row_id] = new_row_id
                Some(mapping)
        schema_address: i64,
    /// plus the incoming batch size would exceed this threshold, the current chunk
        let merge_duration = overall_start.elapsed();
            log_info!(
            // merge_output.mapping freed — release its share, flat_mapping remains tracked
            "write_data called for file: {} (temp: {})",
    /// underlying writer (which closes its file handle and releases its memory reservation).
        WRITERS.contains_key(&temp_filename)
        }
                .downcast_ref::<Int64Array>()
        }
                                temp_filename, total_rows, chunk_paths.len()
                .unwrap_or_default();
            &[],
                );
            WriterState {
        // Delete the IPC staging file and open a fresh one
            } else {
                    let orig_idx = old_row_id as usize;
                output_filename
            writer.finish()?;
        log_debug!(
        let temp_filename = Self::temp_filename(&filename);
            self.open_new_ipc()?;
    }
                    "ERROR: Array is not a StructArray, type: {:?}",
            reverse_sorts,
            let rows_per_slice =
            .map(|r| r.clone())
            current_ipc_writer: None,
            temp_filename,
    fn total_rows(&self) -> usize {
        let reader = SerializedFileReader::new(file)?;
        }
                ),
            let arrow_array = FFI_ArrowArray::from_raw(array_address as *mut _);
        Ok(())
/// batches can be cheaply read back for sorting — Arrow IPC is a raw
                    match &state.variant {
            filename, index_name, schema_address, sort_columns, reverse_sorts, nulls_first, max_sort_modes, writer_generation
        let temp_filename = Self::temp_filename(&filename);
///   exceed `memory_threshold_bytes`, reads the IPC file back, sorts in memory,
                        Ok(mutex) => {
        let temp_filename = Self::temp_filename(filename);
    variant: WriterVariant,
/// Path suffix for the intermediate Arrow IPC file used during sort-on-close.
 *
                "finalize_sorted_chunks: produced {} permutation entries for {}",
            // The batch alone exceeds the memory budget — slice it into pieces
    fn open_new_ipc(&mut self) -> Result<(), Box<dyn std::error::Error>> {
        schema: Arc<arrow::datatypes::Schema>,
            let memory_threshold_bytes = settings.get_sort_in_memory_threshold_bytes();
        if self.current_chunk_bytes >= self.memory_threshold_bytes {
        reservation: &mut MemoryReservation,
                            log_error!(
}
                flat_mapping.len(),
            // recovery, since recovery re-creates a writer for the same generation/file — remove the
        );
        index_name: &str,
        let merge_output = merge_sorted_with_pool(
                            let chunked_writer = mutex.into_inner().unwrap();
                "ERROR: Invalid schema address (null pointer) for file: {}",
        sort_columns: &[String],
            "finalize_writer called for file: {} (temp: {})",
            metadata.file_metadata().num_rows(),
                if let Some(ref mut w) = self.current_ipc_writer {
            merge_duration
            output_filename,
                            // Reserve 3× batch as estimate — ArrowWriter encoding may temporarily
                                crc32,
            &self.sort_columns,
                    }
            "writer:k_way_merge",
                        }
            // A stale entry survived a prior failure (e.g. an Arrow OOM that failed the shard before
        settings.max_sort_modes = max_sort_modes;
 * this file be licensed under the Apache-2.0 license or a
use arrow::row::{RowConverter, SortField};
                                        "Successfully closed temp writer for: {}",
            let arrow_schema = FFI_ArrowSchema::from_raw(schema_address as *mut _);
        let file = File::create(output_filename)?;
        batch: &RecordBatch,
            self.flush_and_sort_chunk(reservation)?;
                    match Arc::try_unwrap(writer_arc) {
}
            let props = WriterPropertiesBuilder::build_with_generation(
                Some(crc_handle),
    ) -> Result<parquet::file::metadata::ParquetMetaData, Box<dyn std::error::Error>> {
    /// Direct Parquet writer — used when no sort columns are configured.
            log_error!(
                path.file_name().unwrap().to_str().unwrap()
/// The underlying writer — either direct Parquet or Arrow IPC staging.
            // Rewrite ___row_id to sequential 0..N so the chunk file is self-consistent
    ) -> Result<RecordBatch, Box<dyn std::error::Error>> {
            RecordBatch::try_new(self.schema.clone(), columns)?
            self.chunk_idx, self.current_chunk_bytes, self.current_rows, self.memory_size()
            "finalize_sorted_chunks: DONE file={}, chunks={}, merge_duration={:?}",
                let slice = batch.slice(offset, len);
        } else {
                    w.write(&slice)?;
    ) -> Result<u32, Box<dyn std::error::Error>> {
        let mut total_memory = 0;
            reservation.shrink(sort_reserve);
    /// same generation/file.
            log_error!("ERROR: Invalid FFI addresses for file: {}", temp_filename);
            drop(merge_output);
    }
    /// Parallel with `sort_columns`: `true` = MAX reduction, `false` = MIN.
    chunk_row_ids: Vec<Vec<i64>>,
/// dump of in-memory Arrow buffers with minimal framing overhead.
        writer_generation: i64,
        );
                        Err(_) => {
        Ok((crc32, row_id_mapping))
                            Err("IPC Writer still in use".into())
    pub fn has_writer(filename: &str) -> bool {
            for chunk_ids in chunk_row_ids {
    writer_generation: i64,
        nulls_first: &[bool],
    /// before the method returns.
            let index_name = settings.index_name.as_deref().unwrap_or("");
        max_sort_modes: &[bool],
                            if let Some(ref mapping) = row_id_mapping {
                crc_handle,
            .schema
        }
        );
            // Nothing to sort, just reopen
            while offset < num_rows {
        self.chunk_row_ids
                                    log_info!(
        }
        filename: String,
        // At finalize, only a k-way merge is needed (no IPC re-read).
        let sorted_columns: Result<Vec<_>, _> = batch
            .to_string_lossy()
            let file = File::create(output_filename)?;
                            }
        let rows = converter.convert_columns(&sort_arrays)?;
use lazy_static::lazy_static;
                                index_name,
                            let file = File::open(&filename)?;
    /// Chunks are already sorted (done eagerly during write), so no sort needed here.
        self.current_rows = 0;
                settings.sort_columns.clone(),
        );
                reduced_sort_array(batch.column(col_index), max)
    ) -> Result<Option<FinalizeResult>, Box<dyn std::error::Error>> {
        max_sort_modes: Vec<bool>,
                            let parquet_metadata = reader.metadata().clone();
            let array: Arc<dyn arrow::array::Array> = arrow::array::make_array(array_data);
    }
                            // Clean up sorted chunk files only after successful finalization.
use arrow::compute::{concat_batches, take};
    /// Writer generation propagated into Parquet file metadata for each chunk.
            sort_columns,
                            let total_rows = chunked_writer.total_rows();
            writer_generation,
            let mut pos = 0usize;
}
const IPC_STAGING_SUFFIX: &str = ".arrow_ipc_staging";
        let row_id_mapping = if !merge_output.mapping.is_empty() && !chunk_row_ids.is_empty() {
            let crc32 = chunk_crcs.first().copied().unwrap_or(0);
            .get(index_name)
            sorted_batch
                                "ERROR: Writer still in use for temp file: {}",
            let base_path = format!("{}{}", temp_filename, IPC_STAGING_SUFFIX);
        }
                crc_handle,
            self.flush_and_sort_chunk(reservation)?;
            .enumerate()
                            Err("Writer still in use".into())
            )
                                reservation.shrink(mapping.len() * std::mem::size_of::<i64>());
    /// Arrow schema shared across all chunks.
                            }
        let crc32 = NativeParquetWriter::write_final_file(
                    record_batch.num_columns()
        let mut writer = Self {
        chunk_paths: &[String],
                if let Some(mut state) = WRITERS.get_mut(&temp_filename) {
        if batches.is_empty() {
            let row_id_array = sorted_batch
        // Write sorted chunk as Parquet
            // that each fit within the threshold, flushing after each piece.
    ) -> Result<(), Box<dyn std::error::Error>> {
        // Release sort working memory (read-back + sorted copy no longer alive)
                                metadata: parquet_metadata,
    ) -> Result<(), Box<dyn std::error::Error>> {
    /// Batches are written as raw Arrow IPC; on close they are read back,
            sort_columns,
        if self.current_rows > 0 {
use arrow_ipc::reader::FileReader as IpcFileReader;
    }
        let converter = RowConverter::new(sort_fields)?;
                            );
            let mut flat_mapping = vec![0i64; total];
            } = state;
    /// Memory budget (bytes) for in-memory sort. When the IPC staging file size
    static ref WRITERS: DashMap<String, WriterState> = DashMap::new();
        let crc32 = crc_handle.crc32();
        index_name: &str,
        }
        nulls_first: Vec<bool>,
    pub row_id_mapping: Option<Vec<i64>>,
                                    let reader = SerializedFileReader::new(file)?;
            .map(|(i, col_name)| {
            metadata.file_metadata().version(),
            "finalize_sorted_chunks: merging {} pre-sorted chunks for {}",
        &mut self,
}
                                "ERROR: IPC Writer still in use for temp file: {}",
                            state.reservation.reconcile(estimated, actual);
                        WriterVariant::Ipc(writer_arc) => {
    }
                                }
        filename: String,
        reverse_sorts: Vec<bool>,
/// Hybrid IPC staging + eager sort writer.
        let file = File::open(&ipc_path)?;
                            let batch_bytes = record_batch.get_array_memory_size();
                offset += len;
        let chunk_path = self.sorted_chunk_path(self.chunk_idx);
        sort_columns: Vec<String>,
            &final_batch,
        {
use parquet::arrow::ArrowWriter;
            (
    chunk_idx: usize,
        // Capture original row IDs for permutation building, then rewrite to sequential 0..N
                            state.reservation.reserve_estimated(estimated)?;
    }
        // Release sort memory
            }
            temp_filename
            writer.close()?;
    /// CRC32 values for each completed sorted Parquet chunk file.
    /// is flushed (sorted and written as Parquet) before accepting the new batch.
        index_name: String,
                    log_error!("ERROR: No writer found for temp file: {}", temp_filename);
        let ipc_path = self.ipc_staging_path();
                }
            Some(flat_mapping)
        let schema = Arc::new(arrow::datatypes::Schema::try_from(&arrow_schema)?);
    pub fn get_file_metadata(
    fn finalize_sorted_chunks(
        if chunk_paths.len() == 1 {
        )?;
    /// Finalize: flush remaining IPC data (sort + write) and return chunk paths + row IDs + CRCs.
    pub fn get_filtered_writer_memory_usage(
            WRITERS.remove(&temp_filename);
                .expect("___row_id column must be Int64");
            .iter()
                            // Detach mapping from reservation before handing to FFI/Java.
        let mut sort_indices: Vec<u32> = (0..batch.num_rows() as u32).collect();
            let mut columns = sorted_batch.columns().to_vec();
        }
        // Read back the IPC file (still hot in page cache since we just wrote it)
                variant,
        batch: &RecordBatch,
        reservation.request(sort_reserve)?;
        nulls_first: Vec<bool>,
    }
            return Ok((0, None));
    /// sorted Parquet chunk, then starts a new IPC file. At finalize, only
            chunk_paths.len(),
                                        metadata: parquet_metadata,
            .map(|col| take(col.as_ref(), &indices, None))
        }
            })
use crate::crc_writer::CrcWriter;
                                &settings.max_sort_modes,
                .column(idx)
            self.schema.clone(),
            PoolBehavior::IgnoreLimit,
                            )?;
    fn write_final_file(
                "Stale writer entry already exists for file: {} — removing it before re-create (likely a prior failed shard / Arrow OOM)",
            .collect::<Result<Vec<_>, Box<dyn std::error::Error>>>()?;
            let file = File::create(&temp_filename)?;
    }
/// - When the accumulated chunk byte size plus the incoming batch size would
            if entry.key().starts_with(&path_prefix) {
    /// Flat row ID mapping where mapping[original_row_id] = new_row_id.
            .join(format!(
            )
        } else {
    /// Idempotent: returns `Ok(())` whether or not an entry existed. Called by the shard
            reverse_sorts,
        batch: &RecordBatch,
    /// Returns true if a writer is currently open for the given filename.
                            log_info!(
        let _ = std::fs::remove_file(&self.ipc_staging_path());
        let temp_filename = Self::temp_filename(filename);
                base_path,
        }
        };
    /// Present only when sort columns were configured.
}
    Parquet(Arc<Mutex<ArrowWriter<CrcWriter<File>>>>),
            format!("Streaming merge failed: {}", e).into()
    reverse_sorts: Vec<bool>,
                mut reservation,
                writer_generation,
                    let orig_idx = original_row_id as usize;
                                        temp_filename
            )
                settings,
            .map(|r| r.clone())
use crate::merge::{
 */
        let mut batches: Vec<RecordBatch> = Vec::new();
    pub crc32: u32,
    }
use native_bridge_common::memory_pool::{MemoryReservation, PoolBehavior};
                                &chunk_row_ids,
        let mut settings: NativeSettings = SETTINGS_STORE
        };
                            let (crc32, row_id_mapping) = Self::finalize_sorted_chunks(
        let reader = IpcFileReader::try_new(file, None)?;
            // Reserve 2× mapping: merge_output.mapping (alive) + flat_mapping (about to allocate)
/// When sort columns are configured, the IPC variant is used so that
        filename: String,
            for i in 0..total {
            total_rows: 0,
                for &original_row_id in chunk_ids {
        mut self,
            let array_data = arrow::ffi::from_ffi(arrow_array, &arrow_schema)?;
            memory_threshold_bytes,
            }
        chunk_crcs: &[u32],
                    }
                            let writer_arc = writer_arc.clone();
            .position(|f| f.name() == ROW_ID_COLUMN_NAME);
/// Bundles all per-writer resources so a single `DashMap::remove` atomically
                        }
                Err("Expected struct array from VectorSchemaRoot".into())
                                temp_filename
            self.flush_and_sort_chunk(reservation)?;
                settings,
                    .index_of(col_name)
            // Chunk finalization merges freshly written chunks; no deletes apply here.
                writer_generation,
        settings.reverse_sorts = reverse_sorts;
/// - At finalize: flushes remaining IPC data (sort + write), returns sorted
        path.parent()
            .unwrap_or_default();
                    "parquet_writer",
        memory_threshold_bytes: u64,
        use arrow::array::Int64Array;
                WriterVariant::Ipc(Arc::new(Mutex::new(chunked_writer))),
#[derive(Debug)]
    /// Base path for staging/chunk files.
        log_debug!(
    /// Row count in the current IPC staging file.
            .collect();
        // Close the IPC writer
                // Flush after each slice that fills the budget.
};
                            let reader = SerializedFileReader::new(file)?;
    /// a k-way merge is needed.
                None
                    Ok(())
            writer_generation,
            return Err("Invalid schema address".into());
        WRITERS.insert(
        schema_address: i64,
            let config = SETTINGS_STORE
        Ok(())
        // Safety net: flush if we ended up at or above the threshold.
    /// the next `create_writer` — which is what recovery does when it re-creates a writer for the
        self.total_rows
            if let Some(struct_array) = array.as_any().downcast_ref::<arrow::array::StructArray>() {
            reservation.shrink(mapping_bytes);
        log_debug!(
                &schema,
        self.base_path.clone()
    /// Unified per-writer registry. Keyed by temp filename.
        if let Some(mut writer) = self.current_ipc_writer.take() {
                WriterVariant::Parquet(writer_arc) => {
            chunk_paths.len(),
enum WriterVariant {
///   IPC file.
    reservation: MemoryReservation,
    fn flush_and_sort_chunk(
    /// Sort a batch using RowConverter: converts sort columns into compact
                                Ok(_) => {
    /// Arrow IPC staging writer — used when sort columns are configured.
                &schema,
use std::fs::File;
                                let _ = std::fs::remove_file(path);
        }
    fn sorted_chunk_path(&self, idx: usize) -> String {
            current_rows: 0,
                                    let parquet_metadata = reader.metadata().clone();
            nulls_first,
        }
            let writer = ArrowWriter::try_new(crc_file, schema, Some(props))?;
                WriterVariant::Parquet(Arc::new(Mutex::new(writer))),
                            let estimated = batch_bytes * 3;
        let file = File::create(&path)?;
            "finalize_sorted_chunks: k-way merge complete: {} chunks merged, duration={:?}",
                        }
                                writer_generation,
    }
        self.chunk_crcs.push(crc32);
                        flat_mapping[orig_idx] = merge_output.mapping[pos];
        )?;
    ) -> Result<(), Box<dyn std::error::Error>> {
            if batch.num_rows() > 0 {
                    self.flush_and_sort_chunk(reservation)?;
            Some(self.writer_generation),
                std::cmp::max(1, (self.memory_threshold_bytes / bytes_per_row) as usize);
 * The OpenSearch Contributors require contributions made to
        Ok(crc32)
                                row_id_mapping,
                                    // Parquet variant is used for non-sorted data; just rename.
    /// For single chunk, just rename. For empty, write empty Parquet.
                w.write(batch)?;
            &self.index_name,
        reservation: &mut MemoryReservation,
use arrow::ffi::{FFI_ArrowArray, FFI_ArrowSchema};
use dashmap::DashMap;
                self.total_rows += len;
        }
 * compatible open source license.
    merge_sorted_with_pool,
            self.current_chunk_bytes += incoming_batch_bytes;
                                    log_error!(
            log_error!("ERROR: Writer not found for temp file: {}", temp_filename);
use crate::writer_properties_builder::WriterPropertiesBuilder;
        // accumulate batches in memory, sort each chunk, write as Parquet.
            metadata.num_row_groups()
        let row_id_col_idx = self
            write_pool(),
    heap::{reduced_sort_array, reduced_sort_type},
                                    std::fs::rename(&temp_filename, &filename)?;
                .collect();
    pub fn finalize_writer(
        }
                settings.nulls_first.clone(),
        max_sort_modes: &[bool],
            let num_rows = batch.num_rows();
            }
        log_info!(
        if (schema_address as *mut u8).is_null() {
    fn finish(
                            // On failure, chunks are preserved as they may be the only copy of the data.
    }
                                "Successfully closed sorting chunked writer for: {}, total_rows={}, chunks={}",
                                        temp_filename
                let mapping_bytes = total * std::mem::size_of::<i64>();
        if self.current_chunk_bytes > 0
                            let (chunk_paths, chunk_row_ids, chunk_crcs) =
            nulls_first,
        Ok((self.completed_chunks, self.chunk_row_ids, self.chunk_crcs))
        log_debug!(
            // the writer could be finalized). Rather than reject — which permanently blocks shard
    /// byte-comparable rows, sorts indices by comparing those rows, then
    nulls_first: Vec<bool>,
        settings.index_name = Some(index_name.clone());
            } else {
    pub(crate) fn sort_batch(
                settings.reverse_sorts.clone(),
        SETTINGS_STORE.insert(index_name.clone(), settings.clone());
        let metadata = reader.metadata().clone();
                Ok(SortField::new_with_options(data_type, options))
                        }
        format!("{}.sorted_chunk_{}.parquet", self.base_path, idx)
        log_info!(
        let mut writer = ArrowWriter::try_new(crc_file, schema, Some(props))?;
    fn memory_size(&self) -> usize {
    pub static ref SETTINGS_STORE: DashMap<String, NativeSettings> = DashMap::new();
                    if orig_idx < total && pos < total {
            chunk_idx: 0,
    ///
                    .map_err(|_| format!("Sort column '{}' not found in schema", col_name))?;
        if self.current_ipc_writer.is_none() {
                let schema = Arc::new(arrow::datatypes::Schema::new(struct_array.fields().clone()));
        );
            )?;
        self.current_chunk_bytes = 0;
                batches.push(batch);
        reverse_sorts: &[bool],
            .enumerate()
        }
            self.current_rows += batch.num_rows();
                            log_error!(
/// - Writes incoming batches to an IPC file (cheap, no memory accumulation).
                &settings,
        settings.sort_columns = sort_columns;
        )
            let bytes_per_row = incoming_batch_bytes / num_rows as u64;
            let props = WriterPropertiesBuilder::build_with_generation(
        sort_columns: Vec<String>,
        nulls_first: &[bool],
        let (crc_file, crc_handle) = CrcWriter::new(file);
            let chunked_writer = SortingChunkedWriter::new(
        let config = SETTINGS_STORE
                self.current_rows += len;
                let slice_bytes = slice.get_array_memory_size() as u64;
        self.completed_chunks.push(chunk_path);
            .iter()
        let crc32 = merge_output.crc32;
                Int64Array::from_iter_values((0..sorted_batch.num_rows() as i64).map(|x| x));
        let sort_fields: Vec<SortField> = sort_columns
                    }
    ) -> Result<(Vec<String>, Vec<Vec<i64>>, Vec<u32>), Box<dyn std::error::Error>> {
            // Compute how many rows fit within the threshold (at least 1 to make progress).
    chunk_crcs: Vec<u32>,
                        Err(_) => {
        &mut self,
        );
        let _ = std::fs::remove_file(&ipc_path);
        writer_generation: Option<i64>,
            log_info!("finalize_sorted_chunks: single chunk, renaming to final output");
            );
        let sorted_batch = NativeParquetWriter::sort_batch(
            .fields()
pub struct NativeParquetWriter;
        self.chunk_idx += 1;
            reservation.request(mapping_bytes * 2)?;
        if let Some(mut writer) = self.current_ipc_writer.take() {
        writer.write(batch)?;
            self.chunk_row_ids.push(ids);
use crate::{log_debug, log_error, log_info};
    completed_chunks: Vec<String>,
            &self.reverse_sorts,
                                    Ok(Some(FinalizeResult {
    /// the Arrow array memory sizes of batches written so far).
                                schema.clone(),
                Some(writer_generation),
    /// Close the current IPC file, read it back, sort, write as sorted Parquet chunk.
                            for path in &chunk_paths {
        let path = Path::new(filename);
impl SortingChunkedWriter {
    }
pub struct FinalizeResult {
            && self.current_chunk_bytes + incoming_batch_bytes > self.memory_threshold_bytes
                                &chunk_paths,
                                Err(e) => {
                let data_type = reduced_sort_type(batch.schema().field(col_index).data_type());
        filename: String,
    /// Current IPC writer for staging incoming batches.
            // reservation) and proceed to create a fresh writer.
            let batch = batch_result?;
                filename
            }
            max_sort_modes,
            // Single chunk: just rename to final output (already sorted Parquet)
                    record_batch.num_rows(),
        } else {
        log_debug!(
            index_name,
            let ids: Vec<i64> = (0..row_id_array.len())
                                    let crc32 = crc_handle.map(|h| h.crc32()).unwrap_or(0);
    }
            .iter()
        writer.open_new_ipc()?;
            merge_duration
                // Reserve for permutation Vec<i64> before allocating
    ) -> Result<usize, Box<dyn std::error::Error>> {
                let col_index = batch.schema().index_of(col_name)?;
        // the budget, flush (sort + write) the current chunk first, then
    /// reorders all columns via take.
    fn temp_filename(filename: &str) -> String {
        Ok(())
        Ok(())
    base_path: String,
    Ipc(Arc<Mutex<SortingChunkedWriter>>),
                        mapping[orig_idx] = new_pos as i64;
        if WRITERS.contains_key(&temp_filename) {
        );
    /// Row IDs captured from each sorted chunk (for permutation building).
        let incoming_batch_bytes = batch.get_array_memory_size() as u64;
    ///   (retained until `finish()` for permutation building).
            // stale entry (dropping the old writer, closing its file handle and releasing its
                } else {
            &self.nulls_first,
            .collect::<Result<Vec<_>, _>>()?;
                            drop(writer);
    }
                            );
                .map(|r| r.clone())
    current_rows: usize,
        output_filename: &str,
            .sum()
    }
                    "Created RecordBatch with {} rows and {} columns",
                                    log_debug!("CRC32 for file {}: {:#010x}", filename, crc32);
///   writes as a sorted Parquet chunk, deletes the IPC file, and starts a new
        reverse_sorts: Vec<bool>,
        if incoming_batch_bytes <= self.memory_threshold_bytes {
                    }
        drop(combined); // free unsorted data
            match variant {
                }
            .get(&index_name)
    }
        schema: Arc<arrow::datatypes::Schema>,
            .map(|(i, col_name)| {
        writer.close()?;
    /// Total rows written across all chunks.
                    Err("Writer not found".into())
            filename,
                schema,
    }
                            match writer.close() {
        .map_err(|e| -> Box<dyn std::error::Error> {
                        }
}
                None,
                            let actual = writer.memory_size().saturating_sub(before);
                    write_pool(),
            chunk_paths.len(),
            return Err("Invalid FFI addresses (null pointers)".into());
use crate::memory::write_pool;
            .unwrap_or_default();
    current_ipc_writer: Option<IpcFileWriter<File>>,
                    }
