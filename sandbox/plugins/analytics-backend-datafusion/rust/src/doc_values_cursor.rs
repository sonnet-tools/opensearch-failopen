            Arc::clone(&runtime),
    }
        let mut file = NamedTempFile::new().unwrap();
        assert_eq!(rewound.first_row, 0);
    unsafe fn exported_i64s(addr: i64, rows: usize) -> Vec<i64> {
        open_iter_with_max(path, initial, super::tests::TEST_MAX_BATCH_SIZE as i64)
        let column = "value";
        assert_dictionary_jump_decodes::<arrow::datatypes::Int32Type>(DataType::Int32, |row| {
        register_test_metadata_cache();
        let reader = factory.open()?;
        let _globals = crate::test_process_globals::lock();
}
            borrow.validity_bit_offset, 3,
    fn a_batch_over_the_memory_budget_fails_instead_of_being_decoded() {
    }
        writer.write(&batch).unwrap();
            DataType::UInt16 => Some(Self::Ushort),
    fn fixture_file() -> NamedTempFile {
        let across = (ROWS_PER_PAGE * 5 + 7) as i64;
        let file = fixture_file();
        assert_eq!(later.rc, RC_OK, "{}", error_message(later.rc));
        let configured_max = 32;
    /// `MemorySegment.ofAddress(addr).reinterpret(len)`: an unchecked view over memory Rust owns.
        assert!(
        });
        assert_eq!(
        let rows_per_page = BATCH_SIZE_HARD_LIMIT * 2;
    fn a_batch_within_the_memory_budget_is_accounted_and_released() {
        assert!(
            DataType::Int64,
        let reader_factory: Arc<dyn ParquetFileReaderFactory> = Arc::new(
use datafusion_datasource::PartitionedFile;
            "value",
    cursor.reservation.resize(0);
    pub(super) fn parquet_fixture_with_page_rows(row_groups: usize, rows_per_page: usize) -> Bytes {
            object_meta,
                        .parts()
            8,
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
    };
            "a rejected batch must leave nothing reserved"
            parquet_df_open_iter(
        assert_eq!(forward.rc, RC_OK);
        let dense = self.has_decoded_batch
        values_addr,
        let store = Arc::new(TieredObjectStore::new(
        )
/// Only reached when a request lands below the resident batch, which a caller honouring Lucene's
                initial,
                "initial {initial} produced {message}"
    };
        assert_eq!(first.column(0).null_count(), 8);
        let handle = open_fixture(&file);
        );
    /// An array can be a window onto a longer buffer, so row 0 need not sit at the buffer's start
            .unwrap();
        let env = runtime_env()?;
    Ok(RC_OK)
            (0..8i64).collect::<Vec<_>>(),
            (target..target + 8).collect::<Vec<_>>()
        let error = open_named_column(bytes, "left")
                &mut validity_addr,
/// core count and monitors it, and a pool created here would be neither sized nor monitored.
/// `ParquetColumnReader.LOCAL_STORE` on the Java side.
            borrowed_batch: None,
                column.as_ptr(),
        assert_eq!(forward.first_row, 32);
            .read_batch_at(target_row as usize, rows)?
            .register(&env.memory_pool);
        );
            (Arc::new(UInt8Array::from(vec![1])), BorrowKind::Ubyte),
            }
        let position = self.reader.position();
        (row % 7) as i64 * 3
    /// The values [`parquet_fixture_encoded`] holds at `target..target + len`.
    use std::io::Write;
            max_batch_size,
) -> Result<i64, DataFusionError> {
        first_row: i64,
        };
    fn next_batch(handle: i64, target_row: i64) -> Batch {
            .set_dictionary_enabled(false)
            "doc-values-cursor-{}.parquet",
    }
            assert_eq!(
        Box::into_raw(boxed) as i64
    }
        let values_buffer = Buffer::from_slice_ref((0..8_i64).collect::<Vec<_>>());
    /// `index.parquet.docvalues.max_batch_size` so a later setting update cannot disagree with
            }
        );
        let batch_size = batch_size.clamp(1, max_batch_size);
                None,
        filename,
    /// static because the registry keeps only a `Weak`.
                .len(5)
        };
        let _globals = crate::test_process_globals::lock();
    /// uses the local filesystem, which is what local-tier shard files need. A non-local store is
    /// actually emits a dictionary page instead of falling back to plain encoding.
                &mut validity_bit_offset,
            Some(store),
        assert!(
    #[test]
unsafe fn open_and_register(
            WriterVersion::PARQUET_2_0,
        let file = fixture_file();
    }
                .offset(3)
        let _globals = crate::test_process_globals::lock();
    }
    }
    store_ptr: i64,
            Self::Long | Self::Double => 8,
        column,
        let handle = open_fixture(&file);
            "reading through the exported pointer must yield the window's first value"
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
        )]));
    }
        use arrow::buffer::Buffer;
        batch_size: usize,
    let data = array.to_data();
        };
    column: &str,
    /// Read at 0, skip within a page, jump across pages, then land on an exact page boundary,
        Ok(batch)
            NEXT_HANDLE.fetch_add(1, Ordering::Relaxed)
        let batch = cursor.next_batch(boundary).unwrap();
        let second_rg = (ROWS_PER_PAGE * 8) as i64;
        drop(Box::from_raw(ptr as *mut Arc<dyn MetadataCachingStore>));
        let props = WriterProperties::builder()
    // The batch is gone, so its bytes must leave the pool with it.
        assert_eq!(cursor.next_batch(0).unwrap().num_rows(), 8);
    /// Default ceiling, as a cursor opened through the FFM boundary would receive it. Tests that care
            unsafe { *(borrow.values_addr as *const i64) },
 * The OpenSearch Contributors require contributions made to
    pub(super) fn register_test_runtime_manager() {
                .unwrap();
    }
                None,
    /// validity bitmap. Binary and variable-width columns come after that. `Float16`
    }
    /// A decimal is a supported Parquet physical type (precision 18 is stored as INT64) that decodes
            "resolution must still pick a single leaf: {error}"
            error_message(unsafe { parquet_df_reset_iter(unknown) }),
    fn assert_skip_shapes_decode(bytes: Bytes) {
        );
use datafusion::error::DataFusionError;
        } else if self.has_decoded_batch {
                    .map(|&idx| schema.column(idx).path().string())
/// Opening a cursor reads two process globals — the runtime manager and the global `RuntimeEnv`
        assert!(error.contains("ambiguous"), "{error}");
                .null_bit_buffer(Some(validity_buffer))
}
    }
        assert_eq!(non_null.column(0).null_count(), 0);
        }
static CURSORS: Lazy<DashMap<i64, Arc<Mutex<DocValuesCursor>>>> = Lazy::new(DashMap::new);
    /// `ParquetColumnReader.widthForKind`.
        let _globals = crate::test_process_globals::lock();
fn at_eof(
            .set_statistics_enabled(EnabledStatistics::Page)
//! page traversal, skipping, decompression, definition-level expansion, and batch
        }
        batch_size: usize,
    max_batch_size: usize,
            .borrowed_batch
            .block_on(backing.put(&location, bytes.into()))
        }
//! construction. This module selects the byte source and exposes the FFM lifecycle.
        let target = (ROWS_PER_PAGE * 5 + 7) as i64;
            factory,
                array.data_type()
        let (mut cursor, _runtime) = open_fixture(1, 8);
    Ushort = 5,   // u16, zero-extended
        file.write_all(&parquet_fixture_with_page_rows(1, ROWS_PER_PAGE))
        // rather than a flat primitive, so it is refused at open instead of on the first read.
        assert_eq!(cursor.next_batch(27).unwrap().num_rows(), 32);
