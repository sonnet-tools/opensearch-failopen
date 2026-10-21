            "timestamp".to_string(),
    }
                        "__row_id__" | "_seq_no" | "_primary_term" | "_version" => {
        };
        parts.push("list".to_string());
                    // PLAIN: explicitly disable dictionary so the writer uses plain encoding
    }
                }
            field_configs: Some(field_configs),
    fn test_field_encoding_plain_overrides_type_disables_dictionary() {
            ..Default::default()
    /// * `compression_type` - String representation of compression type
        assert!(WriterPropertiesBuilder::parse_compression_type("unknown", 0).is_err());
        Float64 => "float64".into(),
        field_configs.insert(
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        // invalid for int32
            .set_max_row_group_row_count(Some(config.get_row_group_max_rows()))
        );
        // Apply field-level configurations
        );
    }
    }
            "row_id".to_string(),
        field_configs.insert(
                        }
    /// Applies page size and row limit settings.
                            "Encoding '{}' is not supported for field '{}' of type '{:?}'",
    use arrow::datatypes::DataType::*;
                    | Date32
            },
        };
        let config = NativeSettings {
                Float32 | Float64 | Int32 | Int64 | UInt32 | UInt64 | FixedSizeBinary(_)
        );
        Int16 => "int16".into(),
    }
        let schema = schema_with(vec![
    #[test]
/// (pre-versioning / legacy file). Callers should treat empty-string as "unknown"
                compression_type: Some("SNAPPY".to_string()),
            "Default should have bloom filter disabled"
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        assert!(!props.dictionary_enabled(&col_path));
            ("name", ArrowDataType::Utf8),
        field_configs.insert(
                    | Int32
            ),
            // Compression: parse once, apply. No type restriction.
        );
    fn test_rle_dictionary_invalid_for_boolean() {
            };
        let schema = schema_with(vec![
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()),
            },
    fn test_type_level_encoding_only_applies_to_matching_type() {
        assert!(props.dictionary_enabled(&col_path));
        .key_value_metadata()
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            FieldConfig {
                            _ => None,
            "flag".to_string(),
/// Returns the type that column properties apply to. Parquet encodes a LIST column's leaf, not
                ..Default::default()
        let config = NativeSettings {
    }
            Encoding::PLAIN
            props.bloom_filter_properties(&col_path)
        let config = NativeSettings {
            .bloom_filter_properties(&parquet::schema::types::ColumnPath::from("name"))
            .set_data_page_size_limit(config.get_page_size_bytes())
        );
            .fields()
        type_bf_enabled.insert("int32".to_string(), true);
    use arrow::datatypes::DataType::*;
            "name".to_string(),
        field_configs.insert(
                field_names.insert(name.as_str());
                        "Cluster-level encoding '{}' is not supported for type '{:?}' (field '{}')",
            type_bloom_filter_enabled: Some(type_bf_enabled),
                BrotliLevel::try_new(level as u32).unwrap_or_default(),
        let config = NativeSettings {
            FieldConfig {
    use super::*;
        };
            Compression::BROTLI(_)
    pub fn build_with_generation(
    }
        };
        let mut type_compression = HashMap::new();
        );
    }
            .expect("build failed");
            field_configs: Some(field_configs),
            type_encoding_configs: Some(type_encoding),
    /// Parses encoding type string to Parquet Encoding enum.
    /// # Arguments
        schema: &ArrowSchema,
            Some(FORMAT_VERSION.to_string()),
mod tests {
        let value_bf = props.bloom_filter_properties(&value_path);
                .bloom_filter_properties(&list_leaf_path("tags"))
        let col_path = parquet::schema::types::ColumnPath::from("name");
            FieldConfig {
            "BYTE_STREAM_SPLIT" => Ok(Encoding::BYTE_STREAM_SPLIT),
    ///
        )];
        let name_path = parquet::schema::types::ColumnPath::from("name");
        type FieldEntry<'a> = (
    ///
        let config = NativeSettings {
        Utf8 | LargeUtf8 => "utf8".into(),
        let config = NativeSettings {
            },
    #[test]
    }
                        .get(t)
}
            props.encoding(&col_path),
            "name".to_string(),
                if let Some(enc) = index_cfg.and_then(|fc| fc.encoding_type.as_deref()) {
            field_names.insert(f.name().as_str());
        Int8 => "int8".into(),
#[cfg(test)]
            let level = index_cfg.and_then(|fc| fc.compression_level).unwrap_or(3);
        assert!(
            },
            Compression::LZ4_RAW
                } else if matches!(enc, Encoding::RLE_DICTIONARY) {
        let schema = list_schema("tags", ArrowDataType::Utf8);
                .field_configs
        assert_eq!(
            .any(|k| k.key == WRITER_GENERATION_KEY && k.value.as_deref() == Some("42"));
    fn test_bloom_filter_enabled_propagates() {
                        "Field '{}' in field_configs does not exist in schema",
        );
        };
                .find(|kv| kv.key == FORMAT_VERSION_KEY)
            type_encoding_configs: Some(type_encoding),
            "bloom filter must be enabled on the list leaf path"
            },
        assert!(WriterPropertiesBuilder::build(&config, &schema).is_ok());
            Some(Encoding::DELTA_BINARY_PACKED)
        };
    #[test]
        };
            name_bf.fpp
    ) -> Result<parquet::file::properties::WriterPropertiesBuilder, String> {
            "ZSTD" => Ok(Compression::ZSTD(
    fn test_field_level_compression_applied() {
                    f.name().as_str(),
                            enc, field_name, arrow_type
        let schema = schema_with(vec![
                bloom_filter_ndv: Some(200_000),
        let schema = schema_with(vec![("age", ArrowDataType::Int64)]);
        );
        let mut type_encoding = HashMap::new();
                    .and_then(|fc| fc.bloom_filter_fpp)
            WriterPropertiesBuilder::parse_compression_type("GZIP", 6).unwrap(),
                ..Default::default()
        // Field sets PLAIN, type sets DELTA_BINARY_PACKED — field wins and dictionary is disabled
fn effective_type(dt: &arrow::datatypes::DataType) -> &arrow::datatypes::DataType {
    /// Applies bloom filter settings.
        // (setting it as column encoding causes parquet-rs error)
        field_configs.insert(
        assert_eq!(props.encoding(&name_path), None);
                    config
    }
        let mut type_bf_fpp = HashMap::new();
                })
        );
                        arrow_type_key(element_type),
            "value".to_string(),
        match encoding_type.to_uppercase().as_str() {
    /// * `config` - The native settings to convert
        let child = std::sync::Arc::new(Field::new("element", element, true));
                ) {
        let config = NativeSettings {
        let config = NativeSettings {
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    fn test_field_encoding_applied() {
        assert!(WriterPropertiesBuilder::parse_encoding_type("unknown").is_err());
        let mut type_bf_ndv = HashMap::new();
        let col_path = parquet::schema::types::ColumnPath::from("row_id");
                .unwrap_or(config.get_bloom_filter_enabled());
            kvs.iter()
                .is_some(),
            "name should have no bloom filter, got: {:?}",
            field_configs: Some(field_configs),
        let age_path = parquet::schema::types::ColumnPath::from("age");
        // Apply page settings
                encoding_type: Some("DELTA_BINARY_PACKED".to_string()),
            parquet::schema::types::ColumnPath,
        let mut type_encoding = HashMap::new();
        let mut field_configs = HashMap::new();
        };
            FieldConfig {
                } else {
                ..Default::default()
        );
        };
                    let parsed = Self::parse_encoding_type(enc)?;
        let config = NativeSettings {
        };
    /// Applies compression settings to the builder.
            type_encoding_configs: Some(type_encoding),
        builder.set_dictionary_page_size_limit(config.get_dict_size_bytes())
            }
        assert_eq!(config.get_bloom_filter_enabled(), false);
        let schema = schema_with(vec![
        assert_eq!(
                            _ => None,
        for f in schema.fields() {
        );
        // Apply dictionary settings
        builder
            field_configs: Some(field_configs),
        let col_path = parquet::schema::types::ColumnPath::from("name");
    /// and every per-column setting would silently fall back to defaults.
        let mut type_compression = HashMap::new();
        field_configs.insert(
            "title".to_string(),
                builder = builder.set_column_bloom_filter_enabled(column_path.clone(), true);
        assert!(
        let schema = schema_with(vec![("age", ArrowDataType::Int32)]);
            "nonexistent".to_string(),
        field_configs.insert(
            ..Default::default()
                    | Date64
        assert!(WriterPropertiesBuilder::build(&config, &schema).is_err());
        };
        // Should NOT set a column-level encoding (that would cause the fallback error)
            bloom_filter_enabled: Some(true),
            WriterPropertiesBuilder::parse_encoding_type("DELTA").unwrap(),
    }
    #[test]
        let col_path = parquet::schema::types::ColumnPath::from("age");
                Some(v) => (v.0, Some(v.1.as_str()), v.2.clone()),
    }
        // Field-level config should take precedence over type-level config
///
        let config = NativeSettings {
            ..Default::default()
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            type_compression_configs: Some(type_compression),
pub const FORMAT_VERSION: &str = "1.0.0.0";
            ("name", ArrowDataType::Utf8),
            None
        config: &NativeSettings,
        type_bf_enabled.insert("utf8".to_string(), true);
    fn test_delta_byte_array_disables_dictionary() {
        let mut field_configs = HashMap::new();
        let mut field_configs = HashMap::new();
        assert!(
                    enc,
    }
    #[test]
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
/// rather than rejecting the file; compatibility decisions are plugin-owned.
            String,
            Encoding::BYTE_STREAM_SPLIT => matches!(
        // "age": int32 type-level enabled but no fpp/ndv -> falls to global fpp=0.1, ndv=100000
        field_configs.insert(
        let mut type_encoding = HashMap::new();
                encoding_type: Some("DICTIONARY".to_string()),
            ..Default::default()
        );
            ("name", ArrowDataType::Utf8),
    fn schema_with(fields: Vec<(&str, ArrowDataType)>) -> ArrowSchema {
        };
        };
        // Dictionary should be enabled
    }
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
    #[test]
        );
            },
        assert_eq!(
    #[test]
        assert!(!props.dictionary_enabled(&col_path));
    #[test]
                bloom_filter_enabled: Some(false),
        };
/// Parquet file-level metadata key for the writer generation.
            compression_level: Some(5),
    }
                    // RLE_DICTIONARY means use dictionary encoding - just ensure it's enabled
            "UNCOMPRESSED" => Ok(Compression::UNCOMPRESSED),
    /// Applies row group row count and byte size limits.
                            Some("timestamp") => Some(Encoding::DELTA_BINARY_PACKED),
        assert!(
            FieldConfig {
        ArrowSchema::new(vec![Field::new(name, ArrowDataType::List(child), true)])
                let bf_ndv = index_cfg
        );
            "name".to_string(),
                    | UInt32
            ("age", ArrowDataType::Int64),
        field_configs.insert(
        let config = NativeSettings {
                        .as_ref()?
                    | UInt16
        let config = NativeSettings {
            .collect();
            FieldConfig {
                }
    fn test_delta_length_byte_array_on_string() {
        })
        );
            "nums".to_string(),
        let mut field_configs = HashMap::new();
            "encoding must be set on the list leaf path"
    #[test]
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
                encoding_type: Some("RLE".to_string()),
        // valid for boolean
    let mut parts = vec![field.name().clone()];
/// bloom-filter settings silently no-op for lists unless the full path is spelled out. The
        assert_eq!(
        _ => format!("{:?}", dt).to_lowercase(),
        let config = NativeSettings {
            FieldConfig {
    }
            title_bf.fpp
        let schema2 = schema_with(vec![("flag", ArrowDataType::Int32)]);
    #[test]
    #[test]
        );
            field_configs: Some(field_configs),
            "bloom_filter_properties should be Some when enabled"
            FieldConfig {
            ..Default::default()
    #[test]
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
                ..Default::default()
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
/// Current parquet format version produced by this writer. Plugin-defined namespace —
        let props = WriterPropertiesBuilder::build(&config, &schema).expect("build failed");
                    // Metadata field defaults by name, then type-based defaults
                None => {
            field_configs: Some(field_configs),
        Timestamp(_, _) => "timestamp".into(),
        UInt32 => "uint32".into(),
    fn test_build_with_compression() {
    }
    use arrow::datatypes::{DataType as ArrowDataType, Field, Schema as ArrowSchema};
        assert!(WriterPropertiesBuilder::parse_compression_type("LZ4", 0).is_err());
        let bf_props = props.bloom_filter_properties(&col_path);
    fn parse_compression_type(compression_type: &str, level: i32) -> Result<Compression, String> {
        assert!(
        let mut type_compression = HashMap::new();
    }
            ..Default::default()
                    builder = builder.set_column_dictionary_enabled(column_path.clone(), false);
            other => Err(format!("Unknown compression type: '{}'", other)),
        let schema = list_schema("tags", ArrowDataType::Utf8);
            },
            field_configs: Some(field_configs),
            )),
    #[test]
            ..Default::default()
        Float32 => "float32".into(),
                ..Default::default()
/// constant `ParquetDataFormatPlugin.PARQUET_FORMAT_VERSION`.
/// Reads the opensearch format version from a Parquet file's key-value metadata.
    fn test_list_column_uses_leaf_column_path_for_encoding() {
            },
    fn test_rle_disables_dictionary_for_boolean() {
        .unwrap_or(file_index as i64)
        assert!(!props.dictionary_enabled(&age_path));
    #[test]
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        );
            field_configs: Some(field_configs),
                .and_then(|v| v.parse::<i64>().ok())
            props.encoding(&list_leaf_path("tags")),
                if let Some(comp) = index_cfg.and_then(|fc| fc.compression_type.as_deref()) {
        );
            ..Default::default()
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let mut builder = WriterProperties::builder();
            ("title", ArrowDataType::Utf8),
        field_configs.insert(
            FieldConfig {
            "bloom_filter_properties should be None when disabled, got: {:?}",
        builder = Self::apply_dictionary_settings(builder, config);
            !props.dictionary_enabled(&col_path),
        Int32 => "int32".into(),
        assert!(result.unwrap_err().contains("DELTA_BINARY_PACKED"));
        let mut field_configs = HashMap::new();
        let schema = schema_with(vec![("test_col", ArrowDataType::Utf8)]);
    fn test_invalid_cluster_encoding_for_type_returns_error() {
            props.encoding(&col_path),
    fn apply_field_configs(
        );
            field_configs: Some(field_configs),
        use arrow::datatypes::DataType::*;
            Some(Encoding::DELTA_BYTE_ARRAY)
        };
            ..Default::default()
    #[test]
        let mut type_encoding = HashMap::new();
    use crate::field_config::FieldConfig;
            "name".to_string(),
            bloom_filter_fpp: Some(0.1),
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let mut type_bf_enabled = HashMap::new();
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            },
        );
        Ok(builder)
                ..Default::default()
        let title_bf = props
                        type_key
        };
        let schema = schema_with(vec![("test_col", ArrowDataType::Utf8)]);
        field_configs.insert(
        assert!(!props.dictionary_enabled(&col_path));
            WriterPropertiesBuilder::parse_encoding_type("PLAIN").unwrap(),
///
    #[test]
        let config = NativeSettings {
            "age".to_string(),
        type_bf_ndv.insert("utf8".to_string(), 50_000u64);
                            .and_then(|t| config.type_bloom_filter_fpp.as_ref()?.get(t).copied())
                    ));
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
                ..Default::default()
            WriterPropertiesBuilder::parse_compression_type("SNAPPY", 0).unwrap(),
pub fn read_writer_generation(metadata: &FileMetaData, file_index: usize) -> i64 {
        ));
    match dt {
        let mut type_bf_enabled = HashMap::new();
}
            bloom_filter_ndv: Some(100_000),
        );
            Encoding::RLE_DICTIONARY
            "RLE_DICTIONARY" | "DICTIONARY" => Ok(Encoding::RLE_DICTIONARY),
            "name".to_string(),
        assert_eq!(
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    fn test_parse_compression_types() {
        };
            Encoding::DELTA_BYTE_ARRAY => matches!(
            name_bf
            "flag".to_string(),
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            type_bloom_filter_enabled: Some(type_bf_enabled),
        let mut field_configs = HashMap::new();
        assert_eq!(props.encoding(&col_path), None);
        assert_eq!(props.encoding(&col_path), Some(Encoding::PLAIN));
    metadata
        );
                        element_type,
            field_configs: Some(field_configs),
            .iter()
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            ..Default::default()
        type_encoding.insert("utf8".to_string(), "DELTA_BYTE_ARRAY".to_string());
        let age_path = parquet::schema::types::ColumnPath::from("age");
            ("value", ArrowDataType::Int32),
        );
            field_configs: Some(field_configs),
    #[test]
    ///
            "name fpp should be 0.01, got {}",
        match compression_type.to_uppercase().as_str() {
            ..Default::default()
            Some(Encoding::DELTA_BINARY_PACKED)
    fn test_type_level_compression_overrides_global() {
    }
        );
            props.encoding(&age_path),
            ..Default::default()
            other => Err(format!("Unknown encoding type: '{}'", other)),
            ("age", ArrowDataType::Int32),
        let schema = schema_with(vec![("age", ArrowDataType::Int32)]);
            "name".to_string(),
        let config = NativeSettings::default();
        let schema = schema_with(vec![("test_col", ArrowDataType::Utf8)]);
    fn test_field_compression_overrides_type_compression() {
                let element_type = effective_type(f.data_type());
            props.compression(&col_path)
        let mut field_names: std::collections::HashSet<&str> = std::collections::HashSet::new();
    }
    }
        ));
            ..Default::default()
        assert_eq!(props.encoding(&col_path), Some(Encoding::RLE));
            "RLE" => Ok(Encoding::RLE),
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        };
        assert!(result.unwrap_err().contains("nonexistent"));
            ..Default::default()
        assert!(value_bf.is_some(), "value should have bloom filter");
    #[test]
        );
    }
            props.compression(&parquet::schema::types::ColumnPath::from("test")),
        builder = Self::apply_row_group_settings(builder, config);
    #[test]
                        return Err(format!(
        assert_eq!(age_bf.ndv, 100_000, "age ndv should be 100000");
                    builder = builder.set_column_encoding(column_path.clone(), enc);
                Some(gen.to_string()),
    use crate::native_settings::NativeSettings;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        let mut field_configs = HashMap::new();
pub const FORMAT_VERSION_KEY: &str = "opensearch.format_version";
/// `list`/`element` segment names match what the arrow-rs writer emits for `DataType::List`.
        schema: &ArrowSchema,
        }
    }
                } else {
        let col_path = parquet::schema::types::ColumnPath::from("test_col");
        };
            compression_type: Some("ZSTD".to_string()),
    #[test]
    fn test_rle_dictionary_enables_dictionary_not_column_encoding() {
        assert!(matches!(
/// Maps an Arrow DataType to a lowercase string key used for cluster-level type config lookups.
        };
        field_configs.insert(
        // "name" (utf8) should have no explicit encoding (uses default)
            bloom_filter_enabled: Some(true),
    fn test_multiple_type_level_encodings_for_different_types() {
        // Key config decisions off the element type and address the column by its full leaf path,
        let schema = schema_with(vec![("id", ArrowDataType::Int32)]);
        let mut field_configs = HashMap::new();
    #[test]
        };
            },
                if matches!(
        let col_path = parquet::schema::types::ColumnPath::from("test_col");
            Encoding::PLAIN => true,
    fn test_list_column_bloom_filter_on_leaf_path() {
            bloom_filter_ndv: Some(100_000),
            bloom_filter_enabled: Some(false),
        field_configs.insert(
        assert!(!props.dictionary_enabled(&name_path));
        .and_then(|kvs| {
    }
/// This struct follows the Single Responsibility Principle by focusing
    fn test_bloom_filter_default_is_false() {
    fn test_valid_encoding_for_type_succeeds() {
            props.bloom_filter_properties(&name_path).is_none(),
        );
        assert!(has_format, "format_version stamp missing");
            "LZ4_RAW" => Ok(Compression::LZ4_RAW),
            Compression::UNCOMPRESSED
                .and_then(|kv| kv.value.as_ref())
        type_bf_enabled.insert("utf8".to_string(), true);
            .any(|k| k.key == FORMAT_VERSION_KEY && k.value.as_deref() == Some(FORMAT_VERSION));
                    | Time32(_)
        field_configs.insert(
            .expect_err("DELTA_BYTE_ARRAY must be rejected for a list of Int64");
        );
            ));
            let index_cfg = config
        let config = NativeSettings {
            "expected SNAPPY but got {:?}",
                .as_ref()
                bloom_filter_enabled: Some(false),
            "BROTLI" => Ok(Compression::BROTLI(
 * The OpenSearch Contributors require contributions made to
        let config = NativeSettings {
                    ),
            ..Default::default()
    fn apply_row_group_settings(
                    return Err(format!(
                } else if let Some(enc) = type_key.and_then(|t| {
                ..Default::default()
            // Encoding: parse once, validate, apply. Skip if nothing set.
    }
        ));
    }
            age_bf.fpp
        let config = NativeSettings {
                        .and_then(|t| config.type_bloom_filter_enabled.as_ref()?.get(t).copied())
        builder = Self::apply_compression_settings(builder, config)?;
    fn test_scalar_column_path_unchanged() {
            bloom_filter_enabled: Some(false),
                    | Timestamp(_, _)
                    | Duration(_)
            field_configs: Some(field_configs),
        let mut field_configs = HashMap::new();
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
            "PLAIN" => Ok(Encoding::PLAIN),
            Encoding::RLE => matches!(dt, Boolean),
            props.bloom_filter_properties(&age_path).is_none(),
            Some(Encoding::DELTA_LENGTH_BYTE_ARRAY)
            .iter()
        let schema = schema_with(vec![("flag", ArrowDataType::Boolean)]);
            field_configs: Some(field_configs),
                ..Default::default()
    }
                ..Default::default()
                        .get(t)
                    | Int64
        let schema = schema_with(vec![("timestamp", ArrowDataType::Int64)]);
                Utf8 | LargeUtf8 | Binary | LargeBinary | FixedSizeBinary(_)
        let result = WriterPropertiesBuilder::build(&config, &schema);
        assert!(matches!(
        // "name": field-level fpp=0.01, ndv=200000 (overrides type utf8 fpp=0.05, ndv=50000)
        let mut kv_metadata = vec![KeyValue::new(
            compression_type: Some("SNAPPY".to_string()),
            ..Default::default()
        parquet::schema::types::ColumnPath::new(vec![
        ));
            ..Default::default()
        let config = NativeSettings {
            type_bloom_filter_enabled: Some(type_bf_enabled),
    }
        let col_path = parquet::schema::types::ColumnPath::from("name");
        ]);
                        enc, arrow_type, field_name
        let config = NativeSettings {
        let name_bf = props.bloom_filter_properties(&name_path);
        );
    fn apply_dictionary_settings(
            }
        ])
            let compression: Option<Compression> =
        field_configs.insert(
        let result = WriterPropertiesBuilder::build(&config, &schema);
            FieldConfig {
        let found = kv.iter().find(|k| k.key == FORMAT_VERSION_KEY);
        List(f) | LargeList(f) | FixedSizeList(f, _) => effective_type(f.data_type()),
        // Type-level sets fpp/ndv for utf8, field-level overrides fpp for "name"
    fn test_build_with_generation_stamps_both() {
            .bloom_filter_properties(&parquet::schema::types::ColumnPath::from("age"))
                            }
        let type_map: std::collections::HashMap<&str, FieldEntry<'_>> = schema
/// - **Dependency Inversion**: Depends on NativeSettings abstraction
            ..Default::default()
                Int8 | Int16
                ZstdLevel::try_new(level).unwrap_or(ZstdLevel::default()),
    ) -> Result<WriterProperties, String> {
        assert!(
            }
        field_configs.insert(
        };
        assert_eq!(props.encoding(&col_path), Some(Encoding::PLAIN));
                ..Default::default()
    }
        let config = NativeSettings {
                    .and_then(|fc| fc.bloom_filter_ndv)
    /// A fully configured WriterProperties instance
}
            ("age", ArrowDataType::Int32),
    }
        builder: parquet::file::properties::WriterPropertiesBuilder,
        type_encoding.insert("int64".to_string(), "DELTA_BINARY_PACKED".to_string());
            let (arrow_type, type_key, column_path) = match type_map.get(field_name) {
use crate::native_settings::NativeSettings;
    /// Applies dictionary encoding settings.
                bloom_filter_fpp: Some(0.01),
    }
            type_compression_configs: Some(type_compression),
        let kv = props.key_value_metadata().expect("KV metadata missing");
    fn list_leaf_path(name: &str) -> parquet::schema::types::ColumnPath {
                .and_then(|kv| kv.value.clone())
fn column_path_for(field: &arrow::datatypes::Field) -> parquet::schema::types::ColumnPath {
        assert!(
    #[test]
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            field_configs: Some(field_configs),
        assert_eq!(
                ..Default::default()
                        "_id" => Some(Self::parse_compression_type("LZ4_RAW", 0)?),
            FieldConfig {
            field_configs: Some(field_configs),
        builder: parquet::file::properties::WriterPropertiesBuilder,
    }
            props.bloom_filter_properties(&col_path).is_none(),
        );
                        type_key
            if let Some(enc) = encoding {
 * compatible open source license.
    fn test_byte_stream_split_on_float() {
            FieldConfig {
                    Encoding::DELTA_BINARY_PACKED
        };
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let age_bf = props
        ]);
    fn test_field_encoding_overrides_type_encoding() {
                ..Default::default()
        ]);
        };
    }
            bloom_filter_enabled: Some(false),
    fn test_list_column_resolves_type_level_config_by_element_type() {
            Encoding::DELTA_BINARY_PACKED
                        _ => match type_key {
        let mut field_configs = HashMap::new();
        );
                bloom_filter_enabled: Some(true),
            Compression::SNAPPY
        let schema = schema_with(vec![("flag", ArrowDataType::Boolean)]);
            .unwrap();
            "utf8 type-level enabled should override global disabled"
        let config = NativeSettings {
                ..Default::default()
                .or_else(|| {
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let name_path = parquet::schema::types::ColumnPath::from("name");
    }
            config.get_compression_level(),
                            .and_then(|t| config.type_bloom_filter_ndv.as_ref()?.get(t).copied())
                } else {
        // so a LIST column is configured like the scalar column of its element type.
            // Bloom filter: field-level > type-level > global. Applied per-column.
    fn test_type_level_compression_applied() {
                encoding_type: Some("RLE_DICTIONARY".to_string()),
        field_configs.insert(
        let config = NativeSettings {
        assert_ne!(
        ]);
        assert!(result.is_err());
use parquet::basic::{BrotliLevel, Compression, Encoding, GzipLevel, ZstdLevel};
            ("age", ArrowDataType::Int32),
    ///
                    Some(parsed)
        let schema = schema_with(vec![("row_id", ArrowDataType::Int64)]);
                ..Default::default()
            (title_bf.fpp - 0.05).abs() < 1e-9,
            },
        // Apply row group settings
        // wrapper at the element, otherwise every encoding would be accepted for a list column.
        builder = builder.set_key_value_metadata(Some(kv_metadata));
        let mut field_configs = HashMap::new();
use parquet::file::properties::WriterProperties;
                ..Default::default()
        assert!(props.dictionary_enabled(&col_path));
                .into_iter()
        // DELTA_BYTE_ARRAY is valid for Utf8 but not Int64. Validation must look through the list
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()), // valid for utf8
                    }
/// `ColumnPath::from(String)` yields a single-segment path, which only matches primitive columns.
        };
        builder: parquet::file::properties::WriterPropertiesBuilder,
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
            "DELTA_BYTE_ARRAY" => Ok(Encoding::DELTA_BYTE_ARRAY),
                ..Default::default()
    /// # Returns
        type_encoding.insert("int32".to_string(), "DELTA_BINARY_PACKED".to_string());
        // A cluster-level `utf8` rule must apply to LIST<Utf8>: the type key is derived from the
                        "_id" => Some(Encoding::PLAIN),
    fn test_type_level_encoding_applied() {
            },
            FieldConfig {
    /// to create a complete WriterProperties instance for Parquet writing.
        assert_eq!(props.encoding(&col_path), Some(Encoding::BYTE_STREAM_SPLIT));
        field_configs.insert(
        assert_eq!(
        assert_eq!(title_bf.ndv, 50_000, "title ndv should be 50000");
            props
        ArrowSchema::new(
        let config2 = NativeSettings {
    parquet::schema::types::ColumnPath::new(parts)
                ..Default::default()
    /// # Returns
                ..Default::default()
                (
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
    ) -> parquet::file::properties::WriterPropertiesBuilder {
    use std::collections::HashMap;
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let props = WriterPropertiesBuilder::build_with_generation(&config, Some(42), &schema)
            "flag".to_string(),
        let has_format = kv
            field_configs: Some(field_configs),
    fn test_field_bloom_filter_overrides_type_level() {
        type_encoding.insert("int32".to_string(), "DELTA_BINARY_PACKED".to_string());
            },
        // generation is stamped only when provided.
}
    ) -> Result<parquet::file::properties::WriterPropertiesBuilder, String> {
            (age_bf.fpp - 0.1).abs() < 1e-9,
            fields
        let col_path = parquet::schema::types::ColumnPath::from("age");
        assert!(matches!(props.compression(&col_path), Compression::ZSTD(_)));
    /// Applies field-level configurations.
        let mut type_compression = HashMap::new();
            for name in fc.keys() {
/// solely on the conversion logic from configuration to Parquet properties.
    #[test]
        let mut field_configs = HashMap::new();
            (name_bf.fpp - 0.01).abs() < 1e-9,
                encoding_type: Some("PLAIN".to_string()),
            matches!(props.compression(&name_path), Compression::ZSTD(_)),
    #[test]
        }
        let schema = schema_with(vec![
    match dt {
        builder = Self::apply_page_settings(builder, config);
    ) -> parquet::file::properties::WriterPropertiesBuilder {
        field_configs.insert(
        let col_path = parquet::schema::types::ColumnPath::from("name");
    #[test]
            "name".to_string(),
        config: &NativeSettings,
            "tags".to_string(),
        );
                    Some(Self::parse_compression_type(comp, level)?)
            props.encoding(&parquet::schema::types::ColumnPath::from("name")),
            },
    }
        Binary | LargeBinary => "binary".into(),
        })
        let name_path = parquet::schema::types::ColumnPath::from("name");
            ("name", ArrowDataType::Utf8),
            WriterPropertiesBuilder::parse_compression_type("BROTLI", 3).unwrap(),
    fn list_schema(name: &str, element: ArrowDataType) -> ArrowSchema {
        // Build the full KV metadata vector. Format version is always stamped; writer
        // int64 encoding should NOT apply to utf8 columns
/// - **Open/Closed**: Can be extended with new compression types without modification
            FieldConfig {
    }
    }
            Some(Encoding::DELTA_BINARY_PACKED)
            FieldConfig {
            FieldConfig {
    }
            "score".to_string(),
        Int64 => "int64".into(),
        };
            ..Default::default()
            "PLAIN should disable dictionary even when overriding type-level"
        // Apply compression settings
            ..Default::default()
                dt,
            ("name", ArrowDataType::Utf8),
    #[test]
            WriterPropertiesBuilder::parse_encoding_type("RLE_DICTIONARY").unwrap(),
                dt,
        let age_path = parquet::schema::types::ColumnPath::from("age");
        other => other,
                builder = builder.set_column_bloom_filter_fpp(column_path.clone(), bf_fpp);
        let col_path = parquet::schema::types::ColumnPath::from("score");
fn arrow_type_key(dt: &arrow::datatypes::DataType) -> String {
        );
 */
        let schema = ArrowSchema::new(Vec::<Field>::new());
                encoding_type: Some("PLAIN".to_string()),
            "name".to_string(),
            Encoding::DELTA_LENGTH_BYTE_ARRAY => {
        config: &NativeSettings,
}
        let bf_props = props.bloom_filter_properties(&col_path);
        type_encoding.insert("int64".to_string(), "DELTA_BINARY_PACKED".to_string());
    use arrow::datatypes::DataType::*;
    }
        let name_path = parquet::schema::types::ColumnPath::from("name");
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        ]);
                    | UInt64
            "name".to_string(),
            kv_metadata.push(KeyValue::new(
                encoding_type: Some("RLE".to_string()),
                ..Default::default()
        let entry = found.expect("format_version KV entry missing");
        assert!(
        )
                ..Default::default()
    #[test]
                matches!(dt, Utf8 | LargeUtf8 | Binary | LargeBinary)
                        .type_encoding_configs
        let result = WriterPropertiesBuilder::build(&config, &schema);
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        );
            ..Default::default()
            "element".to_string(),
            "age".to_string(),
    }
            if bf_enabled {
        assert!(WriterPropertiesBuilder::build(&config, &schema).is_ok());
        type_encoding.insert("utf8".to_string(), "DELTA_BINARY_PACKED".to_string()); // invalid for utf8
                            Some("utf8") | Some("binary") => {
        assert!(matches!(
        let config = NativeSettings {
        let mut field_configs = HashMap::new();
            !props.dictionary_enabled(&col_path),
    }
        }
pub struct WriterPropertiesBuilder;
            "field-level disabled should override type-level enabled"
            ),
            ("name", ArrowDataType::Utf8),
            FieldConfig {
        ));
        };
    metadata
    }
    }
            let encoding: Option<Encoding> =
        assert_eq!(
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()),
                ..Default::default()
    }
            ..Default::default()
        };
            .set_data_page_row_count_limit(config.get_page_row_limit())
            ..Default::default()
            .map(|f| {
        // Regression guard: non-list columns must still be addressed by bare name.
            type_encoding_configs: Some(type_encoding),
        assert!(matches!(
                ..Default::default()
        );
    fn test_invalid_encoding_for_type_returns_error() {
            .iter()
        );
    /// Builds WriterProperties with an optional writer generation stored as key-value metadata.
        builder: parquet::file::properties::WriterPropertiesBuilder,
            "list".to_string(),
        assert!(err.contains("not supported"), "unexpected error: {}", err);
                    }
        let config = NativeSettings {
        // LZ4 (framed) is deprecated per Parquet spec - use LZ4_RAW instead
        };
    fn test_bloom_filter_disabled_propagates() {
        type_bf_enabled.insert("utf8".to_string(), true);
        };
        let name_path = parquet::schema::types::ColumnPath::from("name");
        );
        let mut field_configs = HashMap::new();
        // age (int32) should use global default (LZ4_RAW from build())
        let col_path = parquet::schema::types::ColumnPath::from("age");
        assert!(!matches!(props.compression(&age_path), Compression::SNAPPY));
            .bloom_filter_properties(&parquet::schema::types::ColumnPath::from("title"))
        );
                    let parsed = Self::parse_encoding_type(enc)?;
    }
/// Reads the writer generation from a Parquet file's key-value metadata.
        // RLE_DICTIONARY should enable dictionary encoding, not set a column encoding
        let mut type_encoding = HashMap::new();
        }
        type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
        assert!(
/// Returns the stamped version string, or an empty string if the metadata is absent
        };
            Encoding::DELTA_BINARY_PACKED
        UInt16 => "uint16".into(),
        );
        for field_name in field_names {
        );
        let name_bf = props
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        };
                    })
            name_bf.is_none(),
                    builder = builder.set_column_dictionary_enabled(column_path.clone(), false);
        assert_eq!(
            field_configs: Some(field_configs),
/// Builds the parquet `ColumnPath` for a top-level Arrow field.
        let config = NativeSettings {
            .unwrap();
        type_encoding.insert("int64".to_string(), "DELTA_BINARY_PACKED".to_string());
            "SNAPPY" => Ok(Compression::SNAPPY),
                    type_key
            ..Default::default()
        ]);
        parts.push(child.name().clone());
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        assert_eq!(
    }
        config: &NativeSettings,
    #[test]
        assert_eq!(entry.value.as_deref(), Some(FORMAT_VERSION));
        };
            ..Default::default()
                .find(|kv| kv.key == WRITER_GENERATION_KEY)
        Self::build_with_generation(config, None, schema)
    fn test_byte_stream_split_invalid_for_string() {
            },
        let schema = schema_with(vec![("age", ArrowDataType::Int64)]);
            FieldConfig {
    #[test]
                compression_type: Some("ZSTD".to_string()),
    #[test]
            Some(Encoding::DELTA_BINARY_PACKED)
        assert!(WriterPropertiesBuilder::parse_encoding_type("DELTA_BINRY_PACKED").is_err());
        let schema = schema_with(vec![
                    .unwrap_or(config.get_bloom_filter_ndv());
    }
        let config = NativeSettings::default();
    ///
        assert!(matches!(props.compression(&name_path), Compression::SNAPPY));
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            FieldConfig {
        assert!(
            ..Default::default()
        );
        let config = NativeSettings {
                        "_primary_term" | "_version" => Some(Compression::UNCOMPRESSED),
        );
            "DELTA_BINARY_PACKED" | "DELTA" => Ok(Encoding::DELTA_BINARY_PACKED),
            ),
    }
        );
    }
                        | Encoding::BYTE_STREAM_SPLIT
            ..Default::default()
        assert!(result.is_err());
            &'a arrow::datatypes::DataType,
            bloom_filter_fpp: Some(0.1),
        let config = NativeSettings {
                        ));
            Compression::GZIP(_)
        let schema = schema_with(vec![
///
                encoding_type: Some("PLAIN".to_string()),
        };
                encoding_type: Some("PLAIN".to_string()),
        let config = NativeSettings {
            FieldConfig {
        };
        assert!(
/// Parquet file-level metadata key for the opensearch-defined parquet format version.
        assert!(WriterPropertiesBuilder::build(&config, &schema).is_err());
        ]);
            FieldConfig {
                encoding_type: Some("DELTA_BINARY_PACKED".to_string()), // invalid for utf8
        config: &NativeSettings,
    ///
        let mut field_configs = HashMap::new();
    #[test]
        let mut field_configs = HashMap::new();
    }
            ..Default::default()
        assert!(result.unwrap_err().contains("DELTA_BINARY_PACKED"));
        );
                        _ => match type_key {
                    builder = builder.set_column_dictionary_enabled(column_path.clone(), true);
        }
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
            "DELTA_LENGTH_BYTE_ARRAY" => Ok(Encoding::DELTA_LENGTH_BYTE_ARRAY),
            "age".to_string(),
    fn test_type_level_compression_only_applies_to_matching_type() {
        assert!(matches!(
        let col_path = parquet::schema::types::ColumnPath::from("name");
            }
                    .unwrap_or(config.get_bloom_filter_fpp());
        let mut field_configs = HashMap::new();
            "name".to_string(),
            type_encoding_configs: Some(type_encoding),
    while let List(child) | LargeList(child) | FixedSizeList(child, _) = current {
    }
    ///
        let mut type_encoding = HashMap::new();
        let config = NativeSettings {
/// Returns the generation value, or falls back to `file_index` if not present.
                };
    #[test]
    fn test_rle_valid_only_for_boolean() {
    fn empty_schema() -> ArrowSchema {
        UInt64 => "uint64".into(),
                .collect::<Vec<Field>>(),
    /// Parses compression type string to Parquet Compression enum.
        );
            ..Default::default()
        assert!(has_gen, "writer_generation stamp missing");
        let col_path = parquet::schema::types::ColumnPath::from("name");
        assert!(!props.dictionary_enabled(&col_path));
            },
        let mut field_configs = HashMap::new();
            field_configs: Some(field_configs),
        field_configs.insert(
        );
        assert_eq!(props.encoding(&col_path), None);
            },
                                Some(Self::parse_compression_type("ZSTD", 3)?)
                    | Time64(_)
    #[test]
        assert!(
        let mut field_configs = HashMap::new();
            if let Some(comp) = compression {
            Some(Encoding::DELTA_BINARY_PACKED)
    #[test]
            field_configs: Some(field_configs),
        type_compression.insert("int32".to_string(), "ZSTD".to_string());
                bloom_filter_enabled: Some(true),
                    | UInt8
            WriterPropertiesBuilder::parse_compression_type("LZ4_RAW", 0).unwrap(),
        field_configs.insert(
    #[test]
        let age_path = parquet::schema::types::ColumnPath::from("age");
                    .or_else(|| {
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()),
                    config
            let bf_enabled = index_cfg
            "name".to_string(),
                    // Metadata field defaults by name, then type-based defaults
            type_compression_configs: Some(type_compression),
        // "age" (int64) should have DELTA_BINARY_PACKED
                    match field_name {
    #[test]
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    #[test]
                        .map(|s| s.as_str())
    fn test_plain_encoding_applied() {
    fn test_column_bloom_filter_disabled_overrides_global() {
pub const WRITER_GENERATION_KEY: &str = "opensearch.writer_generation";
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        if let Some(gen) = writer_generation {
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
/*
            ("age", ArrowDataType::Int32),
            props.bloom_filter_properties(&name_path).is_some(),
            field_configs: Some(field_configs),
    ///
            "utf8 has type-level set to ZSTD"
            FieldConfig {
                builder = builder.set_column_compression(column_path.clone(), comp);
            bf_props.is_some(),
            "int32 has no type-level setting, should use global disabled"
        );
        }
    fn parse_encoding_type(encoding_type: &str) -> Result<Encoding, String> {
                        },
            config.get_compression_type(),
                        .map(|s| s.as_str())
                let bf_fpp = index_cfg
                        | Encoding::DELTA_LENGTH_BYTE_ARRAY
            ..Default::default()
        };
                }) {
        // "title": field-level enabled but no fpp/ndv -> falls to type utf8 fpp=0.05, ndv=50000
        assert!(!props.dictionary_enabled(&col_path));
            ..Default::default()
            props.encoding(&col_path),
            matches!(props.compression(&col_path), Compression::SNAPPY),
        field_configs.insert(
        field_configs.insert(
            field_configs: Some(field_configs.clone()),
            },
        ));
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        field_configs.insert(
            type_bloom_filter_fpp: Some(type_bf_fpp),
impl WriterPropertiesBuilder {
            field_configs: Some(field_configs),
        assert!(matches!(
            type_bloom_filter_ndv: Some(type_bf_ndv),
}
        )?;
        );
        let err = WriterPropertiesBuilder::build(&config, &schema)
            WriterPropertiesBuilder::parse_compression_type("UNCOMPRESSED", 0).unwrap(),
        assert!(result.is_err());
        let config = NativeSettings {
    /// Builds WriterProperties from a NativeSettings.
    }
            "name".to_string(),
            bloom_filter_enabled: Some(true),
        // The single-segment path must NOT carry the setting — that was the silent-no-op bug.
                .and_then(|fc| fc.bloom_filter_enabled)
                    .or_else(|| {
        assert!(
            Compression::ZSTD(_)
        assert_eq!(
        assert_eq!(name_bf.ndv, 200_000, "name ndv should be 200000");
        };
    /// A LIST column's leaf lives at `<field>.list.element`; a single-segment path would miss it
    #[test]
    fn test_dictionary_alias_enables_dictionary() {
        type_bf_fpp.insert("utf8".to_string(), 0.05);
        match encoding {
        );
            ("name", ArrowDataType::Utf8),
                ..Default::default()
            FieldConfig {
        };
        type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
        let config = NativeSettings {
            FieldConfig {
                } else if let Some(comp) = type_key.and_then(|t| {
        Ok(builder.build())
            FieldConfig {
    }
pub fn read_format_version(metadata: &FileMetaData) -> String {
/// Builder for converting NativeSettings into Parquet WriterProperties.
        assert!(matches!(props.compression(&col_path), Compression::SNAPPY));
        );
        config: &NativeSettings,
                        .as_ref()?
            WriterPropertiesBuilder::parse_encoding_type("DICTIONARY").unwrap(),
            "title fpp should be 0.05, got {}",
        assert!(WriterPropertiesBuilder::build(&config2, &schema2).is_err());
        let name_path = parquet::schema::types::ColumnPath::from("name");
    /// * `level` - Compression level (algorithm-dependent)
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
                };
        let col_path = parquet::schema::types::ColumnPath::from("timestamp");
                            Some(Encoding::DELTA_BINARY_PACKED)
        let mut type_bf_enabled = HashMap::new();
        assert!(!props.dictionary_enabled(&col_path));
        assert!(WriterPropertiesBuilder::parse_compression_type("SNPPY", 0).is_err());
                encoding_type: Some("BYTE_STREAM_SPLIT".to_string()),
            },
        .unwrap_or_default()
                    })
        );
        let schema = schema_with(vec![("score", ArrowDataType::Float64)]);
    fn test_parse_encoding_types() {
        ArrowSchema::new(Vec::<Field>::new())
                    }
            ..Default::default()
                encoding_type: Some("RLE_DICTIONARY".to_string()),
        );
            )),
        let schema = list_schema("tags", ArrowDataType::Utf8);
            WriterPropertiesBuilder::parse_encoding_type("DELTA_BINARY_PACKED").unwrap(),
        mut builder: parquet::file::properties::WriterPropertiesBuilder,
                        | Encoding::DELTA_BYTE_ARRAY
/// # Design Principles
    }
            Compression::UNCOMPRESSED
            field_configs: Some(field_configs),
            name.to_string(),
            bf_props.is_none(),
    fn test_build_stamps_format_version() {
                        .type_compression_configs
        let mut field_configs = HashMap::new();
        let col_path = parquet::schema::types::ColumnPath::from("flag");
    }
            type_compression_configs: Some(type_compression),
use arrow::datatypes::Schema as ArrowSchema;
                        field_name
        type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
                WRITER_GENERATION_KEY.to_string(),
    /// # Arguments
        let value_path = parquet::schema::types::ColumnPath::from("value");
    }
            ..Default::default()
        field_configs.insert(
                        column_path_for(f),
    fn test_unknown_field_in_field_configs_returns_error() {
            ..Default::default()
        writer_generation: Option<i64>,
        let schema = schema_with(vec![("flag", ArrowDataType::Boolean)]);
        assert_eq!(props.encoding(&name_path), Some(Encoding::DELTA_BYTE_ARRAY));
            bloom_filter_enabled: Some(true),
        let mut field_configs = HashMap::new();
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()),
            matches!(props.compression(&age_path), Compression::ZSTD(_)),
                    if !Self::is_encoding_valid_for_type(parsed, arrow_type) {
        assert!(
            ("age", ArrowDataType::Int32),
        config: &NativeSettings,
    fn test_delta_binary_packed_disables_dictionary() {
/// A LIST column's leaf lives at `<field>.list.element`, so per-column encoding, compression, and
                GzipLevel::try_new(level as u32).unwrap_or_default(),
            props.encoding(&age_path),
            },
                    }
                ..Default::default()
                    builder = builder.set_column_encoding(column_path.clone(), enc);
            .unwrap();
            }
            type_compression_configs: Some(type_compression),
                        },
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        assert_eq!(
                builder = builder.set_column_bloom_filter_ndv(column_path.clone(), bf_ndv);
    ) -> parquet::file::properties::WriterPropertiesBuilder {
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        builder
    #[test]
        schema: &ArrowSchema,
        let col_path = parquet::schema::types::ColumnPath::from("name");
        let config = NativeSettings {
    ///
        let config = NativeSettings::default();
        field_configs.insert(
        builder = Self::apply_field_configs(builder, config, schema)?;
                ..Default::default()
    }
        );
        .and_then(|kvs| {
    fn apply_compression_settings(
                    ))
        assert_eq!(props.encoding(&col_path), Some(Encoding::PLAIN));
                .and_then(|m| m.get(field_name));
            Some(Encoding::DELTA_BYTE_ARRAY),
            props.compression(&list_leaf_path("tags")),
        let mut field_configs = HashMap::new();
                encoding_type: Some("RLE".to_string()),
/// - **Single Responsibility**: Only handles WriterProperties construction
            FieldConfig {
            "flag".to_string(),
                ..Default::default()
            ..Default::default()
                encoding_type: Some("DELTA_BINARY_PACKED".to_string()),
        if let Some(fc) = &config.field_configs {
        let compression = Self::parse_compression_type(
            ..Default::default()
        UInt8 => "uint8".into(),
            FieldConfig {
        Date32 | Date64 => "date".into(),
    fn test_bloom_filter_fpp_ndv_3tier_fallback() {
            ..Default::default()
        );
    }
            type_encoding_configs: Some(type_encoding),
            field_configs: Some(field_configs),
                    if !Self::is_encoding_valid_for_type(parsed, arrow_type) {
        let kv = props.key_value_metadata().expect("KV metadata missing");
        let config = NativeSettings {
    /// This method applies both index-level and field-level configurations
        let config = NativeSettings {
                    Some(parsed)
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
/// NOT comparable to Lucene or other format versions. Must stay in sync with the Java
                ..Default::default()
                bloom_filter_enabled: Some(true),
            props.encoding(&col_path),
        };
        .key_value_metadata()
    #[test]
        assert_eq!(
    fn test_list_column_encoding_validated_against_element_type() {
            _ => true,
            },
            ..Default::default()
            },
    #[test]
        let col_path = parquet::schema::types::ColumnPath::from("age");
    pub fn build(
            .set_max_row_group_bytes(Some(config.get_row_group_max_bytes()))
            props.encoding(&parquet::schema::types::ColumnPath::from("tags")),
                    match field_name {
 *
            },
        assert!(
        }
            FORMAT_VERSION_KEY.to_string(),
///
    #[test]
        );
                    Some(Self::parse_compression_type(comp, level)?)
        let config = NativeSettings {
}
            "int32 type-level ZSTD should override global SNAPPY"
            Encoding::DELTA_BINARY_PACKED => matches!(
            })
            },
        ));
        field_configs.insert(
    }
                encoding_type: Some("DELTA_LENGTH_BYTE_ARRAY".to_string()),
    ) -> Result<WriterProperties, String> {
    /// Appropriate Compression enum variant
        assert_eq!(
        );
        let mut field_configs = HashMap::new();
        Boolean => "boolean".into(),
            Encoding::RLE_DICTIONARY
        let schema = list_schema("nums", ArrowDataType::Int64);
        );
    fn apply_page_settings(
        let age_path = parquet::schema::types::ColumnPath::from("age");
            "GZIP" => Ok(Compression::GZIP(
            },
            Compression::SNAPPY
/// the list wrapper, so encoding/compression decisions must be made on the element type.
        );
        let mut field_configs = HashMap::new();
    let mut current = field.data_type();
        assert!(matches!(
        type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
                    (
                dt,
            field_configs: Some(field_configs),
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        assert!(
        assert_eq!(props.encoding(&col_path), Some(Encoding::DELTA_BYTE_ARRAY));
        let config = NativeSettings {
        let col_path = parquet::schema::types::ColumnPath::from("test_col");
            },
            },
use parquet::file::metadata::{FileMetaData, KeyValue};
            "PLAIN encoding should explicitly disable dictionary"
        let name_path = parquet::schema::types::ColumnPath::from("name");
    fn is_encoding_valid_for_type(encoding: Encoding, dt: &arrow::datatypes::DataType) -> bool {
            "name".to_string(),
    }
    fn test_type_level_bloom_filter_overrides_global() {
        current = child.data_type();
            "age fpp should be 0.1, got {}",
        );
        let mut field_configs = HashMap::new();
                        return Err(format!(
                        | Encoding::RLE
        // element, not from the Debug string of the list wrapper.
            WriterPropertiesBuilder::parse_compression_type("ZSTD", 3).unwrap(),
        let config = NativeSettings {
    #[test]
                }) {
            ..Default::default()
            },
        );
        let schema = ArrowSchema::new(Vec::<Field>::new());
            field_configs: Some(field_configs),
                .map(|(name, dt)| Field::new(name, dt, true))
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        let has_gen = kv
        );
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            Encoding::RLE_DICTIONARY => !matches!(dt, Boolean),
                encoding_type: Some("BYTE_STREAM_SPLIT".to_string()),
                )
        let props = WriterPropertiesBuilder::build(&config, &empty_schema()).unwrap();
            )),
        Ok(builder.set_compression(compression))
        let mut type_compression = HashMap::new();
            FieldConfig {
        field_configs.insert(
            kvs.iter()
        let config = NativeSettings {
