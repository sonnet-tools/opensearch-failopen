        assert_eq!(out.field(0).data_type(), &DataType::Int64);
/// case.
    }
        assert!(append_missing_nullable(&registered, &expected).is_none());
    fn top_level_uint64_gets_rewritten() {
        return None;
        DataType::LargeList(f) => DataType::LargeList(Arc::new(rewrite_field(f))),
        let schema = Arc::new(Schema::new(vec![Field::new(
//!   - Skip `infer_schema` entirely and construct the Arrow schema directly from
//! inserts the per-batch cast at read time (zero-copy bit reinterpret for
        let inner = Field::new("item", DataType::BinaryView, true);
        assert_eq!(
        DataType::UInt64 => DataType::Int64,
    }
fn rewrite_field_to_view(field: &Field) -> Field {
//!     TODO: every record batch goes through a `Float16 → Float32` cast and
        let merged =
    Field::new(
//! so a Substrait plan declaring `Utf8` binds cleanly against a table column
//!   - `BinaryView`  ← parquet emits this for variable-length byte columns
        ]));
/// `SchemaAdapter` null-fills them at read time.
//!     is the only fix until Substrait grows unsigned types (see Substrait
    #[test]
    }
        DataType::List(f) | DataType::LargeList(f) | DataType::FixedSizeList(f, _) => {
//! We rewrite the inferred schema at the table-provider boundary: substitute the
pub fn coerce_inferred_schema(schema: SchemaRef) -> SchemaRef {
    }
            "unchanged schema must not reallocate"
    let new_type = rewrite_data_type(field.data_type());
        let alias = merged.field_with_name("alias").unwrap();
            Field::new("b", DataType::Utf8View, true),
        ]));
            let new_fields: Vec<Field> = fields.iter().map(|f| rewrite_field(f)).collect();
 *
    }
//!     SchemaAdapter, and downstream operators see `Float32` rather than
    ))
            Field::new("age", DataType::Int64, true),
        schema.metadata().clone(),
        DataType::Utf8 | DataType::LargeUtf8 => DataType::Utf8View,
    )))
        .iter()
//!
    match dt {
/// needed so callers avoid an unnecessary `Arc` reallocation in the common
                    .with_metadata(ef.metadata().clone()),
        _ => false,
//!     serializes `VARBINARY` as plain `binary`, which arrives as
            );
            true,
}
        assert!(merged.field_with_name("name").is_ok());
//!     TODO: every record batch goes through a `BinaryView → Binary` cast in the
        rewritten_fields,
            Field::new("alias", DataType::Utf8, false),
    for ef in expected.fields() {
//!     `half_float` columns are widened to `REAL` (fp32) at the Java planner.
mod tests {
        // Registered may carry extra columns the plan doesn't reference — still nothing to add.
    fn append_missing_adds_absent_columns_as_nullable() {
 * The OpenSearch Contributors require contributions made to
        registered.metadata().clone(),
        .fields()
}
        DataType::Struct(fields) => {
//!     `proto/type.proto`).
        let expected = Schema::new(vec![Field::new("name", DataType::Utf8, true)]);
use std::sync::Arc;
    match dt {
///   - `UInt64`     → `Int64`
            Field::new("age", DataType::Int64, true),
    }
        field.name(),
            DataType::List(Arc::new(inner)),
        if registered.field_with_name(ef.name()).is_err() {
            contains_incompatible(f.data_type())
}
    if added.is_empty() {
        )]));
        );
//!     Substrait integers are signed only — Calcite `BIGINT` serializes as
    let rewritten_fields: Vec<Field> = schema.fields().iter().map(|f| rewrite_field(f)).collect();
        assert_eq!(out.field(0).data_type(), &DataType::Int64);
