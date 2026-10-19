    let mut chunk_rg_indices: Vec<usize> = Vec::new();
                doc_min,
            }),
#[derive(Debug, Clone)]
        current_chunks.push(SegmentChunk {
            })
        return false;
            _ => return false,
            }
    num_partitions: usize,
//!
        .iter()
 * this file be licensed under the Apache-2.0 license or a
                doc_max: chunk_doc_max,
                current_chunks.push(SegmentChunk {
        .collect();
 * compatible open source license.
}
    order.sort_by(|&a, &b| {
) -> Vec<PartitionAssignment> {
        match (segments[a].sort_min.as_ref(), segments[b].sort_min.as_ref()) {
//! Reference: <https://github.com/apache/datafusion/blob/49776a6/datafusion/datasource/src/file_groups.rs#L204>
    let rows_per_partition = (total_rows as f64 / num_partitions as f64).ceil() as i64;
pub struct PartitionAssignment {
    fn empty_input_returns_false() {
            (Some(la), Some(lb)) => la.partial_cmp(lb).unwrap_or_else(|| {
    let mut assignments: Vec<PartitionAssignment> = Vec::new();
            chunk_rg_indices.clear();
            segment_idx: chunk_seg.unwrap(),
}
/// - `target_partitions >= segments.len()` (so the optimizer's
/// Empty input → `false` (nothing to advertise).
    segments: &[SegmentLayout],
/// Returns `false` when:
            s(Some(1), Some(10)),
        let bounds = [s(Some(1), Some(15)), s(Some(10), Some(20))];
//! 2. Row indices within a RG are contiguous `[0, num_rows)`.
    fn s(lo: Option<i64>, hi: Option<i64>) -> (Option<ScalarValue>, Option<ScalarValue>) {
    let mut chunk_seg: Option<usize> = None;
/// the row-count-balanced `compute_assignments`.
        (
    pub chunks: Vec<SegmentChunk>,
                std::cmp::Ordering::Equal
    let mut chunk_doc_max: i32 = 0;
        return compute_assignments(layouts, segments.len().max(1));
    if segments.is_empty() {
/// Whether segments form a sorted chain on the lead `index.sort.field` column,
//! accumulated rows exceed `ceil(total_rows / num_partitions)`.
//!
pub fn compute_assignments(
    let mut order: Vec<usize> = (0..refs.len()).collect();
        .flat_map(|(seg_idx, seg)| {
    }
//!
            std::cmp::Ordering::Equal
        assert!(!chain_on_sort_bounds(&bounds));
/// - `sort_fields` is non-empty,
/// k-way-merges sorted chunks at finalize, RGs within a segment are in lead
/// `sort_min`, every segment's `sort_min` is strictly greater than the previous
/// segment's `sort_max`. Same algorithm as DataFusion's
///
use super::table_provider::SegmentFileInfo;
/// Compute partition assignments aligned to row group boundaries.
        // Flush in-progress chunk if segment changed
        current_rows += rg.num_rows;
        .enumerate()
}
                doc_max,
    let mut incomparable = false;
) -> Vec<PartitionAssignment> {
            // invariant is broken; preserve original order rather than panic.
    #[test]
    let total_rows: i64 = all_rgs.iter().map(|rg| rg.num_rows).sum();
            lo.map(|v| ScalarValue::Int64(Some(v))),
        if current_rows >= rows_per_partition && assignments.len() < num_partitions - 1 && !is_last
    }
        let doc_min = first.first_row as i32;
    }
    }
    }
    #[test]
    order.sort_by(|&a, &b| {
    for (lo, hi) in bounds {
pub fn compute_assignments_one_per_segment(
            chunks: vec![SegmentChunk {
//! Ported verbatim from PR #21164.
    let all_rgs: Vec<RGEntry> = segments
    }
        {
    order.sort_by(|&a, &b| {
    // Collect (min, max) for each segment; bail on the first None.
        });
}
                segment_idx: seg_idx,
    if incomparable {
    // Order segments by sort_min — bail to existing partitioning if anything
        return false;
        assignments.push(PartitionAssignment {
            });
        })
    use datafusion::common::ScalarValue;
        // partitioning so we don't produce an unsorted-but-claimed-sorted plan.
    true
    #[test]
#[cfg(test)]
/// One-partition-per-segment assignment for the sort-aware path.
        });
        // Segments arrive in non-sorted order; the helper must sort them itself.
    for w in order.windows(2) {
/// - `partial_cmp` returns `None` (incomparable types).
        let curr_min = refs[w[1]].0;
//!
            std::cmp::Ordering::Equal
            });
        match curr_min.partial_cmp(prev_max) {
    let mut bounds: Vec<(&ScalarValue, &ScalarValue)> = Vec::with_capacity(segments.len());
    if bounds.is_empty() {
    let mut current_rows: i64 = 0;
    });
//! Partition assignment for distributing row groups across DataFusion partitions.
                    doc_max: chunk_doc_max,
    }
                rg_index: rg.index,
        assert!(!chain_on_sort_bounds(&bounds));
        first_row: i64,
        assert!(chain_on_sort_bounds(&bounds));
/// One contiguous chunk of row groups within a single segment.
/// constructing a full `ParquetMetaData`.
pub struct SegmentLayout {
    if incomparable {
///
        if chunk_seg.is_some() && chunk_seg != Some(rg.segment_idx) {
            hi.map(|v| ScalarValue::Int64(Some(v))),
    fn touching_boundary_is_overlap() {
                    doc_min: chunk_doc_min,
    assignments
            incomparable = true;
    }
        let bounds = [
///
    true
            _ => return false,
                segment_idx: seg_idx,
 *
            (Some(lo), Some(hi)) => bounds.push((lo, hi)),
 */
            chunks: current_chunks,
    if !chunk_rg_indices.is_empty() {
        }
    if segments.is_empty() {
    segments: &[SegmentFileInfo],
        let curr_min = bounds[w[1]].0;
    let mut incomparable = false;
/// Produces one `PartitionAssignment` per segment, ordered by `sort_min`
///
        })
            }],
        }
        return false;
    let mut chunk_doc_min: i32 = 0;
        num_rows: i64,
    // Flush remaining
    }
                chunk_rg_indices.clear();
        // Equality at the boundary doesn't chain — strict > only, matches DataFusion.
            _ => {
}
        let last = layout.row_groups.last().unwrap();
/// determined from per-segment min/max footer stats: after sorting segments by
    if !current_chunks.is_empty() {
        rg_index: usize,
                row_group_indices: chunk_rg_indices.clone(),
        assert!(chain_on_sort_bounds(&bounds));
        if layout.row_groups.is_empty() {
                row_group_indices: rg_indices,
/// `is_ordering_valid_for_file_groups` (`file_scan_config.rs:1347-1363`),
//! Partitions MUST align to RG boundaries because:
                });
    }
        let doc_max = (last.first_row + last.num_rows) as i32;
    }
    let mut current_chunks: Vec<SegmentChunk> = Vec::new();
            // Equal/less means overlap; None means incomparable.
/// `(sort_min, sort_max)` pairs directly — the chain logic is independent of
        ];
//! a separate `SegmentChunk`.
                num_rows: rg.num_rows,
}
    use super::*;
    fn disjoint_chain_returns_true() {
        chunk_rg_indices.push(rg.rg_index);
    debug_assert_eq!(
//!
/// Caller must handle the case where this is inappropriate (chain doesn't
        refs[a].0.partial_cmp(refs[b].0).unwrap_or_else(|| {
/// - any pair has overlapping ranges,
pub(crate) fn chain_on_sort_bounds(bounds: &[(Option<ScalarValue>, Option<ScalarValue>)]) -> bool {
///   "can't prove a chain" — same as DataFusion's missing-stats handling),
    }
        segments.len(),
//! Same model as DataFusion's `repartition_evenly_by_size`: flatten all row
    fn overlapping_ranges_returns_false() {
                first_row: rg.first_row,
            Some(std::cmp::Ordering::Greater) => continue,
            Some(std::cmp::Ordering::Greater) => continue,
        assert!(!chain_on_sort_bounds(&[]));
        "segments and layouts must match (one entry per segment)"
    }
/// applied at the segment-within-a-shard granularity.
        chunk_doc_max = (rg.first_row + rg.num_rows) as i32;
    }
    fn single_segment_with_stats_chains_trivially() {
        match (lo, hi) {
            current_rows = 0;
    if all_rgs.is_empty() {
/// of that segment in their physical (sorted) order — because the writer
            doc_max: chunk_doc_max,
            row_group_indices: chunk_rg_indices,
            seg.row_groups.iter().map(move |rg| RGEntry {
        match (&seg.sort_min, &seg.sort_max) {
        assert!(!chain_on_sort_bounds(&bounds));
        segment_idx: usize,
        layouts.len(),
/// the rest of `SegmentFileInfo`. Public so unit tests can call it without
    );
            chunk_doc_min = chunk_doc_max;
//! 3. Doc IDs map 1:1 to row indices within each segment's parquet file.
    // Walk in sorted-by-min order: each segment's min must be > the previous segment's max.
    #[test]
        }
    pub doc_max: i32,
    let mut refs: Vec<(&ScalarValue, &ScalarValue)> = Vec::with_capacity(bounds.len());
    let mut assignments: Vec<PartitionAssignment> = Vec::with_capacity(segments.len());
            // If we got here without sort_min on every segment, caller's
//! 1. Splitting mid-RG causes duplicate processing.
///   `validated_output_ordering` chain check at `file_scan_config.rs:551`
        return vec![];
    });
        let bounds = [s(Some(1), Some(10)), s(Some(10), Some(20))];
        let first = layout.row_groups.first().unwrap();
        let bounds = [s(Some(1), Some(10)), s(None, Some(20))];
            s(Some(31), Some(40)),
    for w in order.windows(2) {
            incomparable = true;
    if incomparable {
                incomparable = true;
///   would accept the layout — vanilla path mirror).
/// hold, target_partitions too low, sort fields empty) by falling back to
        let layout = &layouts[seg_idx];
            continue;
/// sort-key order.
                incomparable = true;
        if chunk_seg != Some(rg.segment_idx) {
//! A single partition may span multiple segments — each segment's RGs become
/// ascending. Each assignment holds a single `SegmentChunk` covering all RGs
 * The OpenSearch Contributors require contributions made to
/// Info about a segment needed for partition assignment.
}
            s(Some(20), Some(30)),
        bounds[a].0.partial_cmp(bounds[b].0).unwrap_or_else(|| {
    }
mod chain_tests {
        match curr_min.partial_cmp(prev_max) {
            (Some(lo), Some(hi)) => refs.push((lo, hi)),
    }
#[derive(Debug, Clone)]
    });
        let prev_max = refs[w[0]].1;
use super::stream::RowGroupInfo;
    pub row_group_indices: Vec<usize>,
            chunk_seg = Some(rg.segment_idx);
use datafusion::common::ScalarValue;
        });
        let rg_indices: Vec<usize> = layout.row_groups.iter().map(|rg| rg.index).collect();
        // somehow we're here without comparable bounds, fall back to row-count
        }
        )
    for (i, rg) in all_rgs.iter().enumerate() {
                    segment_idx: chunk_seg.unwrap(),
        }
        }
        let bounds = [s(Some(1), Some(10))];
                segment_idx: chunk_seg.unwrap(),
            _ => return false,
    }
                chunks: std::mem::take(&mut current_chunks),
    }
                doc_min: chunk_doc_min,
    assignments
            if !chunk_rg_indices.is_empty() {
        let is_last = i == all_rgs.len() - 1;
 * SPDX-License-Identifier: Apache-2.0
        let prev_max = bounds[w[0]].1;
    }
            chunk_doc_min = rg.first_row as i32;
    layouts: &[SegmentLayout],
    struct RGEntry {
            }
    // Sort by min; bail if any pair is incomparable.
    #[test]
//! groups across all segments, iterate sequentially, cut a new partition when
        assignments.push(PartitionAssignment {
///
    for seg_idx in order {
    pub row_groups: Vec<RowGroupInfo>,
        })
            _ => return false,
/*
        }
    // is missing (defensive; caller is supposed to have checked already).
/// - `segments_chain_on_sort_key(...)` returned true,
    let mut order: Vec<usize> = (0..segments.len()).collect();
    let mut order: Vec<usize> = (0..bounds.len()).collect();
            current_chunks.push(SegmentChunk {
    pub segment_idx: usize,
    }
    #[test]
        }
        // Fail safe: caller is supposed to have run the chain check, but if
    }
    }
            doc_min: chunk_doc_min,
    let mut incomparable = false;
    pub doc_min: i32,
pub struct SegmentChunk {
    for seg in segments {
                    row_group_indices: chunk_rg_indices.clone(),
    }
        return false;
    fn missing_stats_returns_false() {
pub fn segments_chain_on_sort_key(segments: &[SegmentFileInfo]) -> bool {
        return Vec::new();
        }
}
#[cfg(test)]
/// A partition which can span multiple segments.
/// - any segment has `sort_min`/`sort_max` set to `None` (treated as
            assignments.push(PartitionAssignment {
/// Test-only variant of `segments_chain_on_sort_key` that takes the
/// Used when:
                std::cmp::Ordering::Equal
