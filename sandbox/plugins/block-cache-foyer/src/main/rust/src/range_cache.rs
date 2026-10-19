///
        // Non-range key (no \x1F) — returns 0 safely.
/// Returns `0` for non-range keys (no [`SEPARATOR`]) — safe default.
    ///
/// # Example
    fn key_byte_size_inverted_range_returns_zero() {
    fn key_byte_size_zero_length_range() {
#[cfg(test)]
/// [`FoyerCache`]: crate::foyer::foyer_cache::FoyerCache
    0
    }
 *
//! Add new key-format helpers here as additional cache consumers are integrated.
        }
    fn range_len_zero_length_range() {
//!   when the Lucene cache consumer is integrated.
        let key = range_cache_key("/data/file.parquet", 1_000_000_000, 1_000_064_000);
            let range_part = &self.0[sep_pos + SEPARATOR.len_utf8()..];
        // Use as_str() to verify separator is present for normal keys.
    pub fn as_str(&self) -> &str {
/// Key format: `"path\x1Fstart-end"`.
/// assert_eq!(key.as_str(), "data/nodes/0/_0.parquet\x1f0-4096");
/// internally when parsing keys to derive the index prefix.
        // Normally start <= end, but if someone passes inverted values,
 * this file be licensed under the Apache-2.0 license or a
    }
    fn range_len_returns_correct_length() {
        assert_eq!(key_byte_size(""), 0);
        // Normal range key: 0-4096 → 4096 bytes.
//! ## Enforced key construction
    fn key_byte_size_returns_range_len_for_valid_key() {
        assert_eq!(key.range_len(), u64::MAX);
}
        // Construct a CacheKey whose inner string has no SEPARATOR so
        // put_range stores exactly (end - start) bytes.
//! [`CacheKey`] has no public constructor and no `From<&str>` impl — raw strings
    #[test]
    }
                }
