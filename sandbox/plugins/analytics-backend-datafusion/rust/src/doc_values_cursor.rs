                    "column '{column}' is ambiguous in {filename}; it matches {paths}"
use tokio::runtime::Runtime;
    CURSORS.insert(handle, Arc::new(Mutex::new(cursor)));
        let _globals = crate::test_process_globals::lock();
            "all-null page must be skipped from OffsetIndex metadata"
    }
        let boxed: Box<Arc<dyn MetadataCachingStore>> =
    ///
        *ptr = value;
                (Arc::new(local), path)
            false,
#[cfg(test)]
            DataType::Int64 | DataType::UInt64 | DataType::Date64 | DataType::Timestamp(_, _) => {
    fn a_borrowed_window_exports_row_zero_and_its_first_validity_bit() {
    #[test]
        let handle = open_fixture(&file);
/// The shared IO runtime, used only to block on object-store fetches; decode is synchronous and runs
    }
        if BorrowKind::for_arrow(data_type).is_none() {
/// `ParquetColumnReader.LOCAL_STORE` on the Java side.
            "local page reads must use the retained synchronous file descriptor"
        let _globals = crate::test_process_globals::lock();
                path.as_ptr(),
/// would fail here and nowhere else; this turns that into a slow read rather than a shard failure.
        // Collect every candidate rather than taking the first: two leaves in different row groups
        .get(&handle)
        assert_eq!(cursor.next_batch(jump).unwrap().num_rows(), 8);
        assert_eq!(cursor.next_batch(24).unwrap().num_rows(), 32);
            .register(&env.memory_pool);
            .build();
    #[test]
                .unwrap()
    /// `PrimitiveArray` is built from `ArrayData`, and `ArrayData::from` never writes the offset
/*
    /// The two buffers reach that address differently. Arrow folds a primitive array's window into
        Bytes::from(writer.into_inner().unwrap().into_inner())
        let cases: Vec<(ArrayRef, BorrowKind)> = vec![
        let configured_max = 32;
        assert_eq!(next_batch(handle, 0).rc, RC_OK);
    static FN: &str = "parquet_df_reset_iter";
        // reader holds while decoding are not reserved against the pool.
            "close is exercised with a batch still held"
    /// Rejected rather than exported as raw bytes Java would silently misread.
    })
    ///
use object_store::{ObjectStore, ObjectStoreExt};
 * this file be licensed under the Apache-2.0 license or a
    }
        assert!(message.contains("out of range"), "{message}");
    }
            NEXT_HANDLE.fetch_add(1, Ordering::Relaxed)
        // A window with no nulls in it is dropped by `ArrayDataBuilder::build`, which would leave
    }
                .num_rows(),
            configured_max,
        let non_null = cursor.next_batch(ROWS_PER_PAGE as i64).unwrap();
    /// validity bitmap. Binary and variable-width columns come after that. `Float16`
                expected_kind.width(),
}
    crate::cache::global_runtime_env().ok_or_else(|| {
        kind: kind as i64,
        ));
    #[test]
    /// `parquet_fixture_with_page_rows` writes eight pages per row group.
        );
            3,
        let env = runtime_env()?;
    }
    Float = 9,    // f32 raw bits; Java re-encodes to a sign-extended sortable int
            "group",
                .add_buffer(values_buffer)
        assert_eq!(batch.value_kind, BorrowKind::Long as i64);
    /// `initial_batch_size` mid-cursor.
        while row < FIXTURE_ROWS {
        let schema = Arc::new(Schema::new(vec![Field::new(
        )]));
    }
        store_override: Option<Arc<dyn ObjectStore>>,
                .unwrap(),
    /// the four access shapes the adaptive planner distinguishes, and assert the decoded values
//! `parquet_df_open_iter` returns an opaque cursor handle, not a pointer: it keys a
        (row % 7) as i64 * 3
            .next_batch(0)
    fn every_entry_point_rejects_an_unknown_handle() {
            "no global DataFusion runtime environment; the analytics-backend-datafusion global \
        return Err(format!(
        let handle = open_fixture(&file);
        let (mut cursor, _runtime) = open_parquet_fixture(bytes, 8);
    fn dictionary_encoded_int32_decodes_after_cross_page_jump() {
    // leading slash away, so no separate location override is needed.
        unsafe {
        return Err(format!(
///
            DataType::UInt8 => Some(Self::Ubyte),
//! # Handles
    }
        assert_eq!(
        Some(nulls) => (nulls.buffer().as_ptr() as usize, nulls.offset()),
    /// Plain-encoded v1 is what every other test in this module writes; this covers the remaining
            );
    }
    target_row: i64,
        let _globals = crate::test_process_globals::lock();
    cursor.borrowed_batch = None;
    let runtime = io_runtime()?;
    /// `ptr` must come from [`leak_store_pointer`] and not have been freed.
        );
    out_last_row: *mut i64,
    fn open_fixture(row_groups: usize, batch_size: usize) -> (DocValuesCursor, Arc<Runtime>) {
            cursor.reservation.size(),
    // Written only once the export is known good, so a failed call leaves them untouched.
        for (array, expected_kind) in cases {
        let reservation = MemoryConsumer::new(format!("parquet-docvalues-cursor:{location}"))
        batch_size: usize,
    /// # Safety
const BATCH_SIZE_HARD_LIMIT: usize = 8_192;
    crate::test_process_globals::assert_held("the process-global runtime manager");
                "unsupported type {data_type} for column '{column}'"
            DataType::UInt32 => Some(Self::UintBits),
            // The fixture writes value == row index, so the buffer must read back as exactly the
    /// leaked into the test binary.
    validity_addr: usize,
        match self {
        );
        P::Native: PartialEq + std::fmt::Debug,
    }
        assert!(message.contains("not found"), "{message}");
    pub(super) fn register_test_runtime_manager() {
        let mut row = 0;
                path.len() as i64,
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
    /// also handed to the reader factory to attribute I/O.
        file.write_all(&parquet_fixture_with_page_rows(1, ROWS_PER_PAGE))
    Ok(RC_OK)
                .unwrap();
    /// Reads back through the exported addresses across a whole multi-page scan, which is the only
) -> i64 {
            .block_on(store.put(&location, bytes.into()))
        let rc = unsafe {
        runtime
            .ok_or_else(|| format!("{FN}: unsupported non-numeric array {}", array.data_type()))?
        let bytes = parquet_fixture_with_page_rows(1, ROWS_PER_PAGE);
    /// TODO: boolean needs a bit-packed values buffer with a value bit offset, mirroring the
///
                batch_size,
            UInt32Array, UInt64Array, UInt8Array,
                &mut values_addr,
            error_message(next_batch(unknown, 0).rc),
            );
             runtime must be created before Parquet doc-values reads"
        let values = (0..rows_per_page * 2)
            values_addr,
    }
        // `window` is the size to remember for next time; `rows` is what we
        let _globals = crate::test_process_globals::lock();
        runtime.block_on(DocValuesCursor::open(
        if target_row < 0 || target_row >= self.row_count {
        use arrow::array::{AsArray, PrimitiveArray};
    /// back), so `to_data().offset()` reads as 0 here and the `data.offset()` term in the export is
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
            "the bitmap is exported unshifted, because bit 3 is not at a byte boundary"
    max_batch_size: usize,
        assert_eq!(batch.first_row, 0);
        unsafe {
        runtime
                array.data_type()
        let err = cursor
            // rows the batch claims to cover.
            assert!(message.contains("unknown handle"), "{message}");
    let borrow = {
        assert_eq!(cursor.next_batch(0).unwrap().num_rows(), 8);
        let _globals = crate::test_process_globals::lock();
//! Forward-only Parquet doc-values cursor over DataFusion I/O and Arrow decoding.
    }
/// and page index, so the rewind costs no IO.
    #[test]
        );
    fn closing_while_holding_a_borrow_drops_the_cursor() {
        let message = error_message(open_iter(file.path().to_str().unwrap(), 8));
        validity_addr: i64,
            unsafe { exported_i64s(later.values_addr, 1) },
use std::path::PathBuf;
    // plain addresses.
    }
                .build()
        assert_eq!(
    fn all_null_page_is_skipped_without_fetch_or_decode() {
        assert_eq!(cursor.max_batch_size, configured_max);
fn runtime_env() -> Result<Arc<RuntimeEnv>, DataFusionError> {
        assert_eq!(batch.last_row, 7, "the initial window is eight rows");
    /// the v1 type scope (INT32/FLOAT/DOUBLE), which no other test writes dictionary-encoded.
        let _globals = crate::test_process_globals::lock();
    /// Ceiling the window grows to, captured at open from
                .unwrap_or_else(|| panic!("{} must be borrowable", array.data_type()));
        // TODO(perf): each open pays its own `File::open`; only footer and page index are cached.
            .unwrap()
                    .with_cache_manager(cache_manager)
        ];
        let props = WriterProperties::builder()
            Some(store),
    }
            (Arc::new(Float64Array::from(vec![1.0])), BorrowKind::Double),
/// configured budget.
        let (store, local_path): (Arc<dyn ObjectStore>, Option<PathBuf>) = match store_override {
    /// A warm shard's Parquet files are not on local disk, so the cursor must read every byte - footer,
            "close must drop the cursor, releasing the retained Arrow buffers"
            .set_writer_version(version)
        let jump = (ROWS_PER_PAGE * 9 + 1) as i64;
    /// is refused before a cursor exists rather than on the first read.
static CURSORS: Lazy<DashMap<i64, Arc<Mutex<DocValuesCursor>>>> = Lazy::new(DashMap::new);
            int64_values(&batch),
        let booleans = arrow::array::BooleanArray::from(vec![true, false]);
        let jump = (ROWS_PER_PAGE * 3 + 5) as i64;
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
use datafusion_datasource::PartitionedFile;
            DataType::Decimal128(18, 2),
        assert!(
            .borrowed_batch
        assert_eq!(next_batch(handle, 40).rc, RC_OK);
        // Flat schemas cannot produce an ambiguity, so this only applies to files written with a
        column,
            .set_dictionary_enabled(true)
    /// to decode now, never past the end of `target_row`'s page.
        let _globals = crate::test_process_globals::lock();
    use arrow::datatypes::{DataType, Field, Schema};
    /// Accounts the resident batch against the node's shared `MemoryPool`, so an over-budget read
    #[test]
    pub(super) fn register_test_metadata_cache() {
            .build();
    values_addr: usize,
        // decimal is a valid physical type but decodes to `Decimal128`, which cannot be borrowed.
        let _globals = crate::test_process_globals::lock();
            row = batch.last_row + 1;
    #[test]
            "the following non-null page should be fetched"
                super::tests::TEST_MAX_BATCH_SIZE as i64,
/// on the calling thread. Required rather than defaulted: `RuntimeManager` sizes this pool from the
                64 * 1024 * 1024,
/// reader pays O(rows accessed) rather than O(rows served) and avoids a per-batch copy.
        assert!(
        let _globals = crate::test_process_globals::lock();
                .await
            parquet_df_open_iter(
    let width = kind.width();
struct BorrowedBuffers {
        }
    std::str::from_utf8(std::slice::from_raw_parts(ptr, len as usize))
        cursor.reservation = MemoryConsumer::new("tiny-budget").register(&tiny_pool);
            cursor.max_batch_size
    }
            borrow.validity_bit_offset, 3,
        assert_eq!(cursor.next_batch(27).unwrap().num_rows(), 32);
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        let second_rg = (ROWS_PER_PAGE * 8) as i64;
        assert!(
    use parquet::arrow::ArrowWriter;
        open_parquet_fixture(
            (0..8i64).collect::<Vec<_>>(),
    fn open_iter_with_max(path: &str, initial: i64, max: i64) -> i64 {
        let values_buffer = Buffer::from_slice_ref((0..8_i64).collect::<Vec<_>>());
                })?; // OffsetIndex + ColumnIndex scoped to just this column
    fn large_jump_halves_the_window_instead_of_resetting() {
        let array = make_array(
        let validity_base = validity_buffer.as_ptr() as usize;
        };
        let data_type = leaf_schema.field(0).data_type();
        let reserved = cursor.reservation.size();
            int64_values(&cursor.next_batch(target).unwrap()),
    }
#[cfg(test)]
    }
        let (mut cursor, _runtime) = open_fixture(2, 8);
        let _globals = crate::test_process_globals::lock();
        assert!(!holds_borrow(handle));
    let rows = batch.num_rows();
/// that only exercise pure decode logic: "every test in this module holds it" is a rule that
unsafe fn store_from_ptr(store_ptr: i64) -> Option<Arc<dyn ObjectStore>> {
            reader,
        assert!(rc < 0, "expected an error pointer, got {rc}");
    /// `MemorySegment.ofAddress(addr).reinterpret(len)`: an unchecked view over memory Rust owns.
    open_and_register(
    write_out(out_values_addr, borrow.values_addr as i64);
    #[test]
    cursor: &DocValuesCursor,
            cursor.next_batch(0).unwrap().num_rows(),
        let _globals = crate::test_process_globals::lock();
            assert!(holds_borrow(handle));
    }
    }
    };
        assert!(handle >= 0, "{}", error_message(handle));
        // the same column, and cache the descriptor per file if it shows.
    async fn open(
impl BorrowKind {
    fn a_closed_handle_is_no_longer_usable() {
        );
}
        batch
        let handle = open_fixture(&file);
    write_out(out_last_row, target_row + rows as i64 - 1); // inclusive last row of this batch
        );
                    .with_memory_pool(Arc::new(GreedyMemoryPool::new(64 * 1024 * 1024)))
    Ushort = 5,   // u16, zero-extended
}
    use tokio::runtime::Builder;
    #[test]
    }
                Arc::clone(&runtime),
                initial,
        let (mut cursor, _runtime) = open_fixture(1, 8);
        let mut writer =
                    DataFusionError::Execution(format!(
    fn reaching_end_of_column_releases_the_borrow() {
    ) -> Result<Self, DataFusionError> {
        let location = ObjectPath::from(format!(
    /// sign-extension rule from it alone, so a wrong mapping here reads the right bytes as the
        let handle = open_fixture(&file);
    }
        // beyond it halves the window rather than resetting, so mixed access does not re-ramp from
            .set_write_batch_size(rows_per_page)
        open_iter_with_max(path, initial, super::tests::TEST_MAX_BATCH_SIZE as i64)
        assert_eq!(
    }
        assert_eq!(
            }
            borrowed_batch: None,
///
pub unsafe extern "C" fn parquet_df_next_batch(
        let file = fixture_file();
    fn assert_dictionary_jump_decodes<P>(data_type: DataType, value_at: fn(usize) -> P::Native)
    out_validity_bit_offset: *mut i64,
    use super::tests::{
        register_test_metadata_cache();
            (Arc::new(Int32Array::from(vec![1])), BorrowKind::Int),
                store_ptr,
        DataFusionError::Configuration(
                        .first()
                8,
        open_parquet_fixture_with_max(bytes, batch_size, TEST_MAX_BATCH_SIZE)
}
        // No handle is returned, and `open_and_register` only inserts after a successful open, so
        filename,
            WriterVersion::PARQUET_2_0,
    }
    /// The batch Java last borrowed from, held so the exported pointers stay valid. Released on the
    /// formats (v1 `DataPage` vs v2 `DataPageV2`). Values repeat (`row % 7`) so the writer
            "{error}"
        for expected in [8, 16, 32, 64, 64, 64] {
    use opensearch_tiered_storage::tiered_object_store::TieredObjectStore;
        let batch = cursor.next_batch(boundary).unwrap();
    if max_batch_size <= 0 || max_batch_size > BATCH_SIZE_HARD_LIMIT as i64 {
            row = batch.last_row + 1;
                column.len() as i64,
        let batch = cursor.next_batch(within).unwrap();
        let leaf_schema = parquet_to_arrow_schema_by_columns(
            cursor.stats.count.load(Ordering::Relaxed) > reads_before,
    out_first_row: *mut i64,
            .lock()
        // it concurrently, so its length is not a signal this test can assert on.
        );
//! Values are exported to Java zero-copy by borrowing the Arrow buffers.
    }
        let window = if dense {
        assert_eq!(cursor.next_batch(8).unwrap().num_rows(), 16);
            TieredFileEntry::with_size(FileLocation::Local, None, size),
/// # Safety
        let _globals = crate::test_process_globals::lock();
        open_fixture_with_page_rows(row_groups, ROWS_PER_PAGE, batch_size)
            0,
            .build();
    cursor.reservation.resize(0);
            metadata,
            let cache = Arc::new(MutexFileMetadataCache::new(DefaultFilesMetadataCache::new(
        (target..target + len).map(encoded_fixture_value).collect()
        assert_eq!(cursor.next_batch(jump).unwrap().num_rows(), 16);
        });
        max_batch_size: usize,
        cursor.next_batch(8).expect("the batch must fit the budget");
        let message = error_message(next_batch(handle, 0).rc);
                borrow.kind,
            Arc::clone(&runtime),
                .unwrap();
    /// actually emits a dictionary page instead of falling back to plain encoding.
use std::sync::atomic::{AtomicI64, Ordering};
        let _globals = crate::test_process_globals::lock();
    fn dictionary_encoded_pages_decode_across_all_skip_shapes_with_writer_v1() {
        assert!(
    }
    fn a_starting_window_above_the_maximum_is_lowered_to_it() {
                    .join(", ");
    let mut cursor = cursor.lock();
enum BorrowKind {
            .get(&handle)
    struct Batch {
        let runtime = Arc::new(Builder::new_current_thread().enable_all().build().unwrap());
                .to_string(),
        validity_bit_offset, // bit index of row 0 within that bitmap (bitmaps are bit-addressable)
        // Each call releases the previous batch before decoding, so retention never accumulates.
        // dictionary-encoded chunk the dictionary must still resolve on the landing page.
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        let column = "value";
                    .expect("test runtime environment must build"),
        assert!(borrowable_buffers(&decimal).is_none(), "Decimal128");
    /// Retained so a reset can rebuild the reader without re-resolving metadata or the page index.
    #[test]
            footer.file_metadata().key_value_metadata(),
    /// Only valid while the cursor still holds the batch these addresses were borrowed from, so
            WriterVersion::PARQUET_2_0,
            stats.count.load(Ordering::Relaxed),
        assert_eq!(
        rows_per_page: usize,
        // ceiling, against representative query shapes.
            .set_max_row_group_row_count(Some(rows_per_page * 8))
        max_batch_size as usize,
        return Ok(true);
        assert!(
        // Small forward skip inside page 0: the planner treats this as dense access.
            .is_some()
        // Local files read through a synchronous `ChunkReader`; anything else goes via the store.
            8,
            )));
//! `parquet_df_close_iter` exactly once.
                .ok_or_else(|| {
    fn next_batch(&mut self, target_row: i64) -> Result<RecordBatch, DataFusionError> {
    out_validity_addr: *mut i64,
        for row in 0..batch.num_rows() {
            parquet_df_open_iter(
/// uses. Required rather than defaulted: a cache or pool created here would sit outside the node's
fn at_eof(
            .unwrap();
        );
            .set_dictionary_enabled(false)
        let (mut cursor, _runtime) =
    }
        let batch = cursor.next_batch(second_rg + 11).unwrap();
        let mut row = 0;
                max,
    /// call this before the next entry-point call on the same handle.
    /// just as well and still serves wrong doc values.
    let mut cursor = cursor.lock();
            ))
    #[test]
            "doc-values-cursor-{}.parquet",
    Ok(RC_OK)
                column.as_ptr(),
    #[test]
        // Reject on the Arrow type the reader will produce, not the Parquet physical type: an INT64
    use crate::cache::metadata_cache::MutexFileMetadataCache;
            stats,
    write_out(out_value_kind, borrow.kind);
                "kind for {}",
        initial_batch_size as usize,
///
            "doc-values-cursor-{}.parquet",
            BATCH_SIZE_HARD_LIMIT
        )
    #[test]
    let cursor = cursor_for(handle, FN).map_err(|e| e.to_string())?;
            assert_eq!(batch.rc, RC_OK, "row {row}: {}", batch.last_row);
        assert!(holds_borrow(handle), "the served batch must be retained");
    initial_batch_size: usize,
            4096,
    debug_assert_eq!(array.data_type().primitive_width(), Some(width));
    Some(BorrowedBuffers {
    }
/// [`BorrowKind::width`], and a matching constant on the Java side.
//! construction. This module selects the byte source and exposes the FFM lifecycle.
    }
const LOCAL_STORE: i64 = 0;
        let row_count = row_groups * rows_per_page * 8;
            parquet_df_open_iter(
        let row_count = reader.row_count() as i64;
        assert_eq!(next_batch(handle, 0).rc, RC_OK);
        let _globals = crate::test_process_globals::lock();
            (row % 7) as f64 * 0.5
            "a failed read must release the retained batch"
//!
    /// Reads values back out of an exported buffer the way Java does, via
    }
    }
        ));
            ROWS_PER_PAGE,
    }
            free_store_pointer(store_ptr);
        );
/// Adding a type means adding a variant here plus arms in [`BorrowKind::for_arrow`] and
        let (mut cursor, _runtime) =
        let schema = Arc::new(Schema::new(vec![Field::new(
            .set_dictionary_enabled(false)
        let file = fixture_file();
            unsafe { *(borrow.values_addr as *const i64) },
            .block_on(store.put(&location, bytes.into()))
            "negative string length: {len}"
                path.len() as i64,
            .unwrap();
            column,
                column.as_ptr(),
        let _globals = crate::test_process_globals::lock();
            holds_borrow(handle),
        assert_eq!(cursor.initial_batch_size, configured_max);
        let mut file = NamedTempFile::new().unwrap();
                let local = LocalFileSystem::new();
                    .iter()
    unsafe fn free_store_pointer(ptr: i64) {
        };
        cursor.next_batch(0).expect("the batch must fit the budget");
    /// Bytes per row. Mirrors `ParquetColumnReader.widthForKind`.
        ));
        assert_eq!(
/// pointer is a warm shard's `TieredObjectStore`, whose files live in the remote object store; the
        // Named per file so `TrackConsumersPool` can attribute usage.
        }
    /// The starting window is clamped to the ceiling, so the decay floor can never sit above the
        );
        ))
        // Closing twice is a no-op, so a Java close in a finally block is safe.
    }
            "bounded synthetic batches must not revisit the skipped page"
            .set_write_batch_size(rows_per_page)
        handle
            ROWS_PER_PAGE,
        let second = cursor.next_batch(25).unwrap();
    let data = array.to_data();
    CURSORS.remove(&handle);
        drop(Box::from_raw(ptr as *mut Arc<dyn MetadataCachingStore>));
#[ffm_safe]
        drop(cursor);
                location.as_ref(),
    }
        Bytes::from(writer.into_inner().unwrap().into_inner())
            .collect::<Vec<_>>();
        let size = bytes.len() as u64;
        let rewound = next_batch(handle, 0);
            !holds_borrow(handle),
    let buffer = data.buffers().first()?; // buffer 0 holds the values for a primitive array
        )));
    fn adaptive_window_is_capped_at_max_batch_size() {
    fn dictionary_encoded_float64_decodes_after_cross_page_jump() {
        .with_local_file(local_path);
    }
    fn only_one_batch_is_retained_across_a_long_scan() {
            "value",
            "reading through the exported pointer must yield the window's first value"
        assert_eq!(batch.last_row, 7);
    }
            .build();
    use opensearch_tiered_storage::registry::traits::FileRegistry;
        let factory = ParquetForwardBatchReaderFactory::new(
        let message = error_message(rc);
                .unwrap();
        // Out of range: fails after the release, so nothing stays held.
                array.data_type()
        let target_row = target_row as usize;
    /// Default ceiling, as a cursor opened through the FFM boundary would receive it. Tests that care
        assert_eq!(next_batch(handle, FIXTURE_ROWS).rc, RC_EOF);
        // Absolute, like the path the engine stamps and the shard's registry is keyed by.
    }
        Ok(batch)
        let path = format!(
            BATCH_SIZE_HARD_LIMIT,
        None,
 * The OpenSearch Contributors require contributions made to
                None,
#[ffm_safe]
        crate::test_process_globals::install_runtime_manager();
    static FN: &str = "parquet_df_open_iter";
            None => {
        let batch = cursor.next_batch(across).unwrap();
}
    fn open_parquet_fixture_with_max(
            Self::Byte | Self::Ubyte => 1,
    store_ptr: i64,
        assert!(handle >= 0, "{}", error_message(handle));
        };
            object_meta,
    #[test]
    fn dense_access_retains_the_grown_window_across_pages() {
        filename,
         tests call register_test_runtime_manager()"
    Int = 2,      // i32 / date32, sign-extended
//! than dereferenced. `0` is never a live handle. Java owns the lifecycle and calls
    /// Wraps `store` the way `ts_get_object_store_box_ptr` does, so the pointer handed to
        assert_eq!(
            ROWS_PER_PAGE,
        let column = "absent";
        return Err(DataFusionError::Internal(format!(
            .collect::<Vec<_>>();
                .unwrap();
    }
    /// Read at 0, skip within a page, jump across pages, then land on an exact page boundary,
        );
        "no runtime manager registered; DataFusionService.doStart registers it in production, \
        return Ok(RC_EOF); // target is past the last row (e.g. a scan running off the end)
/// Exposes an Arrow primitive array's buffers for zero-copy reads from Java.
    }
            [] => {
        };
        let _globals = crate::test_process_globals::lock();
    #[test]
        assert_eq!(first.num_rows(), 8);
    /// replaced — see `crate::test_process_globals::install_runtime_manager`.
            schema,
    Double = 8,   // f64 raw bits; Java re-encodes to a Lucene sortable long
        runtime
        let mut cursor = runtime
        let reader_factory: Arc<dyn ParquetFileReaderFactory> = Arc::new(
            (Arc::new(UInt32Array::from(vec![1])), BorrowKind::UintBits),
        values_addr,
            true,
    /// Releases a pointer from [`leak_store_pointer`], mirroring `ts_destroy_object_store_box_ptr`.
        assert_eq!(cursor.next_batch(0).unwrap().num_rows(), 8);
            )
        // Jump past several pages: whole pages are skipped without decoding, and for a
    }
/// reader, and hand Java the decoded Arrow batch's buffers zero-copy.
        }
/// Only reached when a request lands below the resident batch, which a caller honouring Lucene's
            BATCH_SIZE_HARD_LIMIT / 2,
    /// `parquet_df_open_iter` has exactly the shape a warm shard's store handle carries.
        let _globals = crate::test_process_globals::lock();
        assert_eq!(next_batch(handle, 0).rc, RC_OK);
            "a boundary-clamped read must not reset dense-scan growth"
    use super::*;
        assert_eq!(cursor.next_batch(jump).unwrap().num_rows(), 8);
pub unsafe extern "C" fn parquet_df_close_iter(handle: i64) -> i64 {
        let batch = RecordBatch::try_new(schema, vec![Arc::new(array) as ArrayRef]).unwrap();
    Short = 4,    // i16, sign-extended
                .expect("error message must be valid UTF-8")
            .to_vec()
    if store_ptr <= LOCAL_STORE {
    use super::*;
        column,
                Some(Self::Long)
        }
    let batch = cursor.next_batch(target_row).map_err(|e| e.to_string())?;
    use arrow::array::{ArrayRef, Int64Array};
    // the same absolute path this cursor is opened with (`StoreStrategyRegistry` seeds it from
            "a batch must not decode across a data-page boundary"
#[no_mangle]
}
    row_count: i64,
            .expect("cursor must still be registered")
        let (mut cursor, _runtime) = open_fixture(2, 8);
/// type is defined. Discriminants are the wire values; mirrors `DecodedBatch.KIND_*`.
            cursor.next_batch(64).unwrap().num_rows(),
            "end of column must release the retained batch"
        let matches = (0..schema.num_columns())
    pub(super) fn parquet_fixture_with_decimal_column(rows_per_page: usize) -> Bytes {
            configured_max < BATCH_SIZE_HARD_LIMIT,
        }
        let _globals = crate::test_process_globals::lock();
                array.data_type().primitive_width().unwrap(),
    }
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        let mut file = NamedTempFile::new().unwrap();
    ) -> (DocValuesCursor, Arc<Runtime>) {
        // actually decode now.
    }
use arrow::datatypes::DataType;
        );
            reads_before,
/// # Safety
/// `0` means the shard's Parquet files are on local disk, which is every hot shard: the cursor
    write_out(out_validity_bit_offset, borrow.validity_bit_offset as i64);
                "value",
        let group = arrow::array::StructArray::new(children.into(), vec![left, right], None);
            vec![ROWS_PER_PAGE as i64 + 3],
    fn next_batch(handle: i64, target_row: i64) -> Batch {
    use datafusion::execution::runtime_env::RuntimeEnvBuilder;
                    .collect::<Vec<_>>()
use arrow::array::Array;
        let runtime = Arc::new(Builder::new_current_thread().enable_all().build().unwrap());
    use tempfile::NamedTempFile;
            assert_eq!(rows, expected, "window at row {row}");
/// The node's shared `RuntimeEnv`, which owns the file-metadata cache and the memory pool a cursor
    }
mod ffm_tests {
            Self::Short | Self::Ushort => 2,
        let filename = file.path().to_str().unwrap();
    };
        assert_skip_shapes_decode(parquet_fixture_encoded(
        let (mut cursor, _runtime) = open_fixture(1, 8);
        let column = "value";
#[repr(i64)]
        assert_dictionary_jump_decodes::<arrow::datatypes::Float32Type>(DataType::Float32, |row| {
    /// The kind is the whole of the Rust-to-Java type contract: Java picks a byte width and a
        let location = location_override.unwrap_or_else(|| ObjectPath::from(filename));
    /// each time. Shared by the dictionary/writer-version matrix below.
                        .path()
    fn leak_store_pointer(store: Arc<TieredObjectStore>) -> i64 {
    /// Writes a dictionary-encoded v2 file of the given primitive type, jumps across pages, and
        );
const RC_EOF: i64 = 2;
            && target_row >= position
        );
    Byte = 6,     // i8, sign-extended
        // TODO(memory): this bounds only the decoded batch; the page and dictionary the Arrow
//! Local shard files use Arrow's synchronous `ChunkReader` directly. Arrow owns
            ROWS_PER_PAGE,
    /// at the configured value rather than the compile-time limit.
/// Opens a cursor and registers it, returning the handle Java holds.
        assert!(message.contains("unsupported type Decimal128"), "{message}");
    #[test]
        for initial in [0, -1, BATCH_SIZE_HARD_LIMIT as i64 + 1] {
            .set_statistics_enabled(EnabledStatistics::Page)
    fn open_iter(path: &str, initial: i64) -> i64 {
            assert_eq!(
    fn error_message(rc: i64) -> String {
}
        );
        assert!(message.contains("backward seek"), "{message}");
    column: &str,
            })
            0,
    pub(super) fn parquet_fixture_with_page_rows(row_groups: usize, rows_per_page: usize) -> Bytes {
        let _globals = crate::test_process_globals::lock();
            Arc::clone(&store),
    use datafusion::execution::cache::cache_manager::CacheManagerConfig;
        let schema = Arc::new(Schema::new(vec![Field::new(
            cursor.stats.count.load(Ordering::Relaxed),
        self.has_decoded_batch = true;
        );
    let cursor = runtime.block_on(DocValuesCursor::open(
        let across = (ROWS_PER_PAGE * 5 + 7) as i64;
        let error = cursor.next_batch(second_rg - 1).unwrap_err().to_string();
        let target = (ROWS_PER_PAGE * 5 + 7) as i64;
    /// check on what Java actually sees. The tests around this one assert the *lifetime* of the
    /// The file here is put into an in-memory store behind a `TieredObjectStore`, so the stamped path
    /// exists in no filesystem at all: anything that fell back to a local read would fail outright
            false,
            "an over-budget read must fail on the memory budget, not some other way: {err}"
/// holds `crate::test_process_globals::lock` for its whole body. Uniformly, including the few tests
        let reader = factory.open()?;
            "reset must release the retained batch"
            int64_values(&batch),
#[no_mangle]
        let handle = open_fixture(&file);
/// registration — and inserts into the process-global scoped page-index caches, so every test here
            (Arc::new(UInt64Array::from(vec![1])), BorrowKind::Long),
        let props = WriterProperties::builder()
            Arc::new(GreedyMemoryPool::new(1));
            int64_values(&jumped),
        let (cursor, _runtime) = open_parquet_fixture_with_max(
    cursor.reader = cursor.factory.open().map_err(|e| format!("{FN}: {e}"))?;
            std::path::Path::new(&path).exists() == false,
        Bytes::from(writer.into_inner().unwrap().into_inner())
        filename: &str,
        );
    #[test]
        return Err(DataFusionError::Internal(format!(
        CURSORS
            .build();
        ));
}
        // maps onto one. A caller-supplied store reads through its own IO.
}
    if ptr.is_null() {
    // clears its resident batch before calling. The reservation follows the batch.
            Box::new(store as Arc<dyn MetadataCachingStore>);
    fn an_ambiguous_column_name_is_rejected_rather_than_guessed() {
            .collect::<Vec<_>>();
                    ))
    Ok(false)
    fn a_missing_column_is_reported_without_leaving_a_handle_behind() {
            let borrow = borrowable_buffers(array.as_ref())
            DataType::Int64,
                    "column '{column}' not found in {filename}"
    /// the entry points without that startup path, so any read that needs the IO runtime must
fn borrowable_buffers(array: &dyn Array) -> Option<BorrowedBuffers> {
    #[test]
        assert_skip_shapes_decode(parquet_fixture_encoded(
                handle,
    use std::io::{Cursor, Write};
    use datafusion::execution::cache::DefaultFilesMetadataCache;
            "{FN}: Arrow returned {rows} rows, expected 1..={}",
            (row % 7) as f32 * 0.5
                "initial {initial} produced {message}"
        let schema = Arc::new(Schema::new(vec![Field::new(
                        .parts()
            "the test is only meaningful below the hard limit"
        assert_eq!(
    #[test]
        )]));
                .unwrap();
        column: &str,
    #[test]
    /// static because the registry keeps only a `Weak`.
            );
    write_out(out_first_row, target_row);
    let cursor = cursor_for(handle, FN).map_err(|e| e.to_string())?;
 *
 * SPDX-License-Identifier: Apache-2.0
            .as_any()
            assert_eq!(column.value(row), value_at(target as usize + row));
        std::slice::from_raw_parts(addr as *const i64, rows).to_vec()
        let bytes = parquet_fixture_with_two_leaves_under_one_group();
        assert_eq!(
        // bytes rather than adding to them, since a cursor holds at most one batch.
            RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values)) as ArrayRef])
    )
            assert_eq!(batch.value_kind, BorrowKind::Long as i64);
        );
        .await
    }
    /// Retained so tests can assert on the number of object-store range reads;
    if target_row < 0 || target_row > cursor.row_count {
            "value",
        let _globals = crate::test_process_globals::lock();
        )));
use crate::cache::page_index::load_scoped_page_index_cols;
                "the fixture column is required, so no bitmap should be exported"
        let reads_before = cursor.stats.count.load(Ordering::Relaxed);
            "values decoded from the store must match what was written"
    use tokio::runtime::Builder;
        assert_eq!(
        let schema = Arc::new(Schema::new(vec![Field::new("value", data_type, false)]));
            .filter(|&idx| {
    let caching: Arc<dyn MetadataCachingStore> = Arc::clone(boxed);
    /// `index.parquet.docvalues.max_batch_size` lowers the ceiling per cursor, so growth has to stop
    /// # Safety
                &mut first_row,
    }
            "so Java is handed the bit offset to apply itself"
    target_row: i64,
    fn open_parquet_fixture(bytes: Bytes, batch_size: usize) -> (DocValuesCursor, Arc<Runtime>) {
            (Arc::new(Int64Array::from(vec![1])), BorrowKind::Long),
        );
        })
            cursor.row_count
            "{fn_name}: row {target_row} out of range (0..={})",
        Box::into_raw(boxed) as i64
    }
use arrow::record_batch::RecordBatch;
            assert_eq!(
                batch.last_row
#[allow(clippy::too_many_arguments)]
    fn planned_batch(&self, target_row: i64) -> Result<(usize, usize), DataFusionError> {
        .ok_or_else(|| DataFusionError::Internal(format!("{fn_name}: unknown handle {handle}")))
                column.as_ptr(),
            .set_write_batch_size(ROWS_PER_PAGE)
            max_batch_size,
        let (mut cursor, _runtime) = open_fixture(1, 8);
            .expect("an ambiguous column must not open")
            matches!(err, DataFusionError::ResourcesExhausted(_)),
 */
            .values()
            parquet_fixture_with_page_rows(1, 1024),
                let path = local.path_to_filesystem(&location).ok();
            .downcast_ref::<Int64Array>()
        assert_eq!(second.num_rows(), 16);
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        batch_size: usize,
    #[test]
                .len(5)
                .num_rows(),
            "the exported pointer must address the window's first row, not the buffer start"
            )));
                .unwrap()
        let _globals = crate::test_process_globals::lock();
            encoded_expected(across as usize, batch.num_rows())
        let _globals = crate::test_process_globals::lock();
            !holds_borrow(handle),
    /// engages; position-derived, so a read after a skip proves it landed where it aimed.
            .map(|value| value as i128)
        let values = (0..rows_per_page * 8)
        assert_eq!(
                path.len() as i64,
        P: arrow::datatypes::ArrowPrimitiveType,
    }
            last_row,
        let window = window.min(page_rows);
        assert_eq!(
            DataType::Int32 | DataType::Date32 | DataType::Time32(_) => Some(Self::Int),
        let mut file = NamedTempFile::new().unwrap();
        let first = cursor.next_batch(17).unwrap();
            DataType::Int64,
//! v1 scope: numeric fixed-width leaf columns only (INT32/INT64/FLOAT/DOUBLE).
            .set_max_row_group_row_count(Some(ROWS_PER_PAGE * 8))
        );
            assert_eq!(
    has_decoded_batch: bool,
    unsafe fn exported_i64s(addr: i64, rows: usize) -> Vec<i64> {
        );
        let runtime = Arc::new(Builder::new_current_thread().enable_all().build().unwrap());
            .column(0)
            .set_dictionary_enabled(false)
        assert_eq!(int64_values(&first), (0..8).collect::<Vec<_>>());
    /// instead of quietly reading the wrong bytes.
        static ENV: Lazy<Arc<RuntimeEnv>> = Lazy::new(|| {
        file
    /// next batch call, on reset, or when close drops the cursor.
        initial_batch_size,
    fn_name: &str,
            .build();
            false,
    use object_store::memory::InMemory;
                8,
    /// Stands in for the runtime manager production registers from `DataFusionService`. Tests reach
            cursor.next_batch(56).unwrap().num_rows(),
            (Arc::new(Int16Array::from(vec![1])), BorrowKind::Short),
        register_test_metadata_cache();
/// See [`store_from_ptr`] for the contract `store_ptr` must satisfy.
) -> i64 {
            return Err(DataFusionError::NotImplemented(format!(
            .unwrap();
                    || descriptor
    Long = 1,     // i64 / u64 raw bits
    use bytes::Bytes;
            cursor.stats.count.load(Ordering::Relaxed),
        );
    fn width(self) -> usize {
        );
    }
        let left = Arc::new(Int64Array::from((0..8_i64).collect::<Vec<_>>())) as ArrayRef;
        assert_eq!(cursor.next_batch(8).unwrap().num_rows(), 16);
    cursor.batch_size = cursor.initial_batch_size;
        // A read never crosses a page boundary, so a window larger than one page cannot be
        assert!(holds_borrow(handle));
    }
            validity_addr,
            cursor.reservation.size() > 0,
                &mut last_row,
        assert!(
    }
        });
        assert!(
    /// Reads the message an error return points at, taking ownership so it is freed rather than
        // An unambiguous leaf resolves to a single column, but a nested leaf projects as a struct
        // Skips no larger than the current window are page-scale dense access
use object_store::local::LocalFileSystem;
            .unwrap();
            assert_eq!(
        Bytes::from(writer.into_inner().unwrap().into_inner())
        first_row: i64,
        )]));
        // Decay is multiplicative (32 -> 16), not a reset to the initial window.
            batch_size,
        let target = (ROWS_PER_PAGE * 5 + 7) as i64;
        assert_eq!(
    #[test]
    /// The values [`parquet_fixture_encoded`] holds at `target..target + len`.
        let position = self.reader.position();
        // A cursor holds one batch at a time, so the next read replaces the accounting.
        .map_err(DataFusionError::Execution)?;
/// survives the next test being added, and the affected tests run in 0.03s serially.
        let _globals = crate::test_process_globals::lock();
            RecordBatch::try_new(Arc::clone(&schema), vec![Arc::new(array) as ArrayRef]).unwrap();
        let batch =
        register_test_runtime_manager();
    /// `window` is the adaptive size to remember for next time, `rows` is how much
            int64_values(&batch),
        assert_eq!(
                .unwrap();
}
pub unsafe extern "C" fn parquet_df_open_iter(
        // no bitmap to assert on.
            .value()
    }
    use object_store::ObjectStoreExt;
//! page traversal, skipping, decompression, definition-level expansion, and batch
        let dense = self.has_decoded_batch
            DataType::Struct(children.clone().into()),
            "the replacement batch must still be accounted"
        assert!(
        let first = cursor.next_batch(0).unwrap();
    use std::ffi::{c_char, CString};
            .block_on(DocValuesCursor::open(
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
    #[test]
        );
        let array = batch.column(0); // single projected column
        let batch = cursor.next_batch(target).unwrap();
        )]));
            values_base + 3 * std::mem::size_of::<i64>(),
