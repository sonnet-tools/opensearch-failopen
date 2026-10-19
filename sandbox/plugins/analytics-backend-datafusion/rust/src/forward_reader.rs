        async_reader: Box<dyn AsyncFileReader + Send>,
                "requested skip of {to_skip} rows but skipped {skipped}"
}
//! [`ParquetForwardBatchReaderFactory`]. Repeated (multi-valued) columns are not
        chunk_reader: T,
use std::sync::Arc;
//! object-store [`AsyncFileReader`] (remote/tiered storage), selected by
    /// store that owns the file. `None` continues through DataFusion's reader factory.
                    )));
    pub fn page_row_count(&self, target_row: usize) -> ParquetResult<usize> {
        self.row_count
                if skipped != to_skip {
        }
                .set_column_index(metadata.column_index().cloned())
use datafusion::parquet::file::reader::{ChunkReader, Length};
    }
    let projected_columns = (0..schema.num_columns())
        let batch = self.reader.read_next_batch(rows_to_read)?.ok_or_else(|| {
        let column: ArrayRef = Arc::new(Int32Array::from(values));
            ArrowParquetError::General(format!("Parquet reader exhausted before row {target_row}"))
            }
        let arrow_metadata =
            Arc::clone(&self.metadata),
            self.position = target_row + rows_to_read;
            ArrowParquetError::General(format!("negative row count for row group {row_group_idx}"))
    let column_index = metadata.column_index();
    ///
    /// Current physical row position of the retained Arrow reader.
}
use bytes::Bytes;
    pages: Vec<ParquetForwardPage>,
        let reader =
    /// rows beyond the end of the file return an error.
            ParquetRecordBatchReaderBuilder::new_with_metadata(chunk_reader, arrow_metadata)
        let mut writer =
    pub fn rows_remaining_in_page(&self, target_row: usize) -> ParquetResult<usize> {
    fn ints(batch: &RecordBatch) -> Vec<Option<i32>> {
    }
            let file = std::fs::File::open(path)
    ArrowReaderMetadata, ArrowReaderOptions, ParquetRecordBatchReader,
            .finish_non_exhaustive()
    }
