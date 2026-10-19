fn load_inner(dir: &Path) -> io::Result<KeyIndexSnapshot> {
                let mut m = HashMap::new();
// ── Constants ─────────────────────────────────────────────────────────────────
    match load(dir) {
    fn test_delete_removes_both_files() {
            native_bridge_common::log_info!(
    }
    fn test_load_or_empty_returns_empty_for_missing_file() {
    pub fn empty() -> Self {
        )
//! Foyer cache directory alongside the Foyer segment files.
        assert!(snapshot.index.is_empty());
    #[test]
    pub index: HashMap<String, HashSet<String>>,
///
    // If the process crashes between write and rename, .tmp is left behind;
    use tempfile::TempDir;
 * compatible open source license.
pub const KEY_INDEX_FILENAME: &str = "key_index.json";
        let dir = TempDir::new().unwrap();
        save(dir.path(), &map).unwrap();
}
                m.insert("main".to_string(), HashSet::new());
        let map: DashMap<String, HashSet<String>> = DashMap::new();
}
            index: {
    }
            "\\x1F separator must survive serde roundtrip"
        );
    }
//! ## Crash safety
    #[test]
        let dir = TempDir::new().unwrap();
        assert_eq!(load(dir.path()).unwrap_err().kind(), ErrorKind::NotFound);
/// Serializes the DashMap directly (no intermediate HashMap copy) using
            "key_index.json not found",
/// DashMap's own `Serialize` impl (enabled via the `serde` workspace feature).
        let dir = TempDir::new().unwrap();
/// Name of the committed snapshot file inside the cache directory.
        let dir = TempDir::new().unwrap();
            Err(e) => return Err(e),
        self.index.is_empty()
    let json = serde_json::to_string(&serde_json::json!({
    match std::fs::read_to_string(&final_path) {
    }
 */
    }
        assert!(load_or_empty(dir.path()).is_empty());
    }
    }
    fn make_map(entries: Vec<(&str, Vec<&str>)>) -> DashMap<String, HashSet<String>> {
                vec!["data/b.parquet\x1F0-512", "data/b.parquet\x1F512-1024"],
        assert!(!loaded.index.contains_key("tmp"));
            ".tmp must be deleted"
        Ok(snapshot) => snapshot,
/// snapshot — both outcomes are acceptable; the next periodic persist or
    #[test]
}
    fn test_save_and_load_roundtrip() {
// ── Unit tests ────────────────────────────────────────────────────────────────
/// Returns `Err` on I/O failure. Callers (the persist task and `Drop`) log
        Err(e) => Err(e),
        }
        let snapshot = load(dir.path()).unwrap();
        let snapshot = load(dir.path()).expect("load must succeed");
    }
        .unwrap();
    #[test]
    fn test_save_empty_map_produces_valid_file() {
    let tmp_path = dir.join(KEY_INDEX_TMP_FILENAME);
    for name in [KEY_INDEX_FILENAME, KEY_INDEX_TMP_FILENAME] {
//! leaves the `.tmp` file behind; `load()` uses it as a fallback and then
#[derive(Debug, Serialize, Deserialize)]
/// `Serialize` impl: both produce `{"prefix": ["key1", "key2", ...], ...}`.
        delete(dir.path()).unwrap();
use serde::{Deserialize, Serialize};
    }
            },
    fn test_load_tmp_fallback_also_fails_returns_not_found() {
    pub version: u32,
    std::fs::write(&tmp_path, json.as_bytes())?;
/// the error but do not propagate it — a failed persist is not fatal.
    }
        }
                m
            version: SNAPSHOT_VERSION,
    /// Deserialized key_index: prefix → set of Foyer keys.
        save(dir.path(), &map).unwrap();
        std::fs::write(dir.path().join(KEY_INDEX_TMP_FILENAME), b"stale").unwrap();
    Ok(())
        std::fs::write(
}
        assert!(dir.path().join(KEY_INDEX_FILENAME).exists());
                m.insert("tmp".to_string(), HashSet::new());
        let main_snap = KeyIndexSnapshot {
    use std::collections::HashSet;
///
        let loaded = load(dir.path()).unwrap();
        let key = "data/nodes/0/file.parquet\x1F99999-200000";
            dir.path().join(KEY_INDEX_FILENAME),
    #[test]
        std::fs::write(dir.path().join(KEY_INDEX_FILENAME), b"x").unwrap();
            version: SNAPSHOT_VERSION,
mod tests {
/// stale keys into a freshly-cleared cache.
        Ok(contents) => {
                "[block-cache] key_index: using .tmp fallback (crash during rename?), dir={}",
        assert!(!dir.path().join(KEY_INDEX_TMP_FILENAME).exists());
/// `NotFound` is treated as success for both files.
        let map = make_map(vec![
    }))
/// 1. Try `key_index.json` (primary). Success → return snapshot.
    // ── atomic write ──────────────────────────────────────────────────────────
            (
    /// Used as a fallback when the snapshot file is missing or unparseable.
                );
        );
        Err(e) => {
///
            version: SNAPSHOT_VERSION,
 * SPDX-License-Identifier: Apache-2.0
        .unwrap();
        let total_keys: usize = snapshot.index.values().map(|s| s.len()).sum();
//! [`FoyerCache`]: crate::foyer::foyer_cache::FoyerCache
        assert_eq!(total_keys, 6);
            index: HashMap::new(),
impl KeyIndexSnapshot {
        .unwrap();
                    ["data/x.parquet\x1F0-100".to_string()].into(),
        let snap = KeyIndexSnapshot {
        ));
        let keys = snapshot.index.get("data/nodes/0/file.parquet").unwrap();
        assert!(!dir.path().join(KEY_INDEX_TMP_FILENAME).exists());
            );
    }
        return Err(io::Error::new(
    Ok(())
    /// Format version. Must equal [`SNAPSHOT_VERSION`] to be accepted.
    }
        std::fs::write(dir.path().join(KEY_INDEX_TMP_FILENAME), b"y").unwrap();
        let dir = TempDir::new().unwrap();
        let map = DashMap::new();
        "version": SNAPSHOT_VERSION,
        let dir = TempDir::new().unwrap();
    #[test]
        ]);
        assert_eq!(snapshot.index.len(), 3);
    }
