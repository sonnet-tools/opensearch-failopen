//!     Substrait integers are signed only — Calcite `BIGINT` serializes as
        DataType::Utf8 | DataType::LargeUtf8 => DataType::Utf8View,
        let out = coerce_inferred_schema(schema);
        }
            DataType::List(f) => assert_eq!(f.data_type(), &DataType::Binary),
    let rewritten_fields: Vec<Field> = schema.fields().iter().map(|f| rewrite_field(f)).collect();
    }
        .iter()
        assert_eq!(out.field(1).data_type(), &DataType::Binary);
/// The Substrait consumer binds `base_schema` to the provider BY NAME, so the registered schema
    )
}
        field.name(),
    ))
//!     unsigned semantics are lost before the plan reaches DataFusion. Values
    #[test]
//!     no fp16 type; `OpenSearchSchemaBuilder` maps it to `REAL` which Substrait
/// `SchemaAdapter` null-fills them at read time.
///
    }
///   - `UInt64`     → `Int64`
    for ef in expected.fields() {
mod tests {
    use super::*;
 * The OpenSearch Contributors require contributions made to
        }
        assert_eq!(out.field(1).data_type(), &DataType::Binary);
    let fields = schema
        DataType::Map(f, sorted) => DataType::Map(Arc::new(rewrite_field(f)), *sorted),
        let schema = Arc::new(Schema::new(vec![
    #[test]
//! `DFSchema::datatype_is_logically_equal` (in `datafusion-common/src/dfschema.rs`)
//! Alternatives considered:
    fn field_metadata_and_nullability_preserved() {
        let schema = Arc::new(Schema::new(vec![Field::new(
        let schema = Arc::new(Schema::new(vec![
}
            "xs",
//!   - `UInt64`      ← parquet emits this for `unsigned_long` columns.
        DataType::Struct(fields) => {
//! `UInt64 → Int64`; cheap buffer relabeling for `BinaryView → Binary`).
//!     `DataType::Binary`.
}
        DataType::Binary | DataType::LargeBinary => DataType::BinaryView,
        let out = coerce_inferred_schema(schema);
            append_missing_nullable(&registered, &expected).expect("alias missing → augmented");
///
        assert_eq!(merged.fields().len(), 3);
//! so a Substrait plan declaring `Utf8` binds cleanly against a table column
        let out = coerce_inferred_schema(schema);
        assert_eq!(out.field(0).metadata(), &md);
    fn nested_list_of_uint64_gets_rewritten() {
//!     is the only fix until Substrait grows unsigned types (see Substrait
        return schema;
//!     `execution.parquet.schema_force_view_types = false` (threaded into
    let mut added: Vec<Field> = Vec::new();
            Field::new("b", DataType::BinaryView, true),
            Field::new("b", DataType::Int64, true),
            DataType::Struct(Fields::from(new_fields))
            before,
//!     the `BinaryView → Binary` rewrite here can be removed.
//! Substrait's type system is narrower than Arrow's. The DataFusion Substrait
        fields,
//!
//!     `Binary` rather than `BinaryView`. Drop this arm when we have a proper
        let schema = Arc::new(Schema::new(vec![Field::new(
        .iter()
 *
    if added.is_empty() {
//!     of `Utf8View/BinaryView`. Removes the BinaryView mismatch but also strips
            Field::new("name", DataType::Utf8, true),
        let registered = Schema::new(vec![
 * compatible open source license.
    fields.extend(added);
//!     `i64`, which arrives as `DataType::Int64`.
//!     solution.
//! reporting `Utf8View`. The two cases above are different in nature:
//!     (including OpenSearch's 16-byte `ip` and `binary` mappings) when
//!   - `BinaryView`  ← parquet emits this for variable-length byte columns
            other => panic!("expected List, got {other:?}"),
//!
        let schema = Arc::new(Schema::new(vec![
        let alias = merged.field_with_name("alias").unwrap();
    match data_type {
//!     `Float16` — so we lose the half-precision storage benefit at compute time.
        }
        DataType::BinaryView | DataType::UInt64 | DataType::Float16 => true,
//!     `proto/type.proto`).
//!     above `2^63 - 1` wrap into negatives — documented in
//!     on filter/group-by/hash paths.
}
        .fields()
//! the schema to `ListingTableConfig`. The parquet reader's `SchemaAdapter` then
//! Arrow-only types with their Substrait-compatible counterparts before handing
//!     Every record batch goes through a `Float16 → Float32` cast in the
    fn top_level_binary_view_gets_rewritten() {
        DataType::Struct(fields) => fields.iter().any(|f| contains_incompatible(f.data_type())),
        let expected = Schema::new(vec![Field::new("name", DataType::Utf8, true)]);
    if !schema_needs_coerce(&schema) {
        ]));
        other => other.clone(),
        ]));
        .fields()
    }
        DataType::UInt64 => DataType::Int64,
fn rewrite_data_type(dt: &DataType) -> DataType {
fn rewrite_field(field: &Field) -> Field {
            "unchanged schema must not reallocate"
//!
        let expected = Schema::new(vec![
        other => other.clone(),
//!     TODO: every record batch goes through a `BinaryView → Binary` cast in the
            Field::new("a", DataType::Int64, true),
//! inserts the per-batch cast at read time (zero-copy bit reinterpret for
    #[test]
/// coordinator declares `ARRAY<VARCHAR>` as `List<Utf8View>`.
        assert_eq!(out.field(0).data_type(), &DataType::Int64);
        ]);
    }
//!     serializes as `fp32`, arriving as `DataType::Float32`.
        DataType::Float16 => DataType::Float32,
        ]));
        let before = Arc::as_ptr(&schema);
            "xs",
    }
        ]));
                    .with_metadata(ef.metadata().clone()),
    match dt {
    #[test]
    let new_type = rewrite_data_type(field.data_type());
//! has hardcoded match arms `(Utf8, Utf8View) => true` and `(Utf8View, Utf8) => true`,
    }
}
        let out = coerce_inferred_schema(schema);
        let schema = Arc::new(Schema::new(vec![
            Field::new("s", DataType::Utf8View, true),
        // Only UInt64 ↔ Int64 needs coercion for OpenSearch's unsigned_long
    }
//!
        rewritten_fields,
//!     TODO: every record batch goes through a `Float16 → Float32` cast and
        DataType::Dictionary(key, value) => {
            Field::new("a", DataType::UInt64, true),
        let schema = Arc::new(Schema::new(vec![
            .iter()
//!     sync with `OpenSearchSchemaBuilder.mapFieldType`.
    fn top_level_uint64_gets_rewritten() {
            Field::new("name", DataType::Utf8, true),
        assert!(merged.field_with_name("age").is_ok());
//! `datatype_is_logically_equal` to the schema declared in the plan. The pairs
            Field::new("age", DataType::Int64, true),
        DataType::Dictionary(_, value_type) => contains_incompatible(value_type),
        assert_eq!(out.field(0).data_type(), &DataType::Utf8View);
///   - `Float16`    → `Float32`
        DataType::List(f) => DataType::List(Arc::new(rewrite_field(f))),
//!
//!
    }
        DataType::BinaryView => DataType::Binary,
//!   - `(Int64, UInt64)` is a Substrait + Calcite gap. Substrait's integer
        .map(|field| Arc::new(rewrite_field_to_view(field)))
            Field::new("c", DataType::UInt32, true),
/// Rewrite the schema to forms Substrait can bind against:
    }
//!   - Disable view types entirely with
        let inner = Field::new("item", DataType::UInt64, true);
        DataType::Map(f, _) => contains_incompatible(f.data_type()),
//!     types are semantically identical, but `datatype_is_logically_equal` has
//!
//!     SchemaAdapter, and downstream operators see `Float32` rather than
use std::sync::Arc;
        let inner = Field::new("item", DataType::BinaryView, true);
        assert_eq!(
            Field::new("a", DataType::Int64, true),
    Some(Arc::new(Schema::new_with_metadata(
        DataType::List(child) => DataType::List(Arc::new(rewrite_field_to_view(child))),
    #[test]
pub fn coerce_inferred_schema(schema: SchemaRef) -> SchemaRef {
        assert!(merged.field_with_name("name").is_ok());
fn rewrite_field_to_view(field: &Field) -> Field {
        assert_eq!(out.field(1).data_type(), &DataType::Int64);
    }
//! consumer rejects scans whose table-provider schema is not
        // since the shard has no data for it.
        rewrite_data_type_to_view(field.data_type()),
    fn other_unsigned_ints_are_left_alone() {
        }
            );
//!
        );
        let merged =
        DataType::FixedSizeList(f, n) => DataType::FixedSizeList(Arc::new(rewrite_field(f)), *n),
        // OpenSearch field type, and Calcite has no SMALLINT-equivalent
 * this file be licensed under the Apache-2.0 license or a
        match out.field(0).data_type() {
//!     TODO: values above `2^63 - 1` wrap into negatives. Drop this arm when we
    .with_metadata(field.metadata().clone())
        assert_eq!(alias.data_type(), &DataType::Utf8);
        // `alias` is declared non-nullable in the plan; it must still be appended as nullable
        .fields()
 * SPDX-License-Identifier: Apache-2.0
        // unsigned type to mismatch against, so we leave them untouched.
//!   - `Float16`     ← parquet emits this for `half_float` columns. Calcite has
//!     `Utf8View` from string columns, giving up the inline-prefix optimization
        }
        .collect::<Vec<_>>();
    #[test]
    #[test]
        let before = Arc::as_ptr(&schema);
            Field::new("a", DataType::UInt8, true),
//!
        // mapping today. Smaller unsigned widths aren't produced by any current
//!     solution.
//!     types are signed-only and Calcite has no unsigned `BIGINT`, so the
        let out = coerce_inferred_schema(schema);
//!     no arm for them today (DF 53). If it becomes available in DataFusion,
        let schema = Arc::new(Schema::new(vec![f]));
}
        assert!(alias.is_nullable(), "appended column must be nullable");
        let out = coerce_inferred_schema(schema);
///   - `BinaryView` → `Binary`
        assert!(append_missing_nullable(&registered, &expected).is_none());
//!   - `(Binary, BinaryView)` is a missing equivalence in DataFusion. The two
    fn append_missing_adds_absent_columns_as_nullable() {
//!     `half_float` columns are widened to `REAL` (fp32) at the Java planner.
    }
//!     `ParquetFormat::with_options`). Makes the reader emit `Utf8/Binary` instead
        schema.metadata().clone(),
//!     `OpenSearchSchemaBuilder.mapFieldType`. Narrowing at the scan boundary
        .iter()
        assert_eq!(Arc::as_ptr(&out), before);
//!
//!
            Field::new("b", DataType::Utf8View, true),
            Field::new("age", DataType::Int64, true),
        ]);
//!     serializes `VARBINARY` as plain `binary`, which arrives as
            DataType::List(Arc::new(inner)),
/// Recurses into `List`, `LargeList`, `FixedSizeList`, `Map`, `Struct`,
//!
            other => panic!("expected List, got {other:?}"),
        )]));
            Arc::as_ptr(&out),
/// Appends to `registered` any `expected` field whose name is absent, as a nullable column.
        .map(|f| f.as_ref().clone())
        ]);
/// only needs to *contain* every expected column — order is irrelevant and present columns keep
    let mut fields: Vec<Field> = registered
                Field::new(ef.name(), ef.data_type().clone(), true)
//! we hit on this path:
fn rewrite_data_type_to_view(data_type: &DataType) -> DataType {
    }
}
}
//!
use datafusion::arrow::datatypes::{DataType, Field, Fields, Schema, SchemaRef};
    Field::new(
        if registered.field_with_name(ef.name()).is_err() {
//!     have a proper solution.
//!     the schema from Java to Rust and adds a second mapping table to keep in
pub fn transform_schema_to_view_recursive(schema: &Schema) -> Schema {
            contains_incompatible(f.data_type())
        assert_eq!(out.field(0).data_type(), &DataType::Int64);
    Arc::new(Schema::new_with_metadata(
        assert!(!out.field(0).is_nullable());
        )]));
        match out.field(0).data_type() {
//!
        let f = Field::new("b", DataType::BinaryView, false).with_metadata(md.clone());
        DataType::List(f) | DataType::LargeList(f) | DataType::FixedSizeList(f, _) => {
        field.is_nullable(),
//! `Utf8View` doesn't need coercing: DataFusion 53's
            DataType::List(f) => assert_eq!(f.data_type(), &DataType::Int64),
//!
fn schema_needs_coerce(schema: &Schema) -> bool {
/// needed so callers avoid an unnecessary `Arc` reallocation in the common
        DataType::LargeList(f) => DataType::LargeList(Arc::new(rewrite_field(f))),
    Schema::new_with_metadata(fields, schema.metadata().clone())
/// DataFusion's `transform_schema_to_view` only rewrites top-level fields, while the
//!     `schema_force_view_types` is on. Substrait has no view types — isthmus
        .collect();
            let new_fields: Vec<Field> = fields.iter().map(|f| rewrite_field(f)).collect();
/// `Some(augmented)` if anything was added, `None` if `registered` already covers `expected`.
    fn nested_list_of_binary_view_gets_rewritten() {
            Field::new("alias", DataType::Utf8, false),
    match dt {
        let registered = Schema::new(vec![
//!   - `(Float32, Float16)` is a Calcite-side gap: Calcite has no fp16 type, so
    schema
    #[test]
/// their inferred (coerced) types. Appended columns are forced nullable; DataFusion's parquet
//!     truth, no post-process step. Costs the cross-language plumbing to ship
            Field::new("b", DataType::BinaryView, true),
}
            true,
            true,
    fn schema_without_incompatible_types_is_returned_unchanged() {
        ]));
//!     downstream operators see `Float32`. Drop this arm when we have a proper
//!     the OpenSearch mapping (the same source Calcite reads). Single source of
            Field::new("b", DataType::UInt16, true),
/// case.
        _ => false,
}
    }
    }
        let mut md = std::collections::HashMap::new();
        md.insert("key".to_string(), "value".to_string());
/// Convert Parquet string/binary fields to Arrow view types, including LIST children.
/// `Union`, and `Dictionary`. Returns the input unchanged when no rewrite is
            .any(|(_, f)| contains_incompatible(f.data_type())),
//!     SchemaAdapter (offset+data buffer copy), and downstream operators see
#[cfg(test)]
    }
//! We rewrite the inferred schema at the table-provider boundary: substitute the
        let out = coerce_inferred_schema(schema);
 */
            added.push(
pub fn append_missing_nullable(registered: &Schema, expected: &Schema) -> Option<SchemaRef> {
            Field::new("age", DataType::Int64, true),
        DataType::Union(fields, _) => fields
            DataType::List(Arc::new(inner)),
//! Schema coercion at the Substrait/DataFusion scan boundary.
    fn utf8_view_is_left_alone() {
    }
    )))
        return None;
    #[test]
        let out = coerce_inferred_schema(schema);
        // Registered may carry extra columns the plan doesn't reference — still nothing to add.
//!   - Skip `infer_schema` entirely and construct the Arrow schema directly from
        registered.metadata().clone(),
            Field::new("name", DataType::Utf8, true),
        }
fn contains_incompatible(dt: &DataType) -> bool {
/*
    Field::new(field.name(), new_type, field.is_nullable()).with_metadata(field.metadata().clone())
        .any(|f| contains_incompatible(f.data_type()))
    #[test]
    fn append_missing_returns_none_when_registered_covers_expected() {
            DataType::Dictionary(key.clone(), Box::new(rewrite_data_type(value)))