impl ChunkReader for AsyncFileChunkReader {
        self
    use datafusion::parquet::file::properties::WriterProperties;
 */
            "ParquetForwardBatchReader does not support repeated columns yet".to_string(),
    projection: &ProjectionMask,
            file_meta.schema_descr_ptr(),
                    "OffsetIndex missing for row group {row_group_idx}, column {column_idx}"
use datafusion_datasource::PartitionedFile;
        // Rows 3,4,5 form an entirely-null page; reading it returns nulls and the
    projection: ProjectionMask,
                    return Err(ArrowParquetError::General(format!(
use datafusion::parquet::arrow::arrow_reader::{
/// [`Self::read_batch_at`] only moves forward: complete pages between the
        Ok(Self {
            local_file: None,
            return Err(ArrowParquetError::General(format!(
#[cfg(test)]
        let rows_to_read = max_rows
        }
///
        let projection = ProjectionMask::leaves(metadata.file_metadata().schema_descr(), [0]);
        self.pages
                    ArrowParquetError::General(format!(
            .set_data_page_row_count_limit(3)
        );
/// metadata, and projection.
    pub fn with_local_file(mut self, path: Option<PathBuf>) -> Self {
    };
    // Walk every row group, appending one page entry per data page to `pages`.
use datafusion::arrow::record_batch::{RecordBatch, RecordBatchReader};
                row_count: end - start,
//!
            file_meta.column_orders().cloned(),
                page_idx < index.num_pages() as usize && index.is_null_page(page_idx)
    }
            .map(|i| column.is_valid(i).then(|| column.value(i)))
            projected_columns.len()
        let page = self.page_at(target_row)?;
                "forward batch size must be greater than zero".to_string(),
        let mut reader = reader_for(values);
    ///
            ParquetMetaDataBuilder::new(inflated_file_meta)
            return Err(ArrowParquetError::General(
            )));
            )));
                        "negative first row for row group {row_group_idx}, page {}",
 * The OpenSearch Contributors require contributions made to
            .pages
        self.position = self.physical_position;
            .build()
    pub fn read_batch_at(
    if schema.column(column_idx).max_rep_level() > 0 {
#[derive(Debug, Clone)]
                (page_idx < index.num_pages() as usize)
                target_row >= page.first_row && target_row < page.first_row + page.row_count
        .collect::<Vec<_>>();
        self.file_len
        T: ChunkReader + 'static,
        let inflated_file_meta = FileMetaData::new(
        batch_size: usize,
    let schema = metadata.file_metadata().schema_descr();
                    ))
            reader_factory,
impl Length for AsyncFileChunkReader {
use std::fmt::Debug;
        let column = batch
    ) -> ParquetResult<Self> {
    /// Opens a forward reader over the single column of a fixture file.
        let metadata = ParquetMetaDataReader::new()
    /// First logical row of the page within the file.
    #[test]
    type T = Cursor<Bytes>;
                let skipped = self.reader.skip_rows(to_skip)?;
/// current position and the requested row are skipped without fetching or
            );
    fn reader_for(values: Vec<Option<i32>>) -> ParquetForwardBatchReader {
    for (row_group_idx, row_group) in metadata.row_groups().iter().enumerate() {
    pub fn try_new_with_chunk_reader<T>(
    fn len(&self) -> u64 {
            ArrowParquetError::General("Parquet row count does not fit in usize".to_string())
            )));
        let inflated = Arc::new(
            pages,
                let to_skip = page_end - self.physical_position;
            true,
            .create_reader(0, self.file.clone(), None, &metrics)
        );
    }
        row_group_start += row_group_rows;
        return Err(ArrowParquetError::General(
            .and_then(|row_group| row_group.get(column_idx))
    where
            ArrowReaderMetadata::try_new(Arc::clone(&metadata), ArrowReaderOptions::new())?;
        // metrics, so pass a throwaway set.
//! path. Page bounds come from the `OffsetIndex`; all-null pages are recognised
                Arc::clone(&self.metadata),
    /// decoding.
        assert_eq!(reader.position(), 8);
    /// Creates a factory whose readers use the supplied DataFusion file reader
};
            .build();
use parking_lot::Mutex;
    }
            physical_position: 0,
        );
                self.projection.clone(),
            .parse_and_finish(&file)
//! complete pages between the current position and the requested row are skipped
/// page reader. Calls are serialized because `AsyncFileReader` takes `&mut
            *slot = None;
    }
            .map_err(|error| ArrowParquetError::External(Box::new(error)))?;
                ArrowParquetError::General(format!("OffsetIndex does not contain row {target_row}"))
        metadata: Arc<ParquetMetaData>,
            )));
    pub fn new(
            file_meta.version(),
            let page_end = page_containing_row.first_row + page_containing_row.row_count;
            "{error}"
impl Debug for ParquetForwardBatchReader {
        let metrics = ExecutionPlanMetricsSet::new();
        }
/// self`, matching the single-threaded cursor contract.
            self.batch_size,
        let index = self
    use datafusion::arrow::array::{Array, ArrayRef, Int32Array};
    let column_idx = *column_idx;
            "the file must be exhausted after its final page"
        if let Some(path) = self.local_file.as_ref() {
use datafusion::datasource::physical_plan::parquet::ParquetFileReaderFactory;
            file_meta.key_value_metadata().cloned(),
        ArrowParquetError::General("ParquetForwardBatchReader requires an OffsetIndex".to_string())
        if target_row < self.physical_position {
        let projection = ProjectionMask::leaves(inflated.file_metadata().schema_descr(), [0]);
        if target_row < self.position {
}
//! `ProjectionMask` naming that column, the decode batch size, and the byte
            return Ok(None);
use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
    }
        assert_eq!(ints(&batch), vec![Some(6), Some(7)]);
    physical_position: usize, // deviates from position for null rows
            .with_page_index_policy(PageIndexPolicy::Required)
}
/// remote/tiered storage.
    ) -> ParquetResult<Option<RecordBatch>> {
    use super::*;
            ParquetForwardBatchReader::try_new_with_chunk_reader(file, inflated, projection, 4096)
                .build(),
            .downcast_ref::<Int32Array>()
    }
        runtime: Arc<Runtime>,
            inflated_rows,
            DataType::Int32,
            .row_group(0)
        let page_containing_row = self.page_at(target_row)?.clone();
pub struct ParquetForwardPage {
    }
            metadata,
            let start = usize::try_from(location.first_row_index).map_err(|_| {
        let locations = &offset_index
            .ok_or_else(|| {
                }
    /// Resolving the path is the store's job, not this module's: only a store backed by the local
            };
        let mut reader = dense_reader();
                Some(next) => usize::try_from(next.first_row_index).map_err(|_| {
                "backward seek from {} to {target_row} is not supported",
    /// factory and cached Parquet metadata.
use datafusion::parquet::errors::{ParquetError as ArrowParquetError, Result as ParquetResult};
        assert!(reader.read_batch_at(1, 1).is_err());
    /// reader (remote/tiered storage).
        // physical reader skips past it.
            position: 0,
    position: usize,
    };
                .fields()
    }
            self.file.object_meta.size,
        let row_count = usize::try_from(metadata.file_metadata().num_rows()).map_err(|_| {
        let mut reader = dense_reader();
            .get(index)
        metadata: Arc<ParquetMetaData>,
    {
    }
    }
    /// Skips to `target_row` and decodes the next Arrow batch, clamped to the end
            .reader_factory
    }
        let chunk_reader = AsyncFileChunkReader {
    }
    }
use datafusion::parquet::arrow::async_reader::AsyncFileReader;
        assert_eq!(ints(&batch), vec![Some(2)]);
                .map(|field| new_null_array(field.data_type(), rows_to_read))
            continue;
        // Row groups of 8 and pages of 3 leave the last row in its own page, [19, 20). Nulling it
}
            batch_size,
}
        // with the reader, which would decode every later row from the wrong offset.
    /// Number of rows in the page.
        let mut reader = dense_reader();
        let mut reader = reader_for(values);
    #[test]
    /// (a local file), reusing Parquet metadata already loaded by DataFusion.
            let end = match locations.get(page_idx + 1) {
        metadata: Arc<ParquetMetaData>,
        let row_group_rows = usize::try_from(row_group.num_rows()).map_err(|_| {
        }
 *
                .collect();
                .set_offset_index(metadata.offset_index().cloned())
        let file = tempfile::tempfile().unwrap();
        })?;
