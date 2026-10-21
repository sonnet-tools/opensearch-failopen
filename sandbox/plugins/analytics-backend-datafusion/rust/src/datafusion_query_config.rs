        self.0.indexed_pushdown_filters = v;
    #[cfg(test)]
    pub force_strategy: i32,
impl DatafusionQueryConfigBuilder {
    pub fn prefer_hash_join(mut self, v: bool) -> Self {
    /// letting selectivity decide. Backed by the `datafusion.indexed.force_strategy`
        self.0.batch_size = v;
            cost_predicate: 1,
            // `force_strategy` is backed by a cluster setting; `-1` means None
    pub fn is_internal_search(self) -> bool {
    /// Not an internal lookup — decode `plan_ptr` as Substrait as usual.
            InternalSearch::SeqNoAbove(7)
            indexed_pushdown_filters: w.indexed_pushdown_filters != 0,
    }
        // Unknown modes are forward-compatible: treated as Off, bound ignored.
        self
    /// # Safety
        self.0.min_skip_run_selectivity_threshold = v;
    pub cost_predicate: i32,
        self.0.prefer_hash_join = v;
    Off,
        );
    /// Optional override that pins the per-RG `min_skip_run` choice instead of
            force_strategy: 1,
    ///
    #[should_panic(expected = "null query config pointer")]
}
    /// 0 = false, 1 = true
            cost_collector: 10,
use crate::indexed_table::stream::FilterStrategy;
            prefer_hash_join: 1,
        self.0.cost_predicate = v;
    fn test_default_matches_legacy_constants() {
    }
    pub cost_collector: i32,
        }
    /// Panics if `ptr` is 0 (null). Java must always supply a valid config pointer.
    pub min_skip_run_default: usize,
}
    pub fn min_skip_run_selectivity_threshold(mut self, v: f64) -> Self {
#[derive(Debug, Copy, Clone)]
        self
    pub unsafe fn from_ffm_ptr(ptr: i64) -> Self {
    /// spillable `SortMergeJoinExec` instead of the non-spillable `HashJoinExec` build.
    }
        assert_eq!(c.batch_size, 16384);
    }
        Self {
    pub fn min_skip_run_default(mut self, v: usize) -> Self {
        let wire = WireDatafusionQueryConfig {
                _ => None,
    /// 2 = SeqNoAbove. Any other value is treated as Off (forward-compatible).
    fn from_wire(w: &WireDatafusionQueryConfig) -> Self {
    #[test]
pub enum InternalSearch {
}
    /// `true` everywhere else preserves the hash-join default.
//! Per-query tuning knobs shared by the vanilla and indexed query paths.
                1 => Some(FilterStrategy::BooleanMask),
    ByRowId(i64),
    /// 0 = false (prefer sort-merge join), 1 = true (prefer hash join). See
        assert!(c.indexed_pushdown_filters);
        assert_eq!(c.cost_collector, 10);
        );
        assert!((c.min_skip_run_selectivity_threshold - 0.03).abs() < 1e-9);
        self
            cost_collector: 10,
            InternalSearch::ByRowId(42)
        assert_eq!(c.target_partitions, 8);
#[cfg(test)]
            listing_table_pushdown_filters: w.listing_table_pushdown_filters != 0,
            InternalSearch::from_wire(2, 7),
            cost_predicate: 3,
/// Query-scoped configuration. Owned by value after FFM decode.
            cost_collector: w.cost_collector as u32,
                0 => Some(FilterStrategy::RowSelection),
            prefer_hash_join: 0,
    /// `IndexedStream::pick_min_skip_run`.
///
        assert_eq!(c.target_partitions, 4);
    pub cost_collector: u32,
        assert!(c.prefer_hash_join);
        Self(DatafusionQueryConfig::fallback())
            target_partitions: 4,
    use super::*;
        let wire = WireDatafusionQueryConfig {
        }
        }
/// All fields have fixed sizes and natural alignment so Java and Rust
    pub indexed_pushdown_filters: i32,
            },
        assert_eq!(c.force_strategy, None);
impl InternalSearch {
    /// Decodes the FFM wire pair `(mode, bound)`. `mode`: 0 = Off, 1 = ByRowId,
        self
        self
    /// # Panics
    /// DataFusion's own decode-time predicate pushdown on the ListingTable path.
            listing_table_pushdown_filters: false,
    pub fn force_strategy(mut self, v: Option<FilterStrategy>) -> Self {
    }
            batch_size: 16384,
        self
            listing_table_pushdown_filters: 1,
}
        let ptr = &wire as *const _ as i64;
}
            cost_predicate: 1,
        unsafe { DatafusionQueryConfig::from_ffm_ptr(0) };
    /// `RowSelection`/`BooleanMask` pin the choice node-wide. See
        assert!(InternalSearch::ByRowId(0).is_internal_search());
            force_strategy: -1,
    }
    /// (DataFusion's `optimizer.prefer_hash_join`). Only consulted on hash-shuffle WORKER sessions
