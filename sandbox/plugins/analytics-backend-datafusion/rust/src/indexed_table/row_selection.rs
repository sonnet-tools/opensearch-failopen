        } else {
        let sel = build_row_selection_with_min_skip_run(&bm(&[0, 7]), 10, 1000);
                    return None;
    pub fn rg_position(&self, delivered_idx: usize) -> Option<usize> {
            }
    fn position_map_multiple_selects() {
                    out.push(RowSelector::select(s.row_count));
        }
            Self::Identity { delivered_count }
            BooleanArray::new(all_true, None)
                let rg_end_u32 = (rg_start + run_len).min(u32::MAX as usize) as u32;
//! 1. A parquet [`RowSelection`] (`build_row_selection_with_min_skip_run`)
        // Second block: delivered [2,3,4] → RG [7,8,9] (2 selected + 5 skipped = 7).
        if s.skip && s.row_count < min_skip_run {
            vec![
    pub fn from_selection(selection: &RowSelection) -> Self {
        assert_eq!(pm.delivered_count(), 4);
        // Delivered rows 0..4 correspond to RG positions 3..7.
    }
            PositionMap::from_candidates_with_selection(Arc::clone(&candidates), &selection, 1);
    rg_num_rows: usize,
            vec![true, false, false, true, false, false, false, true]
    for s in input {
        assert_eq!(m.len(), 4);
/// Materialize a `RoaringBitmap` into a packed u64 bit-vector with `len`
            let all_true = datafusion::arrow::buffer::BooleanBuffer::new_set(*delivered_count);
        let candidates = Arc::new(bits);
    #[test]
    // big select covering both sides + the gap.
    let mut rg_pos: u32 = 0;
    fn build_mask_empty_candidates_produces_all_false() {
        assert_eq!(pm.rg_position(0), Some(0));
        //   delivered  0 1 2 3 4
        if min_skip_run == 1 {
    ///   `RoaringBitmap::select` for lookup.
    }
    // ── build_row_selection_with_min_skip_run ────────────────────────
        assert_eq!(selectors(&sel), vec![(true, 5), (false, 1), (true, 4)]);
        // delivered index `i` is set iff the RG position mapped from `i`
        assert_eq!(pm.rg_position(3), Some(8));
    let n = position_map.delivered_count();
                }
//!    RG-relative position, which post-decode masks need for alignment.
        }
/// - `Bitmap` — row-granular selection (every delivered row is a set bit
        } else {
                }
/// Runs with `min_skip_run = 1` are a no-op (every skip is >= 1).
/// bits (LSB-first within each word, matching Arrow's `BooleanBuffer`
/// `PositionMap` was identity (delivered_idx == rg_position) and the mask
        //   rg_pos     0 1 2 5 6
        }
            | Self::Runs {
///
        assert_eq!(pm.rg_position(1_000_000), None);
///   drops them post-decode). Run length of every `skip` is guaranteed
                (true, 2),  // skip rows 8,9
                // Roaring's `range()` iterates bits within the range in
        assert_eq!(pm.delivered_count(), 6);
    // First pass: emit row-granular (select_run, skip_run) pairs by walking
/// Build a `BooleanArray` directly from a packed bit-vector of length
fn coalesce_short_skips(input: Vec<RowSelector>, min_skip_run: usize) -> RowSelection {
    Bitmap {
            } else {
}
/// Build a `RowSelection` from a candidate `RoaringBitmap`, treating any
        raw.push(RowSelector::skip(rg_num_rows - pos as usize));
    let mut iter = candidates.iter().peekable();
}
        ]);
        let m = build_mask(&candidates, &identity_position_map(16));
        // Spot check a few delivered indices.
///
        assert_eq!(m.len(), 5);
        assert_eq!(pm.delivered_count(), 4);
        return RowSelection::from(input);