/// non-decreasing `advanceExact` contract never does. Kept because Lucene's own dense numeric
        // No handle is returned, and `open_and_register` only inserts after a successful open, so
        assert_eq!(stats.count.load(Ordering::Relaxed), 1);
        register_test_metadata_cache();
            "/var/data/nodes/0/indices/idx/0/parquet/_generation_{}.parquet",
    /// page index and pages - through the store pointer Java supplies rather than through its own
        let later = next_batch(handle, ROWS_PER_PAGE as i64 + 3);
        );
}
                                          // window Arrow folds into the buffer pointer, but not for `BooleanArray`.
    reader: ParquetForwardBatchReader,
        assert_skip_shapes_decode(parquet_fixture_encoded(
        let stats = Arc::clone(&cursor.stats);
            (Arc::new(Int8Array::from(vec![1])), BorrowKind::Byte),
                expected_kind as i64,
}
        let stats = Arc::new(ReadIoStats::default());
        Arc::clone(&runtime),
    Ok(RC_OK)
            )
            )
        // cannot disagree.
        let values_base = values_buffer.as_ptr() as usize;
        let mut row = 0i64;
fn io_runtime() -> Result<Arc<Runtime>, DataFusionError> {
    handle: i64,
                )));
        }
        );
/// Validates `target_row`, returning `true` when the cursor is exactly at end-of-column.
            Arc::new(
    factory: ParquetForwardBatchReaderFactory,
    let kind = BorrowKind::for_arrow(array.data_type())?;
        assert!(
    fn adaptive_batches_grow_and_stop_at_page_boundaries() {
    fn assert_skip_shapes_decode(bytes: Bytes) {
    const ROWS_PER_PAGE: usize = 64;
                descriptor.name() == column
        let file = fixture_file();
            borrow.values_addr,
    fn int64_values(batch: &RecordBatch) -> Vec<i64> {
    cursor.reservation.resize(0);
    const ROWS_PER_PAGE: usize = 64;
        // Ask the store where the object lives rather than probing the filesystem for `filename`:
    }
    max_batch_size: i64,
        version: WriterVersion,
            int64_values(&cursor.next_batch(0).unwrap()),
                let descriptor = schema.column(idx);
        assert_eq!(batch.first_row, 0);
    #[test]
            NEXT_HANDLE.fetch_add(1, Ordering::Relaxed)
            .expect("a nested leaf is not a supported column type")
struct DocValuesCursor {
    /// The other fixtures disable dictionary encoding deliberately to control page layouts; this
unsafe fn str_from_raw<'a>(ptr: *const u8, len: i64) -> Result<&'a str, DataFusionError> {
        assert_eq!(later.rc, RC_OK, "{}", error_message(later.rc));
        let array = PrimitiveArray::<P>::from_iter_values((0..ROWS_PER_PAGE * 8).map(value_at));
/// core count and monitors it, and a pool created here would be neither sized nor monitored.
            configured_max,
    where
        // Bitmaps are indexed from the least significant bit, so this clears bit 3: row 3 is null.
/// Resolves the store a cursor reads through from a Java-supplied pointer.
                message.contains("initial batch size"),
        return Ok(Arc::clone(&manager.io_runtime));
        let message = error_message(next_batch(handle, FIXTURE_ROWS + 1).rc);
use opensearch_tiered_storage::tiered_object_store::MetadataCachingStore;
            value_kind,
        assert_eq!(
            "a resident batch must be accounted against the pool"
        let _globals = crate::test_process_globals::lock();
/// Each holds `crate::test_process_globals::lock` for the same reason as the module above.
            .map(encoded_fixture_value)
#[ffm_safe]
/// Writes `value` through a nullable out-parameter.
    .map_err(|e| e.to_string())
    file_len: i64,
        let handle = open_fixture(&file);
    /// Opens a cursor over one column. `store_override` is the store that owns `filename`; `None`
        assert!(message.contains("unknown handle"), "{message}");
            .err()
        parquet_fixture_with_page_rows, register_test_metadata_cache, register_test_runtime_manager,
    }
/// Java reads the values buffer and validity bitmap in place, widening per accessed row, so a sparse
        let _globals = crate::test_process_globals::lock();
            .set_data_page_row_count_limit(rows_per_page)
        assert!(holds_borrow(handle));
        )
        file.write_all(&parquet_fixture_with_page_rows(1, ROWS_PER_PAGE))
        let unknown = i64::MAX;
    initial_batch_size: i64,
            has_decoded_batch: false,
            PartitionedFile::new(location.to_string(), file_size),
            ProjectionMask::leaves(metadata.file_metadata().schema_descr(), [leaf_idx]);
                    || descriptor.path().string() == column
    if target_row == cursor.row_count {
    fn encoded_expected(target: usize, len: usize) -> Vec<i64> {
};
            (second_rg + 11..second_rg + 19).collect::<Vec<_>>()
        // are additionally limited to what is left of it.
    // 0 for a local (hot) shard; a warm shard passes its TieredObjectStore box pointer.
    #[cfg(test)]
            "a later page must also come through the store"
    /// Keyed on the Arrow type, which is the decode output: Parquet INT32 arrives as
                                          // Fold the array offset into the pointer so it addresses row 0. Zero for primitive arrays, whose
        let backing: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
        );
            CachedMetadataReaderFactory::new(store, Arc::clone(&metadata), Arc::clone(&stats)),
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        Ok(Self {
    fn each_borrowable_arrow_type_maps_to_the_kind_java_expects() {
    /// `index.parquet.docvalues.max_batch_size` so a later setting update cannot disagree with
            // Only after the cursor is gone: it cloned the Arc, so this frees the box, not the store.
        writer.write(&batch).unwrap();
                path.as_ptr(),
            stats.count.load(Ordering::Relaxed),
        return Err(DataFusionError::Internal("null string pointer".to_string()));
            DataType::Int16 => Some(Self::Short),
    fn retained_arrow_reader_crosses_row_groups_and_rejects_backward_seeks() {
        assert_eq!(cursor.next_batch(8).unwrap().num_rows(), 16);
        let error = open_named_column(bytes.clone(), "group")
        assert_ne!(batch.values_addr, 0, "a borrowed batch must expose values");
    if let Some(manager) = crate::ffm::try_get_rt_manager() {
        );
//!
            (self.batch_size / 2).max(self.initial_batch_size)
                .into_string()
        use arrow::array::{
        //
        );
            first_row,
}
            .with_precision_and_scale(18, 2)
                "value",
    use datafusion::execution::memory_pool::GreedyMemoryPool;
        let props = WriterProperties::builder()
}
            .set_max_row_group_row_count(Some(rows_per_page * 8))
) -> Result<i64, DataFusionError> {
        );
        assert!(
    }
                filename,
) -> Result<bool, DataFusionError> {
            .set_dictionary_enabled(false)
        Bytes::from(writer.into_inner().unwrap().into_inner())
        let batch = self
        while row < FIXTURE_ROWS {
            parquet_df_next_batch(
        assert!(error.contains("backward seek"), "{error}");
        );
        let children = vec![
    let store = store_from_ptr(store_ptr);
    fn a_column_that_cannot_be_borrowed_is_rejected_at_open() {
            error_message(unsafe { parquet_df_reset_iter(unknown) }),
            }
    if rows == 0 || rows > cursor.max_batch_size {
        assert_eq!(first.column(0).null_count(), 8);
        let location = ObjectPath::from(format!(
            DataType::Float64 => Some(Self::Double),
    fn an_out_of_range_initial_window_is_rejected() {
///
        let (mut cursor, _runtime) = open_parquet_fixture_with_max(
        let props = WriterProperties::builder()
        assert!(
        let schema = Arc::new(Schema::new(vec![Field::new(
    max_batch_size: usize,
    crate::test_process_globals::assert_held("the global DataFusion RuntimeEnv registration");
use parking_lot::Mutex;
        let batch =
    kind: i64,
                None,
            (target..target + 8).collect::<Vec<_>>()
            .collect::<Vec<_>>();
    ///
        let _globals = crate::test_process_globals::lock();
    fn a_failed_read_releases_the_borrow() {
                .unwrap();
    out_values_addr: *mut i64,
    cursor.borrowed_batch = None;
    out_value_kind: *mut i64,
        use arrow::array::{make_array, ArrayData};
    Ok(handle)
    ))?;
        assert!(error.contains("unsupported type Struct"), "{error}");
        }
        self.batch_size = window;
        );
        let batch = next_batch(handle, 0);
            )
            reserved > 0,
        );
        let validity_buffer = Buffer::from_slice_ref([0b1111_0111_u8]);
}
    file_ptr: *const u8, // path bytes and length, since FFM cannot pass a Rust &str
        );
            DataType::Int8 => Some(Self::Byte),
        let strings = arrow::array::StringArray::from(vec!["a", "b"]);
        )]));
            .set_statistics_enabled(EnabledStatistics::Page)
                column.len() as i64,
///
                max_batch_size,
    use std::io::Write;
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        assert_eq!(cursor.next_batch(24).unwrap().num_rows(), 32);
        );
            .set_max_row_group_row_count(Some(rows_per_page * 4))
    }
        // TODO: the growth and backoff factors are not benchmarked. Tune them, and the default
/// `Arc` is cloned out of the box so the cursor keeps the store alive for its own lifetime rather
            DataType::Int64,
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
    /// register a manager explicitly first. Installed once for the whole test process, never
            (0..8).collect::<Vec<_>>()
    ) -> Bytes {
        ];
        assert_eq!(
        let (window, rows) = self.planned_batch(target_row)?;
            self.batch_size
        // there is nothing to leak. `CURSORS` is process-wide and other tests add to and remove from
            "the adaptive window must not grow beyond the configured maximum"
        ));
    CURSORS
            self.batch_size.saturating_mul(2).min(self.max_batch_size)
        let mut values_addr = 0i64;
//!
}
        ] {
        // off-by-one in page-granular skips would surface.
        let stats = Arc::clone(&cursor.stats);
    validity_bit_offset: usize,
        ));
            (Arc::new(UInt8Array::from(vec![1])), BorrowKind::Ubyte),
        let mut writer =
        let cursor = runtime
    }
            Some(location.clone()),
            CURSORS.get(&handle).is_none(),
        //
        .unwrap();
            WriterVersion::PARQUET_1_0,
    // Released here rather than on success, so no early return below leaves buffers held. Java
        let path = file.path().to_str().unwrap();
    // `shardPath.getDataPath().resolve(file)`), and both `ObjectPath` and the registry normalise the
            open_parquet_fixture(parquet_fixture_with_all_null_page(ROWS_PER_PAGE), 8);
        let mut writer =
    /// asserts the landing batch decodes to the written values. Exercises the non-Int64 widths of
                )))
}
        // Adaptive decode window: geometric growth with multiplicative backoff. A forward skip no
        let array = arrow::array::Decimal128Array::from(values)
    fn a_type_with_no_borrow_kind_is_not_borrowable() {
    fn parquet_fixture_with_two_leaves_under_one_group() -> Bytes {
        let message = error_message(next_batch(handle, 0).rc);
///
    // The batch is gone, so its bytes must leave the pool with it.
        let values = (0..row_count).map(|value| value as i64).collect::<Vec<_>>();
use native_bridge_common::ffm_safe;
    fn forward_jump_uses_arrow_skip_without_fetching_intermediate_pages() {
            row += rows as i64;
#[no_mangle]
    /// borrow; a wrong address, a wrong kind, or an unfolded array offset keeps the batch alive
            backing,
            env.cache_manager.get_file_metadata_cache(),
            let batch = next_batch(handle, row);
    #[test]
        );
                path.as_ptr(),
        let bytes = Bytes::from(writer.into_inner().unwrap().into_inner());
        let store: Arc<dyn ObjectStore> = Arc::new(InMemory::new());
                        .is_some_and(|root| root == column)
        let configured_max = 64;
        .map(|entry| Arc::clone(entry.value()))
//! DataFusion supplies metadata, page indexes, and remote object-store/cache I/O.
            Arc::clone(&runtime),
    {
    fn encoded_fixture_value(row: usize) -> i64 {
        assert_eq!(rewound.rc, RC_OK);
        );
        let mut validity_bit_offset = -1i64;
        let first = cursor.next_batch(0).unwrap();
    }
        }
            parquet_df_close_iter(handle);
    let boxed = &*(store_ptr as *const Arc<dyn MetadataCachingStore>);
        );
        last_row: i64,
        let (_arrow_schema, file_size, footer) = load_parquet_metadata_with_meta(
        let max_batch_size = max_batch_size.clamp(1, BATCH_SIZE_HARD_LIMIT);
    }
            }
        let _globals = crate::test_process_globals::lock();
            TEST_MAX_BATCH_SIZE,
        // Repeated large jumps keep halving and bottom out at the initial window.
        file.flush().unwrap();
    reservation: MemoryReservation,
        let _globals = crate::test_process_globals::lock();
    /// fails with `ResourcesExhausted` instead of growing native memory unchecked. Released on drop.
            (Arc::new(Float32Array::from(vec![1.0])), BorrowKind::Float),
        writer.write(&batch).unwrap();
            .set_statistics_enabled(EnabledStatistics::Page)
