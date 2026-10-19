                self.sort_batch = Some(batch);
                Err(e)
 */
        assert!(is_row_id_alive(Some(&bits), 128, 127));
            }
#[inline]
    }
        )
        // Last alive in that range is abs 10 (= local idx 5 in this batch). Result is 5+1=6.
            .iter()
            &self.nulls_first,
    pub nulls_first: Vec<bool>,
            let bits: Vec<u64> = (0..words).map(|_| next_rand(&mut state)).collect();
        assert!(!is_row_id_alive(Some(&row_zero_dead), 64, 0));
// ---------------------------------------------------------------------------
        if word_idx == (last_row / 64) as usize {
                None => {
                        "Data reader exhausted at position {}, needed sort_batch_index={}",
        if !self.deferred {
                self.current_sort_batch_bytes = 0;
                } else if new_bytes < old_sort_bytes {
        assert!(is_row_id_alive(Some(&bits), 64, 63));
    }
        let sort_col_set: std::collections::HashSet<&str> =
        ));
                word &= (1u64 << (top_bit + 1)) - 1;
        let writer_generation = crate::writer_properties_builder::read_writer_generation(
        base_row_id: u64,
                        )));
        }
        sort_columns: &[String],
        let tx = self.sort_prefetch_tx.clone();
        for _ in 0..200 {
        }
    /// Returns `(cursor, projected_arrow_schema, parquet_schema_descriptor, writer_generation, total_row_count)`
                builder2
            reservation.shrink(self.current_data_batch_bytes);
            Ok(None) | Err(_) => None,
        // Track sort batch + prefetch (estimate 2x first batch)
    fn trailing_dead_rows_skipped() {
impl FileCursor {
use super::schema::projection_indices_excluding_row_id;
use parquet::schema::types::SchemaDescriptor;
            self.skip_to_next_live_row(reservation)?;
// Tests
        max_sort_modes: &[bool],
            sort_batch_index: 0,
        // Position at the first live row (no-op when live_bits is None).
        if self.sort_prefetch_pending {
            if top_bit < 63 {
            assert!(
                Some(b) => b.num_rows(),
        let old_sort_bytes = self.current_sort_batch_bytes;
        assert!(!is_row_id_alive(Some(&bits), 128, 63));
                    let base = next_rand(&mut state) % limit;
        self.data_batch = None;
        let reader = self
    /// Deterministic xorshift so the sweep is reproducible without a dev-dependency.
        let first_sort_batch = match sort_reader.next() {
    pub sort_batch: Option<RecordBatch>,
    #[inline]
            base_row_id: 0,
            self.data_batch = None;
    /// Source row-id offset at the start of the current sort batch.
            self.current_data_batch_bytes = 0;
            .count()
        get_sort_values(
    #[inline]
                    })
/// When deferred mode is active (controlled by the dynamic index setting
    }
    #[test]
                .ok_or_else(|| MergeError::Logic("Data batch not loaded".into()))?;
    /// Advances `row_idx` past dead rows, loading successor batches as needed.
        // Bitmap covers only 64 bits, but num_rows says 128.
                        }
        ];
        let prev_rows = self
    pub fn take_slice(
/// costs one word read per 64 rows rather than one bit test per row. The word straddling the
    #[test]
pub fn last_live_index_plus_one(
        }
        is_row_id_alive(
///
            let data_proj = parquet::arrow::ProjectionMask::roots(
        let bits: Vec<u64> = vec![1u64 << 63];
    /// `live_bits` is an optional packed bitset of live rows (Lucene layout).
                }
                    reservation.shrink(self.current_data_batch_bytes);
        assert_eq!(last_live_index_plus_one(Some(&bits), 100, 0, 64), 0);
            Err(e) => {
            .map(|col| {
                    let want = reference(Some(bits), num_rows, base, upper);
    sort_prefetch_rx: std::sync::mpsc::Receiver<Option<MergeResult<RecordBatch>>>,
        loop {
        for r in 0..63 {
    pub sort_col_types: Vec<ArrowDataType>,
    pub fn current_sort_values(&self) -> MergeResult<Vec<SortKey>> {
            &self.sort_col_indices,
                    if super::is_row_id_alive(live_bits, num_rows, base_row_id + idx as u64) {
            reservation.shrink(self.current_data_batch_bytes);
            data_projection_indices
        };
            );
            }
        self.row_idx += 1;
            .filter(|f| {
        }
            .map(|b| b.num_rows() as u64)
        assert!(!is_row_id_alive(Some(&bits), 128, 126));
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 0), 0);
        let batch_bytes = cursor.sort_batch.as_ref().unwrap().get_array_memory_size();
    /// One past the highest live-row index within `[0, batch_upper)`.
    fn bit_crosses_word_boundary_64() {
                Some(Err(e)) => return Err(e.into()),
    fn none_bits_returns_true_for_any_row() {
            end_excl - 1,
    sort_prefetch_pending: bool,
    ///
        if self.data_batch.is_some() && self.data_batch_index == self.sort_batch_index + 1 {
    fn all_rows_alive_returns_batch_upper() {
    fn empty_batch_returns_zero() {
            parquet::arrow::ProjectionMask::roots(
            live_bits,
                        "bits={:?} num_rows={} base={} upper={}",
        if self.live_bits.is_some() {
                .ok_or_else(|| MergeError::Logic("Batch is None".into()))?;
            return Ok(self.sort_batch.is_some());
        let reader = Arc::clone(&self.sort_reader);
    #[test]
            batch_upper,
        // Build data reader (only in deferred mode)
                // Cursor exhausted — release all sort batch tracking
        assert!(is_row_id_alive(Some(&bits), 100, 0));
                .as_ref()
        // Cursor is at base_row_id=5, asking about a 10-row batch ⇒ checks abs rows 5..14.
            .as_mut()
    if batch_upper == 0 {
            vec![0, 0, 1, 0],          // only abs row 128 alive
        let sort_reader = Arc::new(Mutex::new(sort_reader));
            Ok(Some(Ok(batch))) => Some(batch),
            return Ok(());
                self.current_sort_batch_bytes = new_bytes;
    }
    #[test]
        }
/// uses two readers: a sort-only reader for the merge heap and a data reader
            .unwrap_or(0);
        }
    data_batch: Option<RecordBatch>,
            }
        let data_reader = if deferred {
            return 0;
                self.sort_batch_index += 1;
            file_id,
            return Ok(());
        let projected_schema = Arc::new(ArrowSchema::new(
    pub file_id: usize,
            .as_ref()
        assert_eq!(last_live_index_plus_one(Some(&bits), 10, 0, 12), 12);
    data_reader: Option<parquet::arrow::arrow_reader::ParquetRecordBatchReader>,
        let slice = if self.deferred {
            )
            sort_prefetch_pending: false,
                // Error: release sort batch tracking since cursor is now exhausted
                    .map(|f| f.data_type().clone())
        reservation: &mut MemoryReservation,
        len: usize,
        assert_eq!(last_live_index_plus_one(Some(&bits), 100, 60, 10), 10);
            batch,
        reservation: &mut MemoryReservation,
        assert!(is_row_id_alive(Some(&bits), 0, 0));
        if self.live_bits.is_none() {
            self.sort_batch = None;
    ) -> usize {
        let bits: Vec<u64> = vec![];
            ],
                    .ok_or_else(|| {
                let new_bytes = batch.get_array_memory_size();
        let file1 = File::open(path)?;
        }
            .iter()
        // Row 0 is in word 0 and explicitly dead.
                    self.current_data_batch_bytes = 0;
        }
                    let limit = capacity + 64; // deliberately probe beyond the bitset
                    path, file_id
pub struct FileCursor {
            }
                capacity + 40,
    #[test]
            vec![0, 1u64 << 63, 0, 0], // only abs row 127 alive
                        MergeError::Logic(format!(
    live_bits: Option<Arc<Vec<u64>>>,
    }
                .iter()
    }
    #[test]
            num_rows: total_row_count as u64,
        assert!(!is_row_id_alive(Some(&bits), 128, 65));
            let file2 = File::open(path)?;
        batch_size: usize,
    pub fn advance_past_batch(&mut self, reservation: &mut MemoryReservation) -> MergeResult<bool> {
            }
                !is_row_id_alive(Some(&bits), 64, r),
                        return Err(MergeError::Logic(format!(
            let n = match self.sort_batch.as_ref() {
            .filter(|f| f.name() != super::schema::ROW_ID_COLUMN_NAME)
            .sort_batch
        get_merge_pool(None).spawn(move || {
    fn last_live_index_plus_one(&self, batch_upper: usize) -> usize {
            &self.sort_col_types,
#[inline]
    fn rows_past_bitset_length_count_as_alive() {
            }
            }
        None => true,
                self.data_reader = None;
        } else {
                            }
        // Release previous data_batch — about to load a new one
                None => return Ok(()),
 * The OpenSearch Contributors require contributions made to
        None => return batch_upper,
        // Rows 0..4 alive, rows 5..15 dead.
        let end_excl = self.last_live_index_plus_one(batch.num_rows());
            _ => {
    fn bit_at_word_boundary_63() {
            &self.max_sort_modes,
        // Row 64 lives in word 1, which is missing.
        x ^= x << 13;
        Ok(())
            sort_reader,
 * this file be licensed under the Apache-2.0 license or a
        if self.live_bits.is_some() {
        };
                    self.data_batch_index += 1;
            data_batch_index: 0,
    }
                }
        // num_rows=10 but bitset says everything is dead; rows >= 10 are alive by contract.
            if self.row_idx < n {
}
                // Advance the absolute source row-id offset past the batch we just dropped.
            }
    #[test]
        match self.try_load_data(reservation) {
use super::heap::{get_sort_values, SortKey};
    /// Total source rows. Bits at indices `>= num_rows` are ignored.
    fn is_current_row_alive(&self) -> bool {
        // Release data batch tracking — previous data_batch is dropped
        let row_zero_dead: Vec<u64> = vec![!0u64 & !1u64];
            data_reader,
                        ))
    if batch_end > num_rows || batch_end > bitset_rows {
        // Resolve sort column types
            }
use arrow::datatypes::{DataType as ArrowDataType, Schema as ArrowSchema};
                schema
        let bits: Vec<u64> = vec![!0u64];
            })
    ) -> MergeResult<RecordBatch> {
            batch.slice(start, len)
            // Batch boundary crossed — release data_batch before loading next sort batch
/// [`is_row_id_alive`].
    }
    }
    /// from the sort batch. When `live_bits` is `Some`, dead rows are removed via a
            self.skip_to_next_live_row(reservation)?;
                }
            self.num_rows,
                        | ArrowDataType::LargeUtf8
                data_projection_indices.clone(),
                )
    pub max_sort_modes: Vec<bool>,
) -> usize {
                .data_batch
/// `None` ⇒ all alive; rows beyond `num_rows` or beyond the bitset's length are treated
        };
        } else {
        Some(bits) => super::live_docs::is_alive_in_words(bits, num_rows, abs_row_id),
            return Ok(());
                data_projection_indices.clone(),
    }
            .ok_or_else(|| MergeError::Logic("Data reader already closed".into()))?;
                        self.data_batch_index, self.sort_batch_index
    }
        cursor.start_sort_prefetch();
            Ok(()) => Ok(()),
    }
    #[test]
        assert_eq!(last_live_index_plus_one(None, 100, 0, 50), 50);
            };
    #[inline]
    pub fn last_sort_values(&self) -> MergeResult<Vec<SortKey>> {
    pub fn new(
        return 0;
        let sort_projection = if deferred {
            cursor,
            }
        return batch_upper;
            .collect::<MergeResult<_>>()?;
    pub base_row_id: u64,
        // Resolve sort column indices within the sort batch schema
        assert!(is_row_id_alive(Some(&bits), 128, 64));
            self.num_rows,
        Some(bits) => bits,
        assert!(is_row_id_alive(None, 100, 0));
    }
///
        assert!(is_row_id_alive(None, 0, 0));
        )
            total_row_count,
        start: usize,
        let word_base = (word_idx as u64) * 64;
            sort_columns.iter().map(|s| s.as_str()).collect();
        }
    /// The original one-bit-at-a-time implementation, kept as the oracle for the word-scan.
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 10), 10);
    data_batch_index: usize,
    }
    fn next_rand(state: &mut u64) -> u64 {
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 5, 10), 6);
    base_row_id: u64,
                        // Track full-column data batch — already allocated by data_reader.next()
                }
}
    fn bit_at_word_boundary_127() {
                )))
                Some(Err(e)) => Some(Err(MergeError::Arrow(e))),
            let _ = tx.send(result);
