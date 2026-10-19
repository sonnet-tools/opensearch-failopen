    }
    pub fn get_merge_rayon_threads(&self) -> Option<usize> {
    }
    pub merge_deferred_column_threshold: Option<usize>,
    pub fn new() -> Self {
        self.merge_deferred_column_threshold.unwrap_or(0)
    }
    pub merge_io_threads: Option<usize>,
        let config = NativeSettings {
    pub type_encoding_configs: Option<HashMap<String, String>>,
    }
    pub index_name: Option<String>,
    pub fn get_compression_level(&self) -> i32 {
            },
    }
 * this file be licensed under the Apache-2.0 license or a
            compression_level: Some(1),
    }
 * The OpenSearch Contributors require contributions made to
        self.sort_in_memory_threshold_bytes
    pub fn has_field_configs(&self) -> bool {
    }
        self.merge_io_threads
    }
    pub fn get_dict_size_bytes(&self) -> usize {
        };
    pub type_bloom_filter_ndv: Option<HashMap<String, u64>>,
    pub fn get_sort_in_memory_threshold_bytes(&self) -> u64 {
    pub nulls_first: Vec<bool>,
    pub fn get_bloom_filter_fpp(&self) -> f64 {
                ..Default::default()
        let config = NativeSettings {
    pub sort_columns: Vec<String>,
    }
        self.bloom_filter_enabled.unwrap_or(false)
        self.row_group_max_bytes.unwrap_or(128 * 1024 * 1024)
    }
        };
    }
    }
    fn test_struct_construction() {
    pub dict_size_bytes: Option<usize>,
        field_configs.insert(
    pub type_bloom_filter_enabled: Option<HashMap<String, bool>>,
            .as_ref()
    /// Parallel with `sort_columns`: `true` selects the MAX element of a
        assert_eq!(config.get_compression_type(), "LZ4_RAW");
 *
        self.field_configs
    fn test_defaults() {
        let config = NativeSettings::default();
    pub type_bloom_filter_fpp: Option<HashMap<String, f64>>,
        self.compression_type.as_deref().unwrap_or("LZ4_RAW")
        let mut field_configs = HashMap::new();
    pub fn get_page_size_bytes(&self) -> usize {
    pub reverse_sorts: Vec<bool>,
}
    }
    pub page_size_bytes: Option<usize>,
        use crate::field_config::FieldConfig;
    }
                compression_level: None,
use crate::field_config::FieldConfig;
use std::collections::HashMap;
impl NativeSettings {
    pub fn get_bloom_filter_ndv(&self) -> u64 {
    }
    pub fn get_row_group_max_rows(&self) -> usize {
        self.dict_size_bytes.unwrap_or(2 * 1024 * 1024)
        self.field_configs.as_ref()?.get(field_name)
        assert!(config.has_field_configs());
            compression_type: Some("ZSTD".to_string()),
                encoding_type: None,
        let fc = config.get_field_config("timestamp").unwrap();
        assert_eq!(fc.compression_type, Some("SNAPPY".to_string()));
        self.page_size_bytes.unwrap_or(1024 * 1024)
pub struct NativeSettings {
        self.row_group_max_rows.unwrap_or(1_000_000)
    pub compression_level: Option<i32>,
            field_configs: Some(field_configs),
        self.merge_rayon_threads
/*
#[derive(Debug, Clone, Default)]
    pub row_group_max_rows: Option<usize>,
    fn test_field_configs() {
            .map_or(false, |configs| !configs.is_empty())
            "timestamp".to_string(),
    pub bloom_filter_enabled: Option<bool>,
    pub bloom_filter_ndv: Option<u64>,
    pub fn get_compression_type(&self) -> &str {
    pub fn get_row_group_max_bytes(&self) -> usize {
            ..Default::default()
    pub fn get_merge_io_threads(&self) -> Option<usize> {
    /// `index.sort.mode` (defaulting to MIN for ASC and MAX for DESC) on the
    pub row_group_max_bytes: Option<usize>,
    use super::*;
        self.merge_batch_size.unwrap_or(100_000)
    }
        self.compression_level.unwrap_or(2)
            compression_type: Some("SNAPPY".to_string()),
        assert_eq!(config.get_compression_level(), 1);
        assert_eq!(config.get_compression_level(), 2);
 * compatible open source license.
    }
    #[test]
    pub sort_in_memory_threshold_bytes: Option<u64>,
    pub fn get_page_row_limit(&self) -> usize {
            .unwrap_or(32 * 1024 * 1024)
    }
    /// multi-value (LIST) field, `false` selects MIN. Derived from
    /// Java side. Scalar fields ignore this.
                compression_type: Some("SNAPPY".to_string()),
    #[test]
    pub compression_type: Option<String>,
        assert_eq!(config.get_page_row_limit(), 20000);
#[cfg(test)]
    pub merge_batch_size: Option<usize>,
    pub bloom_filter_fpp: Option<f64>,
 */
    pub max_sort_modes: Vec<bool>,
    pub merge_rayon_threads: Option<usize>,
        self.page_row_limit.unwrap_or(20000)
        Self::default()
    pub type_compression_configs: Option<HashMap<String, String>>,
 * SPDX-License-Identifier: Apache-2.0
    pub fn get_merge_batch_size(&self) -> usize {
            ..Default::default()
    pub fn get_merge_deferred_column_threshold(&self) -> usize {
        self.bloom_filter_ndv.unwrap_or(100_000)
        assert_eq!(config.get_compression_type(), "SNAPPY");
}
    pub fn get_field_config(&self, field_name: &str) -> Option<&FieldConfig> {
    }
mod tests {
        use std::collections::HashMap;
        );
    }
    }
    pub fn get_bloom_filter_enabled(&self) -> bool {
}
    #[test]
    pub custom_settings: Option<HashMap<String, String>>,
        self.bloom_filter_fpp.unwrap_or(0.1)
    pub field_configs: Option<HashMap<String, FieldConfig>>,
        assert_eq!(config.get_dict_size_bytes(), 2 * 1024 * 1024);
    pub page_row_limit: Option<usize>,
            FieldConfig {