//!    for a smaller, more block-friendly selector list.
    v
        assert_eq!(pm.rg_position(999_999), Some(999_999));
        } else if !s.skip {
        // hands to parquet), but we pass min_skip_run = 1 so PositionMap
            } => {
            RowSelector::skip(2),
                    return None;
            let words = n.div_ceil(64);
                _ => {
    fn min_skip_run_preserves_big_gaps() {
//! Given a candidate `RoaringBitmap` of RG-relative doc positions, this
        let mut runs = Vec::new();
/// `RowSelection`, in order) to its RG-relative row position. Built from
            }
        let pm =
    // Helper: builds a full-scan PositionMap where delivered_idx == rg_position
        let sel = build_row_selection_with_min_skip_run(&bm(&[]), 50, 10);
        //   after absorb (any skip<4 merges):
    }
/// Used when a caller receives a `RowSelection` (e.g. from page pruning)
        // Whole-RG select collapses to Identity — no runs allocated.
///
            break;
            let mut out = vec![0u64; words];
        // With min_skip_run=1, every non-set bit is a skip — equivalent
                delivered_count, ..
        delivered_count: usize,
        // Out-of-range set bits are ignored defensively.
///   in some bitmap). The i-th delivered row is the i-th set bit via
                // ascending order — O(set_bits_in_range).
        assert_eq!(pm.rg_position(2), Some(7));
        assert_eq!(pm.rg_position(5), Some(11));
///   runs (bounded by `rg_num_rows / min_skip_run`; at the 1024 default
/// skipping — it gets absorbed into the surrounding `select` run. Gaps of
        let pm = PositionMap::from_selection(&sel);
                if delivered_idx >= *delivered_count {
    ///
        for i in 0..10_000u32 {
        }
        assert_eq!(pm.rg_position(0), None);
}
        raw.push(RowSelector::select(run_len));
                    let delivered_idx = delivered_start + (b as usize - rg_start);
            }
        let candidates = RoaringBitmap::new();
///   explode `runs` — e.g. 10k scattered candidates in a 1M-row RG.
        assert_eq!(pm.rg_position(0), Some(3));
                for b in candidates.range(rg_start_u32..rg_end_u32) {
    /// Returns `None` if `delivered_idx >= delivered_count`.
            PositionMap::from_candidates_with_selection(Arc::clone(&candidates), &selection, 1);
        }
/// The returned `Vec<u64>` has `ceil(len / 64)` words. Zero-allocate the
        runs: Vec<(usize, usize, usize)>,
                rg_pos += s.row_count;
use datafusion::parquet::arrow::arrow_reader::{RowSelection, RowSelector};
            break; // RoaringBitmap iter yields ascending; safe to stop.
        min_skip_run: usize,
    #[test]
            out.push(s);
    /// picks the cheapest variant.
    }
    ///   (whole-RG) or `Runs` (small block-granular run count).