/// temp files from accumulating across restarts.
    /// Return an empty snapshot with the current version.
}
            index: HashMap::new(),
                dir.display()
///
                "data/b.parquet",
    #[test]
    // 1. Try the committed file.
                let mut m = HashMap::new();
/// Delete both `key_index.json` and `.key_index.json.tmp` from `dir`.
            ErrorKind::NotFound,
}
            serde_json::to_string(&snap).unwrap().as_bytes(),
            (
        assert!(!dir.path().join(KEY_INDEX_TMP_FILENAME).exists());
            serde_json::to_string(&tmp_snap).unwrap().as_bytes(),
        let snap = KeyIndexSnapshot {
///
                "data/a.parquet",
pub const SNAPSHOT_VERSION: u32 = 1;
        let dir = TempDir::new().unwrap();
        let dir = TempDir::new().unwrap();
        serde_json::from_str(contents).map_err(|e| io::Error::new(ErrorKind::InvalidData, e))?;
/// incompatibly; old files with a different version are rejected on load.
                m.insert(
                vec!["data/a.parquet\x1F0-100", "data/a.parquet\x1F100-200"],
 * this file be licensed under the Apache-2.0 license or a
///   crash where graceful shutdown (`Drop`) was not called.
    }
        let dir = TempDir::new().unwrap();
        std::fs::write(dir.path().join(KEY_INDEX_TMP_FILENAME), json.as_bytes()).unwrap();
    fn test_load_returns_not_found_for_missing_file() {
            index: {
                "[block-cache] WARNING: key_index load failed, starting empty: {} — {}",
            version: SNAPSHOT_VERSION,
    #[test]
    // Serialize directly — no intermediate HashMap copy needed.
}
    #[test]
        std::fs::write(
            parse_and_validate(&contents)
use std::io::{self, ErrorKind};
        let dir = TempDir::new().unwrap();
    // ── save + load roundtrip ─────────────────────────────────────────────────
    fn test_load_rejects_wrong_version() {
    /// Return `true` when there are no prefix buckets in this snapshot.
/// A concurrent `put()` racing with this call may or may not appear in the
use std::collections::{HashMap, HashSet};
 *
    }
        "index": key_index
            index: {
    }
/// Atomically write the key_index snapshot to `<dir>/key_index.json`.
/// `key_index.json` is always preferred: it is the last *successfully committed*
    #[test]
    if tmp_path.exists() {
                let mut m = HashMap::new();
    }
        }
    fn test_delete_is_noop_for_missing_files() {
/// Deletes `.key_index.json.tmp` after every load attempt to prevent stale
/// struct on the write path.
            serde_json::to_string(&main_snap).unwrap().as_bytes(),
//! Persistence helpers for the [`FoyerCache`] key_index.
    fn test_save_is_atomic_no_tmp_file_on_success() {
        assert!(dir.path().join(KEY_INDEX_FILENAME).exists());
        std::fs::write(
            format!(
///
                "key_index version mismatch: expected {}, got {}",
    let result = load_inner(dir);
    }
        let dir = TempDir::new().unwrap();
            Err(e) if e.kind() == ErrorKind::NotFound => {}
//! `DashMap<String, HashSet<String>>` key_index. The file lives inside the
            dir.path().join(KEY_INDEX_FILENAME),
//! The rename is atomic on POSIX filesystems. A crash between the two steps
        let dir = TempDir::new().unwrap();
pub struct KeyIndexSnapshot {
        };
 * The OpenSearch Contributors require contributions made to
    let final_path = dir.join(KEY_INDEX_FILENAME);
pub fn load_or_empty(dir: &Path) -> KeyIndexSnapshot {
    let snapshot: KeyIndexSnapshot =
//! `save()` writes to `.key_index.json.tmp` then renames to `key_index.json`.
            !dir.path().join(KEY_INDEX_TMP_FILENAME).exists(),
pub const KEY_INDEX_TMP_FILENAME: &str = ".key_index.json.tmp";
        Self {
//!
    fn test_load_cleans_up_tmp_even_when_main_succeeds() {
/// # Error handling
/// graceful-shutdown `Drop` will capture any missed keys.
/// # Load strategy
    }
                    "data/x.parquet".to_string(),
        )
        let dir = TempDir::new().unwrap();
/// Load the key_index snapshot from `<dir>/key_index.json`.
            (
            native_bridge_common::log_info!(
/// Deserialized representation of the key_index snapshot.
            keys.contains(key),
//! {"version":1,"index":{"data/shard/_0.parquet":["data/shard/_0.parquet\u001f0-4096"]}}
        Ok(contents) => return parse_and_validate(&contents),
        load(dir.path()).unwrap();
fn parse_and_validate(contents: &str) -> io::Result<KeyIndexSnapshot> {
        assert_eq!(load(dir.path()).unwrap_err().kind(), ErrorKind::InvalidData);
use dashmap::DashMap;
        match std::fs::remove_file(dir.join(name)) {
            },
        assert!(load_or_empty(dir.path()).is_empty());
//! ## File format
        let map = make_map(vec![("data/nodes/0/file.parquet", vec![key])]);
        assert!(loaded.index.contains_key("data/x.parquet"));
    let final_path = dir.join(KEY_INDEX_FILENAME);
    }
    fn test_load_prefers_main_file_over_tmp() {
/// Called by `FoyerCache::clear()` so the next startup does not bulk-load
            ErrorKind::InvalidData,
        }
    fn test_separator_in_keys_roundtrip() {
        assert!(!dir.path().join(KEY_INDEX_TMP_FILENAME).exists());
//!
    }
//! ```
/// Load the snapshot, returning an empty snapshot on any error.
//!
}
        }
//!
        for (prefix, keys) in entries {
    // ── load error cases ──────────────────────────────────────────────────────
//! ```json
    // ── delete ────────────────────────────────────────────────────────────────
///
    Ok(snapshot)
        Err(e) => return Err(e),
        let tmp_snap = KeyIndexSnapshot {
/// 3. Both absent → return `Err(NotFound)`.
    // ── .tmp fallback ─────────────────────────────────────────────────────────
            let set: HashSet<String> = keys.into_iter().map(String::from).collect();
/// - Any other error → logs WARN, returns empty. Never fails startup.
//! Provides atomic save/load/delete for a JSON snapshot of the
        assert!(
    // DashMap implements Serialize (workspace feature "serde" enabled for dashmap).
        assert!(
/// The `index` field deserializes from the JSON object produced by DashMap's
    fn test_load_uses_tmp_fallback_when_main_file_absent() {
}
            );
    match std::fs::read_to_string(&tmp_path) {
    result
        };
    }
        Err(e) if e.kind() == ErrorKind::NotFound => Err(io::Error::new(
                SNAPSHOT_VERSION, snapshot.version
//! deletes it.
        map
pub fn load(dir: &Path) -> io::Result<KeyIndexSnapshot> {
        };
        assert!(loaded.index.contains_key("main"));
        let _ = std::fs::remove_file(&tmp_path);
    #[test]
/// 2. If `key_index.json` is absent, try `.key_index.json.tmp` (fallback for
        )),
pub fn delete(dir: &Path) -> io::Result<()> {
// ── Types ─────────────────────────────────────────────────────────────────────
    #[test]
use std::path::Path;
        Err(e) if e.kind() == ErrorKind::NotFound => {}
            map.insert(prefix.to_string(), set);
    let tmp_path = dir.join(KEY_INDEX_TMP_FILENAME);
        delete(dir.path()).unwrap();
        assert!(!dir.path().join(KEY_INDEX_FILENAME).exists());
    #[test]
        let dir = TempDir::new().unwrap();
        )
#[cfg(test)]
        let json = serde_json::to_string(&snap).unwrap();
    use super::*;
/// Format version embedded in every snapshot. Bump when the schema changes
            ),
        let snapshot = load(dir.path()).unwrap();
        std::fs::write(dir.path().join(KEY_INDEX_FILENAME), b"{{not valid json}}").unwrap();
                m
///    the crash-during-rename edge case). Success → log WARN, return snapshot.
    if snapshot.version != SNAPSHOT_VERSION {
        save(dir.path(), &make_map(vec![("p", vec!["p\x1F0-1"])])).unwrap();
            ),
            ),
///
    let tmp_path = dir.join(KEY_INDEX_TMP_FILENAME);
                dir.display(),
/*
        assert_eq!(loaded.index.len(), 1);
/// Used exclusively by `load()` / `parse_and_validate()`. `save()` serializes
            KeyIndexSnapshot::empty()
        assert_eq!(load(dir.path()).unwrap_err().kind(), ErrorKind::NotFound);
/// Name of the in-progress temp file used during an atomic write.
        assert_eq!(snapshot.version, SNAPSHOT_VERSION);
            version: SNAPSHOT_VERSION,
        save(dir.path(), &map).expect("save must succeed");
/// snapshot. If both files exist, the rename completed and `.tmp` is stale.
    #[test]
    pub fn is_empty(&self) -> bool {
        std::fs::write(
/// # Cleanup
    .map_err(|e| io::Error::new(ErrorKind::InvalidData, e))?;
                e
            Ok(()) => {}
            dir.path().join(KEY_INDEX_TMP_FILENAME),
                m
        };
/// the live `DashMap` directly via `serde_json::json!` — no conversion to this
        Err(e) if e.kind() == ErrorKind::NotFound => KeyIndexSnapshot::empty(),
/// - `NotFound` → empty, silently. Normal for first-ever startup or after a
        .unwrap();
    // load() will fall back to it on the next startup.
        let loaded = load(dir.path()).expect(".tmp fallback must succeed");
    // 2. Fallback: .tmp (crash-during-rename recovery).
            },
// ── Public API ────────────────────────────────────────────────────────────────
                vec!["data/c.parquet\x1F0-4096", "data/c.parquet\x1F4096-8192"],
        assert!(!dir.path().join(KEY_INDEX_FILENAME).exists());
            br#"{"version":999,"index":{}}"#,
            ),
    fn test_load_or_empty_returns_empty_for_corrupt_json() {
///
    // Atomic write: write to .tmp then rename.
    std::fs::rename(&tmp_path, &final_path)?;
            dir.path().join(KEY_INDEX_FILENAME),
        )
    }
                "data/c.parquet",
pub fn save(dir: &Path, key_index: &DashMap<String, HashSet<String>>) -> io::Result<()> {
