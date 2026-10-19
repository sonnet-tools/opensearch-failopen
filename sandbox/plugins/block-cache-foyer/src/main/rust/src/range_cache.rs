        // Key format: "path\x1Fstart-end"
    0
impl CacheKey {
        assert_eq!(key_byte_size(""), 0);
                let start_str = &range_part[..dash_pos];
    /// know the requested size from the key before any remote fetch.
    #[test]
    }
/// assert_eq!(key.as_str(), "data/nodes/0/_0.parquet\x1f0-4096");
    }
///
    CacheKey(format!("{}{}{}-{}", path, SEPARATOR, start, end))
        let key = range_cache_key("/data/file.parquet", 99, 100);
        if let Some(dash_pos) = range_part.find('-') {
/// Used by [`range_cache_key`] when building keys, and by [`FoyerCache`]
    }
    }
    #[test]
        assert_eq!(key.range_len(), 0);
//!
//! [`BlockCache::get`]: crate::traits::BlockCache::get
/// (e.g. [`range_cache_key`]). This enforces the [`SEPARATOR`] convention at
//! are rejected at compile time. Callers must use the helpers in this module.
pub(crate) const SEPARATOR: char = '\x1f';
pub struct CacheKey(String);
        let key = range_cache_key("/a/b.parquet", 100, 50);
    }
// ── Future key-format helpers ─────────────────────────────────────────────────
        // saturating_sub must return 0 rather than panicking or wrapping.
/// ```
pub fn range_cache_key(path: &str, start: u64, end: u64) -> CacheKey {
            let range_part = &self.0[sep_pos + SEPARATOR.len_utf8()..];
    }
    }
        // "start" parsed from key will be 100, "end" will be 50 → saturating_sub → 0
    }
        let key = range_cache_key("/data/file.parquet", 1024, 8192);
    }