use super::io_task::get_merge_pool;
            Some(
// ---------------------------------------------------------------------------
    }
                for _ in 0..40 {
                r
    use super::is_row_id_alive;
        if self.current_data_batch_bytes > 0 {
            // num_rows sometimes shorter than the bitset, sometimes exactly full, sometimes longer.
    #[inline]
                self.sort_prefetch_pending = false;
        let bits: Vec<u64> = vec![1u64 << 10];
                self.current_sort_batch_bytes = 0;
    }
    sort_reader: Arc<Mutex<parquet::arrow::arrow_reader::ParquetRecordBatchReader>>,
                Some(Ok(batch)) if batch.num_rows() > 0 => Some(Ok(batch)),
                                )));
            self.ensure_data_loaded(reservation)?;
            "last_sort_values called on cursor with no live row"
        }
}
        let all_alive: Vec<u64> = vec![!0u64];
                                    self.sort_batch_index
    let last_row = batch_end - 1;
            self.live_bits.as_deref().map(|v| v.as_slice()),
        self.sort_batch = None;
                "row {} should be dead",
        assert!(is_row_id_alive(Some(&bits), 10, 10));
            vec![0, 0, 0, 0],
                let start_abs = self.base_row_id + start as u64;
    pub fn batch_height(&self) -> usize {
        if word_idx == first_word {
        );
/*
                return Err(e);
                .filter_map(|c| schema.fields().iter().position(|f| f.name() == c.as_str()))
                    assert_eq!(
        }
            vec![1, 0, 0, 1u64 << 63], // rows 0 and 255 alive
                0xAAAA_AAAA_AAAA_AAAA,
                            "Data reader returned empty batch at position {}",
    }
        if word_idx == first_word {
    fn try_load_data(&mut self, reservation: &mut MemoryReservation) -> MergeResult<()> {
                    return Err(MergeError::Logic(format!(
            sort_batch: Some(first_sort_batch),
            let builder2 = ParquetRecordBatchReaderBuilder::try_new(file2)?;
                return Err(MergeError::Logic(format!(
                    )))
mod last_live_index_plus_one_tests {
            .build()?;
        deferred_threshold: usize,
        });
            let result = match reader.next() {
    }
                self.data_reader = None;
    #[test]
        num_rows: u64,
        };
            data_batch: None,
            if !self.load_next_batch(reservation)? {
        // Mask off bits below the batch's first row in the bottom word.
    fn short_bitmap_treats_missing_words_as_alive() {
                                    "Data batch rows ({}) != sort batch rows ({}) at index {}",
    fn start_sort_prefetch(&mut self) {
        assert!(is_row_id_alive(None, 100, 99));
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
        ))
            batch,
                    let got = last_live_index_plus_one(Some(bits), num_rows, base, upper);
        }
            &self.nulls_first,
                    reservation.grow(new_bytes - old_sort_bytes);
    }
    #[test]
                capacity,
                // Delta-adjust: new sort batch may differ in size from previous
/// `num_rows` (or beyond the supplied bitset) are treated as alive to match
                sort_batch_schema
        }
                Ok(filter_record_batch(&slice, &mask)?)
            std::sync::mpsc::sync_channel::<Option<MergeResult<RecordBatch>>>(1);
        let batch = self
    #[inline]
    }
            return Ok(false);
    pub fn load_next_batch(&mut self, reservation: &mut MemoryReservation) -> MergeResult<bool> {
                    let want = reference(Some(&bits), num_rows, base, upper);
                        | ArrowDataType::Binary
    }
    sort_batch_index: usize,
            }
            let sort_indices: Vec<usize> = sort_columns
            .fields()
                        self.data_batch = Some(batch);
        while self.data_batch_index <= self.sort_batch_index {
            Ok(Some(Err(e))) => {
        }
    live_bits: Option<&[u64]>,
        reservation.grow(batch_bytes * 2);
        self.sort_batch.as_ref().map_or(0, |b| b.num_rows())
    fn ensure_data_loaded(&mut self, reservation: &mut MemoryReservation) -> MergeResult<()> {
            let num_rows = 256u64;
        } else {
/// `index.parquet.merge_deferred_column_threshold`, default 0 = always deferred),
        match live_bits {
use arrow::compute::filter_record_batch;
        }
    #[test]
        cursor.current_sort_batch_bytes = batch_bytes;
        // Mask off bits above the batch's last row in the top word.
        assert!(is_row_id_alive(Some(&bits), 10, 100));
                                    sb.num_rows(),
            .sort_batch
    let batch_end = base_row_id + batch_upper as u64;
        let file = File::open(path)?;
        if self.current_data_batch_bytes > 0 {
        x ^= x << 17;
            None
            file_id,
    match live_bits {
        if self.current_data_batch_bytes > 0 {
                    "File '{}' (cursor {}) yielded no rows",
            Some(_) => {
            Some(batch) => {
        // Bitset covers 64 rows but the file claims 100; rows >= 64 are alive by contract.
        let bits: Vec<u64> = vec![0u64];
mod is_row_id_alive_tests {
        // Build sort reader (sort-only in deferred, all-columns in eager)
            parquet_schema_descr,
        let builder = ParquetRecordBatchReaderBuilder::try_new(file)?;
        // Data projection: all columns except __row_id__
                self.row_idx = 0;
        assert!(is_row_id_alive(Some(&bits), 128, 64));
                                return Err(MergeError::Logic(format!(
                        ))
    /// Returns `true` if the given absolute source row id is alive.
            end_excl > self.row_idx,
    };
/// as alive (defensive — Java-side contract is that absent bits mean "all alive").
        );
    let bits = match live_bits {
        let bits: Vec<u64> = vec![0u64];
            sort_prefetch_rx,
    }
                let mut i = batch_upper;
    let bitset_rows = (bits.len() as u64).saturating_mul(64);
    fn all_rows_dead_returns_zero() {
        if self.sort_batch.is_none() {
                    .fields()
    #[test]
            abs_row_id,
    #[test]
        }
    }
            if !self.load_next_batch(reservation)? {
                while i > 0 {
        word_idx -= 1;
                    .iter()
use std::sync::{Arc, Mutex};
                    .with_batch_size(batch_size)
            parquet::arrow::ProjectionMask::roots(builder1.parquet_schema(), sort_indices)
                    .with_projection(data_proj)
    use super::last_live_index_plus_one;
/// When `live_bits` is `Some`, dead rows are skipped so `row_idx` always points
            }
            batch.slice(start, len)
                            col, path
                Ok(true)
        }
    }
            &self.max_sort_modes,
///
/// at `base_row_id`. `None` live_bits ⇒ all alive ⇒ returns `batch_upper`. If no row in
        // Decide mode based on schema width
    #[test]
    loop {
        let bits: Vec<u64> = vec![0u64];
            let words = 1 + (next_rand(&mut state) % 5) as usize;
    // If the batch reaches into that region the last row of the batch is alive.
        }
        let mut cursor = Self {
    fn empty_bitmap_returns_alive_for_all() {
        let deferred = schema
    deferred: bool,
#[cfg(test)]
        x
        assert!(is_row_id_alive(Some(&all_alive), 64, 0));
            .ok_or_else(|| MergeError::Logic("Cursor exhausted".into()))?;
    #[test]
            let mut reader = reader.lock().unwrap();
        assert_eq!(last_live_index_plus_one(None, 100, 25, 25), 25);
 *
        live_bits: Option<&[u64]>,
        file_id: usize,
            Some(Ok(b)) if b.num_rows() > 0 => b,
        let mut word = bits[word_idx];
        x ^= x >> 7;
            for &num_rows in &num_rows_options {
/// Returns `true` if `abs_row_id` is alive given the optional `live_bits` packed bitset.
/// the range is alive, returns 0.
                        MergeError::Logic(format!(
        }
                    mask_values.push(self.is_row_id_alive(start_abs + i as u64));
    fn last_row_dead_returns_index_of_previous_alive() {
        let bits: Vec<u64> = vec![0u64, 1u64 << 63];
    current_sort_batch_bytes: usize,
            self.base_row_id,
            let top_bit = (last_row - word_base) as u32; // 0..=63
    /// boolean mask keyed on absolute source row ids. Zero-copy when `live_bits` is `None`.
                                    batch.num_rows(),
            )
                .sort_batch
    num_rows: u64,
                .collect::<Vec<_>>(),
        let (sort_prefetch_tx, sort_prefetch_rx) =
            if low_bit > 0 {
            projected_schema,
                    .build()?,
                0x0F0F_0F0F_0F0F_0F0F,
                // Error path: close reader and release any data_batch memory
                reservation.shrink(self.current_data_batch_bytes);
    }
                        let data_bytes = batch.get_array_memory_size();
            .as_ref()
                for i in 0..len {
        // Projected schema from file metadata
                        self.current_data_batch_bytes = data_bytes;
                .collect();
 * SPDX-License-Identifier: Apache-2.0
    }
            nulls_first: nulls_first.to_vec(),
                self.row_idx += 1;
        let bits: Vec<u64> = vec![0x3FFu64];
    fn reference(
            vec![
        nulls_first: &[bool],
                            if batch.num_rows() != sb.num_rows() {
            None => {
        self.is_row_id_alive(self.base_row_id + self.row_idx as u64)
        last_live_index_plus_one(
        // Skip remaining rows — release data_batch before loading next sort batch
use native_bridge_common::memory_pool::MemoryReservation;
            );
                builder2.parquet_schema(),
            .sort_batch
    }
                            "Sort column '{}' not found in projected batch for file '{}'",
        // 4 words = 256 rows. Try sparse, dense and empty bit patterns.
/// batch's upper edge is masked down to the bits that lie inside the batch; bits at or beyond
                    .fields()
        match sort_result {
        match &self.live_bits {
                    .iter()
            max_sort_modes: max_sort_modes.to_vec(),
            .filter(|f| !sort_col_set.contains(f.name().as_str()))
    batch_upper: usize,
                        bits, num_rows, base, upper
            None => batch_upper,
        let batch = self
        };
///
    fn skip_to_next_live_row(&mut self, reservation: &mut MemoryReservation) -> MergeResult<()> {
    #[test]
                    );
            let batch = self
        let patterns: Vec<Vec<u64>> = vec![
                if self.current_data_batch_bytes > 0 {
                1.max(capacity / 2),
        if !self.load_next_batch(reservation)? {
    }
            self.live_bits.as_deref().map(|v| v.as_slice()),
    pub fn is_row_id_alive(&self, abs_row_id: u64) -> bool {
use super::error::{MergeError, MergeResult};
        &mut self,
            let low_bit = (base_row_id - word_base) as u32; // 0..=63
    /// Returns the sub-batch `[start, start+len)` with dead rows filtered out.
        let builder1 = ParquetRecordBatchReaderBuilder::try_new(file1)?;
                builder1.parquet_schema(),
                for upper in 0..=(256 - base) as usize {
    let mut word_idx = (last_row / 64) as usize;
        let bits: Vec<u64> = vec![!0u64];
                capacity.saturating_sub(7),
pub fn is_row_id_alive(live_bits: Option<&[u64]>, num_rows: u64, abs_row_id: u64) -> bool {
    /// After this, either `row_idx` points at a live row or the cursor is exhausted.
            if self.current_data_batch_bytes > 0 {
            sort_col_indices,
#[cfg(test)]
        self.data_batch = None;
            return;
                Some(Ok(batch)) => {
        let sort_col_types: Vec<ArrowDataType> = sort_columns
            writer_generation,
/// loaded on demand. Otherwise uses a single all-column reader. The sort reader
    }
    }
    fn none_bits_returns_batch_upper() {
                }
    }
            }
                    .position(|f| f.name() == col.as_str())
                    // Skipped batch — discard
    sort_prefetch_tx: std::sync::mpsc::SyncSender<Option<MergeResult<RecordBatch>>>,
    }
        path: &str,
/// One past the highest live-row index within `[0, batch_upper)` for the batch starting
    /// In deferred mode the slice is taken from the on-demand data reader; otherwise
                        // Target batch — validate and keep
                return Ok(());
        *state = x;
/// prefetches the next batch on the shared Rayon pool to overlap IO with merge
                word &= !((1u64 << low_bit) - 1);
            builder.metadata().file_metadata(),
}
                    .find(|f| f.name() == col.as_str())
    let first_word = (base_row_id / 64) as usize;
                Ok(false)
        Ok(true)
            }
    pub sort_col_indices: Vec<usize>,
    fn word_scan_matches_reference_on_random_bitsets() {
            while self.row_idx < n && !self.is_current_row_alive() {
                if new_bytes > old_sort_bytes {
        let sort_result = match self.sort_prefetch_rx.recv() {
                    if self.data_batch_index == self.sort_batch_index {
    /// Returns sort values at the cursor's last live row in the current batch.
            .as_ref()
    fn out_of_bounds_returns_alive_defensively() {
    }
                }
    /// so the caller can build union schemas and row-ID mappings without re-opening the file.
        }
            &self.sort_col_indices,
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 11), 10);
/// highest set bit in the first non-zero word, so a long run of dead rows at the end of a batch
/// at a live row (or the cursor is exhausted).
            current_data_batch_bytes: 0,
                    f.data_type(),
            ];
    num_rows: u64,
        assert!(!is_row_id_alive(Some(&bits), 128, 0));
    #[test]
                    i -= 1;
        }
    ///
        let bits: Vec<u64> = vec![0u64, 1u64];
            .map(|col| {
                            col, path, file_id
                    })
        let bits: Vec<u64> = vec![0u64];
/// computation.
/// Delegates to [`super::live_docs::is_alive_in_words`] for the core bit logic.
            >= deferred_threshold;
use arrow::array::{BooleanArray, RecordBatch};
        if self.row_idx >= self.sort_batch.as_ref().unwrap().num_rows() {
                    reservation.shrink(old_sort_bytes - new_bytes);
        )
                let mask = BooleanArray::from(mask_values);
    }
}
        // bit at abs row 10 alive, all others dead.
        let mut x = *state;
        self.sort_batch = None;
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 16), 5);
                    let idx = i - 1;
                0x5555_5555_5555_5555,
                            self.data_batch_index
                let mut mask_values: Vec<bool> = Vec::with_capacity(len);
                reservation.shrink(old_sort_bytes);
            let capacity = words as u64 * 64;
            row_idx: 0,
    /// Packed live-docs bitset in Lucene `FixedBitSet#getBits()` layout. `None` = all alive.
            self.current_data_batch_bytes = 0;
            let batch = self
    }
                return Ok(());
    fn word_scan_matches_reference_across_word_boundaries() {
    }
}
        assert_eq!(last_live_index_plus_one(Some(&bits), 10, 0, 10), 0);
        }
                .iter()
        let sort_col_indices: Vec<usize> = sort_columns
            .iter()
                reservation.shrink(old_sort_bytes);
            sort_col_types,
/// Scans whole 64-bit words from the tail of the batch and uses `leading_zeros()` to find the
            self.row_idx,
            sort_prefetch_tx,
                0xF0F0_F0F0_F0F0_F0F0,
    fn respects_base_row_id_offset() {
                self.start_sort_prefetch();
                        if let Some(ref sb) = self.sort_batch {
    fn bit_zero_alive_and_dead() {
            }
    }
                    }
        for bits in &patterns {
            None => Ok(slice),
                self.base_row_id += prev_rows;
        let schema = builder.schema().clone();
    }
    /// Opens a Parquet file and creates a cursor positioned at the first live row.
        }
        Ok((
        self.sort_prefetch_pending = false;
        batch_upper: usize,
                    }
            let num_rows_options = [
            self.current_data_batch_bytes = 0;
        // Rows 0..9 alive, row 10 dead.
        self.sort_prefetch_pending = true;
    // Rows at or past num_rows, or past the end of the supplied bitset, are alive by contract.
        live_bits: Option<Arc<Vec<u64>>>,
            return (highest_abs - base_row_id) as usize + 1;
            deferred,
            }
            Some(_) => {
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 10), 0);
            .collect::<MergeResult<_>>()?;
            .data_reader
        let parquet_schema_descr = builder.parquet_schema().clone();
                    let got = last_live_index_plus_one(Some(&bits), num_rows, base, upper);
        let data_projection_indices = projection_indices_excluding_row_id(&schema);
        let mut state = 0x9E37_79B9_7F4A_7C15u64;
        cursor.skip_to_next_live_row(reservation)?;
    #[test]
    }
                matches!(
 * compatible open source license.
    // Absolute row ids covered by this batch: [base_row_id, batch_end).
                _ => None,
    #[test]
/// A cursor over a single sorted Parquet input file.
                        | ArrowDataType::LargeBinary
            })
    pub row_idx: usize,
            vec![!0, !0, !0, !0],
                    ArrowDataType::Utf8
        get_sort_values(
use std::fs::File;
                        got, want,
            reservation.shrink(self.current_data_batch_bytes);
    ) -> MergeResult<(Self, Arc<ArrowSchema>, SchemaDescriptor, i64, usize)> {
        let bits: Vec<u64> = vec![0x1Fu64];
            &self.sort_col_types,
            return Ok(self.sort_batch.is_some());
                    }
                }
        }
        assert!(
        // num_rows=10 — anything >= 10 must come back alive even though all bits are 0.
                self.current_data_batch_bytes = 0;
            .with_batch_size(batch_size)
        let bits: Vec<u64> = vec![0u64];
        Ok(true)
            .with_projection(sort_projection)
    fn rows_past_num_rows_count_as_alive() {
        self.data_batch = None;
                    .ok_or_else(|| {
            })
            match reader.next() {
            for base in 0..256u64 {
    pub fn advance(&mut self, reservation: &mut MemoryReservation) -> MergeResult<bool> {
    }
                        reservation.grow(data_bytes);
                return Ok(false);
                .map(|&i| schema.field(i).clone())
        };
            let highest_abs = word_base + (63 - word.leading_zeros() as u64);
        }
                        return i;
            current_sort_batch_bytes: 0,
    /// Returns `true` if the cursor's current row is alive.
        )
        let mut sort_reader = builder1
            };
            }
            .ok_or_else(|| MergeError::Logic("Cursor exhausted".into()))?;
        if word != 0 {
            return Ok(false);
        // Read first sort batch
        // Open file and read metadata
                    if batch.num_rows() == 0 {
    current_data_batch_bytes: usize,
                    let upper = (next_rand(&mut state) % (limit - base + 1)) as usize;
                }
        let total_row_count = builder.metadata().file_metadata().num_rows() as usize;
                            "Sort column '{}' not found in file '{}' (cursor {})",
                    assert_eq!(got, want, "bits={:?} base={} upper={}", bits, base, upper);
        let sort_batch_schema = first_sort_batch.schema();
            Some(Err(e)) => return Err(e.into()),
        assert!(is_row_id_alive(None, 100, 1_000_000));
                0
                .as_ref()