//! `ParquetMetaData` (footer plus the page index for the projected column), the
    }
        let pages = projected_pages(&metadata, &projection)?;
    pub fn row_count(&self) -> usize {
//! supported yet.
        FileMetaData, PageIndexPolicy, ParquetMetaDataBuilder, ParquetMetaDataReader,
            }
    /// of `target_row`'s page.
            let columns = schema
            .field("page_count", &self.pages.len())
            .filter(|index| !index.page_locations.is_empty())
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
        file: PartitionedFile,
        ParquetForwardBatchReader::try_new_with_chunk_reader(file, metadata, projection, 4096)
                ArrowParquetError::General(format!(
            projection,
                all_null,
    /// rows, OffsetIndex + ColumnIndex enabled) and returns it with its metadata.
        Self::try_new_with_chunk_reader(chunk_reader, metadata, projection, batch_size)
        projection: ProjectionMask,
}
        }
        return Err(ArrowParquetError::General(format!(
    pub fn open(&self) -> ParquetResult<ParquetForwardBatchReader> {
    /// filesystem can name a descriptor, and only it knows how an object path maps onto one.
        // A footer that claims more rows than the pages hold: 8 rows are written, then the row group
        }
        let end = start
    /// a DataFusion object-store reader).
    #[test]
pub struct ParquetForwardBatchReader {
        self.position
///
) -> ParquetResult<Vec<ParquetForwardPage>> {
/// [`Self::open`] uses a synchronous retained file descriptor when the file
use tokio::runtime::Runtime;
                .unwrap();
        for (page_idx, location) in locations.iter().enumerate() {
            .set_max_row_group_row_count(Some(8))
        max_rows: usize,
        Self {
        if target_row > self.row_count {
        // then runs out of data. The skip must fail rather than leave `physical_position` out of step
            .field("position", &self.position)
        let schema = Arc::new(Schema::new(vec![Field::new(
    pub first_row: usize,
    // TODO: add support for repeated columns
        if target_row == self.row_count {
        if max_rows == 0 {
/// Reusable factory for independent forward readers over the same file,
fn projected_pages(
    ) -> ParquetResult<Self>
                ArrowParquetError::General(format!(
            .unwrap();
//! Reads a single projected column forward-only over one retained Arrow reader:
        let (file, metadata) = write_fixture((0..8).map(Some).collect());
                self.row_count
/// non-empty row group. Repeated (multi-valued) columns are rejected until the
 * compatible open source license.
    fn dense_reader() -> ParquetForwardBatchReader {
}
        }
    pub fn position(&self) -> usize {
        assert!(reader.read_batch_at(20, 1).unwrap().is_none());
        assert_eq!(ints(&batch), vec![None, None, None]);
    Ok(pages)
    use datafusion::parquet::file::metadata::{
        // of the file - the boundary where a short skip would be reported if one were possible.
        )]));
        };
        ));
                    "negative first row for row group {row_group_idx}, page {page_idx}"
    /// Whether every value in the page is null, so it can be satisfied without
        self.physical_position = target_row + batch.num_rows();
    // the caller; `row_group_start` tracks the file-absolute first row of each row group.
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
    local_file: Option<PathBuf>,
    }
        target_row: usize,
            return Err(ArrowParquetError::General(format!(
        Ok(page.first_row + page.row_count - target_row)
//! source. [`ParquetForwardBatchReaderFactory::open`] is therefore also the reset
        Ok(Some(batch))
        )
    metadata: &ParquetMetaData,
        }
    fn target_row_at_row_count_returns_none() {
        // and file counts are inflated to 12, stretching the last page to [6, 12). Skipping to row 9
    pub all_null: bool,
            reader: Mutex::new(async_reader),
impl ParquetForwardBatchReader {
/// exists locally, and otherwise builds a DataFusion object-store reader for
            })?
        batch_size: usize,
/// non-empty row group so Arrow can request whole page ranges lazily.
            return ParquetForwardBatchReader::try_new_with_chunk_reader(
                        "requested all-null page skip of {to_skip} rows but skipped {skipped}"
            let all_null = page_statistics.is_some_and(|index| {
            .into_builder()
    fn an_all_null_final_page_skips_to_end_of_file_without_a_short_skip() {
                "page range {start}..{end} exceeds file length {}",
        for slot in values.iter_mut().take(6).skip(3) {
            })
        let file_meta = metadata.file_metadata();
    }
    use datafusion::parquet::arrow::ArrowWriter;
            .unwrap();
/// column, backed by either a local file or a DataFusion [`AsyncFileReader`].
        let inflated_rows = 12i64;
                .build()?;
            .unwrap()
        assert!(
        (File::from(file), Arc::new(metadata))
        &mut self,
/*
        (0..column.len())
                .set_row_groups(vec![inflated_row_group])
                .with_batch_size(batch_size.max(1))
        projection: ProjectionMask,
            .min(page_containing_row.first_row + page_containing_row.row_count - target_row);
        // Append one page entry per data page in this row group.
pub struct ParquetForwardBatchReaderFactory {
            row_count,
                file,
        let next = reader.read_batch_at(6, 2).unwrap().unwrap();
    #[test]
}
use std::io::Cursor;
        reader_for((0..20).map(Some).collect())
        .filter(|&column_idx| projection.leaf_included(column_idx))
        // Pages are 3 rows wide; asking for 10 rows from row 2 yields just row 2.
        let inflated_row_group = metadata
/// A forward-only, page-lazy Parquet batch reader over a single projected leaf
        // Jump straight to row 6, skipping pages [0,3) and [3,6) without decoding.
}
    // Accumulated across the loop: `pages` is the list of page entries returned to
//! Forward-only, page-lazy Parquet batch reader for the doc-values read path.
    pub fn try_new(
        );
//! from the `ColumnIndex`.
    pub row_count: usize,
//! without fetching or decoding them, and pages the ColumnIndex marks entirely
//! null are satisfied without decoding at all.
        writer.close().unwrap();
        let batch = reader.read_batch_at(3, 3).unwrap().unwrap();
                self.physical_position = page_end;
        ParquetForwardBatchReader::try_new(
                )));
        Ok(self.page_at(target_row)?.row_count)
    }
    /// Number of physical rows in the page containing `target_row`.
            "ParquetForwardBatchReader requires exactly one projected leaf column, got {}",
            return Err(ArrowParquetError::General(format!(
        assert_eq!(ints(&batch), vec![None]);
            async_reader,
    fn get_read(&self, start: u64) -> ParquetResult<Self::T> {
    }
}
            Arc::clone(&self.runtime),
            })
            file_meta.created_by().map(str::to_string),
/// Builds the per-page table for the single projected leaf column.
///
            .set_num_rows(inflated_rows)
use datafusion::arrow::array::new_null_array;
            runtime,
            })?;
    ParquetRecordBatchReaderBuilder,
    let [column_idx] = projected_columns.as_slice() else {
        if row_group_rows == 0 {
            .filter(|page| {
                self.batch_size,
            .and_then(|row_group| row_group.get(column_idx))
use std::path::PathBuf;
            let batch = RecordBatch::try_new(schema, columns)?;
    #[test]
        })?;
        let batch = dense_reader().read_batch_at(2, 10).unwrap().unwrap();
        )));
        }
        let page_statistics = column_index
            reader,
                    "invalid OffsetIndex row range {start}..{end} for row group {row_group_idx}"
            .ok_or_else(|| {
            .field("row_count", &self.row_count)
    fn all_null_page_is_served_without_decoding() {
                self.position
use datafusion::parquet::arrow::ProjectionMask;
    /// Creates a retained Arrow reader over an existing synchronous chunk reader
    fn write_fixture(values: Vec<Option<i32>>) -> (File, Arc<ParquetMetaData>) {
            .page_locations;
                })?,
    /// Total rows in the Parquet file.
            return Err(ArrowParquetError::General(format!(
    /// Creates a retained Arrow reader over a DataFusion object-store async
        let properties = WriterProperties::builder()
        reader.read_batch_at(6, 2).unwrap();
            // Page-row limits are only checked at write-batch boundaries, so make
    reader: ParquetRecordBatchReader,
                .with_projection(projection)
            .as_any()
            });
//!
    }
    runtime: Arc<Runtime>,
            return Ok(Some(batch));
    let mut row_group_start = 0usize;
            return Err(ArrowParquetError::General(format!(
    /// Opens a new retained forward reader (local descriptor if available, else
    #[test]
    let mut pages = vec![];
    file: PartitionedFile,
            )));
        let batch = reader.read_batch_at(6, 2).unwrap().unwrap();
            .checked_add(length as u64)
    metadata: Arc<ParquetMetaData>, // Arc as it is shared by readers
        projection: ProjectionMask,
            .and_then(|index| index.get(row_group_idx))
            "value",
            .set_write_batch_size(3)
        values[19] = None;
    reader_factory: Arc<dyn ParquetFileReaderFactory>,
                    .then(|| index.null_count(page_idx))
use datafusion::parquet::file::page_index::column_index::ColumnIndexMetaData;
            "page-header scanning at byte {start} is disabled; an OffsetIndex is required"
    file_len: u64,
                        page_idx + 1
    #[test]
                return Err(ArrowParquetError::General(format!(
    }
        runtime: Arc<Runtime>,
            if self.physical_position < page_end {
            .column(0)
    }
            let schema = self.reader.schema();
        let error = reader.read_batch_at(9, 1).unwrap_err().to_string();
        let mut values: Vec<Option<i32>> = (0..20).map(Some).collect();
        }
/// repeated read path is implemented.
    /// Returns `None` when `target_row == self.row_count()`. Backward seeks and
            .get(row_group_idx)
/// OffsetIndex/ColumnIndex information for one projected data page.
            // the batch small enough to actually split each row group into pages.
            reader.read_batch_at(20, 1).unwrap().is_none(),
    }
        }
        assert!(
        // Next page decodes normally.
    use std::fs::File;
        file_len: u64,
        if skipped != to_skip {
        let batch = reader.read_batch_at(19, 1).unwrap().unwrap();
            .ok_or_else(|| ArrowParquetError::General("page range overflow".to_string()))?;
            .set_offset_index_disabled(false)
            let null_count = page_statistics.and_then(|index| {
    /// Uses a synchronous retained file descriptor for `path`, which the caller resolves from the
            error.contains("requested skip of 9 rows but skipped 8"),
        let skipped = self.reader.skip_rows(to_skip)?;
                ))
            });
            .filter(|index| !matches!(index, ColumnIndexMetaData::NONE));
        writer.write(&batch).unwrap();
            .collect()
                self.physical_position
mod tests {
//! The factory holds everything a reader needs to be rebuilt without new IO: the
        })
        if page_containing_row.all_null {
                None => row_group_rows,
                first_row: row_group_start + start,
    reader: Mutex<Box<dyn AsyncFileReader + Send>>,
    batch_size: usize,
        // makes that final page all-null, so serving it skips the physical reader to exactly the end
impl ParquetForwardBatchReaderFactory {
                self.file_len
/// Adapts DataFusion's async object-store reader to Arrow's synchronous lazy
                "row {target_row} is beyond Parquet row count {}",
    ) -> Self {
    }
            }) || null_count == Some((end - start) as i64);
    }
    runtime: Arc<Runtime>,
        f.debug_struct("ParquetForwardBatchReader")
            file_len,
        if end > self.file_len {
        assert_eq!(ints(&next), vec![Some(6), Some(7)]);
/// decoding them. The projected column must have an OffsetIndex on every
            pages.push(ParquetForwardPage {
    fn forward_jump_skips_intervening_pages() {
    row_count: usize,
            file,
        reader_factory: Arc<dyn ParquetFileReaderFactory>,
    fn a_short_skip_is_rejected_rather_than_decoding_misaligned_rows() {
                    .flatten()
    let offset_index = metadata.offset_index().ok_or_else(|| {
    fn read_batch_at_clamps_to_page_end() {
            if start >= end || end > row_group_rows {
        self.local_file = path;
    fn get_bytes(&self, start: u64, length: usize) -> ParquetResult<Bytes> {
//!
        let to_skip = target_row - self.physical_position;
        let batch = RecordBatch::try_new(Arc::clone(&schema), vec![column]).unwrap();
                .iter()
/// Requires exactly one projected leaf column with an OffsetIndex on every
    })?;
        })?;
    fn page_at(&self, target_row: usize) -> ParquetResult<&ParquetForwardPage> {
        batch_size: usize,
        // create_reader requires a metrics sink; we do not surface these read
    /// Writes `values` to a temp Parquet file (row groups of 8 rows, pages of 3
    }
        }
            runtime,
            ArrowWriter::try_new(file.try_clone().unwrap(), schema, Some(properties)).unwrap();
        let async_reader = self
 * SPDX-License-Identifier: Apache-2.0
            .field("physical_position", &self.physical_position)
        }
            ));
            self.projection.clone(),
                .map_err(|error| ArrowParquetError::External(Box::new(error)))?;
    fn backward_seek_is_rejected() {
            .block_on(self.reader.lock().get_bytes(start..end))
    /// Number of physical rows from `target_row` through the end of its page.
                ))
        Err(ArrowParquetError::General(format!(
        self.runtime
        let mut values: Vec<Option<i32>> = (0..20).map(Some).collect();
            .partition_point(|page| page.first_row + page.row_count <= target_row);
            .unwrap();
use datafusion::parquet::file::metadata::ParquetMetaData;
        )))
        let mut reader =
 * this file be licensed under the Apache-2.0 license or a
                "physical reader is at {} before non-null row {target_row}",
struct AsyncFileChunkReader {
        let (file, metadata) = write_fixture(values);
            .clone()
//! The reader works over either a local file (fast path) or a DataFusion