/// # Example
        assert_eq!(key.range_len(), 64_000);
        // Normally start <= end, but if someone passes inverted values,
        // Construct a CacheKey whose inner string has no SEPARATOR so
    }
        assert_eq!(data.len(), expected_size);
    fn range_len_u64_max_end() {
        assert_eq!(key.range_len(), 7168);
        // Test the fallback indirectly: end == start means len == 0 via saturating_sub.
        // put_range stores exactly (end - start) bytes.
    fn key_byte_size_returns_range_len_for_valid_key() {
        // Find the separator, then parse the "start-end" suffix.
        let key = range_cache_key("/data/file.parquet", 1_000_000_000, 1_000_064_000);
    fn range_keys_for_same_path_share_index_prefix() {
    ///
    /// For non-range keys (no [`SEPARATOR`]) the length cannot be inferred from
    fn range_len_saturating_sub_when_start_greater_than_end() {
        let k = range_cache_key("/data/other.parquet", 0, 4096);
        let key = range_cache_key("/data/file.parquet", start, end);
/// ```
        assert_eq!(key_byte_size("data/file.parquet\x1Fabc-def"), 0);
/// Key format: `"path\x1Fstart-end"`.
    fn key_byte_size_non_zero_start() {
        assert_eq!(key_byte_size(key.as_str()), 7168);
        assert_eq!(key_byte_size(key.as_str()) as usize, expected_size);
    if let Some(sep_pos) = raw_key.find(SEPARATOR) {
///
        let key = range_cache_key("/data/file.parquet", 100, 100);
// ── Range entry helpers ───────────────────────────────────────────────────────
// ── CacheKey newtype ──────────────────────────────────────────────────────────
    fn range_keys_for_different_paths_do_not_share_prefix() {
// For example, block_cache_key() for Lucene IndexInput block caching.
        let key = range_cache_key("/data/file.parquet", 0, 4096);
//! [`CacheKey`] has no public constructor and no `From<&str>` impl — raw strings
        let key = range_cache_key("/data/file.parquet", 0, 4096);
    /// For range entries (format `"path\x1Fstart-end"`) this is `end - start`,
        let key = range_cache_key("/data/file.parquet", 0, 4096);
        assert_eq!(key_byte_size("data/file.parquet\x1Fbadformat"), 0);
    fn range_len_returns_zero_for_key_without_separator() {
    #[test]
        let key = range_cache_key("/data/file.parquet", 0, u64::MAX);
/// let key = range_cache_key("data/nodes/0/_0.parquet", 0, 4096);
        assert_eq!(key.range_len(), u64::MAX);
                let end_str = &range_part[dash_pos + 1..];
    #[test]
        // Has separator but range part is not "start-end" — returns 0, no panic.
    }
/// Parse byte size from a raw Foyer key string: `"path\x1Fstart-end"` → `end - start`.
        if let Some(sep_pos) = self.0.find(SEPARATOR) {
/// path or object-store URL — S3/GCS/Azure percent-encode it as `%1F`.
        assert_eq!(key_byte_size(key.as_str()), 4096);
        let key = range_cache_key("/data/file.parquet", 1024, 8192);
//!   [`BlockCache::evict_prefix`] to evict all ranges for a file.
    pub fn as_str(&self) -> &str {
//!   when the Lucene cache consumer is integrated.
    fn range_key_contains_separator() {
        assert_eq!(key_byte_size("data/file.parquet\x1F100-"), 0);
    ///
 * this file be licensed under the Apache-2.0 license or a
            if let Some(dash_pos) = range_part.find('-') {
        assert_eq!(key.range_len(), 4096);
        assert!(k0.as_str().starts_with("/data/file.parquet"));
        assert!(!k.as_str().starts_with("/data/file.parquet"));
                return end.saturating_sub(start) as i64;
/// `\x1F` (ASCII Unit Separator, decimal 31) cannot appear in any filesystem
                if let (Ok(start), Ok(end)) = (start_str.parse::<u64>(), end_str.parse::<u64>()) {
mod key_byte_size_tests {
        // Normal range key: 0-4096 → 4096 bytes.
    use super::*;
/// Cannot be constructed from a raw string — use the helpers in this module
            let start_str = &range_part[..dash_pos];
    }
//!
    #[test]
//! Add new key-format helpers here as additional cache consumers are integrated.
    #[test]
        &self.0
        // public API: range_len on a normal key is >= 0.
        // A key built without the separator via its own format would return 0.
/// use opensearch_block_cache::range_cache::range_cache_key;
//! [`BlockCache::put`]: crate::traits::BlockCache::put
    /// [`FoyerStatsCounter`][crate::stats::FoyerStatsCounter] — even on a miss we
//! Cache key helpers for [`BlockCache`] consumers.
    #[test]
        // Verify the core invariant: for a correctly-formed put, data.len() == key_byte_size.
/// [`BlockCache::get`] or [`BlockCache::put`] will get a compile error.
    }
    ///
/// [`FoyerCache`]: crate::foyer::foyer_cache::FoyerCache
        let key = range_cache_key("/data/file.parquet", 0, 4096);
        // Use as_str() to verify separator is present for normal keys.
    /// remote store. Used to track `miss_bytes` in
        assert_eq!(key_byte_size(key.as_str()), 1);
    #[test]
/// Opaque cache key.
 * The OpenSearch Contributors require contributions made to
    /// which equals the exact number of bytes the caller requested from the
        let expected_size = (end - start) as usize;
    fn range_len_non_zero_start() {
//! [`BlockCache::evict_prefix`]: crate::traits::BlockCache::evict_prefix
    pub fn range_len(&self) -> u64 {
    #[test]
    #[test]
/*
}
//!   evict all blocks for a segment. A `block_cache_key()` helper will be added
    fn key_byte_size_matches_put_data_len() {
        assert_eq!(zero_len_key.range_len(), 0);
/// Returns `0` for non-range keys (no [`SEPARATOR`]) — safe default.
 * SPDX-License-Identifier: Apache-2.0
//!
#[cfg(test)]
        assert_eq!(key.as_str(), "/data/file.parquet\x1f0-4096");
    fn range_len_zero_length_range() {
                    return end.saturating_sub(start);
//! ## Enforced key construction
 * compatible open source license.
// ── key_byte_size unit tests ──────────────────────────────────────────────────
    }
    fn key_byte_size_malformed_range_returns_zero() {
    #[test]
        assert_eq!(key_byte_size(key.as_str()), 0);
    fn range_len_large_offsets() {
    }
            }
        let start = 1024u64;
        // We can't construct this through range_cache_key without allowing it,
//!
        // Non-range key (no \x1F) — returns 0 safely.
    fn key_byte_size_inverted_range_returns_zero() {
    #[test]
mod tests {
    }
    #[test]
        // For the inverted case we verify the saturation contract using the
///
        let range_part = &raw_key[sep_pos + SEPARATOR.len_utf8()..];
    }
}
/// Equals `data.len()` for any correctly-formed `put()` call.
}
///
}
        let zero_len_key = range_cache_key("/plain/path", 50, 50);
/// The separator between a file path and its byte-range suffix in range keys.
    }
    #[test]
        assert_eq!(key.range_len(), 0);
                }
    #[test]
}
        assert_eq!(key_byte_size(key.as_str()), 0);
        let k0 = range_cache_key("/data/file.parquet", 0, 4096);
        let data = vec![0xABu8; expected_size];
//!   Use [`range_cache_key`] to build the key; pass `path` directly to
    fn key_byte_size_zero_length_range() {
/// Build a cache key for a byte-range read.
        let k1 = range_cache_key("/data/file.parquet", 4096, 8192);
pub(crate) fn key_byte_size(raw_key: &str) -> i64 {
//! ## Key conventions
    }
        // so build the inner string directly via range_cache_key with equal values.
    // ── CacheKey::range_len ───────────────────────────────────────────────────
            if let (Ok(start), Ok(end)) = (start_str.parse::<u64>(), end_str.parse::<u64>()) {
        }
        // start > end → saturating_sub → 0 (not negative, not panic).
    fn key_byte_size_no_separator_returns_zero() {
//! [`BlockCache`]: crate::traits::BlockCache
        }
        // range_len() falls through to the 0 return.
        assert!(key.as_str().contains('\x1f'));
/// compile time: any caller that tries to pass a `&str` directly to
//!
    #[test]
//! - **Range entries** (byte-range reads): key = `"path\x1Fstart-end"`.
#[cfg(test)]
        assert_eq!(key_byte_size("data/file.parquet"), 0);
// Add new helpers here when additional cache consumers are integrated.
#[derive(Debug, Clone, PartialEq, Eq, Hash)]
    /// Return the inner string representation of this key.
/// internally when parsing keys to derive the index prefix.
        0
///
        assert_eq!(key_byte_size("data/file.parquet\x1F"), 0);
            let end_str = &range_part[dash_pos + 1..];
        let key = range_cache_key("/data/file.parquet", 200, 100);
        let key = range_cache_key("/data/file.parquet", 100, 100);
//! - **Block entries** (fixed-size block reads, e.g. Lucene): key = full block
    use super::*;
 */
    fn range_len_returns_correct_length() {
//!   `put`/`get`, and the segment base path to [`BlockCache::evict_prefix`] to
        let end = 8192u64;
//! [`BlockCache::get`] and [`BlockCache::put`] accept [`CacheKey`], not `&str`.
    fn key_byte_size_single_byte_range() {
    /// Returns the number of bytes covered by this cache key.
    }
    /// Use this in doc-tests and when passing the key to Foyer internals.
        assert_eq!(key_byte_size("data/file.parquet\x1F-200"), 0);
//!
        assert!(k1.as_str().starts_with("/data/file.parquet"));
        // start == end → 0 bytes.
    /// the key alone; returns `0` so callers can safely call this on any key.
//!
    }
    #[test]
///
//!   path (already unique, no separator needed). Pass the block path directly to
    #[test]
            }
 *