// ── key_byte_size unit tests ──────────────────────────────────────────────────
    #[test]
        let key = range_cache_key("/data/file.parquet", 1024, 8192);
    #[test]
    #[test]
        assert_eq!(key_byte_size(key.as_str()), 7168);
        // "start" parsed from key will be 100, "end" will be 50 → saturating_sub → 0
        assert_eq!(key_byte_size(key.as_str()), 4096);
        let range_part = &raw_key[sep_pos + SEPARATOR.len_utf8()..];
        assert_eq!(key_byte_size("data/file.parquet\x1F"), 0);
    use super::*;
}
        assert_eq!(key.range_len(), 0);
    fn range_len_saturating_sub_when_start_greater_than_end() {
    fn key_byte_size_no_separator_returns_zero() {
/// `\x1F` (ASCII Unit Separator, decimal 31) cannot appear in any filesystem
//! [`BlockCache::get`] and [`BlockCache::put`] accept [`CacheKey`], not `&str`.
        assert_eq!(key.as_str(), "/data/file.parquet\x1f0-4096");
/// Used by [`range_cache_key`] when building keys, and by [`FoyerCache`]
/// path or object-store URL — S3/GCS/Azure percent-encode it as `%1F`.
    fn range_len_u64_max_end() {
pub(crate) const SEPARATOR: char = '\x1f';
    /// Use this in doc-tests and when passing the key to Foyer internals.
                let end_str = &range_part[dash_pos + 1..];
        // so build the inner string directly via range_cache_key with equal values.
    fn range_key_contains_separator() {
// For example, block_cache_key() for Lucene IndexInput block caching.
                    return end.saturating_sub(start);
    }
        // Test the fallback indirectly: end == start means len == 0 via saturating_sub.
        // For the inverted case we verify the saturation contract using the
 */
        assert_eq!(key_byte_size("data/file.parquet\x1Fabc-def"), 0);
    #[test]
    pub fn range_len(&self) -> u64 {
/// [`BlockCache::get`] or [`BlockCache::put`] will get a compile error.
        assert_eq!(key.range_len(), 64_000);
            }
        let k = range_cache_key("/data/other.parquet", 0, 4096);
    fn key_byte_size_non_zero_start() {
impl CacheKey {
        // We can't construct this through range_cache_key without allowing it,
//!   Use [`range_cache_key`] to build the key; pass `path` directly to
        let key = range_cache_key("/data/file.parquet", 0, 4096);
    #[test]
    /// remote store. Used to track `miss_bytes` in
    ///
    }
//!
// ── Future key-format helpers ─────────────────────────────────────────────────
pub(crate) fn key_byte_size(raw_key: &str) -> i64 {
                if let (Ok(start), Ok(end)) = (start_str.parse::<u64>(), end_str.parse::<u64>()) {
 * compatible open source license.
    #[test]
        assert_eq!(zero_len_key.range_len(), 0);
/// compile time: any caller that tries to pass a `&str` directly to
        // range_len() falls through to the 0 return.
        assert_eq!(key_byte_size(key.as_str()), 0);
//!
        // Verify the core invariant: for a correctly-formed put, data.len() == key_byte_size.
    fn key_byte_size_malformed_range_returns_zero() {
    }
//!
pub struct CacheKey(String);
        let key = range_cache_key("/data/file.parquet", 99, 100);
    }
/// let key = range_cache_key("data/nodes/0/_0.parquet", 0, 4096);
        let start = 1024u64;
}
    fn key_byte_size_single_byte_range() {
        // start == end → 0 bytes.
///
                return end.saturating_sub(start) as i64;
 * SPDX-License-Identifier: Apache-2.0
    // ── CacheKey::range_len ───────────────────────────────────────────────────
pub fn range_cache_key(path: &str, start: u64, end: u64) -> CacheKey {
        // saturating_sub must return 0 rather than panicking or wrapping.
    if let Some(sep_pos) = raw_key.find(SEPARATOR) {
    }
    }
        let key = range_cache_key("/data/file.parquet", 100, 100);
        let key = range_cache_key("/data/file.parquet", 200, 100);
        let key = range_cache_key("/data/file.parquet", 0, 4096);
        let k0 = range_cache_key("/data/file.parquet", 0, 4096);
//! [`BlockCache::evict_prefix`]: crate::traits::BlockCache::evict_prefix
// ── CacheKey newtype ──────────────────────────────────────────────────────────
/// Equals `data.len()` for any correctly-formed `put()` call.
    }
    }
            }
        // Has separator but range part is not "start-end" — returns 0, no panic.
//!
        &self.0
            if let Some(dash_pos) = range_part.find('-') {
    #[test]
        assert!(!k.as_str().starts_with("/data/file.parquet"));
        let key = range_cache_key("/data/file.parquet", 0, u64::MAX);
            let start_str = &range_part[..dash_pos];
    }
    }
}
        let key = range_cache_key("/data/file.parquet", start, end);
///
    CacheKey(format!("{}{}{}-{}", path, SEPARATOR, start, end))
        if let Some(sep_pos) = self.0.find(SEPARATOR) {
        assert_eq!(key.range_len(), 7168);
        assert_eq!(key_byte_size("data/file.parquet"), 0);
        // Key format: "path\x1Fstart-end"
/// The separator between a file path and its byte-range suffix in range keys.
#[cfg(test)]
 * The OpenSearch Contributors require contributions made to
//! [`BlockCache`]: crate::traits::BlockCache
        let expected_size = (end - start) as usize;
    fn key_byte_size_matches_put_data_len() {
    use super::*;
/// ```
        0
//! - **Block entries** (fixed-size block reads, e.g. Lucene): key = full block
        let zero_len_key = range_cache_key("/plain/path", 50, 50);
                let start_str = &range_part[..dash_pos];
            let end_str = &range_part[dash_pos + 1..];
        assert_eq!(key_byte_size(key.as_str()), 0);
    #[test]
///
//!
        let key = range_cache_key("/data/file.parquet", 1024, 8192);
        assert_eq!(key_byte_size("data/file.parquet\x1F-200"), 0);
    }
///
    /// the key alone; returns `0` so callers can safely call this on any key.
//! Cache key helpers for [`BlockCache`] consumers.
    #[test]
mod key_byte_size_tests {
    ///
    }
        let key = range_cache_key("/data/file.parquet", 0, 4096);
//! [`BlockCache::get`]: crate::traits::BlockCache::get
    }
    #[test]
    /// which equals the exact number of bytes the caller requested from the
    fn range_len_returns_zero_for_key_without_separator() {
//! are rejected at compile time. Callers must use the helpers in this module.
        assert!(k1.as_str().starts_with("/data/file.parquet"));
}
    #[test]