use parquet::arrow::{parquet_to_arrow_schema_by_columns, ProjectionMask};
        // the registry keeps only a `Weak`, so ordering would otherwise decide whether an open works.
        let handle = open_fixture(&file);
            Self::Long | Self::Double => 8,
            encoded_expected(within as usize, batch.num_rows())
        // there is nothing to leak. `CURSORS` is process-wide and other tests add to and remove from
        }
    /// `ParquetColumnReader.widthForKind`.
use datafusion::execution::memory_pool::{MemoryConsumer, MemoryReservation};
        assert!(error.contains("ambiguous"), "{error}");
        assert!(
        bytes: Bytes,
        assert_eq!(cursor.next_batch(11).unwrap().num_rows(), 16);
        // Fails here if the batch would push the node past its budget. Replaces the previous batch's
    }
            Some(store) => (store, None),
        );
    // Scoped so the borrow ends before `batch` moves onto the cursor; `BorrowedBuffers` holds
        };
        let file = fixture_file();
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
        });
    fn a_supplied_store_is_read_through_for_a_file_that_is_on_no_local_disk() {
            .to_string();
use std::sync::Arc;
            // Rejected before the file is touched, so the path is irrelevant.
        store.registry().register(
        let handle = unsafe {
                let paths = several
unsafe fn open_and_register(
    }
        assert_eq!(
        );
            "nothing is borrowed before the first read"
        assert_eq!(
    /// cell of the matrix, the v2 data-page format without a dictionary.
            .block_on(backing.put(&location, bytes.into()))
        location_override: Option<ObjectPath>,
            .set_statistics_enabled(EnabledStatistics::Page)
    /// and Java is handed exactly one address per buffer.
    let column = str_from_raw(column_ptr, column_len).map_err(|e| format!("{FN} column: {e}"))?;
        let runtime = Arc::new(Builder::new_current_thread().enable_all().build().unwrap());
    fn open_fixture_with_page_rows(
            .read_batch_at(target_row as usize, rows)?
        let schema = footer.file_metadata().schema_descr();
            assert_eq!(batch.first_row, row);
    // first, because `Arc::clone` alone cannot infer the supertrait.
        // Clamp the ceiling first, then the starting window against it, so the decay floor
        assert_eq!(second.column(0).null_count(), 16);
        let mut validity_addr = 0i64;
    if !ptr.is_null() {
///
            .unwrap();
            return Err(DataFusionError::Internal(format!(
        let store = Arc::new(TieredObjectStore::new(
        // A backward seek fails inside the reader, after the release, for the same reason.
    };
            BATCH_SIZE_HARD_LIMIT / 2
        let props = WriterProperties::builder()
    write_out(out_validity_addr, borrow.validity_addr as i64);
    /// `LocalFileSystem`.
    /// the values buffer's own pointer (`ScalarBuffer::new(buffer, offset, len)` when a
    column_ptr: *const u8,
            let cache_manager = CacheManagerConfig::default().with_file_metadata_cache(Some(cache));
        assert_eq!(
        assert_eq!(
            2,
        let target = (ROWS_PER_PAGE * 5) as i64;
/// `store_ptr` must be `0` or a pointer obtained from `ts_get_object_store_box_ptr` that has not yet
            ))) as Arc<dyn FileMetadataCache>;
        assert_eq!(cursor.reader.position(), 25);
        rows_per_page: usize,
                TEST_MAX_BATCH_SIZE,
    cursor.has_decoded_batch = false;
            "{FN}: initial batch size {initial_batch_size} outside 1..={max_batch_size}"
}
            (row % 7) as i32 * 3
            .set_data_page_row_count_limit(rows_per_page)
            Arc::new(Field::new("left", DataType::Int64, false)),
            "the fixture path must not exist locally, or this test proves nothing"
        };
/// none of which the inherent-method tests above touch.
    ///
    #[test]
            load_scoped_page_index_cols(&store, &location, &footer, &[leaf_idx], &[leaf_idx])
        assert_eq!(unsafe { parquet_df_reset_iter(handle) }, RC_OK);
    use arrow::record_batch::RecordBatch;
    borrowed_batch: Option<RecordBatch>,
        let tiny_pool: Arc<dyn datafusion::execution::memory_pool::MemoryPool> =
        let mut writer =
#[no_mangle]
        register_test_runtime_manager();
        let (mut cursor, _runtime) = open_parquet_fixture(bytes, 8);
            false,
        ));
            Arc::new(Field::new("right", DataType::Int64, false)),
            "the max-sized window is clamped at the page boundary"
    /// A decimal column: Parquet stores precision 18 as INT64, and Arrow decodes it back to
            rc,
        assert_eq!(cursor.next_batch(0).unwrap().num_rows(), 8);
        let _globals = crate::test_process_globals::lock();
            (target..target + 8).collect::<Vec<_>>()
            .map(|row| (row >= rows_per_page).then_some(row as i64))
                return Err(DataFusionError::Plan(format!(
                return Err(DataFusionError::Plan(format!(
    fn dictionary_encoded_float32_decodes_after_cross_page_jump() {
        assert_eq!(batch.rc, RC_OK);
    /// Stands in for the environment production registers from `create_global_runtime`. Held in a
    if initial_batch_size <= 0 || initial_batch_size > max_batch_size {
    ///
        let batch =
    /// Chooses the decode window for `target_row` and returns `(window, rows)`:
/// between open and read.
        );
            batch_size,
        let (mut cursor, _runtime) = open_fixture(1, 8);
    }
        // serve doc values for the wrong column.
            CString::from_raw((-rc) as *mut c_char)
                .null_bit_buffer(Some(validity_buffer))
        let _globals = crate::test_process_globals::lock();
    /// An array can be a window onto a longer buffer, so row 0 need not sit at the buffer's start
        assert_eq!(
static NEXT_HANDLE: AtomicI64 = AtomicI64::new(1); // 0 is never a live handle
            parquet_fixture_with_page_rows(1, 1024),
    if at_eof(&cursor, target_row, FN).map_err(|e| e.to_string())? {
        // "group" is the root of two leaves. Binding it to whichever came first would silently
        writer.write(&batch).unwrap();
        self.reservation.try_resize(batch.get_array_memory_size())?;
        register_test_metadata_cache();
    fn a_served_batch_is_retained_so_javas_pointers_stay_valid() {
            DataType::UInt16 => Some(Self::Ushort),
    }
    pub(super) fn parquet_fixture_encoded(
/// builds its own `LocalFileSystem` and reads through a synchronous `ChunkReader`. A non-zero
        match data_type {
//! process-wide registry, so an unknown or stale handle is reported as an error rather
    fn a_batch_over_the_memory_budget_fails_instead_of_being_decoded() {
        let boundary = (ROWS_PER_PAGE * 7) as i64;
            initial_batch_size: batch_size,
            )
            ROWS_PER_PAGE,
            Arc::new(TieredStorageRegistry::new()),
        let file = fixture_file();
    column_len: i64,
        }
                LOCAL_STORE, // these fixtures are real files on disk
            ProjectionMask::leaves(schema, [leaf_idx]),
        file.flush().unwrap();
    }
        ))
    fn for_arrow(data_type: &DataType) -> Option<Self> {
        register_test_metadata_cache();
            }
            .unwrap();
use once_cell::sync::Lazy;
                &mut validity_bit_offset,
/// Largest decode window this reader will accept, whatever the caller asks for.
            "{FN}: max batch size {max_batch_size} outside 1..={BATCH_SIZE_HARD_LIMIT}"
    #[test]
        assert!(
    #[test]
    /// Int8/Int16/Int32/Date32 depending on its logical type.
    }
use object_store::path::Path as ObjectPath;
        assert_eq!(
    #[test]
            cursor
            let expected = (batch.first_row..=batch.last_row).collect::<Vec<_>>();
        let _globals = crate::test_process_globals::lock();
        // Without the reset this would be a rejected backward seek.
        }
        assert_eq!(
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
            .set_statistics_enabled(EnabledStatistics::Page)
        writer.write(&batch).unwrap();
    #[test]
///
            false,
    use opensearch_tiered_storage::types::{FileLocation, TieredFileEntry};
        // nested schema, by a future mapping type or another writer.
                batch.validity_addr, 0,
            batch_size,
    }
pub unsafe extern "C" fn parquet_df_reset_iter(handle: i64) -> i64 {
            let batch = next_batch(handle, row);
}
        // Rows 3..8 of an eight-row buffer.
        }
        writer.write(&batch).unwrap();
    let (validity_addr, validity_bit_offset) = match data.nulls() {
        let batch =
            array.to_data().offset(),
            cursor.next_batch(rows_per_page as i64).unwrap().num_rows(),
        writer.write(&batch).unwrap();
    fn open_named_column(bytes: Bytes, column: &str) -> Result<DocValuesCursor, DataFusionError> {
        values_addr: i64,
        file.flush().unwrap();
            );
        };
            location.as_ref(),
            borrow.validity_addr, validity_base,
                "width for {}",
        return Err(format!(
    /// A low-cardinality Int64 column written with a chosen dictionary mode and writer version.
        // larger than the current window is treated as dense access, so the window doubles; a jump
        assert_eq!(
use dashmap::DashMap;
    fn dictionary_encoded_pages_decode_across_all_skip_shapes_with_writer_v2() {
        assert_eq!(next_batch(handle, 0).rc, RC_OK);
        let mut first_row = -1i64;
        // (e.g. a moderately selective filter) and must not stall the ramp-up.
        assert_eq!(cursor.next_batch(56).unwrap().num_rows(), 8);
                    .map(|&idx| schema.column(idx).path().string())
    /// one exists to exercise the skip path against dictionary-encoded pages and both data-page
        let decimal = arrow::array::Decimal128Array::from(vec![1_i128, 2])
        // only a local-filesystem store can name a descriptor, and only it knows how an object path
        let store_ptr = leak_store_pointer(store);
    fn holds_borrow(handle: i64) -> bool {
        let handle = open_fixture(&file);
            Float32Array, Float64Array, Int16Array, Int32Array, Int8Array, UInt16Array,
            "resolution must still pick a single leaf: {error}"
    #[cfg(test)]
/// Advance to `target_row`, skip intermediate pages through Arrow's retained
            NEXT_HANDLE.fetch_add(1, Ordering::Relaxed)
            open_fixture_with_page_rows(1, rows_per_page, BATCH_SIZE_HARD_LIMIT / 2);
                Arc::clone(&runtime),
        assert!(borrowable_buffers(&strings).is_none(), "Utf8");
            "value",
        )
        assert_eq!(forward.rc, RC_OK);
        assert!(
        assert_eq!(cursor.next_batch(0).unwrap().num_rows(), 8);
    }
            .set_write_batch_size(rows_per_page)
            _ => None,
            &location,
        assert_dictionary_jump_decodes::<arrow::datatypes::Float64Type>(DataType::Float64, |row| {
        let _globals = crate::test_process_globals::lock();
            [only] => *only,
    use tempfile::NamedTempFile;
            projection,
                self.row_count
                &mut validity_addr,
use datafusion::error::DataFusionError;
        let object_meta = store.head(&location).await?;
    }
    })
        let projection =
            DataType::Float32 => Some(Self::Float),
        let batch = RecordBatch::try_new(schema, vec![Arc::new(group) as ArrayRef]).unwrap();
        let batch_size = batch_size.clamp(1, max_batch_size);
#[ffm_safe]
        // Resolved once so the cache below and the pool the reservation uses come from one runtime.
        // test cannot shrink the budget for tests running alongside it.
    /// A decimal is a supported Parquet physical type (precision 18 is stored as INT64) that decodes
/// been destroyed, which is what `ParquetDataFormatStoreHandler` hands out for the shard's lifetime.
    /// True when the cursor behind `handle` is holding Arrow buffers on Java's behalf.
    ) -> (DocValuesCursor, Arc<Runtime>) {
            8,
                LOCAL_STORE,
        let props = WriterProperties::builder()
    use opensearch_tiered_storage::registry::TieredStorageRegistry;
    Ubyte = 7,    // u8, zero-extended
                Some(store),
        assert_eq!(non_null.column(0).null_count(), 0);
                Some(location.clone()),
            .set_data_page_row_count_limit(rows_per_page)
        // (`initial_batch_size`) can never exceed the growth cap.
        assert!(
                .next_batch((BATCH_SIZE_HARD_LIMIT / 2) as i64)
            reservation,
            .set_dictionary_enabled(dictionary)
                .unwrap();
    fn resetting_releases_the_borrow_and_allows_rereading_row_zero() {
        let right = Arc::new(Int64Array::from((8..16_i64).collect::<Vec<_>>())) as ArrayRef;
        // 8 -> 16 -> 32 -> 64, then held: doubling would pass the configured ceiling.
            .with_precision_and_scale(18, 2)
        let mut value_kind = -1i64;
    fn local_file_cursor_reuses_retained_descriptor_for_page_reads() {
        // satisfied. The remembered window is capped at the whole page; only the rows decoded now
    /// uses the local filesystem, which is what local-tier shard files need. A non-local store is
    /// about a different cap pass their own, since the value is per cursor.
    use object_store::ObjectStoreExt;
        let location = ObjectPath::from(path.as_str());
            RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values)) as ArrayRef])
        )?;
            "a rejected batch must leave nothing reserved"
            .block_on(DocValuesCursor::open(
    /// The value [`parquet_fixture_encoded`] writes at `row`: repeating, so dictionary encoding
        let _globals = crate::test_process_globals::lock();
    }
    /// (OpenSearch `half_float`) needs a kind whose Java side re-encodes to a sortable short.
    fn a_batch_within_the_memory_budget_is_accounted_and_released() {
            RecordBatch::try_new(schema, vec![Arc::new(Int64Array::from(values)) as ArrayRef])
            .set_data_page_row_count_limit(rows_per_page)
        // would read the wrong column silently, so an ambiguous name is an error.
        assert_eq!(cursor.next_batch(24).unwrap().num_rows(), 32);
            ))
        );
        let page_remaining = self.reader.rows_remaining_in_page(target_row)?;
                .unwrap();
        dictionary: bool,
        return None;
    /// defensive. A validity bitmap keeps its offset, because a bit position cannot be folded into
        let (mut cursor, _runtime) = open_fixture(1, 8);
        store_ptr,
        Batch {
//!
    }
            encoded_expected(boundary as usize, batch.num_rows())
        // EOF returns before decoding, so it must not leave the previous batch held.
    #[test]
            unsafe { exported_i64s(batch.values_addr, 8) },
            let rows = (batch.last_row - batch.first_row + 1) as usize;
        // Registered here so a test is not left depending on another test having registered first:
    }
    // Same pointer type and upcast dance as `api::create_reader`: bind the concrete trait object
        batch_size: usize,
    }
/// `index.parquet.docvalues.max_batch_size` can only lower a cursor's ceiling, never raise it past
    }
    let filename = str_from_raw(file_ptr, file_len).map_err(|e| format!("{FN} file: {e}"))?;
mod tests {
    use parquet::file::properties::{EnabledStatistics, WriterProperties, WriterVersion};
            "the values window is carried by the buffer pointer, not by the offset"
                target_row,
            .set_write_batch_size(rows_per_page)
        // the initial size after every jump.
            !holds_borrow(handle),
    }
        ));
    // The FFM contract carries only a message (see native_bridge_common::error), so the typed
fn cursor_for(handle: i64, fn_name: &str) -> Result<Arc<Mutex<DocValuesCursor>>, DataFusionError> {
        None => (0, 0),
    }
        let within = (ROWS_PER_PAGE / 2) as i64;
        } else {
            .unwrap();
            int64_values(&batch),
            .set_statistics_enabled(EnabledStatistics::Page)
/// than depending on the shard's box outliving it.
            factory,
    fn small_forward_skip_keeps_growing_the_window() {
        let borrow = borrowable_buffers(array.as_ref()).expect("Int64 must be borrowable");
}
        );
                "row {target_row} out of range (0..{})",
    /// wrong numbers. Mirrors the `KIND_*` constants in `DecodedBatch.java` and the widths in
                batch.first_row,
/// doc values tolerate a backward target (their layout is seekable), so a non-compliant caller
        // can share a name, and a group root can cover several leaves. Serving whichever came first
        );
    cursor.borrowed_batch = Some(batch);
use datafusion::datasource::physical_plan::parquet::ParquetFileReaderFactory;
            .ok_or_else(|| {
use crate::forward_reader::{ParquetForwardBatchReader, ParquetForwardBatchReaderFactory};
            .expect_err("a batch that does not fit the pool must not be handed out");
        assert_eq!(cursor.batch_size, configured_max);
            !holds_borrow(handle),
        let values = (0..rows_per_page * 2)
        let batch = next_batch(handle, 0);
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
    fn open_fixture(file: &NamedTempFile) -> i64 {
        assert_eq!(forward.first_row, 32);
    fn a_lowered_maximum_caps_growth_below_the_hard_limit() {
        (cursor, runtime)
        let rows_per_page = BATCH_SIZE_HARD_LIMIT * 2;
    // error is flattened here at the boundary.
            );
/// Shared entry-point prologue: resolves a live cursor handle.
/// `open` rejects an unsupported column, so `None` here means the column's Arrow type changed
    /// `Decimal128`, which has no [`BorrowKind`].
        let file = fixture_file();
        register_test_runtime_manager();
        let _globals = crate::test_process_globals::lock();
    filename: &str,
    batch_size: usize,
    pub(super) const TEST_MAX_BATCH_SIZE: usize = BATCH_SIZE_HARD_LIMIT;
            reader_factory,
        // A page boundary, so the read cannot be satisfied from the first fetch alone.
                .offset(3)
            location.as_ref(),
    /// growth cap however the two settings are combined.
/// Status codes returned to Java. A negative return is an error-message pointer produced by
    static FN: &str = "parquet_df_next_batch";
use crate::indexed_table::parquet_bridge::{
        max_batch_size: usize,
    }
    if len < 0 {
            let message = error_message(open_iter("/nonexistent/never-opened.parquet", initial));
            .to_string(),
/// this. Mirrored by `ParquetSettings.DEFAULT_DOCVALUES_MAX_BATCH_SIZE` on the Java side.
    }
    }
        assert_dictionary_jump_decodes::<arrow::datatypes::Int32Type>(DataType::Int32, |row| {
        borrowable_buffers(array.as_ref())
        let page_rows = self.reader.page_row_count(target_row)?;
    }
    #[test]
    Some(caching)
    let values_addr = buffer.as_ptr() as usize + data.offset() * width;
        } else if self.has_decoded_batch {
            .unwrap();
        crate::cache::register_global_runtime_env(&ENV);
        let leaf_idx = match matches.as_slice() {
            !error.contains("ambiguous"),
        let mut writer =
        assert_eq!(batch.rc, RC_OK, "{}", error_message(batch.rc));
        let forward = next_batch(handle, 32);
    fn parquet_fixture_with_all_null_page(rows_per_page: usize) -> Bytes {
        }
    Err(DataFusionError::Configuration(
            row_count,
unsafe fn write_out(ptr: *mut i64, value: i64) {
            })?;
    const FIXTURE_ROWS: i64 = (ROWS_PER_PAGE * 8) as i64;
const RC_OK: i64 = 0;
        );
            parquet_fixture_with_page_rows(row_groups, rows_per_page),
                &mut value_kind,
    #[test]
        let file = fixture_file();
                column.len() as i64,
        let _globals = crate::test_process_globals::lock();
    #[test]
    let handle = NEXT_HANDLE.fetch_add(1, Ordering::SeqCst);
    fn plain_encoded_pages_decode_across_all_skip_shapes_with_writer_v2() {
    // `usize` on cast, and the Java reader exposes an int overload that bypasses settings resolution.
/// Opening a cursor reads two process globals — the runtime manager and the global `RuntimeEnv`
                8,
/// `ffm_safe`, so only non-negative values are status; 1 is unused. Mirrors `ParquetCodecBridge`.
        let _globals = crate::test_process_globals::lock();
        let error = open_named_column(bytes, "left")
            && target_row - position <= self.batch_size;
#[derive(Copy, Clone, Debug, PartialEq, Eq)]
            "Boolean is bit-packed, so it needs a value bit offset before it can be exported"
        let (mut cursor, _runtime) = open_fixture(1, 8);
            .unwrap();
///
            8,
            borrowable_buffers(&booleans).is_none(),
                super::tests::TEST_MAX_BATCH_SIZE as i64,
            "value",
    #[test]
        });
        runtime: Arc<Runtime>,
            ArrowWriter::try_new(Cursor::new(Vec::new()), Arc::clone(&schema), Some(props))
            .set_data_page_row_count_limit(ROWS_PER_PAGE)
        ));
    // Re-checked here because these arrive as untrusted `i64`: a negative would wrap to an enormous
                    .build()
    fn fixture_file() -> NamedTempFile {
                unsafe { exported_i64s(batch.values_addr, rows) },
    #[test]
    UintBits = 3, // u32 raw bits, zero-extended
    load_parquet_metadata_with_meta, CachedMetadataReaderFactory, ReadIoStats,
        validity_addr, // start of the null-bitmap buffer; the bit offset is applied separately
                expected,
        file.write_all(&super::tests::parquet_fixture_with_decimal_column(
        assert_eq!(rewound.first_row, 0);
        let jumped = cursor.next_batch(target).unwrap();
            0,
    #[test]
                .next_batch((BATCH_SIZE_HARD_LIMIT + BATCH_SIZE_HARD_LIMIT / 2) as i64)
/// Tests driving the `extern "C"` entry points: handle registry, status codes, and `borrowed_batch`,
        }
    }
            several => {
            Self::Int | Self::UintBits | Self::Float => 4,
            .reader
        }
 * compatible open source license.
                "batch [{}, {}]",
        for message in [
    initial_batch_size: usize,
    /// Two leaves under one struct, so the group root matches both by first path part.
            "Arrow should fetch only the first and target data pages"
        row_groups: usize,
        assert_eq!(int64_values(&first), encoded_expected(0, first.num_rows()));
        assert_eq!(
use datafusion::execution::runtime_env::RuntimeEnv;
        // Land on an exact page boundary: the first row of the landing page, where an
        use arrow::buffer::Buffer;
    store_ptr: i64,
            reads_before,
        unsafe {
        let handle = open_iter(file.path().to_str().unwrap(), 8);
        let mut writer =
            .set_writer_version(WriterVersion::PARQUET_2_0)
            assert_eq!(batch.rc, RC_OK, "row {row}");
        let jump = (ROWS_PER_PAGE * 6 + 3) as i64;
            .err()
        assert!(holds_borrow(handle));
/// Rewinds a cursor to row zero, rebuilding the Parquet decoder while reusing the resolved metadata
        .map_err(|e| DataFusionError::Internal(format!("invalid UTF-8: {e}")))
        Ok((window, window.min(page_remaining)))
        value_kind: i64,
        // rather than a flat primitive, so it is refused at open instead of on the first read.
        // it concurrently, so its length is not a signal this test can assert on.
    }
    stats: Arc<ReadIoStats>,
                        "no page index available for column '{column}' in {filename}"
                DataFusionError::Internal(format!("reader exhausted before row {target_row}"))
    /// a byte pointer, which is why the bit offset is a separate out-parameter.
            cursor
            assert!(
    fn exported_addresses_read_back_as_the_rows_the_batch_reports() {
            error.contains("group.left") && error.contains("group.right"),
    use object_store::memory::InMemory;
impl DocValuesCursor {
        max_batch_size,
        let file = fixture_file();
        // Converted with the same projection and key-value metadata the reader uses, so the two
            ArrayData::builder(DataType::Int64)
        let rc = unsafe {
        let file = fixture_file();
        let column = batch.column(0).as_primitive::<P>();
    /// supplied by the caller along with its own `location_override`.
        assert_eq!(unsafe { parquet_df_close_iter(handle) }, RC_OK);
    /// to Arrow `Decimal128`, which cannot be borrowed. `open` gates on the decoded Arrow type, so it
        // Before adding a Parquet DocValuesProducer, measure latency with concurrent queries over
/// Store pointer meaning "read from the local filesystem", which is every hot shard. Mirrors
        );
        let mut last_row = -1i64;
        )
    }
            true,
        // Replaces the cursor's own reservation rather than the process-wide registration, so this
    // The object path is derived from `filename` in both cases. A warm shard's registry is keyed by
use datafusion::execution::cache::cache_manager::FileMetadataCache;
    ))
        let metadata =
            (Arc::new(UInt16Array::from(vec![1])), BorrowKind::Ushort),
                RuntimeEnvBuilder::new()
        store,
            .to_string();
        rc: i64,
            true,
/// Java-side interpretation of a borrowed values buffer, and the single place a supported column
            let rows = cursor.next_batch(row).unwrap().num_rows();
