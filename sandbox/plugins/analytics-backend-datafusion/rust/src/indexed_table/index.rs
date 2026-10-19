    /// Create a collector for a specific segment and doc ID range.
/// rely on this — e.g. `IndexedStream` skips filter-bitset fetch on empty
/// cheap to bind to individual segments via [`collector`].
//!   └── RowGroupDocsCollector (per-segment matcher — once per segment)
use std::sync::Arc;
        writer_generation: i64,
    fn collector(
/// [`collect_packed_u64_bitset`](Self::collect_packed_u64_bitset) returns a
pub trait RowGroupDocsCollector: Send + Sync + Debug {
///
 * The OpenSearch Contributors require contributions made to
    fn from(words: Vec<u64>) -> Self {
/// If `max_doc <= min_doc`, implementations MUST return `Ok(Vec::new())`
//! These traits are all `IndexedExec`/`IndexedStream` need. How the searcher
///   clamp by relative position before using a bit.
    /// compiled query this searcher represents.
///
 */
/// - Length is `ceil((max_doc - min_doc) / 64)` words. The last word may
impl From<Vec<u64>> for CollectDocsResult {
 *
 * SPDX-License-Identifier: Apache-2.0
}
    ) -> Result<CollectDocsResult, String>;
        }
    fn collect_packed_u64_bitset(
/// A searcher scoped to a single shard (index), created once per query.
 * compatible open source license.
    ///
    /// The packed u64 bitset of matching docs within the requested range.
/// word-packed bitset matching Lucene's `FixedBitSet.getBits()` exactly:
    /// Number of segments in this shard.
        doc_max: i32,
///
//! irrelevant here.
/// # Empty-range contract
}
    pub next_doc: i32,
        min_doc: i32,
//!          └── collect_packed_u64_bitset(range) → Vec<u64>
    /// per segment per query, cheap to construct from the shard-scoped
use std::fmt::Debug;
/// # Bit layout contract
///   `min_doc + j*64 + i`.
}
//! ShardSearcher (shard-scoped compiled query — once per shard)
/// A collector that retrieves matching doc IDs as a packed bitset for a row
///   doc at relative position `j*64 + i`, i.e. absolute doc ID
        max_doc: i32,
    pub words: Vec<u64>,
    fn segment_count(&self) -> usize;
#[derive(Debug, Clone)]
    /// The next matching doc ID beyond `max_doc`, or `i32::MAX` if exhausted.
/// May be called multiple times with increasing ranges (forward-only iteration).
/// - Bit `i` of word `j` (i.e. `word & (1u64 << i) != 0`) represents the
pub struct CollectDocsResult {
/// - Word `j` covers the 64 doc-id-relative positions `j*64 .. (j+1)*64`.
//! Core index traits — the contract between the index and the query engine.
///   have unused high bits set past `max_doc - min_doc`; consumers MUST
        &self,
        doc_min: i32,
    /// Callers can use this to skip subsequent RGs where `next_doc >= rg_max`.
//! ```
 * this file be licensed under the Apache-2.0 license or a
}
/*
/// Represents a shard-scoped compiled form of the query — typically expensive
/// Result of a `collect_packed_u64_bitset` call.
            words,
///
//! ```text
/// row groups by calling with `max_doc == min_doc`.
    ) -> Result<Arc<dyn RowGroupDocsCollector>, String>;
///
/// to build (parses query, compiles automata / prepares iterators, etc.) but
///
        &self,
//!
///
        CollectDocsResult {
/// group's doc-id range within a segment.
//! was created (FFM upcall to Java, in-process native index, test stub) is
    /// The collector only returns docs in `[doc_min, doc_max)`. One collector
/// (zero-length bitset). This is a no-op case and must not error. Callers
    }
//!
pub trait ShardSearcher: Send + Sync + Debug {
    fn segment_max_doc(&self, writer_generation: i64) -> Result<i64, String>;
    /// Max doc ID for a specific segment, identified by writer generation.
            next_doc: i32::MIN,
