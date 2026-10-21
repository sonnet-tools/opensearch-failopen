}
        assert_eq!(
    #[test]
                }
//!
/// Used when a caller receives a `RowSelection` (e.g. from page pruning)
}
pub fn build_row_selection_with_min_skip_run(
/// Storage is chosen per regime to stay cheap at 1M-row RGs:
/// contiguously. Post-decode masks need this map to know which RG
        // Candidates {0, 3, 7} on a 10-row RG with min_skip_run=4:
        // `select` runs. The mask length = delivered_count and each bit at
    let mut raw: Vec<RowSelector> = Vec::new();
        assert_eq!(pm.delivered_count(), 6);
    }
        // Row-granular regime: candidates drive both RowSelection and
        // candidate bitmap as a packed BooleanArray in one shot;
    }
        assert_eq!(pm.rg_position(2), Some(7));
        // Identity → delivered_idx == rg_position. Materialise the
        // delivered row is by construction a candidate, so the mask is
                }
        // Second block: delivered [2,3,4] → RG [7,8,9] (2 selected + 5 skipped = 7).
        assert_eq!(m.true_count(), 16);
/// given the `RowSelection` we handed it.
        // Third block: delivered [5] → RG [11] (7+3 selected + 1 skipped = 11).
        let m = build_mask(&candidates, &pm);
                    let delivered_idx = delivered_start + (b as usize - rg_start);
///   `>= min_skip_run`; `select` runs absorb tiny gaps.
        let got: Vec<bool> = (0..m.len()).map(|i| m.value(i)).collect();
    /// Build the cheapest `PositionMap` for a (candidates, selection) pair.
                let rg_end_u32 = (rg_start + run_len).min(u32::MAX as usize) as u32;
            let delivered_count = candidates.len() as usize;
            }
}
        let pm = PositionMap::from_selection(&sel);
        let mut runs = Vec::new();
        //
        // With a block-granular selection, parquet delivers only rows from
                (true, 2),  // skip rows 1,2
        } => {
    }
    fn min_skip_run_preserves_big_gaps() {
/// position that row `i` came from. Under the old full-scan strategy,
    }
            }
            selectors(&sel),
            RowSelector::skip(3),
impl PositionMap {
                // Walk the candidate set bits that fall in this run's
//! 1. A parquet [`RowSelection`] (`build_row_selection_with_min_skip_run`)
        // memcpy-speed, O(set_bits + len/64).
        assert_eq!(m.len(), 5);
    }
