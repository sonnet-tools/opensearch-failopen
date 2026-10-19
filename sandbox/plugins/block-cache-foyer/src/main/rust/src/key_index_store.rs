    /// Used as a fallback when the snapshot file is missing or unparseable.
 * SPDX-License-Identifier: Apache-2.0
pub const KEY_INDEX_TMP_FILENAME: &str = ".key_index.json.tmp";
/// Serializes the DashMap directly (no intermediate HashMap copy) using
            index: {
                m.insert("tmp".to_string(), HashSet::new());
}
//! Provides atomic save/load/delete for a JSON snapshot of the
        Err(e) if e.kind() == ErrorKind::NotFound => KeyIndexSnapshot::empty(),
    /// Deserialized key_index: prefix → set of Foyer keys.
        )
        let dir = TempDir::new().unwrap();
        let main_snap = KeyIndexSnapshot {
///
pub struct KeyIndexSnapshot {
    #[test]
        let dir = TempDir::new().unwrap();
//! Persistence helpers for the [`FoyerCache`] key_index.
        assert!(!dir.path().join(KEY_INDEX_FILENAME).exists());
    pub index: HashMap<String, HashSet<String>>,
/// the error but do not propagate it — a failed persist is not fatal.
            ),
        self.index.is_empty()
}
        .unwrap();
        let key = "data/nodes/0/file.parquet\x1F99999-200000";
        assert_eq!(snapshot.version, SNAPSHOT_VERSION);
