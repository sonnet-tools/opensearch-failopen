        assert!(!c.listing_table_pushdown_filters);
    pub fn target_partitions(mut self, v: usize) -> Self {
    }
        }
        self.0
    }
#[repr(C)]
        assert!(!InternalSearch::Off.is_internal_search());
//! setup time and copied into hot-path fields — never dereferenced on a
        Self {
    /// Backed by the `datafusion.indexed.force_strategy` cluster setting.
    /// -1 = None, 0 = RowSelection, 1 = BooleanMask.
mod tests {
    fn wire_decode_round_trips_all_fields() {
    SeqNoAbove(i64),
    }
        assert_eq!(
            min_skip_run_default: w.min_skip_run_default as usize,
/// Engine-internal point lookup driven through the normal `df_execute_query`
        self
            indexed_pushdown_filters: 1,
    pub unsafe fn from_ffm_ptr(ptr: i64) -> Self {
        self.0.prefer_hash_join = v;
        assert_eq!(c.target_partitions, 8);
            prefer_hash_join: w.prefer_hash_join != 0,
            cost_predicate: 3,
    pub cost_predicate: u32,
        self.0.min_skip_run_selectivity_threshold = v;
    #[test]
        assert_eq!(c.cost_predicate, 3);
    /// the normal user-search path).
//! per-batch or per-row hot path.
            force_strategy: -1,
pub struct WireDatafusionQueryConfig {
    pub fn prefer_hash_join(mut self, v: bool) -> Self {
    pub fn listing_table_pushdown_filters(mut self, v: bool) -> Self {
                1 => Some(FilterStrategy::BooleanMask),
            InternalSearch::ByRowId(42)
        Self {
    /// Whether the physical planner prefers a hash join over a sort-merge join for equi-joins
        assert!(InternalSearch::SeqNoAbove(0).is_internal_search());
/// produce the same byte layout on all target platforms. Enum-ish
    pub min_skip_run_default: usize,
    fn test_default_matches_legacy_constants() {
        match mode {
            min_skip_run_selectivity_threshold: 0.03,
        let ptr = &wire as *const _ as i64;
    pub cost_collector: u32,
            listing_table_pushdown_filters: 0,
            ptr != 0,
    pub prefer_hash_join: i32,
    /// wiring is incomplete.
    use super::*;
    /// Decodes the FFM wire pair `(mode, bound)`. `mode`: 0 = Off, 1 = ByRowId,
    /// letting selectivity decide. Backed by the `datafusion.indexed.force_strategy`
            listing_table_pushdown_filters: w.listing_table_pushdown_filters != 0,
impl DatafusionQueryConfigBuilder {
        };
    fn wire_decode_force_fields_none_sentinels() {
            indexed_pushdown_filters: w.indexed_pushdown_filters != 0,
        assert!(
            cost_collector: w.cost_collector as u32,
    #[test]
    #[test]
        let c = unsafe { DatafusionQueryConfig::from_ffm_ptr(ptr) };
    }
    }
impl InternalSearch {
/// `Option<_>` fields are encoded with a `-1` sentinel for `None`.
    }
            2 => InternalSearch::SeqNoAbove(bound),
    pub cost_collector: i32,
    ///
        let wire = WireDatafusionQueryConfig {
/// FFM wire format. Must stay in lockstep with the Java `MemoryLayout`.
//! Populated from Java (cluster / index / request settings) and passed to
            min_skip_run_selectivity_threshold: 0.03,
        assert!(!c.prefer_hash_join);
    }
    }
    pub fn builder() -> DatafusionQueryConfigBuilder {
            min_skip_run_default: 1024,
    #[test]
            cost_predicate: 1,
    /// whose memory is live for the duration of this call.
        self
            prefer_hash_join: true,
            InternalSearch::from_wire(2, 7),
            batch_size: 8192,
    fn from_wire(w: &WireDatafusionQueryConfig) -> Self {
    fn new() -> Self {
    /// `true` everywhere else preserves the hash-join default.
    }
            listing_table_pushdown_filters: false,
        let wire = &*(ptr as *const WireDatafusionQueryConfig);
            cost_predicate: 1,
    /// Seq-no scan: `_seq_no > bound`, projecting only id/seq/term/version.
impl DatafusionQueryConfig {
        assert!((c.min_skip_run_selectivity_threshold - 0.03).abs() < 1e-9);
        assert!(InternalSearch::ByRowId(0).is_internal_search());
    /// Production code should use `from_ffm_ptr` with a real wire config.
        );
        self.0.batch_size = v;
    }
    }
        assert!(c.listing_table_pushdown_filters);
    pub fn batch_size(mut self, v: usize) -> Self {
    /// Whether this is an engine-internal point lookup (i.e. not [`InternalSearch::Off`],
        };
    /// Not an internal lookup — decode `plan_ptr` as Substrait as usual.
    pub listing_table_pushdown_filters: bool,
//!
    pub fn force_strategy(mut self, v: Option<FilterStrategy>) -> Self {
    /// today: the coordinator sets it `false` for a large-build worker join so DataFusion emits a
//! Per-query tuning knobs shared by the vanilla and indexed query paths.
    Off,
            1 => InternalSearch::ByRowId(bound),
            force_strategy: 1,
        assert_eq!(InternalSearch::from_wire(0, 99), InternalSearch::Off);
    /// 0 = false, 1 = true
    // Indexed-only
            InternalSearch::SeqNoAbove(7)
    pub fn cost_predicate(mut self, v: u32) -> Self {
/// a stored reserved column — no Substrait, no planner round-trip. Used by the
    pub listing_table_pushdown_filters: i32,
        let c = DatafusionQueryConfig::test_default();
        );
            cost_collector: 10,
    pub indexed_pushdown_filters: i32,
            cost_predicate: w.cost_predicate as u32,
    pub batch_size: i64,
        self
}
    pub fn is_internal_search(self) -> bool {
            force_strategy: match w.force_strategy {
pub enum InternalSearch {
        let ptr = &wire as *const _ as i64;
                _ => None,
        let c = unsafe { DatafusionQueryConfig::from_ffm_ptr(ptr) };
pub struct DatafusionQueryConfigBuilder(DatafusionQueryConfig);
    }
    /// 0 = false (prefer sort-merge join), 1 = true (prefer hash join). See
    }
/// pluggable-dataformat get-by-id path (`GetService`), not by user search.
    /// 0 = false, 1 = true
    }
            target_partitions: 8,
    // Common
    /// [`DatafusionQueryConfig::prefer_hash_join`].
    /// (DataFusion's `optimizer.prefer_hash_join`). Only consulted on hash-shuffle WORKER sessions
///
    }
    fn wire_decode_null_pointer_panics() {
#[derive(Debug, Copy, Clone)]
    pub fn indexed_pushdown_filters(mut self, v: bool) -> Self {
        self.0.cost_collector = v;
            listing_table_pushdown_filters: 1,
}
        assert_eq!(
    /// `RowSelection`/`BooleanMask` pin the choice node-wide. See
        self.0.min_skip_run_default = v;
            target_partitions: 4,
    }
    /// Production code should always supply a real config via the wire
    }
    pub fn min_skip_run_default(mut self, v: usize) -> Self {
            _ => InternalSearch::Off,
        assert!(c.prefer_hash_join);
#[cfg(test)]
        self
            // (selectivity heuristic decides).
    pub min_skip_run_selectivity_threshold: f64,
        self
        }
    /// Whether IndexedStream asks parquet to apply the residual predicate
    /// Get-by-row-id: `__row_id__ = bound`, single row. `bound` is the physical
        self.0.cost_predicate = v;
        self
            batch_size: 8192,
        self.0.listing_table_pushdown_filters = v;
    /// DataFusion's own decode-time predicate pushdown on the ListingTable path.
        assert_eq!(c.cost_collector, 10);
    /// # Panics
    }
//! Rust once at query start via a `#[repr(C)]` wire struct. Read out at
        self.0.target_partitions = v;
    /// Constructor with sensible defaults for tests and benchmarks.
    }
use crate::indexed_table::stream::FilterStrategy;
            min_skip_run_default: 512,
    pub target_partitions: usize,
            target_partitions: 4,
}
}
            prefer_hash_join: 1,
        assert_eq!(c.force_strategy, None);
    pub fn build(self) -> DatafusionQueryConfig {
    /// `ptr` must be a valid, non-zero pointer to a `WireDatafusionQueryConfig`
    pub fn cost_collector(mut self, v: u32) -> Self {
        assert_eq!(InternalSearch::from_wire(3, 5), InternalSearch::Off);
        Self::fallback()
/// All fields have fixed sizes and natural alignment so Java and Rust
        DatafusionQueryConfigBuilder::new()
        let wire = WireDatafusionQueryConfig {
            indexed_pushdown_filters: 0,
}
    pub cost_predicate: i32,
        assert!(c.indexed_pushdown_filters);
    #[cfg(test)]
    /// spillable `SortMergeJoinExec` instead of the non-spillable `HashJoinExec` build.
    ///
        Self(DatafusionQueryConfig::fallback())
    /// Panics if `ptr` is 0 (null). Java must always supply a valid config pointer.
        self
    /// Fallback values used when Java passes a null config pointer (0).
    /// selections benefit; block-granular ones don't.
                0 => Some(FilterStrategy::RowSelection),
            "from_ffm_ptr: null query config pointer — Java must always provide a valid config"
}
        }
            force_strategy: None,
/// entry point. When active, the Substrait `plan_ptr` is ignored and the plan
    pub target_partitions: i64,
    #[should_panic(expected = "null query config pointer")]
        assert_eq!(c.target_partitions, 4);
    pub fn test_default() -> Self {
    fn internal_search_from_wire_decodes_modes() {
            cost_collector: 17,
    fn fallback() -> Self {
            min_skip_run_selectivity_threshold: w.min_skip_run_selectivity_threshold,
        !matches!(self, InternalSearch::Off)
        assert_eq!(c.min_skip_run_default, 1024);
            batch_size: w.batch_size as usize,
#[derive(Debug, Clone)]
            prefer_hash_join: 0,
        // Unknown modes are forward-compatible: treated as Off, bound ignored.
/// is built natively via the DataFrame API with a single pushed-down filter on
    pub min_skip_run_default: i64,
        assert_eq!(c.cost_predicate, 1);
    }
        self
        self
    }
            target_partitions: w.target_partitions as usize,
    pub force_strategy: Option<FilterStrategy>,
    }
    /// Returns a builder seeded with fallback defaults for test usage.
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
        assert!((c.min_skip_run_selectivity_threshold - 0.07).abs() < 1e-9);
    pub indexed_pushdown_filters: bool,
        assert_eq!(c.batch_size, 8192);
            cost_collector: 10,
    /// # Safety
        assert_eq!(c.force_strategy, Some(FilterStrategy::BooleanMask));
/// Query-scoped configuration. Owned by value after FFM decode.
        self
#[cfg(test)]
    /// Used by version-map restore on crash recovery.
pub struct DatafusionQueryConfig {
        assert_eq!(c.min_skip_run_default, 512);
            },
            min_skip_run_selectivity_threshold: 0.07,
    pub min_skip_run_selectivity_threshold: f64,
    ByRowId(i64),
    /// row position resolved from the secondary (Lucene) index.
        assert_eq!(c.force_strategy, None);
    }
    /// 2 = SeqNoAbove. Any other value is treated as Off (forward-compatible).
            InternalSearch::from_wire(1, 42),
}
    /// cluster setting: `None` (wire `-1`) lets the selectivity heuristic run,
    #[test]
        assert_eq!(c.cost_collector, 17);
        );
        assert!(!c.indexed_pushdown_filters);
        assert_eq!(c.batch_size, 16384);
    pub batch_size: usize,
        Self::from_wire(wire)
        self.0.indexed_pushdown_filters = v;
            min_skip_run_default: 1024,
    /// Optional override that pins the per-RG `min_skip_run` choice instead of
    // Single query concurrency
    }
            batch_size: 16384,
    pub fn min_skip_run_selectivity_threshold(mut self, v: f64) -> Self {
            indexed_pushdown_filters: true,
    /// Decode from a raw FFM pointer.
    /// during decode (via `RowFilter` pushdown). Narrow row-granular
    pub force_strategy: i32,
            // `force_strategy` is backed by a cluster setting; `-1` means None
        self.0.force_strategy = v;
    /// `IndexedStream::pick_min_skip_run`.
    /// struct; this exists only for the transitional period while Java
    pub fn from_wire(mode: i64, bound: i64) -> Self {
    pub prefer_hash_join: bool,
        unsafe { DatafusionQueryConfig::from_ffm_ptr(0) };
#[cfg(test)]
