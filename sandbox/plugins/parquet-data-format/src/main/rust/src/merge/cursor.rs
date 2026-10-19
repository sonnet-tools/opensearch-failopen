            self.base_row_id,
        Ok(true)
        if !self.deferred {
        sort_columns: &[String],
    pub base_row_id: u64,
        }
                            "Data reader returned empty batch at position {}",
        Ok((
        let schema = builder.schema().clone();
        // Resolve sort column types
    fn reference(
 *
            Some(Ok(b)) if b.num_rows() > 0 => b,
            .map(|col| {
            let top_bit = (last_row - word_base) as u32; // 0..=63
        // Position at the first live row (no-op when live_bits is None).
    // Absolute row ids covered by this batch: [base_row_id, batch_end).
        loop {
use parquet::arrow::arrow_reader::ParquetRecordBatchReaderBuilder;
            })
        self.sort_prefetch_pending = false;
            Ok(()) => Ok(()),
            return Ok(());
    pub fn take_slice(
    }
            vec![1, 0, 0, 1u64 << 63], // rows 0 and 255 alive
            max_sort_modes: max_sort_modes.to_vec(),
            let batch = self
        assert!(is_row_id_alive(None, 100, 0));
            &self.nulls_first,
use arrow::array::{BooleanArray, RecordBatch};
        ))
        Ok(true)
    ) -> MergeResult<RecordBatch> {
        let sort_projection = if deferred {
        if word != 0 {
            self.data_batch = None;
        };
                    if batch.num_rows() == 0 {
    /// Returns the sub-batch `[start, start+len)` with dead rows filtered out.
        let reader = Arc::clone(&self.sort_reader);
    sort_reader: Arc<Mutex<parquet::arrow::arrow_reader::ParquetRecordBatchReader>>,
        let builder = ParquetRecordBatchReaderBuilder::try_new(file)?;
        match live_bits {
        if self.live_bits.is_some() {
    fn bit_zero_alive_and_dead() {
            Some(batch) => {
}
            return 0;
                None => {
                Some(b) => b.num_rows(),
            &self.max_sort_modes,
            .collect::<MergeResult<_>>()?;
        reservation: &mut MemoryReservation,
            let data_proj = parquet::arrow::ProjectionMask::roots(
                    .ok_or_else(|| {
            abs_row_id,
                0xAAAA_AAAA_AAAA_AAAA,
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 16), 5);
            if top_bit < 63 {
        let bits: Vec<u64> = vec![0u64];
                word &= (1u64 << (top_bit + 1)) - 1;
                    .with_projection(data_proj)
    }
            data_projection_indices
    fn try_load_data(&mut self, reservation: &mut MemoryReservation) -> MergeResult<()> {
            vec![
                        | ArrowDataType::LargeBinary
    }
        }
    fn word_scan_matches_reference_across_word_boundaries() {
            sort_columns.iter().map(|s| s.as_str()).collect();
        )
                    .build()?,
            .as_mut()
// ---------------------------------------------------------------------------
        assert!(is_row_id_alive(Some(&bits), 128, 127));
    }
                }
mod last_live_index_plus_one_tests {
                None => return Ok(()),
    loop {
            .sort_batch
        // Skip remaining rows — release data_batch before loading next sort batch
    fn bit_at_word_boundary_63() {
                Err(e)
        // Build data reader (only in deferred mode)
        // Release previous data_batch — about to load a new one
    }
use arrow::compute::filter_record_batch;
        });
            parquet::arrow::ProjectionMask::roots(
        let mut state = 0x9E37_79B9_7F4A_7C15u64;
        reservation: &mut MemoryReservation,
impl FileCursor {
            file_id,
        if self.live_bits.is_some() {
            base_row_id: 0,
            None => batch_upper,
            let num_rows_options = [
            }
        // Release data batch tracking — previous data_batch is dropped
        assert!(!is_row_id_alive(Some(&bits), 128, 63));
    let last_row = batch_end - 1;
        num_rows: u64,
    match live_bits {
                0x5555_5555_5555_5555,
        start: usize,
            .sort_batch
            &self.sort_col_types,
                self.row_idx += 1;
                Ok(false)
    live_bits: Option<&[u64]>,
                data_projection_indices.clone(),
        assert!(!is_row_id_alive(Some(&row_zero_dead), 64, 0));
                    }
    sort_batch_index: usize,
        let (sort_prefetch_tx, sort_prefetch_rx) =
            batch.slice(start, len)
        )
    /// Opens a Parquet file and creates a cursor positioned at the first live row.
        assert_eq!(last_live_index_plus_one(Some(&bits), 100, 60, 10), 10);
        // Build sort reader (sort-only in deferred, all-columns in eager)
pub fn last_live_index_plus_one(
                    assert_eq!(
                return Ok(());
                return Ok(());
                    .fields()
use super::error::{MergeError, MergeResult};
/// computation.
    }
    current_sort_batch_bytes: usize,
        Some(bits) => super::live_docs::is_alive_in_words(bits, num_rows, abs_row_id),
        let mut word = bits[word_idx];
    /// Total source rows. Bits at indices `>= num_rows` are ignored.
        };
                        | ArrowDataType::LargeUtf8
            .ok_or_else(|| MergeError::Logic("Cursor exhausted".into()))?;
                    "File '{}' (cursor {}) yielded no rows",
        }
    pub fn advance_past_batch(&mut self, reservation: &mut MemoryReservation) -> MergeResult<bool> {
        // Open file and read metadata
            if !self.load_next_batch(reservation)? {
            ];
/// A cursor over a single sorted Parquet input file.
                    .ok_or_else(|| {
                capacity + 40,
                        self.data_batch_index, self.sort_batch_index
            self.row_idx,
                .as_ref()
                0xF0F0_F0F0_F0F0_F0F0,
    /// The original one-bit-at-a-time implementation, kept as the oracle for the word-scan.
    }
    }
            vec![0, 0, 1, 0],          // only abs row 128 alive
    }
}
    fn word_scan_matches_reference_on_random_bitsets() {
    data_batch: Option<RecordBatch>,
            self.num_rows,
                sort_batch_schema
                builder1.parquet_schema(),
            }
                            col, path
        let parquet_schema_descr = builder.parquet_schema().clone();
        is_row_id_alive(
        // Rows 0..4 alive, rows 5..15 dead.
    #[test]
                    })
        let bits: Vec<u64> = vec![1u64 << 63];
                    mask_values.push(self.is_row_id_alive(start_abs + i as u64));
            let n = match self.sort_batch.as_ref() {
            // Batch boundary crossed — release data_batch before loading next sort batch
    }
                            if batch.num_rows() != sb.num_rows() {
                }
            .fields()
                                    batch.num_rows(),
    }
        if self.data_batch.is_some() && self.data_batch_index == self.sort_batch_index + 1 {
        Some(bits) => bits,
                        got, want,
        assert_eq!(last_live_index_plus_one(None, 100, 25, 25), 25);
            let batch = self
            return Ok(false);
            reservation.shrink(self.current_data_batch_bytes);
        // Read first sort batch
    pub fn is_row_id_alive(&self, abs_row_id: u64) -> bool {
                // Advance the absolute source row-id offset past the batch we just dropped.
            Some(_) => {
    #[test]
            let bits: Vec<u64> = (0..words).map(|_| next_rand(&mut state)).collect();
                }
    deferred: bool,
            end_excl > self.row_idx,
            }
        self.row_idx += 1;
                r
            // num_rows sometimes shorter than the bitset, sometimes exactly full, sometimes longer.
        let bits: Vec<u64> = vec![1u64 << 10];
    #[inline]
            .sort_batch
            .filter(|f| {
        // Decide mode based on schema width
        deferred_threshold: usize,
        }
                    if self.data_batch_index == self.sort_batch_index {
            .iter()
) -> usize {
                self.current_sort_batch_bytes = 0;
    }
            let num_rows = 256u64;
        cursor.skip_to_next_live_row(reservation)?;
    }
                return Ok(false);
        live_bits: Option<&[u64]>,
            Some(
    fn all_rows_dead_returns_zero() {
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 0), 0);
                    let idx = i - 1;
        if self.sort_batch.is_none() {
            );
    }
    live_bits: Option<Arc<Vec<u64>>>,
        &mut self,
            reservation.shrink(self.current_data_batch_bytes);
                    reservation.shrink(old_sort_bytes - new_bytes);
            sort_batch_index: 0,
///
        // Resolve sort column indices within the sort batch schema
                }
    base_row_id: u64,
        }
///
        assert_eq!(last_live_index_plus_one(Some(&bits), 100, 0, 64), 0);
        assert_eq!(last_live_index_plus_one(Some(&bits), 10, 0, 10), 0);
            data_reader,
                            self.data_batch_index
    }
        }
        x ^= x << 17;
            .filter(|f| f.name() != super::schema::ROW_ID_COLUMN_NAME)
        let bits: Vec<u64> = vec![0u64, 1u64 << 63];
            live_bits,
            sort_prefetch_rx,
        let bits: Vec<u64> = vec![0u64, 1u64];
/// Scans whole 64-bit words from the tail of the batch and uses `leading_zeros()` to find the
            reservation.shrink(self.current_data_batch_bytes);
        // Mask off bits above the batch's last row in the top word.
                    // Skipped batch — discard
 * compatible open source license.
                self.start_sort_prefetch();
                // Error: release sort batch tracking since cursor is now exhausted
        assert!(is_row_id_alive(Some(&bits), 128, 64));
    let bitset_rows = (bits.len() as u64).saturating_mul(64);
                        self.data_batch = Some(batch);
            _ => {
            Ok(None) | Err(_) => None,
    }
                    ArrowDataType::Utf8
                    let got = last_live_index_plus_one(Some(&bits), num_rows, base, upper);
        if !self.load_next_batch(reservation)? {
        assert!(!is_row_id_alive(Some(&bits), 128, 65));
    fn rows_past_bitset_length_count_as_alive() {
            sort_col_indices,
            .collect::<MergeResult<_>>()?;
        *state = x;
                                    "Data batch rows ({}) != sort batch rows ({}) at index {}",
        // Mask off bits below the batch's first row in the bottom word.
            }
        let sort_col_types: Vec<ArrowDataType> = sort_columns
    /// Returns sort values at the cursor's last live row in the current batch.
    pub sort_batch: Option<RecordBatch>,
        let bits: Vec<u64> = vec![0u64];
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 10), 0);
                // Delta-adjust: new sort batch may differ in size from previous
        if word_idx == (last_row / 64) as usize {
            Some(Err(e)) => return Err(e.into()),
        let mut x = *state;
    let bits = match live_bits {
            match reader.next() {
    #[test]
    }
        file_id: usize,
        if self.current_data_batch_bytes > 0 {
            file_id,
            self.skip_to_next_live_row(reservation)?;
            writer_generation,
            vec![0, 1u64 << 63, 0, 0], // only abs row 127 alive
        let sort_col_indices: Vec<usize> = sort_columns
            }
#[inline]
        let patterns: Vec<Vec<u64>> = vec![
        assert!(
                        self.current_data_batch_bytes = data_bytes;
                return Err(e);
    /// Source row-id offset at the start of the current sort batch.
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 10), 10);
                Some(Err(e)) => return Err(e.into()),
            sort_reader,
        let data_reader = if deferred {
        let builder1 = ParquetRecordBatchReaderBuilder::try_new(file1)?;
                self.sort_batch = Some(batch);
}
    #[inline]
        let sort_batch_schema = first_sort_batch.schema();
        let first_sort_batch = match sort_reader.next() {
                self.base_row_id += prev_rows;
                self.current_sort_batch_bytes = 0;
        };
    fn none_bits_returns_true_for_any_row() {
    fn all_rows_alive_returns_batch_upper() {
    /// One past the highest live-row index within `[0, batch_upper)`.
    num_rows: u64,
            batch_upper,
/// Delegates to [`super::live_docs::is_alive_in_words`] for the core bit logic.
        self.data_batch = None;
    #[inline]
}
        let slice = if self.deferred {
/// One past the highest live-row index within `[0, batch_upper)` for the batch starting
    }
                    );
    #[test]
        } else {
                    i -= 1;
            .as_ref()
    pub file_id: usize,
        assert!(is_row_id_alive(Some(&bits), 10, 100));
            let _ = tx.send(result);
                .collect();
        get_sort_values(
        assert!(is_row_id_alive(Some(&bits), 64, 63));
                .collect::<Vec<_>>(),
        for r in 0..63 {
/// highest set bit in the first non-zero word, so a long run of dead rows at the end of a batch
        }
            let mut reader = reader.lock().unwrap();
        let bits: Vec<u64> = vec![!0u64];
    }
                builder2.parquet_schema(),
/// batch's upper edge is masked down to the bits that lie inside the batch; bits at or beyond
                    }
    }
                0