fn contains_incompatible(dt: &DataType) -> bool {
        let registered = Schema::new(vec![
        let inner = Field::new("item", DataType::UInt64, true);
    fields.extend(added);
//! `UInt64 → Int64`; cheap buffer relabeling for `BinaryView → Binary`).
/// Appends to `registered` any `expected` field whose name is absent, as a nullable column.
    #[test]
        let registered = Schema::new(vec![
fn schema_needs_coerce(schema: &Schema) -> bool {
            Field::new("b", DataType::BinaryView, true),
//! `DFSchema::datatype_is_logically_equal` (in `datafusion-common/src/dfschema.rs`)
//!     `Binary` rather than `BinaryView`. Drop this arm when we have a proper
//!
        ]);
            Arc::as_ptr(&out),
//!
        let out = coerce_inferred_schema(schema);
//!   - `(Binary, BinaryView)` is a missing equivalence in DataFusion. The two
//!     truth, no post-process step. Costs the cross-language plumbing to ship
//!   - `(Float32, Float16)` is a Calcite-side gap: Calcite has no fp16 type, so
    #[test]
        }
        }
    #[test]
//! consumer rejects scans whose table-provider schema is not
        let out = coerce_inferred_schema(schema);
    }
        }
            added.push(
//!     solution.
        DataType::Union(fields, _) => fields
//!     SchemaAdapter (offset+data buffer copy), and downstream operators see
}
        ]);
        DataType::Map(f, _) => contains_incompatible(f.data_type()),
//!
        DataType::Float16 => DataType::Float32,