pub unsafe extern "C" fn parquet_df_next_batch(
    /// just as well and still serves wrong doc values.
        let row_count = reader.row_count() as i64;
        //
    use tokio::runtime::Builder;
    ///
        let batch = cursor.next_batch(within).unwrap();
/// builds its own `LocalFileSystem` and reads through a synchronous `ChunkReader`. A non-zero
    ///
        let object_meta = store.head(&location).await?;
            .get(&handle)
        // Absolute, like the path the engine stamps and the shard's registry is keyed by.
        let filename = file.path().to_str().unwrap();
            true,
            .next_batch(0)
mod tests {
        }
            .collect::<Vec<_>>();
            "{fn_name}: row {target_row} out of range (0..={})",
///
    open_and_register(
            DataType::Float64 => Some(Self::Double),
        let (store, local_path): (Arc<dyn ObjectStore>, Option<PathBuf>) = match store_override {
            ROWS_PER_PAGE,
            row_count,
        assert_eq!(
        let values_base = values_buffer.as_ptr() as usize;
            assert!(holds_borrow(handle));
            "{error}"
        let file = fixture_file();
        let second = cursor.next_batch(25).unwrap();
            .map(|value| value as i128)
                handle,
    let boxed = &*(store_ptr as *const Arc<dyn MetadataCachingStore>);
        assert_eq!(cursor.next_batch(24).unwrap().num_rows(), 32);
            vec![ROWS_PER_PAGE as i64 + 3],
//! than dereferenced. `0` is never a live handle. Java owns the lifecycle and calls
}
            .set_statistics_enabled(EnabledStatistics::Page)
                    .expect("test runtime environment must build"),
                path.as_ptr(),
    fn large_jump_halves_the_window_instead_of_resetting() {
            .set_data_page_row_count_limit(rows_per_page)
    use arrow::datatypes::{DataType, Field, Schema};
        batch
        location_override: Option<ObjectPath>,
        initial_batch_size as usize,
        );
    /// at the configured value rather than the compile-time limit.
        assert_eq!(
                max_batch_size,
            "value",
const RC_EOF: i64 = 2;
        for expected in [8, 16, 32, 64, 64, 64] {
        )?;
    if rows == 0 || rows > cursor.max_batch_size {
    fn a_failed_read_releases_the_borrow() {
        assert_eq!(cursor.next_batch(jump).unwrap().num_rows(), 8);
        );
        let message = error_message(rc);
        let leaf_schema = parquet_to_arrow_schema_by_columns(
            .unwrap();
        // Repeated large jumps keep halving and bottom out at the initial window.
        assert_eq!(cursor.next_batch(56).unwrap().num_rows(), 8);
            ))
        // Resolved once so the cache below and the pool the reservation uses come from one runtime.
    use super::*;
        assert_eq!(
        open_parquet_fixture(
        assert_eq!(cursor.next_batch(8).unwrap().num_rows(), 16);
        let _globals = crate::test_process_globals::lock();
    fn every_entry_point_rejects_an_unknown_handle() {
        // (`initial_batch_size`) can never exceed the growth cap.
            .block_on(DocValuesCursor::open(
        );
        open_parquet_fixture_with_max(bytes, batch_size, TEST_MAX_BATCH_SIZE)
    }
    #[test]
        let file = fixture_file();
            batch_size,
            let batch = next_batch(handle, row);
struct BorrowedBuffers {
    Short = 4,    // i16, sign-extended
    }
            encoded_expected(across as usize, batch.num_rows())
        unsafe {
        assert_eq!(batch.last_row, 7);
        let within = (ROWS_PER_PAGE / 2) as i64;
        let runtime = Arc::new(Builder::new_current_thread().enable_all().build().unwrap());
             runtime must be created before Parquet doc-values reads"
        assert!(
/// Store pointer meaning "read from the local filesystem", which is every hot shard. Mirrors
        // A backward seek fails inside the reader, after the release, for the same reason.
                "kind for {}",
            let borrow = borrowable_buffers(array.as_ref())
    fn local_file_cursor_reuses_retained_descriptor_for_page_reads() {
            holds_borrow(handle),
        let values = (0..rows_per_page * 2)
            .build();
            configured_max,
    fn resetting_releases_the_borrow_and_allows_rereading_row_zero() {
            borrowable_buffers(&booleans).is_none(),
    // leading slash away, so no separate location override is needed.
) -> i64 {
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
                borrow.kind,
            int64_values(&batch),
        let _globals = crate::test_process_globals::lock();
    if len < 0 {
        let jump = (ROWS_PER_PAGE * 9 + 1) as i64;
            .set_statistics_enabled(EnabledStatistics::Page)
    /// `LocalFileSystem`.
    fn open_iter_with_max(path: &str, initial: i64, max: i64) -> i64 {
    max_batch_size: usize,
}
}
    write_out(out_validity_addr, borrow.validity_addr as i64);
fn io_runtime() -> Result<Arc<Runtime>, DataFusionError> {
        // Converted with the same projection and key-value metadata the reader uses, so the two
        let configured_max = 64;
        ];
    UintBits = 3, // u32 raw bits, zero-extended
    }
    /// Two leaves under one struct, so the group root matches both by first path part.
use object_store::path::Path as ObjectPath;
        P: arrow::datatypes::ArrowPrimitiveType,
        // larger than the current window is treated as dense access, so the window doubles; a jump
                        .first()
            .filter(|&idx| {
        use arrow::array::{
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
    // Same pointer type and upcast dance as `api::create_reader`: bind the concrete trait object
//! Forward-only Parquet doc-values cursor over DataFusion I/O and Arrow decoding.
            int64_values(&batch),
    #[cfg(test)]
                .expect("error message must be valid UTF-8")
        // 8 -> 16 -> 32 -> 64, then held: doubling would pass the configured ceiling.
        ));
                8,
    /// asserts the landing batch decodes to the written values. Exercises the non-Int64 widths of
    ) -> Bytes {
        let runtime = Arc::new(Builder::new_current_thread().enable_all().build().unwrap());
    fn dense_access_retains_the_grown_window_across_pages() {
        assert_eq!(
    ///
    Some(caching)
    }
    }
            configured_max,
        let runtime = Arc::new(Builder::new_current_thread().enable_all().build().unwrap());
use opensearch_tiered_storage::tiered_object_store::MetadataCachingStore;
        }
    /// back), so `to_data().offset()` reads as 0 here and the `data.offset()` term in the export is
        let target = (ROWS_PER_PAGE * 5 + 7) as i64;
                "width for {}",
        validity_addr: i64,
                column.len() as i64,
        let (mut cursor, _runtime) = open_fixture(1, 8);
        runtime
    /// (OpenSearch `half_float`) needs a kind whose Java side re-encodes to a sortable short.
    }
use std::path::PathBuf;
        "no runtime manager registered; DataFusionService.doStart registers it in production, \
use datafusion::execution::runtime_env::RuntimeEnv;
            (target..target + 8).collect::<Vec<_>>()
        let later = next_batch(handle, ROWS_PER_PAGE as i64 + 3);
        assert!(
            error.contains("group.left") && error.contains("group.right"),
        version: WriterVersion,
    /// `parquet_df_open_iter` has exactly the shape a warm shard's store handle carries.
    #[test]
                .await
        let (mut cursor, _runtime) = open_fixture(1, 8);
            configured_max < BATCH_SIZE_HARD_LIMIT,
        let _globals = crate::test_process_globals::lock();
    #[test]
            ROWS_PER_PAGE,
    Double = 8,   // f64 raw bits; Java re-encodes to a Lucene sortable long
    /// `index.parquet.docvalues.max_batch_size` lowers the ceiling per cursor, so growth has to stop
        let mut last_row = -1i64;
    fn open_fixture(file: &NamedTempFile) -> i64 {
use std::sync::atomic::{AtomicI64, Ordering};
        runtime
        let _globals = crate::test_process_globals::lock();
/// The shared IO runtime, used only to block on object-store fetches; decode is synchronous and runs
        store_override: Option<Arc<dyn ObjectStore>>,
            borrow.values_addr,
};
        // are additionally limited to what is left of it.
use crate::indexed_table::parquet_bridge::{
    }
        );
        let handle = open_fixture(&file);
            DataType::Decimal128(18, 2),
    Ok(handle)
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
                .unwrap();
/// registration — and inserts into the process-global scoped page-index caches, so every test here
                unsafe { exported_i64s(batch.values_addr, rows) },
        assert_eq!(first.num_rows(), 8);
        );
            free_store_pointer(store_ptr);
            ROWS_PER_PAGE,
    /// The batch Java last borrowed from, held so the exported pointers stay valid. Released on the
    #[test]
    if initial_batch_size <= 0 || initial_batch_size > max_batch_size {
        assert!(rc < 0, "expected an error pointer, got {rc}");
        );
    validity_bit_offset: usize,
            batch_size,
        // there is nothing to leak. `CURSORS` is process-wide and other tests add to and remove from
        rows_per_page: usize,
        assert_eq!(
            [only] => *only,
        let array = batch.column(0); // single projected column
    }
        let mut writer =
//! `parquet_df_close_iter` exactly once.
        assert_eq!(
        // Each call releases the previous batch before decoding, so retention never accumulates.
            // The fixture writes value == row index, so the buffer must read back as exactly the
        while row < FIXTURE_ROWS {
        };
            Some(store) => (store, None),
            parquet_df_open_iter(
            UInt32Array, UInt64Array, UInt8Array,
/// Each holds `crate::test_process_globals::lock` for the same reason as the module above.
    #[test]
            column,
        let children = vec![
        assert_eq!(
                    .build()
                self.row_count
        .ok_or_else(|| DataFusionError::Internal(format!("{fn_name}: unknown handle {handle}")))
        while row < FIXTURE_ROWS {
            .build();
        register_test_metadata_cache();
    debug_assert_eq!(array.data_type().primitive_width(), Some(width));
        assert!(holds_borrow(handle));
    }
        let (mut cursor, _runtime) = open_fixture(1, 8);
        let schema = footer.file_metadata().schema_descr();
    filename: &str,
            BATCH_SIZE_HARD_LIMIT
        let reads_before = cursor.stats.count.load(Ordering::Relaxed);
    use std::ffi::{c_char, CString};
    /// Stands in for the runtime manager production registers from `DataFusionService`. Tests reach
}
            .set_statistics_enabled(EnabledStatistics::Page)
        assert_eq!(batch.rc, RC_OK, "{}", error_message(batch.rc));
            .set_dictionary_enabled(false)
}
        };
    let caching: Arc<dyn MetadataCachingStore> = Arc::clone(boxed);
        crate::cache::register_global_runtime_env(&ENV);
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
        assert!(message.contains("backward seek"), "{message}");
            DataType::Int64 | DataType::UInt64 | DataType::Date64 | DataType::Timestamp(_, _) => {
    /// # Safety
        let location = location_override.unwrap_or_else(|| ObjectPath::from(filename));
        );
            .ok_or_else(|| {
        // TODO(memory): this bounds only the decoded batch; the page and dictionary the Arrow
//!
        assert_eq!(batch.rc, RC_OK);
    fn next_batch(&mut self, target_row: i64) -> Result<RecordBatch, DataFusionError> {
        Batch {
            load_scoped_page_index_cols(&store, &location, &footer, &[leaf_idx], &[leaf_idx])
    }
            let cache = Arc::new(MutexFileMetadataCache::new(DefaultFilesMetadataCache::new(
    let cursor = runtime.block_on(DocValuesCursor::open(
    fn width(self) -> usize {
    let store = store_from_ptr(store_ptr);
        // test cannot shrink the budget for tests running alongside it.
        let file = fixture_file();
        Bytes::from(writer.into_inner().unwrap().into_inner())
        let batch = RecordBatch::try_new(schema, vec![Arc::new(group) as ArrayRef]).unwrap();
    /// sign-extension rule from it alone, so a wrong mapping here reads the right bytes as the
            WriterVersion::PARQUET_1_0,
            parquet_df_close_iter(handle);
            0,
    fn small_forward_skip_keeps_growing_the_window() {
    column_ptr: *const u8,
        match self {
    /// Writes a dictionary-encoded v2 file of the given primitive type, jumps across pages, and
    /// The file here is put into an in-memory store behind a `TieredObjectStore`, so the stamped path
            DataType::UInt8 => Some(Self::Ubyte),
        ));
/// Status codes returned to Java. A negative return is an error-message pointer produced by
        assert_skip_shapes_decode(parquet_fixture_encoded(
            int64_values(&cursor.next_batch(0).unwrap()),
        )
    fn reaching_end_of_column_releases_the_borrow() {
    use opensearch_tiered_storage::tiered_object_store::TieredObjectStore;
    file_ptr: *const u8, // path bytes and length, since FFM cannot pass a Rust &str
            cursor
    reader: ParquetForwardBatchReader,
        let mut writer =
            CachedMetadataReaderFactory::new(store, Arc::clone(&metadata), Arc::clone(&stats)),
///
            (row % 7) as i32 * 3
            false,
        let values = (0..rows_per_page * 8)
        assert!(
            ProjectionMask::leaves(schema, [leaf_idx]),
        // it concurrently, so its length is not a signal this test can assert on.
            .unwrap()
            .unwrap();
            env.cache_manager.get_file_metadata_cache(),
        let _globals = crate::test_process_globals::lock();
        .map_err(DataFusionError::Execution)?;
        let column = batch.column(0).as_primitive::<P>();
        for message in [
        ));
    /// defensive. A validity bitmap keeps its offset, because a bit position cannot be folded into
        let booleans = arrow::array::BooleanArray::from(vec![true, false]);
            parquet_fixture_with_page_rows(row_groups, rows_per_page),
            reader,
            })
        assert_eq!(
 *
        let _globals = crate::test_process_globals::lock();
        ] {
use native_bridge_common::ffm_safe;
            (row % 7) as f32 * 0.5
    use opensearch_tiered_storage::registry::TieredStorageRegistry;
    use tempfile::NamedTempFile;
            .set_data_page_row_count_limit(ROWS_PER_PAGE)
        // decimal is a valid physical type but decodes to `Decimal128`, which cannot be borrowed.
/// reader pays O(rows accessed) rather than O(rows served) and avoids a per-batch copy.
}
        });
        let handle = open_fixture(&file);
    fn encoded_fixture_value(row: usize) -> i64 {
        Bytes::from(writer.into_inner().unwrap().into_inner())
        Bytes::from(writer.into_inner().unwrap().into_inner())
            stats.count.load(Ordering::Relaxed),
    cursor.batch_size = cursor.initial_batch_size;
        .map_err(|e| DataFusionError::Internal(format!("invalid UTF-8: {e}")))
/// # Safety
    }
                .unwrap()
/// Validates `target_row`, returning `true` when the cursor is exactly at end-of-column.
        let path = format!(
    #[test]
            None => {
    target_row: i64,
    }
                filename,
    )
            );
    cursor.reservation.resize(0);
                expected_kind.width(),
    fn planned_batch(&self, target_row: i64) -> Result<(usize, usize), DataFusionError> {
        assert_skip_shapes_decode(parquet_fixture_encoded(
    stats: Arc<ReadIoStats>,
    fn_name: &str,
            value_kind,
            "Boolean is bit-packed, so it needs a value bit offset before it can be exported"
            DataType::Int16 => Some(Self::Short),
            "the exported pointer must address the window's first row, not the buffer start"
            DataType::Int32 | DataType::Date32 | DataType::Time32(_) => Some(Self::Int),
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        );
            "the fixture path must not exist locally, or this test proves nothing"
        // Small forward skip inside page 0: the planner treats this as dense access.
        bytes: Bytes,
            unsafe { exported_i64s(later.values_addr, 1) },
            .unwrap();
    }
    validity_addr: usize,
    // clears its resident batch before calling. The reservation follows the batch.
        );
                .unwrap();
        );
    /// Reads back through the exported addresses across a whole multi-page scan, which is the only
    }
            matches!(err, DataFusionError::ResourcesExhausted(_)),
        assert!(!holds_borrow(handle));
    }
    /// The other fixtures disable dictionary encoding deliberately to control page layouts; this
/// Writes `value` through a nullable out-parameter.
        });
        runtime.block_on(DocValuesCursor::open(
        let batch = RecordBatch::try_new(schema, vec![Arc::new(array) as ArrayRef]).unwrap();
        DataFusionError::Configuration(
use datafusion::execution::memory_pool::{MemoryConsumer, MemoryReservation};
            DataType::Int64,
/// # Safety
    #[test]
        assert!(
        let batch = cursor.next_batch(second_rg + 11).unwrap();
    let handle = NEXT_HANDLE.fetch_add(1, Ordering::SeqCst);
/// configured budget.
    fn a_type_with_no_borrow_kind_is_not_borrowable() {
#[repr(i64)]
    /// # Safety
        // Clamp the ceiling first, then the starting window against it, so the decay floor
            .ok_or_else(|| format!("{FN}: unsupported non-numeric array {}", array.data_type()))?
    }
            ROWS_PER_PAGE,
    /// A warm shard's Parquet files are not on local disk, so the cursor must read every byte - footer,
    load_parquet_metadata_with_meta, CachedMetadataReaderFactory, ReadIoStats,
        handle
            BATCH_SIZE_HARD_LIMIT,
#[ffm_safe]
            .set_write_batch_size(rows_per_page)
            cursor.next_batch(rows_per_page as i64).unwrap().num_rows(),
        let _globals = crate::test_process_globals::lock();
        );
        let column = "absent";
fn runtime_env() -> Result<Arc<RuntimeEnv>, DataFusionError> {
    /// next batch call, on reset, or when close drops the cursor.
        assert_eq!(
        assert_eq!(batch.value_kind, BorrowKind::Long as i64);
            "an over-budget read must fail on the memory budget, not some other way: {err}"
    CURSORS.insert(handle, Arc::new(Mutex::new(cursor)));
    #[test]
            )
            location.as_ref(),
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        let batch =
                &mut first_row,
            true,
        let leaf_idx = match matches.as_slice() {
            .set_data_page_row_count_limit(rows_per_page)
    ) -> (DocValuesCursor, Arc<Runtime>) {
    }
        // Ask the store where the object lives rather than probing the filesystem for `filename`:
        );
        ));
        writer.write(&batch).unwrap();
            open_fixture_with_page_rows(1, rows_per_page, BATCH_SIZE_HARD_LIMIT / 2);
use arrow::record_batch::RecordBatch;
/// The node's shared `RuntimeEnv`, which owns the file-metadata cache and the memory pool a cursor
        let stats = Arc::new(ReadIoStats::default());
}
//!
            !holds_borrow(handle),
        let values = (0..rows_per_page * 2)
        .get(&handle)
                batch.last_row
    struct Batch {
/// and page index, so the rewind costs no IO.
                "value",
#[no_mangle]
            several => {
        let first = cursor.next_batch(0).unwrap();
        // Land on an exact page boundary: the first row of the landing page, where an
                .unwrap()
            .with_precision_and_scale(18, 2)
const LOCAL_STORE: i64 = 0;
use datafusion::datasource::physical_plan::parquet::ParquetFileReaderFactory;
        let message = error_message(next_batch(handle, 0).rc);
        let _globals = crate::test_process_globals::lock();
    const ROWS_PER_PAGE: usize = 64;
    /// Only valid while the cursor still holds the batch these addresses were borrowed from, so
}
                    .with_memory_pool(Arc::new(GreedyMemoryPool::new(64 * 1024 * 1024)))
                .unwrap();
                column.as_ptr(),
        assert!(
        assert_eq!(next_batch(handle, 0).rc, RC_OK);
        assert_eq!(
        let size = bytes.len() as u64;
    values_addr: usize,
        // No handle is returned, and `open_and_register` only inserts after a successful open, so
            })?;
            "local page reads must use the retained synchronous file descriptor"
            reads_before,
        });
            values_addr,
        file.write_all(&parquet_fixture_with_page_rows(1, ROWS_PER_PAGE))
    use super::*;
        );
        self.batch_size = window;
    /// A low-cardinality Int64 column written with a chosen dictionary mode and writer version.
            WriterVersion::PARQUET_2_0,
    }
    fn error_message(rc: i64) -> String {
    use parquet::file::properties::{EnabledStatistics, WriterProperties, WriterVersion};
/// `Arc` is cloned out of the box so the cursor keeps the store alive for its own lifetime rather
            .lock()
    /// exists in no filesystem at all: anything that fell back to a local read would fail outright
/// between open and read.
    write_out(out_validity_bit_offset, borrow.validity_bit_offset as i64);
        file.flush().unwrap();
        assert_eq!(cursor.next_batch(8).unwrap().num_rows(), 16);
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
    /// call this before the next entry-point call on the same handle.
            RecordBatch::try_new(Arc::clone(&schema), vec![Arc::new(array) as ArrayRef]).unwrap();
            encoded_expected(boundary as usize, batch.num_rows())
    #[test]
        store_ptr,
        let strings = arrow::array::StringArray::from(vec!["a", "b"]);
    Ok(RC_OK)
        file.flush().unwrap();
    fn dictionary_encoded_pages_decode_across_all_skip_shapes_with_writer_v2() {
        let err = cursor
    write_out(out_values_addr, borrow.values_addr as i64);
            TieredFileEntry::with_size(FileLocation::Local, None, size),
        // there is nothing to leak. `CURSORS` is process-wide and other tests add to and remove from
        let boundary = (ROWS_PER_PAGE * 7) as i64;
        );
        // No handle is returned, and `open_and_register` only inserts after a successful open, so
            .build();
    if target_row < 0 || target_row > cursor.row_count {
            row = batch.last_row + 1;
                &mut last_row,
        let rc = unsafe {
    if store_ptr <= LOCAL_STORE {
        let max_batch_size = max_batch_size.clamp(1, BATCH_SIZE_HARD_LIMIT);
            Float32Array, Float64Array, Int16Array, Int32Array, Int8Array, UInt16Array,
                .unwrap_or_else(|| panic!("{} must be borrowable", array.data_type()));
        assert_eq!(int64_values(&first), (0..8).collect::<Vec<_>>());
        (target..target + len).map(encoded_fixture_value).collect()
        let bytes = Bytes::from(writer.into_inner().unwrap().into_inner());
        // Flat schemas cannot produce an ambiguity, so this only applies to files written with a
    // plain addresses.
                batch.first_row,
    #[test]
    /// growth cap however the two settings are combined.
        let group = arrow::array::StructArray::new(children.into(), vec![left, right], None);
    /// Retained so tests can assert on the number of object-store range reads;
            .expect("a nested leaf is not a supported column type")
            parquet_fixture_with_page_rows(1, 1024),
            .is_some()
        // Rows 3..8 of an eight-row buffer.
        let path = file.path().to_str().unwrap();
    cursor.has_decoded_batch = false;
        let location = ObjectPath::from(path.as_str());
    fn dictionary_encoded_float64_decodes_after_cross_page_jump() {
            Arc::new(Field::new("left", DataType::Int64, false)),
        return Err(DataFusionError::Internal("null string pointer".to_string()));
/// Rewinds a cursor to row zero, rebuilding the Parquet decoder while reusing the resolved metadata
//! DataFusion supplies metadata, page indexes, and remote object-store/cache I/O.
    }
    #[test]
        runtime
            return Err(DataFusionError::NotImplemented(format!(
            (Arc::new(Float64Array::from(vec![1.0])), BorrowKind::Double),
    /// `Decimal128`, which has no [`BorrowKind`].
        // An unambiguous leaf resolves to a single column, but a nested leaf projects as a struct
        register_test_runtime_manager();
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
    /// the values buffer's own pointer (`ScalarBuffer::new(buffer, offset, len)` when a
    let mut cursor = cursor.lock();
        assert!(
                    .iter()
impl BorrowKind {
            !holds_borrow(handle),
        let page_remaining = self.reader.rows_remaining_in_page(target_row)?;
            let rows = (batch.last_row - batch.first_row + 1) as usize;
        dictionary: bool,
        // the registry keeps only a `Weak`, so ordering would otherwise decide whether an open works.
        assert_eq!(
        let tiny_pool: Arc<dyn datafusion::execution::memory_pool::MemoryPool> =
    }
        let _globals = crate::test_process_globals::lock();
                LOCAL_STORE, // these fixtures are real files on disk
    if target_row == cursor.row_count {
        filename: &str,
        // Registered here so a test is not left depending on another test having registered first:
    out_last_row: *mut i64,
            stats,
    /// the v1 type scope (INT32/FLOAT/DOUBLE), which no other test writes dictionary-encoded.
        store.registry().register(
        // cannot disagree.
        let schema = Arc::new(Schema::new(vec![Field::new(
    let values_addr = buffer.as_ptr() as usize + data.offset() * width;
    let mut cursor = cursor.lock();
        let mut writer =
    /// fails with `ResourcesExhausted` instead of growing native memory unchecked. Released on drop.
        let array = make_array(
        )]));
    fn adaptive_batches_grow_and_stop_at_page_boundaries() {
        rc: i64,
    let borrow = {
        // A read never crosses a page boundary, so a window larger than one page cannot be
        assert!(
    initial_batch_size: usize,
enum BorrowKind {
            .map(encoded_fixture_value)
            (second_rg + 11..second_rg + 19).collect::<Vec<_>>()
        assert!(error.contains("backward seek"), "{error}");
    /// the entry points without that startup path, so any read that needs the IO runtime must
    crate::test_process_globals::assert_held("the global DataFusion RuntimeEnv registration");
        let _globals = crate::test_process_globals::lock();
            .set_writer_version(version)
    }
        );
    }
use dashmap::DashMap;
        let _globals = crate::test_process_globals::lock();
    }
    }
        );
#[allow(clippy::too_many_arguments)]
        assert_eq!(second.num_rows(), 16);
                array.data_type()
    store_ptr: i64,
        )));
            // Only after the cursor is gone: it cloned the Arc, so this frees the box, not the store.
                    .with_cache_manager(cache_manager)
        // no bitmap to assert on.
        ))
        assert_eq!(next_batch(handle, 40).rc, RC_OK);
        let borrow = borrowable_buffers(array.as_ref()).expect("Int64 must be borrowable");
    pub(super) fn register_test_metadata_cache() {
            "the replacement batch must still be accounted"
    fn encoded_expected(target: usize, len: usize) -> Vec<i64> {
    cursor.borrowed_batch = None;
use arrow::array::Array;
            int64_values(&batch),
        let left = Arc::new(Int64Array::from((0..8_i64).collect::<Vec<_>>())) as ArrayRef;
        let stats = Arc::clone(&cursor.stats);
    fn an_ambiguous_column_name_is_rejected_rather_than_guessed() {
        let mut file = NamedTempFile::new().unwrap();
         tests call register_test_runtime_manager()"
            );
                path.as_ptr(),
            unsafe { exported_i64s(batch.values_addr, 8) },
    /// instead of quietly reading the wrong bytes.
    use datafusion::execution::runtime_env::RuntimeEnvBuilder;
}
        return Err(format!(
            Some(location.clone()),
        ))
        assert_eq!(
                RuntimeEnvBuilder::new()
                    || descriptor.path().string() == column
            .unwrap();
    }
    #[test]
        }
    let kind = BorrowKind::for_arrow(array.data_type())?;
    }
            )
            Self::Byte | Self::Ubyte => 1,
    fn a_lowered_maximum_caps_growth_below_the_hard_limit() {
        Bytes::from(writer.into_inner().unwrap().into_inner())
    handle: i64,
            .set_write_batch_size(rows_per_page)
/// Largest decode window this reader will accept, whatever the caller asks for.
                let path = local.path_to_filesystem(&location).ok();
            );
        let mut writer =
        }
    const FIXTURE_ROWS: i64 = (ROWS_PER_PAGE * 8) as i64;
            reservation,
    /// Retained so a reset can rebuild the reader without re-resolving metadata or the page index.
        register_test_metadata_cache();
///
    let column = str_from_raw(column_ptr, column_len).map_err(|e| format!("{FN} column: {e}"))?;
            "values decoded from the store must match what was written"
        );
        assert_eq!(cursor.next_batch(11).unwrap().num_rows(), 16);
        assert!(handle >= 0, "{}", error_message(handle));
            && target_row - position <= self.batch_size;
    // Released here rather than on success, so no early return below leaves buffers held. Java
        // Named per file so `TrackConsumersPool` can attribute usage.
    }
    let runtime = io_runtime()?;
    let buffer = data.buffers().first()?; // buffer 0 holds the values for a primitive array
}
            .expect_err("a batch that does not fit the pool must not be handed out");
    /// Chooses the decode window for `target_row` and returns `(window, rows)`:
            )));
    /// The value [`parquet_fixture_encoded`] writes at `row`: repeating, so dictionary encoding
            "the following non-null page should be fetched"
            !holds_borrow(handle),
    write_out(out_value_kind, borrow.kind);
        // bytes rather than adding to them, since a cursor holds at most one batch.
        }
        let window = window.min(page_rows);
        let batch = cursor.next_batch(across).unwrap();
                .next_batch((BATCH_SIZE_HARD_LIMIT + BATCH_SIZE_HARD_LIMIT / 2) as i64)
    fn open_iter(path: &str, initial: i64) -> i64 {
    fn plain_encoded_pages_decode_across_all_skip_shapes_with_writer_v2() {
    /// wrong numbers. Mirrors the `KIND_*` constants in `DecodedBatch.java` and the widths in
pub unsafe extern "C" fn parquet_df_open_iter(
/// See [`store_from_ptr`] for the contract `store_ptr` must satisfy.
            let expected = (batch.first_row..=batch.last_row).collect::<Vec<_>>();
//! Local shard files use Arrow's synchronous `ChunkReader` directly. Arrow owns
        );
        register_test_metadata_cache();
        let handle = open_fixture(&file);
        return Err(DataFusionError::Internal(format!(
    }
        let mut validity_bit_offset = -1i64;
                array.data_type().primitive_width().unwrap(),
        kind: kind as i64,
            (self.batch_size / 2).max(self.initial_batch_size)
const RC_OK: i64 = 0;
        Arc::clone(&runtime),
        };
            !error.contains("ambiguous"),
            .build();
        );
            4096,
    #[test]
/// pointer is a warm shard's `TieredObjectStore`, whose files live in the remote object store; the
        assert_eq!(next_batch(handle, 0).rc, RC_OK);
    })
        if BorrowKind::for_arrow(data_type).is_none() {
            )
        // Out of range: fails after the release, so nothing stays held.
            // Rejected before the file is touched, so the path is irrelevant.
        assert!(
            !holds_borrow(handle),
/// non-decreasing `advanceExact` contract never does. Kept because Lucene's own dense numeric
                LOCAL_STORE,
            .err()
            .block_on(DocValuesCursor::open(
            && target_row >= position
            CURSORS.get(&handle).is_none(),
        let matches = (0..schema.num_columns())
    }
    async fn open(
        let stats = Arc::clone(&cursor.stats);
    use tempfile::NamedTempFile;
    let batch = cursor.next_batch(target_row).map_err(|e| e.to_string())?;
        assert!(holds_borrow(handle));
            .set_write_batch_size(ROWS_PER_PAGE)
            "the bitmap is exported unshifted, because bit 3 is not at a byte boundary"
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
            .set_max_row_group_row_count(Some(rows_per_page * 4))
        assert!(
            (Arc::new(Int8Array::from(vec![1])), BorrowKind::Byte),
}
            ))
    // The object path is derived from `filename` in both cases. A warm shard's registry is keyed by
        let column = "value";
    pub(super) fn parquet_fixture_with_decimal_column(rows_per_page: usize) -> Bytes {
        assert!(error.contains("unsupported type Struct"), "{error}");
            assert!(message.contains("unknown handle"), "{message}");
        assert_eq!(cursor.next_batch(8).unwrap().num_rows(), 16);
/// `store_ptr` must be `0` or a pointer obtained from `ts_get_object_store_box_ptr` that has not yet
                (Arc::new(local), path)
            );
        );
            error_message(next_batch(unknown, 0).rc),
    }
use parking_lot::Mutex;
    // `usize` on cast, and the Java reader exposes an int overload that bypasses settings resolution.
            DataType::Int8 => Some(Self::Byte),
//!
            (row % 7) as f64 * 0.5
        let (mut cursor, _runtime) = open_fixture(1, 8);
    use std::io::{Cursor, Write};
///
        for initial in [0, -1, BATCH_SIZE_HARD_LIMIT as i64 + 1] {
    /// one exists to exercise the skip path against dictionary-encoded pages and both data-page
            .set_write_batch_size(rows_per_page)
                })?; // OffsetIndex + ColumnIndex scoped to just this column
        // serve doc values for the wrong column.
    use crate::cache::metadata_cache::MutexFileMetadataCache;
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
        let props = WriterProperties::builder()
    #[test]
        let message = error_message(next_batch(handle, 0).rc);
