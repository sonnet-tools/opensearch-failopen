    }
        };
        assert!(WriterPropertiesBuilder::parse_encoding_type("DELTA_BINRY_PACKED").is_err());
        );
            },
                    type_key
            "PLAIN should disable dictionary even when overriding type-level"
        let name_path = parquet::schema::types::ColumnPath::from("name");
        UInt64 => "uint64".into(),
        let col_path = parquet::schema::types::ColumnPath::from("test_col");
            },
        }
        );
                    builder = builder.set_column_dictionary_enabled(column_path.clone(), false);
        assert!(WriterPropertiesBuilder::build(&config, &schema).is_ok());
        );
/// Returns the generation value, or falls back to `file_index` if not present.
            FieldConfig {
            ..Default::default()
/// # Design Principles
            FieldConfig {
    fn test_bloom_filter_disabled_propagates() {
                dt,
pub fn read_format_version(metadata: &FileMetaData) -> String {
        );
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let config = NativeSettings {
        let config = NativeSettings {
            _ => true,
        assert!(result.unwrap_err().contains("nonexistent"));
                encoding_type: Some("PLAIN".to_string()),
                    builder = builder.set_column_encoding(column_path.clone(), enc);
/// Returns the type that column properties apply to. Parquet encodes a LIST column's leaf, not
    fn apply_dictionary_settings(
    fn test_build_with_generation_stamps_both() {
            field_configs: Some(field_configs),
        field_configs.insert(
        let bf_props = props.bloom_filter_properties(&col_path);
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    /// Builds WriterProperties from a NativeSettings.
        );
        let result = WriterPropertiesBuilder::build(&config, &schema);
    #[test]
/// - **Open/Closed**: Can be extended with new compression types without modification
    ) -> parquet::file::properties::WriterPropertiesBuilder {
            props.compression(&col_path)
            field_configs: Some(field_configs),
        type_bf_fpp.insert("utf8".to_string(), 0.05);
                    .unwrap_or(config.get_bloom_filter_fpp());
        let age_path = parquet::schema::types::ColumnPath::from("age");
}
    }
            Compression::UNCOMPRESSED
        field_configs.insert(
                ..Default::default()
        );
    fn parse_compression_type(compression_type: &str, level: i32) -> Result<Compression, String> {
                    | Date32
        assert!(matches!(
        );
                        .type_encoding_configs
                    Some(parsed)
            Encoding::RLE_DICTIONARY => !matches!(dt, Boolean),
    }
        assert!(result.is_err());
/// (pre-versioning / legacy file). Callers should treat empty-string as "unknown"
            type_compression_configs: Some(type_compression),
            WriterPropertiesBuilder::parse_compression_type("BROTLI", 3).unwrap(),
        // RLE_DICTIONARY should enable dictionary encoding, not set a column encoding
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            bloom_filter_enabled: Some(true),
            type_compression_configs: Some(type_compression),
        builder: parquet::file::properties::WriterPropertiesBuilder,
            FieldConfig {
        assert_eq!(props.encoding(&col_path), Some(Encoding::BYTE_STREAM_SPLIT));
        let mut type_encoding = HashMap::new();
                ..Default::default()
            ..Default::default()
            type_encoding_configs: Some(type_encoding),
                    enc,
            WriterPropertiesBuilder::parse_compression_type("ZSTD", 3).unwrap(),
        );
            .unwrap();
                    Some(Self::parse_compression_type(comp, level)?)
            let encoding: Option<Encoding> =
        assert!(result.is_err());
            kvs.iter()
                .collect::<Vec<Field>>(),
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        // Field sets PLAIN, type sets DELTA_BINARY_PACKED — field wins and dictionary is disabled
    #[test]
        let mut builder = WriterProperties::builder();
        builder
            },
    }
    fn test_build_stamps_format_version() {
            .iter()
impl WriterPropertiesBuilder {
                        return Err(format!(
        let config = NativeSettings {
            "int32 has no type-level setting, should use global disabled"
            // Compression: parse once, apply. No type restriction.
            "age".to_string(),
            !props.dictionary_enabled(&col_path),
                } else {
        assert!(WriterPropertiesBuilder::build(&config2, &schema2).is_err());
            "RLE" => Ok(Encoding::RLE),
    }
        let has_format = kv
    fn test_build_with_compression() {
                        .map(|s| s.as_str())
        assert!(
    }
        field_configs.insert(
            props.compression(&list_leaf_path("tags")),
            "PLAIN encoding should explicitly disable dictionary"
    }
    #[test]
            Encoding::DELTA_BYTE_ARRAY => matches!(
        let kv = props.key_value_metadata().expect("KV metadata missing");
            },
            parquet::schema::types::ColumnPath,
                        },
                .unwrap_or(config.get_bloom_filter_enabled());
        assert!(WriterPropertiesBuilder::parse_encoding_type("unknown").is_err());
        ));
    }
        // LZ4 (framed) is deprecated per Parquet spec - use LZ4_RAW instead
        );
        let name_path = parquet::schema::types::ColumnPath::from("name");
    fn test_type_level_bloom_filter_overrides_global() {
            Some(Encoding::DELTA_BINARY_PACKED)
                    }
        assert_eq!(
        let schema = schema_with(vec![
        List(f) | LargeList(f) | FixedSizeList(f, _) => effective_type(f.data_type()),
                        .as_ref()?
        builder = Self::apply_row_group_settings(builder, config);
        };
        let schema = schema_with(vec![("score", ArrowDataType::Float64)]);
        let col_path = parquet::schema::types::ColumnPath::from("age");
        ));
        assert_eq!(
                    ))
        assert_eq!(
            type_bloom_filter_enabled: Some(type_bf_enabled),
            "utf8 has type-level set to ZSTD"
        let col_path = parquet::schema::types::ColumnPath::from("name");
        use arrow::datatypes::DataType::*;
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        .and_then(|kvs| {
            },
                encoding_type: Some("DELTA_BINARY_PACKED".to_string()),
            ..Default::default()
        assert!(
        let schema = schema_with(vec![("flag", ArrowDataType::Boolean)]);
    #[test]
    }
    fn test_bloom_filter_default_is_false() {
        };
    #[test]
    #[test]
        parquet::schema::types::ColumnPath::new(vec![
        let mut field_configs = HashMap::new();
            "BROTLI" => Ok(Compression::BROTLI(
    fn test_list_column_encoding_validated_against_element_type() {
            "SNAPPY" => Ok(Compression::SNAPPY),
            (age_bf.fpp - 0.1).abs() < 1e-9,
    fn test_rle_valid_only_for_boolean() {
        .key_value_metadata()
    }
        let kv = props.key_value_metadata().expect("KV metadata missing");
                        "Cluster-level encoding '{}' is not supported for type '{:?}' (field '{}')",
    fn test_field_compression_overrides_type_compression() {
 * compatible open source license.
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()),
        );
        assert!(WriterPropertiesBuilder::build(&config, &schema).is_ok());
        Timestamp(_, _) => "timestamp".into(),
    #[test]
                bloom_filter_enabled: Some(false),
        };
        field_configs.insert(
                    f.name().as_str(),
        let child = std::sync::Arc::new(Field::new("element", element, true));
/// rather than rejecting the file; compatibility decisions are plugin-owned.
            if let Some(enc) = encoding {
        assert!(
        assert_eq!(
    /// Applies page size and row limit settings.
        }
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        assert!(
        let config = NativeSettings {
                    let parsed = Self::parse_encoding_type(enc)?;
            FieldConfig {
        let mut type_compression = HashMap::new();
        assert!(result.unwrap_err().contains("DELTA_BINARY_PACKED"));
    }
            Some(Encoding::DELTA_LENGTH_BYTE_ARRAY)
        type FieldEntry<'a> = (
        );
                bloom_filter_ndv: Some(200_000),
            "name".to_string(),
            ));
        assert_eq!(props.encoding(&name_path), Some(Encoding::DELTA_BYTE_ARRAY));
                encoding_type: Some("BYTE_STREAM_SPLIT".to_string()),
        let config = NativeSettings {
        let config = NativeSettings {
    }
        let mut type_bf_enabled = HashMap::new();
    ) -> Result<parquet::file::properties::WriterPropertiesBuilder, String> {
                matches!(dt, Utf8 | LargeUtf8 | Binary | LargeBinary)
    }
        assert!(matches!(
        builder: parquet::file::properties::WriterPropertiesBuilder,
                    .unwrap_or(config.get_bloom_filter_ndv());
        assert!(matches!(props.compression(&col_path), Compression::SNAPPY));
    }
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        // Regression guard: non-list columns must still be addressed by bare name.
            !props.dictionary_enabled(&col_path),
        );
                encoding_type: Some("DELTA_LENGTH_BYTE_ARRAY".to_string()),
            field_configs: Some(field_configs),
        );
            ..Default::default()
            bloom_filter_enabled: Some(true),
            "DELTA_BINARY_PACKED" | "DELTA" => Ok(Encoding::DELTA_BINARY_PACKED),
        builder = Self::apply_field_configs(builder, config, schema)?;
        ]);
    #[test]
                            enc, field_name, arrow_type
    fn schema_with(fields: Vec<(&str, ArrowDataType)>) -> ArrowSchema {
    #[test]
                ..Default::default()
                    }
/// - **Single Responsibility**: Only handles WriterProperties construction
        let col_path = parquet::schema::types::ColumnPath::from("name");
                        "__row_id__" | "_seq_no" | "_primary_term" | "_version" => {
            bloom_filter_enabled: Some(false),
        );
        schema: &ArrowSchema,
        assert!(
pub const FORMAT_VERSION: &str = "1.0.0.0";
            ..Default::default()
            age_bf.fpp
    /// Applies dictionary encoding settings.
            config.get_compression_type(),
        let col_path = parquet::schema::types::ColumnPath::from("test_col");
/*
        let result = WriterPropertiesBuilder::build(&config, &schema);
            ("name", ArrowDataType::Utf8),
                    config
            title_bf.fpp
            bloom_filter_enabled: Some(false),
                    let parsed = Self::parse_encoding_type(enc)?;
                field_names.insert(name.as_str());
    use super::*;
    fn apply_compression_settings(
                .and_then(|kv| kv.value.as_ref())
        builder
                ..Default::default()
        let config = NativeSettings {
/// This struct follows the Single Responsibility Principle by focusing
    #[test]
        let config = NativeSettings {
            bloom_filter_ndv: Some(100_000),
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()),
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let col_path = parquet::schema::types::ColumnPath::from("age");
            ..Default::default()
        let mut type_compression = HashMap::new();
        let compression = Self::parse_compression_type(
            },
            ..Default::default()
        assert!(err.contains("not supported"), "unexpected error: {}", err);
            props.bloom_filter_properties(&name_path).is_none(),
                        return Err(format!(
            FieldConfig {
                ..Default::default()
                }) {
    #[test]
        // Dictionary should be enabled
        };
/// Reads the opensearch format version from a Parquet file's key-value metadata.
                encoding_type: Some("RLE_DICTIONARY".to_string()),
                .find(|kv| kv.key == FORMAT_VERSION_KEY)
        if let Some(gen) = writer_generation {
    fn test_rle_dictionary_invalid_for_boolean() {
        let config = NativeSettings {
        };
}
        let mut type_encoding = HashMap::new();
/// Builds the parquet `ColumnPath` for a top-level Arrow field.
                .and_then(|fc| fc.bloom_filter_enabled)
        );
                    | UInt8
            bloom_filter_fpp: Some(0.1),
                )
        };
                .and_then(|kv| kv.value.clone())
                    | UInt32
            Encoding::DELTA_BINARY_PACKED
    }
            FieldConfig {
    #[test]
        };
        let age_path = parquet::schema::types::ColumnPath::from("age");
    fn apply_row_group_settings(
                    | Time64(_)
            WriterPropertiesBuilder::parse_encoding_type("RLE_DICTIONARY").unwrap(),
            field_configs: Some(field_configs),
        schema: &ArrowSchema,
                GzipLevel::try_new(level as u32).unwrap_or_default(),
            props.bloom_filter_properties(&col_path).is_none(),
    fn list_leaf_path(name: &str) -> parquet::schema::types::ColumnPath {
        );
        let config2 = NativeSettings {
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
/// the list wrapper, so encoding/compression decisions must be made on the element type.
        assert!(matches!(
                        }
    }
        ));
        assert!(!props.dictionary_enabled(&col_path));
        type_bf_enabled.insert("utf8".to_string(), true);
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()),
            "bloom_filter_properties should be None when disabled, got: {:?}",
                .and_then(|m| m.get(field_name));
                let bf_fpp = index_cfg
                Some(gen.to_string()),
    use arrow::datatypes::DataType::*;
            type_encoding_configs: Some(type_encoding),
        assert_eq!(config.get_bloom_filter_enabled(), false);
        );
            },
        type_bf_enabled.insert("utf8".to_string(), true);
            field_names.insert(f.name().as_str());
    /// # Returns
        };
            "value".to_string(),
                ..Default::default()
        let col_path = parquet::schema::types::ColumnPath::from("name");
    fn test_type_level_compression_only_applies_to_matching_type() {
        );
            .set_max_row_group_bytes(Some(config.get_row_group_max_bytes()))
        let mut type_encoding = HashMap::new();
                WRITER_GENERATION_KEY.to_string(),
            field_configs: Some(field_configs),
                (
    #[test]
        let schema = schema_with(vec![("timestamp", ArrowDataType::Int64)]);
}
/// A LIST column's leaf lives at `<field>.list.element`, so per-column encoding, compression, and
            "age".to_string(),
        ]);
                Int8 | Int16
        type_encoding.insert("int32".to_string(), "DELTA_BINARY_PACKED".to_string());
    }
        let config = NativeSettings {
                Utf8 | LargeUtf8 | Binary | LargeBinary | FixedSizeBinary(_)
            bf_props.is_some(),
/// - **Dependency Inversion**: Depends on NativeSettings abstraction
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    }
        // Build the full KV metadata vector. Format version is always stamped; writer
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        assert_eq!(
    #[test]
    #[test]
                .or_else(|| {
        );
        let entry = found.expect("format_version KV entry missing");
                        field_name
    }
                None => {
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    }
            bloom_filter_enabled: Some(true),
    }
    ) -> Result<WriterProperties, String> {
                        type_key
        assert!(
    ///
                        .get(t)
    #[test]
            props.encoding(&col_path),
        assert!(matches!(
        Self::build_with_generation(config, None, schema)
            field_configs: Some(field_configs),
            bloom_filter_enabled: Some(false),
    }
                if let Some(enc) = index_cfg.and_then(|fc| fc.encoding_type.as_deref()) {
                        .type_compression_configs
            field_configs: Some(field_configs),
    fn list_schema(name: &str, element: ArrowDataType) -> ArrowSchema {
        let schema = list_schema("nums", ArrowDataType::Int64);
fn effective_type(dt: &arrow::datatypes::DataType) -> &arrow::datatypes::DataType {
        let config = NativeSettings {
        let config = NativeSettings {
            },
use arrow::datatypes::Schema as ArrowSchema;
                BrotliLevel::try_new(level as u32).unwrap_or_default(),
        type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
            "age".to_string(),
        let mut field_configs = HashMap::new();
                ..Default::default()
        assert_eq!(age_bf.ndv, 100_000, "age ndv should be 100000");
            "flag".to_string(),
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        let mut type_compression = HashMap::new();
    }
            "nonexistent".to_string(),
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            for name in fc.keys() {
        let config = NativeSettings {
            Compression::GZIP(_)
        assert_eq!(
        );
            type_bloom_filter_ndv: Some(type_bf_ndv),
        let mut field_configs = HashMap::new();
/// bloom-filter settings silently no-op for lists unless the full path is spelled out. The
            field_configs: Some(field_configs),
            },
                ..Default::default()
            },
                ..Default::default()
        assert_eq!(
            },
    fn test_field_bloom_filter_overrides_type_level() {
            field_configs: Some(field_configs),
                builder = builder.set_column_compression(column_path.clone(), comp);
                    | Timestamp(_, _)
            "name".to_string(),
    match dt {
        let mut field_configs = HashMap::new();
        // element, not from the Debug string of the list wrapper.
            ..Default::default()
/// constant `ParquetDataFormatPlugin.PARQUET_FORMAT_VERSION`.
            },
        };
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let schema2 = schema_with(vec![("flag", ArrowDataType::Int32)]);
        let schema = schema_with(vec![
    fn test_parse_compression_types() {
                bloom_filter_enabled: Some(false),
        };
    #[test]
        let age_bf = props
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    #[test]
        type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
    }
        );
/// Parquet file-level metadata key for the writer generation.
            "name".to_string(),
        UInt8 => "uint8".into(),
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    fn test_byte_stream_split_on_float() {
    fn test_rle_disables_dictionary_for_boolean() {
                encoding_type: Some("DELTA_BINARY_PACKED".to_string()), // invalid for utf8
            .iter()
            ),
        ]);
            .set_max_row_group_row_count(Some(config.get_row_group_max_rows()))
    use crate::field_config::FieldConfig;
                encoding_type: Some("BYTE_STREAM_SPLIT".to_string()),
        };
        assert_ne!(
                        | Encoding::BYTE_STREAM_SPLIT
                    .or_else(|| {
        // Apply compression settings
    /// This method applies both index-level and field-level configurations
        let age_path = parquet::schema::types::ColumnPath::from("age");
            WriterPropertiesBuilder::parse_encoding_type("DELTA_BINARY_PACKED").unwrap(),
            type_bloom_filter_fpp: Some(type_bf_fpp),
        assert!(
}
        let config = NativeSettings {
        let mut field_configs = HashMap::new();
        // valid for boolean
        }
    fn test_bloom_filter_enabled_propagates() {
                ..Default::default()
        type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
            .bloom_filter_properties(&parquet::schema::types::ColumnPath::from("age"))
            Some(Encoding::DELTA_BINARY_PACKED)
            },
        // Apply page settings
            // Bloom filter: field-level > type-level > global. Applied per-column.
    #[test]
        field_configs.insert(
            "row_id".to_string(),
            Compression::SNAPPY
        schema: &ArrowSchema,
        field_configs.insert(
        let mut type_bf_enabled = HashMap::new();
            ..Default::default()
            other => Err(format!("Unknown encoding type: '{}'", other)),
        );
    fn test_plain_encoding_applied() {
                    (
        );
            kvs.iter()
                encoding_type: Some("RLE_DICTIONARY".to_string()),
        assert!(!props.dictionary_enabled(&col_path));
        Int64 => "int64".into(),
        )];
            ..Default::default()
        assert_eq!(props.encoding(&col_path), None);
        // Field-level config should take precedence over type-level config
        let props = WriterPropertiesBuilder::build(&config, &schema).expect("build failed");
            },
        let found = kv.iter().find(|k| k.key == FORMAT_VERSION_KEY);
        let config = NativeSettings {
        );
                    match field_name {
        assert_eq!(
            Compression::BROTLI(_)
    #[test]
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()), // valid for utf8
                encoding_type: Some("DELTA_BYTE_ARRAY".to_string()),
            field_configs: Some(field_configs),
        let col_path = parquet::schema::types::ColumnPath::from("name");
    }
            .bloom_filter_properties(&parquet::schema::types::ColumnPath::from("name"))
            matches!(props.compression(&col_path), Compression::SNAPPY),
    fn test_list_column_resolves_type_level_config_by_element_type() {
        ArrowSchema::new(Vec::<Field>::new())
            FieldConfig {
        assert_eq!(props.encoding(&col_path), Some(Encoding::DELTA_BYTE_ARRAY));
                encoding_type: Some("PLAIN".to_string()),
            },
            None
            ..Default::default()
        writer_generation: Option<i64>,
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        );
        // age (int32) should use global default (LZ4_RAW from build())
    fn is_encoding_valid_for_type(encoding: Encoding, dt: &arrow::datatypes::DataType) -> bool {
        let mut type_bf_ndv = HashMap::new();
                if matches!(
            props.bloom_filter_properties(&name_path).is_some(),
        Ok(builder.build())
            field_configs: Some(field_configs),
        );
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            ..Default::default()
        };
            field_configs: Some(field_configs),
                let bf_ndv = index_cfg
        Float64 => "float64".into(),
            field_configs: Some(field_configs),
        assert!(matches!(props.compression(&col_path), Compression::ZSTD(_)));
            WriterPropertiesBuilder::parse_compression_type("UNCOMPRESSED", 0).unwrap(),
                ..Default::default()
            FieldConfig {
        config: &NativeSettings,
        );
        );
                ..Default::default()
            "Default should have bloom filter disabled"
        assert!(props.dictionary_enabled(&col_path));
        assert!(!props.dictionary_enabled(&col_path));
    /// * `compression_type` - String representation of compression type
    /// A fully configured WriterProperties instance
            })
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
            },
            ..Default::default()
        let mut field_configs = HashMap::new();
        // "name" (utf8) should have no explicit encoding (uses default)
        let mut field_configs = HashMap::new();
        let mut field_configs = HashMap::new();
                            .and_then(|t| config.type_bloom_filter_ndv.as_ref()?.get(t).copied())
        );
        let bf_props = props.bloom_filter_properties(&col_path);
            ..Default::default()
        assert_eq!(
        let has_gen = kv
        let mut field_configs = HashMap::new();
            FieldConfig {
                            _ => None,
            }
        };
        );
        assert!(!props.dictionary_enabled(&col_path));
        field_configs.insert(
    match dt {
        assert!(WriterPropertiesBuilder::build(&config, &schema).is_err());
        };
            "name".to_string(),
        ));
        ));
                    | Time32(_)
        config: &NativeSettings,
            Some(Encoding::DELTA_BINARY_PACKED)
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
    /// # Returns
            Encoding::DELTA_BINARY_PACKED => matches!(
                    }
            let (arrow_type, type_key, column_path) = match type_map.get(field_name) {
        let name_bf = props
        assert!(has_gen, "writer_generation stamp missing");
        );
                .map(|(name, dt)| Field::new(name, dt, true))
    #[test]
            config.get_compression_level(),
        field_configs.insert(
        type_bf_enabled.insert("int32".to_string(), true);
            FieldConfig {
            bloom_filter_fpp: Some(0.1),
        let config = NativeSettings {
        let schema = schema_with(vec![("flag", ArrowDataType::Boolean)]);
    use arrow::datatypes::{DataType as ArrowDataType, Field, Schema as ArrowSchema};
        Utf8 | LargeUtf8 => "utf8".into(),
        config: &NativeSettings,
///
            field_configs: Some(field_configs),
        let mut field_configs = HashMap::new();
use parquet::file::properties::WriterProperties;
        builder = Self::apply_dictionary_settings(builder, config);
                } else if let Some(enc) = type_key.and_then(|t| {
                }) {
            "timestamp".to_string(),
                    config
        let config = NativeSettings {
            .expect("build failed");
            matches!(props.compression(&age_path), Compression::ZSTD(_)),
    }
            fields
pub const FORMAT_VERSION_KEY: &str = "opensearch.format_version";
                ) {
        );
            FieldConfig {
                compression_type: Some("ZSTD".to_string()),
        let config = NativeSettings {
    fn test_parse_encoding_types() {
    #[test]
            if bf_enabled {
                    return Err(format!(
        ArrowSchema::new(
                };
        let mut field_configs = HashMap::new();
    ///
        let schema = list_schema("tags", ArrowDataType::Utf8);
            field_configs: Some(field_configs),
        let schema = schema_with(vec![("flag", ArrowDataType::Boolean)]);
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
                encoding_type: Some("PLAIN".to_string()),
                    // Metadata field defaults by name, then type-based defaults
                    })
            .unwrap();
            FORMAT_VERSION_KEY.to_string(),
        );
                if let Some(comp) = index_cfg.and_then(|fc| fc.compression_type.as_deref()) {
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        };
        for field_name in field_names {
    }
                ..Default::default()
    pub fn build(
            type_compression_configs: Some(type_compression),
            },
                dt,
        let config = NativeSettings {
        let mut field_configs = HashMap::new();
        );
        let name_path = parquet::schema::types::ColumnPath::from("name");
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        Boolean => "boolean".into(),
        type_encoding.insert("int64".to_string(), "DELTA_BINARY_PACKED".to_string());
        .unwrap_or_default()
        // invalid for int32
            }
        let schema = schema_with(vec![
            Encoding::BYTE_STREAM_SPLIT => matches!(
        Float32 => "float32".into(),
        let name_path = parquet::schema::types::ColumnPath::from("name");
/// Reads the writer generation from a Parquet file's key-value metadata.
            "ZSTD" => Ok(Compression::ZSTD(
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        field_configs.insert(
    /// Applies row group row count and byte size limits.
        };
        ]);
            WriterPropertiesBuilder::parse_compression_type("SNAPPY", 0).unwrap(),
            props.bloom_filter_properties(&age_path).is_none(),
                    })
    #[test]
        );
                builder = builder.set_column_bloom_filter_fpp(column_path.clone(), bf_fpp);
        field_configs.insert(
        parts.push(child.name().clone());
            ..Default::default()
    }
            ..Default::default()
    }
    pub fn build_with_generation(
    ///
    }
    }
        assert!(!matches!(props.compression(&age_path), Compression::SNAPPY));
                ..Default::default()
        parts.push("list".to_string());
    }
                } else {
        let config = NativeSettings {
    #[test]
            ..Default::default()
            type_encoding_configs: Some(type_encoding),
    #[test]
    fn test_delta_byte_array_disables_dictionary() {
        builder = Self::apply_page_settings(builder, config);
        };
    /// Parses compression type string to Parquet Compression enum.
        let type_map: std::collections::HashMap<&str, FieldEntry<'_>> = schema
                .bloom_filter_properties(&list_leaf_path("tags"))
            FieldConfig {
            "UNCOMPRESSED" => Ok(Compression::UNCOMPRESSED),
        );
        let mut field_configs = HashMap::new();
            "name".to_string(),
        };
        assert!(matches!(
    #[test]
    #[test]
        config: &NativeSettings,
        // so a LIST column is configured like the scalar column of its element type.
        );
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        let schema = list_schema("tags", ArrowDataType::Utf8);
        }
        field_configs.insert(
    #[test]
        match compression_type.to_uppercase().as_str() {
pub struct WriterPropertiesBuilder;
        let config = NativeSettings {
                bloom_filter_enabled: Some(true),
        // Key config decisions off the element type and address the column by its full leaf path,
                    Encoding::DELTA_BINARY_PACKED
        );
        assert!(
            Encoding::PLAIN
        assert!(!props.dictionary_enabled(&col_path));
    }
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    fn test_type_level_encoding_applied() {
            FieldConfig {
            field_configs: Some(field_configs),
    /// Applies field-level configurations.
        let mut type_compression = HashMap::new();
                encoding_type: Some("RLE".to_string()),
    ) -> parquet::file::properties::WriterPropertiesBuilder {
        let name_path = parquet::schema::types::ColumnPath::from("name");
        };
            }
    fn test_field_encoding_overrides_type_encoding() {
    fn test_invalid_encoding_for_type_returns_error() {
            ("age", ArrowDataType::Int64),
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        other => other,
    /// Builds WriterProperties with an optional writer generation stored as key-value metadata.
                Float32 | Float64 | Int32 | Int64 | UInt32 | UInt64 | FixedSizeBinary(_)
            "DELTA_BYTE_ARRAY" => Ok(Encoding::DELTA_BYTE_ARRAY),
            ("age", ArrowDataType::Int32),
        let name_path = parquet::schema::types::ColumnPath::from("name");
        let mut field_configs = HashMap::new();
            ("name", ArrowDataType::Utf8),
                    builder = builder.set_column_encoding(column_path.clone(), enc);
        );
        assert!(!props.dictionary_enabled(&col_path));
    }
                    // PLAIN: explicitly disable dictionary so the writer uses plain encoding
            Encoding::RLE => matches!(dt, Boolean),
        let config = NativeSettings {
                })
                ..Default::default()
        let config = NativeSettings {
    use arrow::datatypes::DataType::*;
        for f in schema.fields() {
        let schema = schema_with(vec![("test_col", ArrowDataType::Utf8)]);
                ..Default::default()
    #[test]
        assert_eq!(entry.value.as_deref(), Some(FORMAT_VERSION));
        ]);
        ArrowSchema::new(vec![Field::new(name, ArrowDataType::List(child), true)])
            type_bloom_filter_enabled: Some(type_bf_enabled),
fn arrow_type_key(dt: &arrow::datatypes::DataType) -> String {
            "name".to_string(),
    }
            ..Default::default()
        })
        type_encoding.insert("int32".to_string(), "DELTA_BINARY_PACKED".to_string());
        );
        let config = NativeSettings {
    /// * `level` - Compression level (algorithm-dependent)
    fn test_rle_dictionary_enables_dictionary_not_column_encoding() {
        UInt16 => "uint16".into(),
        assert_eq!(name_bf.ndv, 200_000, "name ndv should be 200000");
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        // "title": field-level enabled but no fpp/ndv -> falls to type utf8 fpp=0.05, ndv=50000
        };
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
            Compression::LZ4_RAW
use parquet::basic::{BrotliLevel, Compression, Encoding, GzipLevel, ZstdLevel};
        config: &NativeSettings,
/// Parquet file-level metadata key for the opensearch-defined parquet format version.
        );
    #[test]
    #[test]
/// NOT comparable to Lucene or other format versions. Must stay in sync with the Java
            WriterPropertiesBuilder::parse_compression_type("GZIP", 6).unwrap(),
    /// A LIST column's leaf lives at `<field>.list.element`; a single-segment path would miss it
    }
        assert!(
    ) -> Result<parquet::file::properties::WriterPropertiesBuilder, String> {
            Some(Encoding::DELTA_BINARY_PACKED)
            type_encoding_configs: Some(type_encoding),
        );
        assert!(matches!(
    /// Applies compression settings to the builder.
    ///
            FieldConfig {
        // The single-segment path must NOT carry the setting — that was the silent-no-op bug.
                    // RLE_DICTIONARY means use dictionary encoding - just ensure it's enabled
    }
    fn apply_page_settings(
            type_encoding_configs: Some(type_encoding),
        let mut type_encoding = HashMap::new();
    /// and every per-column setting would silently fall back to defaults.
        Int8 => "int8".into(),
            WriterPropertiesBuilder::parse_encoding_type("DICTIONARY").unwrap(),
        assert!(result.is_err());
            ..Default::default()
                            }
            props.encoding(&age_path),
        let mut field_configs = HashMap::new();
            type_encoding_configs: Some(type_encoding),
 * The OpenSearch Contributors require contributions made to
            "DELTA_LENGTH_BYTE_ARRAY" => Ok(Encoding::DELTA_LENGTH_BYTE_ARRAY),
    #[test]
            "flag".to_string(),
            ("name", ArrowDataType::Utf8),
        assert!(WriterPropertiesBuilder::build(&config, &schema).is_err());
}
        let value_path = parquet::schema::types::ColumnPath::from("value");
                            Some("timestamp") => Some(Encoding::DELTA_BINARY_PACKED),
        // Apply dictionary settings
                } else if let Some(comp) = type_key.and_then(|t| {
        };
        type_encoding.insert("utf8".to_string(), "DELTA_BINARY_PACKED".to_string()); // invalid for utf8
        assert_eq!(title_bf.ndv, 50_000, "title ndv should be 50000");
        // "name": field-level fpp=0.01, ndv=200000 (overrides type utf8 fpp=0.05, ndv=50000)
                ..Default::default()
            "bloom filter must be enabled on the list leaf path"
        type_compression.insert("int32".to_string(), "ZSTD".to_string());
        let props = WriterPropertiesBuilder::build(&config, &empty_schema()).unwrap();
    use std::collections::HashMap;
        let config = NativeSettings {
        Ok(builder.set_compression(compression))
                        "_id" => Some(Self::parse_compression_type("LZ4_RAW", 0)?),
                        .get(t)
            type_compression_configs: Some(type_compression),
            matches!(props.compression(&name_path), Compression::ZSTD(_)),
        }
        field_configs.insert(
        .key_value_metadata()
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            "BYTE_STREAM_SPLIT" => Ok(Encoding::BYTE_STREAM_SPLIT),
            ("age", ArrowDataType::Int32),
        field_configs.insert(
        field_configs.insert(
    }
            compression_level: Some(5),
#[cfg(test)]
            &'a arrow::datatypes::DataType,
        assert_eq!(props.encoding(&col_path), Some(Encoding::RLE));
        ));
                        _ => match type_key {
        };
    fn apply_field_configs(
    fn test_field_level_compression_applied() {
    }
        let config = NativeSettings {
            let index_cfg = config
                            Some(Encoding::DELTA_BINARY_PACKED)
        };
        field_configs.insert(
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
    ) -> parquet::file::properties::WriterPropertiesBuilder {
        let age_path = parquet::schema::types::ColumnPath::from("age");
        field_configs.insert(
                    | UInt64
            ..Default::default()
            FieldConfig {
                Some(v) => (v.0, Some(v.1.as_str()), v.2.clone()),
    }
                    ));
        field_configs.insert(
            Some(Encoding::DELTA_BYTE_ARRAY)
            "name fpp should be 0.01, got {}",
/// solely on the conversion logic from configuration to Parquet properties.
            FieldConfig {
            ),
    /// Applies bloom filter settings.
        let col_path = parquet::schema::types::ColumnPath::from("name");
                    .or_else(|| {
        builder: parquet::file::properties::WriterPropertiesBuilder,
                .into_iter()
            ("age", ArrowDataType::Int32),
            .set_data_page_row_count_limit(config.get_page_row_limit())
        let col_path = parquet::schema::types::ColumnPath::from("row_id");
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
            ("age", ArrowDataType::Int32),
    metadata
                encoding_type: Some("DELTA_BINARY_PACKED".to_string()),
        // "age" (int64) should have DELTA_BINARY_PACKED
        );
        let mut type_bf_enabled = HashMap::new();
            Compression::UNCOMPRESSED
        builder.set_dictionary_page_size_limit(config.get_dict_size_bytes())
        field_configs.insert(
        Int32 => "int32".into(),
    parquet::schema::types::ColumnPath::new(parts)
                encoding_type: Some("PLAIN".to_string()),
            WriterPropertiesBuilder::parse_encoding_type("PLAIN").unwrap(),
    }
    fn test_type_level_encoding_only_applies_to_matching_type() {
        let config = NativeSettings {
///
        };
            (title_bf.fpp - 0.05).abs() < 1e-9,
    #[test]
 *
        type_bf_ndv.insert("utf8".to_string(), 50_000u64);
                    | UInt16
            ("name", ArrowDataType::Utf8),
                ..Default::default()
        let schema = schema_with(vec![("test_col", ArrowDataType::Utf8)]);
        );
    }
        };
        let mut field_configs = HashMap::new();
        let schema = schema_with(vec![
        if let Some(fc) = &config.field_configs {
            props
    fn test_list_column_uses_leaf_column_path_for_encoding() {
    #[test]
            ..Default::default()
    }
        let config = NativeSettings::default();
            };
        );
                            _ => None,
            other => Err(format!("Unknown compression type: '{}'", other)),
    #[test]
            "age fpp should be 0.1, got {}",
        let schema = schema_with(vec![("age", ArrowDataType::Int64)]);
        assert_eq!(props.encoding(&col_path), Some(Encoding::PLAIN));
        assert_eq!(
        let mut field_configs = HashMap::new();
    }
            compression_type: Some("ZSTD".to_string()),
    fn test_valid_encoding_for_type_succeeds() {
        assert!(props.dictionary_enabled(&col_path));
                        arrow_type_key(element_type),
    }
            ..Default::default()
        };
            bloom_filter_enabled: Some(true),
            Some(Encoding::DELTA_BINARY_PACKED)
        mut builder: parquet::file::properties::WriterPropertiesBuilder,
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        // wrapper at the element, otherwise every encoding would be accepted for a list column.
            "nums".to_string(),
    }
        );
        );
        };
    ///
            ..Default::default()
            "GZIP" => Ok(Compression::GZIP(
    metadata
    }
            },
        let mut type_bf_fpp = HashMap::new();
            // Encoding: parse once, validate, apply. Skip if nothing set.
        type_bf_enabled.insert("utf8".to_string(), true);
        Date32 | Date64 => "date".into(),
        let config = NativeSettings {
            FieldConfig {
    /// to create a complete WriterProperties instance for Parquet writing.
        field_configs.insert(
            String,
            props.encoding(&col_path),
        assert_eq!(
        let schema = schema_with(vec![("id", ArrowDataType::Int32)]);
    #[test]
    }
                compression_type: Some("SNAPPY".to_string()),
        let config = NativeSettings {
    }
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
                                Some(Self::parse_compression_type("ZSTD", 3)?)
            ("name", ArrowDataType::Utf8),
                    // Metadata field defaults by name, then type-based defaults
            ..Default::default()
        field_configs.insert(
    fn test_unknown_field_in_field_configs_returns_error() {
            Encoding::RLE_DICTIONARY
        let mut kv_metadata = vec![KeyValue::new(
        Binary | LargeBinary => "binary".into(),
            bf_props.is_none(),
                ..Default::default()
            props.encoding(&age_path),
            Encoding::RLE_DICTIONARY
 * this file be licensed under the Apache-2.0 license or a
            ..Default::default()
            FieldConfig {
            "bloom_filter_properties should be Some when enabled"
        assert!(
                .and_then(|v| v.parse::<i64>().ok())
                ..Default::default()
            let level = index_cfg.and_then(|fc| fc.compression_level).unwrap_or(3);
        assert!(matches!(props.compression(&name_path), Compression::SNAPPY));
            field_configs: Some(field_configs),
                    .and_then(|fc| fc.bloom_filter_fpp)
        let config = NativeSettings::default();
        assert_eq!(
        assert!(
        assert!(!props.dictionary_enabled(&name_path));
        );
            type_compression_configs: Some(type_compression),
fn column_path_for(field: &arrow::datatypes::Field) -> parquet::schema::types::ColumnPath {
                ..Default::default()
                ..Default::default()
    let mut parts = vec![field.name().clone()];
        let config = NativeSettings {
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
            "score".to_string(),
            .collect();
/// Returns the stamped version string, or an empty string if the metadata is absent
    fn test_byte_stream_split_invalid_for_string() {
            ..Default::default()
        let mut field_names: std::collections::HashSet<&str> = std::collections::HashSet::new();
        }
            "name".to_string(),
            Encoding::PLAIN => true,
        // (setting it as column encoding causes parquet-rs error)
                            "Encoding '{}' is not supported for field '{}' of type '{:?}'",
                        .map(|s| s.as_str())
        // "age": int32 type-level enabled but no fpp/ndv -> falls to global fpp=0.1, ndv=100000
            "list".to_string(),
        let col_path = parquet::schema::types::ColumnPath::from("test_col");
        field_configs.insert(
            },
    fn test_invalid_cluster_encoding_for_type_returns_error() {
                }
            Encoding::DELTA_BINARY_PACKED
        let col_path = parquet::schema::types::ColumnPath::from("age");
            FieldConfig {
 * SPDX-License-Identifier: Apache-2.0
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
                bloom_filter_enabled: Some(true),
        // A cluster-level `utf8` rule must apply to LIST<Utf8>: the type key is derived from the
            WriterPropertiesBuilder::parse_compression_type("LZ4_RAW", 0).unwrap(),
            ("name", ArrowDataType::Utf8),
            },
                    }
    /// # Arguments
                        _ => match type_key {
            "element".to_string(),
        let mut field_configs = HashMap::new();
            "encoding must be set on the list leaf path"
        UInt32 => "uint32".into(),
        field_configs.insert(
    }
        type_encoding.insert("int64".to_string(), "DELTA_BINARY_PACKED".to_string());
    }
        let config = NativeSettings {
            )),
            Some(Encoding::DELTA_BYTE_ARRAY),
        type_encoding.insert("utf8".to_string(), "DELTA_BYTE_ARRAY".to_string());
    fn test_dictionary_alias_enables_dictionary() {
        let col_path = parquet::schema::types::ColumnPath::from("timestamp");
                } else if matches!(enc, Encoding::RLE_DICTIONARY) {
        assert!(result.unwrap_err().contains("DELTA_BINARY_PACKED"));
        builder = Self::apply_compression_settings(builder, config)?;
        let result = WriterPropertiesBuilder::build(&config, &schema);
    fn test_multiple_type_level_encodings_for_different_types() {
            "name".to_string(),
            .expect_err("DELTA_BYTE_ARRAY must be rejected for a list of Int64");
            )),
        let age_path = parquet::schema::types::ColumnPath::from("age");
    fn test_scalar_column_path_unchanged() {
            ..Default::default()
            "name".to_string(),
        let config = NativeSettings {
            }
        match encoding_type.to_uppercase().as_str() {
        assert_eq!(props.encoding(&col_path), Some(Encoding::PLAIN));
            ..Default::default()
        let mut field_configs = HashMap::new();
        };
        );
        let schema = schema_with(vec![
            "RLE_DICTIONARY" | "DICTIONARY" => Ok(Encoding::RLE_DICTIONARY),
/// `ColumnPath::from(String)` yields a single-segment path, which only matches primitive columns.
                ..Default::default()
        );
            "expected SNAPPY but got {:?}",
            .iter()
            ("value", ArrowDataType::Int32),
        };
        assert!(WriterPropertiesBuilder::parse_compression_type("unknown", 0).is_err());
            ..Default::default()
                bloom_filter_enabled: Some(true),
                            Some("utf8") | Some("binary") => {
}
        let name_path = parquet::schema::types::ColumnPath::from("name");
mod tests {
    fn parse_encoding_type(encoding_type: &str) -> Result<Encoding, String> {
            FieldConfig {
            kv_metadata.push(KeyValue::new(
            bloom_filter_ndv: Some(100_000),
                }
    #[test]
    }
        field_configs.insert(
    /// * `config` - The native settings to convert
    }
                        "_id" => Some(Encoding::PLAIN),
    /// # Arguments
            ..Default::default()
                        type_key
                builder = builder.set_column_bloom_filter_enabled(column_path.clone(), true);
        // generation is stamped only when provided.
            },
        })
        let schema = schema_with(vec![
                encoding_type: Some("RLE".to_string()),
                dt,
            .map(|f| {
            FieldConfig {
            ..Default::default()
        );
        );
            },
        assert!(!props.dictionary_enabled(&age_path));
    }
            ("title", ArrowDataType::Utf8),
        );
            field_configs: Some(field_configs),
                        | Encoding::DELTA_LENGTH_BYTE_ARRAY
                builder = builder.set_column_bloom_filter_ndv(column_path.clone(), bf_ndv);
        let schema = schema_with(vec![("age", ArrowDataType::Int64)]);
            "field-level disabled should override type-level enabled"
                let element_type = effective_type(f.data_type());
                .find(|kv| kv.key == WRITER_GENERATION_KEY)
        let err = WriterPropertiesBuilder::build(&config, &schema)
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        // DELTA_BYTE_ARRAY is valid for Utf8 but not Int64. Validation must look through the list
            .set_data_page_size_limit(config.get_page_size_bytes())
        assert!(matches!(
        assert!(WriterPropertiesBuilder::parse_compression_type("LZ4", 0).is_err());
                ..Default::default()
            props.encoding(&parquet::schema::types::ColumnPath::from("name")),
    #[test]
        let col_path = parquet::schema::types::ColumnPath::from("score");
        let config = NativeSettings {
            props.encoding(&parquet::schema::types::ColumnPath::from("tags")),
            name_bf
        config: &NativeSettings,
    #[test]
        field_configs.insert(
                ZstdLevel::try_new(level).unwrap_or(ZstdLevel::default()),
            "name should have no bloom filter, got: {:?}",
                        "_primary_term" | "_version" => Some(Compression::UNCOMPRESSED),
            "flag".to_string(),
    fn test_type_level_compression_overrides_global() {
    use arrow::datatypes::DataType::*;
        assert!(
                bloom_filter_fpp: Some(0.01),
            "name".to_string(),
    while let List(child) | LargeList(child) | FixedSizeList(child, _) = current {
    }
        Int16 => "int16".into(),
                    | Duration(_)
            .any(|k| k.key == FORMAT_VERSION_KEY && k.value.as_deref() == Some(FORMAT_VERSION));
                        | Encoding::RLE
                encoding_type: Some("RLE".to_string()),
        config: &NativeSettings,
            "tags".to_string(),
    #[test]
                        enc, arrow_type, field_name
        let col_path = parquet::schema::types::ColumnPath::from("flag");
        ])
                    builder = builder.set_column_dictionary_enabled(column_path.clone(), false);
            Compression::SNAPPY
            }
            "int32 type-level ZSTD should override global SNAPPY"
            ..Default::default()
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        assert_eq!(
        )?;
        let title_bf = props
                ..Default::default()
    fn test_delta_binary_packed_disables_dictionary() {
        ));
        field_configs.insert(
            ..Default::default()
        assert!(
    fn test_bloom_filter_fpp_ndv_3tier_fallback() {
                    | Date64
                            .and_then(|t| config.type_bloom_filter_fpp.as_ref()?.get(t).copied())
        let mut field_configs = HashMap::new();
                .is_some(),
        let config = NativeSettings {
        let mut field_configs = HashMap::new();
    }
                    | Int32
        let schema = ArrowSchema::new(Vec::<Field>::new());
            ..Default::default()
            WriterPropertiesBuilder::parse_encoding_type("DELTA").unwrap(),
        let col_path = parquet::schema::types::ColumnPath::from("age");
                        column_path_for(f),
            let bf_enabled = index_cfg
        let schema = schema_with(vec![
        let schema = schema_with(vec![("age", ArrowDataType::Int32)]);
        let props = WriterPropertiesBuilder::build_with_generation(&config, Some(42), &schema)
    ///
        let config = NativeSettings {
        let mut type_compression = HashMap::new();
            name_bf.is_none(),
    }
                .field_configs
    ) -> Result<WriterProperties, String> {
        let config = NativeSettings {
            .unwrap();
            "name".to_string(),
        field_configs.insert(
        .unwrap_or(file_index as i64)
    fn test_column_bloom_filter_disabled_overrides_global() {
        builder = builder.set_key_value_metadata(Some(kv_metadata));
            field_configs: Some(field_configs),
            compression_type: Some("SNAPPY".to_string()),
            },
                ..Default::default()
            ..Default::default()
        let col_path = parquet::schema::types::ColumnPath::from("name");
        field_configs.insert(
        let mut field_configs = HashMap::new();
                    match field_name {
            ("name", ArrowDataType::Utf8),
            "PLAIN" => Ok(Encoding::PLAIN),
    let mut current = field.data_type();
                ..Default::default()
        let mut field_configs = HashMap::new();
    #[test]
                    .and_then(|fc| fc.bloom_filter_ndv)
            "name".to_string(),
            type_bloom_filter_enabled: Some(type_bf_enabled),
                        ));
        assert!(value_bf.is_some(), "value should have bloom filter");
        };
        );
        // int64 encoding should NOT apply to utf8 columns
        match encoding {
    fn test_list_column_bloom_filter_on_leaf_path() {
            Encoding::DELTA_LENGTH_BYTE_ARRAY => {
            name.to_string(),
            "flag".to_string(),
    ///
        let col_path = parquet::schema::types::ColumnPath::from("name");
            .any(|k| k.key == WRITER_GENERATION_KEY && k.value.as_deref() == Some("42"));
        assert_eq!(
                ..Default::default()
                        .as_ref()?
                        .and_then(|t| config.type_bloom_filter_enabled.as_ref()?.get(t).copied())
            field_configs: Some(field_configs),
            FieldConfig {
        );
        Ok(builder)
            "title fpp should be 0.05, got {}",
        };
        let config = NativeSettings {
        );
            field_configs: Some(field_configs),
        type_compression.insert("utf8".to_string(), "SNAPPY".to_string());
            "utf8 type-level enabled should override global disabled"
        // Apply row group settings
/// Current parquet format version produced by this writer. Plugin-defined namespace —
        let value_bf = props.bloom_filter_properties(&value_path);
                encoding_type: Some("DICTIONARY".to_string()),
        }
/// Maps an Arrow DataType to a lowercase string key used for cluster-level type config lookups.
            .fields()
            },
        let mut field_configs = HashMap::new();
    ///
/// `list`/`element` segment names match what the arrow-rs writer emits for `DataType::List`.
            FieldConfig {
            props.encoding(&col_path),
    }
            props.encoding(&list_leaf_path("tags")),
    fn test_field_encoding_plain_overrides_type_disables_dictionary() {
                    if !Self::is_encoding_valid_for_type(parsed, arrow_type) {
        ]);
            },
    use crate::native_settings::NativeSettings;
        };
        current = child.data_type();
        .and_then(|kvs| {
                        },
/// Builder for converting NativeSettings into Parquet WriterProperties.
        _ => format!("{:?}", dt).to_lowercase(),
                    Some(Self::parse_compression_type(comp, level)?)
}
    #[test]
pub const WRITER_GENERATION_KEY: &str = "opensearch.writer_generation";
        // Should NOT set a column-level encoding (that would cause the fallback error)
            FieldConfig {
        assert!(WriterPropertiesBuilder::parse_compression_type("SNPPY", 0).is_err());
            "name".to_string(),
                };
        );
        };
    }
            (name_bf.fpp - 0.01).abs() < 1e-9,
    fn test_type_level_compression_applied() {
        let schema = schema_with(vec![("row_id", ArrowDataType::Int64)]);
        assert_eq!(props.encoding(&col_path), None);
        assert!(
    }
            },
            },
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
                } else {
    fn test_field_encoding_applied() {
        let config = NativeSettings {
            ),
        };
            name_bf.fpp
///
                    Some(parsed)
            FieldConfig {
            ..Default::default()
                        | Encoding::DELTA_BYTE_ARRAY
            FieldConfig {
                        "Field '{}' in field_configs does not exist in schema",
        let schema = schema_with(vec![("age", ArrowDataType::Int32)]);
        let mut field_configs = HashMap::new();
pub fn read_writer_generation(metadata: &FileMetaData, file_index: usize) -> i64 {
            if let Some(comp) = compression {
    #[test]
            field_configs: Some(field_configs),
            let compression: Option<Compression> =
            FieldConfig {
                    if !Self::is_encoding_valid_for_type(parsed, arrow_type) {
    /// Appropriate Compression enum variant
            props.compression(&parquet::schema::types::ColumnPath::from("test")),
            .bloom_filter_properties(&parquet::schema::types::ColumnPath::from("title"))
            )),
        assert!(
            ..Default::default()
        };
            props.bloom_filter_properties(&col_path)
        assert_eq!(props.encoding(&col_path), Some(Encoding::PLAIN));
                .as_ref()
        let mut type_encoding = HashMap::new();
    fn empty_schema() -> ArrowSchema {
use parquet::file::metadata::{FileMetaData, KeyValue};
        let schema = schema_with(vec![("name", ArrowDataType::Utf8)]);
        let mut type_encoding = HashMap::new();
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        };
use crate::native_settings::NativeSettings;
        );
        builder: parquet::file::properties::WriterPropertiesBuilder,
        let schema = schema_with(vec![("test_col", ArrowDataType::Utf8)]);
    ///
        // Type-level sets fpp/ndv for utf8, field-level overrides fpp for "name"
            "LZ4_RAW" => Ok(Compression::LZ4_RAW),
        );
        assert!(has_format, "format_version stamp missing");
                    builder = builder.set_column_dictionary_enabled(column_path.clone(), true);
        };
        assert!(
            Compression::ZSTD(_)
    /// Parses encoding type string to Parquet Encoding enum.
        type_encoding.insert("int64".to_string(), "DELTA_BINARY_PACKED".to_string());
        field_configs.insert(
            ..Default::default()
    fn test_delta_length_byte_array_on_string() {
            field_configs: Some(field_configs),
            ("age", ArrowDataType::Int32),
        let props = WriterPropertiesBuilder::build(&config, &schema).unwrap();
        )
                    | Int64
            FieldConfig {
            field_configs: Some(field_configs.clone()),
                    ),
            field_configs: Some(field_configs),
 */
            Some(FORMAT_VERSION.to_string()),
        // Apply field-level configurations
        let config = NativeSettings::default();
        let schema = ArrowSchema::new(Vec::<Field>::new());
            props.encoding(&col_path),
                        element_type,
        };
///
            },
        ]);
            "title".to_string(),
        assert_eq!(props.encoding(&name_path), None);
            field_configs: Some(field_configs),
        );
            ..Default::default()
        let name_bf = props.bloom_filter_properties(&name_path);
        let schema = list_schema("tags", ArrowDataType::Utf8);
