    /// Opens a new retained forward reader (local descriptor if available, else
        values[19] = None;
/// [`Self::read_batch_at`] only moves forward: complete pages between the
//! [`ParquetForwardBatchReaderFactory`]. Repeated (multi-valued) columns are not
    use datafusion::parquet::file::metadata::{
        let inflated = Arc::new(
        let row_group_rows = usize::try_from(row_group.num_rows()).map_err(|_| {
        )));
        // with the reader, which would decode every later row from the wrong offset.
        if skipped != to_skip {
        // Rows 3,4,5 form an entirely-null page; reading it returns nulls and the
        )))
        let mut reader =
                Some(next) => usize::try_from(next.first_row_index).map_err(|_| {
        if target_row < self.position {
        // Next page decodes normally.
impl ParquetForwardBatchReaderFactory {
        }
    pub first_row: usize,
            ParquetMetaDataBuilder::new(inflated_file_meta)
        let mut values: Vec<Option<i32>> = (0..20).map(Some).collect();
                    return Err(ArrowParquetError::General(format!(
//! Reads a single projected column forward-only over one retained Arrow reader:
        ParquetForwardBatchReader::try_new_with_chunk_reader(file, metadata, projection, 4096)
    pub fn try_new(
                let to_skip = page_end - self.physical_position;
    let mut pages = vec![];
        // Jump straight to row 6, skipping pages [0,3) and [3,6) without decoding.
    {
    ArrowReaderMetadata, ArrowReaderOptions, ParquetRecordBatchReader,
    }
    /// Uses a synchronous retained file descriptor for `path`, which the caller resolves from the
        Ok(page.first_row + page.row_count - target_row)
        let reader =
    }
    ///
    #[test]
impl ParquetForwardBatchReader {
            .unwrap();
                .set_row_groups(vec![inflated_row_group])
        writer.close().unwrap();
    position: usize,
    pub fn page_row_count(&self, target_row: usize) -> ParquetResult<usize> {
    }
    let projected_columns = (0..schema.num_columns())
        Ok(Self {
use datafusion_datasource::PartitionedFile;
/*
        // Row groups of 8 and pages of 3 leave the last row in its own page, [19, 20). Nulling it
    /// Total rows in the Parquet file.
        assert!(reader.read_batch_at(20, 1).unwrap().is_none());
    row_count: usize,
        self.position
        let mut values: Vec<Option<i32>> = (0..20).map(Some).collect();
            let all_null = page_statistics.is_some_and(|index| {
    fn get_bytes(&self, start: u64, length: usize) -> ParquetResult<Bytes> {
            let batch = RecordBatch::try_new(schema, columns)?;
            .map(|i| column.is_valid(i).then(|| column.value(i)))
    ) -> ParquetResult<Self>
    file: PartitionedFile,
            .ok_or_else(|| {
            .unwrap();
    }
            .downcast_ref::<Int32Array>()
/// Reusable factory for independent forward readers over the same file,
        }
        &mut self,
                .build(),
        self.physical_position = target_row + batch.num_rows();
        let (file, metadata) = write_fixture((0..8).map(Some).collect());
    local_file: Option<PathBuf>,
            )));
        };
            runtime,
        let inflated_row_group = metadata
        assert_eq!(ints(&next), vec![Some(6), Some(7)]);
            .row_group(0)
    /// Returns `None` when `target_row == self.row_count()`. Backward seeks and
        chunk_reader: T,
                file,
    })?;
            })?
            row_count,
            .filter(|page| {
        metadata: Arc<ParquetMetaData>,
    /// Opens a forward reader over the single column of a fixture file.
        let batch = reader.read_batch_at(3, 3).unwrap().unwrap();
                    )));
        let mut writer =
                row_count: end - start,
            )));
                    ArrowParquetError::General(format!(
        if page_containing_row.all_null {
    reader: Mutex<Box<dyn AsyncFileReader + Send>>,
    }
                "row {target_row} is beyond Parquet row count {}",
    }
        let chunk_reader = AsyncFileChunkReader {
        metadata: Arc<ParquetMetaData>,
            file,
        self.file_len
        let column = batch
    pages: Vec<ParquetForwardPage>,
        let to_skip = target_row - self.physical_position;
        f.debug_struct("ParquetForwardBatchReader")
        }
            .set_max_row_group_row_count(Some(8))
            local_file: None,
                    "OffsetIndex missing for row group {row_group_idx}, column {column_idx}"
        self.row_count
                })?,
                target_row >= page.first_row && target_row < page.first_row + page.row_count
            .collect()
            );
            .get(index)
        let next = reader.read_batch_at(6, 2).unwrap().unwrap();
        target_row: usize,
            pages,
    use datafusion::arrow::datatypes::{DataType, Field, Schema};
    }
/// OffsetIndex/ColumnIndex information for one projected data page.
///
/// column, backed by either a local file or a DataFusion [`AsyncFileReader`].
            reader: Mutex::new(async_reader),
}
            })
            let start = usize::try_from(location.first_row_index).map_err(|_| {
            });
            .reader_factory
            file_meta.key_value_metadata().cloned(),
        file: PartitionedFile,
                "page range {start}..{end} exceeds file length {}",
        }
/// non-empty row group so Arrow can request whole page ranges lazily.
        projection: ProjectionMask,
}
    }
                self.file_len
    #[test]
        .filter(|&column_idx| projection.leaf_included(column_idx))
        if row_group_rows == 0 {
        assert_eq!(ints(&batch), vec![None, None, None]);
    }
        }
    pub fn row_count(&self) -> usize {
        if max_rows == 0 {
        FileMetaData, PageIndexPolicy, ParquetMetaDataBuilder, ParquetMetaDataReader,
            }) || null_count == Some((end - start) as i64);
    pub fn rows_remaining_in_page(&self, target_row: usize) -> ParquetResult<usize> {
            position: 0,
            DataType::Int32,
                .map_err(|error| ArrowParquetError::External(Box::new(error)))?;
        (0..column.len())
                "forward batch size must be greater than zero".to_string(),
        let locations = &offset_index
                return Err(ArrowParquetError::General(format!(
/// non-empty row group. Repeated (multi-valued) columns are rejected until the
        Self {
            return Err(ArrowParquetError::General(format!(
//!
        let properties = WriterProperties::builder()
            return Err(ArrowParquetError::General(format!(
    // the caller; `row_group_start` tracks the file-absolute first row of each row group.
        let batch = reader.read_batch_at(19, 1).unwrap().unwrap();
            .build()
        let row_count = usize::try_from(metadata.file_metadata().num_rows()).map_err(|_| {
//!
    fn target_row_at_row_count_returns_none() {
        let batch = reader.read_batch_at(6, 2).unwrap().unwrap();
    physical_position: usize, // deviates from position for null rows
    }
 */
        if let Some(path) = self.local_file.as_ref() {
/// exists locally, and otherwise builds a DataFusion object-store reader for
        row_group_start += row_group_rows;
                Arc::clone(&self.metadata),
fn projected_pages(
        if target_row < self.physical_position {
    /// Writes `values` to a temp Parquet file (row groups of 8 rows, pages of 3
//! complete pages between the current position and the requested row are skipped
#[cfg(test)]
        let file = tempfile::tempfile().unwrap();
        let page_statistics = column_index
    }
//! The reader works over either a local file (fast path) or a DataFusion
    /// filesystem can name a descriptor, and only it knows how an object path maps onto one.
            })?;
    /// of `target_row`'s page.
use std::sync::Arc;
            Arc::clone(&self.metadata),
            .parse_and_finish(&file)
    let offset_index = metadata.offset_index().ok_or_else(|| {
            ArrowReaderMetadata::try_new(Arc::clone(&metadata), ArrowReaderOptions::new())?;
        self.runtime
/// [`Self::open`] uses a synchronous retained file descriptor when the file
                None => row_group_rows,
    ParquetRecordBatchReaderBuilder,
            runtime,
                .with_batch_size(batch_size.max(1))
pub struct ParquetForwardPage {
        // then runs out of data. The skip must fail rather than leave `physical_position` out of step
            "the file must be exhausted after its final page"
    fn backward_seek_is_rejected() {
    batch_size: usize,
        if target_row > self.row_count {
                        "negative first row for row group {row_group_idx}, page {}",
                self.position
        for (page_idx, location) in locations.iter().enumerate() {
//! from the `ColumnIndex`.
            .field("physical_position", &self.physical_position)
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        Self::try_new_with_chunk_reader(chunk_reader, metadata, projection, batch_size)
    }
    pub row_count: usize,
            )));
}
//! null are satisfied without decoding at all.
    fn len(&self) -> u64 {
            // Page-row limits are only checked at write-batch boundaries, so make
                .unwrap();
        // A footer that claims more rows than the pages hold: 8 rows are written, then the row group
use datafusion::parquet::file::metadata::ParquetMetaData;
        reader_for((0..20).map(Some).collect())
struct AsyncFileChunkReader {
    /// Number of rows in the page.
        let batch = RecordBatch::try_new(Arc::clone(&schema), vec![column]).unwrap();
        runtime: Arc<Runtime>,
    fn reader_for(values: Vec<Option<i32>>) -> ParquetForwardBatchReader {
/// self`, matching the single-threaded cursor contract.
        assert_eq!(reader.position(), 8);
        return Err(ArrowParquetError::General(format!(
    }
}
        assert!(reader.read_batch_at(1, 1).is_err());
///
        let file_meta = metadata.file_metadata();
        // makes that final page all-null, so serving it skips the physical reader to exactly the end
            .build();
                .iter()
use datafusion::parquet::file::page_index::column_index::ColumnIndexMetaData;
use datafusion::datasource::physical_plan::parquet::ParquetFileReaderFactory;
            ));
            if self.physical_position < page_end {
    projection: &ProjectionMask,
    /// decoding.
        let mut reader = reader_for(values);
            return Err(ArrowParquetError::General(format!(
                .map(|field| new_null_array(field.data_type(), rows_to_read))
        })?;
use datafusion::parquet::file::reader::{ChunkReader, Length};
//! source. [`ParquetForwardBatchReaderFactory::open`] is therefore also the reset
    }
        }
            batch_size,
                ArrowParquetError::General(format!(
}
            projected_columns.len()
        let arrow_metadata =
        // Append one page entry per data page in this row group.
        Err(ArrowParquetError::General(format!(
}
        self
//!
                self.physical_position = page_end;
        let metrics = ExecutionPlanMetricsSet::new();
        );
/// repeated read path is implemented.
    fn get_read(&self, start: u64) -> ParquetResult<Self::T> {
    }
        .collect::<Vec<_>>();
            })
        max_rows: usize,
        reader.read_batch_at(6, 2).unwrap();
        let index = self
    pub fn new(
        Ok(self.page_at(target_row)?.row_count)
            "{error}"
    fn an_all_null_final_page_skips_to_end_of_file_without_a_short_skip() {
            inflated_rows,
            .page_locations;
        let error = reader.read_batch_at(9, 1).unwrap_err().to_string();
        }
        }
    where
    /// rows, OffsetIndex + ColumnIndex enabled) and returns it with its metadata.
        projection: ProjectionMask,
    reader: ParquetRecordBatchReader,
use datafusion::physical_plan::metrics::ExecutionPlanMetricsSet;
            reader.read_batch_at(20, 1).unwrap().is_none(),
}
        // create_reader requires a metrics sink; we do not surface these read
            .and_then(|row_group| row_group.get(column_idx))
                self.projection.clone(),
use datafusion::parquet::arrow::async_reader::AsyncFileReader;
        (File::from(file), Arc::new(metadata))
use datafusion::parquet::arrow::arrow_reader::{
    }
                "requested skip of {to_skip} rows but skipped {skipped}"
    /// a DataFusion object-store reader).
            .set_offset_index_disabled(false)
                        page_idx + 1
    /// rows beyond the end of the file return an error.
impl ChunkReader for AsyncFileChunkReader {
mod tests {
impl Length for AsyncFileChunkReader {
        assert_eq!(ints(&batch), vec![Some(6), Some(7)]);
    if schema.column(column_idx).max_rep_level() > 0 {
        let pages = projected_pages(&metadata, &projection)?;
                self.batch_size,
            self.projection.clone(),
            .unwrap();
}
            .partition_point(|page| page.first_row + page.row_count <= target_row);
    ///
                "backward seek from {} to {target_row} is not supported",
        let inflated_rows = 12i64;
        );
            let columns = schema
    ) -> Self {
        )]));
    }
            }
        let batch = self.reader.read_next_batch(rows_to_read)?.ok_or_else(|| {
    ) -> ParquetResult<Self> {
        let metadata = ParquetMetaDataReader::new()
    }
    fn a_short_skip_is_rejected_rather_than_decoding_misaligned_rows() {
            // the batch small enough to actually split each row group into pages.
    }
#[derive(Debug, Clone)]
    /// store that owns the file. `None` continues through DataFusion's reader factory.
    use datafusion::arrow::array::{Array, ArrayRef, Int32Array};
//! path. Page bounds come from the `OffsetIndex`; all-null pages are recognised
            if start >= end || end > row_group_rows {
    fn write_fixture(values: Vec<Option<i32>>) -> (File, Arc<ParquetMetaData>) {
    /// Creates a factory whose readers use the supplied DataFusion file reader
/// decoding them. The projected column must have an OffsetIndex on every
            async_reader,
use datafusion::parquet::errors::{ParquetError as ArrowParquetError, Result as ParquetResult};
    }
    }
                page_idx < index.num_pages() as usize && index.is_null_page(page_idx)
};
            return Err(ArrowParquetError::General(format!(
                let skipped = self.reader.skip_rows(to_skip)?;
        );
    }
            .ok_or_else(|| ArrowParquetError::General("page range overflow".to_string()))?;
) -> ParquetResult<Vec<ParquetForwardPage>> {
        batch_size: usize,
    use std::fs::File;
            .with_page_index_policy(PageIndexPolicy::Required)
    }
                ArrowParquetError::General(format!(
/// A forward-only, page-lazy Parquet batch reader over a single projected leaf
//! The factory holds everything a reader needs to be rebuilt without new IO: the
                first_row: row_group_start + start,
            return Err(ArrowParquetError::General(format!(
        let skipped = self.reader.skip_rows(to_skip)?;
        self.position = self.physical_position;
            .set_num_rows(inflated_rows)
            Arc::clone(&self.runtime),
    // Accumulated across the loop: `pages` is the list of page entries returned to
        file_len: u64,
        async_reader: Box<dyn AsyncFileReader + Send>,
            )));
    }
    // Walk every row group, appending one page entry per data page to `pages`.
    }
                ArrowParquetError::General(format!("OffsetIndex does not contain row {target_row}"))
    fn all_null_page_is_served_without_decoding() {
                (page_idx < index.num_pages() as usize)
            "ParquetForwardBatchReader requires exactly one projected leaf column, got {}",
    pub fn open(&self) -> ParquetResult<ParquetForwardBatchReader> {
    /// Whether every value in the page is null, so it can be satisfied without
            ParquetRecordBatchReaderBuilder::new_with_metadata(chunk_reader, arrow_metadata)
    /// reader (remote/tiered storage).
use std::fmt::Debug;
            error.contains("requested skip of 9 rows but skipped 8"),
    reader_factory: Arc<dyn ParquetFileReaderFactory>,
    use super::*;
            .clone()
                .build()?;
//! without fetching or decoding them, and pages the ColumnIndex marks entirely
        let page_containing_row = self.page_at(target_row)?.clone();
    use datafusion::parquet::file::properties::WriterProperties;
            pages.push(ParquetForwardPage {
            ArrowParquetError::General(format!("Parquet reader exhausted before row {target_row}"))
    file_len: u64,
        let batch = dense_reader().read_batch_at(2, 10).unwrap().unwrap();
            ParquetForwardBatchReader::try_new_with_chunk_reader(file, inflated, projection, 4096)
            .and_then(|index| index.get(row_group_idx))
                }
//! object-store [`AsyncFileReader`] (remote/tiered storage), selected by
        }
            physical_position: 0,
        let mut reader = dense_reader();
            self.batch_size,
}
    /// Creates a retained Arrow reader over an existing synchronous chunk reader
        })?;
        }
                    .then(|| index.null_count(page_idx))
    /// Number of physical rows in the page containing `target_row`.
/// page reader. Calls are serialized because `AsyncFileReader` takes `&mut
//! supported yet.
            return Ok(None);
    let mut row_group_start = 0usize;
    let [column_idx] = projected_columns.as_slice() else {
        let mut reader = dense_reader();
    fn dense_reader() -> ParquetForwardBatchReader {
            });
        })?;
        writer.write(&batch).unwrap();
            .map_err(|error| ArrowParquetError::External(Box::new(error)))?;
        // Pages are 3 rows wide; asking for 10 rows from row 2 yields just row 2.
}
            true,
    pub fn with_local_file(mut self, path: Option<PathBuf>) -> Self {
                ))
    /// Skips to `target_row` and decodes the next Arrow batch, clamped to the end
///
    ) -> ParquetResult<Option<RecordBatch>> {
        // metrics, so pass a throwaway set.
        let rows_to_read = max_rows
    /// Current physical row position of the retained Arrow reader.
    let column_idx = *column_idx;
use bytes::Bytes;
                .set_column_index(metadata.column_index().cloned())
                    ))
            projection,
            file_meta.schema_descr_ptr(),
        assert!(
    pub all_null: bool,
        // and file counts are inflated to 12, stretching the last page to [6, 12). Skipping to row 9
        T: ChunkReader + 'static,
    };
    metadata: &ParquetMetaData,