/// - `Runs` — block-granular selection with a small number of select
            match out.last_mut() {
            };
        // First block: delivered [0,1] → RG [0,1].
        }
    pub fn delivered_count(&self) -> usize {
    /// Build the cheapest `PositionMap` for a (candidates, selection) pair.
    for s in selection.iter() {
        assert_eq!(pm.rg_position(0), Some(0));
        bits: Arc<RoaringBitmap>,
    use super::*;
            // Absorb into the trailing select (or become one if nothing yet).
        if s.skip {
                None
                    last.row_count += s.row_count;
/// output and only touch words containing set bits.
    Runs {
                if delivered_idx >= *delivered_count {
        /// Sorted ascending on `start_delivered_idx`.
    // selects. Keeping it in two passes is clearer and the intermediate
    }
    if candidates.is_empty() {
        let sel = RowSelection::from(vec![RowSelector::select(rg_num_rows)]);
        Self::Runs {
            out.insert_range(rg_pos..end);
//! Row-selection utilities for the indexed streaming path.
        // candidate bitmap as a packed BooleanArray in one shot;
    // RoaringBitmap.iter() yields set bits in ascending order.
            RowSelector::select(2),
        // All positions in candidates → all-true mask.
            | Self::Bitmap {
        assert_eq!(m.null_count(), 0);
    // (used by the old full-scan strategy and equivalent to min_skip_run =
        let m = build_mask(&candidates, &identity_position_map(8));
        // Candidates {0, 100}: gap is 99 rows. With min_skip_run=50, skip survives.
    let mut raw: Vec<RowSelector> = Vec::new();
        return RowSelection::from(Vec::<RowSelector>::new());
                (false, 1), // select row 3
                delivered_count, ..
    fn position_map_bitmap_variant_row_granular() {
            }
            runs,
}
        assert_eq!(pm.rg_position(4), None);
    let buffer = Buffer::from_vec(bits);
                // the corresponding bit.
///   on a 1M RG that's < 1k entries).
    let mut v = vec![0u64; words];
        // Candidates: {1, 5}
    candidates: &RoaringBitmap,
        let got: Vec<bool> = (0..m.len()).map(|i| m.value(i)).collect();
            raw.push(RowSelector::skip((start - pos) as usize));
/// `len`. The `Vec<u64>` is consumed and wrapped as an Arrow `Buffer` via
        }
            RowSelector::select(1),
/// position that row `i` came from. Under the old full-scan strategy,
        assert_eq!(pm.rg_position(3), Some(100));
        let candidates = Arc::new(bm(&[3, 17, 42, 100]));
                (false, 1), // select row 7
        // Runs variant would still be correct but Identity skips the
        assert_eq!(pm.rg_position(1), Some(17));
        // Candidates {0, 3, 7} on a 10-row RG with min_skip_run=4:
            packed_bits_to_boolean_array(bits, *delivered_count)
/// Maps a delivered batch-row index (0-based across all selects in a
    let words = len.div_ceil(64) as usize;
        // Selection: select(3) skip(2) select(2)  → delivers 5 rows.
        // Third block: delivered [5] → RG [11] (7+3 selected + 1 skipped = 11).
        assert_eq!(pm.rg_position(6), None);
            if next == run_end + 1 && (next as usize) < rg_num_rows {
        match &pm {
        assert_eq!(m.true_count(), 0);
//!    whose "skip" runs are each at least `min_skip_run` long. Short gaps
        let m = build_mask(&candidates, &pm);
            RowSelector::select(3),
        assert_eq!(selectors(&sel), vec![(false, 10)]);
    }
            vec![
            } else {
//! The three together replace the pre-refactor "`FilterStrategy =
    // set-bits in order. Then second pass: merge short skips into adjacent
            RowSelector::select(2),
        }
            let bits = bitmap_to_packed_bits(candidates, *delivered_count as u32);
        let sel = build_row_selection_with_min_skip_run(&bm(&[0, 3, 7]), 10, 4);
//!
            RowSelector::skip(3),
                (false, 1), // select row 0
pub fn build_row_selection_with_min_skip_run(
) -> RowSelection {
    for b in bm.iter() {
        assert_eq!(pm.rg_position(1), Some(97));
    }
    /// Hot paths should prefer `from_candidates_with_selection`, which
    }
        let pm = PositionMap::from_selection(&sel);
        v[(b as usize) >> 6] |= 1u64 << (b & 63);
                    if delivered_idx < del_start + len {
    fn build_mask_sparse_candidates_set_only_named_bits() {
            selectors(&sel),
    /// - else → delegate to `from_selection`, which picks `Identity`
    // surrounding selects. A skip flanked by selects becomes part of one
/// lookup is a single `(words[i >> 6] >> (i & 63)) & 1` operation.
/// - `Identity` — whole RG selected. `rg_position(i) = i`. Zero bytes.
            }
/// bit per delivered row, which is a small fraction of `rg_num_rows`.
                // rg-position range, translate to delivered position, set
        if runs.len() == 1 && runs[0].0 == 0 && runs[0].1 == 0 {
    #[test]
                bits: candidates,
    }
            }
        assert_eq!(got, vec![false, false, true, false]);
}
                Some(last) if !last.skip => {
    }
        //
        assert_eq!(pm.delivered_count(), 10_000);
//!    rows parquet actually hands back.
/// Merge any `skip(n)` with `n < min_skip_run` into its surrounding
    }
    #[test]
    match position_map {
use datafusion::arrow::array::BooleanArray;
        // chooses the Bitmap variant rather than Runs.
/// "gap" (consecutive non-set bits) shorter than `min_skip_run` as NOT worth
            RowSelector::select(4),
                delivered_count: delivered_pos,
                delivered_pos += s.row_count;
///   `skip`). Zero over-read but selector count is O(bitmap flips) and can
        }
        // is one big select across the whole RG.
/// `>= min_skip_run` emit a real `skip`.
/// format so no translation is needed.
        }
        // Everything got absorbed into one big select.
        }
                delivered_count,
            other => panic!("expected Bitmap, got {:?}", other),
    let boolean = datafusion::arrow::buffer::BooleanBuffer::new(buffer, 0, len);
        assert_eq!(pm.delivered_count(), 0);
/// had every row in it — for block-granular RowSelection, we only emit a
    /// Translate a delivered row index to its RG-relative position.
    fn min_skip_run_all_bits_set_single_select() {
        // If min_skip_run > rg_num_rows, NO skip survives; the result
    min_skip_run: usize,
        // Runs → iterate runs, materialise each run's slice into the
/// the same `RowSelection` handed to parquet.
        }
        b
        }
        for &v in values {
use roaring::RoaringBitmap;
                delivered_count,
        PositionMap::Runs { runs, .. } => {
    fn position_map_bitmap_variant_no_runs_allocated() {
    },
        let sel = build_row_selection_with_min_skip_run(&bm(&[0, 3, 7]), 10, 1);
            let end = rg_pos.saturating_add(s.row_count as u32);
    #[test]
    fn min_skip_run_ignores_out_of_range_bits() {
                    out[delivered_idx >> 6] |= 1u64 << (delivered_idx & 63);
    coalesce_short_skips(raw, min_skip_run)
    #[test]
                }
    }
    fn identity_position_map(rg_num_rows: usize) -> PositionMap {
                (true, 99), // skip rows 101..200 (>= 50 → preserved)
/// layout). Bits beyond `len` are truncated. O(set_bits), not O(len).
    #[test]
        // delivered row is by construction a candidate, so the mask is
            RowSelector::skip(1),
            selectors(&sel),
        // Bits outside [0, rg_num_rows) are silently ignored (defensive).
    #[test]
                    // Previous was skip or nothing; promote this run to select.
    }
        if b >= len {
        //   mask     : [false, true, false, true, false]
    while let Some(&start) = iter.peek() {
            };
                rg_pos += s.row_count;
        let pm = PositionMap::from_selection(&sel);
//!
        assert_eq!(selectors(&sel), vec![(false, 10)]);
        }
///   non-matching rows over-read (parquet reads them; the caller's mask
        candidates: Arc<RoaringBitmap>,
///   `>= min_skip_run`; `select` runs absorb tiny gaps.
/// Length of the returned mask = `PositionMap::delivered_count`. Bit at
impl PositionMap {
    fn min_skip_run_one_is_row_granular() {
        sel.iter().map(|s| (s.skip, s.row_count)).collect()
                run_end = next;
    }
    fn build_mask_aligns_to_position_map_not_rg_positions() {
/// many lookups against the bitmap — once the packed form exists, each
        assert_eq!(pm.delivered_count(), 1_000_000);
            b.insert(v);
        while let Some(&next) = iter.peek() {
        // A gap >= min_skip_run stays as a real skip.
        //     then another select(1) for row 7 — separated by skip(3) which is < 4
            rg_pos = end;
            } => *delivered_count,
            ]
    fn build_mask_candidates_outside_range_are_ignored() {
    // rg_num_rows + 1). This keeps the legacy behaviour under test.
        let selection = build_row_selection_with_min_skip_run(&candidates, 200, 1);
                if delivered_idx < *delivered_count {
        // `select` runs. The mask length = delivered_count and each bit at
    }
                    last.row_count += s.row_count;
            Self::Identity { delivered_count } => {
        );
                Some(last) if !last.skip => {
        //   raw: select(1) skip(2) select(1) skip(3) select(1) skip(2)
///
        let sel = RowSelection::from(vec![RowSelector::select(1_000_000)]);
        //     skip(2) absorbed → merges the two selects into select(4)   [row 0..4]
        // PositionMap. 4 scattered bits; delivered index i → i-th set bit.
    #[test]
        /// One entry per `select` run: (start_rg_position, start_delivered_idx, length).
                for &(rg_start, del_start, len) in runs {
/// - `min_skip_run = large` → coarser selection, fewer selectors, some
    use datafusion::arrow::buffer::Buffer;
    // ── build_mask ──────────────────────────────────────────────────
}
    fn min_skip_run_oversized_threshold_becomes_full_scan() {
/// position each delivered row came from.
    fn min_skip_run_empty_bitmap_skips_everything() {
                }
/// RG-relative positions for post-decode mask alignment.
    #[test]
        let mut b = RoaringBitmap::new();
/// bit per `select`ed row. `skip` runs contribute nothing.
///
                (false, 1), // select row 0
        //     so skip(3) is absorbed → select(4) + select(1) merged into select(8) [rows 0..8]
    fn bm(values: &[u32]) -> RoaringBitmap {
        // Under the old single-struct design this would allocate a
    pub fn from_candidates_with_selection(
//!
        //     final skip(2) < 4 → absorbed into the trailing select → select(10).
mod tests {
        let candidates = bm(&[2, 9, 100]);
/// Expand a `RowSelection` to a `RoaringBitmap` of RG-relative row
/// - `min_skip_run = 1` → row-granular selection (every non-set bit is a
/// given the `RowSelection` we handed it.
            PositionMap::Bitmap { .. } => {}
                } else {
        // per-lookup indirection and allocation.
                (true, 99), // skip rows 1..100 (>= 50 → preserved)
        PositionMap::from_selection(&sel)
/// positions that were selected.
        assert_eq!(m.len(), 8);
    }
    #[test]
    if min_skip_run <= 1 || input.is_empty() {
    }
        assert_eq!(pm.rg_position(2), Some(42));
        assert_eq!(m.len(), 8);
        let candidates: Vec<u32> = (0..10).collect();
        assert!(matches!(pm, PositionMap::Identity { .. }));
        }
        assert_eq!(pm.rg_position(2), Some(5));
        assert_eq!(selectors(&sel), vec![(true, 50)]);
        // Build the matching selection (it's what the real code path
        let pm = PositionMap::from_selection(&sel);
/// - `min_skip_run = rg_num_rows + 1` → single big `select`, equivalent
        assert_eq!(pm.rg_position(4), None);
        if start > pos {
        // Row-granular regime: candidates drive both RowSelection and
///   explode for noisy dense bitmaps.
            ]
    // vector stays bounded by `2 * number_of_flips`.
        assert_eq!(got, vec![false, true, false, true, false]);
        for s in selection.iter() {
            }
/// Trade-off knob:
                delivered_count,
        assert_eq!(
                (false, 1), // select row 100
                // Walk the candidate set bits that fall in this run's
    // ── PositionMap ──────────────────────────────────────────────────
            } => {
            Self::Runs {
    }
    fn min_skip_run_absorbs_small_gaps() {
        Self::from_selection(selection)
        // ~240 KB runs Vec. Bitmap variant carries only an Arc pointer.
        let candidates = bm(&[0, 3, 7]);
    },
    }
        ]);
                (true, 3),  // skip rows 4,5,6
                let rg_start_u32 = rg_start.min(u32::MAX as usize) as u32;
        let run_len = (run_end - start + 1) as usize;
///
            RowSelector::select(3),
    }
                runs,
    }
///
        }
    if (pos as usize) < rg_num_rows {
                (true, 2),  // skip rows 1,2
        let sel = RowSelection::from(vec![
            Self::Bitmap {
                }
    let mut out = RoaringBitmap::new();
//! module produces:
                bits.select(delivered_idx as u32).map(|b| b as usize)
    RowSelection::from(out)
        assert_eq!(
}
            // A real skip (row_count >= min_skip_run).
        } => {
    //
            bits.insert(i * 97); // scattered, evenly spread up to ~970_000
        assert_eq!(pm.rg_position(1), Some(1));
        let sel = RowSelection::from(vec![RowSelector::skip(10)]);
//! 2. A [`PositionMap`] that translates delivered-batch-row index back to
        assert_eq!(pm.rg_position(4), Some(9));
    ///   bit of `candidates`. Wrap the bitmap in `Arc` and use
        );
    /// Build a Runs-backed map from an arbitrary `RowSelection`. Used only
    }
/// Under [`build_row_selection_with_min_skip_run`]'s "absorb short skips"
        // Identity → delivered_idx == rg_position. Materialise the
        assert_eq!(m.true_count(), 16);
/// Faster than per-position `.contains()` for hot paths that need to do
        let mut bits = RoaringBitmap::new();
                    Some(delivered_idx)
    /// in tests and the block-granular regime (where `runs` stays small).
    #[test]
    fn position_map_single_select() {
        );
/// and needs to AND/OR it with another bitmap. The bitmap contains one
//! 3. A delivered-row [`BooleanArray`] mask (`build_mask`) aligned to the
///   `RoaringBitmap::select`. O(log n) lookup, shares an `Arc` with the
            if s.skip {
        PositionMap::Identity { delivered_count } => {
            }
        let sel = build_row_selection_with_min_skip_run(&bm(&candidates), 10, 5);
///
            let delivered_count = candidates.len() as usize;
        // is in candidates.
    #[test]
    let mut pos = 0u32;
    }
            got,
    }
        let sel = build_row_selection_with_min_skip_run(&bm(&[5, 999]), 10, 1);
        assert_eq!(pm.rg_position(0), Some(0));
                }
//! RowSelection | BooleanMask`" branching. One code path, one knob.
        assert_eq!(selectors(&sel), vec![(false, 10)]);
///
                }
        // Pathological row-granular case: 10_000 scattered bits over a 1M-row RG.
        let selection = build_row_selection_with_min_skip_run(&candidates, 1_000_000, 1);
        let m = build_mask(&candidates, &identity_position_map(4));
    fn selectors(sel: &RowSelection) -> Vec<(bool, usize)> {
/// contiguously. Post-decode masks need this map to know which RG
        assert_eq!(pm.rg_position(9_999), Some(9_999 * 97));
    }
                        return Some(rg_start + (delivered_idx - del_start));
        // With a block-granular selection, parquet delivers only rows from
