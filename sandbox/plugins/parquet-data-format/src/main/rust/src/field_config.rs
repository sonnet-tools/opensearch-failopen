}
    pub bloom_filter_enabled: Option<bool>,
            config.encoding_type,
            encoding_type: None,
    }
    pub bloom_filter_fpp: Option<f64>,
            compression_type: Some("SNAPPY".to_string()),
        assert!(!config.is_empty());
pub struct FieldConfig {
    #[test]
    fn test_field_config_construction() {
        let config = FieldConfig::default();
            ..Default::default()
            && self.compression_level.is_none()
    pub fn is_empty(&self) -> bool {
 * The OpenSearch Contributors require contributions made to
            ..Default::default()
/*
    fn test_field_config_default() {
 * this file be licensed under the Apache-2.0 license or a
}
            && self.bloom_filter_ndv.is_none()
    }
}
            encoding_type: Some("DELTA_BINARY_PACKED".to_string()),
        );
#[cfg(test)]
    use super::*;
            compression_level: Some(1),
            && self.bloom_filter_enabled.is_none()
    }
    #[test]
    pub fn new() -> Self {
        assert_eq!(config.compression_type, Some("SNAPPY".to_string()));
    pub encoding_type: Option<String>,
    #[test]
        let config = FieldConfig {
    pub compression_level: Option<i32>,
 * SPDX-License-Identifier: Apache-2.0
        let config = FieldConfig {
        assert_eq!(
    pub compression_type: Option<String>,
 */
            && self.encoding_type.is_none()
        assert_eq!(config.compression_level, Some(1));
        assert!(config.is_empty());
 * compatible open source license.
        };
            Some("DELTA_BINARY_PACKED".to_string())
impl FieldConfig {
    }
            && self.bloom_filter_fpp.is_none()
    }
mod tests {
        assert!(!config.is_empty());
#[derive(Debug, Clone, Default)]
 *
    fn test_field_config_encoding() {
        };
        Self::default()
        self.compression_type.is_none()
    pub bloom_filter_ndv: Option<u64>,