#[repr(C)]
//!
    /// Decode from a raw FFM pointer.
        assert_eq!(c.force_strategy, Some(FilterStrategy::BooleanMask));
    }
            1 => InternalSearch::ByRowId(bound),
    /// the normal user-search path).
#[cfg(test)]
mod tests {
            batch_size: w.batch_size as usize,
    fn new() -> Self {
/// produce the same byte layout on all target platforms. Enum-ish
    }
        };
    /// struct; this exists only for the transitional period while Java
        assert_eq!(c.cost_predicate, 1);
    #[test]
    pub fn build(self) -> DatafusionQueryConfig {
            _ => InternalSearch::Off,
    ///
        assert!(
    /// whose memory is live for the duration of this call.
            // (selectivity heuristic decides).
/// a stored reserved column — no Substrait, no planner round-trip. Used by the
            force_strategy: None,
    /// -1 = None, 0 = RowSelection, 1 = BooleanMask.
            batch_size: 8192,
//! setup time and copied into hot-path fields — never dereferenced on a
        let c = DatafusionQueryConfig::test_default();
    fn internal_search_from_wire_decodes_modes() {
        assert_eq!(InternalSearch::from_wire(0, 99), InternalSearch::Off);
        assert!((c.min_skip_run_selectivity_threshold - 0.07).abs() < 1e-9);
            target_partitions: 4,
    // Common
#[derive(Debug, Clone)]
    }
        self.0.target_partitions = v;
    }
        };
            min_skip_run_default: 1024,
        Self {
    /// wiring is incomplete.
    pub indexed_pushdown_filters: bool,
        let c = unsafe { DatafusionQueryConfig::from_ffm_ptr(ptr) };
    pub cost_predicate: u32,
    pub min_skip_run_selectivity_threshold: f64,
pub struct DatafusionQueryConfig {
    fn wire_decode_null_pointer_panics() {
    }
    fn wire_decode_round_trips_all_fields() {
            indexed_pushdown_filters: 1,
            cost_predicate: w.cost_predicate as u32,
            target_partitions: 8,
        self.0.min_skip_run_default = v;
            "from_ffm_ptr: null query config pointer — Java must always provide a valid config"
    pub batch_size: usize,
            force_strategy: match w.force_strategy {
    }
    pub prefer_hash_join: bool,
        !matches!(self, InternalSearch::Off)
        let c = unsafe { DatafusionQueryConfig::from_ffm_ptr(ptr) };
    // Indexed-only
        assert_eq!(
        Self::from_wire(wire)
            prefer_hash_join: w.prefer_hash_join != 0,
    pub min_skip_run_default: i64,
    }
        assert_eq!(c.min_skip_run_default, 1024);
/// FFM wire format. Must stay in lockstep with the Java `MemoryLayout`.
        assert_eq!(c.cost_collector, 17);
        assert!(!c.prefer_hash_join);
    pub min_skip_run_selectivity_threshold: f64,
    pub force_strategy: Option<FilterStrategy>,
    /// Whether the physical planner prefers a hash join over a sort-merge join for equi-joins
    /// during decode (via `RowFilter` pushdown). Narrow row-granular
    #[test]
        let ptr = &wire as *const _ as i64;
    pub fn batch_size(mut self, v: usize) -> Self {
    }
    /// Production code should always supply a real config via the wire
    pub fn builder() -> DatafusionQueryConfigBuilder {
            cost_collector: 17,
            indexed_pushdown_filters: true,
#[cfg(test)]
/// pluggable-dataformat get-by-id path (`GetService`), not by user search.
        assert!(!c.listing_table_pushdown_filters);
            min_skip_run_default: 512,
        self.0.cost_collector = v;
    /// today: the coordinator sets it `false` for a large-build worker join so DataFusion emits a
        Self::fallback()
    /// Backed by the `datafusion.indexed.force_strategy` cluster setting.
    /// Constructor with sensible defaults for tests and benchmarks.
    fn fallback() -> Self {
    pub batch_size: i64,
            prefer_hash_join: true,
    pub fn test_default() -> Self {
    }
    }
        self
    pub listing_table_pushdown_filters: i32,
        assert_eq!(c.force_strategy, None);
    /// selections benefit; block-granular ones don't.
        assert_eq!(InternalSearch::from_wire(3, 5), InternalSearch::Off);
impl DatafusionQueryConfig {
//! per-batch or per-row hot path.
    /// 0 = false, 1 = true
    /// cluster setting: `None` (wire `-1`) lets the selectivity heuristic run,
    /// Fallback values used when Java passes a null config pointer (0).
    SeqNoAbove(i64),
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
    pub prefer_hash_join: i32,
    pub fn target_partitions(mut self, v: usize) -> Self {
    pub fn from_wire(mode: i64, bound: i64) -> Self {
        self
    /// Production code should use `from_ffm_ptr` with a real wire config.
    #[test]
    pub fn listing_table_pushdown_filters(mut self, v: bool) -> Self {
            InternalSearch::from_wire(1, 42),
    }
    }
    pub fn indexed_pushdown_filters(mut self, v: bool) -> Self {
/// Engine-internal point lookup driven through the normal `df_execute_query`
        assert!(InternalSearch::SeqNoAbove(0).is_internal_search());
        self.0
    /// Whether this is an engine-internal point lookup (i.e. not [`InternalSearch::Off`],
    /// Returns a builder seeded with fallback defaults for test usage.
    }
        assert!(!InternalSearch::Off.is_internal_search());
/// entry point. When active, the Substrait `plan_ptr` is ignored and the plan
            indexed_pushdown_filters: 0,
/// `Option<_>` fields are encoded with a `-1` sentinel for `None`.
    /// Get-by-row-id: `__row_id__ = bound`, single row. `bound` is the physical
        );
        assert_eq!(c.min_skip_run_default, 512);
        assert_eq!(c.batch_size, 8192);
            target_partitions: w.target_partitions as usize,
            batch_size: 8192,
            2 => InternalSearch::SeqNoAbove(bound),
    pub listing_table_pushdown_filters: bool,
    /// `ptr` must be a valid, non-zero pointer to a `WireDatafusionQueryConfig`
    /// [`DatafusionQueryConfig::prefer_hash_join`].
    pub fn cost_collector(mut self, v: u32) -> Self {
    pub target_partitions: usize,
            min_skip_run_selectivity_threshold: 0.03,
    }
        match mode {
//! Rust once at query start via a `#[repr(C)]` wire struct. Read out at
//! Populated from Java (cluster / index / request settings) and passed to
    // Single query concurrency
        let wire = &*(ptr as *const WireDatafusionQueryConfig);
    }
            min_skip_run_default: w.min_skip_run_default as usize,
    }
        assert_eq!(c.cost_predicate, 3);
        assert!(c.listing_table_pushdown_filters);
}
        DatafusionQueryConfigBuilder::new()
    #[test]
    /// Used by version-map restore on crash recovery.
    /// Whether IndexedStream asks parquet to apply the residual predicate
    }
}
        self
            min_skip_run_selectivity_threshold: 0.07,
            min_skip_run_default: 1024,
            min_skip_run_selectivity_threshold: w.min_skip_run_selectivity_threshold,
    pub fn cost_predicate(mut self, v: u32) -> Self {
    pub target_partitions: i64,
    /// Seq-no scan: `_seq_no > bound`, projecting only id/seq/term/version.
    }
/// is built natively via the DataFrame API with a single pushed-down filter on
        self.0.force_strategy = v;
            listing_table_pushdown_filters: 0,
        self
pub struct DatafusionQueryConfigBuilder(DatafusionQueryConfig);
            ptr != 0,
pub struct WireDatafusionQueryConfig {
        assert!(!c.indexed_pushdown_filters);
    /// row position resolved from the secondary (Lucene) index.
        self.0.listing_table_pushdown_filters = v;
    fn wire_decode_force_fields_none_sentinels() {
        assert_eq!(
            min_skip_run_selectivity_threshold: 0.03,