/// Build a cache key for a byte-range read.
        assert_eq!(key.range_len(), 4096);
        // A key built without the separator via its own format would return 0.
//!   `put`/`get`, and the segment base path to [`BlockCache::evict_prefix`] to
        // public API: range_len on a normal key is >= 0.
    #[test]
    /// Returns the number of bytes covered by this cache key.
    }
//!
/// Parse byte size from a raw Foyer key string: `"path\x1Fstart-end"` → `end - start`.
// ── Range entry helpers ───────────────────────────────────────────────────────
    #[test]
        assert_eq!(key_byte_size(key.as_str()) as usize, expected_size);
        let end = 8192u64;
#[derive(Debug, Clone, PartialEq, Eq, Hash)]
    fn range_keys_for_different_paths_do_not_share_prefix() {
//! - **Range entries** (byte-range reads): key = `"path\x1Fstart-end"`.
//!   [`BlockCache::evict_prefix`] to evict all ranges for a file.
    }
/// Opaque cache key.
    fn range_keys_for_same_path_share_index_prefix() {
/// ```
/// (e.g. [`range_cache_key`]). This enforces the [`SEPARATOR`] convention at
        assert!(key.as_str().contains('\x1f'));
//!   evict all blocks for a segment. A `block_cache_key()` helper will be added
    #[test]
/// Cannot be constructed from a raw string — use the helpers in this module
    }
        let key = range_cache_key("/data/file.parquet", 100, 100);
    /// For non-range keys (no [`SEPARATOR`]) the length cannot be inferred from
        assert_eq!(key.range_len(), 0);
/// use opensearch_block_cache::range_cache::range_cache_key;
///
    /// Return the inner string representation of this key.
    #[test]
    /// [`FoyerStatsCounter`][crate::stats::FoyerStatsCounter] — even on a miss we
        // Find the separator, then parse the "start-end" suffix.
        let key = range_cache_key("/a/b.parquet", 100, 50);
        if let Some(dash_pos) = range_part.find('-') {
//! [`BlockCache::put`]: crate::traits::BlockCache::put
    #[test]
        assert_eq!(key_byte_size(key.as_str()), 1);
        }
    }
        assert_eq!(key_byte_size("data/file.parquet\x1F100-"), 0);
// Add new helpers here when additional cache consumers are integrated.
    #[test]
//!   path (already unique, no separator needed). Pass the block path directly to
    fn range_len_large_offsets() {
            if let (Ok(start), Ok(end)) = (start_str.parse::<u64>(), end_str.parse::<u64>()) {
//!
mod tests {
        let data = vec![0xABu8; expected_size];
    /// know the requested size from the key before any remote fetch.
        assert_eq!(data.len(), expected_size);
        assert!(k0.as_str().starts_with("/data/file.parquet"));
        let k1 = range_cache_key("/data/file.parquet", 4096, 8192);
    }
//! ## Key conventions
        // start > end → saturating_sub → 0 (not negative, not panic).
/*
    /// For range entries (format `"path\x1Fstart-end"`) this is `end - start`,
        let key = range_cache_key("/data/file.parquet", 0, 4096);
        assert_eq!(key_byte_size("data/file.parquet\x1Fbadformat"), 0);
    fn range_len_non_zero_start() {
