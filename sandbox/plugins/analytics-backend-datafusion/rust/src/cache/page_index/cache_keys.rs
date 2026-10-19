/// itself, after our load — so a column's OffsetIndex must always cover all RGs
/// Both scan paths resolve the same `(file, col, rg)` for the same logical
    pub(crate) col: usize,
}
///
 * this file be licensed under the Apache-2.0 license or a
#[derive(Clone, PartialEq, Eq, Hash, Debug)]
impl Display for OiCellKey {
use std::sync::Arc;
 *
/// columns a query filters on, or which literal a predicate uses. Keying at the
        write!(f, "{}:{}:{}", self.path, self.col, self.rg)
/// (an empty entry on a scanned RG panics / breaks reads). RG can therefore never
/// only on `(file, col)`, so any query that reads a column reuses its offset
    }
}
/// value is that column's `OffsetIndexMetaData` for **every** row group (a
/// OffsetIndex cache key — one decoded value per `(file, column)`, where the
/// time for any RG DataFusion chooses to scan — and DataFusion picks that set
pub(crate) struct CiCellKey {
/// request, so cells are shared across paths → cross-path sharing.
/// with query diversity, not schema width.)
/// be a key axis here; the cell is the whole-column, all-RG offset index. Keyed
/// of [`OFFSET_INDEX_CACHE`].
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
 */
/// `Vec` indexed by RG). Unlike the ColumnIndex, the OffsetIndex is read at scan
/// One column's OffsetIndex across all row groups (indexed by RG). The value type
pub(crate) struct OiCellKey {
impl Display for CiCellKey {
/*
//! Cache key types for the two scoped page-index caches.
use parquet::file::page_index::offset_index::OffsetIndexMetaData;
/// re-stored a column for every distinct predicate/RG combination — storage grew
/// surviving-row-group *set*. (The prior set-keyed design re-decoded and
#[derive(Clone, PartialEq, Eq, Hash, Debug)]
/// intrinsic property of the file: it is identical no matter which *other*
/// `(file, column, row-group)`. The page index for a given column+RG is an
/// index irrespective of projection or predicate.
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
/// stored **once per file**, then reused by every query whose predicate touches
/// ColumnIndex cache key — one decoded `ColumnIndexMetaData` **cell** per
    pub(crate) col: usize,
}
    pub(crate) path: Arc<str>,
    pub(crate) path: Arc<str>,
 * SPDX-License-Identifier: Apache-2.0
/// that column — regardless of the predicate-column *combination* or the
/// cell granularity means a column's per-page string min/max is decoded and
        write!(f, "{}:{}", self.path, self.col)
use std::fmt::Display;
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
    pub(crate) rg: usize,
pub(crate) type OiColumn = Vec<OffsetIndexMetaData>;
    }
}