use native_bridge_common::memory_pool::MemoryReservation;
                        "Data reader exhausted at position {}, needed sort_batch_index={}",
            &self.max_sort_modes,
}
        x
                .map(|&i| schema.field(i).clone())
            nulls_first: nulls_first.to_vec(),
            vec![!0, !0, !0, !0],
use arrow::datatypes::{DataType as ArrowDataType, Schema as ArrowSchema};
                Some(Err(e)) => Some(Err(MergeError::Arrow(e))),
                }
            .build()?;
        }
    pub fn load_next_batch(&mut self, reservation: &mut MemoryReservation) -> MergeResult<bool> {
    pub row_idx: usize,
            projected_schema,
        batch_upper: usize,
        self.sort_prefetch_pending = true;
        let deferred = schema
                self.row_idx = 0;
    #[test]
            )
        let end_excl = self.last_live_index_plus_one(batch.num_rows());
        // Bitmap covers only 64 bits, but num_rows says 128.
            if !self.load_next_batch(reservation)? {
                data_projection_indices.clone(),
    #[inline]
        if self.sort_prefetch_pending {
            deferred,
            return Ok(());
/// prefetches the next batch on the shared Rayon pool to overlap IO with merge
                !is_row_id_alive(Some(&bits), 64, r),
    }
        }
        let batch = self
            return (highest_abs - base_row_id) as usize + 1;
        assert!(is_row_id_alive(Some(&bits), 0, 0));
        if word_idx == first_word {
                        | ArrowDataType::Binary
    fn empty_bitmap_returns_alive_for_all() {
            }
        base_row_id: u64,
            .map(|b| b.num_rows() as u64)
        }
    #[test]
    use super::is_row_id_alive;
            }
    #[test]
            self.current_data_batch_bytes = 0;
            "last_sort_values called on cursor with no live row"
                if self.current_data_batch_bytes > 0 {
        assert!(is_row_id_alive(Some(&bits), 10, 10));
/// When `live_bits` is `Some`, dead rows are skipped so `row_idx` always points
        Ok(())
        let sort_reader = Arc::new(Mutex::new(sort_reader));
        assert!(is_row_id_alive(Some(&bits), 128, 64));
            .iter()
            };
        // Data projection: all columns except __row_id__
            }
                _ => None,
            }
                    let want = reference(Some(bits), num_rows, base, upper);
        )
            vec![0, 0, 0, 0],
        // 4 words = 256 rows. Try sparse, dense and empty bit patterns.
        self.sort_batch.as_ref().map_or(0, |b| b.num_rows())
            }
                            "Sort column '{}' not found in projected batch for file '{}'",
            let result = match reader.next() {
                    .map(|f| f.data_type().clone())
    }
    data_reader: Option<parquet::arrow::arrow_reader::ParquetRecordBatchReader>,
                for upper in 0..=(256 - base) as usize {
                    self.current_data_batch_bytes = 0;
    #[test]
    }
    #[test]
            self.live_bits.as_deref().map(|v| v.as_slice()),