/// behaviour, parquet delivers rows from all `select` runs, packed
        // to the old row-granular behaviour.
        // contiguous delivered-row range.
    if rg_num_rows == 0 {
/// `from_vec` — zero-copy. Bit layout matches Arrow's native LSB-first
    }
        let m = build_mask(&candidates, &identity_position_map(8));
            }
        // memcpy-speed, O(set_bits + len/64).
        pos = run_end + 1;
            RowSelector::skip(3),
        PositionMap::Bitmap {
        let pm = PositionMap::from_selection(&sel);
    }
                iter.next();
        let pm =
                    }
        let sel = RowSelection::from(vec![
#[derive(Debug, Clone)]
            // Merge with previous select if any.
                break;
    use datafusion::arrow::array::Array;
            match out.last_mut() {
            delivered_count, ..
use std::sync::Arc;
    }
/// Storage is chosen per regime to stay cheap at 1M-row RGs:
/// [`PositionMap`] alongside it to translate delivered batch rows back to
        let got: Vec<bool> = (0..m.len()).map(|i| m.value(i)).collect();
    }
    /// - `min_skip_run == 1` → row-granular: every delivered row is a set
            delivered_count: delivered_pos,
        return RowSelection::from(vec![RowSelector::skip(rg_num_rows)]);
//!    are absorbed into surrounding selects, trading a little over-read
    }
    // Second pass: absorb skips with row_count < min_skip_run into