//! `ParquetMetaData` (footer plus the page index for the projected column), the
        runtime: Arc<Runtime>,
    fn forward_jump_skips_intervening_pages() {
            .field("position", &self.position)
        ParquetForwardBatchReader::try_new(
    runtime: Arc<Runtime>,
    // TODO: add support for repeated columns
            .block_on(self.reader.lock().get_bytes(start..end))
        let mut reader = dense_reader();
    #[test]
            let file = std::fs::File::open(path)
                    .flatten()
    let schema = metadata.file_metadata().schema_descr();
        self.local_file = path;
    /// (a local file), reusing Parquet metadata already loaded by DataFusion.
        ArrowParquetError::General("ParquetForwardBatchReader requires an OffsetIndex".to_string())
                .collect();
            file_meta.version(),
    fn page_at(&self, target_row: usize) -> ParquetResult<&ParquetForwardPage> {
impl Debug for ParquetForwardBatchReader {
 * SPDX-License-Identifier: Apache-2.0
/// current position and the requested row are skipped without fetching or
            file_meta.created_by().map(str::to_string),
pub struct ParquetForwardBatchReaderFactory {
    #[test]
        let end = start
use tokio::runtime::Runtime;
            };
            file_meta.column_orders().cloned(),
                .fields()
            .ok_or_else(|| {
        if target_row == self.row_count {
        // of the file - the boundary where a short skip would be reported if one were possible.
    projection: ProjectionMask,
        metadata: Arc<ParquetMetaData>,
//! Forward-only, page-lazy Parquet batch reader for the doc-values read path.
            .into_builder()
            ArrowWriter::try_new(file.try_clone().unwrap(), schema, Some(properties)).unwrap();
    runtime: Arc<Runtime>,
/// Requires exactly one projected leaf column with an OffsetIndex on every
    pub fn position(&self) -> usize {
            return Err(ArrowParquetError::General(
use std::io::Cursor;
                    "negative first row for row group {row_group_idx}, page {page_idx}"
            continue;
        ));
            reader,
        let page = self.page_at(target_row)?;
        batch_size: usize,
use std::path::PathBuf;
    fn read_batch_at_clamps_to_page_end() {
            .checked_add(length as u64)
                )));
    pub fn try_new_with_chunk_reader<T>(
        assert_eq!(ints(&batch), vec![None]);
 * this file be licensed under the Apache-2.0 license or a
            file_len,
            .and_then(|row_group| row_group.get(column_idx))
        // physical reader skips past it.
    }
            *slot = None;
                all_null,
use datafusion::parquet::arrow::ProjectionMask;
                self.row_count
            ArrowParquetError::General(format!("negative row count for row group {row_group_idx}"))
            .set_data_page_row_count_limit(3)
/// remote/tiered storage.
            ArrowParquetError::General("Parquet row count does not fit in usize".to_string())
            return ParquetForwardBatchReader::try_new_with_chunk_reader(
            .get(row_group_idx)
                    "invalid OffsetIndex row range {start}..{end} for row group {row_group_idx}"
            let end = match locations.get(page_idx + 1) {
            self.position = target_row + rows_to_read;
                .set_offset_index(metadata.offset_index().cloned())
    for (row_group_idx, row_group) in metadata.row_groups().iter().enumerate() {
            .as_any()
    /// First logical row of the page within the file.
                ))
                        "requested all-null page skip of {to_skip} rows but skipped {skipped}"
//! `ProjectionMask` naming that column, the decode batch size, and the byte
            }
    #[test]
        reader_factory: Arc<dyn ParquetFileReaderFactory>,
            self.file.object_meta.size,
            .field("page_count", &self.pages.len())
        let async_reader = self
    metadata: Arc<ParquetMetaData>, // Arc as it is shared by readers
            return Ok(Some(batch));
        if end > self.file_len {
    };
        batch_size: usize,
        self.pages
    /// Creates a retained Arrow reader over a DataFusion object-store async
    Ok(pages)
/// Adapts DataFusion's async object-store reader to Arrow's synchronous lazy
        let mut reader = reader_for(values);
            .filter(|index| !matches!(index, ColumnIndexMetaData::NONE));
        let inflated_file_meta = FileMetaData::new(
        assert!(
        })
            .pages
    type T = Cursor<Bytes>;
    fn ints(batch: &RecordBatch) -> Vec<Option<i32>> {
    /// Resolving the path is the store's job, not this module's: only a store backed by the local
        }
            .set_write_batch_size(3)
        }
    /// factory and cached Parquet metadata.
        let (file, metadata) = write_fixture(values);
}
                .with_projection(projection)
    #[test]
        }
    #[test]
        let projection = ProjectionMask::leaves(inflated.file_metadata().schema_descr(), [0]);
use datafusion::arrow::array::new_null_array;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
            .filter(|index| !index.page_locations.is_empty())
    /// Number of physical rows from `target_row` through the end of its page.
        )
            "ParquetForwardBatchReader does not support repeated columns yet".to_string(),
        let schema = Arc::new(Schema::new(vec![Field::new(
        projection: ProjectionMask,
    pub fn read_batch_at(
            let null_count = page_statistics.and_then(|index| {
        return Err(ArrowParquetError::General(
            reader_factory,
            .unwrap()
/// Builds the per-page table for the single projected leaf column.
        for slot in values.iter_mut().take(6).skip(3) {
pub struct ParquetForwardBatchReader {
        assert_eq!(ints(&batch), vec![Some(2)]);
            let schema = self.reader.schema();
                "physical reader is at {} before non-null row {target_row}",
            .create_reader(0, self.file.clone(), None, &metrics)
            .min(page_containing_row.first_row + page_containing_row.row_count - target_row);
    }
        let column: ArrayRef = Arc::new(Int32Array::from(values));
            "page-header scanning at byte {start} is disabled; an OffsetIndex is required"
            let page_end = page_containing_row.first_row + page_containing_row.row_count;
        Ok(Some(batch))
        );
    let column_index = metadata.column_index();
                self.physical_position
            )));
    use datafusion::parquet::arrow::ArrowWriter;
            metadata,
use parking_lot::Mutex;
        let projection = ProjectionMask::leaves(metadata.file_metadata().schema_descr(), [0]);
/// metadata, and projection.
use datafusion::arrow::record_batch::{RecordBatch, RecordBatchReader};
            "value",
                if skipped != to_skip {
 *
            .field("row_count", &self.row_count)
            .column(0)
    }
            .finish_non_exhaustive()