#[inline]
    if batch_end > num_rows || batch_end > bitset_rows {
    /// from the sort batch. When `live_bits` is `Some`, dead rows are removed via a
        cursor.current_sort_batch_bytes = batch_bytes;
        cursor.start_sort_prefetch();
/// the range is alive, returns 0.
        let data_projection_indices = projection_indices_excluding_row_id(&schema);
            };
            let highest_abs = word_base + (63 - word.leading_zeros() as u64);
            parquet::arrow::ProjectionMask::roots(builder1.parquet_schema(), sort_indices)
        let bits: Vec<u64> = vec![0u64];
            Ok(Some(Err(e))) => {
                )))
        }
    fn trailing_dead_rows_skipped() {
    // If the batch reaches into that region the last row of the batch is alive.
 * SPDX-License-Identifier: Apache-2.0
            .ok_or_else(|| MergeError::Logic("Data reader already closed".into()))?;
        // Projected schema from file metadata
        if word_idx == first_word {
                        bits, num_rows, base, upper
        let row_zero_dead: Vec<u64> = vec![!0u64 & !1u64];
        }
            Err(e) => {
    /// In deferred mode the slice is taken from the on-demand data reader; otherwise
        match sort_result {
                    })
        // Track sort batch + prefetch (estimate 2x first batch)
            &self.sort_col_indices,
            let file2 = File::open(path)?;
    }
    /// so the caller can build union schemas and row-ID mappings without re-opening the file.
            let sort_indices: Vec<usize> = sort_columns
            }
        let bits: Vec<u64> = vec![];
        }
    sort_prefetch_pending: bool,
                        MergeError::Logic(format!(
                self.data_reader = None;
        if self.current_data_batch_bytes > 0 {
        max_sort_modes: &[bool],
            return;
    let first_word = (base_row_id / 64) as usize;
    fn short_bitmap_treats_missing_words_as_alive() {
                }
    #[test]
                    let base = next_rand(&mut state) % limit;
        let sort_result = match self.sort_prefetch_rx.recv() {
        word_idx -= 1;
            total_row_count,
                        reservation.grow(data_bytes);
                if new_bytes > old_sort_bytes {
            self.current_data_batch_bytes = 0;
        get_merge_pool(None).spawn(move || {
                capacity,
            })
    ///
                        // Target batch — validate and keep
            .map(|col| {
                reservation.shrink(self.current_data_batch_bytes);
                        return i;
        assert!(is_row_id_alive(None, 100, 99));
        assert!(is_row_id_alive(None, 100, 1_000_000));
        None => return batch_upper,
        path: &str,
                    reservation.grow(new_bytes - old_sort_bytes);
            })
            .as_ref()
    /// Advances `row_idx` past dead rows, loading successor batches as needed.
        match self.try_load_data(reservation) {
            }
                    let want = reference(Some(&bits), num_rows, base, upper);
        assert!(is_row_id_alive(Some(&bits), 100, 0));
            .iter()
    #[test]
        }
/// as alive (defensive — Java-side contract is that absent bits mean "all alive").
        // Row 64 lives in word 1, which is missing.
    }
                self.sort_batch_index += 1;
        self.data_batch = None;
        let old_sort_bytes = self.current_sort_batch_bytes;
                    .fields()
                while i > 0 {
        let file1 = File::open(path)?;
                matches!(
#[cfg(test)]
            self.live_bits.as_deref().map(|v| v.as_slice()),
/// at `base_row_id`. `None` live_bits ⇒ all alive ⇒ returns `batch_upper`. If no row in
                    path, file_id
        ));
        }
    /// Returns `true` if the cursor's current row is alive.
            let capacity = words as u64 * 64;
use std::sync::{Arc, Mutex};
                        )));
        self.is_row_id_alive(self.base_row_id + self.row_idx as u64)
    fn empty_batch_returns_zero() {
                .as_ref()
    /// `live_bits` is an optional packed bitset of live rows (Lucene layout).
    // Rows at or past num_rows, or past the end of the supplied bitset, are alive by contract.
        self.sort_batch = None;
            cursor,
        let sort_col_set: std::collections::HashSet<&str> =
                    .iter()
        nulls_first: &[bool],
            for &num_rows in &num_rows_options {
                    return Err(MergeError::Logic(format!(
    fn skip_to_next_live_row(&mut self, reservation: &mut MemoryReservation) -> MergeResult<()> {
use std::fs::File;
    sort_prefetch_rx: std::sync::mpsc::Receiver<Option<MergeResult<RecordBatch>>>,
 * The OpenSearch Contributors require contributions made to
        // Rows 0..9 alive, row 10 dead.
            sort_prefetch_tx,
    }
                .ok_or_else(|| MergeError::Logic("Data batch not loaded".into()))?;
    /// Packed live-docs bitset in Lucene `FixedBitSet#getBits()` layout. `None` = all alive.
/// `None` ⇒ all alive; rows beyond `num_rows` or beyond the bitset's length are treated
                        if let Some(ref sb) = self.sort_batch {
        let all_alive: Vec<u64> = vec![!0u64];
                        }
    num_rows: u64,
            }
        self.data_batch = None;
            &self.sort_col_indices,
mod is_row_id_alive_tests {
        let bits: Vec<u64> = vec![0x1Fu64];
    pub fn current_sort_values(&self) -> MergeResult<Vec<SortKey>> {
                let mut mask_values: Vec<bool> = Vec::with_capacity(len);
                let mask = BooleanArray::from(mask_values);
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 0, 11), 10);
            let low_bit = (base_row_id - word_base) as u32; // 0..=63
    ) -> usize {
            let builder2 = ParquetRecordBatchReaderBuilder::try_new(file2)?;
            if low_bit > 0 {
        get_sort_values(
            return Ok(());
        live_bits: Option<Arc<Vec<u64>>>,
        let mut cursor = Self {
            Some(_) => {
/// Returns `true` if `abs_row_id` is alive given the optional `live_bits` packed bitset.
    }
                    )))
        } else {
            data_batch: None,
                0x0F0F_0F0F_0F0F_0F0F,
    }
            data_batch_index: 0,
                    }
        let bits: Vec<u64> = vec![0u64];
            sort_col_types,
        let batch_bytes = cursor.sort_batch.as_ref().unwrap().get_array_memory_size();
            builder.metadata().file_metadata(),
use super::schema::projection_indices_excluding_row_id;
                    let upper = (next_rand(&mut state) % (limit - base + 1)) as usize;
                    if super::is_row_id_alive(live_bits, num_rows, base_row_id + idx as u64) {
        }
    pub fn new(
        }
                for _ in 0..40 {
    #[test]
                                    sb.num_rows(),
                builder2
        }
    fn respects_base_row_id_offset() {
                for i in 0..len {
            if self.row_idx < n {
            .as_ref()
            }
                Ok(true)
            self.current_data_batch_bytes = 0;
        assert!(is_row_id_alive(Some(&all_alive), 64, 0));
                1.max(capacity / 2),
        let bits: Vec<u64> = vec![0u64];
    fn rows_past_num_rows_count_as_alive() {
    batch_upper: usize,
                        "bits={:?} num_rows={} base={} upper={}",
            self.ensure_data_loaded(reservation)?;
            batch.slice(start, len)
                capacity.saturating_sub(7),
    fn next_rand(state: &mut u64) -> u64 {
        let file = File::open(path)?;
        // num_rows=10 but bitset says everything is dead; rows >= 10 are alive by contract.
    }
    current_data_batch_bytes: usize,
            self.skip_to_next_live_row(reservation)?;
                // Error path: close reader and release any data_batch memory
    fn start_sort_prefetch(&mut self) {
 * this file be licensed under the Apache-2.0 license or a
        );
        assert!(!is_row_id_alive(Some(&bits), 128, 0));
                schema
    pub sort_col_types: Vec<ArrowDataType>,
    pub sort_col_indices: Vec<usize>,
            return Ok(false);
                )
                    self.data_batch_index += 1;
        );
            row_idx: 0,
use parquet::schema::types::SchemaDescriptor;
                .filter_map(|c| schema.fields().iter().position(|f| f.name() == c.as_str()))
        let projected_schema = Arc::new(ArrowSchema::new(
    }
pub struct FileCursor {
use super::heap::{get_sort_values, SortKey};
            self.sort_batch = None;
                Some(Ok(batch)) => {
            .with_batch_size(batch_size)
    }
    /// Returns `(cursor, projected_arrow_schema, parquet_schema_descriptor, writer_generation, total_row_count)`
    let mut word_idx = (last_row / 64) as usize;
    #[inline]
        // Cursor is at base_row_id=5, asking about a 10-row batch ⇒ checks abs rows 5..14.
            .ok_or_else(|| MergeError::Logic("Cursor exhausted".into()))?;
                        let data_bytes = batch.get_array_memory_size();
                return Err(MergeError::Logic(format!(
pub fn is_row_id_alive(live_bits: Option<&[u64]>, num_rows: u64, abs_row_id: u64) -> bool {
        // Row 0 is in word 0 and explicitly dead.
        }
            sort_batch: Some(first_sort_batch),
///
                let mut i = batch_upper;
                    .find(|f| f.name() == col.as_str())
        } else {
                    f.data_type(),
    }
        if self.row_idx >= self.sort_batch.as_ref().unwrap().num_rows() {
        while self.data_batch_index <= self.sort_batch_index {
        last_live_index_plus_one(
 */
    fn bit_crosses_word_boundary_64() {
            std::sync::mpsc::sync_channel::<Option<MergeResult<RecordBatch>>>(1);
    }
        assert!(!is_row_id_alive(Some(&bits), 128, 126));
            return Ok(self.sort_batch.is_some());
            );
            batch,
                        ))
        for bits in &patterns {
    }
        let bits: Vec<u64> = vec![0x3FFu64];
            sort_prefetch_pending: false,
            assert!(
        let prev_rows = self
    }
    };
    #[test]
            &self.sort_col_types,
                    assert_eq!(got, want, "bits={:?} base={} upper={}", bits, base, upper);
                    .with_batch_size(batch_size)
    fn out_of_bounds_returns_alive_defensively() {
                let new_bytes = batch.get_array_memory_size();
            .unwrap_or(0);
        // bit at abs row 10 alive, all others dead.
    ) -> MergeResult<(Self, Arc<ArrowSchema>, SchemaDescriptor, i64, usize)> {
    fn is_current_row_alive(&self) -> bool {
// ---------------------------------------------------------------------------
        assert_eq!(last_live_index_plus_one(Some(&bits), 64, 5, 10), 6);
        let bits: Vec<u64> = vec![!0u64];
/// costs one word read per 64 rows rather than one bit test per row. The word straddling the
/// uses two readers: a sort-only reader for the merge heap and a data reader
/// [`is_row_id_alive`].
    /// After this, either `row_idx` points at a live row or the cursor is exhausted.
                        MergeError::Logic(format!(
        return batch_upper;
            batch,
                self.current_sort_batch_bytes = new_bytes;
                .iter()
            while self.row_idx < n && !self.is_current_row_alive() {
    #[test]
        }
        if self.live_bits.is_none() {
    let batch_end = base_row_id + batch_upper as u64;
        };
                let start_abs = self.base_row_id + start as u64;
#[cfg(test)]
        }
        };
            None
                Some(Ok(batch)) if batch.num_rows() > 0 => Some(Ok(batch)),
        let total_row_count = builder.metadata().file_metadata().num_rows() as usize;
        }
        }
        return 0;
    fn bit_at_word_boundary_127() {
            }
    }
                reservation.shrink(old_sort_bytes);
    use super::last_live_index_plus_one;
    fn last_row_dead_returns_index_of_previous_alive() {
    pub nulls_first: Vec<bool>,
                                )));
        }
            for base in 0..256u64 {
    /// Returns `true` if the given absolute source row id is alive.
                .iter()
    pub fn advance(&mut self, reservation: &mut MemoryReservation) -> MergeResult<bool> {
                } else if new_bytes < old_sort_bytes {
        match &self.live_bits {
                .sort_batch
    fn none_bits_returns_batch_upper() {
                                    self.sort_batch_index
// Tests
                reservation.shrink(old_sort_bytes);
            if self.current_data_batch_bytes > 0 {
            current_sort_batch_bytes: 0,
/// When deferred mode is active (controlled by the dynamic index setting
        ];
/// at a live row (or the cursor is exhausted).
                                return Err(MergeError::Logic(format!(
            ],
                }
/*
        assert!(is_row_id_alive(None, 0, 0));
/// `index.parquet.merge_deferred_column_threshold`, default 0 = always deferred),
                    let limit = capacity + 64; // deliberately probe beyond the bitset
            None => {
                    .iter()
            Ok(Some(Ok(batch))) => Some(batch),
        x ^= x >> 7;
    ///
        len: usize,
    #[test]
    data_batch_index: usize,
    #[test]
/// loaded on demand. Otherwise uses a single all-column reader. The sort reader
            let words = 1 + (next_rand(&mut state) % 5) as usize;
            end_excl - 1,
                self.data_reader = None;
        }
            }
                .ok_or_else(|| MergeError::Logic("Batch is None".into()))?;
        let mut sort_reader = builder1
        // num_rows=10 — anything >= 10 must come back alive even though all bits are 0.
            &self.nulls_first,
    /// Deterministic xorshift so the sweep is reproducible without a dev-dependency.
        let writer_generation = crate::writer_properties_builder::read_writer_generation(
    if batch_upper == 0 {
        let reader = self
                    .position(|f| f.name() == col.as_str())
                }
        let tx = self.sort_prefetch_tx.clone();
    pub fn batch_height(&self) -> usize {
                // Cursor exhausted — release all sort batch tracking
                .data_batch
                        // Track full-column data batch — already allocated by data_reader.next()
            current_data_batch_bytes: 0,
            .data_reader
/// `num_rows` (or beyond the supplied bitset) are treated as alive to match
            .count()
            self.num_rows,
            )
        for _ in 0..200 {
    fn ensure_data_loaded(&mut self, reservation: &mut MemoryReservation) -> MergeResult<()> {
            parquet_schema_descr,
                        ))
    }
///
                word &= !((1u64 << low_bit) - 1);
}
    }
    pub max_sort_modes: Vec<bool>,
use super::io_task::get_merge_pool;
    sort_prefetch_tx: std::sync::mpsc::SyncSender<Option<MergeResult<RecordBatch>>>,
        let word_base = (word_idx as u64) * 64;
            >= deferred_threshold;
                self.sort_prefetch_pending = false;
            None => Ok(slice),
    }
    }
        reservation.grow(batch_bytes * 2);
            return Ok(self.sort_batch.is_some());
            num_rows: total_row_count as u64,
        None => true,
    #[test]
        };
    /// boolean mask keyed on absolute source row ids. Zero-copy when `live_bits` is `None`.
                    let got = last_live_index_plus_one(Some(bits), num_rows, base, upper);
                        return Err(MergeError::Logic(format!(
        batch_size: usize,
                            "Sort column '{}' not found in file '{}' (cursor {})",
    #[test]
                    reservation.shrink(self.current_data_batch_bytes);
                "row {} should be dead",
        )
    fn last_live_index_plus_one(&self, batch_upper: usize) -> usize {
        assert_eq!(last_live_index_plus_one(Some(&bits), 10, 0, 12), 12);
        assert_eq!(last_live_index_plus_one(None, 100, 0, 50), 50);
    pub fn last_sort_values(&self) -> MergeResult<Vec<SortKey>> {
            }
        let batch = self
        if self.current_data_batch_bytes > 0 {
            .with_projection(sort_projection)
            .filter(|f| !sort_col_set.contains(f.name().as_str()))
        x ^= x << 13;
        self.sort_batch = None;
                            }
                Ok(filter_record_batch(&slice, &mask)?)
        // Bitset covers 64 rows but the file claims 100; rows >= 64 are alive by contract.
                self.current_data_batch_bytes = 0;
    #[test]
        // Last alive in that range is abs 10 (= local idx 5 in this batch). Result is 5+1=6.
                            col, path, file_id
