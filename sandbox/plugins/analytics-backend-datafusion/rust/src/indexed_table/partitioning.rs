        num_rows: i64,
                    segment_idx: chunk_seg.unwrap(),
        match (segments[a].sort_min.as_ref(), segments[b].sort_min.as_ref()) {
    segments: &[SegmentFileInfo],
                rg_index: rg.index,
 * this file be licensed under the Apache-2.0 license or a
/// - `partial_cmp` returns `None` (incomparable types).
        }
///   "can't prove a chain" — same as DataFusion's missing-stats handling),
 * The OpenSearch Contributors require contributions made to
            (Some(la), Some(lb)) => la.partial_cmp(lb).unwrap_or_else(|| {
        }
 */
            _ => return false,
pub(crate) fn chain_on_sort_bounds(bounds: &[(Option<ScalarValue>, Option<ScalarValue>)]) -> bool {
                std::cmp::Ordering::Equal
    for seg in segments {
        // Equality at the boundary doesn't chain — strict > only, matches DataFusion.
///
}
pub struct SegmentLayout {
#[cfg(test)]
    let mut current_chunks: Vec<SegmentChunk> = Vec::new();
    }
/// Caller must handle the case where this is inappropriate (chain doesn't
    layouts: &[SegmentLayout],
    let mut order: Vec<usize> = (0..segments.len()).collect();
        // Fail safe: caller is supposed to have run the chain check, but if
///
            row_group_indices: chunk_rg_indices,
use super::stream::RowGroupInfo;
    struct RGEntry {
                incomparable = true;
            Some(std::cmp::Ordering::Greater) => continue,
        let bounds = [s(Some(1), Some(10)), s(Some(10), Some(20))];
    }
        let bounds = [
    if bounds.is_empty() {
                    doc_min: chunk_doc_min,
    }
    let all_rgs: Vec<RGEntry> = segments
        })
//! A single partition may span multiple segments — each segment's RGs become
        match curr_min.partial_cmp(prev_max) {
    }
    pub row_groups: Vec<RowGroupInfo>,
//! 2. Row indices within a RG are contiguous `[0, num_rows)`.
        let bounds = [s(Some(1), Some(15)), s(Some(10), Some(20))];
        (
///
    let mut current_rows: i64 = 0;
    if !chunk_rg_indices.is_empty() {
/// - `target_partitions >= segments.len()` (so the optimizer's
    });
    // is missing (defensive; caller is supposed to have checked already).
    }
        let curr_min = refs[w[1]].0;
//! 3. Doc IDs map 1:1 to row indices within each segment's parquet file.
        segment_idx: usize,
    if segments.is_empty() {
//! Partitions MUST align to RG boundaries because:
        assert!(chain_on_sort_bounds(&bounds));
        return false;
///   would accept the layout — vanilla path mirror).
        // partitioning so we don't produce an unsorted-but-claimed-sorted plan.
        assert!(!chain_on_sort_bounds(&bounds));
        });
    }
/// - any pair has overlapping ranges,
        if chunk_seg.is_some() && chunk_seg != Some(rg.segment_idx) {
    let mut assignments: Vec<PartitionAssignment> = Vec::with_capacity(segments.len());
    if segments.is_empty() {
}
        if chunk_seg != Some(rg.segment_idx) {
        }
            std::cmp::Ordering::Equal
    fn overlapping_ranges_returns_false() {
            });
            chunk_seg = Some(rg.segment_idx);
        rg_index: usize,
            (Some(lo), Some(hi)) => bounds.push((lo, hi)),
//! Reference: <https://github.com/apache/datafusion/blob/49776a6/datafusion/datasource/src/file_groups.rs#L204>
        let first = layout.row_groups.first().unwrap();
    }
//! Partition assignment for distributing row groups across DataFusion partitions.
#[derive(Debug, Clone)]
/// Compute partition assignments aligned to row group boundaries.
    assignments
            _ => return false,
        let rg_indices: Vec<usize> = layout.row_groups.iter().map(|rg| rg.index).collect();
                doc_min,
        })
}
    #[test]
        assert!(chain_on_sort_bounds(&bounds));
    #[test]
/// sort-key order.
 * compatible open source license.
/// of that segment in their physical (sorted) order — because the writer
    true
                doc_max,
        return compute_assignments(layouts, segments.len().max(1));
            _ => return false,
/// Info about a segment needed for partition assignment.
        .enumerate()