pub enum PositionMap {
        let run_len = (run_end - start + 1) as usize;
    }
            }
            RowSelector::skip(2),
            RowSelector::select(2),
        /// Sorted ascending on `start_delivered_idx`.
    use super::*;
    for s in input {
        pos = run_end + 1;
                if delivered_idx < *delivered_count {
            b.insert(v);
        assert_eq!(m.len(), 8);
        let sel = RowSelection::from(vec![
    /// Build a Runs-backed map from an arbitrary `RowSelection`. Used only
//! 3. A delivered-row [`BooleanArray`] mask (`build_mask`) aligned to the
            }
///
        assert_eq!(pm.rg_position(4), Some(9));
    fn build_mask_empty_candidates_produces_all_false() {
                }
                    // Previous was skip or nothing; promote this run to select.
    fn build_mask_dense_candidates_covers_every_position() {
        }
    // First pass: emit row-granular (select_run, skip_run) pairs by walking
//! Row-selection utilities for the indexed streaming path.
        if b >= len {
        ]);
            return Self::Bitmap {
        let mut bits = RoaringBitmap::new();
        if (start as usize) >= rg_num_rows {
        //     so skip(3) is absorbed → select(4) + select(1) merged into select(8) [rows 0..8]
                }
        }
    }
use roaring::RoaringBitmap;
    let mut out: Vec<RowSelector> = Vec::with_capacity(input.len());
    if rg_num_rows == 0 {
        }
        // Runs variant would still be correct but Identity skips the
        // hands to parquet), but we pass min_skip_run = 1 so PositionMap
    pub fn delivered_count(&self) -> usize {
                None
        let candidates = bm(&[2, 9, 100]);
            // Absorb into the trailing select (or become one if nothing yet).
    fn min_skip_run_ignores_out_of_range_bits() {
        // First block: delivered [0,1] → RG [0,1].
    Runs {
    fn bm(values: &[u32]) -> RoaringBitmap {
        let pm = PositionMap::from_selection(&sel);
        let sel = RowSelection::from(vec![RowSelector::select(1_000_000)]);
        } else {
            runs,
/// lookup is a single `(words[i >> 6] >> (i & 63)) & 1` operation.
        // Everything got absorbed into one big select.
    candidates: &RoaringBitmap,
        }
    // rg_num_rows + 1). This keeps the legacy behaviour under test.
///
                // the corresponding bit.
/// "gap" (consecutive non-set bits) shorter than `min_skip_run` as NOT worth
    #[test]
        let candidates = RoaringBitmap::new();
        //     then another select(1) for row 7 — separated by skip(3) which is < 4
    fn selectors(sel: &RowSelection) -> Vec<(bool, usize)> {
            RowSelector::select(4),
    Identity {
        let candidates = Arc::new(bits);
    let mut out = RoaringBitmap::new();
    }
        let sel = RowSelection::from(vec![
        assert_eq!(pm.delivered_count(), 4);
        );
        let pm = PositionMap::from_selection(&sel);
    }
        assert_eq!(pm.rg_position(0), None);
        //   rg_pos     0 1 2 5 6
            packed_bits_to_boolean_array(out, n)
    #[test]
//! module produces:
        Self::Runs {
/// `RowSelection`, in order) to its RG-relative row position. Built from
        PositionMap::from_selection(&sel)
        bits: Arc<RoaringBitmap>,
                    out.push(RowSelector::select(s.row_count));
                Some(last) if !last.skip => {
    // RoaringBitmap.iter() yields set bits in ascending order.
    /// Translate a delivered row index to its RG-relative position.
            } => {
        assert_eq!(pm.rg_position(0), Some(0));
}
        assert_eq!(pm.rg_position(4), None);
    out
/// `from_vec` — zero-copy. Bit layout matches Arrow's native LSB-first
/// bit per `select`ed row. `skip` runs contribute nothing.
/// Under [`build_row_selection_with_min_skip_run`]'s "absorb short skips"
            Self::Runs {
        assert_eq!(pm.rg_position(1_000_000), None);
        // Bitmap → delivered rows are exactly the candidate set bits. Every
                    }
                // ascending order — O(set_bits_in_range).
        }
    Bitmap {
        return RowSelection::from(Vec::<RowSelector>::new());
                    last.row_count += s.row_count;
        raw.push(RowSelector::select(run_len));
///   in some bitmap). The i-th delivered row is the i-th set bit via
    }
                    last.row_count += s.row_count;
    use datafusion::arrow::array::Array;
    }
            delivered_count, ..
        assert_eq!(pm.rg_position(3), Some(8));
                iter.next();
/// `len`. The `Vec<u64>` is consumed and wrapped as an Arrow `Buffer` via
        let got: Vec<bool> = (0..m.len()).map(|i| m.value(i)).collect();
        // All positions in candidates → all-true mask.
    if candidates.is_empty() {
        let candidates: RoaringBitmap = (0u32..16).collect();
        }
            Self::Bitmap {
            break;
/// RG-relative positions for post-decode mask alignment.
                for &(rg_start, del_start, len) in runs {
    ///   bit of `candidates`. Wrap the bitmap in `Arc` and use
        // output buffer. Each run maps a contiguous rg-position range to a
        // all-true.
    while let Some(&start) = iter.peek() {
        let pm = PositionMap::from_selection(&sel);
                (true, 3),  // skip rows 4,5,6
        assert_eq!(selectors(&sel), vec![(false, 10)]);
        let sel = build_row_selection_with_min_skip_run(&bm(&[0, 3, 7]), 10, 1);
    let words = len.div_ceil(64) as usize;
            let mut out = vec![0u64; words];
        let sel = build_row_selection_with_min_skip_run(&bm(&[0, 7]), 10, 1000);
    #[test]
        let m = build_mask(&candidates, &identity_position_map(4));
        raw.push(RowSelector::skip(rg_num_rows - pos as usize));
///
    pub fn rg_position(&self, delivered_idx: usize) -> Option<usize> {
    }
                delivered_count,
    fn min_skip_run_all_bits_set_single_select() {
        //     final skip(2) < 4 → absorbed into the trailing select → select(10).
        assert_eq!(pm.rg_position(3), Some(6));
        let selection = build_row_selection_with_min_skip_run(&candidates, 200, 1);
        assert_eq!(selectors(&sel), vec![(true, 50)]);
    if (pos as usize) < rg_num_rows {
        assert_eq!(pm.rg_position(4), None);
                rg_pos += s.row_count;
                    return None;
                delivered_pos += s.row_count;
///   explode for noisy dense bitmaps.
        match self {
/// - `Runs` — block-granular selection with a small number of select
        return RowSelection::from(input);
    #[test]
    }
        //   raw: select(1) skip(2) select(1) skip(3) select(1) skip(2)
            raw.push(RowSelector::skip((start - pos) as usize));
                run_end = next;
/// Merge any `skip(n)` with `n < min_skip_run` into its surrounding
        ]);
        // If the selection is a single whole-RG select, use Identity; the
            let end = rg_pos.saturating_add(s.row_count as u32);
    fn position_map_identity_fast_path() {
                (false, 1), // select row 3
        assert_eq!(pm.rg_position(1), Some(17));
                    return None;
        // contiguous delivered-row range.
//! 2. A [`PositionMap`] that translates delivered-batch-row index back to
///   `skip`). Zero over-read but selector count is O(bitmap flips) and can
        assert_eq!(pm.rg_position(10_000), None);
            selectors(&sel),
            return Self::Identity {
    #[test]
        // If min_skip_run > rg_num_rows, NO skip survives; the result
        }
    // ── build_mask ──────────────────────────────────────────────────
        // Build the matching selection (it's what the real code path
    pub fn from_selection(selection: &RowSelection) -> Self {
            Self::Identity { delivered_count } => {
            break; // RoaringBitmap iter yields ascending; safe to stop.
/// position each delivered row came from.
        // Delivered rows 0..4 correspond to RG positions 3..7.
    ///   `RoaringBitmap::select` for lookup.
            } => *delivered_count,
    // vector stays bounded by `2 * number_of_flips`.
        assert_eq!(m.len(), 8);
/// Build a `BooleanArray` directly from a packed bit-vector of length
                    out[delivered_idx >> 6] |= 1u64 << (delivered_idx & 63);
    ) -> Self {
    fn position_map_bitmap_variant_row_granular() {
    }
    /// Hot paths should prefer `from_candidates_with_selection`, which
    for s in selection.iter() {
                if delivered_idx >= *delivered_count {
    // selects. Keeping it in two passes is clearer and the intermediate
            }
                    if delivered_idx < del_start + len {
                // Roaring's `range()` iterates bits within the range in
        min_skip_run: usize,
        // Bits outside [0, rg_num_rows) are silently ignored (defensive).
    let mut pos = 0u32;
    rg_num_rows: usize,
        selection: &RowSelection,
//! Given a candidate `RoaringBitmap` of RG-relative doc positions, this
        }
                let rg_start_u32 = rg_start.min(u32::MAX as usize) as u32;
    fn build_mask_sparse_candidates_set_only_named_bits() {
    // set-bits in order. Then second pass: merge short skips into adjacent
}
        assert_eq!(selectors(&sel), vec![(false, 10)]);
                for b in candidates.range(rg_start_u32..rg_end_u32) {
    let buffer = Buffer::from_vec(bits);
                bits,
    }
        assert_eq!(pm.rg_position(2), Some(5));
    for b in bm.iter() {
///
            if s.skip {
                delivered_count,
/// Faster than per-position `.contains()` for hot paths that need to do
        // delivered index `i` is set iff the RG position mapped from `i`
        }
                }
    fn build_mask_aligns_to_position_map_not_rg_positions() {
///   runs (bounded by `rg_num_rows / min_skip_run`; at the 1024 default
//!    for a smaller, more block-friendly selector list.
        PositionMap::Identity { delivered_count } => {
            packed_bits_to_boolean_array(bits, *delivered_count)
        assert_eq!(
        let got: Vec<bool> = (0..m.len()).map(|i| m.value(i)).collect();
            got,
    }
                break;
    #[test]
/// many lookups against the bitmap — once the packed form exists, each
    coalesce_short_skips(raw, min_skip_run)
pub fn build_mask(candidates: &RoaringBitmap, position_map: &PositionMap) -> BooleanArray {
            }
        }
    // (used by the old full-scan strategy and equivalent to min_skip_run =
                }
        );
        // is in candidates.
        }
    RowSelection::from(out)
    }
    #[test]
                runs.push((rg_pos, delivered_pos, s.row_count));
    match position_map {
/// behaviour, parquet delivers rows from all `select` runs, packed
        // A gap >= min_skip_run stays as a real skip.
    use datafusion::arrow::buffer::Buffer;
        match &pm {
        let candidates: Vec<u32> = (0..10).collect();
use std::sync::Arc;
                Some(last) if !last.skip => {
        let selection = build_row_selection_with_min_skip_run(&candidates, 1_000_000, 1);
        let sel = RowSelection::from(vec![RowSelector::skip(10)]);
                if delivered_idx >= *delivered_count {
        // Pathological row-granular case: 10_000 scattered bits over a 1M-row RG.
        assert_eq!(pm.delivered_count(), 4);
                _ => out.push(s),
        let m = build_mask(&candidates, &identity_position_map(16));
        assert_eq!(pm.delivered_count(), 1_000_000);
/// the same `RowSelection` handed to parquet.
        // to the old row-granular behaviour.
        match self {
        // Candidates {0, 100}: gap is 99 rows. With min_skip_run=50, skip survives.
            }
}
/// positions that were selected.
                (false, 1), // select row 0
    let boolean = datafusion::arrow::buffer::BooleanBuffer::new(buffer, 0, len);
        sel.iter().map(|s| (s.skip, s.row_count)).collect()
    if min_skip_run <= 1 || input.is_empty() {
    /// - else → delegate to `from_selection`, which picks `Identity`
        /// One entry per `select` run: (start_rg_position, start_delivered_idx, length).
/// layout). Bits beyond `len` are truncated. O(set_bits), not O(len).
        let mut rg_pos = 0usize;
///   `RoaringBitmap::select`. O(log n) lookup, shares an `Arc` with the
        assert_eq!(pm.rg_position(1), Some(1));
/// format so no translation is needed.
/// and needs to AND/OR it with another bitmap. The bitmap contains one
                runs,
        iter.next();
            RowSelector::select(3),
//!    RG-relative position, which post-decode masks need for alignment.
                } else {
            other => panic!("expected Bitmap, got {:?}", other),
        assert_eq!(pm.rg_position(3), Some(100));
/// skipping — it gets absorbed into the surrounding `select` run. Gaps of
    }
        let sel = RowSelection::from(vec![RowSelector::select(rg_num_rows)]);
            ]
            match out.last_mut() {
        let sel = build_row_selection_with_min_skip_run(&bm(&[0, 100]), 200, 50);
    fn min_skip_run_absorbs_small_gaps() {
            | Self::Runs {
pub fn row_selection_to_bitmap(selection: &RowSelection) -> RoaringBitmap {
        //   delivered  0 1 2 3 4
            // A real skip (row_count >= min_skip_run).
        // Out-of-range set bits are ignored defensively.
    // Helper: builds a full-scan PositionMap where delivered_idx == rg_position
        if runs.len() == 1 && runs[0].0 == 0 && runs[0].1 == 0 {
}
            | Self::Bitmap {
        // Runs → iterate runs, materialise each run's slice into the
                (false, 1), // select row 7
                delivered_count,
        }
///   explode `runs` — e.g. 10k scattered candidates in a 1M-row RG.
        );
    fn min_skip_run_empty_bitmap_skips_everything() {
    }
        assert!(matches!(pm, PositionMap::Bitmap { .. }));
        b
            PositionMap::Bitmap { .. } => {}
        assert_eq!(
        } else if !s.skip {
) -> RowSelection {
        assert_eq!(pm.rg_position(0), Some(0));
//!
/// Materialize a `RoaringBitmap` into a packed u64 bit-vector with `len`
/// [`PositionMap`] alongside it to translate delivered batch rows back to
        PositionMap::Bitmap {
        //   after absorb (any skip<4 merges):
/// `select` neighbours. Adjacent selects get combined.
        for &v in values {
    #[test]
        assert_eq!(pm.rg_position(9_999), Some(9_999 * 97));
    /// - `min_skip_run == 1` → row-granular: every delivered row is a set
            } => {
        if start > pos {
        let sel = build_row_selection_with_min_skip_run(&bm(&[5, 999]), 10, 1);
/// - `min_skip_run = rg_num_rows + 1` → single big `select`, equivalent
        for s in selection.iter() {
        }
    fn position_map_bitmap_variant_no_runs_allocated() {
    fn position_map_single_select() {
        ]);
}
        assert_eq!(pm.rg_position(1), Some(97));
fn coalesce_short_skips(input: Vec<RowSelector>, min_skip_run: usize) -> RowSelection {
        let m = build_mask(&candidates, &identity_position_map(8));
    fn min_skip_run_one_is_row_granular() {
    }
    let mut v = vec![0u64; words];
    pub fn from_candidates_with_selection(
    }
        //   mask     : [false, true, false, true, false]
            vec![true, false, false, true, false, false, false, true]
            ]
///   drops them post-decode). Run length of every `skip` is guaranteed
///
        }
        }
            RowSelector::skip(3),
///   caller (no new allocation). This is the regime that would otherwise
    fn position_map_empty_selection_is_empty() {
        // Under the old single-struct design this would allocate a
    }
    },
///
    },
    #[test]
    #[test]
    //
        while let Some(&next) = iter.peek() {
/// - `min_skip_run = 1` → row-granular selection (every non-set bit is a
        assert_eq!(m.null_count(), 0);
    }
    #[test]
            let words = n.div_ceil(64);
        }
///   on a 1M RG that's < 1k entries).
/// Length of the returned mask = `PositionMap::delivered_count`. Bit at
            vec![
            PositionMap::from_candidates_with_selection(Arc::clone(&candidates), &selection, 1);
        assert_eq!(pm.rg_position(0), Some(0));
        let candidates = bm(&[0, 3, 7]);
            RowSelector::select(2),
    }
        let sel = build_row_selection_with_min_skip_run(&bm(&candidates), 10, 5);
    /// picks the cheapest variant.
    },
    #[test]
//!    rows parquet actually hands back.
/// The returned `Vec<u64>` has `ceil(len / 64)` words. Zero-allocate the
/// Build a `RowSelection` from a candidate `RoaringBitmap`, treating any
    // Second pass: absorb skips with row_count < min_skip_run into
//!    are absorbed into surrounding selects, trading a little over-read
/// had every row in it — for block-granular RowSelection, we only emit a
        assert_eq!(pm.delivered_count(), 0);
/// Returns a `RowSelection` ready for parquet. The caller must track a
#[derive(Debug, Clone)]
        let pm =
        // Selection: select(3) skip(2) select(2)  → delivers 5 rows.
                (true, 99), // skip rows 101..200 (>= 50 → preserved)
        assert_eq!(pm.rg_position(2), Some(42));
        // chooses the Bitmap variant rather than Runs.
    let n = position_map.delivered_count();
/// Runs with `min_skip_run = 1` are a no-op (every skip is >= 1).
                bits: candidates,
        let candidates = Arc::new(bm(&[3, 17, 42, 100]));
        let pm = PositionMap::from_selection(&sel);
                }
use datafusion::parquet::arrow::arrow_reader::{RowSelection, RowSelector};
/// `>= min_skip_run` emit a real `skip`.
            PositionMap::from_candidates_with_selection(Arc::clone(&candidates), &selection, 1);
    // ── build_row_selection_with_min_skip_run ────────────────────────
    }
    BooleanArray::new(boolean, None)
        assert_eq!(pm.delivered_count(), 10_000);
                        return Some(rg_start + (delivered_idx - del_start));
        if s.skip && s.row_count < min_skip_run {
                delivered_count, ..
                (false, 1), // select row 0
///
        assert_eq!(pm.rg_position(1), Some(4));
///   non-matching rows over-read (parquet reads them; the caller's mask
    #[test]
        assert_eq!(pm.rg_position(0), Some(3));
            }
        PositionMap::Runs { runs, .. } => {
/// bit per delivered row, which is a small fraction of `rg_num_rows`.
            match out.last_mut() {
        assert_eq!(pm.rg_position(999_999), Some(999_999));
    }
        assert_eq!(got, vec![false, true, false, true, false]);
    }
                bits.select(delivered_idx as u32).map(|b| b as usize)
/// bits (LSB-first within each word, matching Arrow's `BooleanBuffer`
        assert_eq!(selectors(&sel), vec![(false, 10)]);
            };
                    None
///
/// - `Identity` — whole RG selected. `rg_position(i) = i`. Zero bytes.
        let m = build_mask(&candidates, &identity_position_map(8));
                delivered_count: delivered_pos,
        Self::from_selection(selection)
            };
///
        delivered_count: usize,
        assert_eq!(m.len(), 4);
    }
//!
    ///   (whole-RG) or `Runs` (small block-granular run count).
            rg_pos = end;
        assert_eq!(pm.rg_position(6), None);
///
use datafusion::arrow::array::BooleanArray;
        }
                }
    }
//!    whose "skip" runs are each at least `min_skip_run` long. Short gaps
                delivered_count, ..
    }
            rg_pos = rg_pos.saturating_add(s.row_count as u32);
            } else {
/// delivered-index `i` is `true` iff `candidates` contains the RG-relative
pub fn bitmap_to_packed_bits(bm: &RoaringBitmap, len: u32) -> Vec<u64> {
        let sel = build_row_selection_with_min_skip_run(&bm(&[]), 50, 10);
                _ => {
/// - `Bitmap` — row-granular selection (every delivered row is a set bit
                (true, 99), // skip rows 1..100 (>= 50 → preserved)
        let mut run_end = start;
        candidates: Arc<RoaringBitmap>,
            } else {
    #[test]
            Self::Identity { delivered_count }
/// Trade-off knob:
        let candidates = bm(&[1, 5]);
        // Whole-RG select collapses to Identity — no runs allocated.
        assert_eq!(selectors(&sel), vec![(true, 5), (false, 1), (true, 4)]);
        return RowSelection::from(vec![RowSelector::skip(rg_num_rows)]);
        if min_skip_run == 1 {
            BooleanArray::new(all_true, None)
    // big select covering both sides + the gap.
    /// Returns `None` if `delivered_idx >= delivered_count`.
        // PositionMap. 4 scattered bits; delivered index i → i-th set bit.
            let bits = bitmap_to_packed_bits(candidates, *delivered_count as u32);
    }
    #[test]
        let sel = RowSelection::from(vec![
                    Some(delivered_idx)
        let mut delivered_pos = 0usize;
            RowSelector::select(1),
            RowSelector::skip(1),
    v
    let mut iter = candidates.iter().peekable();
        // With min_skip_run=1, every non-set bit is a skip — equivalent
        delivered_count: usize,
        delivered_count: usize,
    min_skip_run: usize,
/// `PositionMap` was identity (delivered_idx == rg_position) and the mask
    }
            if next == run_end + 1 && (next as usize) < rg_num_rows {
                rg_pos += s.row_count;
//! The three together replace the pre-refactor "`FilterStrategy =
            // Merge with previous select if any.
        // Candidates: {1, 5}
        assert_eq!(pm.rg_position(5), Some(11));
    /// in tests and the block-granular regime (where `runs` stays small).
        assert_eq!(pm.rg_position(0), Some(3));
}
//! RowSelection | BooleanMask`" branching. One code path, one knob.
/// Expand a `RowSelection` to a `RoaringBitmap` of RG-relative row
        // per-lookup indirection and allocation.
        }
            out.push(s);
    fn position_map_multiple_selects() {
    // surrounding selects. A skip flanked by selects becomes part of one
    }
            RowSelector::skip(5),
    }
        } else {
        //     skip(2) absorbed → merges the two selects into select(4)   [row 0..4]
            vec![
            bits.insert(i * 97); // scattered, evenly spread up to ~970_000
        assert!(matches!(pm, PositionMap::Identity { .. }));
            out.insert_range(rg_pos..end);
        /// Delivered row i corresponds to the i-th set bit of `bits`.
    #[test]
                (false, 1), // select row 100
    fn build_mask_candidates_outside_range_are_ignored() {
        assert_eq!(m.true_count(), 0);
/// Maps a delivered batch-row index (0-based across all selects in a
        if s.skip {
        for i in 0..10_000u32 {
    // ── PositionMap ──────────────────────────────────────────────────
    fn identity_position_map(rg_num_rows: usize) -> PositionMap {
mod tests {
            // RoaringBitmap's insert_range handles runs efficiently.
    fn min_skip_run_oversized_threshold_becomes_full_scan() {
#[cfg(test)]
        // is one big select across the whole RG.
            }
            RowSelector::select(3),
            delivered_count: delivered_pos,
        let sel = build_row_selection_with_min_skip_run(&bm(&[0, 3, 7]), 10, 4);
    #[test]
/// - `min_skip_run = large` → coarser selection, fewer selectors, some
pub fn packed_bits_to_boolean_array(bits: Vec<u64>, len: usize) -> BooleanArray {
                (true, 2),  // skip rows 8,9
    ///
        // ~240 KB runs Vec. Bitmap variant carries only an Arc pointer.
        v[(b as usize) >> 6] |= 1u64 << (b & 63);
        let mut b = RoaringBitmap::new();
        assert_eq!(got, vec![false, false, true, false]);
                // rg-position range, translate to delivered position, set
        let pm =
                // RoaringBitmap::select(n) returns the n-th smallest set bit.
            for &(rg_start, delivered_start, run_len) in runs {
/// output and only touch words containing set bits.
    let mut rg_pos: u32 = 0;
            let all_true = datafusion::arrow::buffer::BooleanBuffer::new_set(*delivered_count);
        runs: Vec<(usize, usize, usize)>,
        // Spot check a few delivered indices.
///   to a full scan.