/// Returns a `RowSelection` ready for parquet. The caller must track a
        }
            // RoaringBitmap's insert_range handles runs efficiently.
        let mut rg_pos = 0usize;
        let mut run_end = start;
    }
}
            RowSelector::skip(5),
pub fn row_selection_to_bitmap(selection: &RowSelection) -> RoaringBitmap {
        let sel = RowSelection::from(vec![
/// `select` neighbours. Adjacent selects get combined.
        let candidates: RoaringBitmap = (0u32..16).collect();
    BooleanArray::new(boolean, None)
        assert!(matches!(pm, PositionMap::Bitmap { .. }));
        // If the selection is a single whole-RG select, use Identity; the
        assert_eq!(pm.rg_position(10_000), None);
    },
        delivered_count: usize,
            for &(rg_start, delivered_start, run_len) in runs {
    ) -> Self {
        assert_eq!(pm.rg_position(3), Some(6));
    #[test]
                bits,
        assert_eq!(
                    None
pub fn packed_bits_to_boolean_array(bits: Vec<u64>, len: usize) -> BooleanArray {
        // output buffer. Each run maps a contiguous rg-position range to a
    Identity {
        assert_eq!(pm.rg_position(1), Some(4));
    fn position_map_identity_fast_path() {
        // all-true.
///
        let candidates = bm(&[1, 5]);
                _ => out.push(s),
}
                // RoaringBitmap::select(n) returns the n-th smallest set bit.
            return Self::Bitmap {
pub fn build_mask(candidates: &RoaringBitmap, position_map: &PositionMap) -> BooleanArray {
        }
    }
                }
        selection: &RowSelection,
        let mut delivered_pos = 0usize;
    }
        ]);
    #[test]
                runs.push((rg_pos, delivered_pos, s.row_count));
            return Self::Identity {
    #[test]
        delivered_count: usize,
        // Bitmap → delivered rows are exactly the candidate set bits. Every
///   to a full scan.
    #[test]
    fn build_mask_dense_candidates_covers_every_position() {
///   caller (no new allocation). This is the regime that would otherwise
    let mut out: Vec<RowSelector> = Vec::with_capacity(input.len());
        iter.next();
        match self {
        match self {
    #[test]
/// delivered-index `i` is `true` iff `candidates` contains the RG-relative
    }
            packed_bits_to_boolean_array(out, n)
        if (start as usize) >= rg_num_rows {
#[cfg(test)]
        assert_eq!(pm.rg_position(0), Some(3));
        /// Delivered row i corresponds to the i-th set bit of `bits`.
pub enum PositionMap {
pub fn bitmap_to_packed_bits(bm: &RoaringBitmap, len: u32) -> Vec<u64> {
        let sel = build_row_selection_with_min_skip_run(&bm(&[0, 100]), 200, 50);
        let got: Vec<bool> = (0..m.len()).map(|i| m.value(i)).collect();
    out
    fn position_map_empty_selection_is_empty() {
            rg_pos = rg_pos.saturating_add(s.row_count as u32);