/// One-partition-per-segment assignment for the sort-aware path.
//! groups across all segments, iterate sequentially, cut a new partition when
    order.sort_by(|&a, &b| {
    // Walk in sorted-by-min order: each segment's min must be > the previous segment's max.
    pub chunks: Vec<SegmentChunk>,
    }
pub fn compute_assignments(
    }
        if layout.row_groups.is_empty() {
        let prev_max = bounds[w[0]].1;
    for (lo, hi) in bounds {
            (Some(lo), Some(hi)) => refs.push((lo, hi)),
            }),
        let doc_max = (last.first_row + last.num_rows) as i32;
/// A partition which can span multiple segments.
                incomparable = true;
pub struct SegmentChunk {
        segments.len(),
                row_group_indices: chunk_rg_indices.clone(),
                segment_idx: seg_idx,
    num_partitions: usize,
///
    let mut chunk_doc_min: i32 = 0;
    order.sort_by(|&a, &b| {
        return false;
                num_rows: rg.num_rows,
    });
) -> Vec<PartitionAssignment> {
        let layout = &layouts[seg_idx];
            continue;
        assert!(!chain_on_sort_bounds(&[]));
            // If we got here without sort_min on every segment, caller's
/// Test-only variant of `segments_chain_on_sort_key` that takes the
            incomparable = true;
//!
            }
        match (&seg.sort_min, &seg.sort_max) {
        chunk_doc_max = (rg.first_row + rg.num_rows) as i32;
    }
    }
//!
}
        first_row: i64,
            }],
        // somehow we're here without comparable bounds, fall back to row-count
    true
    if incomparable {
use datafusion::common::ScalarValue;
 * SPDX-License-Identifier: Apache-2.0
    pub row_group_indices: Vec<usize>,
        "segments and layouts must match (one entry per segment)"
                segment_idx: chunk_seg.unwrap(),
    let mut chunk_doc_max: i32 = 0;
        layouts.len(),
    pub segment_idx: usize,
        match curr_min.partial_cmp(prev_max) {
/// segment's `sort_max`. Same algorithm as DataFusion's
            // invariant is broken; preserve original order rather than panic.
}
        refs[a].0.partial_cmp(refs[b].0).unwrap_or_else(|| {
/// Whether segments form a sorted chain on the lead `index.sort.field` column,
            doc_min: chunk_doc_min,
        })
    }
    }
//!
use super::table_provider::SegmentFileInfo;
    let mut bounds: Vec<(&ScalarValue, &ScalarValue)> = Vec::with_capacity(segments.len());
                segment_idx: seg_idx,