pub fn load(dir: &Path) -> io::Result<KeyIndexSnapshot> {
//!
    Ok(())
 * this file be licensed under the Apache-2.0 license or a
                "data/b.parquet",
                m.insert(
pub const KEY_INDEX_FILENAME: &str = "key_index.json";
// ── Unit tests ────────────────────────────────────────────────────────────────
    fn test_delete_removes_both_files() {
#[cfg(test)]
    fn test_load_rejects_wrong_version() {
fn load_inner(dir: &Path) -> io::Result<KeyIndexSnapshot> {
    // Atomic write: write to .tmp then rename.
        assert_eq!(total_keys, 6);
//! ## Crash safety
    #[test]
    #[test]
        };
}
//! `save()` writes to `.key_index.json.tmp` then renames to `key_index.json`.
/// Delete both `key_index.json` and `.key_index.json.tmp` from `dir`.
/// stale keys into a freshly-cleared cache.
        assert!(loaded.index.contains_key("main"));
            dir.path().join(KEY_INDEX_FILENAME),
    fn make_map(entries: Vec<(&str, Vec<&str>)>) -> DashMap<String, HashSet<String>> {
        .unwrap();
    let json = serde_json::to_string(&serde_json::json!({
        match std::fs::remove_file(dir.join(name)) {
    #[test]
    }
                let mut m = HashMap::new();
        )
    pub version: u32,
    // If the process crashes between write and rename, .tmp is left behind;
    let tmp_path = dir.join(KEY_INDEX_TMP_FILENAME);
                m
    fn test_load_cleans_up_tmp_even_when_main_succeeds() {
    #[test]
/// Returns `Err` on I/O failure. Callers (the persist task and `Drop`) log
        ));
        std::fs::write(dir.path().join(KEY_INDEX_FILENAME), b"x").unwrap();
    fn test_save_is_atomic_no_tmp_file_on_success() {
        assert!(
    }
    Ok(snapshot)
//! deletes it.
                vec!["data/b.parquet\x1F0-512", "data/b.parquet\x1F512-1024"],
    #[test]
        let snap = KeyIndexSnapshot {
    #[test]
    if snapshot.version != SNAPSHOT_VERSION {
/// Name of the committed snapshot file inside the cache directory.
    }
        assert_eq!(load(dir.path()).unwrap_err().kind(), ErrorKind::NotFound);
        std::fs::write(
        Self {
///
    match load(dir) {
                    "data/x.parquet".to_string(),
/// the live `DashMap` directly via `serde_json::json!` — no conversion to this
    }
            version: SNAPSHOT_VERSION,
        assert!(!dir.path().join(KEY_INDEX_TMP_FILENAME).exists());
///    the crash-during-rename edge case). Success → log WARN, return snapshot.
///
///
        assert!(loaded.index.contains_key("data/x.parquet"));
            br#"{"version":999,"index":{}}"#,
/// Used exclusively by `load()` / `parse_and_validate()`. `save()` serializes
 * The OpenSearch Contributors require contributions made to
        save(dir.path(), &map).unwrap();
            ".tmp must be deleted"
    }
        let dir = TempDir::new().unwrap();
    }
        let map = DashMap::new();
            !dir.path().join(KEY_INDEX_TMP_FILENAME).exists(),
    let final_path = dir.join(KEY_INDEX_FILENAME);
        assert!(dir.path().join(KEY_INDEX_FILENAME).exists());
            },
        Err(e) => Err(e),
    // ── delete ────────────────────────────────────────────────────────────────
    // load() will fall back to it on the next startup.
            parse_and_validate(&contents)
        let dir = TempDir::new().unwrap();
        )),
        }
    pub fn empty() -> Self {
    }
        let dir = TempDir::new().unwrap();
        map
    /// Return an empty snapshot with the current version.
        let snapshot = load(dir.path()).unwrap();
///   crash where graceful shutdown (`Drop`) was not called.
        .unwrap();
pub fn delete(dir: &Path) -> io::Result<()> {
        let map = make_map(vec![("data/nodes/0/file.parquet", vec![key])]);
        assert!(load_or_empty(dir.path()).is_empty());
            (
    pub fn is_empty(&self) -> bool {
    use tempfile::TempDir;
    Ok(())
    let final_path = dir.join(KEY_INDEX_FILENAME);
        save(dir.path(), &map).unwrap();
use std::path::Path;
/*
        assert_eq!(snapshot.index.len(), 3);
        let dir = TempDir::new().unwrap();
    }
//! [`FoyerCache`]: crate::foyer::foyer_cache::FoyerCache
        )
    #[test]
        assert!(snapshot.index.is_empty());
use dashmap::DashMap;
                let mut m = HashMap::new();
            native_bridge_common::log_info!(
            Ok(()) => {}
    let tmp_path = dir.join(KEY_INDEX_TMP_FILENAME);
    }
/// 1. Try `key_index.json` (primary). Success → return snapshot.
        let dir = TempDir::new().unwrap();
/// Format version embedded in every snapshot. Bump when the schema changes
            "key_index.json not found",
            serde_json::to_string(&snap).unwrap().as_bytes(),
/// graceful-shutdown `Drop` will capture any missed keys.
    fn test_load_prefers_main_file_over_tmp() {
        let json = serde_json::to_string(&snap).unwrap();
/// 3. Both absent → return `Err(NotFound)`.
        let dir = TempDir::new().unwrap();
    let tmp_path = dir.join(KEY_INDEX_TMP_FILENAME);
    std::fs::rename(&tmp_path, &final_path)?;
            index: HashMap::new(),
        Err(e) if e.kind() == ErrorKind::NotFound => {}
    // 1. Try the committed file.
        };
        delete(dir.path()).unwrap();
        for (prefix, keys) in entries {
    }
//!
                vec!["data/a.parquet\x1F0-100", "data/a.parquet\x1F100-200"],
    }
        std::fs::write(dir.path().join(KEY_INDEX_TMP_FILENAME), b"y").unwrap();
    }
            KeyIndexSnapshot::empty()
        let tmp_snap = KeyIndexSnapshot {
/// snapshot. If both files exist, the rename completed and `.tmp` is stale.
            keys.contains(key),
        assert_eq!(loaded.index.len(), 1);
    if tmp_path.exists() {
use std::collections::{HashMap, HashSet};
/// snapshot — both outcomes are acceptable; the next periodic persist or
    // ── save + load roundtrip ─────────────────────────────────────────────────
    .map_err(|e| io::Error::new(ErrorKind::InvalidData, e))?;
        Err(e) => {
    fn test_load_uses_tmp_fallback_when_main_file_absent() {
pub const SNAPSHOT_VERSION: u32 = 1;
    use std::collections::HashSet;
        std::fs::write(
        }
        let dir = TempDir::new().unwrap();
        )
            ErrorKind::NotFound,
        assert!(!dir.path().join(KEY_INDEX_TMP_FILENAME).exists());
            ),
    // ── atomic write ──────────────────────────────────────────────────────────
        std::fs::write(
                e
        let keys = snapshot.index.get("data/nodes/0/file.parquet").unwrap();
mod tests {
    #[test]
                SNAPSHOT_VERSION, snapshot.version
//! Foyer cache directory alongside the Foyer segment files.
impl KeyIndexSnapshot {
/// Atomically write the key_index snapshot to `<dir>/key_index.json`.
            index: {
            ),
    }
    }
        std::fs::write(dir.path().join(KEY_INDEX_TMP_FILENAME), b"stale").unwrap();
    }
    // ── load error cases ──────────────────────────────────────────────────────
        Ok(contents) => {
            );
/// `key_index.json` is always preferred: it is the last *successfully committed*
            ),
        let dir = TempDir::new().unwrap();
        let snap = KeyIndexSnapshot {
        }
        };
    }
        serde_json::from_str(contents).map_err(|e| io::Error::new(ErrorKind::InvalidData, e))?;
        let total_keys: usize = snapshot.index.values().map(|s| s.len()).sum();
    }
    fn test_delete_is_noop_for_missing_files() {
    }
        assert!(!loaded.index.contains_key("tmp"));
            },
            index: {
            version: SNAPSHOT_VERSION,
        .unwrap();
/// incompatibly; old files with a different version are rejected on load.
    #[test]
        let loaded = load(dir.path()).unwrap();
    #[test]
 *
                m
                "data/a.parquet",
 */
/// - Any other error → logs WARN, returns empty. Never fails startup.
        );
/// DashMap's own `Serialize` impl (enabled via the `serde` workspace feature).
            map.insert(prefix.to_string(), set);
        let dir = TempDir::new().unwrap();
/// # Cleanup
/// temp files from accumulating across restarts.
            (
/// struct on the write path.
        let map: DashMap<String, HashSet<String>> = DashMap::new();
        save(dir.path(), &map).expect("save must succeed");
/// The `index` field deserializes from the JSON object produced by DashMap's
//! ## File format
pub fn save(dir: &Path, key_index: &DashMap<String, HashSet<String>>) -> io::Result<()> {
// ── Public API ────────────────────────────────────────────────────────────────
    fn test_load_or_empty_returns_empty_for_corrupt_json() {
    }
        );
            version: SNAPSHOT_VERSION,
                m.insert("main".to_string(), HashSet::new());
/// A concurrent `put()` racing with this call may or may not appear in the
}
    }
        assert!(dir.path().join(KEY_INDEX_FILENAME).exists());
                "key_index version mismatch: expected {}, got {}",
        let dir = TempDir::new().unwrap();
                vec!["data/c.parquet\x1F0-4096", "data/c.parquet\x1F4096-8192"],
///
//! ```json
            "\\x1F separator must survive serde roundtrip"
/// `NotFound` is treated as success for both files.
 * compatible open source license.
            serde_json::to_string(&tmp_snap).unwrap().as_bytes(),
            ErrorKind::InvalidData,
        load(dir.path()).unwrap();
        };
        assert!(!dir.path().join(KEY_INDEX_TMP_FILENAME).exists());
/// 2. If `key_index.json` is absent, try `.key_index.json.tmp` (fallback for
                m
use std::io::{self, ErrorKind};
            serde_json::to_string(&main_snap).unwrap().as_bytes(),
//! {"version":1,"index":{"data/shard/_0.parquet":["data/shard/_0.parquet\u001f0-4096"]}}
        }
//!
    fn test_load_or_empty_returns_empty_for_missing_file() {
/// # Error handling
}
            dir.path().join(KEY_INDEX_TMP_FILENAME),
//! The rename is atomic on POSIX filesystems. A crash between the two steps
        }
        Ok(contents) => return parse_and_validate(&contents),
    // 2. Fallback: .tmp (crash-during-rename recovery).
        std::fs::write(dir.path().join(KEY_INDEX_FILENAME), b"{{not valid json}}").unwrap();
    }))
