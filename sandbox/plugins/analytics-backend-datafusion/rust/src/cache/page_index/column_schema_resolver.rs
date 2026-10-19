/// # Why the file's own schema, not the shared table schema
use arrow::datatypes::SchemaRef;
        // index matches `SchemaDescriptor::get_column_root_idx`; include every leaf
    file_schema: &SchemaRef,
    for name in predicate_column_names {
//! Predicate-column name → parquet leaf-index resolution.
    set.into_iter().collect()
}
/// gives a 1:1 field↔leaf correspondence for that file, so the resolved index
    predicate_column_names: &[String],
            for leaf_idx in 0..parquet_schema.num_columns() {
        resolve_with_schema(file_schema, metadata, predicate_col_names),
    metadata: &ParquetMetaData,
/// full schema reconstruction per file per query. Pure refactor — each returned
use datafusion::parquet::file::metadata::ParquetMetaData;
            set.insert(idx);
}
) -> Vec<usize> {
/// (`parquet_to_arrow_schema`) is the dominant cost of name→leaf resolution on
 * compatible open source license.
    let parquet_schema = metadata.file_metadata().schema_descr();
/// even when the file is missing columns (schema evolution).
/// the merged file has M leaves — the absent columns are all-null and not
pub(super) fn resolve_with_schema(
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
    _union_schema: &SchemaRef,
/// schema, via the same `StatisticsConverter` mapping DataFusion's pruner uses.
///
/// WRONG leaf in a M-leaf file. We would then build
    predicate_column_names: &[String],
/// Resolve predicate column names → parquet leaf indices against a specific arrow
        // `parquet_column()`: LIST/MAP/STRUCT roots may map to one or more physical
//!
 *
/// Resolve TWO name-sets (e.g. predicate columns and projection columns) against
/// indices, resolving against the file's OWN schema so the indices are correct
//! schema evolution (see [`resolve_predicate_parquet_columns`] for details).
        let resolved = StatisticsConverter::try_new(name, arrow_schema, parquet_schema)
        // OffsetIndex rather than a scoped-out placeholder.
        // parquet-rs intentionally does not resolve nested Arrow fields through
/// empty placeholder — and DataFusion's pruner, which resolves against the file's
use std::sync::Arc;
    arrow_schema: &SchemaRef,
 * SPDX-License-Identifier: Apache-2.0
///
    predicate_col_names: &[String],
    metadata: &ParquetMetaData,
use datafusion::parquet::arrow::arrow_reader::statistics::StatisticsConverter;
                }
/// written). Resolving against the N-field union therefore maps a column to the
/// files' columns [N]; a given file may physically contain fewer[M] (e.g.
    projection_col_names: &[String],
//! rather than the shared table schema to ensure correct leaf indices under
) -> (Vec<usize>, Vec<usize>) {
///
pub fn resolve_predicate_parquet_columns_pair(
            .and_then(|conv| conv.parquet_column_index());
        }
/// the scoped ColumnIndex/OffsetIndex at the wrong leaf and leave the real one an
        // under the requested root so any projected nested field receives a real
/// the supplied arrow schema and then matching that position to a parquet leaf
/// (`get_column_root_idx`). The table schema is the **union** of all
                if parquet_schema.get_column_root_idx(leaf_idx) == root_idx {
        if let Some(idx) = resolved {
            continue;
use std::collections::HashSet;
    file_schema: &SchemaRef,
    resolve_with_schema(file_schema, metadata, predicate_column_names)
            .ok()
/// `StatisticsConverter`/`parquet_column` map a column by finding its position in
/// Deriving the arrow schema from the file footer (`parquet_to_arrow_schema`)
) -> Vec<usize> {
        // leaves. Since `arrow_schema` is derived from this file's footer, its root
    let parquet_schema = metadata.file_metadata().schema_descr();
        if let Some((root_idx, _)) = arrow_schema.fields().find(name) {
pub fn resolve_predicate_parquet_columns(
/// matches what DataFusion dereferences. Columns absent from the file are skipped.
    metadata: &ParquetMetaData,
//! Resolution is done against the file's OWN schema (derived from the footer)
    let mut set = HashSet::new();
        resolve_with_schema(file_schema, metadata, projection_col_names),
        }
/// Map the query's predicate-column names to **this file's** parquet leaf
    _arrow_schema: &SchemaRef,
                    set.insert(leaf_idx);
            }
/// indexed setup loop previously each rebuilt it, so doing it once here removes a
/// (`statistics.rs` `page_locations.last().unwrap()`).
    }
/// Vec is identical to calling `resolve_predicate_parquet_columns` separately.
}
/// physical schema, reads the real leaf and panics on the empty `page_locations`
    (
/// wide schemas (it rebuilds the whole file's Schema); the two callers in the
/*
    )
/// the same file in one pass. Deriving the per-file arrow schema
 */