/// `is_ordering_valid_for_file_groups` (`file_scan_config.rs:1347-1363`),
    pub doc_max: i32,
    for w in order.windows(2) {
/// ascending. Each assignment holds a single `SegmentChunk` covering all RGs
/// hold, target_partitions too low, sort fields empty) by falling back to
        chunk_rg_indices.push(rg.rg_index);
            doc_max: chunk_doc_max,
}
    segments: &[SegmentLayout],
        assignments.push(PartitionAssignment {
        bounds[a].0.partial_cmp(bounds[b].0).unwrap_or_else(|| {
    fn empty_input_returns_false() {
    use super::*;
    let mut incomparable = false;
    }
    // Flush remaining
    order.sort_by(|&a, &b| {
                    doc_max: chunk_doc_max,
 *
    #[test]
            s(Some(1), Some(10)),
                row_group_indices: rg_indices,
    });
#[derive(Debug, Clone)]
    if all_rgs.is_empty() {
    if incomparable {
//!
    let mut order: Vec<usize> = (0..refs.len()).collect();
                    row_group_indices: chunk_rg_indices.clone(),
            seg.row_groups.iter().map(move |rg| RGEntry {
///   `validated_output_ordering` chain check at `file_scan_config.rs:551`
        current_rows += rg.num_rows;
            });
/// constructing a full `ParquetMetaData`.
    }
    );
        {
    pub doc_min: i32,
    if incomparable {
            segment_idx: chunk_seg.unwrap(),
    for w in order.windows(2) {
        }
                std::cmp::Ordering::Equal
    let mut order: Vec<usize> = (0..bounds.len()).collect();
            s(Some(20), Some(30)),
                });
    use datafusion::common::ScalarValue;
            assignments.push(PartitionAssignment {
//! Ported verbatim from PR #21164.
//! Same model as DataFusion's `repartition_evenly_by_size`: flatten all row
}
    let total_rows: i64 = all_rgs.iter().map(|rg| rg.num_rows).sum();
            if !chunk_rg_indices.is_empty() {
        ];
    // Sort by min; bail if any pair is incomparable.
/// determined from per-segment min/max footer stats: after sorting segments by
    // Collect (min, max) for each segment; bail on the first None.
        let curr_min = bounds[w[1]].0;
    }
/// Used when:
            s(Some(31), Some(40)),
    #[test]
        });
mod chain_tests {
) -> Vec<PartitionAssignment> {
    if !current_chunks.is_empty() {
            current_chunks.push(SegmentChunk {
            lo.map(|v| ScalarValue::Int64(Some(v))),
    fn disjoint_chain_returns_true() {
    for (i, rg) in all_rgs.iter().enumerate() {
    let mut refs: Vec<(&ScalarValue, &ScalarValue)> = Vec::with_capacity(bounds.len());
        current_chunks.push(SegmentChunk {
/// the row-count-balanced `compute_assignments`.
        }
        let prev_max = refs[w[0]].1;
            chunks: current_chunks,
        let doc_min = first.first_row as i32;
            }
                chunk_rg_indices.clear();
/// - `segments_chain_on_sort_key(...)` returned true,
    }
    let rows_per_partition = (total_rows as f64 / num_partitions as f64).ceil() as i64;
}
        }
                chunks: std::mem::take(&mut current_chunks),
                first_row: rg.first_row,
        return false;
    let mut chunk_seg: Option<usize> = None;
    #[test]
        return vec![];
//! a separate `SegmentChunk`.
            chunks: vec![SegmentChunk {
    for seg_idx in order {
    let mut incomparable = false;
/// - any segment has `sort_min`/`sort_max` set to `None` (treated as
    debug_assert_eq!(
    }
/*
    fn touching_boundary_is_overlap() {
            // Equal/less means overlap; None means incomparable.
        .flat_map(|(seg_idx, seg)| {
//!
#[cfg(test)]
    fn missing_stats_returns_false() {
    }
            incomparable = true;
/// Returns `false` when:
            std::cmp::Ordering::Equal
                doc_min: chunk_doc_min,
    let mut assignments: Vec<PartitionAssignment> = Vec::new();
    }
    let mut incomparable = false;
        });
        }
        assert!(!chain_on_sort_bounds(&bounds));
        if current_rows >= rows_per_partition && assignments.len() < num_partitions - 1 && !is_last
//! accumulated rows exceed `ceil(total_rows / num_partitions)`.
            _ => {
        match (lo, hi) {
        let is_last = i == all_rgs.len() - 1;
///
/// Empty input → `false` (nothing to advertise).
                doc_max: chunk_doc_max,
            _ => return false,
/// k-way-merges sorted chunks at finalize, RGs within a segment are in lead
        )
/// One contiguous chunk of row groups within a single segment.
            chunk_doc_min = chunk_doc_max;
/// the rest of `SegmentFileInfo`. Public so unit tests can call it without
    let mut chunk_rg_indices: Vec<usize> = Vec::new();
            hi.map(|v| ScalarValue::Int64(Some(v))),
pub struct PartitionAssignment {
/// `(sort_min, sort_max)` pairs directly — the chain logic is independent of
/// `sort_min`, every segment's `sort_min` is strictly greater than the previous
    }
        .iter()
/// - `sort_fields` is non-empty,
        return Vec::new();
            Some(std::cmp::Ordering::Greater) => continue,
        // Segments arrive in non-sorted order; the helper must sort them itself.
            chunk_rg_indices.clear();
/// Produces one `PartitionAssignment` per segment, ordered by `sort_min`
        .collect();
        let last = layout.row_groups.last().unwrap();
        }
//! 1. Splitting mid-RG causes duplicate processing.
            chunk_doc_min = rg.first_row as i32;
        let bounds = [s(Some(1), Some(10)), s(None, Some(20))];
        assignments.push(PartitionAssignment {
    fn s(lo: Option<i64>, hi: Option<i64>) -> (Option<ScalarValue>, Option<ScalarValue>) {
    fn single_segment_with_stats_chains_trivially() {
pub fn segments_chain_on_sort_key(segments: &[SegmentFileInfo]) -> bool {
                current_chunks.push(SegmentChunk {
        // Flush in-progress chunk if segment changed
pub fn compute_assignments_one_per_segment(
        return false;
        let bounds = [s(Some(1), Some(10))];
        assert!(!chain_on_sort_bounds(&bounds));
        }
            })
    }
    }
    // Order segments by sort_min — bail to existing partitioning if anything
    #[test]
    assignments
            current_rows = 0;
/// applied at the segment-within-a-shard granularity.