fn parse_and_validate(contents: &str) -> io::Result<KeyIndexSnapshot> {
    match std::fs::read_to_string(&final_path) {
        let snapshot = load(dir.path()).unwrap();
                );
/// Called by `FoyerCache::clear()` so the next startup does not bulk-load
            Err(e) if e.kind() == ErrorKind::NotFound => {}
///
        Err(e) if e.kind() == ErrorKind::NotFound => Err(io::Error::new(
                let mut m = HashMap::new();
    fn test_load_returns_not_found_for_missing_file() {
    fn test_save_empty_map_produces_valid_file() {
        std::fs::write(dir.path().join(KEY_INDEX_TMP_FILENAME), json.as_bytes()).unwrap();
        Err(e) => return Err(e),
        assert_eq!(load(dir.path()).unwrap_err().kind(), ErrorKind::InvalidData);
            Err(e) => return Err(e),
        let _ = std::fs::remove_file(&tmp_path);
            version: SNAPSHOT_VERSION,
/// `Serialize` impl: both produce `{"prefix": ["key1", "key2", ...], ...}`.
        assert!(!dir.path().join(KEY_INDEX_TMP_FILENAME).exists());
            let set: HashSet<String> = keys.into_iter().map(String::from).collect();
    #[test]
                dir.display()
    fn test_load_tmp_fallback_also_fails_returns_not_found() {
    }
                    ["data/x.parquet\x1F0-100".to_string()].into(),
        ]);
    for name in [KEY_INDEX_FILENAME, KEY_INDEX_TMP_FILENAME] {
    #[test]
    fn test_save_and_load_roundtrip() {
//!
        let loaded = load(dir.path()).expect(".tmp fallback must succeed");
    // ── .tmp fallback ─────────────────────────────────────────────────────────
/// Load the snapshot, returning an empty snapshot on any error.
/// Name of the in-progress temp file used during an atomic write.
            format!(
    let snapshot: KeyIndexSnapshot =
    match std::fs::read_to_string(&tmp_path) {
        assert!(load_or_empty(dir.path()).is_empty());
    // Serialize directly — no intermediate HashMap copy needed.
        "version": SNAPSHOT_VERSION,
/// Load the key_index snapshot from `<dir>/key_index.json`.
            dir.path().join(KEY_INDEX_FILENAME),
        return Err(io::Error::new(
        let map = make_map(vec![
pub fn load_or_empty(dir: &Path) -> KeyIndexSnapshot {
    result
            );
            (
    #[test]
            version: SNAPSHOT_VERSION,
/// Deletes `.key_index.json.tmp` after every load attempt to prevent stale
    fn test_separator_in_keys_roundtrip() {
//! leaves the `.tmp` file behind; `load()` uses it as a fallback and then
///
                "[block-cache] WARNING: key_index load failed, starting empty: {} — {}",
        let snapshot = load(dir.path()).expect("load must succeed");
            index: HashMap::new(),
                "data/c.parquet",
///
                "[block-cache] key_index: using .tmp fallback (crash during rename?), dir={}",
            dir.path().join(KEY_INDEX_FILENAME),
        assert!(!dir.path().join(KEY_INDEX_FILENAME).exists());
                dir.display(),
///
    /// Format version. Must equal [`SNAPSHOT_VERSION`] to be accepted.
/// - `NotFound` → empty, silently. Normal for first-ever startup or after a
        assert!(
        std::fs::write(
        Ok(snapshot) => snapshot,
// ── Constants ─────────────────────────────────────────────────────────────────
use serde::{Deserialize, Serialize};
        "index": key_index
        let dir = TempDir::new().unwrap();
    let result = load_inner(dir);
        assert_eq!(load(dir.path()).unwrap_err().kind(), ErrorKind::NotFound);
    std::fs::write(&tmp_path, json.as_bytes())?;
            native_bridge_common::log_info!(
            },
}
}
//! ```
/// Deserialized representation of the key_index snapshot.
}
    /// Return `true` when there are no prefix buckets in this snapshot.
    use super::*;
//! `DashMap<String, HashSet<String>>` key_index. The file lives inside the
        delete(dir.path()).unwrap();
        save(dir.path(), &make_map(vec![("p", vec!["p\x1F0-1"])])).unwrap();
    // DashMap implements Serialize (workspace feature "serde" enabled for dashmap).
}
/// # Load strategy
#[derive(Debug, Serialize, Deserialize)]
    }
        let dir = TempDir::new().unwrap();
    }
// ── Types ─────────────────────────────────────────────────────────────────────