/// Adding a type means adding a variant here plus arms in [`BorrowKind::for_arrow`] and
        let location = ObjectPath::from(format!(
unsafe fn write_out(ptr: *mut i64, value: i64) {
                    DataFusionError::Execution(format!(
            schema,
fn borrowable_buffers(array: &dyn Array) -> Option<BorrowedBuffers> {
        let mut first_row = -1i64;
    fn open_parquet_fixture_with_max(
            DataType::Float32 => Some(Self::Float),
        open_fixture_with_page_rows(row_groups, ROWS_PER_PAGE, batch_size)
    }
            return Err(DataFusionError::Internal(format!(
    /// TODO: boolean needs a bit-packed values buffer with a value bit offset, mirroring the
    fn a_served_batch_is_retained_so_javas_pointers_stay_valid() {
    }
            assert_eq!(rows, expected, "window at row {row}");
        let handle = unsafe {
        row_groups: usize,
            0,
    /// each time. Shared by the dictionary/writer-version matrix below.
        let _globals = crate::test_process_globals::lock();
    ) -> Result<Self, DataFusionError> {
 * this file be licensed under the Apache-2.0 license or a
        );
        let batch =
    if let Some(manager) = crate::ffm::try_get_rt_manager() {
        let location = ObjectPath::from(format!(
            ROWS_PER_PAGE,
            location.as_ref(),
            encoded_expected(within as usize, batch.num_rows())
    ///
    out_values_addr: *mut i64,
    target_row: i64,
                expected_kind as i64,
        assert_eq!(batch.last_row, 7, "the initial window is eight rows");
    }
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
            reads_before,
            "/var/data/nodes/0/indices/idx/0/parquet/_generation_{}.parquet",
        }
    }
/// would fail here and nowhere else; this turns that into a slow read rather than a shard failure.
        assert_eq!(next_batch(handle, FIXTURE_ROWS).rc, RC_EOF);
            has_decoded_batch: false,
            .value()
            DataType::Struct(children.clone().into()),
                Some(Self::Long)
            "a boundary-clamped read must not reset dense-scan growth"
            (Arc::new(Float32Array::from(vec![1.0])), BorrowKind::Float),
    }
        .map(|entry| Arc::clone(entry.value()))
        // Local files read through a synchronous `ChunkReader`; anything else goes via the store.
            self.batch_size
        );
        let cursor = runtime
        cursor.reservation = MemoryConsumer::new("tiny-budget").register(&tiny_pool);
        let runtime = Arc::new(Builder::new_current_thread().enable_all().build().unwrap());
            cursor.next_batch(56).unwrap().num_rows(),
        use arrow::array::{AsArray, PrimitiveArray};
    if ptr.is_null() {
    fn dictionary_encoded_int32_decodes_after_cross_page_jump() {
    std::str::from_utf8(std::slice::from_raw_parts(ptr, len as usize))
            row = batch.last_row + 1;
            Self::Short | Self::Ushort => 2,
    fn adaptive_window_is_capped_at_max_batch_size() {
/// reader, and hand Java the decoded Arrow batch's buffers zero-copy.
        assert_eq!(
        // Without the reset this would be a rejected backward seek.
    }
    let filename = str_from_raw(file_ptr, file_len).map_err(|e| format!("{FN} file: {e}"))?;
            "no global DataFusion runtime environment; the analytics-backend-datafusion global \
        assert!(handle >= 0, "{}", error_message(handle));
            .collect::<Vec<_>>();
    }
        (cursor, runtime)
        max_batch_size as usize,
        assert!(borrowable_buffers(&strings).is_none(), "Utf8");
///
    initial_batch_size: usize,
        let bytes = parquet_fixture_with_page_rows(1, ROWS_PER_PAGE);
/// Exposes an Arrow primitive array's buffers for zero-copy reads from Java.
            "a resident batch must be accounted against the pool"
    // The FFM contract carries only a message (see native_bridge_common::error), so the typed
            assert_eq!(
        max_batch_size: usize,
                return Err(DataFusionError::Plan(format!(
/// `0` means the shard's Parquet files are on local disk, which is every hot shard: the cursor
//! `parquet_df_open_iter` returns an opaque cursor handle, not a pointer: it keys a
            .unwrap();
    out_first_row: *mut i64,
            .build();
/// on the calling thread. Required rather than defaulted: `RuntimeManager` sizes this pool from the
use datafusion::execution::cache::cache_manager::FileMetadataCache;
        let non_null = cursor.next_batch(ROWS_PER_PAGE as i64).unwrap();
            cursor.max_batch_size
            "nothing is borrowed before the first read"
            let message = error_message(open_iter("/nonexistent/never-opened.parquet", initial));
    }
        self.has_decoded_batch = true;
            let cache_manager = CacheManagerConfig::default().with_file_metadata_cache(Some(cache));
            NEXT_HANDLE.fetch_add(1, Ordering::Relaxed)
mod ffm_tests {
        let batch = next_batch(handle, 0);
            "{FN}: initial batch size {initial_batch_size} outside 1..={max_batch_size}"
    const ROWS_PER_PAGE: usize = 64;
        assert_eq!(cursor.reader.position(), 25);
    /// Accounts the resident batch against the node's shared `MemoryPool`, so an over-budget read
        cursor.next_batch(0).expect("the batch must fit the budget");
pub unsafe extern "C" fn parquet_df_reset_iter(handle: i64) -> i64 {
    /// `ptr` must come from [`leak_store_pointer`] and not have been freed.
        let handle = open_iter(file.path().to_str().unwrap(), 8);
                super::tests::TEST_MAX_BATCH_SIZE as i64,
            .collect::<Vec<_>>();
        let _globals = crate::test_process_globals::lock();
                .to_string(),
    fn forward_jump_uses_arrow_skip_without_fetching_intermediate_pages() {
        // Replaces the cursor's own reservation rather than the process-wide registration, so this
        assert_eq!(
    reservation: MemoryReservation,
        assert_eq!(
    fn an_out_of_range_initial_window_is_rejected() {
#[no_mangle]
    has_decoded_batch: bool,
    // error is flattened here at the boundary.
        Ok(Self {
        let row_count = row_groups * rows_per_page * 8;
            "close must drop the cursor, releasing the retained Arrow buffers"
            .unwrap();
                store_ptr,
                location.as_ref(),
        let mut writer =
//! # Handles
        unsafe {
    }
            false,
    fn int64_values(batch: &RecordBatch) -> Vec<i64> {
    }
    if at_eof(&cursor, target_row, FN).map_err(|e| e.to_string())? {
        ));
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
        let _globals = crate::test_process_globals::lock();
        assert_ne!(batch.values_addr, 0, "a borrowed batch must expose values");
            reserved > 0,
        let message = error_message(open_iter(file.path().to_str().unwrap(), 8));
    /// borrow; a wrong address, a wrong kind, or an unfolded array offset keeps the batch alive
            assert_eq!(
        )
        .with_local_file(local_path);
        let mut row = 0;
                TEST_MAX_BATCH_SIZE,
            Arc::clone(&runtime),
/// `ffm_safe`, so only non-negative values are status; 1 is unused. Mirrors `ParquetCodecBridge`.
        );
        )
        assert!(message.contains("unknown handle"), "{message}");
        let handle = open_fixture(&file);
        let schema = Arc::new(Schema::new(vec![Field::new(
}
        )]));
    /// check on what Java actually sees. The tests around this one assert the *lifetime* of the
    /// Int8/Int16/Int32/Date32 depending on its logical type.
        let _globals = crate::test_process_globals::lock();
///
            Box::new(store as Arc<dyn MetadataCachingStore>);
            [] => {
        // Collect every candidate rather than taking the first: two leaves in different row groups
    cursor: &DocValuesCursor,
    static FN: &str = "parquet_df_next_batch";
                DataFusionError::Internal(format!("reader exhausted before row {target_row}"))
        let jumped = cursor.next_batch(target).unwrap();
        let jump = (ROWS_PER_PAGE * 6 + 3) as i64;
        let (cursor, _runtime) = open_parquet_fixture_with_max(
//! v1 scope: numeric fixed-width leaf columns only (INT32/INT64/FLOAT/DOUBLE).
    // `shardPath.getDataPath().resolve(file)`), and both `ObjectPath` and the registry normalise the
            Arc::clone(&store),
            Arc::new(TieredStorageRegistry::new()),
            int64_values(&batch),
        );
        let _globals = crate::test_process_globals::lock();
    /// The starting window is clamped to the ceiling, so the decay floor can never sit above the
    use object_store::ObjectStoreExt;
    #[test]
        assert_eq!(
        assert_eq!(
    #[test]
    // the same absolute path this cursor is opened with (`StoreStrategyRegistry` seeds it from
    }
    fn open_fixture_with_page_rows(
    fn a_column_that_cannot_be_borrowed_is_rejected_at_open() {
        ];
#[cfg(test)]
    /// Ceiling the window grows to, captured at open from
        // `window` is the size to remember for next time; `rows` is what we
        register_test_metadata_cache();
            8,
        let mut value_kind = -1i64;
    /// and Java is handed exactly one address per buffer.
    out_validity_addr: *mut i64,
#[no_mangle]
        // ceiling, against representative query shapes.
        let mut file = NamedTempFile::new().unwrap();
        let window = if dense {
        drop(cursor);
        );
/// [`BorrowKind::width`], and a matching constant on the Java side.
                        .path()
    use object_store::memory::InMemory;
            assert_eq!(batch.rc, RC_OK, "row {row}");
            "a later page must also come through the store"
    ) -> (DocValuesCursor, Arc<Runtime>) {
                Arc::clone(&runtime),
/// than depending on the shard's box outliving it.
    /// The kind is the whole of the Rust-to-Java type contract: Java picks a byte width and a
        );
    /// about a different cap pass their own, since the value is per cursor.
/// uses. Required rather than defaulted: a cache or pool created here would sit outside the node's
    /// engages; position-derived, so a read after a skip proves it landed where it aimed.
) -> i64 {
            values_base + 3 * std::mem::size_of::<i64>(),
    /// supplied by the caller along with its own `location_override`.
    fn a_supplied_store_is_read_through_for_a_file_that_is_on_no_local_disk() {
                "row {target_row} out of range (0..{})",
    Ubyte = 7,    // u8, zero-extended
        let batch = self
            "negative string length: {len}"
        // EOF returns before decoding, so it must not leave the previous batch held.
    /// Releases a pointer from [`leak_store_pointer`], mirroring `ts_destroy_object_store_box_ptr`.
        let _globals = crate::test_process_globals::lock();
            )
        // satisfied. The remembered window is capped at the whole page; only the rows decoded now
                let paths = several
        // actually decode now.
        let _globals = crate::test_process_globals::lock();
        let (mut cursor, _runtime) =
///
        let _globals = crate::test_process_globals::lock();
    }
        let jump = (ROWS_PER_PAGE * 3 + 5) as i64;
    /// also handed to the reader factory to attribute I/O.
            _ => None,
    #[test]
                    .join(", ");
            parquet_df_next_batch(
    /// Stands in for the environment production registers from `create_global_runtime`. Held in a
    initial_batch_size: i64,
        file.flush().unwrap();
    fn a_closed_handle_is_no_longer_usable() {
use crate::cache::page_index::load_scoped_page_index_cols;
        for row in 0..batch.num_rows() {
        );
        // Decay is multiplicative (32 -> 16), not a reset to the initial window.
    column_len: i64,
/// holds `crate::test_process_globals::lock` for its whole body. Uniformly, including the few tests
        }
        let _globals = crate::test_process_globals::lock();
    #[test]
        let _globals = crate::test_process_globals::lock();
            "doc-values-cursor-{}.parquet",
    let cursor = cursor_for(handle, FN).map_err(|e| e.to_string())?;
        let file = fixture_file();
            (Arc::new(Int32Array::from(vec![1])), BorrowKind::Int),
        assert_eq!(cursor.next_batch(jump).unwrap().num_rows(), 8);
        );
                    .collect::<Vec<_>>()
    fn parquet_fixture_with_two_leaves_under_one_group() -> Bytes {
        CURSORS
                                          // Fold the array offset into the pointer so it addresses row 0. Zero for primitive arrays, whose
            stats.count.load(Ordering::Relaxed),
            cursor.stats.count.load(Ordering::Relaxed) > reads_before,
                .unwrap();
    fn open_named_column(bytes: Bytes, column: &str) -> Result<DocValuesCursor, DataFusionError> {
        );
    Byte = 6,     // i8, sign-extended
            cursor.reservation.size() > 0,
    Some(BorrowedBuffers {
        unsafe {
        let (mut cursor, _runtime) = open_fixture(2, 8);
        assert_eq!(int64_values(&first), encoded_expected(0, first.num_rows()));
        // the initial size after every jump.
        let target = (ROWS_PER_PAGE * 5) as i64;
            .to_string(),
        Bytes::from(writer.into_inner().unwrap().into_inner())
/// doc values tolerate a backward target (their layout is seekable), so a non-compliant caller
            .downcast_ref::<Int64Array>()
    kind: i64,
        runtime: Arc<Runtime>,
}
/// Opens a cursor and registers it, returning the handle Java holds.
 * SPDX-License-Identifier: Apache-2.0
                .unwrap();
/// Java reads the values buffer and validity bitmap in place, widening per accessed row, so a sparse
    }
            footer.file_metadata().key_value_metadata(),
    #[test]
                max,
    pub(super) const TEST_MAX_BATCH_SIZE: usize = BATCH_SIZE_HARD_LIMIT;
    use datafusion::execution::cache::cache_manager::CacheManagerConfig;
            int64_values(&jumped),
        )]));
impl DocValuesCursor {
    /// page index and pages - through the store pointer Java supplies rather than through its own
        assert!(
        }
    borrowed_batch: Option<RecordBatch>,
}
            assert_eq!(batch.first_row, row);
            assert_eq!(batch.rc, RC_OK, "row {row}: {}", batch.last_row);
            cursor.row_count
        // A window with no nulls in it is dropped by `ArrayDataBuilder::build`, which would leave
        let batch =
    // Scoped so the borrow ends before `batch` moves onto the cursor; `BorrowedBuffers` holds
    where
                "unsupported type {data_type} for column '{column}'"
    /// `window` is the adaptive size to remember for next time, `rows` is how much
}
        let mut writer =
        assert_eq!(unsafe { parquet_df_reset_iter(handle) }, RC_OK);
            .set_dictionary_enabled(true)
        )]));
            "reset must release the retained batch"
            TEST_MAX_BATCH_SIZE,
        assert!(message.contains("unsupported type Decimal128"), "{message}");
        let unknown = i64::MAX;
        assert_eq!(second.column(0).null_count(), 16);
            ProjectionMask::leaves(metadata.file_metadata().schema_descr(), [leaf_idx]);
    #[test]
        let cases: Vec<(ArrayRef, BorrowKind)> = vec![
                "batch [{}, {}]",
            assert_eq!(batch.value_kind, BorrowKind::Long as i64);
                path.len() as i64,
        let mut values_addr = 0i64;
    /// True when the cursor behind `handle` is holding Arrow buffers on Java's behalf.
            }
        cursor.next_batch(8).expect("the batch must fit the budget");
            RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values)) as ArrayRef])
        );
    crate::test_process_globals::assert_held("the process-global runtime manager");
            "the values window is carried by the buffer pointer, not by the offset"
/*
        assert_eq!(
    }
            // rows the batch claims to cover.
    }
            .err()
    out_validity_bit_offset: *mut i64,
        if target_row < 0 || target_row >= self.row_count {
        }
        // A page boundary, so the read cannot be satisfied from the first fetch alone.
    #[test]
        let mut row = 0i64;
    max_batch_size: i64,
                        "no page index available for column '{column}' in {filename}"
    }
        // Skips no larger than the current window are page-scale dense access
                batch_size,
    }
    use object_store::ObjectStoreExt;
        let array = arrow::array::Decimal128Array::from(values)
        let (mut cursor, _runtime) = open_parquet_fixture(bytes, 8);
        assert_eq!(cursor.initial_batch_size, configured_max);
/// that only exercise pure decode logic: "every test in this module holds it" is a rule that
    ))
                8,
            parquet_fixture_with_page_rows(1, 1024),
/// Resolves the store a cursor reads through from a Java-supplied pointer.
) -> Result<bool, DataFusionError> {
            DataType::UInt32 => Some(Self::UintBits),
    /// to Arrow `Decimal128`, which cannot be borrowed. `open` gates on the decoded Arrow type, so it
        let validity_base = validity_buffer.as_ptr() as usize;
    use opensearch_tiered_storage::types::{FileLocation, TieredFileEntry};
        column: &str,
            Arc::new(Field::new("right", DataType::Int64, false)),
    #[test]
                let descriptor = schema.column(idx);
            BATCH_SIZE_HARD_LIMIT / 2
        let decimal = arrow::array::Decimal128Array::from(vec![1_i128, 2])
            .set_dictionary_enabled(dictionary)
    fn retained_arrow_reader_crosses_row_groups_and_rejects_backward_seeks() {
            )
pub unsafe extern "C" fn parquet_df_close_iter(handle: i64) -> i64 {
        // A cursor holds one batch at a time, so the next read replaces the accounting.
        let (mut cursor, _runtime) = open_fixture(2, 8);
const BATCH_SIZE_HARD_LIMIT: usize = 8_192;
    /// is refused before a cursor exists rather than on the first read.
        batch_size: usize,
    #[test]
            cursor.reservation.size(),
        );
    /// Reads the message an error return points at, taking ownership so it is freed rather than
        // can share a name, and a group root can cover several leaves. Serving whichever came first
    fn assert_dictionary_jump_decodes<P>(data_type: DataType, value_at: fn(usize) -> P::Native)
            .set_statistics_enabled(EnabledStatistics::Page)
            (0..8).collect::<Vec<_>>()
        let first = cursor.next_batch(17).unwrap();
            RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values)) as ArrayRef])
        return Err(format!(
            array.to_data().offset(),
    use parquet::arrow::ArrowWriter;
            initial_batch_size: batch_size,
        assert!(message.contains("out of range"), "{message}");
    fn closing_while_holding_a_borrow_drops_the_cursor() {
        last_row: i64,
    }
        // Before adding a Parquet DocValuesProducer, measure latency with concurrent queries over
        assert_eq!(batch.first_row, 0);
    static FN: &str = "parquet_df_open_iter";
        assert_eq!(cursor.next_batch(0).unwrap().num_rows(), 8);
            "the adaptive window must not grow beyond the configured maximum"
        let _globals = crate::test_process_globals::lock();
                .unwrap();
    }
            3,
#[derive(Copy, Clone, Debug, PartialEq, Eq)]
    static FN: &str = "parquet_df_reset_iter";
}
        let first = cursor.next_batch(0).unwrap();
                .unwrap();
        assert_eq!(
            .set_max_row_group_row_count(Some(ROWS_PER_PAGE * 8))
    }
            .unwrap();
    }
        use arrow::array::{make_array, ArrayData};
    Ok(RC_OK)
        let (mut cursor, _runtime) = open_fixture(1, 8);
    }
    }
    #[test]
        return Ok(RC_EOF); // target is past the last row (e.g. a scan running off the end)
    cursor.borrowed_batch = None;
        let _globals = crate::test_process_globals::lock();
                    || descriptor
    }
        let (mut cursor, _runtime) = open_parquet_fixture(bytes, 8);
    /// The two buffers reach that address differently. Arrow folds a primitive array's window into
        assert_eq!(stats.count.load(Ordering::Relaxed), 1);
    fn parquet_fixture_with_all_null_page(rows_per_page: usize) -> Bytes {
    let width = kind.width();
        assert!(borrowable_buffers(&decimal).is_none(), "Decimal128");
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
            DataType::Int64,
    use object_store::memory::InMemory;
    use bytes::Bytes;
    /// a byte pointer, which is why the bit offset is a separate out-parameter.
        assert_eq!(rewound.rc, RC_OK);
    file_len: i64,
        let handle = open_fixture(&file);
        let file = fixture_file();
        let schema = Arc::new(Schema::new(vec![Field::new(
        let bytes = parquet_fixture_with_two_leaves_under_one_group();
            .set_data_page_row_count_limit(rows_per_page)
        assert_skip_shapes_decode(parquet_fixture_encoded(
    batch_size: usize,
        max_batch_size: usize,
        let array = PrimitiveArray::<P>::from_iter_values((0..ROWS_PER_PAGE * 8).map(value_at));
        register_test_runtime_manager();
            8,
use object_store::local::LocalFileSystem;
/// Java-side interpretation of a borrowed values buffer, and the single place a supported column
    CURSORS
            }
use arrow::datatypes::DataType;
            (Arc::new(Int16Array::from(vec![1])), BorrowKind::Short),
    fn leak_store_pointer(store: Arc<TieredObjectStore>) -> i64 {
        let mut validity_addr = 0i64;
        file
        self.reservation.try_resize(batch.get_array_memory_size())?;
        );
        return Err(format!(
///
    let rows = batch.num_rows();
/// survives the next test being added, and the affected tests run in 0.03s serially.
        );
                Some(location.clone()),
            ))) as Arc<dyn FileMetadataCache>;
            self.batch_size.saturating_mul(2).min(self.max_batch_size)
    fn each_borrowable_arrow_type_maps_to_the_kind_java_expects() {
            ArrayData::builder(DataType::Int64)
        let file = fixture_file();
                Arc::clone(&runtime),
    use datafusion::execution::memory_pool::GreedyMemoryPool;
            first_row,
        Ok((window, window.min(page_remaining)))
        rows_per_page: usize,
    /// replaced — see `crate::test_process_globals::install_runtime_manager`.
        let _globals = crate::test_process_globals::lock();
        assert_eq!(cursor.next_batch(24).unwrap().num_rows(), 32);
                descriptor.name() == column
            Arc::new(
            .to_string();
    /// Rejected rather than exported as raw bytes Java would silently misread.
    fn dictionary_encoded_float32_decodes_after_cross_page_jump() {
            Self::Int | Self::UintBits | Self::Float => 4,
    fn all_null_page_is_skipped_without_fetch_or_decode() {
        let props = WriterProperties::builder()
        let validity_buffer = Buffer::from_slice_ref([0b1111_0111_u8]);
        })
        let error = cursor.next_batch(second_rg - 1).unwrap_err().to_string();
        );
#[ffm_safe]
            false,
    pub(super) fn parquet_fixture_encoded(
        assert!(holds_borrow(handle));
        // Bitmaps are indexed from the least significant bit, so this clears bit 3: row 3 is null.
    }
use object_store::{ObjectStore, ObjectStoreExt};
            .build();
        );
        let file = fixture_file();
    out_value_kind: *mut i64,
    /// Plain-encoded v1 is what every other test in this module writes; this covers the remaining
        let schema = Arc::new(Schema::new(vec![Field::new(
    /// Wraps `store` the way `ts_get_object_store_box_ptr` does, so the pointer handed to
    fn exported_addresses_read_back_as_the_rows_the_batch_reports() {
                column.len() as i64,
    }
            .set_data_page_row_count_limit(rows_per_page)
        ));
            rc,
            cursor
    write_out(out_first_row, target_row);
        .await
    use datafusion::execution::cache::DefaultFilesMetadataCache;
        let _globals = crate::test_process_globals::lock();
            .block_on(store.put(&location, bytes.into()))
        assert!(
        let _globals = crate::test_process_globals::lock();
        let batch =
            (Arc::new(UInt16Array::from(vec![1])), BorrowKind::Ushort),
            cursor.next_batch(64).unwrap().num_rows(),
                    "column '{column}' not found in {filename}"
    use arrow::record_batch::RecordBatch;
                Some(store),
use once_cell::sync::Lazy;
    }
    fn open_fixture(row_groups: usize, batch_size: usize) -> (DocValuesCursor, Arc<Runtime>) {
            last_row,
            2,
/// Tests driving the `extern "C"` entry points: handle registry, status codes, and `borrowed_batch`,
            reader_factory,
    }
        let schema = Arc::new(Schema::new(vec![Field::new("value", data_type, false)]));
use crate::forward_reader::{ParquetForwardBatchReader, ParquetForwardBatchReaderFactory};
}
        let props = WriterProperties::builder()
    Long = 1,     // i64 / u64 raw bits
                path.len() as i64,
        let (_arrow_schema, file_size, footer) = load_parquet_metadata_with_meta(
                .num_rows(),
        ));
        P::Native: PartialEq + std::fmt::Debug,
        writer.write(&batch).unwrap();
    /// Reads values back out of an exported buffer the way Java does, via
                return Err(DataFusionError::Plan(format!(
        );
            "{FN}: max batch size {max_batch_size} outside 1..={BATCH_SIZE_HARD_LIMIT}"
                        .is_some_and(|root| root == column)
                path.len() as i64,
        let error = open_named_column(bytes.clone(), "group")
    }
        )));
            cursor.stats.count.load(Ordering::Relaxed),
    }
        value_kind: i64,
            assert!(
//!
        assert_eq!(
        max_batch_size,
        assert_eq!(cursor.next_batch(jump).unwrap().num_rows(), 16);
    #[test]
        column,
                .ok_or_else(|| {
        );
        filename,
        let (window, rows) = self.planned_batch(target_row)?;
        );
        let _globals = crate::test_process_globals::lock();
        // would read the wrong column silently, so an ambiguous name is an error.
/// type is defined. Discriminants are the wire values; mirrors `DecodedBatch.KIND_*`.
            .map(|row| (row >= rows_per_page).then_some(row as i64))
    // first, because `Arc::clone` alone cannot infer the supertrait.
            "the test is only meaningful below the hard limit"
            int64_values(&cursor.next_batch(target).unwrap()),
        borrowable_buffers(array.as_ref())
            parquet_df_open_iter(
            "a batch must not decode across a data-page boundary"
        validity_bit_offset, // bit index of row 0 within that bitmap (bitmaps are bit-addressable)
        match data_type {
        let _globals = crate::test_process_globals::lock();
        assert_eq!(next_batch(handle, 0).rc, RC_OK);
        // dictionary-encoded chunk the dictionary must still resolve on the landing page.
            .set_dictionary_enabled(false)
        static ENV: Lazy<Arc<RuntimeEnv>> = Lazy::new(|| {
        assert!(holds_borrow(handle), "the served batch must be retained");
        let _globals = crate::test_process_globals::lock();
///
    let cursor = cursor_for(handle, FN).map_err(|e| e.to_string())?;
            (Arc::new(UInt64Array::from(vec![1])), BorrowKind::Long),
        ));
    if max_batch_size <= 0 || max_batch_size > BATCH_SIZE_HARD_LIMIT as i64 {
        let factory = ParquetForwardBatchReaderFactory::new(
    cursor.borrowed_batch = Some(batch);
    #[test]
/// Shared entry-point prologue: resolves a live cursor handle.
            "end of column must release the retained batch"
        for (array, expected_kind) in cases {
            .to_string();
            batch_size,
    // Written only once the export is known good, so a failed call leaves them untouched.
            "the max-sized window is clamped at the page boundary"
    fn only_one_batch_is_retained_across_a_long_scan() {
        // it concurrently, so its length is not a signal this test can assert on.
        let boxed: Box<Arc<dyn MetadataCachingStore>> =
            validity_addr,
        Some(nulls) => (nulls.buffer().as_ptr() as usize, nulls.offset()),
        // reader holds while decoding are not reserved against the pool.
    {
    Float = 9,    // f32 raw bits; Java re-encodes to a sign-extended sortable int
            .expect("an ambiguous column must not open")
        let right = Arc::new(Int64Array::from((8..16_i64).collect::<Vec<_>>())) as ArrayRef;
        register_test_runtime_manager();
        ));
        // nested schema, by a future mapping type or another writer.
            row += rows as i64;
            RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values)) as ArrayRef])
        }
#[ffm_safe]
        parquet_fixture_with_page_rows, register_test_metadata_cache, register_test_runtime_manager,
        let target_row = target_row as usize;
    crate::cache::global_runtime_env().ok_or_else(|| {
        let projection =
        return None;
        let mut row = 0;
        let _globals = crate::test_process_globals::lock();
            BATCH_SIZE_HARD_LIMIT / 2,
                    "column '{column}' is ambiguous in {filename}; it matches {paths}"
        assert_eq!(
    /// Opens a cursor over one column. `store_override` is the store that owns `filename`; `None`
                                          // window Arrow folds into the buffer pointer, but not for `BooleanArray`.
        // "group" is the root of two leaves. Binding it to whichever came first would silently
        }
            );
        let batch = cursor.next_batch(target).unwrap();
    }
        let _globals = crate::test_process_globals::lock();
        std::slice::from_raw_parts(addr as *const i64, rows).to_vec()
        let rc = unsafe {
    Int = 2,      // i32 / date32, sign-extended
        let backing: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        assert_eq!(cursor.max_batch_size, configured_max);
    })
    }
            "Arrow should fetch only the first and target data pages"
        let props = WriterProperties::builder()
                super::tests::TEST_MAX_BATCH_SIZE as i64,
    #[cfg(test)]
        // (e.g. a moderately selective filter) and must not stall the ramp-up.
#[cfg(test)]
    /// register a manager explicitly first. Installed once for the whole test process, never
    // 0 for a local (hot) shard; a warm shard passes its TieredObjectStore box pointer.
    fn a_borrowed_window_exports_row_zero_and_its_first_validity_bit() {
            "{FN}: Arrow returned {rows} rows, expected 1..={}",
        // Jump past several pages: whole pages are skipped without decoding, and for a
                .add_buffer(values_buffer)
///
        assert_eq!(cursor.next_batch(24).unwrap().num_rows(), 32);
            false,
            .unwrap();
        assert_dictionary_jump_decodes::<arrow::datatypes::Float64Type>(DataType::Float64, |row| {
    #[test]
            backing,
        let _globals = crate::test_process_globals::lock();
    fn holds_borrow(handle: i64) -> bool {
            (Arc::new(Int64Array::from(vec![1])), BorrowKind::Long),
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
    }
            .set_statistics_enabled(EnabledStatistics::Page)
    #[test]
            .set_write_batch_size(rows_per_page)
            false,
        None => (0, 0),
static NEXT_HANDLE: AtomicI64 = AtomicI64::new(1); // 0 is never a live handle
        let schema = Arc::new(Schema::new(vec![Field::new(
    }
    #[test]
        assert_eq!(next_batch(handle, 0).rc, RC_OK);
            let batch = next_batch(handle, row);
        store,
        // off-by-one in page-granular skips would surface.
    /// formats (v1 `DataPage` vs v2 `DataPageV2`). Values repeat (`row % 7`) so the writer
                message.contains("initial batch size"),
                "value",
        return Ok(Arc::clone(&manager.io_runtime));
            "group",
        return Err(DataFusionError::Internal(format!(
                column.len() as i64,
            .as_any()
        // Adaptive decode window: geometric growth with multiplicative backoff. A forward skip no
            NEXT_HANDLE.fetch_add(1, Ordering::Relaxed)
}
    use super::tests::{
        let forward = next_batch(handle, 32);
            .with_precision_and_scale(18, 2)
    // Re-checked here because these arrive as untrusted `i64`: a negative would wrap to an enormous
        // the same column, and cache the descriptor per file if it shows.
        validity_addr, // start of the null-bitmap buffer; the bit offset is applied separately
                batch.validity_addr, 0,
        let message = error_message(next_batch(handle, FIXTURE_ROWS + 1).rc);
        writer.write(&batch).unwrap();
            .collect::<Vec<_>>();
        let reservation = MemoryConsumer::new(format!("parquet-docvalues-cursor:{location}"))
                8,
        let rewound = next_batch(handle, 0);
unsafe fn store_from_ptr(store_ptr: i64) -> Option<Arc<dyn ObjectStore>> {
        // Reject on the Arrow type the reader will produce, not the Parquet physical type: an INT64
        return Ok(true);
        // maps onto one. A caller-supplied store reads through its own IO.
                let local = LocalFileSystem::new();
            CString::from_raw((-rc) as *mut c_char)
    use arrow::array::{ArrayRef, Int64Array};
            .reader
                .num_rows(),
    factory: ParquetForwardBatchReaderFactory,
            .set_writer_version(WriterVersion::PARQUET_2_0)
            std::path::Path::new(&path).exists() == false,
            .values()
    fn a_starting_window_above_the_maximum_is_lowered_to_it() {
    use tokio::runtime::Builder;
            let rows = cursor.next_batch(row).unwrap().num_rows();
    }
            metadata,
        assert!(message.contains("not found"), "{message}");
    /// `initial_batch_size` mid-cursor.
    #[test]
            cursor.stats.count.load(Ordering::Relaxed),
        values_addr: i64,
                "the fixture column is required, so no bitmap should be exported"
        //
                .unwrap();
    fn dictionary_encoded_pages_decode_across_all_skip_shapes_with_writer_v1() {
        assert_eq!(batch.first_row, 0);
        let (mut cursor, _runtime) = open_parquet_fixture_with_max(
        crate::test_process_globals::install_runtime_manager();
        assert!(
    /// `parquet_fixture_with_page_rows` writes eight pages per row group.
        // TODO: the growth and backoff factors are not benchmarked. Tune them, and the default
            .to_vec()
            borrow.validity_addr, validity_base,
            "so Java is handed the bit offset to apply itself"
    #[test]
fn cursor_for(handle: i64, fn_name: &str) -> Result<Arc<Mutex<DocValuesCursor>>, DataFusionError> {
                target_row,
    unsafe fn free_store_pointer(ptr: i64) {
            .block_on(store.put(&location, bytes.into()))
    /// Keyed on the Arrow type, which is the decode output: Parquet INT32 arrives as
use std::sync::Arc;
    #[test]
        None,
        assert_eq!(
        file.write_all(&super::tests::parquet_fixture_with_decimal_column(
        writer.write(&batch).unwrap();
            open_parquet_fixture(parquet_fixture_with_all_null_page(ROWS_PER_PAGE), 8);
    /// A decimal column: Parquet stores precision 18 as INT64, and Arrow decodes it back to
    /// `PrimitiveArray` is built from `ArrayData`, and `ArrayData::from` never writes the offset
            "all-null page must be skipped from OffsetIndex metadata"
    /// leaked into the test binary.
        let reserved = cursor.reservation.size();
/// none of which the inherent-method tests above touch.
        assert_eq!(
        let props = WriterProperties::builder()
            true,
    }
    }
        initial_batch_size,
        let data_type = leaf_schema.field(0).data_type();
    /// the four access shapes the adaptive planner distinguishes, and assert the decoded values
            "close is exercised with a batch still held"
        let mut cursor = runtime
    Err(DataFusionError::Configuration(
    row_count: i64,
        );
    fn for_arrow(data_type: &DataType) -> Option<Self> {
            )));
        } else {
            &location,
use parquet::arrow::{parquet_to_arrow_schema_by_columns, ProjectionMask};
    ///
                column.as_ptr(),
        );
            PartitionedFile::new(location.to_string(), file_size),
/// this. Mirrored by `ParquetSettings.DEFAULT_DOCVALUES_MAX_BATCH_SIZE` on the Java side.
        let metadata =
        let batch = next_batch(handle, 0);
                )));
    };
        assert_dictionary_jump_decodes::<arrow::datatypes::Float32Type>(DataType::Float32, |row| {
        // Fails here if the batch would push the node past its budget. Replaces the previous batch's
                .unwrap(),
        assert_eq!(cursor.next_batch(0).unwrap().num_rows(), 8);
//! Values are exported to Java zero-copy by borrowing the Arrow buffers.
/// Advance to `target_row`, skip intermediate pages through Arrow's retained
            "bounded synthetic batches must not revisit the skipped page"
                &mut values_addr,
    fn a_missing_column_is_reported_without_leaving_a_handle_behind() {
/// `index.parquet.docvalues.max_batch_size` can only lower a cursor's ceiling, never raise it past
/// `open` rejects an unsupported column, so `None` here means the column's Arrow type changed
        // beyond it halves the window rather than resetting, so mixed access does not re-ramp from
        let handle = open_fixture(&file);
                path.as_ptr(),
    cursor.reader = cursor.factory.open().map_err(|e| format!("{FN}: {e}"))?;
    ))?;
            Arc::new(GreedyMemoryPool::new(1));
//! process-wide registry, so an unknown or stale handle is reported as an error rather
        assert_eq!(
#[no_mangle]
        let (mut cursor, _runtime) =
            assert_eq!(column.value(row), value_at(target as usize + row));
                    ))
            "value",
        );
    use opensearch_tiered_storage::registry::traits::FileRegistry;
            .set_max_row_group_row_count(Some(rows_per_page * 8))
 */
    #[test]
    Ok(false)
    fn open_parquet_fixture(bytes: Bytes, batch_size: usize) -> (DocValuesCursor, Arc<Runtime>) {
            "value",
    /// Bytes per row. Mirrors `ParquetColumnReader.widthForKind`.
            .column(0)
    CURSORS.remove(&handle);
        let store_ptr = leak_store_pointer(store);
            cursor.next_batch(0).unwrap().num_rows(),
            .set_dictionary_enabled(false)
            .expect("cursor must still be registered")
    }
        .unwrap();
                expected,
        );
 * compatible open source license.
        }
            "a failed read must release the retained batch"
    #[test]
            0,
#[ffm_safe]
            assert_eq!(
        writer.write(&batch).unwrap();
                .into_string()
    .map_err(|e| e.to_string())
    }
    write_out(out_last_row, target_row + rows as i64 - 1); // inclusive last row of this batch
        // only a local-filesystem store can name a descriptor, and only it knows how an object path
    /// cell of the matrix, the v2 data-page format without a dictionary.
        assert_eq!(cursor.next_batch(0).unwrap().num_rows(), 8);
                64 * 1024 * 1024,
        let values = (0..row_count).map(|value| value as i64).collect::<Vec<_>>();
        assert_eq!(cursor.batch_size, configured_max);
                )))
    #[test]
/// been destroyed, which is what `ParquetDataFormatStoreHandler` hands out for the shard's lifetime.
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
    let (validity_addr, validity_bit_offset) = match data.nulls() {
                &mut value_kind,
    if !ptr.is_null() {
    /// to decode now, never past the end of `target_row`'s page.
                .build()
use tokio::runtime::Runtime;
            projection,
            (Arc::new(UInt32Array::from(vec![1])), BorrowKind::UintBits),
        let page_rows = self.reader.page_row_count(target_row)?;
        // TODO(perf): each open pays its own `File::open`; only footer and page index are cached.
        };
struct DocValuesCursor {
        // Closing twice is a no-op, so a Java close in a finally block is safe.
unsafe fn str_from_raw<'a>(ptr: *const u8, len: i64) -> Result<&'a str, DataFusionError> {
            .set_max_row_group_row_count(Some(rows_per_page * 8))
        *ptr = value;
                .next_batch((BATCH_SIZE_HARD_LIMIT / 2) as i64)