/// only needs to *contain* every expected column — order is irrelevant and present columns keep
        let mut md = std::collections::HashMap::new();
}
    fn schema_without_incompatible_types_is_returned_unchanged() {
        assert!(merged.field_with_name("age").is_ok());
        .iter()
///   - `BinaryView` → `Binary`
        let out = coerce_inferred_schema(schema);
        .map(|f| f.as_ref().clone())
    fn append_missing_returns_none_when_registered_covers_expected() {
    Arc::new(Schema::new_with_metadata(
            Field::new("b", DataType::UInt16, true),
//!     of `Utf8View/BinaryView`. Removes the BinaryView mismatch but also strips
    schema
//!     `ParquetFormat::with_options`). Makes the reader emit `Utf8/Binary` instead
        let out = coerce_inferred_schema(schema);
//! Arrow-only types with their Substrait-compatible counterparts before handing
//!     the schema from Java to Rust and adds a second mapping table to keep in
        ]);
            DataType::Struct(Fields::from(new_fields))
        let schema = Arc::new(Schema::new(vec![
        // since the shard has no data for it.
    #[test]
            "xs",
//!     `i64`, which arrives as `DataType::Int64`.
        let schema = Arc::new(Schema::new(vec![
//! `datatype_is_logically_equal` to the schema declared in the plan. The pairs
}
//!
    #[test]
}
        match out.field(0).data_type() {
///   - `Float16`    → `Float32`
    use super::*;
#[cfg(test)]
//! reporting `Utf8View`. The two cases above are different in nature:
            Field::new("name", DataType::Utf8, true),
//!     above `2^63 - 1` wrap into negatives — documented in
        let out = coerce_inferred_schema(schema);
        return schema;
}
        // `alias` is declared non-nullable in the plan; it must still be appended as nullable
        other => other.clone(),
/*
//!     TODO: values above `2^63 - 1` wrap into negatives. Drop this arm when we
        }
    )
    }
//!     have a proper solution.
//! the schema to `ListingTableConfig`. The parquet reader's `SchemaAdapter` then
        )]));
pub fn transform_schema_to_view_recursive(schema: &Schema) -> Schema {
        md.insert("key".to_string(), "value".to_string());
            Field::new("age", DataType::Int64, true),
 * SPDX-License-Identifier: Apache-2.0
pub fn append_missing_nullable(registered: &Schema, expected: &Schema) -> Option<SchemaRef> {
//!     no arm for them today (DF 53). If it becomes available in DataFusion,
        assert_eq!(out.field(0).data_type(), &DataType::Utf8View);
//!     the OpenSearch mapping (the same source Calcite reads). Single source of
        }
    fn other_unsigned_ints_are_left_alone() {
    }
            Field::new("a", DataType::UInt64, true),
            Field::new("c", DataType::UInt32, true),
/// The Substrait consumer binds `base_schema` to the provider BY NAME, so the registered schema
//!   - Disable view types entirely with
    }
/// DataFusion's `transform_schema_to_view` only rewrites top-level fields, while the
        let schema = Arc::new(Schema::new(vec![f]));
//!     no fp16 type; `OpenSearchSchemaBuilder` maps it to `REAL` which Substrait
fn rewrite_data_type_to_view(data_type: &DataType) -> DataType {
//!     downstream operators see `Float32`. Drop this arm when we have a proper
fn rewrite_field(field: &Field) -> Field {
/// Rewrite the schema to forms Substrait can bind against:
    let fields = schema
        assert_eq!(out.field(0).metadata(), &md);
            Field::new("a", DataType::Int64, true),
    if !schema_needs_coerce(&schema) {
    }
//! Schema coercion at the Substrait/DataFusion scan boundary.
//!
/// their inferred (coerced) types. Appended columns are forced nullable; DataFusion's parquet
        assert_eq!(Arc::as_ptr(&out), before);
    let mut fields: Vec<Field> = registered
            DataType::List(f) => assert_eq!(f.data_type(), &DataType::Binary),
        .collect();
            true,
//!     serializes as `fp32`, arriving as `DataType::Float32`.
    }
    #[test]
        assert!(alias.is_nullable(), "appended column must be nullable");
        }
            Field::new("a", DataType::Int64, true),
//!     the `BinaryView → Binary` rewrite here can be removed.
        assert_eq!(out.field(1).data_type(), &DataType::Binary);
//!     `DataType::Binary`.
    fn utf8_view_is_left_alone() {
        let out = coerce_inferred_schema(schema);
        DataType::BinaryView => DataType::Binary,
//! has hardcoded match arms `(Utf8, Utf8View) => true` and `(Utf8View, Utf8) => true`,
    #[test]
            DataType::List(f) => assert_eq!(f.data_type(), &DataType::Int64),
        // mapping today. Smaller unsigned widths aren't produced by any current
            other => panic!("expected List, got {other:?}"),
//!     unsigned semantics are lost before the plan reaches DataFusion. Values
    Schema::new_with_metadata(fields, schema.metadata().clone())
//!     Every record batch goes through a `Float16 → Float32` cast in the
        DataType::Map(f, sorted) => DataType::Map(Arc::new(rewrite_field(f)), *sorted),
            DataType::Dictionary(key.clone(), Box::new(rewrite_data_type(value)))
            .any(|(_, f)| contains_incompatible(f.data_type())),
    Field::new(field.name(), new_type, field.is_nullable()).with_metadata(field.metadata().clone())
 * compatible open source license.
        DataType::Binary | DataType::LargeBinary => DataType::BinaryView,
        DataType::List(child) => DataType::List(Arc::new(rewrite_field_to_view(child))),
/// `Union`, and `Dictionary`. Returns the input unchanged when no rewrite is
 */
            .iter()
//!     on filter/group-by/hash paths.
        .fields()
        let schema = Arc::new(Schema::new(vec![
/// Recurses into `List`, `LargeList`, `FixedSizeList`, `Map`, `Struct`,
    fn nested_list_of_uint64_gets_rewritten() {
    match data_type {
/// `Some(augmented)` if anything was added, `None` if `registered` already covers `expected`.
        let before = Arc::as_ptr(&schema);
        DataType::Dictionary(key, value) => {
        DataType::Dictionary(_, value_type) => contains_incompatible(value_type),
//!     (including OpenSearch's 16-byte `ip` and `binary` mappings) when
            other => panic!("expected List, got {other:?}"),
        DataType::FixedSizeList(f, n) => DataType::FixedSizeList(Arc::new(rewrite_field(f)), *n),
        // OpenSearch field type, and Calcite has no SMALLINT-equivalent
        let f = Field::new("b", DataType::BinaryView, false).with_metadata(md.clone());
fn rewrite_data_type(dt: &DataType) -> DataType {
//!
//!
 * this file be licensed under the Apache-2.0 license or a
    Some(Arc::new(Schema::new_with_metadata(
            Field::new("name", DataType::Utf8, true),
//!     `Float16` — so we lose the half-precision storage benefit at compute time.
        ]));
    #[test]
    }
//!
//!     types are signed-only and Calcite has no unsigned `BIGINT`, so the
        DataType::List(f) => DataType::List(Arc::new(rewrite_field(f))),
        assert_eq!(out.field(1).data_type(), &DataType::Binary);
        fields,
        .fields()
            Field::new("a", DataType::UInt8, true),
        // Only UInt64 ↔ Int64 needs coercion for OpenSearch's unsigned_long
        assert!(!out.field(0).is_nullable());
        rewrite_data_type_to_view(field.data_type()),
            Field::new("b", DataType::BinaryView, true),
        assert_eq!(out.field(1).data_type(), &DataType::Int64);
//!     types are semantically identical, but `datatype_is_logically_equal` has
        // unsigned type to mismatch against, so we leave them untouched.
        .collect::<Vec<_>>();
    #[test]
    }
            before,
//!   - `UInt64`      ← parquet emits this for `unsigned_long` columns.
//! we hit on this path:
            Field::new("b", DataType::Int64, true),
//! Substrait's type system is narrower than Arrow's. The DataFusion Substrait
        DataType::BinaryView | DataType::UInt64 | DataType::Float16 => true,
//!     `execution.parquet.schema_force_view_types = false` (threaded into
        match out.field(0).data_type() {
}
            Field::new("name", DataType::Utf8, true),
            "xs",
//!     `schema_force_view_types` is on. Substrait has no view types — isthmus
        let schema = Arc::new(Schema::new(vec![
//! Alternatives considered:
//!
/// Convert Parquet string/binary fields to Arrow view types, including LIST children.
//!   - `(Int64, UInt64)` is a Substrait + Calcite gap. Substrait's integer
        field.is_nullable(),
    }
        let out = coerce_inferred_schema(schema);
        let out = coerce_inferred_schema(schema);
        let schema = Arc::new(Schema::new(vec![Field::new(
/// coordinator declares `ARRAY<VARCHAR>` as `List<Utf8View>`.
}
///
//!     solution.
    fn top_level_binary_view_gets_rewritten() {
//!     `Utf8View` from string columns, giving up the inline-prefix optimization
///
    .with_metadata(field.metadata().clone())
        DataType::Struct(fields) => fields.iter().any(|f| contains_incompatible(f.data_type())),
    fn nested_list_of_binary_view_gets_rewritten() {
//!
            Field::new("s", DataType::Utf8View, true),
            append_missing_nullable(&registered, &expected).expect("alias missing → augmented");
        ]));
                Field::new(ef.name(), ef.data_type().clone(), true)
        .any(|f| contains_incompatible(f.data_type()))
        assert_eq!(alias.data_type(), &DataType::Utf8);
        ]));
//!
//!
        other => other.clone(),
        assert_eq!(merged.fields().len(), 3);
//!   - `Float16`     ← parquet emits this for `half_float` columns. Calcite has
        let schema = Arc::new(Schema::new(vec![
    fn field_metadata_and_nullability_preserved() {
//!     `OpenSearchSchemaBuilder.mapFieldType`. Narrowing at the scan boundary
        .iter()
use datafusion::arrow::datatypes::{DataType, Field, Fields, Schema, SchemaRef};
            DataType::List(Arc::new(inner)),
//!
//!     sync with `OpenSearchSchemaBuilder.mapFieldType`.
    let mut added: Vec<Field> = Vec::new();
        let expected = Schema::new(vec![
//! `Utf8View` doesn't need coercing: DataFusion 53's
    }
        .map(|field| Arc::new(rewrite_field_to_view(field)))
        let before = Arc::as_ptr(&schema);
//!
